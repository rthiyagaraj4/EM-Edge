<!DOCTYPE html>
<!--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Purpose 		:
*	Created By		:	Suresh.S
*	Created On		:	16 Oct 2004
-->
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<title><fmt:message key="eRS.WorkPlaceRequirement.label" bundle="${rs_labels}"/></title>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../js/RSCommon.js"></script>
<!-- <script language="javascript" src="../../eCommon/js/messages.js"></script> -->
<script language="javascript" src="../js/WorkplaceRequirement.js"></script>
</head>
<%
	String mode= request.getParameter("mode");
	if(mode.equalsIgnoreCase("2"))
	{
%>

<iframe name='frameWorkPlaceSearch' id='frameWorkPlaceSearch' src="../../eRS/jsp/WorkPlaceRequirementAddModify.jsp?<%=request.getQueryString()%>" 	frameborder=0	scrolling='no' noresize style='height:25vh;width:100vw'></iframe>
<iframe name='frameWorkPlaceHdr' id='frameWorkPlaceHdr' src="../../eRS/jsp/WorkplaceRequirementHdr.jsp?<%=request.getQueryString()%>" 
frameborder=0 scrolling='auto' noresize style='height:9vh;width:100vw'></iframe>
<iframe name='frameWorkPlaceResult' id='frameWorkPlaceResult' src="../../eRS/jsp/WorkplaceRequirementResult.jsp?<%=request.getQueryString()%>"
frameborder=0 scrolling='auto' noresize style='height:66vh;width:100vw'></iframe>

<%
	}
%>

