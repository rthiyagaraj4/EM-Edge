<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");  %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<html>
	<head>
		<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		
	</head>
<%
		String url="../../eCommon/jsp/commonToolbar.jsp?";
		String params = request.getQueryString() ;
		String source = url + params ;
		
		String request_id = checkForNull(request.getParameter("request_id"));
		String req_code = checkForNull(request.getParameter("req_code"));
		String req_type = checkForNull(request.getParameter("req_type"));
		req_code = req_code.trim();
	    req_type = req_type.trim();
		
%>
<title><fmt:message key="eMR.CheckListDetails.label" bundle="${mr_labels}"/></title>
<iframe name='f_query_add_mod' id='f_query_add_mod' 	src='../jsp/ChecklistAuditDetails.jsp?request_id=<%=request_id%>&req_code=<%=req_code%>&req_type=<%=req_type%>' frameborder=0 scrolling='auto' noresize style='height:100vh;width:100vw'></iframe>
	


</html>

<%!
	public static String checkForNull(String inputString){
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue){
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

