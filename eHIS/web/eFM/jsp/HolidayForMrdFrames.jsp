<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,java.text.*,webbeans.eCommon.*" %>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>

<head>

	 <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>	
	<script language="javascript" src="../../eCommon/js/common.js"></script>	
	<script language="javascript" src="../../eFM/js/HolidayForMrd.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
	
</head>

<%
    request.setCharacterEncoding("UTF-8");
	String url 	= "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params	= request.getQueryString() ;
	String source   = url+params ;

%>
		<frameset id=mrdholiday rows='8%,20%,*,8%'>
			<frame name='commontoolbarFrame' src='<%=source%>' frameborder=0 scrolling=no noresize>
			<frame name='f_query_add_mod'    src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no'>
			<frame name='f_query_add_mod1' 	src='../../eCommon/html/blank.html' frameborder=0 scrolling='no'>
			<frame name='messageFrame'		 src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling=auto>
		</frameset>
</html>


