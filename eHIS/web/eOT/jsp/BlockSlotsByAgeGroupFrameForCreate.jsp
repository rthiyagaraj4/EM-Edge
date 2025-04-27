<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
 	<script language='javascript' src='../../eOT/js/BlockSlotsBySpeciality.js'></script>
	<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
	<script language='javascript' src='../../eOT/js/Hashtable.js'></script>
	</head>
	<%
		String params = request.getQueryString() ;
		//String oper_room_code=request.getParameter("oper_room_code");
		
	%>
	<frameset rows='90,20,*'>
		<frame name='MasterFrame' src='../../eOT/jsp/BlockSlotsByAgeGroupMain.jsp?' frameborder='0' scrolling='no'>
		<frameset cols='0,*'>
			<frame name='hidden_frame' src='../../eOT/jsp/BlockSlotsByAgeGroupObjectCollect.jsp' frameborder='0' >
			<frame name='header' src='../../eOT/jsp/BlockSlotsByAgeGroupHeader.jsp?' frameborder='0' scrolling='no' noresize>
		</frameset>
		<frameset cols='50%,50%'>
			<frame name='RecordFrame' src='../../eOT/jsp/BlockSlotsByAgeGroupRecord.jsp?<%=params%>'	 frameborder='0' scrolling='no' noresize >
			<frame name='DetailFrame' src='../../eCommon/html/blank.html' frameborder='0' scrolling='auto' noresize>
		</frameset>

	</frameset>
	
</html>
