package edu.poly.shop.domain;

import java.io.File;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MailInfo {
	String from;
	String to;
//	String[] cc;
//	String[] bcc;
	String subject;
	String body;
//	File[] attachments;
public  MailInfo(String to, String body, String subject) {
	
	this.from ="khanhnqpd07365@fpt.edu.vn";
	this.to = to;
	this.subject = subject;
	this.body = body;
	
}
}
