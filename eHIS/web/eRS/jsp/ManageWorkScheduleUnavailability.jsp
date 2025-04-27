<!DOCTYPE html>
<%
/*
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*   File Name		:	ManageWorkSchedule.jsp
*	Purpose 			:
*	Created By		:	Subbulakshmy. K
*	Created On		:	17-12-2004
*/
%>
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<html>
<head>
<title><fmt:message key="eRS.StaffUnavailability.label" bundle="${rs_labels}"/></title>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<!-- <script language="JavaScript" src="../../eCommon/js/messages.js"></script> -->
<!-- <script language="javascript" src="../../eCommon/js/MstCodeCommon.js"></script>
 --><script language="JavaScript" src="../js/ManageWorkSchedule.js"></script>
<!-- <script language="JavaScript" src="../../eRS/js/RSMessages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
<iframe name='ViewScheduleFrame' id='ViewScheduleFrame' src='../../eRS/jsp/ManageWorkScheduleViewStaffDaySchedule.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling='no' noresize style='height:20vh;width:100vw'></iframe>
<iframe name='frameManageWorkScheduleUnavailability' id='frameManageWorkScheduleUnavailability' src='../../eRS/jsp/RecordStaffUnavailabilityCriteria.jsp?callmode=W&<%=request.getQueryString()%>' frameborder=0 scrolling='no' noresize style='height:80vh;width:100vw'></iframe>
<iframe name='messageFrame' id='messageFrame' src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' noresize style='height:0vh;width:100vw'></iframe>

</head>
</html>

