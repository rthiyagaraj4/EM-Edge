/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/* 
* @Module		: Medical Records..[MR]
* @Author		: SRIDHAR R 
* @Created on	: 23 MARCH 2005
* @Function | ID: Request For Medical Board	| MEDICAL_BOARD_REQUEST	| REQUEST_STATUS = 1
 */

package eMR;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import com.ehis.util.*;
import webbeans.eCommon.*;
//import webbeans.eCommon.ConnectionManager;
import eCommon.SingleTabHandler.*;

import eCommon.XSSRequestWrapper;


public class MedBoardRequestServlet extends javax.servlet.http.HttpServlet 
{
    PrintWriter out;
    java.util.Properties p;

    String client_ip_address ;
	String facilityId;
	//String encounter_id	;
	String patient_id ;
	//String requestor_desc ;
	String Requestor_Code ;  
	String appln_date ;  
	String MedicalMembers ;
	//String pract_desc ;
	String practitioner_id ;
	String team_id	;
	String collect_date ;
	String remarks ;
	String Request_id ="";
	String locale="";
    HttpSession session;

	String appl_addr_line1		= ""; 
	String appl_addr_line2		= ""; 
	String appl_addr_line3		= ""; 
	String appl_addr_line4		= ""; 
	String appl_area_code		= ""; 
	String appl_country_code	= ""; 
	String appl_postal_code		= ""; 
	String appl_region_code	= "";  
	String appl_town_code		= ""; 

	/*Added by Ashwini on 20-Nov-2017 for ML-MMOH-CRF-0707*/
	String appl_contact_no1 = ""; 
	String appl_contact_no2 = "";  
	String appl_email_id = "";
	
	String relationship_type	= ""; 
	String cons_letter			= "";
	String recp_dat				= "";
	String add_recp_dat			= "";
	String charges_appllicable_yn	= "N";
	String additional_charges_yn	= "N";
	String patient_name				= "";
	String patient_name_long="";
	String patient_name_local_lang="";
	String patient_name_loc_lang_long="";
	String sStyle="";

    java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");

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
			String call_function	=  checkForNull(req.getParameter("call_function"));
		
			if(call_function.equals("MEDICAL_BOARD_REQUEST"))
				insertMedicalBoardRequest(req);
	
		}catch(Exception e)
        {
           // out.println(e.toString());
			e.printStackTrace();
        }
    }


private void insertMedicalBoardRequest(HttpServletRequest req)
{
	HashMap error_msg	= new HashMap();
	Connection con		= null;
	ResultSet reqIDRS	= null;
	Statement reqIDStmt	= null;
	int req_id = 0;
	boolean	proceed		= true ;
	String request_status = "1";
	String request_type = "MB";
	try
	{
		con = ConnectionManager.getConnection(req);
		con.setAutoCommit(false);
		try
		{
			String reqIDSql=" select MR_MED_REPORT_REQUEST_SEQ.NEXTVAL from dual ";
			reqIDStmt = con.createStatement() ;
			reqIDRS	= reqIDStmt.executeQuery(reqIDSql) ;

			if( reqIDRS !=null )
			{
				while(reqIDRS.next())
				{
					req_id	= reqIDRS.getInt(1);
				}
			}
			if(reqIDRS != null) reqIDRS.close();
			if(reqIDStmt != null) reqIDStmt.close();
		}catch(Exception e1)
		{
			e1.printStackTrace();
			proceed = false;
		}

		if(proceed)
		{
			patient_name	= checkForNull(req.getParameter("patient_name"));
			if(patient_name !=null && patient_name.length()>100){
				patient_name=patient_name.substring(0,100);
			}

			patient_name_local_lang=checkForNull(req.getParameter("patient_name_local_lang"));
			if(patient_name_local_lang !=null && patient_name_local_lang.length()>100){
				patient_name_local_lang=patient_name_local_lang.substring(0,100);
			}

			patient_name_long=checkForNull(req.getParameter("patient_name_long"));
			if(patient_name_long !=null && patient_name_long.length()>300){
				patient_name_long=patient_name_long.substring(0,300);
			}

			patient_name_loc_lang_long=checkForNull(req.getParameter("patient_name_loc_lang_long"));
			if(patient_name_loc_lang_long !=null && patient_name_loc_lang_long.length()>300){
				patient_name_loc_lang_long=patient_name_loc_lang_long.substring(0,300);
			}

			patient_id		= checkForNull(req.getParameter("patientId"));
			if(patient_id.equals(""))
				patient_id		= checkForNull(req.getParameter("patient_id"));

			Requestor_Code	= checkForNull(req.getParameter("Requestor_Code"));
			MedicalMembers	= checkForNull(req.getParameter("MedicalMembers"));
			practitioner_id	= checkForNull(req.getParameter("practitioner_id"));
			team_id			= checkForNull(req.getParameter("team_id"));

			collect_date	= checkForNull(req.getParameter("collect_date"));
			collect_date = DateUtils.convertDate(collect_date,"DMYHM",locale,"en");
			

			remarks			= checkForNull(req.getParameter("remarks"));

			String req_type	= checkForNull(req.getParameter("req_type"));
			if(!req_type.equals(""))
			{
				appl_addr_line1	= checkForNull(req.getParameter("requestor_addr_line1"));
				appl_addr_line2	= checkForNull(req.getParameter("requestor_addr_line2"));
				appl_addr_line3	= checkForNull(req.getParameter("requestor_addr_line3"));
				appl_addr_line4	= checkForNull(req.getParameter("requestor_addr_line4"));
				appl_town_code	= checkForNull(req.getParameter("requestor_res_town_code"));
				appl_area_code	= checkForNull(req.getParameter("requestor_res_area_code"));
				appl_region_code = checkForNull(req.getParameter("requestor_region_code"));
				appl_postal_code = checkForNull(req.getParameter("requestor_postal_desc"));
				appl_country_code = checkForNull(req.getParameter("requestor_country_code"));

				/*Added by Ashwini on 20-Nov-2017 for ML-MMOH-CRF-0707*/
				appl_contact_no1	= checkForNull(req.getParameter("requestor_contact_no1"));
				appl_contact_no2	= checkForNull(req.getParameter("requestor_contact_no2"));
				appl_email_id		= checkForNull(req.getParameter("requestor_appl_email_id"));
				/*ML-MMOH-CRF-0707*/
			}
			relationship_type	=  checkForNull(req.getParameter("relationship_type"));
			if(relationship_type.equals("0"))//Next Of Kin - NKIN
			{
				appl_addr_line1	= checkForNull(req.getParameter("nkin_addr_line1"));
				appl_addr_line2	= checkForNull(req.getParameter("nkin_addr_line2"));
				appl_addr_line3	= checkForNull(req.getParameter("nkin_addr_line3"));
				appl_addr_line4	= checkForNull(req.getParameter("nkin_addr_line4"));
				appl_town_code	= checkForNull(req.getParameter("nkin_res_town_code"));
				appl_area_code	= checkForNull(req.getParameter("nkin_res_area_code"));
				appl_region_code = checkForNull(req.getParameter("nkin_region_code"));
				appl_postal_code = checkForNull(req.getParameter("nkin_postal_desc"));
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
			else if(relationship_type.equals("3"))//Self
			{
				appl_addr_line1		= checkForNull(req.getParameter("appl_addr_line1"));	
				appl_addr_line2		= checkForNull(req.getParameter("appl_addr_line2"));	
				appl_addr_line3		= checkForNull(req.getParameter("appl_addr_line3"));	
				appl_addr_line4		= checkForNull(req.getParameter("appl_addr_line4"));	
				appl_town_code		= checkForNull(req.getParameter("appl_res_town_code"));	
				appl_area_code		= checkForNull(req.getParameter("appl_res_area_code"));	
				appl_region_code	= checkForNull(req.getParameter("appl_region_code"));	
				appl_postal_code	= checkForNull(req.getParameter("appl_postal_code"));
				appl_country_code	= checkForNull(req.getParameter("appl_country_code"));

				/*Added by Ashwini on 20-Nov-2017 for ML-MMOH-CRF-0707*/
				appl_contact_no1	= checkForNull(req.getParameter("self_contact_no1"));
				appl_contact_no2	= checkForNull(req.getParameter("self_contact_no2"));
				appl_email_id		= checkForNull(req.getParameter("self_appl_email_id"));
				/*ML-MMOH-CRF-0707*/
			}
			else if(relationship_type.equals("4"))//Others - OTH
			{
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

			String relationship	= checkForNull(req.getParameter("relationship"));
			String appl_type	= checkForNull(req.getParameter("appl_type"));
			String appl_no		= checkForNull(req.getParameter("appl_no"));
			String appl_name	= checkForNull(req.getParameter("appl_name"));
			
			if(appl_name !=null && appl_name.length()>80){
				appl_name=appl_name.substring(0,80);
			}
			

			String appl_refno	= checkForNull(req.getParameter("appl_refno"));
			String for_attn		= checkForNull(req.getParameter("for_attn"));
			String rep_type		= checkForNull(req.getParameter("rep_type"));
			String dept_spl		= checkForNull(req.getParameter("Splcode"));
			String appl_status	= checkForNull(req.getParameter("appl_status"));

			String appl_comp_dat= checkForNull(req.getParameter("appl_comp_dat"));
			
			String reqd_docs	= checkForNull(req.getParameter("reqd_docs"));
			String board_type	= checkForNull(req.getParameter("board_type"));

			cons_letter	= checkForNull(req.getParameter("cons_letter"));

			String addedById			= p.getProperty( "login_user" ) ;
			String addedDate			= dateFormat.format( new java.util.Date() ) ;
			String modifiedById			= addedById ;
			String modifiedDate			= addedDate ;
			String addedFacilityId		= facilityId;
			String modifiedFacilityId	= addedFacilityId ;
			String addedAtWorkstation	= client_ip_address;
			String modifiedAtWorkstation= addedAtWorkstation ;

			HashMap tableData = new HashMap();

			tableData.put("PATIENT_ID",patient_id); 
			tableData.put("PATIENT_NAME",patient_name); 
			tableData.put("PATIENT_LONG_NAME",patient_name_long);
			tableData.put("PATIENT_LONG_NAME_LOC_LANG",patient_name_loc_lang_long);
			tableData.put("REQUEST_STATUS",request_status);
			tableData.put("REQUEST_TYPE",request_type);
			tableData.put("REQUESTOR_CODE",Requestor_Code); 

			appln_date		=  checkForNull(req.getParameter("appln_date"));

			appln_date = DateUtils.convertDate(appln_date,"DMYHM",locale,"en");
			
			StringTokenizer appln_datetoks = new StringTokenizer (appln_date," ") ;
			StringTokenizer appln_datetok1 = new StringTokenizer (appln_datetoks.nextToken(), "/" ) ;
			String appln_dateArr[] =new String[3] ;
			StringBuffer sb_appln_date = new StringBuffer();
			for( int r=0;r<3;r++ )
				appln_dateArr[r] = appln_datetok1.nextToken() ;
			sb_appln_date.append(appln_dateArr[2]+"-");
			sb_appln_date.append(appln_dateArr[1]+"-");
			sb_appln_date.append(appln_dateArr[0]+" ");
			sb_appln_date.append(appln_datetoks.nextToken()+":00");
			appln_date = sb_appln_date.toString();

//			appln_date = appln_dateArr[2] +"-"+appln_dateArr[1]+"-"+ appln_dateArr[0]+" "+appln_datetoks.nextToken()+":00"   ;
			Timestamp appln_dateTimestamp= Timestamp.valueOf(appln_date);

			tableData.put("APPLICATION_DATE",appln_dateTimestamp);
			tableData.put("MED_BOARD_MEMBERS",MedicalMembers); 
			tableData.put("REQUESTING_PRACT_ID",practitioner_id); 
			tableData.put("PREPARE_TEAM_ID",team_id); 
			tableData.put("COLLECT_DATE",collect_date); 
			tableData.put("REMARKS",remarks); 
			tableData.put("RELATIONSHIP_TYPE",relationship_type); 
			tableData.put("RELATIONSHIP_CODE",relationship);
			tableData.put("APPL_TYPE_CODE",appl_type);
			tableData.put("APPL_NO",appl_no);
			tableData.put("APPLICATION_REF_NO",appl_refno);
			tableData.put("APPLICANT_NAME",appl_name);
			tableData.put("CONSENT_LETTER_APPL",cons_letter);
			tableData.put("FOR_ATTN_OF",for_attn);
			tableData.put("REPORT_TYPE_CODE",rep_type);
			tableData.put("SPECIALTY_CODE",dept_spl);
			tableData.put("APPL_STATUS",appl_status);
			tableData.put("APPL_COMPLETION_DATE",appl_comp_dat);
			tableData.put("REQUIRED_DOCS",reqd_docs);
			tableData.put("MED_BOARD_TYPE_CODE",board_type);

			// Other Details ...
			recp_dat		=  checkForNull(req.getParameter("recp_dat"));
			recp_dat = DateUtils.convertDate(recp_dat,"DMYHM",locale,"en");
			
			if(!recp_dat.equals(""))
			{
				StringTokenizer recp_dattoks = new StringTokenizer (recp_dat," ") ;
				StringTokenizer recp_dattok1 = new StringTokenizer (recp_dattoks.nextToken(), "/" ) ;
				String recp_datArr[] =new String[3] ;
				for( int r=0;r<3;r++ )
					recp_datArr[r] = recp_dattok1.nextToken() ;
				StringBuffer sb_recp_dat = new StringBuffer();
				sb_recp_dat.append(recp_datArr[2] +"-");
				sb_recp_dat.append(recp_datArr[1]+"-");
				sb_recp_dat.append(recp_datArr[0]+" ");
				sb_recp_dat.append(recp_dattoks.nextToken()+":00");
				recp_dat = sb_recp_dat.toString();
//				recp_dat = recp_datArr[2] +"-"+recp_datArr[1]+"-"+ recp_datArr[0]+" "+recp_dattoks.nextToken()+":00"   ;
				Timestamp recp_datTimestamp= Timestamp.valueOf(recp_dat);
				tableData.put("RECEIPT_DATE",recp_datTimestamp);
			}

			add_recp_dat		=  checkForNull(req.getParameter("add_recp_dat"));
			add_recp_dat = DateUtils.convertDate(add_recp_dat,"DMYHM",locale,"en");
			
			if (add_recp_dat != null && !add_recp_dat.equals(""))
			{
				StringTokenizer add_recp_dat_toks = new StringTokenizer (add_recp_dat," ") ;
				StringTokenizer add_recp_dat_tok1 = new StringTokenizer (add_recp_dat_toks.nextToken(), "/" ) ;
				String add_recp_dat_Arr[] =new String[3] ;
				for( int r=0;r<3;r++ )
				add_recp_dat_Arr[r] = add_recp_dat_tok1.nextToken() ;
				StringBuffer sb_add_recp_dat = new StringBuffer();
				sb_add_recp_dat.append(add_recp_dat_Arr[2] +"-");
				sb_add_recp_dat.append(add_recp_dat_Arr[1]+"-");
				sb_add_recp_dat.append(add_recp_dat_Arr[0]+" ");
				sb_add_recp_dat.append(add_recp_dat_toks.nextToken()+":00");
				add_recp_dat = sb_add_recp_dat.toString();
				//add_recp_dat = add_recp_dat_Arr[2] +"-"+add_recp_dat_Arr[1]+"-"+ add_recp_dat_Arr[0]+" "+add_recp_dat_toks.nextToken()+":00"   ;

				Timestamp add_recp_dat_Timestamp= Timestamp.valueOf(add_recp_dat);
				tableData.put("ADDL_RECEIPT_DATE",add_recp_dat_Timestamp);
			}

			charges_appllicable_yn = req.getParameter("charges_appllicable");
			if(charges_appllicable_yn.equals("") || charges_appllicable_yn == null )
				charges_appllicable_yn  = "N";
			tableData.put("CHARGES_APPL_YN",charges_appllicable_yn);

			additional_charges_yn = req.getParameter("additional_charges");
			if(additional_charges_yn.equals("") || additional_charges_yn == null )
				additional_charges_yn  = "N";
		   tableData.put("ADDL_CHARGES_YN",additional_charges_yn);
		   tableData.put("AMOUNT",checkForNull(req.getParameter("amount")));
		   tableData.put("SEC_FILE_NO",checkForNull(req.getParameter("file_no")));
		   tableData.put("RECEIPT_NO",checkForNull(req.getParameter("recp_no")));
		   tableData.put("ADDL_AMOUNT",checkForNull(req.getParameter("add_amount")));
		   tableData.put("ADDL_RECEIPT_NO",checkForNull(req.getParameter("add_recp_no")));
			tableData.put("APPL_ADDR_LINE1",appl_addr_line1);
			tableData.put("APPL_ADDR_LINE2",appl_addr_line2);
			tableData.put("APPL_ADDR_LINE3",appl_addr_line3);
			tableData.put("APPL_ADDR_LINE4",appl_addr_line4);
			tableData.put("APPL_TOWN_CODE",appl_town_code);
			tableData.put("APPL_AREA_CODE",appl_area_code);
			tableData.put("APPL_REGION_CODE",appl_region_code);
			tableData.put("APPL_POSTAL_CODE",appl_postal_code);
			tableData.put("APPL_COUNTRY_CODE",appl_country_code);
			
			/*Added by Ashwini on 20-Nov-2017 for ML-MMOH-CRF-0707*/
			tableData.put("contact_no1",appl_contact_no1);
			tableData.put("contact_no2",appl_contact_no2);
			tableData.put("appl_email_id",appl_email_id);
			/*ML-MMOH-CRF-0707*/

			tableData.put("ADDED_BY_ID",addedById); 
			tableData.put("ADDED_DATE",addedDate); 
			tableData.put("MODIFIED_BY_ID",modifiedById); 
			tableData.put("MODIFIED_DATE",modifiedDate); 
			tableData.put("ADDED_FACILITY_ID",addedFacilityId); 
			tableData.put("MODIFIED_FACILITY_ID",modifiedFacilityId); 
			tableData.put("ADDED_AT_WS_NO",addedAtWorkstation); 
			tableData.put("MODIFIED_AT_WS_NO",modifiedAtWorkstation); 
			tableData.put("FACILITY_ID",facilityId); 

			/*ADDED FOR PATIENT DETAILS COMPONENT*/

			/* DATE OF BIRTH VALIDATIONS */	
			String dateofbirth	= checkForNull(req.getParameter("date_of_birth"));
			
			if (dateofbirth != null && !dateofbirth.equals(""))
			{
				dateofbirth = dateofbirth.trim();
				StringTokenizer birth2 = new StringTokenizer(dateofbirth,"/");
				String DobArr[] =new String[3] ;
				for( int p=0;p<3;p++ )
				{        
					if(birth2.hasMoreTokens()) 
					{
						DobArr[p] = birth2.nextToken();
					}
				}
				StringBuffer sb_dateofbirth = new StringBuffer();
				sb_dateofbirth.append(DobArr[2]+"-");
				sb_dateofbirth.append(DobArr[1]+"-");
				sb_dateofbirth.append(DobArr[0]);
				dateofbirth = sb_dateofbirth.toString();
				//dateofbirth = DobArr[2] + "-" + DobArr[1] + "-" + DobArr[0];
					
				java.sql.Date DobDate = java.sql.Date.valueOf( dateofbirth ) ;
				tableData.put("DATE_OF_BIRTH",DobDate);
			}

			String alt_id1_exp_date = checkForNull(req.getParameter("alt_id1_exp_date"));
			
			if (alt_id1_exp_date != null && !alt_id1_exp_date.equals(""))
			{
				alt_id1_exp_date = alt_id1_exp_date.trim();
				StringTokenizer Alt1token = new StringTokenizer(alt_id1_exp_date,"/");
				String Alt1Arr[] =new String[3] ;
				for( int a=0;a<3;a++ )
				{        
					if(Alt1token.hasMoreTokens()) 
					{
					Alt1Arr[a] = Alt1token.nextToken();
					}
				}
				StringBuffer sb_alt_id1_exp_date = new StringBuffer();
				sb_alt_id1_exp_date.append(Alt1Arr[2]+"-");
				sb_alt_id1_exp_date.append(Alt1Arr[1]+"-");
				sb_alt_id1_exp_date.append(Alt1Arr[0]);

				alt_id1_exp_date = sb_alt_id1_exp_date.toString();

				//alt_id1_exp_date = Alt1Arr[2] + "-" + Alt1Arr[1] + "-" + Alt1Arr[0];
				java.sql.Date alt_id1_date = java.sql.Date.valueOf( alt_id1_exp_date ) ;
				tableData.put("ALT_ID1_EXP_DATE",alt_id1_date);
			}

			String alt_id2_exp_date = checkForNull(req.getParameter("alt_id2_exp_date"));
			
			if (alt_id2_exp_date != null && !alt_id2_exp_date.equals(""))
			{
				alt_id2_exp_date = alt_id2_exp_date.trim();
				StringTokenizer Alt2token = new StringTokenizer(alt_id2_exp_date,"/");
				String Alt2Arr[] =new String[3] ;
				for( int b=0;b<3;b++ )
				{        
					if(Alt2token.hasMoreTokens()) 
					{
					Alt2Arr[b] = Alt2token.nextToken();
					}
				}
				StringBuffer sb_alt_id2_exp_date = new StringBuffer();
				sb_alt_id2_exp_date.append(Alt2Arr[2]+"-");
				sb_alt_id2_exp_date.append(Alt2Arr[1]+"-");
				sb_alt_id2_exp_date.append(Alt2Arr[0]);

				alt_id2_exp_date = sb_alt_id2_exp_date.toString();

				//alt_id2_exp_date = Alt2Arr[2] + "-" + Alt2Arr[1] + "-" + Alt2Arr[0];
				java.sql.Date alt_id2_date = java.sql.Date.valueOf( alt_id2_exp_date ) ;
				tableData.put("ALT_ID2_EXP_DATE",alt_id2_date);
			}

			String alt_id3_exp_date = checkForNull(req.getParameter("alt_id3_exp_date"));
			
			if (alt_id3_exp_date != null && !alt_id3_exp_date.equals(""))
			{
				alt_id3_exp_date = alt_id3_exp_date.trim();
				StringTokenizer Alt3token = new StringTokenizer(alt_id3_exp_date,"/");
				String Alt3Arr[] =new String[3] ;
				for( int c=0;c<3;c++ )
				{        
					if(Alt3token.hasMoreTokens()) 
					{
						Alt3Arr[c] = Alt3token.nextToken();
					}
				}
				StringBuffer sb_alt_id3_exp_date = new StringBuffer();
				sb_alt_id3_exp_date.append(Alt3Arr[2]+"-");
				sb_alt_id3_exp_date.append(Alt3Arr[1]+"-");
				sb_alt_id3_exp_date.append(Alt3Arr[0]);

				alt_id3_exp_date = sb_alt_id3_exp_date.toString();

				//alt_id3_exp_date = Alt3Arr[2] + "-" + Alt3Arr[1] + "-" + Alt3Arr[0];
				java.sql.Date alt_id3_date = java.sql.Date.valueOf( alt_id3_exp_date ) ;
				tableData.put("ALT_ID3_EXP_DATE",alt_id3_date);
			}

			String alt_id4_exp_date = checkForNull(req.getParameter("alt_id4_exp_date"));
			
			if (alt_id4_exp_date != null && !alt_id4_exp_date.equals(""))
			{
				alt_id4_exp_date = alt_id4_exp_date.trim();
				StringTokenizer Alt4token = new StringTokenizer(alt_id4_exp_date,"/");
				String Alt4Arr[] =new String[3] ;
				for( int d=0;d<3;d++ )
				{        
					if(Alt4token.hasMoreTokens()) 
					{
						Alt4Arr[d] = Alt4token.nextToken();
					}
				}
				StringBuffer sb_alt_id4_exp_date = new StringBuffer();
				sb_alt_id4_exp_date.append(Alt4Arr[2]+"-");
				sb_alt_id4_exp_date.append(Alt4Arr[1]+"-");
				sb_alt_id4_exp_date.append(Alt4Arr[0]);

				alt_id4_exp_date = sb_alt_id4_exp_date.toString();

				//alt_id4_exp_date = Alt4Arr[2] + "-" + Alt4Arr[1] + "-" + Alt4Arr[0];
				java.sql.Date alt_id4_date = java.sql.Date.valueOf( alt_id4_exp_date ) ;
				tableData.put("ALT_ID4_EXP_DATE",alt_id4_date);
			}

			tableData.put("NATIONAL_ID_NO",checkForNull(req.getParameter("national_id_no")));
			tableData.put("BIRTH_PLACE_CODE",checkForNull(req.getParameter("Birth_place_code")));
		    tableData.put("BIRTH_PLACE_DESC",checkForNull(req.getParameter("birth_place")));
			tableData.put("GENDER",checkForNull(req.getParameter("sex")));
		    tableData.put("CITIZEN_YN",checkForNull(req.getParameter("citizen_yn"),"N"));
		    tableData.put("LEGAL_ILLEGAL_YN",checkForNull(req.getParameter("legal_yn"),"N"));
		    tableData.put("NATIONALITY_CODE",checkForNull(req.getParameter("nationality_code1")));
		    tableData.put("ETHNIC_GRP_CODE",checkForNull(req.getParameter("ethnic_group")));
			tableData.put("RACE_CODE",checkForNull(req.getParameter("race_code")));
			tableData.put("ALT_ID1_NO",checkForNull(req.getParameter("alt_id1_no")));
			tableData.put("ALT_ID2_NO",checkForNull(req.getParameter("alt_id2_no")));
			tableData.put("ALT_ID3_NO",checkForNull(req.getParameter("alt_id3_no")));
			tableData.put("ALT_ID4_NO",checkForNull(req.getParameter("alt_id4_no")));
			tableData.put("ALT_ID1_TYPE",checkForNull(req.getParameter("alt_id1_type")));
			tableData.put("ALT_ID2_TYPE",checkForNull(req.getParameter("alt_id2_type")));
			tableData.put("ALT_ID3_TYPE",checkForNull(req.getParameter("alt_id3_type")));
			tableData.put("ALT_ID4_TYPE",checkForNull(req.getParameter("alt_id4_type")));
			tableData.put("OTH_ALT_ID_TYPE",checkForNull(req.getParameter("other_alt_type")));
			tableData.put("OTH_ALT_ID_NO",checkForNull(req.getParameter("other_alt_Id")));
			tableData.put("NAME_PREFIX",checkForNull(req.getParameter("name_prefix1")));
			tableData.put("FIRST_NAME",checkForNull(req.getParameter("first_name")));
			tableData.put("SECOND_NAME",checkForNull(req.getParameter("second_name")));
			tableData.put("THIRD_NAME",checkForNull(req.getParameter("third_name")));
			tableData.put("FAMILY_NAME",checkForNull(req.getParameter("family_name")));
			tableData.put("NAME_SUFFIX",checkForNull(req.getParameter("name_suffix1")));
			tableData.put("NAME_PREFIX_LOC_LANG",checkForNull(req.getParameter("name_prefix_oth_lang")));
			tableData.put("FIRST_NAME_LOC_LANG",checkForNull(req.getParameter("first_name_oth_lang")));
			tableData.put("SECOND_NAME_LOC_LANG",checkForNull(req.getParameter("second_name_oth_lang")));
			tableData.put("THIRD_NAME_LOC_LANG",checkForNull(req.getParameter("third_name_oth_lang")));
			tableData.put("FAMILY_NAME_LOC_LANG",checkForNull(req.getParameter("family_name_oth_lang")));
			tableData.put("NAME_SUFFIX_LOC_LANG",checkForNull(req.getParameter("name_suffix_oth_lang")));
			tableData.put("PATIENT_NAME_LOC_LANG",patient_name_local_lang);
			tableData.put("RES_ADDR_LINE1",checkForNull(req.getParameter("addr_line1")));
			tableData.put("RES_ADDR_LINE2",checkForNull(req.getParameter("addr_line2")));
			tableData.put("RES_ADDR_LINE3",checkForNull(req.getParameter("addr_line3")));
			tableData.put("RES_ADDR_LINE4",checkForNull(req.getParameter("addr_line4")));
			tableData.put("RES_TOWN_CODE",checkForNull(req.getParameter("res_town_code")));
			tableData.put("RES_AREA_CODE",checkForNull(req.getParameter("res_area_code")));
			tableData.put("RES_REGION_CODE",checkForNull(req.getParameter("region_code")));
			tableData.put("RES_POSTAL_CODE",checkForNull(req.getParameter("postal_code")));
			tableData.put("RES_COUNTRY_CODE",checkForNull(req.getParameter("country_code")));
			tableData.put("MAIL_ADDR_LINE1",checkForNull(req.getParameter("mail_addr_line1")));
			tableData.put("MAIL_ADDR_LINE2",checkForNull(req.getParameter("mail_addr_line2")));
			tableData.put("MAIL_ADDR_LINE3",checkForNull(req.getParameter("mail_addr_line3")));
			tableData.put("MAIL_ADDR_LINE4",checkForNull(req.getParameter("mail_addr_line4")));
			tableData.put("MAIL_TOWN_CODE",checkForNull(req.getParameter("mail_res_town_code")));
			tableData.put("MAIL_AREA_CODE",checkForNull(req.getParameter("mail_res_area_code")));
			tableData.put("MAIL_REGION_CODE",checkForNull(req.getParameter("mail_region_code")));
			tableData.put("MAIL_POSTAL_CODE",checkForNull(req.getParameter("mail_postal_code")));
			tableData.put("MAIL_COUNTRY_CODE",checkForNull(req.getParameter("mail_country_code")));
			tableData.put("RES_TEL_NO",checkForNull(req.getParameter("contact1_no")));
			tableData.put("OTH_CONTACT_NO",checkForNull(req.getParameter("contact2_no")));
			tableData.put("EMAIL_ID",checkForNull(req.getParameter("email")));
			tableData.put("FACILITY_ID",facilityId);
			tableData.put("REQUEST_ID",req_id+"");
			/*Added by Thamizh selvi on 6th Feb 2018 against ML-MMOH-CRF-0601 Start*/
			tableData.put("alt_addr_line1",checkForNull(req.getParameter("alt_addr_line1")));
			tableData.put("alt_addr_line2",checkForNull(req.getParameter("alt_addr_line2")));
			tableData.put("alt_addr_line3",checkForNull(req.getParameter("alt_addr_line3")));
			tableData.put("alt_addr_line4",checkForNull(req.getParameter("alt_addr_line4")));
			tableData.put("alt_town_code",checkForNull(req.getParameter("alt_town_code")));
			tableData.put("alt_area_code",checkForNull(req.getParameter("alt_area_code")));
			tableData.put("alt_region_code",checkForNull(req.getParameter("alt_region_code")));
			tableData.put("alt_postal_code",checkForNull(req.getParameter("alt_postal_code")));
			tableData.put("alt_country_code",checkForNull(req.getParameter("alt_country_code")));
			/*End*/
			
			
			String dupflds[]={"REQUEST_ID","FACILITY_ID"};

			String tableName = "MR_REPORT_REQUEST_HDR";
			boolean local_ejbs = false;

			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tableData;
			argArray[2] = dupflds;
			argArray[3] = tableName;

			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass();
			paramArray[1] = tableData.getClass();
			paramArray[2] = dupflds.getClass();
			paramArray[3] = tableName.getClass();

			HashMap results = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			boolean inserted	= ( ((Boolean) results.get( "status" )).booleanValue() ) ;

			String error = (String) results.get("error") ;
			if (inserted)
			{
				java.util.Hashtable message=MessageManager.getMessage(locale,"RECORD_MODIFIED","SM");
				error = (String) message.get("message") ;
				//error= error.substring(0,error.indexOf("<br>")) ;
				error = error+ " with REQUEST ID : "+req_id+" ";
				
				
				

				if(cons_letter.equals("0")) // if Available
				{
					out.println("<script>alert('"+error+"');</script>");
					doOnlineReports(patient_id, Request_id, cons_letter);
				}
				else
				{
				//out.println("<script>parent.parent.frames(2).location.href='../eMR/jsp/MedicalBoard.jsp?module_id=MR&function_id=MEDICAL_BOARD_REQUEST&function_name="+java.net.URLEncoder.encode("getLabel('eMR.RequestforMedicalBoard.label','MR')","UTF-8")+"&function_type=F&access=NYNNN';</script>");
				//out.println("<script>parent.parent.frames(2).location.href='../eMR/jsp/MedicalBoard.jsp?module_id=MR&function_id=MEDICAL_BOARD_REQUEST&function_name="+java.net.URLEncoder.encode("getLabel('eMR.RequestforMedicalBoard.label','MR')","UTF-8")+"&function_type=F&access=NYNNN';</script>");	
				
				out.println("<html><head><script language=JavaScript src='../../eCommon/js/common.js'></script></head><BODY CLASS='MESSAGE'>");
				
				out.println("<script>alert('"+error+"');</script>");
				out.println("<script>parent.parent.frames[2].onLocalSuccess();</script></BODY></html>");
				}
				
				if ( message != null ) message.clear();
			}
			else
			{
				
				error = (String) results.get("error") ;
				//error = "Errors Encountered...";
				//error= error.substring(0,error.indexOf("<br>")) ;
				out.println("<script>alert(\""+error+"\");</script>") ;				
			}
			if ( tableData != null) tableData.clear();
			if ( results != null) results.clear();
		}
	}catch ( Exception e ) 
	{
        out.println("Exception in insertMedicalRequest : "+e.toString());
        out.println(" <br> error_msg : "+error_msg);
		e.printStackTrace();
    }
	finally
	{
		if ( error_msg != null) error_msg.clear();
		if(con != null)	ConnectionManager.returnConnection(con,req);
	}
}

///Added by Sridhar R for online report generation from Medical Board Request Functions...
private void doOnlineReports(String patient_Id, String request_ID,String consent_letter) throws ServletException, IOException, SQLException
{
	String facilityId	= (String) session.getValue( "facility_id" ) ;
	String sqlString	= "";		
	String reportParamNames	= "";
	String reportParamValues= "";

	try
	{
		//MRBMRCFR - Consent Form for Medical Report Request
		if(consent_letter.equals("0")) // if Available
		{
			sqlString = " SELECT report_id, report_desc, 1 no_of_copies, module_id FROM sm_report WHERE  module_id = 'MR' AND report_id = 'MRBMRCFR'";
		}

		reportParamNames = "p_patient_id,p_request_id,p_facility_id";
		reportParamValues = ""+patient_Id+","+request_ID+","+facilityId+"";

		StringBuffer htmlFor = new StringBuffer();
		htmlFor.append(" <html><head> <link rel='stylesheet' type ='text/css' href='../eCommon/html/"+sStyle+"'></link>");
		htmlFor.append("</head><body class	='message'>");
		htmlFor.append( "<script language	= 'JavaScript'>");
		htmlFor.append("  var dialogHeight	= '25';");
		htmlFor.append("  var dialogWidth	= '65';");
		htmlFor.append("  var dialogTop		= '58';");
		htmlFor.append("  var arguments		=	'';");
		// modified the below line by Abirami - Bru-HIMS-CRF-313 / Passing function id in the below Query String.
		htmlFor.append("  var getUrl		=	'../eCommon/jsp/InternalReportsPrint.jsp?P_function_id=MEDICAL_BOARD_REQUEST&step=1&sqlString="+java.net.URLEncoder.encode(sqlString)+"&reportParamNames="+reportParamNames+"&reportParamValues="+reportParamValues+"';");
		htmlFor.append("var features = 'dialogHeight:'+dialogHeight+'; dialogWidth:'+dialogWidth+'; status=no;' ;");
		htmlFor.append( "retVal = window.showModalDialog(getUrl,arguments,features); parent.window.close();");
		htmlFor.append(" </script>");
		out.println(htmlFor.toString());
		out.println("</body></html>");
	}catch ( Exception e )
	{
		out.println("Encountered error while Processing Online Reports "+e.toString());
	}
}


	private String checkForNull(String inputString)
	{
		return (inputString==null) ? "" : inputString;
	}

	private String checkForNull(String inputString, String defaultValue)
	{
		return (inputString==null)	?	defaultValue	:	inputString;
	}

}
