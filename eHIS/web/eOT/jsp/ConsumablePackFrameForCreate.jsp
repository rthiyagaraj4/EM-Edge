<!DOCTYPE html>


<%@ page import = "eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>

<html>
	<head>
 	<script language='javascript' src='../../eOT/js/SwabAndInstrumentsTemplate.js'></script>
	<!-- <script language='JavaScript' src='../../eCommon/js/messages.js'></script>
	<script language='JavaScript' src='../../eOT/js/OTMessages.js'></script> -->
 	<%@ page session="false" %>
	</head>
	<%
	    String source=request.getParameter("source");
		/*String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
		String params = request.getQueryString() ;
		String source = url + params ;*/
		String update_mode_yn = request.getParameter("update_mode_yn");
		update_mode_yn=update_mode_yn==null?"insert":update_mode_yn;
		update_mode_yn=update_mode_yn.equals("null")?"insert":update_mode_yn;
		String package_code=request.getParameter("package_code");
	%>
	<frameset rows='125,25,*'>
		<frame name='MasterFrame' src='../../eOT/jsp/ConsumablePackAddModify.jsp??<%=source%>&update_mode_yn=<%=update_mode_yn%>&package_code=<%=package_code%>' frameborder=0 scrolling='no'>
		<frameset cols='0,*'>
		<frame name='hidden_frame' src='../../eOT/jsp/ConsumablePackObjectCollect.jsp?<%=source%>' frameborder=0>
		<frame name='header' src='../../eOT/jsp/ConsumablePackHeader.jsp?<%=source%>' frameborder=0 scrolling='no' noresize>
	</frameset>
	<frameset rows='15%,*'>
		<frame name='RecordFrame' src='../../eOT/jsp/ConsumablePackRecord.jsp?<%=source%>
		&update_mode_yn=<%=update_mode_yn%>&package_code
		=<%=package_code%>' frameborder=0 scrolling='no' noresize >
		<frame name='DetailFrame' src='../../eOT/jsp/ConsumablePackDetailForm.jsp?<%=update_mode_yn%>&package_code=<%=package_code%>' frameborder=0 scrolling='auto' noresize>
	</frameset>

	</frameset>
	
</html>
