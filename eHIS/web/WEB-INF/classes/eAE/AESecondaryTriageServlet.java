/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eAE ;

import java.sql.* ;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.naming.*;
import javax.rmi.*;
import eAE.SecondaryTriage.*;
import webbeans.eCommon.*;
import com.ehis.util.*;
import eCommon.XSSRequestWrapper;

public class AESecondaryTriageServlet extends HttpServlet implements SingleThreadModel
{
    PrintWriter out;
    java.util.Properties p 		= null;

    java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;
	String user_id;
	String facilityId;
	String client_ip_address;
	String error = "";
	String newEncounterID="";
	String called_from_ca;
	String locale="";
	String locale1="";
	String encounter="";

    HttpSession session = null ;
	public void init(ServletConfig config) throws ServletException
    {
         super.init(config);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
    {
	   req.setCharacterEncoding("UTF-8");
       res.setContentType("text/html;charset=UTF-8");
	   req = new XSSRequestWrapper(req);
	   res.addHeader("X-XSS-Protection", "1; mode=block");
	   res.addHeader("X-Content-Type-Options", "nosniff");
	   
       session           	=	req.getSession(false) ;

       out               	= res.getWriter() ;
	   Connection	con			=	null;
	   PreparedStatement pstmt		= null;
	   ResultSet  rs				= null;

       try
       {
		   con = ConnectionManager.getConnection(req);
			int count_enc=0;
			user_id	= (String)session.getValue("login_user")==null?"":(String)session.getValue("login_user") ;
			encounter = req.getParameter("encounter_id")==null?"":req.getParameter("encounter_id");
			this.facilityId = (String) session.getValue( "facility_id" )==null?"":(String) session.getValue( "facility_id" );
			p					=	(Properties)session.getValue("jdbc") ;
			locale			    =   p.getProperty("LOCALE");
			locale1			    =   p.getProperty("LOCALE");
			this.client_ip_address = (p.getProperty("client_ip_address"))==null?"":(p.getProperty("client_ip_address"));
			pstmt = con.prepareStatement("select count(*) from ae_current_patient where encounter_id='"+encounter+"' and facility_id='"+facilityId+"'");
			rs = pstmt.executeQuery();
			while(rs!=null && rs.next()) {
			count_enc =rs.getInt(1);
			}if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();

			if (count_enc>0)
			{
				insertSecondaryTriage(req);
			}else
		   {

					MessageManager mm = new MessageManager();
					final java.util.Hashtable mesg = mm.getMessage(locale, "AE_CHECKED_OUT", "AE") ;
					String msg = ((String) mesg.get("message"));
					out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link></head><body class='MESSAGE'>"+msg+"</body></html>");
					mesg.clear();
			}

		}
        catch(Exception e)
        {
           e.printStackTrace();
        }
		finally {
			if(con!=null)	ConnectionManager.returnConnection(con,req);
		} // end
    } // Do post method ending here

// InsertRegisterAttendance method starts here
private void insertSecondaryTriage(HttpServletRequest req) throws ServletException,IOException{
try
{		HashMap session_details = new HashMap();
		session_details.put("user_id",user_id);
		session_details.put("locale",locale);
		session_details.put("facility_id",facilityId);
		session_details.put("addedAtWorkstation",client_ip_address);
		String patient_id = req.getParameter("patient_id")==null?"":req.getParameter("patient_id");
		String encounter_id = req.getParameter("encounter_id")==null?"":req.getParameter("encounter_id");
		session_details.put("patient_id",patient_id);
		session_details.put("encounter_id",encounter_id);
		String addedById = (String)session.getValue("login_user") ;
		session_details.put("added_by_id",addedById);
		String addedDate   = dateFormat.format( new java.util.Date() ) ;
		java.sql.Date added_date = java.sql.Date.valueOf( addedDate ) ;
		session_details.put("added_date",added_date);
		session_details.put("added_facility_id", facilityId);
		session_details.put("added_at_ws_no",client_ip_address);
		session_details.put("modified_by_id",addedById);
		session_details.put("modified_date",added_date);
		session_details.put("modified_facility_id",facilityId);
		session_details.put("modified_at_ws_no",client_ip_address );
		HashMap ae_pr_encounter_add=new HashMap();
        called_from_ca = req.getParameter("called_from_ca")==null?"N":req.getParameter("called_from_ca");
		ae_pr_encounter_add.put("ambulatory_status",req.getParameter("ambulatory_status")== null ?"":req.getParameter("ambulatory_status"));
		HashMap ae_pr_encounter_oth_dtls=new HashMap();
		ae_pr_encounter_oth_dtls.put("encounter_type","E");
		HashMap ae_pat_emergency_dtls=new HashMap();
		
		/*Added by Thamizh selvi on 16th Mar 2018 against ML-MM0H-CRF-645 Start*/
		String isCaseDtlsRadioBtnAppl	= checkForNull(req.getParameter("isCaseDtlsRadioBtnAppl"));
		String osccType					= checkForNull(req.getParameter("osccType"));
		String osccYn					= checkNullWithDftValue(req.getParameter("oscc_yn"), "N");
		String OandGYn					= checkNullWithDftValue(req.getParameter("OandG_yn"), "N");
		
		String mechInjCode				= "";
		String mechInjSubCode			= "";
		
		if(!("").equals(osccType)){
			StringTokenizer osccToken = new StringTokenizer(osccType, ",");
			if(osccToken.hasMoreTokens()){
				mechInjCode		= checkForNull(osccToken.nextToken());
				mechInjSubCode	= checkForNull(osccToken.nextToken());
			}
		}
		
		if(isCaseDtlsRadioBtnAppl.equals("true") && osccYn.equals("Y")){
			ae_pat_emergency_dtls.put("mech_injury_catg_code",mechInjCode);
			ae_pat_emergency_dtls.put("mech_injury_subcatg_code",mechInjSubCode);
		}else{
			ae_pat_emergency_dtls.put("mech_injury_catg_code",req.getParameter("mechan_injury")== null ?"":req.getParameter("mechan_injury"));
			ae_pat_emergency_dtls.put("mech_injury_subcatg_code",req.getParameter("injury")== null ?"":req.getParameter("injury"));
		}

		ae_pat_emergency_dtls.put("OandGYn",OandGYn);
		/*End*/
		
		String enable_rights_yn=req.getParameter("enable_rights_yn")==null?"":req.getParameter("enable_rights_yn");
		String sel_triage_yn=req.getParameter("sel_triage_yn")==null?"":req.getParameter("sel_triage_yn");
		String sel_cons_yn=req.getParameter("sel_cons_yn")==null?"":req.getParameter("sel_cons_yn");

    	String rec_date_time = req.getParameter("rec_date_time")==null?"":req.getParameter("rec_date_time");
		String sys_date_time = req.getParameter("sys_date_time")==null?"":req.getParameter("sys_date_time");

		/*--Added by K V Shanmukh on 4th-Apr-2018 against ML-MMOH-CRF-0656 Start-->*/
		String isSecTrgBackDateTimeAppl	= checkForNull(req.getParameter("isSecTrgBackDateTimeAppl"));
		String record_date_time=checkForNull(req.getParameter("triage_record_date_time"));
		
		if(record_date_time.equals(""))
			record_date_time=sys_date_time;
		/*END*/
		String modify_flag = req.getParameter("modify_flag")==null?"":req.getParameter("modify_flag");
		String disaster_yn = req.getParameter("Disaster_YN")==null?"N":req.getParameter("Disaster_YN");
        String clinic_code = req.getParameter("clinic_code")==null?"":req.getParameter("clinic_code");
        String referral_id = req.getParameter("referral_id")==null?"":req.getParameter("referral_id");
		String fbc_yn=req.getParameter("fbc_yn")== null ?"":req.getParameter("fbc_yn");
		String lmpdate=req.getParameter("lmp_date") != null ? req.getParameter("lmp_date") : "";
		String lmp_date1=req.getParameter("lmpdate2") != null ? req.getParameter("lmpdate2") : "";
		
		if(lmpdate.equals("") || lmpdate.equals(null)){
			lmpdate	= lmp_date1;
		}

		lmpdate=DateUtils.convertDate(lmpdate,"DMY",locale,"en");
		String date_time_accident =req.getParameter("date_time_accident") != null ? req.getParameter("date_time_accident") : "";
		date_time_accident=DateUtils.convertDate(date_time_accident,"DMYHM",locale,"en");
        ae_pat_emergency_dtls.put("date_time_accident",date_time_accident);
        ae_pat_emergency_dtls.put("place_of_accident",req.getParameter("place_of_accident")== null ?"":req.getParameter("place_of_accident"));
		ae_pat_emergency_dtls.put("episode_id",req.getParameter("episode_id")== null ?"":req.getParameter("episode_id"));
		ae_pat_emergency_dtls.put("visit_num",req.getParameter("visit_num")== null ?"":req.getParameter("visit_num"));
		ae_pat_emergency_dtls.put("sys_date_time",sys_date_time);
		ae_pat_emergency_dtls.put("record_date_time",record_date_time); //Added for ML-MMOH-CRF-0656 by Shanmukh
        ae_pat_emergency_dtls.put("isSecTrgBackDateTimeAppl",isSecTrgBackDateTimeAppl);//Added for ML-MMOH-CRF-0656 by Shanmukh
		ae_pat_emergency_dtls.put("rec_date_time",rec_date_time);
        ae_pat_emergency_dtls.put("modify_flag",modify_flag);
		ae_pat_emergency_dtls.put("ae_encounter_type","E");
		ae_pat_emergency_dtls.put("complaint_code",req.getParameter("complaint_code")== null ?"":req.getParameter("complaint_code"));
		ae_pat_emergency_dtls.put("disaster_yn",disaster_yn);
		ae_pat_emergency_dtls.put("dis_regn_reference",req.getParameter("Disaster_Reference")== null ?"":req.getParameter("Disaster_Reference"));
		ae_pat_emergency_dtls.put("disaster_town_code",req.getParameter("disaster_area")== null ?"":req.getParameter("disaster_area"));
		ae_pat_emergency_dtls.put("disaster_type_code",req.getParameter("disaster_type")== null ?"":req.getParameter("disaster_type"));
		ae_pat_emergency_dtls.put("disaster_category_code",req.getParameter("disaster_category")== null ?"":req.getParameter("disaster_category"));//Added by Ajay Hatwate for ML-MMOH-CRf-2111
		ae_pat_emergency_dtls.put("medical_yn",req.getParameter("medical_yn")== null ?"N":req.getParameter("medical_yn"));
		ae_pat_emergency_dtls.put("surgical_yn",req.getParameter("surgical_yn")== null ?"N":req.getParameter("surgical_yn"));
		ae_pat_emergency_dtls.put("triage_remarks",req.getParameter("triage_remarks")== null ?"":req.getParameter("triage_remarks"));
		//ae_pat_emergency_dtls.put("mech_injury_catg_code",req.getParameter("mechan_injury")== null ?"":req.getParameter("mechan_injury"));
		//ae_pat_emergency_dtls.put("mech_injury_subcatg_code",req.getParameter("injury")== null ?"":req.getParameter("injury"));
		ae_pat_emergency_dtls.put("vehicle_involved1_code",req.getParameter("vehicle_invol")== null ?"":req.getParameter("vehicle_invol"));
		ae_pat_emergency_dtls.put("vehicle_involved2_code",req.getParameter("vehicle_invol1")== null ?"":req.getParameter("vehicle_invol1"));

		//Added by Ashwini on 04-Apr-2017 for GDOH-CFR-0004.3

		ae_pat_emergency_dtls.put("Vehicle_Reg_No1",req.getParameter("Vehicle_Reg_No1")== null ?"":req.getParameter("Vehicle_Reg_No1"));
		
		/*Added by Thamizh selvi on 12th Apr 2018 against ML-MMOH-CRF-0651 Start*/
		ae_pat_emergency_dtls.put("intialMgmtOthers",checkForNull(req.getParameter("initial_mgmt_others")));
		ae_pat_emergency_dtls.put("medication",checkForNull(req.getParameter("medication")));
		/*End*/

		ae_pat_emergency_dtls.put("Vehicle_Reg_No2",req.getParameter("Vehicle_Reg_No2")== null ?"":req.getParameter("Vehicle_Reg_No2"));
		ae_pat_emergency_dtls.put("protective_device_code",req.getParameter("protective_device")== null ?"":req.getParameter("protective_device"));
		ae_pat_emergency_dtls.put("pat_position_code",req.getParameter("affected_site")== null ?"":req.getParameter("affected_site"));
		ae_pat_emergency_dtls.put("oscc_yn",req.getParameter("oscc_yn")== null ?"N":req.getParameter("oscc_yn"));
		ae_pat_emergency_dtls.put("mlc_case_yn",req.getParameter("mlc_case_yn")== null ?"N":req.getParameter("mlc_case_yn"));
		ae_pat_emergency_dtls.put("police_report_no",req.getParameter("police_rep_no1")== null ?"":req.getParameter("police_rep_no1"));
		ae_pat_emergency_dtls.put("police_stat_detail",req.getParameter("police_stat_detail")== null ?"":req.getParameter("police_stat_detail"));
		//Added by Ajay Hatwate for GHL-CRF-0650	
		ae_pat_emergency_dtls.put("mlc_death",req.getParameter("mlc_death")== null ?"N":req.getParameter("mlc_death"));
		ae_pat_emergency_dtls.put("outside_mlc_dtls",req.getParameter("outside_mlc_dtls")== null ?"":req.getParameter("outside_mlc_dtls"));
		ae_pat_emergency_dtls.put("date_of_mlc_capture",req.getParameter("date_of_mlc_capture")== null ?"":req.getParameter("date_of_mlc_capture"));
		ae_pat_emergency_dtls.put("mlc_remarks",req.getParameter("mlc_remarks")== null ?"":req.getParameter("mlc_remarks"));
		ae_pat_emergency_dtls.put("isMLCAppl",req.getParameter("isMLCAppl")== null ?"false":req.getParameter("isMLCAppl"));
		ae_pat_emergency_dtls.put("pregnant_yn",req.getParameter("pregnant_at_present_yn_val")== null ?"N":req.getParameter("pregnant_at_present_yn_val"));
		ae_pat_emergency_dtls.put("lmp_date",lmpdate);
		ae_pat_emergency_dtls.put("immunization_status",req.getParameter("immunization_stat")== null ?"":req.getParameter("immunization_stat"));
		ae_pat_emergency_dtls.put("att_given_yn",req.getParameter("att_given")== null ?"N":req.getParameter("att_given"));
		ae_pat_emergency_dtls.put("devp_milestone_age_yn",req.getParameter("growth_age")== null ?"N":req.getParameter("growth_age"));
		ae_pat_emergency_dtls.put("im_upto_date_yn",req.getParameter("immun_date")== null ?"N":req.getParameter("immun_date"));
		ae_pat_emergency_dtls.put("menarche_yn",req.getParameter("menarche")== null ?"N":req.getParameter("menarche"));
		ae_pat_emergency_dtls.put("height",req.getParameter("height")== null ?"":req.getParameter("height"));
		ae_pat_emergency_dtls.put("weight",req.getParameter("weight")== null ?"":req.getParameter("weight"));
		ae_pat_emergency_dtls.put("circumference",req.getParameter("circumference")== null ?"":req.getParameter("circumference"));
		ae_pat_emergency_dtls.put("immobilization_code",req.getParameter("immobilization")== null ?"":req.getParameter("immobilization"));
		ae_pat_emergency_dtls.put("priority11",req.getParameter("priority11")== null ?"":req.getParameter("priority11"));
		ae_pat_emergency_dtls.put("CaseofTrauma_val",req.getParameter("CaseofTrauma_val")== null ?"N":req.getParameter("CaseofTrauma_val"));
		ae_pat_emergency_dtls.put("order_catalog_code3",req.getParameter("fbc")== null ?"":req.getParameter("fbc"));
		String practitioner_id =req.getParameter("practitioner_id")==null?"":req.getParameter("practitioner_id");
	   	ae_pat_emergency_dtls.put("practitioner_id",req.getParameter("practitioner_id")== null ?"":req.getParameter("practitioner_id"));
		ae_pat_emergency_dtls.put("order_id",req.getParameter("order_id")== null ?"":req.getParameter("order_id"));
		ae_pat_emergency_dtls.put("clinic_code",clinic_code);
		ae_pat_emergency_dtls.put("referral_id",referral_id);
		ae_pat_emergency_dtls.put("fbc_yn",fbc_yn);
		HashMap ae_pat_triage=new HashMap();
		String priority_code = req.getParameter("hddpriority")==null?"Y":req.getParameter("hddpriority");
		String brought_dead =  ((req.getParameter("brought_dead")==null) || (req.getParameter("brought_dead").equals("null")))?"N":req.getParameter("brought_dead");
		String treatment_area_code = req.getParameter("treat_area")==null?"":req.getParameter("treat_area");
		String bed_bay_no =req.getParameter("bed_bay_no")==null?"":req.getParameter("bed_bay_no");
		referral_id =req.getParameter("referral_id")==null?"":req.getParameter("referral_id");
		
		/*Below line added for this CRF AAKH-CRF-0010 [IN038535]*/
		if(treatment_area_code.contains("$$"))treatment_area_code=treatment_area_code.substring(0,treatment_area_code.indexOf("$$"));
				
		String fivelevelapplyn=req.getParameter("five_level_triage_appl_yn")==null?"N":req.getParameter("five_level_triage_appl_yn");		
		ae_pat_triage.put("fivelevelapplyn",fivelevelapplyn);
		String attend_pract_id=req.getParameter("attend_pract_id")==null?"":req.getParameter("attend_pract_id");
		ae_pat_triage.put("attend_pract_id",attend_pract_id);		
		//End AAKH-CRF-0010 [IN038535]
		
		//Below line added for this CRF ML-MMOH-CRF-0654
		String transport_mode=req.getParameter("transport_mode")==null?"":req.getParameter("transport_mode");
		String mode_of_arrival=req.getParameter("mode_of_arrival")==null?"":req.getParameter("mode_of_arrival");
		String accompany_by=req.getParameter("accompany_by")==null?"":req.getParameter("accompany_by");
		ae_pat_emergency_dtls.put("transport_mode",transport_mode);
		ae_pat_emergency_dtls.put("mode_of_arrival",mode_of_arrival);
		ae_pat_emergency_dtls.put("accompany_by",accompany_by);	
		//End ML-MMOH-CRF-0654
		
		ae_pat_emergency_dtls.put("case_type", req.getParameter("case_type")==null?"":req.getParameter("case_type"));

		//Added by Ajay Hatwate for ML-MMOH-CRF-2069
		ae_pat_emergency_dtls.put("queue_no", req.getParameter("queue_no")==null?"":req.getParameter("queue_no"));
		ae_pat_emergency_dtls.put("isSecondaryTriageQueueNum", req.getParameter("isSecondaryTriageQueueNum")==null?"":req.getParameter("isSecondaryTriageQueueNum"));
		ae_pat_emergency_dtls.put("queue_appl_priority_zone", req.getParameter("queue_appl_priority_zone")==null?"":req.getParameter("queue_appl_priority_zone"));
		//End of ML-MMOH-CRF-2069
		
		ae_pat_triage.put("priority_code",priority_code);
		ae_pat_triage.put("brought_dead",brought_dead);
		ae_pat_triage.put("treatment_area_code",treatment_area_code);
		ae_pat_triage.put("bed_bay_no",bed_bay_no);
		ae_pat_triage.put("clinic_code",clinic_code);
		ae_pat_triage.put("referral_id",referral_id);

    	boolean local_ejbs = false;
		if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SecondaryTriage",SecondaryTriageHome.class,local_ejbs);
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		Object argArray[] = new Object[6];
		argArray[0] = p;
		argArray[1] = ae_pr_encounter_add;
		argArray[2] = ae_pr_encounter_oth_dtls;
		argArray[3] = ae_pat_emergency_dtls;
		argArray[4] = ae_pat_triage;
		argArray[5] = session_details;
		Class [] paramArray = new Class[6];
		paramArray[0] = p.getClass();
		paramArray[1] = ae_pr_encounter_add.getClass();
		paramArray[2] = ae_pr_encounter_oth_dtls.getClass();
		paramArray[3] = ae_pat_emergency_dtls.getClass();
		paramArray[4] = ae_pat_triage.getClass();
		paramArray[5] = session_details.getClass();
		java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insertSecondaryTriage",paramArray)).invoke(busObj,argArray);
		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
		boolean inserted=false;
        inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
		error = (String) results.get("error") ;
		if (error==null)
		{	error="";
		}
		if (newEncounterID==null)
		{	newEncounterID="";
		}

	   if ( inserted )
		{
				if(error.indexOf("<br>")!=-1)
				error	=	error.substring(0,error.indexOf("<br>"));
				if(called_from_ca.equals("Y")){
				out.println("<html><head><script language='javascript'>");
				out.println("parent.frames(1).location.href=\"../eAE/jsp/ViewSecondaryTriage.jsp?patient_id="+patient_id+"&clinic_code="+clinic_code+"&treatment_area_code="+treatment_area_code+"&encounter_id="+encounter_id+"&CA="+called_from_ca+"&called_from_ca="+called_from_ca+"&disaster_yn="+disaster_yn+"&brought_dead="+brought_dead+"&bed_no="+bed_bay_no+"&practitioner_id="+practitioner_id+"&referral_id="+referral_id+"&priority_zone="+priority_code+"&rec_date_time="+rec_date_time+"\";");
				out.println("parent.frames(2).location.href=\"../eAE/jsp/AESecondaryTriage.jsp?patient_id="+patient_id+"&clinic_code="+clinic_code+"&treatment_area_code="+treatment_area_code+"&encounter_id="+encounter_id+"&called_from_ca="+called_from_ca+"&brought_dead="+brought_dead+"&bed_no="+bed_bay_no+"&practitioner_id="+practitioner_id+"&referral_id="+referral_id+"&priority_zone="+priority_code+"&rec_date_time="+rec_date_time+"\";");
				out.println("parent.frames(3).location.href=\"../eAE/jsp/SecondaryTriageButtons.jsp?patient_id="+patient_id+"&clinic_code="+clinic_code+"&referral_id="+referral_id+"&treatment_area_code="+treatment_area_code+"&encounter_id="+encounter_id+"&called_from_ca="+called_from_ca+"\";");

				out.println("</script></html>");
				out.println("<script>alert('"+error+"');</script>");
				}else{
					out.println("<script>alert('"+error+"');</script>");
					out.println("<script>window.returnValue='"+encounter+"&"+practitioner_id+"&"+enable_rights_yn+"&"+sel_triage_yn+"&"+sel_cons_yn+"';</script>");
					out.println("<script>parent.window.close();</script>");
				}

		}
		else
			{
				out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link></head><body class='MESSAGE'>"+error+"</body></html>");

				/* String error1 ="";
				String searchMe =error;
				String findMe = "ORA-00001";
				searchMe.indexOf("ORA-00001",0);
				int searchMeLength = searchMe.length();
				int findMeLength = findMe.length();
				boolean foundIt = false;
				for (int i = 0; i <= (searchMeLength - findMeLength); i++) {
					if (searchMe.regionMatches(i, findMe, 0, findMeLength)) {
						foundIt = true;
						MessageManager mm = new MessageManager();
						final java.util.Hashtable mesg = mm.getMessage(locale, "ENC_ALREADY_MODIFIED", "AE") ;
						String msg = ((String) mesg.get("message"));
						error1=msg;
						break;
					}
				}
				if (!foundIt)
				{
					error1=error;
				}
			out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link></head><body class='MESSAGE'>"+error1+"</body></html>");
				*/
			}

		
		ae_pr_encounter_add.clear();
		ae_pr_encounter_oth_dtls.clear();
		ae_pat_emergency_dtls.clear();
		ae_pat_triage.clear();
		session_details.clear();
		results.clear();
	}//end try
	    catch(Exception exception)
		{
			exception.printStackTrace();
		}
   }

    public static String checkForNull(String inputString)
	{
		return ( ((inputString == null) || (inputString.equals("null"))) ? "" : inputString );
	}

	public static String checkNullWithDftValue(String str, String dftval) {
		return ((str == null || str.equals("null")) ? dftval : str);
	}
}
