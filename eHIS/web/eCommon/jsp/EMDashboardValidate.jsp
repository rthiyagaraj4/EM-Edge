<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page  import="java.sql.*, java.util.*, java.io.*, eOR.Common.*, ,webbeans.eCommon.*" contentType="text/html;charset=ISO-8859-1" %>
<HTML>
<HEAD>
<title>EMDashBoard</title>
<script language='javascript' src='../../eCommon/js/common.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</HEAD>
<script>

function openDashBoard()
{		
	if(document.emdash.dash_board_url.value==''){
		var msg	= getMessage('DASHBOARD_URL_NOT_CONFIGURED','Common');
		alert(msg);
		window.close();
	}else{
		document.emdash.submit();
	}
	
}


</script>
<%
Connection con=null ;
Statement stmt=null;
ResultSet rs=null;
con = ConnectionManager.getConnection(request);

Properties properties		= (Properties) session.getValue( "jdbc" );
//String user_id				= (String) session.getAttribute( "login_user" ) ;
String user_id				= request.getParameter("username") ;
String 	user_password		= "";
String 	dash_board_url		= "";

try{
	stmt = con.createStatement();
	String query="select app_password.decrypt(appl_user_password) appl_user_password,(select nvl( DASHBOARD_APP,'') from sm_db_info ) DASHBOARD_APP from sm_appl_user where appl_user_id ='"+user_id+"'";

	rs = stmt.executeQuery(query);
	while(rs.next())
	{
		user_password=checkForNull(rs.getString("appl_user_password"));
		dash_board_url=checkForNull(rs.getString("DASHBOARD_APP"));
	}
	

	if(rs!=null) rs.close();	
	if(stmt!=null) stmt.close();

}catch(Exception e) { 
	out.println(e.toString());
	e.printStackTrace();	
}
 finally
{
	
	if(con!=null) ConnectionManager.returnConnection(con,request);
	
}


	%>

<BODY onKeyDown = 'lockKey()'>
</BODY>
<form name="emdash" id="emdash" action="<%=dash_board_url%>" method="POST">
  <input type="hidden" name="username" id="username" value="<%=user_id%>">
  <input type="hidden" name="password" id="password" value="<%=user_password%>">
  <input type="hidden" name="dash_board_url" id="dash_board_url" value="<%=dash_board_url%>">

  
</form>

</HTML>
	<script >
	openDashBoard();
	</script>

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

