/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMR;

 import java.sql.*;
 import java.io.*;
 import javax.servlet.*;
 import javax.servlet.http.*;
 import java.util.*;
 import javax.naming.*;
 import javax.rmi.*;
 import eCommon.SingleTabHandler.*;
 import eCommon.Common.*;
 import java.net.URLEncoder.*;
 import webbeans.eCommon.*;

 public class FactorServlet extends HttpServlet implements SingleThreadModel 
 {
	 //private ServletConfig config=null;
	 HttpSession session=null;
	 PrintWriter out=null;
	 Properties p=new Properties();
	 String client_ip_address="";
	 String mode="";
	 String facility_id="";
	 String factor_code="";
	 String long_desc="";
	 String short_desc="";
	 String eff_status="";
	 String related_factor="";
	 String risk_factor="";
	 String defn_char="";
	 String factor_type="";
	String added_by_id = "";
	
	boolean inserted= false;
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	 public void init(ServletConfig config)  throws ServletException
	 {
		super.init(config);																
	 }

    public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException	{
		doPost(request,response);
	}

public void doPost(HttpServletRequest req,HttpServletResponse res)throws javax.servlet.ServletException, IOException
{
	this.out=res.getWriter();	
	req.setCharacterEncoding("UTF-8");
	res.setContentType("text/html;charset=UTF-8");
	try
	{
		session=req.getSession(false);
		this.facility_id=(String)session.getValue("facility_id");
		this.p = (java.util.Properties)session.getValue("jdbc");
		this.client_ip_address=p.getProperty("client_ip_address");
		mode = req.getParameter("mode");
		if(mode.equals("1"))	 insertOperation(req, res);
		if(mode.equals("2"))     modifyOperation(req,res);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}


 public void insertOperation(HttpServletRequest req,HttpServletResponse res) throws Exception
{
	try
	{
		String addeddate = dateFormat.format( new java.util.Date() ) ;
		facility_id = (String) session.getValue( "facility_id" ) ;
		added_by_id 	= p.getProperty( "login_user" ) ;
		factor_code=req.getParameter("factor_code")==null ? "":req.getParameter("factor_code");
		long_desc=req.getParameter("long_desc")==null ? "":req.getParameter("long_desc");
		short_desc=req.getParameter("short_desc")==null ? "":req.getParameter("short_desc");
		eff_status=req.getParameter("eff_status")==null ? "D":req.getParameter("eff_status");
		factor_type=req.getParameter("factor_type")==null?"":req.getParameter("factor_type");

		if(factor_type.equals("L"))
		{
		related_factor="Y";
		risk_factor="N";
		defn_char="N";
		}
		else if(factor_type.equals("K"))
		{
		risk_factor="Y";
		related_factor="N";
		defn_char="N";
		}
		else if(factor_type.equals("R") )
		{
		related_factor="Y";
		risk_factor="Y";
		defn_char="N";
		}
		else if(factor_type.equals("C"))
		{	defn_char="Y";
		risk_factor="N";
		related_factor="N";
		}

		HashMap tabData=new HashMap();

		tabData.put("factor_code",factor_code);
		tabData.put("long_desc",long_desc);
		tabData.put("short_desc",short_desc);
		tabData.put("related_factor_yn",related_factor);
		tabData.put("risk_factor_yn",risk_factor);
		tabData.put("defn_characteristic_yn",defn_char);

		tabData.put("eff_status",eff_status);
		tabData.put("ADDED_BY_ID", added_by_id);
		tabData.put("ADDED_DATE", addeddate);
		tabData.put("ADDED_AT_WS_NO",  client_ip_address);
		tabData.put("ADDED_FACILITY_ID",  facility_id);
		tabData.put("MODIFIED_BY_ID", added_by_id);
		tabData.put("MODIFIED_DATE", addeddate);
		tabData.put("MODIFIED_AT_WS_NO", client_ip_address);
		tabData.put("MODIFIED_FACILITY_ID", facility_id);

		String tabname="mr_factor";
		String dupfields[] = {"factor_code"};
		try
		{
			boolean local_ejbs = false;
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabData;
			argArray[2] = dupfields;
			argArray[3] = tabname;
			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass();
			paramArray[1] = tabData.getClass();
			paramArray[2] = dupfields.getClass();
			paramArray[3] = tabname.getClass();

			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			inserted = (((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			String error_value = "0" ;
			if ( inserted )
			{
				error_value= "1";
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
			}
			else
			{
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
			}
			if ( results != null) results.clear();
		}catch(Exception e)
		{
			//out.println("From Servlet--Calling EJB:"+e);
			e.printStackTrace();
			String error = "Error ";
			String error_value = "0" ;
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
		}
		if ( tabData != null) tabData.clear();
	}catch ( Exception e )
      {
		e.printStackTrace();
		//out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
      }
  } // End of the insertParameter

public void modifyOperation(HttpServletRequest req,HttpServletResponse res)throws Exception
{
	try
	{	
		String addeddate = dateFormat.format( new java.util.Date() ) ;
		facility_id = (String) session.getValue( "facility_id" ) ;
		added_by_id 	= p.getProperty( "login_user" ) ;
		HashMap tabData=new HashMap();
		factor_code=req.getParameter("factor_code")==null ? "":req.getParameter("factor_code");
		long_desc=req.getParameter("long_desc")==null ? "":req.getParameter("long_desc");
		short_desc=req.getParameter("short_desc")==null ? "":req.getParameter("short_desc");
		eff_status=req.getParameter("eff_status")==null ? "D":req.getParameter("eff_status");
		factor_type=req.getParameter("factor_type1")==null?"":req.getParameter("factor_type1");

		if(factor_type.equals("L"))
		{
		related_factor="Y";
		risk_factor="N";
		defn_char="N";
		}
		else if(factor_type.equals("K"))
		{
		risk_factor="Y";
		related_factor="N";
		defn_char="N";
		}
		else if(factor_type.equals("R") )
		{
		related_factor="Y";
		risk_factor="Y";
		defn_char="N";
		}
		else if(factor_type.equals("C"))
		{	defn_char="Y";
		risk_factor="N";
		related_factor="N";
		}
		tabData.put("factor_code",factor_code);
		tabData.put("long_desc",long_desc);
		tabData.put("short_desc",short_desc);
		tabData.put("related_factor_yn",related_factor);
		tabData.put("risk_factor_yn",risk_factor);
		tabData.put("defn_characteristic_yn",defn_char);
		tabData.put("eff_status",eff_status);
		tabData.put("MODIFIED_BY_ID", added_by_id);
		tabData.put("MODIFIED_DATE", addeddate);
		tabData.put("MODIFIED_AT_WS_NO", client_ip_address);
		tabData.put("MODIFIED_FACILITY_ID", facility_id);		
		HashMap pkfields=new HashMap();
		pkfields.put("factor_code",factor_code);
		String tabname="mr_factor";
		try
		{
			boolean local_ejbs = false;
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabData;
			argArray[2] = pkfields;
			argArray[3] = tabname;
			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass();
			paramArray[1] = tabData.getClass();
			paramArray[2] = pkfields.getClass();
			paramArray[3] = tabname.getClass();
			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
			inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			String error_value = "0" ;
			if ( inserted )
			{
				error_value= "1";
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
			}
			else
			{
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
			}
				if ( results != null) results.clear();
		}
		catch(Exception e){
		//out.println("From Servlet--Calling EJB:"+e);
		e.printStackTrace();
		String error = "Error ";
		String error_value = "0" ;
		res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
		}
		if ( tabData != null) tabData.clear();
	}
	catch ( Exception e )
	{
		e.printStackTrace();
		//out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
	}
} // End modify


}
