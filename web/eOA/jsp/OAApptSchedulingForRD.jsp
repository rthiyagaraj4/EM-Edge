<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*, webbeans.eCommon.*,  eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<!--  <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN"> -->
<HTML>
<HEAD>
<TITLE></TITLE>
<META NAME="Generator" CONTENT="EditPlus">
<META NAME="Author" CONTENT="">
<META NAME="Keywords" CONTENT="">
<META NAME="Description" CONTENT="">
<%
Connection con = null;
PreparedStatement pstmtValidUser=null; 
ResultSet rset =null;

try{

	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
//	String patient_id = request.getParameter("Patient_Id") == null ? "" : request.getParameter("Patient_Id");
	String function_id = request.getParameter("function_id") == null ? "" : request.getParameter("function_id");
	String locale = request.getParameter("locale") == null ? "" : request.getParameter("locale");
	String facility_id = request.getParameter("facility_id") == null ? "" : request.getParameter("facility_id");	
	String login_user = request.getParameter("login_user") == null ? "" : request.getParameter("login_user");	
	String p_user_password = request.getParameter("p_user_password") == null ? "" : request.getParameter("p_user_password");	
	String bl_operational = request.getParameter("bl_operational") == null ? "" : request.getParameter("bl_operational");	
	String functionCall = request.getParameter("functionCall") == null ? "" : request.getParameter("functionCall");	
	String customer_id = request.getParameter("customer_id") == null ? "" : request.getParameter("customer_id");	

		session.putValue("LOCALE",locale);		

	String called_from=request.getParameter("called_from")==null?"":request.getParameter("called_from");
	String responsibility_id=request.getParameter("responsibility_id")==null?"":request.getParameter("responsibility_id");
	
	String client_ip_address = "";
	client_ip_address = request.getRemoteAddr();
 
	String jdbc_props = "";
	String preferred_style = "";
	String facility_name = "";
	if ( function_id == null )
	function_id="";

	//String file_type_appl_yn = "";
	//String from = request.getParameter( "from" ) ;
	//String to = request.getParameter( "to" ) ;
 

	
	
		session.putValue("CUSTOMER_ID",customer_id);
		session.putValue("bl_operational",bl_operational);
		session.putValue("responsibility_id",responsibility_id);
		session.putValue("facility_id",facility_id);
		session.putValue("login_user",login_user);
		session.putValue("connection_pooling_yn","Y");
		Properties p = new Properties() ;
		p.setProperty( "login_user",login_user) ;
		p.setProperty("connection_pooling_yn","Y") ;
		p.setProperty("client_ip_address",client_ip_address) ;
		p.setProperty("jdbc_props",jdbc_props) ;
		p.setProperty("LOCALE",locale) ;
		session.putValue( "jdbc",p ) ;
	 
	 String s = request.getQueryString();

	 

	 con =  ConnectionManager.getConnection(request);

	 String strSqlValidUser = "select preferred_style,(select facility_name from sm_facility_param where facility_id=?) facility_name  from sm_appl_user where APPL_USER_ID=? and APPL_USER_PASSWORD=? ";

	 pstmtValidUser = con.prepareStatement(strSqlValidUser);
	pstmtValidUser.setString(1,facility_id);
	pstmtValidUser.setString(2,login_user.trim());
	pstmtValidUser.setString(3,p_user_password.trim());
	rset = pstmtValidUser.executeQuery();
	
	if(rset !=null && rset.next()){
		
		preferred_style = rset.getString("preferred_style");
		facility_name = rset.getString("facility_name");
				
		if(facility_name == null || facility_name.equals(""))
            facility_name = "";
		//out.println("preferred_style"+preferred_style);
           if(preferred_style == null || preferred_style.equals(""))
            preferred_style = "IeStyle.css";
		session.putValue("PREFERRED_STYLE",preferred_style);
		session.putValue("facility_name",facility_name);
		rset.close();
	}
%>
<script>
	function openHistory(){	
	
		 var ie7 = (document.all && !window.opera && window.XMLHttpRequest) ? true : false;  
	     if (ie7) {			  
			   window.open('','_parent','');
			   window.close();
           }else{			
			   this.focus();
			   self.opener = this;			 
			   self.close();
           }				

				if('<%=functionCall%>' == 'RESCHEDULE'){
					window.open('../../eOA/jsp/TransferAppointmentFrame.jsp?<%=s%>&p_user_password=<%=p_user_password%>&login_user=<%=login_user%>','eHIS','location=0,height=700,width=1200,top=0,left=0,resizable=yes');	

				}else if('<%=functionCall%>' == 'CANCEL'){
					window.open('../../eOA/jsp/CancelAppointmentFrame.jsp?<%=s%>&p_user_password=<%=p_user_password%>&login_user=<%=login_user%>','eHIS','location=0,height=700,width=1200,top=0,left=0,resizable=yes');	

				}else if('<%=functionCall%>' == 'SCHAPPT'){
					window.open('../../eOA/jsp/CAOAAppointment.jsp?<%=s%>&p_user_password=<%=p_user_password%>&login_user=<%=login_user%>','eHIS','location=0,height=700,width=1200,top=0,left=0,resizable=yes');	
				}
			}
</script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script><Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>
</HEAD>
<body onload='openHistory()'>
</BODY><%} catch(Exception e){
	e.printStackTrace();
}finally{		 
	if (rset !=null) rset.close();
	if (pstmtValidUser!=null) pstmtValidUser.close(); 
	if(con!=null)ConnectionManager.returnConnection(con,request);		
}%>
</HTML>

