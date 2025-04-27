<!DOCTYPE html>
<%
/* 
--------------------------------------------------------------------------------------------------------------------
DDate       	Edit History     Name      	Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------------			 	
23/10/2018		IN067402		Prakash		10/09/2018		Ramesh Goli		ML-MMOH-CRF-0813.1
--------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="eCommon.XSSRequestWrapper"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<html>
	<head><title>Tanner staging Audit Details </title>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String view_tanner_history_yn  = request.getParameter("view_history_yn")==null?"N":request.getParameter("view_history_yn");
	String sex=request.getParameter("Sex")==null?"U":request.getParameter("Sex");
	String age 			= request.getParameter("Age")==null?"":request.getParameter("Age");
	Integer patientAge 	= 0;
	if (age != null && age.length() > 1) {
		if(age.indexOf('Y')!=-1)
			patientAge = Integer.parseInt(age.substring(0, age.indexOf('Y'))); 
    }
%>
 
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	</head>
	
	<%
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	if(patientAge>=2 && patientAge<=18 && !sex.equals("U")){
		if(view_tanner_history_yn.equals("Y")){ 
			%>
			<iframe name='TannerStagingCriteriaFrm' id='TannerStagingCriteriaFrm' src="../../eCA/jsp/CATannerStagingCriteria.jsp?<%=request.getQueryString()%>" frameborder='0' noresize scrolling='auto' style='height:10vh;width:100vw'></iframe>
			<iframe name='TannerStagingDetails' id='TannerStagingDetails' src="" frameborder='0' noresize scrolling='auto' style='height:25vh;width:100vw'></iframe>
			<iframe name='TannerStagingFrame' id='TannerStagingFrame' src="" frameborder='0' noresize scrolling='auto' style='height:55vh;width:100vw'></iframe>
			<iframe name='TannerStagingPrintFrm' id='TannerStagingPrintFrm' src="" frameborder=0 scrolling=no noresize style='height:8vh;width:100vw'></iframe>
	<% }else{%>
		<div>
		<%if(sex.equals("M")){%>
				<iframe name='TannerStagingDetails' id='TannerStagingDetails' src="../../eCA/jsp/CATannerStagingAuditDetails.jsp?<%=request.getQueryString()%>" frameborder='0' noresize scrolling='auto' style="width: 100vw; height: 25vh;"></iframe>
				<iframe name='TannerStagingFrame' id='TannerStagingFrame' src="" frameborder='0' noresize scrolling='auto' style="width: 100vw; height: 60vh;"></iframe>
				<iframe name='TannerStagingPrintFrm' id='TannerStagingPrintFrm' src="" frameborder=0 scrolling=no noresize style='height:10vh;width:100vw'></iframe>
		<%}else{%>
				<iframe name='TannerStagingDetails' id='TannerStagingDetails' src="../../eCA/jsp/CATannerStagingAuditDetails.jsp?<%=request.getQueryString()%>" frameborder='0' noresize scrolling='auto' style="width: 100vw; height: 25vh;"></iframe>
				<iframe name='TannerStagingFrame' id='TannerStagingFrame' src="" frameborder='0' noresize scrolling='auto' style="width: 100vw; height: 60vh;"></iframe>
				<iframe name='TannerStagingPrintFrm' id='TannerStagingPrintFrm' src="" frameborder=0 scrolling=no noresize style='height:10vh;width:100vw'></iframe>
		<%}%>
	<% } 
	}else{%>
		<body>
			<table width="100%" height="550px" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="100%" align="center" valign="middle" valign="top">
						<table width="40%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<%if(sex.equals("U")){%>
								<td width="100%" style="text-align:center; vertical-align:top">
										This function is not applicable for this gender patient.
								<td>
								<%}else{%>
								<td width="100%" style="text-align:center; vertical-align:top">
										This function is applicable for age group between 2 to 18 years alone.
								<td>
								<%}%>
							</tr>
						</table>	
					<td>
				</tr>
			</table>
		</body>
	<%}%>	
	</div>
</html>

