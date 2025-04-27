<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"  %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
String patient_id = request.getParameter("patient_id"); 
String photoCount = request.getParameter("photoCount");
String facility_id = request.getParameter("facility_id");
String user_id = request.getParameter("user_id");
String ws_no = request.getParameter("ws_no");
%>
<html>
<head>

	<title>Capture Blood Donor Photo</title>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link>
	<script language="JavaScript" src="../../eBT/js/ViewPatDetails.js"></script>
	<script language='javascript' src='../../eCommon/js/common.js' ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<iframe name='criteria_frame' id='criteria_frame' src='../../eBT/jsp/photo_upload.jsp?patient_id=<%=patient_id%>&photoCount=<%=photoCount%>&facility_id=<%=facility_id%>&user_id=<%=user_id%>&ws_no=<%=ws_no%>' frameborder=0 scrolling='no' noresize style='height:80vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='no' style='height:20vh;width:100vw'></iframe>
</html>

