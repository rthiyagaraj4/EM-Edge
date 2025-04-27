<!DOCTYPE html>
<%
/* 
---------------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History      		Name        		Rev.Date				Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------

----------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, eCA.*, eCA.Common.*, eCommon.Common.*,java.text.DecimalFormat,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<title>External Notes Display</title>
	<head>
	<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	 %>
		<iframe name="frame0" id="frame0" frameborder="0" scrolling="yes" noresize src="../../eCA/jsp/CAExternalDisplayNotes.jsp?<%=request.getQueryString()%>" style="height:100vh;width:100vw"></iframe><iframe name="frame1" id="frame1" frameborder="0" scrolling="no" noresize src="../../eCA/jsp/CAExternalDisplayNotesToolbar.jsp" style="height:5%;width:100vw"></iframe>		
</html>

