<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page  import=" eST.*,eSS.*,eSS.Common.*, eST.Common.* , eCommon.Common.*, java.text.*, java.util.*,java.lang.*" contentType="text/html;charset=UTF-8"%>

<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title> </title> 
		<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");

		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		CheckListBean bean = (CheckListBean)getBeanObject( "checkListBean","eSS.CheckListBean", request ) ;  
		bean.setLanguageId(locale);
		bean.clear();
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
		<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
		<script language="JavaScript" src="../../eSS/js/CheckList.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	 <script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<iframe name='frameKitTemplateMain' id='frameKitTemplateMain' src="../../eSS/jsp/CheckListMain.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='no'   noresize style='height:25vh;width:100vw'></iframe>
		<iframe name='frameKitTemplateListDetail' id='frameKitTemplateListDetail'			src="../../eSS/jsp/CheckListListDetail.jsp?<%=request.getQueryString()%>"	frameborder=0 scrolling='auto' noresize style='height:45vh;width:100vw'></iframe>
		<iframe name='frameKitTemplateAddModify' id='frameKitTemplateAddModify'	src="../../eSS/jsp/CheckListAddModify.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='no' noresize style='height:30vh;width:100vw'></iframe>
	
	<%
putObjectInBean("checkListBean",bean,request);
%>
</html>

