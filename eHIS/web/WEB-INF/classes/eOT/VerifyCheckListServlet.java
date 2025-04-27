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
import java.util.Properties;
import eOT.VerifyCheckList.*;
import eOT.Common.OTRepository;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;

/*import com.ehis.util.BundleMessage;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.*;*/

public class VerifyCheckListServlet extends javax.servlet.http.HttpServlet {
	public void init(ServletConfig config) throws ServletException	{
		super.init(config);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws javax.servlet.ServletException,IOException{
		//PageContext pageContext = JspFactory.getDefaultFactory().getPageContext(this, req, res, null, false, -1, true);
		String checklist_type = "";
		String locale = "";
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
//		int no_of_verifications=Integer.parseInt(req.getParameter("no_of_verifications"));
		int current_level=Integer.parseInt(req.getParameter("current_level"));
		int size=Integer.parseInt(req.getParameter("size"));
		Properties prop = (java.util.Properties) session.getValue( "jdbc" ) ;
		locale = (String) prop.getProperty( "LOCALE" ) ;
		String checklist_value = "";
//		String chkbox_value = "";
		String accept_remarks_yn = "";
		String remarks_i="";
		int row_count = 0;
		for(int i=1;i<=size;i++){
			remarks_i=req.getParameter("remarks_"+i);
			//System.err.println("remarks_i **********"+remarks_i);
		    remarks_i=java.net.URLDecoder.decode(remarks_i,"UTF-8");

			//System.err.println("remarks_i after decoding**********"+remarks_i);
			checklist_dtls = new HashMap();
			checklist_type = req.getParameter("checklist_type_"+i);
			accept_remarks_yn	= req.getParameter("accept_remarks_yn_"+i);
			checklist_value		= "";
			//String 	ins_upd_flag= req.getParameter("insert_update_flag_"+i); //Common-ICN-0055
			if(checklist_type.equals("E") && !accept_remarks_yn.equals("Y")){ 
				// Ignore Heading titles (have no chkbox, no listitem, no remarks)
			}else{
				row_count++;
				if(checklist_type.equals("E") && accept_remarks_yn.equals("Y")){
					checklist_value = "";			 	
					checklist_dtls.put("insert_update_flag",checkForNull(req.getParameter("insert_update_flag_"+i)));
				}else{
					checklist_dtls.put("insert_update_flag",checkForNull(req.getParameter("insert_update_flag_"+i+"_"+current_level)));
					if(checklist_type.equals("L")){
						checklist_value = req.getParameter("list_value_"+i+"_"+current_level);
					} else if(checklist_type.equals("C")){
						checklist_value = req.getParameter("chkbox_value_"+i+"_"+current_level);
					}
				}
				checklist_dtls.put("description",req.getParameter("description_"+i));
				checklist_dtls.put("checklist_type",checklist_type);
				checklist_dtls.put("checklist_code",req.getParameter("checklist_code_"+i));
				checklist_dtls.put("checklist_item_code",req.getParameter("checklist_item_code_"+i));
				checklist_dtls.put("checklist_item_srl_no",req.getParameter("checklist_item_srl_no_"+i));
				checklist_dtls.put("accept_remarks_yn",accept_remarks_yn);
				checklist_dtls.put("remarks",remarks_i);

				checklist_dtls.put("checklist_value",checklist_value);
				checklist_dtls.put("checklist_stage",req.getParameter("checklist_stage"));

				all_checklist_dtls.put(row_count+"",checklist_dtls);
			}
		}

			tabData.put("checklist_dtls",all_checklist_dtls);
			tabData.put("checklist_user_id",req.getParameter("checklist_user_id"));
			tabData.put("login_at_ws_no",prop.getProperty( "client_ip_address" ));
			tabData.put("facility_id",(String)session.getValue( "facility_id" )) ;
			tabData.put("oper_num",req.getParameter("oper_num"));
			tabData.put("order_id",req.getParameter("order_id"));
			tabData.put("booking_num",req.getParameter("booking_num"));
			tabData.put("checklist_stage",req.getParameter("checklist_stage"));
			tabData.put("list_id",req.getParameter("list_id"));
			tabData.put("confirm_yn",req.getParameter("confirm_yn"));
			tabData.put("booking_or_oper_flag",req.getParameter("booking_or_oper_flag"));
			
			tabData.put("jdbc_prop", prop);
			tabData.put("mode",req.getParameter("mode"));
		try{
			String insert_sql = OTRepository.getOTKeyValue("SQL_OT_VERIFY_CHECKLIST_INSERT");
			String update_sql = OTRepository.getOTKeyValue("SQL_OT_VERIFY_CHECKLIST_UPDATE");
			String msg = "";
			boolean local_ejbs=isLocalEJB();

			//Lookup the Home Object using the Service locator pattern
			//Object home =com.medicom.ESLP.ServiceLocator.getInstance().getHome(OTRepository.getOTKeyValue("JNDI_OT_VERIFY_CHECK_LIST"),VerifyCheckListHome.class,local_ejbs);
			Object home =com.ehis.eslp.ServiceLocator.getInstance().getHome(OTRepository.getOTKeyValue("JNDI_OT_VERIFY_CHECK_LIST"),VerifyCheckListHome.class,local_ejbs);
			//Get the remote object by invoking create method on the home object using reflection
			Object busObj =	(home.getClass().getMethod("create",null)).invoke(home,null);
			//Create an object array, which will be passed as argument to the method call
			Object argArray[]  = new Object[3];
				   argArray[0] = tabData;				   
				   argArray[1] = insert_sql;
				   argArray[2] = update_sql;

			//Create a class array, containing the class types of the arguments passed
			Class [] paramArray	   = new Class[3];
					 paramArray[0] = tabData.getClass();
					 paramArray[1] = insert_sql.getClass();
					 paramArray[2] = update_sql.getClass();
			//Invoke the business method on the EJB using the argument array, class	array and reflection
			String result =(String)(busObj.getClass().getMethod("executeTransaction",paramArray)).invoke(busObj,argArray);
			//Call to remove the EJB
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			//Nullify the class and the object arrays
			argArray = null;
			paramArray = null;

			//Now Clean up the containers passed to the EJB
			tabData.clear();
            MessageManager mm=new MessageManager();
			if(result.equals("TRANSACTION_FAILED")){
				final java.util.Hashtable mesg = mm.getMessage(locale, "APP-OT0082", "OT") ;
				msg = ((String) mesg.get("message"));
 				//out.println("<html><script>alert("+msg+");</script></html>");
				out.println("<html><script>alert('"+msg+"');</script></html>");

			}else{		
				String confirm_yn=req.getParameter("confirm_yn");
				final java.util.Hashtable mesg = mm.getMessage(locale, "RECORD_INSERTED", "SM") ;
				msg = ((String) mesg.get("message"));
				out.println("<html><script>alert('"+msg+"');window.returnValue='"+confirm_yn+"';window.close();</script></html>");
				//out.println("<html><script>location.href =\"../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( result ) + "&err_value=" + "1" +"\"</script><body class='message'></html>");
			}

		}catch(Exception e){
			e.printStackTrace();
			//System.err.println("Err Msg in VerifyCheckListServlet "+e.getMessage());
		}

	}
	boolean isLocalEJB(){
        ServletContext servletcontext = getServletConfig().getServletContext();
		if ((servletcontext.getInitParameter("LOCAL_EJBS")!=null) &&(servletcontext.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
			return true;
		return false;
	}
		private String checkForNull(String str){
		return (str!=null && str.intern()!="null")?str:"";
	}
}



