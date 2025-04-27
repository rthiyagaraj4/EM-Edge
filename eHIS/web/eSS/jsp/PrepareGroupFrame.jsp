<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
 <jsp:useBean id="obj0" scope="page" class="eSS.PrepareGroupBean"/>
<%@ page import=" eSS.*, eSS.Common.* , eCommon.Common.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<!-- 	<link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link>
 --><%
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eSS/js/SsCommon.js"></script>
	<script language="JavaScript" src="../../eSS/js/SsTransaction.js"></script>
	<script language="JavaScript" src="../../eSS/js/PrepareGroup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

    <script>
        function_id = "<%= request.getParameter("function_id")%>";
		menu_id		= "<%= request.getParameter( "menu_id" ) %>"
		module_id	= "<%= request.getParameter( "module_id" ) %>"
		
    </script>
</head>
<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	
	String mode	=		request.getParameter("mode");
	String doc_no	=		request.getParameter("doc_no");
	String doc_type_code	=		request.getParameter("doc_type_code");
	String doc_ref	=		request.getParameter("doc_ref");
	String doc_date	=		request.getParameter("doc_date");
	String store_code	=		request.getParameter("store_code");
	
	System.out.println("mode in frame"+mode);
	String params = request.getQueryString();
	String bean_id = "prepareGroupBean";
	String bean_name = "eSS.PrepareGroupBean";
	PrepareGroupBean bean = (PrepareGroupBean) getBeanObject(bean_id,bean_name,request); 
	if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))) {
	 bean.clear();
			bean.initialize();
	}else if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {
		bean.setDoc_type_code (doc_type_code.trim());
		bean.setDoc_no (doc_no.trim());
		bean.setDefaultDocType(doc_type_code.trim());
		bean.setStore_code(store_code);
		bean.setDefaultStoreCode(bean.getStore_code());
		bean.setDoc_ref(doc_ref);
		bean.setDoc_date(doc_date);
		bean.loadData() ;
	}
%>
<iframe name="PrepareGroupHeaderFrame" id="PrepareGroupHeaderFrame" frameborder="0" scrolling="no" noresize src="../../eSS/jsp/PrepareGroupHeader.jsp?<%=params%>" style="height:150%;width:100vw"></iframe><iframe name="PrepareGroupListFrame" id="PrepareGroupListFrame" src="../../eSS/jsp/PrepareGroupDetail.jsp?<%=params%>" frameborder="0" noresize scrolling="auto" style="height:100vh;width:100vw"></iframe>
<%
putObjectInBean(bean_id,bean,request);
%>
</html> 
 

