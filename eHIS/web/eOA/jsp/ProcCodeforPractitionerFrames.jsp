<!DOCTYPE html>
<!-- 
	Created 
		on 12/14/2010
		For Retunin 
		Function :Procedure Code For Practitioner
-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
 <%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	String url="../../eCommon/jsp/commonToolbar.jsp?";
	String params = request.getQueryString() ;
	String source = url + params ;
%>
<html>
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script language='javascript' src='../../eOA/js/ProcCodeforPractitioner.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
</html>
<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%=source%> frameborder='0' scrolling='no' noresize style='height:6vh;width:100vw'></iframe>
		<iframe scrolling="no" name='f_query_criteria_mod' id='f_query_criteria_mod' src='../../eOA/jsp/ProcCodeforPractitionerCriteria.jsp' noresize frameborder=0/ style='height:13vh;width:100vw'></iframe>
		<iframe scrolling="no" name='f_query_result_mod' id='f_query_result_mod' src='../../eCommon/html/blank.html'  noresize frameborder=0 noresize frameborder/ style='height:76vh;width:100vw'></iframe>
		<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:5vh;width:100vw'></iframe>
<%!	
	private String checkForNull(String inputString){
	return (inputString==null)	? "" : inputString;
}
	private String checkForNull(String inputString, String defaultValue){
	return (inputString==null)	? defaultValue : inputString;
}
%>

