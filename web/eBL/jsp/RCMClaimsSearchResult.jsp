<!DOCTYPE html>
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" %>
<HTML>
<HEAD>
</HEAD>
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		
		<script src='../../eBL/js/RCMClaims.js' language='javascript'></script>
		<script src='../../eBL/js/RCMClaimsStatusChange.js' language='javascript'></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
			String params = request.getQueryString() ;
			if(params==null || params.equals("")) params="";
			String function_id=request.getParameter("function_id");
			if(function_id==null || function_id.equals("")) function_id="";

			System.err.println("RCMClaimsSearchResult.jsp =====================================================>");
%>
   <iframe name='RCMClaimsPayerResult' id='RCMClaimsPayerResult' src='../../eBL/jsp/RCMClaimsPayerResult.jsp?<%=params%>' frameborder=0 noresize style='height:60vh;width:100vw'></iframe>
			<iframe name='RCMClaimsServiceDetails' id='RCMClaimsServiceDetails' src='../../eCommon/html/blank.html' frameborder=0  noresize style='height:40vh;width:100vw'></iframe>			
		  
</HTML>

