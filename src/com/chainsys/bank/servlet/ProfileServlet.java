package com.chainsys.bank.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.bank.model.Profile;
import com.chainsys.bank.service.MyProfile;

/**
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProfileServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Profile> plist = new ArrayList<Profile>();
		Profile profile = new Profile();
		HttpSession session = request.getSession();
		request.setAttribute("name", ((String) session.getAttribute("name")));
		Long id = Long.parseLong((String) session.getAttribute("id"));
		profile.setId(id);

		MyProfile myProfile = new MyProfile();
		plist = myProfile.ExecuteViewProfile(profile);
		request.setAttribute("plist", plist);
		RequestDispatcher rd = request.getRequestDispatcher("EditProfile.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Profile profile = new Profile();
		HttpSession session = request.getSession();
		request.setAttribute("name", ((String) session.getAttribute("name")));
		Long id = Long.parseLong((String) session.getAttribute("id"));
		profile.setName(request.getParameter("name"));
		profile.setFathersname(request.getParameter("fathersname"));
		profile.setPhonenumber(Long.parseLong(request.getParameter("phonenumber")));
		profile.setEmail(request.getParameter("email"));
		profile.setUsername(request.getParameter("username"));
		profile.setPassword(request.getParameter("password"));
		profile.setDob(LocalDate.parse(request.getParameter("dob")));
		profile.setPmtaddress(request.getParameter("pmtaddress"));
		profile.setPmtcity(request.getParameter("pmtcity"));
		profile.setCntaddress(request.getParameter("cntaddress"));
		profile.setCntcity(request.getParameter("cntcity"));
		profile.setState(request.getParameter("state"));
		profile.setId(id);
		int n = 0;
		MyProfile myProfile = new MyProfile();
		n = myProfile.ExecuteEditProfile(profile);
		if (n == 1) {
			RequestDispatcher rd = request.getRequestDispatcher("Sucess3.jsp");
			rd.forward(request, response);

		} else {
			RequestDispatcher rd = request.getRequestDispatcher("EditProfile.jsp");
			rd.forward(request, response);
		}

	}

}
