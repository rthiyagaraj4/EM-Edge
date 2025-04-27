<!DOCTYPE html>
 <!--saved on 27th Oct 2005 -->
<%@page contentType="text/html; charset=UTF-8" import="java.util.*, ePH.*, eOR.*, ePH.Common.* ,eOR.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
    <!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	
	<title><fmt:message key="Common.DiagnosisDescription.label" bundle="${common_labels}"/></title>
 </head>
 <%
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
 String params = request.getQueryString() ; 
 %>
	<iframe name="f_active_order_details" id="f_active_order_details" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/PrescriptionDiagText.jsp?<%=params%>" style="height:85vh;width:100vw"></iframe><iframe name="f_close_frame" id="f_close_frame" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/PrescriptionClose.jsp?called_from=normal" style="height:15vh;width:100vw"></iframe>
</html>


