<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="java.util.*"%>
<%@ page import="com.google.gson.*"%>
<%@ page
	import="eIPAD.chartsummary.allergies.response.EventTypeResponse"%>
<%@ page import="eIPAD.chartsummary.allergies.healthobject.*"%>
<%@ page import="eIPAD.chartsummary.common.response.ErrorInfo"%>
<%@ page import="eIPAD.chartsummary.common.healthobject.PatContext"%>
<c:set var="path" value="${pageContext.request.contextPath}" />

<%
EventTypeResponse oEvntTypeRes = null;
List<EventType> oLstEvntType = null;
String eventTypeResponse = "";
Gson gson = new Gson();
if(request.getAttribute("EventTypeResponse") != null)
{

	oEvntTypeRes = (EventTypeResponse)request.getAttribute("EventTypeResponse");
	if(oEvntTypeRes != null)
	{
		oLstEvntType = oEvntTypeRes.getLstEventTypeDetails();
		if(oLstEvntType != null && oLstEvntType.size() > 0)
		{
			eventTypeResponse = gson.toJson(oLstEvntType);
		}
		
	}
}
String patientDOB="";
PatContext patContext= (PatContext)session.getAttribute("PatientContext");
if(patContext!=null){
	patientDOB = patContext.getDob();
}
//setting current date in dd/mm/yyyy hh:mm
java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm");
String today = dateFormat.format(new java.util.Date());

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
<title></title>
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
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
<script type="application/javascript" src="${path}/eIPAD/js/AllergyTransaction.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>

document.addEventListener('touchmove', function (e) { e.preventDefault(); }, false);
document.addEventListener('DOMContentLoaded', allergyScroll, false);


</script>
<style>



</style>
</head>
<body>
   	<div id="divParent" class="divParent" data-role="page"
		style="padding: 0px">
		<form name="frmRecordAllergy" id="frmRecordAllergy" id="frmRecordAllergy" method="post" style="width: 100%; height: 100%" action="${path}/mobile/chartsummary/AllergyTransactionServlet">
			<!-- Remove reaction -->
			 <div data-role = "none" id = "dvMez" class = "blurPopup" data-popid=""></div>
			 <div id = "sfsarrowUp" data-role = "none" class = "RA-sfs-bubble-arrow RA-sfs-bubble-UpArrowTheme" ></div>
			 <div id = "sfsarrowDown" data-role = "none" class = "RA-sfs-bubble-arrowDown RA-sfs-bubble-DownArrowTheme" ></div>
			 <div id = "dvRemoveReaction" data-role = "none" class = "dvRemoveReaction dvRemoveReactionTheme" onclick = "deleteReaction(this)">Remove</div>
			<!-- Remove reaction end --->
			<!-- popup container  -->
			<div data-role="none" class="allergenSfs sfsIPTheme" id="sfs">
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
											<div class="allergyHeaderPageTitle ipHeaderPageTitleTheme"><%=csResBundle.getString("allergy.allergen") %></div>
										</div>
										<div class="AllergyCell" style="width: 1%">
											<div class="RecordAllergyTable">
												<div class="normalRow">
													<div class="AllergyCell"
														style="width: auto; text-align: right">
														<div class="buttonContainer">
															<div class="WidgetButtonTheme"
																id="RecordAllergySubmitButton"
																onclick="validateAndRecordAllergy()">
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
			<div id="divcnt" class="divAllergyContent divAllergyContentTheme"
				style="padding: 0px; overflow: hidden" data-role="none">
				<div style="width: 100%; height: auto; overflow: auto"
					data-role="none">
					<div data-role="none" style="width: 100%; height: auto">
						<!-- Record allergy content starts here -->
						<div class="AllergyDetailsHeader AllergyDetailsHeaderTheme"
							data-role="none">
							<span class="spanAllergyDetailsHeader" data-role="none"><%=csResBundle.getString("allergy.details") %></span>
						</div>
						<!-- first row -->
						<div class="rowContainer" data-role="none">
							<table cellpadding="0" cellspacing="0" class="tbRowContainer"
								border="0">
								<tr class="normalTr">
									<td class="td30" valign="middle" align="right">
										<div class="allergyRowFonts"><%=csResBundle.getString("allergy.hypersensitivity") %></div>
									</td>
									<td class="td70" valign="middle" align="left">
										<div class="divRangeContainer" data-role="none">
											<div id="nDvParentI" class="parent" data-role="none">
												<div id="scaleDvI" class="scale scaleTheme" data-role="none">
													<div data-role="none" class="Round roundTheme" id="RoundI"
														data-count="I"></div>
													<div data-role="none" class="scaleHover scaleHoverTheme"
														id="scaleHoverI"></div>

													<div data-role="none"
														class="scaleSeparator1 scaleSeparatorTheme"
														onclick="sliderControlClick(event,this,'I',false,true,'0%','U','01')"></div>
													<div data-role="none"
														class="scaleSeparator2 scaleSeparatorTheme"
														onclick="sliderControlClick(event,this,'I',false,true,'33%','M','02')"></div>
													<div data-role="none"
														class="scaleSeparator3 scaleSeparatorTheme"
														onclick="sliderControlClick(event,this,'I',false,true,'66%','O','03')"></div>

													<div data-role="none"
														class="scaleSeparator4 scaleSeparatorTheme1"
														onclick="sliderControlClick(event,this,'I',false,true,'98%','S','04')"></div>
												</div>
												<div style="position: relative; width: 100%; height: 20px">
													<div data-map = "I" data-left = "0%" style="position: absolute; left: 0.5%;" class = "dvSliderLabel" onclick="sliderControlClick(event,this,'I',false,true,'0%','U','01')"><%=csResBundle.getString("allergy.type1") %></div>
													<div data-map = "I" data-left = "33%" style="position: absolute; left: 30%" class = "dvSliderLabel" onclick="sliderControlClick(event,this,'I',false,true,'33%','M','02')"><%=csResBundle.getString("allergy.type2") %></div>
													<div data-map = "I" data-left = "66%" style="position: absolute; left: 64%" class = "dvSliderLabel" onclick="sliderControlClick(event,this,'I',false,true,'66%','O','03')"><%=csResBundle.getString("allergy.type3") %></div>
													<div data-map = "I" data-left = "98%" style="position: absolute; right: 1%" class = "dvSliderLabel" onclick="sliderControlClick(event,this,'I',false,true,'98%','S','04')"><%=csResBundle.getString("allergy.type4") %></div>
												</div>
											</div>
										</div>
									</td>
								</tr>
							</table>

						</div>
						<!-- first row ends -->
						<div class="rowDivider"></div>
						<!-- Second Row Starts -->
						<div class="rowContainer" data-role="none">
							<table cellpadding="0" cellspacing="0" class="tbRowContainer"
								border="0">
								<tr class="normalTr">
									<td class="td30" valign="middle" align="right">
										<div class="allergyRowFonts" id="cmbEventType_Label"><%=csResBundle.getString("allergy.eventType")%> <font style="color: red">*</font>
										</div>
									</td>
									<td class="td70" valign="middle" align="left">
										<div class="divEvent divEventTheme">
											<table cellpadding="0" cellspacing="0"
												style="width: 100%; height: 100%">
												<tr style="width: 100%; height: 100%">
													<td style="width: 100%; height: 100%" valign="middle"
														align="right">

														 <input id="cmbEventType" data-type="ComboBox"
														
														data-role="none" data-mandatory="true" /> <script>
										  	  $(document).ready(function() {
										  		  var data1 = null;
										  		  var eventValue = document.getElementById("hdnEventValues").value;
										  		  eventValue = eventValue.replace("'", "\'");
										  		 // eventValue = escape(eventValue);
										  		//  alert(eventValue);
										  		   data1 = JSON.parse(eventValue);
										  		 $("#cmbEventType").kendoComboBox({
										  			filter:"startswith",
										  			dataTextField: "eventTypeDescription",
							                        dataValueField: "eventTypeCode",
							                        dataSource: data1,
							                        change: function(e) {
							                        	clearDetails("EVNT");
							                        	var selectedIndex = this.select();
							                        	//alert(selectedIndex);
							                        	
							                       
							                        	cmbPrevEventTypeText = this.text();
							                        	cmbEventTypePrevValue = this.value();
							                        	if(selectedIndex == -1){
							                        		this.value("");
							                        	}
							                        	document.getElementById("hdnEventTypeCode").value = this.value();
							                        	document.getElementById("hdnEventTypeCodeValue").value = this.value();
							                        	//alert(document.getElementById("hdnEventTypeCode").value);
							                        	if(this.value() == "DA")
							                        	{
							                        	  $('#dvCA1').css("display" , "none");
							                        	  $('#dvCA2').css("display" , "block");
							                        	}
							                        	else
							                        	{
							                        		$('#dvCA1').css("display" , "block");
								                        	$('#dvCA2').css("display" , "none");
							                        	}
							                        	scrollRefresh();
					                                  }
										  		 });
										  	  });
										  	 	</script>
													</td>
												</tr>
											</table>
										</div>
									</td>
								</tr>
							</table>
						</div>
						<!-- second Row ends -->
						<div class="rowDivider"></div>
						<!-- Third Row Starts -->
						<div class="rowContainer" data-role="none">
							<table cellpadding="0" cellspacing="0" class="tbRowContainer"
								border="0">
								<tr class="normalTr">
									<td class="td30" valign="middle" align="right">
										<div class="allergyRowFonts" id="txtAllergen_Label"><%=csResBundle.getString("allergy.allergen")%> <font style="color: red">*</font>
										</div>
									</td>
									<td class="td70" valign="middle" align="left">
										<div class="divEvent divEventTheme"
											onclick="showAllergenSfs()">
											<table cellpadding="0" cellspacing="0"
												style="width: 100%; height: 100%">
												<tr style="width: 100%; height: 100%">
													<td style="width: 99%; height: 100%" valign="middle">
														<input type="text" readonly data-role="none"
														class="txtContent" name="txtAllergen" id="txtAllergen" id="txtAllergen"
														data-mandatory="true" />
													</td>

													<td style="width: 1%; height: 100%">
														<div class="cellDivider"><div data-role = "none" class = "dvSerarchIcon"></div></div>
													</td>
												</tr>
											</table>
										</div>
									</td>
								</tr>
							</table>
						</div>
						<!-- Third Row Ends -->
						<div class="rowDivider"></div>
						<!-- Fourth Row Starts -->
						<div class="rowContainer1" data-role="none" id="dvCA1">
							<table cellpadding="0" cellspacing="0" class="tbRowContainer1"
								border="0">
								<tr class="normalTr">
									<td class="td30" valign="middle" align="right">
										<div class="allergyRowFonts" id="txtCA_Label"><%=csResBundle.getString("allergy.CS")%></div>
									</td>
									<td class="td70" valign="middle" align="left">
										<div style="position: relative; width: 100%; height: auto"
											data-role="none">
											<textarea class="txtArea" data-role="none" id="txtCA" name="txtCA"
												style="display: block" rows="50" cols="10">
	      									</textarea>
										</div>
									</td>
								</tr>
							</table>
						</div>
						<div class="rowContainer" data-role="none" style="display: none"
							id="dvCA2">
							<table cellpadding="0" cellspacing="0" class="tbRowContainer"
								border="0">
								<tr class="normalTr">
									<td class="td30" valign="middle" align="right">
										<div class="allergyRowFonts"><%=csResBundle.getString("allergy.CS")%></div>
									</td>
									<td class="td70" valign="middle" align="left">
										<div class="divEvent divEventTheme" data-role="none"
											onclick="showCaSfs()">
											<table cellpadding="0" cellspacing="0"
												style="width: 100%; height: 100%">
												<tr style="width: 100%; height: 100%">
													<td style="width: 99%; height: 100%" valign="middle">
														<input readonly type="text" data-role="none" class="txtContent" id="txtCAS" name="txtCAS" id="txtCAS"/>
													</td>
													<td style="width: 1%; height: 100%">
														<div class="cellDivider"></div>
													</td>
												</tr>
											</table>
										</div>
									</td>
								</tr>
							</table>
						</div>
						<!-- Fourth Row Ends -->
						<div class="rowDivider"></div>
						<!-- Fifth row starts -->
						<div class="rowContainer" data-role="none" style="display: block">
							<table cellpadding="0" cellspacing="0" class="tbRowContainer"
								border="0" data-role="none">
								<tr class="normalTr">
									<td class="td30" valign="middle" align="right">
										<div class="allergyRowFonts" id="OnsetDateTime_Label"><%=csResBundle.getString("allergy.onsetDate")%> <font style="color: red">*</font>
										</div>
									</td>
									<td class="td70" valign="middle" align="left">
										<div class="divEvent divEventTheme" data-role="none">
											<table cellpadding="0" cellspacing="0"
												style="width: 100%; height: 100%">
												<tr style="width: 100%; height: 100%">
													<td style="width: 50%; height: 100%" valign="middle">
														<table cellpadding = "0" cellspacing = "0" style = "height:100%;width:100%">
															<tr style = "height:100%;width:100%">
															<td style = "height:100%;width:2%" align = "right" valign = "middle"><input type = "checkBox" name = "chkEstDuration" id = "chkEstDuration" onclick = "setEstDurn(this)" style = "margin-left:5px;height:20px;width:20px"/></td>
															<td style = "height:100%;width:98%" align = "left" valign = "middle"><span class="allergyRowFonts"><%=csResBundle.getString("allergy.estdurn")%></span></td>
															</tr>
														</table>
													</td>
                                       
													<td style="width: 50%; height: 100%" valign="middle"
														align="right">
														<!-- Error Message Container for onset date -->
														<div class="formValWarningTheme formValError"
															id="OnsetDateTime_Warning"
															style="top: 45px; left: 0px; display: none">
															<div class="formValErrorMsgTheme"
																id="OnsetDateTime_WarningMsg"></div>
														</div> <input id="OnsetDateTime" data-type="DateTime"
														data-count="I"
														style="text-align:right"
														data-role="none" onchange="validate(this)"
														data-errmsg1="Onset date should be between Date of Birth and Current date"
														data-mandatory="true" /> <script>
												            $(document).ready(function() {
												                // create DateTimePicker from input HTML element
												                //var today = new Date();
												                $("#OnsetDateTime").kendoDateTimePicker({
												                	 interval: 5,
												        			 value: today
												                });
												            });
												        </script>
													</td>
												</tr>
											</table>
										</div>
									</td>
								</tr>
							</table>
						</div>
						<!-- Fifth row ends -->
						<div class="rowDivider"></div>
						<!-- sixth row starts -->
						<div class="rowContainer" data-role="none" style="display: block">
							<table cellpadding="0" cellspacing="0" class="tbRowContainer"
								border="0">
								<tr class="normalTr">
									<td class="td30" valign="middle" align="right">
										<div class="allergyRowFonts" id="ActiveSinceDate_Label">
											<%=csResBundle.getString("allergy.activeSince")%> <font style="color: red">*</font>
										</div>
									</td>
									<td class="td70" valign="middle" align="left">
										<div class="divEvent divEventTheme">
											<table cellpadding="0" cellspacing="0"
												style="width: 100%; height: 100%" >
												<tr style="width: 100%; height: 100%">
													<td style="width: 5%; height: 100%" valign="middle" align = "left">
													<!--  <input type = "checkBox" name = "chkEstDuration" id = "chkEstDuration" style = "height:20px;width:20px"/>&nbsp;Estimated Duration
													--> 
														
													</td>

													<td style="width: 95%; height: 100%" valign="middle"
														align="right">
														<!-- Error Message Container for onset date -->
														<div class="formValWarningTheme formValError"
															id="ActiveSinceDate_Warning"
															style="top: 45px; left: 0px; display: none">
															<div class="formValErrorMsgTheme"
																id="ActiveSinceDate_WarningMsg"></div>
														</div> <input id="ActiveSinceDate" data-type="Date"
														data-count="I"
														style="text-align:right"
														data-role="none" onchange="validate(this)"
														data-errmsg1="Active Since Date cannot be greater than Current Date"
														data-errmsg2="Active Since Date cannot be less than Onset Date"
														data-mandatory="true" /> <script>
												            $(document).ready(function() {
												                // create DateTimePicker from input HTML element
												               // var today1 = new Date();
												                $("#ActiveSinceDate").kendoDatePicker({
												        			 value: today
												                });
												            });
												        </script>
													</td>
												</tr>
											</table>
										</div>
									</td>
								</tr>
							</table>
						</div>
						<!-- sixth row ends -->
						<div class="rowDivider"></div>
					</div>
					<!-- alergy content ends -->
					<!-- Reaction content strats -->
					<div data-role="none" style="width: 100%; height: auto"
						id="dvRContent">
						<!-- reaction header starts -->
						<div data-role="none" class="reactionHeader">
							<table style="height: 100%; width: 100%" cellspacing="0"
								cellpadding="0" border="0" data-role="none">
								<tr style="height: 100%; width: 100%">
									<td style="height: 100%; width: 100%" valign="middle"><span
										class="spanAllergyDetailsHeader"
										id="AllergyAllReactions_Label" data-role="none"><%=csResBundle.getString("allergy.reaction")%>
									</span><font style="color: red">*</font></td>
								</tr>
							</table>
						</div>
						<!-- reaction header ends-->
						<div class="rowDivider"></div>
						<!-- reaction 1st row starts -->
						<div data-role="none" class="rowContainer">
							<table class="tbRowContainer" cellspacing="0" cellpadding="0"
								border="0" data-role="none">
								<tr class="normalTr">
									<td class="reactionTd" valign="middle">
										<div data-role = "none" class = "divReaction divReactionTheme">
										<%-- <span class = "spanReaction"><%=csResBundle.getString("allergy.enterReaction")%></span> --%>
										<input type="text" data-role="none" class="txtContent" name="txtReactionSearch" id="txtReactionSearch" id="txtReactionSearch" placeholder="<%=csResBundle.getString("allergy.enterReaction")%>"/>
										</div>	
									</td>
									<td class="reactionSmallTd" valign="middle" align="right">
										<div data-role="none" class="addReactionDiv"
											onclick="showReactionSfs()"></div>
									</td>
								</tr>
							</table>
						</div>
					</div>
					<!-- Reaction content ends -->
				</div>
				<!-- first child of the scroller control -->
				<!-- Mandatory fields error -->
				<div class="formValErrorTheme formValError"
					id="MandatoryFields_Error"
					style="bottom: 0px; left: 0px; display: none">
					<div class="formValErrorMsgTheme" id="MandatoryFields_ErrorMsg">All
						mandatory fields must be entered</div>
				</div>
			</div>
			<!-- scrolling div ends -->
			<input type="hidden" name="hdnEventValues" id="hdnEventValues" id="hdnEventValues"
				value='<%=eventTypeResponse%>' /> 
			<input type="hidden" name="hdnHypSensitivity" id="hdnHypSensitivity" id="hdnHypSensitivity" value="01" /> 
			<input type="hidden" name="hdnPath" id="hdnPath" id="hdnPath" value="${path}" /> 
			<input type="hidden" name="hdnEventTypeCode" id="hdnEventTypeCode" id="hdnEventTypeCode" /> 
			<input type="hidden" name="hdnEventTypeCodeValue" id="hdnEventTypeCodeValue"
				id="hdnEventTypeCodeValue" /> <input type="hidden"
				name="hdnSfsType" id="hdnSfsType" id="hdnSfsType" /> <input type="hidden"
				name="hdnAllergenCode" id="hdnAllergenCode" id="hdnAllergenCode" /> 
			<input type="hidden" name="hdnCACode" id="hdnCACode" id="hdnCACode" />
			<input type = "hidden" name = "hdnReactionCount" id = "hdnReactionCount" />
			<input type = "hidden" name = "hdnAddedReactionId" id = "hdnAddedReactionId" />
			<input type = "hidden" name = "hdnEstimatedDuration" id = "hdnEstimatedDuration" value = "N"/>
			<input type = "hidden" name = "hdnTransactionMode" id = "hdnTransactionMode" value = "INSERT"/>
			<input type = "hidden" name = "hdnOnsetDateTime" id = "hdnOnsetDateTime" value=""/>
			<input type = "hidden" name = "hdnActiveSinceDate" id = "hdnActiveSinceDate" value=""/>
			<input type = "hidden" name = "hdnReactionsToAdd" id = "hdnReactionsToAdd" value=""/>
			
			<input type = "hidden" name = "today" id = "today" value="<%=today%>"/>
			<input type = "hidden" name = "patientDOB" id = "patientDOB" value="<%=patientDOB%>"/>
			
		</form>
	</div>
</body>
</html>

