<!DOCTYPE html>
<html>
<head> 
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eXH/js/ViewQuerymessages.js'></script>
<script language='JavaScript' src='../../eCommon/js/common.js'></script>
<script language='JavaScript' src='../../eXH/js/checkfield.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<title><fmt:message key="eXH.MessageReview.Label" bundle="${xh_labels}"/></title> 


<%
		 
		String params = request.getQueryString() ;
		//String source = url + params ; 

	String appl_name = request.getParameter("application_Id"); 
	String facility = request.getParameter("Facility_Id");
	String event_type = request.getParameter("Even_type");
	//String status = request.getParameter("msg_status"); 
	String msg_id = request.getParameter("Msg_Id");
	//String amsg_dt1 = request.getParameter("qmsg_dt1");
	//String amsg_dt2 = request.getParameter("qmsg_dt2");
	String purge_status=request.getParameter("purge_status");
	//String mode = request.getParameter("sortMode");	

 String url2 ="../../eXH/jsp/ViewMsgReviewAuditLog.jsp?appl_name="+appl_name+"&facility="+facility+"&msg_id="+msg_id+"&event_type="+event_type+"&purge_status="+purge_status+"&commMode=&msg_type=&amsg_dt1=&amsg_dt2=&sortMode=A&orderbycolumns=&action_type=S&locale=en";


%>			     
	  
	<iframe name='f_query_' id='f_query_' src='../../eXH/jsp/ViewQueryNextPreviousPage.jsp?<%=params%>&action_type=A&pagechange=N' frameborder=1 noresize scrolling='no' style='height:3vh;width:100vw'></iframe>
		<iframe name='f_query_header' id='f_query_header' src='../../eXH/jsp/ViewQryMsgFooterMain.jsp?<%=params%>&action_type=A' frameborder=1 noresize scrolling='no' style='height:82vh;width:100vw'></iframe>
		<iframe name='auditlogFrame' id='auditlogFrame'	 src='<%=url2%>' frameborder=1 noresize scrolling='no' style='height:15vh;width:100vw'></iframe>
</html>  

