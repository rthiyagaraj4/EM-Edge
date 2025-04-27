<%@page import="eIPAD.chartsummary.activeproblems.healthobject.DiagnosisSfsHO"%>
<%@page import="eIPAD.chartsummary.activeproblems.response.DiagnosisSfsResponse"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@page import="java.util.ResourceBundle"%>
<%@page import="java.util.*"%>
<%@page import="eIPAD.chartsummary.common.response.*" %>
<%@page import="eIPAD.chartsummary.common.healthobject.*" %>
<%@page import="eIPAD.chartsummary.common.healthobject.*" %>
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
<!DOCTYPE html> 
<html> 
<head> 
<title>Diagnosis Search</title>   
<style>
</style>
<meta name="apple-mobile-web-app-capable" content="yes" />   
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<script src="${path}/eIPAD/jquery-1.9.1.js"></script> 
<script src="${path}/eIPAD/jquery.mobile-1.0.1.min.js"></script>
<link rel="stylesheet" href="${path}/eIPAD/jquery.mobile-1.0.1.min.css" />
<link rel="stylesheet" href="${path}/eIPAD/css/iPADThemeA.css" />
<link rel="stylesheet" href="${path}/eIPAD/css/iPADNew.css" />
<script type="application/javascript" src="${path}/eIPAD/js/iscroll.js"></script>
<script src="${path}/eIPAD/kendo.web.min.js"></script>
<link rel="stylesheet" href="${path}/eIPAD/css/kendo.common.min.css" />
<link rel="stylesheet" href="${path}/eIPAD/css/kendo.default.min.css" />
<script type="application/javascript" src="${path}/eIPAD/js/ActiveProblems.js"></script>
<script type="application/javascript" src="${path}/eIPAD/js/GenericSlider.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<style>




</style>
<script>
var sfsScroll;
var sfsFieldScroll;
var sfsDataArr = [];
var custListCombo;
var path;
document.addEventListener('touchmove', function (e) { e.preventDefault(); }, false);
function loadSfsScroller() {
	sfsScroll = new iScroll('SfsScrollWrapper');
	//sfsFieldScroll = new iScroll('SfsFieldsWrapper') ;
	sfsFieldScroll = new iScroll('SfsFieldsWrapper', {
		useTransform: true,
		zoom: false,
		onBeforeScrollStart: function (e) {
		var target = e.target;
		while (target.nodeType != 1) target = target.parentNode;

		if (target.tagName != 'SELECT' && target.tagName != 'INPUT' && target.tagName != 'TEXTAREA' && target.tagName != 'DIV')
		e.preventDefault();
		}
	});
}
document.addEventListener('DOMContentLoaded', loadSfsScroller, false);
function displayResults()
{
	addSpinner();
	//Check if custom list is selected, else change search type to 'S'
	custListCombo = $("#cmbCustomList").data("kendoComboBox");
	if(!custListCombo.value()){
		$("#hdnSearchType").val('S').trigger("change");
	}
	
	document.getElementById("hdnPostback").value = "true";
	document.getElementById("CSsfsForm").submit();
}
function trim1(myString)
{
 return myString.replace(/^\s+|\s+$/g, ''); 
}
function getSfsDataArray()
{
	return sfsDataArr;
}

function cancelSfs()
{
	window.parent.sfsCancel();
}
$(document).ready(function () {
	removeSpinner();

	path = document.getElementById("hdnPath").value;
	
	
	custListCombo = $("#cmbCustomList").data("kendoComboBox");
	$.getJSON(path + "/mobile/chartsummary/ProblemsDiagnosisFieldValues?field=DIAG_CUSTOMLIST&DiagSetId="+$("#TermSetId").val(),function(data){
		var custListDataSrc = data;
		custListCombo.setDataSource(custListDataSrc.diagnosisCustomList);
	});
	
	
	$('#hdnSearchType').change( function() { 
		if($('#hdnSearchType').val()=='C'){
			custListCombo.enable(true);
		}else{
			custListCombo.enable(false);
			$("#hdnTermGroupId").val('');
			custListCombo.value("");
		}
		
	});
	
	 $('#SearchBySlidePointer').sliderGenericControl();
	 $('#SearchTypeSlidePointer').sliderGenericControl();
	 $('#NotifiableSlidePointer').sliderGenericControl();
	 $('#SensitiveSlidePointer').sliderGenericControl();
	 
	 
});


function toggleSearchFields(togImg){
	$("#SfsSearchFields").toggle();
	$(togImg).toggleClass("SfsTogHide");
	$(togImg).toggleClass("SfsTogExpand");
}
function clearData()
{	
	$("#hdnSearchType").val('S').trigger("change");
	$("#hdnSearchBy").val('DESC').trigger("change");
	$("#SearchText").val('');
	$("#hdnNotifiableYN").val('NA').trigger("change");
	custListCombo = $("#cmbCustomList").data("kendoComboBox");
	custListCombo.value("");
	$("#hdnSensitiveYN").val('NA').trigger("change");
	$("#hdnTermGroupId").val('');
	
}
function selectDiagnosis(diagObj){
	var code=$(diagObj).data("code");
	var desc=$(diagObj).data("desc");
	var sensitiveYN=$(diagObj).data("sensitiveyn");
	$("#hdnSelectedDiagCode").val(code);
	$("#hdnSelectedDiagDesc").val(desc);
	
	$.getJSON( path+"/mobile/chartsummary/ProblemsDiagnosisFieldValues?field=DIAG_EXISTS&DiagCode="+$("#hdnSelectedDiagCode").val()+"&DiagSetId="+$("#TermSetId").val(), function(data){
		result = data.validationResult;
		if(result==0){
			$("#DuplicateSelection_Error").show();
			setTimeout(function(){
				$("#DuplicateSelection_Error").hide();
			},5000);
			$("#DuplicateSelection_Error").bind('click',function(){
				$(this).hide();
			});
		}else{
			if(sensitiveYN == "Y"){
				openAuthorizePrompt();
			}else{
				parent.selectDiagnosis();
			}
		}
		//diagAccuracyCombo.setDataSource(diagAccuracyDataSrc.diagAccuracyList);
		//return result;
	});
	//var duplicateVali = duplicateDiagValidate();
	//alert(duplicateVali);
	
	
}
function duplicateDiagValidate(){
	var result;
	
	
}
function openAuthorizePrompt(){
	parent.openAuthorizePrompt();
}
function addSpinner(){
	var a = $("#spinnerDiv")
	if(a.length ==0)
		$("#SfsScrollWrapper").append("<div class='loadingCartItem' id='spinnerDiv'></div>");
}
function removeSpinner(){
	var a = $("#spinnerDiv")
	if(a.length > 0)
	$("#spinnerDiv").remove();
}
</script>
</head>
<body>
	<div class="SfsParent SfsParentTheme" data-role="none">
	<form id="CSsfsForm" class="SfsForm" action="${path}/mobile/chartsummary/ProblemsDiagnosisSFS?SfsType=DIAGNOSIS" method="post" name="CSsfsForm" id="CSsfsForm">
		<div class="SfsParentTable" data-role="none">
			<div class="SfsParentHeaderRow" data-role="none">
				<div class="SfsParentHeaderCell" data-role="none">
					<div class="SfsHeaderTable SfsHeaderTheme" data-role="none">
						<div class="SfsHeaderRow" data-role="none">
							<div class="SfsHeaderButtonCol" data-role="none">
								<div class="SfsHeaderButton SfsHeaderButtonTheme" data-role="none" onclick = "cancelSfs()">
									<%=csResBundle.getString("common.cancel") %>
								</div>
							</div>
							<div class="SfsHeaderTextCol" data-role="none">
								<div class="SfsHeaderTextTheme"  id="DiagSfsHeaderTxt" data-role="none">
									Diagnosis
								</div>
							</div>
							<div class="SfsHeaderButtonCol" data-role="none">
								<div class="SfsHeaderButton SfsHeaderButtonTheme" data-role="none" style = "display:none">
									<%=csResBundle.getString("common.select") %>
								</div>					
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="SfsParentBodyRow" data-role="none">
				<div class="SfsParentBodyCell" data-role="none">
					<div class="SfsBodyTable" data-role="none">
						<div class="SfsBodyRow" data-role="none">
							<div class="SfsBodySearchFieldsCol"  id="SfsSearchFields" data-role="none">
								<div class="SfsSearchFieldsContainer2 SfsSearchFieldsContainerTheme" data-role="none">
									<div id="SfsFieldsScroller" class="sfsFieldsScroller">
									<div id="SfsFieldsWrapper" class="sfsFieldsWrapper">
									<div style="display:table;width:100%;height:100%" data-role="none">
									
									<!-- Search Type Fields Starts -->
										<div style="display:table-row" data-role="none">
											<div class="SfsSearchFieldsPaddedRow" data-role="none">
												<div class="SfsSearchFieldTextTheme" data-role="none">Search Type</div>
											</div>
										</div>
										<div style="display:table-row" data-role="none">
											<div  class="SfsSearchFieldsPaddedRow" data-role="none">
												<div style="display:table;width:100%" data-role="none">
													<div style="display:table-row" data-role="none">
														<div class="SfsSearchByCodeText SfsSearchFieldTxtDullTheme" style="display:table-cell" data-role="none" data-labelfor="SearchTypeSlidePointer-1" data-labelval="1" >
														Search
														</div>
														
														<div class="SfsSearchBySlider" style="display:table-cell;vertical-align:middle;text-align:left" data-role="none">
														  <div  style = "position:relative;width:70%;left:0px" data-role = "none">
														  		<div  class = "sliderSmallScale sfsScaleTheme" data-role = "none" id="SearchTypeSlider">
														  			<div class="sliderSfsIns sliderSfsInsTheme">
															  		    <div data-role = "none" class = "sliderSmallPointer sfsCritRoundTheme" id = "SearchTypeSlidePointer"
															  		    data-parent = "SearchTypeSlider" data-numpoints="2" data-drag="N" 
																		data-valuefield="hdnSearchType" data-value1="S" data-value2="C" data-defaultvalue="${empty param['hdnSearchType']?'S':param['hdnSearchType']}" 
																		data-selstylelabel="SfsSearchFieldTxtSelTheme">
															  		    </div>
															  		    <input type="hidden" id="hdnSearchType" name="hdnSearchType" id="hdnSearchType" value="">
														  		    </div>
														  		</div>
						  									</div>
														</div>
														<div class="SfsSearchByDescText" style="display:table-cell;text-align:right;" data-role="none">
														<span class = "SfsSearchFieldTxtDullTheme" style = "position:relative;margin-right:10px" data-labelfor="SearchTypeSlidePointer-2" data-labelval="2" >Custom List</span>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div style="display:table-row" data-role="none">
											<div class="SfsHLineRow" data-role="none">
												<div class="SfsHLineTheme" data-role="none"></div>
											</div>
										</div>
										<!-- Search Type Fields Ends -->
										
										<!-- Custom List Fields Starts -->
										<div style="display:table-row" data-role="none">
											<div class="SfsSearchFieldsPaddedRow" data-role="none">
												<div class="SfsSearchFieldTextTheme" data-role="none">Custom List</div>
											</div>
										</div>
										<div style="display:table-row" data-role="none">
											<div class="SfsSearchFieldsPaddedRow" data-role="none">
												<div class="SfsTextBoxContainer" data-role="none">
													<input type="" class="SfsTextBoxTheme SfsSearchText" id="cmbCustomList" name="AllergySfsText" id="AllergySfsText" value = "">
													<script>
													$("#cmbCustomList").kendoComboBox({
														enable: false,
														dataTextField: "desc",
								                        dataValueField: "code",
								                        change: function(e) {
								                            $("#hdnTermGroupId").val(this.value());
								                        },
								                        dataBound: function(e) {
								                        	this.value($("#hdnTermGroupId").val());
								                        }
													});
												</script>
												</div>
											</div>
										</div>
										<div style="display:table-row" data-role="none">
											<div class="SfsHLineRow" data-role="none">
												<div class="SfsHLineTheme" data-role="none"></div>
											</div>
										</div>
										<!-- Custom List Fields Ends -->
										
										
										<!-- Search By Fields Starts -->
										<div style="display:table-row" data-role="none">
											<div class="SfsSearchFieldsPaddedRow" data-role="none">
												<div class="SfsSearchFieldTextTheme" data-role="none"><%=csResBundle.getString("common.searchBy") %></div>
											</div>
										</div>
										<div style="display:table-row" data-role="none">
											<div  class="SfsSearchFieldsPaddedRow" data-role="none">
												<div style="display:table;width:100%" data-role="none">
													<div style="display:table-row" data-role="none">
														<div class="SfsSearchByCodeText SfsSearchFieldTxtDullTheme" style="display:table-cell" data-role="none" data-labelfor="SearchBySlidePointer-1" data-labelval="1" >
														<%=csResBundle.getString("common.code") %>
														</div>
														
														<div class="SfsSearchBySlider" style="display:table-cell;vertical-align:middle;text-align:left" data-role="none">
														  	<div  style = "position:relative;width:70%;left:0px" data-role = "none">
														  		<div  class = "sliderSmallScale sfsScaleTheme" data-role = "none" id = "SearchBySlider">
															  		<div class="sliderSfsIns sliderSfsInsTheme">
															  		    <div data-role = "none" class = "sliderSmallPointer sfsCritRoundTheme" id = "SearchBySlidePointer"
															  		    data-parent = "SearchBySlider" data-numpoints="2" data-drag="N" 
																		data-valuefield="hdnSearchBy" data-value1="CODE" data-value2="DESC" data-defaultvalue="${empty param['hdnSearchBy']?'DESC':param['hdnSearchBy']}" 
																		data-selstylelabel="SfsSearchFieldTxtSelTheme">
															  		    </div>
															  		    <input type="hidden" id="hdnSearchBy" name="hdnSearchBy" id="hdnSearchBy" value="">
															  		</div>
														  		</div>
						  									</div>
														</div>
														<div class="SfsSearchByDescText" style="display:table-cell;text-align:right;" data-role="none">
														<span class = "SfsSearchFieldTxtDullTheme" style = "position:relative;margin-right:10px" data-labelfor="SearchBySlidePointer-2" data-labelval="2" ><%=csResBundle.getString("common.description") %></span>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div style="display:table-row" data-role="none">
											<div class="SfsHLineRow" data-role="none">
												<div class="SfsHLineTheme" data-role="none"></div>
											</div>
										</div>
										<!-- Search By Fields Ends -->
										
										<!-- Search Text Fields Starts -->
										<div style="display:table-row" data-role="none">
											<div class="SfsSearchFieldsPaddedRow" data-role="none">
												<div class="SfsSearchFieldTextTheme" data-role="none"><%=csResBundle.getString("common.searchText") %></div>
											</div>
										</div>
										<div style="display:table-row" data-role="none">
											<div class="SfsSearchFieldsPaddedRow" data-role="none">
												<div class="SfsTextBoxContainer" data-role="none"><input type="text" class="SfsTextBoxTheme SfsSearchText" id="SearchText" name="SearchText" id="SearchText" value = "${empty param['SearchText']?'':param['SearchText']}"></div>
											</div>
										</div>
										<div style="display:table-row" data-role="none">
											<div class="SfsHLineRow" data-role="none">
												<div class="SfsHLineTheme" data-role="none"></div>
											</div>
										</div>
										<!-- Search Text Fields Ends -->
										
										<!-- Restrict to notifiable Fields Starts -->
										<div style="display:table-row" data-role="none">
											<div class="SfsSearchFieldsPaddedRow" data-role="none">
												<div class="SfsSearchFieldTextTheme" data-role="none">Restrict to Notifiable</div>
											</div>
										</div>
										<div style="display:table-row" data-role="none">
											<div  class="SfsSearchFieldsPaddedRow2" data-role="none">
												<div  class="parent" data-role="none"style="width:100%">
													<div  class="scale sfsScaleTheme" data-role="none"  id="NotifiableSlider" >
														<div class="sliderSfsIns sliderSfsInsTheme">
															<div data-role="none" class="sliderSmallPointer sfsCritRoundTheme" id="NotifiableSlidePointer"
															data-parent = "NotifiableSlider" data-numpoints="3" data-drag="N" 
															data-valuefield="hdnNotifiableYN" data-value1="Y" data-value2="NA" data-value3="N" data-defaultvalue="${empty param['hdnNotifiableYN']?'NA':param['hdnNotifiableYN']}" 
															data-selstylelabel="SfsSearchFieldTxtSelTheme"></div>
															<input type="hidden" id="hdnNotifiableYN" name="hdnNotifiableYN" id="hdnNotifiableYN" value="">
														</div>
													</div>
												</div>
											</div>
										</div>
										<div style="display:table-row">
											<div style="display:table-cell;width:100%">
												<div style="display:table;width:100%">
													<div style="display:table-row">
														<div style="display:table-cell;vertical-align:middle;text-align:left;padding-left:5px">
															<div style="" class = "SfsSearchFieldTxtDullTheme" data-labelfor="NotifiableSlidePointer-1" data-labelval="1" >Yes</div>
														</div>
														<div style="display:table-cell;vertical-align:middle;text-align:center;padding-left:5px">
															<div style="" class = "SfsSearchFieldTxtDullTheme" data-labelfor="NotifiableSlidePointer-2" data-labelval="2" >None</div>
														</div>
														<div style="display:table-cell;vertical-align:middle;text-align:right;padding-right:10px">
															<div style="" class = "SfsSearchFieldTxtDullTheme" data-labelfor="NotifiableSlidePointer-3" data-labelval="3" >No</div>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div style="display:table-row" data-role="none">
											<div class="SfsHLineRow" data-role="none">
												<div class="SfsHLineTheme" data-role="none"></div>
											</div>
										</div>
										<!--  Restrict to notifiable Fields Ends -->
										
										<!-- Sensitive Fields Starts -->
										<div style="display:table-row" data-role="none">
											<div class="SfsSearchFieldsPaddedRow" data-role="none">
												<div class="SfsSearchFieldTextTheme" data-role="none">Sensitive</div>
											</div>
										</div>
										<div style="display:table-row" data-role="none">
											<div  class="SfsSearchFieldsPaddedRow2" data-role="none">
												<div  class="parent" data-role="none"style="width:100%">
													<div  class="scale sfsScaleTheme" data-role="none"  id="SensitiveSlider" >
														<div class="sliderSfsIns sliderSfsInsTheme">
															<div data-role="none" class="sliderSmallPointer sfsCritRoundTheme" id="SensitiveSlidePointer"
															data-parent = "SensitiveSlider" data-numpoints="3" data-drag="N" 
															data-valuefield="hdnSensitiveYN" data-value1="Y" data-value2="NA" data-value3="N" data-defaultvalue="${empty param['hdnSensitiveYN']?'NA':param['hdnSensitiveYN']}" 
															data-selstylelabel="SfsSearchFieldTxtSelTheme"></div>
															<input type="hidden" id="hdnSensitiveYN" name="hdnSensitiveYN" id="hdnSensitiveYN" value="">
														</div>
													</div>
												</div>
											</div>
										</div>
										<div style="display:table-row">
											<div style="display:table-cell;width:100%">
												<div style="display:table;width:100%">
													<div style="display:table-row">
														<div style="display:table-cell;vertical-align:middle;text-align:left;padding-left:5px">
															<div style="" class = "SfsSearchFieldTxtDullTheme" data-labelfor="SensitiveSlidePointer-1" data-labelval="1" >Yes</div>
														</div>
														<div style="display:table-cell;vertical-align:middle;text-align:center;padding-left:5px">
															<div style="" class = "SfsSearchFieldTxtDullTheme" data-labelfor="SensitiveSlidePointer-2" data-labelval="2" >None</div>
														</div>
														<div style="display:table-cell;vertical-align:middle;text-align:right;padding-right:10px">
															<div style="" class = "SfsSearchFieldTxtDullTheme" data-labelfor="SensitiveSlidePointer-3" data-labelval="3" >No</div>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div style="display:table-row" data-role="none">
											<div class="SfsHLineRow" data-role="none">
												<div class="SfsHLineTheme" data-role="none"></div>
											</div>
										</div>
										<!-- Sensitive Fields Ends -->
										
										
									</div>
									</div>
									</div>
							
									<div style="display:table;width:100%">
										<div style="display:table-row" data-role="none">
											<div style="display:table-cell;vertical-align:bottom;" data-role="none">
												<div style="display:table;width:100%" data-role="none">
													<div style="display:table-row" data-role="none">
														<div class="SfsBodyButtonTheme SfsBodyButtonLeft" data-role="none" onclick = "clearData()">
															<%=csResBundle.getString("common.clear") %>
														</div>
														<div class="SfsBodyButtonTheme SfsBodyButtonRight" data-role="none" onclick = "displayResults()">
															<%=csResBundle.getString("common.search") %>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
									
									
								</div>
							</div>
							<div class="SfsBodyFieldsDockCol" data-role="none">
								<div  class="SfsTogHide" onclick="toggleSearchFields(this)"></div>
							</div>
							<div class="SfsBodySearchResCol" style="display:table-cell" data-role="none">
								<div class="SfsSearchResContainer" data-role="none">
									<div class="SfsSearchResTable" data-role="none">
										<div class="SfsSearchResHeaderRow" data-role="none"> 
											<div class="SfsSearchResHeaderCodeCol SfsSearchResHeaderTheme SfsSearchFieldTextTheme" data-role="none">
												<%=csResBundle.getString("common.code") %>
											</div>
											<div class="SfsSearchResHeaderDescCol SfsSearchResHeaderTheme SfsSearchFieldTextTheme" data-role="none">
												<%=csResBundle.getString("common.description") %>
											</div>
										</div>
									</div>
									<div class="SfsScrollWrapper" id="SfsScrollWrapper" data-role="none">
										<div class="SfsScroller" data-role="none">
											<div class="SfsSearchResTable" data-role="none">
											
											
												<%
												String pb = request.getParameter("hdnPostback")==null?"":request.getParameter("hdnPostback");
													if(request.getParameter("hdnPostback") != null && request.getParameter("hdnPostback").equals("true"))
													{ 
														DiagnosisSfsResponse oSfsRes = null;
														 List<DiagnosisSfsHO> lstSfsHO = null;
														if(request.getAttribute("SfsResponse") != null)
														{
															oSfsRes = (DiagnosisSfsResponse)request.getAttribute("SfsResponse");
															if(oSfsRes != null && oSfsRes.isSuccessResponse())
															{
																 lstSfsHO = oSfsRes.getDiagnosisSfsList();
																 if(lstSfsHO != null)
																 {
																	 int nLstCount = lstSfsHO.size();
																	 int nLoopcount = 0;
																	 DiagnosisSfsHO oSfsHO = null;
																	 if(nLstCount > 0)
																	 {
																		 for(nLoopcount = 0;nLoopcount < nLstCount;nLoopcount++)
																		 {
																			 oSfsHO  = lstSfsHO.get(nLoopcount);
																			 if(oSfsHO != null)
																			 {
																			 %> 
																			 <div class="SfsSearchResRow" data-role="none" onclick="selectDiagnosis(this)" data-code = "<%=oSfsHO.getCode()%>" data-desc = "<%=oSfsHO.getDescription()%>"
																			 data-sensitiveyn="<%=oSfsHO.getSensitiveYN()%>">
																				<div class="SfsSearchResCodeCol SfsSearchResBodyTheme SfsSearchResTextTheme" data-role="none">
																					<%=oSfsHO.getCode()%>
																				</div>
																				<div class="SfsSearchResDescCol SfsSearchResBodyTheme SfsSearchResTextTheme" data-role="none">
																					<%=oSfsHO.getDescription()%>
																				</div>
																			</div>
																			 <% 
																			 }
																		 }
																	 }
																	 else
																	 {
																		 if(oSfsRes.getErrorsList() != null && oSfsRes.getErrorsList().size() > 0)
																			{
																			  %> 
																			 	<div class="SfsSearchResRow" data-role="none" >
																						
																						<div class="SfsSearchResBodyTheme SfsSearchResTextTheme" style = "display:table-cell;width:100%"data-role="none">
																							<%=oSfsRes.getErrorsList().get(0).getErrorMessage() %>
																						</div>
																				</div> 
																			  
																 			  <% 
																			}
																	 }
																 }
															}
															else
															{
																if(oSfsRes != null)
																{
																	if(oSfsRes.getErrorsList() != null && oSfsRes.getErrorsList().size() > 0)
																	{
																	  %> 
																	  <div class="SfsSearchResRow" data-role="none" >
																				
																				<div class="SfsSearchResBodyTheme SfsSearchResTextTheme" style = "display:table-cell;width:100%"data-role="none">
																					<%=oSfsRes.getErrorsList().get(0).getErrorMessage() %>
																				</div>
																		</div> 
																	  
																	  <% 
																	}
																}
															}
														}
														
													}
												%> 
												
											</div>
										</div>
										<!-- Error message for duplicate selection -->
										<div class="formValWarningTheme formValError" id="DuplicateSelection_Error" style="bottom: 0px; left: 0px;display:none">
									  	 	<div class="formValErrorMsgTheme" id="DuplicateSelection_ErrorMsg">An active record already exists for this Diagnosis</div>
									  	 </div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	
	<input type="hidden" id="hdnPostback" name="hdnPostback" id="hdnPostback" value="true" />
	<input type="hidden" id="TermSetId" name="TermSetId" id="TermSetId" value="${param['TermSetId']}"/>
	<input type="hidden" id="hdnTermGroupId" name="hdnTermGroupId" id="hdnTermGroupId" value="${param['hdnTermGroupId']}"/>
	<input type="hidden" name="hdnPath" id="hdnPath" id="hdnPath" value="${path}" /> 
	<input type="hidden" name="hdnSelectedDiagCode" id="hdnSelectedDiagCode" id="hdnSelectedDiagCode" value=""/>
	<input type="hidden" name="hdnSelectedDiagDesc" id="hdnSelectedDiagDesc" id="hdnSelectedDiagDesc" value="" />
	</form>
	</div>

</body>
</html>

