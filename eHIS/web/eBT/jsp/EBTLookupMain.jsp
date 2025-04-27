<!DOCTYPE html>
<%@page import="eBT.*, java.sql.*, java.text.*,java.util.*"  contentType="text/html; charset=UTF-8"%>

<html>

<%	request.setCharacterEncoding("UTF-8");	%>

<%
	String queryString=request.getQueryString();
//	out.println(queryString);
//System.out.println("EBT = EBT LOOKUP MAIN"+queryString);
%>


<title><%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,request.getParameter("title"),"bt_labels")%>
</title> 

<iframe name='group_head' id='group_head' src='../../eBT/jsp/EBTLookupHeader.jsp?<%=queryString%>' noresize  frameborder=no marginheight=0 marginwidth=0 style='height:17vh;width:100vw'></iframe>
<iframe name='code_desc' id='code_desc'    src='../../eCommon/html/blank.html'  noresize  scrolling=auto frameborder=no marginheight=0 marginwidth=0 style='height:73vh;width:100vw'></iframe>
<iframe name='group_tail' id='group_tail' src='../../eCommon/jsp/GeneralCancel.jsp' noresize  frameborder=no marginheight=0 marginwidth=0 style='height:10vh;width:100vw'></iframe>
</html>

