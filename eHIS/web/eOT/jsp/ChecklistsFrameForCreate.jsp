<!DOCTYPE html>
<%@ page import = "eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<html>
	<head>
 	<script language='javascript' src='../../eOT/js/Checklistsmodified.js'></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<!-- <script language='JavaScript' src='../../eCommon/js/messages.js'></script>
	<script language='JavaScript' src='../../eOT/js/OTMessages.js'></script> -->

	</head>
	<%
	    String source=request.getParameter("source");
		/*String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
		String params = request.getQueryString() ;
		String source = url + params ;*/
		String update_mode_yn = request.getParameter("update_mode_yn");
		update_mode_yn=update_mode_yn==null?"insert":update_mode_yn;
		update_mode_yn=update_mode_yn.equals("null")?"insert":update_mode_yn;
		String checklist_code=request.getParameter("checklist_code");
	%>
		<iframe name='MasterFrame' id='MasterFrame'src='../../eOT/jsp/ChecklistsAddModify.jsp?<%=source%>&update_mode_yn=<%=update_mode_yn%>&checklist_code=<%=checklist_code%>' frameborder=0 scrolling='no' style='height:17vh;width:97vw'></iframe>
		<iframe name='hidden_frame' id='hidden_frame' src='../../eOT/jsp/ChecklistsObjectCollect.jsp?<%=source%>' frameborder=0 style='height:3vh;width:0vw'></iframe>
		<iframe name='header' id='header' src='../../eOT/jsp/ChecklistsHeader.jsp?<%=source%>' frameborder=0 scrolling='no' noresize style='height:4vh;width:97vw'></iframe>
		<iframe name='RecordFrame' id='RecordFrame' src='../../eOT/jsp/ChecklistsRecord.jsp?<%=source%>
		&update_mode_yn=<%=update_mode_yn%>&checklist_code=<%=checklist_code%>' frameborder=0 scrolling='no' noresize style='height:15vh;width:97vw'></iframe>
		<!--<frame name='DetailFrame' src='../../eOT/jsp/ChecklistsDetailForm.jsp?<%=source%>&update_mode_yn=<%=update_mode_yn%>&checklist_code=<%=checklist_code%>'  frameborder=0 scrolling='no' noresize> -->
		<iframe name='DetailFrame' id='DetailFrame' src='../../eCommon/html/blank.html'  frameborder=0 scrolling='auto' noresize style='height:55vh;width:97vw'></iframe>

	
</html>
