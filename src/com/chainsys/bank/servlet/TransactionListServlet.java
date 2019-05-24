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

import com.chainsys.bank.model.Bank;
import com.chainsys.bank.service.MyTransactions;

/**
 * Servlet implementation class TransactionListServlet
 */
@WebServlet("/TransactionListServlet")
public class TransactionListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TransactionListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Bank> tlist = new ArrayList<Bank>();
		Bank bank = new Bank();
		HttpSession session = request.getSession();
		request.setAttribute("name", ((String) session.getAttribute("name")));
		String mmid = ((String) session.getAttribute("mmid"));
		String id = (String) session.getAttribute("id");
		String acnum = ((session.getAttribute("accountnumber").toString()));
		bank.setId(id);
		bank.setMmid2((mmid));
		bank.setAcnumber(acnum);

		MyTransactions myTransactions = new MyTransactions();
		tlist = myTransactions.ExecuteTransactionList(bank);
		request.setAttribute("tlist", tlist);
		RequestDispatcher rd = request.getRequestDispatcher("Transactions.jsp");
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
