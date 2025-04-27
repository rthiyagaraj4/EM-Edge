<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<%@ page contentType="text/html;charset=UTF-8" import =" java.sql.*, java.text.*, webbeans.eCommon.*, java.util.* , javax.servlet.http.*, java.net.* " %>
<%
	request.setCharacterEncoding("UTF-8"); 
	String queryString=request.getQueryString();
%>

<title><%=request.getParameter("title")%></title>
	<iframe name="criteria_frame" id="criteria_frame" src='../../eIP/jsp/GeneralNursingUnitSearchCriteria.jsp?<%=queryString%>' noresize scrolling="no" frameborder="no" marginheight="0" marginwidth="0" style='height:16vh;width:99vw'></iframe>
	<iframe name="result_frame" id="result_frame"    src="../../eCommon/html/blank.html"  noresize scrolling="no" frameborder="no" marginheight="0" marginwidth="0" style="height:74vh;width:99vw"></iframe>
	<iframe name="close_frame" id="close_frame" src="../../eCommon/jsp/GeneralCancel.jsp" noresize scrolling="no" frameborder="no" marginheight="0" marginwidth="0" style="height:6vh;width:99vw"></iframe>
	<iframe name="submit_frame" id="submit_frame"    src="../../eCommon/html/blank.html"  noresize scrolling="no" frameborder="no" marginheight="0" marginwidth="0" style="height:4vh;width:99vw"></iframe>
</html>	

