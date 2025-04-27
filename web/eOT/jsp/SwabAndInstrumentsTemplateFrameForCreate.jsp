<!DOCTYPE html>
<%@ page import = "eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>

<html>
	<head>
 	<script language='javascript' src='../../eOT/js/SwabAndInstrumentsTemplate.js'></script>
	<!-- <script src="../../eCommon/js/messages.js" language="javascript"></script>
	<script src="../../eOT/js/OTMessages.js" language="javascript"></script> -->
 	<%@ page session="false" %>
	</head>
	<%
	    String source=checkForNull(request.getParameter("source"),request.getQueryString());
		/*String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
		String params = request.getQueryString() ;
		String source = url + params ;*/
		
		String update_mode_yn = checkForNull(request.getParameter("update_mode_yn"),"insert");
		String template_id=checkForNull(request.getParameter("template_id"));
	%>
		<iframe name='MasterFrame' id='MasterFrame' src='../../eOT/jsp/SwabAndInstrumentsTemplateAddModify.jsp?<%=source%>&update_mode_yn=<%=update_mode_yn%>&template_id=<%=template_id%>' frameborder=0 style='height:17vh;width:97vw' scrolling='no'></iframe>
		<iframe name='hidden_frame' id='hidden_frame' src='../../eOT/jsp/SwabAndInstrumentsTemplateObjectCollect.jsp?<%=source%>' frameborder=0 style='height:3vh;width:0vw'></iframe>
		<iframe name='header' id='header' src='../../eOT/jsp/SwabAndInstrumentsTemplateHeader.jsp?<%=source%>' frameborder=0 scrolling='no' style='height:3vh;width:97vw'  noresize></iframe>
		<iframe name='RecordFrame' id='RecordFrame' src='../../eOT/jsp/SwabAndInstrumentsTemplateRecord.jsp?<%=source%>
		&update_mode_yn=<%=update_mode_yn%>&template_id
		=<%=template_id%>' frameborder=0 scrolling='no' noresize style='height:15vh;width:97vw'></iframe>
		
		<iframe name='DetailFrame' id='DetailFrame' src='../../eCommon/html/blank.html?<%=update_mode_yn%>&template_id=<%=template_id%>' frameborder=0 style='height:59vh;width:97vw' scrolling='auto' noresize></iframe>
	
</html>
