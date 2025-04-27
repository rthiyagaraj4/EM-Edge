/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/****** Created Date Time 09/02/2006 10:08 AM 

 * @filename OrganizationServlet.java
 *
 * @version 3.0 modified on 23/02/2006
 *	
 *****/
 /*
	Developed By       :	Shyam Prasad.P
	Created on   	   :	09/02/2006
	Function		   :	Oraganization
*/
package eMP;

import javax.servlet.ServletException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;
import webbeans.eCommon.*;

import java.io.PrintWriter;
import java.io.IOException;

import java.util.HashMap;
import java.util.Properties;

import com.ehis.eslp.ServiceLocator;

import eCommon.SingleTabHandler.SingleTabHandlerManagerHome;

import eCommon.XSSRequestWrapper;//Added by Kamatchi S for security issue against COMMON-ICN-0187

/*** @todo Class data members should be moved to method level scope ***/
public class OrganizationServlet extends HttpServlet{
	PrintWriter out;
	Properties p;
	String patientcategoryCode;
	String longDesc ;
	String shortDesc ;
	String jobType;
	String effectiveDateFrom ;
	String effectiveDateTo ;
	String effectiveStatus ;
	String facilityId ;
	String client_ip_address ;
	String organization_id="";
	String organization_name="";
	String mode="";
	String mode_sub="";
	String sStyle = "";
	ResultSet rs = null;
	Connection con = null;
	PreparedStatement pstmt			= null;
	
	/**
	 * @todo Synchronization can be removed once variables are moved to method level
	 */
	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res)
												    throws ServletException,IOException{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		//Added by Kamatchi S for security issue against COMMON-ICN-0187
		req = new XSSRequestWrapper(req);
		res.addHeader("X-XSS-Protection", "1; mode=block");
		res.addHeader("X-Content-Type-Options", "nosniff");
		//Added by Kamatchi S for security issue against COMMON-ICN-0187 END
		HttpSession session = req.getSession(false);
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.facilityId = (String) session.getValue( "facility_id" ) ;
		client_ip_address = p.getProperty("client_ip_address");

		try {
			session = req.getSession(false);

		sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
			this.out = res.getWriter();
			String operation = req.getParameter("function");
			mode="";
			mode_sub="";
			mode=req.getParameter("mode");
			mode_sub=req.getParameter("mode_sub");
			String outPut1 = "<html><link rel='stylesheet' type='text/css' href='../eCommon/html/"+sStyle+"'></link><head><script Language='JavaScript' src='../eMP/js/Organization.js'></script></script></head><BODY CLASS='MESSAGE'>";
		    String outPut2 = "</BODY></html>";
		    out.println(outPut1);
			con	= ConnectionManager.getConnection(req);
			if (operation.equals("Organization_main")) //Control goes to this block if its coming from Organisation function
			{
				if(mode.equals("insert"))
                insertOrganization(req, res);
				else
                updateOrganization(req, res);  
			}
			else if(operation.equals("Organization_sub"))//Control goes to this block if its coming from Organisation sub Details function
			{
				if(mode_sub.equals("insert"))
				insertOrganization_sub(req,res);
				else
                updateOrganization_sub(req,res);
			}
			out.println(outPut2);
			
		}catch (Exception e)	{
			//out.println(e.toString());
			e.printStackTrace();
		}
		finally
        {
            if( con != null ) ConnectionManager.returnConnection(con,req);
        }
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException {
		try	{
			
		} catch(Exception e)	{	
			e.printStackTrace();
		}
	}
    
	private void updateOrganization(HttpServletRequest req, HttpServletResponse res)	{
	try {
			organization_name = req.getParameter("org_name");
			organization_id = req.getParameter("org_id");
			effectiveStatus = req.getParameter("eff_status");
			if ( effectiveStatus == null )
					effectiveStatus="D";
			String addedById = p.getProperty( "login_user" ) ;
			String modifiedById = addedById ;
			String modifiedFacilityId = facilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;

			HashMap tabdata=new HashMap();
			tabdata.put("FAMILY_ORG_NAME",organization_name);
			tabdata.put("eff_status",effectiveStatus);
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );

			HashMap condflds=new HashMap();
			condflds.put("FAMILY_ORG_ID",organization_id);

			boolean local_ejbs = isLocalEJB();
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = condflds;
			argArray[3] = "MP_FAMILY_ORG";

			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass(); ;
			paramArray[1] = tabdata.getClass();
			paramArray[2] = condflds.getClass();
			paramArray[3] = String.class;
			
			java.util.HashMap results = (HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			
			argArray = null;
			paramArray = null;
			tabdata.clear();
			
			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;			

			String error = (String) results.get("error") ;
			String error_value = "0" ;
			condflds.clear();
			results.clear();
			if ( inserted ) error_value = "1" ;
			//newly added
			
			
			 if(inserted)
			{
			
			   
			   String sql="";
			   if(effectiveStatus.equals("D")){
			   sql="update MP_FAMILY_ORG_SUB set EFF_STATUS='D' where FAMILY_ORG_ID='"+organization_id+"'";
			   }
			   else if(effectiveStatus.equals("E")){
                 sql="update MP_FAMILY_ORG_SUB set EFF_STATUS='E' where FAMILY_ORG_ID='"+organization_id+"'";

			   }
				pstmt = con.prepareStatement(sql);
				 pstmt.executeUpdate();
			
				con.commit();
			
				out.println("<script>parent.f_query_add_mod.chkorgupdate_success('servlet');</script>");
			}
			else{
              
			out.println("<script>parent.f_query_add_mod.chkorgupdate_error('servlet');</script>");
			}
			out.println("<script>parent.messageFrame.location.href='../eCommon/jsp/MstCodeError.jsp?err_num="+error+"&err_value=" + error_value+"'</script>");
			//
				//res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8") + "&err_value=" + error_value ); 
		 if(pstmt!=null)pstmt.close();
		} catch ( Exception e ) {
				/*out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
				out.println( "Values sent are : <br>" ) ;
				out.println( patientcategoryCode + " "+longDesc + " "+shortDesc +" "+ effectiveDateFrom+" "+ effectiveDateTo + " "+ effectiveStatus ); */
				e.printStackTrace();
			}
	}
	/*Insert function for Organaization SubDetails
	*/
	private void insertOrganization_sub(HttpServletRequest request, HttpServletResponse res)	{
		try {
			
			
			String addedById = p.getProperty( "login_user" ) ;
			String modifiedById = addedById ;
			String addedFacilityId=facilityId;
			String modifiedFacilityId = facilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;
            String eff_status="E";
			HashMap tabdata=new HashMap();
							
            tabdata.put("FAMILY_ORG_SUB_ID", (request.getParameter("subunit_id")==null?"":request.getParameter("subunit_id"))) ;
            tabdata.put("FAMILY_ORG_ID", (request.getParameter("org_id_hd")==null?"":request.getParameter("org_id_hd"))) ;
            tabdata.put("FAMILY_ORG_SUB_NAME", (request.getParameter("subunit_desc")==null?"":request.getParameter("subunit_desc"))) ;
            tabdata.put("ORG_CONTACT_NAME", (request.getParameter("subunit_contactname")==null?"":request.getParameter("subunit_contactname"))) ;
			tabdata.put("RES_TEL_NO", (request.getParameter("hphone_no")==null?"":request.getParameter("hphone_no"))) ;
            tabdata.put("OFF_TEL_NO", (request.getParameter("ophone_no")==null?"":request.getParameter("ophone_no"))) ;
			tabdata.put("ORG_ADDR_LINE_1", (request.getParameter("r_addr_line1")==null?"":request.getParameter("r_addr_line1"))) ;
            tabdata.put("ORG_ADDR_LINE_2", (request.getParameter("r_addr_line2")==null?"":request.getParameter("r_addr_line2"))) ;
            tabdata.put("ORG_ADDR_LINE_3", (request.getParameter("r_addr_line3")==null?"":request.getParameter("r_addr_line3"))) ;
            tabdata.put("ORG_ADDR_LINE_4", (request.getParameter("r_addr_line4")==null?"":request.getParameter("r_addr_line4"))) ;
			tabdata.put("POSTAL_CODE", (request.getParameter("r_postal_code")==null?"":request.getParameter("r_postal_code"))) ;
            tabdata.put("COUNTRY_CODE", (request.getParameter("next_country_code")==null?"":request.getParameter("next_country_code"))) ;
            tabdata.put("RES_AREA_CODE", (request.getParameter("r_area")==null?"":request.getParameter("r_area"))) ;
            tabdata.put("res_town_code", (request.getParameter("r_town")==null?"":request.getParameter("r_town"))) ;
			tabdata.put("REGION_CODE", (request.getParameter("r_region")==null?"":request.getParameter("r_region"))) ;
			tabdata.put("added_by_id",addedById);
			tabdata.put("added_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("added_facility_id", addedFacilityId);
			tabdata.put("added_at_ws_no",addedAtWorkstation);	
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );
			tabdata.put("EFF_STATUS",eff_status);

			String dupflds[]={"FAMILY_ORG_ID","FAMILY_ORG_SUB_ID"};

			boolean local_ejbs = isLocalEJB();
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = dupflds;
			argArray[3] = "MP_FAMILY_ORG_SUB";

			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass(); ;
			paramArray[1] = tabdata.getClass();
			paramArray[2] = dupflds.getClass();
			paramArray[3] = String.class;
			
			java.util.HashMap results = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			
			argArray = null;
			paramArray = null;
			tabdata.clear();
			
			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			String error_value = "0" ;
			tabdata.clear();
			results.clear();
			if ( inserted ) error_value = "1" ;
			//Newly added
			
			
			 if(inserted)
			{
			
			   	out.println("<script>parent.f_query_add_mod.chkorg_sub_success('servlet');</script>");
			}
			else{
              
			out.println("<script>parent.f_query_add_mod.chkorg_sub_error('servlet');</script>");
			}
			//
			
			//res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8") + "&err_value=" + error_value );
			out.println("<script>parent.messageFrame.location.href='../eCommon/jsp/MstCodeError.jsp?err_num="+error+"&err_value=" + error_value+"'</script>");
			
			

		} catch ( Exception e ) {
			/*out.println(e.getMessage());
			out.println(e.toString());*/
			e.printStackTrace();
		}
	}
	boolean isLocalEJB(){
		ServletContext context = getServletConfig().getServletContext();
		if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
				return true;
		else
				return false;
	}
	//end of function
	/*Update function for Subdetails*/
	private void updateOrganization_sub(HttpServletRequest request, HttpServletResponse res)	{
		try {
			
			organization_id=request.getParameter("org_id_hd")==null?"":request.getParameter("org_id_hd");
			String org_sub_id_up=request.getParameter("subunit_id")==null?"":request.getParameter("subunit_id");
			
			HashMap tabdata=new HashMap();
            tabdata.put("FAMILY_ORG_SUB_NAME", (request.getParameter("subunit_desc")==null?"":request.getParameter("subunit_desc"))) ;
            tabdata.put("ORG_CONTACT_NAME", (request.getParameter("subunit_contactname")==null?"":request.getParameter("subunit_contactname"))) ;
			tabdata.put("RES_TEL_NO", (request.getParameter("hphone_no")==null?"":request.getParameter("hphone_no"))) ;
            tabdata.put("OFF_TEL_NO", (request.getParameter("ophone_no")==null?"":request.getParameter("ophone_no"))) ;
			tabdata.put("ORG_ADDR_LINE_1", (request.getParameter("r_addr_line1")==null?"":request.getParameter("r_addr_line1"))) ;
            tabdata.put("ORG_ADDR_LINE_2", (request.getParameter("r_addr_line2")==null?"":request.getParameter("r_addr_line2"))) ;
            tabdata.put("ORG_ADDR_LINE_3", (request.getParameter("r_addr_line3")==null?"":request.getParameter("r_addr_line3"))) ;
            tabdata.put("ORG_ADDR_LINE_4", (request.getParameter("r_addr_line4")==null?"":request.getParameter("r_addr_line4"))) ;
        	tabdata.put("POSTAL_CODE", (request.getParameter("r_postal_code")==null?"":request.getParameter("r_postal_code"))) ;
         	tabdata.put("COUNTRY_CODE", (request.getParameter("next_country_code")==null?"":request.getParameter("next_country_code"))) ;
            tabdata.put("RES_AREA_CODE", (request.getParameter("r_area")==null?"":request.getParameter("r_area"))) ;
            tabdata.put("res_town_code", (request.getParameter("r_town")==null?"":request.getParameter("r_town"))) ;
			tabdata.put("REGION_CODE", (request.getParameter("r_region")==null?"":request.getParameter("r_region"))) ;
					
			String addedById = p.getProperty( "login_user" ) ;
			String modifiedById = addedById ;
			String modifiedFacilityId = facilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;

			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );

			HashMap condflds=new HashMap();
			condflds.put("FAMILY_ORG_ID",organization_id);
			condflds.put("FAMILY_ORG_SUB_ID",org_sub_id_up);

			boolean local_ejbs = isLocalEJB();
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = condflds;
			argArray[3] = "mp_family_org_sub";

			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass(); ;
			paramArray[1] = tabdata.getClass();
			paramArray[2] = condflds.getClass();
			paramArray[3] = String.class;
			
			java.util.HashMap results = (HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			
			argArray = null;
			paramArray = null;
			tabdata.clear();
			
			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;			

			String error = (String) results.get("error") ;
			String error_value = "0" ;
			condflds.clear();
			results.clear();
			if ( inserted ) error_value = "1" ;
				//res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8") + "&err_value=" + error_value );
				//
		    if(inserted)
			{
			
			   out.println("<script>parent.f_query_add_mod.chkorgupdate_sub_success('servlet');</script>");
			}
			else{
              
			out.println("<script>parent.f_query_add_mod.chkorgupdate_sub_error('servlet');</script>");
			}
			out.println("<script>parent.messageFrame.location.href='../eCommon/jsp/MstCodeError.jsp?err_num="+error+"&err_value=" + error_value+"'</script>");
			
			 
//

		} catch ( Exception e ) {
				/* out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
				out.println( "Values sent are : <br>" ) ;
				out.println( patientcategoryCode + " "+longDesc + " "+shortDesc +" "+ effectiveDateFrom+" "+ effectiveDateTo + " "+ effectiveStatus ); */
				e.printStackTrace();
			}
	}
	//end of function
	private void insertOrganization(HttpServletRequest req, HttpServletResponse res)	{
		try {
			organization_name = req.getParameter("org_name");
			organization_id = req.getParameter("org_id");
			effectiveStatus = req.getParameter("eff_status");
			if ( effectiveStatus == null )
					effectiveStatus="D";
			
			String addedById = p.getProperty( "login_user" ) ;
			String modifiedById = addedById ;
			String addedFacilityId=facilityId;
			String modifiedFacilityId = facilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;

			HashMap tabdata=new HashMap();
			tabdata.put("FAMILY_ORG_ID",organization_id);
			tabdata.put("FAMILY_ORG_NAME",organization_name);
			tabdata.put("eff_status",effectiveStatus);
			tabdata.put("added_by_id",addedById);
			tabdata.put("added_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("added_facility_id", addedFacilityId);
			tabdata.put("added_at_ws_no",addedAtWorkstation);	
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );

			String dupflds[]={"FAMILY_ORG_ID"};

			boolean local_ejbs = isLocalEJB1();
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = dupflds;
			argArray[3] = "MP_FAMILY_ORG";

			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass(); ;
			paramArray[1] = tabdata.getClass();
			paramArray[2] = dupflds.getClass();
			paramArray[3] = String.class;
			
			java.util.HashMap results = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			
			argArray = null;
			paramArray = null;
			tabdata.clear();
			
			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			String error_value = "0" ;
			tabdata.clear();
			results.clear();
			if ( inserted ) error_value = "1" ;
		 	
		    
			//res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8") + "&err_value=" + error_value );
		  if(inserted)
			{
			
			   out.println("<script>parent.f_query_add_mod.chkorg_success('servlet');</script>");
			}
			else{
              
			out.println("<script>parent.f_query_add_mod.chkorg_error('servlet');</script>");
			}
		   out.println("<script>parent.messageFrame.location.href='../eCommon/jsp/MstCodeError.jsp?err_num="+error+"&err_value=" + error_value+"'</script>");
			
			
			
			
			

		} catch ( Exception e ) {
			/* out.println(e.getMessage());
			out.println(e.toString()); */
			e.printStackTrace();
		}
	}
	boolean isLocalEJB1(){
		ServletContext context = getServletConfig().getServletContext();
		if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
				return true;
		else
				return false;
	}
}
