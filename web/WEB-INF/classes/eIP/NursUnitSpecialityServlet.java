/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIP;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.HashMap;
import webbeans.eCommon.RecordSet;

import eIP.IPNursUnitSpeciality.*;

public class NursUnitSpecialityServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel
{
	PrintWriter				out;
	java.util.Properties	p;
 	String					facilityId ;
	String sStyle;
	String					client_ip_address ;
	HttpSession				session;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		try
		{
			this.out		= res.getWriter();
			out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/"+sStyle+"'></link><script language='javascript' src='/eCIS/ip/js/NursUnitRoom.js'></script></head><frameset rows='60,*,50'><frame name='commontoolbarFrame' src='../eCommon/jsp/commonToolbar.jsp?function_name=Rooms For Nursing Unit' frameborder=0 scrolling='no' noresize><frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0><frame name='messageFrame' src='../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto'></frameset></html> ");
		}
		catch(Exception e)	{	e.printStackTrace();}
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		session				= req.getSession(false);
		this.p				= (java.util.Properties) session.getValue( "jdbc" ) ;
		this.facilityId		= (String) session.getValue( "facility_id" ) ;
		sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		client_ip_address	= p.getProperty("client_ip_address");
		
		try
		{
			SpecialityAddModify(req,res);
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

	private void SpecialityAddModify(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			HashMap		tabdata				= new HashMap();
            RecordSet	NursUnitSpeciality	= null;
            String		checkedOnes			= "";
			int recordCount					= 0;
			String maxRecord				= "";
            String		nursing_unit_code	= checkForNull(req.getParameter("nursing_unit_code"));
		    String		from				= checkForNull(req.getParameter("from"));
            String		to					= checkForNull(req.getParameter("to"));
			int			n_from				= Integer.parseInt(from.trim());
			int			n_to				= Integer.parseInt(to.trim());

			String search_by    = req.getParameter("search_by") ;
		    if(search_by == null || search_by.equals("null")) search_by="";

		    String search_txt   = req.getParameter("search_txt") ;
		    if(search_txt == null || search_txt.equals("null")) search_txt="";

			NursUnitSpeciality				= (webbeans.eCommon.RecordSet)session.getAttribute("NursUnitSpeciality");

			maxRecord   = (req.getParameter("maxRecord")  == null) ? "":req.getParameter("maxRecord");
			recordCount = Integer.parseInt(maxRecord);

			if(recordCount < 12)
			{
				NursUnitSpeciality.clearAll();
			}

			if(from != null && to != null)
			{
				for( int i= n_from; i<=n_to; i++)
				{
					if(req.getParameter(("chk"+i)) != null)
					{
						checkedOnes = req.getParameter(("chk"+i));
						if(!(NursUnitSpeciality.containsObject(checkedOnes)))
							NursUnitSpeciality.putObject(checkedOnes);
					}

					String removeCode = checkForNull(req.getParameter("removeCode"+(i)));
					if(removeCode.equals("Y"))
					{
						String spclCode = req.getParameter("spclCode"+(i));
						if((NursUnitSpeciality.containsObject(spclCode)))
						{
							int removeCodeIndex = NursUnitSpeciality.indexOfObject(spclCode);
								NursUnitSpeciality.removeObject(removeCodeIndex);
						}
					}
				}
			}

			for(int i=0;i<NursUnitSpeciality.getSize();i++)
			{
				tabdata.put( ("chk"+i), (String)NursUnitSpeciality.getObject(i) );
			}

			String slCount	=	""+NursUnitSpeciality.getSize();
			String addedById = p.getProperty( "login_user" ) ;

			tabdata.put("nursing_unit_code",nursing_unit_code );
			tabdata.put("facilityId",facilityId);
			tabdata.put("modified_by_id",addedById);
			tabdata.put("modified_at_ws_no",client_ip_address );
			tabdata.put("totCount", new Integer(slCount) );
			tabdata.put("search_by",search_by);
			tabdata.put("search_txt",search_txt);
			boolean local_ejbs = false;
			
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/IPNursUnitSpeciality",IPNursUnitSpecialityManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = p;
			argArray[1] = tabdata;

			Class [] paramArray = new Class[2];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();
		
			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("SpecialityAddModify",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			boolean		inserted	= ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String		error		= (String) results.get("error") ;
			String		error_value = "0" ;

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
