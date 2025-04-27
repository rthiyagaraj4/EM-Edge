<!DOCTYPE html>
<%@ page import ="java.sql.*, java.util.*, java.text.* ,javax.servlet.*,javax.servlet.http.*,webbeans.eCommon.*,org.json.simple.parser.JSONParser,org.json.simple.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% 
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>

<Script language='javascript' src='../js/PatDispArchConfig.js'></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
</head>
<body  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<form name="frmPatDispArchConfigCriteria" id="frmPatDispArchConfigCriteria" method="post" action="../../eMR/jsp/PatDispArchConfigResults.jsp"  target="resultsFrame" >
<center>
<%
try	{

		
%>
<Br>


	<table border="0" cellpadding="0" cellspacing="0" width="50%" align='center'>
		<tr>
			<td class="label" width="15%"><fmt:message key="Common.action.label" bundle="${common_labels}"/></td>
			<td width="15%" class="fields" colspan="2">
				<select name="arch_disp" id="arch_disp" onchange="fnArchDispChgn(this);">
					<option value="0"><fmt:message key="eMR.Disposal.label" bundle="${mr_labels}"/></option>
					<option value="1"><fmt:message key="Common.Inactive.label" bundle="${common_labels}"/></option>
				</select>
			</td>
	   </tr>
	  
	</table>
</form>
</center>
</body>
</html>

<%

	} catch(Exception e) {/* out.println(e.getMessage()); */e.printStackTrace();}
	
	finally {

	}
%>

<%!	
	
	public static String checkForNull(String inputString, String defaultValue)	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

