/*





document.addEventListener('touchmove', function (e) { e.preventDefault(); }, false);
$.extend($.expr[":"], { //search as you type
	"containsIN": function(elem, i, match, array) {
	return (elem.textContent || elem.innerText || "").toLowerCase().indexOf((match[3] || "").toLowerCase()) >= 0;
	}
	});
	
var SLSfsScrollEC;
var SLSfsScrollHT;
var SLSfsScrollPC;

var SLSfsScrollMain;
var currentViewMore;
var viewLessHeight;

var arrHT = []; 
var arrPC = []; 

var arrML = [];
var arrSPL = [];
var arrSN = [];

function CNFilterLoaded() {
	SLSfsScrollMain=  new IScroll('#SLSfsWrapperMain', { scrollbars: true, click: true, mouseWheel: true } );	
	SLSfsScrollEC = new IScroll('#SLSfsWrapperEC', { scrollbars: true, click: true,  mouseWheel: true } );
	SLSfsScrollHT = new IScroll('#SLSfsWrapperHT', { scrollbars: true, click: true,  mouseWheel: true } );
	SLSfsScrollPC = new IScroll('#SLSfsWrapperPC', { scrollbars: true, click: true,  mouseWheel: true } );	
}
function hideSlideSFS(){

	$('#EventsSideSFS').hide();
	$('#ChartSummaryBlock').css({'width':'100%'});
	$("#SlideOpener").show();
	$('.eventsMainPanel').show();
	$('.FilterOpenMsg').hide();
	CEMainScroll.refresh();		
}

$( document ).on( "swipeleft", "#SLSfsWrapperMain", function( e ) {
	hideSlideSFS();
});

function refreshMain(){	
	if(SLSfsScrollHT != undefined)
		SLSfsScrollHT.refresh();
	
	if(SLSfsScrollPC != undefined)
		SLSfsScrollPC.refresh();
	
	$("#listHT").find(".listItemHT").show();
	$("#listPC").find(".listItemPC").show();	
	$("#listML").find(".listItemML").show();
	$("#listSPL").find(".listItemSPL").show();
	$(".SLSfsTickVisible").hide();
	$(".SLSfsAfterSelectionTheme").hide();
	if($('#hdnCurrentEncID').val() != undefined){
		$("#SLSfsTickEN"+$('#hdnCurrentEncID').val()).hide();
		chooseEncounterFilter($('#hdnCurrentEncID').val(),'clinicalNotes','fullViewEncounter');
	}	
	
	if($('#searchInputSFSHT').length > 0)
	$('#searchInputSFSHT').val('');
	
	if($('#searchInputSFSPC').length > 0)
	$('#searchInputSFSPC').val('');
		
	arrHT.splice(0,arrHT.length);
	arrPC.splice(0,arrPC.length);
	
	arrML.splice(0,arrML.length);
	arrSPL.splice(0,arrSPL.length);
	arrSN.splice(0,arrSN.length);
	
	clinicalNotesFilter(arrHT,arrPC,arrML,arrSPL,arrSN);
}

function CNFilterShowTick(val, type){ 
	
	
	if(type=="HT"){	
		if($("#SLSfsTickHT"+val).is(":visible")){
			var index = arrHT.indexOf(val);
			arrHT.splice(index, 1);
			$("#SLSfsTickHT"+val).hide();
			
		}
		else{
			arrHT.push(val); 
			$("#SLSfsTickHT"+val).show();			
			}
		if(arrHT.length > 0){
			$('.searchByNotes').addClass("enableSearch");
		}else{
			$('.searchByNotes').removeClass("enableSearch")
		}
	}
	if(type=="PC"){
		arrPC =[];
		 if($("#SLSfsTickPC"+val).is(":visible")){
			 $("#SLSfsTickPC"+val).hide();
			 $('div[id^="SLSfsTickPC"]').hide();
			 
		 }else{
			 arrPC.push(val);
			 $('div[id^="SLSfsTickPC"]').hide();
			 $("#SLSfsTickPC"+val).show();			 
		 }		
	}	
	
	if(type !="HT"){			
		clinicalNotesFilter(arrHT,arrPC,arrML,arrSPL,arrSN);
	}
	if(arrHT.length == 0 && type =="HT" ){	
		clinicalNotesFilter(arrHT,arrPC,arrML,arrSPL,arrSN);
	}
	
}
function searchByNoteType(event){
	event.stopPropagation();
	clinicalNotesFilter(arrHT,arrPC,arrML,arrSPL,arrSN);
}
function myList(val,type){
	if(type=="ML"){
		if($("#SLSfsTickMLPract").is(":visible")){
			var index = arrML.indexOf(val);
			arrML.splice(index, 1);
			$("#SLSfsTickMLPract").hide();			
			clinicalNotesFilter(arrHT,arrPC,arrML,arrSPL,arrSN);
		}
		else{
			arrML.push(val); 
			$("#SLSfsTickMLPract").show();		
			clinicalNotesFilter(arrHT,arrPC,arrML,arrSPL,arrSN);
		}
	}
	if(type=="SPL"){
		if($("#SLSfsTickMLServ").is(":visible")){
			var index = arrML.indexOf(val);
			arrSPL.splice(index, 1);
			$("#SLSfsTickMLServ").hide();		
			clinicalNotesFilter(arrHT,arrPC,arrML,arrSPL,arrSN);
		}
		else{
			arrSPL.push(val); 
			$("#SLSfsTickMLServ").show();		
			clinicalNotesFilter(arrHT,arrPC,arrML,arrSPL,arrSN);
		}
	}
}

function CNFilterClearTxt(current,other1){
	document.getElementById("searchInputSFS"+current).value = "";
	$("#list"+current).find(".listItem"+current).show();
	if(current='HT'){
		SLSfsScrollHT.refresh();
	}
	if(current='PC'){
		SLSfsScrollPC.refresh();
	}
	
}

function CNFilterSectionToggle(current){
	$("#content"+current).toggle();
	$("#textBox"+current).toggle();
	$("#ViewMore"+current).toggle();
	
	
	 if(current=="HT"){	 
		 if($("#AfterSelectionHT").is(":visible")){
				$("#AfterSelectionHT").empty();
			}
			if(arrHT.length>0){
				$("#HTAfterSel").show();
				for(var i=0;i<arrHT.length;i++){
					var specCode= arrHT[i];
					var specDesc ="";
					$("[data-speccode = '"+specCode+"']").each(function (i,v ){
						specDesc = $(this).data("specdesc");
					});
		 			var inblockNT ='<div id="inBlockItem'+specCode+'" class="row SLSfsInlineBlock SLSfsInlineBlockTheme"> <div class="cell SLSfsInlineBlockCell SLSfsInlineBlockCellTheme"> '+ specDesc +' </div><div class="cell SLSfsInlineBlockClose" onclick="removeInblockItem(&quot;'+specCode+'&quot;,&quot;NT&quot;)"><img src="${path}/eIPAD/images/Close10x10.PNG"></div></div>';
		 			$("#AfterSelectionHT").append(inblockHT);    
			 	}
				var addmoreHT ='<div class="row SLSfsInlineBlock SLSfsInlineBlockTheme"> <div class="cell SLSfsInlineBlockCell SLSfsInlineBlockCellTheme" onclick="addmoreFilter(&quot;HT&quot;)"> Add more </div> </div>';
				$("#AfterSelectionHT").append(addmoreHT);
				$("#AfterSelectionHT").show();
				$("#contentHT").hide();
	 		    $("#textBoxHT").hide();
			}else{				
			}
			
		 }
	 if(current=="PC"){
		 if($("#AfterSelectionMAS").is(":visible")){
				$("#AfterSelectionMAS").empty();
			}
			if(arrPC.length>0){
				$("#PCAfterSel").show();
				for(var i=0;i<arrPC.length;i++){
					var specCode= arrPC[i];
					var specDesc ="";
					$("[data-speccode = '"+specCode+"']").each(function (i,v ){
						specDesc = $(this).data("specdesc");
					});
		 			var inblockPC ='<div id="inBlockItem'+specCode+'" class="row SLSfsInlineBlock SLSfsInlineBlockTheme"> <div class="cell SLSfsInlineBlockCell SLSfsInlineBlockCellTheme"> '+ specDesc +' </div><div class="cell SLSfsInlineBlockClose" onclick="removeInblockItem(&quot;'+specCode+'&quot;,&quot;PC&quot;)"><img src="${path}/eIPAD/images/Close10x10.PNG"></div></div>';
		 			$("#AfterSelectionPC").append(inblockPC);    
			 	}				
				$("#AfterSelectionPC").show();
				$("#contentPC").hide();
	 		    $("#textBoxPC").hide();
			}else{
			
			}			
		 } 
	 
	 
	 if($("#content"+current).is(":visible")){
			$("#arrow"+current).addClass('SLSfsarrow');
		}
		else{
			$("#arrow"+current).removeClass('SLSfsarrow')	;
		}
	 
}

function addmoreFilter(current){	
	$("#data"+current).height(viewLessHeight); 
	$("#content"+current).show();
	$("#textBox"+current).show();
	$("#ViewMore"+current).show();
	$("#AfterSelection"+current).hide();
	$('#AfterSelection'+current).empty();
	if($("#content"+current).is(":visible")){
			$("#arrow"+current).addClass('SLSfsarrow');
	}
	$('.listItem'+current).show();
}
function removeInblockItem(val,type){	
	if(type=="HT") {
		$("#inBlockItem"+val).remove();
		$("#SLSfsTickHT"+val).hide();
		var index = arrHT.indexOf(val);
		arrHT.splice(index,1);
			if(arrHT.length<1){
				 $("#NTAfterSel").hide();
				 $("#AfterSelectionHT").html('');				
				SLSfsScrollHT.refresh();
			}
	}
	if(type=="PC") {
		$("#inBlockItem"+val).remove();
		$("#SLSfsTickPC"+val).hide();
		var index = arrPC.indexOf(val);
		arrPC.splice(index,1);
			if(arrPC.length<1){
				 $("#PCAfterSel").hide();
				 $("#AfterSelectionPC").html('');				
				SLSfsScrollPC.refresh();
			}			
	}	
	
	clinicalNotesFilter(arrHT,arrPC,arrML,arrSPL,arrSN);
}
/*refresh filetr*/
 function refreshFilter(current,event){
	 event.stopPropagation();
	if(current == 'HT'){
		arrHT =[];
		 $('div[id^="SLSfsTickHT"]').hide();
		  $("#AfterSelectionHT").html('');
		SLSfsScrollHT.refresh();
	}

	clinicalNotesFilter(arrHT,arrPC,arrML,arrSPL,arrSN);
} 
 
/*time frame slider start*/ 
 
  	var dateArrayStr = $("#hdnEncounterDate").val();
  	var dateArrSize = $("#hdnDateArrCount").val();
	dateArray = $.parseJSON(dateArrayStr);
	
	var encArrayStr = $("#hdnEncounterEnc").val();
  	var encArrSize = $("#hdnEncArrCount").val();
	encArray = $.parseJSON(encArrayStr);
	
	var datePos = dateArrSize - 1;
	var encPos = encArrSize - 1;

	var cuurentDate = new Date();
	var currDate = new Date();
	var srtDate = new Date(currDate.setMonth(currDate.getMonth() - 3));
	
	var startDate = kendo.toString(srtDate, 'yyyy/M/d' ).split('\/');
	var prevDate = new Date();
	prevDate.setDate(startDate[2]);
	prevDate.setMonth(startDate[1]);
	prevDate.setYear(startDate[0]);	
	
	prevDate.setHours(0,0,0);
	cuurentDate.setHours(0,0,0);
parent.setTimeFrame=function () 
{	
	
	$('.startLabel').text(kendo.toString(prevDate, 'd MMM yyyy' ));
    var viewModel = kendo.observable({     
        selectedStartDate: prevDate,
        selectedEndDate: cuurentDate,
		datepickerStartValue:prevDate,
		datepickerEndValue:cuurentDate,
        selectedDateRange: [],
		pickerStartTime:'',
		pickerEndTime:'',
        selectedDatesChanged: function(){
				//to set slider on select date picker
				if(viewModel.selectedEndDate.getTime() <= viewModel.datepickerStartValue.getTime()){
					alert("start date should be less than current date");
					viewModel.set('datepickerStartValue',viewModel.selectedStartDate);
					viewModel.set("pickerStartTime",viewModel.selectedStartDate.getTime());
				}
				if(viewModel.selectedStartDate.getTime() > viewModel.datepickerEndValue.getTime()){
					alert("end date should not be less than start date");
					viewModel.set('datepickerEndValue',viewModel.selectedEndDate);
					viewModel.set("pickerEndTime",viewModel.selectedEndDate.getTime())
				}
				if(viewModel.selectedStartDate.getTime() <= viewModel.datepickerStartValue.getTime()){
					//does not allow to select lesser date of start date
					viewModel.pickerStartTime = viewModel.datepickerStartValue.getTime();
				}else{
					alert("select correct daterange");
					viewModel.set('datepickerStartValue',viewModel.selectedStartDate);
					viewModel.set("pickerStartTime",viewModel.selectedStartDate.getTime());
					
				}
				if(viewModel.selectedEndDate.getTime() >= viewModel.datepickerEndValue.getTime())	{
					//does not allow to select greater date of end date
					viewModel.pickerEndTime = viewModel.datepickerEndValue.getTime();
				}else{
					alert("select correct daterange");
					viewModel.set('datepickerEndValue',viewModel.selectedEndDate);
					viewModel.set("pickerEndTime",viewModel.selectedEndDate.getTime())
				}
            	viewModel.updateDateSlider();            	
        },
        dateStart: '',
        dateEnd: '',
        dateRangeChanged: function(){
            var dateRange = $("#dateSlider").data("kendoRangeSlider").value();
            var startdate = kendo.toString(new Date(dateRange[0]), 'd MMM yyyy' );
            var enddate = kendo.toString(new Date(dateRange[1]), 'd MMM yyyy' );
            viewModel.set('dateStart', startdate);
            viewModel.set('dateEnd', enddate);
            viewModel.set('selectedDateRange', dateRange);
			//to set datepicker on drag 
			viewModel.set('datepickerStartValue',new Date(dateRange[0]));
			viewModel.set('datepickerEndValue',new Date(dateRange[1]));			
        },
        updateDateSlider: function(){
            if ( viewModel.selectedStartDate <= viewModel.selectedEndDate)
            {
                // reinitialize the date slider, since sliders do not support dynamic changes
                var slider = $("#dateSlider").data("kendoRangeSlider");
                    if (slider){
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
                tickPlacement:'none',
                value: [viewModel.selectedStartDate.getTime(), viewModel.selectedEndDate.getTime()],
				selectionStart:(viewModel.pickerStartTime == '')  ? viewModel.selectedStartDate.getTime() : viewModel.pickerStartTime,
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
        resizeSliders: function(){
            // resize the sliders to fill the container
              var sliders = $("[data-role='rangeslider']");
                sliders.each(function (index, ele) {        
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
var temp;
var i;
var j=0;
var selectedDateArr = [];
function SearchByTimeFrame()
{
	var dateRange = $("#dateSlider").data("kendoRangeSlider").value();
	var startdate = kendo.toString(new Date(dateRange[0]), 'd MMM yyyy' );
    var enddate = kendo.toString(new Date(dateRange[1]), 'd MMM yyyy' );
    
    var startDateformat = kendo.toString(new Date(startdate), 'yyyy/MM/dd' );
    var startDateformatfinal =  startDateformat.split('\/');
    var finalStartDate = startDateformatfinal[0]+'-'+startDateformatfinal[1]+'-'+startDateformatfinal[2];
    
    var endDateformat = kendo.toString(new Date(enddate), 'yyyy/MM/dd' );
    var endDateformatfinal =  endDateformat.split('\/');
    var finalEndDate = endDateformatfinal[0]+'-'+endDateformatfinal[1]+'-'+endDateformatfinal[2];
    
    
    var viewPage="fullViewTimeRange";
    EncountersInRange(finalStartDate,finalEndDate,viewPage);
}
   
$(document).ready(function(){
	CNFilterLoaded();
	parent.setTimeFrame();
	//arrow setting intial for EC
	if($("#contentEC").is(":visible")){
		$("#arrowEC").addClass('SLSfsarrow');
	}
	
	$(document).on("click","#SlideOpener",function(){
	
	});
	
	$("#contentTF").hide();	
	$("#contentPC").hide();
	$("#contentHT").hide();	
	$("#textBoxHT").hide();	
	SLSfsScrollEC.on('beforeScrollStart', function () {
		SLSfsScrollMain.disable();
	});
	SLSfsScrollEC.on('scrollEnd', function () {
		SLSfsScrollMain.enable();
	});
	
	SLSfsScrollHT.on('beforeScrollStart', function () {
		SLSfsScrollMain.disable();
	});
	SLSfsScrollHT.on('scrollEnd', function () {
		SLSfsScrollMain.enable();
	});
	
	SLSfsScrollPC.on('beforeScrollStart', function () {
		SLSfsScrollMain.disable();
	});
	SLSfsScrollPC.on('scrollEnd', function () {
		SLSfsScrollMain.enable();
	});	
	
	$('#SLSfsWrapperMain').on('touchstart click', function(){
		SLSfsScrollMain.enable();
	});
	
	$("#searchInputSFSHT").keyup(function () {
		var rows = $("#listHT").find(".listItemHT").hide();
		   if (this.value.length) {
		       var data = this.value.split(" ");
		       $.each(data, function (i, v){
		       		var val = v.toLowerCase(); 
		       		rows.filter(":containsIN('" + val + "')").show();
					});
		   		}
		   	else rows.show();	
		});
	$("#searchInputSFSPC").keyup(function () {
		var rows = $("#listPC").find(".listItemPC").hide();
		   if (this.value.length) {
		       var data = this.value.split(" ");
		       $.each(data, function (i, v){
		       		var val = v.toLowerCase(); 
		       		rows.filter(":containsIN('" + val + "')").show();
					});
		   		}
		   	else rows.show();	
		});
});
*/