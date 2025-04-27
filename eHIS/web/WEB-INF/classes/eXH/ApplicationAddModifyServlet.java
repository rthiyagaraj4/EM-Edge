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
 *  Class used to update application  setup
 *
 */
public class ApplicationAddModifyServlet extends HttpServlet
{
	HttpServletRequest req=null;
	/**
	 * Do post method which implements the functionalities for application  setup
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
		

		
		String appl_id=XHDBAdapter.checkNull(request.getParameter("appl_id"));
		String appl_name=XHDBAdapter.checkNull(request.getParameter("appl_name"));
//		String facility=XHDBAdapter.checkNull(request.getParameter("facility"));
		String field_seperator=XHDBAdapter.checkNull(request.getParameter("field_sep")); 
		String enabled=XHDBAdapter.checkNullForCheckBox(request.getParameter("in_use"));
		String lang_id=XHDBAdapter.checkNull(request.getParameter("lang_id"));
		String p_mode=XHDBAdapter.checkNull(request.getParameter("act_mode"));

		ArrayList arrColumn=null;
		ArrayList array_audit=null;
		
		arrColumn=new ArrayList();

		arrColumn.add(p_mode);
		arrColumn.add(appl_id);
		arrColumn.add(appl_name);
//		arrColumn.add(facility);
		arrColumn.add(field_seperator);
//		arrColumn.add(enabled);

		if(enabled != null && !enabled.equals("N")){
			arrColumn.add("Y");
		}
		else{
			arrColumn.add("N");
		}

		arrColumn.add(lang_id);
		
		array_audit=new ArrayList();
		array_audit = ArrayAuditInfo.getArrayAuditInfo(session);

		

		HashMap details_hm= new HashMap();
		details_hm.put("row_details",arrColumn);
		details_hm.put("gen_details",array_audit);
		HashMap result_hm=new HashMap();
		result_hm=callEJB(details_hm,locale );
	
		
       RequestDispatcher reqDis = 	session.getServletContext().getRequestDispatcher("/eXH/jsp/DisplayResult.jsp?message="+(String)result_hm.get("status"));
       reqDis.forward(request,response);	
       
       arrColumn.clear();
       array_audit.clear();
       details_hm.clear();
       result_hm.clear();       


	}// end of do post

 /**
	 * callEJB method is used to call application  setup related database procedures
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
		
	ArrayList row_arr = (ArrayList) details_hm.get("row_details");
	ArrayList gen_arr = (ArrayList) details_hm.get("gen_details");
	
	  
    try
	{
		if(connection==null) connection = ConnectionManager.getConnection();
      
      }
      catch(Exception exp)
      {

		 System.out.println("Error in calling getconnection method of applicationaddmodifyservlet  :"+exp.toString());
		exp.printStackTrace(System.err);
		exceptions=exceptions+"1"+"*"+exp.toString();
        
      }
 
	
	try
	{

// removed facility	param ostmt = connection.prepareCall("{ call xhmast.application(?,?,?,?,?,?,?,?,?,?,?) }" ); 
 	 ostmt = connection.prepareCall("{ call xhmast.application(?,?,?,?,?,?,?,?,?,?) }" ); 

	 
		  String  p_mode=(String)row_arr.get(0);
  //	  			System.out.println("p_mode : "+p_mode);
   	      String  appl_id=(String)row_arr.get(1);
//	  			System.out.println("appl_id : "+appl_id);
		  String  appl_name=(String)row_arr.get(2);
//	  			System.out.println("appl_name : "+appl_name);
 /*         String  facility=(String)row_arr.get(3);
  	  			System.out.println("facility : "+facility); */
		  String  field_seperator=(String)row_arr.get(3);
//	  			System.out.println("field_seperator : "+field_seperator);
		  String  enabled_tag=(String)row_arr.get(4);
//				System.out.println("enabled_tag : "+enabled_tag);
		  String  lang_id=(String)row_arr.get(5);
//		System.out.println("lang_id :"+lang_id);

		  String  usr_added_by_id=(String)gen_arr.get(0);
		  String  usr_added_at_ws_no=(String)gen_arr.get(1);
		 
		 ostmt.setString(1,p_mode);
		 ostmt.setString(2,appl_id);
		 ostmt.setString(3,appl_name);
		 ostmt.setString(4,field_seperator);
//		 ostmt.setString(5,facility);
		 ostmt.setString(5,enabled_tag);
		 ostmt.setString(6,lang_id);
		 		 		  
		 ostmt.setString(7,usr_added_by_id);
		 ostmt.setString(8,usr_added_at_ws_no);


	 ostmt.registerOutParameter(9,java.sql.Types.VARCHAR);
	 ostmt.registerOutParameter(10,java.sql.Types.VARCHAR);
	 ostmt.execute();

//	boolean chkStat=false;
	String status2 = ostmt.getString(9);
//	System.out.println("status2 : "+status2);
	message_text2  = XHDBAdapter.checkNull(ostmt.getString(10));
	ostmt.close();
	
//	chkStat=containsSubstring(status2,"Unique");

	MessageManager mm=new MessageManager();
//	 System.out.println("message_text2 "+message_text2);   
	if(status2.equals("0"))
		{
		connection.commit();
		final java.util.Hashtable mesg = mm.getMessage(locale, "XH1001", "XH") ;
		//final java.util.Hashtable mesg = mm.getMessage(connection, "XH1001") ;
		status = ((String) mesg.get("message"));
//		 System.out.println("in commit "+locale);   
		mesg.clear();
		}
		else if(status2.equals("2"))
		{
			    connection.commit();
			final java.util.Hashtable mesg = mm.getMessage(locale, "CODE_ALREADY_EXISTS", "Common") ;
				//final java.util.Hashtable mesg = mm.getMessage(connection, "XH1024") ;
			    status = ((String) mesg.get("message"));
			    mesg.clear();
		}
		else if(status2.equals("3"))
		{
			    connection.commit();
				final java.util.Hashtable mesg = mm.getMessage(locale, "XH0053", "XH") ;
			//	final java.util.Hashtable mesg = mm.getMessage(connection, "XH0053") ;
			    status = ((String) mesg.get("message"));			
//				status = "Child record found in xh_data_group_detail for the data_group_id, cannot delete xh_data_group record";
			    mesg.clear();
		}
	 else
		{
		 connection.rollback();
//		 System.out.println("in rollback chkStat :"+chkStat);   
/*
		 if(chkStat)
		 {
		  System.out.println("in rollback if ");   
		  final java.util.Hashtable mesg = mm.getMessage(locale, "XH1024", "XH") ;
		  message_text2 = ((String) mesg.get("message"));
		 
		 }
		 else {
			 System.out.println("in rollback else ");   
			 */
		 final java.util.Hashtable mesg = mm.getMessage(locale, "XH1000", "XH") ;
 		// final java.util.Hashtable mesg = mm.getMessage(connection, "XH1000") ;
		 status = ((String) mesg.get("message"));
		 mesg.clear();
//		 }
		}
	 XHDBAdapter.closeCursor(ostmt);
	
	}catch(Exception ex)
	{ 
		 System.out.println("Error in calling dbrelated statements in callejb method of applicationaddmodifyservlet  :"+ex.toString());
		exceptions=exceptions+"3"+"*"+ex.toString();
		ex.printStackTrace(System.err);

	}
	 try{ 
		ConnectionManager.returnConnection(connection);
	}catch(Exception ex){ System.out.println("Error in closing dbrealted statements in callejb method of applicationaddmodifyservlet :"+ex.toString());
		   ex.printStackTrace(System.err); }
//	 System.out.println("status "+status);   
	    
//	status=message_text2;
	result_hm.put("exceptions",exceptions);
	result_hm.put("status",status);
	
	row_arr.clear();
	gen_arr.clear();

	return result_hm;  
}// end of function

/**
	 * containsSubstring method which finds the sub string exists in main strinng 
	 * @param  String mainString
	 * @param  String subString
	 */

	 public boolean  containsSubstring(String mainString, String subString)
  {
     boolean status = false; 
     Pattern pattern = Pattern.compile(subString);
	 Matcher matcher = pattern.matcher(mainString); 
	 status = matcher.find();
	 return status; 
  }


}// end of class
