<!DOCTYPE html>
<%@page import="java.text.DateFormat"%>
<%@page import="java.sql.ResultSetMetaData"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page
	import="java.sql.Connection,java.sql.ResultSetMetaData,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.*,eXH.XHDBAdapter,java.io.*"%>
<%@ page import="java.util.*"%>

<%
	Connection con = null;
	PreparedStatement pst = null;
	PreparedStatement pst1 = null;
	ResultSet rs = null;

	String app_id = request.getParameter("app_id");
	String event_type = request.getParameter("event_type");
	String notification_status = request.getParameter("notification_status");
	
	String message_id = request.getParameter("message_id");
	List<String> messageIdList = Arrays.asList(message_id.split(","));
	
	//String[] message_id_array = message_id.split(",");
	String facility_id = null;
%>	

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TrackNotificationTable</title>
</head>
<body>
<div id="resubmitteddata">
<% 
		try {
			for (int i = 0; i < messageIdList.size(); i++) {
				
				System.out.println("app_id..."+app_id);
				System.out.println("messageIdList.get(i)..."+messageIdList.get(i));
			
						con = ConnectionManager.getConnection();
						String facility_id_query = "SELECT FACILITY_ID FROM XH_NOTIFY_EVENT_MESSAGE_VW WHERE APPLICATION_ID = ? AND MESSAGE_ID = ?";
						pst1 = con.prepareStatement(facility_id_query); 
						
						pst1.setString(1, app_id);
						pst1.setString(2, messageIdList.get(i));
						rs = pst1.executeQuery();
						while(rs.next()){
							facility_id = rs.getString(1);
						}
						
						System.out.println("facility_id..."+facility_id);
					
						String updqry = "UPDATE XH_APPLICATION_MESSAGE SET MESSAGE_STATUS = NULL WHERE APPLICATION_ID = ? AND FACILITY_ID = ? AND MESSAGE_ID = ?";
				        
						pst = con.prepareStatement(updqry.toString());
						//for(int i = 0; i<message_id_array.length; i++){
						pst.setString(1, app_id);
						pst.setString(2, facility_id);
						pst.setString(3, messageIdList.get(i));
						
						pst.executeUpdate();
						con.commit();
						
						if (pst != null)
							pst.close();
						
						if (pst1 != null)
							pst1.close();
						
						if (con != null)
							con.close();
			}
		}
catch (Exception e1) {
		System.out.println("TableNotificationUpdate.jsp Exc1 : "
				+ e1.toString());
		e1.printStackTrace(System.err);
	} finally {
		
		if (pst != null)
			pst.close();
		
		if (pst1 != null)
			pst1.close();
		
		if (con != null)
			con.close();
	}
%>
	</div>
</body>
</html>
