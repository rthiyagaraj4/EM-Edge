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
*  Class used to update communication client setup
*
*/
public class CommunicationClientMasterServlet extends HttpServlet
{
	HttpServletRequest req=null;
	String locale = "";
	PrintWriter out = null;
	boolean responseSent = false;
	HttpSession session = null;

	/**
	* Do post method which implements the functionalities for  communication client setup
	* @param  HttpServletRequest request
	* @param  HttpServletResponse response
	*/
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException
	{				
		req=request;

		session=request.getSession(false);
		Properties p;		
		p = (Properties) session.getValue("jdbc");	
		locale  = p.getProperty("LOCALE");

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		RequestDispatcher reqDis = null;

		this.out = response.getWriter();

		ResultSet rs1 = null;
		Statement stmt1 = null;

		ResultSet rs2 = null;
		Statement stmt2 = null;

		Connection connection = null;

		String mode = request.getParameter("tab_mode");
		String updateMode = request.getParameter("update_mode");		

		String CLIENT_ID = XHDBAdapter.checkNull(request.getParameter("client_id")); 
		String CLIENT_NAME = XHDBAdapter.checkNull(request.getParameter("client_name"));            
		String OUTBOUND_YN = XHDBAdapter.checkNullForCheckBox(request.getParameter("main_outbound_in_use"));
		String INBOUND_YN = XHDBAdapter.checkNullForCheckBox(request.getParameter("main_inbound_in_use"));             
		String INBOUND_IP_ADDRESS = XHDBAdapter.checkNull(request.getParameter("inbound_tcp_addr"));     
		String INBOUND_PORT_NUMBER = XHDBAdapter.checkNull(request.getParameter("inbound_port_num"));     
		String IN_USE_YN = XHDBAdapter.checkNullForCheckBox(request.getParameter("main_in_use")); 		

	/*	System.out.println("CLIENT_ID :"+CLIENT_ID);
		System.out.println("OUTBOUND_YN :"+OUTBOUND_YN);
		System.out.println("INBOUND_YN :"+INBOUND_YN);
		System.out.println("INBOUND_IP_ADDRESS :"+INBOUND_IP_ADDRESS);
		System.out.println("INBOUND_PORT_NUMBER :"+INBOUND_PORT_NUMBER);
		System.out.println("CLIENT_NAME :"+CLIENT_NAME);
		System.out.println("IN_USE_YN :"+IN_USE_YN);
	*/
	
		ArrayList client_main = new ArrayList();
		ArrayList client_outbound = new ArrayList();
		ArrayList client_inbound = new ArrayList();


		if(updateMode != null && !updateMode.equalsIgnoreCase(""))
		{			
			String status = deleteProtocolLinkId();		
			if(responseSent)
			{
				String forward = "<script>parent.f_query_add_mod.location.href='../eXH/jsp/CommunicationClientMaster.jsp?forwardRequest=Y&mode=U&locale=en&client_id="+CLIENT_ID+"'</script>";
				out.print(forward);
				out.flush();
			}
			else
			{
				reqDis = session.getServletContext().getRequestDispatcher("/eXH/jsp/DisplayResult.jsp?message="+status);			
			}
		}
		else
		{				
			try
			{
				connection = ConnectionManager.getConnection();

				client_main.add(mode);
				client_main.add(CLIENT_ID);
				client_main.add(CLIENT_NAME);
				client_main.add(OUTBOUND_YN);
				client_main.add(INBOUND_YN);
				client_main.add(INBOUND_IP_ADDRESS);
				client_main.add(INBOUND_PORT_NUMBER);
				client_main.add(IN_USE_YN);
				
				ArrayList array_out_temp = null;
				XHFacilityControllerBean xhBean = XHFacilityControllerBean.getBean(XHFacilityControllerBean.strBeanName,request,session);
				xhBean.action(request,connection);

				String strData[][] = xhBean.getDatabaseData();
				xhBean.action(request,connection);
			//	System.out.println("outbound facility bean  :"+strData.length);
				for(int i=0;i<strData.length;i++)
				{
					array_out_temp = new ArrayList();
					array_out_temp.add(mode);
					array_out_temp.add(CLIENT_ID);
					array_out_temp.add(strData[i][0]);
					array_out_temp.add(strData[i][2]);
					array_out_temp.add(strData[i][4]);
					array_out_temp.add(strData[i][5]);
					array_out_temp.add(strData[i][6]);					
				//	System.out.println("FACILITY NAME "+strData[i][4]);
				//	System.out.println(strData[i][0]+" PROTOCOL LINK ID "+strData[i][5]);
					client_outbound.add(array_out_temp);			
				}

				ArrayList array_in_temp = null;
				XHFacilityInboundControllerBean xhBean1=XHFacilityInboundControllerBean.getBean(XHFacilityInboundControllerBean.strBeanName,request,session);
				xhBean1.action(request,connection);
				String strData1[][] = xhBean1.getDatabaseData();
				xhBean1.action(request,connection);
				//System.out.println("inbound facility bean  :"+strData1.length);
				for(int i=0;i<strData1.length;i++)
				{
					array_in_temp = new ArrayList();
					array_in_temp.add(mode);
					array_in_temp.add(CLIENT_ID);
					array_in_temp.add(strData1[i][0]);
					array_in_temp.add(strData1[i][2]);
					array_in_temp.add(strData1[i][4]);
					array_in_temp.add(strData1[i][5]);					
					array_in_temp.add(strData1[i][6]);					
					client_inbound.add(array_in_temp);			
				}
				array_out_temp.clear();
				array_in_temp.clear();
				
			}
			catch(Exception exception)
			{
				System.out.println("Error in dopost method of communicationclientmasterservlet :"+exception.toString());
				exception.printStackTrace(System.err);
			}
			finally
			{
				try
				{
					if(rs1 != null) rs1.close();
					if(rs2 != null) rs2.close();
					if(stmt1 != null) stmt1.close();
					if(stmt2 != null) stmt2.close();
					connection.close();
				}
				catch(Exception exception2)
				{ 
					System.out.println("Error(1) in closing statements in dopost method of communicationclientmasterservlet:"+exception2.toString());
					exception2.printStackTrace(System.err); 
				}
			}

			ArrayList array_audit=new ArrayList();
			array_audit = ArrayAuditInfo.getArrayAuditInfo(session);

			HashMap details_hm = new HashMap();
			details_hm.put("client_main", client_main);
			details_hm.put("client_outbound", client_outbound);
			details_hm.put("client_inbound", client_inbound);
			details_hm.put("gen_details",array_audit);

			HashMap result_hm=new HashMap();
			result_hm=callEJB(details_hm,locale);			
			
			String queryString = "mode=U&client_id="+CLIENT_ID+"&client_name="+CLIENT_NAME+"&main_outbound_in_use="+OUTBOUND_YN+"&main_inbound_in_use="+INBOUND_YN+"&main_in_use="+IN_USE_YN+"&inbound_tcp_addr="+INBOUND_IP_ADDRESS+"&inbound_port_num="+INBOUND_PORT_NUMBER+"&message="+(String)result_hm.get("status");

			if(mode != null && mode.equalsIgnoreCase("I"))
			{
				queryString = "mode=I&message="+(String)result_hm.get("status");
			}

			reqDis = session.getServletContext().getRequestDispatcher("/eXH/jsp/RefreshPage.jsp?action=CommunicationClientMaster.jsp&"+queryString);
			array_audit.clear();
		}	
		if(!responseSent)
		reqDis.forward(request,response);	
		client_main.clear();
		client_outbound.clear();
		client_inbound.clear();
		
		

	}//end of do post

	/**
	* callEJB method is used to call communication client setup related database procedures
	* @param  HashMap details_hm
	* @param  String locale
	*/
	public HashMap callEJB(HashMap details_hm,String locale)
	{
		Connection connection = null;
		CallableStatement ostmt1 = null;
		CallableStatement ostmt2 = null;
		CallableStatement ostmt3 = null;
		String message_text2 = "";

		String status="";
		String exceptions="";
		HashMap result_hm=new HashMap();
		MessageManager mm=new MessageManager();

		boolean chkStatusFlag1=false;
		boolean chkStatusFlag2=false;
		boolean chkStatusFlag3=false;
		boolean chkStat=false;
		boolean childExists = false;

		ArrayList client_main = (ArrayList) details_hm.get("client_main");
		ArrayList client_outbound = (ArrayList) details_hm.get("client_outbound");	
		ArrayList client_inbound = (ArrayList) details_hm.get("client_inbound");	
		ArrayList gen_arr = (ArrayList) details_hm.get("gen_details");

		String  OUTBOUND_YN=(String)client_main.get(3);				
		String  INBOUND_YN=(String)client_main.get(4);

		if(client_outbound.size()==0){chkStatusFlag2=true;}
		if(client_inbound.size()==0){chkStatusFlag3=true;}
		try
		{
			connection = ConnectionManager.getConnection();        

			//now calling the proc that adds the main client details 	
			try
			{
				ostmt1 = connection.prepareCall("{ call xhmast.communication_client(?,?,?,?,?,?,?,?,?,?,?,?,?) }" ); 

				String  mode=(String)client_main.get(0);				
				String  CLIENT_ID=(String)client_main.get(1);				
				String  CLIENT_NAME=(String)client_main.get(2);												
				String  INBOUND_IP_ADDRESS=(String)client_main.get(5);				
				String  INBOUND_PORT_NUMBER=(String)client_main.get(6);				
				String  IN_USE_YN=(String)client_main.get(7);

			/*  System.out.println("mode  :"+mode);
				System.out.println("CLIENT_ID  :"+CLIENT_ID);
				System.out.println("CLIENT_NAME  :"+CLIENT_NAME);
				System.out.println("OUTBOUND_YN  :"+OUTBOUND_YN);
				System.out.println("INBOUND_YN  :"+INBOUND_YN);
				System.out.println("INBOUND_IP_ADDRESS  :"+INBOUND_IP_ADDRESS);
				System.out.println("INBOUND_PORT_NUMBER  :"+INBOUND_PORT_NUMBER);
			*/
				String  usr_added_by_id=(String)gen_arr.get(0);				
				String  usr_added_at_ws_no=(String)gen_arr.get(1);				
				String  usr_facility_id=(String)gen_arr.get(2);

			/*  System.out.println("usr_added_by_id  :"+usr_added_by_id);
				System.out.println("usr_added_at_ws_no  :"+usr_added_at_ws_no);
				System.out.println("usr_facility_id  :"+usr_facility_id);
			*/
				ostmt1.setString(1,mode);
				ostmt1.setString(2,CLIENT_ID);
				ostmt1.setString(3,CLIENT_NAME);
				ostmt1.setString(4,OUTBOUND_YN);
				ostmt1.setString(5,INBOUND_YN);
				ostmt1.setString(6,INBOUND_IP_ADDRESS);
				ostmt1.setString(7,INBOUND_PORT_NUMBER);
				ostmt1.setString(8,IN_USE_YN);

				ostmt1.setString(9,usr_added_by_id);
				ostmt1.setString(10,usr_added_at_ws_no);
				ostmt1.setString(11,usr_facility_id);

				ostmt1.registerOutParameter(12,java.sql.Types.VARCHAR);
				ostmt1.registerOutParameter(13,java.sql.Types.VARCHAR);
				
				ostmt1.execute();				

				message_text2 = ostmt1.getString(12);				
				status = ostmt1.getString(13); // Message returned from the procedure				
				chkStat = containsSubstring(status,"Unique");
				
			/*	System.out.println("status  :"+status);
				System.out.println("chkStat  :"+chkStat);				
			*/
				if(message_text2.equals("0"))
				{					
					connection.commit();
					chkStatusFlag1 = true;								
				}
				else if (message_text2.equals("2"))
				{						
					connection.rollback();
					chkStat = true;
					chkStatusFlag1 = false;								
				}
				else if (message_text2.equals("3"))
				{						
					connection.rollback();
					chkStat = true;
					childExists = true;
					chkStatusFlag1 = false;								
				}
				else
				{					
					connection.rollback();
					chkStatusFlag1 = false;								
				}
				if(ostmt1 != null) ostmt1.close();

			}
			catch(Exception ex)
			{
				System.out.println("Error(1) in calling db related statements in callejb method of communicationclientmasterservlet :"+ex.toString());
				ex.printStackTrace(System.err); 
				exceptions=exceptions+"3a"+"*"+ex.toString();
			}
			status=status+message_text2;
			
			//now calling the proc that adds clinet comm outbound details

			ArrayList arr_outbound_temp=null;

			chkStatusFlag2 = true;
			if(OUTBOUND_YN != null && OUTBOUND_YN.equalsIgnoreCase("Y") && !chkStat)
			{
				chkStatusFlag2 = false;
				for (int j=0;j<client_outbound.size();j++)
				{
					arr_outbound_temp = (ArrayList)client_outbound.get(j);
					try
					{								
						ostmt2 = connection.prepareCall("{ call xhmast.communication_client_outbound(?,?,?,?,?,?,?,?,?,?,?,?) }" ); 

						String mode = (String)arr_outbound_temp.get(0);
						String CLIENT_ID = (String)arr_outbound_temp.get(1);
						String OUTBOUND_APPLICATION_ID = (String)arr_outbound_temp.get(2);
						String OUTBOUND_FACILITY_ID = (String)arr_outbound_temp.get(3);
						String IN_USE_YN_COMM = (String)arr_outbound_temp.get(4);
						String reportOPDir = XHDBAdapter.checkNull((String)arr_outbound_temp.get(6));
						String usr_added_by_id = (String)gen_arr.get(0);
						String usr_added_at_ws_no = (String)gen_arr.get(1);
						String usr_facility_id = (String)gen_arr.get(2);					
						String usr_protocol_link_id = (String)arr_outbound_temp.get(5);
					/*
						System.out.println("mode  :"+mode);
						System.out.println("CLIENT_ID :"+CLIENT_ID);
						System.out.println("OUTBOUND_APPLICATION_ID  :"+OUTBOUND_APPLICATION_ID);
						System.out.println("OUTBOUND_FACILITY_ID :"+OUTBOUND_FACILITY_ID);	
						System.out.println("IN_USE_YN_COMM  :"+IN_USE_YN_COMM);		  	
						System.out.println("usr_added_by_id  :"+usr_added_by_id);	
						System.out.println("usr_added_at_ws_no  :"+usr_added_at_ws_no);	
						System.out.println("usr_facility_id :"+usr_facility_id);		 
						System.out.println("usr_protocol_link_id  :"+usr_protocol_link_id);
					*/
						ostmt2.setString(1,mode);
						ostmt2.setString(2,CLIENT_ID);
						ostmt2.setString(3,OUTBOUND_APPLICATION_ID);
						ostmt2.setString(4,OUTBOUND_FACILITY_ID);
						ostmt2.setString(5,IN_USE_YN_COMM);						
						ostmt2.setString(6,reportOPDir);	
						ostmt2.setString(7,usr_added_by_id);
						ostmt2.setString(8,usr_added_at_ws_no);
						ostmt2.setString(9,usr_facility_id);		
						ostmt2.registerOutParameter(10,java.sql.Types.VARCHAR);
						ostmt2.registerOutParameter(11,java.sql.Types.VARCHAR);
						ostmt2.setString(12,usr_protocol_link_id);

						ostmt2.execute();		 

						message_text2 = ostmt2.getString(10);
						

						if(message_text2.equals("0"))
						{			 
							connection.commit();				
							chkStatusFlag2=true;										
						}
						else
						{							
							connection.rollback();
							chkStatusFlag2=false;			
						}

						if(ostmt2!=null) ostmt2.close();
					}

					catch(Exception ex)
					{
						System.out.println("Error(2) in calling db related statements in callejb method of communicationclientmasterservlet :"+ex.toString());
						ex.printStackTrace(System.err); 
						exceptions=exceptions+"3b"+"*"+ex.toString();
					}
				}
			}
			status=status+message_text2;   
			
			arr_outbound_temp.clear();

			//now calling the proc that adds client comm inbound details

			ArrayList arr_inbound_temp=null;
			chkStatusFlag3 = true;
			if(INBOUND_YN != null && INBOUND_YN.equalsIgnoreCase("Y") && !chkStat)
			{
				chkStatusFlag3 = false;
				for (int j=0;j<client_inbound.size();j++)
				{
					arr_inbound_temp = (ArrayList)client_inbound.get(j);
					try
					{
						ostmt3 = connection.prepareCall("{ call xhmast.communication_client_inbound(?,?,?,?,?,?,?,?,?,?,?,?) }" ); 

						String mode = (String)arr_inbound_temp.get(0);
						String CLIENT_ID = (String)arr_inbound_temp.get(1);
						String INBOUND_APPLICATION_ID = (String)arr_inbound_temp.get(2);
						String INBOUND_FACILITY_ID = (String)arr_inbound_temp.get(3);
						String IN_USE_YN_COMM = (String)arr_inbound_temp.get(4);
						String reportOPDir = XHDBAdapter.checkNull((String)arr_inbound_temp.get(6));
						String INBOUND_PROTOCOL_LINK_ID = (String)arr_inbound_temp.get(5);
						String usr_added_by_id = (String)gen_arr.get(0);
						String usr_added_at_ws_no = (String)gen_arr.get(1);
						String usr_facility_id = (String)gen_arr.get(2);		      

					/*		  
						System.out.println("--- INBOUND ---");
						System.out.println("mode  :"+mode);
						System.out.println("CLIENT_ID :"+CLIENT_ID);
						System.out.println("INBOUND_APPLICATION_ID  :"+INBOUND_APPLICATION_ID);
						System.out.println("INBOUND_FACILITY_ID :"+INBOUND_FACILITY_ID);	
						System.out.println("IN_USE_YN_COMM  :"+IN_USE_YN_COMM);		  	
						System.out.println("INBOUND_PROTOCOL_LINK_ID  :"+INBOUND_PROTOCOL_LINK_ID);	
						System.out.println("usr_added_by_id  :"+usr_added_by_id);	
						System.out.println("usr_added_at_ws_no :"+usr_added_at_ws_no);		 
						System.out.println("usr_facility_id  :"+usr_facility_id);
					*/
						ostmt3.setString(1,mode);
						ostmt3.setString(2,CLIENT_ID);
						ostmt3.setString(3,INBOUND_APPLICATION_ID);
						ostmt3.setString(4,INBOUND_FACILITY_ID);
						ostmt3.setString(5,IN_USE_YN_COMM);						
						ostmt3.setString(6,reportOPDir);	
						ostmt3.setString(7,usr_added_by_id);
						ostmt3.setString(8,usr_added_at_ws_no);
						ostmt3.setString(9,usr_facility_id);			
						ostmt3.registerOutParameter(10,java.sql.Types.VARCHAR);
						ostmt3.registerOutParameter(11,java.sql.Types.VARCHAR);
						ostmt3.setString(12,INBOUND_PROTOCOL_LINK_ID);
						ostmt3.execute();				  
						message_text2 = ostmt3.getString(10);						

						if(message_text2.equals("0"))
						{			  
							connection.commit();
							chkStatusFlag3=true;				
						}
						else
						{							
							connection.rollback();
							chkStatusFlag3=false;					
						}
						if(ostmt3!=null) ostmt3.close();			

					}
					catch(Exception ex)
					{
						System.out.println("Error(3) in calling db related statements in callejb method of communicationclientmasterservlet  :"+ex.toString());
						ex.printStackTrace(System.err); 
						exceptions=exceptions+"3c"+"*"+ex.toString();
					}
				}
			}
			arr_inbound_temp.clear();
		}
		catch(Exception e)
		{
			System.out.println("Error in callEJB method of CommunicationClientMasterServlet  :"+e.toString());
			e.printStackTrace(System.err);
			exceptions = exceptions+"1"+"*"+e.toString();
		}
		finally
		{
			if(client_main != null && !client_main.isEmpty()) client_main.clear();
			if(client_outbound != null && !client_outbound.isEmpty()) client_outbound.clear();
			if(client_inbound != null && !client_inbound.isEmpty()) client_inbound.clear();	
			gen_arr.clear();
			
		}

		if((chkStatusFlag1) && (chkStatusFlag2) && (chkStatusFlag3))
		{
			final java.util.Hashtable mesg = mm.getMessage(locale, "XH1001", "XH") ;
			message_text2 = ((String) mesg.get("message"));
			mesg.clear();
		}
		else
		{
			if(chkStat)
			{
				java.util.Hashtable mesg = null;
				if(!childExists) mesg = mm.getMessage(locale, "XH1024", "XH") ;
				else mesg = mm.getMessage(locale, "XH0053", "XH") ;
				message_text2 = ((String) mesg.get("message"));
				mesg.clear();
			}
			else
			{
				final java.util.Hashtable mesg = mm.getMessage(locale, "XH1000", "XH") ;
				message_text2 = ((String) mesg.get("message"));
				mesg.clear();
			}
		}	

		try
		{
			ConnectionManager.returnConnection(connection);			
		}
		catch(Exception ex)
		{
			System.out.println("Error in closing dbconnection in callejb method of communicationclientmasterservlet  :"+ex.toString());
			ex.printStackTrace(System.err); 	
		}	

		status=message_text2;

		result_hm.put("exceptions",exceptions);
		result_hm.put("status",status);
		
		details_hm.clear();
		

		return result_hm;  

	}//end of function 	

	/**
	* containsSubstring method which finds the sub string exists in main strinng 
	* @param  String mainString
	* @param  String subString
	*/
	public boolean containsSubstring(String mainString, String subString)
	{
		boolean status = false; 
		Pattern pattern = Pattern.compile(subString);
		Matcher matcher = pattern.matcher(mainString); 
		status = matcher.find();
		return status; 
	}

	/**
	*  Method to delete protocol link id from XH_COMM_CLIENT_APPLICATION
	**/
	public String deleteProtocolLinkId()
	{		
		Connection connection = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;

		MessageManager mm=new MessageManager();

		String query = "DELETE FROM xh_comm_client_application WHERE client_id=? AND application_id=? AND facility_id=? AND protocol_link=? AND comm_type=?";				
		String checkActiveStatusQuery = "SELECT * FROM xh_comm_process WHERE client_id=? AND application_id=? AND protocol_link=? AND process_status='A'";

		String client_id = XHDBAdapter.checkNull(req.getParameter("del_client_id"));
		String application_id = XHDBAdapter.checkNull(req.getParameter("del_application_id"));
		String facility_id = XHDBAdapter.checkNull(req.getParameter("del_facility_id"));
		String protocol_link = XHDBAdapter.checkNull(req.getParameter("del_protocol_link"));
		String comm_type = XHDBAdapter.checkNull(req.getParameter("update_mode"));
		String status = "";	
		
		boolean deleteStatus = false;
		responseSent = false;

		try
		{
			if(comm_type != null && comm_type.equalsIgnoreCase("deleteStatus"))
			{
				client_id = XHDBAdapter.checkNull((String)session.getAttribute("del_client_id"));
				application_id = XHDBAdapter.checkNull((String)session.getAttribute("del_application_id"));
				facility_id = XHDBAdapter.checkNull((String)session.getAttribute("del_facility_id"));
				protocol_link = XHDBAdapter.checkNull((String)session.getAttribute("del_protocol_link"));
				comm_type = XHDBAdapter.checkNull((String)session.getAttribute("update_mode"));
				updateRecordStatus(client_id,application_id,protocol_link);
				deleteStatus = true;
			}


		/*	System.out.println("(CommunicationClientMasterServlet:deleteProtocolLinkId)client_id "+client_id);
			System.out.println("(CommunicationClientMasterServlet:deleteProtocolLinkId)application_id "+application_id);
			System.out.println("(CommunicationClientMasterServlet:deleteProtocolLinkId)facility_id "+facility_id);
			System.out.println("(CommunicationClientMasterServlet:deleteProtocolLinkId)protocol_link "+protocol_link);
			System.out.println("(CommunicationClientMasterServlet:deleteProtocolLinkId)comm_type "+comm_type);
		*/
			connection = ConnectionManager.getConnection();			

			if(!deleteStatus)
			{
				pstmt1 = connection.prepareStatement(checkActiveStatusQuery);

				pstmt1.setString(1,client_id);
				pstmt1.setString(2,application_id);			
				pstmt1.setString(3,protocol_link);			
				
				rs = pstmt1.executeQuery();

			}			

			if(rs != null && rs.next())
			{
				System.out.println("(CommunicationClientMasterServlet:deleteProtocolLinkId) active process exists...");
				responseSent = true;
				session.setAttribute("del_client_id",client_id);
				session.setAttribute("del_application_id",application_id);
				session.setAttribute("del_facility_id",facility_id);
				session.setAttribute("del_protocol_link",protocol_link);
				session.setAttribute("update_mode",comm_type);				
			}
			else
			{

				pstmt = connection.prepareStatement(query);

				if(comm_type != null && comm_type.equalsIgnoreCase("outbound")) comm_type = "O";
				else if(comm_type != null && comm_type.equalsIgnoreCase("inbound")) comm_type = "I";			
				
				

				pstmt.setString(1,client_id);
				pstmt.setString(2,application_id);
				pstmt.setString(3,facility_id);
				pstmt.setString(4,protocol_link);
				pstmt.setString(5,comm_type);
				
				int i = pstmt.executeUpdate();				
					
				if(i > 0)
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
		catch(Exception exp)
		{
			exp.printStackTrace(System.err);
		}
		finally
		{
			try
			{
				if(rs != null) rs.close();
				if(pstmt1 != null) pstmt1.close();
				if(pstmt != null) pstmt.close();
				if(connection != null) ConnectionManager.returnConnection(connection);
			}
			catch(Exception exp)
			{
				exp.printStackTrace(System.err);
			}
		}		
		return status;
	}

	public boolean updateRecordStatus(String client_id,String application_id,String protocol_link)
	{		
		String query1 = "UPDATE xh_comm_process SET PROCESS_STATUS ='S' WHERE client_id=? AND application_id=? AND protocol_link=?";
		boolean recordUpdated = false;

		Connection connection = null;
		PreparedStatement pstmt1 = null;
		try
		{			
			connection = ConnectionManager.getConnection();
			pstmt1 = connection.prepareStatement(query1);

			pstmt1.setString(1,client_id);
			pstmt1.setString(2,application_id);			
			pstmt1.setString(3,protocol_link);			
			
			int j = pstmt1.executeUpdate();			
			connection.commit();
			if(j > 0)
			{				
				recordUpdated = true;				
			}

		}
		catch(Exception exp)
		{
			exp.printStackTrace(System.err);
		}
		finally
		{
			try
			{
				if(pstmt1 != null) pstmt1.close();
				if(connection != null) ConnectionManager.returnConnection(connection);
			}
			catch(Exception exp)
			{
				exp.printStackTrace(System.err);
			}
		}
		return recordUpdated;
	}

}//end of class															
