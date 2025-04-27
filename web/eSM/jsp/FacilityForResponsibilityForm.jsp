<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
          String sStyle	=
          (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

	<script language='javascript' src='../js/FacilityforResponsibility.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
<iframe name='buttons' id='buttons' src='../../eSM/jsp/FacilityForResponsibilityMenu.jsp' frameborder=0 scrolling='no' noresize style='height:6vh;width:100vw'></iframe>
	<iframe name='query_criteria' id='query_criteria' 	src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' noresize  style='height:25vh;width:100vw'></iframe>
	<iframe name='result' id='result'		src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize   style='height:66vh;width:100vw'></iframe>
</html>



