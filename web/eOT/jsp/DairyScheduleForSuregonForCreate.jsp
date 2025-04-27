<!DOCTYPE html>
<%@ page import = "eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<html>
	<head>
 	<script language='javascript' src='../../eOT/js/DairyScheduleForSuregon.js'></script>
	<script language='javascript' src='../../eOT/js/Hashtable.js'></script>
	<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
 	<!-- <%@ page session="false" %> -->
	</head>
	<%
	    String source=request.getQueryString();
		/*String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
		String params = request.getQueryString() ;
		String source = url + params ;*/
		String update_mode_yn = checkForNull(request.getParameter("update_mode_yn"));
		String oper_room_code=request.getParameter("oper_room_code");
		/*String wd_start_time=request.getParameter("wd_start_time");
		String wd_end_time=request.getParameter("wd_end_time");
		String hd_start_time=request.getParameter("hd_start_time");
		String hd_end_time=request.getParameter("hd_end_time");*/
		
	%>

		<iframe name='MasterFrame' id='MasterFrame' src='../../eOT/jsp/DairyScheduleForSuregonMain.jsp?<%=source%>&update_mode_yn=<%=update_mode_yn%>&oper_room_code=<%=oper_room_code%>' frameborder=0 scrolling='no' noresize style='height:5vh;width:97vw'></iframe>
			<iframe name='hidden_frame' id='hidden_frame' src='../../eOT/jsp/DairyScheduleForSuregonObjectCollect.jsp?<%=source%>' frameborder=0 noresize style='height:4vh;width:0vw'></iframe>
			<iframe name='header' id='header' src='../../eOT/jsp/DairyScheduleForSuregonHeader.jsp?<%=source%>' frameborder=0 scrolling='no' noresize style='height:4vh;width:97vw'></iframe>
			<iframe name='RecordFrame' id='RecordFrame' src='../../eOT/jsp/DairyScheduleForSuregonRecord.jsp?<%=source%>&update_mode_yn=<%=update_mode_yn%>&oper_room_code=<%=oper_room_code%>' frameborder=0 scrolling='no' noresize style='height:24vh;width:97vw'></iframe>			
			<iframe name='DetailFrame' id='DetailFrame' src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:58vh;width:97vw'></iframe>
</html>
