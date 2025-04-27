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
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;
import eIP.IPConfirmBooking.*;
import com.ehis.util.*;

public class ConfirmBookingServlet extends javax.servlet.http.HttpServlet
{
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		PrintWriter out			= null;
		java.util.Properties p	= null;
		String sStyle			= "";
		String facilityId		= "";
		String patientid		= "";
		String multi_book_pat_yn= "N";
		String locale			= "" ;
		String preferreddate    = "";
		HttpSession session		= null;
		session					= req.getSession(false);
		p						= (java.util.Properties) session.getValue( "jdbc" ) ;
		facilityId				= (String) session.getValue( "facility_id" ) ;
		sStyle					= checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
		locale					= p.getProperty("LOCALE");
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		out						= res.getWriter();
		patientid				= checkForNull(req.getParameter("patient_id"));
		multi_book_pat_yn		= checkForNull(req.getParameter("multi_book_pat_yn"));
		String nursingunitcode	= "";
		String bedclasscode		= "";
		String bclasscode		= "";
		String nunitcode		= "";
		String chk_booking_limit_by = "";
		String gender			= "";
		String dateofbirth		= "";
		bclasscode				= checkForNull(req.getParameter("bclasscode"));
		if( (bclasscode == null) ||  ( bclasscode.equals("")) )
			bedclasscode		= checkForNull(req.getParameter("Bedcode"));
		else
			bedclasscode		= checkForNull(bclasscode);

		nunitcode				= checkForNull(req.getParameter("nunitcode"));
		if( (nunitcode == null) ||  ( nunitcode.equals("")) )
			nursingunitcode		= checkForNull(req.getParameter("nursing_unit"));
		else
			nursingunitcode		= checkForNull(nunitcode);

		preferreddate  			= checkForNull(req.getParameter("pref_adm_date"));
		preferreddate			= DateUtils.convertDate(preferreddate,"DMYHM",locale,"en");

		chk_booking_limit_by	= checkForNull(req.getParameter("chk_booking_limit_by"));

		gender					= checkForNull(req.getParameter("sex"));

		dateofbirth				= checkForNull(req.getParameter("date_of_birth"));
		dateofbirth				= DateUtils.convertDate(dateofbirth,"DMY",locale,"en");

		//String qryString 		= checkForNull(req.getParameter("queryString"));



		Connection con			=	null;
		boolean proceed			= true;
		Statement entitle_stmt	= null;
		Statement Stmt			= null;
		PreparedStatement entitle_pstmt		= null;
		ResultSet entitle_rs	= null;
		ResultSet bl_rs			= null;
		String status			= "";
		String msg				= "";
		String entitlement_by_pat_cat_yn	= "";
		Statement booking_lt_stmt			= null;
		ResultSet booking_lt_rs	= null;
		Double diff				= 0.0;
		Double chkval			= 0.0;
		StringBuffer sbSql		= new StringBuffer();


		try
		{
			con = ConnectionManager.getConnection(p);
			// code changed by Vedesh A D for Edge Conversion
    		out.println("<!DOCTYPE html><head><link rel='stylesheet' type='text/css' href='../eCommon/html/"+sStyle+"'></link>");
    		out.println("<script src='../eCommon/js/showModalDialog.js' language='JavaScript'></script><script language='JavaScript'>");
    		out.println("async function confirmBookingHTML() { ");
			if(!patientid.equals(""))
			{
					entitle_stmt = con.createStatement();
					entitle_rs = entitle_stmt.executeQuery("select entitlement_by_pat_cat_yn from MP_PARAM where module_id = 'MP'") ;
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
						entitle_pstmt.setString(6,checkForNull(req.getParameter("PatClass")));
						entitle_pstmt.setString(7,checkForNull(req.getParameter("Splcode1")));
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
					/*out.println("<script>alert('"+msg+"');</script>");
					out.println("<script>parent.window.close();</script>");*/
					out.println("alert('"+msg+"');");
					out.println("parent.window.close();");
					message.clear();
				}
				else if(status.equals("2"))
				{
					proceed = false;
					java.util.Hashtable message = MessageManager.getMessage(locale,"LOC_NOT_ENTITLED","MP");
					msg = ((String) message.get("message"));
					if(msg.lastIndexOf("<br>") >= 0)
						msg=msg.substring(0,msg.lastIndexOf("<br>"));
					/*out.println("<script>alert('"+msg+"');</script>");
					out.println("<script>parent.window.close();</script>");*/
					out.println("alert('"+msg+"');");
					out.println("parent.window.close();");
					message.clear();
				}
				else if(status.equals("3"))
				{
					proceed = false;
					java.util.Hashtable message = MessageManager.getMessage(locale,"SPL_NOT_ENTITLED","MP");
					msg = ((String) message.get("message"));
					if(msg.lastIndexOf("<br>") >= 0)
						msg=msg.substring(0,msg.lastIndexOf("<br>"));
					/*out.println("<script>alert('"+msg+"');</script>");
					out.println("<script>parent.window.close();</script>");*/
					out.println("alert('"+msg+"');");
					out.println("parent.window.close();");
					message.clear();
				}
				else if(status.equals("4"))
				{
					proceed = false;
					java.util.Hashtable message = MessageManager.getMessage(locale,"BDCL_NOT_ENTITLED","MP");
					msg = ((String) message.get("message"));
					if(msg.lastIndexOf("<br>") >= 0)
						msg=msg.substring(0,msg.lastIndexOf("<br>"));
					/*out.println("<script>alert('"+msg+"');</script>");
					out.println("<script>parent.window.close();</script>");*/
					out.println("alert('"+msg+"');");
					out.println("parent.window.close();");
					message.clear();
				}

			}

			// Finaance Details should not clear For 15632

				Stmt = con.createStatement();
				if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
				sbSql.append("select setup_bl_dtls_in_ip_yn, TO_CHAR(TO_DATE('"+preferreddate+"','dd/mm/rrrr hh24:mi')+((1/(24*60))*60*bed_block_period_normal),'dd/mm/rrrr hh24:mi') bed_block_period_normal , (TO_DATE('"+preferreddate+"','dd/mm/rrrr HH24:MI')-SYSDATE) diff, sign((sysdate+nvl(ADV_BED_BOOK_PERIOD_BKG,0)-(trunc(to_date('"+preferreddate+"','dd/mm/rrrr hh24:mi'))))) valid_flag, nvl(bkg_grace_period,0) bkg_grace_period, chk_booking_limit_by from ip_param where facility_id='"+facilityId+"' ");
				bl_rs = Stmt.executeQuery(sbSql.toString());
				if(bl_rs!=null )
				{
					while(bl_rs.next())
					{
						diff						= bl_rs.getDouble("diff");
						chkval						= bl_rs.getDouble("valid_flag");
					}
					if(bl_rs != null)bl_rs.close();
					if(Stmt != null)Stmt.close();
				}

				if(chkval > 0)
				{
					proceed = true;
				}
				else
			   {
					proceed = false;
					java.util.Hashtable message = MessageManager.getMessage( locale, "PREFER_DATE_LT_EXCEEDED" ,"IP");
					msg = ((String) message.get("message"));
					message.clear();
					/*out.println("<Script>parent.frames[1].enableField();parent.frames[1].document.confirmbooking_form.pref_adm_date.disabled = false ;</Script>");
					out.println("<Script>parent.frames[2].location.href='../eCommon/jsp/error.jsp?err_num="+java.net.URLEncoder.encode(msg, "UTF-8")+"&err_value=0'; </Script>");*/
					out.println("parent.frames[1].enableField();parent.frames[1].document.confirmbooking_form.pref_adm_date.disabled = false ;");
					out.println("parent.frames[2].location.href='../eCommon/jsp/error.jsp?err_num="+java.net.URLEncoder.encode(msg, "UTF-8")+"&err_value=0'; ");
       			}

				if(diff > 0)
				{
					proceed = true;
				}
				else
			     {
					proceed = false;
					java.util.Hashtable message = MessageManager.getMessage( locale, "PREF_ADMDATE_NOT_LESS_SYSDATE","IP" );
			  		msg = ((String) message.get("message"));
					message.clear();
					/*out.println("<Script>parent.frames[1].enableField();parent.frames[1].document.confirmbooking_form.pref_adm_date.disabled = false ;</Script>");
					out.println("<Script>parent.frames[2].location.href='../eCommon/jsp/error.jsp?err_num="+java.net.URLEncoder.encode(msg, "UTF-8")+"&err_value=0'; </Script>");*/
					out.println("parent.frames[1].enableField();parent.frames[1].document.confirmbooking_form.pref_adm_date.disabled = false ;");
					out.println("parent.frames[2].location.href='../eCommon/jsp/error.jsp?err_num="+java.net.URLEncoder.encode(msg, "UTF-8")+"&err_value=0'; ");
			     }
// end 15632
			int count = 0;
			if(chk_booking_limit_by.equals("2") && !bedclasscode.equals(""))
			{

				booking_lt_stmt = con.createStatement();
				booking_lt_rs = booking_lt_stmt.executeQuery(" SELECT count(*) FROM IP_BOOK_LIMIT_BY_AGE_GRP WHERE facility_id='"+facilityId+"' AND bed_class_code = '"+bedclasscode+"' AND age_group_code IN (SELECT age_group_code FROM AM_AGE_GROUP where NVL(GENDER,'"+gender+"') = '"+gender+"' AND trunc(SYSDATE) - TRUNC(TO_DATE('"+dateofbirth+"','DD/MM/YYYY')) BETWEEN DECODE(AGE_UNIT,'Y',365,'M',30,1) * MIN_AGE AND DECODE(AGE_UNIT,'Y',365,'M',30,1) * MAX_AGE ) ");

				if(booking_lt_rs.next())
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
					msg = ((String) message.get("message"));
//					out.println("<script>alert('"+msg+"');</script>");
					out.println("alert('"+msg+"');");
					message.clear();
					/*out.println("<Script>parent.frames[1].enableField();</Script>");
					out.println("<Script>parent.frames[2].location.href='../eCommon/jsp/error.jsp?&err_num='; </Script>");*/
					out.println("parent.frames[1].enableField();");
					out.println("parent.frames[2].location.href='../eCommon/jsp/error.jsp?&err_num=';");
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(entitle_rs != null) entitle_rs.close();
				if(entitle_pstmt != null) entitle_pstmt.close();
				if(bl_rs != null)bl_rs.close();
				if(Stmt != null)Stmt.close();
				if(booking_lt_rs != null) booking_lt_rs.close();
				if(booking_lt_stmt != null) booking_lt_stmt.close();
				if(con!=null) ConnectionManager.returnConnection(con,p);
			}
			catch (Exception se)
			{
				se.printStackTrace();
			}
			
			
		}


		if(proceed)
		{
			insertConfirmBooking(req,res,nursingunitcode,bedclasscode);
		}
		out.println("} confirmBookingHTML ();</script></body></html>");	
		out = null;
	}//E.O.doPost

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		try
		{
			doPost(req,res);
		}
		catch(Exception e)	{	e.printStackTrace(); }
	}

	private void insertConfirmBooking(HttpServletRequest req, HttpServletResponse res, String nursingunitcode, String bedclasscode) throws java.io.IOException
	{
		PrintWriter out			= null;
		java.util.Properties p	= null;
		String sStyle			= "";
		String facilityId		= "";
		String patientid		= "";
		String multi_book_pat_yn= "N";
		String locale			= "" ;
		String preferreddate    = "";
		HttpSession session		= null;
		session					= req.getSession(false);
		p						= (java.util.Properties) session.getValue( "jdbc" ) ;
		facilityId				= (String) session.getValue( "facility_id" ) ;
		sStyle					= checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
		locale					= p.getProperty("LOCALE");
		out						= res.getWriter();
		multi_book_pat_yn		= checkForNull(req.getParameter("multi_book_pat_yn"));
		String chk_booking_limit_by	= checkForNull(req.getParameter("chk_booking_limit_by"));
		Connection con			= null;
		PreparedStatement book_pstmt = null;
		ResultSet book_rs		= null;
		
		String bedno			= "";
		String roomno			= "";
		String bkglstrefno		= "";
		String medsergrpcode	= "";
		String bno				= "";
		String rno				= "";
		String call_function	= "";
		String isBlInstalled	= "";
		String expected_discharge_date	= "";
		String billing_interfaced		= "";
		String iscapture_fin_dtls_yn	= "";
		String booking_remarks  = "";
		String booking_Type_Code= "";
		String booking_status	= "";
		//Maheshwaran K added for the CRF : RUT-CRF-0012 (23395	) as on 28/01/2013
		//Start
		String surgery_order_code="";
		String surgery_order="";
		String surgery_order_id="";
		String surgery_order_line_no="";
		String surgery_order_date="";
		//End
		//Maheshwaran K added for AAKH-CRF-0175 as on 23-08-2023
		String smartCardFunc ="";
		String biometric_reason="";
		//Ends
		bkglstrefno				= checkForNull(req.getParameter("booking_ref_no"));
		medsergrpcode			= req.getParameter("med_service_grp");
		TreeMap patInstructionsMap=(java.util.TreeMap)session.getAttribute("ipPatInstructionsMap");//included for the CRF - RUT-CRF-013 23396

		StringTokenizer token	= new StringTokenizer(medsergrpcode, "#");
		if (token.hasMoreTokens())
			medsergrpcode		= checkForNull(token.nextToken());

		bno						= checkForNull(req.getParameter("bno"));
		if( (bno==null) || (bno.equals("")) )
			bedno				= checkForNull(req.getParameter("bed_no"));
		else
			bedno				= checkForNull(bno);

		rno						= checkForNull(req.getParameter("rno"));
		if( (rno == null) ||  ( rno.equals("")) )
			roomno				= checkForNull(req.getParameter("room_no"));
		else
			roomno				= checkForNull(rno);

		call_function			= req.getParameter("call_function");
		//if (	call_function == null )	  call_function ="IP_Booking";
		if (	call_function == null )	  call_function ="IP_ConfirmBooking";
		preferreddate  			= checkForNull(req.getParameter("pref_adm_date"));
		preferreddate			= DateUtils.convertDate(preferreddate,"DMYHM",locale,"en");

		expected_discharge_date	= checkForNull(req.getParameter("exp_discharge_date"));
		expected_discharge_date	= DateUtils.convertDate(expected_discharge_date,"DMYHM",locale,"en");


		isBlInstalled			= checkForNull(req.getParameter("isBlInstalled"));
		billing_interfaced		= checkForNull(req.getParameter("isBlInterfaced"));
		iscapture_fin_dtls_yn	= checkForNull(req.getParameter("iscapture_fin_dtls_yn"));
		patientid				= checkForNull(req.getParameter("patient_id"));
		String billing_group	= "";
		String episodestatus	= "0";
		if(isBlInstalled.equals("Y"))
		{
			billing_group		= checkForNull(req.getParameter("billing_group"));
		}

		booking_remarks         = checkForNull(req.getParameter("booking_remarks"));
		booking_Type_Code       = checkForNull(req.getParameter("booking_Type_Code"));
		booking_status			= checkForNull(req.getParameter("booking_status"));
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
		/*SRR20056-SCF-3859 IN016433 Friday, November 20, 2009*/
		String bed_booking_ref_no= "";
		boolean proceed = true;
			if(bedno!=null && !bedno.equals(""))
			{
				try
				{
					con = ConnectionManager.getConnection(p);
				
					//book_pstmt	=	con.prepareStatement("select Count(*) no_of_record from ip_bed_booking where booking_status  in ('0','1')  and facility_id = ? and req_nursing_unit_code = ? and req_bed_no = ? AND blocked_from_date_time > SYSDATE AND ((blocked_from_date_time BETWEEN    TO_DATE(?, 'DD/MM/YYYY HH24:MI')    AND TO_DATE(?, 'DD/MM/YYYY HH24:MI')) OR (blocked_until_date_time BETWEEN    TO_DATE(?, 'DD/MM/YYYY HH24:MI') AND TO_DATE(?, 'DD/MM/YYYY HH24:MI')) OR  ( blocked_from_date_time <= TO_DATE(?,'DD/MM/YYYY HH24:MI') and blocked_until_date_time >= TO_DATE(?,'DD/MM/YYYY HH24:MI')))");
					/*Tuesday, December 08, 2009 17016 & IN016433 (beta-reopen)*/
					book_pstmt	=	con.prepareStatement("select bed_booking_ref_no from ip_bed_booking where booking_status  in ('0','1')  and facility_id = ? and req_nursing_unit_code = ? and req_bed_no = ? AND BOOKING_TYPE = 'L' and blocked_from_date_time > SYSDATE AND ((blocked_from_date_time BETWEEN    TO_DATE(?, 'DD/MM/YYYY HH24:MI')    AND TO_DATE(?, 'DD/MM/YYYY HH24:MI')) OR (blocked_until_date_time BETWEEN    TO_DATE(?, 'DD/MM/YYYY HH24:MI') AND TO_DATE(?, 'DD/MM/YYYY HH24:MI')) OR  ( blocked_from_date_time <= TO_DATE(?,'DD/MM/YYYY HH24:MI') and blocked_until_date_time >= TO_DATE(?,'DD/MM/YYYY HH24:MI')))");

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
				finally
				{
					if(con!=null) ConnectionManager.returnConnection(con,p);
				}
			}
		if(proceed)
		{
		/**/
		try
		{
			String error				= "";
			HashMap hashData			= new HashMap();

			String otdatetime			= checkForNull(req.getParameter("ot_date_time"));
			otdatetime					= DateUtils.convertDate(otdatetime,"DMYHM",locale,"en");

			String altid1expdate		= checkForNull(req.getParameter("altid1expdate"));
			altid1expdate				= DateUtils.convertDate(altid1expdate,"DMY",locale,"en");

			String date_of_birth		= checkForNull(req.getParameter("date_of_birth"));
			date_of_birth				= DateUtils.convertDate(date_of_birth,"DMY",locale,"en");
			hashData.put("facilityId",facilityId);
			hashData.put("generatenumyn",checkForNull(req.getParameter("generatenumyn")));
			hashData.put("expdaysofstay",checkForNull(req.getParameter("exp_days_of_stay")));
			hashData.put("priority",checkForNull(req.getParameter("priority")));
			hashData.put("medical_team",checkForNull(req.getParameter("team_id")));
			hashData.put("blood_donation_yn",checkForNull(req.getParameter("blood_donation_yn"),"N"));
			hashData.put("ambulance_reqd_yn",checkForNull(req.getParameter("amb_reqd_yn"),"N"));
			hashData.put("amb_date_time",checkForNull(req.getParameter("amb_reqd_date_time")));
			hashData.put("bkglstrefno",bkglstrefno);
			hashData.put("medsergrpcode",medsergrpcode);
			hashData.put("preferreddate",preferreddate);
			hashData.put("patientid",patientid);
			hashData.put("multi_book_pat_yn",multi_book_pat_yn);
			//hashData.put("nameprefix",checkForNull(req.getParameter("name_prefix1")));
			hashData.put("nameprefix",checkForNull(req.getParameter("name_prefix")));
			hashData.put("firstname",checkForNull(req.getParameter("first_name")));
			hashData.put("secondname",checkForNull(req.getParameter("second_name")));
			hashData.put("thirdname",checkForNull(req.getParameter("third_name")));
			hashData.put("familyname",checkForNull(req.getParameter("family_name")));
			//hashData.put("namesuffix",checkForNull(req.getParameter("name_suffix1")));
			hashData.put("namesuffix",checkForNull(req.getParameter("name_suffix")));
			hashData.put("patientname",checkForNull(req.getParameter("patient_name")));
			hashData.put("gender",checkForNull(req.getParameter("sex"),"M"));

			hashData.put("dateofbirth",date_of_birth);
			hashData.put("restelno",checkForNull(req.getParameter("contact1_no")));
			hashData.put("othcontactno",checkForNull(req.getParameter("contact2_no")));
			hashData.put("emailid",checkForNull(req.getParameter("email")));
			hashData.put("nationalidno",checkForNull(req.getParameter("national_id")));
			hashData.put("altid1no",checkForNull(req.getParameter("alternate_id")));
			hashData.put("resaddrline1",checkForNull(req.getParameter("addr_line1")));
			hashData.put("resaddrline2",checkForNull(req.getParameter("addr_line2")));
			hashData.put("resaddrline3",checkForNull(req.getParameter("addr_line3")));
			hashData.put("resaddrline4",checkForNull(req.getParameter("addr_line4")));
			hashData.put("postalcode",checkForNull(req.getParameter("postal_code")));
			hashData.put("countrycode",checkForNull(req.getParameter("country_code")));
			hashData.put("res_town_code",checkForNull(req.getParameter("res_town_code")));
			hashData.put("res_area_code",checkForNull(req.getParameter("res_area_code")));
			hashData.put("res_region_code",checkForNull(req.getParameter("region_code")));
			hashData.put("mail_addr_line1",checkForNull(req.getParameter("mail_addr_line1")));
			hashData.put("mail_addr_line2",checkForNull(req.getParameter("mail_addr_line2")));
			hashData.put("mail_addr_line3",checkForNull(req.getParameter("mail_addr_line3")));
			hashData.put("mail_addr_line4",checkForNull(req.getParameter("mail_addr_line4")));
			hashData.put("mail_town_code",checkForNull(req.getParameter("mail_res_town_code")));
			hashData.put("mail_area_code",checkForNull(req.getParameter("mail_res_area_code")));
			hashData.put("mail_region_code",checkForNull(req.getParameter("mail_region_code")));
			hashData.put("mail_postal_code",checkForNull(req.getParameter("mail_postal_code")));
			hashData.put("mail_country_code",checkForNull(req.getParameter("mail_country_code")));
			hashData.put("specilitycode", checkForNull(req.getParameter("Splcode1")));
			hashData.put("practitionerid",checkForNull(req.getParameter("practid1")));
			hashData.put("otdatetime",otdatetime);
			hashData.put("overrideyn",checkForNull(req.getParameter("override_yn"),"N"));
			hashData.put("bedclasscode",bedclasscode);
			hashData.put("bedtypecode",checkForNull(req.getParameter("bedtypecode")));
			hashData.put("nursingunitcode",nursingunitcode);
			hashData.put("nursingunittypecode",checkForNull(req.getParameter("nursingunittypecode")));
			hashData.put("roomno",roomno);
			hashData.put("bedno",bedno);
			hashData.put("bookedbyid",checkForNull(req.getParameter("bookedbyid")));
			hashData.put("bookingstatus","");
			hashData.put("dailyrate","");
			hashData.put("client_ip_address",p.getProperty("client_ip_address"));
			hashData.put("oldbedno",checkForNull(req.getParameter("old_bed_no")));
			hashData.put("oldnursingunit",checkForNull(req.getParameter("old_nursing_unit")));
			hashData.put("oldpreferreddate",checkForNull(req.getParameter("old_pref_adm_date")));
			hashData.put("service_code",checkForNull(req.getParameter("service")));
			hashData.put("altid1expdate",altid1expdate);
			hashData.put("reason_for_revision_code",checkForNull(req.getParameter("rev_hid")));
			hashData.put("alt_id1_type","");
			hashData.put("alt_id2_type","");
			hashData.put("alt_id2_no","");
			hashData.put("alt_id2_exp_date","");
			hashData.put("alt_id3_type","");
			hashData.put("alt_id3_no","");
			hashData.put("alt_id3_exp_date","");
			hashData.put("alt_id4_type","");
			hashData.put("alt_id4_no","");
			hashData.put("alt_id4_exp_date","");
			hashData.put("oth_alt_id_type","");
			hashData.put("oth_alt_id_no","");
			hashData.put("expected_discharge_date",expected_discharge_date);

			hashData.put("isBlInstalled",isBlInstalled);
			hashData.put("billing_interfaced",billing_interfaced);
			hashData.put("billing_group",billing_group);
			hashData.put("episodestatus",episodestatus);
			//hashData.put("visitid",visitid+"");
			hashData.put("chk_booking_limit_by",chk_booking_limit_by);
			hashData.put("iscapture_fin_dtls_yn",iscapture_fin_dtls_yn);
			hashData.put("block_bed_based_on",checkForNull(req.getParameter("block_bed_based_on")));

			hashData.put("booking_remarks",booking_remarks);
			hashData.put("booking_Type_Code",booking_Type_Code);
			hashData.put("booking_status",booking_status);

			//RUT-CRF-013 changes - start
			hashData.put("patInstructions",patInstructionsMap);
			//RUT-CRF-013 changes - end
			//Maheshwaran K added for the CRF : RUT-CRF-0012 (23395	) as on 28/01/2013
			//Start
			hashData.put("surgery_order_code",surgery_order_code);
			hashData.put("surgery_order",surgery_order);
			hashData.put("surgery_order_id",surgery_order_id);
			hashData.put("surgery_order_line_no",surgery_order_line_no);
			hashData.put("surgery_order_date",surgery_order_date);
			//End
			//Maheshwaran K added for AAKH-CRF-0175 as on 23-08-2023
			hashData.put("smartCardFunc",checkForNull(req.getParameter("smartCardFunc")));
			biometric_reason=checkForNull((String)session.getAttribute("biometric_reason"));
			if(!biometric_reason.equals("")){
			session.removeAttribute("biometric_reason");
			}
			hashData.put("biometric_reason",biometric_reason);
			//Ends

			HashMap fin_dtls=(HashMap)session.getAttribute("financial_details");
			if(fin_dtls!=null)
			{
				hashData.put("fin_dtls",(HashMap)fin_dtls);
			}
	
			boolean local_ejbs	= false;

			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/IPConfirmBooking",IPConfirmBookingHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = p;
			argArray[1] = hashData;

			Class [] paramArray = new Class[2];
			paramArray[0] = p.getClass();
			paramArray[1] = hashData.getClass();


			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insertIPConfirmBooking",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			error = (String) results.get("error") ;

			String overRideMessage = "";
			overRideMessage = (String) results.get("overrideMessage");
			if(overRideMessage == null ) overRideMessage = "";
			
			if(error.indexOf("<br>")!=-1)
				error = error.substring(0,error.indexOf("<br>"));

			if(error.indexOf("<B>")!=-1)
				error = error.substring(0,error.indexOf("<B>"));

			if ( inserted )
			{
				if (!overRideMessage.equals(""))
				{
					error =overRideMessage +"\\n"+error;
//					out.println("<script>alert('"+error+"'); </script>");
					out.println("alert('"+error+"'); ");
				}
				else
				{
					//out.println("<script>alert('"+error+"'); </script>");
					out.println("alert('"+error+"'); ");
				}
				session.removeAttribute("financial_details");
				session.removeAttribute("ipPatInstructionsMap");//included for the CRF - RUT-CRF-013 23396
				doOnlineReports(req,res,nursingunitcode, facilityId, bkglstrefno, error, call_function,patientid);
			}
			else
			{
				//out.println("<Script>parent.frames[1].enableField();parent.frames[2].location.href='../eCommon/jsp/error.jsp?err_num="+java.net.URLEncoder.encode(error, "UTF-8")+"&err_value=0'; </Script>");
				out.println("parent.frames[1].enableField();parent.frames[2].location.href='../eCommon/jsp/error.jsp?err_num="+java.net.URLEncoder.encode(error, "UTF-8")+"&err_value=0';");
			}

			hashData.clear();
			results.clear();
			if(fin_dtls!=null)
				fin_dtls.clear();

			} catch ( Exception e )
			    {
					e.printStackTrace();
				}
		}

	}//e.o.insert Method

	private void doOnlineReports(HttpServletRequest req, HttpServletResponse res,String nursing_unit, String facilityId, String bkglstrefno, String error,String call_function,String patientid) throws ServletException, IOException, SQLException
	{
		PrintWriter out			= null;
		java.util.Properties p	= null;
		String sStyle			= "";
		String locale			= "" ;
		HttpSession session		= null;
		session					= req.getSession(false);
		p						= (java.util.Properties) session.getValue( "jdbc" ) ;
		sStyle					= checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
		locale					= p.getProperty("LOCALE");
		out						= res.getWriter();
		String sqlString		= "";
		String dest_locn_type	= "";
//14-10-2009 for IN015373

		String  pat_val			= "";
		Connection con			=	null;
		Statement vip_stmt		= null;
		ResultSet vip_rs		= null;


		try
		{
			con = ConnectionManager.getConnection(p);
			if (!nursing_unit.equals(""))
			{
				if(patientid != "")
				{
						vip_stmt = con.createStatement();
						vip_rs = vip_stmt.executeQuery(" SELECT a.PAT_CAT_CODE  FROM MP_PATIENT a ,MP_PAT_CATEGORY b WHERE b.GOVT_OR_PVT_IND = 'V' AND  a.PAT_CAT_CODE = b.PAT_CAT_CODE AND a.patient_id = '"+patientid+"'") ;

						if(vip_rs != null && vip_rs.next())
						{
							pat_val = vip_rs.getString("PAT_CAT_CODE");
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

				//sqlString = "select a.report_id report_id, b.report_desc report_desc, 1 no_of_copies, a.module_id from ip_online_report a, sm_report_lang_vw b  where  b.language_id='"+locale+"' and a.module_id = 'IP' and b.internal_request_yn='Y' and a.facility_id='"+facilityId+"' and a.print_on_booking_yn='Y' and a.nursing_unit_code ='"+nursing_unit+"'  and a.report_id = b.report_id order by 2 ";

				dest_locn_type = "N";
			}
			else
				sqlString = "select b.report_id report_id, b.report_desc report_desc, 1 no_of_copies, b.module_id from sm_report_lang_vw b where b.language_id='"+locale+"' and module_id = 'IP' and report_id = 'IPBBKSLP'";

			String reportParamNames = "P_BKG_LST_REF_NO";
			String reportParamValues = ""+bkglstrefno+"";
			StringBuffer htmlFor = new StringBuffer();
			String Patient_param = "";
			if (!patientid.equals(""))
				Patient_param = "&Patient_ID="+patientid;
			/*htmlFor.append(" <html><head> <link rel='stylesheet' type ='text/css' href='../eCommon/html/"+sStyle+"'></link>");
			htmlFor.append(" <script src='../eCommon/js/showModalDialog.js' language='JavaScript'></script>");
			htmlFor.append("</head><body class='message'>");
			htmlFor.append("<script language = 'JavaScript'>" );*/
			htmlFor.append(" var dialogHeight = '50vh' ;");
			htmlFor.append(" var dialogWidth = '55vw' ;");
			htmlFor.append(" var dialogTop = '0vh';" );
			htmlFor.append(" var arguments =   ''; ");
			//htmlFor.append("  var getUrl        =   '../eCommon/jsp/InternalReportsPrint.jsp?step=1&sqlString="+java.net.URLEncoder.encode(sqlString)+Patient_param+"&dest_locn_type="+dest_locn_type+"&dest_locn_code="+nursing_unit+"&reportParamNames="+reportParamNames+"&reportParamValues="+reportParamValues+"';");
			// modified the below line by Abirami - Bru-HIMS-CRF-313 / Passing function id in the below Query String.
			htmlFor.append(" var getUrl        =   '../../eCommon/jsp/InternalReportsPrint.jsp?P_function_id=IP_CONFIRMBOOKING&step=1&sqlString="+java.net.URLEncoder.encode(sqlString)+Patient_param+"&dest_locn_type="+dest_locn_type+"&dest_locn_code="+nursing_unit+"&reportParamNames="+reportParamNames+"&reportParamValues="+reportParamValues+"';");
			htmlFor.append(" var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; status=no;' ;");
			htmlFor.append("  retVal            =   await top.window.showModalDialog(getUrl,arguments,features); ");
			//htmlFor.append(" </script>"  );
			out.println(htmlFor.toString());

			/*if(call_function.equals("CA_Clinician_IP_Booking"))
				out.println("<Script>parent.frames[2].location.href='../eIP/jsp/IPError.jsp?err_num="+java.net.URLEncoder.encode(error, "UTF-8")+"&err_value=1';");
			else if(call_function.equals("IP_ConfirmBooking"))
			{
				out.println("<script> parent.parent.window.close();</script>");
			}*/
			if(call_function.equals("CA_Clinician_IP_Booking"))
				out.println("parent.frames[2].location.href='../eIP/jsp/IPError.jsp?err_num="+java.net.URLEncoder.encode(error, "UTF-8")+"&err_value=1';");
			else if(call_function.equals("IP_ConfirmBooking"))
			{
				out.println("parent.parent.window.close();");
			}
			//out.println("</script>");

		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
		finally
		{
			if(vip_rs != null) vip_rs.close();
			if(vip_stmt != null) vip_stmt.close();
			if(con!=null) ConnectionManager.returnConnection(con,p);
		}
	}

	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}

	private String checkForNull(String inputString,String defaultstr)
	{
		return (inputString==null)	?	defaultstr	:	inputString;
	}
}// E.O.Class
