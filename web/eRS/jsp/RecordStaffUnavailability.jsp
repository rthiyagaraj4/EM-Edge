<!DOCTYPE html>

<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Purpose 		:	To display the 4 frames on click of the record cancel leave availabitlity
*	Created By		:	Subbulakshmky. k
*	Created On		:	23 Dec 2004
*	Modified By		:	Krishna Kiran 
*	Modified On		:	20 Aug 2009.

--%>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<html>
<head>
<!-- <script language="javascript" src="../js/RSMessages.js"></script> -->
<script language="javascript" src="../js/RecordStaffUnavailability.js"></script>
<SCRIPT language='javascript' src='../../eCommon/js/common.js' ></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;	

%> 
<iframe name="commontoolbarFrame" id="commontoolbarFrame" src='<%=source%>' frameborder=0 scrolling="no" noresize  style='height:6vh;width:100vw'></iframe><iframe name="frameRecordStaffUnavailabilityCriteria" id="frameRecordStaffUnavailabilityCriteria" src='../../eRS/jsp/RecordStaffUnavailabilityCriteria.jsp?callmode=M'frameborder=0 scrolling="no" noresize style='height:24vh;width:100vw'></iframe>
	<iframe name='staffCancelLeaveFrame' id='staffCancelLeaveFrame' src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:61vh;width:100vw'></iframe> 
	<iframe name="messageFrame" id="messageFrame" src="../../eCommon/jsp/error.jsp" frameborder=0 noresize scrolling="auto"  style="height:9vh;width:100vw"></iframe>
</html>

