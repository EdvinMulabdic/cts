package com.springapp.controller;

import com.springapp.model.Client;
import com.springapp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;


@Controller
public class CertificateClientController {
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
    @Autowired
    EA9001Service ea9001Service;
    @Autowired
    EA14001Service ea14001Service;

    @RequestMapping(value = "/server_certificates", params ={"clientId"}, method = RequestMethod.GET)
    public String clientCertificates(@RequestParam(value = "success", required = false) String success,
                                     @RequestParam(value = "error", required = false) String error,
                                     @RequestParam("clientId") String clientIdString, Model model) {
        model.addAttribute("certificates",certificateClientService.getCertificatesByClientId(Integer.parseInt(clientIdString)));
        model.addAttribute("clientId",clientIdString);
        model.addAttribute("clientName", clientService.findClientById(Integer.valueOf(clientIdString)).getClientName());
        model.addAttribute("success", success);
        model.addAttribute("error", error);
        if (LoginController.isUserLoggedIn())
            return "client/clientsCertificates";
        return "login";
    }

    @RequestMapping(value = "/add_duration", method = RequestMethod.GET)
    public String addCertificateToClientRender(HttpServletRequest request, Model model) {
        String clientId = request.getParameter("clientId");
        Client client = clientService.findClientById(Integer.parseInt(clientId));
        model.addAttribute("client", client);
        model.addAttribute("certificates", certificateService.getAllCertificates());
        model.addAttribute("auditori", appUserService.getAllAuditUsers());
        model.addAttribute("ea9001", ea9001Service.getAllEACodes());
        model.addAttribute("ea14001", ea14001Service.getAllEACodes());
        if (LoginController.isUserLoggedIn())
            return "client/createCertificateClient";
        return "login";
    }

    @RequestMapping(value = "/add_server_to_client", method = RequestMethod.POST)
    public String addCertificateToClient(HttpServletRequest request, Model model) throws ParseException {
        String date = request.getParameter("certificationDate");
        String certificateNumber = request.getParameter("certificateNumber");
        Integer certificateId = Integer.parseInt(request.getParameter("certificateId"));
        Integer clientId = Integer.parseInt(request.getParameter("clientId"));
        String appUserId = request.getParameter("auditorId");
        String ea9001 = request.getParameter("ea9001Id");
        String ea14001 = request.getParameter("ea14001Id");
        Integer standardDuration;
        if(certificateClientService.getCertificateClientByCertificateNumber(certificateNumber) == null) {
            if (request.getParameter("standardDuration") != null) {
                standardDuration = Integer.parseInt(request.getParameter("standardDuration"));
            } else {
                standardDuration = 3;
            }
            Boolean isAccredited = true;
            if (request.getParameter("isAccredited").equals("true")) {
                isAccredited = true;
            } else if (request.getParameter("isAccredited").equals("false")) {
                isAccredited = false;
            }
            if (certificateClientService.createCertificateClient(clientId, certificateId, certificateNumber, date, standardDuration, appUserId, isAccredited)) {
                eaCodeAppUserService.addCodeToAppUser(appUserId, certificateId, ea9001, ea14001, clientId);

                model.addAttribute("success", "Certificate successfully added.");
                model.addAttribute("clientId", clientId);
            } else {
                model.addAttribute("error", "Certificate not added. Certificate number doesn't exist.");
                model.addAttribute("clientId", clientId);
            }
            if (LoginController.isUserLoggedIn())
                return "redirect:/server_certificates";
            return "login";
        }
        model.addAttribute("error", "Certificate not added. Certificate number already exist.");
        model.addAttribute("clientId", clientId);

        if (LoginController.isUserLoggedIn())
            return "redirect:/server_certificates";
        return "login";
    }

    @RequestMapping(value = "/updateCertificateClientForma", params = {"certificationNumber"}, method = RequestMethod.GET)
    public String openUpdateCertificateForm(@RequestParam("certificationNumber") String certificationNumber, Model model) throws ParseException {

        model.addAttribute("certificate",  certificateClientService.getCertificateClientByCertificateNumber(certificationNumber));

        if (LoginController.isUserLoggedIn())
            return "client/updateCertificateClient";
        return "login";
    }

    @RequestMapping(value = "/updateCertificateClient", method = RequestMethod.POST)
    public String updateCertificateClient(HttpServletRequest request, Model model) throws ParseException {
        Boolean isAccredited = true;
        if(request.getParameter("isAccredited").equals("true")) {
            isAccredited = true;
        } else if (request.getParameter("isAccredited").equals("false"))  {
            isAccredited = false;
        }

        String certificateNumber = request.getParameter("certificateNumber");
        String date = request.getParameter("certificationDate");
        Integer standardDuration;
        if(request.getParameter("standardDuration") != null) {
            standardDuration = Integer.parseInt(request.getParameter("standardDuration"));
        } else {
            standardDuration = 3;
        }

        String clientId = request.getParameter("clientIdHidden");

        if(certificateClientService.updateCertificateClient(isAccredited,certificateNumber, date, standardDuration)) {
            model.addAttribute("success", "Validation successfully added.");
            model.addAttribute("clientId", clientId);
        } else {
            model.addAttribute("error", "Validation adding failed.");
            model.addAttribute("clientId", clientId);
        };

        if (LoginController.isUserLoggedIn())
            return "redirect:/server_certificates";
        return "login";
    }


    @RequestMapping(value = "/createRevisionForma", params = {"certificationNumber"}, method = RequestMethod.GET)
    public String openRevisionToCertificateForm(@RequestParam("certificationNumber") String certificationNumber, Model model) throws ParseException {

        model.addAttribute("certificate",  certificateClientService.getCertificateClientByCertificateNumber(certificationNumber));

        if (LoginController.isUserLoggedIn())
            return "client/createRevison";
        return "login";
    }

    @RequestMapping(value = "/createRevision", method = RequestMethod.POST)
    public String addRevisionToCertificate(HttpServletRequest request, Model model) throws ParseException {
        String certificateNumber = request.getParameter("certificateNumber");
        String revision = request.getParameter("revisionId");
        String date = request.getParameter("revisionDate");
        String clientId = request.getParameter("clientIdHidden");

        if(certificateClientService.addRevision(certificateNumber, revision, date)) {
            model.addAttribute("success", "Validation successfully added.");
            model.addAttribute("clientId", clientId);
        } else {
            model.addAttribute("error", "Validation add failed.");
            model.addAttribute("clientId", clientId);
        };

        if (LoginController.isUserLoggedIn())
            return "redirect:/server_certificates";
        return "login";
    }

    @RequestMapping(value = "/delete_client_certificate", params = {"clientId", "certificateId"}, method = RequestMethod.GET)
    public String deleteCertificateForClient(@RequestParam("clientId") String clientIdString,
                                             @RequestParam("certificateId") String certificateIdString, Model model,
                                             @RequestParam("certificateClientId") String certificateClientId) {

        Boolean decreasedAuditsForAuditor = eaCodeAppUserService.deleteCodeForAppUser(certificateClientService.getUserWhoCertifiedClientForCertificate
                (certificateIdString, clientIdString), certificateService.getCertificateById(Integer.parseInt(certificateIdString)), clientIdString);
        
        Boolean deletedCertificateForClient =
                certificateClientService.deleteCertificateForClient(Integer.parseInt(certificateIdString), Integer.parseInt(clientIdString), Integer.parseInt(certificateClientId));

        if (deletedCertificateForClient && decreasedAuditsForAuditor) {
            model.addAttribute("success", "Certificate successfully deleted.");
            model.addAttribute("clientId", Integer.parseInt(clientIdString));
            return "redirect:/server_certificates";
            } else {
            model.addAttribute("clientId", clientIdString);

            if (LoginController.isUserLoggedIn())
                return "redirect:/server_certificates";
            return "login";
        }
    }
}

