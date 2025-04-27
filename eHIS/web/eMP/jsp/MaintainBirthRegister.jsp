<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" import ="java.sql.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
		request.setCharacterEncoding("UTF-8");
		String func_idpassed = request.getParameter("function_id")==null?"":request.getParameter("function_id");
		String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
		String params = request.getQueryString() ;
		String source = url + params;
		StringBuffer file_name = new StringBuffer() ;
		file_name.append("../../eMP/jsp/MaintainBirthRegisterFirst.jsp?func_idpassed=");
		file_name.append(func_idpassed);		

%>

<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
	<script src='../../eMP/js/NewbornRegistration.js' language='javascript'></script>
	<script src='../../eMP/js/NewbornRegistration1.js' language='javascript'></script>
	<script src='../../eMP/js/NewbornRegistration2.js' language='javascript'></script>
			
	<!-- <script language='javascript' src='../js/MaintainBirthRegistration.js'></script> -->
	<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>
<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%= source %> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
		<iframe name='f_query_add_mod' id='f_query_add_mod' 	src='<%=file_name.toString()%>' frameborder=0 style='height:83vh;width:100vw'></iframe>
		<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:9vh;width:100vw'></iframe>
</html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

