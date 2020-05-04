package com.springapp.helpers;


import com.sun.mail.smtp.SMTPTransport;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class MailHelpers {
    public static final String EMAIL_FROM = "arden.cts@gmail.com";
    public static final String EMAIL_SUBJECT = "Certificate expiration notification";
    public static final String SMTP_SERVER = "smtp.gmail.com";
    public static final String EMAIL_TO = "zlatko.maric@live.com";
    private static final String EMAIL_TEXT = "Hello Java Mail \n ABC123";
    private static final String USERNAME = "arden.cts@gmail.com";
    private static final String PASSWORD = "myznadcnsyudizqh";
    private static final int PORT = 587;

    public static void sendEmail(String mailTo, String mailMessage) {


        Properties prop = System.getProperties();
        prop.put("mail.smtp.host", SMTP_SERVER); //optional, defined in SMTPTransport
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.port", "587"); // default port 25
        prop.put("mail.smtp.starttls.enable", "true");
        prop.setProperty("mail.debug", "true");

        Session session = Session.getInstance(prop, null);
        Message msg = new MimeMessage(session);

        try {

            // from
            msg.setFrom(new InternetAddress(EMAIL_FROM));

            // to
            msg.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(mailTo, false));

            // subject
            msg.setSubject(EMAIL_SUBJECT);

            // content
            msg.setText(mailMessage);

            msg.setSentDate(new Date());

            // Get SMTPTransport
            SMTPTransport t = (SMTPTransport) session.getTransport("smtp");

            // connect
            t.connect(SMTP_SERVER, PORT, USERNAME, PASSWORD);

            // send
            t.sendMessage(msg, msg.getAllRecipients());

            System.out.println("Response: " + t.getLastServerResponse());

            t.close();

        } catch (MessagingException e) {
            e.printStackTrace();
        }




    }

}
