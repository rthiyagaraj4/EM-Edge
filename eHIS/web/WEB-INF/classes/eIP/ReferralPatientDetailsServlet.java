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

import eIP.IPReferralPatientDetails.* ;

public class ReferralPatientDetailsServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel
{
	PrintWriter out;
	Properties p;
	String sStyle;
	String facilityId;
	String client_ip_address ;
	String patientid ;
	String eid;
	String referral_type;
	String practitioner;
	String call_function = "";

	public void init(ServletConfig config) throws ServletException  {
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

		HttpSession session			= req.getSession(false);
		this.facilityId				= (String)session.getValue("facility_id") ;
		sStyle						= checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
		this.p						= (Properties) session.getValue( "jdbc" ) ;
		this.client_ip_address		= p.getProperty("client_ip_address");

		try {
				req.setCharacterEncoding("UTF-8");
				res.setContentType("text/html;charset=UTF-8");
				this.out		= res.getWriter();
				patientid       = checkForNull(req.getParameter("patient_id"));
				eid				= checkForNull(req.getParameter("encounter_id"));
				referral_type   = checkForNull(req.getParameter("referral_type"));
				practitioner    = checkForNull(req.getParameter("practitioner"));

				if (referral_type.equals("X")) 	  practitioner="";
				call_function	= checkForNull(req.getParameter("call_function"));

			IPRefPatDtls(req);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void IPRefPatDtls(HttpServletRequest req)  
	{
		Connection con  = null;
		String locale	= "";
		try 
		{
			con = ConnectionManager.getConnection(req);
			locale = p.getProperty("LOCALE");
			String error="";

			HashMap hashData = new HashMap();
			hashData.put("facilityId",facilityId);
			hashData.put("patientid",patientid);
			hashData.put("encounterid",eid);
			hashData.put("client_ip_address",client_ip_address);
			hashData.put("practitionerid",checkForNull(req.getParameter("practitioner_id")));
			hashData.put("nursingunitcode",checkForNull(req.getParameter("nursingunitcode")));
			hashData.put("referred",checkForNull(req.getParameter("referred"),"N"));
			hashData.put("referral_type",referral_type);
			hashData.put("referred_to",checkForNull(req.getParameter("referred_to")));
			hashData.put("preferred_date",checkForNull(req.getParameter("preferred_date")));
			hashData.put("location0",checkForNull(req.getParameter("location0")));
			hashData.put("location1",checkForNull(req.getParameter("location1")));
			hashData.put("practitioner",practitioner);
			hashData.put("practitioner1",checkForNull(req.getParameter("practitioner1")));
			hashData.put("ReferralNotes",checkForNull(req.getParameter("ReferralNotes")));			hashData.put("hcare_setting_type_desc",checkForNull(req.getParameter("hcare_setting_type_desc")));
			hashData.put("hcare_setting_type",checkForNull(req.getParameter("hcare_setting_type")));
			hashData.put("open_to_all_pract_yn",checkForNull(req.getParameter("open_to_all_pract_yn")));
			hashData.put("location1_desc",checkForNull(req.getParameter("location2")));
			hashData.put("practitioner_name",checkForNull(req.getParameter("practitioner1")));			hashData.put("from_hcare_setting_type_code",checkForNull(req.getParameter("from_hcare_setting_type_code")));
			hashData.put("service",checkForNull(req.getParameter("service")));
			hashData.put("specialitycode",checkForNull(req.getParameter("speciality")));
			hashData.put("priority_type",checkForNull(req.getParameter("priority")));
			hashData.put("fromspecialty_code",checkForNull(req.getParameter("specialty_code")));
			hashData.put("fromservice_code",checkForNull(req.getParameter("service_code")));
			hashData.put("Bedside",checkForNull(req.getParameter("Bedside"),"N"));
			hashData.put("BedSideDate",checkForNull(req.getParameter("BedSideDate")));
			hashData.put("call_function",call_function);
			hashData.put("referral_reason_code",checkForNull(req.getParameter("referral_reason_code")));
			hashData.put("referral_id",checkForNull(req.getParameter("referral_id")));

		   

			boolean local_ejbs = false;
				
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/IPReferralPatientDetails",IPReferralPatientDetailsHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			
			Object argArray[] = new Object[2];
			argArray[0] = p;
			argArray[1] = hashData;
			
			Class [] paramArray = new Class[2];
			paramArray[0] = p.getClass();
			paramArray[1] = hashData.getClass();
			

			HashMap results = (HashMap)(busObj.getClass().getMethod("insertIPReferralPatientDetails",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			error = (String) results.get("error") ;

			if(inserted)
			{
				String referralid = (String) results.get("referralid") ; 
				doOnlineReportPrinting(facilityId, referralid, locale);

				if(!call_function.equals("BedSideReferral"))
				{

					Hashtable message = MessageManager.getMessage( locale, "CONTINUE_REFERRAL","IP");
					error = (String) message.get("message") ;
					message.clear();
			        if(error.lastIndexOf("<br>")>=0)
					error= error.substring(0,error.indexOf("<br>")) ;
					out.print("<script>var truthBeTold = window.confirm(\""+error+"\");</script>");	
					out.print("<script>if(!truthBeTold)parent.window.close()</script>");
				}
				else
				{
			        if(error.lastIndexOf("<br>")>=0)
					error= error.substring(0,error.indexOf("<br>")) ;
					out.println("<script>alert('"+error+"')</script>");
					out.print("<script>parent.window.close();</script>");
				}
			}
			else
			{
			   out.println("<script>alert('"+error+"')</script>");
			   out.print("<script>parent.window.close();</script>");
			}
			results.clear();
			hashData.clear();

		}catch( Exception e ) 
		{
			e.printStackTrace();
		}
		finally
		{
			ConnectionManager.returnConnection(con,req);
		}
			out.print("<script>if(parent.frames(1).document.RefPatientDtls_form && parent.frames(1).document.RefPatientDtls_form.Bedside) { parent.frames(1).document.RefPatientDtls_form.Bedside.checked=false;parent.frames(1).document.RefPatientDtls_form.Bedside.onclick();}</script>");
	}


	public void doOnlineReportPrinting(String facilityId, String referralid, String locale)
	{
		String sqlString = "";		
		sqlString =" Select report_id, report_desc, 1 no_of_copies, module_id from SM_REPORT_LANG_VW where module_id = 'AM' and language_id = '"+locale+"' and report_id = 'AMRFLETR'";

		String reportParamNames = "p_referral_id,p_facility_id";
		String reportParamValues = referralid + "," + facilityId;
		StringBuffer htmlFor = new StringBuffer();
		
		htmlFor.append(" <html><head> <link rel='stylesheet' type ='text/css' href='../eCommon/html/"+sStyle+"'></link> ");
		htmlFor.append("</head><body class='message'> ");
		htmlFor.append("<script language = 'JavaScript'> ");
		htmlFor.append("  var dialogHeight    = '30' ; ");
		htmlFor.append(" var dialogWidth = '65' ; ");
		htmlFor.append("var dialogTop = 58; ");
		htmlFor.append("  var arguments =   ''; ");
		//modified the below line by Abirami - Bru-HIMS-CRF-313 / Passing function id in the below Query String.
		htmlFor.append("  var getUrl        =   '../eCommon/jsp/InternalReportsPrint.jsp?P_function_id=REG_PATIENT_REFERRAL&step=1&sqlString="+java.net.URLEncoder.encode(sqlString)+"&reportParamNames="+reportParamNames+"&reportParamValues="+reportParamValues+"'; ");
		htmlFor.append(" var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; status=no;' ; ");
		htmlFor.append("  retVal            =   window.showModalDialog(getUrl,arguments,features); ");
		htmlFor.append(" </script> ");
		out.println(htmlFor.toString());
	}

	private String convertString(String val)
	{
		/*if(val == null) val = "" ;

		if(!val.equals(""))
		{
			String dup_val = val ;
			int i = 0 ;

			StringBuffer stringbuffer = new StringBuffer(dup_val);
			for(int j = 0; dup_val.indexOf('\'', i) != -1; j++)
			{
				i = dup_val.indexOf('\'', i);
				stringbuffer.insert(i + j, "'");
				i++;
			}
			val = stringbuffer.toString() ;

		}
		return val ;
		*/
		if(val == null) val = "" ;
		 return val.replaceAll("'","''");
	}

	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
		
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}

}
