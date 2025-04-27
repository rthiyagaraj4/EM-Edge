<!DOCTYPE html>

<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ include file="CommonInclude.jsp"%>

<%@ page contentType="text/html;charset=UTF-8" %> <%
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

		<script src='../../eCommon/js/common.js' language='javascript'></script>

<title><fmt:message key="Common.ReportOptions.label" bundle="${common_labels}"/></title>
<%
 request.setCharacterEncoding("UTF-8");	

	String params = request.getQueryString() ;
	if ( params == null ) params = "" ;	
	String report_options_source = "report_buttons.jsp?" + params ;	
%>
<iframe name="report_options" id="report_options"	src="report_options_form.jsp" scrolling="no" noresize frameborder="0" style="height:80vh;width:90%" frameborder='0'></iframe>
<iframe name="report_buttons" id="report_buttons"	src="<%= report_options_source %>" scrolling="no" noresize frameborder="0" style="height:15vh;width:90%" frameborder='0'></iframe>


