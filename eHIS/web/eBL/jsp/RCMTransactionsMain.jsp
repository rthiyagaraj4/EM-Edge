<!DOCTYPE html>
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" %>
<%@page import="eBL.BLReportIdMapper"%>
<HTML>
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script language="javascript" src="../../eBL/js/RCMTransactions.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
			String params = request.getQueryString() ;
			if(params==null || params.equals("")) params="";
				
			String facility_id = (String)session.getAttribute("facility_id");
			
%>

   <iframe name='commontoolbarFrame' id='commontoolbarFrame'	src='../../eCommon/jsp/commonToolbar.jsp?<%=params%>'  frameborder=0  noresize scrolling="no" style='height:6vh;width:100vw'></iframe>
			<iframe name='BLRCMTransFrameset' id='BLRCMTransFrameset' src='../../eBL/jsp/BLRCMTransFrameset.jsp?<%=params%>' frameborder=0  noresize style='height:89vh;width:100vw'></iframe>	
			<iframe name='messageFrame' id='messageFrame'	 src='../../eCommon/jsp/error.jsp' frameborder=0 noresize noresize style='height:5vh;width:100vw'></iframe>	  

</HTML>

