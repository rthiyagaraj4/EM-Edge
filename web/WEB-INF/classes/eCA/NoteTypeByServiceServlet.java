/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eCA ;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;
import webbeans.eCommon.MessageManager;

import eCA.NoteTypeByService.*;


public class NoteTypeByServiceServlet extends javax.servlet.http.HttpServlet 
{
	public void init(ServletConfig config) throws ServletException	
	{
		super.init(config);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
        throws javax.servlet.ServletException,IOException
	{
		
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = null;

		try 
		{
			out = res.getWriter();
			insertNoteType(req, res, out);
		}
		catch(Exception e)
		{
			out.println(e.toString());
			e.printStackTrace();
		}
	}

private void insertNoteType(HttpServletRequest req, HttpServletResponse res, PrintWriter out)
{
	try {
			java.util.Properties p;
			HttpSession session;

			String client_ip_address ;
			String facilityId="";
			String note_type= "";
			String formats[];
			String formatCheck[];
			String error="";
			String error_value ="";

			session				= req.getSession(false);
			p					= (java.util.Properties) session.getValue( "jdbc" ) ;
			facilityId			= (String)session.getValue("facility_id") ;
			client_ip_address	= (String) p.getProperty("client_ip_address");
            
			RecordSet recordset = null;

			note_type = req.getParameter("note_type");
			note_type = (note_type == null)?"":note_type;

			String s2 = "";
            String s3 = "";

			int u = 0;
            int paramsSize =0;
            
			try
			{
	            s2 = req.getParameter("from") ;
	        
				if(s2 == null)
	            	s2 = "0";
            
	            s3 = req.getParameter("to") ;
				if(s3 == null)
					s3 = "0";
			}
			catch(Exception e)
			{
				out.println("Exception  "+e);
				e.printStackTrace();
			}
           

 	         try
			 {
				recordset= (webbeans.eCommon.RecordSet)com.ehis.persist.PersistenceHelper.getObjectFromBean("NoteTypeServiz","webbeans.eCommon.RecordSet",session);
			 }
			 catch(Exception e)
			 {
				 out.println("exception here "+e);
				 e.printStackTrace();
			 }

			if(s2 != null && s3 != null)
            {
                s2 = s2.trim();
                s3 = s3.trim();
              
                String s1 = "";
				for(int j = (Integer.parseInt(s2)-1); j <= Integer.parseInt(s3); j++)
                    
				if(req.getParameter("chk" + j) != null)
				{
					s1 = req.getParameter("chk" + j);
					
					if(!recordset.containsObject(s1))
						recordset.putObject(s1);
                }
            }

			paramsSize =  recordset.getSize();

  			formats = new String[paramsSize];
			formatCheck = new String[paramsSize];

			for(int i = 0; i < recordset.getSize(); i++)
			{
                formats[u] = (String)recordset.getObject(i);
                u++;
			}

			boolean local_ejbs = false;
	
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/NoteTypeByService",NoteTypeByServiceHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			
			Object argArray[] = new Object[5];
			argArray[0] = p;
			argArray[1] = note_type;
			argArray[2] = formats;
			argArray[3] = facilityId;
			argArray[4] = client_ip_address;
		
			Class [] paramArray = new Class[5];
			paramArray[0] = p.getClass();
			paramArray[1] = note_type.getClass();
			paramArray[2] = formats.getClass();
			paramArray[3] = facilityId.getClass();
			paramArray[4] = client_ip_address.getClass();
	
			java.util.Hashtable results = (java.util.Hashtable)(busObj.getClass().getMethod("insertNoteType",paramArray)).invoke(busObj,argArray);
		
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			
			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

			error     =(String) results.get("error") ;
			results.clear();

			if ( inserted )
			{
				error_value = "1" ;

				if(error.lastIndexOf("<br>")>=0)
					error=error.substring(0,error.lastIndexOf("<br>"));
			}
			else
			{		
				if(error.lastIndexOf("<br>")>=0)
					error=error.substring(0,error.lastIndexOf("<br>"));
			}

			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8") +"&err_value="+error_value);
		} 
		catch ( Exception e ) 
		{
			//out.println("Exception has occured here ...."+e);common-icn-0181
			
			e.printStackTrace();
			//out.println(e.getMessage());//common-icn-0181
			//out.println(e.toString());//common-icn-0181
			//out.println("except U3"+e);//common-icn-0181
		}
	}//E.o.Method InsertAssignBed
}

