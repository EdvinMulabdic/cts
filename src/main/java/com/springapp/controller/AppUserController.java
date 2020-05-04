package com.springapp.controller;

import com.springapp.model.AppUser;
import com.springapp.service.AppUserService;
import com.springapp.service.EA14001Service;
import com.springapp.service.EA9001Service;
import com.springapp.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AppUserController {
    @Autowired
    AppUserService appUserService;
    @Autowired
    EA9001Service ea9001Service;
    @Autowired
    EA14001Service ea14001Service;
    @Autowired
    RoleService roleService;

    @RequestMapping(value= "/engineer_dashboard", method = RequestMethod.GET)
    public String personsMain() {
        return "users/usersMain";
    }

    @RequestMapping(value = "/add_engineer_form", method = RequestMethod.GET)
    public String createAppUserRender(Model model) {
        model.addAttribute("ea9001", ea9001Service.getAllEACodes());
        model.addAttribute("ea14001", ea14001Service.getAllEACodes());
        model.addAttribute("userAccess", roleService.getAllRoles());
        return "users/createUser";
    }

    @RequestMapping(value = "/add_engineer", method = RequestMethod.POST)
    public String createUser(@RequestParam("name") String name, @RequestParam("address") String address,
                             @RequestParam("city") String city, @RequestParam("email") String email, @RequestParam("phone") String phone,
                             @RequestParam("qualifications") String qualifications, @RequestParam("role") String role,
                             @RequestParam("password") String password, @RequestParam("ea9001") String ea9001, @RequestParam("ea14001") String ea14001,
                             Model model) {
        String[] ea9001Id = new String[0];
        String[] ea14001Id = new String[0];
        if(ea9001 != "") {
            ea9001Id = ea9001.split(",");
        }
        if(ea14001 != "") {
            ea14001Id = ea14001.split(",");
        }
        if (appUserService.createUser(name, address, city, email, phone, qualifications, role, password, ea9001Id, ea14001Id)) {
            model.addAttribute("success", "Engineer successfully added.");
            return "redirect:/engineer_list";
        } else {
            model.addAttribute("error", "Engineer adding failed!");
            return "redirect:/add_engineer_form";
        }
    }

    @RequestMapping(value = "/delete_engineer", params = "userId", method = RequestMethod.GET)
    public String deleteAppUser(@RequestParam("userId") String userId, Model model) {
        if (appUserService.deleteUser(Integer.parseInt(userId))) {
            model.addAttribute("success", "Engineer successfully deleted." );
        } else {
            model.addAttribute("error", "Engineer deletion failed!");
        }
        return "redirect:/engineer_list";
    }

    @RequestMapping(value = "/update_engineer_form", params ={"appUserId"}, method = RequestMethod.GET)
    public String updateAppUserRender(@RequestParam("appUserId") String appUserId, Model model) {
        AppUser appUser = appUserService.getUserById(appUserId);
        model.addAttribute("user", appUser);
        model.addAttribute("ea9001", ea9001Service.getAllEACodes());
        model.addAttribute("ea14001", ea14001Service.getAllEACodes());
        model.addAttribute("userAccess", roleService.getAllRoles());
        return "users/updateUser";
    }

    @RequestMapping(value= "/update_engineer", method = RequestMethod.POST)
    public String updateCertificate(@RequestParam("name") String name, @RequestParam("address") String address,
                                    @RequestParam("city") String city, @RequestParam("email") String email, @RequestParam("phone") String phone,
                                    @RequestParam("qualifications") String qualifications, @RequestParam("role") String role,
                                    @RequestParam("password") String password, HttpServletRequest request,  @RequestParam("ea9001") String ea9001, @RequestParam("ea14001") String ea14001,
                                    Model model) {
        String[] ea9001Id = new String[0];
        String[] ea14001Id = new String[0];
        if(ea9001 != "") {
            ea9001Id = ea9001.split(",");
        }
        if(ea14001 != "") {
            ea14001Id = ea14001.split(",");
        }
        if (appUserService.updateUser(name, address, city, email, phone, qualifications, role, password, ea9001Id, ea14001Id, request.getParameter("appUserId"))) {
            model.addAttribute("success", "Engineer successfully updated.");
        } else {
            model.addAttribute("error", "Engineer update failed.");
        }
        return "redirect:/engineer_list";
    }

    @RequestMapping(value = "/engineer_list", method = RequestMethod.GET)
    public String listOfPersonsRender(@RequestParam(value = "success", required = false) String success,
                                      @RequestParam(value = "error", required = false) String error, Model model) {
        model.addAttribute("users", appUserService.getAllUsers());
            model.addAttribute("success", success);
        model.addAttribute("error", error);
        return "users/listOfUsers";
    }

    @RequestMapping(value = "/ea9001_table", method = RequestMethod.GET)
    public String ea9001Table(Model model) {
        model.addAttribute("ea9001", ea9001Service.getAllEACodes());
        model.addAttribute("appUsers", appUserService.getAllUsers());
        return "ea_schema/ea9001";
    }

    @RequestMapping(value = "/ea14001_table", method = RequestMethod.GET)
    public String ea14001Table(Model model) {
        model.addAttribute("ea14001", ea14001Service.getAllEACodes());
        model.addAttribute("appUsers", appUserService.getAllUsers());
        return "ea_schema/ea14001";
    }
}
