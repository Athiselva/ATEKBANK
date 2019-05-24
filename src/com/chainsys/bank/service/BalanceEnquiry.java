package com.chainsys.bank.service;

import java.math.BigDecimal;

import com.chainsys.bank.dao.BankDAO;
import com.chainsys.bank.model.Bank;

public class BalanceEnquiry {

	public BigDecimal ExecuteBalanceEnquiry(Bank bank) {
		BigDecimal balance;
		BankDAO bankDAO = new BankDAO();
		balance = bankDAO.balanceEnquiry(bank);
		return balance;
	}
}
