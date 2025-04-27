<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import=" eSS.*, eSS.Common.* , eCommon.Common.*, java.text.*, java.util.*"  contentType="text/html;charset=UTF-8" %>  
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<html>
	<head>
		
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
		<script language='javascript' src='../../eCommon/js/common.js'></script>
		<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		
		<script language='javascript' src='../../eSS/js/AssignBinLocation.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		String url			=	"../../eCommon/jsp/MstCodeToolbar.jsp?" ;
		String params		=	request.getQueryString() ;
		String source		=	url + params ;
	%>
	<iframe name='qryCriteriaAssignBinLocation' id='qryCriteriaAssignBinLocation' src="../../eSS/jsp/AssignBinLocationQueryCriteria.jsp?<%=source%>" frameborder=0  scrolling='no' style='height:90%;width:100vw'></iframe><iframe name='qryResultAssignBinLocation' id='qryResultAssignBinLocation' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' style='height:100vh;width:100vw'></iframe>
</html>

