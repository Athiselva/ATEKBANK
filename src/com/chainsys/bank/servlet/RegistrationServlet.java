package com.chainsys.bank.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.bank.dao.AuthenticationDAO;
import com.chainsys.bank.model.Bank;
import com.chainsys.bank.model.Profile;
import com.sun.scenario.effect.impl.prism.PrFilterContext;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Profile profile = new Profile();
		Bank bank = new Bank();
		AuthenticationDAO authenticationDAO = new AuthenticationDAO();
		bank.setName(request.getParameter("name"));
		bank.setFathersName(request.getParameter("fathersname"));
		bank.setPhonenumber(Long.parseLong(request.getParameter("phonenumber")));
		bank.setEmail(request.getParameter("email"));
		bank.setGender(request.getParameter("gender"));
		bank.setUsername(request.getParameter("username"));
		bank.setPassword(request.getParameter("password"));
		bank.setDob(LocalDate.parse(request.getParameter("dob")));
		bank.setP_Address(request.getParameter("pmtaddress"));
		bank.setP_City(request.getParameter("pmtcity"));
		bank.setC_Address(request.getParameter("cntaddress"));
		bank.setC_City(request.getParameter("cntcity"));
		bank.setState(request.getParameter("state"));
		bank.setCbal((request.getParameter("pin")));
		int n=authenticationDAO.register(bank);
		if(n==1) {
		RequestDispatcher rd = request.getRequestDispatcher("Success2.jsp");
		rd.forward(request, response);
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("SignupFailed.jsp");
			rd.forward(request, response);
		}
		
	}

}
