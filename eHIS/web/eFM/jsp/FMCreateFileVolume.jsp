<!DOCTYPE html>
<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*"  contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eFM/js/FMCreateFileVolume.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	Connection con				= null;
	PreparedStatement pstmt		= null;
	ResultSet rs				= null;
	
	String sql			= "";
	String sql1        ="";
	String accessAll	= "";
    String   userSecurity ="";
	String facility_id	=	(String) session.getValue("facility_id");
	String user_id		=	(String) session.getValue("login_user");

	if(facility_id == null || facility_id.equals("null")) facility_id = "";
	if(user_id == null || user_id.equals("null")) user_id = "";
	
	try
	{
	
		con	= ConnectionManager.getConnection(request);
		
		sql1  = "Select USER_SECURITY_YN from FM_PARAMETER where facility_id = '"+facility_id+"' ";
		pstmt = con.prepareStatement(sql1);
		rs = pstmt.executeQuery();
		if(rs != null && rs.next())
		{
			 userSecurity = rs.getString("USER_SECURITY_YN");
		}
		
		if(rs!=null)	rs.close();
		if(pstmt!=null) pstmt.close();
	
		if(userSecurity.equals("Y"))
		{
		sql = "SELECT 1 accessAll FROM fm_user_access_rights WHERE facility_id = ? AND appl_user_id = ?  AND create_file_volume_yn = 'Y' ";

		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,user_id);
		rs = pstmt.executeQuery();
		if(rs != null && rs.next())
		{
			accessAll = rs.getString("accessAll");
		}
		if(!accessAll.equals("1"))
		{
			%>
			<script>
				var errortext = getMessage('FM_NO_USER_RIGHTS','FM');
				alert(errortext);
				parent.frames[2].location.href='../../eCommon/jsp/dmenu.jsp';
			</script>
			<%
		}
		}
		String url		= "../../eCommon/jsp/commonToolbar.jsp?" ;
		String params	= request.getQueryString() ;
		String source	= url + params;

		%>
		 <iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>' frameborder='0' scrolling=no noresize style='height:8vh;width:100vw'></iframe>
			<iframe name='createvolume_header' id='createvolume_header' src='../../eFM/jsp/FMCreateFileVolumeSearch.jsp' frameborder=0 scrolling='no' noresize style='height:20vh;width:100vw'></iframe>
			<iframe name='createvolume_criteria' id='createvolume_criteria' src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' noresize style='height:60vh;width:100vw'></iframe>
			<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' scrolling='no' frameborder='0' noresize style='height:12vh;width:100vw'></iframe>
		 
		<%
		if(rs!=null)	rs.close();
		if(pstmt!=null) pstmt.close();
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


