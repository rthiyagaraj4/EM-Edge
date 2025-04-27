<!DOCTYPE html>
<html>
<%@ page  contentType="text/html;charset=UTF-8"  import =" java.sql.*, java.text.*, webbeans.eCommon.*, java.util.* , javax.servlet.http.* " %>
<%
	request.setCharacterEncoding("UTF-8");
	String queryString=request.getQueryString();
%>
<title><%=request.getParameter("title")%></title>
<iframe name='criteria_frame' id='criteria_frame' src='../../eAM/jsp/GeneralPractitionerSearchCriteria.jsp?<%=queryString%>' noresize  frameborder=no marginheight=0 marginwidth=0 style='height:23%;width:100vw'></iframe><iframe name='result_frame' id='result_frame'    src='../../eCommon/html/blank.html'  noresize  scrolling=no frameborder=no marginheight=0 marginwidth=0 style='height:80vh;width:100vw'></iframe><iframe name='close_frame' id='close_frame' src='../../eCommon/jsp/GeneralCancel.jsp' noresize  frameborder=no marginheight=0 marginwidth=0 style='height:10%;width:100vw'></iframe>
</html>

