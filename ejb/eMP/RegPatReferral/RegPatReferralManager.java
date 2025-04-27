/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMP.RegPatReferral;

import java.rmi.* ;
import javax.ejb.* ;
import java.io.*;
import java.sql.* ;
import javax.naming.*;
import javax.rmi.*;
//import oracle.sql.*;
import webbeans.eCommon.*;
import java.util.*;
import eCommon.Common.*;

/**
*
* @ejb.bean
*	name="RegPatReferral"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="RegPatReferral"
*	local-jndi-name="RegPatReferral"
*	impl-class-name="eMP.RegPatReferral.RegPatReferralManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eMP.RegPatReferral.RegPatReferralLocal"
*	remote-class="eMP.RegPatReferral.RegPatReferralRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eMP.RegPatReferral.RegPatReferralLocalHome"
*	remote-class="eMP.RegPatReferral.RegPatReferralHome"
*	generate= "local,remote"
*
*
*/

public class RegPatReferralManager implements SessionBean {

	Connection con = null;
	PreparedStatement pstmt = null;
	PreparedStatement pstmt1 = null;
	ResultSet rs = null;

	
	public final String RECORD_INSERTED = "REFERRAL_REG_SUCCESS" ;
	public final String RECORD_MODIFIED = "RECORD_MODIFIED" ;

	String referralid = "";
	String facilityId = "";
	String referraldate="";
	String referralletterno="";
	String preferredtreatmentdate="";
	String receiveddate="";
	String fromreftype="";
	String fromrefcode="";
	String fromhcaresettingtype="";
	String fromlocntype="";
	String fromlocndesc="";
	String frompractname="";
	String patientid ="";
	String nameprefix="";
	String firstname ="";
	String secondname="";
	String thirdname ="";
	String familyname="";
	String namesuffix="";
	String patientname="";
	String sex="";
	String dateofbirth="";
	String nationalitycode="";
	
	
	String toreftype="";
	
	String tohcaresettingtype="";
	String tospecialitycode="";
	String tolocntype="";
	String tolocncode="";
	String toservicecode="";
	String topractid="";
	String priority="";
	String refnotes="";
	String status="";
	String currentyear="";
	String	addedAtWorkstation	="";
								
	String	national_id_no="";			
	String	alt_id1_no="";					
	String	alt_id2_no="";					
	String	alt_id3_no="";					
	String	alt_id4_no="";					
	String	alt_id1_exp_date="";        
	String	alt_id2_exp_date ="";       
	String	alt_id3_exp_date="";        
	String	alt_id4_exp_date="";        
	String	addr_line1="";                  
	String	addr_line2="";                  
	String	addr_line3="";                  
	String	addr_line4="";                  
	String	res_town_code="";           
	String	res_area_code="";            
	String	country_code="";             
	String	postal_code="";                
	String	mail_addr_line1="";          
	String	mail_addr_line2="";          
	String	mail_addr_line3="";          
	String	mail_addr_line4="";          
	String	mail_res_town_code="";   
	String	mail_res_area_code="";    
	String	mail_country_code="";     
	String	mail_postal_code="";       
	String	contact1_no="";                    
	String	contact2_no="";                   
	String	email=""; 								
	String	tel_no="";							
	String	mobile_no="";					
	String	pager_no=""; 					
	String	referral_reason_code="";	
	String	other_doc_att="";
	String	exm_clinical_find=""; 					
	String	diagnosis="";	
	String	treatment="";
	String	race_code="";
	String	citizen_yn="";
	String legal_yn="";
	String region_code="";
	String mail_region_code="";
	String from_speciality_code="";
	String referred_for_ip="";
	String Birth_place_code="";
	String ethnic_grp_code="";
	String birth_place_desc="";
	String other_alt_type="";
	String other_alt_Id="";
	String mod_referral_id="";
	String transfer_case_yn=""; //Added by Afruddin for ML-MMOH-CRF-1527 US0003 on 28-jun-2020
	String order_catalog_code="";
	String action="";
	String reason_code="";
	String remarks="";
	String apptNo="";
	String addedById = "";
	String modifiedById ="";

	String family_name_loc_lang="";
	String third_name_loc_lang="";
	String second_name_loc_lang="";
	String first_name_loc_lang="";
	String name_prefix_loc_lang="";
	String name_suffix_loc_lang="";
	String patient_name_loc_lang="";
	String patient_name_long="";
	String patient_name_loc_lang_long="";
	String regtrd_yn		= "";

	/*Added by Thamizh selvi on 6th Feb 2018 against ML-MMOH-CRF-0601 Start*/
	String altAddrLine1		= "";
	String altAddrLine2		= "";
	String altAddrLine3		= "";
	String altAddrLine4		= "";
	String altAreaCode		= "";
	String altTownCode		= "";
	String altPostalCode	= "";
	String altRegionCode	= "";
	String altCountryCode	= "";
	/*End*/
	//Maheshwaran K added for AAKH-CRF-0175 as on 23-08-2023
	String smartCardFunc ="";
	String biometric_reason="";


	StringBuffer sql = new StringBuffer();

	public void ejbCreate() {}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext( SessionContext context ) {}// this.ctx=context;}

/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

public java.util.HashMap insertRegPatReferral(
								java.util.Properties p,
								java.util.HashMap tabdata
								) 
		{

		 getInsertData(tabdata);
  		 java.util.HashMap results = new java.util.HashMap() ;
		 boolean result = false ;
	     boolean insertable = true ;
 		 StringBuffer sb = new StringBuffer( "" ) ;
		 addedById = p.getProperty( "login_user" ) ;
		 modifiedById = addedById ;
		 String locale="";
         locale=p.getProperty("LOCALE");
  		
		try
		{
			con=ConnectionManager.getConnection(p);
			con.setAutoCommit(false);

			java.util.HashMap ret = getReferralId(p,tabdata);
			boolean retval=((Boolean)ret.get("status")).booleanValue();
			sb.append((String)ret.get("error"));
			if(retval) insertable = true;
			else insertable = false;
 			ret.clear();

			int res=0;

			if ( insertable )
			{
			try
			{
				res=InsertData();
		
				sql.setLength(0);
				if(res != 0)
				{
					if(!(refnotes.equals("") && refnotes.equals(" ") && refnotes == null))
					{
						sql.append(" Select REF_NOTES from pr_referral_register where REFERRAL_ID ='"+referralid+"' for update ");

						pstmt =con.prepareStatement(sql.toString());
						rs = pstmt.executeQuery() ;
						Clob clb = null;
						if(rs!=null && rs.next())
						{
							  clb = rs.getClob(1);
							  //BufferedWriter w = new BufferedWriter(((CLOB)clb).getCharacterOutputStream());
							  Writer w=clb.setCharacterStream(1);
							  w.write(refnotes,0,refnotes.length());
							  w.flush();
							  w.close();
						}
						sql.setLength(0);
					}
					if(rs != null) rs.close();

					result = true;
					insertable=true;
					con.commit();
					java.util.Hashtable message = MessageManager.getMessage( locale, RECORD_INSERTED,"MP" ) ;
					sb.append( (String) message.get("message") ) ;
					message.clear();

				}
				else
				{
					result = false;
					insertable=false;
					try{
						con.rollback();
						}catch(Exception ec){ec.printStackTrace();}

				}
				sql.setLength(0);
				if(pstmt != null) pstmt.close();
			}catch(Exception e){
				con.rollback();
				result = false ;
				insertable=false;
				sb.append("Insert failed "+e);
				e.printStackTrace();
				
			}
		}
		tabdata.clear();
	 }
	 catch ( Exception e )
	 {
			insertable = false ;
			result = false ;	
			try{
			con.rollback();
			}catch(Exception ee){}
			sb.append( e+ "<br>" ) ;
			e.printStackTrace() ;
	}		
	 finally 
	{
		ConnectionManager.returnConnection(con,p);
	}
	results.put( "status", new Boolean(result) ) ;
	results.put( "error", sb.toString() ) ;
	results.put( "referralid", referralid) ;
	return results ;
}

/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
public java.util.HashMap updateRegPatReferral(java.util.Properties p,	java.util.HashMap tabdata) 					 
		{
		java.util.HashMap results = new java.util.HashMap() ;
		boolean result = false ;
		boolean insertable = true ;
		StringBuffer sb = new StringBuffer( "" ) ;
		addedById = p.getProperty( "login_user" ) ;
		modifiedById = addedById ;
		String locale="";
         locale=p.getProperty("LOCALE");
		try
		{
			con=ConnectionManager.getConnection(p);
			getUpdateData(tabdata);

			int res=UpdateData();
		    									
			if(pstmt != null) pstmt.close();
			sql.setLength(0);
			if(!(refnotes.equals("") && refnotes.equals(" ") && refnotes == null))
			{
				
				sql.append(" Select REF_NOTES from pr_referral_register where REFERRAL_ID ='"+mod_referral_id+"' for update ");
				pstmt=con.prepareStatement(sql.toString());
				rs = pstmt.executeQuery() ;
				Clob clb = null;
				if(rs.next())
				{
					  clb = rs.getClob(1);
					  //BufferedWriter w = new BufferedWriter(((CLOB)clb).getCharacterOutputStream());
					  Writer w=clb.setCharacterStream(1);
					  w.write(refnotes,0,refnotes.length());
					  w.flush();
					  w.close();
				}
				sql.setLength(0);
				if(pstmt != null) pstmt.close();
			}
		if(res != 0)
		{
		   insertable=true;
		}
		else
		   insertable=false;
	 int action_count=0;
	 if(insertable)
	    {
	      try
			{
		  if(!action.equals(""))
		    { 
		  String action_sql_cnt="select count(*) from pr_referral_register_action where referral_id='"+mod_referral_id+"' and action_type='"+action+"' ";
		  pstmt=con.prepareStatement(action_sql_cnt);
		  rs=pstmt.executeQuery();
		  
		  if(rs != null)
		    {
		      if(rs.next()){
			    action_count=rs.getInt(1);}
			}
		  if(rs != null) rs.close();
		  if(pstmt != null) pstmt.close();
		if(action_count == 0)
		{
		  String action_sql="insert into pr_referral_register_action  (FACILITY_ID,REFERRAL_ID,ACTION_DATE_TIME,ACTION_TYPE,ACTION_REASON_CODE,ACTION_REF_ID,ACTIONED_BY,ACTION_REMARKS,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID) values(?,?,sysdate,?,?,?,?,?,?,sysdate,?,?) ";
		  pstmt=con.prepareStatement(action_sql);
		  
		  pstmt.setString(1,facilityId);
		  pstmt.setString(2,mod_referral_id);
		  pstmt.setString(3,action);
		  pstmt.setString(4,reason_code);
		  pstmt.setString(5,apptNo);
		  pstmt.setString(6,addedById);
		  pstmt.setString(7,remarks);
		  pstmt.setString(8,addedById);
		  pstmt.setString(9,addedAtWorkstation);
		  pstmt.setString(10,facilityId);
		  
		  int acnt=pstmt.executeUpdate();
		  if(acnt != 0)      insertable=true;
		  else 				 insertable=false;
	   }
		else
		{
    	String update_action="update pr_referral_register_action set ACTION_DATE_TIME=sysdate,ACTION_REASON_CODE=?,ACTION_REF_ID=?,ACTIONED_BY=? , ACTION_REMARKS=? where referral_id=? and action_type=? and facility_id=? ";
		pstmt=con.prepareStatement(update_action);
		
		pstmt.setString(1,reason_code);
		pstmt.setString(2,apptNo);
		pstmt.setString(3,addedById);
		pstmt.setString(4,remarks);
		pstmt.setString(5,mod_referral_id);
		pstmt.setString(6,action);
		pstmt.setString(7,facilityId);
		
	    int accnt=pstmt.executeUpdate();
		if(accnt != 0)	    insertable=true;
		else			    insertable=false;
	}
		if(pstmt != null) pstmt.close();
      }
   }catch(Exception e){
		    insertable=false;
		    
			e.printStackTrace() ;

			}
	 }
	 if (insertable)
	  {
		result = true ;
		con.commit();
		java.util.Hashtable message = MessageManager.getMessage( locale, RECORD_MODIFIED,"SM" ) ;
		sb.append( (String) message.get("message") ) ;
		message.clear();
	  }else
	  {
	        result =false;
		con.rollback();
	  }
	  sql.setLength(0);
 	  if(rs != null) rs.close();
	  if(pstmt != null) pstmt.close();
	  tabdata.clear();
	 }
	 catch ( Exception e )
	 {
			insertable = false ;
			result = false ;
			try{
			con.rollback();}catch(Exception ce){}
			sb.append( e+ "<br>" ) ;
			e.printStackTrace() ;
	}
	 finally 
	{
		 if (con != null)
		 {
			 try {
					ConnectionManager.returnConnection(con,p);
				} catch (Exception ee) {sb.append( ee+ "<br>" ) ;}
		}
	}
		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sb.toString() ) ;
		results.put( "referralid", referralid) ;
		return results ;
}

public void getInsertData(HashMap tabdata)
{

		facilityId=(String)tabdata.get("facilityId");
		addedAtWorkstation=(String)tabdata.get("client_ip_address");		
		referraldate=(String)tabdata.get("referraldate");
		referralletterno=(String)tabdata.get("referralletterno");
		preferredtreatmentdate=(String)tabdata.get("preferredtreatmentdate");
		receiveddate=(String)tabdata.get("receiveddate");
		fromreftype=(String)tabdata.get("fromreftype");
		fromrefcode=(String)tabdata.get("fromrefcode");
		fromhcaresettingtype=(String)tabdata.get("fromhcaresettingtype");
		fromlocntype=(String)tabdata.get("fromlocntype");
		fromlocndesc=(String)tabdata.get("fromlocndesc");
		frompractname=(String)tabdata.get("frompractname");
		from_speciality_code=(String)tabdata.get("from_speciality_code");
		patientid=(String)tabdata.get("patientid");
		nameprefix=(String)tabdata.get("nameprefix");
		firstname=(String)tabdata.get("firstname");
		secondname=(String)tabdata.get("secondname");
		thirdname=(String)tabdata.get("thirdname");	
		familyname=(String)tabdata.get("familyname");
		namesuffix=(String)tabdata.get("namesuffix");
		patientname=(String)tabdata.get("patientname");
		sex=(String)tabdata.get("sex");
		dateofbirth=(String)tabdata.get("dateofbirth");
		nationalitycode=(String)tabdata.get("nationalitycode");
				
		toreftype=(String)tabdata.get("toreftype");
		
		tohcaresettingtype=(String)tabdata.get("tohcaresettingtype");
		tospecialitycode=(String)tabdata.get("tospecialitycode");
		tolocntype=(String)tabdata.get("tolocationtype");
		tolocncode=(String)tabdata.get("tolocationcode");
		toservicecode=(String)tabdata.get("toservicecode");
		topractid=(String)tabdata.get("topractid");
		priority=(String)tabdata.get("priority");
		refnotes=(String)tabdata.get("refnotes");
		status=(String)tabdata.get("status");
		currentyear=(String)tabdata.get("currentyear");
									
		national_id_no=(String)tabdata.get("national_id_no");			
		alt_id1_no=(String)tabdata.get("alt_id1_no");					
		alt_id2_no=(String)tabdata.get("alt_id2_no");					
		alt_id3_no=(String)tabdata.get("alt_id3_no");					
		alt_id4_no=(String)tabdata.get("alt_id4_no");					
		alt_id1_exp_date=(String)tabdata.get("alt_id1_exp_date");        
		alt_id2_exp_date =(String)tabdata.get("alt_id2_exp_date");       
		alt_id3_exp_date=(String)tabdata.get("alt_id3_exp_date");        
		alt_id4_exp_date=(String)tabdata.get("alt_id4_exp_date");  
		other_alt_type=(String)tabdata.get("other_alt_type");
		other_alt_Id=(String)tabdata.get("other_alt_Id");
		addr_line1=(String)tabdata.get("addr_line1");                  
		addr_line2=(String)tabdata.get("addr_line2");                  
		addr_line3=(String)tabdata.get("addr_line3");                  
		addr_line4=(String)tabdata.get("addr_line4");                  
		res_town_code=(String)tabdata.get("res_town_code");           
		res_area_code=(String)tabdata.get("res_area_code");            
		country_code=(String)tabdata.get("country_code");             
		postal_code=(String)tabdata.get("postal_code");                
		mail_addr_line1=(String)tabdata.get("mail_addr_line1");          
		mail_addr_line2=(String)tabdata.get("mail_addr_line2");          
		mail_addr_line3=(String)tabdata.get("mail_addr_line3");          
		mail_addr_line4=(String)tabdata.get("mail_addr_line4");          
		mail_res_town_code=(String)tabdata.get("mail_res_town_code");   
		mail_res_area_code=(String)tabdata.get("mail_res_area_code");    
		mail_country_code=(String)tabdata.get("mail_country_code");     
		mail_postal_code=(String)tabdata.get("mail_postal_code"); 
		mail_region_code=(String)tabdata.get("mail_region_code");
		contact1_no=(String)tabdata.get("contact1_no");                    
		contact2_no=(String)tabdata.get("contact2_no");                   
		email=(String)tabdata.get("email"); 								
		tel_no=(String)tabdata.get("tel_no");							
		mobile_no=(String)tabdata.get("mobile_no");					
		pager_no=(String)tabdata.get("pager_no"); 					
		referral_reason_code=(String)tabdata.get("referral_reason_code");	
		other_doc_att=(String)tabdata.get("other_doc_att");
		exm_clinical_find=(String)tabdata.get("exm_clinical_find"); 					
		diagnosis=(String)tabdata.get("diagnosis");	
		treatment=(String)tabdata.get("treatment");
		race_code=(String)tabdata.get("race_code");
		citizen_yn=(String)tabdata.get("citizen_yn");
		legal_yn=(String)tabdata.get("legal_yn");
		region_code=(String)tabdata.get("region_code");		
		referred_for_ip=(String)tabdata.get("referred_for_ip");
		Birth_place_code=(String)tabdata.get("Birth_place_code");
		ethnic_grp_code=(String)tabdata.get("ethnic_grp_code");
		birth_place_desc=(String)tabdata.get("birth_place_desc");
		order_catalog_code=(String)tabdata.get("order_catalog_code");

		/*Added by Thamizh selvi on 31st Jan 2018 against ML-MMOH-CRF-0601 Start*/
		altAddrLine1	= checkForNull((String)tabdata.get("altAddrLine1"));
		altAddrLine2	= checkForNull((String)tabdata.get("altAddrLine2"));
		altAddrLine3	= checkForNull((String)tabdata.get("altAddrLine3"));
		altAddrLine4	= checkForNull((String)tabdata.get("altAddrLine4"));
		altAreaCode		= checkForNull((String)tabdata.get("altAreaCode"));
		altTownCode		= checkForNull((String)tabdata.get("altTownCode"));
		altPostalCode	= checkForNull((String)tabdata.get("altPostalCode"));
		altRegionCode	= checkForNull((String)tabdata.get("altRegionCode"));
		altCountryCode	= checkForNull((String)tabdata.get("altCountryCode"));
		transfer_case_yn = checkForNull((String)tabdata.get("transfer_case_yn")); //Added by Afruddin for ML-MMOH-CRF-1527 US0003 on 28-jun-2020
		
		/*End*/

		first_name_loc_lang=(String)tabdata.get("first_name_loc_lang");
		second_name_loc_lang=(String)tabdata.get("second_name_loc_lang");
		third_name_loc_lang=(String)tabdata.get("third_name_loc_lang");
		family_name_loc_lang=(String)tabdata.get("family_name_loc_lang");
		name_prefix_loc_lang=(String)tabdata.get("name_prefix_loc_lang");
		name_suffix_loc_lang=(String)tabdata.get("name_suffix_loc_lang");
		patient_name_loc_lang=(String)tabdata.get("patient_name_loc_lang");

		patient_name_long=(String)tabdata.get("patient_name_long");
		patient_name_loc_lang_long=(String)tabdata.get("patient_name_loc_lang_long");

		regtrd_yn=(String)tabdata.get("regtrd_yn");
		
		//Maheshwaran K added for AAKH-CRF-0175 as on 23-08-2023	
		smartCardFunc=(String)tabdata.get("smartCardFunc");		
		biometric_reason=(String)tabdata.get("biometric_reason");
		//Ends

}

public int InsertData()
{
		
		int rest=0;
		sql.setLength(0);
		try
		{
		sql.append(" Insert into pr_referral_register ( referral_id, referral_date, referral_letter_no, ");
		sql.append(" preferred_treatment_date, received_date, from_ref_type,  ");

		if (fromreftype.equals("X"))
		{
            if (regtrd_yn.equals("Y"))
			sql.append(" from_ref_code,  from_hcare_setting_type, from_locn_type, from_locn_desc, from_pract_id, ");
         else 
			sql.append(" from_ref_code,  from_hcare_setting_type, from_locn_type, from_locn_desc, from_pract_name, ");
		}  
		else
		{
			sql.append(" from_facility_id, from_hcare_setting_type, from_locn_type, from_locn_code, from_pract_id, ");
		}  													
			
		sql.append(" patient_id,name_prefix, first_name,second_name, third_name,family_name,name_suffix, patient_name ,sex , ");
		sql.append(" date_of_birth,  nationality_code, addr_line1,  addr_line2, addr_line3, addr_line4,contact1_no,contact2_no, ");
		sql.append(" to_ref_type, to_facility_id, to_hcare_setting_type , to_speciality_code , to_locn_type , to_locn_code , ");
		sql.append(" to_service_code , to_pract_id, referral_priority , ref_notes , status , added_by_id,"); sql.append("added_date,added_at_ws_no,added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id, "); 
		sql.append(" national_id_no,alt_id1_no,alt_id2_no,alt_id3_no, alt_id4_no,alt_id1_date,alt_id2_date, alt_id3_date , ");						 
		sql.append(" alt_id4_date , res_town_code,res_area_code,country_code, postal_code,mail_addr_line1,mail_addr_line2,mail_addr_line3, ");	sql.append("mail_addr_line4, mail_res_town_code,mail_res_area_code,mail_country_code , mail_postal_code , ");					   
		sql.append(" pract_res_tel_num ,pract_mobile_num,pract_pager_num ,referral_reason_code ,other_doc_att,exam_and_clin_findings ,diagnosis , ");
		sql.append(" treatment ,race_code ,citizen_yn ,legal_illegal_yn , region_code , mail_region_code , referred_for_ip , ");
		sql.append(" email_id , birth_place_code , ethnic_grp_code , birth_place_desc ,oth_alt_id_type ,oth_alt_id_no ,from_speciality_code, ORDER_CATALOG_CODE,first_name_loc_lang ,second_name_loc_lang ,third_name_loc_lang ,family_name_loc_lang ,name_prefix_loc_lang , name_suffix_loc_lang , patient_name_loc_lang,PATIENT_LONG_NAME,PATIENT_LONG_NAME_LOC_LANG, ");
		sql.append(" alt_addr_line1, alt_addr_line2, alt_addr_line3, alt_addr_line4, alt_area_code, alt_town_code, alt_region_code, alt_postal_code, alt_country_code, transfer_case_yn )");//Modified by Thamizh selvi on 6th Feb 2018 against ML-MMOH-CRF-0601 //Modified by Afruddin for ML-MMOH-CRF-1527 US0003 on 28-jun-2020
		sql.append(" values ( ?,to_date(?,'dd/mm/yyyy hh24:mi'),?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy hh24:mi') ,");
		sql.append("?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,empty_clob(),?,?,sysdate,?,?,?,sysdate,");
		sql.append("?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"); //Modified by Afruddin for ML-MMOH-CRF-1527 US0003 on 28-jun-2020
		
		pstmt = con.prepareStatement(sql.toString());
		pstmt.setString	( 1, referralid) ;
		pstmt.setString	( 2, referraldate);
		pstmt.setString	( 3, referralletterno);
		pstmt.setString	( 4, preferredtreatmentdate);
		pstmt.setString	( 5, receiveddate);
		pstmt.setString	( 6, fromreftype);
		pstmt.setString	( 7, fromrefcode);
		pstmt.setString	( 8, fromhcaresettingtype);
		pstmt.setString	( 9, fromlocntype);
		pstmt.setString	( 10, fromlocndesc);
		pstmt.setString	( 11, frompractname);
		pstmt.setString	( 12, patientid);
		pstmt.setString	( 13, nameprefix);
		pstmt.setString	( 14, firstname);
		pstmt.setString	( 15, secondname);
		pstmt.setString	( 16, thirdname);
		pstmt.setString	( 17, familyname);
		pstmt.setString	( 18, namesuffix);
		pstmt.setString	( 19, patientname);
		pstmt.setString	( 20, sex);
		pstmt.setString	( 21, dateofbirth);
		pstmt.setString	( 22, nationalitycode);
		pstmt.setString	( 23, addr_line1);
		pstmt.setString	( 24, addr_line2);
		pstmt.setString	( 25, addr_line3);
		pstmt.setString	( 26, addr_line4);
		pstmt.setString	( 27, contact1_no);
		pstmt.setString	( 28, contact2_no);
		pstmt.setString	( 29, toreftype);
		pstmt.setString	( 30, facilityId);
		pstmt.setString	( 31, tohcaresettingtype);
		pstmt.setString	( 32, tospecialitycode);
		pstmt.setString	( 33, tolocntype);
		pstmt.setString	( 34, tolocncode);
		pstmt.setString	( 35, toservicecode);
		pstmt.setString	( 36, topractid);
		pstmt.setString	( 37, priority);
		pstmt.setString	( 38, status);
		pstmt.setString	( 39, addedById);
		pstmt.setString	( 40, addedAtWorkstation);
		pstmt.setString	( 41, facilityId);
		pstmt.setString	( 42, modifiedById);
		pstmt.setString	( 43, addedAtWorkstation);
		pstmt.setString	( 44, facilityId);///
		pstmt.setString	( 45, national_id_no);          
		pstmt.setString	( 46, alt_id1_no);                 
		pstmt.setString	( 47, alt_id2_no);                 
		pstmt.setString	( 48, alt_id3_no);                 
		pstmt.setString	( 49, alt_id4_no);                 
		pstmt.setString	( 50, alt_id1_exp_date);       
		pstmt.setString	( 51, alt_id2_exp_date);       
		pstmt.setString	( 52, alt_id3_exp_date);       
		pstmt.setString	( 53, alt_id4_exp_date );      
		pstmt.setString	( 54, res_town_code );         
		pstmt.setString	( 55, res_area_code );          
		pstmt.setString	( 56, country_code);            
		pstmt.setString	( 57, postal_code );              
		pstmt.setString	( 58, mail_addr_line1);        
		pstmt.setString	( 59, mail_addr_line2);        
		pstmt.setString	( 60, mail_addr_line3);        
		pstmt.setString	( 61, mail_addr_line4);        
		pstmt.setString	( 62, mail_res_town_code);  
		pstmt.setString	( 63, mail_res_area_code ); 
		pstmt.setString	( 64, mail_country_code);    
		pstmt.setString	( 65, mail_postal_code);      
		pstmt.setString	( 66, tel_no);    
		pstmt.setString	( 67, mobile_no);    
		pstmt.setString	( 68, pager_no);      
		pstmt.setString	( 69, referral_reason_code);
		pstmt.setString	( 70, other_doc_att);     
		pstmt.setString	( 71, exm_clinical_find);      
		pstmt.setString	( 72, diagnosis);
		pstmt.setString	( 73, treatment);            
		pstmt.setString	( 74, race_code);      
		pstmt.setString	( 75, citizen_yn);
		pstmt.setString	( 76, legal_yn);            
		pstmt.setString	( 77, region_code);
		pstmt.setString	( 78, mail_region_code);   
		pstmt.setString	( 79, referred_for_ip);
		pstmt.setString	( 80, email);
		pstmt.setString	( 81, Birth_place_code); 
		pstmt.setString	( 82, ethnic_grp_code); 
		pstmt.setString	( 83, birth_place_desc);
		pstmt.setString	( 84, other_alt_type); 
		pstmt.setString	( 85, other_alt_Id); 
		pstmt.setString	( 86, from_speciality_code); 
		pstmt.setString ( 87, order_catalog_code);
		pstmt.setString ( 88, first_name_loc_lang);
		pstmt.setString ( 89, second_name_loc_lang);
		pstmt.setString ( 90, third_name_loc_lang);
		pstmt.setString ( 91, family_name_loc_lang);
		pstmt.setString ( 92, name_prefix_loc_lang);
		pstmt.setString ( 93, name_suffix_loc_lang);
		pstmt.setString ( 94, patient_name_loc_lang);
		pstmt.setString ( 95, patient_name_long);
		pstmt.setString ( 96, patient_name_loc_lang_long);
		/*Added by Thamizh selvi on 31st Jan 2018 against ML-MMOH-CRF-0601 Start*/
		pstmt.setString (97, altAddrLine1);
		pstmt.setString (98, altAddrLine2);
		pstmt.setString (99, altAddrLine3);
		pstmt.setString (100, altAddrLine4);
		pstmt.setString (101, altAreaCode);
		pstmt.setString (102, altTownCode);
		pstmt.setString (103, altRegionCode);
		pstmt.setString (104, altPostalCode);
		pstmt.setString (105, altCountryCode);
		pstmt.setString (106, transfer_case_yn); //Added by Afruddin for ML-MMOH-CRF-1527 US0003 on 28-jun-2020
		/*End*/
		
		rest = pstmt.executeUpdate() ;
		if(pstmt != null) pstmt.close();
		
		//Maheshwaran K added for AAKH-CRF-0175 as on 23-08-2023
		//Starts
		try 
			{
			//String biometric_reason=(String)ae_values_add_visit.get("biometric_reason");
			if(rest!=0 && smartCardFunc.equals("01") && !biometric_reason.equals(""))
				{
				//System.err.println(facilityId+" "+"MP_REG_REFERRAL"+" "+patientid+referralid+" "+tolocncode+" "+biometric_reason+" "+addedAtWorkstation+" "+modifiedById);
				String status=CommonBean.insertReasonforBiometric(con,facilityId,"MP_REG_REFERRAL",patientid,referralid,tolocncode,biometric_reason,addedAtWorkstation,modifiedById);
				if(status.equals("S"))
					{
					rest	= 1;	
					}
				else {
					rest	= 0;
					}	
				} 
			}
		catch(Exception e)
			{
			rest	= 0;
			e.printStackTrace();
			}
		//Ends	
		}catch(Exception e)
		{
			rest=0;
			
						e.printStackTrace() ;

		}

		return rest;
}

public void getUpdateData(HashMap tabdata)
{
	
			facilityId=(String)tabdata.get("facilityId");
			addedAtWorkstation=(String)tabdata.get("client_ip_address");	
			mod_referral_id=(String)tabdata.get("referral_id");
			referraldate=(String)tabdata.get("referraldate");
			referralletterno=(String)tabdata.get("referralletterno");
			preferredtreatmentdate=(String)tabdata.get("preferredtreatmentdate");
			receiveddate=(String)tabdata.get("receiveddate");
			fromreftype=(String)tabdata.get("fromreftype");
			fromrefcode=(String)tabdata.get("fromrefcode");
			fromhcaresettingtype=(String)tabdata.get("fromhcaresettingtype");
			fromlocntype=(String)tabdata.get("fromlocntype");
			fromlocndesc=(String)tabdata.get("fromlocndesc");
			frompractname=(String)tabdata.get("frompractname");
			from_speciality_code=(String)tabdata.get("from_speciality_code");
			patientid=(String)tabdata.get("patientid");
			nameprefix=(String)tabdata.get("nameprefix");
			firstname=(String)tabdata.get("firstname");
			secondname=(String)tabdata.get("secondname");
			thirdname=(String)tabdata.get("thirdname");		familyname=(String)tabdata.get("familyname");
			namesuffix=(String)tabdata.get("namesuffix");		patientname=(String)tabdata.get("patientname");
			sex=(String)tabdata.get("sex");
			dateofbirth=(String)tabdata.get("dateofbirth");
			nationalitycode=(String)tabdata.get("nationalitycode");
			
			
			toreftype=(String)tabdata.get("toreftype");
			
			tohcaresettingtype=(String)tabdata.get("tohcaresettingtype");
			tospecialitycode=(String)tabdata.get("tospecialitycode");
			tolocntype=(String)tabdata.get("tolocationtype");
			tolocncode=(String)tabdata.get("tolocationcode");
			toservicecode=(String)tabdata.get("toservicecode");
			topractid=(String)tabdata.get("topractid");
			priority=(String)tabdata.get("priority");
			refnotes=(String)tabdata.get("refnotes");
			status=(String)tabdata.get("status");
			currentyear=(String)tabdata.get("currentyear");
			
			national_id_no=(String)tabdata.get("national_id_no");			
			alt_id1_no=(String)tabdata.get("alt_id1_no");					
			alt_id2_no=(String)tabdata.get("alt_id2_no");					
			alt_id3_no=(String)tabdata.get("alt_id3_no");					
			alt_id4_no=(String)tabdata.get("alt_id4_no");					
			alt_id1_exp_date=(String)tabdata.get("alt_id1_exp_date");        
			alt_id2_exp_date =(String)tabdata.get("alt_id2_exp_date");       
			alt_id3_exp_date=(String)tabdata.get("alt_id3_exp_date");        
			alt_id4_exp_date=(String)tabdata.get("alt_id4_exp_date");  
			other_alt_type=(String)tabdata.get("other_alt_type");
			other_alt_Id=(String)tabdata.get("other_alt_Id");
			addr_line1=(String)tabdata.get("addr_line1");                  
			addr_line2=(String)tabdata.get("addr_line2");                  
			addr_line3=(String)tabdata.get("addr_line3");                  
			addr_line4=(String)tabdata.get("addr_line4");                  
			res_town_code=(String)tabdata.get("res_town_code");           
			res_area_code=(String)tabdata.get("res_area_code");            
			country_code=(String)tabdata.get("country_code");             
			postal_code=(String)tabdata.get("postal_code");                
			mail_addr_line1=(String)tabdata.get("mail_addr_line1");          
			mail_addr_line2=(String)tabdata.get("mail_addr_line2");          
			mail_addr_line3=(String)tabdata.get("mail_addr_line3");          
			mail_addr_line4=(String)tabdata.get("mail_addr_line4");          
			mail_res_town_code=(String)tabdata.get("mail_res_town_code");   
			mail_res_area_code=(String)tabdata.get("mail_res_area_code");    
			mail_country_code=(String)tabdata.get("mail_country_code");     
			mail_postal_code=(String)tabdata.get("mail_postal_code"); 
			mail_region_code=(String)tabdata.get("mail_region_code");
			contact1_no=(String)tabdata.get("contact1_no");                    
			contact2_no=(String)tabdata.get("contact2_no");                   
			email=(String)tabdata.get("email"); 								
			tel_no=(String)tabdata.get("tel_no");							
			mobile_no=(String)tabdata.get("mobile_no");					
			pager_no=(String)tabdata.get("pager_no"); 					
			referral_reason_code=(String)tabdata.get("referral_reason_code");	
			other_doc_att=(String)tabdata.get("other_doc_att");
			exm_clinical_find=(String)tabdata.get("exm_clinical_find"); 					
			diagnosis=(String)tabdata.get("diagnosis");	
			treatment=(String)tabdata.get("treatment");
			race_code=(String)tabdata.get("race_code");
			citizen_yn=(String)tabdata.get("citizen_yn");
			legal_yn=(String)tabdata.get("legal_yn");
			region_code=(String)tabdata.get("region_code");		
			referred_for_ip=(String)tabdata.get("referred_for_ip");
			Birth_place_code=(String)tabdata.get("Birth_place_code");
			ethnic_grp_code=(String)tabdata.get("ethnic_grp_code");
			birth_place_desc=(String)tabdata.get("birth_place_desc");


			order_catalog_code=(String)tabdata.get("order_catalog_code");
			action=(String)tabdata.get("action");
			reason_code=(String)tabdata.get("reason_code");
			remarks=(String)tabdata.get("remarks");
			apptNo=(String)tabdata.get("apptNo");

			first_name_loc_lang=(String)tabdata.get("first_name_loc_lang");
			second_name_loc_lang=(String)tabdata.get("second_name_loc_lang");
			third_name_loc_lang=(String)tabdata.get("third_name_loc_lang");
			family_name_loc_lang=(String)tabdata.get("family_name_loc_lang");
			name_prefix_loc_lang=(String)tabdata.get("name_prefix_loc_lang");
			name_suffix_loc_lang=(String)tabdata.get("name_suffix_loc_lang");
			patient_name_loc_lang=(String)tabdata.get("patient_name_loc_lang");
            regtrd_yn=(String)tabdata.get("regtrd_yn");

			patient_name_long=(String)tabdata.get("patient_name_long");
			patient_name_loc_lang_long=(String)tabdata.get("patient_name_loc_lang_long");

			/*Added by Thamizh selvi on 31st Jan 2018 against ML-MMOH-CRF-0601 Start*/
			altAddrLine1	= checkForNull((String)tabdata.get("altAddrLine1"));
			altAddrLine2	= checkForNull((String)tabdata.get("altAddrLine2"));
			altAddrLine3	= checkForNull((String)tabdata.get("altAddrLine3"));
			altAddrLine4	= checkForNull((String)tabdata.get("altAddrLine4"));
			altAreaCode		= checkForNull((String)tabdata.get("altAreaCode"));
			altTownCode		= checkForNull((String)tabdata.get("altTownCode"));
			altPostalCode	= checkForNull((String)tabdata.get("altPostalCode"));
			altRegionCode	= checkForNull((String)tabdata.get("altRegionCode"));
			altCountryCode	= checkForNull((String)tabdata.get("altCountryCode"));
			transfer_case_yn	= checkForNull((String)tabdata.get("transfer_case_yn")); //Added by Afruddin for ML-MMOH-CRF-1527 US0003 on 28-jun-2020	
			
			/*End*/			
			//Maheshwaran K added for AAKH-CRF-0175 as on 23-08-2023	
			smartCardFunc=(String)tabdata.get("smartCardFunc");		
			biometric_reason=(String)tabdata.get("biometric_reason");
			//Ends


}

public int UpdateData()
{
	
	int rest=0;
	sql.setLength(0);	
	try
	{		
					
			sql.append(" update pr_referral_register set referral_date=to_date(?,'dd/mm/yyyy hh24:mi'), referral_letter_no=?,  preferred_treatment_date=to_date(?,'dd/mm/yyyy'),   received_date=to_date(?,'dd/mm/yyyy hh24:mi'),  ");
			if (fromreftype.equals("X"))
			{
			  if (regtrd_yn.equals("Y"))
			    sql.append("from_ref_code=?,from_facility_id = null ,  from_hcare_setting_type=?, from_locn_type=?, from_locn_desc=?, from_pract_id=?,from_pract_name=null, ");
             else
				sql.append("from_ref_code=?,from_facility_id = null ,  from_hcare_setting_type=?, from_locn_type=?, from_locn_desc=?,from_pract_id=null, from_pract_name=?, ");
			}  
			else
			{
				sql.append("from_facility_id=?,from_ref_code = null ,  from_hcare_setting_type=?, from_locn_type=?, from_locn_code=?, from_pract_id=?, ");
			}  		

			sql.append("  patient_id=?,  name_prefix=?,  first_name=?, second_name=?,  third_name=?,   family_name=?,   name_suffix=?,   patient_name=? ,sex=? ,");
			sql.append("date_of_birth=to_date(?,'dd/mm/yyyy'),  nationality_code=?,   addr_line1=?, addr_line2=?, addr_line3=?, addr_line4=?, contact1_no=?,");
			sql.append("contact2_no=?, to_facility_id=?, to_hcare_setting_type=? ,to_speciality_code=? ,to_locn_type=?,to_locn_code=?, to_service_code=? ,");
			sql.append("to_pract_id=?, referral_priority=? , status =?,ref_notes =empty_clob(),from_ref_type=?, modified_by_id=?, modified_date=sysdate, modified_at_ws_no=?, modified_facility_id=?,");
	 
				
			sql.append(" national_id_no=?,	alt_id1_no=?,alt_id2_no=?,alt_id3_no=?, alt_id4_no=?,  alt_id1_date=to_date(?,'dd/mm/yyyy'),  ");		
			sql.append(" alt_id2_date=to_date(?,'dd/mm/yyyy'), alt_id3_date =to_date(?,'dd/mm/yyyy'), alt_id4_date =to_date(?,'dd/mm/yyyy'), ");
			sql.append(" res_town_code=?,  res_area_code=?,  country_code=?,  postal_code=?, mail_addr_line1=?, ");
			sql.append(" mail_addr_line2=?, mail_addr_line3=?, mail_addr_line4=?, mail_res_town_code=?,mail_res_area_code=?, ");							  
			sql.append(" mail_country_code =?, mail_postal_code =?,pract_res_tel_num =?, pract_mobile_num=?, pract_pager_num =?, referral_reason_code =?, ");
			sql.append(" other_doc_att=?, exam_and_clin_findings =?,diagnosis =?, treatment =?,race_code=?,citizen_yn=?,legal_illegal_yn=?,region_code=?,");
			sql.append("mail_region_code=?,from_speciality_code=? ,referred_for_ip=?,email_id=?,birth_place_code=?, ethnic_grp_code=?,birth_place_desc=?,oth_alt_id_type=?,oth_alt_id_no=?,ORDER_CATALOG_CODE=? , first_name_loc_lang=? ,second_name_loc_lang=? ,third_name_loc_lang=? ,family_name_loc_lang=? ,name_prefix_loc_lang=? , name_suffix_loc_lang=? , patient_name_loc_lang=?,PATIENT_LONG_NAME=?,PATIENT_LONG_NAME_LOC_LANG=?, alt_addr_line1 = ?, alt_addr_line2 = ?, alt_addr_line3 = ?, alt_addr_line4 = ?, alt_area_code = ?, alt_town_code = ?, alt_region_code = ?, alt_postal_code = ?, alt_country_code = ?, transfer_case_yn =? where referral_id=? ");//Modified by Thamizh selvi on 6th Feb 2018 against ML-MMOH-CRF-0601	//Modified by Afruddin for ML-MMOH-CRF-1527 US0003 on 28-jun-2020			
				
				
				
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString	( 1, referraldate);
			pstmt.setString	( 2, referralletterno);
			pstmt.setString	( 3, preferredtreatmentdate);
			pstmt.setString	( 4, receiveddate);
			pstmt.setString	( 5, fromrefcode);
			pstmt.setString	( 6, fromhcaresettingtype);
			pstmt.setString	( 7, fromlocntype);
			pstmt.setString	( 8, fromlocndesc);
			pstmt.setString	( 9, frompractname);
			pstmt.setString	( 10, patientid);
			pstmt.setString	( 11, nameprefix);
			pstmt.setString	( 12, firstname);
			pstmt.setString	( 13, secondname);
			pstmt.setString	( 14, thirdname);
			pstmt.setString	( 15, familyname);
			pstmt.setString	( 16, namesuffix);
			pstmt.setString	( 17, patientname);
			pstmt.setString	( 18, sex);
			pstmt.setString	( 19, dateofbirth);
			pstmt.setString	( 20, nationalitycode);
			pstmt.setString	( 21, addr_line1);
			pstmt.setString	( 22, addr_line2);
			pstmt.setString	( 23, addr_line3);
			pstmt.setString	( 24, addr_line4);
			pstmt.setString	( 25, contact1_no);
			pstmt.setString	( 26, contact2_no);
			pstmt.setString	( 27, facilityId);
			pstmt.setString	( 28, tohcaresettingtype);
			pstmt.setString( 29, tospecialitycode);
			pstmt.setString	( 30, tolocntype);
			pstmt.setString	( 31, tolocncode);
			pstmt.setString(32,toservicecode);
			pstmt.setString	( 33, topractid);
			pstmt.setString	( 34, priority);
			pstmt.setString	( 35, status);
			pstmt.setString	( 36, fromreftype);
			pstmt.setString	( 37, modifiedById);
			pstmt.setString	( 38, addedAtWorkstation);
			pstmt.setString	( 39, facilityId);
								
			pstmt.setString	( 40 ,national_id_no);
			pstmt.setString	( 41, alt_id1_no); 
			pstmt.setString	( 42, alt_id2_no);
			pstmt.setString	( 43, alt_id3_no);
			pstmt.setString	( 44, alt_id4_no);
			pstmt.setString	( 45, alt_id1_exp_date);       
			pstmt.setString	( 46, alt_id2_exp_date);       
			pstmt.setString	( 47, alt_id3_exp_date);       
			pstmt.setString	( 48, alt_id4_exp_date );      
			pstmt.setString	( 49, res_town_code );         
			pstmt.setString	( 50, res_area_code );          
			pstmt.setString	( 51, country_code);            
			pstmt.setString	( 52, postal_code );              
			pstmt.setString	( 53, mail_addr_line1);        
			pstmt.setString	( 54, mail_addr_line2);        
			pstmt.setString	( 55, mail_addr_line3);        
			pstmt.setString	( 56, mail_addr_line4);        
			pstmt.setString	( 57, mail_res_town_code);  
			pstmt.setString	( 58, mail_res_area_code ); 
			pstmt.setString	( 59, mail_country_code);    
			pstmt.setString	( 60, mail_postal_code);      
			pstmt.setString	( 61, tel_no);    
			pstmt.setString	( 62, mobile_no);    
			pstmt.setString	( 63, pager_no);      
			pstmt.setString	( 64, referral_reason_code);
			pstmt.setString	( 65, other_doc_att);            
			pstmt.setString	( 66, exm_clinical_find);      
			pstmt.setString	( 67, diagnosis);
			pstmt.setString	( 68, treatment);            
			pstmt.setString	( 69, race_code);      
			pstmt.setString	( 70, citizen_yn);
			pstmt.setString	( 71, legal_yn);
			pstmt.setString	( 72, region_code);
			pstmt.setString	( 73, mail_region_code);            
			pstmt.setString	( 74, from_speciality_code) ;					
			pstmt.setString	( 75, referred_for_ip) ;
			pstmt.setString	( 76, email) ;
			pstmt.setString	( 77, Birth_place_code) ;
			pstmt.setString	( 78, ethnic_grp_code) ;
			pstmt.setString	( 79, birth_place_desc) ;
			pstmt.setString	( 80, other_alt_type); 
			pstmt.setString	( 81, other_alt_Id);
			pstmt.setString ( 82, order_catalog_code);
			pstmt.setString ( 83, first_name_loc_lang);
			pstmt.setString ( 84, second_name_loc_lang);
			pstmt.setString ( 85, third_name_loc_lang);
			pstmt.setString ( 86, family_name_loc_lang);
			pstmt.setString ( 87, name_prefix_loc_lang);
			pstmt.setString ( 88, name_suffix_loc_lang);
			pstmt.setString ( 89, patient_name_loc_lang);
			pstmt.setString ( 90, patient_name_long);
			pstmt.setString ( 91, patient_name_loc_lang_long);
			/*Added by Thamizh selvi on 31st Jan 2018 against ML-MMOH-CRF-0601 Start*/
			pstmt.setString (92, altAddrLine1);
			pstmt.setString (93, altAddrLine2);
			pstmt.setString (94, altAddrLine3);
			pstmt.setString (95, altAddrLine4);
			pstmt.setString (96, altAreaCode);
			pstmt.setString (97, altTownCode);
			pstmt.setString (98, altRegionCode);
			pstmt.setString (99, altPostalCode);
			pstmt.setString (100, altCountryCode);
			pstmt.setString (101, transfer_case_yn); //Added by Afruddin for ML-MMOH-CRF-1527 US0003 on 28-jun-2020
			
			/*End*/

			pstmt.setString	( 102, mod_referral_id) ; //Modified by Afruddin for ML-MMOH-CRF-1527 US0003 on 28-jun-2020

			rest=pstmt.executeUpdate() ;
			if(pstmt != null) pstmt.close();
			//Maheshwaran K added for AAKH-CRF-0175 as on 23-08-2023
			//Starts
			try 
				{
				//String biometric_reason=(String)ae_values_add_visit.get("biometric_reason");
				if(rest!=0 && smartCardFunc.equals("01") && !biometric_reason.equals(""))
					{
					String status=CommonBean.insertReasonforBiometric(con,facilityId,"MP_REG_REFERRAL",patientid,referralid,tolocncode,biometric_reason,addedAtWorkstation,modifiedById);
					if(status.equals("S"))
						{
						rest	= 1;	
						}
					else {
						rest	= 0;
						}	
					} 
				}
			catch(Exception e)
				{
				rest	= 0;
				e.printStackTrace();
				}
			//Ends	
	}catch(Exception e)
	{
		rest=0;
		
								e.printStackTrace() ;


	}
   
    return rest;
}

	public java.util.HashMap getReferralId(
											java.util.Properties p,
											HashMap tabdata									
											)
		{

			
			StringBuffer sbin=new StringBuffer("") ;
			java.util.HashMap results = new java.util.HashMap() ;
			boolean result = true ;
			//StringBuffer insertsql = new StringBuffer();
			//StringBuffer selectsql = new StringBuffer();
			Connection conn=null;
			CallableStatement cstmt=null;
			String errormsg="";
			try
			{
				addedById		 = p.getProperty( "login_user" ) ;
				facilityId=(String)tabdata.get("facilityId");
				currentyear=(String)tabdata.get("currentyear");
				addedAtWorkstation=(String)tabdata.get("client_ip_address");
				conn=ConnectionManager.getConnection(p);				
				conn.setAutoCommit(false);
								
				cstmt=conn.prepareCall("{call PR_GENERATE_REFERRAL_ID(?,?,?,?,?,?)}");
				cstmt.setString(1,facilityId);
				cstmt.setString(2,currentyear);
				cstmt.setString(3,addedById);
				cstmt.setString(4,addedAtWorkstation);
				cstmt.registerOutParameter(5,java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(6,java.sql.Types.VARCHAR);

				cstmt.execute();

				errormsg=cstmt.getString(6);
				if(errormsg ==null) errormsg="";

				if(errormsg.equals(""))
				{
					referralid=cstmt.getString(5);
					result = true ;
				}else
				{
					result = false ;
					sbin.append(errormsg);
				}
			tabdata.clear();
			if(cstmt != null) cstmt.close();

			}catch (Exception e){
				result = false ;
				sbin.append(e);
				try{	conn.rollback();}catch(Exception ce){}
			}
			finally
			{
				ConnectionManager.returnConnection(conn,p);
			}
			results.put( "status", new Boolean(result) ) ;
			results.put( "error", sbin.toString() ) ;
			return results ;

		} // end getReferralId

	public static String checkForNull(String inputString){
		return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
	}
}
