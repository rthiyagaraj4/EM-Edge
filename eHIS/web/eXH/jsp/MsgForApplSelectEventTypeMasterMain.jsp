<!DOCTYPE html>
<html>
<head>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<%String appl_id=request.getParameter("appl_id");%>
</head>
<iframe name='select_frame' id='select_frame' src='../../eXH/jsp/MsgForApplSelectEventTypeMaster.jsp?appl_id=<%=appl_id%>' frameborder=0 scrolling='no'  style='height:7vh;width:100vw'></iframe>
<iframe name='list_frame' id='list_frame' src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' style='height:93vh;width:100vw'></iframe>
</html>


