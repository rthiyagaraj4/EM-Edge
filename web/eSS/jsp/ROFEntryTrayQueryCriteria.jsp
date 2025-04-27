<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ page import="eSS.TrayNoSearchBean" contentType="text/html;charset=UTF-8"%>
<html> 
	<head> 
<%		
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle				=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="javascript" src="../../eSS/js/ROFEntry.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onLoad='FocusFirstElement();' onMouseDown="CodeArrest()">
	<%
		String group_code			=		request.getParameter("group_code");
		String group_desc			=		request.getParameter("group_desc");
		String store_code			=		request.getParameter("store_code");
		String mode					=		request.getParameter("mode");
		String wash_yn				=		request.getParameter("wash_yn");
		String sterilize_yn			=		request.getParameter("sterilize_yn");
		String pack_yn				=		request.getParameter("pack_yn");
		String tray_no				=		 request.getParameter("tray_no");

		if (wash_yn == null) {
			wash_yn					=		"N";
		}
		if (pack_yn == null) {
			pack_yn					=		"N";
		}
		if (sterilize_yn == null) {
			sterilize_yn			=		"N";
		}

		String disabled				=		"disabled";
		String bean_id				=		"trayNoSearchBean";
		String bean_name			=		"eSS.TrayNoSearchBean";
		TrayNoSearchBean bean		=		(TrayNoSearchBean)getBeanObject( bean_id, bean_name, request ) ;

		bean.clear();
		bean.setMode(mode);
		bean.setLoginFacilityId((String)session.getAttribute("facility_id")) ;
		bean.setStore_code(store_code);
		bean.setLanguageId(locale);
		%>
		<form name="formROFEntryTrayQueryCriteria" id="formROFEntryTrayQueryCriteria" action="../../eSS/jsp/ROFEntryTrayQueryResult.jsp" method="post" target="frameROFEntryTrayQueryResult" onreset="FocusFirstElement();">
			<table border="0" cellpadding="1" cellspacing="0" width='100%' height='100%' align='center'>
				<tr>
					<td class="label"><fmt:message key="Common.Group.label" bundle="${common_labels}"/></td>
					<td class="label">&nbsp;<input name="group_desc" id="group_desc" maxLength='15' size='15' readOnly value="<%=group_desc%>" <%=disabled%>><input type="hidden" value="<%=group_code%>" name="group_code"><input type="button" class="BUTTON" value='?' onClick="searchGroupCode(group_code, group_desc);" <%=disabled%>></td>
					<td class="label"><fmt:message key="eSS.TrayNo.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;<input type='text' name="tray_no" id="tray_no" value="<%=bean.checkForNull(tray_no)%>" size='<%=bean.getSsRepositoryValue("INTEGER_PRECISION")%>' maxLength='<%=bean.getSsRepositoryValue("INTEGER_PRECISION")%>' class="NUMBER" onKeyPress="return isValidInteger();"></td>
				</tr>
				<tr>
					<td class="label"><fmt:message key="eSS.BinLocation.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;<select name="bin_location_code" id="bin_location_code"><%=bean.getBinLocations() %></select></td>
 					<td class="label"> </td>
					<td class="label">&nbsp;<input type='submit' class='Button' value='Search' name='search' id='search'></td>
				</tr>
			</table>
			<br>
			<input type="hidden" name="wash_yn" id="wash_yn"			value="<%=wash_yn%>">
			<input type="hidden" name="pack_yn" id="pack_yn"			value="<%=pack_yn%>">
			<input type="hidden" name="sterilize_yn" id="sterilize_yn"	value="<%=sterilize_yn%>">
			<input type="hidden" name="function_id" id="function_id"		value="<%=request.getParameter("function_id")%>">
			<input type="hidden" name="orderbycolumns" id="orderbycolumns"  value="group_code,tray_no">
			<input type="hidden" name="SQL_SS_GROUP_LOOKUP" id="SQL_SS_GROUP_LOOKUP" value="<%= bean.getSsRepositoryValue("SQL_SS_GROUP_LOOKUP")%>">
	</form>
	</body>
	<%	putObjectInBean(bean_id,bean,request);%>
</html>

