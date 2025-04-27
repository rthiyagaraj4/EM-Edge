<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %> 
<html>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eMR/js/SSOrderCatalog.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
<%
		request.setCharacterEncoding("UTF-8");
		Connection con				= null;
		Statement	stmt	        = null;
		ResultSet	rs				= null;

			
	try
	{
	    con				= ConnectionManager.getConnection(request);
	    stmt			= con.createStatement();
		String url		= "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
		String params	= request.getQueryString() ;
		String operational_yn="";
		String source = url + params ;
		String facilityId				= (String) session.getValue( "facility_id");
		String sql="select operational_yn from sm_modules_facility where module_id = 'OR' and facility_id ='"+facilityId+"'";
		rs=stmt.executeQuery(sql);
		if(rs.next())
		{
           operational_yn=rs.getString("operational_yn");
		}
		if(rs!=null) rs.close();
	    if(operational_yn.equals("Y"))
		{
		
%>

    <iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%= source %> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' 	src='../../eCommon/html/blank.html' frameborder=0>
	<iframe name='blankFrame' id='blankFrame' 	    src='../../eCommon/html/blank.html' frameborder=0 noresize style='height:100vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 scrolling='auto' noresize style='height:0%;width:100vw'></iframe>

		<%}else {%>
		<script>
	         alert(getMessage('INVALID_FUNCTION','SM'));
	         parent.frames[1].location.href="../../eCommon/html/blank.html";
		</script>
		<%}
	}
	catch(Exception e){}
	finally   
	{
		if(rs!=null)	rs.close();
		if(stmt!=null)	stmt.close();
		ConnectionManager.returnConnection(con,request);
	}%>
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

