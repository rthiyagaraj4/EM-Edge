/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIPAD.commons.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eCA.RecentlyAccessed.RecentlyAccessedHome;
import java.sql.Date ;


/**
 * Servlet implementation class MaintainRecentlyAccessed
 */
public class MaintainRecentlyAccessedItems extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MaintainRecentlyAccessedItems() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session		=	request.getSession(true) ;
		PrintWriter out =	response.getWriter();
		java.util.Properties	p		=	null;
		p =	(java.util.Properties)session.getValue("jdbc");
		String locale = (String) p.getProperty("LOCALE");
		
		java.util.HashMap htRecentAccess = new java.util.HashMap();
		
		
		String accesedItemCat = request.getParameter("Category");
		String accesedItemVal = request.getParameter("Value");
		
		String respId = (String)session.getAttribute("responsibility_id");
		String practId = (String)session.getAttribute("practitioner_id");
		String facilityId = (String)session.getAttribute("facility_id");
		String wsNo = request.getRemoteAddr();
		if(session!=null){
			if(accesedItemCat!=null && accesedItemVal!=null && respId!=null && practId!=null && facilityId!=null && wsNo!=null && p!=null){
				htRecentAccess.put("accesedItemCat", accesedItemCat);
				htRecentAccess.put("accesedItemVal", accesedItemVal);
				htRecentAccess.put("respId", respId);
				htRecentAccess.put("practId", practId);
				htRecentAccess.put("facilityId", facilityId);
				htRecentAccess.put("wsNo", wsNo);
				try
				{
					boolean local_ejbs = false;
					
					if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
	
					Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/RecentlyAccessed",RecentlyAccessedHome.class,local_ejbs);
					Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
					
					Object argArray[] = new Object[2];
					argArray[0] = p;
					argArray[1] = htRecentAccess;
					
					Class [] paramArray = new Class[2];
					paramArray[0] = p.getClass();
					paramArray[1] = htRecentAccess.getClass();
					
	
	
					java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insertRecentlyAccessedData",paramArray)).invoke(busObj,argArray);
	
					(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
					htRecentAccess.clear();
								
					boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
					out.println(inserted);
					if(!inserted){
						String error = ( ((String ) results.get( "error" )).toString());
						out.println(error);
					}
					
				}
				catch(Exception e)
				{
					out.println("MaintainRecentlyAccessedItems Servlet Exception:"+e);
					
					e.printStackTrace();
					out.println("Exception while accessing RecentlyAccessed EJB for Inseting Records!"+e);
					
				}
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
