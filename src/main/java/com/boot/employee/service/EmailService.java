package com.boot.employee.service;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

@Service
public class EmailService {
	
	private String FROM_MAIL_ID = "marudhu.pandiyan@gmail.com";
	private String SMTP_SERVER_HOST = "smtp.gmail.com";
	private Integer SMTP_SERVER_PORT = 587;
	private String FROM_MAIL_PWD = "_marudhu_ui";
	private Boolean MAIL_SMTP_STARTTLS_ENABLE = true;
	private String Mail_content = "Erste registration is done succesfully . Please set your password using this link HERE";
	public boolean sendEmail(String ToEmailId) {
		
		try {
	        // Create a default MimeMessage object.
	        MimeMessage message = new MimeMessage(getSession());
	        message.setFrom(new InternetAddress(FROM_MAIL_ID));
	        message.setSentDate(new Date());
	        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(ToEmailId));
	        message.setSubject("Erste Registration Mail!");
	        message.setContent(Mail_content, "text/html");

	        // Send message
	        Transport.send(message);
	        System.out.println("Sent message successfully....");
	        return true;
	     } catch (MessagingException mex) {
	        mex.printStackTrace();
	        return false;
	     }
	}
	
	private Session getSession() {
        Properties props = new Properties();
        props.put("mail.smtp.from", FROM_MAIL_ID);
        props.put("mail.smtp.host", SMTP_SERVER_HOST);
        props.put("mail.smtp.port", SMTP_SERVER_PORT);
        props.put("mail.smtp.starttls.enable", MAIL_SMTP_STARTTLS_ENABLE);
        props.put("mail.smtp.auth", true);

        return Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(FROM_MAIL_ID, FROM_MAIL_PWD);
            }
        });
    }
}
