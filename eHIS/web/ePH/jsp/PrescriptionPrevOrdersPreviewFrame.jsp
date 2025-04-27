<!DOCTYPE html>
 <%@page contentType="text/html; charset=UTF-8" import="java.util.*, ePH.*, eOR.*, ePH.Common.* ,eOR.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->

<script language="javascript" src="../../eCommon/js/common.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<title><fmt:message key="ePH.ViewOrder.label" bundle="${ph_labels}"/></title>
</head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	String query_str	=	request.getQueryString(); 
%>
<iframe name="f_drug_details" id="f_drug_details" frameborder="0" scrolling="auto" noresize  src="../../ePH/jsp/PrescriptionPrevOrdersPreview.jsp?<%=query_str%>" style="height:88vh;width:100vw"></iframe><iframe name="f_preview_buttons" id="f_preview_buttons" frameborder="0" scrolling="no" noresize  src="../../ePH/jsp/PrescriptionPreviewOrderButtons.jsp?<%=query_str%>" style="height:8vh;width:100vw"></iframe>
</html>

