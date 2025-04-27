<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*,java.lang.*, eST.*, eST.Common.* , eCommon.Common.*"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
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
<!--	<script language="javascript" src="../../eST/js/StMessages.js"></script> -->
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="javascript" src="../../eST/js/SRRSalesPatientIssueReturnSummaryCriteria.js"></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%

	
		String bean_id					=		"MonthlySummaryReportBean";
		String bean_name				=		"eST.MonthlySummaryReportBean";

		String bean_id1				=		"ReportsStockStatusBean";
		String bean_name1			=		"eST.ReportsStockStatusBean";

		String bean_id2					=		"TrnSummaryListBean";
		String bean_name2				=		"eST.TrnSummaryListBean";


		TrnSummaryListBean bean2			=		(TrnSummaryListBean)getBeanObject( bean_id2,  bean_name2,request);  
		bean2.clear();
		bean2.setLanguageId(locale);


		ReportsStockStatusBean bean1 =		(ReportsStockStatusBean) getBeanObject( bean_id1,  bean_name1,request  );  
		String p_store_group	=	bean1.getListOptionTag(bean2.getListOptionArrayList("SELECT STORE_GROUP_CODE , SHORT_DESC FROM MM_STORE_GROUP_lang_vw WHERE EFF_STATUS = 'E' and language_id=? order by SHORT_DESC",locale));
		//String p_report_id			=		 null;
		String facility_id				=		(String) session.getValue( "facility_id" ) ;
		//String user_name				=		(String) session.getValue( "login_user" ) ;
		
		
		MonthlySummaryReportBean bean = (MonthlySummaryReportBean) getBeanObject( bean_id,  bean_name, request );  
		bean.clear();
		bean.setLanguageId(locale);
	//	String []stParameters=	{bean.getLoginFacilityId(), "ALL"};
		HashMap hmRecord	=	null;
		hmRecord	=		bean.fetchRecord("SELECT To_Char(SYSDATE,'MM') curr_month , To_Char(SYSDATE,'YYYY') curr_year  FROM DUAL");
		String curr_proc_month=(String)hmRecord.get("CURR_MONTH");
		String curr_proc_year =(String)hmRecord.get("CURR_YEAR"); 
		curr_proc_year = com.ehis.util.DateUtils.convertDate(curr_proc_year,"YY","en",locale);
		ArrayList alParam = new ArrayList();
		alParam.add(locale);
		//String billing_group	=	bean.getListOptionTag(bean.getListOptionArrayList("SELECT a.BLNG_GRP_ID code,a.SHORT_DESC description FROM  BL_BLNG_GRP_LANG  a,BL_BLNG_GRP b  WHERE a.BLNG_GRP_ID=b.BLNG_GRP_ID AND a.language_id LIKE ?  AND UPPER(a.BLNG_GRP_ID) LIKE UPPER('%')  AND UPPER(a.short_desc) LIKE UPPER('%')",alParam));

	%>
	<body onLoad="FocusFirstElement();">
		<form name="SRRSalesPatientIssueReturn" id="SRRSalesPatientIssueReturn" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame" >
		<br><br>
		<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' >
			<tr>
			<td width='100%' align='center' class="WHITE">
				<table cellpadding="0" cellspacing="0" width="98%" align="center" border="0">
				<th colspan=8 align=left><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
				</tr>
				<tr>
					<td align="right" class="label" colspan = 8>&nbsp;</td>
					</tr>

				<tr>
				<td class='label' ><fmt:message key="eST.SalesType.label" bundle="${st_labels}"/></td>
				<td class='fields' >&nbsp;
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
	
	</tr>
	<tr>
					<td align="right" class="label" colspan = 8>&nbsp;</td>
					</tr>
	<tr>	
					<td class="label"><fmt:message key="Common.Calendar.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Month/Year.label" bundle="${common_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=2 size=2 name="p_fm_month" id="p_fm_month" value="<%=curr_proc_month%>" onKeyPress="return isValidInteger();" onblur="checkIntegerFormat(this);" class="NUMBER"> 
					<class=text> / 	<class=text> <input maxLength=4 size=4 name="p_fm_year1" id="p_fm_year1" value="<%=curr_proc_year%>" onKeyPress="return isValidInteger();"  class="NUMBER"> <%=bean.getImage("M")%>  </td> 
					<td class="fields" >&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/> </td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=2 size=2 name="p_to_month" id="p_to_month" value="<%=curr_proc_month%>" onKeyPress="return isValidInteger();" onblur="checkIntegerFormat(this);" class="NUMBER"> 
					<class=text> / 	<class=text> <input maxLength=4 size=4 name="p_to_year1" id="p_to_year1" value="<%=curr_proc_year%>" onKeyPress="return isValidInteger();"  class="NUMBER"> <%=bean.getImage("M")%>  </td> 
				</tr>
				<tr>
					<td align="right" class="label" colspan = 8>&nbsp;</td>
					</tr>

				<tr>
					<td  class="label" ><fmt:message key="eST.DrugMedicalSupply.label" bundle="${st_labels}"/></td>
					<td class=fields >&nbsp;&nbsp;<select name="p_dru_med_sel" id="p_dru_med_sel" >
						<option value=''><fmt:message key="Common.all.label" bundle="${mm_labels}"/></option>
						<option  value='Y'><fmt:message key="Common.Drug.label" bundle="${mm_labels}"/></option>
						<option  value='N'><fmt:message key="eST.MedicalSupply.label" bundle="${st_labels}"/></option>
					</select></td>

					<td  class="label" ><fmt:message key="eST.StoreGroup.label" bundle="${st_labels}"/></td>
					<td class=fields >&nbsp;&nbsp;<SELECT name="p_tran_type" id="p_tran_type" ><%=p_store_group%>
					</select></td>
				</tr>
				<tr>
					<td align="right" class="label" colspan = 8>&nbsp;</td>
					</tr>

				<tr>
					<td  class="label"><fmt:message key="Common.Store.label" bundle="${mm_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=6 size=6 name="p_fr_str_code" id="p_fr_str_code"  value="" ><input class="button" name="p_fm_stc" id="p_fm_stc" onClick="return searchCodeStore(p_fr_str_code);"  type="button" value="?"></td>
					<td class="fields" >&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/> </td>
					<td class=fields colspan=5>&nbsp;&nbsp;<input maxLength=6 size=6 name="p_to_str_code" id="p_to_str_code" value="" ><input class="button" name="p_to_stc" id="p_to_stc" onClick="return searchCodeStore(p_to_str_code);"  type="button" value="?" ></td>
				</tr>

				<tr>
					<td align="right" class="label" colspan = 8>&nbsp;</td>
					</tr>

				<tr>
				<td class=label align=right><fmt:message key="Common.BillingGroup.label" bundle="${mm_labels}"/></td>
				
				<td class=fields>&nbsp;&nbsp;<input name="P_Privilege" id="P_Privilege"  value="" ><input class="button" name="p_fm_billing" id="p_fm_billing" onClick="return blng_grp_lkup(P_Privilege);"  type="button" value="?"></td>
				<td class="fields" >&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/> </td>
				<td class=fields colspan=5>&nbsp;&nbsp;<input name="P_Privilege_to" id="P_Privilege_to" value="" ><input class="button" name="p_to_billing" id="p_to_billing" onClick="return blng_grp_lkup(P_Privilege_to);"  type="button" value="?" ></td>
			<!-- 	<input type="hidden" name="P_Privilege" id="P_Privilege" value="">
				<input type="hidden" name="P_Privilege_to" id="P_Privilege_to" value=""> -->
					
			</tr>
			<tr>
					<td align="right" class="label" colspan = 8>&nbsp;</td>
					</tr>
	</table>
	
			<input type="hidden" name="p_language_id" id="p_language_id"		value="<%=locale%>">
			<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%=facility_id%>">
			<input type="hidden" name="p_module_id" id="p_module_id" 		value="ST">
			<input type="hidden" name="p_user_name" id="p_user_name"		value="<%=(String)session.getValue( "login_user" )%>">
			<input type="hidden" name="p_report_id" id="p_report_id"		value="STSALRETS_SRR"> 
			<input type="hidden" name="p_report_type" id="p_report_type"		value="STSALRETS_SRR"> 
			<input type="hidden" name="curr_proc_month" id="curr_proc_month"					value="<%=curr_proc_month%>">
			<input type="hidden" name="curr_proc_year" id="curr_proc_year"					value="<%=curr_proc_year %>">
			<input type="hidden" name="p_fm_year" id="p_fm_year"					value="">
			<input type="hidden" name="p_to_year" id="p_to_year"					value="">
</form>
       
	 <input type="hidden" name="SQL_ST_STORE_LOOKUP" id="SQL_ST_STORE_LOOKUP" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_STORE_LOOKUP_FOR_REPORT")%>">
	
	<%
putObjectInBean(bean_id,bean,request);
%>	
		
	</body>
</html>	

