
<%@ page   contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<title> <fmt:message key="eSM.MenuPreview.label" bundle="${sm_labels}"/> </title>
<%
    request.setCharacterEncoding("UTF-8");
	String menuid=request.getParameter("menuid");
%>


		<iframe name='menuPreview' id='menuPreview' BORDRCOLOR=black MARGINWIDTH=0 FRAMEBORDER=0 SCROLLING=AUTO src='../../eSM/jsp/menuDetailPreview.jsp?menuid=<%=menuid%>' style='height:100vh;width:100vw'> </iframe>

</html>



