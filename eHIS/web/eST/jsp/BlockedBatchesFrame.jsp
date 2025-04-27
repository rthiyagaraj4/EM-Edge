<!DOCTYPE html>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<!-- 	<link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link>
 -->	
 <%
		request.setCharacterEncoding("UTF-8");
		
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
 <script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../js/StCommon.js"></script>
<!-- 	<script language="JavaScript" src="../js/StMessages.js"></script> -->
	<script language="JavaScript" src="../js/BlockedBatches.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<iframe name="frameBlockedBatchesQueryCriteria" id="frameBlockedBatchesQueryCriteria" frameborder="0" scrolling="no" noresize src="../../eST/jsp/BlockedBatchesQueryCriteria.jsp" style="height:15vh;width:100vw"></iframe><iframe name="frameBlockedBatchesQueryResult" id="frameBlockedBatchesQueryResult" src="../../eCommon/html/blank.html" frameborder="0" noresize scrolling="auto" style="height:85vh;width:100vw"></iframe>
</html>


