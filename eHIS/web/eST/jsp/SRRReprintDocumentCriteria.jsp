<!DOCTYPE html>

<%@page contentType="text/html;charset=UTF-8" import="java.util.*, eST.*, eST.Common.* , eCommon.Common.*,java.sql.*,java.lang.*,webbeans.eCommon.*"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
		request.setCharacterEncoding("UTF-8");
		String locale			=		(String)session.getAttribute("LOCALE");
		String sStyle			=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
<!-- 	<script language="javascript" src="../../eCommon/js/messages.js"></script> -->
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
<!-- 	<script language="javascript" src="../../eST/js/StMessages.js"></script> -->
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="javascript" src="../../eST/js/SRRReprintDocument.js"></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		
		String bean_id				=		"SRRRePrintDocReportBean";
		String bean_name			=		"eST.SRRRePrintDocReportBean";
	//	String p_report_id			=		null;
		String facility_id			=		(String) session.getValue( "facility_id" ) ;
		String user_name			=		(String) session.getValue( "login_user" ) ;
		SRRRePrintDocReportBean bean	=		(SRRRePrintDocReportBean) getBeanObject( bean_id,  bean_name, request);  
		bean.setLanguageId(locale);
	%>
	<body onLoad="FocusFirstElement();">
		<form name="ReprintDocumentCriteria" id="ReprintDocumentCriteria" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame" onReset="FocusFirstElement();">
		<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' height='100%'>
			<td width='100%' align='center' class="WHITE"  height='100%'>
				<table cellpadding="0" cellspacing="0" width="90%" align="center" border="0"  height='100%'>
				<th colspan=4 align=left><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
				<tr><td  class="label" colspan='4'>&nbsp;&nbsp;</td> </tr>		
				<tr>	
					<td class="label" ><fmt:message key="Common.Transaction.label" bundle="${common_labels}"/></td>
					<td>&nbsp;&nbsp;<select name="p_trn_type" id="p_trn_type" onChange="populateDocTypeCode(this.value)">
						<%=bean.getListOptionTag(bean.getListOptionArrayList("  SELECT TRN_TYPE, DECODE(TRN_TYPE,'SAL','Sales Voucher','SRT','Sales Return Voucher',LONG_DESC) LONG_DESC FROM ST_TRN_TYPE_LANG_VW  WHERE TRN_TYPE NOT IN ('PRT','OBS','SPB','CBL')  AND language_id=?  ORDER BY 2",locale))%>
						<option value="AIS"  >Authorize at Issue store</option>
						</select><%=bean.getImage("M")%></td>
						<%
						//String select_legend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
						String select_option="<option value=\"\">&nbsp;&nbsp;&nbsp;&nbsp;---"+	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" ---&nbsp;&nbsp;&nbsp;&nbsp;</option>";
						
						//bean.getStRepositoryValue("DEFAULT_LIST_OPTION")
						%> 
					<td  class="label" ><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></td>
					<td>&nbsp;&nbsp;<select name="doc_type_code" id="doc_type_code" >
						
						<%=select_option%>
						</select> </td>
				</tr>
				<tr>
					<td class=label align=right><fmt:message key="Common.item.label" bundle="${common_labels}"/></td>
				</td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=20 size=20 name="p_item_desc" id="p_item_desc" value=""  tabindex='5'><input class="button" name="p_fm_sr2" id="p_fm_sr2" onClick="return searchCodeItem(p_item_desc);" type="button" value="?" tabindex='6'><input type="hidden" name="p_item_code" id="p_item_code" value=""></td>

					<td class="label" ><fmt:message key="Common.DocNo.label" bundle="${common_labels}"/></td>
					<td>&nbsp;&nbsp;<input class="NUMBER" type="text" size="8" maxlength="8" 
						onKeyPress="return isValidInteger();" name="doc_no" id="doc_no" 
						onBlur="return checkIntegerFormat(this);" ></td>
				</tr>

				<tr>
					<td  class="label"><fmt:message key="eST.RequestbyStore.label" bundle="${st_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=20 size=20 name="p_reqby_st" id="p_reqby_st" value="" ><input class="button" name="p_reqby_sr" id="p_reqby_sr" onClick="return searchCodeStore(p_reqby_st);" type="button" value="?"></td>
					<td class=label align=right><fmt:message key="Common.ReqOnStore.label" bundle="${common_labels}"/>
					</td>
					<td class=fields >&nbsp;&nbsp;<input maxLength=20 size=20 name="p_reqon_st" id="p_reqon_st" value="" ><input class="button" name="p_reqon_sr" id="p_reqon_sr" onClick="return searchCodeStore(p_reqon_st);" type="button" value="?"></td>
				</tr>


				<tr>
					<td class=label align=right><fmt:message key="eST.PeriodFromDate.label" bundle="${st_labels}"/></td>
					<td>&nbsp;&nbsp;<input type=text name=p_fr_doc_date size=10 maxlength=10 class="DATE" value=""  onBlur="CheckDate(this);"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_fr_doc_date');"></img></td>
					<td class="label" align=right><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
					<td>&nbsp;&nbsp;<input type=text name=p_to_doc_date size=10 maxlength=10 class="DATE" value=""  onBlur="CheckDate(this);"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_to_doc_date');"></img></td>
				</tr>    
				<tr>
				
					<td>&nbsp;&nbsp;</td>
					<td>&nbsp;&nbsp;</td>
				 <td align='right' colspan=4><input type="button" class="button" name="search" id="search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="callResultPage();"></td>  
		        </tr> 
				</table>
				</td>  
				</tr>
			</table>

			
			<input type="hidden" name="bean_id" id="bean_id"					value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name"				value="<%=bean_name%>">
			<input type="hidden" name="p_module_id" id="p_module_id"				value="ST">
			<input type="hidden" name="p_user_name" id="p_user_name"				value="<%=user_name%>">
			<input type="hidden" name="p_facility_id" id="p_facility_id"			value="<%=facility_id%>">
			<input type="hidden" name="p_report_id" id="p_report_id">
			<input type="hidden" name="p_doc_no" id="p_doc_no">
			<input type="hidden" name="p_doc_type_code" id="p_doc_type_code">
			<input type="hidden" name="p_seq_no" id="p_seq_no">
			<input type="hidden" name="p_reprint_orig" id="p_reprint_orig">
			<input type="hidden" name="dest_locn_type" id="dest_locn_type"			value="S">
			<input type="hidden" name="dest_locn_code" id="dest_locn_code"			value="PARAMETER_WILL_BE_PASSED">
			<input type="hidden" name="p_language_id" id="p_language_id"			value="<%=locale%>">
			

		</form>
		<input type="hidden" name="SQL_ST_ITEM_LOOKUP" id="SQL_ST_ITEM_LOOKUP" 
	value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_LOOKUP")%>">
		<input type="hidden" name="SQL_ST_STORE_LOOKUP" id="SQL_ST_STORE_LOOKUP" 		value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_STORE_LOOKUP_FOR_REPORT")%>">
<%
	putObjectInBean(bean_id,bean,request);
%>

	</body>
</html>	


