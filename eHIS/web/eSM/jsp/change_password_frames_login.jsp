<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<title><fmt:message key="Common.changepassword.label" bundle="${common_labels}"/></title>
<%
    request.setCharacterEncoding("UTF-8");
	String ecis_jdbc_user=request.getParameter("ecis_jdbc_user");
	String startup_db_driver=request.getParameter("startup_db_driver");
	String startup_connect_string=request.getParameter("startup_connect_string");
	String startup_user=request.getParameter("startup_user");
	String startup_password=request.getParameter("startup_password");
%>
<iframe src="../../eSM/jsp/change_password_form_login.jsp?ecis_jdbc_user=<%=ecis_jdbc_user%>&startup_db_driver=<%=startup_db_driver%>&startup_connect_string=<%=startup_connect_string%>&startup_user=<%=startup_user%>&startup_password=<%=startup_password%>"
	name="main_frame" id="main_frame" border=0 scrolling=no noresize style="height:100vh;width:100vw"></iframe>
	<iframe src="../../eCommon/html/blank.html" name="dummy_frame" id="dummy_frame" border=0 scrolling=no noresize style="height:0vh;width:100vw"></iframe>

</html>

