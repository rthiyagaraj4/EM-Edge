<!DOCTYPE html>
<html>
<head>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
request.setCharacterEncoding("UTF-8");
	%>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'</link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
<body onKeyDown = 'lockKey()'>
<table border='1' width='99%'>
<tr>

<td width="5%" align='left' class='DECEASED'>&nbsp;</td>
<td width="25%" align='left' class='oalabel'>
&nbsp;<fmt:message key="Common.deceased.label" bundle="${common_labels}"/>
</td>

<td width="5%" align='left' class='INACTIVE'>&nbsp;</td>
<td width="25%" align='left' class='oalabel'>
&nbsp;<fmt:message key="Common.Inactive.label" bundle="${common_labels}"/>
</td>

<td width="5%" align='left' class='SUSPENDED'>&nbsp;</td>
<td width="25%" align='left' class='oalabel'>
&nbsp;<fmt:message key="Common.Suspended.label" bundle="${common_labels}"/>
</td>

<td width="5%" align='left' class='RESTRICTED'>&nbsp;</td>
<td width="25%" align='left' class='oalabel'>
&nbsp;<fmt:message key="eMP.Restricted.label" bundle="${mp_labels}"/>
</td>
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

