<!DOCTYPE html>
<!--Created by Ashwini on 16-Dec-2019 for AAKH-CRF-0079.11-->
<%@page import="java.util.*,java.sql.* ,java.io.*, webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>

<title><fmt:message key="Common.Insurance.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Document.label" bundle="${common_labels}"/></title>

<head>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String patient_id = request.getParameter("patient_id");
	String encounter_id = request.getParameter("encounter_id");
	String serial_no = request.getParameter("serial_no");	
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>

<iframe name='' id='' src='../../eMP/jsp/MPUploadedDocumentView.jsp?patient_id=<%=patient_id%>&encounter_id=<%=encounter_id%>&serial_no=<%=serial_no%>' frameborder='0' scrolling='auto' noresize style='height:100vh;width:100vw'></iframe>


</html>

