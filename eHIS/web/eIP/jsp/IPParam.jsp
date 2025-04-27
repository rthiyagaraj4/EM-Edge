<!DOCTYPE html>
<%@ page  contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'</link>
	<script language='javascript' src='../../eIP/js/IPParam.js'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>
<%
	request.setCharacterEncoding("UTF-8"); 
	Connection con		= null;
	ResultSet rs 		= null; 
	Statement stmt 		= null;
try
{
	String url		= "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params	= request.getQueryString() ;
	String source	= url + params ;
	con				= ConnectionManager.getConnection(request);
	stmt			= con.createStatement();

	rs = stmt.executeQuery("select 1 from MP_PARAM where MODULE_ID = 'MP' ") ;
	if(rs.next())
	{ // changed the scrolling to auto in f_query_add_mod frame for CRF "MZ-CRF-0017-IP"  by sathish on Wednesday, March 03, 2010
%>
	<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%= source %> frameborder=0 scrolling='no' noresize style='height:5vh;width:100vw'></iframe>
		<iframe name='f_query_add_mod' id='f_query_add_mod' 	 src='../../eIP/jsp/IPParameter.jsp' frameborder=0 scrolling='auto' noresize style='height:83vh;width:100vw'></iframe> 
		<iframe name='messageFrame' id='messageFrame' 	 src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:12vh;width:100vw'></iframe>
</html>

<%}else
	out.println("<script>alert(getMessage('MP_PARAM_NOT_FOUND','MP'));document.location.href= '../../eCommon/jsp/dmenu.jsp'</script>");

	if(rs	!= null)   rs.close();
	if(stmt  != null)   stmt.close();	
}catch(Exception e)
	{
		out.println("Exception in tryCatch : "+ e.toString());
		e.printStackTrace();
	}	finally
	{
		ConnectionManager.returnConnection(con,request);
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

