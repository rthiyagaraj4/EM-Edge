<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, java.lang.*,eST.*, eST.Common.* , eCommon.Common.*"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			=	(String)session.getAttribute("LOCALE");
		String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
<!--	<link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
<!-- 	<script language="javascript" src="../../eCommon/js/messages.js"></script> -->
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
<!-- 	<script language="javascript" src="../../eST/js/StMessages.js"></script> -->
		<script language="javascript" src="../../eST/js/TransAnalysisReport.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
	</head>
	<%
		
		String bean_id				=		"TransAnalysisBean";
		String bean_name			=		"eST.TransAnalysisBean";
//		String p_report_id			=		null;
		String facility_id			=		(String) session.getValue( "facility_id" ) ;
		String user_name			=		(String) session.getValue( "login_user" ) ;
		
		
		TransAnalysisBean bean		=		(TransAnalysisBean) getBeanObject( bean_id, bean_name, request );
		bean.clear();
		bean.setLanguageId(locale);
		bean.setAcc_entity_id((String)session.getAttribute("ACC_ENTITY_ID"));
		
		
	%>
	<body onLoad="FocusFirstElement();">
		<form name="formUnfinalizedTransactions" id="formUnfinalizedTransactions" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame" >
		<br><br>
		<table border="0" cellpadding="0" cellspacing="0" width='75%' align='center' >
			<tr>
			<td width='100%' align='center' class="WHITE">
				<table cellpadding="0" cellspacing="0" width="98%" align="center" border="0">
				<th colspan=8 align=left><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/> </th>
				<tr>
					<td align="right" class="label"><fmt:message key="Common.transactiontype.label" bundle="${common_labels}"/> </td>
					<td class=fields>&nbsp;&nbsp;<select name="p_trn_code" id="p_trn_code" ><%=bean.getTrn_code_list()%>
					</select></td>		
					<td class="label">&nbsp;</td>
					<td class=label>&nbsp;&nbsp;</td>
				</tr>

				<tr>
					<td align="right">&nbsp;</td>
					<td class="fields" >&nbsp;&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/> </td>
					<td align="right" >&nbsp;</td>
					<td class="fields" colspan=5  width="49%">&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/> </td>
				</tr>
				<tr>
					<td align="right" class="label"><fmt:message key="Common.Store.label" bundle="${common_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=6 size=6 name="p_fm_str_code" id="p_fm_str_code" value="" ><input class="button" onClick="return searchCodeStore(p_fm_str_code);" type="button" value="?"></td>
					<td class="label">&nbsp;</td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=6 size=6 name="p_to_str_code" id="p_to_str_code" value="" ><input class="button" onClick="return searchCodeStore(p_to_str_code);" type="button" value="?"></td>
				</tr>
				
				<tr>
					<td align="right" class="label"><fmt:message key="Common.DocTypeCode.label" bundle="${common_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=6 size=6 name="p_fr_doc_type" id="p_fr_doc_type" value="" ><input class="button"  onClick="return searchDocType(p_fr_doc_type);" type="button" name="p_fr_sr" id="p_fr_sr" value="?"></td>
					<td class="label">&nbsp;</td>
					<td class=fields colspan=5>&nbsp;&nbsp;<input maxLength=6 size=6  name="p_to_doc_type" id="p_to_doc_type" value="" ><input class="button" onClick="return searchDocType(p_to_doc_type);" type="button"  name="p_to_sr" id="p_to_sr" value="?"></td>
				</tr>
				<tr>
					<td align="right" class="label"><fmt:message key="Common.DocNo.label" bundle="${common_labels}"/></td>
					<td class=fields >&nbsp;&nbsp;<input class="NUMBER" maxLength=10 size=10 name="p_fm_doc_no" id="p_fm_doc_no" value="" onKeyPress="numbervalidation();"></td><td class="label">&nbsp;</td>
					<td align="left" class="fields" colspan=5>&nbsp;&nbsp;<input class="NUMBER" maxLength=10 size=10  name="p_to_doc_no" id="p_to_doc_no" value="" onKeyPress="numbervalidation();"></td>
				</tr>
				<tr>
					<td class=label align=right><fmt:message key="Common.DocDate.label" bundle="${common_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input type=text name=dt_from_1 size=10 maxlength=10 class="DATE" value="" onBlur="CheckDate(this,'<%=locale%>');"  ><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('dt_from_1');" ></img>&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td class="label">&nbsp;</td><td class=fields colspan=5>&nbsp;&nbsp;<input type=text name=dt_to_1 size=10 maxlength=10 class="DATE" value="" onBlur="CheckDate(this,'<%=locale%>');"  ><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('dt_to_1');" ></img>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				</tr>
				
				<tr>
					<td align="right" class="label" colspan = 8>&nbsp;</td>

		        
				</table>
				</td>  

				</tr>
			</table>

			
			<input type="hidden" name="bean_id" id="bean_id"								value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name"							value="<%=bean_name%>">
			<input type="hidden" name="p_module_id" id="p_module_id" 						value="ST">
			<input type="hidden" name="p_report_id" id="p_report_id" 						value="STBUNFTR">
			<input type="hidden" name="dt_from" id="dt_from" 							value="">
			<input type="hidden" name="dt_to" id="dt_to" 								value="">
			<input type="hidden" name="p_user_name" id="p_user_name"							value="<%=user_name%>">
			<input type="hidden" name="p_facility_id" id="p_facility_id"						value="<%=facility_id%>">
			<input type="hidden" name="p_language_id" id="p_language_id"						value="<%=locale%>">
			

		</form>
			<input type="hidden" name="SQL_ST_STORE_LOOKUP" id="SQL_ST_STORE_LOOKUP"					value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_STORE_LOOKUP_FOR_REPORT")%>">
			<input type="hidden" name="SQL_ST_ITEM_LOOKUP" id="SQL_ST_ITEM_LOOKUP"					value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_LOOKUP")%>">
			<input type="hidden" name="SQL_ST_ITEM_CLASS_LOOKUP_LANG" id="SQL_ST_ITEM_CLASS_LOOKUP_LANG"		value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_CLASS_LOOKUP_FOR_REPORT")%>">
			<input type="hidden" name="SQL_ST_TRN_DOC_TYPE_LOOKUP" id="SQL_ST_TRN_DOC_TYPE_LOOKUP"			value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_TRN_DOC_TYPE_LOOKUP")%>">
			  <%
putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>	

