<!DOCTYPE html>
 <!--saved on 27th Oct 2005 -->
<!--saved on 25th Oct 2005 -->
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	
    <!-- <script language="JavaScript" src="../js/PhMessages.js"></script> -->
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../ePH/js/PhCommon.js"></script>
	<script language="JavaScript" src="../../ePH/js/Prescription_1.js"></script>
	<script language="JavaScript" src="../../ePH/js/PrescriptionTest.js"></script>
	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 </head>
 <%
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
//end.
	String params = request.getQueryString() ; 
	String mode=request.getParameter("mode");
	String bl_install_yn = request.getParameter("bl_install_yn")==null?"":request.getParameter("bl_install_yn");
	String bl_disp_charge_dtl_in_rx_yn = request.getParameter("bl_disp_charge_dtl_in_rx_yn")==null?"":request.getParameter("bl_disp_charge_dtl_in_rx_yn");
	if(mode!=null && mode.equals("amend")){
 %>
		<!-- <frameset rows="20,*,25%" > -->
			<iframe name="f_RX" id="f_RX" frameborder="0" scrolling="no" size="0" src="../../ePH/jsp/PrescriptionRxFrame.jsp" style='height:5vh;width:98vw'></iframe>
			<iframe name="f_prescription_form"  id="f_prescription_form" frameborder="0" scrolling="auto" noresize src="../../ePH/jsp/PrescriptionForm_2.jsp?<%=params%>" style='height:60vh;width:98vw'></iframe>
			<iframe name="f_preview" id="f_preview" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/PrescriptionAmendPreviewFrame.jsp?<%=params%>" style='height:30vh;width:98vw'></iframe>
		<!-- </frameset> -->
<%
	 }
	 else{
		if(bl_install_yn.equals("Y") && bl_disp_charge_dtl_in_rx_yn.equals("Y")){

%>
			<!-- <frameset rows="0,*,140"> -->
<%
		}
		else{
%>
			<!-- <frameset rows="0,*,83"> -->
<%
		}

%>
		<iframe name="f_RX" id="f_RX" frameborder="0" scrolling="no" size="0" src="../../ePH/jsp/PrescriptionRxFrame.jsp" style='height:5vh;width:98vw'></iframe>
		<iframe name="f_prescription_form" id="f_prescription_form" frameborder="0" scrolling="auto" noresize src="../../ePH/jsp/PrescriptionForm_1.jsp?<%=params%>" style='height:60vh;width:98vw'></iframe>
		<iframe name="f_RX" id="f_RX" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/PrescriptionPreviewFrame.jsp?<%=params%>" style='height:30vh;width:98vw'></iframe>
	<!-- </frameset> -->
<%
 }
%>
</html>

