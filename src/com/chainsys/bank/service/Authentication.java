package com.chainsys.bank.service;

import java.sql.SQLException;

import com.chainsys.bank.dao.AuthenticationDAO;
import com.chainsys.bank.model.Bank;

public class Authentication {

	public Boolean ExecuteLogin(Bank bank) {
		AuthenticationDAO authenticationDAO = new AuthenticationDAO();
		Boolean flag = authenticationDAO.login(bank);
		return flag;
	}

	public String ExecuteGetName(Bank bank) {
		AuthenticationDAO authenticationDAO = new AuthenticationDAO();
		String name = authenticationDAO.getName(bank);
		try {
			authenticationDAO.Updatetimestamp(bank);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return name;
	}

	public String ExecuteGetId(Bank bank) {
		AuthenticationDAO authenticationDAO = new AuthenticationDAO();
		String id = authenticationDAO.getid(bank);
		return id;
	}

	public Long ExecuteGetAccountNumber(Bank bank) {
		AuthenticationDAO authenticationDAO = new AuthenticationDAO();
		Long acnum = authenticationDAO.getAccountNumber(bank);
		return acnum;
	}

	public Long ExecuteGetMMID(Bank bank) {
		AuthenticationDAO authenticationDAO = new AuthenticationDAO();
		Long mmid = authenticationDAO.getMMID(bank);
		return mmid;
	}

}
