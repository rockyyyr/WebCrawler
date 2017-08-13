package com.webcrawler.email;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.webcrawler.application.KeywordMatch;

public class EmailAlert {

	private static final String SENDER_EMAIL = "rockyrobson@hotmail.com";
	private static final String HOST = "localhost";
	private static final String SUBJECT_LINE = "Keyword Alert";

	private Address[] recipients;
	private List<KeywordMatch> matches;

	public EmailAlert(List<String> recipients, List<KeywordMatch> matches) {
		this.recipients = getRecipients(recipients);
		this.matches = matches;
	}

	public boolean sendAlert() {
		boolean success = false;

		Properties properties = getProperties();
		MimeMessage message = createMessage(Session.getDefaultInstance(properties));

		try {
			Transport.send(message);
			success = true;
		} catch (MessagingException e) {
			e.printStackTrace();
		}

		return success;
	}

	private Properties getProperties() {
		Properties properties = System.getProperties();

		properties.setProperty("mail.smtp.host", HOST);

		return properties;
	}

	private MimeMessage createMessage(Session session) {
		MimeMessage message = new MimeMessage(session);
		String emailBody = EmailMessage.buildMessage(matches);

		try {
			message.setFrom(new InternetAddress(SENDER_EMAIL));
			message.addRecipients(Message.RecipientType.TO, recipients);
			message.setSubject(SUBJECT_LINE);
			message.setContent(emailBody, "text/html");

		} catch (MessagingException e) {
			e.printStackTrace();
		}

		return message;
	}

	private Address[] getRecipients(List<String> recipients) {
		return recipients.stream().map(s -> createAddress(s)).toArray(Address[]::new);
	}

	private static Address createAddress(String address) {
		Address internetAddress = null;

		try {
			internetAddress = new InternetAddress(address);

		} catch (AddressException e) {
			e.printStackTrace();
		}

		return internetAddress;
	}

}
