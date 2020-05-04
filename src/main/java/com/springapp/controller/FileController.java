package com.springapp.controller;

import com.springapp.model.CertificateClient;
import com.springapp.model.Client;
import com.springapp.service.CertificateClientService;
import com.springapp.service.ClientService;
import com.springapp.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;


@Controller
public class FileController {
    @Autowired
    ClientService clientService;
    @Autowired
    FileService fileService;
    @Autowired
    CertificateClientService certificateClientService;

    @RequestMapping(value = "/upload_file_forma", params = {"clientId", "certificateName","certificateNumber"}, method = RequestMethod.GET)
    public String uploadFileForm(@RequestParam("clientId") String clientIdString,
                                 @RequestParam("certificateName") String certificateName,
                                 @RequestParam("certificationDate") String certificationDate,
                                 @RequestParam("firstRevisionDate") String firstRevisionDate,
                                 @RequestParam("secondRevisionDate") String secondRevisionDate,
                                 Model model) {
        model.addAttribute("client", clientService.findClientById(Integer.parseInt(clientIdString)));
        model.addAttribute("certificateName", certificateName);
        model.addAttribute("certificationDate", certificationDate);
        model.addAttribute("firstRevisionDate", firstRevisionDate);
        model.addAttribute("secondRevisionDate", secondRevisionDate);

        return "file/upload_file";
    }

    @RequestMapping(value = "/upload_file", method = RequestMethod.POST)
    public String uploadFile(@RequestParam("clientId") String clientIdString,
                             @RequestParam("certificateName") String certificateName,
                             @RequestParam("certificationDate") String certificationDate,
                             @RequestParam("firstRevisionDate") String firstRevisionDate,
                             @RequestParam("secondRevisionDate") String secondRevisionDate,
                             @RequestParam("revisionId") String revisionId,
                             HttpServletRequest request, Model model) {
        List<MultipartFile> multipartFile = ((DefaultMultipartHttpServletRequest) request).getFiles("file");
            if(fileService.saveFiles(clientIdString, certificateName, certificationDate, firstRevisionDate, secondRevisionDate, revisionId, multipartFile)) {
                model.addAttribute("success", "Document uploaded.");
                return "redirect:/server_certificates?clientId=" + clientIdString;
            }else {
                model.addAttribute("error", "Document upload failed. Did you add the certificate or engineer?");
                return "redirect:/server_certificates?clientId=" + clientIdString;
            }
    }

    @RequestMapping(value = "/dokumenti_klijenta", params = {"clientId", "certificateName", "certificationDate"}, method = RequestMethod.GET)
    public String clientFiles(@RequestParam("clientId") String clientIdString,
                              @RequestParam("certificateName") String certificateName,
                              @RequestParam("certificationDate") String certificationDate,
                              Model model) {

//        Client client = clientService.findClientById(Integer.parseInt(clientIdString));
        if(certificationDate != "" ) {
            model.addAttribute("files", fileService.getClientFilesByCertificateName(clientIdString, certificateName, certificationDate));
        }
        model.addAttribute("clientId", clientIdString);
        model.addAttribute("certificateName", certificateName);
        model.addAttribute("certificationDate", certificationDate);
//        model.addAttribute("certificate", certificateClientService.getCertificateClientByClientIdAndCertificateNumber(client.getId(), certificateName));

        return "file/listOfClientFiles";
    }

    @RequestMapping(value = "/folderi", method = RequestMethod.GET)
    public String getFolders(@RequestParam("clientId") String clientIdString,
                             @RequestParam("certificateName") String certificateName,
                             @RequestParam("certificationDate") String certificationDate,
                             @RequestParam("firstRevisionDate") String firstRevisionDate,
                             @RequestParam("secondRevisionDate") String secondRevisionDate,
                             Model model) {

        Client client = clientService.findClientById(Integer.parseInt(clientIdString));
        CertificateClient certificate = certificateClientService.getCertificateClientByClientIdAndCertificateName(Integer.parseInt(clientIdString), certificateName);

        model.addAttribute("client", client);
        model.addAttribute("certificateNam e", certificateName);
        model.addAttribute("certificationDate", certificationDate);
        model.addAttribute("firstRevisionDate", firstRevisionDate);
        model.addAttribute("secondRevisionDate", secondRevisionDate);

        model.addAttribute("certificate", certificate);

        return "file/foldersWithClientFiles";
    }

    @RequestMapping(value = "/pogledaj_dokument", params = {"clientId", "fileName", "certificateName"}, method = RequestMethod.GET)
    public void getFile (@RequestParam("clientId") String clientIdString,
                         @RequestParam("fileName") String fileName,
                         @RequestParam("certificateName") String certificateName,
                         @RequestParam("certificationDate") String certificationDate,
                         HttpServletRequest request, HttpServletResponse response) throws IOException {
        fileService.getFile(clientIdString, fileName,certificateName, certificationDate, request, response);

//        File file = fileService.getFileByName(clientIdString, fileName, certificateName);
//
//        ServletContext cntx= req.getSession().getServletContext();
//        String filename = file.getPath();
//        String mime = cntx.getMimeType(filename);
//        if (mime == null) {
//            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
//            return;
//        }
//        resp.setContentType(mime);
//        resp.setContentLength((int) file.length());
//        FileInputStream in = new FileInputStream(file);
//        OutputStream out = resp.getOutputStream();
//        byte[] buf = new byte[1024];
//        int count = 0;
//        while ((count = in.read(buf)) >= 0) {
//            out.write(buf, 0, count);
//        }
//        out.close();
//        in.close();
    }

}