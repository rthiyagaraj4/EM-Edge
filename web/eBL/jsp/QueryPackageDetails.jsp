<!DOCTYPE html>
 <!doctype html public "-//W3C//DTD HTML 4.0 Transitional//EN">
<!-- Author - kumar: called from VisitRegistrationQuery.jsp if package exists for the patient-->
<%@  page  contentType="text/html;charset=UTF-8" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<%
	request.setCharacterEncoding("UTF-8");
	String patientid = request.getParameter("patient_id");
	//String mode = request.getParameter("mode");
%>
<head>
<title><fmt:message key="eBL.AVAILABLE_PACKAGE.label" bundle="${bl_labels}"/></title>
<!--
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link>
	-->
		<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
<!--
	<script language="javascript" src="../../eCommon/js/messages.js"></script>
-->
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<iframe src="QueryPackageDtls.jsp?<%=request.getQueryString()%>" name="package_frame" id="package_frame" frameborder=0 scrolling='yes' noresize  style='height:84vh;width:100vw'></iframe>
<iframe src="PackageDetailsClose.jsp" name="close_frame" id="close_frame" frameborder=0 scrolling='no' noresize style='height:16vh;width:100vw'></iframe>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<FORM name = "packageFrm" METHOD=POST ACTION="">
<INPUT TYPE="hidden" name = "patient_id" value = "<%=patientid%>">
</FORM>
</body>
</html>

