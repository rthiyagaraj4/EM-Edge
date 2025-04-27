<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<!--
	Developed by 	:	Suman
	Created on 	:	24/01/2005
	Module		:	OA
	Function	:	Manage WaitList
-->

<html>

<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link>
	 -->
	 <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/common.js' language='javascript'></SCRIPT>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script> 
	<script language="javascript" src="../../eOA/js/WaitListMgmt.js"> </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>

<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String url 	= "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params	= request.getQueryString() ;
	String source   = url+params ;

	String function_id = request.getParameter("function_id");
	String facilityid=(String)(session.getValue("facility_id")==null?"":session.getValue("facility_id"));
	String globaluser = (String)(session.getValue("login_user")==null?"":session.getValue("login_user"));
	String modify_wait_list_yn = "" ;
	String cancel_wait_list_yn = "" ;
	String oper_stn_id = "" ;
	String currentdate = "" ; 
	String Patient_Id_Length = "" ; 
	String install_yn = "" ; 
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs=null;
	String sql2="SELECT a.modify_wait_list_yn, a.cancel_wait_list_yn, a.oper_stn_id, to_char(sysdate,'dd/mm/yyyy') currentdate,(Select Patient_Id_Length from mp_param where module_id = 'MP') Patient_Id_Length,(select OPERATIONAL_YN from sm_modules_facility where module_id='OR' and facility_id=?) install_yn FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id=? AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id =?	AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,(sysdate))";
	session.removeAttribute("referral_id_app");
	session.removeAttribute("ref_id");
	try{
		con = ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement(sql2);
		pstmt.setString(1,facilityid);
		pstmt.setString(2,facilityid);
		pstmt.setString(3,globaluser);	 
		rs=pstmt.executeQuery();
		if (rs!=null && rs.next()) {			
			modify_wait_list_yn = rs.getString("modify_wait_list_yn")==null?"N":rs.getString("modify_wait_list_yn");
			cancel_wait_list_yn = rs.getString("cancel_wait_list_yn")==null?"N":rs.getString("cancel_wait_list_yn");
			oper_stn_id = rs.getString("oper_stn_id")==null?"":rs.getString("oper_stn_id");
			Patient_Id_Length = rs.getString("Patient_Id_Length")==null?"":rs.getString("Patient_Id_Length");
			currentdate = rs.getString("currentdate")==null?"":rs.getString("currentdate");
			install_yn = rs.getString("install_yn")==null?"N":rs.getString("install_yn");
			%>
			<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%=source%> frameborder=0 scrolling=no noresize style='height:7vh;width:100vw'></iframe>
			<iframe name='f_query_add_mod' id='f_query_add_mod'    src='../../eOA/jsp/WaitListInvitationCriteria.jsp?function_id=<%=function_id%>&modify_wait_list_yn=<%=modify_wait_list_yn%>&cancel_wait_list_yn=<%=cancel_wait_list_yn%>&oper_stn_id=<%=oper_stn_id%>&currentdate=<%=currentdate%>&Patient_Id_Length=<%=Patient_Id_Length%>&install_yn=<%=install_yn%>' frameborder=0 noresize scrolling=no style='height:55vh;width:100vw'></iframe>
			<iframe name='search_static' id='search_static'    src='../../eOA/jsp/WaitListMgmtCriteria.jsp' frameborder=0 noresize scrolling=no style='height:6vh;width:100vw'></iframe>
			<iframe name='f_query_add_mod1' id='f_query_add_mod1' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling="auto" style='height:20vh;width:100vw'></iframe>
			<iframe name='f_query_add_mod2' id='f_query_add_mod2' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling="auto" style='height:0vh;width:100vw'></iframe>
			<iframe name='messageFrame' id='messageFrame'	 src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling=auto style='height:10vh;width:100vw'></iframe>
		<%
		} else {				
			%>
			<script>
			alert(getMessage("NO_OPER_STN_FOR_USER","Common"));
			document.location.href='../../eCommon/jsp/dmenu.jsp';
			</script>
	<%}

//	out.println(function_id);		
%>		
</html>
<%
}
catch(Exception es){
	es.printStackTrace();
//out.println(es);
}
finally{
	if(con!=null)rs.close();
	if(con!=null)pstmt.close();
	if(con!=null)con.close();
}

%>

