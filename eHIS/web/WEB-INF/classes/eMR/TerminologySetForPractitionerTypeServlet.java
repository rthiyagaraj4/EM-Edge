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
//import javax.rmi.*;
import webbeans.eCommon.*;

import eMR.TerminologySetForPractitionerType.*;

public class TerminologySetForPractitionerTypeServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel{
	PrintWriter out;
	java.util.Properties p;
	String term_set_id;
	String facility_id ;
	String added_by_id = "";
	String client_ip_address ;
	HttpSession session;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException	
	{
		session = req.getSession(false);
		this.p = (java.util.Properties) session.getAttribute( "jdbc" ) ;
		this.facility_id = (String) session.getAttribute( "facility_id" ) ;
		client_ip_address = p.getProperty("client_ip_address");
		try{			
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			this.out = res.getWriter();
			modify(req,res);
		}
		catch(Exception e)	{
			//out.println(e.toString());
			e.printStackTrace();
		}
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		try
		{
			req = req;
			this.out = res.getWriter();			
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link><script language='javascript' src='/eCIS/ip/js/NursUnitRoom.js'></script></head><frameset rows='60,*,50'><frame name='commontoolbarFrame' src='../eCommon/jsp/commonToolbar.jsp?function_name=Rooms For Nursing Unit' frameborder=0 scrolling='no' noresize><frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0><frame name='messageFrame' src='../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto'></frameset></html> ");
		}
		catch(Exception e)	
		{	
			//out.println(e.toString());
			e.printStackTrace();
		}
	}

	private void modify(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			added_by_id 	= p.getProperty( "login_user" ) ;
			HashMap tabData=new HashMap();
            RecordSet	TerminologySetForPractitionerType	=	null;
            RecordSet	TerminologySetForPractitionerType1	=	null;
            String checkedOnes = "";
            String	from	=	"",	to		=	"";
			//String err_value="";
			term_set_id = req.getParameter("term_set_id");
			if(term_set_id == null) term_set_id="";
			tabData.put("term_set_id",term_set_id );

			from		=	(req.getParameter("from")==null)	?	"0"	:	req.getParameter("from");
			to			=	(req.getParameter("to")==null)?"0":req.getParameter("to");
			TerminologySetForPractitionerType	=	(webbeans.eCommon.RecordSet)	session.getAttribute("TerminologySetForPractitionerType");
			TerminologySetForPractitionerType1	=	(webbeans.eCommon.RecordSet)	session.getAttribute("TerminologySetForPractitionerType1");



			if(from != null && to != null)
			{				 	
				from	=	from.trim();
				to	=	to.trim();
			
				for( int i=(Integer.parseInt(from))+1; i<=(Integer.parseInt(to)); i++)
				{
					if(req.getParameter(("select"+i)) != null)
					{
						checkedOnes = req.getParameter(("select"+i));
											
						if(!(TerminologySetForPractitionerType.containsObject(checkedOnes)))
							TerminologySetForPractitionerType.putObject(checkedOnes);
					}


					String removeCode = checkForNull(req.getParameter("removeCode"+(i)));
					if(removeCode.equals("Y"))
					{
						String practTypeCode = req.getParameter("practTypeCode"+(i));
						if((TerminologySetForPractitionerType.containsObject(practTypeCode)))
						{
							int removeCodeIndex = TerminologySetForPractitionerType.indexOfObject(practTypeCode);
							TerminologySetForPractitionerType.removeObject(removeCodeIndex);
						}
					}

					if(req.getParameter(("dftselect"+i)) != null)
					{
						checkedOnes = req.getParameter(("dftselect"+i));
						
						if(!(TerminologySetForPractitionerType1.containsObject(checkedOnes)))
							TerminologySetForPractitionerType1.putObject(checkedOnes);
					}

					String dftremoveCode = checkForNull(req.getParameter("dftremoveCode"+(i)));
					if(dftremoveCode.equals("Y"))
					{
						String dftpractTypeCode = req.getParameter("dftpractTypeCode"+(i));
						if((TerminologySetForPractitionerType1.containsObject(dftpractTypeCode)))
						{
							int removeCodeIndex = TerminologySetForPractitionerType1.indexOfObject(dftpractTypeCode);
							TerminologySetForPractitionerType1.removeObject(removeCodeIndex);
						}
					}
 				}
 			}

			int size=TerminologySetForPractitionerType.getSize();

			/*
			
			for(int k=0;k<size1;k++){
				
			}*/

			for(int i=0;i<size;i++)
			{
				tabData.put( ("select"+i), (String)TerminologySetForPractitionerType.getObject(i));
			
			}
			tabData.put("total_records", String.valueOf(size));
			tabData.put("added_by_id", added_by_id);
			tabData.put("added_at_ws_no",  client_ip_address);
			tabData.put("added_facility_id",  facility_id);
			tabData.put("properties",p);
			tabData.put("properties",p);
			tabData.put("recordSet",TerminologySetForPractitionerType1);
			
			boolean local_ejbs = false;
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/TerminologySetForPractitionerType",TerminologySetForPractitionerTypeHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			Object argArray[] = new Object[2];
			argArray[0] = p;
			argArray[1] = tabData;

			Class [] paramArray = new Class[2];
			paramArray[0] = p.getClass();
			paramArray[1] = tabData.getClass();

			HashMap results = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			String error_value = "0" ;
			if ( inserted ) error_value = "1" ;
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
			if ( tabData != null) tabData.clear();
			if ( results != null) results.clear();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}		
	}//End of Modify

	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}

	public static String checkForNull(String inputString, String Default)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? Default : inputString);
	}
}
