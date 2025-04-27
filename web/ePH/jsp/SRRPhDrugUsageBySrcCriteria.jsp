<!DOCTYPE html>
 <%-- saved on 03/11/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" %>

<html>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	//
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<!-- import the calendar script -->
	<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
 	<script LANGUAGE="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script LANGUAGE="javascript" src="../../ePH/js/SRRPhDrugUsageBySrc.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
	<script LANGUAGE="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../ePH/js/DrugNameCommonLookup.js"></script>
	<script LANGUAGE="javascript" src="../js/PhCommon.js"></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<!-- 	<script LANGUAGE="javascript" src="../js/PhMessages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 --></head>

<%
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	/*Added new Queries for Locationtype clinic and Nursing unit also for ATC Classification */
	//String sql_ph_nursing_unit_select =	PhRepository.getPhKeyValue("SQL_PH_MEDN_ORD_STAT_SRC_NU_SELECT1");
	String sql_ph_nursing_unit_select	=	"SELECT NURSING_UNIT_CODE CODE, LONG_DESC DESCRIPTION FROM IP_NURSING_UNIT_LANG_VW A, SM_FACILITY_FOR_USER B WHERE A.FACILITY_ID = B.FACILITY_ID  AND UPPER(A.FACILITY_ID) LIKE UPPER(DECODE(?,NULL,'%',?))AND EFF_STATUS='E' AND LOCN_TYPE ='N' AND upper(NURSING_UNIT_CODE) LIKE upper(?) AND upper(LONG_DESC) LIKE upper(?) AND A.LANGUAGE_ID = ";
	//String sql_ph_clinic_select =	PhRepository.getPhKeyValue("SQL_PH_MEDN_ORD_STAT_SRC_CL_SELECT1");
	String sql_ph_clinic_select			=	"SELECT CLINIC_CODE CODE , LONG_DESC DESCRIPTION  FROM OP_CLINIC_LANG_VW A, SM_FACILITY_FOR_USER B WHERE A.FACILITY_ID = B.FACILITY_ID AND UPPER(A.FACILITY_ID) LIKE UPPER(DECODE(?,NULL,'%',?)) AND EFF_STATUS='E' AND CLINIC_TYPE='C' AND upper(CLINIC_CODE) LIKE upper(?) AND upper(LONG_DESC) LIKE upper(?) AND A.LANGUAGE_ID = ";
	String sql_ph_reports_atc1_lookup=PhRepository.getPhKeyValue("SQL_PH_REPORTS_ATC1_LOOKUP");
	String sql_ph_reports_atc2_lookup=PhRepository.getPhKeyValue("SQL_PH_REPORTS_ATC2_LOOKUP");
	String sql_ph_reports_atc3_lookup=PhRepository.getPhKeyValue("SQL_PH_REPORTS_ATC3_LOOKUP");
	String sql_ph_reports_atc4_lookup=PhRepository.getPhKeyValue("SQL_PH_REPORTS_ATC4_LOOKUP");
	String sql_ph_reports_atc5_lookup=PhRepository.getPhKeyValue("SQL_PH_REPORTS_ATC5_LOOKUP"); //ends queries
	String bean_id				= "SRRPHRepMednOrdStatBySrcBean" ;
	String bean_name			= "ePH.SRRPHRepMednOrdStatBySrcBean";
	SRRPHRepMednOrdStatBySrcBean bean	= (SRRPHRepMednOrdStatBySrcBean)getBeanObject( bean_id, bean_name , request) ;
	bean.setLanguageId(locale);
	String  med_or_yn			= bean.getMednOrList();
    ArrayList facilityList       = bean.getMednFacilityList();
    
   

	if(med_or_yn.equals("N"))
	out.println("<script>GoBack()</script>");
	//Code for billing lookup----starts 28/12/09--****
	String	billingYN       =   "";
	String	visible         =   "";
	billingYN					  =  bean.checkforbillinginterface();//Check from DB
	bean.setBillingYN(billingYN);//Set to bean
    if(billingYN.equals("Y")){
		visible = "visibility:visible";}
	else{
		 visible = "visibility:hidden";}
		 String blng_grp_id=request.getParameter("blng_grp_id")== null ? "":request.getParameter("blng_grp_id");
		 /*Creating New Array List for EDL List box values*/
		 ArrayList EDL_Classification_List=new ArrayList();
		 EDL_Classification_List=bean.getEDLClassficationList();
		 HashMap EDLlistvalues=new HashMap();
		 String code="";	
		String desc="";




%>

<BODY onload="document.formPhDrugUsageBySrcCriteria.p_facility_code.focus();" onMouseDown="" onKeyDown="lockKey()">
<!-- <BODY onload="document.formPhDrugUsageBySrcCriteria.p_facility_code.focus();"> -->
<!--<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" onload="document.formPhDrugUsageBySrcCriteria.p_facility_code.focus();"> -->

<form name="formPhDrugUsageBySrcCriteria" id="formPhDrugUsageBySrcCriteria" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame" >
	
	<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
	<TH COLSPAN="6"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></TH>
	<tr>
        <td class="label"><fmt:message key="Common.FacilityName.label" bundle="${common_labels}"/></td>
		<td COLSPAN="5">&nbsp;<SELECT name="p_facility_code" id="p_facility_code" >
		   	<OPTION VALUE=""> <fmt:message key="ePH.AllAccessFacility.label" bundle="${ph_labels}"/></OPTION>
	<%	 if (facilityList.size() > 0 )
				for (int i=0; i<facilityList.size(); i+=2) {
	%>
			 <OPTION VALUE="<%= facilityList.get(i) %>"><%= facilityList.get(i+1) %></OPTION>

	<% 	} %>
	</select>
	</td>
	</tr>
	
	<tr>
		<td class="label" ><fmt:message key="Common.periodfrom.label" bundle="${common_labels}"/></td>
		<td>&nbsp;<input type="text" size="10" name="dt_from1" id="dt_from1" maxlength=10 OnBlur='CheckDate(this)'><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('dt_from1');" >&nbsp;<img src="../../eCommon/images/mandatory.gif"  align="center"></td> &nbsp;&nbsp;<td class="label">To</td><td>&nbsp;<input type="text" size="10" name="dt_to1" id="dt_to1" maxlength=10 OnBlur='CheckDate(this)'><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('dt_to1');" >&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"></td>
		<INPUT TYPE="hidden" name="dt_from" id="dt_from" VALUE=" ">
		<INPUT TYPE="hidden" name="dt_to" id="dt_to" VALUE=" ">
	</tr>
	<tr>
		<td class="label"><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
		<td>&nbsp;<select name="Location_Type" id="Location_Type" onChange="parent.disableLocation(this.value)">
		<option value="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
		<option value="N"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option><option value="C"><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
		</select></select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center">
		</td>
		<td colspan='4'></td> 
    </tr>
	<tr>
		<td width="15%" class="label"><fmt:message key="ePH.LocationForm.label" bundle="${ph_labels}"/></td>
		<td width="30%">&nbsp;<input type="text" name="loc_name" id="loc_name" maxlength="30" size="30" value="" readonly><input type="button" class="button"  disabled value="?" name="loc_search" id="loc_search" onfocus="parent.searchLocationName(formPhDrugUsageBySrcCriteria.loc_name, 1)" onClick="parent.searchLocationName(formPhDrugUsageBySrcCriteria.loc_name, 1)"></td>
		<input type="hidden" name="loc_id" id="loc_id" value="">
		<td width="5%" class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
		<td width="50%">&nbsp;<input type="text" name="tloc_name" id="tloc_name" maxlength="30" size="30" value="" readonly><input type="button" class="button" disabled value="?" name="tloc_search" id="tloc_search" onfocus="parent.searchLocationName(formPhDrugUsageBySrcCriteria.tloc_name, 2)" onClick="parent.searchLocationName(formPhDrugUsageBySrcCriteria.tloc_name, 2)"></td>
		<input type="hidden" name="tloc_id" id="tloc_id" value="">
		<td colspan='2'></td>
	</tr>
	<!-- Adding new legend billing group 28/12/09 -->
	<tr>
				<td width="15%" class='label'><label style="<%=visible%>"><fmt:message key="ePH.BillingGroup.label" bundle="${ph_labels}"/></label></td>
				<td width="30%">&nbsp<input type=text name="billing_from" id="billing_from" readonly maxlength="30" style="<%=visible%>" size="30" value=""><input class='button' type=button name="billing_button" id="billing_button" value="?"  style="<%=visible%>"  onClick='selectbilling(billing_from,"from");'>
				<input type ='hidden' name='p_fr_privilegde' id='p_fr_privilegde' value =''/>
				</td>
				<td width="15%" class="label" ><label style="<%=visible%>"><fmt:message key="Common.to.label" bundle="${common_labels}"/></label></td>
				<td width="30%">&nbsp<input type=text name="billing_to" id="billing_to" readonly maxlength="30" style="<%=visible%>" size="30" value=""><input class='button' type=button name="billing_button" id="billing_button" value="?"  style="<%=visible%>"  onClick='selectbilling(billing_to,"to");'>
				<input type ='hidden' name='p_to_privilegde' id='p_to_privilegde' value =''/>	
				</td>
				<td colspan='2'></td> 
			  </tr>	
	<tr>
				<td  class="label"><fmt:message key="ePH.TypeofOrder.label" bundle="${ph_labels}"/></td>
				<td>&nbsp;<select name="order_type" id="order_type" onChange="">
				    <option value="ALL" selected><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
                    <option value=""><fmt:message key="ePH.RxOrder.label" bundle="${ph_labels}"/></option>
					<option value="6"><fmt:message key="ePH.CompoundingOrder.label" bundle="${ph_labels}"/> </option>
					<option value="7"><fmt:message key="ePH.TPNStandard.label" bundle="${ph_labels}"/></option>
					<option value="9"><fmt:message key="ePH.OncologyOrder.label" bundle="${ph_labels}"/></option>
					<option value="8"><fmt:message key="ePH.TPNAdmixture.label" bundle="${ph_labels}"/></option>
					<option value="0"><fmt:message key="ePH.OncologyAdmixture.label" bundle="${ph_labels}"/></option>
				</select>
				</td>
				<td colspan='4'></td>
				</tr>		
	<tr>
		<td width="15%" class="label"><fmt:message key="ePH.DrugNameFrom.label" bundle="${ph_labels}"/></td>
		<td width="30%">&nbsp;<input type="text" name="drug_name" id="drug_name" maxlength="30" size="30" value=""><input type="button" class="button" value="?" name="drug_search" id="drug_search" onfocus="callDrugSearch(document.formPhDrugUsageBySrcCriteria.drug_name, 1)" onClick="callDrugSearch(document.formPhDrugUsageBySrcCriteria.drug_name, 1)"></td>
		<input type="hidden" name="drug_code" id="drug_code" value="">
		<td width="5%" class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
		<td width="50%">&nbsp;<input type="text" name="tdrug_name" id="tdrug_name" maxlength="30" size="30" value=""><input type="button" class="button" value="?" name="tdrug_search" id="tdrug_search" onfocus="callDrugSearch(document.formPhDrugUsageBySrcCriteria.tdrug_name, 2)" onClick="callDrugSearch(document.formPhDrugUsageBySrcCriteria.tdrug_name, 2)"></td>
		<input type="hidden" name="tdrug_code" id="tdrug_code" value="">
	</tr>
	<tr>
	<td class="label" nowrap><fmt:message key="ePH.TermCodeforDrugItems.label" bundle="${ph_labels}"/></td>
	<td><input type="checkbox" name="p_termcode" id="p_termcode"value="N" onClick="checkStatus(this,Term_Code_For_drugItem)">
	</td>
	<input type="hidden" name="Term_Code_For_drugItem" id="Term_Code_For_drugItem" value="N">
	<td colspan='4'></td>
	</tr>
	<tr>
		<td class="label"><fmt:message key="ePH.ATCLevel.label" bundle="${ph_labels}"/></td>
		<td>&nbsp;<select name="p_atc_level" id="p_atc_level" onChange='callATC(this);'>
		<OPTION VALUE="ALL">-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</OPTION>
		<OPTION VALUE="ATC1"><fmt:message key="Common.AnatomicalClass.label" bundle="${common_labels}"/></OPTION>
		<OPTION VALUE="ATC2"><fmt:message key="Common.TherapeuticMainClass.label" bundle="${common_labels}"/></OPTION>
		<OPTION VALUE="ATC3"><fmt:message key="Common.TherapeuticSubClass.label" bundle="${common_labels}"/></OPTION>
		<OPTION VALUE="ATC4"><fmt:message key="Common.ChemicalMainClass.label" bundle="${common_labels}"/></OPTION>
		<OPTION VALUE="ATC5"><fmt:message key="Common.ChemicalSubClass.label" bundle="${common_labels}"/></OPTION>
		</select>
		</td>
	</tr>
	<tr>
		<td width="15%" class="label" nowrap><fmt:message key="ePH.ATCClassificationFrom.label" bundle="${ph_labels}"/></td>
		<td width="30%" id="atc_from">&nbsp;<input type="text" name="p_atc_from_id" id="p_atc_from_id" readonly maxlength="30" size="30" value=""><input type="button" class="button" value="?" name="narrationFrom" id="narrationFrom" onClick="search1(document.forms[0].p_atc_from_id,'1')" disabled></td>
		<td width="10%" class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
		<td width="50%" id="atc_to">&nbsp;<input type="text" name="p_atc_to_id" id="p_atc_to_id" maxlength="30" readonly size="30" value=""><input type="button" class="button" value="?" name="narrationTo" id="narrationTo" onClick="search1(document.forms[0].p_atc_to_id,'2')" disabled></td>
		<input type="hidden" name="p_atc_from" id="p_atc_from" value="">
	<input type="hidden" name="p_atc_to" id="p_atc_to" value="">
	<!-- <INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>"> -->
	<!-- <INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= p_facility_id %>"> -->
	<!-- <INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>"> -->
	<!-- <INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH"> -->
	<!-- <INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="PHUSBYPRA"> -->
	</tr>
	<tr>
	<td class="label"><fmt:message key="Common.NationalItem.label" bundle="${common_labels}"/></td>
		<td>&nbsp;<select name="nat_item" id="nat_item" onChange='callNational(this);'>
		<OPTION VALUE="ALL">-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</OPTION>
		<OPTION VALUE="NAT"><fmt:message key="Common.National.label" bundle="${common_labels}"/></OPTION>
		<OPTION VALUE="NONAT"><fmt:message key="Common.NonNational.label" bundle="${common_labels}"/></OPTION>
		</select>
		</td>
		<td class="label"><fmt:message key="Common.Itemtype.label" bundle="${common_labels}"/></td>
		<td>&nbsp;<select name="item_type" id="item_type" onChange=''>
		<OPTION VALUE="ALL"><fmt:message key="Common.all.label" bundle="${common_labels}"/></OPTION>
		<OPTION VALUE="ORG"><fmt:message key="Common.Original.label" bundle="${common_labels}"/></OPTION>
		<OPTION VALUE="GEN"><fmt:message key="Common.generic.label" bundle="${common_labels}"/></OPTION>
		</select>
	</td>
		<td colspan='2'>&nbsp;</td>
	</tr>
	<tr>
	<td class="label" nowrap><fmt:message key="Common.EDClassification.label" bundle="${common_labels}"/></td>
		<td colspan="5">&nbsp;<select name="ed_class" id="ed_class" style="width:550px" disabled>
		<OPTION VALUE="">-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</OPTION>
		<% 
		for(int i=0; i<EDL_Classification_List.size(); i++)
				{	
					EDLlistvalues = (HashMap)EDL_Classification_List.get(i);
					code = (String)EDLlistvalues.get("code");
                    desc = (String)EDLlistvalues.get("desc");
			
			%>
            <OPTION value="<%=code%>"><%=desc%></OPTION>
			<%
			
			}
		
			%>
		
		</select>
		</td>
	
	</tr>

	<tr>
		<td class="label"><fmt:message key="Common.groupby.label" bundle="${common_labels}"/></td>
		<td COLSPAN="3">&nbsp;<select name="p_group_by" id="p_group_by">
					<option value="LC"><fmt:message key="Common.Location.label" bundle="${common_labels}"/></option>
					<option value="DR"><fmt:message key="Common.Drug.label" bundle="${common_labels}"/></option>
					</select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center">
		</td>
 	</tr>
	<tr>
		<td class="label"><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/></td>
		<td COLSPAN="3">&nbsp;<select name="p_report_by" id="p_report_by">
					<option value="DT"><fmt:message key="Common.Detail.label" bundle="${common_labels}"/></option>
					<option value="SM"><fmt:message key="Common.Summary.label" bundle="${common_labels}"/></option>
					</select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center">
		</td>
	</tr>
	</table>
	
	<input type="hidden" name="Nursing_Unit_Code" id="Nursing_Unit_Code" value="">
	<input type="hidden" name="Clinic_Code" id="Clinic_Code" value="">
	<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
	<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= p_facility_id %>">
	<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
	<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="PHUSBYSRC">
	 <INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>"> 
	<!-- added Hidden variables for new changeson29/12/09 -->
	<INPUT TYPE="hidden" name="billingYN" id="billingYN" VALUE="<%=billingYN%>">
	<INPUT TYPE="hidden" name="billingYN" id="billingYN" VALUE="<%=billingYN%>">
	</form>
	<input type="hidden" name="nursing_unit_query" id="nursing_unit_query" value="<%=sql_ph_nursing_unit_select%>">
	<input type="hidden" name="clinic_query" id="clinic_query" value="<%=sql_ph_clinic_select%>">
	<INPUT TYPE="hidden" name="sql_ph_reports_atc1_lookup" id="sql_ph_reports_atc1_lookup" VALUE="<%=sql_ph_reports_atc1_lookup%>">
	<INPUT TYPE="hidden" name="sql_ph_reports_atc2_lookup" id="sql_ph_reports_atc2_lookup" VALUE="<%=sql_ph_reports_atc2_lookup%>">
	<INPUT TYPE="hidden" name="sql_ph_reports_atc3_lookup" id="sql_ph_reports_atc3_lookup" VALUE="<%=sql_ph_reports_atc3_lookup%>">
	<INPUT TYPE="hidden" name="sql_ph_reports_atc4_lookup" id="sql_ph_reports_atc4_lookup" VALUE="<%=sql_ph_reports_atc4_lookup%>">
	<INPUT TYPE="hidden" name="p_reprint" id="p_reprint" VALUE="Y">
	
	
	

<% putObjectInBean(bean_id,bean,request); %>
</body>
</html>

