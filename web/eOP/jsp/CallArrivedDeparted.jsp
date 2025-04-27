<!DOCTYPE html>
<!--
	Developed by 	:	Smita Unnikrishnan
	Created on 	:	12/05/2004
	Module		:	Out Patient Management
	Function	:	This file is used for displaying of frame 3 frames for the function ArrivedDeparted as below
-->
<%@ page import="webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>		
		 <script language="javascript" src="../../eOP/js/ArrivedDeparted.js"></script>
		 <script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		 <script language="javascript" src="../../eCommon/js/common.js"></script>
		 <script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	 </head>
	<% request.setCharacterEncoding("UTF-8"); %>
	<iframe name='dispimg_frame' id='dispimg_frame' src='../../eOP/jsp/PatTrackMovementHead.jsp' frameborder=0 scrolling='no' noresize style='height:3.5vh;width:100vw'></iframe>
		<iframe name='criteria_frame' id='criteria_frame' 	src='../../eOP/jsp/ArrivedDepartedCriteria.jsp?Pageval=D' frameborder=0 scrolling='no' style='height:25vh;width:100vw'></iframe>
		<iframe name='result_frame' id='result_frame' src='../../eCommon/html/blank.html' frameborder=0  style='height:50vh;width:100vw'></iframe>		
	
</html>

