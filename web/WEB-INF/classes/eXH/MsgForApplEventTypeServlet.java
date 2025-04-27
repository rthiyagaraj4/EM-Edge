/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eXH;
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
/**
 * Class used to update messagetype  for application event types
 */
public class MsgForApplEventTypeServlet extends HttpServlet
{
	HttpServletRequest req=null;
	/**
	 * Do post method which implements the functionalities for messagetype  for application event types
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

        req.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
		
		ResultSet rs1=null;
		Statement stmt1=null;
		Connection con=null;
		String sql1 = "";
	//	String status = "";

		String msg_type=request.getParameter("message_type");
		String appl_id=request.getParameter("appl_id");
		String stnd_code=request.getParameter("stnd_code");
	
		String event_type="";
		String comm_type="";
		String in_use = "";
		String disp_status = "";
				
		ArrayList arrMultiple=new ArrayList();
		ArrayList arrColumn=null;
		ArrayList array_audit=null;

		String select_yn = "";
		try
		{
			con=ConnectionManager.getConnection();

			sql1="SELECT B.EVENT_TYPE,B.EVENT_NAME,  B.COMMUNICATION_TYPE MASTCOMMTYPE,A.IN_USE_YN, A.COMMUNICATION_TYPE DTLCOMMTYPE,'B' STATUS  FROM XH_APPLICATION_EVENT_TYPE A,(SELECT  '"+appl_id+"' APPLICATION_ID, EVENT_TYPE,EVENT_NAME,COMMUNICATION_TYPE FROM  XH_EVENT_TYPE WHERE INTERFACE_YN  ='Y' AND DECODE(MESSAGE_TYPE,NULL,'XX',MESSAGE_TYPE)= NVL('"+msg_type+"',DECODE(MESSAGE_TYPE,NULL,'XX',MESSAGE_TYPE)) AND DECODE(STANDARD_CODE,NULL,'XX',STANDARD_CODE)=    NVL('"+stnd_code+"',DECODE(STANDARD_CODE,NULL,'XX',STANDARD_CODE))) B  WHERE B.APPLICATION_ID=A.APPLICATION_ID(+)    AND B.EVENT_TYPE=A.EVENT_TYPE UNION SELECT EVENT_TYPE,EVENT_NAME,COMMUNICATION_TYPE MASTCOMMTYPE,'N' IN_USE_YN,'' DTLCOMMTYPE,'G' STATUS FROM  XH_EVENT_TYPE WHERE INTERFACE_YN  ='Y' AND  DECODE(MESSAGE_TYPE,NULL,'XX',MESSAGE_TYPE)=  NVL('"+msg_type+"',DECODE(MESSAGE_TYPE,NULL,'XX',MESSAGE_TYPE)) AND  DECODE(STANDARD_CODE,NULL,'XX',STANDARD_CODE)=     NVL('"+stnd_code+"',DECODE(STANDARD_CODE,NULL,'XX',STANDARD_CODE)) AND EVENT_TYPE NOT IN (SELECT EVENT_TYPE FROM    XH_APPLICATION_EVENT_TYPE WHERE APPLICATION_ID='"+appl_id+"') ORDER BY 1 ";

//			System.out.println("MsgForApplEventTypeServlet.java sql1 : "+sql1);

			stmt1=con.createStatement();
			rs1=stmt1.executeQuery(sql1);
			while(rs1.next())
			{
				event_type=rs1.getString(1);
				comm_type=rs1.getString(3);
            	disp_status  = rs1.getString(6);
				in_use =  rs1.getString(4);

			   select_yn = XHDBAdapter.checkNullForCheckBox(request.getParameter(event_type+"_interfaced_yn"));
//		       System.out.println("select_yn : "+select_yn);
		
				if(select_yn.equals(in_use)){

				}
				else
				{
					arrColumn=new ArrayList();
					arrColumn.add(appl_id);	
					arrColumn.add(event_type);
	//					System.out.println("select val : "+request.getParameter(event_type+"_interfaced_yn"));
					arrColumn.add(XHDBAdapter.checkNullForCheckBox(request.getParameter(event_type+"_interfaced_yn")));
					arrColumn.add(comm_type);
	//				arrColumn.add(XHDBAdapter.checkNull(request.getParameter(event_type+"_comm_type")));
								
					arrMultiple.add(arrColumn);
				}				
			} // end of while 
		}catch(Exception e)
		{
			 System.out.println("Error in dopost method of msgforappleventtypeservlet :"+e.toString());
			e.printStackTrace(System.err);

		}

		finally
		{
			 try{
				if(rs1!=null)rs1.close();	
				if(stmt1!=null)stmt1.close();
				 con.close();
			 }catch(Exception e){
				  System.out.println("Error in closing statement of dopost method of msgforappleventtypeservlet :"+e.toString());
				 e.printStackTrace(System.err);
			}
		}
	
		array_audit=new ArrayList();
		array_audit = ArrayAuditInfo.getArrayAuditInfo(session);

		out.println("<html><br>"+array_audit+"<br>"+arrMultiple+"</html>");

		HashMap details_hm= new HashMap();
		details_hm.put("row_details",arrMultiple);
		details_hm.put("gen_details",array_audit);

		// now calling function  callEJB

		HashMap result_hm=new HashMap();
		result_hm=callEJB(details_hm,locale);
		
		RequestDispatcher reqDis = 	session.getServletContext().getRequestDispatcher("/eXH/jsp/DisplayResult.jsp?message="+(String)result_hm.get("status"));
		reqDis.forward(request,response);		
	}// end of do post

   /**
	 * callEJB method is used to call messagetype  for application event types related database procedures
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
			 System.out.println("Error in calling getconnection method in callejb method in msgforappleventtypeservlet :"+exp.toString());
			exp.printStackTrace(System.err);
			exceptions=exceptions+"1"+"*"+exp.toString();        
			}
    
		ArrayList arrRow = null;
//		System.out.println("row_arr.size() : "+row_arr.size());
		
		for (int j=0;j<row_arr.size();j++)
		{
		   arrRow = (ArrayList)row_arr.get(j);
		   try
		  {
		   status=status+"***"+arrRow;
		  ostmt = connection.prepareCall("{ call xhmast.event_for_application(?,?,?,?,?,?,?,?) }" ); 
		 
		  String  appln_id=(String)arrRow.get(0);
		  String  event_type=(String)arrRow.get(1);
   	      String  in_use_type=(String)arrRow.get(2);
		  String  comm_type=(String)arrRow.get(3);
//		  System.out.println("Comm TYpe : "+comm_type);

		  String  usr_added_by_id=(String)gen_arr.get(0);
		  String  usr_added_at_ws_no=(String)gen_arr.get(1);
		  //String  s1=(String)gen_arr.get(2);


		 ostmt.setString(1,appln_id);
		 ostmt.setString(2,event_type);
		 ostmt.setString(3,in_use_type);
		 ostmt.setString(4,comm_type);
		 
		  
		 ostmt.setString(5,usr_added_by_id);
		 ostmt.setString(6,usr_added_at_ws_no);
	
		 ostmt.registerOutParameter(7,java.sql.Types.VARCHAR);
		 ostmt.registerOutParameter(8,java.sql.Types.VARCHAR);
		 ostmt.execute();
		
			message_text2 = ostmt.getString(7);	
			if(message_text2.equals("0"))
			 {
				connection.commit();
//				final java.util.Hashtable mesg = mm.getMessage(locale, "XH1001", "XH") ;
				final java.util.Hashtable mesg = mm.getMessage(connection, "XH1001") ;
				message_text2 = ((String) mesg.get("message"));
			 }
			 else
			 {
				 connection.rollback();
//				 final java.util.Hashtable mesg = mm.getMessage(locale, "XH1000", "XH") ;
				 final java.util.Hashtable mesg = mm.getMessage(connection, "XH1000") ;
				 message_text2 = ((String) mesg.get("message"));
			
			}
		// message_text2 = message_text2+" "+ostmt.getString(8);
		 ostmt.close();
		 
	       }
	      catch(Exception ex)
	      {
			  System.out.println("Error in calling dbrealted statements in callejb method of MsgForApplEventTypeServlet : "+ex.toString());
		      ex.printStackTrace(System.err);
			  exceptions=exceptions+"2"+"*"+ex.toString();
		   }
		}
	    
		try
		{
			ConnectionManager.returnConnection(connection);	
		}catch(Exception ex)
		{
			System.out.println("Error in calling closing dbconnection in callejb method of MsgForApplEventTypeServlet : "+ex.toString());
			ex.printStackTrace(System.err);
		}
			
		status=message_text2;
		result_hm.put("exceptions",exceptions);
		result_hm.put("status",status);
		return result_hm;  
	// end of callEJB function
	}

}// end of class
