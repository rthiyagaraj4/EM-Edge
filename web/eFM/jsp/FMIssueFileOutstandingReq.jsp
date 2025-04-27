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
	<script src='../../eFM/js/FMIssueFiles.js' language='javascript'></script>
</head>

<%
	String userSecurity		= checkForNull( request.getParameter("userSecurity"));
	String resLocnIdentities	= checkForNull( request.getParameter("resLocnIdentities"));
	String strLocn				= checkForNull( request.getParameter("strLocn"));
	String s_file_no				= checkForNull( request.getParameter("s_file_no"));
	String s_fs_locn_code		= checkForNull( request.getParameter("s_fs_locn_code"));
	String s_fs_narration		= checkForNull( request.getParameter("s_fs_narration"));
	String s_request_date		= checkForNull( request.getParameter("s_request_date"));
	String s_request_by_id	= checkForNull( request.getParameter("s_request_by_id"));
	String s_fs_locn_identity	= checkForNull( request.getParameter("s_fs_locn_identity"));
	String refresh				= checkForNull( request.getParameter("refresh"));
	String file_type_yn			= checkForNull( request.getParameter("file_type_yn"));
	String s_file_type			= checkForNull( request.getParameter("s_file_type"));
	String s_volume_no		= checkForNull( request.getParameter("s_volume_no"));
	String access_all  = checkForNull( request.getParameter("access_all"),"access_all");
	String file_no_concat=checkForNull( request.getParameter("file_no_concat"));
	String volume_no_concat=checkForNull( request.getParameter("volume_no_concat"));
	String isOutStandingReqAvialble=checkForNull( request.getParameter("isOutStandingReqAvialble"));
	s_file_type		=	((s_file_type==null) || (s_file_type.equals("null"))) ? "" : s_file_type;
	s_volume_no	=	((s_volume_no==null) || (s_volume_no.equals("null"))) ? "" : s_volume_no;
%>
	<script language="JavaScript">
	<!--
	//	setTimeout("document.location.reload();",1000*60*<%=refresh%>)
	//-->
	</script>
		<%if(isOutStandingReqAvialble.equals("true")){ %>
		 <frameset cols='22%,*'>
		 <frameset rows='60%,40%' >
 		     <frame name='OutstaListFrame1' src='../../eFM/jsp/FMIssueFileOutstandingList1.jsp?userSecurity=<%=userSecurity%>&resLocnIdentities=<%=resLocnIdentities%>&file_type_yn=<%=file_type_yn%>&strLocn=<%=strLocn%>&access_all=<%=access_all%>' frameborder=0 scrolling=auto noresize>
			<frame name='OutstaListFrame2' src='../../eCommon/html/blank.html' scrolling=auto frameborder=0 noresize>
		
		</frameset>
		<frameset rows='40%,*,6%' >
		    <frame name='OutstaHeader' src='../../eCommon/html/blank.html' frameborder=0 scrolling=auto noresize >
			<frame name='OutstanListDetail' src='../../eCommon/html/blank.html' scrolling=auto frameborder=0 noresize>
			<frame name='OutstanListButton' src='../../eCommon/html/blank.html'  scrolling=no frameborder=0 noresize>
		</frameset>
	 </frameset>
	  
		<%}else{ %>
		<frameset rows='90%,*'>
			<frame name='OutstanListDetail' src='../../eFM/jsp/FMIssueFileOutstandingDetail.jsp?userSecurity=<%=userSecurity%>&access_all=<%=access_all%>&resLocnIdentities=<%=resLocnIdentities%>&file_type_yn=<%=file_type_yn%>&strLocn=<%=strLocn%>&s_file_no=<%=s_file_no%>&s_fs_locn_code=<%=s_fs_locn_code%>&s_fs_narration=<%=s_fs_narration%>&s_request_date=<%=s_request_date%>&s_request_by_id=<%=s_request_by_id%>&file_no_concat=<%=file_no_concat%>&s_fs_locn_identity=<%=s_fs_locn_identity%>&volume_no_concat=<%=volume_no_concat%>&s_file_type=<%=s_file_type%>&s_volume_no=<%=s_volume_no%>' scrolling=auto frameborder=0 noresize>
			<frame name='OutstanListButton' src='../../eFM/jsp/FMIssueFileOutstandingButton.jsp?resLocnIdentities=<%=resLocnIdentities%>'  style='border-style: solid;	border-color:black; border-width:1' scrolling=no frameborder=0 noresize>
		</frameset>
		<%} %>
		
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

