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
 *  Class used to update InterfaceStandard setup
 *
 */
public class InterfaceStandardCtrllStructureServlet extends HttpServlet
{
	HttpServletRequest req=null;
	/**
	 * Do post method which implements the functionalities for InterfaceStandard setup
	 * @param  HttpServletRequest request
	 * @param  HttpServletResponse response
	 */

	public void doPost (HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException 
	{
		PrintWriter out;
		out=response.getWriter();
		req=request;
		String status="";
		Connection connection = null;
    	CallableStatement ostmt = null;
	    String message_text2 = "";
	   	MessageManager mm=new MessageManager();
	    String exceptions="";
	  
		HttpSession session=request.getSession(false);
		Properties p;		
		p = (Properties) session.getValue("jdbc");	
		 String locale  = p.getProperty("LOCALE");
		request.setCharacterEncoding("UTF-8");
   	    response.setContentType("text/html;charset=UTF-8");
		String p_mode=request.getParameter("act_mode");	
		String segment_type_id=XHDBAdapter.checkNull(request.getParameter("segment_type_id"));
		String standard_desc=XHDBAdapter.checkNull(request.getParameter("element_seq"));

		if(standard_desc.equals("")||standard_desc.equals(null))
		{
standard_desc="1";
		}
		

		String ele_val_id=XHDBAdapter.checkNull(request.getParameter("ele_val_id"));
		String standard_code1=XHDBAdapter.checkNull(request.getParameter("standard_code"));
		String Control_id=XHDBAdapter.checkNull(request.getParameter("element_controlID"));
		String msg_start=request.getParameter("def_val_id");	
    	ArrayList array_audit=null;
		array_audit=new ArrayList();
		array_audit = ArrayAuditInfo.getArrayAuditInfo(session);		
try
	{
		if(connection==null) connection = ConnectionManager.getConnection();
      
      }
      catch(Exception exp)
      {

		 System.out.println("Error in calling getconnection method of InterfaceStandardAddModifyServlet  :"+exp.toString());
		exp.printStackTrace(System.err);
		exceptions=exceptions+"1"+"*"+exp.toString();
        
      }
 
	
	try
	{

	 ostmt = connection.prepareCall("{ call xg_prc.xh_standard_control_seg(?,?,?,?,?,?,?,?,?,?,?) }" ); 
  
		  String  usr_added_by_id=(String)array_audit.get(0);
		  String  usr_added_at_ws_no=(String)array_audit.get(1);
		 
		 
		 ostmt.setString(1,p_mode);

//	   System.out.println("Call EJB p_mode : "+p_mode);

         ostmt.setString(2,segment_type_id);
//		 	   System.out.println("Call standard_code : "+segment_type_id);
		 ostmt.setString(3,ele_val_id);
//	   System.out.println("Call standard_type : "+ele_val_id);
         ostmt.setInt(4,Integer.parseInt(standard_desc));
//	   System.out.println("Call standard_desc : "+standard_desc);
         ostmt.setString(5,msg_start);
//		 	   System.out.println("Call msg_start : "+msg_start);
         ostmt.setString(6,usr_added_by_id);
         ostmt.setString(7,usr_added_at_ws_no);
        ostmt.setString(8,standard_code1);
		ostmt.setString(9,Control_id);
        ostmt.registerOutParameter(10,java.sql.Types.VARCHAR);
	    ostmt.registerOutParameter(11,java.sql.Types.VARCHAR);

       ostmt.execute();
	   String status2= ostmt.getString(10);
//			 System.out.println("Call EJB status2 : "+status2);
	     message_text2 = ostmt.getString(11);

	     ostmt.close();
	    
//	     if(message_text2.equals("0"))
	     if(status2.equals("0"))
		{
		connection.commit();
final java.util.Hashtable mesg = mm.getMessage(locale, "XH1001", "XH") ;
	  		    status = ((String) mesg.get("message"));
        RequestDispatcher reqDis = 	session.getServletContext().getRequestDispatcher("/eXH/jsp/DisplayResult.jsp?message="+status);
        reqDis.forward(request,response);	

		}
	 else
		{
		 connection.rollback();
		 final java.util.Hashtable mesg = mm.getMessage(locale, "XH1000", "XH") ;
	  		    status = ((String) mesg.get("message"));
		  RequestDispatcher reqDis = 	session.getServletContext().getRequestDispatcher("/eXH/jsp/DisplayResult.jsp?message="+status);
        reqDis.forward(request,response);	
		}
	 XHDBAdapter.closeCursor(ostmt);
	
	}catch(Exception ex)
	{ 
		 System.out.println("Error in calling dbrelated statements in callejb method of InterfaceStandardAddModifyServlett  :"+ex.toString());
		exceptions=exceptions+"3"+"*"+ex.toString();
		ex.printStackTrace(System.err);

	}
	 try{
		ConnectionManager.returnConnection(connection);
	}catch(Exception ex){ System.out.println("Error in closing dbrealted statements in callejb method of InterfaceStandardAddModifyServlet :"+ex.toString());
		   ex.printStackTrace(System.err); }
	 
		
		
        
	}// end of do post

 /**
	 * callEJB method is used to call InterfaceStandardAddModifyServlet setup related database procedures
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

		 System.out.println("Error in calling getconnection method of InterfaceStandardAddModifyServlet  :"+exp.toString());
		exp.printStackTrace(System.err);
		exceptions=exceptions+"1"+"*"+exp.toString();
        
      }
 
	
	try
	{

	 ostmt = connection.prepareCall("{ call xg_prc.xh_standard_control_seg(?,?,?,?,?,?,?,?,?,?) }" ); 

		  String  p_mode=(String)row_arr.get(0);
   	      String  standard_code=(String)row_arr.get(1);
		  String  standard_desc=(String)row_arr.get(2);
		  String  standard_type=(String)row_arr.get(3);
		  String  msg_start=(String)row_arr.get(4);
		  String standard_code11=(String)row_arr.get(5);
		//  String  msg_end=(String)row_arr.get(5);
		//  String  seg_start=(String)row_arr.get(6);
		//  String  seg_end=(String)row_arr.get(7);
   	    //  String  fld_separator=(String)row_arr.get(8);
		//  String  elmnt_separator=(String)row_arr.get(9);
 //       String  lang_id=(String)row_arr.get(23);
   
		  String  usr_added_by_id=(String)gen_arr.get(0);
		  String  usr_added_at_ws_no=(String)gen_arr.get(1);

		 ostmt.setString(1,p_mode);
         ostmt.setString(2,standard_code11);
		 ostmt.setString(3,standard_code);
         ostmt.setInt(4,Integer.parseInt(standard_desc));
         ostmt.setString(5,standard_type);
         ostmt.setString(6,msg_start);
        ostmt.setString(7,usr_added_by_id);
        ostmt.setString(8,usr_added_at_ws_no);

 ostmt.registerOutParameter(9,java.sql.Types.VARCHAR);
	     ostmt.registerOutParameter(10,java.sql.Types.VARCHAR);

	//		 System.out.println("Call EJB p_mode : "+p_mode);
		 /*ostmt.setString(2,standard_code);
  	 		 System.out.println("Call EJB standard_code : "+standard_code);
	     ostmt.setString(3,standard_desc);
		 ostmt.setString(4,standard_type);
 	 		 System.out.println("Call EJB standard_type : "+standard_type);
		 ostmt.setString(5,msg_start);
  	 		 System.out.println("Call EJB msg_start : "+msg_start);
		 ostmt.setString(6,msg_end);
		 ostmt.setString(7,seg_start);
		 ostmt.setString(8,seg_end);
   	 		 System.out.println("Call EJB seg_end : "+seg_end);
		 ostmt.setString(9,fld_separator);
	     ostmt.setString(10,elmnt_separator);
   	 		 System.out.println("Call EJB elmnt_separator : "+elmnt_separator);
	//	 ostmt.setString(23,lang_id);
		 		 		  
		 ostmt.setString(11,usr_added_by_id);
		 ostmt.setString(12,usr_added_at_ws_no);
	 
	     ostmt.registerOutParameter(13,java.sql.Types.VARCHAR);
	     ostmt.registerOutParameter(14,java.sql.Types.VARCHAR);*/
	     ostmt.execute();
	
	     String status2= ostmt.getString(9);
	 		 System.out.println("Call EJB status2 : "+status2);
	     message_text2 = ostmt.getString(10);

	     ostmt.close();
	    
//	     if(message_text2.equals("0"))
	     if(status2.equals("0"))
		{
		connection.commit();
		}
	 else
		{
		 connection.rollback();
		}
	 XHDBAdapter.closeCursor(ostmt);
	
	}catch(Exception ex)
	{ 
		 System.out.println("Error in calling dbrelated statements in callejb method of InterfaceStandardAddModifyServlett  :"+ex.toString());
		exceptions=exceptions+"3"+"*"+ex.toString();
		ex.printStackTrace(System.err);

	}
	 try{
		ConnectionManager.returnConnection(connection);
	}catch(Exception ex){ System.out.println("Error in closing dbrealted statements in callejb method of InterfaceStandardAddModifyServlet :"+ex.toString());
		   ex.printStackTrace(System.err); }
//	 System.out.println("status "+status);   
	    
	status=message_text2;
	result_hm.put("exceptions",exceptions);
	result_hm.put("status",status);

	return result_hm;  
}// end of callEJB function



}// end of class
