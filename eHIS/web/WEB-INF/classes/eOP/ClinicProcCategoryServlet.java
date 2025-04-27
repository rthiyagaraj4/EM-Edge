package eOP;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import eCommon.SingleTabHandler.*; 
import webbeans.eCommon.*;
public class ClinicProcCategoryServlet extends javax.servlet.http.HttpServlet	{
PrintWriter out;
java.util.Properties p;

String clinic_proc_catg_code;
String long_desc;
String short_desc;
String eff_status;

String client_ip_address ;
String facilityId="";





public void init(ServletConfig config) throws ServletException	{
	super.init(config);
	
	
	}
public synchronized void doPost(HttpServletRequest req, HttpServletResponse res)
        throws javax.servlet.ServletException,IOException{

		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");	
		
		HttpSession session = req.getSession(false);
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;

		client_ip_address = p.getProperty("client_ip_address");

		try {
			this.out = res.getWriter();
			String operation = req.getParameter("mode");
			this.facilityId = (String) session.getAttribute( "facility_id" ) ;
		if ( operation.equals("insert") ){	
				insertClinicProcCategory(req, res);
		
		}else if ( operation.equals("modify") ){
				modifyClinicProcCategory(req, res);
		}
		
		}catch (Exception e)	{
			out.println(e.toString());
			}
		}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)
 	throws javax.servlet.ServletException,IOException{
		res.setContentType("text/html;charset=UTF-8");
			doPost(req,res);
			
			
			}



	public void insertClinicProcCategory(HttpServletRequest req, HttpServletResponse res) {
	

	res.setContentType("text/html;charset=UTF-8");
	try{

		clinic_proc_catg_code=req.getParameter("clinic_proc_catg_code");
		if (clinic_proc_catg_code == null)
			clinic_proc_catg_code = "";
		long_desc=req.getParameter("long_desc");
		if (long_desc == null)
			long_desc = "";
		short_desc=req.getParameter("short_desc");
		if (short_desc == null)
			short_desc = "";
		
		eff_status=req.getParameter("eff_status")==null ? "D":req.getParameter("eff_status");
		
		
		String addedById = p.getProperty( "login_user" ) ;
		String modifiedById = addedById ;
		String addedAtWorkstation=client_ip_address;
		String modifiedAtWorkstation = addedAtWorkstation ;
		

		HashMap tabdata=new HashMap();
		tabdata.put("CLINIC_PROC_CATG_CODE",clinic_proc_catg_code);
		tabdata.put("long_desc",long_desc);
		tabdata.put("short_desc",short_desc);
		tabdata.put("eff_status",eff_status);

		tabdata.put("added_by_id",addedById);
		tabdata.put("added_date",new  java.sql.Timestamp(System.currentTimeMillis()));
		tabdata.put("added_at_ws_no",addedAtWorkstation);
		tabdata.put("added_facility_id",facilityId);
		tabdata.put("modified_by_id",modifiedById);
		tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
		tabdata.put("modified_at_ws_no",modifiedAtWorkstation );
		tabdata.put("modified_facility_id",facilityId );

		String dupfields[] = {"CLINIC_PROC_CATG_CODE"};

		boolean local_ejbs = isLocalEJB();
		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",
				SingleTabHandlerManagerHome.class,local_ejbs);
		 Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		
		Object argArray[] = new Object[4];
		argArray[0] = p;
		argArray[1] = tabdata;
		argArray[2] = dupfields;
		argArray[3] = "OP_CLINIC_PROC_CATEGORY";

		Class [] paramArray = new Class[4];
		paramArray[0] = p.getClass(); 
		paramArray[1] = tabdata.getClass();
		paramArray[2] = dupfields.getClass();
		paramArray[3] = String.class;
	
	java.util.HashMap results = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,
			argArray);
	(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);


	boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
	String error = (String) results.get("error") ;
	String error_value = "0" ;
		
	if ( inserted ){
				error_value = "1" ;
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8") 
				+ "&err_value=" + error_value );
		
		}else{
		res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8") 
		+ "&err_value=" + error_value );
		}
	
			tabdata.clear();
			results.clear();

			} 			catch ( Exception e ) {
			e.printStackTrace();
		}	
		}
	boolean isLocalEJB(){
		ServletContext context = getServletConfig().getServletContext();		
		if ((context.getInitParameter("LOCAL_EJBS") !=null) 
		&& (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
				return true;
		else
				return false;
	}



	public void modifyClinicProcCategory(HttpServletRequest req, HttpServletResponse res) throws Exception {


	try{
	

			clinic_proc_catg_code=req.getParameter("clinic_proc_catg_code")==null ? ""
					:req.getParameter("clinic_proc_catg_code");
			long_desc=req.getParameter("long_desc")==null ? "":req.getParameter("long_desc");
			short_desc=req.getParameter("short_desc")==null ? "":req.getParameter("short_desc");
			
			
			eff_status=req.getParameter("eff_status")==null ? "D":req.getParameter("eff_status");
			
			String addedById = p.getProperty( "login_user" ) ;
			String modifiedById = addedById ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;			

			
			HashMap tabdata=new HashMap();
			
			tabdata.put("long_desc",long_desc);
			tabdata.put("short_desc",short_desc);
			
			tabdata.put("eff_status",eff_status);
			
			tabdata.put("added_by_id",addedById);
			tabdata.put("added_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("added_at_ws_no",addedAtWorkstation);
			tabdata.put("added_facility_id",facilityId);
			tabdata.put("added_facility_id",facilityId);
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );
			tabdata.put("modified_facility_id",facilityId );

			HashMap condflds=new HashMap();
			condflds.put("CLINIC_PROC_CATG_CODE",clinic_proc_catg_code);
			String hard_val="OP_CLINIC_PROC_CATEGORY";
			boolean local_ejbs = isLocalEJB();
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",
					SingleTabHandlerManagerHome.class,local_ejbs);
			 Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);


				Object argArray[] = new Object[4];
				argArray[0] = p;
				argArray[1] = tabdata;
				argArray[2] = condflds;
				argArray[3] = hard_val;

				Class [] paramArray = new Class[4];
				paramArray[0] = p.getClass();
				paramArray[1] = tabdata.getClass();
				paramArray[2] = condflds.getClass();
				paramArray[3] = hard_val.getClass();

				java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray))
						.invoke(busObj,argArray);

			
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
				
				boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
				String error = (String) results.get("error") ;
				String error_value = "0" ;
				boolean inserted1=true;
				String defaulttermset	= req.getParameter("defaulttermset")==null ? ""
						:req.getParameter("defaulttermset");
				String default_status	= "N";

		
	if ( inserted ){
	error_value = "1" ;
	res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8") 
			+ "&err_value=" + error_value );
	}	else {
		res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8") 
				+ "&err_value=" + error_value );
	}

					condflds.clear();
					results.clear();
					tabdata.clear();

}catch(Exception e){	
			e.printStackTrace();
	}

}

}