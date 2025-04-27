<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page  import=" java.sql.*,java.util.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eSS/jsp/SsCheckParameter.jsp" %>
<html>
<head>
 <%
			request.setCharacterEncoding("UTF-8");
			String sStyle		=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	</link>
	<script language='javascript' src='../../eSS/js/IssueGroup.js'></script>
	<script language='javascript' src='../../eSS/js/SsCommon.js'></script>
	<script language='javascript' src='../../eSS/js/SsTransaction.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<script>
			function_id			=		"<%= request.getParameter( "function_id" ) %>"
			params		="<%=request.getQueryString()%>"
		</script>
		<title>Re-Issue</title>
</head>
<%
	String url					=		"../../eCommon/jsp/commonToolbar.jsp?" ;
	String params				=		request.getQueryString() ;
	String qry_str_toolBar		= params; 
	String source				=		url + params ;
	String source1				= "../../eCommon/html/blank.html";
	String function_id			= request.getParameter("function_id");
	
	System.out.println("function_id"+function_id);
	if(!function_id.trim().equalsIgnoreCase("SS_ISSUE_GROUP")){
	 qry_str_toolBar ="function_id=SS_ACKNOWLEDGEMENT_TRANS&function_name=Re-Issue&function_type=F&access=NYNNN&home_required_yn=N";
	source1 = "../../eSS/jsp/IssueGroupFrame.jsp?"+ params;
	System.out.println("source1"+source1);
	}
	source	 = url + qry_str_toolBar	;
	System.out.println("source"+source);
%>

<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src="<%= source %>" frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' src='<%=source1%>' frameborder=0 scrolling='no' style='height:82vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:10vh;width:100vw'></iframe>
</html>

