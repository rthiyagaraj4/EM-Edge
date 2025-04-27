<!DOCTYPE html>
<html>
<%
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
request.setCharacterEncoding("UTF-8");

String queryString = request.getQueryString();
String action = request.getParameter("action");
%>
<%@ page contentType="text/html;charset=UTF-8" %>

<link rel='StyleSheet' href='../eCommon/html/<%=sStyle%>' type='text/css'></link>

<HEAD>
	<SCRIPT Language="JavaScript"  src="../eCommon/js/ValidateControl.js"></SCRIPT><script src='../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	<SCRIPT>
	function forwardRequest()
	{
		location.href = '../eXH/jsp/<%= action %>?<%= queryString %>';		
	}
	</SCRIPT>
</HEAD>

<BODY onMouseDown="CodeArrest()" onKeyDown ='lockKey()' onLoad="forwardRequest();">
<FORM name="forwardForm" id="forwardForm"></FORM>

</BODY>
</HTML>

