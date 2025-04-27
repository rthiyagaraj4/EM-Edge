<!DOCTYPE html>
<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*" contentType="text/html; charset=UTF-8"%>
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
	<script language='javascript' src='../../eFM/js/FMCancelRequestFiles.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
		String url		= "../../eCommon/jsp/commonToolbar.jsp?" ;
		String params	= request.getQueryString() ;
		String source	= url + params;

		Connection con			= ConnectionManager.getConnection(request);
		PreparedStatement pstmt	= null;
		ResultSet rs			= null;

		String facility_id	= (String) session.getValue("facility_id");
		String user_id		= (String) session.getValue("login_user");

		String sql			= "";
		String sql1			= "";
		String userSecurity = "";
	
		int rec_cnt = 0;	
		String userVal="";

		try
		{
			sql  = "Select USER_SECURITY_YN from FM_PARAMETER where FACILITY_ID = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,facility_id);
			rs   = pstmt.executeQuery();

			if(rs != null && rs.next())
			{			
				 userSecurity		= rs.getString(1);
			} if(rs != null) rs.close(); if(pstmt != null) pstmt.close();

			if(userSecurity.equals("Y"))
			{
				sql1 = "Select 1 rec_cnt , fs_locn_code from FM_USER_ACCESS_RIGHTS where FACILITY_ID = ? and APPL_USER_ID = ? and cancel_request_yn = 'Y'";

				pstmt = con.prepareStatement(sql1);
				pstmt.setString(1,facility_id);
				pstmt.setString(2,user_id);
				rs   = pstmt.executeQuery();
				
				if(rs != null && rs.next())
				{
					 rec_cnt = rs.getInt(1);  //Modified by S.Sathish for IN021089 on Friday, April 30, 2010
					 userVal =  rs.getString("fs_locn_code");
				}
				if(rec_cnt != 1)
				{
					out.println("<script> alert(getMessage(\"FM_NO_USER_RIGHTS\",\"FM\")); parent.frames[2].location.href='../../eCommon/jsp/dmenu.jsp'; </script>");
				}
			}
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
	 <iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>' frameborder='0' scrolling=no noresize style='height:8vh;width:100vw'></iframe>
		<iframe name='receipt_header' id='receipt_header' src='../../eFM/jsp/FMCancelRequestHeader.jsp?userSecurity=<%=userSecurity%>&userVal=<%=userVal%>' frameborder=0 scrolling='no' noresize style='height:16vh;width:99vw'></iframe>
		<iframe name='cancel_criteria' id='cancel_criteria' src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:18vh;width:99vw'></iframe>
		<iframe name='cancel_details' id='cancel_details' src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:48vh;width:100vw'></iframe>
		<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' scrolling='no' frameborder='0' noresize style='height:9%;width:100vw'></iframe>
	 
</html>


