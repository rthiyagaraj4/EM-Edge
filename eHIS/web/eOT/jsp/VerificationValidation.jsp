<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ page import= "java.sql.Connection,java.sql.PreparedStatement,java.sql.CallableStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.Common.CommonBean,java.sql.Types,eOT.*,java.util.Properties" %>

<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<%

Properties p= (Properties)session.getValue("jdbc");
String client_ip_address=""+p.getProperty("client_ip_address");

String user_id = (String)session.getValue("login_user");


 
String order_id_1="";
String waitlist_num_1="";
String theatre_code="";
String facility_id=CommonBean.checkForNull(request.getParameter("facility_id"));
//String patient_id=CommonBean.checkForNull(request.getParameter("patient_id"));
 order_id_1=CommonBean.checkForNull(request.getParameter("order_id_1")); 
 waitlist_num_1=CommonBean.checkForNull(request.getParameter("booking_num_1")); 
 theatre_code=CommonBean.checkForNull(request.getParameter("theatre_code")); 
String p_status="";
String p_msg_txt="";
String p_langerr_msg_txt = "";

Connection con = null;
CallableStatement cstmt = null;
//PreparedStatement pstmt=null;
//PreparedStatement pstmt1=null;
//ResultSet resultset =null;
//ResultSet resultset1 =null;
try
{
	
	int index = 0;
	 	
	con = ConnectionManager.getConnection(request);
		//for checking whether the lab module is installed or not
		cstmt=con.prepareCall("{call OT_SCHEDULE_WAITLIST(?,?,?,?,null,null,null,?,?,?,?,?)}");
		cstmt.setString(++index,facility_id);
		cstmt.setString(++index,order_id_1);
		//cstmt.registerOutParameter(++index,Types.VARCHAR);
		//cstmt.registerOutParameter(++index,Types.INTEGER);
		//cstmt.registerOutParameter(++index,Types.INTEGER);
		//cstmt.registerOutParameter(++index,Types.INTEGER);
		//cstmt.registerOutParameter(++index,Types.VARCHAR);
		//cstmt.setString(++index,booking_no);
		cstmt.setString(++index,waitlist_num_1);
		cstmt.setString(++index,theatre_code);
		cstmt.setString(++index,user_id);
		cstmt.setString(++index,client_ip_address);
		cstmt.registerOutParameter(++index,Types.VARCHAR);
		cstmt.registerOutParameter(++index,Types.VARCHAR);
		cstmt.registerOutParameter(++index,Types.VARCHAR);
		
		cstmt.execute();
		
		p_status =CommonBean.checkForNull(cstmt.getString(7));
		//p_alert_status =CommonBean.checkForNull(cstmt.getString(8));
		p_msg_txt=CommonBean.checkForNull(cstmt.getString(8));
		p_langerr_msg_txt=CommonBean.checkForNull(cstmt.getString(9));
		if(p_status.equals("E")){
			out.println(p_status+"##"+p_msg_txt+"##"+p_langerr_msg_txt);
		}else{
					out.println(p_status+"##");				
		}
	
}catch(Exception e){
		e.printStackTrace();
	}finally{
		
		
		if(cstmt!=null) cstmt.close();		
	//	if(resultset!=null) resultset.close();
		ConnectionManager.returnConnection(con,request);
	}

		%>
