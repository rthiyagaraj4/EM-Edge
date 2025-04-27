<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>

<% request.setCharacterEncoding("UTF-8"); %>

<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language="JavaScript" src="../../eOT/js/OTCommon.js"></script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<script language="JavaScript" src="../../eOT/js/RecordNursing.js"></script>



<% String params = request.getQueryString(); %>
<iframe name='RecordFrame' id='RecordFrame' SRC='../../eOT/jsp/NursingTimeRecord.jsp?<%=params%>'  scrolling='yes' noresize='no' style='height:51vh;width:100vw;border:0'></iframe> 
<iframe name='DetailFrame' id='DetailFrame' SRC='../../eCommon/html/blank.html'   scrolling='auto' noresize='no' style='height:49vh;width:100vw;border:0'></iframe>
 

