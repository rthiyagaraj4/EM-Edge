<!DOCTYPE html>
<!--

	Created On	: 10/06/2002
	Created By	: Shubha
	Module		: File Management (FM)
	
-->
<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*"  contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<title><fmt:message key="eFM.FMUserAccess.label" bundle="${fm_labels}"/></title>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link>
	 -->
	 <%
	 request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
 	<script language='javascript' src='../../eFM/js/FMUserAccess.js'></script> 
	<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	Connection con = ConnectionManager.getConnection(request);
	//java.util.Properties p	= (java.util.Properties) session.getValue("jdbc" ) ;
	String facilityid 	= (String) session.getValue("facility_id");
	Statement stmt		= null;
	ResultSet rs		= null;

try
{
	stmt = con.createStatement();

	String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;	
	
	String str 		= "";		
	String p_user_security_yn= "";
	
	str = "select user_security_yn from fm_parameter where facility_id='"+facilityid+"' ";

	rs = stmt.executeQuery(str);

	while (rs.next())
	{
		p_user_security_yn = rs.getString("user_security_yn");
	}

	if (p_user_security_yn.equals("Y"))
	{
%>
	 <iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>' frameborder='0' scrolling=no noresize style='height:8vh;width:100vw'></iframe>
	     <iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' style='height:83vh;width:100vw'></iframe>
	     <iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/MstCodeError.jsp' scrolling='no' frameborder='0' noresize style='height:9vh;width:100vw'></iframe>
	 
<%
	}
	else
	{
%>
	<script>
		alert(getMessage('SECURITY_ACCESS_NOT_ENFORCED','FM'));
	   parent.frames[2].location.href='../../eCommon/jsp/dmenu.jsp';
	</script>
<%	}
if(stmt!=null) stmt.close();
if(rs!=null)	rs.close();		 
}
catch(Exception e)
{
	out.println(e);
}
finally
{
	ConnectionManager.returnConnection(con,request);
}


%>
</html>

