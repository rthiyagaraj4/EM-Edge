<!DOCTYPE html>
<%@ page import ="java.util.*,java.sql.*,webbeans.eCommon.ConnectionManager,eCommon.Common.*,eOT.*,eOT.Common.OTRepository,eOT.CheckInBean" contentType=" text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%@include file="../../eOT/jsp/StringUtil.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
<script language='javascript' src='../../eOT/js/jquery-latest.js'></script>
<script type='text/javascript' src='../../eOT/js/Booking.js'></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<head><title>Select Primary Speciality </title></head>
<%
	String[] getChkedRecsOrderIdsArray = null;
	String getChkedRecsOrderIds = request.getParameter("getChkedRecsOrderIds");
	if(getChkedRecsOrderIds != null && getChkedRecsOrderIds.contains(","))
		getChkedRecsOrderIds = getChkedRecsOrderIds.replaceAll(",", "','");
	String patientId = request.getParameter("patientId");
	System.out.println("====getChkedRecsOrderIds===="+getChkedRecsOrderIds);
	System.out.println("====patientId===="+patientId);
	if(getChkedRecsOrderIds != null && getChkedRecsOrderIds.trim().length() > 0)
		getChkedRecsOrderIdsArray = getChkedRecsOrderIds.split(",");
	System.out.println("====getChkedRecsOrderIdsArray===="+Arrays.asList(getChkedRecsOrderIdsArray));

	String bean_id = "CheckInBean";
	String bean_name = "eOT.CheckInBean";
	CheckInBean chk_bean = (CheckInBean)mh.getBeanObject(bean_id, request, bean_name);
	OtCommonGettersSetters passDets = new OtCommonGettersSetters();
	passDets.setPatientId(patientId);
	passDets.setOrderId(getChkedRecsOrderIds);
	ArrayList getDetsForOrderIdsList = chk_bean.getDetsForOrderIds(passDets);
	System.out.println("====getDetsForOrderIdsList===="+getDetsForOrderIdsList);

%>
<body>
	<form name="getSpecialityForm" id="getSpecialityForm" >
		<table class='grid' border='1' width='100%' cellpadding='3' cellspacing='0'>
			
			<tr><td></td></tr>
			<tr>
				<td class="columnHeader">&nbsp;</td>
				<td class="columnHeader"><fmt:message key="Common.SurgeryType.label" bundle="${common_labels}"/></td>
				<td class="columnHeader"><fmt:message key="Common.Procedure.label" bundle="${common_labels}"/></td>
				<td class="columnHeader"><fmt:message key="Common.PreferredDate.label" bundle="${common_labels}"/></td>
				<td class="columnHeader"><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
				<td class="columnHeader"><fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/></td>
				<td class="columnHeader"><fmt:message key="eOT.AnaesthesiaRequired.Label" bundle="${ot_labels}"/></td>	
				<td class="columnHeader"><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></td>	
				<td class="columnHeader"><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
				<td class="columnHeader"><fmt:message key="Common.encounterdatetime.label" bundle="${common_labels}"/></td>

			</tr>
<%
			OtCommonGettersSetters getDets = new OtCommonGettersSetters();
			int i=0;
			for(i=0; i<getDetsForOrderIdsList.size(); i++)
			{
				getDets = (OtCommonGettersSetters) getDetsForOrderIdsList.get(i);
%>
				<tr>
					<td class="gridData">
						<input type="radio" name="primarySpeciality" id="primarySpeciality" value="<%=getDets.getOrderId()%>" onclick="assignValue('<%=getDets.getOrderId()%>','<%=i%>');">
					</td>
					<td class="gridData"> <%=getDets.getSurgeryType()%> </td>
					<td class="gridData"><%=getDets.getOperShortDesc()%></td>
					<td class="gridData"><%=getDets.getPreferSurgeryDate()%></td>
					<td class="gridData"> <%=getDets.getSpecialityDesc()%> </td>
					<td class="gridData"> <%=getDets.getSurgeonName()%> </td>
					<td class="gridData"> <%=getDets.getAnesthesiaRequired()%> </td>
					<td class="gridData"> <%=getDets.getPatientClass()%> </td>
					<td class="gridData"> <%=getDets.getEncounterId()%> </td>
					<td class="gridData"> <%=getDets.getEncounterDateTime()%> </td>
				</tr>
				<!--vikash start for MMS-CRF-186 Anesthesia Warning Message-->
				<input type="hidden" name="OrderID<%=i%>" id="OrderID<%=i%>" id="OrderID<%=i%>" value="<%=getDets.getOrderId()%>">
				<input type="hidden" name="Anaesthesia<%=i%>" id="Anaesthesia<%=i%>" id="Anaesthesia<%=i%>" value="<%=getDets.getAnesthesiaRequired()%>">				
				<!--vikash End for MMS-CRF-186 Anesthesia Warning Message-->
<%
			}
%>
<input type="hidden" name="TotalRecord" id="TotalRecord" id="TotalRecord" value="<%=i%>">
		</table>
		<table width="100%" border="0" cellspacing="0" cellpadding="3" align="center">
			<tr>
				<td class="button"  colspan="3"  align="right">
					<input type="button" class="button" name="ok" id="ok" id="ok" value ="OK" onclick="closePrimary();"disabled="true">
					<input type="button" class="button" name="close" id="close" value ="Close" onclick="window.close()">
				</td>
		</table>
		<input type="hidden" name="selectedOrderId" id="selectedOrderId" id="selectedOrderId" value="">
		<input type="hidden" name="selectedRow" id="selectedRow" id="selectedRow" value="">
	</form>
</body>
 

