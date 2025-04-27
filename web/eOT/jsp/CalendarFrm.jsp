<!DOCTYPE html>

<%@ page import = "eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8"); 
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends
   System.err.println("********************* Params in Calender Frm :"+request.getQueryString());
%>
<html>
<iframe name='schedule_hdr' id='schedule_hdr'	src="../../eOT/jsp/CalendarButton.jsp?<%=request.getQueryString()%>" scrolling=no noresize style='height:8vh;width:98vw; border-left-width: 0px;border-top-width: 0px;border-right-width: 0px;border-bottom-width: 0px;'></iframe>
<iframe name='schdule_dtl' id='schdule_dtl' src="../../eOT/jsp/Calenderslot.jsp?<%=request.getQueryString()%>" noresize  scrolling='auto' style='height:82vh;width:98vw; border-left-width: 0px;border-top-width: 0px;border-right-width: 0px;border-bottom-width: 0px;'></iframe>
</html>

