<!DOCTYPE html>
<%@ page import= "java.net.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
<script>
function reset()
{
	frames[1].frames[1].document.AEBedAvailChartForm.reset();
	frames[1].frames[2].document.location.href = '../../eCommon/html/blank.html' ;
}
</script>
</head>
<%
	     request.setCharacterEncoding("UTF-8");
		 request= new XSSRequestWrapper(request);
		 response.addHeader("X-XSS-Protection", "1; mode=block");
		 response.addHeader("X-Content-Type-Options", "nosniff");
		
		String call_function		= "query";
		String clinic_code			= checkForNull(request.getParameter("clinic_code"));
		String treatment_area		= checkForNull(request.getParameter("treatment_area"));
		String bed_no				= checkForNull(request.getParameter("bed_no"));
		String patient_id			= checkForNull(request.getParameter("patient_id"));
		String age					= checkForNull(request.getParameter("age"));
		String gender				= checkForNull(request.getParameter("gender"));
		String where_condition		= checkForNull(request.getParameter("where_condition"));
		String bed_classification	= checkForNull(request.getParameter("bed_classification"));
		String bed_status			= checkForNull(request.getParameter("bed_status"));
		String select_check			= checkForNull(request.getParameter("select_check"));
		select_check = "N";
		String url    = "../../eCommon/jsp/commonToolbar.jsp?"; 
		String params = request.getQueryString() ;

		String source = url + params ;
	%>
	<title><fmt:message key="eAE.BedBayAvailabilityChart.label" bundle="${ae_labels}"/></title>
	<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%= source %> frameborder=0 scrolling='no' noresize style='height:6vh;width:100vw'></iframe>
		<iframe name='criteria0' id='criteria0' src='../../eAE/jsp/AEBedAvailabilityChart.jsp?call_function=<%=java.net.URLEncoder.encode(call_function)%>&clinic_code=<%=java.net.URLEncoder.encode(clinic_code)%>&treatment_area=<%=java.net.URLEncoder.encode(treatment_area)%>&bed_no=<%=java.net.URLEncoder.encode(bed_no)%>&patient_id=<%=java.net.URLEncoder.encode(patient_id)%>&age=<%=java.net.URLEncoder.encode(age)%>&gender=<%=java.net.URLEncoder.encode(gender)%>&where_condition=<%=java.net.URLEncoder.encode(where_condition)%>&bed_classification=<%=java.net.URLEncoder.encode(bed_classification)%>&bed_status=<%=java.net.URLEncoder.encode(bed_status)%>&select_check=<%=java.net.URLEncoder.encode(select_check)%>'  frameborder=0 scrolling='no' frameborder=0 style='height:84vh;width:100vw'></iframe>
		<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='no' style='height:8vh;width:100vw'></iframe>
</html>

<%!

public static String checkForNull(String inputString)
{
	return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
}

public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
}
%>

