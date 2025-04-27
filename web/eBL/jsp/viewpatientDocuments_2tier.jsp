<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*, webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@page import="java.util.Hashtable"%>
<%@page import="eBL.BLReportIdMapper"%>
<%@page import="com.google.gson.JsonObject"%>
<%@page import="java.sql.Date,java.text.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="eBL.BLInsuranceImageBean"%>
<%@page import="eBL.BLInsuranceImage"%>
<%@page import="com.ehis.persist.PersistenceHelper"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<script language="javascript" src='../js/InsUpldImage.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script> 
<!-- GHL_0550_CRF FOR TWO TIER CHANGES  STARTS -->
<%
	request.setCharacterEncoding("UTF-8");
	String resp_id = request.getParameter("p_resp_id") == null ? "" : request.getParameter("p_resp_id");
	String patient_id = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
	
	String facility_id = request.getParameter("facility_id") == null ? "" : request.getParameter("facility_id");
	String module_id = request.getParameter("module_id") == null ? "" : request.getParameter("module_id");
	String login_id = request.getParameter("p_login_user") == null ? "" : request.getParameter("p_login_user");
	
	String login_pwd = request.getParameter("p_user_password") == null ? "" : request.getParameter("user_password");
	String episode_type=request.getParameter("episode_type") == null ? "" : request.getParameter("episode_type");
	String encounter_id = request.getParameter("encounter_id") == null ? "" : request.getParameter("encounter_id");
	
	String calling_from_2T=request.getParameter("calling_from_2T") == null ? "N":request.getParameter("calling_from_2T");
	
	String policy_number=request.getParameter("policy_number")==null ? "N":request.getParameter("policy_number");
	String billing_group=request.getParameter("billing_group")==null ? "N":request.getParameter("billing_group");
	
	
	String episode_id = request.getParameter("p_episode_id") == null ? "" : request.getParameter("p_episode_id");
	String visit_id = request.getParameter("p_visit_id") == null ? "" : request.getParameter("p_visit_id");
	String client_ip_address = request.getRemoteAddr();
	System.out.println("client_ip_address"+client_ip_address);
	
	
	Connection con = null;
	PreparedStatement pstmt=null; 
	ResultSet rs =null;
	PreparedStatement pstmt1=null; 
	ResultSet rs1 =null;
	HttpSession httpSession = request.getSession(false);
	String jdbc_username="";
	String jdbc_password="";
	String jdbc_dns="";
	String jdbc_driver="";
	String login_app_user="";
	try
	{	
		con =  ConnectionManager.getConnection(request);
		String sql = "select app_password.decrypt(appl_user_password) from sm_appl_user where appl_user_id = ?";
		String sql1="select USER_ID,app_password.decrypt(password),CONNECT_STRING,DB_DRIVER  from sm_db_info" ;
			
		pstmt=con.prepareStatement(sql);
		pstmt1=con.prepareStatement(sql1);
		pstmt.setString(1,login_id);	
		
		rs=	pstmt.executeQuery();
		rs1=pstmt1.executeQuery();
		while(rs.next())
		{
			login_app_user	=rs.getString(1);	
		}
		while(rs1.next())
		{
			jdbc_username	=rs1.getString(1);	
			jdbc_password	=rs1.getString(2);
			jdbc_dns	=rs1.getString(3);
			jdbc_driver =rs1.getString(4);	
		}	
		}
		catch(Exception e)
		{
			System.err.println(e);
			e.printStackTrace();
		}
		finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (rs1 != null) {
					rs1.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (pstmt1 != null) {
					pstmt1.close();
				}
				if (con != null) {
					ConnectionManager.returnConnection(con);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}	
	
	//String jdbc_props = "";
	session.putValue("facility_id","GH");
	session.putValue("login_user",login_app_user);
	session.putValue("connection_pooling_yn","Y");
	session.putValue("LOCALE","en");
	session.putValue("PREFERRED_STYLE","IeStyle.css");
	
	Properties p = new Properties() ;
	
	p.setProperty( "login_user",login_app_user ) ;
	
	p.setProperty("connection_pooling_yn","Y") ;	
	
	p.setProperty("client_ip_address","client_ip_address") ;
	p.setProperty("strLogged_dns",jdbc_dns);
	p.setProperty("strLogged_driver",jdbc_driver) ;
	p.setProperty("ecis_jdbc_user",jdbc_username);
	p.setProperty("ecis_jdbc_password",jdbc_password);
	session.putValue( "jdbc",p );
	System.out.println("120==>>"+calling_from_2T);
	%>
	<% 
	if(calling_from_2T.equals("Y"))
	{%>
		<script>
		episodetypevalidationTwotier('<%=patient_id%>','<%=episode_type%>','<%=calling_from_2T%>','<%=policy_number%>','<%=encounter_id%>'); 
		</script>
		<% }%>

</HEAD>
<BODY >
</BODY>
</HTML>

