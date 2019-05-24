package com.chainsys.bank.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.bank.dao.BankDAO;
import com.chainsys.bank.model.Bank;
import com.chainsys.bank.model.Payee;
import com.chainsys.bank.service.BalanceEnquiry;
import com.chainsys.bank.service.FundTransfer;
import com.sun.xml.internal.ws.message.PayloadElementSniffer;

/**
 * Servlet implementation class TransactionServlet
 */
@WebServlet("/TransactionServlet")
public class TransactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TransactionServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("name");
		String username = (String) session.getAttribute("username");
		Bank bank = new Bank();
		bank.setUsername(username);
		BalanceEnquiry executeBalanceEnquiry = new BalanceEnquiry();
		BigDecimal balance = executeBalanceEnquiry.ExecuteBalanceEnquiry(bank);
		request.setAttribute("balance", balance);
		RequestDispatcher rd = request.getRequestDispatcher("Balance_Enquiry.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String page = request.getParameter("page");
		if (page.equals("BE")) {
			HttpSession session = request.getSession();
			String name = (String) session.getAttribute("name");
			String username = (String) session.getAttribute("username");
			Bank bank = new Bank();
			bank.setUsername(username);
			BalanceEnquiry balanceEnquiry = new BalanceEnquiry();
			BigDecimal balance = balanceEnquiry.ExecuteBalanceEnquiry(bank);
			request.setAttribute("balance", balance);
			RequestDispatcher rd = request.getRequestDispatcher("Balance_Enquiry.jsp");
			rd.forward(request, response);
		}

		else if (page.equals("MMID")) {
			HttpSession session = request.getSession();
			request.setAttribute("name", ((String) session.getAttribute("name")));
			String id = (String) session.getAttribute("id");
			Bank bank = new Bank();
			bank.setUsername((String) session.getAttribute("username"));
			Long acnum = ((Long) session.getAttribute("accountnumber"));
			BalanceEnquiry balanceEnquiry = new BalanceEnquiry();
			BigDecimal bal = balanceEnquiry.ExecuteBalanceEnquiry(bank);
			BigDecimal amount = new BigDecimal(request.getParameter("amount"));
			Payee payee = new Payee();
			payee.setPayee_phonenumber(Long.parseLong(request.getParameter("phonenumber")));
			payee.setPayee_mmid(Long.parseLong(request.getParameter("mmid")));
			payee.setRemarks(request.getParameter("remarks"));
			int n = (bal.compareTo(amount));
			if (n > 0 || n == 0) {
				payee.setBalance(bal.subtract(amount));
				payee.setAccountnumber(acnum);
				payee.setPayee_phonenumber((Long.parseLong(request.getParameter("phonenumber"))));
				payee.setPayee_mmid(Long.parseLong(request.getParameter("mmid")));
				payee.setAmount(amount);
				payee.setRemarks((String) request.getParameter("remarks"));
				payee.setId(id);
				FundTransfer fundTransfer2 = new FundTransfer();
				try {
					payee.setImpscount(fundTransfer2.ExecuteGetImpsCount(payee));
					payee.setTotalcount(fundTransfer2.ExecuteGetTotalCount(payee));
				} catch (SQLException e) {
					e.printStackTrace();
				}
				Long impscount=(payee.getAmount()).longValue() + payee.getImpscount();
				Long totalcount=(payee.getAmount()).longValue() + payee.getTotalcount();
				Long i=(long) 50000;
				Long j=(long) 100000;
				if(impscount<=i && totalcount<=j) {
				FundTransfer fundTransfer = new FundTransfer();
				int s = fundTransfer.ExecuteIMPS(payee);
				if (s == 4 || s == 3) {
					List<Bank> tlist = new ArrayList<Bank>();
					String name = (String) session.getAttribute("name");
					String accountnumber = (session.getAttribute("accountnumber")).toString();
					request.setAttribute("name", name);
					request.setAttribute("acnumber", accountnumber);

					tlist = fundTransfer.ExecuteLastTransaction(bank);
					request.setAttribute("tlist", tlist);
					RequestDispatcher rd = request.getRequestDispatcher("TransactionStatusMMID.jsp");
					rd.forward(request, response);
				} else {
					RequestDispatcher rd = request.getRequestDispatcher("IMPS.jsp");
					rd.forward(request, response);
				}
				}
				else
				{
					RequestDispatcher rd = request.getRequestDispatcher("Tfailed.jsp");
					rd.forward(request, response);
				}
			}
		} else if (page.equals("NEFT")) {
			HttpSession session = request.getSession();
			request.setAttribute("name", ((String) session.getAttribute("name")));
			String id = (String) session.getAttribute("id");
			String bname = request.getParameter("name");
			request.setAttribute("bname", bname);
			String bacnum = (request.getParameter("accountnumber"));
			request.setAttribute("bacnum", bacnum);

			Bank bank = new Bank();
			bank.setUsername((String) session.getAttribute("username"));
			Long acnum = ((Long) session.getAttribute("accountnumber"));
			String ifsc = request.getParameter("ifsc");
			request.setAttribute("ifsc", ifsc);
			request.setAttribute("acnum", acnum);
			BalanceEnquiry balanceEnquiry = new BalanceEnquiry();
			BigDecimal bal = balanceEnquiry.ExecuteBalanceEnquiry(bank);
			BigDecimal amount = new BigDecimal(request.getParameter("amount"));
			Payee payee = new Payee();
			int n = (bal.compareTo(amount));
			if (n > 0 || n == 0) {
				payee.setBalance(bal.subtract(amount));
				payee.setAccountnumber(acnum);
				payee.setPayee_accountnumber(Long.parseLong(request.getParameter("accountnumber")));
				payee.setPayee_name(request.getParameter("name"));
				payee.setPayee_ifsc(request.getParameter("ifsc"));
				payee.setAmount(amount);
				payee.setRemarks((String) request.getParameter("remarks"));
				payee.setId(id);
				FundTransfer fundTransfer2 = new FundTransfer();
				try {
					payee.setNeftcount(fundTransfer2.ExecuteGetNeftCount(payee));
					payee.setTotalcount(fundTransfer2.ExecuteGetTotalCount(payee));
				} catch (SQLException e) {
					e.printStackTrace();
				}
				Long neftcount=(payee.getAmount()).longValue() + payee.getNeftcount();
				Long totalcount=(payee.getAmount()).longValue() + payee.getTotalcount();
				Long i=(long) 50000;
				Long j=(long) 100000;
				if(neftcount<=i && totalcount<=j) {
				FundTransfer fundTransfer = new FundTransfer();
				int s = fundTransfer.ExecuteNEFT(payee);
				if (s == 3) {
					List<Bank> tlist = new ArrayList<Bank>();
					tlist = fundTransfer.ExecuteLastTransaction(bank);
					request.setAttribute("tlist", tlist);

					RequestDispatcher rd = request.getRequestDispatcher("TransactionStatus.jsp");
					rd.forward(request, response);
				} else {
					RequestDispatcher rd = request.getRequestDispatcher("NEFT.jsp");
					rd.forward(request, response);
				}
				}
				else
				{
					RequestDispatcher rd = request.getRequestDispatcher("Tfailed.jsp");
					rd.forward(request, response);
				}
			}
		}

	}

}
