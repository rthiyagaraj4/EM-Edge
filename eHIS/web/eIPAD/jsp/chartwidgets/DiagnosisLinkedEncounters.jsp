<!DOCTYPE html>
<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@page import="java.util.*,javax.servlet.http.HttpSession"%>
<%@page import="eIPAD.chartsummary.encounterlist.response.EncounterListResponse"%>
<%@page import="eIPAD.chartsummary.common.response.ErrorInfo"%>
<%@page import="eIPAD.chartsummary.encounterlist.healthobject.EncounterHO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<script>

</script>

<%
EncounterListResponse leResponse = (EncounterListResponse)request.getAttribute("LinkedEncounterResponse");
boolean isSuccessResponse = false;
boolean isEmptyResponse = true;
ArrayList<ErrorInfo> errorList = new ArrayList<ErrorInfo>();
List<EncounterHO> leList = new ArrayList<EncounterHO>();
if(leResponse!=null){
	isSuccessResponse = leResponse.isSuccessResponse();
	isEmptyResponse = leResponse.isEmptyDataResponse();
	leList = leResponse.getEncounterList();
	errorList = leResponse.getErrorsList();
	if(leList!=null && !leList.isEmpty())
		isEmptyResponse = false;
}
%>
<% if(isSuccessResponse && !isEmptyResponse) {
	for(int i=0;i<leList.size();i++){
		EncounterHO currentLE = leList.get(i);
		
%>
<div class="LinkPopupParent" style="position:relative;" data-role = "none">
	<div class="LinkPopupTable" onclick="chooseEncounter('<%=currentLE.getEncounterId()%>')">
		<div class="LinkPopupTableRow LinkPopupContentStripTheme" style="height:40px;">
			<div class="" style="display:table-cell;width:45px;vertical-align:middle;text-align:center">
				<%if(currentLE.getPatientClass().equals("IP")){ %>
				<img src="${path}/eIPAD/images/inPatient32x32.png">
				<%}else if(currentLE.getPatientClass().equals("OP")){ %>
				<img src="${path}/eIPAD/images/OutPatient32x32.png">
				<%} %>
			</div>
			<div class="" style="display:table-cell;vertical-align:middle">
				<div class="LinkPopupText1Theme" style="padding-left:4px"><%=currentLE.getPractShortName() %></div>
				<div class="LinkPopupText2Theme" style="padding-left:4px"><%=currentLE.getEncounterId()%></div>
			</div>
			<div class="" style="display:table-cell;vertical-align:bottom;text-align:right">
				<div class="LinkPopupText2Theme" style="padding-right:4px;padding-bottom:4px;"><%=currentLE.getVisitDate()%></div>
			</div>
		</div>
	</div>
</div>
<%	}
}
else{%>
<div class="PDErrorResponse">
	<div class="WidgetErrorResponse WidgetErrorResponseTheme">
	<%
	for(int k=0;k<errorList.size();k++){
	%>
	<%= errorList.get(k).getErrorMessage()%><br>
	<%} %>
	</div>
</div>
<%} %>
