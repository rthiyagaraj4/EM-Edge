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
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.MessageManager;
import eCommon.SingleTabHandler.*;

public class PseudoBedCreationServlet extends javax.servlet.http.HttpServlet
{
	PrintWriter out;
	Properties p;

	String p_nursing_unit_code;
	String p_bed_no ;
	String p_room;
	String p_eff_status;
	String p_bed_class_code;
	String p_bed_type_code	;
	String p_gender_specific_ind;
	String p_speciality;
	String p_inpatient;
	String p_emergency;
	String p_day_care;
	String p_new_born;
	String p_lodger;
	String frommodal;
	String p_pseudo_bed_yn;
	String locale			= "" ;
	String client_ip_address ;
    String facilityId;
	HttpSession session;
	Hashtable retHash		=	null;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
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

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		try
		{
			session				= req.getSession(false);
			this.p				= (Properties) session.getValue( "jdbc" ) ;
			this.facilityId		= (String) session.getValue( "facility_id" ) ;
			client_ip_address	= p.getProperty("client_ip_address");
			locale				= p.getProperty("LOCALE");
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			this.out = res.getWriter();
			String operation = req.getParameter("function_name");

			if ( operation.equals("insert"))   insertNursingUnitBed(req, res);
			if ( operation.equals("modify"))    modifyNursingUnitBed(req, res);
			if (operation.equals("Delete"))	deletePseudoBedCreation(req, res);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}


	private void insertNursingUnitBed(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			// added by chitra for insertion into PSEUDO_BED_YN column of ip_bed_booking*/
			p_pseudo_bed_yn = req.getParameter("pseudo_bed_yn")==null?"N":req.getParameter("pseudo_bed_yn");
			frommodal = req.getParameter("from_modal")==null?"":req.getParameter("from_modal");
			// added by chitra ends */

			p_nursing_unit_code=req.getParameter("nursing_unit");
			p_bed_no = req.getParameter("bed_no");

			p_room = req.getParameter("room");
			p_eff_status = req.getParameter("eff_status");
			if ( p_eff_status == null )
				p_eff_status="D";

			p_bed_class_code = req.getParameter("bed_class");
			p_bed_type_code= req.getParameter("bed_type");
			p_gender_specific_ind = req.getParameter("gender_specific_ind_code");
			p_speciality = req.getParameter("speciality");
			p_inpatient = req.getParameter("inpatient");
			if ( p_inpatient == null )
				p_inpatient="N";

			p_emergency = req.getParameter("emergency");
			if ( p_emergency == null )
				p_emergency="N";

			p_day_care = req.getParameter("day_care");
			if ( p_day_care == null )
				p_day_care="N";

			p_new_born = req.getParameter("new_born");
			if ( p_new_born == null )
				p_new_born="N";

			p_lodger = req.getParameter("lodger");
			if ( p_lodger == null )
				p_lodger="N";

			String addedById = p.getProperty( "login_user" ) ;
			String modifiedById = addedById ;
			String addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;
			Timestamp added_date = new Timestamp(System.currentTimeMillis() );
			Timestamp modified_date = new Timestamp(System.currentTimeMillis() );


			HashMap tabdata=new HashMap();
			tabdata.put("FACILITY_ID",facilityId);
			tabdata.put("NURSING_UNIT_CODE", p_nursing_unit_code);
			tabdata.put("BED_NO", p_bed_no);
			tabdata.put("ROOM_NO", p_room);
			tabdata.put("EFF_STATUS", p_eff_status);
			tabdata.put("BED_CLASS_CODE",p_bed_class_code );
			tabdata.put("BED_TYPE_CODE", p_bed_type_code);
			tabdata.put("SEX_SPEC_IND", p_gender_specific_ind);
			tabdata.put("SPECIALTY_CODE", p_speciality);
			tabdata.put("PSEUDO_BED_YN", p_pseudo_bed_yn);
			tabdata.put("INPATIENT_PAT_CLASS_APPL_YN", p_inpatient);
			tabdata.put("EMERGENCY_PAT_CLASS_APPL_YN", p_emergency);
			tabdata.put("DAYCARE_PAT_CLASS_APPL_YN", p_day_care);
			tabdata.put("NEWBORN_PAT_CLASS_APPL_YN", p_new_born);
			tabdata.put("LODGER_PAT_CLASS_APPL_YN",p_lodger );

			tabdata.put("added_by_id",addedById);
			tabdata.put("added_date",added_date);
			tabdata.put("added_facility_id", facilityId);
			tabdata.put("added_at_ws_no",addedAtWorkstation);
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",modified_date);
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );

			String dupflds[]={"NURSING_UNIT_CODE","FACILITY_ID","BED_NO"};

			String table_name	= "ip_nursing_unit_bed";
			boolean local_ejbs	= false;

			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = dupflds;
			argArray[3] = table_name;

			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();
			paramArray[2] = dupflds.getClass();
			paramArray[3] = table_name.getClass();

			HashMap results = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			  
			  boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

			String error = (String) results.get("error") ;
			String error_value = "0" ;

			if(frommodal.equals("Y"))
			{
				out.println("<script>alert(\""+error+"\");parent.window.returnValue='"+p_bed_no+"';parent.window.close();</script>");
			}
			else
			{
				if ( inserted )
				{
					error_value = "1" ;
				}
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
			}
			tabdata.clear();
			results.clear();
		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
	}


	private void modifyNursingUnitBed(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			p_nursing_unit_code=req.getParameter("nursing_unit");
			p_bed_no = req.getParameter("bed_no");
			p_room = req.getParameter("room");
			p_eff_status = req.getParameter("eff_status");
			if ( p_eff_status == null )
				p_eff_status="D";

			p_pseudo_bed_yn = req.getParameter("pseudo_bed_yn")==null?"N":req.getParameter("pseudo_bed_yn");

			p_bed_class_code = req.getParameter("bed_class");
			p_bed_type_code= req.getParameter("bed_type");
			p_gender_specific_ind = req.getParameter("gender_specific_ind_code");
			p_speciality = req.getParameter("speciality");
			p_inpatient = req.getParameter("inpatient");
			if ( p_inpatient == null )
				p_inpatient="N";

			p_emergency = req.getParameter("emergency");
			if ( p_emergency == null )
				p_emergency="N";
			else
				p_emergency="Y";

			p_day_care = req.getParameter("day_care");
			if ( p_day_care == null )
				p_day_care="N";

			p_new_born = req.getParameter("new_born");
			if ( p_new_born == null )
				p_new_born="N";

			p_lodger = req.getParameter("lodger");
			if ( p_lodger == null )
				p_lodger="N";

			String addedById = p.getProperty( "login_user" ) ;
			String modifiedById = addedById ;
			String addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;
			Timestamp modified_date = new Timestamp(System.currentTimeMillis() );

			HashMap tabdata=new HashMap();
			tabdata.put("ROOM_NO", p_room);
			tabdata.put("eff_status", p_eff_status);
			tabdata.put("bed_class_code",p_bed_class_code );
			tabdata.put("sex_spec_ind", p_gender_specific_ind);
			tabdata.put("specialty_code", p_speciality);
			tabdata.put("PSEUDO_BED_YN", p_pseudo_bed_yn);
			tabdata.put("inpatient_pat_class_appl_yn", p_inpatient);
			tabdata.put("emergency_pat_class_appl_yn", p_emergency);
			tabdata.put("daycare_pat_class_appl_yn", p_day_care);
			tabdata.put("newborn_pat_class_appl_yn", p_new_born);
			tabdata.put("lodger_pat_class_appl_yn",p_lodger );

			tabdata.put("added_by_id",addedById);
			tabdata.put("added_facility_id", facilityId);
			tabdata.put("added_at_ws_no",addedAtWorkstation);
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",modified_date);
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );

			HashMap condflds=new HashMap();
			condflds.put("facility_id",facilityId);
			condflds.put("nursing_unit_code",p_nursing_unit_code);
			condflds.put("bed_no",p_bed_no);
			  
			String table_name	= "ip_nursing_unit_bed";
			boolean local_ejbs	= false;

			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = condflds;
			argArray[3] = table_name;

			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();
			paramArray[2] = condflds.getClass();
			paramArray[3] = table_name.getClass();

			HashMap results = (HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
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
				error_value = "0" ;
			}
			error = (String) results.get("error") ;
			res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
			tabdata.clear();
			condflds.clear();
			results.clear();
		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
	}

	private void deletePseudoBedCreation(HttpServletRequest req, HttpServletResponse res)
	{
		Connection con =null;
		Statement st1 = null;
		Statement st2 = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		int count1 = 0;
		int count2 = 0;
		try
		{
			  p_nursing_unit_code=req.getParameter("nursing_unit");
			  p_bed_no = req.getParameter("bed_no");
			 
			  String chkBedReq = "select count(*) Count1 from IP_BED_CLASS_REQUEST where TO_NURSING_UNIT_CODE ='"+p_nursing_unit_code+"' and TO_BED_NO='"+p_bed_no+"'and facility_id='"+facilityId+"'";

	    	  String chktfr = "select count(*) Count2 from IP_TRANSFER_REQUEST where REQ_NURSING_UNIT_CODE='"+p_nursing_unit_code+"' and REQ_BED_NO='"+p_bed_no+"' and facility_id='"+facilityId+"'";
			 
			  con = ConnectionManager.getConnection(req);
			  st1 = con.createStatement();
			  rs1 = st1.executeQuery(chkBedReq);
				while(rs1.next())
				{
					count1 = rs1.getInt("Count1");
				}
				if(rs1!=null)    rs1.close();
				if(st1!=null) st1.close();
				st2 = con.createStatement();
				rs2 = st2.executeQuery(chktfr);
				while(rs2.next())
				{
					count2 = rs2.getInt("Count2");
				}
				if(rs2!=null)    rs2.close();
				if(st2!=null) st2.close();
			  if((count1==0)&&(count2==0))
			  {
				  HashMap delflds=new HashMap();
				  delflds.put("nursing_unit_code",p_nursing_unit_code);
				  delflds.put("bed_no",p_bed_no);
				  delflds.put("facility_id",facilityId);

					

/*

				  InitialContext context = new InitialContext();
				  Object homeObject = context.lookup("java:comp/env/SingleTabHandler");
				  SingleTabHandlerManagerHome singleTabHandlerManagerHome  = (SingleTabHandlerManagerHome) PortableRemoteObject.narrow(homeObject ,SingleTabHandlerManagerHome.class);
				  SingleTabHandlerManagerRemote singleTabHandlerManagerRemote = singleTabHandlerManagerHome.create();
				  java.util.HashMap results = singleTabHandlerManagerRemote.delete(p,delflds,"IP_NURSING_UNIT_BED");
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
*/


				String table_name	= "IP_NURSING_UNIT_BED";
				boolean local_ejbs	= false;

				if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

				Object argArray[] = new Object[3];
				argArray[0] = p;
				argArray[1] = delflds;
				argArray[2] = table_name;

				Class [] paramArray = new Class[3];
				paramArray[0] = p.getClass();
				paramArray[1] = delflds.getClass();
				paramArray[2] = table_name.getClass();

				HashMap results = (HashMap)(busObj.getClass().getMethod("delete",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

				boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
				String error = (String) results.get("error") ;
				String error_value = "0" ;

				if ( inserted )
					error_value = "1" ;
				else
					error = (String) results.get("error") ;
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num="+java.net.URLEncoder.encode(error,"UTF-8")+"&err_value="+error_value);
				delflds.clear();
				results.clear();
			}
			else
			{
				MessageManager msg= new MessageManager();
				retHash = msg.getMessage(locale,"BED_USED_CANT_DELETE","IP");
				String message		= (String)retHash.get("message");
				String error_value	=	"0";
				out.println("<html><script>location.href =\"../eCommon/jsp/error.jsp?err_num="+ java.net.URLEncoder.encode(message,"UTF-8")+" &err_value="+error_value+"\"</script><body class='message'></html>");
			}
		}catch ( Exception e )
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(rs1!=null)    rs1.close();
				if(st1!=null) st1.close();
				if(rs2!=null)    rs2.close();
				if(st2!=null) st2.close();
				if(con != null)  ConnectionManager.returnConnection(con,req);
			}catch(Exception e){}
		}
	}

}
