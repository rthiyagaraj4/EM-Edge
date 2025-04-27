<!DOCTYPE html>
<!--
               Developed By :-  Rajesh Kanna.S
			                        1/2/2005 

-->
<html>
<head>
	<%String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eQA/js/QAParameter.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
	<script language='javascript' src='../../eQA/js/QAMessages.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
		String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
		String params = request.getQueryString() ;
		String source = url + params ;
%>
<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%=source%> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eQA/jsp/QAParameterForm.jsp' frameborder=0 scrolling='no' noresize style='height:82vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:10vh;width:100vw'></iframe>
</html>

