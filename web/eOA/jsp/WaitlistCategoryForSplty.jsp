<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"  %>
<html>
<head>
	<%String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

	<script language='javascript' src='../../eOA/js/WaitlistCategoryForSplty.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js' ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<iframe name='criteria_frame' id='criteria_frame' src='../../eOA/jsp/WaitlistCategoryForSpltySearch.jsp' frameborder=0 scrolling='no' noresize style='height:15vh;width:100vw'></iframe>
	<iframe name='result_frame' id='result_frame' src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:85vh;width:100vw'></iframe>

</html>

