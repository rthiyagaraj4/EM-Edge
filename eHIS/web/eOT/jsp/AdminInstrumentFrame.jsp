<!DOCTYPE html>
<%@ page import = "eCommon.XSSRequestWrapper,eCommon.Common.*" contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>

<script language='javascript' src='../../eCommon/js/common.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<!-- Added by MuthuN against 42490 on 10/18/2013 -->
<title>
<fmt:message key="Common.Instrument.label" bundle="${common_labels}"/>
<fmt:message key="Common.Image.label" bundle="${common_labels}"/>
</title>
<iframe name='f_query_add' id='f_query_add'	src='../../eOT/jsp/OTInstrumentFrame.jsp?<%=request.getQueryString()%>'
	 noresize scrolling='auto' style='height:90vh;width:100vw'></iframe><iframe name='group_close' id='group_close' src='../../eOT/jsp/GeneralClose.jsp' noresize  marginheight=0 marginwidth=0 style='height:10vh;width:100vw'></iframe>
</html>

