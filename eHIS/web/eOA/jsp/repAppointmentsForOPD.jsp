<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>

<script src="../../eOA/js/repAppointmentsForOPD.js"></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<%
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
	//out.println(source);
%>

<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%= source %> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' 		src='../../eOA/jsp/repAppointmentsForOPDForm.jsp' frameborder=0 style='height:83vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:9vh;width:100vw'></iframe>

