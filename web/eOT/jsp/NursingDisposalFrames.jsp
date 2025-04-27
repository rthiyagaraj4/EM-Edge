<!DOCTYPE html>
<%@page  contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<% 
	String params=request.getQueryString();
%>
<HTML>
<HEAD></HEAD>

<iframe name='RecordFrame' id='RecordFrame' SRC='../../eOT/jsp/NursingDisposalRecord.jsp?<%=params%>' noresize  scrolling='no' noresize='no' style="height:30vh;width:100vw;border:0"></iframe>
<!-- <FRAME name='DetailFrame' id='DetailFrame' SRC='../../eOT/jsp/NursingDisposalDtls.jsp?<%=params%>' scrolling='no' noresize='no'></FRAME> -->
<iframe name='DetailFrame' id='DetailFrame' SRC='../../eCommon/html/blank.html'   scrolling='yes' noresize='no' style="height:70vh;width:100vw;border:0"></iframe> 
</HTML>


