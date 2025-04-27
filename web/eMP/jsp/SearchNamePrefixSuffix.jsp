<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
	String titles = request.getParameter("titles");
	String titVal = "";
	if(titles.equals("Prefix"))
		titVal = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.NamePrefix.label","common_labels");
	else if(titles.equals("Suffix"))
		titVal = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.NameSuffix.label","common_labels");
%>
<title><%=titVal%></title>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src="../../eCommon/js/ValidateControl.js"></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<iframe name='SearchCriteria' id='SearchCriteria' src='../jsp/SearchNamePrefixSuffixCriteria.jsp?titles=<%=titles%>' noresize  frameborder=no marginheight=0 marginwidth=0 SCROLLING=no style='height:25vh;width:100vw'></iframe>
	<iframe name='SearchSelection' id='SearchSelection' src='../../eCommon/html/blank.html' noresize  frameborder=no marginheight=0 marginwidth=0 SCROLLING=no style='height:75vh;width:100vw'></iframe>
</head>
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

