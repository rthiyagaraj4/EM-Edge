<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.text.*,webbeans.eCommon.*,java.util.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<head>
<title><fmt:message key="Common.NewDocument.label" bundle="${common_labels}"/></title>
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	=
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
  	<script language='javascript' src='../../eDR/js/SearchCriteriaMain.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	Connection con			= null;
	java.sql.Statement stmt	= null;
	ResultSet rs			= null;

	String url    = "../../eCommon/jsp/commonToolbar.jsp?";
	String params = request.getQueryString();
	String source = url + params;

	String str			= "";
	String check_rights = ""; 
	String p_eff_status = "";
	String button_false	= "N";

	boolean check_rights_flag	= false;
	
	try
	{
		con		= ConnectionManager.getConnection(request);
		stmt	= con.createStatement();

		Properties p		= (Properties) session.getValue("jdbc" ) ;
		String addedById	= p.getProperty( "login_user" ) ;
	
		int p_count = 0;

		str = "SELECT eff_status,search_privilege_level FROM dr_user_rights WHERE appl_user_id = '"+addedById+"' ";
		rs = stmt.executeQuery(str);
		while (rs.next())
		{
			check_rights = rs.getString("search_privilege_level");	
			p_eff_status = rs.getString("eff_status");

			check_rights_flag = true;
		} if(rs!=null)	rs.close();

		if(check_rights_flag == false || check_rights.equals("N") || p_eff_status.equals("D"))
		{
			%>
		 	<script>
				var errortext = getMessage('NO_USER_RIGHTS','DR');
				alert(errortext);
				parent.frames[2].location.href='../../eCommon/jsp/dmenu.jsp';
			</script>
			<%	
		}

		str = "SELECT count(*) total FROM dr_process_ctl WHERE proc_status IN ('S0','S1','M0','M1','M2') ";
		rs = stmt.executeQuery(str);
		while (rs.next())
		{
			p_count	= rs.getInt("total");

			check_rights_flag	= true;
		} if(rs != null) rs.close();

		if(p_count > 0)
		{
			%>
			<script>
				var errortext = getMessage('CYCLE_IN_PROGRESS','DR');
				alert(errortext);
			</script>
			<%
			button_false = "Y";	
		}
		else
		{
			button_false = "N";
		}
		%>
		
			<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>'  scrolling='no' noresize style='height:9vh;width:100vw' frameborder='0'></iframe>
			<iframe name='f_query_add_mod' id='f_query_add_mod'src='../../eDR/jsp/SearchCriteriaMain.jsp?button_false=<%=button_false%>'  scrolling='no' style='height:84vh;width:100vw' frameborder='0'></iframe>
			<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' scrolling='no'  noresize style='height:7vh;width:100vw' frameborder='0'></iframe>
		
		<%

		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
	}
	catch(Exception e)
	{
		out.println("Exception :"+e.toString());
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
%>
</html>

