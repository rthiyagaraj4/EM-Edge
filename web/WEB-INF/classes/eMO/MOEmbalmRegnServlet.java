/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMO;

import java.sql.*;
import java.io.*;
import java.util.*;
import java.text.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.naming.*; 
import javax.rmi.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import webbeans.eCommon.*;
import eMO.EmbalmRegistration.*;

public class MOEmbalmRegnServlet extends HttpServlet{

		 PrintWriter out;
		String facilityId; 
		HttpSession session;
		Properties p;
		String client_ip_address;
		boolean inserted					= false;
		Connection con						=null;
		String error 						= "";
		String error_value 					= "0"; //need to modified
		String registration_no 				= "";
		String locale					    = "";
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
		String mode 					 ="";
		String srl_no 					 ="";
		String embalmcomplete 			 ="";
		String cancelembalm 			 ="";
		
		String oth_alt_id_type           ="";
	    String other_alt_Id_text           =""; 

		String embalm_at_home_yn 		="";
		String embalm_at_hospital_yn    ="";
		String cancel_reason            ="";
		String generated_srl_no ="";
		
		

public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
 	}
	
public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
{

         
		   try	
			{
			 
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			con = ConnectionManager.getConnection(req);	
			session           				= req.getSession(false) ;
			out               				= res.getWriter() ;
		 	this.facilityId					= (String) session.getValue( "facility_id" ) ;
			this.p							= (java.util.Properties)session.getValue( "jdbc" ) ;
			this.client_ip_address  		= p.getProperty("client_ip_address");
			locale							= p.getProperty("LOCALE");
			/*String addedById				= p.getProperty( "login_user" ) ;
		    String modifiedById				= addedById ;    
			String addedFacilityId		    = facilityId;
			String modifiedFacilityId		= addedFacilityId ;
			String addedAtWorkstation		= client_ip_address;
			String modifiedAtWorkstation	= addedAtWorkstation ;*/
			
			 boolean inserted				= false;
	      //  hiv_yn							= checkForNull(req.getParameter("hiv_yn"),"N");
	        hiv_yn							= req.getParameter("hiv_yn")==null?"N":req.getParameter("hiv_yn");
	        hep_yn							= req.getParameter("hep_yn")==null?"N":req.getParameter("hep_yn");
		//	hep_yn							= checkForNull(req.getParameter("hep_yn"),"N");
			requestor_id					= checkForNull(req.getParameter("requestor_id"));
			requestor_sex					= checkForNull(req.getParameter("sex"));
			Patient_ID					    = checkForNull(req.getParameter("Patient_ID"));
			requestor_dob				    = checkForNull(req.getParameter("requestor_dob"));
			national_id_no				    = checkForNull(req.getParameter("national_id_no"));
			embalm_proc_date			    = checkForNull(req.getParameter("embalm_proc_date"));
			embalm_req_date			        = checkForNull(req.getParameter("embalm_req_date"));
			embalm_from_time			    = checkForNull(req.getParameter("embalm_from_time"));
			embalm_to_time			        = checkForNull(req.getParameter("embalm_to_time"));
			encounter_id			        = checkForNull(req.getParameter("encounter_id"));
			embalm_fluid_qty			    = checkForNull(req.getParameter("embalm_fluid_qty"));
			first_name						= checkForNull(req.getParameter("first_name"));
			first_name_oth_lang				= checkForNull(req.getParameter("first_name_oth_lang"));
			name_prefix			            = checkForNull(req.getParameter("name_prefix"));
			name_prefix_oth_lang			= checkForNull(req.getParameter("name_prefix_oth_lang"));
			family_name						= checkForNull(req.getParameter("family_name"));
			family_name_oth_lang			= checkForNull(req.getParameter("family_name_oth_lang"));
			name_suffix						= checkForNull(req.getParameter("name_suffix"));
			name_suffix_oth_lang			= checkForNull(req.getParameter("name_suffix_oth_lang"));
			patient_name_long				= checkForNull(req.getParameter("patient_name"));
			patient_name_loc_lang_long		= checkForNull(req.getParameter("patient_name_loca_long"));
			second_name						= checkForNull(req.getParameter("second_name"));
			second_name_oth_lang			= checkForNull(req.getParameter("second_name_oth_lang"));
			third_name						= checkForNull(req.getParameter("third_name"));
			third_name_oth_lang				= checkForNull(req.getParameter("third_name_oth_lang"));
			srl_no          				= checkForNull(req.getParameter("srl_no"));
			//nat_id          				= checkForNull(req.getParameter("national_id_no"));
			oth_alt_id_type          	    = checkForNull(req.getParameter("other_alt_id"));
			other_alt_Id_text          	    = checkForNull(req.getParameter("other_alt_Id_text"));
			
			
			
			
			/* Applicant Address */
			req_addr_line1		            = checkForNull(req.getParameter("addr_line1"));
			req_addr_line2 		            = checkForNull(req.getParameter("addr_line2"));
			req_addr_line3  		        = checkForNull(req.getParameter("addr_line3"));
			req_addr_line4                  = checkForNull(req.getParameter("addr_line4"));
			req_town_code                   = checkForNull(req.getParameter("res_town_code"));
			req_area_code                   = checkForNull(req.getParameter("res_area_code"));
			req_region_code                 = checkForNull(req.getParameter("res_region_code"));
			req_postal_code                 = checkForNull(req.getParameter("postal_code"));
			country_code                    = checkForNull(req.getParameter("country_code"));
			contact1_no                     = checkForNull(req.getParameter("contact1_no"));
			contact2_no                     = checkForNull(req.getParameter("contact2_no"));
			email                           = checkForNull(req.getParameter("email"));
			
			emb_addr_line1  			= checkForNull(req.getParameter("mail_addr_line1"));
			emb_addr_line2  			= checkForNull(req.getParameter("mail_addr_line2"));
			emb_addr_line3  			= checkForNull(req.getParameter("mail_addr_line3"));
			emb_addr_line4  			= checkForNull(req.getParameter("mail_addr_line4"));
			emb_res_town_code  			= checkForNull(req.getParameter("mail_res_town_code"));
			emb_res_area_code  			= checkForNull(req.getParameter("mail_res_area_code"));
			emb_region_code  			= checkForNull(req.getParameter("mail_region_code"));
			emb_postal_code  			= checkForNull(req.getParameter("mail_postal_code"));
			emb_country_code  			= checkForNull(req.getParameter("mail_country_code"));
			mode  			            = checkForNull(req.getParameter("mode"));
			embalmcomplete			    = req.getParameter("embalmcomplete") != null ? req.getParameter("embalmcomplete") : "N";
			cancelembalm			    = req.getParameter("cancelembalm") != null ? req.getParameter("cancelembalm") : "N";
			
			embalm_at_home_yn			    = req.getParameter("home_embal") != null ? req.getParameter("home_embal") : "N";
			embalm_at_hospital_yn		 = req.getParameter("hospital_embal") != null ? req.getParameter("hospital_embal") : "N";
			cancel_reason  			            = checkForNull(req.getParameter("cancelReson"));
			
			
			if(patient_name_long.length()>100){
					patient_name_long=patient_name_long.substring(0,100);
				}
			
			if(patient_name_loc_lang_long.length()>100){
					patient_name_loc_lang_long=patient_name_loc_lang_long.substring(0,100);
				}
			 
			 if(mode.equals("modifiy")){
			        updateMOEmbalRegn(res);
			}else{
			
			insertEmbalmRegn(res);
			
			}
			 
			}catch(Exception e) {
			e.printStackTrace();
            }finally{
		   ConnectionManager.returnConnection(con,req);}

    
	}


 private void  insertEmbalmRegn( HttpServletResponse res)
 {
 
  try{
           
	        String addedById				= p.getProperty( "login_user" ) ;
		    String modifiedById				= addedById ;    
			String addedFacilityId		    = facilityId;
			String modifiedFacilityId		= addedFacilityId ;
			String addedAtWorkstation		= client_ip_address;
			String modifiedAtWorkstation	= addedAtWorkstation ;	       
			 HashMap tabdata				=new HashMap();
		 	tabdata.put("FACILITY_ID",facilityId);
			tabdata.put("ENCOUNTER_ID",encounter_id);
			tabdata.put("PATIENT_ID",Patient_ID);
			tabdata.put("HIV_YN",hiv_yn);
			tabdata.put("HEP_YN",hep_yn);
			tabdata.put("REQUESTOR_ID",requestor_id);
			tabdata.put("EMBALM_REQ_DATE",embalm_req_date);
			tabdata.put("REQ_NAME_PREFIX",name_prefix);
			tabdata.put("REQ_NAME_PREFIX_LOC",name_prefix_oth_lang);
			tabdata.put("REQ_NAME_SUFFIX",name_suffix);
			tabdata.put("REQ_NAME_SUFFIX_LOC",name_suffix_oth_lang);
			tabdata.put("REQ_FAMILY_NAME",family_name);
			tabdata.put("REQ_FAMILY_NAME_LOC",family_name_oth_lang);
			tabdata.put("REQ_FIRST_NAME",first_name);
			tabdata.put("REQ_FIRST_NAME_LOC",first_name_oth_lang);
			tabdata.put("REQUESTOR_SEX",requestor_sex);
			tabdata.put("REQUESTOR_DOB",requestor_dob);
			tabdata.put("EMBALM_PROC_DATE",embalm_proc_date);
			tabdata.put("EMBALM_FROM_TIME",embalm_from_time);
			tabdata.put("EMBALM_TO_TIME",embalm_to_time);
			tabdata.put("EMBALM_FLUID_QTY",embalm_fluid_qty);
			tabdata.put("REQUESTOR_NAT_ID_NO",national_id_no);
			
	     	tabdata.put("ADDED_BY_ID",addedById);
			tabdata.put("ADDED_AT_WS_NO",addedAtWorkstation);
			tabdata.put("ADDED_FACILITY_ID", facilityId);
			tabdata.put("MODIFIED_BY_ID",modifiedById);
			tabdata.put("MODIFIED_AT_WS_NO",modifiedAtWorkstation );
			tabdata.put("MODIFIED_FACILITY_ID",modifiedFacilityId);
			tabdata.put("REQ_PATIENT_NAME",patient_name_long);
			tabdata.put("REQ_PATIENT_NAME_LOC",patient_name_loc_lang_long);
		
			//ADRESS
			 tabdata.put("REQ_ADDR_LINE1",req_addr_line1);
			 tabdata.put("REQ_ADDR_LINE2",req_addr_line2);
			 tabdata.put("REQ_ADDR_LINE3",req_addr_line3);
			 tabdata.put("REQ_ADDR_LINE4",req_addr_line4);
			 tabdata.put("REQ_TOWN_CODE",req_town_code);
			 tabdata.put("REQ_AREA_CODE",req_area_code);
			 tabdata.put("REQ_REGION_CODE",req_region_code);
			 tabdata.put("REQ_POSTAL_CODE",req_postal_code);
			 tabdata.put("COUNTRY_CODE",country_code);
			 tabdata.put("CONTACT1_NO",contact1_no);
			 tabdata.put("CONTACT2_NO",contact2_no);
			 tabdata.put("EMAIL",email);
			 tabdata.put("EMB_ADDR_LINE1",emb_addr_line1);
			 tabdata.put("EMB_ADDR_LINE2",emb_addr_line2);
			 tabdata.put("EMB_ADDR_LINE3",emb_addr_line3);
			 tabdata.put("EMB_ADDR_LINE4",emb_addr_line4);
			 tabdata.put("EMB_RES_TOWN_CODE",emb_res_town_code);
			 tabdata.put("EMB_RES_AREA_CODE",emb_res_area_code);
			 tabdata.put("EMB_REGION_CODE",emb_region_code);
			 tabdata.put("EMB_POSTAL_CODE",emb_postal_code);
			 tabdata.put("EMB_COUNTRY_CODE",emb_country_code);
			 tabdata.put("REQ_SECOND_NAME",second_name);
			 tabdata.put("REQ_SECOND_NAME_LOC",second_name_oth_lang);
			 tabdata.put("REQ_THIRD_NAME",third_name);
			 tabdata.put("REQ_THIRD_NAME_LOC",third_name_oth_lang);
			 tabdata.put("REQUESTOR_ALT_ID_TYPE",oth_alt_id_type);
			 tabdata.put("REQUESTOR_ALT_ID",other_alt_Id_text);
			 
			 tabdata.put("EMBALM_AT_HOME_YN",embalm_at_home_yn);
			 tabdata.put("EMBALM_AT_HOSPITAL_YN",embalm_at_hospital_yn);
			 tabdata.put("CANCEL_REMARKS",cancel_reason);
              
		 boolean local_ejbs 				= false;	
        if((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) && (getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
	   Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/EmbalmRegistration",MOEmbalmRegnHome.class,local_ejbs);		
	    Object busObj 							= (home.getClass().getMethod("create",null)).invoke(home,null);
	  
	     
		Object argArray[] 						= new Object[2];
		argArray[0] 							= p;
		
		argArray[1] 							= tabdata;
		Class [] paramArray 					= new Class[2];
		paramArray[0] 							= p.getClass();
		paramArray[1] 							= tabdata.getClass();
		
		
		
		java.util.HashMap results				=new HashMap();
		results									=(HashMap)busObj.getClass().getMethod("insertMOEmbalRegn", paramArray).invoke(busObj, argArray); 
		
		inserted								 = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
		error 									 = (String) results.get("error") ;
		generated_srl_no						 = (String) results.get("srl_no") ;
		Patient_ID						 = (String) results.get("patient_id") ;
           
	     //Modified against IN:051368 - generated_srl_no is not appended in case of error.
		 //error=error+" SRL_NO IS "+generated_srl_no;
		
		error_value  = "0" ;
		if ( inserted ){ 
			error=error+" SRL_NO IS "+generated_srl_no;
	    	error_value = "1" ;
		    doOnlineReports(facilityId,generated_srl_no,Patient_ID);
	      
		  out.println("<script> parent.frames[1].frames[1].onSuccess('"+error+"','"+error_value+"');</script>");
		
		}
		else {
		  error_value = "0" ;
		 
	     out.println("<script> parent.frames[1].frames[1].onSuccess('"+error+"','"+error_value+"');</script>");
		}
	       tabdata.clear();
		   results.clear(); 
	 
	 
	 }catch(Exception e){
	   e.printStackTrace();
		out.println("<h3> Exception raised by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
	 }
 }
 
 private void doOnlineReports(String facility_id,String srl_no,String patient_id) throws ServletException, IOException, SQLException
 {
 
 
 StringBuffer htmlFor =new StringBuffer();
		
		String sqlString="";
		htmlFor.setLength(0);
		
		
		 sqlString =" select report_id, report_desc, 1 no_of_copies, module_id from sm_report where module_id = 'MO' AND REPORT_ID='MOEMBSER' and INTERNAL_REQUEST_YN ='Y'";		
		
		
		String reportParamNames = "p_facility_id,P_SRL_NO,P_PATIENT_ID";
		String reportParamValues = ""+facility_id+","+srl_no+","+patient_id+"";
	    
	  
	    htmlFor.append(" <html><head> <link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link>");
		htmlFor.append("<script src='../eCommon/js/showModalDialog.js' language='JavaScript'></script>");
        htmlFor.append("</head><body class='message'>");
        htmlFor.append("<script language = 'JavaScript'> async function moEmbalmReport(){" );
        htmlFor.append("  var dialogHeight    = '30' ;");
        htmlFor.append( " var dialogWidth = '70' ;");
        htmlFor.append( "var dialogTop = 65;" );
        htmlFor.append( "  var arguments =   ''; ");
    	// modified the below line by Abirami - Bru-HIMS-CRF-313 / Passing function id in the below Query String.
        htmlFor.append("  var getUrl        =   '../../eCommon/jsp/InternalReportsPrint.jsp?P_function_id=MO_PRINT_BURIAL_PERMIT&step=1&sqlString="+java.net.URLEncoder.encode(sqlString,"UTF-8")+"&reportParamNames="+reportParamNames+"&reportParamValues="+reportParamValues+"&Patient_ID="+Patient_ID+"';");

        htmlFor.append(" var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; status=no;' ;");
        htmlFor.append("  retVal            =   await window.showModalDialog(getUrl,arguments,features); }");
        htmlFor.append(" moEmbalmReport();</script>"  );
        out.println(htmlFor.toString());
		htmlFor.setLength(0);
 
 
 }

 private void updateMOEmbalRegn(HttpServletResponse res)
 {
 
   try{
   
             
	        String addedById				= p.getProperty( "login_user" ) ;
		    String modifiedById				= addedById ;    
			String addedFacilityId		    = facilityId;
			String modifiedFacilityId		= addedFacilityId ;
			String addedAtWorkstation		= client_ip_address;
			String modifiedAtWorkstation	= addedAtWorkstation ;
	        boolean local_ejbs 				= false;
			 HashMap tabdata				=new HashMap();
		 	tabdata.put("FACILITY_ID",facilityId);
			tabdata.put("ENCOUNTER_ID",encounter_id);
			tabdata.put("PATIENT_ID",Patient_ID);
			tabdata.put("HIV_YN",hiv_yn);
			tabdata.put("HEP_YN",hep_yn);
			tabdata.put("REQUESTOR_ID",requestor_id);
			tabdata.put("EMBALM_REQ_DATE",embalm_req_date);
			tabdata.put("REQ_NAME_PREFIX",name_prefix);
			tabdata.put("REQ_NAME_PREFIX_LOC",name_prefix_oth_lang);
			tabdata.put("REQ_NAME_SUFFIX",name_suffix);
			tabdata.put("REQ_NAME_SUFFIX_LOC",name_suffix_oth_lang);
			tabdata.put("REQ_FAMILY_NAME",family_name);
			tabdata.put("REQ_FAMILY_NAME_LOC",family_name_oth_lang);
			tabdata.put("REQ_FIRST_NAME",first_name);
			tabdata.put("REQ_FIRST_NAME_LOC",first_name_oth_lang);
			tabdata.put("REQUESTOR_SEX",requestor_sex);
			tabdata.put("REQUESTOR_DOB",requestor_dob);
			tabdata.put("EMBALM_PROC_DATE",embalm_proc_date);
			tabdata.put("EMBALM_FROM_TIME",embalm_from_time);
			tabdata.put("EMBALM_TO_TIME",embalm_to_time);
			tabdata.put("EMBALM_FLUID_QTY",embalm_fluid_qty);
			tabdata.put("REQUESTOR_NAT_ID_NO",national_id_no);
			
	     	tabdata.put("ADDED_BY_ID",addedById);
			tabdata.put("ADDED_AT_WS_NO",addedAtWorkstation);
			tabdata.put("ADDED_FACILITY_ID", facilityId);
			tabdata.put("MODIFIED_BY_ID",modifiedById);
			tabdata.put("MODIFIED_AT_WS_NO",modifiedAtWorkstation );
			tabdata.put("MODIFIED_FACILITY_ID",modifiedFacilityId);
			tabdata.put("REQ_PATIENT_NAME",patient_name_long);
			tabdata.put("REQ_PATIENT_NAME_LOC",patient_name_loc_lang_long);
			
		
			//ADRESS
			 tabdata.put("REQ_ADDR_LINE1",req_addr_line1);
			 tabdata.put("REQ_ADDR_LINE2",req_addr_line2);
			 tabdata.put("REQ_ADDR_LINE3",req_addr_line3);
			 tabdata.put("REQ_ADDR_LINE4",req_addr_line4);
			 tabdata.put("REQ_TOWN_CODE",req_town_code);
			 tabdata.put("REQ_AREA_CODE",req_area_code);
			 tabdata.put("REQ_REGION_CODE",req_region_code);
			 tabdata.put("REQ_POSTAL_CODE",req_postal_code);
			 tabdata.put("COUNTRY_CODE",country_code);
			 tabdata.put("CONTACT1_NO",contact1_no);
			 tabdata.put("CONTACT2_NO",contact2_no);
			 tabdata.put("EMAIL",email);
			 tabdata.put("EMB_ADDR_LINE1",emb_addr_line1);
			 tabdata.put("EMB_ADDR_LINE2",emb_addr_line2);
			 tabdata.put("EMB_ADDR_LINE3",emb_addr_line3);
			 tabdata.put("EMB_ADDR_LINE4",emb_addr_line4);
			 tabdata.put("EMB_RES_TOWN_CODE",emb_res_town_code);
			 tabdata.put("EMB_RES_AREA_CODE",emb_res_area_code);
			 tabdata.put("EMB_REGION_CODE",emb_region_code);
			 tabdata.put("EMB_POSTAL_CODE",emb_postal_code);
			 tabdata.put("EMB_COUNTRY_CODE",emb_country_code);
			 tabdata.put("REQ_SECOND_NAME",second_name);
			 tabdata.put("REQ_SECOND_NAME_LOC",second_name_oth_lang);
			 tabdata.put("REQ_THIRD_NAME",third_name);
			 tabdata.put("REQ_THIRD_NAME_LOC",third_name_oth_lang);
			 tabdata.put("SRL_NO",srl_no);
			 
			 tabdata.put("embalmcomplete",embalmcomplete);
			 tabdata.put("cancelembalm",cancelembalm);
			 tabdata.put("REQUESTOR_ALT_ID_TYPE",oth_alt_id_type);
			 tabdata.put("REQUESTOR_ALT_ID",other_alt_Id_text);
			 tabdata.put("EMBALM_AT_HOME_YN",embalm_at_home_yn);
			 tabdata.put("EMBALM_AT_HOSPITAL_YN",embalm_at_hospital_yn);
			 tabdata.put("CANCEL_REMARKS",cancel_reason);
		
			
			
			
        if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
	    Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/EmbalmRegistration",MOEmbalmRegnHome.class,local_ejbs);
		
	    Object busObj 							= (home.getClass().getMethod("create",null)).invoke(home,null);
	  
	     
		Object argArray[] 						= new Object[2];
		argArray[0] 							= p;
		
		argArray[1] 							= tabdata;
		Class [] paramArray 					= new Class[2];
		paramArray[0] 							= p.getClass();
		paramArray[1] 							= tabdata.getClass();
		
	
		
		java.util.HashMap results				=new HashMap();
		results									=(HashMap)busObj.getClass().getMethod("updateMOEmbalRegn", paramArray).invoke(busObj, argArray); 
		
		inserted								 = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
		error 									 = (String) results.get("error") ;
		 generated_srl_no						 = (String) results.get("srl_no") ;
		Patient_ID						    = (String) results.get("patient_id") ;
          
		 error=error+" Modified SRL_NO IS "+generated_srl_no;
		
		error_value  = "0" ;
		if ( inserted ){ 
	    	error_value = "1" ;
		  
	      	error_value = "1" ;
		  doOnlineReports(facilityId,generated_srl_no,Patient_ID);
		 out.println("<script> parent.frames[1].frames[1].onSuccess('"+error+"','"+error_value+"');</script>");
		}
		else {
		  error_value = "0" ;
		   out.println("<script> parent.frames[1].frames[1].onSuccess('"+error+"','"+error_value+"');</script>");
		}
	       tabdata.clear();
		   results.clear(); 
	 
	 
	 

   }catch(Exception e){
         e.printStackTrace();
		out.println("<h3> Exception raised by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
   
   }
 
 }
 


public static String checkForNull(String inputString)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
}






















































}
