<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>
<HTML>

<HEAD>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
    <TITLE><fmt:message key="Common.Image.label" bundle="${common_labels}"/></TITLE>
</HEAD>
	<iframe src="../../eOH/jsp/MedPntredit.jsp?<%=request.getQueryString()%>" frameborder=0  marginheight=0 marginwidth=0 SCROLLING="auto" name="criteriaPainterFrame" NORESIZE style="height:100vh;width:100vw"></iframe>
      	    <iframe src="../../eOH/jsp/ResultEntryDrawingToolButton.jsp?<%=request.getQueryString()%>" frameborder=0  marginheight=0 marginwidth=0 SCROLLING="no"  name="criteriaButtonFrame" NORESIZE style="height:5%;width:100vw"></iframe>
	
</HTML>

