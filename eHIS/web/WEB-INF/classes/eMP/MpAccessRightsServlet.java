/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/****** Last Modified Date Time 9/22/2005 11:21 AM *****/
package eMP;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import webbeans.eCommon.*;
import eMP.AccessRights.*;

public class MpAccessRightsServlet extends javax.servlet.http.HttpServlet
{
    PrintWriter out;
    java.util.Properties p;
    String facilityId ;
    String client_ip_address ;
	int maxRecords = 0 ;
	String resp_id = "";
	String view_pat_photo_yn = "";
	String view_pat_fin_dtls_yn = "";
 
    HttpSession session;
    java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;


    public void init(ServletConfig config) throws ServletException
    {
        super.init(config);
    }

    public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
    {
        session = req.getSession(false);
        this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
        this.facilityId = (String) session.getValue( "facility_id" ) ;
        this.client_ip_address = p.getProperty("client_ip_address");
      
        try
        {
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");            
            this.out = res.getWriter();

            modifyAccessRights(req, res);
        }
        catch(Exception e)
        {
            out.println(e.toString());
        }
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
    {
        try
        {
            this.out = res.getWriter();
            req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");

            String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
            String params = req.getQueryString() ;
            String source = url + params ;

            out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link><script language='javascript' src='../eMP/js/MPAuditTrialParameter.js'></script></head><frameset rows='42,*,50'><frame name='commontoolbarFrame' src='"+source+"' frameborder=0 scrolling='no' noresize> <frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0><frame name='messageFrame' src='../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto'></frameset></html> ");
        }
        catch(Exception e)  {   }
    }

    private void modifyAccessRights(HttpServletRequest req, HttpServletResponse res)
    {
        try
        {

            HashMap tabdata=new HashMap();

            maxRecords = Integer.parseInt((String)req.getParameter("maxRecords"));

			for (int i=1;i<=maxRecords; i++ )
			{
				

 			  resp_id = req.getParameter("RespId"+i);
			  view_pat_photo_yn = req.getParameter("viewpatphotoyn"+i)==null?"N":req.getParameter("viewpatphotoyn"+i);
			  view_pat_fin_dtls_yn = req.getParameter("viewpatfindtlsyn"+i)==null?"N":req.getParameter("viewpatfindtlsyn"+i);
			
			tabdata.put("RespId"+i,resp_id);
			tabdata.put("viewpatphotoyn"+i,view_pat_photo_yn);
			tabdata.put("viewpatfindtlsyn"+i,view_pat_fin_dtls_yn);
			

			}
				String slCount	=	""+maxRecords;
		
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
                tabdata.put("ilCount", new Integer(slCount) );

                
					boolean local_ejbs = false;

					if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/AccessRights",AccessRightsHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);


			Object argArray[] = new Object[2];
			argArray[0] = p;
			argArray[1] = tabdata;
			
			Class [] paramArray = new Class[2];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();
				
			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insertAccessRights",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);


                    boolean inserted = ( ((Boolean) results.get("status")).booleanValue() ) ;
                    String error ;
                    String error_value = "0" ;

                    error = (String) results.get("message") ;
                    if ( inserted ) {
                         error_value = "1" ;
                    } else {
                         error = (String) results.get("error") ;
                    }					

					tabdata.clear();
					results.clear();
                    res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
              }
        catch ( Exception e )
        {
            //out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			e.printStackTrace();
        }
    }
}
