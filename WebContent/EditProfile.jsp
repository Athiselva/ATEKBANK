<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
body {
	background-image: url('bac3.jpg');
	background-size: 100%;
	background-repeat: repeat-y;
	background-attachment: fixed;
	height: 40%;
	width: 80%;
}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Profile</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>
.w3-btn {width:150px;}
</style>
  
</head>
<body>

<br>
<div class="container bootstrap snippet">
    <div class="row"> 
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    	<div class="col-sm-2.5"><a href="Home.jsp" class="pull-right"><img title="ATEK Bank" class="img-circle img-responsive" src="Atek Bank2.bmp"></a></div>
    </div>
    <div class="row">
  		<div class="col-sm-3"><!--left col-->
              

      <div class="text-center">
        <img src="http://ssl.gstatic.com/accounts/ui/avatar_2x.png" class="avatar img-circle img-thumbnail" alt="avatar">
        <h6 style="color:white;">Change Profile Picture</h6>
        <input type="file" class="text-center center-block file-upload">
      </div></hr><br>

                 <c:forEach var="plist" items="${plist}">
          <div class="panel panel-default">
            <div class="panel-heading">Account Created Date <i class="fa fa-link fa-1x"></i></div>
            <div class="panel-body"><a>${plist.cdate}</a></div>
          </div>
               
          <div class="panel panel-default">
            <div class="panel-heading">Last Access Date</div>
            <div class="panel-body"><a>${plist.mdate}</a></div>
          </div>
          </c:forEach>
        </div><!--/col-3-->
        <c:forEach var="plist" items="${plist}">
    	<div class="col-sm-9">
            <ul class="nav nav-tabs">
                <li class="active"><a data-toggle="tab" href="#home">My Profile</a></li>
              </ul>

         
          <div class="tab-content">
            <div class="tab-pane active" id="home">
                <hr>
                  <form class="form" action="ProfileServlet" method="post" id="registrationForm">
                      <div class="form-group">
                          
                          <div class="col-xs-6">
                              <label for="first_name"><h4>Name</h4></label>
                              <input type="text" required class="form-control" value="${plist.name}" name="name" id="first_name" placeholder="Name" title="4-30 Characters,A-z,a-z is only allowed" pattern="[a-zA-Z\s]{4,25}">
                          </div>
                      </div>
                      <div class="form-group">
                          
                          <div class="col-xs-6">
                            <label for="last_name"><h4>Father's Name</h4></label>
                              <input type="text" required class="form-control"  value="${plist.fathersname}" name="fathersname" id="last_name" placeholder="Fathers Name" title="4-20 Characters,A-z,a-z is only allowed" pattern="[a-zA-Z\s]{4,25}">
                          </div>
                      </div>
          
                      <div class="form-group">
                          
                          <div class="col-xs-6">
                              <label for="phone"><h4>Account Number</h4></label>
                              <input type="text" class="form-control"  value="${plist.acnumber}" readonly name="acnumber" id="phone" placeholder="Account Number" title="enter your phone number if any.">
                          </div>
                      </div>
          
                      <div class="form-group">
                          <div class="col-xs-6">
                             <label for="mobile"><h4>Mobile</h4></label>
                              <input type="text" required  class="form-control" name="phonenumber"  value="${plist.phonenumber}" id="mobile" placeholder="Mobile Number" pattern="[0-9]{10}" title="enter your mobile number if any.">
                          </div>
                      </div>
                      <div class="form-group">
                          
                          <div class="col-xs-6">
                              <label for="email"><h4>Email</h4></label>
                              <input type="email" required class="form-control" name="email"  value="${plist.email}" id="email" placeholder="you@email.com" title="enter your email." pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$">
                          </div>
                      </div>
                      <div class="form-group">
                          
                          <div class="col-xs-6">
                              <label for="text"><h4>Gender</h4></label>
                              <input type="text" required class="form-control" name="gender" readonly  value="${plist.gender}" id="location" placeholder="Gender" title="enter a Gender">
                          </div>
                      </div>
                      <div class="form-group">
                          
                          <div class="col-xs-6">
                              <label for="text"><h4>Username</h4></label>
                              <input type="text" required class="form-control" name="username"  value="${plist.username}" id="password" placeholder="Username" title="6-20 Characters,A-Z,a-z,0-9 only allowed" required pattern=^[a-zA-Z][a-zA-Z0-9-_\.]{5,20}$>
                          </div>
                      </div>
                      <div class="form-group">
                          
                          <div class="col-xs-6">
                            <label for="text"><h4>Password</h4></label>
                              <input type="text" required class="form-control" name="password"  value="${plist.password}" id="password2" placeholder="password" title="6-20 Characters,A-Z,a-z & Special characters only allowed"
			pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,20}">
                          </div>
                           <div class="col-xs-6">
                              <label for="text"><h4>Customer ID</h4></label>
                              <input type="text" required class="form-control" readonly  value="${plist.id}" name="id" id="password" placeholder="Customer ID" title="enter your password.">
                          </div>
                      </div>
                      <div class="form-group">
                          
                          <div class="col-xs-6">
                            <label for="text"><h4>Date of Birth</h4></label>
                              <input type="Date" required class="form-control" name="dob" value="${plist.dob}" id="password2" placeholder="Date of Birth" min="1980-01-01" max="2000-01-01" title="enter your password2.">
                          </div>
                           <div class="col-xs-6">
                              <label for="text"><h4>Permanent Address</h4></label>
                              <input type="text"  class="form-control" name="pmtaddress" value="${plist.pmtaddress}" id="password" placeholder="Permanent Address" title="4-150 Characters,A-z,a-z is only allowed" pattern="[a-zA-Z\s]{4,150}" required>
                          </div>
                      </div>
                      <div class="form-group">
                          
                          <div class="col-xs-6">
                            <label for="text"><h4>City and District</h4></label>
                              <input type="text" required class="form-control" name="pmtcity" value="${plist.pmtcity}" id="password2" placeholder="City" title="4-40 Characters,A-z,a-z is only allowed" pattern=".{5,50}">
                          </div>
                          
                      </div>
                       <div class="form-group">
                          
                          <div class="col-xs-6">
                            <label for="text"><h4>Current Address</h4></label>
                              <input type="text" required class="form-control" value="${plist.cntaddress}" name="cntaddress" id="password2" placeholder="Current Address" title="4-200 Characters,A-z,a-z is only allowed" pattern="[a-zA-Z\s]{4,200}">
                          </div>
                           <div class="col-xs-6">
                              <label for="text"><h4>City and District</h4></label>
                              <input type="text" required class="form-control" value="${plist.cntcity}" name="cntcity" id="password" placeholder="City" title="4-40 Characters,A-z,a-z is only allowed" pattern=".{5,50}">
                          </div>
                      </div>
                      <div class="form-group">
                          
                          <div class="col-xs-6">
                            <label for="text"><h4>State</h4></label>
                              <input type="text" required class="form-control" value="${plist.state}" name="state" id="password2" placeholder="State" title="4-40 Characters,A-z,a-z is only allowed" pattern="[a-zA-Z\s]{4,40}">
                          </div>
                           <div class="col-xs-6">
                              <label for="text"><h4>IFSC Code</h4></label>
                              <input type="text" required class="form-control" readonly value="${plist.ifsc}" name="ifsc" id="password" placeholder="IFSC Code" pattern=".{7,7}">
                          </div>
                      </div>    
                      </c:forEach>
                     <div class="form-group">
                           <div class="col-xs-12">
                                <br>
                              	 <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                              	 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                              	 <button class="w3-button w3-green w3-round-xxlarge">Submit</button></p>
							</div>
                            </div>
                      </div>
              
             </div><!--/tab-pane-->
            
            
          </div><!--/tab-content-->

          

                 

</body>
</html>