/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOT;     
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
import webbeans.eCommon.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import eCommon.SingleTabHandler.*;
import webbeans.eCommon.*;	
import eCommon.Common.CommonBean;
import org.xml.sax.InputSource;
import com.ehis.util.BundleMessage;
import javax.servlet.jsp.*;
import eCommon.XSSRequestWrapper;


public class OperationsProceduresServlet extends javax.servlet.http.HttpServlet{
	PrintWriter out;
	HttpSession session;
	java.util.Properties p;
	HashMap results;
	String facilityId="";
	String client_ip_address="";
	String login_user="";
	String table_name="OT_OPER_MAST";
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		req= new XSSRequestWrapper(req);
		res.addHeader("X-XSS-Protection", "1; mode=block");
		res.addHeader("X-Content-Type-Options", "nosniff");
		session = req.getSession(false);
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.facilityId = (String) session.getValue( "facility_id" ) ;
		login_user = this.p.getProperty( "login_user" ) ;
		client_ip_address = this.p.getProperty("client_ip_address") ;
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
			//out.println(e.toString());
		}
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		doPost(req,res);
	}

	private HashMap populateTabData(HttpServletRequest req, HttpServletResponse res){
		String mode = checkForNull(req.getParameter("mode"));
		HashMap tabdata=new HashMap();
		if("insert".equals(mode)){
			/* String oper_code=checkForNull(req.getParameter("oper_code"));
			String oper_cat_code = checkForNull(req.getParameter("oper_cat_code"));
			String oper_sub_cat_code = checkForNull(req.getParameter("oper_sub_cat_code"));
			String type=checkForNull(req.getParameter("type"));			
			String duration = checkForNull(req.getParameter("duration")); */
			String long_desc=checkForNull(req.getParameter("long_desc"));
			String short_desc=checkForNull(req.getParameter("short_desc"));
			String oper_type_code = checkForNull(req.getParameter("oper_type_code"));
			String order_catalog_code = checkForNull(req.getParameter("order_catalog_code"));
			String speciality_code = checkForNull(req.getParameter("speciality_code"));
			String pre_op_check_list = checkForNull(req.getParameter("pre_op_check_list"));
			String post_op_check_list = checkForNull(req.getParameter("post_op_check_list"));
			String swab_instr_tmpl_id = checkForNull(req.getParameter("swab_instr_tmpl_id"));
			String status = checkForNull(req.getParameter("status"),"D");
			String side_appl = checkForNull(req.getParameter("side_appl"),"N");
			tabdata.put("oper_code",checkForNull(req.getParameter("oper_code")));
			if(order_catalog_code.equals(""))
				order_catalog_code = checkForNull(req.getParameter("oper_code"));
			tabdata.put("long_desc",long_desc);
			tabdata.put("short_desc",short_desc);
			tabdata.put("oper_type_code",oper_type_code);
			tabdata.put("order_catalog_code",order_catalog_code);
			tabdata.put("appl_right_left_flag",side_appl);
			tabdata.put("speciality_code",speciality_code);
			tabdata.put("pre_op_check_list",pre_op_check_list);
			tabdata.put("post_op_check_list",post_op_check_list);
			tabdata.put("swab_instr_tmpl_id",swab_instr_tmpl_id);
			tabdata.put("diag_code_scheme",checkForNull(req.getParameter("diag_code_scheme")));	
			tabdata.put("status",status);
			//auditing fields
			tabdata.put("added_by_id",login_user);
			tabdata.put("added_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("added_facility_id", facilityId);
			tabdata.put("added_at_ws_no",client_ip_address);
			tabdata.put("modified_by_id",login_user);
			tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("modified_facility_id",facilityId);
			tabdata.put("modified_at_ws_no",client_ip_address );
		}else if("modify".equals(mode)){
			String long_desc=checkForNull(req.getParameter("long_desc"),req.getParameter("long_desc1") );
			String short_desc=checkForNull(req.getParameter("long_desc"),req.getParameter("short_desc1") );
			String nature_type=checkForNull(req.getParameter("type"),req.getParameter("type1") );
			String status = checkForNull(req.getParameter("status"),"D");
			tabdata.put("long_desc",long_desc);
			tabdata.put("short_desc",short_desc);
			tabdata.put("nature_type",nature_type);
			tabdata.put("status",status);
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
			//Object home =com.medicom.ESLP.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object home =com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			//Get the remote object by invoking create method on the home object using reflection
			busObj =	(home.getClass().getMethod("create",null)).invoke(home,null);
		}catch(Exception e){
				//out.println(e.toString());
				e.printStackTrace();
		}
		return busObj;
	}

	
	private void insert(HttpServletRequest req, HttpServletResponse res){
		String oper_code=checkForNull(req.getParameter("oper_code"));
		String order_catalog_code = checkForNull(req.getParameter("order_catalog_code"));
		if(order_catalog_code.equals(""))
			order_catalog_code= oper_code;
		String duration = checkForNull(req.getParameter("duration"));

		String speciality_code = checkForNull(req.getParameter("speciality_code"));
		String oper_cat_code = checkForNull(req.getParameter("oper_cat_code"));

		String oper_sub_cat_code = checkForNull(req.getParameter("oper_sub_cat_code"));
		HashMap tabData = populateTabData(req,res);
		String dupflds[]={"oper_code"};
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
		MessageManager mm=new MessageManager();
		
		try{
			String locale = p.getProperty("LOCALE") ;
			Object busObj =	getRemoteObject();
			String retval = "";
			String error_value = "0" ;
			results =(HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;

			if ( inserted ){
				error_value = "1" ;
				order_catalog(req, res, oper_code, duration,  order_catalog_code);
				if (!oper_cat_code.equals("")){
						retval = ins_category(req, res, oper_code, speciality_code,  oper_cat_code,  oper_sub_cat_code);
						if(retval.equals("1"))
							error_value = "1" ;
						else
							error_value = "0" ;
				}

				if(error_value.equals("0")){
					final java.util.Hashtable mesg = mm.getMessage(locale, "APP-OT0082", "OT") ;
					error = ((String) mesg.get("message"));
					res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) +"&err_value="+error);
				}else{
					final java.util.Hashtable mesg = mm.getMessage(locale, "RECORD_INSERTED", "SM") ;
					error = ((String) mesg.get("message"));
					res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) +"&err_value=1");
				}
			}else{
				error = (String) results.get("error") ;
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) +"&err_value="+error);
			}
		}
		catch ( Exception e ){
			//out.println(" Exception raised ...So Record Not insertedFoll: Error Received : "+e.toString());
			//out.println( "Values sent are : <br>" ) ;
			e.printStackTrace();
		}
	}

	private void modify(HttpServletRequest req, HttpServletResponse res){
		Connection con = null;
		MessageManager mm=new MessageManager();
		PreparedStatement pstmt = null;
		String err_text = "";
		String oper_code=checkForNull(req.getParameter("oper_code"));
		String long_desc=checkForNull(req.getParameter("long_desc"));
		String short_desc=checkForNull(req.getParameter("short_desc"));
		String oper_type_code = checkForNull(req.getParameter("oper_type_code"));
		String order_catalog_code = checkForNull(req.getParameter("order_catalog_code1"));
		String duration = checkForNull(req.getParameter("duration"));
		String pre_op_check_list = checkForNull(req.getParameter("pre_op_check_list"));
		String post_op_check_list = checkForNull(req.getParameter("post_op_check_list"));
		String swab_instr_tmpl_id = checkForNull(req.getParameter("swab_instr_tmpl_id"));
		String oper_cat_code = checkForNull(req.getParameter("oper_cat_code"));
		String oper_sub_cat_code = checkForNull(req.getParameter("oper_sub_cat_code"));
		String db_oper_cat_code=checkForNull(req.getParameter("db_oper_cat_code"));
		String 	db_oper_sub_cat_code=checkForNull(req.getParameter("db_oper_sub_cat_code"));
		String 	duration_db_value =checkForNull(req.getParameter("duration_db_value"));
		String  status = checkForNull(req.getParameter("status"),"D");
		String side_appl = checkForNull(req.getParameter("side_appl1"),"N");
		String speciality_code = checkForNull(req.getParameter("speciality_code"));
		String error_value="0";
		String retval = ""; //Common-ICN-0055
		try{
			String locale = p.getProperty("LOCALE") ;
			con = ConnectionManager.getConnection(req);
			String sql = "UPDATE OT_OPER_MAST SET LONG_DESC =? , SHORT_DESC = ?, OPER_TYPE_CODE = ?, APPL_RIGHT_LEFT_FLAG= ?, PRE_OP_CHECK_LIST= ? , POST_OP_CHECK_LIST = ?, SWAB_INSTR_TMPL_ID= ? , STATUS = ?, SPECIALITY_CODE = ?,MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ? WHERE OPER_CODE = ?";
		 	pstmt=con.prepareStatement(sql);
			pstmt.setString(1, long_desc);
			pstmt.setString(2, short_desc);
			pstmt.setString(3, oper_type_code);
			pstmt.setString(4, side_appl);
			pstmt.setString(5, pre_op_check_list);
			pstmt.setString(6, post_op_check_list);
			pstmt.setString(7, swab_instr_tmpl_id);
			pstmt.setString(8, status);
			pstmt.setString(9, speciality_code);
			pstmt.setString(10, login_user);
			pstmt.setString(11, client_ip_address);
			pstmt.setString(12, facilityId);
			pstmt.setString(13, oper_code);
			int flag = pstmt.executeUpdate();
			if (flag > 0)
			{
				if (duration != duration_db_value) {
					order_catalog(req, res, oper_code, duration,  order_catalog_code);
				}
				if (oper_cat_code!=null && !oper_cat_code.equals(""))
				{
					if (!db_oper_cat_code.equals("")  ) {
						if ((oper_cat_code != db_oper_cat_code) || (oper_sub_cat_code != db_oper_sub_cat_code)){
							 retval = upd_category(req, res, oper_code,  oper_cat_code,  oper_sub_cat_code);
						}
					}
					if (db_oper_cat_code.equals("") && !oper_cat_code.equals("") )
					{
						 retval = ins_category(req, res, oper_code, speciality_code,  oper_cat_code,  oper_sub_cat_code);
					}
				}		 
				con.commit();
				error_value="1";
				// err_text = "Operation Completed Successfully .... ";
				final java.util.Hashtable mesg = mm.getMessage(locale, "RECORD_INSERTED", "SM") ;
				err_text = ((String) mesg.get("message"));
			}else{	 					
				//err_text = "Operation Failed";
				final java.util.Hashtable mesg = mm.getMessage(locale, "APP-OT0082", "OT") ;
				err_text = ((String) mesg.get("message"));
				con.rollback();
				error_value="0";
			}
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( err_text) +"&err_value="+error_value);
			if (pstmt!=null){
				pstmt.close();
			}
		}catch (Exception e ){
			e.printStackTrace();
			//out.println(" Exception raised ...Record Not updated : Error Received : "+e.toString());
		}finally{
			if(con!=null)	ConnectionManager.returnConnection(con,req);
		} 
	}

	private void order_catalog(HttpServletRequest req, HttpServletResponse res, String oper_code, String duration,  String order_catalog_code){
		Connection con = null;
		PreparedStatement pstmt = null;
		int flag=0;
		java.text.SimpleDateFormat xdate = new java.text.SimpleDateFormat("dd/MM/yyyy");
		String durdate = xdate.format( new java.util.Date() ) ;
		durdate = durdate+" "+duration;

		try
		{
				con = ConnectionManager.getConnection(req);
				String sql = "UPDATE OR_ORDER_CATALOG SET CONTR_MOD_ID = 'OT' , CONTR_MSR_PANEL_ID  = ? ,	APPT_REQD_YN  = 'Y'  , 	APPT_TIME = TO_DATE(?,'DD/MM/YYYY HH24:MI')	WHERE ORDER_CATALOG_CODE = ?";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, oper_code);
				pstmt.setString(2, durdate);
				pstmt.setString(3, order_catalog_code);
				flag=pstmt.executeUpdate();
				if (flag==1){
					con.commit();
				}
				if (pstmt!=null){
					pstmt.close();
				}
		}
		catch (Exception e ){
			e.printStackTrace();
			//out.println(" 310: Exception raised ...Record Not updated : Error Received : "+e.toString());
		}
		finally{
			if(con!=null)	
				ConnectionManager.returnConnection(con,req);
		}
	
	}

	private String ins_category(HttpServletRequest req, HttpServletResponse res, String oper_code, String speciality_code,  String oper_cat_code,  String oper_sub_cat_code){

		Connection con = null;
		PreparedStatement pstmt1 = null;
		String err_text = "";
		try
		{
			con = ConnectionManager.getConnection(req);
			String sql = "INSERT INTO OT_OPER_FOR_GROUP_CAT (OPER_CODE, OPER_GROUP_CODE, OPER_CAT_CODE , OPER_SUB_CAT_CODE, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID , MODIFIED_BY_ID , MODIFIED_DATE , MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) VALUES (?, ?, ?, ?, ?, sysdate, ?, ?, ?, sysdate, ?, ?)";
			 pstmt1=con.prepareStatement(sql);
			 pstmt1.setString(1, oper_code);
			 pstmt1.setString(2, speciality_code);
			 pstmt1.setString(3, oper_cat_code);
			 pstmt1.setString(4, oper_sub_cat_code);
			 pstmt1.setString(5, login_user);
			 pstmt1.setString(6, client_ip_address);
			 pstmt1.setString(7, facilityId);
			 pstmt1.setString(8, login_user);
			 pstmt1.setString(9, client_ip_address);
			 pstmt1.setString(10, facilityId);
			 int flag = pstmt1.executeUpdate();
			if (flag > 0){
				con.commit();
				err_text = "1";
			}else{	 					
				//err_text = "Record not inserted for Category == "+flag;
				con.rollback();
				err_text = "0";
			}
			if (pstmt1!=null){
				pstmt1.close();
			}
		}catch (Exception e ){
						e.printStackTrace();
						//err_text = e.toString();
		}finally{
				if(con!=null)	ConnectionManager.returnConnection(con,req);
		} 
		return  err_text ;
	}	  

	private String upd_category(HttpServletRequest req, HttpServletResponse res, String oper_code,  String oper_cat_code,  String oper_sub_cat_code){

		Connection con = null;
		PreparedStatement pstmt1 = null;
		String err_text = "";
		try
		{
				con = ConnectionManager.getConnection(req);
				String sql = "UPDATE OT_OPER_FOR_GROUP_CAT SET OPER_CAT_CODE = ? ,  OPER_SUB_CAT_CODE = ?,   MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ? , MODIFIED_FACILITY_ID = ? WHERE OPER_CODE = ?";
				pstmt1=con.prepareStatement(sql);
				 pstmt1.setString(1, oper_cat_code);
				 pstmt1.setString(2, oper_sub_cat_code);
				 pstmt1.setString(3, login_user);
				 pstmt1.setString(4, client_ip_address);
				 pstmt1.setString(5, facilityId);
				 pstmt1.setString(6, oper_code);

				 int flag = pstmt1.executeUpdate();
					if (flag > 0)
					{
						con.commit();
						err_text = ""+flag;
					} else{	 					
						err_text = "Record not Updated for Category == "+flag;
					}
					if (pstmt1!=null)
					{
						pstmt1.close();
					}

			}
			catch (Exception e ){
						e.printStackTrace();
						//err_text = e.toString();
			}
			finally{
				if(con!=null)	ConnectionManager.returnConnection(con,req);
			} 
			return  err_text ;
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
