<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
 <jsp:useBean id="obj0" scope="page" class="eSS.LoanRequestGroupBean"/>
<%@ page  import=" eSS.*, eSS.Common.* , eCommon.Common.*, java.text.*, java.util.*" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<html>
	<head>
		<title></title>
		<meta name="Generator" content="EditPlus @ MEDICOM Solutions (P) Ltd. Bangalore. INDIA.">
		<meta name="Author" content="Manish Anand">
<%
		request.setCharacterEncoding("UTF-8");
		String sStyle					=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="JavaScript" src="../../eSS/js/SsTransaction.js"></script>
		<script language="JavaScript" src="../../eSS/js/LoanRequestGroup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</head>
<%
	
		String locale			 = (String)session.getAttribute("LOCALE");		
		
		String mode				 =		request.getParameter("mode");
		String doc_no			 =		request.getParameter("doc_no");
		String doc_type_code	 =		request.getParameter("doc_type_code");
		String req_on_store_code =		request.getParameter("req_on_store_code");
		
				
		String params = request.getQueryString();
		String bean_id = "LoanRequestGroupBean";
		String bean_name = "eSS.LoanRequestGroupBean";
		LoanRequestGroupBean bean = (LoanRequestGroupBean) getBeanObject(bean_id,bean_name,request); 
		bean.setLanguageId(locale);
		
		   
		if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))) {
		 	bean.clear();
			bean.initialize();
		}else if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {
			bean.setDoc_type_code (doc_type_code.trim());
			bean.setDoc_no (doc_no.trim());
			
			bean.loadData();
			bean.loadDtlData() ;
						
		}//Added ends
	putObjectInBean("LoanRequestGroupBean",bean,request);

%>
<!-- 	<frameset rows='100,*'>
		<frame name='frameLoanRequestGroupHeader' id='frameLoanRequestGroupHeader'				src="../../eSS/jsp/LoanRequestGroupHeader.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='no'   noresize>
		<frameset cols="40%,*" >
			<frame name='frameLoanRequestGroupDetail' id='frameLoanRequestGroupDetail'			src="../../eSS/jsp/LoanRequestGroupDetail.jsp?<%=request.getQueryString()%>"					frameborder=0 scrolling='no'   noresize>
			<frame name='frameLoanRequestGroupList' id='frameLoanRequestGroupList'			src="../../eSS/jsp/LoanRequestGroupList.jsp?<%=request.getQueryString()%>"					frameborder=0 scrolling='auto' noresize>
		</frameset>

	</frameset> -->
	<frameset rows="150,*">
	<frame name="frameLoanRequestGroupHeader" id="frameLoanRequestGroupHeader" frameborder="0" scrolling="no" noresize src="../../eSS/jsp/LoanRequestGroupHeader.jsp?<%=request.getQueryString()%>">
	<frame name="frameLoanRequestGroupList" id="frameLoanRequestGroupList" src="../../eSS/jsp/LoanRequestGroupLists.jsp?<%=request.getQueryString()%>" frameborder="0" noresize scrolling="auto">
</frameset>

</html>

