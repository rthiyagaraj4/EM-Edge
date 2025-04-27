<!DOCTYPE html>

<html>
<head>
	<%String sStyle	=
    (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
    <script language='javascript' src='../../eMR/js/QueryProcedure.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
	
	
</head>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
	
	 Connection con 					= null;
	 PreparedStatement stmt				= null;
	 ResultSet rset					    = null;
	 String install_yn = "N";			

try{
	 con =  ConnectionManager.getConnection(request);
	 stmt	= con.prepareStatement("select install_yn from sm_module where module_id='CA'");
	 rset	= stmt.executeQuery();

	if ((rset != null) && (rset.next()))
	{
		install_yn = checkForNull(rset.getString("install_yn"),"N");
	}

}
catch(Exception e){/* out.println(e.toString()); */e.printStackTrace();}
finally{
		if(stmt!=null)stmt.close();
		if(rset!=null)rset.close();
		ConnectionManager.returnConnection(con,request);
	   }
 if(install_yn.equals("N"))
 {	
	 out.println("<script>alert(getMessage('CA_NOT_INSTALLED','Common'));</script>");
	 out.println("<script>document.location.href='../../eCommon/jsp/dmenu.jsp';</script>"); 
	}

 else {

		String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
		String params = request.getQueryString() ;
		String source = url + params ;
%>
<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>' frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='query_procedure_criteria' id='query_procedure_criteria' src='../../eMR/jsp/QueryProcedureCriteria.jsp' frameborder=0 scrolling='no' noresize style='height:40vh;width:100vw'></iframe> 
	<iframe name='query_procedure_result' id='query_procedure_result' src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:45vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:8vh;width:100vw'></iframe>
<% } %>
</html>

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

