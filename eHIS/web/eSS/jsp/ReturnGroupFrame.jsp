<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="eSS.ReturnGroupBean,eSS.*, eSS.Common.* , eCommon.Common.*, java.text.*, java.util.*" contentType="text/html;charset=UTF-8"%>

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
		<script language="javascript" src="../../eSS/js/ReturnGroup.js"></script>
		<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		String bean_id			=		"returnGroupBean";
		String bean_name		=		"eSS.ReturnGroupBean";
		String mode				=		request.getParameter("mode");

		if ((mode == null) || (mode.equals(""))) 
			return;
		if ( !(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT"))))
			return;
		
		ReturnGroupBean returnGroupBean = (ReturnGroupBean) getBeanObject( bean_id, bean_name,  request);
		returnGroupBean.clear();//Added by Sakti Sankar against CRF-360
		returnGroupBean.setMode(mode.trim());
		returnGroupBean.setFunctionId(returnGroupBean.checkForNull(request.getParameter("function_id")));
		returnGroupBean.setLanguageId(locale);//Added by Sakti Sankar against CRF-360

		if (mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {

			String doc_type_code		=	request.getParameter("doc_type_code");
			String doc_no				=	request.getParameter("doc_no");
			returnGroupBean.setDoc_type_code (doc_type_code);
			returnGroupBean.setDoc_no(doc_no);
			returnGroupBean.loadData();
		}
		//Comented by Sakti Sankar against CRF-360
		/*else {
			returnGroupBean.clear();
		}*/

			putObjectInBean(bean_id,returnGroupBean,request); 


	%>
	<frameset rows='100,*'>
		<frame name='frameReturnGroupHeader' id='frameReturnGroupHeader' src="../../eSS/jsp/ReturnGroupHeader.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='no'   noresize>
 		<frameset cols="40%,*" >
			<frame name='frameReturnGroupDetail' id='frameReturnGroupDetail' src="../../eSS/jsp/ReturnGroupDetail.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='no'   noresize>
			<frame name='frameReturnGroupList' id='frameReturnGroupList' src='../../eSS/jsp/ReturnGroupList.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling='auto' noresize>
		</frameset>
	</frameset>
</html>

