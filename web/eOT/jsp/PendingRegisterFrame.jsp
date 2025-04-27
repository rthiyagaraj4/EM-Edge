<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>
<html>
<%
   String strOrderId=request.getParameter("orderid");
	strOrderId=strOrderId==null?"":strOrderId;
	String param="orderid="+strOrderId;
	%>
<iframe name='OtPatientLineFrame' id='OtPatientLineFrame' src="../../eOT/jsp/OTPatLineFrame.jsp?<%=request.getQueryString()%>"  scrolling='no'  style='height:12vh;width:100vw'></iframe>
<iframe name='commontoolbarFrame' id='commontoolbarFrame' src="../../eOT/jsp/OperationProcedureHdr.jsp?<%=request.getQueryString()%>"  scrolling='no' nowrap style='height:55vh;width:100vw'></iframe>
<iframe name='message_search_frame' id='message_search_frame'	 src="../../eOT/jsp/PendingProcedureDtl.jsp?<%=param%>" style='height:33vh;width:100vw'></iframe>
</html>

