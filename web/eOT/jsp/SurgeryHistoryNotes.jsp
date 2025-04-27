<!DOCTYPE html>
<%@ page contentType=" text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<title><fmt:message key="Common.notes.label" bundle="${common_labels}"/></title>
<% String params=request.getQueryString(); %>
<iframe name='HdrFrame' id='HdrFrame' SRC='../../eOT/jsp/CommonNotesHdr.jsp'  scrolling='no' noresize style='height:3vh;width:97vw;border:0'></iframe>
	<iframe name='tab_frame' id='tab_frame' SRC='../../eOT/jsp/NotesTab.jsp?<%=params%>'  scrolling='no' noresize style='height:4vh;width:97vw;border:0'></iframe>
	<iframe name='TitleFrame' id='TitleFrame' SRC='../../eCommon/html/blank.html'  scrolling='no' noresize style='height:3vh;width:97vw;border:0'></iframe>
	<iframe name='ResultFrame' id='ResultFrame' SRC='../../eCommon/html/blank.html'  scrolling='auto' noresize style='height:77vh;width:97vw;border:0'></iframe>
	<iframe name="messageFrame" id="messageFrame" src="../../eCommon/jsp/error.jsp"  noresize scrolling="no" style="height:5vh;width:97vw;border:0"></iframe>

