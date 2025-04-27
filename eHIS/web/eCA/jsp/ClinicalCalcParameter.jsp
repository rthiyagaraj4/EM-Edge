<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
<HEAD>
<script src='../../eCA/js/ClinicalCalcParameter.js' language='javascript'></script>
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
<FRAMESET ROWS="10%,30%,*,10%"	border=0  >
    <frame name='commontoolbarFrame' id='commontoolbarFrame'	src='<%=source%>' frameborder=0 scrolling='no' noresize>
	
	<FRAME name="ClinicalCalcSelectFrame" id="ClinicalCalcSelectFrame" SRC = "../../eCA/jsp/ClinicalCalcSelectFormula.jsp?<%=request.getQueryString()%>" noresize scrolling="auto">
	<FRAME name="ClinicalCalcSelectedFrame" id="ClinicalCalcSelectedFrame" SRC = "../../eCommon/html/blank.html" noresize scrolling="auto">
	<!--<FRAME name="ClinicalCalcSelectedFrame" id="ClinicalCalcSelectedFrame" SRC = "../../eCA/jsp/ClinicalCalcSelectedFormulaList.jsp?<%=request.getQueryString()%>" noresize scrolling="auto">-->
	<frame src='../../eCommon/jsp/MstCodeError.jsp' name='messageFrame' id='messageFrame' noresize frameborder=0>
</FRAMESET>
</HTML>

