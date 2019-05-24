package com.chainsys.bank.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.chainsys.bank.dao.BankDAO;
import com.chainsys.bank.model.Bank;

public class MyTransactions {

	public ArrayList<Bank> ExecuteTransactionList(Bank bank) {
		BankDAO bankDAO = new BankDAO();
		ArrayList<Bank> tlist = new ArrayList();
		try {
			tlist = bankDAO.Transactions(bank);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return tlist;
	}

}
