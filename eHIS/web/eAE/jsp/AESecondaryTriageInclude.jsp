<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ page import="java.sql.Connection,java.sql.ResultSet,java.sql.PreparedStatement,java.util.*,java.util.HashMap,java.util.Properties, java.util.ArrayList, java.text.SimpleDateFormat, com.ehis.util.*, webbeans.eCommon.ConnectionManager,eCommon.Common.*,org.json.simple.*" contentType="text/html;charset=UTF-8"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<%


Connection con				      = null;  
PreparedStatement pstmt		      = null;
ResultSet rset				      = null;
PreparedStatement pstmt1	      = null;
PreparedStatement pstmtEncounter      = null;
ResultSet rset1				      = null;
ResultSet rsetEncounter				      = null;
String sqlFinal		= "";
String sql2		= "";
StringBuffer sbBuff = new StringBuffer();

String ca_install_yn= checkForNull( request.getParameter( "ca_install_yn") );
int tindex = 0;
String sys_date_time= checkForNull( request.getParameter( "sys_date_time") );
String dis_triage_record_date_time= checkForNull( request.getParameter( "dis_triage_record_date_time") );
String VisitProp= checkForNull( request.getParameter( "VisitProp") );
String EncounterProp= checkForNull( request.getParameter( "EncounterProp") );
String facilityId= checkForNull( request.getParameter( "facilityId") );
String RepDb= checkForNull( request.getParameter( "RepDb") );
String sqlDate= checkForNull( request.getParameter( "sqlDate") );
String priority= checkForNull( request.getParameter( "priority") );
String five_level_triage_appl_yn= checkForNull( request.getParameter( "five_level_triage_appl_yn") );
String disPriority= checkForNull( request.getParameter( "disPriority") );
String optSelected= checkForNull( request.getParameter( "optSelected") );
String priorityStatus1= checkForNull( request.getParameter( "priorityStatus1") );
String priorityStatus2= checkForNull( request.getParameter( "priorityStatus2") );
String priorityStatus3= checkForNull( request.getParameter( "priorityStatus3") );
String disabled111= checkForNull( request.getParameter( "disabled111") );
String disabled11= checkForNull( request.getParameter( "disabled11") );
String disabled12= checkForNull( request.getParameter( "disabled12") );
String disabled13= checkForNull( request.getParameter( "disabled13") );
String red= checkForNull( request.getParameter( "red") );
String yellow= checkForNull( request.getParameter( "yellow") );
String green = checkForNull( request.getParameter( "green") );
String prioritynewdisabled = checkForNull( request.getParameter( "prioritynewdisabled") );
String priority_zone_code= checkForNull( request.getParameter( "priority_zone_code") );
String priority_zone_desc= checkForNull( request.getParameter( "priority_zone_desc") );
String priority_zone_order= checkForNull( request.getParameter( "priority_zone_order") );
String priority_zone_color= checkForNull( request.getParameter( "priority_zone_color") );
String priority_zone_hidden_fileds= checkForNull( request.getParameter( "priority_zone_hidden_fileds") );
String priority_selected= checkForNull( request.getParameter( "priority_selected") );
String priority_no= checkForNull( request.getParameter( "priority_no") );
String dis_regn_ref= checkForNull( request.getParameter( "dis_regn_ref") );
StringBuffer sqlAmbulatory= new StringBuffer(checkForNull( request.getParameter( "sqlAmbulatory")));
String AmbulatorySql= checkForNull( request.getParameter( "AmbulatorySql") );
String modify_flag= checkForNull( request.getParameter( "modify_flag") );
String modifyYN= checkForNull( request.getParameter( "modifyYN") );
String dis_area= checkForNull( request.getParameter( "dis_area") );
String display_triage_record_date_time= checkForNull( request.getParameter( "display_triage_record_date_time") );
String encounter_id= checkForNull( request.getParameter( "encounter_id") );
String locale= checkForNull( request.getParameter( "locale") );
String priority_code= checkForNull( request.getParameter( "priority_code") );
String queue_appl_priority_zone= checkForNull( request.getParameter( "queue_appl_priority_zone") );

String queue_max_num_allowed= checkForNull( request.getParameter( "queue_max_num_allowed") );
String queue_no= checkForNull( request.getParameter( "queue_no") );
String dis_queue_no= checkForNull( request.getParameter( "dis_queue_no") );
String queue_num_mandatory= checkForNull( request.getParameter( "queue_num_mandatory") );
String patient_id= checkForNull( request.getParameter( "patient_id") );
String clinic_code = checkForNull( request.getParameter( "clinic_code") );
String patient_gender= checkForNull( request.getParameter( "patient_gender") );
String treat_code= checkForNull( request.getParameter( "treat_code") );
String optSelectedTreat = checkForNull( request.getParameter( "optSelectedTreat") );
String disTreatArea= checkForNull( request.getParameter( "disTreatArea") );
String bed_no= checkForNull( request.getParameter( "bed_no") );
String disBed= checkForNull( request.getParameter( "disBed") );
String disBed1= checkForNull( request.getParameter( "disBed1") );
String checked1= checkForNull( request.getParameter( "checked1") );
String disDisaster = checkForNull( request.getParameter( "disDisaster") );
String visit_date = checkForNull( request.getParameter( "visit_date") );
String dis1= checkForNull( request.getParameter( "dis1") );
String dis2= checkForNull( request.getParameter( "dis2") );
String dis3= checkForNull( request.getParameter( "dis3") );
String dis5= checkForNull( request.getParameter( "dis5") );
String dis7= checkForNull( request.getParameter( "dis7") );
String dis16= checkForNull( request.getParameter( "dis16") );
String disMed= checkForNull( request.getParameter( "disMed") );
String disSur = checkForNull( request.getParameter( "disSur") );
String disOandGYn= checkForNull( request.getParameter( "disOandGYn") );
String a_status= checkForNull( request.getParameter( "a_status") );
String leveloftriage_visibility = checkForNull( request.getParameter( "leveloftriage_visibility") );
String attend_practitioner_name= checkForNull( request.getParameter( "attend_practitioner_name") );
String attend_practitioner_id= checkForNull( request.getParameter( "attend_practitioner_id") );
String transport_mode_code= checkForNull( request.getParameter( "transport_mode_code") );
String accompanied_by_code= checkForNull( request.getParameter( "accompanied_by_code") );
String accompanied_by_dis= checkForNull( request.getParameter( "accompanied_by_dis") );
String pat_dtls_unknown_yn= checkForNull( request.getParameter( "pat_dtls_unknown_yn") );
String referral_id= checkForNull( request.getParameter( "referral_id") );
String disRefID= checkForNull( request.getParameter( "disRefID") );
String complaint= checkForNull( request.getParameter( "complaint") );
String triage_remarks= checkForNull( request.getParameter( "triage_remarks") );
String checkedMed= checkForNull( request.getParameter( "checkedMed") );
String checkedSur= checkForNull( request.getParameter( "checkedSur") );
String checkedOandGYn= checkForNull( request.getParameter( "checkedOandGYn") );
String oscc_yn= checkForNull( request.getParameter( "oscc_yn") );
String medical_yn= checkForNull( request.getParameter( "medical_yn") );
String surgical_yn= checkForNull( request.getParameter( "surgical_yn") );
String queue_secondary_triage= checkForNull( request.getParameter( "queue_secondary_triage") );
String disaster_category_yn= checkForNull( request.getParameter( "disaster_category_yn") );
String disaster_type_code= checkForNull( request.getParameter( "disaster_type_code") );
String disaster_category_code= checkForNull( request.getParameter( "disaster_category_code") );
String checked2= checkForNull( request.getParameter( "checked2") );
String checked9= checkForNull( request.getParameter( "checked9") );
String disOscc= checkForNull( request.getParameter( "disOscc") );
String disable3= checkForNull( request.getParameter( "disable3") );
String called_from_ca= checkForNull( request.getParameter( "called_from_ca") );

String caseType= checkForNull( request.getParameter( "caseType") );
String caseTypeDisable= checkForNull( request.getParameter( "caseTypeDisable") );
String caseTypeMandYn= checkForNull( request.getParameter( "caseTypeMandYn") );
String caseTypeYn= checkForNull( request.getParameter( "caseTypeYn") );
String date_time_of_accident= checkForNull( request.getParameter( "date_time_of_accident") );
String localeName= checkForNull( request.getParameter( "localeName") );
int p_count=0;//Added by krishna Pranay ML-MMOH-CRF-1759.1
String disDateAcci= checkForNull( request.getParameter( "disDateAcci") );
String place_of_accident= checkForNull( request.getParameter( "place_of_accident") );
String disPlaceAcci= checkForNull( request.getParameter( "disPlaceAcci") );
String mech_injury_subcatg_code= checkForNull( request.getParameter( "mech_injury_subcatg_code") );
String vehicle_invlovedcode= checkForNull( request.getParameter( "vehicle_invlovedcode") );
String Vehicle_Reg_No1= checkForNull( request.getParameter( "Vehicle_Reg_No1") );
String dis6= checkForNull( request.getParameter( "dis6") );
String dis8= checkForNull( request.getParameter( "dis8") );
String dis9= checkForNull( request.getParameter( "dis9") );
String dis10= checkForNull( request.getParameter( "dis10") );
String dis11= checkForNull( request.getParameter( "dis11") );
String dis12= checkForNull( request.getParameter( "dis12") );
String dis13= checkForNull( request.getParameter( "dis13") );
String protective_device_code= checkForNull( request.getParameter( "protective_device_code") );
String pat_position_code= checkForNull( request.getParameter( "pat_position_code") );
String checked3= checkForNull( request.getParameter( "checked3") );
String checked5= checkForNull( request.getParameter( "checked5") );
String checked6= checkForNull( request.getParameter( "checked6") );
String checked7= checkForNull( request.getParameter( "checked7") );
String disMLC= checkForNull( request.getParameter( "disMLC") );
String MLC_DEATH_YN= checkForNull( request.getParameter( "MLC_DEATH_YN") );
String disMLCDeath= checkForNull( request.getParameter( "disMLCDeath") );
String pol_rep_no_mx_size= checkForNull( request.getParameter( "pol_rep_no_mx_size") );
String pol_stn_det_mx_size= checkForNull( request.getParameter( "pol_stn_det_mx_size") );
String police_station_dtls= checkForNull( request.getParameter( "police_station_dtls") );
String police_rep_no= checkForNull( request.getParameter( "police_rep_no") );
String MLC_NO_OUTSIDE_DTLS= checkForNull( request.getParameter( "MLC_NO_OUTSIDE_DTLS") );
String disOutMLCDet= checkForNull( request.getParameter( "disOutMLCDet") );
String MLC_CAPTURE_DATE= checkForNull( request.getParameter( "MLC_CAPTURE_DATE") );
String disDateOfCapt= checkForNull( request.getParameter( "disDateOfCapt") );
String disMLCRemark= checkForNull( request.getParameter( "disMLCRemark") );
String MLC_REMARKS= checkForNull( request.getParameter( "MLC_REMARKS") );
String initialMgmtLblName= checkForNull( request.getParameter( "initialMgmtLblName") );
String order_catalog_code1= checkForNull( request.getParameter( "order_catalog_code1") );
String order_catalog_code2= checkForNull( request.getParameter( "order_catalog_code2") );
String order_catalog_code3= checkForNull( request.getParameter( "order_catalog_code3") );
String order_catalog_code4= checkForNull( request.getParameter( "order_catalog_code4") );
String order_catalog_code5= checkForNull( request.getParameter( "order_catalog_code5") );
String order_catalog_code6= checkForNull( request.getParameter( "order_catalog_code6") );
String FBCProp= checkForNull( request.getParameter( "FBCProp") );
String ECGProp= checkForNull( request.getParameter( "ECGProp") );
String DressProp= checkForNull( request.getParameter( "DressProp") );
String SpO2Prop= checkForNull( request.getParameter( "SpO2Prop") );
String dressingLblName= checkForNull( request.getParameter( "dressingLblName") );
String intialMgmtOthers= checkForNull( request.getParameter( "intialMgmtOthers") );
String disIntialMgmtOthers= checkForNull( request.getParameter( "disIntialMgmtOthers") );
String dis14= checkForNull( request.getParameter( "dis14") );
String dis15= checkForNull( request.getParameter( "dis15") );
String disImmobil= checkForNull( request.getParameter( "disImmobil") );
String immobilization= checkForNull( request.getParameter( "immobilization") );
String selected= checkForNull( request.getParameter( "selected") );
String selected1= checkForNull( request.getParameter( "selected1") );
String selected2= checkForNull( request.getParameter( "selected2") );
String checked4= checkForNull( request.getParameter( "checked4") );
String checked8= checkForNull( request.getParameter( "checked8") );
int patient_age= Integer.parseInt(checkForNull( request.getParameter( "patient_age") ));
int max_age_paediatric= Integer.parseInt(( request.getParameter( "max_age_paediatric") ));
int min_age_pregnancy= Integer.parseInt(checkForNull( request.getParameter( "min_age_pregnancy") ));
String sex= checkForNull( request.getParameter( "sex") );
String pediatric_status= checkForNull( request.getParameter( "pediatric_status") );
String disabled991= checkForNull( request.getParameter( "disabled991") );
String disImm= checkForNull( request.getParameter( "disImm") );
String disMenarche= checkForNull( request.getParameter( "disMenarche") );
String disabled99= checkForNull( request.getParameter( "disabled99") );
String disHeight= checkForNull( request.getParameter( "disHeight") );
String disWeight= checkForNull( request.getParameter( "disWeight") );
String height= checkForNull( request.getParameter( "height") );
String weight= checkForNull( request.getParameter( "weight") );
String capBloodSugProp= checkForNull( request.getParameter( "capBloodSugProp") );
String cbdProp= checkForNull( request.getParameter( "cbdProp") );
String medication= checkForNull( request.getParameter( "medication") );
String disMedication= checkForNull( request.getParameter( "disMedication") );
String fbccheck= checkForNull( request.getParameter( "fbccheck") );
String fbccheck_val= checkForNull( request.getParameter( "fbccheck_val") );
String disCir= checkForNull( request.getParameter( "disCir") );
String disabled= checkForNull( request.getParameter( "disabled") );
String menstrual_status= checkForNull( request.getParameter( "menstrual_status") );
String disabledPre= checkForNull( request.getParameter( "disabledPre") );
String min_age_for_lmp= checkForNull( request.getParameter( "min_age_for_lmp") );
String year_value= checkForNull( request.getParameter( "year_value") );
int minageforlmp= Integer.parseInt(checkForNull( request.getParameter( "minageforlmp") ));
String lmp_date= checkForNull( request.getParameter( "lmp_date") );
String lmpdate1=checkForNull( request.getParameter( "lmp_date") );//Added by krishna Pranay ML-MMOH-CRF-1759.1
String clinical_notes_status= checkForNull( request.getParameter( "clinical_notes_status") );
String patient_class= checkForNull( request.getParameter( "patient_class") );
String episode_id= checkForNull( request.getParameter( "episode_id") );
String loginUser= checkForNull( request.getParameter( "loginUser") );
String ca_chart_rec_status= checkForNull( request.getParameter( "ca_chart_rec_status") );
String sys_date_qry= checkForNull( request.getParameter( "sys_date_qry") );
String circumference= checkForNull( request.getParameter( "circumference") );
String Vehicle_Reg_No2= checkForNull( request.getParameter( "Vehicle_Reg_No2") );
String vehicle_invlovedcode1= checkForNull( request.getParameter( "vehicle_invlovedcode1") );
String mech_injr_code= checkForNull( request.getParameter( "mech_injr_code") );
String PositionSql= checkForNull( request.getParameter( "PositionSql") );
String invokeMenstrualHistYN= checkForNull( request.getParameter( "invokeMenstrualHistYN") );//Added by krishna Pranay ML-MMOH-CRF-1759.1
String latestMensDtlStatus= checkForNull( request.getParameter( "latestMensDtlStatus") );//Added by krishna Pranay ML-MMOH-CRF-1759.1
String rec_view_lmp_details_label= checkForNull( request.getParameter( "rec_view_lmp_details_label") );//Added by krishna Pranay ML-MMOH-CRF-1759.1
String function_id= checkForNull( request.getParameter( "function_id") );//Added by krishna Pranay ML-MMOH-CRF-1759.1
String MensdisabledPre= checkForNull( request.getParameter( "MensdisabledPre") );//Added by krishna Pranay ML-MMOH-CRF-1759.1
String lastMensPeriod="",lastPeriodWeeks="",lastPeriodDays ="",lastPeriodEdd ="",unsureDatePeriod ="",unsureDateWeeks ="",unsureDateDays  ="",unsureRedd  ="",CALmpDate="",CAWeeks="",CADays="", CAEdd="",exisitng_pregency_yn="";	//Added by krishna Pranay ML-MMOH-CRF-1759.1
StringBuffer sqlPosition= new StringBuffer( checkForNull(request.getParameter( "sqlPosition")));

int countECG =0, countDerss=0, countSpO2=0, countCapBlood=0,countCBD=0,yearvalue=0;

Boolean isPriorityZoneAppl			= false;
Boolean modeofarrival=false;
Boolean isCaseDtlsRadioBtnAppl	= false;
Boolean isMechInjLabelChngAppl	= false;
Boolean isReconfirmCOTAppl = false;
Boolean isChngBtnPositionAppl = false;
Boolean isOrderCatalogChngAppl	= false;
Boolean isMLCAppl = false;
boolean isSecondaryTriageQueueNum = false;


try{
	 con = ConnectionManager.getConnection(request);
	 
	 boolean siteSpecific		=eCommon.Common.CommonBean.isSiteSpecific(con, "MR","MLC_TO_MEDICO_LEGAL_CASE"); 
		/*end ML-MMOH-CRF-0354 [IN057191] */
		/*Below query modified for this CRF AAKH-CRF-0010 [IN038535]*/
		Boolean isLabelChngAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "AE","LABEL_CHG_BR_DEAD_PLACE_ACCDNT"); //Added by Ashwini on 18-Jan-2017 for GDOH-CRF-0131
		/*Below query modified for this CRF ML-MMOH-CRF-0644 [IN:062162]*/
		boolean allowSplChar =eCommon.Common.CommonBean.isSiteSpecific(con, "AE","ALLOW_SPLCHAR_DISASTERREF");  
		//Added by Mano on 20-jan-2017 for MMOH-CRF-0644
		Boolean isPlaceOfOccuurrence = eCommon.Common.CommonBean.isSiteSpecific(con, "AE","PLACE_OF_OCCURRENCE");  // Added by mujafar for ML-MMOH-CRF-0647
		//Below line added for this CRF ML-MMOH-CRF-0654
		 modeofarrival = eCommon.Common.CommonBean.isSiteSpecific(con, "AE","SECONDARY_TRIAGE");  
		 Boolean isReplacePresntngPrblmByChiefComp = eCommon.Common.CommonBean.isSiteSpecific(con, "AE","REPLACE_PRE_PROB_BY_CHF_COMPL"); //Added by Ashwini on 22-May-2017 for ML-MMOH-CRF-0650
		isCaseDtlsRadioBtnAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "AE","SEC_TRIAGE_CASE_DETAILS");//Added by Thamizh selvi on 8th Mar 2018 against ML-MMOH-CRF-645
		isMechInjLabelChngAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "AE","RENAME_MECH_INJ_SUB_INJ");//Added by Thamizh selvi on 29th Mar 2018 against ML-MMOH-CRF-649
		Boolean isSecTrgBackDateTimeAppl=eCommon.Common.CommonBean.isSiteSpecific(con, "AE","SEC_TRG_BACK_DATE_APPL");// Added by Shanmukh on 6th-Apr-2018 for ML-MMOH-CRF-0656
		isChngBtnPositionAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "AE","DIAGNOSIS_DTLS_IN_24HRS_VISIT");//Added by Thamizh selvi on 9th Apr 2018 against ML-MMOH-CRF-0655
		isOrderCatalogChngAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "AE","SEC_TRIAGE_ORDER_CATALOG");//Added by Thamizh selvi on 12th Apr 2018 against ML-MMOH-CRF-0651
		isPriorityZoneAppl			= eCommon.Common.CommonBean.isSiteSpecific(con, "AE", "PRIORITY_ZONE");//Added By Shanmukh for MMS-DM-CRF-0147
		isMLCAppl 			=eCommon.Common.CommonBean.isSiteSpecific(con, "AE", "MLC_DTLS");//Added by Ajay Hatwate for GHL-CRF-0650
		//Added by Ajay Hatwate for ML-MMOH-CRF-2069
		isSecondaryTriageQueueNum = eCommon.Common.CommonBean.isSiteSpecific(con, "AE", "SECONDARY_TRIAGE_QNUM");
		//Added by Ashwini on 18-Jan-2021 for ML-MMOH-CRF-1409
		isReconfirmCOTAppl		= eCommon.Common.CommonBean.isSiteSpecific(con, "AE", "RECONFIRM_CASE_OF_TRAUMA");
	
%>
<div id='Triage_Details'>
	 <table cellspacing='0' cellpadding='0' width='100%' border=0 align='center'>
            <tr><td class='white'>

		<ul id="tablist" class="tablist" >
			<li class="tablistitem" title="Triage Details">
				<a  class="tabClicked" id='Triage_Details_tab' >
					<span class="tabSpanclicked" onClick='javascript:expandCollapse("Triage_Details_tab")' id="Triage_tabspan"><fmt:message key="Common.TriageDetails.label" bundle="${common_labels}"/></span>
				</a>
			</li>
			<%if(ca_install_yn.equals("Y")){%>
			<li class="tablistitem" title="Assessment">
				<a class="tabA" id='Assessment_tab' >
					<span class="tabAspan" onClick='javascript:expandCollapse("Assessment_tab")' id="assess_tabspan"><fmt:message key="Common.Assessment.label" bundle="${common_labels}"/></span>
				</a>
			</li>
			<%}%> 
		</ul>
    </td></tr>
    </table>
	<table cellspacing='0' cellpadding='0' width='100%' border=0 align='center'>
      <tr><td class='white'>
			<ul id="tablist" class="tablist">
				<li class="tablistitem" title="Condition / Case">
					<a  class="tabClicked" id="Condition_tab" >
						<span class="tabSpanclicked" onClick='javascript:expandCollapse("Condition_tab")' id="patCond_tabspan"><fmt:message key="eAE.ConditionCase.label" bundle="${ae_labels}"/></span>
					</a>
				</li>
				<!--Added by Thamizh selvi on 10th Apr 2018 against ML-MMOH-CRF-0655 Start-->
				<% if(isChngBtnPositionAppl){ %>
				<li class="tablistitem" title="Allergy Details">
					<a  class="tabA" id="allergy_dtls" >
						<span class="tabAspan" onClick='javascript:expandCollapse("allergy_dtls")' id="allergyDtls_tabspan"><fmt:message key="Common.AllergyDetails.label" bundle="${common_labels}"/></span>
					</a>
				</li>
				<% } %><!--End-->
				<li class="tablistitem" title="Others">
					<a class="tabA" id="others_tab" >
						<span class="tabAspan" onClick='javascript:expandCollapse("others_tab")' id="others_tabspan"><fmt:message key="Common.others.label" bundle="${common_labels}"/></span>
					</a>
				</li>
			</ul>
       </td></tr>
</table>
<!--Added by k v shanmukh on 2nd-Apr-2018 against ML-MMOH-CRF-0656 Start-->
<%if(isSecTrgBackDateTimeAppl){%>
<table border="0" cellpadding="0" cellspacing="0" align='center' width='100%'>
	<tr>
		<td class='LABEL'   width='25%' ><fmt:message key="eAE.Triage.label" bundle="${common_labels}"/> <fmt:message key="Common.datetime.label" bundle="${common_labels}"/></td> 
		<% if(display_triage_record_date_time.equals("")){%>
			<td class='fields' width='34%' tabindex='<%=++tindex%>'>
			<input type='text'  id='triage_record_date_time1' name='triage_record_date_time1' id='triage_record_date_time1' value="<%=sys_date_time%>" maxLength='19' size='16' tabindex=''onBlur='triageRecordDate(this);'<%=dis_triage_record_date_time%>>
			<img src="../../eCommon/images/CommonCalendar.gif"  onClick="return showCalendar('triage_record_date_time1', null, 'hh:mm:ss' );" style='cursor:pointer'   /> <img src='../../eCommon/images/mandatory.gif' ></img>
			</td>
		<%}else {%>
			<td class='fields' width='34%' tabindex='<%=++tindex%>'>
			<input type='text'  id='triage_record_date_time1' name='triage_record_date_time1' id='triage_record_date_time1' value="<%=display_triage_record_date_time%>" maxLength='19' size='16' tabindex=''<%=dis_triage_record_date_time%>>
			</td>
		<%}%>
		<!--Added by Thamizh selvi on 9th Apr 2018 against ML-MMOH-CRF-0655 Start-->
		<% if(isChngBtnPositionAppl){ %>
			<td class='fields' width='20%' tabindex='<%=++tindex%>'>
				<input type="button" name="visit_24hr" id="visit_24hr" class="BUTTON" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.VisitWithin24Hrs.label","ae_labels")%>' onClick="showLastVisitDetails('LastVisit24');" <%=VisitProp%>>
			</td>
			<td class='fields' width='21%' tabindex='<%=++tindex%>'>
				<input type="button" name="PrevEncounter" id="PrevEncounter" class="BUTTON" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PreviousEncounters.label","common_labels")%>' onClick="showPrevEncounter();"  <%=EncounterProp%> >
			</td>
		<% } %>
		<!--End-->
	</tr>
</table>
<%}else if(isChngBtnPositionAppl){ %><!--Added by Thamizh selvi on 9th Apr 2018 against ML-MMOH-CRF-0655 Start-->
<table border="0" cellpadding="0" cellspacing="0" align='center' width='100%'>
	<tr>
		<td colspan='2'>&nbsp;</td>
		<td class='fields' width='15%' tabindex='<%=++tindex%>'>
			<input type="button" name="visit_24hr" id="visit_24hr" class="BUTTON" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.VisitWithin24Hrs.label","ae_labels")%>' onClick="showLastVisitDetails('LastVisit24');" <%=VisitProp%>>
		</td>
		<td class='fields' width='15%' tabindex='<%=++tindex%>'>
			<input type="button" name="PrevEncounter" id="PrevEncounter" class="BUTTON" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PreviousEncounters.label","common_labels")%>' onClick="showPrevEncounter();"  <%=EncounterProp%> >
		</td>
	</tr>
</table>
<% } %>
<!--End-->	
	<%
	String secTrgRecDateTimeList=eAE.AECommonBean.getAETrgRecDateTime(con,facilityId,encounter_id,RepDb);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1	 	
	%>
	<input type='hidden' name='secTrgRecDateTimeList' id='secTrgRecDateTimeList' value='<%=secTrgRecDateTimeList%>'>
	
<table border="0" cellpadding="2" cellspacing="0" align='center' width='100%'>
      <input type='hidden' name='sysdate' id='sysdate' value='<%=sqlDate%>'>
	  <tr>
		<td class='COLUMNHEADER' colspan='4' ><fmt:message key="Common.PatientCondition.label" bundle="${common_labels}"/></td>
	  </tr>

     <tr><input type="hidden" name='hddpriority' id='hddpriority'value=<%=priority%>>
              <td class='label' width='25%' ><fmt:message key="Common.PriorityZone.label" bundle="${common_labels}"/></td>
	    <%/*Below Condition Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 28th 2014*/
		if(!five_level_triage_appl_yn.equals("Y")){%>
	          <%
		  
		  if(isPriorityZoneAppl){%><!--Added by Shanmukh on 10th-SEPT-2018 for MMS-DM-CRF-0147-->
		  <td class='fields' width='25%'>
			<select name='Priority_Zone_Type' id='Priority_Zone_Type' onchange='setPriority(this);setTreatment(this);'<%=disPriority%>>		
		<%
		try{
		sql2="SELECT PRIORITY_ZONE,PRIORITY_ZONE_DESC FROM AE_PRIORITY_ZONE_LANG_VW WHERE LANGUAGE_ID= ? and EFF_STATUS='E' and PRIORITY_ZONE not in('B','W') order by PRIORITY_ZONE_ORDER";
				
			    pstmt   = con.prepareStatement(sql2);
				pstmt.setString(1,locale) ;
				rset    = pstmt.executeQuery();
				 while(rset!=null && rset.next())
				{
					if(rset.getString("PRIORITY_ZONE").equals(priority))
							   {
                                    optSelected="selected";
							   }
							   else
								   optSelected="";
							   
					out.println("<option value='"+rset.getString("PRIORITY_ZONE")+"'"+optSelected+">"+rset.getString("PRIORITY_ZONE_DESC")+""); 
				}
		    }catch(Exception e){e.printStackTrace();}
						%>
					</select>
			</td>
		  <%}else{%>
	          <td class='label'   width='25%' tabindex='<%=++tindex%>'>
					<%=red%><input type="checkbox" name='priorityR' id='priorityR'   onClick='setPriority(this);setTreatment(this);' <%=priorityStatus1%> <%=disabled111%>></td>
			 		<td class='label' width='25%' ><%=yellow%><input type="checkbox" name='priorityY' id='priorityY'    onClick='setPriority(this);setTreatment(this);' <%=priorityStatus2%> <%=disabled12%>></td>
			 		<td class='label' width='25%' ><%=green%><input type="checkbox" name='priorityG' id='priorityG' <%=priorityStatus3%> onClick='setPriority(this);setTreatment(this);'<%=disabled13%>>
	          </td>
			<%}%>  
	    <%}else{ %>
	  		  <td class='fields'   width='25%' tabindex='<%=++tindex%>'>
	  		  <select name='prioritynew' id='prioritynew' id='prioritynew'  onchange='setPriority(this.value);setTreatment(this);' <%=prioritynewdisabled%>> 
	    		<option value=''>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------
	    		<% 
	    		String sql1="SELECT PRIORITY_ZONE,PRIORITY_ZONE_DESC,PRIORITY_ZONE_COLOR,PRIORITY_ZONE_ORDER FROM AE_PRIORITY_ZONE_LANG_VW ##REPDB## WHERE LANGUAGE_ID=? and EFF_STATUS='E' order by PRIORITY_ZONE_ORDER asc";//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
				/*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
				sqlFinal = sql1.toString();
				sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
				/*End*/
				pstmt   = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
				pstmt.setString(1,locale) ;
				rset1    = pstmt.executeQuery();
				while(rset1!=null && rset1.next()){
					priority_zone_code	= rset1.getString("PRIORITY_ZONE");
					priority_zone_desc	= rset1.getString("PRIORITY_ZONE_DESC");
					priority_zone_order	=(rset1.getString("PRIORITY_ZONE_ORDER")==null || rset1.getString("PRIORITY_ZONE_ORDER")=="")?"":rset1.getString("PRIORITY_ZONE_ORDER");
					priority_zone_color = (rset1.getString("PRIORITY_ZONE_COLOR")==null || rset1.getString("PRIORITY_ZONE_COLOR")=="")?"":rset1.getString("PRIORITY_ZONE_COLOR");
					priority_zone_hidden_fileds	= priority_zone_hidden_fileds+"<input type='hidden' name='priority_zone_order_by_"+priority_zone_code+"' id='priority_zone_order_by_"+priority_zone_code+"' value='"+priority_zone_order+"'>";
					if(priority.equals(priority_zone_code)){
						priority_selected	= "selected";
						priority_no			= priority_zone_order;
					}else{
						priority_selected	= "";
					}
				%>
					<option value='<%=priority_zone_code%>' style='background-color:<%=priority_zone_color%>;' <%=priority_selected%>><%=priority_zone_desc%></option>
				
				<%}%>
	  	  </select><%if(prioritynewdisabled.equals("")){ %><img align='center' src='../../eCommon/images/mandatory.gif'></img><%}%>
	  	  </td>
	    <%
		 if(rset1!=null) rset1.close();
		 if(pstmt1!=null) pstmt1.close();
	    	
	    } %>		  
		            </tr>  
					<tr> 
					<td class='label' width='25%' > <fmt:message key="Common.priority.label" bundle="${common_labels}"/> </td> 
					 <td class='fields' width='25%' ><select name='priority11' id='priority11' tabindex='65' <%=disPriority%>>
					 <option value=''>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------
                  <%
                       StringBuffer sqlpriority = new StringBuffer();
					   sqlpriority.append("select PRIORITY_CODE,SHORT_DESC from ");
					   sqlpriority.append("ae_pat_priority_lang_vw ##REPDB## where language_id='"+locale+"'  and PRIORITY_ZONE=? and EFF_STATUS='E'");//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
					   /*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
						sqlFinal = sqlpriority.toString();
						sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
						/*End*/
						 pstmt = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
						 pstmt.setString(1,priority);
					     rset = pstmt.executeQuery();
						 
						 while(rset!=null && rset.next())
						   {
							   if(rset.getString(1).equals(priority_code))
							   {
                                    optSelected="selected";
							   }
							   else
								   optSelected="";

							   out.println("<option value='"+rset.getString(1)+"'"+optSelected+">"+rset.getString(2)+" ");
							  
						   }
						 if(pstmt!=null) pstmt.close();
						 if(rset!=null) rset.close();
						 if((sqlpriority != null) && (sqlpriority.length() > 0))
						 {
							sqlpriority.delete(0,sqlpriority.length());
						 }
					   %>  
					</select>
		             </td>   
		             <!-- 	Added by Ajay Hatwate for ML-MMOH-2069  -->
		             <%
		            // System.out.println(isSecondaryTriageQueueNum + " isSecondaryTriageQueueNum " + queue_no + " queue_no "  + priority + " priority");
		             if(!modify_flag.equals("Y") && priority.equals(queue_appl_priority_zone)){
		            	 dis_queue_no = " ";
		             }
		             if(isSecondaryTriageQueueNum && queue_secondary_triage.equals("Y")){ %>
		             <%-- <input type='hidden' name='queue_appl_priority_zone' id='queue_appl_priority_zone' value='<%=queue_appl_priority_zone %>' >
		             <input type='hidden' name='queue_num_mandatory' id='queue_num_mandatory' value='<%=queue_num_mandatory %>' > --%>
		             <td class='label' width='25%' > <fmt:message key="Common.QueueNo.label" bundle="${common_labels}"/> </td> 
					 <td class='fields' width='25%' ><input type='number' id='queue_no1' name='queue_no1' id='queue_no1' onKeyPress='return(ChkNumberInput(this,event,0))' onBlur='validateQueueNo(this)' maxLength='16' size='16' value='<%=queue_no %>' tabindex='66' <%=dis_queue_no %>>
					 <% 
					 String queue_no_mand_img_dis = " disabled ";
					 if(queue_num_mandatory.equals("Y") && !modify_flag.equals("Y") && !priority.equals("U")){ 
						 queue_no_mand_img_dis = " ";
					 }%> 
		             <img src='../../eCommon/images/mandatory.gif' id='queue_no_mand_img' align='center' style='visibility:hidden' ></img>
		             <%
		             
		             int ex_queue_count = 0;
		             StringBuffer sqlTreatA = new StringBuffer();
					 sqlTreatA.append(" select count(*) count from  ae_queue_no_audit where PATIENT_ID=?  and encounter_id=? order by ADDED_DATE desc ");//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
					/*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
					sqlFinal = sqlTreatA.toString();
					sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
					/*End*/
					 pstmt = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
					 pstmt.setString(1,patient_id);
					 pstmt.setString(2,encounter_id);
					
					 rset = pstmt.executeQuery();
					 
					 while(rset!=null && rset.next())
					   {
						 ex_queue_count =rset.getInt("count");
						}
					 if(pstmt!=null) pstmt.close();
					 if(rset!=null) rset.close();
					 if((sqlTreatA != null) && (sqlTreatA.length() > 0))
					 {
						sqlTreatA.delete(0,sqlTreatA.length());
					 }
		             if(ex_queue_count > 1){ %>
		             
		             <input type=button class=button value='<fmt:message key="Common.AuditTrail.label" bundle="${common_labels}"/>' onClick="callSecQueueAudit();">
		             
		             <% }
					 } %>
		             <!-- End of ML-MMOH-CRF-2069 -->
					</tr>  

		<tr> 
		
			  <td class='LABEL'  width='25%' ><fmt:message key="Common.treatmentarea.label" bundle="${common_labels}"/></td>
			  <td class='fields' width='25%' tabindex='<%=++tindex%>'>
			   <%
				 StringBuffer sqlTreatA = new StringBuffer();
				 sqlTreatA.append("SELECT treatment_area_code, short_desc FROM ae_tmt_area_for_clinic_lang_vw ##REPDB## WHERE language_id='"+locale+"'  and facility_id = ? AND clinic_code = ?  AND priority_zone = ?  AND  (gender = ? OR gender IS NULL) ");//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
				/*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
				sqlFinal = sqlTreatA.toString();
				sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
				/*End*/
				 pstmt = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
				 pstmt.setString(1,facilityId);
				 pstmt.setString(2,clinic_code);
				 pstmt.setString(3,priority);
				 pstmt.setString(4,patient_gender);
				
				 rset = pstmt.executeQuery();
				 
				 while(rset!=null && rset.next())
				   {
					 String code =rset.getString(1);
					 String desc =specialCharacter(rset.getString(2));
					 if (code.equals("null") || code==null) 
						 code="";
					  if (desc.equals("null") || desc==null) 
						 desc="";
					  if(code.equals(treat_code))
					   {
							optSelectedTreat="selected";
					   }
					   else
						   optSelectedTreat="";
			   
					   sbBuff.append("<option value=\""+code+"\" "+optSelectedTreat+">"+desc+"</option>");
				  }
				 if(pstmt!=null) pstmt.close();
				 if(rset!=null) rset.close();
				 if((sqlTreatA != null) && (sqlTreatA.length() > 0))
				 {
					sqlTreatA.delete(0,sqlTreatA.length());
				 }
				 
			   %> 
			   <select name='treat_area' id='treat_area'  <%=disTreatArea%> onChange='clearBed();clearBed1();'>
				<option value=''>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
				<%=sbBuff.toString()%>
			    </select>
			 </td>
			 
				   <!-- onblur="ChangeUpperCase(this);checkForValidBed(this.value);" -->
			 <td class='label' width='25%'><fmt:message key="eAE.BedBayNo.label" bundle="${ae_labels}"/></td>
			 <td class='fields' width='25%' tabindex='<%=++tindex%>'><input type='text' name='bed_bay_no' id='bed_bay_no' size='8' maxlength='8'  readonly onblur="ChangeUpperCase(this);" onKeyPress="return(CheckForSpecChars(event))"  value ='<%=bed_no%>' <%=disBed%>><input type=button class=button value='?' name='bed_button' id='bed_button'  onClick="callBedAvailChart();" <%=disBed1%>>
             </td>
		  </tr>
          <tr> 
             <td class='label' ><fmt:message key="Common.Disaster.label" bundle="${common_labels}"/></td>
			 <td class='fields' width='25%' tabindex='<%=++tindex%>'><input type="checkbox" name='Disaster_YN' id='Disaster_YN'  onClick='setDisaster(this)'<%=checked1%> <%=disDisaster%>></td>
			 <%
			 if(allowSplChar)
			 {
			 %>
		   <td class='label' ><fmt:message key="eAE.DisasterReference.label" bundle="${ae_labels}"/></td>
			 <td class='fields' width='25%' tabindex='<%=++tindex%>'><input type="text" name='Disaster_Reference' id='Disaster_Reference'  onKeyPress="return CheckForSpecChar(event)"
			  value="<%=dis_regn_ref%>" maxLength="15" <%=disabled11%> ></td>
             <td class='label' colspan='2'>&nbsp;</td>
			 <%
			 }
			 else
			 {
			 %>
			  <td class='label' ><fmt:message key="eAE.DisRegnReference.label" bundle="${ae_labels}"/></td>
			 <td class='fields' width='25%' tabindex='<%=++tindex%>'><input type="text" name='Disaster_Reference' id='Disaster_Reference'   onKeyPress="return CheckForSpecChars(event)"  value='<%=dis_regn_ref%>' maxLength='15' <%=disabled11%> ></td>
			 <td class='label' colspan='2'>&nbsp;</td>
			 <%
			 }
			 %>
		  </tr> 
		  <tr>
			 <td class='label' width='25%'><fmt:message key="eAE.DisasterArea.label" bundle="${ae_labels}"/></td>
			 <td class='fields' width='25%' tabindex='<%=++tindex%>'><input type='text'  name="disaster_area1" id="disaster_area1" value="<%=dis_area%>" maxLength='10' onblur='if(this.value !="")searchDisasterArea(this,disaster_area1);'  <%=disabled11%>><input type='button' name='disaster' id='disaster' value='?' class='button'  tabindex='<%=++tindex%>' onclick='searchDisasterArea(this,disaster_area1);' <%=disabled11%> >
             </td>
             <% if(disaster_category_yn.equals("N")){ %>
		      <td class='LABEL' width='25%'><fmt:message key="eAE.DisasterType.label" bundle="${ae_labels}"/></td>
			 <td class='fields' width='25%' tabindex='<%=++tindex%>'>
				 <select name='disaster_type' id='disaster_type' tabindex='63' <%=disabled11%>>
				  <option value=''>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------
			<%  
                  try
				  {	
				   PreparedStatement pstmtTrans = null;
				   ResultSet rsetTrans = null;
				   optSelected="";
				  sqlFinal = "select a.disaster_type_code, a.short_desc from ae_disaster_type_lang_vw ##REPDB## a where a.language_id='"+locale+"'  and  a.eff_status='E' and  a.disaster_type_code like '%%' order by short_desc";
				  sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
                  pstmtTrans = con.prepareStatement(sqlFinal);
				  /*End*/
				   rsetTrans = pstmtTrans.executeQuery();
				   while(rsetTrans!=null && rsetTrans.next())
					{
					  if(rsetTrans.getString(1).equals(disaster_type_code))
							   {
                                    optSelected="selected";			
							   }
							   else
							   {
								   optSelected="";				      
							   }
					  out.println("<option value='"+rsetTrans.getString("disaster_type_code")+"' "+optSelected+" >"+rsetTrans.getString("short_desc")+""); 
					}
                  if(rsetTrans!=null) rsetTrans.close();
				  if(pstmtTrans!=null) pstmtTrans.close();
				  }catch(Exception e) {e.printStackTrace();}
	            %>
                 </select>
              </td>
              <%} %>
           </tr>
<!--            Added by Ajay Hatwate ML-MMOH-CRF-2111 -->
           <%if(disaster_category_yn.equals("Y")){ %>
           <tr>
             <td class='LABEL' width='25%'><fmt:message key="Common.Disaster.label" bundle="${common_labels}"/> <fmt:message key="Common.category1.label" bundle="${common_labels}"/></td>
			 <td class='fields' width='25%' tabindex='<%=++tindex%>'>
				 <select name='disaster_category' id='disaster_category' onChange="remVal(document.forms[0].disaster_type);setDisasterType(this);" tabindex='63' <%=disabled11%>>
				  <option value=''>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
				  <%
				try {	
					pstmt = con.prepareStatement("select disaster_category_code, short_desc from ae_disaster_category where eff_status = 'E'");
					rset = pstmt.executeQuery();
					while(rset!=null && rset.next()) {
						if(rset.getString(1).equals(disaster_category_code)){
							out.println("<option value='"+rset.getString(1)+"' selected>"+rset.getString(2)+" ");
						}else{
							out.println("<option value='"+rset.getString(1)+"'>"+rset.getString(2)+" ");							
						}
					}
				    if(pstmt!=null) pstmt.close();
 			        if(rset!=null) rset.close();
				}catch (Exception e) {e.printStackTrace();}
			%>
				  </select>
				  </td>  
				  <td class='LABEL' width='25%'><fmt:message key="eAE.DisasterType.label" bundle="${ae_labels}"/></td>
			 <td class='fields' width='25%'>
				 <select name='disaster_type' id='disaster_type' tabindex='63' <%=disabled11%>>
				  <option value=''>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
				  <%if(modifyYN.equals("Y")){  
	                  try
					  {	
					   PreparedStatement pstmtTrans = null;
					   ResultSet rsetTrans = null;
					   optSelected="";
					  sqlFinal = "SELECT DISASTER_TYPE_CODE,SHORT_DESC FROM  AE_DISASTER_TYPE ##REPDB## WHERE DISASTER_CATEGORY_CODE=? AND EFF_STATUS='E' ORDER BY 2";
					  sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
	                  pstmtTrans = con.prepareStatement(sqlFinal);
	                  pstmtTrans.setString(1, disaster_category_code);
					   rsetTrans = pstmtTrans.executeQuery();
					   
					   while(rsetTrans!=null && rsetTrans.next())
						{
						  if(rsetTrans.getString(1).equals(disaster_type_code))
								   {
	                                    out.println("<option value='"+rsetTrans.getString("disaster_type_code")+"'  selected >"+rsetTrans.getString("short_desc")+""); 
								   }
						}
	                  if(rsetTrans!=null) rsetTrans.close();
					  if(pstmtTrans!=null) pstmtTrans.close();
					  }catch(Exception e) {e.printStackTrace();}
				  }%>
				  </select>
				  </td>
           </tr>
		      <%} %>
<!--            End of ML-MMOH-CRF-2111		 -->
	      <tr>
			 <input type='hidden' id='regndatetime' name="visit_date_time" id="visit_date_time"  value='<%=visit_date%>'>
			 <%if(modify_flag.equals("Y")) { %>
		      <td class='LABEL'  width='25%' tabindex='<%=++tindex%>' ><fmt:message key="Common.ambulatorystatus.label" bundle="${common_labels}"/></td>
  		      <td class='fields' width='25%' tabindex='<%=++tindex%>'>
				 <select name='ambulatory_status' id='ambulatory_status' tabindex='63' <%=dis1%>>
				  <option value=''>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------
					   <%
						   pstmt = con.prepareStatement(AmbulatorySql);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
					       rset = pstmt.executeQuery();
						   optSelected="";
						   while(rset!=null && rset.next())
						   {
							   if(rset.getString(1).equals(a_status))
							   {
                                    optSelected="selected";	
							   }
							   else
							   {
								   optSelected="";	      
							   }	  
                              out.println("<option value='"+rset.getString(1)+"'"+optSelected+">"+rset.getString(2)+" ");
						   }
						   if(pstmt!=null) pstmt.close();
						   if(rset!=null) rset.close();
						   if((sqlAmbulatory != null) && (sqlAmbulatory.length() > 0))
							 {
								sqlAmbulatory.delete(0,sqlAmbulatory.length());
							 }
					   %>
                 </select>
              </td>
             <%
		     }
			 if(modify_flag.equals("N")) {
		     %>
              <td class='LABEL'  width='25%' ><fmt:message key="Common.ambulatorystatus.label" bundle="${common_labels}"/></td>
  		      <td  class='fields' width='25%' tabindex='<%=++tindex%>'>
				 <select name='ambulatory_status' id='ambulatory_status' tabindex='63' >
				  <option value=''>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------
					   <%
						   pstmt = con.prepareStatement(AmbulatorySql);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
					       rset = pstmt.executeQuery(); 
						   optSelected="";
						   while(rset!=null && rset.next())
						   {
                              out.println("<option value='"+rset.getString(1)+"'>"+rset.getString(2)+" ");
						   }
						   if(pstmt!=null) pstmt.close();
						   if(rset!=null) rset.close();
						   if((sqlAmbulatory != null) && (sqlAmbulatory.length() > 0))
							 {
								sqlAmbulatory.delete(0,sqlAmbulatory.length());
							 }
					   %>
                 </select>
              </td>
			  <%}%>
              </td>		   
			 <!--Bewlow line added for this CRF AAKH-CRF-0010 [IN038535]-->
		<td class='LABEL' width='25%' style='<%=leveloftriage_visibility%>'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
		<td class='fields' width='25%' style='<%=leveloftriage_visibility%>'>
		<input type=text  name=practitioner_desc id=practitioner_desc size=30 maxlength=30 value="<%=attend_practitioner_name%>" onBlur="beforeGetPractitioner(document.forms[0].pract_button,practitioner_desc);" <%=dis16%>><input type=button class=button value='?' name=pract_button id=pract_button   onclick="aegetPractitioner(this,practitioner_desc);" <%=dis16%>><input type=hidden value="<%=attend_practitioner_id%>" name="attend_pract_id" id="attend_pract_id"><input type=hidden value="<%=attend_practitioner_id%>" name="prev_pract_id" id="prev_pract_id"></td>
		   <!--End AAKH-CRF-0010 [IN038535]-->
          </tr>
		   <!--Below line added for this CRF ML-MMOH-CRF-0654-->
		  <%if(modeofarrival){
		  %>		   
		   <tr>
		    <td class='LABEL' width='25%' ><fmt:message key="Common.ModeofArrival.label" bundle="${common_labels}"/></td>
			<td class='fields'  colspan='3'>
				   <select name='transport_mode' id='transport_mode' onChange="remVal(document.forms[0].mode_of_arrival);setTransMode(this);" >
				    	<option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------
                <%  
				   PreparedStatement pstmtTrans = null;
				   ResultSet rsetTrans = null;
				   optSelected="";
				   StringBuffer sqlAMTrans = new StringBuffer();
                   sqlAMTrans.append("SELECT transport_mode, short_desc FROM am_transport_mode_lang_vw ##REPDB## WHERE language_id='"+locale+"' and PATIENT_RELATED_YN='Y' AND eff_status = 'E' ORDER BY 2 ");//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
				   /*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
					sqlFinal = sqlAMTrans.toString();
					sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
					/*End*/
                   pstmtTrans = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1				
				   rsetTrans = pstmtTrans.executeQuery();
				  while(rsetTrans!=null && rsetTrans.next()){	
				  
						if(rsetTrans.getString(1).equals(transport_mode_code)){
							optSelected="selected";								
						}else{
							optSelected="";							      
						}							  
                       out.println("<option value='"+rsetTrans.getString(1)+"'"+optSelected+">"+rsetTrans.getString(2)+" "); 					
				  }
				  if(pstmtTrans!=null) pstmtTrans.close();
				  if(rsetTrans!=null) rsetTrans.close();
				  if((sqlAMTrans != null) && (sqlAMTrans.length() > 0))
				  {
						sqlAMTrans.delete(0,sqlAMTrans.length());
				   }
	            %>
				   </select>
                   <select name='mode_of_arrival' id='mode_of_arrival' >
						 <option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------
				   </select>
		    </td> 
		    </td> 
          </tr>	
          <tr>
            <td class='LABEL'  width='25%' ><fmt:message key="eAE.AccompaniedBy.label" bundle="${ae_labels}"/></td>
			<td class='fields'  width='25%'>
				 <select name='accompany_by' id='accompany_by' <%=accompanied_by_dis%>>
					<option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---
				<%  
				   PreparedStatement pstmtAccom = null;
				   ResultSet rsetAccom = null;
				   optSelected="";	
				   StringBuffer sqlAMEsc = new StringBuffer();
                   sqlAMEsc.append("SELECT ESCORT_TYPE_CODE, SHORT_DESC  FROM  AM_ESCORT_TYPE_LANG_VW ##REPDB## WHERE language_id='"+locale+"' AND EFF_STATUS='E' ORDER BY 2 ");//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
				   /*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
					sqlFinal = sqlAMEsc.toString();
					sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
					/*End*/

				   pstmtAccom = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
				   rsetAccom = pstmtAccom.executeQuery();
				   while(rsetAccom!=null && rsetAccom.next()){
					 
						if(rsetAccom.getString(1).equals(accompanied_by_code)){
							optSelected="selected";								
						}else{
							optSelected="";							      
						}							  
						   out.println("<option value='"+rsetAccom.getString(1)+"'"+optSelected+">"+rsetAccom.getString(2)+" ");
										
					}
				   if(rsetAccom!=null) rsetAccom.close();
				   if(pstmtAccom!=null) pstmtAccom.close(); 
				   if((sqlAMEsc != null) && (sqlAMEsc.length() > 0))
					{
						sqlAMEsc.delete(0,sqlAMEsc.length());
					}
	             %> 
				 </select>
			</td>
			<td class='label'  colspan='2'>&nbsp;</td> 
          </tr>		  
		  <%}%>
		  <!--End ML-MMOH-CRF-0654-->
		  <tr> 
			  <td class='label'   width='25%'><fmt:message key="Common.referralid.label" bundle="${common_labels}"/></td> 
			 <%if(pat_dtls_unknown_yn.equals("N")){%>
				  <td class='fields' width='25%' 
				  tabindex='<%=++tindex%>'><input type='text' name='referral_id' id='referral_id' value="<%=referral_id%>" maxlength='14' size='14'  onBlur='searchPatient(document.forms[0].referral_id);' <%=disRefID%>><input type='button' class='button' value='?' name='ref_id_search' id='ref_id_search'   onClick='getReferralID()' <%=disRefID%>></td>
			<%}else if(pat_dtls_unknown_yn.equals("Y")) {%>
				<td  class='fields' width='25%'><input type='text' name='referral_id' id='referral_id' value='' maxlength='14' size='14'  onBlur=''  align='left' disabled><input type='button' class='button' value='?' name='ref_id_search' id='ref_id_search' onClick='getReferralID()' disabled></td>
		   <%}%>
	     <input type='hidden' name='injury_3' id='injury_3' value=''>

			<!--Added by Ashwini on 22-May-2017 for ML-MMOH-CRF-0650-->
			<%if(!isReplacePresntngPrblmByChiefComp){ %>
				<td class='LABEL' width='25%' ><fmt:message key="Common.PresentingProblem.label" bundle="${common_labels}"/></td>
				<td class='fields' width='25%' tabindex='<%=++tindex%>'><input type='text'  name="complaint_desc" id="complaint_desc" value="<%=complaint%>" onblur='if(this.value !="")searchComplaintType(this,complaint_desc);' tabindex='65' <%=dis3%>><input type='button' name='Complainttype' id='Complainttype' value='?' class='button' onclick='searchComplaintType(this,complaint_desc);' <%=dis3%>>
				</td>	
			<%}else{%>
				<td></td>
				<td>
					<input type=button name='ChiefComplaints' id='ChiefComplaints' value= '<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ChiefComplaints.label","ca_labels")%>'   onClick='ChiefComplaints_type()'  class='Button'  > 
				</td>
			<%}%>
		 </tr>
		 <tr> 
					<td class='LABEL' width='25%' ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
					<td class='fields' width='25%' colspan='3' tabindex='<%=++tindex%>'><textarea name='triage_remarks' cols='50'   align='left'  onblur='makeValidString(this);checkMaxLen(this);' onkeypress='checkMaxLimit(this,250);' <%=dis2%>><%=triage_remarks%></textarea>
		  </td>
		  </tr>  
		 <tr>
					<td class='COLUMNHEADER' colspan='4' ><fmt:message key="eAE.CaseDetails.label" bundle="${ae_labels}"/></td>
		 </tr>
		 <!--Added by Thamizh selvi on 8th Mar 2018 against ML-MMOH-CRF-0645 Start-->
		 <% if(isCaseDtlsRadioBtnAppl){ %>
		<tr>
		<td colspan=4>
		<table border='0' cellpadding='0' cellspacing='0' width='100%'>		
			<tr>
				<td class='label' width='17%'>
					<!--Modified by Ashwini on 18-Jan-2021 for ML-MMOH-CRF-1409-->
					<fmt:message key="Common.CaseofTrauma.label" bundle="${common_labels}"/>
				</td>
				<td class='fields' width='7%'>
					<input type='radio' name='caseDetails' id='caseDetails' tabindex='<%=++tindex%>' id='trauma' value='N' onClick='caseDetailsOnChange(this);' <%=checked9%> <%=dis5%>></input>
				</td>
				<td class='label' width='10%'>
					<fmt:message key="Common.oscc.label" bundle="${common_labels}"/>
				</td>
				<td class='fields' width='7%'>
					<input type='radio' name='caseDetails' id='caseDetails' tabindex='<%=++tindex%>' id='oscc' value='N' onClick='caseDetailsOnChange(this);' <%=disOscc%> <%=checked2%>></input>
				</td>
				<td class='label' width='10%'>
					<span id='osccTypeLabel' style="visibility:hidden"><fmt:message key="Common.oscc.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.type.label" bundle="${common_labels}"/></span>
				</td>
				<td class='fields' width='16%'>
					<select name='osccType' id='osccType' style="visibility:hidden" tabindex='<%=++tindex%>' <%=dis7%>>
						<option value=''>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------
						<%
								JSONArray osccTypeJsonArr	= new JSONArray();
								osccTypeJsonArr  = eAE.AECommonBean.getOSCCTypeList(con,locale,RepDb);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1	
									
								for(int i = 0 ; i < osccTypeJsonArr.size() ; i++) 
								{
									JSONObject osccTypejson		= (JSONObject)osccTypeJsonArr.get(i);
									String injCategoryCode		= (String) osccTypejson.get("injCategoryCode");
									String injSubCategoryCode	= (String) osccTypejson.get("injSubCategoryCode");
									String subCategoryShortDesc	= (String) osccTypejson.get("subCategoryShortDesc");
											
									out.println("<option value="+injCategoryCode+","+injSubCategoryCode+">"+subCategoryShortDesc+"</option>");
											
								}
											
						%>
					</select>
					<img src='../../eCommon/images/mandatory.gif' id='osccTypeMandImg' style="visibility:hidden" align='center'></img>
				</td>
			</tr>
			<tr>
				<td class='label'  width='17%'>
					<fmt:message key="Common.medical.label" bundle="${common_labels}"/>
				</td>
				<td class='fields' width='7%'>
					<input type='radio' tabindex='<%=++tindex%>' name="caseDetails" id='medical' value='N' onClick='caseDetailsOnChange(this);' <%=checkedMed%> <%=disMed%>></input>
				</td>
				<td class='label' width='10%'>
					<fmt:message key="Common.Surgical.label" bundle="${common_labels}"/>
				</td>
				<td class='fields' width='7%'> 
					<input type='radio' tabindex='<%=++tindex%>' name="caseDetails" id='surgical' value='N' onClick='caseDetailsOnChange(this);' <%=checkedSur%> <%=disSur%>></input> 
				</td>
			</tr>
			<tr>
				<td class='label'  width='17%'>
					<fmt:message key="eAE.OandG.label" bundle="${ae_labels}"/>
				</td>
				<td class='fields' width='7%' tabindex='<%=++tindex%>' >
					<input type='radio' name="caseDetails" id="caseDetails" id='OandG' value='N' onClick='caseDetailsOnChange(this);' <%=checkedOandGYn%> <%=disOandGYn%>></input>
				</td>
			</tr>
		</table>
		</td>
		</tr>
			<input type='hidden' name='oscc_yn' id='oscc_yn' value='<%=oscc_yn%>'>
			<input type='hidden' name='medical_yn' id='medical_yn' value='<%=medical_yn%>'>
			<input type='hidden' name='surgical_yn' id='surgical_yn' value='<%=surgical_yn%>'>
		 <% }else{ %>
		 <!--End-->
		 <tr>  
			        <td class='label' width='25%'><fmt:message key="Common.CaseofTrauma.label" bundle="${common_labels}"/></td>
			        <td class='fields' width='25%' tabindex='<%=++tindex%>'><input type='checkbox'   name="CaseofTrauma" id="CaseofTrauma" value='N' onClick='checktrauma(this);setMechInj1(this);' <%=checked9%> <%=dis5%>>
					</td>	
					<td class='label' width='25%'><fmt:message key="Common.oscc.label" bundle="${common_labels}"/></td>
                    <td class='fields' width='25%' tabindex='<%=++tindex%>'><input type='checkbox'  name="oscc_yn" id="oscc_yn"   value='<%=oscc_yn%>' onClick='chkOsccValue(this);remVal(document.forms[0].mechan_injury);setMechInj();' <%=disOscc%> tabindex='' <%=checked2%>>
					<!-- <%=checked2%> <%=disable3%> --> </td>
         </tr>
		 <tr> 
					<td class='label'  width='25%'><fmt:message key="Common.medical.label" bundle="${common_labels}"/></td>
					<td class='fields' width='25%' tabindex='<%=++tindex%>'><input type='checkbox'  name="medical_yn" id="medical_yn" value='N' onClick='chkMedicalValue(this);' <%=checkedMed%> <%=disMed%>></td>
					<td class='label'  width='25%' ><fmt:message key="Common.Surgical.label" bundle="${common_labels}"/></td>
					<td class='fields' width='25%' tabindex='<%=++tindex%>'> <input type='checkbox'  name="surgical_yn" id="surgical_yn"   value='N' onClick='chkSurgValue(this);' <%=checkedSur%> <%=disSur%>> 
					</td>
		 </tr>
		 <% } %>
				<input type='hidden' name='patient_id' id='patient_id' value=<%=patient_id%>>
				<input type='hidden' name='called_from_ca' id='called_from_ca' value=<%=called_from_ca%>>
				<!-- Added by Ajay Hatwate for ML-MMOH-CRf-1653 -->
		<% if(caseTypeYn.equals("Y")){ %>
		 <tr>	
	      <td class='LABEL' width='25%' ><fmt:message key="eAE.CaseType.label" bundle="${ae_labels}"/></td>
		      <td class='fields' width='25%' >
			 <select name='case_type' id='case_type' <%=caseTypeDisable%> >
			 <option value=''>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------
			  <%
			   StringBuffer sqlCaseType = new StringBuffer();
			 	 
			 
			   sqlCaseType.append("SELECT case_type_code, short_desc FROM ae_case_type WHERE EFF_STATUS ='E' ORDER BY 2");

			   pstmt = con.prepareStatement(sqlCaseType.toString());
			   rset = pstmt.executeQuery();
			   while(rset!=null && rset.next())
			   {				   
				  if(caseType.equals(rset.getString(1))){
				 	out.println("<option value='"+rset.getString(1)+"' selected >"+rset.getString(2)+" ");
				  }else{
					out.println("<option value='"+rset.getString(1)+"' >"+rset.getString(2)+" ");  
				  }
			   }
			   if(pstmt!=null) pstmt.close();
			   if(rset!=null)	rset.close();
			   if((sqlCaseType != null) && (sqlCaseType.length() > 0))
				 {
				   sqlCaseType.delete(0,sqlCaseType.length());
				 } 
			   %>
			 </select>
			 <%if(caseTypeMandYn.equals("Y")){ %>
			  <img src='../../eCommon/images/mandatory.gif' align='center'></img>
			 <%} %>
			 </td>
		 </tr>
		 <%} %>
			<!-- End of ML-MMOH-CRF-1653 -->
		 <% if(isCaseDtlsRadioBtnAppl){ %>
		 <tbody id='placeOfOccMechInjFieldsDisplay' style="display:none;">
		 <% } %>
		 <tr>
		 	<!-- if else added by mujafar for ML-MMOH-CRF-0647 -->
			<%if(isPlaceOfOccuurrence == true){%>
			<td class='LABEL'  width='25%' ><fmt:message key="eAE.DateTimeOfOccurrence.label" bundle="${ae_labels}"/></td>
			<%}else{%>
	          <td class='label' width='25%'><fmt:message key="eAE.DateTimeOfAccident.label" bundle="${ae_labels}"/></td>
			<%}%>
  		      <td class='fields' width='25%' tabindex='<%=++tindex%>'>
			  <input type='text'  id='accidentdatetime' name='date_time_accident' id='date_time_accident'   maxLength='16' size='16' tabindex=''
			  value="<%=DateUtils.convertDate(date_time_of_accident,"DMYHM","en",localeName)%>"  onBlur='doDate(this);' <%=disDateAcci%>><img src="../../eCommon/images/CommonCalendar.gif"  onClick="return showCalendar('accidentdatetime', null, 'hh:mm' );" style='cursor:pointer' <%=disDateAcci%> ></img><img src='../../eCommon/images/mandatory.gif' id='dateOfOccurImg' style="visibility:hidden" align='center'></td><!--Added mandatory image for ML-MMOH-CRF-0648 on 5th Apr 2018 by Thamizh selvi-->
	
			  	<!--Added by Ashwini on 19-Jan-2017 for GDOH-CRF-0131-->
				<!-- if else added by mujafar for ML-MMOH-CRF-0647 -->
				<!--Modified by Ashwini on 17-Aug-2017 for GDOH-CRF-0161-->
				 <%if(isLabelChngAppl == true){ %>
			  <td class='label' width='25%'><fmt:message key="eAE.PlaceOfAccident.label" bundle="${ae_labels}"/>/<fmt:message key="eAE.PickupPlace.label" bundle="${ae_labels}"/></td>
			  <%}
			  else if(isPlaceOfOccuurrence == true){
			  %>
			  <td class='LABEL' width='25%' ><fmt:message key="eAE.PlaceOfOccurrence.label" bundle="${ae_labels}"/></td>
			  <%
			  }
			  else{
				%><td class='label' width='25%' ><fmt:message key="eAE.PlaceOfAccident.label" bundle="${ae_labels}"/></td>
				<%} %>
			<%if(isPlaceOfOccuurrence == false){%>
			  <td class='fields' width='25%' tabindex='<%=++tindex%>'><input type='text' name="place_of_accident" id="place_of_accident"  maxLength='30' size='25'  tabindex='' value="<%=place_of_accident%>" onBlur="makeValidString(this)" <%=disPlaceAcci%>></td>
			<%}
			else{	
			%>
			 <td class='fields' width='25%'><select name='place_of_accident' id='place_of_accident' <%=disPlaceAcci%> >
			   <option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------</option> 
                <%  
                  try 
				  {	
				   PreparedStatement pstmtTrans1 = null;
				   ResultSet rsetTrans1 = null;
				   /*Above line commented and below code added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
					sqlFinal = "select PLACE_OCCURRENCE_TYPE_CODE, short_desc from AE_PLACE_OF_OCCURRENCE ##REPDB## where  eff_status='E' order by short_desc";
					sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
					pstmtTrans1 = con.prepareStatement(sqlFinal);
					/*End*/		
				   rsetTrans1 = pstmtTrans1.executeQuery();   
				   while(rsetTrans1!=null && rsetTrans1.next())
					{ 
						 if(rsetTrans1.getString(1).equals(place_of_accident))
							   {
                                    optSelected="selected";				
							   }
							   else
							   {
								   optSelected="";				      
							   }
					  out.println("<option value='"+rsetTrans1.getString("PLACE_OCCURRENCE_TYPE_CODE")+"' "+optSelected+" >"+rsetTrans1.getString("short_desc")+""); 		  
					}
                  if(rsetTrans1!=null) rsetTrans1.close();
				  if(pstmtTrans1!=null) pstmtTrans1.close();
				  }catch(Exception e) {/* out.println("Exception in Place of Occurrence="+e);	 */		e.printStackTrace();}
	            %>
				</select><img src='../../eCommon/images/mandatory.gif' id='placeOfOccurImg' style="visibility:hidden" align='center'><!--Added mandatory image for ML-MMOH-CRF-0648 on 5th Apr 2018 by Thamizh selvi-->
				</td>
			<%}%>
	     </tr>
	     <tr>	
		           <td class='LABEL' width='25%' >
						<!--Added by Thamizh selvi on 29th Mar 2018 against ML-MMOH-CRF-0649 Start-->
						<% if(isMechInjLabelChngAppl){ %>
							<fmt:message key="eAE.MechOfMainInj.label" bundle="${ae_labels}"/>
						<% }else{ %><!--End-->
							<fmt:message key="Common.MechanismofInjury.label" bundle="${common_labels}"/>
						<% } %>
				   </td>
				   <% if(isMechInjLabelChngAppl){ %><!--Added by Thamizh selvi on 29th Mar 2018 against ML-MMOH-CRF-0649-->
  						<td class='fields' width='25%' tabindex='<%=++tindex%>'>
				   <% }else{ %>
						<td class='fields' width='25%' colspan='2' tabindex='<%=++tindex%>'>
				   <% } %>
				   <select name='mechan_injury' id='mechan_injury' onChange='setInjury(this)' <%=dis6%>> 
				    <option value=''>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------
					   <%
					  //if(modify_flag.equals("Y")) {
						 StringBuffer sqlMechaInjury = new StringBuffer();
						 sqlMechaInjury.append("SELECT INJ_CATEGORY_CODE,SHORT_DESC FROM AE_INJURY_CATEGORY_LANG_VW ##REPDB##  WHERE language_id='"+locale+"'  and EFF_STATUS='E' and   oscc_yn=  '"+oscc_yn+"'  ORDER BY 2 ");//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
						 	/*modify_flag is commented and above query is modifed by Rameswar on 04-Oct-16 for GDOH-CRF-0004.2*/

						/*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
						sqlFinal = sqlMechaInjury.toString();
						sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
						/*End*/
						 pstmt = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
					     rset = pstmt.executeQuery();
						 
						 	 optSelected="";
						 while(rset!=null && rset.next())
						   {
							   if(rset.getString("INJ_CATEGORY_CODE").equals(mech_injr_code))
							   {
                                    optSelected="selected";
															
							   }
							   else
								   optSelected="";

                              out.println("<option value='"+rset.getString(1)+"'"+optSelected+">"+rset.getString(2)+" ");
						   }
						 if(pstmt!=null) pstmt.close();
						 if(rset!=null) rset.close();
						 if((sqlMechaInjury != null) && (sqlMechaInjury.length() > 0))
						 {
							sqlMechaInjury.delete(0,sqlMechaInjury.length());
						 }
					  // } 
					   %>  
                 </select><img src='../../eCommon/images/mandatory.gif' id='mand4' style="visibility:hidden" align='center'></img>
				 <% if(!isMechInjLabelChngAppl){ %><!--Added by Thamizh selvi on 29th Mar 2018 against ML-MMOH-CRF-0649-->
					<font  class='label'></font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.and.label" bundle="${common_labels}"/>
				 <% } %>
              </td>
			  <!--Added by Thamizh selvi on 29th Mar 2018 against ML-MMOH-CRF-0649 Start-->
			  <% if(isMechInjLabelChngAppl){ %>
				<td class='LABEL' width='25%'><fmt:message key="eAE.MechaofSubInjury.label" bundle="${ae_labels}"/></td>
			  <% } %><!--End-->
  		      <input type='hidden' name='mech_sub_code' id='mech_sub_code' value=<%=mech_injury_subcatg_code%> >
			 <td class='fields' width='25%' tabindex='<%=++tindex%>'>
				<select name='injury' id='injury' tabindex='68' <%=dis7%>>
				  <option value=''>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------
				</select><img src='../../eCommon/images/mandatory.gif' id='mand5' style="visibility:hidden" align='center'></img>
              </td> 
	  </tr>
	  <% if(isCaseDtlsRadioBtnAppl){ %>
	  </tbody>
	  <% } %>
	  <tr>	
		      <td class='LABEL' width='25%' ><fmt:message key="Common.VehiclesInvolved.label" bundle="${common_labels}"/></td>
  		      <td class='fields' width='25%' colspan='2' tabindex='<%=++tindex%>'>
				 <select name='vehicle_invol' id='vehicle_invol' <%=dis8%>>
				  <option value='' >--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------
					   <%
						 StringBuffer sqlVehicleInv = new StringBuffer();
						 sqlVehicleInv.append("select ARRIVAL_CODE, SHORT_DESC ARRIVAL_SHORT_DESC from am_arrival_lang_vw ##REPDB## where language_id='"+locale+"'  and EFF_STATUS='E' and facility_id='"+facilityId+"' and ARRIVAL_CODE like '%%' order by 2");//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
						 /*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
						sqlFinal = sqlVehicleInv.toString();
						sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
						/*End*/
						 pstmt = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
					     rset = pstmt.executeQuery();
						 
						 optSelected="";
						 while(rset!=null && rset.next())
						   {
							   if(rset.getString(1).equals(vehicle_invlovedcode))
							   {
                                    optSelected="selected";										
							   }
							   else
								   optSelected="";
                              out.println("<option value='"+rset.getString(1)+"'"+optSelected+">"+rset.getString(2)+" ");
						   }
						 if(pstmt!=null) pstmt.close();
						 if(rset!=null) rset.close();
					   %>
                 </select><font  class='label'></font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				 <fmt:message key="Common.and.label" bundle="${common_labels}"/>
              </td>
			  <td class='fields' width='25%' tabindex='<%=++tindex%>'>
				<select name='vehicle_invol1' id='vehicle_invol1' tabindex='68' <%=dis9%>>
				  <option value=''>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------
				<%
						 pstmt = con.prepareStatement(sqlFinal);
					     rset = pstmt.executeQuery();
						  
						 optSelected="";
						 while(rset!=null && rset.next())
						   {
							   if(rset.getString(1).equals(vehicle_invlovedcode1))
							   {
                                    optSelected="selected";										
							   }
							   else
								   optSelected="";
                              out.println("<option value='"+rset.getString(1)+"'"+optSelected+">"+rset.getString(2)+" ");
						   }
						 if(pstmt!=null) pstmt.close();
						 if(rset!=null) rset.close();
						 if((sqlVehicleInv != null) && (sqlVehicleInv.length() > 0))
						 {
							sqlVehicleInv.delete(0,sqlVehicleInv.length());
						 }
					   %>
				</select>
              </td> 			   
	   </tr>
<!--Added by Ashwini on 04-Apr-2017 for GDOH-CFR-0004.3-->
	<tr>
	 <td class='LABEL' width='25%' ><fmt:message key="eAE.VehicleRegNo.label" bundle="${ae_labels}"/></td>
		<td class='fields' width='25%' colspan='2' >
			<input type='text' name="Vehicle_Reg_No1" id="Vehicle_Reg_No1"  maxLength='15' size='20' value="<%=Vehicle_Reg_No1%>" onKeyPress="return SpCharChkForMotorVecRegNo(event);" <%=dis8%>> <font  class='label'></font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.and.label" bundle="${common_labels}"/> 
		</td>
		<td class='fields' width='25%'>
			<input type='text' name="Vehicle_Reg_No2" id="Vehicle_Reg_No2"  maxLength='15' size='20' value="<%=Vehicle_Reg_No2%>" onKeyPress="return SpCharChkForMotorVecRegNo(event);" <%=dis8%>>
		</td>
	</tr>
	   <tr>	
		      <td class='LABEL' width='25%' ><fmt:message key="Common.ProtectiveDeviceUsed.label" bundle="${common_labels}"/></td>
  		      <td class='fields' width='25%' tabindex='<%=++tindex%>'>
				 <select name='protective_device' id='protective_device' <%=dis10%>>
				   <option value=''>---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------
			   <%
			   StringBuffer sqlProtect = new StringBuffer();
			  // sqlProtect.append("SELECT PROTECTIVE_DEVICE_CODE, SHORT_DESC FROM  AE_PROTECTIVE_DEVICE_LANG_VW WHERE language_id='"+locale+"'  and EFF_STATUS ='E' ORDER BY 2");
			   sqlProtect.append("SELECT PROTECTIVE_DEVICE_CODE, SHORT_DESC FROM  AE_PROTECTIVE_DEVICE_LANG_VW ##REPDB## WHERE language_id='"+locale+"'  and EFF_STATUS ='E' and PROTECTIVE_DEVICE_CODE like '%%' ORDER BY 2");//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
			   /*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
				sqlFinal = sqlProtect.toString();
				sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
				/*End*/
			   pstmt = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
			   rset = pstmt.executeQuery();    
			   optSelected="";
			   while(rset!=null && rset.next())
			   {
					if(rset.getString(1).equals(protective_device_code))
				   {
						optSelected="selected";									
				   }
				   else
					   optSelected=""; 
				  out.println("<option value='"+rset.getString(1)+"'"+optSelected+">"+rset.getString(2)+" ");
			   }
			   if(pstmt!=null) pstmt.close();
			   if(rset!=null) rset.close();
			   if((sqlProtect != null) && (sqlProtect.length() > 0))
				 {
					sqlProtect.delete(0,sqlProtect.length());
				 }
			   %>
                 </select>
               </td>
			   <td class='LABEL' width='25%' ><fmt:message key="Common.PositionDuringIncident.label" bundle="${common_labels}"/>
               </td>
			   <td class='fields' width='25%' tabindex='<%=++tindex%>'>
				   <select name='affected_site' id='affected_site' tabindex='' <%=dis11%>>
				   <option value=''>---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------
					   <%
						   pstmt = con.prepareStatement(PositionSql);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
					       rset = pstmt.executeQuery();
						   
						   optSelected="";
						   while(rset!=null && rset.next())
						   {
							  if(rset.getString(1).equals(pat_position_code))
							   {
                                    optSelected="selected";								
							   }
							   else
								   optSelected="";
                              out.println("<option value='"+rset.getString(1)+"'"+optSelected+">"+rset.getString(2)+" ");
						   }
						   if(pstmt!=null) pstmt.close();
						   if(rset!=null) rset.close();
						   if((sqlPosition != null) && (sqlPosition.length() > 0))
							{
								sqlPosition.delete(0,sqlPosition.length());
							}
					   %>
                 </select>
              </td>
	  </tr> 
	 <tr><!-- below line(s) modified by VenkateshS against ML-MMOH-CRF-0354 [IN057191] -->
	         <%if(siteSpecific){%>
			  <td class='COLUMNHEADER' colspan='4' ><fmt:message key="Common.MedicalLegalCase.label" bundle="${common_labels}"/> <fmt:message key="Common.details.label" bundle="${common_labels}"/></td>
			 <%}else {%>
		    <td class='COLUMNHEADER' colspan='4' ><fmt:message key="Common.mlcdetails.label" bundle="${common_labels}"/></td>
			<%}%>
	 </tr>
	 <tr>	 <%if(siteSpecific){%>
	          <td class='label' width='25%'><fmt:message key="Common.MedicalLegalCase.label" bundle="${common_labels}"/></td>
	           <%}else{%>
		      <td class='label' width='25%'><fmt:message key="Common.mlc.label" bundle="${common_labels}"/></td>
               <%}%>
			   <!--end ML-MMOH-CRF-0354 [IN057191 -->
		     <td class='fields' width='25%' tabindex='<%=++tindex%>'><input type='checkbox'  name="mlc_case_yn" id="mlc_case_yn"  onclick='chkMlcValue(this)' <%=checked3%>   <%=disMLC%>></td>
             <% if(isMLCAppl){ %>
             <td class='LABEL' width='25%' ><fmt:message key="Common.MlcDeath.label" bundle="${common_labels}"/></td>
					<td class='fields' width='25%'><input type="checkbox" name='mlc_death' id='mlc_death' value='<%=MLC_DEATH_YN %>' onclick='updateSelf(this)' <%=disMLCDeath %> <%=MLC_DEATH_YN.equals("Y")?" Checked ":"" %> ></td></td>
             <%}else{ %>
             <td class='LABEL' width='25%' colspan='2'>&nbsp;</td>
             <% }%>
      </tr> 
	  <tr>
	          <td class='label' width='25%'><fmt:message key="Common.PoliceReportNo.label" bundle="${common_labels}"/></td>
  		      <td class='fields' width='25%' tabindex='<%=++tindex%>'>
			  <input type='text'  name='police_rep_no1' id='police_rep_no1'   maxLength='<%=pol_rep_no_mx_size %>' <% if(isMLCAppl){ %> onpaste="maxLengthPaste(this, '100')" <%} %> size='15' tabindex='' value="<%=police_rep_no%>"  <%=dis12%>></td>
			  <td class='label' width='25%'><fmt:message key="Common.PoliceStationDetails.label" bundle="${common_labels}"/></td>
			  <td class='fields' width='25%' tabindex='<%=++tindex%>'><input type='text' name="police_stat_detail" id="police_stat_detail"  maxLength='<%=pol_stn_det_mx_size %>' <% if(isMLCAppl){ %> onpaste="maxLengthPaste(this, '100')" <%} %> size='25' tabindex='' value='<%=police_station_dtls%>'  <%=dis13%>></td>
	  </tr>
	  <!-- Added by Ajay Hatwate for GHL-CRF-0650  -->
	  <% if(isMLCAppl){ %>
	   <tr>
		<td class='LABEL' width='25%' ><fmt:message key="Common.OutMlcNoDtls.label" bundle="${common_labels}"/></td>
					<td class='fields' width='25%'><input type='text' name="outside_mlc_dtls" id="outside_mlc_dtls" value='<%=MLC_NO_OUTSIDE_DTLS %>' maxlength='100' onpaste="maxLengthPaste(this, '100')" <%=disOutMLCDet %> ></td></td>	
		<td class='LABEL' width='25%' ><fmt:message key="Common.DateOfMlcCapture.label" bundle="${common_labels}"/></td>
					<td class='fields' width='25%'>
					<input type='text'  id='dateofmlccapture' name="date_of_mlc_capture" id="date_of_mlc_capture" onBlur="validateMlcCapture(this)" maxLength='19' size='19' value='<%=MLC_CAPTURE_DATE %>' <%=disDateOfCapt %>><img src="../../eCommon/images/CommonCalendar.gif"  onClick="return showCalendar('dateofmlccapture','dd/mm/yyyy' ,'hh:mm:ss',null );" style='cursor:pointer'></img>
					</td></td>				
	</tr>
	<tr>
		<td class='LABEL' width='25%' ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
					<td class='fields' width='25%'>
					<textarea name='mlc_remarks' rows=3 maxlength=12 cols=45 onKeyPress="checkMaxLimit(this, 500)" onpaste="maxLengthPaste(this, '500')" <%=disMLCRemark %>><%=MLC_REMARKS%></textarea>
					</td></td>				
	</tr>
	  <%} %>
	  <!-- End of GHL-CRF-0650  -->
     <tr><td colspan=4 class=label height=5></td></tr>
  </table>
</div>
	<div id='Others' style = 'display:none' >
	 <table cellspacing='0' cellpadding='0' width='100%' border=0 align='center'>
            <tr><td class='white'>

		<ul id="tablist" class="tablist" >
			<li class="tablistitem" title="Triage Details">
				<a  class="tabClicked" id='Triage_Details_tab' >
					<span class="tabSpanclicked" onClick='javascript:expandCollapse("Triage_Details_tab")' id="Triage_tabspan"><fmt:message key="Common.TriageDetails.label" bundle="${common_labels}"/></span>
				</a>
			</li>
			<%if(ca_install_yn.equals("Y")){%>
			<li class="tablistitem" title="Assessment">
				<a class="tabA" id='Assessment_tab' >
					<span class="tabAspan" onClick='javascript:expandCollapse("Assessment_tab")' id="assess_tabspan"><fmt:message key="Common.Assessment.label" bundle="${common_labels}"/></span>
				</a>
			</li>
			<%}%> 
		</ul>
    </td></tr>
    </table>
	<table cellspacing='0' cellpadding='0' width='100%' border=0 align='center'>
      <tr><td class='white'>
			<ul id="tablist" class="tablist">
				<li class="tablistitem" title="Condition / Case">
					<a  class="tabA" id="Condition_tab" >
						<span class="tabAspan" onClick='javascript:expandCollapse("Condition_tab")' id="patCond_tabspan"><fmt:message key="eAE.ConditionCase.label" bundle="${ae_labels}"/></span>
					</a>
				</li>
				<!--Added by Thamizh selvi on 10th Apr 2018 against ML-MMOH-CRF-0655 Start-->
				<% if(isChngBtnPositionAppl){ %>
				<li class="tablistitem" title="Allergy Details">
					<a  class="tabA" id="allergy_dtls" >
						<span class="tabAspan" onClick='javascript:expandCollapse("allergy_dtls")' id="allergyDtls_tabspan"><fmt:message key="Common.AllergyDetails.label" bundle="${common_labels}"/></span>
					</a>
				</li>
				<% } %><!--End-->
				<li class="tablistitem" title="Others">
					<a class="tabClicked" id="others_tab" >
						<span class="tabSpanclicked" onClick='javascript:expandCollapse("others_tab")' id="others_tabspan"><fmt:message key="Common.others.label" bundle="${common_labels}"/></span>
					</a>
				</li>
			</ul>
       </td></tr>
</table>
<!--Added by k v shanmukh on 2nd-Apr-2018 against ML-MMOH-CRF-0656 Start-->
<%if(isSecTrgBackDateTimeAppl){%>
<table border="0" cellpadding="2" cellspacing="0" align='center' width='100%'>
	<tr>
		<td class='LABEL'   width='25%' ><fmt:message key="eAE.Triage.label" bundle="${common_labels}"/> <fmt:message key="Common.datetime.label" bundle="${common_labels}"/></td> 
		<% if(display_triage_record_date_time.equals("")){%>
			<td class='fields' width='34%' tabindex='<%=++tindex%>'>
			<input type='text'  id='other_triage_record_date_time' name='triage_record_date_time' id='triage_record_date_time' value="<%=sys_date_time%>" maxLength='19' size='16' tabindex=''onBlur='triageRecordDate(this);'<%=dis_triage_record_date_time%>>
			<img src="../../eCommon/images/CommonCalendar.gif"  onClick="return showCalendar('other_triage_record_date_time', null, 'hh:mm:ss' );" style='cursor:pointer'   /> <img src='../../eCommon/images/mandatory.gif' ></img>
			</td>
		<%}else {%>
			<td class='fields' width='34%' tabindex='<%=++tindex%>'>
			 <input type='text'  id='other_triage_record_date_time' name='triage_record_date_time' id='triage_record_date_time' value="<%=display_triage_record_date_time%>" maxLength='19' size='16' tabindex='' <%=dis_triage_record_date_time%>>
			</td>
		<%}%>
		<!--Added by Thamizh selvi on 9th Apr 2018 against ML-MMOH-CRF-0655 Start-->
		<% if(isChngBtnPositionAppl){ %>
			<td class='fields' width='20%' tabindex='<%=++tindex%>'>
				<input type="button" name="visit_24hr" id="visit_24hr" class="BUTTON" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.VisitWithin24Hrs.label","ae_labels")%>' onClick="showLastVisitDetails('LastVisit24');" <%=VisitProp%>>
			</td>
			<td class='fields' width='21%' tabindex='<%=++tindex%>'>
				<input type="button" name="PrevEncounter" id="PrevEncounter" class="BUTTON" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PreviousEncounters.label","common_labels")%>' onClick="showPrevEncounter();"  <%=EncounterProp%> >
			</td>
		<% } %>
		<!--End-->
	</tr>
</table>
<%}else if(isChngBtnPositionAppl){ %><!--Added by Thamizh selvi on 9th Apr 2018 against ML-MMOH-CRF-0655 Start-->
<table border="0" cellpadding="2" cellspacing="0" align='center' width='100%'>
	<tr>
		<td colspan='2'>&nbsp;</td>
		<td class='fields' width='15%' tabindex='<%=++tindex%>'>
			<input type="button" name="visit_24hr" id="visit_24hr" class="BUTTON" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.VisitWithin24Hrs.label","ae_labels")%>' onClick="showLastVisitDetails('LastVisit24');" <%=VisitProp%>>
		</td>
		<td class='fields' width='15%' tabindex='<%=++tindex%>'>
			<input type="button" name="PrevEncounter" id="PrevEncounter" class="BUTTON" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PreviousEncounters.label","common_labels")%>' onClick="showPrevEncounter();"  <%=EncounterProp%> >
		</td>
	</tr>
</table>
<% } %>
<!--End-->	
 <table border="0" cellpadding="3" cellspacing="0" align='center' colspan=8 width="100%">
	 <tr>
			<!--Added by Thamizh selvi on 12th Apr 2018 against ML-MMOH-CRF-0651 Start-->
			<% if(isOrderCatalogChngAppl && !initialMgmtLblName.trim().equals("")){ %>
				<td class='COLUMNHEADER' colspan='4' ><%=initialMgmtLblName%></td>
			<% }else{ %><!--End-->
				<td class='COLUMNHEADER' colspan='4' ><fmt:message key="eAE.InitialManagement.label" bundle="${ae_labels}"/></td>
			<% } %>
	 </tr>
	<%if(ca_install_yn.equals("Y")){
	if (order_catalog_code3.equals("")){ FBCProp		  ="disabled";}
    try
	 {	
				   StringBuffer sqlECG1 = new StringBuffer();
				   StringBuffer sqlECG3 = new StringBuffer();
				   StringBuffer sqlECG4 = new StringBuffer();
				   StringBuffer sqlECG5 = new StringBuffer();
				   StringBuffer sqlOrderCatalog6 = new StringBuffer();//Added by Thamizh selvi on 12th Apr 2018 against ML-MMOH-CRF-0651
				   sqlECG1.append("select count(*)  from or_order ##REPDB## a, or_order_line ##REPDB## b  where a.ORDERING_FACILITY_ID='"+facilityId+"' and a.patient_id='"+patient_id+"' and  a.ENCOUNTER_ID='"+encounter_id+"' and a.order_id=b.order_id  ");//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
				   sqlECG3.append(sqlECG1);
				   sqlECG4.append(sqlECG1);
				   sqlECG5.append(sqlECG1);
				   sqlOrderCatalog6.append(sqlECG1);//Added by Thamizh selvi on 12th Apr 2018 against ML-MMOH-CRF-0651
				   StringBuffer s1 = new StringBuffer();
				   StringBuffer s3 = new StringBuffer();
				   StringBuffer s4 = new StringBuffer();
				   StringBuffer s5 = new StringBuffer();
				   StringBuffer s6 = new StringBuffer();//Added by Thamizh selvi on 12th Apr 2018 against ML-MMOH-CRF-0651
				   s1.append(" and b.ORDER_CATALOG_CODE='"+order_catalog_code2+"'");
				   s3.append(" and b.ORDER_CATALOG_CODE='"+order_catalog_code4+"'");
				   s4.append(" and b.ORDER_CATALOG_CODE='"+order_catalog_code1+"'");
				   s5.append(" and b.ORDER_CATALOG_CODE='"+order_catalog_code5+"'");
				   s6.append(" and b.ORDER_CATALOG_CODE='"+order_catalog_code6+"'");//Added by Thamizh selvi on 12th Apr 2018 against ML-MMOH-CRF-0651
				   /*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
				   sqlFinal = sqlECG1.append(s1).toString();
				   sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
				   /*End*/
				   pstmtEncounter = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
				   rsetEncounter = pstmtEncounter.executeQuery();
				   while(rsetEncounter!=null && rsetEncounter.next())
					 {
						      countECG=rsetEncounter.getInt(1);
					 }
				  if(rsetEncounter!=null){ rsetEncounter.close(); rsetEncounter=null; }
				  if(pstmtEncounter!=null){ pstmtEncounter.close(); pstmtEncounter=null; }

					  if (countECG>0)
					  {
						  ECGProp = "checked";
					  }else
					  {
						  ECGProp ="";
					  }
				   /*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
				   sqlFinal = sqlECG3.append(s3).toString();
				   sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
				   /*End*/
				   pstmtEncounter = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
				   rsetEncounter = pstmtEncounter.executeQuery();
				   while(rsetEncounter!=null && rsetEncounter.next())
					 {
						      countDerss=rsetEncounter.getInt(1);
					 }
				  if(rsetEncounter!=null){ rsetEncounter.close(); rsetEncounter=null; }
				  if(pstmtEncounter!=null){ pstmtEncounter.close(); pstmtEncounter=null; }
					  if (countDerss>0)
					  {
						  DressProp = "checked";
					  }else
					  {
						  DressProp ="";
					  }
				   /*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
				   sqlFinal = sqlECG4.append(s4).toString();
				   sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
				   /*End*/
				   pstmtEncounter = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
				   rsetEncounter = pstmtEncounter.executeQuery();
				   while(rsetEncounter!=null && rsetEncounter.next())
					 {
						      countSpO2=rsetEncounter.getInt(1);
					 }
				  if(rsetEncounter!=null){ rsetEncounter.close(); rsetEncounter=null; }
				  if(pstmtEncounter!=null){ pstmtEncounter.close(); pstmtEncounter=null; }
					  if (countSpO2>0)
					  {
						  SpO2Prop = "checked";
					  }else
					  {
						  SpO2Prop ="";
					  }
					/*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
				   sqlFinal = sqlECG5.append(s5).toString();
				   sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
				   /*End*/
				   pstmtEncounter = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
				   rsetEncounter = pstmtEncounter.executeQuery();
				   while(rsetEncounter!=null && rsetEncounter.next())
					 {
						      countCapBlood=rsetEncounter.getInt(1);
					 }
				  if(rsetEncounter!=null){ rsetEncounter.close(); rsetEncounter=null; }
				  if(pstmtEncounter!=null){ pstmtEncounter.close(); pstmtEncounter=null; }
					  if (countCapBlood>0)
					  {
						  capBloodSugProp = "checked";
					  }else
					  {
						  capBloodSugProp ="";
					  }
				/*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
				sqlFinal = sqlOrderCatalog6.append(s6).toString();
				sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
				/*End*/
				/*Added by Thamizh selvi on 12th Apr 2018 against ML-MMOH-CRF-0651 Start*/
				pstmtEncounter = con.prepareStatement(sqlFinal);
				rsetEncounter = pstmtEncounter.executeQuery();
				while(rsetEncounter!=null && rsetEncounter.next()){
				      countCBD = rsetEncounter.getInt(1);
				}
		  	    if(rsetEncounter!=null){ rsetEncounter.close(); rsetEncounter=null; }
				if(pstmtEncounter!=null){ pstmtEncounter.close(); pstmtEncounter=null; }
				if (countCBD > 0){
					cbdProp = "checked";
				}else{
					cbdProp ="";
				}/*End*/
	}catch(Exception e) {e.printStackTrace();}
  %>
	 <tr><td colspan=4 class=label height=5></td></tr>
    <tr >
		<!--Added by Thamizh selvi on 12th Apr 2018 against ML-MMOH-CRF-0651 Start-->
		<% if(isOrderCatalogChngAppl){ %>
				<td class='LABEL'   width='25%' >
					<fmt:message key="eAE.CBD.label" bundle="${ae_labels}"/>
				</td>
				<td class='fields' width='25%' tabindex='<%=++tindex%>'>
					<input type="checkbox" name='cbd' id='cbd' <%=cbdProp%>  disabled>
				</td>
				<td class='LABEL'   width='25%' >
					<fmt:message key="Common.Medication.label" bundle="${ae_labels}"/>
				</td>
				<td class='fields' width='25%' tabindex='<%=++tindex%>'> 
					<input type=text  name='medication' id='medication'  onKeyPress="return CheckSpecCharOnKeyPress(event)" onPaste = "return false;" value="<%=medication%>" size="30" maxlength="30" <%=disMedication%> >
				</td>
		<% }else{ %><!--End-->
			 <td class='LABEL'   width='25%' ><fmt:message key="eAE.CapBloodSugar.label" bundle="${ae_labels}"/></td>
			 <td class='fields' width='25%' tabindex='<%=++tindex%>'><input type="checkbox" name='cap_bloodSugar' id='cap_bloodSugar'  <%=capBloodSugProp%>  disabled>
			 <td class='LABEL'   width='25%' ><fmt:message key="eAE.SpO2.label" bundle="${ae_labels}"/></td>
			 <td class='fields' width='25%' tabindex='<%=++tindex%>'> 
			  <input type="checkbox" name='spo2' id='spo2'   <%=SpO2Prop%> disabled >
			 </td>
		<% } %>
	</tr>
	 <tr>
	     <td class='LABEL'   width='25%' >		 
		 <fmt:message key="eAE.FBC.label" bundle="${ae_labels}"/></td>
		 <td class='fields' width='25%' tabindex='<%=++tindex%>'> 
		 <input type="checkbox" name='fbc' id='fbc' onClick='chkOrderCat3(this);' <%=FBCProp%> <%=fbccheck%> value="<%=fbccheck_val%>">
		 </td>
		 <td class='LABEL'   width='25%' ><fmt:message key="Common.ecg.label" bundle="${common_labels}"/></td>
		 <td class='fields' width='25%' tabindex='<%=++tindex%>'> 
		 <input type="checkbox" name='ecg' id='ecg' <%=ECGProp%> disabled> 
         </td>
	 </tr>
	 <tr>
		<!--Added by Thamizh selvi on 12th Apr 2018 against ML-MMOH-CRF-0651 Start-->
		<% if(isOrderCatalogChngAppl){ %>
			 <td class='label' width='25%'>
				<% if(!dressingLblName.trim().equals("")){ %>
					<%=dressingLblName%>
				<% }else{%>
					<fmt:message key="Common.Compression.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Dressing.label" bundle="${common_labels}"/>
				<% } %>
				</td>
			 <td class='fields' width='25%' tabindex='<%=++tindex%>'> 
				<input type="checkbox" name='dressing' id='dressing'   <%=DressProp%> disabled>
			 </td>
			 <td class='label' width='25%'>
				<fmt:message key="Common.others.label" bundle="${common_labels}"/>
			 </td>
			 <td class='fields' width='25%' tabindex='<%=++tindex%>'> 
				<input type=text  name='initial_mgmt_others' id='initial_mgmt_others'  onKeyPress="return CheckSpecCharOnKeyPress(event)" onPaste = "return false;" value="<%=intialMgmtOthers%>" size="30" maxlength="30" <%=disIntialMgmtOthers%> >
			 </td>
		<% }else{ %><!--End-->
			 <td class='label' width='25%'><fmt:message key="Common.Dressing.label" bundle="${common_labels}"/>
			 <td class='fields' width='25%' tabindex='<%=++tindex%>'> 
			  <input type="checkbox" name='dressing' id='dressing'   <%=DressProp%> disabled>
			 </td>
			 <td class='LABEL' colspan=2>&nbsp;</td>
		<% } %>
	 </tr>
    <%}%>
	 <tr>
  		 <td class='LABEL' width='25%'><fmt:message key="eAE.Immobilization.label" bundle="${ae_labels}"/></td>
         <td class='fields' colspan='2' tabindex='<%=++tindex%>'>
				 <select name='immobilization' id='immobilization' onChange='' <%=disImmobil%> >
					<Option value=''>&nbsp;------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----&nbsp;</Option>
					 <%
			          try{
			               StringBuffer sqlImmob = new StringBuffer();
                           sqlImmob.append("select immobilization_code,short_desc from ae_immobilization_lang_vw ##REPDB## where language_id='"+locale+"' and eff_status='E'");//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
						   /*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
						   sqlFinal = sqlImmob.toString();
						   sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
						   /*End*/
			               pstmt=con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
						   rset = pstmt.executeQuery();
						   while(rset!=null && rset.next())
						   {
							   if(rset.getString(1).equals(immobilization))
							   {
                                    optSelected="selected";
							   }
							   else
								   optSelected="";

							    out.println( "<option value='"+rset.getString(1)+"'"+optSelected+">"+rset.getString(2)+""); 
						   }
						   if(rset!=null) rset.close();
						   if(pstmt!=null) pstmt.close();
						   if((sqlImmob != null) && (sqlImmob.length() > 0))
							 {
								sqlImmob.delete(0,sqlImmob.length());
							 }
						  }catch(Exception e){e.printStackTrace();}
                 %>
                 </select> 
         </td>
		 <td colspan=2 class='LABEL' >&nbsp;</td>  
  </tr>
 <tr><td colspan=4 class=label height=5></td></tr>
  <tr>
		<td class='COLUMNHEADER' colspan='4' ><fmt:message key="Common.ATTImmunizationDetails.label" bundle="${common_labels}"/></td>
  </tr>
 <tr><td colspan=4 class=label height=5></td></tr>
  <tr>				 
		      <td class='LABEL' ><fmt:message key="Common.ImmunizationStatus.label" bundle="${common_labels}"/></td>
  		      <td class='fields' width='25%' tabindex='<%=++tindex%>'>
				 <select name='immunization_stat' id='immunization_stat' onChange='' <%=dis14%>>
					       <Option value=''>-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</Option>
                           <Option value='F'<%=selected%> ><fmt:message key="Common.FullyImmunized.label" bundle="${common_labels}"/></option>
                           <Option value='P'<%=selected1%>  ><fmt:message key="Common.PartiallyImmunized.label" bundle="${common_labels}"/></option>
                           <Option value='U'<%=selected2%>  ><fmt:message key="Common.unknown.label" bundle="${common_labels}"/></option>
				 </select>
              </td>
  		      <td class='LABEL'  width='25%'><fmt:message key="Common.ATTGiven.label" bundle="${common_labels}"/></td>
		      <td class='fields' width='25%' tabindex='<%=++tindex%>'><input type='checkbox'  name="att_given" id="att_given"   value='' <%=checked4%> <%=dis15%> onblur="agecheck(this,'<%=ca_install_yn%>','<%=patient_age%>','<%=max_age_paediatric%>','<%=min_age_pregnancy%>','<%=sex%>');">
			  </td>
	 </tr>
	 <tr><td colspan=4 class=label height=5></td></tr>
	 </table>
		<% if (patient_age <= max_age_paediatric){
				   pediatric_status = "true";	%>

		<table  border="0" cellpadding="3" cellspacing="0" align='center' colspan=12 width="100%">
	    <tr>
		    <td class='COLUMNHEADER' colspan='8' ><fmt:message key="Common.PediatricDetail.label" bundle="${common_labels}"/></td>
	   </tr>
	 <tr><td colspan=4 class=label height=5></td></tr>
	   <tr>	
         <td class='LABEL'  width="25%" ><fmt:message key="Common.Growth/DevelMilestoneAge.label" bundle="${common_labels}"/></td>
  		 <td class='fields'  width="25%" tabindex='<%=++tindex%>'><input type='checkbox'  name="growth_age" id="growth_age"  <%=checked5%> onclick='chkhwc(event);' <%=disabled991%> <%=disabled99%>></td>
		 <td class='LABEL' width="25%"><fmt:message key="Common.Immunizationuptodate.label" bundle="${common_labels}"/></td>
		 <td class='fields'  width="25%" tabindex='<%=++tindex%>'>
		 <input type='checkbox' align='left' name="immun_date" id="immun_date"    <%=checked6%> <%=disImm%> >
         </td>
     </tr>
     <tr>
 		 <td class='LABEL' width="25%"><fmt:message key="Common.Menarche.label" bundle="${common_labels}"/></td>
		 <td  class='fields'  width="25%" tabindex='<%=++tindex%>'><input type='checkbox'  name="menarche" id="menarche"    onclick='checkmenstrual(this);' <%=checked7%> <%=disMenarche%>></td>
		 <td class='LABEL' ><fmt:message key="Common.height.label" bundle="${common_labels}"/></td>
  		 <td class='fields' tabindex='<%=++tindex%>'><input type='text'  name="height" id="height" <%=disHeight%> id='height'size="5" maxlength='6' value="<%=height%>"onKeyPress='return( allowValidNumber(this,event,3,2)); return(ChkNumberInput(this,event,0)); '
		 onBlur='SPCheckPositiveNumber(this);'>&nbsp;<fmt:message key="Common.cm.label" bundle="${common_labels}"/></td>    
	   </tr>
       <tr>	
		 <td class='LABEL' ><fmt:message key="Common.weight.label" bundle="${common_labels}"/></td>
  		 <td class='fields' tabindex='<%=++tindex%>'><input type='text'  name="weight" id="weight" size="5" maxlength='7' value="<%=weight%>" onKeyPress='return( allowValidNumber(this,event,2,3));return(ChkNumberInput(this,event,0))'
		 onBlur='SPCheckPositiveNumber(this);'<%=disWeight%>>&nbsp;<fmt:message key="Common.kg.label" bundle="${common_labels}"/></td>
 		 <td class='LABEL' ><fmt:message key="Common.Circumference.label" bundle="${common_labels}"/></td>
  		 <td class='fields' tabindex='<%=++tindex%>'><input type='text'  name="circumference" id="circumference" size="5" maxlength='6'value="<%=circumference%>"onKeyPress='return( allowValidNumber(this,event,3,2));return(ChkNumberInput(this,event,0))'onBlur="SPCheckPositiveNumber(this);if(this.readOnly==false)agecheck(this,'<%=ca_install_yn%>','<%=patient_age%>','<%=max_age_paediatric%>','<%=min_age_pregnancy%>','<%=sex%>');"<%=disCir%>>&nbsp;&nbsp;<fmt:message key="Common.cm.label" bundle="${common_labels}"/></td>
	  </tr> 
	 <tr><td colspan=4 class=label height=5></td></tr>
 </table>
 <% } else{	
			  disabled="";
		 }%>
 <%
 
 //ML-MMOH-CRF-1759.1 end
 if(latestMensDtlStatus.equals("A") && modify_flag.equals("N")){		
 	   pstmt1 = con.prepareStatement("SELECT * FROM (SELECT event_status, TO_CHAR(last_menstrual_period, 'DD/MM/YYYY') AS last_menstrual_period, gestation_poa_weeks, gestation_poa_days, TO_CHAR(unsure_of_date, 'DD/MM/YYYY') AS unsure_of_date, gestation_pog_weeks, gestation_pog_days, TO_CHAR(edd, 'DD/MM/YYYY') AS edd, TO_CHAR(redd, 'DD/MM/YYYY') AS redd FROM ca_mens_his_trans_dtl WHERE patient_id =? AND event_status =? ORDER BY added_date DESC) WHERE ROWNUM = 1");
 	   pstmt1.setString(1, patient_id);
 	   pstmt1.setString(2, latestMensDtlStatus);

 	   rset1 = pstmt1.executeQuery();
 	   if (rset1.next()){
 		   lastMensPeriod = rset1.getString("LAST_MENSTRUAL_PERIOD")==null?"":rset1.getString("LAST_MENSTRUAL_PERIOD");
 		   lastPeriodWeeks = rset1.getString("GESTATION_POA_WEEKS")==null?"":rset1.getString("GESTATION_POA_WEEKS");
 		   lastPeriodDays = rset1.getString("GESTATION_POA_DAYS")==null?"":rset1.getString("GESTATION_POA_DAYS");
 		   unsureDatePeriod = rset1.getString("UNSURE_OF_DATE")==null?"":rset1.getString("UNSURE_OF_DATE");
 		   unsureDateWeeks = rset1.getString("GESTATION_POG_WEEKS")==null?"":rset1.getString("GESTATION_POG_WEEKS");
 		   unsureDateDays = rset1.getString("GESTATION_POG_DAYS")==null?"":rset1.getString("GESTATION_POG_DAYS");
 		   lastPeriodEdd = rset1.getString("EDD")==null?"":rset1.getString("EDD");
 		   unsureRedd = rset1.getString("REDD")==null?"":rset1.getString("REDD");

 		   if(!lastMensPeriod.equals(""))
 		   {
 			   CALmpDate=lastMensPeriod;
 		   }
 		   else
 		   {
 			   CALmpDate=unsureDatePeriod;
 		   }
 		   
 		   
 		   if(!lastPeriodWeeks.equals(""))
 		   {
 			   CAWeeks=lastPeriodWeeks;
 		   }
 		   else
 		   {
 			   CAWeeks=unsureDateWeeks;
 		   }
 		   
 		   if(!lastPeriodDays.equals(""))
 		   {
 			   CADays=lastPeriodDays;
 		   }
 		   else
 		   {
 			   CADays=unsureDateDays;
 		   }
 		   
 		   if(!lastPeriodEdd.equals(""))
 		   {
 			   CAEdd=lastPeriodEdd;

 		   }
 		   else
 		   {
 			   CAEdd=unsureRedd;
 		   }
 	   }
 	   if(pstmt1!=null) pstmt1.close();
 	   if(rset1!=null) rset1.close();	
 	}
 else if("Y".equals(invokeMenstrualHistYN) && modify_flag.equals("N")){
	 
	  pstmt1 = con.prepareStatement("SELECT PREGNANT_YN FROM AE_PAT_EMERGENCY_DETAIL WHERE ENCOUNTER_ID = ? AND RECORDED_DATE = (SELECT MAX(RECORDED_DATE) FROM AE_PAT_EMERGENCY_DETAIL WHERE ENCOUNTER_ID =?)");
	 	 pstmt1.setString(1, encounter_id);
	 	 pstmt1.setString(2, encounter_id);
	 	  rset1 = pstmt1.executeQuery();
			    if (rset1.next()){
			    	exisitng_pregency_yn= rset1.getString("PREGNANT_YN");
			    	if(exisitng_pregency_yn.equals("Y"))
			    	{
			    		checked8 = "checked";
			    	}
			    }
			    if(pstmt1!=null) pstmt1.close();
			    if(rset1!=null) rset1.close();	
				 CALmpDate=lmpdate1;
 }

			pstmt = con.prepareStatement("SELECT CASE WHEN COUNT(patient_id) = 1 AND MAX(EVENT_STATUS) = 'E' THEN 0 ELSE COUNT(patient_id) END AS p_count FROM ca_mens_his_trans_dtl WHERE patient_id = ?");
			pstmt.setString(1,patient_id);
			rset1 = pstmt.executeQuery();
			while (rset1.next()) {
				p_count = rset1.getInt(1);
			}
			if (rset1 != null)
				rset1.close();
			if (pstmt != null)
				pstmt.close(); 

		//ML-MMOH-CRF-1759.1 end
 if ((sex.equalsIgnoreCase("F") && (patient_age >= min_age_pregnancy)) || (sex.equalsIgnoreCase("F") && (patient_age >= Integer.parseInt(min_age_for_lmp))) ){
				 menstrual_status = "true"; %>			
     <table border="0" cellpadding="3" cellspacing="0" align='center' width='100%'>
	 <tr>
		    <td class='COLUMNHEADER' colspan='4' ><fmt:message key="Common.MenstrualHistory.label" bundle="${common_labels}"/></td>
	 </tr>
	 <tr><td colspan=4 class=label height=5></td></tr>
     <tr>		
		    <td class='LABEL' width="15%" ><fmt:message key="Common.PregnantatPresent.label" bundle="${common_labels}"/></td>
            <td class='fields' width='10%' tabindex='<%=++tindex%>'>
            <!-- krishna pranay regarding ML-MMOH-CRF-1759.1 start-->
           <%  if ("A".equals(latestMensDtlStatus) && "Y".equals(invokeMenstrualHistYN)){
        	   checked8 = "checked";
           %>
          <input type='checkbox' name="pregnant_at_present_yn_val" id="pregnant_at_present_yn_val" <%=checked8%> <%=MensdisabledPre%> onClick='checkPregnant(this); if(this.checked == false) { nmdesig.innerHTML = ""; nmdesig1.innerHTML = ""; eddesig.innerHTML = ""; } if(this.checked == true) { calculateEDD1(); calculateNoOfDays1(); }'>
            <%  }else{%>
	         <input type='checkbox'  name="pregnant_at_present_yn_val" id="pregnant_at_present_yn_val" <%=checked8%> onClick='checkPregnant(this);if(this.checked ==false){nmdesig.innerHTML="";nmdesig1.innerHTML="";eddesig.innerHTML=""};if(this.checked ==true  ){calculateEDD(),calculateNoOfDays();}' <%=disabledPre%>></td>
			 <% }%>

			 <%if(modify_flag.equals("Y") && invokeMenstrualHistYN.equals("Y") && p_count!=0){ %>
			 <td width="10%" tabindex='<%=++tindex%>' nowrap>
    		<a id="mensHistHyperLinkDisplay" href="javascript:menstHistDtl('<%=patient_id%>' ,'<%=facilityId%>')" style="text-decoration: underline;"><fmt:message key="eMP.ViewMenstrualHistoryDetails.label" bundle="${mp_labels}" /></td>
			<% }else if(checked8.equals("checked") && invokeMenstrualHistYN.equals("Y")){%>
			<td width="10%" tabindex='<%=++tindex%>' nowrap>
    		<a id="mensHistHyperLinkDisplay" href="javascript:viewMenstrualHistoryDtl('<%=function_id%>','<%=encounter_id%>','<%=patient_id %>','<%=patient_gender %>','<%=year_value %>')" style="text-decoration: underline;">
        	<fmt:message key="<%= rec_view_lmp_details_label %>" bundle="${mp_labels}" />
    		</a>
			</td>
			 <%}else if(invokeMenstrualHistYN.equals("Y")){ %>
			 	<td width="10%" tabindex='<%=++tindex%>' nowrap>
    		<a id="mensHistHyperLinkDisplay" href="javascript:viewMenstrualHistoryDtl('<%=function_id%>','<%=encounter_id%>','<%=patient_id %>','<%=patient_gender %>','<%=year_value %>')" style="text-decoration: underline;display:none;">
        	<fmt:message key="<%= rec_view_lmp_details_label %>" bundle="${mp_labels}" />
    		</a>
			</td>
			<%}%>
			 <%
			 if((min_age_for_lmp!=null)&&(year_value!=null))
			 {
				minageforlmp=Integer.parseInt( min_age_for_lmp);
                yearvalue=Integer.parseInt( year_value);
              if(yearvalue>=minageforlmp)
				 {
				   %>
			<td class='LABEL' width='25%' size='20' id="lmplabel"><fmt:message key="eAE.LMPDate.label" bundle="${ae_labels}"/></td>
            <td class='fields' width='25%' tabindex='<%=++tindex%>'><input type="text"  name="lmp_date" id="lmp_date" <%=MensdisabledPre%>  id="lmpdate" maxlength="10" size="8"  onblur='makeValidString(this);doDate1(this);if(this.value==""){nmdesig.innerHTML="";nmdesig1.innerHTML="";} checkPregnantDate(this);if(pregnant_at_present_yn_val.checked==true)calculateEDD(),calculateNoOfDays();'  value = "<%=DateUtils.convertDate(lmp_date,"DMY","en",localeName)%>" ><img src='../../eCommon/images/CommonCalendar.gif'  id="lmp_calendar"  name="lmp_calendar" onClick="return showCalendar('lmpdate');" <%=MensdisabledPre%> style='cursor:pointer'><img src='../../eCommon/images/mandatory.gif' id='mand2' style="visibility:hidden" align='center'></img></td> 
			<%}else{%>
			<td class='LABEL' width='25%' size='20' id="lmplabel"><fmt:message key="eAE.LMPDate.label" bundle="${ae_labels}"/></td>
            <td class='fields' width='25%' tabindex='<%=++tindex%>'><input type="text" name="lmp_date" id="lmp_date" disabled <%=MensdisabledPre%> id="lmpdate" maxlength="10" size="8"  onblur='makeValidString(this);doDate1(this); checkPregnantDate(this);calculateEDD();calculateNoOfDays();'  value = "<%=DateUtils.convertDate(lmp_date,"DMY","en",localeName)%>" ><img src='../../eCommon/images/CommonCalendar.gif' id="lmp_calendar" name="lmp_calendar" onClick="return showCalendar('lmpdate');" disabled <%=MensdisabledPre%>   style='cursor:pointer'><img src='../../eCommon/images/mandatory.gif' id='mand2' style="visibility:hidden" align='center'></img></td> 
		<%}}%>
       </tr>
	   <tr>	
	   <%if(modify_flag.equals("N") && invokeMenstrualHistYN.equals("Y")){ %>
			<td class='LABEL' width='25%' size='20' style="display:none;"  id="lmplabel1"><fmt:message key="eAE.LMPDate.label" bundle="${ae_labels}"/></td>
            <td class='fields' width='25%' tabindex='<%=++tindex%>'  id="Lmpinputfield" style="display:none;" ><input type="text" name="lmpdate1" id="lmpdate1" style="display:none;"  <%=MensdisabledPre%> id="lmpdate1" maxlength="10" size="8"  onblur='makeValidString(this);doDate1(this); checkPregnantDate(this);'  value = "<%=lmpdate1%>" ><img src='../../eCommon/images/CommonCalendar.gif' id="lmp_calendar1" name="lmp_calendar1" onClick="return showCalendar('lmpdate1');" style="display:none;" disabled <%=MensdisabledPre%>   style='cursor:pointer'></td> 
            <%}else if(modify_flag.equals("Y") && invokeMenstrualHistYN.equals("Y")){ %>
            <td class='LABEL' width='25%' size='20' style="display:none;"  id="lmplabel1"><fmt:message key="eAE.LMPDate.label" bundle="${ae_labels}"/></td>
            <td class='fields' width='25%' tabindex='<%=++tindex%>'  id="Lmpinputfield" style="display:none;" ><input type="text" name="lmpdate1" id="lmpdate1" style="display:none;"  <%=MensdisabledPre%> id="lmpdate1" maxlength="10" size="8"  onblur='makeValidString(this);doDate1(this);if(this.value==""){nmdesig.innerHTML="";nmdesig1.innerHTML="";} checkPregnantDate(this);if(pregnant_at_present_yn_val.checked==true)calculateEDD1(),calculateNoOfDays1();'  value = "<%=lmpdate1%>" ><img src='../../eCommon/images/CommonCalendar.gif' id="lmp_calendar1" name="lmp_calendar1" onClick="return showCalendar('lmpdate1');" style="display:none;" disabled <%=MensdisabledPre%>   style='cursor:pointer'></td> 
            <%} %>
          	<td class='LABEL' width='25%' ><fmt:message key="Common.POA.label" bundle="${common_labels}"/>&nbsp;<font name="weekVal" id='nmdesig' class='label'></font>&nbsp;<fmt:message key="Common.weeks.label" bundle="${common_labels}"/>&nbsp;<font id='nmdesig1' class='label'></font>&nbsp;<fmt:message key="Common.days.label" bundle="${common_labels}"/></td>
		       <td class='LABEL' align='left' ><fmt:message key="Common.EDD.label" bundle="${common_labels}"/>&nbsp;<font name="eddVal" id='eddesig' class='label'></font> 
		    </td>
			<td colspan=2 class='LABEL' >&nbsp;</td>  
	</tr> 
   	 <tr><td colspan=4 class=label height=5></td></tr>
 </table>
 <input type='hidden' id='CALmpDate' name='CALmpDate' id='CALmpDate' value='<%=CALmpDate%>'>
<input type='hidden' id='CAEdd' name='CAEdd' id='CAEdd' value='<%=CAEdd%>'>
<input type='hidden' id='CADays' name='CADays' id='CADays' value='<%=CADays%>'>
<input type='hidden' id='CAWeeks' name='CAWeeks' id='CAWeeks' value='<%=CAWeeks%>'>
<input type='hidden' id='lmpdate2' name='lmpdate2' id='lmpdate2' value='<%=lmpdate1%>'>
<input type='hidden' id='latestMensDtlStatus' name='latestMensDtlStatus' id='latestMensDtlStatus' value='<%=latestMensDtlStatus%>'>
<input type='hidden' id='check_yn' name='check_yn' id='check_yn' value='<%=checked8%>'>

<% if (modify_flag.equals("Y")) { %>
<script>
    calculateNoOfDays1();
    calculateEDD1();
</script>
<% } %>



<script>
/* code for calculating POA -- Weeks and Days as well as EDD values onload */
calculateNoOfDays();
calculateEDD();
</script>

<script>
function setInitialValues() {
	var CALmpDate = document.getElementById("CALmpDate").value;
	var CAWeeks=document.getElementById("CAWeeks").value;
	var CADays=document.getElementById("CADays").value;
	var CAEdd=document.getElementById("CAEdd").value;
	var latestMensDtlStatus=document.getElementById("latestMensDtlStatus").value;
	var invokeMenstrualHistYN=document.getElementById("invokeMenstrualHistYN").value;
	var check_yn=document.getElementById("check_yn").value;

    if(latestMensDtlStatus=="A" && invokeMenstrualHistYN =="Y")
    	{
    	 document.getElementById('lmpdate1').value = CALmpDate; 
    	    document.getElementById('nmdesig').innerHTML = CAWeeks;
    	    document.getElementById('nmdesig1').innerHTML = CADays;
    	    document.getElementById('eddesig').innerHTML = CAEdd;
    	document.getElementById('lmpdate1').style.display='inline';
    	document.getElementById('lmplabel1').style.display='inline';
    	document.getElementById('lmp_calendar1').style.display='inline';
    	document.getElementById('lmplabel').style.visibility='hidden';
    	document.getElementById('lmpdate').style.visibility='hidden';
      	document.getElementById('lmp_calendar').style.visibility='hidden';
    	document.getElementById('Lmpinputfield').style.display='inline';

    	}
    else if(latestMensDtlStatus!="A" && invokeMenstrualHistYN =="Y" && check_yn=="checked"){
    	document.getElementById('lmpdate1').style.display='inline';
    	document.getElementById('lmplabel1').style.display='inline';
    	document.getElementById('lmp_calendar1').style.display='inline';
    	document.getElementById('lmp_calendar1').disabled =true;
    	document.getElementById('lmplabel').style.display='none';
    	document.getElementById('lmpdate').style.display='none';
      	document.getElementById('lmp_calendar').style.display='none';
    	document.getElementById('Lmpinputfield').style.display='inline';
    	document.getElementById('Lmpinputfield').disabled =true;

    }
}

// Attach the function to the window.onload event
window.onload = function() {
    setInitialValues();
};
 </script>
 <%  } %>
</div>
<!-- New Tab Other Details Added on 04/02/2005  -->
<%if(ca_install_yn.equals("Y")){%>
 <div id='Assessment' style= 'display:none'>
		<table cellspacing='0' cellpadding='0' width='100%' border=0 align='center'>
            <tr><td class='white'>
		<ul id="tablist" class="tablist" >
			<li class="tablistitem" title="Triage Details">
				<a class="tabA" id='Triage_tab' >
					<span class="tabAspan" onClick='javascript:expandCollapse("Triage_Details_tab")' id="Triage_tabspan"><fmt:message key="Common.TriageDetails.label" bundle="${common_labels}"/></span>
				</a>
			</li>			
			<li class="tablistitem" title="Assessment">
				<a class="tabClicked" id="assess_tab" >
					<span class="tabSpanclicked" onClick='javascript:expandCollapse("Assessment_tab")' id="assess_tabspan"><fmt:message key="Common.Assessment.label" bundle="${common_labels}"/></span>
				</a>
			</li>		
		</ul>
	</td></tr></table>
	<!-- Added For AAKH-CRF-0010 [IN:038535] By Dharma on Mar 6th 2014 Start -->
	<%if(five_level_triage_appl_yn.equals("Y")){ %>
		 <table border="0" cellspacing='0' cellpadding='3'  align='center' width='100%'>
			 <tr><td class='COLUMNHEADER' colspan='4' ><fmt:message key="Common.Assessment.label" bundle="${common_labels}"/></td></tr>
			<%if(clinical_notes_status.equals("A")){%>
			 	<tr><td   colspan='4' ><a href="javascript:FnProceedClicnicalNotes('<%=patient_id%>','<%=episode_id%>','<%=patient_class%>','','','','<%=encounter_id%>','<%=facilityId%>','<%=loginUser%>')"><fmt:message key="Common.record.label" bundle="${common_labels}"/> <fmt:message key="Common.ClinicalNotes.label" bundle="${common_labels}"/></a></td></tr>
			<%}else{ %>
				<tr><td   colspan='4' ><a href="javascript:FnNotApplicable();"><fmt:message key="Common.record.label" bundle="${common_labels}"/> <fmt:message key="Common.ClinicalNotes.label" bundle="${common_labels}"/></a></td></tr>
			  <%}
			  if(ca_chart_rec_status.equals("A")){%>
			 	<tr><td   colspan='4' ><a href="javascript:FnProceedCARecordChart('<%=patient_id%>','<%=sys_date_qry%>','','<%=episode_id%>','<%=encounter_id%>','<%=facilityId%>')">CA <fmt:message key="eOT.RecordChart.Label" bundle="${ot_labels}"/></a></td></tr>
			<%}else{ %>
				<tr><td   colspan='4' ><a href="javascript:FnNotApplicable();">CA <fmt:message key="eOT.RecordChart.Label" bundle="${ot_labels}"/></a></td></tr>
			<%} %>
			<tr><td  colspan='4' ><a href="javascript:FnProceedRegisterPatientReferral('<%=encounter_id%>','<%=patient_id%>');"><fmt:message key="eMP.RegisterPatientReferral.label" bundle="${mp_labels}"/></a></td></tr>
		 </table>
	 <%} %>
	 <!-- Added For AAKH-CRF-0010 [IN:038535] By Dharma on Mar 6th 2014 End -->
</div>
<%}
}catch(Exception e){
	e.printStackTrace();
}%>
<%!
	public static String checkForNull(String inputString)
	{
		return ( ((inputString == null) || (inputString.equals(""))) ? "" : inputString );
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
	  public String specialCharacter(String single){
			int i=0;
			
			
	if(( single.indexOf('\'', i)!=-1)){
		single=(String)single.replace('\'',' ');
	}


	return single ; 
		
		}
%>

