<!DOCTYPE html>
<!--
	Created on	:	12/02/2002
	Created by	:	NANDA KUMAR R.


-->

<!doctype html public "-//W3C//DTD HTML 4.0 Transitional//EN">
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%@ page contentType="text/html;charset=UTF-8"  %>
<html>
<head>
<title> <fmt:message key="Common.NewDocument.label" bundle="${common_labels}"/> </title>
	 <!--   <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	 <%
	 request.setCharacterEncoding("UTF-8");
	String sStyle	=
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	   <script language='javascript' src='../../eDR/js/PossibleDuplicates.js'></script>
	   <script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

  </head>
<%
	String url    = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
	
%>
<frameset rows='8%,*,7%'>
			<frame name='commontoolbarFrame' src=<%=source%> frameborder=0 scrolling=no noresize>
			<frame name='f_query_add_mod' src='../../eDR/jsp/PossibleDuplicatesFrameset.jsp' frameborder=0 scrolling='NO'>
			<frame name='messageFrame' src='../../eCommon/jsp/error.jsp' scrolling='no' frameborder='0' noresize>
</frameset>
</html>

