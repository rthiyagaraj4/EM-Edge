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
*	Created By		:	Vinay
*	Created On		:	31 Jan 2005
--%>
<%@page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'> -->
<%
	 //This file is saved on 16/12/2005.
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<!-- <script language="JavaScript" src="../../eCP/js/common.js"></script> -->
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script language="JavaScript" src="../js/AssessmentCriteriaScore.js"></script>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<iframe name='assess_crit_score_header' id='assess_crit_score_header' src='../../eCP/jsp/AssessmentCriteriaScoresHeader.jsp' frameborder=0 noresize scrolling='no' style='height:32vh;width:99vw'></iframe>
<iframe name='blankFrame' id='blankFrame' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' style='height:0vh;width:99vw'></iframe>
<iframe name='assess_crit_score_addmod' id='assess_crit_score_addmod'	src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto' style='height:60vh;width:99vw'></iframe>
</html>

