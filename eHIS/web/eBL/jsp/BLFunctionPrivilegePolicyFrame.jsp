
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%request.setCharacterEncoding("UTF-8");
String queryString = request.getQueryString();
%>
</head>

	<iframe name='PolicyAdd' id='PolicyAdd' src="BLFunctionPrivilegePolicyAdd.jsp?<%=queryString %>" frameborder=0 scrolling='no' noresize style='height:75vh;width:98vw'></iframe>
	<iframe name='PolicyBtn' id='PolicyBtn' src="BLFunctionPrivilegePolicyBtn.jsp?<%=queryString %>" frameborder=0 scrolling='no' noresize style='height:50vh;width:98vw'></iframe>

</html>

