package com.chainsys.bank.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.chainsys.bank.model.Profile;
import com.chainsys.bank.util.ConnectionUtil;

public class ProfileDAO {

	public ArrayList<Profile> ViewProfile(Profile profile) throws SQLException {
		ArrayList<Profile> plist = new ArrayList();
		Connection connection = ConnectionUtil.getConnection();
		String sql = "select account_number,customer_name,customer_id,email,phone_number,fathers_name,gender,balance,username,password,dob,permanent_address,\r\n"
				+ "permanent_city,current_address,current_city,state,ifsc_code,created_date,modified_date,mmid from trn_customers where customer_id=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setLong(1, (profile.getId()));

		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			Profile profile2 = new Profile();
			profile2.setAcnumber(resultSet.getLong("account_number"));
			profile2.setName(resultSet.getString("customer_name"));
			profile2.setId(resultSet.getLong("customer_id"));
			profile2.setEmail(resultSet.getString("email"));
			profile2.setPhonenumber(resultSet.getLong("phone_number"));
			profile2.setFathersname(resultSet.getString("fathers_name"));
			profile2.setGender(resultSet.getString("gender"));
			profile2.setBalance(resultSet.getBigDecimal("balance"));
			profile2.setUsername(resultSet.getString("username"));
			profile2.setPassword(resultSet.getString("password"));
			profile2.setDob(resultSet.getDate("dob").toLocalDate());
			profile2.setPmtaddress(resultSet.getString("permanent_address"));
			profile2.setPmtcity(resultSet.getString("permanent_city"));
			profile2.setCntaddress(resultSet.getString("current_address"));
			profile2.setCntcity(resultSet.getString("current_city"));
			profile2.setState(resultSet.getString("state"));
			profile2.setIfsc(resultSet.getString("ifsc_code"));
			profile2.setCdate((resultSet.getTimestamp("created_date").toLocalDateTime()));
			profile2.setMdate((resultSet.getTimestamp("modified_date")).toLocalDateTime());
			profile2.setMmid(resultSet.getString("mmid"));

			plist.add(profile2);
		}
		ConnectionUtil.close(connection, preparedStatement, resultSet);
		return plist;

	}

	public int EditProfile(Profile profile) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "update trn_customers set customer_name=?,email=?,phone_number=?,fathers_name=?,username=?,password=?,dob=?,permanent_address=?,permanent_city=?,current_Address=?,current_city=?,state=? where customer_id=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, (profile.getName()));
		preparedStatement.setString(2, profile.getEmail());
		preparedStatement.setLong(3, profile.getPhonenumber());
		preparedStatement.setString(4, profile.getFathersname());
		preparedStatement.setString(5, profile.getUsername());
		preparedStatement.setString(6, profile.getPassword());
		preparedStatement.setDate(7, Date.valueOf(profile.getDob()));
		preparedStatement.setString(8, profile.getPmtaddress());
		preparedStatement.setString(9, profile.getPmtcity());
		preparedStatement.setString(10, profile.getCntaddress());
		preparedStatement.setString(11, profile.getCntcity());
		preparedStatement.setString(12, profile.getState());
		preparedStatement.setLong(13, profile.getId());
		int n = preparedStatement.executeUpdate();
		preparedStatement.close();
		return n;
	}
}
