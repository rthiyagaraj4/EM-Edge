<!DOCTYPE html>
<%@ page import = "eCommon.XSSRequestWrapper,eCommon.Common.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends
%>
<%
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

<iframe name="commontoolbarFrame" id="commontoolbarFrame"  scrolling="no" noresize frameborder='0' src="../../eOT/jsp/TabSearch.jsp?<%=request.getQueryString()%>" style="height:5vh;width:99vw"></iframe>


<iframe name="f_query_add_mod" id="f_query_add_mod"  scrolling="no" noresize frameborder='0' src="../../eOT/jsp/CalendarFrame.jsp?<%=request.getQueryString()%>" style="height:94vh;width:99vw"></iframe>

<!--<frame name="f_query_add_mod" id="f_query_add_mod" frameborder="0" scrolling="no" noresize src="../../eOT/jsp/PendingOrderFrm.jsp?<%=request.getQueryString()%>">-->



