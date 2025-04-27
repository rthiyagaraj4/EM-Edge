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
	<script language='javascript' src='../../eOA/js/CopyTimeTable.js'></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<iframe name='query' id='query' src='../../eOA/jsp/CopyTimeTableCriteria.jsp' frameborder=0 scrolling=no noresize style='height:7vh;width:97vw'></iframe>
	<iframe name='qryresult' id='qryresult' src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' style='height:21vh;width:100vw'></iframe>
	<iframe name='dispresult' id='dispresult' src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' style='height:70vh;width:97vw'></iframe>
</html> 

