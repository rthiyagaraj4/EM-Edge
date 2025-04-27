<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCP
*	Purpose 		:	
*	Created By		:	Venkatasubbu PR
*	Created On		:	21 Feb 2005
--%>
<%@page contentType="text/html;charset=UTF-8"%>

<html>
<head>

<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%
	 //This file is saved on 18/10/2005.
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<iframe name='assign_care_mgr_result' id='assign_care_mgr_result'	src='../../eCP/jsp/AssignCareManagerQueryResult.jsp' frameborder=0 noresize scrolling='auto' style='height:50vh;width:99vw'></iframe><iframe name='assign_care_mgr_addmod' id='assign_care_mgr_addmod'	src='../../eCP/jsp/AssignCareManagerAddModify.jsp' frameborder=0 noresize scrolling='no' style='height:42vh;width:99vw'></iframe><iframe name='assign_care_mgr_toolbar' id='assign_care_mgr_toolbar'	src='../../eCP/jsp/AssignCareManagerToolbar.jsp' frameborder=0 noresize scrolling='no' style='height:10vh;width:99vw'></iframe><iframe name='messageFrame1' id='messageFrame1'	src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' style='height:12vh;width:99vw'></iframe>
</html>

