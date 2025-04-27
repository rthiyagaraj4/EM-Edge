<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html;charset=UTF-8" import=" eSS.*, eSS.Common.* , eCommon.Common.*, java.text.*, java.util.*, eSS.Common.*" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
 <%-- Mandatory declarations end --%>
<%
	String sStyle		=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	request.setCharacterEncoding("UTF-8");
	String locale		=		(String)session.getAttribute("LOCALE");

%>


<html>
<jsp:useBean id="bean" scope="page" class="eSS.ReportsMasterCodeBean"/>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eSS/js/AgeingAnalysisReport.js"></script>
	<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>
<body onLoad="FocusFirstElement();"onMouseDown="CodeArrest()">  
<%
		String bean_id			=		"ssTransaction";
		String bean_name		=		"eSS.Common.SsTransaction";
		//SsTransaction bean		=		(SsTransaction) getBeanObject(bean_id,  bean_name, request );
		bean.clear() ;
		bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
%>
		
<form name="formAgeingAnalysis" id="formAgeingAnalysis" onReset="FocusFirstElement();" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame">
	<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center'  height='100%'>
	<tr>
	<td width='100%' align='center'  class="WHITE">
	<table border="0" cellpadding="1" cellspacing="0" width='75%' align='center'>
	<tr><th colspan='3' align='left'><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th></tr>
	<tr><td colspan='3'>&nbsp;</td></tr>
	<tr>
		<td>&nbsp;</td>
		<td class='LABEL'>&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
		<td class='LABEL'>&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
	</tr>
	<tr>
		<td class='LABEL' align='right'><fmt:message key="Common.Group.label" bundle="${common_labels}"/></td>
		<td>&nbsp;<input onKeyPress="return CheckForSpecChars(event);" onBlur="checkSpecialChars(this);" class='UPPER' type='text' maxLength='10' size='10' name="p_fr_group_code" id="p_fr_group_code"><input type='button' class='BUTTON' value="?" onClick="searchGroupCode(p_fr_group_code)"></td>
		<td>&nbsp;<input onKeyPress="return CheckForSpecChars(event);" onBlur="checkSpecialChars(this);" class='UPPER' type='text' maxLength='10' size='10' name="p_to_group_code" id="p_to_group_code"><input type='button' class='BUTTON' value="?" onClick="searchGroupCode(p_to_group_code)"></td>
	</tr>
	<tr>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
					
	</tr>
	<tr>
		<td class='LABEL' align='right'><fmt:message key="Common.Store.label" bundle="${common_labels}"/></td>
		<td>&nbsp;<input onKeyPress="return CheckForSpecChars(event);" onBlur="checkSpecialChars(this);" class='UPPER' type='text' maxLength='6' size='6' name="p_fr_store_code" id="p_fr_store_code"><input type='button' class='BUTTON' value="?" onClick="searchStoreCode(p_fr_store_code)"></td>
		<td>&nbsp;<input onKeyPress="return CheckForSpecChars(event);" onBlur="checkSpecialChars(this);" class='UPPER' type='text' maxLength='6' size='6' name="p_to_store_code" id="p_to_store_code"><input type='button' class='BUTTON' value="?" onClick="searchStoreCode(p_to_store_code)"></td>
	</tr>
	<tr>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
					
	</tr>
	<tr>
		<td class='LABEL' align='right'><fmt:message key="eSS.SurgeryType.label" bundle="${ss_labels}"/></td>
		<td>&nbsp;<input onKeyPress="return CheckForSpecChars(event);" onBlur="checkSpecialChars(this);" class='UPPER' type='text' maxLength='8' size='8' name="p_fr_surgery_type" id="p_fr_surgery_type"><input type='button' class='BUTTON' value="?" onClick="searchSurgeryType(p_fr_surgery_type)"></td>
		<td>&nbsp;<input onKeyPress="return CheckForSpecChars(event);" onBlur="checkSpecialChars(this);" class='UPPER' type='text' maxLength='8' size='8' name="p_to_surgery_type" id="p_to_surgery_type"><input type='button' class='BUTTON' value="?" onClick="searchSurgeryType(p_to_surgery_type)"></td>
	</tr>
	<tr><td colspan='3'>&nbsp;</td></tr>
	</table>
	</td>
	</tr>
	</table>
	<input type="hidden" name="function_id" id="function_id"							value="<%=bean.getFunctionId()%>">
	<input type="hidden" name="p_module_id" id="p_module_id" 						value="SS">
	<input type="hidden" name="p_report_id" id="p_report_id" 						value="SSBAGEAN">
	<input type="hidden" name="p_user_name" id="p_user_name"							value="<%=bean.getLoginById()%>">
	<input type="hidden" name="p_facility_id" id="p_facility_id"						value="<%=bean.getLoginFacilityId()%>">
	<input type="hidden" name="locale" id="locale"								value="<%=locale%>">
	<input type="hidden" name="SQL_SS_STORE_LOOKUP" id="SQL_SS_STORE_LOOKUP"					value="<%=bean.getSsRepositoryValue("SQL_SS_STORE_LOOKUP")%>">
	<input type="hidden" name="SQL_SS_SURGERY_TYPE_LOOKUP" id="SQL_SS_SURGERY_TYPE_LOOKUP"			value="<%=bean.getSsRepositoryValue("SQL_SS_SURGERY_TYPE_LOOKUP")%>">
	<input type="hidden" name="SQL_SS_GROUP_LOOKUP_FOR_REPORT" id="SQL_SS_GROUP_LOOKUP_FOR_REPORT"		value="<%=bean.getSsRepositoryValue("SQL_SS_GROUP_LOOKUP_FOR_REPORT")%>">
</form>
<%
	putObjectInBean(bean_id,bean,request);
%>
</body>
</html>

