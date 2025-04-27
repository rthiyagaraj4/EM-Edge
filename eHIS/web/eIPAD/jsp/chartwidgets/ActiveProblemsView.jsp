<!DOCTYPE html>
<%@page import="eIPAD.chartsummary.activeproblems.healthobject.ProblemsDiagnosisHO"%>
<%@page import="eIPAD.chartsummary.activeproblems.response.ProblemsDiagnosisResponse"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@page import="java.util.*,javax.servlet.http.HttpSession"%>
<%@ page import="java.util.ArrayList"%>
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
var pdModifyButtonShownId = 0;
$(document).ready(function(){
	$(".PDContentTable").on("dblclick swipeleft", function() {
		var thisButton = $(this).data('pdcount');
		if(pdModifyButtonShownId != thisButton){
			$("#PDModifyButton"+pdModifyButtonShownId).hide();
			$("#PDTable"+pdModifyButtonShownId).removeClass("WidgetContentStripSelTheme").addClass("WidgetContentStripTheme");
			$("#PDModifyButton"+thisButton).show();
			$("#PDTable"+thisButton).removeClass("WidgetContentStripTheme").addClass("WidgetContentStripSelTheme");
			pdModifyButtonShownId = thisButton;
		}
	});
	$(".PDContentTable").on("swiperight", function() {
		var thisButton = $(this).data('pdcount');
		$("#PDModifyButton"+thisButton).hide();
		$("#PDTable"+thisButton).removeClass("WidgetContentStripSelTheme").addClass("WidgetContentStripTheme");
		if(thisButton==pdModifyButtonShownId){
			pdModifyButtonShownId=0;
		}
		
	});
	
});
function showLinkedEncounters(obj,popupId){
	
	var buttonHeight = $(obj).height();
	var buttonWidth = $(obj).width();
	var popupObj = $("#"+popupId);
	var popupHeight = $(popupObj).height();
	var popupWidth = $(popupObj).width();
	var arrowHeight = $("#"+popupId+"-arrowUp").height();
    var top = $(obj).offset().top;
    var position = $(obj).position().top+buttonHeight;
    var positionLeft = $(obj).position().left - popupWidth + (buttonWidth/2);
    var positionRight = $(window).width() - positionLeft - popupWidth - + (buttonWidth/2);
    
    var popupTitle = $(obj).data("title");
    var linkurl = encodeURI($(obj).data("linkurl"));
    var scrollerId = popupId+"-contents";
    var wrapperId = popupId+"-wrapper";
    
    //clearing the contents
    $("#"+scrollerId).empty();
    
    if(top + popupHeight + 100 > $(window).height()){   //100 is the EM footer and Chart summary footer height
    	position = position - popupHeight - buttonHeight - arrowHeight;
    	top = $(window).height() - popupHeight - buttonHeight;
    	$("#"+popupId+"-arrowUp").hide();
    	$("#"+popupId+"-arrowDown").show();
    }
    else{
    	$("#"+popupId+"-arrowUp").show();
    	$("#"+popupId+"-arrowDown").hide();
    }
    
    //alert(popupTitle);
    $("#"+popupId+"-title").html(popupTitle);
    
    $(popupObj).css("top", position+"px");
    $(popupObj).css("right", positionRight+"px");
    $(popupObj).show();

    $("#"+scrollerId).load(linkurl, function(){
    	var LinkedECScroll;
    	LinkedECScroll = new iScroll(wrapperId, {
    		useTransform : true,
    		zoom : false,
    		onBeforeScrollStart : function(e) {
    			var target = e.target;
    			while (target.nodeType != 1) target = target.parentNode;

    			if (target.tagName != 'SELECT' && target.tagName != 'INPUT' && target.tagName != 'TEXTAREA' ){
    				e.preventDefault();
    			}

    			e.stopPropagation();
    		}
    	});
    	if(LinkedECScroll!=null){
    		LinkedECScroll.refresh();
    	}
    });

}


function openRecordPDFrame(){
	$("#PageLoadingAnimation").show();
	window.parent.document.getElementById('ChartSummaryIframe').src = '${path}/mobile/chartsummary/RecordDiagnosisView';
	// window.parent.document.getElementById('ChartSummaryIframe').src = '${path}/eIPAD/jsp/chartwidgets/RecordDiagnosis.jsp';
}
function openModifyDiagnosisFrame(diagSetId,diagCode,occurSrlNo){
	var params = 'DiagSetId='+diagSetId+'&DiagCode='+diagCode+'&OccurSrlNo='+occurSrlNo;
	window.parent.document.getElementById('ChartSummaryIframe').src = '${path}/mobile/chartsummary/ModifyDiagnosisView?'+params;
}

function openModifyComplaintFrame(complCode){
	var params = 'ComplaintCode='+complCode;
	window.parent.document.getElementById('ChartSummaryIframe').src = '${path}/mobile/chartsummary/ModifyComplaintView?'+params;
}
</script>

<%
ProblemsDiagnosisResponse pdResponse = (ProblemsDiagnosisResponse)request.getAttribute("ProblemsDiagnosisResponse");
boolean isSuccessResponse = false;
boolean isEmptyResponse = true;
ArrayList<ErrorInfo> errorList = new ArrayList<ErrorInfo>();
List<ProblemsDiagnosisHO> pdList = new ArrayList<ProblemsDiagnosisHO>();
if(pdResponse!=null){
	isSuccessResponse = pdResponse.isSuccessResponse();
	isEmptyResponse = pdResponse.isEmptyDataResponse();
	pdList = pdResponse.getProblemsDiagnosisList();
	errorList = pdResponse.getErrorsList();
	if(pdList!=null && !pdList.isEmpty())
		isEmptyResponse = false;
}
%>
<div id="PageLoadingAnimation" > </div>
	<div class="widgetParent widgetParentTheme" style="position:relative;" data-role = "none">
		<!-- Linked encounters/complaints popup starts -->
		<div id="PDLinkedECcontainer" class="PDLinkedECcontainer">
			<div id="PDLinkedECcontainer-arrowUp" class="PDLinkPopup-arrowUpTheme"></div>
			<div  class="PDLinkPopup PDLinkPopupTheme">
				<div style="display:table;width:100%">
					<div style="display:table-row">
						<div style="display:table-cell;height:40px">
							<div style="display:table" class="PDLinkPopupHeader PDLinkPopupHeaderTheme">
								<div style="display:table-row">
									<div style="display:table-cell;width:100px;vertical-align:middle;text-align:center">
										<div class="PDLinkPopupCloseBtnTheme" id="PDLinkPopupCloseBtn" onclick="closePopup('PDLinkedECcontainer')"><%=csResBundle.getString("common.close") %></div>
									</div>
									<div style="display:table-cell;width:80%;vertical-align:middle;text-align:center" class="PDLinkPopupHeaderTextTheme" id="PDLinkedECcontainer-title"></div>
								</div>
							</div>
						</div>
					</div>
					<div style="display:table-row">
						<div style="display:table-cell;width:100%;vertical-align:middle;">
							<div id="PDLinkedECcontainer-wrapper" class="PDLinkPopupWrapper">
								<div id="PDLinkedECcontainer-contents" class="PDLinkPopupContents">
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div id="PDLinkedECcontainer-arrowDown" class="PDLinkPopup-arrowDownTheme"></div>
		</div>
	<!-- Linked encounters/complaints popup ends -->
 	<form id="problemsDiagnosisForm" class="problemsDiagnosisForm" action="" method="post" name="problemsDiagnosisForm" id="problemsDiagnosisForm"> 
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
								<div class="widgetHeaderIconButton widgetHeaderIconButtonTheme" data-role = "none"><img src="${path}/eIPAD/images/CS_Active_Problems_32x32.png" class="widgetHeaderButtonImage"></div>
								
							</div>
<!-- 							<div class="widgetHeaderIconCol2" data-role = "none">
								<div class="widgetHeaderArrowRightTheme" data-role = "none"></div>
							</div> -->
							<div class="widgetHeaderHeadingTextCol" data-role = "none"><span class="widgetHeaderHeadingTextTheme" data-role = "none"><%=csResBundle.getString("activeProbs.activeProblemsAndDiagnosis") %></span> <input type="button" class="widgetHeaderCountButtonTheme" id="activeProblemViewCount" value="<%=pdList.size()%>"></div>
							<div class="widgetHeaderPlusButtonCell" data-role = "none">
								<div class="WidgetButtonTheme" data-role = "none" onclick="openRecordPDFrame()"><img src="${path}/eIPAD/images/CS_add16x16.png"></div>
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
						if(!pdResponse.isSensitiveDataShown() && pdResponse.isSensitiveDataPresent() && pdResponse.getSensitiveDiagnosisCount()>0){
					%>
					<div class="SensitiveHeader SensitiveHeaderTheme" id="PDSensitiveHeader" data-role = "none">
						<div style="display:table-row">
							<div style="display:table-cell;width:48%">
							</div>
							<div style="display:table-cell;vertical-align:middle;padding-right:15px">
								<div style="" class="SensitiveHeaderText WidgetNormalBoldTextTheme">
									Sensitive Diagnosis (<%=pdResponse.getSensitiveDiagnosisCount() %>)
								</div>
							</div>
							<div style="display:table-cell;vertical-align:middle;padding-left:15px">
								<div class="viewSensitiveButton viewSensitiveButtonTheme WidgetNormalBoldTextTheme" id="viewSensitiveDataButton" onclick="openAuthorizePrompt()">
								View
								</div>
							</div>
							<div style="display:table-cell;width:48%">
							</div>
						</div>
					</div>
					<%
						}
						for(int i=0;i<pdList.size();i++){
							ProblemsDiagnosisHO currentPD = pdList.get(i);
						
					%>
								<!-- PD widget content starts here -->
					<div class="PDContentTable WidgetContentStripTheme" id="PDTable<%=i+1 %>" data-pdcode="<%=currentPD.getDiagProbCode() %>" data-role = "none" data-pdcount="<%=i+1 %>">
						<div class="PDContentRow" data-role = "none">
							<div class="PDContentCol1 WidgetContentStripCol1Theme" data-role = "none">
							
								<div class="PDIcon <%if(currentPD.getSensitiveYN().equals("Y")){%> WidgetContentStripCol1BoxOrangeTheme<%}else {%>WidgetContentStripCol1BoxTheme<%} %>" data-role = "none">
							 
							
							
							
							<%if(currentPD.getCurrentState().equals("PROBLEM")){ %>
									<img src="${path}/eIPAD/images/CS_Active_Problems_32x32.png">
							<%} else if(currentPD.getCurrentState().equals("DIAGNOSIS")){
									if(currentPD.getCurrentAccuracyInd().equals("U")){
							%>
									<img src="${path}/eIPAD/images/DiagnosisW32x32.png">
									<%} else {%>
									<img src="${path}/eIPAD/images/DiagnosisAddW32x32.png">
									<%}
								}%>
								</div>
							</div>
							<div class="PDContentCol2" data-role = "none">
								<div style="font-weight:normal;" class="WidgetParaHeadText2Theme PDdescText" data-role = "none"><%=currentPD.getDiagProbDesc() %></div>
								<div class="WidgetParaHeadTextTheme PDCodeText" style="display:inline-block" data-role = "none"><%=currentPD.getDiagProbCode() %></div>
							<%if(currentPD.getEncounterStage().equals("A")){ %>
								<div class="WidgetNormalTextItalicTheme" style="display:inline-block">(During Admission stage)</div>
							<%}else if(currentPD.getEncounterStage().equals("I")){ %>
								<div class="WidgetNormalTextItalicTheme" style="display:inline-block">(During Intermediate stage)</div>
							<%}else if(currentPD.getEncounterStage().equals("D")){ %>
								<div class="WidgetNormalTextItalicTheme" style="display:inline-block">(During Discharge stage)</div>
							<%} %>
							</div>
							<div style="display:table-cell;vertical-align:middle;position: absolute;margin-top: 18px;">
								<div class="SfsHeaderButtonTheme" style="display:none" 
								<%if(currentPD.getCurrentState().equals("DIAGNOSIS")){ %>
									onclick="openModifyDiagnosisFrame('<%=currentPD.getTermSetId()%>','<%=currentPD.getDiagProbCode()%>','<%=currentPD.getOccurSrlNo() %>')"
								<%}else{ %>
									onclick="openModifyComplaintFrame('<%=currentPD.getDiagProbCode()%>')"
								<%} %>
								id="PDModifyButton<%=i+1 %>">Modify
								</div>
							</div>
							<div class="PDContentCol3" style="width:80px" data-role = "none">
							<%if(currentPD.getComplCount()>0 && currentPD.getCurrentState().equals("DIAGNOSIS")) {%>
								<div style="display:inline-block;text-align:center">
									<div class="widgetIconButton WidgetButtonTheme"  id="PDLinkedProblems_<%=currentPD.getDiagProbCode()%>" onclick="showLinkedEncounters(this,'PDLinkedECcontainer')" data-role = "none" data-linkurl="${path}/mobile/chartsummary/DiagnosisLinkedProblems?termSetId=<%=currentPD.getTermSetId()%>&diagCode=<%=currentPD.getDiagProbCode()%>&termSetDesc=<%=currentPD.getTermSetDesc()%>&occurSrlNo=<%=currentPD.getOccurSrlNo()%>" data-title="Linked Problems">
										<img src="${path}/eIPAD/images/LinkedProblem24x24.png">
									</div>
								</div>
							<%} 
							if(currentPD.getEncounterCount()>0 && currentPD.getCurrentState().equals("DIAGNOSIS")) {%>
								<div style="display:inline-block;text-align:center">
									<div class="widgetIconButton WidgetButtonTheme" id="PDLinkedEncounters_<%=currentPD.getDiagProbCode()%>" onclick="showLinkedEncounters(this,'PDLinkedECcontainer')" data-role = "none" data-linkurl="${path}/mobile/chartsummary/DiagnosisLinkedEncounters?termSetId=<%=currentPD.getTermSetId()%>&diagCode=<%=currentPD.getDiagProbCode()%>&status=<%=currentPD.getStatus()%>" data-title="Linked Encounters">
										<img src="${path}/eIPAD/images/Linked_Encounters24x24.png">
									</div>
								</div>
							<%} %>
								<div class="WidgetDateTextTheme" data-role = "none"><%=currentPD.getOnsetDate()%></div>
							</div>
						</div>
					</div>
						<% 
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
					<%}%>
				</div>
			</div>
			
			
		<input type="hidden" name="SensitiveDataPwd" id="SensitiveDataPwd" id="SensitiveDataPwd" value="">
		</div>
 	</form> 
	</div>

