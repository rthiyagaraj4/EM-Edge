<!DOCTYPE html>
<!--
	Developed by 	:	Smita Unnikrishnan
	Created on 	:	12/05/2004
	Module		:	Out Patient Management
	Function	:	This file is used for displaying of frame 3 frames for the function ArrivedDeparted as below
-->
 <%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,webbeans.eCommon.*" %> 
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

	<html>
	<head>		
		 <script language="javascript" src="../../eOP/js/ArrivedDeparted.js"></script>
		 <script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		 <script language="javascript" src="../../eCommon/js/common.js"></script>
		 <script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	 </head>	 
	 <%
	   request.setCharacterEncoding("UTF-8");
	   	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
       String params = request.getQueryString() ;
       String source = url + params ;
		
		%>
	<iframe name='commontoolbarFrame' id='commontoolbarFrame'    src=<%=source%> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
		<iframe name='f_query_add_mod' src="../../eOP/jsp/CallArrivedDeparted.jsp" frameborder=0  id='f_query_add_mod'  FRAMEBORDER=NO    scrolling='no' style='height:80vh;width:100vw'></iframe>
		<iframe src='../../eCommon/jsp/error.jsp' frameborder=0 name='messageFrame' id='messageFrame'  FRAMEBORDER=NO    scrolling='no' style='height:12vh;width:100vw'></iframe>
	

	  
</html>

