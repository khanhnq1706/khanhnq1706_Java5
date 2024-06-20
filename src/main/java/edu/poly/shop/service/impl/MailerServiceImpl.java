package edu.poly.shop.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import edu.poly.shop.domain.MailInfo;
import edu.poly.shop.service.MailerService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
@Service
public class MailerServiceImpl implements MailerService{
	@Autowired
	public  JavaMailSender sender ;
	List<MimeMessage> queue = new ArrayList<>();
	@Override
	public  void push(String to, String body, String subject) throws MessagingException {
		MailInfo mail = new MailInfo();
		this.push(mail);
		
	}
	@Override
	public void push(MailInfo mail) throws MessagingException {
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, false, "utf-8");
		
		helper.setFrom("khanhnqpd07365@fpt.edu.vn");
		helper.setTo(mail.getTo());
		helper.setSubject(mail.getSubject());
		helper.setText(mail.getBody(),true);
		helper.setReplyTo(mail.getFrom());
//		for (String email  : mail.getCc()) {
//			helper.addCc(email);
//		}
//		for (String email  : mail.getBcc()) {
//			helper.addBcc(email);
//		}
//		for (File file  : mail.getAttachments()) {
//			helper.addAttachment(file.getName(), file);
//		}
		queue.add(message);
	}
	@Override
	@Scheduled(fixedDelay = 100)
	public  void run() {
		int succsess = 0;
		int error =0;
	while (!queue.isEmpty()) {
		MimeMessage message = queue.remove(0);
		try {
			sender.send(message);
			succsess ++;
		} catch (Exception e) {
			e.printStackTrace();
		error ++;
		}
	}
	System.out.printf(">> Sent: %d, Error: %d\r\n", succsess, error);;
	}
}
