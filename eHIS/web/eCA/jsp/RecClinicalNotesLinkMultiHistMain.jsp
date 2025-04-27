<!DOCTYPE html>
<%@ page import="webbeans.eCommon.*,java.sql.*, java.util.*, java.text.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<script language='javascript' src='../../eCA/js/RecClinicalNotesLinkMed.js'></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<title><fmt:message key="eCA.MyFilter.label" bundle="${ca_labels}"/></title>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

</head>
<iframe name="RecClinicalNotesLinkMultiHistCriteriaFrame" id="RecClinicalNotesLinkMultiHistCriteriaFrame" frameborder="0" scrolling="no" noresize src = "../../eCA/jsp/RecClinicalNotesLinkMultiHistCriteria.jsp?<%=request.getQueryString()%>"></iframe>
	<iframe name="RecClinicalNotesLinkMultiHistPrevNextFrame" id="RecClinicalNotesLinkMultiHistPrevNextFrame" frameborder="0" scrolling="no" noresize src = "../../eCommon/html/blank.html" ></iframe>
	<iframe name="RecClinicalNotesLinkMultiHistDetFrame" id="RecClinicalNotesLinkMultiHistDetFrame" frameborder="0" scrolling="yes" noresize src = "../../eCommon/html/blank.html" ></iframe>
	<iframe name="RecClinicalNotesLinkMultiHistToolbarFrame" id="RecClinicalNotesLinkMultiHistToolbarFrame" frameborder="0" scrolling="no" noresize src = "../../eCA/jsp/RecClinicalNotesLinkMultiHistToolbar.jsp?<%=request.getQueryString()%>"></iframe>
	<iframe name="messageFrame" id="messageFrame" frameborder="0" scrolling="no" noresize src = "../../eCommon/html/blank.html"></iframe>


</html>

