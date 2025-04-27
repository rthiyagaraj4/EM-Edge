<!DOCTYPE html>
 <!--
/*
-------------------------------------------------------------------------------------------------------------------------------------------------------------
Date		 	Edit history        	Name			       Rev.Date		     Rev.Nam			     Description
-------------------------------------------------------------------------------------------------------------------------------------------------------------

10/10/2017		ML-MMOH-CRF-0917		Shazana Hasan												ML-MMOH-CRF-0917 (Added 'From Store' and 'To Store')
------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
  -->
 <%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*,java.lang.*,java.sql.*,eST.*, eST.Common.* , eCommon.Common.*, webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
<!-- 		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link>
 -->		
<%

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
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="javascript" src="../../eST/js/AgeingAnalysisReport.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		
		String bean_id = "ReportsStockStatusBean";
		String bean_name = "eST.ReportsStockStatusBean";
	//	String p_report_id = null;
		
		
		ReportsStockStatusBean bean = (ReportsStockStatusBean)getBeanObject( bean_id,bean_name,request);  
		String facility_id  =  bean.getLoginFacilityId();
		String user_name  =  bean.getLoginById();
		//bean.clear();
		bean.setLanguageId(locale);
		HashMap hmRecord	=	bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_ACC_ENTITY_PARAM_SELECT_SINGLE"), bean.getAccEntityID());

	%>
	<body onLoad="FocusFirstElement();">
		<form name="formAgeingAnalysisReportCriteria" id="formAgeingAnalysisReportCriteria" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame"  onReset="FocusFirstElement();">
		
		<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' height='100%'>
			<tr>
			<td width='100%' align='center' class="WHITE">
				<table cellpadding="0" cellspacing="0" width="80%" align="center" border="0">
				<th colspan=4 align=left><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>

				
				<tr>
					<td>&nbsp;</td>
					<td class="fields" colspan=2>&nbsp;&nbsp;&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td class="fields">&nbsp;&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				</tr>
				<tr>
					<td  class="label"><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></td>
					<td colspan=2>&nbsp;&nbsp;<input maxLength=20 size=20 name="p_fm_item_code" id="p_fm_item_code" value="" class="UPPER"><input class="button" onClick="return searchCodeItem(p_fm_item_code);" type="button" value="?"></td>
					<td>&nbsp;&nbsp;<input maxLength=20 size=20 name="p_to_item_code" id="p_to_item_code" class="UPPER"><input class="button" onClick="return searchCodeItem(p_to_item_code);" type="button" value="?"></td>
				</tr>
				<tr>
					<td  class="label"><fmt:message key="Common.ItemClass.label" bundle="${common_labels}"/></td><!-- Modified for IN:074037  -->
					<td colspan=2>&nbsp;&nbsp;<input maxLength=4 size=4 name="p_fm_item_class_code" id="p_fm_item_class_code" value="" class="UPPER"><input class="button" onClick="return searchCodeItemClass(p_fm_item_class_code);" type="button" value="?" ></td>
					<td>&nbsp;&nbsp;<input maxLength=4 size=4 name="p_to_item_class_code" id="p_to_item_class_code" value=""  class="UPPER"><input class="button" onClick="return searchCodeItemClass(p_to_item_class_code);" type="button" value="?"></td>
				</tr>
				<tr>
					<td class=label><fmt:message key="Common.AlphaCode.label" bundle="${common_labels}"/></td><!-- Modified for IN:074037  -->
					<td colspan=2>&nbsp;&nbsp;<input type=text name=p_fm_alpha_code size=10 maxlength=10 value="" onKeyPress="return CheckForSpecialChars(event);"></td>
					<td>&nbsp;&nbsp;<input type=text name=p_to_alpha_code size=10 maxlength=10 value="" onKeyPress="return CheckForSpecialChars(event);"></td>
				</tr>
				<!-- Added by Shazana for ML-MMOH-CRF-0917 START -->
				
				<tr>
					<td  class="label"><fmt:message key="Common.StoreCode.label" bundle="${common_labels}"/></td><!-- Modified for IN:074037  -->
					<td class=fields>&nbsp;&nbsp;<input maxLength=6 size=6 name="fr_st_code" id="fr_st_code" value="" onKeyPress="return CheckForSpecialChars(event);"><input class="button"  onClick="return searchCodeStore(fr_st_code,'F');" type="button" name="p_fr_sr" id="p_fr_sr" value="?"></td>
					<td class="label">&nbsp;</td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=6 size=6  name="to_st_code" id="to_st_code" value="" onKeyPress="return CheckForSpecialChars(event);"><input class="button" onClick="return searchCodeStore(to_st_code,'T');" type="button"  name="p_to_sr" id="p_to_sr" value="?"></td>
				</tr>
				
				<!-- Added by Shazana for ML-MMOH-CRF-0917 END-->
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>

				<tr>
					<td class="label"><fmt:message key="Common.ReportOption.label" bundle="${common_labels}"/></td>
<!-- 					<td colspan=2>&nbsp;&nbsp;<select name="p_report_option" id="p_report_option">
						<option value=""><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
						<option value="Q"><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></option>
						<option value="V"><fmt:message key="Common.Value.label" bundle="${common_labels}"/></option>
					</select></td>
 -->			<%if(((String)bean.getAccessCostDetails()).equals("Y")){%>
					<td class=fields colspan=5 >&nbsp;&nbsp;<select name="p_report_option" id="p_report_option" >	
						<option  value=""><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
						<option  value="Q"><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></option>
						<option  value="V"><fmt:message key="Common.Value.label" bundle="${common_labels}"/></option>
					</select></td>
			<%}else{%>
					<td class=fields colspan=5 >&nbsp;&nbsp;<select name="P_REPORT_OPTION" id="P_REPORT_OPTION" >	
						<option  value="Q"><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></option>
					</select></td>
			<%}%>
					<td class="label">&nbsp;</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
				<th colspan=4 align=left><fmt:message key="eST.AgeingSlotdays.label" bundle="${st_labels}"/> </th>
				</tr>
				<tr>
					<td colspan=4 align=center>
					<table align='center' cellpadding=0 cellspacing=0 border=0 align=center>
						<tr>
 							<td>&nbsp;
							</td>
							<td class='label' align='center'><b><fmt:message key="Common.Slot.label" bundle="${common_labels}"/> 1</b>
							</td>
							<td>&nbsp;
							</td>
 							<td class='label' align='center'><b><fmt:message key="Common.Slot.label" bundle="${common_labels}"/> 2</b>
							</td>
 							<td>&nbsp;
							</td>
							<td class='label' align='center'><b><fmt:message key="Common.Slot.label" bundle="${common_labels}"/> 3</b>
							</td>
 							<td>&nbsp;
							</td>
							<td class='label' align='center'><b><fmt:message key="Common.Slot.label" bundle="${common_labels}"/> 4</b>
							</td>
 							<td>&nbsp;
							</td>
							<td class='label' align='center'><b><fmt:message key="Common.Slot.label" bundle="${common_labels}"/> 5</b>
							</td>
						</tr>
						<tr>
							<td class='label' align='right'><b>&lt;=</b></td> 
							<td align='center'><input type='text' name="p_slot_1" id="p_slot_1" class="NUMBER" onKeyPress="return isValidInteger(this);" onBlur="checkIntegerFormat(this);" maxlength=10 size=10 value="<%=hmRecord.get("AGE_SLOT_1") == null ? "" : hmRecord.get("AGE_SLOT_1")%>">
							</td>
							<td class='label' align='center'><b>-</b></td>
							<td align='center'><input type='text' name="p_slot_2" id="p_slot_2" class="NUMBER" onKeyPress="return isValidInteger(this);" onBlur="checkIntegerFormat(this);" maxlength=10 size=10 value="<%=hmRecord.get("AGE_SLOT_2") == null ? "" : hmRecord.get("AGE_SLOT_2")%>">
							</td>
							<td class='label' align='center'><b>-</b></td>
							<td align='center'><input type='text' name="p_slot_3" id="p_slot_3" class="NUMBER" onKeyPress="return isValidInteger(this);" onBlur="checkIntegerFormat(this);" maxlength=10 size=10 value="<%=hmRecord.get("AGE_SLOT_3")==null ? "" : hmRecord.get("AGE_SLOT_3")%>">
							</td>
							<td class='label' align='center'><b>-</b></td>
							<td align='center'><input type='text' name="p_slot_4" id="p_slot_4" class="NUMBER" onKeyPress="return isValidInteger(this);" onBlur="checkIntegerFormat(this);" maxlength=10 size=10 value="<%=hmRecord.get("AGE_SLOT_4")==null? "" : hmRecord.get("AGE_SLOT_4")%>" onChange="p_slot_5.value=this.value;">
							</td>
							<td class='label' align='center'><b>&gt;</b></td> 
							<td align='center'><input type='text' name="p_slot_5" id="p_slot_5" class="NUMBER" onKeyPress="return isValidInteger(this);" onBlur="checkIntegerFormat(this);" maxlength=10 size=10 value="<%=hmRecord.get("AGE_SLOT_5")==null ? "" : hmRecord.get("AGE_SLOT_5")%>" readOnly>
							</td>
						</tr>
					</table>
					</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				</table>
				</td>  
				</tr>
			</table>

			
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
			<input type="hidden" name="p_module_id" id="p_module_id" 		value="ST">
			<input type="hidden" name="p_report_id" id="p_report_id" value="STBAGENG">
	
			<input type="hidden" name="p_user_name" id="p_user_name"			value="<%=user_name%>">
			<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%=facility_id%>">
			<input type="hidden" name="p_language_id" id="p_language_id"		value="<%=locale%>">
			
			<input type="hidden" name="p_fr_st_code" id="p_fr_st_code"		 value=""><!--Added by Shazana for ML-MMOH-CRF-0917-->
			<input type="hidden" name="p_to_st_code" id="p_to_st_code"	     value=""><!--Added by Shazana for ML-MMOH-CRF-0917-->
            

		</form>
		<input type="hidden" name="SQL_ST_STORE_LOOKUP" id="SQL_ST_STORE_LOOKUP" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_STORE_LOOKUP_FOR_REPORT")%>"><!-- Added by Shazana for ML-MMOH-CRF-0917 -->
		<input type="hidden" name="SQL_ST_ITEM_LOOKUP" id="SQL_ST_ITEM_LOOKUP" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_LOOKUP")%>">
			 <input type="hidden" name="SQL_ST_ITEM_CLASS_LOOKUP_LANG" id="SQL_ST_ITEM_CLASS_LOOKUP_LANG" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_CLASS_LOOKUP_FOR_REPORT")%>">
			 <%
putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>	

