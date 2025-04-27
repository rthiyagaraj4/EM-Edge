<!DOCTYPE html>
<!-- by Meghanath -->
<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*"  contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<HTML>
<HEAD>
	<!-- <LINK rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></LINK> -->
	<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script> <!-- Added by Sangeetha for GDOH-CRF-0133 -->
	<SCRIPT language='javascript' src='../../eCommon/js/common.js'></SCRIPT>
	<SCRIPT language='javascript' src='../../eCommon/js/ValidateControl.js'></SCRIPT>
	<SCRIPT language='javascript' src='../../eFM/js/FMTransferFile.js'></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<body>
<%
	String url	  = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params;

	Connection con		= ConnectionManager.getConnection(request);

	PreparedStatement pstmt	= null;
	ResultSet rs			= null;

	String sql							= "";
	String sql1							= "";
	String locnIden						= "";
	String userSecurity					= "";
	String Dflt_archive_fs_locn_code	= "";
	String Dflt_lost_fs_locn_code		= "";
	String auto_rec_ward_yn				= "";
	String auto_rec_clinic_yn			= "";
	String auto_rec_pract_yn			= "";
   String auto_rec_dept_yn        ="";
	int userVal = 0;

	String facility_id	= (String) session.getValue("facility_id");
	String user_id		= (String) session.getValue("login_user");

	try
	{
		sql  = "SELECT transfer_file_yn, user_security_yn, dflt_archive_fs_locn_code, dflt_lost_fs_locn_code,auto_rec_ward_yn, auto_rec_clinic_yn, auto_rec_pract_yn ,auto_rec_dept_yn FROM fm_parameter WHERE facility_id = ? ";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,facility_id);
		rs = pstmt.executeQuery();
		if(rs != null && rs.next())
		{
			locnIden					= rs.getString(1);
			userSecurity				= rs.getString(2);
			Dflt_archive_fs_locn_code	= rs.getString(3);
			Dflt_lost_fs_locn_code		= rs.getString(4);
			auto_rec_ward_yn			= rs.getString(5);
			auto_rec_clinic_yn			= rs.getString(6);
			auto_rec_pract_yn			= rs.getString(7);
		    auto_rec_dept_yn           = rs.getString(8);
		  }
		if(rs != null)    rs.close();
		if(pstmt != null) pstmt.close();
		
		if(locnIden == null || locnIden.equals("null"))	locnIden = "N";
		if(userSecurity == null || userSecurity.equals("null"))	userSecurity = "N";

		if(locnIden.equals("N"))
		{
			out.println("<SCRIPT>alert(getMessage(\"NO_TRANSFER_FILES\",\"FM\")); parent.frames[2].location.href='../../eCommon/jsp/dmenu.jsp'; </SCRIPT>");
		}
		if(userSecurity.equals("Y"))
		{
			sql1 = "SELECT 1 FROM fm_user_access_rights WHERE facility_id = ?  AND appl_user_id = ?  AND transfer_file_yn = 'Y' ";
			pstmt = con.prepareStatement(sql1);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,user_id);			

			rs = pstmt.executeQuery();

			if(rs != null && rs.next())
			{
				 userVal = rs.getInt(1);
			}
			if(userVal != 1)
			{
				out.println("<SCRIPT>alert(getMessage(\"FM_NO_USER_RIGHTS\",\"FM\")); parent.frames[2].location.href='../../eCommon/jsp/dmenu.jsp';</SCRIPT>");
			}
		}
	if(rs	 !=null) rs.close();
	if(pstmt !=null) pstmt.close();
	}catch(Exception e){out.println("Exception e :"+e.toString());}
	finally
	{		
		ConnectionManager.returnConnection(con,request);
	}
if(session.getAttribute("user_name")!=null)
session.removeAttribute("user_name");

%>
	<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>' frameborder='0' scrolling='no' noresize style='height:6vh;width:100vw'></iframe>
		<FRAMESET cols="55%,45%" border=0>
		<iframe name='transfer_from' id='transfer_from' src='../../eFM/jsp/FMTransferFileFrom.jsp?userSecurity=<%=userSecurity%>&Dflt_Archive_Locn=<%=Dflt_archive_fs_locn_code%>&Dflt_Lost_Locn=<%=Dflt_lost_fs_locn_code%>&accessAll=<%=userVal%>&auto_rec_ward_yn=<%=auto_rec_ward_yn%>&auto_rec_clinic_yn=<%=auto_rec_clinic_yn%>&auto_rec_pract_yn=<%=auto_rec_pract_yn%>&auto_rec_dept_yn=<%=auto_rec_dept_yn%>' frameborder='0' scrolling='no' noresize style='height:30%;width:50vw'></iframe>
		<iframe name='transfer_to' id='transfer_to' src="../../eFM/jsp/FMTransferFileTo.jsp" frameborder='0' scrolling='no' noresize style='height:16%;width:49vw'></iframe>
		<iframe name='transfer_criteria' id='transfer_criteria' src='../../eCommon/html/blank.html'  frameborder='0' scrolling='no' noresize style="width: 100%;height: 12.6vh;"></iframe>
		<iframe name='transfer_detail' id='transfer_detail' src='../../eCommon/html/blank.html' frameborder='0' scrolling='auto' noresize style="width:100%"></iframe>
		<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder='0' scrolling='no'  noresize style="width: 100%;height: 10vh;position: absolute;bottom: 0;left: 0;"></iframe>
	</FRAMESET>
	</body>
</HTML>

