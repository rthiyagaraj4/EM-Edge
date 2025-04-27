<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import ="java.sql.*,java.util.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eSS/jsp/SsCheckParameter.jsp" %>
<html>
<head>	
		<title>Request</title>
<%
		request.setCharacterEncoding("UTF-8");
		String sStyle				=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>


		<script language='javascript' src='../../eSS/js/RequestGroup.js'></script>
		<script language='javascript' src='../../eSS/js/SsCommon.js'></script>
		<script language='javascript' src='../../eSS/js/SsTransaction.js'></script>
		<script language='javascript' src='../../eCommon/js/common.js'></script>
		<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

			<script>
				function_id			=		"<%= request.getParameter( "function_id" ) %>"
				menu_id				=		"<%= request.getParameter( "menu_id" ) %>"
				module_id			=		"<%= request.getParameter( "module_id" ) %>"
			</script>
</head>
<%
		String url					=		"../../eCommon/jsp/commonToolbar.jsp?" ;
		String params				=		request.getQueryString() ;		
		
		// Added Starts For OT CRF 35660	Bru-HIMS-CRF-268.1 by Ganga 

		String module_id = (String)request.getParameter("module_id")==null?"SS":(String)request.getParameter("module_id");

System.err.println("request.getQueryString()"+request.getQueryString());

		if(module_id.equals("OT")){ 
			
					String beanid						= request.getParameter( "beanid" )==null?"":request.getParameter( "beanid" );
					String beanName						= request.getParameter( "beanName" )==null?"":request.getParameter( "beanName" );
					String doc_type_code				= request.getParameter( "doc_type_code" )==null?"":request.getParameter( "doc_type_code" );
					String doc_no						= request.getParameter( "doc_no" )==null?"":request.getParameter( "doc_no" );
					String doc_date						= request.getParameter( "doc_date" )==null?"":request.getParameter( "doc_date" );
					String req_by_store_code			= request.getParameter( "req_by_store_code" )==null?"":request.getParameter( "req_by_store_code" );
					String req_on_store_code			= request.getParameter( "req_on_store_code" )==null?"":request.getParameter( "req_on_store_code" );
					String entry_completed_yn			= request.getParameter( "entry_completed_yn" )==null?"":request.getParameter( "entry_completed_yn" );
					String request_type					= request.getParameter( "request_type" )==null?"":request.getParameter( "request_type" );

			params = "menu_id=SS_MENU&module_id=OT&function_id=SS_REQUEST_GROUP&function_name=Request&function_type=F&access=NYNNN&home_required_yn=N&mode=1&doc_type_code="+doc_type_code+"&doc_no="+doc_no+"&doc_date="+doc_date+"&req_by_store_code="+req_by_store_code+"&req_on_store_code="+req_on_store_code+"&entry_completed_yn="+entry_completed_yn+"&request_type="+request_type+"&beanid="+beanid+"&beanName="+beanName+"";
		}
		session.putValue( "queryString",params );
		// Added Ended For OT CRF 35660	Bru-HIMS-CRF-268.1 by Ganga 

		String source				=		url + params ;
		

		


%>
<frameset rows="42,*,50" >
	<frame name='commontoolbarFrame' id='commontoolbarFrame'	src="<%= source %>" frameborder=0 scrolling='no' noresize>
	<%if(module_id.equals("OT")){ 
		%>
			<frame name='f_query_add_mod' id='f_query_add_mod' src="../../eSS/jsp/RequestGroupFrame.jsp?<%=params%>" frameborder=0 scrolling='no'>
	<%}else{%>	
			<frame name='f_query_add_mod' id='f_query_add_mod' src="../../eCommon/html/blank.html" frameborder=0 scrolling='no'>
	<%}%>
	<frame name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto'>
</frameset>
</html>

