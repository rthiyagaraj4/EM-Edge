<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page contentType="text/html;charset=UTF-8"  import="eSS.*, eSS.Common.* , eCommon.Common.*,java.util.*" %>

<%@ page import="eSS.PrintCountSheetBean" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");

		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String locale			= (String)session.getAttribute("LOCALE");
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<!-- <script language="javascript" src="../../eCommon/js/MstCodeCommon.js"></script> -->
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="javascript" src="../../eSS/js/PrintCountSheet.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		String mode				    =	request.getParameter("mode");
		String bean_id				=	"printCountSheetBean";
		String bean_name			=   "eSS.PrintCountSheetBean";
		String function_id			=	request.getParameter("function_id");
		String p_facility_id		=	(String) session.getValue("facility_id");
		String p_user_name			=	(String) session.getValue("login_user");
		PrintCountSheetBean bean	=	(PrintCountSheetBean) getBeanObject( bean_id, bean_name,request );  
		bean.clear();

		bean.setMode(mode);
		bean.setFunctionId(bean.checkForNull(function_id));

		String p_fm_store_code			=		"" ;
		String p_to_store_code			=		"" ;
		String p_fm_curr_store_code		=		"" ;
		String p_to_curr_store_code		=		"" ;
		String p_fm_group_code			=		"";
		String p_to_group_code			=		"" ;

	%>

	<body onLoad="FocusFirstElement();"onMouseDown="CodeArrest()">
		<form name="formPrintCountSheet" id="formPrintCountSheet" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame" >
		<table border="0" cellpadding="10" cellspacing="0" width='100%' align='center' height='100%'>
			<tr>
			<td width='100%' align='center' class="WHITE">
				<table cellpadding="1" cellspacing="0" width="70%" align="center" border="0">
				<th colspan=4 align=left><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>  
				<tr> 
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
				</tr>  
				<tr>
					<td align="right">&nbsp;</td>
					<td class="label" class="label">&nbsp;&nbsp;<b><fmt:message key="Common.from.label" bundle="${common_labels}"/></b></td>
					<td align="right" >&nbsp;</td>
					<td class="label" class="label">&nbsp;&nbsp;<b><fmt:message key="Common.to.label" bundle="${common_labels}"/></b></td>
				</tr>
				
				<tr>
					<td align="right" class="label"><fmt:message key="eSS.Owner.label" bundle="${ss_labels}"/></td>
					<td class=label>&nbsp;&nbsp;<input maxLength=6 size=6 name="p_fm_store_code" id="p_fm_store_code" value="" onBlur="convertToUpperCase(this)" ><input class="button" onClick="return searchCode(p_fm_store_code,'Store');" type="button" value="?"></td>
					<td class="label">&nbsp;</td>
					<td class=label>&nbsp;&nbsp;<input maxLength=6 size=6 name="p_to_store_code" id="p_to_store_code" value="" onBlur="convertToUpperCase(this)"  ><input class="button" onClick="return searchCode(p_to_store_code,'Store');" type="button" value="?"></td>
				</tr>
				<tr>  
					<td align="right" class="label"><fmt:message key="Common.current.label" bundle="${common_labels}"/></td>
					<td class=label>&nbsp;&nbsp;<input maxLength=6 size=6 name="p_fm_curr_store_code" id="p_fm_curr_store_code" value="" onBlur="convertToUpperCase(this)"  ><input class="button" onClick="return searchCode(p_fm_curr_store_code,'Current');" type="button" value="?"></td>
					<td class="label">&nbsp;</td>
					<td class=label>&nbsp;&nbsp;<input maxLength=6 size=6 name="p_to_curr_store_code" id="p_to_curr_store_code" value="" onBlur="convertToUpperCase(this)"  ><input class="button" onClick="return searchCode(p_to_curr_store_code,'Current');" type="button" value="?"></td>
				</tr>
				<tr>
					<td align="right" class="label"><fmt:message key="Common.Group.label" bundle="${common_labels}"/></td>
					<td class=label>&nbsp;&nbsp;<input maxLength=10 size=10  name="p_fm_group_code" id="p_fm_group_code" value=""  onBlur="convertToUpperCase(this)" ><input class="button" onClick="return searchCode(p_fm_group_code,'Group');" type="button" value="?" onBlur="convertToUpperCase(this)" ></td>
					<td class="label">&nbsp;</td>
					<td class=label>&nbsp;&nbsp;<input maxLength=10 size=10  name="p_to_group_code" id="p_to_group_code" value=""  onBlur="convertToUpperCase(this)" ><input class="button" onClick="return searchCode(p_to_group_code,'Group');" type="button" value="?"></td>
				</tr>
				<tr>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
				</tr>
				</table>
				</td>
				</tr>
			</table>
			
			<input type="hidden" name="P_facility_id" id="P_facility_id"									value="<%=p_facility_id%>">
			<input type="hidden" name="from_group_desc" id="from_group_desc"									value="<%=p_fm_group_code%>">
			<input type="hidden" name="to_group_desc" id="to_group_desc"									value="<%=p_to_group_code%>">
			<input type="hidden" name="from_store_desc" id="from_store_desc"									value="<%=p_fm_store_code%>">
			<input type="hidden" name="to_store_desc" id="to_store_desc"									value="<%=p_to_store_code%>">
			<input type="hidden" name="from_curr_desc" id="from_curr_desc"									value="<%=p_fm_curr_store_code%>">
			<input type="hidden" name="to_curr_desc" id="to_curr_desc"									value="<%=p_to_curr_store_code%>">
			<input type="hidden" name="bean_id" id="bean_id"											value="<%=bean_id%>"> 			
			<input type="hidden" name="bean_name" id="bean_name"										value="<%=bean_name%>"> 
			<input type="hidden" name="p_report_id" id="p_report_id"										value="SSBPHSHT">
			<input type="hidden" name="p_module_id" id="p_module_id"										value="SS">
			<input type="hidden" name="locale" id="locale"											value="<%=locale%>">
			<input type="hidden" name="p_user_name" id="p_user_name"										value="<%=p_user_name%>">
			<input type="hidden" name="P_AT_WS_NO" id="P_AT_WS_NO"										value="<%=bean.getLoginAtWsNo()%>">
			<input type='hidden' name="trn_type" id="trn_type"										value="ROF">
			<input type="hidden" name="orderbycolumns" id="orderbycolumns"									value="doc_type_code,doc_no">
			<input type="hidden" name="SQL_SS_GROUP_LOOKUP" id="SQL_SS_GROUP_LOOKUP"								value="<%= eSS.Common.SsRepository.getSsKeyValue("SQL_SS_GROUP_LOOKUP")%>">
			<input type="hidden" name="SQL_SS_STORE_PRINT_COUNT_OWNER_SELECT_LIST" id="SQL_SS_STORE_PRINT_COUNT_OWNER_SELECT_LIST"		value="<%= eSS.Common.SsRepository.getSsKeyValue("SQL_SS_STORE_PRINT_COUNT_OWNER_SELECT_LIST")%>">
			<input type="hidden" name="SQL_SS_STORE_PRINT_COUNT_ALL_SELECT_LIST" id="SQL_SS_STORE_PRINT_COUNT_ALL_SELECT_LIST"		value="<%= eSS.Common.SsRepository.getSsKeyValue("SQL_SS_STORE_PRINT_COUNT_ALL_SELECT_LIST")%>">
		</form>
<%
	putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>

