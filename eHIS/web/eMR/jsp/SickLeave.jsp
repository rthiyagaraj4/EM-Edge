<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	request.setCharacterEncoding("UTF-8");
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script language='javascript' src='../../eMR/js/SickLeave.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<iframe name='commontoolbarFrame' id='commontoolbarFrame' src="<%= source %>" frameborder=0 scrolling='no'  style='height:6vh;width:100vw'></iframe>
<iframe name='searchFrame' id='searchFrame' src='../../eMR/jsp/SickLeaveMain1.jsp?step=2&call_from=MAIN' frameborder=0 scrolling='no' style='height:4vh;width:100vw'></iframe>
<iframe name='patientLine' id='patientLine' src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' style='height:7vh ;width:100vw'></iframe>
<iframe name='workAreaFrame' id='workAreaFrame' 	 src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' style='height:74vh;width:100vw'></iframe>
<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:9vh;width:100vw'></iframe>
</html>

