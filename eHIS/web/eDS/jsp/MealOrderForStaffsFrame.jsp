<!DOCTYPE html>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%-- Mandatory declarations end --%>

<%@page import = "eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends
%>
<html>
<head>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel="StyleSheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script language="javascript" src="../../eDS/js/MealOrderForStaffs.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	String params = request.getQueryString();
%>
<script>
var mealOrderArray=new Array();
var rowVal=0;
</script>

<iframe name="tab_frame" id="tab_frame" frameborder="0" scrolling="no" noresize src="../../eDS/jsp/MealOrderForStaffsTabs.jsp?<%=params%>" style="height:10vh;width:100vw"></iframe>
<iframe name="details_frame" id="details_frame" frameborder="0" scrolling="no" noresize src="../../eCommon/html/blank.html" style="height:80vh;width:100vw"></iframe>
<form name="MealOrderForStaffsForm" id="MealOrderForStaffsForm">
	<input type='hidden' name='params' id='params' value='<%=params%>'>
	<input type='hidden' name='mealOrderItemsArray' id='mealOrderItemsArray' value=''>
</form>
</html>

