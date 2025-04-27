/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eAM;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.Date;
import java.sql.Timestamp;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Properties;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
//import javax.servlet.SingleThreadModel;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.MessageManager;
import webbeans.eCommon.RecordSet;
			
public class SpecialtyForExternalReferralSourceServlet extends HttpServlet 
{
	PrintWriter out;
    String mysql;
    Properties p;
    String facility = "";
	//String recordCount = "";
    String facilityId;
    String client_ip_address;
    //String serviceURL;
    //String objectName;
	String error	=	"";
	String error_value	=	"0";
	        String locale="";

	int size = 0;
	public final String RECORD_MODIFIED = "RECORD_MODIFIED" ;


	int retval = 0;
    HttpSession session;
   
	//java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	public void init(ServletConfig servletconfig) throws ServletException
    {
        super.init(servletconfig);
    }
	/*public void doGet(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
        throws ServletException, IOException
    {
        try
        {
            out = httpservletresponse.getWriter();
            httpservletresponse.setContentType("text/html");
            out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link><script language='javascript' src='../../eAM/js/SpecialtyForExternalRefrralSource.js'></script></head><frameset rows='60,*,50'><frame name='commontoolbarFrame' src='../eCommon/jsp/commonToolbar.jsp?function_name=Specialty for External Referral Source' frameborder=0 scrolling='no' noresize><frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0><frame name='messageFrame' src='../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto'></frameset></html> ");
        }
        catch(Exception _ex) { }
    }*/
	public synchronized void doPost(HttpServletRequest httpservletrequest, HttpServletResponse 	httpservletresponse) throws ServletException, IOException
    {
		
        session = httpservletrequest.getSession(false);
        p = (Properties)session.getValue("jdbc");
        facilityId = (String)session.getValue("facility_id");
        client_ip_address = p.getProperty("client_ip_address");
 locale= p.getProperty("LOCALE");
        try
        {
            httpservletresponse.setContentType("text/html");
            out = httpservletresponse.getWriter();
			ServiceAddModify(httpservletrequest);
        }
        catch(Exception exception)
        {
            out.println(exception.toString());
        }
    }
    private void ServiceAddModify(HttpServletRequest httpservletrequest)
    {
	//	Object obj			= null;
		RecordSet recordset = null;
		java.sql.Connection connection = null;
		PreparedStatement  pst = null;
		PreparedStatement  pst1 = null;

		String s2 = "";
        String s3 = "";


		String addedById = p.getProperty( "login_user" ) ;
//		String addedDate = dateFormat.format( new java.util.Date() ) ;
		//String modifiedById = addedById ;
//		String modifiedDate = addedDate ;
		String addedFacilityId=facilityId;
		String modifiedFacilityId = addedFacilityId ;
//		String addedAtWorkstation=client_ip_address;
		//String modifiedAtWorkstation = addedAtWorkstation ;

		//java.sql.Date added_date = java.sql.Date.valueOf(addedDate) ;
		//java.sql.Date modified_date = java.sql.Date.valueOf(modifiedDate) ;

		try
		{
			connection = ConnectionManager.getConnection(httpservletrequest);
			connection.setAutoCommit(false);

			//recordCount = httpservletrequest.getParameter("recordCount");
			facility    = httpservletrequest.getParameter("facility");
			
				 mysql = "DELETE FROM  AM_REFERRAL_FOR_SPECIALTY WHERE REFERRAL_CODE = ?";
				try
				{
					pst = connection.prepareStatement(mysql);
					pst.setString(1,facility);
					retval = pst.executeUpdate();
										
					if(retval >= 0)
					{
						try
						{
							s2 = httpservletrequest.getParameter("from") != null ? httpservletrequest.getParameter("from") : "0";
							s3 = httpservletrequest.getParameter("to") != null ? httpservletrequest.getParameter("to") : "0";

							recordset = (RecordSet)session.getAttribute("ReferralSpeciality");
							if(s2 != null && s3 != null)
							{
				                s2 = s2.trim();
								s3 = s3.trim();
				                for(int j = Integer.parseInt(s2); j <= Integer.parseInt(s3); j++)
								if(httpservletrequest.getParameter("chk"+j) != null)
								{
									String s1 = httpservletrequest.getParameter("chk"+j);
									if(!recordset.containsObject(s1))
										recordset.putObject(s1);
								}
							}


							size = recordset.getSize();
							for(int k=0;k<size;k++)
							{
								String speciality_code = (String)recordset.getObject(k);
								String mysql1 = "INSERT INTO AM_REFERRAL_FOR_SPECIALTY(REFERRAL_CODE, SPECIALTY_CODE, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO,ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID)VALUES (?,?,?,sysdate,?,?,?,sysdate,?,?)";
								
								if (pst1 != null)  pst1 = null;
								pst1 = connection.prepareStatement(mysql1);

								pst1.setString(1,facility);
								pst1.setString(2,speciality_code);
								pst1.setString(3,addedById);
								pst1.setString(4,client_ip_address);
								pst1.setString(5,modifiedFacilityId);
								pst1.setString(6,addedById);
								pst1.setString(7,client_ip_address);
								pst1.setString(8,modifiedFacilityId);

								retval = pst1.executeUpdate();
								if(pst1 != null) pst1.close();
							}
						}
						catch (Exception exception)
						{
							error	=	exception.toString();
						}
						if(retval > 0)
						{
							error_value = "1" ;
							java.util.Hashtable message = MessageManager.getMessage(locale, RECORD_MODIFIED ,"SM") ;
							error	= (String) message.get("message") ;
							connection.commit();
							message.clear();
						}
					}
					}
					catch (Exception exception)
					{
						error	=	exception.toString();
					}
					out.println("<script>parent.messageFrame.location.href='../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode(error,"UTF-8")+"&err_value="+error_value+"';</script>");
		}
		catch(Exception e)
		{
				out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
		}
		finally
		{
			try
			{
				if(pst != null)  pst.close();
				
				ConnectionManager.returnConnection(connection,httpservletrequest);
			}
			catch(Exception cEx){}
		}
	}
}
