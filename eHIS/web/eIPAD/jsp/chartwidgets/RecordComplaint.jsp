<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@page import="java.util.ResourceBundle"%>
<%@page import="java.util.*"%>
<%@page import="eIPAD.chartsummary.common.response.*"%>
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
	 //Setting patient DOB and current server date
		var patDOB_str = $("#patientDOB").val();
		patDOB = StringToDate(patDOB_str);
		var today_str = $("#today").val();
		today = StringToDate(today_str);
		
		//Initializing DateTimePicker Objects
		onsetDTPicker = $("#OnsetDate").data("kendoDateTimePicker");
		
		//to enable scrolling inside textarea
		$('textarea').each(function(index){
			$(this).bind('touchmove', function(event){
		    	event.stopPropagation();
			});
		});
		   
});


</script>

</head>
<body>
	<div id="divParent" class="divParent" data-role="page" style="padding: 0px">
		<form name = "frmRecordCompl" id = "frmRecordCompl" style="width: 100%; height: 100%" action="${path}//mobile/chartsummary/ComplaintTransaction">
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
																			<div class="flipButtonInActiveTheme headerflipButton" id="DiagnosisSwitch" onclick="openDiagnosisFrame()">Record Diagnosis</div>
																		</div>
																		<div style="display:table-cell;vertical-align:middle">
																			<div class="flipButtonActiveTheme headerflipButton" id="ComplaintsSwitch" >Chief Complaint</div>
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
																<div class="WidgetButtonTheme" id="RecordComplSubmitButton" onclick="validateAndRecordComplaint()">
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
								<span class="cstheaderTextTheme" data-role="none">Complaint Details</span>
							</div>
						 	<div class="cstRowDivider"></div>
						 	
						 	<!-- Complaint Code field Starts -->
				   	    	<div class="cstFieldRowContainer" data-role="none">
								<div style="display:table;width:100%">
									<div style="display:table-row">
						 				<div style="display:table-cell;width:30%;text-align:right;vertical-align:middle">
						 					<div class="cstFieldLabel" id="hdnComplCode_Label">Complaint Code<font style="color: red">*</font></div>
						 				</div>
						 				<div style="display:table-cell;width:60%;">
						 					
						 					<div class="cstFieldContainer1 cstFieldContainerTheme" onclick="showComplaintSfs()">
						 						<!-- Error Message Container for complaint code -->
						 						<div class="formValWarningTheme formValError" id="hdnComplCode_Warning" style="top: 45px; left: 0px; display: none">
													<div class="formValErrorMsgTheme" id="hdnComplCode_WarningMsg"></div>
												</div> 
						 						<div style="display:table">
						 							<div style="display:table-row">
						 								<div style="display:table-cell;width:99%;vertical-align:middle;padding-left:5px;" id="ComplCodeField">
						 								</div>
						 								<input type="hidden" name="hdnComplCode" id="hdnComplCode" id="hdnComplCode" value='' data-mandatory="true" data-errmsg1="Record already exists"/>
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
							<!-- Complaint Code field Ends -->	
							
							<!-- Complaint Desc field Starts -->
							<div class="cstFieldRowContainer2" data-role="none">
								<div style="display:table;width:100%">
									<div style="display:table-row">
						 				<div style="display:table-cell;width:30%;text-align:right;vertical-align:middle">
						 					<div class="cstFieldLabel" id="txtComplDesc_Label">Complaint Details<font style="color: red">*</font></div>
						 				</div>
						 				<div style="display:table-cell;width:60%;">
						 					<div class="cstFieldContainer2 cstFieldContainerTheme">
						 						<textarea class="csttxtArea" maxlength="500"  data-role="none" id="txtComplDesc" name="txtComplDesc" style="display: block" data-mandatory="true"></textarea>
						 					</div>
						 				</div>
						 				<div style="display:table-cell;width:10%"></div>
						 			</div>
				   	    		</div>
				   	    	</div>
				   	    	<div class="cstRowDivider"></div>
							<!-- Complaint Desc field Ends -->
							
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
				   	    	
				   	    	<!-- Remarks field Starts -->	
						 	<div class="cstFieldRowContainer2" data-role="none">
								<div style="display:table;width:100%">
									<div style="display:table-row">
						 				<div style="display:table-cell;width:30%;text-align:right;vertical-align:middle">
						 					<div class="cstFieldLabel">Remarks</div>
						 				</div>
						 				<div style="display:table-cell;width:60%;">
						 					<div class="cstFieldContainer2 cstFieldContainerTheme">
						 						<textarea class="csttxtArea" maxlength="2000"  data-role="none" id="txtRemarks" name="txtRemarks" style="display: block" rows="6" cols="10"></textarea>
						 					</div>
						 				</div>
						 				<div style="display:table-cell;width:10%"></div>
						 			</div>
				   	    		</div>
				   	    	</div>
				   	    	<div class="cstRowDivider"></div>		
							<!-- Remarks field Ends -->


						 	
						</div><!-- container -->
					</div>
					<!-- Mandatory fields error -->
					<div class="formValErrorTheme formValError" id="MandatoryFields_Error" style="bottom: 10px; left: 2%; display: none">
						<div class="formValErrorMsgTheme" id="MandatoryFields_ErrorMsg">All mandatory fields must be entered</div>
					</div>
				</div>
				<input type="hidden" name="hdnPath" id="hdnPath" id="hdnPath" value="${path}" /> 
				<input type="hidden" name="hdnMode" id="hdnMode" id="hdnMode" value="RECORD"/>
				<input type = "hidden" name = "today" id = "today" value="<%=today%>"/>
				<input type = "hidden" name = "patientDOB" id = "patientDOB" value="<%=patientDOB%>"/>
		</form>
	</div>
</body>
</html>

