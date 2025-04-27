<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ page import="eSS.AssignBinLocationBean" %>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<html>
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		
		<script language="javascript" src="../../eSS/js/AssignBinLocation.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
		<script language='javascript' src='../../eCommon/js/common.js'></script>
	</head>
	<%
		String bean_id			= "AssignBinLocationBean";
		String bean_name		= "eSS.AssignBinLocationBean";
		String mode				= request.getParameter("mode");
	
		
		if ((mode == null) || (mode.equals(""))) 
			return;
		if ( !(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT"))))
			return;
		String doc_type_code	=	request.getParameter("doc_type_code");
		String doc_no			=	request.getParameter("doc_no");

		AssignBinLocationBean bean = (AssignBinLocationBean) getBeanObject( bean_id,  bean_name, request);  
		bean.setDoc_type_code(doc_type_code.trim());
		bean.setDoc_no(doc_no.trim());
		bean.loadData();
		
		putObjectInBean(bean_id,bean,request);


	%>
	<frameset rows='100,*'>
		<frame name='AssignBinLocationHeaderFrame' src="../../eSS/jsp/AssignBinLocationHeader.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='no'   noresize>
 		<frameset cols="40%,*" >
			<frame name='AssignBinLocationDetailFrame' src="../../eSS/jsp/AssignBinLocationDetail.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='no'   noresize>
			<frameset rows="15,*">
				<frame name='AssignBinLocationListHeaderFrame' src='../../eSS/html/AssignBinLocationListHeader.html' frameborder=0 scrolling='no'   noresize>
				<frame name='AssignBinLocationListFrame' src='../../eSS/jsp/AssignBinLocationList.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling='auto' noresize>
			</frameset>
		</frameset>
	</frameset>
</html>
