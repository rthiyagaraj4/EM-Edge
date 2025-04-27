<!DOCTYPE html>
<%@ page  contentType="text/html;charset=UTF-8" import="java.sql.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
    <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>

<head>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>  

  <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<Script src="../../eOA/js/Validate.js" language="JavaScript"></Script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?"; 
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String params = request.getQueryString() ;
	String source = url + params ;
	Connection con = null;
	Statement stmt = null;
	String facilityid=(String)(session.getValue("facility_id")==null?"":session.getValue("facility_id"));
	String globaluser = (String)(session.getValue("login_user")==null?"":session.getValue("login_user"));
	ResultSet rs=null;
	int cnt=0;
	String oper_stn_id="";
	String book_appt_yn="";
	String create_wait_list_yn="";
	String or_oper_yn="";




	try{
		con = ConnectionManager.getConnection(request);
		 stmt = con.createStatement();
		 String str ="SELECT (select count(1) cnt from oa_param WHERE MODULE_ID='OA') oa_param_cnt,( select Operational_yn from sm_modules_facility where facility_id = '"+facilityid+"' and module_id = 'OR') or_oper_yn,a.oper_stn_id, nvl(canc_appt_yn,'N') canc_appt_yn, nvl(tfr_appt_yn,'N') tfr_appt_yn, nvl(book_appt_yn,'N') book_appt_yn,nvl(CREATE_WAIT_LIST_YN,'N') creat_wt_lst_yn, to_char(sysdate,'dd/mm/yyyy') dt FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id='"+facilityid+"' AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id ='"+globaluser+"'	AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate)) ";
		 
		rs = stmt.executeQuery(str);

		if(rs !=null && rs.next())
		{	
			cnt=rs.getInt("oa_param_cnt");
			oper_stn_id=rs.getString("oper_stn_id");
		 	book_appt_yn=rs.getString("book_appt_yn");
			create_wait_list_yn=rs.getString("creat_wt_lst_yn");
			or_oper_yn=rs.getString("or_oper_yn");

		}
		if (oper_stn_id.equals("")){%>
			<script>
			alert(getMessage("NO_OPER_STN_FOR_USER","Common"));
			document.location.href='../../eCommon/jsp/dmenu.jsp';	
			</script>
			<%
	}else{
		//String sql2="SELECT a.oper_stn_id, nvl(canc_appt_yn,'N') canc_appt_yn, nvl(tfr_appt_yn,'N') tfr_appt_yn, nvl(book_appt_yn,'N') book_appt_yn, to_char(sysdate,'dd/mm/yyyy') dt FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id='"+facilityid+"' AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id ='"+globaluser+"'	AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate))";
		//if (rs!=null) rs.close();
		//rs=stmt.executeQuery(sql2);
		//if (rs!=null && rs.next()){
		if (cnt==0){%>
			<script>						
				alert(getMessage('OA_PARAM_NOT_FOUND','OA'));
				document.location.href='../../eCommon/jsp/dmenu.jsp';			
			</script>
		<%}else{%>			

			</head>
			<iframe name='commontoolbarFrame' id='commontoolbarFrame' align="left" src=<%=source%> scrolling='no' noresize style='height:7vh;width:100vw;vertical-align:top' frameborder='0'></iframe>
			<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eOA/jsp/Appointment.jsp?oper_stn_id=<%=oper_stn_id%>&book_appt_yn=<%=book_appt_yn%>&create_wait_list_yn=<%=create_wait_list_yn%>&install_yn_val=<%=or_oper_yn%>'  scrolling='no' style='height:83vh;width:100vw' frameborder='0'></iframe>
			<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' noresize scrolling='auto' style='height:9vh;width:100vw' frameborder='0'></iframe>
			</html>

	<%	}
	
	}
	if(rs !=null) rs.close();
	if(stmt !=null) stmt.close();
}
catch(Exception es){
	es.printStackTrace();
}
finally{
	ConnectionManager.returnConnection(con,request);
}

%>

