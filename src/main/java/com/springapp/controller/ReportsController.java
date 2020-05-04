package com.springapp.controller;

import com.springapp.model.Certificate;
import com.springapp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Controller
public class ReportsController {
    @Autowired
    ClientService clientService;
    @Autowired
    CertificateService certificateService;
    @Autowired
    CertificateClientService certificateClientService;
    @Autowired
    AppUserService appUserService;
    @Autowired
    EACodeAppUserService eaCodeAppUserService;

    @RequestMapping(value= "/report_dashboard", method = RequestMethod.GET)
    public String reportsPanel() {
        if (LoginController.isUserLoggedIn())
            return "reports/reportsPanel";
        return "login";
    }

    @RequestMapping(value= "/server_number", method = RequestMethod.GET)
    public String statistic(Model model) {
        model.addAttribute("datum", new Date());
        model.addAttribute("brojKlijenata", clientService.getAllClients().size());
        if (LoginController.isUserLoggedIn())
            return "reports/statistic";
        return "login";
    }

    @RequestMapping(value= "/certificate_duration_search", method = RequestMethod.GET)
    public String clientStandard(Model model) {
        model.addAttribute("standards", certificateService.getAllCertificates());
        if (LoginController.isUserLoggedIn())
            return "reports/clients_standard";
        return "login";
    }

    @RequestMapping(value= "/certificate_duration_search_result", method = RequestMethod.GET)
    public String clientStandardTable(@RequestParam("standard") String standard,
                                      @RequestParam("isAccredited") String isAccredited,
                                      Model model) {
        Boolean accredited = true;
        if(("isAccredited").equals("true")) {
            accredited = true;
        }else if (("isAccredited").equals("false"))  {
            accredited = false;
        }
        model.addAttribute("clients", certificateClientService.getClientsByCertificateId(Integer.parseInt(standard), accredited));
        model.addAttribute("standard", certificateService.getCertificateById(Integer.parseInt(standard)));
        if (LoginController.isUserLoggedIn())
            return "reports/clients_standard_table";
        return "login";
    }

    @RequestMapping(value= "/engineer_search_report", method = RequestMethod.GET)
    public String auditorReports(Model model) {
        model.addAttribute("auditori", appUserService.getAllAuditUsers());
        if (LoginController.isUserLoggedIn())
            return "reports/auditori_report_panel";
        return "login";
    }

    @RequestMapping(value= "/engineer_search_results", method = RequestMethod.GET)
    public String auditorReportTable(@RequestParam("auditor") String appUserId, Model model) {
        model.addAttribute("appUserStatistic", eaCodeAppUserService.getAllEACodesForAppUserStatistic(appUserId));
        model.addAttribute("appUser", appUserService.getUserById(appUserId));
        if (LoginController.isUserLoggedIn())
            return "reports/auditori_report_table";
        return "login";
    }

}
