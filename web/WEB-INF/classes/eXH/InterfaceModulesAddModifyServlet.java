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
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.*;
import eXH.XHDBAdapter;
import eXH.ArrayAuditInfo;
/**
 *  Class used to update InterfaceModules setup
 *
 */
public class InterfaceModulesAddModifyServlet extends HttpServlet
{
	HttpServletRequest req=null;
	/**
	 * Do post method which implements the functionalities for InterfaceModules setup
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
		String module_id=XHDBAdapter.checkNull(request.getParameter("module_Id"));
		String sub_module_id=XHDBAdapter.checkNull(request.getParameter("sub_module_id"));
		String sub_module_desc=XHDBAdapter.checkNull(request.getParameter("sub_module_desc"));


//		String lang_id=XHDBAdapter.checkNull(request.getParameter("lang_id"));
		
		ArrayList arrColumn=null;
		ArrayList array_audit=null;
		
		arrColumn=new ArrayList();

		arrColumn.add(p_mode);
		arrColumn.add(module_id);
		arrColumn.add(sub_module_id);
		arrColumn.add(sub_module_desc);
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
        
        arrColumn.clear();
        array_audit.clear();
        details_hm.clear();
        result_hm.clear();


	}// end of do post

 /**
	 * callEJB method is used to call InterfaceModulesAddModifyServlet setup related database procedures
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

		 System.out.println("Error in calling getconnection method of InterfaceModulesAddModifyServlet  :"+exp.toString());
		exp.printStackTrace(System.err);
		exceptions=exceptions+"1"+"*"+exp.toString();
        
      }
 
	
	try
	{

	 ostmt = connection.prepareCall("{ call Xg_prc.xh_interface(?,?,?,?,?,?,?,?) }" ); 

		  String  p_mode=(String)row_arr.get(0);
   	      String  module_id=(String)row_arr.get(1);
   	      String  sub_module_id=(String)row_arr.get(2);
		  String  sub_module_desc=(String)row_arr.get(3);
 //       String  lang_id=(String)row_arr.get(23);
   
		  String  usr_added_by_id=(String)gen_arr.get(0);
		  String  usr_added_at_ws_no=(String)gen_arr.get(1);

		 ostmt.setString(1,p_mode);
//			 System.out.println("Call EJB p_mode : "+p_mode);
		 ostmt.setString(2,module_id);
//  	 		 System.out.println("Call EJB module_id : "+module_id);
 		 ostmt.setString(3,sub_module_id);
//  	 		 System.out.println("Call EJB sub_module_id : "+sub_module_id);
	     ostmt.setString(4,sub_module_desc);
//		 ostmt.setString(23,lang_id);
		 		 		  
		 ostmt.setString(5,usr_added_by_id);
		 ostmt.setString(6,usr_added_at_ws_no);
	 
	     ostmt.registerOutParameter(7,java.sql.Types.VARCHAR);
	     ostmt.registerOutParameter(8,java.sql.Types.VARCHAR);
	     ostmt.execute();
	
	     String status2= ostmt.getString(7);
//	 		 System.out.println("Call EJB status2 : "+status2);
	     message_text2 = ostmt.getString(8);

	     ostmt.close();
	    
		MessageManager mm=new MessageManager();
//			System.out.println("message_text2 "+message_text2);   
		if(status2.equals("0"))
			{
			connection.commit();
//			final java.util.Hashtable mesg = mm.getMessage(locale, "XH1001", "XH") ;
			final java.util.Hashtable mesg = mm.getMessage(connection, "XH1001") ;
			status = ((String) mesg.get("message"));
			mesg.clear();
//			 System.out.println("in commit ");   
			}
			else if(status2.equals("2"))
			{
					connection.commit();
		//			final java.util.Hashtable mesg = mm.getMessage(locale, "CODE_ALREADY_EXISTS", "Common") ;
					final java.util.Hashtable mesg = mm.getMessage(connection, "XH1024") ;
					status = ((String) mesg.get("message"));	
					mesg.clear();
			}
		 else
			{
					connection.rollback();
			// 	    final java.util.Hashtable mesg = mm.getMessage(locale, "XH1000", "XH") ;
				    final java.util.Hashtable mesg = mm.getMessage(connection, "XH1000") ;
					status = ((String) mesg.get("message"));
					mesg.clear();
			}
	 XHDBAdapter.closeCursor(ostmt);
	
	}catch(Exception ex)
	{ 
		 System.out.println("Error in calling dbrelated statements in callejb method of InterfaceModulesAddModifyServlet  :"+ex.toString());
		exceptions=exceptions+"3"+"*"+ex.toString();
		ex.printStackTrace(System.err);

	}
	 try{
		ConnectionManager.returnConnection(connection);
	}catch(Exception ex){ System.out.println("Error in closing dbrealted statements in callejb method of InterfaceModulesAddModifyServlet :"+ex.toString());
		   ex.printStackTrace(System.err); }
//	 System.out.println("status "+status);   
	    
//	status=message_text2;
	result_hm.put("exceptions",exceptions);
	result_hm.put("status",status);

	row_arr.clear();
	gen_arr.clear();
	return result_hm;  
}// end of callEJB function



}// end of class
