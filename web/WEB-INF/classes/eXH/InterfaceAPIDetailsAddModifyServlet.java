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
 *  Class used to update InterfaceAPI setup
 *
 */
public class InterfaceAPIDetailsAddModifyServlet extends HttpServlet
{
	HttpServletRequest req=null;
	/**
	 * Do post method which implements the functionalities for InterfaceAPIDetails setup
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
//			System.out.println("Dtlsrvlt p_mode : "+p_mode);
		String api_code=XHDBAdapter.checkNull(request.getParameter("api_code"));
//			System.out.println("Dtlsrvlt api_code : "+api_code);
		String srl_no=XHDBAdapter.checkNull(request.getParameter("srl_no"));
//			System.out.println("Dtlsrvlt srl_no : "+srl_no);
		String arg_id=XHDBAdapter.checkNull(request.getParameter("arg_id"));
		String arg_name=XHDBAdapter.checkNull(request.getParameter("arg_name"));

		String stnd_code=XHDBAdapter.checkNull(request.getParameter("stnd_code"));
		String sub_api=XHDBAdapter.checkNull(request.getParameter("sub_api"));
		
//		String lang_id=XHDBAdapter.checkNull(request.getParameter("lang_id"));
		
		ArrayList arrColumn=null;
		ArrayList array_audit=null;
		
		arrColumn=new ArrayList();

		arrColumn.add(p_mode);
		arrColumn.add(api_code);
		arrColumn.add(srl_no);
		arrColumn.add(arg_id);
		arrColumn.add(arg_name);

		arrColumn.add(stnd_code);
		arrColumn.add(sub_api);

  //	arrColumn.add(lang_id);
		   
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
	 * callEJB method is used to call InterfaceAPIDtlAddModifyServlet setup related database procedures
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

		 System.out.println("Error in calling getconnection method of InterfaceAPIDetailsServlet  :"+exp.toString());
		exp.printStackTrace(System.err);
		exceptions=exceptions+"1"+"*"+exp.toString();
        
      }
 
	
	try
	{

 	 ostmt = connection.prepareCall("{ call Xg_prc.xh_api_details(?,?,?,?,?,?,?,?,?,?) }" ); 

		  String  p_mode=(String)row_arr.get(0);
   	      String  api_code=(String)row_arr.get(1);
		  String  srl_no=(String)row_arr.get(2);
		  String  arg_id=(String)row_arr.get(3);
		  String  arg_name=(String)row_arr.get(4);
 //       String  lang_id=(String)row_arr.get(23);

	 	  String  stnd_code=(String)row_arr.get(5);
		  String  sub_api=(String)row_arr.get(6);
   
		  String  usr_added_by_id=(String)gen_arr.get(0);
//		  String  usr_added_at_ws_no=(String)gen_arr.get(1);

		 ostmt.setString(1,p_mode);
//			 System.out.println("Call EJB p_mode : "+p_mode);
	 	 ostmt.setString(2,api_code);
//  	 		 System.out.println("Call EJB api_code : "+api_code);
		 ostmt.setString(3,srl_no);
//  	 		 System.out.println("Call EJB srl_no : "+srl_no);
	     ostmt.setString(4,arg_id);
		 ostmt.setString(5,arg_name);
// 	 		 System.out.println("Call EJB arg_name : "+arg_name);
		 ostmt.setString(6,stnd_code);
 //	 		 System.out.println("Call EJB stnd_code : "+stnd_code);
		//	 ostmt.setString(23,lang_id);
		 		 		  
		 ostmt.setString(7,usr_added_by_id);
	 	 ostmt.setString(8,sub_api);

	     ostmt.registerOutParameter(9,java.sql.Types.VARCHAR);
	     ostmt.registerOutParameter(10,java.sql.Types.VARCHAR);
	     ostmt.execute();
	
	     String status2= ostmt.getString(9);
//	 		 System.out.println("Call EJB status2 : "+status2);
	     message_text2 = ostmt.getString(10);

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
	
	}catch(Exception ex)
	{ 
		 System.out.println("Error in calling dbrelated statements in callejb method of InterfaceAPIDtlModifyServlet  :"+ex.toString());
		exceptions=exceptions+"3"+"*"+ex.toString();
		ex.printStackTrace(System.err);

	}
	 try{
		ConnectionManager.returnConnection(connection);
	}catch(Exception ex){ System.out.println("Error in closing dbrealted statements in callejb method of InterfaceAPIDtlAddModifyServlet :"+ex.toString());
		   ex.printStackTrace(System.err); }
//	 System.out.println("status "+status);   
	    
//	status=message_text2;
	result_hm.put("exceptions",exceptions);
	result_hm.put("status",status);

	return result_hm;  
}// end of callEJB function



}// end of class
