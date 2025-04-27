/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eAM;

/**
 *		FileName : Serviceinfacility.java
 *		Version	 : 3
 *		Date	 : 14-2-05	
**/
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import webbeans.eCommon.*;

public class ServiceinfacilityServlet extends HttpServlet
{
    PrintWriter out;
    Properties p;
    PreparedStatement pslPrepStmt;
    PreparedStatement psldelStmt;
    String facilitycode;
    String servicecode;
    String deptcode;
    Connection con;
    String effectiveStatus;
    String facilityId;
	String locale="";

    String client_ip_address;
    //String serviceURL;
    //String objectName;
    HttpSession session;
    int count;
	//java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

    public synchronized void doPost(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
        throws ServletException, IOException
    {
        session = httpservletrequest.getSession(false);
        facilityId = (String)session.getValue("facility_id");
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.client_ip_address = p.getProperty("client_ip_address");
 locale= p.getProperty("LOCALE");
		//Connection object
        con = ConnectionManager.getConnection(httpservletrequest);
        try
        {
            httpservletresponse.setContentType("text/html");
            out = httpservletresponse.getWriter();
            String s = httpservletrequest.getParameter("function_name");
            if(s == null)
                s = "";
            if(s.equals("insert"))
                insertServiceinfacility(httpservletrequest, httpservletresponse);
        }
        catch(Exception exception)
        {
            out.println(exception.toString());
        }
        finally
        {
            ConnectionManager.returnConnection(con, httpservletrequest);
        }
    }

   /* public void doGet(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
        throws ServletException, IOException
    {
        try
        {
            out = httpservletresponse.getWriter();
            httpservletresponse.setContentType("text/html");
            out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link><script language='javascript' src='../eAM/js/Subservice.js'></script></head><frameset rows='60,*,50'><frame name='commontoolbarFrame' src='../eCommon/jsp/MstCodeToolbar.jsp?function_name=Occupation' frameborder=0 scrolling='no' noresize><frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0><frame name='messageFrame' src='../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto'></frameset></html> ");
        }
        catch(Exception exception) { }
    }*/

    private void insertServiceinfacility(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
    {
        try
        {
            String s = httpservletrequest.getParameter("count") != null ? httpservletrequest.getParameter("count") : "0";
            count = Integer.parseInt(s);
            out.println("count "+ count);

            String totalvalues=httpservletrequest.getParameter("totalvalues") != null ? httpservletrequest.getParameter("totalvalues") : "";

            facilitycode = httpservletrequest.getParameter("operating_facility_id");
            deptcode = httpservletrequest.getParameter("dept_code");
            String s3 = p.getProperty("login_user");
            String s5 = s3;
            String s7 = facilityId;
            String s8 = s7;
            String s9 = client_ip_address;
            String s10 = s9;
            HashMap hashmap = new HashMap();
				hashmap.put("added_by_id", s3);
				hashmap.put("modified_by_id", s5);
				hashmap.put("modified_facility_id", s8);
				hashmap.put("modified_at_ws_no", s10);
            String s19 = "";
            int k = 0;
            out.println("totalvalues "+ totalvalues);
            StringTokenizer stringtokenizer = new StringTokenizer(totalvalues, "~");
            int maintkn=stringtokenizer.countTokens();
              for(int j=0;j<maintkn;j++)
              {
				String st4=stringtokenizer.nextToken();
				StringTokenizer st5=new StringTokenizer(st4,"$");
				String s12 = st5.nextToken();
                String s14 = st5.nextToken();
              //  String s16 = st5.nextToken();

		
					String del = "delete from am_facility_service where  service_code='"+s12+"'  and operating_facility_id='"+facilitycode+"' and  DEPT_CODE='"+deptcode+"'";
					psldelStmt = con.prepareStatement(del);
					k = psldelStmt.executeUpdate();
					if(psldelStmt!=null)
						psldelStmt.close();
					
                    s19 = "insert into am_facility_service  ( operating_facility_id,service_code ,dept_code,eff_status,added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no ,modified_facility_id ) values('"+facilitycode+"','"+s12+"','"+deptcode+"','"+s14+"','"+s3+"',sysdate,'"+s9+"','"+s8+"','"+s3+"',sysdate,'"+s9+"','"+s8+"') ";
                    
					pslPrepStmt = con.prepareStatement(s19);
                   	k = pslPrepStmt.executeUpdate();
					if( pslPrepStmt!=null)
						pslPrepStmt.close();
               
				/*else if(s16.equals("Y") && s14.equals("D"))
                {
                   String s18 = " update am_facility_service set eff_status=?,modified_by_id=?,modified_date=sysdate,modified_at_ws_no =? ,modified_facility_id=? ,dept_code=? where service_code=?  and operating_facility_id=? ";

                   pslPrepStmt = con.prepareStatement(s18);
                   pslPrepStmt.setString(1, s14);
                   pslPrepStmt.setString(2,s5);
                   pslPrepStmt.setString(3,s10);
                   pslPrepStmt.setString(4,s8);
                   pslPrepStmt.setString(5, deptcode);
                   pslPrepStmt.setString(6, s12);
                   pslPrepStmt.setString(7, facilitycode);

                   k = pslPrepStmt.executeUpdate();
		        }*///if ends
     		}//for ends
            hashmap.clear();

            String s20 = "";
            if(k == 1)
            {
                con.commit();
                Map map1 = MessageManager.getMessage(locale, "RECORD_INSERTED","SM");
                s20 = (String)map1.get("message");				
                httpservletresponse.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode(s20,"UTF-8" ) + "&err_value=1");
				map1.clear();
            } 
			else
            {
                con.rollback();
                httpservletresponse.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode(s20,"UTF-8" ) + "&err_value=1");
            }
        }
        catch(Exception exception)
        {
            out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : " + exception.toString());
            out.println("Values sent are : <br>");
            out.println(facilitycode + "  " + servicecode + "  " + deptcode + "  " + effectiveStatus);
        }
		finally
		{
			try
			{
				if(psldelStmt!=null) psldelStmt.close();
				if(pslPrepStmt!=null) pslPrepStmt.close();
			}catch(Exception e){out.print("Exception in closing statement " + e);}
		}
    }
}
