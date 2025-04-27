<!DOCTYPE html>
 <jsp:useBean id="obj0" scope="page" class="eST.CancelRequestBean"/>
<%@ page import=" eST.*, eST.Common.* , eCommon.Common.*" contentType="text/html;charset=UTF-8"%>
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
	<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
	<script language="JavaScript" src="../../eST/js/StTransaction.js"></script>
	<script language="JavaScript" src="../../eST/js/CancelRequest.js"></script>
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
	

	String params = request.getQueryString();
	String bean_id = "cancelRequestBean";
	String bean_name = "eST.CancelRequestBean";
	CancelRequestBean bean = (CancelRequestBean) getBeanObject(bean_id,bean_name,request);  
	bean.initialize();

	String doc_type_code = request.getParameter("doc_type_code");
	String doc_no = request.getParameter("doc_no");
	bean.loadData(doc_type_code, doc_no);
	bean.setLanguageId(locale);
%>
<iframe name="CancelRequestHeaderFrame" id="CancelRequestHeaderFrame" frameborder="0" scrolling="no" noresize src="../../eST/jsp/CancelRequestHeader.jsp?<%=params%>" style="height:150%;width:100vw"></iframe><iframe name="CancelRequestListFrame" id="CancelRequestListFrame" src="../../eST/jsp/CancelRequestList.jsp?<%=params%>" frameborder="0" noresize scrolling="auto" style="height:100vh;width:100vw"></iframe>
<%
putObjectInBean(bean_id,bean,request);
%>
</html> 

