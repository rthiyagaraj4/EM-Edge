<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<HTML>
<HEAD>
<title>Package Utilization Details</title>
</HEAD>
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><script language='javascript' src='../../eBL/js/PkgUtilization.js'></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<%		   			
		String params = request.getQueryString() ;
		if(params==null || params.equals("")) params="";
		params = params + "&calledFrom=Banner";
%>		
		<iframe name='PkgDtlsFrame' id='PkgDtlsFrame' src='../../eBL/jsp/PkgUtilizationDtlsForPatient.jsp?<%=params%>' frameborder=0 scrolling='auto' noresize></iframe>
			<iframe name='PkgServDtlsFrame' id='PkgServDtlsFrame' src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize></iframe>
	
</HTML>

