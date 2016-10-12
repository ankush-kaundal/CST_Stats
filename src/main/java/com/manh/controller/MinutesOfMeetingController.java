package com.manh.controller;

import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.validation.Valid;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.manh.model.MoM;
import com.manh.model.User;

@Controller
public class MinutesOfMeetingController {

	private static final String MINUTES_OF_MEETING_PAGE = "MinutesOfMeeting";
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(MinutesOfMeetingController.class);
	
	@RequestMapping(value = "/minutesOfMeeting", method = RequestMethod.GET)
	public String navidateToMinutesOfMeetingPage(@Valid @ModelAttribute("minutesOfMeetingPage") User userForm,
	    BindingResult result, Map<String, Object> model) { 
		return MINUTES_OF_MEETING_PAGE;
	}
	
	@RequestMapping(value = "/submitMoM", method = RequestMethod.GET)
	public String submitMoM(@Valid @ModelAttribute("minutesOfMeetingPage") MoM mom,
	    BindingResult result, Map<String, Object> model) throws UnsupportedEncodingException { 
		
		
		final String from = "sacgupta@manh.com";
		final String to = "sacgupta@manh.com";
		final String password = "Computing_1";
		final String subject = "CST_Stats";
		final String mailMessage = mom.getMomMessage();
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "outlook.office365.com");
		props.put("mail.smtp.port", "587");
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
			}
		});
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject(subject);
			message.setText(mailMessage);
			Transport.send(message);
			System.out.println("Mail sent...");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		return MINUTES_OF_MEETING_PAGE;
	}
	
	
}
