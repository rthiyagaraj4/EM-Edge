<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%
/*
--------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------------------------
15/07/2021	TFS:21516		Shazana										MOHE-CRF-0084.1-US014
--------------------------------------------------------------------------------------------------------------------
*/  
%>

<%@ page  contentType="text/html;charset=UTF-8" import=" eST.*, eST.Common.* , eCommon.Common.*, java.text.*, java.util.*,java.sql.*,webbeans.eCommon.*,java.lang.*"%> 
<%@ page  contentType="text/html;charset=UTF-8"%> <!-- Added by Sakti against TTM-SCF-0043 [IN:044469]-->  
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			=		(String)session.getAttribute("LOCALE");
		String sStyle			=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
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
		<script language="javascript" src="../../eST/js/TransactionsAuditTrail.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		
		String bean_id				=		"MonthlySummaryReportBean";
		String bean_name			=		"eST.MonthlySummaryReportBean";
		//String p_report_id		=		null;
		String facility_id			=		(String) session.getValue( "facility_id" ) ;
		String user_name			=		(String) session.getValue( "login_user" ) ;
		
		
		MonthlySummaryReportBean bean =		(MonthlySummaryReportBean) getBeanObject(bean_id,bean_name,request);  
		bean.clear();
		bean.setLanguageId(locale);
		bean.setAcc_entity_id((String)session.getAttribute("ACC_ENTITY_ID"));
		boolean restrict_stores_user_access_yn =false;//Added for TFS id:21516 
	    String strFacilityParam = "";
		String restrictInReportYN = "";
		Connection con				= null; 
		 try{
				con						= ConnectionManager.getConnection(request);
			    restrict_stores_user_access_yn = eCommon.Common.CommonBean.isSiteSpecific(con, "ST","ST_RESTRICT_USER_ACCESS_STORES");
		    }
		 catch (Exception exp){
			 exp.printStackTrace();
		 }
		    finally{ 
		    	if(con != null)
		    		ConnectionManager.returnConnection(con,request); 
		    }
		 strFacilityParam = bean.getRestrictUserAccessStore();

			if(strFacilityParam== null || strFacilityParam.equals(""))
				strFacilityParam = "N"; 
			if(restrict_stores_user_access_yn){
				if(strFacilityParam.equals("Y")){
					restrictInReportYN = "Y";
				}else{
					restrictInReportYN = "N"; 
				}
			}//END  
		
		//String []stParameters		=		{bean.getLoginFacilityId(), "ALL"};
	//	HashMap hmRecord			=		null;
	//	hmRecord					=		bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_FACILITY_PARAM_SELECT_SINGLE"), stParameters);
		
	//	String curr_proc_month		=		(String)hmRecord.get("CURR_PROC_MONTH");
	//	String curr_proc_year		=		(String)hmRecord.get("CURR_PROC_YEAR"); 
       
	%>
	<body onLoad="FocusFirstElement();setReportOrder();setvals();">
<!-- 	SQL_ST_TRN_TYPE_SELECT_LIST -->
		<form name="TransactionsAuditTrailCriteria" id="TransactionsAuditTrailCriteria" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame" >
		<br><br>
		<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' >
			<tr>
			<td width='100%' align='center' class="WHITE">
				<table cellpadding="0" cellspacing="0" width="98%" align="center" border="0">
				<th colspan=8 align=left><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
							
				<tr>
					<td align="right">&nbsp;</td>
					<td class="fields">&nbsp;&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td align="right" >&nbsp;</td>
					<td class="fields" colspan=5 width="10%">&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				</tr>
				<tr>
					<td class="label"><fmt:message key="Common.StoreCode.label" bundle="${common_labels}"/> </td>
					<%if(restrict_stores_user_access_yn){  %><!-- MOHE-CRF-0084.1  -->
					<td class=fields>&nbsp;&nbsp;<input maxLength=6 size=6 name="p_fr_str_code" id="p_fr_str_code"  value="" ><input class="button" name="p_fm_stc" id="p_fm_stc" onClick="return searchCodeStore1(p_fr_str_code);"  type="button" value="?"></td>
					<%}else{ %>
					<td class=fields>&nbsp;&nbsp;<input maxLength=6 size=6 name="p_fr_str_code" id="p_fr_str_code"  value="" ><input class="button" name="p_fm_stc" id="p_fm_stc" onClick="return searchCodeStore(p_fr_str_code);"  type="button" value="?"></td>
					<%} %>
					
					<td class="label">&nbsp;</td>
					<%if(restrict_stores_user_access_yn){  %><!-- MOHE-CRF-0084.1  -->
					<td class=fields colspan=5>&nbsp;<input maxLength=6 size=6  name="p_to_str_code" id="p_to_str_code" value="" ><input class="button" name="p_to_stc" id="p_to_stc" onClick="return searchCodeStore1(p_to_str_code);"  type="button" value="?" ></td>
					<%}else{ %>
					<td class=fields colspan=5>&nbsp;<input maxLength=6 size=6  name="p_to_str_code" id="p_to_str_code" value="" ><input class="button" name="p_to_stc" id="p_to_stc" onClick="return searchCodeStore(p_to_str_code);"  type="button" value="?" ></td>
					<%} %>
					
				</tr>
				
				<tr>
					<td class="label"><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=20 size=20  name="p_fm_item_code" id="p_fm_item_code" value="" ><input class="button" name="p_fm_sr2" id="p_fm_sr2" onClick="return searchCodeItem(p_fm_item_code);" type="button" value="?"></td>
					<td class="label">&nbsp;</td>
					<td class=fields colspan=5>&nbsp;<input maxLength=20 size=13 name="p_to_item_code" id="p_to_item_code" value="" ><input class="button" name="p_to_sr2" id="p_to_sr2" onClick="return searchCodeItem(p_to_item_code);" type="button" value="?"  ></td>
				</tr>
				<tr>
					<td  class="label"><fmt:message key="Common.ItemClass.label" bundle="${common_labels}"/> </td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=4 size=4 name="p_fr_item_class" id="p_fr_item_class" value="" ><input class="button" onClick="return searchCodeItemClass(p_fr_item_class);" type="button" value="?"></td>
					<td class="label">&nbsp;</td>
					<td class=fields colspan=5>&nbsp;<input maxLength=4 size=4 name="p_to_item_class" id="p_to_item_class" value="" ><input class="button" onClick="return searchCodeItemClass(p_to_item_class);" type="button" value="?"></td>
				</tr>
				<tr>
					<td class=label align=left><fmt:message key="Common.AlphaCode.label" bundle="${common_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input type=text name=p_fr_alpa_code size=10 maxlength=10 value="" onKeyPress="return CheckForSpecialChars(event);"></td>
					<td class="label">&nbsp;</td><td class=fields colspan=5>&nbsp;<input type=text name=p_to_alpa_code size=10 maxlength=10 value="" onKeyPress="return CheckForSpecialChars(event);"></td>
				</tr>
				<tr>
					<td class=label align=left><fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input type=text name=dt_from_1 id=dt_from_1 size=10 maxlength=10 class="DATE" value="" onBlur="ChekDate(this,'<%=locale%>');"  ><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('dt_from_1');" ></img>&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td class="fields">&nbsp;</td><td class=fields colspan=5>&nbsp;<input type=text name=dt_to_1 id=dt_to_1 size=10 maxlength=10 class="DATE" value="" onBlur="ChekDate(this,'<%=locale%>');"  ><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('dt_to_1');" ></img>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				</tr>
				<tr>
					<td class=label align=left><fmt:message key="Common.DocRef.label"   bundle="${common_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input type=text name=p_fr_doc_ref size=10 maxlength=10 value="" ></td>
					<td class="fields">&nbsp;</td><td class=fields colspan=5>&nbsp;<input type=text name=p_to_doc_ref size=10 maxlength=10 value="" ></td>
				</tr>
				
				<tr>
					<td  class="label" ><fmt:message key="Common.transactiontype.label" bundle="${common_labels}"/></td>
					<td class=fields >&nbsp;&nbsp;<SELECT name="p_tran_type" id="p_tran_type" onChange = 'setReportOrder();'><%=bean.getTrn_type()%>
					</select></td>
					<!-- *
					 * @Name - Priya
					 * @Date - 06/07/2010
					 * @Inc# - 21344 (AK-CRF-0016)
					 * @Desc - New option 'ByOtherStore' store is added for the 'ReportOrder' select box 
					-->
					<td class="label"><fmt:message key="Common.ReportOrder.label" bundle="${common_labels}"/></td>
					<td class=fields colspan=5>&nbsp;<SELECT name="p_order_by" id="p_order_by" onChange="changeReport();">
					</select></td>
				</tr>
				<tr>
					<td class="label" ><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/></td>
					<td class=fields colspan=7>&nbsp;&nbsp;<SELECT name="p_report_type" id="p_report_type" >
					<OPTION VALUE="B"><fmt:message key="Common.Both.label" bundle="${common_labels}"/></OPTION>
					<OPTION VALUE="C"><fmt:message key="eST.Consumption.label" bundle="${st_labels}"/></OPTION>
					<OPTION VALUE="N"><fmt:message key="eST.NonConsumption.label" bundle="${st_labels}"/></OPTION>
					</select></td>
				</tr>
				<!-- *
					 * @Name - Sakti
					 * @Date - 24/07/2014
					 * @Inc# -  KDAH-SCF-0247 [IN:050324]
					 * @Desc - New checkbox 'Exclude Internal Adjustments'  is added 
					-->
				<tr>
				<td class="label">Exclude Internal Adjustments</td>
				<td class=fields >&nbsp;<input type="checkbox" onclick="setvals();" name="p_exclude_internal_adjustment_yn" id="p_exclude_internal_adjustment_yn" value=""/></td>
				</tr>
                
				</table>
				</td>  

				</tr>

				
			</table>

			
			<input type="hidden" name="bean_id" id="bean_id"								value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name"							value="<%=bean_name%>">
			<input type="hidden" name="p_module_id" id="p_module_id" 						value="ST">
			<input type="hidden" name="dt_from" id="dt_from" 							value="">
			<input type="hidden" name="dt_to" id="dt_to" 								value="">
			<input type="hidden" name="p_user_name" id="p_user_name"							value="<%=user_name%>">
			<input type="hidden" name="p_facility_id" id="p_facility_id"						value="<%=facility_id%>">
			<input type="hidden" name="p_report_id" id="p_report_id"							value="STBTXAU1">
			<input type="hidden" name="p_language_id" id="p_language_id"						value="<%=locale%>">
			<input type="hidden" name="p_exclude_internal_adj_yn" id="p_exclude_internal_adj_yn"			value="">
			<input type="hidden" name="p_strFacilityParam" id="p_strFacilityParam"			value="<%=strFacilityParam%>"><!-- MOHE-CRF-0084.1 -->
			
</form>
			<input type="hidden" name="SQL_ST_STORE_LOOKUP" id="SQL_ST_STORE_LOOKUP"					value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_STORE_LOOKUP_FOR_REPORT")%>">
            <input type="hidden" name="SQL_ST_ITEM_LOOKUP" id="SQL_ST_ITEM_LOOKUP"					value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_LOOKUP")%>">
			 <input type="hidden" name="SQL_ST_ITEM_CLASS_LOOKUP_LANG" id="SQL_ST_ITEM_CLASS_LOOKUP_LANG"		value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_CLASS_LOOKUP_FOR_REPORT")%>">

		<%
putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>	

