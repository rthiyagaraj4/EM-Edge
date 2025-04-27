<!DOCTYPE html>
<%
/* 
--------------------------------------------------------------------------------------------------------------------
DDate       	Edit History     Name      			Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------------			 	
09/20/2018		IN067564		Ramya Maddena		10/09/2018		Ramesh Goli		ML-MMOH-CRF-1186
--------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import ="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<%
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<html>
	<head><title>Ballard Score </title>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String view_history_yn  = request.getParameter("view_history_yn")==null?"N":request.getParameter("view_history_yn");
	
%>
 
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	</head>
	
	<% if(view_history_yn.equals("Y")){ %>
	<iframe name='BallardScoreCriteriaHistory' id='BallardScoreCriteriaHistory' src="../../eCA/jsp/CABallardScoreCriteria.jsp?<%=request.getQueryString()%>" frameborder='0' noresize scrolling='auto' style='height:6vh;width:100vw'></iframe>
	<iframe name='BallardScoreAuditDetailsFrm' id='BallardScoreAuditDetailsFrm' src="" frameborder='0' noresize scrolling='auto' style='height:25vh;width:100vw'></iframe>
		<iframe name='BallardScoreAuditResultFrm' id='BallardScoreAuditResultFrm' src="" frameborder='0' noresize scrolling='auto' style='height:56vh;width:100vw'></iframe>
		<iframe name='BallardScoreAuditPrintFrm' id='BallardScoreAuditPrintFrm' src="../../eCA/jsp/CABallardScoreAuditPrint.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling=no noresize style='height:6vh;width:100vw'></iframe>
	<% }else{ %>
	<!-- <frameset rows="15%,40%,5%"> -->
		<iframe name='BallardScoreAuditDetailsFrm' id='BallardScoreAuditDetailsFrm' src="../../eCA/jsp/CABallardScoreAuditDetails.jsp?<%=request.getQueryString()%>" frameborder='0' noresize scrolling='auto' style='height:25vh;width:100vw'></iframe>
		<iframe name='BallardScoreAuditResultFrm' id='BallardScoreAuditResultFrm' src="" frameborder='0' noresize scrolling='auto' style='height:64vh;width:100vw'></iframe>
		<iframe name='BallardScoreAuditPrintFrm' id='BallardScoreAuditPrintFrm' src="../../eCA/jsp/CABallardScoreAuditPrint.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling=no noresize style='height:6vh;width:100vw'></iframe>
	<% } %>
		 
	
</html>

