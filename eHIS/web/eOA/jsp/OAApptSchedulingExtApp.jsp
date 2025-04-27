<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<!--  <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN"> -->
<HTML>
<HEAD>
<TITLE></TITLE>
<META NAME="Generator" CONTENT="EditPlus">
<META NAME="Author" CONTENT="">
<META NAME="Keywords" CONTENT="">
<META NAME="Description" CONTENT="">
<script src='../../eCommon/js/common.js' language='javascript'></script>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<%
Connection con = null;
PreparedStatement pstmtValidUser=null; 
PreparedStatement pstmtResp=null; 
PreparedStatement pstmtApptDtls=null; 
ResultSet rset =null;
ResultSet rsetResp =null;
ResultSet rsetApptDtls =null;
try{

	request.setCharacterEncoding("UTF-8"); 
	request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
	String locale = "en";
	String facility_id = request.getParameter("facility_id") == null ? "" : request.getParameter("facility_id");	
	String login_user = request.getParameter("login_user") == null ? "" : request.getParameter("login_user");	
	String functionCall = request.getParameter("functionCall") == null ? "" : request.getParameter("functionCall");	
	String i_appt_ref_no = request.getParameter("i_appt_ref_no") == null ? "" : request.getParameter("i_appt_ref_no");	
	String client_ip_address = "";
	client_ip_address = request.getRemoteAddr();
	String jdbc_props = "";
	String preferred_style = "";
	String facility_name = "";
	 String s = request.getQueryString();
	 String isValidLogin	= "N";
	String oper_stn_id="";
	String currentdate="";
	String canc_appt_yn="";
	String tfr_appt_yn="";
	String book_appt_yn="";
	String tfr_appt_across_catg_yn="";
	boolean allow_inside=true;
	String arguments	= "";
	String isApptExists	= "N";

	 con =  ConnectionManager.getConnection(request);

	 String strSqlValidUser = "select preferred_style,(select facility_name from sm_facility_param where facility_id=?) facility_name  from sm_appl_user where APPL_USER_ID=?";

	pstmtValidUser = con.prepareStatement(strSqlValidUser);
	pstmtValidUser.setString(1,facility_id);
	pstmtValidUser.setString(2,login_user.trim());
	rset = pstmtValidUser.executeQuery();
	
	if(rset !=null && rset.next()){
		
		preferred_style = rset.getString("preferred_style");
		facility_name = rset.getString("facility_name");
				
		if(facility_name == null || facility_name.equals(""))
            facility_name = "";
           if(preferred_style == null || preferred_style.equals(""))
            preferred_style = "IeStyle.css";

			rset.close();
			isValidLogin	= "Y";

			String operSql	= "SELECT a.oper_stn_id, nvl(canc_appt_yn,'N') canc_appt_yn, nvl(tfr_appt_yn,'N') tfr_appt_yn, nvl(book_appt_yn,'N') book_appt_yn, a.tfr_appt_across_catg_yn tfr_appt_across_catg_yn, to_char(sysdate,'dd/mm/yyyy') dt FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id=? AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id =? AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate))";
			pstmtResp = con.prepareStatement(operSql);
			pstmtResp.setString(1,facility_id);
			pstmtResp.setString(2,login_user.trim());
			rsetResp = pstmtResp.executeQuery();
			
			if(rsetResp !=null && rsetResp.next()){
				oper_stn_id=rsetResp.getString("oper_stn_id");
				canc_appt_yn=rsetResp.getString("canc_appt_yn");
				tfr_appt_yn=rsetResp.getString("tfr_appt_yn");
				book_appt_yn=rsetResp.getString("book_appt_yn");
				tfr_appt_across_catg_yn=rsetResp.getString("tfr_appt_across_catg_yn");


				session.putValue("PREFERRED_STYLE",preferred_style);
				session.putValue("facility_name",facility_name);
				session.putValue("LOCALE",locale);		
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


				//String apptSql	= "SELECT TO_CHAR (appt_slab_from_time, 'HH24:MI:SS') i_from_time, TO_CHAR (appt_slab_to_time, 'HH24:MI:SS') i_to_time, clinic_code i_clinic_code, practitioner_id i_practitioner_id, to_char(appt_date,'dd/mm/yyyy') i_appt_date, TO_CHAR (appt_date, 'DAY') appt_day1, APPT_TYPE_CODE visit_type_ind, team_id i_team_id, care_locn_type_ind clinic_type, op_get_desc.op_clinic (facility_id, clinic_code, '"+locale+"', 1 ) clinic_name, resource_class res_type, DECODE (resource_class,  'P', am_get_desc.am_practitioner (practitioner_id, '"+locale+"', 1),  'R', practitioner_id,  am_get_desc.am_resource (facility_id, practitioner_id, '"+locale+"', '2' ) ) practitioner_name   FROM oa_appt WHERE facility_id = '"+facility_id+"' AND appt_ref_no = '"+i_appt_ref_no+"'";
				String apptSql	= "SELECT TO_CHAR (appt_slab_from_time, 'HH24:MI:SS') i_from_time, TO_CHAR (appt_slab_to_time, 'HH24:MI:SS') i_to_time, clinic_code i_clinic_code, practitioner_id i_practitioner_id, to_char(appt_date,'dd/mm/yyyy') i_appt_date, TO_CHAR (appt_date, 'DAY') appt_day1, APPT_TYPE_CODE visit_type_ind, team_id i_team_id, care_locn_type_ind clinic_type, op_get_desc.op_clinic (facility_id, clinic_code, ? , 1 ) clinic_name, resource_class res_type, DECODE (resource_class,  'P', am_get_desc.am_practitioner (practitioner_id, ?, 1),  'R', practitioner_id,  am_get_desc.am_resource (facility_id, practitioner_id, ?, '2' ) ) practitioner_name   FROM oa_appt WHERE facility_id =? AND appt_ref_no = ? ";
				pstmtApptDtls = con.prepareStatement(apptSql);
				pstmtApptDtls.setString(1,locale);
				pstmtApptDtls.setString(2,locale);
				pstmtApptDtls.setString(3,locale);
				pstmtApptDtls.setString(4,facility_id);
				pstmtApptDtls.setString(5,i_appt_ref_no);
				rsetApptDtls = pstmtApptDtls.executeQuery();
				
				if(rsetApptDtls !=null && rsetApptDtls.next()){
					isApptExists	= "Y";
					String i_from_time	= checkForNull(rsetApptDtls.getString("i_from_time"));
					String i_to_time	= checkForNull(rsetApptDtls.getString("i_to_time"));
					String i_clinic_code	= checkForNull(rsetApptDtls.getString("i_clinic_code"));
					String i_practitioner_id	= checkForNull(rsetApptDtls.getString("i_practitioner_id"));
					String i_appt_date	= checkForNull(rsetApptDtls.getString("i_appt_date"));
					String new_appt_date	= i_appt_date; 
					String appt_day1	= checkForNull(rsetApptDtls.getString("appt_day1").trim());
					String visit_type_ind	= checkForNull(rsetApptDtls.getString("visit_type_ind"));
					String i_team_id	= checkForNull(rsetApptDtls.getString("i_team_id"));
					String clinic_type	= checkForNull(rsetApptDtls.getString("clinic_type"));
					String clinic_name	= checkForNull(rsetApptDtls.getString("clinic_name"));
					String res_type	= checkForNull(rsetApptDtls.getString("res_type"));
					String practitioner_name	= checkForNull(rsetApptDtls.getString("practitioner_name"));
					arguments	= "&i_from_time="+i_from_time+"&i_to_time="+i_to_time+"&i_clinic_code="+i_clinic_code+"&i_practitioner_id="+i_practitioner_id+"&i_appt_date="+i_appt_date+"&new_appt_date="+new_appt_date+"&appt_day1="+appt_day1+"&visit_type_ind="+visit_type_ind+"&i_team_id="+i_team_id+"&clinic_type="+clinic_type+"&res_type="+res_type+"&tfr_appt_across_catg_yn="+tfr_appt_across_catg_yn+"&over_booked=N&Forced=N&rd_appt_yn=N"+"&practitioner_name="+practitioner_name+"&clinic_name="+clinic_name;

				}
			}else{
				allow_inside	= false;
			}
			rsetResp.close();
			rsetApptDtls.close();
	}
%>
<script>
	function openHistory(){	
				if('<%=isValidLogin%>'=='Y'){	
					if('<%=allow_inside%>'=='true'){

						 if ('<%=tfr_appt_yn%>' =='N' || '<%=canc_appt_yn%>' =='N') {
							 alert(getMessage('NO_TRFR_APPT_OPER','OA'));
						 }else if('<%=isApptExists%>'=='N'){
							 alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));
						 }else{
								if('<%=functionCall%>' == 'RESCHEDULE'){
									window.open('../../eOA/jsp/TransferAppointmentFrame.jsp?<%=s%><%=arguments%>','eHIS','location=0,height=700,width=1200,top=0,left=0,resizable=yes');	

								}else if('<%=functionCall%>' == 'CANCEL'){
									window.open('../../eOA/jsp/CancelAppointmentFrame.jsp?<%=s%><%=arguments%>','eHIS','location=0,height=700,width=1200,top=0,left=0,resizable=yes');	

								} 
							}
						}else{
							alert(getMessage("NO_OPER_STN_FOR_USER","Common"));
						}
					}else{
						alert(getMessage("INVALID_USER_ID","Common"));
					}
			}
</script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<body onload='openHistory()'>
<%!
public static String checkForNull(String inputString)
{
	return ( ((inputString == null) || (inputString.equals("null"))) ? "" : inputString );
}
%>
</BODY><%} catch(Exception e){
	e.printStackTrace();
}finally{		 
	if (rset !=null) rset.close();
	if (pstmtValidUser!=null) pstmtValidUser.close(); 
	if (pstmtResp!=null) pstmtResp.close(); 
	if (pstmtApptDtls!=null) pstmtApptDtls.close(); 
	if(con!=null)ConnectionManager.returnConnection(con,request);		
}%>
</HTML>

