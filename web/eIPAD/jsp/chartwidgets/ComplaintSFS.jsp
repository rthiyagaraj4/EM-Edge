<%@page import="eIPAD.chartsummary.activeproblems.healthobject.ComplaintSfsHO"%>
<%@page import="eIPAD.chartsummary.activeproblems.response.ComplaintSfsResponse"%>

<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@page import="java.util.ResourceBundle"%>
<%@page import="java.util.*"%>
<%@page import="eIPAD.chartsummary.common.response.*" %>
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
<title>Complaint Search</title>   
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
var specialtyListCombo;
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
	//Check if Speciality is selected, else change search type to 'A' ALL
	specialtyListCombo = $("#cmbSpecialtyList").data("kendoComboBox");
	if(!specialtyListCombo.value() && $("#hdnFilterBy").val()=='S'){
		$("#hdnFilterBy").val('A').trigger("change");
	}
	
	document.getElementById("hdnPostback").value = "true";
	document.getElementById("CSsfsForm").submit();
}



function cancelSfs()
{
	window.parent.sfsCancel();
}
$(document).ready(function () {

	path = document.getElementById("hdnPath").value;
	
	
	specialtyListCombo = $("#cmbSpecialtyList").data("kendoComboBox");
	$.getJSON(path + "/mobile/chartsummary/ProblemsDiagnosisFieldValues?field=COMPL_SPECIALTYLIST",function(data){
		var specialtyListDataSrc = data;
		specialtyListCombo.setDataSource(specialtyListDataSrc.specialtyList);
	});
	
	
	$('#hdnFilterBy').change( function() { 
		if($('#hdnFilterBy').val()=='S'){
			specialtyListCombo.enable(true);
		}else{
			specialtyListCombo.enable(false);
			$("#hdnSpecialtyCode").val('');
			specialtyListCombo.value("");
		}
	});
	
	 $('#FilterBySlidePointer').sliderGenericControl();
	 $('#SearchBySlidePointer').sliderGenericControl();
	 //$('#SearchTypeSlidePointer').sliderGenericControl();
	 
	
	 
});

function selectComplaint(diagObj){
	var code=$(diagObj).data("code");
	var desc=$(diagObj).data("complainttext");
	$("#hdnSelectedComplCode").val(code);
	$("#hdnSelectedComplText").val(desc);
	
	$.getJSON( path+"/mobile/chartsummary/ProblemsDiagnosisFieldValues?field=COMPL_EXISTS&ComplaintCode="+code, function(data){
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
			parent.selectComplaint();
		}
	});
	
	
}
function toggleSearchFields(togImg){
	$("#SfsSearchFields").toggle();
	$(togImg).toggleClass("SfsTogHide");
	$(togImg).toggleClass("SfsTogExpand");
}
function clearComplSfsData()
{	
	$("#hdnSearchBy").val('DESC').trigger("change");
	$("#hdnFilterBy").val('A').trigger("change");
	specialtyListCombo = $("#cmbSpecialtyList").data("kendoComboBox");
	specialtyListCombo.value("");
	$("#hdnSpecialtyCode").val('');
	$("#SearchText").val('');
	
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
	<form id="CSsfsForm" class="SfsForm" action="${path}/mobile/chartsummary/ProblemsDiagnosisSFS?SfsType=COMPLAINT" method="post" name="CSsfsForm" id="CSsfsForm">
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
									Complaint
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
									
									<!-- Filter By Fields Starts -->
										<div style="display:table-row" data-role="none">
											<div class="SfsSearchFieldsPaddedRow" data-role="none">
												<div class="SfsSearchFieldTextTheme" data-role="none">Filter by</div>
											</div>
										</div>
										<div style="display:table-row" data-role="none">
											<div  class="SfsSearchFieldsPaddedRow2" data-role="none">
												<div  class="parent" data-role="none"style="width:100%">
													<div  class="scale sfsScaleTheme" data-role="none"  id="FilterBySlider" >
														<div class="sliderSfsIns sliderSfsInsTheme">
															<div data-role="none" class="sliderSmallPointer sfsCritRoundTheme" id="FilterBySlidePointer"
															data-parent = "FilterBySlider" data-numpoints="3" data-drag="N" 
															data-valuefield="hdnFilterBy" data-value1="S" data-value2="N" data-value3="A" data-defaultvalue="${empty param['hdnFilterBy']?'NA':param['hdnFilterBy']}" 
															data-selstylelabel="SfsSearchFieldTxtSelTheme"></div>
															<input type="hidden" id="hdnFilterBy" name="hdnFilterBy" id="hdnFilterBy" value="${empty param['hdnFilterBy']?'NA':param['hdnFilterBy']}">
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
															<div style="" class = "SfsSearchFieldTxtDullTheme" data-labelfor="FilterBySlidePointer-1" data-labelval="1">Specialty</div>
														</div>
														<div style="display:table-cell;vertical-align:middle;text-align:center;padding-left:5px">
															<div style="" class = "SfsSearchFieldTxtDullTheme" data-labelfor="FilterBySlidePointer-2" data-labelval="2" >Non Specialty</div>
														</div>
														<div style="display:table-cell;vertical-align:middle;text-align:right;padding-right:10px">
															<div style="" class = "SfsSearchFieldTxtDullTheme" data-labelfor="FilterBySlidePointer-3" data-labelval="3" >All</div>
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
										<!--  Filter By Fields Ends -->
									
									
										<!-- Specialty List Fields Starts -->
										<div style="display:table-row" data-role="none">
											<div class="SfsSearchFieldsPaddedRow" data-role="none">
												<div class="SfsSearchFieldTextTheme" data-role="none">Specialty</div>
											</div>
										</div>
										<div style="display:table-row" data-role="none">
											<div class="SfsSearchFieldsPaddedRow" data-role="none">
												<div class="SfsTextBoxContainer" data-role="none">
													<input type="" class="SfsTextBoxTheme SfsSearchText" id="cmbSpecialtyList" name="cmbSpecialtyList" id="cmbSpecialtyList" value = "">
													<script>
													$("#cmbSpecialtyList").kendoComboBox({
														enable: false,
														dataTextField: "specialtyDesc",
								                        dataValueField: "specialtyCode",
								                        change: function(e) {
								                            $("#hdnSpecialtyCode").val(this.value());
								                        },
								                        dataBound: function(e) {
								                        	this.value($("#hdnSpecialtyCode").val());
								                        }
													});
													</script>
												</div>
												<input type="hidden" id="hdnSpecialtyCode" name="hdnSpecialtyCode" id="hdnSpecialtyCode" value="${param['hdnSpecialtyCode']}">
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
										
									</div>
									</div>
									</div>
							
									<div style="display:table;width:100%">
										<div style="display:table-row" data-role="none">
											<div style="display:table-cell;vertical-align:bottom;" data-role="none">
												<div style="display:table;width:100%" data-role="none">
													<div style="display:table-row" data-role="none">
														<div class="SfsBodyButtonTheme SfsBodyButtonLeft" data-role="none" onclick = "clearComplSfsData()">
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
														ComplaintSfsResponse oSfsRes = null;
														 List<ComplaintSfsHO> lstSfsHO = null;
														if(request.getAttribute("SfsResponse") != null)
														{
															oSfsRes = (ComplaintSfsResponse)request.getAttribute("SfsResponse");
															if(oSfsRes != null && oSfsRes.isSuccessResponse())
															{
																 lstSfsHO = oSfsRes.getComplaintSfsList();
																 if(lstSfsHO != null)
																 {
																	 int nLstCount = lstSfsHO.size();
																	 int nLoopcount = 0;
																	 ComplaintSfsHO oSfsHO = null;
																	 if(nLstCount > 0)
																	 {
																		 for(nLoopcount = 0;nLoopcount < nLstCount;nLoopcount++)
																		 {
																			 oSfsHO  = lstSfsHO.get(nLoopcount);
																			 if(oSfsHO != null)
																			 {
																			 %> 
																			 <div class="SfsSearchResRow" data-role="none" onclick="selectComplaint(this)" data-code = "<%=oSfsHO.getCode()%>" data-desc = "<%=oSfsHO.getDescription()%>"
																			 data-complainttext="<%=oSfsHO.getComplaintText()%>">
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
									  	 	<div class="formValErrorMsgTheme" id="DuplicateSelection_ErrorMsg">Complaint already exists</div>
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
	<input type="hidden" name="hdnPath" id="hdnPath" id="hdnPath" value="${path}" /> 
	<input type="hidden" name="hdnSelectedComplCode" id="hdnSelectedComplCode" id="hdnSelectedComplCode" value=""/>
	<input type="hidden" name="hdnSelectedComplText" id="hdnSelectedComplText" id="hdnSelectedComplText" value="" />
	</form>
	</div>

</body>
</html>

