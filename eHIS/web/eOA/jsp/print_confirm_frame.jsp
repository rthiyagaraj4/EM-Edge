<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper"  %>
<html>
<title></title>
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String url = "../../eOA/jsp/print_confirm_form.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
	
%>
<iframe src='<%=source%>' name="main_frame" border=0 scrolling=no noresize style='height:0vh;width:100vw'></iframe>
	<iframe src="../../eCommon/html/blank.html" name="dummy_frame" id="dummy_frame" border=0 scrolling=no noresize style="height:0vh;width:100vw"></iframe>

</html>

