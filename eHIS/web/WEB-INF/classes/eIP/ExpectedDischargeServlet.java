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
import javax.rmi.*;
import webbeans.eCommon.*;
import com.ehis.util.*;
import eCommon.SingleTabHandler.*;

public class ExpectedDischargeServlet extends javax.servlet.http.HttpServlet
{   
	//PreparedStatement pstmt1;
	//java.util.Properties p;
	//String sStyle;
	//HttpSession session;

	public void init(ServletConfig config) throws ServletException	
	{
		super.init(config);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws javax.servlet.ServletException,IOException
	{  
		
		java.util.Properties p		= null;
		HttpSession session			= null;
		String sStyle				= "";
		String facilityId			= "";
		String call_function		= "";
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		session						= req.getSession(false);
		p							= (java.util.Properties) session.getValue( "jdbc" ) ;
		facilityId					= (String) session.getValue( "facility_id" ) ;
		sStyle						= checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
		call_function 				= req.getParameter("call_function");
		
		try 
		{
			if(call_function.equals("REC_EXP_PROC_DATE"))
				updateProcedureSurgery(req, res, facilityId);
			else
				updateExpectedDischarge(req, res, facilityId);
		}
		catch (Exception e)	
		{
			e.printStackTrace();
		}
	}


	public void doGet(HttpServletRequest req, HttpServletResponse res)throws javax.servlet.ServletException,IOException 
	{
		PrintWriter out				= null;
		HttpSession session			= null;
		String sStyle				= "";
		String url					= "";
		String params				= "";
		String source				= "";	
		sStyle						= checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
		try	
		{
			out						= res.getWriter();
			doPost(req,res);
			url						= "../eCommon/jsp/commonToolbar.jsp?" ;
			params					= req.getQueryString() ;
			source					= url + params ;
			out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/"+sStyle+"'></link><script language='javascript' src='/eCIS/mp/js/Occupation.js'></script></head><frameset rows='60,*,50'><frame name='commontoolbarFrame' src='"+source+"' frameborder=0 scrolling='no' noresize><frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0><frame name='messageFrame' src='../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto'></frameset></html> ");
		} 
		catch(Exception e)	
		{
			e.printStackTrace();
		}
	}

	private void updateProcedureSurgery(HttpServletRequest req, HttpServletResponse res, String facilityId)	
	{
		Connection con				= null;
		PreparedStatement pstmt1	= null;
		java.util.Properties p		= null;
		HttpSession session			= null;
		session						= req.getSession(false);
		p							= (java.util.Properties) session.getValue( "jdbc" ) ;
		int res1					= 0;
		int res2					= 0;
		PrintWriter out				= null;
		String encounterId			= "";
		String locale				= "";
		String surgProcDate			= "";
		String addedFacilityId		= "";
		String addedAtWorkstation	= "";
		String addedById			= "";
		String modifiedById			= "";
		String modifiedFacilityId	= "";
		String modifiedAtWorkstation= "";
		encounterId 				= req.getParameter("encounterID");
		try 
		{
			out						= res.getWriter();
			con						= ConnectionManager.getConnection(req);
			locale					= p.getProperty("LOCALE");
		 	surgProcDate			= req.getParameter("proc_surgery_date");
			
			surgProcDate			= DateUtils.convertDate(surgProcDate,"DMYHM",locale,"en");
			
			addedFacilityId			= facilityId;
			addedAtWorkstation		= p.getProperty("client_ip_address");
			addedById				= p.getProperty( "login_user" ) ;
			modifiedById			= addedById ;
			modifiedFacilityId		= addedFacilityId ;
			modifiedAtWorkstation	= addedAtWorkstation ;
			StringBuffer sql1		= new StringBuffer();
			sql1.append(" UPDATE PR_ENCOUNTER_OTHER_DETAIL SET exp_surgery_date_time = to_date('"+surgProcDate+"','dd/mm/rrrr hh24:mi'), modified_by_id = ?, modified_date	= sysdate, modified_facility_id = ?, modified_at_ws_no = ? WHERE operating_facility_id = ? AND encounter_id = ?");
			pstmt1   = con.prepareStatement( sql1.toString() );
			pstmt1.setString	( 1, modifiedById ) ;
			pstmt1.setString	( 2, modifiedFacilityId ) ;
			pstmt1.setString	( 3, modifiedAtWorkstation ) ;
			pstmt1.setString	( 4, facilityId ) ;
			pstmt1.setString	( 5, encounterId ) ;
			res1 = pstmt1.executeUpdate() ;
			if(res1 > 0)
			{
				StringBuffer sql2 = new StringBuffer();
				sql2.append(" UPDATE IP_ADT_TRN SET ot_date_time = to_date('"+surgProcDate+"','dd/mm/rrrr hh24:mi'), modified_by_id = ?, modified_date = sysdate, modified_facility_id = ?, modified_at_ws_no = ?  WHERE facility_id = ? AND encounter_id =? AND SRL_NO = '1' ");
				if(pstmt1!=null) pstmt1.close(); 
				pstmt1   = con.prepareStatement( sql2.toString() );
				pstmt1.setString	( 1, modifiedById ) ;
				pstmt1.setString	( 2, modifiedFacilityId ) ;
				pstmt1.setString	( 3, modifiedAtWorkstation ) ;
				pstmt1.setString	( 4, facilityId ) ;
				pstmt1.setString	( 5, encounterId ) ;
				res2 = pstmt1.executeUpdate() ;
			}
			if (res1 >0 && res2 >0 )
			{
				con.commit();
				MessageManager mm	= new MessageManager();
				String         msg1	= "";
			    final java.util.Hashtable mesg = mm.getMessage(locale, "RECORD_MODIFIED", "SM") ;
			    msg1				= (String)mesg.get("message");
			    out.println("<script>alert('"+msg1+"');</script>");			
				mesg.clear();
			}
			else
			{
				out.println("<script> alert('Incomplete Operation ...');</script>");
			}
			if(pstmt1!=null) pstmt1.close(); 
		}catch ( Exception e ) 
		{
			try
			{
				con.rollback();
				con.setAutoCommit(true);
			}catch(Exception u){u.printStackTrace();}

		}finally 
		{
			out.println("<script>parent.parent.document.getElementById('dialog_tag').close(); </script>");
			ConnectionManager.returnConnection(con,req);
		}
	}


	private void updateExpectedDischarge(HttpServletRequest req, HttpServletResponse res, String facilityId)	
	{

		Connection con				= null;
		PreparedStatement pstmt1	= null;
		java.util.Properties p		= null;
		HttpSession session			= null;
		session						= req.getSession(false);
		p							= (java.util.Properties) session.getValue( "jdbc" ) ;
		PrintWriter out				= null;
		boolean bedFlg				= false ;
		int res1					= 0;
		String encounterId			= "";
		String expecteddischargedate= "";
		String bedno				= "";
		String nursingunitcode		= "";
		String locale				= "";
		String	addedFacilityId		= "";
		String	addedAtWorkstation	= "";
		String addedById			= "";
		String modifiedById			= "";
		String modifiedFacilityId	= "";
		String modifiedAtWorkstation= "";
		String curdate				= "";
		encounterId 				= req.getParameter("encounterID");
		try 
		{
			out						= res.getWriter();
			con						= ConnectionManager.getConnection(req);
			expecteddischargedate	= req.getParameter("expected_discharge_date");
			curdate					= req.getParameter("systdate");
			bedno					= req.getParameter("bedno");
			if(bedno == null)
			bedno="";
			nursingunitcode			= req.getParameter("nursingunitshortdesc");
            locale					= p.getProperty("LOCALE");
			expecteddischargedate	= DateUtils.convertDate(expecteddischargedate,"DMYHM",locale,"en");
			//curdate					= DateUtils.convertDate(curdate,"DMYHM",locale,"en");
			addedFacilityId			= facilityId;
			addedAtWorkstation		= p.getProperty("client_ip_address");
			addedById				= p.getProperty( "login_user" ) ;
			modifiedById			= addedById ;
			modifiedFacilityId		= addedFacilityId ;
			modifiedAtWorkstation	= addedAtWorkstation ;
			/*
			java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "dd/MM/yyyy hh24:mm" );
			java.util.Date dt		= new java.util.Date();
			curdate					= dateFormat.format( dt ) ;
			curdate					= DateUtils.convertDate(curdate,"DMYHM",locale,"en");
			*/
			StringBuffer sql1 = new StringBuffer();
			sql1.append(" UPDATE PR_ENCOUNTER_OTHER_DETAIL SET exp_discharge_date_time = to_date('"+expecteddischargedate+"','dd/mm/rrrr hh24:mi'), modified_by_id	= ?, modified_date	= sysdate, modified_facility_id = ?, modified_at_ws_no = ? WHERE operating_facility_id = ? AND encounter_id = ? ");

			pstmt1   = con.prepareStatement( sql1.toString() );
			pstmt1.setString	( 1, modifiedById ) ;
			pstmt1.setString	( 2, modifiedFacilityId ) ;
			pstmt1.setString	( 3, modifiedAtWorkstation ) ;
			pstmt1.setString	( 4, facilityId ) ;
			pstmt1.setString	( 5, encounterId ) ;
			res1 = pstmt1.executeUpdate() ;
			if(res1 > 0)
			{
				if (!bedno.equals(""))
				{
					bedFlg = true;
					StringBuffer sql2 = new StringBuffer();
					sql2.append(" UPDATE ip_nursing_unit_bed SET occupied_until_date_time=to_date('"+ expecteddischargedate +"','dd/mm/rrrr hh24:mi'), modified_by_id		= ?,  modified_date		= sysdate, modified_facility_id = ?, modified_at_ws_no = ?  WHERE facility_id  = ? AND nursing_unit_code =? AND bed_no= ? ");
					if(pstmt1!=null) pstmt1.close(); 
					pstmt1   = con.prepareStatement( sql2.toString() );
					pstmt1.setString	( 1, modifiedById ) ;
					pstmt1.setString	( 2, modifiedFacilityId ) ;
					pstmt1.setString	( 3, modifiedAtWorkstation ) ;
					pstmt1.setString	( 4, facilityId ) ;
					pstmt1.setString	( 5, nursingunitcode ) ;
					pstmt1.setString	( 6, bedno ) ;
					pstmt1.executeUpdate() ;
				}
			}

		try
		{
			if (sql1.length() > 0)	sql1.delete(0, sql1.length());
			sql1.append(" UPDATE PR_ENCOUNTER SET exp_discharge_date_time = to_date('"+expecteddischargedate+"','dd/mm/rrrr hh24:mi'), modified_by_id	= ?, modified_date	= sysdate, modified_facility_id = ?, modified_at_ws_no = ? WHERE facility_id = ? AND encounter_id = ? ");
			if(pstmt1!=null) pstmt1.close();
			pstmt1   = con.prepareStatement(sql1.toString());
			pstmt1.setString( 1, modifiedById );
			pstmt1.setString( 2, modifiedFacilityId );
			pstmt1.setString( 3, modifiedAtWorkstation );
			pstmt1.setString( 4, facilityId );
			pstmt1.setString( 5, encounterId );
			res1 = 0;
			res1 = pstmt1.executeUpdate();
			// Modified by Muthu on 17/03/2010 for WalkThrough Issue :- When Changing the EDD of bed through Record expected discharge date function blocked until date is not getting updated to new EDD
			/*Thursday, October 14, 2010 , dateutils condition check added for SRR20056-SCF-5616-IN024363*/
			if(DateUtils.isAfter(expecteddischargedate,curdate, "DMYHM", "en"))
			{
				String sql_bed_bkg = "UPDATE IP_BED_BOOKING SET blocked_until_date_time = to_date('"+expecteddischargedate+"','dd/mm/rrrr hh24:mi'), modified_by_id	= ?, modified_date	= sysdate, modified_facility_id = ?, modified_at_ws_no = ? WHERE facility_id = ? AND encounter_id = ? and booking_type = 'N' ";

				if(pstmt1!=null) pstmt1.close();
				pstmt1   = con.prepareStatement(sql_bed_bkg);
				pstmt1.setString( 1, modifiedById );
				pstmt1.setString( 2, modifiedFacilityId );
				pstmt1.setString( 3, modifiedAtWorkstation );
				pstmt1.setString( 4, facilityId );
				pstmt1.setString( 5, encounterId );
				pstmt1.executeUpdate();
			}

			// End of Comment


		}catch (Exception Exp)
		{
			Exp.printStackTrace();
		}

			if (res1 >0 && (!bedFlg) || res1 >0 && (bedFlg))
			{
				con.commit();
				MessageManager mm = new MessageManager();
			    final java.util.Hashtable mesg = mm.getMessage(locale, "RECORD_MODIFIED", "SM");
				String         msg1=(String)mesg.get("message");
			    out.println("<script>alert('"+msg1+"');</script>");
				mesg.clear();
			}
			else
			{
				out.println("<script> alert('Incomplete Operation ...');</script>");
			}

			if(pstmt1!=null) pstmt1.close();
		} catch ( Exception e ) 
		{
			try
			{
				con.rollback();
				con.setAutoCommit(true);
			}catch(Exception u){u.printStackTrace();}
		}
		finally 
		{
			out.println("<script> parent.parent.document.getElementById('dialog_tag').close(); </script>");
			ConnectionManager.returnConnection(con,req);
		}
	}

	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
}

