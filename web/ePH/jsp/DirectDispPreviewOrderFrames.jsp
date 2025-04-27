<!DOCTYPE html>
 <%@page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper"%>


<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<script language="javascript" src="../../eCommon/js/common.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<title><fmt:message key="ePH.ViewOrder.label" bundle="${ph_labels}"/></title>
</head>
<%
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
	String query_str	=	request.getQueryString();
%>
<iframe name="f_patient_details" id="f_patient_details" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/DirectDispPreviewOrderPatDet.jsp?<%=query_str%>" style="height:13vh;width:99vw"></iframe>
<iframe name="f_drug_details" id="f_drug_details" frameborder="0" scrolling="auto" noresize  src="../../ePH/jsp/DirectDispPreviewOrderDrugDetails.jsp?<%=query_str%>" style="height:72vh;width:99vw"></iframe>
<iframe name="f_preview_buttons" id="f_preview_buttons" frameborder="0" scrolling="no" noresize  src="../../ePH/jsp/DirectDispPreviewOrderButtons.jsp?<%=query_str%>" style="height:5vh;width:99vw"></iframe>
</html>

