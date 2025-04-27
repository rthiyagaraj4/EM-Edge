<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
<title><fmt:message key="eMO.ReleaseDeceasedBodyPart.label" bundle="${mo_labels}"/></title>
	<%
     String sStyle	=
    (session.getAttribute("PREFERRED_STYLE") != null) || (session.getAttribute("PREFERRED_STYLE") != "") ? (String)session.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
	request.setCharacterEncoding("UTF-8");

	%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eMO/js/MOReleaseDeceased.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>
	<%
	String param = request.getParameter("param");
	if(param == null || param.equals("null"))
		param = "";
	%>
	<iframe name='SearchFrameset' id='SearchFrameset' src="../../eMO/jsp/MOReleaseDeceasedSearch.jsp?function_id=MO_RELEASE_DECEASED&first=N&param=<%=param%>" frameborder='0' scrolling='no' style='height:100vh;width:100vw'></iframe><iframe name='msgFrame' id='msgFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:10%;width:100vw'></iframe><iframe name='dummyFrame' id='dummyFrame' src='' frameborder=0 noresize scrolling='no' style='height:0%;width:100vw'></iframe>
</html>

