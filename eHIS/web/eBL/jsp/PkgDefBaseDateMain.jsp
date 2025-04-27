<!DOCTYPE html>
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" %>

<%
		String params = request.getQueryString();
%>
<HTML>
<HEAD>
</HEAD>
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language="javascript" src='../../eBL/js/PkgDef.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
		<iframe name='baseDateDtl' id='baseDateDtl'	src='PkgDefBaseDate.jsp?<%=params%>'  frameborder='0' noresize scrolling='auto' style='height:75vh;width:100vw'></iframe>
		<iframe name='basePriceBtn' id='basePriceBtn' src="../../eBL/jsp/PkgDefBasePriceBtn.jsp?<%=params%>&table_name=pkgDate&func_mode=PACKAGE_DATE" frameborder='0' noresize scrolling='no' style='height:25vh;width:100vw'></iframe>

</HTML>

