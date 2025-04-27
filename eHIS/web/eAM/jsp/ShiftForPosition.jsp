<!DOCTYPE html>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<head>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language="JavaScript" src="../../eRS/js/RSMessages.js"></script>
<script src='../js/ShiftForPosition.js' language="JavaScript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
</head>

<%request.setCharacterEncoding("UTF-8");	
		String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
		String params = request.getQueryString() ;
		String source = url + params ;
		String facility_id = (String)session.getValue( "facility_id" );
		String operational_yn="";
		Connection con = null;
		Statement stmt=null;
		ResultSet rset=null ;
	

try
	{

	con =ConnectionManager.getConnection(request);
		stmt = con.createStatement();
		
		rset = stmt.executeQuery("select operational_yn from sm_modules_facility where facility_id = '"+facility_id+"' and module_id = 'OR'");
		if(rset!= null && rset.next())
		{
			operational_yn = rset.getString("operational_yn");
			if(operational_yn !=null) operational_yn="";
			if(operational_yn.equals("N") )
			{	
				%>
				<script>alert(getMessage("OR_NOT_INSTALLED","SM"));history.go(-1);
				</script>
		<%	}
			else
			{	%>

		<iframe name="commontoolbarFrame" id="commontoolbarFrame" src='<%=source%>' frameborder=0 scrolling="no" noresize  style='height:8vh;width:100vw'></iframe>
		<iframe name="f_query_add_mod" id="f_query_add_mod" src='../../eCommon/html/blank.html' frameborder=0 scrolling="no" style='height:80vh;width:100vw'></iframe>
		<iframe name="messageFrame" id="messageFrame" src="../../eCommon/jsp/MstCodeError.jsp" frameborder=0 scrolling="auto" noresize style='height:12vh;width:100vw'></iframe>
		

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

