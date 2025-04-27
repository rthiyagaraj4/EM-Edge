<!DOCTYPE html>
<%@ page import=" ePO.STPOCancelRequestBean" contentType="text/html;charset=UTF-8"%>
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
	<script language="JavaScript" src="../../ePO/js/PoCommon.js"></script>
	<script language="JavaScript" src="../../ePO/js/PoTransaction.js"></script>
	<script language="JavaScript" src="../../ePO/js/STPOCancelRequest.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

    <script>
        function_id = "<%= request.getParameter("function_id")%>";
		menu_id		= "<%= request.getParameter( "menu_id" ) %>"
		module_id	= "<%= request.getParameter( "module_id" ) %>"
    </script>
</head>
<%
	request.setCharacterEncoding("UTF-8");
	String locale			    = (String)session.getAttribute("LOCALE");
	String params               = request.getQueryString();
	String bean_id              = "STpoCancelRequestBean";
	String bean_name            = "ePO.STPOCancelRequestBean";
	STPOCancelRequestBean bean  = (STPOCancelRequestBean) getBeanObject(bean_id,bean_name,request);  
	bean.setLanguageId(locale);
	bean.initialize();

	String req_code = request.getParameter("req_code");
	String req_no = request.getParameter("req_no");
	bean.loadData(req_code, req_no);
%>
<iframe name="STPOCancelRequestHeaderFrame" id="STPOCancelRequestHeaderFrame" frameborder="0" scrolling="no" noresize src="../../ePO/jsp/STPOCancelRequestHeader.jsp?<%=params%>" style="height:150%;width:100vw"></iframe><iframe name="STPOCancelRequestListFrame" id="STPOCancelRequestListFrame" src="../../ePO/jsp/STPOCancelRequestList.jsp?<%=params%>" frameborder="0" noresize scrolling="auto" style="height:100vh;width:100vw"></iframe>
<%
putObjectInBean(bean_id,bean,request);
%>
</html> 

