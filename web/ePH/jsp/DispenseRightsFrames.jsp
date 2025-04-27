<!DOCTYPE html>
 <%@page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper"%>
<HTML>
<%
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
//end.
	String url = "../../ePH/jsp/DispenseRightsAddModify.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>
		<iframe name="disp_rights_main_frame" id="disp_rights_main_frame" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="<%= source %>" style="height:10vh;width:98vw"></iframe>
		<iframe name="disp_rights_sub_frame" id="disp_rights_sub_frame" FRAMEBORDER="0" SCROLLING="auto" NORESIZE SRC="../../eCommon/html/blank.html" style="height:85vh;width:98vw"></iframe>
</HTML>

