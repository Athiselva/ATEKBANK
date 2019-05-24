package com.chainsys.bank.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.chainsys.bank.dao.BankDAO;
import com.chainsys.bank.model.Bank;
import com.chainsys.bank.model.Payee;

public class FundTransfer {

	public int ExecuteIMPS(Payee payee) {
		BankDAO bankDAO = new BankDAO();
		int n = bankDAO.IMPSTransfer(payee);
		return n;
	}

	public int ExecuteNEFT(Payee payee) {
		BankDAO bankDAO = new BankDAO();
		int n = bankDAO.NEFTTransfer(payee);
		return n;
	}
	
	public Long ExecuteGetImpsCount(Payee payee) throws SQLException {
		BankDAO bankDAO = new BankDAO();
		Long n=bankDAO.GetIMPSCount(payee);
		return n;
	}
	
	public Long ExecuteGetNeftCount(Payee payee) throws SQLException {
		BankDAO bankDAO = new BankDAO();
		Long n=bankDAO.GetNEFTCount(payee);
		return n;
	}
	
	public Long ExecuteGetTotalCount(Payee payee) throws SQLException {
		BankDAO bankDAO = new BankDAO();
		Long n=bankDAO.GetTotalCount(payee);
		return n;
	}
	

	public ArrayList<Bank> ExecuteLastTransaction(Bank bank) {
		BankDAO bankDAO = new BankDAO();
		ArrayList<Bank> tlist = new ArrayList();
		try {
			tlist = bankDAO.LastTransaction(bank);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return tlist;
	}

}
