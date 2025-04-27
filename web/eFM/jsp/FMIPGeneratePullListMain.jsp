<!DOCTYPE html>
<!--
	Developed by 	:	Prakash.S
	Created on 		:	23/06/2002
	Module/Function	:	FM/Generate Pull List
	Function		:	
-->
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
	
	%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eFM/js/FMIPGeneratePullList.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
String user_security_yn  = request.getParameter("user_security_yn")==null?"N":request.getParameter("user_security_yn");
String access_all  = request.getParameter("access_all")==null?"N":request.getParameter("access_all");
%>
<iframe name='FMGenPullListCriteriaFrame' id='FMGenPullListCriteriaFrame' src='../../eFM/jsp/FMIPGeneratePullListCriteria.jsp?user_security_yn=<%=user_security_yn%>&access_all=<%=access_all%>' frameborder='0' scrolling=no noresize style='height:11vh;width:100vw'></iframe>
	<iframe name='FMGenPullListResultFrame' id='FMGenPullListResultFrame' src='../../eCommon/html/blank.html' frameborder='0' scrolling='no' style='height:50vh;width:100vw'></iframe>
	<iframe name='FMGenPullListNoteFrame' id='FMGenPullListNoteFrame' src='../../eCommon/html/blank.html' scrolling='no' frameborder='0' noresize style='height:39vh;width:100vw'></iframe>

</html> 

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString == "") ||(inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

