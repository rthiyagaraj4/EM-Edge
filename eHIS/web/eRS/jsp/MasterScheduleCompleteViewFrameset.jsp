<!DOCTYPE html>
<%
/*
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*   File Name		:	MasterSheduleCompleteViewFrameset.jsp
*	Purpose 			:
*	Created By		:	Subbulakshmy. K
*	Created On		:	24-11-2004
*/
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<title><fmt:message key="eRS.MasterSchedule.label" bundle="${rs_labels}"/> </title>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../js/RSCommon.js"></script>
<script language="javascript" src="../js/MasterSchedule.js"></script>
<!-- <script language="javascript" src="../js/RSMessages.js"></script>
<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
</head>
<iframe name= "frameCompleteViewHdr" src='../../eRS/jsp/MasterScheduleCompleteViewHdr.jsp' frameborder=0 scrolling='no' noresize style='height:3vh;width:100vw'></iframe>
<iframe name= "frameCompleteViewDetails" src='../../eRS/jsp/MasterScheduleCompleteView.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling='auto' noresize style='height:97vh;width:100vw'></iframe>

</html>

