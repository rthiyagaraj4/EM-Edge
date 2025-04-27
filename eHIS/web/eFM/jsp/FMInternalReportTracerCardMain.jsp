<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");
	String url = "../../eFM/jsp/FMInternalReportReprintMain.jsp?ReportName=" ;
	String report_name = request.getParameter("ReportName");
	String source = url + report_name ;
%>

<html>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script src="../../eCommon/js/ValidateControl.js"></script>
	<script src="../../eFM/js/FMInternalReportReprint.js" language="javascript"></script>
 <head>
<iframe name='TracerRecordsearchFrame' id='TracerRecordsearchFrame' src='<%=source%>' scrolling='NO' frameborder=0 noresize style='height:38%;width:100vw'></iframe>
	<iframe name='TracerRecordsearchResultFrame' id='TracerRecordsearchResultFrame' src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:62%;width:100vw'></iframe>


