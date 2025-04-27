<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>

 <%@ page import = "java.util.*" %>
 <%@ page import = "com.google.gson.*" %>
 <%@ page import = "eIPAD.chartsummary.allergies.response.EventTypeResponse" %>
 <%@ page import="eIPAD.chartsummary.allergies.healthobject.*"%>
 <%@ page import="eIPAD.chartsummary.common.response.ErrorInfo"%>
 <%@ page import ="eIPAD.chartsummary.common.healthobject.PatContext" %>
 <%@ page import="eIPAD.chartsummary.allergies.response.AllergyResponse"%>
<%@ page import="eIPAD.chartsummary.allergies.healthobject.Allergy"%>
<%@ page import="eIPAD.chartsummary.allergies.healthobject.Reaction"%>
<%@ page import="eIPAD.chartsummary.common.response.ErrorInfo"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="path" value="${pageContext.request.contextPath}"/>
<%
Locale appLocale;
if(session.getAttribute("LOCALE")!=null && !session.getAttribute("LOCALE").equals(""))
	appLocale = new Locale((String)session.getAttribute("LOCALE"));
else 
	appLocale = new Locale("en");
ResourceBundle csResBundle = ResourceBundle.getBundle("eIPAD.chartsummary.common.resourcebundle.cslabels", appLocale); 
%>

<%

String patientDOB="";
PatContext patContext= (PatContext)session.getAttribute("PatientContext");
if(patContext!=null){
	patientDOB = patContext.getDob();
}
%>
<!DOCTYPE html> 
<html> 
<head> 
<title></title>   
<meta name="apple-mobile-web-app-capable" content="yes" />   
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
  <link rel="stylesheet" href="${path}/eIPAD/jquery.mobile-1.0.1.min.css" /> 

<link rel="stylesheet" href="${path}/eIPAD/css/kendo.common.min.css" /> 
<link rel="stylesheet" href="${path}/eIPAD/css/kendo.default.min.css" />  
<script src="${path}/eIPAD/jquery-1.9.1.js"></script> 
  <script src="${path}/eIPAD/kendo.web.min.js"></script>
 <script src="${path}/eIPAD/console.js"></script>
<script src="${path}/eIPAD/jquery.mobile-1.0.1.min.js"></script>
<link rel="stylesheet" href="${path}/eIPAD/css/iPADNew.css" /> 
<link rel="stylesheet" href="${path}/eIPAD/css/iPADThemeA.css" /> 
<script type="application/javascript" src="${path}/eIPAD/js/iscroll.js"></script>
<%-- <script type="application/javascript" src="${path}/eIPAD/js/ChartSummaryValidation.js"></script> --%>
<script type="application/javascript" src="${path}/eIPAD/js/AllergyTransaction.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>

document.addEventListener('touchmove', function (e) { e.preventDefault(); }, false);
document.addEventListener('DOMContentLoaded', allergyScroll, false);


</script>
<style>

</style>
</head>

<%
AllergyResponse allergyResponse = (AllergyResponse)request.getAttribute("AllergyResponse");
boolean isSuccessResponse = allergyResponse.isSuccessResponse();
boolean isEmptyResponse = false;
ArrayList<ErrorInfo> errorList = new ArrayList<ErrorInfo>();
List<Allergy> allergyList = new ArrayList<Allergy>();
List<Reaction> reactionList = new ArrayList<Reaction>();
allergyList = allergyResponse.getAllergyDetails();
errorList = allergyResponse.getErrorsList();

//setting current date in dd/mm/yyyy hh:mm
java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm");
String today = dateFormat.format(new java.util.Date());
		
if(allergyList==null || allergyList.isEmpty())
	isEmptyResponse = true;
%>
<body >
	<div id="divParent" class = "divParent" data-role="page" style = "padding:0px">
		<form name = "frmRecordAllergy" id = "frmRecordAllergy" method = "post" style = "width:100%;height:100%" action="${path}/mobile/chartsummary/AllergyTransactionServlet">
			<!-- Remove reaction -->
			 <div data-role = "none" id = "dvMez" class = "blurPopup" data-popid=""></div>
			 <div id = "sfsarrowUp" data-role = "none" class = "RA-sfs-bubble-arrow RA-sfs-bubble-UpArrowTheme" ></div>
			 <div id = "sfsarrowDown" data-role = "none" class = "RA-sfs-bubble-arrowDown RA-sfs-bubble-DownArrowTheme" ></div>
			 <div id = "dvRemoveReaction" data-role = "none" class = "dvRemoveReaction dvRemoveReactionTheme" onclick = "deleteReaction(this)">Remove</div>
			 <div id = "sfsarrowUpError" data-role = "none" class = "RA-sfs-bubble-arrow RA-sfs-bubble-UpArrowTheme" ></div>
			 <div id = "sfsarrowDownError" data-role = "none" class = "RA-sfs-bubble-arrowDown RA-sfs-bubble-DownArrowTheme" ></div>
			 <div id = "dvMarkAsError" data-role = "none" class = "dvRemoveReaction dvRemoveReactionTheme" onclick = "errorReaction(this)">Mark As Error</div>
			<!-- Remove reaction end --->
		<!-- popup container -->
		   <div data-role = "none" class = "allergenSfs sfsIPTheme"  id = "sfs" >
  	 			<iframe id = "sfsFrame" frameborder="0" style = "display:block;" scrolling ="no" class="popupIFrame" src = ""></iframe>  
   		  </div> 
		 <!-- popup container ends -->  
			<div id = "allergyHeader"  class = "AllergyHeader" style="padding:0px" data-role = "none">
			  <table cellpadding = "0" cellspacing = "0" class = "tbAllergyHeader" data-role = "none">
			  	
			  	<tr class = "normalTr">
			  		<td class = "normalTd">
			  			<div class = "RecordAllergyHeader RecordAllergyHeaderTheme">
			  				<div class = "RecordAllergyTable">
							  		<div class = "normalRow">
							  			<div class = "AllergyCell" style = "width:99%;text-align:left">
							  			  <div class = "allergyHeaderPageTitle ipHeaderPageTitleTheme">Modify Allergy</div><!-- TODO localize -->
							  			</div>
							  			<div class = "AllergyCell" style = "width:1%">
							  			  <div class = "RecordAllergyTable">
							  			  	<div class = "normalRow">
							  			  		<div class = "AllergyCell" style = "width:auto;text-align:right">
							  			  			<div class = "buttonContainer">
							  			  				<div class = "WidgetButtonTheme" id="RecordAllergySubmitButton" onclick="validateAndModifyAllergy()"><img src = "${path}/eIPAD/images/CS_Ok16x16.png"/></div>
							  			  			</div>
							  			  		</div>
							  			  		<div class = "AllergyCell" style = "width:auto;text-align:right">
							  			  			<div class = "buttonContainer">
							  			  				<div class = "WidgetButtonTheme" onclick="cancelTransaction()"><img src = "${path}/eIPAD/images/CS_Close16x16.png"/></div>
							  			  			</div>
							  			  		</div>
							  			  	</div>
							  			  </div>
							  			</div>
							  		</div>
							  	</div>
			  			</div>
			  		</td>
			  	</tr>
			  </table>
			</div>
		
		   
			<div id = "divcnt"  class = "divAllergyContent divAllergyContentTheme" style="padding:0px;overflow:hidden" data-role = "none">
				<div style = "width:100%;height:auto;overflow:auto" data-role = "none">
					<% if(isSuccessResponse && !isEmptyResponse) {
							Allergy currentAllergy = allergyList.get(0);
							
							String estimatedDurationYN = currentAllergy.isEstimatedDuration()?"Y":"N";
					%>
					<input type = "hidden" name = "existingReactionCount" id = "existingReactionCount" value = "<%=currentAllergy.getReactions().size()%>" />
								<!-- Allergy widget content starts here -->
					<div class="AllergyContentTable WidgetContentStripTheme" id="AllergyContentTable" data-allergencode="<%=currentAllergy.getAllergenCode()%>" data-role = "none">
						<div class="AllergyContentRow AllergyContentRowTheme" data-role = "none">
							<div class="AllergyContentCol1 WidgetContentStripCol1Theme" data-role = "none">
								<div class="AllergyReactionCount WidgetContentStripCol1BoxTheme" data-role = "none">
									<img src="${path}/eIPAD/images/Refresh_black.png" class="AllergyReactionCountImage">
								</div>
							</div>
							<div class="AllergyContentCol2" data-role = "none">
								<div class="WidgetParaHeadTextTheme AllergyEventTypeText" data-role = "none"><%=currentAllergy.getAllergyEventDesc() %></div>
								<div class="WidgetNormalTextTheme AllergyAllergenText" data-role = "none"><%=currentAllergy.getAllergenDesc() %></div>
							</div>
							<div class="AllergyContentCol3" data-role = "none">
								<div class="AllergyEventExpandCollapse" data-role = "none">
								</div>
								<%if(currentAllergy.isEstimatedDuration()) {%>
									<div class="AllergyEstDurationIcon"><img src="${path}/eIPAD/images/Yellow Bullet.png" class="AlleryEstDurationImage"></div>
								<%} %>
								<div class="WidgetDateTextTheme" data-role = "none"><%=currentAllergy.getOnsetDate() %></div>
							</div>
						</div>
					</div>
					
					<!-- Add Reaction content starts -->
					<div data-role = "none" style = "width:100%;height:auto" id="dvRContent"> 
					<!-- reaction header starts -->
						<div data-role = "none" class = "reactionHeader">
							<table style = "height:100%;width:100%" cellspacing = "0" cellpadding = "0" border = "0" data-role = "none">
								<tr style = "height:100%;width:100%">
									<td style = "height:100%;width:100%" valign = "middle">
										
											<span class = "spanAllergyDetailsHeader" id="AllergyAllReactions_Label" data-role = "none">Reaction </span><font style = "color:red">*</font>
										
									</td>
									
								</tr>
							</table>
						</div>
						<!-- reaction header ends--> 
						
						<div class = "rowDivider"></div>
						
						<!-- reaction 1st row starts -->
						<div data-role = "none" class = "rowContainer">
							<table class = "tbRowContainer" cellspacing = "0" cellpadding = "0" border = "0" data-role = "none">
								<tr class = "normalTr">
									<td class = "reactionTd" valign = "middle" >
										<div data-role = "none" class = "divReaction divReactionTheme">
										<%--  <span class = "spanReaction"><%=csResBundle.getString("allergy.enterReaction")%></span> --%>
										<input type="text" data-role="none" class="txtContent" name="txtReactionSearch" id="txtReactionSearch" id="txtReactionSearch" placeholder="<%=csResBundle.getString("allergy.enterReaction")%>"/>
										</div>									
									</td>
									<td class = "reactionSmallTd" valign = "middle" align = "right">
										<div data-role = "none" class = "addReactionDiv" onclick="showReactionSfs()"></div>
									</td>
									
								</tr>
							</table>
						</div>
					</div> <!-- Reaction content ends --> 
					
					<% StringBuffer reactionCodesSB = new StringBuffer();%> <!-- Adding all existing reaction codes to this String with seperator `-->
					<!-- Existing Reactions List starts -->
						<% reactionList = currentAllergy.getReactions();
							if(reactionList != null && !reactionList.isEmpty())
							{
						%>
					<div style="margin-left:10px;margin-top:10px;">
						<div class="AllergyReactionTable AllergyReactionTableTheme" style="width:100%" data-role = "none">
							<%
								for(int j=0; j<reactionList.size(); j++){
									Reaction currentReaction = reactionList.get(j);		
									reactionCodesSB.append(currentReaction.getReactionCode() + "`");
							%>

							<div class="AllergyReactionRow" data-role = "none">
								<div class="AllergyReactionCol1 WidgetContentStripCol1Theme" data-role = "none">
									<div  class="AllergyReactionSeverityCont" data-role = "none">
										<div class="AllergyReactionSeverityTable" data-role = "none">
										<%
										if(currentReaction.getSevereityDesc().equals("M") ){%>
											<div class="AllergyReactionSeverityRow" data-role = "none">
												<div class="AllergyReactionDiviCell" data-role = "none"><div class="AllergyReactionSeverityDiviTheme" data-role = "none"></div></div>
												<div class="AllergyReactionSeverityCell" data-role = "none"><div class="AllergyReactionSeverityOrangeTheme" data-role = "none"></div></div>
												<div class="AllergyReactionDiviCell" data-role = "none"><div class="AllergyReactionSeverityDiviTheme" data-role = "none"></div></div>
												<div class="AllergyReactionSeverityCell" data-role = "none"><div class="AllergyReactionSeverityGrayTheme" data-role = "none"></div></div>
												<div class="AllergyReactionDiviCell" data-role = "none"><div class="AllergyReactionSeverityDiviTheme" data-role = "none"></div></div>
												<div class="AllergyReactionSeverityCell" data-role = "none"><div class="AllergyReactionSeverityGrayTheme" data-role = "none"></div></div>
												<div class="AllergyReactionDiviCell" data-role = "none"><div class="AllergyReactionSeverityDiviTheme" data-role = "none"></div></div>
											</div>
										<%
										}
										else if(currentReaction.getSevereityDesc().equals("O")){
										%>
											<div class="AllergyReactionSeverityRow" data-role = "none">
												<div class="AllergyReactionDiviCell" data-role = "none"><div class="AllergyReactionSeverityDiviTheme" data-role = "none"></div></div>
												<div class="AllergyReactionSeverityCell" data-role = "none"><div class="AllergyReactionSeverityOrangeTheme" data-role = "none"></div></div>
												<div class="AllergyReactionDiviCell" data-role = "none"><div class="AllergyReactionSeverityDiviTheme" data-role = "none"></div></div>
												<div class="AllergyReactionSeverityCell" data-role = "none"><div class="AllergyReactionSeverityOrangeTheme" data-role = "none"></div></div>
												<div class="AllergyReactionDiviCell" data-role = "none"><div class="AllergyReactionSeverityDiviTheme" data-role = "none"></div></div>
												<div class="AllergyReactionSeverityCell" data-role = "none"><div class="AllergyReactionSeverityGrayTheme" data-role = "none"></div></div>
												<div class="AllergyReactionDiviCell" data-role = "none"><div class="AllergyReactionSeverityDiviTheme" data-role = "none"></div></div>
											</div>
										<%
										}
										else if(currentReaction.getSevereityDesc().equals("S")){
										%>
											<div class="AllergyReactionSeverityRow" data-role = "none">
												<div class="AllergyReactionDiviCell" data-role = "none"><div class="AllergyReactionSeverityDiviTheme" data-role = "none"></div></div>
												<div class="AllergyReactionSeverityCell" data-role = "none"><div class="AllergyReactionSeverityOrangeTheme" data-role = "none"></div></div>
												<div class="AllergyReactionDiviCell" data-role = "none"><div class="AllergyReactionSeverityDiviTheme" data-role = "none"></div></div>
												<div class="AllergyReactionSeverityCell" data-role = "none"><div class="AllergyReactionSeverityOrangeTheme" data-role = "none"></div></div>
												<div class="AllergyReactionDiviCell" data-role = "none"><div class="AllergyReactionSeverityDiviTheme" data-role = "none"></div></div>
												<div class="AllergyReactionSeverityCell" data-role = "none"><div class="AllergyReactionSeverityOrangeTheme" data-role = "none"></div></div>
												<div class="AllergyReactionDiviCell" data-role = "none"><div class="AllergyReactionSeverityDiviTheme" data-role = "none"></div></div>
											</div>
										<%
										} 
										else{
										%>
											<div class="AllergyReactionSeverityRow" data-role = "none">
												<div class="AllergyReactionDiviCell" data-role = "none"><div class="AllergyReactionSeverityDiviTheme" data-role = "none"></div></div>
												<div class="AllergyReactionSeverityCell" data-role = "none"><div class="AllergyReactionSeverityGrayTheme" data-role = "none"></div></div>
												<div class="AllergyReactionDiviCell" data-role = "none"><div class="AllergyReactionSeverityDiviTheme" data-role = "none"></div></div>
												<div class="AllergyReactionSeverityCell" data-role = "none"><div class="AllergyReactionSeverityGrayTheme" data-role = "none"></div></div>
												<div class="AllergyReactionDiviCell" data-role = "none"><div class="AllergyReactionSeverityDiviTheme" data-role = "none"></div></div>
												<div class="AllergyReactionSeverityCell" data-role = "none"><div class="AllergyReactionSeverityGrayTheme" data-role = "none"></div></div>
												<div class="AllergyReactionDiviCell" data-role = "none"><div class="AllergyReactionSeverityDiviTheme" data-role = "none"></div></div>
											</div>
										<%
										} %>
										</div>
									</div>
									<div class="WidgetSmallTextTheme" data-role = "none"><%=csResBundle.getString("allergy.severity") %></div>
								</div>
								<div class="AllergyReactionCol2 AllergyReactionCol2Theme WidgetContentStripTheme" data-role = "none">
									<div class="AllergyReactionDescTheme" data-role = "none"><%=currentReaction.getReactionDesc() %></div>
									<div class="AllergyReactionSiteTheme" data-role = "none"><%=currentReaction.getReactionSite() %></div>
								</div>
								<div class="AllergyReactionCol3 AllergyReactionCol3Theme WidgetContentStripTheme" data-role = "none">
									<div class="WidgetDateText2Theme" data-role = "none"><%=currentReaction.getReactionDate() %></div>
								</div>
								<div class="" style="display:table-cell;width:8%">
									<div data-role = "none" id ="errorReaction<%=j%>" class = "errorReaction removeReactionTheme" onclick = "showMarkAsErrorBubble(this)" style="margin-left:50%" data-id="<%=j%>" data-error="N"></div>
								</div>
							</div>
							<input type = "hidden" name = "existingReactionCode<%=j%>" id = "existingReactionCode<%=j%>" value="<%=currentReaction.getReactionCode()%>"/>
							<input type = "hidden" name = "existingReactionDesc<%=j%>" id = "existingReactionDesc<%=j%>" value="<%=currentReaction.getReactionDesc()%>"/>
							<input type = "hidden" name = "existingReactionSrlNo<%=j%>" id = "existingReactionSrlNo<%=j%>" value="<%=currentReaction.getReactionSerNo()%>"/>
							<% } %>
						</div>
					</div>
					<!-- Existing Reactions List ends here -->
					
					<!-- Allergy widget content ends here -->
					<% 		
							} 
							
							String reactioncodes = reactionCodesSB.substring(0, (reactionCodesSB.length()-1));%> <!-- removing the last ` character -->
						<script> arrReactionCode = ('<%=reactioncodes%>').split('`')</script>
					<input type = "hidden" name = "hdnHypSensitivity" id = "hdnHypSensitivity" value = "<%=currentAllergy.getAllergyEventTypeInd()%>" />
					<input type = "hidden" name = "hdnEventTypeCode" id = "hdnEventTypeCode" value = "<%=currentAllergy.getAllergyEventCode()%>" />
					<input type = "hidden" name = "hdnEventTypeCodeValue" id ="hdnEventTypeCodeValue" value="<%=currentAllergy.getAllergyEventDesc()%>" />
					<input type = "hidden" name = "hdnSfsType" id = "hdnSfsType"  />
					<input type = "hidden" name = "hdnAllergenCode" id = "hdnAllergenCode" value="<%=currentAllergy.getAllergenCode()%>" />
					<input type = "hidden" name = "hdnCACode" id = "hdnCACode" value="" /> <!-- drug code is always passed as empty in MODIFY-->
					<input type = "hidden" name = "hdnReactionCount" id = "hdnReactionCount" />
					<input type = "hidden" name = "hdnAddedReactionId" id = "hdnAddedReactionId" />
					<input type = "hidden" name = "hdnEstimatedDuration" id = "hdnEstimatedDuration" value = "<%=estimatedDurationYN%>"/>
					<input type = "hidden" name = "hdnTransactionMode" id = "hdnTransactionMode" value = "MODIFY"/>
					<input type = "hidden" name = "hdnOnsetDateTime" id = "hdnOnsetDateTime" value="<%=currentAllergy.getOnsetDate()%>"/>
					<input type = "hidden" name = "hdnActiveSinceDate" id = "hdnActiveSinceDate" value="<%=currentAllergy.getActiveDate()%>"/>
					
					<input type = "hidden" name = "certainity" id = "certainity" value="<%=currentAllergy.getCertainity()%>"/>
					<input type = "hidden" name = "status1" id = "status1" value="<%=currentAllergy.getAllergyStatus()%>"/>
					<input type = "hidden" name = "diagnosis_code" id = "diagnosis_code" value="<%=currentAllergy.getDiagnosisCode()%>"/>
					<input type = "hidden" name = "remarks" id = "remarks" value="<%=currentAllergy.getRemarks()%>"/>
					<input type = "hidden" name = "no_known_allergy" id = "no_known_allergy" value=""/> <!-- no_known_allergy is always passed as empty in MODIFY-->
					<input type = "hidden" name = "sou_of_info" id = "sou_of_info" value="<%=currentAllergy.getInformationSource()%>"/>
					<input type = "hidden" name = "err_remarks" id = "err_remarks" value=""/><!-- err_remarks is always passed as empty in MODIFY since there is no provision in EM-Mobile to mark an allergy as error-->
					<input type = "hidden" name = "Site_Of_Reac" id = "Site_Of_Reac" value=""/><!-- Site_Of_Reac is always passed as empty and is passed in MODIFY alone-->
					<input type = "hidden" name = "treat_advice" id = "treat_advice" value="<%=currentAllergy.getTreatmentAdvice()%>"/>
					<input type = "hidden" name = "cause_sub" id = "cause_sub" value="<%=currentAllergy.getCausativeSubstance()%>"/>
					<input type = "hidden" name = "severity" id = "severity" value=""/> <!-- this value is not used in the EJB RecordAdverseEventManager. Specifying it here inorder to maintain consistency -->
					<input type = "hidden" name = "route_exp" id = "route_exp" value="<%=currentAllergy.getRouteOfExposure()%>"/>
					<input type = "hidden" name = "allergy_test_res" id = "allergy_test_res" value="<%=currentAllergy.getAllergyTestResult()%>"/>
					<input type = "hidden" name = "drug_code" id = "drug_code" value=""/><!-- Site_Of_Reac is always passed as empty in MODIFY-->
					<input type = "hidden" name = "chkreact1" id = "chkreact1" value="N"/><!-- chkreact1 is always passed as "N" in MODIFY but this value is not used in the EJB RecordAdverseEventManager -->
					<input type = "hidden" name = "reaction_date" id = "reaction_date" value=""/><!-- reaction_date is passed with some date in MODIFY but this value is not used in the EJB RecordAdverseEventManager -->
					<input type = "hidden" name = "certainity" id = "certainity" value="<%=currentAllergy.getCertainity()%>"/>
					
					<input type = "hidden" name = "today" id = "today" value="<%=today%>"/>
					<input type = "hidden" name = "patientDOB" id = "patientDOB" value="<%=patientDOB%>"/>
					
					
					
					<input type = "hidden" name = "hdnReactionsToAdd" id = "hdnReactionsToAdd" value=""/>
					<input type = "hidden" name = "hdnErrorReactions" id = "hdnErrorReactions" value=""/>
					<input type = "hidden" name = "hdnPath" id = "hdnPath" value = "${path}" />
					<%}
					else{%>
			
					<div class="AllergyErrorResponse">
						<%
						for(int k=0;k<errorList.size();k++){
						%>
						<div class="WidgetErrorResponse"><%= errorList.get(k).getErrorMessage()%></div>
						<%} %>
					</div>
			<%} %>

				</div><!-- first child of the scroller control -->
				<!-- Mandatory fields error -->
				<div class="formValErrorTheme formValError" id="MandatoryFields_Error" style="bottom: 0px; left: 0px;display:none">
			  	 	<div class="formValErrorMsgTheme" id="MandatoryFields_ErrorMsg">All mandatory fields must be entered</div>
			  	 </div>
			  	 <div class="formValWarningTheme formValError" id="AllReactionsErrorMarked_Error" style="bottom: 0px; left: 0px;display:none">
			  	 	<div class="formValErrorMsgTheme" id="MandatoryFields_ErrorMsg">All reactions cannot be marked as error</div>
			  	 </div>
			</div><!-- scrolling div ends -->

		</form>
	</div>
</body>
</html>

