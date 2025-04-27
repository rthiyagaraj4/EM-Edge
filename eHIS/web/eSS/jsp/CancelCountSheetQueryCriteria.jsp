<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page contentType="text/html;charset=UTF-8"  import="eSS.*, eSS.Common.* , eCommon.Common.*,java.util.*" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ page import="eSS.CancelCountSheetBean" %>

<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
		String sStyle	=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String locale	=	(String)session.getAttribute("LOCALE");
%>


		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<!-- <script language="javascript" src="../../eCommon/js/MstCodeCommon.js"></script> -->
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="javascript" src="../../eSS/js/CancelCountSheet.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		String bean_id			=		"cancelCountSheetBean";
		String bean_name		=		"eSS.CancelCountSheetBean";
		String mode				=		request.getParameter("mode");

		CancelCountSheetBean cancelCountSheetBean = (CancelCountSheetBean) getBeanObject( bean_id,  bean_name, request);  
		cancelCountSheetBean.clear();
		cancelCountSheetBean.setMode(mode);
		cancelCountSheetBean.setLanguageId(locale);
	
	%>	
	<body onLoad="FocusFirstElement();" onMouseDown="CodeArrest()">
		<form name="formCancelCountSheetHeader" id="formCancelCountSheetHeader" action="../../eSS/jsp/CancelCountSheetQueryResult.jsp" method="GET" target="frameCancelCountSheetQueryResult">
			<table border="0" cellpadding="0" cellspacing="0" width='100%' height='100%' align='center'><tr><td>
				<table border="0" cellpadding="0" cellspacing="0" width='100%' >
				<tr>
					<td align="right" class="label"><fmt:message key="eSS.PhysicalInvId.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<select name="phy_inv_id" id="phy_inv_id"><%=cancelCountSheetBean.getPhyInvIds()%></select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align=center></td>
					<td align="right" class="label"><fmt:message key="eSS.OwnerStore.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<select name="owner_store_code" id="owner_store_code"><%=cancelCountSheetBean.getOwnerStores()%></select></td>
					<td align="right" class="label"><fmt:message key="eSS.CurrentStore.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<select name="current_store_code" id="current_store_code"><%=cancelCountSheetBean.getCurrentStores()%></select></td>
				</tr>
				<tr>
					<td colspan='6' align='right'>&nbsp;</td>
				</tr>
				<tr>
					<td colspan='6' align='right'><input type="button" value="Search" class="BUTTON" onClick="checkMandatory();"></td>
				</tr>
				</table>
			</td>
			</tr>
			</table>
			<input type='hidden' name="mode" id="mode" value="<%=mode%>">
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
			<input type="hidden" name="locale" id="locale" value="<%= locale %>">
			<input type="hidden" name="function_id" id="function_id" value="<%=cancelCountSheetBean.getFunctionId()%>">
		</form>
<%
	putObjectInBean(bean_id,cancelCountSheetBean,request);
%>
	</body>
</html>

