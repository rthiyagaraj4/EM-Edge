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
	<script language="JavaScript" src="../js/ComputeStockLevelsStores.js"></script>
	<!--  <script language='javascript' src='../../eST/js/MonthlySummaryReport.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
  -->
</head>
<iframe name="frameComputeStockLevelsStoresCriteria" id="frameComputeStockLevelsStoresCriteria" frameborder="0" scrolling="no" noresize src="../../eST/jsp/ComputeStockLevelsStoresCriteria.jsp?<%=request.getQueryString()%>" style="height:31vh;width:100vw"></iframe><iframe name="frameComputeStockLevelsStoresResult" id="frameComputeStockLevelsStoresResult" src="../../eCommon/html/blank.html" frameborder="0" noresize scrolling="auto" style="height:69vh;width:100vw"></iframe>
</html>


