<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,eDR.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<head><title><fmt:message key="eDR.IdentifyMainDuplicatePatients.label" bundle="${dr_labels}"/></title>
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	=
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eDR/js/EnterDuplicatesPatientID.js'></script>
	<script language='javascript' src='../../eDR/js/DuplicateRecord.js'></script>
	<script  language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<%

	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;

	String str = "";
	String check_rights = "";

	boolean check_rights_flag = false;
	
	Connection con				= null;
	java.sql.Statement stmt		= null;
	ResultSet rs				= null;
try
{
	con = ConnectionManager.getConnection(request);
	Properties p	= (Properties) session.getValue("jdbc" ) ;
	
	String proc_status	= "";
	String effstatus	= "";	 
	
	stmt				= con.createStatement();
	
	String addedById	= p.getProperty( "login_user" ) ;
	String facilityid 	= (String) session.getValue("facility_id");
	int p_count =0;
	
	
	str = "select eff_status,identify_privilege_level from dr_user_rights where appl_user_id='"+addedById+"' ";

	rs = stmt.executeQuery(str);
	while (rs.next())
	{
		check_rights = rs.getString("identify_privilege_level");	
		effstatus    = rs.getString("eff_status");
		check_rights_flag=true;
	}
	if(rs != null) rs.close();
	if (check_rights_flag==false || check_rights.equals("N") || effstatus.equals("D"))
	{
%>
	<script>
		var errortext = getMessage('NO_USER_RIGHTS','DR');
		alert(errortext);
		parent.frames[2].location.href='../../eCommon/jsp/dmenu.jsp';
	</script>
<%
	}

	str = "select count(*) total from dr_param ";
	rs = stmt.executeQuery(str);
	while (rs.next())
	{
		p_count = rs.getInt("total");	
	}
	if(rs != null) rs.close();
	if (p_count == 0 )
	{
%>
 	<script>
		var errortext = getMessage('DR_PARAM_NOT_AVAILABLE','DR');
		alert(errortext);
			parent.frames[2].location.href='../../eCommon/jsp/dmenu.jsp';
	</script>
<%	}
	

if (check_rights.equals("L") && check_rights_flag==true )
{
	str = "select search_facility_id,search_type from dr_process_ctl ";

	rs = stmt.executeQuery(str);

	String p_s_f_id = "X";
	String p_search_type = "X";
	while (rs.next())
	{
		p_s_f_id = rs.getString("search_facility_id");
		p_search_type = rs.getString("search_type");
	}
	if(rs != null) rs.close();

if (!p_s_f_id.equals("X") || !p_search_type.equals("X"))
{
	if (!p_s_f_id.equals(facilityid) || !p_search_type.equals("L"))
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

	str = "select proc_status from dr_process_ctl " ;

	rs = stmt.executeQuery(str);

	while (rs.next())
	{
		proc_status = rs.getString("proc_status");
	}
	if(rs != null) rs.close();
	if (proc_status.equals("S0"))
	{
%>
	<script>
		var errortext = getMessage('SEARCH_MERGE_JOB_EXISTS','DR');
		alert(errortext);
		parent.frames[2].location.href='../../eCommon/jsp/dmenu.jsp';
	</script>
<%
	}
	if(rs!=null)	rs.close();
	if(stmt!=null) stmt.close();
}
catch(Exception e)
{out.println("Exception e :"+e.toString());}
finally
{
	ConnectionManager.returnConnection(con,request);
}%>

	<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>'  scrolling=no noresize style='height:9vh;width:100vw'frameborder='0'></iframe>
		<iframe name='enterDuplicatePatients' id='enterDuplicatePatients' src='../../eCommon/html/blank.html'  scrolling=no noresize style='height:81vh;width:100vw'frameborder='0'></iframe>
		<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' scrolling='no'  noresize style='height:10vh;width:100vw' frameborder='0'></iframe>
	
</html>

