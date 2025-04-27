<!DOCTYPE html>
<html>
<head>
	<%String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

  <script language='javascript' src='../../eQA/js/QAIndicatorFacility.js'></script> 
	<!-- <script src='../../eCommon/js/MstCodeCommon.js' language='javascript'></script>  -->
	<script language='javascript' src='../../eCommon/js/messages.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>


<iframe name='criteria_frame' id='criteria_frame' src='../../eQA/jsp/QAIndicatorForFacility1.jsp' frameborder=0 scrolling='no' noresize style='height:21vh;width:100vw'></iframe>
	<iframe name='result_frame' id='result_frame' src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' noresize style='height:79vh;width:100vw'></iframe>
	

</html>

