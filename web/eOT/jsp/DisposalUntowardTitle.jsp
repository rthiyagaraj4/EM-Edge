<!DOCTYPE html>
<%@ page import ="eCommon.XSSRequestWrapper,eCommon.Common.CommonBean" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends
%>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>

<html>
<head>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<% 
	String title= CommonBean.checkForNull(request.getParameter("title"));
%>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name='TitleForm' id='TitleForm'>
<table border='0' cellpadding=3 cellspacing='0' width='100%'>
<tr>
	<td colspan='2'class='CAGROUPHEADING'><%=title%></td> 
</tr>
</table>
</form>
</body>
</html>


