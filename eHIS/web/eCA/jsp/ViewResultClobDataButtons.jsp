<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Description
--------------------------------------------------------------------------------------------------------------------
11/06/2013    IN039414      Ramesh G		Result Widget->Click on Result Hyperlink->Click on any Lab results->HTML tags displayed in Result									
--------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle =

		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
	<body  onKeyDown="lockKey()">
	<form>
		<table align='right'><tr><td align='right'><input type='button' class='button' value='Close' onclick=window.close()></td></tr></table>
	</form>
	</body>
</html>

