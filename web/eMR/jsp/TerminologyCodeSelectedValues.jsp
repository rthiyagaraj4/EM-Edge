<!DOCTYPE html>
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eMR
*	Purpose 		:	
*	Created By		:	Vinay
*	Created On		:	17 Jan 2005
--%>
<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.lang.*,java.net.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script language="JavaScript" src="../../eMR/js/TerminologyCode.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff"); 
String termsetid = request.getParameter("termsetid");
if(termsetid==null) termsetid="";
// String termdesc = java.net.URLDecoder.decode(request.getParameter("termdesc"));
String termdesc = request.getParameter("termdesc");
//out.println("termdesc"+termdesc);

if(termdesc==null) termdesc="";
%>
</head>
<body OnMouseDown='CodeArrest()' onKeyDown='lockKey()'>
<form name='term_code_selval' id='term_code_selval'>
<table border="1" cellpadding="0" cellspacing="0"  width="100%" align='center'>
<tr><td class="COLUMNHEADER" ><fmt:message key="eMR.SelectedClassificationLevels.label" bundle="${mr_labels}"/></td></tr>
</table>
<table border="1" cellpadding="0" cellspacing="0" id='tableId' width="100%" align='center'>
<%
if(!termsetid.equals(""))
{%>
	<tr><td><font color="blue"><%=termdesc%></font></td></tr>	
<%
}
%>
</table>
</form>
</body>
</html>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

