<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title ><%=request.getParameter( "title" )%></title>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<% String params = request.getQueryString(); %>
</head>

<iframe name='PolicyDetailsDiagCopayPage' id='PolicyDetailsDiagCopayPage'	src='PolicyDetailsDiagCopayPopup.jsp?<%=params%>'  frameborder=0 scrolling='auto' noresize style='height:80vh;width:100vw'></iframe>
		<iframe name='diagPopupAdd' id='diagPopupAdd'	src='PolicyDetailsDiagCopayBtn.jsp?<%=params%>' frameborder=0 noresize  noresize style='height:20vh;width:100vw'></iframe>

</html>

