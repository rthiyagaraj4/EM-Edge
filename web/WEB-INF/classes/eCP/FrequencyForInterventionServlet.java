/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
//This file is saved on 01/12/2005.


package eCP;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
//import javax.naming.*;
//import javax.rmi.*;
import eCommon.Common.*;
import webbeans.eCommon.*;
import eCP.FrequencyForIntervention.*;

public class FrequencyForInterventionServlet extends javax.servlet.http.HttpServlet 
	{
	PrintWriter out;
	java.util.Properties p;
	String locale="";
	String facilityId ;
	String client_ip_address ;
	    
	HttpSession session;
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
		
		}
	
public  void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{			
				
		session = req.getSession(false);
		this.p = (java.util.Properties) session.getAttribute( "jdbc" ) ;
		this.facilityId = (String) session.getAttribute( "facility_id" ) ;
		client_ip_address = p.getProperty("client_ip_address");
		
		try
		{
			res.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
			this.out = res.getWriter();
			SpecialityAddModify(req,res);
		}
		catch(Exception e)
		{
			out.println(e.toString());
		}
	}
	
public void doGet(HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		try
		{
			this.out = res.getWriter();
			res.setContentType("text/html");
		
		}
		catch(Exception e)	{	
		e.printStackTrace();}
	}

	private void SpecialityAddModify(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
            HashMap tabdata=new HashMap();
            RecordSet	 FrequencyForIntervention	=	null;
            String checkedOnes = "";
            String	from	=	"",	to		=	"";
			int n=0;
           
			String frequency_code = req.getParameter("frequency_code")==null ? "":req.getParameter("frequency_code");
			tabdata.put("frequency_code",frequency_code );
			from		=	(req.getParameter("from")==null) ?	"0"	:	req.getParameter("from");
            to			=	(req.getParameter("to")==null) ?	"0"	:	req.getParameter("to");

            FrequencyForIntervention	=	(webbeans.eCommon.RecordSet)session.getAttribute("FrequencyForIntervention");
	
    		if(from != null && to != null)
			{
				from	=	from.trim();
				to		=	to.trim();
				
				for( int i=(Integer.parseInt(from)); i<=(Integer.parseInt(to)); i++)
				{
					if(req.getParameter(("chk"+i)) != null)
					{
						checkedOnes = req.getParameter(("chk"+i));

         			if(!(FrequencyForIntervention.containsObject(checkedOnes)))
									FrequencyForIntervention.putObject(checkedOnes);
					}
				}
			}

			n=FrequencyForIntervention.getSize();

			if(n>0)
			{
			for(int i=0;i<n;i++)
			{
				tabdata.put( ("chk"+i), (String)FrequencyForIntervention.getObject(i) );
			}
			}

			String addedById = p.getProperty( "login_user" ) ;
			String addedDate = dateFormat.format( new java.util.Date() ) ;
			String modifiedById = addedById ;
			String modifiedFacilityId = facilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;

			java.sql.Date added_date1 = java.sql.Date.valueOf( addedDate ) ;
			java.sql.Date added_date = new java.sql.Date(added_date1.parse(added_date1.toLocaleString())-(added_date1.getTimezoneOffset()*60*1000) ) ;
			
			tabdata.put("added_date", added_date);
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );
			tabdata.put("totCount", String.valueOf(n));
			tabdata.put("locale",locale);
		/*InitialContext context = new InitialContext();
		Object homeObject = context.lookup("java:comp/env/FrequencyForIntervention");
		FrequencyForInterventionHome home = (FrequencyForInterventionHome) PortableRemoteObject.narrow(homeObject ,FrequencyForInterventionHome.class);
		FrequencyForInterventionRemote remote = home.create();
		java.util.HashMap results = remote.SpecialityAddModify(p,tabdata) ;*/

		boolean local_ejbs = false;
				ServletContext context = getServletConfig().getServletContext();
				if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
				local_ejbs = true;
				Object obj = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/FrequencyForIntervention", eCP.FrequencyForIntervention.FrequencyForInterventionHome.class, local_ejbs);
				Object obj1 = obj.getClass().getMethod("create", null).invoke(obj, null);
				Object aobj[] = new Object[2];
				aobj[0] = p;
				aobj[1] = tabdata;
				Class aclass[] = new Class[2];
				aclass[0] = p.getClass();
				aclass[1] = tabdata.getClass();
				HashMap results = (HashMap)obj1.getClass().getMethod("SpecialityAddModify", aclass).invoke(obj1, aobj);
				obj1.getClass().getMethod("remove", null).invoke(obj1, null);

				boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
				String error = (String) results.get("error") ;
				String error_value = "0" ;

				if ( inserted ) error_value = "1" ;
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8") + "&err_value=" + error_value );
	
		} catch ( Exception e ) {
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ;

		}finally{
			session.removeAttribute("FrequencyForIntervention");
		}
	}//E.O.Method
} 
