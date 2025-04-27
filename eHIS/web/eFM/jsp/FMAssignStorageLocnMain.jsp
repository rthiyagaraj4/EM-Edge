<!DOCTYPE html>
<!--
	Developed by 	:	Prakash.S
	Created on 		:	10/06/2002
	Module			:	FM - Assign File Store Location
	Function		:	This function is used split into three frame structure.
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
	<script language='javascript' src='../../eFM/js/FMAssignStorageLocn.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<iframe name='FMAssnStrLocnCriteriaFrame' id='FMAssnStrLocnCriteriaFrame' src='../../eFM/jsp/FMAssignStorageLocnCriteria.jsp' frameborder='0' scrolling=no noresize style='height:20vh;width:99vw'></iframe>
<iframe name='FMAssnStrLocnSubResultFrame' id='FMAssnStrLocnSubResultFrame' src='../../eCommon/html/blank.html' frameborder='0' scrolling='no' style='height:6vh;width:100vw'></iframe>
<iframe name='FMAssnStrLocnMainResultFrame' id='FMAssnStrLocnMainResultFrame' src='../../eCommon/html/blank.html' scrolling='no' frameborder='0' noresize style='height:74vh;width:100vw'></iframe>

</html>

