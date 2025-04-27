<!DOCTYPE html>
<%@ page import = "eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");  
   //Added Against MMS Vulnerability Issue - Ends 
%>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language="JavaScript" src="../../eOT/js/OTCommon.js"></script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<script language="JavaScript" src="../../eOT/js/Recordsurgeon.js"></script>



<% String params = request.getQueryString(); %>
 <iframe name="notes_tab" id="notes_tab" scrolling="no" noresize src="../../eOT/jsp/RecordSurgeonNotesTab.jsp?<%=params%>" style="height:8vh;width:100vw;border:0"></iframe>
 <iframe name='ChildBaseFrame' id='ChildBaseFrame' SRC='../../eCommon/html/blank.html'   scrolling='no' noresize='no' style='height:92vh;width:100vw;border:0'></iframe>


