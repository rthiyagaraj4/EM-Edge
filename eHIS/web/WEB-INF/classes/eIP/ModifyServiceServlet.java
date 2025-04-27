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
import javax.rmi.*;
import java.util.*;
import webbeans.eCommon.*;
import eCommon.SingleTabHandler.*;
import com.ehis.util.*;

public class ModifyServiceServlet extends javax.servlet.http.HttpServlet
{
	PrintWriter out;
	java.util.Properties p;
	String sStyle;
	String locale			= "";

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

		HttpSession session				= req.getSession(false);
		String facilityId				= (String)session.getValue("facility_id") ;
		sStyle							= checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
		this.p							= (java.util.Properties) session.getValue( "jdbc" ) ;
		locale							= p.getProperty("LOCALE");
		Connection con 					= null;
		Statement stmt 					= null;
		ResultSet srs 					= null;
		try 
		{
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			this.out = res.getWriter();

			String patientid			= checkForNull(req.getParameter("patient_id"));
			String eid					= checkForNull(req.getParameter("encounter_id"));
			
			String srlno = "";
			StringBuffer sbSql			= new StringBuffer("");
			if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
			sbSql.append("select MAX(srl_no) srl_no from ip_adt_trn	where facility_id = '"+facilityId+"' and encounter_id = "+eid+" ");
			try
			{
				con		= ConnectionManager.getConnection(p);
				stmt	= con.createStatement();
				srs		= stmt.executeQuery(sbSql.toString());
				if(srs.next())
				{
				   srlno = srs.getString("srl_no");
				}
				if(srs !=null) srs.close(); if(stmt !=null) stmt.close();

				IPModifyService(req, facilityId, patientid,eid,srlno)	;	
				
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(con!=null) ConnectionManager.returnConnection(con,p);
		}


	}

	private void IPModifyService(HttpServletRequest req, String facilityId, String patientid,String encounterID,String srl_no)	
	{
			Connection con 					= null;
			Statement stmt 					= null;
			ResultSet srs 					= null;
			PreparedStatement pstmt			= null;
			CallableStatement cstmt			= null;
			int res1						= 0;
			boolean result					= true;
		try
		{
			con								= ConnectionManager.getConnection(p);
			//java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;
			String modifiedById				= p.getProperty( "login_user" ) ;
			String client_ip_address		= p.getProperty("client_ip_address");
			//String addedDate				= dateFormat.format( new java.util.Date() ) ;
			String addedFacilityId			= facilityId;
			String addedAtWorkstation		= client_ip_address;
			String error					= "";
			String expecteddischargedate	=  checkForNull(req.getParameter("expecteddischargedate"));
			expecteddischargedate			=	DateUtils.convertDate(expecteddischargedate,"DMYHM",locale,"en");
			
			/*Thursday, November 25, 2010 , SRR20056-SCF-6046 [IN:025165]*/
			try
			{
				cstmt = con.prepareCall("{call IP_AUDIT_FUNCTION.ASSIGN_VALUE('Y')}");
				cstmt.execute();
				if(cstmt!=null) cstmt.close();
			}catch(Exception exception)
			{
				exception.printStackTrace();
			}

			StringBuffer sql1 = new StringBuffer();
			// Modified  for this CRF AMRI-CRF-0284 [IN:049116]
			sql1.append(" UPDATE PR_ENCOUNTER SET exp_discharge_date_time = to_date(?,'dd/mm/rrrr hh24:mi'),SERVICE_CODE= ?,SUBSERVICE_CODE=?, CONTACT_REASON_CODE=?,ENC_MODIFIED_YN = ?, modified_by_id	= ?, modified_date	= sysdate, modified_facility_id = ?, modified_at_ws_no = ?, ADMIT_PRACTITIONER_ID=?, ADMISSION_APPROVAL_DETAILS=? WHERE facility_id = ? AND encounter_id = ? "); //Modified by Suji Keerthi for MMS-DM-CRF-0191
			try
			{
				pstmt	= con.prepareStatement(sql1.toString());
				pstmt.setString(1 , expecteddischargedate );
				pstmt.setString(2 , checkForNull(req.getParameter("service")) );
				pstmt.setString(3 , checkForNull(req.getParameter("sub_service")) );
				pstmt.setString(4 , checkForNull(req.getParameter("revision_resn_code")) );
				pstmt.setString(5 , "Y" );
				pstmt.setString(6 , modifiedById );
				pstmt.setString(7 , addedFacilityId );
				pstmt.setString(8 , addedAtWorkstation );
				pstmt.setString(9, checkForNull(req.getParameter("practid"))); //Added for this CRF AMRI-CRF-0284 [IN:049116]
				//Below Added by Suji Keerthi for MMS-DM-CRF-0191
				pstmt.setString(10, checkForNull(req.getParameter("admission_approval_details"))); 
				pstmt.setString(11 , facilityId );
				pstmt.setString(12 , encounterID );
				res1		= pstmt.executeUpdate();
				if(res1 > 0)
					result = true; 
				else 
					result = false;
				if(srs !=null) srs.close(); if(pstmt !=null) pstmt.close();

								
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}	
			
			if(result)
			{
				/*Wednesday, May 12, 2010 , update in ip_open_encounter will done through trigger IP_PR_ENCNTR_UPD_OPEN_ENC_TRG in Pr_encounter*/
				/*
				if (sql1.length() > 0)	sql1.delete(0, sql1.length());
				sql1.append(" UPDATE IP_OPEN_ENCOUNTER SET exp_discharge_date_time = to_date(?,'dd/mm/rrrr hh24:mi'),SERVICE_CODE= ?,SUBSERVICE_CODE=?, modified_by_id	= ?, modified_date	= sysdate, modified_facility_id = ?, modified_at_ws_no = ? WHERE facility_id = ? AND encounter_id = ? ");
				try
				{
					
					pstmt	= con.prepareStatement(sql1.toString());
					pstmt.setString(1 , expecteddischargedate );
					pstmt.setString(2 , checkForNull(req.getParameter("service")) );
					pstmt.setString(3 , checkForNull(req.getParameter("sub_service")) );
					pstmt.setString(4 , modifiedById );
					pstmt.setString(5 , addedFacilityId );
					pstmt.setString(6 , addedAtWorkstation );
					pstmt.setString(7 , facilityId );
					pstmt.setString(8 , encounterID );
					res1		= pstmt.executeUpdate();
					if(res1 > 0)
						result = true; 
					else 
						result = false;
					if(srs !=null) srs.close(); if(pstmt !=null) pstmt.close();

									
				}
				catch (Exception e)
				{
					out.println("exception in IP_OPEN_ENCOUNTER table select query:"+e.toString());
					e.printStackTrace();
				}
				if(result)
				{*/
					if (sql1.length() > 0)	sql1.delete(0, sql1.length());
					sql1.append(" UPDATE IP_ADT_TRN SET TO_SERVICE_CODE= ?,TO_SUBSERVICE_CODE=?, modified_by_id	= ?, modified_date	= sysdate, modified_facility_id = ?, modified_at_ws_no = ? WHERE facility_id = ? AND encounter_id = ? and srl_no = ? ");
					try
					{
					
					pstmt	= con.prepareStatement(sql1.toString());
					pstmt.setString(1 , checkForNull(req.getParameter("service")) );
					pstmt.setString(2 , checkForNull(req.getParameter("sub_service")) );
					pstmt.setString(3 , modifiedById );
					pstmt.setString(4 , addedFacilityId );
					pstmt.setString(5 , addedAtWorkstation );
					pstmt.setString(6 , facilityId );
					pstmt.setString(7 , encounterID );
					pstmt.setString(8 , srl_no );
					res1		= pstmt.executeUpdate();
					if(res1 > 0)
						result = true; 
					else 
						result = false;
					if(srs !=null) srs.close(); if(pstmt !=null) pstmt.close();

									
					}
					catch (Exception e)
					{
						e.printStackTrace();
					}
				//}
			}

				
			if(result)
			{
				con.commit();
				MessageManager mm = new MessageManager();
			    final java.util.Hashtable mesg = mm.getMessage(locale, "RECORD_MODIFIED", "SM");
				String         msg1=(String)mesg.get("message");
			    out.println("<script>alert('"+msg1+"');</script>");
				mesg.clear();
				out.print("<script> parent.document.getElementById('dialog_tag').close(); </script>");
			}
			else
			{
				out.println("<script>alert('"+error+"');</script>");		//out.println("<script>if(parent.frames(1).document.EmergencyTransfer_form.transfer.disabled==true)parent.frames(1).document.EmergencyTransfer_form.transfer.disabled=false;</script>");
				out.println("<script>if(parent.frames[1].document.Change_Adm_Dtls_Form.chkIn_Lodger.disabled==true)parent.frames[1].document.Change_Adm_Dtls_Form.chkIn_Lodger.disabled=false;</script>");
			}

			
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(srs !=null) srs.close(); 
				if(stmt !=null) stmt.close();
				 if(pstmt !=null) pstmt.close();
				 if(con != null)  ConnectionManager.returnConnection(con,req);
			}
			catch (Exception e)
			{
			}
		}

	}

	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	private String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
}
