<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
		<title></title>
		<meta name="Author" content="Mahesh">
	<%
		request.setCharacterEncoding("UTF-8");
		String locale			=		(String)session.getAttribute("LOCALE");
		String sStyle			=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="javascript" src="../../eST/js/InspectionBoardReport.js"></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</head>
	<%
		String facility_id  =	(String) session.getValue( "facility_id" ) ;
		String user_name	=	(String)session.getAttribute("appl_user_name");
		eST.AcknowledgmentBean bean = (eST.AcknowledgmentBean)getBeanObject( "acknowledgmentBean","eST.AcknowledgmentBean",request );
		bean.setLanguageId(locale);
		//String doc_type_code = (String)bean.fetchRecord("SELECT DEF_ADJ_DOC_TYPE_CODE DOC_TYPE_CODE FROM ST_FACILITY_PARAM WHERE FACILITY_ID = ? AND MATERIAL_GROUP_CODE = 'ALL'",facility_id).get("DOC_TYPE_CODE"); //ML-MMOH-SCF-2212
	%>
	<body onLoad="FocusFirstElement();">
		<form name="formInspectionBoardReportCriteria" id="formInspectionBoardReportCriteria" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame"  onReset="FocusFirstElement();">
		
		<table border="0" cellpadding="0" cellspacing="0" width='95%' align='center' >
			<tr>
				<th align="left" colspan = 10><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
			</tr>
			<tr>
				<td class=label>Condemn ID</td>
				<td class=fields>&nbsp;&nbsp;<input type=text name="p_condemn_id" id="p_condemn_id" size=10 maxlength=10 value="" onKeyPress="return CheckForSpecChars(event);">
				</td>
				<td colspan=8>&nbsp;</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td class="fields" >&nbsp;&nbsp;&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
				<td>&nbsp;</td>
				<td class="fields">&nbsp;&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
			</tr>
			<tr>
				<td align="left" class="label"><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></td>
				<td class=fields>&nbsp;&nbsp;<input maxLength=20 size=20  name="p_fm_item_code" id="p_fm_item_code" value="" onKeyPress="return CheckForSpecChars(event);"><input class="button" name="p_fm_sr2" id="p_fm_sr2" onClick="return searchCodeItem(p_fm_item_code);" type="button" value="?"></td>
				<td class="label">&nbsp;</td>
				<td class=fields colspan=5>&nbsp;&nbsp;<input maxLength=20 size=20 name="p_to_item_code" id="p_to_item_code" value="" onKeyPress="return CheckForSpecChars(event);" ><input class="button" name="p_to_sr2" id="p_to_sr2" onClick="return searchCodeItem(p_to_item_code);" type="button" value="?"  ></td>
			</tr>
			<tr>
				<td align="left" class="label"><fmt:message key="Common.ItemClass.label" bundle="${common_labels}"/></td>
				<td class=fields>&nbsp;&nbsp;<input maxLength=4 size=4 name="p_fm_item_class_code" id="p_fm_item_class_code" value="" onKeyPress="return CheckForSpecChars(event);"><input class="button" onClick="return searchCodeItemClass(p_fm_item_class_code);" type="button" value="?"></td>
				<td class="label">&nbsp;</td>
				<td class=fields colspan=5>&nbsp;&nbsp;<input maxLength=4 size=4 name="p_to_item_class_code" id="p_to_item_class_code" value="" onKeyPress="return CheckForSpecChars(event);"><input class="button" onClick="return searchCodeItemClass(p_to_item_class_code);" type="button" value="?"></td>
			</tr>
			<tr>
				<td class="label" align="left"><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></td>
				<td class=fields>&nbsp;&nbsp;<input type=text name="dt_from" id="dt_from" size=10 maxlength=10 class="DATE" value="" onBlur="CheckDate(this);" onKeyPress="return CheckForSpecChars(event);">
				<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('dt_from');" ></img>
				&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td class="label">&nbsp;</td><td class=fields colspan=5>&nbsp;&nbsp;<input type=text name="dt_to" id="dt_to" size=10 maxlength=10 class="DATE" value="" onBlur="CheckDate(this);" onKeyPress="return CheckForSpecChars(event);">
				<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('dt_to');" ></img>
				&nbsp;&nbsp;&nbsp;&nbsp;</td>
			</tr>
			
			<tr>
				<td align="left" class="label"><fmt:message key="Common.StoreCode.label" bundle="${common_labels}"/></td>
				<td class=fields>&nbsp;&nbsp;<input maxLength=6 size=6 name="p_fm_store_code" id="p_fm_store_code"  value="" onKeyPress="return CheckForSpecChars(event);"><input class="button"  onClick="return searchCodeStore(p_fm_store_code);"  type="button" value="?"></td>
				<td class="label">&nbsp;</td>
				<td class=fields colspan=5>&nbsp;&nbsp;<input maxLength=6 size=6  name="p_to_store_code" id="p_to_store_code" value="" onKeyPress="return CheckForSpecChars(event);"> <input class="button" onClick="return searchCodeStore(p_to_store_code);"  type="button" value="?" ></td>
			</tr>
			
			<tr>
				<td class="label" align="left"><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/></td>
				<td class=fields>&nbsp;&nbsp;<input type=text name="p_fm_batch_id" id="p_fm_batch_id" size=10 maxlength=10 value="" onKeyPress="return CheckForSpecChars(event);"></td>
				<td class="label">&nbsp;</td>
				<td class=fields>&nbsp;&nbsp;<input type=text name="p_to_batch_id" id="p_to_batch_id" size=10 maxlength=10 value="" onKeyPress="return CheckForSpecChars(event);"></td>
			</tr>
			<tr>
				<td class="label" align="left">Condenmed Date</td>
				<td class=fields>&nbsp;&nbsp;<input type=text name="cond_dt_from" id="cond_dt_from" size=10 maxlength=10 class="DATE" value="" onBlur="CheckDate(this);" onKeyPress="return CheckForSpecChars(event);">
				<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('cond_dt_from');" ></img>
				&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td class="label">&nbsp;</td><td class=fields colspan=5>&nbsp;&nbsp;<input type=text name="cond_dt_to" id="cond_dt_to" size=10 maxlength=10 class="DATE" value="" onBlur="CheckDate(this);" onKeyPress="return CheckForSpecChars(event);">
				<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('cond_dt_to');" ></img>
				&nbsp;&nbsp;&nbsp;&nbsp;</td>
			</tr>
			<tr>
				<td align="left" class="label"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/> &nbsp;<fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
				<td class=fields>&nbsp;&nbsp;<input maxLength=10 size=10 name="p_fm_remarks_code" id="p_fm_remarks_code"  value="" onKeyPress="return CheckForSpecChars(event);"><input class="button" onClick="return searchRemarksCode(p_fm_remarks_code);"  type="button" value="?"></td>
				<td class="label">&nbsp;</td>
				<td class=fields colspan=5>&nbsp;&nbsp;<input maxLength=10 size=10  name="p_to_remarks_code" id="p_to_remarks_code" value="" onKeyPress="return CheckForSpecChars(event);"> <input class="button" onClick="return searchRemarksCode(p_to_remarks_code);"  type="button" value="?" ></td>
			</tr>
		</table>
		<input type="hidden" name="p_module_id" id="p_module_id" 	value="ST">
		<input type="hidden" name="p_report_id" id="p_report_id"		value="STBIBRDC">
		<input type="hidden" name="p_user_name" id="p_user_name"		value="<%=user_name%>">
		<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%=facility_id%>">
		<input type="hidden" name="p_language_id" id="p_language_id"	value="<%=locale%>">
		<input type="hidden" name="p_doc_type_code" id="p_doc_type_code"	value=""><!--ML-MMOH-SCF-2212-- removed as doc_type_code-->
		<input type="hidden" name="SQL_ST_ITEM_CLASS_LOOKUP_LANG" id="SQL_ST_ITEM_CLASS_LOOKUP_LANG" value="<%=eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_CLASS_LOOKUP_FOR_REPORT")%>">
		</form>
		<input type="hidden" name="SQL_ST_STORE_LOOKUP" id="SQL_ST_STORE_LOOKUP"	value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_STORE_LOOKUP_FOR_REPORT")%>">
		<input type="hidden" name="SQL_ST_ITEM_LOOKUP" id="SQL_ST_ITEM_LOOKUP" value="<%=eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_LOOKUP")%>">
	</body>
</html>	

