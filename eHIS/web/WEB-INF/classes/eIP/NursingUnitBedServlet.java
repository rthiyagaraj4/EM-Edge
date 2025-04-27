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
import webbeans.eCommon.*;
import eCommon.SingleTabHandler.*;

public class NursingUnitBedServlet extends javax.servlet.http.HttpServlet
{
	PrintWriter out;
	java.util.Properties p;
	String p_nursing_unit_code;
	String main_bed_no;
	String p_bed_no ;
	String p_room;
	String prev_eff_status		= "D";
	String pres_eff_status;
	String p_gender_specific_ind;
	String pseudo_bed_status;
	String pseudo_bed_yn;
	String client_ip_address ;
    String facilityId;
	String table_name;
	String CENSUS_BED;  // Added by mano GHL-CRF-418
	String locale				= "" ;
	HttpSession session;
	Connection connection 		= null;
	Statement statement			= null;
	ResultSet resultSet			= null; 	
	Hashtable retHash			= null;
	int countValue				= 0;
	int maxValue				= 0;


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
		session				= req.getSession(false);
		this.p				= (java.util.Properties) session.getValue( "jdbc" ) ;
		this.facilityId		= (String) session.getValue( "facility_id" ) ;
		client_ip_address	= p.getProperty("client_ip_address");
		locale				= p.getProperty("LOCALE");

		if((facilityId==null) || (facilityId.equals("null")) || (facilityId.equals(""))) facilityId = "";
		if ((client_ip_address==null) || (client_ip_address.equals("null"))) client_ip_address = "";
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		try
		{
			this.out = res.getWriter();
			String nursing_unit_code	= checkForNull(req.getParameter("nursing_unit"));
			String room					= checkForNull(req.getParameter("room"));
			String bed_no				= checkForNull(req.getParameter("bed_no"));
			pres_eff_status				= checkForNull(req.getParameter("eff_status"), "D");
			String operation			= checkForNull(req.getParameter("function_name"));
			String no_of_beds_max		= "0";
			main_bed_no					=	checkForNull(req.getParameter("main_bed_no"));
			
			StringBuffer stringBuffer   = new StringBuffer();
			connection					= ConnectionManager.getConnection(req);
			try
			{
				stringBuffer.append(" Select count(*) countValue from ip_nursing_unit_bed where room_no = '"+room+"' and nursing_unit_code = '"+nursing_unit_code+"' and facility_id = '"+facilityId+"' and EFF_STATUS = 'E' and PSEUDO_BED_YN = 'N'");
				statement			=	connection.createStatement();
				resultSet			=	statement.executeQuery(stringBuffer.toString());

				if ((resultSet != null) && (resultSet.next()))
					countValue  = resultSet.getInt("countValue");
				if (resultSet  != null) resultSet.close();
				if (statement  != null) statement.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}

			try
			{
				stringBuffer.delete(0, stringBuffer.length());
				stringBuffer.append("select no_of_beds_max from am_facility_room where room_num = '");
				stringBuffer.append(room);
				stringBuffer.append("' and operating_facility_id = '"+facilityId+"' ");
				statement	=	connection.createStatement();
				resultSet	=	statement.executeQuery(stringBuffer.toString());

				if ((resultSet != null) && (resultSet.next()))
					no_of_beds_max = checkForNull(resultSet.getString("no_of_beds_max"));
				if (resultSet != null) resultSet.close();
				if (statement != null) statement.close();
			}catch(Exception ee)
			{
				ee.printStackTrace();
			}

			if ((no_of_beds_max != null) && (!no_of_beds_max.equals("")))
				maxValue = Integer.parseInt(no_of_beds_max);

			try
			{
				stringBuffer.delete(0, stringBuffer.length());
				stringBuffer.append("Select EFF_STATUS from ip_nursing_unit_bed where room_no = '"+room+"' and nursing_unit_code = '"+nursing_unit_code+"' and facility_id = '"+facilityId+"' and bed_no = '"+bed_no+"' and PSEUDO_BED_YN = 'N'");
				statement	=	connection.createStatement();
				resultSet	=	statement.executeQuery(stringBuffer.toString());

				if ((resultSet != null) && (resultSet.next()))
				{
					prev_eff_status = resultSet.getString("EFF_STATUS");
				}
					if(prev_eff_status == null) prev_eff_status = "D";
				if (resultSet != null) resultSet.close();
				if (statement != null) statement.close();
			}catch(Exception ee)
			{
				ee.printStackTrace();
			}

		if ((no_of_beds_max != null) && (!no_of_beds_max.equals("")))
			maxValue = Integer.parseInt(no_of_beds_max);

		if ((maxValue <= countValue) && (operation.equals("insert"))&& (main_bed_no.equals("")))
			{
				MessageManager mm = new MessageManager();
				final java.util.Hashtable mesg = mm.getMessage(locale, "MAX_BED_ALLOWED","IP") ;
				String msg1=(String)mesg.get("message");
				
				out.println("<script language='JavaScript'>parent.frames[1].clearFormValues();</script>");
				out.println("<script>parent.frames[1].document.Nursing_Unit_Bed.search_bed.disabled = true;</script>");
				out.println("<html><script>location.href =\"../eCommon/jsp/MstCodeError.jsp?err_num="+ java.net.URLEncoder.encode(msg1+" : " + maxValue)+" &err_value=1\"</script><body class='message'></html>");
							
			}
			else
			{
				if ( operation.equals("insert"))   insertNursingUnitBed(req);
				if ( operation.equals("modify"))   modifyNursingUnitBed(req);
				if ( operation.equals("Delete"))   deleteNursingUnitBed(req);
			}
		}catch(Exception exp)
		{
			exp.printStackTrace();
		}
		finally
		{
			if(connection != null)  ConnectionManager.returnConnection(connection,req);
		}
	}

	private void insertNursingUnitBed(HttpServletRequest req)
	{
		try
		{
			p_nursing_unit_code	=	checkForNull(req.getParameter("nursing_unit"));
			p_bed_no			=	checkForNull(req.getParameter("bed_no"));
			//main_bed_no			=	checkForNull(req.getParameter("main_bed_no"));

			if(! main_bed_no.equals(""))
			{
				pseudo_bed_yn	  = "Y";
				pseudo_bed_status = "N";
			}
			else
			{
				pseudo_bed_yn	  = "N";
				pseudo_bed_status = "N";
			}
			p_room							=	checkForNull(req.getParameter("room"));
			p_gender_specific_ind			=	checkForNull(req.getParameter("gender_specific_ind_code"));
			CENSUS_BED				        =   checkForNull(req.getParameter("CENSUS_BED"), "N"); //Added by Mano for CRF-GHL-0418
			String addedById				=	checkForNull(p.getProperty( "login_user" ));
			String modifiedById				=	checkForNull(addedById);
			String addedFacilityId			=	checkForNull(facilityId);
			String modifiedFacilityId		=	checkForNull(addedFacilityId);
			String addedAtWorkstation		=	checkForNull(client_ip_address);
			String modifiedAtWorkstation	=	checkForNull(addedAtWorkstation);
			Timestamp added_date			= new Timestamp(System.currentTimeMillis() );
			Timestamp modified_date			= new Timestamp(System.currentTimeMillis() );
			
			HashMap tabdata=new HashMap();
			
			tabdata.put("FACILITY_ID",facilityId);
			tabdata.put("NURSING_UNIT_CODE", p_nursing_unit_code);
			tabdata.put("MAIN_BED_NO", main_bed_no);
			tabdata.put("PSUEDO_BED_STATUS", pseudo_bed_status);
			tabdata.put("PSEUDO_BED_YN", pseudo_bed_yn);
			tabdata.put("BED_NO", p_bed_no);
			tabdata.put("ROOM_NO", p_room);
			tabdata.put("EFF_STATUS", checkForNull(req.getParameter("eff_status"), "D"));
			tabdata.put("BED_CLASS_CODE",checkForNull(req.getParameter("bed_class")) );
			tabdata.put("BED_TYPE_CODE", checkForNull(req.getParameter("bed_type")));
			tabdata.put("SEX_SPEC_IND", p_gender_specific_ind);
			tabdata.put("SPECIALTY_CODE", checkForNull(req.getParameter("speciality")));
			tabdata.put("INPATIENT_PAT_CLASS_APPL_YN", checkForNull(req.getParameter("inpatient"), "N"));
			tabdata.put("EMERGENCY_PAT_CLASS_APPL_YN", checkForNull(req.getParameter("emergency"), "N"));
			tabdata.put("DAYCARE_PAT_CLASS_APPL_YN", checkForNull(req.getParameter("day_care"), "N"));
			tabdata.put("NEWBORN_PAT_CLASS_APPL_YN", checkForNull(req.getParameter("new_born"), "N"));
			tabdata.put("LODGER_PAT_CLASS_APPL_YN",checkForNull(req.getParameter("lodger"), "N") );
			tabdata.put("added_by_id",addedById);
			tabdata.put("added_date",added_date);
			tabdata.put("added_facility_id", facilityId);
			tabdata.put("added_at_ws_no",addedAtWorkstation);
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",modified_date);
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );
			tabdata.put("CENSUS_BED_YN",CENSUS_BED );  //Added by mano GHL-CRF-0418
			String dupflds[]={"NURSING_UNIT_CODE","FACILITY_ID","BED_NO"};
			
			table_name			= "ip_nursing_unit_bed";
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
		
			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue());
			out.println("<script>parent.frames[1].document.Nursing_Unit_Bed.status.value ='"+inserted+"';</script>");
			String error = (String) results.get("error") ;
			String error_value = "0" ;
			results.clear();
			if ( inserted )
			{
			error_value = "1" ;
			out.println("<script language='JavaScript'>parent.frames[1].clearvalues();</script>");
			}
			if ((main_bed_no.equals("")))
			{
				out.println("<script>parent.frames[1].document.Nursing_Unit_Bed.search_bed.disabled = true;</script>");
				out.println("<script>parent.frames[1].document.Nursing_Unit_Bed.main_bed_no.disabled = true;</script>");
			}
			out.println("<html><script>location.href =\"../eCommon/jsp/MstCodeError.jsp?err_num="+ java.net.URLEncoder.encode(error, "UTF-8")+" &err_value="+error_value+"\"</script><body class='message'></html>");
				
			tabdata.clear();
		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
	}

	private void modifyNursingUnitBed(HttpServletRequest req)
	{
		try
		{
			p_nursing_unit_code		=	checkForNull(req.getParameter("nursing_unit"));
			p_bed_no				=	checkForNull(req.getParameter("bed_no"));
			p_room					=	checkForNull(req.getParameter("room"));
			p_gender_specific_ind	=	checkForNull(req.getParameter("gender_specific_ind_code"));

			CENSUS_BED		        =   checkForNull(req.getParameter("CENSUS_BED"), "N"); //Added by mano CRF-GHL-CRF-0418
			

			String addedById		=	checkForNull(p.getProperty( "login_user" )) ;
			String modifiedById		=	checkForNull(addedById);
			String addedFacilityId	=	checkForNull(facilityId);

			String modifiedFacilityId		=	checkForNull(addedFacilityId );
			String addedAtWorkstation		= 	checkForNull(client_ip_address);
			String modifiedAtWorkstation	=	checkForNull(addedAtWorkstation) ;
			String gender					=	"";
			gender							=	p_gender_specific_ind;
			if(p_gender_specific_ind.equals("Female"))
				gender   = "F";
			else if(p_gender_specific_ind.equals("Male"))
				gender   = "M";
			else if(p_gender_specific_ind.equals("Unknown"))
				gender   = "U";
			boolean flag = true;

			Timestamp modified_date = new Timestamp(System.currentTimeMillis() );
			HashMap tabdata = new HashMap();

			if ((prev_eff_status.equals("D")) && (pres_eff_status.equals("E")))
			{
				if (maxValue <= countValue)
				{
					MessageManager mm = new MessageManager();
					final java.util.Hashtable mesg = mm.getMessage(locale, "MAX_BED_ALLOWED","IP") ;
					String         msg1=(String)mesg.get("message");
					flag = false;
				
					out.println("<script language='JavaScript'>parent.frames[1].clearFormValues();</script>");
					if ((main_bed_no.equals("")))
					{
						out.println("<script>parent.frames[1].document.Nursing_Unit_Bed.search_bed.disabled = true;</script>");
					}
					out.println("<html><script>location.href =\"../eCommon/jsp/MstCodeError.jsp?err_num="+ java.net.URLEncoder.encode(msg1+" : " + maxValue)+" &err_value=1\"</script><body class='message'></html>");
					
					
				}
				else
				flag = true;
			}

			if(flag)
			{
				
				tabdata.put("ROOM_NO", p_room);
				tabdata.put("eff_status", checkForNull(req.getParameter("eff_status"), "D"));
				tabdata.put("bed_class_code",checkForNull(req.getParameter("bed_class")) );
				tabdata.put("bed_type_code", checkForNull(req.getParameter("bed_type")));
				tabdata.put("sex_spec_ind", gender);
				tabdata.put("specialty_code", checkForNull(req.getParameter("speciality")));
				tabdata.put("inpatient_pat_class_appl_yn", checkForNull(req.getParameter("inpatient"), "N"));
				tabdata.put("emergency_pat_class_appl_yn", checkForNull(req.getParameter("emergency"), "N"));
				tabdata.put("daycare_pat_class_appl_yn", checkForNull(req.getParameter("day_care"), "N"));
				tabdata.put("newborn_pat_class_appl_yn", checkForNull(req.getParameter("new_born"), "N"));
				tabdata.put("lodger_pat_class_appl_yn",checkForNull(req.getParameter("lodger"), "N") );
				tabdata.put("added_by_id",addedById);
				tabdata.put("added_facility_id", facilityId);
				tabdata.put("added_at_ws_no",addedAtWorkstation);
				tabdata.put("modified_by_id",modifiedById);
				tabdata.put("modified_date",modified_date);
				tabdata.put("modified_facility_id",modifiedFacilityId);
				tabdata.put("modified_at_ws_no",modifiedAtWorkstation );
				tabdata.put("CENSUS_BED_YN", CENSUS_BED);  //Added by mano GHL-CRF-0418
				

				HashMap condflds = new HashMap();

				condflds.put("facility_id",facilityId);
				condflds.put("nursing_unit_code",p_nursing_unit_code);
				condflds.put("bed_no",p_bed_no);

				table_name		   = "ip_nursing_unit_bed";
				boolean local_ejbs = false;

				if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

				Object home		   = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
				Object busObj	   = (home.getClass().getMethod("create",null)).invoke(home,null);

				Object argArray[]  = new Object[4];
				argArray[0]		   = p;
				argArray[1]		   = tabdata;
				argArray[2]		   = condflds;
				argArray[3]		   = table_name;

				Class [] paramArray= new Class[4];
				paramArray[0]	   = p.getClass();
				paramArray[1]	   = tabdata.getClass();
				paramArray[2]	   = condflds.getClass();
				paramArray[3]	   = table_name.getClass();

				java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);

				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

				boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
				out.println("<script>parent.frames[1].document.Nursing_Unit_Bed.status.value ='"+inserted+"';</script>");
				String error = (String) results.get("error") ;
				String error_value = "0" ;
				results.clear();
				condflds.clear();
				tabdata.clear();

				if (inserted)
				{
				error_value = "1" ;
				out.println("<script language='JavaScript'>parent.frames[1].clearvalues();</script>");
				}
				
				if ((main_bed_no.equals("")))
				{
					out.println("<script>parent.frames[1].document.Nursing_Unit_Bed.search_bed.disabled = true;</script>");
				}
				out.println("<html><script>location.href =\"../eCommon/jsp/MstCodeError.jsp?err_num="+ java.net.URLEncoder.encode(error, "UTF-8")+" &err_value="+error_value+"\"</script><body class='message'></html>");
								
			}
		}
		catch ( Exception e )
		{
			e.printStackTrace(System.out);
		}
	}

	private void deleteNursingUnitBed(HttpServletRequest req)
	{
		Connection con =null;
		Statement st1 = null;
		Statement st2 = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		int count1	  = 0;
		int count2    = 0;
		try
		{
			con = ConnectionManager.getConnection(req);
			p_nursing_unit_code	=	checkForNull(req.getParameter("nursing_unit"));
			p_bed_no			=	checkForNull(req.getParameter("bed_no"));

			p_room				=	checkForNull(req.getParameter("room"));
			//String chkadt = "select count(*) Count1 from ip_adt_trn where TO_ROOM_NO='"+p_room+"' and TO_NURSING_UNIT ='"+p_nursing_unit_code+"' and TO_BED_NO='"+p_bed_no+"'and facility_id='"+facilityId+"'";
			
			String chkBedReq = "select count(*) Count1 from IP_BED_CLASS_REQUEST where TO_NURSING_UNIT_CODE ='"+p_nursing_unit_code+"' and TO_BED_NO='"+p_bed_no+"'and facility_id='"+facilityId+"'";


	    	String chktfr = "select count(*) Count2 from ip_transfer_request where REQ_ROOM_NO ='"+p_room+"' and REQ_NURSING_UNIT_CODE='"+p_nursing_unit_code+"' and REQ_BED_NO='"+p_bed_no+"' and facility_id='"+facilityId+"'";
			st1 = con.createStatement();
			rs1 = st1.executeQuery(chkBedReq);
			while(rs1.next())
			{
				count1 = rs1.getInt("Count1");
			}
			if(rs1 != null) rs1.close();
			if(st1 != null) st1.close();

			st2 = con.createStatement();
			rs2 = st2.executeQuery(chktfr);
			while(rs2.next())
			{
				count2 = rs2.getInt("Count2");
			}

			if((count1==0)&&(count2==0))
			{
				HashMap condflds=new HashMap();
				condflds.put("facility_id",facilityId);
				condflds.put("nursing_unit_code",p_nursing_unit_code);
				condflds.put("bed_no",p_bed_no);
					table_name		   = "ip_nursing_unit_bed";

					Object argArray[]  = new Object[3];
					argArray[0]		   = p;
					argArray[1]		   = condflds;
					argArray[2]		   = table_name;

					Class []paramArray= new Class[3];
					paramArray[0]	   = p.getClass();
					paramArray[1]	   = condflds.getClass();
					paramArray[2]	   = table_name.getClass();


				boolean local_ejbs	= false;

				if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
				java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("delete",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);		
			
				boolean inserted	= ( ((Boolean) results.get( "status" )).booleanValue() ) ;
						String error = (String) results.get("error") ;

				results.clear();
				condflds.clear();

					String error_value = "0" ;
					if ( inserted )
				{
					error_value = "1" ;
				out.println("<script language='JavaScript'>parent.frames[1].clearvalues();</script>");
				}
					if ((main_bed_no.equals("")))
					{
						out.println("<script>parent.frames[1].document.Nursing_Unit_Bed.search_bed.disabled = true;</script>");
					}
					out.println("<html><script>location.href 	=\"../eCommon/jsp/MstCodeError.jsp?err_num="+ java.net.URLEncoder.encode(error, "UTF-8")+" &err_value="+error_value+"\"</script><body class='message'></html>");
										
			}
			else
			{
				MessageManager msg= new MessageManager();
				retHash = msg.getMessage(locale,"BED_USED_CANT_DELETE","IP");
				String message		= (String)retHash.get("message");
				String error_value	=	"0";
				if ((main_bed_no.equals("")))
				{
					out.println("<script>parent.frames[1].document.Nursing_Unit_Bed.search_bed.disabled = true;</script>");
				}
				out.println("<html><script>location.href =\"../eCommon/jsp/MstCodeError.jsp?err_num="+ java.net.URLEncoder.encode(message,"UTF-8")+" &err_value="+error_value+"\"</script><body class='message'></html>");
				return;
			}
			if(rs2 != null) rs2.close();
			if(st2 != null) st2.close();
		}
		catch ( Exception e )
		{
			e.printStackTrace(System.out);
			e.printStackTrace(System.err);
		}
		finally
		{
			if(con != null)  ConnectionManager.returnConnection(con,req);
		}
	}

	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null")) || (inputString.equals(""))) ? defaultValue : inputString);
	}
}
