<!DOCTYPE html>
<%@page  contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.Hashtable,java.util.ArrayList, java.util.HashMap,java.util.Enumeration, eBL.Common.*, eBL.*, eCommon.Common.*, webbeans.eCommon.*" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>


<HTML>
<HEAD>
</HEAD>
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language="javascript" src="../../eBL/js/RCMTransactions.js"></script>
		<script type="text/javascript">
		if(window.dialogArguments != ""){
			document.title = window.dialogArguments;
		}		
		</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
<%
			String params = request.getQueryString() ;
			if(params==null || params.equals("")) params="";
	
			String beanId = "bl_BLRCMTransactionsBean";
			String beanName = "eBL.BLRCMTransactionsBean";

			BLRCMTransactionsBean transBean = (BLRCMTransactionsBean) getBeanObject(beanId, beanName, request);
		
			transBean.clearAll();
		
			
			String function_id=request.getParameter("function_id");
			if(function_id==null || function_id.equals("")) function_id="";
			String called_from_dashboard_YN = request.getParameter("called_from_dashboard_YN");
			if(called_from_dashboard_YN == null || called_from_dashboard_YN.equals("")) called_from_dashboard_YN = "N";
			System.err.println("function_id "+function_id+", called_from_dashboard_YN= "+called_from_dashboard_YN);
			
			String facility_id = (String)session.getAttribute("facility_id");
			
%>

			   
	<%
		if(called_from_dashboard_YN.equals("Y")){ %>
		<iframe name='search_frame' id='search_frame' src='../../eCommon/html/blank.html' frameborder=0  noresize style='height:0vh;width:100vw'></iframe>
			<iframe name='BLRCMTransGenerateBillResult' id='BLRCMTransGenerateBillResult' src='../../eBL/jsp/BLRCMTransGenerateBillResult.jsp?<%=params%>&function_id=<%=function_id%>' frameborder=0 noresize scrolling="auto" style='height:50vh;width:100vw'></iframe>
			<iframe name='BLRCMTransGenerateServiceResult' id='BLRCMTransGenerateServiceResult' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling="auto" style='height:40vh;width:100vw'></iframe>	
			<iframe name='BLRCMTransResultQryBtn' id='BLRCMTransResultQryBtn' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling="no" style='height:5vh;width:100vw'></iframe>
			<iframe name='messageFrame' id='messageFrame' src='../../eCommon/html/blank.html' frameborder=0  noresize style='height:5vh;width:100vw'></iframe>
					
	<%	}else{%>
		<iframe name='search_frame' id='search_frame' src='../../eBL/jsp/BLEClaimQueryCriteria.jsp?<%=params%>&function_id=<%=function_id%>' frameborder=0  noresize style='height:25vh;width:100vw'></iframe>
			<iframe name='BLRCMTransGenerateBillResult' id='BLRCMTransGenerateBillResult' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling="auto" style='height:40vh;width:100vw'></iframe>
	<iframe name='BLRCMTransGenerateServiceResult' id='BLRCMTransGenerateServiceResult' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling="auto" style='height:25vh;width:100vw'></iframe>
<iframe name='BLRCMTransResultQryBtn' id='BLRCMTransResultQryBtn' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling="no" style='height:5vh;width:100vw'></iframe>			
	<%	} %>

</HTML>

<%
putObjectInBean("bl_BLRCMTransactionsBean",transBean,request);   
%>

