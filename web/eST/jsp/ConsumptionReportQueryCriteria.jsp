<!DOCTYPE html>
 <%
/*
--------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------------------------
15/07/2021	TFS:21516		Shazana										MOHE-CRF-0084.1-US014
--------------------------------------------------------------------------------------------------------------------
*/
%>
 
 <%-- JSP Page specific attributes start --%>
<%@page import="java.util.*,java.lang.*, eST.*, eST.Common.* , eCommon.Common.*,java.sql.*,webbeans.eCommon.*"
contentType="text/html;charset=UTF-8" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
<!-- 		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link>
 -->	<%

request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
		
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
<!-- 		<script language="javascript" src="../../eCommon/js/messages.js"></script> -->
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
<!-- 		<script language="javascript" src="../../eST/js/StMessages.js"></script> -->
  		<script language="javascript" src="../../eST/js/StTransaction.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="javascript" src="../../eST/js/ConsumptionReport.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
  

	</head>
	<%		
		String bean_id = "ConsumptionReportBean";
		String bean_name = "eST.ConsumptionReportBean";
		String facility_id  =  (String) session.getValue( "facility_id" ) ;
		String user_name  =  (String) session.getValue( "login_user" ) ;
		
		ConsumptionReportBean bean = (ConsumptionReportBean) getBeanObject( bean_id,bean_name,request);  
		bean.clear();
		bean.setLanguageId(locale);
		String []stParameters=	{bean.getLoginFacilityId(), "ALL"};
		HashMap hmRecord	=	null;
		hmRecord	=	bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_FACILITY_PARAM_SELECT_SINGLE"), stParameters);
		String curr_proc_day=(String)hmRecord.get("CURR_PROC_DAY");
		String curr_proc_month=(String)hmRecord.get("CURR_PROC_MONTH");
		String curr_proc_year =(String)hmRecord.get("CURR_PROC_YEAR"); 
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
	
	%>
	<body onLoad="FocusFirstElement(),getItem();">
	<form name="formConsumptionReportQueryCriteria" id="formConsumptionReportQueryCriteria" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame" >		
	<br><br>
		<table border="0" cellpadding="0" cellspacing="0" width='90%' align='center'  >
			<tr>
			    <td width='100%' align='center' class="WHITE" >
		<table cellpadding="0" cellspacing="0" width="85%" align="center" border="0">
			<th colspan=9 align=left><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th></td>				
			</tr>
			<tr>
				<td  class="label" width="20%"><fmt:message key="Common.report.label" bundle="${common_labels}"/> </td>
				<td class=fields  colspan='8'>&nbsp;&nbsp;<select name="p_report" id="p_report" onChange="setReportType(),setATCType(),setItemStore(),setHideTop(),hideOrderBy(),showReportId();"> 
<option  value='C'>  <fmt:message key="eST.Consumption.label" bundle="${st_labels}"/></option>
<option  value='CD'><fmt:message key="eST.ConsumptionDeviation.label" bundle="${st_labels}"/></option>
<option  value='ATC'><fmt:message key="eST.ConsumptionByATCClassification.label" bundle="${st_labels}"/></option>
				</select></td>
	       </tr>
		   <tr>
				<td align="right" colspan=8>&nbsp;</td>
			</tr>
			<tr>
				<td class="label" width="20%"><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/></td>
				<td class=fields  colspan='8'>&nbsp;&nbsp;<select name="p_report_idS" id="p_report_idS" onChange="getVal(),setReportSubType(),setOrderByType();"> <option  value='STBCONS1'><fmt:message key="eST.ItemConsolidated.label" bundle="${st_labels}"/></option>
<option  value='STBCONS2'><fmt:message key="eST.ByStore.label" bundle="${st_labels}"/></option>
<option  value='STBCONS3'><fmt:message key="eST.StoreItemClass.label" bundle="${st_labels}"/></option>
<option  value='STBCONS4'><fmt:message key="eST.ByItemClass.label" bundle="${st_labels}"/></option>
<option  value='STBCONS5'><fmt:message key="eST.ByItem.label" bundle="${st_labels}"/></option></select>
 					<select name="p_item_store" id="p_item_store" id="p_item_store_style" style="visibility:hidden">
<option  value='S'><fmt:message key="eST.StoreLevel.label" bundle="${st_labels}"/></option>
<option  value='I'><fmt:message key="Common.ItemLevel.label" bundle="${common_labels}"/></option>
					</select><input type="hidden" name="p_report_id" id="p_report_id"></td>
			</tr>
		
			<tr>
				<td align="right">&nbsp;</td>
				<td class="fields" class="label" width="30%">&nbsp;&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
				<td align="right" >&nbsp;</td>
				<td align="right" >&nbsp;</td>
				<td class="fields" >&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				<td align="right" >&nbsp;</td>
			</tr>
			<tr>  
				<td  class="label" nowrap><font style="visibility:visible" id="consumption_period"><fmt:message key="eST.ConsumptionPeriod.label" bundle="${st_labels}"/></font></td>
				<td class=fields>&nbsp;&nbsp;<input maxLength=2 size=2 name="p_fr_month" id="p_fr_month" value="" onKeyPress="return isValidInteger();"  style="visibility:visible" id="p_fr_month_style"
				onBlur="return CheckMonth1(p_fr_month);" class="NUMBER"> 
				<class=text><b style="visibility:visible" id="divide1_style"> / <b>	<class=text> <input maxLength=4 size=4 name="p_fr_year" id="p_fr_year" value="" style="visibility:visible" id="p_fr_year_style" onKeyPress="return isValidInteger();"  
				onBlur="return ChkYear(p_fr_year);" class="NUMBER">  <b style="visibility:visible" id="image_style"><%=bean.getImage("M")%> </b></td> 
				<td class="label">&nbsp;</td>
				<td class="label">&nbsp;</td>
				<td class=fields>&nbsp;&nbsp;<input maxLength=2 size=2 name="p_to_month" id="p_to_month" value="<%=curr_proc_month%>" style="visibility:visible" id="p_to_month_style" onKeyPress="return isValidInteger();"    onBlur="return CheckMonth2(p_to_month);" class="NUMBER"> 
				<class=text> <b style="visibility:visible" id="divide2_style"> / 	</b><class=text> <input maxLength=4 size=4 name="p_to_year" id="p_to_year" value="<%=curr_proc_year%>" style="visibility:visible" id="p_to_year_style" onKeyPress="return isValidInteger();"  class="NUMBER">   </td> 
				<td class="label">&nbsp;</td>
			</tr>

			<tr>
				<td  class="label" width="30%"><fmt:message key="Common.StoreCode.label" bundle="${common_labels}"/></td>
				<%if(restrict_stores_user_access_yn){ %><!-- mohe-crf-0084.1 start -->
				<td class=fields>&nbsp;&nbsp;<input maxLength=6 size=6 name="p_fm_store_code" id="p_fm_store_code" value="" ><input class="button"  onClick="return searchCodeStore1(p_fm_store_code);" type="button" name="p_fr_sr" id="p_fr_sr" value="?"></td>
				<%}else{ %>
				<td class=fields>&nbsp;&nbsp;<input maxLength=6 size=6 name="p_fm_store_code" id="p_fm_store_code" value="" ><input class="button"  onClick="return searchCodeStore(p_fm_store_code);" type="button" name="p_fr_sr" id="p_fr_sr" value="?"></td>
				<%} %>
				
				<td class="label">&nbsp;</td>
				<td class="label">&nbsp;</td>
				<%if(restrict_stores_user_access_yn){ %>
				<td class=fields colspan=4>&nbsp;&nbsp;<input maxLength=6 size=6  name="p_to_store_code" id="p_to_store_code" value="" ><input class="button" onClick="return searchCodeStore1(p_to_store_code);" type="button"  name="p_to_sr" id="p_to_sr" value="?"></td>
				<%}else{ %>
				<td class=fields colspan=4>&nbsp;&nbsp;<input maxLength=6 size=6  name="p_to_store_code" id="p_to_store_code" value="" ><input class="button" onClick="return searchCodeStore(p_to_store_code);" type="button"  name="p_to_sr" id="p_to_sr" value="?"></td>
				<%} %><!-- mohe-crf-0084.1 end -->

			</tr>
			<tr>
				<td  class="label" width="30%"><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></td>
				
				<td class=fields >&nbsp;&nbsp;<input maxLength=20 size=20 name="p_fm_item_code" id="p_fm_item_code" value="" ><input class="button" name="p_fm_sr2" id="p_fm_sr2" onClick="return searchCodeItem(p_fm_item_code);" type="button" value="?"></td>
			    
				<td class=fields colspan=4 align ="right">&nbsp;&nbsp;<input maxLength=20 size=10 name="p_to_item_code" id="p_to_item_code" value="" ><input class="button" name="p_to_sr2" id="p_to_sr2" onClick="return searchCodeItem(p_to_item_code);" type="button" value="?">&nbsp;&nbsp;&nbsp;</td>
			</tr>
			<tr>
				<td  class="label" width="30%"><fmt:message key="Common.ItemClass.label" bundle="${common_labels}"/></td>
				<td class=fields>&nbsp;&nbsp;<input maxLength=4 size=4 name="p_fm_item_class" id="p_fm_item_class" value="" ><input class="button" onClick="return searchCodeItemClass(p_fm_item_class);" type="button" value="?"></td>
				<td class="label">&nbsp;</td>
				<td class="label">&nbsp;</td>
				<td class=fields colspan=4>&nbsp;&nbsp;<input maxLength=4 size=4 name="p_to_item_class" id="p_to_item_class" value="" ><input class="button" onClick="return searchCodeItemClass(p_to_item_class);" type="button" value="?"></td>
			</tr>
			<tr>
				<td class='label' align='left' width="30%"><fmt:message key="Common.AlphaCode.label" bundle="${common_labels}"/></td>
				<td class=fields>&nbsp;&nbsp;<input type=text name=p_fr_alp_code size=10 maxlength=10 value="" onKeyPress="return CheckForSpecialChars(event);"></td>
				<td class=label>&nbsp;</td>
				<td class=label>&nbsp;</td>
				<td class=fields colspan=4>&nbsp;&nbsp;<input type=text name=p_to_alp_code size=10 maxlength=10 value="" onKeyPress="return CheckForSpecialChars(event);"></td>
			</tr>
				<%-- Item Analysis added Thursday, August 19, 2004--%>
			 <tr>
				<td class="label" width="30%"><fmt:message key="Common.ItemAnalysis.label" bundle="${common_labels}"/> 1</td>
				<td class=fields >&nbsp;&nbsp;<select name="p_item_anal_1" id="p_item_anal_1"  > <%=bean.getItem_analList()%>
				</select> </td>
				<td class=label>&nbsp;</td>
				<td class=label ><fmt:message key="Common.ItemAnalysis.label" bundle="${common_labels}"/> 2</td>
				<td class=fields >&nbsp;&nbsp;<select name="p_item_anal_2" id="p_item_anal_2"   > <%=bean.getItem_analList()%>
				</select>
				</td>
				<td class=label>&nbsp;</td>
			</tr>  
			<tr>
				<td class=label ><fmt:message key="Common.ItemAnalysis.label" bundle="${common_labels}"/> 3</td>
				<td class=fields>&nbsp;&nbsp;<select name="p_item_anal_3" id="p_item_anal_3"> <%=bean.getItem_analList()%>
				</select></td>
				<td class=label>&nbsp;</td>
				<td class='label' align='left' width="30%"><font style="visibility:visible" id="report_option_style"><fmt:message key="Common.ReportOption.label" bundle="${common_labels}"/></font></td>
<%if(((String)bean.getAccessCostDetails()).equals("Y")){%>
				<td class=fields >&nbsp;&nbsp;<select name="P_1" id="P_1" style="visibility:visible" id="p_1_style">
				<option value="0"><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
				<option value="1"><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></option>
				<option value="2"><fmt:message key="Common.Value.label" bundle="${common_labels}"/></option>
				</select>
				</td>
<%}else{%>
				<td class=fields >&nbsp;&nbsp;<select name="P_1" id="P_1" style="visibility:visible" id="p_1_style">
				<option value="1"><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></option>
				</select>
				</td>
<%}%>
				<td class=label>&nbsp;</td></tr>
	
			<tr>
			   <td  class="label" width="30%"><font style="visibility:hidden" id = 'patcclass' name='patcclass'><fmt:message key="Common.ATCClassification.label" bundle="${common_labels}"/></font></td>
			   <td class=fields>&nbsp;&nbsp;<input maxLength=6 size=6 name="p_fm_atc_class_lev" id="p_fm_atc_class_lev"  style="visibility:hidden" value="" ><input class="button" onClick="return searchCodeATCClassification(p_fm_atc_class_lev,'<%=eST.Common.StRepository.getStKeyValue("ST_SQL_ATC_CLASS_LEV1")%>','<%=eST.Common.StRepository.getStKeyValue("ST_SQL_ATC_CLASS_LEV2")%>','<%=eST.Common.StRepository.getStKeyValue("ST_SQL_ATC_CLASS_LEV3")%>','<%=eST.Common.StRepository.getStKeyValue("ST_SQL_ATC_CLASS_LEV4")%>','<%=eST.Common.StRepository.getStKeyValue("ST_SQL_ATC_CLASS_LEV5")%>' )" type="button" name="p_fr_sr" id="p_fr_sr_style" style="visibility:hidden" value="?"></td>
				<td class="label">&nbsp;</td>
				<td class="label">&nbsp;</td>
				<td class=fields colspan=4>&nbsp;&nbsp;<input maxLength=6 size=6  name="p_to_atc_class_lev" id="p_to_atc_class_lev"  style="visibility:hidden" value="" ><input class="button" onClick="return searchCodeATCClassification(p_to_atc_class_lev,'<%=eST.Common.StRepository.getStKeyValue("ST_SQL_ATC_CLASS_LEV1")%>','<%=eST.Common.StRepository.getStKeyValue("ST_SQL_ATC_CLASS_LEV2")%>','<%=eST.Common.StRepository.getStKeyValue("ST_SQL_ATC_CLASS_LEV3")%>','<%=eST.Common.StRepository.getStKeyValue("ST_SQL_ATC_CLASS_LEV4")%>','<%=eST.Common.StRepository.getStKeyValue("ST_SQL_ATC_CLASS_LEV5")%>' )" type="button"  name="p_to_sr" id="p_to_sr_style" style="visibility:hidden" value="?"></td>

			</tr>
			<tr>
				<td  class="label" width="30%"><fmt:message key="eST.SuppressZero.label" bundle="${st_labels}"/></td>
				<td class=fields width="30%">&nbsp;<input type='checkbox' name='p2' id='p2' checked value='Y'></td>
				<td class=label align="right" nowrap>&nbsp;&nbsp;<font style="visibility:visible" id = 'p_top_style' align="right" 
				><fmt:message key="Common.Top.label" bundle="${common_labels}"/></font></td>
				<td class=fields colspan=3>&nbsp;&nbsp;<input type="text" class="NUMBER" maxLength="3" size="1" name="p_count" id="p_count" onKeyPress="return isValidInteger();"  onBlur="checkIntegerFormat(this),changeReport();" id="p_count_style" style="visibility:visible">	<font style="visibility:visible" id = 'p_item_style'><fmt:message key="Common.item.label" bundle="${common_labels}"/>(<fmt:message key="eST.S.label" bundle="${st_labels}"/>)<fmt:message key="Common.by.label" bundle="${common_labels}"/></font> &nbsp;
<%if(((String)bean.getAccessCostDetails()).equals("Y")){%>
				<select name="p_order_by" id="p_order_by" id="p_order_by_style" style="visibility:visible">
				<option value="4"><fmt:message key="Common.Value.label" bundle="${common_labels}"/></option>
				<option value="3"><fmt:message key="Common.Qty.label" bundle="${common_labels}"/></option>
				</select>
<%}else{%>
				<select name="p_order_by" id="p_order_by" id="p_order_by_style" style="visibility:visible">
				<option value="3"><fmt:message key="Common.Qty.label" bundle="${common_labels}"/></option>
				</select>
<%}%>
				</td>	
				 
			</tr>

			<tr>
				<td class=label nowrap>&nbsp;<fmt:message key="eST.ExcludeExternalStores.label" bundle="${st_labels}"/> </td>	
				<td class=fields colspan=4>&nbsp;<input type='checkbox' name='p_excludeexternalstores' id='p_excludeexternalstores' value='N'></td>
				<td class=label>&nbsp;</td>
			</tr>
		</table>
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
			<input type="hidden" name="p_module_id" id="p_module_id" 		value="ST">
			<input type="hidden" name="p_user_name" id="p_user_name"			value="<%=user_name%>">
			<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%=facility_id%>">
			<input type="hidden" name="p_report_type" id="p_report_type"		value="STBATCIC"> 
			<input type="hidden" name="curr_proc_day" id="curr_proc_day"		value="<%=curr_proc_day%>">
             <input type="hidden" name="curr_proc_month" id="curr_proc_month"		value="<%=curr_proc_month%>">
	     	<input type="hidden" name="curr_proc_year" id="curr_proc_year"		value="<%=curr_proc_year %>">
			<input type='hidden' name="sysdate" id="sysdate" value="<%=bean.getSystemDate().toString()%>">
			<input type="hidden" name="p_language_id" id="p_language_id"		value="<%=locale%>">
			<input type="hidden" name="p_strFacilityParam" id="p_strFacilityParam"		value="<%=strFacilityParam%>"><!-- MOHE-CRF-0084.1 -->
</form>
		 	<input type="hidden" name="SQL_ST_STORE_LOOKUP" id="SQL_ST_STORE_LOOKUP" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_STORE_LOOKUP_FOR_REPORT")%>">
            <input type="hidden" name="SQL_ST_ITEM_LOOKUP" id="SQL_ST_ITEM_LOOKUP" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_LOOKUP")%>">
			 <input type="hidden" name="SQL_ST_ITEM_CLASS_LOOKUP_LANG" id="SQL_ST_ITEM_CLASS_LOOKUP_LANG" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_CLASS_LOOKUP_FOR_REPORT")%>">
			 <input type="hidden" name="SQL_ST_ALPHA_LOOKUP" id="SQL_ST_ALPHA_LOOKUP" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ALPHA_LOOKUP")%>">
			 <input type="hidden" name="SQL_ST_ITEM_ANAL_CODE_SELECT_SINGLE" id="SQL_ST_ITEM_ANAL_CODE_SELECT_SINGLE" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_ANAL_CODE_SELECT_SINGLE")%>">
		<%
putObjectInBean(bean_id,bean,request);
%>	
		
	</body>
</html>	

