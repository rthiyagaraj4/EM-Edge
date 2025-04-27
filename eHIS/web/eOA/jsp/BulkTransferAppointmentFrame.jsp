<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>


<html>
<head>

	 <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eOA/js/BulkTransferAppointment.js'></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	
	String source = url + params ;
	Connection con = null;
	Statement stmt = null;
	ResultSet rs=null;
	String facilityid=(String)session.getValue("facility_id");
	String globaluser = (String)session.getValue("login_user");
	String oper_stn_id="";
	String currentdate="";
	//String canc_appt_yn="";
	String tfr_appt_yn="";
	String book_appt_yn="";
	boolean allow_inside=true;
	String visit_limit_rule = "";

	try{

		con = ConnectionManager.getConnection(request);
		 stmt = con.createStatement();
	
		String sql2="SELECT a.oper_stn_id, tfr_appt_yn, book_appt_yn, to_char(sysdate,'dd/mm/yyyy') dt, (select visit_limit_rule from oa_param where module_id='OA') visit_limit_rule FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id='"+facilityid+"' AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id ='"+globaluser+"'	AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate))";

		
				rs=stmt.executeQuery(sql2);
				if (rs!=null && rs.next()){
					oper_stn_id = rs.getString("oper_stn_id")==null?"":rs.getString("oper_stn_id");
					currentdate = rs.getString("dt")==null?"":rs.getString("dt");
					//canc_appt_yn=rs.getString("canc_appt_yn");
					tfr_appt_yn = rs.getString("tfr_appt_yn")==null?"":rs.getString("tfr_appt_yn");
					book_appt_yn = rs.getString("book_appt_yn")==null?"":rs.getString("book_appt_yn");
					visit_limit_rule = rs.getString("visit_limit_rule")==null?"":rs.getString("visit_limit_rule");
				}else{					
					allow_inside = false;
				%>
				<script>
					alert(getMessage("NO_OPER_STN_FOR_USER","Common"));
					//location.href='../../eCommon/jsp/home.jsp';
					document.location.href='../../eCommon/jsp/dmenu.jsp';
				
				</script>
				<%
				}
	
			
	%>	
		
		<%if(allow_inside){%>

	<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%= source %>  scrolling='no' noresize style='height:8vh;width:100vw' frameborder='0'></iframe>
		<iframe name='frame1' id='frame1' 	src='../../eOA/jsp/BulkTransferAppointmentcriteria.jsp?oper_stn_id=<%=oper_stn_id%>&currentdate=<%=currentdate%>&tfr_appt_yn=<%=tfr_appt_yn%>&book_appt_yn=<%=book_appt_yn%>&visit_limit_rule=<%=visit_limit_rule%>'   scrolling='no' style='height:32vh;width:100vw' frameborder='0'></iframe>
		<iframe name='frame2' id='frame2' 	src='../../eCommon/html/blank.html'  scrolling='no' style='height:46vh;width:100vw' frameborder='0'></iframe>
		<iframe name='frame3submit' id='frame3submit' 	src='../../eCommon/html/blank.html'  scrolling='no' style='height:4vh;width:100vw' frameborder='0'></iframe>
		<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp'  noresize scrolling='auto' style='height:9vh;width:100vw' frameborder='0'></iframe>

	</html>

	<%
	}
	if(rs !=null) rs.close();
	if(stmt !=null) stmt.close();
}
catch(Exception es){
	//out.println("Excep" + es);
	es.printStackTrace();
}
finally{
	ConnectionManager.returnConnection(con,request);
}

%>

