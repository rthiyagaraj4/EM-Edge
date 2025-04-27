/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eXB; 
import java.sql.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.*;
import eXB.XBDBAdapter;
import eXB.ArrayAuditInfo;
/**
 *  Class used to update Export Files
 *
 */
public class ExportFilesAddModifyServlet extends HttpServlet
{ 
	HttpServletRequest req=null;
	/**
	 * Do post method which implements the functionalities for Export Files
	 * @param  HttpServletRequest request
	 * @param  HttpServletResponse response
	 */

	public void doPost (HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException 
	{
		PrintWriter out;
		out=response.getWriter();
		req=request;		
			
		HttpSession session=request.getSession(false);
		Properties p = (Properties) session.getValue("jdbc");	
		String locale = p.getProperty("LOCALE");

		request.setCharacterEncoding("UTF-8");
   	    response.setContentType("text/html;charset=UTF-8");

		String p_mode = request.getParameter("act_mode");
		String event_type = XBDBAdapter.checkNull(request.getParameter("event_type"));
		String sent_file_id = XBDBAdapter.checkNull(request.getParameter("sent_file_id"));
		String sent_date = XBDBAdapter.checkNull(request.getParameter("sent_date"));
		String sent_file_cnt = XBDBAdapter.checkNull(request.getParameter("sent_file_cnt"));
		String facilityID = XBDBAdapter.checkNull(request.getParameter("facilityID"));
		String referrenceNo = XBDBAdapter.checkNull(request.getParameter("referrenceNo"));

		System.out.println("sent_date : "+sent_date);
		System.out.println("sent_file_id : "+sent_file_id);
		System.out.println("event_type : "+event_type);
		System.out.println("sent_file_cnt : "+sent_file_cnt);
		System.out.println("facilityID : "+facilityID);
		System.out.println("referrenceNo : "+referrenceNo);

/*		String csmbs=XBDBAdapter.checkNull(request.getParameter("csmbs"));
			System.out.println("csmbs : "+csmbs);
		String reply_file_id=XBDBAdapter.checkNull(request.getParameter("reply_file_id"));
			System.out.println("reply_file_id : "+reply_file_id);
		String reply_date=XBDBAdapter.checkNull(request.getParameter("reply_date"));
			System.out.println("reply_date : "+reply_date); */

		ArrayList arrColumn=null;
		ArrayList array_audit=null;
		
		arrColumn=new ArrayList();

		arrColumn.add(p_mode);
		arrColumn.add(event_type);
		arrColumn.add(sent_file_id);
		arrColumn.add(sent_date);
		arrColumn.add(facilityID);
		arrColumn.add(referrenceNo);
		
/*		arrColumn.add(csmbs);
		arrColumn.add(reply_file_id);
        arrColumn.add(reply_date); */

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
        
	}

 /**
	 * callEJB method is used to call Export Files related database procedures
	 * @param  HashMap details_hm
	 * @param  String locale
	 */
public HashMap callEJB(HashMap details_hm,String locale )
   {    

	Connection connection = null;
	CallableStatement ostmt = null;
	String message_text2 = "";
	String status = "";
	String exceptions = "";
	HashMap result_hm = new HashMap();
	MessageManager mm = new MessageManager();
	ArrayList row_arr = (ArrayList) details_hm.get("row_details");
	ArrayList gen_arr = (ArrayList) details_hm.get("gen_details");
	
	try
	{
		if(connection == null) connection = ConnectionManager.getConnection();
	}
	catch(Exception exp)
	{
		System.out.println("Error in calling getconnection method of ExportFilesAddModifyServlet  :"+exp.toString());
		exp.printStackTrace(System.err);
		exceptions=exceptions+"1"+"*"+exp.toString();
	}
 
	try
	{
		ostmt = connection.prepareCall("{ call XB_EBILLING.xb_sent_file_dtls(?,?,?,?,?,?,?,?,?) }" ); 

		String p_mode = (String)row_arr.get(0);
		String event_type = (String)row_arr.get(1);
		String sent_file_id = (String)row_arr.get(2);
		String sent_date = (String)row_arr.get(3);
		String facilityID = (String)row_arr.get(4);
		String referrenceNo = (String)row_arr.get(5);
		String usr_added_by_id = (String)gen_arr.get(0);
		String usr_added_at_ws_no = (String)gen_arr.get(1);

		System.out.println("callEJB p_mode : "+p_mode);
		System.out.println("callEJB sent_file_id : "+sent_file_id);
		System.out.println("callEJB usr_added_by_id : "+usr_added_by_id);
		System.out.println("callEJB usr_added_at_ws_no : "+usr_added_at_ws_no);
		
		ostmt.setString(1,event_type);
		ostmt.setString(2,sent_file_id);
		ostmt.setString(3,sent_date);
		ostmt.setString(4,facilityID);
		ostmt.setString(5,referrenceNo);
		ostmt.setString(6,usr_added_by_id);
		ostmt.setString(7,usr_added_at_ws_no);
		ostmt.registerOutParameter(8,java.sql.Types.VARCHAR);
		ostmt.registerOutParameter(9,java.sql.Types.VARCHAR);
		ostmt.execute();

		String status2= ostmt.getString(8);
		message_text2 = ostmt.getString(9);
		System.out.println("callEJB status2 : "+status2);
		System.out.println("callEJB message_text2 : "+message_text2);

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
			mesg.clear();
			//				status = "Child record found in xh_data_group_detail";
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

		XBDBAdapter.closeCursor(ostmt);
	}
	catch(Exception ex)
	{ 
		System.out.println("Error in calling dbrelated statements in callejb method of ExportFilesAddModifyServlet  :"+ex.toString());
		exceptions=exceptions+"3"+"*"+ex.toString();
		ex.printStackTrace(System.err);
	}
	finally{
	
		row_arr.clear();
		gen_arr.clear();
	}
	try
	{
		ConnectionManager.returnConnection(connection);
	}
	catch(Exception ex)
	{ 
		System.out.println("Error in closing dbrealted statements in callejb method of ExportFilesAddModifyServlet :"+ex.toString());
		ex.printStackTrace(System.err); 
	}
	System.out.println("status "+status);   
	    
//	status=message_text2;
	result_hm.put("exceptions",exceptions);
	result_hm.put("status",status);
	return result_hm;  
}
}// end of class
