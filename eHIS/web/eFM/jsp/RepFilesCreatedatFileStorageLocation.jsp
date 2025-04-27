<!DOCTYPE html>
<!--
	Created on   	   :	11/4/2009 For AK-CRF-0006
	 Module Name 	   :	FM\Reports Files Created at FilesStorageLocation .
-->
<%@ page contentType="text/html; charset=UTF-8" %>
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
		<script language='javascript' src='../../eFM/js/checkSystemDate.js'></script>	
		<script language='javascript' src='../../eFM/js/FilesCreatedatFileStorageLocation.js'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/dchk.js' language='javascript'></script>
		<script src="../../eCommon/js/common.js"></script>
		<script src="../../eCommon/js/DateUtils.js"></script>

 </head>

<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;	
	String function_id		= "";
	function_id = request.getParameter("function_id");
%>


<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>' scrolling='NO' frameborder='0'  noresize style='height:9vh;width:100vw'></iframe>
	<iframe name='Add_Modify_Frame' id='Add_Modify_Frame' src='../../eFM/jsp/FMFilesCreatedatFileStorageLocation.jsp?function_id=<%=function_id%>'	scrolling='NO' frameborder=0 noresize style='height:83vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' scrolling='NO' frameborder='0' noresize style='height:9vh;width:100vw'></iframe>


