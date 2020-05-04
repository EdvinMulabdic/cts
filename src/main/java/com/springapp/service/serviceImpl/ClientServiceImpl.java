package com.springapp.service.serviceImpl;

import com.springapp.dao.ClientDao;
import com.springapp.helpers.ClientHelper;
import com.springapp.model.Client;
import com.springapp.service.ClientService;
import com.springapp.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    ClientDao clientDao;

    @Autowired
    FileService fileService;

    public Boolean createClient(String clientName, String contactPerson,String positionInOrganization, String address,
                                String address2, String phone, String email,String webAddress, String clientPDVNumber, Boolean isTransferred) {
        return clientDao.createClient(clientName, contactPerson, positionInOrganization, address, address2, phone, email,
                webAddress, clientPDVNumber, isTransferred);
    }

    public List<Client> getAllClients() {
        return clientDao.getAllClients();
    }

    public Boolean updateClient(String clientName, String contactPerson, String positionInOrganization, String address,
                                String address2, String phone, String email, String webAddress, String clientPDVNumber,
                                ClientHelper.clientStatus clientStatus, Integer clientId) {

        Client client = findClientById(clientId);
        if(!clientName.equals(client.getClientName())) {
            fileService.updateRootFolderName(client.getClientName(), clientName);
        }
        return clientDao.updateClient(clientName, contactPerson, positionInOrganization, address, address2, phone, email,
                webAddress, clientPDVNumber, clientStatus, clientId);
    }

    public Boolean deleteClient(Integer clientId) {
        return clientDao.deleteClient(clientId);
    }

    public Client findClientById(Integer clientId) {
        return clientDao.findClientById(clientId);
    }

}
