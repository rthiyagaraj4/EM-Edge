<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %> 
<%request.setCharacterEncoding("UTF-8");%>

<html>
<head>
<Script src="../js/PatientRegistration.js" language="JavaScript"></Script>
<Script src="../js/PatientRegistration1.js" language="JavaScript"></Script>
<Script src="../js/PatientRegistration2.js" language="JavaScript"></Script>
<Script src="../js/PatientRegistration3.js" language="JavaScript"></Script>
<Script src="../js/ChangePatientDetails.js" language="JavaScript"></Script>
<%@ page session="false" %>
<title>
    <fmt:message key="eMP.ChgPatDtl.title.label" bundle="${mp_labels}"/>
</title>
</head>

<%
String pat_id = request.getParameter("pat_id");
String source = request.getParameter("source");

%>

<frameset rows='47,*,50'>
    <frame name='commontoolbarFrame'    src=<%=source%> frameborder=0 scrolling='no' noresize>
<frameset rows='51,*'>
    <frame name='patient_main'  frameborder=0 scrolling='no' noresize src='../jsp/ChangePatientHeader.jsp?patient_id=<%=pat_id%>' >
    <frame name='patient_sub' frameborder=0 scrolling='no' noresize src="../jsp/ChangePatientSub.jsp?patient_id=<%=pat_id%>" >
</frameset>
    <frame name='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto'>
</frameset>
</html>
