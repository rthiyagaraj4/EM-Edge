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
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
//end.
	String params = request.getQueryString() ;  

%>
<iframe name="f_sliding_scale_hdr" id="f_sliding_scale_hdr" frameborder="0" scrolling="" noresize src="../../ePH/jsp/PrescriptionSlidingScaleRemarks.jsp?<%=params%>" style="height:38vh;width:100vw"></iframe><iframe name="f_sliding_scale_dtls" id="f_sliding_scale_dtls" frameborder="0" scrolling="auto" noresize src="../../ePH/jsp/PrescriptionSlidingScaleTmplDtl.jsp?<%=params%>" style="height:62vh;width:100vw"></iframe>
</html>

