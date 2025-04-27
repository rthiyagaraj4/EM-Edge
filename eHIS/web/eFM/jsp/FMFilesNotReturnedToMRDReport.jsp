<!DOCTYPE html>
<!-- Developed By	   :-	Prashant Bhalsingh
	 Created on   	   :	21/06/2001
	 Module Name 	   :	FM\Reports CodeList
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
	<script src="../../eCommon/js/ValidateControl.js"></script>
	<script src="../../eFM/js/FMFileNotReturnedToMRD.js" language="javascript"></script>
 <head>
<iframe name='commontoolbarFrame' id='commontoolbarFrame'      src='<%=source%>' scrolling='NO' frameborder=0  noresize style='height:9vh;width:100vw'></iframe>
	<iframe name='searchFrame' id='searchFrame' src='../../eFM/jsp/FMFileNotReturnedToMRDReportSearch.jsp'	scrolling='NO' frameborder=0 noresize style='height:15vh;width:100vw'></iframe>
	<iframe name='searchResultFrame' id='searchResultFrame' src='../../eCommon/html/blank.html' frameborder=0 scrolling='NO' noresize style='height:68vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' scrolling='NO' frameborder='0' noresize style='height:9vh;width:100vw'></iframe>


