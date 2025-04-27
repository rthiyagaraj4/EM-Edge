<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page   import=" eSS.*, eSS.Common.* , eCommon.Common.*" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
 <%@include file="../../eCommon/jsp/CommonInclude.jsp" %>

<html>
	<head>
	
		<title> </title>
<%
		request.setCharacterEncoding("UTF-8");
		String sStyle		=		 (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language='javascript' src='../../eSS/js/SsCommon.js'></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language='javascript' src='../../eSS/js/SsTransaction.js'></script>
		<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
		<script>
			function_id		=		"<%= request.getParameter("function_id")%>";
		</script>
	</head>
	<%
		String bean_id			=		 "rofEntryBean";
		String bean_name		=		 "eSS.ROFEntryBean";
		String mode				=		 request.getParameter("mode");
		if ((mode == null) || (mode.equals(""))) 
			return;
		if ( !(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT"))))
			return;

		ROFEntryBean bean		=		(ROFEntryBean)getBeanObject( bean_id, bean_name, request ) ;

		bean.clear();
		bean.setMode(mode.trim());
		bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
		if (mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {
			String doc_type_code	=	 request.getParameter("doc_type_code");
			String doc_no			=	 request.getParameter("doc_no");
			
			bean.setDoc_type_code (doc_type_code.trim());
			bean.setDoc_no(doc_no.trim());
			bean.loadData();
		}

	%>
	<frameset rows='100,*'>
		<frame name='frameROFEntryHeader' src="../../eSS/jsp/ROFEntryHeader.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='no'   noresize>
		<frameset cols="40%,*" >
			<frame name='frameROFEntryDetail' src="../../eSS/jsp/ROFEntryDetail.jsp?<%=request.getQueryString()%>"					frameborder=0 scrolling='no'   noresize>
			<frameset rows="15,*">
				<frame name='frameROFEntryListHeader'	src='../../eSS/html/ROFEntryListHeader.html'			frameborder=0 scrolling='no'   noresize>
				<frame name='frameROFEntryList' src="../../eSS/jsp/ROFEntryList.jsp?<%=request.getQueryString()%>"					frameborder=0 scrolling='auto' noresize>
			</frameset>
		</frameset>
	</frameset>
	<%	putObjectInBean(bean_id,bean,request);%>

</html>
