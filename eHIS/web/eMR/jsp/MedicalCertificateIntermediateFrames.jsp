<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"  %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% request.setCharacterEncoding("UTF-8"); %>
<html>

<head>
<Title><fmt:message key="Common.PreviousEncounters.label" bundle="${common_labels}"/></Title>
	<script language='javascript' src='../../eCommon/js/common.js'>
	
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

   
<%
try{
String patientid		= (request.getParameter("PatientId")==null)?"":request.getParameter("PatientId") ;		
String call_function		= (request.getParameter("call_from")==null)?"":request.getParameter("call_from") ;


%>
</head>
	<iframe name="DiagDetail_frame" id="DiagDetail_frame"  src="../../eMR/jsp/MedRecRequestResult.jsp?call_from=<%=call_function%>&PatientId=<%=patientid%>" frameborder='0' scrolling='auto' noresize  style="height:55vh;width:100vw" >
<iframe name='dup_display' id='dup_display' src='../../eCommon/html/blank.html' frameborder='0' scrolling='auto' noresize ></iframe>
	
</html>

<%}
catch(Exception ex){
	ex.printStackTrace();
}
%>

