<!DOCTYPE html>
 <%@ page import=" eST.SalesAndReturnHistoryBean"  	contentType="text/html;charset=UTF-8" %>
 <%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String locale			= (String)session.getAttribute("LOCALE");
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eST/js/SalesAndReturnHistory.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

   
</head>
<title><fmt:message key="eST.Sales/ReturnHistory.label" bundle="${st_labels}"/> </title>
<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
	String bean_id				=		"SalesAndReturnHistoryBean";
	String bean_name			=		"eST.SalesAndReturnHistoryBean";
	SalesAndReturnHistoryBean bean		=	(SalesAndReturnHistoryBean) getBeanObject(bean_id, bean_name,request  );  
	bean.setLanguageId(locale);
	
%>
<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src="<%= source %>" frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' frameborder="0" scrolling="no" noresize src="../../eST/jsp/SalesAndReturnHistoryFrameset.jsp" style='height:82vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:10vh;width:100vw'></iframe>
</html>

