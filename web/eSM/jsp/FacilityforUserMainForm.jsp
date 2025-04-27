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

	<script language='javascript' src='../../eSM/js/FacilitiesForUser.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
	<iframe name='facilityForUserTopFrame' id='facilityForUserTopFrame' src='../../eSM/jsp/FacilityForUserTop.jsp' frameborder=0 scrolling='no' noresize style='height:5vh;width:100vw'></iframe>
	<iframe name='query_criteria' id='query_criteria' 	src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' noresize style='height:22vh;width:100vw'></iframe>
	<iframe name='result' id='result' src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' noresize style='height:70vh;width:100vw'></iframe>

</html>


