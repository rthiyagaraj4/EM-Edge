<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<%   request.setCharacterEncoding("UTF-8"); %>
<% 
	out.println("<html>");
	out.println("<head><title>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancelledby.label","common_labels")+"</title></head>");
	String url 	= "../../eIP/jsp/CancelledbySearch.jsp?" ;
	String params	= request.getQueryString() ;
	String source   = url+params ;
%>
<iframe name='cancel_frame' id='cancel_frame' src=<%=source%> frameborder=0 scrolling=auto noresize style='height:80vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame'	 src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling=auto style='height:1%;width:100vw'></iframe>
</html>


