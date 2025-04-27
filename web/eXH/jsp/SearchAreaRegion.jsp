<!DOCTYPE html>
<!-- Latest Modified Date : 10/1/2005 4:36 PM -->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@page contentType="text/html;charset=UTF-8"
	import="java.sql.*,java.util.*,java.io.*,webbeans.eCommon.ConnectionManager"%>
<%
	String sStyle = checkForNull(
			(String) session.getAttribute("PREFERRED_STYLE"),
			"IeStyle.css");
%>

<link rel='stylesheet' type='text/css'
	href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>


<%
	

	request.setCharacterEncoding("UTF-8");
	
	String area_desc = checkForNull(request.getParameter("area_desc"));
	String region_desc = checkForNull(request.getParameter("region_desc"));
	String area_code="";
	String region_code="";

	Connection conn = null;
	java.sql.PreparedStatement prpstmt = null;
	ResultSet rs = null;
	try {
		conn = ConnectionManager.getConnection(request);

		String sql;

		prpstmt = conn
				.prepareStatement("select nvl(res_area_code,'') area_code,nvl(region_code,'') region_code from mp_res_area where short_desc=?");

		prpstmt.setString(1, area_desc);
		rs = prpstmt.executeQuery();
		
		if (rs != null && rs.next()) {
			area_code = checkForNull(rs.getString("area_code"));
			region_code = checkForNull(rs.getString("region_code"));
		} else {
			area_code = "";
			region_code="";
		}

		if (rs != null)
			rs.close();
		if (prpstmt != null)
			prpstmt.close();
		
		%>
		
		<script>
		parent.frames[1].frames[1].document.forms[0].r_area.value="<%=area_code%>";
			parent.frames[1].frames[1].document.forms[0].r_region.value="<%=region_code%>";

		</script>
		
		<%
		
	} catch (Exception e) {
		System.out.println("Exception-->" + e.toString());
		e.printStackTrace();
	} finally {
		if (rs != null)
			rs.close();
		if (prpstmt != null)
			prpstmt.close();
		ConnectionManager.returnConnection(conn, request);
	}
%>

<%!	
			private String checkForNull(String inputString)
			{
				return (inputString==null)	?	""	:	inputString;
			}
			public static String checkForNull(String inputString, String defaultValue)
			{
				return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
			}
		%>

