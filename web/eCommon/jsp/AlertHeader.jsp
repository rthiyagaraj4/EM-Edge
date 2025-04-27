<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String p_user_name= (String) session.getValue( "login_user" ) ;
	%>
	
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Alert</title>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	</head>
	<body>
		<!-- <input type="button" style="background: url(../../eAlert/images/Alerticon.png) no-repeat center;width:24px;height:24px;border:0;cursor:pointer;" onclick="showalert()"/>
		<span id="unackalerts" class="ALERTCOUNT" style="vertical-align:top;align:left;"></span> -->
		
		<div class="countcontainer" onclick="showalert()" style="cursor:pointer">

			<table width="100%" border="0" cellspacing="0" cellpadding="0" style="background:transparent;">
				<tr>
				    <td width="16" height="27" align="left" valign="bottom"><img src="../../eAlert/images/Alert_Icon.PNG" width="16" height="16" /></td>
				    	<td width="73%" height="27" align="left" valign="top">
				    	<div id="countdiv" class="countdigit" style="display:block">
				    		<table border="0" cellspacing="0" cellpadding="0">
								<tr>
						    		<td width="4" align="left" valign="top"><img src="../../eAlert/images/CountLeft.png" width="4" height="16" /></td>
							    	<td background="../../eAlert/images/CountCenter.png">
							    		<span class="countnum" id="unackalerts"></span>
									</td>
									<td width="4" align="right" valign="top"><img src="../../eAlert/images/CountRight.png" width="4" height="16" /></td>
								</tr>
							</table>
						</div>
					</td>
				</tr>
			</table>
		</div>
		
	</body>
	<script type="text/javascript">
	function showalert()
	{
		window.showModalDialog("../../eAlert/jsp/AlertContainer.jsp", null, "dialogWidth:330px; dialogHeight:470px; center:yes; status:no; toolbar:no");
	}
	
	function unackalertcount(){
		var unAckAlerts = getUnacknowledgedAlerts("<%=p_user_name%>");
		var countdiv = document.getElementById("countdiv");
		if(unAckAlerts == "0"){
			document.getElementById("unackalerts").innerHTML = "";
			countdiv.style.display = 'none';
		}
		else{
			document.getElementById("unackalerts").innerHTML = unAckAlerts;
			countdiv.style.display = 'block';
		}
		//document.getElementById("unackalerts").innerHTML = getUnacknowledgedAlerts("<%=p_user_name%>");  
	}
	
	window.setInterval("unackalertcount()", "60000");
	unackalertcount();
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</html>

