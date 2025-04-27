<!DOCTYPE html>


<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% request.setCharacterEncoding("UTF-8");	%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<% 
	String params=request.getQueryString(); 
	String patient_id = request.getParameter("patient_id");
	String patient_name = request.getParameter("patient_name");
	patient_name=java.net.URLDecoder.decode(patient_name,"UTF-8");
%>

<%
String  AnaesthesiaNotes =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.AnaesthesiaNotes.Label","ot_labels");
%>

<title><%=AnaesthesiaNotes%> -<%=patient_id+" "+patient_name%> </title>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></SCRIPT>
	<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<iframe name='HdrFrame' id='HdrFrame' SRC='../../eOT/jsp/AT_AnaesthesiaHdr.jsp?function_name=Anesthesia Notes'  scrolling='no' noresize style='height:5vh;width:95vw;border=0'></iframe>
	<!-- <hr color=red> -->
	<iframe name='tab_frame' id='tab_frame' SRC='../../eOT/jsp/AT_AnaesthesiaHistoryNotesTab.jsp?<%=params%>'  scrolling='no' noresize frameborder='0' style='height:6vh;width:95vw;border=0'></iframe>
	<iframe name='TitleFrame' id='TitleFrame' SRC='../../eCommon/html/blank.html'  scrolling='no' noresize frameborder='0' style='height:5vh;width:95vw;border=0'></iframe>
	<iframe name='ResultFrame' id='ResultFrame' SRC='../../eCommon/html/blank.html'  scrolling='auto' noresize frameborder='0' style='height:70vh;width:95vw;border=0'></iframe>
	<iframe name="messageFrame" id="messageFrame" src="../../eCommon/jsp/error.jsp"  noresize scrolling="no" frameborder='0' style="height:9vh;width:95vw;border=0"></iframe>

</html>

