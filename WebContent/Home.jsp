<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
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
									class="d-none d-md-inline-block">Support@atekbank.com</span>
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
						<font size="+2" font color="white">
							Welcome&nbsp;
							${name}
							</font>
							
						<div class="col-10">
							<nav class="site-navigation text-right" role="navigation">
							<div class="container">
								<div class="d-inline-block d-lg-none ml-md-0 mr-auto py-3">
									<a href="#" class="site-menu-toggle js-menu-toggle text-white"><span
										class="icon-menu h3"></span></a>
								</div>

								<ul class="site-menu js-clone-nav d-none d-lg-block">
									<li class="has-children active"><a href="Home.jsp">Overview</a>
										<ul class="dropdown arrow-top">
											<li><a href="Home.jsp">My View</a></li>
										</ul></li>
									<li class="has-children"><a href="Home.jsp">My
											Account</a>
										<ul class="dropdown arrow-top">
											<li><a href="TransactionServlet">Balance Enquiry</a></li>
										</ul></li>
									<li class="has-children"><a href="Home.jsp">Payment
											and Transfer</a>
										<ul class="dropdown arrow-top">
											<li class="has-children">
                          <a href="#">Fund Transfer</a>
                          <ul class="dropdown">
                            <li><a href="IMPS.jsp">Mobile (via MMID)</a></li>
                            <li><a href="NEFT.jsp">NEFT Transfer</a></li>
                            <li><a href="RTGS.jsp">RTGS Transfer</a></li>
                          </ul>
                        </li>
											<li><a href="TransactionListServlet">My Transactions</a></li>
										</ul></li>
									<li class="has-children"><a href="Home.jsp">My
											Profile</a>
										<ul class="dropdown arrow-top">
											<li><a href="ViewProfileServlet">View Profile</a></li>
											<li><a href="ProfileServlet">Edit Profile</a></li>
										</ul></li>


									<li><a href="AboutUs.html">About Us</a></li>
									<li><a href="InvalidateServlet">Logout</a></li>
								</ul>
							</div>
							</nav>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="site-blocks-cover overlay"
			style="background-image: url(images/hero_bg_1.jpg);" data-aos="fade"
			data-stellar-background-ratio="0.5">
			<div class="container">
				<div
					class="row align-items-center text-center justify-content-center">
					<div class="col-md-8">
						<span class="sub-text">A tradition of Trust</span>
						<h1>Together we can!</h1>
						<input type="hidden" name="page" value="BE"><br>
					</div>
				</div>
			</div>
		</div>

		<div class="site-block-1">
			<div class="container">
				<div class="row">
					<div class="col-lg-4">
						<a href="TransactionListServlet" class="site-block-feature d-flex p-4 rounded mb-4">
							<div class="mr-3">
								<span class="icon flaticon-window font-weight-light h2"></span>
							</div>
							<div class="text">
								<h3>View All Transactions</h3>
								<p>Previous Entire Transaction List.</p>
							</div>
						</a>
					</div>
					<div class="col-lg-4">
						<a href="IMPS.jsp"
							class="site-block-feature d-flex p-4 rounded mb-4">
							<div class="mr-3">
								<span class="icon flaticon-measuring font-weight-light h2"></span>
							</div>
							<div class="text">
								<h3>Money Transfer (IMPS)</h3>
								<p>With In a same or Another Bank within a Minute.</p>
							</div>
						</a>
					</div>
					<div class="col-lg-4">
						<a href="ProfileServlet" class="site-block-feature d-flex p-4 rounded mb-4">
							<div class="mr-3">
								<span class="icon flaticon-interior-design font-weight-light h2"></span>
							</div>
							<div class="text">
								<h3>Edit Profile</h3>
								<p>To Change Your Username,Password and Your personal Info.</p>
							</div>
						</a>
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
