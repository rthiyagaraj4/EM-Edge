<!DOCTYPE html>
<!-- /*  Developed By Prabhu.M
		 Date -- 06/07/2004
		 Functionality -- OP/Catalog for Clinic	
*/ -->
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<!-- 	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%
request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eOP/js/CatalogForClinic.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>

	<%
	Connection con = null;
	Statement stmt=null;
	ResultSet rset=null ;
try
	{
		String url="../../eCommon/jsp/commonToolbar.jsp?";
		String params = request.getQueryString() ;
		String source = url + params ;
		String facility_id = (String)session.getValue( "facility_id" );
		String operational_yn ="N";
	
		con =ConnectionManager.getConnection(request);
		stmt = con.createStatement();
		
		rset = stmt.executeQuery("select operational_yn from sm_modules_facility where facility_id = '"+facility_id+"' and module_id = 'OR'");
		if(rset!= null && rset.next())
		{
			operational_yn = rset.getString("operational_yn");
			if(operational_yn == null) operational_yn =""; 
		}
			if(operational_yn.equals("N") || operational_yn.equals(""))
			{	
				%>
				<script>alert(getMessage("OR_NOT_INSTALLED","SM"));document.location.href ='../../eCommon/jsp/dmenu.jsp'
				</script>
		<%	}
			else
			{	%>
		
			<iframe name='commontoolbarFrame' id='commontoolbarFrame' src="<%=source%>" frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
				<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eCommon/html/blank.html' frameborder=0 style='height:80vh;width:100vw'></iframe>
				<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:12vh;width:100vw'></iframe>
	<%
			}
		
	}catch(Exception e)
	{
		out.print("Exception "+e);
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

