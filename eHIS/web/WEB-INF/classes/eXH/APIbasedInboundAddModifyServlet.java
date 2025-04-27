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
 *  Class used to update APIbasedInbound  setup
 *
 */
public class APIbasedInboundAddModifyServlet extends HttpServlet
{
	HttpServletRequest req=null;
	/**
	 * Do post method which implements the functionalities for QuerybasedInbound  setup
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
		
		String p_mode=request.getParameter("act_mode");	
		String application_id=XHDBAdapter.checkNull(request.getParameter("application_id"));
		String facility_id=XHDBAdapter.checkNull(request.getParameter("facility_id"));
		String event_type=XHDBAdapter.checkNull(request.getParameter("event_type_id"));
		String segment_type=XHDBAdapter.checkNull(request.getParameter("segment_type_id"));
		String inboundapi_id=XHDBAdapter.checkNull(request.getParameter("inboundapi_id"));
		String profile_id=XHDBAdapter.checkNull(request.getParameter("profile_id"));

		String frmSrl_no = XHDBAdapter.checkNull(request.getParameter("frmSrl_no"));
//			System.out.println("from s_no : "+frmSrl_no);

		int frmS_no = Integer.parseInt(frmSrl_no);

        int toS_no = frmS_no+14;
//			System.out.println("to s_no : "+toS_no);

		String srl_no = "";
		String arg_serial_no="";
		String arg_id="";
		String arg_name="";
		String element_pos="";
		String element_val="";
	//	String stnd_code="";

		ArrayList arrMultiple=new ArrayList();		
		ArrayList arrColumn=new ArrayList();	
		ArrayList array_audit=null;

		HashMap details_hm= new HashMap();
		HashMap result_hm=new HashMap();

		try
		{

		con=ConnectionManager.getConnection();

		String sql="SELECT  A.SNO,A.ARGUMENT_ID,A.ARGUMENT_NAME  FROM xh_inbound_api_dtl A  WHERE A.APPLICATION_ID='"+application_id+"' AND	A.FACILITY_ID='"+facility_id+"' AND A.EVENT_TYPE='"+event_type+"' AND A.SEGMENT_ID='"+segment_type+"'  AND A.INBOUND_API='"+inboundapi_id+"'  AND A.PROFILE_ID='"+profile_id+"' AND A.SNO between '"+frmS_no+"' AND '"+toS_no+"'  ORDER BY A.SNO ";

//		System.out.println("sql : "+sql);
		stmt1=con.createStatement();
		rs1=stmt1.executeQuery(sql);
		int i = 1;
		while(rs1.next())
			{
				srl_no=rs1.getString(1);
				arg_serial_no=XHDBAdapter.checkNull(rs1.getString(1));
				arg_id=XHDBAdapter.checkNull(rs1.getString(2));
				arg_name=XHDBAdapter.checkNull(rs1.getString(3));

				element_pos=XHDBAdapter.checkNull(request.getParameter(srl_no+"_element_id"));
				element_val=XHDBAdapter.checkNull(request.getParameter("element_val_"+srl_no));
				if(i==1){
//					System.out.println("1st row srl_no : "+srl_no);
//					System.out.println("1st row  element_pos : "+element_pos);
//					System.out.println("1st row  element_val : "+element_val);
					i++;
				}
//				stnd_code=XHDBAdapter.checkNull(rs1.getString(4));

//		String lang_id=XHDBAdapter.checkNull(request.getParameter("lang_id"));
				
		arrColumn=new ArrayList();

		arrColumn.add(p_mode);
		arrColumn.add(application_id);
		arrColumn.add(facility_id);
		arrColumn.add(event_type);
		arrColumn.add(segment_type);
		arrColumn.add(inboundapi_id);
		arrColumn.add(srl_no);
		arrColumn.add(arg_id);
		arrColumn.add(arg_name);
		arrColumn.add(element_pos);
		arrColumn.add(element_val);
		arrColumn.add(profile_id);
//		arrColumn.add(lang_id);
		
		arrMultiple.add(arrColumn);

		} // end of while


		array_audit=new ArrayList();
		array_audit = ArrayAuditInfo.getArrayAuditInfo(session);		

		details_hm.put("row_details",arrMultiple);
		details_hm.put("gen_details",array_audit);
		result_hm=callEJB(details_hm,locale );	
				
        RequestDispatcher reqDis = 	session.getServletContext().getRequestDispatcher("/eXH/jsp/DisplayResult.jsp?message="+(String)result_hm.get("status"));
        reqDis.forward(request,response);	
        
        arrMultiple.clear();
        arrColumn.clear();
        array_audit.clear();
        details_hm.clear();
        result_hm.clear();

	}catch(Exception e)
		{
			 System.out.println("Error in dopost method of eventlistformessageservlet :"+e.toString());
			e.printStackTrace(System.err);
		}

 finally{
	 try{
	if(rs1!=null)rs1.close();	
	if(stmt1!=null)stmt1.close();
	if(con!=null)	ConnectionManager.returnConnection(con);
//	if(arrMultiple!=null) arrMultiple.clear();
//	if(arrColumn!=null) arrColumn.clear();
//	if(array_audit!=null) array_audit.clear(); 
//	if(details_hm!=null) details_hm.clear();
//	if(result_hm!=null) result_hm.clear();
	 


	 }catch(Exception e){

	 	  System.out.println("Error in closing dbconnection in dopost method of eventlistformessageservlet :"+e.toString());
	     e.printStackTrace(System.err);
	 }
		}



	}// end of do post

 /**
	 * callEJB method is used to call QuerybasedInbound setup related database procedures
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

		System.out.println("Error in calling getconnection method of APIbasedInboundAddModifyServlet  :"+exp.toString());
		exp.printStackTrace(System.err);
		exceptions=exceptions+"1"+"*"+exp.toString();
        
      }
 
 	ArrayList arrRow = new ArrayList();
//				System.out.println("row_arr size : "+row_arr.size());

	for (int j=0;j<row_arr.size();j++)
	{
		arrRow = (ArrayList)row_arr.get(j);
//		System.out.println("call EJB j val : "+j);
//			System.out.println("arrRow size : "+arrRow.size());
	    try
	    {
	
		 ostmt = connection.prepareCall("{ call Xg_prc.xh_inbound_api_dtl(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }" ); 

		  String  p_mode=(String)arrRow.get(0);
  // 	 		 System.out.println("Call EJB p_mode : "+p_mode);
 		  String  application_id=(String)arrRow.get(1);
		  String  facility_id=(String)arrRow.get(2);
		  String  event_type=(String)arrRow.get(3);
		  String  segment_type=(String)arrRow.get(4);
   	      String  inboundapi_id=(String)arrRow.get(5);
		  String  arg_serial_no=(String)arrRow.get(6);
          String  arg_id=(String)arrRow.get(7);
          String  arg_name=(String)arrRow.get(8);
		  String  element_pos=(String)arrRow.get(9);
//				System.out.println("Call EJB  element_pos : "+element_pos);
		  String  element_val=(String)arrRow.get(10);
 // 				System.out.println("Call EJB  element_val : "+element_val);
  		  String  prof_id=(String)arrRow.get(11);
 // 		  String  lang_id=(String)row_arr.get(6);


		  String  usr_added_by_id=(String)gen_arr.get(0);
		  String  usr_added_at_ws_no=(String)gen_arr.get(1);
		 
		 ostmt.setString(1,p_mode);
//  	 		 System.out.println("Call EJB p_mode : "+p_mode);
 		 ostmt.setString(2,application_id);
		 ostmt.setString(3,facility_id);
		 ostmt.setString(4,event_type);
		 ostmt.setString(5,segment_type);
		 ostmt.setString(6,inboundapi_id);
		 ostmt.setString(7,arg_serial_no);
//			 System.out.println("Call EJB arg_serial_no : "+arg_serial_no);
		 ostmt.setString(8,arg_id);
		 ostmt.setString(9,arg_name);
 		 ostmt.setString(10,element_pos);
//			 System.out.println("Call EJB element_pos : "+element_pos);
		 ostmt.setString(11,element_val);
//			 System.out.println("Call EJB element_val : "+element_val);
 		 ostmt.setString(12,prof_id);
//		 ostmt.setString(13,srtnd_code);
//		 ostmt.setString(8,lang_id);
		 		 		  
		 ostmt.setString(13,usr_added_by_id);
		 ostmt.setString(14,usr_added_at_ws_no);

	     ostmt.registerOutParameter(15,java.sql.Types.VARCHAR);
	     ostmt.registerOutParameter(16,java.sql.Types.VARCHAR);

		 ostmt.execute();
		
		 String status2= ostmt.getString(15);
//			 System.out.println("Call EJB Status2 : "+status2);
	     message_text2 = ostmt.getString(16);
//	  		 System.out.println("Call EJB message_text2 : "+message_text2);
	     ostmt.close();
	    
		if(status2.equals("0"))
		{
                connection.commit();
				final java.util.Hashtable mesg = mm.getMessage(locale, "XH1001", "XH") ;
			    status = ((String) mesg.get("message"));
			    mesg.clear();
		}
        else
		{
                connection.rollback();
				final java.util.Hashtable mesg = mm.getMessage(locale, "XH1000", "XH") ;
				status = ((String) mesg.get("message"));
				mesg.clear();
		}

	 XHDBAdapter.closeCursor(ostmt);
	
	}catch(Exception ex)
	{ 
		 System.out.println("Error in calling dbrelated statements in callejb method of DataGroupDetailsAddModifyServlet  :"+ex.toString());
		exceptions=exceptions+"3"+"*"+ex.toString();
		ex.printStackTrace(System.err);

	}
	}
	 try{
		ConnectionManager.returnConnection(connection);
			if(arrRow!=null) arrRow.clear();
			if(gen_arr!=null) gen_arr.clear();
			if(row_arr!=null) row_arr.clear();

	}catch(Exception ex){ System.out.println("Error in closing db related statements in callejb method of DataGroupDetailsAddModifyServlet :"+ex.toString());
		   ex.printStackTrace(System.err); }
//	 System.out.println("status "+status);   
	    
//	status=message_text2;
	result_hm.put("exceptions",exceptions);
	result_hm.put("status",status);

	return result_hm;  
}// end of function


}// end of class
