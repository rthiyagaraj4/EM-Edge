<!DOCTYPE html>
 <!--saved on 27th Oct 2005 -->
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<html>
<head>
	<!-- <LINK REL="stylesheet" TYPE="text/css" HREF="../../eCommon/html/IeStyle.css"></LINK> -->
	
	<SCRIPT LANGUAGE="JavaScript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<script language="JavaScript" src="../../ePH/js/Prescription_2.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	

<%
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
	String params		= request.getQueryString() ;
	String title		= request.getParameter("title");
	String mode			= request.getParameter("mode"); 
	
%>
<title><%=title%></title>
</head>

	<iframe name='remarks_detail' id='remarks_detail'  frameborder="0" scrolling='auto' noresize src="../../ePH/jsp/PrescriptionAmendRemarksDetails.jsp?<%=params%>" style="height:85vh;width:100vw"></iframe>
<%
if(mode!=null && ( mode.equals("allergy") || mode.equals("over_dose") || mode.equals("curr_rx") ) ){
%><iframe name="remarks_close" id="remarks_close" src="../../ePH/jsp/PrescriptionClose.jsp?called_from=amendremarks" frameborder="0" noresize scrolling="no" style="height:15vh;width:100vw"></iframe>
<%
}else{
%>
<iframe name="remarks_close" id="remarks_close" src="../../ePH/jsp/PrescriptionClose.jsp?called_from=refill" frameborder="0" noresize scrolling="no" style="height:15vh;width:100vw"></iframe>
<%
}
%>

</html>

