/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eXH;
import java.sql.*;
import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;
import webbeans.eCommon.*;
import eXH.XHDBAdapter;
import eXH.ArrayAuditInfo;
/**
 *  Class used to update DataGroupId setup
 *
 */
public class DataGroupIdAddModifyServlet extends HttpServlet
{
	HttpServletRequest req=null;
	/**
	 * Do post method which implements the functionalities for DataGroupId  setup
	 * @param  HttpServletRequest request
	 * @param  HttpServletResponse response
	 */

	public void doPost (HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException 
	{
		req=request;
		
			
		HttpSession session=request.getSession(false);
		Properties p;		
		p = (Properties) session.getValue("jdbc");	
		String locale  = p.getProperty("LOCALE");

		request.setCharacterEncoding("UTF-8");
   	    response.setContentType("text/html;charset=UTF-8");
		
		String p_mode=request.getParameter("act_mode");
		String dg_code=XHDBAdapter.checkNull(request.getParameter("dg_code"));
//		System.out.println("dg_code : "+dg_code);
		String dg_desc=XHDBAdapter.checkNull(request.getParameter("dg_desc"));
//		System.out.println("dg_desc : "+dg_desc);

		String standard_code=XHDBAdapter.checkNull(request.getParameter("standard_code"));
//		System.out.println("standard_code : "+standard_code);
		String application_id=XHDBAdapter.checkNull(request.getParameter("application_id"));
//		System.out.println("application_id : "+application_id);
		String comm_mode=XHDBAdapter.checkNull(request.getParameter("Communication_mode"));
//		String p_mode=request.getParameter("act_mode");		
//		String lang_id=XHDBAdapter.checkNull(request.getParameter("lang_id"));

		ArrayList<String> arrColumn=null;
		ArrayList<String> array_audit=null;
		
		arrColumn=new ArrayList<String>();

		arrColumn.add(p_mode);
		arrColumn.add(dg_code);
		arrColumn.add(dg_desc);
		arrColumn.add(standard_code);
		arrColumn.add(application_id);
        arrColumn.add(comm_mode);
//		arrColumn.add(lang_id);
		
		array_audit=new ArrayList<String>();
		array_audit = ArrayAuditInfo.getArrayAuditInfo(session);		

		HashMap<String, ArrayList<String>> details_hm= new HashMap<String, ArrayList<String>>();
		details_hm.put("row_details",arrColumn);
		details_hm.put("gen_details",array_audit);
		HashMap<String, String> result_hm=new HashMap<String, String>();
		result_hm=callEJB(details_hm,locale );	
		
        RequestDispatcher reqDis = 	session.getServletContext().getRequestDispatcher("/eXH/jsp/DisplayResult.jsp?message="+(String)result_hm.get("status"));
        reqDis.forward(request,response);		
        
        arrColumn.clear();
        array_audit.clear();


	}// end of do post

 /**
	 * callEJB method is used to call DataGroupId setup related database procedures
	 * @param  HashMap details_hm
	 * @param  String locale
	 */
	public HashMap<String, String> callEJB(HashMap<String, ArrayList<String>> details_hm,String locale )
   {    

	Connection connection = null;
	CallableStatement ostmt = null;
	String message_text2 = "";
	String status="";
	String exceptions="";
	HashMap<String, String> result_hm=new HashMap<String, String>();
	MessageManager mm=new MessageManager();
		
	ArrayList<?> row_arr = (ArrayList<?>) details_hm.get("row_details");
	ArrayList<?> gen_arr = (ArrayList<?>) details_hm.get("gen_details");
	
	  
    try
	{
		if(connection==null) connection = ConnectionManager.getConnection();
      
      }
      catch(Exception exp)
      {

		 System.out.println("Error in calling getconnection method of DataGroupIdAddModifyServlet  :"+exp.toString());
		exp.printStackTrace(System.err);
		exceptions=exceptions+"1"+"*"+exp.toString();
        
      }
 
	
	try
	{

// 	 ostmt = connection.prepareCall("{ call Xg_prc.xh_data_group(?,?,?,?,?,?,?) }" ); 

 	 ostmt = connection.prepareCall("{ call Xg_prc.xh_data_group(?,?,?,?,?,?,?,?,?,?) }" ); 

		  String  p_mode=(String)row_arr.get(0);
//	   		  System.out.println("callEJB p_mode : "+p_mode);
   	      String  dg_code=(String)row_arr.get(1);
		  String  dg_desc=(String)row_arr.get(2);
//   			  System.out.println("callEJB dg_desc : "+dg_desc);
	  	  String  standard_code=(String)row_arr.get(3);
		  String  application_id=(String)row_arr.get(4);
		  String protocol_mode=(String)row_arr.get(5);
	

//          String  lang_id=(String)row_arr.get(3);

		  String  usr_added_by_id=(String)gen_arr.get(0);
//		      		System.out.println("callEJB usr_added_by_id : "+usr_added_by_id);

		  String  usr_added_at_ws_no=(String)gen_arr.get(1);
//		      		System.out.println("callEJB usr_added_at_ws_no : "+usr_added_at_ws_no);

		 
		 ostmt.setString(1,p_mode);
		 ostmt.setString(2,dg_code);
		 ostmt.setString(3,dg_desc);
		 ostmt.setString(4,application_id);
 		 ostmt.setString(5,standard_code);
         ostmt.setString(6,protocol_mode);
		 
		 ostmt.setString(7,usr_added_by_id);
		 ostmt.setString(8,usr_added_at_ws_no);


	     ostmt.registerOutParameter(9,java.sql.Types.VARCHAR);
	     ostmt.registerOutParameter(10,java.sql.Types.VARCHAR);
	     ostmt.execute();
	 
		 String status2= ostmt.getString(9);
//	 	 		System.out.println("callEJB status2 : "+status2);
	     message_text2 = ostmt.getString(10);
//				System.out.println("callEJB message_text2 : "+message_text2);

	     ostmt.close();

		if(status2.equals("0"))
		{
                connection.commit();
                final java.util.Hashtable mesg = mm.getMessage(locale, "XH1001", "XH") ;
				//final java.util.Hashtable mesg =  mm.getMessage(connection,"XH1001") ;
			    status = ((String) mesg.get("message"));
			    mesg.clear();
		}
		else if(status2.equals("2"))
		{
			    connection.commit();
				final java.util.Hashtable mesg = mm.getMessage(locale, "CODE_ALREADY_EXISTS", "Common") ;
		//		final java.util.Hashtable mesg = mm.getMessage(connection, "XH1024") ;
			    status = ((String) mesg.get("message"));
			    mesg.clear();
		}
		else if(status2.equals("3"))
		{
			    connection.commit();
				final java.util.Hashtable mesg = mm.getMessage(locale, "XH0053", "XH") ;
				//final java.util.Hashtable mesg =  mm.getMessage(connection,"XH0053") ;
			    status = ((String) mesg.get("message"));			
//				status = "Child record found in xh_data_group_detail";
			    mesg.clear();
		}
        else
		{
                connection.rollback();
                final java.util.Hashtable mesg = mm.getMessage(locale, "XH1000", "XH") ;
				//final java.util.Hashtable mesg = mm.getMessage(connection, "XH1000") ;
				status = ((String) mesg.get("message"));	
				status = status+message_text2;
				mesg.clear();
		}

	 XHDBAdapter.closeCursor(ostmt);
	 
	 row_arr.clear();
	 gen_arr.clear();
	
	}catch(Exception ex)
	{ 
		System.out.println("Error in calling dbrelated statements in callejb method of DataGroupIdAddModifyServlet  :"+ex.toString());
		exceptions=exceptions+"3"+"*"+ex.toString();
		ex.printStackTrace(System.err);

	}
	 try{
		ConnectionManager.returnConnection(connection);
	}catch(Exception ex){ System.out.println("Error in closing dbrealted statements in callejb method of DataGroupIdAddModifyServlet :"+ex.toString());
		   ex.printStackTrace(System.err); }
//	 System.out.println("status "+status);   
	    
//	status=message_text2;
	result_hm.put("exceptions",exceptions);
	result_hm.put("status",status);

	return result_hm;  
}// end of function



}// end of class
