<!DOCTYPE html>
<%
/*  							 
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name       Rev.Date	Rev.Name 		Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           							created

26/11/2014	IN050580		Nijitha 								MO-CRF-20080
---------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		
	</head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>

	 <frameset id="NotesReferralTrackingMainFrame"  name="NotesReferralTrackingMainFrame" rows='42%,65%,5%' >
	
		<frame name="refferalTrackingNotesSearch"  id="refferalTrackingNotesSearch" src='../../eCA/jsp/CANotesReferralTrackingSearch.jsp?<%=request.getQueryString()%>' frameborder='0' scrolling='no' noresize>
		<frameset name="NotesRefferralTracking" id="NotesRefferralTracking" cols="49%,51%">
		<frame name="refferalTrackingNotesRefferedFrom" id="refferalTrackingNotesRefferedFrom" src="" frameborder='0' >
		<frame name="refferalTrackingNotesRefferedTo" id="refferalTrackingNotesRefferedTo" src=''  frameborder='0' >
		</frameset>
		<frame name="refferalTrackingNotesPrint" id="refferalTrackingNotesPrint" src='../../eCA/jsp/CANotesReferralTrackingToolBar.jsp?<%=request.getQueryString()%>' frameborder='0' scrolling='no' noresize>
	</frameset>
	
	
</html>
