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
import eOT.ExamsCheckList.ExamsCheckListHome;
import eOT.Common.OTRepository;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;

public class ExamsCheckListServlet extends javax.servlet.http.HttpServlet {
	public void init(ServletConfig config) throws ServletException	{
		super.init(config);
	}
	boolean isLocalEJB(){
        ServletContext servletcontext = getServletConfig().getServletContext();
		if ((servletcontext.getInitParameter("LOCAL_EJBS")!=null) &&(servletcontext.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
			return true;
		return false;
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws javax.servlet.ServletException,IOException{
		//String checklist_type = ""; //Common-ICN-0055
		HashMap  all_checklist_dtls	= new HashMap();
		HashMap  checklist_dtls	= null;
		HashMap tabData = new HashMap();
		PrintWriter out;
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		req= new XSSRequestWrapper(req);
		res.addHeader("X-XSS-Protection", "1; mode=block");
		res.addHeader("X-Content-Type-Options", "nosniff");
		HttpSession session=req.getSession(false);
		out=res.getWriter();
		int size=Integer.parseInt(req.getParameter("size"));
		Properties prop = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = prop.getProperty("LOCALE") ;
		int row_count = 0;
		for(int i=1;i<=size;i++){
			checklist_dtls = new HashMap();
			row_count++;
			checklist_dtls.put("insert_update_flag",req.getParameter("insert_update_flag_"+i));
			checklist_dtls.put("checklist_code",req.getParameter("checklist_code_"+i));
			checklist_dtls.put("checklist_item_code",req.getParameter("checklist_item_code_"+i));
			checklist_dtls.put("checklist_item_srl_no",req.getParameter("checklist_item_srl_no_"+i));
			checklist_dtls.put("old_remarks",req.getParameter("old_remarks_"+i));
			checklist_dtls.put("new_remarks",req.getParameter("new_remarks_"+i));
			checklist_dtls.put("checklist_value",req.getParameter("checkbox_"+i));
			all_checklist_dtls.put(row_count+"",checklist_dtls);
		}
			tabData.put("checklist_dtls",all_checklist_dtls);
			tabData.put("checklist_user_id",req.getParameter("checklist_user_id"));
			tabData.put("login_at_ws_no",prop.getProperty( "client_ip_address" ));
			tabData.put("facility_id",(String)session.getValue( "facility_id" )) ;
			tabData.put("order_id",req.getParameter("order_id"));
			tabData.put("patient_id",req.getParameter("patient_id"));
			tabData.put("confirm_yn",req.getParameter("confirm_yn"));
			tabData.put("check_list_code",req.getParameter("check_list_code"));
			tabData.put("completed_by_id",req.getParameter("completed_by_id"));
			tabData.put("hdr_insert_update_flag",req.getParameter("hdr_insert_update_flag"));
			tabData.put("jdbc_prop", prop);
			tabData.put("mode",req.getParameter("mode"));
		try{
			String hdr_insert_sql = OTRepository.getOTKeyValue("SQL_OT_EXAMS_CHECKLIST_HDR_INSERT");
			String dtl_insert_sql = OTRepository.getOTKeyValue("SQL_OT_EXAMS_CHECKLIST_DTL_INSERT");
			String hdr_update_sql = OTRepository.getOTKeyValue("SQL_OT_EXAMS_CHECKLIST_HDR_UPDATE");
			String dtl_update_sql = OTRepository.getOTKeyValue("SQL_OT_EXAMS_CHECKLIST_DTL_UPDATE");
			boolean local_ejbs=isLocalEJB();

			//Lookup the Home Object using the Service locator pattern
			//Object home =com.medicom.ESLP.ServiceLocator.getInstance().getHome("java:comp/env/ExamsCheckList",ExamsCheckListHome.class,local_ejbs);
			Object home =com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/ExamsCheckList",ExamsCheckListHome.class,local_ejbs);
			//Get the remote object by invoking create method on the home object using reflection
			Object busObj =	(home.getClass().getMethod("create",null)).invoke(home,null);
			//Create an object array, which will be passed as argument to the method call
			Object argArray[]  = new Object[5];
				   argArray[0] = tabData;				   
				   argArray[1] = hdr_insert_sql;
				   argArray[2] = dtl_insert_sql;
				   argArray[3] = hdr_update_sql;
				   argArray[4] = dtl_update_sql;

			//Create a class array, containing the class types of the arguments passed
			Class [] paramArray	   = new Class[5];
					 paramArray[0] = tabData.getClass();
					 paramArray[1] = hdr_insert_sql.getClass();
					 paramArray[2] = dtl_insert_sql.getClass();
					 paramArray[3] = hdr_update_sql.getClass();
					 paramArray[4] = dtl_update_sql.getClass();

			//Invoke the business method on the EJB using the argument array, class	array and reflection
			String result =(String)(busObj.getClass().getMethod("executeTransaction",paramArray)).invoke(busObj,argArray);

			//Call to remove the EJB
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			//Nullify the class and the object arrays
			argArray = null;
			paramArray = null;

			//Now Clean up the containers passed to the EJB
			tabData.clear();

			String msg = "";
			MessageManager mm=new MessageManager();
			if(result.equals("TRANSACTION_FAILED")){
				//msg = "Operation Failed...";
				//out.println("<html><script>alert('Operation Failed..');document.frames.messageFrame.location.href =\"../../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( msg ) + "&err_value=" + "0" +"\"</script><body class='message'></html>");
				final java.util.Hashtable mesg = mm.getMessage(locale, "APP-OT0082", "OT") ;
				msg = ((String) mesg.get("message"));
				out.println("<html><script>alert("+msg+");</script></html>");
			}else{		
				String confirm_yn=req.getParameter("confirm_yn");
				final java.util.Hashtable mesg = mm.getMessage(locale, "RECORD_INSERTED", "SM") ;
				msg = ((String) mesg.get("message"));
				//out.println("<html><script>alert('APP-SM0002 Operation Completed Successfully ....');parent.window.returnValue='"+confirm_yn+"';parent.window.close();</script></html>");
				out.println("<html><script>alert("+msg+");parent.window.returnValue='"+confirm_yn+"';parent.window.close();</script></html>");
				//out.println("<html><script>location.href =\"../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( result ) + "&err_value=" + "1" +"\"</script><body class='message'></html>");
			}
		}catch(Exception e){
			e.printStackTrace();
			//System.err.println("Err Msg in ExamsCheckListServlet "+e.getMessage());
		}
	}
} 
