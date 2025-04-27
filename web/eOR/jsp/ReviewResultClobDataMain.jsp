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
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created	
27/06/2013	  IN041228		Ramesh G	 Review Results->Click on Result Hyperlink->Click on any Lab results->HTML tags displayed in Result
---------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<html>
<title><fmt:message key="Common.EventDetails.label" bundle="${common_labels}"/></title>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<iframe src="../../eOR/jsp/ReviewResultClobData.jsp?<%=request.getQueryString()%>" name="ReviewResultClobDataFrame"  scrolling="auto" frameborder="0" marginheight=0 marginwidth=0 style="height:90vh;width:100vw"></iframe>
<iframe src="../../eOR/jsp/ReviewResultClobDataButton.jsp" name="ReviewResultClobDataButtonFrame" id="ReviewResultClobDataButtonFrame"  scrolling="auto" frameborder="0" marginheight=0 marginwidth=0 style="height:10vh;width:100vw"></iframe>
</html>

