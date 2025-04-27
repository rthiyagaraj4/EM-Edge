<!DOCTYPE html>
 <!--saved on 27th Oct 2005 -->
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<html>
<head>
   <!--  <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
   
<!--     <script language="JavaScript" src="../js/PhMessages.js"></script> -->
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/PhCommon.js"></script>
	<script language="JavaScript" src="../../ePH/js/Prescription_1.js"></script>
	<script language="JavaScript" src="../../ePH/js/PrescriptionTest.js"></script>

 </head>
 <%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
 String params = request.getQueryString() ; 
 %>
	<!-- <frameset cols="27%,*" id="PrescriptionDetailFrameSet"> -->
				<iframe name="f_prescription" id="f_prescription" scrolling="no" noresize src="../../ePH/jsp/PrescriptionFormFrame.jsp?<%=params%>" class="CATHIRDWORKAREA"  style='height:30vh;width:100vw'></iframe>
			<!-- 	<frameset rows="*,20" > -->
					<iframe name="f_detail"  id="f_detail" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/PrescriptionDetail_1.jsp?<%=params%>" style='height:92vh;width:100vw'></iframe>
					<iframe name="f_button" id="f_button" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/PrescriptionButton_1.jsp?<%=params%>" style='height:5vh;width:100vw'></iframe>
				<!-- </frameset> -->
		<!-- </frameset> -->  
</html>

