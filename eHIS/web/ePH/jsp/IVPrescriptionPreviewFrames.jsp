<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper"%>
<HTML>
	<HEAD>
<%
		request.setCharacterEncoding("UTF-8");
//Added  for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
		String params		= request.getQueryString();
		String titletext	= request.getParameter("titletext");
%>
		<TITLE><%= titletext %></TITLE>
	</HEAD>
	<iframe name="preview_dtls" id="preview_dtls" FRAMEBORDER="0" SCROLLING="auto" NORESIZE SRC="IVPrescriptionPreviewDetails.jsp?<%= params %>" style="height:96vh;width:100vw"></iframe><iframe name="preview_btns" id="preview_btns" FRAMEBORDER="0" SCROLLING="auto" NORESIZE SRC="IVPrescriptionPreviewButtons.jsp" style="height:4vh;width:100vw"></iframe>
</HTML>

