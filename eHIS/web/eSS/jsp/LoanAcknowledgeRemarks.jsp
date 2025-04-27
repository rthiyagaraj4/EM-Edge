<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%
/*
-------------------------------------------------------------------------------------------------------------------------------------------
Date		            Create History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------
11/02/2014	       		BRU-HIMS-CRF-225.1	    Sakti Sankar	   11/02/2014	    Sakti Sankar			 Newly Created
--------------------------------------------------------------------------------------------------------------------------------------------
*/
%>

<%@ page import=" eSS.LoanAcknowledgementBean" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<html>
	<head>
	<%
		request.setCharacterEncoding("UTF-8");
		String locale			=		(String)session.getAttribute("LOCALE");
		String sStyle			=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eSS/js/SsCommon.js"></script>
		<script language="JavaScript" src="../../eSS/js/SsTransaction.js"></script>
		<script language="JavaScript" src="../../eSS/js/LoanAcknowledgment.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


		<title><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></title>
	</head>
<%
		String bean_id	=	"LoanAcknowledgementBean";
		String bean_name=	"eSS.LoanAcknowledgementBean";
		//String remarks		=	"";
		String remarks		=	(String)request.getParameter("remarks")==null?"":(String)request.getParameter("remarks");	
		
		eSS.LoanAcknowledgementBean bean = (eSS.LoanAcknowledgementBean)getBeanObject( "LoanAcknowledgementBean","eSS.LoanAcknowledgementBean",request );
		bean.setLanguageId(locale);

	%>
<body onload='FocusFirstElement();'>
	<form name= "formAcknowledgeRemarks">
	<br>
	<table border="0" cellspacing="0" width="100%" align=center>
	  <tr>
		<td  colspan="2">&nbsp;</td>
	  </tr>
	  <tr>
		<td  class="label" nowrap><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
		<td class='fields'>
			&nbsp;&nbsp;
			<%if(((String)bean.getAction_type()).equals("C")) {%>
			<textarea name="remarks" rows="3" cols="40" readonly><%=remarks%></textarea>&nbsp;
			<%}else{%>
			<textarea name="remarks" rows="3" cols="40" ><%=remarks%></textarea>&nbsp;
			<%}%>
			&nbsp;
		</td>
	  </tr>
	  <tr>
		<td  colspan="2" align="right"><input type="button" class="button" name="close" id="close" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onClick="updateRemarks();"></td>
	  </tr>
	</table>
		<input type="hidden"	name="bean_id" id="bean_id"		value="<%=bean_id%>">
		<input type="hidden"	name="bean_name" id="bean_name"	value="<%=bean_name %>">
	</form>
	</body>
</html>

