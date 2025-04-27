<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");
	String url	  = "../../eCommon/jsp/commonToolbar.jsp?";
	String params = request.getQueryString();
	String source = url + params; 
%>
<HTML>
	<HEAD>
		<!-- <LINK rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></LINK> -->
		<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<SCRIPT language='javascript' src='../../eCommon/js/common.js'></SCRIPT>
		<SCRIPT language='javascript' src='../../eCommon/js/ValidateControl.js'></SCRIPT>
		<SCRIPT language='javascript' src='../../eFM/js/QueryFMFileEncounterDetails.js'></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</HEAD>
	<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>' frameborder='0' scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
		<iframe name='QFMFEDSearchFrame' id='QFMFEDSearchFrame' src='../../eFM/jsp/QueryFMFileEncounterDetailsSearch.jsp'  frameborder='0' scrolling='auto' noresize style='height:14vh;width:100vw'></iframe>
		<iframe name='QFMFEDResultFrame' id='QFMFEDResultFrame' src='../../eCommon/html/blank.html' frameborder='0' scrolling='auto' noresize style='height:69vh;width:100vw'></iframe>
		<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder='0' scrolling='no' noresize style='height:9vh;width:100vw'></iframe>
	
</HTML>

