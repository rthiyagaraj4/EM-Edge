<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<title>
<fmt:message key="Common.Instrument.label" bundle="${common_labels}"/>
<fmt:message key="Common.Image.label" bundle="${common_labels}"/>
</title>
<iframe name='f_query_add' id='f_query_add'	src="../../eOT/jsp/OTInstrumentImage.jsp?<%=request.getQueryString()%>"
	  noresize scrolling='auto' style='height:92vh;width:100vw'></iframe><iframe name='group_close' id='group_close' src='../../eOT/jsp/GeneralClose.jsp' noresize  marginheight=0 marginwidth=0 style='height:8vh;width:100vw'></iframe>

