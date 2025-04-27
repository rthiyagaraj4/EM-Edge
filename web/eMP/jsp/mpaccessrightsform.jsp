<!DOCTYPE html>
<%@ page language="java" contentType="text/html;charset=UTF-8" import ="java.sql.Connection,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.*,java.util.HashMap"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<jsp:useBean id="accessRightRecSet" class="webbeans.eCommon.RecordSet" scope="session"/> 
<jsp:useBean id="accessRightfinaRecSet" class="webbeans.eCommon.RecordSet" scope="session"/> 
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<Script language='javascript' src='../../eMP/js/MpAccessRights.js'></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
<title>
</title>
</head>

<body onLoad="FocusFirstElement()" onKeyDown = 'lockKey()' OnMouseDown="CodeArrest()">
<form name='MpAccessRightsForm' id='MpAccessRightsForm'>

<table border='0' cellpadding='5' cellspacing='0' width='100%'>
		
		<tr>
			<td width='25%' class='label'>
				<fmt:message key="Common.search.label" bundle="${common_labels}"/> <fmt:message  key="Common.responsibility.label" bundle="${common_labels}"/>	
			</td>
			<td width='25%' class='fields'>
				<INPUT TYPE="text" onBlur='makeValidQueryCriteria(this)' name="searchresp" id="searchresp" maxLength="60" onKeyPress="return blockevent(event)"><img align='center' src='../../eCommon/images/mandatory.gif'></img>
			</td>
			<td width='25%' class='label'>
				<fmt:message key="Common.criteria.label" bundle="${common_labels}"/>
			</td>
			<td width='25%' class='fields'>
				<select name="search_criteria" id="search_criteria">
					<option value="S"><fmt:message  key="Common.startsWith.label" bundle="${common_labels}"/>
					<option value="E"><fmt:message  key="Common.endsWith.label" bundle="${common_labels}"/>
					<option value="C"><fmt:message  key="Common.contains.label" bundle="${common_labels}"/>
				</select>
			</td>			
		</tr>		
	
	<tr>
		<td colspan='4' class='button' align='right'>
		<input type='button' name='Search' id='Search' class='button' value='<fmt:message  key="Common.search.label" bundle="${common_labels}"/>' onClick='displayDetails()' ><input type='button' class='button' name='Clear' id='Clear' onClick='clearValues()' value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>'>
		</td>
	</tr>
</table>
</form>
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

