<!DOCTYPE html>
<!-- 
--------------------------------------------------------------------------------------------------------------------
Date		Edit History		Name		Description
--------------------------------------------------------------------------------------------------------------------
?             	100            		?		created
11/10/2013    IN043916		Karthi L		Alpha-CA>Summary Menu>Incorrect count is displayed in 'Pending Signatures' and 'Pending cosign' menu's	
--------------------------------------------------------------------------------------------------------------------
-->
<%@page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<title><fmt:message key="eCA.SignNotes.label" bundle="${ca_labels}"/></title>

	<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		Properties p = (Properties)session.getValue("jdbc");
		String locale				= (String) p.getProperty("LOCALE");
		String dateRange =request.getParameter("dateRange")==null?"":request.getParameter("dateRange");
		String option_id =request.getParameter("option_id")==null?"":request.getParameter("option_id");
		String toDate = "";
		String frDate = "";
		toDate	= com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
		//if (!dateRange.equals("N")){		// Commented for 43916		
			frDate	= com.ehis.util.DateUtils.minusDate(toDate,"DMY",locale,1,"M");
		//} // Commented for 43916	
		
		
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script src="../../eCommon/js/common.js" language="javascript"></script>

</head>
<frameset rows="13%,*,6%" frameborder=0 class="<%=request.getParameter("cname")%>">
	<frame src="../../eCA/jsp/SignNotesCriteria.jsp?<%=request.getQueryString()%>" name="SignNotesCriteriaFrame" border=0 scrolling=no noresize>
	<frameset cols="20%,*" frameborder=0 >
		<frame src="../../eCA/jsp/SignNotesTree.jsp?<%=request.getQueryString()%>&fromDate=<%=frDate%>&ToDate=<%=toDate%>&option_id=<%=option_id%>" name="SignNotesTreeFrame" border=0 scrolling=auto noresize>
		<frame src="../../eCA/jsp/SignNotesDetails.jsp?<%=request.getQueryString()%>&fromDate=<%=frDate%>&ToDate=<%=toDate%>&option_id=<%=option_id%>" name="SignNotesDetailsFrame" border=0 scrolling=auto noresize>
	</frameset>
	<frame src="../../eCA/jsp/SignNotesTools.jsp?<%=request.getQueryString()%>" name="SignNotesToolsFrame" border=0 scrolling=no noresize>
</frameset>
</html>
