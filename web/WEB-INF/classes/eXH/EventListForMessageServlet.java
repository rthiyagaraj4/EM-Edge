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
 * Class used to update  Event list for message type
 */
public class EventListForMessageServlet extends HttpServlet
{
	HttpServletRequest req=null;
	/**
	 * Do post method which implements the functionalities of  Event list for message type
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

        req.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
	
		ResultSet rs1=null;
		Statement stmt1=null;
		Connection con=null;
		String msg_type=request.getParameter("message_type");
		String stnd_code=request.getParameter("stnd_code");
	//		System.out.println("stnd_code : "+stnd_code);
		
		String event_type="";
		String comm_type="";
		
		ArrayList arrMultiple=new ArrayList();
		ArrayList arrColumn=null;
		ArrayList array_audit=null;
		try
		{

			con=ConnectionManager.getConnection();

			String sql1=" SELECT EVENT_TYPE,EVENT_NAME,INTERFACE_YN,COMMUNICATION_TYPE FROM XH_EVENT_TYPE WHERE 			  DECODE(MESSAGE_TYPE,NULL,'XX',MESSAGE_TYPE) =    	 NVL('"+msg_type+"',DECODE(MESSAGE_TYPE,NULL,'XX',MESSAGE_TYPE))  AND DECODE(standard_code,NULL,'XX',standard_code) = 	   	  	 NVL('"+stnd_code+"',DECODE(standard_code,NULL,'XX',standard_code))  ORDER BY EVENT_TYPE ";
	//		System.out.println("EventListForMessageServlet.java sql1 : "+sql1);
			stmt1=con.createStatement();
			rs1=stmt1.executeQuery(sql1);
			while(rs1.next())
			{
				event_type=rs1.getString(1);
				
				arrColumn=new ArrayList();
				arrColumn.add(event_type);
				arrColumn.add(XHDBAdapter.checkNullForCheckBox(request.getParameter(event_type+"_interfaced_yn")));
				comm_type = rs1.getString(4);
				arrColumn.add(comm_type);
		//		arrColumn.add(XHDBAdapter.checkNull(request.getParameter(event_type+"_comm_type")));
				arrMultiple.add(arrColumn);
			}
		}catch(Exception e)
		{
			 System.out.println("Error in dopost method of eventlistformessageservlet :"+e.toString());
			e.printStackTrace(System.err);
		}

 finally{
	 try{
	if(rs1!=null)rs1.close();	
	if(stmt1!=null)stmt1.close();
	 con.close();
	 }catch(Exception e){

	 	  System.out.println("Error in closing dbconnection in dopost method of eventlistformessageservlet :"+e.toString());
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
	
	arrMultiple.clear();
	arrColumn.clear();
	array_audit.clear();
	details_hm.clear();
	result_hm.clear();
	}// end of do post

    /**
	 * callEJB method is used to call messagetype  of  Event list for message type
	 * @param  HashMap details_hm
	 * @param  String locale
	 */
	public HashMap callEJB(HashMap details_hm, String locale)
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
		connection = ConnectionManager.getConnection();
 
      }
      catch(Exception exp)
      {

		  System.out.println("Error in calling getdbconnection in callejb method of eventlistformessageservlet :"+exp.toString());
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
		 ostmt = connection.prepareCall("{ call xhmast.event_type(?,?,?,?,?,?,?) }" ); 
		
		  String  event_type=(String)arrRow.get(0);
   	      String  in_use_type=(String)arrRow.get(1);
		  String  comm_type=(String)arrRow.get(2);

		  String  usr_added_by_id=(String)gen_arr.get(0);
		  String  usr_added_at_ws_no=(String)gen_arr.get(1);
		  //String  s1=(String)gen_arr.get(2);

		 ostmt.setString(1,event_type);
		 ostmt.setString(2,in_use_type);
		 ostmt.setString(3,comm_type);
		 		  
		 ostmt.setString(4,usr_added_by_id);
		 ostmt.setString(5,usr_added_at_ws_no);
      
		 ostmt.registerOutParameter(6,java.sql.Types.VARCHAR);
		 ostmt.registerOutParameter(7,java.sql.Types.VARCHAR);
		 ostmt.executeUpdate(); 
		
		message_text2 = ostmt.getString(6);	
		if(message_text2.equals("0"))
		{
			connection.commit();
	//		final java.util.Hashtable mesg = mm.getMessage(locale, "XH1001", "XH") ;
			final java.util.Hashtable mesg = mm.getMessage(connection, "XH1001") ;
		    message_text2 = ((String) mesg.get("message"));
		    mesg.clear();
		 }
		 else
			  {
				 connection.rollback();
//				 final java.util.Hashtable mesg = mm.getMessage(locale, "XH1000", "XH") ;
				 final java.util.Hashtable mesg = mm.getMessage(connection, "XH1000") ;
				 message_text2 = ((String) mesg.get("message"));
				 mesg.clear();
			  }
		// message_text2 = message_text2+" "+ostmt.getString(7);
		 ostmt.close();
		 
		 
	       }
	      catch(Exception ex)
	      {
			  System.out.println("Error in calling dbrealted statements in calling callejb method of eventlistformessageservlet :"+ex.toString());
	         ex.printStackTrace(System.err);
			  
			  exceptions=exceptions+"4"+"*"+ex.toString();
				status=ex.toString();
	      }
	}
	
	try{
		ConnectionManager.returnConnection(connection);
	}catch(Exception ex){
		
	  System.out.println("Error in closing dbconnection in callejb method of eventlistformessageservlet :"+ex.toString());
	 ex.printStackTrace(System.err);
	}

	status=message_text2;
	result_hm.put("exceptions",exceptions);
	result_hm.put("status",status);
	
	row_arr.clear();
	gen_arr.clear();
	arrRow.clear();

	return result_hm;  
}// end of function
	

}// end of class
