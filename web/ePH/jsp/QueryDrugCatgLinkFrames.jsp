<!DOCTYPE html>
	 <!--This file is saved on 28/10/2005-->
<%@page contentType="text/html;charset=UTF-8"%>
<HTML>
<HEAD>
	<!-- <LINK REL="stylesheet" TYPE="text/css" HREF="../../eCommon/html/IeStyle.css"></LINK> -->
	
	<SCRIPT LANGUAGE="javascript" SRC="../js/PhCommon.js"></script>
 	<SCRIPT LANGUAGE="javascript" SRC="../js/QueryDrugCatgLink.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../js/DrugDetailsDisplay.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>

<%
	String source = "../../ePH/jsp/QueryDrugCatgLinkCriteria.jsp" ;
%>

<iframe name="f_query_criteria" id="f_query_criteria" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="<%= source %>" style="height:10vh;width:100vw"></iframe><iframe name="f_query_result" id="f_query_result" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="../../eCommon/html/blank.html" style="height:90vh;width:99vw"></iframe>
</HTML>

