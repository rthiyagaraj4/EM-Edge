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
import eMO.MortuaryRegistration.*;
import webbeans.eCommon.*;



public class MOMortuaryRegnServlet extends HttpServlet {
	
PrintWriter out;
String facilityId; 
HttpSession session;

Properties p;
String client_ip_address;

boolean inserted		= false;
String mode = "";
/*Added by Thamizh selvi on 25th July 2017 for ML-MMOH-CRF-0689 Start*/
String calledFrom			= "";
String externalBidYn		= "";
String policeOfficerName	= "";
String policeContactNo		= "";
/*End*/
String refe_type="";
String deceased_date="";
String hcare_type="";
String registration_no = "";
String encounter_id = "";
String mlc_yn = "";
String pm_yn = "";
String body_received_date = "";
String patient_id = "";
String patient_class="";
String service_code = "";
String death_manner_code = "";
    /*Below line(s) "death_after_potmrtm" variable added by Venkatesh.S on 12-Nov-2013 against Bru-HIMS-CRF-365 [IN:039572]*/
String death_after_potmrtm  ="";  
String body_condition_code = "";
String identification_marks = "";
String police_details="";
String place_of_death = "";
String area_type = "";
String bed_no ="";
String assign_date_time = "";
String RFID_Tag = "";
String postmortem_status="";
String consent_form_code = "";
String consent_chk = "";
String consent_received_by = "";
String consent_received_date = "";
String police_chk = "";
String police_received_by = "";
String police_received_date = "";
String death_certificate_reqd_yn = "N";
String brought_by_police_yn = "N";
String pol_rep_no="";
String pol_stn_id="";
String pol_id="";
String body_found_at="";
String relflagyn="";
String deceasedat="";
Connection con=null;
String error_value = "0" ;
String error = "";
//String body_parts="";
String high_risk_body_yn="";
String postmortem_type ="";
String consent_given_by="";
String relationship_with_deceased="";
String referral_source="";
String referral_by="";
String relgn_code="";
String unclaimedbodyyn="";
String donor_card_available_yn="";        
String donor_card_no ="";                 
String donor_card_details="";             
String consent_form_code2 ="";            
String consent_form_received_by2="";      
String consent_form_received_date2="";
String consent_form_given_by3  ="";       
String relationship_with_deceased3="";
String consent_form_code3         ="";    
String consent_form_received_by3     =""; 
String consent_form_received_date3 ="";
String regn_no ="";
String organdonation=""; 
String body_claiming_date_time="";
String postmortem_startend_status="";
String vechile_no="";
String burial_permit_app_by="";
String burial_app_date="";
String print_burialpermit="";
String body_burial_permit_no="";
String death_status_remarks="";
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
String MOB_TEL_NO="";
String NAT_ID_NO ="";
String ORGANIZATION_NAME="";  
String PATIENT_EMPLOYEE_ID="";

//Added by Ashwini on 24-Jul-2017 for ML-MMOH-CRF-0743
String PASSPORT_NO="";
String OTHER_IDENTIFICATION="";

String res_town_code="";
String res_area_code="";
String region_code ="";
String locale = "";
String generate_burial_permit = "";
String external="";
String dec_fac_id="";
String dec_enc_id="";
String RELEASE_TO_FACILITY="";  //Added Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg
String reason_desc=""; //Added this CRF Bru-HIMS-CRF-366 [IN-039612]
String external_rec_exists	="";//Added For Bru-HIMS-CRF-0368 By Dharma on 3rd Dec 2013 


	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}
	
	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException{

			try	
			{
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			con = ConnectionManager.getConnection(req);	
			session           	= req.getSession(false) ;
			out               	= res.getWriter() ;
			this.facilityId			= (String) session.getValue( "facility_id" ) ;
			this.p					= (java.util.Properties)session.getValue( "jdbc" ) ;
			this.client_ip_address  = p.getProperty("client_ip_address");
			locale					= p.getProperty("LOCALE");
			registration_no		= checkForNull(req.getParameter("regno"));
			encounter_id		= checkForNull(req.getParameter("encounter_id"));
			refe_type             = checkForNull(req.getParameter("refe_type"));
			mlc_yn				= req.getParameter("mlc_yn")==null?"N":req.getParameter("mlc_yn");
			pm_yn				= req.getParameter("postmortem_reqd_yn")==null?"N":req.getParameter("postmortem_reqd_yn");
		    patient_class       = req.getParameter("patient_class")==null?"N":req.getParameter("patient_class"); 
			postmortem_startend_status =checkForNull(req.getParameter("startendstat"));
			death_after_potmrtm        =checkForNull(req.getParameter("manner_of_death_after_potmrtm"));
			
		
			
			if(!(postmortem_startend_status.equals("E")||postmortem_startend_status.equals("S")||postmortem_startend_status.equals("R")))
			{
			if(pm_yn.equals("Y"))
			{
			postmortem_status="A";
			}else
			{
			postmortem_status="N";
			}
			}else
			{
			postmortem_status=postmortem_startend_status;
			}
			
		
		    place_of_death	           = checkForNull(req.getParameter("place_of_death"));
			body_received_date         = checkForNull(req.getParameter("body_received_date_time"));	
			external			= checkForNull(req.getParameter("external"),"N");
			dec_fac_id			= checkForNull(req.getParameter("dec_fac_id"),facilityId);
			dec_enc_id			= checkForNull(req.getParameter("dec_enc_id"),"");
			

			if(!body_received_date.equals(""))
				 body_received_date=com.ehis.util.DateUtils.convertDate(body_received_date,"DMYHM",locale, "en");	
			

			area_type			       = checkForNull(req.getParameter("area_type"));
			bed_no				       = checkForNull(req.getParameter("bed_no"));
			assign_date_time	       = checkForNull(req.getParameter("assign_date_time"));
			RFID_Tag	       = checkForNull(req.getParameter("RFID_Tag"));
		
			if(!assign_date_time.equals(""))
				 assign_date_time=com.ehis.util.DateUtils.convertDate(assign_date_time,"DMYHM",locale, "en");			
			

			relationship_with_deceased = checkForNull(req.getParameter("deceasedrelationship"));
			consent_given_by		   = checkForNull(req.getParameter("conscentgivenby"));
			high_risk_body_yn	       = checkForNull(req.getParameter("highriskbodyyn"),"N");
			relgn_code		           = checkForNull(req.getParameter("relgn_code"));
			relflagyn		           = checkForNull(req.getParameter("relflagyn"));
			deceased_date              = checkForNull(req.getParameter("deceased_date"));			

			if(!deceased_date.equals(""))
				 deceased_date=com.ehis.util.DateUtils.convertDate(deceased_date,"DMYHM",locale, "en");
		

			unclaimedbodyyn	           = checkForNull(req.getParameter("unclaimedbodyyn"),"N");
            postmortem_type			   = checkForNull(req.getParameter("postmortem_type"));
			referral_source            = checkForNull(req.getParameter("referral_source"));
			referral_by                = checkForNull(req.getParameter("referral_by"));   
            donor_card_available_yn    = checkForNull(req.getParameter("donor_card_available_yn"),"N");           
            donor_card_no              = checkForNull(req.getParameter("donar_card_no"));                    
            donor_card_details         = checkForNull(req.getParameter("donardetails"));                
            consent_form_code2         = checkForNull(req.getParameter("donarconscentform"));               
            consent_form_received_by2  = checkForNull(req.getParameter("donarconsent_received_by"));         
            consent_form_received_date2= checkForNull(req.getParameter("donarconsent_received_date")); 
			
			
			if(!consent_form_received_date2.equals(""))
				 consent_form_received_date2=com.ehis.util.DateUtils.convertDate(consent_form_received_date2,"DMYHM",locale, "en");				
			
            consent_form_given_by3     = checkForNull(req.getParameter("conscentgivenby1"));          
            relationship_with_deceased3= checkForNull(req.getParameter("deceasedrelationship1"));   
            consent_form_code3         = checkForNull(req.getParameter("consent_form_code1"));      
            consent_form_received_by3  = checkForNull(req.getParameter("consent_received_by1"));    
			consent_form_received_date3= checkForNull(req.getParameter("consent_received_date1")); 

			
			if(!consent_form_received_date3.equals(""))
				 consent_form_received_date3=com.ehis.util.DateUtils.convertDate(consent_form_received_date3,"DMYHM",locale, "en");	
			

            organdonation              = checkForNull(req.getParameter("donatedorgan"));   
			CLAIMANT_TYPE              =checkForNull(req.getParameter("CLAIMANT_TYPE"));   
			CLAIMANT_TYPE_CODE         =checkForNull(req.getParameter("CLAIMANT_TYPE_CODE"));   
			RELATIONSHIP               =checkForNull(req.getParameter("RELATIONSHIP"));    
			NAME                       =checkForNull(req.getParameter("NAME"));   
			body_found_at              =checkForNull(req.getParameter("bodyfounddat"));   
			deceasedat                 =checkForNull(req.getParameter("deceasedat"));   
			JOB_TITLE                  =checkForNull(req.getParameter("JOB_TITLE"));     
			ADD_LINE1                  =checkForNull(req.getParameter("addr_line_1"));    
			ADD_LINE2                  =checkForNull(req.getParameter("addr_line_2"));   
			ADD_LINE3                  =checkForNull(req.getParameter("addr_line_3"));   
			ADD_LINE4                  =checkForNull(req.getParameter("addr_line_4"));   
			res_town_code              = checkForNull(req.getParameter("town1"));   
            res_area_code              = checkForNull(req.getParameter("area1"));    
            region_code                = checkForNull(req.getParameter("region1"));   
			
			ZIP_CODE                   =checkForNull(req.getParameter("ZIP_CODE"));   
			COUNTRY_CODE               =checkForNull(req.getParameter("COUNTRY_CODE"));    
			TELEPHONE_OFF              =checkForNull(req.getParameter("TELEPHONE_OFF"));   
			TELEPHONE_RES              =checkForNull(req.getParameter("TELEPHONE_RES"));   
			EMAIL_ID                   =checkForNull(req.getParameter("EMAIL_ID"));   
			MOB_TEL_NO                 =checkForNull(req.getParameter("MOB_TEL_NO"));   
			NAT_ID_NO                  =checkForNull(req.getParameter("NAT_ID_NO"));   
			ORGANIZATION_NAME          =checkForNull(req.getParameter("ORGANIZATION_NAME"));     
			PATIENT_EMPLOYEE_ID        =checkForNull(req.getParameter("PATIENT_EMPLOYEE_ID"));  
			
			//Added by Ashwini on 24-Jul-2017 for ML-MMOH-CRF-0743
			PASSPORT_NO				=checkForNull(req.getParameter("PASSPORT_NO")); 
			OTHER_IDENTIFICATION    =checkForNull(req.getParameter("OTHER_IDENTIFICATION")); 

			regn_no                 =checkForNull(req.getParameter("regn_no"));    
			vechile_no              =checkForNull(req.getParameter("vechile_no"));   
			burial_permit_app_by     =checkForNull(req.getParameter("burial_permit_app_by"));   
			burial_app_date          =checkForNull(req.getParameter("burial_app_date"));  

			
			if(!burial_app_date.equals(""))
				 burial_app_date=com.ehis.util.DateUtils.convertDate(burial_app_date,"DMYHM",locale, "en");	

			
			print_burialpermit        =checkForNull(req.getParameter("print_burialpermit"),"N");   
			body_burial_permit_no    =checkForNull(req.getParameter("body_burial_permit_no"));   
			body_claiming_date_time=checkForNull(req.getParameter("body_claiming_date_time"));  

			
			if(!body_claiming_date_time.equals(""))
				 body_claiming_date_time=com.ehis.util.DateUtils.convertDate(body_claiming_date_time,"DMYHM",locale, "en");	

			
			death_manner_code			= checkForNull(req.getParameter("manner_of_death"));
			patient_id					= checkForNull(req.getParameter("patient_id"));
			service_code				= checkForNull(req.getParameter("service_code"));
			body_condition_code			= checkForNull(req.getParameter("body_condition_code"));
			identification_marks		= checkForNull(req.getParameter("identification_marks"));
			consent_form_code			= checkForNull(req.getParameter("consent_form_code"));
			consent_chk					= checkForNull(req.getParameter("consent_chk"),"N");
			consent_received_by			= checkForNull(req.getParameter("consent_received_by"));
			consent_received_date		= checkForNull(req.getParameter("consent_received_date"));

			

			if(!consent_received_date.equals(""))
				 consent_received_date=com.ehis.util.DateUtils.convertDate(consent_received_date,"DMYHM",locale, "en");	

			

			police_chk					= checkForNull(req.getParameter("police_approval_received_yn"),"N");
			police_received_by			= checkForNull(req.getParameter("police_received_by"));
			police_received_date			= checkForNull(req.getParameter("police_received_date"));

			
			if(!police_received_date.equals(""))
				 police_received_date=com.ehis.util.DateUtils.convertDate(police_received_date,"DMYHM",locale, "en");	

			

			death_status_remarks			= checkForNull(req.getParameter("causeofdeath"));
			police_details			  = checkForNull(req.getParameter("police_details"));
			death_certificate_reqd_yn = checkForNull(req.getParameter("death_certificate_reqd_yn"),"N");
			brought_by_police_yn	  = checkForNull(req.getParameter("brought_by_police_yn"),"N");
			pol_rep_no				  = checkForNull(req.getParameter("pol_rep_no"));
			pol_stn_id				  = checkForNull(req.getParameter("pol_stn_id"));
			pol_id					  = checkForNull(req.getParameter("pol_id"));
			mode 					  =  checkForNull(req.getParameter("mode"));
			/*Added by Thamizh selvi on 25th July 2017 for ML-MMOH-CRF-0689 Start*/
			calledFrom				  = checkForNull(req.getParameter("calledFrom"));
			externalBidYn			  = checkForNull(req.getParameter("externalBidYn"),"N");
			policeOfficerName		  = checkForNull(req.getParameter("pol_officer_name"));
			policeContactNo			  = checkForNull(req.getParameter("pol_contact_no"));
			/*End*/
			hcare_type				= checkForNull(req.getParameter("hcare_type")); 	
			generate_burial_permit				= checkForNull(req.getParameter("generate_burial_permit")); 	// Suresh M
			RELEASE_TO_FACILITY				= checkForNull(req.getParameter("RELEASE_TO_FACILITY")); //Added Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg			
			reason_desc = checkForNull(req.getParameter("reason_desc")); //Added this Bru-HIMS-CRF-366 [IN-039612]
			external_rec_exists	=req.getParameter("external_rec_exists"); //Added For Bru-HIMS-CRF-0368 By Dharma on 3rd Dec 2013 
			
			if(generate_burial_permit.equals("")) generate_burial_permit="N";

			if(external_rec_exists.equals("Y") && external.equals("Y") && mode.equalsIgnoreCase("insert")){
				insertMORegn(res);
			}else{
				if(mode.equalsIgnoreCase("modify"))
				{
					 
					updateMORegn(res);
				}
				else
				{
					
					insertMORegn(res);
				}
				}

        }catch(Exception e)
		{
			e.printStackTrace();
	    }
        finally
	    {
		  ConnectionManager.returnConnection(con,req);
	    }
	}
  

	public static String checkForNull(String inputString)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
}

public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? defaultValue : inputString);
}
 private void  insertMORegn( HttpServletResponse res){
  try{

	  

    	String addedById			= p.getProperty( "login_user" ) ;
    	
		String modifiedById			= addedById ;
	
		String addedFacilityId		= facilityId;
		String modifiedFacilityId	= addedFacilityId ;
		String addedAtWorkstation	= client_ip_address;
		String modifiedAtWorkstation= addedAtWorkstation ;
		HashMap tabdata=new HashMap();
		tabdata.put("FACILITY_ID",facilityId);
		tabdata.put("REGISTRATION_NO",registration_no);
		if(external.equals("Y")){
			encounter_id=dec_enc_id;
		}
		tabdata.put("ENCOUNTER_ID",encounter_id);
		tabdata.put("MLC_YN",mlc_yn);
		tabdata.put("PM_YN",pm_yn);
		tabdata.put("BODY_RECEIVED_DATE",body_received_date);
		tabdata.put("PATIENT_ID",patient_id);
		tabdata.put("SERVICE_CODE",service_code);
		tabdata.put("DEATH_MANNER_CODE",death_manner_code);
		tabdata.put("BODY_COND_CODE",body_condition_code);
		tabdata.put("IDENTIFICATION_MARKS",identification_marks);
		tabdata.put("CONSENT_FORM_CODE",consent_form_code);
		tabdata.put("CONSENT_FORM_RECEIVED_YN",consent_chk);
	    tabdata.put("POLICE_DTLS",police_details);
		tabdata.put("DEATH_CERTIFICATE_REQD_YN",death_certificate_reqd_yn);
		tabdata.put("BROUGHT_BY_POLICE_YN",brought_by_police_yn);
		tabdata.put("PLACE_OF_DEATH",place_of_death);
		tabdata.put("POL_REP_NO",pol_rep_no);
		tabdata.put("POL_STN_ID",pol_stn_id);
		tabdata.put("POL_ID",pol_id);
		tabdata.put("POL_REP_NO",pol_rep_no);
		tabdata.put("AREA_CODE",area_type);
		tabdata.put("body_found_at",body_found_at);
		tabdata.put("deceasedat",deceasedat);
		tabdata.put("BED_NO",bed_no);
		tabdata.put("ADDED_BY_ID",addedById);
		tabdata.put("ASSIGN_DATE_TIME",assign_date_time);
		tabdata.put("RFID_Tag",RFID_Tag);
		tabdata.put("CONSENT_FORM_RECEIVED_BY",consent_received_by);			
		tabdata.put("CONSENT_FORM_RECEIVED_DATE",consent_received_date);
		tabdata.put("refe_type",refe_type);
		tabdata.put("hcare_type",hcare_type);
		tabdata.put("POLICE_APPROVAL_RECEIVED_YN",police_chk);
		tabdata.put("POLICE_APPROVAL_RECEIVED_BY",police_received_by);
    	tabdata.put("POLICE_APPROVAL_RECEIVED_DATE",police_received_date);
		tabdata.put("ADDED_AT_WS_NO",addedAtWorkstation);
		tabdata.put("ADDED_FACILITY_ID", facilityId);	
		tabdata.put("MODIFIED_BY_ID",modifiedById);
		tabdata.put("MODIFIED_AT_WS_NO",modifiedAtWorkstation );
		tabdata.put("MODIFIED_FACILITY_ID",modifiedFacilityId);
		tabdata.put("RELATIONSHIP_WITH_DECEASED",relationship_with_deceased);
		tabdata.put("CONSENT_GIVEN_BY",consent_given_by);
		tabdata.put("HIGH_RISK_BODY_YN", high_risk_body_yn);	
		tabdata.put("UNCLAIMED_BODY_YN",unclaimedbodyyn);
		tabdata.put("POSTMORTEM_TYPE",postmortem_type);
		tabdata.put("REF_SOURCE_CODE",referral_source );
		tabdata.put("REFERRED_BY",referral_by);
   		tabdata.put("POSTMORTEM_STATUS",postmortem_status);
		tabdata.put("DONOR_CARD_AVAILABLE_YN",donor_card_available_yn);
		tabdata.put("DONOR_CARD_NO", donor_card_no);	
		tabdata.put("DONOR_CARD_DETAILS",donor_card_details);
		tabdata.put("CONSENT_FORM_CODE2",consent_form_code2);
		tabdata.put("CONSENT_FORM_RECEIVED_BY2",consent_form_received_by2 );
		tabdata.put("CONSENT_FORM_RECEIVED_DATE2",consent_form_received_date2);
		tabdata.put("CONSENT_FORM_GIVEN_BY3",consent_form_given_by3);
        tabdata.put("RELATIONSHIP_WITH_DECEASED3",relationship_with_deceased3);
		tabdata.put("CONSENT_FORM_CODE3", consent_form_code3);	
		tabdata.put("CONSENT_FORM_RECEIVED_BY3",consent_form_received_by3);
		tabdata.put("CONSENT_FORM_RECEIVED_DATE3",consent_form_received_date3);
		tabdata.put("organdonation",organdonation );
		tabdata.put("CLAIM_DATE_TIME",body_claiming_date_time);
   		tabdata.put("CLAIMANT_TYPE",CLAIMANT_TYPE);
		tabdata.put("CLAIMANT_TYPE_CODE",CLAIMANT_TYPE_CODE);
		tabdata.put("RELATIONSHIP",RELATIONSHIP);
		tabdata.put("NAME",NAME);
		tabdata.put("res_town_code",res_town_code);
		tabdata.put("res_area_code",res_area_code);
		tabdata.put("region_code",region_code);
		tabdata.put("deceased_date",deceased_date);
		tabdata.put("JOB_TITLE",JOB_TITLE);
		tabdata.put("ADD_LINE1",ADD_LINE1);
		tabdata.put("ADD_LINE2",ADD_LINE2);
		tabdata.put("ADD_LINE3",ADD_LINE3);
		tabdata.put("ADD_LINE4",ADD_LINE4);
		tabdata.put("ZIP_CODE",ZIP_CODE);
		tabdata.put("COUNTRY_CODE",COUNTRY_CODE);
		tabdata.put("TELEPHONE_OFF",TELEPHONE_OFF);
		tabdata.put("TELEPHONE_RES",TELEPHONE_RES);
		tabdata.put("EMAIL_ID",EMAIL_ID);
		tabdata.put("MOB_TEL_NO",MOB_TEL_NO);
		tabdata.put("NAT_ID_NO",NAT_ID_NO);
		tabdata.put("ORGANIZATION_NAME",ORGANIZATION_NAME);
		tabdata.put("PATIENT_EMPLOYEE_ID",PATIENT_EMPLOYEE_ID);

		//Added by Ashwini on 24-Jul-2017 for ML-MMOH-CRF-0743
		tabdata.put("PASSPORT_NO",PASSPORT_NO);
		tabdata.put("OTHER_IDENTIFICATION",OTHER_IDENTIFICATION);

		tabdata.put("BURIAL_PERMIT_GEN_YN",print_burialpermit);
		tabdata.put("BURIAL_PERMIT_APPROVED_BY",burial_permit_app_by);
		tabdata.put("BURIAL_PERMIT_APPROVED_DATE",burial_app_date);
		tabdata.put("VEHICLE_NUM",vechile_no);
        tabdata.put("body_burial_permit_no",body_burial_permit_no);
        tabdata.put("death_status_remarks",death_status_remarks);
		tabdata.put("relgn_code",relgn_code);
		tabdata.put("relflagyn",relflagyn);
		tabdata.put("patient_class",patient_class);
		tabdata.put("generate_burial_permit",generate_burial_permit);
		tabdata.put("external",external);
		tabdata.put("dec_fac_id",dec_fac_id);
		tabdata.put("RELEASE_TO_FACILITY",RELEASE_TO_FACILITY); //Added Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg
		tabdata.put("reason_desc",reason_desc); //Added this CRF Bru-HIMS-CRF-366 [IN-039612] 
		/*Added by Thamizh selvi on 25th July 2017 for ML-MMOH-CRF-0689 Start*/
		tabdata.put("calledFrom",calledFrom);
		tabdata.put("externalBidYn",externalBidYn);
		tabdata.put("policeOfficerName",policeOfficerName);
		tabdata.put("policeContactNo",policeContactNo);
		/*End*/
		boolean local_ejbs = false;
        if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
		
		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/MortuaryRegistration",MOMortuaryRegnHome.class,local_ejbs);
		
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

		
		
		Object argArray[] = new Object[2];
		argArray[0] = p;
		argArray[1] = tabdata;
		Class [] paramArray = new Class[2];
		paramArray[0] = p.getClass();
		paramArray[1] = tabdata.getClass();
		java.util.HashMap results=new HashMap();
		
		results =(HashMap)busObj.getClass().getMethod("insertMORegn", paramArray).invoke(busObj, argArray); 

		inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
		
		error = (String) results.get("error") ;

		registration_no=error;
		error_value  = "0" ;
		if ( inserted )
		{ error_value = "1" ;
	      doOnlineReports(facilityId,registration_no);
		 out.println("<script>parent.messageFrame.location.href='../eCommon/jsp/error.jsp?err_num=&err_value=1'</script>");
		 // res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode("") + "&err_value=" + error_value );
		
		}
		else
		{ error_value = "0" ;
	res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8") + "&err_value=" + error_value );
		}tabdata.clear();
		 results.clear(); 
	  }catch ( Exception e )
      {			
		e.printStackTrace();
		out.println("<h3> Exception raised by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString()); 		
       }
  } 
 

private void doOnlineReports(String facility_id,String registration_no) throws ServletException, IOException, SQLException
    {
		StringBuffer htmlFor =new StringBuffer();
		
		String sqlString="";
		htmlFor.setLength(0);
		if(area_type.equals(""))
		{
		 sqlString =" select report_id, report_desc, 1 no_of_copies, module_id from sm_report where module_id = 'MO' AND REPORT_ID = 'MOBLABEL'";		
		}else
		{
		 sqlString =" select report_id, report_desc, 1 no_of_copies, module_id from sm_report where module_id = 'MO' AND REPORT_ID in('MOBLABEL','MOBFREEZ')";		
		
		}
	
		String reportParamNames = "p_facility_id,P_FM_REGISTRATION_NO,P_TO_REGISTRATION_NO";
		String reportParamValues = ""+facility_id+","+registration_no+","+registration_no+"";
	    
	  
	    htmlFor.append(" <html><head> <link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link>");
		htmlFor.append("<script src='../eCommon/js/showModalDialog.js' language='JavaScript'></script>");
        htmlFor.append("</head><body class='message'>");
        htmlFor.append("<script language = 'JavaScript'> async function mortureReport(){" );
        htmlFor.append("  var dialogHeight    = '30' ;");
        htmlFor.append( " var dialogWidth = '70' ;");
        htmlFor.append( "var dialogTop = 65;" );
        htmlFor.append( "  var arguments =   ''; ");
    	// modified the below line by Abirami - Bru-HIMS-CRF-313 / Passing function id in the below Query String.
        htmlFor.append("  var getUrl        =   '../../eCommon/jsp/InternalReportsPrint.jsp?P_function_id=MO_PRINT_BURIAL_PERMIT&step=1&sqlString="+java.net.URLEncoder.encode(sqlString,"UTF-8")+"&reportParamNames="+reportParamNames+"&reportParamValues="+reportParamValues+"&Patient_ID="+patient_id+"';");

        htmlFor.append(" var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; status=no;' ;");
        htmlFor.append("  retVal            =   await window.showModalDialog(getUrl,arguments,features); }");
        htmlFor.append(" mortureReport();</script>"  );
        out.println(htmlFor.toString());
		htmlFor.setLength(0);
 }



 private void  updateMORegn( HttpServletResponse res){
  try{

    	String addedById			= p.getProperty( "login_user" ) ;
    	String modifiedById			= addedById ;
		String addedFacilityId		= facilityId;
		String modifiedFacilityId	= addedFacilityId ;
		String addedAtWorkstation	= client_ip_address;
		String modifiedAtWorkstation= addedAtWorkstation ;
		HashMap tabdata=new HashMap();
		tabdata.put("FACILITY_ID",facilityId);
		tabdata.put("REGISTRATION_NO",registration_no);
		tabdata.put("ENCOUNTER_ID",encounter_id);
		tabdata.put("MLC_YN",mlc_yn);
		tabdata.put("PM_YN",pm_yn);
		tabdata.put("BODY_RECEIVED_DATE",body_received_date);
		tabdata.put("PATIENT_ID",patient_id);
		tabdata.put("SERVICE_CODE",service_code);
		tabdata.put("DEATH_MANNER_CODE",death_manner_code);
		tabdata.put("BODY_COND_CODE",body_condition_code);
		tabdata.put("IDENTIFICATION_MARKS",identification_marks);
		tabdata.put("CONSENT_FORM_CODE",consent_form_code);
		tabdata.put("CONSENT_FORM_RECEIVED_YN",consent_chk);
		tabdata.put("POLICE_DTLS",police_details);
		tabdata.put("DEATH_CERTIFICATE_REQD_YN",death_certificate_reqd_yn);
		tabdata.put("BROUGHT_BY_POLICE_YN",brought_by_police_yn);
		tabdata.put("PLACE_OF_DEATH",place_of_death);
		tabdata.put("POL_REP_NO",pol_rep_no);
		tabdata.put("POL_STN_ID",pol_stn_id);
		tabdata.put("POL_ID",pol_id);
		tabdata.put("POL_REP_NO",pol_rep_no);
		tabdata.put("AREA_CODE",area_type);
		tabdata.put("BED_NO",bed_no);
		tabdata.put("deceased_date",deceased_date);
		tabdata.put("regn_no",regn_no);
		tabdata.put("ADDED_BY_ID",addedById);
		tabdata.put("ASSIGN_DATE_TIME",assign_date_time);
		tabdata.put("RFID_Tag",RFID_Tag);
		tabdata.put("CONSENT_FORM_RECEIVED_BY",consent_received_by);			
		tabdata.put("CONSENT_FORM_RECEIVED_DATE",consent_received_date);
		tabdata.put("POSTMORTEM_TYPE",postmortem_type);
		tabdata.put("POSTMORTEM_STATUS",postmortem_status);
		tabdata.put("POSTMORTEM_STARTEND_STATUS",postmortem_startend_status);
		tabdata.put("refe_type",refe_type);
		tabdata.put("ADDED_AT_WS_NO",addedAtWorkstation);
		tabdata.put("ADDED_FACILITY_ID", facilityId);	
		tabdata.put("MODIFIED_BY_ID",modifiedById);
		tabdata.put("MODIFIED_AT_WS_NO",modifiedAtWorkstation );
		tabdata.put("MODIFIED_FACILITY_ID",modifiedFacilityId);
       	tabdata.put("RELATIONSHIP_WITH_DECEASED",relationship_with_deceased);
		tabdata.put("CONSENT_GIVEN_BY",consent_given_by);
		tabdata.put("HIGH_RISK_BODY_YN", high_risk_body_yn);	
		tabdata.put("UNCLAIMED_BODY_YN",unclaimedbodyyn);
		tabdata.put("POSTMORTEM_TYPE",postmortem_type);
		tabdata.put("body_found_at",body_found_at);
		tabdata.put("deceasedat",deceasedat);
		tabdata.put("REF_SOURCE_CODE",referral_source );
		tabdata.put("REFERRED_BY",referral_by);
		tabdata.put("hcare_type",hcare_type);
		tabdata.put("DONOR_CARD_AVAILABLE_YN",donor_card_available_yn);
		tabdata.put("DONOR_CARD_NO", donor_card_no);	
		tabdata.put("DONOR_CARD_DETAILS",donor_card_details);
		tabdata.put("CONSENT_FORM_CODE2",consent_form_code2);
		tabdata.put("CONSENT_FORM_RECEIVED_BY2",consent_form_received_by2 );
		tabdata.put("CONSENT_FORM_RECEIVED_DATE2",consent_form_received_date2);
		tabdata.put("CONSENT_FORM_GIVEN_BY3",consent_form_given_by3);
        tabdata.put("RELATIONSHIP_WITH_DECEASED3",relationship_with_deceased3);
		tabdata.put("CONSENT_FORM_CODE3", consent_form_code3);	
		tabdata.put("CONSENT_FORM_RECEIVED_BY3",consent_form_received_by3);
		tabdata.put("CONSENT_FORM_RECEIVED_DATE3",consent_form_received_date3);
		tabdata.put("organdonation",organdonation );
        tabdata.put("CLAIMANT_TYPE",CLAIMANT_TYPE);
		tabdata.put("CLAIMANT_TYPE_CODE",CLAIMANT_TYPE_CODE);
		tabdata.put("RELATIONSHIP",RELATIONSHIP);
		tabdata.put("relgn_code",relgn_code);
		tabdata.put("NAME",NAME);
    	tabdata.put("JOB_TITLE",JOB_TITLE);
		tabdata.put("ADD_LINE1",ADD_LINE1);
		tabdata.put("ADD_LINE2",ADD_LINE2);
		tabdata.put("ADD_LINE3",ADD_LINE3);
		tabdata.put("ADD_LINE4",ADD_LINE4);
		tabdata.put("ZIP_CODE",ZIP_CODE);
		tabdata.put("res_town_code",res_town_code);
		tabdata.put("res_area_code",res_area_code);
		tabdata.put("region_code",region_code);
		tabdata.put("COUNTRY_CODE",COUNTRY_CODE);
	    tabdata.put("TELEPHONE_OFF",TELEPHONE_OFF);
		tabdata.put("TELEPHONE_RES",TELEPHONE_RES);
		tabdata.put("EMAIL_ID",EMAIL_ID);
		tabdata.put("MOB_TEL_NO",MOB_TEL_NO);
		tabdata.put("NAT_ID_NO",NAT_ID_NO);
		tabdata.put("ORGANIZATION_NAME",ORGANIZATION_NAME);
		tabdata.put("PATIENT_EMPLOYEE_ID",PATIENT_EMPLOYEE_ID);

		//Added by Ashwini on 24-Jul-2017 for ML-MMOH-CRF-0743
		tabdata.put("PASSPORT_NO",PASSPORT_NO);
		tabdata.put("OTHER_IDENTIFICATION",OTHER_IDENTIFICATION);
		tabdata.put("BURIAL_PERMIT_GEN_YN",print_burialpermit);
		tabdata.put("BURIAL_PERMIT_APPROVED_BY",burial_permit_app_by);
		tabdata.put("BURIAL_PERMIT_APPROVED_DATE",burial_app_date);
		tabdata.put("CLAIM_DATE_TIME",body_claiming_date_time);
		tabdata.put("VEHICLE_NUM",vechile_no);
        tabdata.put("body_burial_permit_no",body_burial_permit_no);
        tabdata.put("death_status_remarks",death_status_remarks);
        tabdata.put("POLICE_APPROVAL_RECEIVED_YN",police_chk);
		tabdata.put("POLICE_APPROVAL_RECEIVED_BY",police_received_by);
    	tabdata.put("POLICE_APPROVAL_RECEIVED_DATE",police_received_date);
		tabdata.put("patient_class",patient_class);
		tabdata.put("generate_burial_permit",generate_burial_permit);
		tabdata.put("external",external);
		tabdata.put("RELEASE_TO_FACILITY",RELEASE_TO_FACILITY); //Added Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg		
		tabdata.put("reason_desc",reason_desc); //Added this CRF Bru-HIMS-CRF-366 [IN-039612]
		    /*Below line(s) "death_after_potmrtm" variable added by Venkatesh.S on 12-Nov-2013 against Bru-HIMS-CRF-365 [IN:039572]*/
		tabdata.put("death_after_potmrtm",death_after_potmrtm); 
		/*Added by Thamizh selvi on 25th July 2017 for ML-MMOH-CRF-0689 Start*/
		tabdata.put("calledFrom",calledFrom);
		tabdata.put("externalBidYn",externalBidYn);
		tabdata.put("policeOfficerName",policeOfficerName);
		tabdata.put("policeContactNo",policeContactNo);
		/*End*/

		boolean local_ejbs = false;
        if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
        Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/MortuaryRegistration",MOMortuaryRegnHome.class,local_ejbs);
        Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
        Object argArray[] = new Object[2];
        argArray[0] = p;
        argArray[1] = tabdata;
        Class [] paramArray = new Class[2];
        paramArray[0] = p.getClass();
        paramArray[1] = tabdata.getClass();
        java.util.HashMap results=new HashMap();
        results =(HashMap)busObj.getClass().getMethod("updateMORegn", paramArray).invoke(busObj, argArray); 
        busObj.getClass().getMethod("remove",null).invoke(busObj,null);
		inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
		error = (String) results.get("error") ;
        error_value  = "0" ;
		if ( inserted )
		{ error_value = "1" ;
		 res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=" + error_value );
		}
		 else
		 { error_value = "0" ;
		   res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=" + error_value );
		 }tabdata.clear();
		 results.clear();		
	     }catch ( Exception e )
         {			
		e.printStackTrace();
		out.println("<h3> Exception raised by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
        }
  } 
 }
