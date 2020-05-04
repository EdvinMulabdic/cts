package com.springapp.controller;

import com.springapp.model.Certificate;
import com.springapp.service.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;


@Controller
public class CertificateController {
    @Autowired
    CertificateService certificateService;

    @RequestMapping(value = "/durations", method = RequestMethod.GET)
    public String certificates() {
        if (LoginController.isUserLoggedIn())
            return "certificates/certificateMain";
        return "login";
    }

    @RequestMapping(value= "/add_duration_form", method = RequestMethod.GET)
    public String createCertificateRender() {
        if (LoginController.isUserLoggedIn())
            return "certificates/createCertificate";
        return "login";
    }

    @RequestMapping(value= "/add_duration", method = RequestMethod.POST)
    public String createCertificate(@RequestParam("certificateName") String certificateName,
                                    @RequestParam("certificateDuration") String certificateDuration, Model model) {
        if(certificateService.createCertificate(certificateName,certificateDuration)) {
            model.addAttribute("success", "Certificate successfully added.");
        } else {
            model.addAttribute("error", "Certificate not added.");
        }
        if (LoginController.isUserLoggedIn())
            return "redirect:/duration_list";
        return "login";
    }

    @RequestMapping(value= "/update_duration_form", params ={"certificateId"}, method = RequestMethod.GET)
    public String updateCertificateRender(@RequestParam("certificateId") String certificateId, Model model) {
        Certificate certificate = certificateService.getCertificateById(Integer.parseInt(certificateId));
        model.addAttribute("certificate", certificate);
        if (LoginController.isUserLoggedIn())
            return "certificates/updateCertificate";
        return "login";
    }

    @RequestMapping(value= "/update_certificate", method = RequestMethod.POST)
    public String updateCertificate(@RequestParam("certificateName") String certificateName,
                                    @RequestParam("certificateDuration") String certificateDuration, HttpServletRequest request, Model model) {
        if(certificateService.updateCertificate(certificateName, certificateDuration, request.getParameter("certificateId"))) {
            model.addAttribute("success", "Certificate successfully updated.");
        } else {
            model.addAttribute("error", "Certificate not updated.");
        }
        if (LoginController.isUserLoggedIn())
            return "redirect:/duration_list";
        return "login";
    }

    @RequestMapping(value= "/duration_list", method = RequestMethod.GET)
    public String listOfCertificates(@RequestParam(value = "success", required = false) String success,
                                     @RequestParam(value = "error", required = false) String error, Model model) {
        model.addAttribute("certificates", certificateService.getAllCertificates());
        model.addAttribute("success", success);
        if (LoginController.isUserLoggedIn())
            return "certificates/listOfCertificates";
        return "login";
    }

    @RequestMapping(value= "/delete_duration",params = "certificateId", method = RequestMethod.GET)
    public String deleteCertificate(@RequestParam(value = "certificateId") String certificateId, Model model) {
        if(certificateService.deleteCertificate(certificateId)) {
            model.addAttribute("success", "Certificate successfully deleted.");
        } else {
            model.addAttribute("error", "Certificate not deleted.");
        }
        if (LoginController.isUserLoggedIn())
            return "redirect:/duration_list";
        return "login";
    }


}
