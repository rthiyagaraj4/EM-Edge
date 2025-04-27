/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMO.EmbalmRegistration;
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
*	name="EmbalmRegistration"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="EmbalmRegistration"
*	local-jndi-name="EmbalmRegistration"
*	impl-class-name="eMO.EmbalmRegistration.MOEmbalmRegnManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eMO.EmbalmRegistration.MOEmbalmRegnLocal"
*	remote-class="eMO.EmbalmRegistration.MOEmbalmRegnRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eMO.EmbalmRegistration.MOEmbalmRegnLocalHome"
*	remote-class="eMO.EmbalmRegistration.MOEmbalmRegnHome"
*	generate= "local,remote"
*
*
*/

public class MOEmbalmRegnManager implements SessionBean
{
        java.util.HashMap results	   	    = null;    
        SessionContext ctx;
	   // boolean result					    = false ;
      //  Connection con ;
	   // PreparedStatement pstmt			    = null ;
	    Statement stmt	                    = null;
	    ResultSet rs					    = null; 
		StringBuffer  sb					= new StringBuffer();
		String facility_id 					= "";	
		String srl_no						= "";
	    String hiv_yn 			   			= "";
		String hep_yn 			   			= "";
		String requestor_id 			   	= "";
		String requestor_sex 			   	= "";
		String Patient_ID 			     	= "";
		String requestor_dob 			    = "";
		String national_id_no 			    = "";
		String embalm_proc_date 		    = "";
		String embalm_req_date 		        = "";
		String embalm_from_time 		    = "";
		String embalm_to_time 		        = "";
		String embalm_fluid_qty 		    = "";
		String encounter_id 		        = "";
		String name_prefix 		            = "";
		String name_prefix_oth_lang 	    = "";
		String first_name			 	    = "";
		String first_name_oth_lang			= "";
		String name_suffix					= "";
		String name_suffix_oth_lang			= "";
		String family_name_oth_lang			= "";
		String family_name					= "";
		String patient_name_long			= "";
		String patient_name_loc_lang_long	= "";
		String second_name					= "";
		String second_name_oth_lang			= "";
		String third_name					= "";
		String third_name_oth_lang			= "";
		HashMap hashtable					=null;
		String locale 						= "";
		String addedById		            = "";
		String addedAtWorkstation		    = "";
		String facilityId				    = "";
		String modifiedById				    = "";
		String modifiedAtWorkstation		= "";
		String modifiedFacilityId			= "";
		
		 String req_addr_line1 				= "";
		String req_addr_line2 				= "";
		String req_addr_line3 				= "";
		String req_addr_line4 				= "";
		String req_town_code   			    = "";
		String req_area_code   		        ="";
		String req_region_code  			="";
		String req_postal_code 			    = "";
		String country_code			   	    ="";
		String contact1_no  			    = "";
		String contact2_no     				= "";
		String email         			    ="";
		
		String emb_addr_line1			 = "";
		String emb_addr_line2 			 = "";
		String emb_addr_line3			 = "";
		String emb_addr_line4      		 ="";
		String emb_res_town_code		 ="";
		String emb_res_area_code		 ="";
		String emb_region_code 			 = "";
		String emb_postal_code			 ="";
		String emb_country_code			 ="";
		String  modify_srl_no 			 ="";
		String embalmcomplete 			 ="";
		String cancelembalm 			 ="";
		String embalm_status			 	="";
		//String nat_id					 ="";
		String oth_alt_id_type			  	="";
		String other_alt_Id_text			="";
		String embalm_at_home_yn		 	="";
		String embalm_at_hospital_yn     	="";
		String cancel_reason  				="";

		Properties	p ;
		
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
	
	public java.util.HashMap updateMOEmbalRegn(Properties properties,HashMap ht)  throws  SQLException
	{
     
	 
	         Connection con                  =null;
			 PreparedStatement pstmt		 =null;
	       try{
	       
		   // PreparedStatement pstmt		=null;
			p							= properties  ;
			con							= ConnectionManager.getConnection(p);
			con.setAutoCommit(false);
	        locale					    = p.getProperty("LOCALE");
			hashtable	          	    = ht;
			results						= new java.util.HashMap() ;
			String updateQuery          = "";
			int cnt                     = 0;
			extractValues();
			  
			 if(cancelembalm.equals("Y")) { 
				embalm_status="09";
			  }else if(embalmcomplete.equals("Y")) { 
			   embalm_status="04";
			  }else{				  
				  embalm_status="01";
			   }				

			updateQuery="UPDATE MO_EMBALM_SERVICE SET  ENCOUNTER_ID=?,PATIENT_ID=?,HIV_YN=?,HEP_YN=?,REQUESTOR_ID=?,EMBALM_REQ_DATE=TO_DATE(?,'DD/MM/YYYY'),REQ_NAME_PREFIX=?,REQ_NAME_PREFIX_LOC=?, REQ_NAME_SUFFIX=?,REQ_NAME_SUFFIX_LOC=?,REQ_FAMILY_NAME=?,REQ_FAMILY_NAME_LOC=?,REQ_FIRST_NAME=?,REQ_FIRST_NAME_LOC=?, REQUESTOR_SEX=?,REQUESTOR_DOB=TO_DATE(?,'DD/MM/YYYY'),EMBALM_PROC_DATE=TO_DATE(?,'DD/MM/YYYY'),EMBALM_FROM_TIME=TO_DATE(?,'hh24:mi')  ,EMBALM_TO_TIME=TO_DATE(?,'hh24:mi'),EMBALM_FLUID_QTY=?,REQUESTOR_NAT_ID_NO=?, MODIFIED_BY_ID=?,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=?,REQ_PATIENT_NAME=?,REQ_PATIENT_NAME_LOC=?,REQ_ADDR_LINE1=?,REQ_ADDR_LINE2=?,REQ_ADDR_LINE3=?,REQ_ADDR_LINE4=?,REQ_TOWN_CODE=?,REQ_AREA_CODE=?,REQ_REGION_CODE=?,REQ_POSTAL_CODE=?,COUNTRY_CODE=?,CONTACT1_NO=?,CONTACT2_NO=?,EMAIL=?,EMB_ADDR_LINE1=?,EMB_ADDR_LINE2=?,EMB_ADDR_LINE3=?,EMB_ADDR_LINE4=?,EMB_RES_TOWN_CODE=?,EMB_RES_AREA_CODE=?,EMB_REGION_CODE=?,EMB_POSTAL_CODE=?,EMB_COUNTRY_CODE=?,REQ_SECOND_NAME=?, REQ_SECOND_NAME_LOC=?,REQ_THIRD_NAME=?,REQ_THIRD_NAME_LOC=?,EMBALM_STATUS=?,REQUESTOR_ALT_ID_TYPE=?,REQUESTOR_ALT_ID=?,EMBALM_AT_HOME_YN=?,EMBALM_AT_HOSPITAL_YN=?,CANCEL_REMARKS=? WHERE FACILITY_ID=? AND SRL_NO=?";
			
			
			
			pstmt =con.prepareStatement(updateQuery);
			pstmt.setString(1,encounter_id);
			pstmt.setString(2,Patient_ID);
			pstmt.setString(3,hiv_yn);
			pstmt.setString(4,hep_yn);
			pstmt.setString(5,requestor_id);
			pstmt.setString(6,embalm_req_date);
			pstmt.setString(7,name_prefix);
			pstmt.setString(8,name_prefix_oth_lang);
			pstmt.setString(9,name_suffix);
			pstmt.setString(10,name_suffix_oth_lang);
			pstmt.setString(11,family_name);
			pstmt.setString(12,family_name_oth_lang);
			pstmt.setString(13,first_name);
			pstmt.setString(14,first_name_oth_lang);
			pstmt.setString(15,requestor_sex);
			pstmt.setString(16,requestor_dob);
			pstmt.setString(17,embalm_proc_date);
			pstmt.setString(18,embalm_from_time);
			pstmt.setString(19,embalm_to_time);
			pstmt.setString(20,embalm_fluid_qty); //fine
			pstmt.setString(21,national_id_no);
			pstmt.setString(22,modifiedById);
			pstmt.setString(23,modifiedAtWorkstation);
			pstmt.setString(24,modifiedFacilityId);
			pstmt.setString(25,patient_name_long);
			pstmt.setString(26,patient_name_loc_lang_long); 
			pstmt.setString(27,req_addr_line1);
			pstmt.setString(28,req_addr_line2);
			pstmt.setString(29,req_addr_line3);
			pstmt.setString(30,req_addr_line4);
			pstmt.setString(31,req_town_code);
			pstmt.setString(32,req_area_code);
			pstmt.setString(33,req_region_code);
			pstmt.setString(34,req_postal_code);
			pstmt.setString(35,country_code);
			pstmt.setString(36,contact1_no);
			pstmt.setString(37,contact2_no);
			pstmt.setString(38,email);
			pstmt.setString(39,emb_addr_line1);
			pstmt.setString(40,emb_addr_line2);
			pstmt.setString(41,emb_addr_line3);
			pstmt.setString(42,emb_addr_line4);
			pstmt.setString(43,emb_res_town_code);
			pstmt.setString(44,emb_res_area_code);
			pstmt.setString(45,emb_region_code);
			pstmt.setString(46,emb_postal_code);
			pstmt.setString(47,emb_country_code);
			pstmt.setString(48,second_name);
			pstmt.setString(49,second_name_oth_lang);
			pstmt.setString(50,third_name);
			pstmt.setString(51,third_name_oth_lang);
			pstmt.setString(52,embalm_status);
			pstmt.setString(53,oth_alt_id_type);
			pstmt.setString(54,other_alt_Id_text);
			pstmt.setString(55,embalm_at_home_yn);
			pstmt.setString(56,embalm_at_hospital_yn);
			pstmt.setString(57,cancel_reason);
			pstmt.setString(58,facility_id);
			pstmt.setString(59,modify_srl_no);
			
			
			cnt=pstmt.executeUpdate();
			
			oth_alt_id_type 	=(String)hashtable.get("REQUESTOR_ALT_ID_TYPE"); 
		     other_alt_Id_text 	=(String)hashtable.get("REQUESTOR_ALT_ID"); 

			 if(cnt==1){
			  con.commit();
			  java.util.Hashtable message = MessageManager.getMessage(locale,"RECORD_MODIFIED","SM");
			  sb.append((String) message.get("message"));
			  results.put( "status", new Boolean(true) ) ;
			  results.put( "error", sb.toString() ) ;
			  results.put( "srl_no", modify_srl_no) ;
			  results.put("patient_id", Patient_ID) ;
			  sb.setLength(0); 
			  
			 }else{
			  con.rollback();
			 
			   }
		    
	         
			 
	 
	   }catch(Exception ee){
	    con.rollback();
	   ee.printStackTrace(System.err);
	   return results ;
	   } 
	   
	   finally{
	               if(pstmt!=null)pstmt.close();
				   if(con != null) 
					ConnectionManager.returnConnection(con,p);

				}
	
	return results ;
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

      public java.util.HashMap insertMOEmbalRegn(Properties properties,HashMap ht)  throws  SQLException
      { 
	        Connection con              = null;    
   			PreparedStatement pstmt		= null;
				
	      try
		  {

         
		  // PreparedStatement pstmt		=null;
			p							= properties  ;
			con							= ConnectionManager.getConnection(p);
			locale 						= p.getProperty("LOCALE");
			results						= new java.util.HashMap() ;
		    hashtable	          	    = ht;
			String insertQuery          = "";
			String sequence_query       = ""; 
				String reg_query           = ""; 
			String  mo_facility_id         ="";
			String registration_no      ="";
			int cnt                     = 0;
			extractValues();
			
			
			reg_query="select facility_id,REGISTRATION_NO from (select facility_id,REGISTRATION_NO,added_date from MO_MORTUARY_REGN where patient_id='"+Patient_ID+"' order By added_date desc) where rownum=1";
			 stmt=con.createStatement();
			 rs	= stmt.executeQuery(reg_query);
		  while(rs.next())
			{
			mo_facility_id				   = rs.getString("facility_id");
			registration_no                =rs.getString("REGISTRATION_NO");
			}
			//stmt=null;
			//rs=null;
			
			if(stmt != null) //CheckStyle issue 19-05-2023
				stmt.close();
			if(rs != null)
				rs.close();
			/*sequence_query             ="select MO_GET_EMBALM_NUM('"+facility_id+"') nextembalmno from dual";
			
			stmt=con.createStatement();
			rs						   = stmt.executeQuery(sequence_query);
			while(rs.next())
			{
			srl_no					   = rs.getString("nextembalmno");
				
			}*/
			//Modified against Regression-PAS-MO Transaction – Embalm Registration [IN:051368] - Start
			
			con.setAutoCommit(false);
			
			sequence_query             ="select MO_GET_EMBALM_NUM('"+facility_id+"') nextembalmno, NEXT_NUM, MAX_NUM from MO_EMBALM_NUM_CONTROL where facility_id='"+facility_id+"'";
			
			stmt=con.createStatement();
			rs						   = stmt.executeQuery(sequence_query);
			if(rs.next()) //If Embalm number is defined, then it continues  
			{
				if(rs.getLong("NEXT_NUM")> rs.getLong("MAX_NUM")) //If Embalm number exceeds the max limit, then it returns error message
				{ 
					java.util.Hashtable message = MessageManager.getMessage(locale,"EMBALM_REG_NO_EXCEEDS_MAX_NO","MO");
					sb.append((String) message.get("message"));
					results.put( "status", new Boolean(false) ) ;
					results.put( "error", sb.toString() ) ;
					sb.setLength(0);
				}else{ // It continues to embalm registration
				
					srl_no					   = rs.getString("nextembalmno");
					
					insertQuery					="INSERT INTO MO_EMBALM_SERVICE(FACILITY_ID,SRL_NO,ENCOUNTER_ID,PATIENT_ID,HIV_YN,HEP_YN,REQUESTOR_ID,EMBALM_REQ_DATE,REQ_NAME_PREFIX,REQ_NAME_PREFIX_LOC,REQ_NAME_SUFFIX,REQ_NAME_SUFFIX_LOC,REQ_FAMILY_NAME,REQ_FAMILY_NAME_LOC,REQ_FIRST_NAME,REQ_FIRST_NAME_LOC,REQ_SECOND_NAME,REQ_SECOND_NAME_LOC,REQ_THIRD_NAME,REQ_THIRD_NAME_LOC,REQ_PATIENT_NAME,REQ_PATIENT_NAME_LOC,REQUESTOR_SEX,REQUESTOR_DOB,REQ_CONTACT_NO,REQUESTOR_NAT_ID_NO,EMBALM_PROC_DATE,EMBALM_FROM_TIME,EMBALM_TO_TIME,EMBALM_FLUID_QTY,EMBALM_STATUS,CANCEL_REMARKS,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,REQ_ADDR_LINE1,REQ_ADDR_LINE2, REQ_ADDR_LINE3,REQ_ADDR_LINE4,REQ_TOWN_CODE,REQ_AREA_CODE,REQ_REGION_CODE,REQ_POSTAL_CODE,COUNTRY_CODE,CONTACT1_NO,CONTACT2_NO,EMAIL,EMB_ADDR_LINE1,EMB_ADDR_LINE2,EMB_ADDR_LINE3,EMB_ADDR_LINE4,EMB_RES_TOWN_CODE,EMB_RES_AREA_CODE,EMB_REGION_CODE,EMB_POSTAL_CODE,EMB_COUNTRY_CODE,REQUESTOR_ALT_ID_TYPE,REQUESTOR_ALT_ID,EMBALM_AT_HOME_YN,EMBALM_AT_HOSPITAL_YN,MOR_REGN_FACILITY_ID,MOR_REGN_NUM) VALUES (?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy hh24:mi'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy hh24:mi'),?,?,to_date(?,'dd/mm/yyyy hh24:mi'),to_date(?,'hh24:mi'),to_date(?,'hh24:mi'),?,?,?,?,sysdate,?,?,?,sysdate,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
					 
					  
					pstmt = con.prepareStatement(insertQuery);   
					 pstmt.setString(1,facility_id);
					 pstmt.setString(2,srl_no);
					
					 pstmt.setString(3,encounter_id);
					 pstmt.setString(4,Patient_ID);
					 pstmt.setString(5,hiv_yn);
					 pstmt.setString(6,hep_yn);
					 pstmt.setString(7,requestor_id);
					 pstmt.setString(8,embalm_req_date);
					 pstmt.setString(9,name_prefix);
					 pstmt.setString(10,name_prefix_oth_lang);
					 pstmt.setString(11,name_suffix);
					 pstmt.setString(12,name_suffix_oth_lang);
					 pstmt.setString(13,family_name);
					 pstmt.setString(14,family_name_oth_lang);
					 pstmt.setString(15,first_name);
					 pstmt.setString(16,first_name_oth_lang);
					 pstmt.setString(17,second_name);
					 pstmt.setString(18,second_name_oth_lang);
					 pstmt.setString(19,third_name);
					 pstmt.setString(20,third_name_oth_lang);
					 pstmt.setString(21,patient_name_long);
					 pstmt.setString(22,patient_name_loc_lang_long);
					 pstmt.setString(23,requestor_sex);
					 pstmt.setString(24,requestor_dob);
					 pstmt.setString(25,"");
					 pstmt.setString(26,national_id_no);
					 pstmt.setString(27,embalm_proc_date);
					 pstmt.setString(28,embalm_from_time);
					 pstmt.setString(29,embalm_to_time);
					 pstmt.setString(30,embalm_fluid_qty);
					 pstmt.setString(31,"01");
					 pstmt.setString(32,cancel_reason);
					 pstmt.setString(33,addedById); //FINE
					 pstmt.setString(34,addedAtWorkstation);
					 pstmt.setString(35,facilityId);
					 pstmt.setString(36,modifiedById);
					 pstmt.setString(37,modifiedAtWorkstation);
					 pstmt.setString(38,modifiedFacilityId);
					 //address
					  pstmt.setString(39,req_addr_line1);
					  pstmt.setString(40,req_addr_line2);
					  pstmt.setString(41,req_addr_line3);
					  pstmt.setString(42,req_addr_line4);
					  pstmt.setString(43,req_town_code);
					  pstmt.setString(44,req_area_code);
					  pstmt.setString(45,req_region_code);
					  pstmt.setString(46,req_postal_code);
					  pstmt.setString(47,country_code);
					  pstmt.setString(48,contact1_no);
					  pstmt.setString(49,contact2_no);
					  pstmt.setString(50,email);
					  pstmt.setString(51,emb_addr_line1);
					  pstmt.setString(52,emb_addr_line2);
					  pstmt.setString(53,emb_addr_line3);
					  pstmt.setString(54,emb_addr_line4);
					  pstmt.setString(55,emb_res_town_code);
					  pstmt.setString(56,emb_res_area_code);
					  pstmt.setString(57,emb_region_code);
					  pstmt.setString(58,emb_postal_code);
					  pstmt.setString(59,emb_country_code);
					  pstmt.setString(60,oth_alt_id_type);
					  pstmt.setString(61,other_alt_Id_text);
					  
					  pstmt.setString(62,embalm_at_home_yn);
					  pstmt.setString(63,embalm_at_hospital_yn);
					  pstmt.setString(64,mo_facility_id);
					  pstmt.setString(65,registration_no);
					 
					 cnt=pstmt.executeUpdate();
					 
					
					 //con.commit();
					 if(cnt==1){
					  con.commit();
					  java.util.Hashtable message = MessageManager.getMessage(locale,"RECORD_INSERTED","SM");
					  sb.append((String) message.get("message"));
					  results.put( "status", new Boolean(true) ) ;
					  results.put( "error", sb.toString() ) ;
					   results.put( "srl_no", srl_no) ;
						results.put( "patient_id", Patient_ID) ;
					 
					  sb.setLength(0); 
					  
					 }else{
					  con.rollback();
					 
					   }
				 } //
			}else // If Embalm is not defined, then it returns the below Error message 
			{
				java.util.Hashtable message = MessageManager.getMessage(locale,"EMBALM_NOT_DEFINED","MO");
				sb.append((String) message.get("message"));
				results.put( "status", new Boolean(false) ) ;
				results.put( "error", sb.toString() ) ;
				sb.setLength(0); 
			} //Modified against Regression-PAS-MO Transaction – Embalm Registration [IN:051368] - End
			//  added for checkstyle audit
			if(stmt != null) stmt.close();
			if(rs!=null) rs.close();
		}catch(Exception e){
			     con.rollback();
				e.printStackTrace();
				
				}
				finally{
				 
				 if(pstmt!=null)pstmt.close();
				 if(con != null) 
					ConnectionManager.returnConnection(con,p);
				}
				 sb.setLength(0);
		         ht.clear();
			 
				
	         return results ;
      
	  
	}
 
    public void extractValues(){
	  
	  try
		{ 
		 
		    
		
			 java.text.SimpleDateFormat dt    = new  java.text.SimpleDateFormat("dd/MM/yyyy");
		     java.util.Date today   = new java.util.Date();
		     //String dateString 		= dt.format(today); //Commented for checkstyle
			
	         facility_id 			=(String)hashtable.get("FACILITY_ID");
	         encounter_id 			=(String)hashtable.get("ENCOUNTER_ID");
	         Patient_ID 			=(String)hashtable.get("PATIENT_ID");
	         hiv_yn 			    =(String)hashtable.get("HIV_YN");
	         hep_yn 			    =(String)hashtable.get("HEP_YN");
	         requestor_id 			=(String)hashtable.get("REQUESTOR_ID");
	         embalm_req_date 		=(String)hashtable.get("EMBALM_REQ_DATE");
	         name_prefix 		    =(String)hashtable.get("REQ_NAME_PREFIX");
	         name_prefix_oth_lang   =(String)hashtable.get("REQ_NAME_PREFIX_LOC");
	         name_suffix            =(String)hashtable.get("REQ_NAME_SUFFIX");
	         name_suffix_oth_lang   =(String)hashtable.get("REQ_NAME_SUFFIX_LOC");
	         family_name   			=(String)hashtable.get("REQ_FAMILY_NAME");
	         family_name_oth_lang   =(String)hashtable.get("REQ_FAMILY_NAME_LOC");
	         first_name			    =(String)hashtable.get("REQ_FIRST_NAME");
	         first_name_oth_lang    =(String)hashtable.get("REQ_FIRST_NAME_LOC");
	         requestor_sex   	    =(String)hashtable.get("REQUESTOR_SEX");
	         requestor_dob   	    =(String)hashtable.get("REQUESTOR_DOB");
	         embalm_proc_date   	=(String)hashtable.get("EMBALM_PROC_DATE");
			 embalm_from_time   	= (String)hashtable.get("EMBALM_FROM_TIME");
			
	         embalm_to_time		   	=(String)hashtable.get("EMBALM_TO_TIME");
			
	         
			 embalm_fluid_qty		=(String)hashtable.get("EMBALM_FLUID_QTY");
	         national_id_no		    =(String)hashtable.get("REQUESTOR_NAT_ID_NO");
			
	         addedById				=(String)hashtable.get("ADDED_BY_ID");
	         addedAtWorkstation		=(String)hashtable.get("ADDED_AT_WS_NO");
	         facilityId				=(String)hashtable.get("ADDED_FACILITY_ID");
	         modifiedById			=(String)hashtable.get("MODIFIED_BY_ID");
	         modifiedAtWorkstation	=(String)hashtable.get("MODIFIED_AT_WS_NO");
	         modifiedFacilityId  	=(String)hashtable.get("MODIFIED_FACILITY_ID"); 
	         patient_name_long  	=(String)hashtable.get("REQ_PATIENT_NAME"); 
			
	         patient_name_loc_lang_long =(String)hashtable.get("REQ_PATIENT_NAME_LOC"); 
			
			 
			 
	        
			req_addr_line1   	=(String)hashtable.get("REQ_ADDR_LINE1"); 
			req_addr_line2   	=(String)hashtable.get("REQ_ADDR_LINE2"); 
			req_addr_line3    	=(String)hashtable.get("REQ_ADDR_LINE3"); 
			req_addr_line4     	=(String)hashtable.get("REQ_ADDR_LINE4"); 
			req_town_code     	=(String)hashtable.get("REQ_TOWN_CODE"); 
			req_area_code      	=(String)hashtable.get("REQ_AREA_CODE"); 
			req_region_code     =(String)hashtable.get("REQ_REGION_CODE"); 
			req_postal_code     =(String)hashtable.get("REQ_POSTAL_CODE"); 
			country_code        =(String)hashtable.get("COUNTRY_CODE"); 
			contact1_no         =(String)hashtable.get("CONTACT1_NO"); 
			contact2_no         =(String)hashtable.get("CONTACT2_NO"); 
			email               =(String)hashtable.get("EMAIL"); 
			emb_addr_line1      =(String)hashtable.get("EMB_ADDR_LINE1"); 
			emb_addr_line2      =(String)hashtable.get("EMB_ADDR_LINE2"); 
			emb_addr_line3      =(String)hashtable.get("EMB_ADDR_LINE3"); 
			emb_addr_line4      =(String)hashtable.get("EMB_ADDR_LINE4"); 
			emb_res_town_code   =(String)hashtable.get("EMB_RES_TOWN_CODE"); 
			emb_res_area_code   =(String)hashtable.get("EMB_RES_AREA_CODE"); 
			emb_region_code     =(String)hashtable.get("EMB_REGION_CODE"); 
			emb_postal_code     =(String)hashtable.get("EMB_POSTAL_CODE"); 
		    emb_country_code	=(String)hashtable.get("EMB_COUNTRY_CODE"); 
		    second_name     	=(String)hashtable.get("REQ_SECOND_NAME"); 
		    second_name_oth_lang=(String)hashtable.get("REQ_SECOND_NAME_LOC"); 
		    third_name          =(String)hashtable.get("REQ_THIRD_NAME"); 
		    third_name_oth_lang =(String)hashtable.get("REQ_THIRD_NAME_LOC"); 
		    modify_srl_no  =        (String)hashtable.get("SRL_NO"); 
		    cancelembalm =(String)hashtable.get("cancelembalm"); 
		     embalmcomplete 	=(String)hashtable.get("embalmcomplete"); 
		     oth_alt_id_type 	=(String)hashtable.get("REQUESTOR_ALT_ID_TYPE"); 
		     other_alt_Id_text 	=(String)hashtable.get("REQUESTOR_ALT_ID"); 
			 
		     embalm_at_home_yn 	=(String)hashtable.get("EMBALM_AT_HOME_YN"); 
		     embalm_at_hospital_yn 	=(String)hashtable.get("EMBALM_AT_HOSPITAL_YN"); 
			  cancel_reason = (String)hashtable.get("CANCEL_REMARKS"); 

		
		}catch(Exception e){
		e.printStackTrace(System.err);
		
		}

	  } 

}

