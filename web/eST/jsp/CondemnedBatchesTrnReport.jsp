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
      <script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../js/StCommon.js"></script>
	<script language="JavaScript" src="../js/CondemnedBatchesTrnReport.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	 <script>
        function_id = "<%= request.getParameter( "function_id" ) %>"
    </script>
</head>
<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
//	String facilityid=(String)session.getValue("facility_id");
%>
<title><fmt:message key="eST.ReportOfTransferredBatches.label" bundle="${st_labels}"/></title>
<iframe name="commontoolbarFrame" id="commontoolbarFrame" frameborder="0" scrolling="no" noresize src="<%= source %>" style="height:8vh;width:100vw"></iframe><iframe name="f_query_add_mod" id="f_query_add_mod" frameborder="0" scrolling="no" noresize src="../../eST/jsp/CondemnedBatchesTrnReportCriteria.jsp" style="height:82vh;width:100vw"></iframe><iframe name="messageFrame" id="messageFrame" src="../../eCommon/jsp/error.jsp" frameborder="0" noresize scrolling="auto" style="height:10vh;width:100vw"></iframe>
</html>

