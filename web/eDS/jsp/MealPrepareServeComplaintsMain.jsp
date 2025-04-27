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
	<script language="javascript" src="../../eDS/js/MealPreparedServedComplaints.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
     //Checkstyle Violation commented by Munisekhar
	//String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	  String params = request.getQueryString() ;
	  params=params+"&function_id=DS_MEAL_COMPLAINTS";
	//String source = url + params ;
%>

<iframe name="tab_frame" id="tab_frame" frameborder="0" scrolling="no" noresize src="../../eDS/jsp/MealPrepareServeComplaintsTabs.jsp?<%=params%>" style="height:9vh;width:99vw"></iframe>
<iframe name="header_frame" id="header_frame" frameborder="0" scrolling="no" noresize src="../../eDS/jsp/MealPrepareServeComplaintsHeader.jsp?<%=params%>" style="height:11vh;width:99vw"></iframe>
<iframe name="meal_tab_frame" id="meal_tab_frame" frameborder="0" scrolling="no" noresize src="../../eDS/jsp/MealPrepareServeComplaintsTabFrames.jsp?<%=params%>" style="height:72vh;width:99vw"></iframe>
<iframe name="dummy" id="dummy" src='../../eCommon/html/blank.html' frameborder="0" noresize scrolling="no" style='height:6vh;width:99vw'></iframe>
<form name="MealPrepareServeComplaintsForm" id="MealPrepareServeComplaintsForm">
	<input type='hidden' name='params' id='params' value='<%=params%>'>
</form>
</html>

