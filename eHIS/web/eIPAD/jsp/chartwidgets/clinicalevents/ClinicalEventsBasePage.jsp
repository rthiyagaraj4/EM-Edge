<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
    <head>
        <meta name="apple-mobile-web-app-capable" content="yes" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		
        <link rel="stylesheet" href="${path}/eIPAD/jquery.mobile-1.3.1.min.css" />
		<link rel="stylesheet" href="${path}/eIPAD/jquery-ui-1.7.2.custom.css" />
        <link rel="stylesheet" href="${path}/eIPAD/css/iPADNew.css" />
		<link rel="stylesheet" href="${path}/eIPAD/css/iPADThemeA.css" /> 
		<link rel="stylesheet" href="${path}/eIPAD/css/mCommon.css" /> 
		<link rel="stylesheet" href="${path}/eIPAD/css/SlideSFS.css" />
		 <link rel="stylesheet" href="${path}/eIPAD/css/kendo.common.min.css" />
        <link rel="stylesheet" href="${path}/eIPAD/css/kendo.default.min.css" />
    </head>

    <body style="display: block; margin: 0px; height: 100%; width: 100%;">
    <div class="ChartSummaryParent ChartSummaryParentTheme clinicalEventsWrap" data-role="page">
		<div id="PageLoadingAnimation" class="absoluteCenter">
		</div>
        <!--SFS jsp starts-->
		<div  class="slideSfsOpener"  id="SlideOpener">
			<img id="sfsSearchImg" src="${path}/eIPAD/images/Open_window.png"/>
		</div>		

		<div class="EventsSideSFS" id="EventsSideSFS">
		</div>
		<!--SFS jsp ends-->
		<div class="ChartSummaryBlock" id="ChartSummaryBlock" data-role = "none">
			<form id="ChartSummaryForm" name = "ChartSummaryForm" method = "post" action = "" class="ChartSummaryFormElem">
				<div class="ChartSummaryMainTable" data-role = "none">
					<div data-role = "none" class ="ChartSummaryPageHeader" id="CSHeader">
						<div class="ChartSummaryHeaderCell" data-role = "none">
							<div class="ChartSummaryHeaderCont" data-role = "none">
								<div class="ChartSummaryHeaderTable ChartSummaryHeaderTableTheme" data-role = "none">
									<div class="ChartSummaryHeaderRow" data-role = "none">
										<div class="ChartSummaryHeaderIconCol" data-role = "none">
											<div class="WidgetButtonTheme" data-role = "none"><img src="${path}/eIPAD/images/MenuIcon.png"></div>
										</div>
										<div class="ChartSummaryHeaderTextCol" data-role = "none">
											<div class="ChartSummaryHeaderText ChartSummaryHeaderTextTheme" data-role = "none">Clinical Events</div>
										</div> 
										<div class="ChartSummaryHeaderEncRightCol" data-role="none" onclick="closeClinicalEvents()">
											<div class="WidgetButtonTheme" data-role = "none" onclick="closeClinicalEvents()"><img src="${path}/eIPAD/images/CS_Close16x16.png"></div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div id="ClinicalEvents" class="divClinicalEventsContent divAllergyContentTheme"  data-role="none"> 
						<div data-role="none" class="ChartSummaryPageContent ChartSummaryPageContentTheme" id="ChartSummaryPageContent"  >
							<div data-role="none" class="ChartSummaryPageContentCell" >
								<div id="EventsSidePanel"></div>
								<div id="EventsMainViewContent"></div>
							</div>
						</div>
					</div>
					<div data-role = "none" class = "ChartSummaryPageFooter"  id="CSFooter">
						<div data-role = "none" class = "ChartSummaryPageFooterCell">
							<div data-role = "none" class = "ChartSummaryPageFooterCont">
								<div data-role = "none" class = "ChartSummaryPageFooterTable ChartSummaryPageFooterTableTheme">
									<div data-role = "none" class = "ChartSummaryPageFooterRow">
										<div data-role = "none" class = "ChartSummaryPageFooterFirstCol" ></div>
										<div data-role = "none" class = "ChartSummaryPageFooterButton ChartSummaryPageFooterBtnTheme" onclick="openChartSummaryFrame()">
											<div data-role = "none" class = "ChartSummaryPageFooterText">Chart Summary</div>
										</div>
                                            <div data-role="none" class="ChartSummaryPageFooterButton ChartSummaryPageFooterBtnTheme" onclick="openClinicalNotes()">
                                                <!-- openClinicalNotes() -->
                                                <div data-role="none" class="ChartSummaryPageFooterText">Clinical Notes</div>
                                            </div>
                                            <div data-role="none" class="ChartSummaryPageFooterButton ChartSummaryPageFooterBtnTheme" onclick="openOrdersFrame()">
                                                <div data-role="none" class="ChartSummaryPageFooterText">Order</div>
                                            </div>
                                            <div data-role="none" class="ChartSummaryPageFooterButton ChartSummaryPageFooterBtnSelTheme" onclick="openClinicalEvents()">
                                                <div data-role="none" class="ChartSummaryPageFooterText">Clinical Events</div>
                                            </div>
                                            <div data-role = "none" class = "ChartSummaryPageFooterButton ChartSummaryPageFooterBtnTheme" onclick="openPharmacyOrders()">
										<div data-role = "none" class = "ChartSummaryPageFooterText">Pharmacy Order</div>
									</div>
                                            <div data-role="none" class="ChartSummaryPageFooterLastCol"></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <input type="hidden" name="hdnPath" id="hdnPath" id="hdnPath" value="${path}" />
                </div>
            </form>
        </div>
    </div>
	
	<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
    <script type="text/javascript" src="${path}/eIPAD/js/iscroll5/iscroll.js"></script>  		
    <!-- <script src="${path}/eIPAD/kendo.web.min.js"></script> -->
	<script src="${path}/eIPAD/kendo.all.min.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
    <script>
		var path;
		var CEMainScroll;
		var setTimeFrame;
		var encounterIDs = "";
		var hideSFS="False";

        $(document).ready(function() {
            path = $('#hdnPath').val();
            parent.setOnLoadContentPaneHeight();

            $('#EventsSidePanel').load(path + '/eIPAD/jsp/chartwidgets/clinicalevents/ClinicalEventsPanel.jsp');
            $('#EventsMainViewContent').load(path + '/eIPAD/jsp/chartwidgets/clinicalevents/ClinicalEventsViewContent.jsp');

            $(document).on("click", "#SlideOpener", function() {
                $('#ChartSummaryBlock ').css("width", "calc(100% - 245px)");
                $('#ChartSummaryBlock ').css('float', 'right');
				if(hideSFS=="False")
				{
					$('#EventsSideSFS').load(path + '/mobile/ClinicalEventsSFSServlet');
					hideSFS="True";
				}
			
                $('#EventsSideSFS').show();
                $('#SlideOpener').hide();
                $('.eventsMainPanel').hide();
                $('.FilterOpenMsg').css('display', 'table');
                CEMainScroll.refresh();
            });
        });

        function closeClinicalEvents() {
            parent.closeChartSummary();
        }

        function openOrdersFrame() {
			$("#PageLoadingAnimation").show();
            window.location.replace(path + "/mobile/charts/orders/MNewOrderServlet");
        }

        function openChartSummaryFrame() {
			$("#PageLoadingAnimation").show();
            window.location.replace(path + "/mobile/chartsummary/ChartWidgetsView");
        }

		function openClinicalEvents() {			
			$("#PageLoadingAnimation").show();
			window.parent.$('#hdnopeningPage').val('clinicalEvents');
			window.parent.$("#ChartsBaseForm").submit();
		}
		
		function openClinicalNotes() {
            $("#PageLoadingAnimation").show();
            window.location.replace(path+"/mobile/charts/notes/OpenClinicalNoteServlet");
        }
		
		function openPharmacyOrders(){
			$("#PageLoadingAnimation").show();
			parent.openPharmacyOrders();
		}

        function changeOrientation(orient, EMHFheight) {
            var CSHFheight = $('#CSHeader').height() + $('#CSFooter').height();
            var content_height = parent.getTotalPageDivHeight() - EMHFheight - CSHFheight - 10; //margin 5px
            $("#ChartSummaryMainWrapper").css("height", content_height + 'px');
            $('.eventsSidePanel,.FilterOpenMsg').css("height", content_height + 'px');
            $('#datePanelWrap').css("height", (content_height - 50) + 'px');
		    $('.noEventsMsgDisplay').css("height", (content_height - 25) + 'px');
		    $('.noEventsMsgDisplay').css("line-height", (content_height - 25) + 'px');
        }
    
	    function EncountersInRange(finalStartDate, finalEndDate,arrPC,arrHT) {
            $('div[id^="SLSfsTickEN"]').hide();
	        $('div[id^="SLSfsTickPC"]').hide();
	        $("#listPC").find(".listItemPC").show();			
	        $('div[id^="SLSfsTickHT"]').hide();
	        $("#listHT").find(".listItemHT").show();
	        var arrPCval="";
	        var arrHTval="";
	        if(arrPC.length>0) arrPCval=arrPC[0];
	        if(arrHT.length>0) arrHTval=arrHT[0];
	        loadClinicalEvents('', finalStartDate ,finalEndDate,arrPCval,arrHTval);
        }

        function loadClinicalEvents(encounterIds, finalStartDate, finalEndDate,patientClass,historyType) {
	        var  startDate="";
	        var  endDate="";		
	        if(finalStartDate!="" && finalStartDate!=undefined){	
		      finalStartDate=finalStartDate.split("-");	
		      finalEndDate=finalEndDate.split("-");	
		      startDate=finalStartDate[2]+"/"+finalStartDate[1]+"/"+ finalStartDate[0];
		      endDate=finalEndDate[2]+"/"+finalEndDate[1]+"/"+ finalEndDate[0];
	        }	
	
	        $('#EventsSidePanel').load(path + '/eIPAD/jsp/chartwidgets/clinicalevents/ClinicalEventsPanel.jsp',{"encounterIds": encounterIds,"startDate": startDate,"endDate": endDate,"patientClass": patientClass,"historyType": historyType},function(){		
              $(".listItemPC").hide();	
	          var patClassSFSSel =$('#patClass').val();
	          if(patClassSFSSel !='null' && patClassSFSSel !=""){
                var eventPatClass = patClassSFSSel.split(",");
                $.each( eventPatClass, function( index, value ){
                  $("#PC_"+value).show();
                });
	          }
	          $(".listItemHT").hide();
	          var eventTypeSFSSel =$('#eventType').val();
	          if(eventTypeSFSSel !='null' && eventTypeSFSSel !=""){
                var eventPatType = eventTypeSFSSel.split(",");
                $.each( eventPatType, function( index, value ){
                  $("#HT_"+value).show();
                });
                $("#dataHT").show();
              }else{
		        $("#dataHT").hide();
		      }
            });   
        }

        function clinicalEventsFilter(st,en,arrHT, arrPC) {	    
	        var listItemHT=[];

	        if(arrPC.length>0){
		      $('.EventsSideSFS').find(".listItemPC[data-speccode]").hide();
		      var MatchedValues = "[data-speccode='"+arrPC[0]+"']";
		      $('.EventsSideSFS').find(".listItemPC" + MatchedValues).show();
		    }
	        else{
			  $('.EventsSideSFS').find(".listItemPC[data-speccode]").show();
			}
		   
		    if(arrHT.length>0){
		      $('.EventsSideSFS').find(".listItemHT[data-speccode]").hide();
		      var MatchedValues = "[data-speccode='"+arrHT[0]+"']";		
		      $('.EventsSideSFS').find(".listItemHT" + MatchedValues).show();
	        }
	        else{		
		      $('.EventsSideSFS').find(".listItemHT[data-speccode]").show();
	        }
	
	        $(".listItemHT:visible").each(function (i,v){	
			  listItemHT.push($(this).attr('data-speccode'));
	        });
	        var arrPCval="";
	        var arrHTval="";
	        if(arrPC.length>0) arrPCval=arrPC[0];
	        if(arrHT.length>0) arrHTval=arrHT[0];
	        loadClinicalEvents(encounterIDs, st, en,arrPCval,arrHTval);
		}

        function chooseEncounterFilter(encounterID, openingPages) {
	        if ($("#contentPC").is(":visible"))	
		       CNFilterSectionToggle('PC');
	
	        if ($("#contentHT" ).is(":visible"))	
		       CNFilterSectionToggle('HT');
		
	        $('div[id^="SLSfsTickPC"]').hide();
	        $("#listPC").find(".listItemPC").show();
	        arrPC.length=0;
	        $('div[id^="SLSfsTickHT"]').hide();
	        $("#listHT").find(".listItemHT").show();
	        arrHT.length=0;	

	        var encIDs = $('#hdnEncIDs').val().split(",");
            encounterIDs = "";
            if ($("#SLSfsTickEN" + encounterID).is(":visible")) {
               if ($('#contentEC .listItemEC').length == 1) {
                  return;
               }
               $("#SLSfsTickEN" + encounterID).hide();
            } 
			else {
              //clearing notetype and ticks			 
              $("#AfterSelectionNT").html('');
              $('.searchByNotes').removeClass("enableSearch");
              $("#SLSfsTickEN" + encounterID).show();
            }

            for (var i = 0; i < encIDs.length - 1; i++) {
              if ($("#SLSfsTickEN" + encIDs[i]).is(":visible")) {
                 encounterIDs = encounterIDs + encIDs[i] + ",";
              }
            }
            encounterIDs = encounterIDs.slice(0, -1);	
	        var arrPCval="";
	        var arrHTval="";
	        if(arrPC.length>0) arrPCval=arrPC[0];
	        if(arrHT.length>0) arrHTval=arrHT[0];
	        $("#SelectedhdnEncIDs").val(encounterIDs);

	        loadClinicalEvents(encounterIDs, "", "",arrPCval,arrHTval);
            parent.setTimeFrame();
        }
    </script>
    </body>
</html>

