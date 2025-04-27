<!DOCTYPE html>
<!-- AuthorizeOrders.jsp -->
<%@ page contentType="text/html; charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
 <script language="JavaScript" src="../../eCommon/js/common.js"></script>
 	<script language="JavaScript" src="../js/PendingAppointment.js"></script>
 	<script language="JavaScript" src="../js/OrCommon.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<Title><fmt:message key="eOR.PendingAppointment.label" bundle="${or_labels}"/></Title>
 
<script>function_id = "<%=request.getParameter("function_id")%>";</script>

</head>
<%
//	String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
//	String params = request.getQueryString() ;
//	String source = url + params ;
String frmSum=request.getParameter("frmSum");
if(frmSum == null || frmSum.equals("null")) frmSum =""; else frmSum = frmSum.trim();
%>
<iframe name='CosignOrderTop' id='CosignOrderTop'	src='PendingAppointmentTop.jsp?frmSum=<%=frmSum%>' frameborder=0 scrolling='no' noresize style='height:15%;width:100vw'></iframe>
	<iframe name='CosignOrderBottom' id='CosignOrderBottom' src='../../eCommon/html/blank.html' frameborder=0 style='height:100vh;width:100vw'></iframe>
</html>

