<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="portal.common.response.ErrorInfo"%>
<%@page import="portal.login.response.LoginResponse"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/Portal.css" type="text/css" />
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
			  formElement.action = "../../servlet/LoginServlet?patientId="+userName+"&useWebService=Y";
			  formElement.submit();
		  }
	  }
	  
  }
</script>
</head>
<body>

<%
	LoginResponse loginResponse = (LoginResponse) getServletConfig()
			.getServletContext().getAttribute("loginResponse");
	String errorMessage = "";
	if(loginResponse != null){
		ErrorInfo errorInfo = loginResponse.getErrorInfo();
		int errorCode = errorInfo.getErrorCode();
		if(ErrorInfo.SUCCESS_CODE != errorCode){
			//errorMessage = errorInfo.getErrorMessage();
			errorMessage = "Login failed. Please check the Username and Password";
			// safe initialization
			/* if(errorMessage == null){
				errorMessage = "";
			} */
		}
	}

%>

	<form id='login_form' name='login_form' id='login_form' method="post" action="../../servlet/LoginServlet">
			<div class="center">
				<div class="login" id="loginFrame" style = "display:block">
					<div class="loginFieldsBg">
							<input class="name" id='name' name='name' id='name' type="text" placeholder ="Username" /><br /> 
							<input class="password" type='password' id='password' name='password' id='password' placeholder ="Password" /><br />
							<table border=0 cellpadding="0" width="320px" cellspacing="0" style="text-wrap:normal;word-wrap:break-word;">	
								<tr>
									<td style="text-wrap:normal;word-wrap:break-word;">
										<span style="color:#dd0000;text-wrap:normal;word-wrap:break-word;">
										<% if(!errorMessage.trim().equals("")){
											out.println(errorMessage);
										}
										%></span>
									</td>
								</tr>	
							</table>
							<input
								type="submit" value="Login" class="loginID" onclick = "Login()" data-inline="true"/> 
					</div>
				</div>		
		  </div>
	</form>
</body>
</html>

