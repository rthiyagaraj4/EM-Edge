/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOT;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import webbeans.eCommon.MessageManager;
import webbeans.eOT.StaffAssignmentBean;

import com.ehis.eslp.ServiceLocator;
import com.ehis.persist.PersistenceHelper;
import eCommon.XSSRequestWrapper;

public class StaffAssignmentServlet extends javax.servlet.http.HttpServlet {
	

	PrintWriter out;
	java.util.Properties p;
	HashMap results;
	
	String facilityId="";
	String login_user="";
	String mode="";
	String client_ip_address = "";
	Map tabdata=null;
	HttpSession session;
	
	
	
	boolean insertable = false;

	String locale = "";

	StringBuffer sys_err = new StringBuffer("") ;

	
	
	

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	/**
	 * First method to be called by the servlet
	 */
	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{	
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		req= new XSSRequestWrapper(req);
		res.addHeader("X-XSS-Protection", "1; mode=block");
		res.addHeader("X-Content-Type-Options", "nosniff");
		session = req.getSession(false);
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		facilityId = (String) session.getValue( "facility_id" ) ;
		facilityId = facilityId.substring(facilityId.length() - 2);
		client_ip_address = this.p.getProperty("client_ip_address");
		login_user = this.p.getProperty( "login_user" ) ;
		locale = this.p.getProperty("LOCALE") ;
		
		try
		{
			this.out = res.getWriter();
			mode = req.getParameter("mode");
 			
			callEJB(req, res);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			//out.println(e.toString());
		}
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException{
		doPost(req,res);
	}


	/**
	 * Populate the request data in tabdata map
	 * @param req
	 * @param res
	 * @return
	 */
	private void populateTabData(HttpServletRequest req, HttpServletResponse res){
		
		
		
		tabdata.put("facility_id",facilityId);
		tabdata.put("login_at_ws_no",client_ip_address);
		tabdata.put("login_user",login_user);
		tabdata.put("locale",locale);
		
		String mode =	checkForNull(req.getParameter("mode"));	
		
		tabdata.put("MODE",mode);
		
		populateDetails(req);
		
		
	}
	/**
	 * Populate format selection data
	 * @param req
	 */
	private void populateDetails(HttpServletRequest req)
	{
		String bean_id		= "ot_StaffAssignmentBean" ;
		String bean_name	= "eOT.StaffAssignmentBean";
		StaffAssignmentBean staffAssignmentBean = (StaffAssignmentBean)PersistenceHelper.getBeanObject( bean_id, bean_name, req ) ;
		tabdata.put("STAFF_ASSIGNMENT_BEAN", staffAssignmentBean);
	}
	
	

	/**
	 * Insert data into table 
	 * Calls BLBannerManager to insert data
	 * @param req
	 * @param res
	 */
	private void callEJB(HttpServletRequest req,HttpServletResponse res)
	{
		try 
		{	
			tabdata=new HashMap();
				
			populateTabData(req,res);

			boolean local_ejbs = false;
			if ((getServletConfig().getServletContext().getInitParameter(
					"LOCAL_EJBS") != null)
					&& (getServletConfig().getServletContext()
							.getInitParameter("LOCAL_EJBS")
							.equalsIgnoreCase("TRUE")))
			{	
				local_ejbs = true;
			}
			Object home =ServiceLocator.getInstance().getHome("java:comp/env/StaffAssignment",eOT.StaffAssignment.StaffAssignmentHome.class, local_ejbs);

		
			
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home, null);
			Object argArray[] = new Object[2];
			
			argArray[0] = tabdata;
			argArray[1] = p;
			
			Class[] paramArray = new Class[2];
			
			paramArray[0] = Map.class;
			paramArray[1] = p.getClass();
			
			//Call the EJB
			String errText  = null;
			
			String mode = req.getParameter("mode");
 			
			if(mode == null || mode.equals("insert")) 
			{
				errText = (String) (busObj.getClass().getMethod("insert", paramArray)).invoke(busObj, argArray);	
				(busObj.getClass().getMethod("remove", null)).invoke(busObj, null);
			}
			else
			{
				errText = (String) (busObj.getClass().getMethod("update", paramArray)).invoke(busObj, argArray);	
				(busObj.getClass().getMethod("remove", null)).invoke(busObj, null);
			}
			
			
			if(errText.equals("RECORD_INSERTED"))
			{
				
				java.util.Hashtable hashtable = MessageManager.getMessage(p.getProperty("LOCALE"),"RECORD_INSERTED","SM");	
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( (java.lang.String)hashtable.get("message"),"UTF-8" ) +"&err_value=1");
			}
			else 
			{		
				//java.util.Hashtable hashtable = MessageManager.getMessage(p.getProperty("LOCALE"),"RECORD_INSERTED","SM");
				java.util.Hashtable hashtable = MessageManager.getMessage(p.getProperty("LOCALE"),errText,"SM");	
				if(hashtable != null && hashtable.size() > 0)
				{
					res.sendRedirect("../eCommon/jsp/error.jsp?err_num=Record Already Exists." +"&err_value=2");
				}
				else
				{
					res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + "Error while inserting&err_value=2");
				}
			}	 
			 
		} 
		catch (Exception e)  
		{ 
			//System.out.println("exception in main=" + e.toString());
			e.printStackTrace();
			//out.println("<h3> Exception raise by Servlet ...So Record Not inserted </h3> Foll: Error Received : "+ e.toString() );
			//out.println("Values sent are : <br>");
		} 

	}


	private String checkForNull(String str){
		return (str!=null && str.intern()!="null")?str:"";
	}
}		

