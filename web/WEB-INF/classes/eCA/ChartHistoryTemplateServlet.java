/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eCA;
import java.io.*;
import java.net.*;
import java.sql.*;
import java.util.*;
import javax.rmi.*;
import javax.servlet.*;
import javax.naming.*;
import javax.servlet.http.*;
import webbeans.eCommon.*;
import eCA.ChartHistoryTemplate.*;

public class ChartHistoryTemplateServlet extends HttpServlet
{
	public void init(ServletConfig config) throws ServletException
	{
				super.init(config);
	}
		
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException, IOException
	{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");

		webbeans.eCommon.RecordSet recordSet;
		java.util.Properties p;
		HashMap htRecord_atl			= null ;

		HttpSession httpsession		=	req.getSession(false);
		p							=	(Properties)httpsession.getValue("jdbc");
		String locale				=	(String) p.getProperty("LOCALE");
		String login_by_id			=	(String) p.getProperty("login_user");
		String login_at_ws_no		=	(String) p.getProperty("client_ip_address");
		String login_facility_id	=	(String)httpsession.getValue("facility_id");

		String cols					=	req.getParameter("maxc");
		String rows					=	req.getParameter("maxr");
		String summaryid_val		=	req.getParameter("summaryid");
		String summarydesc			=	req.getParameter("summarydesc");
		String updateflag			=	req.getParameter("updateflag");
		String enadis				=	req.getParameter("enadis");
						
		recordSet= (webbeans.eCommon.RecordSet)com.ehis.persist.PersistenceHelper.getObjectFromBean("FinalBean","webbeans.eCommon.RecordSet",httpsession);

		try
		{
			HashMap  user_id_info =  new HashMap();

			user_id_info.put("addedById",login_by_id);
			user_id_info.put("facility_id",login_facility_id);
			user_id_info.put("client_ip_address",login_at_ws_no);
			user_id_info.put("rows",rows);
			user_id_info.put("cols",cols);
			user_id_info.put("summaryid",summaryid_val);
			user_id_info.put("summarydesc",summarydesc);
			user_id_info.put("enadis",enadis);
			user_id_info.put("locale",locale);
			
			ArrayList arrlstMain = new ArrayList();

			for(int i=0; i<recordSet.getSize(); i++)
			{
				htRecord_atl   = (java.util.HashMap)recordSet.getObject(i);
				arrlstMain.add(i,htRecord_atl);	
			}
					
			boolean local_ejbs = false;
		
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/ChartHistoryTemplate",ChartHistoryTemplateHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			
			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = arrlstMain;
			argArray[2] = user_id_info;
			argArray[3] = updateflag;

			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass();
			paramArray[1] = arrlstMain.getClass();
			paramArray[2] = user_id_info.getClass();
			paramArray[3] = updateflag.getClass();

			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("manageChartHistory",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
		
			argArray = null;
			paramArray = null;
			arrlstMain.clear();
			user_id_info.clear();
			htRecord_atl.clear();

			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

			String error = "";
			String error_value = "0" ;
					
			if ( inserted )
				error_value = "1" ;
				
			error = (String) results.get("message") ;
					
			results.clear();

			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) +"&err_value="+error_value);
		 }
		catch(Exception e)
		{
			
			e.printStackTrace();
		} 
	} 
}
