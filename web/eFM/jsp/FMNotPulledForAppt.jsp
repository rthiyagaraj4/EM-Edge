<!DOCTYPE html>
<!-- Developed By	   :-	Prashant Bhalsingh
	 Created on   	   :	21/06/2001
	 Module Name 	   :	FM\Reports FMNotPulledForAppt.
-->
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eFM/js/checkSystemDate.js'></script>	
	<script language='javascript' src='../../eFM/js/FMNotPulledForAppt.js'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
 <head>

<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;	
	String function_id		= "";
	function_id = request.getParameter("function_id");
%>


<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>' scrolling='NO' frameborder=0  noresize style='height:8vh;width:100vw'></iframe>
<iframe name='searchFrame' id='searchFrame' src='../../eFM/jsp/FMFileNotPulledForAppointment.jsp?function_id=<%=function_id%>'	scrolling='NO' frameborder=0 noresize style='height:30vh;width:100vw'></iframe>
<iframe name='searchResultFrame' id='searchResultFrame' src='../../eCommon/html/blank.html' frameborder=0 scrolling='NO' noresize style='height:50vh;width:100vw'></iframe>
<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' scrolling='NO' frameborder='0' noresize style='height:12vh;width:100vw'></iframe>


