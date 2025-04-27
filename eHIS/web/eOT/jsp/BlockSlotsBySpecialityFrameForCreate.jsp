<!DOCTYPE html>
<%@ page import = "eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<html>
	<head>
 	<script language='javascript' src='../../eOT/js/BlockSlotsBySpeciality.js'></script>
	<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
 	<!-- <%@ page session="false" %> -->
	</head>
	<%
	    String source=request.getQueryString();
		/*String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
		String params = request.getQueryString() ;
		String source = url + params ;*/
		String update_mode_yn = request.getParameter("update_mode_yn");
		update_mode_yn=update_mode_yn==null?"insert":update_mode_yn;
		update_mode_yn=update_mode_yn.equals("null")?"insert":update_mode_yn;
		String oper_room_code=request.getParameter("oper_room_code");
		String wd_start_time=request.getParameter("wd_start_time");
		String wd_end_time=request.getParameter("wd_end_time");
		String hd_start_time=request.getParameter("hd_start_time");
		String hd_end_time=request.getParameter("hd_end_time");
		
	%>
		<iframe name='MasterFrame' id='MasterFrame' src='../../eOT/jsp/BlockSlotsBySpecialityMain.jsp?<%=source%>&update_mode_yn=<%=update_mode_yn%>&oper_room_code=<%=oper_room_code%>' frameborder=0 scrolling='no' style='height:9vh;width:97vw'></iframe>
			<iframe name='hidden_frame' id='hidden_frame' src='../../eOT/jsp/BlockSlotsBySpecialityObjectCollect.jsp?<%=source%>' frameborder=0 style='height:2vh;width:0vw'></iframe>
			<iframe name='header' id=name='header' src='../../eOT/jsp/BlockSlotsBySpecialityHeader.jsp?<%=source%>' frameborder=0 scrolling='no' noresize style='height:4vh;width:97vw'></iframe>
			<iframe name='RecordFrame' id='RecordFrame' src='../../eOT/jsp/BlockSlotsBySpecialityRecord.jsp?<%=source%>&update_mode_yn=<%=update_mode_yn%>&oper_room_code=<%=oper_room_code%>&wd_start_time=<%=wd_start_time%>&wd_end_time=<%=wd_end_time%>&hd_start_time=<%=hd_start_time%>&hd_end_time=<%=hd_end_time%>' frameborder=0 scrolling='no' noresize style='height:20vh;width:97vw'></iframe>			
			<iframe name='DetailFrame' id='DetailFrame' src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:60vh;width:97vw'></iframe>
	
</html>
