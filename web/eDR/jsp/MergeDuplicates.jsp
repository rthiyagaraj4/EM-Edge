<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" %>
<!doctype html public "-//W3C//DTD HTML 4.0 Transitional//EN">

<html>
<head>
<title> <fmt:message key="Common.NewDocument.label" bundle="${common_labels}"/> </title>
 <!--  <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
 <%
	request.setCharacterEncoding("UTF-8");
	String sStyle	=
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
   <script language='javascript' src='../../eDR/js/PossibleDuplicates.js'></script>
   <script language='javascript' src='../../eDR/js/MergeDuplicates.js'></script>
   <script language='javascript' src='../../eCommon/js/common.js'></script>
   <script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	String url		= "../../eCommon/jsp/commonToolbar.jsp?";
	String params	= request.getQueryString();
	String source	= url + params;

	String str			= "";
	String check_rights = "";

	boolean check_rights_flag = false;
	
	Connection con			= null;
	java.sql.Statement stmt	= null;
	ResultSet rs			= null;

	Properties p		= (Properties) session.getValue("jdbc");
	String effstatus	= "";	 
	
	try
	{
		con		= ConnectionManager.getConnection(request);
		stmt	= con.createStatement();

		String addedById	= p.getProperty("login_user");

		int p_count	 = 0;
	
		str = "SELECT eff_status,merge_privilege_level FROM dr_user_rights WHERE appl_user_id = '"+addedById+"' ";
		rs = stmt.executeQuery(str);
		while (rs.next())
		{
			check_rights	= rs.getString("merge_privilege_level");	
			effstatus		= rs.getString("eff_status");
			
			check_rights_flag	= true;
		} if(rs != null) rs.close();

		if(check_rights_flag==false || check_rights.equals("N") || effstatus.equals("D"))
		{
			%>
			<script>
				var errortext = getMessage('NO_USER_RIGHTS','DR');
				alert(errortext);
				parent.frames[2].location.href='../../eCommon/jsp/dmenu.jsp';
			</script>
			<%
		}
		
		str = "SELECT count(*) total FROM dr_param";
		rs	= stmt.executeQuery(str);
		while(rs.next())
		{
			p_count = rs.getInt("total");	
		} 
		
		if(p_count == 0)
		{
			%>
		 	<script>
				var errortext = getMessage('DR_PARAM_NOT_AVAILABLE','DR');
				alert(errortext);
				parent.frames[2].location.href='../../eCommon/jsp/dmenu.jsp';
			</script>
			<%
		}
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
	}
	catch(Exception e)
	{
		out.println("Exception e :"+e.toString());
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
%>
	<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>'  scrolling='no' noresize style='height:8vh;width:100vw' frameborder='0'></iframe>
		<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eDR/jsp/MergeDuplicatesFrameset.jsp'  scrolling='no' style='height:85vh;width:100vw' frameborder='0'></iframe>
		<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' scrolling='no'  noresize style='height:7vh;width:100vw' frameborder='0'></iframe>
	
</html>

