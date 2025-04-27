<!DOCTYPE html>
 <!--saved on 27th Oct 2005 -->
<!-- 
Developed by	: P.Sudhakaran.
Module/Function : RefillDetailsFrame
-->
<%@page contentType="text/html; charset=UTF-8" import="java.util.*, ePH.*, eOR.*, ePH.Common.* ,eOR.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
	<title><fmt:message key="ePH.PrescriptionRemarks.label" bundle="${ph_labels}"/></title>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	
	<script language="JavaScript" src="../../ePH/js/Prescription_2.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
</head>
<%
request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
	String params = request.getQueryString() ; 

%>
<iframe name="remarks_detail" id="remarks_detail" frameborder="0" scrolling="auto" noresize src="../../ePH/jsp/PrescriptionAmendRemarksDetails.jsp?<%=params%>"" style="height:82vh;width:100vw"></iframe><iframe name="remarks_close" id="remarks_close" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/PrescriptionClose.jsp?called_from=amendremarks" style="height:18vh;width:100vw"></iframe>

</html>


