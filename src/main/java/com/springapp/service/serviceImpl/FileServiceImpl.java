package com.springapp.service.serviceImpl;

import com.springapp.dao.FileDao;
import com.springapp.model.Client;
import com.springapp.service.ClientService;
import com.springapp.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;


public class FileServiceImpl implements FileService {
    @Autowired
    FileDao fileDao;
    @Autowired
    ClientService clientService;

    @Override
    public Boolean saveFiles(String clientIdString,String certificateName, String certificationDate, String firstRevisionDate, String secondRevisionDate, String revisionId, List<MultipartFile> multipartFile) {
        return fileDao.saveFiles(clientService.findClientById(Integer.parseInt(clientIdString)), certificateName, certificationDate,firstRevisionDate, secondRevisionDate, revisionId, multipartFile);
    }

    @Override
    public List<File> getClientFilesByCertificateName(String clientIdString, String certificateName, String certificationDate) {
        return fileDao.getClientFilesByCertificateName(clientService.findClientById(Integer.parseInt(clientIdString)), certificateName, certificationDate);
    }

    @Override
    public void getFile(String clientIdString, String fileName, String certificateName, String certificationDate, HttpServletRequest request, HttpServletResponse response) {
        File file = getFileByName(clientIdString, fileName, certificateName, certificationDate);

        ServletContext cntx= request.getSession().getServletContext();
        String filename = file.getPath();
        String mime = cntx.getMimeType(filename);
        if (mime == null) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return;
        }
        response.setContentType(mime);
        response.setContentLength((int) file.length());
        response.setHeader("content-disposition", "filename=" + fileName);
        FileInputStream in = null;
        try {
            in = new FileInputStream(file);
            OutputStream out = response.getOutputStream();
            byte[] buf = new byte[1024];
            int count = 0;
            while ((count = in.read(buf)) >= 0) {
                out.write(buf, 0, count);
            }
            out.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Boolean createFolderForClientCertificate(Client client, String certificateName) {
        return fileDao.createFolderForClientCertificate(client, certificateName);
    }

    @Override
    public Boolean deleteAllFilesForCertificateClient(Client client, String certificateName, String certificationDate) {
        return fileDao.deleteAllFilesForCertificateClient(client, certificateName, certificationDate);
    }

    @Override
    public void updateRootFolderName(String oldClientName, String newClientName) {
        fileDao.updateRootFolderName(oldClientName, newClientName);
    }

    private File getFileByName(String clientIdString, String fileName, String certificateName, String certificationDate) {
        return fileDao.getFileByName(clientService.findClientById(Integer.parseInt(clientIdString)), fileName, certificateName, certificationDate);
    }
}
