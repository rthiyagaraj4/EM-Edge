/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eAE.SecondaryTriage;

import java.rmi.*;
import java.util.*;
import java.sql.*;
import java.io.*;
import javax.ejb.*;
import javax.naming.*;
import webbeans.eCommon.*;
import eCommon.Common.*;

/**
*
* @ejb.bean
*	name="SecondaryTriage"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="SecondaryTriage"
*	local-jndi-name="SecondaryTriage"
*	impl-class-name="eAE.SecondaryTriage.SecondaryTriageManager"
*
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject"
*	local-class="eAE.SecondaryTriage.SecondaryTriageLocal"
*	remote-class="eAE.SecondaryTriage.SecondaryTriageRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome"
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eAE.SecondaryTriage.SecondaryTriageLocalHome"
*	remote-class="eAE.SecondaryTriage.SecondaryTriageHome"
*	generate= "local,remote"
*
*
*/
public class SecondaryTriageManager implements SessionBean {
	Connection con;
	PreparedStatement pstmt=null;
	PreparedStatement pstmt1=null;
	PreparedStatement pstmt2=null;
	PreparedStatement pstmt3=null;
	CallableStatement cstmt = null;

	int rs = 0;
	int rset1 = 0;
	int rset2 = 0;
	int rset3 = 0;


	HashMap results 	= new HashMap() ;
	StringBuffer sb  	= new StringBuffer("");

	StringBuffer UpAEPatE     =  null ;
	StringBuffer UpPREnc      =  null ;
	StringBuffer UpPREncOth   =  null ;
	StringBuffer UpOPPatQ     =  null;
	StringBuffer InAEMovement =  null;
	//Below line added for this CRF AAKH-CRF-0010 [IN038535]
	StringBuffer UpOPLastVisit =  null;
	PreparedStatement psmtLastVisit=null;
	int lastvisit = 0;
	
	String cs="";

	String dis_regn_reference		=  "";
	String ambulatory_status		=  "";
	String encounter_type			= "";
	String ae_encounter_type		= "";
	String complaint_code			= "";
	String referral_id 			= "";
	String disaster_yn				= "";
	String surgical_yn				= "";
	String medical_yn				= "";
	String disaster_town_code		= "";
	String disaster_type_code		= "";
	String mech_injury_catg_code		= "";
	String mech_injury_subcatg_code	= "";
	String vehicle_involved1_code		= "";
	String vehicle_involved2_code		= "";

	//Added by Ashwini on 04-Apr-2017 for GDOH-CFR-0004.3
	String Vehicle_Reg_No1				= "";
	String Vehicle_Reg_No2				= "";

	String protective_device_code	 	= "";
	String pat_position_code			= "";
	String oscc_yn					= "";
	String mlc_case_yn				= "";
	String police_report_no			= "";
	String police_station_dtls		= "";
	String pregnant_yn				= "";
	String lmp_date				= "";
	String immunization_status		= "";
	String att_given_yn				= "";
	String devp_milestone_age_yn	= "";
	String im_upto_date_yn			= "";
	String menarche_yn				= "";
	String height					= "";
	String weight					= "";
	String circumference				= "";
	String cap_blood_sugar			= "";
	String fbc_yn					= "";
	String ecg_yn					= "";
	String dressing_yn				= "";
	String immobilization_code		= "";
	String priority11				= "";
	String CaseofTrauma_val			= "";
	String priority_code				= "";
	String bed_bay_no				= "";
	String clinic_code				= "";
	String added_by_id				= "";
	String added_at_ws_no			= "";
	String added_facility_id			= "";
	String modified_by_id			= "";
	String modified_at_ws_no		= "";
	String modified_facility_id		= "";
	String facility_id				= "";
	String encounter_id				= "";
	String patient_id				= "";
	String treatment_area_code		= "";
	String brought_dead			= "";
	String triage_remarks			= "";
	String modify_flag				= "";
	String rec_date_time			= "";
	String clinic_code2				= "";
	String practitioner_id			= "";
	String order_id					= "";
	String order_catalog_code3		= "";
	String sys_date_time		    = "";
	String record_date_time		    = ""; //Added for ML-MMOH-CRF-0656 by K V Shanmukh
	String isSecTrgBackDateTimeAppl = "";//Added for ML-MMOH-CRF-0656 by K V Shanmukh
	String episodeno                = "";
	String visitnum                 = "";
	String locale					= "";
	String date_time_accident		= "";
    String place_of_accident		= "";
	String prev_que_stat            = "";
	String attend_pract_id          = "";  //This line added for this CRF AAKH-CRF-0010 [IN038535]	
	String fivelevelapplyn          = "";  //This line added for this CRF AAKH-CRF-0010 [IN038535]	

	//Below line added for this CRF ML-MMOH-CRF-0654
	 String transport_mode="";
     String mode_of_arrival="";
     String accompany_by="";
     Boolean modeofTransfer=false;	 
	//End ML-MMOH-CRF-0654
	
	String OandGYn	= "N";//Added by Thamizh selvi on 16th Mar 2018 against ML-MMOH-CRF-0645
	
	/*Added by Thamizh selvi on 12th Apr 2018 against ML-MMOH-CRF-0651 Start*/
	String medication		= "";
	String intialMgmtOthers	= "";
	/*End*/
	/*Added by Ajay Hatwate for GHL-CRF-0650 on 12/07/2023 */
	String isMLCAppl = "false";
	String mlc_death = "";
	String outside_mlc_dtls = "";
	String date_of_mlc_capture = "";
	String mlc_remarks = "";
	/*End */

	boolean result 				= false;

	SessionContext ctx;
	public void ejbCreate() { }
	public void ejbRemove()  { }
	public void ejbActivate()   { }
	public void ejbPassivate()   { }

	public void setSessionContext (SessionContext sessioncontext)   {
		ctx = sessioncontext;
	}

	public void extractValue(java.util.HashMap ae_pr_encounter_add, java.util.HashMap ae_pr_encounter_oth_dtls,  java.util.HashMap ae_pat_emergency_dtls,  java.util.HashMap ae_pat_triage,  java.util.HashMap session_details){

		locale					=(String)session_details.get("locale");
		if(locale==null) locale="";
		ambulatory_status		= (String)ae_pr_encounter_add.get("ambulatory_status");
		if(ambulatory_status == null) ambulatory_status="";
		encounter_type		= (String)ae_pr_encounter_oth_dtls.get("encounter_type");
		if(encounter_type == null) encounter_type="";
		ae_encounter_type		= (String)ae_pat_emergency_dtls.get("ae_encounter_type");
		if(ae_encounter_type == null) ae_encounter_type="";
		complaint_code		= (String)ae_pat_emergency_dtls.get("complaint_code");
		if(complaint_code == null) complaint_code="";


		referral_id		= (String)ae_pat_emergency_dtls.get("referral_id");
		if(referral_id == null) referral_id="";

		dis_regn_reference		= (String)ae_pat_emergency_dtls.get("dis_regn_reference");
		if(dis_regn_reference == null) dis_regn_reference="";

		disaster_yn		= (String)ae_pat_emergency_dtls.get("disaster_yn");
		if(disaster_yn == null) disaster_yn="N";
		surgical_yn		= (String)ae_pat_emergency_dtls.get("surgical_yn");
		if(surgical_yn == null) surgical_yn="N";
		medical_yn		= (String)ae_pat_emergency_dtls.get("medical_yn");
		if(medical_yn == null) medical_yn="N";
		disaster_town_code		= (String)ae_pat_emergency_dtls.get("disaster_town_code");
		if(disaster_town_code == null) disaster_town_code="";
		disaster_type_code		= (String)ae_pat_emergency_dtls.get("disaster_type_code");
		if(disaster_type_code == null) disaster_type_code="";
		mech_injury_catg_code		= (String)ae_pat_emergency_dtls.get("mech_injury_catg_code");
		if(mech_injury_catg_code == null) mech_injury_catg_code="";
		mech_injury_subcatg_code		= (String)ae_pat_emergency_dtls.get("mech_injury_subcatg_code");
		if(mech_injury_subcatg_code == null) mech_injury_subcatg_code="";
		
		vehicle_involved1_code		= (String)ae_pat_emergency_dtls.get("vehicle_involved1_code");
		if(vehicle_involved1_code == null) vehicle_involved1_code="";
		
		vehicle_involved2_code		= (String)ae_pat_emergency_dtls.get("vehicle_involved2_code");
		if(vehicle_involved2_code == null) vehicle_involved2_code="";
		
		//Added by Ashwini on 04-Apr-2017 for GDOH-CFR-0004.3
		Vehicle_Reg_No1		= (String)ae_pat_emergency_dtls.get("Vehicle_Reg_No1");
		if(Vehicle_Reg_No1 == null) Vehicle_Reg_No1="";
		
		Vehicle_Reg_No2		= (String)ae_pat_emergency_dtls.get("Vehicle_Reg_No2");
		if(Vehicle_Reg_No2 == null) Vehicle_Reg_No2="";
		
		protective_device_code		= (String)ae_pat_emergency_dtls.get("protective_device_code");
		if(protective_device_code == null) protective_device_code="";
		pat_position_code		= (String)ae_pat_emergency_dtls.get("pat_position_code");
		if(pat_position_code == null) pat_position_code="";
		oscc_yn		= (String)ae_pat_emergency_dtls.get("oscc_yn");
		if(oscc_yn == null) oscc_yn="N";
		mlc_case_yn		= (String)ae_pat_emergency_dtls.get("mlc_case_yn");
		if(mlc_case_yn == null) mlc_case_yn="N";
		police_report_no		= (String)ae_pat_emergency_dtls.get("police_report_no");
		if(police_report_no == null) police_report_no="";
		police_station_dtls		= (String)ae_pat_emergency_dtls.get("police_stat_detail");
		if(police_station_dtls == null) police_station_dtls="";
		pregnant_yn		= (String)ae_pat_emergency_dtls.get("pregnant_yn");
		if(pregnant_yn == null) pregnant_yn="N";
		lmp_date		= (String)ae_pat_emergency_dtls.get("lmp_date");
		if(lmp_date == null) lmp_date="";
		immunization_status		= (String)ae_pat_emergency_dtls.get("immunization_status");
		if(immunization_status == null) immunization_status="";
		att_given_yn		= (String)ae_pat_emergency_dtls.get("att_given_yn");
		if(att_given_yn == null) att_given_yn="N";
		devp_milestone_age_yn		= (String)ae_pat_emergency_dtls.get("devp_milestone_age_yn");
		if(devp_milestone_age_yn == null) devp_milestone_age_yn="N";
		im_upto_date_yn		= (String)ae_pat_emergency_dtls.get("im_upto_date_yn");
		if(im_upto_date_yn == null) im_upto_date_yn="N";
		menarche_yn		= (String)ae_pat_emergency_dtls.get("menarche_yn");
		if(menarche_yn == null) menarche_yn="N";
		height		= (String)ae_pat_emergency_dtls.get("height");
		if(height == null) height="";
		weight		= (String)ae_pat_emergency_dtls.get("weight");
		if(weight == null) weight="";
		circumference		= (String)ae_pat_emergency_dtls.get("circumference");
		if(circumference == null) circumference="";
		cap_blood_sugar		= (String)ae_pat_emergency_dtls.get("cap_blood_sugar");
		if(cap_blood_sugar == null) cap_blood_sugar="";
		fbc_yn		= (String)ae_pat_emergency_dtls.get("fbc_yn");
		if(fbc_yn == null) fbc_yn="N";
		ecg_yn		= (String)ae_pat_emergency_dtls.get("ecg_yn");
		if(ecg_yn == null) ecg_yn="N";
		dressing_yn		= (String)ae_pat_emergency_dtls.get("dressing_yn");
		if(dressing_yn == null) dressing_yn="N";
		immobilization_code		= (String)ae_pat_emergency_dtls.get("immobilization_code");
		if(immobilization_code == null) immobilization_code="N";
		priority11		= (String)ae_pat_emergency_dtls.get("priority11");
		if(priority11 == null) priority11="N";
		CaseofTrauma_val		= (String)ae_pat_emergency_dtls.get("CaseofTrauma_val");
		if(CaseofTrauma_val == null)  	 CaseofTrauma_val="N";
		priority_code		= (String)ae_pat_triage.get("priority_code");
		if(priority_code == null) priority_code="";
		bed_bay_no		= (String)ae_pat_triage.get("bed_bay_no");
		if(bed_bay_no == null) bed_bay_no="";
		clinic_code		= (String)ae_pat_triage.get("clinic_code");
		if(clinic_code == null) clinic_code="";
		/*Below line added for this CRF AAKH-CRF-0010 [IN038535]*/
		attend_pract_id		= (String)ae_pat_triage.get("attend_pract_id");
		if(attend_pract_id == null) attend_pract_id="";			
		fivelevelapplyn		= (String)ae_pat_triage.get("fivelevelapplyn"); 
		if(fivelevelapplyn == null) fivelevelapplyn="N";
        //End CRF		
		
		added_by_id		= (String)session_details.get("added_by_id");
		if(added_by_id==null)  added_by_id="";
		added_at_ws_no		= (String)session_details.get("added_at_ws_no");
		if(added_at_ws_no==null)  added_at_ws_no="";
		added_facility_id		= (String)session_details.get("added_facility_id");
		if(added_facility_id==null) added_facility_id="";
		modified_by_id		= (String)session_details.get("modified_by_id");
		if(modified_by_id==null) modified_by_id="";
		modified_at_ws_no		= (String)session_details.get("modified_at_ws_no");
		if(modified_at_ws_no==null) modified_at_ws_no="";
		modified_facility_id		= (String)session_details.get("modified_facility_id");
		if(modified_facility_id==null) modified_facility_id="";
		facility_id		= (String)session_details.get("facility_id");
		if(facility_id==null) 	facility_id="";
		encounter_id		= (String)session_details.get("encounter_id");
		if(encounter_id==null) encounter_id="";
		patient_id		= (String)session_details.get("patient_id");
		if(patient_id==null) 	patient_id="";
		treatment_area_code		= (String)ae_pat_triage.get("treatment_area_code");
		if(treatment_area_code==null) treatment_area_code="";
		brought_dead		= (String)ae_pat_triage.get("brought_dead");
		if(brought_dead == null || brought_dead.equals("null") || brought_dead == "" || brought_dead.equals(""))   brought_dead  = "N";
		triage_remarks		= (String)ae_pat_emergency_dtls.get("triage_remarks");
		if(triage_remarks == null) triage_remarks="";
		modify_flag		= (String)ae_pat_emergency_dtls.get("modify_flag");
		if(modify_flag == null) modify_flag="";
		rec_date_time		= (String)ae_pat_emergency_dtls.get("rec_date_time");
		if(rec_date_time == null) rec_date_time="";
		sys_date_time       = (String)ae_pat_emergency_dtls.get("sys_date_time");
		if(sys_date_time == null) sys_date_time="";
		//Added for ML-MMOH-CRF-0656 by K V Shanmukh
		isSecTrgBackDateTimeAppl=(String)ae_pat_emergency_dtls.get("isSecTrgBackDateTimeAppl");
		if(isSecTrgBackDateTimeAppl == null) isSecTrgBackDateTimeAppl="";
		record_date_time       = (String)ae_pat_emergency_dtls.get("record_date_time");
		if(record_date_time == null) record_date_time="";
		//end
		clinic_code2     		= (String) ae_pat_emergency_dtls.get("clinic_code");
		practitioner_id		= (String) ae_pat_emergency_dtls.get("practitioner_id");
		order_id			= (String)ae_pat_emergency_dtls.get("order_id");
		order_catalog_code3=(String)ae_pat_emergency_dtls.get("order_catalog_code3");
		episodeno            = (String)ae_pat_emergency_dtls.get("episode_id");
	    visitnum              =(String)ae_pat_emergency_dtls.get("visit_num");
        date_time_accident		= (String)ae_pat_emergency_dtls.get("date_time_accident");
        place_of_accident		= (String)ae_pat_emergency_dtls.get("place_of_accident");
		
		//Below line added for this CRF ML-MMOH-CRF-0654
		transport_mode	= (String)ae_pat_emergency_dtls.get("transport_mode");
		if(transport_mode==null) transport_mode="";
		mode_of_arrival	= (String)ae_pat_emergency_dtls.get("mode_of_arrival");
		if(mode_of_arrival==null) mode_of_arrival="";
		accompany_by = (String)ae_pat_emergency_dtls.get("accompany_by");
		if(accompany_by==null) accompany_by="";
		//End this CRF ML-MMOH-CRF-0654

		OandGYn	= checkNullWithDftValue((String)ae_pat_emergency_dtls.get("OandGYn"),"N");//Added by Thamizh selvi on 16th Mar 2018 against ML-MMOH-CRF-0645
		
		/*Added by Thamizh selvi on 12th Apr 2018 against ML-MMOH-CRF-0651 Start*/
		medication			= checkForNull((String)ae_pat_emergency_dtls.get("medication"));
		intialMgmtOthers	= checkForNull((String)ae_pat_emergency_dtls.get("intialMgmtOthers"));
		/*End*/

		/*Added by Ajay Hatwate for GHL-CRF-0650 as on 12/07/2023*/
			isMLCAppl = checkForNull((String) ae_pat_emergency_dtls.get("isMLCAppl"));
			if(isMLCAppl.equals("true")) {
			mlc_death = checkNullWithDftValue((String) ae_pat_emergency_dtls.get("mlc_death"), "N");
			outside_mlc_dtls = checkForNull((String) ae_pat_emergency_dtls.get("outside_mlc_dtls"));
			date_of_mlc_capture = checkForNull((String) ae_pat_emergency_dtls.get("date_of_mlc_capture"));
			mlc_remarks = checkForNull((String) ae_pat_emergency_dtls.get("mlc_remarks"));
			}
		/*End*/
		ae_pr_encounter_add.clear();		ae_pr_encounter_oth_dtls.clear();
		ae_pat_emergency_dtls.clear();	ae_pat_triage.clear();
		session_details.clear();
	}
	/**
	 *Method to insert SecondaryTriage
	 *@param properties Connection Properties
	 *@param hashaMap PR Encounter Data
	 *@param hashaMap AE Patient Emergency Details
	 *@param hashaMap Patient Triage Details
	 *@param hashaMap Session Details
	 *@return HashMap holding the transaction details
	*/
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/



	public java.util.HashMap insertSecondaryTriage(Properties p,  java.util.HashMap ae_pr_encounter_add, java.util.HashMap ae_pr_encounter_oth_dtls,  java.util.HashMap ae_pat_emergency_dtls,  java.util.HashMap ae_pat_triage,  java.util.HashMap session_details) {
		try {
			extractValue(ae_pr_encounter_add, ae_pr_encounter_oth_dtls,   ae_pat_emergency_dtls,  ae_pat_triage,  session_details);
			con = ConnectionManager.getConnection(p);
			con.setAutoCommit(false);
			if((sb != null) && (sb.length() > 0))
				sb.delete(0,sb.length());

			String queue_status="";
			//Added for this CRF ML-MMOH-CRF-0654
			modeofTransfer=CommonBean.isSiteSpecific(con, "AE","SECONDARY_TRIAGE");

				try{

				if (mlc_case_yn.equals("Y")) {

			        UpPREnc = new StringBuffer();
			        UpPREnc.append("UPDATE PR_ENCOUNTER SET ");
					UpPREnc.append(" AMBULATORY_STATUS = ?, MLC_YN  = ?,");
					UpPREnc.append(" POL_STN_ID = ?,POL_REP_NO = ?,");
					UpPREnc.append(" MARKED_BY_ID= ?, MARKED_DATE=sysdate,");
					UpPREnc.append(" PRIORITY_ZONE=?,TREATMENT_AREA_CODE=?,");
					UpPREnc.append(" BROUGHT_DEAD_YN=?,ASSIGN_BED_NUM=?, ");
					UpPREnc.append(" DISASTER_YN = ?,DISASTER_TOWN_CODE	= ?, ");
					UpPREnc.append(" DISASTER_TYPE_CODE=? ,MEDICAL_YN=?,SURGICAL_YN=?, ");
					UpPREnc.append(" TRAUMA_YN=?,MECH_INJURY_CATG_CODE=?, ");
					UpPREnc.append(" MECH_INJURY_SUBCATG_CODE = ?, ");
					UpPREnc.append(" DATE_TIME_OF_ACCIDENT = to_date(?,'dd/mm/rrrr hh24:mi'), ");
					UpPREnc.append(" PLACE_OF_ACCIDENT = ?, ");
					UpPREnc.append(" COMPLAINT_CODE = ?, ");
					UpPREnc.append(" REFERRAL_ID = ? , OSCC_YN=? ");
					/*Added by Dharma for AUDIT COLUMNS update Start*/
					UpPREnc.append(" ,MODIFIED_BY_ID= ?, ");
					UpPREnc.append(" MODIFIED_AT_WS_NO= ?, ");					
					UpPREnc.append(" MODIFIED_DATE = sysdate, ");
					UpPREnc.append(" MODIFIED_FACILITY_ID= ? ");
					/*Added by Dharma for AUDIT COLUMNS update End*/
					if(fivelevelapplyn.equals("Y")&&!attend_pract_id.equals(""))
					UpPREnc.append(", ATTEND_PRACTITIONER_ID = ?"); //added AAKH-CRF-0010 [IN038535]
					/*Tuesday, January 18, 2011 ,  SRR20056-SCF-6415 [IN:025852]*/
					//UpPREnc.append(", MARKED_BY_ID ='"+modified_by_id+"', MARKED_DATE = sysdate ");
					/* SRR20056-SCF-6415 [IN:025852] end*/
						
					/*Added by Rameswar on 28-Nov-15 for GDOH-CRF-0004.1*/
					UpPREnc.append(", VEHICLE_INVOLVED1_CODE = ? ");
					UpPREnc.append(", VEHICLE_INVOLVED2_CODE = ? ");
					UpPREnc.append(", PAT_POSITION_CODE = ?     " );
					/*Added by Rameswar on 28-Nov-15 for GDOH-CRF-0004.1*/

					
					UpPREnc.append(", PROTECTIVE_DEVICE_CODE = ? ");/*Added by Rameswar on 04-Oct-16 for GDOH-CRF-0004.2*/

					//Added by Ashwini on 04-Apr-2017 for GDOH-CFR-0004.3
					UpPREnc.append(", VEHICLE_REG_NO1 = ? ");
					UpPREnc.append(", VEHICLE_REG_NO2 = ? ");
					
					//Added by Sangeetha for ML-MMOH-CRF-0654 on 17/may/17
					UpPREnc.append(", TRANSPORT_MODE = ?, ARRIVAL_CODE = ?, ACCOMPANIED_BY_CODE = ?, O_AND_G_YN = ? ");//Modified by Thamizh selvi on 16th Mar 2018 against ML-MMOH-CRF-0645 --O_AND_G_YN
					//Added by Ajay Hatwate for GHL-CRF-0650
					if(isMLCAppl.equals("true")){
						UpPREnc.append(", mlc_death_yn=?, MLC_REMARKS=?, MLC_CAPTURE_DATE=to_date(?,'DD/MM/YYYY HH24:MI:SS'), MLC_NO_OUTSIDE_DTLS=?");
					}

					UpPREnc.append(" WHERE FACILITY_ID = ? AND ENCOUNTER_ID = ? ");

				 	if(pstmt1!=null) pstmt1.close();pstmt1=null;
					pstmt1	= con.prepareStatement(UpPREnc.toString());
					pstmt1.setString(1,ambulatory_status);			pstmt1.setString(2,mlc_case_yn);
					pstmt1.setString(3,police_station_dtls);			pstmt1.setString(4,police_report_no);
					pstmt1.setString(5,modified_by_id);			pstmt1.setString(6,priority_code);
					pstmt1.setString(7,treatment_area_code);		pstmt1.setString(8,brought_dead);
					pstmt1.setString(9,bed_bay_no);				pstmt1.setString(10,disaster_yn);
					pstmt1.setString(11,disaster_town_code);		pstmt1.setString(12,disaster_type_code);
					pstmt1.setString(13,medical_yn);				pstmt1.setString(14,surgical_yn);
					pstmt1.setString(15,CaseofTrauma_val);		pstmt1.setString(16,mech_injury_catg_code);
					pstmt1.setString(17,mech_injury_subcatg_code);
					pstmt1.setString(18,date_time_accident);
					pstmt1.setString(19,place_of_accident);
					pstmt1.setString(20,complaint_code);
					pstmt1.setString(21,referral_id);
					pstmt1.setString(22,oscc_yn);
					/*Added by Dharma for AUDIT COLUMNS update Start*/
					pstmt1.setString(23,modified_by_id);
					pstmt1.setString(24,added_at_ws_no);
					pstmt1.setString(25,modified_facility_id);
					/*Added by Dharma for AUDIT COLUMNS update End*/
					/*Below line added for the CRF AAKH-CRF-0010 [IN038535]*/
					if(fivelevelapplyn.equals("Y")&&!attend_pract_id.equals("")){
					    pstmt1.setString(26,attend_pract_id); 
						/*Added by Rameswar on 28-Nov-15 for GDOH-CRF-0004.1*/
						pstmt1.setString(27,vehicle_involved1_code);
						pstmt1.setString(28,vehicle_involved2_code);
						pstmt1.setString(29,pat_position_code);
						/*Added by Rameswar on 28-Nov-15 for GDOH-CRF-0004.1*/

						pstmt1.setString(30,protective_device_code);/*Added by Rameswar on 04-oct-16 for GDOH-CRF-0004.2*/

						//Added by Ashwini on 04-Apr-2017 for GDOH-CFR-0004.3
						pstmt1.setString(31,Vehicle_Reg_No1);
						pstmt1.setString(32,Vehicle_Reg_No2);

						//Added by Sangeetha for ML-MMOH-CRF-0654 on 17/may/17
						pstmt1.setString(33,transport_mode);
						pstmt1.setString(34,mode_of_arrival);
						pstmt1.setString(35,accompany_by);
						
						pstmt1.setString(36,OandGYn);//Added by Thamizh selvi on 16th Mar 2018 against ML-MMOH-CRF-0645
						if(isMLCAppl.equals("true")){//Added by Ajay Hatwate for GHL-CRF-0650
							pstmt1.setString(37,mlc_death);
							pstmt1.setString(38,mlc_remarks);
							pstmt1.setString(39,date_of_mlc_capture);
							pstmt1.setString(40,outside_mlc_dtls);
							pstmt1.setString(41,facility_id);
							pstmt1.setString(42,encounter_id);
						}else{
					    pstmt1.setString(37,facility_id);
					    pstmt1.setString(38,encounter_id);
						}
					}else{
						/*Added by Rameswar on 28-Nov-15 for GDOH-CRF-0004.1*/
						pstmt1.setString(26,vehicle_involved1_code);
						pstmt1.setString(27,vehicle_involved2_code);
						pstmt1.setString(28,pat_position_code);
						/*Added by Rameswar on 28-Nov-15 for GDOH-CRF-0004.1*/

						pstmt1.setString(29,protective_device_code);/*Added by Rameswar on 04-oct-16 for GDOH-CRF-0004.2*/

						//Added by Ashwini on 04-Apr-2017 for GDOH-CFR-0004.3
						pstmt1.setString(30,Vehicle_Reg_No1);
						pstmt1.setString(31,Vehicle_Reg_No2);

						//Added by Sangeetha for ML-MMOH-CRF-0654 on 17/may/17
						pstmt1.setString(32,transport_mode);
						pstmt1.setString(33,mode_of_arrival);
						pstmt1.setString(34,accompany_by);

						pstmt1.setString(35,OandGYn);//Added by Thamizh selvi on 16th Mar 2018 against ML-MMOH-CRF-0645

						//Added by Ajay Hatwate for GHL-CRF-650 as on 12-07-2023
						if(isMLCAppl.equals("true")){
							pstmt1.setString(36,mlc_death);
							pstmt1.setString(37,mlc_remarks);
							pstmt1.setString(38,date_of_mlc_capture);
							pstmt1.setString(39,outside_mlc_dtls);
							pstmt1.setString(40,facility_id);
							pstmt1.setString(41,encounter_id);
						}else{
						pstmt1.setString(36,facility_id);
					    pstmt1.setString(37,encounter_id);
						}
					}
					//End AAKH-CRF-0010 [IN038535]
					
				} else if (mlc_case_yn.equals("N")) {
					UpPREnc = new StringBuffer();
					UpPREnc.append("UPDATE PR_ENCOUNTER SET ");
					UpPREnc.append(" AMBULATORY_STATUS = ?, ");
					UpPREnc.append(" PRIORITY_ZONE =?,TREATMENT_AREA_CODE=?,");
					UpPREnc.append(" BROUGHT_DEAD_YN=? ,ASSIGN_BED_NUM=? ,");
					UpPREnc.append(" DISASTER_YN = ?,DISASTER_TOWN_CODE	= ?, ");
					UpPREnc.append(" DISASTER_TYPE_CODE=? ,MEDICAL_YN=?,SURGICAL_YN=?, ");
					UpPREnc.append(" TRAUMA_YN=?,MECH_INJURY_CATG_CODE=?, ");
					UpPREnc.append(" MECH_INJURY_SUBCATG_CODE = ? ,");
					UpPREnc.append(" DATE_TIME_OF_ACCIDENT = to_date(?,'dd/mm/rrrr hh24:mi'), ");
					UpPREnc.append(" PLACE_OF_ACCIDENT = ?, ");
					UpPREnc.append(" COMPLAINT_CODE = ?, ");
					UpPREnc.append(" REFERRAL_ID = ?, ");
					UpPREnc.append(" OSCC_YN=? ");
					/*Added by Dharma for AUDIT COLUMNS update Start*/
					UpPREnc.append(" ,MODIFIED_BY_ID= ?, ");
					UpPREnc.append(" MODIFIED_AT_WS_NO= ?, ");					
					UpPREnc.append(" MODIFIED_DATE = sysdate, ");
					UpPREnc.append(" MODIFIED_FACILITY_ID= ? ");
					/*Added by Dharma for AUDIT COLUMNS update End*/
					if(fivelevelapplyn.equals("Y")&&!attend_pract_id.equals(""))
					UpPREnc.append(", ATTEND_PRACTITIONER_ID = ? "); //added AAKH-CRF-0010 [IN038535]
					/*Tuesday, January 18, 2011 ,  SRR20056-SCF-6415 [IN:025852]*/
					UpPREnc.append(" , MLC_YN = '"+mlc_case_yn+"', MARKED_BY_ID ='', MARKED_DATE = '' ");
					/* SRR20056-SCF-6415 [IN:025852] end*/
					/*Added by Ajay Hatwate for GHL-CRF-0650 on 25/07/2023 */
					if(isMLCAppl.equals("true")){
						UpPREnc.append(", mlc_death_yn='N', MLC_REMARKS='', MLC_CAPTURE_DATE='', MLC_NO_OUTSIDE_DTLS='', POL_STN_ID = '',POL_REP_NO = ''");
					}

					/*Added by Rameswar on 28-Nov-15 for GDOH-CRF-0004.1*/
					UpPREnc.append(", VEHICLE_INVOLVED1_CODE = ? ");
					UpPREnc.append(", VEHICLE_INVOLVED2_CODE = ? ");
					UpPREnc.append(", PAT_POSITION_CODE = ? ");
					/*Added by Rameswar on 28-Nov-15 for GDOH-CRF-0004.1*/

					UpPREnc.append(", PROTECTIVE_DEVICE_CODE = ? "); /*Added by Rameswar on 04-Oct-16 for GDOH-CRF-0004.2*/

					//Added by Ashwini on 04-Apr-2017 for GDOH-CFR-0004.3
					UpPREnc.append(", VEHICLE_REG_NO1 = ? ");
					UpPREnc.append(", VEHICLE_REG_NO2 = ? ");

					//Added by Sangeetha for ML-MMOH-CRF-0654 on 17/may/17
					UpPREnc.append(", TRANSPORT_MODE = ?, ARRIVAL_CODE = ?, ACCOMPANIED_BY_CODE = ?, O_AND_G_YN = ?");//Modified by Thamizh selvi on 16th Mar 2018 against ML-MMOH-CRF-0645 --O_AND_G_YN

					UpPREnc.append(" WHERE FACILITY_ID = ? AND ENCOUNTER_ID = ? ");

					if(pstmt1!=null) pstmt1.close();pstmt1=null;

			    	pstmt1	= con.prepareStatement(UpPREnc.toString());
					pstmt1.setString(1,ambulatory_status);			pstmt1.setString(2,priority_code);
					pstmt1.setString(3,treatment_area_code);		pstmt1.setString(4,brought_dead);
					pstmt1.setString(5,bed_bay_no);				pstmt1.setString(6,disaster_yn);
					pstmt1.setString(7,disaster_town_code);		pstmt1.setString(8,disaster_type_code);
					pstmt1.setString(9,medical_yn);				pstmt1.setString(10,surgical_yn);
					pstmt1.setString(11,CaseofTrauma_val);		pstmt1.setString(12,mech_injury_catg_code);
					pstmt1.setString(13,mech_injury_subcatg_code);
					pstmt1.setString(14,date_time_accident);
					pstmt1.setString(15,place_of_accident);
					pstmt1.setString(16,complaint_code);
					pstmt1.setString(17,referral_id);
					pstmt1.setString(18,oscc_yn);
					/*Added by Dharma for AUDIT COLUMNS update Start*/
					pstmt1.setString(19,modified_by_id);
					pstmt1.setString(20,added_at_ws_no);
					pstmt1.setString(21,modified_facility_id);
					/*Added by Dharma for AUDIT COLUMNS update End*/

					/*Added below line for the CRF AAKH-CRF-0010 [IN038535]*/
					if(fivelevelapplyn.equals("Y")&&!attend_pract_id.equals("")){
					   pstmt1.setString(22,attend_pract_id); 
						
						/*Added by Rameswar on 28-Nov-15 for GDOH-CRF-0004.1*/
						pstmt1.setString(23,vehicle_involved1_code);
						pstmt1.setString(24,vehicle_involved2_code);
						pstmt1.setString(25,pat_position_code);
						/*Added by Rameswar on 28-Nov-15 for GDOH-CRF-0004.1*/

						pstmt1.setString(26,protective_device_code);/*Added by Rameswar on 04-Oct-16 for GDOH-CRF-0004.2*/

						//Added by Ashwini on 04-Apr-2017 for GDOH-CFR-0004.3
						pstmt1.setString(27,Vehicle_Reg_No1);
						pstmt1.setString(28,Vehicle_Reg_No2);

						//Added by Sangeetha for ML-MMOH-CRF-0654 on 17/may/17
						pstmt1.setString(29,transport_mode);
						pstmt1.setString(30,mode_of_arrival);
						pstmt1.setString(31,accompany_by);

						pstmt1.setString(32,OandGYn);//Added by Thamizh selvi on 16th Mar 2018 against ML-MMOH-CRF-0645

					   pstmt1.setString(33,facility_id);
					   pstmt1.setString(34,encounter_id);
					}else{
						/*Added by Rameswar on 28-Nov-15 for GDOH-CRF-0004.1*/
						pstmt1.setString(22,vehicle_involved1_code);
						pstmt1.setString(23,vehicle_involved2_code);
						pstmt1.setString(24,pat_position_code);
						/*Added by Rameswar on 28-Nov-15 for GDOH-CRF-0004.1*/

						pstmt1.setString(25,protective_device_code);/*Added by Rameswar on 04-Oct-16 for GDOH-CRF-0004.2*/

						//Added by Ashwini on 04-Apr-2017 for GDOH-CFR-0004.3
						pstmt1.setString(26,Vehicle_Reg_No1);
						pstmt1.setString(27,Vehicle_Reg_No2);

						//Added by Sangeetha for ML-MMOH-CRF-0654 on 17/may/17
						pstmt1.setString(28,transport_mode);
						pstmt1.setString(29,mode_of_arrival);
						pstmt1.setString(30,accompany_by);

						pstmt1.setString(31,OandGYn);//Added by Thamizh selvi on 16th Mar 2018 against ML-MMOH-CRF-0645

					   pstmt1.setString(32,facility_id);
					   pstmt1.setString(33,encounter_id);
					}
					//End AAKH-CRF-0010 [IN038535]
					
				}
				rset1 =  pstmt1.executeUpdate();
				if(rset1 > 0) result	=	true;
				else  result	=	false;

				if((UpPREnc != null) && (UpPREnc.length() > 0)) { UpPREnc.delete(0,UpPREnc.length()); }
				if(pstmt1!=null) pstmt1.close();pstmt1=null;
			}catch(Exception e){e.printStackTrace();
				result =false;
				sb.append("PR_ENCOUNTER :"+e);
            }

		if(result) {
			try {
				pstmt3	= con.prepareStatement("select queue_status from op_patient_queue where facility_id=?  and encounter_id=?");
				pstmt3.setString(1,facility_id);
				pstmt3.setString(2,encounter_id);
				ResultSet rs1=pstmt3.executeQuery();
				if(rs1.next())
				{
				prev_que_stat=rs1.getString("queue_status");
				}
				if(rs1!=null)rs1.close();
                if(pstmt3!=null)pstmt3.close();pstmt3=null;
				if(prev_que_stat.equals("04"))
				{
				queue_status=prev_que_stat;
				}else
				{
				if (!treatment_area_code.equals("")) queue_status ="02";
				else 	queue_status ="01";
				}
				//if (!treatment_area_code.equals("")) {

					UpOPPatQ = new StringBuffer();
					UpOPPatQ.append("UPDATE OP_PATIENT_QUEUE SET PRIORITY_ZONE = ?, ");
					UpOPPatQ.append(" TREATMENT_AREA_CODE=?,QUEUE_STATUS  =?,");
					UpOPPatQ.append(" TRAUMA_YN =?, AE_REMARKS = ?, ");
					UpOPPatQ.append(" AE_BED_NO =?,OSCC_YN=?,SURGICAL_YN=?,");
					UpOPPatQ.append(" MEDICAL_YN=?,MECH_INJURY_CATG_CODE=?,");
			        UpOPPatQ.append(" MECH_INJURY_SUBCATG_CODE=?,");
					UpOPPatQ.append(" MLC_YN = ?, DISASTER_TYPE_CODE = ?, ");
					UpOPPatQ.append(" BROUGHT_DEAD_YN= ?,DISASTER_YN= ?,");
					UpOPPatQ.append(" DISASTER_TOWN_CODE= ?, ");
					
					UpOPPatQ.append(" PAT_PRIORITY= ?,");
					UpOPPatQ.append(" DATE_TIME_OF_ACCIDENT= to_date(?,'dd/mm/rrrr hh24:mi'),");
					UpOPPatQ.append(" PLACE_OF_ACCIDENT= ?, ");
					UpOPPatQ.append(" COMPLAINT_CODE= ?, ");
					UpOPPatQ.append(" REFERRAL_ID= ?, ");					
					UpOPPatQ.append(" DIS_REGN_REFERENCE= ?, ");
					/*Below line added for this CRF AAKH-CRF-0010 [IN038535]*/
					UpOPPatQ.append(" MODIFIED_BY_ID= ?, ");
					UpOPPatQ.append(" MODIFIED_AT_WS_NO= ?, ");					
					UpOPPatQ.append(" MODIFIED_DATE = sysdate, ");
					UpOPPatQ.append(" MODIFIED_FACILITY_ID= ? ");					
					if(fivelevelapplyn.equals("Y")&&!attend_pract_id.equals(""))
					UpOPPatQ.append(", practitioner_id = ? ");
					//End AAKH-CRF-0010 [IN038535]

					/*Added by Rameswar on 28-Nov-15 for GDOH-CRF-0004.1*/
					UpOPPatQ.append(", VEHICLE_INVOLVED1_CODE  = ? ");
					UpOPPatQ.append(", VEHICLE_INVOLVED2_CODE  = ? ");
					UpOPPatQ.append(", PAT_POSITION_CODE  = ? ");
					/*Added by Rameswar on 28-Nov-15 for GDOH-CRF-0004.1*/

					UpOPPatQ.append(", PROTECTIVE_DEVICE_CODE  = ? ");/*Added by Rameswar on 04-Oct-16 for GDOH-CRF-0004.2*/

					//Added by Ashwini on 04-Apr-2017 for GDOH-CFR-0004.3
					UpOPPatQ.append(", VEHICLE_REG_NO1  = ? ");
					UpOPPatQ.append(", VEHICLE_REG_NO2  = ? ");

					//Added by Sangeetha for ML-MMOH-CRF-0654 on 17/may/17
					UpOPPatQ.append(", TRANSPORT_MODE = ?, ARRIVAL_CODE = ?, ACCOMPANIED_BY_CODE = ?, O_AND_G_YN = ?");//Modified by Thamizh selvi on 16th Mar 2018 against ML-MMOH-CRF-0645 --O_AND_G_YN
					
					if (!treatment_area_code.equals("")){
						UpOPPatQ.append(" , assign_tmt_area_time = NVL(assign_tmt_area_time,SYSDATE) ");//Added by Thamizh selvi on 8th Dec 2017 against Inc:66039
					}
                    // Added for ML-MMOH-CRF-0656 by K V Shanmukh
					
					if(isSecTrgBackDateTimeAppl.equals("true")){
						
						UpOPPatQ.append(" , TRIAGE_DATE_TIME=NVL(TRIAGE_DATE_TIME,to_date('"+record_date_time+"','dd/mm/rrrr hh24:mi:ss'))");
						
					}else{
					UpOPPatQ.append(" , TRIAGE_DATE_TIME=NVL(TRIAGE_DATE_TIME,SYSDATE)");}
					//end
					UpOPPatQ.append(" WHERE ENCOUNTER_ID = ?  and FACILITY_ID=?");
					pstmt3	= con.prepareStatement(UpOPPatQ.toString());
					pstmt3.setString(1,priority_code);
					pstmt3.setString(2,treatment_area_code);
					pstmt3.setString(3,queue_status);
					pstmt3.setString(4,CaseofTrauma_val);
					pstmt3.setString(5,triage_remarks);
					pstmt3.setString(6,bed_bay_no);
					pstmt3.setString(7,oscc_yn);
					pstmt3.setString(8,surgical_yn);
					pstmt3.setString(9,medical_yn);
					pstmt3.setString(10,mech_injury_catg_code);
					pstmt3.setString(11,mech_injury_subcatg_code);
				        pstmt3.setString(12,mlc_case_yn);
					pstmt3.setString(13,disaster_type_code);
					pstmt3.setString(14,brought_dead);
					pstmt3.setString(15,disaster_yn);
					pstmt3.setString(16,disaster_town_code);
					pstmt3.setString(17,priority11);
					pstmt3.setString(18,date_time_accident);
					pstmt3.setString(19,place_of_accident);
					pstmt3.setString(20,complaint_code);
					pstmt3.setString(21,referral_id);
					pstmt3.setString(22,dis_regn_reference);
					/*Below line added for this CRF AAKH-CRF-0010 [IN038535]*/
					pstmt3.setString(23,modified_by_id); 		
					pstmt3.setString(24,modified_at_ws_no);
					pstmt3.setString(25,modified_facility_id);
					if(fivelevelapplyn.equals("Y")&&!attend_pract_id.equals("")){
					pstmt3.setString(26,attend_pract_id);
					/*Added by Rameswar on 28-Nov-15 for GDOH-CRF-0004.1*/
					pstmt3.setString(27,vehicle_involved1_code);
					pstmt3.setString(28,vehicle_involved2_code);
					pstmt3.setString(29,pat_position_code);
					/*Added by Rameswar on 28-Nov-15 for GDOH-CRF-0004.1*/

					pstmt3.setString(30,protective_device_code);	/*Added by Rameswar on 04-Oct-16 for GDOH-CRF-0004.2*/

					//Added by Ashwini on 04-Apr-2017 for GDOH-CFR-0004.3
					pstmt3.setString(31,Vehicle_Reg_No1);
					pstmt3.setString(32,Vehicle_Reg_No2);

					//Added by Sangeetha for ML-MMOH-CRF-0654 on 17/may/17
					pstmt3.setString(33,transport_mode);
					pstmt3.setString(34,mode_of_arrival);
					pstmt3.setString(35,accompany_by);

					pstmt3.setString(36,OandGYn);//Added by Thamizh selvi on 16th Mar 2018 against ML-MMOH-CRF-0645
                   
					pstmt3.setString(37,encounter_id);
					pstmt3.setString(38,facility_id);
					}else{
					/*Added by Rameswar on 28-Nov-15 for GDOH-CRF-0004.1*/
					pstmt3.setString(26,vehicle_involved1_code);
					pstmt3.setString(27,vehicle_involved2_code);
					pstmt3.setString(28,pat_position_code);
					/*Added by Rameswar on 28-Nov-15 for GDOH-CRF-0004.1*/

					pstmt3.setString(29,protective_device_code);	/*Added by Rameswar on 04-Oct-16 for GDOH-CRF-0004.2*/

					//Added by Ashwini on 04-Apr-2017 for GDOH-CFR-0004.3
					pstmt3.setString(30,Vehicle_Reg_No1);
					pstmt3.setString(31,Vehicle_Reg_No2);

					//Added by Sangeetha for ML-MMOH-CRF-0654 on 17/may/17
					pstmt3.setString(32,transport_mode);
					pstmt3.setString(33,mode_of_arrival);
					pstmt3.setString(34,accompany_by);

					pstmt3.setString(35,OandGYn);//Added by Thamizh selvi on 16th Mar 2018 against ML-MMOH-CRF-0645
                   
					pstmt3.setString(36,encounter_id);
					pstmt3.setString(37,facility_id);
					}
					//End AAKH-CRF-0010 [IN038535]


					rset3 =  pstmt3.executeUpdate();
					if(rset3> 0)  result	=	true;
					else  result	=	false;
					if((UpOPPatQ != null) && (UpOPPatQ.length() > 0)) {UpOPPatQ.delete(0,UpOPPatQ.length()); }
					if(pstmt3!=null) pstmt3.close();pstmt3=null;
				//}
 			}catch(Exception e){e.printStackTrace();
				result =false;
				sb.append("OP_PATIENT_QUEUE :"+e);

            }
	    }
		/*Below line added for this CRF AAKH-CRF-0010 [IN038535]*/
		if(result) {
			try{
				UpOPLastVisit = new StringBuffer();
				UpOPLastVisit.append("UPDATE OP_LAST_VISIT_FOR_SERVICE SET ");
				UpOPLastVisit.append("MODIFIED_BY_ID = ?, MODIFIED_AT_WS_NO = ?, MODIFIED_DATE = sysdate, MODIFIED_FACILITY_ID = ? ");				
				if(fivelevelapplyn.equals("Y")&&!attend_pract_id.equals(""))
				UpOPLastVisit.append(", ATTEND_PRACTITIONER_ID = ? ");
				
				UpOPLastVisit.append("WHERE ENCOUNTER_ID = ?  and OPERATING_FACILITY_ID=? ");
				
				psmtLastVisit	= con.prepareStatement(UpOPLastVisit.toString());
				psmtLastVisit.setString(1,modified_by_id); 		
				psmtLastVisit.setString(2,modified_at_ws_no);
				psmtLastVisit.setString(3,modified_facility_id);
				if(fivelevelapplyn.equals("Y")&&!attend_pract_id.equals("")){
					psmtLastVisit.setString(4,attend_pract_id);
					psmtLastVisit.setString(5,encounter_id);
					psmtLastVisit.setString(6,facility_id);
				}else{
					psmtLastVisit.setString(4,encounter_id);
					psmtLastVisit.setString(5,facility_id);
				}
				
				
				lastvisit =  psmtLastVisit.executeUpdate();
				if(lastvisit > 0) result	=	true;
				else 	result	=	false;
				if((UpOPLastVisit != null) && (UpOPLastVisit.length() > 0)) { UpOPLastVisit.delete(0,UpOPLastVisit.length()); }
				if(psmtLastVisit!=null) psmtLastVisit.close();psmtLastVisit=null;
			}catch(Exception e){e.printStackTrace();
				result =false;
				sb.append("OP_LAST_VISIT_FOR_SERVICE :"+e);

            }
		}
		
		//End AAKH-CRF-0010 [IN038535]

		if(result) {
			try{
				UpPREncOth = new StringBuffer();
				UpPREncOth.append("UPDATE PR_ENCOUNTER_OTHER_DETAIL SET ");
				/*Added by Dharma for AUDIT COLUMNS update Start*/
				UpPREncOth.append(" MODIFIED_BY_ID= ?, ");
				UpPREncOth.append(" MODIFIED_AT_WS_NO= ?, ");					
				UpPREncOth.append(" MODIFIED_DATE = sysdate, ");
				UpPREncOth.append(" MODIFIED_FACILITY_ID= ?, ");
				/*Added by Dharma for AUDIT COLUMNS update End*/
				UpPREncOth.append("ENCOUNTER_TYPE = ? WHERE ENCOUNTER_ID = ?  and OPERATING_FACILITY_ID=? ");
				pstmt2	= con.prepareStatement(UpPREncOth.toString());
				/*Added by Dharma for AUDIT COLUMNS update Start*/
				pstmt2.setString(1,modified_by_id);
				pstmt2.setString(2,added_at_ws_no);
				pstmt2.setString(3,modified_facility_id);
				/*Added by Dharma for AUDIT COLUMNS update End*/
				pstmt2.setString(4,encounter_type);
				pstmt2.setString(5,encounter_id);
				pstmt2.setString(6,facility_id);
				rset2 =  pstmt2.executeUpdate();
				if(rset2 > 0) result	=	true;
				else 	result	=	false;
				if((UpPREncOth != null) && (UpPREncOth.length() > 0)) { UpPREncOth.delete(0,UpPREncOth.length()); }
				if(pstmt2!=null) pstmt2.close();pstmt2=null;
			}catch(Exception e){e.printStackTrace();
				result =false;
				sb.append("PR_ENCOUNTER_OTHER_DETAIL :"+e);

            }
		}

			result = updatingAeEmengencyDetails();



			if(result) {
					if ((!treatment_area_code.equals("")) && (!clinic_code.equals(""))) {
					try{
						InAEMovement = new StringBuffer();
						InAEMovement.append(" insert into ae_pat_movement_log (patient_id,facility_id,encounter_id,assign_tmt_area_code,assign_date,assign_clinic_code,assign_bed_no,added_facility_id,added_date,added_by_id,added_at_ws_no) values (?,?,?,?,sysdate,?,?,?,sysdate,?,?) ");

						pstmt				=	con.prepareStatement(InAEMovement.toString());
						pstmt.setString(1,patient_id);
						pstmt.setString(2,facility_id);
						pstmt.setString(3,encounter_id);
						pstmt.setString(4,treatment_area_code	);
						pstmt.setString(5,clinic_code);
						pstmt.setString(6,bed_bay_no);
						pstmt.setString(7,facility_id);
						pstmt.setString(8,added_by_id);
						pstmt.setString(9,added_at_ws_no);

			 			if(pstmt.executeUpdate()>0)  result=true;
						else	  result=false;
						if((InAEMovement != null) && (InAEMovement.length() > 0)) { InAEMovement.delete(0,InAEMovement.length()); }
						if(pstmt!=null) pstmt.close(); pstmt=null;
					}catch(Exception e){
					// Tuesday, May 25, 2010 PE_EXE
					String searchMe =e.getMessage();
					String flag="";
					String msg ="";
					if(searchMe !=null){
						int start=searchMe.indexOf("ORA",0);
						int end=start+9;
						if(searchMe.length()>= end){
							if(searchMe.substring(start,end).equals("ORA-00001")){
									MessageManager mm = new MessageManager();
									final java.util.Hashtable mesg = mm.getMessage(locale, "ENC_ALREADY_MODIFIED", "AE") ;
									msg = ((String) mesg.get("message"));
									flag="N";
							}else{
									flag="Y";
							}
						} else{
							flag="Y";
						}
					}
					if(flag.equals("N"))
					{
						sb.append(msg);
						result	= false;
					}else{
						e.printStackTrace();
						sb.append("<br>Exception@EJBLog: "+e);
						result	= false;
					 }
									
	              }
				}
			}
			if(result) {


			try{

					if(!(order_catalog_code3.equals(""))) {
						cstmt = con.prepareCall("{call OR_INSERT_ORDER_OTH_MODULE (to_date(sysdate,'dd/mm/rrrr hh24:mi'),?,'AE',?,?,'EM',?,?,?,'E',?,?,?,?,?,?,?,?,?)}");
						cstmt.setString(1, order_catalog_code3);
						cstmt.setString(2,  facility_id);
						cstmt.setString(3,  patient_id);
						cstmt.setString(4,  encounter_id);
						cstmt.setString(5,  episodeno);
						cstmt.setString(6,  visitnum);
						cstmt.setString(7,  clinic_code2);
						cstmt.setString(8,  practitioner_id);
						cstmt.setString(9,  added_by_id);
						cstmt.setString(10,  added_at_ws_no);
						cstmt.registerOutParameter(11,java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(12,java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(13,java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(14,java.sql.Types.VARCHAR);
						cstmt.setString(15,  order_id);

						cstmt.execute();
						cs = cstmt.getString(14);
						if(cs == null) cs="";
						if(cs.equals(""))  result = true;
						else   result = false;
					}
					if(cstmt != null) cstmt.close();cstmt=null;
				}catch(Exception e) {
					e.printStackTrace();
					result = false;
					e.printStackTrace();
				    sb.append("order catalog procedure :"+e);
				}
			}//end of OR proc
			if(result) {
				result = true ;
				con.commit();
			} else{
				con.rollback();
				if(cs!=null)
				{
				sb.append(cs);
				}
				else
				{
			  sb.append("Record Updation Incomplete ....");
				}

			}
			 ae_pr_encounter_add.clear();
			 ae_pr_encounter_oth_dtls.clear();
			 ae_pat_emergency_dtls.clear();
			 ae_pat_triage.clear();
			session_details.clear();
		}  catch (Exception e) {
			e.printStackTrace();
				sb.append(e);
		} finally  {
			try {
				if(result) {
					if((sb != null) && (sb.length() > 0))
					sb.delete(0,sb.length());

				MessageManager mm = new MessageManager();
				final java.util.Hashtable mesg = mm.getMessage(locale, "RECORD_MODIFIED", "SM") ;
                String msg  = ((String) mesg.get("message"));
				sb.append(msg) ;
				mesg.clear();
				}
				if(con!=null) { ConnectionManager.returnConnection(con,p); }
			}   catch(Exception e){e.printStackTrace();}
		}

		results.put("status",new Boolean(result));
		results.put("error",sb.toString());
		return results;
	}

	public boolean updatingAeEmengencyDetails(){
			if(modify_flag.equals("N")) {
				try{
					UpAEPatE = new StringBuffer();
					UpAEPatE.append("INSERT into  AE_PAT_EMERGENCY_DETAIL ");
					UpAEPatE.append("(AE_ENCOUNTER_TYPE ,COMPLAINT_CODE ,");
					UpAEPatE.append("MEDICAL_YN	,SURGICAL_YN ,REMARKS ,");
					UpAEPatE.append("MECH_INJURY_CATG_CODE ,MECH_INJURY_SUBCATG_CODE ,");
					UpAEPatE.append("VEHICLE_INVOLVED1_CODE ,VEHICLE_INVOLVED2_CODE,");
					UpAEPatE.append("PROTECTIVE_DEVICE_CODE  ,PAT_POSITION_CODE,");
					UpAEPatE.append("OSCC_YN,");
					UpAEPatE.append("PREGNANT_YN  ,");
					UpAEPatE.append("LMP_DATE ,IMMUNIZATION_STATUS  ,");
					UpAEPatE.append("ATT_GIVEN_YN ,DEVP_MILESTONE_AGE_YN ,");
					UpAEPatE.append("IM_UPTO_DATE_YN  ,MENARCHE_YN ,");
					UpAEPatE.append("HEIGHT ,WEIGHT   ,CIRCUMFERENCE ,");
					UpAEPatE.append("CAP_BLOOD_SUGAR ,FBC_YN,ECG_YN  ,");
					UpAEPatE.append("DRESSING_YN ,IMMOBILIZATION_CODE ,");
					UpAEPatE.append("BURN_YN,");
					UpAEPatE.append("TRAUMA_YN ,BLUNT_INJURY_YN,");
					UpAEPatE.append("PENETRATING_INJURY_YN	 ,TETANUS_ADMIN_YN  ,");
					UpAEPatE.append("GD_FOR_AGE_YN,ADDED_BY_ID ,");
					UpAEPatE.append("ADDED_DATE ,ADDED_AT_WS_NO,");
					UpAEPatE.append("ADDED_FACILITY_ID ,MODIFIED_BY_ID  ,");
					UpAEPatE.append("MODIFIED_DATE ,MODIFIED_AT_WS_NO,");
					UpAEPatE.append("MODIFIED_FACILITY_ID	 ,PAT_PRIORITY	,");
					UpAEPatE.append("FACILITY_ID  ,ENCOUNTER_ID,PRIORITY_ZONE,TREATMENT_AREA_CODE,BED_NO,CLINIC_CODE,RECORDED_DATE,AMBULATORY_STATUS,DISASTER_YN,DISASTER_TOWN_CODE,DISASTER_TYPE_CODE,POL_REP_NO,POL_STN_ID,DATE_TIME_OF_ACCIDENT,PLACE_OF_ACCIDENT,VEHICLE_REG_NO1,VEHICLE_REG_NO2, O_AND_G_YN, INITIAL_MGMT_MEDICATION, INITIAL_MGMT_OTHERS ");//Modified by Thamizh selvi on 16th Mar 2018 against ML-MMOH-CRF-0645 --O_AND_G_YN
					//Modified above query by Thamizh selvi on 12th Apr 2018 against ML-MMOH-CRF-0651 --INITIAL_MGMT_MEDICATION, INITIAL_MGMT_OTHERS
					
					//Below line added for this CRF ML-MMOH-CRF-0654
                    if(modeofTransfer){					
					   UpAEPatE.append(",transport_mode,arrival_code,accompanied_by_code");
					}
					
					/* Added by Ajay Hatwate for GHL-CRF-0650 on 18/07/2023 */
					if(isMLCAppl.equals("true")){
						UpAEPatE.append(", mlc_death_yn, MLC_REMARKS, MLC_CAPTURE_DATE, MLC_NO_OUTSIDE_DTLS ");
					}
					/* End GHL-CRF-0650 */
					UpAEPatE.append(")");
					
					//End ML-MMOH-CRF-0654
					
					UpAEPatE.append(" values(?,?,?,?,?,?,?,?,?,?,?,?,?,");
					UpAEPatE.append("to_date(?,'dd/mm/rrrr'), ?,?,?,?,?,?,?,?,");
					UpAEPatE.append(" ?,?,?,?,?,?,?,?,?,?,?,?,sysdate,");
					UpAEPatE.append("?,?,?,sysdate,?,?,?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy hh24:mi:ss'),?,?,?,?,?,?,to_date(?,'dd/mm/yyyy hh24:mi'),?,?,?,?,?,?");//Modified by Thamizh selvi on 16th Mar 2018 against ML-MMOH-CRF-0645
					//Modified above line by Thamizh selvi on 12th Apr 2018 against ML-MMOH-CRF-0651

					//Below line added for this CRF ML-MMOH-CRF-0654
					if(modeofTransfer){		
					   UpAEPatE.append(",?,?,?");
					}
					/* Added by Ajay Hatwate for GHL-CRF-0650 on 18/07/2023 */
					if(isMLCAppl.equals("true")){
						UpAEPatE.append(", ?, ?, to_date(?,'DD/MM/YYYY HH24:MI:SS'), ?");
					}
					/* End GHL-CRF-0650 */
					
					UpAEPatE.append(")");
					
					//End ML-MMOH-CRF-0654

					if(pstmt!=null) pstmt.close();pstmt=null;
					pstmt	= con.prepareStatement(UpAEPatE.toString());
					pstmt.setString(1,ae_encounter_type);
					pstmt.setString(2,complaint_code);
					pstmt.setString(3,medical_yn);
					pstmt.setString(4,surgical_yn);
					pstmt.setString(5,triage_remarks); 			pstmt.setString(6,mech_injury_catg_code);
					pstmt.setString(7,mech_injury_subcatg_code); 	pstmt.setString(8,vehicle_involved1_code);
					pstmt.setString(9,vehicle_involved2_code); 		pstmt.setString(10,protective_device_code);
					pstmt.setString(11,pat_position_code);
					pstmt.setString(12,oscc_yn);
					pstmt.setString(13,pregnant_yn);
					pstmt.setString(14,lmp_date);
					pstmt.setString(15,immunization_status);
					pstmt.setString(16,att_given_yn);
					pstmt.setString(17,devp_milestone_age_yn);
					pstmt.setString(18,im_upto_date_yn);
					pstmt.setString(19,menarche_yn);
					pstmt.setString(20,height);
					pstmt.setString(21,weight);
					pstmt.setString(22,circumference);
					pstmt.setString(23,cap_blood_sugar);
					pstmt.setString(24,fbc_yn);
					pstmt.setString(25,ecg_yn);
					pstmt.setString(26,dressing_yn);
					pstmt.setString(27,immobilization_code);
					pstmt.setString(28,"N");
					pstmt.setString(29,CaseofTrauma_val);
					pstmt.setString(30,"N");
					pstmt.setString(31,"N");
					pstmt.setString(32,"N");
					pstmt.setString(33,"N");
					pstmt.setString(34,added_by_id);
					pstmt.setString(35,added_at_ws_no);
					pstmt.setString(36,added_facility_id);
					pstmt.setString(37,modified_by_id); 			pstmt.setString(38,modified_at_ws_no);
					pstmt.setString(39,modified_facility_id);
					pstmt.setString(40,priority11);
					pstmt.setString(41,facility_id);
					pstmt.setString(42,encounter_id);
					pstmt.setString(43,priority_code); 				pstmt.setString(44,treatment_area_code);
					pstmt.setString(45,bed_bay_no );
					pstmt.setString(46,clinic_code );
					//pstmt.setString(47,sys_date_time );
					pstmt.setString(47,record_date_time );  // Added for ML-MMOH-CRF-0656 by K V Shanmukh
					pstmt.setString(48,ambulatory_status );
					pstmt.setString(49,disaster_yn );
					pstmt.setString(50,disaster_town_code );
					pstmt.setString(51,disaster_type_code );
					pstmt.setString(52,police_report_no );
					pstmt.setString(53,police_station_dtls );
					pstmt.setString(54,date_time_accident );
					pstmt.setString(55,place_of_accident );

					//Added by Ashwini on 04-Apr-2017 for GDOH-CFR-0004.3
					pstmt.setString(56,Vehicle_Reg_No1);
					pstmt.setString(57,Vehicle_Reg_No2);

					pstmt.setString(58,OandGYn);//Added by Thamizh selvi on 16th Mar 2018 against ML-MMOH-CRF-0645
					/*Added by Thamizh selvi on 12th Apr 2018 against ML-MMOH-CRF-0651 Start*/
					pstmt.setString(59,medication);
					pstmt.setString(60,intialMgmtOthers);
					/*End*/
					
					//Added for this CRF ML-MMOH-CRF-0654
					if(modeofTransfer){	
						pstmt.setString(61,transport_mode);
						pstmt.setString(62,mode_of_arrival);
						pstmt.setString(63,accompany_by);	
				    }
                    //End ML-MMOH-CRF-0654
					/* Added by Ajay Hatwate for GHL-CRF-0650 on 18/07/2023 */
					if(isMLCAppl.equals("true") && modeofTransfer){						
						pstmt.setString(64,mlc_death);
						pstmt.setString(65,mlc_remarks);
						pstmt.setString(66,date_of_mlc_capture);
						pstmt.setString(67,outside_mlc_dtls);
					}else if(isMLCAppl.equals("true") && !modeofTransfer){
						pstmt.setString(61,mlc_death);
						pstmt.setString(62,mlc_remarks);
						pstmt.setString(63,date_of_mlc_capture);
						pstmt.setString(64,outside_mlc_dtls);
					}
					/* End GHL-CRF-0650 */

					rs =  pstmt.executeUpdate();
					if(rs> 0) 	result	=	true;
					else 	result	=	false;
					if((UpAEPatE != null) && (UpAEPatE.length() > 0)) { UpAEPatE.delete(0,UpAEPatE.length()); }
					if(pstmt!=null) pstmt.close();pstmt=null;
				}catch(Exception e){
					// Tuesday, May 25, 2010 PE_EXE
					String searchMe =e.getMessage();
					String flag="";
					String msg ="";
					if(searchMe !=null){
						int start=searchMe.indexOf("ORA",0);
						int end=start+9;
						if(searchMe.length()>= end){
							if(searchMe.substring(start,end).equals("ORA-00001")){
									MessageManager mm = new MessageManager();
									final java.util.Hashtable mesg = mm.getMessage(locale, "ENC_ALREADY_MODIFIED", "AE") ;
									msg = ((String) mesg.get("message"));
									flag="N";
							}else{
									flag="Y";
							}
						} else{
							flag="Y";
						}
					}
					if(flag.equals("N"))
					{
						sb.append(msg);
						result	= false;
					}else{
						e.printStackTrace();
						result =false;
						sb.append("AE_PAT_EMERGENCY_DETAIL :"+e);
					 }
									
	              }
			}

		return result;
	}

	public static String checkForNull(String inputString)
	{
		return ( ((inputString == null) || (inputString.equals("null"))) ? "" : inputString );
	}
	public static String checkNullWithDftValue(String str, String dftval) {
		return ((str == null || str.equals("null")) ? dftval : str);
	}
} //End of the Class
