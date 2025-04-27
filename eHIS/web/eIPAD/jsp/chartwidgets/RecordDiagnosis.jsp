<%@page import="eIPAD.chartsummary.activeproblems.healthobject.DiagnosisSetHO"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@page import="java.util.ResourceBundle"%>
<%@page import="java.util.*"%>
<%@ page import="com.google.gson.*"%>
<%@page import="eIPAD.chartsummary.common.response.*"%>
<%@page import="eIPAD.chartsummary.activeproblems.response.DiagnosisSetResponse"%>
<%@ page import="eIPAD.chartsummary.common.healthobject.PatContext"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<%

Locale appLocale;
if (session.getAttribute("LOCALE") != null && !session.getAttribute("LOCALE").equals(""))
	appLocale = new Locale((String) session.getAttribute("LOCALE"));
else
	appLocale = new Locale("en");
ResourceBundle csResBundle = ResourceBundle.getBundle("eIPAD.chartsummary.common.resourcebundle.cslabels",appLocale);

/* Gson gson = new Gson();
DiagnosisSetResponse diagSetResp;
ArrayList<DiagnosisSetHO> diagSetList = new ArrayList<DiagnosisSetHO>();
String diagSetJson = "";
if(request.getAttribute("DiagnosisSetResponse") != null){
	diagSetResp = (DiagnosisSetResponse)request.getAttribute("DiagnosisSetResponse");
	if(diagSetResp != null && diagSetResp.isSuccessResponse() && !diagSetResp.isEmptyDataResponse()){
		diagSetList = diagSetResp.getDiagnosisSetList(); 
		diagSetJson = gson.toJson(diagSetResp);
	}
} */

String patientDOB="";
PatContext patContext= (PatContext)session.getAttribute("PatientContext");
if(patContext!=null){
	patientDOB = patContext.getDob();
}
//setting current date in dd/mm/yyyy hh:mm
java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm");
String today = dateFormat.format(new java.util.Date());

%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Record Vitals</title>

<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<link rel="stylesheet" href="${path}/eIPAD/jquery.mobile-1.0.1.min.css" />
<link rel="stylesheet" href="${path}/eIPAD/css/kendo.common.min.css" />
<link rel="stylesheet" href="${path}/eIPAD/css/kendo.default.min.css" />
<script src="${path}/eIPAD/jquery-1.9.1.js"></script> 
<script src="${path}/eIPAD/kendo.web.min.js"></script>
<script src="${path}/eIPAD/console.js"></script>
<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
<link rel="stylesheet" href="${path}/eIPAD/css/iPADNew.css" />
<link rel="stylesheet" href="${path}/eIPAD/css/iPADThemeA.css" />
<script type="application/javascript" src="${path}/eIPAD/js/iscroll.js"></script>
<script type="application/javascript" src="${path}/eIPAD/js/GenericSlider.js"></script>
<script type="application/javascript" src="${path}/eIPAD/js/ActiveProblemsTransaction.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



<script>
document.addEventListener('touchmove', function (e) { e.preventDefault(); }, false);
document.addEventListener('DOMContentLoaded', assignMainScroll, false);
var diagTransactMainScroll;
var screenOrienttation = "landscape";
var path;

function changeOrientation(orient, EMHFheight)
{
	var CSHFheight = $('#allergyHeader').height();
   	HFheight = EMHFheight;
   	screenOrienttation = orient;
   	var content_height = parent.getTotalPageDivHeight() - EMHFheight - CSHFheight-6 ;
   	document.getElementById("divcnt").style.height = content_height+"px";
   //	$('#header1').focus();
   	scrollRefresh();
}
function scrollRefresh()
{
 	if(diagTransactMainScroll != null)
 		diagTransactMainScroll.refresh();
}

function assignMainScroll() {
	 setTimeout(function () {
		 diagTransactMainScroll = new iScroll('divcnt', {
		useTransform: true,
		zoom: false,
		
		onBeforeScrollStart: function (e) {
		var target = e.target;
		while (target.nodeType != 1) target = target.parentNode;

		if (target.tagName != 'SELECT' && target.tagName != 'INPUT' && target.tagName != 'TEXTAREA' && target.tagName != 'DIV')
		e.preventDefault();
		} 
		});
}, 1000); 
}



$(document).ready(function () {
	parent.setOnLoadContentPaneHeight();
	path = document.getElementById("hdnPath").value;
	mode = document.getElementById("hdnMode").value;
	
	$("#DiagnosisSwitch").on("swiperight", function() {
	 openComplaintsFrame();
	});
	
	
	$("#cmbDiagSet").kendoComboBox({
		dataTextField: "desc",
		dataValueField: "code",
		//dataSource: diagSetValuesJson.diagnosisSetList,
		//value:diagSetValuesJson.defaultValue,
		change: function(e) {
			showHideAllOtherFields();
		}
	});
	
	//Initializing all the combo and multiselect objects
	diagSetCombo = $("#cmbDiagSet").data("kendoComboBox");
	diagClassCombo = $("#cmbDiagClass").data("kendoComboBox");
	diagComplaintMulSel = $("#mulComplaints").data("kendoMultiSelect");
	diagAccuracyCombo = $("#cmbAccuracy").data("kendoComboBox");
	diagAnatomicalCombo = $("#cmbAnatSite").data("kendoComboBox");
	diagApplSideCombo = $("#cmbApplSide").data("kendoComboBox");
	
	
	populateDiagSetCombo();
	//populating accuracy combo on load since accuracy values are not dependant on Diagnosis set value
	populateDiagAccuracyCombo();
	populateAnatomicalCombo();
	$('#hdnAnatomicalSite').change(function(){ 
		populateAnatomicalCombo();	
		diagAnatomicalCombo = $("#cmbAnatSite").data("kendoComboBox");
		diagAnatomicalCombo.value(''); 
		if($('#hdnAnatomicalSite').val()=="O"){
			$("#ApplicableSideFieldWrap").show();
			diagApplSideCombo = $("#cmbApplSide").data("kendoComboBox");
			diagApplSideCombo.value('');
			$("#hdnDiagApplSide").val("");
		}
		else{
			$("#ApplicableSideFieldWrap").hide();
			diagApplSideCombo = $("#cmbApplSide").data("kendoComboBox");
			diagApplSideCombo.value('');
			$("#hdnDiagApplSide").val("");
		}
		scrollRefresh();
	});
	

	//Setting patient DOB and current server date
	var patDOB_str = $("#patientDOB").val();
	patDOB = StringToDate(patDOB_str);
	var today_str = $("#today").val();
	today = StringToDate(today_str);
	
	//Initializing DateTimePicker Objects
	onsetDTPicker = $("#OnsetDate").data("kendoDateTimePicker");
	asOnDPicker = $("#AsOnDate").data("kendoDatePicker");
	
	//to enable scrolling inside textarea
	$('textarea').each(function(index){
		$(this).bind('touchmove', function(event){
	    	event.stopPropagation();
		});
	});
});



</script>
<style>


</style>
</head>
<body>
	<div id="divParent" class="divParent" data-role="page" style="padding: 0px">
		<form name = "frmRecordDiag" id = "frmRecordDiag" style="width: 100%; height: 100%" action="${path}/mobile/chartsummary/DiagnosisTransaction">
			<div data-role = "none" id = "dvMez" class = "blurPopup" data-popid=""></div>
			<!-- popup container -->
			<div data-role="none" class="diagSfs sfsIPTheme" id="sfs">
				<iframe id="sfsFrame" frameborder="0" style="display: block;"
					scrolling="no" class="popupIFrame" src=""></iframe>
			</div>
			<!-- popup container ends -->
			<div id="allergyHeader" class="AllergyHeader" style="padding: 0px"
					data-role="none">
					<table cellpadding="0" cellspacing="0" class="tbAllergyHeader"
						data-role="none">
						<tr class="normalTr">
							<td class="normalTd">
								<div class="RecordAllergyHeader RecordAllergyHeaderTheme">
									<div class="RecordAllergyTable">
										<div class="normalRow">
											<div class="AllergyCell" style="width: 99%; text-align: left">
												<div style="display:table">
													<div style="display:table-row">
														<div style="display:table-cell">
															<div class="flipButtonOutlineTheme flipButtonOutline">
																<div style="display:table;height:100%">
																	<div style="display:table-row">
																		<div style="display:table-cell;vertical-align:middle">
																			<div class="flipButtonActiveTheme headerflipButton" id="DiagnosisSwitch">Record Diagnosis</div>
																		</div>
																		<div style="display:table-cell;vertical-align:middle">
																			<div class="flipButtonInActiveTheme headerflipButton" id="ComplaintsSwitch" onclick="openComplaintsFrame()">Chief Complaint</div>
																		</div>
																	</div>
																</div>
															</div>
														</div>
													</div>
												</div>
											</div>
											<div class="AllergyCell" style="width: 1%">
												<div class="RecordAllergyTable">
													<div class="normalRow">
														<div class="AllergyCell"
															style="width: auto; text-align: right">
															<div class="buttonContainer">
																<div class="WidgetButtonTheme" id="RecordDiagSubmitButton" onclick="validateAndRecordDiagnosis()">
																	<img src="${path}/eIPAD/images/CS_Ok16x16.png"/>
																</div>
															</div>
														</div>
														<div class="AllergyCell"
															style="width: auto; text-align: right">
															<div class="buttonContainer">
																<div class="WidgetButtonTheme" onclick="cancelTransaction()">
																	<img src="${path}/eIPAD/images/CS_Close16x16.png"/>
																</div>
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
				<div id="divcnt" class="divAllergyContent divAllergyContentTheme" style="padding: 0px; overflow: hidden" data-role="none">
					<div style="width: 100%; height: auto; overflow: auto" data-role="none">
						<div style="width: 100%; height: auto; overflow: auto" data-role="none">	<!-- container start -->	

		 					<div class="cstFormHeader" data-role="none">
								<span class="cstheaderTextTheme" data-role="none">Diagnosis Details</span>
							</div>
						 	<div class="cstRowDivider"></div>
						 	
						 	
						 	<!-- Diagnosis Set field Starts -->				
							<div class="cstFieldRowContainer" data-role="none">
								<div style="display:table;width:100%">
									<div style="display:table-row">
						 				<div style="display:table-cell;width:30%;text-align:right;vertical-align:middle">
						 					<div class="cstFieldLabel" id="cmbDiagSet_Label">Diagnosis Set<font style="color: red">*</font></div>
						 				</div>
						 				<div style="display:table-cell;width:60%;">
						 					<div class="cstFieldContainer1 cstFieldContainerTheme" >
						 						<input id="cmbDiagSet" name="cmbDiagSet" id="cmbDiagSet" data-type="ComboBox" data-role="none" data-mandatory="true" />
						 						<input type="hidden" name="hdnDiagSet" id="hdnDiagSet" id="hdnDiagSet" value='' />
						 					</div>
						 				</div>
						 				<div style="display:table-cell;width:10%"></div>
						 			</div>
				   	    		</div>
				   	    	</div>
				   	    	<div class="cstRowDivider"></div>
				   	    	<!-- Diagnosis Set field Ends -->			
				   	    	
				   	    	<div id="RDAllOtherFields"  style="display:none;"> <!--  A div to enclose all fields other than Diagnosis Set, since all other fields won't be displayed if Diagnosis Set field is not selected -->

				   	    	
				   	    	<!-- Diagnosis Code field Starts -->
				   	    	<div class="cstFieldRowContainer" data-role="none">
								<div style="display:table;width:100%">
									<div style="display:table-row">
						 				<div style="display:table-cell;width:30%;text-align:right;vertical-align:middle">
						 					<div class="cstFieldLabel" id="hdnDiagCode_Label">Diagnosis Code<font style="color: red">*</font></div>
						 				</div>
						 				<div style="display:table-cell;width:60%;">
						 					<!-- Error Message Container for diagnosis code -->
						 					<div class="cstFieldContainer1 cstFieldContainerTheme" onclick="showDiagnosisSfs()">
						 						<div class="formValWarningTheme formValError" id="hdnDiagCode_Warning" style="top: 45px; left: 0px; display: none">
													<div class="formValErrorMsgTheme" id="hdnDiagCode_WarningMsg"></div>
												</div> 
						 						<div style="display:table">
						 							<div style="display:table-row">
						 								<div style="display:table-cell;width:99%;vertical-align:middle;padding-left:5px;" id="DiagCodeField">
						 								</div>
						 								<input type="hidden" name="hdnDiagCode" id="hdnDiagCode" id="hdnDiagCode" value='' data-mandatory="true" data-errmsg1="An active record already exists for this Diagnosis"/>
						 								<div style="display:table-cell;width:1%">
						 									<div class="cstSearchIconCell"><div data-role = "none" class = "cstSfsFieldSearchIcon"></div></div>
						 								</div>
						 							</div>
						 						</div>

						 					</div>
						 				</div>
						 				<div style="display:table-cell;width:10%"></div>
						 			</div>
				   	    		</div>
				   	    	</div>
				   	    	<div class="cstRowDivider"></div>			
							<!-- Diagnosis Code field Ends -->	
							
							<!-- Diagnosis Desc field Starts -->
							<div class="cstFieldRowContainer2" data-role="none">
								<div style="display:table;width:100%">
									<div style="display:table-row">
						 				<div style="display:table-cell;width:30%;text-align:right;vertical-align:middle">
						 					<div class="cstFieldLabel" id="txtDiagDesc_Label">Description<font style="color: red">*</font></div>
						 				</div>
						 				<div style="display:table-cell;width:60%;">
						 					<div class="cstFieldContainer2 cstFieldContainerTheme">
						 						<textarea class="csttxtArea" maxlength="500" data-role="none" id="txtDiagDesc" name="txtDiagDesc" style="display: block" data-mandatory="true" rows="6" cols="30" >
	      										</textarea>
						 					</div>
						 				</div>
						 				<div style="display:table-cell;width:10%"></div>
						 			</div>
				   	    		</div>
				   	    	</div>
				   	    	<div class="cstRowDivider"></div>
							<!-- Diagnosis Desc field Ends -->
							
							
							
							<div id="EncounterStageFieldWrap">
							<!-- Encounter Stages Starts -->
							<div class="cstFieldRowContainer" data-role="none">
								<div style="display:table;width:100%">
									<div style="display:table-row">
						 				<div style="display:table-cell;width:30%;text-align:right;vertical-align:middle">
						 					<div class="cstFieldLabel">Encounter Stages<font style="color: red">*</font></div>
						 				</div>
						 				<div style="display:table-cell;width:60%;" >
						 					<div class="cstFieldContainer1" >
												<div  class="parent" data-role="none">
													<div id="EncStageSlider" class="scale scaleTheme" data-role="none">
														<div data-role="none" class="Round roundTheme" id="EncStageSlidePointer" data-count="I" 
														data-parent = "EncStageSlider" data-numpoints="3" data-drag="N" data-dragdiv="EncStageScaleHover" 
														data-valuefield="hdnEncStage" data-value1="A" data-value2="D" data-value3="I" data-defaultvalue="A" 
														data-selstylelabel="slSelectedLabel"></div>
														<input type="hidden" id="hdnEncStage" name="hdnEncStage" id="hdnEncStage" value="">
														<div data-role="none" class="scaleHover scaleHoverTheme" id="EncStageScaleHover"></div>
	
														<div data-role="none" class="threescaleSeparator1 scaleSeparatorTheme"></div>
														<div data-role="none" class="threescaleSeparator2 scaleSeparatorTheme"></div>
														<div data-role="none" class="threescaleSeparator3 scaleSeparatorTheme"></div>
	
													</div>
													<div style="display:table;height:20px;width:100%;height:100%">
														<div style="display:table-row">
															<div style="display:table-cell;vertical-align:middle;text-align:left;width:33%" class="dvSliderLabel" data-labelfor="EncStageSlidePointer-1" data-labelval="1" >Admission</div>
															<div style="display:table-cell;vertical-align:middle;text-align:center;width:33%" class="dvSliderLabel" data-labelfor="EncStageSlidePointer-2" data-labelval="2" >Discharge</div>
															<div style="display:table-cell;vertical-align:middle;text-align:right;width:33%" class="dvSliderLabel" data-labelfor="EncStageSlidePointer-3" data-labelval="3" >Intermediate</div>
														</div>
													</div>
													<!-- <div style="position: relative; width: 100%; height: 20px">
														<div style="position: absolute; left: 0.5%;" class = "dvSliderLabel" data-labelfor="EncStageSlidePointer-1">Admission</div>
														<div style="position: absolute; left: 45%" class = "dvSliderLabel" data-labelfor="EncStageSlidePointer-2">Discharge</div>
														<div style="position: absolute; right: 1%" class = "dvSliderLabel" data-labelfor="EncStageSlidePointer-3">Intermediate</div>
													</div> -->
												</div>
						 					</div>
						 				</div>
						 				<div style="display:table-cell;width:10%"></div>
						 			</div>
				   	    		</div>
				   	    	</div>
				   	    	<div class="cstRowDivider"></div>
				   	    	<!-- Encounter Stages field Ends -->	
				   	    	</div>
				   	    	
				   	    	
				   	    	<!-- Diagnosis Classification field Starts -->
				   	    	<div class="cstFieldRowContainer" data-role="none">
								<div style="display:table;width:100%">
									<div style="display:table-row">
						 				<div style="display:table-cell;width:30%;text-align:right;vertical-align:middle">
						 					<div class="cstFieldLabel" id="cmbDiagClass_Label">Diagnosis Classification</div>
						 				</div>
						 				<div style="display:table-cell;width:60%;">
						 					<div class="cstFieldContainer1 cstFieldContainerTheme" >
						 						<!-- Error Message Container for Duplicate primary diagnosis -->
												<div class="formValWarningTheme formValError" id="cmbDiagClass_Warning" style="top: 45px; left: 0px; display: none">
													<div class="formValErrorMsgTheme" id="cmbDiagClass_WarningMsg"></div>
												</div> 
												<input id="cmbDiagClass" name="cmbDiagClass" id="cmbDiagClass" data-type="ComboBox" data-role="none" data-mandatory="false" onchange="validateDuplicatePrimaryDiag(this)"
												data-errmsg1="Primary Diagnosis already exists"/>
								 				<script>
													$(document).ready(function() {
														$("#cmbDiagClass").kendoComboBox({
												  			dataTextField: "desc",
									                        dataValueField: "code",
									                        change: function(e) {
									                            var value = this.value();
									                            if(this.select()==-1){
									                            	this.value('');
									                            	$("#hdnDiagClass").val("");
									                            }
									                            else{
									                            	$("#hdnDiagClass").val(this.value());
									                            }
									                          }
														});
									 				 });
												</script>
												<input type="hidden" name="hdnDiagClass" id="hdnDiagClass" id="hdnDiagClass" value='' />
						 					</div>
						 				</div>
						 				<div style="display:table-cell;width:10%"></div>
						 			</div>
				   	    		</div>
				   	    	</div>
				   	    	<div class="cstRowDivider"></div>
				   	    	<!-- Diagnosis Classification field Ends -->	
				   	    	
				   	    	<!-- Chief Complaints field Starts -->
				   	    	<div class="cstFieldRowContainer" data-role="none">
								<div style="display:table;width:100%">
									<div style="display:table-row">
						 				<div style="display:table-cell;width:30%;text-align:right;vertical-align:middle">
						 					<div class="cstFieldLabel">Chief Complaint</div>
						 				</div>
						 				<div style="display:table-cell;width:60%;">
						 					<div class="cstFieldContainer1 cstFieldContainerTheme" >
						 						<select id="mulComplaints" multiple="multiple" style = "height:40px" data-type = "ComboBox"> 
										      	</select>
							   					 <script>
							   					 $(document).ready(function() {
							   						 $("#mulComplaints").kendoMultiSelect({
							   							dataTextField: "desc",
								                        dataValueField: "code",
								                        change: function(e) {
								                            var value = this.value();
								                            var complStr = "";
								                            for(var i=0; i<value.length;i++){
								                            	complStr = complStr+value[i]+"$";
								                            }
								                            $("#hdnDiagCompl").val(complStr);
								                            // Use the value of the widget
								                        }
							   						});
							   					 });
							   					 </script>
							   					 <input type="hidden" name="hdnDiagCompl" id="hdnDiagCompl" id="hdnDiagCompl" value='' />
						 					</div>
						 				</div>
						 				<div style="display:table-cell;width:10%"></div>
						 			</div>
				   	    		</div>
				   	    	</div>
				   	    	<div class="cstRowDivider"></div>
				   	    	<!-- Chief Complaints field Ends -->
				   	    	
				   	    	<div id="NatureFieldWrap">
				   	    	<!-- Nature Field Starts -->
				   	    	<div class="cstFieldRowContainer" data-role="none">
								<div style="display:table;width:100%">
									<div style="display:table-row">
						 				<div style="display:table-cell;width:30%;text-align:right;vertical-align:middle">
						 					<div class="cstFieldLabel">Nature<font style="color: red">*</font></div>
						 				</div>
						 				<div style="display:table-cell;width:60%;" >
						 					<div class="cstFieldContainer1" >
												<div  class="parent" data-role="none">
													<div id="NatureSlider" class="scale scaleTheme" data-role="none">
														<div data-role="none" class="Round roundTheme" id="NatureSlidePointer" data-count="I" 
														data-parent = "NatureSlider" data-numpoints="3" data-drag="N" data-dragdiv="NatureScaleHover" 
														data-valuefield="hdnNature" data-value1="A" data-value2="W" data-value3="P" data-defaultvalue="A" 
														data-selstylelabel="slSelectedLabel"></div>
														<input type="hidden" id="hdnNature" name="hdnNature" id="hdnNature" value="">
														<div data-role="none" class="scaleHover scaleHoverTheme" id="NatureScaleHover"></div>
	
														<div data-role="none" class="threescaleSeparator1 scaleSeparatorTheme"></div>
														<div data-role="none" class="threescaleSeparator2 scaleSeparatorTheme"></div>
														<div data-role="none" class="threescaleSeparator3 scaleSeparatorTheme"></div>
	
													</div>
													<!-- <div style="position: relative; width: 100%; height: 20px">
														<div style="position: absolute; left: 0.5%;" class = "dvSliderLabel" data-labelfor="NatureSlidePointer-1">Actual</div>
														<div style="position: absolute; left: 45%" class = "dvSliderLabel" data-labelfor="NatureSlidePointer-2">Wellness</div>
														<div style="position: absolute; right: 1%" class = "dvSliderLabel" data-labelfor="NatureSlidePointer-3">Potential</div>
													</div> -->
													<div style="display:table;height:20px;width:100%;height:100%">
														<div style="display:table-row">
															<div style="display:table-cell;vertical-align:middle;text-align:left;width:33%" class="dvSliderLabel" data-labelfor="NatureSlidePointer-1" data-labelval="1" >Actual</div>
															<div style="display:table-cell;vertical-align:middle;text-align:center;width:33%" class="dvSliderLabel" data-labelfor="NatureSlidePointer-2" data-labelval="2" >Wellness</div>
															<div style="display:table-cell;vertical-align:middle;text-align:right;width:33%" class="dvSliderLabel" data-labelfor="NatureSlidePointer-3" data-labelval="3" >Potential</div>
														</div>
													</div>
												</div>
						 					</div>
						 				</div>
						 				<div style="display:table-cell;width:10%"></div>
						 			</div>
				   	    		</div>
				   	    	</div>
				   	    	<div class="cstRowDivider"></div>
				   	    	<!-- Nature field Ends -->	
				   	    	</div>
				   	    	
				   	    	
				   	    	<!-- Accuracy field Starts -->
				   	    	<div class="cstFieldRowContainer" data-role="none">
								<div style="display:table;width:100%">
									<div style="display:table-row">
						 				<div style="display:table-cell;width:30%;text-align:right;vertical-align:middle">
						 					<div class="cstFieldLabel" id="cmbAccuracy_Label">Accuracy<font style="color: red">*</font></div>
						 				</div>
						 				<div style="display:table-cell;width:60%;">
						 					<div class="cstFieldContainer1 cstFieldContainerTheme" >
						 						<input id="cmbAccuracy" name="cmbAccuracy" id="cmbAccuracy" data-type="ComboBox" data-role="none" data-mandatory="true" />
								 				<script>
													$("#cmbAccuracy").kendoComboBox({
														dataTextField: "desc",
								                        dataValueField: "code",
								                        change: function(e) {
								                            if(this.select()==-1){
								                            	this.value('');
								                            	$("#hdnDiagAcc").val("");
								                            	$("#hdnDiagAccInd").val("");
								                            }
								                            else{
								                            	var selected = this.select();
								                            	var accInd = diagAccuracyDataSrc.diagAccuracyList[selected].accInd;
								                            	$("#hdnDiagAcc").val(this.value());
								                            	$("#hdnDiagAccInd").val(accInd);
								                            }
								                         }
													});
												</script>
												<input type="hidden" name="hdnDiagAcc" id="hdnDiagAcc" id="hdnDiagAcc" value='' />
												<input type="hidden" name="hdnDiagAccInd" id="hdnDiagAccInd" id="hdnDiagAccInd" value='' />
						 					</div>
						 				</div>
						 				<div style="display:table-cell;width:10%"></div>
						 			</div>
				   	    		</div>
				   	    	</div>
				   	    	<div class="cstRowDivider"></div>				
				   	    	<!-- Accuracy field Ends -->	
	
							<div id="SeverityFieldWrap">
							<!-- Severity Field Starts -->
							<div class="cstFieldRowContainer" data-role="none">
								<div style="display:table;width:100%">
									<div style="display:table-row">
						 				<div style="display:table-cell;width:30%;text-align:right;vertical-align:middle">
						 					<div class="cstFieldLabel">Severity</div>
						 				</div>
						 				<div style="display:table-cell;width:60%;" >
						 					<div class="cstFieldContainer1" >
												<div  class="parent" data-role="none">
													<div id="SeveritySlider" class="scale scaleTheme2" data-role="none">
														<div data-role="none" class="Round roundTheme" id="SeveritySlidePointer" data-count="I" 
														data-parent = "SeveritySlider" data-numpoints="4" data-drag="Y" data-dragdiv="SeverityScaleHover" 
														data-valuefield="hdnSeverity" data-value1="D" data-value2="L" data-value3="S" data-value4="E" data-defaultvalue="D" 
														data-selstylelabel="slSelectedLabel"></div>
														<input type="hidden" id="hdnSeverity" name="hdnSeverity" id="hdnSeverity" value="">
														<div data-role="none" class="scaleHover scaleHoverTheme" id="SeverityScaleHover"></div>
	
														<div data-role="none" class="scaleSeparator1 scaleSeparatorTheme"></div>
														<div data-role="none" class="scaleSeparator2 scaleSeparatorTheme"></div>
														<div data-role="none" class="scaleSeparator3 scaleSeparatorTheme"></div>
														<div data-role="none" class="scaleSeparator4 scaleSeparatorTheme1"></div>
	
													</div>
													<div style="position: relative; width: 100%; height: 20px">
														<div style="position: absolute; left: 0.5%" class = "dvSliderLabel" data-labelfor="SeveritySlidePointer-1" data-labelval="1" >Moderate</div>
														<div style="position: absolute; left: 31%" class = "dvSliderLabel" data-labelfor="SeveritySlidePointer-2" data-labelval="2" >Severe</div>
														<div style="position: absolute; left: 64%" class = "dvSliderLabel" data-labelfor="SeveritySlidePointer-3" data-labelval="3" >Mild</div>
														<div style="position: absolute; right: 1%" class = "dvSliderLabel" data-labelfor="SeveritySlidePointer-4" data-labelval="4" >Extreme</div>
													</div> 
													<!-- <div style="display:table;height:20px;width:100%;height:100%">
														<div style="display:table-row">
															<div style="display:table-cell;vertical-align:middle;text-align:left;width:25%" class="dvSliderLabel" data-labelfor="SeveritySlidePointer-1">Moderate</div>
															<div style="display:table-cell;vertical-align:middle;text-align:center;width:25%" class="dvSliderLabel" data-labelfor="SeveritySlidePointer-2">Severe</div>
															<div style="display:table-cell;vertical-align:middle;text-align:center;width:25%" class="dvSliderLabel" data-labelfor="SeveritySlidePointer-3">Mild</div>
															<div style="display:table-cell;vertical-align:middle;text-align:right;width:25%" class="dvSliderLabel" data-labelfor="SeveritySlidePointer-4">Extreme</div>
														</div>
													</div> -->
												</div>
						 					</div>
						 				</div>
						 				<div style="display:table-cell;width:10%"></div>
						 			</div>
				   	    		</div>
				   	    	</div>
				   	    	<div class="cstRowDivider"></div>
				   	    	<!-- Severity field Ends -->
				   	    	</div>	
				   	    	
				   	    	<div id="PriorityFieldWrap">
				   	    	<!-- Priority Field Starts -->	
				   	    	<div class="cstFieldRowContainer" data-role="none">
								<div style="display:table;width:100%">
									<div style="display:table-row">
						 				<div style="display:table-cell;width:30%;text-align:right;vertical-align:middle">
						 					<div class="cstFieldLabel">Priority</div>
						 				</div>
						 				<div style="display:table-cell;width:60%;" >
						 					<div class="cstFieldContainer1" >
												<div  class="parent" data-role="none">
													<div id="PrioritySlider" class="scale scaleTheme2" data-role="none">
														<div data-role="none" class="Round roundTheme" id="PrioritySlidePointer" data-count="I" 
														data-parent = "PrioritySlider" data-numpoints="3" data-drag="Y" data-dragdiv="PriorityScaleHover" 
														data-valuefield="hdnPriority" data-value1="N" data-value2="H" data-value3="C" data-defaultvalue="N" 
														data-selstylelabel="slSelectedLabel"></div>
														<input type="hidden" id="hdnPriority" name="hdnPriority" id="hdnPriority" value="">
														<div data-role="none" class="scaleHover scaleHoverTheme" id="PriorityScaleHover"></div>
	
														<div data-role="none" class="threescaleSeparator1 scaleSeparatorTheme"></div>
														<div data-role="none" class="threescaleSeparator2 scaleSeparatorTheme"></div>
														<div data-role="none" class="threescaleSeparator3 scaleSeparatorTheme"></div>
	
													</div>
													<!-- <div style="position: relative; width: 100%; height: 20px">
														<div style="position: absolute; left: 0.5%;" class = "dvSliderLabel" data-labelfor="PrioritySlidePointer-1">Normal</div>
														<div style="position: absolute; left: 45%" class = "dvSliderLabel" data-labelfor="PrioritySlidePointer-2">High</div>
														<div style="position: absolute; right: 1%" class = "dvSliderLabel" data-labelfor="PrioritySlidePointer-3">Critical</div>
													</div> -->
													<div style="display:table;height:20px;width:100%;height:100%">
														<div style="display:table-row">
															<div style="display:table-cell;vertical-align:middle;text-align:left;width:33%" class="dvSliderLabel" data-labelfor="PrioritySlidePointer-1" data-labelval="1" >Normal</div>
															<div style="display:table-cell;vertical-align:middle;text-align:center;width:33%" class="dvSliderLabel" data-labelfor="PrioritySlidePointer-2" data-labelval="2" >High</div>
															<div style="display:table-cell;vertical-align:middle;text-align:right;width:33%" class="dvSliderLabel" data-labelfor="PrioritySlidePointer-3" data-labelval="3" >Critical</div>
														</div>
													</div>
												</div>
						 					</div>
						 				</div>
						 				<div style="display:table-cell;width:10%"></div>
						 			</div>
				   	    		</div>
				   	    	</div>			
				   	    	<div class="cstRowDivider"></div>
				   	    	<!-- Priority field Ends -->	
				   	    	</div>
				   	    	
				   	    	<div id="OnsetTypeFieldWrap">
				   	    	<!-- Onset Type Field Starts -->
				   	    	<div class="cstFieldRowContainer" data-role="none">
								<div style="display:table;width:100%">
									<div style="display:table-row">
						 				<div style="display:table-cell;width:30%;text-align:right;vertical-align:middle">
						 					<div class="cstFieldLabel">Onset Type</div>
						 				</div>
						 				<div style="display:table-cell;width:60%;" >
						 					<div class="cstFieldContainer1" >
												<div  class="parent" data-role="none">
													<div id="OnsetTypeSlider" class="scale scaleTheme" data-role="none">
														<div data-role="none" class="Round roundTheme" id="OnsetTypeSlidePointer" data-count="I" 
														data-parent = "OnsetTypeSlider" data-numpoints="3" data-drag="N" data-dragdiv="OnsetTypeScaleHover" 
														data-valuefield="hdnOnsetType" data-value1="N" data-value2="A" data-value3="C" data-defaultvalue="N" 
														data-selstylelabel="slSelectedLabel"></div>
														<input type="hidden" id="hdnOnsetType" name="hdnOnsetType" id="hdnOnsetType" value="N">
														<div data-role="none" class="scaleHover scaleHoverTheme" id="OnsetTypeScaleHover"></div>
	
														<div data-role="none" class="threescaleSeparator1 scaleSeparatorTheme"></div>
														<div data-role="none" class="threescaleSeparator2 scaleSeparatorTheme"></div>
														<div data-role="none" class="threescaleSeparator3 scaleSeparatorTheme"></div>
	
													</div>
													<!-- <div style="position: relative; width: 100%; height: 20px">
														<div style="position: absolute; left: 0.5%;" class = "dvSliderLabel" data-labelfor="OnsetTypeSlidePointer-1">Not Applicable</div>
														<div style="position: absolute; left: 45%" class = "dvSliderLabel" data-labelfor="OnsetTypeSlidePointer-2">Acute</div>
														<div style="position: absolute; right: 1%" class = "dvSliderLabel" data-labelfor="OnsetTypeSlidePointer-3">Chronic</div>
													</div> -->
													<div style="display:table;height:20px;width:100%;height:100%">
														<div style="display:table-row">
															<div style="display:table-cell;vertical-align:middle;text-align:left;width:33%" class="dvSliderLabel" data-labelfor="OnsetTypeSlidePointer-1" data-labelval="1" >Not Applicable</div>
															<div style="display:table-cell;vertical-align:middle;text-align:center;width:33%" class="dvSliderLabel" data-labelfor="OnsetTypeSlidePointer-2" data-labelval="2" >Acute</div>
															<div style="display:table-cell;vertical-align:middle;text-align:right;width:33%" class="dvSliderLabel" data-labelfor="OnsetTypeSlidePointer-3" data-labelval="3" >Chronic</div>
														</div>
													</div>
												</div>
						 					</div>
						 				</div>
						 				<div style="display:table-cell;width:10%"></div>
						 			</div>
				   	    		</div>
				   	    	</div>			
				   	    	<div class="cstRowDivider"></div>
				   	    	<!-- Onset Type field Ends -->
				   	    	</div>
				   	    	
				   	    	
				   	    	<!-- Onset date field Starts -->
				   	    	<div class="cstFieldRowContainer" data-role="none">
								<div style="display:table;width:100%">
									<div style="display:table-row">
						 				<div style="display:table-cell;width:30%;text-align:right;vertical-align:middle">
						 					<div class="cstFieldLabel" id="OnsetDate_Label">Onset Date<font style="color: red">*</font></div>
						 				</div>
						 				<div style="display:table-cell;width:60%;">
						 					<div class="cstFieldContainer1 cstFieldContainerTheme" >
						 						<!-- Error Message Container for onset date -->
												<div class="formValWarningTheme formValError" id="OnsetDate_Warning" style="top: 45px; left: 0px; display: none">
													<div class="formValErrorMsgTheme" id="OnsetDate_WarningMsg"></div>
												</div> 
												<input id="OnsetDate" data-type="Date" data-count="I" style="text-align:right" data-role="none" onchange="validate(this)"
													data-errmsg1="Onset date should be between Date of Birth and current date" data-mandatory="true" /> 
													<script>
											            $(document).ready(function() {
											                // create DateTimePicker from input HTML element
											               // var today1 = new Date();
											                $("#OnsetDate").kendoDateTimePicker({
											        			value: today,
											        			format: "dd/MM/yyyy hh:mm tt",
											        			max:today,
											        			min:patDOB,
											        			change: function() {
										        			        var value = this.value();
										        			        $("#hdnOnsetDateTime").val(DMYHMToString(value));
										        				}
											                });
											            });
											        </script>
											       <input type="hidden" id="hdnOnsetDateTime" name="hdnOnsetDateTime" id="hdnOnsetDateTime" value="">
						 					</div>
						 				</div>
						 				<div style="display:table-cell;width:10%"></div>
						 			</div>
				   	    		</div>
				   	    	</div>
				   	    	<div class="cstRowDivider"></div>
				   	    					
				   	    	<!-- Onset Date field Ends -->
				   	    	
				   	    	<!-- As on date field Starts -->
				   	    	
				   	    	<div class="cstFieldRowContainer" data-role="none">
								<div style="display:table;width:100%">
									<div style="display:table-row">
						 				<div style="display:table-cell;width:30%;text-align:right;vertical-align:middle">
						 					<div class="cstFieldLabel" id="AsOnDate_Label">As On<font style="color: red">*</font></div>
						 				</div>
						 				<div style="display:table-cell;width:60%;">
						 					<div class="cstFieldContainer1 cstFieldContainerTheme" >
						 						<!-- Error Message Container for as on date -->
												<div class="formValWarningTheme formValError" id="AsOnDate_Warning" style="top: 45px; left: 0px; display: none">
													<div class="formValErrorMsgTheme" id="AsOnDate_WarningMsg"></div>
												</div> 
												<input id="AsOnDate" data-type="Date" style="text-align:right" data-role="none" onchange="validate(this)"
													data-errmsg1="Status Date should be between Onset Date and Current Date" data-mandatory="true" /> 
													<script>
														$(document).ready(function() {
											                // create DateTimePicker from input HTML element
											               // var today1 = new Date();
											                onsetDTPicker = $("#OnsetDate").data("kendoDateTimePicker");
											                $("#AsOnDate").kendoDatePicker({
											        			value: today,
											        			format: "dd/MM/yyyy",
											        			max: today,
											        			min:patDOB,
											        			change: function() {
										        			        var value = this.value();
										        			        $("#hdnAsOnDate").val(DMYToString(value));
										        				}
											                });
											            });
											        </script>
											        <input type="hidden" id="hdnAsOnDate" name="hdnAsOnDate" id="hdnAsOnDate" value="">
						 					</div>
						 				</div>
						 				<div style="display:table-cell;width:10%"></div>
						 			</div>
				   	    		</div>
				   	    	</div>
				   	    	<div class="cstRowDivider"></div>
				   	    	<!-- As on Date field Ends -->
				   	    	
				   	    	<!-- Anatomical site field Starts -->
				   	    	<div class="cstFieldRowContainer" data-role="none">
								<div style="display:table;width:100%">
									<div style="display:table-row">
						 				<div style="display:table-cell;width:30%;text-align:right;vertical-align:middle">
						 					<div class="cstFieldLabel">Anatomical Site</div>
						 				</div>
						 				<div style="display:table-cell;width:60%;">
						 					<div class="cstFieldContainer1" >
						 						<div style="display:table;width:100%;height:100%">
						 							<div style="display:table-row;">
						 								<div style="display:table-cell;vertical-align:middle;">
						 									<div class="cstFieldContainerTheme cstFieldContainer3">
						 										<div style="display:table;width:100%;height:100%">
						 											<div style="display:table-row">
						 												<div style="display:table-cell;vertical-align:middle;text-align:right;padding-right:5px">
						 													<div class="dvSliderLabel" data-labelfor="AnatomicalSlidePointer-1" data-labelval="1" >Oral Cavity</div>
						 												</div>
						 												<div style="display:table-cell;vertical-align:middle;text-align:center;width:50px">
						 													<div class = "sliderSmallParent" data-role = "none"> 
																		  		<div  class = "sliderSmallScale sfsScaleTheme" id="AnatomicalSlider"  data-role = "none" >
																		  			<div class="sliderSfsIns sliderSfsInsTheme">
																			  		    <div data-role = "none" class = "sliderSmallPointer sfsCritRoundTheme" id = "AnatomicalSlidePointer"
																			  		    data-parent = "AnatomicalSlider" data-numpoints="2" data-drag="N" 
																						data-valuefield="hdnAnatomicalSite" data-value1="C" data-value2="O" data-defaultvalue="O" 
																						data-selstylelabel="slSelectedLabel">
																			  		    </div>
																			  		    <input type="hidden" id="hdnAnatomicalSite" name="hdnAnatomicalSite" id="hdnAnatomicalSite" value="">
																		  		    </div>
																		  		</div>
									  										</div>
						 												</div>
						 												<div style="display:table-cell;vertical-align:middle;text-align:left;padding-left:5px">
						 													<div data-labelfor="AnatomicalSlidePointer-2" class="dvSliderLabel" data-labelval="2" >Others</div>
						 												</div>
						 											</div>
						 										</div>
						 									</div>
						 								</div>
						 								<div style="display:table-cell;width:60%">
						 									<div class="cstFieldContainerTheme cstFieldContainer1">
				 												<input id="cmbAnatSite" name="cmbAnatSite" id="cmbAnatSite" data-type="ComboBox" data-role="none"/>
													 				<script>
																		$("#cmbAnatSite").kendoComboBox({
																			dataTextField: "desc",
													                        dataValueField: "code",
													                        change: function(e) {
													                            if(this.select()==-1){
													                            	this.value('');
													                            	$("#hdnAnatomicalSiteVal").val("");
													                            }
													                            else{
													                            	$("#hdnAnatomicalSiteVal").val(this.value());
													                            }
													                         }
																		});
																	</script>
																	<input type="hidden" id="hdnAnatomicalSiteVal" name="hdnAnatomicalSiteVal" id="hdnAnatomicalSiteVal" value="">
						 									</div>
						 								</div>
						 							</div>
						 						</div>
						 					</div>
						 				</div>
						 				<div style="display:table-cell;width:10%"></div>
						 			</div>
				   	    		</div>
				   	    	</div>

				   	    	<div class="cstRowDivider"></div>
				   	    	<!-- Anatomical site field Ends -->
				   	    	
				   	    	<div id="ApplicableSideFieldWrap">
				   	    	<!-- Applicable Side field Starts -->	
				   	    	<div class="cstFieldRowContainer" data-role="none">
								<div style="display:table;width:100%">
									<div style="display:table-row">
						 				<div style="display:table-cell;width:30%;text-align:right;vertical-align:middle">
						 					<div class="cstFieldLabel">Applicable Side</div>
						 				</div>
						 				<div style="display:table-cell;width:60%;">
						 					<div class="cstFieldContainer1 cstFieldContainerTheme" >
						 						<input id="cmbApplSide" name="cmbApplSide" id="cmbApplSide" data-type="ComboBox" data-role="none"/>
								 				<script>
													$("#cmbApplSide").kendoComboBox({
														dataSource: [
														  { id: "L", name: "Left" },
														  { id: "R", name: "Right" },
														  { id: "B", name: "Both" },
														  { id: "N", name: "Not Applicable" }
														],
														dataTextField: "name",
														dataValueField: "id",
														change: function(e) {
								                            if(this.select()==-1){
								                            	this.value('');
								                            	$("#hdnDiagApplSide").val("");
								                            }
								                            else{
								                            	$("#hdnDiagApplSide").val(this.value());
								                            }
								                         }
													});
												</script>
												<input type="hidden" name="hdnDiagApplSide" id="hdnDiagApplSide" id="hdnDiagApplSide" value='' />
						 					</div>
						 				</div>
						 				<div style="display:table-cell;width:10%"></div>
						 			</div>
				   	    		</div>
				   	    	</div>
				   	    	<div class="cstRowDivider"></div>			

				   	    	<!-- Applicable side field Ends -->	
				   	    	</div>
						 	
						 	<!-- Remarks field Starts -->	
						 	<div class="cstFieldRowContainer2" data-role="none">
								<div style="display:table;width:100%">
									<div style="display:table-row">
						 				<div style="display:table-cell;width:30%;text-align:right;vertical-align:middle">
						 					<div class="cstFieldLabel">Remarks</div>
						 				</div>
						 				<div style="display:table-cell;width:60%;">
						 					<div class="cstFieldContainer2 cstFieldContainerTheme">
						 						<textarea class="csttxtArea" maxlength="2000" data-role="none" id="txtRemarks" name="txtRemarks" style="display: block" rows="6" cols="30">
	      										</textarea>
						 					</div>
						 				</div>
						 				<div style="display:table-cell;width:10%"></div>
						 			</div>
				   	    		</div>
				   	    	</div>
				   	    	<div class="cstRowDivider"></div>		
							<!-- Remarks field Ends -->
						 </div> <!-- Closing RDAllOtherFields div -->
						</div><!-- container -->
					</div>
					<!-- Mandatory fields error -->
					<div class="formValErrorTheme formValError" id="MandatoryFields_Error" style="bottom: 10px; left: 2%; display: none">
						<div class="formValErrorMsgTheme" id="MandatoryFields_ErrorMsg">All mandatory fields must be entered</div>
					</div>
				</div>
				<input type="hidden" name="hdnPath" id="hdnPath" id="hdnPath" value="${path}" /> 
				<input type="hidden" name="hdnMode" id="hdnMode" id="hdnMode" value="RECORD"/>
				<%-- <input type="hidden" name="hdnDiagSetValues" id="hdnDiagSetValues" id="hdnDiagSetValues" value='<%=diagSetJson%>' /> --%>
				<!-- <input type="hidden" name="hdnDiagDesc" id="hdnDiagDesc" id="hdnDiagDesc" value='' /> -->
				<input type="hidden" name="SensitiveDataPwd" id="SensitiveDataPwd" id="SensitiveDataPwd" value="">
				<input type = "hidden" name = "today" id = "today" value="<%=today%>"/>
				<input type = "hidden" name = "patientDOB" id = "patientDOB" value="<%=patientDOB%>"/>
		</form>
	</div>
</body>
</html>

