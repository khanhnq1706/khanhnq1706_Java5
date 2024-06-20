package edu.poly.shop.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	private int customerId;
	private String name;
	private String password;
	private String email;
	private String phone;
	private String photo;
	private Date registedDate;
	private short status;
}
