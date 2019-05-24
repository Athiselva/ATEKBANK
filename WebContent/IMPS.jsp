<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
body {
	background-image: url('blue.jpg');
	background-size: 100%;
	background-repeat: repeat-y;
	background-attachment: fixed;
	height: 40%;
	width: 81%;
}
<style>
.register{
    background: -webkit-linear-gradient(left, #3931af, #00c6ff);
    margin-top: 0%;
    padding: 5%;
}
.register-left{
    text-align: center;
    color: #fff;
    margin-top: 2%;
}
.register-left input{
    border: none;
    border-radius: 1.5rem;
    padding: 2%;
    width: 50%;
    background: #f8f9fa;
    font-weight: bold;
    color: #383d41;
    margin-top: 30%;
    margin-bottom: 30%;
    cursor: pointer;
}
.register-right{
    background: #f8f9fa;
    border-top-left-radius: 10% 50%;
    border-bottom-left-radius: 10% 50%;
}
.register-left img{
    margin-top: 26%;
    margin-bottom: 50%;
    width: 35%;
    -webkit-animation: mover 2s infinite  alternate;
    animation: mover 1s infinite  alternate;
}
@-webkit-keyframes mover {
    0% { transform: translateY(0); }
    100% { transform: translateY(-20px); }
}
@keyframes mover {
    0% { transform: translateY(0); }
    100% { transform: translateY(-20px); }
}
.register-left p{
    font-weight: lighter;
    padding: 12%;
    margin-top: -9%;
    
}
.register .register-form{
    padding: 5%;
    margin-top: 12%;
    
}
.btnRegister{
    float: right;
    margin-top: 10%;
    border: none;
    border-radius: 1.5rem;
    padding: 2%;
    background: #0062cc;
    color: #fff;
    font-weight: 600;
    width: 50%;
    cursor: pointer;
}
.register .nav-tabs{
    margin-top: 2%;
    border: none;
    background: #0062cc;
    border-radius: 1.5rem;
    width: 28%;
    float: right;
}
.register .nav-tabs .nav-link{
    padding: 0%;
    height: 34px;
    font-weight: 600;
    color: #fff;
    border-top-right-radius: 1.5rem;
    border-bottom-right-radius: 1.5rem;
}
.register .nav-tabs .nav-link:hover{
    border: none;
}
.register .nav-tabs .nav-link.active{
    width: 100px;
    color: #0062cc;
    border: 2px solid #0062cc;
    border-top-left-radius: 1.5rem;
    border-bottom-left-radius: 1.5rem;
}
.register-heading{
    text-align: center;
    margin-top: 8%;
    margin-bottom: -15%;
    color: #495057;
}
</style>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Money Transfer</title>
<link href="bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="bootstrap.min.js"></script>
<script src="jquery.min.js"></script>
</head>
<body>
<div class="container register">
                <div class="row">
                    <div class="col-md-3 register-left">
                      <img src="logo.png" alt=""/>
                        <h3>ATEK BANK</h3>
                        <p>You are 30 seconds away from earning your own money!</p>
                        <form method="post" action="Home.jsp">
                        <input type="submit" name="" value="Home"/><br/>
                        </form>
                    </div>
                    
                    <div class="col-md-9 register-right">
                       <br><br>
                        <div class="tab-content" id="myTabContent">
                            <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                                <h3 class="register-heading">Money Transfer (via MMID)</h3><br><br>
                                 <form method="post" action="TransactionServlet">
                                <div class="row register-form">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <input type="text" name="phonenumber" required class="form-control" pattern="[0-9]{10}" placeholder="Payee Mobile Number *" value="" />
                                        </div>
                                        <div class="form-group">
                                            <input type="text" class="form-control" required name="mmid"  placeholder="Payee MMID *" pattern="[0-9]{7}" value="" />
                                        </div>
                                        <div class="form-group">
                                            <div class="maxl">
                                                
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                       
                                        <div class="form-group">
                                            <input type="number" min="1" max="25000" required name="amount" class="form-control" placeholder="Amount *" value="" />
                                        </div>
                                        <div class="form-group">
                                            <input type="text" class="form-control" name="remarks" required pattern=".{4,30}" placeholder="Remarks (Optional)" value="" />
                                        </div>
                                        <input type="submit" class="btnRegister"  value="Proceed"/>
                                        <input type="hidden" name="page" value="MMID"><br>
                                    </div>
                                </div>
                            </div>
                            </form>

</body>
</html>