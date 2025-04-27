<!DOCTYPE html>
<html>
<head>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" %>

<%@ page session="false" contentType="text/html;charset=UTF-8" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>


<script src='../../eMP/js/Organization.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<%
	String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
	String family_org_id_accept_yn = "";

	Connection conn  = null;
	Statement stmt   = null;
	ResultSet rs     = null;

	try
	{
		conn = ConnectionManager.getConnection(request);
		stmt = conn.createStatement();
		rs = stmt.executeQuery("select FAMILY_ORG_ID_ACCEPT_YN from mp_param");

		while(rs!=null && rs.next())
		{
			family_org_id_accept_yn=rs.getString("FAMILY_ORG_ID_ACCEPT_YN");		
		}
		if(family_org_id_accept_yn == null || family_org_id_accept_yn.equals("null")) family_org_id_accept_yn="N";
		
		if(family_org_id_accept_yn.equals("N"))
		 {
			%>	
		<script>
			alert(getMessage("ORGN_NOT_APPL","MP"));
			document.location.href='../../eCommon/jsp/dmenu.jsp';
		</script>
	<%
		 }
		else if(family_org_id_accept_yn.equals(""))
		 {
	%>	
		<script>
			alert(getMessage("MP_PARAM_NOT_FOUND","MP"));
		    document.location.href='../../eCommon/jsp/dmenu.jsp';
		</script>
	<%
		 }
	else
		 {
%>
<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%=source%> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
		<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eCommon/html/blank.html' frameborder=0 style='height:83vh;width:100vw'></iframe>
		<iframe name='messageFrame' id='messageFrame'	src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' style='height:9vh;width:100vw'></iframe>
<%
 }
	}
	catch(Exception e)
	 {
		out.println("Exception in Organization is:"+e.toString());

		
	 }
	 finally
	 {
		ConnectionManager.returnConnection(conn,request);	
		stmt.close();
		rs.close();
     }

	%>
	</html>

