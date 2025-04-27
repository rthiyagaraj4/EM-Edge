<!DOCTYPE html>
<%
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
09/10/2013     		1   		Sethuraman      Created 
-------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page language="java" import ="webbeans.eCommon.*, eCA.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%	
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<html>
	<head>
		<title><fmt:message key="Common.PreviousEncounters.label" bundle="${common_labels}"/></title>
		<%
			
			String sStyle =
			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
			
			EncSummGroup summGrpDetails = new EncSummGroup();		
			
			String patientId = request.getParameter("patientId") == null ? "" : request.getParameter("patientId");
			String currEncId = request.getParameter("currEncId") == null ? "" : request.getParameter("currEncId");
			
			String encounterId = "", encounterDate = "", classValue = "", patientType = "";			
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script language='javascript' src='../../eCA/js/EncSummPopUp.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
		
	</head>
	<body onscroll='scrollTitleTop()' OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name = 'encSummPopUpListForm'>
			<table class='grid' cellpadding='3' cellspacing='0' border='1' width='100%'  align='center'>
				<tr id='trcoll'>
					<td class='columnHeader' colspan='5'><fmt:message key="Common.PreviousEncounters.label" bundle="${common_labels}"/></td>					
				</tr>
			</table>
			<table class='grid' cellpadding='3' cellspacing='0' border='0' width='100%'  align='center'>
				<tr id='trcoll'>
					<td class='COLUMNHEADERCENTER' width="100" ><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
					<td class='COLUMNHEADERCENTER'><fmt:message key="Common.encounterdate.label" bundle="${common_labels}"/></td>
					<td class='COLUMNHEADERCENTER'><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></td>							
					<td class='COLUMNHEADERCENTER'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>					
				</tr>
				<%										
					List<PatientEncounterBean> oPatientEncList = null;
					PatientEncounterBean sPatienEncBean = null;
					
					int nListSize = 0;
					
					try
					{
						oPatientEncList = new ArrayList<PatientEncounterBean>();
						sPatienEncBean = new PatientEncounterBean();
						
						sPatienEncBean.setRequest(request);
						sPatienEncBean.setsPatientID(patientId);
						sPatienEncBean.setsCurrEncID(currEncId);
						
						oPatientEncList = summGrpDetails.getPatientEncounter(sPatienEncBean);		
						
						nListSize = oPatientEncList.size();	
						
						classValue = "gridData";
						
						if (nListSize == 0)
						{
							%>	
								<script>
									alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));
									parent.EncSummPopupPrevEncFrame.location.href = '../../eCommon/html/blank.html';
								</script>
							<%
						}
						
						for (int i=0;i<nListSize;i++){
							
							sPatienEncBean = oPatientEncList.get(i);
							
							encounterId = sPatienEncBean.getsEncounterID();
							encounterDate = sPatienEncBean.getsVisitDateTime();
							if (sPatienEncBean.getsPatientClass().equalsIgnoreCase("i"))
								patientType = "Inpatient";
							else if (sPatienEncBean.getsPatientClass().equalsIgnoreCase("o"))
								patientType = "Outpatient";
							%>							
							<tr id ='trRowId<%=i %>'>								
								<td style='display:none'> <input type='hidden' name ='patientId<%=i %>' value = '<%=patientId %>' > </td>
								<td style='display:none'> <input type='hidden' name ='encounterId<%=i %>' value = '<%=encounterId %>' > </td>
								<!-- 
								<td class='gridData'> <a href="javascript:viewEncounterSummary('<%=patientId %>','<%=encounterId %>');"><%=encounterId %> </a> </td>
								 -->
								<td class='gridData'> <a href="javascript:setEncounterValue('<%=patientId %>','<%=encounterId %>'); javascript:checkForSummary(this);"><%=encounterId %> </a> </td>
								<td class='gridData'> <%=encounterDate %> </td>
								<td class='gridData'> <%=patientType %> </td>										
								<td class='gridData'   align='center'> 
									<input type='radio' name='encSel' id='encSel' onclick="setEncounterValue('<%=patientId %>','<%=encounterId %>');"> 
								</td>							
							</tr>	
							<%												
						}						

					}
					catch(Exception e)
					{
						//out.println("Exception in try of EncSummPopUpList.jsp"+e.toString());//COMMON-ICN-0181
						e.printStackTrace();
					}				
			%>
			</table>			
		</form>		
	</body>
</html>

