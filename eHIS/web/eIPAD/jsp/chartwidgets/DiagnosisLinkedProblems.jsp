<!DOCTYPE html>
<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@page import="java.util.*,javax.servlet.http.HttpSession"%>
<%@ page import="eIPAD.chartsummary.common.response.ErrorInfo"%>
<%@page import="eIPAD.chartsummary.activeproblems.healthobject.ProblemsDiagnosisHO"%>
<%@page import="eIPAD.chartsummary.activeproblems.response.ProblemsDiagnosisResponse"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<script>

</script>

<%
ProblemsDiagnosisResponse lpResponse = (ProblemsDiagnosisResponse)request.getAttribute("LinkedProblemsResponse");
boolean isSuccessResponse = false;
boolean isEmptyResponse = true;
ArrayList<ErrorInfo> errorList = new ArrayList<ErrorInfo>();
List<ProblemsDiagnosisHO> lpList = new ArrayList<ProblemsDiagnosisHO>();
if(lpResponse!=null){
	isSuccessResponse = lpResponse.isSuccessResponse();
	isEmptyResponse = lpResponse.isEmptyDataResponse();
	lpList = lpResponse.getProblemsDiagnosisList();
	errorList = lpResponse.getErrorsList();
	if(lpList!=null && !lpList.isEmpty())
		isEmptyResponse = false;
}
%>
<% if(isSuccessResponse && !isEmptyResponse) {
	for(int i=0;i<lpList.size();i++){
		ProblemsDiagnosisHO currentLP = lpList.get(i);
		
%>
<div class="LinkPopupParent" style="position:relative;" data-role = "none">
	<div class="LinkPopupTable">
		<div class="LinkPopupTableRow LinkPopupContentStripTheme" style="height:40px;">
			<div class="" style="display:table-cell;vertical-align:middle">
				<div class="LinkPopupText1Theme" style="padding-left:8px"><%=currentLP.getDiagProbDesc() %></div>
			</div>
			<div class="" style="display:table-cell;vertical-align:middle;text-align:right">
				<div class="LinkPopupText2Theme" style="padding-right:6px;"><%=currentLP.getOnsetDate()%></div>
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
