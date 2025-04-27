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
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
31/08/2015	IN056823		Ramesh G										The Owner Store users access the newly introduced  'Return Vendor Loan' functionality
--------------------------------------------------------------------------------------------------------------------
*/
%>
<%-- JSP Page specific attributes start --%>
<%@	page import="eSS.VendorLoanReturnBean, eCommon.Common.*,eSS.Common.*, eSS.*,java.util.*,java.sql.* ,java.lang.*,webbeans.eCommon.*,java.util.ArrayList,java.util.HashMap" contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@	include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@	include file="../../eCommon/jsp/CommonBean.jsp" %>

<%-- Mandatory declarations end --%>

<html>
	<head>
		<title><fmt:message key="eSS.GroupItemDetails.label" bundle="${ss_labels}"/></title>
		
<%
		request.setCharacterEncoding("UTF-8");
		String sStyle				 =		 (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="Javascript" src="../../eSS/js/VendorLoanReturn.js"> </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
</head>
<body onload="window.scrollTo(0,0)">
<%

	String	doc_no			=	request.getParameter( "doc_no" ) ;
	String	doc_type_code	=	request.getParameter( "doc_type_code" ) ;
	String	doc_type		=	request.getParameter( "doc_type" ) ;
	String	doc_date		= 	request.getParameter( "doc_date" ) ;
	String	storeSelText	= 	request.getParameter( "storeSelText" ) ;
	String	vendorSelText	= 	request.getParameter( "vendorSelText" ) ;
	String	checklist_code 		= 		"";
	%>
	<form name="VenderReturnGroupItemHeaderForm" id="VenderReturnGroupItemHeaderForm">
		<table cellpadding=0 cellspacing=0 width="100%" align="center">
		<tr>
          <td  class="label" ><fmt:message key="Common.DocType.label" bundle="${common_labels}"/> :<%=doc_type %></td>
          <td  class="label" ><fmt:message key="eSS.DocNo.label" bundle="${ss_labels}"/>:<%=doc_no %></td>
          <td  class="label" ><fmt:message key="eSS.DocDate.label" bundle="${ss_labels}"/>:<%=doc_date %></td>
          <td  class="label" ><fmt:message key="eSS.FromStore.label" bundle="${ss_labels}"/>:<%=storeSelText %></td>
          <td  class="label" ><fmt:message key="eSS.ToVendor.label" bundle="${ss_labels}"/>:<%=vendorSelText %></td>
		 </tr>
		 </table>
	</form>
</body>
</html>

