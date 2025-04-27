/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
This ejb is used to prepare discharge advice for the patients.
@version - V3
*/

package eIP.IPPrepareDischargeAdvice;

import java.rmi.RemoteException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.ejb.CreateException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Hashtable;
import java.util.Properties;
import java.sql.* ;
//import blipin.BLDischargePatient;
import blipin.BLPrepareDischargeAdvice;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.MessageManager;

/**
*
* @ejb.bean
*	name="IPPrepareDischargeAdvice"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="IPPrepareDischargeAdvice"
*	local-jndi-name="IPPrepareDischargeAdvice"
*	impl-class-name="eIP.IPPrepareDischargeAdvice.IPPrepareDischargeAdviceManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eIP.IPPrepareDischargeAdvice.IPPrepareDischargeAdviceLocal"
*	remote-class="eIP.IPPrepareDischargeAdvice.IPPrepareDischargeAdviceRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eIP.IPPrepareDischargeAdvice.IPPrepareDischargeAdviceLocalHome"
*	remote-class="eIP.IPPrepareDischargeAdvice.IPPrepareDischargeAdviceHome"
*	generate= "local,remote"
*
*
*/

public class IPPrepareDischargeAdviceManager implements SessionBean
{
	//Connection connection			=	null;
	/*PreparedStatement preStatement	=	null;
	ResultSet resultSet				=	null;
	CallableStatement cstmt			= null;
	boolean result  				=	true;
	boolean bill_result  			=	true;
	String locale					=   "";
	String sql						=	"";
	String occupieddatetime			=	"";
	String disadvsrlno				=	"";
	String disadvstatus				=	"0";
	String phys_fees_bill_yn		=	"N";
	String eeg_charges_bill_yn		=	"N";
	String other_charges_bill_yn	=	"N";
	String ret_to_pharmacy_bill_yn	=	"N";
	String bill_error				=	"";
	int res1						= 0;
	int res4						= 0;
	int res5						= 0;*/
	int res6						= 0;
	SessionContext ctx;

	public void ejbCreate(){}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext (SessionContext context){ this.ctx=context;}

	/**
	This method is used to update the discharge advice.
	@version - V3
	@param1 - java.util.Properties
	@param2 - java.util.HashMap
	@return - java.util.HashMap
	*/
/**
* @ejb.interface-method
*	 view-type="both"
*/

	public java.util.HashMap updateDischargeAdvice(Properties p,java.util.HashMap paramHashTab) 
	{
		Connection connection				=	null;
		PreparedStatement preStatement		=	null;
		ResultSet resultSet					=	null;
		CallableStatement cstmt				= null;
		boolean result  					=	true;
		boolean bill_result  				=	true;
		String locale						=   "";
		String sql							=	"";
		String occupieddatetime				=	"";
		String disadvsrlno					=	"";
		String disadvstatus					=	"0";
		String phys_fees_bill_yn			=	"N";
		String eeg_charges_bill_yn			=	"N";
		String other_charges_bill_yn		=	"N";
		String ret_to_pharmacy_bill_yn		=	"N";
		String bill_error					=	"";
		int res1							= 0;
		int res4							= 0;
		int res5							= 0;
		java.util.HashMap results			= new java.util.HashMap() ;
		String facilityId					=	"";		
		String encounterId					=	"";
		String bedno						=	"";
		String nursingunitcode				=	"";
		String expecteddischargedate		=	"";
		String patientid					=	"";
		String dischargetypecode			=	"";
		String post_mortem_req_yn			=	"";
		String dischargesummaryyn			=	"";
		String takehomenewmedyn				=	"";
		String take_home_new_med_bill_yn	=	"";
		String takehomestkmedyn				=	"";
		String labchargesyn					=	"N";
		String lab_charges_bill_yn			=	"N";
		String xraychargesyn				=	"N";
		String xray_charges_bill_yn			=	"N";
		String scanchargesyn				=	"N";
		String scan_charges_bill_yn			=	"N";
		String ultrasoundchargesyn			=	"N";
		String ultrasound_charges_bill_yn	=	"N";
		String mrichargesyn					=	"N";
		String mri_charges_bill_yn			=	"N";
		String rtchargesyn					=	"N";
		String rt_charges_bill_yn			=	"N";
		String physiochargesyn				=	"N";
		String physio_charges_bill_yn		=	"N";
		String ecgchargesyn					=	"N";
		String ecg_charges_bill_yn			=	"N";
		String dietchargesyn				=	"N";
		String diet_charges_bill_yn			=	"N";
		String phchargesyn					=	"N";
		String ph_charges_bill_yn			=	"N";
		String setup_bl_dtls_in_ip_yn		=	"N";
		String modifiedAtWorkstation		=	"";
		String practid						=	"";
		String inform_to					=	"";
		String informed_date				=	"";
		String informed_name				=	"";
		String medico_legal					=	"";
		String police_rep_no				=	"";
		String police_station				=	"";
		String police_id					=	"";
		String discharge_remarks			=	"";
		String referred						=	"";
		String referral_type				=	"";
		String hcare_setting_type			=	"";
		String referred_to					=	"";
		String priority						=	"";
		String preferred_date				=	"";
		String speciality					=	"";
		String service						=	"";
		String location0					=	"";
		String location1					=	"";
		String location2					=	"";
		String pract_name					=	"";
		String practitioner1				=	"";
		String practitioner					=	"";
		String ref_for_ip					=	"";
		String patient_status				=	"";
		String absconded_date				=	"";
		String absconded_yn					=	"";
		String reported_to					=	"";
		String deathtime					=	"";
		String SickLeaveRecordFlag			=	""; 
		String LeaveFrom					=	 ""; 
		String LeaveTo						=	""; 
		String FitForDuty					=	 ""; 
		String FitonDuty					=	 ""; 
		String CertIssued					=	 ""; 
		String AuthorizedById				=	 "";
		String cert_Remarks					=	""; 
		String MC_No						=	"";
		String emp_details					=	"";
		String cert_type					=	"";
		String issued_date					=	"";
		String sl_ref_no					=	"";
		String dischargestatuscode			=   "";
		//String or_installed					=   "";
		//String order_catalog_code			=   "";
		String billing_interfaced			=   "";
		String billing_installed			=   "";
		String function_id					=   "";
		String patient_class_value			=   "";
		String episode_type					=   "";
		//String BillResult					= "PASS";
		StringBuffer sqlBuffer				=	new StringBuffer();
		StringBuffer messageBuffer			=	new StringBuffer("");
		/*Added by Dharma on Oct 29th against HSA-CRF-0181 [IN:049541] Start*/
		String weight_on_admission			= "";
		String weight_on_admission_unit		= "";
		/*Added by Dharma on Oct 29th against HSA-CRF-0181 [IN:049541] End*/
		
		/*Added by Kamatchi S for ML-MMOH-CRF-1527 on 23-JUN-2020*/
		String height_on_admission		= "";
		String bmi="";
		String discharge_to="";
		/*Added by Kamatchi S for ML-MMOH-CRF-1527 on 23-JUN-2020*/
		
		/*Added by Ashwini on 07-Mar-2018 for GHL-CRF-0505*/
		String aadhar_card				= "";
		String relationship				= "";
		String isAadharCardAndRelAppl	= "";
		String citizen_yn				= "";
		String alt_id4_type				= "";
		String discharge_indicator		= "";
		int rs1							= 0;
		/*End GHL-CRF-0505*/
/*Added for AAKH-CRF-0179 by Ajay Hatwate on 23-08-2023*/
		String death_reg_form_accession_num = "";
		String isDeathRegisterFormAppl = "";
		String enable_death_reg_form = "";
		
		try
		{
			locale = p.getProperty("LOCALE");
		try
		{
		facilityId					=	(String) paramHashTab.get("facilityId");                 
		encounterId					=	(String) paramHashTab.get("encounterId");                
		bedno						=	(String) paramHashTab.get("bedno");                      
		nursingunitcode				=	(String) paramHashTab.get("nursingunitcode");            
		expecteddischargedate		=	(String) paramHashTab.get("expecteddischargedate"); 
		
		patientid					=	(String) paramHashTab.get("patientid");                  
		dischargetypecode			=	(String) paramHashTab.get("dischargetypecode");
		deathtime					=	(String) paramHashTab.get("deathtime");
		post_mortem_req_yn			=	(String) paramHashTab.get("post_mortem_req_yn");  
		dischargesummaryyn			=	(String) paramHashTab.get("dischargesummaryyn");         
		takehomenewmedyn			=	(String) paramHashTab.get("takehomenewmedyn");           
		take_home_new_med_bill_yn	=	(String) paramHashTab.get("take_home_new_med_bill_yn");  
		takehomestkmedyn			=	(String) paramHashTab.get("takehomestkmedyn");           
		labchargesyn				=	(String) paramHashTab.get("labchargesyn");               
		lab_charges_bill_yn			=	(String) paramHashTab.get("lab_charges_bill_yn");        
		xraychargesyn				=	(String) paramHashTab.get("xraychargesyn");              
		xray_charges_bill_yn		=	(String) paramHashTab.get("xray_charges_bill_yn");       
		scanchargesyn				=	(String) paramHashTab.get("scanchargesyn");              
		scan_charges_bill_yn		=	(String) paramHashTab.get("scan_charges_bill_yn");       
		ultrasoundchargesyn			=	(String) paramHashTab.get("ultrasoundchargesyn");        
		ultrasound_charges_bill_yn	=	(String) paramHashTab.get("ultrasound_charges_bill_yn"); 
		mrichargesyn				=	(String) paramHashTab.get("mrichargesyn");               
		mri_charges_bill_yn			=	(String) paramHashTab.get("mri_charges_bill_yn");        
		rtchargesyn					=	(String) paramHashTab.get("rtchargesyn");                
		rt_charges_bill_yn			=	(String) paramHashTab.get("rt_charges_bill_yn");         
		physiochargesyn				=	(String) paramHashTab.get("physiochargesyn");            
		physio_charges_bill_yn		=	(String) paramHashTab.get("physio_charges_bill_yn");     
		ecgchargesyn				=	(String) paramHashTab.get("ecgchargesyn");               
		ecg_charges_bill_yn			=	(String) paramHashTab.get("ecg_charges_bill_yn");        
		dietchargesyn				=	(String) paramHashTab.get("dietchargesyn");              
		diet_charges_bill_yn		=	(String) paramHashTab.get("diet_charges_bill_yn");       
		phchargesyn					=	(String) paramHashTab.get("phchargesyn");                
		ph_charges_bill_yn			=	(String) paramHashTab.get("ph_charges_bill_yn");         
		setup_bl_dtls_in_ip_yn		=	(String) paramHashTab.get("setup_bl_dtls_in_ip_yn");     
		modifiedAtWorkstation		=	(String) paramHashTab.get("client_ip_address");          
		practid						=	(String) paramHashTab.get("practid");                    
		inform_to					=	(String) paramHashTab.get("inform_to");                  
		informed_date				=	(String) paramHashTab.get("informed_date");              
		informed_name				=	(String) paramHashTab.get("informed_name");              
		medico_legal				=	(String) paramHashTab.get("medico_legal");               
		police_rep_no				=	(String) paramHashTab.get("police_rep_no");              
		police_station				=	(String) paramHashTab.get("police_station");             
		police_id					=	(String) paramHashTab.get("police_id");                  
		discharge_remarks			=	(String) paramHashTab.get("discharge_remarks");          
		referred					=	(String) paramHashTab.get("referred");                   
		referral_type				=	(String) paramHashTab.get("referral_type");              
		hcare_setting_type			=	(String) paramHashTab.get("hcare_setting_type");         
		referred_to					=	(String) paramHashTab.get("referred_to");                
		priority					=	(String) paramHashTab.get("priority");                   
		preferred_date				=	(String) paramHashTab.get("preferred_date");             
		speciality					=	(String) paramHashTab.get("speciality");                 
		service						=	(String) paramHashTab.get("service");                    
		location0					=	(String) paramHashTab.get("location0");                  
		location1					=	(String) paramHashTab.get("location1");                  
		location2					=	(String) paramHashTab.get("location2");                  
		pract_name					=	(String) paramHashTab.get("pract_name");                 
		practitioner1				=	(String) paramHashTab.get("practitioner1");              
		practitioner				=	(String) paramHashTab.get("practitioner");               
		ref_for_ip					=	(String) paramHashTab.get("ref_for_ip");                 
		absconded_date				=	(String) paramHashTab.get("absconded_date"); 
		absconded_yn				=	(String) paramHashTab.get("absconded_yn"); 
		reported_to					=	(String) paramHashTab.get("reported_to"); 
		patient_status				=	(String) paramHashTab.get("patient_status");
		SickLeaveRecordFlag			=	(String) paramHashTab.get("SickLeaveRecordFlag");
		LeaveFrom					=	(String) paramHashTab.get("LeaveFrom");
		LeaveTo						=	(String) paramHashTab.get("LeaveTo");
		FitForDuty					=	(String) paramHashTab.get("FitForDuty");
		FitonDuty					=	(String) paramHashTab.get("resume_date");
		CertIssued					=	(String) paramHashTab.get("CertIssued");
		AuthorizedById				=	(String) paramHashTab.get("AuthorizedById");
		cert_Remarks				=	(String) paramHashTab.get("cert_Remarks");
		MC_No						=	(String) paramHashTab.get("MC_No");
		emp_details					=	(String) paramHashTab.get("emp_details");
		cert_type					=	(String) paramHashTab.get("cert_type");
		issued_date					=	(String) paramHashTab.get("issued_date");
		//modified on 3-07-2008 SCR 3228
		dischargestatuscode			=	(String) paramHashTab.get("dischargestatuscode");
		billing_interfaced			=	(String) paramHashTab.get("billing_interfaced");
		billing_installed			=	(String) paramHashTab.get("billing_installed");
		function_id					=	(String) paramHashTab.get("function_id");
		if(function_id.equals(""))  function_id = "PRE_DIS_ADVICE";
		
		patient_class_value			=	(String) paramHashTab.get("patient_class_value");  
		
		/*Added by Dharma on Oct 29th against HSA-CRF-0181 [IN:049541] Start*/
		weight_on_admission			= (String) paramHashTab.get("weight_on_admission");
		weight_on_admission_unit	= (String) paramHashTab.get("weight_on_admission_unit");
		/*Added by Dharma on Oct 29th against HSA-CRF-0181 [IN:049541] End*/

		/* Added by kamatchi s for ML-MMOH-CRF-1527 ON 23-JUN-2020*/
		height_on_admission		= (String) paramHashTab.get("height_on_admission");
		bmi = (String) paramHashTab.get("bmi");
		discharge_to = (String) paramHashTab.get("discharge_to");
		/*Added by Ashwini on 07-Mar-2018 for GHL-CRF-0505*/
		aadhar_card				= (String) paramHashTab.get("aadhar_card");
		relationship			= (String) paramHashTab.get("relationship");
		isAadharCardAndRelAppl	= (String) paramHashTab.get("isAadharCardAndRelAppl");
		citizen_yn				= (String) paramHashTab.get("citizen_yn");
		alt_id4_type			= (String) paramHashTab.get("alt_id4_type");
		discharge_indicator		= (String) paramHashTab.get("discharge_indicator");
		/*End GHL-CRF-0505*/
		
/*Added for AAKH-CRF-0179 by Ajay Hatwate on 23-08-2023 */
		isDeathRegisterFormAppl = (String) paramHashTab.get("isDeathRegisterFormAppl");
		enable_death_reg_form = (String) paramHashTab.get("enable_death_reg_form");
		if(isDeathRegisterFormAppl.equals("true")){
				death_reg_form_accession_num = (String) paramHashTab.get("death_reg_form_accession_num");
		}
		/*End of AAKH-CRF-0179*/
		paramHashTab.clear();
		connection		=	 ConnectionManager.getConnection(p);
		connection.setAutoCommit(false);

		result  					= true;
		String addedById 			= p.getProperty( "login_user" ) ;
		if(result)
		{
			sqlBuffer.append(" SELECT '1' from ip_discharge_advice WHERE facility_id = ? AND encounter_id  = ? AND dis_adv_status in ( '0','1' ) ");

			preStatement	= connection.prepareStatement(sqlBuffer.toString());
			preStatement.setString(1, facilityId);
			preStatement.setString(2, encounterId);
			resultSet		=  preStatement.executeQuery();
			if (resultSet.next())
			{
				result = false;
				java.util.Hashtable message = MessageManager.getMessage(locale,"DIS_ADVICE_ALREAD_EXISIT","IP");
				messageBuffer.append( (String) message.get("message") ) ;
				message.clear();
			}
			if (resultSet != null)  resultSet.close();
			if (preStatement != null)  preStatement.close();
		}
		
		String location				= "";
		String to_practitioner_desc = "";
		String to_facility			= "";

		if (!referral_type.equals("X"))
		{
			to_practitioner_desc = pract_name; 
			location			 = ""; 
			to_facility			 = referred_to;
		}
		else
		{
			to_practitioner_desc = practitioner1; 
			location			 = location2; 
			to_facility			 = "";
		}

		//Generating Discharge advice serial number
		if(result)
		{
			if(sqlBuffer.length() > 0)  sqlBuffer.delete(0,sqlBuffer.length());
			sqlBuffer.append("SELECT nvl(max(dis_adv_srl_no),0)+1  dis_adv_srl_no  from ip_discharge_advice WHERE facility_id = ? AND encounter_id  = ?");

			preStatement = connection.prepareStatement(sqlBuffer.toString());
			preStatement.setString(1, facilityId);
			preStatement.setString(2, encounterId);
			resultSet = preStatement.executeQuery();

			if(resultSet.next())
			disadvsrlno = resultSet.getString(1);
			else
			disadvsrlno = "1";

			if (resultSet != null)  resultSet.close();
			if (preStatement != null)  preStatement.close();
		}
		

		if(result)
		{
			if (sqlBuffer.length() > 0)
			sqlBuffer.delete(0, sqlBuffer.length());

			sqlBuffer.append(" insert into IP_DISCHARGE_ADVICE ( facility_id, encounter_id, dis_adv_srl_no");
			sqlBuffer.append(", patient_id, expected_discharge_date, discharge_type_code, deceased_date_time, ");
			sqlBuffer.append("post_mortem_req_yn, discharge_summary_yn, take_home_new_med_yn, ");
			sqlBuffer.append("take_home_stk_med_yn, lab_charges_yn, xray_charges_yn, scan_charges_yn, ");
			sqlBuffer.append("ultrasound_charges_yn, mri_charges_yn, rt_charges_yn, physio_charges_yn");
			sqlBuffer.append(", ecg_charges_yn, diet_charges_yn, ph_charges_yn, lab_charges_bill_yn");
			sqlBuffer.append(", xray_charges_bill_yn, scan_charges_bill_yn, ultrasound_charges_bill_yn");
			sqlBuffer.append(", mri_charges_bill_yn, rt_charges_bill_yn, physio_charges_bill_yn, ");
			sqlBuffer.append("ecg_charges_bill_yn, diet_charges_bill_yn, ph_charges_bill_yn, ");
			sqlBuffer.append("phys_fees_bill_yn, eeg_charges_bill_yn, other_charges_bill_yn, ");
			sqlBuffer.append("ret_to_pharmacy_bill_yn, take_home_new_med_bill_yn, dis_adv_status, ");
			sqlBuffer.append("added_by_id, added_date, added_at_ws_no, added_facility_id, ");
			sqlBuffer.append("modified_by_id, modified_date, modified_at_ws_no, modified_facility_id, ");
			sqlBuffer.append("dis_adv_date_time, auth_practitioner_id, informed_to, informed_date_time");
			sqlBuffer.append(", informed_name, med_lgl_case_yn, pol_rep_no, pol_stn_id, pol_id, ");
			sqlBuffer.append("discharge_narration, referred_yn, to_ref_type, to_hcare_setting_type, ");
			sqlBuffer.append("to_ref_code, referral_priority, preferred_treatment_date,  ");
			sqlBuffer.append("to_specialty_code, to_service_code, to_locn_code, to_locn_type, ");
			sqlBuffer.append("to_pract_id, referral_date, to_locn_desc, to_facility_id, ");
			sqlBuffer.append("to_pract_name,referred_for_ip,ABSCONDED_DATE, ABSCONDED_YN,REPORTED_TO,ref_notes"); 
			// modified on 3-07-2008 SCR 3228
			sqlBuffer.append(", discharge_status_code, relationship_code )");
		
			sqlBuffer.append(" VALUES (?, ?, ?, ?,  ");
			sqlBuffer.append("to_date(?,'dd/mm/rrrr hh24:mi'), ?, to_date(?,'dd/mm/rrrr hh24:mi'),?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ");
			
			sqlBuffer.append("?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?,?,?,?, ?, ?, sysdate, ?, ?, ?, ");
			sqlBuffer.append("sysdate, ?, ? , sysdate,?, ?, to_date(?,'dd/mm/rrrr hh24:mi'), ?, ");
			sqlBuffer.append("?, ?, ?, ?, ?, ?, ?, ?, ?, ?, to_date(?,'dd/mm/rrrr hh24:mi'), ?, ");
			sqlBuffer.append("?, ?, ?, ?,sysdate,?, ?, ?, ?, to_date(?,'dd/mm/rrrr hh24:mi'),?,?,empty_clob(),?,? ) ");
			
			try
			{

				preStatement = connection.prepareStatement( sqlBuffer.toString() );
				preStatement.setString	(1, facilityId					);
				preStatement.setString	(2, encounterId					);
				preStatement.setString	(3, disadvsrlno					);
				preStatement.setString	(4, patientid					);
				preStatement.setString	(5, expecteddischargedate		);
				preStatement.setString	(6, dischargetypecode			);
				preStatement.setString	(7, deathtime					);

				preStatement.setString	(8, post_mortem_req_yn			);
				preStatement.setString	(9, dischargesummaryyn			);
				preStatement.setString	(10, takehomenewmedyn			);
				preStatement.setString	(11,takehomestkmedyn			);
				preStatement.setString	(12,labchargesyn				);
				preStatement.setString	(13,xraychargesyn				);
				preStatement.setString	(14,scanchargesyn				);
				preStatement.setString	(15,ultrasoundchargesyn			);
				preStatement.setString	(16,mrichargesyn				);
				preStatement.setString	(17,rtchargesyn					);
				preStatement.setString	(18,physiochargesyn				);
				preStatement.setString	(19,ecgchargesyn				);
				preStatement.setString	(20,dietchargesyn				);
				preStatement.setString	(21,phchargesyn					);
				preStatement.setString	(22,lab_charges_bill_yn			);
				preStatement.setString	(23,xray_charges_bill_yn		);
				preStatement.setString	(24,scan_charges_bill_yn		);
				preStatement.setString	(25,ultrasound_charges_bill_yn	);
				preStatement.setString	(26,mri_charges_bill_yn			);
				preStatement.setString	(27,rt_charges_bill_yn			);
				preStatement.setString	(28,physio_charges_bill_yn		);
				preStatement.setString	(29,ecg_charges_bill_yn			);
				preStatement.setString	(30,diet_charges_bill_yn		);
				preStatement.setString	(31,ph_charges_bill_yn			);
				preStatement.setString	(32,phys_fees_bill_yn			);
				preStatement.setString	(33,eeg_charges_bill_yn			);
				preStatement.setString	(34,other_charges_bill_yn		);
				preStatement.setString	(35,ret_to_pharmacy_bill_yn		);
				preStatement.setString	(36,take_home_new_med_bill_yn	);
				preStatement.setString	(37,disadvstatus				);
				preStatement.setString	(38,addedById					);
				preStatement.setString	(39,modifiedAtWorkstation		) ;
				preStatement.setString	(40,facilityId					) ;
				preStatement.setString	(41,addedById					);
				preStatement.setString	(42,modifiedAtWorkstation		) ;
				preStatement.setString	(43,facilityId					) ;
				preStatement.setString	(44,practid						) ;

				preStatement.setString	(45,inform_to					) ;
				preStatement.setString	(46,informed_date				) ;
				preStatement.setString	(47,informed_name				) ;
				preStatement.setString	(48,medico_legal				) ;
				preStatement.setString	(49,police_rep_no				) ;
				preStatement.setString	(50,police_station				) ;
				preStatement.setString	(51,police_id					) ;
				preStatement.setString	(52,discharge_remarks			) ;
				preStatement.setString	(53,referred					) ;
				preStatement.setString	(54,referral_type				) ;
				preStatement.setString	(55,hcare_setting_type			) ;
				preStatement.setString	(56,referred_to					) ;
				preStatement.setString	(57,priority					) ;
				preStatement.setString	(58,preferred_date				) ;
				preStatement.setString	(59,speciality					) ;
				preStatement.setString	(60,service						) ;
				preStatement.setString	(61,location1					) ;
				preStatement.setString	(62,location0					) ;
				preStatement.setString	(63,practitioner				) ;
				preStatement.setString	(64,location					) ;
				preStatement.setString	(65,to_facility					) ;
				preStatement.setString	(66,to_practitioner_desc		) ;
				preStatement.setString	(67,ref_for_ip					) ;
				preStatement.setString	(68,absconded_date				) ;
				preStatement.setString	(69,absconded_yn				) ;
				preStatement.setString	(70,reported_to					) ;
				//modified on 3-07-2008 SCR 3228
				preStatement.setString	(71,dischargestatuscode			) ;

				/*Added by Ashwini on 07-Mar-2018 for GHL-CRF-0505*/
				preStatement.setString	(72,relationship				) ;
				/*End GHL-CRF-0505*/

				res1 = preStatement.executeUpdate() ;

				if (preStatement != null)  preStatement.close();

				if(res1>0) 
					result = true; 
				else 
				{
					result = false;
					messageBuffer.append("Exception while inserting into IP_DISCHARGE_ADVICE_TABLE");
				}
			}catch(Exception e)
			{
				result = false;
				messageBuffer.append("Exception while inserting into IP_DISCHARGE_ADVICE_TABLE : " + e.toString());
				e.printStackTrace();
			}

			 /*Added by Ashwini on 07-Mar-2018 for GHL-CRF-0505*/
			 if(isAadharCardAndRelAppl.equals("true") && citizen_yn.equals("Y") && discharge_indicator.equals("DS") && (!("").equals(alt_id4_type)))
			 {
					if(result)
					{
						 try{
							   if (sqlBuffer.length() > 0)
							   sqlBuffer.delete(0, sqlBuffer.length());
							   sqlBuffer.append("update MP_PATIENT set  ");
							   sqlBuffer.append("alt_id4_no = ? ,");
							   sqlBuffer.append("MODIFIED_BY_ID = ? ,");
							   sqlBuffer.append("MODIFIED_DATE  = sysdate ,");
							   sqlBuffer.append("MODIFIED_AT_WS_NO	= ? ,");
							   sqlBuffer.append("MODIFIED_FACILITY_ID = ? ");
							   sqlBuffer.append(" WHERE PATIENT_ID = ? ");
							   preStatement = connection.prepareStatement(sqlBuffer.toString());
							   preStatement.setString(1, aadhar_card) ;
							   preStatement.setString(2, addedById) ;
							   preStatement.setString(3, modifiedAtWorkstation) ;
							   preStatement.setString(4, facilityId) ;
							   preStatement.setString(5, patientid) ;
				
							   rs1 =  preStatement.executeUpdate();

							   if(rs1 > 0)
									result	= true;
							   else
									result	= false;
							   if(preStatement!=null) preStatement.close(); preStatement=null;
							   if((sqlBuffer != null) && (sqlBuffer.length() > 0))
								  {
									sqlBuffer.delete(0,sqlBuffer.length());
								  }
						}catch(Exception e){e.printStackTrace();  result	= false;
								  messageBuffer.append("Exception while updating MP_PATIENT :"+e);
								  }
					}
			 }
			 /*End GHL-CRF-0505*/
					
			if(result)
			{
				try
				{
					if (sqlBuffer.length() > 0)
					sqlBuffer.delete(0, sqlBuffer.length());
					sqlBuffer.append("SELECT occupied_until_date_time from IP_NURSING_UNIT_BED ");
					sqlBuffer.append("WHERE facility_id = '");
					sqlBuffer.append(facilityId);
					sqlBuffer.append("' AND nursing_unit_code  = '");
					sqlBuffer.append(nursingunitcode);
					sqlBuffer.append("' AND bed_no = '");
					sqlBuffer.append(bedno);
					sqlBuffer.append("' ");

					preStatement = connection.prepareStatement(sqlBuffer.toString());
					resultSet=preStatement.executeQuery();
					if(resultSet.next())
						occupieddatetime = resultSet.getString(1);
					if (resultSet != null)  resultSet.close();
					if (preStatement != null)  preStatement.close();
				}
				catch(Exception e)
				{
					result = false;
					messageBuffer.append("Exception while fetching record from ip_nursing_unit_bed_table :"+e.toString());
					e.printStackTrace();
				}
			}

			if(expecteddischargedate != occupieddatetime)
			{
				if(result)
				{
					if (sqlBuffer.length() > 0)
					sqlBuffer.delete(0, sqlBuffer.length());
					try
					{
						sqlBuffer.append("update IP_NURSING_UNIT_BED set occupied_until_date_time =to_date('");
						sqlBuffer.append(expecteddischargedate);
						sqlBuffer.append("','dd/mm/rrrr hh24:mi'), modified_by_id = ?, modified_date = sysdate, ");
						sqlBuffer.append("modified_facility_id = ?, modified_at_ws_no = ? WHERE  facility_id = ? ");
						sqlBuffer.append("AND nursing_unit_code = ? AND bed_no = ?");

						preStatement = connection.prepareStatement( sqlBuffer.toString());
						preStatement.setString	( 1, addedById ) ;
						preStatement.setString	( 2, facilityId ) ;
						preStatement.setString	( 3, modifiedAtWorkstation ) ;
						preStatement.setString	( 4, facilityId ) ;
						preStatement.setString	( 5, nursingunitcode ) ;
						preStatement.setString	( 6, bedno ) ;
						res4 = preStatement.executeUpdate() ;

						if(res4>0) 
							result = true; 
						else
						{
							result = false;
							messageBuffer.append("Exception while updating IP_NURSING_UNIT_BED_TABLE");
						}
						if (preStatement != null)  preStatement.close();
					}
					catch(Exception e)
					{
						result = false;
						messageBuffer.append("Exception while updating ip_nursing_unit_bed_table : " + 	e.toString());
						e.printStackTrace();
					}


					if(result)
					{
						if (sqlBuffer.length() > 0)
						sqlBuffer.delete(0, sqlBuffer.length());

						sqlBuffer.append(" update PR_ENCOUNTER_OTHER_DETAIL set exp_discharge_date_timE = to_date('");
						sqlBuffer.append(expecteddischargedate);
						sqlBuffer.append("','dd/mm/rrrr hh24:mi'), modified_by_id = ?, modified_date = sysdate, ");
						sqlBuffer.append("modified_facility_id = ?, modified_at_ws_no = ? WHERE ");
						sqlBuffer.append("operating_facility_id	= ? AND encounter_id = ? ");


						
						try
						{
							if (preStatement != null)  preStatement = null;
							preStatement = connection.prepareStatement(sqlBuffer.toString());
							preStatement.setString	( 1, addedById ) ;
							preStatement.setString	( 2, facilityId ) ;
							preStatement.setString	( 3, modifiedAtWorkstation ) ;
							preStatement.setString	( 4, facilityId ) ;
							preStatement.setString	( 5, encounterId ) ;
							res5 = preStatement.executeUpdate();

							if(res5>0) 
								result = true; 
							else 
							{	
								result = false;
								messageBuffer.append("Exception while updating PR_ENCOUNTER_OTHER_DETAIL_TABLE");
							}
						}
						catch(Exception e)
						{
							result = false;
							messageBuffer.append("Exception while updating pr_encounter_other_detail_table : " +e.toString());
							e.printStackTrace();
						}
						if (preStatement != null)  preStatement.close();
					}
					/// UPDATES pr_encounter_table with OTH_ADT_STATUS = '7' for Normal Prepare Discharge Advice
					if(result)
					{
						if (sqlBuffer.length() > 0)
						sqlBuffer.delete(0, sqlBuffer.length());

						if(absconded_yn.equals("Y"))
							patient_status = "4";
						else
							patient_status = "";

						sqlBuffer.append(" update PR_ENCOUNTER set ");
						sqlBuffer.append(" oth_adt_status = '7', ");
						sqlBuffer.append(" ip_leave_status = '"+patient_status+"', ");
						sqlBuffer.append(" modified_by_id = ?, modified_date = sysdate, ");
						sqlBuffer.append(" modified_facility_id = ?, modified_at_ws_no = ?, ");
						sqlBuffer.append(" exp_discharge_date_time = to_date('"+expecteddischargedate+"','dd/mm/rrrr hh24:mi') ");
						/*Thursday, January 13, 2011 ,SRR20056-SCF-6415 [IN:025852],point 11*/
						if(medico_legal.equals("Y"))
						{
							sqlBuffer.append(", mlc_yn = '"+medico_legal+"', marked_date=sysdate , marked_by_id='"+addedById+"' ");
						}				
						else
						{
							sqlBuffer.append(", mlc_yn = '"+medico_legal+"', marked_date='' , marked_by_id='' ");
						}
						
						/*Added by Dharma on Oct 29th against HSA-CRF-0181 [IN:049541] Start*/
						sqlBuffer.append(" , weight_on_admission = '"+weight_on_admission+"' ");
						sqlBuffer.append(" , weight_on_admission_unit = '"+weight_on_admission_unit+"' ");
						/*Added by Dharma on Oct 29th against HSA-CRF-0181 [IN:049541] End*/
						
						/* Added by kamatchi S on 23-jun-2020 for ML-MMOH-CRF-1527*/
						sqlBuffer.append(" , height_on_admission = '"+height_on_admission+"' ");
						sqlBuffer.append(" , bmi = '"+bmi+"' ");
						sqlBuffer.append(" , discharge_to = '"+discharge_to+"' ");
						/* Added by kamatchi S on 23-jun-2020 for ML-MMOH-CRF-1527*/
						//Added for AAKH-CRF-0179 by Ajay Hatwate on 23-08-2023
						if(isDeathRegisterFormAppl.equals("true") && enable_death_reg_form.equals("Y")){
							sqlBuffer.append(", death_reg_form_accession_num = ? ");
						}
						sqlBuffer.append(" WHERE ");
						sqlBuffer.append(" facility_id = ? AND encounter_id = ? ");
						try
						{
							preStatement = connection.prepareStatement(sqlBuffer.toString());
							preStatement.setString	( 1, addedById ) ;
							preStatement.setString	( 2, facilityId ) ;
							preStatement.setString	( 3, modifiedAtWorkstation ) ;
							//Added for AAKH-CRF-0179 by Ajay Hatwate on 23-08-2023
							if(isDeathRegisterFormAppl.equals("true") && enable_death_reg_form.equals("Y")){
								preStatement.setString	( 4, death_reg_form_accession_num ) ;
								preStatement.setString	( 5, facilityId ) ;
								preStatement.setString	( 6, encounterId ) ;
							}else{
							preStatement.setString	( 4, facilityId ) ;
							preStatement.setString	( 5, encounterId ) ;
							}
							res6 = preStatement.executeUpdate();

							if(res6 > 0) 
								result = true; 
							else 
							{	
								result = false;
								messageBuffer.append("Exception while updating pr_encounter_table");
							}
							if (preStatement != null)  preStatement.close();
						}
						catch(Exception e)
						{
							result = false;
							messageBuffer.append("Exception while updating pr_encounter_table : " + e.toString());
							e.printStackTrace();
						}

					}
				}
			}

			if(result)
			{
				if(SickLeaveRecordFlag.equals("Y"))
				{
					try
					{
						preStatement= connection.prepareStatement("select PR_SICK_LEAVE_REGISTER_SEQ.NEXTVAL from dual");
						resultSet = preStatement.executeQuery();
						if ((resultSet!=null)&&(resultSet.next()))	sl_ref_no = resultSet.getString(1);
						if (resultSet != null)  resultSet.close();
						if (preStatement != null)  preStatement.close();
						StringBuffer Leave_sql = new StringBuffer();
						Leave_sql.append(" insert into pr_sick_leave_register (sl_ref_no, patient_id, facility_id, encounter_id, leave_from, leave_to, fit_for_duty, cert_issued, authorized_by_id, remarks, added_by_id, added_date, added_at_ws_no, added_facility_id,fit_on_duty,cert_issued_date,cert_type,mc_no,employment_details,MODIFIED_AT_WS_NO,MODIFIED_BY_ID,modified_date,MODIFIED_FACILITY_ID) values(?,?,?,?,to_date(?,'dd/mm/rrrr hh24:mi'),to_date(?,'dd/mm/rrrr hh24:mi'),?,?,?,?,?,sysdate,?,?,to_date(?,'dd/mm/rrrr'),to_date(?,'dd/mm/rrrr'),?,?,?,?,?,sysdate,?) ");

						preStatement= connection.prepareStatement( Leave_sql.toString() );
						preStatement.setString    ( 1, sl_ref_no ) ;
						preStatement.setString    ( 2, patientid ) ;
						preStatement.setString    ( 3, facilityId ) ;
						preStatement.setString    ( 4, encounterId ) ;
						preStatement.setString    ( 5, LeaveFrom ) ;
						preStatement.setString    ( 6, LeaveTo ) ;
						preStatement.setString    ( 7, FitForDuty ) ;
						preStatement.setString    ( 8, CertIssued ) ;
						preStatement.setString    ( 9, AuthorizedById ) ;
						preStatement.setString    ( 10, cert_Remarks ) ;
						preStatement.setString    ( 11, addedById ) ;
						preStatement.setString    ( 12, modifiedAtWorkstation ) ;
						preStatement.setString    ( 13, facilityId ) ;
						preStatement.setString    ( 14, FitonDuty ) ;
						preStatement.setString    ( 15, issued_date ) ;
						preStatement.setString    ( 16, cert_type ) ;
						preStatement.setString    ( 17, MC_No ) ;
						preStatement.setString    ( 18, emp_details ) ;
						preStatement.setString    ( 19, modifiedAtWorkstation ) ;
						preStatement.setString    ( 20, addedById ) ;
						preStatement.setString    ( 21, facilityId ) ;
						res5 = preStatement.executeUpdate() ;
						if (preStatement != null)  preStatement.close();
						if(res5 != 0)
							result=true;
						else
						{
							result=false;
							messageBuffer.append("Error in inserting into pr_sick_leave_register_table");
						}
					}catch(Exception exception)
					{
						result=false;
						messageBuffer.append( exception.toString() +" Error in pr_sick_leave_register_table ");
						exception.printStackTrace();
					}
				}
			}
		}
		
		if(result && billing_installed.equals("Y") && billing_interfaced.equals("Y"))
		{
			try
			{
				   
					if(patient_class_value.equals("IP"))
	 					episode_type = "I";
					else if(patient_class_value.equals("DC"))
						episode_type = "D";
					
					String  episode_id	=	encounterId;
					Hashtable hashtableBill = new Hashtable();
					hashtableBill.put("facility_id",facilityId);
					hashtableBill.put("patient_id",patientid);					
					hashtableBill.put("episode_id",episode_id);
					hashtableBill.put("encounter_id",encounterId);
					hashtableBill.put("function_id",function_id);
					hashtableBill.put("locale",locale);
					hashtableBill.put("billing_installed",billing_installed);
					hashtableBill.put("billing_interfaced",billing_interfaced);
					hashtableBill.put("episode_type",episode_type);					  
					     

					BLPrepareDischargeAdvice blPrepareDischargeAdvice = new BLPrepareDischargeAdvice();
					Hashtable resultsBL = blPrepareDischargeAdvice.billPatientService(p,connection,hashtableBill);
					bill_result = ((Boolean) resultsBL.get("status")).booleanValue();
					if(!bill_result){
						bill_error = (String) (resultsBL.get("error"));				
						result  = false;
						messageBuffer.append(bill_error);
					}
					else
						result  = true;

					resultsBL.clear();
					hashtableBill.clear();		
				
			}
			catch(Exception exceptionBL)
			{
					result  = false;
					messageBuffer.append(" eBL Error : "+exceptionBL);
					exceptionBL.printStackTrace();
			}
		}
		
	
		/*1/29/2009 7688	PMG20089-CRF-0485 order catalog in discharge advice*/
			/*
			if(result)
			{
				try
				{
					if (sqlBuffer.length() > 0)
					sqlBuffer.delete(0, sqlBuffer.length());
					sqlBuffer.append( "select count(*) from sm_module where module_id='OR' and install_yn='Y'");
					preStatement = connection.prepareStatement(sqlBuffer.toString());
					resultSet=preStatement.executeQuery();
					if(resultSet.next())
						or_installed = resultSet.getString(1);	
					if (resultSet != null)  resultSet.close();
					if (preStatement != null)  preStatement.close();
				}
				catch (Exception e)
				{
					result = false;
					messageBuffer.append("Exception in sm_module"+e.toString());
				}
				
				try
				{
					if (sqlBuffer.length() > 0)
					sqlBuffer.delete(0, sqlBuffer.length());
					sqlBuffer.append( "select order_catalog_code from ip_discharge_type where discharge_type_code='"+dischargetypecode+"'");
					preStatement = connection.prepareStatement(sqlBuffer.toString());
					resultSet=preStatement.executeQuery();
					if(resultSet.next())
						order_catalog_code = resultSet.getString(1);
						if(order_catalog_code == null) order_catalog_code = "";
					if (resultSet != null)  resultSet.close();
					if (preStatement != null)  preStatement.close();
				}
				catch (Exception e)
				{
					result = false;
					messageBuffer.append("Exception in sm_module"+e.toString());
				}
			}

			if(!or_installed.equals("0") && !order_catalog_code.equals(""))
			{
				if(result)
				{
					
					try
					{
						cstmt = connection.prepareCall("{call OR_INS_DIS_ADV_ORDER (sysdate,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
						
						cstmt.setString(1,  order_catalog_code );
						cstmt.setString(2,  "IP");
						cstmt.setString(3,  facilityId );
						cstmt.setString(4,  patientid );
						cstmt.setString(5,  "IP");
						cstmt.setString(6,  encounterId );
						cstmt.setString(7,  encounterId );
						cstmt.setString(8,  "");
						cstmt.setString(9,  "N");
						cstmt.setString(10, nursingunitcode );
						cstmt.setString(11, practitioner );
						cstmt.setString(12, addedById );
						cstmt.setString(13, modifiedAtWorkstation );
						cstmt.setString(14, disadvsrlno );
						cstmt.registerOutParameter(15,java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(16,java.sql.Types.VARCHAR);
						cstmt.execute();
						String cs_success = cstmt.getString(15);
						String cs_error   = cstmt.getString(16);
						
						if(cs_success == null) cs_success = "";
						if(cs_error == null)   cs_error = "";

						if(!cs_success.equals(""))
						{
							messageBuffer.append(""+cs_success);
							result = true;
						}
						if(!cs_error.equals(""))
						{
							messageBuffer.append(""+cs_error);
							result = true;
						}
					}
					catch (Exception exp)
					{
						result = false;
						messageBuffer.append("Procedure-OR_INS_DIS_ADV_ORDER:"+exp.toString());
						exp.printStackTrace(System.out);
					}
				}
			}
			*/
			/**/
			
		if(result)
		{
			connection.commit();
			result = true;
			java.util.Hashtable message = MessageManager.getMessage(locale, "RECORD_MODIFIED","SM");
			messageBuffer.append( (String) message.get("message"));
			message.clear();
		}
		else
		{
			result =	false;
			connection.rollback();
			//messageBuffer.append(" Error in EJB... Connection rolledBack ");
		}

	}
	catch(Exception e)
	{
		messageBuffer.append(e  +" <br>1: "+sql);
		result = false;
		connection.rollback() ;
		e.printStackTrace();
	}
	}
	catch(Exception e)
	{
		messageBuffer.append(e  +" <br>1: "+sql);
		result = false;
		e.printStackTrace();
	}
	finally
	{
		try
		{
			if(resultSet!=null) resultSet.close();
			if(preStatement!=null) preStatement.close();
			if(cstmt != null)  cstmt.close();
			}catch(Exception e) {e.printStackTrace();}
			if(connection != null)      ConnectionManager.returnConnection(connection,p);
		}
		
		results.put( "status", new Boolean(result) ) ;
		results.put( "error", messageBuffer.toString() ) ;
		return results ;
	}
} // end session bean
