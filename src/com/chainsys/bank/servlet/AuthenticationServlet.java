package com.chainsys.bank.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.bank.model.Bank;
import com.chainsys.bank.service.Authentication;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/AuthenticationServlet")
public class AuthenticationServlet extends HttpServlet {
	//Logger log= Logger.getLogger(AuthenticationServlet.class);
	private static final long serialVersionUID = 1L;

	public AuthenticationServlet() {
		super();
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		//PropertyConfigurator.configure("D:\\Dev-Workspace\\Bank\\src\\log4j.properties");
		//log.debug(" ----  Invoked LoginServlet doPost method ----");
		Bank bank = new Bank();
		Authentication authentication = new Authentication();
		bank.setUsername((request.getParameter("username")).toString());
		bank.setPassword(request.getParameter("password"));
		//log.debug(" ----  username: "+ bank.getUsername());
		//log.debug(" ----  password: "+ bank.getPassword());
		if (authentication.ExecuteLogin(bank)) {
			HttpSession session = request.getSession();
			String name = authentication.ExecuteGetName(bank);
			String id = authentication.ExecuteGetId(bank);
			long acnum = authentication.ExecuteGetAccountNumber(bank);
			long mmid = authentication.ExecuteGetMMID(bank);
			session.setAttribute("username", request.getParameter("username"));
			session.setAttribute("name", name);
			session.setAttribute("id", id);
			session.setAttribute("accountnumber", acnum);
			request.setAttribute("name", name);
			request.setAttribute("mmid", mmid);
			RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
			rd.forward(request, response);

		} else {
			RequestDispatcher rd = request.getRequestDispatcher("IncorrectPassword.html");
			rd.forward(request, response);
		}
	}

}
