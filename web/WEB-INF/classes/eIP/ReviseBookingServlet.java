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
import java.util.*;
import java.util.StringTokenizer;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;
import com.ehis.util.*;
import eIP.IPReviseBooking.*;

public class ReviseBookingServlet extends javax.servlet.http.HttpServlet
{
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		try
		{
			doPost(req,res);		
		}
		catch(Exception e)	
		{	
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		
		PrintWriter out			= null;
		java.util.Properties p	= null;
		HttpSession session		= null;
		session					= req.getSession(false);
		String facilityId		= "";
		String patientid		= "";
		String multi_book_pat_yn= "N";
		String patientclasscode	= "";
		String specilitycode	= "";
		String preferreddate	= "";
		String bedclasscode		= "";
		String nursingunitcode	= "";
		String locale			= "" ;
		p						= (java.util.Properties) session.getValue("jdbc");
		facilityId				= (String) session.getValue("facility_id");
		
		try	
		{
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			out					= res.getWriter();
			locale				= p.getProperty("LOCALE");
			patientid			= checkForNull(req.getParameter("patient_id"));
			multi_book_pat_yn	= checkForNull(req.getParameter("multi_book_pat_yn"));
			patientclasscode	= checkForNull(req.getParameter("patientclasscode"));
			specilitycode       = checkForNull(req.getParameter("Splcode1"));
			preferreddate  		= checkForNull(req.getParameter("pref_adm_date"));
			preferreddate		= DateUtils.convertDate(preferreddate,"DMYHM",locale,"en");
			
			String bclasscode	= checkForNull(req.getParameter("bclasscode"));
			if( (bclasscode == null) ||  ( bclasscode.equals("")) )
				bedclasscode    = checkForNull(req.getParameter("bed_class_desc"));
			else
				bedclasscode    = bclasscode;
			String nunitcode	= checkForNull(req.getParameter("nunitcode"));
			if( (nunitcode == null) ||  ( nunitcode.equals("")) )
				nursingunitcode = checkForNull(req.getParameter("nursing_unit"));
			else
				nursingunitcode = nunitcode;

		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		Connection con			=	null;
		boolean proceed			= true;
		Statement entitle_stmt	= null;
		PreparedStatement entitle_pstmt = null;
		ResultSet entitle_rs	= null;
		String status			= "";
		String msg				= "";
		String entitlement_by_pat_cat_yn = "";

		if(!patientid.equals("")) 
		{
			try
			{
				con				= ConnectionManager.getConnection(p);
				
				entitle_stmt	= con.createStatement();
				entitle_rs		= entitle_stmt.executeQuery("select entitlement_by_pat_cat_yn from MP_PARAM where module_id = 'MP'") ;
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
					entitle_pstmt.setString(2,preferreddate);
					entitle_pstmt.setString(3,facilityId);
					entitle_pstmt.setString(4,"N");
					entitle_pstmt.setString(5,nursingunitcode);
					entitle_pstmt.setString(6,patientclasscode);
					entitle_pstmt.setString(7,specilitycode);
					entitle_pstmt.setString(8,bedclasscode);

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
					out.println("<script>alert('"+msg+"');</script>");
					out.println("<script>parent.window.close();</script>");

					message.clear();
				}
				else if(status.equals("2"))
				{
					proceed = false;
					java.util.Hashtable message = MessageManager.getMessage(locale,"LOC_NOT_ENTITLED","MP");
					msg = ((String) message.get("message"));
					if(msg.lastIndexOf("<br>") >= 0)
						msg=msg.substring(0,msg.lastIndexOf("<br>"));
					out.println("<script>alert('"+msg+"');</script>");
					out.println("<script>parent.window.close();</script>");

					message.clear();
				}
				else if(status.equals("3"))
				{
					proceed = false;
					java.util.Hashtable message = MessageManager.getMessage(locale,"SPL_NOT_ENTITLED","MP");
					msg = ((String) message.get("message"));
					if(msg.lastIndexOf("<br>") >= 0)
						msg=msg.substring(0,msg.lastIndexOf("<br>"));
					out.println("<script>alert('"+msg+"');</script>");
					out.println("<script>parent.window.close();</script>");
					message.clear();
				}
				else if(status.equals("4"))
				{
					proceed = false;
					java.util.Hashtable message = MessageManager.getMessage(locale,"BDCL_NOT_ENTITLED","MP");
					msg = ((String) message.get("message"));
					if(msg.lastIndexOf("<br>") >= 0)
						msg=msg.substring(0,msg.lastIndexOf("<br>"));
					out.println("<script>alert('"+msg+"');</script>");
					out.println("<script>parent.window.close();</script>");
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
			
			insertReviseBooking(req, res);
		}
	}//E.O.doPost

	private void insertReviseBooking(HttpServletRequest req, HttpServletResponse res)throws java.io.IOException
	{
		PrintWriter out				= null;
		java.util.Properties p		= null;
		HttpSession session			= null;
		session						= req.getSession(false);
		String facilityId			= "";
		String patientid			= "";
		String multi_book_pat_yn	= "N";
		String patientclasscode		= "";
		String specilitycode		= "";
		String preferreddate		= "";
		String bedclasscode			= "";
		String nursingunitcode		= "";
		String locale				= "" ;
		//Maheshwaran K added for the CRF : RUT-CRF-0012 (23395	) as on 28/01/2013
		//Start
		String surgery_order_code="";
		String surgery_order="";
		String surgery_order_id="";
		String surgery_order_line_no="";
		String surgery_order_date="";
		//End
		p							= (java.util.Properties) session.getValue("jdbc");
		facilityId					= (String) session.getValue("facility_id");
		out							= res.getWriter();
		locale						= p.getProperty("LOCALE");
		patientid					= checkForNull(req.getParameter("patient_id"));
		multi_book_pat_yn			= checkForNull(req.getParameter("multi_book_pat_yn"));
		patientclasscode			= checkForNull(req.getParameter("patientclasscode"));
		specilitycode				= checkForNull(req.getParameter("Splcode1"));
		preferreddate  				= checkForNull(req.getParameter("pref_adm_date"));
		preferreddate				= DateUtils.convertDate(preferreddate,"DMYHM",locale,"en");
		String chk_booking_limit_by	= checkForNull(req.getParameter("chk_booking_limit_by"));
		String bclasscode			= checkForNull(req.getParameter("bclasscode"));
			if( (bclasscode == null) ||  ( bclasscode.equals("")) )
				bedclasscode		= checkForNull(req.getParameter("bed_class_desc"));
			else
				bedclasscode		= bclasscode;
			String nunitcode		= checkForNull(req.getParameter("nunitcode"));
			if( (nunitcode == null) ||  ( nunitcode.equals("")) )
				nursingunitcode		= checkForNull(req.getParameter("nursing_unit"));
			else
				nursingunitcode		= nunitcode;
		Connection con				= null;
		PreparedStatement book_pstmt= null;
		Statement         book_stmt=null;// code added  by  munisekhar for [IN:048232] 
		ResultSet book_rs			= null;
		
		String msg				= "";// code added  by  munisekhar for [IN:048232] 
		String bedno				= "";
		String roomno				= "";
		String generatenumyn 		= "";
		String expdaysofstay		= "";
		String priority				= "";
		String nationalidno			= "";
		String medical_team			= "";
		String amb_date_time		= "";
		String bkglstrefno			= "";
		String medsergrpcode		= "";
		String oldpreferreddate		= "";
		String altid1no				= "";
		String altid1expdate		= "";
		String nameprefix			= "";
		String firstname			= "";
		String secondname			= "";
		String thirdname			= "";
		String familyname			= "";
		String namesuffix			= "";
		String patientname			= "";
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
		String practitionerid		= ""; 
		String chiefcomplaint		= "";
		String otdatetime			= "";
		String oldbedno				= "";
		String bedtypecode			= "";
		String nursingunittypecode	= "";
		String bookedbyid			= "";
		String modifiedDate			= "";
		String expected_discharge_date	= "";
		String service_code			= "";
		String overrideyn			= "";
		String blood_donation_yn	= "";
		String ambulance_reqd_yn	= "";
		String reason_for_revision_code = "";
		String gender				= "";
		String bno					= "";
		String rno					= "";
		String isBlInstalled		= "";
		String billing_interfaced	= "";
		String iscapture_fin_dtls_yn= "";
		String booking_remarks      = "";
		String booking_Type_Code    = "";
		String billing_group		= "";
		String episodestatus		= "0";
		/*Added by Thamizh selvi on 31st Jan 2018 against ML-MMOH-CRF-0601 Start*/
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
		//Ends

		generatenumyn 				= checkForNull(req.getParameter("generatenumyn"));
		expdaysofstay				= checkForNull(req.getParameter("exp_days_of_stay"));
		priority					= checkForNull(req.getParameter("priority"));
		nationalidno				= checkForNull(req.getParameter("national_id"));
		medical_team				= checkForNull(req.getParameter("team_id"));
		amb_date_time				= checkForNull(req.getParameter("amb_reqd_date_time"));
		bkglstrefno					= checkForNull(req.getParameter("booking_ref_no"));
		medsergrpcode				= req.getParameter("med_service_grp");
		TreeMap patInstructionsMap=(java.util.TreeMap)session.getAttribute("ipPatInstructionsMap");//included for the CRF - RUT-CRF-013 23396 
		ArrayList patInstructionsList=new ArrayList();
		if (patInstructionsMap != null){
			Iterator it=patInstructionsMap.keySet().iterator();
			while(it.hasNext()){
				Integer key=(Integer)it.next();
				String mapValue=(String)patInstructionsMap.get(key);			
				patInstructionsList.add(mapValue);
			}
		}		
		StringTokenizer token = new StringTokenizer(medsergrpcode, "#");
		if (token.hasMoreTokens())
			medsergrpcode=checkForNull(token.nextToken());
		
		oldpreferreddate			= checkForNull(req.getParameter("old_pref_adm_date"));
		altid1no					= checkForNull(req.getParameter("alternate_id"));
		altid1expdate				= checkForNull(req.getParameter("altid1expdate"));
		altid1expdate				= DateUtils.convertDate(altid1expdate,"DMY",locale,"en");
		//String nameprefix			= checkForNull(req.getParameter("name_prefix1"));
		nameprefix					= checkForNull(req.getParameter("name_prefix"));
		firstname					= checkForNull(req.getParameter("first_name"));
		secondname					= checkForNull(req.getParameter("second_name"));
		thirdname					= checkForNull(req.getParameter("third_name"));
		familyname					= checkForNull(req.getParameter("family_name"));
		//String namesuffix			= checkForNull(req.getParameter("name_suffix1"));
		namesuffix					= checkForNull(req.getParameter("name_suffix"));
		
		patientname					= checkForNull(req.getParameter("patient_name"));
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
		practitionerid				= checkForNull(req.getParameter("practid1"));
		chiefcomplaint				= checkForNull(req.getParameter("complaintcode"));
		otdatetime					= checkForNull(req.getParameter("ot_date_time"));
		otdatetime					= DateUtils.convertDate(otdatetime,"DMYHM",locale,"en");
		//String service_code		= checkForNull(req.getParameter("service"));
		//String oldnursingunit		= checkForNull(req.getParameter("old_nursing_unit"));
		oldbedno					= checkForNull(req.getParameter("old_bed_no"));
		bedtypecode					= checkForNull(req.getParameter("bed_type_desc"));
		nursingunittypecode			= checkForNull(req.getParameter("nursingunittypecode"));
		bookedbyid					= checkForNull(req.getParameter("bookedbyid"));
		modifiedDate				= checkForNull(req.getParameter("modifiedDate"));
		expected_discharge_date		= checkForNull(req.getParameter("exp_discharge_date"));
		expected_discharge_date					= DateUtils.convertDate(expected_discharge_date,"DMYHM",locale,"en");
		service_code				= checkForNull(req.getParameter("service_desc"));
				
		overrideyn					= checkForNull(req.getParameter("override_yn"));
		if (overrideyn == null ||overrideyn =="" ||overrideyn.equals("")) overrideyn ="N";
		/*Added by Thamizh selvi on 31st Jan 2018 against ML-MMOH-CRF-0601 Start*/
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
		blood_donation_yn			= req.getParameter("blood_donation_yn");
		if (blood_donation_yn == null )   
			blood_donation_yn ="N";
		else
			blood_donation_yn ="Y";

		ambulance_reqd_yn			= req.getParameter("amb_reqd_yn");
		if (ambulance_reqd_yn == null )   
			ambulance_reqd_yn ="N";
		else
			ambulance_reqd_yn ="Y";

		reason_for_revision_code	= checkForNull(req.getParameter("rev_hid"));
		
		gender						= checkForNull(req.getParameter("sex"));
		if (	gender == null || gender == "" || gender.equals(""))
			 gender="M";

		bno							= checkForNull(req.getParameter("bno"));
		if( (bno==null) || (bno.equals("")) )
			bedno					= checkForNull(req.getParameter("bed_no"));
		else
			bedno					= bno;
		
		rno							= checkForNull(req.getParameter("rno"));
		if( (rno == null) ||  ( rno.equals("")) )
			roomno					= checkForNull(req.getParameter("room_no"));
		else
			roomno					= rno;

		
		isBlInstalled				= checkForNull(req.getParameter("isBlInstalled"));
		billing_interfaced			= checkForNull(req.getParameter("isBlInterfaced"));
		iscapture_fin_dtls_yn		= checkForNull(req.getParameter("iscapture_fin_dtls_yn"));
		booking_remarks				= checkForNull(req.getParameter("booking_remarks"));
		booking_Type_Code			= checkForNull(req.getParameter("booking_Type_Code"));
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
				billing_group		= checkForNull(req.getParameter("billing_group"));
			}
	
		/*SRR20056-SCF-3859 IN016433 Friday, November 20, 2009*/
		String bed_booking_ref_no   = "";
		boolean proceed = true;
			if(bedno!=null && !bedno.equals(""))
			{
				try
				{
					con = ConnectionManager.getConnection(p);
				
					//book_pstmt	=	con.prepareStatement("select Count(*) no_of_record from ip_bed_booking where booking_status  in ('0','1')  and facility_id = ? and req_nursing_unit_code = ? and req_bed_no = ? AND blocked_from_date_time > SYSDATE AND ((blocked_from_date_time BETWEEN    TO_DATE(?, 'DD/MM/YYYY HH24:MI')    AND TO_DATE(?, 'DD/MM/YYYY HH24:MI')) OR (blocked_until_date_time BETWEEN    TO_DATE(?, 'DD/MM/YYYY HH24:MI') AND TO_DATE(?, 'DD/MM/YYYY HH24:MI')) OR  ( blocked_from_date_time <= TO_DATE(?,'DD/MM/YYYY HH24:MI') and blocked_until_date_time >= TO_DATE(?,'DD/MM/YYYY HH24:MI')))");
					/*Tuesday, December 08, 2009 17016 & IN016433 (beta-reopen)*/
					book_pstmt	=	con.prepareStatement("select bed_booking_ref_no from ip_bed_booking where booking_status  in ('0','1')  and facility_id = ? and req_nursing_unit_code = ? and req_bed_no = ? AND blocked_from_date_time > SYSDATE AND ((blocked_from_date_time BETWEEN    TO_DATE(?, 'DD/MM/YYYY HH24:MI')    AND TO_DATE(?, 'DD/MM/YYYY HH24:MI')) OR (blocked_until_date_time BETWEEN    TO_DATE(?, 'DD/MM/YYYY HH24:MI') AND TO_DATE(?, 'DD/MM/YYYY HH24:MI')) OR  ( blocked_from_date_time <= TO_DATE(?,'DD/MM/YYYY HH24:MI') and blocked_until_date_time >= TO_DATE(?,'DD/MM/YYYY HH24:MI')))");

					book_pstmt.setString(1,facilityId);
					book_pstmt.setString(2,nursingunitcode);
					book_pstmt.setString(3,bedno);
					book_pstmt.setString(4,preferreddate);
					book_pstmt.setString(5,expected_discharge_date);
					book_pstmt.setString(6,preferreddate);
					book_pstmt.setString(7,expected_discharge_date);
					book_pstmt.setString(8,preferreddate);
					book_pstmt.setString(9,expected_discharge_date);
					book_rs		=	book_pstmt.executeQuery();

					if(book_rs.next())
					{
							bed_booking_ref_no				= book_rs.getString(1);						
					
					
						if(!bed_booking_ref_no.equals(bkglstrefno))
						{
							proceed = false;	
									
							java.util.Hashtable message = MessageManager.getMessage(locale,"OVERLAP_BLOCK_TIME","IP");
							String Msg = ((String) message.get("message"));
							out.println("<script>alert('"+Msg+"');parent.window.close();</script>");
							message.clear();
						}
						else
						{
							proceed = true;
						}
					}
					else
					{
						proceed = true;
					}
					if(book_rs !=null) book_rs.close(); 
					if(book_pstmt != null) book_pstmt.close();
					
				
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
				//Commented for Checkstyle
				//finally
				//{
					//if(con!=null) ConnectionManager.returnConnection(con,p);
				//}
			}
		          // code added  by  munisekhar for [IN:048232] 
					int count = 0;
					if(chk_booking_limit_by.equals("2") && !bedclasscode.equals(""))
					{ try{
					   //con = ConnectionManager.getConnection(p);//Commented for Checkstyle
						book_stmt = con.createStatement();
						book_rs = book_stmt.executeQuery(" SELECT count(*) FROM IP_BOOK_LIMIT_BY_AGE_GRP WHERE facility_id='"+facilityId+"' AND bed_class_code = '"+bedclasscode+"' AND age_group_code IN (SELECT age_group_code FROM AM_AGE_GROUP where NVL(GENDER,'"+gender+"') = '"+gender+"' AND trunc(SYSDATE) - TRUNC(TO_DATE('"+dateofbirth+"','DD/MM/YYYY')) BETWEEN DECODE(AGE_UNIT,'Y',365,'M',30,1) * MIN_AGE AND DECODE(AGE_UNIT,'Y',365,'M',30,1) * MAX_AGE ) ");

						if(book_rs.next())
						{
							count = book_rs.getInt(1);
						}
						if(book_rs != null) book_rs.close();
						if(book_stmt != null) book_stmt.close();

						if(count > 0)
						{
							proceed = true;
						}
						else
						{
							proceed = false;
							java.util.Hashtable message = MessageManager.getMessage(locale,"AGR_GRP_BOOKING_LT_SETUP","IP");
							msg = ((String) message.get("message"));
							out.println("<script>alert('"+msg+"');</script>");
							message.clear();
							out.println("<Script>parent.frames(2).location.href='../eCommon/jsp/error.jsp?&err_num='; </Script>");
						}
					}catch (Exception e)
				{
					e.printStackTrace();
				}
				finally
				{
					if(con!=null) ConnectionManager.returnConnection(con,p);
				}
				}
				//  end of   [IN:048232] 
		if(proceed)
		{
		/**/
		try 
				{

			String error = "";
			String overrideMessage				= "";
			HashMap hashData = new HashMap();
			hashData.put("facilityId",facilityId);
			hashData.put("generatenumyn",generatenumyn);
			hashData.put("expdaysofstay",expdaysofstay);
			hashData.put("priority",priority);
			hashData.put("medical_team",medical_team);
			hashData.put("blood_donation_yn",blood_donation_yn);
			hashData.put("ambulance_reqd_yn",ambulance_reqd_yn);
			hashData.put("amb_date_time",amb_date_time);
			hashData.put("bkglstrefno",bkglstrefno);
			hashData.put("medsergrpcode",medsergrpcode);
			hashData.put("preferreddate",preferreddate);
			hashData.put("patientid",patientid);
			hashData.put("multi_book_pat_yn",multi_book_pat_yn);
			hashData.put("nameprefix",nameprefix);
			hashData.put("firstname",firstname);
			hashData.put("secondname",secondname);
			hashData.put("thirdname",thirdname);
			hashData.put("familyname",familyname);
			hashData.put("namesuffix",namesuffix);
			hashData.put("patientname",patientname);
			hashData.put("gender",gender);
			hashData.put("dateofbirth",dateofbirth);
			hashData.put("restelno",restelno);
			hashData.put("othcontactno",othcontactno);
			hashData.put("emailid",emailid);
			hashData.put("nationalidno",nationalidno);
			hashData.put("altid1no",altid1no);
			hashData.put("resaddrline1",resaddrline1);
			hashData.put("resaddrline2",resaddrline2);
			hashData.put("resaddrline3",resaddrline3);
			hashData.put("resaddrline4",resaddrline4);
			hashData.put("postalcode",postalcode);
			hashData.put("countrycode",countrycode);
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
			hashData.put("patientclasscode",patientclasscode);
			hashData.put("specilitycode",specilitycode);
			hashData.put("practitionerid",practitionerid);
			hashData.put("chiefcomplaint",chiefcomplaint);
			hashData.put("otdatetime",otdatetime);
			hashData.put("overrideyn",overrideyn);
			hashData.put("bedclasscode",bedclasscode);
			hashData.put("bedtypecode",bedtypecode);
			hashData.put("nursingunitcode",nursingunitcode);
			hashData.put("nursingunittypecode",nursingunittypecode);
			hashData.put("roomno",roomno);
			hashData.put("bedno",bedno);
			hashData.put("bookedbyid",bookedbyid);
			hashData.put("client_ip_address",p.getProperty("client_ip_address"));
			hashData.put("oldbedno",oldbedno);
			//hashData.put("oldnursingunit",oldnursingunit);
			hashData.put("oldpreferreddate",oldpreferreddate);
			hashData.put("service_code",service_code);
			hashData.put("altid1expdate",altid1expdate);
			hashData.put("reason_for_revision_code",reason_for_revision_code);
			hashData.put("modifiedDate",modifiedDate);
			hashData.put("expected_discharge_date",expected_discharge_date);

			//new billing parameter should be passed for billing interface

			hashData.put("isBlInstalled",isBlInstalled);   
			hashData.put("billing_interfaced",billing_interfaced);
			hashData.put("billing_group",billing_group);   
			hashData.put("episodestatus",episodestatus); 
			//hashData.put("visitid",visitid+""); 
			hashData.put("iscapture_fin_dtls_yn",iscapture_fin_dtls_yn); 
			hashData.put("booking_remarks",booking_remarks);
			hashData.put("booking_Type_Code",booking_Type_Code);
			//Maheshwaran K added for the CRF : RUT-CRF-0012 (23395	) as on 28/01/2013
			//Start
			hashData.put("surgery_order_code",surgery_order_code);
			hashData.put("surgery_order",surgery_order);
			hashData.put("surgery_order_id",surgery_order_id);
			hashData.put("surgery_order_line_no",surgery_order_line_no);
			hashData.put("surgery_order_date",surgery_order_date);
			//End
			/*Added by Thamizh selvi on 31st Jan 2018 against ML-MMOH-CRF-0601 Start*/
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
			//Maheshwaran K added for AAKH-CRF-0175 as on 23-08-2023
			hashData.put("smartCardFunc",checkForNull(req.getParameter("smartCardFunc")));
			biometric_reason = checkForNull((String) session.getValue( "biometric_reason" ));
			hashData.put("biometric_reason",biometric_reason);
			if(!biometric_reason.equals("")){
			session.removeAttribute("biometric_reason");
			}

			//Ends

			HashMap fin_dtls=(HashMap)session.getAttribute("financial_details");
						
			if(fin_dtls!=null)
			{
				hashData.put("fin_dtls",(HashMap)fin_dtls);	
			}
			hashData.put("block_bed_based_on",checkForNull(req.getParameter("block_bed_based_on")));
			hashData.put("patInstructions",patInstructionsList);//included for the CRF -RUT CRF 23396
			boolean local_ejbs	= false;
			
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/IPReviseBooking",IPReviseBookingHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			
			Object argArray[] = new Object[2];
			argArray[0] = p;
			argArray[1] = hashData;
			
			Class [] paramArray = new Class[2];
			paramArray[0] = p.getClass();
			paramArray[1] = hashData.getClass();
		
		    
			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insertIPReviseBooking",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
				
			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			error = (String) results.get("error") ;
			overrideMessage = (String) results.get("overrideMessage") ;
			if(overrideMessage == null) overrideMessage = "";
			
			results.clear();
			hashData.clear();
			if(fin_dtls!=null)
				fin_dtls.clear();

			if(error.indexOf("<br>")!=-1)
				error = error.substring(0,error.indexOf("<br>"));
				
			
				if ( inserted )
				{
					if(!(overrideMessage.equals("")))
					{
						error = overrideMessage + "\\n" +error;
						out.println("<script>alert('"+error+"'); parent.parent.window.close();</script>");
					}else
					{
						out.println("<script>alert('"+error+"'); parent.parent.window.close();</script>");
					}
					session.removeAttribute("financial_details"); 					
					session.removeAttribute("ipPatInstructionsMap");//included for the CRF - RUT-CRF-013 - 23396

				}
				else
				{
					
					if(error.indexOf("Exception") == -1)
					{
						out.println("<script>parent.frames[0].document.forms[0].apply.disabled = false;</script>");
					}
					res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=1" );
				}				
	
			} 
			catch ( Exception e )
			{
				e.printStackTrace();
			}
		}
	}//e.o.insert Method

	public static String checkForNull(String inputString){
		return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
	}
}// E.O.Class
