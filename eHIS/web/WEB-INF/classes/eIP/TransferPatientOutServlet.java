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
import com.ehis.util.*;

import eIP.IPTransferPatientOut.* ;


public class TransferPatientOutServlet extends javax.servlet.http.HttpServlet
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

	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws javax.servlet.ServletException,IOException
	{
		PrintWriter out			= null;
		Properties p			= null;
		String facilityId		= "";	
		String locale			= "";
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");	  
		HttpSession session		= req.getSession(false);
		facilityId				= checkForNull((String)session.getValue("facility_id")) ;
		p						= (Properties) session.getValue( "jdbc" ) ;
		locale					= p.getProperty("LOCALE");
		try 
		{
			out					= res.getWriter();
		
			boolean proceed		= true;
			Connection con		= null;
			Statement entitle_stmt = null;
			PreparedStatement entitle_pstmt		= null;
			ResultSet entitle_rs= null;
			String status		= "";
			String msg			= "";
			String entitlement_by_pat_cat_yn	= "";
				
				try
				{
					con = ConnectionManager.getConnection(req);
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
						entitle_pstmt.setString(1,checkForNull(req.getParameter("patient_id")));
						entitle_pstmt.setString(2,checkForNull(req.getParameter("admission_date")));
						entitle_pstmt.setString(3,facilityId);
						entitle_pstmt.setString(4,"N");
						entitle_pstmt.setString(5,checkForNull(req.getParameter("nursing_unit_code")));
						entitle_pstmt.setString(6,checkForNull(req.getParameter("patient_class")));
						entitle_pstmt.setString(7,checkForNull(req.getParameter("Splcode")));
						entitle_pstmt.setString(8,checkForNull(req.getParameter("to_bed_class")));

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
					out.println("<script>top.window.document.getElementById('dialog_tag').close();</script>");
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
					message.clear();
				}

			}catch(Exception e)
			{
				e.printStackTrace();
			}
			
			Statement stmt				= null;
			ResultSet rs				= null;
			try
			{
				StringBuffer strBuffer	= new StringBuffer();
				String tfr_req_status	= checkForNull(req.getParameter("status"));
				String modified_date_val= checkForNull(req.getParameter("modified_date_val"));
				String encounter_id		= checkForNull(req.getParameter("encounter_id"));

				strBuffer.append(" select tfr_req_status, TO_CHAR(modified_date, 'dd/mm/rrrr hh24:mi') modified_date FROM IP_TRANSFER_REQUEST where facility_id = '");
				strBuffer.append(facilityId);
				strBuffer.append("' and encounter_id = '");
				strBuffer.append(encounter_id);
				strBuffer.append("' ");
				if(tfr_req_status.equals("1"))
					strBuffer.append(" and tfr_req_status = '1' ");
				else
					strBuffer.append(" and tfr_req_status = '3' ");

				stmt = con.createStatement();
				rs = stmt.executeQuery(strBuffer.toString());
				String modifiedDate_value = "";
				if ((rs != null) && (rs.next()))
				{
					modifiedDate_value = checkForNull(rs.getString("modified_date"));
				}
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();

				
			

				if(modifiedDate_value.equals(modified_date_val))
				{
					proceed = true;
				}
				else
				{
					
					proceed = false;
					java.util.Hashtable errMsg = MessageManager.getMessage(locale,"ENC_ALREADY_MODIFIED","IP");
					msg = (String)errMsg.get("message");
					if(msg.lastIndexOf("<br>") >= 0)
						msg=msg.substring(0,msg.lastIndexOf("<br>"));
					out.println("<script>alert('"+msg+"')</script>");
					out.println("<script>top.window.document.getElementById('dialog_tag').close();</script>");
					errMsg.clear();
				}

			}catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				if(con!=null) ConnectionManager.returnConnection(con,p);
			}	


			if(proceed)
			{
				IPTransferPatientOut(req,res);
			}

		}
		catch (Exception e)	
		{
			e.printStackTrace();
		}
	}

private void IPTransferPatientOut(HttpServletRequest req, HttpServletResponse res)	throws java.io.IOException
{
	PrintWriter out						= null;
	Properties p						= null;
	HttpSession session					= null;
	session								= req.getSession(false);
	out									= res.getWriter();
	p									= (java.util.Properties) session.getValue( "jdbc" );
	String facilityId					= "";	
	String locale						= "" ;
	String transferdate					= "";
	String tobedtype					= "";
	String tobedclass					= "";
	String info_date_time				= "";
	String bed_block_until				= "";
	String auth_date_time				= "";
	facilityId							= checkForNull((String)session.getValue("facility_id")) ;
	transferdate						= checkForNull(req.getParameter("transfer_date"));
	transferdate						= DateUtils.convertDate(transferdate,"DMYHM",locale,"en");
	
	tobedtype							= checkForNull(req.getParameter("bed_type_code"));
	if(tobedtype.equals(""))
		tobedtype						= checkForNull(req.getParameter("hid_bed_type"));

	tobedclass							= checkForNull(req.getParameter("to_bed_class"));
	if(tobedclass.equals(""))
		tobedclass						= checkForNull(req.getParameter("hid_bed_code"));
	
	info_date_time						= checkForNull(req.getParameter("info_date_time"));
	info_date_time						= DateUtils.convertDate(info_date_time,"DMYHM",locale,"en");
	
	bed_block_until						= checkForNull(req.getParameter("bed_block_until"));
	bed_block_until						= DateUtils.convertDate(bed_block_until,"DMYHM",locale,"en");
	
	auth_date_time						= checkForNull(req.getParameter("auth_date_time"));
	auth_date_time						= DateUtils.convertDate(auth_date_time,"DMYHM",locale,"en");
/*10/10/2008*/
//String reason_for_reserved_bed  = checkForNull(req.getParameter("reason_for_reserved_bed"));

	try
	{
		String error="";
		HashMap hashData = new HashMap();
				
		hashData.put("facilityId",facilityId);
		hashData.put("patientid",checkForNull(req.getParameter("patient_id")));
		hashData.put("encounterid",checkForNull(req.getParameter("encounter_id")));
		hashData.put("bed_class_chk",checkForNull(req.getParameter("bed_class_chk")));
		hashData.put("billing_group_id",checkForNull(req.getParameter("billing_group_id")));
		hashData.put("oper_stn_id",checkForNull(req.getParameter("oper_stn_id")));
		hashData.put("transferdate",transferdate);
		hashData.put("transfertype",checkForNull(req.getParameter("transfer_type")));
		hashData.put("priority",checkForNull(req.getParameter("priority")));
		hashData.put("tonursingunitcode",checkForNull(req.getParameter("nursing_unit_code")));
		hashData.put("toservicecode",checkForNull(req.getParameter("service")));
		hashData.put("sub_service",checkForNull(req.getParameter("sub_service")));
		hashData.put("tospecialitycode",checkForNull(req.getParameter("Splcode")));
		hashData.put("topractitionerid",checkForNull(req.getParameter("practid")));
		hashData.put("med_team_id",checkForNull(req.getParameter("team_id")));
		hashData.put("informed_yn",checkForDefault(req.getParameter("info_pat_relatives"),"N"));
		hashData.put("informed_to", checkForNull(req.getParameter("inform_to")));
		hashData.put("informed_name",checkForNull(req.getParameter("info_pat_name")));
		hashData.put("informed_dt",info_date_time);
		hashData.put("auth_dt",auth_date_time);
		hashData.put("porterage_det",checkForNull(req.getParameter("porterage_hid")));
		hashData.put("book_conf_yn",checkForNull(req.getParameter("book_conf_yn")));
		hashData.put("book_ref_no",checkForNull(req.getParameter("book_ref_no")));
		hashData.put("client_ip_address",p.getProperty("client_ip_address"));
		hashData.put("req_bed_type_code",checkForNull(req.getParameter("req_bed_type_code")));
		hashData.put("practitioner_id",checkForNull(req.getParameter("practitioner_id")));
		hashData.put("bed_block_periond",checkForNull(req.getParameter("bed_blocking_period")));
		//hashData.put("block_type_code",checkForNull(req.getParameter("reserve_reason_code")));
		hashData.put("block_type_code",checkForNull(req.getParameter("blocking_type_code")));//Above line commented and the current line added for the SCF - GHL-SCF-763
		hashData.put("bed_block_remark",checkForNull(req.getParameter("bed_block_remarks")));
		hashData.put("bed_block_until",bed_block_until);
		hashData.put("to_bed_class_code_val",checkForNull(req.getParameter("to_bed_class_code_val")));
		hashData.put("frbedclass",checkForNull(req.getParameter("frbedclass")));
		hashData.put("frbedtype",checkForNull(req.getParameter("fr_bed_type")));
		hashData.put("tobedtype",tobedtype);
		hashData.put("tobedclass",tobedclass);
		
		/*Added by Thamizh selvi on 11th May 2017 for ML-MMOH-CRF-0617 Start*/
		String autoCnrmTfrReq = checkForDefault(req.getParameter("autoCnrmTfrReq"),"N");
		hashData.put("autoCnrmTfrReq",autoCnrmTfrReq);
		if(autoCnrmTfrReq.equals("Y")){
			hashData.put("tobedno",checkForNull(req.getParameter("to_bed_no")));
			hashData.put("toroomno",checkForNull(req.getParameter("to_room_no")));
		}/*End*/

		hashData.put("frnursingunitcode",checkForNull(req.getParameter("fr_nursing_unit_code")));
		hashData.put("frsubservcode",checkForNull(req.getParameter("fr_sub_service_code")));
		hashData.put("frservicecode",checkForNull(req.getParameter("fr_service_code")));
		hashData.put("frroomno",checkForNull(req.getParameter("fr_room_no")));
		hashData.put("frbedno",checkForNull(req.getParameter("fr_bed_no")));
		hashData.put("frpractitionerid",checkForNull(req.getParameter("fr_practitioner_id")));
		hashData.put("frspecialitycode",checkForNull(req.getParameter("fr_speciality_code")));
		hashData.put("change_bed_class_yn",checkForNull(req.getParameter("change_bed_class_yn")));
		hashData.put("ipparam_bed_yn",checkForNull(req.getParameter("ipparam_bed_yn")));
		hashData.put("mother_bed_status",checkForNull(req.getParameter("mother_bed_status")));
		hashData.put("bed_change",checkForDefault(req.getParameter("bed_change"),"N"));
		hashData.put("modified_bed_type_code", checkForNull(req.getParameter("modified_bed_type_code")));
		hashData.put("override_yn", checkForNull(req.getParameter("override_yn")));
		hashData.put("gender", checkForNull(req.getParameter("gender")));
		hashData.put("dateofbirth", checkForNull(req.getParameter("dateofbirth")));
		hashData.put("bl_operational", checkForNull(req.getParameter("bl_operational")));
/*10/10/2008*/
		hashData.put("is_reserved_bed_checked",checkForDefault(req.getParameter("is_reserved_bed_checked"),"N"));
		hashData.put("reason_for_reserved_bed",checkForNull(req.getParameter("reason_for_reserved_bed")));
		hashData.put("reserve_bed_no",checkForNull(req.getParameter("r_bed_no")));
		hashData.put("reserve_room_no",checkForNull(req.getParameter("r_room_no")));
		hashData.put("reserve_nurs_unit_code",checkForNull(req.getParameter("r_nursing_unit")));
		hashData.put("res_bed_no", checkForNull(req.getParameter("res_bed_no")));
		hashData.put("res_room_no", checkForNull(req.getParameter("res_room_no")));
		hashData.put("res_nursing_unit", checkForNull(req.getParameter("res_nursing_unit")));
		boolean local_ejbs = false;
		if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/IPTransferPatientOut",IPTransferPatientOutHome.class,local_ejbs);
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);


		Object argArray[] = new Object[2];
		argArray[0] = p;
		argArray[1] = hashData;

		Class [] paramArray = new Class[2];
		paramArray[0] = p.getClass();
		paramArray[1] = hashData.getClass();

		HashMap results = (HashMap)(busObj.getClass().getMethod("insertIPTransferPatientOut",paramArray)).invoke(busObj,argArray);
		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

		boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
		error = (String) results.get("error") ;
		if(error.indexOf("<br>")>=0)
		error=error.substring(0,error.indexOf("<br>"));

		results.clear();
		hashData.clear();
		if(inserted)
		{
			 out.println("<script>alert('"+error+"');</script>");
			 out.println("<script>top.window.document.getElementById('dialog_tag').close();</script>");
		}
		else
		{
			out.println("<script>alert('"+error+"');</script>");
			//out.println("<script>parent.frames(2).document.forms(0).button_s.disabled=false;</script>");
			out.println("<script>parent.frames[5].button_s.disabled=false;</script>");
		}

	} catch ( Exception e ) 
	{
		e.printStackTrace();
	}
}
	// Added by Sridhar R on 2 MARCH 2005.. thesse functions will chk for null value & return empty String...
	public static String checkForNull(String inputString)
	{
		return( (inputString == null) ? "" : inputString );
	}

	public static String checkForDefault(String inputString, String Default)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? Default : inputString);
	}



}
