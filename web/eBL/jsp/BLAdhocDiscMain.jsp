<!DOCTYPE html>
<HTML>
<HEAD>	
	<%String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<!--	<script language="javascript" src="../../eBL/js/BLEnterServiceRequest.js"></script>-->
	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</HEAD>
<%
		String params = request.getQueryString();
//		System.out.println("params :"+params);
		
%>

	<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src='../../eCommon/jsp/commonToolbar.jsp?<%=params%>'  frameborder=0 scrolling='no' style='height:6vh;width:100vw'>
	<iframe name='hdr_frame' id='hdr_frame' src='../../eBL/jsp/BLViewPatEncounterDtlsFrame.jsp?<%=params%>' frameborder=0 scrolling='no' noresize style='height:89vh;width:100vw'></iframe>-->
	
	<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' noresize style='height:5vh;width:100vw'></iframe>

		
</HTML>

