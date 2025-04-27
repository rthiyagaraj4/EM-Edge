<!DOCTYPE html>


<html>
<%@ page contentType="text/html;charset=UTF-8"  import =" java.sql.*, java.text.*, webbeans.eCommon.*, java.util.* , javax.servlet.http.* "  %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
	String params = request.getQueryString() ;
	String calling_from=request.getParameter("calling_from");
	
%>
</head>

<!--<iframe src="AM_Referral_Setup.jsp?query_string=<%=params%>" name="master_menu" scrolling='no' noresize></iframe>
	<iframe src="../../eCommon/html/blank.html" name="master_pages" id="master_pages"></iframe>-->


<title><%=request.getParameter("title")%></title>
<%if(calling_from.equals("query"))
{
%>
<!--<title><%=request.getParameter("title")%></title>-->
<iframe name='group_head' id='group_head' src="../../eAM/jsp/AddModifyReferralSourceLookupHeader.jsp?<%=params%>" noresize scrolling=no  frameborder=no marginheight=0 marginwidth=0 style='height:19vh;width:95vw'></iframe>
<iframe name='code_desc' id='code_desc'    src='../../eCommon/html/blank.html'  noresize  scrolling=auto frameborder=no marginheight=0 marginwidth=0 style='height:67vh;width:95vw'></iframe>
<iframe name='group_tail' id='group_tail' src='../../eAM/jsp/ReferralSourceLookupClose.jsp' noresize  frameborder=no marginheight=0 marginwidth=0 style='height:6vh;width:95vw'></iframe>
<%}%>
<%if(calling_from.equals("create")){%>
<iframe name='group_head' id='group_head' src="../../eAM/jsp/ReferralSourceLookupHeader.jsp?<%=params%>" noresize scrolling=no  frameborder=no marginheight=0 marginwidth=0 style='height:14vh;width:95vw'></iframe>
<iframe name='code_desc' id='code_desc'    src='../../eCommon/html/blank.html'  noresize  scrolling=auto frameborder=no marginheight=0 marginwidth=0 style='height:76vh;width:95vw'></iframe>
<iframe name='group_tail' id='group_tail' src='../../eAM/jsp/ReferralSourceLookupClose.jsp' noresize  frameborder=no marginheight=0 marginwidth=0 style='height:10vh;width:95vw'></iframe>
<%}%>
</html>
</html>


