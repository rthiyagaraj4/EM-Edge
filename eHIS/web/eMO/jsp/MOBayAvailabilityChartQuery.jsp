<!DOCTYPE html>
<html>
<%@ page import= "java.net.*"   contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<head>
</head>
<%
     	request.setCharacterEncoding("UTF-8");
		String area_code		    = checkForNull(request.getParameter("area_code"));
		String patient_id			= checkForNull(request.getParameter("patient_id"));
		String where_condition		= checkForNull(request.getParameter("where_condition"));
		String bed_status			= checkForNull(request.getParameter("bed_status"));
		
		String url    = "../../eCommon/jsp/commonToolbar.jsp?"; 
		String params = request.getQueryString() ;

		String source = url + params ;
	%>
	<script language='javascript' src='../../eMO/js/MOBayAvailability.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	<title>Bed/Bay Availability Chart</title>
	<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%= source %> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
		<iframe name='criteria0' id='criteria0' src='../../eMO/jsp/MOBayAvailabilityChart.jsp?area_code=<%=java.net.URLEncoder.encode(area_code)%>&patient_id=<%=java.net.URLEncoder.encode(patient_id)%>&where_condition=<%=java.net.URLEncoder.encode(where_condition)%>&bed_status=<%=java.net.URLEncoder.encode(bed_status)%>'  frameborder=0 scrolling='no' frameborder=0 style='height:83vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp&err_num=' frameborder=0 noresize scrolling='no' style='height:9vh;width:100vw'></iframe>
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

