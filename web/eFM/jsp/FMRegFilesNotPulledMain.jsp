<!DOCTYPE html>
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
	<script language='javascript' src='../../eFM/js/FMRegFilesNotPulled.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<iframe name='FMRegFilesNotPulledCriteriaFrame' id='FMRegFilesNotPulledCriteriaFrame' src='../../eFM/jsp/FMRegFilesNotPulledCriteria.jsp' frameborder='0' scrolling=no noresize style='height:15%;width:100vw'></iframe>
	<iframe name='FMRegFilesNotPulledResultFrame' id='FMRegFilesNotPulledResultFrame' src='../../eCommon/html/blank.html' scrolling='no' frameborder='0' noresize style='height:100vh;width:100vw'></iframe>

</html>

