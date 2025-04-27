<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*" contentType="text/html; charset=UTF-8" %>

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
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body onMouseDown="CodeArrest()" onKeyDown = 'lockKey();'>
<%
	String p_param		= request.getParameter("p_param");
	String doc_or_file	= request.getParameter("doc_or_file")==null?"F":request.getParameter("doc_or_file");
	if (p_param.equals("REQ"))
	{
		
%>
  <table border=0 cellspacing=0 width='100%' cellpadding='0' align ='center'>
  <tr>
  		<td width="1%"  class='label'>&nbsp;</td>
<% if(doc_or_file.equals("D")) { %>
		<td width="10%"  class='label'><b><fmt:message key="eFM.DocumentStatus.label" bundle="${fm_labels}"/> :&nbsp;</td>
<% } else { %>
		<td width="10%"  class='label'><b><fmt:message key="eFM.FileStatus.label" bundle="${fm_labels}"/> :&nbsp;</td>
<% } %>
		<td width="1%"  style='background-color:#CCEEDD;'>&nbsp;</td>
		<td width="7%"  class='label'><font size=1>&nbsp;&nbsp;<b> <fmt:message key="eFM.Transit.label" bundle="${fm_labels}"/> </b></font></td>

		<td width="1%"  style='background-color:#FFFFEE;'>&nbsp;</td>
		<td width="6%"  class='label'><font size=1>&nbsp;&nbsp;<b> <fmt:message key="Common.Lost.label" bundle="${common_labels}"/> </b></font></td>

		<td width="1%"  style='background-color:#FFEECC;'>&nbsp;</td>
		<td width="8%"  class='label'><font size=1>&nbsp;&nbsp;<b> <fmt:message key="Common.Archived.label" bundle="${common_labels}"/></b></font></td>

		<td width="1%"  style='background-color:#D1BBA7;'>&nbsp;</td>
		<td width="7%"  class='label'><font size=1>&nbsp;&nbsp;<b> <fmt:message key="Common.Outside.label" bundle="${common_labels}"/></b></font></td>
		
		<td width="1%"  style='background-color:#C0C0C0;'>&nbsp;</td>
		<td width="7%"  class='label'><font size=1>&nbsp;&nbsp;<b> <fmt:message key="Common.returned.label" bundle="${common_labels}"/></b></font></td>
		
		<td width="1%"  style='background-color:#ADD8E6;'>&nbsp;</td>
		<td width="12%"  class='label'><font size=1>&nbsp;&nbsp;<b> <fmt:message key="eFM.InReqFSLocation.label" bundle="${fm_labels}"/> </b></font></td>

		<td width="1%"  style='background-color:#E0FFFF;'>&nbsp;</td>
		<td width="10%"  class='label'><font size=1>&nbsp;&nbsp;<b> <fmt:message key="eFM.InOtherFacility.label" bundle="${fm_labels}"/></b></font></td>

	</tr>
 	</table>	
<%
	}
	else if (p_param.equals("QUERYMRD"))
	{
%>
  <table border=0 cellspacing=0 width='100%' cellpadding='0' align ='center' style='position: absolute; bottom: 0;>
  <tr>
  		<td width="1%"  class='label'>&nbsp;</td>
		<td width="7%"  class='label'><b>&nbsp;</td>

		<td width="1%"  style='background-color:ORANGE;'>&nbsp;</td>
		<td width="14%"  class='label'><font size=1>&nbsp;&nbsp;<b>  <fmt:message key="eFM.Dueforreturn.label" bundle="${fm_labels}"/></b></font></td>

		
		<td width="1%"  class='label'>&nbsp;</td>
		<td width="7%"  class='label'><b>&nbsp;</td> 
		
		<td width="1%"  style='background-color:red;'>&nbsp;</td>
		<td width="14%"  class='label'><font size=1>&nbsp;&nbsp;&nbsp;<b><fmt:message key="eFM.OverDueforreturn.label" bundle="${fm_labels}"/>	</b></font></td>

		

		<td width="1%"  >&nbsp;</td>
		<td width="7%"  class='label'><font size=1>&nbsp;&nbsp;<b> &nbsp;</b></font></td>

		<td width="1%"  >&nbsp;</td>
		<td width="7%"  class='label'><font size=1>&nbsp;&nbsp;<b> &nbsp;</b></font></td>

		<td width="1%"  >&nbsp;</td>
		<td width="7%"  class='label'><font size=1>&nbsp;&nbsp;<b> &nbsp; </b></font></td>

		<td width="1%"  >&nbsp;</td>
		<td width="7%"  class='label'><font size=1>&nbsp;&nbsp;<b> &nbsp;</b></font></td>

	</tr>
 	</table>	
<%
	}
	else 
	{
%>
  <table border=0 cellspacing=0 width='100%' cellpadding='0' align ='center'>
  <tr>
  		<td width="1%"  class='label'>&nbsp;</td>
<% if(doc_or_file.equals("D")) { %>
		<td width="7%"  class='label'><b><fmt:message key="eFM.DocumentStatus.label" bundle="${fm_labels}"/> :&nbsp;</td>
<% } else { %>
		<td width="7%"  class='label'><b><fmt:message key="eFM.FileStatus.label" bundle="${fm_labels}"/> :&nbsp;</td>
<% } %>	<td width="1%"  style='background-color:darkseagreen;'>&nbsp;</td>
		<td width="7%"  class='label'><font size=1>&nbsp;&nbsp;<b> <fmt:message key="eFM.Transit.label" bundle="${fm_labels}"/> </b></font></td>

		<td width="1%"  style='background-color:mediumvioletred;'>&nbsp;</td>
		<td width="6%"  class='label'><font size=1>&nbsp;&nbsp;<b> <fmt:message key="Common.Lost.label" bundle="${common_labels}"/> </b></font></td>

		<td width="1%"  style='background-color:gold;'>&nbsp;</td>
		<td width="7%"  class='label'><font size=1>&nbsp;&nbsp;<b> <fmt:message key="Common.Archived.label" bundle="${common_labels}"/></b></font></td>

		<td width="1%"  style='background-color:sandybrown;'>&nbsp;</td>
		<td width="7%"  class='label'><font size=1>&nbsp;&nbsp;<b> <fmt:message key="Common.Outside.label" bundle="${common_labels}"/></b></font></td>
		
		<td width="1%"  style='background-color:#C0C0C0;'>&nbsp;</td>
		<td width="7%"  class='label'><font size=1>&nbsp;&nbsp;<b> <fmt:message key="Common.returned.label" bundle="${common_labels}"/></b></font></td>
		
		<% 
			//if(!p_param.equals("RECEIVE"))
			//{
		%>		
		<td width="1%"  style='background-color:cyan;'>&nbsp;</td>
		<td width="10%"  class='label'><font size=1>&nbsp;&nbsp;<b><fmt:message key="eFM.FromOtherFacilities.label" bundle="${fm_labels}"/></b></font></td>
		<%
		//	}
		%>

	</tr>
 	</table>	
<%
	}
%>
</body>
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

