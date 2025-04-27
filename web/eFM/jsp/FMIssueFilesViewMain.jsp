<!DOCTYPE html>
<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*" contentType="text/html; charset=UTF-8" %>
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
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script src='../../eFM/js/FMIssueFiles.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
//String file_type_yn		=		request.getParameter("file_type_yn");
	String url = "../../eFM/jsp/FMIssueFilesView.jsp?" ;
    String params = request.getQueryString() ;
    String source = url + params ;
%>
	 <iframe name='IssuesView' id='IssuesView' src='<%=source%>' frameborder=0 scrolling=auto  style='height:90vh;width:100vw'></iframe>
		<iframe name='IssueViewColor' id='IssueViewColor' src='../../eFM/jsp/FMIssueFilesViewColor.jsp' scrolling=no frameborder=0 style='height:15vh;width:100vw'></iframe>
	 
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

