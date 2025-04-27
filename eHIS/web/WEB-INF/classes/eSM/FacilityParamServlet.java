/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eSM;

import java.sql.*;
import java.io.*;
import java.net.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;
import org.apache.commons.fileupload.*;
import javax.servlet.http.HttpUtils.*;
import eCommon.SingleTabHandler.*;

public class FacilityParamServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel
{
	PrintWriter out;
	Properties p;

	boolean isMultipart				= false;
	DiskFileUpload upload			= null;
	FileItem Item					= null;
	FileItem  fileItem1				= null;
	long	docSize1					= 0;
	List items						= null;
	Iterator iter					= null;

	String docType1="";
	String docName1="";
	String facility_id="";
	String res_area_code="";
	String res_town_code="";
	String region_code="";

	String head_of_facility_job_title;
	String acc_entity_id="";
	String operation="";
	String gstin_facility = ""; //Added by Ashwini on 28-Jun-2017 for AMS-CRF-0132
	String vat_no ="";  //Added by Mano aganist MMS--DM-CRF-0118.3
	String facility_name = "";
	String site_id = "";
	String addr_line1 = "";
	String addr_line2 = "";
	String addr_line3 = "";
	String addr_line4 = "";
	String addr_line1_loc_lang = "";
	String addr_line2_loc_lang = "";
	String addr_line3_loc_lang = "";
	String addr_line4_loc_lang = "";
	String m_postal_code = "";
	String country_code = "";
	String tel_no1 = "";
	String tel_no2 = "";
	String tel_no3 = "";
	String tel_no4 = "";
	String fax_no = "";
	String email_id = "";
	//String logo = "";
	String website_id = "";
	String head_of_facility_name = "";
	String license_no = "";
	String app_server_ip = "";
	String hcare_setting_type_code = "";
	String category_code = "";
	String language_id = "";
	String display_site_name = "N";
	String fac_logo_name_flag = "";
	String fac_logo_file_name = "";


	Connection con ;
	PreparedStatement pstmt1 ;
	ResultSet rs1 ;
	HttpSession session;

	PreparedStatement pstmt=null;
	PreparedStatement pstmtupdate=null;


	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		session 		= req.getSession(false) ;
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		fac_logo_name_flag = "";
		fac_logo_file_name = ""; 

		try{

		out = res.getWriter() ;
		p = ( java.util.Properties ) session.getValue( "jdbc" ) ;
		con = ConnectionManager.getConnection(req);
		isMultipart			= FileUpload.isMultipartContent(req); 

		if(isMultipart){

			upload			= new DiskFileUpload();
			items			= upload.parseRequest(req);
			iter			= items.iterator();
			String name		= "";
			String value	= "";

			while(iter.hasNext()) {

				Item = (FileItem)iter.next();
				if(Item.isFormField()){

				name		= Item.getFieldName();
				value		= Item.getString();

				if(name.equals("function"))
					operation = value;
				if(name.equals("facility_id"))
					facility_id = value;
				if(name.equals("acc_entity_id"))
					acc_entity_id = value;
				if(name.equals("m_area"))
					res_area_code = value;
				if(name.equals("m_town"))
					res_town_code = value;
				if(name.equals("m_region"))
					region_code = value;
				if(name.equals("head_of_facility_job_title"))
					head_of_facility_job_title = value;
				
				//Added by Ashwini on 28-Jun-2017 for AMS-CRF-0132
				if(name.equals("gstin_facility"))
					gstin_facility = value;
				//Added by Mano aganist MMS--DM-CRF-0118.3
				if(name.equals("vat_no"))
					vat_no = value;

				if(name.equals("facility_name"))
					facility_name = value;
				if(name.equals("site_id"))
					site_id = value;
				if(name.equals("addr_line1"))
					addr_line1 = value;
				if(name.equals("addr_line2"))
					addr_line2 = value;
				if(name.equals("addr_line3"))
					addr_line3 = value;
				if(name.equals("addr_line4"))
					addr_line4 = value;	
				
				if(name.equals("addr_line1_loc_lang")) { 					
					addr_line1_loc_lang =  new String(Item.getString().getBytes("ISO-8859-1"), "UTF-8");
				}
				if(name.equals("addr_line2_loc_lang")) {
					addr_line2_loc_lang =  new String(Item.getString().getBytes("ISO-8859-1"), "UTF-8");
				}
				if(name.equals("addr_line3_loc_lang")) {
					addr_line3_loc_lang =  new String(Item.getString().getBytes("ISO-8859-1"), "UTF-8");
				}
				if(name.equals("addr_line4_loc_lang")) {
					addr_line4_loc_lang =  new String(Item.getString().getBytes("ISO-8859-1"), "UTF-8");
				} 				

				if(name.equals("m_postal_code"))
					m_postal_code = value;
				if(name.equals("country_code"))
					country_code = value;
				if(name.equals("tel_no1"))
					tel_no1 = value;
				if(name.equals("tel_no2"))
					tel_no2 = value;
				if(name.equals("tel_no3"))
					tel_no3 = value;
				if(name.equals("tel_no4"))
					tel_no4 = value;
				if(name.equals("fax_no"))
					fax_no = value;
				if(name.equals("email_id"))
					email_id = value;
				//if(name.equals("logo"))
					//logo = value;
				if(name.equals("website_id"))
					website_id = value;
				if(name.equals("head_of_facility_name"))
					head_of_facility_name = value;
				if(name.equals("license_no"))
					license_no = value;
				if(name.equals("app_server_ip"))
					app_server_ip = value;
				if(name.equals("hcare_setting_type_code"))
					hcare_setting_type_code = value;

				if(name.equals("category_code"))
					category_code = value;

				if(name.equals("language_id"))
					language_id = value;
				if(name.equals("fac_logo_name_flag"))
					fac_logo_name_flag = value;
				if(name.equals("fac_logo_file_name"))
					fac_logo_file_name = value;
				if(name.equals("display_site_name_yn"))
					{
		/*1*/			display_site_name = value;
					}

				} else {
					fileItem1	    = Item;
					docName1		= fileItem1.getName();
					docType1		= fileItem1.getContentType();
					docSize1		= fileItem1.getSize();
				}
			}
		}


		if (operation == null || operation.equals("null"))  operation = "";
		if (facility_id==null || facility_id.equals("null"))  facility_id = "";
		if (acc_entity_id==null || acc_entity_id.equals("null"))  acc_entity_id = "";
		if (res_area_code==null || res_area_code.equals("null"))  res_area_code = "";
		if (res_town_code==null  || res_town_code.equals("null"))  res_town_code = "";
		if (region_code==null || region_code.equals("null"))  region_code = "";
		if (head_of_facility_job_title == null || head_of_facility_job_title.equals("null"))  	head_of_facility_job_title = "";

		//Added by Ashwini on 28-Jun-2017 for AMS-CRF-0132
		if (gstin_facility==null || gstin_facility.equals("null"))  gstin_facility = "";
		
		//Added by mano aganist MMS--DM-CRF-0118.3
		if (vat_no==null || vat_no.equals("null"))  vat_no = "";

		if (facility_name==null || facility_name.equals("null"))  facility_name = "";
		if (site_id==null || site_id.equals("null"))  site_id = "";
		if (addr_line1==null || addr_line1.equals("null"))  addr_line1 = "";
		if (addr_line2==null || addr_line2.equals("null"))  addr_line2 = "";
		if (addr_line3==null || addr_line3.equals("null"))  addr_line3 = "";
		if (addr_line4==null || addr_line4.equals("null"))  addr_line4 = ""; 		

		if (addr_line1_loc_lang==null || addr_line1_loc_lang.equals("null"))  addr_line1_loc_lang = "";
		if (addr_line2_loc_lang==null || addr_line2_loc_lang.equals("null"))  addr_line2_loc_lang = "";
		if (addr_line3_loc_lang==null || addr_line3_loc_lang.equals("null"))  addr_line3_loc_lang = "";
		if (addr_line4_loc_lang==null || addr_line4_loc_lang.equals("null"))  addr_line4_loc_lang = "";	

		if (m_postal_code==null || m_postal_code.equals("null"))  m_postal_code = "";
		if (tel_no1==null || tel_no1.equals("null"))  tel_no1 = "";
		if (tel_no2==null || tel_no2.equals("null"))  tel_no2 = "";
		if (tel_no3==null || tel_no3.equals("null"))  tel_no3 = "";
		if (tel_no4==null || tel_no4.equals("null"))  tel_no4 = "";
		if (fax_no==null || fax_no.equals("null"))  fax_no = "";
		if (email_id==null || email_id.equals("null"))  email_id = "";
		//if (logo==null || logo.equals("null"))  logo = "";
		if (website_id==null || website_id.equals("null"))  website_id = "";
		if (head_of_facility_name==null || head_of_facility_name.equals("null"))  head_of_facility_name = "";
		if (license_no==null || license_no.equals("null"))  license_no = "";
		if (app_server_ip==null || app_server_ip.equals("null"))  app_server_ip = "";
		if (hcare_setting_type_code==null || hcare_setting_type_code.equals("null"))  hcare_setting_type_code = "";
		if (category_code==null || category_code.equals("null"))  category_code = "";
		if (language_id==null || language_id.equals("null"))  language_id = "";
		if (display_site_name==null || display_site_name.equals("null"))  display_site_name = "Y";
		if (docName1==null || docName1.equals("null"))  docName1 = "";
		if (fac_logo_name_flag==null || fac_logo_name_flag.equals("null"))  fac_logo_name_flag = "";
		if (fac_logo_file_name==null || fac_logo_file_name.equals("null"))  fac_logo_file_name = "";
		
		if ( operation.equals("insert") ) insertFacilityParam( req, res ) ;
		if ( operation.equals("modify") ) modifyFacilityParam( req, res ) ;

		}
		catch(Exception e)
		{
			out.println(e.toString());
			e.printStackTrace();
		}
	}

	private void insertFacilityParam(HttpServletRequest req, HttpServletResponse res)
	{	try
		{
			Timestamp  ts= new Timestamp(System.currentTimeMillis() );
            HashMap tabdata=new HashMap();
			tabdata.put("facility_id",facility_id);

			//Added by Ashwini on 28-Jun-2017 for AMS-CRF-0132
			tabdata.put("gstin_facility",gstin_facility);
			
			//Added by Mano aganist MMS--DM-CRF-0118.3
			tabdata.put("vat_no",vat_no);

			tabdata.put("facility_name",facility_name);
			tabdata.put("facility_type","F");
			tabdata.put("site_id",site_id);

			tabdata.put("addr_line1",addr_line1);
			tabdata.put("addr_line2",addr_line2);
			tabdata.put("addr_line3",addr_line3);
			tabdata.put("addr_line4",addr_line4);

			tabdata.put("addr_line1_loc_lang",addr_line1_loc_lang);
			tabdata.put("addr_line2_loc_lang",addr_line2_loc_lang);
			tabdata.put("addr_line3_loc_lang",addr_line3_loc_lang);
			tabdata.put("addr_line4_loc_lang",addr_line4_loc_lang); 

			tabdata.put("addr_postal_code",m_postal_code);

			tabdata.put("RES_AREA_CODE",res_area_code);
			tabdata.put("RES_TOWN_CODE", res_town_code);
			tabdata.put("REGION_CODE",region_code);

			tabdata.put("country_code",country_code);
			tabdata.put("tel_no1",tel_no1);
			tabdata.put("tel_no2",tel_no2);
			tabdata.put("tel_no3",tel_no3);
			tabdata.put("tel_no4",tel_no4);
			tabdata.put("fax_no",fax_no);
			tabdata.put("email_id",email_id);
			//tabdata.put("facility_logo",logo);
			tabdata.put("website_id",website_id);
			tabdata.put("head_of_facility_name",head_of_facility_name);
		    tabdata.put("head_of_facility_job_title",head_of_facility_job_title);
			tabdata.put("license_no",license_no);
			tabdata.put("app_server_ip",app_server_ip);

			tabdata.put("added_by_id",p.getProperty( "login_user" )==null ?"":p.getProperty( "login_user" ));
			tabdata.put("added_date",ts);
			tabdata.put("added_at_ws_no", p.getProperty("client_ip_address")==null ?"": p.getProperty("client_ip_address"));
			tabdata.put("modified_by_id", p.getProperty( "login_user" )==null ?"": p.getProperty( "login_user" ));
			tabdata.put("modified_date",ts);
		    tabdata.put("modified_at_ws_no",p.getProperty("client_ip_address")==null ?"": p.getProperty("client_ip_address"));
			tabdata.put("hcare_setting_type_code",hcare_setting_type_code);
			tabdata.put("facility_level_code",category_code);
			tabdata.put("language_id",language_id);
			tabdata.put("DISPLAY_SITE_NAME_YN",display_site_name);
			tabdata.put("WS_BY_IP_NAME ","N");
			if(fac_logo_name_flag.equals("Y")){
				tabdata.put("FACILITY_IMAGE_FILE_NAME",fac_logo_file_name);
			}
			tabdata.put("status","E");

			String dupflds[]={"facility_id"};

			boolean local_ejbs = false;

			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);

			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[4];

			String table_name="sm_facility_param";
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

			if (!acc_entity_id.equals("") && inserted)
			{	HashMap tabledata=new HashMap();
				tabledata.put("ACC_ENTITY_ID",acc_entity_id);
				tabledata.put("FACILITY_ID",facility_id);
				tabledata.put("ADDED_BY_ID",p.getProperty( "login_user" )== null ?"":p.getProperty( "login_user" ));
				tabledata.put("ADDED_DATE",ts);
			    tabledata.put("ADDED_AT_WS_NO",p.getProperty("client_ip_address")==null ?"": p.getProperty("client_ip_address"));
				tabledata.put("MODIFIED_BY_ID",p.getProperty( "login_user" )==null ?"": p.getProperty( "login_user" ));
				tabledata.put("MODIFIED_DATE",ts);
				tabledata.put("MODIFIED_AT_WS_NO",p.getProperty("client_ip_address")==null ?"": p.getProperty("client_ip_address"));

				String dupfields[]={"ACC_ENTITY_ID","FACILITY_ID"};
				Object argArray1[] = new Object[4];

				String table_name1="SM_ACC_ENTITY_PARAM_FACL";
				argArray1[0] = p;
				argArray1[1] = tabledata;
				argArray1[2] = dupfields;
				argArray1[3] = table_name1;

				Class [] paramArray1 = new Class[4];
				paramArray1[0] = p.getClass();
				paramArray1[1] = tabledata.getClass();
				paramArray1[2] = dupfields.getClass();
				paramArray1[3] = table_name1.getClass();

				java.util.HashMap result = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray1)).invoke(busObj,argArray1);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

				boolean saved = ( ((Boolean) result.get( "status" )).booleanValue() ) ;
				String error_one_value = "0" ;
				if ( saved ) error_one_value = "1" ;
				else error_one_value = "0" ;
				tabledata.clear();
				result.clear();

			res.sendRedirect("../../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_one_value );
			}

			if ( inserted )
			{
				if(docSize1>0)
				{

					try{

					String update_fac_param="update sm_facility_param set FACILITY_LOGO = empty_blob() WHERE FACILITY_ID = '"+facility_id+"'";
					pstmt = con.prepareStatement(update_fac_param);
					int updt_blob_result = pstmt.executeUpdate();
					if(updt_blob_result > 0){
					java.sql.Blob img_blob1 = null;
					java.io.OutputStream blobOutputStream1 = null;
					String update_cmp_logo = "select FACILITY_LOGO from sm_facility_param WHERE FACILITY_ID = '"+facility_id+"' for update";
					pstmtupdate=con.prepareStatement(update_cmp_logo);
					ResultSet rsupdt= pstmtupdate.executeQuery();

					while(rsupdt!=null && rsupdt.next()){

						img_blob1	=	(java.sql.Blob)rsupdt.getBlob(1);
						blobOutputStream1 = img_blob1.setBinaryStream(0);
						int docs1	 =	 (int)docSize1;
						blobOutputStream1.write(fileItem1.get(),0,docs1);
						blobOutputStream1.close();
					}
					if(rsupdt!=null) rsupdt.close();
					}

					if(pstmt!=null)	pstmt.close();
					if(pstmtupdate!=null)	pstmtupdate.close();

					}catch(Exception e){
						
						e.printStackTrace();
					}
					error_value = "1" ;
					error_value = error_value;

					con.commit();
				}
			}
			else
			{
				 error = (String) results.get("error") ;
			}

			error = (String) results.get("error") ;
			res.sendRedirect("../../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );

			if(con !=null)con.close();
			tabdata.clear();
			results.clear();

	}
catch ( Exception e )
	{
	out.println( "exception1="+e.getMessage() );
	e.printStackTrace();
	}
}

private void modifyFacilityParam(HttpServletRequest req, HttpServletResponse res)
{ try
	{

	Timestamp  ts= new Timestamp(System.currentTimeMillis() );
		HashMap tabdata=new HashMap();
		
		//Added by Ashwini on 28-Jun-2017 for AMS-CRF-0132
		tabdata.put("gstin_facility",gstin_facility);
		
		//Added by Mano aganist MMS--DM-CRF-0118.3
		tabdata.put("vat_no",vat_no);

		tabdata.put("facility_name",facility_name);
		tabdata.put("facility_type","F");

		tabdata.put("addr_line1",addr_line1);
		tabdata.put("addr_line2",addr_line2);
		tabdata.put("addr_line3",addr_line3);
		tabdata.put("addr_line4",addr_line4); 		

		tabdata.put("addr_line1_loc_lang",addr_line1_loc_lang);
		tabdata.put("addr_line2_loc_lang",addr_line2_loc_lang);
		tabdata.put("addr_line3_loc_lang",addr_line3_loc_lang);
		tabdata.put("addr_line4_loc_lang",addr_line4_loc_lang); 

		tabdata.put("addr_postal_code",m_postal_code);
		tabdata.put("country_code",country_code);

		tabdata.put("RES_AREA_CODE",res_area_code);
		tabdata.put("RES_TOWN_CODE",res_town_code);
		tabdata.put("REGION_CODE",region_code);

		tabdata.put("tel_no1",tel_no1);
		tabdata.put("tel_no2",tel_no2);
		tabdata.put("tel_no3",tel_no3);
		tabdata.put("tel_no4",tel_no4);
		tabdata.put("fax_no",fax_no);
		tabdata.put("email_id",email_id);
		//tabdata.put("facility_logo",logo);
		tabdata.put("website_id",website_id);
		tabdata.put("head_of_facility_name",head_of_facility_name);
		tabdata.put("head_of_facility_job_title",head_of_facility_job_title);
		tabdata.put("license_no",license_no);
		tabdata.put("app_server_ip",app_server_ip);

		if(fac_logo_name_flag.equals("Y")){
			tabdata.put("FACILITY_IMAGE_FILE_NAME",fac_logo_file_name);
		}

		tabdata.put("modified_by_id",p.getProperty( "login_user" )==null ?"": p.getProperty( "login_user" ));
		tabdata.put("modified_date",ts);
		tabdata.put("modified_at_ws_no",p.getProperty("client_ip_address")==null ?"": p.getProperty("client_ip_address"));
		tabdata.put("hcare_setting_type_code",hcare_setting_type_code);
		tabdata.put("facility_level_code",category_code);
		tabdata.put("language_id",language_id);
		tabdata.put("DISPLAY_SITE_NAME_YN",display_site_name);
		tabdata.put("WS_BY_IP_NAME ","N");		

		HashMap condflds=new HashMap();
		condflds.put("facility_id",facility_id);
		boolean local_ejbs = false;
		if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		Object argArray[] = new Object[4];
		String table_name="sm_facility_param";
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
			tabdata.clear();
			results.clear();
			condflds.clear();
			int rec_count = 0;
		try
		  {
			pstmt1 = con.prepareStatement("SELECT count(*) FROM SM_ACC_ENTITY_PARAM_FACL WHERE FACILITY_ID = '"+facility_id+"' ");
			rs1 = pstmt1.executeQuery();
			if(rs1.next()) rec_count = rs1.getInt(1);
			if(rec_count == 0 && !acc_entity_id.equals("") && acc_entity_id!="" )
				{HashMap tabledata=new HashMap();
				tabledata.put("ACC_ENTITY_ID",acc_entity_id);
				tabledata.put("FACILITY_ID",facility_id);
				tabledata.put("ADDED_BY_ID",p.getProperty( "login_user" )== null ?"":p.getProperty( "login_user" ));
					tabledata.put("ADDED_DATE",ts);
				     tabledata.put("ADDED_AT_WS_NO",p.getProperty("client_ip_address")==null ?"": p.getProperty("client_ip_address"));
					tabledata.put("MODIFIED_BY_ID",p.getProperty( "login_user" )==null ?"": p.getProperty( "login_user" ));
					tabledata.put("MODIFIED_DATE",ts);
				    tabledata.put("MODIFIED_AT_WS_NO",p.getProperty("client_ip_address")==null ?"": p.getProperty("client_ip_address"));
					String dupfields[]={"ACC_ENTITY_ID","FACILITY_ID"};
					Object argArray1[] = new Object[4];
					String table_name1="SM_ACC_ENTITY_PARAM_FACL";
					argArray1[0] = p;
					argArray1[1] = tabledata;
					argArray1[2] = dupfields;
					argArray1[3] = table_name1;
					Class [] paramArray1 = new Class[4];
					paramArray1[0] = p.getClass();
					paramArray1[1] = tabledata.getClass();
					paramArray1[2] = dupfields.getClass();
					paramArray1[3] = table_name1.getClass();
					java.util.HashMap result = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray1)).invoke(busObj,argArray1);
				   (busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
					boolean saved = ( ((Boolean) result.get( "status" )).booleanValue() ) ;
					String error_one_value = "0" ;
					if ( saved ) error_one_value = "1" ;
					else error_one_value = "0" ;
				    res.sendRedirect("../../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_one_value );
                    tabledata.clear();
					result.clear();
				}
			else if(rec_count > 0 && !acc_entity_id.equals(""))
				{HashMap tabledata=new HashMap();
				tabledata.put("ACC_ENTITY_ID",acc_entity_id);
				tabledata.put("MODIFIED_BY_ID",p.getProperty( "login_user" )==null ?"": p.getProperty( "login_user" ));
				tabledata.put("MODIFIED_DATE",ts);
			    tabledata.put("MODIFIED_AT_WS_NO",p.getProperty("client_ip_address")==null ?"": p.getProperty("client_ip_address"));
				tabledata.put("FACILITY_ID",facility_id);
				String dupfields[]={"ACC_ENTITY_ID","FACILITY_ID"};
				Object argArray1[] = new Object[4];
				String table_name1="SM_ACC_ENTITY_PARAM_FACL";
				argArray1[0] = p;
				argArray1[1] = tabledata;
				argArray1[2] = dupfields;
				argArray1[3] = table_name1;
				Class [] paramArray1 = new Class[4];
				paramArray1[0] = p.getClass();
				paramArray1[1] = tabledata.getClass();
				paramArray1[2] = dupfields.getClass();
				paramArray1[3] = table_name1.getClass();
				java.util.HashMap result = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray1)).invoke(busObj,argArray1);
     		   (busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
				boolean saved = ( ((Boolean) result.get( "status" )).booleanValue() ) ;
					String error_one_value = "0" ;
					if ( saved ) error_one_value = "1" ;
					else error_one_value = "0" ;
			  res.sendRedirect("../../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_one_value );
				tabledata.clear();
					result.clear();
				}
				else if(rec_count > 0 && acc_entity_id.equals(""))
				{	HashMap tabledata=new HashMap();
					tabledata.put("FACILITY_ID",facility_id);
					tabledata.clear();
				}if(rs1 != null) rs1.close();
				if(pstmt1 != null) pstmt1.close();
		  }
		  catch(Exception e)
		  {
				out.println("exception 2="+e.toString());
				e.printStackTrace();
		  }
		finally
		{//if( con !=null)ConnectionManager.returnConnection(con,req);
		}

		if ( inserted )
		{
			if(docSize1>0)
			{
				try{

				String update_facility_param="update sm_facility_param set FACILITY_LOGO = empty_blob() WHERE FACILITY_ID = '"+facility_id+"'";
				pstmt = con.prepareStatement(update_facility_param);

				int updt_blob_result = pstmt.executeUpdate();

				if(updt_blob_result > 0){
				java.sql.Blob img_blob1 = null;
				java.io.OutputStream blobOutputStream1 = null;
				String update_cmp_logo = "select FACILITY_LOGO from sm_facility_param WHERE FACILITY_ID = '"+facility_id+"' for update";
				pstmtupdate=con.prepareStatement(update_cmp_logo);
				ResultSet rsupdt= pstmtupdate.executeQuery();

				while(rsupdt!=null && rsupdt.next()){
					img_blob1	=	(java.sql.Blob)rsupdt.getBlob(1);
					blobOutputStream1 = img_blob1.setBinaryStream(0);
					int docs1	 =	 (int)docSize1;
					blobOutputStream1.write(fileItem1.get(),0,docs1);
					blobOutputStream1.close();
				}
				if(rsupdt!=null) rsupdt.close();
				}

				if(pstmt!=null)	pstmt.close();
				if(pstmtupdate!=null)	pstmtupdate.close();

				}catch(Exception e){
					
					e.printStackTrace();
				}
				 error_value = "1" ;
				 error_value = error_value;

				 con.commit();
			}
		}
		else
		{
			 error = (String) results.get("error") ;
		}
			error = (String) results.get("error") ;
			res.sendRedirect("../../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
			if(con !=null)con.close();
		}
		catch ( Exception e )
		{out.println( "exception 3="+e.getMessage() ); e.printStackTrace();	}
		finally
		{if( con != null ) ConnectionManager.returnConnection(con,req);}
	}
}
