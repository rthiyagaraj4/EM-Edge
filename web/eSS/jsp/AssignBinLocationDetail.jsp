<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@page contentType="text/html;charset=UTF-8" import=" eSS.*, eSS.Common.* , eCommon.Common.*, java.text.*, java.util.*" %>

<%@ page import="eSS.AssignBinLocationBean" %>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

request.setCharacterEncoding("UTF-8");

%>

<html>
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="javascript" src="../../eSS/js/AssignBinLocation.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		String bean_id				=		"assignBinLocationBean";
		String bean_name			=		"eSS.AssignBinLocationBean";
		String disabled				=		 "";
		AssignBinLocationBean bean	=		(AssignBinLocationBean) getBeanObject( bean_id,  bean_name, request);
		String tray_no				=	request.getParameter("tray_no");
	

		java.util.HashMap defaultParameter	=	 null;
		defaultParameter					=	bean.getSSParameter();
		String table_index					=	bean.checkForNull(request.getParameter("table_index"),"-1");
		String selected_bin_location_code   =	 bean.checkForNull(request.getParameter("selected_bin_location_code"));
		String store_code					=	 bean.checkForNull(request.getParameter("store_code"));
		bean.setSelected_bin_location_code(selected_bin_location_code);
		bean.setStore_code(store_code);
		
		if (tray_no == null) {
			tray_no			=	"";
			disabled		= "disabled";
		}
	%>

	<body onMouseDown="CodeArrest();">
		<form name="formAssignBinLocationDetail" id="formAssignBinLocationDetail" action="../../eSS/jsp/AssignBinLocationList.jsp" method="post" target="AssignBinLocationListFrame">
			<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' height='100%'>
			<tr>
			<td width='100%' height='100%' align='center' valign='top'>
				<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center'>
					<tr>
						<td>&nbsp;</td><td>&nbsp;</td>
					</tr>
					<tr>
						<td align="right" class="label"><fmt:message key="eSS.TrayNo.label" bundle="${ss_labels}"/></td><td class="label">&nbsp;&nbsp;<input type="text" name="tray_no" id="tray_no" size="12" maxlength =  "12" class="NUMBER" value="<%=tray_no%>" disabled ></td>
					</tr>
					<tr>
						<td align="right" class="label"><fmt:message key="eSS.BinLocation.label" bundle="${ss_labels}"/></td><td class="label" >&nbsp;&nbsp;<select name="bin_location_code" id="bin_location_code" 				<%=disabled%>><%=bean.getBinLocations(store_code)%></select>&nbsp;<IMG src="../../eCommon/images/mandatory.gif" align=center></td>
					</tr>
						<td>&nbsp;</td><td>&nbsp;</td>
					</tr>
					<tr>
						<td align="center" class="label" colspan='2'>
							<input type="button" value="Modify" name="modify" id="modify" class="BUTTON" <%=disabled%> onClick="updateTrayNo();">
							<input type="button" value="Cancel" name="cancel" id="cancel" class="BUTTON" <%=disabled%> onClick="disableAll();">
						</td>
					</tr>
					<tr>
						<td>&nbsp;</td><td>&nbsp;</td>
					</tr>
				</table>
			</td>
			</tr>
			</table>
			<input type='hidden' name="description" id="description" value="">
			<input type='hidden' name="mode" id="mode" value="<%=bean.getMode()%>">
			<input type='hidden' name="table_index" id="table_index" value="<%=table_index%>">
			<input type='hidden' name="tray_code" id="tray_code" value="">
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
			<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
		</form>
<%
	putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>

