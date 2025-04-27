<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="eSS.PrintCountSheetBean" %>
<!-- <%@ include file="../../eCommon/jsp/Common.jsp" %> --> 
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@page contentType="text/html;charset=UTF-8"  import="eSS.*, eSS.Common.* , eCommon.Common.*,java.util.*" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
<%
			String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
			request.setCharacterEncoding("UTF-8");
			String locale= (String)session.getAttribute("LOCALE");

%>
	    <link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<!--<!-- <script language="javascript" src="../../eCommon/js/MstCodeCommon.js"></script> -->
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="javascript" src="../../eSS/js/GroupMovementStatisticsReport.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
/*		String mode					=		request.getParameter("mode");
	
		String function_id			=		request.getParameter("function_id");
		String doc_no				=		null;
		String doc_type_code		=		null;
		String disabled				=		"";*/
		String p_facility_id		=		(String) session.getValue("facility_id");
		String p_user_name			=		(String) session.getValue("login_user");
		

/*		String p_fm_store_code		=		"" ;
		String p_to_store_code		=		"" ;
		String p_fm_curr_store_code =		"" ;
		String p_to_curr_store_code	=		"" ;
		String p_fm_group_code		=		"";
		String p_to_group_code		=		"" ;*/

	%>
	<body onLoad="FocusFirstElement();"onMouseDown="CodeArrest()"> 
		<form name="formDispatch" id="formDispatch" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame" >
		<table border="0" cellpadding="10" cellspacing="0" width='100%' align='center' height='100%'>
			<tr>
			<td width='100%' align='center' class="WHITE">
				<table cellpadding="1" cellspacing="0" width="70%" align="center" border="0">
				<tr><th colspan=4 align=left><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th></tr>
				<tr>
					<td align="right" width='20%'>&nbsp;</td>
					<td align="right" width='30%'>&nbsp;</td>
					<td align="right" width='20%'>&nbsp;</td>
					<td align="right" width='30%'>&nbsp;</td>
				</tr>  
				<tr>
					<td align="right">&nbsp;</td>
					<td class="label" class="label" >&nbsp;&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td align="right" >&nbsp;</td>
					<td class="label" class="label">&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				</tr>
					
				<tr>
					<td align="right" class="label"><fmt:message key="Common.Group.label" bundle="${common_labels}"/></td>
					<td class=label>&nbsp;&nbsp;<input maxLength=10 size=10 name="p_fm_group_code" id="p_fm_group_code" value=""  onBlur="convertToUpperCase(this)" ><input class="button" onClick="return searchCode(p_fm_group_code,'Group');" type="button" value="?" onBlur="convertToUpperCase(this)" ></td>
					<td class="label">&nbsp;</td>
					<td class=label>&nbsp;&nbsp;<input maxLength=10 size=10 name="p_to_group_code" id="p_to_group_code" value=""  onBlur="convertToUpperCase(this)" ><input class="button" onClick="return searchCode(p_to_group_code,'Group');" type="button" value="?"></td>
				</tr>
				<tr>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
				</tr>
				<tr>
					<td align="right" class="label"><fmt:message key="Common.Store.label" bundle="${common_labels}"/></td>
					<td class=label>&nbsp;&nbsp;<input maxLength=6 size=8 name="p_fm_store_code" id="p_fm_store_code" value="" onBlur="convertToUpperCase(this);checkSpecialChars(this);" onKeyPress="return CheckForSpecChars(event);"  class='UPPER' ><input class="button" onClick="return searchCode(p_fm_store_code,'Store');" type="button" value="?" onBlur="convertToUpperCase(this)" ></td>
					<td class="label">&nbsp;</td>
					<td class=label>&nbsp;&nbsp;<input maxLength=6 size=8 name="p_to_store_code" id="p_to_store_code" value=""  onBlur="convertToUpperCase(this);checkSpecialChars(this);" onKeyPress="return CheckForSpecChars(event);"  class='UPPER' ><input class="button" onClick='return searchCode(p_to_store_code,"Store");' type="button" value="?"></td>
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
			
			<input type="hidden" name="P_facility_id" id="P_facility_id"			value="<%=p_facility_id%>">
			<input type="hidden" name="p_report_id" id="p_report_id"				value="SSBGRPMV">
			<input type="hidden" name="p_module_id" id="p_module_id"				value="SS">
			<input type="hidden" name="p_user_name" id="p_user_name"				value="<%=p_user_name%>">
			<input type="hidden" name="locale" id="locale"					value="<%=locale%>">
			<input type="hidden" name="SQL_SS_STORE_LOOKUP" id="SQL_SS_STORE_LOOKUP"		value="<%= eSS.Common.SsRepository.getSsKeyValue("SQL_SS_STORE_LOOKUP")%>">
			<input type="hidden" name="SQL_SS_GROUP_LOOKUP" id="SQL_SS_GROUP_LOOKUP"		value="<%= eSS.Common.SsRepository.getSsKeyValue("SQL_SS_GROUP_LOOKUP")%>">
			</form>
	</body>
</html>

