/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eAM;

import javax.servlet.ServletException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.Date;

import java.io.PrintWriter;
import java.io.IOException;

import java.util.Properties;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

import com.ehis.eslp.ServiceLocator;

import eCommon.SingleTabHandler.SingleTabHandlerManagerHome;

/**
 * @todo Class members should be moved to method level scope
 */

public class ReactionServlet extends HttpServlet{
	PrintWriter out;
    Properties p;
    String reactioncode;
    String longdesc;
    String shortdesc;
    String adversereacyn;    
    String effectiveStatus;
    String facilityId;
    String client_ip_address;
    String serviceURL;
   // String objectName;    

	HttpSession session;
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{	
		res.setContentType("text/html");
		out = res.getWriter();
		session = req.getSession(false);
		p = (Properties) session.getValue( "jdbc" ) ;
		
		facilityId = (String) session.getValue( "facility_id" ) ;
		if(facilityId==null) facilityId="";
		
		client_ip_address = p.getProperty("client_ip_address");
		if(client_ip_address ==null) client_ip_address ="";
		
		serviceURL=(String) session.getValue("serviceURL");
		if(serviceURL==null) serviceURL="";

		try{			
			String operation = req.getParameter("function");
			
			if ( operation.equals("insert"))   insertReaction(req, res);
			if ( operation.equals("modify"))   modifyReaction(req, res);			
		}catch(Exception e){
			out.println(e.toString());
			e.printStackTrace();
		}
	}
	
	private void modifyReaction(HttpServletRequest req, HttpServletResponse res){
		try{
			reactioncode = req.getParameter("reaction_code");
            longdesc = req.getParameter("long_desc");
            shortdesc = req.getParameter("short_desc");
            adversereacyn = req.getParameter("adverse_reaction_yn");
            if(adversereacyn == null)
                adversereacyn = "N";            
            effectiveStatus = req.getParameter("eff_status");
            if(effectiveStatus == null)
                effectiveStatus = "D";

			String addedById = p.getProperty( "login_user" ) ;
			if(addedById==null) addedById="";
			String addedDate = dateFormat.format( new java.util.Date() ) ;
			if(addedDate ==null) addedDate="";
			String modifiedById = addedById ;
			if(modifiedById==null) modifiedById="";
			String modifiedDate = addedDate ;
			String addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;
			//java.sql.Date added_date = java.sql.Date.valueOf( addedDate ) ;
			//java.sql.Date modified_date = java.sql.Date.valueOf( modifiedDate ) ;

			HashMap tabdata=new HashMap();
			tabdata.put("REACTION_CODE", reactioncode);
            tabdata.put("LONG_DESC", longdesc);
            tabdata.put("SHORT_DESC", shortdesc);
            tabdata.put("ADVERSE_REACTION_YN", adversereacyn);           
            tabdata.put("EFF_STATUS", effectiveStatus);

			tabdata.put("MODIFIED_BY_ID",modifiedById);
			tabdata.put("MODIFIED_DATE",modifiedDate);
			tabdata.put("MODIFIED_AT_WS_NO", modifiedAtWorkstation);
			tabdata.put("MODIFIED_FACILITY_ID", modifiedFacilityId);

			HashMap condflds=new HashMap();
			condflds.put("reaction_code",reactioncode);

/*			Context context =  new InitialContext();
			Object homeObject = context.lookup("java:comp/env/SingleTabHandler");
			SingleTabHandlerManagerHome singleTabHandlerManagerHome=(SingleTabHandlerManagerHome)PortableRemoteObject.narrow(homeObject,  SingleTabHandlerManagerHome.class);

			final SingleTabHandlerManagerRemote singleTabHandlerManagerRemote = singleTabHandlerManagerHome.create();

			final java.util.HashMap results = singleTabHandlerManagerRemote.update(p,tabdata,condflds,"AM_REACTION");
*/
			boolean local_ejbs = false;
			ServletContext context = getServletConfig().getServletContext();
			if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
				local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

		/*	Object argArray[] = new Object[1];			
			HashMap hmParams = new HashMap();
			hmParams.put("p",p);
			hmParams.put("tabdata",tabdata);
			hmParams.put("condflds",condflds);
			hmParams.put("table_name","AM_REACTION");
			argArray[0] = hmParams;

			Class [] paramArray = new Class[1];
			paramArray[0] = hmParams.getClass();*/


					Object argArray[] = new Object[4];
				//argArray[0] =hashmap;
				String table_name="AM_REACTION";
				argArray[0] =p;
				argArray[1] =tabdata;
				argArray[2] =condflds;
				argArray[3] =table_name;

				Class [] paramArray = new Class[4];
				//paramArray[0] =hashmap.getClass();
					paramArray[0] =p.getClass();
					paramArray[1] =tabdata.getClass();
					paramArray[2] =condflds.getClass();
					paramArray[3] =table_name.getClass();

					
			
			HashMap results = (HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			
			//Clears the mapping
			tabdata.clear();
			condflds.clear();
//			hmParams.clear();

			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

			String error = (String) results.get("error") ;
			String error_value = "0" ;
			if ( inserted ){
			 error_value = "1" ;
			}else{
			 error = (String) results.get("error") ;
			}
        	error = (String) results.get("error") ;
    		res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8"  )+"&err_value="+error_value );

			results.clear();

		}catch ( Exception e ){
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
		}
	}

	private void insertReaction(HttpServletRequest req, HttpServletResponse res){
		try{
			reactioncode = req.getParameter("reaction_code");
            longdesc = req.getParameter("long_desc");
            shortdesc = req.getParameter("short_desc");
            adversereacyn = req.getParameter("adverse_reaction_yn");
            if(adversereacyn == null)
                adversereacyn = "N";            
            effectiveStatus = req.getParameter("eff_status");
            if(effectiveStatus == null)
                effectiveStatus = "D";

			String addedById = p.getProperty( "login_user" ) ;
			if(addedById==null) addedById="";
			String addedDate = dateFormat.format( new java.util.Date() ) ;
			if(addedDate ==null) addedDate="";

			String modifiedById = addedById ;
			String modifiedDate = addedDate ;
			if(modifiedById==null) modifiedById="";
			String addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;

	//		java.sql.Date added_date = java.sql.Date.valueOf( addedDate ) ;
	//		java.sql.Date modified_date = java.sql.Date.valueOf( modifiedDate ) ;

			HashMap tabdata=new HashMap();
			tabdata.put("REACTION_CODE", reactioncode);
            tabdata.put("LONG_DESC", longdesc);
            tabdata.put("SHORT_DESC", shortdesc);
            tabdata.put("ADVERSE_REACTION_YN", adversereacyn);           
            tabdata.put("EFF_STATUS", effectiveStatus);
			
			tabdata.put("ADDED_BY_ID",addedById);
			tabdata.put("ADDED_DATE",addedDate);
			tabdata.put("ADDED_AT_WS_NO",addedAtWorkstation);
			tabdata.put("ADDED_FACILITY_ID",addedFacilityId);

			tabdata.put("MODIFIED_BY_ID",modifiedById);
			tabdata.put("MODIFIED_DATE",modifiedDate);
			tabdata.put("MODIFIED_AT_WS_NO", modifiedAtWorkstation);
			tabdata.put("MODIFIED_FACILITY_ID", modifiedFacilityId);

			String dupflds[]={"REACTION_CODE"};

/*
			Context context =  new InitialContext(  ) ;
			Object homeObject = context.lookup("java:comp/env/SingleTabHandler");
			SingleTabHandlerManagerHome singleTabHandlerManagerHome=(SingleTabHandlerManagerHome)PortableRemoteObject.narrow(homeObject,  SingleTabHandlerManagerHome.class);
			final SingleTabHandlerManagerRemote singleTabHandlerManagerRemote = singleTabHandlerManagerHome.create();

			final java.util.HashMap results = singleTabHandlerManagerRemote.insert(p,tabdata,dupflds,"AM_REACTION");
*/
			boolean local_ejbs = false;
			ServletContext context = getServletConfig().getServletContext();
			if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
				local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

		/*	Object argArray[] = new Object[1];			
			HashMap hmParams = new HashMap();
			hmParams.put("p",p);
			hmParams.put("tabdata",tabdata);
			hmParams.put("dupflds",dupflds);
			hmParams.put("table_name","AM_REACTION");
			argArray[0] = hmParams;

			Class [] paramArray = new Class[1];
			paramArray[0] = hmParams.getClass();*/


			
				Object argArray[] = new Object[4];
				//argArray[0] =hashmap;
				String table_name="AM_REACTION";
				argArray[0] =p;
				argArray[1] =tabdata;
				argArray[2] =dupflds;
				argArray[3] =table_name;

				Class [] paramArray = new Class[4];
				//paramArray[0] =hashmap.getClass();
					paramArray[0] =p.getClass();
					paramArray[1] =tabdata.getClass();
					paramArray[2] =dupflds.getClass();
					paramArray[3] =table_name.getClass();

					
			
			HashMap results = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
		
			//Clears the mapping
			tabdata.clear();
//			hmParams.clear();

			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

			String error = (String) results.get("error") ;
			String error_value = "0" ;
			if ( inserted ){
				error_value = "1" ;
			}else{
				error = (String) results.get("error") ;
			}
			error = (String) results.get("error") ;
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8"  )+"&err_value="+error_value );
            
			results.clear();

		}catch ( Exception e ){
			out.println("<h3> Exception raise by Servlet ...So Record Not Inserted </h3> Foll: Error Received : "+e.toString());
			e.printStackTrace();
		}
	}
}
