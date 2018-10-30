package com.boot.employee.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

@Service
public class EmailService {
	
	public boolean sendEmail(String ToEmailId) {
		
		// Assuming you are sending email from localhost
	      String host = "localhost";
	      String username = "marudhu.pandiyan@itcinfotech.com";
	      String password = "pandi@123";
	      // Get system properties
	      Properties properties = System.getProperties();
	    //  properties.setProperty("mail.user", username);
	      // Setup mail server
	     // properties.setProperty("mail.smtp.host", host);

	      // Get the default Session object.
	      Session session = Session.getDefaultInstance(properties);
	      
		try {
	        // Create a default MimeMessage object.
	        MimeMessage message = new MimeMessage(session);

	        // Set From: header field of the header.
	        message.setFrom(new InternetAddress(username));

	        // Set To: header field of the header.
	        message.addRecipient(Message.RecipientType.TO, new InternetAddress(ToEmailId));

	        // Set Subject: header field
	        message.setSubject("Erste Registration Mail!");

	        // Now set the actual message
	        message.setText("Erste registration is done succesfully . Please set your password using this link HERE");

	        // Send message
	        Transport t = session.getTransport("smtps");
	        try {
	            t.connect(host, username, password);
	            t.sendMessage(message, message.getAllRecipients());
	        } finally {
	            t.close();
	        }
	        System.out.println("Sent message successfully....");
	        return true;
	     } catch (MessagingException mex) {
	        mex.printStackTrace();
	        return false;
	     }
	}
	
}
