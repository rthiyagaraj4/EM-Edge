<!DOCTYPE html>
<!--saved on 27th Oct 2005 -->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8" import="java.util.*, ePH.*,eOR.*, ePH.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>

<%-- Mandatory declarations start --%>
<%-- Mandatory declarations end --%>
<html>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	

	<script language="javascript" src="../js/PhCommon.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<!-- <script language="javascript" src="../js/PhMessages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
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
<iframe name="f_sliding_scale_dtls" id="f_sliding_scale_dtls" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/PrescriptionSlidingScaleDetail.jsp?<%=params%>" style="height:29vh;width:100vw"></iframe><iframe name="f_sliding_scale_remarks" id="f_sliding_scale_remarks" frameborder="0" scrolling="auto" noresize src="../../ePH/jsp/PrescriptionSlidingScaleTemplateFrame.jsp?<%=params%>" style="height:31vh;width:100vw"></iframe><iframe name="f_sliding_scale_admin_dtls" id="f_sliding_scale_admin_dtls" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/PrescriptionSlidingScaleAdmin.jsp?<%=params%>" style="height:40vh;width:100vw"></iframe>
</html>

