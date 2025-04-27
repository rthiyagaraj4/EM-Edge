<!DOCTYPE html>
<%@ page import = "java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
	<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eAE/js/UpdateUnknownDetails.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	
	String url					= "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params				= request.getQueryString() ;
	String source				= url + params ;
	String check_rights			= "";
	boolean check_rights_flag	= false;
	
	Connection con				= null;
	PreparedStatement pstmt		=	null;
	ResultSet rs				= null;
	java.util.Properties p		= (java.util.Properties) session.getValue("jdbc" ) ;
	
	String proc_status	= "";
	String effstatus	= "";	 
	
	try
	{
        con					= ConnectionManager.getConnection(request);
	    String addedById	= p.getProperty( "login_user" ) ;
	    int p_count			= 0;
		StringBuffer sqlStr0=new StringBuffer();
		StringBuffer sqlStr = new StringBuffer();
		sqlStr0.append("SELECT install_yn  FROM sm_module where module_id='DR' ");
        String dr_install_yn="";
   		pstmt	= con.prepareStatement(sqlStr0.toString());
		rs		= pstmt.executeQuery();
		while(rs!=null  && rs.next())
		  {
						dr_install_yn		= rs.getString(1);
		  }
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
       if(dr_install_yn.equals("N"))
        %>
		<script>
			var errortext = getMessage('DR_NOT_INSTALLED','Common');
	        alert(errortext);
			document.location.href= '../../eCommon/jsp/dmenu.jsp';
		</script>
	<% else
		{
		sqlStr.append("select eff_status,merge_privilege_level from dr_user_rights  "); 
		sqlStr.append(" where appl_user_id= ? ");
		pstmt		=	con.prepareStatement(sqlStr.toString());
        pstmt.setString	(	1,	addedById		);
		rs			=	pstmt.executeQuery();	
		while (rs.next())
		{
			check_rights = rs.getString("merge_privilege_level");	
			effstatus    = rs.getString("eff_status");

			check_rights_flag = true;
		}
		if(rs !=null) rs.close();
        if(pstmt !=null) pstmt.close();
		if((sqlStr != null) && (sqlStr.length() > 0))
		{
			sqlStr.delete(0,sqlStr.length());
		}
	if (check_rights_flag == false || check_rights.equals("N") || effstatus.equals("D"))
	{
%>
		<script>
			var errortext = getMessage('NO_USER_RIGHTS','DR');
			alert(errortext);
			document.location.href= '../../eCommon/jsp/dmenu.jsp';
		</script>
<%
	}
		StringBuffer sqlStr1 = new StringBuffer();
		sqlStr1.append("select count(*) total from dr_param where module_id='DR' "); 
		pstmt		=	con.prepareStatement(sqlStr1.toString());
		rs			=	pstmt.executeQuery();	
		while (rs.next())
		{
			p_count = rs.getInt("total");	
		}
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if (p_count == 0 )
		{
			
	%>
			<script>
				var errortext = getMessage('DR_PARAM_NOT_AVAILABLE','DR');
				alert(errortext);
				document.location.href= '../../eCommon/jsp/dmenu.jsp';
			</script>
	<%
		}
		StringBuffer sqlStr2 = new StringBuffer();
		sqlStr2.append("select proc_status  from dr_process_ctl  "); 
		pstmt		=	con.prepareStatement(sqlStr2.toString());
		rs			=	pstmt.executeQuery();
		while (rs.next())
		{
			proc_status = rs.getString("proc_status");
		}
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		
		if (proc_status.equals("S0") )
		{
	%>
			<script>
				var errortext = getMessage('DR_PROCESS_CYCLE','DR');
				alert(errortext);
				document.location.href= '../../eCommon/jsp/dmenu.jsp';
			</script>
	<%
		}
		else if(proc_status.equals("S1") || proc_status.equals("S2") || proc_status.equals("M1") || proc_status.equals("M2") )
		{
	%>
			<script>
				var errortext = getMessage('DR_PROCESS_CYCLE','DR');
				alert(errortext);
				document.location.href= '../../eCommon/jsp/dmenu.jsp';
			</script> 
	<%
		}
		StringBuffer sqlStr3 = new StringBuffer();
		sqlStr3.append("select count(*) total from dr_process_ctl"); 
		pstmt		=	con.prepareStatement(sqlStr3.toString());
		rs			=	pstmt.executeQuery();
		while (rs.next())
		{
			p_count = rs.getInt("total");
		}
		if(rs !=null) rs.close();
		if(pstmt !=null) pstmt.close();
		if (p_count == 0)
		{
	%>
	<%
		}
		if (rs!=null) rs.close();
		if (pstmt!=null) pstmt.close();
		}
}catch(Exception e){e.printStackTrace();}
finally
{
		ConnectionManager.returnConnection(con,request);
}
%>
<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>' frameborder='0' scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eAE/jsp/UpdateUnknownDetails.jsp' frameborder='0' scrolling='no' noresize style='height:83vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' scrolling='no' frameborder='0' noresize style='height:9vh;width:100vw'></iframe>

</html>

