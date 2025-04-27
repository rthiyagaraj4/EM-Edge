/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMR;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Properties;
import webbeans.eCommon.RecordSet;
import eMR.ICDForDiagGroup.*;

import eCommon.XSSRequestWrapper;


public class ICDForDiagGroupServlet extends javax.servlet.http.HttpServlet
{
    PrintWriter out;
    java.util.Properties p;
    String facilityId ;
    String client_ip_address ;
	String group_type="";
    String diag_code_scheme="";
    String diag_group_code="";
	String sStyle="";
    HttpSession session;
    java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

    public void init(ServletConfig config) throws ServletException
    {
        super.init(config);
    }

    public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
    {
        session = req.getSession(false);
        this.facilityId = (String) session.getValue( "facility_id" ) ;
        this.p = (Properties) session.getValue( "jdbc" ) ;
		this.client_ip_address = p.getProperty("client_ip_address");
		sStyle	= (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
        try
        {
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			req= new XSSRequestWrapper(req);
			res.addHeader("X-XSS-Protection", "1; mode=block");
			res.addHeader("X-Content-Type-Options", "nosniff");
			
			this.out = res.getWriter();

			modifyICDForDiagGroup(req, res);
        }
        catch(Exception e)
        {
           // out.println(e.toString());
		   e.printStackTrace();
        }
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
    {
        try
        {
            this.out = res.getWriter(); 
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			
			req= new XSSRequestWrapper(req);
			res.addHeader("X-XSS-Protection", "1; mode=block");
			res.addHeader("X-Content-Type-Options", "nosniff");
			
            String url = "../eCommon/jsp/MstCodeToolbar.jsp?" ;
            String params = req.getQueryString() ;
            String source = url + params ;
            out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/"+sStyle+"'></link><script language='javascript' src='../eMP/js/MPAuditTrialParameter.js'></script></head><frameset rows='42,*,50'><frame name='commontoolbarFrame' src='"+source+"' frameborder=0 scrolling='no' noresize> <frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0><frame name='messageFrame' src='../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto'></frameset></html> ");
        }
        catch(Exception e)  {  /* out.println(e.toString()); */ e.printStackTrace(); }
    }

    private void modifyICDForDiagGroup(HttpServletRequest req, HttpServletResponse res)
    {
        try
        {
			HashMap tabdata	= new HashMap();
            RecordSet icdforDiagGroup	= null;
            String checkedOnes			= "";
            String from					= "";
			String to					= "";

            from		=	(req.getParameter("from")==null)	?	"0"	:	req.getParameter("from");
            to			=	(req.getParameter("to")==null)		?	"0"	:	req.getParameter("to");

			icdforDiagGroup	= (webbeans.eCommon.RecordSet)session.getAttribute("icdforDiagGroup");
			
			diag_code_scheme = req.getParameter("diag_code_scheme");
				if(diag_code_scheme== null) diag_code_scheme="";
			group_type = req.getParameter("group_type");
				if(group_type== null) group_type="";
			diag_group_code = req.getParameter("diag_group_code");
				if(diag_group_code == null) diag_group_code="";
						
			if(from != null && to != null)
			{
				from	=	from.trim();
				to		=	to.trim();
				
				for( int i=(Integer.parseInt(from)); i<=(Integer.parseInt(to)); i++)
				{
					if(req.getParameter(("icdCodeNum"+i)) != null)
					{
						checkedOnes = req.getParameter(("icdCodeNum"+i));
					}	
					if(req.getParameter(("icdCodeNum"+i)) != null && !icdforDiagGroup.containsObject(checkedOnes))
					{
						icdforDiagGroup.putObject(checkedOnes);
					}
			    }
			}
						
			for(int i=0;i<icdforDiagGroup.getSize();i++)
			{
				tabdata.put( ("icdCodeNum"+i), (String)icdforDiagGroup.getObject(i) );
			}
						
			tabdata.put("diag_group_code",diag_group_code );
			tabdata.put("group_type",group_type );
			tabdata.put("diag_code_scheme",diag_code_scheme );

			String slCount					= ""+icdforDiagGroup.getSize();
			String addedById				= p.getProperty( "login_user" ) ;
			String addedDate				= dateFormat.format( new java.util.Date() ) ;
			String modifiedById				= addedById ;
			String modifiedFacilityId		= facilityId ;
			String addedAtWorkstation		= client_ip_address;
			String modifiedAtWorkstation	= addedAtWorkstation ;

			java.sql.Date added_date1 = java.sql.Date.valueOf( addedDate ) ;
			java.sql.Date added_date = new java.sql.Date(added_date1.parse(added_date1.toLocaleString())-(added_date1.getTimezoneOffset()*60*1000));

			tabdata.put("added_date", added_date);
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );
			tabdata.put("totCount", new Integer(slCount) );

			boolean local_ejbs = false;

			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/ICDForDiagGroup",ICDForDiagGroupHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = p;
			argArray[1] = tabdata;

			Class [] paramArray = new Class[2];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();

			HashMap results = (HashMap)(busObj.getClass().getMethod("insertICDForDiagGroup",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			boolean inserted	= (((Boolean) results.get("status")).booleanValue());

			String error = "";
			String error_value = "0" ;
			if ( inserted )
			{
				error_value = "1" ;
				error= (String) results.get("message") ;
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
			}
			else
			{
				error = (String) results.get("error") ;
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
			}
			if ( tabdata != null) tabdata.clear();
			if ( results != null) results.clear();
		}
		catch(Exception e)
        {
         //   out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
		 e.printStackTrace();
        }
    }
}
