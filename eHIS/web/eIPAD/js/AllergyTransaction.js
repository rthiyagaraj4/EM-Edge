
function StringToDate(string){
	var d = new Date();
	//var str='01/07/2013 11:18:13';
	var datenum,month,year;
	var hr=0, min=0, sec=0;
	var datetimearr = string.split(" ");
	if(datetimearr[0]){
		var datearr = datetimearr[0].split("/");
		if(datearr[0])
			datenum = parseInt(datearr[0]);
		if(datearr[1])
			month = parseInt(datearr[1]);
		if(datearr[2])
			year = parseInt(datearr[2]);
	}
	if(datetimearr[1]){
		var timearr = datetimearr[1].split(":");
		if(timearr[0])
			hr = parseInt(timearr[0]);
		if(timearr[1])
			min = parseInt(timearr[1]);
		if(timearr[2])
			sec = parseInt(timearr[2]);
	}
	
	d.setDate(datenum);
	d.setMonth(month-1);
	d.setFullYear(year);
	//if(hr!=0)
	d.setHours(hr);
	//if(min!=0)
	d.setMinutes(min);
	//if(sec!=0)
	d.setSeconds(sec);
	return d;
	
}

function twoDigits(num){
	if(num<10)
		num = "0" + num;
	return num;
}
function DMYHMSToString(dateobj){
	var d = new Date();
	if(dateobj){
		d = dateobj;
	}
	//--15/07/2013 10:45:06
	var stringDate = twoDigits(d.getDate()) + "/" + twoDigits((d.getMonth()+1)) + "/" + twoDigits(d.getFullYear()) + " " + twoDigits(d.getHours()) + ":" + twoDigits(d.getMinutes()) + ":" + twoDigits(d.getSeconds());
	return stringDate;
}

function DMYHMToString(dateobj){
	var d = new Date();
	if(dateobj){
		d = dateobj;
	}
	//--15/07/2013 10:45
	var stringDate = twoDigits(d.getDate()) + "/" + twoDigits((d.getMonth()+1)) + "/" + twoDigits(d.getFullYear()) + " " + twoDigits(d.getHours()) + ":" + twoDigits(d.getMinutes());
	return stringDate;
}

function DMYToString(dateobj){
	var d = new Date();
	if(dateobj){
		d = dateobj;
	}
	//--15/07/2013
	var stringDate = twoDigits(d.getDate()) + "/" + twoDigits((d.getMonth()+1)) + "/" + twoDigits(d.getFullYear());
	return stringDate;
}

function validateOnsetDate(field){
	var calendar = $("#OnsetDateTime").data("kendoDateTimePicker");
	var selected = calendar.value();
	//var today = new Date();
	//var dob = StringToDate(patDOB);
	
	//if(selected<patDOB || selected>today){
	//	var errMsg = $(field).data("errmsg1");
	//	setWarningMessage(field,errMsg);
	//	return false;
	//}
	//else{
	//	return true;
	//}
	if(selected>=patDOB && selected<=today){
		return true;
	}
	else{
		var errMsg = $(field).data("errmsg1");
		setWarningMessage(field,errMsg);
		calendar.value(today);
		return false;
		
	}
}

function validateActiveSinceDate(field){
	
	var onsetCal = $("#OnsetDateTime").data("kendoDateTimePicker");
	var onsetDate = onsetCal.value();
	
	var activeSinceCal = $("#ActiveSinceDate").data("kendoDatePicker");
	var activeSinceDate = activeSinceCal.value();
	
	//var today = new Date();
	
	if(activeSinceDate<=today && activeSinceDate>=onsetDate){
		return true;
	}
	else if(activeSinceDate>today){
		var errMsg = $(field).data("errmsg1");
		setWarningMessage(field,errMsg);
		activeSinceCal.value(today);
		return false;
	}
	else if(activeSinceDate<onsetDate){
		var errMsg2 = $(field).data("errmsg2");
		setWarningMessage(field,errMsg2);
		activeSinceCal.value(today);
		return false;
	}
	else{
		var errMsg2 = $(field).data("errmsg2");
		setWarningMessage(field,errMsg2);
		activeSinceCal.value(today);
		return false;
	}
	
	// if(activeSinceDate>today){
		// var errMsg = $(field).data("errmsg1");
		// setWarningMessage(field,errMsg);
		// return false;
	// }
	// else if(activeSinceDate<onsetDate){
		// var errMsg2 = $(field).data("errmsg2");
		// setWarningMessage(field,errMsg2);
		// return false;
	// }
	// else{
		// return true;
	// }
}

function validateReactionDate(field){
	
	//var today = new Date();
	
	var activeSinceCal = $("#ActiveSinceDate").data("kendoDatePicker");
	var activeSinceDate;
	if(activeSinceCal!=null){
		activeSinceDate = activeSinceCal.value();
	}
	//this happens in modify allergy page
	else{
		activeSinceDate = StringToDate($("#hdnActiveSinceDate").attr("value"));
	}
	var id= $(field).attr("id");
	var reactionCal = $(field).data("kendoDateTimePicker");
	var reactionDate = reactionCal.value();
	//alert("active since" +activeSinceDate);
	if(reactionDate<=today && activeSinceDate<=reactionDate){
		return true;
	}
	else if(reactionDate>today){
		var errMsg = $(field).data("errmsg1");
		setWarningMessage(field,errMsg);
		reactionCal.value(today);
		return false;
	}
	else if(reactionDate<activeSinceDate){
		var errMsg2 = $(field).data("errmsg2") + " " + activeSinceDate.getDate()+"/"+(activeSinceDate.getMonth()+1)+"/"+activeSinceDate.getFullYear();
		setWarningMessage(field,errMsg2);
		reactionCal.value(today);
		return false;
	}
	else{
		var errMsg = $(field).data("errmsg1");
		setWarningMessage(field,errMsg);
		reactionCal.value(today);
		return false;
	}
	
	// if(reactionDate>today){
		// var errMsg = $(field).data("errmsg1");
		// setWarningMessage(field,errMsg);
		// return false;
	// }
	// else if(reactionDate<activeSinceDate){
		// var errMsg2 = $(field).data("errmsg2") + " " + activeSinceDate.getDate()+"/"+(activeSinceDate.getMonth()+1)+"/"+activeSinceDate.getFullYear();
		// setWarningMessage(field,errMsg2);
		// return false;
	// }
	// else{
		// return true;
	// }
	
}

function validate(field){
	var result=true;
	if($(field).attr("id") == "OnsetDateTime"){
		result = validateOnsetDate(field);
	}
	if($(field).attr("id") == "ActiveSinceDate"){
		result = validateActiveSinceDate(field);
	}
	if($(field).attr("id").indexOf("ReactionDateTime") !== -1){
		result = validateReactionDate(field);
	}
	if(result){
		hideWarningDialog(field);
	}
	else{
		showWarningDialog(field);
	}
	return result;
}

function validateAndRecordAllergy(){
	var mandatoryValPassed = true;
	//Checking all mandatory fields
	$("[data-mandatory='true']").each(function(index,field){
		//alert($(field).val());
		if($(field).val().trim() == ""){
			mandatoryValPassed = false;
			$("#"+$(field).attr("id")+"_Label").css("color","red");
		}
		else{
			$("#"+$(field).attr("id")+"_Label").css("color","black");
		}
	});
	
	//Checking if atleast 1 reaction is added
	if($("[id^='ReactionContainer']").length == 0){
		$("#AllergyAllReactions_Label").css("color","red");
		mandatoryValPassed = false;
	}
	else{
		$("#AllergyAllReactions_Label").css("color","black");
	}
	
	var otherValPassed = true;
	//Checking for date validations
	otherValPassed = validate($("#OnsetDateTime"));
	otherValPassed = validate($("#ActiveSinceDate"));
	$("input[id^='ReactionDateTime']").each(function(index,field){
		var reactionDateValPassed = validate(field);
		if(!reactionDateValPassed){
			otherValPassed = false;
		}
	});
	//show mandatory fields error msg
	if(mandatoryValPassed != true ){
		$("#MandatoryFields_Error").show();
		setTimeout(function(){
			$("#MandatoryFields_Error").hide();
		},5000);
		$("#MandatoryFields_Error").bind('click',function(){
			$(this).hide();
		});
	}
	//setParametersForRecordAllergy();
	if(mandatoryValPassed && otherValPassed){
		
		setParametersForRecordAllergy();
		
		$("#frmRecordAllergy").submit();
	}
	
}



function validateAndModifyAllergy(){
	var mandatoryValPassed = true;
	//Checking all mandatory fields
	$("[data-mandatory='true']").each(function(index,field){
		//alert($(field).val());
		if($(field).val().trim() == ""){
			mandatoryValPassed = false;
			$("#"+$(field).attr("id")+"_Label").css("color","red");
		}
		else{
			$("#"+$(field).attr("id")+"_Label").css("color","black");
		}
	});
	
	var allReactionsMarkedAsError = false;
	var existingReactionCount = $("#existingReactionCount").val();
	existingReactionCount = parseInt(existingReactionCount);
	if(arrErrorReactionId.length >= existingReactionCount){
		allReactionsMarkedAsError = true;
	}
	
	
	
	var otherValPassed = true;
	//Checking for date validations
	$("input[id^='ReactionDateTime']").each(function(index,field){
		var reactionDateValPassed = validate(field);
		if(!reactionDateValPassed){
			otherValPassed = false;
		}
	});
	//show mandatory fields error msg
	if(mandatoryValPassed != true ){
		$("#MandatoryFields_Error").show();
		setTimeout(function(){
			$("#MandatoryFields_Error").hide();
		},5000);
		$("#MandatoryFields_Error").bind('click',function(){
			$(this).hide();
		});
	}
	else if(allReactionsMarkedAsError == true){
		$("#AllReactionsErrorMarked_Error").show();
		setTimeout(function(){
			$("#AllReactionsErrorMarked_Error").hide();
		},5000);
		$("#AllReactionsErrorMarked_Error").bind('click',function(){
			$(this).hide();
		});
	}
	
		//setParametersForRecordAllergy();
	if(mandatoryValPassed && otherValPassed && !allReactionsMarkedAsError){
		
		setParametersForModifyAllergy();
		$("#frmRecordAllergy").submit();
	}
	
}

function setParametersForRecordAllergy(){
	var calendar;
	var selected;
	calendar = $("#OnsetDateTime").data("kendoDateTimePicker");
	selected = calendar.value();
	$("#hdnOnsetDateTime").val(DMYHMSToString(selected));
	calendar = $("#ActiveSinceDate").data("kendoDatePicker");
	selected = calendar.value();
	$("#hdnActiveSinceDate").val(DMYToString(selected));
	
	var reactionsToAdd = arrReactionId.join("`");
	$("#hdnReactionsToAdd").val(reactionsToAdd);
	
	$("input[id^='ReactionDateTime']").each(function(index,field){
		var id = $(field).attr("id");
		var react_date_calobj = $(this).data("kendoDateTimePicker");
	 	 $("#hdn" + id).val(DMYHMToString(react_date_calobj.value()));
	});
	$("#hdnEventValues").val(null);
}
function setParametersForModifyAllergy(){
	var reactionsToAdd = arrReactionId.join("`");
	$("#hdnReactionsToAdd").val(reactionsToAdd);
	
	var reactionsToErr= arrErrorReactionId.join("`");
	$("#hdnErrorReactions").val(reactionsToErr);
	
	$("input[id^='ReactionDateTime']").each(function(index,field){
		var id = $(field).attr("id");
		var react_date_calobj = $(this).data("kendoDateTimePicker");
	 	 $("#hdn" + id).val(DMYHMToString(react_date_calobj.value()));
	});
	$("#hdnEventValues").val(null);
}
function cancelTransaction(){
	var path = document.getElementById("hdnPath").value + "/mobile/chartsummary/ChartWidgetsView";
	window.location.replace(path);
}

function setWarningMessage(field,errmsg){
	var id= $(field).attr("id");
	$("#"+id+"_WarningMsg").html(errmsg);
}
function showWarningDialog(field){
	var id= $(field).attr("id");
	$("#"+id+"_Warning").show();
	$("#"+id+"_Warning").bind('click',function(){
		$(this).hide();
	});
	//hide after 5 secs
	setTimeout(function() {
		$("#"+id+"_Warning").hide();
	}, 5000);
	
}
function hideWarningDialog(field){
	var id= $(field).attr("id");
	$("#"+id+"_Warning").hide();
}
// Script for modify/add allergy 

var recordScroll ;
var scaleHoverHeight = "10px";
var winWidth;
var winHeight;
var arrowLeft;
var arrowTop;
var sfsLeft;
var sfsTop;
var offset;
var bEventTypeSfs = false;
var wHt = 608;
var currentKendoControl;
var isDateControl = false;
var isDateTimeControl = false;
var isOpened = false;
var  bAllcontrolsLoaded = false;
var screenOrienttation = "landscape";
var reactionCount = 0;
var patDOB;
var today;
var arrowTop = 0;
var arrowLeft = 0;
var rTop = 0;
var rLeft = 0;
var dvReactionObj = null; // to hold the object reference of the circular icon placed next to each reaction item.
var dvErrorReactionObj = null; // to hold the object reference of the circular icon placed next to each reaction item.
var winWidth = 0; // global object to hold the document width
var winHeight = 0; // global object to hold th document height
var HFheight = 0;
var bRB = false; // to hide or show remove reaction bubble.
var bEB = false; // to hide or show mark reaction as error bubble.
var arrReactionCode = []; // To hold the reaction code. 
var arrReactionId = []; // to hold the reactionid,can be used in server side.
var arrErrorReactionId = []; // to hold the reactionids marked as error,can be used in server side.
var markErrorCount = 0;
var reactionIds = 0; // used remove the id from array arrReactionId when remove icon is clicked.
var cmbEventTypePrevValue = "";
var cmbPrevEventTypeText = "";
var bCmbSelectEventFired = false;

function allergyScroll() {
		 setTimeout(function () {
			recordScroll = new iScroll('divcnt', {
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
function scrollRefresh()
{
	if(recordScroll != null)
		recordScroll.refresh();
}
function hideReactionBubble()
{
	$('#sfsarrowUp').css("display" , "none");
	$('#sfsarrowDown').css("display" , "none");
	$('#dvRemoveReaction').css("display" , "none"); 
	
	
}
function hideErrorReactionBubble()
{
	$('#sfsarrowUpError').css("display" , "none");
	$('#sfsarrowDownError').css("display" , "none");
	$('#dvMarkAsError').css("display" , "none"); 
	
	
}
function changeOrientation(orient, EMHFheight)
{
	var CSHFheight = $('#allergyHeader').height();
	HFheight = EMHFheight;
	var content_height = parent.getTotalPageDivHeight() - EMHFheight - CSHFheight-6 ;
	document.getElementById("divcnt").style.height = content_height+"px";
	screenOrienttation = orient;
	scrollRefresh();
	//showReactionBubble();
    hideReactionBubble();
	hideErrorReactionBubble();
    if(dvReactionObj != null)
	{
		//$(dvReactionObj).html("-");	
		$(dvReactionObj).removeClass("removeReactionActTheme").addClass("removeReactionTheme");
	}
	if(dvErrorReactionObj != null)
	{
		//$(dvErrorReactionObj).html("-");	
		$(dvErrorReactionObj).removeClass("removeReactionActTheme").addClass("removeReactionTheme");
	}
    bRB = false;
	bEB = false;
	if( bAllcontrolsLoaded)
	{
		 // to close all the Kendo pop up controls when orientation changes
		 $("[data-type = 'DateTime']").each(function(index, value) { 
			 $(this).data("kendoDateTimePicker").close("date");
			 $(this).data("kendoDateTimePicker").close("time");
		 });
		
		 $("[data-type = 'Date']").each(function(index, value) { 
			 $(this).data("kendoDatePicker").close();
			
		 });
		 $("[data-type = 'ComboBox']").each(function(index, value) { 
			 $(this).data("kendoComboBox").close();		
		 });
		 if(screenOrienttation == "landscape") // to display the sfs based on the orientation
		 {
			 
			$('#sfs').css("left" , "15%");
		 }
		 else
		 {
		     $('#sfs').css("left" , "2%");	 
		 }
	}	
}
function validateEventType()
{
	  // var bReturn = true;
	   var kComboType = $("#cmbEventType").data("kendoComboBox");
	   /*
	   alert("prevtouch " +cmbPrevEventTypeText);
	   alert("ktext"+ kComboType.text());
	   alert("kselect" +kComboType.select() );
	   alert("kvalue" + kComboType.value());
	   alert("prev" + cmbEventTypePrevValue);
	   */
	   if(kComboType.select() == -1)
	   {
		   clearDetails("EVNTCOMBO");
		   kComboType.value("");
		   kComboType.text("");
		   cmbEventTypePrevValue =  "";
		   cmbPrevEventTypeText = "";
		   document.getElementById("hdnEventTypeCode").value = "";
           document.getElementById("hdnEventTypeCodeValue").value = "";
          
	   }
	   else if(kComboType.value() != "" && kComboType.value() == cmbEventTypePrevValue && kComboType.text() != cmbPrevEventTypeText)
	   {
		   
		   kComboType.value("");
		   kComboType.text("");
		   cmbEventTypePrevValue =  "";
		   cmbPrevEventTypeText = "";
		   document.getElementById("hdnEventTypeCode").value = "";
           document.getElementById("hdnEventTypeCodeValue").value = "";
           clearDetails("EVNT");
		  // alert("hi");
	   }
}
$(document).ready(function () {
	 parent.setOnLoadContentPaneHeight();
	 bAllcontrolsLoaded = true;
	 
	 if(screenOrienttation == "landscape")
	 {
		 
		$('#sfs').css("left" , "15%");
	 }
	 if(screenOrienttation == "portrait")
	 {
	     $('#sfs').css("left" , "2%");	 
	 }
	 else
	 {
		 $('#sfs').css("left" , "15%");
	 }
	
	$('#txtCA').bind('touchmove', function(event){
    	event.stopPropagation();
	});
	$(document).bind('touchstart', function(event){
/*	   if(bEventTypeSfs)
		{
		   $('#sfs').css("display" , "none");
		   bEventTypeSfs = false;
		}*/
	   validateEventType();
	   if(bRB)
	   {
		    hideReactionBubble();
			bRB = false;
			if(dvReactionObj != null)
			{
				//$(dvReactionObj).html("-");
				$(dvReactionObj).removeClass("removeReactionActTheme").addClass("removeReactionTheme");
			}
	   }
	   if(bEB)
	   {
		    hideErrorReactionBubble();
			bEB = false;
			if(dvErrorReactionObj != null)
			{
				//$(dvErrorReactionObj).html("-");
				$(dvErrorReactionObj).removeClass("removeReactionActTheme").addClass("removeReactionTheme");
			}

	   }
	});
	$('#dvRemoveReaction').bind('touchstart', function(event){
		//event.preventDefault();
		event.stopPropagation();
	});
	$('#dvMarkAsError').bind('touchstart', function(event){
		//event.preventDefault();
		event.stopPropagation();
	});
	//---------slider functionality starts---------------
	jQuery.fn.sliderControl = function() { 
	    var scrollStartPos = 0; 
	    var scrollLast = 0;
	    var dvleft = 100;
	    var n33 = 0;
	    var n66 = 0;
	    var n99 = 0;
	    var touchleft = 0;
	    var iDcount = "1";
	    var offset = null;  
	    var scaleLeft = "0%";
	    $(this).bind('touchstart', function(event) { 
	        var e = event.originalEvent; 
	        var orig = event.originalEvent;
		    var pos = $(this).position();
		    offset = {
		      x: orig.changedTouches[0].pageX - pos.left,
		      y: orig.changedTouches[0].pageY - pos.top
		    };
	        iDcount = $(this).attr("data-count");
	        if(iDcount == null || iDcount == "")
	        	{
	        	  iDcount = "1";
	        	}
	       n33 =  $('#nDvParent' + iDcount).width() * 0.33;
	       n66 =  $('#nDvParent' + iDcount).width() * 0.66;
	       n99 =  $('#nDvParent' + iDcount).width() * 0.99;
	    }); 
	    $(this).bind('touchmove', function(event) { 
	    	event.preventDefault();
	    	event.stopPropagation();
	    	var e = event.originalEvent; 
	    	touchleft = e.touches[0].pageX - offset.x;
	    	if(touchleft < n99 && touchleft > 0)
	    	{
		    	 $(this).css("left" , touchleft);
		    	 $(this).css("z-index" , "3");
		    	 $('#scaleHover' + iDcount).css("width",touchleft );
		    	 $('#scaleHover' + iDcount).css("height",scaleHoverHeight);
	    	}
	    }); 
	    $(this).bind('touchend', function(event) { 
	    	
	        if(touchleft < 0)
	        {
	        	 $(this).css("left" , "0%");
      		 	 $('#scaleHover' + iDcount).css("width","0px" );
   	    	 	 $('#scaleHover' + iDcount).css("height","0px");
   	    	 	 $('#hdnScale' +iDcount).val("U");
   	    	     scaleLeft = "0%";
	        }
	    	if(touchleft > 0 && touchleft < n33)
	        {
	        	  var midLevel = n33 / 2 ;
	        	  if(touchleft > midLevel)
	        	  {
	        		  $(this).css("left" , "33%");
	        		  $('#scaleHover' +iDcount ).css("width","33%" );
	     	    	  $('#scaleHover' + iDcount).css("height",scaleHoverHeight);
	     	    	  $('#hdnScale' +iDcount).val("M");
	     	    	  scaleLeft = "33%";
	        	  }
	        	  else
	        	  {
	        		  $(this).css("left" , "0%");
	        		  $('#scaleHover' + iDcount).css("width","0px" );
	     	    	  $('#scaleHover' + iDcount).css("height","0px");
	     	    	  $('#hdnScale' +iDcount).val("U");
	     	    	  scaleLeft = "0%";
	        	  }
	        }
	    	if(touchleft > n33 && touchleft < n66)
	    	{
	    		 var midLevel = n33 / 2 ;
	    		 midLevel = n33 + midLevel;
	    		 if(touchleft > midLevel)
	        	  {
	        		  $(this).css("left" , "66%");
	        		  $('#scaleHover' + iDcount).css("width","66%");
	     	    	  $('#scaleHover' + iDcount).css("height",scaleHoverHeight);
	     	    	  $('#hdnScale' +iDcount).val("O");
	     	    	  scaleLeft = "66%";
	        	  }
	        	  else
	        	  {
	        		  $(this).css("left" , "33%");
	        		  $('#scaleHover' + iDcount).css("width","33%" );
	     	    	  $('#scaleHover' + iDcount).css("height",scaleHoverHeight); 
	     	    	  $('#hdnScale' +iDcount).val("M");
	     	    	  scaleLeft = "33%"; 
	        	  } 
	    	}
	    	if(touchleft > n66 && touchleft < n99)
	    	{
	    		 var midLevel = n33 / 2 ;
	    		 midLevel = n33*2 + midLevel;
	    		 if(touchleft > midLevel)
	        	  {
	        		  $(this).css("left" , "97.5%");
	        		  $('#scaleHover' + iDcount).css("width","99%" );
	     	    	  $('#scaleHover' + iDcount).css("height",scaleHoverHeight);
	     	    	  $('#hdnScale' +iDcount).val("S");
	     	    	   scaleLeft = "98%";
	        	  }
	        	  else
	        	  {
	        		  $(this).css("left" , "66%");
	        		  $('#scaleHover' + iDcount).css("width","66%" );
	     	    	  $('#scaleHover' + iDcount).css("height",scaleHoverHeight);
	     	    	  $('#hdnScale' +iDcount).val("O");
	     	    	  scaleLeft = "66%";
	        	  } 
	    	}
	    	if(touchleft > n99)
	    	{
	    		 $(this).css("left" , "97.5%");
       		     $('#scaleHover' + iDcount).css("width","99%" );
    	    	 $('#scaleHover' + iDcount).css("height",scaleHoverHeight);
    	    	 $('#hdnScale' +iDcount).val("S");
    	    	 scaleLeft = "98%";
	    	}
	    	$("[data-map = '" + iDcount + "']").each(function(index, value) {  
	        	$(this).removeClass("dvSliderLabelActive").addClass("dvSliderLabel");
	    		if($(this).attr("data-left") == scaleLeft)
	    		{
	    			//$(this).css("color","#125570");
	    			$(this).removeClass("dvSliderLabel").addClass("dvSliderLabelActive");
	    		}
	    	});
	    	
	    });
	    
	    return this; 
	}; 
	//---------slider functionality ends---------------
	//Setting patient DOB and current server date
	var patDOB_str = $("#patientDOB").val();
	patDOB = StringToDate(patDOB_str);
	//alert(patDOB);
	var today_str = $("#today").val();
	today = StringToDate(today_str);
	//alert(today);
});//document.ready ends

// the function gets called when the user clicks the slider control
function sliderControlClick(e,obj,count,bScaleHover,bPopulateCombo,left,severity,hypSensitivity)
{
	$('#Round' + count).css("left" , left);
	if(bScaleHover)
	{
		$('#scaleHover' + count).css("width",left );
		$('#scaleHover' + count).css("height",scaleHoverHeight); 
		$('#hdnScale' +count).val(severity);
	}
	if(bPopulateCombo)
	{
	    $('#hdnHypSensitivity').val(hypSensitivity);
	    clearDetails("HYP");
		populateEventTypeCombo();
		
	}
    $("[data-map = '" + count + "']").each(function(index, value) {  
    	$(this).removeClass("dvSliderLabelActive").addClass("dvSliderLabel");
		if($(this).attr("data-left") == left)
		{
			//$(this).css("color","#125570");
			$(this).removeClass("dvSliderLabel").addClass("dvSliderLabelActive");
		}
	});
}
function showReactionBubble()
{
	if(dvReactionObj != null && bRB)
	{
		calculateBubblePosition();
	}
}
function showErrorReactionBubble()
{
	if(dvErrorReactionObj != null && bEB)
	{
		calculateErrorBubblePosition();
	}
}
function calculateBubblePosition() //the function is used show the bubble above or below the remove reaction icon
{
	if(dvReactionObj != null )
	{
		//var CSHFheight = $('#allergyHeader').height();
		 
		offset = $(dvReactionObj).offset();
		winWidth = $(document).width();
		winHeight = $(document).height();
		//var controlPos = offset.top + $('#dvRemoveReaction').height() + 30;
		//alert(winHeight);
		//alert(controlPos);
		
		var bw;//$('#sfsarrowDown').css("border-width").split("px");
		var arrowBorderWidth = 10;
		if($('#sfsarrowDown').css("border-width") != null && $('#sfsarrowDown').css("border-width") != "")
		{
		  	bw = $('#sfsarrowDown').css("border-width").split("px");
		  	arrowBorderWidth = parseInt(bw[0]);
		}
		
	//	alert(arrowBorderWidth);
		
		if(winHeight > offset.top + $('#dvRemoveReaction').height() + 40  ) // will show the arrow upwards
		{
			arrowTop = offset.top + $(dvReactionObj).height() -arrowBorderWidth;//- 8;
			arrowLeft = offset.left + arrowBorderWidth/2;
			rTop = arrowTop + 2 * arrowBorderWidth;
			rLeft = arrowLeft - $('#dvRemoveReaction').width() + arrowBorderWidth;
			
			arrowLeft = (arrowLeft/winWidth) * 100 ;
			arrowTop = (arrowTop/winHeight) * 100 ;
			
			rTop = (rTop/winHeight) * 100 ;
			rLeft = (rLeft/winWidth) * 100 ;
			
			arrowLeft = arrowLeft + "%";
			arrowTop = arrowTop + "%";
			
			rTop = rTop + "%";
			rLeft = rLeft + "%";
			$('#sfsarrowDown').css("display" , "none");
			$('#sfsarrowUp').css("left" , arrowLeft);
			$('#sfsarrowUp').css("top" , arrowTop);
			$('#sfsarrowUp').css("z-index" , "1");
			$('#sfsarrowUp').css("display" , "block");
			
			
			$('#dvRemoveReaction').css("left" , rLeft);
			$('#dvRemoveReaction').css("top" , rTop);
			$('#dvRemoveReaction').css("z-index" , "1");
			$('#dvRemoveReaction').css("display" , "block");
		}
		else
		{
			//alert("hi");
			arrowTop = offset.top - $(dvReactionObj).height() ;
			arrowTop = arrowTop + arrowBorderWidth;
			arrowLeft = offset.left + arrowBorderWidth/2;
			
			rTop = arrowTop - 35;
			rLeft = arrowLeft - $('#dvRemoveReaction').width() +  arrowBorderWidth;
			
			arrowLeft = (arrowLeft/winWidth) * 100 ;
			arrowTop = (arrowTop/winHeight) * 100 ;
			
			rTop = (rTop/winHeight) * 100 ;
			rLeft = (rLeft/winWidth) * 100 ;
			
			arrowLeft = arrowLeft + "%";
			arrowTop = arrowTop + "%";
			
			rTop = rTop + "%";
			rLeft = rLeft + "%";
			
			$('#sfsarrowUp').css("display" , "none");
			$('#sfsarrowDown').css("left" , arrowLeft);
			$('#sfsarrowDown').css("top" , arrowTop);
			$('#sfsarrowDown').css("z-index" , "1");
			$('#sfsarrowDown').css("display" , "block");
			
			$('#dvRemoveReaction').css("left" , rLeft);
			$('#dvRemoveReaction').css("top" , rTop);
			$('#dvRemoveReaction').css("z-index" , "1");
			$('#dvRemoveReaction').css("display" , "block");
			
		}
	}
}


function calculateErrorBubblePosition() //the function is used show the bubble above or below the mark reaction as error icon
{
	if(dvErrorReactionObj != null )
	{
		//var CSHFheight = $('#allergyHeader').height();
		 
		offset = $(dvErrorReactionObj).offset();
		winWidth = $(document).width();
		winHeight = $(document).height();
		//var controlPos = offset.top + $('#dvRemoveReaction').height() + 30;
		//alert(winHeight);
		//alert(controlPos);
		
		var bw;//$('#sfsarrowDown').css("border-width").split("px");
		var arrowBorderWidth = 10;
		if($('#sfsarrowDownError').css("border-width") != null && $('#sfsarrowDownError').css("border-width") != "")
		{
		  	bw = $('#sfsarrowDownError').css("border-width").split("px");
		  	arrowBorderWidth = parseInt(bw[0]);
		}
		
	//	alert(arrowBorderWidth);
		
		if(winHeight > offset.top + $('#dvMarkAsError').height() + 40  ) // will show the arrow upwards
		{
			arrowTop = offset.top + $(dvErrorReactionObj).height() -arrowBorderWidth;//- 8;
			arrowLeft = offset.left + arrowBorderWidth/2;
			rTop = arrowTop + 2 * arrowBorderWidth;
			rLeft = arrowLeft - $('#dvMarkAsError').width() + arrowBorderWidth;
			
			arrowLeft = (arrowLeft/winWidth) * 100 ;
			arrowTop = (arrowTop/winHeight) * 100 ;
			
			rTop = (rTop/winHeight) * 100 ;
			rLeft = (rLeft/winWidth) * 100 ;
			
			arrowLeft = arrowLeft + "%";
			arrowTop = arrowTop + "%";
			
			rTop = rTop + "%";
			rLeft = rLeft + "%";
			$('#sfsarrowDownError').css("display" , "none");
			$('#sfsarrowUpError').css("left" , arrowLeft);
			$('#sfsarrowUpError').css("top" , arrowTop);
			$('#sfsarrowUpError').css("z-index" , "1");
			$('#sfsarrowUpError').css("display" , "block");
			
			
			$('#dvMarkAsError').css("left" , rLeft);
			$('#dvMarkAsError').css("top" , rTop);
			$('#dvMarkAsError').css("z-index" , "1");
			$('#dvMarkAsError').css("display" , "block");
		}
		else
		{
			//alert("hi");
			arrowTop = offset.top - $(dvErrorReactionObj).height() ;
			arrowTop = arrowTop + arrowBorderWidth;
			arrowLeft = offset.left + arrowBorderWidth/2;
			
			rTop = arrowTop - 35;
			rLeft = arrowLeft - $('#dvMarkAsError').width() +  arrowBorderWidth;
			
			arrowLeft = (arrowLeft/winWidth) * 100 ;
			arrowTop = (arrowTop/winHeight) * 100 ;
			
			rTop = (rTop/winHeight) * 100 ;
			rLeft = (rLeft/winWidth) * 100 ;
			
			arrowLeft = arrowLeft + "%";
			arrowTop = arrowTop + "%";
			
			rTop = rTop + "%";
			rLeft = rLeft + "%";
			
			$('#sfsarrowUpError').css("display" , "none");
			$('#sfsarrowDownError').css("left" , arrowLeft);
			$('#sfsarrowDownError').css("top" , arrowTop);
			$('#sfsarrowDownError').css("z-index" , "1");
			$('#sfsarrowDownError').css("display" , "block");
			
			$('#dvMarkAsError').css("left" , rLeft);
			$('#dvMarkAsError').css("top" , rTop);
			$('#dvMarkAsError').css("z-index" , "1");
			$('#dvMarkAsError').css("display" , "block");
			
		}
	}
}
/*
 * This function is used to show the removeReaction bubble in the page.
 * RemoveReaction bubble gets called when the user clicks circular button place next to reaction items
 */
function showRemoveReactionBubble(obj)
{
	//$('#ReactionContainer1').css("display" , "none");
	//offset = $(obj).offset();
	if(dvReactionObj != null) 
	{
		//$(dvReactionObj).html("-");	
		$(dvReactionObj).removeClass("removeReactionActTheme").addClass("removeReactionTheme");//to change the image of the previously selected remove icon
	}
	dvReactionObj = obj; // assigning the selected reaction html item object to the global variable
	//$(dvReactionObj).html("|");
	$(dvReactionObj).removeClass("removeReactionTheme").addClass("removeReactionActTheme");
	bRB = true;
	showReactionBubble();
	
}

/*
 * This function is used to show the mark as error bubble in the page.
 * error bubble gets called when the user clicks circular button place next to reaction items
 */
function showMarkAsErrorBubble(obj)
{
	if(dvErrorReactionObj != null) 
	{
		//$(dvReactionObj).html("-");	
		$(dvErrorReactionObj).removeClass("removeReactionActTheme").addClass("removeReactionTheme");//to change the image of the previously selected remove icon
	}
	var isError = $(obj).attr("data-error");
	if(isError == "N" ){
		dvErrorReactionObj = obj; // assigning the selected reaction html item object to the global variable
		//$(dvErrorReactionObj).html("|");
		$(dvErrorReactionObj).removeClass("removeReactionTheme").addClass("removeReactionActTheme");
		bEB = true;
		showErrorReactionBubble();
	}
	else if(isError == "Y"){
		unmarkErrorReaction(obj);
	}
}


function deleteReaction(reactionObj)
{
	var reactionId;
	var reactionCode;
	var count;
	if(dvReactionObj != null)
	{
		reactionContainerId = $(dvReactionObj).attr("data-containerID");
		count = $(dvReactionObj).attr("data-Id");
		count = parseInt(count);
		var hdnReactionCode = $("#reactionCode" + count).val();
		if(arrReactionCode != null && arrReactionCode.length > 0)
		{
			arrReactionCode.splice($.inArray(hdnReactionCode, arrReactionCode),1);	
		}
		if(arrReactionId != null && arrReactionId.length > 0)
		{
			arrReactionId.splice($.inArray(count, arrReactionId),1);
		}
		$("#"  + reactionContainerId).remove();
	    hideReactionBubble();
		bRB = false;
		dvReactionObj = null;
		scrollRefresh();
	}
}
function errorReaction(bubbleObj)
{
	
	var id;
	if(dvErrorReactionObj != null)
	{

		id = $(dvErrorReactionObj).attr("data-id");
		id = parseInt(id);

		if(arrErrorReactionId != null)
		{
			markErrorCount = arrErrorReactionId.push(id);
		}
	
	    hideErrorReactionBubble();
		bEB = false;
		//$(dvErrorReactionObj).html("-");
		$(dvErrorReactionObj).removeClass("removeReactionActTheme").addClass("removeReactionTheme");
		$(dvErrorReactionObj).attr("data-error","Y");
		$(dvErrorReactionObj).removeClass("removeReactionTheme").addClass("errorReactionTheme");
		dvErrorReactionObj = null;
	}
}
function unmarkErrorReaction(reactionObj)
{
	
	var id;
	id = $(reactionObj).attr("data-id");
	id = parseInt(id);
	$(reactionObj).removeClass("errorReactionTheme").addClass("removeReactionTheme");
	if(arrErrorReactionId != null)
	{
		arrErrorReactionId.splice($.inArray(id, arrErrorReactionId),1);
	}
	$(reactionObj).attr("data-error","N");
}
/*
 * To populate event type combo based on HyperSensitivity value
 */
function populateEventTypeCombo()
{
	var xmlhttp;
	var sendString = "eventTypeIndicator=" + $('#hdnHypSensitivity').val();
	var path = $('#hdnPath').val() + "/chartsummary/RecordAllergyView";
	if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp = new XMLHttpRequest();
	} else {// code for IE6, IE5
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			var data1 = null;
			var eventValue = xmlhttp.responseText;
			if(eventValue != null && eventValue != "")
			{
				eventValue = eventValue.replace("'", "\'");
				data1 = JSON.parse(eventValue);
				$("#cmbEventType").kendoComboBox({
					filter:"startswith",
					dataTextField: "eventTypeDescription",
			        dataValueField: "eventTypeCode",
			        dataSource: data1,
			        change: function(e) {
			        	clearDetails("EVNT");
	                  	$('#hdnEventTypeCode').val(this.value());
	                	$('#hdnEventTypeCodeValue').val(this.value());
		                	if(this.value() == "DA") // if the value is DA then show causative substance as a look up
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
        		
			}
		}//if
	}
	xmlhttp.open("POST", path, true);
	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xmlhttp.send(sendString);
}
function showCaSfs()
{
	
	var EI = $('#hdnHypSensitivity').val();
	var EC = $('#hdnEventTypeCode').val();//document.getElementById("hdnEventTypeCode").value;
	var AT = $('#hdnAllergenCode').val();
	if(AT != null && AT != "")//launches the causative substance only if allegen is selected
	{
		showMezzaineWindow();
		$('#sfs').css("display" , "block");
		$("#dvMez").data("popid","sfs");
		var path = $('#hdnPath').val() + "/chartsummary/AllergySfs?EC=" + EC + "&EI=" + EI + "&hdnSfsType=2&title=Causative Substance&AT=" + AT;
		document.getElementById("hdnSfsType").value = "2";
		document.getElementById("sfsFrame").src = path;
		bEventTypeSfs = true;
	}
}
function showMezzaineWindow()
{
	$('#dvMez').css("display","block");
	setTimeout(function() {
		$("#dvMez").on("click",closeMezzaineWindow);
	}, 500);
}
function closeMezzaineWindow()
{
	var popid = $("#dvMez").data("popid");
	$("#"+popid).hide();
	$("#dvMez").data("popid","");
	$('#dvMez').css("display","none");
	$("#dvMez").off();
}
function showReactionSfs()
{
	
	var EI = $('#hdnHypSensitivity').val();
	var EC = $('#hdnEventTypeCode').val();
	var AT = $('#hdnAllergenCode').val();
	var SC = $('#txtReactionSearch').val();
	if(AT != null && AT != "") // lauches the Reaction sfs only if allergen is selected
	{
		showMezzaineWindow();
		$('#sfs').css("display" , "block");
		$("#dvMez").data("popid","sfs");
		var path = $('#hdnPath').val() + "/chartsummary/AllergySfs?EC=" + EC + "&EI=" + EI + "&hdnSfsType=3&title=Add Reaction&AT=" + AT;
		if($.trim(SC).length > 0){
			path = path + "&SC=" + SC + "&hdnPostBack=true";
		}
		document.getElementById("sfsFrame").src = path;
		bEventTypeSfs = true;
	}
}
function showAllergenSfs()
{
	
	var EI = $('#hdnHypSensitivity').val();
	var EC = $('#hdnEventTypeCode').val();
	if(EC != null && EC != "")    // lauches the allergen sfs onnly if eventtype is selected.
	{
		showMezzaineWindow();
		$("#dvMez").data("popid","sfs");
		$('#sfs').css("display" , "block");
		var path = $('#hdnPath').val() + "/chartsummary/AllergySfs?EC=" + EC + "&EI=" + EI + "&hdnSfsType=1&title=Allergen";
		//$('#sfsFrame').attr("src" , path);
		document.getElementById("hdnSfsType").value = "1";
		document.getElementById("sfsFrame").src = path;
		bEventTypeSfs = true;
	}
}
function getSfsDetails(sfsDataArr)
{
	//var sfsDataArr = document.getElementById("sfsFrame").contentWindow.getSfsDataArray();
	closeMezzaineWindow();
	$('#sfs').css("display" , "none");
	bEventTypeSfs = false;
	if(sfsDataArr != null && sfsDataArr.length > 0)
	{
		if(sfsDataArr[0].sfsType == "1")
		{
			$('#hdnAllergenCode').val(sfsDataArr[0].code);
			$('#txtAllergen').val(sfsDataArr[0].desc);
			clearDetails("ALLERGEN");
		}
		if(sfsDataArr[0].sfsType == "2")
		{
			$('#hdnCACode').val(sfsDataArr[0].code);
			$('#txtCAS').val(sfsDataArr[0].desc);
		}
	}
}
/*
 * This function gets called from the page ReactionSFS.jsp when the user clicks the 'Select button'. The input parameter hold 
the values selected from ReactionSFS.jsp.The values are passed to SfsGson.jsp(ajax) to construct the html for adding reaction in this page.
 */
function getReactionSfsDetails(sfsDataArr)
{
	closeMezzaineWindow();
	$('#sfs').css("display" , "none");
	bEventTypeSfs = false;
	if(sfsDataArr != null && sfsDataArr.length > 0)
	{
		var i =0;
		var arrLength = sfsDataArr.length;
		var myString = JSON.stringify(sfsDataArr);
		var xmlhttp;
		var sendString = "RC=" + reactionCount+"&json=" + myString;
		var path = document.getElementById("hdnPath").value + "/eIPAD/jsp/chartwidgets/SfsGson.jsp";
		if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
				xmlhttp = new XMLHttpRequest();
		} else {// code for IE6, IE5
				xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.open("POST", path, true);
		xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xmlhttp.send(sendString);
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				var respText = xmlhttp.responseText;
				//alert(respText);
				$('#dvRContent').append(respText);
				scrollRefresh();
				reactionCount = reactionCount + sfsDataArr.length; // count to assign the id for elements returned by reaction sfs
				$('#hdnReactionCount').val(reactionCount);
				//var j = 0;
				for(;reactionIds< reactionCount; reactionIds++) // adding all the selected reaction id in a array
				{
					arrReactionId.push(reactionIds);	
				}
				reactionIds = reactionCount;
			}
		}
		for(i =0 ;i < arrLength; i ++)
		{
			arrReactionCode.push(sfsDataArr[i].code);
		}
	}
}
function returnReactionCode()
{
	return arrReactionCode;
}
function removeAllReactions()
{
	$(".reactionItemsContainer").each(function(index, value) {  
		$(this).remove();
	});
	scrollRefresh();
	//reseting all the values so that new values can be assigned when required.
	arrReactionCode = null;
	arrReactionCode = [];
	arrReactionId = null;
	arrReactionId = [];
	reactionCount = 0;
	reactionIds = 0;
}
function clearDetails(fromElement)
{
	if(fromElement == "HYP")
	{
	  	$('#hdnEventTypeCode').val("");
		$('#hdnEventTypeCodeValue').val("");
		$("#cmbEventType").data("kendoComboBox").value("");
		$("#cmbEventType").data("kendoComboBox").text("");
		$('#hdnAllergenCode').val("");
		$('#txtAllergen').val("");
		$('#hdnCACode').val("");
		$('#txtCAS').val("");
		$('#txtCA').val("");
		$('#dvCA1').css("display" , "block");
		$('#dvCA2').css("display" , "none");
		scrollRefresh();
	}
	if(fromElement == "EVNT")
	{
		$('#hdnAllergenCode').val("");
		$('#txtAllergen').val("");
		$('#hdnCACode').val("");
		$('#txtCAS').val("");
		$('#txtCA').val("");
		$('#dvCA1').css("display" , "block");
		$('#dvCA2').css("display" , "none");
		scrollRefresh();
	}
	if(fromElement == "EVNTCOMBO")
	{
		$('#hdnAllergenCode').val("");
		$('#txtAllergen').val("");
		$('#hdnCACode').val("");
		$('#txtCAS').val("");
		//$('#txtCA').val("");
		$('#dvCA1').css("display" , "block");
		$('#dvCA2').css("display" , "none");
		scrollRefresh();
	}
	if(fromElement == "ALLERGEN")
	{
		$('#hdnCACode').val("");
		$('#txtCAS').val("");
		$('#txtCA').val("");
	}
	removeAllReactions();
}
function setEstDurn(objCheckBox)
{
	if(objCheckBox.checked)
	{
		$('#hdnEstimatedDuration').val("Y");
	}
	else
	{
		$('#hdnEstimatedDuration').val("N");	
	}
}
function sfsCancel()
{
	closeMezzaineWindow();
	$('#sfs').css("display","none");
	document.getElementById("sfsFrame").src = "";
	
}
