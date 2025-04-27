<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.net.*, java.util.*, java.text.*, webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<!-- <link rel='stylesheet' type='text/css' href='../../eComman/html/IeStyle.css'></link> -->
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eOP/js/ConcludeEpisode.js'></script> 
	<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<%
		String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
		String params = request.getQueryString();
		String source = url + params;
%>
		
	<iframe name="commontoolbarFrame" id="commontoolbarFrame" src=<%=source%> frameborder='0' scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe name="concl_episode_criteria" id="concl_episode_criteria" src="../../eOP/jsp/ConcludeEpisodeCriteria.jsp" frameborder=0 scrolling='no' noresize style='height:30vh;width:100vw'></iframe>
	<iframe name="concl_episode_result" id="concl_episode_result" src="../../eCommon/html/blank.html" frameborder=0 scrolling='auto' noresize style='height:50vh;width:100vw'></iframe>
	<iframe name="messageFrame" id="messageFrame" src="../../eCommon/jsp/error.jsp" frameborder=0 scrolling='auto' noresize style='height:12vh;width:100vw'></iframe>
	

	
</html>

