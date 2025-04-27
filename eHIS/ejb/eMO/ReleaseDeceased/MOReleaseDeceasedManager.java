/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMO.ReleaseDeceased;
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
*	name="ReleaseDeceased"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="ReleaseDeceased"
*	local-jndi-name="ReleaseDeceased"
*	impl-class-name="eMO.ReleaseDeceased.MOReleaseDeceasedManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eMO.ReleaseDeceased.MOReleaseDeceasedLocal"
*	remote-class="eMO.ReleaseDeceased.MOReleaseDeceasedRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eMO.ReleaseDeceased.MOReleaseDeceasedLocalHome"
*	remote-class="eMO.ReleaseDeceased.MOReleaseDeceasedHome"
*	generate= "local,remote"
*
*
*/

public class MOReleaseDeceasedManager implements SessionBean
{	
	Connection con ;           
	PreparedStatement pstmt=null ;        
	//ResultSet rset;
	ResultSet rs;

	Properties	p ;
	public final String RECORD_MODIFIED		= "RECORD_MODIFIED" ;	
	StringBuffer  sql=new StringBuffer();
	//StringBuffer  sql1	=new StringBuffer();
	StringBuffer  sb	=new StringBuffer();
	
	
	HashMap hashtable=null;

	String 	        facility_id                            ="";				                       
	String		  	registration_no			               ="";
	String          exportation_reqd_yn                    ="";
	String          modified_at_ws_no                      ="";
	String          modified_facility_id                   ="";
	String          modified_by_id                         ="";
	String		  	release_body_date			            ="";
	String          area_code                              ="";
    String          bed_no                                 ="";  
    String		  	body_rel_by			                   ="";
	String			police_officer						="";
	String			police_station						="";
	String			rank						="";
	String			burial_issued_yn						="";
	String			burial_issued_dtime						="";
	String          CLAIMANT_TYPE="";
	String          CLAIMANT_TYPE_CODE="";
    String         res_town_code                               ="";
	String         res_area_code                               =""; 
	String         region_code                                 ="";
	
	String          RELATIONSHIP=""; 
	String          NAME="";
	String          JOB_TITLE="";  
	String          ADD_LINE1=""; 
	String          ADD_LINE2="";
	String          ADD_LINE3="";
	String          ADD_LINE4="";
	String          ZIP_CODE="";
	String          COUNTRY_CODE=""; 
	String          TELEPHONE_OFF ="";
	String          TELEPHONE_RES="";
	String          EMAIL_ID ="";
	String          MOB_TEL_NO="";
	String          NAT_ID_NO ="";
	String          ORGANIZATION_NAME="";  
	String          PATIENT_EMPLOYEE_ID="";

	//Added by Ashwini on 02-Aug-2017 for ML-MMOH-CRF-0743
	String          PASSPORT_NO="";
	String          OTHER_IDENTIFICATION="";

    String          unclaimed_body_yn="";
	String			locale										   ="";
	String 			RELEASE_TO_FACILITY =""; //Added Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg	
	String reason_desc=""; //Added this CRF Bru-HIMS-CRF-366 [IN-039612]
	String claim_date_time = "";// Added by Santhosh for ML-MMOH-CRF-1948
	
  	SessionContext ctx;
	java.util.HashMap results	    =null;                      
	//java.util.HashMap extractData	=null;
	//boolean result					= false ;
	boolean result					= true ;
	//boolean insertable				= true ;		
    
  
	/****************************** CALL BACK Functions  ****************************************/
	public void ejbCreate() {}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext( SessionContext context ) {this.ctx = context;}
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

	public java.util.HashMap  updateReleaseDeceased(Properties properties,HashMap ht) 
	{  
		
		sql.append("select area_code, bed_no from mo_mortuary_regn_vw where facility_id=? and  registration_no=?");
    try 
    {    p				       = properties  ;
	     con					= ConnectionManager.getConnection(p);
		 locale					= p.getProperty("LOCALE");
		
		 con.setAutoCommit(false);					
	 	 results			= new java.util.HashMap() ;
	     hashtable	= ht;
		  facility_id                               =(String)hashtable.get("FACILITY_ID");  
		  registration_no                           =(String)hashtable.get("REGISTRATION_NO");   
		  exportation_reqd_yn                       =(String)hashtable.get("EXPORTATION_REQD_YN");  
		  modified_at_ws_no                         =(String)hashtable.get("modified_at_ws_no"); 
		  modified_facility_id                      =(String)hashtable.get("modified_facility_id"); 
		  modified_by_id                            =(String)hashtable.get("modified_by_id"); 
		  body_rel_by	                            =(String)hashtable.get("bodyrelby");
		  release_body_date		                    =(String)hashtable.get("RELEASE_BODY_DATE");
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
		  
		  //Added by Ashwini on 02-Aug-2017 for ML-MMOH-CRF-0743
		  PASSPORT_NO							 =(String)hashtable.get("PASSPORT_NO"); 
		  OTHER_IDENTIFICATION                   =(String)hashtable.get("OTHER_IDENTIFICATION"); 

		  unclaimed_body_yn                      =(String)hashtable.get("unclaimed_body_yn");    
		  res_town_code							 =(String)hashtable.get("res_town_code");
		  res_area_code						     =(String)hashtable.get("res_area_code");
			region_code                             =(String)hashtable.get("region_code"); 
		  police_officer=(String)hashtable.get("police_officer");
		  police_station=(String)hashtable.get("police_station");
		  rank=(String)hashtable.get("rank");
		  burial_issued_yn=(String)hashtable.get("burial_issued_yn");
		  burial_issued_dtime=(String)hashtable.get("burial_issued_dtime");
		  RELEASE_TO_FACILITY=(String)hashtable.get("RELEASE_TO_FACILITY"); //Added Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg		  
		  reason_desc=(String)hashtable.get("reason_desc"); //Added this CRF Bru-HIMS-CRF-366 [IN-039612]
		  claim_date_time=(String)hashtable.get("CLAIM_DATE_TIME");// Added by Santhosh for ML-MMOH-CRF-1948
		  
		  
		 if(body_rel_by==null) body_rel_by=""; 
		 if(release_body_date==null) release_body_date="";
	     if(facility_id==null)facility_id ="";
		 if(registration_no==null)registration_no="";
		 if(exportation_reqd_yn==null)exportation_reqd_yn ="";
		 if(modified_facility_id==null)modified_facility_id ="";
		 if(modified_by_id==null)modified_by_id ="";
		 if(modified_at_ws_no==null)modified_at_ws_no="";
		 try
		 {
				pstmt = con.prepareStatement(sql.toString());   			
				pstmt.setString(1,facility_id);
				pstmt.setString(2,registration_no);
				rs = pstmt.executeQuery();
				if(rs.next())
				{
					area_code=rs.getString("area_code");
					bed_no = rs.getString("bed_no");
				}	 	
		 }
		 catch (Exception e)
		 {
			 result = false;
			 e.printStackTrace();
			 sb.append("mo_mortuary_regn_vw Exception in selection:"+e);
		 }		
		if(area_code == null) area_code = "";
		if(bed_no == null) bed_no = "";
        if(rs!=null)rs.close();
		if(pstmt!=null) pstmt.close();

		if(!bed_no.equals("") && result)
		{
			sql.delete(0,sql.length());
			// sql.setLength(0);
		 	 sql.append("update mo_bed_for_area set occupying_patient_id=null,registration_no=null,modified_by_id=?, modified_date=sysdate,modified_facility_id=?,modified_at_ws_no=? where area_code=? and bed_no=? and facility_id = ?");
			 try
			 {
			 		pstmt	= con.prepareStatement(sql.toString());
					pstmt.setString(1,modified_by_id) ;
				    pstmt.setString(2,modified_facility_id) ;
				    pstmt.setString(3,modified_at_ws_no) ;
					pstmt.setString(4,area_code) ;
					pstmt.setString(5,bed_no) ;
					pstmt.setString(6,facility_id) ;
					pstmt.executeUpdate();
			 }
			 catch (Exception e)
			 {
				result = false;
				e.printStackTrace();				
				java.util.Hashtable message = MessageManager.getMessage(locale,"ERROR_WHILE_Updating","IP");
				String msgVal = ((String) message.get("message"));
				message.clear();
				//msgVal = msgVal.substring(0,msgVal.length()-4);
				sb.append(msgVal+" mo_bed_for_area");
			 }
			 if(pstmt!=null) pstmt.close();

		}
		
		//sql.setLength(0);
		int rs1 = 0;
		if(result)
		{
			sql.delete(0,sql.length());
		
			sql.append("update  MO_MORTUARY_REGN set RELEASE_BODY_DATE=to_date(?,'dd/mm/yyyy hh24:mi'), EXPORTATION_REQD_YN=?,modified_by_id=?, modified_date=sysdate,modified_facility_id=?,modified_at_ws_no=? ,RELEASED_BY=?,RELEASE_POL_ID=?,RELEASE_POL_STN_ID=?,RELEASE_POL_OFFICER_RANK=?,BURIAL_PERMIT_ISSUED_YN=?,BURIAL_PERMIT_ISSUE_DATE=to_date(?,'dd/mm/yyyy hh24:mi'),unclaimed_body_yn=?,CLAIM_DATE_TIME=to_date(?,'dd/mm/yyyy hh24:mi')  where FACILITY_ID=? and REGISTRATION_NO=? ");
			
			try
			{
				pstmt	= con.prepareStatement(sql.toString());
				pstmt.setString(1,release_body_date) ;
				pstmt.setString(2,exportation_reqd_yn) ;
				pstmt.setString(3,modified_by_id) ;
				pstmt.setString(4,modified_facility_id) ;
				pstmt.setString(5,modified_at_ws_no) ;
				pstmt.setString(6,body_rel_by) ;
				pstmt.setString(7,police_officer) ;
				pstmt.setString(8,police_station) ;
				pstmt.setString(9,rank) ;
				pstmt.setString(10,burial_issued_yn) ;
				pstmt.setString(11,burial_issued_dtime) ;
				pstmt.setString(12,unclaimed_body_yn) ;
				pstmt.setString(13,(claim_date_time==null) ?"" :claim_date_time) ;
				pstmt.setString(14,facility_id) ;
				pstmt.setString(15,registration_no) ;
				rs1 =  pstmt.executeUpdate();
				if(rs1>0)
					result = true;
				else
				{
					java.util.Hashtable message = MessageManager.getMessage(locale,"ERROR_WHILE_Updating","IP");
					String msgVal = ((String) message.get("message"));
					message.clear();
					//msgVal = msgVal.substring(0,msgVal.length()-4);
					sb.append(msgVal+" MO_MORTUARY_REGN");
					result = false;
				}
				
			}
			catch (Exception e)
			{
				result = false;
				e.printStackTrace();
				java.util.Hashtable message = MessageManager.getMessage(locale,"ERROR_WHILE_Updating","IP");
				String msgVal = ((String) message.get("message"));
				message.clear();
				//msgVal = msgVal.substring(0,msgVal.length()-4);
				sb.append(msgVal+" MO_MORTUARY_REGN");
			}
			if(pstmt!=null)pstmt.close();
		}
 
	    //sql.setLength(0);
		
		if(result)
		{
			sql.delete(0,sql.length());
		
			sql.append("delete from MO_CLAIMANT where REGISTRATION_NO='"+registration_no+"' and FACILITY_ID='"+facility_id+"'");
			try
			{
				pstmt = con.prepareStatement(sql.toString());
				pstmt.executeUpdate();
			}
			catch (Exception e)
			{
				result = false;
				e.printStackTrace();
				java.util.Hashtable message = MessageManager.getMessage(locale,"ERROR_WHILE_Updating","IP");
				String msgVal = ((String) message.get("message"));
				message.clear();
				//msgVal = msgVal.substring(0,msgVal.length()-4);
				sb.append(msgVal+" MO_CLAIMANT");
			}			
			if(pstmt!=null)pstmt.close();

		}
		//Insert Query Modified Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg
		if(!CLAIMANT_TYPE.equals("") && result)
		 {
			//sql.setLength(0);
			sql.delete(0,sql.length());
			sql.append("insert into MO_CLAIMANT(FACILITY_ID,REGISTRATION_NO,CLAIMANT_TYPE, CLAIMANT_TYPE_CODE, RELATIONSHIP, NAME, JOB_TITLE, ADD_LINE1, ADD_LINE2, ADD_LINE3, ADD_LINE4, ZIP_CODE, COUNTRY_CODE,TELEPHONE_OFF, TELEPHONE_RES, EMAIL_ID, MOB_TEL_NO, NAT_ID_NO, ORGANIZATION_NAME, PATIENT_EMPLOYEE_ID, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,RES_TOWN_CODE,RES_AREA_CODE,REGION_CODE,RELEASE_TO_FACILITY,REASON,PASSPORT_NO,OTHER_IDENTIFICATION) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?,?,?,?,?,?,?)");

			try
			{
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
			  pstmt.setString(21 ,(modified_by_id==null) ?"" :modified_by_id	);                                  
			  pstmt.setString(22 ,(modified_at_ws_no==null) ?"" :modified_at_ws_no	);                          
			  pstmt.setString(23 ,(modified_facility_id==null) ?"" :modified_facility_id	);                      
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
			  
		   	  pstmt.executeUpdate();  
				
			}
			catch (Exception e)
			{
				result = false;
				e.printStackTrace();
				java.util.Hashtable message = MessageManager.getMessage(locale,"ERROR_WHILE_INSERTING","IP");
				String msgVal = ((String) message.get("message"));
				message.clear();
				//msgVal = msgVal.substring(0,msgVal.length()-4);
				sb.append(msgVal+" MO_CLAIMANT");
			}
			  
		  }		 
		if(rs1>0 && result)
		{
			result=true;
			con.commit();
			java.util.Hashtable message = MessageManager.getMessage( locale, "RECORD_MODIFIED","SM" ) ;
			sb.append( (String) message.get("message") ) ;
			message.clear();
		}
		else
		 con.rollback();

		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sb.toString() ) ;		
	}
	catch(Exception fe)
	{
			fe.printStackTrace(System.err);
			return results ;
	}
	finally	
	{
			try 
			{
				if (con != null) 
					ConnectionManager.returnConnection(con,p);
				if(pstmt!=null) 
					pstmt.close();
			}
			catch (Exception ee) 
			{
				ee.printStackTrace(System.err);
				return results ;
			}
	}
	sb.setLength(0);
	sql.setLength(0);
	ht.clear();
	return results ;
	}
	
}
