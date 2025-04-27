<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eMP/js/FileType.js'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;

String sql=	"Select file_type_appl_yn from mp_param";

 String file_type_appl_yn=""; 	
	 Connection con	= null;
	 Statement stmt	= null;
	 ResultSet rset	=null; 	
		try{
		con = ConnectionManager.getConnection(request);
		stmt	= con.createStatement();

	 	rset = stmt.executeQuery(sql);	
 
		if(rset.next())
 		{
 		
		file_type_appl_yn=rset.getString("file_type_appl_yn");
		if(file_type_appl_yn == null || file_type_appl_yn.equals("null")) file_type_appl_yn="Y"; 	
		
		}
		}catch(Exception e) { 
			//out.println(e.toString());
			e.printStackTrace(); // Added by lakshmanan for security issue ID 174067150 on 14-08-2023
			}
		finally
		{
			if (rset != null) rset.close();
			if (stmt != null) stmt.close();	
			if(con!=null) ConnectionManager.returnConnection(con,request);
		}
%>
<%
	if(file_type_appl_yn.equals("Y")){
%>

	<!--	<iframe name='commontoolbarFrame' id='commontoolbarFrame'src='../../eCommon/jsp/MstCodeToolbar.jsp?function_name=Section' frameborder=0 scrolling='no' noresize>
	-->
	<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%= source %> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' 	 src='../../eCommon/html/blank.html' frameborder=0 style='height:83vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' 	 src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' style='height:9vh;width:100vw'></iframe>

<% } else { %>
<script>
var alertmessage=getMessage("CANNOT_CREATE_FILE_TYPE","MP"); // old message:FILE_NOT_FOR_FACILITY
alert(alertmessage);
document.location.href='../../eCommon/jsp/dmenu.jsp';
</script>
<% } %>		
</html> 

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

