<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eMR
*	Purpose 		:	
*	Created By		:	Vinay
*	Created On		:	17 Jan 2005
--%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<% request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>


<script language="JavaScript" src="../../eMR/js/TerminologyCode.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<iframe name='f_term_disp_lvl' id='f_term_disp_lvl' 	src='../../eMR/jsp/TerminologyCodeDisplayLevels.jsp' frameborder=0 noresize scrolling='auto'style='height:40vh;width:30vw'></iframe><iframe name='f_term_selected_values' id='f_term_selected_values' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto'style='height:40vh;width:70vw'></iframe>
</html>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

