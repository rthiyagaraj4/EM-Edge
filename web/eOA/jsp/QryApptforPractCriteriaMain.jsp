<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"  %>

<html>
<head>
<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'</link>
 -->
 <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
<iframe name='query' id='query' src='../../eOA/jsp/QryApptforPractCriteria.jsp' frameborder=no scrolling=no noresize style='height:15vh;width:97vw'></iframe>
	<iframe name='resultu' id='resultu'src='../../eCommon/html/blank.html' frameborder=no scrolling='auto' style='height:82vh;width:97vw'></iframe>
</html> 

