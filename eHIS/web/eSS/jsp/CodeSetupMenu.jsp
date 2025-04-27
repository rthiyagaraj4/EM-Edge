<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html;charset=UTF-8"  import=" eSS.*, eSS.Common.* , eCommon.Common.*, java.text.*, java.util.*" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<%
	request.setCharacterEncoding("UTF-8");
	eSS.CodeSetupBean bean	=	(eSS.CodeSetupBean)getBeanObject( "ss_codeSetupBean","eSS.CodeSetupBean",request );  
	String module_id	=	request.getParameter("module_id");
	/*String function_id	=	request.getParameter("function_id");
	String menu_id		=	request.getParameter("menu_id");
	String resp_id		=	(String)session.getAttribute("responsibility_id");
	String function_name=	request.getParameter("function_name");
   */
%>

<html>
<head>
<%
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<SCRIPT LANGUAGE="JavaScript" src='../../eSS/js/CodeSetup.js'></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


		
		
</head>
<body style="background-color:dimgray;" >
<form name="formCodeSetup" id="formCodeSetup">
<table cellspacing=1 cellpadding=1 width='100%' border=0 id='t' align='center'>
<% 
if (module_id.equals("SS"))
{
%>
	<tr onclick='chcol(this)'>
		<td  class='MENUSUBLEVELCOLOR' onClick="callJSPs('SterilizationType')" >
		<fmt:message key="eSS.SterilizationType.label" bundle="${ss_labels}"/></td>
		</tr>
	<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="callJSPs('SurgeryType')" >
			<fmt:message key="eSS.SurgeryType.label" bundle="${ss_labels}"/></td>
	</tr>
	<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="callJSPs('ServiceLocation')" ><fmt:message key="eSS.ServiceLocation.label" bundle="${ss_labels}"/></td>
	</tr>
	<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="callJSPs('Autoclave_Washing_Unit')" ><fmt:message key="eSS.AutoclaveWashingUnit.label" bundle="${ss_labels}"/></td>
	</tr>
	<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="callJSPs('Autoclave_Washing_Test')" ><fmt:message key="eSS.AutoclaveWashingTest.label" bundle="${ss_labels}"/></td>
	</tr>
	<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="callJSPs('WriteoffReason')" ><fmt:message key="eSS.WriteoffReason.label" bundle="${ss_labels}"/></td>
	</tr>
	<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="callJSPs('UsageType')" ><fmt:message key="eSS.UsageType.label" bundle="${ss_labels}"/></td>
	</tr>
	<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="callJSPs('SubClassification')" >
			<fmt:message key="eSS.SubClassification.label" bundle="${ss_labels}"/></td>
	</tr>
	<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="callJSPs('SterilizationProcessStage')" >
			<fmt:message key="eSS.SterilizationProcessStage.label" bundle="${ss_labels}"/></td>
	</tr>
	<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="callJSPs('WashingType')" ><fmt:message key="eSS.WashingType.label" bundle="${ss_labels}"/></td>
	</tr>
	<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="callJSPs('StatisticalGroup')" ><fmt:message key="eSS.StatisticalGroup.label" bundle="${ss_labels}"/></td>
	</tr>
	<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="callJSPs('CSSDStore')" ><fmt:message key="eSS.CSSDStore.label" bundle="${ss_labels}"/></td>
	</tr>
	<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="callJSPs('CSSDItem')" ><fmt:message key="eSS.CSSDItem.label" bundle="${ss_labels}"/></td>
	</tr>
	<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="callJSPs('CSSDGroup')" ><fmt:message key="eSS.CSSDGroup.label" bundle="${ss_labels}"/></td>
	</tr>
	<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="callJSPs('SterilizationCost')" ><fmt:message key="eSS.SterilizationCost.label" bundle="${ss_labels}"/></td>
	</tr>
	</tr>
	<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="callJSPs('AlternateGroup')" ><fmt:message key="eSS.AlternateGroup.label" bundle="${ss_labels}"/></td>
	</tr>
	</tr>
	<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="callJSPs('GroupforStore')" ><fmt:message key="eSS.GroupforStore.label" bundle="${ss_labels}"/></td>
	</tr>
	<% } %>
	
	<tr onclick='chcol(this)'>
			<td class='MENUSELECTEDCOLOR' style='color:white;' onClick="javascript:parent.window.document.location.href='../../eCommon/jsp/CommonClearObjects.jsp'">
			<b><fmt:message key="Common.menu.label" bundle="${common_labels}"/></b></td>
	</tr>
</table>
</form>
	<%
putObjectInBean("ss_codeSetupBean",bean,request);
%>
</body>
</html>

