<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="eSS.ReturnGroupBean,eSS.*, eSS.Common.* , eCommon.Common.*, java.text.*, java.util.*" contentType="text/html;charset=UTF-8"%>

<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@include file="../../eCommon/jsp/CommonInclude.jsp" %> 

<html>
	<head>
		<title><fmt:message key="eSS.DiscrepancyDetails.label" bundle="${ss_labels}"/></title>
		
<%	request.setCharacterEncoding("UTF-8");
	String sStyle		=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eSS/js/ReturnGroup.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
	</head>
	<%
		String params	=		request.getQueryString() ;
		
	%>
	<div style="display: flex; flex-direction: row; height: 100vh; gap: 5px;">
    
        <!-- First iframe: ReturnGroupDiscrepancyDetail -->
        <iframe name="frameReturnGroupDiscrepancyDetail" id="frameReturnGroupDiscrepancyDetail" 
                src="../../eSS/jsp/ReturnGroupDiscrepancyDetail.jsp?<%=params%>" 
                frameborder="0" scrolling="no" noresize 
                style="height: 70vh; width: 71vw;"></iframe>
<div style="display: flex; flex-direction: column; height: 100vh;width:54vw; gap: 5px;">
        <!-- Second iframe: ReturnGroupDiscrepancyHeader -->
        <iframe name="frameReturnGroupDiscrepancyHeader" id="frameReturnGroupDiscrepancyHeader" 
                src="../../eSS/html/ReturnGroupDiscrepancyHeader.html?<%=params%>" 
                frameborder="0" scrolling="auto" noresize 
                style="height: 6vh; width: 83vw;"></iframe>
			<iframe name="frameReturnGroupDiscrepancyList" src="../../eSS/jsp/ReturnGroupDiscrepancyList.jsp?<%=params%>" frameborder=0 scrolling='auto' noresize style="height: 43vh; width: 63vw;"></iframe>
       
</div>
    <!-- Second column for remaining space -->
   
    
</div>
	
</html>
