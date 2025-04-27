/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMO.MortuaryRegistration;
import java.rmi.* ;
import javax.ejb.* ;
import java.util.*;
import java.sql.* ;
import javax.naming.*;
import java.io.*;
import javax.rmi.*;
import webbeans.eCommon.*;

/**
*
* @ejb.bean
*	name="MortuaryRegistration"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="MortuaryRegistration"
*	local-jndi-name="MortuaryRegistration"
*	impl-class-name="eMO.MortuaryRegistration.MOMortuaryRegnManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eMO.MortuaryRegistration.MOMortuaryRegnLocal"
*	remote-class="eMO.MortuaryRegistration.MOMortuaryRegnRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eMO.MortuaryRegistration.MOMortuaryRegnLocalHome"
*	remote-class="eMO.MortuaryRegistration.MOMortuaryRegnHome"
*	generate= "local,remote"
*
*
*/

public class MOMortuaryRegnManager implements SessionBean
{	

	Connection con ;
	PreparedStatement pstmt=null ;
	ResultSet rs=null;
	Properties	p ;
	StringBuffer  sql=new StringBuffer();
	StringBuffer  sql1	=new StringBuffer();
	StringBuffer  sb	=new StringBuffer();
	StringTokenizer strToken1=null;
	HashMap hashtable=null;
    String order_id="";
	String	ord_date_time="";
	String	practitioner_id=""; 
	String old_area_code="";
    String old_bed_no="";
    String  order_catalog_code=""; 
	String  postmortem_startend_status="";
	String  relgn_code="";
    SessionContext ctx;
    String postmortem_end_date_time ="";  
	String facility_id ="";				                       
	String encounter_id ="";
	String deceased_date ="";   
	String patient_id ="";
	String hcare_type ="";
	String mlc_yn ="";
	String pm_yn ="";
	String death_certificate_reqd_yn ="";
	String registration_no ="";
	String consent_form_code ="";
	String regn_no =""; 
	String brought_by_police_yn ="";
	String modified_at_ws_no ="";
	String modified_facility_id ="";
	String modified_by_id ="";
	String bed_no ="";
	String police_dtls ="";
	String refe_type ="";
	String pol_rep_no ="";
	String pol_stn_id ="";
	String pol_id ="";
	String place_of_death ="";
	String service_code ="";
    String atopsyno=""; 
	String consent_form_received_by ="";
	String consent_form_received_date ="";
	String police_approval_received_yn ="";
	String police_approval_received_by ="";
	String police_approval_received_date ="";
	String body_received_date		                   ="";
	String death_manner_code			               ="";
	String body_cond_code		                       ="";
	String identification_marks	 	               ="";
	String area_code	                               ="";
	String assign_date_time		                   ="";
	String RFID_Tag		                   ="";
	String postmortem_status		                   ="";
	String added_by_id		                           ="";
	String added_at_ws_no	                           ="";
	String added_facility_id 	 	                   ="";
	String relflagyn                                  ="";
	String death_status_remarks                        ="";  
    String body_found_at                               =""; 
	String res_town_code                               ="";
	String res_area_code                               =""; 
	String region_code                                 ="";
	String high_risk_body_yn="";
    String postmortem_type ="";
	String consent_given_by="";
	String relationship_with_deceased="";
	String referral_source="";
    String referral_by="";
	String unclaimedbodyyn="";
	String donor_card_available_yn="";        
    String donor_card_no ="";                 
    String donor_card_details="";             
    String consent_form_given_by3  ="";       
    String relationship_with_deceased3="";
    String consent_form_code3         ="";    
    String consent_form_received_by3     =""; 
    String consent_form_received_date3 ="";
    String organdonation="";
    CallableStatement cstmt = null;   
    String vechile_no="";
    String burial_permit_app_by="";
    String burial_app_date="";
    String claim_date_time="";
	String CLAIMANT_TYPE="";
	String CLAIMANT_TYPE_CODE="";
	String RELATIONSHIP=""; 
	String NAME="";
	String JOB_TITLE="";  
	String ADD_LINE1=""; 
	String ADD_LINE2="";
	String ADD_LINE3="";
	String ADD_LINE4="";
	String ZIP_CODE="";
	String COUNTRY_CODE=""; 
	String TELEPHONE_OFF ="";
	String TELEPHONE_RES="";
	String EMAIL_ID ="";
	String patient_class="";
	String MOB_TEL_NO="";
	String NAT_ID_NO ="";
	String ORGANIZATION_NAME="";  
	String PATIENT_EMPLOYEE_ID="";
	/*Added by Thamizh selvi on 25th July 2017 for ML-MMOH-CRF-0689 Start*/
	String calledFrom			= "";
	String externalBidYn		= "";
	String policeOfficerName	= "";
	String policeContactNo		= "";
	/*End*/
	//Added by Ashwini on 24-Jul-2017 for ML-MMOH-CRF-0743
	String PASSPORT_NO="";
	String OTHER_IDENTIFICATION="";
	String body_burial_permit_no="";
	String generate_burial_permit="";
  	String RELEASE_TO_FACILITY="";  //Added Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg
	String reason_desc=""; //Added this CRF Bru-HIMS-CRF-366
  	java.util.HashMap results	    =null;                      
	java.util.Hashtable message=null;
	boolean result					= false ;

	String locale = "";
	String external="";
	String dec_fac_id="";
	String death_after_potmrtm="";

	/****************************** CALL BACK Functions  ****************************************/
	public void ejbCreate()  {}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext( SessionContext context ) {this.ctx = context;}	


	/**
	 *Method to insert single record
	 *@param properties Connection Properties
	 *@param hashaMap Record data 
	 *@param as data for duplication check
	 *@param s Table Name
	 *@return HashMap holding the transaction details
	*/
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/


	public java.util.HashMap updateMORegn(Properties properties,HashMap ht) 
	{  
		try 
		{
			PreparedStatement pstmt=null;
			p	= properties  ;
			con	= ConnectionManager.getConnection(p);
			con.setAutoCommit(false);	

			locale = p.getProperty("LOCALE");

			results	= new java.util.HashMap() ;
			hashtable= ht;
			extractValues();
			boolean result=updateRegnDetails();
			if(result==false)
			{  
			//	sb.append("Exception in ->updateRegnDetails()" );
			//	results.put( "status", new Boolean(false) ) ;
			//	results.put( "error", sb.toString() ) ;
				return results;
			}
			int pstcnt=0;
			if(!(postmortem_startend_status.equals("E")||postmortem_startend_status.equals("S")))
			{
				
				strToken1= new StringTokenizer(organdonation,"|");
				sql.setLength(0);
				sql.append("delete from MO_ORGAN_DONATION_REGN where REGISTRATION_NO='"+regn_no+"' and FACILITY_ID='"+facility_id+"'");
				pstmt = con.prepareStatement(sql.toString());
				pstcnt=pstmt.executeUpdate();
				if(pstmt!=null)pstmt.close();
				sql.setLength(0);
				if(strToken1!=null)
				{
					sql.setLength(0);	
					sql.append("insert into MO_ORGAN_DONATION_REGN(FACILITY_ID,REGISTRATION_NO,ORGAN_CODE, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) values(?,?,?,?,sysdate,?,?,?,sysdate,?,?)");
					pstmt = con.prepareStatement(sql.toString());
					while(strToken1.hasMoreElements())
					{
						String organs=(String)strToken1.nextElement();
						if(!organs.equals(""))
						{
							pstmt.setString(1,facility_id);
							pstmt.setString(2,(regn_no==null)?"" :regn_no);
							pstmt.setString(3,(organs==null)?"" :organs);
							pstmt.setString(4,(added_by_id==null) ?"" :added_by_id);
							pstmt.setString(5,(added_at_ws_no==null) ?"" :added_at_ws_no);
							pstmt.setString(6,(added_facility_id==null) ?"" :added_facility_id);
							pstmt.setString(7,(modified_by_id==null) ?"" :modified_by_id	);                                           
							pstmt.setString(8,(modified_at_ws_no==null) ?"" :modified_at_ws_no	);                            
							pstmt.setString(9,(modified_facility_id==null) ?"" :modified_facility_id);                     
							pstcnt=pstmt.executeUpdate();
							if(pstcnt==0)result=false;
						}
					}
				}
				if(pstmt!=null)pstmt.close();
			}
			if(result)
			{
				sql.setLength(0);
				sql.append("delete from MO_CLAIMANT where REGISTRATION_NO='"+regn_no+"' and FACILITY_ID='"+facility_id+"'");
				pstmt = con.prepareStatement(sql.toString());
				pstmt.executeUpdate();
				if(pstmt!=null)pstmt.close();
				//Insert Query Modified Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg
				if(!CLAIMANT_TYPE.equals(""))
				{
					sql.setLength(0);
					sql.append("insert into MO_CLAIMANT(FACILITY_ID,REGISTRATION_NO,CLAIMANT_TYPE, CLAIMANT_TYPE_CODE, RELATIONSHIP, NAME, JOB_TITLE, ADD_LINE1, ADD_LINE2, ADD_LINE3, ADD_LINE4, ZIP_CODE, COUNTRY_CODE,TELEPHONE_OFF, TELEPHONE_RES, EMAIL_ID, MOB_TEL_NO, NAT_ID_NO, ORGANIZATION_NAME, PATIENT_EMPLOYEE_ID, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,RES_TOWN_CODE,RES_AREA_CODE,REGION_CODE,RELEASE_TO_FACILITY,REASON,PASSPORT_NO,OTHER_IDENTIFICATION) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?,?,?,?,?,?,?)");
					pstmt = con.prepareStatement(sql.toString());   
					pstmt.setString(1,facility_id);
					pstmt.setString(2,(regn_no==null)?"" :regn_no);
					pstmt.setString(3,(CLAIMANT_TYPE==null)?"" :CLAIMANT_TYPE);
					pstmt.setString(4,(CLAIMANT_TYPE_CODE==null)?"" :CLAIMANT_TYPE_CODE);
					pstmt.setString(5,(RELATIONSHIP==null)?"" :RELATIONSHIP);
					pstmt.setString(6,(NAME==null)?"" :NAME);
					pstmt.setString(7,(JOB_TITLE==null)?"" :JOB_TITLE);
					pstmt.setString(8,(ADD_LINE1==null)?"" :ADD_LINE1);
					pstmt.setString(9,(ADD_LINE2==null)?"" :ADD_LINE2);
					pstmt.setString(10,(ADD_LINE3==null)?"" :ADD_LINE3);
					pstmt.setString(11,(ADD_LINE4==null)?"" :ADD_LINE4);
					pstmt.setString(12,(ZIP_CODE==null)?"" :ZIP_CODE);
					pstmt.setString(13,(COUNTRY_CODE==null)?"" :COUNTRY_CODE);
					pstmt.setString(14,(TELEPHONE_OFF==null)?"" :TELEPHONE_OFF);
					pstmt.setString(15,(TELEPHONE_RES==null)?"" :TELEPHONE_RES);
					pstmt.setString(16,(EMAIL_ID==null)?"" :EMAIL_ID);
					pstmt.setString(17,(MOB_TEL_NO==null)?"" :MOB_TEL_NO);
					pstmt.setString(18,(NAT_ID_NO==null)?"" :NAT_ID_NO);
					pstmt.setString(19,(ORGANIZATION_NAME==null)?"" :ORGANIZATION_NAME);
					pstmt.setString(20,(PATIENT_EMPLOYEE_ID==null)?"" :PATIENT_EMPLOYEE_ID);
					pstmt.setString(21 ,(added_by_id==null) ?"" :added_by_id	);                                  
					pstmt.setString(22 ,(added_at_ws_no==null) ?"" :added_at_ws_no	);                          
					pstmt.setString(23 ,(added_facility_id==null) ?"" :added_facility_id	);                      
					pstmt.setString(24 ,(modified_by_id==null) ?"" :modified_by_id	);                            
					pstmt.setString(25 ,(modified_at_ws_no==null) ?"" :modified_at_ws_no	);                     
					pstmt.setString(26 ,(modified_facility_id==null) ?"" :modified_facility_id);   
					pstmt.setString(27 ,(res_town_code==null) ?"" :res_town_code);   
					pstmt.setString(28 ,(res_area_code==null) ?"" :res_area_code);   
					pstmt.setString(29 ,(region_code==null) ?"" :region_code);   
					pstmt.setString(30 ,(RELEASE_TO_FACILITY==null) ?"" :RELEASE_TO_FACILITY); //Added Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg
					
					pstmt.setString(31 ,(reason_desc==null) ?"" :reason_desc); //Added this CRF Bru-HIMS-CRF-366 [IN-039612]

					//Added by Ashwini on 24-Jul-2017 for ML-MMOH-CRF-0743
					pstmt.setString(32,(PASSPORT_NO==null)?"" :PASSPORT_NO);
					pstmt.setString(33,(OTHER_IDENTIFICATION==null)?"" :OTHER_IDENTIFICATION);
					
					pstcnt=pstmt.executeUpdate();  
					if(pstcnt==0)result=false;
				}
				if(pstmt!=null)pstmt.close();
			}
			if(result == true && !calledFrom.equals("MO_BID_REGN"))
			{
				sql.setLength(0);
				sql.append("UPDATE MP_PATIENT SET REGISTERED_IN_MO_YN='Y', DECEASED_DATE = TO_DATE(?,'DD/MM/YYYY HH24:MI'),MODIFIED_BY_ID=?, MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?  WHERE PATIENT_ID =? ");
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(1,deceased_date);
				pstmt.setString(2,modified_by_id);
			    pstmt.setString(3,modified_at_ws_no);
			    pstmt.setString(4,modified_facility_id==null?"" :modified_facility_id);
				pstmt.setString(5,patient_id);
				pstcnt=pstmt.executeUpdate();
				if(pstcnt==0)
				{
					
					result=false;
				}
				if(pstmt!=null)pstmt.close();	 
			}
			if(result && external.equals("N"))
			{
				sql.setLength(0);
				sql.append("UPDATE PR_ENCOUNTER SET DECEASED_DATE_TIME = TO_DATE(?,'DD/MM/YYYY HH24:MI'),MODIFIED_BY_ID=?, MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?  WHERE FACILITY_ID =? AND ENCOUNTER_ID =? ");
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(1,deceased_date);
				pstmt.setString(2,modified_by_id);
			    pstmt.setString(3,modified_at_ws_no);
			    pstmt.setString(4,modified_facility_id==null?"" :modified_facility_id);
				pstmt.setString(5,facility_id);
				pstmt.setString(6,encounter_id);
				pstcnt=pstmt.executeUpdate();
				if(pstcnt==0)
				{	
					result=false;
					
				}
				if(pstmt!=null)pstmt.close();
			}
			if(result && external.equals("N"))
			{
				sql.setLength(0);
				sql.append("UPDATE MR_DEATH_REGISTER_HDR SET DEATH_DATE_TIME = TO_DATE(?,'DD/MM/YYYY HH24:MI'),MODIFIED_BY_ID=?, MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?  WHERE FACILITY_ID =? AND ENCOUNTER_ID =? ");
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(1,deceased_date);
				pstmt.setString(2,modified_by_id);
			    pstmt.setString(3,modified_at_ws_no);
			    pstmt.setString(4,modified_facility_id==null?"" :modified_facility_id);
				pstmt.setString(5,facility_id);
				pstmt.setString(6,encounter_id);
				pstcnt=pstmt.executeUpdate();
				if(pstcnt==0)
				{	
					result=false;
					
				}
			}
			if((result && external.equals("N")) && patient_class.equals("IP"))
			{
				sql.setLength(0);
				sql.append("UPDATE IP_ADT_TRN SET DECEASED_DATE_TIME = TO_DATE(?,'DD/MM/YYYY HH24:MI'),MODIFIED_BY_ID=?, MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?  where facility_id =? and encounter_id =? AND TRN_TYPE ='D' ");
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(1,deceased_date);
				pstmt.setString(2,modified_by_id);
			    pstmt.setString(3,modified_at_ws_no);
			    pstmt.setString(4,modified_facility_id==null?"" :modified_facility_id);
				pstmt.setString(5,facility_id);
				pstmt.setString(6,encounter_id);
				pstcnt=pstmt.executeUpdate();
				if(pstcnt==0)
				{	
					
					result=false;
				}
				if(result)
				{
					sql.setLength(0);
					sql.append("UPDATE IP_PATIENT_LAST_ENCOUNTER SET DECEASED_DATE_TIME = TO_DATE(?,'DD/MM/YYYY HH24:MI'),MODIFIED_BY_ID=?, MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE FACILITY_ID =? AND ENCOUNTER_ID =? ");
					pstmt = con.prepareStatement(sql.toString());
					pstmt.setString(1,deceased_date);
					pstmt.setString(2,modified_by_id);
			        pstmt.setString(3,modified_at_ws_no);
			        pstmt.setString(4,modified_facility_id==null?"" :modified_facility_id);
					pstmt.setString(5,facility_id);
					pstmt.setString(6,encounter_id);
					pstcnt=pstmt.executeUpdate();
				}
				if(pstcnt==0)
				{	

					result=false;
				}
			}
			if((result && external.equals("N")) && (patient_class.equals("OP")||patient_class.equals("EM")))
			{
				if(result)
				{
					sql.setLength(0);
					sql.append("UPDATE OP_PATIENT_QUEUE SET DECEASED_DATE_TIME = TO_DATE(?,'DD/MM/YYYY HH24:MI'),MODIFIED_BY_ID=?, MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?  WHERE FACILITY_ID =? AND ENCOUNTER_ID =? ");
					pstmt = con.prepareStatement(sql.toString());
					pstmt.setString(1,deceased_date);
					pstmt.setString(2,modified_by_id);
			        pstmt.setString(3,modified_at_ws_no);
			        pstmt.setString(4,modified_facility_id==null?"" :modified_facility_id);
					pstmt.setString(5,facility_id);
					pstmt.setString(6,encounter_id);
					pstcnt=pstmt.executeUpdate();
				}
				if(pstcnt==0)
				{	
					result=false;
				}
			}
			if(pstmt!=null)pstmt.close();	 
			
			if(result)
			{	sql.setLength(0);
				sql.append("select area_code,bed_no from mo_bed_for_area where REGISTRATION_NO='"+regn_no+"' and facility_id = '"+facility_id+"' "); 
			    pstmt = con.prepareStatement(sql.toString());
				rs=pstmt.executeQuery();
			   while(rs.next())
				{
				old_area_code=rs.getString("area_code")==null?"":rs.getString("area_code");
                old_bed_no=rs.getString("bed_no")==null?"":rs.getString("bed_no");
				}
			if(!bed_no.equals(old_bed_no))
				{
			sql.setLength(0);
			sql.append("update  mo_bed_for_area set  OCCUPYING_PATIENT_ID=null, REGISTRATION_NO=null,BLOCKED_YN='N', BLOCKED_UPTO=NULL, REASON_FOR_BLOCKING=NULL, MODIFIED_BY_ID=?, MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? where area_code=? and bed_no=? and facility_id = ? "); 
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1,modified_by_id);
			pstmt.setString(2,modified_at_ws_no);
			pstmt.setString(3,modified_facility_id==null?"" :modified_facility_id);
			pstmt.setString(4,old_area_code);
			pstmt.setString(5,old_bed_no);
			pstmt.setString(6,facility_id);
			pstcnt=pstmt.executeUpdate();	
			
			if(!bed_no.equals(""))
			{
			sql.setLength(0);
			sql.append("update MO_BED_FOR_AREA set OCCUPYING_PATIENT_ID=?,BLOCKED_YN='N',BLOCKED_UPTO=null,REASON_FOR_BLOCKING=null,  MODIFIED_BY_ID=?,MODIFIED_DATE=sysdate,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=?,registration_no=? where area_code=? and bed_no=? and facility_id = ? and OCCUPYING_PATIENT_ID is null and  registration_no is null and EFF_STATUS='E' ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1,patient_id  );
			pstmt.setString(2,modified_by_id);
			pstmt.setString(3,modified_at_ws_no);
			pstmt.setString(4,modified_facility_id==null?"" :modified_facility_id);
			pstmt.setString(5,regn_no);
			pstmt.setString(6,area_code);
			pstmt.setString(7,bed_no);
			pstmt.setString(8,facility_id);
			 pstcnt=pstmt.executeUpdate();
     
			if (pstcnt==0)
			{
			result=false;
			}
			}
			
			}
			
			
			}
			
			if(result)
			{
				con.commit();
				java.util.Hashtable message = MessageManager.getMessage(locale,"RECORD_MODIFIED","SM");
				sb.append((String) message.get("message"));
				//message= MessageManager.getMessage( con,"RECORD_MODIFIED" ) ;
				//sb.append( (String) message.get("message") ) ;
				results.put( "status", new Boolean(false) ) ;
				results.put( "error", sb.toString() ) ;
				sb.setLength(0); 
			}
			else	
			{
				con.rollback();
			}
			results.put( "status", new Boolean(result) ) ;
			results.put( "error", sb.toString() ) ;
			sb.setLength(0); 	
		}
		catch(Exception fe)
	    {        
			fe.printStackTrace(System.err);
			sb.append("Exception in MortuaryRegnManager Watch Point No.100->" + fe);
			results.put( "inception",sb.toString() ) ;
			results.put( "status", new Boolean(false) ) ;
			results.put( "error", sb.toString() ) ;
			return results ;
		}
		finally	
		{	try 
			{
				if (con != null) 
					ConnectionManager.returnConnection(con,p);
				
			}
			catch (Exception ee) 
			{
				ee.printStackTrace(System.err);
				sb.append("Exception in TemplateComponentManager Watch Point No.101->" + ee);
				results.put( "status", new Boolean(false) ) ;
				results.put( "error", sb.toString() ) ;
				return results ;
			}
		}
		sql.setLength(0);
		sql1.setLength(0);
        sb.setLength(0);
		ht.clear();
		return results ;
	}
	public boolean updateRegnDetails()
	{
	
		try
		{
			/*Added by Thamizh selvi on 25th July 2017 for ML-MMOH-CRF-0689 Start*/
			if(calledFrom.equals("MO_BID_REGN")){
				cstmt= con.prepareCall("{call MP_AUDIT_FUNCTION.ASSIGN_VALUE('RECORD_REVOKE_PAT')}");
				cstmt.execute();
				if(cstmt != null) cstmt.close();
				sql.setLength(0);
				sql.append("UPDATE MP_PATIENT SET active_yn ='N', deceased_yn = 'Y', REGISTERED_IN_MO_YN = 'Y', deceased_date=TO_DATE(?,'DD/MM/YYYY HH24:MI'), MODIFIED_BY_ID=?, MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE PATIENT_ID =? ");
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(1,deceased_date);
				pstmt.setString(2,modified_by_id==null?"":modified_by_id);
				pstmt.setString(3,modified_at_ws_no==null?"":modified_at_ws_no);
				pstmt.setString(4,modified_facility_id==null?"":modified_facility_id);
				pstmt.setString(5,patient_id);
				int updCnt = 0;
				updCnt = pstmt.executeUpdate();
				if(updCnt == 0) 
					return false;
				if(pstmt!=null)pstmt.close();
			}/*End*/
			
			sql.setLength(0);
			sql.append("Select POSTMORTEM_END_DATE_TIME,BURIAL_PERMIT_NO,AUTOPSY_NO from mo_mortuary_regn where REGISTRATION_NO='"+regn_no+"' and  facility_id='"+facility_id+"'");
			pstmt = con.prepareStatement(sql.toString());
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				postmortem_end_date_time=rs.getString("POSTMORTEM_END_DATE_TIME")==null?"":rs.getString("POSTMORTEM_END_DATE_TIME");
				atopsyno=rs.getString("AUTOPSY_NO")==null?"":rs.getString("AUTOPSY_NO");
			}
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			
			if(body_burial_permit_no.equals("") && generate_burial_permit.equals("Y"))
			{
				if(!(postmortem_end_date_time.equals("")))
				{
					sql.setLength(0);
					
					sql.append("Select NEXT_BURIAL_PERMIT_NO from MO_parameter where facility_id='"+facility_id+"'");
					pstmt = con.prepareStatement(sql.toString());
					rs=pstmt.executeQuery();
					if(rs.next())
					{
						body_burial_permit_no=rs.getString(1);	
					}
					if(rs!=null)rs.close();
					if(pstmt!=null)pstmt.close();
					sql.setLength(0);
					sql.append("update MO_PARAMETER SET NEXT_BURIAL_PERMIT_NO=NEXT_BURIAL_PERMIT_NO+1,MODIFIED_BY_ID=?,MODIFIED_DATE=sysdate,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=? where facility_id=?");
					pstmt = con.prepareStatement(sql.toString());
					pstmt.setString(1,modified_by_id);
			        pstmt.setString(2,modified_at_ws_no);
			        pstmt.setString(3,modified_facility_id==null?"" :modified_facility_id);
			        pstmt.setString(4,facility_id);
					pstmt.executeUpdate();
					if(pstmt!=null)pstmt.close(); 
				}
				else
				{
					if(!pm_yn.equals("Y"))
					{
						sql.setLength(0);
						sql.append("Select NEXT_BURIAL_PERMIT_NO from MO_parameter where facility_id='"+facility_id+"'");
						if(pstmt!=null)pstmt.close();
						pstmt = con.prepareStatement(sql.toString());
						rs=pstmt.executeQuery();
						if(rs.next())
						{
							body_burial_permit_no=rs.getString(1);		
						}
						if(rs!=null)rs.close();
						if(pstmt!=null)pstmt.close();	
						sql.setLength(0);
						sql.append("update MO_PARAMETER SET NEXT_BURIAL_PERMIT_NO=NEXT_BURIAL_PERMIT_NO+1,MODIFIED_BY_ID=?,MODIFIED_DATE=sysdate,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=? where facility_id=? ");
						pstmt = con.prepareStatement(sql.toString());
						pstmt.setString(1,modified_by_id);
			            pstmt.setString(2,modified_at_ws_no);
			            pstmt.setString(3,modified_facility_id==null?"" :modified_facility_id);
			            pstmt.setString(4,facility_id);
						pstmt.executeUpdate();
					}
				}
			}
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();	
			sql.setLength(0);
			if(atopsyno.equals(""))
			{
				if(pm_yn.equals("Y"))
				{     
					pstmt = con.prepareStatement("select mo_get_next_postmortem_num('"+facility_id+"') nextatopno from MO_POSTMORTEM_NUM_CONTROL where FACILITY_ID='"+facility_id+"'");   	
					rs = pstmt.executeQuery();
					if(rs.next())
					{
						atopsyno=rs.getString("nextatopno");
					}
					if(rs!=null)rs.close();
					if(pstmt!=null)pstmt.close();
					pstmt = con.prepareStatement("select NEXT_NUM, MAX_NUM from MO_POSTMORTEM_NUM_CONTROL where facility_id=?"); 	
					pstmt.setString(1,facility_id);
					rs = pstmt.executeQuery();
					rs.next();
					if(rs.getLong(1)> rs.getLong(2))
					{ 
						java.util.Hashtable message = MessageManager.getMessage(locale,"REG_NO_EXCEEDS_MAX_NO","MO");
						sb.append((String) message.get("message"));
						//message = MessageManager.getMessage(con,"REG_NO_EXCEEDS_MAX_NO") ;
						//sb.append( (String) message.get("message") ) ;

						results.put( "status", new Boolean(false) ) ;
						results.put( "error", sb.toString() ) ;
						sb.setLength(0);
						sql.setLength(0);
						sql1.setLength(0);
						return false;
					}
					sql.setLength(0);
					sql.append("update MO_POSTMORTEM_NUM_CONTROL set next_num=next_num+1,MODIFIED_BY_ID=?,MODIFIED_DATE=sysdate,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=? where facility_id=?");
					pstmt = con.prepareStatement(sql.toString());
					pstmt.setString(1,modified_by_id);
			        pstmt.setString(2,modified_at_ws_no);
			        pstmt.setString(3,modified_facility_id==null?"" :modified_facility_id);
			        pstmt.setString(4,facility_id);
					pstmt.executeUpdate();
				}
			}
			sql.setLength(0);
			sql.append("select  burial_permit_no from mo_mortuary_regn where  BURIAL_PERMIT_NO=? and registration_no!=? and facility_id='"+facility_id+"'");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1,body_burial_permit_no);
			pstmt.setString(2,regn_no);
			rs=pstmt.executeQuery();
			if(rs.next())
			{ 

				java.util.Hashtable message = MessageManager.getMessage(locale,"BURIAL_PERMIT_NO_EXISTS","MO");
				sb.append((String) message.get("message"));

				//message = MessageManager.getMessage(con,"BURIAL_PERMIT_NO_EXISTS") ;
				//sb.append( (String) message.get("message") ) ;

				results.put( "status", new Boolean(false) ) ;
				results.put( "error", sb.toString() ) ;
				sb.setLength(0);
				sql.setLength(0);
				sql1.setLength(0);
				return false;
			}
			if((pm_yn.equals("Y"))&&(postmortem_end_date_time.equals("")))
			{
				burial_permit_app_by ="";
				burial_app_date=""; 
				vechile_no="";
				body_burial_permit_no=""; 
				claim_date_time="";
			}
			sql.setLength(0);
			sql1.append("update MO_MORTUARY_REGN set DEATH_CERTIFICATE_REQD_YN=?,BROUGHT_BY_POLICE_YN=?,POLICE_DTLS=?,PLACE_OF_DEATH=?,CONSENT_FORM_CODE=?,CONSENT_FORM_RECEIVED_BY=?,CONSENT_FORM_RECEIVED_DATE=to_date(?,'dd/mm/yyyy hh24:mi'),DEATH_MANNER_CODE=?,BODY_COND_CODE=?,IDENTIFICATION_MARKS=?,AREA_CODE=?,BED_NO=?,ASSIGN_DATE_TIME=to_date(?,'dd/mm/yyyy hh24:mi'),BURIAL_PERMIT_NO=?,BURIAL_PERMIT_APPROVED_BY=?,BURIAL_PERMIT_APPROVED_DATE=to_date(?,'dd/mm/yyyy hh24:mi'),VEHICLE_NUM =?,MODIFIED_BY_ID =?,MODIFIED_DATE =sysdate,MODIFIED_AT_WS_NO =?,MODIFIED_FACILITY_ID =?,UNCLAIMED_BODY_YN  =?,HIGH_RISK_BODY_YN  =?,CONSENT_GIVEN_BY=?,RELATIONSHIP_WITH_DECEASED=?,REF_SOURCE_CODE  =?,REFERRED_BY=?,DONOR_CARD_AVAILABLE_YN=?,DONOR_CARD_NO=?,DONOR_CARD_DETAILS=?,CONSENT_FORM_CODE2=?,CONSENT_FORM_RECEIVED_BY2=?,CONSENT_FORM_RECEIVED_DATE2=to_date(?,'dd/mm/yyyy hh24:mi'),CONSENT_GIVEN_BY2=?,RELATIONSHIP_WITH_DECEASED2=?,police_approval_received_yn=?,police_approval_received_by=?,police_approval_received_date=to_date(?,'dd/mm/yyyy hh24:mi'),death_status_remarks=?,POSTMORTEM_TYPE =?,POL_REP_NO=?,POL_STN_ID=?,POL_ID=?,CLAIM_DATE_TIME=to_date(?,'dd/mm/yyyy hh24:mi'),REFERRAL_TYPE=?,HCARE_SETTING_TYPE=?,BODY_FOUND_AT=?,mlc_yn=?,pm_yn=?,POSTMORTEM_STATUS=?,AUTOPSY_NO=?,RFID_TAG_NUM=?,ACTUAL_DEATH_MANNER_CODE=?,police_officer_name=?, police_contact_no=? where facility_id='"+facility_id+"' and  REGISTRATION_NO='"+regn_no+"'");//Modified by Thamizh selvi on 3rd Aug 2017 for ML-MMOH-CRF-0689
			if(pstmt!=null)pstmt.close();
			if(rs!=null)rs.close();
			
			pstmt = con.prepareStatement(sql1.toString());   
			pstmt.setString(1 ,(death_certificate_reqd_yn ==null)?"" :death_certificate_reqd_yn);  
			pstmt.setString(2 ,(brought_by_police_yn		 ==null)?"" :brought_by_police_yn	);  
			pstmt.setString(3 , (police_dtls==null )?"" :police_dtls);  
			pstmt.setString(4 ,(place_of_death==null) ?"" :place_of_death); 
			pstmt.setString(5 ,(consent_form_code==null) ?"" :consent_form_code	);                      
			pstmt.setString(6 ,(consent_form_received_by==null) ?"" :consent_form_received_by	);          
			pstmt.setString(7 ,(consent_form_received_date==null) ?"" :consent_form_received_date	);      
			pstmt.setString(8 ,(death_manner_code==null) ?"" :death_manner_code	);                      
			pstmt.setString(9 ,(body_cond_code==null) ?"" :body_cond_code	);   	                        
			pstmt.setString(10 ,(identification_marks==null) ?"" :identification_marks	);   			    
			pstmt.setString(11 ,(area_code==null) ?"" :area_code	);   
			pstmt.setString(12 ,(bed_no==null) ?"" :bed_no); 	                                            
			pstmt.setString(13 ,(assign_date_time==null) ?"" :assign_date_time	);   	                    
			pstmt.setString(14,(body_burial_permit_no.equals(""))?"" :body_burial_permit_no); 
			pstmt.setString(15 ,(burial_permit_app_by==null) ?"" :burial_permit_app_by); 
			pstmt.setString(16 ,(burial_app_date==null) ?"" :burial_app_date); 
			pstmt.setString(17 ,(vechile_no==null) ?"" :vechile_no); 
			pstmt.setString(18 ,(modified_by_id==null) ?"" :modified_by_id	);                                            
			pstmt.setString(19 ,(modified_at_ws_no==null) ?"" :modified_at_ws_no	);                            
			pstmt.setString(20 ,(modified_facility_id==null) ?"" :modified_facility_id);                    
			pstmt.setString(21 ,(unclaimedbodyyn==null||unclaimedbodyyn.equals("")) ?"N" :unclaimedbodyyn);
			pstmt.setString(22 ,(high_risk_body_yn==null||high_risk_body_yn.equals("")) ?"N" :high_risk_body_yn);
			pstmt.setString(23 ,(consent_given_by==null) ?"" :consent_given_by);	    
			pstmt.setString(24,(relationship_with_deceased==null) ?"" :relationship_with_deceased);		
			pstmt.setString(25 ,(referral_source==null) ?"" :referral_source);
			pstmt.setString(26 ,(referral_by==null) ?"" :referral_by);
			pstmt.setString(27 ,(donor_card_available_yn==null||donor_card_available_yn.equals("")) ?"N" :donor_card_available_yn);                                  
			pstmt.setString(28 ,(donor_card_no==null) ?"" :donor_card_no);                            
			pstmt.setString(29 ,(donor_card_details==null) ?"" :donor_card_details);                        
			pstmt.setString(30 ,(consent_form_code3==null) ?"" :consent_form_code3);
			pstmt.setString(31 ,(consent_form_received_by3==null) ?"" :consent_form_received_by3);
			pstmt.setString(32 ,(consent_form_received_date3==null) ?"" :consent_form_received_date3); 
			pstmt.setString(33 ,(consent_form_given_by3==null) ?"" :consent_form_given_by3);
			pstmt.setString(34 ,(relationship_with_deceased3==null) ?"" :relationship_with_deceased3);
			pstmt.setString(35,(police_approval_received_yn==null)||(police_approval_received_yn.equals("")) ?"N" :police_approval_received_yn); 
			pstmt.setString(36 ,(police_approval_received_by==null) ?"" :police_approval_received_by); 
			pstmt.setString(37 ,(police_approval_received_date==null) ?"" :police_approval_received_date); 
			pstmt.setString(38 ,(death_status_remarks==null) ?"" :death_status_remarks); 
			pstmt.setString(39 ,(postmortem_type==null) ?"" :postmortem_type);
			pstmt.setString(40,(pol_rep_no==null) ?"" :pol_rep_no); 
			pstmt.setString(41,(pol_stn_id==null) ?"" :pol_stn_id); 
			pstmt.setString(42,(pol_id==null )?"" :pol_id); 
			pstmt.setString(43,(claim_date_time==null) ?"" :claim_date_time); 		
			pstmt.setString(44,(refe_type==null) ?"" :refe_type); 
			pstmt.setString(45,(hcare_type==null)?"":hcare_type);
			pstmt.setString(46,(body_found_at==null)?"":body_found_at);
			pstmt.setString(47 ,(mlc_yn ==null)?"" :mlc_yn  ); 
			pstmt.setString(48 ,(pm_yn ==null)?"" :pm_yn ); 
			pstmt.setString(49 ,(postmortem_status ==null)?"" :postmortem_status ); 
			pstmt.setString(50,(atopsyno==null) ?"" :atopsyno); 
			pstmt.setString(51,(RFID_Tag==null) ?"" :RFID_Tag); 
			  /*  Below line(s) added by Venkatesh.S on 12-Nov-2013 against Bru-HIMS-CRF-365 [IN:039572] */
			pstmt.setString(52,(death_after_potmrtm==null) ?"" :death_after_potmrtm); 
			/*Added by Thamizh selvi on 3rd Aug 2017 for ML-MMOH-CRF-0689 Start*/
			pstmt.setString(53,(policeOfficerName==null) ?"" :policeOfficerName);
			pstmt.setString(54,(policeContactNo==null) ?"" :policeContactNo);
			/*End*/
			pstmt.executeUpdate();
			if(pstmt!=null)pstmt.close();
			sql.setLength(0);
			
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
			
		}
	
	}

	
	/**
	 *Method to insert single record
	 *@param properties Connection Properties
	 *@param hashaMap Record data 
	 *@param as data for duplication check
	 *@param s Table Name
	 *@return HashMap holding the transaction details
	*/
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public java.util.HashMap insertMORegn(Properties properties,HashMap ht) 
	{ 	 
		
		//sql1.append("INSERT INTO MO_MORTUARY_REGN(FACILITY_ID,REGISTRATION_NO,ENCOUNTER_ID, PATIENT_ID,MLC_YN,PM_YN,DEATH_CERTIFICATE_REQD_YN,BROUGHT_BY_POLICE_YN,POLICE_DTLS,POL_REP_NO, POL_STN_ID,POL_ID,PLACE_OF_DEATH,SERVICE_CODE,CONSENT_FORM_CODE,CONSENT_FORM_RECEIVED_BY,CONSENT_FORM_RECEIVED_DATE,BODY_RECEIVED_DATE,DEATH_MANNER_CODE,BODY_COND_CODE,IDENTIFICATION_MARKS,AREA_CODE,ASSIGN_DATE_TIME,POSTMORTEM_STATUS,ADDED_BY_ID,ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,BED_NO,UNCLAIMED_BODY_YN, HIGH_RISK_BODY_YN,POSTMORTEM_TYPE,CONSENT_GIVEN_BY,RELATIONSHIP_WITH_DECEASED,REF_SOURCE_CODE, REFERRED_BY,DONOR_CARD_AVAILABLE_YN,DONOR_CARD_NO,DONOR_CARD_DETAILS, CONSENT_FORM_CODE2,CONSENT_FORM_RECEIVED_BY2,CONSENT_FORM_RECEIVED_DATE2, CONSENT_GIVEN_BY2,RELATIONSHIP_WITH_DECEASED2,BURIAL_PERMIT_APPROVED_BY, BURIAL_PERMIT_APPROVED_DATE, VEHICLE_NUM,BURIAL_PERMIT_NO,police_approval_received_yn,police_approval_received_by,police_approval_received_date,death_status_remarks,AUTOPSY_NO,ORDER_ID,ORD_DATE_TIME,PM_REQUESTED_BY,ORDER_CATALOG_CODE,CLAIM_DATE_TIME,REFERRAL_TYPE,HCARE_SETTING_TYPE,BODY_FOUND_AT,RFID_TAG_NUM,DECEASED_FACILITY_ID,EXTERNAL_YN)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy hh24:mi'),to_date(?,'dd/mm/yyyy hh24:mi'),?,?,?,?,to_date(?,'dd/mm/yyyy hh24:mi '),?,?,sysdate,?,?,?,sysdate,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy hh24:mi'),?,?,?,to_date(?,'dd/mm/yyyy hh24:mi'),?,?,?,?,to_date(?,'dd/mm/yyyy hh24:mi'),?,?,?,to_date(?,'dd/mm/yyyy hh24:mi'),?,?,to_date(?,'dd/mm/yyyy hh24:mi'),?,?,?,?,?,?)");
		
		sql1.append("INSERT INTO MO_MORTUARY_REGN(FACILITY_ID,REGISTRATION_NO,ENCOUNTER_ID, PATIENT_ID,MLC_YN,PM_YN,DEATH_CERTIFICATE_REQD_YN,BROUGHT_BY_POLICE_YN,POLICE_DTLS,POL_REP_NO, POL_STN_ID,POL_ID,PLACE_OF_DEATH,SERVICE_CODE,CONSENT_FORM_CODE,CONSENT_FORM_RECEIVED_BY,CONSENT_FORM_RECEIVED_DATE,BODY_RECEIVED_DATE,DEATH_MANNER_CODE,BODY_COND_CODE,IDENTIFICATION_MARKS,AREA_CODE,ASSIGN_DATE_TIME,POSTMORTEM_STATUS,ADDED_BY_ID,ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,BED_NO,UNCLAIMED_BODY_YN, HIGH_RISK_BODY_YN,POSTMORTEM_TYPE,CONSENT_GIVEN_BY,RELATIONSHIP_WITH_DECEASED,REF_SOURCE_CODE, REFERRED_BY,DONOR_CARD_AVAILABLE_YN,DONOR_CARD_NO,DONOR_CARD_DETAILS, CONSENT_FORM_CODE2,CONSENT_FORM_RECEIVED_BY2,CONSENT_FORM_RECEIVED_DATE2, CONSENT_GIVEN_BY2,RELATIONSHIP_WITH_DECEASED2,BURIAL_PERMIT_APPROVED_BY, BURIAL_PERMIT_APPROVED_DATE, VEHICLE_NUM,BURIAL_PERMIT_NO,police_approval_received_yn,police_approval_received_by,police_approval_received_date,death_status_remarks,AUTOPSY_NO,PM_REQUESTED_BY,CLAIM_DATE_TIME,REFERRAL_TYPE,HCARE_SETTING_TYPE,BODY_FOUND_AT,RFID_TAG_NUM,DECEASED_FACILITY_ID,EXTERNAL_YN,external_bid_yn,police_officer_name,police_contact_no)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy hh24:mi'),to_date(?,'dd/mm/yyyy hh24:mi'),?,?,?,?,to_date(?,'dd/mm/yyyy hh24:mi '),?,?,sysdate,?,?,?,sysdate,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy hh24:mi'),?,?,?,to_date(?,'dd/mm/yyyy hh24:mi'),?,?,?,?,to_date(?,'dd/mm/yyyy hh24:mi'),?,?,?,to_date(?,'dd/mm/yyyy hh24:mi'),?,?,?,?,?,?,?,?,?)");//Modified by Thamizh selvi on 1st Aug 2017 for ML-MMOH-CRF-0689
		try 
		{ 	 
			p = properties  ;
			con = ConnectionManager.getConnection(p);
			con.setAutoCommit(false);		
			locale = p.getProperty("LOCALE");
			results = new java.util.HashMap() ;
			hashtable = ht;
			extractValues();
			
			if(checkDuplicate()==false) //chk duplicate
			return results;			
			pstmt = con.prepareStatement("SELECT mo_get_next_regn_num('"+facility_id+"') next_regn_num FROM MO_REGN_NUM_CONTROL 	WHERE FACILITY_ID='"+facility_id+"'");
			
			rs = pstmt.executeQuery();
			
			if(rs!=null)
			{
				while(rs.next())
				{
					registration_no = rs.getString(1);
				}
			}
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			
			if(pm_yn.equals("Y"))
			{     
				
				pstmt = con.prepareStatement("select mo_get_next_postmortem_num('"+facility_id+"') nextatopno from MO_POSTMORTEM_NUM_CONTROL where FACILITY_ID='"+facility_id+"'"); 
				
				rs = pstmt.executeQuery();
				
				if(rs.next())
				{
					atopsyno=rs.getString("nextatopno");
				}
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				pstmt = con.prepareStatement("select NEXT_NUM, MAX_NUM from MO_POSTMORTEM_NUM_CONTROL where facility_id=?");   			
				pstmt.setString(1,facility_id);
				
				rs = pstmt.executeQuery();
				
				rs.next();
				
				if(rs.getLong(1)> rs.getLong(2))
				{
					
					
					java.util.Hashtable message = MessageManager.getMessage(locale,"REG_NO_EXCEEDS_MAX_NO","MO");
					sb.append((String) message.get("message"));

					//message = MessageManager.getMessage(con,"REG_NO_EXCEEDS_MAX_NO") ;
					//sb.append( (String) message.get("message") ) ;
					results.put( "status", new Boolean(false) ) ;
					results.put( "error", sb.toString() ) ;
					sb.setLength(0);
					sql.setLength(0);
					sql1.setLength(0);
					return results;
				}
			}
			if(pstmt!=null)pstmt.close();
			if(rs!=null)rs.close();
			pstmt = con.prepareStatement("select NEXT_NUM, MAX_NUM from MO_REGN_NUM_CONTROL where facility_id=?");   			
			pstmt.setString(1,facility_id);
			
			rs = pstmt.executeQuery();
			
			rs.next();
			
			if(rs.getLong(1)> rs.getLong(2))
			{ 
				
				java.util.Hashtable message = MessageManager.getMessage(locale,"REG_NO_EXCEEDS_MAX_NO","MO");
				sb.append((String) message.get("message"));

				//message = MessageManager.getMessage(con,"REG_NO_EXCEEDS_MAX_NO") ;
				//sb.append( (String) message.get("message") ) ;
				results.put( "status", new Boolean(false) ) ;
				results.put( "error", sb.toString() ) ;
				sb.setLength(0);
				sql.setLength(0);
				sql1.setLength(0);
				return results;
			}
			else
			{
				
				if(rs!=null) rs.close();
				if(pstmt!=null)pstmt.close();
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				result=insertRegistrationDtls();
				if(result==false)
				{ 
					//sb.append("Error  in this fn->insertRegistrationDtls()");
				//	results.put( "status", new Boolean(false) ) ;
					//results.put( "error", sb.toString() ) ;
				
					con.rollback();
					return results ;
				}
				else
				{ 
					
					int pstmtcnt=0;
					result=insertOrgDonDetForPostmortem();
					if(result==false)
					{
						
						sb.append("Error  in this fn->insertOrgDonDetForPostmortem()");
						results.put( "status", new Boolean(false) ) ;
						results.put( "error", sb.toString() ) ;
						con.rollback();
						return results ;
					}
					else
					{
						
						if(relflagyn.equals("Y"))
						{
							
							cstmt= con.prepareCall("{call MP_AUDIT_FUNCTION.ASSIGN_VALUE('MO_REGISTER_DECEASED')}");
							cstmt.execute();
							if(cstmt != null) cstmt.close();
							sql.setLength(0);
							sql.append("UPDATE MP_PATIENT SET RELGN_CODE =?,MODIFIED_BY_ID=?,MODIFIED_DATE=sysdate,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=? WHERE PATIENT_ID =? ");
							pstmt = con.prepareStatement(sql.toString());
							pstmt.setString(1,relgn_code);
							pstmt.setString(2,modified_by_id);
			                pstmt.setString(3,modified_at_ws_no);
			                pstmt.setString(4,modified_facility_id==null?"" :modified_facility_id);
			                pstmt.setString(5,patient_id);
							pstmtcnt=pstmt.executeUpdate();
							if(pstmt!=null)pstmt.close();
							if(pstmtcnt==0)
								result=false;
						}
						if(result == true && !calledFrom.equals("MO_BID_REGN"))//Modified by Thamizh selvi on 25th July 2017 for ML-MMOH-CRF-0689
						{
							
							sql.setLength(0);
							sql.append("UPDATE MP_PATIENT SET REGISTERED_IN_MO_YN = 'Y', DECEASED_DATE = TO_DATE(?,'DD/MM/YYYY HH24:MI'),MODIFIED_BY_ID=?,MODIFIED_DATE=sysdate,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=?  WHERE PATIENT_ID =? ");
							pstmt = con.prepareStatement(sql.toString());
							pstmt.setString(1,deceased_date);
							pstmt.setString(2,modified_by_id);
			                pstmt.setString(3,modified_at_ws_no);
			                pstmt.setString(4,modified_facility_id==null?"" :modified_facility_id);
			                pstmt.setString(5,patient_id);
							pstmtcnt=pstmt.executeUpdate();
							
							if(pstmtcnt==0)
							{
								result=false;
							}    

							if(pstmt!=null)pstmt.close();	 
						}
						
						if(result && external.equals("N"))
						{
							
							sql.setLength(0);
							sql.append("UPDATE PR_ENCOUNTER SET DECEASED_DATE_TIME = TO_DATE(?,'DD/MM/YYYY HH24:MI'),MODIFIED_BY_ID=?,MODIFIED_DATE=sysdate,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=?   WHERE FACILITY_ID =? AND ENCOUNTER_ID =? ");
							pstmt = con.prepareStatement(sql.toString());
							pstmt.setString(1,deceased_date);
							pstmt.setString(2,modified_by_id);
			                pstmt.setString(3,modified_at_ws_no);
			                pstmt.setString(4,modified_facility_id==null?"" :modified_facility_id);
			                pstmt.setString(5,facility_id);
							pstmt.setString(6,encounter_id);
							pstmtcnt=pstmt.executeUpdate();
							
							if(pstmtcnt==0)
							{
								result=false;
							}
							if(pstmt!=null)pstmt.close();
						}
						if(result && external.equals("N"))
						{
							
							sql.setLength(0);
							sql.append("UPDATE MR_DEATH_REGISTER_HDR SET DEATH_DATE_TIME = TO_DATE(?,'DD/MM/YYYY HH24:MI') ,MODIFIED_BY_ID=?,MODIFIED_DATE=sysdate,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=?   WHERE FACILITY_ID =? AND ENCOUNTER_ID =? ");

							pstmt = con.prepareStatement(sql.toString());
							pstmt.setString(1,deceased_date);
							pstmt.setString(2,modified_by_id);
			                pstmt.setString(3,modified_at_ws_no);
			                pstmt.setString(4,modified_facility_id==null?"" :modified_facility_id);
			                pstmt.setString(5,facility_id);
							pstmt.setString(6,encounter_id);
							pstmtcnt=pstmt.executeUpdate();
							
						
							if(pstmtcnt==0)
							{	
								result=false;
							}
							if((result && external.equals("N"))&& patient_class.equals("IP"))
							{
								
								sql.setLength(0);
								sql.append("UPDATE IP_ADT_TRN SET DECEASED_DATE_TIME = TO_DATE(?,'DD/MM/YYYY HH24:MI'),MODIFIED_BY_ID=?,MODIFIED_DATE=sysdate,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=?   WHERE FACILITY_ID =? AND ENCOUNTER_ID =? AND TRN_TYPE = 'D' ");
								pstmt = con.prepareStatement(sql.toString());
								pstmt.setString(1,deceased_date);
							    pstmt.setString(2,modified_by_id);
			                    pstmt.setString(3,modified_at_ws_no);
			                    pstmt.setString(4,modified_facility_id==null?"" :modified_facility_id);
			                    pstmt.setString(5,facility_id);
							    pstmt.setString(6,encounter_id);
								pstmtcnt=pstmt.executeUpdate();
								
								
								if(pstmtcnt==0)
								{	
									result=false;
								}
								if(result)
								{
									
									sql.setLength(0);
									sql.append("UPDATE IP_PATIENT_LAST_ENCOUNTER SET DECEASED_DATE_TIME = TO_DATE(?,'DD/MM/YYYY HH24:MI'),MODIFIED_BY_ID=?,MODIFIED_DATE=sysdate,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=?  WHERE FACILITY_ID =? AND ENCOUNTER_ID =? ");
									pstmt = con.prepareStatement(sql.toString());
									pstmt.setString(1,deceased_date);
							        pstmt.setString(2,modified_by_id);
			                        pstmt.setString(3,modified_at_ws_no);
			                        pstmt.setString(4,modified_facility_id==null?"" :modified_facility_id);
			                        pstmt.setString(5,facility_id);
							        pstmt.setString(6,encounter_id);
									pstmtcnt=pstmt.executeUpdate();
									
													
								}
								if(pstmtcnt==0)
								{	
									result=false;
								}
								
							}
							if((result && external.equals("N")) && (patient_class.equals("OP")||patient_class.equals("EM")))
							{
								
								if(result)
								{
									
									sql.setLength(0);
									sql.append("update  OP_PATIENT_QUEUE   set DECEASED_DATE_TIME =to_date(?,'dd/mm/yyyy hh24:mi'),MODIFIED_BY_ID=?,MODIFIED_DATE=sysdate,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=?  WHERE FACILITY_ID =? AND ENCOUNTER_ID =? ");
									pstmt = con.prepareStatement(sql.toString());
									pstmt.setString(1,deceased_date);
							        pstmt.setString(2,modified_by_id);
			                        pstmt.setString(3,modified_at_ws_no);
			                        pstmt.setString(4,modified_facility_id==null?"" :modified_facility_id);
			                        pstmt.setString(5,facility_id);
							        pstmt.setString(6,encounter_id);
									pstmtcnt=pstmt.executeUpdate();
									
								}
								if(pstmtcnt==0)
								{	
									result=false;
								}
							}
							if(pstmt!=null)pstmt.close();	 
						}
						sql.setLength(0);
						if (!bed_no.equals("")&& result )
						{
							
							sql.setLength(0);
							sql.append("select count(*)cnt from mo_bed_for_area where area_code=? and bed_no=? and facility_id = ? and occupying_patient_id is null and (blocked_yn='N' OR (BLOCKED_YN='Y' AND BLOCKED_UPTO <= SYSDATE))");
							pstmt = con.prepareStatement(sql.toString());
							pstmt.setString(1,area_code);
							pstmt.setString(2,bed_no);
							pstmt.setString(3,facility_id);
							
							rs=pstmt.executeQuery();
							
							rs.next();
							if(rs.getInt("cnt")==0)
							{
								
								con.rollback();

								java.util.Hashtable message = MessageManager.getMessage(locale,"VAC_BED_SEL","MO");
								sb.append((String) message.get("message"));

								//message = MessageManager.getMessage( con,"VAC_BED_SEL");
								//sb.append( (String) message.get("message") ) ;

								results.put( "status", new Boolean(false) ) ;
								results.put( "error", sb.toString() ) ;
								sql.setLength(0);
								sql1.setLength(0);
								sb.setLength(0);
								message.clear();
								return results ;
							}
							if(rs!=null)rs.close();
							if(pstmt!=null)pstmt.close();
							sql.setLength(0);
							sql.append("update MO_BED_FOR_AREA set OCCUPYING_PATIENT_ID=?,BLOCKED_YN='N',BLOCKED_UPTO=null,REASON_FOR_BLOCKING=null,  MODIFIED_BY_ID=?,MODIFIED_DATE=sysdate,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=?,registration_no=? where area_code=? and bed_no=? and facility_id = ?  and OCCUPYING_PATIENT_ID is null and  registration_no is null and EFF_STATUS='E' ");
							pstmt = con.prepareStatement(sql.toString());
							pstmt.setString(1,patient_id  );
							pstmt.setString(2,modified_by_id);
							pstmt.setString(3,modified_at_ws_no);
							pstmt.setString(4,modified_facility_id==null?"" :modified_facility_id);
							pstmt.setString(5,registration_no);
							pstmt.setString(6,area_code);
							pstmt.setString(7,bed_no);
							pstmt.setString(8,facility_id);
							
							pstmtcnt=pstmt.executeUpdate();
							
							if(pstmtcnt==0)
							{
								result=false;								
							}
							if(pstmt!=null) pstmt.close();
						}
						if(result)
						{ 
							
							con.commit();
							sb.append(registration_no) ;
						}
						else
						{
							
							con.rollback();
						}
						
						results.put( "status", new Boolean(result) ) ;
						results.put( "error", sb.toString() ) ;
					}	
				}
			}
		}
		catch(Exception fe)
		{     
			
			try
			{
				con.rollback();
				fe.printStackTrace(System.err);
				sb.append("Exception in MortuaryRegnManager Watch Point No.102->" + fe);
				results.put( "inception",sb.toString() ) ;
				results.put( "status", new Boolean(false) ) ;
				results.put( "error", sb.toString() ) ;
				return results ;
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		finally	
		{
			try 
			{
				if (con != null) 
				ConnectionManager.returnConnection(con,p);
			}
			catch (Exception ee) 
			{
				ee.printStackTrace(System.err);
				sb.append("Exception in TemplateComponentManager Watch Point No.103->" + ee);
				results.put( "status", new Boolean(false) ) ;
				results.put( "error", sb.toString() ) ;
				return results ;
			}
		}
		sql.setLength(0);
		sql1.setLength(0);
		sb.setLength(0);
		ht.clear();
		return results ;
	}
	public boolean insertOrgDonDetForPostmortem()
	{
	  try
	  {
	   
	   if(pm_yn.equals("Y"))
		{
		  sql.setLength(0);
		  sql.append("update MO_POSTMORTEM_NUM_CONTROL set next_num=next_num+1,MODIFIED_BY_ID=?,MODIFIED_DATE=sysdate,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=? where facility_id=?");
         pstmt = con.prepareStatement(sql.toString());
		 pstmt.setString(1,modified_by_id);
		 pstmt.setString(2,modified_at_ws_no);
		 pstmt.setString(3,modified_facility_id==null?"" :modified_facility_id);
		 pstmt.setString(4,facility_id);
         pstmt.executeUpdate();
        }
		 sql.setLength(0);
	//	 int cnt=0;
		
		 sql.append("update MO_REGN_NUM_CONTROL set next_num=next_num+1,MODIFIED_BY_ID=?,MODIFIED_DATE=sysdate,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=?  where facility_id=?");
         if(pstmt!=null)pstmt.close();
		 pstmt = con.prepareStatement(sql.toString());
		 pstmt.setString(1,modified_by_id);
		 pstmt.setString(2,modified_at_ws_no);
		 pstmt.setString(3,modified_facility_id==null?"" :modified_facility_id);
		 pstmt.setString(4,facility_id);
         pstmt.executeUpdate();
         if(pstmt!=null) pstmt.close();
         if(area_code==null)area_code="";
		 if(bed_no==null)bed_no="";
         
		 
		 strToken1= new StringTokenizer(organdonation,"|");
		 if(strToken1!=null)
		 {
		   sql.setLength(0);	
		  sql.append("insert into MO_ORGAN_DONATION_REGN(FACILITY_ID,REGISTRATION_NO,ORGAN_CODE, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) values(?,?,?,?,sysdate,?,?,?,sysdate,?,?)");
		  pstmt = con.prepareStatement(sql.toString());
		 while(strToken1.hasMoreElements())
		 {  String organs=(String)strToken1.nextElement();
		 if(organs!="")
		 {

		 pstmt.setString(1,facility_id);
		 pstmt.setString(2,(registration_no==null)?"" :registration_no);
		 pstmt.setString(3,(organs==null)?"" :organs);
		 pstmt.setString(4,(added_by_id==null) ?"" :added_by_id);
		 pstmt.setString(5,(added_at_ws_no==null) ?"" :added_at_ws_no);
		 pstmt.setString(6,(added_facility_id==null) ?"" :added_facility_id);
		 pstmt.setString(7,(modified_by_id==null) ?"" :modified_by_id	);                                            
		 pstmt.setString(8,(modified_at_ws_no==null) ?"" :modified_at_ws_no	);                            
		 pstmt.setString(9,(modified_facility_id==null) ?"" :modified_facility_id);                              
		 pstmt.executeUpdate();
		 }  
		 }
		}
		 sql.setLength(0);	
		 if(pstmt!=null)pstmt.close();
		 //Insert Query Modified Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg
		 if(!CLAIMANT_TYPE.equals(""))
		 {sql.append("insert into MO_CLAIMANT(FACILITY_ID,REGISTRATION_NO,CLAIMANT_TYPE, CLAIMANT_TYPE_CODE, RELATIONSHIP, NAME, JOB_TITLE, ADD_LINE1, ADD_LINE2, ADD_LINE3, ADD_LINE4, ZIP_CODE, COUNTRY_CODE,TELEPHONE_OFF, TELEPHONE_RES, EMAIL_ID, MOB_TEL_NO, NAT_ID_NO, ORGANIZATION_NAME, PATIENT_EMPLOYEE_ID, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,RES_TOWN_CODE,RES_AREA_CODE,REGION_CODE,RELEASE_TO_FACILITY, REASON,PASSPORT_NO,OTHER_IDENTIFICATION) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?,?,?,?,?,?,?)");
		  pstmt = con.prepareStatement(sql.toString());   
		  pstmt.setString(1,facility_id);
		  pstmt.setString(2,(registration_no==null)?"" :registration_no);
		  pstmt.setString(3,(CLAIMANT_TYPE==null)?"" :CLAIMANT_TYPE);
		  pstmt.setString(4,(CLAIMANT_TYPE_CODE==null)?"" :CLAIMANT_TYPE_CODE);
		  pstmt.setString(5,(RELATIONSHIP==null)?"" :RELATIONSHIP);
          pstmt.setString(6,(NAME==null)?"" :NAME);
		  pstmt.setString(7,(JOB_TITLE==null)?"" :JOB_TITLE);
		  pstmt.setString(8,(ADD_LINE1==null)?"" :ADD_LINE1);
		  pstmt.setString(9,(ADD_LINE2==null)?"" :ADD_LINE2);
		  pstmt.setString(10,(ADD_LINE3==null)?"" :ADD_LINE3);
          pstmt.setString(11,(ADD_LINE4==null)?"" :ADD_LINE4);
		  pstmt.setString(12,(ZIP_CODE==null)?"" :ZIP_CODE);
		  pstmt.setString(13,(COUNTRY_CODE==null)?"" :COUNTRY_CODE);
		  pstmt.setString(14,(TELEPHONE_OFF==null)?"" :TELEPHONE_OFF);
		  pstmt.setString(15,(TELEPHONE_RES==null)?"" :TELEPHONE_RES);
          pstmt.setString(16,(EMAIL_ID==null)?"" :EMAIL_ID);
		  pstmt.setString(17,(MOB_TEL_NO==null)?"" :MOB_TEL_NO);
		  pstmt.setString(18,(NAT_ID_NO==null)?"" :NAT_ID_NO);
		  pstmt.setString(19,(ORGANIZATION_NAME==null)?"" :ORGANIZATION_NAME);
          pstmt.setString(20,(PATIENT_EMPLOYEE_ID==null)?"" :PATIENT_EMPLOYEE_ID);
		  pstmt.setString(21 ,(added_by_id==null) ?"" :added_by_id	);                                  
		  pstmt.setString(22 ,(added_at_ws_no==null) ?"" :added_at_ws_no	);                          
		  pstmt.setString(23 ,(added_facility_id==null) ?"" :added_facility_id	);                      pstmt.setString(24 ,(modified_by_id==null) ?"" :modified_by_id	);                            
		  pstmt.setString(25 ,(modified_at_ws_no==null) ?"" :modified_at_ws_no	);                      pstmt.setString(26 ,(modified_facility_id==null) ?"" :modified_facility_id);                  
		  pstmt.setString(27 ,(res_town_code==null) ?"" :res_town_code);   
		  pstmt.setString(28 ,(res_area_code==null) ?"" :res_area_code);   
		  pstmt.setString(29 ,(region_code==null) ?"" :region_code);   
		  pstmt.setString(30 ,(RELEASE_TO_FACILITY==null) ?"" :RELEASE_TO_FACILITY);
		  
		  pstmt.setString(31 ,(reason_desc==null) ?"" :reason_desc); //Added this CRF Bru-HIMS-CRF-366

		  //Added by Ashwini on 24-Jul-2017 for ML-MMOH-CRF-0743
		  pstmt.setString(32,(PASSPORT_NO==null)?"" :PASSPORT_NO);
		  pstmt.setString(33,(OTHER_IDENTIFICATION==null)?"" :OTHER_IDENTIFICATION);
		  
		  pstmt.executeUpdate();  
		 }
		 if(pstmt!=null)pstmt.close();
		 return true;
		 
		 



	  }catch(Exception e)
	  {
		e.printStackTrace();
	   return false;
	   
	  }
	
	}
	public boolean insertRegistrationDtls()
	{try
		{
			/*Added by Thamizh selvi on 25th July 2017 for ML-MMOH-CRF-0689 Start*/
			if(calledFrom.equals("MO_BID_REGN")){
				cstmt= con.prepareCall("{call MP_AUDIT_FUNCTION.ASSIGN_VALUE('RECORD_REVOKE_PAT')}");
				cstmt.execute();
				if(cstmt != null) cstmt.close();
				sql.setLength(0);
				sql.append("UPDATE MP_PATIENT SET active_yn ='N', deceased_yn = 'Y', REGISTERED_IN_MO_YN = 'Y', deceased_date=TO_DATE(?,'DD/MM/YYYY HH24:MI'), MODIFIED_BY_ID=?, MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE PATIENT_ID =? ");
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(1,deceased_date);
				pstmt.setString(2,modified_by_id==null?"":modified_by_id);
				pstmt.setString(3,modified_at_ws_no==null?"":modified_at_ws_no);
				pstmt.setString(4,modified_facility_id==null?"":modified_facility_id);
				pstmt.setString(5,patient_id);
				int updCnt = 0;
				updCnt = pstmt.executeUpdate();
				if(updCnt == 0)
					return false;
				if(pstmt!=null)pstmt.close();
			}/*End*/
				
				sql.setLength(0);
		//sql.append("select ORDER_ID, ORD_DATE_TIME, PRACTITIONER_ID, ORDER_CATALOG_CODE   from mo_manage_deceased_vw where patient_id=? and facility_id=? and POSTMORTEM_TYPE=? ");
		sql.append("select PRACTITIONER_ID  from mo_manage_deceased_vw where patient_id=? and facility_id=? and POSTMORTEM_TYPE=? ");
		pstmt = con.prepareStatement(sql.toString());
		pstmt.setString(1,patient_id);
		pstmt.setString(2,facility_id);
		pstmt.setString(3,postmortem_type);
		rs=pstmt.executeQuery();
		if(rs.next())
		{  //order_id=rs.getString("ORDER_ID");
		   //ord_date_time=rs.getString("ORD_DATE_TIME");
		   practitioner_id=rs.getString("PRACTITIONER_ID"); 
		   //order_catalog_code=rs.getString("ORDER_CATALOG_CODE"); 
	       postmortem_status="R"; 	   
		}
		
		if(rs!=null)rs.close();
        if(pstmt!=null)pstmt.close();
		if(pm_yn.equals("Y"))
		{burial_permit_app_by ="";
		 burial_app_date=""; 
		 vechile_no="";
		 body_burial_permit_no=""; 
	     claim_date_time="";
		}else if(body_burial_permit_no.equals("") && generate_burial_permit.equals("Y"))
		{
		 sql.setLength(0);
		 sql.append("Select NEXT_BURIAL_PERMIT_NO from MO_parameter where facility_id='"+facility_id+"'");
		 pstmt = con.prepareStatement(sql.toString());
		 rs=pstmt.executeQuery();
		 if(rs.next())
		 {body_burial_permit_no=rs.getString(1);
		 }
		 
		 sql.setLength(0);
		 sql.append("update MO_PARAMETER SET NEXT_BURIAL_PERMIT_NO=NEXT_BURIAL_PERMIT_NO+1,MODIFIED_BY_ID=?,MODIFIED_DATE=sysdate,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=?  where facility_id=? ");
		 pstmt = con.prepareStatement(sql.toString());
		 pstmt.setString(1,modified_by_id);
		 pstmt.setString(2,modified_at_ws_no);
		 pstmt.setString(3,modified_facility_id==null?"" :modified_facility_id);
		 pstmt.setString(4,facility_id);
		 pstmt.executeUpdate();
		 if(pstmt!=null)pstmt.close(); 
    	 }
		 if(rs!=null)rs.close();
		 if(pstmt!=null)pstmt.close();
		sql.setLength(0);
		
		sql.append("select  burial_permit_no from mo_mortuary_regn where  BURIAL_PERMIT_NO=? and  facility_id='"+facility_id+"'");
		pstmt = con.prepareStatement(sql.toString());
		pstmt.setString(1,body_burial_permit_no);
		rs=pstmt.executeQuery();
		if(rs.next())
		{ 
			//String  burexistnum=rs.getString("burial_permit_no");

		  java.util.Hashtable message = MessageManager.getMessage(locale,"BURIAL_PERMIT_NO_EXISTS","MO");
		  sb.append((String) message.get("message"));
            
		  //message = MessageManager.getMessage(con,"BURIAL_PERMIT_NO_EXISTS") ;
		  //sb.append( (String) message.get("message") ) ;
		  
		  results.put( "status", new Boolean(false) ) ;
		  results.put( "error", sb.toString() ) ;
		  sb.setLength(0);
		  sql.setLength(0);
		  sql1.setLength(0);
		  return false;
		}
		
		if(pstmt!=null)pstmt.close();
		if(rs!=null)rs.close();
		pstmt = con.prepareStatement(sql1.toString());   
		pstmt.setString(1 ,(facility_id==null)?"" :facility_id);   
		pstmt.setString(2 ,(registration_no==null)?"" :registration_no);  
		pstmt.setString(3 ,(encounter_id==null)?"" :encounter_id);  
		pstmt.setString(4 ,(patient_id==null)?"" :patient_id); 
		pstmt.setString(5 ,(mlc_yn ==null)?"" :mlc_yn  ); 
		pstmt.setString(6 ,(pm_yn ==null)?"" :pm_yn ); 
		pstmt.setString(7 ,(death_certificate_reqd_yn ==null)?"" :death_certificate_reqd_yn);  
		pstmt.setString(8 ,(brought_by_police_yn		 ==null)?"" :brought_by_police_yn	);  
		pstmt.setString(9 , (police_dtls==null )?"" :police_dtls);  
		pstmt.setString(10,(pol_rep_no==null) ?"" :pol_rep_no); 
		pstmt.setString(11,(pol_stn_id==null) ?"" :pol_stn_id); 
		pstmt.setString(12,(pol_id==null )?"" :pol_id); 
		pstmt.setString(13,(place_of_death==null) ?"" :place_of_death); 
		pstmt.setString(14,(service_code==null) ?"" :service_code	); 
		pstmt.setString(15,(consent_form_code==null) ?"" :consent_form_code	);                      
		pstmt.setString(16,(consent_form_received_by==null) ?"" :consent_form_received_by	);          
		pstmt.setString(17,(consent_form_received_date==null) ?"" :consent_form_received_date	);     
		pstmt.setString(18,(body_received_date==null) ?"" :body_received_date	);   	                
		pstmt.setString(19,(death_manner_code==null) ?"" :death_manner_code	);                          pstmt.setString(20,(body_cond_code==null) ?"" :body_cond_code	);   	                        
		pstmt.setString(21,(identification_marks==null) ?"" :identification_marks	);   			    pstmt.setString(22 ,(area_code==null) ?"" :area_code	);   			                        
		pstmt.setString(23 ,(assign_date_time==null) ?"" :assign_date_time	);   	                    pstmt.setString(24 ,(postmortem_status==null) ?"N" :postmortem_status	);   	                pstmt.setString(25 ,(added_by_id==null) ?"" :added_by_id	);                                  
		pstmt.setString(26 ,(added_at_ws_no==null) ?"" :added_at_ws_no	);                              
		pstmt.setString(27 ,(added_facility_id==null) ?"" :added_facility_id	);                      
		pstmt.setString(28 ,(modified_by_id==null) ?"" :modified_by_id	);                              
		pstmt.setString(29 ,(modified_at_ws_no==null) ?"" :modified_at_ws_no	);                      
		pstmt.setString(30 ,(modified_facility_id==null) ?"" :modified_facility_id);                    
		pstmt.setString(31 ,(bed_no==null) ?"" :bed_no); 	                                            
		pstmt.setString(32 ,(unclaimedbodyyn==null||unclaimedbodyyn.equals("")) ?"N" :unclaimedbodyyn);
		pstmt.setString(33 ,(high_risk_body_yn==null||high_risk_body_yn.equals("")) ?"N" :high_risk_body_yn);
		pstmt.setString(34 ,(postmortem_type==null) ?"" :postmortem_type);
		pstmt.setString(35 ,(consent_given_by==null) ?"" :consent_given_by);
		pstmt.setString(36 ,(relationship_with_deceased==null) ?"" :relationship_with_deceased);
		pstmt.setString(37 ,(referral_source==null) ?"" :referral_source);
		pstmt.setString(38 ,(referral_by==null) ?"" :referral_by);
		pstmt.setString(39 ,(donor_card_available_yn==null||donor_card_available_yn.equals("")) ?"N" :donor_card_available_yn);                                  
		pstmt.setString(40 ,(donor_card_no==null) ?"" :donor_card_no);                            
		pstmt.setString(41 ,(donor_card_details==null) ?"" :donor_card_details);                        
		pstmt.setString(42 ,(consent_form_code3==null) ?"" :consent_form_code3);
		pstmt.setString(43 ,(consent_form_received_by3==null) ?"" :consent_form_received_by3);
		pstmt.setString(44 ,(consent_form_received_date3==null) ?"" :consent_form_received_date3); 
		pstmt.setString(45 ,(consent_form_given_by3==null) ?"" :consent_form_given_by3);
		pstmt.setString(46 ,(relationship_with_deceased3==null) ?"" :relationship_with_deceased3);
		pstmt.setString(47 ,(burial_permit_app_by==null) ?"" :burial_permit_app_by); 
		pstmt.setString(48 ,(burial_app_date==null) ?"" :burial_app_date); 
		pstmt.setString(49 ,(vechile_no==null) ?"" :vechile_no); 
		pstmt.setString(50,(body_burial_permit_no==null) ?"" :body_burial_permit_no); 
		pstmt.setString(51,(police_approval_received_yn==null)||police_approval_received_yn.equals("") ?"N" :police_approval_received_yn); 
		pstmt.setString(52,(police_approval_received_by==null) ?"" :police_approval_received_by); 
		pstmt.setString(53,(police_approval_received_date==null) ?"" :police_approval_received_date); 
		pstmt.setString(54,(death_status_remarks==null) ?"" :death_status_remarks); 
		pstmt.setString(55,(atopsyno==null) ?"" :atopsyno); 
		//pstmt.setString(56,(order_id==null) ?"" :order_id); 
		//pstmt.setString(57,(ord_date_time==null) ?"" :ord_date_time); 
		pstmt.setString(56,(practitioner_id==null) ?"" :practitioner_id); 
		//pstmt.setString(59,(order_catalog_code==null) ?"" :order_catalog_code); 
		pstmt.setString(57,(claim_date_time==null) ?"" :claim_date_time); 
		pstmt.setString(58,(refe_type==null) ?"" :refe_type); 
		pstmt.setString(59,(hcare_type==null)?"":hcare_type);
		pstmt.setString(60,(body_found_at==null)?"":body_found_at);
		pstmt.setString(61,(RFID_Tag==null)?"":RFID_Tag);
		pstmt.setString(62,dec_fac_id);
		pstmt.setString(63,external);
				/*Added by Thamizh selvi on 3rd Aug 2017 for ML-MMOH-CRF-0689 Start*/
				pstmt.setString(64,(externalBidYn==null || externalBidYn=="")?"N":externalBidYn);
				pstmt.setString(65,(policeOfficerName==null) ?"" :policeOfficerName);
				pstmt.setString(66,(policeContactNo==null) ?"" :policeContactNo); 
				/*End*/

		int cnt = pstmt.executeUpdate();
        if ( cnt != 0)
	    {
		result = true ;
	    }
	    else
	    {
		result = false;
	    }
		if(pstmt!=null)pstmt.close();
	
	     return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;		
		}
	
	}

	public void extractValues() // to extract values from the has table
	{
		try
		{ 
	
		    facility_id	                           =(String)hashtable.get("FACILITY_ID");        
			registration_no                        =(String)hashtable.get("REGISTRATION_NO");  
			encounter_id	                       =(String)hashtable.get("ENCOUNTER_ID");        		relgn_code                             =(String)hashtable.get("relgn_code");
			patient_id			                   =(String)hashtable.get("PATIENT_ID");        		patient_class                          = (String)hashtable.get("patient_class");          
			mlc_yn                                 =(String)hashtable.get("MLC_YN");    
			pm_yn			                       =(String)hashtable.get("PM_YN");        		                               
			death_certificate_reqd_yn			   =(String)hashtable.get("DEATH_CERTIFICATE_REQD_YN");        
			brought_by_police_yn				   =(String)hashtable.get("BROUGHT_BY_POLICE_YN");        		          
			police_dtls		                       =(String)hashtable.get("POLICE_DTLS");        		          
			refe_type                              =(String)hashtable.get("refe_type");        		          
			pol_rep_no	  		                   =(String)hashtable.get("POL_REP_NO");        		          
			pol_stn_id		                       =(String)hashtable.get("POL_STN_ID");        		          
			pol_id		                           =(String)hashtable.get("POL_ID");        		          
			place_of_death		                   =(String)hashtable.get("PLACE_OF_DEATH");        		          
			service_code			               =(String)hashtable.get("SERVICE_CODE");        		          
			consent_form_code                      =(String)hashtable.get("CONSENT_FORM_CODE"); 
			consent_form_received_by	           =(String)hashtable.get("CONSENT_FORM_RECEIVED_BY");        		     
			consent_form_received_date			   =(String)hashtable.get("CONSENT_FORM_RECEIVED_DATE");        		       		 
			consent_form_received_by	           =(String)hashtable.get("CONSENT_FORM_RECEIVED_BY");        		     
			consent_form_received_date			   =(String)hashtable.get("CONSENT_FORM_RECEIVED_DATE"); postmortem_startend_status			 =(String)hashtable.get("POSTMORTEM_STARTEND_STATUS");        		
			police_approval_received_yn			   =(String)hashtable.get("POLICE_APPROVAL_RECEIVED_YN");        		 
			police_approval_received_by			   =(String)hashtable.get("POLICE_APPROVAL_RECEIVED_BY");        		 
			police_approval_received_date		   =(String)hashtable.get("POLICE_APPROVAL_RECEIVED_DATE");        	 
			body_received_date		               =(String)hashtable.get("BODY_RECEIVED_DATE");        		          
			death_manner_code			           =(String)hashtable.get("DEATH_MANNER_CODE");        		          
			body_cond_code		                   =(String)hashtable.get("BODY_COND_CODE");        		          
			identification_marks	 	           =(String)hashtable.get("IDENTIFICATION_MARKS");        		          
			area_code	                           =(String)hashtable.get("AREA_CODE");  
			assign_date_time		               =(String)hashtable.get("ASSIGN_DATE_TIME");        		          
			RFID_Tag		               =(String)hashtable.get("RFID_Tag");        		          
			postmortem_status		               =(String)hashtable.get("POSTMORTEM_STATUS");        		          
			added_at_ws_no	                       =(String)hashtable.get("ADDED_AT_WS_NO");        		          
			added_facility_id 	 	               =(String)hashtable.get("ADDED_FACILITY_ID");     
			added_by_id		                       =(String)hashtable.get("ADDED_BY_ID");        		          
			modified_by_id		                   =(String)hashtable.get("MODIFIED_BY_ID");        		          
			modified_at_ws_no		               =(String)hashtable.get("MODIFIED_AT_WS_NO");
			bed_no			                       =(String)hashtable.get("BED_NO");
			modified_facility_id 	 	           =(String)hashtable.get("MODIFIED_FACILITY_ID");     
			high_risk_body_yn                      =(String)hashtable.get("HIGH_RISK_BODY_YN");     
			postmortem_type                        =(String)hashtable.get("POSTMORTEM_TYPE");       
			consent_given_by                       =(String)hashtable.get("CONSENT_GIVEN_BY");     
			relationship_with_deceased             =(String)hashtable.get("RELATIONSHIP_WITH_DECEASED");     
			referral_source                        =(String)hashtable.get("REF_SOURCE_CODE");     
			referral_by                            =(String)hashtable.get("REFERRED_BY");     
            unclaimedbodyyn                        =(String)hashtable.get("UNCLAIMED_BODY_YN");     
         	donor_card_available_yn                =(String)hashtable.get("DONOR_CARD_AVAILABLE_YN");     
			donor_card_no                          = (String)hashtable.get("DONOR_CARD_NO");     
			donor_card_details                     =(String)hashtable.get("DONOR_CARD_DETAILS");     
			consent_form_given_by3				   =(String)hashtable.get("CONSENT_FORM_GIVEN_BY3");     
			relationship_with_deceased3            =(String)hashtable.get("RELATIONSHIP_WITH_DECEASED3");     
			consent_form_code3                     =(String)hashtable.get("CONSENT_FORM_CODE3");     
			consent_form_received_by3              =(String)hashtable.get("CONSENT_FORM_RECEIVED_BY3");     
			consent_form_received_date3            =(String)hashtable.get("CONSENT_FORM_RECEIVED_DATE3");     
			organdonation                          =(String)hashtable.get("organdonation");     
            regn_no                                =(String)hashtable.get("regn_no");   
			death_status_remarks                   =(String)hashtable.get("death_status_remarks");   
            CLAIMANT_TYPE                          =(String)hashtable.get("CLAIMANT_TYPE");     
			CLAIMANT_TYPE_CODE                     =(String)hashtable.get("CLAIMANT_TYPE_CODE");     
			RELATIONSHIP                           =(String)hashtable.get("RELATIONSHIP");     
			NAME                                   =(String)hashtable.get("NAME");     
			JOB_TITLE                              =(String)hashtable.get("JOB_TITLE");               
			ADD_LINE1                              =(String)hashtable.get("ADD_LINE1");               
			ADD_LINE2                              =(String)hashtable.get("ADD_LINE2");               
			ADD_LINE3                              =(String)hashtable.get("ADD_LINE3");               
			ADD_LINE4                              =(String)hashtable.get("ADD_LINE4");               
			ZIP_CODE                               =(String)hashtable.get("ZIP_CODE");                
			COUNTRY_CODE                           =(String)hashtable.get("COUNTRY_CODE");           
			TELEPHONE_OFF                          =(String)hashtable.get("TELEPHONE_OFF");          
			TELEPHONE_RES                          =(String)hashtable.get("TELEPHONE_RES");           
			EMAIL_ID                               =(String)hashtable.get("EMAIL_ID");               
			MOB_TEL_NO                             =(String)hashtable.get("MOB_TEL_NO");              
			NAT_ID_NO                              =(String)hashtable.get("NAT_ID_NO");              
			ORGANIZATION_NAME                      =(String)hashtable.get("ORGANIZATION_NAME");       
			PATIENT_EMPLOYEE_ID                    =(String)hashtable.get("PATIENT_EMPLOYEE_ID");     
			/*Added by Thamizh selvi on 25th July 2017 for ML-MMOH-CRF-0689 Start*/
			calledFrom		                       =(String)hashtable.get("calledFrom");
			externalBidYn	                       =(String)hashtable.get("externalBidYn");
			policeOfficerName					   =(String)hashtable.get("policeOfficerName");
			policeContactNo						   =(String)hashtable.get("policeContactNo");
			/*End*/
			//Added by Ashwini on 24-Jul-2017 for ML-MMOH-CRF-0743
			PASSPORT_NO								=(String)hashtable.get("PASSPORT_NO"); 
			OTHER_IDENTIFICATION                    =(String)hashtable.get("OTHER_IDENTIFICATION"); 
		    vechile_no                             =(String)hashtable.get("VEHICLE_NUM");     
            burial_permit_app_by                   =(String)hashtable.get("BURIAL_PERMIT_APPROVED_BY");     
            burial_app_date                        =(String)hashtable.get("BURIAL_PERMIT_APPROVED_DATE");     
            body_burial_permit_no                  =(String)hashtable.get("body_burial_permit_no");     
            body_burial_permit_no                  =(String)hashtable.get("body_burial_permit_no");      
			claim_date_time                        =(String)hashtable.get("CLAIM_DATE_TIME");   
			hcare_type							   =(String)hashtable.get("hcare_type");
			//deceasedat							   =(String)hashtable.get("deceasedat");
		 	body_found_at						   =(String)hashtable.get("body_found_at");
            relflagyn                              =(String)hashtable.get("relflagyn");
	        res_town_code							   =(String)hashtable.get("res_town_code");
			res_area_code						   =(String)hashtable.get("res_area_code");
            region_code                              =(String)hashtable.get("region_code"); 
			deceased_date                              =(String)hashtable.get("deceased_date"); 
			generate_burial_permit                              =(String)hashtable.get("generate_burial_permit"); 
			RELEASE_TO_FACILITY                              =(String)hashtable.get("RELEASE_TO_FACILITY"); //Added Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg			
			reason_desc                              =(String)hashtable.get("reason_desc"); //Added this CRF Bru-HIMS-CRF-366 [IN-039612]
			external = (String)hashtable.get("external");
			dec_fac_id=(String)hashtable.get("dec_fac_id");
			    /*Below line(s) "death_after_potmrtm" variable added by Venkatesh.S on 12-Nov-2013 against Bru-HIMS-CRF-365 [IN:039572]*/
			death_after_potmrtm=(String)hashtable.get("death_after_potmrtm");
			
			
		

		
		}
		catch(Exception e)
		{
			e.printStackTrace(System.err);
			sb.append("Exception in MortuaryRegnManager" + e);
		}
	}
	public boolean checkDuplicate() //checks for the duplicates in the table
	{
		try 
		{		
			String duplicateSql = "select count(*) from MO_MORTUARY_REGN where FACILITY_ID=? and patient_id=? and body_part_obtained_from is null" ;
			pstmt = con.prepareStatement(duplicateSql) ;
			pstmt.setString(1,facility_id) ;
			pstmt.setString(2,patient_id) ;
			rs = pstmt.executeQuery() ;
			int count  = 0;
			while(rs.next())
			{
			count = rs.getInt(1) ;
			}
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if (count > 0)
			{
			 
			 java.util.Hashtable message = MessageManager.getMessage(locale,"CODE_ALREADY_EXISTS","COMMON");
		     sb.append((String) message.get("message"));

			 //message = MessageManager.getMessage( con, "CODE_ALREADY_EXISTS" ) ;
			 //sb.append( (String) message.get("message") ) ;

			 results.put( "status", new Boolean(false) ) ;
			 results.put( "error", sb.toString() ) ;
			sql.setLength(0);
	       	sql1.setLength(0);
            sb.setLength(0);
	
			 return false ;
			
			}
			else
			{
				
				return true ;
			}
		}
		catch ( Exception e ) 
		{
			e.printStackTrace(System.err);
			
			sb.append("Exception " +  e + "<br>" ) ;
			results.put( "status", new Boolean(false) ) ;
			results.put( "error", sb.toString() ) ;
			e.printStackTrace() ;
			return false ;
		}
	}

}
