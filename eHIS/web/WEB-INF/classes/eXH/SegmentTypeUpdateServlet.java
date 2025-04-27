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
import javax.servlet.*;

/**
 *  Class used to update the segment values setup
 *
 */

public class SegmentTypeUpdateServlet extends HttpServlet
{
	HttpServletRequest req=null;

    /**
	 * Do post method which implements the functionalities for segment updation
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
	
		ResultSet rs1=null;
		Statement stmt1=null;
		Connection con=null;
		String segment_type="";
		
		
		ArrayList arrMultiple=new ArrayList();
		ArrayList arrColumn=null;
		ArrayList array_audit=null;
		try
		{

			con=ConnectionManager.getConnection();

			String sql1="SELECT SEGMENT_TYPE,IN_USE_YN FROM XH_SEGMENT WHERE OPTIONAL_YN='Y'ORDER BY SEGMENT_TYPE" ;
			stmt1=con.createStatement();
			rs1=stmt1.executeQuery(sql1);
			while(rs1.next())
			{
				segment_type=rs1.getString(1);
				
				arrColumn=new ArrayList();

				arrColumn.add(segment_type);
				arrColumn.add(XHDBAdapter.checkNullForCheckBox(request.getParameter(segment_type+"_select_yn")));

				arrColumn.add(XHDBAdapter.checkNull(request.getParameter(segment_type+"_file_ctrl_type")));

		//		System.out.println("sgmnt_type : "+segment_type);
		//		System.out.println("fl_ctrl_type : "+XHDBAdapter.checkNull(request.getParameter(segment_type+"_file_ctrl_type")));
				
				arrMultiple.add(arrColumn);
			}
	
		}catch(Exception e)
		{
			 System.out.println("Error in dopost method of segmenttypeupdateservlet :"+e.toString());
			e.printStackTrace(System.err);
		}

 finally{
	 try{
	if(rs1!=null)rs1.close();	
	 if(stmt1!=null)stmt1.close();
	 con.close();
	 }catch(Exception e)
		 {
			 System.out.println("Error in closing statement of dopost method of segmenttypeupdateservlet:"+e.toString());
			e.printStackTrace(System.err);
		 }
		}
	
	array_audit=new ArrayList();
	array_audit = ArrayAuditInfo.getArrayAuditInfo(session);

	HashMap details_hm= new HashMap();
	details_hm.put("row_details",arrMultiple);
	details_hm.put("gen_details",array_audit);

	HashMap result_hm=new HashMap();
	result_hm=callEJB(details_hm,locale);
		
    RequestDispatcher reqDis = 	session.getServletContext().getRequestDispatcher("/eXH/jsp/DisplayResult.jsp?message="+(String)result_hm.get("status"));
    reqDis.forward(request,response);		
	

	}// end of do post
   
	/**
	 * callEJB method is used to call segment related database procedures
	 * @param  HashMap details_hm
	 * @param  String locale
	 */

	public HashMap callEJB(HashMap details_hm,String locale)
    {
    

	Connection connection = null;
	CallableStatement ostmt = null;
	String message_text2 = "";
	
	String status="";
	String exceptions="";
	String sts="";
	HashMap result_hm=new HashMap();
	MessageManager mm=new MessageManager();

	ArrayList row_arr = (ArrayList) details_hm.get("row_details");
	ArrayList gen_arr = (ArrayList) details_hm.get("gen_details");
	
    try
	{
		if(connection==null)connection = ConnectionManager.getConnection();
           
	 }
      catch(Exception exp)
      {

		 System.out.println("Error in calling getconnection method in callejb method of segmenttypeupdateservlet :"+exp.toString());
		exp.printStackTrace(System.err);
		exceptions=exceptions+"1"+"*"+exp.toString();
        
      }
	
	ArrayList arrRow = null;
	
	for (int j=0;j<row_arr.size();j++)
	{
		arrRow = (ArrayList)row_arr.get(j);
	    try
	    {
		  status=status+"***"+arrRow;
 		  ostmt = connection.prepareCall("{ call xhmast.segment(?,?,?,?,?,?,?) }" ); 
		  
		  String  segment_type=(String)arrRow.get(0);
		  String  in_use_type=(String)arrRow.get(1);
	      String  file_control_type=(String)arrRow.get(2);

		  String  usr_added_by_id=(String)gen_arr.get(0);
		  String  usr_added_at_ws_no=(String)gen_arr.get(1);

		  ostmt.setString(1,in_use_type);
	  	  ostmt.setString(2,file_control_type);
		//	System.out.println("fl_ctrl_type : "+file_control_type);
		  ostmt.setString(3,segment_type);
		  
		  ostmt.setString(4,usr_added_by_id);
		  ostmt.setString(5,usr_added_at_ws_no);
		  
		  ostmt.registerOutParameter(6,java.sql.Types.VARCHAR);
		  ostmt.registerOutParameter(7,java.sql.Types.VARCHAR);
		  ostmt.execute(); 
		
		  sts =ostmt.getString(6);
 		  message_text2 = ostmt.getString(7);
		  if(sts.equals("0"))
		  {
			connection.commit();
			final java.util.Hashtable mesg = mm.getMessage(locale, "XH1001", "XH") ;
  	        message_text2 = ((String) mesg.get("message"));
		  }
		  else
		  {
		   
			connection.rollback();
			final java.util.Hashtable mesg = mm.getMessage(locale, "XH1000", "XH") ;
			 message_text2 = ((String) mesg.get("message"));
		  }

		 if(ostmt!=null) ostmt.close();
		 
	      }
	      catch(Exception ex)
	      {
			    System.out.println("Error in calling dbrealted statements in callejb method of segmenttypeupdateservlet:"+ex.toString());
		       ex.printStackTrace(System.err);
			  exceptions=exceptions+"2"+"*"+ex.toString();
		
	      }
	   }
	  
		try{
		if(connection!=null) ConnectionManager.returnConnection(connection);
	}catch(Exception ex){ System.out.println("Error in calling closing dbconnection method in segmenttypeupdateservlet:"+ex.toString());
		     ex.printStackTrace(System.err); }
	
	status=message_text2;
	result_hm.put("exceptions",exceptions);
	result_hm.put("status",status);
	return result_hm;  
}// end of function
	

}// end of class
