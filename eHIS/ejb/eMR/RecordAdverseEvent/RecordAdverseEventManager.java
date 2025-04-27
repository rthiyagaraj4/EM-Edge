/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMR.RecordAdverseEvent;


import java.rmi.* ;
import javax.ejb.* ;
import java.util.*;
import java.sql.* ;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;
import java.sql.Timestamp;

/**
*
* @ejb.bean
*	name="RecordAdverseEvent"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="RecordAdverseEvent"
*	local-jndi-name="RecordAdverseEvent"
*	impl-class-name="eMR.RecordAdverseEvent.RecordAdverseEventManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eMR.RecordAdverseEvent.RecordAdverseEventLocal"
*	remote-class="eMR.RecordAdverseEvent.RecordAdverseEventRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eMR.RecordAdverseEvent.RecordAdverseEventLocalHome"
*	remote-class="eMR.RecordAdverseEvent.RecordAdverseEventHome"
*	generate= "local,remote"
*
*
*/



public class RecordAdverseEventManager
    implements SessionBean
{
	  /*HashMap results	    = new HashMap();    
	 // Connection con =null;
	  ResultSet rs=null;
	  Statement stmt=null;
	  PreparedStatement pstmt=null,pstmt1=null,pstmt2=null,pstmt3=null;*/
    public RecordAdverseEventManager()
    {
       
    }

   /* public void ejbCreate()
        throws CreateException
    {
    }
*/
 public void ejbCreate()
    {
    }
    public void ejbRemove()
    {
    }

    public void ejbActivate()
    {
    }

    public void ejbPassivate()
    {
    }

    public void setSessionContext(SessionContext sessioncontext)
    {
    }

	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
    public java.util.HashMap  insertAdveEvent(Properties properties,HashMap hashmap)
	{
	  HashMap results	    = new HashMap();    
	  ResultSet rs			= null;
	  Statement stmt		= null;
	  PreparedStatement pstmt=null;			
	  Connection con		= null;
	  
	  CallableStatement cstmt = null;//this line added for this CRF Bru-HIMS-CRF-133
	  
	 try
     {
		  	String addedById = "",addedFacilityId = "",addedAtWorkstation = "", modifiedFacilityId = "",status_val = "";
			//boolean flag=true;
			boolean result_kn	= true;
			boolean result		= false;
			int result1			= 0;
			properties			= (Properties)hashmap.get("p");
			con					= ConnectionManager.getConnection(properties);
            con.setAutoCommit(false);
			stmt				= con.createStatement();
			String	PatientId	= (String)hashmap.get("PatientId");
            String certainity	= (String)hashmap.get("certainity");
			//String severity_head = (String)hashmap.get("severity_head");
			String adv_event_ind	= (String)hashmap.get("adv_event_ind");
            String adv_event_type	= (String)hashmap.get("adv_event_type");
            String allergen		= (String)hashmap.get("allergen");
            String onset_date	= (String)hashmap.get("onset_date");
			String Encounter_Id	= (String)hashmap.get("Encounter_Id");
			String facilityId	= (String)hashmap.get("facilityId");
			String modifiedById	= (String)hashmap.get("modifiedById");
			String visit_adm_date_time		= (String)hashmap.get("visit_adm_date_time");
			String assign_care_locn_type	= (String)hashmap.get("assign_care_locn_type");
			String assign_care_locn_code	= (String)hashmap.get("assign_care_locn_code");
			String attend_practitioner_id	= (String)hashmap.get("attend_practitioner_id");
			String adv_event_srl_no			= (String)hashmap.get("adv_event_srl_no");
			String diagnosis_code			= (String)hashmap.get("diagnosis_code");
			String status_date				= (String)hashmap.get("status_date");
			String react_code_val			= (String)hashmap.get("react_code_val");
			String term_code				= (String)hashmap.get("term_code");
			String no_known_allergy			= (String)hashmap.get("no_known_allergy");
			String allergy_conf_reqd_yn			= (String)hashmap.get("allergy_conf_reqd_yn");//Added for the CRF - RUT-CRF-0064

			//String chkreact1=(String)hashmap.get("chkreact1");
			String estimated_duration_yn	= (String)hashmap.get("estimated_duration_yn");

			//String drug_code=(String)hashmap.get("drug_code");

			//String react_values_main=(String)hashmap.get("react_values_main");
			//String Site_Of_Reac_oth=(String)hashmap.get("Site_Of_Reac_oth");
			//String severity_oth=(String)hashmap.get("severity_oth");
			//String other_reaction_date=(String)hashmap.get("other_reaction_date");
			//String other_reaction=(String)hashmap.get("other_reaction");
			
			/*Below line added for this CRF Bru-HIMS-CRF-133*/
			String isPatientEncMovement			= (String) hashmap.get("isPatientEncMovement"); 
		    String Sydate = (String) hashmap.get("Sydate"); 
			String p_queue_date = (String) hashmap.get("p_queue_date"); 
			String p_queue_status = (String) hashmap.get("p_queue_status"); 
			//End Bru-HIMS-CRF-133
			
			String otherAllergenFreeTxt		= checkForNull((String)hashmap.get("otherAllergenFreeTxt"));//Added by Thamizh selvi on 21st Dec 2017 against ML-MMOH-CRF-0751
			addedById						= modifiedById;
			addedFacilityId					= facilityId;
			modifiedFacilityId				= facilityId;
			String modifiedAtWorkstation	= (String)hashmap.get("modifiedAtWorkstation");
			addedAtWorkstation				= modifiedAtWorkstation;
			String status					= "A";
			status_val						= "A";
			java.util.HashMap ret			= new HashMap();   
			boolean retval					= true;
			/*Below lines added by venkatesh.S against ML-MMOH-CRF-0366 */
			String onset_type				=(String) hashmap.get("onset_type"); 
			String comments					=(String) hashmap.get("comments"); 
			/*end ML-MMOH-CRF-0366 */
			 
			if(no_known_allergy.equals("N") || no_known_allergy.equals("U"))
			{
				try
				{

					//String sql_known = "update mp_patient set known_allergy_yn=?,modified_by_id = ?,modified_at_ws_no = ?, modified_date = sysdate  where  patient_id = ?";
					/*Wednesday, March 02, 2011 , SRR20056-SCF-7005 [IN:026717]*/
					/*Added the Audit column in the below query*/
					String sql_known = "update mp_patient set known_allergy_yn=?,modified_by_id=?,modified_date=sysdate,modified_at_ws_no=?,modified_facility_id=?  where  patient_id = ?";

					pstmt = con.prepareStatement(sql_known.toString());

					pstmt.setString(1,no_known_allergy);
					pstmt.setString(2,modifiedById);
					pstmt.setString(3,modifiedAtWorkstation);
					pstmt.setString(4,modifiedFacilityId);
					pstmt.setString(5,PatientId);

					int result_known=pstmt.executeUpdate();

					if(result_known!=0)
					{		
						result_kn=true;
					}
					else
					{
						result_kn =false;
					}

					if(pstmt != null) pstmt.close();

					//Added for the CRF - RUT-CRF-0064 - Start
					if(result_kn && allergy_conf_reqd_yn.equals("Y")){
						result_kn=insertAllergyConfirmationDetails(properties, hashmap,con);
					}
					//Added for the CRF - RUT-CRF-0064 - End
					if(result_kn)
					{
					 result = true ;
					 con.commit();
				
					}else{
						con.rollback();
						result = false;
						result_kn = false;
					}
					results.put( "status", new Boolean(result) ) ;
					results.put( "error", "1") ;
					if(pstmt != null) pstmt.close();
					if(rs != null) rs.close();
					if(stmt !=null) stmt.close();
					hashmap.clear();
				}
				catch (Exception en)
				{
					result_kn = false;
					en.printStackTrace();
				}
				
			}
			else
			{

				try
				{
					//String sql_known = "update mp_patient set known_allergy_yn=?,modified_by_id = ?,modified_at_ws_no = ?, modified_date = sysdate  where  patient_id = ?";
					/*Wednesday, March 02, 2011 , SRR20056-SCF-7005 [IN:026717]*/
					/*Added the Audit column in the below query*/
					String sql_known = "update mp_patient set known_allergy_yn=?,modified_by_id=?,modified_date=sysdate,modified_at_ws_no=?,modified_facility_id=?  where  patient_id = ?";
					pstmt = con.prepareStatement(sql_known.toString());
					pstmt.setString(1,no_known_allergy);
					pstmt.setString(2,modifiedById);
					pstmt.setString(3,modifiedAtWorkstation);
					pstmt.setString(4,modifiedFacilityId);
					pstmt.setString(5,PatientId);
					int result_known=pstmt.executeUpdate();


					if(result_known!=0)
					{		
						result_kn=true;
					}
					else
					{
						result_kn =false;
					}

					if(pstmt != null) pstmt.close();
						
				}
				catch (Exception em)
				{
					em.printStackTrace();
				}
				//Added for the CRF - RUT-CRF-0064 - Start
				if(result_kn && allergy_conf_reqd_yn.equals("Y")){
					result_kn=insertAllergyConfirmationDetails(properties, hashmap,con);
				}
				//Added for the CRF - RUT-CRF-0064 - End
			if(result_kn)
			{
			    
				/*Below line added for this CRF Bru-HIMS-CRF-133*/							
							if(eOP.QMSInterface.isSiteSpecific(con,"OP","PATENC_MOVEMENT") && isPatientEncMovement.equals("true") && p_queue_date.equals(Sydate)){
							    cstmt = con.prepareCall("{call PR_ENC_MVMNT(?,?,?,?,?)}");
							    cstmt.setString(1, facilityId);
							    cstmt.setString(2, PatientId);
							    cstmt.setString(3, Encounter_Id);
								cstmt.setString(4, p_queue_status);
								cstmt.registerOutParameter(5, java.sql.Types.VARCHAR);								
								cstmt.execute();	
								String err_pr_enc_mvmnt= cstmt.getString(5);
								
								if (cstmt != null){
									cstmt.close();
								}							 
							 }
							 //End Bru-HIMS-CRF-133
			
			 
			              
						/*Below lines ONSET_TYPE,COMMENTS added by venkatesh.S against ML-MMOH-CRF-0366 */
				String sql_insert_pr_adverse_event_hdr= "insert into  PR_ALLERGY_SENSITIVITY (PATIENT_ID, ADV_EVENT_TYPE_IND, ADV_EVENT_TYPE, ALLERGEN_CODE, ADV_EVENT_SRL_NO, CERTAINTY, SEVERITY, ONSET_FACILITY_ID, ONSET_ENCOUNTER_ID, ONSET_ENCOUNTER_DATE, ONSET_LOCN_TYPE, ONSET_LOCN_CODE, ONSET_PRACTITIONER_ID, ONSET_DATE, STATUS, ACTIVE_DATE,REACTION_CODE_VALUES,ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,DIAGNOSIS_CODE,TERM_SET_ID,CALCULATED_ONSET_DATE_YN,ONSET_TYPE,COMMENTS,OTHER_ALLERGEN) values (?,?,?,?,?,?,?,?,?,TO_DATE('"+visit_adm_date_time+"','dd/mm/yyyy'),?,?,?,TO_DATE('"+onset_date+"','dd/mm/yyyy hh24:mi:ss'),?,TO_DATE('"+status_date+"','dd/mm/yyyy'),?,?,sysdate,?,?,?,sysdate,?,?,?,?,?,?,?,?)";//Modified by Thamizh selvi on 21st Dec 2017 against ML-MMOH-CRF-0751

				pstmt = con.prepareStatement(sql_insert_pr_adverse_event_hdr);
           
          
				if(status_val.equals("A"))
				{
					pstmt.setString(1,  PatientId);
                    pstmt.setString(2,  adv_event_ind);
                    pstmt.setString(3,  adv_event_type);
                    pstmt.setString(4,  allergen);
                    pstmt.setString(5,  adv_event_srl_no);
                    pstmt.setString(6,  certainity);
                    //pstmt.setString(7,  severity_head);
					pstmt.setString(7,  "");
                    pstmt.setString(8,  facilityId);
                    pstmt.setString(9,  Encounter_Id);
					pstmt.setString(10, assign_care_locn_type);
                    pstmt.setString(11, assign_care_locn_code);
					pstmt.setString(12, attend_practitioner_id);
                    pstmt.setString(13, status);
					pstmt.setString(14, react_code_val);
                    pstmt.setString(15, addedById);
                    pstmt.setString(16, addedAtWorkstation);
					pstmt.setString(17, addedFacilityId);
                    pstmt.setString(18, modifiedById);
                    pstmt.setString(19, modifiedAtWorkstation);
                    pstmt.setString(20, modifiedFacilityId);
					pstmt.setString(21, diagnosis_code);
					pstmt.setString(22, term_code);
					pstmt.setString(23, estimated_duration_yn);
					pstmt.setString(24, onset_type);
					pstmt.setString(25, comments.replaceAll("'","`"));
					pstmt.setString(26, otherAllergenFreeTxt);//Added by Thamizh selvi on 21st Dec 2017 against ML-MMOH-CRF-0751
					result1 = pstmt.executeUpdate();
					if(result1 > 0)
						result_kn	= true ;
					else
						result_kn   = false ;
				}else
				{
					if(rs !=null ) rs.close();
					String sql_adv_srl_num=" select ADV_EVENT_SRL_NO from PR_ALLERGY_SENSITIVITY where ADV_EVENT_TYPE_IND='"+adv_event_ind+"' and  ADV_EVENT_TYPE='"+adv_event_type+"' and ALLERGEN_CODE='"+allergen+"'";
					 rs=stmt.executeQuery(sql_adv_srl_num);
					 if(rs !=null && rs.next())
					 {
						 adv_event_srl_no=rs.getString("ADV_EVENT_SRL_NO");
						 if(adv_event_srl_no ==null) adv_event_srl_no="";
					 }
					if(!adv_event_srl_no.equals("null") || !adv_event_srl_no.equals(""))
					{
						result1	= 1;
						result_kn	= true ;
					}else
					{
						result1 = 0;
						result_kn   = false ;
					}
				}
			}
			  if(rs !=null) rs.close();
			  if(stmt !=null) stmt.close();
	          if(result_kn)
			  {
				// flag=true;
					ret			= insertAdveEvent_two( properties, hashmap,con);
					retval		= ((Boolean)ret.get("status")).booleanValue();
				
				  if(retval)
					  result	= true;
				  else
					  result    = false;
					
				}
				results.put( "status", new Boolean(result) ) ;
				results.put( "error", "1") ;
				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();
				if(stmt !=null) stmt.close();
				hashmap.clear();
				ret.clear();
			}
			/*
			results.put( "status", new Boolean(result) ) ;
			results.put( "error", "1") ;
			 if(pstmt != null) pstmt.close();
			 if(rs != null) rs.close();
			 if(stmt !=null) stmt.close();
			 hashmap.clear();
			 */
	}catch (Exception e1)
     {
		e1.printStackTrace();
     }
	 finally{
		
		if(con !=null)	ConnectionManager.returnConnection(con,properties);
	}
	return results;
}


	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public java.util.HashMap  modifyAdveEvent(Properties properties,HashMap hashmap)
	{
		HashMap results			= new HashMap();    
		ResultSet rs			= null;
		Statement stmt			= null;
		PreparedStatement pstmt	= null,pstmt1=null,pstmt2=null,pstmt3=null;
		Connection con			= null;
	 try
     {

		String 		addedById="",addedFacilityId="",addedAtWorkstation="",modifiedFacilityId="",reaction_code="",adv_event_reac_srl_no="",sql_insert_pr_adverse_event_reaction="",sql_srl_num_three="",sql_insert_pr_adverse_event_reaction_oth="",sql_srl_num_three_oth="";
		
		boolean flag			= true;
		int result1=0,result2=0,result3=0;
		properties				= (Properties)hashmap.get("p");
		con						= ConnectionManager.getConnection(properties);
        con.setAutoCommit(false);
		stmt					= con.createStatement();
		String	PatientId		= (String)hashmap.get("PatientId");
        String certainity		= (String)hashmap.get("certainity");
			String adv_event_ind =(String)hashmap.get("adv_event_ind");
            String adv_event_type =(String)hashmap.get("adv_event_type");
            String allergen = (String)hashmap.get("allergen");
			//String reaction_date=(String)hashmap.get("reaction_date");
			String sou_of_info=(String)hashmap.get("sou_of_info");
			String remarks=(String)hashmap.get("remarks");

			String treat_advice=(String)hashmap.get("treat_advice");
			String allergy_test_res=(String)hashmap.get("allergy_test_res");
			//String Site_Of_Reac=(String)hashmap.get("Site_Of_Reac");
			//String other_reaction=(String)hashmap.get("other_reaction");
			//String severity=(String)hashmap.get("severity");
			String route_exp=(String)hashmap.get("route_exp");
			String cause_sub=(String)hashmap.get("cause_sub");
			String allergyAlertby=(String)hashmap.get("allergyAlertby");

			String react_values_main=(String)hashmap.get("react_values_main");

			String facilityId =(String)hashmap.get("facilityId");
			String modifiedById=(String)hashmap.get("modifiedById");
			String status1=(String)hashmap.get("status1");

			//String modify_date_time=(String)hashmap.get("modify_date_time");
			String err_remarks=(String)hashmap.get("err_remarks");

			String adv_event_srl_no=(String)hashmap.get("adv_event_srl_no");
			String adv_dtl_srl_num=(String)hashmap.get("adv_dtl_srl_num");
			//String diagnosis_code=(String)hashmap.get("diagnosis_code");
			String status_date=(String)hashmap.get("status_date");
			String drug_code=(String)hashmap.get("drug_code");
			//String severity_head = (String)hashmap.get("severity_head");
			String react_code_val=(String)hashmap.get("react_code_val");
			String other_reaction_main=(String)hashmap.get("other_reaction_main");
			//String evnt_dtl_modified_yn=(String)hashmap.get("evnt_dtl_modified_yn");
			String reac_desc_val=(String)hashmap.get("reac_desc_val");
			String otherAllergenFreeTxt = (String)hashmap.get("otherAllergenFreeTxt");//Added by Thamizh selvi on 21st Dec 2017 against ML-MMOH-CRF-0751


String reaction_date_one="";
String severity_one="";
String site_of_reac_one="";
String reaction_val_sep="";

String reaction_date_oth="";
String reaction_code_oth="";
String severity_oth="";
String site_of_reac_oth="";

int result_oth=0;
			
			StringBuffer sql_update=new StringBuffer("");
			addedById=modifiedById;
			addedFacilityId=facilityId;
			modifiedFacilityId=facilityId;
			String modifiedAtWorkstation=(String)hashmap.get("modifiedAtWorkstation");
			addedAtWorkstation=modifiedAtWorkstation;
			if((!status1.equals("A")))
			{
				
				try
				{
					 sql_update.append("Update PR_ALLERGY_SENSITIVITY set STATUS=?,ERROR_REMARK=?,CERTAINTY=?");
					 if(status1.equals("R"))
					{
						sql_update.append(", RESOLVED_DATE=to_date('"+status_date+"','dd/mm/yyyy')");
					}else if(status1.equals("E"))
					{
						sql_update.append(", INERROR_DATE=to_date('"+status_date+"','dd/mm/yyyy')");
					}
					//sql_update.append("where PATIENT_ID=? and ADV_EVENT_TYPE_IND=? and ADV_EVENT_TYPE=? and ALLERGEN_CODE=? and ADV_EVENT_SRL_NO=?");
					sql_update.append(",modified_by_id = ?,modified_at_ws_no = ?, modified_date = sysdate , MODIFIED_FACILITY_ID = ?  where PATIENT_ID=? and ADV_EVENT_TYPE_IND=? and ADV_EVENT_TYPE=? and ALLERGEN_CODE=? and ADV_EVENT_SRL_NO=?");
					pstmt = con.prepareStatement(sql_update.toString());
				
					pstmt.setString(1,status1);
				
				
					//pstmt.setString(1,"E");//
				
					pstmt.setString(2,err_remarks);
					pstmt.setString(3,certainity);
					pstmt.setString(4,modifiedById);
					pstmt.setString(5,modifiedAtWorkstation);
					pstmt.setString(6,modifiedFacilityId);
					pstmt.setString(7,PatientId);
					pstmt.setString(8,adv_event_ind);
					pstmt.setString(9,adv_event_type);
					pstmt.setString(10,allergen);
					pstmt.setString(11,adv_event_srl_no);
					

					result1=pstmt.executeUpdate();
					if(pstmt != null) pstmt.close();

					if(result1 >0)
					{
						flag = true;
						//insertAdveEvent_two( properties, hashmap);
					}else{
						flag = false;
					}
				
				}
				catch (Exception ep)
				{
					ep.printStackTrace();
				}

				

				//10/15/2009  IN015364(SRR20056-SCF-3695)
				// Allergy marked error or resolved update mp_patient
					
					int active_allergy_cnt= 0;
				try
				{
					String allergy_cnt="SELECT Count(*) FROM pr_allergy_sensitivity WHERE patient_id='"+PatientId+"' and STATUS ='A'";
					rs=stmt.executeQuery(allergy_cnt);
					if(rs !=null && rs.next())
					{
						active_allergy_cnt =rs.getInt(1);
					}

					if(rs != null) rs.close();
					if(active_allergy_cnt == 0)
					{
						//String mp_allergy = "update mp_patient set known_allergy_yn='N',modified_by_id = ?,modified_at_ws_no = ?, modified_date = sysdate  where  patient_id = ?";

						/*Wednesday, March 02, 2011 , SRR20056-SCF-7005 [IN:026717]*/
						String mp_allergy = "update mp_patient set known_allergy_yn='N',modified_by_id=?,modified_date=sysdate,modified_at_ws_no=?,modified_facility_id=? where  patient_id = ?";
						pstmt = con.prepareStatement(mp_allergy);
						//pstmt.setString(1,no_known_allergy);
						pstmt.setString(1,modifiedById);
						pstmt.setString(2,modifiedAtWorkstation);
						pstmt.setString(3,modifiedFacilityId);
						pstmt.setString(4,PatientId);
						int allergy_known=pstmt.executeUpdate();


						if(allergy_known!=0)
						{		
							flag = true;

						}
						else
						{
							flag = false;
						}

						if(pstmt != null) pstmt.close();
					}
				}
				catch (Exception ec)
				{
					ec.printStackTrace();
				}
					


				//10/26/2008 if reac_desc_val value is blank no realction selcted		
			 if(!reac_desc_val.equals(""))
			{
				 /*10/15/2008  0083*/
				 try
				 {
					java.lang.StringBuffer sql_insert_pr_adverse_event_dtl=new java.lang.StringBuffer("");
					 sql_insert_pr_adverse_event_dtl.append("insert into PR_ADVERSE_EVENT (PATIENT_ID, ADV_EVENT_TYPE_IND,ALLERGY_ALERT_BY,ADV_EVENT_TYPE, ALLERGEN_CODE, ADV_EVENT_SRL_NO, ADV_EVENT_DTL_SRL_NO, ROUTE_OF_EXPOSURE, INFORMATION_SOURCE, ALLERGY_TEST_RESULT, TREATMENT_ADVICE, REMARKS, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID, OTHER_ALLERGEN");//Modified by Thamizh selvi on 21st Dec 2017 against ML-MMOH-CRF-0751
					 if(!adv_event_type.equals("DA"))
					{
					 sql_insert_pr_adverse_event_dtl.append(",CAUSATIVE_SUBSTANCE");
					}else
					{
						sql_insert_pr_adverse_event_dtl.append(",DRUG_CODE");
					}
					sql_insert_pr_adverse_event_dtl.append(") values (?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?");//Modified by Thamizh selvi on 21st Dec 2017 against ML-MMOH-CRF-0751
					if(!adv_event_type.equals("DA"))
					{
					sql_insert_pr_adverse_event_dtl.append(",'"+cause_sub+"'");
					}else
					{
						sql_insert_pr_adverse_event_dtl.append(",'"+drug_code+"'");
					}
					sql_insert_pr_adverse_event_dtl.append(")") ;
					pstmt1 = con.prepareStatement(sql_insert_pr_adverse_event_dtl.toString());
							pstmt1.setString(1, PatientId);
							pstmt1.setString(2, adv_event_ind);
							pstmt1.setString(3, allergyAlertby);
							pstmt1.setString(4, adv_event_type);
							pstmt1.setString(5, allergen);
							pstmt1.setString(6, adv_event_srl_no);
							pstmt1.setString(7, adv_dtl_srl_num);
							pstmt1.setString(8, route_exp);
							pstmt1.setString(9, sou_of_info);
							pstmt1.setString(10, allergy_test_res );
							pstmt1.setString(11, treat_advice);
							pstmt1.setString(12, remarks);
							pstmt1.setString(13, addedById);
							pstmt1.setString(14, addedAtWorkstation);
							pstmt1.setString(15, addedFacilityId);
							pstmt1.setString(16, modifiedById);
							pstmt1.setString(17, modifiedAtWorkstation);
							pstmt1.setString(18, modifiedFacilityId);
							pstmt1.setString(19, otherAllergenFreeTxt);//Added by Thamizh selvi on 21st Dec 2017 against ML-MMOH-CRF-0751

							result2 = pstmt1.executeUpdate();
							
							if(result2 > 0)
							{
								flag = true;
							}else {
								flag = false;
							}
							if(pstmt1 !=null) pstmt1.close();
				 }
				 catch (Exception epr)
				 {
					 epr.printStackTrace();
				 }
			 
					
					if(!other_reaction_main.equals(""))
				{

					StringTokenizer token2 = new StringTokenizer(other_reaction_main, "@");
					String oth_reaction_val_sep = "";

					while (token2.hasMoreTokens())
					{
						oth_reaction_val_sep=token2.nextToken();

						StringTokenizer token1 = new StringTokenizer(oth_reaction_val_sep, "`");

						while (token1.hasMoreTokens() && flag)
						{
							reaction_date_oth =token1.nextToken();
							reaction_code_oth     =token1.nextToken();
							severity_oth      =token1.nextToken();
							site_of_reac_oth  =token1.nextToken();

							if(severity_oth.equals("$")) severity_oth="";
							if(site_of_reac_oth.equals("$")) site_of_reac_oth="";		
					

					

				
							reaction_code="Oth";
			
						sql_srl_num_three_oth="select nvl(max(adv_event_rxn_srl_no),0)+1 adv_event_rxn_srl_no from PR_ADVERSE_EVENT_REACTION where  PATIENT_ID='"+PatientId+"' and ADV_EVENT_TYPE_IND='"+adv_event_ind+"' and ADV_EVENT_TYPE ='"+adv_event_type+"' and ALLERGEN_CODE='"+allergen+"'";
								rs=stmt.executeQuery(sql_srl_num_three_oth);
						if(rs !=null && rs.next())
						{
						adv_event_reac_srl_no =rs.getString("adv_event_rxn_srl_no");
						if(adv_event_reac_srl_no ==null) adv_event_reac_srl_no="";
						}

						if(rs != null) rs.close();
						try
						{
							sql_insert_pr_adverse_event_reaction_oth="insert into PR_ADVERSE_EVENT_REACTION (PATIENT_ID, ADV_EVENT_TYPE_IND, ADV_EVENT_TYPE, ALLERGEN_CODE, ADV_EVENT_SRL_NO,ADV_EVENT_DTL_SRL_NO, ADV_EVENT_RXN_SRL_NO, ADV_REAC_CODE,SEVERITY, REACTION_DATE, OTHERS_REACTION, REACTION_SITE,ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,OTHER_ALLERGEN)values(?,?,?,?,?,?,?,?,?,to_date('"+reaction_date_oth+"','dd/mm/yyyy hh24:mi'),?,?,?,sysdate,?,?,?,sysdate,?,?,?)";//Modified by Thamizh selvi on 21st Dec 2017 against ML-MMOH-CRF-0751
							pstmt3 = con.prepareStatement(sql_insert_pr_adverse_event_reaction_oth);


							pstmt3.setString(1, PatientId);
							pstmt3.setString(2, adv_event_ind);
							pstmt3.setString(3, adv_event_type);
							pstmt3.setString(4, allergen);
							pstmt3.setString(5, adv_event_srl_no);
							pstmt3.setString(6, adv_dtl_srl_num);
							pstmt3.setString(7, adv_event_reac_srl_no);
							pstmt3.setString(8, reaction_code);
							pstmt3.setString(9, severity_oth);
							//pstmt3.setString(10, );
							pstmt3.setString(10, reaction_code_oth);
							pstmt3.setString(11, site_of_reac_oth);
							pstmt3.setString(12, addedById );
							pstmt3.setString(13, addedAtWorkstation);
							pstmt3.setString(14, addedFacilityId);
							pstmt3.setString(15, modifiedById);
							pstmt3.setString(16, modifiedAtWorkstation );
							pstmt3.setString(17, modifiedFacilityId);
							pstmt3.setString(18, otherAllergenFreeTxt);//Added by Thamizh selvi on 21st Dec 2017 against ML-MMOH-CRF-0751

							result_oth = pstmt3.executeUpdate();
							

								if(result_oth > 0)
								{
									flag = true;
								}
								else
								{
									flag = false;
								}
							}
							catch (Exception eq)
							{
								eq.printStackTrace();
							}
							
						}
						
						
					}

					
				}
				else
				{
						result_oth=1;
				}


if(result_oth == 1 && flag)
		{

			StringTokenizer token = new StringTokenizer(react_values_main, "@");

			while (token.hasMoreTokens())
			 {
				reaction_val_sep=token.nextToken();

				StringTokenizer token1 = new StringTokenizer(reaction_val_sep, "`");

			while (token1.hasMoreTokens())
			 {

				reaction_date_one=token1.nextToken();
			    reaction_code=token1.nextToken();
				severity_one=token1.nextToken();
				site_of_reac_one=token1.nextToken();


				if(severity_one.equals("$")) severity_one="";
				if(site_of_reac_one.equals("$")) site_of_reac_one="";



			    sql_srl_num_three="select nvl(max(adv_event_rxn_srl_no),0)+1 adv_event_rxn_srl_no from PR_ADVERSE_EVENT_REACTION where  PATIENT_ID='"+PatientId+"' and ADV_EVENT_TYPE_IND='"+adv_event_ind+"' and ADV_EVENT_TYPE ='"+adv_event_type+"' and ALLERGEN_CODE='"+allergen+"'";
						rs=stmt.executeQuery(sql_srl_num_three);
						if(rs !=null && rs.next())
						{
						adv_event_reac_srl_no =rs.getString("adv_event_rxn_srl_no");
						if(adv_event_reac_srl_no ==null) adv_event_reac_srl_no="";
						}

				if(rs != null) rs.close();
				
				try
				{
					sql_insert_pr_adverse_event_reaction="insert into PR_ADVERSE_EVENT_REACTION (PATIENT_ID, ADV_EVENT_TYPE_IND, ADV_EVENT_TYPE, ALLERGEN_CODE, ADV_EVENT_SRL_NO,ADV_EVENT_DTL_SRL_NO, ADV_EVENT_RXN_SRL_NO, ADV_REAC_CODE,SEVERITY, REACTION_DATE, OTHERS_REACTION, REACTION_SITE,ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,OTHER_ALLERGEN)values(?,?,?,?,?,?,?,?,?,to_date('"+reaction_date_one+"','dd/mm/yyyy hh24:mi'),?,?,?,sysdate,?,?,?,sysdate,?,?,?)";//Modified by Thamizh selvi on 21st Dec 2017 against ML-MMOH-CRF-0751
					pstmt2 = con.prepareStatement(sql_insert_pr_adverse_event_reaction);


					pstmt2.setString(1, PatientId);
					pstmt2.setString(2, adv_event_ind);
					pstmt2.setString(3, adv_event_type);
					pstmt2.setString(4, allergen);
					pstmt2.setString(5, adv_event_srl_no);
					pstmt2.setString(6, adv_dtl_srl_num);
					pstmt2.setString(7, adv_event_reac_srl_no);
					pstmt2.setString(8, reaction_code);
					pstmt2.setString(9, severity_one);
					//pstmt2.setString(10, );
					pstmt2.setString(10, "");
					pstmt2.setString(11, site_of_reac_one);
					pstmt2.setString(12, addedById );
					pstmt2.setString(13, addedAtWorkstation);
					pstmt2.setString(14, addedFacilityId);
					pstmt2.setString(15, modifiedById);
					pstmt2.setString(16, modifiedAtWorkstation );
					pstmt2.setString(17, modifiedFacilityId);
					pstmt2.setString(18, otherAllergenFreeTxt);//Added by Thamizh selvi on 21st Dec 2017 against ML-MMOH-CRF-0751
					
					result3 = pstmt2.executeUpdate();
					

					if(pstmt2 !=null) pstmt2.close();

					if(result3 > 0)
					{
						flag = true;
					}else{
						flag = false;
					}
				}
				catch (Exception et)
				{
					et.printStackTrace();
				}
				

			}
			 }//end of while
		}
			}//10/26/2008 if reac_desc_val value is blank no realction selcted		
		/*10/15/2008  0083*/
		 }else
		 {

			try
			{
				String sql_update_one="Update PR_ALLERGY_SENSITIVITY set SEVERITY=? ,REACTION_CODE_VALUES=?,CERTAINTY='"+certainity+"' ,modified_by_id = ?,modified_at_ws_no = ?, modified_date = sysdate,MODIFIED_FACILITY_ID = ? Where ACTIVE_DATE=to_date('"+status_date+"','dd/mm/yyyy') and PATIENT_ID=? and ADV_EVENT_TYPE_IND=? and ADV_EVENT_TYPE=? and ALLERGEN_CODE=? and ADV_EVENT_SRL_NO=?";

				pstmt = con.prepareStatement(sql_update_one);
				//pstmt.setString(1,severity_head);
				pstmt.setString(1,"");
				pstmt.setString(2,react_code_val);
				pstmt.setString(3,modifiedById);
				pstmt.setString(4,modifiedAtWorkstation);
				pstmt.setString(5,modifiedFacilityId);
				pstmt.setString(6,PatientId);
				pstmt.setString(7,adv_event_ind);
				pstmt.setString(8,adv_event_type);
				pstmt.setString(9,allergen);
				pstmt.setString(10,adv_event_srl_no);
		
		
				result1=pstmt.executeUpdate();
				if(pstmt != null) pstmt.close();
			}
			catch (Exception eu)
			{
				eu.printStackTrace();
			}

			
		// 11/13/2008
		 if(!reac_desc_val.equals(""))
			{
			 

					try
					{
						java.lang.StringBuffer sql_insert_pr_adverse_event_dtl=new java.lang.StringBuffer("");
						 sql_insert_pr_adverse_event_dtl.append("insert into PR_ADVERSE_EVENT (PATIENT_ID, ADV_EVENT_TYPE_IND,ALLERGY_ALERT_BY, ADV_EVENT_TYPE, ALLERGEN_CODE, ADV_EVENT_SRL_NO, ADV_EVENT_DTL_SRL_NO, ROUTE_OF_EXPOSURE, INFORMATION_SOURCE, ALLERGY_TEST_RESULT, TREATMENT_ADVICE, REMARKS, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID, OTHER_ALLERGEN");//Modified by Thamizh selvi on 15th Jan 2018 against ML-MMOH-CRF-0751
						 if(!adv_event_type.equals("DA"))
						{
						 sql_insert_pr_adverse_event_dtl.append(",CAUSATIVE_SUBSTANCE");
						}else
						{
							sql_insert_pr_adverse_event_dtl.append(",DRUG_CODE");
						}
						sql_insert_pr_adverse_event_dtl.append(") values (?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?");
						if(!adv_event_type.equals("DA"))
						{
						sql_insert_pr_adverse_event_dtl.append(",'"+cause_sub+"'");
						}else
						{
							sql_insert_pr_adverse_event_dtl.append(",'"+drug_code+"'");
						}
						sql_insert_pr_adverse_event_dtl.append(")") ;
						pstmt1 = con.prepareStatement(sql_insert_pr_adverse_event_dtl.toString());
								pstmt1.setString(1, PatientId);
								pstmt1.setString(2, adv_event_ind);
								pstmt1.setString(3, allergyAlertby);
								pstmt1.setString(4, adv_event_type);
								pstmt1.setString(5, allergen);
								pstmt1.setString(6, adv_event_srl_no);
								pstmt1.setString(7, adv_dtl_srl_num);
								pstmt1.setString(8, route_exp);
								pstmt1.setString(9, sou_of_info);
								pstmt1.setString(10, allergy_test_res );
								pstmt1.setString(11, treat_advice);
								pstmt1.setString(12, remarks);
								pstmt1.setString(13, addedById);
								pstmt1.setString(14, addedAtWorkstation);
								pstmt1.setString(15, addedFacilityId);
								pstmt1.setString(16, modifiedById);
								pstmt1.setString(17, modifiedAtWorkstation);
								pstmt1.setString(18, modifiedFacilityId);
								pstmt1.setString(19, otherAllergenFreeTxt);//Added by Thamizh selvi on 15th Jan 2018 against ML-MMOH-CRF-0751
								
								result2 = pstmt1.executeUpdate();
								
								if(result2 > 0)
								{
									flag = true;
								}else {
									flag = false;
								}
						if(pstmt1 !=null) pstmt1.close();
					}
					catch (Exception et)
					{
						et.printStackTrace();
					}
				
				 
				 
			/*	 StringTokenizer token = new StringTokenizer(react_values_main, "@");
					while (token.hasMoreTokens())
					{
						reaction_code=token.nextToken();
						sql_srl_num_three="select nvl(max(adv_event_rxn_srl_no),0)+1 adv_event_rxn_srl_no from PR_ADVERSE_EVENT_REACTION where  PATIENT_ID='"+PatientId+"' and ADV_EVENT_TYPE_IND='"+adv_event_ind+"' and ADV_EVENT_TYPE ='"+adv_event_type+"' and ALLERGEN_CODE='"+allergen+"'";
						rs=stmt.executeQuery(sql_srl_num_three);
						if(rs !=null && rs.next())
						{
						adv_event_reac_srl_no =rs.getString("adv_event_rxn_srl_no");
						if(adv_event_reac_srl_no ==null) adv_event_reac_srl_no="";
						}
				
				/*		sql_insert_pr_adverse_event_reaction="insert into PR_ADVERSE_EVENT_REACTION (PATIENT_ID, ADV_EVENT_TYPE_IND, ADV_EVENT_TYPE, ALLERGEN_CODE, ADV_EVENT_SRL_NO,ADV_EVENT_DTL_SRL_NO, ADV_EVENT_RXN_SRL_NO, ADV_REAC_CODE,SEVERITY, REACTION_DATE, OTHERS_REACTION, REACTION_SITE,ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID)values('"+PatientId+"','"+adv_event_ind+"','"+adv_event_type+"','"+allergen+"','"+adv_event_srl_no+"','"+adv_dtl_srl_num+"','"+adv_event_reac_srl_no+"','"+reaction_code+"','"++"','"++"','"++"','"++"','"+addedById+"',sysdate,'"+addedAtWorkstation+"','"+addedFacilityId+"','"+modifiedById+"',sysdate,'"+modifiedAtWorkstation+"','"+modifiedFacilityId+"')";
						pstmt2 = con.prepareStatement(sql_insert_pr_adverse_event_reaction);
						result3 = pstmt2.executeUpdate();


	/*					if(result3 > 0)
						{
							flag = true;
						}else {
							flag = false;
						}
					}//end of while  
			}   */




		


			/*	if(!other_reaction_main.equals(""))
				{

					StringTokenizer token2 = new StringTokenizer(other_reaction_main, "*");
					
					reaction_date_oth=token2.nextToken();
					 reaction_code_oth=token2.nextToken();
					severity_oth=token2.nextToken();
					site_of_reac_oth=token2.nextToken();

					if(severity_oth.equals("$")) severity_oth="";
					if(site_of_reac_oth.equals("$")) site_of_reac_oth="";

				
				reaction_code="Oth";
			
				sql_srl_num_three_oth="select nvl(max(adv_event_rxn_srl_no),0)+1 adv_event_rxn_srl_no from PR_ADVERSE_EVENT_REACTION where  PATIENT_ID='"+PatientId+"' and ADV_EVENT_TYPE_IND='"+adv_event_ind+"' and ADV_EVENT_TYPE ='"+adv_event_type+"' and ALLERGEN_CODE='"+allergen+"'";
						rs=stmt.executeQuery(sql_srl_num_three_oth);
						if(rs !=null && rs.next())
						{
						adv_event_reac_srl_no =rs.getString("adv_event_rxn_srl_no");
						if(adv_event_reac_srl_no ==null) adv_event_reac_srl_no="";
						}

				if(rs != null) rs.close();

				sql_insert_pr_adverse_event_reaction_oth="insert into PR_ADVERSE_EVENT_REACTION (PATIENT_ID, ADV_EVENT_TYPE_IND, ADV_EVENT_TYPE, ALLERGEN_CODE, ADV_EVENT_SRL_NO,ADV_EVENT_DTL_SRL_NO, ADV_EVENT_RXN_SRL_NO, ADV_REAC_CODE,SEVERITY, REACTION_DATE, OTHERS_REACTION, REACTION_SITE,ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID)values(?,?,?,?,?,?,?,?,?,to_date('"+reaction_date_oth+"','dd/mm/yyyy hh24:mi'),?,?,?,sysdate,?,?,?,sysdate,?,?)";
				pstmt3 = con.prepareStatement(sql_insert_pr_adverse_event_reaction_oth);


					pstmt3.setString(1, PatientId);
					pstmt3.setString(2, adv_event_ind);
					pstmt3.setString(3, adv_event_type);
					pstmt3.setString(4, allergen);
					pstmt3.setString(5, adv_event_srl_no);
					pstmt3.setString(6, adv_dtl_srl_num);
					pstmt3.setString(7, adv_event_reac_srl_no);
					pstmt3.setString(8, reaction_code);
					pstmt3.setString(9, severity_oth);
					//pstmt3.setString(10, );
					pstmt3.setString(10, reaction_code_oth);
					pstmt3.setString(11, site_of_reac_oth);
					pstmt3.setString(12, addedById );
					pstmt3.setString(13, addedAtWorkstation);
					pstmt3.setString(14, addedFacilityId);
					pstmt3.setString(15, modifiedById);
					pstmt3.setString(16, modifiedAtWorkstation );
					pstmt3.setString(17, modifiedFacilityId);
					result_oth = pstmt3.executeUpdate();

					if(result_oth > 0)
					{
						flag = true;
					}else{
						flag = false;
					}

					
				}else
				{
						result_oth=1;
				}*/

				if(!other_reaction_main.equals(""))
				{

					StringTokenizer token2 = new StringTokenizer(other_reaction_main, "@");
					String oth_reaction_val_sep = "";

					while (token2.hasMoreTokens())
					{
						oth_reaction_val_sep=token2.nextToken();

						StringTokenizer token1 = new StringTokenizer(oth_reaction_val_sep, "`");

						while (token1.hasMoreTokens() && flag)
						{
							reaction_date_oth =token1.nextToken();
							reaction_code_oth     =token1.nextToken();
							severity_oth      =token1.nextToken();
							site_of_reac_oth  =token1.nextToken();

							if(severity_oth.equals("$")) severity_oth="";
							if(site_of_reac_oth.equals("$")) site_of_reac_oth="";		
					

					

				
							reaction_code="Oth";
			
						sql_srl_num_three_oth="select nvl(max(adv_event_rxn_srl_no),0)+1 adv_event_rxn_srl_no from PR_ADVERSE_EVENT_REACTION where  PATIENT_ID='"+PatientId+"' and ADV_EVENT_TYPE_IND='"+adv_event_ind+"' and ADV_EVENT_TYPE ='"+adv_event_type+"' and ALLERGEN_CODE='"+allergen+"'";
								rs=stmt.executeQuery(sql_srl_num_three_oth);
						if(rs !=null && rs.next())
						{
						adv_event_reac_srl_no =rs.getString("adv_event_rxn_srl_no");
						if(adv_event_reac_srl_no ==null) adv_event_reac_srl_no="";
						}

						if(rs != null) rs.close();

						
							try
							{
								sql_insert_pr_adverse_event_reaction_oth="insert into PR_ADVERSE_EVENT_REACTION (PATIENT_ID, ADV_EVENT_TYPE_IND, ADV_EVENT_TYPE, ALLERGEN_CODE, ADV_EVENT_SRL_NO,ADV_EVENT_DTL_SRL_NO, ADV_EVENT_RXN_SRL_NO, ADV_REAC_CODE,SEVERITY, REACTION_DATE, OTHERS_REACTION, REACTION_SITE,ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,OTHER_ALLERGEN)values(?,?,?,?,?,?,?,?,?,to_date('"+reaction_date_oth+"','dd/mm/yyyy hh24:mi'),?,?,?,sysdate,?,?,?,sysdate,?,?,?)";//Modified by Thamizh selvi on 15th Jan 2018 against ML-MMOH-CRF-0751
									pstmt3 = con.prepareStatement(sql_insert_pr_adverse_event_reaction_oth);


									pstmt3.setString(1, PatientId);
									pstmt3.setString(2, adv_event_ind);
									pstmt3.setString(3, adv_event_type);
									pstmt3.setString(4, allergen);
									pstmt3.setString(5, adv_event_srl_no);
									pstmt3.setString(6, adv_dtl_srl_num);
									pstmt3.setString(7, adv_event_reac_srl_no);
									pstmt3.setString(8, reaction_code);
									pstmt3.setString(9, severity_oth);
									//pstmt3.setString(10, );
									pstmt3.setString(10, reaction_code_oth);
									pstmt3.setString(11, site_of_reac_oth);
									pstmt3.setString(12, addedById );
									pstmt3.setString(13, addedAtWorkstation);
									pstmt3.setString(14, addedFacilityId);
									pstmt3.setString(15, modifiedById);
									pstmt3.setString(16, modifiedAtWorkstation );
									pstmt3.setString(17, modifiedFacilityId);
									pstmt3.setString(18, otherAllergenFreeTxt);//Added by Thamizh selvi on 15th Jan 2018 against ML-MMOH-CRF-0751
									
									result_oth = pstmt3.executeUpdate();
									

										if(result_oth > 0)
										{
											flag = true;
										}
										else
										{
											flag = false;
										}
							}
							catch (Exception Er)
							{
								Er.printStackTrace();
							}
							
						}
					}

					
				}else
				{
						result_oth=1;
				}

if(result_oth == 1 && flag)
		{

			StringTokenizer token = new StringTokenizer(react_values_main, "@");

			while (token.hasMoreTokens())
			 {
				reaction_val_sep=token.nextToken();

				StringTokenizer token1 = new StringTokenizer(reaction_val_sep, "`");

			while (token1.hasMoreTokens())
			 {

				reaction_date_one=token1.nextToken();
			    reaction_code=token1.nextToken();
				severity_one=token1.nextToken();
				site_of_reac_one=token1.nextToken();


				if(severity_one.equals("$")) severity_one="";
				if(site_of_reac_one.equals("$")) site_of_reac_one="";



			    sql_srl_num_three="select nvl(max(adv_event_rxn_srl_no),0)+1 adv_event_rxn_srl_no from PR_ADVERSE_EVENT_REACTION where  PATIENT_ID='"+PatientId+"' and ADV_EVENT_TYPE_IND='"+adv_event_ind+"' and ADV_EVENT_TYPE ='"+adv_event_type+"' and ALLERGEN_CODE='"+allergen+"'";
						rs=stmt.executeQuery(sql_srl_num_three);
						if(rs !=null && rs.next())
						{
						adv_event_reac_srl_no =rs.getString("adv_event_rxn_srl_no");
						if(adv_event_reac_srl_no ==null) adv_event_reac_srl_no="";
						}

				if(rs != null) rs.close();
				
				try
					{
						sql_insert_pr_adverse_event_reaction="insert into PR_ADVERSE_EVENT_REACTION (PATIENT_ID, ADV_EVENT_TYPE_IND, ADV_EVENT_TYPE, ALLERGEN_CODE, ADV_EVENT_SRL_NO,ADV_EVENT_DTL_SRL_NO, ADV_EVENT_RXN_SRL_NO, ADV_REAC_CODE,SEVERITY, REACTION_DATE, OTHERS_REACTION, REACTION_SITE,ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID, OTHER_ALLERGEN)values(?,?,?,?,?,?,?,?,?,to_date('"+reaction_date_one+"','dd/mm/yyyy hh24:mi'),?,?,?,sysdate,?,?,?,sysdate,?,?,?)";//Modified by Thamizh selvi on 15th Jan 2018 against ML-MMOH-CRF-0751
					pstmt2 = con.prepareStatement(sql_insert_pr_adverse_event_reaction);


						pstmt2.setString(1, PatientId);
						pstmt2.setString(2, adv_event_ind);
						pstmt2.setString(3, adv_event_type);
						pstmt2.setString(4, allergen);
						pstmt2.setString(5, adv_event_srl_no);
						pstmt2.setString(6, adv_dtl_srl_num);
						pstmt2.setString(7, adv_event_reac_srl_no);
						pstmt2.setString(8, reaction_code);
						pstmt2.setString(9, severity_one);
						//pstmt2.setString(10, );
						pstmt2.setString(10, "");
						pstmt2.setString(11, site_of_reac_one);
						pstmt2.setString(12, addedById );
						pstmt2.setString(13, addedAtWorkstation);
						pstmt2.setString(14, addedFacilityId);
						pstmt2.setString(15, modifiedById);
						pstmt2.setString(16, modifiedAtWorkstation );
						pstmt2.setString(17, modifiedFacilityId);
						pstmt2.setString(18, otherAllergenFreeTxt);//Added by Thamizh selvi on 15th Jan 2018 against ML-MMOH-CRF-0751

						result3 = pstmt2.executeUpdate();
						
						

						if(pstmt2 !=null) pstmt2.close();

						if(result3 > 0)
						{
							flag = true;
						}else{
							flag = false;
						}
					}
					catch (Exception Ex)
					{
						Ex.printStackTrace();
					}
					
			}
			 }//end of while
		}
	}else{
		
				try
				{
					 java.lang.StringBuffer sql_insert_pr_adverse_event_dtl=new java.lang.StringBuffer("");
			 sql_insert_pr_adverse_event_dtl.append("insert into PR_ADVERSE_EVENT (PATIENT_ID, ADV_EVENT_TYPE_IND,ALLERGY_ALERT_BY, ADV_EVENT_TYPE, ALLERGEN_CODE, ADV_EVENT_SRL_NO, ADV_EVENT_DTL_SRL_NO, ROUTE_OF_EXPOSURE, INFORMATION_SOURCE, ALLERGY_TEST_RESULT, TREATMENT_ADVICE, REMARKS, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID, OTHER_ALLERGEN");//Modified by Thamizh selvi on 15th Jan 2018 against ML-MMOH-CRF-0751

			 if(!adv_event_type.equals("DA"))
			{
			 sql_insert_pr_adverse_event_dtl.append(",CAUSATIVE_SUBSTANCE");
			}else
			{
				sql_insert_pr_adverse_event_dtl.append(",DRUG_CODE");
			}
			sql_insert_pr_adverse_event_dtl.append(") values (?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?");
			if(!adv_event_type.equals("DA"))
			{
			sql_insert_pr_adverse_event_dtl.append(",'"+cause_sub+"'");
			}else
			{
				sql_insert_pr_adverse_event_dtl.append(",'"+drug_code+"'");
			}
			sql_insert_pr_adverse_event_dtl.append(")") ;
			pstmt1 = con.prepareStatement(sql_insert_pr_adverse_event_dtl.toString());
					pstmt1.setString(1, PatientId);
                    pstmt1.setString(2, adv_event_ind);
                    pstmt1.setString(3, allergyAlertby);
                    pstmt1.setString(4, adv_event_type);
                    pstmt1.setString(5, allergen);
                    pstmt1.setString(6, adv_event_srl_no);
                    pstmt1.setString(7, adv_dtl_srl_num);
                    pstmt1.setString(8, route_exp);
                    pstmt1.setString(9, sou_of_info);
                    pstmt1.setString(10, allergy_test_res );
                    pstmt1.setString(11, treat_advice);
                    pstmt1.setString(12, remarks);
					pstmt1.setString(13, addedById);
                    pstmt1.setString(14, addedAtWorkstation);
                    pstmt1.setString(15, addedFacilityId);
                    pstmt1.setString(16, modifiedById);
					pstmt1.setString(17, modifiedAtWorkstation);
                    pstmt1.setString(18, modifiedFacilityId);
					pstmt1.setString(19, otherAllergenFreeTxt);//Added by Thamizh selvi on 15th Jan 2018 against ML-MMOH-CRF-0751
					
					result2 = pstmt1.executeUpdate();
					
					if(result2 > 0)
					{
						flag = true;
					}else {
						flag = false;
					}
				}
				catch (Exception Et)
				{
					Et.printStackTrace();
				}
	
	}//11/13/2008
}
		 if(flag)
			{
			 con.commit();
			
			}else{
			con.rollback();
			}
			
			if(pstmt1 !=null) pstmt1.close();
			if(pstmt2 !=null) pstmt2.close();
			 if(pstmt3 !=null) pstmt3.close();
			if(rs != null) rs.close();
			if(stmt !=null) stmt.close();
			boolean result=true;
			hashmap.clear();
			sql_update.setLength(0);
			results.put( "status", new Boolean(result) ) ;
	}catch (Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		if (con !=null)	ConnectionManager.returnConnection(con,properties);
	}
	 return results;
 }


	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
 public java.util.HashMap insertAdveEvent_two(Properties properties,HashMap hashmap,Connection con)
{
	  HashMap results	    = new HashMap();    
	  ResultSet rs=null;
	  Statement stmt=null;
	  PreparedStatement pstmt1=null,pstmt2=null,pstmt3=null;
		
	try
	{
			
		
			String addedById="",addedFacilityId="",addedAtWorkstation="", modifiedFacilityId="",occurance_srl_no="",sql_srl_num_two="",sql_srl_num_three="",sql_insert_pr_adverse_event_reaction="",reaction_code="",adv_event_dtl_srl_no="",sql_insert_pr_adverse_event_reaction_oth="",sql_srl_num_three_oth="";
			// String status_val=""
			boolean result=true;
			boolean flag=true;
			int result2=0,result3=0;
			properties = (Properties)hashmap.get("p");
			//con = ConnectionManager.getConnection(properties);
            //con.setAutoCommit(false);
			stmt=con.createStatement();
			String	PatientId =(String)hashmap.get("PatientId");
			String adv_event_ind = (String)hashmap.get("adv_event_ind");
            String adv_event_type = (String)hashmap.get("adv_event_type");
            String allergen = (String)hashmap.get("allergen");
			String cause_sub=(String)hashmap.get("cause_sub");
			String allergyAlertby=(String)hashmap.get("allergyAlertby");
			
		    String route_exp=(String)hashmap.get("route_exp");
            //String severity=(String)hashmap.get("severity");
			//String reaction_date=(String)hashmap.get("reaction_date");
			//String other_reaction=(String)hashmap.get("other_reaction");
			//String Site_Of_Reac=(String)hashmap.get("Site_Of_Reac");
			String allergy_test_res=(String)hashmap.get("allergy_test_res");
			String treat_advice=(String)hashmap.get("treat_advice");
			String remarks=(String)hashmap.get("remarks");
			String sou_of_info=(String)hashmap.get("sou_of_info");
			String react_values_main=(String)hashmap.get("react_values_main");
			String facilityId =(String)hashmap.get("facilityId");
			String modifiedById=(String)hashmap.get("modifiedById");
			String adv_event_srl_no=(String)hashmap.get("adv_event_srl_no");
			String drug_code=(String)hashmap.get("drug_code");
			String other_reaction_main=(String)hashmap.get("other_reaction_main");
			//String status_date=(String)hashmap.get("status_date");

			String otherAllergenFreeTxt = (String)hashmap.get("otherAllergenFreeTxt");//Added by Thamizh selvi on 21st Dec 2017 against ML-MMOH-CRF-0751
			addedById=modifiedById;
			addedFacilityId=facilityId;
			modifiedFacilityId=facilityId;
			String modifiedAtWorkstation=(String)hashmap.get("modifiedAtWorkstation");
			addedAtWorkstation=modifiedAtWorkstation;
			//status_val="O";
			java.lang.StringBuffer sql_insert_pr_adverse_event_dtl=new java.lang.StringBuffer("");
			

			try
			{
				 sql_insert_pr_adverse_event_dtl.append("insert into PR_ADVERSE_EVENT (PATIENT_ID, ADV_EVENT_TYPE_IND,ALLERGY_ALERT_BY, ADV_EVENT_TYPE, ALLERGEN_CODE, ADV_EVENT_SRL_NO, ADV_EVENT_DTL_SRL_NO,  ROUTE_OF_EXPOSURE,  INFORMATION_SOURCE, ALLERGY_TEST_RESULT, TREATMENT_ADVICE, REMARKS, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,OTHER_ALLERGEN");//Modified by Thamizh selvi on 21st Dec 2017 against ML-MMOH-CRF-0751
				  
				   
				 if(!adv_event_type.equals("DA")) 
				{
				 sql_insert_pr_adverse_event_dtl.append(",CAUSATIVE_SUBSTANCE");
				}else
				{
					sql_insert_pr_adverse_event_dtl.append(",DRUG_CODE");
				}
				sql_insert_pr_adverse_event_dtl.append(") values (?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?");

				if(!adv_event_type.equals("DA"))
				{
				cause_sub=cause_sub.replaceAll("'","`");
				sql_insert_pr_adverse_event_dtl.append(",'"+cause_sub+"'");
				}else
				{
					sql_insert_pr_adverse_event_dtl.append(",'"+drug_code+"'");
				}
				sql_insert_pr_adverse_event_dtl.append(")") ;
				pstmt1 = con.prepareStatement(sql_insert_pr_adverse_event_dtl.toString());

				
				
				sql_srl_num_two="select nvl(max(ADV_EVENT_DTL_SRL_NO),0)+1 ADV_EVENT_DTL_SRL_NO from PR_ADVERSE_EVENT where  PATIENT_ID='"+PatientId+"' and ADV_EVENT_TYPE_IND='"+adv_event_ind+"' and ADV_EVENT_TYPE ='"+adv_event_type+"' and ALLERGEN_CODE='"+allergen+"'";
				rs=stmt.executeQuery(sql_srl_num_two);
					if(rs !=null && rs.next())
					{
					   occurance_srl_no =rs.getString("ADV_EVENT_DTL_SRL_NO");
					   if(occurance_srl_no ==null) occurance_srl_no="";
					}
						pstmt1.setString(1, PatientId);
						
						pstmt1.setString(2, adv_event_ind);
						pstmt1.setString(3, allergyAlertby);
						pstmt1.setString(4, adv_event_type);
						pstmt1.setString(5, allergen);
						pstmt1.setString(6, adv_event_srl_no);
						pstmt1.setString(7, occurance_srl_no);
						pstmt1.setString(8, route_exp);
						pstmt1.setString(9, sou_of_info);
						pstmt1.setString(10, allergy_test_res );
						pstmt1.setString(11, treat_advice);
						pstmt1.setString(12, remarks);
						pstmt1.setString(13, addedById);
						pstmt1.setString(14, addedAtWorkstation);
						pstmt1.setString(15, addedFacilityId);
						pstmt1.setString(16, modifiedById);
						pstmt1.setString(17, modifiedAtWorkstation);
						pstmt1.setString(18, modifiedFacilityId);
						pstmt1.setString(19, otherAllergenFreeTxt);//Added by Thamizh selvi on 21st Dec 2017 against ML-MMOH-CRF-0751

						result2 = pstmt1.executeUpdate();
						if(result2 > 0)
						{
						flag = true;
						}else{
							flag = false;
						}
				if(rs !=null) rs.close();
			
			}
			catch (Exception Ex1)
			{
				Ex1.printStackTrace();
			}
String reaction_date_one="";
String severity_one="";
String site_of_reac_one="";
String reaction_val_sep="";

String reaction_date_oth="";
String reaction_code_oth="";
String severity_oth="";
String site_of_reac_oth="";


int result_oth=0;
				/*if(!other_reaction_main.equals(""))
				{

					StringTokenizer token2 = new StringTokenizer(other_reaction_main, "*");
					
					reaction_date_oth=token2.nextToken();
					reaction_code_oth=token2.nextToken();
					severity_oth=token2.nextToken();
					site_of_reac_oth=token2.nextToken();

					if(severity_oth.equals("$")) severity_oth="";
					if(site_of_reac_oth.equals("$")) site_of_reac_oth="";
		
				reaction_code="Oth";
			    sql_srl_num_three_oth="select nvl(max(adv_event_rxn_srl_no),0)+1 adv_event_rxn_srl_no from PR_ADVERSE_EVENT_REACTION where  PATIENT_ID='"+PatientId+"' and ADV_EVENT_TYPE_IND='"+adv_event_ind+"' and ADV_EVENT_TYPE ='"+adv_event_type+"' and ALLERGEN_CODE='"+allergen+"'";
				rs=stmt.executeQuery(sql_srl_num_three_oth);
				if(rs !=null && rs.next())
				{
					adv_event_dtl_srl_no =rs.getString("adv_event_rxn_srl_no");
					if(adv_event_dtl_srl_no ==null) adv_event_dtl_srl_no="";
				}

				if(rs != null) rs.close();

				sql_insert_pr_adverse_event_reaction_oth="insert into PR_ADVERSE_EVENT_REACTION (PATIENT_ID, ADV_EVENT_TYPE_IND, ADV_EVENT_TYPE, ALLERGEN_CODE, ADV_EVENT_SRL_NO,ADV_EVENT_DTL_SRL_NO, ADV_EVENT_RXN_SRL_NO, ADV_REAC_CODE,SEVERITY, REACTION_DATE, OTHERS_REACTION, REACTION_SITE,ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID)values(?,?,?,?,?,?,?,?,?,to_date('"+reaction_date_oth+"','dd/mm/yyyy hh24:mi'),?,?,?,sysdate,?,?,?,sysdate,?,?)";
				pstmt3 = con.prepareStatement(sql_insert_pr_adverse_event_reaction_oth);


					pstmt3.setString(1, PatientId);
					pstmt3.setString(2, adv_event_ind);
					pstmt3.setString(3, adv_event_type);
					pstmt3.setString(4, allergen);
					pstmt3.setString(5, adv_event_srl_no);
					pstmt3.setString(6, occurance_srl_no);
					pstmt3.setString(7, adv_event_dtl_srl_no);
					pstmt3.setString(8, reaction_code);
					pstmt3.setString(9, severity_oth);
					//pstmt3.setString(10, );
					pstmt3.setString(10, reaction_code_oth);
					pstmt3.setString(11, site_of_reac_oth);
					pstmt3.setString(12, addedById );
					pstmt3.setString(13, addedAtWorkstation);
					pstmt3.setString(14, addedFacilityId);
					pstmt3.setString(15, modifiedById);
					pstmt3.setString(16, modifiedAtWorkstation );
					pstmt3.setString(17, modifiedFacilityId);
					result_oth = pstmt3.executeUpdate();

					if(pstmt3 !=null) pstmt3.close();

					if(result_oth > 0)
					{
						flag = true;
					}else{
						flag = false;
					}

					
				}else
				{
						result_oth=1;
				}*/
				if(!other_reaction_main.equals(""))
				{
					

					StringTokenizer token2 = new StringTokenizer(other_reaction_main, "@");
					String oth_reaction_val_sep = "";

					while (token2.hasMoreTokens())
					{
						oth_reaction_val_sep=token2.nextToken();

						StringTokenizer token1 = new StringTokenizer(oth_reaction_val_sep, "`");

						while (token1.hasMoreTokens() && flag)
						{
							reaction_date_oth =token1.nextToken();
							reaction_code_oth     =token1.nextToken();
							severity_oth      =token1.nextToken();
							site_of_reac_oth  =token1.nextToken();

							if(severity_oth.equals("$")) severity_oth="";
							if(site_of_reac_oth.equals("$")) site_of_reac_oth="";					
											
						reaction_code="Oth";
						sql_srl_num_three_oth="select nvl(max(adv_event_rxn_srl_no),0)+1 adv_event_rxn_srl_no from PR_ADVERSE_EVENT_REACTION where  PATIENT_ID='"+PatientId+"' and ADV_EVENT_TYPE_IND='"+adv_event_ind+"' and ADV_EVENT_TYPE ='"+adv_event_type+"' and ALLERGEN_CODE='"+allergen+"'";
						rs=stmt.executeQuery(sql_srl_num_three_oth);
						if(rs !=null && rs.next())
						{
							adv_event_dtl_srl_no =rs.getString("adv_event_rxn_srl_no");
							if(adv_event_dtl_srl_no ==null) adv_event_dtl_srl_no="";
						}
						if(rs != null) rs.close();

						
							try
							{
								sql_insert_pr_adverse_event_reaction_oth="insert into PR_ADVERSE_EVENT_REACTION (PATIENT_ID, ADV_EVENT_TYPE_IND, ADV_EVENT_TYPE, ALLERGEN_CODE, ADV_EVENT_SRL_NO,ADV_EVENT_DTL_SRL_NO, ADV_EVENT_RXN_SRL_NO, ADV_REAC_CODE,SEVERITY, REACTION_DATE, OTHERS_REACTION, REACTION_SITE,ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,OTHER_ALLERGEN)values(?,?,?,?,?,?,?,?,?,to_date('"+reaction_date_oth+"','dd/mm/yyyy hh24:mi'),?,?,?,sysdate,?,?,?,sysdate,?,?,?)";//Modified by Thamizh selvi on 21st Dec 2017 against ML-MMOH-CRF-0751
								pstmt3 = con.prepareStatement(sql_insert_pr_adverse_event_reaction_oth);


								pstmt3.setString(1, PatientId);
								pstmt3.setString(2, adv_event_ind);
								pstmt3.setString(3, adv_event_type);
								pstmt3.setString(4, allergen);
								pstmt3.setString(5, adv_event_srl_no);
								pstmt3.setString(6, occurance_srl_no);
								pstmt3.setString(7, adv_event_dtl_srl_no);
								pstmt3.setString(8, reaction_code);
								pstmt3.setString(9, severity_oth);
								//pstmt3.setString(10, );
								pstmt3.setString(10, reaction_code_oth);
								pstmt3.setString(11, site_of_reac_oth);
								pstmt3.setString(12, addedById );
								pstmt3.setString(13, addedAtWorkstation);
								pstmt3.setString(14, addedFacilityId);
								pstmt3.setString(15, modifiedById);
								pstmt3.setString(16, modifiedAtWorkstation );
								pstmt3.setString(17, modifiedFacilityId);
								pstmt3.setString(18, otherAllergenFreeTxt);//Added by Thamizh selvi on 21st Dec 2017 against ML-MMOH-CRF-0751
								result_oth = pstmt3.executeUpdate();
								


								if(pstmt3 !=null) pstmt3.close();
								if(result_oth > 0)
								{
									flag = true;
								}else{
									flag = false;
								}
						
								
							}
							catch (Exception err)
							{
								err.printStackTrace();
							}
						}
					}

					
				}else
				{
						result_oth=1;
				}

if(result_oth == 1 && flag)
		{


			StringTokenizer token = new StringTokenizer(react_values_main, "@");
			while (token.hasMoreTokens())
			 {
				reaction_val_sep=token.nextToken();
				StringTokenizer token1 = new StringTokenizer(reaction_val_sep, "`");
			while (token1.hasMoreTokens())
			 {

				reaction_date_one=token1.nextToken();
			    reaction_code=token1.nextToken();
				severity_one=token1.nextToken();
				site_of_reac_one=token1.nextToken();

				if(severity_one.equals("$")) severity_one="";
				if(site_of_reac_one.equals("$")) site_of_reac_one="";

			    sql_srl_num_three="select nvl(max(adv_event_rxn_srl_no),0)+1 adv_event_rxn_srl_no from PR_ADVERSE_EVENT_REACTION where  PATIENT_ID='"+PatientId+"' and ADV_EVENT_TYPE_IND='"+adv_event_ind+"' and ADV_EVENT_TYPE ='"+adv_event_type+"' and ALLERGEN_CODE='"+allergen+"'";
				rs=stmt.executeQuery(sql_srl_num_three);
				if(rs !=null && rs.next())
				{
					adv_event_dtl_srl_no =rs.getString("adv_event_rxn_srl_no");
					if(adv_event_dtl_srl_no ==null) adv_event_dtl_srl_no="";
				}
				if(rs != null) rs.close();
				//sql_insert_pr_adverse_event_reaction="insert into PR_ADVERSE_EVENT_REACTION (PATIENT_ID, ADV_EVENT_TYPE_IND, ADV_EVENT_TYPE, ALLERGEN_CODE, ADV_EVENT_SRL_NO,ADV_EVENT_DTL_SRL_NO, ADV_EVENT_RXN_SRL_NO, ADV_REAC_CODE,SEVERITY, REACTION_DATE, OTHERS_REACTION, REACTION_SITE,ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID)values(?,?,?,?,?,?,?,?,?,to_date('"+reaction_date_one+"','dd/mm/yyyy hh24:mi'),?,?,?,sysdate,?,?,?,sysdate,?,?)";
				
					try
					{
						sql_insert_pr_adverse_event_reaction="insert into PR_ADVERSE_EVENT_REACTION (PATIENT_ID, ADV_EVENT_TYPE_IND, ADV_EVENT_TYPE, ALLERGEN_CODE, ADV_EVENT_SRL_NO,ADV_EVENT_DTL_SRL_NO, ADV_EVENT_RXN_SRL_NO, ADV_REAC_CODE,SEVERITY, REACTION_DATE, OTHERS_REACTION, REACTION_SITE,ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,OTHER_ALLERGEN)values(?,?,?,?,?,?,?,?,?,to_date('"+reaction_date_one+"','dd/mm/yyyy hh24:mi'),?,?,?,sysdate,?,?,?,sysdate,?,?,?)";//Modified by Thamizh selvi on 21st Dec 2017 against ML-MMOH-CRF-0751
						pstmt2 = con.prepareStatement(sql_insert_pr_adverse_event_reaction);


							pstmt2.setString(1, PatientId);
							pstmt2.setString(2, adv_event_ind);
							pstmt2.setString(3, adv_event_type);
							pstmt2.setString(4, allergen);
							pstmt2.setString(5, adv_event_srl_no);
							pstmt2.setString(6, occurance_srl_no);
							pstmt2.setString(7, adv_event_dtl_srl_no);
							pstmt2.setString(8, reaction_code);
							pstmt2.setString(9, severity_one);
							//pstmt2.setString(10, );
							pstmt2.setString(10, "");
							pstmt2.setString(11, site_of_reac_one);
							pstmt2.setString(12, addedById );
							pstmt2.setString(13, addedAtWorkstation);
							pstmt2.setString(14, addedFacilityId);
							pstmt2.setString(15, modifiedById);
							pstmt2.setString(16, modifiedAtWorkstation );
							pstmt2.setString(17, modifiedFacilityId);
							pstmt2.setString(18, otherAllergenFreeTxt);//Added by Thamizh selvi on 21st Dec 2017 against ML-MMOH-CRF-0751
							result3 = pstmt2.executeUpdate();

							if(pstmt2 !=null) pstmt2.close();
							if(result3 > 0)
							{
								flag = true;
							}else{
								flag = false;
							}
					}
					catch (Exception err1)
					{
						err1.printStackTrace();
					}
			}
			 }//end of while
		}

			if(flag)
			{
				con.commit();
				result=true;
			}else{
				result=false;
				con.rollback();
			}
			
			results.put( "status", new Boolean(result) ) ;
			results.put( "error", "1") ;
			 if(pstmt1 !=null) pstmt1.close();
			 if(pstmt2 !=null) pstmt2.close();
			
			 if(rs != null) rs.close();
			 if(stmt !=null) stmt.close();
			 hashmap.clear();
	}catch (Exception e)
	{
		e.printStackTrace();
	}
	finally{
		if(con !=null)	ConnectionManager.returnConnection(con,properties);
	}
	 return results;

}
 
 //Added the following method for the RUT-CRF - 0064
 public boolean insertAllergyConfirmationDetails(Properties properties,HashMap hashmap,Connection con ){
	 boolean flag=false;
	 try
		{
		 //con=ConnectionManager.getConnection(properties);
				 
		 PreparedStatement pstmt2=null;
		 ResultSet rs = null;
		 int srl_no=0;
		 int result3=0;
		 
		 String	 PatientId	= (String)hashmap.get("PatientId");
		String	 AllergyConfirmYN	= (String)hashmap.get("AllergyConfirmYN");//Added for the CRF RUT-CRF- 0064
		String	 allergy_conf_reqd_yn	= (String)hashmap.get("allergy_conf_reqd_yn");//Added for the CRF RUT-CRF-0064
		String facilityId	= (String)hashmap.get("facilityId");
		String modifiedById	= (String)hashmap.get("modifiedById");
		String modifiedAtWorkstation	= (String)hashmap.get("modifiedAtWorkstation");
		String Encounter_Id	= (String)hashmap.get("Encounter_Id");
		
		
		 String selectSql = "Select nvl(MAX(srl_no),0)+1 srl_no from MR_ALLERGY_CONFIRMATION where patient_id='"+PatientId+"' ";
		 pstmt2=con.prepareStatement(selectSql);
		 rs=pstmt2.executeQuery();
		 while(rs!=null && rs.next()){
			 srl_no=rs.getInt(1);
		 }
		 if(rs!=null) rs.close();
		 if(pstmt2!=null) pstmt2.close();
		 
		 String insertSql="";
		 insertSql="insert into MR_ALLERGY_CONFIRMATION (PATIENT_ID, ALLERGY_CONFIRM_YN, ONSET_FACILITY_ID, ONSET_ENCOUNTER_ID, " +
					"SRL_NO,ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID)" +
					"values(?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?)";
			pstmt2 = con.prepareStatement(insertSql);

			
			
				pstmt2.setString(1, PatientId);
				pstmt2.setString(2, AllergyConfirmYN);
				pstmt2.setString(3, facilityId);
				pstmt2.setString(4, Encounter_Id);
				pstmt2.setInt(5, srl_no);
				pstmt2.setString(6, modifiedById);
				
								
				pstmt2.setString(7, modifiedAtWorkstation);
				pstmt2.setString(8, facilityId);
				pstmt2.setString(9, modifiedById);
				pstmt2.setString(10, modifiedAtWorkstation );
				pstmt2.setString(11, facilityId);
				result3 = pstmt2.executeUpdate();

				if(pstmt2 !=null) pstmt2.close();
				if(result3 > 0)
				{
					flag = true;
				}else{
					flag = false;
				}
		}
		catch (Exception err1)
		{
			err1.printStackTrace();
		}
	
	 return flag;
 }
 public static String checkForNull(String inputString)
 {
	return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
 }
}
