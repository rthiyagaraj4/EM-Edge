<!DOCTYPE html>
<!-- 
--------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------
?             100            ?           created
4/12/2013	  IN042552		 Karthi L	 To maintain Patient's event confidentiality at Practitioner, Speciality and Responsibility level (Bru-HIMS-CRF-391)
--------------------------------------------------------------------------------------------------------
-->

<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
<HEAD>
 <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
 <script src='../../eCommon/js/common.js' language='javascript'></script>
 <script src='../../eCA/js/ConfidentialitySetUpHeader.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>
		<iframe name="commontoolbarFrame" id="commontoolbarFrame" SRC='<%=source%>' FRAMEBORDER='0' NORESIZE SCROLLING="no" style='height:8vh;width:100vw'></iframe>
		<iframe name="CAConfidentialitySetUpHeaderFrame" id="CAConfidentialitySetUpHeaderFrame" SRC = "../../eCA/jsp/CAConfidentialitySetupHeader.jsp?<%=params%>" NORESIZE SCROLLING="no" style="height:13vh;width:100vw;border:none"></iframe>
		<iframe name="CAConfidentialitySearchQueryFrame" id="CAConfidentialitySearchQueryFrame" SRC = "../../eCA/jsp/blank.jsp" NORESIZE SCROLLING="auto" style='height:13vh; width:99vw; border:none;'></iframe>
		<iframe name="CAConfidentialitySearchResultFrame" id="CAConfidentialitySearchResultFrame" SRC = "../../eCA/jsp/blank.jsp" NORESIZE SCROLLING="auto" style='height:55vh; width:99vw;border:none;'></iframe>
		<iframe name='messageFrame' id='messageFrame' SRC='../../eCommon/jsp/MstCodeError.jsp' NORESIZE FRAMEBORDER='0' style='height:10vh;width:100vw'></iframe>
</HTML>

