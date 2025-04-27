<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
<HEAD>
<script src='../../eCA/js/ClinicalRepMast.js' language='javascript'></script>
 <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
 <script src='../../eCommon/js/common.js' language='javascript'></script>
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

    <iframe name='commontoolbarFrame' id='commontoolbarFrame'	src='<%=source%>' frameborder='0' scrolling='no' noresize style="height:7vh;width:100vw"></iframe>
	<IFRAME SRC = "../../eCommon/html/blank.html" name="ClinicalRepMastMainFrame" id="ClinicalRepMastMainFrame" noresize style="height:0vh;width:100vw; border-left-width: 0px;border-right-width: 0px;border-bottom-width: 0px;border-top-width: 0px;"></iframe>
	<!--<FRAME SRC = "../../eCA/jsp/ClinicalRepMastMainTab.jsp?<%=request.getQueryString()%>" NAME="ClinicalRepMastMainFrame" noresize> -->
	<IFRAME SRC = "../../eCommon/html/blank.html" name="ClinicalRepMastSubFrame" id="ClinicalRepMastSubFrame"  scrolling="no" style="height:0vh;width:100vw; border-left-width: 0px;border-right-width: 0px;border-bottom-width: 0px;border-top-width: 0px;"></iframe>
	<!--<FRAME  SRC = "../../eCA/jsp/ClinicalRepMastSubTab.jsp?<%=request.getQueryString()%>" NAME="ClinicalRepMastSubFrame"  scrolling="no"> -->
	<IFRAME name="ClinicalRepMastMainEventFrame" id="ClinicalRepMastMainEventFrame" SRC = "../../eCA/jsp/ClinicalRepMastBatchEventMain.jsp?<%=request.getQueryString()%>" noresize scrolling="no" style="height:10vh;width:100vw; border-left-width: 0px;border-right-width: 0px;border-bottom-width: 0px;border-top-width: 0px;"></iframe>
	<IFRAME name="ClinicalRepMastAssociateFrame" id="ClinicalRepMastAssociateFrame" noresize scrolling="auto" style="height:69vh;width:100vw; border-left-width: 0px;border-right-width: 0px;border-bottom-width: 0px;border-top-width: 0px;"></iframe>
	<iframe src='../../eCommon/jsp/MstCodeError.jsp' name='messageFrame' id='messageFrame' noresize frameborder=0 style="height:7vh;width:100vw; border-left-width: 0px;border-right-width: 0px;border-bottom-width: 0px;border-top-width: 0px;"></iframe>

</HTML>

