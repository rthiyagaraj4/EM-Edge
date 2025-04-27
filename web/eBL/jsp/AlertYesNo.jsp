<!DOCTYPE html>
<!-- 
Sr No        Version           TFS/Incident        SCF/CRF            		 Developer Name
--------------------------------------------------------------------------------------------------------
1  		V221023				TH-KW-CRF-0020.7		Mohanapriya
--------------------------------------------------------------------------------------------------------
-->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<HTML>
	<head>
	<title>Confirmation</title>
	<%
		String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css"; 
	%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<script language='javascript' src='../../eBL/js/BillReceipt.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
	</head>
	<%
	String queryString = request.getQueryString(); 	
	String message=request.getParameter("message");
	System.err.println("message in AlertYesNo.jsp==>"+message);
	%>
	<table width='100%' >
		<tr>
		 <td class="LABEL" width="100%" align ="center">
			<%=message%>
		 </td>
			
		</tr>
		<tr>
		</tr>
		<tr>
			<td width="50%" align ="center">
				<input type='button' class='button' name='Yes' id='Yes' id='Yes' value='<fmt:message key="Common.yes.label" bundle="${common_labels}"/>' onclick="parent.window.returnValue=1;window.close();">
				<input type='button' class='button' name='No' id='No'  id='No' value='<fmt:message key="Common.no.label" bundle="${common_labels}"/>'onclick="parent.window.returnValue=0;window.close();">
			</td>
		</tr>
	</table>
</HTML>

