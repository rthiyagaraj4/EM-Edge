<!DOCTYPE html>
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Purpose 		:	
*	Created By		:	SuchilagnaPanigrahi
*	Created On		:	19 Feb 2005
--%>
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<title><fmt:message key="eRS.RecordOverTime.label" bundle="${rs_labels}"/></title>
<head>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<!-- <script language="javascript" src="../../eCommon/js/MstCodeCommon.js"></script>
 --><script language="JavaScript" src="../../eRS/js/ManageWorkScheduleOvertime.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<iframe name='blankFrame' id='blankFrame' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto' style='height:0vh;width:100vw'></iframe><iframe name='ManageWorkSchedule_viewStaff' id='ManageWorkSchedule_viewStaff' src='../jsp/ManageWorkScheduleViewStaffDaySchedule.jsp?<%=request.getQueryString()%>' frameborder=0  style='height:99vh;width:100vw'></iframe><iframe name='ManageWorkSchedule_Overtime' id='ManageWorkSchedule_Overtime' src='../jsp/ManageWorkScheduleOvertime.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling='auto' style='height:1vh;width:100vw'></iframe>
</html>

