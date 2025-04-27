<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<title><fmt:message key="eRS.ChangeShift.label" bundle="${rs_labels}"/></title>

<script language="javascript" src="../../eCommon/js/common.js"></script>
<!-- <script language="JavaScript" src="../../eCommon/js/messages.js"></script> -->
<!-- <script language="javascript" src="../../eCommon/js/MstCodeCommon.js"></script>
 --><script language="JavaScript" src="../../eRS/js/ManageWorkScheduleChange.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<iframe name='ManageWorkSchedule_viewWokplaceShiftTimes' id='ManageWorkSchedule_viewWokplaceShiftTimes' src='../jsp/ManageWorkScheduleViewStaffDaySchedule.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling='no' noresize  style='height:5vh;width:100vw'></iframe><iframe name='ManageWorkScheduleChange_frame' id='ManageWorkScheduleChange_frame' src='../jsp/ManageWorkScheduleChange.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling='no' style='height:13vh;width:100vw'></iframe><iframe name='blankFrame' id='blankFrame' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' style='height:0vh;width:100vw'></iframe>
</html>

