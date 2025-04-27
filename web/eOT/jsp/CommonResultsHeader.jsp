<!DOCTYPE html>
<%@page  contentType="text/html;charset=UTF-8" %>
<%@page  import ="eOT.*,eOT.Common.*" %>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% request.setCharacterEncoding("UTF-8");	%>
<html>
<head>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<style>
	TD.HDR{
	FONT-SIZE: 8pt ;
	COLOR:white;
	BORDER-STYLE: solid;
	height:9;
	BACKGROUND-COLOR:black;
	BORDER-BOTTOM: #CC9966 1px solid;
    BORDER-LEFT: #CC9966 1px solid;
    BORDER-RIGHT: #CC9966 1px solid;
    BORDER-TOP: #CC9966 1px solid;
	}
	</style>

</head>

<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
	<form name="ResultsHeaderForm" id="ResultsHeaderForm" >
		<%
			String header_flag = request.getParameter("header_flag");
			if(header_flag.equals("SLATE_SCHEDULED")){
		%>
		<table cellpadding="3"  cellspacing="0" width="100%" align="center" border="1" id="slate_results_table_header">
			<!-- <tr id="slate_results_table_row1"> -->
			
			<td class="CAGROUPHEADING" align="left" nowrap>
			<fmt:message key="eOT.ScheduledCases.Label" bundle="${ot_labels}"/>
			</td>
			  </tr>
		</table>
		<table cellpadding="3" cellspacing="0" width="100%" align="center" border="1" id="slate_results_table">
			<tr id="slate_results_table_row1">
				 <td  class="columnHeader" width="6%" > 
					<fmt:message key="Common.from.label" bundle="${common_labels}"/>
				 </td>
				<td  class="columnHeader" width="6%" >
				<fmt:message key="Common.to.label" bundle="${common_labels}"/> 
				</td>
				<td  class="columnHeader" width="11%" >
				<fmt:message key="Common.patientId.label" bundle="${common_labels}"/>
				</td>
				<td  class="columnHeader" width="20%" >
				<fmt:message key="Common.PatientName.label" bundle="${common_labels}"/>
				</td>
				<td  class="columnHeader" width="12%" >
					<fmt:message key="Common.Procedure.label" bundle="${common_labels}"/>
				</td>
				<td  class="columnHeader" width="13%" >
					<fmt:message key="Common.speciality.label" bundle="${common_labels}"/>
				</td>
				<td  class="columnHeader" width="13%" >
					<fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/>
				</td>
				 <td  class="columnHeader" width="17%" >
					<fmt:message key="Common.status.label" bundle="${common_labels}"/>
				</td>
			</tr>		
		</table>
			<%
				} else if(header_flag.equals("SLATE_UNSCHEDULED")){
			%>
				<table cellpadding="3" cellspacing="0" width="100%" align="center" border="1" id="slate_unsch_results_table_header">
					<tr id="slate_unsch_results_table_row1">
						<td class="CAGROUPHEADING" align="left" nowrap>
							<fmt:message key="eOT.UnScheduledCases.Label" bundle="${ot_labels}"/>
						</td>
					</tr>
				</table>
				<table cellpadding=3 cellspacing="0" width="100%" align="center" border="1" id="slate_unsch_results_table">
					<tr id="slate_unsch_results_table_row1">
							<td class='fields' class="columnHeader" width="13%" >
							<fmt:message key="Common.patientId.label" bundle="${common_labels}"/>
						</td>
						<td class='fields' class="columnHeader" width="30%" >
						<fmt:message key="Common.PatientName.label" bundle="${common_labels}"/>
						</td>
						<td class='fields' class="columnHeader" width="12%" >
						<fmt:message key="Common.Procedure.label" bundle="${common_labels}"/>
						</td>
					<td class='fields' class="columnHeader" width="13%" >	
					<fmt:message key="Common.speciality.label" 	bundle="${common_labels}"/>
					</td>
						<td class='fields' class="columnHeader" width="13%" >
							<fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/>
						</td>
					<td class='fields' class="columnHeader" width="17%" >	
					<fmt:message key="Common.status.label" bundle="${common_labels}"/>
						</td>
					</tr>
					<tr></tr>
				</table>
			<%
				}else if(header_flag.equals("SURGERY_WARD_CHECK_OUT")){
			%>
					<table cellpadding=3  cellspacing="0" width="100%" align="center" border="1" id="slate_results_table_header" >
						<tr id="slate_results_table_row1">
							<td class="CAGROUPHEADING" align="left" nowrap>
								<fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/>
							</td>
						</tr>
					</table>
					<table cellpadding=3  cellspacing="0" width="98%" align="left" border="1" id="slate_results_table">
						<tr id="slate_results_table_row1">
							
					<td class="columnHeader" width="11%" >
							<fmt:message key="Common.patientId.label" bundle="${common_labels}"/>
							</td>
							<td  class="columnHeader" width="23%" >
							<fmt:message key="Common.PatientName.label" bundle="${common_labels}"/>
							</td>
							<td  class="columnHeader" width="13%" >
							<fmt:message key="Common.Procedure.label" bundle="${common_labels}"/>
							</td>
							<td  class="columnHeader" width="13%" >
							<fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/>
							</td>
							<td  class="columnHeader" width="6%" >
							<fmt:message key="Common.from.label" bundle="${common_labels}"/>
							</td>
							<td class="columnHeader" width="6%" >						
								<fmt:message key="Common.to.label" bundle="${common_labels}"/>
							</td>
							<td  class="columnHeader" width="14%" >
								<fmt:message key="Common.status.label" bundle="${common_labels}"/>
							</td>
							<td  class="columnHeader" width="14%" ><fmt:message key="eOT.CheckOutTime.Label" 	bundle="${ot_labels}"/>
							</td> 
						</tr>
						<tr></tr>
					</table>
			<%
				}else if(header_flag.equals("RADIOLOGY_WARD_CHECK_OUT")){
			%>
					<table cellpadding=3  cellspacing="0" width="100%" align="center" border="1" id="slate_results_table_header">
						<tr id="slate_results_table_row1">
							<td class="CAGROUPHEADING" align="left" nowrap>
								<fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/>
							</td>
						</tr>
					</table>
					<table cellpadding=3  cellspacing="0" width="100%" align="center" border="1" id="slate_results_table">
						<tr id="slate_results_table_row1">
							<td  class="columnHeader" width="15%" >
								<fmt:message key="Common.patientId.label" bundle="${common_labels}"/>
							</td>
							<td  class="columnHeader" width="25%" >
								<fmt:message key="Common.PatientName.label" bundle="${common_labels}"/>
							</td>
							<td  class="columnHeader" width="15%" >
							<fmt:message key="eOT.Exam.Label" 	bundle="${ot_labels}"/>
							</td>
							<td  class="columnHeader" width="15%" >Physician
							</td>
								<td class="columnHeader" width="6%" >
								<fmt:message key="Common.from.label" bundle="${common_labels}"/>
							</td>
								<td  class="columnHeader" width="6%" >
								<fmt:message key="Common.to.label" bundle="${common_labels}"/>
							</td>
							<td  class="columnHeader" width="18%" >
							<fmt:message key="Common.status.label" bundle="${common_labels}"/>
							</td>
							</tr>
							<tr></tr>
						</table>
			<%
				}
			%>

		</form>
</body>
</html>

