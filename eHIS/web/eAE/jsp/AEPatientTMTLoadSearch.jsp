<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper"%>
<html>
<head>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript' ></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
<%
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
%>
<iframe name='AEPatientTMTSearchFrame' id='AEPatientTMTSearchFrame' src='../../eAE/jsp/AEPatientTMTSearch.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling='no' noresize style='height:28vh;width:100vw'></iframe>
	<iframe name='AEPatientTMTResultFrame' id='AEPatientTMTResultFrame' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto' style='height:74vh;width:100vw'></iframe><iframe name='AEMPLegendFrame' id='AEMPLegendFrame' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' style='height:5vh;width:100vw'></iframe>
<body onMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>

</body>
</html>

