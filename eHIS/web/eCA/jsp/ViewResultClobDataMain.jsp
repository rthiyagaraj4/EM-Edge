<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Description
--------------------------------------------------------------------------------------------------------------------
11/06/2013    IN039414      Ramesh G		Result Widget->Click on Result Hyperlink->Click on any Lab results->HTML tags displayed in Result									
--------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<html>
<title><fmt:message key="Common.EventDetails.label" bundle="${common_labels}"/></title>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<iframe src="../../eCA/jsp/ViewResultClobData.jsp?<%=request.getQueryString()%>" name="ViewResultClobDataFrame"  scrolling="auto" frameborder="0" marginheight=0 marginwidth=0 style="height:90%;width:100vw"></iframe><iframe src="../../eCA/jsp/ViewResultClobDataButtons.jsp" name="ViewResultClobDataButtonsFrame" id="ViewResultClobDataButtonsFrame"  scrolling="auto" frameborder="0" marginheight=0 marginwidth=0 style="height:100vh;width:100vw"></iframe>
</html>

