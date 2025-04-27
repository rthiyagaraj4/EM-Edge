<!DOCTYPE html>
<!--
--------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------------
?             100            ?           created
21/05/2013    IN037756.1      Chowminya G  Can we default the “Requested Facility” to the log in Facility of the user  instead of “All" 
--------------------------------------------------------------------------------------------------------------------
-->
<%@page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<title><fmt:message key="eCA.ReviewNotes.label" bundle="${ca_labels}"/></title>
	
	<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

		Properties p = (Properties)session.getValue("jdbc");
		String locale				= (String) p.getProperty("LOCALE");
		String toDate = "";
		String frDate = "";
		toDate	= com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
		frDate	= com.ehis.util.DateUtils.minusDate(toDate,"DMY",locale,1,"M");
		String	facilityid	=	(String)	session.getValue("facility_id");//IN037756.1

	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>

</head>
 <!-- <frameset rows="19%,*,6%" frameborder=0 class="<%=request.getParameter("cname")%>">
	<frame src="../../eCA/jsp/ReviewNotesCriteria.jsp?<%=request.getQueryString()%>" name="ReviewNotesCriteriaFrame" id="ReviewNotesCriteriaFrame" border=0 scrolling=no noresize> 
	<frameset cols="200px,*" frameborder=0 >
		<frame src="../../eCA/jsp/ReviewNotesTree.jsp?<%=request.getQueryString()%>&fromDate=<%=frDate%>&ToDate=<%=toDate%>&reqFacility=<%=facilityid%>" name="ReviewotesTreeFrame" id="ReviewotesTreeFrame" border=0 scrolling=auto noresize>
		<frame src="../../eCA/jsp/ReviewNotesDetails.jsp?<%=request.getQueryString()%>&fromDate=<%=frDate%>&ToDate=<%=toDate%>&reqFacility=<%=facilityid%>" id="ReviewNotesDetailsFrame" name="ReviewNotesDetailsFrame" border=0 scrolling=auto noresize>
	</frameset>
	<frame src="../../eCA/jsp/ReviewNotesTools.jsp" name="ReviewNotesToolsFrame" id="ReviewNotesToolsFrame" border=0 scrolling=no noresize>
</frameset> -->
  	<iframe src="../../eCA/jsp/ReviewNotesCriteria.jsp?<%=request.getQueryString()%>" name="ReviewNotesCriteriaFrame" id="ReviewNotesCriteriaFrame" border=0 scrolling=no noresize style='height:20vh;width:99vw' frameborder=0></iframe>
	<iframe src="../../eCA/jsp/ReviewNotesTree.jsp?<%=request.getQueryString()%>&fromDate=<%=frDate%>&ToDate=<%=toDate%>&reqFacility=<%=facilityid%>" name="ReviewotesTreeFrame" id="ReviewotesTreeFrame" border=0 scrolling=auto noresize frameborder=0 style='height:34vh;width:21vw' align='left'></iframe>
	<iframe src="../../eCA/jsp/ReviewNotesDetails.jsp?<%=request.getQueryString()%>&fromDate=<%=frDate%>&ToDate=<%=toDate%>&reqFacility=<%=facilityid%>" name="ReviewNotesDetailsFrame" id="ReviewNotesDetailsFrame" border=0 scrolling=auto noresize frameborder=0 style='height:69vh;width:77vw' align='right'></iframe>
	<iframe src="../../eCA/jsp/ReviewNotesTools.jsp" name="ReviewNotesToolsFrame" id="ReviewNotesToolsFrame" border=0 scrolling=no noresize style='height:10vh;width:100vw' frameborder=0></iframe>

</html>
