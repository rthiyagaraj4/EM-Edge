<!DOCTYPE html>
<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*" contentType="text/html; charset=UTF-8" %>
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
	<script src='../../eFM/js/FMIssueFiles.js' language='javascript'></script>
</head>

<%
	String userSecurity			= request.getParameter("userSecurity");
	String resLocnIdentities	= request.getParameter("resLocnIdentities");
	String strLocn				= request.getParameter("strLocn");
	String s_file_no			= request.getParameter("s_file_no");
	String s_fs_locn_code		= request.getParameter("s_fs_locn_code");
	String s_fs_narration		= request.getParameter("s_fs_narration");
	String s_request_date		= request.getParameter("s_request_date");
	String s_request_by_id		= request.getParameter("s_request_by_id");
	String s_fs_locn_identity	= request.getParameter("s_fs_locn_identity");
	String refresh				= request.getParameter("refresh");
	String s_file_type			= request.getParameter("s_file_type");
	String s_volume_no			= request.getParameter("s_volume_no");
	String access_all  = request.getParameter("access_all")==null?"":request.getParameter("access_all");

	s_file_type	=	((s_file_type==null) || (s_file_type.equals("null"))) ? "" : s_file_type;
	s_volume_no	=	((s_volume_no==null) || (s_volume_no.equals("null"))) ? "" : s_volume_no;

%>
		<script language="JavaScript">
		<!--
			setTimeout("document.location.reload();",1000*60*<%=refresh%>)
		//-->
		</script>
	 <frameset cols='22%,*'>
		 <frameset rows='50%,50%' style='border-style: solid; border-color: #0000CD;border-width:2'>
 		     <frame name='OutstaListFrame1' src='../../eFM/jsp/DTIssueFileOutstandingList1.jsp?userSecurity=<%=userSecurity%>&access_all=<%=access_all%>&resLocnIdentities=<%=resLocnIdentities%>&strLocn=<%=strLocn%>&s_file_no=<%=s_file_no%>&s_fs_locn_code=<%=s_fs_locn_code%>&s_fs_narration=<%=s_fs_narration%>&s_request_date=<%=s_request_date%>&s_request_by_id=<%=s_request_by_id%>&s_fs_locn_identity=<%=s_fs_locn_identity%>&s_file_type=<%=s_file_type%>&s_volume_no=<%=s_volume_no%>' frameborder=0 scrolling=auto noresize>
			 <frame name='OutstaListFrame2' src='../../eCommon/html/blank.html' frameborder=0 scrolling=auto noresize>
		</frameset>

		<frameset rows='40%,*,6%'>
		    <frame name='OutstaHeader' src='../../eCommon/html/blank.html' frameborder=0 scrolling=auto noresize>
			<frame name='OutstanListDetail' src='../../eCommon/html/blank.html' scrolling=auto frameborder=0 noresize>
			<frame name='OutstanListButton' src='../../eCommon/html/blank.html' style='border-style: solid; border-color:black; border-width:1' scrolling=no frameborder=0 noresize>
		</frameset>
	 </frameset>
</html>

