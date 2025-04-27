<!DOCTYPE html>
<%
/*
Sr No     Version        Incident			SCF/CRF					Developer Name
-----------------------------------------------------------------------------------
1          V220525							GHL-CRF-0632     		Mohanapriya
-----------------------------------------------------------------------------------
*/
%>
<HTML>
<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>	
	<script language="javascript" src='../js/indirectServCancel.js'></script> 
	<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	String params = request.getQueryString() ;
	if(params==null || params.equals("")) params="";
	String function_id=request.getParameter("function_id");
	if(function_id==null || function_id.equals("")) function_id="";
%>
	<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src='../../eCommon/jsp/commonToolbar.jsp?<%=params%>'  frameborder=0 scrolling='no' noresize style='height:6vh;width:100vw'></iframe>
		<iframe name='indirectServCancelFrame' id='indirectServCancelFrame' 	src='IndirectServCancelHdrFrame.jsp?<%=params%>'  frameborder=0  noresize style='height:7vh;width:100vw'></iframe>
		<iframe name='indirect_serv_cancel' id='indirect_serv_cancel' src='../../eCommon/html/blank.html' frameborder=0 style='height:80vh;width:100vw'></iframe>
		<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' noresize style='height:7vh;width:100vw'></iframe>
	
</HTML>

