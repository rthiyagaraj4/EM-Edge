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
	 22/04/2014	       		BRU-HIMS-CRF-398	    Sakti Sankar	   22/04/2014	     Sakti Sankar			 Newly Created
	 --------------------------------------------------------------------------------------------------------------------------------------------
	 */
%>  
<%@	page import="java.util.*,eSS.Common.*,eSS.*,java.util.*,java.sql.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@	include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<html>
<title>Return Details</title>
<head>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "")
			? (String) session.getAttribute("PREFERRED_STYLE")
			: "IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>

	<%
		String params = request.getQueryString();
	%>

<iframe name="ReturnStatusDetailForDoc" id="ReturnStatusDetailForDoc" src="../../eSS/jsp/ReturnStatusQueryDetailForDoc.jsp?<%=params%>" frameborder=0 scrolling='no'   noresize style='height:87vh;width:100vw'></iframe>
		<iframe name="frameClose" id="frameClose" src="../../eSS/jsp/ReturnStatusQueryDetailClose.jsp" frameborder=0 scrolling='no'   noresize style='height:100vh;width:100vw'></iframe>
	
</html>

