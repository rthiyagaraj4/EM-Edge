<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language="JavaScript" src="../../eOT/js/OTCommon.js"></script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<script language="JavaScript" src="../../eOT/js/RecordNursing.js"></script>
<script language="JavaScript" src="../../eOT/js/Hashtable.js"></script>
<iframe name='RecordFrame' id='RecordFrame' SRC='../../eOT/jsp/ICDPCSRecord.jsp?<%=request.getQueryString()%>'  scrolling='no' noresize style='height:25vh;width:100vw;border=0'></iframe> 
<iframe name='DetailFrame' id='DetailFrame' SRC='../../eCommon/html/blank.html'   scrolling='auto' noresize style='height:66vh;width:100vw;border=0'></iframe>
<iframe name='displayframe' id='displayframe' SRC='../../eOT/jsp/ICDPCSRecordDtl.jsp?' scrolling='no' noresize style='height:9vh;width:100vw;border=0'></iframe>
 

