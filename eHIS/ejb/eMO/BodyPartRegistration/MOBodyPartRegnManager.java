/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMO.BodyPartRegistration;
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
*	name="BodyPartRegistration"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="BodyPartRegistration"
*	local-jndi-name="BodyPartRegistration"
*	impl-class-name="eMO.BodyPartRegistration.MOBodyPartRegnManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eMO.BodyPartRegistration.MOBodyPartRegnLocal"
*	remote-class="eMO.BodyPartRegistration.MOBodyPartRegnRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eMO.BodyPartRegistration.MOBodyPartRegnLocalHome"
*	remote-class="eMO.BodyPartRegistration.MOBodyPartRegnHome"
*	generate= "local,remote"
*
*
*/

public class MOBodyPartRegnManager implements SessionBean
{	

	Connection con ;
	PreparedStatement pstmt=null ;
	//ResultSet rset;
	ResultSet rs=null;
	Properties	p ;
	public final String CODE_ALREADY_EXISTS = "CODE_ALREADY_EXISTS" ;
	StringBuffer  sql=new StringBuffer();
	StringBuffer  sql1	=new StringBuffer();
	StringBuffer  sb	=new StringBuffer();
	StringTokenizer strToken1=null;
	SessionContext ctx;
	HashMap hashtable=null;
	String remarks="";
	String RFID_Tag="";
    String order_id="";
	String	ord_date_time="";
	String	practitioner_id=""; 
    String  order_catalog_code=""; 
    String bodypartorgans=""; 
	String  refe_type="";
	String         res_town_code                               ="";
	String         res_area_code                               =""; 
	String         region_code                                 ="";
    String postmortem_end_date_time                            ="";  
	String 	        facility_id                                ="";				                       
	String		  	encounter_id	                           ="";
	String		  	patient_id			                       ="";
	String		  	mlc_yn                                     ="";
	String		  	pm_yn			                           ="";
	String		  	registration_no			                   ="";
	String          consent_form_code                          ="";
	String          regn_no                                    =""; 
	String		  	brought_by_police_yn				       ="";
	String          modified_at_ws_no                          ="";
	String          modified_facility_id                       ="";
	String          modified_by_id                             ="";
	String          bed_no                                     ="";
	String		  	police_dtls		                           ="";
	String		  	pol_rep_no	                               ="";
	String		  	pol_stn_id		                           ="";
	String		  	pol_id		                               ="";
	String		  	service_code			                   ="";
    String          atopsyno                                   =""; 
	String		  	consent_form_received_by	               ="";
	String		  	consent_form_received_date	               ="";
	String		  	police_approval_received_yn	               ="";
	String		  	police_approval_received_by		           ="";
	String		  	police_approval_received_date              ="";
	String		  	body_received_date		                   ="";
	String		  	area_code	                               ="";
	String		  	assign_date_time		                   ="";
	String		  	postmortem_status		                   ="";
	String		  	added_by_id		                           ="";
	String		  	added_at_ws_no	                           ="";
	String		  	added_facility_id 	 	                   ="";
	String          claim_date_time                            ="";
	String          high_risk_body_yn                          ="";
    String          postmortem_type                            ="";
	String          consent_given_by                           ="";
	String          relationship_with_deceased                 ="";
	String          referral_source                            ="";
	String			hcare_type								   ="";
    String          referral_by                                ="";
	String          unclaimedbodyyn                            ="";
    //String          organdonation                              ="";
    String          vechile_no                                 ="";
    String          burial_permit_app_by                       ="";
    String          burial_app_date                            ="";
	String          CLAIMANT_TYPE							   ="";
	String          CLAIMANT_TYPE_CODE						   ="";
	String          RELATIONSHIP							   =""; 
	String          NAME									   ="";
	String          JOB_TITLE								   =""; 
	String          ADD_LINE1                                  ="";  
	String          ADD_LINE2								   ="";  
	String			ADD_LINE3								   ="";  
	String			ADD_LINE4								   ="";  
	String			ZIP_CODE                                   ="";
	String			COUNTRY_CODE                               =""; 
	String			TELEPHONE_OFF                              ="";
	String			TELEPHONE_RES                              ="";
	String			EMAIL_ID                                   ="";
	String			MOB_TEL_NO                                 ="";
	String			NAT_ID_NO                                  ="";
	String			ORGANIZATION_NAME                          ="";  
	String			PATIENT_EMPLOYEE_ID                        ="";

	//Added by Ashwini on 24-Jul-2017 for ML-MMOH-CRF-0743
	String			PASSPORT_NO			                       ="";
	String			OTHER_IDENTIFICATION                       ="";

    String			body_burial_permit_no                      ="";
    String			body_part_obtained_from                    ="";
    String          old_area_code                              =""; 
   	String          old_bed_no                                 ="";
	String			locale									   ="";	
	String 			RELEASE_TO_FACILITY						   =""; //Added Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg   
	String          reason_desc=""; //Added this  CRF Bru-HIMS-CRF-366
	/*Added by Thamizh selvi on 3rd Aug 2017 for ML-MMOH-CRF-0689 Start*/
	String policeOfficerName	= "";
	String policeContactNo		= "";
	String calledFrom			= "";
	String externalBodyPartYn	= "N";
	/*End*/
	java.util.HashMap results	    =null;                      
	java.util.Hashtable message=null;
	boolean result					= false ;
	
    
  
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
	
	public java.util.HashMap updateBodyPartRegn(Properties properties,HashMap ht) 
	{  

	try 
	 {  PreparedStatement pstmt=null;
		ResultSet rs=null;
		p				                              = properties  ;
		con					                      = ConnectionManager.getConnection(p);

		locale = p.getProperty("LOCALE");

		con.setAutoCommit(false);					
		results			                          = new java.util.HashMap() ;
		hashtable	                          = ht;
		extractValues();
		sql.setLength(0);
		sql.append("Select POSTMORTEM_END_DATE_TIME,BURIAL_PERMIT_NO,AUTOPSY_NO from mo_mortuary_regn where REGISTRATION_NO='"+regn_no+"' and  facility_id='"+facility_id+"'");
		pstmt = con.prepareStatement(sql.toString());
		rs=pstmt.executeQuery();
		if(rs.next())
		{		postmortem_end_date_time=rs.getString("POSTMORTEM_END_DATE_TIME")==null?"":rs.getString("POSTMORTEM_END_DATE_TIME");
		        atopsyno=rs.getString("AUTOPSY_NO")==null?"":rs.getString("AUTOPSY_NO");
		}
		
		if(rs!=null)rs.close();
		if(pstmt!=null)pstmt.close();
		
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
		{ message = MessageManager.getMessage(locale,"REG_NO_EXCEEDS_MAX_NO","MO") ;
		  sb.append( (String) message.get("message") ) ;
		  results.put( "status", new Boolean(false) ) ;
		  results.put( "error", sb.toString() ) ;
		  sb.setLength(0);
		  sql.setLength(0);
		  sql1.setLength(0);
		  return results;
			
		}
		  if(rs!=null)rs.close();
		  if(pstmt!=null)pstmt.close();
		  sql.setLength(0);
		  sql.append("update MO_POSTMORTEM_NUM_CONTROL set next_num=next_num+1, MODIFIED_BY_ID=?, MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? where facility_id=?");
          pstmt = con.prepareStatement(sql.toString());
		  pstmt.setString(1,modified_by_id);
		  pstmt.setString(2,modified_at_ws_no);
		  pstmt.setString(3,modified_facility_id==null?"" :modified_facility_id);
		  pstmt.setString(4,facility_id);
          pstmt.executeUpdate();
		}
		}
		
		
		boolean result=updateregDet();
		
		if(result==false)
		 {
		 return results;
		 }
		int pstcnt=0;
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
			sql.append("update  mo_bed_for_area set  OCCUPYING_PATIENT_ID=null, REGISTRATION_NO=null,BLOCKED_YN='N', BLOCKED_UPTO=NULL, REASON_FOR_BLOCKING=NULL, MODIFIED_BY_ID=?, MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? where area_code=? and bed_no=? and facility_id = ?"); 
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
	   
	   
	   strToken1= new StringTokenizer(bodypartorgans,"|");
	   if(strToken1!=null)
	   {
	     sql.setLength(0);	
       if(strToken1.hasMoreElements())
	   {
	   sql.setLength(0);
	   sql.append("delete from MO_BODY_PART_REGN where REGISTRATION_NO='"+regn_no+"' and FACILITY_ID='"+facility_id+"'");
	   pstmt = con.prepareStatement(sql.toString());
	   pstmt.executeUpdate();
	  }
	 if(pstmt!=null)pstmt.close(); 
	 sql.setLength(0);
	 sql.append("insert into MO_BODY_PART_REGN(FACILITY_ID,REGISTRATION_NO,BODY_PART_CODE, ADDED_BY_ID,ADDED_DATE, ADDED_AT_WS_NO,ADDED_FACILITY_ID) values(?,?,?,?,sysdate,?,?)");
	 pstmt = con.prepareStatement(sql.toString());
	 while(strToken1.hasMoreElements())
	 {
	   String bodypart=(String)strToken1.nextElement();
	   if(!bodypart.equals(""))
	 {
 
		pstmt.setString(1,facility_id);
		pstmt.setString(2,(regn_no==null)?"" :regn_no);
		pstmt.setString(3,(bodypart==null)?"" :bodypart);
		pstmt.setString(4,(added_by_id==null) ?"" :added_by_id);
		pstmt.setString(5,(added_at_ws_no==null) ?"" :added_at_ws_no);
		pstmt.setString(6,(added_facility_id==null) ?"" :added_facility_id);
		pstmt.executeUpdate();
	}  
	}
	}
    
	if(pstmt!=null)pstmt.close();
    if(pstmt!=null)pstmt.close();
	sql.setLength(0);
	sql.append("delete from MO_CLAIMANT where REGISTRATION_NO='"+regn_no+"' and FACILITY_ID='"+facility_id+"'");
	pstmt = con.prepareStatement(sql.toString());
	pstmt.executeUpdate();
	if(pstmt!=null)pstmt.close();
	//Insert Query Modified Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg
	if(!CLAIMANT_TYPE.equals(""))
	 { sql.setLength(0);
	   sql.append("insert into MO_CLAIMANT(FACILITY_ID,REGISTRATION_NO,CLAIMANT_TYPE, CLAIMANT_TYPE_CODE, RELATIONSHIP, NAME, JOB_TITLE, ADD_LINE1, ADD_LINE2, ADD_LINE3, ADD_LINE4, ZIP_CODE, COUNTRY_CODE,TELEPHONE_OFF, TELEPHONE_RES, EMAIL_ID, MOB_TEL_NO, NAT_ID_NO, ORGANIZATION_NAME, PATIENT_EMPLOYEE_ID, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,RES_TOWN_CODE,RES_AREA_CODE,REGION_CODE,RELEASE_TO_FACILITY, REASON,PASSPORT_NO,OTHER_IDENTIFICATION) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?,?,?,?,?,?,?)");
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
	   pstmt.setString(30 ,(RELEASE_TO_FACILITY==null) ?"" :RELEASE_TO_FACILITY);    //Added Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg
	   pstmt.setString(31 ,(reason_desc==null) ?"" :reason_desc);    //Added this CRF Bru-HIMS-CRF-366 [IN-039612]
	   
	   //Added by Ashwini on 24-Jul-2017 for ML-MMOH-CRF-0743
	   pstmt.setString(32,(PASSPORT_NO==null)?"" :PASSPORT_NO);
	   pstmt.setString(33,(OTHER_IDENTIFICATION==null)?"" :OTHER_IDENTIFICATION);

	   pstmt.executeUpdate();  
	  }
		 if(pstmt!=null)pstmt.close();
		
		 if(result)
         {
		 con.commit();
		
		  message= MessageManager.getMessage( locale,"RECORD_MODIFIED" ,"SM") ;
 	      sb.append( (String) message.get("message") ) ;
		  results.put( "status", new Boolean(true) ) ;
		  results.put( "error", sb.toString() ) ;
	      sb.setLength(0); 
	   }
	   else
		{
	   con.rollback();
	   results.put( "status", new Boolean(result) ) ;
	   results.put( "error", sb.toString() ) ;
	   sb.setLength(0); 	
		}
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
	{
	try 
		{if (con != null) 
		  ConnectionManager.returnConnection(con,p);
		}catch (Exception ee) 
		{	ee.printStackTrace(System.err);
			sb.append("Exception in TemplateComponentManager Watch Point No.101->" + ee);
			results.put( "status", new Boolean(false) ) ;
			results.put( "error", sb.toString() ) ;
			return results ;
		}
	}	sql.setLength(0);
	   sql1.setLength(0);
       sb.setLength(0);
		ht.clear();
		return results ;}


	
	/****************************** Function to Insert Value  ****************************************/
	
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
	
	public java.util.HashMap insertBodyPartRegn(Properties properties,HashMap ht) 
	{  
	      	
	try 
	{ 
		 p				                              = properties  ;
	     con					                      = ConnectionManager.getConnection(p);

		 locale = p.getProperty("LOCALE");
		 con.setAutoCommit(false);					
	 	 results			                          = new java.util.HashMap() ;
	     hashtable	                          = ht;
	     extractValues();
         if(checkDuplicate()==false) //chk duplicate
	     return results;			
         pstmt = con.prepareStatement("SELECT mo_get_next_regn_num('"+facility_id+"') next_regn_num FROM MO_REGN_NUM_CONTROL WHERE FACILITY_ID='"+facility_id+"'");
 	     rs = pstmt.executeQuery();
	     if(rs!=null)
	     {
	     while(rs.next())
		 {
		  registration_no = rs.getString(1);
		 }
		 }if(rs!=null) rs.close();
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
		  message = MessageManager.getMessage(locale,"REG_NO_EXCEEDS_MAX_NO","MO") ;
		  sb.append( (String) message.get("message") ) ;
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
		message = MessageManager.getMessage(locale,"REG_NO_EXCEEDS_MAX_NO","MO") ;
		sb.append( (String) message.get("message") ) ;
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
		boolean result=collectOrderBurialPermitDetails();
		if(result==false)
		{
		message = MessageManager.getMessage(locale,"BURIAL_PERMIT_NO_EXISTS","MO") ;
		sb.append( (String) message.get("message") ) ;
		results.put( "status", new Boolean(false) ) ;
		results.put( "error", sb.toString() ) ;
		sb.setLength(0);
		sql.setLength(0);
		sql1.setLength(0);
		return results;
		}
		result=storeInMORegn();
		if(result)
		{  
	    if (!bed_no.equals(""))
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
		{con.rollback();
		 message = MessageManager.getMessage( locale,"VAC_BED_SEL","MO");
		 sb.append( (String) message.get("message") ) ;
		 results.put( "status", new Boolean(false) ) ;
		 results.put( "error", sb.toString() ) ;
		 sql.setLength(0);
	     sql1.setLength(0);
         sb.setLength(0);
		 message.clear();
		 return results ;
		}

		if(pstmt!=null)pstmt.close();
		if(rs!=null)rs.close();
		 }
		insertRegistrationDetails();
		storeBodypartDetails();
		if(result)
        {
		con.commit();
		message= MessageManager.getMessage( locale, "PAT_ID_SUCCESS","MP") ;
	    results.put("registration_no",registration_no);
		sb.append( (String) message.get("message") +"<B><font size=4>"+registration_no+"</font></B>") ;
	    
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
		{
			try 
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
 
  public boolean updateregDet()
 {   try
	 {
	   if(body_burial_permit_no.equals(""))
	   {
		if(!(postmortem_end_date_time.equals("")))
		{sql.setLength(0);
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
		sql.append("update MO_PARAMETER SET NEXT_BURIAL_PERMIT_NO=NEXT_BURIAL_PERMIT_NO+1, MODIFIED_BY_ID=?,MODIFIED_DATE=sysdate,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=? where facility_id=? ");
		pstmt = con.prepareStatement(sql.toString());
		pstmt.setString(1,modified_by_id);
		pstmt.setString(2,modified_at_ws_no);
		pstmt.setString(3,modified_facility_id==null?"" :modified_facility_id);
		pstmt.setString(4,facility_id);
		pstmt.executeUpdate();
		if(pstmt!=null)pstmt.close(); 
		}else
		{
		if(!pm_yn.equals("Y"))
			{
			
        if((body_part_obtained_from.equals("D")||body_part_obtained_from.equals("A"))&&burial_permit_app_by.equals(""))
		{
		}else{ 
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
	 }
	   	if(pstmt!=null)pstmt.close();
		sql.setLength(0);
		sql.append("select  burial_permit_no from mo_mortuary_regn where  BURIAL_PERMIT_NO=? and registration_no!=? and facility_id='"+facility_id+"'");
		pstmt = con.prepareStatement(sql.toString());
		pstmt.setString(1,body_burial_permit_no);
		pstmt.setString(2,regn_no);
		rs=pstmt.executeQuery();
		if(rs.next())
		{ message = MessageManager.getMessage(locale,"BURIAL_PERMIT_NO_EXISTS","MO") ;
		  sb.append( (String) message.get("message") ) ;
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
		}
		sql.setLength(0);

	    sql1.append("update MO_MORTUARY_REGN set BROUGHT_BY_POLICE_YN=?,POL_REP_NO=?,POL_STN_ID=?,POL_ID=?,POLICE_DTLS=?,CONSENT_FORM_CODE=?,CONSENT_FORM_RECEIVED_BY=?,CONSENT_FORM_RECEIVED_DATE=to_date(?,'dd/mm/yyyy hh24:mi'),BURIAL_PERMIT_NO=?,BURIAL_PERMIT_APPROVED_BY=?,BURIAL_PERMIT_APPROVED_DATE=to_date(?,'dd/mm/yyyy hh24:mi'),VEHICLE_NUM =?,MODIFIED_BY_ID =?,MODIFIED_DATE=sysdate,MODIFIED_AT_WS_NO =?,MODIFIED_FACILITY_ID =?,UNCLAIMED_BODY_YN =?,HIGH_RISK_BODY_YN=?,CONSENT_GIVEN_BY=?,RELATIONSHIP_WITH_DECEASED=?,REF_SOURCE_CODE  =?,REFERRED_BY=?,police_approval_received_yn=?,police_approval_received_by=?,police_approval_received_date=to_date(?,'dd/mm/yyyy hh24:mi'),POSTMORTEM_TYPE =?,CLAIM_DATE_TIME=to_date(?,'dd/mm/yyyy hh24:mi'),REFERRAL_TYPE =?,HCARE_SETTING_TYPE=?,MLC_YN=?, PM_YN=?,remarks=?,RFID_TAG_NUM=?,POSTMORTEM_STATUS=?,AUTOPSY_NO=?,AREA_CODE=?, BED_NO=?, police_officer_name=?, police_contact_no=?   where REGISTRATION_NO='"+regn_no+"' and  facility_id='"+facility_id+"'");//Modified by Thamizh selvi on 3rd Aug 2017 for ML-MMOH-CRF-0689


		
	if(pstmt!=null)pstmt.close();
	if(rs!=null)rs.close();

	pstmt = con.prepareStatement(sql1.toString());   
	pstmt.setString(1,(brought_by_police_yn==null)?"" :brought_by_police_yn	);  
	pstmt.setString(2,(pol_rep_no==null) ?"" :pol_rep_no); 
	pstmt.setString(3,(pol_stn_id==null) ?"" :pol_stn_id); 
	pstmt.setString(4,(pol_id==null )?"" :pol_id); 
	pstmt.setString(5,(police_dtls==null )?"" :police_dtls);  
	pstmt.setString(6,(consent_form_code==null) ?"" :consent_form_code	);                      
	pstmt.setString(7,(consent_form_received_by==null) ?"" :consent_form_received_by	);         
	pstmt.setString(8,(consent_form_received_date==null) ?"" :consent_form_received_date	);     
	pstmt.setString(9,(body_burial_permit_no.equals(""))?"" :body_burial_permit_no); 
	pstmt.setString(10 ,(burial_permit_app_by==null) ?"" :burial_permit_app_by); 
	pstmt.setString(11 ,(burial_app_date==null) ?"" :burial_app_date); 
	pstmt.setString(12 ,(vechile_no==null) ?"" :vechile_no); 
	pstmt.setString(13 ,(modified_by_id==null) ?"" :modified_by_id	);                             
	pstmt.setString(14 ,(modified_at_ws_no==null) ?"" :modified_at_ws_no	);                     
	pstmt.setString(15 ,(modified_facility_id==null) ?"" :modified_facility_id);                   
	pstmt.setString(16 ,(unclaimedbodyyn==null||unclaimedbodyyn.equals("")) ?"N" :unclaimedbodyyn);
	pstmt.setString(17 ,(high_risk_body_yn==null||high_risk_body_yn.equals("")) ?"N" :high_risk_body_yn);
	pstmt.setString(18 ,(consent_given_by==null) ?"" :consent_given_by);	    
	pstmt.setString(19,(relationship_with_deceased==null) ?"" :relationship_with_deceased);		
	pstmt.setString(20 ,(referral_source==null) ?"" :referral_source);
	pstmt.setString(21 ,(referral_by==null) ?"" :referral_by);
	pstmt.setString(22 ,(police_approval_received_yn==null)||(police_approval_received_yn.equals("")) ?"N" :police_approval_received_yn); 
	pstmt.setString(23 ,(police_approval_received_by==null) ?"" :police_approval_received_by); 
	pstmt.setString(24 ,(police_approval_received_date==null) ?"" :police_approval_received_date); 
	pstmt.setString(25 ,(postmortem_type==null) ?"" :postmortem_type);
	pstmt.setString(26 ,(claim_date_time==null) ?"" :claim_date_time);
	pstmt.setString(27,(refe_type==null) ?"" :refe_type); 
	pstmt.setString(28,(hcare_type==null)?"":hcare_type);
    pstmt.setString(29 ,(mlc_yn ==null)?"" :mlc_yn  ); 
	pstmt.setString(30 ,(pm_yn ==null)?"" :pm_yn  ); 
	pstmt.setString(31 ,(remarks ==null)?"" :remarks  ); 
	pstmt.setString(32 ,(RFID_Tag ==null)?"" :RFID_Tag  ); 
	pstmt.setString(33 ,(postmortem_status ==null)?"" :postmortem_status  ); 
	pstmt.setString(34 ,(atopsyno ==null)?"" :atopsyno  ); 
    pstmt.setString(35,area_code);
	pstmt.setString(36,bed_no);
	/*Added by Thamizh selvi on 3rd Aug 2017 for ML-MMOH-CRF-0689 Start*/
	pstmt.setString(37,(policeOfficerName==null) ?"" :policeOfficerName);
	pstmt.setString(38,(policeContactNo==null) ?"" :policeContactNo);
	/*End*/
			
	 pstmt.executeUpdate();
	
	if(pstmt!=null)pstmt.close();
	}catch(Exception e)
	{	
		e.printStackTrace();
	}

	
	return true; 
 
 
 }

	
  public void insertRegistrationDetails()
  { try
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
		 sql.append("update MO_REGN_NUM_CONTROL set next_num=next_num+1,MODIFIED_BY_ID=?,MODIFIED_DATE=sysdate,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=? where facility_id=?");
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
         
         if (!bed_no.equals(""))
         {
         	sql.setLength(0);
			sql.append("update MO_BED_FOR_AREA set OCCUPYING_PATIENT_ID=?,BLOCKED_YN='N',BLOCKED_UPTO=null,REASON_FOR_BLOCKING=null, MODIFIED_BY_ID=?,MODIFIED_DATE=sysdate,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=?,registration_no=? where area_code=? and bed_no=? and facility_id = ? and OCCUPYING_PATIENT_ID is null and registration_no is null and EFF_STATUS='E' ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1,patient_id  );
			pstmt.setString(2,modified_by_id);
			pstmt.setString(3,modified_at_ws_no);
			pstmt.setString(4,modified_facility_id==null?"" :modified_facility_id);
			pstmt.setString(5,registration_no);
			pstmt.setString(6,area_code);
			pstmt.setString(7,bed_no);
			pstmt.setString(8,facility_id);
			
             pstmt.executeUpdate();
             if(pstmt!=null) pstmt.close();
        }
       }catch(Exception e)
	  {
			e.printStackTrace();
	  }
  }




   public boolean collectOrderBurialPermitDetails()
   {
	try
	   {
	    sql.setLength(0);
		//sql.append("select ORDER_ID, ORD_DATE_TIME, PRACTITIONER_ID, ORDER_CATALOG_CODE   from mo_manage_deceased_vw where patient_id=? and facility_id=? and POSTMORTEM_TYPE=? ");
		sql.append("select PRACTITIONER_ID  from mo_manage_deceased_vw where patient_id=? and facility_id=? and POSTMORTEM_TYPE=? ");
		pstmt = con.prepareStatement(sql.toString());
		pstmt.setString(1,patient_id);
		pstmt.setString(2,facility_id);
		pstmt.setString(3,postmortem_type);
		rs=pstmt.executeQuery();
		if(rs.next())
		{ //order_id=rs.getString("ORDER_ID");
		  //ord_date_time=rs.getString("ORD_DATE_TIME");
		  practitioner_id=rs.getString("PRACTITIONER_ID"); 
		  //order_catalog_code=rs.getString("ORDER_CATALOG_CODE"); 
		  postmortem_status="R"; 	   
		}
    	
		if(pm_yn.equals("Y"))
		{
		  burial_permit_app_by ="";
		  burial_app_date=""; 
		  vechile_no="";
		  body_burial_permit_no=""; 
		}else if(body_burial_permit_no.equals(""))
		{
			
			if((body_part_obtained_from.equals("D")||body_part_obtained_from.equals("A"))&&burial_permit_app_by.equals(""))
		{
		}else{
		  sql.setLength(0);
		  sql.append("Select NEXT_BURIAL_PERMIT_NO from MO_parameter where facility_id='"+facility_id+"'");
		  pstmt = con.prepareStatement(sql.toString());
		  rs=pstmt.executeQuery();
		  if(rs.next())
		   {
		      body_burial_permit_no=rs.getString(1);
		    }
		   sql.setLength(0);
		 if(rs!=null)rs.close();
		if(pstmt!=null)pstmt.close();
		sql.append("update MO_PARAMETER SET NEXT_BURIAL_PERMIT_NO=NEXT_BURIAL_PERMIT_NO+1,MODIFIED_BY_ID=?,MODIFIED_DATE=sysdate,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=? where facility_id=? ");
       
		pstmt = con.prepareStatement(sql.toString());
		pstmt.setString(1,modified_by_id);
		pstmt.setString(2,modified_at_ws_no);
		pstmt.setString(3,modified_facility_id==null?"" :modified_facility_id);
		pstmt.setString(4,facility_id);
		pstmt.executeUpdate();
		if(pstmt!=null)pstmt.close(); 
		}}
		if(rs!=null)rs.close();
		if(pstmt!=null)pstmt.close();
		
		sql.setLength(0);
		sql.append("select  burial_permit_no from mo_mortuary_regn where  BURIAL_PERMIT_NO=? and  facility_id='"+facility_id+"'");
		pstmt = con.prepareStatement(sql.toString());
		pstmt.setString(1,body_burial_permit_no);
		rs=pstmt.executeQuery();
		if(rs.next())
		{ 
		  return false;
		}
 if(pstmt!=null)pstmt.close();
 if(rs!=null)rs.close();		
     }catch(Exception e)
	   {
		 e.printStackTrace();
	   }
 
	  return true; 
  }




	
public void storeBodypartDetails()
{  try
	{
      strToken1= new StringTokenizer(bodypartorgans,"|");
	  if(strToken1!=null)
	   {
	     sql.setLength(0);	
		 sql.append("insert into MO_BODY_PART_REGN(FACILITY_ID,REGISTRATION_NO,BODY_PART_CODE, ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID) values(?,?,?,?,sysdate,?,?)");
		
		 pstmt = con.prepareStatement(sql.toString());
		 while(strToken1.hasMoreElements())
		 {
		 String bodypart=(String)strToken1.nextElement();
		 if(bodypart!="")
		 {
         pstmt.setString(1,facility_id);
		 pstmt.setString(2,(registration_no==null)?"" :registration_no);
		 pstmt.setString(3,(bodypart==null)?"" :bodypart);
		 pstmt.setString(4,(added_by_id==null) ?"" :added_by_id);
		 pstmt.setString(5,(added_at_ws_no==null) ?"" :added_at_ws_no);
		 pstmt.setString(6,(added_facility_id==null) ?"" :added_facility_id);
		
		 pstmt.executeUpdate();
		 }  
		 }
		}  

       /* strToken1= new StringTokenizer(organdonation,"|");
		if(pstmt!=null)pstmt.close();
		if(strToken1!=null)
		 {
		 sql.setLength(0);	
		 sql.append("insert into MO_ORGAN_DONATION_REGN(FACILITY_ID,REGISTRATION_NO,ORGAN_CODE, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) values(?,?,?,?,sysdate,?,?,?,sysdate,?,?)");
		pstmt = con.prepareStatement(sql.toString());
		 while(strToken1.hasMoreElements())
		 {
		   String organs=(String)strToken1.nextElement();
		
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
			
			
		}*/
	  	 sql.setLength(0);	
		if(pstmt!=null)pstmt.close();
		 
		 
		 //Insert Query Modified Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg
		 if(!CLAIMANT_TYPE.equals(""))
		 {
		 sql.append("insert into MO_CLAIMANT(FACILITY_ID,REGISTRATION_NO,CLAIMANT_TYPE, CLAIMANT_TYPE_CODE, RELATIONSHIP, NAME, JOB_TITLE, ADD_LINE1, ADD_LINE2, ADD_LINE3, ADD_LINE4, ZIP_CODE, COUNTRY_CODE,TELEPHONE_OFF, TELEPHONE_RES, EMAIL_ID, MOB_TEL_NO, NAT_ID_NO, ORGANIZATION_NAME, PATIENT_EMPLOYEE_ID, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,RES_TOWN_CODE,RES_AREA_CODE,REGION_CODE,RELEASE_TO_FACILITY, REASON, PASSPORT_NO, OTHER_IDENTIFICATION) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?,?,?,?,?,?,?)");
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
		  pstmt.setString(30 ,(RELEASE_TO_FACILITY==null) ?"" :RELEASE_TO_FACILITY); //Added Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg		  
		  pstmt.setString(31 ,(reason_desc==null) ?"" :reason_desc); //Added this Bru-HIMS-CRF-366 [IN-039612] 
		  
		  //Added by Ashwini on 24-Jul-2017 for ML-MMOH-CRF-0743
		  pstmt.setString(32,(PASSPORT_NO==null)?"" :PASSPORT_NO);
		  pstmt.setString(33,(OTHER_IDENTIFICATION==null)?"" :OTHER_IDENTIFICATION);

		 pstmt.executeUpdate();
		 
		 }
		 
		 if(pstmt!=null)pstmt.close();

	}catch(Exception e)
	{
		e.printStackTrace();
	}
}




public boolean storeInMORegn()
{try
	{
	//sql1.append("insert into MO_MORTUARY_REGN(FACILITY_ID,REGISTRATION_NO,ENCOUNTER_ID,PATIENT_ID,REF_SOURCE_CODE,REFERRED_BY,UNCLAIMED_BODY_YN,BODY_RECEIVED_DATE,HIGH_RISK_BODY_YN,MLC_YN,BROUGHT_BY_POLICE_YN,SERVICE_CODE,PM_YN,POSTMORTEM_TYPE,AREA_CODE,BED_NO,ASSIGN_DATE_TIME,POL_REP_NO,POL_STN_ID,POL_ID,POLICE_DTLS,POLICE_APPROVAL_RECEIVED_YN,POLICE_APPROVAL_RECEIVED_BY,POLICE_APPROVAL_RECEIVED_DATE,CONSENT_GIVEN_BY,RELATIONSHIP_WITH_DECEASED,CONSENT_FORM_CODE,CONSENT_FORM_RECEIVED_BY,CONSENT_FORM_RECEIVED_DATE,BODY_PART_OBTAINED_FROM,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,POSTMORTEM_STATUS,MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,BURIAL_PERMIT_NO,BURIAL_PERMIT_APPROVED_BY,BURIAL_PERMIT_APPROVED_DATE,VEHICLE_NUM,AUTOPSY_NO,CLAIM_DATE_TIME,REFERRAL_TYPE,ORDER_ID,ORD_DATE_TIME,PM_REQUESTED_BY,ORDER_CATALOG_CODE,HCARE_SETTING_TYPE,remarks,RFID_TAG_NUM)values(?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy hh24:mi'),?,?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy hh24:mi'),?,?,?,?,?,?,to_date(?,'dd/mm/yyyy hh24:mi'),?,?,?,?,to_date(?,'dd/mm/yyyy hh24:mi'),?,?,sysdate,?,?,?,?,sysdate,?,?,?,?,to_date(?,'dd/mm/yyyy hh24:mi'),?,?,to_date(?,'dd/mm/yyyy hh24:mi'),?,?,to_date(?,'dd/mm/yyyy hh24:mi'),?,?,?,?,?)");
	
	sql1.append("insert into MO_MORTUARY_REGN(FACILITY_ID,REGISTRATION_NO,ENCOUNTER_ID,PATIENT_ID,REF_SOURCE_CODE,REFERRED_BY,UNCLAIMED_BODY_YN,BODY_RECEIVED_DATE,HIGH_RISK_BODY_YN,MLC_YN,BROUGHT_BY_POLICE_YN,SERVICE_CODE,PM_YN,POSTMORTEM_TYPE,AREA_CODE,BED_NO,ASSIGN_DATE_TIME,POL_REP_NO,POL_STN_ID,POL_ID,POLICE_DTLS,POLICE_APPROVAL_RECEIVED_YN,POLICE_APPROVAL_RECEIVED_BY,POLICE_APPROVAL_RECEIVED_DATE,CONSENT_GIVEN_BY,RELATIONSHIP_WITH_DECEASED,CONSENT_FORM_CODE,CONSENT_FORM_RECEIVED_BY,CONSENT_FORM_RECEIVED_DATE,BODY_PART_OBTAINED_FROM,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,POSTMORTEM_STATUS,MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,BURIAL_PERMIT_NO,BURIAL_PERMIT_APPROVED_BY,BURIAL_PERMIT_APPROVED_DATE,VEHICLE_NUM,AUTOPSY_NO,CLAIM_DATE_TIME,REFERRAL_TYPE,PM_REQUESTED_BY,HCARE_SETTING_TYPE,remarks,RFID_TAG_NUM,police_officer_name,police_contact_no,external_body_part_yn)values(?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy hh24:mi'),?,?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy hh24:mi'),?,?,?,?,?,?,to_date(?,'dd/mm/yyyy hh24:mi'),?,?,?,?,to_date(?,'dd/mm/yyyy hh24:mi'),?,?,sysdate,?,?,?,?,sysdate,?,?,?,?,to_date(?,'dd/mm/yyyy hh24:mi'),?,?,to_date(?,'dd/mm/yyyy hh24:mi'),?,?,?,?,?,?,?,?)");//Modified by Thamizh selvi on 3rd Aug 2017 for ML-MMOH-CRF-0689
	pstmt = con.prepareStatement(sql1.toString());   
	
	pstmt.setString(1 ,(facility_id==null)?"" :facility_id);   
	pstmt.setString(2 ,(registration_no==null)?"" :registration_no);  
	pstmt.setString(3 ,(encounter_id==null)?"" :encounter_id);  
	pstmt.setString(4 ,(patient_id==null)?"" :patient_id); 
	pstmt.setString(5 ,(referral_source==null) ?"" :referral_source);
	pstmt.setString(6 ,(referral_by==null) ?"" :referral_by);
	pstmt.setString(7 ,(unclaimedbodyyn==null||unclaimedbodyyn.equals("")) ?"N" :unclaimedbodyyn);
	pstmt.setString(8,(body_received_date==null) ?"" :body_received_date	);   	               
	pstmt.setString(9 ,(high_risk_body_yn==null||high_risk_body_yn.equals("")) ?"N" :high_risk_body_yn);
	pstmt.setString(10 ,(mlc_yn ==null)?"" :mlc_yn  ); 
	pstmt.setString(11 ,(brought_by_police_yn		 ==null)?"" :brought_by_police_yn	);  
	pstmt.setString(12,(service_code==null) ?"" :service_code	); 
	pstmt.setString(13 ,(pm_yn ==null)?"" :pm_yn ); 
	pstmt.setString(14 ,(postmortem_type==null) ?"" :postmortem_type);
	pstmt.setString(15 ,(area_code==null) ?"" :area_code	);  
	pstmt.setString(16 ,(bed_no==null) ?"" :bed_no); 	                                           
	pstmt.setString(17 ,(assign_date_time==null) ?"" :assign_date_time	);   	                  
	pstmt.setString(18,(pol_rep_no==null) ?"" :pol_rep_no); 
	pstmt.setString(19,(pol_stn_id==null) ?"" :pol_stn_id); 
	pstmt.setString(20,(pol_id==null )?"" :pol_id); 
	pstmt.setString(21 , (police_dtls==null )?"" :police_dtls); 
	pstmt.setString(22,(police_approval_received_yn==null)||police_approval_received_yn.equals("") ?"N" :police_approval_received_yn); 
	pstmt.setString(23,(police_approval_received_by==null) ?"" :police_approval_received_by); 
	pstmt.setString(24,(police_approval_received_date==null) ?"" :police_approval_received_date);
	pstmt.setString(25 ,(consent_given_by==null) ?"" :consent_given_by);
	pstmt.setString(26 ,(relationship_with_deceased==null) ?"" :relationship_with_deceased);
	pstmt.setString(27,(consent_form_code==null) ?"" :consent_form_code	);                      
	pstmt.setString(28,(consent_form_received_by==null) ?"" :consent_form_received_by	);         
	pstmt.setString(29,(consent_form_received_date==null) ?"" :consent_form_received_date	);     
	pstmt.setString(30,(body_part_obtained_from==null) ?"" :body_part_obtained_from	);     
	pstmt.setString(31 ,(added_by_id==null) ?"" :added_by_id	);                                                    
	pstmt.setString(32 ,(added_at_ws_no==null) ?"" :added_at_ws_no	);                                    
	pstmt.setString(33 ,(added_facility_id==null) ?"" :added_facility_id	);
	pstmt.setString(34 ,(postmortem_status==null) ?"" :postmortem_status	);
	pstmt.setString(35 ,(modified_by_id==null) ?"" :modified_by_id	);                            
	pstmt.setString(36 ,(modified_at_ws_no==null) ?"" :modified_at_ws_no	);                    
	pstmt.setString(37 ,(modified_facility_id==null) ?"" :modified_facility_id);                
	pstmt.setString(38,(body_burial_permit_no.equals(""))?"" :body_burial_permit_no); 
	pstmt.setString(39 ,(burial_permit_app_by==null) ?"" :burial_permit_app_by); 
	pstmt.setString(40 ,(burial_app_date==null) ?"" :burial_app_date); 
	pstmt.setString(41 ,(vechile_no==null) ?"" :vechile_no); 
	pstmt.setString(42,(atopsyno==null) ?"" :atopsyno); 
	pstmt.setString(43,(claim_date_time==null) ?"" :claim_date_time); 
	pstmt.setString(44,(refe_type==null) ?"" :refe_type); 
	//pstmt.setString(45,(order_id==null) ?"" :order_id); 
	//pstmt.setString(46,(ord_date_time==null) ?"" :ord_date_time); 
	pstmt.setString(45,(practitioner_id==null) ?"" :practitioner_id); 
	//pstmt.setString(48,(order_catalog_code==null) ?"" :order_catalog_code);
	pstmt.setString(46,(hcare_type==null)?"":hcare_type);
	pstmt.setString(47,(remarks==null)?"":remarks);
	pstmt.setString(48,(RFID_Tag==null)?"":RFID_Tag);
	/*Added by Thamizh selvi on 3rd Aug 2017 for ML-MMOH-CRF-0689 Start*/
	pstmt.setString(49,(policeOfficerName==null)?"":policeOfficerName);
	pstmt.setString(50,(policeContactNo==null)?"":policeContactNo);
	pstmt.setString(51,externalBodyPartYn);
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
	
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
		
return result;
}

public void extractValues() // to extract values from the has table
	{
		try
		{ 
		facility_id	                         =(String)hashtable.get("FACILITY_ID");        
		registration_no                      =(String)hashtable.get("REGISTRATION_NO");  
		encounter_id	                     =(String)hashtable.get("ENCOUNTER_ID");        	   patient_id		                     =(String)hashtable.get("PATIENT_ID");        		   
		mlc_yn                               =(String)hashtable.get("MLC_YN");    
		pm_yn			                     =(String)hashtable.get("PM_YN");        		       
		//death_certificate_reqd_yn		     =( String)hashtable.get("DEATH_CERTIFICATE_REQD_YN");
		brought_by_police_yn			     =(String)hashtable.get("BROUGHT_BY_POLICE_YN");  
		police_dtls		                     =(String)hashtable.get("POLICE_DTLS");        	
		pol_rep_no	  		                 =(String)hashtable.get("POL_REP_NO");        	
		pol_stn_id		                     =(String)hashtable.get("POL_STN_ID");     
		pol_id		                         =(String)hashtable.get("POL_ID");     
		service_code			             =(String)hashtable.get("SERVICE_CODE");   
		consent_form_code                    =(String)hashtable.get("CONSENT_FORM_CODE"); 
		consent_form_received_by	         =  (String)hashtable.get("CONSENT_FORM_RECEIVED_BY"); consent_form_received_date			 =(String)hashtable.get("CONSENT_FORM_RECEIVED_DATE"); consent_form_received_by	         =(String)hashtable.get("CONSENT_FORM_RECEIVED_BY");   
		consent_form_received_date			 =(String)hashtable.get("CONSENT_FORM_RECEIVED_DATE"); 
		police_approval_received_yn			 =(String)hashtable.get("POLICE_APPROVAL_RECEIVED_YN"); 
		police_approval_received_by			 =(String)hashtable.get("POLICE_APPROVAL_RECEIVED_BY"); 
		police_approval_received_date	     =(String)hashtable.get("POLICE_APPROVAL_RECEIVED_DATE"); body_received_date		                =(String)hashtable.get("BODY_RECEIVED_DATE");      
		area_code	                         =(String)hashtable.get("AREA_CODE");  
		assign_date_time		             =(String)hashtable.get("ASSIGN_DATE_TIME");        
		postmortem_status		             =(String)hashtable.get("POSTMORTEM_STATUS");       
		added_at_ws_no	                     =(String)hashtable.get("ADDED_AT_WS_NO");        
		added_facility_id 	 	             =(String)hashtable.get("ADDED_FACILITY_ID");     
		added_by_id		                     =(String)hashtable.get("ADDED_BY_ID");        
		modified_by_id		                 =(String)hashtable.get("MODIFIED_BY_ID");        
		modified_at_ws_no		             =(String)hashtable.get("MODIFIED_AT_WS_NO");
		bed_no			                     =(String)hashtable.get("BED_NO");
		modified_facility_id 	 	         =(String)hashtable.get("MODIFIED_FACILITY_ID"); 
		high_risk_body_yn                    =(String)hashtable.get("HIGH_RISK_BODY_YN");     
		postmortem_type                      =(String)hashtable.get("POSTMORTEM_TYPE");       
		consent_given_by                     =(String)hashtable.get("CONSENT_GIVEN_BY");     
		relationship_with_deceased           = (String)hashtable.get("RELATIONSHIP_WITH_DECEASED"); referral_source                        =(String)hashtable.get("REF_SOURCE_CODE");     
		referral_by                          =(String)hashtable.get("REFERRED_BY"); 
		hcare_type							 =(String)hashtable.get("hcare_type");
		unclaimedbodyyn                      =(String)hashtable.get("UNCLAIMED_BODY_YN");     
//		organdonation                        =(String)hashtable.get("organdonation");     
		regn_no                              =(String)hashtable.get("regn_no");   
		CLAIMANT_TYPE                        =(String)hashtable.get("CLAIMANT_TYPE");     
		CLAIMANT_TYPE_CODE                   =(String)hashtable.get("CLAIMANT_TYPE_CODE");     
		RELATIONSHIP                         =(String)hashtable.get("RELATIONSHIP");     
		NAME                                 =(String)hashtable.get("NAME");     
		remarks                              =(String)hashtable.get("remarks");     
		RFID_Tag                              =(String)hashtable.get("RFID_Tag");     
		res_town_code						 =(String)hashtable.get("res_town_code");
		res_area_code						 =(String)hashtable.get("res_area_code");
        region_code                          =(String)hashtable.get("region_code"); 
		JOB_TITLE                            =(String)hashtable.get("JOB_TITLE");               
		ADD_LINE1=(String)hashtable.get("ADD_LINE1");               
		ADD_LINE2=(String)hashtable.get("ADD_LINE2");               
		ADD_LINE3=(String)hashtable.get("ADD_LINE3");               
		ADD_LINE4=(String)hashtable.get("ADD_LINE4");               
		ZIP_CODE=(String)hashtable.get("ZIP_CODE");                
		COUNTRY_CODE=(String)hashtable.get("COUNTRY_CODE");           
		TELEPHONE_OFF =(String)hashtable.get("TELEPHONE_OFF");          
		TELEPHONE_RES=(String)hashtable.get("TELEPHONE_RES");           
		EMAIL_ID =(String)hashtable.get("EMAIL_ID");               
		MOB_TEL_NO=(String)hashtable.get("MOB_TEL_NO");              
		NAT_ID_NO =(String)hashtable.get("NAT_ID_NO");              
		ORGANIZATION_NAME=(String)hashtable.get("ORGANIZATION_NAME");       
		PATIENT_EMPLOYEE_ID=(String)hashtable.get("PATIENT_EMPLOYEE_ID");  
		
		//Added by Ashwini on 24-Jul-2017 for ML-MMOH-CRF-0743
		PASSPORT_NO=(String)hashtable.get("PASSPORT_NO"); 
		OTHER_IDENTIFICATION=(String)hashtable.get("OTHER_IDENTIFICATION"); 

		vechile_no=(String)hashtable.get("VEHICLE_NUM");     
		burial_permit_app_by=(String)hashtable.get("BURIAL_PERMIT_APPROVED_BY");     
		burial_app_date=(String)hashtable.get("BURIAL_PERMIT_APPROVED_DATE");     
		body_burial_permit_no=(String)hashtable.get("body_burial_permit_no");     
		body_part_obtained_from=(String)hashtable.get("body_part_obtained_from");
		claim_date_time=(String)hashtable.get("CLAIM_DATE_TIME");
		refe_type=(String)hashtable.get("refe_type");
		bodypartorgans=(String)hashtable.get("organ");
		RELEASE_TO_FACILITY=(String)hashtable.get("RELEASE_TO_FACILITY"); //Added Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg
		reason_desc=(String)hashtable.get("reason_desc"); //Added this CRF Bru-HIMS-CRF-366 [IN-039612]
		/*Added by Thamizh selvi on 3rd Aug 2017 for ML-MMOH-CRF-0689 Start*/
		policeOfficerName	= (String)hashtable.get("policeOfficerName");
		policeContactNo		= (String)hashtable.get("policeContactNo");
		calledFrom			= (String)hashtable.get("calledFrom");
		if (calledFrom.equals("MO_EBP_REGN"))
			externalBodyPartYn = "Y";
		else
			externalBodyPartYn = "N";
		/*End*/
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
			String duplicateSql = "select count(*) from MO_MORTUARY_REGN where FACILITY_ID=? and REGISTRATION_NO=?" ;
			pstmt = con.prepareStatement(duplicateSql) ;
			pstmt.setString(1,facility_id) ;
			pstmt.setString(2,registration_no) ;
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
			 
			  message = MessageManager.getMessage( locale, "CODE_ALREADY_EXISTS","Common" ) ;
			 sb.append( (String) message.get("message") ) ;
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
