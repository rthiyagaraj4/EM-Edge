<!DOCTYPE html>
 <!--
Fine Tuning
-->
<HTML>
<HEAD>
	<%
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
 <link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>


	<SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<SCRIPT LANGUAGE="JavaScript" SRC="../js/PhCommon.js"></SCRIPT>
	<SCRIPT LANGUAGE="JavaScript" SRC="../js/DrugNameCommonLookup.js"></SCRIPT>
	<SCRIPT LANGUAGE="JavaScript" SRC="../js/DiscontinueDrug.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>

<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>

<iframe name="commontoolbarFrame" id="commontoolbarFrame" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="<%= source %>" style="height:8vh;width:100vw"></iframe><iframe name="f_query_add_mod" id="f_query_add_mod" FRAMEBORDER="0" SCROLLING="auto" NORESIZE SRC="../../eCommon/html/blank.html" style="height:83vh;width:100vw"></iframe><iframe name="messageFrame" id="messageFrame" SRC="../../eCommon/jsp/MstCodeError.jsp" FRAMEBORDER="0" NORESIZE SCROLLING="auto" style="height:9vh;width:100vw"></iframe>
</HTML>

