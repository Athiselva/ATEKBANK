<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
.button {
  background-color: #4CAF50; /* Green */
  border: none;
  color: grey;
  padding: 0px 0px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 0px 0px;
  -webkit-transition-duration: 0.3s; /* Safari */
  transition-duration: 0.5s;
  cursor: pointer;
}

.button1 {
  background-color: white; 
  color: black; 
  border: 2px solid #4CAF50;
}

.button1:hover {
  background-color: #4CAF50;
  color: white;
}

.button2 {
  background-color: white; 
  color: black; 
  border: 2px solid #008CBA;
}

.button2:hover {
  background-color: #008CBA;
  color: white;
}

.button3 {
  background-color: white; 
  color: black; 
  border: 2px solid #f44336;
}

.button3:hover {
  background-color: #f44336;
  color: white;
}

.button4 {
  background-color: lightblue;
  color: black;
  border: 2px solid #e7e7e7;
}

.button4:hover {background-color: #B5B2B2;}

.button5 {
  background-color: white;
  color: black;
  border: 2px solid #555555;
}

.button5:hover {
  background-color: #555555;
  color: white;
}
</style>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fund Transfer</title>
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
<!-- jquery -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>

</head>
<body>

	<div class="site-wrap">

		<div class="site-mobile-menu">
			<div class="site-mobile-menu-header">
				<div class="site-mobile-menu-close mt-3">
					<span class="icon-close2 js-menu-toggle"></span>
				</div>
			</div>
			<div class="site-mobile-menu-body"></div>
		</div>
		<!-- .site-mobile-menu -->


		<div class="site-navbar-wrap">
			<div class="site-navbar-top">
				<div class="container py-3">
					<div class="row align-items-center">
						<div class="col-6">
							<a href="#" class="p-2 pl-0"><span class="icon-twitter"></span></a>
							<a href="#" class="p-2 pl-0"><span class="icon-facebook"></span></a>
							<a href="#" class="p-2 pl-0"><span class="icon-linkedin"></span></a>
							<a href="#" class="p-2 pl-0"><span class="icon-instagram"></span></a>
						</div>
						<div class="col-6">
							<div class="d-flex ml-auto">
								<a href="#" class="d-flex align-items-center ml-auto mr-4">
									<span class="icon-phone mr-2"></span> <span
									class="d-none d-md-inline-block">+91 8072025050</span>
								</a> <a href="#" class="d-flex align-items-center"> <span
									class="icon-envelope mr-2"></span> <span
									class="d-none d-md-inline-block">atekbank@rediffmail.com</span>
								</a>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="site-navbar">
				<div class="container py-1">
					<div class="row align-items-center">
						<div class="col-2">
							<h1 class="mb-0 site-logo">
								<a href="Home.jsp">ATEK_BANK</a>
							</h1>
						</div>
						&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
						&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
						
							
						
					</div>
					</div><br><br><br><center>
					<form action="TransactionServlet" method="post">
					<font size="+6" font color="white">
							Dear&nbsp;
							${name}
							</font><br>
					<button class="button button4">Click here to Check Balance</button>
					<input type="hidden" name="page" value="BE"><br>
				</div>
			
		</div>
		 
		<div class="site-blocks-cover overlay"
			style="background-image: url(images/hero_bg_1.jpg);" data-aos="fade"
			data-stellar-background-ratio="0.5">
			<div class="container">
				<div
					class="row align-items-center text-center justify-content-center">
					<div class="col-md-8">
							
			</div>
		</div>
		
				
	

		<div class="site-block-1">
			<div class="container">
				<div class="row">
					<div class="col-lg-4">
						
					</div>
				</div>
			</div>
		</div>

	</div>


	<footer class="site-footer border-top">
	<div class="container">
		<div class="row">
			<div class="col-lg-40 mb-10 mb-lg-0">
				<div class="row mb-13">
					<div class="col-md-20"></div>
				</div>


			</div>
			<div class="col-lg-4"></div>
		</div>

	</div>


	<div class="col-lg-14 mb-5 mb-lg-0">

		<div class="mb-z">
			<center>
				<h3 class="footer-heading mb-2">About Us</h3>
				<p>Atek Bank, a state chartered commercial bank, has been serving metro Atlanta’s Southern Crescent since 1955.</p>
			</center>

		</div>

	</div>

	</div>
	<div class="row pt-5 mt-5 text-center">
		<div class="col-md-12">
			<p>
				<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
				Copyright &copy;
				<script>
					document.write(new Date().getFullYear());
				</script>
				All rights reserved | Powered <i class="icon-heart-o"
					aria-hidden="true"></i> by <a href="https://colorlib.com"
					target="_blank">Athitek Solutions</a>
				<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
			</p>
		</div>

	</div>
	</div>
	</footer>
	</div>

	<script src="js/jquery-3.3.1.min.js"></script>
	<script src="js/jquery-migrate-3.0.1.min.js"></script>
	<script src="js/jquery-ui.js"></script>
	<script src="js/popper.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/jquery.stellar.min.js"></script>
	<script src="js/jquery.countdown.min.js"></script>
	<script src="js/jquery.magnific-popup.min.js"></script>
	<script src="js/bootstrap-datepicker.min.js"></script>
	<script src="js/aos.js"></script>

	<script src="js/main2.js"></script>

</body>
</html>
