<!DOCTYPE html>
<%@page import="eIPAD.chartsummary.currentmedications.healthobject.CurrentMedicationHO"%>
<%@page import="eIPAD.chartsummary.currentmedications.response.CurrentMedicationRes"%>
<%@page import="eIPAD.chartsummary.currentmedications.healthobject.CurMedMultipleFlowRateHO"%> 
<%@page import="ePH.QueryPatientDrugProfileBean"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@page import="javax.servlet.http.HttpSession"%> 
<%@ page import="java.util.ArrayList"%>
<%@ page import="eIPAD.chartsummary.common.response.ErrorInfo"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<%-- Mandatory declarations start --%>
<%@include file="../../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>



<c:set var="path" value="${pageContext.request.contextPath}"/>
<%
Locale appLocale;
 

if(session.getAttribute("LOCALE")!=null && !session.getAttribute("LOCALE").equals(""))
	appLocale = new Locale((String)session.getAttribute("LOCALE"));
else 
	appLocale = new Locale("en");
ResourceBundle csResBundle = ResourceBundle.getBundle("eIPAD.chartsummary.common.resourcebundle.cslabels", appLocale); 
%>

<script>
$(document).ready(function() {
});
var detailOpen = false;
var curOrderId ;
var prOrderId ;
 function showDetails(orderId){
	 curOrderId = orderId;
	 if(curOrderId != prOrderId)
		 {
	 		if(detailOpen!=true){
	 			$('#multipleFluidDetails'+curOrderId).show();
	 			$('#showMultipleDetail'+curOrderId).addClass("rotateImg");
	 			scrollerRefresh(CSMainScroll);
	 		}
	 		else{
	 				if(prOrderId != null){
	 					$('#multipleFluidDetails'+prOrderId).hide();
	 					$('#showMultipleDetail'+prOrderId).removeClass("rotateImg");
	 					$('#multipleFluidDetails'+curOrderId).show();
	 					$('#showMultipleDetail'+curOrderId).addClass("rotateImg");
	 					scrollerRefresh(CSMainScroll);
	 				}
	 			}
	 		
	 		detailOpen =true;
	 	}
	 else{
		 if(detailOpen == true) {
			 $('#multipleFluidDetails'+curOrderId).hide();
			 $('#showMultipleDetail'+curOrderId).removeClass("rotateImg");
			 scrollerRefresh(CSMainScroll);
			 detailOpen=false;
		 }
		 else{
			 $('#multipleFluidDetails'+curOrderId).show();
			 $('#showMultipleDetail'+curOrderId).addClass("rotateImg");
			 scrollerRefresh(CSMainScroll);
			 detailOpen=true;
		 }
	 }
	 prOrderId = curOrderId; 
 }
 function filterCurMedication(filterByVal){
	 loadCurrentMedication(filterByVal);
 }

 function loadCurrentMedication(filterByVal){
     
	  $("#CurrentMedicationFrame").load( path + "/mobile/chartsummary/CurrentMedicationView?filterByVal=" +filterByVal,function(){
			scrollerRefresh(CSMainScroll);
			$("[data-filterIcon = 'CM']").each(function(index, value) {  
			if(filterByVal == 'all')
			 {
				  $("[data-filterBy = 'cmallrecords']").removeClass("notesIconTheme").addClass("notesIconSelectedTheme"); 
				
			 }
			 else
			 {
				 if(filterByVal.indexOf($(this).attr("data-filterBy")) != -1)	 
					{
					 $(this).removeClass("notesIconTheme").addClass("notesIconSelectedTheme");
					 $("[data-filterBy = 'cmallrecords']").removeClass("notesIconSelectedTheme").addClass("notesIconTheme");
					}
			 }
			});
	  });
}
 
</script>

<%
CurrentMedicationRes cmResponse = (CurrentMedicationRes)request.getAttribute("Response");
boolean isSuccessResponse = false;
boolean isEmptyResponse = true;
ArrayList<ErrorInfo> errorList = new ArrayList<ErrorInfo>();
List<CurrentMedicationHO> curMedList = new ArrayList<CurrentMedicationHO>();
CurrentMedicationHO curMedHO = null;
if(cmResponse!=null){
	isSuccessResponse = cmResponse.isSuccessResponse();
	isEmptyResponse = cmResponse.isEmptyDataResponse();
	curMedList = cmResponse.getCurrentMedicationList();
	errorList = cmResponse.getErrorsList();
	//if(curMedList!=null && !curMedList.isEmpty())
		//isEmptyResponse = false;
	
}
int count = cmResponse.getCount();
%>

	<div class="widgetParent widgetParentTheme" style="position:relative;" data-role = "none">
	 	<form id="currentMedicationForm" class="currentMedicationForm" action="" method="post" name="currentMedicationForm" id="currentMedicationForm"> 
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
								<div class="widgetHeaderHeadingTextCol" data-role = "none">
									<span class="widgetHeaderHeadingTextTheme" data-role = "none">Current Medication</span> 
										<input type="button" class="widgetHeaderCountButtonTheme" id="currentMedicationViewCount" value="<%=count%>">
								</div>
							 	<div class="notesFilterCol" data-role="none" > 
									<table style="height: 100%; width: 100%" cellpadding="0" cellspacing="0" border="0">
										<tr style="height: 100%; width: 100%">
											<td style="width: 100%" align="right" valign="center">
												<div data-role="none" class="notesFilterContainer">
													<table style="width: 100%; height: 100%;" cellpadding="0" cellspacing="0" border="0">
														<tr>
															<td  class="notesIconSelectedTheme" valign="center" align="center" data-filterIcon = "CM" data-filterBy = "cmallrecords"   onclick = "filterCurMedication('all')"><img src="${path}/eIPAD/images/view01.png" style="vertical-align: middle;" /></td>
															<td  class="notesIconTheme" valign="center" align="center" data-filterIcon = "CM" data-filterBy = "norRx"  onclick = "filterCurMedication('norRx')"><img src="${path}/eIPAD/images/Rx.png" style="vertical-align: middle;" /></td>
															<td  class="notesIconTheme" valign="center" align="center" data-filterIcon = "CM" data-filterBy = "comRx"   onclick = "filterCurMedication('comRx')"><img src="${path}/eIPAD/images/CRx.png" style="vertical-align: middle;" /></td>
															<td  class="notesIconTheme" valign="center" align="center" data-filterIcon = "CM" data-filterBy = "IVRx"   onclick = "filterCurMedication('IVRx')" ><img src="${path}/eIPAD/images/IV.png" style="vertical-align: middle;" /></td>
														</tr>
													</table>
												</div>
											</td>
										</tr>
									</table>
							 	</div>
							</div>
						</div>
					</div>
				</div>
					
	
				<div class="widgetContentRow" data-role = "none">
					<div class="widgetHeaderMarginCell" data-role = "none">
						
					</div>
					<div class="widgetContentCell widgetContentCellTheme WidgetContentStripTheme" data-role = "none">
					
						 <%!
						  public ArrayList<String> getMntName(String strDate){ 
							 String[] dateSplit = strDate.split(" ");
						  	 String dateNumber = dateSplit[0];
						  	 String dateTime = dateSplit[1];
							 String[] dateItems = dateNumber.split("/");
							 ArrayList<String> dateItem = new ArrayList<String>();
					 		 String dateNo = dateItems[0];
					 		 dateItem.add(dateNo);
					 		 String dateMth = dateItems[1];
					 		 int mthNo = Integer.parseInt(dateMth);
					 		 String dateYear = dateItems[2];
					 		 dateItem.add(dateYear);
					 		 String monthString = null;
					 		 switch (mthNo) {
					            case 1:  monthString = "JAN";
					                     break;
					            case 2:  monthString = "FEB";
					                     break;
					            case 3:  monthString = "MAR";
					                     break;
					            case 4:  monthString = "APR";
					                     break;
					            case 5:  monthString = "MAY";
					                     break;
					            case 6:  monthString = "JUN";
					                     break;
					            case 7:  monthString = "JUL";
					                     break;
					            case 8:  monthString = "AUG";
					                     break;
					            case 9:  monthString = "SEP";
					                     break;
					            case 10: monthString = "OCT";
					                     break;
					            case 11: monthString = "NOV";
					                     break;
					            case 12: monthString = "DEC";
					                     break;
					            default: monthString = "Invalid month";
					                     break;
					 	 	}
					 		 
					 		dateItem.add(monthString);
					 		dateItem.add(dateTime);
					 		return dateItem; 
					 	 } 
	 					 %>
						 <% 
						 String prevOrderId = "";
						 boolean compoundRxRow = false; // to check if previous row is of compound Rx 
						 boolean prevComp = false; // to check if the items found are compound Rx or not 
						 String strComDtNo = "", strComDtMth="", strComDtYr="";
						 String endComDtNo = "", endComDtMth="",endComDtYr="";
						 int borderCheck = 0;
						 
						 if(isSuccessResponse && !isEmptyResponse) {
							 for(int i =0;i<curMedList.size();i++ )
							 {
								 curMedHO = curMedList.get(i);
								 
							 	 String currOrderId = curMedHO.getOrderId();
							 	
							 	 String startDate = curMedHO.getStartDate();
							 	 String endDate = curMedHO.getEndDate();
							 	 ArrayList<String> startDtItem = getMntName(startDate);
							 	 String stDtNo = startDtItem.get(0);
							 	 String stDtMth = startDtItem.get(2);
							 	 String stDtYr = startDtItem.get(1);
							 	 String stDtTime = startDtItem.get(3);
							 	 ArrayList<String> endDtItem = getMntName(endDate);
							 	 String endDtNo = endDtItem.get(0);
							 	 String endDtMth = endDtItem.get(2);
							 	 String endDtYr = endDtItem.get(1);
							 	 String endDtTime = endDtItem.get(3);
							 	 
							 	 String RxValue = curMedHO.getPrepYN();
							 	 String lineStatus = curMedHO.getLineStatus();
							 	 String statusFrmQuery = curMedHO.getStatus();
							 	 String returnedQty = curMedHO.getReturnedQty();
							 	 String patientClass = curMedHO.getPatientClass();
							 	 String dischargeMed = curMedHO.getDischargeMed();
							 	 String multiFlowRateYN = curMedHO.getSplitFluidMedicationYN();
							 	 
							 	 
							 	 String status = "*A"; // it is directly declared as *A because in desktop version it is send a url parameter and its value is *A in almost all cases 
							 	
							 	 String	bean_id			=	"QueryPatientDrugProfileBean" ;
								 String	bean_name		=	"ePH.QueryPatientDrugProfileBean";
							 	 QueryPatientDrugProfileBean bean = (QueryPatientDrugProfileBean)getBeanObject( bean_id,bean_name, request) ;
							 	 String futureYN = bean.compareDate(startDate);
							 	 String expiryYN = bean.compareDate(endDate);
							 	 String activeMed = "";
							 	 
							 	if(!returnedQty.equals("") ){  // the following code to check the active medication. Right now only active medication is shown in indication. 
									if((status.equals("A") || status.equals("*A")) && (lineStatus.equals("DP") || lineStatus.equals("DF")) && (futureYN.equals("N")) && !expiryYN.equals("N")){
										activeMed = "active";
									}
									else{
										if(futureYN.equals("Y")) 
											activeMed	= "FUTURE_Rx";
										else if(expiryYN.equals("N")){
											activeMed	= "EXPIRED_MEDICATION";
										}
										else if (lineStatus.equals("CN"))
											activeMed	= "CANCEL";
										else if (lineStatus.equals("DC"))
											activeMed	= "DIS-CONTINUED";
										else if(dischargeMed.equals("D"))
											activeMed="DISCHARGEMED1";
										else if (lineStatus.equals("HD") || lineStatus.equals("HC"))
											activeMed	= "HOLD";
										else
											activeMed	= "active";
											
										}
								 	}
								 	else if (lineStatus.equals("CN")){
										
										if(expiryYN.equals("N"))
											activeMed	= "EXPIRED_MEDICATION";
										else
											activeMed	= "CANCEL";
									}
									else if (lineStatus.equals("DC")){
										
										if(expiryYN.equals("N"))
											activeMed	= "EXPIRED_MEDICATION";
										else
											activeMed	= "DIS-CONTINUED";
									}
									else if( ((statusFrmQuery.equalsIgnoreCase("active")) || ((patientClass.equals("IP") || patientClass.equals("DC")) && (lineStatus.equals("OS") || lineStatus.equals("RG") || lineStatus.equals("IP") || lineStatus.equals("VF")) ) || ((patientClass.equals("OP") || patientClass.equals("EM")) && (lineStatus.equals("OS") || lineStatus.equals("RG") || lineStatus.equals("IP") || lineStatus.equals("VF") || lineStatus.equals("DP") || lineStatus.equals("DF")) ))){
										//(lineStatus.equals("DP") || lineStatus.equals("DF") )
		
										if(futureYN.equals("Y")) { 
											
											activeMed	= "FUTURE_Rx";
										}
										else{
											
											if(expiryYN.equals("N")){
											
												activeMed	= "EXPIRED_MEDICATION";
											}
											else {
												if(dischargeMed.equals("D")){
													
													activeMed="DISCHARGEMED1";
												}
												else 
													activeMed	= "active";
											}
											
										}
								}							 	 

							//if(RxValue.equals("1") || RxValue.equals("3") || RxValue.equals("5")){
								if(RxValue.equals("1000") ){
								prevComp = false;
								if(!compoundRxRow){
								%>
							<div class="PDContentTable WidgetContentStripTheme" id="CMTable"  data-role = "none" >
								<div class="PDContentRow" data-role = "none">
										<div style="" class="curMedOutCol  WidgetContentStripCol1Theme" data-role = "none">
											<div class="curMedTable">
												<div class="row">
												  <div  class="curMedInnerCell">
													<div class="PDIcon WidgetContentStripCol1BoxTheme" style="text-align:center;"  data-role = "none">
														<div class="curMedIconContainer">
															<div class="row"> 
																<div class="curMedInnerCell">
																	<img src="${path}/eIPAD/images/IV.png" style="vertical-align:middle;" >
																</div>	
															</div>
														</div>
													</div>
												  </div>
												</div>
											</div>
										</div>
										<div id="outerTbCol2"; class="curMedCol2Cell curMedColBorderTheme" >
										 	<div id="repeat" class="curMedCol2InnerTab01">
												<div id="r1" style="display: table;width: 100%;" class="curMedCol2InnerRow01">
													<div class="PDContentCol2" data-role = "none" style="width:95%;">
														<div class="curMedCol2InnerTab01">
															<div class="curMedCol2InnerRow02">
																<div id="col1" class="curMedCol2InnerCell"> 
																	<div class="table">
															 			<div class="row">
																			<div  class="WidgetParaHeadTextTheme PDdescText curMedCol2InnerTabCell01" data-role = "none">
																 				<%=curMedHO.getDrugName()  %> 
																 			</div>
																		</div>
																		
															    		<div class="curMedCol2InnerTabRow02">
																			<div  class="curMedCol2InnerTabCell02 curMedDetailsFontTheme" >
																				Fluid 
																				<span style="font-weight:normal;"> Total Volume :</span>
																				<%= curMedHO.getDosageDetails() %>
																			</div>			
															    		</div>
															    	</div>
																</div>
																<div id= "col2"  class="curMedInnTab02Cell01IV"> 
																	<div  class="curMedCol2InnTab02IV" >
													 					<div class="curMedInnerCell" >
													 						<div class="curMedIVMultiRowTable">
													 							<div class="curMedIVMultiRow"> 
															 						<div class="curMedDetailsFontTheme curMedIVMultiRowCell"  onclick="showDetails('<%=currOrderId%>')"> 
															 						<% if(multiFlowRateYN.equalsIgnoreCase("Y")) { %>
															 							 <div style="float:right;" class="table"> 
															 								<div class="row"> 
															 									<div class="curMedInnerCell">
															 										Multiple Flow Rate 
															 									</div>
															 									<div class="curMedTabCell">
															 										<img id="showMultipleDetail<%=currOrderId %>" src="/eHIS/eIPAD/images/EXPCOL.PNG" ; />
															 									</div>
															 								</div>
																						</div>	
															 						<% } else { %>
															 							<span style="font-weight:normal;"> Rate - </span>
															 							<%= curMedHO.getInfusionRate() %> <%=curMedHO.getInfusionVolStrUnit() %> /<%=curMedHO.getInfusionPerUnit() %>
															 							<span style="font-weight:normal;"> over </span> <%=curMedHO.getInfusionTime() %> <%=curMedHO.getInfusionOverUnit() %>
															 						<% } %>
															 						</div>
															 					</div>
															 					<div class="curMedIVMultiRow">	
															 						<div class="curMedDetailsFontThemeIV curMedIVMultiRowCell" > 
															 							 <%= curMedHO.getFrequency() %> for <%=curMedHO.getDuration()  %> <%=curMedHO.getDuration_desc() %> , <%=curMedHO.getOrderQty() %>
															 						</div>
															 					</div>
													 						</div> 	
													 					</div>
													 					<div class="cell" >
																			<% if(activeMed.equals("active")){ %>
																			<div class="curMedInnTab02Cell02 curMedStatusThemeActive" >
															 					
															 				</div>
															 				<% }else {%>
															 				<div class="curMedInnTab02Cell02 curMedStatusThemeNormal" >
															 					
															 				</div>
															 				<% } %>
														 				</div>
														 			</div>
																</div>
															</div>
														</div>
													</div>
									 			</div>	 
											</div> 
										</div>
									
									
									<div id="PDCol3"  class="curMedCol3OutCell curMedCol3Theme" > 
										  <div class="curMedCol3InnTab01">
										   <div class="row">
											<div id="outerCol1" class="row">
												<div id="innerTab" class="table">
													<div class="row">
														<div id="innerCol1"  class="curMedDateNumTheme curMedInnerCell">
															<%=stDtNo %>
														</div>
														<div id="innerCol2" class="curMedInnerCell">
													 		<div id="innerTab01" class="table">
													 			<div id="innerRow1" class="row">
																	<div class="curMedDateMthYrTheme cell"> 
													 					<%= stDtMth %>
													 				</div>
																</div>
													 			<div id="innerRow2" class="row"> 
																	<div class="curMedDateMthYrTheme cell">
													 					<%=stDtYr  %>
																	</div>
													 			</div>
													 	 	</div>
														</div>
													</div>
													
												</div>
											</div>
											
											<div class="curMedInnerCell">
											 	<div class="row">
											 		<div  class="curMedDateDashTheme curMedInnerCell">
											 	  		- 
											 		</div>
											 	</div>
											</div>
											
											<div id="outerCol2" class="cell">
												<div id="innerTab" class="table">
													<div class="row">
														<div id="innerCol1" class="curMedDateNumTheme curMedInnerCell">
															<%= endDtNo %>
														</div>
														<div id="innerCol2" class="curMedInnerCell">
													 		<div id="innerTab01" class="table">
													 			<div id="innerRow1" class="row">
													 				<div class="curMedDateMthYrTheme cell">
																		<%= endDtMth %>
																	</div>
													 			</div>
													 			<div id="innerRow2" class="row"> 
													 				<div  class="curMedDateMthYrTheme cell">
																		<%= endDtYr %>
																	</div>
													 			</div>
													 	 	</div>
														</div>
													</div>
													
												</div>
											</div>
										   </div>
										   <div class="row">
										   		<div class="cell">
										   			<div class="curMedTimeTable">
														<div class="row">
															<div class="curMedDateMthYrTheme cell">
																<%=stDtTime %>
															</div>
														</div>
													</div> 
										   		</div>
										   		<div class="cell"></div> <!-- empty div created for alignment --> 
										   		<div class="cell">
										   			<div class="curMedTimeTable">
														<div class="row">
															<div class="curMedDateMthYrTheme cell">
																<%=endDtTime %>
															</div>
														</div>
													</div> 
										   		</div>
										   </div>
										</div> 							
									</div>
								</div>
							</div>
							<% 
								int multiRowBorder = 0;
								if(multiFlowRateYN.equalsIgnoreCase("Y")){
								 	 ArrayList<CurMedMultipleFlowRateHO> multiFlowRateDetailList = curMedHO.getMulitpleFlowRate();
								 	 %>
								 	 <div class="WidgetContentStripTheme" >
										<div id="multipleFluidDetails<%=currOrderId %>" class="WidgetContentStripTheme"  style="display:none;margin-left:5px;margin-right:5px;border: 1px solid #B8CEDB; margin-top:5px;margin-bottom:5px;">
								 	<% 
								 	 for(int j=0;j<multiFlowRateDetailList.size();j++)
								 	 {
								 		 CurMedMultipleFlowRateHO multiflowDetail = new CurMedMultipleFlowRateHO();
								 		 multiflowDetail= multiFlowRateDetailList.get(j);
								 		 String gapDuration = multiflowDetail.getGapInHrs(); // in hrs 
								 		 String startIVRxDate = multiflowDetail.getStartDateTime();
								 		 ArrayList<String> startDtIVRxItem = getMntName(startIVRxDate);
									 	 String stDtIVNo = startDtIVRxItem.get(0);
									 	 String stDtIVMth = startDtIVRxItem.get(2);
									 	 String stDtIVYr = startDtIVRxItem.get(1);
									 	 String stDtIVTime = startDtIVRxItem.get(3);
								 		 String endIVRxDate = multiflowDetail.getEndDateTime();
								 		 ArrayList<String> endDtIVRxItem = getMntName(endIVRxDate);
									 	 String endDtIVNo = endDtIVRxItem.get(0);
									 	 String endDtIVMth = endDtIVRxItem.get(2);
									 	 String endDtIVYr = endDtIVRxItem.get(1);
									 	 String endDtIVTime = endDtIVRxItem.get(3);
									 	 
								%>
							 <div  class="WidgetContentStripTheme PDContentTable" >
								 	 <div class="curMedCol2InnerRow01">
									 	 
										<div class="curMedIVMultiTableRow">
											<!-- Column 1 -->
											<div style="" class="curMedOutCol  WidgetContentStripCol1Theme" data-role = "none">
												<div class="curMedMultiIVTable" >
													<div class="row">
													  <div  class="curMedInnerCell" style="text-align:center;">
															<img src="${path}/eIPAD/images/CM_Child-icon.png" >
													  </div>
													</div>
												</div>
											</div>
											 <!-- Column 2 -->
										<div id="outerTbCol2"; class="curMedCol2Cell  " >
										 	<div id="repeat" class="curMedCol2InnerTab01">
												<div id="r1" style="display: table;width: 100%;" class="curMedCol2InnerRow02IVMulti" >
													<div class="curMedIVMultiRow02Cell" >
														<span class="curMedDetailsFontThemeNormal"> Infuse volume : </span> 
														<span class="curMedDetailsFontTheme" > <%=multiflowDetail.getTotalStrength() %> <%=multiflowDetail.getTotStrengthUOM() %></span>
														<span class="curMedDetailsFontThemeNormal"> , Rate - </span>
														<span class="curMedDetailsFontTheme" > <%=multiflowDetail.getInfusionRate() %> <%=multiflowDetail.getInfusionVolStrUnit() %> </span>
														<span class="curMedDetailsFontThemeNormal"> / </span>
														<span class="curMedDetailsFontTheme" > <%=multiflowDetail.getInfusionPerUnit() %> </span>
														<span class="curMedDetailsFontThemeNormal"> over </span> 
														<span class="curMedDetailsFontTheme" > <%=multiflowDetail.getInfuseOver() %> <%=multiflowDetail.getInfuseOverUnit() %></span>
													</div>	
									 			</div>	
									 			<div id="r2" class="curMedCol2InnerRow02IVMulti" > 
									 				<div class="curMedIVMultiRow02Cell" >
									 					<span  class="curMedDetailsFontThemeNormal">Gap </span>
									 					<%if(gapDuration.equals("") || gapDuration.equals(null) ) { %>
									 					<span class="curMedDetailsFontTheme" > 0.00 Hrs </span>
									 					<% }else {  %>
									 					<span class="curMedDetailsFontTheme">  <%=gapDuration %> Hrs </span>
									 					<%} %>
									 				</div>
									 			</div>
											</div> 
										</div>	
										
											 <!-- Col 3 -->
										<div id="PDCol3"  class="curMedCol3OutCellRight "  > 
										  <div class="curMedCol3InnTabIV">
											   <div class="row">
													<div id="outerCol1" class="cell">
														<div id="innerTab" class="table">
															<div class="row">
																<div id="innerCol1"  class="curMedDateNumTheme curMedInnerCell">
																	<%=stDtIVNo %>
																</div>
																<div id="innerCol2" class="curMedInnerCell">
															 		<div id="innerTab01" class="table">
															 			<div id="innerRow1" class="row">
																			<div class="curMedDateMthYrTheme cell"> 
															 					<%= stDtIVMth %>
															 				</div>
																		</div>
															 			<div id="innerRow2" class="row"> 
																			<div class="curMedDateMthYrTheme cell">
															 					<%=stDtIVYr  %>
																			</div>
															 			</div>
															 	 	</div>
																</div>
															</div>
														</div>
													</div>
												
													<div class="curMedInnerCell">
													 	<div class="row">
													 		<div class="curMedDateDashTheme curMedInnerCell">
													 	  		- 
													 		</div>
													 	</div>
													</div>
												
													<div id="outerCol2" class="cell">
														<div id="innerTab" class="table">
															<div class="row">
																<div id="innerCol1" class="curMedDateNumTheme curMedInnerCell">
																	<%= endDtIVNo %>
																</div>
																<div id="innerCol2" class="curMedInnerCell">
															 		<div id="innerTab01" class="table">
															 			<div id="innerRow1" class="row;">
															 				<div class="curMedDateMthYrTheme cell">
																				<%= endDtIVMth %>
																			</div>
															 			</div>
															 			<div id="innerRow2" class="row"> 
															 				<div class="curMedDateMthYrTheme cell">
																				<%= endDtIVYr %>
																			</div>
															 			</div>
															 	 	</div>
																</div>
															</div>
														</div>
													</div>
											   </div>
											   <div class="row">
										   		<div class="cell">
										   			<div class="curMedTimeTable">
														<div class="row">
															<div class="curMedDateMthYrTheme cell">
																<%=stDtTime %>
															</div>
														</div>
													</div> 
										   		</div>
										   		<div class="cell"></div> <!-- empty div created for alignment --> 
										   		<div class="cell">
										   			<div class="curMedTimeTable">
														<div class="row">
															<div class="curMedDateMthYrTheme cell">
																<%=endDtTime %>
															</div>
														</div>
													</div> 
										   		</div>
										   </div>
										</div> 							
									</div>
								</div>
								<!-- </div> -->
						</div>
					</div>	 
								<% 		
								 multiRowBorder++;
								 	 }
							 	 %>
							
				</div>	
			</div>	
					<% 		 	 
								}
								}
								  else{
									  if(compoundRxRow){ // this is given to check whether a row is of compoundRx or Normal RX 
									  compoundRxRow= false;
							%>
						</div>	
					</div>
							<div id="PDCol3"  class="curMedCol3OutCell curMedCol3Theme" > 
								<div class="curMedCol3InnTab01">
								   <div class="row">
									<div id="outerCol1" class="cell">
										<div id="innerTab" class="table">
											<div class="row">
												<div id="innerCol1"  class="curMedDateNumTheme curMedInnerCell">
													<%=strComDtNo %>
												</div>
												<div id="innerCol2" class="curMedInnerCell">
											 		<div id="innerTab01" class="table">
											 			<div id="innerRow1" class="row">
															<div class="curMedDateMthYrTheme cell"> 
											 					<%= strComDtMth %>
											 				</div>
														</div>
											 			<div id="innerRow2" class="row"> 
															<div class="curMedDateMthYrTheme cell">
											 					<%=strComDtYr  %>
															</div>
											 			</div>
											 	 	</div>
												</div>
											</div>
										</div>
									</div>
									
									<div class="curMedInnerCell">
									 	<div class="row">
									 		<div  class="curMedDateDashTheme curMedInnerCell">
									 	  		- 
									 		</div>
									 	</div>
									</div> 
									
									<div id="outerCol2" class="cell">
										<div id="innerTab" class="table">
											<div class="row">
												<div id="innerCol1"  class="curMedDateNumTheme curMedInnerCell" >
													<%= endComDtNo %>
												</div>
												<div id="innerCol2" class="curMedInnerCell">
											 		<div id="innerTab01" class="table">
											 			<div id="innerRow1" class="row">
											 				<div class="curMedDateMthYrTheme cell">
																<%= endComDtMth %>
															</div>
											 			</div>
											 			<div id="innerRow2" class="row"> 
											 				<div class="curMedDateMthYrTheme cell">
																<%= endComDtYr %>
															</div>
											 			</div>
											 	 	</div>
												</div>
											</div>
										</div>
									</div>
								   </div>
								</div> 							
							</div>
						</div>
					</div>	  
							<% 		  
							  }
									  i--; // i variable for going to a previous item. 
							  }			
							}
								
							else if(RxValue.equals("") ){
								  prevComp = false;
								  if(!compoundRxRow){
						%> 
									<!-- --------------------Current Medication widget content starts here----------------------- -->
					<div class="PDContentTable WidgetContentStripTheme" id="CMTable"  data-role = "none" >
						<div class="PDContentRow" data-role = "none">
								<div style="" class="curMedOutCol  WidgetContentStripCol1Theme" data-role = "none">
									<div class="curMedTable">
										<div class="row">
										  <div  class="curMedInnerCell">
											<div class="PDIcon WidgetContentStripCol1BoxTheme" style="text-align:center;"  data-role = "none">
												<div class="curMedIconContainer">
													<div class="row"> 
														<div class="curMedInnerCell">
															<img src="${path}/eIPAD/images/Rx.png" style="vertical-align:middle;" >
														</div>	
													</div>
												</div>
											</div>
										  </div>
										</div>
									</div>
								</div>
								<div id="outerTbCol2"; class="curMedCol2Cell curMedColBorderTheme" >
								 	<div id="repeat" class="curMedCol2InnerTab01">
										<div id="r1" style="display: table;width: 100%;" class="curMedCol2InnerRow01">
											<div class="PDContentCol2" data-role = "none" style="width:95%;">
												<div class="curMedCol2InnerTab01">
													<div class="curMedCol2InnerRow02">
														<div id="col1" class="curMedCol2InnerCell"> 
															<div class="table">
													 			<div class="row">
																	<div  class="WidgetParaHeadTextTheme PDdescText curMedCol2InnerTabCell01" data-role = "none">
														 				<%=curMedHO.getDrugName()  %> 
														 			</div>
																</div>
																
																<div class="curMedCol2InnerTabRow02">
																	<div  class="curMedCol2InnerTabCell02 WidgetNormalTextTheme" >
																		<%= curMedHO.getFormDesc() %>, <%= curMedHO.getRouteDesc() %>
																	</div>			
													    		</div>
													    		
													    	</div>
														</div>
														<div id= "col2" style=" text-align: right; " class="curMedInnTab02Cell01"> 
															<div  class="curMedCol2InnTab">
												 				<div class="curMedInnerCell" >
												 					<div  class="curMedCol2InnTabCell03 curMedDetailsFontTheme"> 
												 						<%= curMedHO.getDosageDetails() %> <%= curMedHO.getFrequency() %> for <%=curMedHO.getDuration()  %> <%=curMedHO.getDuration_desc() %>
												 					</div>
												 				</div>
												 				<div class="curMedStatusIndi">
																	<% if(activeMed.equals("active")){ %>
																	<div class="curMedInnTab02Cell02 curMedStatusThemeActive" >
													 					
													 				</div>
													 				<% }else {%>
													 				<div class="curMedInnTab02Cell02 curMedStatusThemeNormal" >
													 					
													 				</div>
													 				<% } %>
												 				</div>
												 				
												 				 
												 			</div>
														</div>
													</div>
												</div>
											</div>
							 			</div>	 
									</div> 
								</div>	
							<div id="PDCol3"  class="curMedCol3OutCell curMedCol3Theme" > 
								  <div class="curMedCol3InnTab01">
								   <div class="row">
									<div id="outerCol1" class="cell">
										<div id="innerTab" class="table">
											<div class="row">
												<div id="innerCol1"  class="curMedDateNumTheme curMedInnerCell">
													<%=stDtNo %>
												</div>
												<div id="innerCol2" class="curMedInnerCell">
											 		<div id="innerTab01" class="table">
											 			<div id="innerRow1" class="row">
															<div  class="curMedDateMthYrTheme cell"> 
											 					<%= stDtMth %>
											 				</div>
														</div>
											 			<div id="innerRow2" class="row"> 
															<div class="curMedDateMthYrTheme cell">
											 					<%=stDtYr  %>
															</div>
											 			</div>
											 	 	</div>
												</div>
											</div>
										</div>
									</div>
									
									<div class="curMedInnerCell">
									 	<div class="row">
									 		<div  class="curMedDateDashTheme curMedInnerCell">
									 	  		- 
									 		</div>
									 	</div>
									</div> 
									
									<div id="outerCol2" class="cell">
										<div id="innerTab" class="table">
											<div class="row">
												<div id="innerCol1"  class="curMedDateNumTheme curMedInnerCell">
													<%= endDtNo %>
												</div>
												<div id="innerCol2" class="curMedInnerCell">
											 		<div id="innerTab01" class="table">
											 			<div id="innerRow1" class="row">
											 				<div class="curMedDateMthYrTheme cell">
																<%= endDtMth %>
															</div>
											 			</div>
											 			<div id="innerRow2" class="row"> 
											 				<div class="curMedDateMthYrTheme cell">
																<%= endDtYr %>
															</div>
											 			</div>
											 	 	</div>
												</div>
											</div>
										</div>
									</div>
								   </div>
								</div> 							
							</div>
							
						</div>
					</div>
					
							 <% 
							 }
								  else{
									  if(compoundRxRow){  // this is given to check whether a row is of compoundRx or Normal RX 
									  compoundRxRow= false;
									  %>
						</div>	
					</div>
							<div id="PDCol3"  class="curMedCol3OutCell curMedCol3Theme" > 
								<div class="curMedCol3InnTab01">
								   <div class="row">
									<div id="outerCol1" class="cell">
										<div id="innerTab" class="table">
											<div class="row">
												<div id="innerCol1"  class="curMedDateNumTheme curMedInnerCell">
													<%=strComDtNo %>
												</div>
												<div id="innerCol2" class="curMedInnerCell">
											 		<div id="innerTab01" class="table">
											 			<div id="innerRow1" class="row">
															<div class="curMedDateMthYrTheme cell"> 
											 					<%= strComDtMth %>
											 				</div>
														</div>
											 			<div id="innerRow2" class="row"> 
															<div class="curMedDateMthYrTheme cell">
											 					<%=strComDtYr  %>
															</div>
											 			</div>
											 	 	</div>
												</div>
											</div>
										</div>
									</div>
									
									<div class="curMedInnerCell">
									 	<div class="row">
									 		<div  class="curMedDateDashTheme curMedInnerCell">
									 	  		- 
									 		</div>
									 	</div>
									</div> 
									
									<div id="outerCol2" class="cell">
										<div id="innerTab" class="table">
											<div class="row">
												<div id="innerCol1"  class="curMedDateNumTheme curMedInnerCell" >
													<%= endComDtNo %>
												</div>
												<div id="innerCol2" class="curMedInnerCell">
											 		<div id="innerTab01" class="table">
											 			<div id="innerRow1" class="row">
											 				<div  class="curMedDateMthYrTheme cell">
																<%= endComDtMth %>
															</div>
											 			</div>
											 			<div id="innerRow2" class="row"> 
											 				<div  class="curMedDateMthYrTheme cell">
																<%= endComDtYr %>
															</div>
											 			</div>
											 	 	</div>
												</div>
											</div>
										</div>
									</div>
								   </div>
								</div> 							
							</div>
						</div>
					</div>	  
							<% 		  
							  }
									  i--; // i variable for going to a previous item. 
							  }	
							  }
							  // else if(RxValue.equals("6")) { 
							  else if(RxValue.equals("6")|| RxValue.equals("1") || RxValue.equals("3") || RxValue.equals("5")) {
									if(!prevOrderId.equals(currOrderId)){
										compoundRxRow = true;
											if(prevComp) { %>
								   </div>	
										</div>
												<div id="PDCol3"  class="curMedCol3OutCell curMedCol3Theme" > 
													<div class="curMedCol3InnTab01">
													   <div class="row">
														<div id="outerCol1" class="cell">
															<div id="innerTab" class="table">
																<div class="row">
																	<div id="innerCol1"  class="curMedDateNumTheme curMedInnerCell">
																		<%=strComDtNo %>
																	</div>
																	<div id="innerCol2" class="curMedInnerCell">
																 		<div id="innerTab01" class="table">
																 			<div id="innerRow1" class="row">
																				<div class="curMedDateMthYrTheme cell"> 
																 					<%= strComDtMth %>
																 				</div>
																			</div>
																 			<div id="innerRow2" class="row"> 
																				<div class="curMedDateMthYrTheme cell">
																 					<%=strComDtYr  %>
																				</div>
																 			</div>
																 	 	</div>
																	</div>
																</div>
															</div>
														</div>
														
														<div class="curMedInnerCell">
														 	<div class="row">
														 		<div class="curMedInnerCell" class="curMedDateDashTheme">
														 	  		- 
														 		</div>
														 	</div>
														</div> 
														
														<div id="outerCol2" class="cell">
															<div id="innerTab" class="table">
																<div class="row">
																	<div id="innerCol1"  class="curMedDateNumTheme curMedInnerCell" >
																		<%= endComDtNo %>
																	</div>
																	<div id="innerCol2" class="curMedInnerCell">
																 		<div id="innerTab01" class="table">
																 			<div id="innerRow1" class="row">
																 				<div class="curMedDateMthYrTheme cell">
																					<%= endComDtMth %>
																				</div>
																 			</div>
																 			<div id="innerRow2" class="row"> 
																 				<div  class="curMedDateMthYrTheme cell">
																					<%= endComDtYr %>
																				</div>
																 			</div>
																 	 	</div>
																	</div>
																</div>
															</div>
														</div>
													   </div>
													</div> 							
												</div>
											</div>
										</div>	  
								<% } %>   
								   
								   
								   <div class="PDContentTable WidgetContentStripTheme"  id="PDTable"   data-role = "none" >
									<div class="PDContentRow" data-role = "none">
								
										<div style="" class="curMedOutCol  WidgetContentStripCol1Theme" data-role = "none">
											<div class="curMedTable">
												<div class="row">
												  <div  class="curMedInnerCell">
													<div class="PDIcon WidgetContentStripCol1BoxTheme" style="text-align:center;"  data-role = "none">
														<div class="curMedIconContainer">
															<div class="row"> 
																<div class="curMedInnerCell">
																	<% if(RxValue.equals("6")) { %>   
																	<img src="${path}/eIPAD/images/CRx.png" style="vertical-align:middle;" >
																	<% } else {%>   
																	<img src="${path}/eIPAD/images/IV.png" style="vertical-align:middle;" >
																	<% } %>
																</div>	
															</div>
														</div>
													</div>
												  </div>
												</div>
											</div>
										</div>
										
										<!-- Column 2 for dispaly detials Starts --> 
										
										<div id="outerTbCol2"; class="curMedCol2Cell curMedColBorderTheme" >
								 			<div id="repeat" class="curMedCol2InnerTab01">
											
											<% }
											   if(borderCheck!=0 && prevOrderId.equals(currOrderId))
											   {
									  		 %>      
							            
							            <div id="printBorder" class="curMedCol2InnerRow01">
							 				<div  class="curMedCompoundBorder curMedBorderTheme"></div>
							 			</div> 
							            <% } %>
										<div id="r1" style="display: table;width: 100%;" class="curMedCol2InnerRow01">
											<div class="PDContentCol2" data-role = "none" style="width:95%;">
												<div class="curMedCol2InnerTab01">
													<div class="curMedCol2InnerRow02">
													
													<% if(RxValue.equals("6")) { %>
														<div id="col1" class="curMedCol2InnerCell"> 
															<div class="table">
													 			<div class="row">
																	<div  class="WidgetParaHeadTextTheme PDdescText curMedCol2InnerTabCell01" data-role = "none">
														 				<%=curMedHO.getDrugName()  %>
														 			</div>
																</div>
																<div class="curMedCol2InnerTabRow02">
																	<div  class="curMedCol2InnerTabCell02 WidgetNormalTextTheme" >
																		<%= curMedHO.getFormDesc() %>, <%= curMedHO.getRouteDesc() %>
																	</div>			
													    		</div>
													    	</div>
														</div>
														<div id= "col2" style=" text-align: right; " class="curMedInnTab02Cell01"> 
															  <div  class="curMedCol2InnTab">
												 				<div class="curMedInnerCell" >
												 					<div  class="curMedCol2InnTabCell03 curMedDetailsFontTheme"> 
												 						<%= curMedHO.getDosageDetails() %>  <%= curMedHO.getFrequency() %> for <%=curMedHO.getDuration()  %> <%=curMedHO.getDuration_desc() %>
												 					</div>
												 				</div>
												 				<div class="curMedStatusIndi">
																	<% if(activeMed.equals("active")){ %>
																	<div class="curMedInnTab02Cell02 curMedStatusThemeActive" >
													 					
													 				</div>
													 				<% }else {%>
													 				<div class="curMedInnTab02Cell02 curMedStatusThemeNormal" >
													 					
													 				</div>
													 				<% } %>
												 				</div> 
												 			</div>
														</div>
														<% } else {%> 
														<div id="col1" class="curMedCol2InnerCell"> 
																	<div class="table">
															 			<div class="row">
																			<div  class="WidgetParaHeadTextTheme PDdescText curMedCol2InnerTabCell01" data-role = "none">
																 				<%=curMedHO.getDrugName()  %> 
																 			</div>
																		</div>
																		
															    		<div class="curMedCol2InnerTabRow02">
																			<div  class="curMedCol2InnerTabCell02 curMedDetailsFontTheme" >
																				Fluid 
																				<span style="font-weight:normal;"> Total Volume :</span>
																				<%= curMedHO.getDosageDetails() %>
																			</div>			
															    		</div>
															    	</div>
														</div> 
														<div id= "col2"  class="curMedInnTab02Cell01IV"> 
																	<div  class="curMedCol2InnTab02IV" >
													 					<div class="curMedInnerCell" >
													 						<div class="curMedIVMultiRowTable">
													 							<div class="curMedIVMultiRow"> 
															 						<div class="curMedDetailsFontTheme curMedIVMultiRowCell"  onclick="showDetails('<%=currOrderId%>')"> 
															 						<% if(multiFlowRateYN.equalsIgnoreCase("Y")) { %>
															 							 <div style="float:right;" class="table"> 
															 								<div class="row"> 
															 									<div class="curMedInnerCell">
															 										Multiple Flow Rate 
															 									</div>
															 									<div class="curMedTabCell">
															 										<img id="showMultipleDetail<%=currOrderId %>" src="/eHIS/eIPAD/images/EXPCOL.PNG" ; />
															 									</div>
															 								</div>
																						</div>	
															 						<% } else { %>
															 							<span style="font-weight:normal;"> Rate - </span>
															 							<%= curMedHO.getInfusionRate() %> <%=curMedHO.getInfusionVolStrUnit() %> /<%=curMedHO.getInfusionPerUnit() %>
															 							<span style="font-weight:normal;"> over </span> <%=curMedHO.getInfusionTime() %> <%=curMedHO.getInfusionOverUnit() %>
															 						<% } %>
															 						</div>
															 					</div>
															 					<div class="curMedIVMultiRow">	
															 						<div class="curMedDetailsFontThemeIV curMedIVMultiRowCell" > 
															 							 <%= curMedHO.getFrequency() %> for <%=curMedHO.getDuration()  %> <%=curMedHO.getDuration_desc() %> , <%=curMedHO.getOrderQty() %>
															 						</div>
															 					</div>
													 						</div> 	
													 					</div>
													 					<div class="cell" >
																			<% if(activeMed.equals("active")){ %>
																			<div class="curMedInnTab02Cell02 curMedStatusThemeActive" >
															 					
															 				</div>
															 				<% }else {%>
															 				<div class="curMedInnTab02Cell02 curMedStatusThemeNormal" >
															 					
															 				</div>
															 				<% } %>
														 				</div>
														 			</div>
																</div>
														<% }%>
														
													</div>
												</div>
											</div>
							 			</div>	 
									  <%
									  			// The date variables are taken into another variables to print them after the complete compound Rx items are done. 
 											  borderCheck++;
											  strComDtNo = stDtNo ;
											  strComDtMth = stDtMth;
											  strComDtYr = stDtYr;
											  endComDtNo = endDtNo;
											  endComDtMth = endDtMth;
											  endComDtYr = endDtYr;
			
									   		  prevOrderId = currOrderId; 
									   		  prevComp = true;
									   		}
									 }
									 if(compoundRxRow)
									 {
										 compoundRxRow= false;
								  		%>
											</div>
										</div>
								
							<div id="PDCol3"  class="curMedCol3OutCell curMedCol3Theme" > 
								<div class="curMedCol3InnTab01">
								   <div class="row">
									<div id="outerCol1" class="cell">
										<div id="innerTab" class="table">
											<div class="row">
												<div id="innerCol1"  class="curMedDateNumTheme curMedInnerCell">
													<%=strComDtNo %>
												</div>
												<div id="innerCol2" class="curMedInnerCell">
											 		<div id="innerTab01" class="table">
											 			<div id="innerRow1" class="row">
															<div class="curMedDateMthYrTheme cell"> 
											 					<%= strComDtMth %>
											 				</div>
														</div>
											 			<div id="innerRow2" class="row"> 
															<div class="curMedDateMthYrTheme cell">
											 					<%=strComDtYr  %>
															</div>
											 			</div>
											 	 	</div>
												</div>
											</div>
										</div>
									</div>
									
									<div class="curMedInnerCell">
									 	<div class="row">
									 		<div  class="curMedDateDashTheme curMedInnerCell">
									 	  		- 
									 		</div>
									 	</div>
									</div> 
									
									<div id="outerCol2" class="cell">
										<div id="innerTab" class="table">
											<div class="row">
												<div id="innerCol1"  class="curMedDateNumTheme curMedInnerCell" >
													<%= endComDtNo %>
												</div>
												<div id="innerCol2" class="curMedInnerCell">
											 		<div id="innerTab01" class="table">
											 			<div id="innerRow1" class="row">
											 				<div class="curMedDateMthYrTheme cell">
																<%= endComDtMth %>
															</div>
											 			</div>
											 			<div id="innerRow2" class="row"> 
											 				<div class="curMedDateMthYrTheme cell">
																<%= endComDtYr %>
															</div>
											 			</div>
											 	 	</div>
												</div>
											</div>
										</div>
									</div>
								   </div>
								</div> 							
							</div>
						</div>
					</div>
					<% 		 }
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
			</div>
	 	</form> 
	</div>

