<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ page import="eSS.PhyInvEntryBean" %>
<%@page contentType="text/html;charset=UTF-8"  import="eSS.*, eSS.Common.* , eCommon.Common.*,java.util.*" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
		<title> </title>
<%
		String sStyle	=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		request.setCharacterEncoding("UTF-8");
		String locale	=		(String)session.getAttribute("LOCALE");

%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eCommon/js/MstCodeCommon.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="javascript" src="../../eSS/js/PhyInvEntry.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		String bean_id					=		"phyInvEntryBean";
		String bean_name				=		"eSS.PhyInvEntryBean";
		String mode						=		request.getParameter("mode");
		String phy_inv_id				=		"";
		String owner_store_code			=		"";
		String current_store_code		=		"";
		String group_code				=		"";
		String count_sheet_date			=		"";
		String disabled					=		"";

		PhyInvEntryBean phyInvEntryBean =		(PhyInvEntryBean) getBeanObject( bean_id, bean_name,request );  
		phyInvEntryBean.setLanguageId(locale);
		if (mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {
			phy_inv_id					=		phyInvEntryBean.getPhy_inv_id();
			owner_store_code			=		phyInvEntryBean.getStore_code();
			current_store_code			=		phyInvEntryBean.getCurr_store_code();
			count_sheet_date			=		phyInvEntryBean.getCount_sheet_date();
			disabled					=		"disabled";
		}
	%>	
	<body onLoad="FocusFirstElement();"onMouseDown='CodeArrest();'>
		<form name="formPhyInvEntryHeader" id="formPhyInvEntryHeader">
			<table border="0" cellpadding="0" cellspacing="0" width='100%' height='100%' align='center'><tr><td>
				<table border="0" cellpadding="0" cellspacing="0" width='100%' >
				<tr>
					<td align="right" class="label"><fmt:message key="eSS.PhysicalInvId.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<input type="text" name="phy_inv_id" id="phy_inv_id" maxlength=10 size=10 class="NUMBER" onkeypress="return isValidNumber(this,event,<%=phyInvEntryBean.getSsRepositoryValue("INTEGER_PRECISION")%>,0);" onBlur="validatePhyInvId(this);" value="<%=phy_inv_id%>" <%=disabled%>><%=phyInvEntryBean.getMandatoryImageTag()%></td>
					<td align="right" class="label"><fmt:message key="eSS.CountSheetDate.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<input type="text" name="count_sheet_date" id="count_sheet_date" value="<%=com.ehis.util.DateUtils.convertDate(count_sheet_date,"DMY","en",locale)%>" maxLength=10 size=10 onBlur="CheckDate(this);" disabled readonly></td>
				</tr>
				<tr>
					<td align="right" class="label"><fmt:message key="eSS.Owner.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<select name="owner_store_code" id="owner_store_code" onBlur ="return addBinLocations(this);" <%=disabled%>><%=phyInvEntryBean.getOwnerStores()%></select><%=phyInvEntryBean.getMandatoryImageTag()%></td>
					<td align="right" class="label"><fmt:message key="eSS.CurrentStore.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<select name="current_store_code" id="current_store_code" onBlur="validatePhyInvRecord();" <%=disabled%>><%=phyInvEntryBean.getCurrentStores()%></select><%=phyInvEntryBean.getMandatoryImageTag()%></td>
				</tr>
				</table>
				</td>
				</tr>
			</table>
			<input type='hidden' name="mode" id="mode"					value="<%=mode%>">
			<input type='hidden' name="locale" id="locale"					value="<%=locale%>">
			<input type="hidden" name="bean_id" id="bean_id"					value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name"				value="<%= bean_name %>">
			<input type="hidden" name="group_code" id="group_code"				value="<%=group_code%>">
			<input type="hidden" name="facility_id" id="facility_id"				value="">
			<input type="hidden" name="records_for_submission" id="records_for_submission"	value="">
			<input type="hidden" name="function_id" id="function_id"				value="<%=phyInvEntryBean.getFunctionId()%>">
			<input type="hidden" name="SQL_SS_GROUP_LOOKUP" id="SQL_SS_GROUP_LOOKUP"		value="<%= eSS.Common.SsRepository.getSsKeyValue("SQL_SS_GROUP_LOOKUP")%>">
		</form>
<%
	putObjectInBean(bean_id,phyInvEntryBean,request);
%>
	</body>
</html>

