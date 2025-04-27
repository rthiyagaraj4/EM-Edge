<!DOCTYPE html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*, eCommon.XSSRequestWrapper" %>

<html>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eAM/js/CatalogForSpeciality.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

	<%
	Connection con = null;
	Statement stmt=null;
	ResultSet rset=null ;
try
	{
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		String url="../../eCommon/jsp/MstCodeToolbar.jsp?";
		String params = request.getQueryString() ;
		String source = url + params ;
		String facility_id = (String)session.getValue( "facility_id" );
		String operational_yn ="";
		
		con =ConnectionManager.getConnection(request);
		stmt = con.createStatement();
		String sql="select operational_yn from sm_modules_facility where facility_id = '"+facility_id+"' and module_id = 'OR'";
		rset = stmt.executeQuery(sql);
		if(rset!= null && rset.next())
		{
			operational_yn = rset.getString("operational_yn");
			if(operational_yn ==null) operational_yn="";

			if(operational_yn.equals("N") || operational_yn.equals(""))
			{	
				%>
				<script>alert(getMessage("OR_NOT_INSTALLED","SM"));history.go(-1);
				</script>
		<%	}
			else
			{	%>
		
			<iframe name='commontoolbarFrame' id='commontoolbarFrame' src="<%=source%>" frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
				<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eCommon/html/blank.html' frameborder=0 style='height:80vh;width:100vw'></iframe>
				<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' style='height:12vh;width:100vw'></iframe>
	<%
			}
		}else
		{
		%>
				<script>alert(getMessage("OR_NOT_INSTALLED","SM"));history.go(-1);
				</script>
		<%
		}
	}catch(Exception e)
	{
//		out.print("Exception "+e);
e.printStackTrace();
	}
	finally
	{
		try{
		if(stmt != null) stmt.close();
		if(rset != null) rset.close();
		}catch(Exception e){}
		 if( con != null) ConnectionManager.returnConnection(con,request);
	}
%>

</html>

