<!DOCTYPE html>
<%--
	FileName	: ResultTemplate.jsp
	Version	    : 3	
	Modified On	: 22-2-2005
--%>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*, eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>


<html>
	<head>
			<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

	<script language='javascript' src='../js/ResultTemplate.js'></script>
		<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</head>
	<%
	request.setCharacterEncoding("UTF-8");	
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
	//String facility_id = (String)session.getValue( "facility_id" );
	String install_yn_ca="";
		Connection con = null;
		Statement stmt=null;
		ResultSet rset=null ;
	

try
	{

	con =ConnectionManager.getConnection(request);
		stmt = con.createStatement();
		
		rset = stmt.executeQuery("select install_yn from sm_module where module_id='CA'");
		if(rset!= null && rset.next())
		{
			install_yn_ca = rset.getString("install_yn");
		//	out.println("operational_yn :" +operational_yn);
			if(install_yn_ca !=null) install_yn_ca="";
			if(install_yn_ca.equals("N") )
			{	
				%>
				<script>alert(getMessage("CA_NOT_INSTALLED","Common"));history.go(-1);
				</script>
		<%	}
			else
			{	
	%>
	<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%=source%> frameborder=0 scrolling='no' noresize style='height:10vh;width:100vw'></iframe>
		<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eCommon/html/blank.html' frameborder=0 style='height:80vh;width:100vw'></iframe>
		<iframe name='messageFrame' id='messageFrame'	src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' style='height:10vh;width:100vw'></iframe>
</html>
		<%
			}
		}else
		{
		%>
				<script>alert(getMessage("CA_NOT_INSTALLED","Common"));history.go(-1);
				</script>
	
	<%
		}
	}catch(Exception e)
	{
		//out.print("Exception "+e);
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

