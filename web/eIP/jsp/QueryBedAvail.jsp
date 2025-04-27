<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");  %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script>
		function reset()
		{
			frames[1].frames[1].document.forms[0].reset();
			frames[1].frames[0].location.href='../../eCommon/html/blank.html';
			frames[1].frames[1].location.href ='../../eIP/jsp/BedAvailabilityChartCriteria0.jsp?P_call_func=QUERY_BED_AVAIL&wherecondn='+frames[1].frames[1].document.forms[0].wherecondn.value;
			frames[1].frames[2].location.href ='../../eCommon/html/blank.html';
		}
	</script>
</head>
<%
		String url="../../eCommon/jsp/commonToolbar.jsp?";
		String params = request.getQueryString() ;
		String source = url + params ;
%>
	<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%= source %> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
		<iframe name='f_query_add_mod' id='f_query_add_mod' 	src='../jsp/BedAvailabilityChart.jsp?P_call_func=QUERY_BED_AVAIL&enable_bed_date=Y' frameborder=0 scrolling='no' style='height:80vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:12vh;width:100vw'></iframe>
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

