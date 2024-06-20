package edu.poly.shop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;

import edu.poly.shop.domain.MailInfo;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

public interface MailerService {

	void run();

	void push(MailInfo mail) throws MessagingException;

	void push(String to, String body, String subject) throws MessagingException;



}
