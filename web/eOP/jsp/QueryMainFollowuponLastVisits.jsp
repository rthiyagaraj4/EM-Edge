<!DOCTYPE html>
<html>
<head>
<!-- <link rel='stylesheet' type ='text/css' href='../../eCommonhtml/IeStyle.css'>
</link> -->
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eOP/js/FollowuponLastVisits.js'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<iframe name='query_criteria' id='query_criteria'	src="../../eOP/jsp/QueryCriteriaFollowuponLastVisits.jsp"  frameborder=0 scrolling='no' noresize style='height:27vh;width:100vw'></iframe>
	<iframe name='query_result' id='query_result' src="../../eCommon/html/blank.html" frameborder=0 scrolling='auto' style='height:70vh;width:100vw'></iframe>

</html>

