<!DOCTYPE html>
<%@page import = "eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>

<%
//Added Against MMS Vulnerability Issue - Starts
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
//Added Against MMS Vulnerability Issue - Ends 

String strOrderId=checkForNull(request.getParameter("orderid"));
if(strOrderId.equals("0")==false){%>
	<iframe name='message_search_frame' id='message_search_frame'
	src="../../eOT/jsp/BookingProcedureFrame.jsp?<%=request.getQueryString()%>"   scrolling='auto'   style='height:40vh;width:97vw' frameborder='0'></iframe>
	<iframe name='detailframe' id='detailframe' src="../../eOT/jsp/BookingCancel.jsp?<%=request.getQueryString()%>" scrolling='auto' frameborder='0'  nowrap style='height:45vh;width:99vw'></iframe>
<%}else{%>
<iframe name='message_search_frame' id='message_search_frame'
src="../../eOT/jsp/BookingProcedureFrame.jsp?<%=request.getQueryString()%>"   scrolling='no'   style='height:92vh;width:99vw' frameborder='0'></iframe>
<%}%>

