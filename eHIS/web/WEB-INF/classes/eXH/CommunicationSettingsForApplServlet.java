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
import java.util.regex.*;
/**
 *  Class used to update the  communication settings for application setup
 *
 */
public class CommunicationSettingsForApplServlet extends HttpServlet
{
	HttpServletRequest req=null;
   /**
	 * Do post method which implements the functionalities for  communication settings for application
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
		String mode=request.getParameter("tab_mode");
		//System.out.println("mode :"+mode);
		String APPLICATION_ID=request.getParameter("appl_name"); 
		//System.out.println("APPLICATION_ID :"+APPLICATION_ID);
	 	String FACILITY_ID=request.getParameter("facility");            
		//System.out.println("FACILITY_ID :"+FACILITY_ID); 
		String INBOUND_YN=XHDBAdapter.checkNullForCheckBox(request.getParameter("in_use"));
		//System.out.println("INBOUND_YN :"+INBOUND_YN); 
   		String INBOUND_COMM_MODE=request.getParameter("in_comm_mode");
		//System.out.println("INBOUND_COMM_MODE :"+INBOUND_COMM_MODE); 
	    String INBOUND_DIRECTORY=XHDBAdapter.checkNull(request.getParameter("in_dir_name"));
		//System.out.println("INBOUND_DIRECTORY :"+INBOUND_DIRECTORY); 
		String INBOUND_ACK_TYPE=request.getParameter("in_ack_type");
		//System.out.println("INBOUND_ACK_TYPE :"+INBOUND_ACK_TYPE); 
	   	String PROCESSING_ID=request.getParameter("proc_id"); 
		//System.out.println("PROCESSING_ID :"+PROCESSING_ID); 
		String FILTER_RULE_TYPE=request.getParameter("filter_rule_type");
		//System.out.println("FILTER_RULE_TYPE :"+FILTER_RULE_TYPE); 
	  	String OUTBOUND_YN=XHDBAdapter.checkNullForCheckBox(request.getParameter("out_use"));
		//System.out.println("OUTBOUND_YN :"+OUTBOUND_YN); 
		String OUTBOUND_COMM_MODE=XHDBAdapter.checkNull(request.getParameter("out_comm_mode"));
		//System.out.println("OUTBOUND_COMM_MODE :"+OUTBOUND_COMM_MODE); 
		String OUTBOUND_DIRECTORY=XHDBAdapter.checkNull(request.getParameter("out_dir_name"));
		//System.out.println("OUTBOUND_DIRECTORY :"+OUTBOUND_DIRECTORY); 
		String OUTBOUND_IP_ADDRESS=XHDBAdapter.checkNull(request.getParameter("out_tcp_addr"));
		//System.out.println("OUTBOUND_IP_ADDRESS :"+OUTBOUND_IP_ADDRESS); 
		String OUTBOUND_PORT_NUMBER=XHDBAdapter.checkNull(request.getParameter("out_port_num"));
		//System.out.println("OUTBOUND_PORT_NUMBER :"+OUTBOUND_PORT_NUMBER); 
		String OUTBOUND_ACK_TYPE=XHDBAdapter.checkNull(request.getParameter("out_ack_type"));
		//System.out.println("OUTBOUND_ACK_TYPE :"+OUTBOUND_ACK_TYPE); 
		String OUTBOUND_RETRY_INTERVAL=XHDBAdapter.checkNull(request.getParameter("re_try_time"));
		//System.out.println("OUTBOUND_RETRY_INTERVAL :"+OUTBOUND_RETRY_INTERVAL); 
		String OUTBOUND_MAXIMUM_RETRIES=XHDBAdapter.checkNull(request.getParameter("max_re_try"));
		//System.out.println("OUTBOUND_MAXIMUM_RETRIES :"+OUTBOUND_MAXIMUM_RETRIES); 
		String AUTOMATIC_RESTART_TYPE=XHDBAdapter.checkNull(request.getParameter("auto_restart_type"));
		//System.out.println("AUTOMATIC_RESTART_TYPE :"+AUTOMATIC_RESTART_TYPE); 
		String AUTOMATIC_RESTART_TIME=XHDBAdapter.checkNull(request.getParameter("auto_restart_time"));
		//System.out.println("AUTOMATIC_RESTART_TIME :"+AUTOMATIC_RESTART_TIME); 

		
		ArrayList arrOutbound=new ArrayList();
		ArrayList arrInbound=new ArrayList();
		try
		{

			arrOutbound.add(mode);
			arrOutbound.add(APPLICATION_ID);
			arrOutbound.add(FACILITY_ID);
			arrOutbound.add(PROCESSING_ID);          
			arrOutbound.add(FILTER_RULE_TYPE);
			arrOutbound.add(OUTBOUND_YN);                    
			arrOutbound.add(OUTBOUND_COMM_MODE);             
			arrOutbound.add(OUTBOUND_DIRECTORY);             
			arrOutbound.add(OUTBOUND_IP_ADDRESS);            
			arrOutbound.add(OUTBOUND_PORT_NUMBER);           
			arrOutbound.add(OUTBOUND_ACK_TYPE);
			arrOutbound.add(OUTBOUND_RETRY_INTERVAL);        
			arrOutbound.add(OUTBOUND_MAXIMUM_RETRIES);
			arrOutbound.add(AUTOMATIC_RESTART_TYPE);        
			arrOutbound.add(AUTOMATIC_RESTART_TIME);
			

			arrInbound.add(mode);	
			arrInbound.add(APPLICATION_ID);
			arrInbound.add(FACILITY_ID);
			arrInbound.add(INBOUND_YN);                    
			arrInbound.add(INBOUND_COMM_MODE);             
			arrInbound.add(INBOUND_DIRECTORY);             
			arrInbound.add(INBOUND_ACK_TYPE);


		}catch(Exception e)
		{
			 System.out.println("Error in dopost method of communicationsettingsforapplservlet :"+e.toString());
		    e.printStackTrace(System.err); 
		}

 	ArrayList array_audit=new ArrayList();
	array_audit = ArrayAuditInfo.getArrayAuditInfo(session);
	HashMap details_hm= new HashMap();
	details_hm.put("out_details",arrOutbound);
	details_hm.put("in_details",arrInbound);
	details_hm.put("gen_details",array_audit);
    HashMap result_hm=new HashMap();
	result_hm=callEJB(details_hm,locale);
	
	
RequestDispatcher reqDis = 	session.getServletContext().getRequestDispatcher("/eXH/jsp/DisplayResult.jsp?message="+(String)result_hm.get("status"));
 reqDis.forward(request,response);	
 arrOutbound.clear();
 arrInbound.clear();
 array_audit.clear();
 details_hm.clear();
 result_hm.clear();
 
	}// end of do post

   /**
	 * callEJB method is used to call communication settings for application related database procedures
	 * @param  HashMap details_hm
	 * @param  String locale
	 */
	public HashMap callEJB(HashMap details_hm,String locale)
    {
    

	Connection connection = null;
	CallableStatement ostmt1 = null;
	CallableStatement ostmt2 = null;
	String message_text2 = "";
	String message_text3 = "";
		
	String status="";
	String exceptions="";
	HashMap result_hm=new HashMap();
	
	boolean chkStatus=false;
	boolean chkStat=false;
	boolean chkStatusFlag1=false;
	boolean chkStatusFlag2=false;
	//boolean enableflag1=false;
	//boolean enableflag2=false;


	ArrayList out_arr = (ArrayList) details_hm.get("out_details");
	ArrayList in_arr = (ArrayList) details_hm.get("in_details");
	ArrayList gen_arr = (ArrayList) details_hm.get("gen_details");
	MessageManager mm=new MessageManager();
   	 
    try
	{
	   connection = ConnectionManager.getConnection();
	   connection.setAutoCommit(false);
    }
    catch(Exception exp)
	{
	    System.out.println("Error in calling getconnection method in dopost method of communicationsettingsforapplservlet :"+exp.toString());
		exp.printStackTrace(System.err); 
		exceptions=exceptions+"1"+"*"+exp.toString();
    }
    
	try
	{

		  ostmt1 = connection.prepareCall("{ call xhmast.application_outbound_comm(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }" ); 
	
		  String  mode=(String)out_arr.get(0);
		  //System.out.println("mode :"+mode); 
   	      String  APPLICATION_ID=(String)out_arr.get(1);
		  //System.out.println("APPLICATION_ID :"+APPLICATION_ID); 
		  String  FACILITY_ID=(String)out_arr.get(2);
		  //System.out.println("FACILITY_ID :"+FACILITY_ID); 
          String  PROCESSING_ID=(String)out_arr.get(3);
		  //System.out.println("PROCESSING_ID :"+PROCESSING_ID); 
   	      String  FILTER_RULE_TYPE=(String)out_arr.get(4);
		  //System.out.println("FILTER_RULE_TYPE :"+FILTER_RULE_TYPE); 
		  String  OUTBOUND_YN=(String)out_arr.get(5);
		  //System.out.println("OUTBOUND_YN :"+OUTBOUND_YN); 
		  String  OUTBOUND_COMM_MODE=(String)out_arr.get(6);
		  //System.out.println("OUTBOUND_COMM_MODE :"+OUTBOUND_COMM_MODE); 
          String  OUTBOUND_DIRECTORY=(String)out_arr.get(7);
		  //System.out.println("OUTBOUND_DIRECTORY :"+OUTBOUND_DIRECTORY); 
   	      String  OUTBOUND_IP_ADDRESS=(String)out_arr.get(8);
		  //System.out.println("OUTBOUND_IP_ADDRESS :"+OUTBOUND_IP_ADDRESS); 
		  String  OUTBOUND_PORT_NUMBER=(String)out_arr.get(9);
		  //System.out.println("OUTBOUND_PORT_NUMBER :"+OUTBOUND_PORT_NUMBER); 
		  String  OUTBOUND_ACK_TYPE=(String)out_arr.get(10);
		  //System.out.println("OUTBOUND_ACK_TYPE :"+OUTBOUND_ACK_TYPE); 
          String  OUTBOUND_RETRY_INTERVAL=(String)out_arr.get(11);
		  //System.out.println("OUTBOUND_RETRY_INTERVAL :"+OUTBOUND_RETRY_INTERVAL); 
   	      String  OUTBOUND_MAXIMUM_RETRIES=(String)out_arr.get(12);
		  //System.out.println("OUTBOUND_MAXIMUM_RETRIES :"+OUTBOUND_MAXIMUM_RETRIES); 
		  String  AUTOMATIC_RESTART_TYPE=(String)out_arr.get(13);
		  //System.out.println("AUTOMATIC_RESTART_TYPE :"+AUTOMATIC_RESTART_TYPE); 
   	      String  AUTOMATIC_RESTART_TIME=(String)out_arr.get(14);
		  //System.out.println("AUTOMATIC_RESTART_TIME :"+AUTOMATIC_RESTART_TIME); 
		
		  String  usr_added_by_id=(String)gen_arr.get(0);
		  //System.out.println("usr_added_by_id :"+usr_added_by_id); 
		  String  usr_added_at_ws_no=(String)gen_arr.get(1);
		  //System.out.println("usr_added_at_ws_no :"+usr_added_at_ws_no); 
		  String  usr_facility_by_id=(String)gen_arr.get(2);
		  //System.out.println("usr_facility_by_id :"+usr_facility_by_id); 

		  ostmt1.setString(1,mode);
		  ostmt1.setString(2,APPLICATION_ID);
		  ostmt1.setString(3,FACILITY_ID);
		  ostmt1.setString(4,PROCESSING_ID);
		  ostmt1.setString(5,FILTER_RULE_TYPE);
		  ostmt1.setString(6,OUTBOUND_YN);
		  ostmt1.setString(7,OUTBOUND_COMM_MODE);
		  ostmt1.setString(8,OUTBOUND_DIRECTORY);
		  ostmt1.setString(9,OUTBOUND_IP_ADDRESS);
		  ostmt1.setString(10,OUTBOUND_PORT_NUMBER);
		  ostmt1.setString(11,OUTBOUND_ACK_TYPE);
		  ostmt1.setString(12,OUTBOUND_RETRY_INTERVAL);
		  ostmt1.setString(13,OUTBOUND_MAXIMUM_RETRIES);
		  ostmt1.setString(14,AUTOMATIC_RESTART_TYPE);
		  ostmt1.setString(15,AUTOMATIC_RESTART_TIME);
			 		  
		  ostmt1.setString(16,usr_added_by_id);
		  ostmt1.setString(17,usr_added_at_ws_no);
		  ostmt1.setString(18,usr_facility_by_id);
		
		  ostmt1.registerOutParameter(19,java.sql.Types.VARCHAR);
		  ostmt1.registerOutParameter(20,java.sql.Types.VARCHAR);
		  //System.out.println("before executing xhmast.application_outbound_comm"); 
		  ostmt1.execute();
		  //System.out.println("after executing xhmast.application_outbound_comm"); 
			
		  message_text2 = ostmt1.getString(19);
		  //System.out.println("message_text2 :"+message_text2); 
		  String status1 = ostmt1.getString(20);
		  //System.out.println("status1 :"+status1); 
		  chkStatus=containsSubstring(status1,"Unique");
		  //System.out.println("chkStatus :"+chkStatus); 
		 
		  if(message_text2.equals("0"))
		  {
			chkStatusFlag1=true;
			//System.out.println(" chkStatusFlag1(true) :"+chkStatusFlag1);
		  }
		  else
		  {
			chkStatusFlag1=false;
			//System.out.println(" chkStatusFlag1(false) :"+chkStatusFlag1);
		  }
		  //System.out.println(" chkStatusFlag1(1) :"+chkStatusFlag1); 
	   //*************************************************************/
		  ostmt2 = connection.prepareCall("{ call xhmast.application_inbound_comm(?,?,?,?,?,?,?,?,?,?,?,?) }" );
		  String  mode1=(String)in_arr.get(0);
		  //System.out.println("mode1 :"+mode1); 
   	      String  APPLICATION_ID1=(String)in_arr.get(1);
		  //System.out.println("APPLICATION_ID1 :"+APPLICATION_ID1); 
		  String  FACILITY_ID1=(String)in_arr.get(2);
		  //System.out.println("FACILITY_ID1 :"+FACILITY_ID1); 
          String  INBOUND_YN=(String)in_arr.get(3);
		  //System.out.println("INBOUND_YN :"+INBOUND_YN); 
   	      String  INBOUND_COMM_MODE=(String)in_arr.get(4);
		  //System.out.println("INBOUND_COMM_MODE :"+INBOUND_COMM_MODE); 
		  String  INBOUND_DIRECTORY=(String)in_arr.get(5);
		  //System.out.println("INBOUND_DIRECTORY :"+INBOUND_DIRECTORY); 
		  String  INBOUND_ACK_TYPE=(String)in_arr.get(6);
		  //System.out.println("INBOUND_ACK_TYPE :"+INBOUND_ACK_TYPE);          		
		  String  usr_added_by_id1=(String)gen_arr.get(0);
		  //System.out.println("usr_added_by_id1 :"+usr_added_by_id1); 
		  String  usr_added_at_ws_no1=(String)gen_arr.get(1);
		//  System.out.println("usr_added_at_ws_no1 :"+usr_added_at_ws_no1); 
		  String  usr_facility_by_id1=(String)gen_arr.get(2);
		//  System.out.println("usr_facility_by_id1 :"+usr_facility_by_id1); 

		
		  ostmt2.setString(1,mode1);
		  ostmt2.setString(2,APPLICATION_ID1);
		  ostmt2.setString(3,FACILITY_ID1);
		  ostmt2.setString(4,INBOUND_YN);
		  ostmt2.setString(5,INBOUND_COMM_MODE);
		  ostmt2.setString(6,INBOUND_DIRECTORY);
		  ostmt2.setString(7,INBOUND_ACK_TYPE);
		 		 		  
		  ostmt2.setString(8,usr_added_by_id1);
		  ostmt2.setString(9,usr_added_at_ws_no1);
		  ostmt2.setString(10,usr_facility_by_id1);
		
		  ostmt2.registerOutParameter(11,java.sql.Types.VARCHAR);
		  ostmt2.registerOutParameter(12,java.sql.Types.VARCHAR);
		 // System.out.println("before executing xhmast.application_inbound_comm"); 
		  ostmt2.execute();
         // System.out.println("after executing xhmast.application_inbound_comm"); 
		  message_text3 = ostmt2.getString(11);
		//  System.out.println("message_text3 :"+message_text3); 
		  String status2 = ostmt2.getString(12);
		 // System.out.println("status2 :"+status2); 
		  chkStat=containsSubstring(status2,"Unique");
		//  System.out.println(" chkStat :"+chkStat); 	 
		  if(message_text3.equals("0"))
		  {
			chkStatusFlag2=true;
			//System.out.println(" chkStatusFlag2(true) :"+chkStatusFlag2);
		  }
		  else
		  {
			// System.out.println(" chkStatusFlag2(false) :"+chkStatusFlag2);
			 chkStatusFlag2=false;
		
		  }
	      //System.out.println(" chkStatusFlag1 :"+chkStatusFlag1); 
		 // System.out.println(" chkStatusFlag2 :"+chkStatusFlag2); 
		
		  if((chkStatusFlag1)&&(chkStatusFlag2))
	      {
			 //System.out.println(" commit "); 
			 connection.commit();
			 final java.util.Hashtable mesg = mm.getMessage(locale, "XH1001", "XH") ;
 			 message_text3 = ((String) mesg.get("message"));
			// System.out.println(" message_text3 :"+message_text3); 
 			mesg.clear();
		
	      }
		  else
		  {	 
		      //System.out.println(" rollback "); 
			  connection.rollback();
			  final java.util.Hashtable mesg = mm.getMessage(locale, "XH1000", "XH") ;
 			  message_text3 = ((String) mesg.get("message"));
		  	  //System.out.println(" message_text3 :"+message_text3); 
 			 mesg.clear();
		
		  }
	   //*************************************************************/
		  if(ostmt1!=null) ostmt1.close();
		  if(ostmt2!=null) ostmt2.close();		 
	  }catch(Exception ex)
	   {
			  System.out.println("Error(1) in calling db related statements in callejb method of communicationsettingsforapplservlet :"+ex.toString());
		      ex.printStackTrace(System.err); 
		      exceptions=exceptions+"4a"+"*"+ex.toString();
		
	    }
   
	try{
		ConnectionManager.returnConnection(connection);
	
	    }catch(Exception ex){  System.out.println("Error in closing dbconnection in callejb method of communicationsettingsforapplservlet :"+ex.toString());
		      ex.printStackTrace(System.err); 
		 }
  	    //System.out.println(" message_text3 :"+message_text3); 
		status=message_text3;
		//System.out.println(" status :"+status); 
	    result_hm.put("exceptions",exceptions);
	    result_hm.put("status",status);

	    out_arr.clear();
	    in_arr.clear();
	    gen_arr.clear();
	    
	    return result_hm;  
}// end of function*/
	

  public boolean  containsSubstring(String mainString, String subString)
  {
     boolean status = false; 
     Pattern pattern = Pattern.compile(subString);
	 Matcher matcher = pattern.matcher(mainString); 
	 status = matcher.find();
	 return status; 
  }

}// end of class
