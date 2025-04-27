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

import eIP.IPTransferPractitioner.* ;

public class TransferPractitionerServlet extends javax.servlet.http.HttpServlet 
{
	Properties p;
	PrintWriter out;
	String facilityId;
	String sStyle;
	String locale			= "" ;

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
		String patientid = "";		
		out				 = null;
		p				 = null;
		facilityId		 = "";
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		HttpSession session = req.getSession(false);
		this.facilityId = (String)session.getValue("facility_id") ;
		sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		this.p = (Properties) session.getValue( "jdbc" ) ;
		locale = p.getProperty("LOCALE");
		try
		{
			this.out	= res.getWriter();
			patientid	= checkForNull(req.getParameter("patient_id"));
			
			Connection con	=	null;
			boolean proceed = true;
			//Statement entitle_stmt = null;
			PreparedStatement entitle_pstmt = null;
			ResultSet entitle_rs = null;
			String status	= "";
			String msg		= "";
			String entitlement_by_pat_cat_yn = "";
			entitlement_by_pat_cat_yn	= checkForNull(req.getParameter("entitlement_by_pat_cat_yn"));
			try
			{
				con = ConnectionManager.getConnection(p);		

				if(entitlement_by_pat_cat_yn.equals("Y"))
				{
					entitle_pstmt = con.prepareStatement("select MP_ENTITLEMENT_VALIDATION(?,to_char(to_date(?,'dd/mm/yyyy hh24:mi'),'dd/mm/yyyy'),?,?,?,?,?,?) from dual");
					entitle_pstmt.setString(1,patientid);
					entitle_pstmt.setString(2,checkForNull(req.getParameter("admission_date")));
					entitle_pstmt.setString(3,facilityId);
					entitle_pstmt.setString(4,"N");
					entitle_pstmt.setString(5,checkForNull(req.getParameter("nursing_unit")));
					entitle_pstmt.setString(6,checkForNull(req.getParameter("patient_class")));
					entitle_pstmt.setString(7,checkForNull(req.getParameter("Splcode")));
					entitle_pstmt.setString(8,checkForNull(req.getParameter("bed_class_code")));

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
					out.println("<script>parent.frames(1).document.forms(0).transfer.disabled = false;</script>");
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
					out.println("<script>parent.frames(1).document.forms(0).transfer.disabled = false;</script>");
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
					out.println("<script>parent.frames(1).document.forms(0).transfer.disabled = false;</script>");
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

			if(proceed)
			{
				TransferPractitioner(req, patientid);
			}

			}
		catch (Exception e)	
		{
			e.printStackTrace();
		}
	}

	private void TransferPractitioner(HttpServletRequest req, String patID)	
	{
		try
		{
			String error="";
			HashMap hashData = new HashMap();
			ArrayList arrayList=new ArrayList();

			hashData.put("facilityId",facilityId);
			hashData.put("patientid",patID);
			hashData.put("encounterid",checkForNull(req.getParameter("encounter_id")));
			hashData.put("transferdate",checkForNull(req.getParameter("transfer_date")));
			hashData.put("transfertype",checkForNull(req.getParameter("transfer_type")));
			hashData.put("frpractitionerid",checkForNull(req.getParameter("fr_practitioner_id")));
			hashData.put("frspecialitycode",checkForNull(req.getParameter("fr_speciality_code")));
			hashData.put("frteamid",checkForNull(req.getParameter("fr_team_id")));
			hashData.put("topractitionerid",checkForNull(req.getParameter("practid")));
			hashData.put("tospecialitycode",checkForNull(req.getParameter("Splcode")));
			hashData.put("toteamid",checkForNull(req.getParameter("team_id")));
			hashData.put("nursingunitcode",checkForNull(req.getParameter("nursing_unit")));
			hashData.put("fmservicecode",checkForNull(req.getParameter("service_code")));
			hashData.put("toservicecode",checkForNull(req.getParameter("service")));
			hashData.put("bedclass",checkForNull(req.getParameter("bed_class_code")));
			hashData.put("bedtype",checkForNull(req.getParameter("bed_type_code")));
			hashData.put("bedno",checkForNull(req.getParameter("bed_no")));
			hashData.put("roomno",checkForNull(req.getParameter("room_no")));
			hashData.put("admission_date",checkForNull(req.getParameter("admission_date")));
			hashData.put("patient_class",checkForNull(req.getParameter("patient_class")));
			hashData.put("client_ip_address",p.getProperty("client_ip_address"));

			arrayList.add(hashData);
			boolean local_ejbs = false;
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/IPTransferPractitioner",IPTransferPractitionerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = p;
			//argArray[1] = hashData;
			argArray[1] = arrayList;

			Class [] paramArray = new Class[2];
			paramArray[0] = p.getClass();
			//paramArray[1] = hashData.getClass();
			paramArray[1] = arrayList.getClass();
			HashMap results = (HashMap)(busObj.getClass().getMethod("insertIPTransferPractitioner",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;	 
			error = (String) results.get("error") ;
			results.clear();
			hashData.clear();
			arrayList.clear();
			if(error.lastIndexOf("<br>")>=0)	
				error = error.substring(0,error.indexOf("<br>"));

			if(inserted)
			{
				out.print("<script>alert(\""+error+"\")</script>");
				//: Online reports model window should not be displayed asking for wristband level. Wristband label should be printed while transferring the practitioner...
				// commented on 11/18/2005 by Sridhar R ...

				out.print("<script>window.parent.close();</script>");
			}
			else
			{
				 if(error.indexOf("Exception") == -1)
				 {
					out.println("<script>parent.frames(1).document.forms(0).transfer.disabled = false;</script>");
				 }
				 out.println("<script>alert(\""+error+"\");</script>");
			}

		}catch( Exception e ) 
		{
			e.printStackTrace();
		}
	}


	public static String checkForNull(String inputString)
	{
		return( (inputString == null) ? "" : inputString );
	}
} 
