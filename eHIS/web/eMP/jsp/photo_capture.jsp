<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
	request.setCharacterEncoding("UTF-8");%>
<% String patient_id = request.getParameter("patient_id"); %>
<HTML>
<HEAD>
<title> <fmt:message key="eMP.CapturePatientPhoto.label" bundle="${mp_labels}"/></title>
<script language="JavaScript" src="../../eMP/js/ViewPatDetails.js"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>

<BODY onUnLoad='window.returnValue="close"' onKeyDown='lockKey()'>
<html>
<OBJECT classid="clsid:ED804A50-F421-4E01-B055-2C2C193F70B3" name="PhotoCapture"></OBJECT>
<!-- <a onClick="Terminate_Capture()"> Close </a> -->
<script>
try{	
	PhotoCapture.Initialize_Patient_ID("<%=patient_id%>");	
}catch(e){
	alert(getMessage("CAM_DRV_INS","common"));
	window.returnValue="close";
	window.close();
}
	function Terminate_Capture() {
		PhotoCapture.Terminate_Capture();
		window.close();
	}
</script>
</html>
</BODY>
</HTML>

