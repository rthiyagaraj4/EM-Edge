<!DOCTYPE html>
<%
	/*
	----------------------------------------------------------------------------------------------------------------
	 Date       Edit History   	Name       			Rev.Date   	Rev.By    				Description
	----------------------------------------------------------------------------------------------------------------
	10/01/2018  IN061893		Kamalakannan G  	10/01/2018  Ramesh G 			ML-MMOH-CRF-0545
	19/01/2018  IN066356		Kamalakannan G  	17/01/2018  Ramesh G 			ML-MMOH-CRF-0545
	-----------------------------------------------------------------------------------------------------------------
	*/
%>
<%@ page language="java" import="eCommon.XSSRequestWrapper" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% 
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<title><fmt:message key="Common.Rejected.label" bundle="${or_labels}"/></title><!--IN066356 -->
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
 	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eOR/js/RejectedOrders.js"></script>
	<script language="JavaScript" src="../js/OrCommon.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrCommonFunction.js"></script>
	<Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
</head>
<body onscroll='processScroll()' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="rejected_remarks" id="rejected_remarks" method="post" target="messageFrame"> 
<%
	String remarks	=	(request.getParameter("remarks")==null)?"0":request.getParameter("remarks");
	String rej_pract_name	=	(request.getParameter("rej_pract_name")==null)?"0":request.getParameter("rej_pract_name");
	String reject_date_time	=	(request.getParameter("reject_date_time")==null)?"0":request.getParameter("reject_date_time");
%>
<table width=100%>
<tr><td class='fields' colspan ='2'><TEXTAREA NAME="" ROWS="6" COLS="61" readonly><%=remarks%></TEXTAREA></td></tr><!--IN066356-->
<tr>
	<td >
		<fmt:message key="eOR.DateandTime.label" bundle="${ca_labels}"/>
	</td>
	<td>
		<%=reject_date_time %>
	</td>
</tr>
<tr>
	<td>
		<fmt:message key="Common.practitioner.label" bundle="${ca_labels}"/><!--IN066356-->
	</td>
	<td>
		<%=rej_pract_name%>
	</td>
</tr>
<tr><td colspan="2" class=white align='right'><input type='button' class='button' value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onClick='modal_close();'></td></tr>
</table>
</form>
</body>
</html>

