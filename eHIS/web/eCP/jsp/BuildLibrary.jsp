<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%--
*	Copyright � MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCP
*	Purpose 		:	
*	Created By		:	Sandhya.S
*	Created On		:	24 jan 2005

--%>
<%@page import="eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>
<HTML>
<%
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<HEAD>
<SCRIPT language="javascript" src="../../eCommon/js/ValidateControl.js" ></SCRIPT>
<SCRIPT language="javascript" src="../../eCommon/js/common.js"></SCRIPT>
<SCRIPT language="javascript" src="../../eCP/js/BuildLibrary.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
<%
//This file is saved on 18/10/2005.
	String url			= "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
 	String params		= request.getQueryString() ;
	String source		= url + params ;
	//System.err.println("url "+url);
%>

<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>'	frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' 	 src='../../eCommon/html/blank.html' frameborder=0 noresize style='height:84vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame'		 src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' style='height:8vh;width:100vw'></iframe>
</HEAD>

<script>
	setTimeout("disableapply();",1500);
	//disableapply();
</script>
</HTML>

