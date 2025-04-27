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
import java.util.Properties;
import java.util.HashMap;
import java.util.ArrayList;
import javax.naming.*;
import javax.rmi.*;
import eCommon.XSSRequestWrapper;
import webbeans.eCommon.*;
import eCommon.SingleTabHandler.*;

public class NursingUnitServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel
{
	PrintWriter out;
	Properties p;

	String nursingunitcode				= "";
	String bl_setup_ip					= "";
	String bill_type					= "";
	String client_ip_address			= "";
    String facilityId					= "";
	String addedById					= "";
	String table_name					= "";
	Timestamp added_date				= null;
	Connection con						= null;
	ArrayList pat_ins_bean = new ArrayList();
	int display_order=0;
	String pat_ins_id="";
	String default_yn="";
	HttpSession session;
	RecordSet associateDiagBean = new RecordSet();

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

public  void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
{
	session						= req.getSession(false);
	this.p						= (java.util.Properties) session.getValue( "jdbc" ) ;
	this.facilityId				= (String) session.getValue( "facility_id" ) ;
	client_ip_address			= p.getProperty("client_ip_address");
	try
	{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		req= new XSSRequestWrapper(req);
		res.addHeader("X-XSS-Protection", "1; mode=block");
		res.addHeader("X-Content-Type-Options", "nosniff");

		this.out				= res.getWriter();
		nursingunitcode			= checkForNull(req.getParameter("nursing_unit_code"));
		bl_setup_ip				= checkForNull(req.getParameter("bl_setup_ip"),"N");

		if(bl_setup_ip.equals("Y"))
		{
			bill_type			= checkForNull(req.getParameter("bill_type"));
		}
		addedById				= p.getProperty( "login_user" ) ;

		String operation = req.getParameter("function_name");
		associateDiagBean = (RecordSet) session.getValue("associateDiagBean");
		if (operation.equals("insert"))	insertNursingUnit(req, res);
		if (operation.equals("modify"))	modifyNursingUnit(req, res);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}

private void insertNursingUnit(HttpServletRequest req, HttpServletResponse res)
{
	try
	{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		HashMap tabdata=new HashMap();
		pat_ins_bean= associateDiagBean.getRecordSetHandle();
		tabdata.put("facility_id",facilityId);
		tabdata.put("nursing_unit_code",nursingunitcode);
		tabdata.put("physical_location",checkForNull(req.getParameter("physical_location")));
		tabdata.put("locn_type",checkForNull(req.getParameter("locn_type")));
		tabdata.put("long_desc",checkForNull(req.getParameter("long_desc")));
		tabdata.put("short_desc",checkForNull(req.getParameter("short_desc")));
		tabdata.put("nursing_unit_type_code",checkForNull(req.getParameter("nursing_unit_type_code")));
		tabdata.put("age_group_code",checkForNull(req.getParameter("age_group_code")));
		tabdata.put("dept_code",checkForNull(req.getParameter("dept_code")));
		tabdata.put("service_code",checkForNull(req.getParameter("service_code")));
		tabdata.put("level_of_care_code",checkForNull(req.getParameter("level_of_care_code")));
		tabdata.put("incl_for_hosp_occup_calc_yn",checkForNull(req.getParameter("incl_for_hosp_occup_calc_yn"),"N"));
		tabdata.put("allow_emerg_trf_yn",checkForNull(req.getParameter("allow_emerg_trg_yn"),"N"));
		tabdata.put("temporary_location_yn",checkForNull(req.getParameter("temporary_location_yn"),"N"));
		tabdata.put("teaching_location_yn",checkForNull(req.getParameter("teaching_location_yn"),"N"));
		tabdata.put("allow_pseudo_bed_yn",checkForNull(req.getParameter("allow_pseudo_bed_srl_yn"),"N"));
		tabdata.put("check_same_sex_in_room_yn",checkForNull(req.getParameter("check_same_sex_in_room_yn"),"N"));
		tabdata.put("online_mr_notfn_yn",checkForNull(req.getParameter("online_mr_notfn_yn"),"N"));
		tabdata.put("auto_file_transfer_yn",checkForNull(req.getParameter("auto_file_transfer_yn"),"N"));
		tabdata.put("eff_status",checkForNull(req.getParameter("eff_status"),"D"));
		tabdata.put("fs_locn_code",checkForNull(req.getParameter("mr_location_code")));
		tabdata.put("section_code",checkForNull(req.getParameter("section")));
		tabdata.put("release_bed_on_leave_yn",checkForNull(req.getParameter("rel_bed_on_leave"),"N"));
		tabdata.put("ALLOW_NEW_BORN_REGN_YN",checkForNull(req.getParameter("all_new_bor"),"N"));
		tabdata.put("APPL_PATIENT_CLASS",checkForNull(req.getParameter("applicable_to")));

		tabdata.put("MR_SECTION_CODE",checkForNull(req.getParameter("mr_section")));
		tabdata.put("MR_SECTION_TYPE",checkForNull(req.getParameter("mr_section_type")));
		tabdata.put("DFLT_FILE_TYPE_CODE",checkForNull(req.getParameter("dflt_file_type")));

		tabdata.put("added_by_id",addedById);
		tabdata.put("added_date",added_date);
		tabdata.put("added_facility_id", facilityId);
		tabdata.put("added_at_ws_no",client_ip_address);
		tabdata.put("modified_by_id",addedById);
		tabdata.put("modified_date",added_date);
		tabdata.put("modified_facility_id",facilityId);
		tabdata.put("modified_at_ws_no",client_ip_address );
		String dupflds[]={"nursing_unit_code","facility_id"};
	
		table_name			= "ip_nursing_unit";
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


		boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
		String error = (String) results.get("error") ;
		String error_value = "0" ;
		if (inserted)
		{
			HashMap pat_inst_tabdata=new HashMap();
			/* CheckStyle Violation Commented by Munisekhar */ 
			//HashMap pat_inst_condflds = new HashMap();
			error_value = "1" ;
			int size=pat_ins_bean.size();

			size=size/4;
			if(size > 0)
			{
			int k=-1;
			for(int m=0;m<size;m++)
			{
				k++;
				display_order=Integer.parseInt(pat_ins_bean.get(k).toString());

				k=k+2;
				pat_ins_id=pat_ins_bean.get(k).toString();
				default_yn=pat_ins_bean.get(++k).toString();	
				pat_inst_tabdata.put("DISPLAY_ORDER",display_order);

				pat_inst_tabdata.put("DEFAULT_LINKED_YN",default_yn);
				pat_inst_tabdata.put("ADDED_BY_ID",addedById);
				pat_inst_tabdata.put("ADDED_DATE",added_date);
				pat_inst_tabdata.put("ADDED_AT_WS_NO",client_ip_address);
				pat_inst_tabdata.put("ADDED_FACILITY_ID",facilityId);
				pat_inst_tabdata.put("MODIFIED_BY_ID",addedById);
				pat_inst_tabdata.put("MODIFIED_DATE",added_date);
				pat_inst_tabdata.put("MODIFIED_AT_WS_NO",client_ip_address);
				pat_inst_tabdata.put("MODIFIED_FACILITY_ID",facilityId);

				table_name			= "IP_NURS_PAT_INSTRUCTIONS";

				pat_inst_tabdata.put("FACILITY_ID",facilityId);
				pat_inst_tabdata.put("NURSING_UNIT_CODE",nursingunitcode);
				pat_inst_tabdata.put("INSTRUCTION_ID",pat_ins_id);
				String pkflds[]={"FACILITY_ID","NURSING_UNIT_CODE","INSTRUCTION_ID"};
				argArray[0] = p;
				argArray[1] = pat_inst_tabdata;
				argArray[2] = pkflds;
				argArray[3] = table_name;
			
				paramArray[0] = p.getClass();
				paramArray[1] = pat_inst_tabdata.getClass();
				paramArray[2] = pkflds.getClass();
				paramArray[3] = table_name.getClass();
				
				//java.util.HashMap results_ptInstn_update = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
				//(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
				java.util.HashMap results_ptInstn_update = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
				boolean instruction_Inserted = ( ((Boolean) results_ptInstn_update.get( "status" )).booleanValue() ) ;
				if (!instruction_Inserted)
				{
					error= (String)results_ptInstn_update.get("error") ;
					con.rollback();
					break;					
				}

				
				
		   }		
       
		}
		}
		if(bl_setup_ip.equals("Y"))
		{
			if(inserted)
			{
				error_value = "1" ;
				HashMap tabdata_bl = new HashMap();
				tabdata_bl.put("facility_id",facilityId);
				tabdata_bl.put("nursing_unit_code",nursingunitcode);
				tabdata_bl.put("bill_type_code",bill_type);
				tabdata_bl.put("added_by_id",addedById);
				tabdata_bl.put("added_date",added_date);
				tabdata_bl.put("modified_by_id",addedById);
				tabdata_bl.put("modified_date",added_date);
				tabdata_bl.put("added_at_ws_no",client_ip_address);
				tabdata_bl.put("added_facility_id",facilityId);
				tabdata_bl.put("modified_at_ws_no",client_ip_address);
				tabdata_bl.put("modified_facility_id",facilityId);

				table_name	= "bl_ip_nursing_unit";
				argArray[0] = p;
				argArray[1] = tabdata_bl;
				argArray[2] = dupflds;
				argArray[3] = table_name;
			
				paramArray[0] = p.getClass();
				paramArray[1] = tabdata_bl.getClass();
				paramArray[2] = dupflds.getClass();
				paramArray[3] = table_name.getClass();
			
				java.util.HashMap results_bl = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
				
				inserted = ( ((Boolean) results_bl.get( "status" )).booleanValue() ) ;

				if(inserted)
				{
					error_value = "1" ;
					res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
				}
				else
				{
					error = (String) results_bl.get("error") ;
					res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode( error, "UTF-8" ) );

				}

				tabdata_bl.clear();
				results_bl.clear();
			}

		}

		if ( inserted )
		{
			error_value = "1" ;
			 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
		}
		else
		{
			 error = (String) results.get("error") ;
			 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode( error, "UTF-8" ) );
		}
		tabdata.clear();
		results.clear();

	}
	catch ( Exception e )
	{
		e.printStackTrace();
	}
}

private void modifyNursingUnit(HttpServletRequest req, HttpServletResponse res)
{
	String del_pat_ins_sql="delete from ip_nurs_pat_instructions where FACILITY_ID=? and NURSING_UNIT_CODE=?"; //included for the CRF RUT-CRF-013
	try
	{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		con				= ConnectionManager.getConnection(req);
		con.setAutoCommit(false);
		HashMap tabdata	= new HashMap();
		pat_ins_bean= associateDiagBean.getRecordSetHandle();
		tabdata.put("physical_location",checkForNull(req.getParameter("physical_location")));
		tabdata.put("long_desc",checkForNull(req.getParameter("long_desc")));
		tabdata.put("short_desc",checkForNull(req.getParameter("short_desc")));
		tabdata.put("nursing_unit_type_code",checkForNull(req.getParameter("nursing_unit_type_code")));
		tabdata.put("age_group_code",checkForNull(req.getParameter("age_group_code")));
		tabdata.put("dept_code",checkForNull(req.getParameter("dept_code")));
		tabdata.put("service_code",checkForNull(req.getParameter("service_code")));
		tabdata.put("level_of_care_code",checkForNull(req.getParameter("level_of_care_code")));
		tabdata.put("incl_for_hosp_occup_calc_yn",checkForNull(req.getParameter("incl_for_hosp_occup_calc_yn"),"N"));
		tabdata.put("allow_emerg_trf_yn",checkForNull(req.getParameter("allow_emerg_trg_yn"),"N"));
		tabdata.put("temporary_location_yn",checkForNull(req.getParameter("temporary_location_yn"),"N"));
		tabdata.put("teaching_location_yn",checkForNull(req.getParameter("teaching_location_yn"),"N"));
		tabdata.put("allow_pseudo_bed_yn",checkForNull(req.getParameter("allow_pseudo_bed_srl_yn"),"N"));
		tabdata.put("check_same_sex_in_room_yn",checkForNull(req.getParameter("check_same_sex_in_room_yn"),"N"));
		tabdata.put("eff_status",checkForNull(req.getParameter("eff_status"),"D"));
		tabdata.put("online_mr_notfn_yn",checkForNull(req.getParameter("online_mr_notfn_yn"),"N"));
		tabdata.put("auto_file_transfer_yn",checkForNull(req.getParameter("auto_file_transfer_yn"),"N"));
		tabdata.put("fs_locn_code",checkForNull(req.getParameter("mr_location_code")));
		tabdata.put("section_code",checkForNull(req.getParameter("section")));
		tabdata.put("APPL_PATIENT_CLASS",checkForNull(req.getParameter("applicable_to")));
		tabdata.put("MR_SECTION_CODE",checkForNull(req.getParameter("mr_section")));
		tabdata.put("DFLT_FILE_TYPE_CODE",checkForNull(req.getParameter("dflt_file_type")));
		tabdata.put("MR_SECTION_TYPE",checkForNull(req.getParameter("mr_section_type")));
		tabdata.put("release_bed_on_leave_yn",checkForNull(req.getParameter("rel_bed_on_leave"),"N"));
		tabdata.put("ALLOW_NEW_BORN_REGN_YN",checkForNull(req.getParameter("all_new_bor"),"N"));
		tabdata.put("modified_by_id",addedById);
		tabdata.put("modified_date",added_date);
		tabdata.put("modified_facility_id",facilityId);
		tabdata.put("modified_at_ws_no",client_ip_address );

		HashMap condflds=new HashMap();
		condflds.put("nursing_unit_code",nursingunitcode);
		condflds.put("facility_id",facilityId);

	
	
		table_name			= "ip_nursing_unit";
		boolean local_ejbs	= false;
		
		if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
			local_ejbs = true;

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
	
		java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

		boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
		String error = (String) results.get("error") ;
		String error_value = "0" ;
		//Billing Interface with IP--Starts here
		if(inserted)
		{
			////included for the CRF RUT-CRF-013
			PreparedStatement pstmt=con.prepareStatement(del_pat_ins_sql);
			pstmt.setString(1,facilityId);
			pstmt.setString(2,nursingunitcode);
		     /* CheckStyle Violation Commented by Munisekhar */
			int instn_deleted=pstmt.executeUpdate();
			con.commit();
			String pkflds[]={"FACILITY_ID","NURSING_UNIT_CODE","INSTRUCTION_ID"};
			HashMap pat_inst_tabdata=new HashMap();
			  /* CheckStyle Violation Commented by Munisekhar */
			//HashMap pat_inst_condflds = new HashMap();
			error_value = "0" ;
			int size=pat_ins_bean.size();
			size=size/4;
			if(size > 0)
			{
			int k=-1;
			for(int m=0;m<size;m++)
			{
				k++;
				display_order=Integer.parseInt(pat_ins_bean.get(k).toString());

				k=k+2;
				pat_ins_id=pat_ins_bean.get(k).toString();
				default_yn=pat_ins_bean.get(++k).toString();	
				pat_inst_tabdata.put("DISPLAY_ORDER",display_order);
				pat_inst_tabdata.put("ADDED_BY_ID",addedById);
				pat_inst_tabdata.put("ADDED_DATE",added_date);
				pat_inst_tabdata.put("ADDED_AT_WS_NO",client_ip_address);
				pat_inst_tabdata.put("ADDED_FACILITY_ID",facilityId);
				pat_inst_tabdata.put("DEFAULT_LINKED_YN",default_yn);
				pat_inst_tabdata.put("MODIFIED_BY_ID",addedById);
				pat_inst_tabdata.put("MODIFIED_DATE",added_date);
				pat_inst_tabdata.put("MODIFIED_AT_WS_NO",client_ip_address);
				pat_inst_tabdata.put("MODIFIED_FACILITY_ID",facilityId);
				pat_inst_tabdata.put("FACILITY_ID",facilityId);
				pat_inst_tabdata.put("NURSING_UNIT_CODE",nursingunitcode);
				pat_inst_tabdata.put("INSTRUCTION_ID",pat_ins_id);
				table_name			= "IP_NURS_PAT_INSTRUCTIONS";

				

				argArray[0] = p;
				argArray[1] = pat_inst_tabdata;
				argArray[2] = pkflds;
				argArray[3] = table_name;
			
				paramArray[0] = p.getClass();
				paramArray[1] = pat_inst_tabdata.getClass();
				paramArray[2] = pkflds.getClass();
				paramArray[3] = table_name.getClass();
				
				java.util.HashMap results_ptInstn_update = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);				
				
				boolean instruction_Inserted = ( ((Boolean) results_ptInstn_update.get( "status" )).booleanValue() ) ;
				if (!instruction_Inserted)
				{
					error= (String)results_ptInstn_update.get("error") ;
					con.rollback();
					break;					
				}
		   }		   
		}
			//Enhancements required
			/*if(bl_setup_ip.equals("Y"))
			 {
				 HashMap tabdata_bl=new HashMap();
				ResultSet rs=null;
				Statement stmt	= null;

				stmt=con.createStatement();
				 try
				 {
					 String sql = "select * from bl_ip_nursing_unit where nursing_unit_code ='"+nursingunitcode+"' and facility_id='"+facilityId+"'";
					 out.println("inside try");
					 rs=stmt.executeQuery(sql);
					 if(rs!=null )
					 {
						if(rs.next())
						{
							out.println("inside update table");
							tabdata_bl.put("bill_type_code",bill_type);
							tabdata_bl.put("modified_by_id",addedById);
							tabdata_bl.put("modified_date",added_date);
							tabdata_bl.put("modified_facility_id",facilityId);
							tabdata_bl.put("modified_at_ws_no",client_ip_address );

							
							table_name			= "bl_ip_nursing_unit";
							argArray[0] = p;
							argArray[1] = tabdata_bl;
							argArray[2] = condflds;
							argArray[3] = table_name;
						
							paramArray[0] = p.getClass();
							paramArray[1] = tabdata_bl.getClass();
							paramArray[2] = condflds.getClass();
							paramArray[3] = table_name.getClass();
						
							java.util.HashMap results_bl_update = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
							(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
				
						}
						else
						{
							tabdata_bl.put("facility_id",facilityId);
							tabdata_bl.put("nursing_unit_code",nursingunitcode);
							tabdata_bl.put("bill_type_code",bill_type);
							tabdata_bl.put("added_by_id",addedById);
							tabdata_bl.put("added_date",added_date);
							tabdata_bl.put("modified_by_id",addedById);
							tabdata_bl.put("modified_date",added_date);
							tabdata_bl.put("added_at_ws_no",client_ip_address);
							tabdata_bl.put("added_facility_id",facilityId);
							tabdata_bl.put("modified_at_ws_no",client_ip_address);
							tabdata_bl.put("modified_facility_id",facilityId);

							String dupflds[]={"nursing_unit_code","facility_id"};

							table_name			= "bl_ip_nursing_unit";
							argArray[0] = p;
							argArray[1] = tabdata_bl;
							argArray[2] = dupflds;
							argArray[3] = table_name;
						
							paramArray[0] = p.getClass();
							paramArray[1] = tabdata_bl.getClass();
							paramArray[2] = dupflds.getClass();
							paramArray[3] = table_name.getClass();
						
							java.util.HashMap results_bl_insert1 = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
							(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
						}
					 }
				 }
				 catch(Exception e){out.print(e);}
				 finally
				 {
					 if(stmt!=null)		stmt.close();
					 if(rs!=null)		rs.close();
				 }
			}*///Billing Interface with IP--Ends here
		con.commit();
		res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
         /* CheckStyle Correction added by Munisekhar */ 
		if(pstmt !=null) pstmt.close(); 
		
		}
		else
		{
		 error = (String) results.get("error") ;
		 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode( error, "UTF-8" ) );
		}
		tabdata.clear();
		condflds.clear();
		results.clear();
	}
	catch ( Exception e )
	{
		try{
			con.rollback();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		e.printStackTrace();
	}
	finally
	{	if(con != null )
		{
			ConnectionManager.returnConnection(con,req);
		}
	}
}
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
}
