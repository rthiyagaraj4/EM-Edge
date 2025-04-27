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
-------------------------------------------------------------------------------------------------------------------------------------------------------------
Date		            Edit History	        Name			INC Number       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------------------------

12/11/2014				AAKH_CRF_0057			Sakti Sankar		52312											Autoclaving function, option to select
																													Biological indicator , BMS Pass / Fail 
																													Both in Master as wel as Transaction function.
--------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import=" eSS.*, eSS.Common.* , eCommon.Common.*, java.text.*, java.util.*" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<jsp:useBean id="alAutoclavingList" scope="session" class="java.util.ArrayList"/>
<%-- Mandatory declarations end --%>
<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
		String sStyle		 =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<meta name="Generator" content="EditPlus @ MEDICOM Solutions (P) Ltd. Bangalore. INDIA.">
		<meta name="Author" content="Geetha CR">
	
		<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
		
	</head>
<%
	alAutoclavingList.clear();

	String	 bean_id			=	 "autoclavingListBean";
	String	 bean_name			=	 "eSS.AutoclavingListBean";

	AutoclavingListBean bean	=	(AutoclavingListBean) getBeanObject( bean_id, bean_name, request );  
	bean.clear();
	bean.setMode(request.getParameter("mode"));
	putObjectInBean(bean_id,bean,request);

%>
	<frameset rows='130,*'>
		<frame name='frameAutoclavingHeader' id='frameAutoclavingHeader'				src="../../eSS/jsp/AutoclavingHeader.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='no'   noresize>
<%if (bean.getMode().equals(bean.getCommonRepositoryValue("MODE_MODIFY")) ){ //UPDATE MODE%>
		
		<frame name='frameAutoclavingList' id='frameAutoclavingList'			src="../../eSS/jsp/AutoclavingList.jsp?<%=request.getQueryString()%>"					frameborder=0 scrolling='auto' noresize>
<%}else{%>
		
		<frame name='frameAutoclavingList' id='frameAutoclavingList'			src="../../eCommon/html/blank.html?<%=request.getQueryString()%>"					frameborder=0 scrolling='auto' noresize>
<%}%>
		</frameset>
</html>

