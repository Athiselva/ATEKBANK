package com.chainsys.bank.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.chainsys.bank.dao.ProfileDAO;
import com.chainsys.bank.model.Profile;

public class MyProfile {

	public ArrayList<Profile> ExecuteViewProfile(Profile profile) {
		ProfileDAO profileDAO = new ProfileDAO();
		ArrayList<Profile> plist = new ArrayList();
		try {
			plist = profileDAO.ViewProfile(profile);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return plist;
	}

	public int ExecuteEditProfile(Profile profile) {
		int n = 0;
		ProfileDAO profileDAO = new ProfileDAO();
		try {
			n = profileDAO.EditProfile(profile);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n;
	}

}
