<!DOCTYPE html>
<%
/*
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*   File Name		:	CancelWorkScheduleFrameset.jsp
*	Purpose 			:
*	Created By		:	Sreenivasulu.Y
*	Created On		:	16 Nov 2004
*/
%>
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<title><fmt:message key="eRS.CancelWorkSchedule.label" bundle="${rs_labels}"/></title>
    <script language="JavaScript" src="../../eCommon/js/common.js"></script>
 	<script language="JavaScript" src="../js/RSCommon.js"></script>
	<script language="javascript" src="../js/CancelWorkSchedule.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<iframe name='frameCanWrkSchCriteria' id='frameCanWrkSchCriteria' src="../../eRS/jsp/CancelWorkScheduleCriteria.jsp?<%=request.getQueryString()%>" frameborder=0	scrolling='no' noresize style='height:31vh;width:100vw'></iframe>
	<iframe name='frameCanWrkSchHdr' id='frameCanWrkSchHdr' src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:4vh;width:100vw'></iframe>
	<iframe name='frameCanWrkSchResult' id='frameCanWrkSchResult' src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:65vh;width:100vw'></iframe>

</html>

