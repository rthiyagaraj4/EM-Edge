<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<!doctype html public "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
<title> <fmt:message key="Common.NewDocument.label" bundle="${common_labels}"/> </title>
 <%
	request.setCharacterEncoding("UTF-8");
	String sStyle	=
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
   <script language='javascript' src='../../eDR/js/ReviewMergeProcessErrors.js'></script>
   <Script language="JavaScript" src="../../eCommon/js/common.js"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
</head>
<%
	String url		= "../../eCommon/jsp/commonToolbar.jsp?";
	String params	= request.getQueryString();
	String source	= url + params;

	String str			= "";
	String check_rights	= "";

	boolean check_rights_flag = false;

	Connection con			= null;
	java.sql.Statement stmt	= null;
	ResultSet rs			= null;

	Properties p	= (Properties) session.getValue("jdbc");
	
	String proc_status	= "";
	String effstatus	= "";	 
	
	try
	{
		con		=	ConnectionManager.getConnection(request);
		stmt	= con.createStatement();

		String addedById	= p.getProperty( "login_user" ) ;
		int p_count			= 0;
	
		str = "SELECT eff_status,merge_privilege_level FROM dr_user_rights WHERE appl_user_id = '"+addedById+"' ";
		rs = stmt.executeQuery(str);
		while (rs.next())
		{
			check_rights = rs.getString("merge_privilege_level");	
			effstatus    = rs.getString("eff_status");

			check_rights_flag = true;
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
		rs = stmt.executeQuery(str);
		while (rs.next())
		{
			p_count = rs.getInt("total");	
		} if(rs != null) rs.close();

		if(p_count == 0 )
		{
			%>
		 	<script>
				var errortext = getMessage('DR_PARAM_NOT_AVAILABLE','DR');
				alert(errortext);
				parent.frames[2].location.href='../../eCommon/jsp/dmenu.jsp';
			</script>
			<%
		}
	
		str = "SELECT proc_status FROM dr_process_ctl";
		rs = stmt.executeQuery(str);
		while (rs.next())
		{
			proc_status = rs.getString("proc_status");
		} if(rs != null) rs.close();
		
		if(proc_status.equals("S0"))
		{
			%>
			<script>
				var errortext = getMessage('SEARCH_MERGE_JOB_EXISTS','DR');
				alert(errortext);
				parent.frames[2].location.href='../../eCommon/jsp/dmenu.jsp';
			</script>
			<%
		}
		else if (proc_status.equals("S2") || proc_status.equals("CL") || proc_status.equals("AB") )
		{
			%>
			<script>
				var errortext = getMessage('NO_SEARCH_PROCESS','DR');
				alert(errortext);
				parent.frames[2].location.href='../../eCommon/jsp/dmenu.jsp';
			</script>
			<%
		}

		str = "SELECT count(*) total FROM dr_process_ctl";
		rs = stmt.executeQuery(str);
		while (rs.next())
		{
			p_count = rs.getInt("total");
		} if(rs != null) rs.close();

		if(p_count == 0)
		{
			%>
			<script>
				var errortext = getMessage('NO_SEARCH_PROCESS','DR');
				alert(errortext);
				parent.frames[2].location.href='../../eCommon/jsp/dmenu.jsp';
			</script>
			<%
		}
	 if(stmt!=null) stmt.close();}
	
	catch(Exception e)
	{
		out.println("Exception ee :"+ e.toString());
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
%>
	<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>' scrolling='no' noresize style='height:8vh;width:100vw' frameborder='0'></iframe>
		<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eDR/jsp/ReviewMergeProcessErrorsFrameset.jsp' scrolling='no'style='height:85vh;width:100vw' frameborder='0'></iframe>
		<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' scrolling='no'  noresize style='height:7vh;width:100vw' frameborder='0'></iframe>
	
</html>

