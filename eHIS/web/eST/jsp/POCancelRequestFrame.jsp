<!DOCTYPE html>
<%@ page import=" eST.POCancelRequestBean" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
	<script language="JavaScript" src="../../eST/js/StTransaction.js"></script>
	<script language="JavaScript" src="../../eST/js/POCancelRequest.js"></script>
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
	String bean_id = "poCancelRequestBean";
	String bean_name = "eST.POCancelRequestBean";
	POCancelRequestBean bean = (POCancelRequestBean) getBeanObject(bean_id,bean_name,request);  
	bean.setLanguageId(locale);
	bean.initialize();

	String doc_type_code = request.getParameter("doc_type_code");
	String doc_no = request.getParameter("doc_no");
	bean.loadData(doc_type_code, doc_no);
%>
<iframe name="POCancelRequestHeaderFrame" id="POCancelRequestHeaderFrame" frameborder="0" scrolling="no" noresize src="../../eST/jsp/POCancelRequestHeader.jsp?<%=params%>" style="height:150%;width:100vw"></iframe><iframe name="POCancelRequestListFrame" id="POCancelRequestListFrame" src="../../eST/jsp/POCancelRequestList.jsp?<%=params%>" frameborder="0" noresize scrolling="auto" style="height:100vh;width:100vw"></iframe>
<%
putObjectInBean(bean_id,bean,request);
%>
</html> 

