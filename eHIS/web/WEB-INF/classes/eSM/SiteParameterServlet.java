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
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.text.*;
import javax.servlet.http.HttpUtils.*;
import webbeans.eCommon.*;
import org.apache.commons.fileupload.*;
import java.net.*;

import eCommon.SingleTabHandler.*;

public class SiteParameterServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel
{
	PrintWriter out;
	
	java.util.Properties p;

	String siteId;
	String siteName ;
	String gstinSite ; //Added by Ashwini on 28-Jun-2017 for AMS-CRF-0132
	String wkstationidentify = "";
	String changewsidatfacy="";
	Connection conn=null;

	String facilityId ;
	HttpSession session;

	boolean isMultipart				= false;	
	DiskFileUpload upload			= null;
	FileItem Item					= null;
	FileItem  fileItem1=null,fileItem2=null;
	long	paramsize				= 0;
	long	docSize1					= 0;
	long	docSize2					= 0;
	int		file_limit				= 0;
	int it_cnt=0;
	List items						= null;
	Iterator iter					= null;	
	java.io.InputStream instream	= null;
	String docName1					= "";
	String docName2					= "";
	String docType1					= "";
	String docType2					= "";
	String site_id =null; 
	String site_name =null;
	String gstin_site =null; //Added by Ashwini on 28-Jun-2017 for AMS-CRF-0132
	String function =null;
	String eff_date_from =null;
	String eff_date_to =null;
	String function_name =null;
	String addr_line1_prompt =null;
    String ADDR_LINE1_APPL_YN =null;
	String addr_line1_order =null;
	String addr_line2_prompt =null;
    String ADDR_LINE2_APPL_YN =null;
	String addr_line2_order =null;
	String addr_line3_prompt =null;
	String ADDR_LINE3_APPL_YN =null;
	String addr_line3_order =null;
	String addr_line4_prompt =null;
	String ADDR_LINE4_APPL_YN =null;
	String addr_line4_order =null;
	String res_town_prompt =null;
	String RES_TOWN_APPL_YN =null;
	String res_town_order =null;
	String res_area_prompt =null;
	String RES_AREA_APPL_YN =null;
	String res_area_order =null;
	String REGION_PROMPT =null;
    String REGION_APPL_YN =null;
	String REGION_ORDER =null;
	String postal_code_prompt =null;
	String POSTAL_CODE_APPL_YN =null;
	String postal_code_order =null;
	String eff_date_from1 =null;
	String eff_date_to1 =null;
	PreparedStatement pstmt=null;
	PreparedStatement pstmtupdate=null;
	ResultSet rsupdt=null;
	String NATID_MAND_PRACT_OTHSTAFF_YN=null;//Added by Suji Keerthi for MOHE-CRF-0011 on 21-Apr-2020
	String ENFORCE_PASSWORD_POLICY_YN=null;//Maheshwaran added for the MMS-QH-CRF-0149
	String FIRST_LOGIN_CHANGE_PASSWORD_YN=null;//Added by Maheshwaran for AMs-CRF-0098
	String CHANGE_PASSWORD_MANDATORY_YN=null;//Added by Maheshwaran for AMs-CRF-0098

//	15/04/2009
	
	String  POSTAL_CODE_LINK_YN;
	String  DISPLAY_USER_NAME_YN;
	String MULTIPLE_LOGIN_ALLOWED_YN;
	String UNLOCK_USER_SESSION_HRS;
    String SPL_NUR_UNIT_TO_ENABLE_YN="N";//Added by Shanmukh on 7th-AUG-2018 for ML-MMOH-CRF-1115

	//Added by kamatchi S for ML-BRU-CRF-0594
	String dis_user_val ="";

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	} 

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		ADDR_LINE1_APPL_YN="N";
		ADDR_LINE2_APPL_YN="N";
		ADDR_LINE3_APPL_YN="N";
		ADDR_LINE4_APPL_YN="N";
		RES_TOWN_APPL_YN="N";
		RES_AREA_APPL_YN="N";
		REGION_APPL_YN="N";
		POSTAL_CODE_APPL_YN="N";

	

		POSTAL_CODE_LINK_YN=req.getParameter("postal_code_link_yn");
		POSTAL_CODE_LINK_YN 		= (POSTAL_CODE_LINK_YN == null)?"N":POSTAL_CODE_LINK_YN;

		
		MULTIPLE_LOGIN_ALLOWED_YN=req.getParameter("multiple_login_allowed_yn");
		MULTIPLE_LOGIN_ALLOWED_YN 		= (MULTIPLE_LOGIN_ALLOWED_YN == null)?"N":MULTIPLE_LOGIN_ALLOWED_YN;
		
		
		SPL_NUR_UNIT_TO_ENABLE_YN= (req.getParameter("SPL_NUR_UNIT_TO_ENABLE_YN") == null)?"N":req.getParameter("SPL_NUR_UNIT_TO_ENABLE_YN");

		//Added by kamatchi S for ML-BRU-CRF-0594
		dis_user_val= (req.getParameter("dis_user_val") == null)?"":req.getParameter("dis_user_val");
		
		UNLOCK_USER_SESSION_HRS=req.getParameter("unlock_user_session_hrs");
		UNLOCK_USER_SESSION_HRS 		= (UNLOCK_USER_SESSION_HRS == null)?"":UNLOCK_USER_SESSION_HRS;

		DISPLAY_USER_NAME_YN=req.getParameter("display_user_name_yn");
		DISPLAY_USER_NAME_YN= (DISPLAY_USER_NAME_YN == null)?"N":DISPLAY_USER_NAME_YN;
		//Added by Suji Keerthi for MOHE-CRF-0011 on 21-Apr-2020
		NATID_MAND_PRACT_OTHSTAFF_YN=req.getParameter("NATID_MAND_PRACT_OTHSTAFF_YN");
		NATID_MAND_PRACT_OTHSTAFF_YN= (NATID_MAND_PRACT_OTHSTAFF_YN == null)?"N":NATID_MAND_PRACT_OTHSTAFF_YN;
		//Ended for MOHE-CRF-0011
		//Maheshwaran added for the MMS-QH-CRF-0149
		ENFORCE_PASSWORD_POLICY_YN=req.getParameter("ENFORCE_PASSWORD_POLICY_YN");
		ENFORCE_PASSWORD_POLICY_YN= (ENFORCE_PASSWORD_POLICY_YN == null)?"N":ENFORCE_PASSWORD_POLICY_YN;
		
		FIRST_LOGIN_CHANGE_PASSWORD_YN=req.getParameter("FIRST_LOGIN_CHANGE_PASSWORD_YN");//Added by Maheshwaran for AMs-CRF-0098
		FIRST_LOGIN_CHANGE_PASSWORD_YN= (FIRST_LOGIN_CHANGE_PASSWORD_YN == null)?"N":FIRST_LOGIN_CHANGE_PASSWORD_YN;//Added by Maheshwaran for AMs-CRF-0098
		
		CHANGE_PASSWORD_MANDATORY_YN=req.getParameter("CHANGE_PASSWORD_MANDATORY_YN");//Added by Maheshwaran for AMs-CRF-0098
		CHANGE_PASSWORD_MANDATORY_YN= (CHANGE_PASSWORD_MANDATORY_YN == null)?"N":CHANGE_PASSWORD_MANDATORY_YN;//Added by Maheshwaran for AMs-CRF-0098


		req.setCharacterEncoding("UTF-8");
        res.setContentType("text/html;charset=UTF-8");	
		session = req.getSession(false);
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.facilityId = (String) session.getValue( "facility_id" ) ;
		if(facilityId==null) facilityId="";

		docSize1					= 0;   
		docSize2					= 0;
		docName1					= ""; 
		docName2					= ""; 
		docType1					= ""; 
		docType2					= "";
		fileItem1=null;
		fileItem2=null;
		it_cnt=0;


		try
		{
			this.out = res.getWriter();
			out.println("<script src='../eCommon/js/common.js' language='javascript'></script>");
			isMultipart			= FileUpload.isMultipartContent(req);
			conn = ConnectionManager.getConnection();
			if(isMultipart){
			upload			= new DiskFileUpload();
			items			= upload.parseRequest(req);
			iter			= items.iterator();
			String name		= "";
			String value	= "";
			while(iter.hasNext()){
				Item = (FileItem)iter.next();
				if(Item.isFormField()){
				name		= Item.getFieldName();
				value		= Item.getString();

 				if(name.equals("function")) function=value;
				if(name.equals("site_id"))	site_id=value;
				if(name.equals("site_name")) site_name=value;

				//Added by Ashwini on 28-Jun-2017 for AMS-CRF-0132
				if(name.equals("gstin_site")) gstin_site=value; 

				if(name.equals("eff_date_from")) eff_date_from=value;
				if(name.equals("eff_date_to")) eff_date_to=value;
				if(name.equals("function_name")) function_name=value;

				if(name.equals("addr_line1_prompt")) addr_line1_prompt=value;
				if(name.equals("ADDR_LINE1_APPL_YN"))ADDR_LINE1_APPL_YN=value;
				if(name.equals("addr_line1_order")) addr_line1_order=value;
				                
				if(name.equals("addr_line2_prompt")) addr_line2_prompt=value;
				if(name.equals("ADDR_LINE2_APPL_YN")) ADDR_LINE2_APPL_YN=value;
				if(name.equals("addr_line2_order")) addr_line2_order=value;
				
				if(name.equals("addr_line3_prompt")) addr_line3_prompt=value;
				if(name.equals("ADDR_LINE3_APPL_YN")) ADDR_LINE3_APPL_YN=value;
				if(name.equals("addr_line3_order")) addr_line3_order=value;
				
				if(name.equals("addr_line4_prompt")) addr_line4_prompt=value;
				if(name.equals("ADDR_LINE4_APPL_YN")) ADDR_LINE4_APPL_YN=value;
				if(name.equals("addr_line4_order")) addr_line4_order=value;
				
				if(name.equals("res_town_prompt")) res_town_prompt=value;
				if(name.equals("RES_TOWN_APPL_YN")) RES_TOWN_APPL_YN=value;
				if(name.equals("res_town_order")) res_town_order=value;
				
				if(name.equals("res_area_prompt")) res_area_prompt=value;
				if(name.equals("RES_AREA_APPL_YN")) RES_AREA_APPL_YN=value;
				if(name.equals("res_area_order")) res_area_order=value;
				
				if(name.equals("REGION_PROMPT")) REGION_PROMPT=value;
				if(name.equals("REGION_APPL_YN")) REGION_APPL_YN=value;
				if(name.equals("REGION_ORDER")) REGION_ORDER=value;
				
				if(name.equals("postal_code_prompt")) postal_code_prompt=value;
				if(name.equals("POSTAL_CODE_APPL_YN")) POSTAL_CODE_APPL_YN=value;
				if(name.equals("postal_code_order")) postal_code_order=value;
				
				if(name.equals("eff_date_from1")) eff_date_from1=value;
				if(name.equals("eff_date_to1")) eff_date_to1=value;	


				//15-04-09
				if(name.equals("postal_code_link_yn")) POSTAL_CODE_LINK_YN=value;
				if(name.equals("display_user_name_yn")) DISPLAY_USER_NAME_YN=value;
				if(name.equals("multiple_login_allowed_yn")) MULTIPLE_LOGIN_ALLOWED_YN=value;
				if(name.equals("unlock_user_session_hrs")) UNLOCK_USER_SESSION_HRS=value;
				if(name.equals("natid_mand_pract_othstaff_yn")) NATID_MAND_PRACT_OTHSTAFF_YN=value;//Added by Suji Keerthi for MOHE-CRF-0011 on 21-Apr-2020
				if(name.equals("enforce_password_policy_yn")) ENFORCE_PASSWORD_POLICY_YN=value;//Maheshwaran added for the MMS-QH-CRF-0149
				if(name.equals("first_login_change_password_yn")) FIRST_LOGIN_CHANGE_PASSWORD_YN=value;//Added by Maheshwaran for AMs-CRF-0098
				if(name.equals("change_password_mandatory_yn")) CHANGE_PASSWORD_MANDATORY_YN=value;		//Added by Maheshwaran for AMs-CRF-0098		
				if(name.equals("SPL_NUR_UNIT_TO_ENABLE_YN")) SPL_NUR_UNIT_TO_ENABLE_YN=value;//Added by Shanmukh on 7th-AUG-2018 for ML-MMOH-CRF-1115
				if(name.equals("dis_user_val")) dis_user_val=value;//Added by kamatchi S for ML-BRU-CRF-0594
				}else{
				fileItem1	= Item;
				docName1		= Item.getName();
				docType1		= Item.getContentType();
				docSize1		= Item.getSize();
				if(docType1 == null)
					docType1 = "999";
				it_cnt++;
				}
			}
			}else{
				//if not multipart
			}
			String operation = function;
			if ( operation.equals("modify"))		modifySiteParameter(req);
		}
		catch(Exception e)
		{
			out.println(e.toString()); 
			e.printStackTrace();
		}
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res)
 	throws javax.servlet.ServletException,IOException
	{
	try	{
	this.out = res.getWriter();
	out.println("<script src='../eCommon/js/common.js' language='javascript'></script>");
	String url = "../eCommon/jsp/MstCodeToolbar.jsp?" ;
	String params = req.getQueryString() ;
	String source = url + params ;
	out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link><script src='../eCommon/js/common.js' language='javascript'></script><script language='javascript' src='../eSM/js/SiteParameter.js'></script></head><frameset rows='42,*,50'><frame name='commontoolbarFrame'	src='" + source + "' frameborder=0 scrolling='no' noresize><frame name='f_query_add_mod' src='../eSM/jsp/SiteParameterModify.jsp' frameborder=0 scrolling='auto' ><frame name='messageFrame'	src='../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto'></frameset></html>");
	}
	catch(Exception e)	{
		e.printStackTrace();
	}
	}


private void modifySiteParameter(HttpServletRequest req)
{
	try
		{
			siteId=site_id;
			//int size				= (int)docSize2;
			int updt_blob_result	=0;
			if(siteId == null || siteId.equals("")) siteId = "Null val error"; 

			siteName = site_name;
			if(siteName == null || siteName.equals("")) siteName = "Null val error"; 
			
			//Added by Ashwini on 28-Jun-2017 for AMS-CRF-0132
			gstinSite = gstin_site;
			if(gstinSite == null || gstinSite.equals("")) gstinSite = "";

			wkstationidentify =  req.getParameter("ws_by_ip_name_NAME");
			{
			if(wkstationidentify == null ) wkstationidentify = "N"; 
			if(wkstationidentify.equals("IP Address") ) wkstationidentify = "I"; 
			if(wkstationidentify.equals("Machine Name") ) wkstationidentify = "N"; 
			}
			
			changewsidatfacy =  req.getParameter("change_wsid_at_facility");
			if(changewsidatfacy == null || changewsidatfacy.equals("")) changewsidatfacy = "N"; 
			
			

		

			Timestamp  ts= new Timestamp(System.currentTimeMillis() );

			HashMap tabdata=new HashMap();
			tabdata.put("site_name",siteName);
			tabdata.put("gstin_site",gstinSite); //Added by Ashwini on 28-Jun-2017 for AMS-CRF-0132

			tabdata.put("modified_by_id",p.getProperty( "login_user" )== null ?"":p.getProperty( "login_user" ));
			tabdata.put("modified_date",ts);
			tabdata.put("modified_at_ws_no",p.getProperty("client_ip_address")== null ?"":p.getProperty("client_ip_address"));
			
			tabdata.put("addr_line1_prompt", addr_line1_prompt);
			tabdata.put("addr_line1_order",addr_line1_order);
			tabdata.put("ADDR_LINE1_APPL_YN",ADDR_LINE1_APPL_YN);

			tabdata.put("addr_line2_prompt",addr_line2_prompt);
			tabdata.put("addr_line2_order",addr_line2_order);
			tabdata.put("ADDR_LINE2_APPL_YN",ADDR_LINE2_APPL_YN);
			
			tabdata.put("addr_line3_prompt",addr_line3_prompt);
			tabdata.put("addr_line3_order",addr_line3_order);
			tabdata.put("ADDR_LINE3_APPL_YN",ADDR_LINE3_APPL_YN);

			tabdata.put("addr_line4_prompt",addr_line4_prompt);
			tabdata.put("addr_line4_order",addr_line4_order);
			tabdata.put("ADDR_LINE4_APPL_YN",ADDR_LINE4_APPL_YN);

			tabdata.put("res_area_prompt",res_area_prompt);
			tabdata.put("res_area_order", res_area_order);
			tabdata.put("RES_AREA_APPL_YN",RES_AREA_APPL_YN);
			
			tabdata.put("res_town_prompt",res_town_prompt);
			tabdata.put("res_town_order",res_town_order);
			tabdata.put("RES_TOWN_APPL_YN",RES_TOWN_APPL_YN);
			
			/**********************************************/
			tabdata.put("REGION_PROMPT",REGION_PROMPT);
			tabdata.put("REGION_ORDER",REGION_ORDER);
			tabdata.put("REGION_APPL_YN",REGION_APPL_YN);
			/*************************************************/
			  
			tabdata.put("postal_code_prompt",postal_code_prompt);
			tabdata.put("postal_code_order", postal_code_order);
			tabdata.put("POSTAL_CODE_APPL_YN",POSTAL_CODE_APPL_YN);
			
			tabdata.put("WS_BY_IP_NAME",wkstationidentify);
			tabdata.put("Change_ws_at_fcy_yn",changewsidatfacy);
	
		//15-04-2009

			tabdata.put("POSTAL_CODE_LINK_YN",POSTAL_CODE_LINK_YN);
			tabdata.put("MULTIPLE_LOGIN_ALLOWED_YN",MULTIPLE_LOGIN_ALLOWED_YN);
			tabdata.put("UNLOCK_USER_SESSION_HRS",UNLOCK_USER_SESSION_HRS);
			tabdata.put("DISPLAY_USER_NAME_YN",DISPLAY_USER_NAME_YN);
			tabdata.put("NATID_MAND_PRACT_OTHSTAFF_YN",NATID_MAND_PRACT_OTHSTAFF_YN);//Added by Suji Keerthi for MOHE-CRF-0011 on 21-Apr-2020
			tabdata.put("ENFORCE_PASSWORD_POLICY_YN",ENFORCE_PASSWORD_POLICY_YN);//Maheshwaran k Added for MMS-QH-CRF-0149
			tabdata.put("FIRST_LOGIN_CHANGE_PASSWORD_YN",FIRST_LOGIN_CHANGE_PASSWORD_YN);//Added by Maheshwaran for AMs-CRF-0098
			tabdata.put("CHANGE_PASSWORD_MANDATORY_YN",CHANGE_PASSWORD_MANDATORY_YN);//Added by Maheshwaran for AMs-CRF-0098
			tabdata.put("SPL_NUR_UNIT_TO_ENABLE_YN",SPL_NUR_UNIT_TO_ENABLE_YN);//Added by Shanmukh on 7th-AUG-2018 for ML-MMOH-CRF-1115
			tabdata.put("DIS_USER_VAL",dis_user_val);//Added by Kamatchi S for ML-BRU-CRF-0594




			HashMap condflds=new HashMap();
			condflds.put("site_id",siteId);

			boolean local_ejbs = false;
		
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			
			Object argArray[] = new Object[4];
			String table_name="sm_site_param";
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
			String error_value ;

			if ( inserted && !docName1.equals(""))
			{
				try{
				StringBuffer image_sql=new StringBuffer("update SM_SITE_PARAM set");
				StringBuffer insert_image_sql=new StringBuffer("select ");
				image_sql=image_sql.append(" SITE_LOGO_LOGIN_SCREEN=empty_blob()");
				insert_image_sql=insert_image_sql.append(" SITE_LOGO_LOGIN_SCREEN");
				insert_image_sql=insert_image_sql.append(" from SM_SITE_PARAM for update");
				pstmt=conn.prepareStatement(image_sql.toString());
				updt_blob_result = pstmt.executeUpdate();
				if(updt_blob_result > 0){
				java.sql.Blob img_blob1 = null;
				java.io.OutputStream blobOutputStream1 = null;
				pstmtupdate=conn.prepareStatement(insert_image_sql.toString());
				rsupdt= pstmtupdate.executeQuery();
				while(rsupdt!=null && rsupdt.next()){

							img_blob1			=	(java.sql.Blob)rsupdt.getBlob(1);
							blobOutputStream1	=	img_blob1.setBinaryStream(0);
							int docs1			=	(int)docSize1;
							blobOutputStream1.write(fileItem1.get(),0,docs1);
							blobOutputStream1.close();

				}
				}
				if (rsupdt != null) rsupdt.close();
	            if (pstmtupdate != null) pstmtupdate.close();

				}catch(Exception e){
					
					e.printStackTrace();
				}
				 error_value = "1" ;
				 error_value = error_value;
			}
			else
			{
				 error = (String) results.get("error") ;
			}

        	 error = (String) results.get("error") ;

	        if (pstmt != null) pstmt.close();

			out.println("<script>location.href =\"../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode( error, "UTF-8" ) +"\"</script>");
			conn.commit();
			//if(conn !=null)conn.close();
            tabdata.clear();
			condflds.clear();
			results.clear();

		}
		catch ( Exception e )
		{
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ;
			out.println("*sitID= "+ siteId+" *site=  "+siteName+" *WS= "+wkstationidentify+" *wsYN=  "+changewsidatfacy  );
			e.printStackTrace();
		}
		finally
		{
			ConnectionManager.returnConnection(conn,req);
		}

	}
}
