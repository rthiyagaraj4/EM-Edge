<!DOCTYPE html>
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*,eBL.Common.*,eBL.*,eCommon.Common.*,com.ehis.util.*" %>

<HTML>
<HEAD>

<!--
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'</link>
-->
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language="javascript" src='../../eBL/js/PkgAssociate.js'></script>
		<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script> 
</HEAD>
<%
		String params = request.getQueryString();		
		String title=request.getParameter("title");
%>
<title><%=title%></title>
		<iframe name='PkgAssociateDtl' id='PkgAssociateDtl'	src="../../eBL/jsp/PkgAssociateDtl.jsp?<%=params%>"  frameborder=0 scrolling='auto' noresize style='height:82vh;width:100vw'></iframe>
			<iframe name=' PkgAssociateBtn' id=' PkgAssociateBtn' src="../../eBL/jsp/PkgAssociateBtn.jsp" frameborder='0' noresize scrolling='no' style='height:8vh;width:100vw'></iframe>	
			<iframe name='dummyFrame' id='dummyFrame'		src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' noresize style='height:0vh;width:100vw'></iframe>
		
</HTML>

