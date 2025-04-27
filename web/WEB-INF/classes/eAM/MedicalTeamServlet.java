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
import webbeans.eCommon.*;
import java.util.Date;
import eCommon.SingleTabHandler.*;
import com.ehis.util.*;
import eCommon.XSSRequestWrapper;

public class MedicalTeamServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel
{
	PrintWriter out;
	java.util.Properties p;
	
	String facility_Id ;
	String longdesc ;
	String shortdesc ;
	String teamid = "";
	String eff_status ="";
	/// Added By Ush
	String specialty="";
	String appl_for_op_yn="";
	String appl_for_ip_yn="";
	String appl_for_mr_yn=""; //added by mujafar for ML-MMOH-CRF-0716
	String appl_from_date="";
	String appl_to_date="";
	//Timestamp receiveTimestamp1=null;
	//Timestamp receiveTimestamp2=null;
	java.sql.Date iss_date_d;
	java.sql.Date iss_date_d1;
	String locale="";


	//String setup_bl_dtls_in_ip_yn;
	//int i = 0;
	//Integer noofbeds = new Integer(i);

	String client_ip_address ;
    String facilityId;
	//String serviceURL;
	//String objectName;
	HttpSession session;
	Connection con = null;
		
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		//MMS-ME-SCF-0096 vulnerability Issue 
		req= new XSSRequestWrapper(req);
		res.addHeader("X-XSS-Protection", "1; mode=block");
		res.addHeader("X-Content-Type-Options", "nosniff");
		//MMS-ME-SCF-0096 vulnerability Issue
		session = req.getSession(false);
		this.out = res.getWriter();
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.facilityId = (String) session.getValue( "facility_id" ) ;
		
		this.client_ip_address = p.getProperty("client_ip_address");
		//serviceURL=(String) session.getValue("serviceURL");
		//objectName="/test/SingleTabHandlerManager";

		try
		{
			res.setContentType("text/html");
			locale=(String)session.getAttribute("LOCALE"); 
			String operation = req.getParameter("function_name");
			appl_to_date = req.getParameter("to_date");
			if(appl_to_date==null || appl_to_date.equals("null")) appl_to_date ="";
			appl_to_date= appl_to_date.trim();
			appl_from_date = req.getParameter("from_date");
			if(appl_from_date==null || appl_from_date.equals("null")) appl_from_date ="";
			appl_from_date=appl_from_date.trim();

			

			appl_to_date=DateUtils.convertDate(appl_to_date,"DMY",locale,"en");
			appl_from_date=DateUtils.convertDate(appl_from_date,"DMY",locale,"en");

			

			if (operation.equals("insert"))	insertFacilityTeam(req, res);
			if (operation.equals("modify"))	modifyFacilityTeam(req, res);
		}
		catch(Exception e)
		{
			out.println(e.toString());
		}
	}
	private void insertFacilityTeam(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			facility_Id =  req.getParameter("facility_id");
			if(facility_Id == null || facility_Id.equals("null")) facility_Id="";
			teamid		= req.getParameter("teamid");
			if(teamid == null || teamid.equals("null")) teamid="";
			longdesc 	= req.getParameter("long_desc");
			if(longdesc == null || longdesc.equals("null")) longdesc="";
			shortdesc 	= req.getParameter("short_desc");
			if(shortdesc == null || shortdesc.equals("null")) shortdesc="";
			eff_status	= req.getParameter("eff_status");
			if (eff_status == null || eff_status.equals("null")) eff_status="D";
			specialty= req.getParameter("specialty");
			if(specialty == null || specialty.equals("null")) specialty="";
			appl_for_ip_yn = req.getParameter("appl_for_ip_yn");
			if(appl_for_ip_yn == null || appl_for_ip_yn.equals("null")) appl_for_ip_yn="N";
			appl_for_op_yn = req.getParameter("appl_for_op_yn");
			if(appl_for_op_yn == null || appl_for_op_yn.equals("null")) appl_for_op_yn="N";
			appl_for_mr_yn = req.getParameter("appl_for_mr_yn"); // ADDED BY MUJAFAR FOR ML-MMOH-CRF-0716
			if(appl_for_mr_yn == null || appl_for_mr_yn.equals("null")) appl_for_mr_yn="N";
			
			HashMap tabdata=new HashMap();
			String receiveArr9[] =new String[3] ;
			String receiveArr8[] =new String[3] ;
			if(!appl_from_date.equals(""))
			{
				StringTokenizer receivetok7 = new StringTokenizer(appl_from_date, "/");
								
				for(int n=0;n<3;n++)
				{
					if(receivetok7.hasMoreTokens())
					{
						receiveArr8[n] = receivetok7.nextToken();
					}
				}
				appl_from_date = receiveArr8[2] +"-"+receiveArr8[1]+"-"+ receiveArr8[0];
				iss_date_d1 = java.sql.Date.valueOf(appl_from_date);
				tabdata.put("EFF_DATE_FROM",iss_date_d1);
			}
			else 
			{
				tabdata.put("EFF_DATE_FROM",appl_from_date);
				
			}

			if(!appl_to_date.equals(""))
			{
				
			
				StringTokenizer receivetok9 = new StringTokenizer (appl_to_date, "/" ) ;
				for(int n1=0;n1<3;n1++)
					receiveArr9[n1] = receivetok9.nextToken() ;
				appl_to_date = receiveArr9[2] +"-"+receiveArr9[1]+"-"+ receiveArr9[0];
				iss_date_d = java.sql.Date.valueOf(appl_to_date);
				tabdata.put("EFF_DATE_TO",iss_date_d);
			}
			else
			{
				tabdata.put("EFF_DATE_TO",appl_to_date);
				
			}

				String addedById = p.getProperty( "login_user" ) ;
				String addedDate = dateFormat.format( new java.util.Date() ) ;
			String modifiedById = addedById ;
			String modifiedDate = addedDate ;
			String addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;
			
			java.sql.Date added_date1 = java.sql.Date.valueOf( addedDate ) ;
			java.sql.Date modified_date1 = java.sql.Date.valueOf(modifiedDate ) ;
			
			java.sql.Date added_date = new java.sql.Date(added_date1.parse(added_date1.toLocaleString())-(added_date1.getTimezoneOffset()*60*1000) ) ;
			java.sql.Date modified_date = new java.sql.Date(modified_date1.parse(modified_date1.toLocaleString())-(modified_date1.getTimezoneOffset()*60*1000) ) ;
			
				

			tabdata.put("facility_id"			,facility_Id);
			tabdata.put("team_id"				,teamid);
			tabdata.put("long_desc"				,longdesc);
			tabdata.put("short_desc"			,shortdesc);
			tabdata.put("eff_status"			,eff_status);
			tabdata.put("added_by_id"			,addedById);
			tabdata.put("added_date"			,added_date);
			tabdata.put("added_facility_id"		,facilityId);
			tabdata.put("added_at_ws_no"		,addedAtWorkstation);
			tabdata.put("modified_by_id"		,modifiedById);
			tabdata.put("modified_date"			,modified_date);
			tabdata.put("modified_facility_id"	,modifiedFacilityId);
			tabdata.put("modified_at_ws_no"		,modifiedAtWorkstation );
			tabdata.put("speciality_code"		,specialty);
			tabdata.put("appl_for_op_yn"		,appl_for_op_yn);
			tabdata.put("appl_for_ip_yn"		,appl_for_ip_yn); 
			tabdata.put("appl_for_mr_yn"		,appl_for_mr_yn); //added by mujafar for ML-MMOH-CRF-0716
			
			String dupflds[]={"team_id"};
			/*InitialContext context = new InitialContext();
			Object homeObject = context.lookup("java:comp/env/SingleTabHandler");
			SingleTabHandlerManagerHome singleTabHandlerManagerHome  = (SingleTabHandlerManagerHome) PortableRemoteObject.narrow(homeObject ,SingleTabHandlerManagerHome.class);
			SingleTabHandlerManagerRemote singleTabHandlerManagerRemote = singleTabHandlerManagerHome.create();
			java.util.Hashtable results = singleTabHandlerManagerRemote.insert(p,tabdata,dupflds,"am_medical_team");*/


				boolean local_ejbs = false;
		
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE")))
				local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		/*	HashMap hashmap = new HashMap();
				hashmap.put("p",p);
				hashmap.put("tabdata",tabdata);
				hashmap.put("dupflds",dupflds);
				String table_name="am_medical_team";
				hashmap.put("table_name",table_name);
				
				Object argArray[] = new Object[1];
				
				argArray[0] =hashmap;
			
			

				Class [] paramArray = new Class[1];
				paramArray[0] =hashmap.getClass();*/
					Object argArray[] = new Object[4];
				//argArray[0] =hashmap;
				String table_name="am_medical_team";
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

			out.println("error"+error);

			if ( inserted )
			{
				 error_value = "1" ;
			}
			else
			{
				error = (String) results.get("error") ;
			}
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8"  ) + "&err_value=" + error_value );

			tabdata.clear();
			results.clear();

		}
		catch ( Exception e )
		{
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ;
			e.printStackTrace();

		}
	}
//////////////////////////// M O D I F Y ///////////////////////////////////
	private void modifyFacilityTeam(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			con = ConnectionManager.getConnection(req);
			teamid		= req.getParameter("teamid");
			longdesc 	= req.getParameter("long_desc");
			shortdesc 	= req.getParameter("short_desc");
			eff_status	= req.getParameter("eff_status");
				if ( eff_status == null )
					 eff_status="D";

			specialty= req.getParameter("specialty");
			if(specialty == null) specialty="";
			appl_for_ip_yn = req.getParameter("appl_for_ip_yn");
				if(appl_for_ip_yn == null) appl_for_ip_yn="N"; 

			appl_for_op_yn = req.getParameter("appl_for_op_yn");
				if(appl_for_op_yn == null) appl_for_op_yn="N";
				
			appl_for_mr_yn = req.getParameter("appl_for_mr_yn"); //added by mujafar for ML-MMOH-CRF-0716
				if(appl_for_mr_yn == null) appl_for_mr_yn="N";	
			
		

			facility_Id =  req.getParameter("facility_id");
			if(facility_Id == null || facility_Id.equals("null")) facility_Id="";
			
			HashMap tabdata=new HashMap();
			String receiveArr9[] =new String[3] ;
			String receiveArr8[] =new String[3] ;
			if(!appl_from_date.equals(""))
			{
				StringTokenizer receivetok7 = new StringTokenizer (appl_from_date, "/" );
				for( int n=0;n<3;n++)
				{
					if(receivetok7.hasMoreTokens())
					{
						receiveArr8[n] = receivetok7.nextToken() ;
					}
				}
				appl_from_date = receiveArr8[2] +"-"+receiveArr8[1]+"-"+ receiveArr8[0];
				iss_date_d1 = java.sql.Date.valueOf(appl_from_date);
				tabdata.put("EFF_DATE_FROM",iss_date_d1);
			}
			else
				tabdata.put("EFF_DATE_FROM",appl_from_date);

			if(!appl_to_date.equals(""))
			{
				StringTokenizer receivetok9 = new StringTokenizer (appl_to_date, "/" ) ;
				for(int n1=0;n1<3;n1++)
				{
					if(receivetok9.hasMoreTokens())
					{
						receiveArr9[n1] = receivetok9.nextToken() ;
					}
				}
				appl_to_date = receiveArr9[2] +"-"+receiveArr9[1]+"-"+ receiveArr9[0];
				iss_date_d = java.sql.Date.valueOf(appl_to_date);
				tabdata.put("EFF_DATE_TO",iss_date_d);
			}
			else
				tabdata.put("EFF_DATE_TO",appl_to_date);
				
			String addedById = p.getProperty( "login_user" ) ;
			String addedDate = dateFormat.format( new java.util.Date() ) ;
			String modifiedById = addedById ;
			String modifiedDate = addedDate ;
			String addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;

			java.sql.Date added_date1 = java.sql.Date.valueOf( addedDate ) ;
			java.sql.Date modified_date1 = java.sql.Date.valueOf(modifiedDate ) ;

			java.sql.Date added_date = new java.sql.Date(added_date1.parse(added_date1.toLocaleString())-(added_date1.getTimezoneOffset()*60*1000) ) ;
			java.sql.Date modified_date = new java.sql.Date(modified_date1.parse(modified_date1.toLocaleString())-(modified_date1.getTimezoneOffset()*60*1000) ) ;

			tabdata.put("facility_id",facility_Id);
			tabdata.put("team_id",teamid);
			/*tabdata.put("EFF_DATE_FROM",iss_date_d1);
			tabdata.put("EFF_DATE_TO",iss_date_d);*/
			tabdata.put("long_desc",longdesc);
			tabdata.put("short_desc",shortdesc);
			tabdata.put("eff_status",eff_status);
			tabdata.put("added_by_id",addedById);
			tabdata.put("added_date",added_date);
			tabdata.put("added_facility_id", facilityId);
			tabdata.put("added_at_ws_no",addedAtWorkstation);
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",modified_date);
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );
			tabdata.put("speciality_code",specialty);
			tabdata.put("appl_for_op_yn",appl_for_op_yn);
			tabdata.put("appl_for_ip_yn",appl_for_ip_yn); 
			tabdata.put("appl_for_mr_yn",appl_for_mr_yn); //added by mujafar for ML-MMOH-CRF-0716

			HashMap condflds=new HashMap();
			condflds.put("team_id",teamid);
			

			boolean local_ejbs = false;
		
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE")))
				local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);



					Object argArray[] = new Object[4];
				String table_name="am_medical_team";
				argArray[0] =p;
				argArray[1] =tabdata;
				argArray[2] =condflds;
				argArray[3] =table_name;

				Class [] paramArray = new Class[4];
					paramArray[0] =p.getClass();
					paramArray[1] =tabdata.getClass();
					paramArray[2] =condflds.getClass();
					paramArray[3] =table_name.getClass();

					
			

			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);



		  	boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

			String error = (String) results.get("error") ;
			String error_value = "0" ;
			if ( inserted )
			{
				 error_value = "1" ;
			}
			else
			{
				 error = (String) results.get("error") ;
			}

			error = (String) results.get("error") ;
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8"  ) + "&err_value=" + error_value );

			tabdata.clear();
			condflds.clear();
			results.clear();


		}//E.o.try
		catch ( Exception e )
		{
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ;
		}
		finally
		{
			if(con != null)
			{
				ConnectionManager.returnConnection(con,req);
			}
		}
	}
}
