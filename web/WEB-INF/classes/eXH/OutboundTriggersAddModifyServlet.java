/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eXH;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.net.*;
import java.sql.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.*;
import eXH.XHDBAdapter;
import eXH.ArrayAuditInfo;
import eXH.XHTYPE;
import java.util.regex.*;
/**
 *  Class used to update OutboundTriggers setup
 *
 */
public class OutboundTriggersAddModifyServlet extends HttpServlet
{
	HttpServletRequest req=null;
	String gen_flag = "";
	/**
	 * Do post method which implements the functionalities for OutboundTriggers setup
	 * @param  HttpServletRequest request
	 * @param  HttpServletResponse response
	 */

	public void doPost (HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException 
	{
		PrintWriter out;
		out=response.getWriter();
		req=request;
		
			
		HttpSession session=request.getSession(false);
		Properties p;		
		p = (Properties) session.getValue("jdbc");	
		String locale  = p.getProperty("LOCALE");

		request.setCharacterEncoding("UTF-8");
   	    response.setContentType("text/html;charset=UTF-8");

		String p_mode=request.getParameter("act_mode");	
//			System.out.println("p_mode : "+p_mode);
		String trig_name=XHDBAdapter.checkNull(request.getParameter("trig_name"));
		String trig_event=XHDBAdapter.checkNull(request.getParameter("trig_event"));
		String table_name=XHDBAdapter.checkNull(request.getParameter("table_name"));
		String trig_type=XHDBAdapter.checkNull(request.getParameter("trig_type"));
		String trig_cond=XHDBAdapter.checkNull(request.getParameter("trig_cond"));
		String event_type=XHDBAdapter.checkNull(request.getParameter("event_type_id"));
//			System.out.println("OutbTrigsrvlt event_type : "+event_type);
		String facility_name=XHDBAdapter.checkNull(request.getParameter("facility_id"));
//			System.out.println("OutbTrigsrvlt facility_name : "+facility_name);
		String facility_type=XHDBAdapter.checkNull(request.getParameter("facility_type"));
		if(p_mode.equals("I")&&facility_type.equals("S")){
			facility_name	= "'"+facility_name+"'";
//			System.out.println("facility_id wid qts : "+facility_name);
		}
		String insert_stat=XHDBAdapter.checkNull(request.getParameter("insert_stat"));

		gen_flag=XHDBAdapter.checkNull(request.getParameter("gen_flag"));
//			System.out.println("OutbTrigsrvlt gen_flag : "+gen_flag);
			
//		String lang_id=XHDBAdapter.checkNull(request.getParameter("lang_id"));
		
		ArrayList arrColumn=null;
		ArrayList array_audit=null;
		
		arrColumn=new ArrayList();

		arrColumn.add(p_mode);
		arrColumn.add(trig_name);
		arrColumn.add(trig_event);
		arrColumn.add(table_name);
		arrColumn.add(trig_type);
		arrColumn.add(trig_cond);
		arrColumn.add(event_type);
		arrColumn.add(facility_name);
		arrColumn.add(insert_stat);
 //		arrColumn.add(lang_id);
		   
		array_audit=new ArrayList();
		array_audit = ArrayAuditInfo.getArrayAuditInfo(session);		

		HashMap details_hm= new HashMap();
		details_hm.put("row_details",arrColumn);
		details_hm.put("gen_details",array_audit);
		HashMap result_hm=new HashMap();
		result_hm=callEJB(details_hm,locale );	
		
        RequestDispatcher reqDis = 	session.getServletContext().getRequestDispatcher("/eXH/jsp/DisplayResult.jsp?message="+(String)result_hm.get("status"));
        reqDis.forward(request,response);		


	}// end of do post

 /**
	 * callEJB method is used to call OutboundTriggersAddModifyServlet setup related database procedures
	 * @param  HashMap details_hm
	 * @param  String locale
	 */
	public HashMap callEJB(HashMap details_hm,String locale )
   {
    

	Connection connection = null;
	CallableStatement ostmt = null;
	String message_text2 = "";
	String status="";
	String exceptions="";
	HashMap result_hm=new HashMap();
	MessageManager mm=new MessageManager();
		
	ArrayList row_arr = (ArrayList) details_hm.get("row_details");
	ArrayList gen_arr = (ArrayList) details_hm.get("gen_details");
	
	  
    try
	{
		if(connection==null) connection = ConnectionManager.getConnection();
      
      }
      catch(Exception exp)
      {

		 System.out.println("Error in calling getconnection method of OutboundTriggersAddModifyServlet  :"+exp.toString());
		exp.printStackTrace(System.err);
		exceptions=exceptions+"1"+"*"+exp.toString();
        
      }
 
	
	try
	{

	 ostmt = connection.prepareCall("{ call Xg_prc.xh_trigger(?,?,?,?,?,?,?,?,?,?,?,?,?) }" ); 

		  String  p_mode=(String)row_arr.get(0);
   	      String  trig_name=(String)row_arr.get(1);
		  String  trig_event=(String)row_arr.get(2);
		  String  table_name=(String)row_arr.get(3);
		  String  trig_type=(String)row_arr.get(4);
		  String  trig_cond=(String)row_arr.get(5);
		  String  event_type=(String)row_arr.get(6);
		  String  facility_name=(String)row_arr.get(7);
		  String  insert_stat=(String)row_arr.get(8);
 //       String  lang_id=(String)row_arr.get(23);
   
		  String  usr_added_by_id=(String)gen_arr.get(0);
		  String  usr_added_at_ws_no=(String)gen_arr.get(1);

		 ostmt.setString(1,p_mode);
//			 System.out.println("Call EJB p_mode : "+p_mode);
		 ostmt.setString(2,trig_name);
//  	 		 System.out.println("Call EJB trig_name : "+trig_name);
	     ostmt.setString(3,trig_event);
		 ostmt.setString(4,table_name);
		 ostmt.setString(5,trig_type);
		 ostmt.setString(6,trig_cond);
		 ostmt.setString(7,event_type);
		 ostmt.setString(8,facility_name);
		 ostmt.setString(9,insert_stat);
//		 ostmt.setString(23,lang_id);
		 		 		  
		 ostmt.setString(10,usr_added_by_id);
		 ostmt.setString(11,usr_added_at_ws_no);
	 
	     ostmt.registerOutParameter(12,java.sql.Types.VARCHAR);
	     ostmt.registerOutParameter(13,java.sql.Types.VARCHAR);
	     ostmt.execute();
	
	     String status2= ostmt.getString(12);
//	 		 System.out.println("Call EJB status2 : "+status2);
	     message_text2 = ostmt.getString(13);
//		 		System.out.println("Srvlet ostmt message_text2 : "+message_text2);


//	     ostmt.close();
		java.util.Hashtable mesg = new Hashtable();
		if(status2.equals("0"))
		{
                connection.commit();
				mesg = mm.getMessage(locale, "XH1001", "XH") ;
			    status = ((String) mesg.get("message"));
	
		 if(gen_flag.equals("G")){ 	
//				  System.out.println("Srvlet gen_flag : "+gen_flag);
	 		 ostmt = connection.prepareCall("{ call xhdevapi.xhgeneric_trigger(?,?,?) }" ); 
//			 ostmt = connection.prepareCall("{ call Xhgeneric_trigger(?,?,?) }" ); 

//				  System.out.println("Call EJB trig_name : "+trig_name);
			 ostmt.setString(1,trig_name);
		     ostmt.registerOutParameter(2,java.sql.Types.VARCHAR);
		     ostmt.registerOutParameter(3,java.sql.Types.VARCHAR);
		     ostmt.execute();
	
			 String error_code= ostmt.getString(2);
			 String error_msg = ostmt.getString(3);
			 message_text2 = error_msg;

			if(error_code.equals("0")){
                connection.commit();
//				final java.util.Hashtable mesg = mm.getMessage(locale, "XH1001", "XH") ;
				mesg = mm.getMessage(locale, "XH1001", "XH") ;
			    status = ((String) mesg.get("message"));
			}
			else
			{
                connection.rollback();
//				final java.util.Hashtable mesg = mm.getMessage(locale, "XH1000", "XH") ;
				mesg = mm.getMessage(locale, "XH1000", "XH") ;
				status = ((String) mesg.get("message"));	
//				status = status+message_text2;
			}

// 			 XHDBAdapter.closeCursor(ostmt);	
		}// End of gen_flag -G
		} // end of if
		else
		{
                connection.rollback();
//				final java.util.Hashtable mesg = mm.getMessage(locale, "XH1000", "XH") ;
				mesg = mm.getMessage(locale, "XH1000", "XH") ;
				status = ((String) mesg.get("message"));	
				status = status+message_text2;
		}
		 ostmt.close();
		 XHDBAdapter.closeCursor(ostmt);


	}catch(Exception ex)
	{ 
		 System.out.println("Error in calling dbrelated statements in callejb method of OutboundTriggersAddModifyServlet  :"+ex.toString());
		exceptions=exceptions+"3"+"*"+ex.toString();
		ex.printStackTrace(System.err);

	}
	 try{
		 if(ostmt!=null) ostmt.close();
		ConnectionManager.returnConnection(connection);
	}catch(Exception ex){ System.out.println("Error in closing dbrealted statements in callejb method of OutboundTriggersAddModifyServlet :"+ex.toString());
		   ex.printStackTrace(System.err); }
//	 System.out.println("status "+status);   
	    
//	status=message_text2;
	result_hm.put("exceptions",exceptions);
	result_hm.put("status",status);

	return result_hm;  
}// end of callEJB function



}// end of class
