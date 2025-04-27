/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eXH;

import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.*;
import java.io.*;
import java.util.*;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.*;
import eXH.*;

/**
 * Class used to Control the functionalities of Administer Communication process 
 *
 */
public class XHProcessControllerServlet extends HttpServlet
{

HttpServletRequest request=null;

/**
	 * Do post method which implements the functionalities for start and stop the communication process
	 * @param  HttpServletRequest request
	 * @param  HttpServletResponse response
	 * @throws IOException
	 * @throws ServletException
	 */
	
public void doPost (HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException 
{
	
 HttpSession session=request.getSession(false);
 Properties p;		
 p = (Properties) session.getValue("jdbc");	
 String locale  = p.getProperty("LOCALE");

 request.setCharacterEncoding("UTF-8");
 response.setContentType("text/html;charset=UTF-8");

 PrintWriter out=response.getWriter();
 String strActionType = request.getParameter("action_type");
   
 String facility=XHDBAdapter.checkNull(request.getParameter("facility"));
 String comm_type = XHDBAdapter.checkNull(request.getParameter("comm_type")); 
 String comm_client = XHDBAdapter.checkNull(request.getParameter("comm_client")); 
 String appl_Id = XHDBAdapter.checkNull(request.getParameter("appl_Id"));
 String process_id = XHDBAdapter.checkNull(request.getParameter("process_id"));
 String process_status = XHDBAdapter.checkNull(request.getParameter("process_status"));

 String stat="";
 if (strActionType.equalsIgnoreCase("Start"))
 {
	   stat=start(request,locale);
 }
 
 if( (strActionType.equalsIgnoreCase("Stop"))||(strActionType.equalsIgnoreCase("Reset")))
 {
   stat=stop(strActionType,request,locale);
 }
	 
 request.setAttribute("message",stat);
 request.setAttribute("facility",facility);
 request.setAttribute("comm_type",comm_type); 
 request.setAttribute("comm_client",comm_client); 
 request.setAttribute("appl_Id",appl_Id);
 request.setAttribute("process_id",process_id);
 request.setAttribute("process_status",process_status);

 RequestDispatcher reqDis = session.getServletContext().getRequestDispatcher("/eXH/jsp/DisplayReviewResult.jsp?message="+stat+"");
 reqDis.forward(request,response);		
}
 
/**
	 * start  method which starts the communication process
	 * @param  HttpServletRequest request
	 * @param  String locale
	 */
private String start(HttpServletRequest request,String locale)
{
	Runtime runtime=null;
	Process process=null;
	String msg="";
	MessageManager mm=new MessageManager();
	Connection con=null;
	Statement stmt=null;
	ResultSet rs=null;
	String passWord=null;
	CallableStatement ostmt = null;
	String flag=null;
	String proc_id="";
	
	HttpSession session=request.getSession(false);

	runtime = Runtime.getRuntime();
	String cmd="";
	
	String facility=XHDBAdapter.checkNull(request.getParameter("facility").trim());
	//System.out.println("facility :"+facility);
	String comm_client=XHDBAdapter.checkNull(request.getParameter("comm_client").trim());
	//System.out.println("comm_client :"+comm_client);
	String comm_type = XHDBAdapter.checkNull(request.getParameter("comm_type").trim()); 
	//System.out.println("comm_type :"+comm_type);
	String appl_Id = XHDBAdapter.checkNull(request.getParameter("appl_Id").trim());
	//System.out.println("appl_Id :"+appl_Id);
	//String process_id = XHDBAdapter.checkNull(request.getParameter("process_id").trim());
//	System.out.println("process_id :"+process_id);
   /* String temp=getInitParameter("registryPort");
	System.out.println("temp :"+temp);*/

	String curr_user_id=(String)session.getValue("login_user");
	String dbString=(String)session.getValue("dbString");
	
   if(comm_type.equalsIgnoreCase("I")) facility="*A";

	
    //**********************************************************************/
		/*appprint.get_report_output_directory (	USER,
							:parameter.p_ws_no,
						  :parameter.p_temp_dir,						
							l_error_text	 );*/
	
	
	try
	{
		con =ConnectionManager.getConnection(request);
		String sql="select app_password.decrypt(APPL_USER_PASSWORD) from sm_appl_user where appl_user_ID = '"+curr_user_id+"'";
		stmt=con.createStatement();
		rs=stmt.executeQuery(sql);
		while(rs.next())
		{
			passWord=rs.getString(1);
		}
		if(rs!=null) rs.close();
        if(stmt!=null) stmt.close();
        //SELECT XH_PROCESS_ID_SEQ.NEXTVAL  FROM DUAL
		String sql1="SELECT XH_PROCESS_ID_SEQ.NEXTVAL  FROM DUAL";
		stmt=con.createStatement();
		rs=stmt.executeQuery(sql1);
		while(rs.next())
		{
			proc_id=rs.getString(1);
			
		}
		if(rs!=null) rs.close();
        if(stmt!=null) stmt.close();


		int l_proc_id=Integer.parseInt(proc_id);
		

		String dir_name="";
		String err_txt="";
//************************************************************************************
        ostmt =con.prepareCall("{ call appprint.get_report_output_directory(?,?,?,?) }" ); 
		ostmt.setString(1,curr_user_id);
		ostmt.setString(2,comm_client);
		ostmt.registerOutParameter(3,java.sql.Types.VARCHAR);
		ostmt.registerOutParameter(4,java.sql.Types.VARCHAR);

		ostmt.execute(); 
		dir_name =ostmt.getString(3);
		err_txt =ostmt.getString(4);
		if(ostmt!=null) ostmt.close();


//***************************************************************************************
        
		ostmt =con.prepareCall("{ call xhcore.INSERT_COMM_PROCESS(?,?,?,?,?,?) }" ); 
		ostmt.setInt(1,l_proc_id);
		ostmt.setString(2,facility);
		ostmt.setString(3,comm_client);
		ostmt.setString(4,appl_Id);
		ostmt.setString(5,comm_type);
		ostmt.registerOutParameter(6,java.sql.Types.VARCHAR);
		ostmt.execute(); 
		flag =ostmt.getString(6);
        if(ostmt!=null) ostmt.close();

		//con.commit();
      //System.out.println("flag  :"+flag); 
        if(flag==null)
        {
			 con.commit();
             if(comm_type.equalsIgnoreCase("O"))
	         cmd="java OutboundProcess"+" "+appl_Id+" "+facility+" "+l_proc_id+" "+comm_type+" "+"9999 "+dir_name+" N "+dbString+" "+curr_user_id+" "+passWord+" ";
			 // cmd="java OutboundProcess CSSD HS 333 0 9999 C:/MEDICOM/REPORTS/ N 1 192.5.2.214:1521:SRDV RAYILLA MED123";
	         if(comm_type.equalsIgnoreCase("I"))
	         cmd="java InboundProcess "+comm_client+" "+appl_Id+" "+facility+" "+l_proc_id+" "+comm_type+" "+"9999 "+dir_name+" N "+dbString+" "+curr_user_id+" "+passWord+" ";
			//cmd="java InboundProcess INDBGL-W00 CSSDIB *A 183 I 9999 C:/MEDICOM/REPORTS/ N indbgl-app02:1521:SRDV RAYILLA MED123";
	         //System.out.println("cmd  :"+cmd); 
	         process= runtime.exec(cmd);
	         final java.util.Hashtable mesg = mm.getMessage(locale, "XH1001", "XH") ;
  	         msg = ((String) mesg.get("message"));

		}
		else{
               con.rollback();
		       final java.util.Hashtable mesg = mm.getMessage(locale, "XH1000", "XH") ;
		       msg = ((String) mesg.get("message"));
			}

    }catch(Exception ex)
	{
		   System.out.println("Error in start method of xhprocesscontrollerservlet :"+ex.toString()); 
           ex.printStackTrace(System.err);
		   final java.util.Hashtable mesg = mm.getMessage(locale, "XH1000", "XH") ;
		   msg = ((String) mesg.get("message"));
	}finally{
			try{ 
				ConnectionManager.returnConnection(con);
				}catch(Exception e)
				{
					 System.out.println("Error in closing dbconnection method in start method of xhproesscontrollerservlet :"+e.toString()); 
					 e.printStackTrace(System.err);
				}	
	         }
//	System.out.println("message status :"+msg);
	return msg;

}
/**
	 * stop method which stops the communication process by updatng the status in db tabled  the functionalities for Replay and Rebuild 
	 * @param  HttpServletRequest request
	 * @param  HttpServletResponse response
	 * @throws IOException
	 * @throws ServletException
	 */
private String stop (String action,HttpServletRequest request,String locale)
{
    Connection con = null;
	CallableStatement ostmt = null;
	String message_text2 = "";
	String status="";
	String sts="";
	MessageManager mm=new MessageManager();

	//String facility=XHDBAdapter.checkNull(request.getParameter("facility").trim());
	//String comm_type = XHDBAdapter.checkNull(request.getParameter("comm_type").trim()); 
	//String appl_Id =XHDBAdapter.checkNull( request.getParameter("appl_Id").trim());
	HttpSession session=request.getSession(false);
	String process_id = XHDBAdapter.checkNull(request.getParameter("process_id").trim());
	String curr_user_id=(String)session.getValue("login_user");
	try{

	con =ConnectionManager.getConnection(request);
	if (action.equalsIgnoreCase("Stop"))
	{
	
		ostmt =con.prepareCall("{ call xhcomm.stop_process(?,?,?,?) }" ); 
		ostmt.setString(1,curr_user_id);
		ostmt.setString(2,process_id);

		ostmt.registerOutParameter(3,java.sql.Types.VARCHAR);
		ostmt.registerOutParameter(4,java.sql.Types.VARCHAR);
		ostmt.execute(); 
		sts =ostmt.getString(3);
		message_text2 = ostmt.getString(4);
		if(sts.equals("0"))
		{
			 con.commit();
			 final java.util.Hashtable mesg = mm.getMessage(locale, "XH1001", "XH") ;
  	         message_text2 = ((String) mesg.get("message"));
		}
		else
		{
		   	con.rollback();
			final java.util.Hashtable mesg = mm.getMessage(locale, "XH1000", "XH") ;
		    message_text2 = ((String) mesg.get("message"));
		}
  		if(ostmt!=null) ostmt.close();
		status=message_text2;
		 
	 }
	/* if (action.equalsIgnoreCase("Reset"))
	 {
		ostmt1 = con.prepareCall("{ call xhcomm.reset_process(?,?,?) }" ); 
		ostmt1.setString(1,process_id);
		ostmt1.registerOutParameter(2,java.sql.Types.VARCHAR);
	    ostmt1.registerOutParameter(3,java.sql.Types.VARCHAR);
		ostmt1.execute(); 
	    sts =ostmt1.getString(2);
		message_text2 = ostmt1.getString(3);
		if(sts.equals("0"))
	    {
		  con.commit();
		  final java.util.Hashtable mesg = mm.getMessage(locale, "RECORD_INSERTED", "SM") ;
          message_text2 = ((String) mesg.get("message"));
		}
	    else
		{
	 	   con.rollback();
		   final java.util.Hashtable mesg = mm.getMessage(locale, "APP-XH1016", "XH") ;
   	       message_text2 = ((String) mesg.get("message"));
		}
		XHDBAdapter.closeCursor(ostmt1);
		status=message_text2;
		
		 }*/
	 }catch(Exception ex)
		{
		    System.out.println("Error in stop method of xhprocesscontrollerservlet :"+ex.toString()); 
            ex.printStackTrace(System.err);
		 }
	     finally{
			try{ 
					
				ConnectionManager.returnConnection(con);
				}catch(Exception e)
				{
					System.out.println("Error in closing dbconnection method in stop of xhprocesscontrollerservlet:"+e.toString()); 
					e.printStackTrace(System.err);
				}
 return status;
}
//*************************************************************************************/	
}
}//end of class 
