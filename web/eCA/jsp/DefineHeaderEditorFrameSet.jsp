<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<% 
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String query_string = "header_type="+request.getParameter("header_type")+"&mode="+request.getParameter("mode")+"&header_id="+request.getParameter("header_id")+"&long_desc="+request.getParameter("long_desc")+"&short_desc="+request.getParameter("short_desc")+"&eff_status="+request.getParameter("eff_status");
%>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<iframe name="f_query_add_mod" id="f_query_add_mod" src="../../eCA/jsp/DefineHeaderEditorMainFrameSet.jsp?<%=query_string%>" frameborder="none" border="none" scrolling="auto" noresize style="height:100vh;width:100vw"></iframe> 


