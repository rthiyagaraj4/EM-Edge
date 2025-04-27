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

<%@ page import="eSS.VendorLoanReturnBean,eSS.*, eSS.Common.* , eCommon.Common.*, java.text.*, java.util.*" contentType="text/html;charset=UTF-8"%>

<%@	include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 

<html>
	<head>
		<title>Acknowledged Vendor Loan Request</title>		
<%
		request.setCharacterEncoding("UTF-8");
		String sStyle					=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String locale			= (String)session.getAttribute("LOCALE");
		String facility_id		=	(String)session.getValue("facility_id");
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="JavaScript" src="../../eSS/js/VendorLoanReturn.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</head>
<iframe name="frameVenderReturnGroupItemHeader" id="frameVenderReturnGroupItemHeader" frameborder="0" scrolling="no" noresize src="../../eSS/jsp/VenderReturnGroupItemHeader.jsp?<%=request.getQueryString()%>" style="height:8vh;width:100vw"></iframe><iframe name="frameVenderReturnGroupItemDetails" id="frameVenderReturnGroupItemDetails" src="../../eSS/jsp/VenderReturnGroupItemDetails.jsp?<%=request.getQueryString()%>" frameborder="0" noresize scrolling="auto" style="height:81vh;width:100vw"></iframe><iframe name="frameVenderReturnGroupItemButtons" id="frameVenderReturnGroupItemButtons" src="../../eSS/jsp/VernderReturnGroupItemButtons.jsp?<%=request.getQueryString()%>" frameborder="0" noresize scrolling="no" style="height:10vh;width:100vw"></iframe>

</html>

