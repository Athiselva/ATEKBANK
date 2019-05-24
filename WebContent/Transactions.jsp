<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
body {
	background-image: url('blue.jpg');
	background-size: 100%;
	background-repeat: repeat-y;
	background-attachment: fixed;
	height: 40%;
	width: 80%;
}
</style>
<style>
#customers {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 125%;
  
}

#customers td, #customers th {
  border: 1px solid #ddd;
  padding: 8px;
}

#customers tr:nth-child(even){background-color: #f2f2f2;}
#customers tr:nth-child(odd){background-color: #f2f2f2;}
#customers tr:hover {background-color: #ddd;}

#customers tr:nth-child(even){ text-align: center;}
#customers tr:nth-child(odd){ text-align: center;}

#customers th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: center;
  background-color: #AEC3CA;
  color: white;
}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transactions</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Nunito+Sans:200,300,400,700,900">
<link rel="stylesheet" href="fonts/icomoon/style.css">

<link rel="stylesheet" href="css/magnific-popup.css">
<link rel="stylesheet" href="css/jquery-ui.css">
<link rel="stylesheet" href="css/owl.carousel.min.css">
<link rel="stylesheet" href="css/owl.theme.default.min.css">
<link rel="stylesheet" href="css/bootstrap-datepicker.css">


<link rel="stylesheet" href="fonts/flaticon/font/flaticon.css">

<link rel="stylesheet" href="css/aos.css">

<link rel="stylesheet" href="css/style2.css">
<link href="bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="bootstrap.min.js"></script>
<script src="jquery.min.js"></script>
</head>
<body>
<form method="post" action="TransactionServlet">
<br><center>
							<div class="site-navbar">
				<div class="container py-1">
					<div class="row align-items-center">&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
						<div class="col-2">
							<h1 class="mb-0 site-logo">
								<a href="Home.jsp">ATEK_BANK</a>
							</h1>
							
						</div></div></div>
							</div><br>
							<p style = "font-family:georgia,garamond,serif;font-size:30px;font-style:bold; color:white">
    &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&nbsp;&nbsp;&nbsp;     TRANSACTIONS
      </p>
							<br></center>
<table id="customers" align="center">
 <tr>
    <th>Serial Number</th>
    <th>Transaction ID</th>
    <th>Balance</th>
     <th>Transaction Amount</th>
     <th>Payee Account</th>
     <th>Date and Time</th>
     <th>MMID</th>
  
  <c:forEach var="tlist" items="${tlist}">

							 <tr>
  					
  							  
  							    
 						      <td>${tlist.id }</td>
 						      <td>${tlist.transactionID }</td>
 						      <td>${tlist.cbal }</td>
 						      <td>${tlist.amt }</td>
  							  <td>${tlist.accountnumber}</td>
                              <td>${tlist.tdate}</td>
                              <td>${tlist.mmid}</td>

							</tr>

					</c:forEach>
 
</table>

<input type="hidden" name="page" value="TRNS"><br>                            
</form>
</body>
</html>