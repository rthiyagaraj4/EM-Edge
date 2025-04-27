<!DOCTYPE html>
 <%
	String params		= request.getQueryString();
	String titletext	= request.getParameter("titletext");
%>

<html>
<head><title><%= titletext %></title></head>

<iframe name="preview_dtls" id="preview_dtls" frameborder="0" scrolling="auto" noresize src="OncologyRegimenPreviewDetails.jsp?<%= params %>" style="height:96vh;width:100vw"></iframe><iframe name="preview_btns" id="preview_btns" frameborder="0" scrolling="auto" noresize src="IVPrescriptionPreviewButtons.jsp" style="height:4vh;width:100vw"></iframe>

</html>

