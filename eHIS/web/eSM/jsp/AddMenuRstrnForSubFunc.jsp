<!DOCTYPE html>
<%@ page import="java.sql.*, java.net.*, java.util.*, eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<title><fmt:message key="eSM.MenuRestrictforResponsSubFunction.label" bundle="${sm_labels}"/> </title>
<head>
	<%
        String sStyle	=
       (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
    request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
    String Step =  request.getParameter("Step");
	String ModuleID = request.getParameter("ModuleID");
	String MenuID = request.getParameter("MenuID");
	String OptionSequenceNo = request.getParameter("OptionSequenceNo");
	String FunctionID = request.getParameter("FunctionID");
	String FunctionVal = request.getParameter("FunctionVal");
	String SubFunctionValues = request.getParameter("SubFunctionValues");
	String Resp_id = request.getParameter("Resp_id");
%>
<iframe name='f_query_add_mod' id='f_query_add_mod' src="../../eSM/jsp/AddMenuRstrnForSubFuncResult.jsp?Step=<%=Step%>&MenuID=<%=MenuID%>&ModuleID=<%=ModuleID%>&OptionSequenceNo=<%=OptionSequenceNo%>&FunctionID=<%=FunctionID%>&FunctionVal=<%=FunctionVal%>&SubFunctionValues=<%=SubFunctionValues%>&Resp_id=<%=Resp_id%>" frameborder='0' scrolling='auto' noresize style='height:96vh;width:100vw'></iframe>
	<iframe name='f_query_close' id='f_query_close' src='../../eSM/jsp/AddMenuRstrnForSubFuncClose.jsp' frameborder='0' scrolling='no' noresize style='height:4vh;width:100vw'></iframe>

</html>

