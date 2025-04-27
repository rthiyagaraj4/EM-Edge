/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMO.ManageDeceased;
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
*	name="ManageDeceased"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="ManageDeceased"
*	local-jndi-name="ManageDeceased"
*	impl-class-name="eMO.ManageDeceased.MOManageDeceasedManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eMO.ManageDeceased.MOManageDeceasedLocal"
*	remote-class="eMO.ManageDeceased.MOManageDeceasedRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eMO.ManageDeceased.MOManageDeceasedLocalHome"
*	remote-class="eMO.ManageDeceased.MOManageDeceasedHome"
*	generate= "local,remote"
*
*
*/

public class MOManageDeceasedManager implements SessionBean
{ 
	SessionContext ctx;
	Connection con ;
	PreparedStatement pstmt ; 
	Properties	p ;
	public final String RECORD_INSERTED		= "RECORD_INSERTED" ;
	
StringBuffer  sb			=new StringBuffer();
String facility_id									 = "";				                       
String patient_id									 = "";
String pmstatus										 = "";
String area_code									 = "";
String new_bed_no									 = "";
String old_bed_no								     ="";
String assign_tmt_area_time							 = "";
String RFID_Tag							 = "";
String receiveTimestamp								 = "";
String modifiedById									 = "";
String modifiedFacilityId							 = "";
String modifiedAtWorkstation						 = "";
String donatedorgan                                  ="";            
String tissue_procured_by                             ="";
//String tissue_procure_performed_da                     ="";
String pm_requested_by                                 =""; 
String PM_PURPOSE                 		               =""; 
String pract1                     			           =""; 
String pract2                                          ="";  
String pract3                     			           =""; 
String pract4                     			           =""; 
String pract5                                          =""; 
String role1                      			           =""; 
String role2                      			           =""; 
String role3                                           =""; 
String role4                      			           =""; 
String role5                      			           =""; 
String pract6			                               =""; 
String pract7			  		 	                   =""; 
String desi1			  			                   =""; 
String desi2			                               =""; 
String pm_start_date_time	  			               =""; 
String pract9                                          =""; 
String mr_diagnosis_code          			           =""; 
String mr_diagnosis_code1         			           =""; 
String mr_diagnosis_code2                              =""; 
String mr_diagnosis_code3                              =""; 
String mr_diagnosis_code4                              =""; 
String mr_diagnosis_code5                              =""; 
String mr_diagnosis_code6                              ="";  	// BRU-HIMS-CRF-270
String mr_diagnosis_code7                              ="";		// BRU-HIMS-CRF-270		

String mr_diagnosis_desc          			           =""; 
String mr_diagnosis_desc1         			           =""; 
String mr_diagnosis_desc2                              =""; 
String mr_diagnosis_desc3                              =""; 
String mr_diagnosis_desc4                              =""; 
String mr_diagnosis_desc5                              =""; 
String mr_diagnosis_desc6                              =""; 	// BRU-HIMS-CRF-270
String mr_diagnosis_desc7                              =""; 	// BRU-HIMS-CRF-270
String onset_date1                                     =""; 
String onset_date2                                     =""; 
String onset_date3					                   =""; 
String onset_date4                                     =""; 
String onset_date5                                     =""; 
String onset_date6                                     =""; 
// BRU-HIMS-CRF-270
String onset_date7                                     =""; 	
String onset_date8                                     =""; 	
String cause_remarks1                                  =""; 
String cause_remarks2                                  =""; 
String cause_remarks3					               =""; 
String cause_remarks4                                  =""; 
String cause_remarks5                                  =""; 
String cause_remarks6                                  =""; 
// BRU-HIMS-CRF-270 END HERE
String manner_of_death                                 =""; 
String postmortem_findings                             =""; 
String speci_desc1                                     =""; 
String speci_desc2                                     =""; 
String speci_desc3                                     =""; 
String speci_desc4                                     =""; 
String speci_desc5                                     =""; 
String speci_desc6                                     =""; 
String speci_type1                                     =""; 
String speci_type2                                     =""; 
String speci_type3                                     =""; 
String speci_type4                                     =""; 
String speci_type5                                     =""; 
String speci_type6                                     =""; 
String anotomical_site_code1                           =""; 
String anotomical_site_code2                           =""; 
String anotomical_site_code3                           =""; 
String anotomical_site_code4                           =""; 
String anotomical_site_code5                           =""; 
String anotomical_site_code6                           =""; 
String collection_time1		                           =""; 
String collection_time2                                =""; 
String collection_time3                                =""; 
String collection_time4                                =""; 
String collection_time5                                =""; 
String collection_time6                                =""; 
String spec_collected_by                               =""; 
String spec_handed_over_to                             =""; 
String spec_handed_over_date                           =""; 
String diagscheme                                      =""; 
String registration_no                                 =""; 
String postmortem_finding                              = "";
String pm_end_date_time                                ="";
String role_for_practitioner                           =""; 
String pm_performed_by                                 ="";
String tissue_procure_performed_date                   ="";
String designation1                                    ="";
String designation2                                    ="";
String designation3                                    ="";
ResultSet rs=null;
String locale										   ="";
/*Below line(s) "death_after_potmrtm" variable added by Venkatesh.S on 12-Nov-2013 against Bru-HIMS-CRF-365 [IN:039572]*/
String death_after_potmrtm                             =""; 
String examination_type                                ="";   //added by Mano aganist ML-MMOH-CRF-0791

int	   insert_result		=  0;
java.util.HashMap results	    =null;                      
boolean insertable				= true ;		

  
	/****************************** CALL BACK Functions  ****************************************/
	public void ejbCreate() {}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext( SessionContext context ) {this.ctx = context;}
	/****************************** Function to Insert Value  ****************************************/

/**
* @ejb.interface-method
*	 view-type="both"
*/

public java.util.HashMap modifyReassignArea(Properties properties,HashMap ht) 
	{ 	   
	try 
	{  

		results			= new java.util.HashMap() ;
	       p				= properties  ;
	       con				= ConnectionManager.getConnection(p);
		   locale = p.getProperty("LOCALE");
		   con.setAutoCommit(false);					
	    	area_code			= (String)ht.get("AREA_CODE");
			if(area_code==null)area_code="" ;
			old_bed_no=(String)ht.get("old_bed_no");
			if(old_bed_no==null)old_bed_no="" ;
			new_bed_no				= (String)ht.get("BED_NO");
			if(new_bed_no==null)new_bed_no="";
			assign_tmt_area_time= (String)ht.get("ASSIGN_DATE_TIME");
            if(assign_tmt_area_time==null) assign_tmt_area_time="";
			modifiedById	=  (String)ht.get("MODIFIED_BY_ID");
            if(modifiedById==null) modifiedById="";
		//	modified_date =  (java.sql.Timestamp)ht.get("MODIFIED_DATE");
			modifiedAtWorkstation= (String)ht.get("MODIFIED_AT_WS_NO");
			if(modifiedAtWorkstation==null) modifiedAtWorkstation="";
			modifiedFacilityId=     (String)ht.get("MODIFIED_FACILITY_ID");
            if(modifiedFacilityId==null)modifiedFacilityId="";
			facility_id=(String)ht.get("FACILITY_ID");
			if(facility_id==null) facility_id="";
			registration_no=(String)ht.get("REGISTRATION_NO");
            if(registration_no==null) registration_no="";
			patient_id=(String)ht.get("OCCUPYING_PATIENT_ID");
            if(patient_id==null) patient_id="";
		    
			RFID_Tag=(String)ht.get("RFID_Tag");
            if(RFID_Tag==null) RFID_Tag="";
			
			StringBuffer  sql1=new StringBuffer();

			sql1.append("update MO_MORTUARY_REGN SET AREA_CODE='"+area_code+"',BED_NO='"+new_bed_no+"',ASSIGN_DATE_TIME=to_date('"+assign_tmt_area_time+"','dd/mm/yyyy hh24:mi'),RFID_TAG_NUM='"+RFID_Tag+"',MODIFIED_BY_ID='"+modifiedById+"',MODIFIED_DATE=sysdate,MODIFIED_AT_WS_NO='"+modifiedAtWorkstation+"',MODIFIED_FACILITY_ID='"+modifiedFacilityId+"'  where  FACILITY_ID='"+facility_id+"' and REGISTRATION_NO='"+registration_no+"'");
           
			pstmt = con.prepareStatement(sql1.toString());
			int cnt=pstmt.executeUpdate();
 
			if(cnt == 0)
				 insertable=false;
			else
				insertable=true;

			if (pstmt!=null) pstmt.close();
          
		     
		   
		if(!old_bed_no.equals(new_bed_no)){		
			if(!new_bed_no.equals("")){
				sql1.setLength(0);
				sql1.append("select count(*)cnt from mo_bed_for_area where area_code=? and bed_no=? and facility_id = ? and occupying_patient_id is null and (blocked_yn='N' OR (BLOCKED_YN='Y' AND BLOCKED_UPTO <= SYSDATE))");
				pstmt = con.prepareStatement(sql1.toString());
				pstmt.setString(1,area_code);
				pstmt.setString(2,new_bed_no);
				pstmt.setString(3,facility_id);
				rs=pstmt.executeQuery();
				rs.next();
				if(rs.getInt("cnt")==0){
					con.rollback();								
					 //java.util.Hashtable message = MessageManager.getMessage( con,"VAC_BED_SEL");
					 java.util.Hashtable message = MessageManager.getMessage( locale,"VAC_BED_SEL","MO");			 
					 sb.setLength(0);
					 sb.append( (String) message.get("message") ) ;
					 results.put( "status", new Boolean(false) ) ;
					 results.put( "error", sb.toString() ) ;
					 sql1.setLength(0);
					 sb.setLength(0);
					 message.clear();
					 return results ;
				}
			}
			if(rs!=null)rs.close();
		  }
			if(insertable){   
				if (!old_bed_no.equals("")){
					sql1.setLength(0);
					sql1.append("update MO_BED_FOR_AREA SET OCCUPYING_PATIENT_ID=null,registration_no=null,BLOCKED_YN='N',BLOCKED_UPTO=null,REASON_FOR_BLOCKING=null,MODIFIED_BY_ID='"+modifiedById+"', MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO='"+modifiedAtWorkstation+"', MODIFIED_FACILITY_ID='"+modifiedFacilityId+"'  where  OCCUPYING_PATIENT_ID='"+patient_id+"' and registration_no='"+registration_no+"' and facility_id = '"+facility_id+"'  ");			
					pstmt = con.prepareStatement(sql1.toString());
					pstmt.executeUpdate();
					sql1.setLength(0);			  
			    }
		    }
		   if(pstmt!=null)	pstmt.close();
		
	    if (!new_bed_no.equals(""))
		{
			
			if(insertable)
			{
		  StringBuffer sql = new StringBuffer();
		  sql.append("update MO_BED_FOR_AREA SET OCCUPYING_PATIENT_ID='"+patient_id+"',registration_no='"+registration_no+"',BLOCKED_YN='N',BLOCKED_UPTO=null,REASON_FOR_BLOCKING=null,MODIFIED_BY_ID='"+modifiedById+"', MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO='"+modifiedAtWorkstation+"', MODIFIED_FACILITY_ID='"+modifiedFacilityId+"' where AREA_CODE='"+area_code+"' and BED_NO='"+new_bed_no+"' and facility_id = '"+facility_id+"' and OCCUPYING_PATIENT_ID is null and registration_no is null and EFF_STATUS='E'");
        pstmt = con.prepareStatement(sql.toString());
		
		int i=pstmt.executeUpdate();
		if(pstmt!=null) pstmt.close();
		if(i == 0)
	    insertable=false;
		else
		insertable=true;
		}
		
		
	   }
	  
	  if(insertable)
		{
		
		con.commit();
		sb.setLength(0);
	    //java.util.Hashtable message = MessageManager.getMessage( con, RECORD_INSERTED );
		java.util.Hashtable message = MessageManager.getMessage( locale, "RECORD_INSERTED","SM" );
 	    sb.append( (String) message.get("message") );
	    results.put( "status", new Boolean(true) ) ;
		results.put( "error", sb.toString() ) ;
		message.clear();
		}
	    else
		{
	     con.rollback();
	    		 
		results.put( "status", new Boolean(insertable) ) ;
		results.put( "error", sb.toString() ) ;
		}
	  
		//	}
			//if(rs!=null)rs.close();
	  }
	  catch(Exception e)
	  {
		 e.printStackTrace();
	  } 
	  finally
	  {
		  ConnectionManager.returnConnection(con,p);
	  }
	 ht.clear();	
	  return results;
	 
	 
	 }//end of modifyReassignArea 

/**
* @ejb.interface-method
*	 view-type="both"
*/
public HashMap modifyPMstatusStartArea(Properties properties,HashMap ht) 				
  {
    try 
	{   
		results			= new java.util.HashMap() ;
	     p				= properties  ;
	     con					= ConnectionManager.getConnection(p);
		 locale = p.getProperty("LOCALE");		
	     con.setAutoCommit(false);	
		 extractValues(ht);
         StringBuffer  sql1=new StringBuffer();
		
		/*Below line(s) DEATH_CODE_AFTER_POSTMRM column added by Venkatesh.S on 12-Nov-2013 against Bru-HIMS-CRF-365 [IN:039572]*/
		 //sql1.append("update MO_MORTUARY_REGN SET  pm_requested_by='"+pm_requested_by+"', PM_CERTIFIED_BY='"+pract9+"',ACTUAL_DEATH_MANNER_CODE='"+manner_of_death+"', POSTMORTEM_FINDING='"+postmortem_findings+"',TISSUE_PROCURED_BY='"+tissue_procured_by+"', TISSUE_PROCURE_PERFORMED_DATE=to_date('"+tissue_procure_performed_date+"','dd/mm/yyyy hh24:mi'), SPECIMEN_COLLECTED_BY='"+spec_collected_by+"',SPECIMEN_HANDED_OVER_DATE=to_date('"+spec_handed_over_date+"','dd/mm/yyyy hh24:mi'),SPECIMEN_HANDED_OVER_TO='"+spec_handed_over_to+"', POSTMORTEM_STATUS='"+pmstatus+"',POSTMORTEM_START_DATE_TIME=to_date('"+pm_start_date_time+"','dd/mm/yyyy hh24:mi'),POSTMORTEM_END_DATE_TIME=to_date('"+pm_end_date_time+"','dd/mm/yyyy hh24:mi'),PM_PURPOSE='"+PM_PURPOSE+"', MODIFIED_BY_ID='"+modifiedById+"',MODIFIED_DATE=sysdate,MODIFIED_AT_WS_NO='"+modifiedAtWorkstation+"',MODIFIED_FACILITY_ID='"+modifiedFacilityId+"',PM_PERFORMED_BY='"+pm_performed_by+"',ROLE_FOR_PRACTITIONER='"+role_for_practitioner+"' ,DEATH_CODE_AFTER_POSTMRM='"+death_after_potmrtm+"'	where FACILITY_ID='"+facility_id+"' and REGISTRATION_NO='"+registration_no+"'");
		 
		 /*Below query added by Venkatesh.S on 12-Nov-2013 against Bru-HIMS-CRF-365 [IN:039572]*/
		 /*Below query added by Mano against ML-MMOH-CRF-0791 */
		 
		 sql1.append("update MO_MORTUARY_REGN SET  pm_requested_by='"+pm_requested_by+"', PM_CERTIFIED_BY='"+pract9+"',ACTUAL_DEATH_MANNER_CODE='"+death_after_potmrtm+"', POSTMORTEM_FINDING='"+postmortem_findings+"',TISSUE_PROCURED_BY='"+tissue_procured_by+"', TISSUE_PROCURE_PERFORMED_DATE=to_date('"+tissue_procure_performed_date+"','dd/mm/yyyy hh24:mi'), SPECIMEN_COLLECTED_BY='"+spec_collected_by+"',SPECIMEN_HANDED_OVER_DATE=to_date('"+spec_handed_over_date+"','dd/mm/yyyy hh24:mi'),SPECIMEN_HANDED_OVER_TO='"+spec_handed_over_to+"', POSTMORTEM_STATUS='"+pmstatus+"',POSTMORTEM_START_DATE_TIME=to_date('"+pm_start_date_time+"','dd/mm/yyyy hh24:mi'),POSTMORTEM_END_DATE_TIME=to_date('"+pm_end_date_time+"','dd/mm/yyyy hh24:mi'),PM_PURPOSE='"+PM_PURPOSE+"', MODIFIED_BY_ID='"+modifiedById+"',MODIFIED_DATE=sysdate,MODIFIED_AT_WS_NO='"+modifiedAtWorkstation+"',MODIFIED_FACILITY_ID='"+modifiedFacilityId+"',PM_PERFORMED_BY='"+pm_performed_by+"',ROLE_FOR_PRACTITIONER='"+role_for_practitioner+"',DEATH_MANNER_CODE='"+manner_of_death+"',EXAMINATION_TYPE='"+examination_type+"' where FACILITY_ID='"+facility_id+"' and REGISTRATION_NO='"+registration_no+"'");
		
         pstmt = con.prepareStatement(sql1.toString());
		 int cnt=pstmt.executeUpdate();
		 if(cnt == 0)
		  insertable=false;
		  else
		  insertable=true;
		 if(pstmt!=null) pstmt.close();
     
	     if(insertable)
	     {	insertable= recordPostmortemTeam();
		 
		 }
     if(insertable)
	 {  
		 insertable= recordWitnessTeam();
	 }
		 
	 if(insertable)
	 {    insertable= recordDiagnosis();
	 }
	 if(insertable)
	 {  
	 StringTokenizer  strToken1= new StringTokenizer(donatedorgan,"|");

	   if(strToken1!=null)
		 {StringBuffer	Organrecord		=	new StringBuffer( "" ) ; 
		 // sql.setLength(0);	
		 Organrecord.append("update MO_ORGAN_DONATION_REGN set TISSUE_PROCURED_YN=?,TISSUE_PROCUREMENT_DATE=to_date(?,'dd/mm/yyyy hh24: mi'),MODIFIED_BY_ID=?,MODIFIED_DATE=sysdate,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=?  where registration_no=? and organ_code=? and facility_id=?");
		String organs="";
		String tissueprocdate="";
		 String check="";
		 pstmt = con.prepareStatement(Organrecord.toString());
		 while(strToken1.hasMoreElements())
		 {
		    organs=(String)strToken1.nextElement();
		    tissueprocdate=(String)strToken1.nextElement();
		  
			if(tissueprocdate.equals("N"))
			 {check="N";
			 tissueprocdate="";
			}
			else {check="Y";
			 }
        
		 if(!organs.equals(""))
		 {
        
		 pstmt.setString(1,check);
         pstmt.setString(2,(tissueprocdate==null) ?"" :tissueprocdate);                          
		 pstmt.setString(3,(modifiedById==null) ?"" :modifiedById	);
		 pstmt.setString(4,(modifiedAtWorkstation==null) ?"" :modifiedAtWorkstation	);                  pstmt.setString(5,(modifiedFacilityId==null) ?"" :modifiedFacilityId);                     
		 pstmt.setString(6,(registration_no==null)?"" :registration_no);
		 pstmt.setString(7,(organs==null)?"" :organs);
		 pstmt.setString(8,facility_id);
		 pstmt.executeUpdate();
		 
		
		 }  
		
		
	 
	 
	 }

	 
		 }
	 }
	 if(pstmt!=null)pstmt.close();
	 if(insertable)
	 {  
		recordSpecimenCollection();
	  }
	 


	  
	 
	 


	   if(pstmt!=null)pstmt.close();
	   if(insertable)
		{
		con.commit();
		sb.setLength(0);
	    java.util.Hashtable message = MessageManager.getMessage( locale,"RECORD_INSERTED","SM" ) ;
 	    sb.append( (String) message.get("message") ) ;
	    results.put( "error", sb.toString() ) ;
		results.put( "status", new Boolean(insertable) ) ;
		message.clear();
		}
	   else
	     con.rollback();
	   			 
		results.put( "status", new Boolean(insertable) ) ;
		results.put( "error", sb.toString() ) ;
	 
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 } 
	 finally
	 {
		  ConnectionManager.returnConnection(con,p);
	 }
	 ht.clear();
	  return results;
 
 
 }		

/**
* @ejb.interface-method
*	 view-type="both"
*/
public java.util.HashMap modifyPMstatusEndArea(Properties properties,HashMap ht) 		 
  {
    try 
	{
	       results			= new java.util.HashMap() ;
	       
	       p				= properties  ;
		   con					= ConnectionManager.getConnection(p);
		   locale = p.getProperty("LOCALE");
		   con.setAutoCommit(false);					
       pmstatus= (String)ht.get("POSTMORTEM_STATUS");
	   if(pmstatus==null)pmstatus="" ;
	   postmortem_finding = (String)ht.get("POSTMORTEM_FINDING");
	   if(postmortem_finding==null) postmortem_finding="" ;
	   receiveTimestamp = (String)ht.get("POSTMORTEM_END_DATE_TIME");
	   modifiedById= (String)ht.get("MODIFIED_BY_ID");
	   if(modifiedById==null)modifiedById="" ;
		//modified_date	=  (java.sql.Timestamp)ht.get("MODIFIED_DATE");
       modifiedAtWorkstation	=  (String)ht.get("MODIFIED_AT_WS_NO");
	   if(modifiedAtWorkstation==null)modifiedAtWorkstation="" ;
	   modifiedFacilityId	=  (String)ht.get("MODIFIED_FACILITY_ID");
	   if(modifiedFacilityId==null)modifiedFacilityId="" ;
       facility_id= (String)ht.get("FACILITY_ID");
	   if(facility_id==null)facility_id="" ;
	   registration_no	=  (String)ht.get("REGISTRATION_NO");
	   if(registration_no==null)registration_no="" ;
       StringBuffer  sql1=new StringBuffer();

			sql1.append("update MO_MORTUARY_REGN SET POSTMORTEM_STATUS='"+pmstatus+"',POSTMORTEM_END_DATE_TIME=to_date('"+receiveTimestamp+"','dd/mm/yyyy hh24:mi'),POSTMORTEM_FINDING='"+postmortem_finding+"',PM_PERFORMED_BY='"+pm_performed_by+"',ROLE_FOR_PRACTITIONER='"+role_for_practitioner+"',MODIFIED_BY_ID='"+modifiedById+"',MODIFIED_DATE=sysdate,MODIFIED_AT_WS_NO='"+modifiedAtWorkstation+"',MODIFIED_FACILITY_ID='"+modifiedFacilityId+"'			where  FACILITY_ID='"+facility_id+"' and REGISTRATION_NO='"+registration_no+"'");

           pstmt = con.prepareStatement(sql1.toString());
			
			int cnt=pstmt.executeUpdate();
			if(cnt == 0)
				 insertable=false;
			else
				insertable=true;
			if(pstmt!=null) pstmt.close();

       if(insertable)
		{
		con.commit();
		sb.setLength(0);
	    java.util.Hashtable message = MessageManager.getMessage( locale, "RECORD_INSERTED","SM" ) ;
 	    sb.append( (String) message.get("message") ) ;
	    message.clear();
		}
	    else
	     con.rollback();
	   			 
		results.put( "status", new Boolean(insertable) ) ;
		results.put( "error", sb.toString() ) ;
	  }
	 catch(Exception e)
	  {
		 e.printStackTrace();
	  }
	  finally
	  {
		  ConnectionManager.returnConnection(con,p);
	  }
	 ht.clear();
	  return results;
 
 }		
/**
* @ejb.interface-method
*	 view-type="both"
*/
public java.util.HashMap  modifyPMstatusCancelArea(Properties properties,HashMap ht) 	 
  {
    try 
	{
	   results			= new java.util.HashMap() ;
	   p				= properties  ;
	   con					= ConnectionManager.getConnection(p);
	   locale = p.getProperty("LOCALE");
	   con.setAutoCommit(false);					

	   pmstatus= (String)ht.get("POSTMORTEM_STATUS");
	   if(pmstatus==null)pmstatus="" ;
	   modifiedById= (String)ht.get("MODIFIED_BY_ID");
	   if(modifiedById==null)modifiedById="" ;
		//modified_date	=  (java.sql.Timestamp)ht.get("MODIFIED_DATE");
       modifiedAtWorkstation	=  (String)ht.get("MODIFIED_AT_WS_NO");
	   if(modifiedAtWorkstation==null)modifiedAtWorkstation="" ;
	   modifiedFacilityId	=  (String)ht.get("MODIFIED_FACILITY_ID");
	   if(modifiedFacilityId==null)modifiedFacilityId="" ;
       facility_id= (String)ht.get("FACILITY_ID");
	   if(facility_id==null)facility_id="" ;
	   registration_no	=  (String)ht.get("REGISTRATION_NO");
	   if(registration_no==null)registration_no="" ;

       StringBuffer  sql1=new StringBuffer();


	   sql1.append("update MO_MORTUARY_REGN SET POSTMORTEM_STATUS='"+pmstatus+"',MODIFIED_BY_ID='"+modifiedById+"',MODIFIED_DATE=sysdate,MODIFIED_AT_WS_NO='"+modifiedAtWorkstation+"',MODIFIED_FACILITY_ID='"+modifiedFacilityId+"'	where  FACILITY_ID='"+facility_id+"' and REGISTRATION_NO='"+registration_no+"'");

       pstmt = con.prepareStatement(sql1.toString());
			
	   int cnt=pstmt.executeUpdate();
	   if(cnt == 0)
			 insertable=false;
		else
				insertable=true;
		if(pstmt!=null) pstmt.close();

       if(insertable)
		{
		con.commit();
		sb.setLength(0);
	    java.util.Hashtable message = MessageManager.getMessage( locale, "RECORD_INSERTED","SM" ) ;
 	    sb.append( (String) message.get("message") ) ;
		message.clear();
	    }
	   else
	     con.rollback();
	   			 
		results.put( "status", new Boolean(insertable) ) ;
		results.put( "error", sb.toString() ) ;
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 } 
	  finally
	 {
		  ConnectionManager.returnConnection(con,p);
	 }
	 ht.clear();
	  return results;
 }		

/**
* @ejb.interface-method
*	 view-type="both"
*/
public boolean recordSpecimenCollection()
{
        try
	{
		 StringBuffer	specimencoll		=	new StringBuffer( "" ) ; 
		 specimencoll.append("delete from mo_specimen_collection where REGISTRATION_NO=? and FACILITY_ID=?");
		 pstmt				=	con.prepareStatement(specimencoll.toString());
         pstmt.setString	(	1,	registration_no		);
		 pstmt.setString	(	2,	facility_id		);
		 pstmt.executeUpdate();
		 if(pstmt!=null)pstmt.close();
		 specimencoll.setLength(0);
		 specimencoll.append("insert into mo_specimen_collection (FACILITY_ID,REGISTRATION_NO,SPECIMENT_DESC,SPECIMEN_TYPE,ANATOMICAL_SITE_CODE,COLLECTED_DATE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID)  values (?,?,?,?,?,to_date(?,'dd/mm/yyyy hh24:mi'),?,sysdate,?,?,?,sysdate,?,?)");
		 pstmt				=	con.prepareStatement(specimencoll.toString());
    	 if (!speci_type1.equals(""))
		 {	        pstmt.setString	(	1,	facility_id		);
					pstmt.setString	(	2,	registration_no		);
					pstmt.setString	(	3,	speci_desc1);
					pstmt.setString	(	4,	speci_type1);
					pstmt.setString	(	5,	anotomical_site_code1);
					pstmt.setString	(	6,	collection_time1);
					pstmt.setString	(	7,	modifiedById		);
					pstmt.setString	(	8,	modifiedAtWorkstation		);
					pstmt.setString	(	9,	modifiedFacilityId	);
					pstmt.setString	(	10,	modifiedById		);
					pstmt.setString	(	11,	modifiedAtWorkstation	);
					pstmt.setString	(	12,	modifiedFacilityId	);
					insert_result	=	pstmt.executeUpdate();
				    if(insert_result > 0)
					{
					  insertable	= true;
					}
				    else
					  insertable	= false;
			}
		 if (!speci_type2.equals(""))
		 {
			        pstmt.setString	(	1,	facility_id		);
					pstmt.setString	(	2,	registration_no		);
					pstmt.setString	(	3,	speci_desc2);
					pstmt.setString	(	4,	speci_type2);
					pstmt.setString	(	5,	anotomical_site_code2);
					pstmt.setString	(	6,	collection_time2);
					pstmt.setString	(	7,	modifiedById		);
					pstmt.setString	(	8,	modifiedAtWorkstation		);
					pstmt.setString	(	9,	modifiedFacilityId	);
					pstmt.setString	(	10,	modifiedById		);
					pstmt.setString	(	11,	modifiedAtWorkstation	);
					pstmt.setString	(	12,	modifiedFacilityId	);
					insert_result	=	pstmt.executeUpdate();
				    if(insert_result > 0)
					{
					  insertable	= true;
					}
				    else
					  insertable	= false;
			}
	
			 if (!speci_type3.equals(""))
		 {
			        pstmt.setString	(	1,	facility_id		);
					pstmt.setString	(	2,	registration_no		);
					pstmt.setString	(	3,	speci_desc3);
					pstmt.setString	(	4,	speci_type3);
					pstmt.setString	(	5,	anotomical_site_code3);
					pstmt.setString	(	6,	collection_time3);
					pstmt.setString	(	7,	modifiedById		);
					pstmt.setString	(	8,	modifiedAtWorkstation		);
					pstmt.setString	(	9,	modifiedFacilityId	);
					pstmt.setString	(	10,	modifiedById		);
					pstmt.setString	(	11,	modifiedAtWorkstation	);
					pstmt.setString	(	12,	modifiedFacilityId	);
					insert_result	=	pstmt.executeUpdate();
				    if(insert_result > 0)
					{
					  insertable	= true;
					}
				    else
					  insertable	= false;
			}
		
		 if (!speci_type4.equals(""))
		 {	        pstmt.setString	(	1,	facility_id		);
					pstmt.setString	(	2,	registration_no		);
					pstmt.setString	(	3,	speci_desc4);
					pstmt.setString	(	4,	speci_type4);
					pstmt.setString	(	5,	anotomical_site_code4);
					pstmt.setString	(	6,	collection_time4);
					pstmt.setString	(	7,	modifiedById		);
					pstmt.setString	(	8,	modifiedAtWorkstation		);
					pstmt.setString	(	9,	modifiedFacilityId	);
					pstmt.setString	(	10,	modifiedById		);
					pstmt.setString	(	11,	modifiedAtWorkstation	);
					pstmt.setString	(	12,	modifiedFacilityId	);
    				insert_result	=	pstmt.executeUpdate();
				    if(insert_result > 0)
					{
					  insertable	= true;
					}
				    else
					  insertable	= false;
			}
		
		 if (!speci_type5.equals(""))
		 {	        pstmt.setString	(	1,	facility_id		);
					pstmt.setString	(	2,	registration_no		);
					pstmt.setString	(	3,	speci_desc5);
					pstmt.setString	(	4,	speci_type5);
					pstmt.setString	(	5,	anotomical_site_code5);
					pstmt.setString	(	6,	collection_time5);
					pstmt.setString	(	7,	modifiedById		);
					pstmt.setString	(	8,	modifiedAtWorkstation		);
					pstmt.setString	(	9,	modifiedFacilityId	);
					pstmt.setString	(	10,	modifiedById		);
					pstmt.setString	(	11,	modifiedAtWorkstation	);
					pstmt.setString	(	12,	modifiedFacilityId	);
					insert_result	=	pstmt.executeUpdate();
				    if(insert_result > 0)
					{ insertable	= true;
					} else
					  insertable	= false;
			}		
		 if (!speci_type6.equals(""))
		 {	        pstmt.setString	(	1,	facility_id		);
					pstmt.setString	(	2,	registration_no		);
					pstmt.setString	(	3,	speci_desc6);
					pstmt.setString	(	4,	speci_type6);
					pstmt.setString	(	5,	anotomical_site_code6);
					pstmt.setString	(	6,	collection_time6);
					pstmt.setString	(	7,	modifiedById		);
					pstmt.setString	(	8,	modifiedAtWorkstation		);
					pstmt.setString	(	9,	modifiedFacilityId	);
					pstmt.setString	(	10,	modifiedById		);
					pstmt.setString	(	11,	modifiedAtWorkstation	);
					pstmt.setString	(	12,	modifiedFacilityId	);
					insert_result	=	pstmt.executeUpdate();
				    if(insert_result > 0)
					{insertable	= true;
					}
				    else	  insertable	= false;
			}	
			
			if(pstmt!=null)pstmt.close();
			}
    catch(Exception e)
	{
		e.printStackTrace();
	}
return true;
}
/**
* @ejb.interface-method
*	 view-type="both"
*/
public boolean recordDiagnosis()
{  try
	{	   
		StringBuffer	Diagrecord		=	new StringBuffer( "" ) ; 
	 	 Diagrecord.append("delete from mo_postmortem_finding where REGISTRATION_NO=? and FACILITY_ID=?");
		 pstmt				=	con.prepareStatement(Diagrecord.toString());
     	 pstmt.setString	(	1,	registration_no		);
		 pstmt.setString	(	2,	facility_id		);
		 pstmt.executeUpdate();
		 Diagrecord.setLength(0);
		 if(pstmt!=null)pstmt.close();

		 Diagrecord.append("insert into mo_postmortem_finding (FACILITY_ID,REGISTRATION_NO,FINDING_TYPE,TERM_SET_ID,TERM_CODE,TERM_CODE_SHORT_DESC,ONSET_RECORDED_DATE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,TERM_CODE_CAUSE)  values (?,?,?,?,?,?,to_date(?,'dd/mm/yyyy hh24:mi'),?,sysdate,?,?,?,sysdate,?,?,?)");

		 pstmt				=	con.prepareStatement(Diagrecord.toString());

		 

    	 if (!mr_diagnosis_code.equals(""))

		 {	        pstmt.setString	(	1,	facility_id		);
					
					pstmt.setString	(	2,	registration_no		);
					
					pstmt.setString	(	3,	"1");
					
					pstmt.setString	(	4,	diagscheme);
					
					pstmt.setString	(	5,	mr_diagnosis_code);
					
					pstmt.setString	(	6,	mr_diagnosis_desc);
					
					pstmt.setString	(	7,	onset_date1);
					
					pstmt.setString	(	8,	modifiedById		);
					
					pstmt.setString	(	9,	modifiedAtWorkstation		);
					 
					pstmt.setString	(	10,	modifiedFacilityId	);
					 
					pstmt.setString	(	11,	modifiedById		);
					
					pstmt.setString	(	12,	modifiedAtWorkstation	);
					 
					pstmt.setString	(	13,	modifiedFacilityId	);
					
					pstmt.setString	(	14,	cause_remarks1);
					insert_result	=	pstmt.executeUpdate();

				    if(insert_result > 0)

					{ 
						insertable	= true;
					
					}
					else

					  insertable	= false;
	
			}

		 

		  

	         if (!mr_diagnosis_code1.equals(""))
		    {       

				 
				 
					pstmt.setString	(	1,	facility_id		);
					pstmt.setString	(	2,	registration_no		);
					pstmt.setString	(	3,	"1");
					pstmt.setString	(	4,	diagscheme);
					pstmt.setString	(	5,	mr_diagnosis_code1);
					pstmt.setString	(	6,	mr_diagnosis_desc1);
					pstmt.setString	(	7,	onset_date2);
					pstmt.setString	(	8,	modifiedById		);
					pstmt.setString	(	9,	modifiedAtWorkstation		);
					pstmt.setString	(	10,	modifiedFacilityId	);
					pstmt.setString	(	11,	modifiedById		);
					pstmt.setString	(	12,	modifiedAtWorkstation	);
					pstmt.setString	(	13,	modifiedFacilityId	);
					pstmt.setString	(	14,	cause_remarks2	);

					insert_result	=	pstmt.executeUpdate();
				    if(insert_result > 0)
					{
					  insertable	= true;
					}
				    else
					  insertable	= false;
			}
			 
	       if (!mr_diagnosis_code2.equals(""))
		 {	   			   
					pstmt.setString	(	1,	facility_id		);
					pstmt.setString	(	2,	registration_no		);
					pstmt.setString	(	3,	"2");
					pstmt.setString	(	4,	diagscheme);
					pstmt.setString	(	5,	mr_diagnosis_code2);
					pstmt.setString	(	6,	mr_diagnosis_desc2);
					pstmt.setString	(	7,	onset_date3);
					pstmt.setString	(	8,	modifiedById		);
					pstmt.setString	(	9,	modifiedAtWorkstation		);
					pstmt.setString	(	10,	modifiedFacilityId	);
					pstmt.setString	(	11,	modifiedById		);
					pstmt.setString	(	12,	modifiedAtWorkstation	);
					pstmt.setString	(	13,	modifiedFacilityId	);

					insert_result	=	pstmt.executeUpdate();
				    if(insert_result > 0)
					{
					  insertable	= true;
					}
				    else
					  insertable	= false;
			}
			 
			       if (!mr_diagnosis_code3.equals(""))
		 {	   
					  
					pstmt.setString	(	1,	facility_id		);
					pstmt.setString	(	2,	registration_no);
					pstmt.setString	(	3,	"2");
					pstmt.setString	(	4,	diagscheme);
					pstmt.setString	(	5,	mr_diagnosis_code3);
					pstmt.setString	(	6,	mr_diagnosis_desc3);
					pstmt.setString	(	7,	onset_date4);
					pstmt.setString	(	8,	modifiedById		);
					pstmt.setString	(	9,	modifiedAtWorkstation		);
					pstmt.setString	(	10,	modifiedFacilityId	);
					pstmt.setString	(	11,	modifiedById		);
					pstmt.setString	(	12,	modifiedAtWorkstation	);
					pstmt.setString	(	13,	modifiedFacilityId	);
					insert_result	=	pstmt.executeUpdate();
				    if(insert_result > 0)
					{
					  insertable	= true;
					}
				    else
					  insertable	= false;
			}
			 
			if (!mr_diagnosis_code4.equals(""))
		    {      
				
					pstmt.setString	(	1,	facility_id		);
					pstmt.setString	(	2,	registration_no		);
					pstmt.setString	(	3,	"3");
					pstmt.setString	(	4,	diagscheme);
					pstmt.setString	(	5,	mr_diagnosis_code4);
					pstmt.setString	(	6,	mr_diagnosis_desc4);
					pstmt.setString	(	7,	onset_date5);
					pstmt.setString	(	8,	modifiedById		);
					pstmt.setString	(	9,	modifiedAtWorkstation		);
					pstmt.setString	(	10,	modifiedFacilityId	);
					pstmt.setString	(	11,	modifiedById		);
					pstmt.setString	(	12,	modifiedAtWorkstation	);
					pstmt.setString	(	13,	modifiedFacilityId	);
					pstmt.setString	(	14,	cause_remarks3	);
					insert_result	=	pstmt.executeUpdate();
				    if(insert_result > 0)
					{
					  insertable	= true;
					}
				    else
					  insertable	= false;
			}
		 
		if (!mr_diagnosis_code5.equals(""))
		 {	
			 
					pstmt.setString	(	1,	facility_id		);
					pstmt.setString	(	2,	registration_no		);
					pstmt.setString	(	3,	"3");
					pstmt.setString	(	4,	diagscheme);
					pstmt.setString	(	5,	mr_diagnosis_code5);
					pstmt.setString	(	6,	mr_diagnosis_desc5);
					pstmt.setString	(	7,	onset_date6);
					pstmt.setString	(	8,	modifiedById		);
					pstmt.setString	(	9,	modifiedAtWorkstation		);
					pstmt.setString	(	10,	modifiedFacilityId	);
					pstmt.setString	(	11,	modifiedById		);
					pstmt.setString	(	12,	modifiedAtWorkstation	);
					pstmt.setString	(	13,	modifiedFacilityId	);
					pstmt.setString	(	14,	cause_remarks4	);
					insert_result	=	pstmt.executeUpdate();
				    if(insert_result > 0)
					{
					  insertable	= true;
					}
				    else
					  insertable	= false;
			}
			if (!mr_diagnosis_code6.equals(""))
		 {	
					pstmt.setString	(	1,	facility_id		);
					pstmt.setString	(	2,	registration_no		);
					pstmt.setString	(	3,	"3");
					pstmt.setString	(	4,	diagscheme);
					pstmt.setString	(	5,	mr_diagnosis_code6);
					pstmt.setString	(	6,	mr_diagnosis_desc6);
					pstmt.setString	(	7,	onset_date7);
					pstmt.setString	(	8,	modifiedById		);
					pstmt.setString	(	9,	modifiedAtWorkstation		);
					pstmt.setString	(	10,	modifiedFacilityId	);
					pstmt.setString	(	11,	modifiedById		);
					pstmt.setString	(	12,	modifiedAtWorkstation	);
					pstmt.setString	(	13,	modifiedFacilityId	);
					pstmt.setString	(	14,	cause_remarks5	);
					insert_result	=	pstmt.executeUpdate();
				    if(insert_result > 0)
					{
					  insertable	= true;
					}
				    else
					  insertable	= false;
			}
			if (!mr_diagnosis_code7.equals(""))
		 {	
					pstmt.setString	(	1,	facility_id		);
					pstmt.setString	(	2,	registration_no		);
					pstmt.setString	(	3,	"3");
					pstmt.setString	(	4,	diagscheme);
					pstmt.setString	(	5,	mr_diagnosis_code7);
					pstmt.setString	(	6,	mr_diagnosis_desc7);
					pstmt.setString	(	7,	onset_date8);
					pstmt.setString	(	8,	modifiedById		);
					pstmt.setString	(	9,	modifiedAtWorkstation		);
					pstmt.setString	(	10,	modifiedFacilityId	);
					pstmt.setString	(	11,	modifiedById		);
					pstmt.setString	(	12,	modifiedAtWorkstation	);
					pstmt.setString	(	13,	modifiedFacilityId	);
					pstmt.setString	(	14,	cause_remarks6	);
					insert_result	=	pstmt.executeUpdate();
				    if(insert_result > 0)
					{
					  insertable	= true;
					}
				    else
					  insertable	= false;
			}
	if(pstmt!=null)pstmt.close();

	}catch(Exception e)
	{
		
		e.printStackTrace();
	}
return true;
}

/**
* @ejb.interface-method
*	 view-type="both"
*/
public boolean recordWitnessTeam()
{     try
	   { 
         StringBuffer	MOWitnessTeam		=	new StringBuffer( "" ) ; 
		 MOWitnessTeam.append("delete from mo_postmortem_witness where REGISTRATION_NO=? and FACILITY_ID=?");
		 pstmt				=	con.prepareStatement(MOWitnessTeam.toString());
         
		 pstmt.setString	(	1,	registration_no		);
		 pstmt.setString	(	2,	facility_id		);
		 pstmt.executeUpdate();
         MOWitnessTeam.setLength(0);
		 if(pstmt!=null)pstmt.close();
		 MOWitnessTeam.append("insert into mo_postmortem_witness ");
		 MOWitnessTeam.append("(FACILITY_ID,REGISTRATION_NO,WITNESS_NAME,DESIGNATION, ");
		 MOWitnessTeam.append("ADDED_BY_ID,");
		 MOWitnessTeam.append("ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID, ");
		 MOWitnessTeam.append("MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID)  values ");
		 MOWitnessTeam.append("(?,?,?,?,?,");
		 MOWitnessTeam.append("sysdate,?,?,");
		 MOWitnessTeam.append("?,sysdate,?,?) ");
		 pstmt				=	con.prepareStatement(MOWitnessTeam.toString());

		 if (!pract6.equals(""))
		 {
			        pstmt.setString	(   1,	facility_id		);
					pstmt.setString	(	2,	registration_no		);
					pstmt.setString	(	3,	pract6);
					pstmt.setString	(	4,	desi1);
					pstmt.setString	(	5,	modifiedById		);
					pstmt.setString	(	6,	modifiedAtWorkstation		);
					pstmt.setString	(	7,	modifiedFacilityId	);
					pstmt.setString	(	8,	modifiedById		);
					pstmt.setString	(	9,	modifiedAtWorkstation	);
					pstmt.setString	(	10,	modifiedFacilityId	);

					insert_result	=	pstmt.executeUpdate();
				    if(insert_result > 0)
					{
					  insertable	= true;
					}
				    else
					  insertable	= false;
			}
	   
	 
	 if (!pract7.equals(""))
		 {
			        pstmt.setString	(	1,	facility_id		);
					pstmt.setString	(	2,	registration_no		);
					pstmt.setString	(	3,	pract7);
					pstmt.setString	(	4,	desi2);
					pstmt.setString	(	5,	modifiedById		);
					pstmt.setString	(	6,	modifiedAtWorkstation		);
					pstmt.setString	(	7,	modifiedFacilityId	);
					pstmt.setString	(	8,	modifiedById		);
					pstmt.setString	(	9,	modifiedAtWorkstation	);
					pstmt.setString	(	10,	modifiedFacilityId	);

					insert_result	=	pstmt.executeUpdate();
				    if(insert_result > 0)
					{
					  insertable	= true;
					}
				    else
					  insertable	= false;
			}
	   
 if(pstmt!=null)pstmt.close();	 
	 }
 

	   

	 
catch(Exception e)
{
	e.printStackTrace();
}
return true;
}

/**
* @ejb.interface-method
*	 view-type="both"
*/
public boolean recordPostmortemTeam()
{   try
	{

         StringBuffer	MOPMTeam		=	new StringBuffer( "" ) ; 
		 MOPMTeam.append("delete from MO_POSTMORTEM_TEAM where REGISTRATION_NO=? and FACILITY_ID=?");
		 pstmt				=	con.prepareStatement(MOPMTeam.toString());
         
		 pstmt.setString	(	1,	registration_no		);
		 pstmt.setString	(	2,	facility_id		);
		 pstmt.executeUpdate();
	     MOPMTeam.setLength(0);
		 if(pstmt!=null)pstmt.close();
		 MOPMTeam.append("insert into MO_POSTMORTEM_TEAM ");
		 MOPMTeam.append("(FACILITY_ID,REGISTRATION_NO,PRACTITIONER_ID, ");
		 MOPMTeam.append("ROLE_FOR_PRACTITIONER,ADDED_BY_ID,");
		 MOPMTeam.append("ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID, ");
		 MOPMTeam.append("MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,DESIGNATION,TEAM_IND)  values ");
		 MOPMTeam.append("(?,?,?,?,?,");
		 MOPMTeam.append("sysdate,?,?,");
		 MOPMTeam.append("?,sysdate,?,?,?,?) ");
		 pstmt				=	con.prepareStatement(MOPMTeam.toString());
         if (!pract1.equals(""))
		 {
			pstmt.setString	(	1,	facility_id		);
			pstmt.setString	(	2,	registration_no		);
			pstmt.setString	(	3,	pract1);
			pstmt.setString	(	4,	role1);
			pstmt.setString	(	5,	modifiedById		);
			pstmt.setString	(	6,	modifiedAtWorkstation		);
			pstmt.setString	(	7,	modifiedFacilityId	);
			pstmt.setString	(	8,	modifiedById		);
			pstmt.setString	(	9,	modifiedAtWorkstation	);
			pstmt.setString	(	10,	modifiedFacilityId	);
			pstmt.setString	(	11,	""	);
            pstmt.setString	(	12,	"1"	);
			int insert_result	=	pstmt.executeUpdate();
			if(insert_result > 0)
			{
			  insertable	= true;
			}
			 else
			 insertable	= false;
			}
            if(insertable && (!pract2.equals("")))
            {
			pstmt.setString	(	1,	facility_id		);
			pstmt.setString	(	2,	registration_no		);
			pstmt.setString	(	3,	pract2	);
			pstmt.setString	(	4,	role2	);
			pstmt.setString	(	5,	modifiedById		);
			pstmt.setString	(	6,	modifiedAtWorkstation		);
			pstmt.setString	(	7,	modifiedFacilityId	);
			pstmt.setString	(	8,	modifiedById		);
			pstmt.setString	(	9,	modifiedAtWorkstation	);
			pstmt.setString	(	10,	modifiedFacilityId	);
			pstmt.setString	(	11,	""	);
			pstmt.setString	(	12,	"1"	);
			insert_result	=	pstmt.executeUpdate();
		    if(insert_result > 0)
 			 {
			   insertable	= true;
			 }
			 else
			  insertable	= false;
			}
			if(insertable && (!pract3.equals("")))
            {
			pstmt.setString	(	1,	facility_id		);
			pstmt.setString	(	2,	registration_no		);
			pstmt.setString	(	3,	pract3	);
			pstmt.setString	(	4,	role3	);
			pstmt.setString	(	5,	modifiedById		);
			pstmt.setString	(	6,	modifiedAtWorkstation		);
			pstmt.setString	(	7,	modifiedFacilityId	);
			pstmt.setString	(	8,	modifiedById		);
			pstmt.setString	(	9,	modifiedAtWorkstation	);
			pstmt.setString	(	10,	modifiedFacilityId	);
			pstmt.setString	(	11,	designation3);
			pstmt.setString	(	12,	"2"	);
			insert_result	=	pstmt.executeUpdate();
		    if(insert_result > 0)
   			 { 
			  insertable	= true;
			}
			else
			  insertable	= false;
			}
			
			if(insertable && (!pract4.equals("")))
            {
			pstmt.setString	(	1,	facility_id		);
			pstmt.setString	(	2,	registration_no		);
			pstmt.setString	(	3,	pract4	);
			pstmt.setString	(	4,	role4	);
			pstmt.setString	(	5,	modifiedById		);
			pstmt.setString	(	6,	modifiedAtWorkstation		);
			pstmt.setString	(	7,	modifiedFacilityId	);
			pstmt.setString	(	8,	modifiedById		);
			pstmt.setString	(	9,	modifiedAtWorkstation	);
			pstmt.setString	(	10,	modifiedFacilityId	);
            pstmt.setString	(	11,	designation1	);
			pstmt.setString	(	12,	"2"	);
			insert_result	=	pstmt.executeUpdate();
		    if(insert_result > 0)
	       	{
			  insertable	= true;
			}
			else
			  insertable	= false;
			}
			if(insertable && (!pract5.equals("")))
            {
			pstmt.setString	(	1,	facility_id		);
			pstmt.setString	(	2,	registration_no		);
			pstmt.setString	(	3,	pract5	);
			pstmt.setString	(	4,	role5	);
			pstmt.setString	(	5,	modifiedById		);
			pstmt.setString	(	6,	modifiedAtWorkstation		);
			pstmt.setString	(	7,	modifiedFacilityId	);
			pstmt.setString	(	8,	modifiedById		);
			pstmt.setString	(	9,	modifiedAtWorkstation	);
			pstmt.setString	(	10,	modifiedFacilityId	);
            pstmt.setString	(	11,	designation2	);
			pstmt.setString	(	12,	"2"	);
			insert_result	=	pstmt.executeUpdate();
		    if(insert_result > 0)
			{
			  insertable	= true;
			}
		    else
			  insertable	= false;
			}
       
            if(pstmt!=null) pstmt.close();
	   
	   
	   }

  catch(Exception e)
  {
		e.printStackTrace();
  }
	
return true;
}

/**
* @ejb.interface-method
*	 view-type="both"
*/
public void extractValues(HashMap ht)
 {
 donatedorgan                  = (String) ht.get("donatedorgan")==null?"":(String) ht.get("donatedorgan");
 tissue_procured_by            = (String) ht.get("tissue_procured_by")==null?"":(String) ht.get("tissue_procured_by");
 tissue_procure_performed_date =(String) ht.get("tissue_procure_performed_date")==null?"":(String) ht.get("tissue_procure_performed_date");
 pm_requested_by               = (String) ht.get("pm_requested_by")==null?"":(String) ht.get("pm_requested_by");
 PM_PURPOSE                    = (String) ht.get("PM_PURPOSE")==null?"":(String) ht.get("PM_PURPOSE");
 pract1                        =(String) ht.get("PM_CONDUCTED_BY_PRACT_ID1")==null?"":(String) ht.get("PM_CONDUCTED_BY_PRACT_ID1");
 pract2                        =(String) ht.get("PM_CONDUCTED_BY_PRACT_ID2")==null?"":(String) ht.get("PM_CONDUCTED_BY_PRACT_ID2");
 pract3                        =(String) ht.get("PM_CONDUCTED_BY_PRACT_ID3")==null?"":(String) ht.get("PM_CONDUCTED_BY_PRACT_ID3");
 pract4                        =(String) ht.get("PM_CONDUCTED_BY_PRACT_ID4")==null?"":(String) ht.get("PM_CONDUCTED_BY_PRACT_ID4");
 pract5                        =(String) ht.get("PM_CONDUCTED_BY_PRACT_ID5")==null?"":(String) ht.get("PM_CONDUCTED_BY_PRACT_ID5");
 role1                         =(String) ht.get("PRACT_ID1_ROLE1")==null?"":(String) ht.get("PRACT_ID1_ROLE1");
 role2                         =(String) ht.get("PRACT_ID2_ROLE2")==null?"":(String) ht.get("PRACT_ID2_ROLE2");
 role3                         =(String) ht.get("PRACT_ID3_ROLE3")==null?"":(String) ht.get("PRACT_ID3_ROLE3");
 role4                         =(String) ht.get("PRACT_ID4_ROLE4")==null?"":(String) ht.get("PRACT_ID4_ROLE4");
 role5                         =(String) ht.get("PRACT_ID5_ROLE5")==null?"":(String) ht.get("PRACT_ID5_ROLE5");
 pract6			       =(String) ht.get("WITNESS1")==null?"":(String) ht.get("WITNESS1");
 pract7			       =(String) ht.get("WITNESS2")==null?"":(String) ht.get("WITNESS2");
 designation3=(String)ht.get("desig3");
 if(designation3==null)designation3="" ;
 designation1=(String)ht.get("desig1");
 if(designation1==null)designation1="" ;
 designation2=(String)ht.get("desig2");
 
   if(designation2==null)designation2="" ;
 pm_performed_by=(String)ht.get("PM_PERFORMED_BY");
 if(pm_performed_by==null)pm_performed_by="" ;
 role_for_practitioner=(String)ht.get("ROLE_FOR_PRACTITIONER");
 if(role_for_practitioner==null)role_for_practitioner="" ;
      
	   
 desi1			       =(String) ht.get("WITNESSDESI1")==null?"":(String) ht.get("WITNESSDESI1");
 desi2			       =(String) ht.get("WITNESSDESI2")==null?"":(String) ht.get("WITNESSDESI2");
 pm_start_date_time	       = (String) ht.get("POSTMORTEM_START_DATE_TIME")==null?"": (String) ht.get("POSTMORTEM_START_DATE_TIME");
if(!pm_start_date_time.equals(""))
{
pmstatus="S";
}
 pm_end_date_time              =(String) ht.get("POSTMORTEM_END_DATE_TIME")==null?"":(String) ht.get("POSTMORTEM_END_DATE_TIME");
if(!pm_end_date_time.equals(""))
{
pmstatus="E";
}
 pract9                        =(String) ht.get("PM_CERTIFIED_BY")==null?"":(String) ht.get("PM_CERTIFIED_BY");
 mr_diagnosis_code             =(String) ht.get("mr_diagnosis_code")==null?"":(String) ht.get("mr_diagnosis_code");
 mr_diagnosis_code1            =(String) ht.get("mr_diagnosis_code1")==null?"":(String) ht.get("mr_diagnosis_code1");
 mr_diagnosis_code2            =(String) ht.get("mr_diagnosis_code2")==null?"":(String) ht.get("mr_diagnosis_code2");
 mr_diagnosis_code3            =(String) ht.get("mr_diagnosis_code3")==null?"":(String) ht.get("mr_diagnosis_code3");
 mr_diagnosis_code4            =(String) ht.get("mr_diagnosis_code4")==null?"":(String) ht.get("mr_diagnosis_code4");
 mr_diagnosis_code5            =(String) ht.get("mr_diagnosis_code5")==null?"":(String) ht.get("mr_diagnosis_code5");
 mr_diagnosis_code6           =(String) ht.get("mr_diagnosis_code6")==null?"":(String) ht.get("mr_diagnosis_code6"); // BRU-HIMS-CRF-270
 mr_diagnosis_code7            =(String) ht.get("mr_diagnosis_code7")==null?"":(String) ht.get("mr_diagnosis_code7"); // BRU-HIMS-CRF-270

 mr_diagnosis_desc             =(String) ht.get("mr_diagnosis_desc")==null?"":(String) ht.get("mr_diagnosis_desc");
 mr_diagnosis_desc1            =(String) ht.get("mr_diagnosis_desc1")==null?"":(String) ht.get("mr_diagnosis_desc1");
 mr_diagnosis_desc2            =(String) ht.get("mr_diagnosis_desc2")==null?"":(String) ht.get("mr_diagnosis_desc2");
 mr_diagnosis_desc3            =(String) ht.get("mr_diagnosis_desc3")==null?"":(String) ht.get("mr_diagnosis_desc3");
 mr_diagnosis_desc4            =(String) ht.get("mr_diagnosis_desc4")==null?"":(String) ht.get("mr_diagnosis_desc4");
 mr_diagnosis_desc5            =(String) ht.get("mr_diagnosis_desc5")==null?"":(String) ht.get("mr_diagnosis_desc5");
 mr_diagnosis_desc6            =(String) ht.get("mr_diagnosis_desc6")==null?"":(String) ht.get("mr_diagnosis_desc6"); // BRU-HIMS-CRF-270
 mr_diagnosis_desc7            =(String) ht.get("mr_diagnosis_desc7")==null?"":(String) ht.get("mr_diagnosis_desc7"); // BRU-HIMS-CRF-270

 onset_date1                   =(String) ht.get("onset_date1")==null?"":(String) ht.get("onset_date1");
 onset_date2                   =(String) ht.get("onset_date2")==null?"":(String) ht.get("onset_date2");
 onset_date3                   =(String) ht.get("onset_date3")==null?"":(String) ht.get("onset_date3");
 onset_date4                   =(String) ht.get("onset_date4")==null?"":(String) ht.get("onset_date4");
 onset_date5                   =(String) ht.get("onset_date5")==null?"":(String) ht.get("onset_date5");
 onset_date6                   =(String) ht.get("onset_date6")==null?"":(String) ht.get("onset_date6");
 // BRU-HIMS-CRF-270
 onset_date7                   =(String) ht.get("onset_date7")==null?"":(String) ht.get("onset_date7"); 
 onset_date8                   =(String) ht.get("onset_date8")==null?"":(String) ht.get("onset_date8"); 
 cause_remarks1                   =(String) ht.get("cause_remarks1")==null?"":(String) ht.get("cause_remarks1");
 cause_remarks2                   =(String) ht.get("cause_remarks2")==null?"":(String) ht.get("cause_remarks2");
 cause_remarks3                   =(String) ht.get("cause_remarks3")==null?"":(String) ht.get("cause_remarks3");
 cause_remarks4                   =(String) ht.get("cause_remarks4")==null?"":(String) ht.get("cause_remarks4");
 cause_remarks5                   =(String) ht.get("cause_remarks5")==null?"":(String) ht.get("cause_remarks5");
 cause_remarks6                   =(String) ht.get("cause_remarks6")==null?"":(String) ht.get("cause_remarks6");  
  // BRU-HIMS-CRF-270 END HERE 
 manner_of_death               =(String) ht.get("manner_of_death")==null?"":(String) ht.get("manner_of_death");
 postmortem_findings           =(String) ht.get("postmortem_findings")==null?"":(String) ht.get("postmortem_findings");
 speci_desc1                   =(String) ht.get("speci_desc1")==null?"":(String) ht.get("speci_desc1");
 speci_desc2                   =(String) ht.get("speci_desc2")==null?"":(String) ht.get("speci_desc2");
 speci_desc3                   =(String) ht.get("speci_desc3")==null?"":(String) ht.get("speci_desc3");
 speci_desc4                   =(String) ht.get("speci_desc4")==null?"":(String) ht.get("speci_desc4");
 speci_desc5                   =(String) ht.get("speci_desc5")==null?"":(String) ht.get("speci_desc5");
 speci_desc6                   =(String) ht.get("speci_desc6")==null?"":(String) ht.get("speci_desc6");
 speci_type1                   =(String) ht.get("speci_type1")==null?"":(String) ht.get("speci_type1");
 speci_type2                   =(String) ht.get("speci_type2")==null?"":(String) ht.get("speci_type2");
 speci_type3                   =(String) ht.get("speci_type3")==null?"":(String) ht.get("speci_type3");
 speci_type4                   =(String) ht.get("speci_type4")==null?"":(String) ht.get("speci_type4");
 speci_type5                   =(String) ht.get("speci_type5")==null?"":(String) ht.get("speci_type5");
 speci_type6                   =(String) ht.get("speci_type6")==null?"":(String) ht.get("speci_type6");
 anotomical_site_code1         =(String) ht.get("anotomical_site_code1")==null?"":(String) ht.get("anotomical_site_code1");;
 anotomical_site_code2         =(String) ht.get("anotomical_site_code2")==null?"":(String) ht.get("anotomical_site_code2");;
 anotomical_site_code3         =(String) ht.get("anotomical_site_code3")==null?"":(String) ht.get("anotomical_site_code3");;
 anotomical_site_code4         =(String) ht.get("anotomical_site_code4")==null?"":(String) ht.get("anotomical_site_code4");
 anotomical_site_code5         =(String) ht.get("anotomical_site_code5")==null?"":(String) ht.get("anotomical_site_code5");
 anotomical_site_code6         =(String) ht.get("anotomical_site_code6")==null?"":(String) ht.get("anotomical_site_code6");
 collection_time1	       =(String) ht.get("collection_time1")==null?"":(String) ht.get("collection_time1");
 collection_time2              =(String) ht.get("collection_time2")==null?"":(String) ht.get("collection_time2");
 collection_time3              =(String) ht.get("collection_time3")==null?"":(String) ht.get("collection_time3");
 collection_time4              =(String) ht.get("collection_time4")==null?"":(String) ht.get("collection_time4");
 collection_time5              =(String) ht.get("collection_time5")==null?"":(String) ht.get("collection_time5");
 collection_time6              =(String) ht.get("collection_time6")==null?"":(String) ht.get("collection_time6");
 spec_collected_by             =(String) ht.get("spec_collected_by")==null?"":(String) ht.get("spec_collected_by");
 spec_handed_over_to           =(String) ht.get("spec_handed_over_to")==null?"":(String) ht.get("spec_handed_over_to");
 spec_handed_over_date         =(String) ht.get("spec_handed_over_date")==null?"":(String) ht.get("spec_handed_over_date");
 diagscheme                    =(String) ht.get("diagscheme")==null?"":(String) ht.get("diagscheme");
 registration_no               =(String) ht.get("REGISTRATION_NO")==null?"":(String) ht.get("REGISTRATION_NO");
 /*Below line(s) added by Venkatesh.S on 12-Nov-2013 against Bru-HIMS-CRF-365 [IN:039572]*/
 death_after_potmrtm           =(String) ht.get("death_after_potmrtm")==null?"":(String) ht.get("death_after_potmrtm");
 examination_type              =(String) ht.get("examination_type")==null?"":(String) ht.get("examination_type"); //Added by Mano on 26-sep-2017 aganist ML-MMOH-CRF-0791

 
 modifiedById	=  (String)ht.get("MODIFIED_BY_ID");
 if(modifiedById==null)modifiedById="" ;
 modifiedAtWorkstation=  (String)ht.get("MODIFIED_AT_WS_NO");
 if(modifiedAtWorkstation==null)modifiedAtWorkstation="" ;
 modifiedFacilityId	=  (String)ht.get("MODIFIED_FACILITY_ID");
 if(modifiedFacilityId==null)modifiedFacilityId="" ;
 facility_id	=  (String)ht.get("FACILITY_ID");
 if(facility_id==null)facility_id="" ;

ht.clear();
}





}
