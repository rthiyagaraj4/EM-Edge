<!DOCTYPE html>
 <!--saved on 27th Oct 2005 -->
<%@page contentType="text/html; charset=UTF-8" import="java.util.*, ePH.*, eOR.*, ePH.Common.* ,eOR.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
	request.setCharacterEncoding("UTF-8");
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
	String locale = (String) session.getAttribute("LOCALE");
	

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%> 

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language="javascript" src="../../eCommon/js/common.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<title><fmt:message key="ePH.ViewOrder.label" bundle="${ph_labels}"/></title>
</head>
<%
	String query_str	=	request.getQueryString();
	
%>
<iframe name="f_patient_details" id="f_patient_details" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/PrescriptionAmendPreviewOrdPatDet.jsp?<%=query_str%>" style="height:15vh;width:100vw"></iframe><iframe name="f_drug_details" id="f_drug_details" frameborder="0" scrolling="auto" noresize  src="../../ePH/jsp/PrescriptionAmendPreviewOrdDrugDet.jsp?<%=query_str%>" style="height:77vh;width:100vw"></iframe><iframe name="f_preview_buttons" id="f_preview_buttons" frameborder="0" scrolling="no" noresize  src="../../ePH/jsp/PrescriptionPreviewOrderButtons.jsp?<%=query_str%>" style="height:8vh;width:100vw"></iframe>
</html>

