<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%
	if(session.getAttribute("login_user") == null)
	{
		%>
		<script>
			//top.location.href = "../../eCommon/jsp/Login.jsp?level=3"
		alert("Session Expired or Not Logged In. Please Login again to access the Application")
		top.location.href = "../../index.jsp?page=redirect"
		</script>
		<%
	}
%>
