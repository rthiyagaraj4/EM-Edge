<!DOCTYPE html>
<%@ page import = "eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>

<html>
	<head>
 	<script language='javascript' src='../../eOT/js/ListItems.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>

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
		String list_id=request.getParameter("list_id");
	%>

		<iframe name='MasterFrame' id='MasterFrame' src='../../eOT/jsp/ListItemsAddModify.jsp??<%=source%>&update_mode_yn=<%=update_mode_yn%>&list_id=<%=list_id%>' frameborder=0 style='height:13vh;width:97vw' scrolling='no'></iframe>
		<iframe name='hidden_frame' id='hidden_frame' src='../../eOT/jsp/ListItemsObjectCollect.jsp?<%=source%>' frameborder=0 style='height:3vh;width:0vw'></iframe>
		<iframe name='header' id='header' src='../../eOT/jsp/ListItemsHeader.jsp?<%=source%>' frameborder=0 scrolling='no' noresize style='height:4vh;width:97vw'></iframe>
		<iframe name='RecordFrame' id='RecordFrame' src='../../eOT/jsp/ListItemsRecord.jsp?<%=source%>
		&update_mode_yn=<%=update_mode_yn%>&list_id
		=<%=list_id%>' frameborder=0 scrolling='no' noresize style='height:12vh;width:97vw'></iframe>
		<!--<frame name='DetailFrame' src='../../eOT/jsp/ListItemsDetailForm.jsp?<%=update_mode_yn%>&list_id=<%=list_id%>' frameborder=0 scrolling='no' noresize>-->
		<iframe name='DetailFrame' id='DetailFrame' src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:55vh;width:97vw'></iframe>
	
</html>
