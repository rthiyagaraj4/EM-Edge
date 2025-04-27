<!DOCTYPE html>
<!-- 	Function Name VisitRegistration
	Created by M.Sathis Kumar on 13/12/2000 -->
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eOP/js/VisitRegistration.js'></script>
	<script Language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<title><fmt:message key="Common.LastVisitDetails.label" bundle="${common_labels}"/></title>
</head>
<%
	String 	l_encounter_id 		= request.getParameter("encounter_id");
	String 	l_service_encounter_id 	= request.getParameter("service_encounter_id");
%>
	<iframe name='LastVisitDetails1' id='LastVisitDetails1' src='../../eOP/jsp/VisitRegistrationLastVisitDetails1.jsp?encounter_id=<%=l_encounter_id%>&service_encounter_id=<%=l_service_encounter_id%>' frameborder=no scrolling='no' noresize style='height:15vh;width:100vw'></iframe>
		<iframe name='LastVisitDetails2' id='LastVisitDetails2' src='../../eOP/jsp/VisitRegistrationLastVisitDetails2.jsp?encounter_id=<%=l_encounter_id%>&service_encounter_id=<%=l_service_encounter_id%>' frameborder=no scrolling='no' noresize style='height:85vh;width:100vw'></iframe>
	
</html>

