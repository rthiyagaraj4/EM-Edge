/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIP;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.rmi.*;
import webbeans.eCommon.*;
import eIP.IPDayCareUnit.IPDayCareUnitHome;

public class DaycareUnitServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel
{
	PrintWriter out;
	Properties p			 = null;
	String client_ip_address = "";
    String facilityId		 = "";
	HttpSession session;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public  void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		session			  = req.getSession(false);
		this.p			  = (java.util.Properties) session.getValue("jdbc") ;
		this.facilityId   = (String) session.getValue("facility_id") ;
		client_ip_address = p.getProperty("client_ip_address");

		try
		{
			
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			this.out		= res.getWriter();
			insertDaycare(req,res);			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	private void insertDaycare(HttpServletRequest req,HttpServletResponse res)
	{
		    Connection con			 = null;

		try
		{
			con						 = ConnectionManager.getConnection(req);	
			String s2				 = "";
			String s3				 = "";
			String search_by		 ="";	
			String search_txt		 ="";	
			int    i				 = 0;
			RecordSet recordset      = null;
			HashMap hashmap		     = new HashMap();
			s2					     = checkForNull_int(req.getParameter("from"));
			s3					     = checkForNull_int(req.getParameter("to"));
			search_txt				 = checkForNull(req.getParameter("search_txt"));
			search_by				 = checkForNull(req.getParameter("search_by"));
			recordset			     = (RecordSet)session.getAttribute("DayCareUnitSpeciality");

			if(s2 != null && s3 != null)
			{
				s2 = s2.trim();
				s3 = s3.trim();

				for(int j = Integer.parseInt(s2); j <= Integer.parseInt(s3); j++)
				{
				  if(req.getParameter("chk" + j) != null)
						{
							String s1 = req.getParameter("chk" + j);
							if(!recordset.containsObject(s1))
								recordset.putObject(s1);
						}
					String removeCode = checkForNull(req.getParameter("removeCode"+(j)));
					if(removeCode.equals("Y"))
					{
						String spclCode = req.getParameter("spclCode"+(j));
						if((recordset.containsObject(spclCode)))
						{
							int removeCodeIndex = recordset.indexOfObject(spclCode);
							recordset.removeObject(removeCodeIndex);
						}
					}
				}
			}

			for(i = 0; i < recordset.getSize(); i++)
				hashmap.put("chk" + i, (String)recordset.getObject(i)); //put the clinic codes here

			String counter			     = "" + recordset.getSize();
			String error_value		     = "0";
			String error			     = "";
			String modifiedById          = p.getProperty("login_user");
			boolean inserted             = false;
			String modifiedFacilityId    = facilityId;
			String modifiedAtWorkstation = client_ip_address;
			Timestamp added_date         = new Timestamp(System.currentTimeMillis());

			hashmap.put("FACILITY_ID",facilityId);
			hashmap.put("nursing_unit_code",checkForNull(req.getParameter("nursing_unit_code")));
			hashmap.put("added_by_id",modifiedById);
			hashmap.put("added_date",added_date);
			hashmap.put("added_facility_id", facilityId);
			hashmap.put("added_at_ws_no",modifiedFacilityId);
			hashmap.put("modified_by_id",modifiedById);
			hashmap.put("modified_date",added_date);
			hashmap.put("modified_facility_id",modifiedFacilityId);
			hashmap.put("modified_at_ws_no",modifiedAtWorkstation );
			hashmap.put("totCount",new Integer(counter) );
			hashmap.put("search_txt",search_txt);
			hashmap.put("search_by",search_by);

			boolean local_ejbs = false;

			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home			= com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/IPDayCareUnit",IPDayCareUnitHome.class,local_ejbs);
			Object busObj		= (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[]	= new Object[2];
			argArray[0]		    = p;
			argArray[1]         = hashmap;

			Class [] paramArray = new Class[2];
			paramArray[0]		= p.getClass();
			paramArray[1]		= hashmap.getClass();

			HashMap results		= (java.util.HashMap)(busObj.getClass().getMethod("DayCareUnitAddModify",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			inserted		    = ( ((Boolean) results.get("status")).booleanValue() );

			error				= (String) results.get("error") ;
			error_value			= "0" ;                

			if(inserted)
			{
				error_value			= "1" ;
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value);
			}
			else
			{
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
			}

			hashmap.clear();
			results.clear();
		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
		finally
		{
			 ConnectionManager.returnConnection(con,req);
		}
	}

	public static String checkForNull(String inputString)
	{
	 return((inputString==null)? "": inputString);
	}

	public static String checkForNull_int(String inputString)
	{
		return((inputString==null)? "0": inputString);
	}
}
