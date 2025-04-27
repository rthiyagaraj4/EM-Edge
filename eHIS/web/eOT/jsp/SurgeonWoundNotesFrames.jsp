<!DOCTYPE html>
<%@ page import = "eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends
%>
<% String params = request.getQueryString(); 
	String tab_id = request.getParameter("tab_id");
	
%>

<% if(tab_id.equals("wound_tab")){ 	%>
	<iframe name='RecordFrame' id='RecordFrame' SRC='../../eOT/jsp/WoundRecord.jsp?<%=params%>'  scrolling='no' noresize='no' style='height:55vh;width:100vw;border:0'></iframe> 
	<iframe name='DetailFrame' id='DetailFrame' SRC='../../eCommon/html/blank.html'   scrolling='auto' noresize='no' style='height:45vh;width:100vw;border:0'></iframe>
	
<% } else if(tab_id.equals("notes_tab")) {  %>
   <iframe name='RecordFrame' id='RecordFrame' SRC='../../eOT/jsp/SurgeonNotesRecord.jsp?<%=params%>'  scrolling='no' noresize='no' style='height:100vh;width:100vw;border:0'></iframe> 
   <iframe name='DetailFrame' id='DetailFrame' SRC='../../eCommon/html/blank.html'   scrolling='no' noresize='no' style='height:0vh;width:100vw;border:0'></iframe>
 
<%}%>

