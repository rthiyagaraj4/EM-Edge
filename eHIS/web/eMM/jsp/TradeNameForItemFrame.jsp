<!DOCTYPE html>
<%@ page import="webbeans.eCommon.*,java.sql.*, java.util.*, java.text.*,eMM.*" contentType="text/html;charset=UTF-8"%>
<jsp:useBean id="obj"   scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="alTradeNameForItemList" scope="session" class="java.util.ArrayList"/>

<%
	alTradeNameForItemList =  new ArrayList();
%>
 
<html>
<head>
<!-- 	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link>
 --><%
		request.setCharacterEncoding("UTF-8");
//		String locale			= (String)session.getAttribute("LOCALE");
		//locale ="en";
//		String primary_lang		= (String)session.getAttribute("PRIMARY_LANG");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
</head>
<iframe name='frameTradeNameForItemHeader' id='frameTradeNameForItemHeader'  src='../../eMM/jsp/TradeNameForItemHeader.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling='no' noresize style='height:20vh;width:100vw'></iframe>
<iframe name='frameTradeNameForItemAddModify' id='frameTradeNameForItemAddModify' frameborder="0" scrolling="auto" noresize src="../../eMM/jsp/TradeNameForItemAddModify.jsp?<%=request.getQueryString()%>" style='height:60vh;width:100vw'></iframe>
<iframe name='frameTradeNameForItemDetail' id='frameTradeNameForItemDetail' frameborder="0" scrolling="no" noresize src="../../eCommon/html/blank.html" style='height:20vh;width:100vw'></iframe>
</html>

