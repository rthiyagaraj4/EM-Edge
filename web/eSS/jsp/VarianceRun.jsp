<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="eSS.VarianceBean" %>
<%@page contentType="text/html;charset=UTF-8"  import="eSS.*, eSS.Common.* , eCommon.Common.*,java.util.*" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 

<html>
	<head>

<%
		request.setCharacterEncoding("UTF-8");
		String sStyle			=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String locale			=		(String)session.getAttribute("LOCALE");
%>
		
	
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eCommon/js/MstCodeCommon.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="javascript" src="../../eSS/js/Variance.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		String mode				=		request.getParameter("mode");
		String bean_id			=		"varianceBean";
		String bean_name		=		"eSS.VarianceBean";
		String function_id		=		request.getParameter("function_id");
		String p_facility_id	=		(String) session.getValue("facility_id");
		String p_user_name		=		(String) session.getValue("login_user");
		VarianceBean bean		=		( VarianceBean) getBeanObject( bean_id, bean_name,request);  
		bean.clear();
		bean.setMode(mode);
		bean.setLanguageId(locale);
		bean.setFunctionId(bean.checkForNull(function_id));
	%>
	<body onLoad="FocusFirstElement();"onMouseDown='CodeArrest();'>
		<form name="formVariance" id="formVariance" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame" >
		<table border="0" cellpadding="10" cellspacing="0" width='100%' align='center' height='100%'>
			<tr>
			<td width='100%' align='center' class="WHITE">
				<table cellpadding="3" cellspacing="0" width="50%" align="center" border="0">
				<th colspan=2 align=left><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
				<tr>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
					
				</tr>
				<tr>
					<td align="right" class="label"><fmt:message key="eSS.PhysicalInvId.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<select name="p_phy_inv_id" id="p_phy_inv_id"  ><%=bean.getPhyId()%></select><%=bean.getMandatoryImageTag()%></td>
					
				</tr>
				<tr>
					<td align="right" class="label"><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<select name="p_report_type" id="p_report_type"   ><%=bean.getReport_type()%></select></td>
					
				</tr>
				
				<tr>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
					
				</tr>
				</table>
				</td>
				</tr>
			</table>
			<input type="hidden" name="bean_id" id="bean_id"			value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name"		value="<%=bean_name%>">
			<input type="hidden" name="P_facility_id" id="P_facility_id"	value="<%=p_facility_id%>">
			<input type="hidden" name="p_report_id" id="p_report_id" >
			<input type="hidden" name="p_module_id" id="p_module_id"		value="SS">
			<input type="hidden" name="p_user_name" id="p_user_name"		value="<%=p_user_name%>">
			<input type="hidden" name="P_AT_WS_NO" id="P_AT_WS_NO"		value="<%=bean.getLoginAtWsNo()%>">
			<input type="hidden" name="orderbycolumns" id="orderbycolumns"	value="doc_type_code,doc_no">
		</form>
<%
	putObjectInBean(bean_id,bean,request);
%>

	</body>
</html>

