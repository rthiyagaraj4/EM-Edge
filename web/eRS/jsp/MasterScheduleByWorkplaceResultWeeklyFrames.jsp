<!DOCTYPE html>
<%
/*
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*   File Name		:	MasterSheduleByWorkplaceResultWeeklyFrames.jsp
*	Purpose 		:
*	Created By		:	Subbulakshmy. K
*	Created On		:	24-11-2004
*/
%>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*, eRS.*,com.ehis.eslp.* " contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<title><fmt:message key="eRS.MasterScheduleByWorkplaceResultWeeklyFrames.label" bundle="${rs_labels}"/></title>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../js/RSCommon.js"></script>
<script language="javascript" src="../js/MasterSchedule.js"></script>
<!-- <script language="javascript" src="../js/RSMessages.js"></script>
<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
</head>
<iframe name='frameByWorkplaceResultHdr' id='frameByWorkplaceResultHdr' src='../../eRS/jsp/MasterScheduleWeekByWorkplaceResultHdr.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling="no" noresize style='height:10vh;width:100vw'></iframe>
<iframe name= "frameByWorkplaceResultWeekly" src='../../eRS/jsp/MasterScheduleByWorkplaceResultWeekly.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling='auto' noresize style='height:90vh;width:100vw'></iframe>

</html>

