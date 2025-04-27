<!DOCTYPE html>
<%@page import="java.util.StringTokenizer"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="eIPAD.chartsummary.common.response.ErrorInfo"%>
<%@page import="eIPAD.chartsummary.common.healthobject.PatContext"%> 
<%@page import="eIPAD.chartsummary.CLEventHistory.bc.ClinicalEventsBC"%>
<%@page import="eIPAD.chartsummary.CLEventHistory.request.ClinicalEventsFilterRequest"%>
<%@page import="eIPAD.chartsummary.CLEventHistory.response.ClinicalEventDatewiseCountResponse"%>
<%@page import="eIPAD.chartsummary.CLEventHistory.healthobject.CLEventHistoryItemHO"%>
<%@page import="eIPAD.chartsummary.CLEventHistory.healthobject.ClinicalEventHistItemCount"%>                
<%@page import="eIPAD.chartsummary.CLEventHistory.healthobject.ClinicalEventDateCountItem"%>
<%@page import="java.util.Date"%> 
<%@page import="java.text.SimpleDateFormat"%> 
<%@page import="eIPAD.chartsummary.CLEventHistory.healthobject.ClinicalEventHistItemCountDets"%> 
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<div class="eventsSidePanel" >	
	<div class="dateSelection">		
		<div class="selectdate">Select a date</div> 
		<div style="display: inline-block;float:right;margin:-5px;margin-top:1px;"><input id="cevtdate"></div>		
	</div>		
	<div id="datePanelWrap" style="Clear:both;top:5px;padding-top: 0px;">
		<div class="datePanelScroller">
			<%
				PatContext patientContext = (PatContext)session.getAttribute("PatientContext"); //Patient context to bring data stored in session
				String loggedInUser = patientContext.getLoggedInUser();
				ClinicalEventsBC objEvents = new ClinicalEventsBC();
				ClinicalEventsFilterRequest eventsReq = new ClinicalEventsFilterRequest();
				eventsReq.setPatientContext(patientContext);
				
				String encounterIDs = request.getParameter("encounterIds")==null?"":request.getParameter("encounterIds");				
				String startDate = request.getParameter("startDate");
				String endDate = request.getParameter("endDate");
				String patientClass= request.getParameter("patientClass");
				String historyType = request.getParameter("historyType");
		
				StringTokenizer stoken = new java.util.StringTokenizer(encounterIDs,",");	
				ArrayList<String> encounterIdList = new ArrayList<String>();
				while(stoken.hasMoreTokens()){
					String encId	=	(String) stoken.nextToken();
					encounterIdList.add(encId);
				}				
				eventsReq.setEncounterIdList(encounterIdList);
				eventsReq.setFromDate(startDate);
				eventsReq.setToDate(endDate);
				eventsReq.setPatientClass(patientClass);
				eventsReq.setHistoryType(historyType);				
				
				ClinicalEventDatewiseCountResponse res = objEvents.getDatewiseEventsCount(eventsReq);
				
				List<ClinicalEventDateCountItem> eventsList;
				ClinicalEventDateCountItem objHO;
				eventsList = res.getDatewiseEventList();
				int countEvents = eventsList.size();
				
				String eventDates = new String("");
				String eventType = new String("");
				String patClass = new String("");
				for(int nLoopCount=0; nLoopCount<countEvents; nLoopCount++)
					{ 
						objHO = eventsList.get(nLoopCount);
						ArrayList<ClinicalEventHistItemCount> objEventItems =objHO.getEventItemsCount();
						if(objHO != null ){
							Date todayDt = new Date();
							Date yesdayDt =new Date(new Date().getTime() - 60*60*24*1000);
							String todayDateStr = new String("");
							String yesdayDateStr = new String("");
							String dateStr = new String("");
							SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-M-d"); 
							String startDateStr = dateFormat.format(objHO.getEventDate());
							eventDates=eventDates+startDateStr+",";
							SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy");
							todayDateStr= formatter.format(todayDt).toUpperCase();
							yesdayDateStr= formatter.format(yesdayDt).toUpperCase();
							dateStr= formatter.format(objHO.getEventDate()).toUpperCase();
							if (dateStr.equals(todayDateStr))
								todayDateStr="Today";
							else if (dateStr.equals(yesdayDateStr))
								todayDateStr="Yesterday";
							else
								todayDateStr=dateStr;
						%>
							<%if(nLoopCount == 0){%>
								<div class="dayWiseWrap selectedDate" onclick="dateChangeOnClick('<%=startDateStr%>','<%=nLoopCount%>')" id="<%=startDateStr%>" data-intialvalue="<%=startDateStr%>" data-dateValue="<%=objHO.getEventDate()%>">	
							<input type="hidden"  name = "intialvalue" id = "intialvalue" value='<%=startDateStr%>'/>
							<%}else{%>
							<div class="dayWiseWrap" onclick="dateChangeOnClick('<%=startDateStr%>', '<%=nLoopCount%>')" id="<%=startDateStr%>">
							
							<%}	%>
							<div class="table">
								<div class="date-header"><%=todayDateStr%></div>
									<%	for(int j=0; j<objEventItems.size(); j++)
										{ 
											ClinicalEventHistItemCount objHistItem =objEventItems.get(j);
											 if(eventType.indexOf(objHistItem.getHistType()) == -1){
												eventType=eventType+objHistItem.getHistType()+",";	  
											 }
									 %>
											<div id="<%=objHistItem.getHistType()%>_<%=startDateStr%>" 
											class="row SLSfsInlineBlock SLSfsInlineBlockTheme clincalTheme<%=objHistItem.getHistType()%>" 
											onclick="eventsOnClick(event,'<%=objHistItem.getHistType()%>_<%=startDateStr%>')"> 
												<div class="cell SLSfsInlineBlockCell SLSfsInlineBlockCellTheme"><%=objHistItem.getHistDesc()%></div>
													<div class="cell SLSfsInlineBlockClose"><%=objHistItem.getCount()%></div>
												</div>
												<%	ArrayList<ClinicalEventHistItemCountDets>  singleItmes	=	objHistItem.getEventDetailsList();
													 for(int k=0;k<singleItmes.size();k++){
														 ClinicalEventHistItemCountDets singleItme=singleItmes.get(k);														 
														 if(patClass.indexOf(singleItme.getPatientClass()) == -1){
															patClass=patClass+singleItme.getPatientClass()+",";	  
														}
											}}%>
								</div>								
							</div>
									<%}}%>
										<input type="hidden"  name = "eventDates" id = "eventDates" value="<%=eventDates%>"/>
										<input type="hidden"  name = "eventType" id = "eventType" value="<%=eventType%>"/>
										<input type="hidden"  name = "patClass" id = "patClass" value="<%=patClass%>"/>
										<input type="hidden" name="hdnPath" id="hdnPath" id="hdnPath" value="${path}" />
								</div>
							</div>
	</div>	
</div>
<div id="PageLoadingAnimation" class="absoluteCenter"></div>
<script>
	function formatSystemDate(d) {
        var month = '' + (d.getMonth() + 1),
        day = '' + d.getDate(),
        year = d.getFullYear();
        return [year, month, day].join('-');
    }
	
	function getFormattedDate(t_sdate){
		var currDate = new Date();
		var formmatedCurrDate = formatSystemDate(currDate); 			
		var previousDate = new Date(new Date().getTime() - 60*60*24*1000);
		var formmatedPrevDate = formatSystemDate(previousDate); 			
		var combineDatestr = "";
			
		if(t_sdate == formmatedCurrDate){
			combineDatestr = "Today";
		}
		else if(t_sdate == formmatedPrevDate){
			combineDatestr = "Yesterday";
		}
		else{
			var sptdate = String(t_sdate).split("-");
	        var monthsList = ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'];
	        var Month = sptdate[1];
	        var Day = sptdate[2];
	        var Year = sptdate[0];
	        combineDatestr = Day + " " + monthsList[Month - 1] + " " + Year;
		}
		return combineDatestr;
	} 		
	
	function setHeightAndBase(){
	    var fromTopValues=0;
	    $("div[data-notes]").each( function (index, value) {
		    var dataNotes =$(this).attr('data-notes');
            var headerID = dataNotes;
		    var headerTop= $("#"+headerID).height();
	        $(this).attr('data-start', fromTopValues);
            fromTopValues=fromTopValues+headerTop;
                $(this).attr('data-height', headerTop);
                $(this).attr('data-end', fromTopValues);
            });
	}
 
    function addHideAttribute(pos){
		var counts=[];
		var display="display";
		$("div[data-notes]").each( function (index, value){
			var datadisp =$(this).attr('data-disp');
			if(datadisp==display){
				counts.push(display);
			}
		});
		if(counts.length>5){
		    var dataHeight =$("#"+pos+"_event").attr('data-height');
            var showEvents=$("#"+pos+"_event");
		    $("#"+pos+"_event").attr("data-disp", "none");	
		    $("#"+pos+"_event").attr("data-removed", "yes");	
		    $("#"+pos+"_event").attr("data-previous",dataHeight);	
		}
	}
	
    function addShowAttribute(pos){
		var showEvents=$("#"+pos+"_event");
		$("#"+pos+"_event").attr("data-disp", "display");
		$("#"+pos+"_event").css('display','block');
	}
	
	function onInitialLoad(){
		$('.notesViewWrapper .notes').empty();
		var dateArr=[];
		var adder=[];
		if ($("#eventDates").val() != null && $("#eventDates").val() != "") {
			dateArr = $("#eventDates").val().split(",");
			dateArr.pop();
		}
		else if($("#eventDates").val() == ""){
			$("#noEventsMsg").css("display","block");
		}
		if(dateArr.length>0)		
			$("#PageLoadingAnimation").show();
         
		    for(var i=0;i<dateArr.length;i++){
		  $('.notesViewWrapper .notes').append('<div style="display:none;" id="'+i+'_event" data-disp="none" data-positions='+i+' data-date='+dateArr[i]+' data-notes="'+i+'_event"><div class="clinicalEventDateHeader header'+i+'"><div class="clinicalEventDateSpan"><div class="clinicalEventDatePosition">'+getFormattedDate(dateArr[i])+'</div></div></div><div style="overflow:hidden;" id="date'+dateArr[i]+'" class="note'+i+'"></div></div>'); 
		    }
		
		    var dateArrLength=dateArr.length;
		    var count;
		    if(dateArrLength>=5){
		       count=5;				
		    }else{
			   count=dateArrLength;				
		    }
		
		    for(var i=0;i<count;i++){   		
		        addShowAttribute(i);
			    $(".note"+i).append("<div class='PageLoadingAnimationInside'></div>");	
	            var selected_encd= $('#SelectedhdnEncIDs').val();	
	            var startFilterDate= $('#Selectedhdnstart').val();
	            var endFilterDate= $('#Selectedhdnend').val();
	            var PCFilter= $('#Selectedhdnpc').val();
	            var HTFilter= $('#SelectedhdnHT').val();
		
			    if(selected_encd==undefined){
				 selected_encd="";
			    }
			    if(startFilterDate==undefined){
				 startFilterDate="";
			    }
			    if(endFilterDate==undefined){
				 endFilterDate="";
			    }
			    if(PCFilter==undefined){
				 PCFilter="";
			    }
			    if(HTFilter==undefined){
				 HTFilter="";
			    }			
			    $("#"+i+"_event").css('display','block');
	    	    $(".note"+i).load(path+'/eIPAD/jsp/chartwidgets/clinicalevents/ClinicalEventSelectedView.jsp?date='+dateArr[i]+'&pos='+i+'&selected_encd='+selected_encd+'&startFilterDate='+startFilterDate+'&endFilterDate='+endFilterDate+'&PCFilter='+PCFilter+'&HTFilter='+HTFilter,
        	      function(res){ 
					adder.push(res);
					if(adder.length==count){
					  CEMainScroll.scrollToElement(".header0" , 0 );
					  $("#PageLoadingAnimation").hide();
					  setHeightAndBase();	
					}
					CEMainScroll.refresh();	
                  }
		        );					  
	        }	    
	
	    var availableDates = $('#eventDates').val().slice(0, -1).split(",");
        var minDate = availableDates[availableDates.length - 1].split(/[^0-9]/);
        var pastDate = new Date(minDate[0], minDate[1] - 1, "01"); 
        var today = new Date();
        var maxDate = new Date(today.getFullYear(), today.getMonth() + 1, "0");
        $("#cevtdate").kendoDatePicker({
            value: new Date(),
            min: new Date(pastDate.setDate(pastDate.getDate())),
            max: new Date(maxDate.setDate(maxDate.getDate())),
            dates: availableDates,
            disableDates: function(date) {
                            var dates = $("#cevtdate").data("kendoDatePicker").options.dates;
                            if (date && compareDates(date, dates)) {
                                return false;
                            } else
                            {
                                return true;
                            }
            },
            change: function() {
                        var value = this.value();
                        var evtId = value.getFullYear().toString() + '-' + (value.getMonth() + 1).toString() + '-' + value.getDate().toString();
                        dateChangeOnClick(evtId);
            }
        }); 
    }  
		
	$(document).ready(function() {	
        parent.setOnLoadContentPaneHeight();
        datePanelWrap = new IScroll('#datePanelWrap', {
		   vScroll: true,
		   click: true,
           mouseWheel: true
        });
	    onInitialLoad();
        if ($('.selectedDate input').val() != undefined) {
           $('#EventsSidePanel').show();        
        } else{
		   $('#EventsSidePanel').hide();
		}
		   	
        $(document).on('click', '.dayWiseWrap', function() {
            $('.dayWiseWrap').removeClass('selectedDate');
            $(this).toggleClass('selectedDate');
        });
    });

    function available(date) {
        dmy = date.getDate() + "-" + (date.getMonth() + 1) + "-" + date.getFullYear();
        if ($.inArray(dmy, availableDates) != -1) {
            return [true, "", "Available"];
        } else {
            return [false, "", "unAvailable"];
        }
    }

    function compareDates(date, dates) {
        for (var i = 0; i < dates.length; i++) {
            var dateArray = dates[i].split(/[^0-9]/);
            var dt = new Date(dateArray[0], dateArray[1] - 1, dateArray[2]);
            if (dt.getDate() == date.getDate() && dt.getMonth() == date.getMonth() && dt.getYear() == date.getYear()) {
                return true;
            }
        }
    }
	
	function getAllPostions(){		
		var checkArray=[];
		var eventDatesObj = $("#eventDates").val().split(",");
        eventDatesObj.pop();		 
		for(var i=0;i<eventDatesObj.length;i++){  		 
		  checkArray.push(i);		
		}		 
		return  checkArray;
	}
	
	function checkGivenValuesInsideRange(start,end){
		 var checkArray=[];
		 var eventDatesObj = $("#eventDates").val().split(",");
         eventDatesObj.pop();
		 var allPos=getAllPostions();
	
		 for(var i=start;i<=end;i++){  		 
		    if(allPos.indexOf(i)!=-1){				
				checkArray.push(i);				
		    }		 
        }		
		return  checkArray;		
	}

	function dateChangeOnClick(date,position){
        $(".SLSfsInlineBlockTheme").removeClass('highlightSelectedEvent'); 
        $('.notesViewWrapper .notes').html('');	
	    var eventDatesObj = $("#eventDates").val().split(",");
	    eventDatesObj.pop();
        var pos = parseInt(position);
        var adder = [];
        var selectedPos;

        if (position == undefined) {
           var datePosInCalendar = eventDatesObj.indexOf(date);
           selectedPos = datePosInCalendar;
        } else {
           selectedPos = position;
        }	
	    var start= parseInt(selectedPos)-parseInt(2);
	    var end= parseInt(selectedPos)+parseInt(2);	
	    $("#PageLoadingAnimation").show();

	    for(var i=0;i<eventDatesObj.length;i++){	
		  $('.notesViewWrapper .notes').append('<div style="display:none;" id="'+i+'_event" data-disp="none" data-positions='+i+' data-date='+eventDatesObj[i]+' data-notes="'+i+'_event"><div class="clinicalEventDateHeader header'+i+'"><div class="clinicalEventDateSpan"><div class="clinicalEventDatePosition">'+getFormattedDate(eventDatesObj[i])+'</div></div></div><div style="overflow:hidden;" id="date'+eventDatesObj[i]+'" class="note'+i+'"></div></div>'); 
		} 		
		var rangeChecker=checkGivenValuesInsideRange(start,end);
		var len=eventDatesObj.length;
		var count;
		if(len>=5){
		   count=5;				
		} else {
			count=len;				
		}
		
		var selected_encd= $('#SelectedhdnEncIDs').val();
		var startFilterDate= $('#Selectedhdnstart').val();
	    var endFilterDate= $('#Selectedhdnend').val();
	    var PCFilter= $('#Selectedhdnpc').val();
	    var HTFilter= $('#SelectedhdnHT').val();
		if(selected_encd==undefined){
			selected_encd="";
		}
		if(startFilterDate==undefined){
			startFilterDate="";
		}
		if(endFilterDate==undefined){
			endFilterDate="";
		}
		if(PCFilter==undefined){
			PCFilter="";
		}
		if(HTFilter==undefined){
			HTFilter="";
		}
		
		for(var i=start;i<=end;i++){   		
		    addShowAttribute(i);
			$("#"+i+"_event").css('display','block');			
			$(".note"+i).append("<div class='PageLoadingAnimationInside'></div>");				
	    	$(".note"+i).load(path+'/eIPAD/jsp/chartwidgets/clinicalevents/ClinicalEventSelectedView.jsp?date='+eventDatesObj[i]+'&pos='+i+'&selected_encd='+selected_encd+'&startFilterDate='+startFilterDate+'&endFilterDate='+endFilterDate+'&PCFilter='+PCFilter+'&HTFilter='+HTFilter,
        	  function(res, status, xhr){
        		$("#PageLoadingAnimation").hide();
				adder.push(res);
				if(adder.length==rangeChecker.length){
					$("#PageLoadingAnimation").hide();
					CEMainScroll.refresh();	
					setHeightAndBase();
                    CEMainScroll.scrollToElement(".header"+selectedPos , 0 );					  
				}	
              }
		    );					  
	    }
	  
		$('.dayWiseWrap').removeClass('selectedDate');
        $("#"+date).toggleClass('selectedDate');
        datePanelWrap.scrollToElement(".selectedDate", 1);
        $('#cevtdate').data('kendoDatePicker').value(date);
    }	

    function clear(range,min,max){
	  if(range=="min"){
	    addHideAttribute(max);
	  }else{
	    addHideAttribute(min);
	  }
	  setHeightAndBase();
    }

    function hideAllDivs(){	
        $("div[data-notes]").each( function (index, value) {
            var data_date =$(this).attr('data-date');
            var data_disp =$(this).attr('data-disp');
	        var data_pos =$(this).attr('data-positions');

           if(data_disp=="none"){
	          $("#"+data_pos+"_event").css('display','none');	
	          var dat="#date"+data_date;	  
              $(dat).html('');
           }  
        });
    }

    function getMinMaxDate(){
		var visibleDatesArr=[];				
		$("div[data-notes]").each( function (index, value) {			
			var divDisp = $(this).attr('data-disp');
			var divPos = $(this).attr('data-positions');
			if(divDisp == "display"){
				visibleDatesArr.push(divPos);
			}
		});	
		return visibleDatesArr;
    }

	function getLastHideCount(){
	    var indexes=0;
	    $("div[data-notes]").each( function (index, value) {			
			var removeDiv = $(this).attr('data-removed');
			var divHeight = $(this).attr('data-previous');			
			if(removeDiv == "yes"){
				indexes=indexes+1;
			}
		});		
		return  indexes;
    }
	
    function moveToScrollPos(vals){
	    var height=0;
	    var indexes=0;
	    var finalHeight=0;
	    $("div[data-notes]").each( function (index, value) {			
			var removeDiv = $(this).attr('data-removed');
			var divHeight = $(this).attr('data-previous');
			
			if(removeDiv == "yes"){
				indexes=indexes+1;				
				height=parseInt(height)+parseInt(divHeight);
			}
		});		
	    var calculatedVal=parseInt(vals)-parseInt(height);			
	    finalHeight=parseInt(calculatedVal)+(parseInt(indexes)*parseInt(1));
	    return  finalHeight;	
    }
	
	function removeAttribute(){	
	    $("div[data-notes]").each( function (index, value) {			
			var removeDiv = $(this).attr('data-removed');
			var divHeight = $(this).attr('data-previous');
			
			if(removeDiv == "yes"){
				$(this).removeAttr('data-removed');
				$(this).removeAttr('data-previous');
			}
		});	
	}
	
    function loadDataOnEnd(date,position,range,min,max,vals){
	    var eventDatesObj = $("#eventDates").val().split(",");
        eventDatesObj.pop();
        var pos = parseInt(position);
	    var loadData1;
	    var loadData2;
	    var loadPos1;
	    var loadPos2;
	    var currectloadData;
	    var loadData;
	    var totalClear=0;
	    var visibleDatesArr = getMinMaxDate();
		var minValue=visibleDatesArr[0];
		var maXvalue=visibleDatesArr[visibleDatesArr.length-1];
		
	    if(range=="min"){
		   loadData1 = eventDatesObj[parseInt(position) - parseInt(1)];
           loadData2 = eventDatesObj[parseInt(position) - parseInt(2)];	 		 
	       loadPos1 = parseInt(position) - parseInt(1);
		   loadPos2 = parseInt(position) - parseInt(2);		 
	    }else if(range=="max"){
		   loadData1 = eventDatesObj[parseInt(position) + parseInt(1)];
           loadData2 = eventDatesObj[parseInt(position) + parseInt(2)];
	       loadPos1 = parseInt(position) + parseInt(1);
		   loadPos2 = parseInt(position) + parseInt(2);
	    }
	
	    var selected_encd= $('#SelectedhdnEncIDs').val();
	    var startFilterDate= $('#Selectedhdnstart').val();
	    var endFilterDate= $('#Selectedhdnend').val();
	    var PCFilter= $('#Selectedhdnpc').val();
	    var HTFilter= $('#SelectedhdnHT').val();
	
	    if(selected_encd==undefined){
			selected_encd="";
		}
		if(startFilterDate==undefined){
			startFilterDate="";
		}
		if(endFilterDate==undefined){
			endFilterDate="";
		}
		if(PCFilter==undefined){
			PCFilter="";
		}
		if(HTFilter==undefined){
			HTFilter="";
		}

		if(eventDatesObj.indexOf(loadPos1)==-1){
			totalClear=totalClear+1;
			addShowAttribute(loadPos1);
			clear(range,min,max);
		}
					
	    $(".note"+loadPos1).append("<div class='PageLoadingAnimationInside'></div>");	
	    $(".note"+loadPos1).load(path+'/eIPAD/jsp/chartwidgets/clinicalevents/ClinicalEventSelectedView.jsp?date='+loadData1+'&pos='+loadPos1+'&selected_encd='+selected_encd+'&startFilterDate='+startFilterDate+'&endFilterDate='+endFilterDate+'&PCFilter='+PCFilter+'&HTFilter='+HTFilter,
        		function(res){	
					$("#PageLoadingAnimation").hide();
					hideAllDivs();
					setHeightAndBase();					
					if(range=="max"){						
					   var recentHideCount=getLastHideCount();					
					   if(recentHideCount==totalClear){
					      var scrolls=moveToScrollPos(vals) * parseInt(-1);				
				          setTimeout(function(){ CEMainScroll.scrollTo(0,scrolls); }, 500); 
					   }							
					}					
					CEMainScroll.refresh();
                }		
	    );	
	
	    if(eventDatesObj.indexOf(loadPos2)==-1){
			totalClear=totalClear+1;
			addShowAttribute(loadPos2);
			var visibleDatesArr = getMinMaxDate();
		    var minValue=visibleDatesArr[0];
		    var maXvalue=visibleDatesArr[visibleDatesArr.length-1];
		    clear(range,minValue,maXvalue);				
		}	
	    $(".note"+loadPos2).append("<div class='PageLoadingAnimationInside'></div>");	
	    $(".note"+loadPos2).load(path+'/eIPAD/jsp/chartwidgets/clinicalevents/ClinicalEventSelectedView.jsp?date='+loadData2+'&pos='+loadPos2+'&selected_encd='+selected_encd+'&startFilterDate='+startFilterDate+'&endFilterDate='+endFilterDate+'&PCFilter='+PCFilter+'&HTFilter='+HTFilter,
        		function(res){	
					$("#PageLoadingAnimation").hide();
					hideAllDivs();
					setHeightAndBase();					
				    if(range=="max"){
					   var recentHideCount=getLastHideCount();					
					    if(recentHideCount==totalClear){
					      var scrolls=moveToScrollPos(vals) * parseInt(-1);
		                  setTimeout(function(){ CEMainScroll.scrollTo(0,scrolls); }, 500); 
					    }
				    }
					CEMainScroll.refresh();	
                }		
	    );	
		
	    if(range=="min"){
		   loadData=eventDatesObj[loadPos2];
		   currectloadData=eventDatesObj[minValue];		
	    }else if(range=="max"){
		   loadData=eventDatesObj[pos];
		   currectloadData=eventDatesObj[maXvalue];		
	    }

	    if(eventDatesObj.length>5){
		    if(loadData==undefined){
			  $('.dayWiseWrap').removeClass('selectedDate');
              $("#"+currectloadData).toggleClass('selectedDate');
			  datePanelWrap.scrollToElement(".selectedDate", 1);
		    }else{
			  $('.dayWiseWrap').removeClass('selectedDate');
              $("#"+loadData).toggleClass('selectedDate');
			  datePanelWrap.scrollToElement(".selectedDate", 1);
		    }
	    }
         	
    }	

    function eventsOnClick(evt, eventDateObj) {
	    evt.stopPropagation();
	    var str = eventDateObj;
        var res = str.split("_");    
	    var current= res[1];
	    var htmlElem= $("."+eventDateObj).html();
	    var eventDatesObjs = $("#eventDates").val().split(",");
        eventDatesObjs.pop();
	    var datePosInCalendar = eventDatesObjs.indexOf(current);

	    if(htmlElem==undefined){
		    dateChangeOnClick(current,datePosInCalendar);
            setTimeout(function(){  		 
		       CEMainScroll.scrollToElement("."+eventDateObj , 1 );
            }, 1500);
	    }else{
		    CEMainScroll.scrollToElement("."+eventDateObj , 1 );
	    }

	    $(".SLSfsInlineBlockTheme").removeClass('highlightSelectedEvent');	
	    $("#"+eventDateObj).toggleClass('highlightSelectedEvent');	
	    $('.dayWiseWrap').removeClass('selectedDate');
        $("#"+current).toggleClass('selectedDate');
	    datePanelWrap.scrollToElement(".selectedDate", 1);	
    }

    CEMainScroll.on ('scrollStart', function () {
        $(".SLSfsInlineBlockTheme").removeClass('highlightSelectedEvent');
    });

</script>

<style>
.PageLoadingAnimationInside{
	z-index: 10000;
	width: 100%;
	height: 25px;
	background-color: #808080;
	opacity: 0.4;
	background-image: url(${path}/eIPAD/images/Loading24x24.gif);
	background-repeat: no-repeat;
	background-position: 50% 50%;
	 
}
.highlightSelectedEvent{
	box-shadow: 0px 2px 3px #888888;
}
</style>

