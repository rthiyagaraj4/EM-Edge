<!DOCTYPE html>


<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<!doctype html public "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
<title> <fmt:message key="eDR.IdentifyDuplicate.label" bundle="${dr_labels}"/> </title>
  <%
	request.setCharacterEncoding("UTF-8");
	String sStyle	=
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	 <script language='javascript' src='../../eDR/js/IdentifyValidDuplicates.js'></script>
	<Script language='javascript' src="../../eCommon/js/common.js" ></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 

</head>
<%
	String url		= "../../eCommon/jsp/commonToolbar.jsp?";
	String params	= request.getQueryString();
	String source	= url + params ;

	String str = "";
	String check_rights = "";

	boolean check_rights_flag = false;
	
	String modal=request.getParameter("modal");
	if(modal == null || modal.equals("null")) modal = "";
	
	Connection con			= null;
	java.sql.Statement stmt	= null;
	ResultSet rs			= null;

	Properties p	= (Properties) session.getValue("jdbc" ) ;
	
	String proc_status	= "";
	String effstatus	= "";	 
	
try
{
	con		= ConnectionManager.getConnection(request);
	stmt	= con.createStatement();
	
	String addedById	= p.getProperty( "login_user" ) ;
	String facilityid 	= (String) session.getValue("facility_id");
	
	int p_count =0;
		
	str = "select eff_status,identify_privilege_level from dr_user_rights where appl_user_id='"+addedById+"' ";
	
	rs = stmt.executeQuery(str);
	
	while (rs.next())
	{
		check_rights = rs.getString("identify_privilege_level");	
		effstatus    = rs.getString("eff_status");

		check_rights_flag	= true;
	} if(rs != null) rs.close();

	if (check_rights_flag == false || check_rights.equals("N") || effstatus.equals("D"))
	{
		if(modal != null && modal.equals("Y")){
%>
	<script>
		var errortext = getMessage('NO_USER_RIGHTS','DR');
		alert(errortext);
		window.close();
	</script>
<%
	}else{
		%>
	<script>
		var errortext = getMessage('NO_USER_RIGHTS','DR');
		alert(errortext);
		parent.frames[2].location.href='../../eCommon/jsp/dmenu.jsp';
	</script>	
	<%	
	}
}
	str = "select count(*) total from dr_param ";
	
	rs = stmt.executeQuery(str);
	
	while (rs.next())
	{
		p_count = rs.getInt("total");	
	
	} if(rs != null) rs.close();
	
	if (p_count == 0 )
	{

	if(modal.equals("Y")){
%>
	<script>
		var errortext = getMessage('DR_PARAM_NOT_AVAILABLE','DR');
		alert(errortext);
		window.close();
	</script>
<%
	}else{
%>
 	<script>
		var errortext = getMessage('DR_PARAM_NOT_AVAILABLE','DR');
		alert(errortext);
			parent.frames[2].location.href='../../eCommon/jsp/dmenu.jsp';
	</script>
<%	}
}

if(check_rights.equals("L") && check_rights_flag == true )
{
	
	str = "select search_facility_id,search_type from dr_process_ctl ";
	
	rs = stmt.executeQuery(str);
	
	String p_s_f_id = "X";
	String p_search_type = "X";
	while(rs.next())
	{
		p_s_f_id = rs.getString("search_facility_id");
		p_search_type = rs.getString("search_type");
	} if(rs != null) rs.close();
	
	if(!p_s_f_id.equals("X") || !p_search_type.equals("X"))
	{

	if(!(p_s_f_id.equals(facilityid)))
	{
		if(modal.equals("Y"))
		{
			%>
			<script>
				var errortext = getMessage('NO_USER_RIGHTS_ALL_FCY','DR');
				alert(errortext);
				window.close();
			</script>
			<%
		}else{
		%>
		<script>
			var errortext = getMessage('NO_USER_RIGHTS_ALL_FCY','DR');
			alert(errortext);
			parent.frames[2].location.href='../../eCommon/jsp/dmenu.jsp';
		</script>
		<%
	}	
}else{
	if(!p_search_type.equals("L"))
	{
		if(modal.equals("Y")){
		%>
		<script>
			var errortext = getMessage('NO_USER_RIGHTS','DR');
			alert(errortext);
			window.close();
		</script>
		<%
	}else{
	%>
	<script>
		var errortext = getMessage('NO_USER_RIGHTS','DR');
		alert(errortext);
		parent.frames[2].location.href='../../eCommon/jsp/dmenu.jsp';
	</script>
	<%
	}	
}
}
}
else
{
	if(modal.equals("Y"))
	{
		%>
		<script>
			var errortext = getMessage('NO_USER_RIGHTS','DR');
			alert(errortext);
			window.close();
		</script>
	<%
	}else{
	%>
	<script>
		var errortext = getMessage('NO_USER_RIGHTS','DR');
		alert(errortext);
		parent.frames[2].location.href='../../eCommon/jsp/dmenu.jsp';
	</script>
<%
	}
}
}	

	str = "select proc_status from dr_process_ctl " ;
	
	rs = stmt.executeQuery(str);
	
	while (rs.next())
	{
		proc_status = rs.getString("proc_status");
		
	} if(rs != null) rs.close();
	
	if(proc_status.equals("S0"))
	{
		if(!modal.equals("Y"))
		{
			%>
			<script>
				var errortext = getMessage('SEARCH_MERGE_JOB_EXISTS','DR');
				alert(errortext);
				parent.frames[2].location.href='../../eCommon/jsp/dmenu.jsp';
			</script>
		<%
		}
	}
	else if(proc_status.equals("S2") || proc_status.equals("CS") || proc_status.equals("AB") )
	{
		if(modal.equals("Y")){
		%>
		<script>
			var errortext = getMessage('NO_SEARCH_PROCESS','DR');
			alert(errortext);
			window.close();
			parent.frames[2].location.href='../../eCommon/jsp/dmenu.jsp';
		</script>
	<%
	}else{
%>
	<script>
		var errortext = getMessage('NO_SEARCH_PROCESS','DR');
		alert(errortext);
		parent.frames[2].location.href='../../eCommon/jsp/dmenu.jsp';
	</script>

<%
	}
}
	str = "select count(*) total from dr_process_ctl";
	
	rs = stmt.executeQuery(str);
	
	while (rs.next())
	{
		p_count = rs.getInt("total");
		
	} if(rs != null) rs.close();
	
	if(p_count == 0)
	{
		if(!modal.equals("Y")){
%>
	<script>
		var errortext = getMessage('NO_SEARCH_PROCESS','DR');
		alert(errortext);
		parent.frames[2].location.href='../../eCommon/jsp/dmenu.jsp';
	</script>
<%
	}
}

if(modal.equals("Y")){
%>
	
			
			<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>'  scrolling=no noresize style='height:0vh;width:100vw' frameborder="0"></iframe>
			<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eDR/jsp/IdentifyValidDuplicatesFrameset.jsp?modal=<%=modal%>'  scrolling='NO' style='height:85vh;width:100vw' frameborder="0"></iframe>
			<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' scrolling='no'  noresize style='height:5vh;width:100vw' frameborder="0"></iframe>
			
<%
}
else if(modal.equals("")){
%>
			<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>'  scrolling=no noresize style='height:8vh;width:100vw' frameborder="0"></iframe>
			<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eDR/jsp/IdentifyValidDuplicatesFrameset.jsp'  scrolling='NO' style='height:85vh;width:100vw' frameborder="0"></iframe>
			<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' scrolling='no'  noresize style='height:7vh;width:100vw' frameborder="0"></iframe>

			<%
				}if (rs != null) rs.close();
if (stmt != null) stmt.close();
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
</html>

