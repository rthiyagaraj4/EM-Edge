<!DOCTYPE html>
<%@ page session="true" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eFM/js/QueryFolderWiseDocuments.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	StringBuffer sourceBuffer	= new StringBuffer();	
	String url					= "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params				= request.getQueryString() ;
	sourceBuffer.append(url);
	sourceBuffer.append(params);
%>
 <iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=sourceBuffer.toString()%>' frameborder='0' scrolling=no noresize style='height:8%;width:100vw'></iframe>
	<iframe name='criteria_frame' id='criteria_frame' src='../../eFM/jsp/QueryFolderWiseDocumentsCriteria.jsp' frameborder=0 scrolling='no' noresize style='height:9%;width:100vw'></iframe>
	<iframe name='result_frame' id='result_frame' src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:100vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' scrolling='auto' frameborder='0' noresize style='height:9%;width:100vw'></iframe>
 
</html>


