<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<title><fmt:message key="eRS.SwapShifts.label" bundle="${rs_labels}"/></title>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<!-- <script language="JavaScript" src="../../eCommon/js/messages.js"></script> -->
<!-- <script language="javascript" src="../../eCommon/js/MstCodeCommon.js"></script>
 --><script language="JavaScript" src="../../eRS/js/ManageWorkScheduleSwap.js"></script>
<!-- <script language="JavaScript" src="../../eRS/js/RSMessages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
</head>

<iframe name='blankFrame' id='blankFrame' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' noresize style='height:0vh;width:100vw'></iframe>
<iframe name='ManageWorkSchedule_viewWokplaceShiftTimes' id='ManageWorkSchedule_viewWokplaceShiftTimes' src='../jsp/ManageWorkScheduleViewStaffDaySchedule.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling='no' noresize style='height:3vh;width:100vw'></iframe>
<iframe name='ManageWorkSchedule_frame' id='ManageWorkSchedule_frame' src='../jsp/ManageWorkScheduleSwap.jsp?<%=request.getQueryString()%>' frameborder=0 noresize scrolling='no' style='height:7vh;width:100vw'></iframe>
<iframe name='ManageWorkScheduleSwap_frame' id='ManageWorkScheduleSwap_frame' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' style='height:2vh;width:100vw'></iframe>
<iframe name='ManageWorkScheduleStaff2Shifts_frame' id='ManageWorkScheduleStaff2Shifts_frame' src='../../eCommon/html/blank.html' noresize frameborder=0 scrolling='auto' style='height:6vh;width:100vw'></iframe>
<iframe name='ManageWorkScheduleButtons_frame' id='ManageWorkScheduleButtons_frame' src='../../eCommon/html/blank.html' noresize frameborder=0 scrolling='auto' style='height:1vh;width:100vw'></iframe>
</html>

