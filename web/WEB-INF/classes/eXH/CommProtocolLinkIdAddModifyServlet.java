/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 /***************************************************************************************************************
 * Author   :   Neelkamal Pyla
 * Desc     :	Class used to update the CommProtocolLink setup
 ***************************************************************************************************************/
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
 *  Class used to update CommProtocolLink  setup
 *
 */
public class CommProtocolLinkIdAddModifyServlet extends HttpServlet
{
	HttpServletRequest req=null;
	/**
	 * Do post method which implements the functionalities for CommProtocolLink setup
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
		String protocol_linkId=XHDBAdapter.checkNull(request.getParameter("protocol_linkId"));
		String protocol_linkName=XHDBAdapter.checkNull(request.getParameter("protocol_linkName"));
		String protocol_id=XHDBAdapter.checkNull(request.getParameter("protocol_id"));
		String datagroup_id=XHDBAdapter.checkNull(request.getParameter("datagroup_id"));
	
		String stnd_code=XHDBAdapter.checkNull(request.getParameter("standard_code"));
  	    String prfl_id=XHDBAdapter.checkNull(request.getParameter("profile_id"));
		String appl_id=XHDBAdapter.checkNull(request.getParameter("application_id"));
//			System.out.println("appl_id : "+appl_id);
		String fac_id=XHDBAdapter.checkNull(request.getParameter("facility_id"));
//			System.out.println("fac_id : "+fac_id);
		String auditYN=request.getParameter("auditYN");
		String debugYN=request.getParameter("debugYN");
		String outbndLogYN=request.getParameter("outbndLogYN");
		String inbndLogYN=request.getParameter("inbndLogYN");
	
		ArrayList arrColumn=null;
		ArrayList array_audit=null;
		
		arrColumn=new ArrayList();

		arrColumn.add(p_mode);
		arrColumn.add(protocol_linkId);
		arrColumn.add(protocol_linkName);
		arrColumn.add(protocol_id);
		arrColumn.add(datagroup_id);

		arrColumn.add(stnd_code);
		arrColumn.add(prfl_id);
		arrColumn.add(appl_id);
		arrColumn.add(fac_id);

		if(auditYN != null){
			arrColumn.add("Y");
		}
		else{
			arrColumn.add("N");
		}
		if(debugYN != null){
			arrColumn.add("Y");
		}
		else{
			arrColumn.add("N");
		}
		if(outbndLogYN != null){
			arrColumn.add("Y");
		}
		else{
			arrColumn.add("N");
		}
		if(inbndLogYN != null){
			arrColumn.add("Y");
		}
		else{
			arrColumn.add("N");
		}

//		arrColumn.add(lang_id);
		
		array_audit=new ArrayList();
		array_audit = ArrayAuditInfo.getArrayAuditInfo(session);		

		HashMap details_hm= new HashMap();
		details_hm.put("row_details",arrColumn);
		details_hm.put("gen_details",array_audit);
		HashMap result_hm=new HashMap();
		result_hm=callEJB(details_hm,locale );	
		//parent.frames(1).document.location.reload();

       
        RequestDispatcher reqDis = 	session.getServletContext().getRequestDispatcher("/eXH/jsp/DisplayResult.jsp?function=C&message="+(String)result_hm.get("status"));
        reqDis.forward(request,response);	
        
        arrColumn.clear();
        array_audit.clear();
        details_hm.clear();
        result_hm.clear();


	}// end of do post

 /**
	 * callEJB method is used to call CommProtocolLink setup related database procedures
	 * @param  HashMap details_hm
	 * @param  String locale
	 */
	public HashMap callEJB(HashMap details_hm,String locale )
   {
    

	Connection connection = null;
//	Statement stmt = null;
//	ResultSet rs = null;
	CallableStatement ostmt = null;
//	CallableStatement ostmt2 = null;
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

		 System.out.println("Error in calling getconnection method of CommProtocolLinkIdAddModifyServlet  :"+exp.toString());
		exp.printStackTrace(System.err);
		exceptions=exceptions+"1"+"*"+exp.toString();
        
      }
 
	
	try
	{



	 ostmt = connection.prepareCall("{ call Xg_prc.xh_protocol_link(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }" ); 

	 	  String  p_mode=(String)row_arr.get(0);
//			  System.out.println("Call EJB Mode : "+p_mode);
   	      String  protocol_linkId=(String)row_arr.get(1);
 // 	  		  System.out.println("call EJB protocol_linkId : "+protocol_linkId);
		  String  protocol_linkName=(String)row_arr.get(2);
//	  		  System.out.println("call EJB protocol_linkName : "+protocol_linkName);
		  String  protocol_id=(String)row_arr.get(3);
//	  		  System.out.println("call EJB protocol_id : "+protocol_id);
		  String  datagroup_id=(String)row_arr.get(4);
//	  		  System.out.println("call EJB datagroup_id : "+datagroup_id);

	      String  stnd_code=(String)row_arr.get(5);
//  	  		  System.out.println("call EJB stnd_code : "+stnd_code);
		  String  prfl_id=(String)row_arr.get(6);
//	  		  System.out.println("call EJB prfl_id : "+prfl_id);
		  String  appl_id=(String)row_arr.get(7);
//	  		  System.out.println("call EJB appl_id : "+appl_id);
		  //String  fac_id=(String)row_arr.get(8);
//	  		  System.out.println("call EJB fac_id : "+fac_id);

          String  auditYN=(String)row_arr.get(9);
//  	  		  System.out.println("call EJB auditYN : "+auditYN);
		  String  debugYN=(String)row_arr.get(10);
//	  		  System.out.println("call EJB debugYN : "+debugYN);
		  String  outbndLogYN=(String)row_arr.get(11);
//	  		  System.out.println("call EJB outbndLogYN : "+outbndLogYN);
		  String  inbndLogYN=(String)row_arr.get(12);
//	  		  System.out.println("call EJB inbndLogYN : "+inbndLogYN);

  //        String  lang_id=(String)row_arr.get(5);

		  String  usr_added_by_id=(String)gen_arr.get(0);
		  String  usr_added_at_ws_no=(String)gen_arr.get(1);
//		 System.out.println("Xg_prc.xh_protocol_link('"+p_mode+"','"+protocol_linkId+"','"+protocol_linkName+"','"+protocol_id+"','"+datagroup_id+"','"+usr_added_by_id+"','"+usr_added_at_ws_no+"','','','"+stnd_code+"','"+appl_id+"','"+prfl_id+"','"+auditYN+"','"+debugYN+"','"+outbndLogYN+"','"+inbndLogYN+")");
		 ostmt.setString(1,p_mode);
		 ostmt.setString(2,protocol_linkId);
		 ostmt.setString(3,protocol_linkName);
	 	 ostmt.setString(4,protocol_id);
		 ostmt.setString(5,datagroup_id);

//		 ostmt.setString(6,lang_id);

		 ostmt.setString(6,usr_added_by_id);
		 ostmt.setString(7,usr_added_at_ws_no);

	     ostmt.registerOutParameter(8,java.sql.Types.VARCHAR);
	     ostmt.registerOutParameter(9,java.sql.Types.VARCHAR);

		 ostmt.setString(10,stnd_code);
		 ostmt.setString(11,appl_id);
	 	 ostmt.setString(12,prfl_id);
	     ostmt.setString(13,auditYN);
		 ostmt.setString(14,debugYN);
	 	 ostmt.setString(15,outbndLogYN);
		 ostmt.setString(16,inbndLogYN);

	     ostmt.execute();
	
	     String status2= ostmt.getString(8);
 //	  		  System.out.println("call EJB status2 : "+status2);
	     message_text2 = ostmt.getString(9);
	     ostmt.close();
	    
		if(status2.equals("0"))
		{
                connection.commit();
			final java.util.Hashtable mesg = mm.getMessage(locale, "XH1001", "XH") ;
				//final java.util.Hashtable mesg = mm.getMessage(connection, "XH1001") ;
			    status = ((String) mesg.get("message"));
			    mesg.clear();

	/*			stmt=connection.createStatement();
				String sql="";
				String comm_type = "";
				String facility_id = "";
				String event_type = "";
				String sgmnt_type = "";
				sql=" SELECT PROTCOL_MODE FROM XH_PROTOCOL WHERE PROTOCOL_ID='"+protocol_id+"'";  
	
				rs=stmt.executeQuery(sql);
				while(rs.next()){
	                comm_type = rs.getString(1);
					System.out.println("CommProtocolLinkIdAddModifyServlet Comm_type : "+comm_type);
				}

//				sql="  SELECT FACILITY_ID,EVENT_TYPE,SEGMENT_TYPE FROM XH_DATA_GROUP_DETAIL WHERE PROTOCOL_LINK_ID='"+protocol_linkId+"' AND DATA_GROUP_ID='"+datagroup_id+"'AND SRL_NO='1' ";

				sql="  SELECT FACILITY_ID,EVENT_TYPE,SEGMENT_TYPE FROM XH_DATA_GROUP_DETAIL WHERE PROTOCOL_LINK_ID='"+protocol_linkId+"' AND DATA_GROUP_ID='"+datagroup_id+"' ";

				rs=stmt.executeQuery(sql);
				while(rs.next()){
	                facility_id = rs.getString(1);
						System.out.println("CommProtocolLinkIdAddModifyServlet facility_id : "+facility_id);
					event_type = rs.getString(2);
						System.out.println("CommProtocolLinkIdAddModifyServlet event_type : "+event_type);
					sgmnt_type = rs.getString(3);
						System.out.println("CommProtocolLinkIdAddModifyServlet sgmnt_type : "+sgmnt_type);
				}
				 ostmt2 = connection.prepareCall("{ call xhgeneric.controlbuilder(?,?,?,?,?,?,?) }" ); 
				 ostmt2.setString(1,comm_type);
				 ostmt2.setString(2,appl_id);
				 ostmt2.setString(3,facility_id);
				 ostmt2.setString(4,event_type);
				 ostmt2.setString(5,sgmnt_type);
 				 ostmt2.setString(6,protocol_linkId);
				 ostmt2.registerOutParameter(7,java.sql.Types.VARCHAR);
		 	     ostmt2.execute();	
			     String  p_message_segment = ostmt2.getString(7);
 	  				  System.out.println("call EJB  p_message_segment  : "+p_message_segment);
				 ostmt2.close();
		         connection.commit();
*/
		}
		else if(status2.equals("2"))
		{
			    connection.commit();
				final java.util.Hashtable mesg = mm.getMessage(locale, "CODE_ALREADY_EXISTS", "Common") ;
				//final java.util.Hashtable mesg = mm.getMessage(connection, "XH1024") ;
			    status = ((String) mesg.get("message"));
			    mesg.clear();
		}
        else
		{
                connection.rollback();
			final java.util.Hashtable mesg = mm.getMessage(locale, "XH1000", "XH") ;
				//final java.util.Hashtable mesg = mm.getMessage(connection, "XH1000") ;
				status = ((String) mesg.get("message"));
				mesg.clear();
		}

	 XHDBAdapter.closeCursor(ostmt);
// 	 XHDBAdapter.closeCursor(ostmt2);
	
	}catch(Exception ex)
	{ 
		 System.out.println("Error in calling dbrelated statements in callejb method of CommProtocolLinkIdAddModifyServlet  :"+ex.toString());
		exceptions=exceptions+"3"+"*"+ex.toString();
		ex.printStackTrace(System.err);

	}
	 try{
		ConnectionManager.returnConnection(connection);
	}catch(Exception ex){ System.out.println("Error in closing dbrealted statements in callejb method of CommProtocolLinkIdAddModifyServlet :"+ex.toString());
		   ex.printStackTrace(System.err); }
//	 System.out.println("status "+status);   
	    
	result_hm.put("exceptions",exceptions);
	result_hm.put("status",status);
	
	row_arr.clear();
	gen_arr.clear();
	

	return result_hm;  
}// end of function



}// end of class
