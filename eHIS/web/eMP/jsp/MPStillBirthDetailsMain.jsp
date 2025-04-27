<!DOCTYPE html>
<%@page import="java.util.*,java.sql.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head> 

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

String quer_str=request.getQueryString();


%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eMP/js/MPStillBirthDetails.js'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'> </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
</head>
<title><fmt:message key="eMP.StillBirthDtls.label" bundle="${mp_labels}"/></title>
  <iframe name='f_add_mod' id='f_add_mod' src="../../eMP/jsp/MPStillBirthDetails.jsp?<%=quer_str%>" frameborder=0  noresize style='height:100vh;width:100vw'></iframe>
		<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='no' style='height:0vh;width:100vw'></iframe> 
</html>

