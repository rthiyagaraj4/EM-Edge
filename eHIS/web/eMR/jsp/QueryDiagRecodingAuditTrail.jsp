<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.*,java.sql.*,java.text.*,java.net.*,eCommon.XSSRequestWrapper" %>
<html>
<head>
	<%String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
    <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eMR/js/QueryDiagRecodingAuditTrail.js' language='javascript'></script>
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
		
		String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
		String params = request.getQueryString() ;
		String source = url + params ;
%>
		<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>' frameborder=0 scrolling='no' noresize style='height:6vh;width:100vw'></iframe>
			<iframe name='query_criteria' id='query_criteria' src='../../eMR/jsp/DiagRecodingAuditTrailQueryCriteria.jsp' frameborder=0 scrolling='no' noresize style='height:27vh;width:100vw'></iframe>	
			<iframe name='header' id='header' src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' noresize style='height:10vh;width:100vw'></iframe>	
			<iframe name='query_result' id='query_result' src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:46vh;width:100vw'></iframe>
			<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:9vh;width:100vw'></iframe><iframe name='blankFrame' id='blankFrame' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' style='height:0vh;width:100vw'></iframe>
	</html>
<%
}
else
{
	out.println("<script>alert(getMessage('CA_NOT_INSTALLED','Common'));</script>");
	out.println("<script>document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
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

