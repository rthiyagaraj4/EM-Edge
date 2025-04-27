<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*, webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<html>
<%	
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>  
<script language="javascript" src="../../eCommon/js/common.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<%
request.setCharacterEncoding("UTF-8");
Connection con = null;
PreparedStatement pstmt=null; 
ResultSet rset =null;
ResultSet rs =null;
String strSqlValidUser = "select preferred_style,(select facility_name from sm_facility_param where facility_id=?) facility_name  from sm_appl_user where APPL_USER_ID=? and APPL_USER_PASSWORD=? ";
PreparedStatement pstmtValidUser = null;
String client_ip_address = request.getRemoteAddr();
String jdbc_props = "";
String direct_facility_id = request.getParameter("facility_id") == null ? "" : request.getParameter("facility_id");
String p_ses_id = request.getParameter("p_session_id") == null ? "" : request.getParameter("p_session_id");
String direct_resp_id = request.getParameter("responsibility_id") == null ? "" : request.getParameter("responsibility_id");
String patient_id = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
String direct_login_user = request.getParameter("login_user") == null ? "" : request.getParameter("login_user");
String direct_login_pwd = request.getParameter("login_pwd") == null ? "" : request.getParameter("login_pwd");
String function_id = request.getParameter("function_id") == null ? "" : request.getParameter("function_id");
String preferred_style="",facility_name="";	
String locale = request.getParameter("locale") == null ? "" : request.getParameter("locale");
session.putValue("responsibility_id",direct_resp_id);
session.putValue("facility_id",direct_facility_id);
session.putValue("login_user",direct_login_user);
session.putValue("connection_pooling_yn","Y");
session.putValue("LOCALE",locale);
session.putValue("mp_bl_oper_yn","Y");
Properties p = new Properties() ;
p.setProperty( "login_user",direct_login_user ) ;
p.setProperty("connection_pooling_yn","Y") ;
p.setProperty("client_ip_address",client_ip_address) ;
p.setProperty("jdbc_props",jdbc_props) ;
p.setProperty("LOCALE",locale) ;
session.putValue( "jdbc",p ) ;
	try
		{
		con =  ConnectionManager.getConnection(request);
		pstmtValidUser = con.prepareStatement(strSqlValidUser);
		pstmtValidUser.setString(1,direct_facility_id);
		pstmtValidUser.setString(2,direct_login_user.trim());
		pstmtValidUser.setString(3,direct_login_pwd.trim());
		rset = pstmtValidUser.executeQuery();
		if(rset !=null && rset.next())
			{
			preferred_style = rset.getString("preferred_style");
			facility_name = rset.getString("facility_name");
			if(facility_name == null || facility_name.equals(""))
            facility_name = "";
		    if(preferred_style == null || preferred_style.equals(""))
            preferred_style = "IeStyle.css";
			session.setAttribute("PREFERRED_STYLE",preferred_style);
			session.putValue("facility_name",facility_name);
			rset.close();
			pstmtValidUser.close();
			}
		}
	catch(Exception e2)	
		{
		System.out.println("Exception occurred while getting the PREFERRED_STYLE details : "+e2);
		e2.printStackTrace();
		}		
	try 
		{
		pstmt = con.prepareStatement( "select install_yn bl_install_yn,(select operational_yn from sm_modules_facility where module_id='BL' and facility_id =?) operational_yn from sm_module where module_id='BL'" ) ;
		pstmt.setString( 1, direct_facility_id ) ;
		rs = pstmt.executeQuery() ;
		if ( rs != null && rs.next() ) 
			{
			String bl_install_yn = rs.getString("bl_install_yn") == null ? "N": rs.getString("bl_install_yn");
			String operational_yn = rs.getString("operational_yn") == null ? "N": rs.getString("operational_yn");
			if(bl_install_yn.equals("Y") && operational_yn.equals("Y"))
				{
				session.putValue("mp_bl_oper_yn", "Y");
				}
			else
				{
				session.putValue("mp_bl_oper_yn", "N");
				}
			}
		rs.close();	
		pstmt.close();
		}
	catch(Exception e1)	
		{
		System.out.println("Exception occurred while getting the billing details : "+e1);
		e1.printStackTrace();
		}
	try
		{
		if(con!=null)
		ConnectionManager.returnConnection(con,request);
		}
	catch(Exception  e)	{}
	%>
<body >
</body>
<script>	
	 if('<%=function_id%>' == 'CHG_PAT_DTLS'){
		window.open('../../eMP/jsp/ChangePatientDetails.jsp?step=1&menu_id=MP&module_id=MP&function_name=Change Patient Details&function_type=F&access=NYNNN&function_id=<%=function_id%>&home_required_yn=N&Patient_ID=<%=patient_id%>','eHIS','location=0,height=700,width=1050,top=0,left=0,resizable=yes');
	 }else  if('<%=function_id%>' == 'PAT_SEARCH'){
		var p_ses_id = '<%=p_ses_id%>';		
		pat_id=PatientSearch('','','','','','','','Y','Y','Visitreg');		
		if(pat_id!=null){
			patFlag=pat_id.charAt(0);			
		if(patFlag == 'Y'){
			var patientid=pat_id.substring(1,pat_id.length);
			location.href ='../../eMP/jsp/InsertPatientDetails.jsp?pat_id='+escape(patientid)+'&p_ses_id='+p_ses_id;
		  }else if(pat_id!="") { 
			  location.href ='../../eMP/jsp/InsertPatientDetails.jsp?pat_id='+escape(pat_id)+'&p_ses_id='+p_ses_id;
		  }
		}
	 }
</script>
		   
</html>

