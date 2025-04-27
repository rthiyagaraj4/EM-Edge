<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"  %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
String patient_id = request.getParameter("patient_id"); 
String photoCount = request.getParameter("photoCount");
%>
<html>
<head>
	<%String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<title><fmt:message key="eMP.CapturePatientPhoto.label" bundle="${mp_labels}"/></title>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language="JavaScript" src="../../eMP/js/ViewPatDetails.js"></script>
	<script language='javascript' src='../../eCommon/js/common.js' ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<!-- row size modified for smart card -->
<iframe name='criteria_frame' id='criteria_frame' src='../../eMP/jsp/photo_upload.jsp?patient_id=<%=patient_id%>&photoCount=<%=photoCount%>' frameborder=0 scrolling='no' noresize style='height:95vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='no' style='height:5vh;width:100vw'></iframe>
</html>

