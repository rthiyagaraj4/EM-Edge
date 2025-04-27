<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<jsp:useBean id="EventBean" class="webbeans.eCommon.RecordSet" scope="session"/>
<%
request.setCharacterEncoding("UTF-8");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<html>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCA/js/ClinicalEventGroup.js'></script>
	<script src='../../eCommon/js/messages.js' language='javascript'></script>
</head>
<%
//		String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
//		String params = request.getQueryString() ;
//		String source = url + params ;
	
	%>

<html>
<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script language='javascript' src='../../eCA/js/ClinicalEventGroup.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<iframe name='batchcriteria' id='batchcriteria'	src="../../eCA/jsp/ClinicalEventGroupBatchEventCriteria.jsp" frameborder=0 scrolling='no' noresize style='height:30%;width:100vw'></iframe>
	<iframe name='batchbean' id='batchbean' 	src='../../eCommon/html/blank.html' frameborder=no scrolling='auto' style='height:70%;width:100vw'></iframe>
</html>

