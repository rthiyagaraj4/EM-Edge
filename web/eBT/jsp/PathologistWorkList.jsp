<!DOCTYPE html>
<%
/*
Added by Niveditha For GHL-CRF-0602.1
*/
%>

<%@page import="java.util.*,java.sql.*,webbeans.eCommon.*, java.util.*,java.lang.*," contentType="text/html;charset=UTF-8" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%
request.setCharacterEncoding("UTF-8");

String cols = "";
String title = "";

%>
<head>
<title>
<%=title%>
</title>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/dchk.js' language='javascript'></SCRIPT>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script></head>

<iframe name="pathologistWorkListCriteriaFrame" id="pathologistWorkListCriteriaFrame" frameborder="0" scrolling="no" noresize src="../../eBT/jsp/PathologistWorkListCriteria.jsp" style="height:30vh;width:100vw"></iframe>
		<iframe name="pathologistWorkListResultFrame" id="pathologistWorkListResultFrame" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="../../eCommon/html/blank.html" style="height:80%;width:100vw"></iframe>


