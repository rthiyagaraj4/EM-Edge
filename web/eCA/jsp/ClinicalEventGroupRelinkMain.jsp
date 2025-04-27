<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<%
request.setCharacterEncoding("UTF-8");	
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";


%>
<html>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCA/js/ClinicalEventGroup.js'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
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

<iframe name='linkcri' id='linkcri'	src="../../eCA/jsp/ClinicalEventGroupRelinkCriteria.jsp" frameborder=no scrolling='no' noresize style='height:25%;width:100vw'></iframe>
	<iframe name='linkbean' id='linkbean' 	src='../../eCommon/html/blank.html' frameborder=no scrolling='auto' style='height:75%;width:100vw'></iframe>
</html>

