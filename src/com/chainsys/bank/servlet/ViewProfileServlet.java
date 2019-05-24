package com.chainsys.bank.servlet;

import java.io.IOException;
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
 * Servlet implementation class ViewProfileServlet
 */
@WebServlet("/ViewProfileServlet")
public class ViewProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewProfileServlet() {
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
		RequestDispatcher rd = request.getRequestDispatcher("ViewProfile.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
