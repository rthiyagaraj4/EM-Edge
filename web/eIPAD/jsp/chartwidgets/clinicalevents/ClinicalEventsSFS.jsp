<!DOCTYPE html>
<%@page import="eIPAD.chartsummary.CLEventHistory.healthobject.ClinicalEventFieldItem"%>
<%@page import="eIPAD.chartsummary.CLEventHistory.response.ClinicalEventsFieldResponse"%>
<%@page import="eIPAD.chartsummary.CLEventHistory.daoimpl.ClinicalEventsDAOImpl"%>
<%@page import="eIPAD.chartsummary.CLEventHistory.dao.ClinicalEventsDAO"%>
<%@page import="eIPAD.chartsummary.clinicalnotes.daoimpl.ClinicalNotesDAOImpl"%>
<%@page import="eIPAD.chartsummary.common.healthobject.PatContext"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@page import="eIPAD.chartsummary.clinicalnotes.response.*"%>
<%@page import="eIPAD.chartsummary.clinicalnotes.healthobject.*"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import ="java.util.ResourceBundle" %>
<%@ page import="eIPAD.chartsummary.common.response.TransactionResponse"%>
<%@ page import="eIPAD.chartsummary.common.response.ErrorInfo" %>
<%@page import="eIPAD.chartsummary.encounterlist.response.EncounterListResponse"%>
<%@page import="eIPAD.chartsummary.encounterlist.healthobject.EncounterHO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.google.gson.Gson;" %>

<c:set var="path" value= "${pageContext.request.contextPath}"/>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=4.0, user-scalable=no" />

<link rel="stylesheet" href="${path}/eIPAD/css/SlideSFS.css" />
<!-- <script src="${path}/eIPAD/js/ClinicalEventsSFS.js"></script> -->
<script src="${path}/eIPAD/js/iscroll5/iscroll.js"></script>
	
<!-- main table STARTS -->
<div class="table" id="CNFilterHeader">
    <div class="row" ><!-- MR1 -->
        <div class="cell">
            <div class="table" style="width:100%;">
                <div class="row SLSfsHeader SLSfsHeaderTheme">
                    <div class="cell SLSfsHeaderText SLSfsHeaderTextTheme">SEARCH / FILTER</div>
                    <div class="cell SLSfsHeaderCell" id="refMain" onclick="refreshMain()"><img src = "${path}/eIPAD/images/Reload24x24.png" /></div>
                    <div class="cell SLSfsHeaderCell"  onclick="hideSlideSFS()"><img src = "${path}/eIPAD/images/CloseSearch24x24.png" /></div>
                </div>
            </div>
        </div>
    </div>
    
    <%    
	PatContext patientContext = (PatContext)session.getAttribute("PatientContext"); //Patient context to bring data stored in session
	Gson gson = new Gson();
	String jsonFieldResDate = "";
	String jsonFieldResEnc = "";   
    %>
    <div class="row" id="CNFilterContent"> <!-- MR2 -->
	 <div class="SFSContent">
        <div class="cell">
           
                <div id="SLSfsWrapperMain">
                    <div id="SLSfsScrollerMain">
                        <div class="table" id="SLSfsMainTable" >

							<!-- Encounter selection STARTS -->
							<%EncounterListResponse allEncountersResp = (EncounterListResponse)request.getAttribute("EncounterListResponse");
							ArrayList<EncounterHO> allEncArrayList = new ArrayList<EncounterHO>();
							EncounterHO currentEncounter = new EncounterHO();
							if(allEncountersResp!=null && allEncountersResp.isSuccessResponse() && !allEncountersResp.isEmptyDataResponse()){
								allEncArrayList = allEncountersResp.getEncounterList();
								currentEncounter = allEncArrayList.get(0);
							}
                            
                            String selectedEncounter = "";
                            boolean secondaryEncSelected = false;
                            int selectedEncIndex = 0;
                            if(patientContext.getSelectedEncounterId()!= null && !patientContext.getSelectedEncounterId().equals("")){
                                selectedEncounter = patientContext.getSelectedEncounterId();
                                secondaryEncSelected = true;
							}%>
							
                            <div class="table filterTextWrap">
                               <div class="row" id="headingEC" style="height:40px">
                                <div class="cell">
					<div class="table" style="width:100%;height:40px">
					<div class="row SLSfsCategoryBlock" onclick="CNFilterSectionToggle('EC')" style="width:100%; height:40px;">
                                            <div class="cell SLSfsDivText SLSfsDivTextTheme" >ENCOUNTER</div>
                                            <div class="cell SLSfsHeaderCellTab SLSfsarrow" id="arrowEC" ><img  src ="${path}/eIPAD/images/DownarrowSFS.png" /></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row" id="contentEC">
                                <div class="cell">
                                    <div class="SLSfsNormalView" id="dataEC">
					<div id="SLSfsWrapperEC" style="background-color: #ffffff;">
						<div id="SLSfsScrollerEC">
							<div class="table" id="listEC" style="width:100%; height:100%;">
                                                            <input type = "hidden" name ="hdnCurrentEncID" id ="hdnCurrentEncID" value = "<%=currentEncounter.getEncounterId()%>"/>
                                                            <%String shdnEncIDs="";
							    if(allEncArrayList!=null && allEncArrayList.size()>0){
                                                                for(int i=0;i<allEncArrayList.size();i++){
                                                                    EncounterHO iEncounter = allEncArrayList.get(i);															
								    shdnEncIDs=shdnEncIDs+iEncounter.getEncounterId()+",";
                                                                    if(secondaryEncSelected && selectedEncounter.equals(iEncounter.getEncounterId())){
                                                                        selectedEncIndex = i;
									}%>                                                            
															<div class="listItemEC" style="width:100%; height:40px;" onclick="chooseEncounterFilter('<%=iEncounter.getEncounterId()%>','clinicalEvents')">
                                                                <div class= "cell SLSfsViewItemText SLSfsViewItemTextTheme" id="">
                                                                    <div class="">
																		<div class="cell" style="vertical-align:middle">
																			<div class="ipOPText"><%=iEncounter.getPatientClass()%></div>
																		</div>
                                                                        <div class="cell">
                                                                            <p class="SFSEncounterId" >EN ID <%=iEncounter.getEncounterId()%></p>
                                                                            <p class="SFSEncounterDate" ><%=iEncounter.getFromDate() %> &nbsp <%=iEncounter.getToDate()%></p>
                                                                        </div>
                                                                    </div>
                                                                </div>                                                                
                                                                <div class="cell SLSfsListTick SLSfsListTickTheme"><div class="SLSfsTickVisible SLSfsTickVisibleTheme SLSfsCircleVisibleTheme" id="SLSfsTickEN<%=iEncounter.getEncounterId()%>" style="display:none"></div></div>
                                                            </div>
															<%}}%>
							<input type = "hidden" name ="hdnEncIDs" id ="hdnEncIDs" value = "<%=shdnEncIDs%>"/>
							<input type = "hidden" name ="SelectedhdnEncIDs" id ="SelectedhdnEncIDs" value = "<%=shdnEncIDs%>"/>
                                                    </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            </div>
                            <!-- Encounter selection ENDS -->
                            <!-- TimeFrame STARTS -->
                            <%
                            ArrayList<String> dateArray = new ArrayList<String>();
                            ArrayList<String> encArray = new ArrayList<String>();
                            
                            for(int i=0;i<allEncArrayList.size();i++){ 
                            EncounterHO EncounterLst = allEncArrayList.get(i);
                            dateArray.add(EncounterLst.getFromDate());
                            encArray.add(EncounterLst.getEncounterId());
                            }
                            int hdnDateArrCount = dateArray.size();
                            int hdnEncArrCount = encArray.size();
                            jsonFieldResDate = gson.toJson(dateArray);
                            jsonFieldResEnc = gson.toJson(encArray);
                            %>
                            <div class="table filterTextWrap">
                            <input type = "hidden" name ="hdnDateArrCount" id ="hdnDateArrCount" value = '<%=hdnDateArrCount%>'/>
                            <input type = "hidden" name ="hdnEncArrCount" id ="hdnEncArrCount" value = '<%=hdnEncArrCount%>'/>
                            <input type = "hidden" name ="hdnEncounterDate" id ="hdnEncounterDate" value = '<%=jsonFieldResDate%>'/>
                            <input type = "hidden" name ="hdnEncounterEnc" id ="hdnEncounterEnc" value = '<%=jsonFieldResEnc%>'/>
                            <div class="row" id="headingTF">
                                <div class="cell">
                                    <div class="table">
                                        <div class="row SLSfsCategoryBlock" onclick="CNFilterSectionToggle('TF')">
                                            <div class="cell SLSfsDivText SLSfsDivTextTheme" >TIME FRAME</div>
                                            <div class="cell SLSfsHeaderCellTab " id="arrowTF" ><img  src ="${path}/eIPAD/images/DownarrowSFS.png" /></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row" id="contentTF">
                                <div class="cell">
                                    <div class="SLSfsNormalView" id="dataTF">
                                        <div id="SLSfsWrapperTF"> 
                                            <div id="SLSfsScrollerTF">
                                                 
					    <div class="table" id="listTF" style="width:100%; height:100%;">
                                                    <div class="listItemTF">
                                                        <div class="cell timeFrameSlider"><div id="dateSlider"><input/> <input/></div></div>
                                                        <div class="rangeLabels">
                                                            <span class="startLabel"></span>
                                                            <span class="endLabel">Today</span>
                                                        </div>
                                                        <div class="selectedDates">
                                                             <input data-role="datepicker" data-bind="value:datepickerStartValue, events:{change:selectedDatesChanged}"/>
                                                             <input data-role="datepicker"  data-bind="value:datepickerEndValue, events:{change:selectedDatesChanged}"/>
                                                             <div class="timeFrameSearch" onclick="SearchByTimeFrame()">
                                                                <div class="WidgetButtonTheme" id="btnsfs">
                                                                      <img src="${path}/eIPAD/images/Search18x18.png" width="16px" ;="" height="16px" style="padding-top: 3px;">
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
							<input type = "hidden" name ="Selectedhdnstart" id ="Selectedhdnstart" />
							<input type = "hidden" name ="Selectedhdnend" id ="Selectedhdnend" />
                            <!-- TimeFrame ENDS -->
                            
                             <!-- Patient Class STARTS -->
                            <%	ClinicalEventsDAO daoImpl= new ClinicalEventsDAOImpl();
                            ClinicalEventsFieldResponse  patientClassResp=   daoImpl.getEventsPatientClassList(patientContext);
                            %>
							<div class="table filterTextWrap">
								<div class="row" id="headingPC" style="height:40px">
									<div class="cell">
										<div class="table" style="width:100%;height:40px">
											<div class="row SLSfsCategoryBlock" onclick="CNFilterSectionToggle('PC')" style="width:100%; height:40px;">
												<div class="cell SLSfsDivText SLSfsDivTextTheme" >PATIENT CLASS</div>
													<div class="cell SLSfsHeaderCellTab " id="arrowPC" ><img  src ="${path}/eIPAD/images/DownarrowSFS.png" /></div>
												</div>
											</div>
									</div>
								</div>
								<div class="row" id="contentPC">
									<div class="cell">
										<div class="SLSfsNormalView" id="dataPC">
											<div id="SLSfsWrapperPC" style="background-color: #ffffff;">
												<div id="SLSfsScrollerPC">
													<div class="table" id="listPC" style="width:100%; height:100%;">
														<%if(patientClassResp.isSuccessResponse() && !patientClassResp.isEmptyDataResponse()){
															ArrayList<ClinicalEventFieldItem> fieldItems = patientClassResp.getFieldItems();
															for(int i=0;i<fieldItems.size();i++) {
																ClinicalEventFieldItem patientClassItems=fieldItems.get(i);%>
														<div id="PC_<%=patientClassItems.getCode()%>" class="listItemPC" style="width:100%; height:40px;" onclick="CNFilterShowTick('<%= patientClassItems.getCode()%>','PC')" data-speccode='<%= patientClassItems.getCode()%>' data-specdesc='<%= patientClassItems.getDesc()%>'>
																<div class= "cell SLSfsViewItemText SLSfsViewItemTextTheme" id="textPC"<%= patientClassItems.getCode()%>><%=patientClassItems.getDesc()%></div>
																<div class="cell SLSfsListTick SLSfsListTickTheme" id="divPC"<%= patientClassItems.getCode()%>><div class="SLSfsTickVisible SLSfsTickVisibleTheme " id="SLSfsTickPC<%= patientClassItems.getCode()%>" style="display:none"></div></div>
														</div>
														<%}}%>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
								<input type = "hidden" name ="Selectedhdnpc" id ="Selectedhdnpc" />					
							<!-- Patient Class  AncServ ENDS -->
							<!-- History Type STARTS -->
							<%								
							ClinicalEventsFieldResponse  histTypeResp=   daoImpl.getEventHistoryTypeList(patientContext);
							%>
							<div class="table filterTextWrap">
								<div class="row" id="headingHT" style="height:40px">
									<div class="cell">
										<div class="table" style="width:100%;height:40px">
											<div class="row SLSfsCategoryBlock" style="width:100%; height:40px;" onclick="CNFilterSectionToggle('HT')" >
												<div class="cell SLSfsDivText SLSfsDivTextTheme" >HISTORY TYPE</div>
											<!--<span class="clearFilter" onclick="refreshFilter('HT',event)">CLEAR</span><span class="searchByEvents" onclick="searchByEventType(event)"><img  src ="${path}/eIPAD/images/SearchGray16x16.png" /></span> -->
												<div class="cell SLSfsHeaderCellTab " id="arrowHT" ><img  src ="${path}/eIPAD/images/DownarrowSFS.png" /></div>
											</div>
										</div>
									</div>
								</div>
							<div class="row" id="contentHT">
								<div class="cell">
									<div class="SLSfsNormalView" id="dataHT">
										<div id="SLSfsWrapperHT" style="height:100%; width:100%; background-color: #ffffff;">
											<div id="SLSfsScrollerHT">
												<div class="table" id="listHT" style="width:100%; height:100%;">
													<%if(histTypeResp.isSuccessResponse() && !histTypeResp.isEmptyDataResponse()){
															ArrayList<ClinicalEventFieldItem> fieldItems = histTypeResp.getFieldItems();															
															for(int i=0;i<fieldItems.size();i++) {
																ClinicalEventFieldItem careItem = fieldItems.get(i);%>
															<div id="HT_<%=careItem.getCode()%>" class="listItemHT" style="width:100%; height:40px;" onclick="CNFilterShowTick('<%=careItem.getCode()%>','HT')" data-speccode='<%=careItem.getCode()%>' data-specdesc='<%=careItem.getDesc()%>'>
																<div class= "cell SLSfsViewItemText SLSfsViewItemTextTheme" id="textHT<%= careItem.getCode()%>"><%= careItem.getDesc() %></div>
																<div class="cell SLSfsListTick SLSfsListTickTheme" id="divHT<%= careItem.getCode()%>">
																<div class="SLSfsTickVisible SLSfsTickVisibleTheme" id="SLSfsTickHT<%= careItem.getCode()%>" style="display:none"></div></div>
															</div>
											 		<%}}%>	
												</div>
							  				</div>
										</div>
									</div>
								</div>
							</div>
							</div>
									<input type = "hidden" name ="SelectedhdnHT" id ="SelectedhdnHT" />
							<!-- History Type ENDS -->
							</div>
                        </div>
                    </div>
                </div>
            </div>
            
        </div>
    </div>
</div>
<script>
document.addEventListener('touchmove', function(e) {
    e.preventDefault();
}, false);
$.extend($.expr[":"], { //search as you type
    "containsIN": function(elem, i, match, array) {
        return (elem.textContent || elem.innerText || "").toLowerCase().indexOf((match[3] || "").toLowerCase()) >= 0;
    }
});

var SLSfsScrollMain;
var SLSfsScrollHT;
var SLSfsScrollPC;
var SLSfsScrollEC;

var arrHT = [];
var arrPC = [];

var i;
var j = 0;
var selectedDateArr = [];
var finalEndDate;
var finalStartDate;

/*
$("#searchInputSFSHT").keyup(function() {
    var rows = $("#listHT").find(".listItemPC").hide();    
    if (this.value.length) {
        var data = this.value.split(" ");
        $.each(data, function(i, v) {
            var val = v.toLowerCase();
            rows.filter(":containsIN('" + val + "')").show();
        });
    } else rows.show();
});
*/

function CNFilterLoaded() {
    SLSfsScrollMain = new IScroll('#SLSfsWrapperMain', {
        scrollbars: true,
        click: true,
        mouseWheel: true
    });
    SLSfsScrollEC = new IScroll('#SLSfsWrapperEC', { scrollbars: true, click: true,  mouseWheel: true } );	
    SLSfsScrollHT = new IScroll('#SLSfsWrapperHT', { scrollbars: true, click: true,  mouseWheel: true } );
    SLSfsScrollPC = new IScroll('#SLSfsWrapperPC', { scrollbars: true, click: true,  mouseWheel: true } );	
}

function hideSlideSFS() {
    $('#EventsSideSFS').hide();
	$('#EventsMainViewContent').show();//added
    $('#ChartSummaryBlock').css({
        'width': '100%'
    });
    $("#SlideOpener").show();
    $('.eventsMainPanel').show();
    $('.FilterOpenMsg').hide();
    setHeightAndBase();
    CEMainScroll.refresh();
}

$(document).on("swipeleft", "#SLSfsWrapperMain", function(e) {
    hideSlideSFS();
});

function refreshMain() {

	
	 $('#SelectedhdnEncIDs').val("");
	 $('#Selectedhdnstart').val("");
	 $('#Selectedhdnend').val("");
	 $('#Selectedhdnpc').val("");
	 $('#SelectedhdnHT').val("");
	    
	    
    if (SLSfsScrollHT != undefined)
        SLSfsScrollHT.refresh();

    if (SLSfsScrollPC != undefined)
        SLSfsScrollPC.refresh();

	$("#listHT").find(".listItemHT").show();
	$("#listPC").find(".listItemPC").show();
	$(".SLSfsTickVisible").hide();
	$(".SLSfsAfterSelectionTheme").hide();
	chooseEncounterFilter("", 'clinicalEvents');
}

function CNFilterShowTick(val, type) {    
    if (type == "HT") {
		arrHT = [];
		if ($("#SLSfsTickHT" + val).is(":visible")) {
			$("#SLSfsTickHT" + val).hide();

        } else {
			arrHT.push(val);
			$('div[id^="SLSfsTickHT"]').hide();//added
			$("#SLSfsTickHT" + val).show();
		}
	}
	if (type == "PC") {
		arrPC = [];
        if ($("#SLSfsTickPC" + val).is(":visible")) {
            $("#SLSfsTickPC" + val).hide();
            $('div[id^="SLSfsTickPC"]').hide();
		}else{
			arrPC.push(val);
			$('div[id^="SLSfsTickPC"]').hide();
			$("#SLSfsTickPC" + val).show();
		}
	}
	$("#Selectedhdnpc").val(arrPC);
	$("#SelectedhdnHT").val(arrHT);
	clinicalEventsFilter(finalStartDate,finalEndDate,arrHT, arrPC);	
	 if (SLSfsScrollHT != undefined)
        SLSfsScrollHT.refresh();

    if (SLSfsScrollPC != undefined)
        SLSfsScrollPC.refresh();
}

function searchByEventType(event) {
    event.stopPropagation();
    clinicalEventsFilter(arrHT, arrPC);
}
function CNFilterSectionToggle(current) {	
    $("#content" + current).toggle();
    $("#textBox" + current).toggle();
    $("#ViewMore" + current).toggle();
	
    if ($("#content" + current).is(":visible")) {		
		$("#arrow" + current).addClass('SLSfsarrow');
    } else {
		$("#arrow" + current).removeClass('SLSfsarrow');
    }
	
	SLSfsScrollMain.refresh();
	
	if(SLSfsScrollEC != null){
	SLSfsScrollEC.refresh();}
	
	if(SLSfsScrollPC != null){
		SLSfsScrollPC.refresh();}
	 
	if(SLSfsScrollHT != null){
		SLSfsScrollHT.refresh();}
}

function removeInblockItem(val, type) {
    if (type == "HT") {
        $("#inBlockItem" + val).remove();
        $("#SLSfsTickHT" + val).hide();
        var index = arrHT.indexOf(val);
        arrHT.splice(index, 1);
        if (arrHT.length < 1) {
            $("#NTAfterSel").hide();
            $("#AfterSelectionHT").html('');
            SLSfsScrollHT.refresh();
        }
    }
    if (type == "PC") {
        $("#inBlockItem" + val).remove();
        $("#SLSfsTickPC" + val).hide();
        var index = arrPC.indexOf(val);
        arrPC.splice(index, 1);
        if (arrPC.length < 1) {
            $("#PCAfterSel").hide();
            $("#AfterSelectionPC").html('');
            SLSfsScrollPC.refresh();
        }
    }

    clinicalEventsFilter(arrHT, arrPC);
}
/*refresh filetr*/
function refreshFilter(current, event) {
    event.stopPropagation();
    if (current == 'HT') {
        arrHT = [];
        $('div[id^="SLSfsTickHT"]').hide();
        $("#AfterSelectionHT").html('');
        SLSfsScrollHT.refresh();
    }

    clinicalEventsFilter(arrHT, arrPC);
}

/*time frame slider start*/

var dateArrayStr = $("#hdnEncounterDate").val();
var dateArrSize = $("#hdnDateArrCount").val();
dateArray = $.parseJSON(dateArrayStr);
var encArrSize = $("#hdnEncArrCount").val();
var datePos = dateArrSize - 1;
var encPos = encArrSize - 1;
var cuurentDate = new Date();
var currDate = new Date();
var startDate = dateArray[datePos].split(" ")[0].split("/");
var prevDate = new Date();
prevDate.setDate(startDate[0]);
prevDate.setMonth(startDate[1] - 1);
prevDate.setYear(startDate[2]);
prevDate.setHours(0, 0, 0);
cuurentDate.setHours(0, 0, 0);
parent.setTimeFrame = function() {
        $('.startLabel').text(kendo.toString(prevDate, 'd MMM yyyy'));
        var viewModel = kendo.observable({
            selectedStartDate: prevDate,
            selectedEndDate: cuurentDate,
            datepickerStartValue: prevDate,
            datepickerEndValue: cuurentDate,
            selectedDateRange: [],
            pickerStartTime: '',
            pickerEndTime: '',
            selectedDatesChanged: function() {
                //to set slider on select date picker
                if (viewModel.selectedEndDate.getTime() <= viewModel.datepickerStartValue.getTime()) {
                    alert("start date should be less than current date");
                    viewModel.set('datepickerStartValue', viewModel.selectedStartDate);
                    viewModel.set("pickerStartTime", viewModel.selectedStartDate.getTime());
                }
                if (viewModel.selectedStartDate.getTime() > viewModel.datepickerEndValue.getTime()) {
                    alert("end date should not be less than start date");
                    viewModel.set('datepickerEndValue', viewModel.selectedEndDate);
                    viewModel.set("pickerEndTime", viewModel.selectedEndDate.getTime())
                }
                if (viewModel.selectedStartDate.getTime() <= viewModel.datepickerStartValue.getTime()) {
                    //does not allow to select lesser date of start date
                    viewModel.pickerStartTime = viewModel.datepickerStartValue.getTime();
                } else {
                    alert("select correct daterange");
                    viewModel.set('datepickerStartValue', viewModel.selectedStartDate);
                    viewModel.set("pickerStartTime", viewModel.selectedStartDate.getTime());

                }
                if (viewModel.selectedEndDate.getTime() >= viewModel.datepickerEndValue.getTime()) {
                    //does not allow to select greater date of end date
                    viewModel.pickerEndTime = viewModel.datepickerEndValue.getTime();
                } else {
                    alert("select correct daterange");
                    viewModel.set('datepickerEndValue', viewModel.selectedEndDate);
                    viewModel.set("pickerEndTime", viewModel.selectedEndDate.getTime())
                }
                viewModel.updateDateSlider();
            },
            dateStart: '',
            dateEnd: '',
            dateRangeChanged: function() {

                var dateRange = $("#dateSlider").data("kendoRangeSlider").value();
                var startdate = kendo.toString(new Date(dateRange[0]), 'd MMM yyyy');
                var enddate = kendo.toString(new Date(dateRange[1]), 'd MMM yyyy');
                viewModel.set('dateStart', startdate);
                viewModel.set('dateEnd', enddate);
                viewModel.set('selectedDateRange', dateRange);
                //to set datepicker on drag 
                viewModel.set('datepickerStartValue', new Date(dateRange[0]));
                viewModel.set('datepickerEndValue', new Date(dateRange[1]));
            },
            updateDateSlider: function() {
                if (viewModel.selectedStartDate <= viewModel.selectedEndDate) {
                    // reinitialize the date slider, since sliders do not support dynamic changes
                    var slider = $("#dateSlider").data("kendoRangeSlider");
                    if (slider) {
                        var wrapper = slider.wrapper;
                        var element = slider.element;
                        slider.destroy();
                        wrapper.before(element.show());
                        wrapper.remove();
                    }
                    $("#dateSlider").kendoRangeSlider({
                        largeStep: 86400000,
                        smallStep: 86400000,
                        min: viewModel.selectedStartDate.getTime(),
                        max: viewModel.selectedEndDate.getTime(),
                        tickPlacement: 'none',
                        value: [viewModel.selectedStartDate.getTime(), viewModel.selectedEndDate.getTime()],
                        selectionStart: (viewModel.pickerStartTime == '') ? viewModel.selectedStartDate.getTime() : viewModel.pickerStartTime,
                        selectionEnd: (viewModel.pickerEndTime == '') ? viewModel.selectedEndDate.getTime() : viewModel.pickerEndTime,
                        tooltip: {
                            template: kendo.template('#=kendo.toString(new Date(selectionStart), \'M/d/yyyy\' ) # to #=kendo.toString(new Date(selectionEnd), \'M/d/yyyy\' ) #')
                        },
                        change: viewModel.dateRangeChanged
                    });

                    viewModel.resizeSliders();
                    viewModel.dateRangeChanged();
                }
            },
            resizeSliders: function() {
                // resize the sliders to fill the container
                var sliders = $("[data-role='rangeslider']");
                sliders.each(function(index, ele) {
                    var slider = $(ele).getKendoRangeSlider();
                    slider.wrapper.css("width", "100%");
                });
            }
        });

        kendo.bind('body', viewModel);
        viewModel.updateDateSlider();
        viewModel.resizeSliders();
    }
    //search by time frame


function SearchByTimeFrame() {
    var dateRange = $("#dateSlider").data("kendoRangeSlider").value();
    var startdate = kendo.toString(new Date(dateRange[0]), 'd MMM yyyy');
    var enddate = kendo.toString(new Date(dateRange[1]), 'd MMM yyyy');
    var startDateformat = kendo.toString(new Date(startdate), 'yyyy/MM/dd');
    var startDateformatfinal = startDateformat.split('\/');
    finalStartDate = startDateformatfinal[0] + '-' + startDateformatfinal[1] + '-' + startDateformatfinal[2];

    var endDateformat = kendo.toString(new Date(enddate), 'yyyy/MM/dd');
    var endDateformatfinal = endDateformat.split('\/');
    finalEndDate = endDateformatfinal[0] + '-' + endDateformatfinal[1] + '-' + endDateformatfinal[2];
	$('#Selectedhdnstart').val(finalStartDate);
	$('#Selectedhdnend').val(finalEndDate);
	arrPC.length=0;
	arrHT.length=0;
	EncountersInRange(finalStartDate, finalEndDate,arrPC,arrHT);	
}

$(document).ready(function() {

    CNFilterLoaded();
    parent.setTimeFrame();
    //arrow setting intial for EC

    if ($("#contentEC").is(":visible")) {
        $("#arrowEC").addClass('SLSfsarrow');
    }

    $(document).on("click", "#SlideOpener", function() {

    });

    $("#contentTF").hide();
    $("#contentPC").hide();
    $("#contentHT").hide();
    $("#textBoxHT").hide();

	if(SLSfsScrollEC != null){
		SLSfsScrollEC.on('beforeScrollStart', function () {
			SLSfsScrollMain.disable();
		});
		SLSfsScrollEC.on('scrollEnd', function () {
			SLSfsScrollMain.enable();
		});
	}
	
	if(SLSfsScrollPC != null){
		SLSfsScrollPC.on('beforeScrollStart', function() {
			SLSfsScrollMain.disable();
		});

		SLSfsScrollPC.on('scrollEnd', function() {
			SLSfsScrollMain.enable();
		});
	}
	
	if(SLSfsScrollHT != null){
		SLSfsScrollHT.on('beforeScrollStart', function() {
			SLSfsScrollMain.disable();
		});
		SLSfsScrollHT.on('scrollEnd', function() {
			SLSfsScrollMain.enable();
		});
	}	

    $('#SLSfsWrapperMain').on('touchstart click', function() {
        SLSfsScrollMain.enable();
    });
});
</script>

