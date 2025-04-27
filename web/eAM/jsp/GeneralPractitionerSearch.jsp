<html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page  contentType="text/html;charset=UTF-8"  import =" java.sql.*, java.text.*, webbeans.eCommon.*, java.util.* , javax.servlet.http.* "  %>

<%
request.setCharacterEncoding("UTF-8");
	String queryString=request.getQueryString();
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	//out.println("<script>alert('"+queryString+"')</script>");
  
%>
<head>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>
<title><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></title>
<iframe name='criteria_frame' id='criteria_frame' src="../../eAM/jsp/GeneralPractitionerSearchCriteria.jsp?<%=queryString%>" noresize  frameborder="0" marginheight=0 marginwidth=0 scrolling=no style='height:24vh;width:98vw'></iframe>
<iframe name='result_frame' id='result_frame'    src="../../eAM/jsp/GeneralPractitionerSearchResult.jsp?<%=queryString%>"  noresize  scrolling=yes frameborder="0" marginheight=0 marginwidth=0 style='height:67vh;width:98vw'></iframe>
<iframe name='close_frame' id='close_frame' src="../../eAM/jsp/GeneralPractitionerClose.jsp" noresize  frameborder="0" marginheight=0 marginwidth=0 style='height:8vh;width:98vw'></iframe>
</html>

