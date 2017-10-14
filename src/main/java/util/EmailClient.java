package util;
import javax.mail.*;
import javax.mail.internet.*;

import classes.Person;

import java.util.*;
import java.io.*;


class SendEmail
{
	final String emailInfo = "EmailInfo.properties";
	Properties properties = new Properties();

	public static void main(String args[])
	{
		SendEmail sendEmail = new SendEmail();
		sendEmail.process();
	}

	private void process()
	{
		try{
			//This is required to load all the properties
			FileInputStream fileInputStream = new FileInputStream(emailInfo);
			properties.load(fileInputStream);
			fileInputStream.close();
		}catch(IOException ioe)
		{
			//throw IOException of your choice.
			//can end here
		}
		System.out.println("Email properties read successfully.");

			final List<Person> people = new ArrayList<>();
			String email = "";
			for(Person user : people) {
				if(user.getUserType() == "d") {
			 email = user.getEmail();
				}
			}

		String smtpAddress = "smtp-mail.outlook.com";
		String fromAddress = "wrongholt@student.cvtc.edu";
		String toAddress = "wrongholt@gmail.com";
		String emailSubject = "Thank you for signing up!";
		String emailBody = "You are so awesome!";

		Properties props = new Properties();
		props.put("mail.smtp.host", smtpAddress);
		props.put("mail.from", fromAddress);
		Session session = Session.getInstance(props, null);

		try
		{
			MimeMessage mimeMessage = new MimeMessage(session);
			mimeMessage.setRecipients(Message.RecipientType.TO,toAddress);
			mimeMessage.setSentDate(new Date());
			mimeMessage.setSubject(emailSubject);
			mimeMessage.setText(emailBody);
			System.out.println("Preparing email...");
			Transport.send(mimeMessage);
			System.out.println("e-mail sent.");
		}
		catch(MessagingException me)
		{
			System.out.println("e-mail send failed.");
			me.getMessage();
		}
	}
}
