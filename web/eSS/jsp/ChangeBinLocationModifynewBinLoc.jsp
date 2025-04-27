<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="java.sql.*, java.util.*,eSS.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>  
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<html>
	<head>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eSS/js/SsTransaction.js"></script>
		<script language="javascript" src="../../eSS/js/ChangeBinLocationForTray.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
			
		String owner_store_code			=	request.getParameter("owner_store_code");
		String bin_location_code		=	request.getParameter("bin_location_code");
		String bin_desc					=	request.getParameter("bin_desc");
		String store_desc				=	request.getParameter("store_desc");
		String tray_no					=	request.getParameter("tray_no");
		String group_code				=	request.getParameter("group_desc");
		String new_bin_location_code	=	request.getParameter("new_bin_location_code");
//		String new_bin_location_desc	=	request.getParameter("new_bin_location_desc");
	
		String bean_id					=	"changeBinLocationForTrayBean";
		String bean_name				=	 "eSS.ChangeBinLocationForTrayBean";
//		String function_id				=	request.getParameter("function_id");

		
		ChangeBinLocationForTrayBean bean = (ChangeBinLocationForTrayBean) getBeanObject( bean_id,  bean_name, request);  
		bean.clear();
		//bean.setMode(mode);
		//bean.setFunctionId(function_id);
		bean.setOwner_store_code(owner_store_code);
		bean.setNew_bin_location_code(new_bin_location_code);
		//ArrayList binLocation = bean.getBinLocations();
		%>
		<title><fmt:message key="eSS.NewBinLocation.label" bundle="${ss_labels}"/></title>
		<body onMouseDown='CodeArrest();'>
		<form name="formChangeBinLocationForTrayModifyBinLoc" id="formChangeBinLocationForTrayModifyBinLoc">
		<table border="0" cellpadding="1" cellspacing="0" width='100%' align='center' title="Query Criteria">
		<br>
		<tr><td colspan=4>&nbsp;</td></tr>
				<tr>
					<td  class="label"><fmt:message key="eSS.OwnerStore.label" bundle="${ss_labels}"/>&nbsp;&nbsp;</td>
					<td class="QUERYDATA" ><%=bean.checkForNull(store_desc)%></td>
					<td class="label"><fmt:message key="Common.Group.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
					<td class="QUERYDATA" ><%=bean.checkForNull(group_code)%></td>
				</tr>
				<tr><td colspan=4>&nbsp;</td></tr>
				<tr>
					<td  class="label"><fmt:message key="eSS.TrayNo.label" bundle="${ss_labels}"/>&nbsp;&nbsp;</td>
					<td class="QUERYDATA" ><%=tray_no%></td>
					<td  class="label"><fmt:message key="eSS.OldBinLocation.label" bundle="${ss_labels}"/>&nbsp;&nbsp;</td>
					<td class="QUERYDATA" ><%=bean.checkForNull(bin_desc)%></td>
				</tr>
				<tr><td colspan=4>&nbsp;</td></tr>				
				<tr>
					<td  class="label"><fmt:message key="eSS.NewBinLocation.label" bundle="${ss_labels}"/>&nbsp;&nbsp;</td>
					<td class="label" colspan=3><select name="new_bin_location_code" id="new_bin_location_code" ><%=bean.getModNewBinLocation()%></select></td>
				</tr>
				<tr><td colspan=4>&nbsp;</td></tr>
				</table>
				<br>
				 <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		 
				<tr>
				<td colspan='2' width='35%'  align='right' class='BODYCOLORFILLED'><input type='button' class='Button' value='OK' name='OK' id='OK' onClick="checkBinLoc()">&nbsp;</td>
				<td width='40%'  class='BODYCOLORFILLED'  ><input type='button' class='Button' value='Cancel' name='Cancel' id='Cancel' onClick="closeWindow();"></td>
				</tr>
			</table>
			<input type=hidden name="new_bin_location_desc" id="new_bin_location_desc">
		
			<input type=hidden name="bin_location_code" id="bin_location_code" value="<%=bin_location_code%>">
		</form>
<%
	putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>

