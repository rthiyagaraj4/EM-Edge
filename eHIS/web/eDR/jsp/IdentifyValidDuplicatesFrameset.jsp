<!DOCTYPE html>
<!-- Developed By       :  P.Sudhakaran -->

<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.text.*,webbeans.eCommon.*" %>
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
	<script language='javascript' src='../../eDR/js/IdentifyValidDuplicates.js'></script>
	<Script language="JavaScript" src="../../eCommon/js/common.js" ></Script>
<!-- 	<script language="javascript" src="../../eDR/js/DRrowcolor.js" ></script> -->
	<Script Language="JavaScript" src="../../eCommon/js/rowcolor.js"></Script>
</head>
<%	
	
	Connection con			= null;
	PreparedStatement pstmt = null;	
	ResultSet rs  			= null;	

	String grp_no	= "";

	try
	{	
		con		= ConnectionManager.getConnection(request);
		//pstmt	= con.createStatement(); 
		
		String sql1		= ""; 		
		
		sql1  = "SELECT count(1) grp_no FROM DR_DUP_GROUP_HDR A,DR_DUP_GROUP_DTLS B WHERE A.DUP_GROUP_ID = B.DUP_GROUP_ID AND system_gen_yn='Y' AND marked_for_merge_yn='N' AND group_status = 'U' AND sug_valid_pat_flag='Y'";
		
		pstmt = con.prepareStatement(sql1);	
		rs    = pstmt.executeQuery();
		if(rs != null)
		{
			if(rs.next())
			{
				grp_no = rs.getString("grp_no");		
			}
		}
		
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
	}
	catch(Exception e)
	{
		out.println("Exception e :"+e.toString());
		e.printStackTrace();
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
	
	String modal = request.getParameter("modal");	
	
	if(modal == null || modal.equals("null")) modal = "";

	if(modal.equals("Y"))
	{
		%>
		<FRAMESET COLS="28,72">
			<FRAMESET ROWS='80,*'>
				<FRAME NAME='GROUP_TITLE' id='GROUP_TITLE' FRAMEBORDER='0' SRC="../../eDR/jsp/IdentifyValidDuplicateHeaderTitle.jsp?modal=<%=modal%>&grp_no=<%=grp_no%>" scrolling='no' noresize>
				<FRAMESET COLS='92%,*'>
					<FRAME NAME='GROUP_HDR' id='GROUP_HDR' FRAMEBORDER='0'  SRC="../../eDR/jsp/IdentifyValidDuplicateHeader.jsp?modal=<%=modal%>&grp_no=<%=grp_no%>" scrolling='no' noresize>
					<FRAME NAME='GROUP_RECORD_IMAGE' id='GROUP_RECORD_IMAGE' FRAMEBORDER='0'  	SRC="../../eDR/jsp/IdentifyValidDuplicateArrow.jsp?grp_no=<%=grp_no%>" scrolling='no' noresize>
				</FRAMESET>
			</FRAMESET>
			<FRAMESET ROWS="14%,14%,*">
				<FRAME NAME='SEARCH_SCREEN'  id='SEARCH_SCREEN' FRAMEBORDER='0' SRC='../../eDR/jsp/IdentifyValidDuplicateSearch.jsp?modal=<%=modal%>'>
				<FRAME NAME='GROUP_DTLS_TITLE' id='GROUP_DTLS_TITLE' FRAMEBORDER='0'  SRC='../../eDR/jsp/IdentifyValidDuplicateDetailsTitle.jsp'>
			    <FRAME NAME='GROUP_DTLS' id='GROUP_DTLS' FRAMEBORDER=0  SRC="">
			</FRAMESET>
		</FRAMESET>
		<%
	}
	else
	{
		%>
		<FRAMESET COLS="28,72">
			<FRAMESET ROWS='60,*'>
				<FRAME NAME='GROUP_TITLE' id='GROUP_TITLE' FRAMEBORDER=0 SRC="../../eDR/jsp/IdentifyValidDuplicateHeaderTitle.jsp?modal=<%=modal%>&grp_no=<%=grp_no%>" scrolling=no noresize>
				<FRAMESET COLS='92%,*'>
					<FRAME NAME='GROUP_HDR' id='GROUP_TITLE' FRAMEBORDER=0  SRC="../../eDR/jsp/IdentifyValidDuplicateHeader.jsp?modal=<%=modal%>&grp_no=<%=grp_no%>" scrolling='no' noresize>
					<FRAME NAME='GROUP_RECORD_IMAGE' id='GROUP_RECORD_IMAGE' FRAMEBORDER=0  SRC="../../eDR/jsp/IdentifyValidDuplicateArrow.jsp?grp_no=<%=grp_no%>" scrolling='no' noresize>
				</FRAMESET>
			</FRAMESET>
			<FRAMESET ROWS="14%,14%,*">
				<FRAME NAME='SEARCH_SCREEN' id='SEARCH_SCREEN' FRAMEBORDER='0' SRC='../../eDR/jsp/IdentifyValidDuplicateSearch.jsp?modal=<%=modal%>' noresize>
				<FRAME NAME='GROUP_DTLS_TITLE' id='GROUP_DTLS_TITLE' FRAMEBORDER='0'  SRC='../../eDR/jsp/IdentifyValidDuplicateDetailsTitle.jsp' noresize>
				<FRAME NAME='GROUP_DTLS' id='GROUP_DTLS' FRAMEBORDER='0'  SRC="" noresize>
			</FRAMESET>
		</FRAMESET>
		<%
	}
%>
</html>
