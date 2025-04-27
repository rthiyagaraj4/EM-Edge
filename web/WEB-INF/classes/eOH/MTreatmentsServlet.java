/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOH;

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
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;


public class MTreatmentsServlet extends javax.servlet.http.HttpServlet{
	PrintWriter out;
	HttpSession session;
	java.util.Properties p;
	HashMap results;
	String facilityId="";
	String client_ip_address="";
	String login_user="";
	String locale="";
	String table_name="OH_TREATMENT";

	
	
	
	Connection con = null;
	PreparedStatement pstmt = null;
	PreparedStatement pstmt_insert = null;
	ResultSet rs = null;
	int flag=0;

	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		session = req.getSession(false);
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.facilityId = (String) session.getValue( "facility_id" ) ;
		login_user = this.p.getProperty( "login_user" ) ;
		client_ip_address = this.p.getProperty("client_ip_address") ;
		locale = this.p.getProperty("LOCALE") ;
		try
		{
			this.out = res.getWriter();
			String operation = req.getParameter("mode");
			if ( operation.equals("insert") )   insert(req, res);
			if ( operation.equals("modify"))    modify(req, res);
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		doPost(req,res);
	}

	private HashMap populateTabData(HttpServletRequest req, HttpServletResponse res){
		con = ConnectionManager.getConnection(req);
		String mode = checkForNull(req.getParameter("mode"));		
		HashMap tabdata=new HashMap();
		
		if("insert".equals(mode)){
			
			String trmt_code=checkForNull(req.getParameter("trmt_code"));
			String trmt_desc=checkForNull(req.getParameter("trmt_desc"));
			String trmt_category_code=checkForNull(req.getParameter("trmt_category_code"));
			String order_catalog_code=checkForNull(req.getParameter("order_catalog_code"));
			String eff_status = checkForNull(req.getParameter("eff_status"),"D");
			String multiple_task_yn=checkForNull(req.getParameter("multiple_task_yn"),"N");
			//Added by Sharon Crasta on 1/19/2010 for SRR20056-CRF-0442(IN010838)
			String crown_applicable_yn=checkForNull(req.getParameter("crown_applicable_yn"),"N");
			String progress_note_group_code=checkForNull(req.getParameter("progress_note_group_code"));
			//String inlay_onlay_yn=checkForNull(req.getParameter("inlay_onlay_yn"),"N");
			//End
			tabdata.put("trmt_code",trmt_code);
			tabdata.put("trmt_desc",trmt_desc);
			
			//String splty_module_id=checkForNull(req.getParameter("splty_module_id"),"OH");
			if(order_catalog_code==null || order_catalog_code.equals("null") || order_catalog_code.equals("")){
				order_catalog_code = trmt_code;
			}
			tabdata.put("trmt_category_code",trmt_category_code);
			tabdata.put("order_catalog_code",order_catalog_code);
			tabdata.put("multiple_task_yn",multiple_task_yn);
			//Added by Sharon Crasta on 1/19/2010 for SRR20056-CRF-0442(IN010838)
			tabdata.put("crown_applicable",crown_applicable_yn);
			tabdata.put("progress_note_group",progress_note_group_code);
			//tabdata.put("inlay_onlay",inlay_onlay_yn);
			//End
			tabdata.put("eff_status",eff_status);
			tabdata.put("splty_module_id","OH");
			tabdata.put("added_by_id",login_user);
			tabdata.put("added_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("added_facility_id", facilityId);
			tabdata.put("added_at_ws_no",client_ip_address);
			tabdata.put("modified_by_id",login_user);
			tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("modified_facility_id",facilityId);
			tabdata.put("modified_at_ws_no",client_ip_address );
		}
		else if("modify".equals(mode)){
			
			String trmt_desc=checkForNull(req.getParameter("trmt_desc"),req.getParameter("trmt_desc1") );
			String multiple_task_yn=checkForNull(req.getParameter("multiple_task_yn"),"N");
			String trmt_category_code=checkForNull(req.getParameter("trmt_category_code"),req.getParameter("trmt_category_code1") );
			String order_catalog_code=checkForNull(req.getParameter("order_catalog_code"),req.getParameter("order_catalog_code1") );
			String eff_status = checkForNull(req.getParameter("eff_status"),"D");
			//out.println("mutli="+multiple_task_yn);
			//out.println("getparameteer="+req.getParameter("multiple_task_yn"));
		    //Added by Sharon Crasta on 1/19/2010 for SRR20056-CRF-0442(IN010838)
			String crown_applicable_yn=checkForNull(req.getParameter("crown_applicable_yn"),"N");
			String progress_note_group_code=checkForNull(req.getParameter("progress_note_group_code"));
			//String inlay_onlay_yn=checkForNull(req.getParameter("inlay_onlay_yn"),"N");
			//End
			tabdata.put("trmt_desc",trmt_desc);
			tabdata.put("trmt_category_code",trmt_category_code);
			tabdata.put("order_catalog_code",order_catalog_code);
			tabdata.put("multiple_task_yn",multiple_task_yn);
			//Added by Sharon Crasta on 1/19/2010 for SRR20056-CRF-0442(IN010838)
			tabdata.put("crown_applicable",crown_applicable_yn);
			tabdata.put("progress_note_group",progress_note_group_code);
			//tabdata.put("inlay_onlay",inlay_onlay_yn);
			//End
			tabdata.put("eff_status",eff_status);
			tabdata.put("modified_by_id",login_user);
			tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("modified_facility_id",facilityId);
			tabdata.put("modified_at_ws_no",client_ip_address );
		}
		return tabdata;
	}

	private Object getRemoteObject(){
		boolean local_ejbs = isLocalEJB();
		Object busObj=null;
		try{
			Object home =com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			
			//Get the remote object by invoking create method on the home object using reflection
			busObj =	(home.getClass().getMethod("create",null)).invoke(home,null);
		}catch(Exception e){
				out.println(e.toString());
		}
		return busObj;
	}

	
	private void insert(HttpServletRequest req, HttpServletResponse res){
		HashMap tabData = populateTabData(req,res);
		String dupflds[]={"trmt_code"};
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
		
		try{
			Object busObj =	getRemoteObject();
			results =(HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			String error_value = "0" ;
			if ( inserted ){
				 error_value = "1" ;
				 try{		
				
					String trmt_code_update=checkForNull(req.getParameter("trmt_code"));
					String order_catalog_code_update=checkForNull(req.getParameter("order_catalog_code"));
					if(order_catalog_code_update==null || order_catalog_code_update.equals("null") || order_catalog_code_update.equals("")){
						order_catalog_code_update = trmt_code_update;
					}
					pstmt=con.prepareStatement("UPDATE OR_ORDER_CATALOG SET CONTR_MOD_ID='OH', CONTR_MSR_PANEL_ID=? WHERE ORDER_CATEGORY='OH' AND ORDER_CATALOG_CODE = ?");
					pstmt.setString(1,trmt_code_update);
					pstmt.setString(2,order_catalog_code_update);
					flag = pstmt.executeUpdate();


					// Insert the data into OH_TREATMENT_TASKS Table for linking:
					if(pstmt!=null) pstmt.close();
					pstmt=con.prepareStatement("SELECT C.TASK_CODE, B.ORDER_CATALOG_CODE, B.ORDER_SET_SEQ_NUM, B.DURN_TYPE, B.DURN_VALUE, (SELECT TO_CHAR(APPT_TIME,'HH24:MI') APPT_TIME FROM OR_ORDER_CATALOG A WHERE A.ORDER_CATALOG_CODE = B.ORDER_CATALOG_CODE) APPT_TIME FROM OR_ORDER_SET_COMPONENT B, OH_TASKS C WHERE B.ORDER_CATALOG_CODE = C.ORDER_CATALOG_CODE AND B.ORDER_SET_CODE = ?");
					pstmt.setString(1,order_catalog_code_update);
					if(rs!=null) rs.close();
					rs = pstmt.executeQuery();

					pstmt_insert=con.prepareStatement("INSERT INTO OH_TREATMENT_TASKS(TRMT_CODE, TASK_CODE, SEQ_NO, APPT_DURATION, DAYS_BETWEEN_OPERATOR, DAYS_BETWEEN, EFF_STATUS, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) VALUES(?, ?, ?,	TO_DATE(?,'HH24:MI'), ?, ?, 'E', ?, SYSDATE, ?, ?, ?, SYSDATE, ?, ?)");
				
					int flag_2 = 0;
					String tasks_found_flag = "N";
					while(rs!=null && rs.next()){
						tasks_found_flag = "Y";
						pstmt_insert.setString(1,trmt_code_update);
						pstmt_insert.setString(2,rs.getString("TASK_CODE"));
						pstmt_insert.setString(3,rs.getString("ORDER_SET_SEQ_NUM"));
						pstmt_insert.setString(4,rs.getString("APPT_TIME"));
						pstmt_insert.setString(5,""); //updated as NULL
						pstmt_insert.setString(6,""); //updated as NULL
						pstmt_insert.setString(7,login_user);
						pstmt_insert.setString(8,client_ip_address);
						pstmt_insert.setString(9,facilityId);
						pstmt_insert.setString(10,login_user);
						pstmt_insert.setString(11,client_ip_address);
						pstmt_insert.setString(12,facilityId);
						flag_2=pstmt_insert.executeUpdate();
					}
					if(flag != 0 || (tasks_found_flag.equals("Y") && flag_2!=0)){
						con.commit();
					}
					else{
						con.rollback();
					}
				}catch(Exception e){
					try{
						System.err.println("Rollback performed, Err Msg in MTreatmentsServlet"+e.getMessage());
						con.rollback();
					}catch(Exception e_1){
						System.err.println("MTreatmentsServlet :Caught Exception during rollback"+e_1);
					}
				}finally{
					try{
						if(pstmt!=null) pstmt.close();
						if(pstmt_insert!=null) pstmt_insert.close();
						if(rs!=null) rs.close();
						if(con!=null) ConnectionManager.returnConnection(con,req);
					}catch(Exception e){}
				}
			}else{
				 error = (String) results.get("error") ;
			}
			error = (String) results.get("error") ;
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) +"&err_value="+error_value);
			tabData.clear();
		}
		catch ( Exception e ){
			try{
				System.err.println("Rollback performed, Err Msg in MTreatmentsServlet"+e.getMessage());
				con.rollback();
			}catch(Exception e_1){
				System.err.println("MTreatmentsServlet :Caught Exception during rollback"+e_1);
			}
			out.println(" Exception raised ...So Record Not insertedFoll: Error Received : "+e.toString());
		}
	}

	private void modify(HttpServletRequest req, HttpServletResponse res){
		String trmt_code=checkForNull(req.getParameter("trmt_code1"));	
		HashMap tabData = populateTabData(req,res);
		HashMap condflds=new HashMap();
		condflds.put("trmt_code",trmt_code);
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
			tabData.clear();
			condflds.clear();

		}
		catch ( Exception e ){
			out.println("<h3> Exception raised by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
		}
	}


	private String checkForNull(String str){
		return (str!=null && str.intern()!="null")?str:"";
	}

	private String checkForNull(String str,String defaultVal){
		return (!checkForNull(str).equals(""))?str:defaultVal;
	}

	private boolean isLocalEJB(){
		ServletContext servletcontext = getServletConfig().getServletContext();
		if ((servletcontext.getInitParameter("LOCAL_EJBS")!=null) &&(servletcontext.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
			return true;
			return false;
	}

}

