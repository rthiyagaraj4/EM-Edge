<!DOCTYPE html>
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" %>
<HTML>
<HEAD>
</HEAD>
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		
		<script language='javascript' src='../../eBL/js/RCMClaims.js'></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
			String params = request.getQueryString() ;
			if(params==null || params.equals("")) params="";
			String function_id=request.getParameter("function_id");
			if(function_id==null || function_id.equals("")) function_id="";
%>
   <iframe name='RCMQueryCriteriaFrame' id='RCMQueryCriteriaFrame' src='../../eBL/jsp/RCMClaimsQueryCriteria.jsp?<%=params%>' frameborder=0 noresize scrolling="auto" style='height:30vh;width:100vw'></iframe>
   <iframe name='RCMQueryResultFrame' id='RCMQueryResultFrame' src='../../eCommon/html/blank.html' frameborder=0  noresize scrolling='auto' style='height:65vh;width:100vw'></iframe>
   <iframe name='RCMQueryResultBtnFrame' id='RCMQueryResultBtnFrame' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto' style='height:5vh;width:100vw'></iframe>	  
</HTML>

