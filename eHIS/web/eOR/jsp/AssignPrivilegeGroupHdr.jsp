<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page language="java" import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
    String queryString=request.getQueryString();
%>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src="../../eCommon/js/ValidateControl.js"	language="javascript"></script>
<script src="../../eCommon/js/ValidateControl.js"	language="javascript"></script>
<script src="../../eCommon/js/common.js"  language="javascript"></script>
<script language='javascript' src='../../eOR/js/AssignPrivilegeGroup.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body  OnMouseDown="CodeArrest()" class='CONTENT'>
<form name='AssignPrivilegeGroupHdr' id='AssignPrivilegeGroupHdr'>
<BR>
	<table cellpadding='3' cellspacing='0' border='0' width='100%' align='center'>
		<tr>
			<td class='label'  width='24.75%'><fmt:message key="Common.groupby.label" bundle="${common_labels}"/></td>
			<td class='fields' >&nbsp;&nbsp;<select name='group_by' id='group_by' onChange='return fetchDetailsRecords(this);'>
				<option value=""> --------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------- </option>	
				<option value="PG"><fmt:message key="eOR.PrivilegeGroup.label" bundle="${or_labels}"/></option>
				<!-- Modified by kishore kumar N on 18-Aug-09 for CRF 641 -->
				<!-- <option value="RS"><fmt:message key="Common.responsibility.label" bundle="${common_labels}"/></option> 
					
					Ends here.
				-->

				<option value="PR"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></option>
				</select><img src="../../eCommon/images/mandatory.gif"></img></td>
		</tr>
	</table>
	<input type="hidden" name="queryString" id="queryString"	  value="<%=queryString%>">
	<input type="hidden" name="function_id" id="function_id"	  value="Assign_Privilege_Group">
</form>
</body>
</html>

