<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
	<head>
		<title> </title> 
		<meta name="Author" content="Suresh R">
<%
		request.setCharacterEncoding("UTF-8");
		String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
		<script language="JavaScript" src="../../eSS/js/SsCommon.js"></script>
		<script language="JavaScript" src="../../eSS/js/VendorLoanAck.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
		<%
		String locale			= (String)session.getAttribute("LOCALE");
		eSS.VendorLoanAckBean bean = (eSS.VendorLoanAckBean)getBeanObject( "VendorLoanAckBean","eSS.VendorLoanAckBean",request );
		bean.setLanguageId(locale);
		

%>
<iframe name='AcknowledgeHeaderframe' id='AcknowledgeHeaderframe'	src="../../eSS/jsp/VendorLoanAckHeader.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='no'   noresize style='height:16vh;width:100vw'></iframe>
		<iframe name='AcknowledgeDetailframe' id='AcknowledgeDetailframe'	src="../../eCommon/html/blank.html" frameborder=0 scrolling='auto'   noresize style='height:56vh;width:100vw'></iframe>
		<iframe name='AcknowledgeListframe' id='AcknowledgeListframe'		src="../../eCommon/html/blank.html" frameborder=0 scrolling='auto' noresize style='height:10vh;width:100vw'></iframe>
	
</html>

