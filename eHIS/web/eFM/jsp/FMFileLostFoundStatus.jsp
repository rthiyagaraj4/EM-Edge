<!DOCTYPE html>
<!--
	Created On	: 6/21/2002
	Created By	: Nanda Kumar R.
	Module		: File Management (FM)
	Function	: FM Record Lost/Found	
-->
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html; charset=UTF-8" %>
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
	<script src='../../eFM/js/FMParam.js' language='javascript'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eFM/js/FMLostFound.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<%
	Connection con = ConnectionManager.getConnection(request);

	Properties p		= (Properties) session.getValue("jdbc" ) ;
	String addedById	= p.getProperty( "login_user" ) ;
	String facilityid 	= (String) session.getValue("facility_id");

	java.sql.Statement stmt		= null;
	ResultSet rs				= null;
	java.sql.Statement stmt1	= null;
	ResultSet rs1				= null;

try
{

	stmt = con.createStatement();
	stmt1 = con.createStatement();

	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;	
	
	String sql 					= "";		
	String sql1 				= "";		
	String p_user_security_yn	= "";
	String p_access_all			= "";

	sql = "select user_security_yn from fm_parameter where facility_id='"+facilityid+"' ";
	rs  = stmt.executeQuery(sql);

	while (rs.next())
	{
		p_user_security_yn	= rs.getString("user_security_yn");
	}	
	
	if (p_user_security_yn.equals("Y"))
	{
		sql1 = "select 1 accessAll from fm_user_access_rights where facility_id='"+facilityid+"' and  appl_user_id='"+addedById+"' and change_file_status_yn='Y' ";
		
		rs1 = stmt1.executeQuery(sql1);
		if(rs1 != null && rs1.next())
		{
			p_access_all = rs1.getString("accessAll");
		}
		else
		{
	%>
		<script>
			var errortext = getMessage('FM_NO_USER_RIGHTS','FM');
			alert(errortext);
			parent.frames[2].location.href='../../eCommon/jsp/dmenu.jsp';
		</script>	

	<%	}
	}

%>
	 <iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>' frameborder='0' scrolling=no noresize style='height:7vh;width:100vw'></iframe>
 		 <iframe name='search_criteria' id='search_criteria' src='../../eFM/jsp/FMLostFoundSearch.jsp?p_access_all=<%=p_access_all%>&p_user_security_yn=<%=p_user_security_yn%>' frameborder=0 scrolling='auto' noresize style='height:20vh;width:100vw'></iframe>
 		 <iframe name='record_lost_found_frame' id='record_lost_found_frame' src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:14vh;width:100vw'></iframe>
		 <iframe name='change_file_status' id='change_file_status' src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' noresize style='height:47vh;width:100vw'></iframe>
	     <iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' scrolling='no' frameborder='0' noresize style='position: absolute; bottom: 0; left: 0; width: 100vw; height: 12vh; border: none;'></iframe>
	 
<%
if(stmt!=null) stmt.close();
if(rs!=null)	rs.close();
if(stmt1!=null) stmt1.close();
if(rs1!=null)	rs1.close();
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
<form name=LoadReqFiles> </form>
</html>

