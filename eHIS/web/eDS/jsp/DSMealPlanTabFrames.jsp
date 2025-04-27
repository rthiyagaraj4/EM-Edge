<!DOCTYPE html>



<%@  page import = "eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends %>
<html>
<head>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel="StyleSheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
	<%
		String params	= request.getQueryString();
		String tab_name = request.getParameter("tab_name") ;
		if(tab_name==null) tab_name="GenerateMealPlan";
		if(tab_name!=null && tab_name.equals("null")) tab_name="GenerateMealPlan";
		if(tab_name.equals("GenerateMealPlan")){
	%>
	<iframe name="record_details_frame" id="record_details_frame" frameborder="0" scrolling="no" noresize src="../../eDS/jsp/DSGenerateMealPlan.jsp?<%=params%>" style="height:65vh;width:100vw"></iframe>
	<iframe name="record_generate_meal_plan_hdr_frame" id="record_generate_meal_plan_hdr_frame" frameborder="0" scrolling="no" noresize src="../../eCommon/html/blank.html" style="height:3vh;width:100vw"></iframe>
	<%//MMS-DM-CRF-0044
	}else if(tab_name.equals("GenerateMealPlanAttendant")){
	%>
	<iframe name="record_details_frame" id="record_details_frame" frameborder="0" scrolling="no" noresize src="../../eDS/jsp/DSGenerateMealPlanAttendant.jsp?<%=params%>" style="height:65vh;width:100vw"></iframe>
	<iframe name="record_generate_meal_plan_hdr_frame" id="record_generate_meal_plan_hdr_frame" frameborder="0" scrolling="no" noresize src="../../eCommon/html/blank.html" style="height:3vh;width:100vw"></iframe>
	<%//MMS-DM-CRF-0044
	}else if(tab_name.equals("PrintMealDietList")){
	%>
	<iframe name="record_details_frame" id="record_details_frame" frameborder="0" scrolling="no" noresize src="../../eDS/jsp/GenerateMealPlanPrint.jsp?<%=params%>" style="height:65vh;width:100vw"></iframe>
	<iframe name="record_anethesia_details_hdr_frame" id="record_anethesia_details_hdr_frame" frameborder="0" scrolling="no" noresize src="../../eCommon/html/blank.html" style="height:3vh;width:100vw"></iframe>
	<%
	}else if(tab_name.equals("DischargedPatients")){
	%>
	<iframe name="record_details_frame" id="record_details_frame" frameborder="0" scrolling="no" noresize src="../../eDS/jsp/DSMealPlanDischarge.jsp?<%=params%>" style="height:22vh;width:100vw"></iframe>
	<iframe name="record_anethesia_details_hdr_frame" id="record_anethesia_details_hdr_frame" frameborder="0" scrolling="no" noresize src="../../eCommon/html/blank.html" style="height:3vh;width:100vw"></iframe>
	<%	
	}else if(tab_name.equals("DietOrderSheet")){
	%>
		<iframe name="record_details_frame" id="record_details_frame" frameborder="0" scrolling="no" noresize src="../../eDS/jsp/DSDietOrderSheet.jsp?<%=params%>" style="height:65vh;width:100vw"></iframe>
		<iframe name="record_anethesia_details_hdr_frame" id="record_anethesia_details_hdr_frame" frameborder="0" scrolling="no" noresize src="../../eCommon/html/blank.html" style="height:3vh;width:100vw"></iframe>
	<%
	}
	%>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name='DSMealPlanFrames' id='DSMealPlanFrames'>
</form>
</body>
</html>

