<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="eCommon.XSSRequestWrapper" %>
<%	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>

<html>
<head>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eOR/js/MultiPatientOrders.js"></script>
 	<script language="JavaScript" src="../../eOR/js/OrCommon.js"></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<%@ page session="false" %>
	<script>
		function_id = "<%=request.getParameter("function_id")%>";
	</script>

</head>
<iframe name='frameMultiPatientOrdersHdr' id='frameMultiPatientOrdersHdr' src="../../eOR/jsp/MultiPatientOrdersHdr.jsp?<%=request.getQueryString()%>" frameborder='0' noresize scrolling='no'style="height:15vh;width:100vw">
	</iframe>

	<iframe name="frameMultiPatientOrdersHdrDtl" id="frameMultiPatientOrdersHdrDtl" src="../../eCommon/html/blank.html"  noresize frameborder='0' scrolling='auto' style="height:5vh;width:100vw">
	</iframe>

	<iframe name="frameMultiPatientOrdersHdrResult" id="frameMultiPatientOrdersHdrResult" src="../../eCommon/html/blank.html"frameborder='0' noresize
	scrolling="auto" style="height:65vh;width:100vw">
	</iframe>

	<iframe name='frameMultiPatientOrdersTool' id='frameMultiPatientOrdersTool' src="../../eCommon/html/blank.html" frameborder='0' noresize scrolling='no' style="height:6vh;width:100vw">
	</iframe>


</html>

