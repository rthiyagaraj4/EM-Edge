<!DOCTYPE html>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<%
 request.setCharacterEncoding("UTF-8"); 

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 

     <script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	 <script language="JavaScript" src="../../eCommon/js/common.js"></script>
 	<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
	<script language="JavaScript" src="../../eST/js/StTransaction.js"></script>
	<script language="JavaScript" src="../../eST/js/CondemnExpiredBatches.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

    <script>
        function_id = "<%= request.getParameter("function_id")%>";
		menu_id		= "<%= request.getParameter( "menu_id" ) %>"
		module_id	= "<%= request.getParameter( "module_id" ) %>"
    </script>
</head>
<%

	String params = request.getQueryString();
%>
<iframe name="CondemnExpiredBatchesQueryHeader" id="CondemnExpiredBatchesQueryHeader" frameborder="0" scrolling="no" noresize src="../../eST/jsp/CondemnExpiredBatchesQueryCriteria.jsp?<%=params%>" style="height:20vh;width:100vw"></iframe>
<iframe name="CondemnExpiredBatchesQueryResult" id="CondemnExpiredBatchesQueryResult" frameborder="0" src="../../eCommon/html/blank.html" scrolling="auto"  style="height:80vh;width:100vw"></iframe>
</html>

