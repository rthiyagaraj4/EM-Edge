<!DOCTYPE html>
<%@ page import = "eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends
%>
<iframe name='message_search_frame' id='message_search_frame' src='../../eOT/jsp/ProcedureHdrLegend.jsp'  scrolling='no'  style='height:15vh;width:99vw'></iframe>
<iframe name='detailframe' id='detailframe' src="../../eOT/jsp/BookingProcedureDtl.jsp?<%=request.getQueryString()%>"   scrolling='yes' nowrap noresize style='height:78vh;width:99vw'></iframe>



