<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page  import=" eSS.*, eSS.Common.* , eCommon.Common.*, java.text.*, java.util.*" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp" %>

<html>
	<head>
<%
			request.setCharacterEncoding("UTF-8");
			String sStyle		=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eSS/js/GenerateROF.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

   </head>

	<%

		String mode				=		request.getParameter("mode");
				
		if ((mode == null) || (mode.equals(""))) 
			return;
		if ( !(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT"))))
			return; 

		
	%>
	<iframe name='frameGenerateROFFrameHeader' id='frameGenerateROFFrameHeader' src="../../eSS/jsp/GenerateROFHeader.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='no'   noresize style='height:110%;width:100vw'></iframe>
		<iframe name='frameGenerateROFFrameList' id='frameGenerateROFFrameList' src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:100vh;width:100vw'></iframe>
	
</html>

