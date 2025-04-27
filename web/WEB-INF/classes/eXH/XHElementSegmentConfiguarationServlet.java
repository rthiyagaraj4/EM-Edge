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
 * Servlet to deal with Element Segment Configuaration data. 
 *
 */
public class XHElementSegmentConfiguarationServlet extends HttpServlet
{

HttpServletRequest req=null;

/**
	 * doPost -- inserts a new record in xh_event_segment_config table (Element Segment Config)
	 * @param  HttpServletRequest request
	 * @param  HttpServletResponse response
	 * @throws IOException
	 * @throws ServletException
	 */
	
public void doPost (HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException 
{	
		PrintWriter out = response.getWriter();
		req=request;
		
			
		HttpSession session=request.getSession(false);
		Properties p;		
		p = (Properties) session.getValue("jdbc");	
		String locale  = p.getProperty("LOCALE");

		request.setCharacterEncoding("UTF-8");
   	    response.setContentType("text/html;charset=UTF-8");
		
		String p_mode=request.getParameter("act_mode");
		String configType = request.getParameter("config_type");
		String configName = request.getParameter("config_id");
		String data_src_type = request.getParameter("datasrc_type");
		String queryText = request.getParameter("query_text");
		String sysDefStructure = request.getParameter("SysDefStr");
		String stnd_code = request.getParameter("stnd_code");
		String profile_id = request.getParameter("profile_id");	
	
		ArrayList arrColumn=null;
		ArrayList array_audit=null;
		
		arrColumn=new ArrayList();

		arrColumn.add(p_mode);
		arrColumn.add(configType);
		arrColumn.add(configName);
		arrColumn.add(data_src_type);
		arrColumn.add(queryText);		
		arrColumn.add(sysDefStructure);
		arrColumn.add(stnd_code);
		arrColumn.add(profile_id);

		array_audit=new ArrayList();
		array_audit = ArrayAuditInfo.getArrayAuditInfo(session);		

		HashMap details_hm= new HashMap();
		details_hm.put("row_details",arrColumn);
		details_hm.put("gen_details",array_audit);
		HashMap result_hm=new HashMap();
		result_hm=callEJB(details_hm,locale );	
		
        RequestDispatcher reqDis = 	session.getServletContext().getRequestDispatcher("/eXH/jsp/DisplayResult.jsp?message="+(String)result_hm.get("status"));
        reqDis.forward(request,response);		


	}// end of do post

	/**
	 * callEJB method is used to call CommProtocolId setup related database procedures
	 * @param  HashMap details_hm
	 * @param  String locale
	 */
   public HashMap callEJB(HashMap details_hm,String locale )
   {
    

	Connection connection = null;
	CallableStatement ostmt = null;
	CallableStatement ostmt2 = null;
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
      catch(Exception exp){

		System.out.println("Error in calling getconnection method of CommProtocolIdAddModifyServlet  :"+exp.toString());
		exp.printStackTrace(System.err);
		exceptions=exceptions+"1"+"*"+exp.toString();
        
      }
 
	  try
	  {

		  ostmt = connection.prepareCall("{ call Xg_prc.xh_event_segment_config(?,?,?,?,?,?,?,?,?,?,?,?) }" ); 
	 
		  String  p_mode=(String)row_arr.get(0);
   	      String  configType=(String)row_arr.get(1);
		  String  configName=(String)row_arr.get(2);
		  String  data_src_type=(String)row_arr.get(3);
		  String  queryText=(String)row_arr.get(4);
		  String  sysDefStructure=(String)row_arr.get(5);
	      String  stnd_code=(String)row_arr.get(6);
		  String  profile_id=(String)row_arr.get(7);

  		  String  usr_added_by_id=(String)gen_arr.get(0);
		  String  usr_added_at_ws_no=(String)gen_arr.get(1);

//		ostmt = connection.prepareCall(query);

		ostmt.setString(1,p_mode);
		ostmt.setString(2,configName);
		ostmt.setString(3,configType);
		ostmt.setString(4,queryText);
		ostmt.setString(5,sysDefStructure);
		ostmt.setString(6,usr_added_by_id);
		ostmt.setString(7,usr_added_at_ws_no);
		ostmt.setString(8,data_src_type);
	    ostmt.setString(9,stnd_code);
		ostmt.setString(10,profile_id);
	 
	    ostmt.registerOutParameter(11,java.sql.Types.VARCHAR);
	    ostmt.registerOutParameter(12,java.sql.Types.VARCHAR);
	    ostmt.execute();

		String status2= ostmt.getString(11);
	    message_text2 = ostmt.getString(12);

	    ostmt.close();

		if(status2.equals("0"))
		{
            connection.commit();
			if(p_mode.equals("I")||p_mode.equals("U")){
				ostmt2 = connection.prepareCall("{ call Xg_prc.default_values_insert(?,?,?,?,?) }" ); 
	
				ostmt2.setString(1,sysDefStructure);
  				ostmt2.setString(2,configType);
				ostmt2.setString(3,stnd_code);
				ostmt2.setString(4,configName);
				ostmt2.registerOutParameter(5,java.sql.Types.VARCHAR);
			
				ostmt2.execute();

				message_text2 = XHDBAdapter.checkNull(ostmt2.getString(5));

				ostmt2.close();
			}
			if(status2.equals("0")||message_text2.equals("")){
			    connection.commit();
				final java.util.Hashtable mesg = mm.getMessage(locale, "XH1001", "XH") ;
				status = ((String) mesg.get("message"));
			}
		}
		else if(status2.equals("2")){
			connection.rollback();
			final java.util.Hashtable mesg = mm.getMessage(locale, "CODE_ALREADY_EXISTS", "Common") ;
			status = ((String) mesg.get("message"));		
		}
        else
		{
                connection.rollback();
				final java.util.Hashtable mesg = mm.getMessage(locale, "XH1000", "XH") ;
				status = ((String) mesg.get("message"));		
		}

	 XHDBAdapter.closeCursor(ostmt);
	
	}catch(Exception ex)
	{ 
		 System.out.println("Error in calling dbrelated statements in callejb method of CommProtocolIdAddModifyServlet  :"+ex.toString());
		exceptions=exceptions+"3"+"*"+ex.toString();
		ex.printStackTrace(System.err);

	}
	try{
		ConnectionManager.returnConnection(connection);
	}catch(Exception ex){ System.out.println("Error in closing dbrealted statements in callejb method of CommProtocolIdAddModifyServlet :"+ex.toString());
		   ex.printStackTrace(System.err); 
	}
//	 System.out.println("status "+status);   
	    
//	status=message_text2;
	result_hm.put("exceptions",exceptions);
	result_hm.put("status",status);

	return result_hm;  
}// end of callEJB function


}//end of class 
