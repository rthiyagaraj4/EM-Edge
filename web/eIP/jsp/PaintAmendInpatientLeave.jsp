<!DOCTYPE html>
<!doctype html public "-//W3C//DTD HTML 4.0 Transitional//EN">
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
<title><fmt:message key="eIP.AmendInpatientLeave.label" bundle="${ip_labels}"/></title>
<script src="../js/AmendInpatientLeave.js" language="JavaScript"></Script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
<%
    request.setCharacterEncoding("UTF-8");
    String encounterid = request.getParameter("encounter_id");
    String facility_id = (String)session.getValue("facility_id");
%>
<iframe src="../../eCommon/jsp/pline.jsp?EncounterId=<%=encounterid%>&Facility_Id=<%=facility_id%>" name="PatientLine_frame" scrolling=NO noresize style="height:10vh;width:100vw"></iframe>
    <iframe src="../jsp/addModifyAmentInpatientLeave.jsp?<%=request.getQueryString()%>" name="Amend_frame" scrolling='no' noresize style='height:90vh;width:100vw'></iframe>

</html>

