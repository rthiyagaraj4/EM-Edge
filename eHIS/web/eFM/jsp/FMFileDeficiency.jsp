<!DOCTYPE html>
<!-- Developed By	   :-	Prashant Bhalsingh
	 Created on   	   :	21/06/2001
	 Module Name 	   :	FM\Reports FMFileDeficinecy.
-->
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;	
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
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src="../../eFM/js/FMFileDeficiencyReport.js" language="javascript"></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
 <head>
<iframe name='commontoolbarFrame' id='commontoolbarFrame'      src='<%=source%>' scrolling='NO' frameborder=0  noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='searchFrame' id='searchFrame' src='../../eFM/jsp/FMFileDeficiencySearch.jsp'	scrolling='NO' frameborder=0 noresize style='height:18vh;width:100vw'></iframe>
	<iframe name='searchResultFrame' id='searchResultFrame' src='../../eCommon/html/blank.html' frameborder=0 scrolling='NO' noresize style='height:62vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' scrolling='NO' frameborder='0' noresize style='height:12vh;width:100vw'></iframe>


