
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

import eIP.IPAmendBooking.*;

public class AmendBookingServlet extends javax.servlet.http.HttpServlet
{
	PrintWriter out;
	java.util.Properties p;
	String facilityId ;
	String sStyle;
	HttpSession session;
	String client_ip_address ;
	String locale			= "" ;
	StringBuffer strOutBfr = null;

	public void init(ServletConfig config) throws ServletException	{
		super.init(config);
	}
	
	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
		{
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");

			String url = "../eCommon/jsp/commonToolbar.jsp?" ;
			String params = req.getQueryString() ;
			String source = url + params ;
			this.out = res.getWriter();
			strOutBfr = new StringBuffer();
			//out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/"+sStyle+"'></link><script language='javascript' src='../eMP/js/Occupation.js'></script></head><frameset rows='60,*,50'><frame name='commontoolbarFrame' src='"+source+"' frameborder=0 scrolling='no' noresize><frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0><frame name='messageFrame' src='../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto'></frameset>");
			//strOutBfr.append("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/"+sStyle+"'></link><script language='javascript' src='../eMP/js/Occupation.js'></script></head><frameset rows='60,*,50'><frame name='commontoolbarFrame' src='"+source+"' frameborder=0 scrolling='no' noresize><frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0><frame name='messageFrame' src='../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto'></frameset>");
			

			p = null;
			session				= req.getSession(false);
			this.p				= (java.util.Properties) session.getValue( "jdbc" ) ;
			this.facilityId		= (String) session.getValue( "facility_id" ) ;
			sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
			client_ip_address	= p.getProperty("client_ip_address");
			locale = p.getProperty("LOCALE");

			try 
			{
				//this.out		= res.getWriter();
				insertAmendBooking(req,res);

			}catch (Exception e){e.printStackTrace();	}
			//this.out = res.getWriter();
			
			//strOutBfr.append("</html>");
			
			
			out.println(strOutBfr.toString());
			
		}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		try{
				
			doPost(req,res);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	private void insertAmendBooking(HttpServletRequest req, HttpServletResponse res)
	{
		//Maheshwaran K added for AAKH-CRF-0175 as on 23-08-2023
		String smartCardFunc ="";
		String biometric_reason="";
		//Ends
		String error="";
		TreeMap patInstructionsMap=(java.util.TreeMap)session.getAttribute("ipPatInstructionsMap");//included for the CRF - RUT - CRF -013 23396
		try 
		{
			HashMap hashData = new HashMap();
			hashData.put("facilityId",facilityId);
			hashData.put("remarks",checkForNull(req.getParameter("reason_for_revision")));
			hashData.put("bkg_lst_ref_no",checkForNull(req.getParameter("bkg_lst_ref_no")));
			hashData.put("turndownreason",checkForNull(req.getParameter("reason_for_turndown")));
			hashData.put("med_ser_grp_code",checkForNull(req.getParameter("med_ser_grp_code")));
			hashData.put("gender",checkForNull(req.getParameter("gender")));
			hashData.put("addedAtWorkstation",client_ip_address);
			//RUT-CRF-013 changes - start
			hashData.put("patInstructions",patInstructionsMap);
			//RUT-CRF-013 changes - end	
			//billing interface data

			hashData.put("isBlInstalled",checkForNull(req.getParameter("isBlInstalled")));
			hashData.put("iscapture_fin_dtls_yn",checkForNull(req.getParameter("iscapture_fin_dtls_yn")));
			
			//Maheshwaran K added for AAKH-CRF-0175 as on 23-08-2023
			hashData.put("patient_id",checkForNull(req.getParameter("patient_id")));
			hashData.put("nursing_unit",checkForNull(req.getParameter("nursing_unit")));
			hashData.put("smartCardFunc",checkForNull(req.getParameter("smartCardFunc")));
			biometric_reason=checkForNull(req.getParameter("biometric_reason"));
			if(!biometric_reason.equals("")){
			session.removeAttribute("biometric_reason");
			}
			hashData.put("biometric_reason",biometric_reason);
			//Ends
			boolean local_ejbs	= false;
			
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/IPAmendBooking",IPAmendBookingHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = p;
			argArray[1] = hashData;
			
			Class [] paramArray = new Class[2];
			paramArray[0] = p.getClass();
			paramArray[1] = hashData.getClass();
		
			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insertIPAmendBooking",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			error = (String) results.get("error");
				if(error == null) error="";
			if ( inserted )
			{
                if(error.lastIndexOf("<br>")>=0)
				error = error.substring(0,error.indexOf("<br>"));
				//error=error.replaceAll("<br>","");
				session.removeAttribute("ipPatInstructionsMap");//included for the CRF - RUT - CRF -013 23396 			
				/*out.print("<script>alert('"+error+"')</script>");
				out.print("<script>parent.window.close();</script>");*/
				strOutBfr.append("<script>alert('"+error+"')</script>");
				strOutBfr.append("<script>parent.window.close();</script>");
			}
			else{
						
				//out.print("<script>alert('"+error+"')</script>");
				strOutBfr.append("<script>alert('"+error+"')</script>");
			}
			if(!biometric_reason.equals("") && inserted)
			{
				session.removeAttribute("biometric_reason");
			}
			
		hashData.clear();
		results.clear();
		} catch ( Exception e )
		{
			e.printStackTrace();
		}
	}

	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
}
