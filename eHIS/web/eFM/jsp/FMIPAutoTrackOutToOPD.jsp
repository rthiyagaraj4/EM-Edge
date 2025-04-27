<!DOCTYPE html>
<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*" contentType="text/html; charset=UTF-8" %>
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
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script src='../../eFM/js/FMIPAutoTrackOutToOPD.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
		String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
		String params = request.getQueryString() ;
		String source = url + params;

		Connection conn = ConnectionManager.getConnection(request);
		String facility_id = (String) session.getValue("facility_id");
		String user_id = (String) session.getValue("login_user");

		Statement stmt=null;
		ResultSet rs=null;
		String sql = "";

		PreparedStatement stmt1=null;
		ResultSet rs1=null;
		String sql1 = "";

		String userSecurity = "";
		String autotrack_upon_confirm_pl_yn = "";
		String access_all = "";
		int userVal = 0;
		
	try
	{
		stmt =conn.createStatement();
		sql=" Select USER_SECURITY_YN,autotrack_upon_confirm_pl_yn from FM_PARAMETER where facility_id = '"+facility_id+"' ";
		rs = stmt.executeQuery(sql);

		if(rs.next())
		{
			 userSecurity = rs.getString(1);
			 autotrack_upon_confirm_pl_yn = rs.getString("autotrack_upon_confirm_pl_yn");
		}
		if(autotrack_upon_confirm_pl_yn == null) autotrack_upon_confirm_pl_yn="N";

		if(rs!=null)	rs.close();
		if(stmt!=null) stmt.close();

		if(userSecurity == null || userSecurity.equals("null"))
			userSecurity = "N";

	if(!autotrack_upon_confirm_pl_yn.equals("Y"))
		{
			if(userSecurity.equals("Y"))
			{
				sql1 = "Select 1, fs_locn_code from FM_USER_ACCESS_RIGHTS where FACILITY_ID = ? and APPL_USER_ID = ? and TRACK_OUT_TO_IPW_YN = 'Y'";

					stmt1 = conn.prepareStatement(sql1);
					stmt1.setString(1,facility_id);
					stmt1.setString(2,user_id);
					rs1   = stmt1.executeQuery();

				if(rs1.next())
				{
					 userVal = rs1.getInt(1);
					 access_all = rs1.getString("fs_locn_code");
				}
				if(rs1!=null)	rs1.close();
				if(stmt1!=null) stmt1.close();

				if(userVal != 1) 
				{
					out.println("<script> alert(getMessage(\"FM_NO_USER_RIGHTS\",\"FM\")); parent.frames[2].location.href='../../eCommon/jsp/dmenu.jsp'; </script>");
				}
			}
		}
		else
		{
			out.println("<script> alert(getMessage('AUTO_TRACK_NOT_APPLICABLE','FM')); parent.frames[2].location.href='../../eCommon/jsp/dmenu.jsp'; </script>");
		}
	}
	catch(Exception e)
	{
		out.println(e);
	}
	finally
	{			
		ConnectionManager.returnConnection(conn,request);
	}
if(session.getAttribute("issue_user_name")!=null)
session.removeAttribute("issue_user_name");
if(session.getAttribute("syDate")!=null)
session.removeAttribute("syDate");
if(session.getAttribute("curr_date")!=null)
session.removeAttribute("curr_date");

%>
	 <iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>' frameborder='0' scrolling=no noresize style='height:8vh;width:100vw'></iframe>
 		 <iframe name='autotracktoopd' id='autotracktoopd' src='../../eFM/jsp/FMIPAutoTrackOutToOPDMain.jsp?userSecurity=<%=userSecurity%>&access_all=<%=access_all%>' frameborder=0 scrolling='no' style='height:80vh;width:100vw'></iframe>
	     <iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' scrolling='no' frameborder='0' noresize style='height:12vh;width:100vw'></iframe>
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

