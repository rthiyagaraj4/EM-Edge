<!DOCTYPE html>
<%@page contentType="text/html; charset=UTF-8" import="java.util.*, ePH.*, eOR.*, ePH.Common.* ,eOR.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<script language="javascript" src="../../eCommon/js/common.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<title> <fmt:message key="ePH.DrugSearch.label" bundle="${ph_labels}"/></title>
</head>
<%
request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends

	String query_str	=	request.getQueryString(); 
%>
<iframe name="f_search_details" id="f_search_details" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/ADRReportingDrugLookUpSearch.jsp?<%=query_str%>" style="height:10vh;width:99vw"></iframe>
<iframe name="f_drug_details" id="f_drug_details" frameborder="0" scrolling="auto" noresize  src="../../eCommon/html/blank.html" style="height:83vh;width:99vw"></iframe>
</html>

