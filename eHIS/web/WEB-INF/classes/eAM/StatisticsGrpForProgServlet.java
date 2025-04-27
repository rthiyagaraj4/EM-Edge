/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eAM;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
//import oracle.aurora.jndi.sess_iiop.ServiceCtx ;

import eCommon.SingleTabHandler.*;

public class StatisticsGrpForProgServlet extends javax.servlet.http.HttpServlet
{
	PrintWriter out;
	
	java.util.Properties p;

	String ModuleID;
	String ProgramType;
	String ProgramID;
	String StatGroup;
	String SeqNumber;

	String facilityId ;
	String client_ip_address ;

	//String serviceURL;
	//String objectName;
	HttpSession session;
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		session = req.getSession(false);		
		this.facilityId = (String) session.getValue( "facility_id" ) ;
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.client_ip_address = p.getProperty("client_ip_address");
		/*serviceURL=(String) session.getValue("serviceURL");
		objectName="/test/SingleTabHandlerManager";*/

		try
		{
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");

    		this.out = res.getWriter();
			String operation = req.getParameter("function_name");

			if ( operation.equals("insert") )   insertStatisticsGrpForProg(req, res);
			if ( operation.equals("modify") )   modifyStatisticsGrpForProg(req, res);
			if ( operation.equals("delete") )   deleteStatisticsGrpForProg(req, res);
		}
		catch(Exception e)
		{
			out.println(e.toString());
		}
	}

	/*public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		try
		{
			this.out = res.getWriter();
			res.setContentType("text/html");
		}
		catch(Exception e)	{	}
	}*/


	private void modifyStatisticsGrpForProg(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			ModuleID = req.getParameter("module");
			ProgramID = req.getParameter("program");
			ProgramType = req.getParameter("program_type");
			StatGroup = req.getParameter("statistics_group");
			SeqNumber = req.getParameter("seq_num");

			String addedById = p.getProperty( "login_user" ) ;
			String addedDate = dateFormat.format( new java.util.Date() ) ;
			String modifiedById = addedById ;
			String modifiedDate = addedDate ;
			String modifiedFacilityId = facilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;

//			java.sql.Date added_date1 = java.sql.Date.valueOf( addedDate ) ;
			//java.sql.Date added_date = new java.sql.Date(added_date1.parse(added_date1.toLocaleString())-(added_date1.getTimezoneOffset()*60*1000) ) ;
			java.sql.Date modified_date1 = java.sql.Date.valueOf(modifiedDate ) ;
			java.sql.Date modified_date = new java.sql.Date(modified_date1.parse(modified_date1.toLocaleString())-(modified_date1.getTimezoneOffset()*60*1000) ) ; 

			HashMap tabdata=new HashMap();
			tabdata.put("SEQUENCE_NO",SeqNumber);

			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",modified_date);
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );

			HashMap condflds=new HashMap();
			condflds.put("MODULE_ID",ModuleID);
			condflds.put("PROGRAM_ID",ProgramID);
			condflds.put("STAT_GRP_ID",StatGroup);

			/*java.util.Hashtable env = (java.util.Hashtable)session.getValue("env");
			env.put( Context.URL_PKG_PREFIXES, "oracle.aurora.jndi" ) ;
			InitialContext ic = new InitialContext( env );
			final SingleTabHandlerManagerHome singleTabHandlerManagerHome  = (SingleTabHandlerManagerHome) ic.lookup( serviceURL+objectName ) ;
			InitialContext context = new InitialContext();
			Object homeObject = context.lookup("java:comp/env/SingleTabHandler");
			final SingleTabHandlerManagerHome singleTabHandlerManagerHome  = (SingleTabHandlerManagerHome) PortableRemoteObject.narrow(homeObject ,SingleTabHandlerManagerHome.class);
			final SingleTabHandlerManagerRemote singleTabHandlerManagerRemote = singleTabHandlerManagerHome.create();

			final java.util.Hashtable results = singleTabHandlerManagerRemote.update(p,tabdata,condflds,"AM_STAT_GRP_FOR_PROGRAM");*/
			boolean local_ejbs = false;
		
					if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

					Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
					Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		
				/*	Object argArray[] = new Object[1];			
					HashMap hmParams = new HashMap();
					hmParams.put("p",p);
					hmParams.put("tabdata",tabdata);
					hmParams.put("condflds",condflds);
					hmParams.put("table_name","AM_STAT_GRP_FOR_PROGRAM");
					argArray[0] = hmParams;

					Class [] paramArray = new Class[1];
					paramArray[0] = hmParams.getClass();*/



						Object argArray[] = new Object[4];
				//argArray[0] =hashmap;
				String table_name="AM_STAT_GRP_FOR_PROGRAM";
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

		
				java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);

				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

					tabdata.clear();
				//	hmParams.clear();
					condflds.clear();

			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

			String error = (String) results.get("error") ;
			String error_value = "0" ;
			if ( inserted )
			{
				 error_value = "1" ;
				 //res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ) + "&err_value=" + error_value );
			}
			/*else
			{
			    error = (String) results.get("error") ;
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode( error ) );
			}
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ) );

        	error = (String) results.get("error") ;*/
    		res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" )+"&err_value="+error_value );

			tabdata.clear();
			condflds.clear();
			results.clear();

		}
		catch ( Exception e )
		{
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ;
			out.println( ModuleID+"    "+ProgramType+"   "+ProgramID+"    "+StatGroup+"  "+SeqNumber);
			e.printStackTrace();
		}
	}
			
	private void insertStatisticsGrpForProg(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			ModuleID = req.getParameter("module");
			ProgramType = req.getParameter("program_type");
			ProgramID = req.getParameter("program");
			StatGroup = req.getParameter("statistics_group");
			SeqNumber = req.getParameter("seq_num");

			String addedById = p.getProperty( "login_user" ) ;
			String addedDate = dateFormat.format( new java.util.Date() ) ;
			String modifiedById = addedById ;
			String modifiedDate = addedDate ;
			String addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;

			java.sql.Date added_date1 = java.sql.Date.valueOf( addedDate ) ;
			java.sql.Date added_date = new java.sql.Date(added_date1.parse(added_date1.toLocaleString())-(added_date1.getTimezoneOffset()*60*1000) ) ;
			java.sql.Date modified_date1 = java.sql.Date.valueOf(modifiedDate ) ;
			java.sql.Date modified_date = new java.sql.Date(modified_date1.parse(modified_date1.toLocaleString())-(modified_date1.getTimezoneOffset()*60*1000) ) ; 

			HashMap tabdata=new HashMap();

			tabdata.put("MODULE_ID",ModuleID);
			tabdata.put("PROGRAM_ID",ProgramID);
			tabdata.put("PROGRAM_TYPE",ProgramType);
			tabdata.put("STAT_GRP_ID",StatGroup);
			tabdata.put("SEQUENCE_NO",SeqNumber);

			tabdata.put("added_by_id",addedById);
			tabdata.put("added_date",added_date);
			tabdata.put("added_facility_id", facilityId);
			tabdata.put("added_at_ws_no",addedAtWorkstation);
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",modified_date);
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );

			String dupflds[]={"MODULE_ID","PROGRAM_ID","STAT_GRP_ID"};

           /* out.print(added_date);
			java.util.Hashtable env = (java.util.Hashtable)session.getValue("env");
			env.put( Context.URL_PKG_PREFIXES, "oracle.aurora.jndi" ) ;
			InitialContext ic = new InitialContext( env );
			final SingleTabHandlerManagerHome singleTabHandlerManagerHome  = (SingleTabHandlerManagerHome) ic.lookup( serviceURL+objectName ) ;
			InitialContext context = new InitialContext();
			Object homeObject = context.lookup("java:comp/env/SingleTabHandler");
			final SingleTabHandlerManagerHome singleTabHandlerManagerHome  = (SingleTabHandlerManagerHome) PortableRemoteObject.narrow(homeObject ,SingleTabHandlerManagerHome.class);
			final SingleTabHandlerManagerRemote singleTabHandlerManagerRemote = singleTabHandlerManagerHome.create();

			final java.util.Hashtable results = singleTabHandlerManagerRemote.insert(p,tabdata,dupflds,"AM_STAT_GRP_FOR_PROGRAM");*/

			boolean local_ejbs = false;
		
					if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

					Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
					Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		
				/*	Object argArray[] = new Object[1];			
					HashMap hmParams = new HashMap();
					hmParams.put("p",p);
					hmParams.put("tabdata",tabdata);
					hmParams.put("dupflds",dupflds);
					hmParams.put("table_name","AM_STAT_GRP_FOR_PROGRAM");
					argArray[0] = hmParams;

					Class [] paramArray = new Class[1];
					paramArray[0] = hmParams.getClass();*/


					Object argArray[] = new Object[4];
				//argArray[0] =hashmap;
				String table_name="AM_STAT_GRP_FOR_PROGRAM";
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

			
					java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);

				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);





			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

			String error = (String) results.get("error") ;
			String error_value = "0" ;
			if ( inserted )
			{
				 error_value = "1" ;
				// res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ) + "&err_value=" + error_value );
			}
			/*else
			{
				 error = (String) results.get("error") ;
				 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode( error ) );
									}
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ) );

			   	error = (String) results.get("error") ;*/
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8" )+"&err_value="+error_value );
				tabdata.clear();
				results.clear();
//				hmParams.clear();				
			}catch ( Exception e ){
				out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
				out.println( "Values sent are : <br>" ) ;
				out.println( ModuleID+"    "+ProgramType+"   "+ProgramID+"    "+StatGroup+"  "+SeqNumber);
				e.printStackTrace();
			}
	}

   private void deleteStatisticsGrpForProg(HttpServletRequest req, HttpServletResponse res)
	{
		//boolean flag=true;
		try 
		{
			res.setContentType("text/html");

			ModuleID = req.getParameter("module");
			ProgramType = req.getParameter("program_type");
			ProgramID = req.getParameter("program");
			StatGroup = req.getParameter("statistics_group");

			

			HashMap delflds=new HashMap();

			delflds.put("module_id",ModuleID);
			delflds.put("program_id",ProgramID);
			delflds.put("stat_grp_id",StatGroup);

			/*java.util.Hashtable env = (java.util.Hashtable)session.getValue("env");
			env.put( Context.URL_PKG_PREFIXES, "oracle.aurora.jndi" ) ;
			InitialContext ic = new InitialContext( env );
			final SingleTabHandlerManagerHome singleTabHandlerManagerHome  = (SingleTabHandlerManagerHome) ic.lookup( serviceURL+objectName ) ;
			InitialContext context = new InitialContext();
			Object homeObject = context.lookup("java:comp/env/SingleTabHandler");
			final SingleTabHandlerManagerHome singleTabHandlerManagerHome  = (SingleTabHandlerManagerHome) PortableRemoteObject.narrow(homeObject ,SingleTabHandlerManagerHome.class);
			final SingleTabHandlerManagerRemote singleTabHandlerManagerRemote = singleTabHandlerManagerHome.create();

			final java.util.Hashtable results = singleTabHandlerManagerRemote.delete(p,delflds,"AM_STAT_GRP_FOR_PROGRAM");*/

			boolean local_ejbs = false;
		
					if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

					Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
					Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		
					Object argArray[] = new Object[3];
					String table_name="AM_STAT_GRP_FOR_PROGRAM";
					argArray[0] = p;
					argArray[1] = delflds;
					argArray[2] = table_name;
		


					Class [] paramArray = new Class[3];
					paramArray[0] = p.getClass();
					paramArray[1] = delflds.getClass();
					paramArray[2] = table_name.getClass();
		

				java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("delete",paramArray)).invoke(busObj,argArray);

				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);


			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			String error_value = "0" ;
			results.clear();
			delflds.clear();
			if ( inserted )
			{
				error_value = "1" ;
				//res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ) + "&err_value=" + error_value );
			}
			/*else
			{
				error = (String) results.get("error") ;
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode( error ) );
			}*/
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8"  )+"&err_value="+error_value);


		} 
		catch ( Exception e ) 
		{
			out.println(e.getMessage());
			out.println(e.toString());
			e.printStackTrace();
		}
	}	
}
