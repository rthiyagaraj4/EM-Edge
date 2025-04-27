package eIP;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;

import eIP.IPCancelTransferPatientIn.* ;

public class IPCancelTransferPatientInServlet extends javax.servlet.http.HttpServlet 
implements SingleThreadModel
{
	PrintWriter out;
	java.util.Properties p;
	String facilityId;
	String client_ip_address ;
	public void init(ServletConfig config) throws ServletException	
	{
		super.init(config);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws javax.servlet.ServletException,IOException
	{  
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		HttpSession session		= req.getSession(false);
		this.facilityId			= (String)session.getValue("facility_id") ;
		this.p					= (java.util.Properties) session.getValue( "jdbc" ) ;
		this.client_ip_address	= p.getProperty("client_ip_address");
		try 
		{
			this.out = res.getWriter();
			CancelTransferPatientIn(req);
		}
		catch (Exception e)	
		{
			e.printStackTrace();
		}
	}
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		try
		{
			doPost(req,res);
		}
		catch(Exception e)	{	}
	}
	private void CancelTransferPatientIn(HttpServletRequest req)	
	{
		try 
		{
			String error		= "";
			HashMap hashData	= new HashMap();
			
			hashData.put("facilityId",facilityId);
			hashData.put("client_ip_address",client_ip_address);
			hashData.put("patientid",checkForNull(req.getParameter("patient_id")));
			hashData.put("encounterid",checkForNull(req.getParameter("encounter_id")));
			hashData.put("srlNo",checkForNull(req.getParameter("srl_no")));
			hashData.put("cancel_reason",checkForNull(req.getParameter("cancelReason")));

			hashData.put("trf_type",checkForNull(req.getParameter("trfType")));
			hashData.put("frm_serv_code",checkForNull(req.getParameter("frmServCode")));
			hashData.put("frm_bed_cls_code",checkForNull(req.getParameter("frmBedClsCode")));
			hashData.put("frm_bed_cls_type",checkForNull(req.getParameter("frmBedClsType")));
			hashData.put("frm_pract",checkForNull(req.getParameter("frmPractId")));
			hashData.put("frm_spec_code",checkForNull(req.getParameter("frmSpecCode")));
			hashData.put("frm_sub_serv_code",checkForNull(req.getParameter("frmSubServCode")));

			hashData.put("toNursCode",checkForNull(req.getParameter("to_nurs_code")));
			hashData.put("frmNursCode",checkForNull(req.getParameter("frm_nurs_code")));
			hashData.put("toBedNo",checkForNull(req.getParameter("to_bed_no")));
			hashData.put("frmBedNo",checkForNull(req.getParameter("frm_bed_no")));
			hashData.put("toRoomNo",checkForNull(req.getParameter("to_room_no")));
			hashData.put("frmRoomNo",checkForNull(req.getParameter("frm_room_no")));
			
			hashData.put("modifiedDate",checkForNull(req.getParameter("modified_date")));
			hashData.put("tfrReqRefNo",checkForNull(req.getParameter("tfrReqRefNo")));

			boolean local_ejbs = false;
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
			
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/IPCancelTransferPatientIn",IPCancelTransferPatientInHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			Object argArray[] = new Object[2];
			
			argArray[0] = p;
			argArray[1] = hashData;
			
			Class [] paramArray = new Class[2];
			
			paramArray[0] = p.getClass();
			paramArray[1] = hashData.getClass();
			
			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insertCancelTransferPatientIn",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			
			boolean inserted	= ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			error				= (String) results.get("error") ;
		
			if(error.lastIndexOf("<br>") >= 0)
			error				= error.substring(0,error.indexOf("<br>"));

			if(inserted)
			{ 
				//out.println("<script type='text/javascript'>parent.onSuccess();parent.window.returnValue= \""+inserted+"\" ;</script>");
				out.println("<script type='text/javascript'>parent.onSuccess();parent.document.getElementById('dialog-body').contentWindow.returnValue= \""+inserted+"\" ; parent.document.getElementById('dialog_tag').close();</script>");
//				out.println("<script type='text/javascript'>parent.onSuccess();</script>");
			}
			else
				out.print("<html><script>parent.frames[1].location.href =\"../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode(error,"UTF-8") + "\"</script></html>");
			

		 hashData.clear();
		 results.clear();
		} 
		catch ( Exception e ) 
		{
			e.printStackTrace();
			//out.println("Exception raised in IPCacnelTransferPatientInServlet : "+e.toString());
		}
	}
	public static String checkForNull(String inputString)
	{
		return((inputString == null) ? "" : inputString);
	}
}