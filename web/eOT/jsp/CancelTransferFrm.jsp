<!DOCTYPE html>

<%@ page import = "eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends
%>



<iframe name="f_query_add_mod" id="f_query_add_mod" frameborder="0" scrolling="no" noresize src="../../eOT/jsp/CancelTransferSearch.jsp?<%=request.getQueryString()%>" style='height:35vh;width:99vw'></iframe>

<iframe name='qa_query_result' id='qa_query_result' 		src="../../eCommon/html/blank.html" frameborder=0 style='height:64vh;width:99vw'></iframe>
<iframe name='qa_query_result_tail' id='qa_query_result_tail' src="../../eCommon/html/blank.html" frameborder=0 style='height:5vh;width:99vw'></iframe>


