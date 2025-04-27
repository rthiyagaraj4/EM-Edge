<!DOCTYPE html>
<!--
	Module			:	eMR
	Function			:	MR Queries -> View Death Register
	Developed By 	:	Vinod Babu 
	Created On	 	:	12/05/2005
	Modified On		:	12/05/2005
-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page contentType="text/html;charset=UTF-8"
	import="webbeans.eCommon.*,java.sql.*,java.text.*,java.net.*,eCommon.XSSRequestWrapper"%>
<html>
<head>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
%>
<link rel='stylesheet' type='text/css'
	href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../js/MedRecRequestCriteria.js'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	String ca_install_yn = "N";
	try {
		con = ConnectionManager.getConnection(request);
		stmt = con.createStatement();
		rs = stmt
				.executeQuery("SELECT install_yn FROM SM_MODULE WHERE module_id = 'CA'");

		if ((rs != null) && (rs.next()))
			ca_install_yn = checkForNull(rs.getString("install_yn"),
					"N");

		if (rs != null)
			rs.close();
		if (stmt != null)
			stmt.close();

	} catch (Exception exp) {
		//out.println("Exception in CA Install.jsp : "+exp.toString());
		exp.printStackTrace();
	} finally {
		if (con != null)
			ConnectionManager.returnConnection(con, request);
	}

	if (ca_install_yn.equals("Y")) {

		request.setCharacterEncoding("UTF-8");
		request = new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");

		String url = "../../eCommon/jsp/commonToolbar.jsp?";
		String params = request.getQueryString();
		String source = url + params;
		String call_function = request.getParameter("function_id");
%>
</head>
<iframe name='commontoolbarFrame' id='commontoolbarFrame'
	src='<%=source%>' frameborder=0 scrolling='no' noresize
	style='height: 7vh; width: 100vw'></iframe>
<iframe name='f_query_add_mod' id='f_query_add_mod'
	src='../jsp/MedRecRequestCriteria.jsp?call_function=<%=call_function%>&function_id=<%=call_function%>'
	frameborder=0 scrolling='no' noresize style='height: 300px; width: 100vw'></iframe>
<iframe scrolling="auto" name='resultframe' id='resultframe'
	src='../../eCommon/html/blank.html' noresize style='height: 37vh; width: 100vw' frameborder=0></iframe>
<iframe name='colour_ind' id='colour_ind'
	src='../../eCommon/html/blank.html' frameborder=0 scrolling='no'
	noresize style='height: 5vh; width: 100vw'></iframe>
<iframe name='messageFrame' id='messageFrame'
	src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='no'
	style='height: 9vh; width: 100vw'></iframe>

</html>
<%
	} else {
		out.println("<script>alert(getMessage('CA_NOT_INSTALLED','Common'));</script>");
		out.println("<script>document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
	}
%>

<%!private String checkForNull(String inputString) {
		return (inputString == null) ? "" : inputString;
	}

	private String checkForNull(String inputString, String defaultValue) {
		return (inputString == null) ? defaultValue : inputString;
	}%>

