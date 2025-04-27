<!DOCTYPE html>
<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@page import="java.util.*,javax.servlet.http.HttpSession"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.LinkedHashMap"%>
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


<style>
#PageLoadingAnimation{
	z-index: 10000;
	position: absolute;
	left: 0px;
	top: 0px;
	width: 100%;
	height: 100%;
	background-color: #808080;
	opacity: 0.6;
	background-image: url(${path}/eIPAD/images/Loading24x24.gif);
	background-repeat: no-repeat;
	background-position: 50% 50%;
	display: none; 
}

</style>


<script>
//this variable is maintained for showing only one modify button at a time
var modifyButtonShown = 0;
$(document)
.ready(
		function() {
			$(".AllergyContentTable").on("dblclick swipeleft", function() {
				//var allergencode = $(this).data("allergencode");
				//var allergyeventcode = $(this).data("allergyeventcode");
				//var allergyeventtypeind = $(this).data("allergyeventtypeind");
				//$("#AllergyModifyButton"+allergencode+"_"+allergyeventcode+"_"+allergyeventtypeind).show();
				
				var allergyModButCount = $(this).data("count");
				$("#AllergyModifyButton"+modifyButtonShown).hide();
				$("#AllergyModifyButton"+allergyModButCount).show();
				highlightAllergy(allergyModButCount);
				modifyButtonShown = allergyModButCount;

			});
			$(".AllergyContentTable").on("swiperight", function() {
	
				var allergyModButCount = $(this).data("count");
				//$("#AllergyModifyButton"+modifyButtonShown).hide();
				$("#AllergyModifyButton"+allergyModButCount).hide();
				highlightAllergy(allergyModButCount);

			});
		});
function expCollAllergy(count){
	$('#AllergyReactionTable'+count).toggle();
	//$('#AllergyContentTable'+count).toggleClass('WidgetContentStripTheme');
	//$('#AllergyContentTable'+count).toggleClass('WidgetContentStripSelTheme');
	if(($('#ExpCollAllergy'+count).attr("src")).indexOf("Expandview") >=0)
		$('#ExpCollAllergy'+count).attr("src","${path}/eIPAD/images/Collapseview.png")
	else if(($('#ExpCollAllergy'+count).attr("src")).indexOf("Collapseview") >=0)
		$('#ExpCollAllergy'+count).attr("src","${path}/eIPAD/images/Expandview.png")
	scrollerRefresh(CSMainScroll);
}

function modifyAllergy(allergencode,date){
	$("input[id=hdnModifyAllergyCode]").val(allergencode);
	$("input[id=hdnModifyAllergyDate]").val(date);
	$('#frmIcontent').attr("action", "${path}/chartsummary/RecordAllergyView");
}
function openRecordAllergyFrame(){
	$("#PageLoadingAnimation").show();
	window.parent.document.getElementById('ChartSummaryIframe').src = '${path}/chartsummary/RecordAllergyView';
	
}
function openModifyAllergyFrame(allergen,eventCode,eventInd){
	window.parent.document.getElementById('ChartSummaryIframe').src = '${path}/chartsummary/ModifyAllergyView?allergencode='+allergen+'&eventcode='+eventCode+'&eventind='+eventInd;
	
}
//this variable is maintained for highlighting only one allergy at a time
var hightlightedAllergy=0;
function highlightAllergy(count){
	$('#AllergyContentTable'+hightlightedAllergy).removeClass('WidgetContentStripSelTheme').addClass('WidgetContentStripTheme');
	$('#AllergyContentTable'+count).removeClass('WidgetContentStripTheme').addClass('WidgetContentStripSelTheme');
	hightlightedAllergy = count;
}

function testmove(){
	$("#VitalsFrame").prependTo("#ChartSummaryMainScroller");
}

</script>

<%
AllergyResponse allergyResponse = (AllergyResponse)request.getAttribute("AllergyResponse");
boolean isSuccessResponse = false;
boolean isEmptyResponse = true;
ArrayList<ErrorInfo> errorList = new ArrayList<ErrorInfo>();
List<Allergy> allergyList = new ArrayList<Allergy>();
List<Reaction> reactionList = new ArrayList<Reaction>();
if(allergyResponse!=null){
	isSuccessResponse = allergyResponse.isSuccessResponse();
	allergyList = allergyResponse.getAllergyDetails();
	errorList = allergyResponse.getErrorsList();
	if(allergyList!=null && !allergyList.isEmpty())
		isEmptyResponse = false;
}
%>
<div id="PageLoadingAnimation" > </div>
	<div class="widgetParent widgetParentTheme" data-role = "none">
<!-- 	<form id="AllergyWidgetForm" class="AllergyWidgetForm" action="" method="post" name="AllergyWidgetForm" id="AllergyWidgetForm"> -->
		<div class="widgetTable" data-role = "none">
			<div class="widgetHeaderRow widgetHeaderRowTheme" data-role = "none">
				<div class="widgetHeaderMarginCell" data-role = "none">
					<div class="widgetHeaderMarginExtn widgetHeaderMarginExtnTheme" data-role = "none"></div>
					<div class="widgetHeaderIcontriangle" data-role = "none"></div>
				</div>
				<div class="widgetHeaderCell widgetHeaderCellTheme" data-role = "none">
					<div class="widgetHeaderSubTable" data-role = "none">
						<div class="widgetHeaderSubRow" data-role = "none">
							<div class="widgetHeaderIconCol1" data-role = "none">
								<div class="widgetHeaderIconButton widgetHeaderIconButtonTheme" data-role = "none"><img src="${path}/eIPAD/images/CS_Allergies.PNG" class="widgetHeaderButtonImage"></div>
								
							</div>

							<div class="widgetHeaderHeadingTextCol" data-role = "none"><span class="widgetHeaderHeadingTextTheme" data-role = "none"><%=csResBundle.getString("allergy.allergies") %></span> <input type="button" class="widgetHeaderCountButtonTheme" id="allergyViewCount" value="<%=allergyList.size()%>" onclick="testmove()"></div>
							<div class="widgetHeaderPlusButtonCell" data-role = "none">
								<div class="WidgetButtonTheme" data-role = "none" onclick="openRecordAllergyFrame()"><img src="${path}/eIPAD/images/CS_add16x16.png"></div>
							</div>
						</div>
					</div>
				</div>
			</div>


			<div class="widgetContentRow" data-role = "none">
				<div class="widgetHeaderMarginCell" data-role = "none">
				</div>
				<div class="widgetContentCell widgetContentCellTheme" data-role = "none">
					<% if(isSuccessResponse && !isEmptyResponse) {
						for(int i=0;i<allergyList.size();i++){
							Allergy currentAllergy = allergyList.get(i);
							String allergyUniqueStr = currentAllergy.getAllergyEventDesc() + currentAllergy.getAllergenDesc() + currentAllergy.getOnsetDate();
						
					%>
								<!-- Allergy widget content starts here -->
					<div class="AllergyContentTable WidgetContentStripTheme" id="AllergyContentTable<%=i+1 %>" data-count="<%=i+1 %>" data-allergencode="<%=currentAllergy.getAllergenCode()%>" data-allergyeventcode="<%=currentAllergy.getAllergyEventCode()%>" data-allergyeventtypeind="<%=currentAllergy.getAllergyEventTypeInd()%>" data-role = "none" onclick="highlightAllergy('<%=i+1 %>')">
						<div class="AllergyContentRow AllergyContentRowTheme" data-role = "none">
							<div class="AllergyContentCol1 WidgetContentStripCol1Theme" data-role = "none">
								<div class="AllergyReactionCount WidgetContentStripCol1BoxTheme" data-role = "none">
									<div class="AllergyReactionCountCircleTheme" data-role = "none">
									<!-- Add an extra 0 to front if count is in 1 digit -->
									<%if(currentAllergy.getCount()<10){ %>
										<div class="AllergyReactionCountCircleText" data-role = "none">0<%=currentAllergy.getCount()%></div>
									<%}else{ %>
										<div class="AllergyReactionCountCircleText" data-role = "none"><%=currentAllergy.getCount()%></div>
									<%} %>
									</div>
									<img src="${path}/eIPAD/images/Allergy16x16.png" class="AllergyReactionCountImage">
								</div>
							</div>
							<div class="AllergyContentCol2" data-role = "none">
								<div class="WidgetParaHeadTextTheme AllergyEventTypeText" data-role = "none"><%=currentAllergy.getAllergenDesc() %></div>
								<div class="WidgetNormalTextTheme AllergyAllergenText" data-role = "none"><%=currentAllergy.getAllergyEventDesc() %></div>
							</div>
							<div class="AllergyContentCol3" data-role = "none">
								<div class="AllergyEventExpandCollapse" data-role = "none">
									<div class="SfsHeaderButtonTheme" style="display:none" id="AllergyModifyButton<%=i+1 %>" 
										onclick="openModifyAllergyFrame('<%=currentAllergy.getAllergenCode()%>','<%=currentAllergy.getAllergyEventCode()%>','<%=currentAllergy.getAllergyEventTypeInd()%>')">
										<%=csResBundle.getString("common.modify") %>
									</div>
									<img src="${path}/eIPAD/images/Expandview.png" class="AllergyEventExpandCollapseImage" id="ExpCollAllergy<%=i+1 %>" onclick="expCollAllergy('<%=i+1 %>')">
								</div>
								<%if(currentAllergy.isEstimatedDuration()) {%>
									<div class="AllergyEstDurationIcon"><img src="${path}/eIPAD/images/Yellow Bullet.png" class="AlleryEstDurationImage"></div>
								<%} %>
								<div class="WidgetDateTextTheme" data-role = "none"><%=currentAllergy.getOnsetDate() %></div>
							</div>
						</div>
					</div>
						<% reactionList = currentAllergy.getReactions();
							if(reactionList != null && !reactionList.isEmpty())
							{
								boolean severe=false;
						%>
					<div style="display:none" id="AllergyReactionTable<%= i+1 %>" class="AllergyReacOutContTheme">
						<div style="display:table;width:100%;">
							<div class="AllergyReactionTableContainer AllergyReacContTheme"  data-role = "none">
								
									<%
										for(int j=0; j<reactionList.size(); j++){
											Reaction currentReaction = reactionList.get(j);							
									%>
								<div class="AllergyReactionTable AllergyReactionTableTheme WidgetContentStripTheme" data-role = "none">
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
										<div class="AllergyReactionCol2 AllergyReactionCol2Theme" data-role = "none">
											<div class="AllergyReactionDescTheme" data-role = "none"><%=currentReaction.getReactionDesc() %></div>
											<div class="AllergyReactionSiteTheme" data-role = "none"><%=currentReaction.getReactionSite() %></div>
										</div>
										<div class="AllergyReactionCol3 AllergyReactionCol3Theme" data-role = "none">
											<div class="WidgetDateText2Theme" data-role = "none"><%=currentReaction.getReactionDate() %></div>
										</div>
									</div>
								</div>
									<%
											if(currentReaction.getSevereityDesc().equals("S"))
												severe = true;
										}%>
									
									<% 
									//if there are severe reactions then the allergy record should be expanded by default
									if(severe){ %>
									<%-- <script>expCollAllergy('<%=i+1 %>');</script> --%>
									 <% } %> 
								
							</div>
						</div>
					</div>
					<!-- Allergy widget content ends here -->
					<% 		
							}
						}
					}
					else{%>
			
					<div class="WidgetVwErrContainer">
						<%
						for(int k=0;k<errorList.size();k++){
						%>
						<div class="WidgetErrorResponse WidgetErrorResponseTheme"><%= errorList.get(k).getErrorMessage()%></div>
						<%} %>
					</div>
			<%} %>
				</div>
			</div>
			
			
		</div>
<!-- 	</form> -->
	</div>

