package com.chainsys.bank.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

import com.chainsys.bank.model.Bank;
import com.chainsys.bank.model.Payee;
import com.chainsys.bank.util.ConnectionUtil;

public class BankDAO {
	/**
	 * 
	 * @param bank
	 * @returns Balance
	 */
	public BigDecimal balanceEnquiry(Bank bank) {
		try {
			Connection connection = ConnectionUtil.getConnection();
			String sql2 = "select Balance from trn_customers where username=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql2);
			preparedStatement.setString(1, bank.getUsername());
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				bank.setBalance(resultSet.getBigDecimal("balance"));
			}
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to get Balance");
		}
		return bank.getBalance();
	}

	public int IMPSTransfer(Payee payee) {
		int r1 = 0, r2 = 0, r3 = 0, r4 = 0, r5 = 0, r6 = 0;
		try {
			Connection connection = ConnectionUtil.getConnection();
			String sql4 = "select balance from trn_customers where mmid=?";
			PreparedStatement preparedStatement4 = connection.prepareStatement(sql4);
			preparedStatement4.setLong(1, payee.getPayee_mmid());
			r4 = preparedStatement4.executeUpdate();
			if (r4 != 0) {
				String sql5 = "update trn_customers set balance=balance+? where mmid=? and phone_number=?";
				PreparedStatement preparedStatement5 = connection.prepareStatement(sql5);
				preparedStatement5.setBigDecimal(1, payee.getAmount());
				preparedStatement5.setLong(2, payee.getPayee_mmid());
				preparedStatement5.setLong(3, payee.getPayee_phonenumber());
				r5 = preparedStatement5.executeUpdate();
				preparedStatement5.close();
			}

			if (r5 == 0) {
				String sql2 = "insert into trn_payee(account_number,payee_name,transaction_id,ifsc_code,mmid,remarks,balance,transaction_DATE,com_date,count)\r\n"
						+ "values(?,?,Trn_payee_transid_seq03.nextval,?,?,?,?,?,?,?)";
				PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
				preparedStatement2.setLong(1, payee.getAccountnumber());
				preparedStatement2.setString(2, payee.getPayee_name());
				preparedStatement2.setString(3, payee.getPayee_ifsc());
				preparedStatement2.setLong(4, payee.getPayee_mmid());
				preparedStatement2.setString(5, payee.getRemarks());
				preparedStatement2.setBigDecimal(6, payee.getAmount());
				preparedStatement2.setTimestamp(7, Timestamp.valueOf(LocalDateTime.now()));
				preparedStatement2.setTimestamp(8, Timestamp.valueOf(LocalDateTime.now()));
				preparedStatement2.setBigDecimal(9, payee.getCount());
				r2 = preparedStatement2.executeUpdate();
				preparedStatement2.close();
			}

			String sql3 = "insert into TRN_TRNSC_LIST(customer_id,transaction_id,current_balance,amount,mmid,transaction_date)values(?,Trn_translist_transid_seq03.nextval,?,?,?,?)";
			PreparedStatement preparedStatement3 = connection.prepareStatement(sql3);
			preparedStatement3.setString(1, payee.getId());
			preparedStatement3.setBigDecimal(2, payee.getBalance());
			preparedStatement3.setBigDecimal(3, payee.getAmount());
			preparedStatement3.setLong(4, payee.getPayee_mmid());
			preparedStatement3.setTimestamp(5, Timestamp.valueOf(LocalDateTime.now()));
			r3 = preparedStatement3.executeUpdate();
			preparedStatement3.close();

			String sql1 = "update trn_customers set balance=?, IMPSCOUNT=IMPSCOUNT+?,TOTALCOUNT=TOTALCOUNT+? where account_number=?";
			PreparedStatement preparedStatement1 = connection.prepareStatement(sql1);
			preparedStatement1.setBigDecimal(1, payee.getBalance());
			preparedStatement1.setBigDecimal(2, payee.getAmount());
			preparedStatement1.setBigDecimal(3, payee.getAmount());
			preparedStatement1.setLong(4, payee.getAccountnumber());
			r1 = preparedStatement1.executeUpdate();
			ConnectionUtil.close(connection, preparedStatement1, null);
			ConnectionUtil.close(connection, preparedStatement3, null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (r1 + r2 + r3 + r4 + r5);
	}

	public int NEFTTransfer(Payee payee) {
		int r1 = 0, r2 = 0, r3 = 0, r4 = 0, r5 = 0, r6 = 0, r7 = 0;
		try {
			Connection connection = ConnectionUtil.getConnection();
			String sql4 = "select balance from trn_customers where account_number=?";
			PreparedStatement preparedStatement4 = connection.prepareStatement(sql4);
			preparedStatement4.setLong(1, payee.getAccountnumber());
			r4 = preparedStatement4.executeUpdate();
			if (r4 != 0) {
				String sql5 = "update trn_customers set balance=balance+? where account_number=? and ifsc_code=?";
				PreparedStatement preparedStatement5 = connection.prepareStatement(sql5);
				preparedStatement5.setBigDecimal(1, payee.getAmount());
				preparedStatement5.setLong(2, payee.getPayee_accountnumber());
				preparedStatement5.setString(3, payee.getPayee_ifsc());
				r5 = preparedStatement5.executeUpdate();
				preparedStatement5.close();
			}
			if (r5 == 0) {
				String sql6 = "select balance from trn_payee where account_number=?";
				PreparedStatement preparedStatement6 = connection.prepareStatement(sql6);
				preparedStatement6.setLong(1, payee.getPayee_accountnumber());
				r6 = preparedStatement6.executeUpdate();
				preparedStatement6.close();
				if (r6 != 0) {
					String sql7 = "update trn_payee set balance=balance+? where account_number=?";
					PreparedStatement preparedStatement7 = connection.prepareStatement(sql7);
					preparedStatement7.setBigDecimal(1, payee.getAmount());
					preparedStatement7.setLong(2, payee.getPayee_accountnumber());
					r7 = preparedStatement7.executeUpdate();
					preparedStatement7.close();

				}
			}

			if (r6 == 0) {
				String sql2 = "insert into trn_payee(account_number,payee_name,transaction_id,ifsc_code,mmid,remarks,balance,transaction_DATE,com_date,count)\r\n"
						+ "values(?,?,Trn_payee_transid_seq03.nextval,?,?,?,?,?,?,?)";
				PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
				preparedStatement2.setLong(1, payee.getAccountnumber());
				preparedStatement2.setString(2, payee.getPayee_name());
				preparedStatement2.setString(3, payee.getPayee_ifsc());
				preparedStatement2.setLong(4, payee.getPayee_mmid());
				preparedStatement2.setString(5, payee.getRemarks());
				preparedStatement2.setBigDecimal(6, payee.getAmount());
				preparedStatement2.setTimestamp(7, Timestamp.valueOf(LocalDateTime.now()));
				preparedStatement2.setTimestamp(8, Timestamp.valueOf(LocalDateTime.now()));
				preparedStatement2.setBigDecimal(9, payee.getCount());
				r2 = preparedStatement2.executeUpdate();
				preparedStatement2.close();
			}

			String sql3 = "insert into TRN_TRNSC_LIST(customer_id,transaction_id,current_balance,amount,mmid,transaction_date,benf_ac_number)values(?,Trn_translist_transid_seq03.nextval,?,?,?,?,?)";
			PreparedStatement preparedStatement3 = connection.prepareStatement(sql3);
			preparedStatement3.setString(1, payee.getId());
			preparedStatement3.setBigDecimal(2, payee.getBalance());
			preparedStatement3.setBigDecimal(3, payee.getAmount());
			preparedStatement3.setLong(4, payee.getPayee_mmid());
			preparedStatement3.setTimestamp(5, Timestamp.valueOf(LocalDateTime.now()));
			preparedStatement3.setLong(6, payee.getPayee_accountnumber());
			r3 = preparedStatement3.executeUpdate();
			preparedStatement3.close();

			String sql1 = "update trn_customers set balance=balance-?, NEFTCOUNT=NEFTCOUNT+?,TOTALCOUNT=TOTALCOUNT+? where account_number=?";
			PreparedStatement preparedStatement1 = connection.prepareStatement(sql1);
			preparedStatement1.setBigDecimal(1, payee.getAmount());
			preparedStatement1.setBigDecimal(2, payee.getAmount());
			preparedStatement1.setBigDecimal(3, payee.getAmount());
			preparedStatement1.setLong(4, payee.getAccountnumber());
			r1 = preparedStatement1.executeUpdate();
			ConnectionUtil.close(connection, preparedStatement1, null);
			ConnectionUtil.close(connection, preparedStatement3, null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (r1 + r2 + r3);

	}

	int n = 0;

	public ArrayList<Bank> Transactions(Bank bank) throws SQLException {
		ArrayList<Bank> tlist = new ArrayList();
		Connection connection = ConnectionUtil.getConnection();
		String sql = "select customer_id,transaction_id,current_balance,amount,benf_ac_number,transaction_date,mmid from trn_trnsc_list where customer_id=? order by transaction_id desc";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, Integer.parseInt(bank.getId()));

		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			Bank bank2 = new Bank();
			n = n + 1;
			bank2.setId(Integer.toString(n));
			bank2.setTransactionID(Long.parseLong(resultSet.getString("transaction_id")));
			bank2.setCbal((resultSet.getBigDecimal("current_balance").toString()));
			bank2.setAmt(resultSet.getBigDecimal("amount").toString());
			bank2.setAccountnumber(resultSet.getLong("benf_ac_number"));
			bank2.setTdate(resultSet.getTimestamp("transaction_date").toString());
			bank2.setMmid(resultSet.getLong("mmid"));
			tlist.add(bank2);
		}
		ConnectionUtil.close(connection, preparedStatement, resultSet);
		return tlist;
	}

	public ArrayList<Bank> LastTransaction(Bank bank) throws SQLException {
		ArrayList<Bank> tlist = new ArrayList();
		Connection connection = ConnectionUtil.getConnection();
		String sql = "select *from (select transaction_id,current_balance,amount,benf_ac_number,transaction_date,mmid FROM trn_trnsc_list order by transaction_id desc) where ROWNUM < 2";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			Bank bank2 = new Bank();

			bank2.setTransactionID(Long.parseLong(resultSet.getString("transaction_id")));
			bank2.setCbal((resultSet.getBigDecimal("current_balance").toString()));
			bank2.setAmt(resultSet.getBigDecimal("amount").toString());
			bank2.setAccountnumber(resultSet.getLong("benf_ac_number"));
			bank2.setTdate(resultSet.getTimestamp("transaction_date").toString());
			bank2.setMmid(resultSet.getLong("mmid"));
			tlist.add(bank2);
		}
		ConnectionUtil.close(connection, preparedStatement, resultSet);
		return tlist;
	}
	
	public Long GetIMPSCount(Payee payee) throws SQLException {
	Connection connection = ConnectionUtil.getConnection();
	String sql = "select impscount from trn_customers where account_number=?";
	PreparedStatement preparedStatement = connection.prepareStatement(sql);
	preparedStatement.setLong(1, payee.getAccountnumber());
	ResultSet resultSet = preparedStatement.executeQuery();
	while (resultSet.next()) {
		payee.setImpscount((resultSet.getLong("impscount"))); 
	}
	ConnectionUtil.close(connection, preparedStatement, resultSet);
	return payee.getImpscount();
	}
	
	public Long GetNEFTCount(Payee payee) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "select neftcount from trn_customers where account_number=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setLong(1, payee.getAccountnumber());
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			payee.setNeftcount((resultSet.getLong("neftcount"))); 
		}
		ConnectionUtil.close(connection, preparedStatement, resultSet);
		return payee.getNeftcount();
		}
	
	public Long GetTotalCount(Payee payee) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "select totalcount from trn_customers where account_number=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setLong(1, payee.getAccountnumber());
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			payee.setTotalcount((resultSet.getLong("totalcount"))); 
		}
		ConnectionUtil.close(connection, preparedStatement, resultSet);
		return payee.getTotalcount();
		}

}
