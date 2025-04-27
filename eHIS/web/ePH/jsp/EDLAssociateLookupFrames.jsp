<!DOCTYPE html>
 
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="ePH.*, ePH.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>
<html>
<head>

<% 
	request.setCharacterEncoding("UTF-8");
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?
(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 
String strEDLCodes = request.getParameter("EDLCodes")==null?"":request.getParameter("EDLCodes");
String strSource= "EDLAssociateLookupDetails.jsp?EDLCodes="+strEDLCodes;
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>
	
	<script language="JavaScript" SRC="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../ePH/js/PhCommon.js"></script>
	<script language="JavaScript" src="../../ePH/js/EDL.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<title><fmt:message key="ePH.EDLCLASSIFICATION.label" bundle="${ph_labels}"/></title>
</head>


<iframe name="EDLLookUpDetailsFrame" id="EDLLookUpDetailsFrame" frameborder="0" scrolling="yes" noresize src="<%=strSource%>" style="height:90vh;width:99vw"></iframe>
<iframe name="EDLLookUpButtonsFrame" id="EDLLookUpButtonsFrame" frameborder="0" scrolling="no" noresize src="EDLAssociateLookupButtons.jsp" style="height:8vh;width:99vw"></iframe>

</html> 

