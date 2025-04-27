<!DOCTYPE html>
<!-- 
Sr No        Version           Incident             SCF/CRF             Developer Name
--------------------------------------------------------------------------------------
1			V230106				36652			TH-KW-CRF-0145.1			Mohanapriya
 -->
<%@ page import="java.sql.*, java.util.*, java.text.*, webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

	<%	
	
		request.setCharacterEncoding("UTF-8");
	
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	//IN073001 Start.
	String request_num = request.getParameter("request_num") == null ? "" : request.getParameter("request_num");
	String request_line_num = request.getParameter("request_line_num") == null ? "" : request.getParameter("request_line_num");
	String direct_facility_id = request.getParameter("facility_id") == null ? "" : request.getParameter("facility_id");
	
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>  
<script language="javascript" src="../../eCommon/js/common.js"></script>
<html>

<%

Connection con = null;
PreparedStatement pstmt=null; 
ResultSet rset =null;

PreparedStatement pstmt1=null;
ResultSet rset1 =null;

PreparedStatement pstmt2=null; 
ResultSet rset2 =null;

String strSqlValidUser = "select preferred_style,(select facility_name from sm_facility_param where facility_id=?) facility_name  from sm_appl_user where APPL_USER_ID=? and APPL_USER_PASSWORD=? ";
String strSqlValidResp = "SELECT 1 FROM SM_RESP_FOR_USER WHERE APPL_USER_ID=? AND RESP_ID=? ";
String sql_chartTitle = "select APPL_TASK_DESC from CA_APPL_TASK where option_id = ? ";

PreparedStatement pstmtValidUser = null;
PreparedStatement pstmtValidResp = null;

String client_ip_address = "";
client_ip_address = request.getRemoteAddr();
String jdbc_props = "";
String direct_resp_id = request.getParameter("responsibility_id") == null ? "" : request.getParameter("responsibility_id");
String patient_id = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
String chartTitle = "";

String direct_login_user = request.getParameter("login_user") == null ? "" : request.getParameter("login_user");
String direct_login_pwd = request.getParameter("login_pwd") == null ? "" : request.getParameter("login_pwd");
String episode_id = request.getParameter("episode_id") == null ? "" : request.getParameter("episode_id");
String encounter_id = request.getParameter("encounter_id") == null ? "" : request.getParameter("encounter_id");
String mode = request.getParameter("mode") == null ? "V" : request.getParameter("mode");
String limit_function_id = request.getParameter("limit_function_id") == null ? "" : request.getParameter("limit_function_id");
//out.println("mode = "+mode);
String window_name = "";
String accession_number = request.getParameter("accession_num") == null ? "" : request.getParameter("accession_num");
String accession_type = request.getParameter("accession_type") == null ? "" : request.getParameter("accession_type");
String preferred_style="",facility_name="";	
String locale = request.getParameter("locale") == null ? "" : request.getParameter("locale");
String calledFrom = request.getParameter("calledFrom") == null ? "" : request.getParameter("calledFrom");//V230106
String visit_id = "";

System.err.println("direct_login_user "+direct_login_user+" direct_login_pwd "+direct_login_pwd+" direct_facility_id "+direct_facility_id);

String function_id = request.getParameter("function_id") == null ? "" : request.getParameter("function_id");
if (encounter_id.equals(""))
{
	if (!patient_id.equals(""))
		mode="V";
	else
	{
		out.println("<script>alert(getMessage('NO_PATIENT_ID','CA'));</script>");
		out.println("<script>window.close();</script>");
	}
}
   
String func_role_id="",practitioner_name="",pract_type="";
String location_code="",location_type="",bed_num="",room_num="",episode_type="",discharge_date="",
visit_adm_date="",episode_Status="",Sex="",Age="",Dob="",security_level="",protection_ind="",patient_class="";

session.putValue("responsibility_id",direct_resp_id);
session.putValue("facility_id",direct_facility_id);
session.putValue("login_user",direct_login_user);
session.putValue("connection_pooling_yn","Y");
Properties p = new Properties() ;
p.setProperty( "login_user",direct_login_user ) ;
p.setProperty("connection_pooling_yn","Y") ;
p.setProperty("client_ip_address",client_ip_address) ;
p.setProperty("jdbc_props",jdbc_props) ;
p.setProperty("LOCALE",locale) ;
session.putValue( "jdbc",p ) ;

try{

	con =  ConnectionManager.getConnection(request);

	pstmtValidUser = con.prepareStatement(strSqlValidUser);
	pstmtValidUser.setString(1,direct_facility_id);
	pstmtValidUser.setString(2,direct_login_user.trim());
	pstmtValidUser.setString(3,direct_login_pwd.trim());
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
		pstmtValidResp = con.prepareStatement(strSqlValidResp);
		pstmtValidResp.setString(1,direct_login_user);
		pstmtValidResp.setString(2,direct_resp_id);
		rset = pstmtValidResp.executeQuery();
		if(rset !=null && rset.next()){
			String child_window = "N";
			String query_string="patid="+patient_id+"&access=NYNNN"+"&calledFrom="+calledFrom;
			System.err.println("query_string "+query_string);
			
				%>
					<iframe name='content' id='content' src='../../eBL/jsp/MaintainTreatmentPackMain.jsp?<%=query_string%>' frameborder=0  marginheight=0 marginwidth=0 SCROLLING='yes' style='height:100vh;width:100vw'></iframe>
			</html>

			<%
					
				}else{//else of RESP CHECK 
					out.println("<script>alert(getMessage('NO_RESP','CA'));</script>");
					out.println("<script>window.close();</script>");			
				}



				if(rset != null)rset.close();
				if(pstmtValidUser != null)pstmtValidUser.close();
				if(pstmtValidResp != null)pstmtValidResp.close();
			}else{//else of USER CHECK
					out.println("<script>alert(getMessage('INVALID_USER_PWD','CA'));</script>");
					out.println("<script>window.close();</script>");
			}
		}
			catch(Exception e){
				//out.println("Error "+e);
				e.printStackTrace();
			}
			finally{
				if (pstmt!=null) pstmt.close();
				if (rset !=null) rset.close();

				if (pstmt1!=null) pstmt1.close();
				if (rset1 !=null) rset1.close();
				if (pstmt2!=null) pstmt2.close();
				if (rset2 !=null) rset2.close();

				if(con!=null)ConnectionManager.returnConnection(con,request);		
			}
		%>


