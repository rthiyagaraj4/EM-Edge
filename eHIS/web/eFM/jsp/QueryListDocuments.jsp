<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>

<html>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='/eHIS/common/html/ehis.css'></link> -->
	<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script src='../../eFM/js/QueryListDocuments.js' language='javascript'></script>
 <head>
<iframe name='commontoolbarFrame' id='commontoolbarFrame'      src='<%=source%>' scrolling='NO' frameborder=0  noresize style='height:8%;width:100vw'></iframe>
	<iframe name='searchFrame' id='searchFrame'       src='../../eFM/jsp/QueryListDocumentsCriteria.jsp'	scrolling='NO' frameborder=0 noresize style='height:18%;width:100vw'></iframe>
	<iframe name='resultFrame' id='resultFrame' src='../../eCommon/html/blank.html' frameborder=0 scrolling='NO' noresize style='height:100vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' scrolling='no' frameborder='0' noresize style='height:8%;width:100vw'></iframe>


