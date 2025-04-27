<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../js/StCommon.js"></script>
	<script language="JavaScript" src="../js/StockStatusByStore.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<iframe name="criteria" id="criteria" frameborder="0" scrolling="no" noresize src="../../eST/jsp/CancelCountSheetQueryCriteria.jsp" style="height:20vh;width:100vw"></iframe>
<iframe name="result" id="result" src="../../eCommon/html/blank.html" frameborder="0" noresize scrolling="auto" style="height:75vh;width:100vw"></iframe>
<iframe name="colorIndicators" id="colorIndicators" src="../../eST/jsp/CancelCountSheetColorIndicators.jsp" frameborder="0" noresize scrolling="no" style="height:5vh;width:100vw"></iframe>
</html>


