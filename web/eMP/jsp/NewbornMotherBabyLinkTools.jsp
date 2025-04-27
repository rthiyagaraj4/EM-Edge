<!DOCTYPE html>
<!doctype html public "-//W3C//DTD HTML 4.0 Transitional//EN">

<html>
<head>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	request.setCharacterEncoding("UTF-8");
%>
	<link type="text/css" rel="stylesheet" href="../../eCommon/html/<%=sStyle%>"></link>
	
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script language="JavaScript">
	<!--
			function toNewBornMain(motherid,val,accessRights)
			{
				parent.window.close();
				parent.window.returnValue = motherid+'`'+val+'`'+accessRights;
			}
	//-->
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body onKeyDown = 'lockKey()'>
<%
		String accessRights = request.getParameter("accessRights");
		if( accessRights == null) accessRights="";
		String close = request.getParameter("close");
		if( close == null) close="N";
		String motherid=request.getParameter("mother_id")==null?"":request.getParameter("mother_id");
%>
<table cellpadding=0 cellspacing=0 border=0 width='10%' align='right'>
	<tr>
	   <% 
		if (close.equals("N"))
		{
	   %>
		<td><input type=button class=button value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick="toNewBornMain('', 'C','<%=accessRights%>')"></td>
		<td><input type=button class=button value='<fmt:message key="Common.Register.label" bundle="${common_labels}"/>'  onClick="toNewBornMain('<%=motherid%>', 'Y','<%=accessRights%>')"></td>
		<% 
		} 
		else
		{ %>
		<td class='BODYCOLORFILLED'><input type=button class=button value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onClick="toNewBornMain('', 'C','<%=accessRights%>')"></td>		
		<%}
		%>		
	</tr>
</table>
</body>
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

