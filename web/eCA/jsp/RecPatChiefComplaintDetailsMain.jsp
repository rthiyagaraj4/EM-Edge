<!DOCTYPE html>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String qrystr = request.getQueryString();
//	String complaint_desc = request.getParameter("complaint_desc");
%>
<title><fmt:message key="eCA.ComplaintDetails.label" bundle="${ca_labels}"/></title>
<head>
<script src='../../eCA/js/RecPatChiefComplaint.js' language='javascript'></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%

%>
</head>
<iframe name="RecPatChiefComplaintDetailsResultFrame" id="RecPatChiefComplaintDetailsResultFrame" src='../../eCA/jsp/RecPatChiefComplaintDetailsResult.jsp?<%=qrystr%>' frameborder=0 scrolling="no" noresize style='height:91vh;width:100vw'></iframe>
	<iframe name="RecPatChiefComplaintDetailsCloseFrame" id="RecPatChiefComplaintDetailsCloseFrame" src='../../eCA/jsp/RecPatChiefComplaintDetailsClose.jsp?<%=qrystr%>' frameborder=0 scrolling="no" noresize style='height:7vh;width:100vw'></iframe>

</html>

