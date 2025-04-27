<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=UTF-8"  import =" java.sql.*, java.text.*, webbeans.eCommon.*, java.util.* , javax.servlet.http.* "  %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
	String queryString=request.getQueryString();

//out.println("<script> alert(\" in search queryString:---"+queryString+"\"); </script>");
  
%>

<title><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></title>
<iframe name='criteria_frame' id='criteria_frame' src='../../eAM/jsp/GenPractSearchCriteria.jsp?<%=queryString%>' noresize  frameborder=no marginheight=0 marginwidth=0 style='height:25vh;width:100vw'></iframe>
<iframe name='result_frame' id='result_frame'    src='../../eCommon/html/blank.html'  noresize  scrolling=no frameborder=no marginheight=0 marginwidth=0 style='height:68vh;width:100vw'></iframe>
<iframe name='close_frame' id='close_frame' src='../../eAM/jsp/GeneralPractitionerClose.jsp' noresize  frameborder=no marginheight=0 marginwidth=0 style='height:7vh;width:100vw'></iframe>
</html>

