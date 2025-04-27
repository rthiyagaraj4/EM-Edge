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
<script language="javascript" src="../../eOA/js/TransferCancelAppointment.js"></script>
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
	String canc_appt_yn="";
	String tfr_appt_yn="";
	String book_appt_yn="";
	boolean allow_inside=true;
	String function_id = request.getParameter("function_id");
	String functionid = request.getParameter("function_id");

	try{

		con = ConnectionManager.getConnection(request);
		 stmt = con.createStatement();
	
		String sql2="SELECT a.oper_stn_id, nvl(canc_appt_yn,'N') canc_appt_yn, nvl(tfr_appt_yn,'N') tfr_appt_yn, nvl(book_appt_yn,'N') book_appt_yn, to_char(sysdate,'dd/mm/yyyy') dt FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id='"+facilityid+"' AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id ='"+globaluser+"'	AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate))";
		if (rs!=null) rs.close();
				rs=stmt.executeQuery(sql2);
				if (rs!=null && rs.next()){
					oper_stn_id=rs.getString("oper_stn_id");
					currentdate=rs.getString("dt");
					canc_appt_yn=rs.getString("canc_appt_yn");
					tfr_appt_yn=rs.getString("tfr_appt_yn");
					book_appt_yn=rs.getString("book_appt_yn");
				}else{					
					allow_inside=false;
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

	<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%=source%>  scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
		<iframe name='frame1' id='frame1' 	src='../../eOA/jsp/TransferCancelAppointmentQueryCriteria.jsp?oper_stn_id=<%=oper_stn_id%>&currentdate=<%=currentdate%>&canc_appt_yn=<%=canc_appt_yn%>&tfr_appt_yn=<%=tfr_appt_yn%>&book_appt_yn=<%=book_appt_yn%>&function_id=<%=function_id%>' scrolling='no' style='height:20vh;width:100vw' frameborder='0'></iframe>
		<iframe name='frame2' id='frame2' 	src='../../eCommon/html/blank.html'  scrolling='auto' style='height:63vh;width:100vw' frameborder='0'></iframe>
		<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp'  noresize scrolling='auto' style='height:9vh;width:100vw' frameborder='0'></iframe>
	<form>
	<input type='hidden' name='functionid' id='functionid' value=<%=functionid%>>
	</form>

	</html>

	<%
	}
	if(rs !=null) rs.close();
	if(stmt !=null) stmt.close();
}
catch(Exception es){
//out.println("Excep" + es);
es.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}
finally{
	ConnectionManager.returnConnection(con,request);
}

%>

