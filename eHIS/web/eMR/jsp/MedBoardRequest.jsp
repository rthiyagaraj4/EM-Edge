<!DOCTYPE html>
<%
/*
 ****************************************************************************************
* @Module		: Medical Records..[MR]
* @Author		: SRIDHAR R 
* @Created on	: 23 MARCH 2005
* @Function		: MEDICAL_BOARD_REQUEST
 ****************************************************************************************
*/
%>

<%@ page contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
	<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script> 
	<script src='../../eMR/js/MedBoardRequest.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	 
</head>

<%
request.setCharacterEncoding("UTF-8");
	String url			= "../../eCommon/jsp/commonToolbar.jsp?";
	String params	= request.getQueryString() ;
	String source		= url + params ;
	String call_function= checkForNull(request.getParameter("function_id"));
%>
	<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%= source %> frameborder='0' scrolling='no' noresize style='height:8%;width:100vw'></iframe>
		<iframe scrolling="no" name='detail_frame' id='detail_frame' src='../../eMR/jsp/MedBoardRequestDetail.jsp?call_function=<%=call_function%>' noresize frameborder=0 scrolling="no" style='height:43%;width:100vw'></iframe><iframe scrolling="no" name='tab_frame' id='tab_frame' src='../../eMR/jsp/MedBoardRequestDetailTabs.jsp?call_function=<%=call_function%>' noresize frameborder=0 scrolling="no" style='height:41%;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:8%;width:100vw'></iframe>
</html>


<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	? "" : inputString;
	}
	private String checkForNull(String inputString, String defaultValue)
	{
		return (inputString==null)	? defaultValue : inputString;
	}
%>

