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
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import webbeans.eCommon.*;
import eIP.IPCancelAdmission.*;
//public class CancelAdmissionServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel
public class CancelAdmissionServlet extends javax.servlet.http.HttpServlet 
{
	
	public void init(ServletConfig config) throws ServletException  
	{
		super.init(config);
	}
	//public synchronized void doPost(HttpServletRequest req, HttpServletResponse res)
	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws javax.servlet.ServletException,IOException
	{
		
		PrintWriter out				= null;
		java.util.Properties p		= null;
		String sStyle				= "";
		String facilityId			= "";
		String remarks				= "";
		String bedno				= "";
		String nursingunitcode		= "";
		String roomno				= "";
		String encounterId			= "";
		String gender				= "";
		//String billing_interfaced	= "";
		String bl_install			= "N";
		String episode_id			= "";
		String patient_id			= "";
		String patient_class		= "";
		String pat_check_yn			= "";
		String blocked_bed_no		= "";
		HttpSession session			= null;
		String client_ip_address	= "";

		session						= req.getSession(false);
        p							= (java.util.Properties) session.getValue( "jdbc" ) ;
        facilityId					= (String) session.getValue( "facility_id" ) ;
		sStyle						= checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
        encounterId					= checkForNull(req.getParameter("encounterID"));
        client_ip_address			= p.getProperty("client_ip_address");
        req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
        out							= res.getWriter();
		String locale				= p.getProperty("LOCALE");

		try 
		{

            remarks			= checkForNull(req.getParameter("reason_for_cancellation"),"N");
			bedno			= checkForNull(req.getParameter("bedno"));
            nursingunitcode = checkForNull(req.getParameter("nursingunitcode"),"N");
            roomno			= checkForNull(req.getParameter("roomno"),"N");
            gender			= checkForNull(req.getParameter("gender"),"N");
			blocked_bed_no  = checkForNull(req.getParameter("blocked_bed_no"));
			bl_install      = checkForNull(req.getParameter("bl_install"),"N");
            episode_id      = checkForNull(req.getParameter("episode_id"));
            patient_id      = checkForNull(req.getParameter("patient_id"));
			patient_class	= checkForNull(req.getParameter("patient_class"));
			pat_check_yn	= checkForNull(req.getParameter("pat_check_yn"));
			HashMap hashValues = new HashMap();
			hashValues.put("remarks",remarks);
			hashValues.put("bedno",bedno);
			hashValues.put("nursingunitcode",nursingunitcode);
			hashValues.put("roomno",roomno);
			hashValues.put("gender",gender);
			hashValues.put("blocked_bed_no",blocked_bed_no);
			hashValues.put("bl_install",bl_install);
			hashValues.put("episode_id",episode_id);
			hashValues.put("patient_id",patient_id);
			hashValues.put("patient_class",patient_class);
			hashValues.put("pat_check_yn",pat_check_yn);
			hashValues.put("client_ip_address",client_ip_address);
			hashValues.put("facilityId",facilityId);
			hashValues.put("locale",locale);
			hashValues.put("encounterId",encounterId);
			updateCancelAdmission(req,res,hashValues,out,p);
			hashValues.clear();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
        }
    }
	//public synchronized void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException 
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException 
	{
		try 
		{ 
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			doPost(req,res);
			PrintWriter out			= null;
			HttpSession session		= null;
			java.util.Properties p	= null;
			session					= req.getSession(false);
			p						= (java.util.Properties) session.getValue( "jdbc" ) ;
			out						= res.getWriter();
			String sStyle			= checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
			String url = "../eCommon/jsp/commonToolbar.jsp?" ;
			String params = req.getQueryString() ;
			String source = url + params ;
			out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/"+sStyle+"'></link><script language='javascript' src='/eCIS/mp/js/Occupation.js'></script></head><frameset rows='60,*,50'><frame name='commontoolbarFrame' src='"+source+"' frameborder=0 scrolling='no' noresize><frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0><frame name='messageFrame' src='../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto'></frameset></html> ");
		} 
		catch(Exception e)    
		{
			e.printStackTrace();
        }
	}
	//private synchronized void updateCancelAdmission(HttpServletRequest req, HttpServletResponse res,HashMap hashValues,PrintWriter out,Properties p) throws IOException
	private void updateCancelAdmission(HttpServletRequest req, HttpServletResponse res,HashMap hashValues,PrintWriter out,Properties p) throws IOException
	{
		try 
		{
            
            String error				= "";
			String encounterId			= "";
			String facilityId			= "";
			String remarks				= "";
			String bedno				= "";
			String nursingunitcode		= "";
			String roomno				= "";
			String gender				= "";
			String bl_install			= "";
			String episode_id			= "";
			String blocked_bed_no		= "";
			String patient_id			= "";
			String patient_class		= "";
			String pat_check_yn			= "";
			String client_ip_address	= "";
			String locale				= "";
			facilityId					= (String)hashValues.get("facilityId");
			encounterId					= (String)hashValues.get("encounterId");
			remarks						= (String)hashValues.get("remarks");
			bedno						= (String)hashValues.get("bedno");
			nursingunitcode				= (String)hashValues.get("nursingunitcode");
			roomno						= (String)hashValues.get("roomno");
			gender						= (String)hashValues.get("gender");
			blocked_bed_no				= (String)hashValues.get("blocked_bed_no");
			bl_install					= (String)hashValues.get("bl_install");
			episode_id					= (String)hashValues.get("episode_id");
			patient_id					= (String)hashValues.get("patient_id");
			patient_class				= (String)hashValues.get("patient_class");
			pat_check_yn				= (String)hashValues.get("pat_check_yn");
			locale						= (String)hashValues.get("locale");
			client_ip_address			= (String)hashValues.get("client_ip_address");
            facilityId					= convertString(facilityId);
            encounterId					= convertString(encounterId);
            remarks						= convertString(remarks);
            bedno						= convertString(bedno);
            nursingunitcode				= convertString(nursingunitcode);
            roomno						= convertString(roomno);
            gender						= convertString(gender);
            bl_install					= convertString(bl_install);
            episode_id					= convertString(episode_id);
			blocked_bed_no				= convertString(blocked_bed_no);
            patient_id					= convertString(patient_id);
			patient_class				= convertString(patient_class);
			pat_check_yn				= convertString(pat_check_yn);

			java.util.HashMap	hashData	=	new java.util.HashMap();
			hashData.put("facilityId",facilityId);
			hashData.put("encounterId",encounterId);
			hashData.put("remarks",remarks);
			hashData.put("bedno",bedno);
			hashData.put("nursingunitcode",nursingunitcode);
			hashData.put("roomno",roomno);
			hashData.put("gender",gender);
			hashData.put("bl_install",bl_install);
			hashData.put("episode_id",episode_id);
			hashData.put("patient_id",patient_id);
			hashData.put("client_ip_address",client_ip_address);
			hashData.put("blocked_bed_no",blocked_bed_no);
			hashData.put("patient_class",patient_class);
			hashData.put("pat_check_yn",pat_check_yn);
			boolean local_ejbs	= false;

			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/IPCancelAdmission",IPCancelAdmissionHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = p;
			argArray[1] = hashData;
			
			Class [] paramArray = new Class[2];
			paramArray[0] = p.getClass();
			paramArray[1] = hashData.getClass();
		
			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("updateCancelAdmission",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
            error     =(String) results.get("error") ;
			if(error.lastIndexOf("<br>")>=0)
                error=error.substring(0,error.lastIndexOf("<br>"));


			if ( inserted )
            {   MessageManager mm = new MessageManager();
			    final java.util.Hashtable mesg = mm.getMessage(locale, "RECORD_MODIFIED", "SM") ;
			    String         msg1=(String)mesg.get("message");
			    out.println("<script>alert(' "+msg1+"');</script>") ;
                out.println("<script>parent.window.close();</script>");
				mesg.clear();
            }
            else
			    out.println("<script>alert(\" "+error+"\");</script>");
					
			hashData.clear();
			hashValues.clear();
			results.clear();
		} 
		catch ( Exception e )
		{
			e.printStackTrace();
			
		}
	}//E.o.Method UpdateCancelAdmission
    private  String convertString(String val)
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
