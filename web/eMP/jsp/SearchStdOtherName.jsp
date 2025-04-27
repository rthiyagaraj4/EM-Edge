<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %> 
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<html>
<head>
<title><fmt:message key="eMP.searchothername.label" bundle="${mp_labels}"/></title>
<%
	request.setCharacterEncoding("UTF-8"); 
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String param_value = request.getParameter("param_value") == null?"":request.getParameter("param_value");
	String names_in_oth_lang = request.getParameter("names_in_oth_lang");	
	String field_lang = request.getParameter("field_lang");	
	if(names_in_oth_lang == null || names_in_oth_lang.equals("null"))
		names_in_oth_lang = "N";
		request.setCharacterEncoding("UTF-8");
		
%>
	<script src="../../eCommon/js/ValidateControl.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<iframe name='SearchCriteria' id='SearchCriteria'src="../jsp/SearchStdOtherNameCriteria.jsp?names_in_oth_lang=<%=names_in_oth_lang%>&param_value=<%=param_value%>&field_lang=<%=field_lang%>" noresize  frameborder=0 marginheight=0 marginwidth=0 SCROLLING=no style='height:23vh;width:95vw'></iframe>
	<iframe name='SearchSelection' id='SearchSelection' src='../../eCommon/html/blank.html' noresize  frameborder=no marginheight=0 marginwidth=0 SCROLLING=auto style='height:73vh;width:95vw'></iframe>
</head>
</html>

