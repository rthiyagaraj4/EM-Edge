/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOT;

import com.ehis.eslp.ServiceLocator;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.HashMap;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import eCommon.SingleTabHandler.*;
import eCommon.XSSRequestWrapper;


public class SpecialitiesServlet extends javax.servlet.http.HttpServlet
{
	PrintWriter out;
	java.util.Properties p;
	String table_name = "OT_SPECIALITIES";
	String facilityId="";
	String login_user="";
	String client_ip_address="";
	HttpSession session;
	HashMap results = new HashMap();
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		req.setCharacterEncoding("UTF-8");
		req= new XSSRequestWrapper(req);
		res.addHeader("X-XSS-Protection", "1; mode=block");
		res.addHeader("X-Content-Type-Options", "nosniff");
		session = req.getSession(false);
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		facilityId = (String) session.getValue( "facility_id" ) ;
		client_ip_address = this.p.getProperty("client_ip_address");
		login_user = this.p.getProperty( "login_user" ) ;
		try
		{
			res.setContentType("text/html");
			this.out = res.getWriter();
			String operation = req.getParameter("mode");
			if ( operation.equals("insert") )   insert(req, res);
			if ( operation.equals("modify"))    modify(req, res);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		doPost(req,res);
	}

	private Object getRemoteObject(){
		boolean local_ejbs = isLocalEJB();
		Object busObj=null;
		try{
			Object home =com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			//Get the remote object by invoking create method on the home object using reflection
			busObj =	(home.getClass().getMethod("create",null)).invoke(home,null);
		}catch(Exception e){
				e.printStackTrace();
		}
		return busObj;
			
	}

	private void modify(HttpServletRequest req, HttpServletResponse res){
		String  speciality_code=checkForNull(req.getParameter("speciality_code"));
		HashMap tabData = populateTabData(req,res);
		HashMap condflds=new HashMap();
		condflds.put("speciality_code",speciality_code);
		Object argArray[]  = new Object[4];
		argArray[0] = p;
		argArray[1] = tabData;				   
		argArray[2] = condflds;
		argArray[3] = table_name;
		Class [] paramArray	   = new Class[4];
		paramArray[0] = p.getClass();
		paramArray[1] = tabData.getClass();
		paramArray[2] = condflds.getClass();
		paramArray[3] = table_name.getClass();
		try{
			Object busObj = getRemoteObject();
			results =(HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
			//Call to remove the EJB
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			String error_value = "0" ;
			if ( inserted ){
				error_value = "1" ;
			}else{
				error = (String) results.get("error") ;
			}
       		error = (String) results.get("error") ;
    		res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) +"&err_value="+error_value);
		}catch ( Exception e ){
			e.printStackTrace();
		}finally{
		tabData.clear();
		condflds.clear();
		}
	}


	private HashMap populateTabData(HttpServletRequest req, HttpServletResponse res){
		HashMap tabdata=new HashMap();
		String anaesthesia_review_reqd_yn=checkForNull(req.getParameter("anaesthesia_required_yn"));
		String status = checkForNull(req.getParameter("status"));
		String operation = checkForNull(req.getParameter("mode"));
		String  speciality_code=checkForNull(req.getParameter("speciality_code"));
		String  diag_code_scheme=checkForNull(req.getParameter("diag_code_scheme")); //newly added by rajesh
		String discr_msr_id=checkForNull(req.getParameter("chart_id"));
		anaesthesia_review_reqd_yn="".equals(anaesthesia_review_reqd_yn)?"N":anaesthesia_review_reqd_yn;
		status = "".equals(status)?"D":status;
		String pre_op_check_list=checkForNull(req.getParameter("pre_op_checklist_code"));
		String pre_op_no_of_verifications=checkForNull(req.getParameter("pre_op_no_of_verifications"));
		String post_op_no_of_verifications=checkForNull(req.getParameter("post_op_no_of_verifications"));
		String swab_instr_tmpl_id=checkForNull(req.getParameter("template_id"));
//Added for Medical servide group by rajesh
		String med_ser_group=checkForNull(req.getParameter("service_id"));
		String pre_op_verify1_user_role=checkForNull(req.getParameter("role_id1"));
		String pre_op_verify2_user_role=checkForNull(req.getParameter("role_id2"));
		String pre_op_verify3_user_role=checkForNull(req.getParameter("role_id3"));
        String pre_op_verify4_user_role=checkForNull(req.getParameter("role_id4"));
		String post_op_check_list=checkForNull(req.getParameter("post_op_checklist_code"));
		String post_op_verify1_user_role=checkForNull(req.getParameter("role_id5"));
        String post_op_verify2_user_role=checkForNull(req.getParameter("role_id6"));
		String post_op_verify3_user_role=checkForNull(req.getParameter("role_id7"));
		String post_op_verify4_user_role=checkForNull(req.getParameter("role_id8"));
		//population of data
		if("insert".equals(operation))
		tabdata.put("speciality_code",speciality_code);
		tabdata.put("diag_code_scheme",diag_code_scheme);//newly added by rajesh
		tabdata.put("discr_msr_id",discr_msr_id);
		tabdata.put("pre_op_check_list",pre_op_check_list);
		tabdata.put("pre_op_no_of_verifications",pre_op_no_of_verifications);
		tabdata.put("pre_op_verify1_user_role",pre_op_verify1_user_role);
		tabdata.put("pre_op_verify2_user_role",pre_op_verify2_user_role);    
		tabdata.put("pre_op_verify3_user_role",pre_op_verify3_user_role);
		tabdata.put("pre_op_verify4_user_role",pre_op_verify4_user_role);
		tabdata.put("post_op_check_list",post_op_check_list);
		tabdata.put("post_op_no_of_verifications",post_op_no_of_verifications);
		tabdata.put("post_op_verify1_user_role",post_op_verify1_user_role);
		tabdata.put("post_op_verify2_user_role",post_op_verify2_user_role);    
		tabdata.put("post_op_verify3_user_role",post_op_verify3_user_role);
		tabdata.put("post_op_verify4_user_role",post_op_verify4_user_role);
		tabdata.put("swab_instr_tmpl_id",swab_instr_tmpl_id);
		tabdata.put("med_ser_grp_code",med_ser_group);
		tabdata.put("anaesthesia_review_reqd_yn",anaesthesia_review_reqd_yn);    
		tabdata.put("status",status);
		if("insert".equals(operation)){
			tabdata.put("added_by_id",login_user);
			tabdata.put("added_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("added_facility_id", facilityId);
			tabdata.put("added_at_ws_no",client_ip_address);
			tabdata.put("modified_by_id",login_user);
			tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("modified_facility_id",facilityId);
			tabdata.put("modified_at_ws_no",client_ip_address );
		 }else if("modify".equals(operation)){
			tabdata.put("modified_by_id",login_user);
			tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("modified_facility_id",facilityId);
			tabdata.put("modified_at_ws_no",client_ip_address );
		}
		return tabdata;
	}

	private void insert(HttpServletRequest req, HttpServletResponse res){
			HashMap tabData =  populateTabData(req,res);
			String dupflds[]={"speciality_code"};
			// boolean local_ejbs=isLocalEJB();
			//Lookup the Home Object using the Service locator pattern
			try{
				/*Object home =com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
				//Get the remote object by invoking create method on the home object using reflection*/

				Object busObj =	getRemoteObject();
				//Create an object array, which will be passed as argument to the method call
				Object argArray[]  = new Object[4];
				argArray[0] = p;
				argArray[1] = tabData;				   
				argArray[2] = dupflds;
				argArray[3] = table_name;
				//Create a class array, containing the class types of the arguments passed
				Class [] paramArray	   = new Class[4];
				paramArray[0] = p.getClass();
				paramArray[1] = tabData.getClass();
				paramArray[2] = dupflds.getClass();
				paramArray[3] = table_name.getClass();
				//Invoke the business method on the EJB using the argument array, class	array and reflection
				results =(HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
				//Call to remove the EJB
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
				boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
				String error = (String) results.get("error") ;
				String error_value = "0" ;
				if ( inserted ){
					 error_value = "1" ;
					 //results.put("error","OT-90000");							
				}else{
					 error = (String) results.get("error") ;
				}
  
			    error = (String) results.get("error") ;
			    res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) +"&err_value="+error_value);

			}
			catch ( Exception e )
			{
				e.printStackTrace();
			}finally{
				tabData.clear();
			}
		}

		private String checkForNull(String str){
			return (str!=null && str.intern()!="null")?str:"";
		}

		private boolean isLocalEJB(){
			ServletContext servletcontext = getServletConfig().getServletContext();
			if ((servletcontext.getInitParameter("LOCAL_EJBS")!=null) &&(servletcontext.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
			return true;
			return false;
		}
}
