package com.springapp.controller;

import com.springapp.helpers.UserAccessHelper;
import com.springapp.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.sql.SQLException;


@Controller
@Transactional

public class LoginController {
    @Autowired
    AppUserService appUserService;
    @Autowired
    UserAccessHelper userAccessHelper;

    private static Boolean isLoggedIn = false;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String homepage() {
        isLoggedIn = false;
        return "login";
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String mainPage() {
        if (isLoggedIn)
            return "main";
        return "login";
    }

    @RequestMapping(value= "/login_access", method = RequestMethod.POST)
    public String adminLogin(@RequestParam("email") String email,
                                   @RequestParam("password") String password, Model model) throws SQLException {
        String authenticate = appUserService.authenticate(email, password);
        if (authenticate.equals(userAccessHelper.adminAccess())) {
            isLoggedIn = true;
            return "redirect:/main";
        } else if (authenticate.equals(userAccessHelper.userAccess())) {
            isLoggedIn = true;
            return "redirect:/main";
        } else if(authenticate.equals(userAccessHelper.unauthorized())) {
            model.addAttribute("error", "Incorrect username or password");
            return "login";
        }
        return "login";
    }

    public static Boolean isUserLoggedIn() {
        return isLoggedIn;
    }
}
