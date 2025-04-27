<!DOCTYPE html>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<!-- 	<link rel="stylesheet"type="text/css" href="../../eCommon/htm l/IeStyle.css"></link> --><%
		request.setCharacterEncoding("UTF-8");
		
		String sStyle		=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../js/StCommon.js"></script>
<!-- 	<script language="JavaScript" src="../js/StMessages.js"></script> -->
		<script language="JavaScript" src="../js/ComputeStockLevels.js"></script>
		<script language='javascript' src='../../eST/js/MonthlySummaryReport.js'></script> 
<!-- 	<script language="javascript" src="../../eMM/js/MmMessages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->

</head>

<iframe name="frameComputeStockLevelsCriteria" id="frameComputeStockLevelsCriteria" frameborder="0" scrolling="no" noresize src="../../eST/jsp/ComputeStockLevelsCriteria.jsp?<%=request.getQueryString()%>" style="height:25vh;width:100vw"></iframe>
<iframe name="frameComputeStockLevelsResult" id="frameComputeStockLevelsResult" src="../../eCommon/html/blank.html" frameborder="0" noresize scrolling="auto" style="height:75vh;width:100vw"></iframe>
</html>



