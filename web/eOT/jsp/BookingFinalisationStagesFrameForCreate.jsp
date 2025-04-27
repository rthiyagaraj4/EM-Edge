<!DOCTYPE html>
<%@ page import = "eCommon.XSSRequestWrapper,eCommon.Common.*" contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<html>
	<head>
 	<script language='javascript' src='../../eOT/js/BookingFinalisationStages.js'></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>

	<%@ page session="false" %>
	</head>
	<%
	    String source=request.getParameter("source");
		String update_mode_yn = request.getParameter("update_mode_yn");
		update_mode_yn=update_mode_yn==null?"insert":update_mode_yn;
		update_mode_yn=update_mode_yn.equals("null")?"insert":update_mode_yn;
		String stage_code=request.getParameter("stage_code");
		String specific_ind=request.getParameter("specific_ind");
		
	%>
<frameset rows='290,20,*'>
	<frame name='MasterFrame' src='../../eOT/jsp/BookingFinalisationStagesAddModify.jsp?<%=source%>&update_mode_yn=<%=update_mode_yn%>&stage_code=<%=stage_code%>' frameborder=0 scrolling='no'>
	<frameset cols='0,*'>
		<frame name='hidden_frame' src='../../eOT/jsp/BookingFinalisationStagesObjectCollect.jsp?<%=source%>' frameborder=0>
		<frame name='header' src='../../eOT/jsp/BookingFinalisationStagesHeader.jsp?<%=source%>' frameborder=0 scrolling='no' noresize>
	</frameset>
	<frameset rows='25%,*'>
		<frame name='RecordFrame' src='../../eOT/jsp/BookingFinalisationStagesRecord.jsp?<%=source%>
		&update_mode_yn=<%=update_mode_yn%>&stage_code
		=<%=stage_code%>&specific_ind=<%=specific_ind%>' frameborder=0 scrolling='no' noresize >
		<!--<frame name='DetailFrame' src='../../eOT/jsp/BookingFinalisationStagesDetailForm.jsp?<%=update_mode_yn%>&stage_code=<%=stage_code%>' frameborder=0 scrolling='no' noresize>-->
		<frame name='DetailFrame' src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize>
	</frameset>
</frameset>
	
</html>
