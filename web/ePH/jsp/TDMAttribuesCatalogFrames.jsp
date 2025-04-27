<!DOCTYPE html>

<%@page contentType="text/html;charset=UTF-8" import="java.util.*,ePH.*, ePH.Common.*,eCommon.XSSRequestWrapper" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
%>

<HTML>
<HEAD>
	<!-- <LINK REL="stylesheet" TYPE="text/css" HREF="../../eCommon/html/IeStyle.css"></LINK> -->
<!-- 	
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/messages.js"></SCRIPT> -->
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../js/PhCommon.js"></SCRIPT>
<!-- 	<SCRIPT LANGUAGE="javascript" SRC="../js/PhMessages.js"></SCRIPT> -->
	<SCRIPT language="Javascript" src="../../ePH/js/TDMAttributes.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<TITLE><fmt:message key="ePH.LaboratorySearch.label" bundle="${ph_labels}"/></TITLE>
	</HEAD>
	<iframe name="TDM_attribute_ordercatalog_header" id="TDM_attribute_ordercatalog_header" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="../../ePH/jsp/TDMAttribuesCatalogHdr.jsp?<%=request.getQueryString()%>" style="height:10vh;width:98vw"></iframe>
	<iframe name="TDM_attributes_ordercatalog_details" id="TDM_attributes_ordercatalog_details" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="../../ePH/jsp/TDMAttribuesCatalog.jsp?<%=request.getQueryString()%>" style="height:82vh;width:98vw"></iframe>
</HTML>

