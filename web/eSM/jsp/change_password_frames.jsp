<!DOCTYPE html>
 <%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<title><fmt:message key="Common.changepassword.label" bundle="${common_labels}"/></title>
<%
    request.setCharacterEncoding("UTF-8");
	String main = request.getParameter("main_yn")==null?"":request.getParameter("main_yn");
%>

<iframe src="../../eSM/jsp/change_password_form.jsp?main=<%=main%>" name="main_frame" id="main_frame" border=0 scrolling=no noresize style="height:100vh;width:100vw"></iframe>
	<iframe src="../../eCommon/html/blank.html" name="dummy_frame" id="dummy_frame" border=0 scrolling=no noresize style="height:0vh;width:100vw"></iframe>

</html>

