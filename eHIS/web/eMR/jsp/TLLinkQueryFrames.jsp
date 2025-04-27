<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
 <% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %> 
<html>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eMR/js/TLReportSetup.js' language='javascript'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<%
	request.setCharacterEncoding("UTF-8");
	//String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	//String params = request.getQueryString() ;
	//String source = url + params ;
%>
<iframe name='f_query_add_mod_search' id='f_query_add_mod_search' 	src='../../eMR/jsp/TLLinkCriteria.jsp' frameborder=0 scrolling='auto' noresize style='height:260%;width:100vw'></iframe>
	<iframe name='f_query_add_mod_result' id='f_query_add_mod_result' 	src='../../eCommon/html/blank.html' frameborder=0 noresize style='height:100vh;width:100vw'></iframe>
	

</html>



<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

