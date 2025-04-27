<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        		Rev.Date		Rev.Name 		Description
--------------------------------------------------------------------------------------------------------
08/05/2019		IN69027			Ramesh G			?				?				MMS-DM-CRF-0150
--------------------------------------------------------------------------------------------------------
*/
%>
<%@ page  import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<HEAD>
<iframe SRC="../../eOR/jsp/MDSForDiagnosisMandatoryHdr.jsp?<%=request.getQueryString()%>" NAME="MDSForDiagnosisMandatoryHdr" scrolling='no' noresize  style='height:15vh;width:100vw'></iframe>
<iframe SRC="../../eCommon/html/blank.html" name="MDSForDiagnosisMandatoryResult" id="MDSForDiagnosisMandatoryResult"  scrolling='yes' noresize  style='height:85vh;width:100vw'></iframe>

</HTML>

