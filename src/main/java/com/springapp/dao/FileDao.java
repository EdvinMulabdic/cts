package com.springapp.dao;

import com.springapp.model.Client;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;


public interface FileDao {
    Boolean saveFiles(Client client,String certificateName, String certificationDate, String firstRevisionDate, String secondRevisionDate, String revisionId, List<MultipartFile> multipartFile);

    List<File> getClientFilesByCertificateName(Client client, String certificateName, String certificationDate);

    File getFileByName(Client client, String fileName, String certificateName, String certificationDate);

    Boolean deleteAllFilesForCertificateClient(Client client,String certificateName, String certificationDate);

    Boolean createFolderForClientCertificate(Client client, String certificateName);

    void updateRootFolderName(String oldClientName, String newClientName);

}
