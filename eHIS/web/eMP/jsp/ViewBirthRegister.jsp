<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eMP/js/ViewBirthDetails.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	request.setCharacterEncoding("UTF-8");
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
	//onLoad="assign()"
%>
<% String func_idpassed = request.getParameter("function_id")==null?"":request.getParameter("function_id");


%>
	<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>' frameborder=0 scrolling='no' noresize=noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='pat_line' id='pat_line' 	src='../../eCommon/html/blank.html' frameborder=0 noresize=noresize scrolling='no' style='height:5vh;width:100vw'></iframe> 
	<iframe name='f_query_add_mod' id='f_query_add_mod'	src='../../eMP/jsp/ViewBirthRegisterBlank.jsp?step_1=3&func_idpassed=<%=func_idpassed%>&function_id=<%=func_idpassed%>' frameborder=0 noresize=noresize scrolling='yes' style='height:78vh;width:100vw'></iframe> 
	<iframe name='messageFrame' id='messageFrame'	src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='no' noresize=noresize style='height:9vh;width:100vw'></iframe>

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

