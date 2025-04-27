<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*, java.net.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%	
	String sql = "";
	Connection con = null;
	ResultSet rs = null;
	PreparedStatement stmt = null;
	
	String event_indicator = "";
	String event_title = "";
	String event_desc = "";
	String patient_id = "";
	String mesg_id = "";
	int msgCount = 0;
	String client_ip_address ="";

	String messageDetails = "";
	int i = 0;

	String funcId = request.getParameter("function_id");

	String appl_user_id=(String)session.getValue("login_user");

	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");

	client_ip_address = p.getProperty("client_ip_address");


	System.out.println(" -----------------FUNCID ----------------------: "+funcId);

	System.out.println(" -----------------APPL_USER_ID ----------------------: "+appl_user_id);

	System.out.println(" -----------------CLIENT_IP_ADDRESS ----------------------: "+client_ip_address);


	if (funcId.equals("query"))
	{
		try
		{
			con		= ConnectionManager.getConnection(request);
			Map hash = (Map)obj.parseXMLString( request ) ;
			hash = (Map)hash.get("SEARCH") ;
			
			sql="Select count(*) msg_count from sm_user_notification where APPL_USER_ID = ? and EVENT_READ_YN = 'N' ";
			stmt=con.prepareStatement(sql);
			stmt.setString(1,appl_user_id);
			rs=stmt.executeQuery();
			
			System.out.println(" -----------------MESSAGE COUNT QUERY--------------- "+sql);

			if (rs!=null){
				if(rs.next())
				{
					msgCount = rs.getInt("msg_count");
					System.out.println(" -----------------MSGCOUNT COUNT--------------- "+msgCount);
					%>
						msgCount = "<%=msgCount%>";
						appl_user_id = "<%=appl_user_id%>";
					<%
				}
			}
			

			sql="Select EVENT_NORMALACY_IND, EVENT_TITLE, EVENT_DESC, PATIENT_ID, MESG_ID from sm_user_notification where APPL_USER_ID = ? and EVENT_MSG_SHOWN_YN = 'N' ";
			stmt=con.prepareStatement(sql);
			stmt.setString(1,appl_user_id);
			rs=stmt.executeQuery();
			
			System.out.println(" -----------------MESSAGE DETAILS QUERY--------------- "+sql);
			if(rs!=null)
			{
				while(rs.next())
				{
					event_indicator = rs.getString("EVENT_NORMALACY_IND") == null ? "" : rs.getString("EVENT_NORMALACY_IND");
					event_title = rs.getString("EVENT_TITLE") == null ? "" : rs.getString("EVENT_TITLE");
					event_desc = rs.getString("EVENT_DESC") == null ? "" : rs.getString("EVENT_DESC");
					patient_id = rs.getString("PATIENT_ID") == null ? "" : rs.getString("PATIENT_ID");
					mesg_id = rs.getString("MESG_ID") == null ? "" : rs.getString("MESG_ID");

					messageDetails = event_indicator + "~" + event_title + "~" + event_desc + "~" + patient_id + "~" + mesg_id;
					%>
						practArryMessage[<%=i%>] = "<%=messageDetails%>";
					<%
					i++;
				}			
				
			}			
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
		}
		catch(Exception e){
			out.println("Exception"+e.toString());
		}
		finally
		{
			if(con!=null)ConnectionManager.returnConnection(con,request);
		}
	}
	else if (funcId.equals("EVENT_MSG_SHOWN_YN"))
	{
		mesg_id = request.getParameter("messageId");

		System.out.println(" ----------------EVENT_MSG_SHOWN_YN MESG_ID ----------------------: "+mesg_id);

		try
		{
			con		= ConnectionManager.getConnection(request);
			Map hash = (Map)obj.parseXMLString( request ) ;
			hash = (Map)hash.get("SEARCH") ;

			sql="UPDATE SM_USER_NOTIFICATION set EVENT_MSG_SHOWN_YN = 'N' WHERE MESG_ID = ? AND APPL_USER_ID = ? ";
			stmt=con.prepareStatement(sql);
			stmt.setString(1,mesg_id);
			stmt.setString(2,appl_user_id);
			i=stmt.executeUpdate();
			
			System.out.println(" -----------------I--------------- "+i);
			if(i == 1)
			{
				System.out.println(" -----------------SM_USER_NOTIFICATION EVENT_MSG_SHOWN_YN UPDATED SUCCESSFULLY ----------------------: ");
				con.commit();
			}			
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
		}
		catch(Exception e){
			out.println("Exception"+e.toString());
		}
		finally
		{
			if(con!=null)ConnectionManager.returnConnection(con,request);
		}

	}
	else if (funcId.equals("EVENT_READ_YN"))
	{
		mesg_id = request.getParameter("messageId");

		System.out.println(" -----------------EVENT_READ_YN MESG_ID ----------------------: "+mesg_id);

		try
		{
			con		= ConnectionManager.getConnection(request);
			Map hash = (Map)obj.parseXMLString( request ) ;
			hash = (Map)hash.get("SEARCH") ;

			sql="UPDATE SM_USER_NOTIFICATION set EVENT_READ_YN = 'Y' WHERE MESG_ID = ? AND APPL_USER_ID = ? ";
			stmt=con.prepareStatement(sql);
			stmt.setString(1,mesg_id);
			stmt.setString(2,appl_user_id);
			i=stmt.executeUpdate();
			
			System.out.println(" -----------------I--------------- "+i);
			if(i == 1)
			{
				System.out.println(" -----------------SM_USER_NOTIFICATION EVENT_READ_YN UPDATED SUCCESSFULLY ----------------------: ");
				con.commit();
			}			
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
		}
		catch(Exception e){
			out.println("Exception"+e.toString());
		}
		finally
		{
			if(con!=null)ConnectionManager.returnConnection(con,request);
		}

	}
%>
