<!DOCTYPE html>
<%
/* 
--------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------
26/10/2020	IN067210		SIVABAGYAM M	26/10/2020	RAMESH G	ML-MMOH-CRF-1144
--------------------------------------------------------------------------------------------------------
*/
%>

<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
<HEAD>
 <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
 <script src='../../eCommon/js/common.js' language='javascript'></script>
 <script src='../../eCA/js/CARoleBasedAccessRightsforTaskList.js' language='javascript'></script>
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
<iframe name="CARoleBasedAccessRightsforTaskListFrame" id="CARoleBasedAccessRightsforTaskListFrame" SRC = "../../eCA/jsp/CARoleBasedAccessRightsforTaskList.jsp?<%=params%>" NORESIZE SCROLLING="auto" style="height:82vh;width:100vw"></iframe>
<iframe name='messageFrame' id='messageFrame' SRC='../../eCommon/jsp/MstCodeError.jsp' NORESIZE FRAMEBORDER='0' style='height:10vh;width:100vw'></iframe>
</HTML>

