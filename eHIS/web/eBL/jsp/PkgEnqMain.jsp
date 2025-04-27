<!DOCTYPE html>
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" %>

<HTML>

<HEAD>
</HEAD>
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>	
		<script language='javascript' src='../../eBL/js/PkgEnq.js'></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%		   			
			String params = request.getQueryString() ;
			if(params==null || params.equals("")) params="";
			//System.out.println("------------------PkgEnqMain .jsp-------:"+params);
%>		<title><%=request.getParameter("title")%></title>
		<iframe name='PkgEnqFrame' id='PkgEnqFrame' src='PkgEnqFrame.jsp?<%=params%>' frameborder=0 scrolling='auto' noresize style='height:92vh;width:100vw'></iframe>
			<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='no' noresize style='height:7vh;width:100vw'></iframe>

	
</HTML>

