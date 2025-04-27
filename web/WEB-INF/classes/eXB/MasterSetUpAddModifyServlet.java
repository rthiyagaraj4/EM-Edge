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
 *  Class used to update Master setup
 *
 */
public class MasterSetUpAddModifyServlet extends HttpServlet
{
	HttpServletRequest req=null;
	/**
	 * Do post method which implements the functionalities for Master  setup
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
		String module_Id=XBDBAdapter.checkNull(request.getParameter("module_Id"));
			System.out.println("module_Id : "+module_Id);
		String module_Name=XBDBAdapter.checkNull(request.getParameter("module_Name"));
			System.out.println("module_Name : "+module_Name);
		String payer_group=XBDBAdapter.checkNull(request.getParameter("payer_group_code"));
			System.out.println("payer_group : "+payer_group);
		String payer_code=XBDBAdapter.checkNull(request.getParameter("payer_code"));
			System.out.println("payer_code : "+payer_code);
		String policy_code=XBDBAdapter.checkNull(request.getParameter("policy_code"));
			System.out.println("policy_code : "+policy_code);
		String episode_type=XBDBAdapter.checkNull(request.getParameter("episode_type"));
					System.out.println("MasterSetUpAddModifyServlet.java episode_type : "+episode_type);

/*			if(episode_type.equals()){
			} */
		String enableYN=(XBDBAdapter.checkNullForCheckBox(request.getParameter("enabled_yn"))).trim();
			System.out.println("MasterSetUpAddModifyServlet.java enableYN : "+enableYN);
			if(!enableYN.equals("N") && !enableYN.equals("") ){
				enableYN = "Y";
			}

//		String p_mode=request.getParameter("act_mode");		
//		String lang_id=XBDBAdapter.checkNull(request.getParameter("lang_id"));

		String facility_Id=XBDBAdapter.checkNull(request.getParameter("facility_Id"));
			System.out.println("facility_Id : "+facility_Id);

		ArrayList arrColumn=null;
		ArrayList array_audit=null;
		
		arrColumn=new ArrayList();

		arrColumn.add(p_mode);
		arrColumn.add(module_Id);
		arrColumn.add(module_Name);
		arrColumn.add(payer_group);
		arrColumn.add(payer_code);
        arrColumn.add(policy_code);
		arrColumn.add(episode_type);
/*		if(episode_type != null){
			arrColumn.add("Y");
		}
		else{
			arrColumn.add("N");
		} */
        arrColumn.add(enableYN);
		arrColumn.add(facility_Id);
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
	 * callEJB method is used to call MasterSetUp related database procedures
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

		 System.out.println("Error in calling getconnection method of MasterSetUpAddModifyServlet  :"+exp.toString());
		exp.printStackTrace(System.err);
		exceptions=exceptions+"1"+"*"+exp.toString();
        
      }
 
	try
	{

 	 ostmt = connection.prepareCall("{ call XB_EBILLING.xb_ebilling_module_type(?,?,?,?,?,?,?,?,?,?,?,?,?) }" ); 

		  String  p_mode=(String)row_arr.get(0);
//	   		  System.out.println("callEJB p_mode : "+p_mode);
   	      String  module_Id=(String)row_arr.get(1);
		  String  module_Name=(String)row_arr.get(2);
//   			  System.out.println("callEJB module_Name : "+module_Name);
	  	  String  payer_group=(String)row_arr.get(3);
		  String  payer_code=(String)row_arr.get(4);
		  String  policy_code=(String)row_arr.get(5);
  		  String  episode_type=(String)row_arr.get(6);
//  		      		System.out.println("callEJB episode_type : "+episode_type);
		  String  enableYN=(String)row_arr.get(7);
	  	  String  facility_ID=(String)row_arr.get(8);
//		      		System.out.println("callEJB enableYN : "+enableYN);
//          String  lang_id=(String)row_arr.get(3);

		  String  usr_added_by_id=(String)gen_arr.get(0);
//		      		System.out.println("callEJB usr_added_by_id : "+usr_added_by_id);

		  String  usr_added_at_ws_no=(String)gen_arr.get(1);
//		      		System.out.println("callEJB usr_added_at_ws_no : "+usr_added_at_ws_no);

		 
		 ostmt.setString(1,p_mode);
		 ostmt.setString(2,module_Id);
		 ostmt.setString(3,module_Name);
		 ostmt.setString(4,payer_group);
 		 ostmt.setString(5,payer_code);
         ostmt.setString(6,policy_code);
  		 ostmt.setString(7,episode_type);
         ostmt.setString(8,enableYN);
		 ostmt.setString(9,facility_ID);
		 ostmt.setString(10,usr_added_by_id);
		 ostmt.setString(11,usr_added_at_ws_no);


	     ostmt.registerOutParameter(12,java.sql.Types.VARCHAR);
	     ostmt.registerOutParameter(13,java.sql.Types.VARCHAR);
	     ostmt.execute();
	 
		 String status2= ostmt.getString(12);
	 	 		System.out.println("callEJB status2 : "+status2);
	     message_text2 = ostmt.getString(13);
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
//				status = "Child record found in xh_data_group_detail";
			    mesg.clear();
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
		
		row_arr.clear();
		gen_arr.clear();

	 XBDBAdapter.closeCursor(ostmt);
	
	}catch(Exception ex)
	{ 
		System.out.println("Error in calling dbrelated statements in callejb method of MasterSetUpAddModifyServlet  :"+ex.toString());
		exceptions=exceptions+"3"+"*"+ex.toString();
		ex.printStackTrace(System.err);
	}
	 try{
		ConnectionManager.returnConnection(connection);
	}catch(Exception ex){ System.out.println("Error in closing dbrealted statements in callejb method of MasterSetUpAddModifyServlet :"+ex.toString());
		   ex.printStackTrace(System.err); }
	 System.out.println("status "+status);   
	    
//	status=message_text2;
	result_hm.put("exceptions",exceptions);
	result_hm.put("status",status);

	return result_hm;  
}// end of function



}// end of class
