<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<HTML>
<HEAD>


<%
	//response.setContentType("UTF-8");
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	String params		= request.getQueryString();
	String titletext	= request.getParameter("titletext");

%>
<TITLE><%= request.getParameter("titletext")%></TITLE>


</HEAD>

<iframe name="preview_dtls" id="preview_dtls" FRAMEBORDER="0" SCROLLING="auto" NORESIZE SRC="IVPrescriptionWithoutAdditivesPreview.jsp?<%= params %>" style="height:93vh;width:96vw"></iframe><iframe name="preview_btns" id="preview_btns" FRAMEBORDER="0" SCROLLING="auto" NORESIZE SRC="IVPrescriptionPreviewButtons.jsp" style="height:4vh;width:97vw"></iframe>

</HTML>

