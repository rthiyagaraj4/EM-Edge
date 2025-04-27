<!DOCTYPE html>
<%/*
Sr No        Version           Incident        SCF/CRF             			Developer Name
-------------------------------------------------------------------------------------------
 1           V210407                        AMS-CRF-0238,AMRI-CRF-0473,    
											GHL-CRF-0635				      Ram kumar S

*/ %>
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
<style>
#loading {
    background: url('../../eBL/images/giphy.gif') no-repeat center center;
    position: absolute;
    top: 0;
    left: 0;
    height: 100%;
    width: 100%;
    z-index: 9999999;
}

#success {
    background: url('../../eBL/images/success.gif') no-repeat center center;
    position: absolute;
    top: 0;
    left: 0;
    height: 100%;
    width: 100%;
    z-index: 9999999;
}
</style>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
$(function() {
$('#success').hide();
});


function genQRCode(facility_id,patientid,episode_id,functionMode,logInId,episodeType,WsNo,visitId,docNum,docTypeCode,qrCode)
{ 
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();			
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	var temp_jsp="../../eBL/jsp/BLCommonAjax.jsp?functionMode="+functionMode+"&patientid="+patientid+"&episode_id="+episode_id+"&facility_id="+facility_id+"&logInId="+logInId+"&episodeType="+episodeType+"&WsNo="+WsNo+"&visitId="+visitId+"&docNum="+docNum+"&docTypeCode="+docTypeCode+"&qrCode="+qrCode; 																					
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText = trimString(xmlHttp.responseText);	
	if(responseText!=""){
		$('#loading').hide();
		$('#message').html("Code Generated Successfully");
		$('#success').show();
		window.open('', '_self', '');
		window.close();
	}
}

//Trim String
function trimString(sInString)
{
  sInString = sInString.replace( /^\s+/g, "" );// strip leading
  return sInString.replace( /\s+$/g, "" );// strip trailing
}

</script>
<%
	request.setCharacterEncoding("UTF-8");
	String patient_id = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
	String facility_id = request.getParameter("facility_id") == null ? "" : request.getParameter("facility_id");
	String calling_from_2T=request.getParameter("calling_from_2T") == null ? "N":request.getParameter("calling_from_2T");
	String episode_id = request.getParameter("episode_id") == null ? "" : request.getParameter("episode_id");
	String functionMode = request.getParameter("functionMode") == null ? "" : request.getParameter("functionMode");
	String login_id = request.getParameter("p_login_user") == null ? "" : request.getParameter("p_login_user");
	String episode_type = request.getParameter("episode_type") == null ? "" : request.getParameter("episode_type");
	String WS_No = request.getParameter("ADDED_AT_WS_NO") == null ? "" : request.getParameter("ADDED_AT_WS_NO");
	String visit_id = request.getParameter("visit_id") == null ? "" : request.getParameter("visit_id");
	String docNum = request.getParameter("p_doc_num") == null ? "" : request.getParameter("p_doc_num");
	String docTypeCode = request.getParameter("p_doc_type_code") == null ? "" : request.getParameter("p_doc_type_code");
	String qrCode = request.getParameter("qr_Code") == null ? "" : request.getParameter("qr_Code");
	String client_ip_address = request.getRemoteAddr();
	System.err.println("request  "+request.getQueryString());
	System.err.println("patient_id  "+patient_id);
	System.err.println("facility_id  "+facility_id);
	System.err.println("calling_from_2T  "+calling_from_2T);
	System.err.println("episode_id  "+episode_id);
	System.err.println("functionMode  "+functionMode);
	System.err.println("login_id  "+login_id);
	System.err.println("episode_type  "+episode_type);
	System.err.println("WS_No  "+WS_No);
	System.err.println("visit_id  "+visit_id);
	System.err.println("docNum  "+docNum);
	System.err.println("docTypeCode  "+docTypeCode);
	System.err.println("qrCode  "+qrCode);
	
	
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
	session.putValue("facility_id",facility_id);
	session.putValue("login_user",login_app_user);
	session.putValue("connection_pooling_yn","Y");
	session.putValue("LOCALE","en");
	session.putValue("PREFERRED_STYLE","IeStyle.css");
	
	Properties p = new Properties() ;
	
	p.setProperty( "login_user",login_app_user ) ;	
	p.setProperty("connection_pooling_yn","Y") ;	
	p.setProperty("client_ip_address",client_ip_address) ;
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
		genQRCode('<%=facility_id%>','<%=patient_id%>','<%=episode_id%>','<%=functionMode%>','<%=login_id%>','<%=episode_type%>','<%=WS_No%>','<%=visit_id%>','<%=docNum%>','<%=docTypeCode%>','<%=qrCode%>'); 
		</script>
		<% }%>

</HEAD>
<BODY onload="window.resizeTo(600,600);">
<div id="loading"></div>
<p id="message">QR Code getting Generated</p>
<div id="success"></div>
</BODY>
</HTML>

