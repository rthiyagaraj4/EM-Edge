<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page contentType="text/html;charset=UTF-8"   import="java.util.*, eSS.*, eSS.Common.* , eCommon.Common.*,eSS.PrintCountSheetBean " %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<html>
	<head>
<%
		String sStyle				=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		request.setCharacterEncoding("UTF-8");
		String locale				=		(String)session.getAttribute("LOCALE");

%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eCommon/js/MstCodeCommon.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="javascript" src="../../eSS/js/SterileLabel.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
	    String bean_id				 =		"reportsMasterCodeBean";
		String bean_name			 =		"eSS.ReportsMasterCodeBean";
		ReportsMasterCodeBean bean	 =		(ReportsMasterCodeBean)getBeanObject( bean_id, bean_name, request ) ;
		bean.clear();

		
/*		String mode					=		request.getParameter("mode");
		String function_id			=		request.getParameter("function_id");
		String doc_no				=		null;
		String doc_type_code		=		null;
		String disabled				=		"";
*/		String p_facility_id		=		(String) session.getValue("facility_id");
		String p_user_name			=		(String) session.getValue("login_user");
		
/*		String p_fm_store_code		=		"" ;
		String p_to_store_code		=		"" ;
		String p_fm_curr_store_code	=		"" ;
		String p_to_curr_store_code	=		"" ;
		String p_fm_group_code		=		"";
		String p_to_group_code		=		"" ;
*/
	%>
	<body onLoad="FocusFirstElement();" onMouseDown="CodeArrest()">
		<form name="formSterilelabel" id="formSterilelabel" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame" >
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
					<td class="label" class="label">&nbsp;&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td align="right" >&nbsp;</td>
					<td class="label" class="label">&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				</tr>
				
				<tr>
					<td align="right" class="label"><fmt:message key="eSS.SterReqDocType.label" bundle="${ss_labels}"/></td>
					<td class=label>&nbsp;&nbsp;<input maxLength=6 size=6 name="p_fm_rof_document_type" id="p_fm_rof_document_type" value="" onBlur="convertToUpperCase(this);checkSpecialChars(this);" onKeyPress="return CheckForSpecChars(event);"  class='UPPER'><input class="button" onClick="return searchCode(p_fm_rof_document_type);" type="button" value="?"></td>
					<td class="label">&nbsp;</td>
					<td class=label>&nbsp;&nbsp;<input maxLength=6 size=6 name="p_to_rof_document_type" id="p_to_rof_document_type" value="" onBlur="convertToUpperCase(this);checkSpecialChars(this);" onKeyPress="return CheckForSpecChars(event);"  class='UPPER' ><input class="button" onClick="return searchCode(p_to_rof_document_type);" type="button" value="?"></td>
				</tr>
				<tr>  
					<td align="right" class="label"><fmt:message key="eSS.SterReqDocNo.label" bundle="${ss_labels}"/></td>
					<td class=label>&nbsp;&nbsp;<input class="NUMBER" maxLength=8 size=8 name="p_fm_rof_document_no" id="p_fm_rof_document_no" value="" onkeypress="return isValidNumber(this,event,<%=bean.getSsRepositoryValue("INTEGER_PRECISION")%>,0);"  onBlur="checkIntegerFormat(this);"  ></td>
					<td class="label">&nbsp;</td>
					<td class=label>&nbsp;&nbsp;<input class="NUMBER" maxLength=8 size=8 name="p_to_rof_document_no" id="p_to_rof_document_no" value="" onkeypress="return isValidNumber(this,event,<%=bean.getSsRepositoryValue("INTEGER_PRECISION")%>,0);"  onBlur="checkIntegerFormat(this);"  ></td>
				</tr>
				<tr>
					<td align="right" class="label"><fmt:message key="eSS.AutoclaveUnit.label" bundle="${ss_labels}"/></td>
					<td class=label>&nbsp;&nbsp;<input maxLength=8 size=11 name="p_fm_autoclave_unit" id="p_fm_autoclave_unit" value="" onBlur="convertToUpperCase(this);checkSpecialChars(this);" onKeyPress="return CheckForSpecChars(event);"  class='UPPER' ><input class="button" onClick="return searchCode(p_fm_autoclave_unit);" type="button" value="?" onBlur="convertToUpperCase(this)" ></td>
					<td class="label">&nbsp;</td>
					<td class=label>&nbsp;&nbsp;<input maxLength=8 size=11 name="p_to_autoclave_unit" id="p_to_autoclave_unit" value=""  onBlur="convertToUpperCase(this);checkSpecialChars(this);" onKeyPress="return CheckForSpecChars(event);"  class='UPPER' ><input class="button" onClick="return searchCode(p_to_autoclave_unit);" type="button" value="?"></td>
				</tr>
				<tr>  
					<td align="right" class="label"><fmt:message key="eSS.LoadNo.label" bundle="${ss_labels}"/></td>
					<td class=label>&nbsp;&nbsp;<input class="NUMBER" maxLength=12 size=12 name="p_fm_load_no" id="p_fm_load_no" value="" onKeyPress="return isValidInteger(event);" onBlur="checkIntegerFormat(this);"  ></td>
					<td class="label">&nbsp;</td>
					<td class=label>&nbsp;&nbsp;<input class="NUMBER" maxLength=12 size=12 name="p_to_load_no" id="p_to_load_no" value="" onKeyPress="return isValidInteger(event);" onBlur="checkIntegerFormat(this);"   ></td>
				</tr>
				<tr>  
					<td align="right" class="label"><fmt:message key="eSS.GroupCode.label" bundle="${ss_labels}"/></td>
					<td class=label>&nbsp;&nbsp;<input maxLength=10 size=10 name="p_fm_group_code" id="p_fm_group_code" value="" onBlur="convertToUpperCase(this);checkSpecialChars(this);" onKeyPress="return CheckForSpecChars(event);"  class='UPPER'  ><input class="button" onClick="return searchCode(p_fm_group_code);" type="button" value="?"></td>
					<td class="label">&nbsp;</td>
					<td class=label>&nbsp;&nbsp;<input maxLength=10 size=10 name="p_to_group_code" id="p_to_group_code" value="" onBlur="convertToUpperCase(this);checkSpecialChars(this);" onKeyPress="return CheckForSpecChars(event);"  class='UPPER'  ><input class="button" onClick="return searchCode(p_to_group_code);" type="button" value="?"></td>
				</tr>
				<tr>  
					<td align="right" class="label"><fmt:message key="eSS.TrayNo.label" bundle="${ss_labels}"/></td>
					<td class=label>&nbsp;&nbsp;<input class="NUMBER" maxLength=12 size=12 name="p_fm_curr_tray_no" id="p_fm_curr_tray_no" value="" onKeyPress="return isValidInteger(event);" onBlur="checkIntegerFormat(this);" ></td>
					<td class="label">&nbsp;</td>
					<td class=label>&nbsp;&nbsp;<input class="NUMBER" maxLength=12 size=12 name="p_to_curr_tray_no" id="p_to_curr_tray_no" value="" onKeyPress="return isValidInteger(event);" onBlur="checkIntegerFormat(this);"  ></td>
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
			
			<input type="hidden" name="P_facility_id" id="P_facility_id"							value="<%=p_facility_id%>">
			<input type="hidden" name="p_report_id" id="p_report_id"								value="SSBSTLBL">
			<input type="hidden" name="p_module_id" id="p_module_id"								value="SS">
			<input type="hidden" name="p_user_name" id="p_user_name"								value="<%=p_user_name%>">
			<input type="hidden" name="locale" id="locale"									value="<%=locale%>">
			<input type="hidden" name="SQL_SS_GROUP_LOOKUP" id="SQL_SS_GROUP_LOOKUP"						value="<%= eSS.Common.SsRepository.getSsKeyValue("SQL_SS_GROUP_LOOKUP")%>">
			<input type="hidden" name="SQL_STERILE_LABEL_ROF_DOC_TYPE_LIST" id="SQL_STERILE_LABEL_ROF_DOC_TYPE_LIST"		value="<%= eSS.Common.SsRepository.getSsKeyValue("SQL_STERILE_LABEL_ROF_DOC_TYPE_LIST")%>">
			<input type="hidden" name="SQL_STERILE_LABEL_AUTOCLAVE_UNIT" id="SQL_STERILE_LABEL_AUTOCLAVE_UNIT"		value="<%= eSS.Common.SsRepository.getSsKeyValue("SQL_STERILE_LABEL_AUTOCLAVE_UNIT")%>">
		</form>
	</body>
	<% putObjectInBean(bean_id,bean,request);%>
</html>

