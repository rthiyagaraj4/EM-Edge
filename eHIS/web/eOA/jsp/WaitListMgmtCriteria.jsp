<!DOCTYPE html>
<!--
	Developed by 	:	Suman
	Created on 	:	24/01/2005
	Module		:	OA
	Function	:	Manage WaitList
-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%@ page contentType="text/html;charset=UTF-8" import = "java.sql.*,webbeans.eCommon.*" %>

 <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eOA/js/WaitListMgmt.js'></script>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js'></script>
<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>



		<html>
		<head>
		</head>
		<body  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
		<form name='WaitListMgmtForm' id='WaitListMgmtForm' >
		<table name='waitMgmtTable1' id='waitMgmtTable1' width='100%' align='center' cellpadding='0' cellspacing='0' border='0'>

			
		<tr>	
				<td class='button' align="right"><input type='button' name='Select' id='Select' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' class='button' onClick='callResult();' tabindex=12><input type=button name='Clear' id='Clear' value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' class='button' onClick='ClearForms();' tabindex=13></td>
		</tr>
	</table>
		

			</form>
		</body>
		</html>

			

