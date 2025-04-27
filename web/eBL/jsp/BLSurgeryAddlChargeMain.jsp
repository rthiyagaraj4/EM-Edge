<!DOCTYPE html>
<HTML>
<HEAD>	
	<title>Service Entry</title>
	<%String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eBL/js/BLEnterReceiptsRefund.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
</HEAD>
<%
		String params = request.getQueryString();
//		String function_id=request.getParameter("function_id");
		
%>

<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src='../../eCommon/jsp/commonToolbar.jsp?<%=params%>'  frameborder=0 scrolling='no' style='height:6vh;width:100vw'>
	<iframe name='search_frame' id='search_frame' src='../../eBL/jsp/BLViewPatEncounterDtlsFrame.jsp?<%=params%>' frameborder=0 scrolling='no' noresize style='height:89vh;width:100vw'></iframe>
<!--<iframe name='search_frame' id='search_frame' src='../../eBL/jsp/BLSurgeryAddlChargeFrame.jsp?<%=params%>' frameborder=0 scrolling='no' noresize style='height:100vh;width:100vw'></iframe>-->
	<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' noresize style='height:5vh;width:100vw'></iframe>

		
</HTML>

