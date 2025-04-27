<!DOCTYPE html>
<%
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
24/09/2014     		1   		Sethuraman      Created for Configuring Summary Layout  
-------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import="java.sql.*,eCA.*,webbeans.eCommon.*"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../js/EncSummLayout.js'></script>
<Script language="JavaScript" src='../../eCommon/js/CommonLookup.js'></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<body>
	<form name="SummLayoutBlankForm" id="SummLayoutBlankForm"
		action="../../servlet/eCA.EncSummLayoutServlet" method="post"
		target="messageFrame">	

		<input type=hidden name="mode" id="mode" value=">"> 
		<input type=hidden name="es_summ_code" id="es_summ_code" value="">
		<input type=hidden name="changeFlag" id="changeFlag" value="">		
		<input type=hidden name="headerValue" id="headerValue" value=""> 
		<input type=hidden name="footerValue" id="footerValue" value=""> 
	</form>
</body>
</html>

