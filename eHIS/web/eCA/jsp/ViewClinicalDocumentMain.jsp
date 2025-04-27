<!DOCTYPE html>
<!--
		Author	: Arvind Singh Pal
		Purpose : Created For GHL-CRF-0043 
		Date		: 16 November 2009

		-->

<%@page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
		

<TITLE><fmt:message key="eCA.ViewClinicalDocuments.label" bundle="${ca_labels}"/></TITLE>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String url = "../../eCA/jsp/ViewClinicalDocumentCriteria.jsp?" ;
		String params = request.getQueryString() ;		
		String source = url + params ;		

		%>
<iframe src='<%=source%>' name="ViewCriteria" id="ViewCriteria" scrolling="auto" frameborder="0" style='height:30vh;width:99vw'></iframe>
<iframe src="../../eCommon/html/blank.html" name="ViewResult" id="ViewResult"  scrolling="auto" frameborder="0" style="height:62vh;width:99vw"></iframe>
<iframe name='pagination' id='pagination' src='../../eCA/jsp/ViewClinicalDocumentPagination.jsp' noresize  frameborder=no marginheight=0 marginwidth=0 style='height:0vh;width:99vw'></iframe>
<iframe name='messageFrameReference' id='messageFrameReference' src='../../eCommon/html/blank.html' noresize  frameborder=no marginheight=0 marginwidth=0 style='height:0vh;width:99vw'></iframe>
</html>

