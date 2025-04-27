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
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;

import eIP.IPNursUnitService.*;

public class NursUnitServiceServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel
{
	PrintWriter out;
	java.util.Properties p;

	String nursing_unit_code;
	String dept_code;
	String facilityId ;
	String sStyle;
	String client_ip_address ;
	HttpSession session;
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		try
		{
			this.out = res.getWriter();
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/"+sStyle+"'></link><script language='javascript' src='/eCIS/ip/js/NursUnitRoom.js'></script></head><frameset rows='60,*,50'><frame name='commontoolbarFrame' src='../eCommon/jsp/commonToolbar.jsp?function_name=Rooms For Nursing Unit' frameborder=0 scrolling='no' noresize><frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0><frame name='messageFrame' src='../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto'></frameset></html> ");
		}
		catch(Exception e)	{e.printStackTrace();	}

		session = req.getSession(false);
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.facilityId = (String) session.getValue( "facility_id" ) ;
		sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		client_ip_address = p.getProperty("client_ip_address");

		try
		{
			ServiceAddModify(req,res);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}


	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		try
		{
			doPost(req,res);		
		}
		catch(Exception e)	
		{	
			e.printStackTrace();
		}
	}

	private void ServiceAddModify(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			HashMap tabdata				= new HashMap();
			RecordSet NursUnitService	=	null;
			RecordSet NursUnitDeptService	=	null;
			String checkedOnes			= "";
			String checkedDeptOnes		= "";


			int recordCount				= 0;
			String	from			=  "",	to		=	"",maxRecord = "";
			nursing_unit_code		=  req.getParameter("nursing_unit_code");
			if ( nursing_unit_code  == null) nursing_unit_code="";

			String search_by    = req.getParameter("search_by") ;
		    if(search_by == null || search_by.equals("null")) search_by="";

		    String search_txt   = req.getParameter("search_txt") ;
		    if(search_txt == null || search_txt.equals("null")) search_txt="";

			dept_code				=  req.getParameter("dept_code");

			if(dept_code == null)      dept_code="";

			tabdata.put("nursing_unit_code",nursing_unit_code );
			tabdata.put("dept_code",dept_code);

			from = (req.getParameter("from")== null) ? "0":req.getParameter("from");
			to   = (req.getParameter("to")  == null) ? "0":req.getParameter("to");
			maxRecord   = (req.getParameter("maxRecord")  == null) ? "":req.getParameter("maxRecord");
			recordCount = Integer.parseInt(maxRecord);
			NursUnitService	= (webbeans.eCommon.RecordSet)session.getAttribute("NursUnitService");
			NursUnitDeptService	= (webbeans.eCommon.RecordSet)session.getAttribute("NursUnitDeptService");
			if(recordCount < 12)
			{
				NursUnitService.clearAll();
				NursUnitDeptService.clearAll();
			}

			if(from != null && to != null)
			{
				from	=	from.trim();
				to		=	to.trim();
				for( int i=(Integer.parseInt(from)); i<=(Integer.parseInt(to)); i++)
				{
					if(req.getParameter(("chk"+i)) != null)
					{
						checkedOnes = req.getParameter(("chk"+i));
                        checkedDeptOnes = req.getParameter("deptCode"+(i));
						if(!(NursUnitService.containsObject(checkedOnes)))
						{
							NursUnitService.putObject(checkedOnes);

							NursUnitDeptService.putObject(checkedDeptOnes);
						}
					}

						String removeCode = checkForNull(req.getParameter("removeCode"+(i)));
						if(removeCode.equals("Y"))
						{
							String spclCode = req.getParameter("spclCode"+(i));
							if((NursUnitService.containsObject(spclCode)))
							{
								int removeCodeIndex = NursUnitService.indexOfObject(spclCode);
								{
									NursUnitService.removeObject(removeCodeIndex);
									NursUnitDeptService.removeObject(removeCodeIndex);
								}
							}
						}
				}
			}
			for(int i=0;i<NursUnitService.getSize();i++)
			{
				tabdata.put( ("chk"+i), (String)NursUnitService.getObject(i));
				tabdata.put( ("dept"+i), (String)NursUnitDeptService.getObject(i));
			}
			String slCount	=	""+NursUnitService.getSize();
			String addedById = p.getProperty( "login_user" ) ;
			String addedDate = dateFormat.format( new java.util.Date() ) ;
			String modifiedById = addedById ;
			String modifiedFacilityId = facilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;

			java.sql.Date added_date1 = java.sql.Date.valueOf( addedDate ) ;
			java.sql.Date added_date = new java.sql.Date(added_date1.parse(added_date1.toLocaleString())-(added_date1.getTimezoneOffset()*60*1000) ) ;

			tabdata.put("facilityId",facilityId);
			tabdata.put("added_date", added_date);
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );
			tabdata.put("totCount", new Integer(slCount) );

			tabdata.put("search_by",search_by);
			tabdata.put("search_txt",search_txt);

			boolean local_ejbs = false;

			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/IPNursUnitService",IPNursUnitServiceManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = p;
			argArray[1] = tabdata;

			Class [] paramArray = new Class[2];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();

			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("ServiceAddModify",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			String error_value = "0" ;

			if ( inserted ) error_value = "1" ;
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );

			tabdata.clear();
			results.clear();

			}catch ( Exception e ) 
			{
				e.printStackTrace();
			}
		}

		public static String checkForNull(String inputString)
		{
			return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
		}

		public static String checkForDefault(String inputString, String Default)
		{
			return(((inputString==null) || (inputString.equals("null"))) ? Default : inputString);
		}
}
