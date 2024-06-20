package edu.poly.shop.service.impl;

import org.springframework.stereotype.Service;

import edu.poly.shop.repository.AccountRepository;
@Service
public class AccountServiceImpl {
AccountRepository accountRepository1;
public AccountServiceImpl(AccountRepository accountRepository) {
	this.accountRepository1 = accountRepository;
}
}
