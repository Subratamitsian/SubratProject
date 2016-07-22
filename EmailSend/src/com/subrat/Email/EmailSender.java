package com.subrat.Email;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailSender {
	
	protected String message_recip = "subratpanda@outlook.com";
	protected String message_subject = "Test Mail";
	/** The message body */
	protected String message_body ="Hello, this is a test mail.";
	protected Session session;
	protected Message mesg;
	
		public void send( ) {
			Properties props = new Properties( );
			props.put("mail.smtp.host", "smtp.gmail.com");
			/*props.put("mail.smtp.socketFactory.port", "465");  
			props.put("mail.smtp.socketFactory.class",  
			            "javax.net.ssl.SSLSocketFactory");  
			props.put("mail.smtp.auth", "true");  
			props.put("mail.smtp.port", "465"); */
			session = Session.getDefaultInstance(props, null);
			// to make it verbose
			session.setDebug(true); 
			try {
					mesg = new MimeMessage(session);
					mesg.setFrom(new InternetAddress("subratamitsian@gmail.com"));
					InternetAddress toAddress = new InternetAddress(message_recip);
					mesg.addRecipient(Message.RecipientType.TO, toAddress);
					mesg.setSubject(message_subject);
					mesg.setText(message_body);
					Transport.send(mesg);
				} 
			catch (MessagingException ex) {
				while ((ex = (MessagingException)ex.getNextException( )) != null) {
					ex.printStackTrace( );
					}
			}
		}
	public static void main(String[] av) {
	EmailSender sender = new EmailSender( );
	sender.send( );
	}

}
