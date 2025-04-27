<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!-- 
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History      	Name        		Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
20/01/2016	  	IN057193			Karthi L											Flag For Discharge Summary Not Done								
12/07/2017		IN061885			Raja S				13/07/2017		Ramesh G		ML-MMOH-CRF-0537
----------------------------------------------------------------------------------------------------------------------------------------------------------
-->
<%@page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<title>Pending Discharge Summary</title>
	
	<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

		Properties p = (Properties)session.getValue("jdbc");
		String locale				= (String) p.getProperty("LOCALE");
		String toDate = "";
		String frDate = "";
		toDate	= com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
		frDate	= com.ehis.util.DateUtils.minusDate(toDate,"DMY",locale,1,"M");
		String viewBy = request.getParameter("viewBy")==null?"":request.getParameter("viewBy");//Added for IN061885
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<iframe src="../../eCA/jsp/PendDiscSummCriteria.jsp?<%=request.getQueryString()%>"  name="PendDiscSummCriteriaFrame" border=0 scrolling=no noresize style="height:15%;width:100vw"></iframe> 
<!-- 	<frameset cols="200px,*" frameborder=0 > --> 
		<!--<iframe src="../../eCA/jsp/PendDiscSummDetails.jsp?fromDate=<%=frDate%>&ToDate=<%=toDate%>" name="PendDiscSummDetailsFrame" border=0 scrolling=auto noresize style="height:100vh;width:100vw"></iframe>  //Commented for IN061885 -->
		<iframe src="../../eCA/jsp/PendDiscSummDetails.jsp?fromDate=<%=frDate%>&ToDate=<%=toDate%>&viewBy=<%=viewBy%>" name="PendDiscSummDetailsFrame" border=0 scrolling=auto noresize style="height:6%;width:100vw"></iframe>
<!-- 	 -->
	</frameset>
</html>

