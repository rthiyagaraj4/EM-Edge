<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import="java.sql.*, java.util.*, java.text.*, webbeans.eCommon.*,com.ehis.util.*,org.json.simple.* " contentType="text/html;charset=UTF-8" %>
<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	Connection con=null;
	PreparedStatement pstmt   =null;
	PreparedStatement pstmt1   =null;
	ResultSet rs            = null;	
	ResultSet rs1            = null;
	
	

%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
<Script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eOP/js/OPCancelCheckout.js'></script>
<script language="javascript" src="../../eOP/js/OPPractitionerComponent.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<%
try {
con = ConnectionManager.getConnection(request);
/*Below line(s) added by venkateshs against ML-MMOH-CRF-0354 [IN057191] */
boolean siteSpecific		=eCommon.Common.CommonBean.isSiteSpecific(con, "MR","MLC_TO_MEDICO_LEGAL_CASE"); 
/*end ML-MMOH-CRF-0354 [IN057191] */
	String locale = (String)session.getAttribute("LOCALE"); 
    String loginUser = (String)session.getValue("login_user");
	String facility_id = (String) session.getValue( "facility_id" ) ;
	String bl_install_yn=(String) session.getValue( "bl_operational" ) ;
	String encounter_id = checkForNull(request.getParameter("encounter_id"));
	String patient_id = checkForNull(request.getParameter("patient_id"));
	String module_id = checkForNull(request.getParameter("module_id"));
	String oper_stn_id = checkForNull(request.getParameter("oper_stn_id"));
	String pat_class = "";
	String p_episode_type ="";
    String body_release_date_time = "";
	String circumstance_of_injury_code = "";
	String brought_dead_yn = "";
	String appt_ref_no = "";
	String pat_cat = "";
	String referral_value = "";
	String forced_appt_yn = "";
	String oacnt = ""; 

	String brought_dead_st="";
	String mlc_st ="";
	String medical_st = "";
	String surgical_st ="";
	String pm_st ="";
	String high_risk_st ="";
	String multi_speciality_yn ="N";

	//Added by Ashwini on 18-Jan-2021 for ML-MMOH-CRF-1409
	Boolean isReconfirmCOTAppl		= eCommon.Common.CommonBean.isSiteSpecific(con, "AE", "RECONFIRM_CASE_OF_TRAUMA");

        //Added by Ajay Hatwate for AAKH-CRF-0179
	Boolean isDeathRegisterFormAppl = false;
	isDeathRegisterFormAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "AE", "DEATH_REGISTER_FORM_APPL");
	String enable_death_reg_form = "N";
	String death_reg_form_accession_num = "";
	enable_death_reg_form	=  eMP.MPCommonBean.getEnableDeathRegisterFormYN(con);
	
	//End of AAKH-CRF-0179
	/*Added by Thamizh selvi on 27th Mar 2018 against ML-MMOH-CRF-646 Start*/
	Boolean isCaseDtlsRadioBtnAppl	= eCommon.Common.CommonBean.isSiteSpecific(con, "AE","SEC_TRIAGE_CASE_DETAILS");
	String traumaYn					= checkForNull(request.getParameter("traumaYn"),"N");
	String OandGYn					= checkForNull(request.getParameter("OandGYn"),"N");
	String osccYn					= checkForNull(request.getParameter("osccYn"),"N");
	String nonEmergYn				= checkForNull(request.getParameter("nonEmergYn"),"N");
	String checkedOandGYn			= "";
	String checkedTraumaYn			= "";
	String checkedOsccYn			= "";
	String checkedNonEmergYn		= "";
	String mechInjCatgCode			= checkForNull(request.getParameter("mechInjCode"));
	String mechInjSubCatgCode		= checkForNull(request.getParameter("mechInjSubCode"));
	/*End*/
	

		String	   visit_type = request.getParameter("visit_type")==null?"":request.getParameter("visit_type");
		//String	   practitioner_name   = request.getParameter("practitioner_name")==null?"":request.getParameter("practitioner_name");
		String	   disposition   = request.getParameter("disposition")==null?"":request.getParameter("disposition");
		String	   medical_yn  = request.getParameter("medical_yn")==null?"":request.getParameter("medical_yn");  
		String	   surgical_yn   = request.getParameter("surgical_yn")==null?"":request.getParameter("surgical_yn");
		String	   mlc_yn  = request.getParameter("mlc_yn")==null?"":request.getParameter("mlc_yn");
		String	   deceased_time   = checkForNull(request.getParameter("deceased_time"));
		String	   discharge_date_time = request.getParameter("discharge_date_time")==null?"":request.getParameter("discharge_date_time");  
		String	   visit_type_ind   = request.getParameter("visit_type_ind")==null?"":request.getParameter("visit_type_ind");
		String	   p_visit_id   = request.getParameter("p_visit_id")==null?"":request.getParameter("p_visit_id");
		String	   p_episode_id  = request.getParameter("p_episode_id")==null?"":request.getParameter("p_episode_id");
		String	   treatment_area_code   = request.getParameter("treatment_area_code")==null?"":request.getParameter("treatment_area_code");
		String	   locn_code   = request.getParameter("locn_code")==null?"":request.getParameter("locn_code");
		String	   priority_zone   = request.getParameter("priority_zone")==null?"":request.getParameter("priority_zone");
		String	   deceased_yn   = request.getParameter("deceased_yn")==null?"":request.getParameter("deceased_yn");
		String	   ae_bed_no   = request.getParameter("ae_bed_no")==null?"":request.getParameter("ae_bed_no");
		String	   high_risk_yn   = request.getParameter("high_risk_yn")==null?"":request.getParameter("high_risk_yn");
		String	   pm_yn   = request.getParameter("pm_yn")==null?"":request.getParameter("pm_yn");		
		String	   sysdate   = request.getParameter("cdate")==null?"":request.getParameter("cdate");		
		String	   ae_bed_charge_appl_yn   = request.getParameter("ae_bed_charge")==null?"":request.getParameter("ae_bed_charge");	
		String	   pract_id   = request.getParameter("pract_id")==null?"":request.getParameter("pract_id");	
		
		 
		String discharge_date_time_display = DateUtils.convertDate(discharge_date_time,"DMYHM","en",locale);	

		deceased_time = DateUtils.convertDate(deceased_time,"DMYHM","en",locale);

		
	if(module_id.equals("AE"))
		pat_class="EM";
	else if(module_id.equals("OP"))
		pat_class="OP";

	if(pat_class.equals("EM"))
		p_episode_type="E";	
	else
        p_episode_type="O";

	/*
	CRF-362 AE bed charges start
	String ae_bed_charge_appl_yn="";
	String sql_ae_bed="SELECT NVL(AE_BED_CHARGE_APPL_YN,'N') ae_bed_charge FROM Bl_parameters Where  operating_facility_id = ?";
	pstmt1=con.prepareStatement(sql_ae_bed);
	pstmt1.setString(1,facility_id);
	rs1=pstmt1.executeQuery();
	while(rs1.next()){
		ae_bed_charge_appl_yn=rs1.getString(1);

	}
	if(rs1 != null) rs1.close();
	if(pstmt1 != null) pstmt1.close();	

	CRF-362 AE bed charges complete

	String sql_sys = "select to_char(sysdate,'dd/mm/yyyy hh24:mi') cdate from dual ";
	 pstmt1 = con.prepareStatement(sql_sys);
		 rs1 = pstmt1.executeQuery();
		 if(rs1!=null && rs1.next())
		{	
			 sysdate = rs1.getString(1);
			
		}
		if(pstmt1!=null ) pstmt1.close();	
		if (rs1 != null)  rs1.close();
		 StringBuffer aesql = new StringBuffer();
		  aesql.append(" select oper_stn_id from am_user_for_oper_stn ");
		  aesql.append(" where appl_user_id= ? ");
		  aesql.append(" and facility_id=  ? ");

		  pstmt = con.prepareStatement(aesql.toString());
		  pstmt.setString(1, loginUser);
		  pstmt.setString(2, facility_id);

		  aerset = pstmt.executeQuery();
		  if(aerset.next())
			oper_stn_id=aerset.getString(1);

		  if(aerset!=null)aerset.close();
		  if(pstmt!=null)pstmt.close();
		  if((aesql != null) && (aesql.length() > 0))
			{
				aesql.delete(0,aesql.length());
			}  
	StringBuffer sql = new StringBuffer();

	sql.append("select a.OP_EPISODE_VISIT_NUM, op_get_desc.OP_VISIT_TYPE(facility_id,a.VISIT_TYPE_CODE,'"+locale+"',2) visit_type, a.episode_id episode_id, am_get_desc.AM_PRACTITIONER(a.practitioner_id,'"+locale+"',1) practitioner_name, am_get_desc.am_disposition_type(a.disposition_type,'"+locale+"',2) disposition_short_desc,a.medical_yn medical_yn  ,a.surgical_yn surgical_yn, a.mlc_yn mlc_yn,a.pm_yn pm_yn, a.high_risk_yn high_risk_yn, TO_CHAR(b.DECEASED_DATE,'dd/mm/yyyy hh24:mi') deceased_time, TO_CHAR(a.DISCHARGE_DATE_TIME,'dd/mm/yyyy hh24:mi') DISCHARGE_DATE_TIME, a.TREATMENT_AREA_CODE, a.LOCN_CODE, a.PRIORITY_ZONE, b.DECEASED_YN, a.VISIT_TYPE_IND,a.AE_BED_NO FROM op_patient_queue a, mp_patient b WHERE  a.facility_id = '"+facility_id+"' AND  a.patient_id = b.patient_id AND queue_STATUS = '07' AND patient_class='"+pat_class+"' AND trunc(a.DISCHARGE_DATE_TIME) = trunc(sysdate) and encounter_id='"+encounter_id+"'");	
	 pstmt = con.prepareStatement(sql.toString());
	 rs = pstmt.executeQuery();
	 if(rs!=null && rs.next())
	{
	
		 String visit_type =checkForNull(rs.getString("visit_type")); 
		 String practitioner_name = checkForNull(rs.getString("practitioner_name")); 
		 String disposition = checkForNull(rs.getString("disposition_short_desc")); 
		 String medical_yn = checkForNull(rs.getString("medical_yn")); 
		 String medical_st = "";
		 if(medical_yn == "Y")
			medical_st = "checked";
		 else
			 medical_st = "";
		 String surgical_yn = checkForNull(rs.getString("surgical_yn")); 
		 String mlc_yn = checkForNull(rs.getString("mlc_yn")); 
		 String deceased_time = checkForNull(rs.getString("deceased_time")); 
		 String discharge_date_time = checkForNull(rs.getString("DISCHARGE_DATE_TIME")); 
		 visit_type_ind = checkForNull(rs.getString("VISIT_TYPE_IND")); 
		p_visit_id = checkForNull(rs.getString("OP_EPISODE_VISIT_NUM")); 
		p_episode_id = checkForNull(rs.getString("episode_id")); 
		treatment_area_code = checkForNull(rs.getString("TREATMENT_AREA_CODE"));
		locn_code = checkForNull(rs.getString("LOCN_CODE"));
		priority_zone = checkForNull(rs.getString("PRIORITY_ZONE"));
		deceased_yn = checkForNull(rs.getString("DECEASED_YN"));
		String ae_bed_no = checkForNull(rs.getString("AE_BED_NO")); 
		high_risk_yn = checkForNull(rs.getString("high_risk_yn")); 
		pm_yn = checkForNull(rs.getString("pm_yn"));
*/

Boolean isLabelChngAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "AE","LABEL_CHG_BR_DEAD_PLACE_ACCDNT"); //Added by Ashwini on 18-Jan-2017 for GDOH-CRF-0131 and GDOH-CRF-0123


String five_level_triage_appl_yn	= "N";
String AcessSql   = "SELECT five_level_triage_appl_yn FROM AE_PARAM WHERE OPERATING_FACILITY_ID=? ";
 pstmt=con.prepareStatement(AcessSql);
 pstmt.setString(1,facility_id);
 rs=pstmt.executeQuery();
 while(rs!=null && rs.next()) {
	  five_level_triage_appl_yn	=  (rs.getString("five_level_triage_appl_yn")==null || rs.getString("five_level_triage_appl_yn")=="")?"N":rs.getString("five_level_triage_appl_yn");
 }
 if(rs!=null)  rs.close();
 if(pstmt!=null)  pstmt.close();
  String str="Select  practitioner_name from am_practitioner_lang_vw where  eff_status = 'E' and practitioner_id='"+pract_id+"'and LANGUAGE_ID='"+locale+"'";
   pstmt = con.prepareStatement(str);
	 rs = pstmt.executeQuery();
	 String practitioner_name="";
	 if(rs!=null && rs.next())
	{
   practitioner_name = checkForNull(rs.getString("practitioner_name"));
 
	}


		if(pm_yn.equals("Y"))
			pm_st="checked";
		else
			pm_st="unchecked";

		if(high_risk_yn.equals("Y"))
			high_risk_st="checked";
		else
			high_risk_st="unchecked";

		
		if(mlc_yn.equals("Y"))
			mlc_st = "checked";
		else
			mlc_st = "unchecked";

		
		if(medical_yn.equals("Y"))
			medical_st="checked";
		else
			medical_st="unchecked";

		
		if(surgical_yn.equals("Y"))
			surgical_st="checked";
		else
			surgical_st="unchecked";

		/*Added by Thamizh selvi on 27th Mar 2018 against ML-MMOH-CRF-0646 Start*/
		if(traumaYn.equals("Y"))
			checkedTraumaYn		= "checked";
		else
			checkedTraumaYn		= "";
		if(osccYn.equals("Y"))
			checkedOsccYn		= "checked";
		else
			checkedOsccYn		= "";
		if(OandGYn.equals("Y"))
			checkedOandGYn		= "checked";
		else
			checkedOandGYn		= "";
		if(nonEmergYn.equals("Y"))
			checkedNonEmergYn	= "checked";
		else
			checkedNonEmergYn	= "";
		/*End*/
		
	

		 String sql1="SELECT TO_CHAR(BODY_RELEASE_DATE_TIME,'dd/mm/yyyy hh24:mi') BODY_RELEASE_DATE_TIME, am_get_desc.AM_CIRCUMSTANCE_OF_INJURY(CIRCUMSTANCE_OF_INJURY_CODE,'"+locale+"',1) CIRCUMSTANCE_OF_INJURY_CODE, BROUGHT_DEAD_YN,(select multi_speciality_yn from op_clinic where clinic_code=a.ASSIGN_CARE_LOCN_CODE and facility_id='"+facility_id+"') multi_speciality_yn, death_reg_form_accession_num FROM pr_encounter a WHERE  PATIENT_ID='"+patient_id+"' AND ENCOUNTER_ID='"+encounter_id+"' AND FACILITY_ID='"+facility_id+"'";
		
		 pstmt1 = con.prepareStatement(sql1);
		 rs1 = pstmt1.executeQuery();
		 if(rs1!=null && rs1.next())
		{	
			 body_release_date_time = checkForNull(rs1.getString("BODY_RELEASE_DATE_TIME")); 
			 body_release_date_time = DateUtils.convertDate(body_release_date_time,"DMYHM","en",locale);

      	     circumstance_of_injury_code = checkForNull(rs1.getString("CIRCUMSTANCE_OF_INJURY_CODE")); 
		     brought_dead_yn = checkForNull(rs1.getString("BROUGHT_DEAD_YN")); 
		     multi_speciality_yn = checkForNull(rs1.getString("multi_speciality_yn")); 
			
		     if(isDeathRegisterFormAppl && enable_death_reg_form.equals("Y")){
		    	 death_reg_form_accession_num = checkForNull(rs1.getString("death_reg_form_accession_num")); 
		     }
		}
		if(pstmt1!=null ) pstmt1.close();	
		if (rs1 != null)  rs1.close();

		if(brought_dead_yn.equals("Y"))
			brought_dead_st="checked";
		else
			brought_dead_st="unchecked";


		String sql3="SELECT APPT_REF_NO,PATIENT_CLASS,FORCED_APPT_YN,APPT_STATUS FROM OA_APPT WHERE FROM_FACILITY_ID='"+facility_id+"' AND FROM_ENCOUNTER_ID='"+encounter_id+"' AND APPT_STATUS ='1'";
		pstmt1 = con.prepareStatement(sql3);
	    rs1 = pstmt1.executeQuery();
		
		if(rs1!=null && rs1.next())
		{	
			oacnt = "Y";
			appt_ref_no = checkForNull(rs1.getString("APPT_REF_NO")); 
			pat_cat = checkForNull(rs1.getString("PATIENT_CLASS")); 
			forced_appt_yn = checkForNull(rs1.getString("FORCED_APPT_YN"));
			referral_value = checkForNull(rs1.getString("APPT_STATUS"));
		}
		if(pstmt1!=null ) pstmt1.close();	
		if (rs1 != null)  rs1.close();
		
			
%>
<style>
textarea {
        overflow-y: scroll;
        resize: none; /* Remove this if you want the user to resize the textarea */
    }
</style>
<BODY onLoad='' onMouseDown="CodeArrest()" onKeyDown='lockKey();'>
<form name="OPCancelChkoutResult" id="OPCancelChkoutResult" action='../../servlet/eOP.PatCheckoutServlet' method='post' target="Dummy_frame">
	<table border='0' align=center cellpadding='0' cellspacing='0' width='98%'  >
		<tr>
			<td colspan=4>&nbsp;</td>
		</tr>
		<tr>
			<td    class="label" width='5%'><fmt:message key="Common.visittype.label" bundle="${common_labels}"/></td>
			<td class ='querydata' width="25%"><%=visit_type%></td>
			<td    class="label" width='15%'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
			<td class='querydata' width="5%"><%=practitioner_name%></td>
		</tr>
		<tr style='heigth:10px'></tr>
			<td class='COLUMNHEADER' colspan=4><fmt:message key="Common.Disposition.label" bundle="${common_labels}"/></td>
		<tr>
			<td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td>
		</tr>
		
		<tr>
			<td   class="label" width="25%"><fmt:message key="Common.date.label" bundle="${common_labels}"/>/<fmt:message key="Common.time.label" bundle="${common_labels}"/></td>
			<td class='querydata' width="25%"><%=discharge_date_time_display%></td>

			<td    class="label" width='25%'><fmt:message key="Common.type.label" bundle="${common_labels}"/></td>
			<td class='querydata' width="25%"><%=disposition%></td>
		</tr>
		<tr><td ></td></tr>
		<tr><td ></td></tr>
		<td  colspan=4 class='COLUMNHEADER'><fmt:message key="eOP.CaseDefinitions.label" bundle="${op_labels}"/></td>
		<tr>
			<td colspan=4 height=5>&nbsp;</td>
		</tr>
		<!--Added by Thamizh selvi on 26th Mar 2018 against ML-MMOH-CRF-0646 Start-->
		<% if(isCaseDtlsRadioBtnAppl && module_id.equals("AE")){ %>
		<tr>
			<td class='label' width='20%'>
				<fmt:message key="Common.Trauma.label" bundle="${common_labels}"/>
			</td>
			<td>
				<table border='0' cellpadding='0' cellspacing='0' width='100%'>		
					<tr>
						<td class='fields' width='15%'>
							<input type='radio' name='caseDetails' id='caseDetails' id='trauma' value='<%=traumaYn%>' <%=checkedTraumaYn%> disabled></input>
						</td>
						<td class='label' width='15%'>
							<fmt:message key="Common.oscc.label" bundle="${common_labels}"/>
						</td>
						<td class='fields' width='16%'>
							<input type='radio' name='caseDetails' id='caseDetails' id='oscc' value='<%=osccYn%>' <%=checkedOsccYn%> disabled></input>
						</td>
					</tr>
				</table>
			</td>
			<td class='label' width='20%'>
				<span id='osccTypeLabel' style="visibility:hidden"><fmt:message key="Common.oscc.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.type.label" bundle="${common_labels}"/></span>
			</td>
			<td class='fields'>
				<select name='osccType' id='osccType' style="visibility:hidden">
					<option value=''>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------
					<%
						JSONArray osccTypeJsonArr	= new JSONArray();
						osccTypeJsonArr  = eAE.AECommonBean.getOSCCTypeList(con,locale,"");	
										
						for(int i = 0 ; i < osccTypeJsonArr.size() ; i++) 
						{
							JSONObject osccTypejson		= (JSONObject)osccTypeJsonArr.get(i);
							String injCategoryCode		= (String) osccTypejson.get("injCategoryCode");
							String injSubCategoryCode	= (String) osccTypejson.get("injSubCategoryCode");
							String subCategoryShortDesc	= (String) osccTypejson.get("subCategoryShortDesc");
								
							out.println("<option value="+injCategoryCode+","+injSubCategoryCode+">"+subCategoryShortDesc+"</option>");
										
						}
										
					%>
					</select><img src='../../eCommon/images/mandatory.gif' id='osccTypeMandImg' style="visibility:hidden" align='center'></img>
			</td>
		</tr>
		<tr>
			<td class='label'>
				<fmt:message key="Common.medical.label" bundle="${common_labels}"/>
			</td>
			<td>
				<table border='0' cellpadding='0' cellspacing='0' width='100%'>		
					<tr>
						<td class='fields'  width='15%'>
							<input type='radio' name="caseDetails" id="caseDetails" id='medical' value='<%=medical_yn%>' <%=medical_st%> disabled></input>
						</td>
						<td class='label'  width='15%'>
							<fmt:message key="Common.Surgical.label" bundle="${common_labels}"/>
						</td>
						<td class='fields'  width='16%'>
							<input type='radio' name="caseDetails" id="caseDetails" id='surgical' value='<%=surgical_yn%>' <%=surgical_st%> disabled></input> 
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td class='label'>
				<fmt:message key="eAE.OandG.label" bundle="${ae_labels}"/>
			</td>
			<td>
				<table border='0' cellpadding='0' cellspacing='0' width='100%'>		
					<tr>
						<td class='fields'  width='15%'>
							<input type='radio' name="caseDetails" id="caseDetails" id='OandG' value='<%=OandGYn%>' <%=checkedOandGYn%> disabled></input>
						</td>
						<td class='label' width='15%'>
							<fmt:message key="eAE.NonEmergency.label" bundle="${ae_labels}"/>
						</td>
						<td class='fields' width='16%'>
							<input type='radio' name="caseDetails" id="caseDetails" id='NonEmerg' value='<%=nonEmergYn%>' <%=checkedNonEmergYn%> disabled></input> 
						</td>
					</tr>
				</table>
			</td>	
		</tr>
		<% }else{ %>
		<!--End-->
		<!--Added by Ashwini on 18-Jan-2021 for ML-MMOH-CRF-1409-->
		<%if(isReconfirmCOTAppl && module_id.equals("AE")){%>
		<tr>
			<td class='label' width='25%'><fmt:message key="Common.CaseofTrauma.label" bundle="${common_labels}"/></td>
			<td class='fields' width='25%'><input type='checkbox' name="CaseofTrauma" id="CaseofTrauma" value='<%=traumaYn%>' <%=checkedTraumaYn%> disabled></td>
		</tr>
		<%}%>
		<!--End ML-MMOH-CRF-1409-->
		<tr>
			<td    class="label" width='25%'><fmt:message key="Common.medical.label" bundle="${common_labels}"/></td>
			<td class='field' width="25%"><input type='checkbox' name='medical' id='medical' value='<%=medical_yn%>'  <%=medical_st%> disabled></td>
			<td    class="label" width='25%'><fmt:message key="Common.Surgical.label" bundle="${common_labels}"/></td>
			<td class='field' width="25%"><input type='checkbox' name='surgical' id='surgical' value='<%=surgical_yn%>'  <%=surgical_st%> disabled></td>
		</tr>
		<% } %>
		<tr>
			<td    class="label" width='25%'><fmt:message key="Common.CircumstanceofInjury.label" bundle="${common_labels}"/></td>
			<td class='querydata' width="25%"><%=circumstance_of_injury_code%></td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			
		</tr>
		<td colspan=4 class='columnheader'><fmt:message key="eOP.IntheEventofDeath.label" bundle="${op_labels}"/></td>
		<tr>
			<td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td>
		</tr>
		<tr>
			<td    class="label" width='25%'>
			<%if(!five_level_triage_appl_yn.equals("Y")  && (isLabelChngAppl == false) ){ %> 
				<fmt:message key="Common.broughtdead.label" bundle="${common_labels}"/>
			<%}else{ %>	
				<fmt:message key="eAE.DeadOnArrival.label" bundle="${ae_labels}"/><!--bundle change for PAS-MP-PMG2020-TECH-CRF-0010/01-Label Name-->
			<%} %>
			
			</td>
			<td class='field' width="25%"><input type='checkbox' name='brdead' id='brdead' value='<%=brought_dead_yn%>'  <%=brought_dead_st%> disabled></td>
			<!-- below line(s) modified by VenkateshS against ML-MMOH-CRF-0354 [IN057191] -->
			<%if(siteSpecific){%>
			<td   class="label" width='25%'><fmt:message key="Common.MedicalLegalCase.label" bundle="${common_labels}"/></td>
			<%}else{%>
			<td   class="label" width='25%'><fmt:message key="Common.mlc.label" bundle="${common_labels}"/></td>
			<%}%>
			<!--end ML-MMOH-CRF-0354 [IN057191 -->
			<td class='field' width="25%"><input type='checkbox' name='mlc' id='mlc' value='<%=mlc_yn%>'  <%=mlc_st%> disabled></td>
		</tr>
		<tr>
			<td    class="label" width='25%'><fmt:message key="Common.PMRequired.label" bundle="${common_labels}"/></td>
			<td class='field' width="25%"><input type='checkbox' name='postmortem' id='postmortem' value='<%=pm_yn%>' <%=pm_st%> disabled></td>
			<td    class="label" width='25%'><fmt:message key="Common.highriskbody.label" bundle="${common_labels}"/></td>
			<td class='field' width="25%"><input type='checkbox' name='high_risk' id='high_risk' value='<%=high_risk_yn%>' <%=high_risk_st%> disabled></td>
		</tr>
		<tr>
			<td    class="label" width='25%'><fmt:message key="Common.deceaseddatetime.label" bundle="${common_labels}"/></td>
			<td class='querydata' width="25%"><%=deceased_time%>
			<%if(isDeathRegisterFormAppl && enable_death_reg_form.equals("Y") && deceased_yn.equals("Y") && !death_reg_form_accession_num.equals("")){ %>
				<a href="javascript:getDeathRegFormAccessionNum('<%=patient_id%>', '<%=encounter_id%>', '<%=p_episode_id%>', '', '<%=pat_class%>', '', '<%=locn_code%>', '<%=death_reg_form_accession_num%>', '');" id='deathRegFormLink'><fmt:message key="Common.DeathRegForm.label" bundle="${common_labels}"/></a>
			<%}%>
			</td>
			<td    class="label" width='25%'><fmt:message key="Common.BodyReleaseDateTime.label" bundle="${common_labels}"/></td>
			<td class='querydata' width="25%"><%=body_release_date_time%></td>
		</tr>
		<tr><td ></td></tr>
		<tr><td ></td></tr>
		<td  colspan=4 class='columnheader'><fmt:message key="Common.CancelCheckout.label" bundle="${common_labels}"/></td>
		<tr>
			<td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td>
		</tr>
		<tr>
			<td    class="label" width='25%'><fmt:message key="Common.ReasonforCancellation.label" bundle="${common_labels}"/>
			<td class='field'><select name='reasonCode' id='reasonCode' tabindex=1 style='width:238px'><option value=''>-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -------- 
					

					<%
						String tab_name = "";
						if(module_id.equals("AE"))
							tab_name="CANCEL_AE_CHECKOUT_YN";
						else if(module_id.equals("OP"))
							tab_name="CANCEL_OP_CHECKOUT_YN";

						 String sql2="select contact_reason_code,contact_reason from am_contact_reason_lang_vw where nvl("+tab_name+",'N') = 'Y' and eff_status='E' and language_id='"+locale+"' order by contact_reason";

						 pstmt1 = con.prepareStatement(sql2);
						 rs1 = pstmt1.executeQuery();
						 if(rs1!=null)
						{	
							while(rs1.next())
							{
							String contact_reason_code=rs1.getString("CONTACT_REASON_CODE");
							String contact_reason_desc=rs1.getString("CONTACT_REASON");
							out.println("<option value='"+contact_reason_code+"'>"+contact_reason_desc);
							}
			
						}
						if(pstmt1!=null ) pstmt1.close();	
						if (rs1 != null)  rs1.close();

					
					%>
			</select><img align='center' src='../../eCommon/images/mandatory.gif'></img>
			</td>

			<td    class="label" width='25%'><fmt:message key="Common.cancelledby.label" bundle="${common_labels}"/></td>
			<td class='field' width="25%"><input type='text' name='cancelled_by' id='cancelled_by'  tabindex=2 onKeyPress="return(CheckForSpecChars(event))" size='20' maxlength='30' onBlur='GetCancellLookupBlur(this);' value="<%=loginUser%>"><input type='hidden' name='userId' id='userId' size='40' maxlength='30' value='<%=loginUser%>'readonly><input type='button' class='BUTTON' value="?"  name='cancel_search' id='cancel_search'onclick='GetCancellLookup(cancelled_by)' tabindex=3><img align='center' src='../../eCommon/images/mandatory.gif'></img></td>
		</tr>
		<tr>
			<td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td>
		</tr>
		<tr>
			<td    class="label" width='25%'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
			<td> <textarea name='remarks' rows=2 cols=30 onblur='makeValidString(this);checkMaxLen(this);' tabindex=4></textarea><img align='center' src='../../eCommon/images/mandatory.gif'></img></td>
			
		<%
			if(module_id.equals("AE"))
			{
				/*if(ae_bed_no != "")
				{
					String sql5="select CURRENT_STATUS, TO_CHAR(OCCUPIED_UNTIL_DATE_TIME,'dd/mm/yyyy hh24:mi') OCCUPIED_UNTIL_DATE_TIME from AE_BED_FOR_TRMT_AREA where FACILITY_ID='"+facility_id+"' AND CLINIC_CODE='"+locn_code+"' AND TREATMENT_AREA_CODE='"+treatment_area_code+"' AND BED_NO='"+ae_bed_no+"'";
				
					pstmt1 = con.prepareStatement(sql5);
					rs1 = pstmt1.executeQuery();
					if(rs1!=null && rs1.next())
					{	
						current_status = rs1.getString("CURRENT_STATUS");
						occupied_until_date_time = checkForNull(rs1.getString("OCCUPIED_UNTIL_DATE_TIME"));
					}
					if(pstmt1!=null ) pstmt1.close();	
					if (rs1 != null)  rs1.close(); checkForValidBed(this.value); remove Monday, February 08, 2010  18873
					*/
			%>
					
					<td class="label" width='25%'><fmt:message key="eAE.BedBayNo.label" bundle="${ae_labels}"/></td>
				<td class='field' width="25%"><input type='text'  name='bed_no' id='bed_no' size='8' maxlength='8'  readonly onKeyPress='return CheckForSpecChars(event)' onblur='ChangeUpperCase(this);' value='<%=ae_bed_no%>' tabindex=5><input type='button'  name='search_bed' id='search_bed' value='?' onclick="searchBed()" class='button' tabindex=6>
			
					
				
			<%
			}
			else
		{
				
		%>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<input type="hidden" name="bed_no" id="bed_no" value=''>

		<%
		}
		%>
			
			
		</tr>
		</table>

		<table  border='0'cellpadding='0' cellspacing='0' align=center width='98%'  >


		<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td width='25%' class='label'><input type='button' class='Button' name='cancelhkout' id='cancelhkout' onClick="Apply('<%=module_id%>')" value='<fmt:message key="Common.CancelCheckout.label" bundle="${common_labels}"/>' > </td>
			<td width='25%' class='label'><input type='button' class='Button' name='cancel' id='cancel' onClick="window.close()" value='<fmt:message key="Common.Abort.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.CancelCheckout.label" bundle="${common_labels}"/>'></td>
		<tr>

<%
//}
%>

	</table>

	<input type='hidden' name='locale' id='locale' value='<%=locale%>'>
	<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'>
	<input type='hidden' name='encounter_id' id='encounter_id' value='<%=encounter_id%>'>
	<input type='hidden' name='function_name' id='function_name' value='cancelChkout'>
	<input type='hidden' name='p_episode_type' id='p_episode_type' value='<%=p_episode_type%>'>
	<input type='hidden' name='p_visit_id' id='p_visit_id' value='<%=p_visit_id%>'>
	<input type='hidden' name='p_episode_id' id='p_episode_id' value='<%=p_episode_id%>'>
	<input type='hidden' name='patient_id' id='patient_id' value='<%=patient_id%>'>
	<input type="hidden" name="bl_install_yn" id="bl_install_yn" value="<%=bl_install_yn%>" >

	<input type="hidden" name="treatment_area_code" id="treatment_area_code" value="<%=treatment_area_code%>" >
	<input type="hidden" name="locn_code" id="locn_code" value="<%=locn_code%>" >
	<input type="hidden" name="priority_zone" id="priority_zone" value="<%=priority_zone%>" >
	<input type="hidden" name="oper_stn_id" id="oper_stn_id" value="<%=oper_stn_id%>" >
	<input type="hidden" name="deceased_yn" id="deceased_yn" value="<%=deceased_yn%>" >
	<input type="hidden" name="module_id" id="module_id" value="<%=module_id%>" >
	<input type="hidden" name="visit_type_ind" id="visit_type_ind" value="<%=visit_type_ind%>" >
	<input type="hidden" name="appt_ref_no" id="appt_ref_no" value="<%=appt_ref_no%>" >
	<input type="hidden" name="pat_cat" id="pat_cat" value="<%=pat_cat%>" >
	<input type="hidden" name="forced_appt_yn" id="forced_appt_yn" value="<%=forced_appt_yn%>" >
	<input type="hidden" name="referral_value" id="referral_value" value="<%=referral_value%>" >
	<input type="hidden" name="oacnt" id="oacnt" value="<%=oacnt%>" >
	 <input type='hidden' name='sysdate' id='sysdate' value='<%=sysdate%>'>
	 <input type='hidden' name='flag_chk' id='flag_chk' value=''>

	  <!--CRF-362 AE bed charge -->
	 <input type='hidden' name='ae_bed_charge_appl_yn' id='ae_bed_charge_appl_yn' value='<%=ae_bed_charge_appl_yn%>'>
	 <input type='hidden' name='multi_speciality_yn' id='multi_speciality_yn' value='<%=multi_speciality_yn%>'>
	
	<!--Added by Thamizh selvi on 27th Mar 2018 against ML-MMOH-CRF-0646 Start-->
	<input type='hidden' name='mechInjCatgCode' id='mechInjCatgCode' value='<%=mechInjCatgCode%>'>
	<input type='hidden' name='mechInjSubCatgCode' id='mechInjSubCatgCode' value='<%=mechInjSubCatgCode%>'>
	<input type='hidden' name='isCaseDtlsRadioBtnAppl' id='isCaseDtlsRadioBtnAppl' value='<%=isCaseDtlsRadioBtnAppl%>'>
	<!--End-->
	<!-- Added by Ajay Hatwate for AAKH-CRF-0179 -->	
	<input type='hidden' name='death_reg_form_accession_num' id='death_reg_form_accession_num' value='<%=death_reg_form_accession_num%>'>
	<input type ='hidden' name= 'callback_mode' value="View">	
	<!-- End of AAKH-CRF-0179 -->
</form>
<!--Added by Thamizh selvi against ML-MMOH-CRF-0646 Start-->
<script>
	if(document.forms[0].isCaseDtlsRadioBtnAppl.value == "true" && document.forms[0].module_id.value == "AE"){
		if(document.getElementById("oscc").checked){
			document.getElementById("osccTypeLabel").style.visibility	= "visible";
			document.forms[0].osccType.style.visibility					= "visible";
			document.forms[0].osccType.disabled							= "true";
			var mechInjSubCatCode	= document.forms[0].mechInjSubCatgCode.value;
			var mechInjrCode		= document.forms[0].mechInjCatgCode.value;
			for(var i=0;i<document.forms[0].osccType.options.length;i++ ){
				var osccTypeArr = document.forms[0].osccType.options[i].value.split(",");
				if(osccTypeArr[0] == mechInjrCode && osccTypeArr[1] == mechInjSubCatCode)
					document.forms[0].osccType.options[i].selected = true;
			}
		}
	}
</script>
<!--End-->
</body>
</html>
<%
} catch(Exception e) {
	e.printStackTrace();
} finally {
	ConnectionManager.returnConnection(con,request);
}
%>

<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

