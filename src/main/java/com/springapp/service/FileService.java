package com.springapp.service;

import com.springapp.model.Client;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;


public interface FileService {
    Boolean saveFiles(String clientIdString,String certificateName, String certificationDate, String firstRevisionDate, String secondRevisionDate, String revisionId, List<MultipartFile> multipartFile);
    List<File> getClientFilesByCertificateName(String clientIdString, String certificateName, String certificationDate);
    void getFile (String clientIdString, String fileName, String certificateName, String certificationDate, HttpServletRequest request, HttpServletResponse response);
    Boolean createFolderForClientCertificate(Client client, String certificateName);
    Boolean deleteAllFilesForCertificateClient(Client client,String certificateName, String certificationDate);
    void updateRootFolderName(String oldClientName, String newClientName);
}
