/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
// This servlet is used to call the ejb for adding the rooms for the nursing unit.
// @version - V3

package eIP;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.ejb.*;
import java.rmi.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;

import eIP.IPNursUnitRoom.*;

public class NursUnitRoomServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel
{
	PrintWriter out;
	java.util.Properties p;

	String nursing_unit_code;
	String sStyle;
	String facilityId ;
	String client_ip_address ;
	String addedById;
	HttpSession session;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		try
		{
			this.out		= res.getWriter();
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			//out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/"+sStyle+"'></link><script language='javascript' src='/eCIS/ip/js/NursUnitRoom.js'></script></head><frameset rows='60,*,50'><frame name='commontoolbarFrame' src='../eCommon/jsp/commonToolbar.jsp?function_name=Rooms For Nursing Unit' frameborder=0 scrolling='no' noresize><frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0><frame name='messageFrame' src='../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto'></frameset></html> ");
		}
		catch(Exception e)	{/* out.println(e.toString()); */ e.printStackTrace();	}
		session				= req.getSession(false);
		this.p				= (java.util.Properties) session.getValue( "jdbc" ) ;
		this.facilityId		= (String) session.getValue( "facility_id" ) ;
		sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		client_ip_address	= p.getProperty("client_ip_address");
		addedById			= p.getProperty( "login_user" ) ;
	
		try
		{
			NursUnitAddModify(req,res);
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

	/**
	This method is used to invoke the ejb methods for 
	@author - 
	@version - V3
	@param1 - javax.servlet.http.HttpServletRequest
	@param2 - javax.servlet.http.HttpServletResponse
	@return - void
	*/
	private void NursUnitAddModify(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			
			HashMap		tabdata		= new HashMap();
		    String		Update_yn		= checkForNull(req.getParameter("Update_yn"));
		    String		search_by		= checkForNull(req.getParameter("search_by"));
		    String		search_txt		= checkForNull(req.getParameter("search_txt"));
			RecordSet accessRightRecSet	= null;
			RecordSet  accessRightRec	= null;
			RecordSet  accessRight	    = null;
			String LevelVal				= "";
			String no_of_beds			= "";
			//int		max_record			= Integer.parseInt(norecords.trim());
			String maxrecord			= checkForNull(req.getParameter("maxRecord"));
			int max_rec					= Integer.parseInt(maxrecord.trim());
			nursing_unit_code			= checkForNull(req.getParameter("nursing_unit_code"));
			//Hashtable	htRecord		= new Hashtable();
            String		checkedOnes		= "";
            String		from			= checkForNull(req.getParameter("from"));
			String		to				= checkForNull(req.getParameter("to"));

			accessRightRecSet			= (webbeans.eCommon.RecordSet)session.getAttribute("AXSRightRecSet");
			accessRightRec				= (webbeans.eCommon.RecordSet)session.getAttribute("AXSRightRec");
			accessRight  				= (webbeans.eCommon.RecordSet)session.getAttribute("AXSRight");

			int		n_from				= Integer.parseInt(from.trim());
			int		n_to				= Integer.parseInt(to.trim());

		
			/* END OF ADDITION FOR LEVEL OF CARE */
			if(max_rec < 14)
			{
				accessRightRecSet.clearAll();
				accessRightRec.clearAll();
				accessRight.clearAll();
			}

			if(from != null && to != null)
			{
				for( int i= n_from; i<=n_to; i++)
				{
					if(req.getParameter(("chk"+i)) != null)
					{
						checkedOnes = req.getParameter(("chk"+i));
						LevelVal = req.getParameter(("level"+i));
						no_of_beds = req.getParameter(("no_of_beds"+i));
	
						if(!(accessRightRecSet.containsObject(checkedOnes)))
						{
							accessRightRecSet.putObject(checkedOnes);
							accessRightRec.putObject(LevelVal);
							accessRight.putObject(no_of_beds);	
				

						}
					}

					String removeCode = checkForNull(req.getParameter("removeCode"+(i)));
					if(removeCode.equals("Y"))
						{ 
							if(req.getParameter("rm_num"+(i)) != null)
							 {
								String rm_num = req.getParameter("rm_num"+(i));
								if(accessRightRecSet.containsObject(rm_num))
								{
									int removeCodeIndex = accessRightRecSet.indexOfObject(rm_num);
									accessRightRecSet.removeObject(removeCodeIndex);
									accessRightRec.removeObject(removeCodeIndex);
									accessRight.removeObject(removeCodeIndex);	
								}
							 }
							
						}
				}
			
			
			}
			
			for(int i=0;i<=accessRightRecSet.getSize();i++)
			{
				tabdata.put( ("chk"+i),(String)accessRightRecSet.getObject(i) );
				tabdata.put( ("level"+i),(String)accessRightRec.getObject(i));
				tabdata.put( ("no_of_beds"+i),(String)accessRight.getObject(i) );

			}
			

			String slCount = ""+accessRightRecSet.getSize();
			tabdata.put("nursing_unit_code",nursing_unit_code );
			tabdata.put("facilityId",facilityId);
			tabdata.put("modified_by_id",addedById);
			tabdata.put("modified_facility_id",facilityId);
			tabdata.put("modified_at_ws_no",client_ip_address );
			tabdata.put("totCount", new Integer(slCount));
			tabdata.put("Update_yn", Update_yn);
			tabdata.put("search_by", search_by);
			tabdata.put("search_txt", search_txt);
			

			boolean local_ejbs = false;
		
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/IPNursUnitRoom",IPNursUnitRoomManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = p;
			argArray[1] = tabdata;
	
			Class [] paramArray = new Class[2];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();

			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("NursUnitAddModify",paramArray)).invoke(busObj,argArray);
			

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			boolean inserted	= ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error		= (String) results.get("error") ;

			

			String error_value	= "0" ;
		
			if ( inserted ) 
				error_value = "1" ;
			
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );

			tabdata.clear();
			results.clear();

		} 
		catch ( Exception e ) 
		{
			e.printStackTrace();
		}
	}
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
}
