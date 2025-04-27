<!DOCTYPE html>
 <%@  page  contentType="text/html;charset=UTF-8" %>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
 <!doctype html public "-//W3C//DTD HTML 4.0 Transitional//EN">

 <!-- Author - kumar: called from VisitRegistrationQuery.jsp if outstanding amount exists for the patient-->
<html>
<head>
<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<title><fmt:message key="eBL.CREDIT_AUTH.label" bundle="${bl_labels}"/></title>
<%
	request.setCharacterEncoding("UTF-8");

	String patientid = request.getParameter("patient_id");
//	String outst_amt = request.getParameter("outst_amt");
%>
</head>
<iframe src="dispOutstAmt.jsp?<%=request.getQueryString()%>" name="Outstamt_frame" frameborder='0' scrolling='no' noresize  style='height:100vh;width:98vw'></iframe>
<iframe src="" name="dummy" id="dummy" frameborder='0' scrolling='no' noresize style='height:0vh;width:100vw'></iframe>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<FORM name = "disp_credit_auth" id = "disp_credit_auth" METHOD=POST ACTION="">
<INPUT TYPE="hidden" name = "patient_id" id="patient_id" value = "<%=patientid%>">
</FORM>
</body>
</html>

