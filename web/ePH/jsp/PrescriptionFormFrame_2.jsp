<!DOCTYPE html>
 <!--saved on 27th Oct 2005 -->
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	
    <!-- <script language="JavaScript" src="../js/PhMessages.js"></script> -->
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/PhCommon.js"></script>
	<script language="JavaScript" src="../js/Prescription_1.js"></script>
	<script language="JavaScript" src="../js/PrescriptionTest.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


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
	<iframe name="f_RX" id="f_RX" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/PrescriptionRxFrame.jsp" style="height:3vh;width:100vw"></iframe><iframe name="f_prescription_form" id="f_prescription_form" frameborder="0" scrolling="auto" noresize src="../../ePH/jsp/PrescriptionForm_2.jsp?<%=params%>" style="height:93vh;width:100vw"></iframe><iframe name="f_RX" id="f_RX" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/PrescriptionPreviewFrame.jsp?<%=params%>" style="height:4vh;width:100vw"></iframe>
</html>


