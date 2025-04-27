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
 *  Class used to insert new protocol link ID for the application
 *
 */
public class AddProtocolLinkIDServlet extends HttpServlet
{

    HttpServletRequest req=null;
   /**
	 * Do post method which implements the functionalities for  adding new protocol link
	 * @param  HttpServletRequest request
	 * @param  HttpServletResponse response
	 */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException
    {
        PrintWriter out;
		CallableStatement ostmt1 = null;
		out=response.getWriter();
		req=request;
		
        HttpSession session=request.getSession(false);
		Properties p;		
		p = (Properties) session.getValue("jdbc");	
		String locale  = p.getProperty("LOCALE");

		request.setCharacterEncoding("UTF-8");
   	    response.setContentType("text/html;charset=UTF-8");
        
        ResultSet rs1 = null;
        Statement stmt1 = null;

		String status = "";
		MessageManager mm=new MessageManager();
        
        Connection connection = null;
       
    	String applicationID = XHDBAdapter.checkNull(request.getParameter("applicationID"));
		String facilityID = XHDBAdapter.checkNull(request.getParameter("facilityID"));
		String protocol_mode = XHDBAdapter.checkNull(request.getParameter("protocol_mode"));
		String client_ID = XHDBAdapter.checkNull(request.getParameter("client_id"));
		String in_use = XHDBAdapter.checkNull(request.getParameter("in_use"));
		String clientName = XHDBAdapter.checkNull(request.getParameter("clientName"));
		String INBOUND_YN = XHDBAdapter.checkNull(request.getParameter("INBOUND_YN"));
		String OUTBOUND_YN = XHDBAdapter.checkNull(request.getParameter("OUTBOUND_YN"));
		String mainInUse = XHDBAdapter.checkNull(request.getParameter("mainInUse"));

		String reportOPDir = "C:/eHIS/reports/";

		String sqlStmt1 = "SELECT PROTOCOL_LINK_ID,PROTOCOL_LINK_NAME FROM XH_PROTOCOL_LINK "+
								" WHERE APPLICATION_ID LIKE '"+applicationID+"%'"+ 
								" AND protocol_id IN"+
								" (SELECT protocol_id FROM xh_protocol WHERE protcol_mode='"+protocol_mode+"')ORDER BY 1";
		String checked = "";
		String message_text2 = "";

		ArrayList array_audit=new ArrayList();
		array_audit = ArrayAuditInfo.getArrayAuditInfo(session);
		String usr_added_by_id = (String)array_audit.get(0);
		String usr_added_at_ws_no = (String)array_audit.get(1);
		String usr_added_facility_id = (String)array_audit.get(2);
		String usr_protocol_link_id = null;		

		if(facilityID == null || facilityID.equals(""))
			facilityID = "XX";

		try
		{
			connection = ConnectionManager.getConnection();
			stmt1 = connection.createStatement();
			rs1 = stmt1.executeQuery(sqlStmt1);
			while(rs1.next())
			{
				checked = null;
				String temp = "check_"+rs1.getString("PROTOCOL_LINK_ID");
				checked = request.getParameter(temp);	
				usr_protocol_link_id = rs1.getString("PROTOCOL_LINK_ID");

			/*	System.out.println("protocol_mode "+protocol_mode);
				System.out.println("CLIENT ID "+client_ID);
				System.out.println("CLIENT Name "+clientName);
				System.out.println("INBOUND_YN "+INBOUND_YN);
				System.out.println("OUTBOUND_YN "+OUTBOUND_YN);
				System.out.println("mainInUse "+mainInUse);
				System.out.println("applicationID "+applicationID);
				System.out.println("facilityID "+facilityID);
				System.out.println("in_use "+in_use);
				System.out.println("usr_added_by_id "+array_audit.get(0));
				System.out.println("usr_added_at_ws_no "+array_audit.get(1));
				System.out.println("usr_added_facility_id "+array_audit.get(2));
				System.out.println("PROTOCOL_LINK_ID "+rs1.getString("PROTOCOL_LINK_ID"));
				System.out.println("CHECKED "+checked);	
			*/

				if(checked != null && protocol_mode != null && protocol_mode.equalsIgnoreCase("O"))
				{
					ostmt1 = connection.prepareCall("{ call xhmast.communication_client_outbound(?,?,?,?,?,?,?,?,?,?,?,?) }" );
					ostmt1.setString(1,"I");
					ostmt1.setString(2,client_ID);
					ostmt1.setString(3,applicationID);
					ostmt1.setString(4,facilityID);
					ostmt1.setString(5,"N");							  
					ostmt1.setString(6,reportOPDir);
					ostmt1.setString(7,usr_added_by_id);
					ostmt1.setString(8,usr_added_at_ws_no);
					ostmt1.setString(9,usr_added_facility_id);

					ostmt1.registerOutParameter(10,java.sql.Types.VARCHAR);
					ostmt1.registerOutParameter(11,java.sql.Types.VARCHAR);

					ostmt1.setString(12,usr_protocol_link_id);
				    
					ostmt1.execute();

					message_text2 = ostmt1.getString(10);								

				    if(message_text2.equals("0"))
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

				    if(ostmt1 != null) ostmt1.close();
				}
				else if(checked != null && protocol_mode != null && protocol_mode.equalsIgnoreCase("I"))
				{
					ostmt1 = null;
					ostmt1 = connection.prepareCall("{ call xhmast.communication_client_inbound(?,?,?,?,?,?,?,?,?,?,?,?) }" );
					ostmt1.setString(1,"I");
					ostmt1.setString(2,client_ID);
					ostmt1.setString(3,applicationID);
					ostmt1.setString(4,facilityID);
					ostmt1.setString(5,in_use);							  
					ostmt1.setString(6,reportOPDir);
					ostmt1.setString(7,usr_added_by_id);
					ostmt1.setString(8,usr_added_at_ws_no);
					ostmt1.setString(9,usr_added_facility_id);

					ostmt1.registerOutParameter(10,java.sql.Types.VARCHAR);
					ostmt1.registerOutParameter(11,java.sql.Types.VARCHAR);

					ostmt1.setString(12,usr_protocol_link_id);
				    
					ostmt1.execute();

					message_text2 = ostmt1.getString(10);								

				    if(message_text2.equals("0"))
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
				}							
			}

			String queryString = "mode=U&client_id="+client_ID+"&client_name="+clientName+"&main_outbound_in_use="+OUTBOUND_YN+"&main_inbound_in_use="+INBOUND_YN+"&main_in_use="+mainInUse+"&inbound_tcp_addr=000.00.000.000&inbound_port_num=0000&message="+status;

			RequestDispatcher reqDis = 	session.getServletContext().getRequestDispatcher("/eXH/jsp/RefreshPage.jsp?action=CommunicationClientMaster.jsp&"+queryString);
			reqDis.forward(request,response);
		}
		catch(Exception exception)
		{
			exception.printStackTrace(System.err);
		}
		finally
		{
			try
			{
				ConnectionManager.returnConnection(connection);
				if(stmt1 != null) stmt1.close();
				if(rs1 != null)	rs1.close();
				if(ostmt1!=null) ostmt1.close();
				array_audit.clear();
			}
			catch(Exception ex)
			{
				System.out.println("Error in calling closing dbconnection in finally block of AddProtocolLinkIDServlet :"+ex.toString());
				ex.printStackTrace(System.err);
			}
		}

    }//end of do post

}//end of class															
