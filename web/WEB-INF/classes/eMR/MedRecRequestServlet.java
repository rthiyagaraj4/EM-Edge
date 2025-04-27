/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
@ MODULE		: Medical Records..(MR)
@ Function Name	: Medical Report Request 
@ Developer		: SRIDHAR R
*/

package eMR;
import eMR.MedRecRequest.*;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.SingleThreadModel;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.MessageManager;
import com.ehis.util.*;
import org.json.simple.*;  // added by mujafar for ML-MMOH-CRF-0762

import eCommon.XSSRequestWrapper;

public class MedRecRequestServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel
{
    PrintWriter out;
    java.util.Properties p;

    String client_ip_address ;
	String facilityId;

	String encounter_id	;
	String patient_id ;
	String requestor_desc ;
	String Requestor_Code ;  
	String appln_date ;  
	String MedicalMembers ;
	String pract_desc ;
	String practitioner_id ;
	String team_id	;
	String collect_date ;
	String remarks ;
	String Request_id ="";
	String locale="";

	Statement stmt = null;

    HttpSession session;

	String appl_addr_line1		= ""; 
	String appl_addr_line2		= ""; 
	String appl_addr_line3		= ""; 
	String appl_addr_line4		= ""; 
	String appl_area_code = ""; 
	String appl_country_code = ""; 
	String appl_postal_code = ""; 
	String appl_region_code = "";  
	String appl_town_code = ""; 

	/*Added by Ashwini on 20-Nov-2017 for ML-MMOH-CRF-0707*/
	String appl_contact_no1 = ""; 
	String appl_contact_no2 = "";  
	String appl_email_id = "";

	//String appl_mob_tel_no = "";
	
	/*for delivery address...*/
	String del_addr_line1		= ""; 
	String del_addr_line2		= ""; 
	String del_addr_line3		= ""; 
	String del_addr_line4		= ""; 
	String del_res_town_code	= ""; 
	String del_res_area_code	= ""; 
	String del_region_code		= ""; 
	String del_postal_code		= ""; 
	String del_country_code		= ""; 
	String relationship_type	= ""; 
	String cons_letter			= "";
	String sStyle				= "";
	String call_function		= "";
	int count = 0; // added by mujafar for ML-MMOH-CRF-0762

    java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

    public void init(ServletConfig config) throws ServletException
    {
        super.init(config);
    }

	public synchronized void doGet(HttpServletRequest req, HttpServletResponse res)
	throws javax.servlet.ServletException,IOException
	{
		doPost(req,res);
	}

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
    {
		session = req.getSession(false);
        this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
        this.facilityId = (String) session.getValue( "facility_id" ) ;
        client_ip_address = p.getProperty("client_ip_address");
		locale = p.getProperty("LOCALE");	
		sStyle	= (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
        try
        {            
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			
			req= new XSSRequestWrapper(req);
			res.addHeader("X-XSS-Protection", "1; mode=block");
			res.addHeader("X-Content-Type-Options", "nosniff");
			
            this.out = res.getWriter();
        	out.println("<!DOCTYPE html><head><link rel='stylesheet' type='text/css' href='../eCommon/html/"+sStyle+"'></link><script src='../eCommon/js/showModalDialog.js' language='JavaScript'></script><script language='JavaScript'> async function callPatientRegistrationServletHtml (){ ");		
			call_function	=  checkForNull(req.getParameter("call_function"));
			if(call_function.equals("MEDICAL_REPORT_REQUEST"))
				insertMedicalRequest(req);
			else if(call_function.equals("REVISE_MEDICAL_REPORT") || call_function.equals("REVISE_MEDICAL_BOARD")){
				insertReviseRequest(req);
			}
			out.println("} callPatientRegistrationServletHtml ();</script></body></html>");		
			
        }
        catch(Exception e)
        {
				e.printStackTrace();
        }
    }


private void insertMedicalRequest(HttpServletRequest req)
{
	HashMap error_msg = new HashMap();
	Connection con =null;
	JSONArray checklistArray		= new JSONArray(); // added by mujafar for ML-MMOH-CRF-0762
	try
	{
		con = ConnectionManager.getConnection(req);

		encounter_id	= checkForNull(req.getParameter("EncounterIDS"));	
		
		/*Added By Dharma on 2nd Dec 2019 against ML-MMOH-CRF-1454 Start*/
		String isSpecialtyDefaultApp	= checkForNull(req.getParameter("isSpecialtyDefaultApp"));
		
		String encIdsForSpecialty=encounter_id.replace('|',',');
		encIdsForSpecialty	= encIdsForSpecialty.substring(0, encIdsForSpecialty.length() - 1);
	    String lastEncSpecialtyCode = "";
	    if(isSpecialtyDefaultApp.equals("true")){
	    	lastEncSpecialtyCode = MRCommonBean.getLaestEncSpecialtyCode(con,encIdsForSpecialty,facilityId);
	    }
		/*Added By Dharma on 2nd Dec 2019 against ML-MMOH-CRF-1454 End*/
		patient_id		= checkForNull(req.getParameter("patientId"));
		requestor_desc	= checkForNull(req.getParameter("requestor_desc"));
		String req_type	= checkForNull(req.getParameter("req_type"));
		String other_application_ref_no	= checkForNull(req.getParameter("other_application_ref_no"));//Added By Dharma on 28/11/2019 against  ML-MMOH-CRF-1360
		String classification_appl_yn = checkForNull(req.getParameter("classification_appl_yn")); // added by mujafar for ML-MMOH-CRF-0762
		if(!req_type.equals(""))
		{
			appl_addr_line1	= checkForNull(req.getParameter("requestor_addr_line1"));
			appl_addr_line2	= checkForNull(req.getParameter("requestor_addr_line2"));
			appl_addr_line3	= checkForNull(req.getParameter("requestor_addr_line3"));
			appl_addr_line4	= checkForNull(req.getParameter("requestor_addr_line4"));
			appl_town_code	= checkForNull(req.getParameter("requestor_res_town_code"));
			appl_area_code	= checkForNull(req.getParameter("requestor_res_area_code"));
			appl_region_code = checkForNull(req.getParameter("requestor_region_code"));
			appl_postal_code = checkForNull(req.getParameter("requestor_postal_code"));
			appl_country_code = checkForNull(req.getParameter("requestor_country_code"));

			/*Added by Ashwini on 20-Nov-2017 for ML-MMOH-CRF-0707*/
			appl_contact_no1	= checkForNull(req.getParameter("requestor_contact_no1"));
			appl_contact_no2	= checkForNull(req.getParameter("requestor_contact_no2"));
			appl_email_id		= checkForNull(req.getParameter("requestor_appl_email_id"));
			/*ML-MMOH-CRF-0707*/
		}

		Requestor_Code	=  checkForNull(req.getParameter("Requestor_Code"));

		appln_date		=  checkForNull(req.getParameter("appln_date"));
		appln_date = DateUtils.convertDate(appln_date,"DMYHM",locale,"en");
			
		MedicalMembers	=  checkForNull(req.getParameter("MedicalMembers"));
		pract_desc		=  checkForNull(req.getParameter("pract_desc"));
		practitioner_id	=  checkForNull(req.getParameter("practitioner_id"));
		team_id			=  checkForNull(req.getParameter("team_id"));

		collect_date	=  checkForNull(req.getParameter("collect_date"));
		collect_date = DateUtils.convertDate(collect_date,"DMYHM",locale,"en");
		
		String add_recp_dat			= checkForNull(req.getParameter("add_recp_dat"));
		add_recp_dat = DateUtils.convertDate(add_recp_dat,"DMYHM",locale,"en");
		
		String recp_dat			= checkForNull(req.getParameter("recp_dat"));
		recp_dat = DateUtils.convertDate(recp_dat,"DMYHM",locale,"en");
		
		String req_type_status = checkForNull(req.getParameter("req_type_status")); // added by mujafar for ML-MMOH-CRF-0762

		
		remarks			=  checkForNull(req.getParameter("remarks")); 
	
		relationship_type =  checkForNull(req.getParameter("relationship_type"));
		
		
		
		
		if(relationship_type.equals("0")|| (classification_appl_yn.equals("true")&& req_type_status.equals("N")) )//Next Of Kin - NKIN
		{ // modified by mujafar for ML-MMOH-CRF-0762
			appl_addr_line1	= checkForNull(req.getParameter("nkin_addr_line1"));
			appl_addr_line2	= checkForNull(req.getParameter("nkin_addr_line2"));
			appl_addr_line3	= checkForNull(req.getParameter("nkin_addr_line3"));
			appl_addr_line4	= checkForNull(req.getParameter("nkin_addr_line4"));
			appl_town_code	= checkForNull(req.getParameter("nkin_res_town_code"));
			appl_area_code	= checkForNull(req.getParameter("nkin_res_area_code"));
			appl_region_code = checkForNull(req.getParameter("nkin_region_code"));
			appl_postal_code = checkForNull(req.getParameter("nkin_postal_code"));
			appl_country_code = checkForNull(req.getParameter("nkin_country_code"));

			/*Added by Ashwini on 20-Nov-2017 for ML-MMOH-CRF-0707*/
			appl_contact_no1	= checkForNull(req.getParameter("nkin_contact_no1"));
			appl_contact_no2	= checkForNull(req.getParameter("nkin_contact_no2"));
			appl_email_id		= checkForNull(req.getParameter("nkin_appl_email_id"));
			/*ML-MMOH-CRF-0707*/
		}
		else if(relationship_type.equals("1"))//First To Notify  - FTON
		{
			appl_addr_line1	= checkForNull(req.getParameter("fton_addr_line1"));
			appl_addr_line2	= checkForNull(req.getParameter("fton_addr_line2"));
			appl_addr_line3	= checkForNull(req.getParameter("fton_addr_line3"));
			appl_addr_line4	= checkForNull(req.getParameter("fton_addr_line4"));
			appl_town_code	= checkForNull(req.getParameter("fton_res_town_code"));
			appl_area_code	= checkForNull(req.getParameter("fton_res_area_code"));
			appl_region_code = checkForNull(req.getParameter("fton_region_code"));
			appl_postal_code = checkForNull(req.getParameter("fton_postal_code"));
			appl_country_code = checkForNull(req.getParameter("fton_country_code"));

			/*Added by Ashwini on 20-Nov-2017 for ML-MMOH-CRF-0707*/
			appl_contact_no1	= checkForNull(req.getParameter("fton_contact_no1"));
			appl_contact_no2	= checkForNull(req.getParameter("fton_contact_no2"));
			appl_email_id		= checkForNull(req.getParameter("fton_appl_email_id"));
			/*ML-MMOH-CRF-0707*/
		}
		else if(relationship_type.equals("2"))//Employer - EMPLR
		{
			appl_addr_line1	= checkForNull(req.getParameter("emplr_addr_line1"));
			appl_addr_line2	= checkForNull(req.getParameter("emplr_addr_line2"));
			appl_addr_line3	= checkForNull(req.getParameter("emplr_addr_line3"));
			appl_addr_line4	= checkForNull(req.getParameter("emplr_addr_line4"));
			appl_town_code	= checkForNull(req.getParameter("emplr_res_town_code"));
			appl_area_code	= checkForNull(req.getParameter("emplr_res_area_code"));
			appl_region_code = checkForNull(req.getParameter("emplr_region_code"));
			appl_postal_code = checkForNull(req.getParameter("emplr_postal_code"));
			appl_country_code = checkForNull(req.getParameter("emplr_country_code"));

			/*Added by Ashwini on 20-Nov-2017 for ML-MMOH-CRF-0707*/
			appl_contact_no1	= checkForNull(req.getParameter("emplr_contact_no1"));
			appl_contact_no2	= checkForNull(req.getParameter("emplr_contact_no2"));
			appl_email_id		= checkForNull(req.getParameter("emplr_appl_email_id"));
			/*ML-MMOH-CRF-0707*/
		}
		else if(relationship_type.equals("3")|| (classification_appl_yn.equals("true")&& req_type_status.equals("P")) )//Self
		{  // modified by mujafar for ML-MMOH-CRF-0762
			appl_addr_line1		= checkForNull(req.getParameter("appl_addr_line1"));	
			appl_addr_line2		= checkForNull(req.getParameter("appl_addr_line2"));	
			appl_addr_line3		= checkForNull(req.getParameter("appl_addr_line3"));	
			appl_addr_line4		= checkForNull(req.getParameter("appl_addr_line4"));	
			appl_town_code	= checkForNull(req.getParameter("appl_res_town_code"));	
			appl_area_code	= checkForNull(req.getParameter("appl_res_area_code"));	
			appl_region_code	= checkForNull(req.getParameter("appl_region_code"));	
			appl_postal_code	= checkForNull(req.getParameter("appl_postal_code"));
			appl_country_code	= checkForNull(req.getParameter("appl_country_code"));

			/*Added by Ashwini on 20-Nov-2017 for ML-MMOH-CRF-0707*/
			appl_contact_no1	= checkForNull(req.getParameter("self_contact_no1"));
			appl_contact_no2	= checkForNull(req.getParameter("self_contact_no2"));
			appl_email_id		= checkForNull(req.getParameter("self_appl_email_id"));
			/*ML-MMOH-CRF-0707*/
		}
		else if(relationship_type.equals("4") || (classification_appl_yn.equals("true")&& req_type_status.equals("O")) || (classification_appl_yn.equals("true")&& req_type_status.equals(""))  )//Others - OTH
		{ // modified by mujafar for ML-MMOH-CRF-0762
			appl_addr_line1	= checkForNull(req.getParameter("Oth_appl_addr_line1"));
			appl_addr_line2	= checkForNull(req.getParameter("Oth_appl_addr_line2"));
			appl_addr_line3	= checkForNull(req.getParameter("Oth_appl_addr_line3"));
			appl_addr_line4	= checkForNull(req.getParameter("Oth_appl_addr_line4"));
			appl_town_code	= checkForNull(req.getParameter("Oth_appl_res_town_code"));
			appl_area_code	= checkForNull(req.getParameter("Oth_appl_res_area_code"));
			appl_region_code = checkForNull(req.getParameter("Oth_appl_region_code"));
			appl_postal_code = checkForNull(req.getParameter("Oth_appl_postal_code"));
			appl_country_code = checkForNull(req.getParameter("Oth_appl_country_code"));

			/*Added by Ashwini on 20-Nov-2017 for ML-MMOH-CRF-0707*/
			appl_contact_no1	= checkForNull(req.getParameter("other_contact_no1"));
			appl_contact_no2	= checkForNull(req.getParameter("other_contact_no2"));
			appl_email_id		= checkForNull(req.getParameter("other_appl_email_id"));
			/*ML-MMOH-CRF-0707*/
		}

		/*for delivery address...*/
		del_addr_line1		= checkForNull(req.getParameter("del_addr_line1"));	
		del_addr_line2		= checkForNull(req.getParameter("del_addr_line2"));	
		del_addr_line3		= checkForNull(req.getParameter("del_addr_line3"));	
		del_addr_line4		= checkForNull(req.getParameter("del_addr_line4"));	
		del_res_town_code	= checkForNull(req.getParameter("del_res_town_code"));	
		del_res_area_code	= checkForNull(req.getParameter("del_res_area_code"));	
		del_region_code		= checkForNull(req.getParameter("del_region_code"));	
		del_postal_code		= checkForNull(req.getParameter("del_postal_code"));
		del_country_code	= checkForNull(req.getParameter("del_country_code"));

		String relationship	= checkForNull(req.getParameter("relationship"));
		String appl_type	= checkForNull(req.getParameter("appl_type"));
		String appl_no		= checkForNull(req.getParameter("appl_no"));
		String appl_name	= checkForNull(req.getParameter("appl_name"));
		String appl_addr	= checkForNull(req.getParameter("appl_addr"));
		
		String appl_refno	= checkForNull(req.getParameter("appl_refno"));
		String for_attn		= checkForNull(req.getParameter("for_attn"));
		String rep_type		= checkForNull(req.getParameter("rep_type"));
		String dept_spl		= checkForNull(req.getParameter("Splcode"));
		/*Added By Dharma on 2nd Dec 2019 against ML-MMOH-CRF-1454 Start*/
		if(dept_spl.equals("")){
			dept_spl	= lastEncSpecialtyCode;
		}
		/*Added By Dharma on 2nd Dec 2019 against ML-MMOH-CRF-1454 End*/
		String appl_status	= checkForNull(req.getParameter("appl_status"));

		String appl_comp_dat= checkForNull(req.getParameter("appl_comp_dat"));
	
		String reqd_docs	= checkForNull(req.getParameter("reqd_docs"));
		String board_type	= checkForNull(req.getParameter("board_type"));

		cons_letter	= checkForNull(req.getParameter("cons_letter"));

		String charges_appllicable	= checkForNull(req.getParameter("charges_appllicable"));
			if(charges_appllicable.equals("")) charges_appllicable = "N";

		String additional_charges	= checkForNull(req.getParameter("additional_charges"));
			if(additional_charges.equals("")) additional_charges = "N";

		//Added By Ashwini on 21-Aug-2017 for ML-MMOH-CRF-0708
		String ret_val	= checkForNull(req.getParameter("ret_val"));
		
		String amount = checkForNull(req.getParameter("amount"));
		
		String addedById			= p.getProperty( "login_user" ) ;
		String addedDate			= dateFormat.format( new java.util.Date() ) ;
		String modifiedById			= addedById ;
		String modifiedDate			= addedDate ;
		String addedFacilityId		= facilityId;
		String modifiedFacilityId	= addedFacilityId ;
		String addedAtWorkstation	= client_ip_address;
		String modifiedAtWorkstation = addedAtWorkstation ;
		String error = "";

		HashMap tableData = new HashMap();
		
		// added by mujafar for ML-MMOH-CRF-0762 start
		
		if(classification_appl_yn.equals("true"))
			
			{
				
				String contact2_nat_id_no = checkForNull(req.getParameter("contact2_nat_id_no"));
				String contact1_oth_alt_id_type = checkForNull(req.getParameter("contact1_oth_alt_id_type")); 
				String contact1_oth_alt_id_no = checkForNull(req.getParameter("contact1_oth_alt_id_no"));
				
				
				checklistArray =  MRCommonBean.getChecklistValues(con,req_type,Requestor_Code);
				
			
				
				
				count =  checklistArray.size();
				String[] checklistcodearray= new String[count];
				
			
				
				tableData.put("classification_appl_yn",classification_appl_yn);
				tableData.put("contact2_nat_id_no",contact2_nat_id_no);
				tableData.put("contact1_oth_alt_id_type",contact1_oth_alt_id_type);
				tableData.put("contact1_oth_alt_id_no",contact1_oth_alt_id_no);
				tableData.put("count",count);
				
				String ret_val1 = checkForNull(req.getParameter("ret_val1"));
				
				if(ret_val1.equals("")) ret_val1 = "N";
				String retVal1[]= ret_val1.split("~");
				
				for(int i = 0 ; i < checklistArray.size() ; i++)
				{
				JSONObject json	= (JSONObject)checklistArray.get(i);
				
				String chk_list_code = (String) json.get("chk_list_code");
				tableData.put("chk_list_code"+i,chk_list_code);
				tableData.put("chk_list_code_status"+i,retVal1[i]);
				
				
				
				}
				
				String classification_ind = checkForNull(MRCommonBean.getIndicator(con,req_type));
				
				tableData.put("classification_ind",classification_ind);
				
			
			}
		
		// added by mujafar for ML-MMOH-CRF-0762 end

		tableData.put("encounter_id",encounter_id); 
		tableData.put("patient_id",patient_id); 
		tableData.put("requestor_desc",requestor_desc); 
		tableData.put("Requestor_Code",Requestor_Code); 
		tableData.put("appln_date",appln_date); 
		tableData.put("MedicalMembers",MedicalMembers); 
		tableData.put("pract_desc",pract_desc); 
		tableData.put("practitioner_id",practitioner_id); 
		tableData.put("team_id",team_id); 
		tableData.put("collect_date",collect_date); 
		tableData.put("remarks",remarks); 
		tableData.put("other_application_ref_no",other_application_ref_no);//Added By Dharma on 28/11/2019 against  ML-MMOH-CRF-1360
		tableData.put("relationship_type",relationship_type); 
		tableData.put("relationship",relationship);
		tableData.put("req_type",req_type);
		tableData.put("appl_type",appl_type);
		tableData.put("appl_no",appl_no);
		tableData.put("appl_name",appl_name);
		tableData.put("appl_addr",appl_addr);
		tableData.put("cons_letter",cons_letter);
		tableData.put("appl_refno",appl_refno);
		tableData.put("for_attn",for_attn);
		tableData.put("rep_type",rep_type);
		tableData.put("dept_spl",dept_spl);
		tableData.put("appl_status",appl_status);
		tableData.put("appl_comp_dat",appl_comp_dat);
		tableData.put("reqd_docs",reqd_docs);
		tableData.put("board_type",board_type);
		tableData.put("charges_appllicable",charges_appllicable);
		tableData.put("additional_charges",additional_charges);
		tableData.put("amount",amount);
		tableData.put("receipt_no",checkForNull(req.getParameter("recp_no")));
		tableData.put("addl_amount",checkForNull(req.getParameter("add_amount")));
		tableData.put("addl_receipt_no",checkForNull(req.getParameter("add_recp_no")));
		tableData.put("add_recp_dat",add_recp_dat);
		tableData.put("recp_dat",recp_dat);

		tableData.put("appl_addr_line1",appl_addr_line1);
		tableData.put("appl_addr_line2",appl_addr_line2);
		tableData.put("appl_addr_line3",appl_addr_line3);
		tableData.put("appl_addr_line4",appl_addr_line4);
		tableData.put("appl_town_code",appl_town_code);
		tableData.put("appl_area_code",appl_area_code);
		tableData.put("appl_region_code",appl_region_code);
		tableData.put("appl_postal_code",appl_postal_code);
		tableData.put("appl_country_code",appl_country_code);
		tableData.put("del_addr_line1",del_addr_line1);
		tableData.put("del_addr_line2",del_addr_line2);
		tableData.put("del_addr_line3",del_addr_line3);
		tableData.put("del_addr_line4",del_addr_line4);
		tableData.put("del_res_town_code",del_res_town_code);
		tableData.put("del_res_area_code",del_res_area_code);
		tableData.put("del_region_code",del_region_code);
		tableData.put("del_postal_code",del_postal_code);
		tableData.put("del_country_code",del_country_code);

		//Added By Ashwini on 21-Aug-2017 for ML-MMOH-CRF-0708
		if(ret_val.equals("")) ret_val = "N"; 
		String retVal[]= ret_val.split("~");
		tableData.put("CHKLST_CONSENT_FR_PAT",retVal[0]);
		tableData.put("CHKLST_IDENT_DOC",retVal[1]);
		tableData.put("CHKLST_MARITAL_CERT",retVal[2]);
		tableData.put("CHKLST_STAT_DEC",retVal[3]);
		tableData.put("CHKLST_CONSENT_FR_EMBSY",retVal[4]);
		tableData.put("CHKLST_PAYMENT",retVal[5]);  

		/*Added by Ashwini on 20-Nov-2017 for ML-MMOH-CRF-0707*/
		tableData.put("contact_no1",appl_contact_no1);
		tableData.put("contact_no2",appl_contact_no2);
		tableData.put("appl_email_id",appl_email_id);
		/*ML-MMOH-CRF-0707*/

		tableData.put("addedById",addedById); 
		tableData.put("addedDate",addedDate); 
		tableData.put("modifiedById",modifiedById); 
		tableData.put("modifiedDate",modifiedDate); 
		tableData.put("addedFacilityId",addedFacilityId); 
		tableData.put("modifiedFacilityId",modifiedFacilityId); 
		tableData.put("addedAtWorkstation",addedAtWorkstation); 
		tableData.put("modifiedAtWorkstation",modifiedAtWorkstation); 
		tableData.put("facilityId",facilityId); 

		
		boolean local_ejbs = false;
		if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/MedRecRequest",MedRecRequestHome.class,local_ejbs);
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

		Object argArray[] = new Object[2];
		argArray[0] = p;
		argArray[1] = tableData;

		Class [] paramArray = new Class[2];
		paramArray[0] = p.getClass();
		paramArray[1] = tableData.getClass();

		HashMap results = (HashMap)(busObj.getClass().getMethod("insertMedRecRequest",paramArray)).invoke(busObj,argArray);
		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

		boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue());
		error_msg = results;
		error = (String) results.get("error") ;
		Request_id = (String) results.get("req_id") ;

		if (inserted)
		{
			java.util.Hashtable message=MessageManager.getMessage(locale,"RECORD_MODIFIED","SM");
			error = (String) message.get("message") ;
			//error= error.substring(0,error.indexOf("<br>")) ;
			out.println("alert('"+error+" with Request ID : "+Request_id+"');") ;	

			if( call_function.equals("MEDICAL_REPORT_REQUEST") && cons_letter.equals("0") ) // if Available
			{
				doOnlineReports(patient_id, Request_id, "", cons_letter,con);/*Modified by Rameswar on  18-07-2016 for ML-MMOH-CRF-0441*/
			}
			else if(call_function.equals("REVISE_MEDICAL_REPORT") || call_function.equals("REVISE_MEDICAL_BOARD"))
			{
				doOnlineReports(patient_id, Request_id, "", cons_letter,con);/*Modified by Rameswar on  18-07-2016 for ML-MMOH-CRF-0441*/
			}

			if ( message != null ) message.clear();
		}
		else
		{
			error = (String) results.get("error") ;
			//error= error.substring(0,error.indexOf("<br>")) ;
			out.println("alert(\""+error+"\");") ;
		}

		//out.println("parent.window.close()");
		out.println("top.document.getElementById('dialog_tag').close()");

		if ( tableData != null) tableData.clear();
		if ( results != null) results.clear();
	}catch ( Exception e ) 
	{
       /*  out.print("Exception in insertMedicalRequest : "+e.toString());
        out.print("error_msg in insertMedicalRequest : "+error_msg); */
		
			e.printStackTrace();
    }
	finally
	{
		if ( error_msg != null) error_msg.clear();
		try
		{
			if(stmt != null) stmt.close();
			if(con != null)	ConnectionManager.returnConnection(con,req);
			}catch(Exception e)
			{
				//out.print("Exception in finallay : "+e.toString());
				
					e.printStackTrace();
			}
	}
}

private void insertReviseRequest(HttpServletRequest req)
{
    Connection con =null;
	HashMap error_msg = new HashMap();
	
	try
	{
		con = ConnectionManager.getConnection(req);

		String patientId = checkForNull(req.getParameter("patientId"));
		String request_id= checkForNull(req.getParameter("request_id"));
		String hdd_request_desc= checkForNull(req.getParameter("hdd_request_desc"));
		String  hdd_Medical_members= checkForNull(req.getParameter("hdd_Medical_members"));
		String  hdd_Pract_name= checkForNull(req.getParameter("hdd_Pract_name"));
		//String  hdd_team_desc= checkForNull(req.getParameter("hdd_team_desc"));
		String  hdd_CollectDate= checkForNull(req.getParameter("hdd_CollectDate"));
		String  hdd_remarks= checkForNull(req.getParameter("hdd_remarks"));
		String  hdd_requestor_code= checkForNull(req.getParameter("hdd_requestor_code"));
		String  hdd_team_code= checkForNull(req.getParameter("hdd_team_code"));
		String  hdd_pract_code= checkForNull(req.getParameter("hdd_pract_code"));

		String  revised_date= checkForNull(req.getParameter("revised_collect_date"));
		revised_date = DateUtils.convertDate(revised_date,"DMYHM",locale,"en");
		
		String  Auth_by= checkForNull(req.getParameter("Authorised_hid"));
		String addedById			= p.getProperty( "login_user" ) ;
		String addedDate			= dateFormat.format( new java.util.Date() ) ;
		String modifiedById			= addedById ;
		String modifiedDate			= addedDate ;
		String addedFacilityId		= facilityId;
		String modifiedFacilityId	= addedFacilityId ;
		String addedAtWorkstation	= client_ip_address;
		String modifiedAtWorkstation = addedAtWorkstation ;
		String error = "";

		HashMap tableData = new HashMap();
		tableData.put("patient_id",patientId); 
		tableData.put("request_id",request_id); 
		tableData.put("requestor_desc",hdd_request_desc); 
		tableData.put("Requestor_Code",hdd_requestor_code); 
		tableData.put("MedicalMembers",hdd_Medical_members); 
		tableData.put("pract_desc",hdd_Pract_name); 
		tableData.put("practitioner_id",hdd_pract_code); 
		tableData.put("team_id",hdd_team_code); 
		tableData.put("collect_date",hdd_CollectDate); 
		tableData.put("remarks",hdd_remarks); 
		tableData.put("revised_date",revised_date); 
		tableData.put("Auth_by",Auth_by); 

		tableData.put("addedById",addedById); 
		tableData.put("addedDate",addedDate); 
		tableData.put("modifiedById",modifiedById); 
		tableData.put("modifiedDate",modifiedDate); 
		tableData.put("addedFacilityId",addedFacilityId); 
		tableData.put("modifiedFacilityId",modifiedFacilityId); 
		tableData.put("addedAtWorkstation",addedAtWorkstation); 
		tableData.put("modifiedAtWorkstation",modifiedAtWorkstation); 
		tableData.put("facilityId",facilityId); 
		
	
		boolean local_ejbs = false;

		if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/MedRecRequest",MedRecRequestHome.class,local_ejbs);
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

		Object argArray[] = new Object[2];
		argArray[0] = p;
		argArray[1] = tableData;

		Class [] paramArray = new Class[2];
		paramArray[0] = p.getClass();
		paramArray[1] = tableData.getClass();

		HashMap results = (HashMap)(busObj.getClass().getMethod("insertReviseRequestbean",paramArray)).invoke(busObj,argArray);
		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

		boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

		error_msg = results;
		error = (String) results.get("error") ;

		if(inserted)
		{
			java.util.Hashtable message = MessageManager.getMessage( locale, "RECORD_MODIFIED" ,"SM") ;
			error = (String) message.get("message") ;
			doOnlineReports(patientId, request_id, call_function, "",con);/*Modified by Rameswar on  18-07-2016 for ML-MMOH-CRF-0441*/
			if ( message != null ) message.clear();
		}
		else
		{
			error = (String) results.get("error") ;
			error = "Errors Encountered..";
		}

		//error= error.substring(0,error.indexOf("<br>")) ;
		out.println("alert(\""+error+"\");top.document.getElementById('dialog_tag').close()") ;
		if ( tableData != null) tableData.clear();
		if ( results != null) results.clear();
	}catch ( Exception e ) 
	{
        /* out.println("Exception in insertReviseRequest : "+e);
        out.println("<br> error_msg in insertReviseRequest : "+error_msg); */
		
			e.printStackTrace();
    }
	finally
	{
		if ( error_msg != null) error_msg.clear();
		try
		{
			if(stmt != null) stmt.close();
			if(con != null)
			ConnectionManager.returnConnection(con,req);
		}catch(Exception e)
		{
			//out.print("Exception in finally Block : "+e.toString());
			
				e.printStackTrace();
		}
	}
}

///Added by Sridhar R on 21 OCT 2004 for online report generation from report request & Rivse report Functions...
private void doOnlineReports(String patient_Id, String request_ID,String function_id, String consent_letter,Connection con) throws ServletException, IOException, SQLException
{
	
	String facilityId	= (String) session.getValue( "facility_id" ) ;
	String sqlString	= "";		
	String reportParamNames	= "";
	String reportParamValues= "";
	
	Boolean WCHspecReport = eCommon.Common.CommonBean.isSiteSpecific(con, "MR","ACKNOWLEDGMENT_LETTER");/*Added by Rameswar on  18-07-2016 for ML-MMOH-CRF-0441*/
	String ackLetter ="";/*Added by Rameswar on  18-07-2016 for ML-MMOH-CRF-0441*/
	try
	{
		if(function_id.equals("REVISE_MEDICAL_REPORT") || function_id.equals("REVISE_MEDICAL_BOARD"))
		{	/*Added by Rameswar on  18-07-2016 for ML-MMOH-CRF-0441*/
			if(WCHspecReport &&function_id.equals("REVISE_MEDICAL_REPORT") ){

				ackLetter=",'MRACKLTR'";
			}

			//MRBRCLTR - Recall Letter for Medical Report Request	
			sqlString = " SELECT report_id, report_desc, 1 no_of_copies, module_id FROM sm_report WHERE  module_id = 'MR' AND report_id in('MRBRCLTR'"+ackLetter+") ";/*Added by Rameswar on  18-07-2016 for ML-MMOH-CRF-0441*/
		}
		else if(function_id.equals(""))
		{
			//MRBMRCFR - Consent Form for Medical Report Request
			if(consent_letter.equals("0")) // if Available
			{
				sqlString = " SELECT report_id, report_desc, 1 no_of_copies, module_id FROM sm_report WHERE  module_id = 'MR' AND report_id = 'MRBMRCFR' ";
			}
		}
		reportParamNames = "p_request_id,p_facility_id,p_patient_id";
		reportParamValues = ""+request_ID+","+facilityId+","+patient_Id+"";

		String htmlFor = "";
		StringBuffer sb_htmlFor = new StringBuffer();
		
		sb_htmlFor.append("  var dialogHeight	= '50vh';");
		sb_htmlFor.append("  var dialogWidth	= '55vw';");
		sb_htmlFor.append("  var dialogTop		= '5';");
		sb_htmlFor.append("  var arguments		=	'';");
		// modified the below line by Abirami - Bru-HIMS-CRF-313 / Passing function id in the below Query String.
		sb_htmlFor.append("  var getUrl		=	'../../eCommon/jsp/InternalReportsPrint.jsp?P_function_id=REVISE_MEDICAL_REPORT&step=1&sqlString="+java.net.URLEncoder.encode(sqlString)+"&reportParamNames="+reportParamNames+"&reportParamValues="+reportParamValues+"&Patient_ID="+patient_Id+"';");
		sb_htmlFor.append("var features = 'dialogHeight:'+dialogHeight+'; dialogWidth:'+dialogWidth+'; status=no;' ;");
		sb_htmlFor.append("retVal = await top.window.showModalDialog(getUrl,arguments,features); top.document.getElementById('dialog_tag').close();");
	
		htmlFor = sb_htmlFor.toString();
		System.out.println("line no 748"+htmlFor);
		out.println(htmlFor);
		
		
	}
	catch ( Exception e )
	{
		//out.println("Encountered error while Processing Online Reports "+e.toString());
		
			e.printStackTrace();
	}
}


	private String checkForNull(String inputString)
	{
		return (inputString==null) ? "" : inputString;
	}

}
