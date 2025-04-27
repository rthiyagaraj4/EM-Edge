<!DOCTYPE html>
<%@ page import = "eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<html>
	<head>
		<script language='javascript' src='../../eOT/js/setcomponents.js'></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
 	<%@ page session="false" %>
	</head>
	<%
	    String source=request.getParameter("source");
		String update_mode_yn = request.getParameter("update_mode_yn");
		update_mode_yn=update_mode_yn==null?"insert":update_mode_yn;
		update_mode_yn=update_mode_yn.equals("null")?"insert":update_mode_yn;
		
		String instr_code=request.getParameter("instr_code");
	%>

		<iframe name='MasterFrame' id='MasterFrame' src='../../eOT/jsp/SetComponentsAddModify.jsp?<%=source%>&update_mode_yn=<%=update_mode_yn%>&instr_code=<%=instr_code%>' frameborder=0 scrolling='no' style='height:7vh;width:97vw'></iframe>
		<iframe name='hidden_frame' id='hidden_frame' src='../../eOT/jsp/SetComponentsObjectCollect.jsp?<%=source%>' frameborder=0 style='height:4vh;width:0vw'></iframe>
		<iframe name='header' id='header' src='../../eOT/jsp/SetComponentsHeader.jsp?<%=source%>' frameborder=0 scrolling='no' noresize style='height:4vh;width:97vw'></iframe>
		<iframe name='RecordFrame' id='RecordFrame' src='../../eOT/jsp/SetComponentsRecord.jsp?<%=source%>
		&update_mode_yn=<%=update_mode_yn%>&instr_code
		=<%=instr_code%>' frameborder=0 scrolling='no' noresize style='height:19vh;width:97vw'></iframe>
		<iframe name='DetailFrame' id='DetailFrame' src='../../eOT/jsp/SetComponentsDetailForm.jsp?<%=update_mode_yn%>&instr_code=<%=instr_code%>' frameborder=0 scrolling='auto' style='height:65vh;width:97vw' noresize></iframe>


</html>
