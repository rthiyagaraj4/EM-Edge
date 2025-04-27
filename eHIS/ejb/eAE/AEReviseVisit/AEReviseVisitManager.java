/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eAE.AEReviseVisit;

import java.rmi.*;
import java.util.*;
import java.sql.*;
import java.io.*;
import javax.ejb.*;
import javax.naming.*;   

 
import webbeans.eCommon.*;

/**
*
* @ejb.bean
*	name="AEReviseVisit"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="AEReviseVisit"
*	local-jndi-name="AEReviseVisit"
*	impl-class-name="eAE.AEReviseVisit.AEReviseVisitManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eAE.AEReviseVisit.AEReviseVisitLocal"
*	remote-class="eAE.AEReviseVisit.AEReviseVisitRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eAE.AEReviseVisit.AEReviseVisitLocalHome"
*	remote-class="eAE.AEReviseVisit.AEReviseVisitHome"
*	generate= "local,remote"
*
*
*/

public class AEReviseVisitManager implements SessionBean { 
	Connection con; 
	PreparedStatement pstmt;
	PreparedStatement pstmt2;
	java.util.HashMap results = new java.util.HashMap() ;
	StringBuffer sb  		 = new StringBuffer();
	StringBuffer sbMessage 	= new StringBuffer("");
	boolean result 			= false;
	int rs1 = 0;
	SessionContext ctx;
	public final String RECORD_MODIFIED = "RECORD_MODIFIED";

	String contact1_email_id = "";
	String contact1_mob_tel_no = "";
	String contact1_new_nat_id_no = "";

	String occ_class = "";
	String occu_of_per_desc = ""; 

	String next_contact_relation = "";
 	String contact2_nat_id_no = "";
	String contact2_mob_tel_no = "";
	String contact2_email_id = "";
	String contact1_birth_date = "";

	String next_contact_name = "";
	String next_job_title = "";
	String next_addr_line1 = "";
	String next_addr_line2 = "";
	String next_addr_line3 = "";
	String next_addr_line4 = "";
	String next_postal_code = "";
	String next_country = "";
	String next_res_tel_no = "";
	String first_off_tel_no = "";
	String organization_name = "";

	String first_addr_line1 = "";
	String first_addr_line2 = "";
	String first_addr_line3 = "";
	String first_addr_line4 = "";
	String first_postal_code = "";
	String first_country_code = "";
	String first_job_title = "";
	String first_res_tel_no = "";
	String next_off_tel_no = "";

	String notify_name = "";
	String employ_addr_line1 = "";
	String employ_addr_line2 = "";
 	String employ_addr_line3 = "";
	String employ_addr_line4 = "";
	String employ_postal_code = "";
	String empyr_country_code = "";
	String empl_occupation = "";
	String empyr_eid = "";
	String empl_status = "";
	String empyr_contact_name = "";
	String empyr_off_tel_no = "";

	String addedAtWorkstation = "";
	String relationship = "";
	String res3_tel_no = "";

	String f_town = "";
	String f_area = "";
	String f_region = "";
	String n_town = "";
	String n_area = "";
	String n_region = "";
	String e_town = "";
 	String e_area = "";
 	String e_region = "";

 	String user_id = "";
	String facility_id = "";
	String encounter_id = "";
	String referal_id = "";
	String name_of_escort			= "";
	String address_of_escort			= "";
	String address_of_escort1		= "";
	String address_of_escort2		= "";
	String address_of_escort3		= "";
	String next_country1			= "";
	String ambulance_contact_no		= "";
	String motor_vehicle_reg_no		= "";
	String arrival_remarks			= "";
	String relation_val				= "";
	String accompany_by				= "";
	String nat_id_no				= "";
	String other_alt_id				= "";
	String oth_alt_id				= "";
	String m_postal_code			= "";
	String m_region					= "";
	String m_area					= "";
	String m_town					= "";
	String mlc_details_val			=  "";
	String locale="";
	String isAENextofKinchngAppl= ""; // added by mujafar for ML-MMOH-CRF-0632
	String patient_id1_val = ""; // // added by mujafar for ML-MMOH-CRF-0632
	
	public void ejbCreate() {}
	public void ejbRemove()  { }
	public void ejbActivate()   { }
	public void ejbPassivate()   { }
	public void setSessionContext (SessionContext sessioncontext)  {
		ctx = sessioncontext;
	}

	public void extractValues( java.util.HashMap ae_escort_type,java.util.HashMap ae_rel_contacts,java.util.HashMap session_details){
		try{
			contact1_email_id			= (String)ae_rel_contacts.get("contact1_email_id");
			contact1_mob_tel_no			= (String)ae_rel_contacts.get("contact1_mob_tel_no");
			contact1_new_nat_id_no		= (String)ae_rel_contacts.get("contact1_new_nat_id_no");
			contact1_birth_date			= (String)ae_rel_contacts.get("contact1_birth_date");

			occ_class					= (String)ae_rel_contacts.get("occ_class");
			occu_of_per_desc			=  (String)ae_rel_contacts.get("occu_of_per_desc");
			organization_name			= (String)ae_rel_contacts.get("organization_name");

			
 			contact2_nat_id_no			= (String)ae_rel_contacts.get("contact2_nat_id_no");
			contact2_mob_tel_no			= (String)ae_rel_contacts.get("contact2_mob_tel_no");
			contact2_email_id			= (String)ae_rel_contacts.get("contact2_email_id");
			
			next_contact_relation		= (String)ae_rel_contacts.get("next_contact_relation");
			next_contact_name			= (String)ae_rel_contacts.get("next_contact_name");
			next_job_title				= (String)ae_rel_contacts.get("next_job_title");
			next_addr_line1				= (String)ae_rel_contacts.get("next_addr_line1");
			next_addr_line2				= (String)ae_rel_contacts.get("next_addr_line2");
			next_addr_line3				= (String)ae_rel_contacts.get("next_addr_line3");
			next_addr_line4				= (String)ae_rel_contacts.get("next_addr_line4");
			next_postal_code			= (String)ae_rel_contacts.get("next_postal_code");
			next_country				= (String)ae_rel_contacts.get("next_country");
			next_res_tel_no				= (String)ae_rel_contacts.get("next_res_tel_no");

			first_off_tel_no			= (String)ae_rel_contacts.get("first_off_tel_no");
			first_addr_line1			= (String)ae_rel_contacts.get("first_addr_line1");
			first_addr_line2			= (String)ae_rel_contacts.get("first_addr_line2");
			first_addr_line3			= (String)ae_rel_contacts.get("first_addr_line3");
			first_addr_line4			= (String)ae_rel_contacts.get("first_addr_line4");
			first_postal_code			= (String)ae_rel_contacts.get("first_postal_code");
			first_country_code			= (String)ae_rel_contacts.get("first_country_code");
			first_job_title				= (String)ae_rel_contacts.get("first_job_title");
			first_res_tel_no			= (String)ae_rel_contacts.get("first_res_tel_no");

			next_off_tel_no				= (String)ae_rel_contacts.get("next_off_tel_no");
			notify_name					= (String)ae_rel_contacts.get("notify_name");

			employ_addr_line1			= (String)ae_rel_contacts.get("employ_addr_line1");
			employ_addr_line2			= (String)ae_rel_contacts.get("employ_addr_line2");
 			employ_addr_line3			= (String)ae_rel_contacts.get("employ_addr_line3");
			employ_addr_line4			= (String)ae_rel_contacts.get("employ_addr_line4");
			employ_postal_code			= (String)ae_rel_contacts.get("employ_postal_code");
			empyr_country_code			= (String)ae_rel_contacts.get("empyr_country_code");
			empl_occupation				= (String)ae_rel_contacts.get("empl_occupation");
			empyr_eid					= (String)ae_rel_contacts.get("empyr_eid");
			empl_status					= (String)ae_rel_contacts.get("empl_status");
			empyr_contact_name			= (String)ae_rel_contacts.get("empyr_contact_name");
			empyr_off_tel_no			= (String)ae_rel_contacts.get("empyr_off_tel_no");

			relationship				= (String)ae_rel_contacts.get("relationship");
			res3_tel_no					= (String)ae_rel_contacts.get("res3_tel_no");

			f_town						= (String)ae_rel_contacts.get("f_town");
			f_area						= (String)ae_rel_contacts.get("f_area");
			f_region					= (String)ae_rel_contacts.get("f_region");
			n_town						= (String)ae_rel_contacts.get("n_town");
			n_area						= (String)ae_rel_contacts.get("n_area");
			n_region					= (String)ae_rel_contacts.get("n_region");
			e_town						= (String)ae_rel_contacts.get("e_town");
 			e_area						= (String)ae_rel_contacts.get("e_area");
 			e_region					= (String)ae_rel_contacts.get("e_region");
			
			isAENextofKinchngAppl       = (String)ae_rel_contacts.get("isAENextofKinchngAppl");
			patient_id1_val             =  (String)ae_rel_contacts.get("patient_id1_val");

			encounter_id				= (String)ae_escort_type.get("encounter_id");
			referal_id					= (String)ae_escort_type.get("referal_id");
			name_of_escort				= (String)ae_escort_type.get("name_of_escort") ; 
			address_of_escort			= (String)ae_escort_type.get("address_of_escort");
			address_of_escort1			= (String)ae_escort_type.get("address_of_escort1");
			address_of_escort2			= (String)ae_escort_type.get("address_of_escort2") ;
			address_of_escort3			= (String)ae_escort_type.get("address_of_escort3");
			next_country1				= (String)ae_escort_type.get("next_country1");
			ambulance_contact_no		= (String)ae_escort_type.get("ambulance_contact_no");
			motor_vehicle_reg_no		= (String)ae_escort_type.get("motor_vehicle_reg_no");
			arrival_remarks				= (String)ae_escort_type.get("arrival_remarks");
			relation_val				= (String)ae_escort_type.get("relation_val");
			accompany_by				= (String)ae_escort_type.get("accompany_by");
			nat_id_no					= (String)ae_escort_type.get("nat_id_no");
			other_alt_id				= (String)ae_escort_type.get("other_alt_id");
			oth_alt_id					= (String)ae_escort_type.get("oth_alt_id");
			m_postal_code				= (String)ae_escort_type.get("m_postal_code");
			m_region					= (String)ae_escort_type.get("m_region");
			m_area						= (String)ae_escort_type.get("m_area");
			m_town						= (String)ae_escort_type.get("m_town");
			mlc_details_val				= (String)ae_escort_type.get("mlc_details_val");
			addedAtWorkstation			= (String)session_details.get("addedAtWorkstation");
			user_id						= (String)session_details.get("user_id");
			facility_id					= (String)session_details.get("facility_id");
			ae_escort_type.clear();
			ae_rel_contacts.clear();
			session_details.clear();
		}catch(Exception e){e.printStackTrace();}
	}


	/**
	 *Method to update AE Revise Visit
	 *@param properties Connection Properties
	 *@param hashaMap AE Escort Data
	 *@param hashaMap AE Related condact Details
	 *@param hashaMap Session Details
	 *@return HashMap holding the transaction details
	*/
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/


	public java.util.HashMap updateAEReviseVisit(java.util.Properties p, java.util.HashMap ae_escort_type,java.util.HashMap ae_rel_contacts,java.util.HashMap session_details)  {
		sb  				= new StringBuffer();
		sbMessage 		= new StringBuffer("");
		result 			= false;
		rs1				= 0;
		locale=(String)session_details.get("locale");
	   	try {
			extractValues(ae_escort_type, ae_rel_contacts, session_details);
			con = ConnectionManager.getConnection(p);
			con.setAutoCommit(false);
			rs1 = 0;
			if((referal_id==null) || (referal_id.equals("null"))) 
			referal_id	="";
			if (!referal_id.equals("")) {

				result = updatingPrEncounter();
				if(result) rs1 = 1;
				else rs1 = 0;
				StringBuffer opstm = new StringBuffer();
				opstm.append("UPDATE OP_PATIENT_QUEUE SET REFERRAL_ID=?,MODIFIED_BY_ID = ?,");
				opstm.append("MODIFIED_DATE = SYSDATE ,MODIFIED_FACILITY_ID =  ?, MODIFIED_AT_WS_NO=? ");
				opstm.append("WHERE FACILITY_ID = ? and ENCOUNTER_ID = ? ");
				pstmt= con.prepareStatement(opstm.toString());
				pstmt.setString(1, referal_id) ;
				pstmt.setString(2, user_id);
				pstmt.setString(3, facility_id);
				pstmt.setString(4, addedAtWorkstation) ;
				pstmt.setString(5, facility_id);
				pstmt.setString(6, encounter_id) ;
				pstmt.executeUpdate();
				if(opstm != null)
				    opstm.delete(0,opstm.length());
				if(pstmt!=null) pstmt.close();
				sb.append("After Update  PR_ENCOUNTER_OTHER_DETAIL"+rs1);

				String refSql ="";
				int refCount = 0;
				/*Modified by Dharma for AUDIT COLUMNS update Start*/
				//refSql = "update pr_referral_register set status = 'C' , referred_in_func = 3 where referral_id ='"+referal_id+"' ";	
				refSql = "update pr_referral_register set status = 'C' , referred_in_func = 3 , MODIFIED_BY_ID = ?,MODIFIED_DATE = SYSDATE ,MODIFIED_FACILITY_ID =  ?, MODIFIED_AT_WS_NO=? where referral_id ='"+referal_id+"' ";
				pstmt = con.prepareStatement(refSql);
				pstmt.setString(1, user_id);
				pstmt.setString(2, facility_id);
				pstmt.setString(3, addedAtWorkstation) ;
				/*Modified by Dharma for AUDIT COLUMNS update Start*/
				refCount = pstmt.executeUpdate();				

				if(refCount>0)
					result = true;
				else {	 
					result = false;
				}
				if(pstmt!=null) pstmt.close();
				
			}
			result = updatingPrEncounterOtherDetail();

			if(result) rs1 = 1;
			else rs1 = 0;
			sb.append("After Update  PR_ENCOUNTER_OTHER_DETAIL"+rs1);
			if(result) {
				sb.append("Before Update  AE_PAT_RELATED_CONTACTS");
				result = updatingAEPatRelatedContacts();

				if(result) rs1 = 1;
				else rs1 = 0;
				sb.append("After Update  AE_PAT_RELATED_CONTACTS"+rs1);
			} // End of if result
			if(result) {
				// TO Update the MLC Details, if entered
			 	sb.append("Before Update  AE_PAT_EMERGENCY_DETAIL");
				if(!mlc_details_val.equals("")) {
					StringBuffer sql4 		= new StringBuffer();
					sql4.append("UPDATE AE_PAT_EMERGENCY_DETAIL SET "); 
					sql4.append("MEDICO_LEGAL_DETAILS = ?,MODIFIED_BY_ID = ?, "); 
					sql4.append("MODIFIED_DATE  = SYSDATE , "); 
					sql4.append("MODIFIED_FACILITY_ID = ?, MODIFIED_AT_WS_NO= ? "); 
					sql4.append("WHERE FACILITY_ID = ? and ENCOUNTER_ID = ? "); 
					pstmt= con.prepareStatement(sql4.toString());
					pstmt.setString(1, mlc_details_val) ;
					pstmt.setString(2, user_id);
					pstmt.setString(3, facility_id);
					pstmt.setString(4, addedAtWorkstation) ;
					pstmt.setString(5, facility_id);
					pstmt.setString(6, encounter_id) ;
					rs1 =  pstmt.executeUpdate();
					if(rs1 > 0)
						result	= true;
					else
						result	= false;
					if(pstmt!=null) pstmt.close();
					sb.append("After Update  AE_PAT_EMERGENCY_DETAIL"+rs1);			 
				} // end of if	  mlc_details_val
			} // End of if result
			MessageManager mess = new MessageManager();
			if(result) {
				con.commit();
				final java.util.Hashtable message = mess.getMessage(locale,"RECORD_MODIFIED","SM") ;
				String msg=(String)message.get("message");
				sbMessage.append(msg);
				message.clear();
			} else {
				con.rollback();
				sb.append("Transaction Failed ....");
			}
			ae_escort_type.clear();
			ae_rel_contacts.clear();
			session_details.clear();
		} // End of the try
		catch(Exception exception) {
        		sb.append("Catch :"+exception.getMessage()) ; 
			result=false;
        		try{
				con.rollback();
			}catch(Exception e) {e.printStackTrace();}
				sb.append("EJB Catch");
				sb.append(exception.toString());
				exception.printStackTrace();
        	} finally  {
			if(con!=null) { ConnectionManager.returnConnection(con,p); }
		} // End of the Finally
		results.put("status",new Boolean(result));
		results.put("error",sb.toString());
		results.put("ResultFromMessageManager", sbMessage.toString());
		return results;
	} // End of the method updateAEReviseVisit

	// New Function Added to split the updateAEReviseVisit

	//*************** Function 1 *************************

	public boolean updatingPrEncounter(){
		StringBuffer sql1 		= new StringBuffer();    
		StringBuffer sql2 		= new StringBuffer();    
		try{
			sql1.append(" UPDATE PR_ENCOUNTER SET ");
			sql1.append(" REFERRAL_ID = ? , MODIFIED_BY_ID = ?, ");
			sql1.append(" MODIFIED_DATE  = SYSDATE ,MODIFIED_FACILITY_ID = ?, ");
			sql1.append(" MODIFIED_AT_WS_NO	= ? ");
			sql1.append(" WHERE FACILITY_ID = ? and ENCOUNTER_ID = ? ");

			pstmt= con.prepareStatement(sql1.toString());  

			pstmt.setString(1, referal_id) ;
			pstmt.setString(2, user_id);
			pstmt.setString(3, facility_id);
			pstmt.setString(4,addedAtWorkstation) ;
			pstmt.setString(5, facility_id);
			pstmt.setString(6, encounter_id) ;

			pstmt.executeUpdate();

			sql2.append(" UPDATE OP_LAST_VISIT_FOR_SERVICE SET ");
			sql2.append(" REFERRAL_ID = ? , MODIFIED_BY_ID = ?, ");
			sql2.append(" MODIFIED_DATE  = SYSDATE ,MODIFIED_FACILITY_ID = ?, ");
			sql2.append(" MODIFIED_AT_WS_NO	= ?  ");
			sql2.append(" WHERE OPERATING_FACILITY_ID = ? and ENCOUNTER_ID = ? ");
			

			pstmt2= con.prepareStatement(sql2.toString());  
			pstmt2.setString(1, referal_id) ;
			pstmt2.setString(2, user_id);
			pstmt2.setString(3, facility_id);
			pstmt2.setString(4,addedAtWorkstation) ;
			pstmt2.setString(5, facility_id);
			pstmt2.setString(6, encounter_id) ;

			pstmt2.executeUpdate();
			
			
		}catch (Exception e) {
			e.printStackTrace();
		    return false;
		}
		try{
			sql1.delete(0,sql1.length());
			if(pstmt!=null) pstmt.close();
			sql2.delete(0,sql2.length());
			if(pstmt2!=null) pstmt2.close();
		}catch(Exception e) {e.printStackTrace();}
		return true;
	}

	//*************** Function 2 *************************

	public boolean updatingPrEncounterOtherDetail(){
		StringBuffer sql2 		= new StringBuffer();
		try{
			sql2.append(" UPDATE PR_ENCOUNTER_OTHER_DETAIL SET ");
			sql2.append(" ESCORT_NAME = ? , ESCORT_ADD_LN1 = ?, ESCORT_ADD_LN2 = ?,");
			sql2.append(" ESCORT_ADD_LN3 = ? , ESCORT_ADD_LN4 = ?, ");
			sql2.append(" ESCORT_ADD_POSTAL_CODE = ?, ESCORT_COUNTRY_CODE = ?, ");
			sql2.append(" ESCORT_TEL_NUM = ? , ESCORT_MV_REG_NO = ?,  ");
			sql2.append(" ESCORT_REMARKS = ? ,MODIFIED_BY_ID = ?, ");
			sql2.append(" MODIFIED_DATE  = SYSDATE ,MODIFIED_FACILITY_ID = ?, ");
			sql2.append(" MODIFIED_AT_WS_NO	= ? ,RELATION_TO_PATIENT	= ?,");
			sql2.append(" ACCOMPANIED_BY_CODE=?,ESCORT_NATIONAL_ID_NO=?, ");
			sql2.append(" ESCORT_OTH_ALT_ID_TYPE= ?,ESCORT_OTH_ALT_ID_NO =?, ");
			sql2.append(" ESCORT_REGION_CODE=?,RES_AREA_CODE=?,RES_TOWN_CODE=? ");
			sql2.append(" WHERE OPERATING_FACILITY_ID = ? and ENCOUNTER_ID = ? " );

			pstmt= con.prepareStatement(sql2.toString());  

		        pstmt.setString(1, name_of_escort) ; 
			pstmt.setString(2, address_of_escort) ;
			pstmt.setString(3, address_of_escort1) ;
			pstmt.setString(4, address_of_escort2) ;
			pstmt.setString(5, address_of_escort3) ;
			pstmt.setString(6, m_postal_code) ;
			pstmt.setString(7, next_country1) ;
			pstmt.setString(8, ambulance_contact_no) ;
			pstmt.setString(9, motor_vehicle_reg_no) ;
			pstmt.setString(10, arrival_remarks) ;
			pstmt.setString(11, user_id);
			pstmt.setString(12, facility_id);
			pstmt.setString(13, addedAtWorkstation) ;
			pstmt.setString(14, relation_val) ;
			pstmt.setString(15, accompany_by) ;
			pstmt.setString(16, nat_id_no) ;
			pstmt.setString(17, other_alt_id) ;
			pstmt.setString(18, oth_alt_id) ;
			pstmt.setString(19, m_region) ;
			pstmt.setString(20, m_area) ;
			pstmt.setString(21, m_town) ;
			pstmt.setString(22, facility_id);
			pstmt.setString(23, encounter_id) ;

			pstmt.executeUpdate();

		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		try{
			sql2.delete(0,sql2.length());
			if(pstmt!=null) pstmt.close();
		}catch(Exception e) { e.printStackTrace(); }
		return true;
	}
	//*************** Function 3 *************************

	public boolean updatingAEPatRelatedContacts(){
		StringBuffer sql3 		= new StringBuffer();	
		try{
			
			sql3.append("UPDATE AE_PAT_RELATED_CONTACTS SET "); 
			sql3.append("CONTACT1_EMAIL_ID=?,CONTACT1_MOB_TEL_NO=?, "); 
			sql3.append("CONTACT1_NATIONAL_ID_NO=?,OCPN_CLASS_CODE=?, "); 
			sql3.append("OCPN_DESC=?,CONTACT1_RELATION=?,CONTACT2_NATIONAL_ID_NO=?, "); 
			sql3.append("CONTACT2_MOB_TEL_NO=?,CONTACT2_EMAIL_ID=?, "); 
			sql3.append("CONTACT1_NAME =?,JOB1_TITLE =?, ADDR1_LINE1 =?, "); 
			sql3.append("ADDR1_LINE2 =?,ADDR1_LINE3 =?,ADDR1_LINE4 =?, "); 
			sql3.append("POSTAL1_CODE =?,COUNTRY1_CODE =?,RES1_TEL_NO =?,"); 
			sql3.append("OFF2_TEL_NO =?,EMPLOYER_NAME =?,ADDR2_LINE1 =?,");
			sql3.append("ADDR2_LINE2 =?, ADDR2_LINE3 =?,ADDR2_LINE4 =?,"); 
			sql3.append("POSTAL2_CODE = ?,COUNTRY2_CODE =?, "); 
			sql3.append("FIRST_TO_NOTIFY_NAME =?,ADDR3_LINE1 =?, "); 
			sql3.append("ADDR3_LINE2 =?,ADDR3_LINE3 =?, ADDR3_LINE4 =?,"); 
			sql3.append("POSTAL3_CODE =?,COUNTRY3_CODE =?,"); 
			sql3.append("OCPN_CODE =?,PATIENT_EMPLOYEE_ID =?,"); 
			sql3.append("EMPLOYMENT_STATUS =?,MODIFIED_BY_ID = ?,"); 
			sql3.append("MODIFIED_DATE  = SYSDATE ,MODIFIED_FACILITY_ID = ?, "); 
			sql3.append("MODIFIED_AT_WS_NO=?,CONTACT2_RELATION = ?,"); 
			sql3.append("CONTACT1_TOWN_CODE=?,CONTACT1_AREA_CODE=?, "); 
			sql3.append("CONTACT1_REGION_CODE=?,CONTACT2_TOWN_CODE=?,"); 
			sql3.append("CONTACT2_AREA_CODE=?,CONTACT2_REGION_CODE=?,"); 
			sql3.append("CONTACT3_TOWN_CODE=?,CONTACT3_AREA_CODE=?,"); 
			sql3.append("CONTACT3_REGION_CODE=?,CONTACT1_BIRTH_DATE= to_date(?,'dd/mm/yyyy'),"); 
			sql3.append("JOB2_TITLE=?,RES2_TEL_NO=?,OFF1_TEL_NO=?,"); 
			sql3.append("CONTACT3_NAME=?,RES3_TEL_NO=?,OFF3_TEL_NO=?"); 
			if(isAENextofKinchngAppl.equals("true")) // added by mujafar for ML-MMOH-CRF-0632
			sql3.append(",REL_PATIENT_ID=?"); 
			
			sql3.append("WHERE FACILITY_ID = ? and ENCOUNTER_ID = ? ");
				  
			pstmt= con.prepareStatement(sql3.toString());

			pstmt.setString(1, contact1_email_id) ;
			pstmt.setString(2, contact1_mob_tel_no) ;
			pstmt.setString(3, contact1_new_nat_id_no) ;	
			pstmt.setString(4, occ_class) ;
	    		pstmt.setString(5, occu_of_per_desc) ;
			pstmt.setString(6, next_contact_relation) ;
 			pstmt.setString(7, contact2_nat_id_no) ;
			pstmt.setString(8, contact2_mob_tel_no) ;
			pstmt.setString(9, contact2_email_id) ;
			pstmt.setString(10, next_contact_name) ;
			pstmt.setString(11, next_job_title) ;
			pstmt.setString(12, next_addr_line1) ;
			pstmt.setString(13, next_addr_line2) ;
			pstmt.setString(14, next_addr_line3) ;
			pstmt.setString(15, next_addr_line4) ;
			pstmt.setString(16, next_postal_code) ;
			pstmt.setString(17, next_country) ;
			pstmt.setString(18, next_res_tel_no) ;
			pstmt.setString(19, first_off_tel_no) ;
			pstmt.setString(20, organization_name) ;
			pstmt.setString(21, first_addr_line1) ;
			pstmt.setString(22, first_addr_line2) ;
			pstmt.setString(23, first_addr_line3) ;
			pstmt.setString(24, first_addr_line4) ;
			pstmt.setString(25, first_postal_code) ;
			pstmt.setString(26, first_country_code) ;
			pstmt.setString(27, notify_name) ;
			pstmt.setString(28, employ_addr_line1) ;
			pstmt.setString(29, employ_addr_line2) ;
 			pstmt.setString(30, employ_addr_line3) ;
			pstmt.setString(31, employ_addr_line4) ;
			pstmt.setString(32, employ_postal_code) ;
			pstmt.setString(33, empyr_country_code) ;
			pstmt.setString(34, empl_occupation) ;
			pstmt.setString(35, empyr_eid) ;
			pstmt.setString(36, empl_status) ;
			pstmt.setString(37, user_id);
			pstmt.setString(38, facility_id);
			pstmt.setString(39, addedAtWorkstation) ;
			pstmt.setString(40, relationship);
			pstmt.setString(41, n_town); // modified for ML-MMOH-CRF-0632
			pstmt.setString(42, n_area);
			pstmt.setString(43, n_region);
			pstmt.setString(44, f_town);
			pstmt.setString(45, f_area);
			pstmt.setString(46, f_region);
			pstmt.setString(47, e_town);
 			pstmt.setString(48, e_area);
 			pstmt.setString(49, e_region);
 			pstmt.setString(50, contact1_birth_date);
			pstmt.setString(51, first_job_title);
			pstmt.setString(52, first_res_tel_no);
			pstmt.setString(53, next_off_tel_no);
			pstmt.setString(54, empyr_contact_name);
			pstmt.setString(55, res3_tel_no);
			pstmt.setString(56, empyr_off_tel_no);
			if(isAENextofKinchngAppl.equals("true")) // added by mujafar for ML-MMOH-CRF-0632
			{
				pstmt.setString(57, patient_id1_val) ;
				pstmt.setString(58, facility_id);
				pstmt.setString(59, encounter_id) ;
			}
			else
			{
			pstmt.setString(57, facility_id);
			pstmt.setString(58, encounter_id) ;
			}
			
			rs1 =  pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		    return false;
		}
		try{
			sql3.delete(0,sql3.length());
			if(pstmt!=null) pstmt.close();
		}catch(Exception e) { e.printStackTrace(); }
		return true;
	}
		
			

} //End of the Class
