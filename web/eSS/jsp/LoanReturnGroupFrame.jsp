<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="eSS.LoanReturnGroupBean,eSS.*, eSS.Common.* , eCommon.Common.*, java.text.*, java.util.*" contentType="text/html;charset=UTF-8"%>

<%@	include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 

<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
		String sStyle			=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String locale			= (String)session.getAttribute("LOCALE");
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eSS/js/LoanReturnGroup.js"></script>
		<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		String bean_id			=		"LoanReturnGroupBean";
		String bean_name		=		"eSS.LoanReturnGroupBean";
		String mode				=		request.getParameter("mode");

		if ((mode == null) || (mode.equals(""))) 
			return;
		if ( !(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT"))))
			return;
		
		LoanReturnGroupBean LoanReturnGroupBean = (LoanReturnGroupBean) getBeanObject( bean_id, bean_name,  request);
		LoanReturnGroupBean.clear();//Added by Sakti Sankar against CRF-360
		LoanReturnGroupBean.setMode(mode.trim());
		LoanReturnGroupBean.setFunctionId(LoanReturnGroupBean.checkForNull(request.getParameter("function_id")));
		LoanReturnGroupBean.setLanguageId(locale);//Added by Sakti Sankar against CRF-360

		if (mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {

			String doc_type_code		=	request.getParameter("doc_type_code");
			String doc_no				=	request.getParameter("doc_no");
			LoanReturnGroupBean.setDoc_type_code (doc_type_code);
			LoanReturnGroupBean.setDoc_no(doc_no);
			LoanReturnGroupBean.loadData();
		}
		//Comented by Sakti Sankar against CRF-360
		/*else {
			LoanReturnGroupBean.clear();
		}*/

			putObjectInBean(bean_id,LoanReturnGroupBean,request); 


	%>
	<iframe name='frameLoanReturnGroupHeader' id='frameLoanReturnGroupHeader' src="../../eSS/jsp/LoanReturnGroupHeader.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='no'   noresize style='height:100%;width:100vw'></iframe>
 		<iframe name='frameLoanReturnGroupList' id='frameLoanReturnGroupList' src='../../eSS/jsp/LoanReturnGroupList.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling='auto' noresize style='height:100vh;width:100vw'></iframe>		
	
</html>

