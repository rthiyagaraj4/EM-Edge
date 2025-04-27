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
<%
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		request.setCharacterEncoding("UTF-8");
		String locale= (String)session.getAttribute("LOCALE");

%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="javascript" src="../../eSS/js/PhyInvEntry.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>

	<%
		String bean_id			=		"phyInvEntryBean";
		String bean_name		=		"eSS.PhyInvEntryBean";
		String canDisable		=		"";
		String disabled			=		"";
		String cmdMode			=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels");


		PhyInvEntryBean phyInvEntryBean = (PhyInvEntryBean) getBeanObject( bean_id, bean_name,request );  
		

		String editing_key			=		request.getParameter("editing_key");
		String bin_location_code	=		"";
		String group_code			=		"";
		String tray_no				=		"";

		if (editing_key != null) {
			tray_no					=		request.getParameter("tray_no");
			bin_location_code		=		request.getParameter("bin_location_code");
			group_code				=		request.getParameter("group_code");
			phyInvEntryBean.setSelected_group_code(group_code);
			phyInvEntryBean.setLanguageId(locale);

			phyInvEntryBean.setSelected_bin_location_code(bin_location_code);
			 cmdMode			=			com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modify.label","common_labels");

			disabled = "disabled";
		}
	%>
	<body onMouseDown='CodeArrest();'>

		<form name="formPhyInvEntryDetail" id="formPhyInvEntryDetail" onLoad="addBinLocations();">
			<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' height='100%'>
			<tr>
			<td width='100%' height='100%' align='center' valign='top'>
				<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center'>
					<tr>
						<td>&nbsp;</td><td>&nbsp;</td>
					</tr>
					<tr>
						<td align="right" class="label"><fmt:message key="Common.Group.label" bundle="${common_labels}"/></td><td class="label" >&nbsp;&nbsp;<select name="group_code" id="group_code" <%=disabled%>><%=phyInvEntryBean.getGroups()%></select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"></td>
					</tr>
					<tr>
						
						<td align="right" class="label"><fmt:message key="eSS.TrayNo.label" bundle="${ss_labels}"/></td><td class="label">&nbsp;&nbsp;<input type="text" value="<%=tray_no%>" name="tray_no"  <%=disabled%> class='NUMBER' onKeyPress="return isValidInteger();"  size="<%=phyInvEntryBean.getSsRepositoryValue("INTEGER_PRECISION")%>" maxLength="<%=phyInvEntryBean.getSsRepositoryValue("INTEGER_PRECISION")%>">
						<img src="../../eCommon/images/mandatory.gif" align="center"></td>
					</tr>
					<tr>
						<td align="right" class="label"><fmt:message key="eSS.BinLocation.label" bundle="${ss_labels}"/></td><td class="label" >&nbsp;&nbsp;<select name="bin_location_code" id="bin_location_code" <%=canDisable%>><%=phyInvEntryBean.getBinLocationsForStore()%></select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"></td>
					</tr>
						<td>&nbsp;</td><td>&nbsp;</td>
					</tr>
					<tr>
						<td align="center" class="label" colspan='2'>
							<input type="button" value="<%=cmdMode%>" name="modify" class="BUTTON" onClick="return addToTable();">
							<input type="button" value="Cancel" name="cancel" id="cancel" class="BUTTON" onClick="disableAll();">
						</td>
					</tr>
					<tr>
						<td>&nbsp;</td><td>&nbsp;</td>
					</tr>
				</table>
			</td>
			</tr>
			</table>
			<input type='hidden' name="description" id="description"		value="">
			<input type='hidden' name="mode" id="mode"			value="<%=phyInvEntryBean.getMode()%>">
			<input type='hidden' name="table_index" id="table_index"		value="-1">
			<input type='hidden' name="tray_code" id="tray_code"		value="">
			<input type="hidden" name="bean_id" id="bean_id"			value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name"		value="<%= bean_name %>">
			<input type="hidden" name="function_id" id="function_id"		value="<%=phyInvEntryBean.getFunctionId()%>">
			<input type="hidden" name="editing_key" id="editing_key"		value="<%=editing_key%>">
			<input type="hidden" name="bin_location_desc" id="bin_location_desc" value="">
			<input type="hidden" name="group_desc" id="group_desc"		value="">
		</form>
		<%
putObjectInBean(bean_id,phyInvEntryBean,request);
%>
	</body>
</html>

