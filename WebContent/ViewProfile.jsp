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
                              <input type="text" class="form-control" value="${plist.name}" readonly name="name" id="first_name" placeholder="Name" title="enter your first name if any.">
                          </div>
                      </div>
                      <div class="form-group">
                          
                          <div class="col-xs-6">
                            <label for="last_name"><h4>Father's Name</h4></label>
                              <input type="text" class="form-control"  value="${plist.fathersname}" readonly name="fathersname" id="last_name" placeholder="Fathers Name" title="enter your last name if any.">
                          </div>
                      </div>
          
                      <div class="form-group">
                          
                          <div class="col-xs-6">
                              <label for="phone"><h4>Account Number</h4></label>
                              <input type="text" class="form-control"  value="${plist.acnumber}" readonly name="phonenumber" id="phone" placeholder="Account Number" title="enter your phone number if any.">
                          </div>
                      </div>
          
                      <div class="form-group">
                          <div class="col-xs-6">
                             <label for="mobile"><h4>Mobile</h4></label>
                              <input type="text" class="form-control" name="phonenumber"  readonly value="${plist.phonenumber}" id="mobile" placeholder="Mobile Number" title="enter your mobile number if any.">
                          </div>
                      </div>
                      <div class="form-group">
                          
                          <div class="col-xs-6">
                              <label for="email"><h4>Email</h4></label>
                              <input type="email" class="form-control" name="email" readonly value="${plist.email}" id="email" placeholder="you@email.com" title="enter your email.">
                          </div>
                      </div>
                      <div class="form-group">
                          
                          <div class="col-xs-6">
                              <label for="text"><h4>Gender</h4></label>
                              <input type="text" class="form-control" name="gender" readonly  value="${plist.gender}" id="location" placeholder="Gender" title="enter a Gender">
                          </div>
                      </div>
                      <div class="form-group">
                          
                          <div class="col-xs-6">
                              <label for="text"><h4>Username</h4></label>
                              <input type="text" class="form-control" name="username" readonly  value="${plist.username}" id="password" placeholder="Username" title="enter your password.">
                          </div>
                      </div>
                      <div class="form-group">
                          
                          <div class="col-xs-6">
                            <label for="text"><h4>Password</h4></label>
                              <input type="text" class="form-control" name="password" readonly  value="${plist.password}" id="password2" placeholder="password" title="enter your password2.">
                          </div>
                           <div class="col-xs-6">
                              <label for="text"><h4>Customer ID</h4></label>
                              <input type="text" class="form-control"  value="${plist.id}" readonly name="id" id="password" placeholder="Customer ID" title="enter your password.">
                          </div>
                      </div>
                      <div class="form-group">
                          
                          <div class="col-xs-6">
                            <label for="text"><h4>Date of Birth</h4></label>
                              <input type="Date" class="form-control" name="dob" value="${plist.dob}" readonly id="password2" placeholder="Date of Birth" title="enter your password2.">
                          </div>
                           <div class="col-xs-6">
                              <label for="text"><h4>Permanent Address</h4></label>
                              <input type="text" class="form-control" name="pmtaddress" value="${plist.pmtaddress}" readonly id="password" placeholder="Permanent Address" title="enter your password.">
                          </div>
                      </div>
                      <div class="form-group">
                          
                          <div class="col-xs-6">
                            <label for="text"><h4>City and District</h4></label>
                              <input type="text" class="form-control" name="pmtcity" value="${plist.pmtcity}" readonly id="password2" placeholder="City" title="enter your password2.">
                          </div>
                          
                      </div>
                       <div class="form-group">
                          
                          <div class="col-xs-6">
                            <label for="text"><h4>Current Address</h4></label>
                              <input type="text" class="form-control" value="${plist.cntaddress}" name="cntaddress" id="password2" readonly placeholder="Current Address" title="enter your password2.">
                          </div>
                           <div class="col-xs-6">
                              <label for="text"><h4>City and District</h4></label>
                              <input type="text" class="form-control" value="${plist.cntcity}" name="cntcity" id="password" readonly placeholder="City" title="enter your password.">
                          </div>
                      </div>
                      <div class="form-group">
                          
                          <div class="col-xs-6">
                            <label for="text"><h4>State</h4></label>
                              <input type="text" class="form-control" value="${plist.state}" name="state" id="password2" readonly placeholder="State" title="enter your password2.">
                          </div>
                           <div class="col-xs-6">
                              <label for="text"><h4>IFSC Code</h4></label>
                              <input type="text" class="form-control" value="${plist.ifsc}" name="ifsc" id="password" readonly placeholder="IFSC Code" title="enter your password.">
                          </div>
                      </div>    
                      <div class="form-group">
                          
                          <div class="col-xs-6">
                            <label for="text"><h4>MMID</h4></label>
                              <input type="text" readonly class="form-control" value="${plist.mmid}" name="state" id="password2" readonly placeholder="State" title="enter your password2.">
                          </div>
                      </div>    
                      </c:forEach>
                      
                     <div class="form-group">
                           <div class="col-xs-12">
                                <br>
                              	<br>	<br>
                              	
							</div>
                            </div>
                      </div>
              
             </div><!--/tab-pane-->
            
            
          </div><!--/tab-content-->

          

                 

</body>
</html>