<!DOCTYPE html>
<html>  
<head>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eXH/js/AdministerReviewCommunicationProcess.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
 
<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;		
	String module_id = request.getParameter("module_id");		
	String source = url + params ;
	String functionID = request.getParameter("function_id");

%>
										   
		
<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src='<%=source%>' frameborder=0 scrolling='no' noresize  style='height:7vh;width:100vw'></iframe>
<iframe name="queue_frame" id="queue_frame" src="../../eXH/jsp/AdminOracleJobProcessList.jsp?functionID=<%=functionID%>&module_id=<%=module_id%>"  frameborder=0 noresize scrolling="no" style="height:41vh;width:100vw"></iframe>
<iframe name="action_frame" id="action_frame" src='../../eXH/jsp/AdminOracleJobProcessAction.jsp?functionID=<%=functionID%>&module_id=<%=module_id%>' frameborder=0 noresize scrolling="no" style='height:40vh;width:100vw'></iframe>
<iframe name="messageFrame" id="messageFrame"	src="../../eCommon/jsp/error.jsp" scrolling="no" frameborder="0" noresize="" style="position: absolute; bottom: 0; left: 0; width: 100vw; height: 11vh; border: none;"></iframe>
</html>							  				    

