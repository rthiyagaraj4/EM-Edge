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
		<title></title>
		<meta name="Author" content="Suresh Rajagopal">
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
<%

		String mode				 =		request.getParameter("mode");
		String doc_no			 =		request.getParameter("doc_no");
		String doc_type_code	 =		request.getParameter("doc_type_code");		
				
		String params = request.getQueryString();
		String bean_id = "VendorLoanReturnBean";
		String bean_name = "eSS.VendorLoanReturnBean";
		VendorLoanReturnBean bean = (VendorLoanReturnBean) getBeanObject(bean_id,bean_name,request); 
		bean.setLanguageId(locale);
		bean.setLoginFacilityId(facility_id);
		   
		if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))) {
		 	bean.clear();
			bean.initialize();
		}else if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {
			bean.setDoc_type_code (doc_type_code.trim());
			bean.setDoc_no (doc_no.trim());
		}
	putObjectInBean(bean_id,bean,request);
%>
<iframe name="frameVendorLoanReturnHeader" id="frameVendorLoanReturnHeader" frameborder="0" scrolling="no" noresize src="../../eSS/jsp/VendorLoanReturnHeader.jsp?<%=request.getQueryString()%>" style="height:150%;width:100vw"></iframe><iframe name="frameVendorLoanReturnList" id="frameVendorLoanReturnList" src="../../eCA/jsp/blank.jsp" frameborder="0" noresize scrolling="auto" style="height:100vh;width:100vw"></iframe>

</html>

