/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eAE;

import java.sql.*;
import java.io.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.naming.*;
import javax.rmi.*;
import com.ehis.util.*;

import eCommon.SingleTabHandler.*;

public class ReserveBedServlet extends HttpServlet implements SingleThreadModel{
	PrintWriter out;
	String facilityId;
	HttpSession session;
	Properties p;
	String client_ip_address;

	boolean inserted		= false;
	String reserve_until	=	"";
	Timestamp timestamp;	                                
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	String locale="";

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		this.out = res.getWriter();
		try	
		{
			session 		= req.getSession(true);
			this.facilityId = checkForNull((String) session.getValue("facility_id"));
			this.p			= (java.util.Properties) session.getValue( "jdbc" ) ;

			this.client_ip_address	=	p.getProperty("client_ip_address");
			reserve_until			=	checkForNull(req.getParameter("reserve_until"));
			locale			    =   p.getProperty("LOCALE");
			reserve_until=DateUtils.convertDate(reserve_until,"DMYHM",locale,"en");


			StringTokenizer toks = new StringTokenizer(reserve_until," ") ;
            			if(toks.hasMoreTokens()) 
			{
				StringTokenizer tok1 = new StringTokenizer(toks.nextToken(),"/");
				String arr[] =new String[3] ;
				for( int i=0;i<3;i++ )
				{        
					if(tok1.hasMoreTokens()) 
					{
					arr[i] = tok1.nextToken() ;
					}
				}

			while (toks.hasMoreTokens()) 
			reserve_until = arr[2] + "-" + arr[1] + "-" + arr[0] + " " + toks.nextToken() + ":00";
			}
			timestamp		= Timestamp.valueOf(reserve_until);
			modifyReserveBed(req, res);

		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}


 private void  modifyReserveBed(HttpServletRequest req, HttpServletResponse res){
  try{
        
		String addedById			= p.getProperty( "login_user" ) ;
		String addedDate			= dateFormat.format( new java.util.Date() ) ;
		String modifiedById			= addedById ;
		String modifiedDate			= addedDate ;
		String addedFacilityId		= facilityId;
		String modifiedFacilityId	= addedFacilityId ;
		String addedAtWorkstation	=client_ip_address;
		String modifiedAtWorkstation= addedAtWorkstation ;

		java.sql.Date modified_date1= java.sql.Date.valueOf(modifiedDate ) ;
	    java.sql.Date modified_date = new java.sql.Date(modified_date1.parse(modified_date1.toLocaleString())-(modified_date1.getTimezoneOffset()*60*1000) ) ; 

		java.util.HashMap tabdata=new HashMap();

		tabdata.put("CURRENT_STATUS","R");
		tabdata.put("REASON_FOR_RESERVE",req.getParameter("reasons")== null ?"":req.getParameter("reasons"));
		tabdata.put("OCCUPIED_UNTIL_DATE_TIME",timestamp);
		tabdata.put("MODIFIED_BY_ID",modifiedById);
		tabdata.put("MODIFIED_DATE",modified_date);
		tabdata.put("MODIFIED_FACILITY_ID",modifiedFacilityId);
		tabdata.put("MODIFIED_AT_WS_NO",modifiedAtWorkstation );

		java.util.HashMap condflds=new HashMap();
		condflds.put("CLINIC_CODE",req.getParameter("clinic")== null ?"":req.getParameter("clinic"));
		condflds.put("TREATMENT_AREA_CODE",req.getParameter("treatment_area")== null ?"":req.getParameter("treatment_area"));
		condflds.put("BED_NO",req.getParameter("bed_no")== null ?"":req.getParameter("bed_no"));
		condflds.put("FACILITY_ID",facilityId);

		boolean local_ejbs = false;
		String tablename ="AE_BED_FOR_TRMT_AREA";

		if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		
		Object argArray[] = new Object[4];
		argArray[0] = p;
		argArray[1] = tabdata;
		argArray[2] = condflds;
		argArray[3] = tablename;

		Class [] paramArray = new Class[4];
		paramArray[0] = p.getClass();
		paramArray[1] = tabdata.getClass();
		paramArray[2] = condflds.getClass();
		paramArray[3] = tablename.getClass();


		java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
		
		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

		inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

		String error = (String) results.get("error") ;
		String error_value = "0" ;
		
		   if ( inserted )
		   {
				error_value= "1";
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=" + error_value );
		   }
		   else
		   {
			   MessageManager mm=new MessageManager();
			   final java.util.Hashtable mesg = mm.getMessage(locale, "BED_RESERVN_FAILED", "AE") ;
			   String msg = ((String) mesg.get("message"));
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num="+msg+ java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=" );
				mesg.clear();
		   }
		   tabdata.clear();
		   condflds.clear();
		   results.clear();
	  }catch ( Exception e )
      {
		e.printStackTrace();
		//out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
      }
  } // End of the modifyParameter
	/**** To Handle java.lang.NullPointerException. *****/
	public static String checkForNull(String inputString)
	{
		return ( ((inputString == null) || (inputString.equalsIgnoreCase("null"))) ? "" : inputString );
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return ( ((inputString == null) || (inputString.equalsIgnoreCase("null"))) ? defaultValue : inputString );
	}

} // End of the Class
