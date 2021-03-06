package com.springapp.service;

import com.springapp.helpers.ClientHelper;
import com.springapp.model.Client;

import java.util.List;


public interface ClientService {
    Boolean createClient(String clientName, String contactPerson,String positionInOrganization, String address, String address2, String phone, String email,String webAddress, String clientPDVNumber, Boolean isTransferred);
    List<Client> getAllClients();
    Boolean updateClient(String clientName, String contactPerson, String positionInOrganization, String address, String address2, String phone, String email, String webAddress, String clientPDVNumber, ClientHelper.clientStatus clientStatus, Integer clientId);
    Boolean deleteClient(Integer clientId);
    Client findClientById(Integer clientId);
}
