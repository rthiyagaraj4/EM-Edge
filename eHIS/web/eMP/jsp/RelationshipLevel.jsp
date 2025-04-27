<!DOCTYPE html>
<%@ page session="false" contentType="text/html;charset=UTF-8" import="java.sql.*,webbeans.eCommon.*"%>
<html>
	<head>
		<script language='javascript' src='../js/RelationshipLevel.js'></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
	</head>
<%
	request.setCharacterEncoding("UTF-8");
	String params = request.getQueryString() ;
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String source = url + params ;
%>
	
			<frameset id='relation' rows='14%,12%,*,8%'>
				<frame name='commontoolbarFrame'	src=<%= source %> frameborder=0 scrolling='no' noresize>
				<frame name='relnshp_lvl_crtra' 	src='../../eCommon/html/blank.html' frameborder=no scrolling='no'>

				<frameset cols="60%,40%" border="0" framespacing=2>
					<frame name="relnshp_lvl_res" src = "../../eCommon/html/blank.html"
					 marginheight='0' marginwidth='0' scrolling='auto'  BORDERCOLOR='green' frameborder='no' noresize>
					<frame name="relnshp_lvl_add_mod" src = "../../eCommon/html/blank.html" marginheight='0' marginwidth='0'  frameborder='no'  scrolling='no' noresize >
				</frameset> 
				<frame name='messageFrame'	src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto'>
			</frameset>			
</html>


