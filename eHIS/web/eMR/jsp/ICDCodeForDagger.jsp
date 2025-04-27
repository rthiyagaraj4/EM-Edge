<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"  import="webbeans.eCommon.*,java.sql.*,eCommon.XSSRequestWrapper" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
</link>
<script language='javascript' src='../js/ICDCodeForDagger.js'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eMR/js/ICDCodeForDagger.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>

<%
	 

	Connection con	= null;
	Statement stmt	= null;
	ResultSet rs	= null;
	String ca_install_yn = "N";
	try
	{
		con = ConnectionManager.getConnection(request);
		stmt	= con.createStatement();
		rs		= stmt.executeQuery("SELECT install_yn FROM SM_MODULE WHERE module_id = 'CA'");	

		if ((rs != null) && (rs.next()))
			ca_install_yn = checkForNull(rs.getString("install_yn"),"N");
		
		if(rs	 != null)   rs.close();
		if(stmt !=null) stmt.close();

	}catch(Exception exp)
	{
		//out.println("Exception in CA Install.jsp : "+exp.toString());
		exp.printStackTrace();
	}
	finally
	{
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}

	if(ca_install_yn.equals("Y"))
	{
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
		String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
		String params = request.getQueryString() ;
		String source = url + params ;
%>

<form name="parentForm" id="parentForm" action="">
<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%= source %> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='f_query_mod' id='f_query_mod' src="../../eCommon/html/blank.html" frameborder=0 scrolling='auto' style='height:100vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' style='height:40%;width:100vw'></iframe>
<input type="hidden" name="flag" id="flag" >
</form>
</html>
<%

	}
	else
	{
		out.println("<script>alert(getMessage('CA_NOT_INSTALLED','Common'));</script>");
	}
%>

<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

