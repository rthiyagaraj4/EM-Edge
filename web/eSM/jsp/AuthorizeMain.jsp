<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title><fmt:message key="eSM.Auth_Screen.label" bundle="${sm_labels}"/></title>	<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
			<script language="javascript" src="../../eCommon/js/common.js"></script>
			<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>

<%
	String mode = request.getParameter("mode");
	if(mode==null) mode = "";
	//Added by Ajay for MMS-DM-CRF-0209.4 US04
	String func_id = request.getParameter("func_id");
	if(func_id==null) func_id="";
	String resp_id = request.getParameter("resp_id");
	if(resp_id == null) resp_id ="";

%>
<iframe SRC="AuthorizePage.jsp?resp_id=<%=resp_id %>&func_id=<%=func_id %>" name='AuthFrame1' id='AuthFrame1' frameborder=0 scrolling='no' noresize style='height:100vh;width:100vw'></iframe>
	<iframe SRC="../../eCommon/html/blank.html" frameborder=0 name='AuthDummyFrame' id='AuthDummyFrame' scrolling='no' noresize style='height:0vh;width:100vw'></iframe>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">	
</body>
</html>


