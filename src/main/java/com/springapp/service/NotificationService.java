package com.springapp.service;

import com.springapp.model.CertificateClient;
import com.springapp.model.Client;

import java.util.List;
import java.util.Map;


public interface NotificationService {
    void sendEmails();
    List<Client> listOfClientsWithSentEmails();
    Map<Client, CertificateClient> sendEmail3Months();
    Map<Client, CertificateClient> sendEmail6Months();
    Map<Client, CertificateClient> sendEmail1Year();
}
