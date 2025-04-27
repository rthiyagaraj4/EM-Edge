<!DOCTYPE html>
<!-- Developed By	   :-	Prashant Bhalsingh
	 Created on   	   :	24/06/2001
	 Module Name 	   :	FM\File Code report
-->
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,java.text.*"  contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language="javascript" src="../../eFM/js/FMFileDeficiencyReport_SRR.js" ></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 </head>

<form name="ReportSearch" id="ReportSearch" action="" method="post" target="messageFrame">
<body  OnMouseDown="CodeArrest()" onLoad="codeCheck('D');" onKeyDown = 'lockKey();'>
	<BR>
	<div align="left">
		<table border="0" cellpadding="0" cellspacing="0"  align='center'>
			<tr>
				<td width='10%' >&nbsp;</td>
				<td class="label" width='40%'><fmt:message key="Common.groupby.label" bundle="${common_labels}"/></td>
				<td class='fields' width='40%'><select name="code" id="code" onChange="codeCheck(this.value);">
						<option value='D' ><fmt:message key="Common.type.label" bundle="${common_labels}"/></option>
						<option value='F' ><fmt:message key="Common.criteria.label" bundle="${common_labels}"/></option>
						<option value='P' ><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></option>
					    <option value='S' ><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></option>
					</select>
				</td>
				<td width='10%' >&nbsp</td></tr>
			</tr>
		</table>
	</div>
</form>
</body>
</html>

