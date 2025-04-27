<!DOCTYPE html>
 
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.sql.*,java.util.*, java.text.*, webbeans.eCommon.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>


<html>
<head>

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
	<script LANGUAGE="javascript" src="../../ePH/js/SRRPhDrugUsageByPract.js"></script>
	<script LANGUAGE="javascript" src="../../ePH/js/SRRPhrugAndMedicalSupplyReturnAvePerReturnVoucher.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
	<script LANGUAGE="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../ePH/js/DrugNameCommonLookup.js"></script>
	<script LANGUAGE="javascript" src="../js/PhCommon.js"></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<!--	<script LANGUAGE="javascript" src="../js/PhMessages.js"></script>
		<script language="javascript" src="../../eCommon/js/messages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
-->
</head>

<%
	
	String p_facility_id1		= (String) session.getValue( "facility_id" ) ;
	String sql_ph_medn_stat_pract_select1=PhRepository.getPhKeyValue("SQL_PH_MEDN_STAT_PRACT_MODIFIED_SELECT");
	String sql_ph_drug_search_select2 =	PhRepository.getPhKeyValue("SQL_PH_DRUG_SEARCH_SELECT2");

	String sql_ph_nursing_unit_select	=	"SELECT NURSING_UNIT_CODE CODE, LONG_DESC DESCRIPTION FROM IP_NURSING_UNIT_LANG_VW A, SM_FACILITY_FOR_USER B WHERE A.FACILITY_ID = B.FACILITY_ID  AND UPPER(A.FACILITY_ID) LIKE UPPER(DECODE(?,NULL,'%',?))AND EFF_STATUS='E' AND LOCN_TYPE ='N' AND upper(NURSING_UNIT_CODE) LIKE upper(?) AND upper(LONG_DESC) LIKE upper(?) AND A.LANGUAGE_ID = ";
	String sql_ph_clinic_select			=	"SELECT CLINIC_CODE CODE , LONG_DESC DESCRIPTION  FROM OP_CLINIC_LANG_VW A, SM_FACILITY_FOR_USER B WHERE A.FACILITY_ID = B.FACILITY_ID AND UPPER(A.FACILITY_ID) LIKE UPPER(DECODE(?,NULL,'%',?)) AND EFF_STATUS='E' AND CLINIC_TYPE='C' AND upper(CLINIC_CODE) LIKE upper(?) AND upper(LONG_DESC) LIKE upper(?) AND A.LANGUAGE_ID = ";

	

	String bean_id				= "SRRPHDrugUsageByPractBean" ;
	String bean_name			= "ePH.SRRPHDrugUsageByPractBean";
	SRRPHDrugUsageByPractBean bean	= (SRRPHDrugUsageByPractBean)getBeanObject( bean_id,bean_name, request ) ;
	bean.setLanguageId(locale);
	String	bean_id1			=	"ADRReportBean" ;
	String	bean_name1		=	"ePH.ADRReportBean";

   	ADRReportBean bean1 = (ADRReportBean)getBeanObject(bean_id1,bean_name1 ,request) ;
	bean1.setLanguageId(locale);
	String  med_or_yn			= bean.getMednOrList();
    ArrayList facilityList      = bean.getMednFacilityList();
	//ArrayList dateList          = bean.getMednDateList();
	ArrayList jobtitle          = bean.getTitle();

	if(med_or_yn.equals("N"))
	out.println("<script>GoBack()</script>");
	SimpleDateFormat dtSystemFormat = new SimpleDateFormat("dd/MM/yyyy");
	java.util.Date date_time	 	= new java.util.Date();
	String Sysdate ="";
	Sysdate 				= dtSystemFormat.format(date_time); 
	Sysdate=com.ehis.util.DateUtils.convertDate(Sysdate,"DMY","en",locale);
	
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
		 ArrayList EDL_Classification_List=bean.getEDLClassficationList();
		 HashMap EDLlistvalues=new HashMap();
		 String code="";	
		String desc="";
		String speciality_code=request.getParameter("speciality_code")== null ? "":request.getParameter("speciality_code");
		
%>



<BODY onload="document.FormClinicalalertReportCriteria.p_facility_code.focus();callgroup(this);" onMouseDown="" onKeyDown="lockKey()">
<!--<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" onload="document.formPhMednStatByPractCriteria.p_facility_code.focus();"> -->

<form name="FormClinicalalertReportCriteria" id="FormClinicalalertReportCriteria" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame"  >
	
	<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
	<TH COLSPAN="6"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></TH>
	<tr><td class='label' colspan='4' height='4'></td></tr>
	<tr>
		<td align="right" class="label"><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/></td>
		<td COLSPAN="3" align="left">&nbsp;<SELECT name="p_report_type" id="p_report_type"  onChange="" style="width:155px">
			<option value ="S"><fmt:message key="Common.Summary.label" bundle="${common_labels}"/></option>
		   	<option value ="D"><fmt:message key="Common.Detail.label" bundle="${common_labels}"/></option>
			<option value ="M"><fmt:message key="Common.monthly.label" bundle="${common_labels}"/> <fmt:message key="Common.Summary.label" bundle="${common_labels}"/></option>	
    	  </select>
		  &nbsp;<img src="../../eCommon/images/mandatory.gif"  align="center">
        </td>
    </tr>
	<tr><td class='label' colspan='4' height='4'></td></tr>
	<tr>
		<td class="label"><fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
		<!-- <td>&nbsp;</td> -->
		<td>&nbsp;<input type="text" size="10" maxlength=10 name="dt_from1" id="dt_from1" Onblur="CheckDate(this);if(DateCheck(sysdate,dt_from1))validate_date(this,'TO_DATE_LESS_FROM')">
		<IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('dt_from1');" >&nbsp;<img src="../../eCommon/images/mandatory.gif"  align="center"></td>&nbsp;&nbsp;<td class="label">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;To</td>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" size="10" name="dt_to1" id="dt_to1" Onblur="CheckDate(this);if(DateCheck(sysdate,dt_to1))validate_date(this,'TO_DATE_LESS_FROM')">&nbsp;<IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('dt_to1');" >&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"></td>
		<INPUT TYPE="hidden" name="dt_from" id="dt_from" VALUE="">
		<INPUT TYPE="hidden" name="dt_to" id="dt_to" VALUE="">
	</tr>
	<tr><td class='label' colspan='4' height='4'></td></tr>
	<tr>
        <td class="label"><fmt:message key="Common.FacilityName.label" bundle="${common_labels}"/></td>
		<td COLSPAN="5">&nbsp;<SELECT name="p_facility_code" id="p_facility_code" onchange=''>
		   	<OPTION VALUE=""> <fmt:message key="ePH.AllAccessFacility.label" bundle="${ph_labels}"/></OPTION>
	<%	 if (facilityList.size() > 0 )
				for (int i=0; i<facilityList.size(); i+=2) {
	%>
			 <OPTION VALUE="<%= facilityList.get(i) %>"><%= facilityList.get(i+1) %></OPTION>

	<% 	} %>
	
	</select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center">
	</td>
	<td colspan='4'></td>
	</tr>
	<tr><td class='label' colspan='4' height='4'></td></tr>
	
	<tr>
		<td class="label"><fmt:message key="ePH.ClinicalAlertType.label" bundle="${ph_labels}"/></td>
		<td>&nbsp;<select name="p_clinical_Alert_Type" id="p_clinical_Alert_Type" onchange=''>
		<OPTION VALUE="">-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</OPTION>
		<OPTION VALUE="DA"><fmt:message key="ePH.DrugAllergy.label" bundle="${ph_labels}"/></OPTION>
		<OPTION VALUE="DI"><fmt:message key="Common.DrugInteraction.label" bundle="${common_labels}"/></OPTION>
		<OPTION VALUE="DDUP"><fmt:message key="ePH.DrugDuplication.label" bundle="${ph_labels}"/></OPTION>
		<OPTION VALUE="DDOS"><fmt:message key="ePH.DrugDosage.label" bundle="${ph_labels}"/></OPTION>
		<OPTION VALUE="DD"><fmt:message key="ePH.Contraindication.label" bundle="${ph_labels}"/></OPTION>
		</select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center">
		</td>
		<td class="label" nowrap>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.groupby.label" bundle="${common_labels}"/></td>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select name="p_group_by" id="p_group_by" onChange='callgroup(this);'>
		<OPTION VALUE="">-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</OPTION>
		<OPTION VALUE="L"><fmt:message key="Common.Location.label" bundle="${common_labels}"/></OPTION>
		<OPTION VALUE="S"><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></OPTION>
		<OPTION VALUE="P"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></OPTION>
		</select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center">
		</td>
		
	</tr>
	<tr><td class='label' colspan='4' height='4'></td></tr>
	<tr>
		<td class="label"><fmt:message key="ePH.ATCLevel.label" bundle="${ph_labels}"/></td>
		<td>&nbsp;<select name="p_report_ids" id="p_report_ids" onChange=''>
		<OPTION VALUE="">-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</OPTION>
		<OPTION VALUE="ATCS1"><fmt:message key="Common.AnatomicalClass.label" bundle="${common_labels}"/></OPTION>
		<OPTION VALUE="ATCS2"><fmt:message key="Common.TherapeuticMainClass.label" bundle="${common_labels}"/></OPTION>
		<OPTION VALUE="ATCS3"><fmt:message key="Common.TherapeuticSubClass.label" bundle="${common_labels}"/></OPTION>
		<OPTION VALUE="ATCS4"><fmt:message key="Common.ChemicalMainClass.label" bundle="${common_labels}"/></OPTION>
		<OPTION VALUE="ATCS5"><fmt:message key="Common.ChemicalSubClass.label" bundle="${common_labels}"/></OPTION>
		</select>
		</select>
		</td>
		</tr>
		<tr><td class='label' colspan='4' height='4'></td></tr>
		<tr >
						<td class="label"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
						<td>&nbsp;<input type="text"  name="P_PAT_ID1" id="P_PAT_ID1" size=20 value=""  onKeyPress="return CheckForSpecChars(event)" maxlength="<%=bean1.getPatientIDLength()%>" >&nbsp;<input type="button" name="patient_search" id="patient_search" value="?" class="button" onClick="callPatientLookup();">
						<input type="hidden" name="P_PAT_ID" id="P_PAT_ID" value="">
						</td>	
		</tr>		
		<tr><td class='label' colspan='4' height='4'></td></tr>
		<tr >
		<td align='right' class="label" nowrap><fmt:message key="Common.Drug.label" bundle="${common_labels}"/></td>
				<td>&nbsp;<input type="text" name="p_drug_name" id="p_drug_name" maxlength="40" size="40" readonly >&nbsp;<input type="button" class="button" value="?" name="p_drug_name_search" id="p_drug_name_search" onfocus="searchDrugName();" onclick="searchDrugName();">
				<input type="hidden" name="p_drug_code" id="p_drug_code" value="">
				</td>
		</tr>
		<tr><td class='label' colspan='4' height='4'></td></tr>
		<tr>
		<td class="label"><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
		<td>&nbsp;<select name="Location_Type" id="Location_Type" onChange="parent.disableLocation(this.value)">
		<option value="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
		<option value="N"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option><option value="C"><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
		</select>
		</td>
		<td colspan='4'></td> 
    </tr>
	<tr><td class='label' colspan='4' height='4'></td></tr>
	<tr>
		<td  class="label"><fmt:message key="ePH.LocationForm.label" bundle="${ph_labels}"/></td>
		<td>&nbsp;<input type="text" name="loc_name" id="loc_name" maxlength="30" size="30" value="" readonly>&nbsp;<input type="button" class="button"  disabled value="?" name="loc_search" id="loc_search" onfocus="parent.searchLocationName(FormClinicalalertReportCriteria.loc_name, 1)" onClick="parent.searchLocationName(FormClinicalalertReportCriteria.loc_name, 1)"></td>
		<input type="hidden" name="loc_id" id="loc_id" value="">
		<td  class="label">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="tloc_name" id="tloc_name" maxlength="30" size="30" value="" readonly>&nbsp;<input type="button" class="button" disabled value="?" name="tloc_search" id="tloc_search" onfocus="parent.searchLocationName(FormClinicalalertReportCriteria.tloc_name, 2)" onClick="parent.searchLocationName(FormClinicalalertReportCriteria.tloc_name, 2)"></td>
		<input type="hidden" name="tloc_id" id="tloc_id" value="">
		<td colspan='2'></td>
	</tr>
	<tr><td class='label' colspan='4' height='4'></td></tr>
	<tr>
		<td class="label"><fmt:message key="Common.Specialty.label" bundle="${common_labels}"/></td>
		<td>&nbsp;<input type="text" name="p_specialty_name" id="p_specialty_name" readonly maxlength="30" size="30" value="">&nbsp;<input type="button" class="button" value="?" name="p_specialty_search" id="p_specialty_search" disabled onClick='selectspeciality(p_specialty_name,"from")'></td>
		<input type="hidden" name="p_specialty_id" id="p_specialty_id" value=""> 
		<td class="label" nowrap>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="tp_specialty_name" id="tp_specialty_name" readonly maxlength="30" size="30" value="">&nbsp;<input type="button" class="button" value="?" name="tp_specialty_search" id="tp_specialty_search" disabled onClick='selectspeciality(tp_specialty_name,"to")'></td>
		<input type="hidden" name="tp_specialty_id" id="tp_specialty_id" value="">
		<td colspan='2'></td>
	</tr>
	<tr><td class='label' colspan='4' height='4'></td></tr>
	<tr>
		<td class="label"><fmt:message key="Common.PractitionerFrom.label" bundle="${common_labels}"/></td>
		<td>&nbsp;<input type="text" name="pract_name" id="pract_name" readonly maxlength="30" size="30" value="">&nbsp;<input type="button" class="button" value="?" name="pract_search" id="pract_search" disabled onClick="parent.searchPractitioner(pract_name, 1)"></td>
		<input type="hidden" name="pract_id" id="pract_id" value=""> 
		<td class="label" nowrap>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="tpract_name" id="tpract_name" readonly maxlength="30" size="30" value="">&nbsp;<input type="button" class="button" value="?" name="tpract_search" id="tpract_search" disabled onClick="parent.searchPractitioner(tpract_name, 2)"></td>
		<input type="hidden" name="tpract_id" id="tpract_id" value="">
		<td colspan='2'></td>
	</tr>
	<tr><td class='label' colspan='4' height='4'></td></tr>
	</table>



<INPUT TYPE="hidden" name="sysdate" id="sysdate" VALUE="<%=Sysdate%>">
<input type="hidden" name="p_reprint" id="p_reprint" value="Y">
<input type="hidden" name="p_report_id" id="p_report_id" value="">
<input type="hidden" name="p_module_id" id="p_module_id" value="PH">
<input type="hidden" name="p_report_name" id="p_report_name" value="">
<input type="hidden" name="p_report_exec_name" id="p_report_exec_name" value="">
<INPUT TYPE="hidden" name="p_facility_id1" id="p_facility_id1" VALUE="<%=p_facility_id1%>">	
<INPUT TYPE="hidden" name="P_facility_id" id="P_facility_id" VALUE="">	
<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>">
<input type="hidden" name="Nursing_Unit_Code" id="Nursing_Unit_Code" value="">
<input type="hidden" name="Clinic_Code" id="Clinic_Code" value="">
<input type="hidden" name="p_frm_order_date" id="p_frm_order_date" value="">
<input type="hidden" name="p_to_order_date" id="p_to_order_date" value="">
<input type="hidden" name="p_patient_id" id="p_patient_id" value="">
<input type="hidden" name="p_locn_type" id="p_locn_type" value="">
<input type="hidden" name="p_frm_locn_code" id="p_frm_locn_code" value="">
<input type="hidden" name="p_to_locn_code" id="p_to_locn_code" value="">
<input type="hidden" name="p_frm_spec_code" id="p_frm_spec_code" value="">
<input type="hidden" name="p_to_spec_code" id="p_to_spec_code" value="">
<input type="hidden" name="p_frm_pract_code" id="p_frm_pract_code" value="">
<input type="hidden" name="p_to_pract_code" id="p_to_pract_code" value="">
<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
</form>
<input type="hidden" name="sql_ph_drug_search_select2" id="sql_ph_drug_search_select2" value="<%=sql_ph_drug_search_select2%>">
<INPUT TYPE="hidden" name="sql_ph_medn_stat_pract_select1" id="sql_ph_medn_stat_pract_select1" VALUE="<%=sql_ph_medn_stat_pract_select1%>">
<input type="hidden" name="nursing_unit_query" id="nursing_unit_query" value="<%=sql_ph_nursing_unit_select%>">
<input type="hidden" name="clinic_query" id="clinic_query" value="<%=sql_ph_clinic_select%>">
<% putObjectInBean(bean_id,bean,request);
 putObjectInBean(bean_id1,bean1,request);%>
</body>
</html>

