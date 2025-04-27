/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIP.IPDischargePatient;

import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.ejb.CreateException;
import java.util.Properties;
import java.util.Hashtable;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.MessageManager;
import blipin.BLDischargePatient;
import eCommon.Common.*;

/**
*
* @ejb.bean
*	name="IPDischargePatient"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="IPDischargePatient"
*	local-jndi-name="IPDischargePatient"
*	impl-class-name="eIP.IPDischargePatient.IPDischargePatientManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eIP.IPDischargePatient.IPDischargePatientLocal"
*	remote-class="eIP.IPDischargePatient.IPDischargePatientRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eIP.IPDischargePatient.IPDischargePatientLocalHome"
*	remote-class="eIP.IPDischargePatient.IPDischargePatientHome"
*	generate= "local,remote"
*
*
*/

public class IPDischargePatientManager implements SessionBean 
{
	//Connection connection			= null;
	PreparedStatement preStatement	= null;
	PreparedStatement pstmt			= null;
	ResultSet rset					= null;
	Statement stmt					= null;
	ResultSet srs					= null;
	Statement stmt_add				= null;
	ResultSet rs_add				= null;
	String locale					= "";
	StringBuffer stringBuffer;
	Statement count_stmt			= null;
	ResultSet count_rs				= null;
	
	//Added for HSA-CRF-0306.1
	ResultSet rest=null;
	PreparedStatement pstmt1= null;
	CallableStatement cstmt=null;
	String errmsg="";
	
	
	SessionContext ctx;
	public void ejbCreate() {}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext (SessionContext context){ this.ctx=context;}
	/**
		This method is used to discharge the patient.
		@version - V3
		@param1 - java.util.Properties
		@param2 - java.util.HashMap
		@return - java.util.HashMap
	*/
/**
* @ejb.interface-method
*	 view-type="both"
*/
	public java.util.HashMap insertIPDischargePatient(Properties p, HashMap paramHashTab) 
	{
		Connection connection				= null;
		CallableStatement cstmt				= null;
		/* ADDED FOR ML-MMOH-CRF-1972 ISSUE */
		ResultSet rs2 			 = null;
		PreparedStatement pstmt2 = null;
		int res1				= 0;
		StringBuffer sql1				= new StringBuffer("");
		/* END FOR ML-MMOH-CRF-1972 ISSUE */
		StringBuffer sb						= new StringBuffer("");
		boolean result						= false;
		String BillResult					= "PASS";
		java.util.HashMap results			= new java.util.HashMap() ;
		String sl_ref_no					= "";
		String facilityId					= ""; 
		String patientid					= ""; 
		String encounter_id					= ""; 
		String dischargedate				= ""; 
		String dischargetype				= ""; 
		String practitionerid				= ""; 
		String specialitycode				= ""; 
		String patienttype					= ""; 
		String bedclasscode					= ""; 
		String nursingunitcode				= ""; 
		String servicecode					= ""; 
		String bedno						= ""; 
		String roomno						= ""; 
		String daily_rate					= ""; 
		String dischargeremarks				= ""; 
		String blockuntildate				= ""; 
		String admissiondatetime			= ""; 
		String bedtypecode					= ""; 
		String patientgender				= ""; 
		String deceasedyn					= ""; 
		String postmortemrequest			= ""; 
		String dischargesummarysigned		= ""; 
		String newmedicine					= ""; 
		String addedAtWorkstation			= ""; 
		String bl_interfaced_yn				= ""; 
		String referred						= ""; 
		String referral_type				= ""; 
		String referred_to					= ""; 
		String priority						= ""; 
		String preferred_date				= ""; 
		String speciality					= ""; 
		String service						= ""; 
		String location0					= ""; 
		String location1					= ""; 
		String location2					= ""; 
		String practitioner					= ""; 
		String pract_name					= ""; 
		String practitioner1				= ""; 
		String hcare_setting_type_desc		= ""; 
		String hcare_setting_type			= ""; 
		String open_to_all_pract_yn			= ""; 
		String from_hcare_setting_type_code	= "";
		String eid							= ""; 
		String SickLeaveRecordFlag			= ""; 
		String LeaveFrom					= ""; 
		String LeaveTo						= ""; 
		String FitForDuty					= ""; 
		String FitonDuty					= ""; 
		String CertIssued					= ""; 
		String AuthorizedById				= ""; 
		String remarks						= ""; 
		String practid						= ""; 
		String DECEASED_DATE_TIME			= ""; 
		String body_released				= ""; 
		String dischg_practid				= ""; 
		String ref_for_ip					= ""; 
		String inform_to					= ""; 
		String informed_date				= ""; 
		String informed_name				= ""; 
		String medico_legal					= ""; 
		String police_rep_no				= ""; 
		String police_station				= ""; 
		String police_id					= ""; 
		String accomp_person				= ""; 
		String witness_id					= "";
		String cnt_values					= "";
		String blocking_type_code			= "";
		String bed_block_remarks			= "";
		String deactivate_pseudo_bed_yn		= "";
		String mother_bed_status			= "";
		String bl_operational				= "";
		String override_yn					= "";
		String body_risk_yn					= "";
		String dis_Adv_Srl_No				= "";
		String patient_class				= "";
		String fm_install_yn				= "";
		String pseudobedyn					= "";
		int bookingrefno					= 0;
		String subservice_code				= "";
		String dischargestatus				= ""; 
		String episode_type					= ""; 
		String function_id					= "";
		String referral_id_list		        = "";//Added for Incident NO:34615 by Srinivas
		String ref_id				        = "";//Added for Incident NO:34615 by Srinivas
		//added for the CRF - Bru-HIMS-CRF-157
		String other_late_discharge_reason ="";
		String late_discharge_reason="";
		int L_male_count					= 0;
		int L_female_count					= 0;
		int L_unknown_count					= 0;
		int res3							= 0;
		int res								= 0;
		int res4							= 0;
		stringBuffer = new StringBuffer();
		String locn_type					= "";
		String error 						= "";
		
		/*Added by Dharma on Oct 29th against HSA-CRF-0181 [IN:049541] Start*/
		String weight_on_admission			= "";
		String weight_on_admission_unit		= "";
		/*Added by Dharma on Oct 29th against HSA-CRF-0181 [IN:049541] End*/
		
		/*Added by KAMATCHI S on 23-JUN-2020 for ML-MMOH-CRF-1527*/
		String height_on_admission		= "";
		String bmi	= "";
		String discharge_to="";
		/*Added by KAMATCHI S on 23-JUN-2020 for ML-MMOH-CRF-1527 END */
		
		String allow_muti_bedside_review_yn="N";//Added for this HSA-CRF-0263.1
		String daycare_unit_code=""; //Added for this CRF HSA-CRF-0306.1

		// added by mujafar for ML-MMOH-CRF-0659 start 
		String absconded_date				=	""; 
		String absconded_yn					=	"";
		String reported_to					=	"";
		String isModifyDiscTypeStatusAppl = (String)paramHashTab.get("isModifyDiscTypeStatusAppl");
		String allow_modify_disc_yn       = (String)paramHashTab.get("allow_modify_disc_yn");
		// added by mujafar for ML-MMOH-CRF-0659 end
		try
		{
			connection						= ConnectionManager.getConnection(p);
			connection.setAutoCommit(false);
			locale = p.getProperty("LOCALE");
			boolean isForAdmission=CommonBean.isSiteSpecific(connection, "AE", "AE_FOR_ADMISSION_TAB");//ADDED BY KAMATCHI S FOR ML-MMOH-CRF-1972 ISSUE
			facilityId						= (String)paramHashTab.get("facilityId");
			patientid						= (String)paramHashTab.get("patientid");
			encounter_id					= (String)paramHashTab.get("encounterid");
			dischargedate					= (String)paramHashTab.get("dischargedate");
			dischargetype					= (String)paramHashTab.get("dischargetype");
			practitionerid					= (String)paramHashTab.get("practitionerid");
			specialitycode					= (String)paramHashTab.get("specialitycode");
			patienttype						= (String)paramHashTab.get("patienttype");
			bedclasscode					= (String)paramHashTab.get("bedclasscode");
			nursingunitcode					= (String)paramHashTab.get("nursingunitcode");
			servicecode						= (String)paramHashTab.get("servicecode");
			bedno							= (String)paramHashTab.get("bedno");
			roomno							= (String)paramHashTab.get("roomno");
			daily_rate						= (String)paramHashTab.get("dailyrate");
			dischargeremarks				= (String)paramHashTab.get("dischargeremarks");
			blockuntildate					= (String)paramHashTab.get("blockuntildate");
			if(blockuntildate.equals("0")) 
				blockuntildate				=  "";
			admissiondatetime				= (String)paramHashTab.get("admissiondatetime");
			bedtypecode						= (String)paramHashTab.get("bedtypecode");
			patientgender					= (String)paramHashTab.get("patientgender");
			deceasedyn						= (String)paramHashTab.get("deceasedyn");
			postmortemrequest				= (String)paramHashTab.get("postmortemrequest");
			dischargesummarysigned			= (String)paramHashTab.get("dischargesummarysigned");
			newmedicine						= (String)paramHashTab.get("newmedicine");
			addedAtWorkstation				= (String)paramHashTab.get("client_ip_address");
			bl_interfaced_yn				= (String)paramHashTab.get("bl_interfaced_yn");
			referred						= (String)paramHashTab.get("referred");
			referral_type					= (String)paramHashTab.get("referral_type");
			referred_to						= (String)paramHashTab.get("referred_to");
			priority						= (String)paramHashTab.get("priority");
			preferred_date					= (String)paramHashTab.get("preferred_date");
			speciality						= (String)paramHashTab.get("speciality");
			service							= (String)paramHashTab.get("service");
			location0						= (String)paramHashTab.get("location0");
			location1						= (String)paramHashTab.get("location1");
			location2						= (String)paramHashTab.get("location2");
			practitioner					= (String)paramHashTab.get("practitioner");
			pract_name						= (String)paramHashTab.get("pract_name");
			practitioner1					= (String)paramHashTab.get("practitioner1");
			hcare_setting_type_desc			= (String)paramHashTab.get("hcare_setting_type_desc");
			hcare_setting_type				= (String)paramHashTab.get("hcare_setting_type");
			open_to_all_pract_yn			= (String)paramHashTab.get("open_to_all_pract_yn");
			from_hcare_setting_type_code	= (String)paramHashTab.get("from_hcare_setting_type_code");
			eid								= (String)paramHashTab.get("eid");
			SickLeaveRecordFlag				= (String)paramHashTab.get("SickLeaveRecordFlag");
			LeaveFrom						= (String)paramHashTab.get("LeaveFrom");
			LeaveTo							= (String)paramHashTab.get("LeaveTo");
			FitForDuty						= (String)paramHashTab.get("FitForDuty");
			FitonDuty						= (String)paramHashTab.get("FitonDuty");
			CertIssued						= (String)paramHashTab.get("CertIssued");
			AuthorizedById					= (String)paramHashTab.get("AuthorizedById");
			remarks							= (String)paramHashTab.get("remarks");
			practid							= (String)paramHashTab.get("practid");
			DECEASED_DATE_TIME				= (String)paramHashTab.get("DECEASED_DATE_TIME");
			body_released					= (String)paramHashTab.get("body_released");
			dischg_practid					= (String)paramHashTab.get("dischg_practid");
			ref_for_ip						= (String)paramHashTab.get("ref_for_ip");
			inform_to						= (String)paramHashTab.get("inform_to");
			informed_date					= (String)paramHashTab.get("informed_date");
			informed_name					= (String)paramHashTab.get("informed_name");
			medico_legal					= (String)paramHashTab.get("medico_legal");
			police_rep_no					= (String)paramHashTab.get("police_rep_no");
			police_station					= (String)paramHashTab.get("police_station");
			police_id						= (String)paramHashTab.get("police_id");
			accomp_person					= (String)paramHashTab.get("accomp_person");
			witness_id						= (String)paramHashTab.get("witness_id");
			cnt_values						= (String)paramHashTab.get("cnt_values");
			blocking_type_code				= (String)paramHashTab.get("blocking_type_code");
			bed_block_remarks				= (String)paramHashTab.get("bed_block_remarks");
			override_yn						= (String)paramHashTab.get("override_yn");
			deactivate_pseudo_bed_yn		= (String)paramHashTab.get("deactivate_pseudo_bed_yn");
			mother_bed_status				= (String)paramHashTab.get("mother_bed_status");
			bl_operational					= (String)paramHashTab.get("bl_operational");
			body_risk_yn					= (String)paramHashTab.get("body_risk_yn");
			dis_Adv_Srl_No					= (String)paramHashTab.get("dis_Adv_Srl_No");
			patient_class					= (String)paramHashTab.get("patient_class");
			subservice_code					= (String)paramHashTab.get("subservice_code");
			locn_type						= (String)paramHashTab.get("locn_type");
			dischargestatus					= (String)paramHashTab.get("dischargestatus");
			late_discharge_reason=(String)paramHashTab.get("late_discharge_reason");
			other_late_discharge_reason=(String)paramHashTab.get("other_late_discharge_reason");
			
			
			/*Added by Dharma on Oct 29th against HSA-CRF-0181 [IN:049541] Start*/
			weight_on_admission				= (String)paramHashTab.get("weight_on_admission");
			weight_on_admission_unit		= (String)paramHashTab.get("weight_on_admission_unit");
			/*Added by Dharma on Oct 29th against HSA-CRF-0181 [IN:049541] End*/
			
			/*Added by KAMATCHI S on 23-JUN-2020 for ML-MMOH-CRF-1527*/
			height_on_admission		= (String)paramHashTab.get("height_on_admission");
			bmi	= (String)paramHashTab.get("bmi");
			discharge_to = (String)paramHashTab.get("discharge_to");
			/*Added by KAMATCHI S on 23-JUN-2020 for ML-MMOH-CRF-1527 END */
			
			allow_muti_bedside_review_yn=(String)paramHashTab.get("allow_muti_bedside_review_yn"); //Added for this CRF HSA-CRF-0263.1
			
			daycare_unit_code=(String)paramHashTab.get("daycare_unit_code"); //Added for this CRF HSA-CRF-306.1

			if(isModifyDiscTypeStatusAppl.equals("true") && allow_modify_disc_yn.equals("Y"))
			{
			absconded_date				=	(String) paramHashTab.get("absconded_date"); 
			absconded_yn				=	(String) paramHashTab.get("absconded_yn"); 
			reported_to					=	(String) paramHashTab.get("reported_to"); 
			}
			
			String babyBedNo="";//Added for the incident IN038484
			String babyPatientId="";//Added for the incident IN038484			
			//int babyCount=0;//Added for the incident IN038484	 //Commented for checkstyle		
			//function_id					=	(String) paramHashTab.get("function_id");

			paramHashTab.clear();
			long encounterid				= Long.parseLong(encounter_id);
			int dailyrate					= 0;
			if (!daily_rate.equals(""))
				dailyrate				= Integer.parseInt(daily_rate);
			String modifiedById				= p.getProperty( "login_user" ) ;
			String sql						= "";
			int rs							= 0;
			if (practitioner.equals(""))
				pract_name				= practitioner1;
			boolean boolBLInstall		= false;
			
			//To fetch the baby patient id and baby bed no from ip_nursing_unit_bed table. Incident - IN038484 - start
			if(mother_bed_status.equals("Y")){
				if(stringBuffer.length() > 0 ) stringBuffer.delete(0,stringBuffer.length());
			
			
			stringBuffer.append("SELECT OCCUPYING_PATIENT_ID,bed_no FROM ip_nursing_unit_bed WHERE facility_id = ? AND nursing_unit_code = ? AND mothers_patient_id = ?");
			preStatement = connection.prepareStatement(stringBuffer.toString());
			preStatement.setString	( 1, facilityId ) ;
			preStatement.setString	( 2, nursingunitcode);
			preStatement.setString	( 3, patientid) ;
			srs = preStatement.executeQuery();
			while(srs.next())
			{
				babyPatientId=babyPatientId+srs.getString("OCCUPYING_PATIENT_ID")+"|";
				babyBedNo=babyBedNo+srs.getString("bed_no")+"|";								
			}
				
			}
			//To fetch the baby patient id and baby bed no from ip_nursing_unit_bed table. Incident - IN038484 - End
			try
			{
				if(stringBuffer.length() > 0 ) stringBuffer.delete(0,stringBuffer.length());
				//Added Audit column
				stringBuffer.append(" update IP_DISCHARGE_ADVICE set dis_adv_status = '1' ");
				/*Thursday, January 13, 2011 ,SRR20056-SCF-6415 [IN:025852],point 9*/
				//Added for the incident - IN038484 - start
				if(mother_bed_status.equals("Y"))
					stringBuffer.append(",baby_patient_id='"+babyPatientId+"', baby_bed_no='"+babyBedNo+"'");
				//Added for the incident - IN038484 - End
				if(isModifyDiscTypeStatusAppl.equals("true") && allow_modify_disc_yn.equals("Y")) // added by mujafar for ML=MMOH-CRF-0659
				stringBuffer.append(", med_lgl_case_yn = '"+medico_legal+"', pol_rep_no = '"+police_rep_no+"', pol_stn_id = '"+police_station+"', pol_id = '"+police_id+"' , MODIFIED_BY_ID= '"+modifiedById+"', MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO ='"+addedAtWorkstation+"', ABSCONDED_DATE= to_date(?,'dd/mm/rrrr hh24:mi'), ABSCONDED_YN='"+absconded_yn+"',REPORTED_TO='"+reported_to+"' , MODIFIED_FACILITY_ID ='"+facilityId+"'" );					
				else
				stringBuffer.append(", med_lgl_case_yn = '"+medico_legal+"', pol_rep_no = '"+police_rep_no+"', pol_stn_id = '"+police_station+"', pol_id = '"+police_id+"' , MODIFIED_BY_ID= '"+modifiedById+"', MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO ='"+addedAtWorkstation+"' , MODIFIED_FACILITY_ID ='"+facilityId+"'" );
				
				stringBuffer.append(" where facility_id = ? and encounter_id = ? and dis_Adv_Srl_No = '"+dis_Adv_Srl_No+"' ");
				sql						= stringBuffer.toString();
				preStatement			= connection.prepareStatement( sql );
				if(isModifyDiscTypeStatusAppl.equals("true") && allow_modify_disc_yn.equals("Y")) // added by mujafar for ML=MMOH-CRF-0659
				{
					preStatement.setString	( 1, absconded_date ) ;
					preStatement.setString	( 2, facilityId ) ;
					preStatement.setLong	( 3, encounterid ) ;


				}
				else
				{
				preStatement.setString	( 1, facilityId ) ;
				preStatement.setLong	( 2, encounterid ) ;
				}
				rs  = preStatement.executeUpdate() ;
				if(rs > 0 )
					result = true;
				else
				{
					result = false;
					sb.append("Error in updating ip_discharge_advice_table");
				}
				if(preStatement!=null) preStatement.close();
			}catch(Exception e)
			{
				result = false;
				sb.append("Error in updating IP_DISCHARGE_ADVICE_table");
				e.printStackTrace();
			}
			/*Friday, May 14, 2010, update for IP_BED_BOOKING_SRL_CTRL to generate NEXT_BOOKING_SRL_NO will be done through following procedure*/
			if(result){
				if(!blockuntildate.equals(""))
				{
					try
					{
						cstmt=connection.prepareCall("{call IP_GET_BOOKING_SRL_NO.GET_IP_BED_BKG_SRL_NO(?,?,?,?,?,?)}");
						cstmt.setString(1,facilityId);
						cstmt.setString(2,"D");
						cstmt.setString(3,"Y");
						cstmt.setString(4,addedAtWorkstation);
						cstmt.setString(5,modifiedById);
						cstmt.registerOutParameter(6,java.sql.Types.NUMERIC);
						cstmt.execute();
						bookingrefno=cstmt.getInt(6);
						/*Added by Thamizh selvi on 1st Dec 2017 against AYH-SCF-0007 Start*/
						if(bookingrefno < 1){
							java.util.Hashtable message = MessageManager.getMessage( locale, "BED_BKG_SRL_CTRL_NOT_DEFINED","IP" ) ;
							sb.append( (String) message.get("message") ) ;
							result = false;
						}else/*End*/
							result = true;
						if(cstmt != null) cstmt.close();
					}
					catch (Exception e1)
					{
						result = false;
						e1.printStackTrace();
					}
				}
			}

			if(!(cnt_values.equals("0")||(cnt_values.equals(""))) && result)
			{
				try
				{
					stringBuffer.delete(0,stringBuffer.length());
					//Added Audit column
					stringBuffer.append(" update PR_PATIENT_VALUABLES set WITNESS_ID = ? ,modified_by_id = ? , modified_date = sysdate ,modified_at_ws_no = ? , modified_facility_id = ? ");
					stringBuffer.append(" where facility_id = ? and encounter_id = ? ");
					sql						= stringBuffer.toString();
					preStatement			= connection.prepareStatement( sql );
					preStatement.setString	( 1, witness_id ) ;
					//Added Audit column
					preStatement.setString	( 2, modifiedById ) ;
					preStatement.setString	( 3, addedAtWorkstation ) ;
					preStatement.setString	( 4, facilityId ) ;
					
					preStatement.setString	( 5, facilityId ) ;
					preStatement.setLong	( 6, encounterid ) ;
					rs  = preStatement.executeUpdate() ;
					if(rs > 0 )
						result = true;
					else
					{
						result = false;
						sb.append("Error in updating pr_patient_valuables_table");
					}
					if(preStatement!=null) preStatement.close();
				}catch(Exception e)
				{
					result = false;
					sb.append("Error in updating pr_patient_valuables_table");
					e.printStackTrace();
				}
			}
			
			if(result)
			{
				try
				{
					if (stringBuffer.length() > 0)
						stringBuffer.delete(0,stringBuffer.length());
					stringBuffer.append(" UPDATE PR_ENCOUNTER set adt_status = '08', ");
					stringBuffer.append(" reserved_room_no='', reserved_nurs_unit_code='', reserved_bed_no='', ");
					stringBuffer.append(" cancel_reason_code='', cancel_disch_practitioner_id='',cancel_disch_date = null,");
					stringBuffer.append(" adt_status_set_on_date = sysdate, adt_status_set_by_user = ?, ");
					stringBuffer.append(" adt_status_set_reason = ?, discharge_date_time = to_date('");
					stringBuffer.append(dischargedate);
					stringBuffer.append("','dd/mm/rrrr hh24:mi'), ");
					stringBuffer.append("deceased_date_time = to_date('");
					stringBuffer.append(DECEASED_DATE_TIME);
					stringBuffer.append("','dd/mm/rrrr hh24:mi') ");
					stringBuffer.append(", modified_by_id = ?, modified_date = sysdate, modified_facility_id = ? ");
					stringBuffer.append(", modified_at_ws_no = ?, disch_practitioner_id = ?, pol_rep_no = ?, pol_stn_id = ?, pol_id = ? ");
					stringBuffer.append(", informed_to = ?, informed_name = ? ");
					stringBuffer.append(", informed_date_time = to_date(?,'dd/mm/rrrr hh24:mi'), mlc_yn = ? ");
					stringBuffer.append(", disposition_type = '"+dischargetype+"' ");
					stringBuffer.append(", discharge_status_code = '"+dischargestatus+"' ");
					
					/*Added by Dharma on Oct 29th against HSA-CRF-0181 [IN:049541] Start*/
					stringBuffer.append(", weight_on_admission = '"+weight_on_admission+"' ");
					stringBuffer.append(", weight_on_admission_unit = '"+weight_on_admission_unit+"' ");
					/*Added by Dharma on Oct 29th against HSA-CRF-0181 [IN:049541] End*/
					
					/*Added by KAMATCHI S on 23-JUN-2020 for ML-MMOH-CRF-1527*/
					stringBuffer.append(", height_on_admission = '"+height_on_admission+"' ");
					stringBuffer.append(", bmi = '"+bmi+"' ");
					stringBuffer.append(", discharge_to = '"+discharge_to+"' ");
					/*Added by KAMATCHI S on 23-JUN-2020 for ML-MMOH-CRF-1527*/
					
					if(medico_legal.equals("Y"))
					{
						stringBuffer.append(", marked_date=sysdate , marked_by_id='"+modifiedById+"'");
					}				
					/*Thursday, January 13, 2011 ,SRR20056-SCF-6415 [IN:025852],point 11*/
					else
					{
						stringBuffer.append(", marked_date='' , marked_by_id=''");
					}

					stringBuffer.append(", high_risk_yn = '"+body_risk_yn+"' ");
					stringBuffer.append(" ,body_release_date_time = to_date('"+body_released+"','dd/mm/rrrr hh24:mi') ");
					if(postmortemrequest.equals("Y"))
					{
						/*
						4/30/2009 
						*/
						//stringBuffer.append(" ,body_release_date_time = to_date('"+body_released+"','dd/mm/rrrr hh24:mi') ");
						stringBuffer.append(" ,pm_yn = '"+postmortemrequest+"' ");
					}
					stringBuffer.append(", late_disc_reason_code = ? ");
					stringBuffer.append(", other_late_disc_reason = ? ");
					stringBuffer.append(" where facility_id = ? and encounter_id = ? and adt_status != '08'");

					sql		= stringBuffer.toString();
					
					preStatement = connection.prepareStatement( sql );
					preStatement.setString	( 1, modifiedById ) ;
					preStatement.setString	( 2, dischargeremarks ) ;
					preStatement.setString	( 3, modifiedById ) ;
					preStatement.setString	( 4, facilityId ) ;
					preStatement.setString	( 5, addedAtWorkstation ) ;
					preStatement.setString	( 6, dischg_practid ) ;
					preStatement.setString	( 7, police_rep_no ) ;
					preStatement.setString	( 8, police_station ) ;
					preStatement.setString	( 9, police_id ) ;
					preStatement.setString	( 10, inform_to ) ;
					preStatement.setString	( 11, informed_name ) ;
					preStatement.setString	( 12, informed_date ) ;
					preStatement.setString	( 13, medico_legal ) ;
					preStatement.setString	( 14, late_discharge_reason ) ;
					preStatement.setString	( 15, other_late_discharge_reason ) ;
					preStatement.setString	( 16, facilityId ) ;
					preStatement.setLong	( 17, encounterid ) ;
					rs  = preStatement.executeUpdate() ;

					if(rs > 0 )
						result = true;
					else
					{
						result = false;
						sb.append("Error in updating pr_encounter_table ");
					}
					if(preStatement!=null) preStatement.close();

				}catch(Exception e)
				{
					result = false;
					sb.append("Error in updating pr_encounter_table ");
					e.printStackTrace();
				}
			}
			/*Monday, April 26, 2010 , patient status update through new procedure*/
			if (result)
			{
				try
				{
					//comment for chk style String cs	= "0";

					cstmt		= connection.prepareCall("{call MP_AUDIT_FUNCTION.UPDATE_ENCOUNTER(?,?,?,?,?,?,?)}");

					cstmt.setString(1,  checkForNull(facilityId));
					cstmt.setLong(2,  encounterid);
					cstmt.setString(3,  checkForNull(patient_class));
					cstmt.setString(4,  checkForNull(patientid));
					cstmt.setString(5,  "08");
					cstmt.setString(6, checkForNull(modifiedById ));
					cstmt.setString(7, checkForNull(addedAtWorkstation ));
					cstmt.execute();
					
				}
				catch (Exception cs)
				{
					result = false;
					sb.append("MP_AUDIT_FUNCTION.UPDATE_ENCOUNTER:"+cs.toString());
					cs.printStackTrace(System.err);
				}
				finally
				{
					if(cstmt!=null) cstmt.close();
				}
			}
			/**/
			if (accomp_person.equals(""))
					accomp_person = "N";
			if (result && accomp_person.equals("Y"))
			{
				try
				{
					if (stringBuffer.length() > 0)
						stringBuffer.delete(0,stringBuffer.length());
					stringBuffer.append(" update IP_LODGER_DETAIL set check_out_yn = 'Y', " );
					stringBuffer.append(" check_out_date_time = sysdate, modified_by_id=?, " );
					stringBuffer.append(" modified_date = sysdate, modified_facility_id = ?, modified_at_ws_no = ? " );
					stringBuffer.append(" where patient_encounter_id = ? ");
					stringBuffer.append(" and facility_id = ? and check_out_yn = 'N' ");
					preStatement = connection.prepareStatement(stringBuffer.toString());
					preStatement.setString	( 1, modifiedById ) ;
					preStatement.setString	( 2, facilityId ) ;
					preStatement.setString	( 3, addedAtWorkstation ) ;
					preStatement.setLong	( 4, encounterid ) ;
					preStatement.setString	( 5, facilityId) ;
					rs  = preStatement.executeUpdate() ;
					if(rs > 0 )
						result = true;
					else
					{
						result = false;
						sb.append("Error in Updating ip_lodger_detai_table ");
					}
					if(preStatement!=null) preStatement.close();
				
				}catch(Exception e)
				{
					result = false;
					sb.append("Error in updating ip_lodger_detail_table");
					e.printStackTrace();
				}
			}
			
			if(result)
			{
				try
				{
					if (stringBuffer.length() > 0)
						stringBuffer.delete(0,stringBuffer.length());
					//Added Audit column	
					stringBuffer.append(" update IP_TRANSFER_REQUEST set ");
					stringBuffer.append(" tfr_req_status = '9' , MODIFIED_BY_ID= '"+modifiedById+"', MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO ='"+addedAtWorkstation+"' , MODIFIED_FACILITY_ID ='"+facilityId+"'" );
					stringBuffer.append(" where facility_id = ? ");
					stringBuffer.append(" and encounter_id = ? ");
					stringBuffer.append(" and tfr_req_status in ('0','3')");
					preStatement = connection.prepareStatement(stringBuffer.toString());
					preStatement.setString	( 1, facilityId ) ;
					preStatement.setLong	( 2, encounterid ) ;
					rs = 0;
					rs = preStatement.executeUpdate() ;
				}catch(Exception e)
				{
					result = false;
					sb.append("Exception in updating ip_transfer_request_table : "+e);
					e.printStackTrace();
				}
				if(preStatement!=null) preStatement.close();
			}
			
			if(result)
			{
				try
				{
					if (stringBuffer.length() > 0)
						stringBuffer.delete(0,stringBuffer.length());
					//Added Audit column	
					stringBuffer.append(" update IP_BED_CLASS_REQUEST set ");
					stringBuffer.append(" request_status = '9' , MODIFIED_BY_ID= '"+modifiedById+"', MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO ='"+addedAtWorkstation+"' , MODIFIED_FACILITY_ID ='"+facilityId+"'" );
					stringBuffer.append(" where facility_id = ? ");
					stringBuffer.append(" and encounter_id = ? ");
					stringBuffer.append(" and request_status = '0' ");
					preStatement = connection.prepareStatement(stringBuffer.toString());
					preStatement.setString	( 1, facilityId ) ;
					preStatement.setLong	( 2, encounterid ) ;
					rs = 0;
					rs = preStatement.executeUpdate() ;
				}catch(Exception e)
				{
					result = false;
					sb.append("Exception in updating ip_bed_class_request_table : "+e);
					e.printStackTrace();
				}
				if(preStatement!=null) preStatement.close();
			}

			if(result && deceasedyn.equals("Y"))
			{
				try
				{
					cstmt = connection.prepareCall("{call MP_AUDIT_FUNCTION.ASSIGN_VALUE('DISCHARGE_PATIENT')}");
					cstmt.execute();
						if(cstmt!=null) cstmt.close();
				}catch(Exception exception)
				{
					result = false;
					sb.append("Exception in Procedure-MP_AUDIT_FUNCTION.assign_value:"+exception.toString());
					exception.printStackTrace();
				}
				
				if(result)
				{
					try
					{
						if (stringBuffer.length() > 0)
							stringBuffer.delete(0,stringBuffer.length());
						stringBuffer.append(" update MP_PATIENT set deceased_yn = 'Y', active_yn = 'N', deceased_date = to_date('");
						stringBuffer.append(DECEASED_DATE_TIME);
						stringBuffer.append("','dd/mm/rrrr hh24:mi'), ");
						stringBuffer.append(" modified_by_id = ?, modified_date = sysdate, modified_facility_id = ?, ");
						stringBuffer.append(" modified_at_ws_no = ?, DECEASED_FACILITY_ID = ?, DECEASED_ENCOUNTER_ID = ? ");
						stringBuffer.append(" where patient_id = ? ");

						String sql2 = stringBuffer.toString();
						preStatement = connection.prepareStatement(sql2);
						preStatement.setString	( 1, modifiedById);
						preStatement.setString	( 2, facilityId ) ;
						preStatement.setString	( 3, addedAtWorkstation ) ;
						preStatement.setString	( 4, facilityId);	
						preStatement.setLong	( 5, encounterid);	
						preStatement.setString	( 6, patientid);	
						int resss = preStatement.executeUpdate() ;
						if(resss!=0)
							result=true;
						else
						{
							result =false;
							sb.append("Error in Updating deceased status in mp_patient_table");
						}
					}catch(Exception e)
					{
						result = false;
						sb.append("Exception in Updating deceased status in mp_patient_table : "+e);
						e.printStackTrace();
					}
					if(preStatement!=null) preStatement.close();
				}
				if(result && postmortemrequest.equals("Y"))
				{
					try
					{
						if (stringBuffer.length() > 0)
							stringBuffer.delete(0,stringBuffer.length());
						stringBuffer.append(" update PR_ENCOUNTER_OTHER_DETAIL set body_release_date_time = to_date('");
						stringBuffer.append(body_released);
						stringBuffer.append("','dd/mm/rrrr hh24:mi'), ");
						stringBuffer.append(" modified_by_id = ?, modified_date = sysdate, modified_facility_id = ?, ");
						stringBuffer.append(" modified_at_ws_no = ?");
						stringBuffer.append(" where operating_facility_id = ? and encounter_id = ? ");
						preStatement = connection.prepareStatement(stringBuffer.toString());
						preStatement.setString	( 1, modifiedById);
						preStatement.setString	( 2, facilityId ) ;
						preStatement.setString	( 3, addedAtWorkstation ) ;
						preStatement.setString	( 4, facilityId);
						preStatement.setLong	( 5, encounterid);
						int resss = preStatement.executeUpdate() ;
						if(resss!=0)
							result=true;
						else
						{
							result =false;
							sb.append("Error in Updating PR_ENCOUNTER_OTHER_DETAIL");
						}
					}catch(Exception e)
					{
						result = false;
						sb.append("Exception in updating PR_ENCOUNTER_OTHER_DETAIL : "+e);
						e.printStackTrace();
					}
				} 
			}
			int srlno = 0;
			
			if(result)
			{
				try
				{
					if (stringBuffer.length() > 0)
						stringBuffer.delete(0,stringBuffer.length());
					stringBuffer.append(" select max (srl_no)+1 max from IP_ADT_TRN where facility_id = '");
					stringBuffer.append(facilityId);
					stringBuffer.append("' and encounter_id = ");
					stringBuffer.append(encounterid);
					stringBuffer.append(" ");
					sql		= stringBuffer.toString();
					if(stmt != null)stmt.close();
					stmt	= connection.createStatement();
					srs		= stmt.executeQuery(sql);
					if(srs.next())
					  srlno = srs.getInt("max");
					if(srs!= null) srs.close();

					if(srlno > 1)
						result = true;
					else
						result = false;

				}catch(Exception e)
				{
					result = false;
					sb.append("Exception in fetching records from ip_adt_trn_table :"+e);
					e.printStackTrace();
				}
			}

			if(result)
			{
				try
				{
					if(stringBuffer.length() > 0 ) stringBuffer.delete(0,stringBuffer.length());
					//stringBuffer.append(" update IP_ADT_TRN set trn_to_date_time = sysdate where srl_no = ("+srlno+" - 1) ");
					/*Tuesday, August 24, 2010 , MZ-SCF-0208 [IN:023428] since if we backdate discharge trn_to_date_time value going as sysdate instead of actual discharge date*/
					stringBuffer.append(" update IP_ADT_TRN set trn_to_date_time = to_date('"+dischargedate+"','dd/mm/rrrr hh24:mi') ");
					//updating audit columns
					stringBuffer.append(", modified_by_id = '" + modifiedById  + "', modified_date = sysdate, modified_facility_id = '");
					stringBuffer.append( facilityId +"', modified_at_ws_no = '"+ addedAtWorkstation +"'");
					stringBuffer.append(" where srl_no = ("+srlno+" - 1) ");
					stringBuffer.append(" and facility_id = '"+facilityId+"' and encounter_id = '"+encounterid+"' ");
					if(pstmt !=null) pstmt.close();
					pstmt = connection.prepareStatement(stringBuffer.toString());
					res	= 0;
					res = pstmt.executeUpdate();
					if(res!=0)
						result=true;
					else
					{
						result =false;
						sb.append("Error in inserting into ip_adt_trn_table");
					}
					if(pstmt !=null) pstmt.close();
				}catch(Exception ex)
				{
					result = false;
					sb.append("Exception in updating ip_adt_trn_table :"+ex.toString());
					ex.printStackTrace();
				}
			}

			if(result)
			{
				try
				{
					if(!bl_interfaced_yn.equals("Y"))
					{
						dailyrate = 0;
					}
					if (stringBuffer.length() > 0)
						stringBuffer.delete(0,stringBuffer.length());
					stringBuffer.append(" insert into IP_ADT_TRN (");
					stringBuffer.append(" facility_id,encounter_id, srl_no, patient_id, trn_type, ");
					stringBuffer.append(" trn_code,trn_date_time, fr_nursing_unit_code, fr_room_no, ");
					stringBuffer.append(" fr_bed_no, fr_bed_class_code, fr_bed_type_code, ");
					stringBuffer.append(" fr_daily_rate, fr_practitioner_id, fr_specialty_code, ");
					stringBuffer.append("  fr_service_code,fr_subservice_code, ");
					stringBuffer.append(" added_by_id, added_date, ");
					stringBuffer.append(" added_facility_id, added_at_ws_no, ");
					stringBuffer.append(" modified_by_id, modified_date, ");
					stringBuffer.append(" modified_facility_id, modified_at_ws_no, ");
					stringBuffer.append(" auth_practitioner_id,deceased_date_time, ");
					stringBuffer.append(" disch_practitioner_id, tfr_type, ");
					stringBuffer.append(" patient_class, admission_date_time  ");
					stringBuffer.append(" ) values ( ");
					stringBuffer.append(" ?, ?, ?, ?, ?, ?, to_date(?,'dd/mm/rrrr hh24:MI'),?,?,?,?,?,?,?, ?,?, ?,?, sysdate, ");
					stringBuffer.append(" ?, ?, ?, sysdate,?,?,?,to_date(?,'dd/mm/rrrr hh24:MI'), ?, ?, ?, to_date(?,'dd/mm/rrrr hh24:MI') )");
					sql =  stringBuffer.toString();

					if (preStatement != null)	preStatement.close();
					preStatement = connection.prepareStatement( sql );
					preStatement.setString	( 1, facilityId ) ;
					preStatement.setLong	( 2, encounterid ) ;
					preStatement.setInt		( 3, srlno ) ;
					preStatement.setString	( 4, patientid);
					preStatement.setString	( 5, "D" ) ;
					preStatement.setString	( 6, dischargetype ) ;
					preStatement.setString	( 7, dischargedate ) ;
					preStatement.setString	( 8, nursingunitcode ) ;
					preStatement.setString	( 9, roomno ) ;
					preStatement.setString	( 10, bedno ) ;
					preStatement.setString	( 11, bedclasscode ) ;
					preStatement.setString	( 12, bedtypecode ) ;
					preStatement.setInt		( 13, dailyrate ) ;
					preStatement.setString	( 14, practitionerid ) ;
					preStatement.setString	( 15, specialitycode ) ;
					preStatement.setString	( 16, servicecode ) ;
					preStatement.setString	( 17, subservice_code ) ;
					preStatement.setString	( 18, modifiedById);
					preStatement.setString	( 19, facilityId ) ;
					preStatement.setString	(20, addedAtWorkstation ) ;
					preStatement.setString	( 21, modifiedById ) ;
					preStatement.setString	( 22, facilityId ) ;
					preStatement.setString	( 23, addedAtWorkstation ) ;
					preStatement.setString	( 24, practid ) ;
					preStatement.setString	( 25, DECEASED_DATE_TIME ) ;
					preStatement.setString	( 26, dischg_practid ) ;
					preStatement.setString	( 27, "D" ) ;
					preStatement.setString	( 28, patient_class );
					preStatement.setString	( 29, admissiondatetime );
					res = 0;
					res = preStatement.executeUpdate() ;

					if(res!=0)
					{
						result=true;
					}
					else
					{
						result =false;
						sb.append("Error in inserting into ip_adt_trn_table");
					}
					if(preStatement!=null) preStatement.close();
				}catch (Exception exadt)
				{
					result = false;
					sb.append("Error in inserting into ip_adt_trn_table "+exadt.toString());
					exadt.printStackTrace();
				}
			}

			if(result)
			{
				try
				{
					if(stringBuffer.length() > 0 ) stringBuffer.delete(0,stringBuffer.length());
					stringBuffer.append(" update IP_ADT_TRN set DISCHARGE_DATE_TIME = to_date('"+dischargedate+"','dd/mm/rrrr hh24:mi') ");
					stringBuffer.append(", modified_by_id = ?, modified_date = sysdate, modified_facility_id = ? ");
					stringBuffer.append(", modified_at_ws_no = ? ");
					stringBuffer.append(" where facility_id = ? and encounter_id = ? ");

					sql	=	stringBuffer.toString();
					pstmt = connection.prepareStatement( sql );
					pstmt.setString	( 1, modifiedById ) ;
					pstmt.setString	( 2, facilityId ) ;
					pstmt.setString	( 3, addedAtWorkstation ) ;
					pstmt.setString	( 4, facilityId ) ;
					pstmt.setLong	( 5, encounterid ) ;
					rs = 0;
					rs  = pstmt.executeUpdate() ;

					if(rs > 0)
					{
						result = true;
					}
					else
					{
						result = false;
						sb.append("Error in updating pr_encounter_table ");
					}
					if(preStatement!=null) preStatement.close();


					res = pstmt.executeUpdate();
					if(res!=0)
						result=true;
					else
					{
						result =false;
						sb.append("Error in inserting into ip_adt_trn_table");
					}
					if(pstmt !=null) pstmt.close();
				}catch(Exception ex)
				{
					result = false;
					sb.append("Exception in updating ip_adt_trn_table :"+ex.toString());
					ex.printStackTrace();
				}

			}



			if(result)
			{
				if (stringBuffer.length() > 0)
					stringBuffer.delete(0,stringBuffer.length());
				stringBuffer.append(" update IP_NURSING_UNIT set num_of_beds_occupied = num_of_beds_occupied - 1 ");
				stringBuffer.append(", modified_by_id = ?, modified_date = sysdate, ");
				stringBuffer.append(" modified_facility_id = ?, modified_at_ws_no = ?");
				stringBuffer.append(" where facility_id = ? and nursing_unit_code = ? ");
				if (preStatement != null)	preStatement.close();
				preStatement = connection.prepareStatement(stringBuffer.toString());
				preStatement.setString	( 1, modifiedById);
				preStatement.setString	( 2, facilityId ) ;
				preStatement.setString	( 3, addedAtWorkstation ) ;
				preStatement.setString	( 4, facilityId);
				preStatement.setString	( 5, nursingunitcode ) ;
				int res2 = preStatement.executeUpdate() ;
				if(res2!=0)
					result=true;
				else
				{
					result =false;
					sb.append("Error in Updating ip_nursing_unit_table ");
				}
				if(preStatement!=null) preStatement.close();
			}
			if(patientgender.equals("M")) L_male_count    = 1;
			if(patientgender.equals("F")) L_female_count  = 1;
			if(patientgender.equals("U")) L_unknown_count = 1;

			if(result)
			{
				try
				{
					if (stringBuffer.length() > 0)
						stringBuffer.delete(0,stringBuffer.length());
					stringBuffer.append(" update IP_NURSING_UNIT_ROOM set ");
					stringBuffer.append(" occ_male_bed_count = occ_male_bed_count-?, occ_female_bed_count = occ_female_bed_count-?, ");
					stringBuffer.append(" occ_unknown_bed_count = occ_unknown_bed_count-?, modified_by_id = ?, ");
					stringBuffer.append(" modified_date = sysdate, modified_facility_id = ?, modified_at_ws_no = ? ");
					stringBuffer.append(" where facility_id=? and nursing_unit_code = ? and room_no = ? ");
					if (preStatement != null)	preStatement.close();
					preStatement = connection.prepareStatement(stringBuffer.toString());
					preStatement.setInt	( 1, L_male_count ) ;
					preStatement.setInt	( 2, L_female_count);
					preStatement.setInt	( 3, L_unknown_count);
					preStatement.setString	( 4, modifiedById);
					preStatement.setString	( 5, facilityId ) ;
					preStatement.setString	( 6, addedAtWorkstation ) ;
					preStatement.setString	( 7, facilityId);
					preStatement.setString	( 8, nursingunitcode ) ;
					preStatement.setString	( 9, roomno ) ;
					res3 = preStatement.executeUpdate() ;
					if(res3!=0)
						result=true;
					else
					{
						result =false;
						sb.append("Error in Updating ip_nursing_unit_room_table ");
					}
					if(preStatement!=null) preStatement.close();
				}catch(Exception e)
				{
					result = false;
					sb.append("Error in Updating ip_nursing_unit_room_table : "+e.getMessage());
					e.printStackTrace();
				}
			}

			if(result)
			{
				try
				{
					if (stringBuffer.length() > 0)
						stringBuffer.delete(0,stringBuffer.length());
					stringBuffer.append(" select pseudo_bed_yn from IP_NURSING_UNIT_BED ");
					stringBuffer.append(" where facility_id = '");
					stringBuffer.append(facilityId);
					stringBuffer.append("' and nursing_unit_code = '");
					stringBuffer.append(nursingunitcode);
					stringBuffer.append("' and bed_no = '");
					stringBuffer.append(bedno);
					stringBuffer.append("' ");
					if(stmt!=null)stmt.close();
					stmt = connection.createStatement();
					srs = stmt.executeQuery(stringBuffer.toString());
					if((srs != null) && (srs.next()))
						pseudobedyn = checkForNull(srs.getString("pseudo_bed_yn"));
					if(srs!= null) srs.close();
				}catch(Exception e)
				{
					result = false;
					sb.append("Exception in fetching values from ip_nursing_unit_bed_table : "+e);
					e.printStackTrace();
				}
			}
			
			if(result)
			{
				try
				{
					if (stringBuffer.length() > 0)
						stringBuffer.delete(0,stringBuffer.length());
					stringBuffer.append(" update IP_NURSING_UNIT_BED set ");
					stringBuffer.append(" occupied_until_date_time = ?, ");	
					stringBuffer.append(" occupying_patient_id = ?, current_status = 'A',  modified_by_id = ?, ");
					stringBuffer.append("modified_date = sysdate, modified_facility_id = ? ,modified_at_ws_no = ? ");
					if(deactivate_pseudo_bed_yn.equals("Y") && pseudobedyn.equals("Y"))
						stringBuffer.append(", psuedo_bed_status = 'C' ");
					stringBuffer.append(" where facility_id = ? and nursing_unit_code = ? and bed_no = ? ");
					if (preStatement != null)	preStatement.close();
					preStatement = connection.prepareStatement(stringBuffer.toString());
					preStatement.setString	( 1, null ) ;
					preStatement.setString	( 2, null ) ;
					preStatement.setString	( 3, modifiedById);
					preStatement.setString	( 4, facilityId ) ;
					preStatement.setString	( 5, addedAtWorkstation ) ;
					preStatement.setString	( 6, facilityId);
					preStatement.setString	( 7, nursingunitcode ) ;
					preStatement.setString	( 8, bedno ) ;
					res4 = 0;
					res4 = preStatement.executeUpdate() ;
					if(res4!=0)
						result=true;
					else
					{
						result =false;
						sb.append("Error in Updating ip_nursing_unit_bed_table");
					}
					if(preStatement!=null) preStatement.close();
				}catch(Exception e)
				{
					result = false;
					sb.append("Exception in updating ip_nursing_unit_bed_table : "+e);
					e.printStackTrace();
				}
			}

			if(mother_bed_status.equals("Y") && result)
			{
				try
				{
					if(stringBuffer.length() > 0 ) stringBuffer.delete(0,stringBuffer.length());
					stringBuffer.append(" update IP_NURSING_UNIT_BED set ");
					stringBuffer.append(" occupying_patient_id = ?, occupied_until_date_time = ?, mothers_patient_id = ?, ");
					stringBuffer.append(" mothers_encounter_id = ?, current_status = 'A', modified_date = sysdate, ");
					stringBuffer.append(" modified_facility_id = ?, modified_by_id = ?, modified_at_ws_no = ? ");
					stringBuffer.append(" where facility_id = ? and nursing_unit_code = ?  and main_bed_no = ?");
					if (preStatement != null)	preStatement.close();
					preStatement = connection.prepareStatement(stringBuffer.toString());
					preStatement.setString	( 1, null ) ;
					preStatement.setString	( 2, null ) ;
					preStatement.setString	( 3, null ) ;
					preStatement.setString	( 4, null ) ;
					preStatement.setString	( 5, facilityId);
					preStatement.setString	( 6, modifiedById) ;
					preStatement.setString	( 7, addedAtWorkstation) ;
					preStatement.setString	( 8, facilityId);		
					preStatement.setString	( 9, nursingunitcode ) ;
					preStatement.setString	( 10, bedno ) ;
					res4 = 0;
					res4 = preStatement.executeUpdate() ;
					if(res4!=0)
						result=true;
					else
					{
						result =false;
						sb.append(" Error in Updating ip_nursing_unit_bed_table ");
					}
					if(preStatement!=null) preStatement.close();
				}catch(Exception e)
				{
					result = false;
					sb.append("Exception in updating ip_nursing_unit_bed_table : "+e);
					e.printStackTrace();
				}
			}
			// Start of FM logic ...
			if(result)
			{
				String sql16 = "select install_yn from SM_MODULE where module_id = 'FM' ";
				/*String dflt_incomplete_fs_locn_code		=	"";
				 String dflt_incomplete_fs_locn_identity	=	"";
				 String fm_fs_locn_code					=	"";
				 String fm_fs_locn_identity				=	"";
				 String file_no							=	"";
				 int volume_no						=	0;
				 String holder_name						=	"";*/
				stmt_add		= connection.createStatement();
				rs_add			= stmt_add.executeQuery(sql16);
				if (rs_add!=null && rs_add.next())
					fm_install_yn = checkForNull(rs_add.getString(1));
				if(fm_install_yn.equals("Y"))
				{
					try
					{
						if (stringBuffer.length() > 0)
							stringBuffer.delete(0,stringBuffer.length());
								

								
								cstmt = connection.prepareCall("{call FM_MOV_FILE_TO_INCOMPL_FS_LOCN(?,?,?,?,?,?,?)}");
								cstmt.setString(1,  facilityId);
								cstmt.setString(2,  patientid);
								cstmt.setString(3,  locn_type);
								cstmt.setString(4,  nursingunitcode);
								cstmt.setString(5,  modifiedById);
								cstmt.setString(6,  addedAtWorkstation);
								cstmt.registerOutParameter(7,java.sql.Types.VARCHAR);

								cstmt.execute();
								String err_val = cstmt.getString(7);

								if(err_val == null)
								{
									result = true;
								}
								else
								{
									sb.append("Procedure-FM_MOV_FILE_TO_INCOMPL_FS_LOCN FAILED");
									result = false;
								}


						/*stringBuffer.append(" Select a.dflt_incomplete_fs_locn_code, b.locn_identity, b.holder_name from ");
						stringBuffer.append(" FM_PARAMETER a, FM_STORAGE_LOCN b where a.facility_id = b.facility_id ");
						stringBuffer.append(" and dflt_incomplete_fs_locn_code  = b.fs_locn_code and b.facility_id ='");
						stringBuffer.append(facilityId);
						stringBuffer.append("' ");
						if(rs_add != null) rs_add.close();
						rs_add = stmt.executeQuery(stringBuffer.toString());
						if (rs_add!=null && rs_add.next())
						{
							dflt_incomplete_fs_locn_code	 = rs_add.getString(1);
							dflt_incomplete_fs_locn_identity = rs_add.getString(2);
							holder_name= rs_add.getString(3);
						}
						if(dflt_incomplete_fs_locn_code==null) 
							dflt_incomplete_fs_locn_code="";*/
					}catch(Exception e)
					{
						result = false;
						//sb.append(" Exception in selecting dflt_incomplete_fs_locn_code : "+e);
						sb.append(" Exception in updation of procedure  FM_MOV_FILE_TO_INCOMPL_FS_LOCN : "+e);
						e.printStackTrace();
					}
					finally {
							if (cstmt != null)
								cstmt.close();
						}								

					/*try
					{
						if(!dflt_incomplete_fs_locn_code.equals(""))
						{
							if (stringBuffer.length() > 0)
								stringBuffer.delete(0,stringBuffer.length());
							stringBuffer.append("select file_no, volume_no from FM_CURR_LOCN where ");
							stringBuffer.append("facility_id = '"+facilityId+"' and patient_id='"+patientid+"' ");
							if(rs_add != null) rs_add.close();
							rs_add = stmt.executeQuery(stringBuffer.toString());
							if (rs_add!=null && rs_add.next())
							{
								file_no= rs_add.getString("file_no");
									if(file_no==null) file_no ="";
								volume_no= rs_add.getInt("volume_no");
							}
							if (stringBuffer.length() > 0)
								stringBuffer.delete(0,stringBuffer.length());
							stringBuffer.append("select b.fs_locn_code,c.locn_identity from  fm_curr_locn a, ip_nursing_unit b, ");
							stringBuffer.append("fm_storage_locn c  where a.curr_fs_locn_code = b.fs_locn_code ");
							stringBuffer.append("and a.facility_id = b.facility_id and a.curr_facility_id = c.facility_id ");
							stringBuffer.append("and a.curr_fs_locn_code = c.fs_locn_code and a.facility_id ='");
							stringBuffer.append(facilityId);
							stringBuffer.append("' and a.file_no = '");
							stringBuffer.append(file_no);
							stringBuffer.append("' and a.volume_no = '");
							stringBuffer.append(volume_no);
							stringBuffer.append("' and b.nursing_unit_code = '");
							stringBuffer.append(nursingunitcode);
							stringBuffer.append("' ");
							if(rs_add != null) rs_add.close();
							rs_add	=	stmt.executeQuery(stringBuffer.toString());
							if (rs_add!=null && rs_add.next())
							{
								fm_fs_locn_code		= rs_add.getString(1);
								fm_fs_locn_identity = rs_add.getString(2);
							}
							if (fm_fs_locn_code==null) fm_fs_locn_code="";
							if(fm_fs_locn_code!="")
							{
								sql16 = "insert into fm_movement_log(facility_id, file_no, sent_date_time, patient_id, src_facility_id, src_fs_locn_code, src_locn_identity, src_user_id, dest_facility_id, rec_date_time, dest_fs_locn_code, dest_locn_identity, dest_user_id, movement_type, src_mr_locn_yn, dest_mr_locn_yn, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id,volume_no) values( ?,?,sysdate,?,?,?,?,?,?,sysdate,?,?,?,'F','N','N',?,sysdate,?,?,?,sysdate,?,?,?)";
								if (preStatement != null)	preStatement.close();
								preStatement = connection.prepareStatement(sql16);
								preStatement.setString	( 1, facilityId) ;
								preStatement.setString	( 2, file_no);
								preStatement.setString	( 3, patientid) ;
								preStatement.setString	( 4, facilityId) ;
								preStatement.setString	( 5, fm_fs_locn_code) ;
								preStatement.setString	( 6, fm_fs_locn_identity) ;
								preStatement.setString	( 7, modifiedById) ;
								preStatement.setString	( 8, facilityId) ;
								preStatement.setString	( 9, dflt_incomplete_fs_locn_code) ;
								preStatement.setString	( 10, dflt_incomplete_fs_locn_identity) ;
								preStatement.setString	( 11, modifiedById) ;
								preStatement.setString	( 12, modifiedById) ;
								preStatement.setString	( 13, addedAtWorkstation) ;
								preStatement.setString	( 14, facilityId) ;
								preStatement.setString	( 15, modifiedById) ;
								preStatement.setString	( 16, addedAtWorkstation) ;
								preStatement.setString	( 17, facilityId) ;
								preStatement.setInt	( 18, volume_no) ;
								res = 0;
								res= preStatement.executeUpdate() ;
								if(res>0 )  
									result = true; 
								else
								{
									result = false;
									sb.append("Error in while insert into fm_movement_log");
								}
								if(preStatement!=null) preStatement.close();
								
								if(result)
								{
									if (stringBuffer.length() > 0)
										stringBuffer.delete(0,stringBuffer.length());
									stringBuffer.append("update fm_curr_locn set iss_date_time = sysdate, curr_facility_id =?, ");
									stringBuffer.append("curr_file_status = 'O', curr_fs_locn_code = ?, curr_fs_locn_identity = ?, ");
									stringBuffer.append("curr_holder_user_id = ?, last_movement_date_time = sysdate,");
									stringBuffer.append("prev_facility_id = ?, prev_fs_locn_code = ?, ");
									stringBuffer.append("modified_by_id = ?, modified_date = sysdate, modified_at_ws_no = ?, ");
									stringBuffer.append("modified_facility_id = ? ");
									stringBuffer.append("where facility_id = ? and file_no = ? and volume_no = ?");
									if (preStatement != null)	preStatement = null;
									preStatement = connection.prepareStatement(stringBuffer.toString());
									preStatement.setString	( 1,  facilityId) ;
									preStatement.setString	( 2,  dflt_incomplete_fs_locn_code) ;
									preStatement.setString	( 3,  dflt_incomplete_fs_locn_identity) ;
									preStatement.setString	( 4,  holder_name) ;
									preStatement.setString	( 5,  facilityId) ;
									preStatement.setString	( 6,  fm_fs_locn_code) ;
									preStatement.setString	( 7, modifiedById) ;
									preStatement.setString	( 8, addedAtWorkstation) ;
									preStatement.setString	( 9, facilityId) ;
									preStatement.setString	( 10, facilityId) ;
									preStatement.setString	( 11, file_no) ;
									preStatement.setInt	( 12, volume_no) ;
									res = 0;
									res = preStatement.executeUpdate() ;
									if(res>0 )  
										result = true;
									else 
									{
										result = false;
										sb.append("Error in while update fm_curr_locn_table");
									}
									if(preStatement!=null) preStatement.close();
								}
							}
						}
					}catch(Exception exp)
					{
						result = false;
						sb.append("sql exp at fm_install : "+exp.getMessage());
					}*/
				}
			}
			//...FM logic ends here
			/*Friday, May 14, 2010 , update will done through IP_GET_BOOKING_SRL_NO.GET_IP_BED_BKG_SRL_NO at line no 205*/
			/*
			if(result)
			{
				
				try
				{
					if (!blockuntildate.equals(""))
					{
						if (stringBuffer.length() > 0)
							stringBuffer.delete(0,stringBuffer.length());
						stringBuffer.append(" select next_booking_srl_no from IP_BED_BOOKING_SRL_CTRL ");
						stringBuffer.append(" where facility_id = '");
						stringBuffer.append(facilityId);
						stringBuffer.append("' and booking_type = 'D' ");
						if(stmt!=null)stmt.close();
						stmt = connection.createStatement();
						srs = stmt.executeQuery(stringBuffer.toString());
						if((srs != null) && (srs.next()))
							bookingrefno = checkForNull(srs.getString("next_booking_srl_no"));
					}
				}catch(Exception e)
				{
					result = false;
					sb.append("Exception in fetching records from ip_bed_booking_srl_ctrl_table : "+e);
					e.printStackTrace();
				}
			}

			
			if(result && !blockuntildate.equals("") && !bookingrefno.equals(""))
			{
				try
				{
					if (stringBuffer.length() > 0)
						stringBuffer.delete(0,stringBuffer.length());
					stringBuffer.append(" update IP_BED_BOOKING_SRL_CTRL set next_booking_srl_no = ");
					stringBuffer.append(" next_booking_srl_no+1 , modified_by_id = '");
					stringBuffer.append(modifiedById);
					stringBuffer.append("' ,modified_date = sysdate ,modified_facility_id = '");
					stringBuffer.append(facilityId);
					stringBuffer.append("' ,modified_at_ws_no = '");
					stringBuffer.append(addedAtWorkstation);
					stringBuffer.append("' where facility_id = '");
					stringBuffer.append(facilityId);
					stringBuffer.append("' and booking_type = 'D' ");
					if(stmt!=null)stmt.close();
					stmt	= connection.createStatement();
					rs		= stmt.executeUpdate(stringBuffer.toString());
					if(rs!=0)
						result=true;
					else
					{
						result =false;
						sb.append("Error in Updating IP_BED_BOOKING_SRL_CTRL");
					}
				}catch(Exception e)
				{
					result = false;
					sb.append("Exception in updating IP_BED_BOOKING_SRL_CTRL : "+e);
					e.printStackTrace();
				}
			}*/

			if(result && !blockuntildate.equals("") && bookingrefno >0)
			{
				try
				{
					if (stringBuffer.length() > 0)
						stringBuffer.delete(0,stringBuffer.length());
					stringBuffer.append("insert into IP_BED_BOOKING (");
					stringBuffer.append("facility_id, booking_type, bed_booking_ref_no,  ");
					stringBuffer.append("blocked_from_date_time, blocked_until_date_time, ");
					stringBuffer.append("added_by_id, added_date, added_at_ws_no, added_facility_id, ");
					stringBuffer.append("modified_by_id, modified_date, modified_at_ws_no, modified_facility_id, ");
					stringBuffer.append("req_nursing_unit_code, req_service_code, req_bed_no, req_room_no, ");
					stringBuffer.append("req_bed_class_code, req_bed_type_code, req_practitioner_id, ");
					stringBuffer.append("req_specialty_code, booked_by_id, booking_date_time, booking_status, ");
					stringBuffer.append("blocking_type_code, blocking_remarks, override_yn) values (");
					stringBuffer.append("?, ?, ?, sysdate, to_date(?,'dd/mm/rrrr hh24:mi'), ?, sysdate, ?, ?, ?, ");
					stringBuffer.append("sysdate, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate, ?, ?, ?, ?)");
					if (preStatement != null)	preStatement = null;
					preStatement = connection.prepareStatement(stringBuffer.toString());
					preStatement.setString	( 1, facilityId ) ;
					preStatement.setString	( 2, "D") ;
					preStatement.setInt	( 3, bookingrefno ) ;
					preStatement.setString	( 4, blockuntildate ) ;
					preStatement.setString	( 5, modifiedById ) ;
					preStatement.setString	( 6, addedAtWorkstation ) ;
					preStatement.setString	( 7, facilityId);
					preStatement.setString	( 8, modifiedById);
					preStatement.setString	( 9, addedAtWorkstation);
					preStatement.setString	( 10, facilityId);
					preStatement.setString	( 11, nursingunitcode);
					preStatement.setString	( 12, servicecode);
					preStatement.setString	( 13, bedno);
					preStatement.setString	( 14, roomno);
					preStatement.setString	( 15, bedclasscode);
					preStatement.setString	( 16, bedtypecode);
					preStatement.setString	( 17, practitionerid);
					preStatement.setString	( 18, specialitycode);
					preStatement.setString	( 19, modifiedById);
					preStatement.setString	( 20, "0");
					preStatement.setString	( 21, blocking_type_code);
					preStatement.setString	( 22, bed_block_remarks);
					preStatement.setString	( 23, override_yn);
					int res5 = preStatement.executeUpdate();
					if(res5 != 0)
						result = true;
					else
					{
						result = false;
						sb.append("Error in inserting into ip_bed_booking_table");
					}
					if(preStatement!=null) preStatement.close();
				}catch(Exception e)
				{
					result = false;
					sb.append("Exception in inserting into ip_bed_booking_table : "+e);
					e.printStackTrace();
				}
			}



			if (bl_operational.equals("Y"))
				boolBLInstall = true;
			else
				boolBLInstall = false;
			// MOD#01 Interface part for BL starts
			if(result && boolBLInstall)
			{
				try
				{
					String  episode_id	=	encounter_id;
					function_id="DISCHARGE_PATIENT";
					
					if(patient_class.equals("IP"))
	 					episode_type = "I";
					else if(patient_class.equals("DC"))
						episode_type = "D";
					
					Hashtable hashtableBill = new Hashtable();
					hashtableBill.put("facility_id",facilityId);
					hashtableBill.put("patient_id",patientid);
					hashtableBill.put("encounter_id",encounter_id);
					hashtableBill.put("episode_id",episode_id);
					hashtableBill.put("function_id",function_id);
					hashtableBill.put("locale",locale);
					hashtableBill.put("dischargedate",dischargedate);
					hashtableBill.put("dischargetype",dischargetype);
					hashtableBill.put("practitionerid",practitionerid);
					hashtableBill.put("specialitycode",specialitycode);
					hashtableBill.put("patienttype",patienttype);
					hashtableBill.put("bedclasscode",bedclasscode);
					hashtableBill.put("nursingunitcode",nursingunitcode);
					hashtableBill.put("servicecode",servicecode);
					hashtableBill.put("bedno",bedno);
					hashtableBill.put("roomno",roomno);
					hashtableBill.put("dailyrate",daily_rate);
					hashtableBill.put("dischargeremarks",dischargeremarks);
					hashtableBill.put("blockuntildate",blockuntildate);
					hashtableBill.put("admissiondatetime",admissiondatetime);
					hashtableBill.put("bedtypecode",bedtypecode);
					hashtableBill.put("patientgender",patientgender);
					hashtableBill.put("deceasedyn",deceasedyn);
					hashtableBill.put("postmortemrequest",postmortemrequest);
					hashtableBill.put("dischargesummarysigned",dischargesummarysigned);
					hashtableBill.put("newmedicine",newmedicine);
					hashtableBill.put("addedAtWorkstation",addedAtWorkstation);
					hashtableBill.put("billing_interfaced",bl_interfaced_yn);
					hashtableBill.put("referred",referred);
					hashtableBill.put("referral_type",referral_type);
					hashtableBill.put("referred_to",referred_to);
					hashtableBill.put("priority",priority);
					hashtableBill.put("preferred_date",preferred_date);
					hashtableBill.put("speciality",speciality);
					hashtableBill.put("service",service);
					hashtableBill.put("location0",location0);
					hashtableBill.put("location1",location1);
					hashtableBill.put("location2",location2);
					hashtableBill.put("practitioner",practitioner);
					hashtableBill.put("practitioner1",practitioner1);
					hashtableBill.put("hcare_setting_type_desc",hcare_setting_type_desc);
					hashtableBill.put("hcare_setting_type",hcare_setting_type);
					hashtableBill.put("open_to_all_pract_yn",open_to_all_pract_yn);
					hashtableBill.put("from_hcare_setting_type_code",from_hcare_setting_type_code);
					hashtableBill.put("eid",eid);
					hashtableBill.put("SickLeaveRecordFlag",SickLeaveRecordFlag);
					hashtableBill.put("LeaveFrom",LeaveFrom);
					hashtableBill.put("LeaveTo",LeaveTo);
					hashtableBill.put("FitForDuty",FitForDuty);
					hashtableBill.put("FitonDuty",FitonDuty);
					hashtableBill.put("CertIssued",CertIssued);
					hashtableBill.put("AuthorizedById",AuthorizedById);
					hashtableBill.put("remarks",remarks);
					hashtableBill.put("practid",practid);
					hashtableBill.put("DECEASED_DATE_TIME",DECEASED_DATE_TIME);
					hashtableBill.put("billing_installed",bl_operational);
					hashtableBill.put("episode_type",episode_type);
					
					BLDischargePatient blDischargePatient = new BLDischargePatient();
					Hashtable resultsBL = blDischargePatient.billPatientService(p,connection,hashtableBill);
					result = ((Boolean) resultsBL.get("status")).booleanValue();
					
					if(!result){
					error = (String) (resultsBL.get("error"));
					sb.append(error);
					BillResult = "FAIL";
					}
					else
						BillResult = "PASS";
					resultsBL.clear();
					hashtableBill.clear();

					
				}catch(Exception exceptionBL)
				{
					result  = false;
					sb.append(" eBL Error : "+exceptionBL);
					exceptionBL.printStackTrace();
				}
			}// End of MOD#01


			try
			{

				if(stringBuffer.length() > 0)	stringBuffer.delete(0,stringBuffer.length());
				stringBuffer.append(" update IP_RESERVED_BED_DTL set RESERVED_TO_TIME = SYSDATE, MODIFIED_BY_ID = '"+modifiedById+"' , MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO = '"+addedAtWorkstation+"', MODIFIED_FACILITY_ID  = '"+facilityId+"' where FACILITY_ID = '"+facilityId+"' and  ENCOUNTER_ID = '"+encounter_id+"' and reserved_to_time is null ");
				rs = 0;
				preStatement = connection.prepareStatement(stringBuffer.toString());
				rs  = preStatement.executeUpdate() ;

				if(preStatement!=null) preStatement.close();
			}catch(Exception e)
			{
				result = false;
				sb.append("Error in updating IP_RESERVED_BED_DTL "+e.toString());
				e.printStackTrace();
			}
		try
		{

			
			if (stringBuffer.length() > 0)	stringBuffer.delete(0,stringBuffer.length());
			stringBuffer.append(" update IP_BED_BOOKING set booking_status = '2' , ");
			stringBuffer.append(" blocked_until_date_time = sysdate, modified_by_id='"+modifiedById+"',");
			stringBuffer.append(" modified_date = sysdate,  modified_at_ws_no = '"+addedAtWorkstation+"',  modified_facility_id ='"+facilityId+"'  ");
			//stringBuffer.append(" where facility_id = '"+facilityId+"' and encounter_id = '"+encounter_id+"' and booking_type ='N'  and blocked_until_date_time IS null ");
			/*Thursday, September 09, 2010 , SRR20056-SCF-5168 [IN:023714] condition added or blocked_until_date_time > SYSDATE */
			stringBuffer.append(" where facility_id = '"+facilityId+"' and encounter_id = '"+encounter_id+"' and booking_type ='N'  and ( BLOCKED_UNTIL_DATE_TIME IS NULL or blocked_until_date_time > SYSDATE) ");
			res = 0;
			preStatement = connection.prepareStatement( stringBuffer.toString() );
			res = preStatement.executeUpdate() ;
			if(preStatement != null) preStatement.close();

		}
		catch (Exception exp)
		{
			result = false;
			sb.append("Error in updating IP_BED_BOOKING "+exp.toString());
			exp.printStackTrace();
		}
		/*Monday, January 11, 2010 IN018051 ,bed side referral closed while patient discharge. */
		/*below line modified for this CRF HSA-CRF-0263.1*/
		if(result)
		{
		   
		if(allow_muti_bedside_review_yn.equals("N")){ //Added for this HSA-CRF-0263.1
			try{
				if (stringBuffer.length() > 0)	stringBuffer.delete(0,stringBuffer.length());
				stringBuffer.append(" Update PR_REFERRAL_REGISTER set STATUS = ? , referred_in_func = 5, ");
				stringBuffer.append(" modified_by_id = ?,");
				stringBuffer.append(" modified_date = sysdate,  modified_at_ws_no = ?,  modified_facility_id = ?, bedside_ref_review_status=?  ");
				stringBuffer.append(" where from_encounter_id = ? and BEDSIDE_REFERRAL_YN = ? ");
				/*Below line commented and above line added for this CRF HSA-CRF-0146*/
				//stringBuffer.append(" where from_encounter_id = ? and BEDSIDE_REFERRAL_YN = ? and bedside_ref_seen_date is null  ");

				res = 0;
				preStatement = connection.prepareStatement( stringBuffer.toString() );
				preStatement.setString(1,"C");
				preStatement.setString(2,modifiedById);
				preStatement.setString(3,addedAtWorkstation);
				preStatement.setString(4,facilityId);
				preStatement.setString(5,"C"); // CRF HSA-CRF-0146
				preStatement.setString(6,encounter_id);
				preStatement.setString(7,"Y");
				res = preStatement.executeUpdate() ;
				if(preStatement != null) preStatement.close();

			}catch (Exception exp){
					result = false;
					sb.append("Error in updating PR_REFERRAL_REGISTER "+exp.toString());
					exp.printStackTrace();
			}
		} //End for this HSA-CRF-0263.1
			
			try
			{
						
				if(stringBuffer.length() > 0)
				stringBuffer.delete(0, stringBuffer.length());
				stringBuffer.append(" SELECT  REFERRAL_ID refid");
				stringBuffer.append(" FROM pr_referral_register a ");
				stringBuffer.append(" WHERE added_facility_id = '"+facilityId+"' ");
				stringBuffer.append(" AND from_encounter_id ='"+encounter_id+"'");
				stringBuffer.append(" AND bedside_referral_yn != 'Y' and status = 'D' "); 
		         if(stmt!=null)stmt.close();
			    stmt = connection.createStatement();
			    
				rset = stmt.executeQuery(stringBuffer.toString());
				boolean first_time = true;
	
				while(rset.next())
				{
					ref_id = rset.getString("refid");

					if(first_time)
					  referral_id_list = "('"+ref_id+"'" ;
					else
						referral_id_list = referral_id_list + ",'" +ref_id +"'";

					first_time = false;
				}

				if(!first_time)
					referral_id_list = referral_id_list + ")";

				if(rset != null) rset.close();
				if(stmt != null) stmt.close();
				if(referral_id_list != "")
				{
					if(result)
					{
						if(stringBuffer.length() > 0)
							stringBuffer.delete(0, stringBuffer.length());
						
						stringBuffer.append(" update pr_referral_register set status = 'O',");
						stringBuffer.append(" modified_by_id=?,modified_date=sysdate,modified_facility_id=?, ");
						stringBuffer.append(" modified_at_ws_no=?");
						stringBuffer.append(" where referral_id in ");
						stringBuffer.append(referral_id_list);
						
                        res = 0;
						preStatement = connection.prepareStatement( stringBuffer.toString() );
				        
						preStatement.setString(1, modifiedById);
						preStatement.setString(2, facilityId);
						preStatement.setString(3, addedAtWorkstation);

						res = preStatement.executeUpdate();
						if(preStatement != null)	preStatement.close();
		         	}
					}
					}
			catch (Exception exp)
			{
				result = false;
				sb.append("Error in updating PR_REFERRAL_REGISTER table  "+exp.toString());
				exp.printStackTrace();
			}
			
			//end for Incident NO:34615 by Srinivas
			
			
		}
		/**/
		/* Added by kamatchi S ML-MMOH-CRF-1972 IP history patient list issue */
		if(result && isForAdmission)
					{
						try
						{
							if(sql1.length() > 0) sql1.delete(0,sql1.length());
							sql1.append(" select encounter_id,pendng_admission_date_time from  ae_current_patient where  patient_id='"+patientid+"' and  FACILITY_ID = '"+facilityId+"' and ROWNUM = 1 order by queue_date desc");
							pstmt2   = connection.prepareStatement( sql1.toString() );
							rs2 = pstmt2.executeQuery() ;
							long ae_encounter_id=0;
							String pendng_admission_date_time="";
							if(rs2!=null){
							if(rs2.next())
								{
									ae_encounter_id=rs2.getLong("encounter_id");
									pendng_admission_date_time=checkForNull(rs2.getString("pendng_admission_date_time"));
									System.err.println("ae_encounter_id================="+ae_encounter_id);
									System.err.println("pendng_admission_date_time================="+pendng_admission_date_time);
								}
							}
								if(pstmt2!=null) pstmt2.close();
								if(rs2!=null) rs2.close();
								if(!pendng_admission_date_time.equals(""))
								{
								if(sql1.length() > 0) sql1.delete(0,sql1.length());
	
							sql1.append(" UPDATE ae_current_patient SET  pendng_admission_date_time= NULL, modified_by_id= '"+modifiedById+"', modified_date = sysdate, modified_facility_id = '"+facilityId+"', modified_at_ws_no = '"+addedAtWorkstation+"' WHERE facility_id = '"+facilityId+"' AND encounter_id = '"+ae_encounter_id+"' ");
							pstmt2   = connection.prepareStatement( sql1.toString() );
							res1 = pstmt2.executeUpdate() ;
							if(res1 > 0 ) 
								result = true; 
							else
							{
								result = false;
								sb.append("Exception in updating ae_current_patient");
							}	
									
								}
							
						}
						catch(Exception e1)
						{
							result = false;
							sb.append("Exception in updating ae_current_patient");
							e1.printStackTrace();
						}
					}

		// Changes for BRU-HIMS-CRF-0231: DS Diet orders should be closed when a patient is discharged
		if(result){
			try{

					cstmt = connection.prepareCall("{call Ds_Meal_Plan_Generation.Proc_Dis_Patients(?,sysdate,?,?,?,?,?)}");

					cstmt.setString(1, facilityId);
					cstmt.setString(2, "");
					cstmt.setString(3, "");
					cstmt.setString(4, modifiedById);
					cstmt.setString(5, addedAtWorkstation);
					cstmt.setString(6,encounter_id);
					cstmt.execute();
					//connection.commit();
					if(cstmt != null)	cstmt.close(); //Added for checkstyle
			}
			catch(Exception exp){
//	Commented: To be reviewed			result = false;
				sb.append("Error in calling Proc_Dis_Patients "+exp.toString());
				exp.printStackTrace();
			}
		}	
			if(result)
			{
				result = true ;
				java.util.Hashtable message = MessageManager.getMessage(locale,"RECORD_MODIFIED","SM");
				sb.append( (String) message.get("message"));
				message.clear();
				connection.commit();
			}
			else
			{
				if(BillResult.equals("FAIL"))
					sb.append(" Billing Updation failed... ");
				else
					sb.append(" Transaction Failed... ");
				connection.rollback();
			}
			
			/*Below line added for this  HSA-CRF-0306.1*/
			boolean siteSpecific=CommonBean.isSiteSpecific(connection,"FM","CURRENT_FS_LOCATION");
			System.err.println("IPDischargePatientManager.java siteSpecific===>"+siteSpecific);
			if(siteSpecific && result){
			
             
			  //int currentencounterid=Integer.parseInt(encounter_id);
			  System.err.println("IPDischargePatientManager.java patientid===>"+patientid);			  
			 // System.err.println("IPDischargePatientManager.java currentencounterid===>"+currentencounterid);
			  System.err.println("IPDischargePatientManager.java location0 ===>"+location0);
			  System.err.println("IPDischargePatientManager.java location1===>"+location1);
			  System.err.println("IPDischargePatientManager.java location2===>"+location2);
			  System.err.println("IPDischargePatientManager.java nursingunitcode===>"+nursingunitcode);
			  System.err.println("IPDischargePatientManager.java encounterid===>"+encounterid);
			  System.err.println("IPDischargePatientManager.java patient_class===>"+patient_class);
			  System.err.println("IPDischargePatientManager.java daycare_unit_code===>"+daycare_unit_code);
			  
			  String current_loc_id="";
			  if(patient_class.equals("DC"))current_loc_id=daycare_unit_code;
			  if(patient_class.equals("IP"))current_loc_id=nursingunitcode;
			  System.err.println("IPDischargePatientManager.java current_loc_id===>"+current_loc_id);
			 
							 			  			  
                cstmt = connection.prepareCall("{call sm_day_return_date_proc(?,?,?,?,?,?,?,?)}");				
				cstmt.setString(1, "");
				cstmt.setString(2, facilityId);
				cstmt.setString(3, "DISCHARGE");
				cstmt.setString(4, "");	
                cstmt.setString(5, patientid);               		
				cstmt.setString(6, current_loc_id);                 					
                cstmt.setLong(7, encounterid);					
				cstmt.registerOutParameter(8,java.sql.Types.VARCHAR);
				cstmt.execute();					
				errmsg=cstmt.getString(8); 
			   
			}
           	
			//End HSA-CRF-0306.1
			
			
			
		}catch ( Exception e ) 
		{
			try
			{
				sb.append("Current Transaction Failed :: "+e.getMessage());
				if(connection == null)
					connection.rollback();
				sb.append(" Connection is null ...so rollingback ");
			}
			catch(Exception e1)
			{
				sb.append( "Error in Rollback : "+e1.toString());
			}
			result = false;
			sb.append(e.toString()) ;
			e.printStackTrace() ;
		}
		finally 
		{
			try
			{   
				if(preStatement != null)		preStatement.close() ;
				if(rset != null)				rset.close();
				if(stmt != null)				stmt.close();
				if(srs != null)					srs.close();
				if(stmt_add != null)			stmt_add.close();
				if(rs_add != null)		    	rs_add.close();
				if(count_stmt != null)		    count_stmt.close();
				if(count_rs != null)		    count_rs.close();
				if(cstmt != null)				cstmt.close();
				if(connection != null) ConnectionManager.returnConnection(connection,p);
			}
			catch(Exception ce){}
		}
		
		results.put("status", new Boolean(result));
		results.put("error", sb.toString());
		results.put("sl_ref_no", sl_ref_no);
		return results ;
	}

	public static String checkForNull(String inputString)
	{
		return(((inputString == null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
}
