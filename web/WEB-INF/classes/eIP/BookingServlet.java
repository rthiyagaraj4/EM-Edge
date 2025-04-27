/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIP;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.StringTokenizer;
import javax.rmi.*;
import webbeans.eCommon.*;
import eIP.IPBooking.*;
import com.ehis.util.*;
import eCommon.Common.*;

public class BookingServlet extends javax.servlet.http.HttpServlet 
{
	String sStyle				= "";
	
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res)throws javax.servlet.ServletException,IOException
	{
		try  
		{
			PrintWriter out				= null;
			out               	        = res.getWriter() ;
			doPost(req,res);
			String url = "../eCommon/jsp/commonToolbar.jsp?" ;
			String params = req.getQueryString() ;
			String source = url + params ;
			out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/"+sStyle+"'></link><script language='javascript' src='/eCIS/ip/js/Booking.js'></script></head><frameset rows='42,*,50'><frame name='commontoolbarFrame'	src='"+source+"' frameborder=0 scrolling='no' noresize> <frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0><frame name='messageFrame'	src='../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto'></frameset></html> ");
			
		}catch(Exception e)	{	e.printStackTrace() ; }
	}


	public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out				= null;
		java.util.Properties p		= null;
		HttpSession session			= null;
		out							= res.getWriter();
		session						= req.getSession(false);
		p							= (java.util.Properties) session.getValue( "jdbc" ) ;
		String facilityId			= "";
		String patientid			= "";
		String locale				= "";
		facilityId					= (String) session.getValue( "facility_id" ) ;
		locale						= p.getProperty("LOCALE");
		String greg_pref_adm_date	= "";
		String multi_book_pat_yn	= "N";
		boolean proceed				= true;	
		sStyle						= (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String qryString 			= "";
		
		try	
		{
				
			patientid				= checkForNull(req.getParameter("patient_id"));
			multi_book_pat_yn		= checkForNull(req.getParameter("multi_book_pat_yn"));
			qryString 				= checkForNull(req.getParameter("qryString"));	
			Connection con			=	null;
			Statement entitle_stmt	= null;
			PreparedStatement entitle_pstmt = null;
			ResultSet entitle_rs	= null;

			String status			= "";
			String msg				= "";
			String entitlement_by_pat_cat_yn = "";
			proceed					= true;
	
			greg_pref_adm_date		= checkForNull(req.getParameter("pref_adm_date"));
			greg_pref_adm_date		= DateUtils.convertDate(greg_pref_adm_date,"DMYHM",locale,"en");
			
			out.println("<!DOCTYPE html><head><link rel='stylesheet' type='text/css' href='../eCommon/html/"+sStyle+"'></link>");
			out.println("<script src='../eCommon/js/showModalDialog.js' language='JavaScript'></script><script language='JavaScript'>");
			out.println("async function callInternalReports() { "); 
			
			if(!patientid.equals("")) 
			{
				try
				{					
					con = ConnectionManager.getConnection(p);
					entitle_stmt = con.createStatement();
					entitle_rs = entitle_stmt.executeQuery("select entitlement_by_pat_cat_yn from MP_PARAM ") ;
					if(entitle_rs.next())
					{	
						entitlement_by_pat_cat_yn = entitle_rs.getString("entitlement_by_pat_cat_yn");
					}
					if(entitle_rs != null) entitle_rs.close();
					if(entitle_stmt != null) entitle_stmt.close();

								
					if(entitlement_by_pat_cat_yn.equals("Y"))
					{
						entitle_pstmt = con.prepareStatement("select MP_ENTITLEMENT_VALIDATION(?,to_char(to_date(?,'dd/mm/yyyy hh24:mi'),'dd/mm/yyyy'),?,?,?,?,?,?) from dual");

						entitle_pstmt.setString(1,patientid);
						entitle_pstmt.setString(2,greg_pref_adm_date);
						entitle_pstmt.setString(3,facilityId);
						entitle_pstmt.setString(4,"N");
						entitle_pstmt.setString(5,checkForNull(req.getParameter("nursing_unit")));
						entitle_pstmt.setString(6,checkForNull(req.getParameter("app_pat_class")));
						entitle_pstmt.setString(7,checkForNull(req.getParameter("Splcode")));
						entitle_pstmt.setString(8,checkForNull(req.getParameter("bed_class_desc")));
						entitle_rs=entitle_pstmt.executeQuery();
						if(entitle_rs != null && entitle_rs.next())
						{
							status=entitle_rs.getString(1);
							if(status == null) status="";
						}
						if(entitle_rs != null) entitle_rs.close();
						if(entitle_pstmt != null) entitle_pstmt.close();
					}
				
					if(status.equals("0"))
					{
						proceed = true;
					}
					else if(status.equals("1"))
					{
						proceed = false;
						java.util.Hashtable message = MessageManager.getMessage(locale,"PAT_CAT_EXP","MP");
						msg = ((String) message.get("message"));
						if(msg.lastIndexOf("<br>") >= 0)
							msg=msg.substring(0,msg.lastIndexOf("<br>"));
						out.println("alert('"+msg+"');");
	
						out.println("parent.frames[0].location.href='../eCommon/jsp/commonToolbar.jsp?"+qryString+"';");
						out.println("parent.frames[1].location.reload();");
						out.println("parent.frames[2].location.href='../eCommon/jsp/MstCodeError.jsp';");
						message.clear();
					}
					else if(status.equals("2"))
					{
						proceed = false;
						java.util.Hashtable message = MessageManager.getMessage(locale,"LOC_NOT_ENTITLED","MP");
						msg = ((String) message.get("message"));
						if(msg.lastIndexOf("<br>") >= 0)
							msg=msg.substring(0,msg.lastIndexOf("<br>"));
						out.println("alert('"+msg+"');");
						out.println("parent.frames[0].location.href='../eCommon/jsp/commonToolbar.jsp?"+qryString+"';");
						out.println("parent.frames[1].location.reload();");
						out.println("parent.frames[2].location.href='../eCommon/jsp/MstCodeError.jsp';");
						message.clear();
					}
					else if(status.equals("3"))
					{
						proceed = false;
						java.util.Hashtable message = MessageManager.getMessage(locale,"SPL_NOT_ENTITLED","MP");
						msg = ((String) message.get("message"));
						if(msg.lastIndexOf("<br>") >= 0)
							msg=msg.substring(0,msg.lastIndexOf("<br>"));
						out.println("alert('"+msg+"');");
						out.println("parent.frames[0].location.href='../eCommon/jsp/commonToolbar.jsp?"+qryString+"';");
						out.println("parent.frames[1].location.reload();");
						out.println("parent.frames[2].location.href='../eCommon/jsp/MstCodeError.jsp';");
						message.clear();
					}
					else if(status.equals("4"))
					{
						proceed = false;
						java.util.Hashtable message = MessageManager.getMessage(locale,"BDCL_NOT_ENTITLED","MP");
						msg = ((String) message.get("message"));
						if(msg.lastIndexOf("<br>") >= 0)
							msg=msg.substring(0,msg.lastIndexOf("<br>"));
						out.println("alert('"+msg+"');");
						out.println("parent.frames[0].location.href='../eCommon/jsp/commonToolbar.jsp?"+qryString+"';");
						out.println("parent.frames[1].location.reload();");
						out.println("parent.frames[2].location.href='../eCommon/jsp/MstCodeError.jsp';");
						message.clear();
					}
					
				}catch(Exception e)
				{
					e.printStackTrace();
				}
				finally
				{
					if(con!=null) ConnectionManager.returnConnection(con,p);
				}
			}
			
			
			if(proceed)
			{		
				insertBooking(req,res, facilityId, patientid);
			}
			out.println("} callInternalReports(); </script></head>");
			out.println("<body></body>");
			out.println("</html>");
			
		}
		catch(Exception e)
		{
			e.printStackTrace() ;
		}
	}

	

	private void insertBooking(HttpServletRequest req, HttpServletResponse res,String facilityId, String patientid)	throws java.io.IOException
	{
		PrintWriter out				= null;
		java.util.Properties p		= null;
		HttpSession session			= null;
		out							= res.getWriter();
		session						= req.getSession(false);
		p							= (java.util.Properties) session.getValue( "jdbc" ) ;
		Connection con				= null;
		Statement booking_lt_stmt	= null;
		ResultSet booking_lt_rs		= null;
		Statement book_stmt			= null;
		ResultSet book_rs			= null;
		String greg_pref_adm_date	= "";
		String chk_booking_limit_by = "";
		String call_function		= "";
		String qryString 			= "";
		String locale				= "";
		String generatenumyn 		= "";
		String medsergrpcode		= "";
		String ot_medical_service	= "";
		String preferreddate  		= "";
		String preferredtimeind		= "";
		String exp_days_of_stay		= "";
		String nationalidno			= "";
		String altid1no				= "";
		String altid1expdate		= "";
		String altid1type			= "";
		String altid2no				= "";
		String altid2expdate		= "";
		String altid2type			= "";
		String altid3no				= "";
		String altid3expdate		= "";
		String altid3type			= "";
		String altid4no				= "";
		String altid4expdate		= "";
		String altid4type			= "";
		String oth_alt_id_no		= "";
		String oth_alt_id_type		= "";
		String nameprefix			= "";
		String firstname			= "";
		String secondname			= "";
		String thirdname			= "";
		String familyname			= "";
		String namesuffix			= "";
		String patientname			= "";
		String name_prefix_oth_lang	= "";
		String first_name_oth_lang	= "";
		String second_name_oth_lang	= "";
		String third_name_oth_lang	= "";
		String family_name_oth_lang	= "";
		String name_suffix_oth_lang	= "";
		String patient_name_local_lang	= "";
		String gender				= "";
		String dateofbirth			= "";
		String restelno 			= "";
		String othcontactno			= "";
		String emailid 				= "";
		String postalcode			= "";
		String countrycode			= "";
		String resaddrline1			= "";
		String resaddrline2			= "";
		String resaddrline3			= "";
		String resaddrline4			= "";
		String res_town_code		= "";
		String res_area_code		= "";
		String res_region_code		= "";
		String mail_addr_line1		= "";
		String mail_addr_line2		= "";
		String mail_addr_line3		= "";
		String mail_addr_line4		= "";
		String mail_town_code		= "";
		String mail_area_code		= "";
		String mail_region_code		= "";
		String mail_postal_code		= "";
		String mail_country_code	= "";
		String eth_grp				= "";
		String eth_sub_grp			= "";
		String birth_place			= "";
		String citizen				= "";
		String legal				= "";
		String patienttypecode		= "";
		String refsourcetype		= "";
		String referralcode			= "";
		String specilitycode		= "";
		String practitionerid		= "";
		String chiefcomplaint		= "";
		String procedure			= "";
		String location				= "";
		String otdatetime			= "";
		String bedclasscode			= "";
		String nursingunitcode		= "";
		String bedtypecode			= "";
		String appt_ref				= "";
		String nursingunittypecode	= "";
		String bookedbyid			= "";
		String roomno				= "";
		String bedno				= "";
		String nationality			= "";
		String teamid				= "";
		String referral_id			= "";
		String service_code			= "";
		String ambreqddatetime		= "";
		String birth_Place_desc		= "";
		String confirm_yn			= "";
		String place_of_birth		= "";
		String is_oa_yn				= "";
		String wait_list_ref_no		= "";
		String overrideyn			= "N";
		String blooddonationyn		= "N";
		String ambreqdyn			= "N";
		String priorityind			= "N";
		String expected_discharge_date			= "";
		String isBlInstalled		= "N";
		String billing_interfaced	= "N";
		String iscapture_fin_dtls_yn= "N";
		String chief_complaint		= "";
		String is_op_pending_referral_booking	= "";
		String booking_remarks		= "";
		String billing_group		= "";
		String episodestatus		= "0";
		String patient_name_long="";
		String patient_name_loc_lang_long="";
		//Maheshwaran K added for the CRF : RUT-CRF-0012 (23395	) as on 28/01/2013
		//Start
		String surgery_order_code="";
		String surgery_order="";
		String surgery_order_id="";
		String surgery_order_line_no="";
		String surgery_order_date="";
		//End
		/*Added by Thamizh selvi on 30th Jan 2018 against ML-MMOH-CRF-0601 Start*/
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
		TreeMap patInstructionsMap=(java.util.TreeMap)session.getAttribute("ipPatInstructionsMap");//included for the CRF - RUT-CRF-013 23396
		call_function				= req.getParameter("call_function");
		if (call_function == null )	  call_function ="IP_Booking";
		boolean proceed				= true;
		locale						= p.getProperty("LOCALE");
		generatenumyn 				= checkForNull(req.getParameter("generatenumyn"));

		if (	generatenumyn == null || generatenumyn == "" || generatenumyn.equals(""))	
		   generatenumyn			= "N";

		medsergrpcode				= checkForNull(req.getParameter("med_service_grp"));
		ot_medical_service			= checkForNull(req.getParameter("ot_medical_service"));

		if (medsergrpcode.equals("")||medsergrpcode==null)
				medsergrpcode		= checkForNull(req.getParameter("medsergrpcode_hid"));
		greg_pref_adm_date			= checkForNull(req.getParameter("pref_adm_date"));
		greg_pref_adm_date			= DateUtils.convertDate(greg_pref_adm_date,"DMYHM",locale,"en");
		preferreddate  				= greg_pref_adm_date;//checkForNull(req.getParameter("pref_adm_date"));
			if (preferreddate.equals("")||preferreddate==null)
				preferreddate = checkForNull(req.getParameter("pref_adm_date_hid"));

		//if(call_function.equals("OT"))
		StringTokenizer token		= new StringTokenizer(medsergrpcode, "#");
		if (token.hasMoreTokens())
		{
			medsergrpcode			= checkForNull(token.nextToken());

		}
		if(call_function.equals("OT") && (!ot_medical_service.equals("")))
		{
			medsergrpcode			= ot_medical_service;

		}
		preferredtimeind			= checkForNull(req.getParameter("amVal"));
		exp_days_of_stay			= checkForNull(req.getParameter("exp_days_of_stay"));		
		nationalidno				= checkForNull(req.getParameter("national_id_no"));
		altid1no					= checkForNull(req.getParameter("alt_id1_no"));
		altid1expdate				= checkForNull(req.getParameter("alt_id1_exp_date"));
		altid1expdate				= DateUtils.convertDate(altid1expdate,"DMY",locale,"en");
		altid1type					= checkForNull(req.getParameter("alt_id1_type"));
		altid2no					= checkForNull(req.getParameter("alt_id2_no"));
		altid2expdate				= checkForNull(req.getParameter("alt_id2_exp_date"));
		altid2expdate				= DateUtils.convertDate(altid2expdate,"DMY",locale,"en");
		altid2type					= checkForNull(req.getParameter("alt_id2_type"));
		altid3no					= checkForNull(req.getParameter("alt_id3_no"));
		altid3expdate				= checkForNull(req.getParameter("alt_id3_exp_date"));
		altid3expdate				= DateUtils.convertDate(altid3expdate,"DMY",locale,"en");
		altid3type					= checkForNull(req.getParameter("alt_id3_type"));
		altid4no					= checkForNull(req.getParameter("alt_id4_no"));
		altid4expdate				= checkForNull(req.getParameter("alt_id4_exp_date"));
		altid4expdate				= DateUtils.convertDate(altid4expdate,"DMY",locale,"en");
		altid4type					= checkForNull(req.getParameter("alt_id4_type"));
		oth_alt_id_no				= checkForNull(req.getParameter("other_alt_Id"));
		oth_alt_id_type				= checkForNull(req.getParameter("other_alt_type"));
		//String nameprefix			= checkForNull(req.getParameter("name_prefix1"));
		nameprefix					= checkForNull(req.getParameter("name_prefix"));
		firstname					= checkForNull(req.getParameter("first_name"));
		secondname					= checkForNull(req.getParameter("second_name"));
		thirdname					= checkForNull(req.getParameter("third_name"));
		familyname					= checkForNull(req.getParameter("family_name"));
		namesuffix					= checkForNull(req.getParameter("name_suffix"));
		patientname					= checkForNull(req.getParameter("patient_name"));
		
		if(patientname !=null && patientname.length()>100){
			patientname=patientname.substring(0,100);
		}
		

		patient_name_long = checkForNull(req.getParameter("patient_name_long"));
		patient_name_loc_lang_long = checkForNull(req.getParameter("patient_name_loc_lang_long"));

		if(patient_name_long !=null && patient_name_long.length()>300){
			patient_name_long=patient_name_long.substring(0,300);
		}

		if(patient_name_loc_lang_long !=null && patient_name_loc_lang_long.length()>300){
			patient_name_loc_lang_long=patient_name_loc_lang_long.substring(0,300);
		}

		name_prefix_oth_lang		= checkForNull(req.getParameter("name_prefix_oth_lang"));
		first_name_oth_lang			= checkForNull(req.getParameter("first_name_oth_lang"));
		second_name_oth_lang		= checkForNull(req.getParameter("second_name_oth_lang"));
		third_name_oth_lang			= checkForNull(req.getParameter("third_name_oth_lang"));
		family_name_oth_lang		= checkForNull(req.getParameter("family_name_oth_lang"));
		name_suffix_oth_lang		= checkForNull(req.getParameter("name_suffix_oth_lang"));
		patient_name_local_lang		= checkForNull(req.getParameter("patient_name_local_lang"));
		if(patient_name_local_lang !=null && patient_name_local_lang.length()>100){
			patient_name_local_lang=patient_name_local_lang.substring(0,100);
		}
		gender						= checkForNull(req.getParameter("sex"));
		dateofbirth					= checkForNull(req.getParameter("date_of_birth"));
		dateofbirth					= DateUtils.convertDate(dateofbirth,"DMY",locale,"en");
	
		restelno 					= checkForNull(req.getParameter("contact1_no"));
		othcontactno				= checkForNull(req.getParameter("contact2_no"));
		emailid 					= checkForNull(req.getParameter("email"));
		postalcode					= checkForNull(req.getParameter("postal_code"));
		countrycode					= checkForNull(req.getParameter("country_code"));
		resaddrline1				= checkForNull(req.getParameter("addr_line1"));
		resaddrline2				= checkForNull(req.getParameter("addr_line2"));
		resaddrline3				= checkForNull(req.getParameter("addr_line3"));
		resaddrline4				= checkForNull(req.getParameter("addr_line4"));
		res_town_code				= checkForNull(req.getParameter("res_town_code"));
		res_area_code				= checkForNull(req.getParameter("res_area_code"));
		res_region_code				= checkForNull(req.getParameter("region_code"));
		mail_addr_line1				= checkForNull(req.getParameter("mail_addr_line1"));
		mail_addr_line2				= checkForNull(req.getParameter("mail_addr_line2"));
		mail_addr_line3				= checkForNull(req.getParameter("mail_addr_line3"));
		mail_addr_line4				= checkForNull(req.getParameter("mail_addr_line4"));
		mail_town_code				= checkForNull(req.getParameter("mail_res_town_code"));
		mail_area_code				= checkForNull(req.getParameter("mail_res_area_code"));
		mail_region_code			= checkForNull(req.getParameter("mail_region_code"));
		mail_postal_code			= checkForNull(req.getParameter("mail_postal_code"));
		mail_country_code			= checkForNull(req.getParameter("mail_country_code"));

		/*Added by Thamizh selvi on 29th Jan 2018 against ML-MMOH-CRF-0601 Start*/
		altAddrLine1	= checkForNull(req.getParameter("alt_addr_line1"));
		altAddrLine2	= checkForNull(req.getParameter("alt_addr_line2"));
		altAddrLine3	= checkForNull(req.getParameter("alt_addr_line3"));
		altAddrLine4	= checkForNull(req.getParameter("alt_addr_line4"));
		altAreaCode		= checkForNull(req.getParameter("alt_area_code"));
		altTownCode		= checkForNull(req.getParameter("alt_town_code"));
		altPostalCode	= checkForNull(req.getParameter("alt_postal_code"));
		altRegionCode	= checkForNull(req.getParameter("alt_region_code"));
		altCountryCode	= checkForNull(req.getParameter("alt_country_code"));
		/*End*/
		
		eth_grp						= checkForNull(req.getParameter("ethnic_group"));
		eth_sub_grp					= checkForNull(req.getParameter("race_code"));
		birth_place					= checkForNull(req.getParameter("Birth_place_code"));
		citizen						= checkForNull(req.getParameter("citizen"));
		legal						= checkForNull(req.getParameter("legal"));
		patienttypecode				= checkForNull(req.getParameter("PatCode"));
		refsourcetype				= checkForNull(req.getParameter("source_type"));
		referralcode				= checkForNull(req.getParameter("source"));
		specilitycode				= checkForNull(req.getParameter("Splcode"));
		practitionerid				= checkForNull(req.getParameter("practid"));
		chiefcomplaint				= checkForNull(req.getParameter("complaintcode"));
			
		procedure					= checkForNull(req.getParameter("surg_proc"));
		location					= checkForNull(req.getParameter("clinic_location"));
		otdatetime					= checkForNull(req.getParameter("ot_date_time"));
		otdatetime					= DateUtils.convertDate(otdatetime,"DMYHM",locale,"en");
		bedclasscode				= checkForNull(req.getParameter("bed_class_desc"));
		nursingunitcode				= checkForNull(req.getParameter("nursing_unit"));
		
		bedtypecode					= checkForNull(req.getParameter("bed_type_desc"));
		appt_ref					= checkForNull(req.getParameter("appt_ref"));
		nursingunittypecode			= checkForNull(req.getParameter("nursingunittypecode"));
		bookedbyid					= checkForNull(req.getParameter("bookedbyid"));
		roomno						= checkForNull(req.getParameter("room_no"));
		bedno						= checkForNull(req.getParameter("bed_no"));
		nationality					= checkForNull(req.getParameter("nationality_code1"));
		teamid						= checkForNull(req.getParameter("team_id"));
		referral_id					= checkForNull(req.getParameter("referral_id"));
		service_code				= checkForNull(req.getParameter("service_desc"));
		ambreqddatetime				= checkForNull(req.getParameter("amb_reqd_date_time"));
		birth_Place_desc			= checkForNull(req.getParameter("birth_place"));
		confirm_yn					= checkForNull(req.getParameter("confirm_yn"));
		place_of_birth				= checkForNull(req.getParameter("place_of_birth"));
			if(place_of_birth.equals(""))   place_of_birth = birth_Place_desc;
		
		is_oa_yn					= checkForNull(req.getParameter("is_oa_yn"));
		wait_list_ref_no			= checkForNull(req.getParameter("wait_list_ref_no"));
		
		overrideyn					= req.getParameter("override_yn");
		if (overrideyn == null || overrideyn == "" || overrideyn.equals(""))
				  overrideyn="N";
		blooddonationyn				= req.getParameter("blood_donation_yn");
		if (blooddonationyn == null || blooddonationyn == "" || blooddonationyn.equals(""))
				  blooddonationyn="N";
		ambreqdyn					= req.getParameter("amb_reqd_yn");
		if (ambreqdyn == null || ambreqdyn == "" || ambreqdyn.equals(""))
				   ambreqdyn="N";
		priorityind					= req.getParameter("priority_ind");
		if (priorityind == null || priorityind == "" || priorityind.equals(""))	 priorityind ="N";

		expected_discharge_date			= checkForNull(req.getParameter("exp_discharge_date"));
		expected_discharge_date					= DateUtils.convertDate(expected_discharge_date,"DMYHM",locale,"en");

		isBlInstalled					= checkForNull(req.getParameter("isBlInstalled"),"N");
		billing_interfaced				= checkForNull(req.getParameter("isBlInterfaced"),"N");
		iscapture_fin_dtls_yn			= checkForNull(req.getParameter("iscapture_fin_dtls_yn"),"N");
		chief_complaint					= checkForNull(req.getParameter("chief_complaint"));
		is_op_pending_referral_booking	= checkForNull(req.getParameter("is_op_pending_referral_booking"));
		booking_remarks			= checkForNull(req.getParameter("booking_remarks"));
		//Maheshwaran K added for the CRF : RUT-CRF-0012 (23395	) as on 28/01/2013
		//Start
		surgery_order_code			= checkForNull(req.getParameter("surgery_order_code"));
		surgery_order			= checkForNull(req.getParameter("surgery_order"));
		surgery_order_id			= checkForNull(req.getParameter("surgery_order_id"));
		surgery_order_line_no			= checkForNull(req.getParameter("surgery_order_line_no"));
		surgery_order_date			= checkForNull(req.getParameter("surgery_order_date"));
		if(!surgery_order_date.equals(""))
		surgery_order_date=DateUtils.convertDate(surgery_order_date,"DMY",locale,"en");
		//End
		if(isBlInstalled.equals("Y"))  
		{
			//pkg_bill_type			= checkForNull(req.getParameter("pkg_bill_type"));
			//if(!( req.getParameter("pkg_bill_no")==null || req.getParameter("pkg_bill_no").equals("") ))
			//pkg_bill_no =Integer.parseInt(req.getParameter("pkg_bill_no"));
			billing_group			= checkForNull(req.getParameter("billing_group"));
			//insTrackDtlsExists		= checkForNull(req.getParameter("insTrackDtlsExists"));
		}


		try
		{
			int count = 0;
			con = ConnectionManager.getConnection(p);
			smartCardFunc = eCommon.Common.CommonBean.isSiteSpecificforBiometric(con);//Maheshwaran K added for AAKH-CRF-0175 as on 23-08-2023
			//Maheshwaran K added for AAKH-CRF-0175 as on 23-08-2023		
			if(smartCardFunc.equals("01")) {
			biometric_reason	= checkForNull((String) session.getValue( "biometric_reason" )) ;
			session.removeAttribute("biometric_reason");
			}
			//Ends	
			/*
			book_stmt = con.createStatement();
			book_rs = book_stmt.executeQuery("select CHK_BOOKING_LIMIT_BY from IP_PARAM where facility_id='"+facilityId+"' ") ;
			if(book_rs.next())
			{	
				chk_booking_limit_by = book_rs.getString("chk_booking_limit_by");
			}
			if(book_rs != null) book_rs.close();
			if(book_stmt != null) book_stmt.close();
			*/
			chk_booking_limit_by = checkForNull(req.getParameter("chk_booking_limit_by"));

			if(chk_booking_limit_by.equals("2") && !bedclasscode.equals(""))
			{
				booking_lt_stmt = con.createStatement();
				booking_lt_rs = booking_lt_stmt.executeQuery(" SELECT count(*) FROM IP_BOOK_LIMIT_BY_AGE_GRP WHERE facility_id='"+facilityId+"' AND bed_class_code = '"+bedclasscode+"' AND age_group_code IN (SELECT age_group_code FROM AM_AGE_GROUP where NVL(GENDER,'"+gender+"') = '"+gender+"' AND trunc(SYSDATE) - TRUNC(TO_DATE('"+dateofbirth+"','DD/MM/YYYY')) BETWEEN DECODE(AGE_UNIT,'Y',365,'M',30,1) * MIN_AGE AND DECODE(AGE_UNIT,'Y',365,'M',30,1) * MAX_AGE ) ");

				//String ss = "SELECT count(*) FROM IP_BOOK_LIMIT_BY_AGE_GRP WHERE facility_id='"+facilityId+"' AND bed_class_code = '"+bedclasscode+"' AND age_group_code IN (SELECT age_group_code FROM AM_AGE_GROUP where NVL(GENDER,'"+gender+"') = '"+gender+"' AND trunc(SYSDATE) - TRUNC(TO_DATE('"+dateofbirth+"','DD/MM/YYYY')) BETWEEN DECODE(AGE_UNIT,'Y',365,'M',30,1) * MIN_AGE AND DECODE(AGE_UNIT,'Y',365,'M',30,1) * MAX_AGE )";

				if(booking_lt_rs != null && booking_lt_rs.next())
				{	
					count = booking_lt_rs.getInt(1);
				}
				if(booking_lt_rs != null) booking_lt_rs.close();
				if(booking_lt_stmt != null) booking_lt_stmt.close();

				if(count > 0)
				{
					proceed = true;
				}
				else
				{
					proceed = false;
					java.util.Hashtable message = MessageManager.getMessage(locale,"AGR_GRP_BOOKING_LT_SETUP","IP");
					String Msg = ((String) message.get("message"));
					out.println("alert('"+Msg+"');");
					message.clear();
					out.println("parent.frames[0].location.href='../eCommon/jsp/commonToolbar.jsp?"+qryString+"';");
					out.println("parent.frames[1].location.reload();");
					out.println("parent.frames[2].location.href='../eCommon/jsp/MstCodeError.jsp';");
				}
			}


			if(bedno!=null && !bedno.equals(""))
			{
				int no_of_time_bed_booked = 0;

				String sql	= "select Count(*) no_of_record from ip_bed_booking where booking_status  in ('0','1')  and facility_id = '"+facilityId+"' and req_nursing_unit_code = '"+nursingunitcode+"' and req_bed_no = '"+bedno+"' AND blocked_from_date_time > SYSDATE AND ((blocked_from_date_time BETWEEN    TO_DATE('"+greg_pref_adm_date+"', 'DD/MM/YYYY HH24:MI')    AND TO_DATE('"+expected_discharge_date+"', 'DD/MM/YYYY HH24:MI')) OR (blocked_until_date_time BETWEEN    TO_DATE('"+greg_pref_adm_date+"', 'DD/MM/YYYY HH24:MI') AND TO_DATE('"+expected_discharge_date+"', 'DD/MM/YYYY HH24:MI')) OR  ( blocked_from_date_time <= TO_DATE('"+greg_pref_adm_date+"','DD/MM/YYYY HH24:MI') and blocked_until_date_time >= TO_DATE('"+expected_discharge_date+"','DD/MM/YYYY HH24:MI')))";

				book_stmt	=	con.createStatement();
				book_rs		=	book_stmt.executeQuery(sql);

				if(book_rs.next())
				{
					no_of_time_bed_booked				= book_rs.getInt("no_of_record");						
				}
				if(book_rs !=null) book_rs.close(); 
				if(book_stmt != null) book_stmt.close();

				if(no_of_time_bed_booked>0)
				{
					proceed = false;	
					
					java.util.Hashtable message = MessageManager.getMessage(locale,"OVERLAP_BLOCK_TIME","IP");
					String Msg = ((String) message.get("message"));
					out.println("alert('"+Msg+"');");
					message.clear();
					out.println("parent.frames[0].location.href='../eCommon/jsp/commonToolbar.jsp?"+qryString+"';");
					out.println("parent.frames[1].location.reload();");
					out.println("parent.frames[2].location.href='../eCommon/jsp/MstCodeError.jsp';");	
				}
				else
				{
					proceed = true;
				}
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace() ;
		}
		finally
		{
			if(con!=null) ConnectionManager.returnConnection(con,p);
		}
		if(proceed)
		{
			try 
			{
				String error		= "";
				HashMap hashData	= new HashMap();
				HashMap fin_dtls	= new HashMap();
				hashData.put("facilityId",facilityId);  //facilityId
				hashData.put("generatenumyn",generatenumyn);
				hashData.put("bkglstrefno",checkForNull(req.getParameter("booking_ref_no"))); //bookingrefno
				hashData.put("medsergrpcode",medsergrpcode);
				hashData.put("preferreddate",preferreddate);  //admissiondate
				hashData.put("preferredtimeind",preferredtimeind);
				hashData.put("multi_book_pat_yn",checkForNull(req.getParameter("multi_book_pat_yn"),"N"));
				hashData.put("patientid",patientid); //patientid
				hashData.put("nameprefix",nameprefix);
				hashData.put("firstname",firstname);
				hashData.put("secondname",secondname);
				hashData.put("thirdname",thirdname);
				hashData.put("familyname",familyname);
				hashData.put("namesuffix",namesuffix);
				hashData.put("patient_name_long",patient_name_long);
				hashData.put("patient_name_loc_lang_long",patient_name_loc_lang_long);

				hashData.put("name_prefix_oth_lang",name_prefix_oth_lang);
				hashData.put("first_name_oth_lang",first_name_oth_lang);
				hashData.put("second_name_oth_lang",second_name_oth_lang);
				hashData.put("third_name_oth_lang",third_name_oth_lang);
				hashData.put("family_name_oth_lang",family_name_oth_lang);
				hashData.put("name_suffix_oth_lang",name_suffix_oth_lang);
				hashData.put("patient_name_local_lang",patient_name_local_lang);
				hashData.put("patientname",patientname);
				hashData.put("gender",gender);
				hashData.put("dateofbirth",dateofbirth);
				hashData.put("restelno",restelno); //res_tel_no
				hashData.put("othcontactno",othcontactno); //oth_contact_no
				hashData.put("emailid",emailid); //email_id
				hashData.put("nationalidno",nationalidno);
				hashData.put("altid1no",altid1no);
				hashData.put("altid1expdate",altid1expdate);
				hashData.put("altid1type",altid1type);
				hashData.put("altid2no",altid2no);
				hashData.put("altid2expdate",altid2expdate);
				hashData.put("altid2type",altid2type);				
				hashData.put("altid3no",altid3no);
				hashData.put("altid3expdate",altid3expdate);
				hashData.put("altid3type",altid3type);
				hashData.put("altid4no",altid4no);
				hashData.put("altid4expdate",altid4expdate);
				hashData.put("altid4type",altid4type);
				hashData.put("oth_alt_id_type",oth_alt_id_type);
				hashData.put("oth_alt_id_no",oth_alt_id_no);
				hashData.put("resaddrline1",resaddrline1); //res_addr_line1
				hashData.put("resaddrline2",resaddrline2); //res_addr_line2
				hashData.put("resaddrline3",resaddrline3); //res_addr_line3
				hashData.put("resaddrline4",resaddrline4); //res_addr_line4
				hashData.put("postalcode",postalcode);  //postal_code
				hashData.put("countrycode",countrycode);  //country_code
				hashData.put("res_town_code",res_town_code);
				hashData.put("res_area_code",res_area_code);
				hashData.put("res_region_code",res_region_code);
				hashData.put("mail_addr_line1",mail_addr_line1);
				hashData.put("mail_addr_line2",mail_addr_line2);
				hashData.put("mail_addr_line3",mail_addr_line3);
				hashData.put("mail_addr_line4",mail_addr_line4);
				hashData.put("mail_town_code",mail_town_code);
				hashData.put("mail_area_code",mail_area_code);
				hashData.put("mail_region_code",mail_region_code);
				hashData.put("mail_postal_code",mail_postal_code);
				hashData.put("mail_country_code",mail_country_code);
				hashData.put("patienttypecode",patienttypecode); //patienttype
				hashData.put("refsourcetype",refsourcetype);
				hashData.put("referralcode",referralcode);
				hashData.put("specilitycode",specilitycode);  //speciality
				hashData.put("practitionerid",practitionerid);  //practitioner
				hashData.put("chiefcomplaint",chiefcomplaint); //chiefcomplaint
				hashData.put("otdatetime",otdatetime); //otdatetime
				hashData.put("overrideyn",overrideyn);
				hashData.put("bedclasscode",bedclasscode); //bedclass
				hashData.put("bedtypecode",bedtypecode); //bedtype
				hashData.put("nursingunitcode",nursingunitcode); //nursingunit
				hashData.put("nursingunittypecode",nursingunittypecode); //nursingunittype
				hashData.put("roomno",roomno);  // roomno
				hashData.put("bedno",bedno); //bedno
				hashData.put("bookedbyid",bookedbyid);
				hashData.put("client_ip_address",p.getProperty("client_ip_address"));
				hashData.put("priorityind",priorityind);
				hashData.put("ambreqddatetime",ambreqddatetime);
				hashData.put("ambreqdyn",ambreqdyn);
				hashData.put("blooddonationyn",blooddonationyn);
				hashData.put("nationality",nationality);
				hashData.put("teamid",teamid);  //medicalteam
				hashData.put("referral_id",referral_id); //referralid
				hashData.put("exp_days_of_stay",exp_days_of_stay);
				hashData.put("service_code",service_code); //service
				hashData.put("eth_grp",eth_grp);
				hashData.put("eth_sub_grp",eth_sub_grp);
				hashData.put("birth_place",birth_place);
				hashData.put("citizen",citizen);
				hashData.put("legal",legal);
				hashData.put("place_of_birth",place_of_birth);
				hashData.put("confirm_yn",confirm_yn);
				hashData.put("procedure",procedure);
				hashData.put("location",location);
				hashData.put("appt_ref",appt_ref);
				hashData.put("is_oa_yn",is_oa_yn);
				hashData.put("call_function",call_function);
				hashData.put("wait_list_ref_no",wait_list_ref_no);
				hashData.put("locale",locale);
				hashData.put("expected_discharge_date",expected_discharge_date); 
				hashData.put("block_bed_based_on",checkForNull(req.getParameter("block_bed_based_on"))); 
				/*Added by Thamizh selvi on 29th Jan 2018 against ML-MMOH-CRF-0601 Start*/
				hashData.put("altAddrLine1",altAddrLine1);
				hashData.put("altAddrLine2",altAddrLine2);
				hashData.put("altAddrLine3",altAddrLine3);
				hashData.put("altAddrLine4",altAddrLine4);
				hashData.put("altAreaCode",altAreaCode);
				hashData.put("altTownCode",altTownCode);
				hashData.put("altPostalCode",altPostalCode);
				hashData.put("altRegionCode",altRegionCode);
				hashData.put("altCountryCode",altCountryCode);
				/*End*/
				//new billing parameter should be passed for billing interface
				hashData.put("isBlInstalled",isBlInstalled);   
				//hashData.put("insTrackDtlsExists",insTrackDtlsExists);   
				//hashData.put("dailycharge",dailycharge+"");  
				hashData.put("billing_interfaced",billing_interfaced);
				hashData.put("billing_group",billing_group);   
				//hashData.put("pkg_bill_type",pkg_bill_type );
				//hashData.put("pkg_bill_no",pkg_bill_no+"");    
				hashData.put("episodestatus",episodestatus); 
				//hashData.put("visitid",visitid+""); 
				hashData.put("iscapture_fin_dtls_yn",iscapture_fin_dtls_yn); 
				hashData.put("booking_remarks",booking_remarks);
				hashData.put("booking_Type",checkForNull(req.getParameter("booking_Type"))); 
				if(isBlInstalled.equals("Y"))  
				{
					fin_dtls=(HashMap)session.getAttribute("financial_details");
					if(fin_dtls!=null)
					{
						hashData.put("fin_dtls",(HashMap)fin_dtls);	
					}
				}
				hashData.put("chief_complaint",chief_complaint); 

				//RUT-CRF-013 changes - start
				hashData.put("patInstructions",patInstructionsMap);
				//Maheshwaran K added for the CRF : RUT-CRF-0012 (23395	) as on 28/01/2013
				//Start
				hashData.put("surgery_order_code",surgery_order_code);
				hashData.put("surgery_order",surgery_order);
				hashData.put("surgery_order_id",surgery_order_id);
				hashData.put("surgery_order_line_no",surgery_order_line_no);
				hashData.put("surgery_order_date",surgery_order_date);
				//End
				//Maheshwaran K added for AAKH-CRF-0175 as on 23-08-2023	
				hashData.put("smartCardFunc",smartCardFunc);
				hashData.put("biometric_reason",biometric_reason);
				//Ends
				
				//RUT-CRF-013 changes - end
				boolean local_ejbs			= false;
				if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs					= true;

				Object home					= com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/IPBooking",IPBookingHome.class,local_ejbs);
				Object busObj				= (home.getClass().getMethod("create",null)).invoke(home,null);
				Object argArray[]			= new Object[2];
				argArray[0]					= p;
				argArray[1]					= hashData;
				
				Class [] paramArray			= new Class[2];
				paramArray[0]				= p.getClass();
				paramArray[1]				= hashData.getClass();
			
				java.util.HashMap results	= (java.util.HashMap)(busObj.getClass().getMethod("insertIPBooking",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
				boolean inserted			= ( ((Boolean) results.get( "status" )).booleanValue() ) ;
				error						= (String) results.get("error") ;
			
				String book_reference_no	= "";
				book_reference_no			= (String) results.get("booking_reference_no") ;
				String overRideMessage		= "";
				overRideMessage				= (String) results.get("overrideMessage");
				if(overRideMessage == null ) overRideMessage = "";
				if (!overRideMessage.equals(""))
				{
					error =overRideMessage +"\\n"+error;
				}
				
				if(error.indexOf("<br>")!=-1)
					error					= error.substring(0,error.indexOf("<br>"));

				HashMap hashResult			= new HashMap();
				hashResult.put("nursingunitcode",nursingunitcode);
				hashResult.put("facilityId",facilityId);
				hashResult.put("book_reference_no",book_reference_no);
				hashResult.put("error",error);
				hashResult.put("call_function",call_function);
				hashResult.put("patientid",patientid);
				hashResult.put("is_op_pending_referral_booking",is_op_pending_referral_booking);
				hashResult.put("locale",locale);
			
				if(inserted)
				{
					if(confirm_yn.equals("Y"))
					{
						doOnlineReports(hashResult,p,out);		
					}
					else
					{			
						if(call_function.equals("CA_Task_IP_Booking")||call_function.equals("CA_Clinician_IP_Booking"))
						{
							out.println("alert('"+error+"');");
							/*out.println("parent.window.close();");*/
							out.println("parent.document.getElementById('dialog_tag').close();");
							//out.println("</script>");
						}
						else if(call_function.equals("OT"))
						{
							out.println("alert('"+error+"');");
							/*out.println("parent.window.close();");*/
							out.println("parent.document.getElementById('dialog_tag').close();");
							//out.println("</script>");
							out.println("parent.frames[0].location.href='../eCommon/jsp/commonToolbar.jsp?"+qryString+"'");	
							out.println("parent.frames[2].location.href='../eCommon/jsp/error.jsp';");
						}
						else if(call_function.equals("OA_IP_Booking"))
						{
							out.println("alert('"+error+"');");
							/*out.println("parent.window.close();");*/
							out.println("parent.document.getElementById('dialog_tag').close();");
							//out.println("</script>");
						}
						else
						{							
							//out.println("<Script>parent.frames[2].location.href='../eCommon/jsp/error.jsp?err_num="+java.net.URLEncoder.encode(error, "UTF-8")+"&err_value=1';</script>");
							/*Modified on 27-06-2008 for SCR #4591 */	
								
							doOnlineReports(hashResult,p,out);	
						}
						//out.println("</script>");
					}
					session.removeAttribute("ipPatInstructionsMap");//included for the CRF - RUT-CRF-013 23396 			
						
				}
				else
				{
					if(error.indexOf("Exception") == -1)
					{
						out.println("if(parent.frames[0].document.forms[0] != null && parent.frames[0].document.forms[0] != undefined){");					
						out.println("parent.frames[0].document.forms[0].apply.disabled = false;}");
					}
					if(call_function.equals("CA_Clinician_IP_Booking"))
					{	
						out.println("parent.frames[2].location.href='../eIP/jsp/IPError.jsp?err_num="+java.net.URLEncoder.encode(error, "UTF-8")+"&err_value=0';");		
					}
					else if(call_function.equals("OT"))
					{	
						out.println("parent.frames[2].location.href='../eIP/jsp/IPError.jsp?err_num="+java.net.URLEncoder.encode(error, "UTF-8")+"&err_value=0&call_func=OT';");		
					}
					else if(call_function.equals("IP_Booking"))
					{
						out.println("parent.frames[2].location.href='../eCommon/jsp/error.jsp?err_num="+java.net.URLEncoder.encode(error, "UTF-8")+"&err_value=0';");
					}
					else if(call_function.equals("OA_IP_Booking"))
					{
						out.println("parent.frames[2].location.href='../eIP/jsp/IPError.jsp?err_num="+java.net.URLEncoder.encode(error, "UTF-8")+"&err_value=0';");			
					}
					else if(call_function.equals("CA_Task_IP_Booking"))
					{
						out.println("parent.frames[2].location.href='../eIP/jsp/IPError.jsp?err_num="+java.net.URLEncoder.encode(error, "UTF-8")+"&err_value=0';");		
					}
					//out.println("</script>");
				}
				hashData.clear();
				results.clear();
				hashResult.clear();
				
				if(inserted)
				{
					session.removeAttribute("financial_details"); 
					if(fin_dtls!=null)
						fin_dtls.clear();
				}


			}catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}//E.o.Method InsertBooking


	private void doOnlineReports(HashMap hashValues,java.util.Properties p,PrintWriter out) throws ServletException, IOException, SQLException
	{
		String sqlString		= "";		
		String dest_locn_type	= "";
		String  pat_val			= "";
		Connection con			=	null;
		Statement vip_stmt		= null;
		ResultSet vip_rs		= null;
		String nursing_unit		= "";
		String facilityId		= "";
		String bkglstrefno		= "";
		String error			= "";
		String call_function	= "";
		String patientid		= "";
		String is_op_pending_referral_booking	= "";
		String locale			= "";
		String reportParamNames	= "";
		String reportParamValues= "";
		String Patient_param	= "";
		//int cnt = 0;

		try
		{
			con					= ConnectionManager.getConnection(p);
			nursing_unit		= (String)hashValues.get("nursingunitcode");
			facilityId			= (String)hashValues.get("facilityId");
			bkglstrefno			= (String)hashValues.get("book_reference_no");
			error				= (String)hashValues.get("error");
			call_function		= (String)hashValues.get("call_function");
			patientid			= (String)hashValues.get("patientid");
			is_op_pending_referral_booking			= (String)hashValues.get("is_op_pending_referral_booking");
			locale				= (String)hashValues.get("locale");
			if (!nursing_unit.equals(""))
			{
			
				if(patientid != "")
				{
					vip_stmt = con.createStatement();
					vip_rs = vip_stmt.executeQuery(" SELECT a.PAT_CAT_CODE  FROM MP_PATIENT a ,MP_PAT_CATEGORY b WHERE b.GOVT_OR_PVT_IND = 'V' AND  a.PAT_CAT_CODE = b.PAT_CAT_CODE AND a.patient_id = '"+patientid+"'") ;

					if(vip_rs.next())
					{	
						pat_val = vip_rs.getString(1);
					}
					if(vip_rs != null) vip_rs.close();
					if(vip_stmt != null) vip_stmt.close();
				}
				
			if(pat_val!="")
			{
				sqlString = "select a.report_id report_id, b.report_desc report_desc, 1 no_of_copies, a.module_id from ip_online_report a, sm_report_lang_vw b  where  b.language_id='"+locale+"' and a.module_id = 'IP' and b.internal_request_yn='Y' and a.facility_id='"+facilityId+"' and a.print_on_booking_yn='Y' and a.nursing_unit_code ='"+nursing_unit+"'  and a.report_id = b.report_id and a.report_id NOT IN 'IPBBKSLP' order by 2 ";
			}else
				{
				sqlString = "select a.report_id report_id, b.report_desc report_desc, 1 no_of_copies, a.module_id from ip_online_report a, sm_report_lang_vw b  where  b.language_id='"+locale+"' and a.module_id = 'IP' and b.internal_request_yn='Y' and a.facility_id='"+facilityId+"' and a.print_on_booking_yn='Y' and a.nursing_unit_code ='"+nursing_unit+"'  and a.report_id = b.report_id and a.report_id NOT IN  'IPBKSVIP' order by 2 ";
				}
				dest_locn_type = "N";
			}
			else
				sqlString = "select b.report_id report_id, b.report_desc report_desc, 1 no_of_copies, b.module_id from sm_report_lang_vw b where b.language_id='"+locale+"' and module_id = 'IP' and report_id = 'IPBBKSLP'";
				
			

			reportParamNames			= "P_BKG_LST_REF_NO";
			reportParamValues			= ""+bkglstrefno+"";
			StringBuffer htmlFor = new StringBuffer();
			if (!patientid.equals(""))
				Patient_param = "&Patient_ID="+patientid;
			/*htmlFor.append(" <html><head> <link rel='stylesheet' type ='text/css' href='../eCommon/html/"+sStyle+"'></link>");
			htmlFor.append("</head><body class='message'>");
			htmlFor.append("<script language = 'JavaScript'>") ;
			htmlFor.append("async function callInternalReportsPrint() {") ;*/
			htmlFor.append(" var dialogHeight = '50vh' ;");
			htmlFor.append(" var dialogWidth = '55vw' ;");
			htmlFor.append(" var dialogTop = '0vh';" );
			htmlFor.append(" var arguments = ''; ");
			
			// modified the below line by Abirami - Bru-HIMS-CRF-313 / Passing function id in the below Query String.
			htmlFor.append(" var getUrl =  '../../eCommon/jsp/InternalReportsPrint.jsp?P_function_id=IP_BOOKING&step=1&sqlString="+java.net.URLEncoder.encode(sqlString)+Patient_param+"&dest_locn_type="+dest_locn_type+"&dest_locn_code="+nursing_unit+"&reportParamNames="+reportParamNames+"&reportParamValues="+reportParamValues+"';");
			//htmlFor.append("  var getUrl        =   '../eCommon/jsp/InternalReportsPrint.jsp?step=1&sqlString="+java.net.URLEncoder.encode(sqlString)+Patient_param+"&dest_locn_type="+dest_locn_type+"&dest_locn_code="+nursing_unit+"&reportParamNames="+reportParamNames+"&reportParamValues="+reportParamValues+"';");
			htmlFor.append(" var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; status=no;' ;");
			htmlFor.append(" retVal = await window.showModalDialog(getUrl,arguments,features); ");
			/*htmlFor.append(" } callInternalReportsPrint();"  );
			htmlFor.append(" </script>"  );*/
			
			out.println(htmlFor.toString());
			
			if(call_function.equals("CA_Clinician_IP_Booking"))
			{
				out.println("alert('"+error+"');");
				/*out.println("parent.window.close();");
				out.println("</script>");*/
				out.println("parent.document.getElementById('dialog_tag').close();");
			}
			else if(call_function.equals("IP_Booking"))
			{
				if(is_op_pending_referral_booking.equals("Y"))
				{
					out.println("alert('"+error+"');");
					/*out.println("parent.window.close();");
					out.println("</script>");*/
					out.println("parent.document.getElementById('dialog_tag').close();");
				}
				else
				{		
					out.println("parent.frames[2].location.href='../eCommon/jsp/error.jsp?err_num="+java.net.URLEncoder.encode(error, "UTF-8")+"&err_value=1';");
				}

			}
			else if(call_function.equals("OA_IP_Booking"))
			{
				out.println("alert('"+error+"');");
				/*out.println("parent.window.close();");
				out.println("</script>");*/
				out.println("parent.document.getElementById('dialog_tag').close();");
			}
			else if(call_function.equals("CA_Task_IP_Booking")||call_function.equals("OT"))
			{
				out.println("alert('"+error+"');");
				/*out.println("parent.window.close();");
				out.println("</script>");*/
				out.println("parent.document.getElementById('dialog_tag').close();");
			}
			//out.println("</script>");
		}
		catch ( Exception e )
		{
			e.printStackTrace() ;
		}
		finally
		{ 
			if(con!=null) ConnectionManager.returnConnection(con,p);
		}

		
	} 

	public static String checkForNull(String inputString){
		return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
}// E.O.Class
