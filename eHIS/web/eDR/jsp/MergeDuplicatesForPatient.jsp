<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.util.*, java.net.*, java.text.*, webbeans.eCommon.*" %>
<html>
<head>
<title><fmt:message key="eDR.DefaultSearchCriteria.label" bundle="${dr_labels}"/></title>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	=
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eDR/js/MergeDuplicatePatient.js' ></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	Connection con		= null;
	Statement stmt		= null;
	ResultSet rs		= null;

	String url		= "../../eCommon/jsp/commonToolbar.jsp?";
	String params	= request.getQueryString();
	String source	= url + params;

	String str						= "";
	String check_rights				= "";
	String proc_status				= "";
	String effstatus				= "";	 
	String identify_privilege_level	= "";
	String search_privilege_level	= "";

	boolean check_rights_flag = false;

	Properties p	= (Properties) session.getValue("jdbc");
	
	try
	{
		con		= ConnectionManager.getConnection(request);
		stmt	= con.createStatement();

		String addedById	= p.getProperty("login_user");
		String facilityid 	= (String) session.getValue("facility_id");

		int p_count			= 0;
	
		str = "SELECT eff_status, search_privilege_level, merge_privilege_level, identify_privilege_level FROM dr_user_rights WHERE appl_user_id = '"+addedById+"' ";
		rs = stmt.executeQuery(str);
		while (rs.next())
		{
			check_rights				= rs.getString("merge_privilege_level");
			identify_privilege_level	= rs.getString("identify_privilege_level");
			search_privilege_level		= rs.getString("search_privilege_level");
			effstatus					= rs.getString("eff_status");

			check_rights_flag	= true;
		} if(rs != null) rs.close();

	   if(search_privilege_level != null && ((search_privilege_level .equals("L")) || (search_privilege_level .equals("A"))) )
		{
		   if(identify_privilege_level != null && ((identify_privilege_level.equals("L")) || (identify_privilege_level.equals("A"))) )
			{
				if(check_rights_flag == false || check_rights.equals("N") || effstatus.equals("D"))
				{
					%>
					<script>
						var errortext = getMessage('NO_USER_RIGHTS','DR');
						alert(errortext);
						parent.frames[2].location.href='../../eCommon/jsp/dmenu.jsp';
					</script>
					<%
				}
			}
			else 
			{
				%>
				<script>
					var errortext = getMessage('NO_USER_RIGHTS','DR');
					alert(errortext);
					parent.frames[2].location.href='../../eCommon/jsp/dmenu.jsp';
				</script>
				<%
			}
		}
		else
		{
			%>
			<script>
				var errortext = getMessage('NO_USER_RIGHTS','DR');
				alert(errortext);
				parent.frames[2].location.href='../../eCommon/jsp/dmenu.jsp';
			</script>
			<%
		}

		if(check_rights.equals("L") && check_rights_flag==true )
		{
			str = "SELECT search_facility_id, search_type FROM dr_process_ctl ";
			rs  = stmt.executeQuery(str);

			String p_s_f_id			= "X";
			String p_search_type	= "X";

			while(rs.next())
			{
				p_s_f_id		= rs.getString("search_facility_id");
				p_search_type	= rs.getString("search_type");
			} if(rs != null) rs.close();

			if(!p_s_f_id.equals("X") || !p_search_type.equals("X"))
			{
				if(!p_s_f_id.equals(facilityid) || !p_search_type.equals("L"))
				{
					%>
					<script>
						var errortext = getMessage('NO_USER_RIGHTS_ALL_FCY','DR');
						alert(errortext);
						parent.frames[2].location.href='../../eCommon/jsp/dmenu.jsp';
					</script>
					<%
				}
			}
			else
			{
				%>
				<script>
					var errortext = getMessage('NO_USER_RIGHTS_ALL_FCY','DR');
					alert(errortext);
					parent.frames[2].location.href='../../eCommon/jsp/dmenu.jsp';
				</script>
				<%
			}
		}

		str = "select count(*) total from dr_param ";
		rs  = stmt.executeQuery(str);
		while (rs.next())
		{
			p_count = rs.getInt("total");	
		} if(rs != null) rs.close();

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
		
		str = "select proc_status  from dr_process_ctl  " ;
		rs	= stmt.executeQuery(str);
		while(rs.next())
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
			
		if((!proc_status.equals("AB")) && (!proc_status.equals("CS")))
		{
			%>
			<script>
				var errortext = getMessage('CYCLE_IN_PROGRESS','DR');
				alert(errortext);
				
				parent.frames[2].location.href='../../eCommon/jsp/dmenu.jsp';
			</script>
			<%
		}

		str = "select count(*) total from dr_process_ctl";
		rs  = stmt.executeQuery(str);
		while (rs.next())
		{
			p_count = rs.getInt("total");
		} 

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
	<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>'  scrolling=no noresize style='height:7vh;width:100vw' frameBorder="0"></iframe>
		<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eDR/jsp/MergeDuplicatePatIdQuery.jsp'  scrolling='no' noresize style='height:4vh;width:100vw' frameBorder="0"></iframe>
		<iframe name='duplicate_searach_ctiteria' id='duplicate_searach_ctiteria' src='../../eCommon/html/blank.html'  scrolling='auto' noresize style='height:45vh;width:100vw' frameBorder="0"></iframe>
		<iframe name='duplicate_searach_result' id='duplicate_searach_result' src='../../eCommon/html/blank.html' scrolling='auto' noresize style='height:30vh;width:100vw' frameBorder="0"></iframe>
		<iframe name='duplicate_searach_image' id='duplicate_searach_image' src='../../eCommon/html/blank.html' scrolling='no' noresize style='height:5vh;width:100vw' frameBorder="0"></iframe>  
		<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' scrolling='no'  noresize style='height:8vh;width:100vw' frameBorder="0"></iframe>
	
</html>

