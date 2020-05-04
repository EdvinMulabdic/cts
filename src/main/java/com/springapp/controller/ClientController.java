package com.springapp.controller;

import com.springapp.helpers.ClientHelper;
import com.springapp.model.Client;
import com.springapp.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.ParseException;


@Controller
public class ClientController {
    @Autowired
    ClientService clientService;

    @RequestMapping(value= "/server_dashboard", method = RequestMethod.GET)
    public String personsMain() {
        if (LoginController.isUserLoggedIn())
            return "client/clientMain";
        return "login";
    }

    @RequestMapping(value = "/add_server_form", method = RequestMethod.GET)
    public String createPersonsRender() {
        if (LoginController.isUserLoggedIn())
            return "client/createClient";
        return "login";
    }

    @RequestMapping(value = "/add_server", method = RequestMethod.POST)
    public String createPerson(@RequestParam("clientName") String clientName, @RequestParam("contactPerson") String contactPerson,
                               @RequestParam("positionInOrganization") String positionInOrganization, @RequestParam("address") String address,
                               @RequestParam("address2") String address2, @RequestParam("phone") String phone, @RequestParam("email") String email,
                               @RequestParam("webAddress") String webAddress, @RequestParam("clientPDVNumber") String clientPDVNumber,
                                HttpServletRequest request, Model model) {

        String isTransferred = request.getParameter("isTransferred");
        Boolean prelaznik = false;
        if(isTransferred != null) {
            prelaznik = isTransferred.equals("on");
        }
        if(clientService.createClient(clientName, contactPerson, positionInOrganization, address, address2, phone, email, webAddress, clientPDVNumber, prelaznik)) {
            model.addAttribute("success", "Server successfully added.");
            if (LoginController.isUserLoggedIn())
                return "redirect:/server_list";
            return "login";
        } else {
            model.addAttribute("error", "Server adding failed!");
            if (LoginController.isUserLoggedIn())
                return "redirect:/add_server_form";
            return "login";
        }
    }

    @RequestMapping(value = "/server_list", method = RequestMethod.GET)
    public String listOfPersonsRender(@RequestParam(value = "success", required = false) String success,
                                      @RequestParam(value = "error", required = false) String error, Model model) {
        model.addAttribute("clients", clientService.getAllClients());
        model.addAttribute("success", success);
        model.addAttribute("error", error);
        if (LoginController.isUserLoggedIn())
            return "client/listOfClients";
        return "login";
    }

    @RequestMapping(value = "/update_server_form", params ={"clientId"} ,method = RequestMethod.GET)
    public String updateClientRender(@RequestParam("clientId") String clientId, Model model) {
        Integer clientIdd = Integer.valueOf(clientId);
        Client client = clientService.findClientById(clientIdd);
        model.addAttribute("client", client);
        if (LoginController.isUserLoggedIn())
            return "client/updateClient";
        return "login";
    }

    @RequestMapping(value = "/update_server", method = RequestMethod.POST)
    public String  updateClient(@RequestParam("clientName") String clientName, @RequestParam("contactPerson") String contactPerson,
                                @RequestParam("positionInOrganization") String positionInOrganization, @RequestParam("address") String address,
                                @RequestParam("address2") String address2, @RequestParam("phone") String phone, @RequestParam("email") String email,
                                @RequestParam("webAddress") String webAddress, @RequestParam("clientPDVNumber") String clientPDVNumber,
                                @RequestParam("clientStatus") ClientHelper.clientStatus clientStatus, HttpServletRequest request, Model model)
                throws ParseException, IOException {

        Integer clientId = Integer.parseInt(request.getParameter("clientId"));

        if(clientService.updateClient(clientName, contactPerson, positionInOrganization, address, address2, phone, email, webAddress, clientPDVNumber, clientStatus, clientId)) {
            model.addAttribute("success", "Server succesfully updated.");
        } else {
            model.addAttribute("error", "Server update failed!");
        }
        if (LoginController.isUserLoggedIn())
            return "redirect:/server_list";
        return "login";
    }

    @RequestMapping(value = "/delete_server",params = "clientId", method = RequestMethod.GET)
    public String deleteClient(@RequestParam("clientId") String clientId, Model model) {
        if(clientService.deleteClient(Integer.parseInt(clientId))) {
            model.addAttribute("success", "Server successfully deleted." );
        } else {
            model.addAttribute("error", "Server deletion failed!");
        }
        if (LoginController.isUserLoggedIn())
            return "redirect:/server_list";
        return "login";
    }

}
