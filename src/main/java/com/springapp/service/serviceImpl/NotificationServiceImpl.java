package com.springapp.service.serviceImpl;

import com.springapp.helpers.Constants;
import com.springapp.helpers.MailHelpers;
import com.springapp.model.CertificateClient;
import com.springapp.model.Client;
import com.springapp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;


@Service
public class NotificationServiceImpl implements NotificationService {
    @Autowired
    ClientService clientService;
    @Autowired
    CertificateClientService certificateClientService;

    protected static Integer sentMails = 0;
    List<Client> clientsWithSentMail = new ArrayList<>();
    Map<Client, CertificateClient> clientsCertificates1year = new HashMap<>();
    Map<Client, CertificateClient> clientsCertificates6months = new HashMap<>();
    Map<Client, CertificateClient> clientsCertificates3months = new HashMap<>();



    public void sendEmails() {
        List<Client> clientList = clientService.getAllClients();

        List<CertificateClient> certificateClientList = certificateClientService.getAllCertificateClient();

        Date currentDate = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat(Constants.DATE_PATTERN);
        Calendar cal = Calendar.getInstance();
        cal.setTime(currentDate);
        currentDate = cal.getTime();

        Date certificateExpirationDate1year;
        Date certificateExpirationDate6months;
        Date certificateExpirationDate3months;

        Calendar cal1year = Calendar.getInstance();
        Calendar cal3months = Calendar.getInstance();
        Calendar cal6months = Calendar.getInstance();


        for (int i = 0; i < clientList.size(); i++) {
            for (int j = 0; j < certificateClientList.size(); j++) {
                cal1year.setTime(certificateClientList.get(j).getExpirationDate());
                cal1year.add(Calendar.YEAR, -1);

                cal6months.setTime(certificateClientList.get(j).getExpirationDate());
                cal6months.add(Calendar.MONTH, -6);

                cal3months.setTime(certificateClientList.get(j).getExpirationDate());
                cal3months.add(Calendar.MONTH, -3);

                certificateExpirationDate1year = cal1year.getTime();
                certificateExpirationDate6months = cal6months.getTime();
                certificateExpirationDate3months = cal3months.getTime();

                if (clientList.get(i).getId().equals(certificateClientList.get(j).getClient().getId()) &&
                        (formatter.format(certificateExpirationDate1year).equals(formatter.format(currentDate)))) {
                    clientsCertificates1year.put(clientList.get(i), certificateClientList.get(j));
                }
                if(clientList.get(i).getId().equals(certificateClientList.get(j).getClient().getId()) &&
                        (formatter.format(certificateExpirationDate6months).equals(formatter.format(currentDate)))) {
                    clientsCertificates6months.put(clientList.get(i),certificateClientList.get(j));
                }
                if (clientList.get(i).getId().equals(certificateClientList.get(j).getClient().getId()) &&
                        (formatter.format(certificateExpirationDate3months).equals(formatter.format(currentDate)))) {
                    clientsCertificates3months.put(clientList.get(i), certificateClientList.get(j));
                }
            }
        }

        sendAllEmails();

//        sendEmail1Year();
//        sendEmail6Months(clientsCertificates6months);
//        sendEmail3Months(clientsCertificates3months);

    }
    @Override
    public Map<Client, CertificateClient>  sendEmail1Year() {
        return clientsCertificates1year;
    }
    @Override
    public Map<Client, CertificateClient> sendEmail6Months() {
        return clientsCertificates6months;
    }

    @Override
    public Map<Client, CertificateClient> sendEmail3Months() {
        return clientsCertificates3months;
    }

    private void sendAllEmails() {
        // send emails for 3 months
        for (Map.Entry<Client, CertificateClient> entry : clientsCertificates3months.entrySet()) {
            String mailMessage = "Certificate for server " + entry.getKey().getClientName()
                    + " expires in three months on date " + entry.getValue().getExpirationDate()
                    + ". Responsible engineer is " + entry.getValue().getAppUser().getName() + ".";
            MailHelpers.sendEmail(entry.getValue().getAppUser().getEmail(), mailMessage);
            clientsWithSentMail.add(entry.getKey());
        }

        // send emails for 6 months
        for (Map.Entry<Client, CertificateClient> entry : clientsCertificates6months.entrySet()) {
            String mailMessage = "Certificate for server " + entry.getKey().getClientName()
                    + " expires in six months on date " + entry.getValue().getExpirationDate()
                    + ". Responsible engineer is " + entry.getValue().getAppUser().getName() + ".";
            MailHelpers.sendEmail(entry.getValue().getAppUser().getEmail(), mailMessage);
            clientsWithSentMail.add(entry.getKey());
        }

        // send emails for 12 months
        for (Map.Entry<Client, CertificateClient> entry : clientsCertificates1year.entrySet()) {
            String mailMessage = "Certificate for server " + entry.getKey().getClientName()
                    + " expires in one year on date " + entry.getValue().getExpirationDate()
                    + ". Responsible engineer is " + entry.getValue().getAppUser().getName() + ".";
            MailHelpers.sendEmail(entry.getValue().getAppUser().getEmail(), mailMessage);
            clientsWithSentMail.add(entry.getKey());
        }
    }

    public static Integer numberOfSentMails(){
        return  sentMails;
    }

    @Override
    public List<Client> listOfClientsWithSentEmails() {
        return clientsWithSentMail;
    }

}
