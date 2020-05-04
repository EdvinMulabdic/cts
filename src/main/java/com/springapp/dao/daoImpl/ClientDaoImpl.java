package com.springapp.dao.daoImpl;

import com.springapp.dao.AbstractDao;
import com.springapp.dao.ClientDao;
import com.springapp.helpers.ClientHelper;
import com.springapp.model.Client;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;


import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public class ClientDaoImpl extends AbstractDao<Integer, Client> implements ClientDao {

    public Boolean createClient(String clientName, String contactPerson,String positionInOrganization, String address, String address2, String phone, String email,String webAddress, String clientPDVNumber, Boolean isTransferred) {
        Client client = new Client();
        client.setClientName(clientName);
        client.setContactPerson(contactPerson);
        client.setPositionInOrganization(positionInOrganization);
        client.setAddress(address);
        client.setAddress2(address2);
        client.setPhone(phone);
        client.setEmail(email);
        client.setWebAddress(webAddress);
        client.setClientPDVNumber(clientPDVNumber);
        client.setActive(true);
        client.setClientStatus(ClientHelper.clientStatus.AKTIVAN);
        client.setTransferred(isTransferred);

        return persist(client);
    }

    public List<Client> getAllClients() {
        Criteria criteria = createEntityCriteria();
        return criteria.add(Restrictions.eq("isActive", true)).list();
    }

    public Boolean updateClient(String clientName, String contactPerson,String positionInOrganization, String address, String address2, String phone, String email,String webAddress, String clientPDVNumber, ClientHelper.clientStatus clientStatus, Integer clientId) {
       Client client = findClientById(clientId);

        client.setClientName(clientName);
        client.setContactPerson(contactPerson);
        client.setPositionInOrganization(positionInOrganization);
        client.setAddress(address);
        client.setAddress2(address2);
        client.setPhone(phone);
        client.setEmail(email);
        client.setWebAddress(webAddress);
        client.setClientPDVNumber(clientPDVNumber);
        client.setClientStatus(clientStatus);
      return update(client);
    }

    public Boolean deleteClient(Integer clientId) {
        Client client = findClientById(clientId);
        client.setActive(false);
       return update(client);
    }

    public Client findClientById(Integer clientId) {
        Criteria criteria = createEntityCriteria();
        Client client = (Client) criteria.add(Restrictions.eq("id", clientId)).uniqueResult();
        return client;
    }
}
