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

public class BulkTransferPractitionerServlet extends javax.servlet.http.HttpServlet 
{
	Properties p;
	PrintWriter out;
	String facilityId;
	String sStyle;
	String locale			= "" ;
	Connection con	=	null;//Added for check Style

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
		try{
		TransferPractitioner(req,res);
		}catch(Exception e){
			e.printStackTrace();
		}
	}


	private void TransferPractitioner(HttpServletRequest req, HttpServletResponse res){
		HttpSession session = req.getSession(false);
		int counter;
		this.p = (Properties) session.getValue( "jdbc" ) ;
		ArrayList arrayList=new ArrayList();
		String checkbox		= "";
		String frm_pract_id	= "";
		String to_pract_id	= "";
		String patient_id	= "";
		String encounter_id	= "";
		String trans_type="";
		String team_id="";
		String speciality_code="";
		String nursing_unit_code="";
		String service_code="";
		String bed_class="";
		String bed_type="";
		String bed_no="";
		String room_no="";
		String admission_date_time="";
		String patient_class="";
		String transfer_date="";
		String qryString="";
		boolean validate=false;
		try{
			con = ConnectionManager.getConnection(p);//Added for check Style
		this.facilityId=checkForNull((String)session.getValue("facility_id"));
		frm_pract_id=checkForNull(req.getParameter("practitioner_id_from"));
		to_pract_id=checkForNull(req.getParameter("practitioner_id_to"));
		trans_type=checkForNull(req.getParameter("trans_type"));
		qryString=checkForNull(req.getParameter("qryString"));
		counter=Integer.parseInt(req.getParameter("counter"));
		for(int cnt=0;cnt<counter;cnt++){
			checkbox=checkForNull(req.getParameter(("Check"+cnt)));
				if(checkbox.equals("Y")){
					patient_id			=checkForNull(req.getParameter(("patient_id"+cnt)));
					encounter_id		=checkForNull(req.getParameter(("encounter_id"+cnt)));
					team_id				=checkForNull(req.getParameter(("team_id"+cnt)));
					speciality_code		=checkForNull(req.getParameter(("dbspeciality_code"+cnt)));
					service_code		=checkForNull(req.getParameter(("service_code"+cnt)));
					bed_type			=checkForNull(req.getParameter(("bed_type_code"+cnt)));
					bed_class			=checkForNull(req.getParameter(("bed_class_code"+cnt)));
					bed_no				=checkForNull(req.getParameter(("bed_no"+cnt)));
					room_no				=checkForNull(req.getParameter(("room_no"+cnt)));
					nursing_unit_code	=checkForNull(req.getParameter(("nursing_unit_code"+cnt)));
					admission_date_time	=checkForNull(req.getParameter(("admission_date_time"+cnt)));
					patient_class		=checkForNull(req.getParameter(("patient_class"+cnt)));
					HashMap hashMap=new HashMap();
					hashMap.put("facilityId",facilityId);
					hashMap.put("patientid",patient_id);
					hashMap.put("encounterid",encounter_id);
					hashMap.put("transferdate",transfer_date); 
					hashMap.put("transfertype",trans_type); 
					hashMap.put("frpractitionerid",frm_pract_id);
					hashMap.put("frspecialitycode",speciality_code);
					hashMap.put("frteamid",team_id);
					hashMap.put("topractitionerid",to_pract_id);
					hashMap.put("tospecialitycode",speciality_code);
					hashMap.put("toteamid",team_id);
					hashMap.put("nursingunitcode",nursing_unit_code);
					hashMap.put("fmservicecode",service_code);
					hashMap.put("toservicecode",service_code);
					hashMap.put("bedclass",bed_class);
					hashMap.put("bedtype",bed_type);
					hashMap.put("bedno",bed_no);
					hashMap.put("roomno",room_no);
					hashMap.put("admission_date",admission_date_time);
					hashMap.put("patient_class",patient_class);
					hashMap.put("client_ip_address",p.getProperty("client_ip_address"));
					validate=validatePatient(req,res,hashMap,con);//Added for check Style
					if(validate){
						arrayList.add(hashMap);
					}				

			}
		}
		if(validate){
			String error="";
			try{
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
			//hashData.clear();
			arrayList.clear();
			if(error.lastIndexOf("<br>")>=0)	
				error = error.substring(0,error.indexOf("<br>"));

			if(inserted)
			{
				out.println("<Script>parent.frames[3].location.href='../eCommon/jsp/error.jsp?err_num="+java.net.URLEncoder.encode(error, "UTF-8")+"&err_value=1';</script>");
				out.println("<script>parent.f_query_add_mod.location.reload()</script>");
			}
			else
			{
				 out.println("<Script>parent.frames[3].location.href='../eCommon/jsp/error.jsp?err_num="+java.net.URLEncoder.encode(error, "UTF-8")+"&err_value=1';</script>");
				 out.println("<script>parent.f_query_add_mod.location.reload()</script>");
			}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	  }catch(Exception e){
		  e.printStackTrace();
	  }
	  //Added for check Style
	  finally
			{
				if(con!=null) ConnectionManager.returnConnection(con,p);
			}	

	}


	public boolean validatePatient(HttpServletRequest req, HttpServletResponse res,HashMap hashMap,Connection con) throws javax.servlet.ServletException,IOException{
		HttpSession session = req.getSession(false);
		locale = p.getProperty("LOCALE");
		String patientid = "";
		out = null;
		p = null;
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		boolean proceed = true;
		sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		this.p = (Properties) session.getValue( "jdbc" ) ;
		locale = p.getProperty("LOCALE");
		try
		{
			this.out	= res.getWriter();
			patientid	= (String)hashMap.get("patientid");
			//Connection con	=	null;//Commented for check Style			
			Statement entitle_stmt = null;
			PreparedStatement entitle_pstmt = null;
			ResultSet entitle_rs = null;
			String status	= "";
			String msg		= "";
			String entitlement_by_pat_cat_yn = "";
			try
			{
				//con = ConnectionManager.getConnection(p);//Commented for check Style
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
					entitle_pstmt.setString(2,(String)hashMap.get("admission_date"));
					entitle_pstmt.setString(3,facilityId);
					entitle_pstmt.setString(4,"N");
					entitle_pstmt.setString(5,(String)hashMap.get("nursingunitcode"));
					entitle_pstmt.setString(6,(String)hashMap.get("patient_class"));
					entitle_pstmt.setString(7,(String)hashMap.get("frspecialitycode"));
					entitle_pstmt.setString(8,(String)hashMap.get("bedclass"));

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
					out.println("<script>parent.frames[1].document.forms[0].transfer.disabled = false;</script>");
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
					out.println("<script>parent.frames[1].document.forms[0].transfer.disabled = false;</script>");
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
					out.println("<script>parent.frames[1].document.forms[0].transfer.disabled = false;</script>");
					message.clear();
				}
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			//Commented for check Style
			/*finally
			{
				//if(con!=null) ConnectionManager.returnConnection(con,p);
			}	*/	
			

			}
		catch (Exception e)	
		{
			e.printStackTrace();
		}

		return proceed;
	}
	
	public static String checkForNull(String inputString)
	{
		return( (inputString == null) ? "" : inputString );
	}
} 
