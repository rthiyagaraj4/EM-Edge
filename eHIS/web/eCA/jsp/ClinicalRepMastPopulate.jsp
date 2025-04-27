<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<html>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCA/js/ClinicalRepMast.js'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	
</head>
<html>
<%
String source=request.getParameter("source");
%>

<frameset id='discrete' rows='40%,*'>
	<frame name='HeaderFrame' 	src='../../eCA/jsp/ClinicalRepMastAssociateMain.jsp?source=<%=source%>' frameborder=no scrolling='auto'>

	<frameset cols="50%,50%" border="0" framespacing=2>
	<frame name="paneldetails" src = "../../eCommon/html/blank.html "
	 marginheight='0' marginwidth='0' scrolling=auto  BORDERCOLOR='green' frameborder=no noresize>
	<frame name="paneladd" src = "../../eCommon/html/blank.html" marginheight='0' marginwidth='0'  frameborder=no  scrolling=no noresize >
	
</frameset> 

</frameset>
</html>
