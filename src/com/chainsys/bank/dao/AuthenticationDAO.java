package com.chainsys.bank.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.LinkedList;

import com.chainsys.bank.model.Bank;
import com.chainsys.bank.util.ConnectionUtil;

public class AuthenticationDAO {

	public Boolean login(Bank bank) {
		try {
			Connection connection = ConnectionUtil.getConnection();
			String sql = "select username,password from trn_customers where username=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, bank.getUsername());
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				if (resultSet.getString("username").equals(bank.getUsername())
						&& resultSet.getString("password").equals(bank.getPassword())) {
					bank.setFlag(true);
				} else {
					bank.setFlag(false);
				}
			}
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to Login");
		}
		return bank.isFlag();

	}

	public String getName(Bank bank) {
		try {
			Connection connection = ConnectionUtil.getConnection();
			String sql2 = "select customer_name from trn_customers where username=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql2);
			preparedStatement.setString(1, bank.getUsername());
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				bank.setName(resultSet.getString("customer_name"));
			}
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to get the Customer Name");
		}
		return bank.getName();
	}

	public Long getAccountNumber(Bank bank) {
		try {
			Connection connection = ConnectionUtil.getConnection();
			String sql2 = "select account_number from trn_customers where username=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql2);
			preparedStatement.setString(1, bank.getUsername());
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				bank.setAccountnumber(resultSet.getLong("account_number"));
			}
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to get the Customer Name");
		}
		return bank.getAccountnumber();
	}

	public String getid(Bank bank) {
		try {
			Connection connection = ConnectionUtil.getConnection();
			String sql2 = "select customer_id from trn_customers where username=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql2);
			preparedStatement.setString(1, bank.getUsername());
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				bank.setId(resultSet.getString("customer_id"));
			}
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to get the Customer Name");
		}
		return bank.getId();
	}

	public Long getMMID(Bank bank) {
		try {
			Connection connection = ConnectionUtil.getConnection();
			String sql2 = "select mmid from trn_customers where username=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql2);
			preparedStatement.setString(1, bank.getUsername());
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				bank.setMmid(resultSet.getLong("mmid"));
			}
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to get the Customer Name");
		}
		return bank.getAccountnumber();
	}
	
	public String getIFSC(Bank bank) throws SQLException {
		String s=null;
		Connection connection = ConnectionUtil.getConnection();
		String sql2 = "select ifsc_code from trn_ifsc where current_city=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql2);
		preparedStatement.setString(1, bank.getIfsc());
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			s=(resultSet.getString("ifsc_code"));
		}
		ConnectionUtil.close(connection, preparedStatement, resultSet);
		return s;
	}
	
	public void Updatetimestamp(Bank bank) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		String sql2="update trn_customers set modified_date=? where username=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql2);
		preparedStatement.setTimestamp(1, Timestamp.valueOf(LocalDateTime.now()));
		preparedStatement.setString(2, bank.getUsername());
		preparedStatement.executeUpdate();
		ConnectionUtil.close(connection, preparedStatement,null);
	}

	public int register(Bank bank) {
		Connection connection = ConnectionUtil.getConnection();
		String sql2 ="insert into trn_customers (ACCOUNT_NUMBER,CUSTOMER_NAME,CUSTOMER_ID,EMAIL,PHONE_NUMBER,FATHERS_NAME,GENDER,USERNAME,PASSWORD,DOB,\r\n" + 
				"PERMANENT_ADDRESS,PERMANENT_CITY,CURRENT_ADDRESS,CURRENT_CITY,STATE,FLAG,CREATED_DATE,MODIFIED_DATE,MMID,ifsc_code)\r\n" + 
				"values(Trn_customers_acnum_seq02.nextval,?,Trn_customers_cusid_seq01.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,trn_customers_mmid_seq03.nextval,?)";
		PreparedStatement preparedStatement;
		int n=0;
		try {
			preparedStatement = connection.prepareStatement(sql2);
			preparedStatement.setString(1, bank.getName());
			preparedStatement.setString(2, bank.getEmail());
			preparedStatement.setLong(3, bank.getPhonenumber());
			preparedStatement.setString(4, bank.getFathersName());
			preparedStatement.setString(5, bank.getGender());
			preparedStatement.setString(6, bank.getUsername());
			preparedStatement.setString(7, bank.getPassword());
			preparedStatement.setDate(8, Date.valueOf(bank.getDob()));
			preparedStatement.setString(9, bank.getP_Address());
			preparedStatement.setString(10, bank.getP_City());
			preparedStatement.setString(11, bank.getC_Address());
			preparedStatement.setString(12, bank.getC_City());
			preparedStatement.setString(13, bank.getState());
			preparedStatement.setString(14,bank.getCbal());
			preparedStatement.setTimestamp(15, Timestamp.valueOf(LocalDateTime.now()));
			preparedStatement.setTimestamp(16, Timestamp.valueOf(LocalDateTime.now()));
			preparedStatement.setString(17, "ATEK000134");
			n = preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return n;
	}
}
