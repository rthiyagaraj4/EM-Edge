<!DOCTYPE html>
<%@ page import ="java.sql.*, java.util.*, java.text.* " contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %> 

<html><head>
<%
	request.setCharacterEncoding("UTF-8");
     String series=request.getParameter("series");
     if(series==null || series.equals("")) series="";
     String prompt = request.getParameter("prompt") ;
     StringTokenizer sttoks = new StringTokenizer(prompt,"~") ;
     String alt_prompt = sttoks.nextToken() ;
     String nat_prompt = sttoks.nextToken() ;
     if(series.equals("N"))
     {
        
  %>
<title><fmt:message key="Common.Check.label" bundle="${common_labels}"/> <%=nat_prompt%></title>
<%}else if(series.equals("A")){%>
<title><fmt:message key="Common.Check.label" bundle="${common_labels}"/> <%=alt_prompt%></title>
<%}%>
<style>
iframe{border:0px;}
</style>
</head>
<iframe name="main" id="main"  src="../../eMP/jsp/checkNationality.jsp?step=first&<%=request.getQueryString()%>" scrolling="no" noresize style='height:75vh;width:95vw'></iframe>
<iframe name='dummy' id='dummy' style='height:0vh;width:100vw'></iframe>

</html>

