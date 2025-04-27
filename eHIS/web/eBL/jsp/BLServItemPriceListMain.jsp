<!DOCTYPE html>
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<!--
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'</link>
	-->
	<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
    <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyleBL.css'></link>
	<script language='javascript' src='../js/BLServItemPriceList.js'></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script type="text/javascript" src="../js/BLServItemPriceListValidation.jsp"></script>
	

<%
		String params = request.getQueryString() ;
		System.out.println("params BL_ServItemPrice_List=" + params);
%>
<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src='../../eCommon/jsp/commonToolbar.jsp?<%=params %>'  frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
<iframe name='BL_ServItemPrice_List' id='BL_ServItemPrice_List' 	src='BLServItemPriceList.jsp?<%=params %>' frameborder=0 scrolling='no' noresize style='height:84vh;width:100vw'></iframe>
<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' scrolling='auto' frameborder=0 noresize style='height:8vh;width:100vw'></iframe>

