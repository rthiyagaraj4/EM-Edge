<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, webbeans.eCommon.*" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
	
	%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eFM/js/FMIPConfirmPullingList.js'></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head> 
<%
	Connection con	=	null;
	PreparedStatement pstmt	= null;
	Statement stmt	=	null;
	ResultSet rs	=	null;
	PreparedStatement stmt1=null;
	ResultSet rs1=null;
	String sql1 = "";
	String facility_id="", login_user="", sql="";
	String access_all = "";
	String user_security_yn="";

	
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
	try
	{
		con			=	ConnectionManager.getConnection(request);
		facility_id	=	(String)session.getValue("facility_id");
		login_user	=	(String)session.getValue("login_user");
		String install_yn="";
		String row_count = "";		
		stmt	=	con.createStatement();
		
		sql=" Select install_yn from sm_module where module_id = 'IP' ";
		rs = stmt.executeQuery(sql);

		if(rs.next())
		{
			 install_yn = rs.getString("install_yn");
		}
		if(rs!=null)	rs.close();
		if(stmt!=null) stmt.close();

		if(install_yn == null || install_yn.equals("null"))
		install_yn = "N";

		if(install_yn.equals("Y"))
		{
			String fm_param_query="select user_security_yn from fm_parameter where facility_id=?";			
				
			pstmt	=	con.prepareStatement(fm_param_query);
			pstmt.setString(1,facility_id);
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				user_security_yn	=	rs.getString("user_security_yn");
			}
			if(rs!=null)	rs.close();
			if(pstmt!=null) pstmt.close();		
			
			if(user_security_yn.equals("Y"))
			{
				sql1 = "Select 1, fs_locn_code from FM_USER_ACCESS_RIGHTS where FACILITY_ID = ? and APPL_USER_ID = ? and TRACK_OUT_TO_IPW_YN = 'Y'";

				stmt1 = con.prepareStatement(sql1);
				stmt1.setString(1,facility_id);
				stmt1.setString(2,login_user);
				rs1   = stmt1.executeQuery();

				if(rs1.next())
				{
					row_count	=	rs1.getString(1);
					access_all = rs1.getString("fs_locn_code");
				}
				if(rs1!=null)	rs1.close();

				if(!row_count.equals("1"))
				{					
					out.println("<script> alert(getMessage('FM_NO_USER_RIGHTS','FM')); parent.frames[2].location.href='../../eCommon/jsp/dmenu.jsp'; </script>");
				}
			}
		}
		else
		{			
			out.println("<script> alert(getMessage('FM_NO_USER_RIGHTS','FM')); parent.frames[2].location.href='../../eCommon/jsp/dmenu.jsp'; </script>");

		}
	if(pstmt!=null) pstmt.close();
	if(stmt1!=null) stmt1.close();
	}
	catch(Exception e)
	{
		out.println("Exception while fetching connection :"+e);
	}
	finally
	{				
		ConnectionManager.returnConnection(con, request);
	}

if(session.getAttribute("user_name")!=null)
session.removeAttribute("user_name");
if(session.getAttribute("user_security_yn")!=null)
session.removeAttribute("user_security_yn");
if(session.getAttribute("sys_date")!=null)
session.removeAttribute("sys_date");


%>
<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>' frameborder='0' scrolling=no noresize style='height:7vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eFM/jsp/FMIPConfirmPullingListMain.jsp?user_security_yn=<%=user_security_yn%>&access_all=<%=access_all%>' frameborder='0' scrolling='no' style='height:85vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' scrolling='no' frameborder='0' noresize style='height:8vh;width:100vw'></iframe>
  <iframe name='submit_frame' id='submit_frame' src='../../eCommon/html/blank.html' scrolling='no' frameborder='0' noresize style='height:0%;width:100vw'></iframe>


</html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString == "") ||(inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

