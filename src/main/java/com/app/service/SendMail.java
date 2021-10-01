package com.app.service;

import java.io.File;

import org.apache.commons.lang3.CharEncoding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.app.customExceptionHandler.CustomExceptionHandler;
import com.app.dto.NotificationEmail;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class SendMail {

	@Value("${EMAIL_FROM}")
	private String from;

	@Autowired
	private JavaMailSender mailSender;

	public SendMail() {
	}

	@Async
	public void sendMail(NotificationEmail notificationEmail) {
		FileSystemResource file = new FileSystemResource(new File("./MyQRCode.png"));
		MimeMessagePreparator messagePreparator = mimeMessage -> {
			MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, CharEncoding.UTF_8);
			messageHelper.setFrom(from);
			messageHelper.setTo(notificationEmail.getRecipient());
			messageHelper.setSubject(notificationEmail.getSubject());
			messageHelper.setText(notificationEmail.getBody()+"<html><body><img src='cid:identifier1234'></body></html>",true);
			messageHelper.addInline("identifier1234", file);
			
		};
		try {
			mailSender.send(messagePreparator);
			log.info("Activation email sent!!");
		} catch (MailException e) {
			log.error("Exception occurred when sending mail", e);
			throw new CustomExceptionHandler(
					"Exception occurred when sending mail to " + notificationEmail.getRecipient());
		}
	}
}
