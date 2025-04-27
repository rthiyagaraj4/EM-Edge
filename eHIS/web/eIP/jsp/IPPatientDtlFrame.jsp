<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<%@ page contentType="text/html;charset=UTF-8" import =" java.sql.*, java.text.*, webbeans.eCommon.*, java.util.* , javax.servlet.http.*, java.net.* " %>
<%
	request.setCharacterEncoding("UTF-8"); 
	String queryString=request.getQueryString();

	
%>
<script src='../../eCommon/js/common.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<title><%=request.getParameter("title")%></title>
	<iframe name="criteria_frame" id="criteria_frame" src='../../eIP/jsp/IPPatientsDetails.jsp?<%=queryString%>' noresize scrolling="auto" frameborder="no" marginheight="0" marginwidth="0" style='height:92vh;width:98vw'></iframe>
	<iframe name="close_frame" id="close_frame" src="../../eCommon/jsp/GeneralCancel.jsp" noresize scrolling="no" frameborder="no" marginheight="0" marginwidth="0" style="height:8vh;width:98vw"></iframe>
</html>	

