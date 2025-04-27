<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<html>
<%@ page contentType="text/html;charset=UTF-8" %>
<head>
<title><fmt:message key="eMR.DeathRegistration.label" bundle="${mr_labels}"/></title>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
<%
	request.setCharacterEncoding("UTF-8");
	String patientid = request.getParameter("Patient_Id");
	String encounterid=request.getParameter("Encounter_Id");
	String call_from=request.getParameter("call_from");
	if (call_from==null) call_from="";
	String practitioner_id=request.getParameter("practitioner_id");
	if (practitioner_id==null) practitioner_id="";	

%>
<iframe src="../../eMR/jsp/addDiagnosis.jsp?practitioner_id=<%=practitioner_id%>" name="AddDiag_frame" scrolling='no' frameborder=1 noresize style='height:32%;width:100vw'></iframe>
<iframe src="../../eMR/jsp/addModifyDiag.jsp?encounter_id=<%=encounterid%>&call_from=<%=call_from%>" name="DiagDetail_frame" scrolling='yes' noresize  style='height:68%;width:100vw'></iframe>
</head>
<body onKeyDown = 'lockKey()'>
<FORM name = "Diag_dtl" METHOD=POST ACTION="">
<INPUT TYPE="hidden" name = "Encounter_Id" value = "<%=encounterid%>">
<INPUT TYPE="hidden" name = "Patient_Id" value = "<%=patientid%>">
</FORM>
</body>
</html>

