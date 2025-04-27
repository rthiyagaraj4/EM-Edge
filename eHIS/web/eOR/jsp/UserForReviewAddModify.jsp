<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--ReasonCode.jsp -->
 <%@ page  import="eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>

<%
     request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String function_id = request.getParameter( "function_id" ) ;

%>
<html>
<head>
 	<script language="JavaScript" src="../js/UserForReview.js"></script>
 	<script language="JavaScript" src="../js/OrCommon.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript"> function_id = "<%=function_id%>"</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%@ page session="false" %>
</head>
<%	
	String mode			= request.getParameter("mode");
	String resp_id		= request.getParameter("resp_id");	
	String resp_name	= request.getParameter("resp_name");
	String pract_id		= request.getParameter("pract_id");
	String pract_name	= request.getParameter("pract_name");

	mode = mode.trim();
	if(!(mode.equals("2"))){
		mode = "1";
	}

	if(mode.equals("1")){
%>
		<iframe name='user_for_review_top1' id='user_for_review_top1' src='UserForReviewAddModifyTop1.jsp?function_id=<%=function_id%>&mode=<%=mode%>' frameborder=0 scrolling='no' noresize style='height:4vh;width:100vw'></iframe>
			<iframe name='user_for_review_top2' id='user_for_review_top2' src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' style='height:8vh;width:100vw'></iframe>
			<iframe name='reason_for_review_bottom' id='reason_for_review_bottom' src='../../eCommon/html/blank.html' frameborder=0 style='height:88vh;width:100vw'></iframe>
<%	}else{ %>
		<iframe name='user_for_review_top2' id='user_for_review_top2' src='UserForReviewAddModifyTop2.jsp?mode=<%=mode%>&resp_id=<%=resp_id%>&pract_id=<%=pract_id%>&resp_name=<%=resp_name%>&pract_name=<%=pract_name%>' frameborder=0 scrolling='no' style='height:10vh;width:100vw'></iframe>
		<iframe name='reason_for_review_bottom' id='reason_for_review_bottom' src='UserForReviewAddModifyBottom.jsp?function_id=<%=function_id%>&mode=<%=mode%>&resp_id=<%=resp_id%>&pract_id=<%=pract_id%>' frameborder=0 style='height:90vh;width:100vw'></iframe>
<%
	}
%>

</html>									

