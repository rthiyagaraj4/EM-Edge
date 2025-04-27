<!DOCTYPE html>

<!--
Fine Tuning
-->
<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
	String locale = (String) session.getAttribute("LOCALE");
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE")
			: "IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'
	type='text/css'></link>


<script language="JavaScript" src="../js/PhCommon.js"></script>
<script language="JavaScript" src="../js/PresRemarkForDrug.js"></script>
<script language="JavaScript"
	src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
<!-- <SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/MstCodeCommon.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
</head>
<%
	String url = "../../eCommon/jsp/MstCodeToolbar.jsp?";
	String params = request.getQueryString();
	String source = url + params;
%>
<script>
	   toolBarString = "<%=params%>"
</script>

<iframe name="commontoolbarFrame" id="commontoolbarFrame" frameborder="0" scrolling="no"
		noresize src="<%= source %>" style="height:8vh;width:100vw"></iframe><iframe name="f_query_add_mod" id="f_query_add_mod" frameborder="0" scrolling="no" noresize
		src="../../eCommon/html/blank.html" style="height:84vh;width:100vw"></iframe><iframe name="messageFrame" id="messageFrame" src="../../eCommon/jsp/MstCodeError.jsp"
		frameborder="0" noresize scrolling="auto" style="height:8vh;width:100vw"></iframe>
</html>

