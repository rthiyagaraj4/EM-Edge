<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="portalrefimpl.PortalConstants"%>
<%@page import="portalrefimpl.common.response.ErrorInfo"%>
<%@page import="portalrefimpl.login.response.LoginResponse"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>::: Patient Portal - Home :::</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link rel="stylesheet" href="../css/style.css" type="text/css"/>
<link rel="stylesheet" href="../css/style_ie.css" type="text/css"/>

<script>
  function Login()
  {
	  var userName = document.getElementById("name").value;
	  var pwd = document.getElementById("password").value;
	  
	  if(userName == null || userName == "")
		  {
		    alert("Please Enter User Name");
		    return false
		  }
	  
	  if(pwd == null || pwd == "")
		  {
		    alert("Please Enter Password");
		    return false;
		  }
	 return true; 
  }
  
  function showHomePage(){
	  var loginResult = Login();
	  if(loginResult == false){
		  return;
	  }else if(loginResult == true){
		  var formElement = document.getElementById("login_form");
		  if(formElement){
			  var userName = document.getElementById("name").value;
			  //formElement.action = "../jsp/PatientPortalHome.jsp?patientId="+userName+"&useWebService=Y";
			  formElement.action = "../servlet/LoginServlet?patientId="+userName+"&useWebService=Y";
			  formElement.submit();
		  }
	  }
	  
  }
  
  document.onkeypress = keyPress;
  function keyPress(e){
	  var x = e || window.event;
	  var key = (x.keyCode || x.which);
	    if(key == 13 || key == 3){
	    	showHomePage();
	    }
	}
  
</script>
</head>
<body>

<%
	LoginResponse loginResponse = null;
	/* loginResponse = (LoginResponse) getServletConfig()
			.getServletContext().getAttribute("loginResponse"); */
	loginResponse = (LoginResponse)session
			.getAttribute(PortalConstants.LOGINRESPONSE_SESSION_KEY);
	String errorMessage = "";
	if(loginResponse != null){
		if(!loginResponse.isSuccessful()){
			//errorMessage = errorInfo.getErrorMessage();
			//errorMessage = "Login failed. Please check the Username and Password.";
			errorMessage = loginResponse.getErrorMessage();
			// safe initialization
			/* if(errorMessage == null){
				errorMessage = "";
			} */
		}
	}

%>

<div id="wrapper" style="background-image:url(../images/loginbg.png);background-repeat:repeat-x;" class="LoginBackgroun">
 	
<header id="headerlogin">
  <div id="loginHearBg">
  </div>
</header>
 
<form id='login_form' name='login_form' id='login_form' method="post" action="../../servlet/LoginServlet">
<div id="logincontent">
<div id="mydiv">
	<div class="row">
    	<div id="loginlogo">
   		<img src="../images/logo.png"> </div>
        <div id="logininput">
      		<div id="logininputcontent">
						<span class="signin"> Sign In </span><br>
			  <span class="username"> Username </span><br>
                        <input id='name' name='name' id='name' type="text" style="background: transparent url('../images/textbox.png') no-repeat;width: 265px;color : #747862;height:30px;border:0;padding:0px 0px;margin-bottom:0px;" class="textbo"><br>
                        <span class="username"> Password </span><br>
                        <input type="password" id='password' name='password' id='password' style="background: transparent url('../images/textbox.png') no-repeat;width: 265px;color : #747862;height:30px;border:0;padding:0px 0px;margin-bottom:0px;" class="textbo"><br>
                        
                        
                        <%
                        if(!errorMessage.trim().equals("")){
                        %>
                        <!-- place holder for error image -->
                        <p>
                        <span class="loginerror">
                        <%	
							out.println(errorMessage);
                        %>
                        </span>
                        </p>
                        <%
                        }
                        %>
                        
                        <span> <a href="#" onclick="showHomePage()" class="Signbtn">Sign In</a></span><br>
                        <span> <a href="#" class="mainlink">Unable to access my account</a></span><br>
                        <span> <a href="#" class="mainlink">Click here to Register </a></span>


                    
            </div>
        </div>
    
    </div>
    
</div>
</div>
    <!-- #content-->
</form>    

</div>


<footer id="footer">

    	 <div id="poweredby">
        <p class="loginpoweredby">Powered by <img src="../images/csc.png" width="25" height="14"></p>
        </div>
    
    

</footer>
</body>
</html>

