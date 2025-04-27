<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<title><fmt:message key="eMR.MaintainDeathRegister.label" bundle="${mr_labels}"/></title>
</head>
<%
	request.setCharacterEncoding("UTF-8");
	String encounterid=request.getParameter("encounter_id");
	String call_from=request.getParameter("call_from");
	if (call_from==null) call_from="";
	String practitioner_id=request.getParameter("practitioner_id");
	if (practitioner_id==null) practitioner_id="";
%>
<iframe src="../../eMR/jsp/addModifyDeathRegistration.jsp?encounter_id=<%=encounterid%>&call_from=<%=call_from%>" name="Header_frameq" scrolling='no' frameborder = '2' noresize style='height:25%;width:100vw'></iframe>
	<iframe src="../../eMR/jsp/addDiag.jsp?Encounter_Id=<%=encounterid%>&call_from=<%=call_from%>&practitioner_id=<%=practitioner_id%>" name="Diagnosis_frame" scrolling='auto' noresize  frameborder = '2' >
	<iframe src="../../eMR/jsp/recordDiag.jsp" name="RecordDiag_frame" id="RecordDiag_frame" scrolling='no' frameborder = '1' noresize style='height:*%;width:100vw'></iframe>
	<iframe src="../../eCommon/jsp/error.jsp" name="Dummy_frame" id="Dummy_frame" scrolling='no' noresize style='height:5%;width:100vw'></iframe>

</html>

