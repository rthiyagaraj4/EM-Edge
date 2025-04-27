/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eFM;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.*;
import java.io.*;
import javax.rmi.*;
import javax.naming.*;
import javax.ejb.*;
import eFM.FMRegFilesNotPulled.*;
import webbeans.eCommon.*;
import webbeans.st.RecordSetBean;

public class FMRegFilesNotPulledServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel
{
	String locale			= "" ;

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,java.io.IOException
	{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		java.io.PrintWriter out = response.getWriter();
		java.util.Properties p=null;
		String client_ip_address="";	
		HttpSession session=request.getSession(false);
							

		try
		{
			String CBValStr="", facility_id="";			
			Hashtable   htRecord	=	new Hashtable();

			boolean inserted=false;
			String error="", error_value="";

			facility_id							=	(String)session.getValue("facility_id");
			webbeans.st.RecordSetBean recordSet	=	(RecordSetBean)session.getValue("recordSet");
			CBValStr		=	request.getParameter("CBValStr");

			if(CBValStr == null || CBValStr.equals("null"))CBValStr="";			

			if(!(CBValStr.equals("")))
			{
				StringTokenizer stoken_yn = new StringTokenizer(CBValStr,"~");
				int count_yn			  =	stoken_yn.countTokens();
				for(int i=0;i<count_yn;i++)
				{
					String pull_yn		=	stoken_yn.nextToken();
					String index_val	=	pull_yn.substring(7);					
					int index			=	Integer.parseInt(index_val);					
					htRecord			=	(java.util.Hashtable)	recordSet.getObject(index);
					htRecord.put("file_pull_yn"		,	"Y");
					htRecord.put("locale"		,	locale);
					recordSet.setObject((index),htRecord);
				}
			}
             p = (java.util.Properties) session.getValue( "jdbc" ) ;
	 		locale = p.getProperty("LOCALE");
			client_ip_address = p.getProperty("client_ip_address");		
			
		boolean local_ejbs = false;
					if((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
					
					Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/FMRegFilesNotPulled",FMRegFilesNotPulledHome.class,local_ejbs);
					Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
					
					Object argArray[] = new Object[4];
					argArray[0] = p;
					argArray[1] = recordSet;
					argArray[2] = facility_id;
					argArray[3] = client_ip_address;
					
					
					Class [] paramArray = new Class[4];
					paramArray[0] = p.getClass();
					paramArray[1] = recordSet.getClass();
					paramArray[2] = facility_id.getClass();
					paramArray[3] = client_ip_address.getClass();
					
					
					java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("updateFMFilePullYN",paramArray)).invoke(busObj,argArray);
					(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			inserted	= ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			error		= (String) results.get("error") ;
			htRecord.clear();
			results.clear();
						

			if(inserted)
			{
				error_value="1";
				response.sendRedirect("../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( error,"UTF-8" )+ "&err_value=" + error_value );
			}
			else
			{
				error_value="0";
				response.sendRedirect("../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( error,"UTF-8" )+ "&err_value=" + error_value );
			}
		}
		catch(Exception e)
		{
			out.println("Exception in main try"+e);
		}		
	}//end of doPost
}//end of Main class


		




