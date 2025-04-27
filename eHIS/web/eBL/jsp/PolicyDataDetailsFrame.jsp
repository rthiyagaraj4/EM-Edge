<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<HTML>
<HEAD>
<%
String title = request.getParameter("title");
%>
<title><%=title %></title>
</HEAD>
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<!--<script src="../../eBL/js/BloodProductBillingDetails.js" language="javascript"></script>-->
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
			String params = request.getQueryString() ;
			if(params==null || params.equals("")) params="";
			String source = request.getParameter("source");
%>

   <iframe name='policydetails' id='policydetails'	src='../../eBL/jsp/<%=source%>.jsp?<%=params%>'  frameborder=0  style='height:100vh;width:100vw'></iframe>	  
</HTML>

