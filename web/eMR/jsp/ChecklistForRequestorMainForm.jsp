<!DOCTYPE html>

<html>
<head>
	<%
          String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

	<script language='javascript' src='../js/ChecklistForRequestor.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
<iframe name='buttons' id='buttons' src='../../eMR/jsp/ChecklistForRequestor_Form.jsp' frameborder=0 scrolling='no' noresize style='height:30vh;width:100vw'></iframe>
	<iframe name='query_criteria' id='query_criteria' 	src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' noresize  style='height:20vh;width:100vw'></iframe>
	<iframe name='result' id='result'		src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' noresize   style='height:34vh;width:100vw'></iframe>
</html>



