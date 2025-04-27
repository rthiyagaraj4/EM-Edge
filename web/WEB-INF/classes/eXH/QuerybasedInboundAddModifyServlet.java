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
 *  Class used to update QuerybasedInbound  setup
 *
 */
public class QuerybasedInboundAddModifyServlet extends HttpServlet
{
	HttpServletRequest req=null;
	/**
	 * Do post method which implements the functionalities for QuerybasedInbound  setup
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
		String application_id=XHDBAdapter.checkNull(request.getParameter("application_id"));
		String facility_id=XHDBAdapter.checkNull(request.getParameter("facility_id"));
		String event_type=XHDBAdapter.checkNull(request.getParameter("event_type_id"));
		String segment_type=XHDBAdapter.checkNull(request.getParameter("segment_type_id"));
		String inboundapi_id=XHDBAdapter.checkNull(request.getParameter("inboundapi_id"));
		String insert_Query=XHDBAdapter.checkNull(request.getParameter("insert_Query")); 
		String update_Query=XHDBAdapter.checkNull(request.getParameter("update_Query"));
		String srl_no=request.getParameter("srl_no");
		String tableName=XHDBAdapter.checkNull(request.getParameter("table_name"));

		String sub_api=XHDBAdapter.checkNull(request.getParameter("sub_api"));
		String profile_id=XHDBAdapter.checkNull(request.getParameter("profile_id"));
		String stnd_code=XHDBAdapter.checkNull(request.getParameter("stnd_code"));
	
		String exec_nature = XHDBAdapter.checkNull(request.getParameter("exec_nature"));
		String gen_flag = XHDBAdapter.checkNull(request.getParameter("gen_flag"));
//		String lang_id=XHDBAdapter.checkNull(request.getParameter("lang_id"));
		
		ArrayList arrColumn=null;
		ArrayList array_audit=null;
		
		arrColumn=new ArrayList();

		arrColumn.add(p_mode);
		arrColumn.add(application_id);
		arrColumn.add(facility_id);
		arrColumn.add(event_type);
		arrColumn.add(segment_type);
		arrColumn.add(inboundapi_id);
		arrColumn.add(insert_Query);
		arrColumn.add(update_Query);
		arrColumn.add(srl_no);
		arrColumn.add(tableName);
		arrColumn.add(sub_api);
		arrColumn.add(profile_id);
		arrColumn.add(stnd_code);
		arrColumn.add(exec_nature);
		arrColumn.add(gen_flag);
		

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
	 * callEJB method is used to call QuerybasedInbound setup related database procedures
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

		System.out.println("Error in calling getconnection method of QuerybasedInboundAddModifyServlet  :"+exp.toString());
		exp.printStackTrace(System.err);
		exceptions=exceptions+"1"+"*"+exp.toString();
        
      }
 
	
	try
	{

		 String  exec_nature=(String)row_arr.get(13);
 		 String  gen_flag=(String)row_arr.get(14);

		 if(gen_flag.equals("G")){
		  if(exec_nature.equals("Q")){
			 ostmt = connection.prepareCall("{ call xhdevapi.geninsertupddelqry(?,?,?,?,?,?) }" ); 
		  }
		  else if(exec_nature.equals("T")){
		 	 ostmt = connection.prepareCall("{ call xhdevapi.geninsertupddel(?,?,?,?,?,?) }" ); 
		  }

		  String  application_id=(String)row_arr.get(1);
          String  facility_id=(String)row_arr.get(2);
		  String  event_type=(String)row_arr.get(3);
		  String  segment_type=(String)row_arr.get(4);
	      String  inboundapi_id=(String)row_arr.get(5);

		 ostmt.setString(1,application_id);
		 ostmt.setString(2,facility_id);
		 ostmt.setString(3,event_type);
		 ostmt.setString(4,segment_type);
		 ostmt.setString(5,inboundapi_id);

		 ostmt.registerOutParameter(6,java.sql.Types.VARCHAR);
	     ostmt.execute();
		
		 String status2= ostmt.getString(6);
	     ostmt.close();
		 if(status2.equals("S"))
			{
                connection.commit();
				final java.util.Hashtable mesg = mm.getMessage(locale, "XH1001", "XH") ;
			    status = ((String) mesg.get("message"));
			}
        else
			{
                connection.rollback();
				final java.util.Hashtable mesg = mm.getMessage(locale, "XH1000", "XH") ;
				status = ((String) mesg.get("message"));		
			}
		 }
		 else{

		ostmt = connection.prepareCall("{ call Xg_prc.xh_inbound_query_dtl(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }" ); 

 		  String  p_mode=(String)row_arr.get(0);
		  String  application_id=(String)row_arr.get(1);
          String  facility_id=(String)row_arr.get(2);
		  String  event_type=(String)row_arr.get(3);
		  String  segment_type=(String)row_arr.get(4);
	      String  inboundapi_id=(String)row_arr.get(5);
		  String  insert_Query=(String)row_arr.get(6);
		  String  update_Query=(String)row_arr.get(7);
   	      String  srl_no=(String)row_arr.get(8);
		  String  tableName=(String)row_arr.get(9);
	  	  String  sub_api=(String)row_arr.get(10);
		  String  profile_id=(String)row_arr.get(11);
//	  	  String  stnd_code=(String)row_arr.get(12);
 // 		  String  lang_id=(String)row_arr.get(8);


		  String  usr_added_by_id=(String)gen_arr.get(0);
		  String  usr_added_at_ws_no=(String)gen_arr.get(1);
		 
       	 ostmt.setString(1,p_mode);
		 ostmt.setString(2,application_id);
		 ostmt.setString(3,facility_id);
		 ostmt.setString(4,event_type);
		 ostmt.setString(5,segment_type);
		 ostmt.setString(6,inboundapi_id);
		 ostmt.setString(7,insert_Query);
 		 ostmt.setString(8,update_Query);
		 ostmt.setString(9,srl_no);
		 ostmt.setString(10,tableName);
 		 ostmt.setString(11,sub_api);
 //			 System.out.println("Call EJB sub_api : "+sub_api);
 //		 ostmt.setString(12,stnd_code);
// 			 System.out.println("Call EJB stnd_code : "+stnd_code);	
 		 ostmt.setString(12,profile_id);
			 
		 ostmt.setString(13,usr_added_by_id);
		 ostmt.setString(14,usr_added_at_ws_no);

  	     ostmt.registerOutParameter(15,java.sql.Types.VARCHAR);
		 ostmt.registerOutParameter(16,java.sql.Types.VARCHAR);
//		 		 ostmt.registerOutParameter(6,java.sql.Types.VARCHAR);
	     ostmt.execute();
		
		 String status2= ostmt.getString(15);
	     message_text2 = ostmt.getString(16);
	     ostmt.close();
	    
		 if(status2.equals("0"))
			{
                connection.commit();
				final java.util.Hashtable mesg = mm.getMessage(locale, "XH1001", "XH") ;
			    status = ((String) mesg.get("message"));
			}
        else
			{
                connection.rollback();
				final java.util.Hashtable mesg = mm.getMessage(locale, "XH1000", "XH") ;
				status = ((String) mesg.get("message"));		
			}

	 XHDBAdapter.closeCursor(ostmt);
	} // end of else
	
	}catch(Exception ex)
	{ 
		 System.out.println("Error in calling dbrelated statements in callejb method of QuerybasedInboundAddModifyServlet  :"+ex.toString());
		exceptions=exceptions+"3"+"*"+ex.toString();
		ex.printStackTrace(System.err);

	}
	 try{
		ConnectionManager.returnConnection(connection);
	}catch(Exception ex){ System.out.println("Error in closing db related statements in callejb method of QuerybasedInboundAddModifyServlet :"+ex.toString());
		   ex.printStackTrace(System.err); }
//	 System.out.println("status "+status);   
	    
//	status=message_text2;
	result_hm.put("exceptions",exceptions);
	result_hm.put("status",status);

	return result_hm;  
}// end of function



}// end of class
