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

/**
*  The XHViewEventsOutboundServlet class used to implement the functionalities of  
*  Administered events and view events.
*  0utbound - Replay & Rebuild
*  Inbound  - Reload
*/

public class XHViewEventsOutboundServlet extends HttpServlet
{

	HttpServletRequest req=null;

	/**
	* Do post method which implements the functionalities for Replay and Rebuild and Reload
	* @param  HttpServletRequest request
	* @param  HttpServletResponse response
	* @throws IOException
	* @throws ServletException
	*/

	public void doPost (HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException 
	{

		PrintWriter out;
		Properties p = null;

		HttpSession session = null;
		Connection con= null;
		CallableStatement cs = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;

		String locale = null;
	//	String updateAudit = null;
		String urlParameters = "";

		MessageManager mm = null;

		try
		{
			session = request.getSession(false);
			p = (Properties) session.getValue("jdbc");	
			locale = p.getProperty("LOCALE");
			mm = new MessageManager();

			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");		

			out = response.getWriter();
			req = request;

			if(con == null) con = ConnectionManager.getConnection();
		}
		catch(Exception exp)
		{
			exp.printStackTrace(System.err);
		}

		try
		{
			String facilityId = XHDBAdapter.checkNull(request.getParameter("facilityId"));
			String applicationId = XHDBAdapter.checkNull(request.getParameter("applicationId"));
			String messageId = XHDBAdapter.checkNull(request.getParameter("messageId"));
			String buttonInvoked = request.getParameter("buttonInvoked");
			String msg_id1,msg_dt1,msg_id2,msg_dt2,msg_status,facility,orderBy,order,reason,pat_id,merg_pat_id,episode_type,episode_id,visit_id,action_typ,last_processed_date,not_req_rsn,addid,addeddate,addedwsno,modfid,modifieddate,modifiedwsno,msg_date,applnname,eventtype,purge_status;
			String message_text2="";
			//String purge_status="";

			msg_id1 = null;
			msg_dt1 = null;
			msg_id2 = null;
			msg_dt2 = null;
			msg_status = null;
			facility = null;
			reason = null;
			pat_id = null;
			merg_pat_id = null;
			episode_type = null;
			episode_id = null;
			visit_id = null;
			action_typ = null;
			last_processed_date = null;
			not_req_rsn = null;
			addid = null;
			addeddate = null;
			addedwsno = null;
			modfid = null;
			modifieddate = null;
			modifiedwsno = null;
			msg_date = null;
			orderBy = null;
			order = null;
			applnname = null;
			eventtype = null;
			purge_status = null;

			String sub_module = "";
			String interface_module = "";
			String protocol_link_id = "";
			String event_status = null;	

			msg_status = XHDBAdapter.checkNull(request.getParameter("msg_status"));
			facility = XHDBAdapter.checkNull(request.getParameter("facility")); 
			msg_id1 = XHDBAdapter.checkNull(request.getParameter("msg_id1")); 
			msg_id2 = XHDBAdapter.checkNull(request.getParameter("msg_id2"));  
			msg_dt1 = XHDBAdapter.checkNull(request.getParameter("msg_dt1")); 
			msg_dt2 = XHDBAdapter.checkNull(request.getParameter("msg_dt2")); 
			pat_id = XHDBAdapter.checkNull(request.getParameter("pat_id"));
			merg_pat_id = XHDBAdapter.checkNull(request.getParameter("merg_pat_id"));
			episode_type = XHDBAdapter.checkNull(request.getParameter("episode_type"));
			episode_id = XHDBAdapter.checkNull(request.getParameter("episode_id"));
			visit_id = XHDBAdapter.checkNull(request.getParameter("visit_id"));
			action_typ = XHDBAdapter.checkNull(request.getParameter("action_typ"));
			last_processed_date = XHDBAdapter.checkNull(request.getParameter("last_processed_date"));
			not_req_rsn = XHDBAdapter.checkNull(request.getParameter("not_req_rsn"));
			addid = XHDBAdapter.checkNull(request.getParameter("addid"));
			addeddate = XHDBAdapter.checkNull(request.getParameter("addeddate"));
			addedwsno = XHDBAdapter.checkNull(request.getParameter("addedwsno"));
			modfid = XHDBAdapter.checkNull(request.getParameter("modfid"));
			modifieddate = XHDBAdapter.checkNull(request.getParameter("modifieddate"));
			modifiedwsno = XHDBAdapter.checkNull(request.getParameter("modifiedwsno"));
			msg_date = XHDBAdapter.checkNull(request.getParameter("msg_date"));
			orderBy = XHDBAdapter.checkNull(request.getParameter("orderBy"));
			order = XHDBAdapter.checkNull(request.getParameter("order"));
			eventtype = XHDBAdapter.checkNull(request.getParameter("eventType"));
			applnname = XHDBAdapter.checkNull(request.getParameter("applnname"));
			purge_status = XHDBAdapter.checkNull(request.getParameter("purge_status"));
			sub_module = XHDBAdapter.checkNull(request.getParameter("sub_module"));
			interface_module = XHDBAdapter.checkNull(request.getParameter("interface_module"));
			protocol_link_id = XHDBAdapter.checkNull(request.getParameter("protocol_link_id"));
			event_status = XHDBAdapter.checkNull(request.getParameter("event_status"));
			String isReview = XHDBAdapter.checkNull(request.getParameter("functionType"));			

			String protocolMode = XHDBAdapter.checkNull(request.getParameter("protocolMode"));
			String accessionNumber = XHDBAdapter.checkNull(request.getParameter("accessionNumber"));
			String msgDate = XHDBAdapter.checkNull(request.getParameter("msgDate"));
			String protocolID = XHDBAdapter.checkNull(request.getParameter("protocolID"));
			String srlNo = XHDBAdapter.checkNull(request.getParameter("srlNo"));
			String commMode = null;
			String queueType = XHDBAdapter.checkNull(request.getParameter("purge_status"));

			if(queueType != null && queueType.equals("")) queueType = "ONLINE";

	//		System.out.println(" Review "+queueType );

			if(buttonInvoked.equals("replay"))
			{
				cs = con.prepareCall("{ call XHMSG.REPLAY(?,?,?,?,?,?,?) }" ); 
				cs.setString(1,sub_module);
				cs.setString(2,facilityId);
				cs.setString(3,applicationId);
				cs.setString(4,messageId);
				cs.setString(5,queueType);				
				cs.registerOutParameter(6,java.sql.Types.VARCHAR);
				cs.registerOutParameter(7,java.sql.Types.VARCHAR);
				cs.execute();
				message_text2 = cs.getString(6);
				commMode = "outbound";
			}		 
			else if(buttonInvoked.equals("rebuild"))
			{
				cs = con.prepareCall("{ call XHGENERIC.MESSAGE_REBUILD(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }" ); 
				cs.setString(1,sub_module);
				cs.setString(2,"O");
				cs.setString(3,applicationId );
//				System.out.println("protocolMode "+protocolMode);
				cs.setString(4,eventtype );
				cs.setString(5,facilityId);
				cs.setString(6,accessionNumber);
				cs.setString(7,messageId );
				cs.setString(8,msgDate );
				cs.setString(9,protocol_link_id);
				cs.setString(10,pat_id);
				cs.setString(11,episode_type);
				cs.setString(12,episode_id);
				cs.setString(13,visit_id);
				cs.setString(14,protocolID);
				cs.setString(15,queueType);
				cs.registerOutParameter(16,java.sql.Types.VARCHAR);
	//			System.out.println("-- Rebuild --");
				cs.execute();
				message_text2 = cs.getString(16);				
				commMode = "outbound";
			}
			else if(buttonInvoked.equals("reload"))
			{																
				cs = con.prepareCall("{ call XHGENERIC.message_reload(?,?,?,?,?,?,?,?,?) }" ); 
				cs.setString(1,sub_module);
				cs.setString(2,"I");				
				cs.setString(3,applicationId);
				cs.setString(4,facilityId);
				cs.setString(5,messageId);
				cs.setString(6,srlNo);
				cs.setString(7,eventtype);
				cs.setString(8,queueType);
				cs.registerOutParameter(9,java.sql.Types.VARCHAR);
				
				cs.execute();
				message_text2 = cs.getString(9);
				
				commMode = "inbound";
			/*	if(message_text2.equals("0"))
				{					
					urlParameters = "&purge_status=OFFLINE";
				}
			*/
			}

			if("Review".equals(isReview)) commMode = "Review";

			msg_id1 = msg_id2 = messageId;

			if(cs != null) cs.close();  
	//		System.out.println("(XHViewEventsOutboundServlet:doPost)message_text2: "+message_text2);
			if(message_text2.equals("0"))
			{
				con.commit();
				final java.util.Hashtable mesg = mm.getMessage(locale,"XH1001", "XH");
			//	final java.util.Hashtable mesg = mm.getMessage(con,"XH1001");
				message_text2 = ((String) mesg.get("message"));
			}
			else
			{				
				final java.util.Hashtable mesg = mm.getMessage(locale, "XH1000", "XH");
			//	final java.util.Hashtable mesg = mm.getMessage(con,"XH1000");
				con.rollback();
				message_text2 = ((String) mesg.get("message"));
			}
			if(cs!=null) cs.close(); 
						
		//	String urlParameters="&msg_id1="+msg_id1+"&msg_dt1="+msg_dt1+"&msg_id2="+msg_id2+"&msg_dt2="+msg_dt2+"&msg_status="+msg_status+"&facility="+facility+"&orderBy="+orderBy+"&order="+order+"&reason="+reason+"&pat_id="+pat_id+"&merg_pat_id="+merg_pat_id+"&episode_type="+episode_type+"&episode_id="+episode_id+"&visit_id="+visit_id+"&action_typ="+action_typ+"&last_processed_date="+last_processed_date+"&not_req_rsn="+not_req_rsn+"&addid="+addid+"&addeddate="+addeddate+"&addedwsno="+addedwsno+"&modfid="+modfid+"&modifieddate="+modifieddate+"&modifiedwsno="+modifiedwsno+"&msg_date="+msg_date+"&eventtype="+eventtype+"&applnname="+applnname+"&purge_status="+purge_status+"&interface_module="+interface_module+"&sub_module="+sub_module+"&protocol_link_id="+protocol_link_id+"&event_status="+event_status;

			String status=message_text2;
			urlParameters = urlParameters + "&msg_id1="+msg_id1+"&msg_id2="+msg_id2+"&applnname="+applicationId+"&facility="+facilityId+"&srlNo="+srlNo+"&comm_mode="+commMode+"&protocolMode="+protocolMode;

			RequestDispatcher reqDis =	session.getServletContext().getRequestDispatcher("/eXH/jsp/ViewDisplayResult.jsp?&message="+status+urlParameters);
			reqDis.forward(request,response);

		}catch(Exception ex)
		{ 			
			ex.printStackTrace(System.err);
		}
		finally{
			try
			{
				if(cs != null) cs.close(); 
				if(pstmt != null) pstmt.close();
				if(stmt != null) stmt.close();
				if(con!=null) ConnectionManager.returnConnection(con);
			}catch(Exception ex){ ex.printStackTrace(System.err); }
		}

	}// end of do post

}// end of class
