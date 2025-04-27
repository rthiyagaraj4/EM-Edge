<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*,java.text.*, eST.*, eST.Common.*,ePH.*,ePH.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%-- Mandatory declarations end --%>
<html>
<head>
		<%
	request.setCharacterEncoding("UTF-8");
	String locale	= (String)session.getAttribute("LOCALE");
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String currentdate	= com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
	String facility_id  = (String)session.getValue( "facility_id" );
	String login_user	= (String)session.getValue("login_user");
	String bean_id				=		"TrnSummaryListBean";
	String bean_name			=		"eST.TrnSummaryListBean";
	String bean_id1				=		"ReportsStockStatusBean";
	String bean_name1			=		"eST.ReportsStockStatusBean";


		TrnSummaryListBean bean		=		(TrnSummaryListBean) getBeanObject( bean_id,bean_name,request);  
		bean.clear();
		bean.setLanguageId(locale);
		ReportsStockStatusBean bean1 =		(ReportsStockStatusBean) getBeanObject( bean_id1,  bean_name1,request  );  
		 ArrayList params = new ArrayList();
		
		params.add(facility_id);
		params.add(login_user);
		params.add(locale);

		String sql=	bean1.getListOptionTag(bean.getListOptionArrayList("SELECT   st.store_code , mm.short_desc FROM mm_store_lang_vw mm, ST_USER_ACCESS_FOR_STORE st, ST_STORE ststr, ST_ACC_ENTITY_PARAM stpa WHERE mm.store_code = st.store_code AND mm.store_code = ststr.store_code  AND mm.eff_status = 'E' AND st.srt_allowed_yn = 'Y' AND ststr.srt_allowed_yn = 'Y' AND mm.facility_id =? AND st.user_id =?  AND mm.language_id =?ORDER BY 2",params));
	
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
    <script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="JavaScript" src="../../eST/js/SRRSalesReturnVoucherReport.js"></script>
	<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script> 
	<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'> </script> 
			<script language="javascript" src="../../eST/js/StCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">
<form name="SRRSalesRtnVoucherForm" id="SRRSalesRtnVoucherForm" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame" >


<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0" id="prescriptionquerycriteriatable" >

	<tr>
		 <td class="label" nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
		<td class="field" width="20%">&nbsp;
		<input align="center" type='text'  name='p_patient_id' id='p_patient_id' size=20 value=""  onKeyPress="return CheckForSpecChars(event)" onBlur="return CheckForSpecChars(event)" maxlength="20" ><input valign='top' type='button' name='patient_search' id='patient_search' value='?' class='button'
		onfocus="callPatientLookup();" onClick="callPatientLookup();"></td>
	<!-- Added if conditions  onblur of dates ==by sandhya-->		
		<td class="label" nowrap><fmt:message key="eST.ReturnDate.label" bundle="${st_labels}"/></td>
		<td >&nbsp;&nbsp;<input type="text" name="p_fr_rtn_date" id="p_fr_rtn_date" value=""  maxlength="10" size="10" onBlur="if(CheckDate(this))if(DateCheck(currentdate,p_fr_rtn_date))validate_date(this,'TO_DATE_LESS_FROM')">
		<IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('p_fr_rtn_date');"  onblur='p_fr_rtn_date.focus()'>&nbsp;<img name='mandatory' src="../../eCommon/images/mandatory.gif"></td>
		<td>&nbsp;
		<label class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/></label></td>
		<td>&nbsp;&nbsp;<input type="text" name="p_to_rtn_date" id="p_to_rtn_date" value=""  maxlength="10" size="10" onBlur="if(CheckDate(this))if(DateCheck(currentdate,p_to_rtn_date))validate_date(this,'TO_DATE_LESS_FROM')">
		<IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('p_to_rtn_date');" onblur='p_to_rtn_date.focus()' >&nbsp;<img name='mandatory' src="../../eCommon/images/mandatory.gif"></td>   
		<INPUT TYPE="hidden" name="p_disp_date" id="p_disp_date" VALUE="">		
	</tr>
	
		<tr>
		
		<td class="label" nowrap><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
		<td>&nbsp;
			<input type="text" name="p_encounter" id="p_encounter" maxlength="20" size="20"  onKeyPress="return isValidInteger();" onBlur="return checkIntegerFormat(this);" >
		</td>

	
					<td  class="label" ><fmt:message key="eST.ReturnStore.label" bundle="${st_labels}"/></td>
					<td class=fields >&nbsp;&nbsp;<SELECT name="p_rtnstore" id="p_rtnstore" ><%=sql%>
					</select>&nbsp;<img name='mandatory' src="../../eCommon/images/mandatory.gif"></td>
				
		
  	
	</tr>
	
	<tr>
	<td class='label' ><fmt:message key="eST.SalesType.label" bundle="${st_labels}"/></td>
	<td class='fields'>&nbsp;
		<select name="p_sal_trn_type" id="p_sal_trn_type">
					<option value="">&nbsp;--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
					<option value="I" ><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/></option>
					<option value="D" ><fmt:message key="Common.daycare.label" bundle="${common_labels}"/></option>
					<option value="O"><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/></option>
					<option value="E"><fmt:message key="Common.emergency.label" bundle="${common_labels}"/></option>
					<option value="R"><fmt:message key="Common.referral.label" bundle="${common_labels}"/></option>
					<option value="X"><fmt:message key="eST.DirectSales.label" bundle="${st_labels}"/></option>
		</select>
	</td>
	<td class="label" nowrap><fmt:message key="Common.documentno.label" bundle="${common_labels}"/></td>
		<td>&nbsp;
			<input type="text" name="p_document" id="p_document" maxlength="20" size="20"  onKeyPress="return CheckForSpecChars(event);">
		</td>
		<td colspan="2"> 
			<input type="button" name="btnSearch" id="btnSearch" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' class="button" onClick="showResults()" >
		</td>
		
		</td>	
		</tr>
	
</table>
<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="">
<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>">
<INPUT TYPE="hidden" name="currentdate" id="currentdate" VALUE="<%=currentdate%>">
<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="ST">
<INPUT TYPE="hidden" name="P_REPRINT" id="P_REPRINT" VALUE="Y">
<INPUT TYPE="hidden" name="p_doc_no" id="p_doc_no" VALUE="">
<INPUT TYPE="hidden" name="p_doc_rtn_date" id="p_doc_rtn_date" VALUE="">
<INPUT TYPE="hidden" name="p_rtn_store_code" id="p_rtn_store_code" VALUE="">



</form>

</body>
</html>

