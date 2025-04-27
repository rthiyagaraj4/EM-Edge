<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<title><fmt:message key="eCA.ViewClinicalNote.label" bundle="${ca_labels}"/></title>

<%
request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

</head>
<frameset rows='100%' framespacing='0'>
	
<frame name="ViewClinicalNoteNoteContentMainDetailFrame" id="ViewClinicalNoteNoteContentMainDetailFrame"   noresize src="../../eCommon/html/blank.html">
</frame>

</frameset>

</html>

