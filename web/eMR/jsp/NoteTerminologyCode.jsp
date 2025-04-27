<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.*,java.sql.*,eCommon.XSSRequestWrapper" %>
<html>
<head>
<!-- <script language="JavaScript" src="../../eCommon/js/common.js"></script> -->

<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language=JavaScript src="../../eCommon/js/common.js"></script>	
<script language="JavaScript" src="../../eMR/js/NoteTerminologyCode.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


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
		//String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
		String params = request.getQueryString() ;
		String source = url + params ;
%>

	<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>' frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' 	src='../../eCommon/html/blank.html' scrolling='no' frameborder=0 noresize style='height:83vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame'	src='../../eCommon/jsp/MstCodeError.jsp'  frameborder=0 noresize scrolling='auto' style='height:9vh;width:100vw'></iframe>
	</head>
	<body onKeyDown='lockKey()'>
	</body>
	</html>
<%

	}
	else
	{
		out.println("<script>alert(getMessage('CA_NOT_INSTALLED','Common'));</script>");
	}
%>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	? "" : inputString;
	}

	private String checkForNull(String inputString, String defaultValue)
	{
		return (inputString==null)	? defaultValue : inputString;
	}
%>

