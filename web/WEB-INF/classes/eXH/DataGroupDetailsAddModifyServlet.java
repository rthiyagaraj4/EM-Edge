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
import webbeans.eCommon.*;
import eXH.XHDBAdapter;
import eXH.ArrayAuditInfo;
/**
 *  Class used to update DataGroupDetails  setup
 *
 */
public class DataGroupDetailsAddModifyServlet extends HttpServlet
{
	HttpServletRequest req=null;
	/**
	 * Do post method which implements the functionalities for DataGroupDetails  setup
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
		String srl_no=XHDBAdapter.checkNull(request.getParameter("srl_no"));
//			System.out.println("srlno : "+srl_no);
		String datagroup_id=XHDBAdapter.checkNull(request.getParameter("dg_code"));
		String application_id=XHDBAdapter.checkNull(request.getParameter("application_id"));
		String facility_id=XHDBAdapter.checkNull(request.getParameter("facility_id"));
		String mesg_type=XHDBAdapter.checkNull(request.getParameter("mesg_type_id"));
		String event_type=XHDBAdapter.checkNull(request.getParameter("event_type_id"));
		String segment_type=XHDBAdapter.checkNull(request.getParameter("segment_type_id"));
		String filt_rule_type=XHDBAdapter.checkNull(request.getParameter("filter_rule_type"));
//			System.out.println("filt_rule_type : "+filt_rule_type);

		String protocol_linkId=XHDBAdapter.checkNull(request.getParameter("protocol_link_id"));
//		String protocol_linkId = "";
//		String lang_id=XHDBAdapter.checkNull(request.getParameter("lang_id"));
		
		ArrayList arrColumn=null;
		ArrayList array_audit=null;
		
		arrColumn=new ArrayList();

		arrColumn.add(p_mode);
		arrColumn.add(srl_no);
		arrColumn.add(datagroup_id);
		arrColumn.add(protocol_linkId);
		arrColumn.add(application_id);
		arrColumn.add(facility_id);
		arrColumn.add(mesg_type);
		arrColumn.add(event_type);
		arrColumn.add(segment_type);
		arrColumn.add(filt_rule_type);
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
/*
		if(arrColumn!=null)  arrColumn.clear();
		if(array_audit!=null)  array_audit .clear();
	    if(details_hm!=null)  details_hm .clear();
*/
        arrColumn.clear();
        array_audit.clear();
	}// end of do post

 /**
	 * callEJB method is used to call DataGroupDetails setup related database procedures
	 * @param  HashMap details_hm
	 * @param  String locale
	 */
	public HashMap callEJB(HashMap details_hm,String locale )
   {
    

	Connection connection = null;
	CallableStatement ostmt = null;
	String status="";
	String exceptions="";
	HashMap<String, String> result_hm=new HashMap<String, String>();
	MessageManager mm=new MessageManager();
	
	ArrayList row_arr = (ArrayList) details_hm.get("row_details");
	ArrayList gen_arr = (ArrayList) details_hm.get("gen_details");
	
	  
    try
	{
		if(connection==null) connection = ConnectionManager.getConnection();
//		if(details_hm!=null) details_hm.clear();      
      }
      catch(Exception exp)
      {

		System.out.println("Error in calling getconnection method of DataGroupDetailsAddModifyServlet  :"+exp.toString());
		exp.printStackTrace(System.err);
		exceptions=exceptions+"1"+"*"+exp.toString();
        
      }
 
	
	try
	{


	 ostmt = connection.prepareCall("{ call Xg_prc.xh_data_group_detail(?,?,?,?,?,?,?,?,?,?,?,?,?,?) }" ); 

		  String  p_mode=(String)row_arr.get(0);

		  String  srl_no=(String)row_arr.get(1);

   	 	  String  datagroup_id=(String)row_arr.get(2);
		  String  protocol_linkId=(String)row_arr.get(3);
          String  application_id=(String)row_arr.get(4);
          String  facility_id=(String)row_arr.get(5);
		  String  mesg_type=(String)row_arr.get(6);
		  String  event_type=(String)row_arr.get(7);
		  String  segment_type=(String)row_arr.get(8);
		  String  filt_rule_type=(String)row_arr.get(9);
 // 		  String  lang_id=(String)row_arr.get(6);

		  String  usr_added_by_id=(String)gen_arr.get(0);
		  String  usr_added_at_ws_no=(String)gen_arr.get(1);
		 
		 ostmt.setString(1,p_mode);
//  	 		 System.out.println("DataGroupDetailsAddModifyServlet Call EJB p_mode : "+p_mode);
		 ostmt.setString(2,srl_no);
//			 System.out.println("Call EJB srl_no : "+srl_no);
		 ostmt.setString(3,datagroup_id);
//			 System.out.println("Call EJB datagroup_id : "+datagroup_id);
		 ostmt.setString(4,protocol_linkId);
//			 System.out.println("Call EJB protocol_linkId : "+protocol_linkId);
//		 ostmt.setString(5,application_id);
 		 ostmt.setString(5,application_id);
//		System.out.println("Call EJB application_id : "+application_id);
		 ostmt.setString(6,facility_id);
//			 System.out.println("Call EJB facility_id : "+facility_id);
 		 ostmt.setString(7,mesg_type);
//			 System.out.println("Call EJB mesg_type : "+mesg_type);
		 ostmt.setString(8,event_type);
//			 System.out.println("Call EJB event_type : "+event_type);
		 ostmt.setString(9,segment_type);
 //	 		 System.out.println("Call EJB segment_type : "+segment_type);
		 ostmt.setString(10,filt_rule_type);
//	 		 System.out.println("Call EJB filt_rule_type : "+filt_rule_type);
	//	 ostmt.setString(9,lang_id);
		 		 		  
		 ostmt.setString(11,usr_added_by_id);
//	 		 System.out.println("Call EJB usr_added_by_id : "+usr_added_by_id);
		 ostmt.setString(12,usr_added_at_ws_no);

	     ostmt.registerOutParameter(13,java.sql.Types.VARCHAR);
	     ostmt.registerOutParameter(14,java.sql.Types.VARCHAR);
	     ostmt.execute();
		
		 String status2= ostmt.getString(13);
//	  		 System.out.println("Call EJB message_text2 : "+message_text2);
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
			//	final java.util.Hashtable mesg = mm.getMessage(connection, "XH1024") ;
			    status = ((String) mesg.get("message"));
			    mesg.clear();
		}
        else
		{
                connection.rollback();
		final java.util.Hashtable mesg = mm.getMessage(locale, "XH1000", "XH") ;
		//		final java.util.Hashtable mesg =  mm.getMessage(connection,"XH1000") ;
				status = ((String) mesg.get("message"));
				mesg.clear();
		}
		
		row_arr.clear();
		gen_arr.clear();

	 XHDBAdapter.closeCursor(ostmt);

	}catch(Exception ex)
	{ 
		 System.out.println("Error in calling dbrelated statements in callejb method of DataGroupDetailsAddModifyServlet  :"+ex.toString());
		exceptions=exceptions+"3"+"*"+ex.toString();
		ex.printStackTrace(System.err);

	}
	 try{
		ConnectionManager.returnConnection(connection);
	}catch(Exception ex){ System.out.println("Error in closing db related statements in callejb method of DataGroupDetailsAddModifyServlet :"+ex.toString());
		   ex.printStackTrace(System.err); }
//	 System.out.println("status "+status);   
	    
//	status=message_text2;
	result_hm.put("exceptions",exceptions);
	result_hm.put("status",status);

	return result_hm;  
}// end of function



}// end of class
