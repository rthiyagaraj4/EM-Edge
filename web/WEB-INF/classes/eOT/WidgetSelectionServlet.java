/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOT;
import com.ehis.eslp.ServiceLocator;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import org.xml.sax.InputSource;
import eOT.WidgetSelection.*;
//import eOT.WidgetSelection.WidgetSelectionHome;
import eOT.*;

//import oracle.aurora.jndi.sess_iiop.ServiceCtx;

public class WidgetSelectionServlet extends javax.servlet.http.HttpServlet {
	public void init(ServletConfig config) throws ServletException	{
		super.init(config);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws javax.servlet.ServletException,IOException{
		req.setCharacterEncoding("UTF-8");
  
		//String opeartion=req.getParameter("opeartion"); //Common-ICN-0055
         		
		insertWidgetSelection(req,res);
        

	}

	private void insertWidgetSelection(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
		try

		{		
			HttpSession  session           	=	req.getSession(false) ;
			String user_id	= (String)session.getValue("login_user")==null?"":(String)session.getValue("login_user") ;
			String facilityId = (String) session.getValue( "facility_id" )==null?"":(String) session.getValue( "facility_id" );
			Properties p					=	(Properties)session.getValue("jdbc") ;
			String locale			    =   p.getProperty("LOCALE");
			boolean inserted=false;
			HashMap session_details = new HashMap();
			String  login_at_ws_no			=	"";
			
			String staffass= req.getParameter("staffass")==null?"N":req.getParameter("staffass");
			String room1=req.getParameter("room1")==null?"":req.getParameter("room1");
			String room2=req.getParameter("room2")==null?"":req.getParameter("room2");
			String room3=req.getParameter("room3")==null?"":req.getParameter("room3");
			login_at_ws_no	=	p.getProperty("client_ip_address");
			String refresh= req.getParameter("refresh")==null?"N":req.getParameter("refresh");
			String RefreshInterval= req.getParameter("RefreshInterval")==null?"30":req.getParameter("RefreshInterval");
			String Interval= req.getParameter("Interval")==null?"SS":req.getParameter("Interval");
			String facilityid= req.getParameter("facilityid")==null?"":req.getParameter("facilityid");
			String widget_selection_id= req.getParameter("widget_selection_id")==null?"":req.getParameter("widget_selection_id");
			
			session_details.put ( "login_user_id", (String) session.getValue("login_user"));
			session_details.put("staffass", staffass);
			session_details.put("room1", room1);
			session_details.put("room2", room2);
			session_details.put("room3", room3);
			session_details.put("refresh", refresh);
			session_details.put("RefreshInterval", RefreshInterval);
			session_details.put("Interval", Interval);
			session_details.put("user_id", user_id);
			session_details.put("facilityId", facilityId);
			session_details.put("locale", locale);
			session_details.put("widget_selection_id", widget_selection_id);
			session_details.put("facilityid", facilityid);
			//session_details.put("login_at_ws_no", login_at_ws_no);

			boolean local_ejbs = false;
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
			System.out.println("89,before object home ");
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/WidgetSelection",eOT.WidgetSelection.WidgetSelectionHome.class,local_ejbs);
			System.out.println("91,Afterobject home "+home);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			Object argArray[] = new Object[2];
			argArray[0] = p;
			argArray[1] = session_details;

			Class [] paramArray = new Class[2];
			paramArray[0] = p.getClass();
			paramArray[1] = session_details.getClass();
			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insertWidgetSelection",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);				
			inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			System.out.println("122,inserted===>"+inserted);	
			String error = (String) results.get("error") ;
			System.out.println("124,error===>"+error);	
			if (error==null)
			{	error="";
			}
			if(inserted){
				System.out.println("105,If===>"+inserted);	
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8") + "&err_value=1"  );
			}else{
				System.out.println("108,Else===>");
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num="+java.net.URLEncoder.encode( error,"UTF-8" ) );
			}

		}//end try
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
	}
	
	

	boolean isLocalEJB(){
		ServletContext servletcontext = getServletConfig().getServletContext();
		if ((servletcontext.getInitParameter("LOCAL_EJBS")!=null) &&(servletcontext.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
			return true;
		return false;
	}
}



