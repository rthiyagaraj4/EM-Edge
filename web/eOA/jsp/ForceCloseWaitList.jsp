<!DOCTYPE html>
  <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>

<html>

<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language="javascript" src="../../eOA/js/ForceClose.js"> </script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
    <script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
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
Connection con =null;
PreparedStatement pstmt = null;
ResultSet rs=null;
String facilityId=(String) session.getValue("facility_id");
String globaluser = (String)session.getValue("login_user");
String oper_stn_id="";
String patient_id_length="";
String prd="";
String sqlQuery = "" ;
	
try{
	con = ConnectionManager.getConnection(request);	 
	
	sqlQuery = "SELECT a.oper_stn_id,(SELECT NVL (forceclose_period, 0) FROM oa_param where module_id = 'OA') prd, (SELECT patient_id_length FROM mp_param where module_id = 'MP') patient_id_length FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id = ? AND a.facility_id = b.facility_id AND a.oper_stn_id = b.oper_stn_id AND b.appl_user_id = ? AND TRUNC (SYSDATE) BETWEEN b.eff_date_from AND NVL (b.eff_date_to, TRUNC (SYSDATE))";
	pstmt = con.prepareStatement(sqlQuery);
	pstmt.setString(1,facilityId);
	pstmt.setString(2,globaluser);
	rs = pstmt.executeQuery();
	if(rs!=null && rs.next()){
		oper_stn_id = rs.getString("oper_stn_id")==null?"":rs.getString("oper_stn_id");
		prd = rs.getString("prd")==null?"":rs.getString("prd");
		patient_id_length = rs.getString("patient_id_length")==null?"":rs.getString("patient_id_length");
	}

	 if(oper_stn_id.equals("")) {
		%>
		<script>
			alert(getMessage('NO_OPER_STN_FOR_USER','Common'));			 
			document.location.href='../../eCommon/jsp/dmenu.jsp';
		</script>
		<%
	 } else if(!prd.equals("")) {	 		
	%>
		<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>' frameborder=0 scrolling=no noresize style='height:7vh;width:100vw'></iframe>
			<iframe name='f_query_add_mod' id='f_query_add_mod'    src='../../eOA/jsp/ForceClose.jsp?oper_stn_id=<%=oper_stn_id%>&prd=<%=prd%>&patient_id_length=<%=patient_id_length%>' frameborder=0 noresize scrolling='auto' style='height:83vh;width:100vw'></iframe>
			<iframe name='messageFrame' id='messageFrame'	 src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling=auto style='height:10vh;width:100vw'></iframe>
	</html>
	<%
	if(pstmt !=null) pstmt.close();
	if(rs !=null) rs.close();
	}else{%>
		<script>
			alert(getMessage("OA_PARAM_NOT_FOUND","OA"));
			document.location.href='../../eCommon/jsp/dmenu.jsp';
		</script>
	<%}
}catch(Exception es){
	//out.println(es); 
	es.printStackTrace();
}finally{
	ConnectionManager.returnConnection(con,request);
}

%>

