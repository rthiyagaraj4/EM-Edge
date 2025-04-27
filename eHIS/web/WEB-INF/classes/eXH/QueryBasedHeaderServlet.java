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
 *  Class used to update InboundDataMapping Header setup
 *
 */
public class QueryBasedHeaderServlet extends HttpServlet
{
	HttpServletRequest req=null;
	/**
	 * Do post method which implements the functionalities for InboundDataMapping Header  setup
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
		String profile_id=XHDBAdapter.checkNull(request.getParameter("profile_id"));

		ArrayList arrColumn=null;
		ArrayList array_audit=null;
		
		arrColumn=new ArrayList();

		arrColumn.add(p_mode);
		arrColumn.add(application_id);
		arrColumn.add(facility_id);
		arrColumn.add(profile_id);
		arrColumn.add(event_type);
		arrColumn.add(segment_type);
		arrColumn.add(inboundapi_id);
		
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
	 * callEJB method is used to call InboundDataMapping Header setup related database procedures
	 * @param  HashMap details_hm
	 * @param  String locale
	 */
	public HashMap callEJB(HashMap details_hm,String locale )
   {    

	Connection connection = null;
	CallableStatement ostmt = null;

	Statement stmt = null;
	ResultSet resultset = null;

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

		 System.out.println("Error in calling getconnection method of QueryBasedHeaderServlet  :"+exp.toString());
		exp.printStackTrace(System.err);
		exceptions=exceptions+"1"+"*"+exp.toString();
        
      }
 
	
	try
	{

 	 ostmt = connection.prepareCall("{ call Xg_prc.xh_inbound_header(?,?,?,?,?,?,?,?,?,?,?) }" ); 

		  String  p_mode=(String)row_arr.get(0);      
		  String  application_id=(String)row_arr.get(1);
   // 		System.out.println("callEJB application_id : "+application_id);
          String  facility_id=(String)row_arr.get(2);		  
   // 	   		System.out.println("callEJB facility_id : "+facility_id);
		  String  profile_id=(String)row_arr.get(3);		  
   //	   		System.out.println("callEJB profile_id : "+profile_id);
		  String  event_type=(String)row_arr.get(4);
		  String  segment_type=(String)row_arr.get(5);
	      String  inboundapi_id=(String)row_arr.get(6);

		  String  usr_added_by_id=(String)gen_arr.get(0);
	//	      		System.out.println("callEJB usr_added_by_id : "+usr_added_by_id);
		  String  usr_added_at_ws_no=(String)gen_arr.get(1);
	//	      		System.out.println("callEJB usr_added_at_ws_no : "+usr_added_at_ws_no);
		 
		 ostmt.setString(1,p_mode);
		 ostmt.setString(2,application_id);
		 ostmt.setString(3,facility_id);
 		 ostmt.setString(4,profile_id);
		 ostmt.setString(5,event_type);
		 ostmt.setString(6,segment_type);
		 ostmt.setString(7,inboundapi_id);
	 		 		  
		 ostmt.setString(8,usr_added_by_id);
		 ostmt.setString(9,usr_added_at_ws_no);


	     ostmt.registerOutParameter(10,java.sql.Types.VARCHAR);
	     ostmt.registerOutParameter(11,java.sql.Types.VARCHAR);
	     ostmt.execute();
	
		 String status2= ostmt.getString(10);
	     message_text2 = ostmt.getString(11);

	     ostmt.close();
	    
 		if(status2.equals("0"))
		{
			connection.commit();
			final java.util.Hashtable mesg = mm.getMessage(locale, "XH1001", "XH") ;
			status = ((String) mesg.get("message"));

		if(p_mode.equals("I")){

	String sql1 = 	"SELECT sno,argument_id,argument_name FROM xh_api_details WHERE api_code='"+inboundapi_id+"'";
			
	 stmt = connection.createStatement();
	 resultset	=	stmt.executeQuery(sql1);
     String srl_no = "";
	 String arg_id = "";
 	 String arg_name = "";
//  	 String stnd_code = "";

// 	String profile_id = "";
	String element_pos = "";
	String element_val = "";

	 ArrayList argMultiple=new ArrayList();
	 ArrayList argRow=new ArrayList();

	  while(resultset.next()){

		   argRow=new ArrayList();

		  	srl_no        = 	XHDBAdapter.checkNull(resultset.getString(1));
			arg_id        = 	XHDBAdapter.checkNull(resultset.getString(2));
			arg_name   = 	XHDBAdapter.checkNull(resultset.getString(3));
//			stnd_code  = 	XHDBAdapter.checkNull(resultset.getString(4));

			argRow.add(srl_no);
			argRow.add(arg_id);
			argRow.add(arg_name);
//   		    argRow.add(stnd_code);
	
			argMultiple.add(argRow);

		  }

	ArrayList arrRow = new ArrayList();
	
	for (int j=0;j<argMultiple.size();j++)
	{
	   arrRow=new ArrayList();
		arrRow = (ArrayList)argMultiple.get(j);

          srl_no			=	(String)arrRow.get(0);
		  arg_id			=	(String)arrRow.get(1);
		  arg_name	=	(String)arrRow.get(2);
//   	      stnd_code	=	XHDBAdapter.checkNull((String)arrRow.get(3));
		 	
	 ostmt = connection.prepareCall("{ call Xg_prc.xh_inbound_api_dtl(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }" ); 

		 ostmt.setString(1,p_mode);
 		 ostmt.setString(2,application_id);
		 ostmt.setString(3,facility_id);
		 ostmt.setString(4,event_type);
		 ostmt.setString(5,segment_type);
		 ostmt.setString(6,inboundapi_id);
		 ostmt.setString(7,srl_no);
		 ostmt.setString(8,arg_id);
		 ostmt.setString(9,arg_name);
 		 ostmt.setString(10,element_pos);
		 ostmt.setString(11,element_val);
  		 ostmt.setString(12,profile_id);

		 ostmt.setString(13,usr_added_by_id);
		 ostmt.setString(14,usr_added_at_ws_no);

	     ostmt.registerOutParameter(15,java.sql.Types.VARCHAR);
	     ostmt.registerOutParameter(16,java.sql.Types.VARCHAR);
	     ostmt.execute();
		
		 status2= ostmt.getString(15);
	     message_text2 = ostmt.getString(16);
	     ostmt.close();
	/*	 if(arrRow!=null)
		{
			arrRow.clear();
		} */
	    }  // end of for
	    
		if(status2.equals("0"))
		{
		    connection.commit();
			final java.util.Hashtable mesg2 = mm.getMessage(locale, "XH1001", "XH") ;
//			final java.util.Hashtable mesg = mm.getMessage(locale, "XH1001", "XH") ;
//			status = ((String) mesg.get("message"));
			status = ((String) mesg2.get("message"));

		}
	   } // end of p_mode 'I'

//			final java.util.Hashtable mesg = mm.getMessage(locale, "XH1001", "XH") ;
//			status = ((String) mesg.get("message"));
	
	   } // status2.equals("0")
   
   		else if(status2.equals("2"))
		{
			    connection.commit();
				final java.util.Hashtable mesg = mm.getMessage(locale, "CODE_ALREADY_EXISTS", "Common") ;
			    status = ((String) mesg.get("message"));			
		}
		else
		{
                connection.rollback();
				final java.util.Hashtable mesg = mm.getMessage(locale, "XH1000", "XH") ;
				status = ((String) mesg.get("message"));		
		}

	 XHDBAdapter.closeCursor(ostmt);
	
	}
	catch(Exception ex)
	{ 
		System.out.println("Error in calling dbrelated statements in callejb method of QueryBasedHeaderServlet  :"+ex.toString());
		exceptions=exceptions+"3"+"*"+ex.toString();
		ex.printStackTrace(System.err);

	}
//   }
	 try{
 	     if(resultset!=null) resultset.close();
		 if(stmt!=null) stmt.close();
		ConnectionManager.returnConnection(connection);
	}catch(Exception ex){ System.out.println("Error in closing dbrealted statements in callejb method of QueryBasedHeaderServlet :"+ex.toString());
		   ex.printStackTrace(System.err); }
//	 System.out.println("status "+status);   
	    
//	status=message_text2;
	result_hm.put("exceptions",exceptions);
	result_hm.put("status",status);

	return result_hm;  
}// end of function



}// end of class
