package com.springapp.dao.daoImpl;

import com.springapp.dao.FileDao;
import com.springapp.helpers.Constants;
import com.springapp.helpers.FilesHelper;
import com.springapp.model.Client;
import org.apache.commons.io.FileUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;



public class FileDaoImpl implements FileDao {

    public static String root = String.valueOf((Paths.get(Constants.ROOT_PATH).toAbsolutePath()));

    @Override
    public Boolean saveFiles(Client client, String certificateName, String certificationDate, String firstRevisionDate, String secondRevisionDate, String revisionId, List<MultipartFile> multipartFile) {
        List<String> fileNames = new ArrayList<>();
        if (null != multipartFile && multipartFile.size() > 0) {
            for (MultipartFile file : multipartFile) {
                String fileName = file.getOriginalFilename();
                fileNames.add(fileName);
                String destination = "";
                if (revisionId.equals("1")) {
                    if(!firstRevisionDate.equals("")) {
                        destination = FilesHelper.getYearFromCertificationDate(firstRevisionDate);
                    }else {
                        return false;
                    }
                } else if (revisionId.equals("2")) {
                    if(!secondRevisionDate.equals("")) {
                        destination = FilesHelper.getYearFromCertificationDate(secondRevisionDate);
                    }else {
                        return false;
                    }
                } else {
                    if(!certificateName.equals("")) {
                        destination = FilesHelper.getYearFromCertificationDate(certificationDate);
                    }else {
                        return false;
                    }
                }

                File dir = new File(root + File.separator + client.getClientName() + File.separator +
                        FilesHelper.getStringWithoutColonSign(certificateName) + File.separator +
                        destination,  fileName);
                try {
                    if (!dir.exists()) {
                        dir.mkdirs();
                        file.transferTo(dir);
                    } else {
                        file.transferTo(dir);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public List<File> getClientFilesByCertificateName(Client client, String certificateName, String certificationDate) {
        try {
            List<File> filesInFolder = Files.walk(Paths.get(root + File.separator + client.getClientName() +
                    File.separator + FilesHelper.getStringWithoutColonSign(certificateName) + File.separator +
                    FilesHelper.getYearFromCertificationDate(certificationDate)).toAbsolutePath())
                    .filter(Files::isRegularFile)
                    .map(Path::toFile)
                    .collect(Collectors.toList());
            return filesInFolder;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public File getFileByName(Client client, String fileName, String certificateName, String certificationDate) {
        if (client != null) {
            File dir = new File(root + File.separator + client.getClientName() +
                    File.separator + FilesHelper.getStringWithoutColonSign(certificateName) +
                    File.separator + FilesHelper.getYearFromCertificationDate(certificationDate));
            if (dir.exists()) {
                for (File f : dir.listFiles()) {
                    if (f.isFile() && f.getName().equals(fileName))
                        return f;
                }
            }
        }
        return null;
    }

    @Override
    public Boolean deleteAllFilesForCertificateClient(Client client, String certificateName, String certificationDate) {
        File dir = new File(root + File.separator + client.getClientName() +
                File.separator + FilesHelper.getStringWithoutColonSign(certificateName) +
                File.separator + FilesHelper.getYearFromCertificationDate(certificationDate));
        if (dir.exists()) {
            try {
                FileUtils.deleteDirectory(dir);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return true;
        }
        return false;

    }

    @Override
    public Boolean createFolderForClientCertificate(Client client, String certificateName) {
        if (client != null) {
            File dir = new File(root + File.separator + client.getClientName() +
                    File.separator + FilesHelper.getStringWithoutColonSign(certificateName));
            if (!dir.exists())
                dir.mkdirs();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void updateRootFolderName(String oldClientName, String newClientName) {
        File dir = new File(root + File.separator + oldClientName);
        if (dir.exists()) {
            dir.renameTo(new File(root + File.separator + newClientName));
        }
    }

}
