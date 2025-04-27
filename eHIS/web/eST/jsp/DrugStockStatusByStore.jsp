<!DOCTYPE html>
<%@ page import=" eST.DrugStockStatusByStoreBean"  	contentType="text/html;charset=UTF-8" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>

<head>
	<%
	request.setCharacterEncoding("UTF-8");
		
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' 
type='text/css' ></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../js/StCommon.js"></script>
	<script language="JavaScript" src="../js/DrugStockStatusByStore.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<%	String function_id    = (String)request.getParameter("function_id")==null?"":(String)request.getParameter("function_id");
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
	eST.BatchSearchBean bean = (eST.BatchSearchBean)getBeanObject( "batchSearchBean",  "eST.BatchSearchBean" ,request);
	bean.setFunctionId(function_id);
	bean.clear();
%>

<iframe name="commontoolbarFrame" id="commontoolbarFrame" frameborder="0" scrolling="no" noresize src="<%= source %>" style="height:8vh;width:100vw"></iframe><iframe name="f_query_add_mod" id="f_query_add_mod" frameborder="0" scrolling="no" noresize src="../../eST/jsp/DrugStockStatusByStoreFrameset.jsp" style="height:100vh;width:100vw"></iframe><iframe name="messageFrame" id="messageFrame" src="../../eCommon/jsp/error.jsp" frameborder="0" noresize scrolling="auto" style="height:50%;width:100vw"></iframe>

</html>

 

