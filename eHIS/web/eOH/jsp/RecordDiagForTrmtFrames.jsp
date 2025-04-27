<!DOCTYPE html>
<%@ page contentType=" text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<html>
	<head>
		<script src="../../eOH/js/RecordDiagForTrmt.js" language="javascript"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	</head>
	<%
		String params = request.getQueryString() ;
	%>
	<!-- <frameset rows='7%,35%,1%,7%,*,0'> -->
	<!-- <frameset rows='8%,35%,1%,8%,*,0,4%,15%,4%'> -->
	<frameset rows='12%,30%,*,35%,0%,0%,4%'>
		<frame name='RecordDiagHeaderTitle' id='RecordDiagHeaderTitle'	src='../../eOH/jsp/RecordDiagForTrmtHeaderTitle.jsp?<%=params%>' frameborder=0  noresize>
		<frame name='RecordDiagHeader' id='RecordDiagHeader'	src='../../eOH/jsp/RecordDiagForTrmtHeader.jsp?<%=params%>' frameborder=0>
		<!-- <frame name='blank' id='blank'	src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling="no">  -->
		<!-- <frame name='RecordDiagDetailTitle' id='RecordDiagDetailTitle' src='../../eOH/jsp/RecordDiagForTrmtTitle.jsp?<%=params%>' frameborder=0> -->
		<frame name='RecordDiagDetail' id='RecordDiagDetail' src='../../eOH/jsp/RecordDiagForTrmt.jsp?<%=params%>' frameborder=0 noresize scrolling="auto">
		<frame name='RecordDiagLinkedCondition' id='RecordDiagLinkedCondition' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling="auto">
		<frame name='hidden_frame' id='hidden_frame' src='../../eOH/jsp/CommonMasterObjectCollect.jsp' frameborder="0" noresize>
		<frame name='close_hash_frame' id='close_hash_frame' src='../../eOH/jsp/CommonMasterObjectCollect.jsp' frameborder="0" noresize>
		<!-- <frame name='linkConditionTitle' id='linkConditionTitle' src='../../eOH/jsp/LinkConditionForTrmtTitle.jsp?<%=params%>' frameborder=0>
		<frame name='linkconditionDetail' id='linkconditionDetail' src='../../eOH/jsp/LinkConditionForTrmt.jsp?<%=params%>' frameborder=0> -->
		<frame name='recordFrame' id='recordFrame' src='../../eOH/jsp/RecordDiagLinkCondition.jsp?<%=params%>' frameborder=0>
	</frameset>
</html>

