<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<title><fmt:message key="eRS.CancelShifts.label" bundle="${rs_labels}"/></title>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../../eRS/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<!-- <script language="JavaScript" src="../../eCommon/js/messages.js"></script> -->
<!-- <script language="javascript" src="../../eCommon/js/MstCodeCommon.js"></script>
 --><!-- <script language="javascript" src="../../eRS/js/CpMessages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
<iframe name='ViewScheduleFrame' id='ViewScheduleFrame' src='../../eRS/jsp/ManageWorkScheduleViewStaffDaySchedule.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling='no' noresize style='height:20vh;width:100vw'></iframe>
	 <iframe name='ManageWorkScheduleCancel_Frame' id='ManageWorkScheduleCancel_Frame' 	src='../../eRS/jsp/ManageWorkScheduleCancel.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling='no' noresize style='height:80vh;width:100vw'></iframe>
	 <iframe name='MessageFrame' id='MessageFrame' src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' noresize style='height:0vh;width:100vw'></iframe>

</head>
</html>

