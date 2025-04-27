<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@page import="java.util.ResourceBundle"%>
<%@page import="java.util.*"%>
<%@page import="eIPAD.chartsummary.common.response.*"%>
<%@page import="eIPAD.chartsummary.vitals.response.*"%>
<%@page import="eIPAD.chartsummary.vitals.healthobject.*"%>
<%@ page import="eIPAD.chartsummary.common.healthobject.PatContext"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<%

Locale appLocale;
String locale = "en";
String patientDOB = "";
String patientId = "";
String patientClass = "";
String chartId = "";
int nLoopCount1 = 0;

if (session.getAttribute("LOCALE") != null
		&& !session.getAttribute("LOCALE").equals(""))
	appLocale = new Locale((String) session.getAttribute("LOCALE"));
else
	appLocale = new Locale("en");
ResourceBundle csResBundle = ResourceBundle.getBundle(
		"eIPAD.chartsummary.common.resourcebundle.cslabels",
		appLocale);

VitalsPanelResponse oVitalsPanelRespone = null;
if(request.getAttribute("VitalsPanelResponse") != null)
{
	oVitalsPanelRespone = (VitalsPanelResponse)request.getAttribute("VitalsPanelResponse");
}
;

PatContext oPatContext = null;
if(session.getAttribute("PatientContext") != null)
{
	oPatContext = (PatContext)session.getAttribute("PatientContext");
	 
}
if(oPatContext != null)
{
	patientDOB = oPatContext.getDob();
	//locale = oPatContext.getLocale();
	patientId = oPatContext.getPatientId();
	patientClass = oPatContext.getPatientClass();
	
	
}
//setting current date in dd/mm/yyyy hh:mm
java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm");
String today = dateFormat.format(new java.util.Date());
%>
<!DOCTYPE html>
<html>
<head>

<title>Record Vitals</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<link rel="stylesheet" href="${path}/eIPAD/jquery.mobile-1.0.1.min.css" />
<link rel="stylesheet" href="${path}/eIPAD/css/kendo.common.min.css" />
<link rel="stylesheet" href="${path}/eIPAD/css/kendo.default.min.css" />
<script src="${path}/eIPAD/jquery-1.9.1.js"></script> 
<script src="${path}/eIPAD/kendo.web.min.js"></script>
<script src="${path}/eIPAD/console.js"></script>
<%
	if(appLocale != null && appLocale.getLanguage() != null && !appLocale.getLanguage().equalsIgnoreCase("en"))
	{
		locale = appLocale.getLanguage();
		%>
			<script src="${path}/eIPAD/cultures/kendo.culture.<%= appLocale.getLanguage()%>.min.js"></script>
		<% 
	}
%>

<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
<link rel="stylesheet" href="${path}/eIPAD/css/iPADNew.css" />
<link rel="stylesheet" href="${path}/eIPAD/css/iPADThemeA.css" />
<script type="application/javascript" src="${path}/eIPAD/js/iscroll.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<style>
.buttonContainer 
	{
		margin-right: 10px;
	}
	.dvControlTable
	{
		display : table;
		width : 100%;
		min-height : 65px;
		height: auto;
	}
	.dvControlRow
	{
		display : table-row;
		width : 100%;
		min-height : 65px;
		height: auto;
	}
	.Cell1
	{
		display : table-cell;
		width : 30%;
		min-height : 65px;
		height: auto;
		vertical-align : middle;
		text-align : right;
		
	}
	.Cell2
	{
		display : table-cell;
		width : 57%;
		min-height : 65px;
		height: auto;
		vertical-align : middle;
		text-align : left;
	
	}
	.cell3
	{
		display : table-cell;
		width : 15%;
		min-height :65px;
		height : auto;
		vertical-align : middle;
		text-align :center;
	}
	.dateCell
	{
		display : table-cell;
		width : 50%;
		min-height : 40px;
		height: auto;
		vertical-align : middle;
		text-align : right;
	}
	.dateCell2
	{
		display : table-cell;
		width : 70%;
		min-height : 65px;
		height: auto;
		vertical-align : middle;
		text-align : left;
	}
	.dvControlLabel
	{
		position : relative;
		margin-right : 10px;
		font-family :Arial;
        font-size : 13px;
        font-weight : bold;
        color : #44484a;	
	}
	.dvRange
	{
	position : relative;
	font-family : Arial;
	font-size : 13px;
	font-weight :bold;
	}
	.dvUnit
	{
	position : relative;
	font-family : Arial;
	font-size : 10px;
	}
	 .divEvent1
	 {
	   position:relative;
	   height : 40px;
	   width : 100%;
	   margin-left : 10px;
	   vertical-align : middle;
	   text-align : center;
	   
	 }
	  .divEvent2
	 {
	   position:relative;
	   height : 40px;
	   width : 575px;
	   margin-left : 10px;
	   vertical-align : middle;
	   text-align : left;
	   
	 }
	 .chkChart
	{
	  margin-top : 10px;
	  margin-left : 5px;
	  width : 20px;
	  height : 20px;
	}
</style>
<script>
document.addEventListener('touchmove', function (e) { e.preventDefault(); }, false);
document.addEventListener('DOMContentLoaded', vitalsScroll, false);
//document.addEventListener('focusout', function(e) {setRecordVitalsDimensions();});


var vitalsRecordScroll;
var screenOrienttation = "landscape";
var bAllcontrolsLoaded = false;

function changeOrientation(orient, EMHFheight)
{
	var CSHFheight = $('#allergyHeader').height();
   	HFheight = EMHFheight;
   	screenOrienttation = orient;
   		 
   	var content_height = parent.getTotalPageDivHeight() - EMHFheight - CSHFheight-6 ;
   	document.getElementById("divcnt").style.height = content_height+"px";
   //	$('#header1').focus();
   	scrollRefresh();
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
	}	
}
function scrollRefresh()
{
 	if(vitalsRecordScroll != null)
 		vitalsRecordScroll.refresh();
}
function cancelTransaction(){
	var path = document.getElementById("hdnPath").value + "/mobile/chartsummary/ChartWidgetsView";
	window.parent.document.getElementById('ChartSummaryIframe').src = path;
}

function vitalsScroll() {
		 setTimeout(function () {
			 vitalsRecordScroll = new iScroll('divcnt', {
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
function valueChange(obj,index)
{
	  var sHidden = "comp_" + index;
	  document.getElementById(sHidden).value = obj.value;
	 // alert( document.getElementById(sHidden).value);
	  
	  
}
function setComboValue(objcombo,rownumber)
{
	/*
	  var sHidden = "listItemValue" + rownumber;
	  var sCompValue = "comp_" + rownumber;
	  document.getElementById(sHidden).value = objcombo.options[objcombo.selectedIndex].text;
	  document.getElementById(sCompValue).value = objcombo.value;
	  */

}

$(document).ready(function () {
	setRecordVitalsDimensions();
});
function setRecordVitalsDimensions()
{
	   parent.setOnLoadContentPaneHeight();
	   bAllcontrolsLoaded = true;
}
function setScreen()
{
	alert(window.event.keyCode);
	alert(window.event);
    parent.myOrientResizeFunction();
	parent.setOnLoadContentPaneHeight();
}
function allowValidNumberLocal3(fld,e){
	var count=fld.value.length;//ok
    var whichCode = (window.Event) ? e.which : e.keyCode;//ok
	//var whichCode = (window.Event) ? e.which : e.keyCode;
	if (whichCode == 13) return false; 
	 else return true;
}
function allowValidNumberLocal2(fld, e, maxInt, deci)
{

    var count=fld.value.length;//ok
    var whichCode = (window.Event) ? e.which : e.keyCode;//ok
   // alert(whichCode);
    if(whichCode == 8)  
	{
	  	  return true;
	}
	var minusOccurance = fld.value.indexOf('-');
	var plusOccurance = fld.value.indexOf('+');
	if(minusOccurance != -1 || plusOccurance != -1)
	{
		maxInt++;
		fld.setAttribute("maxLength",maxInt);
	}
	else
	{
		fld.setAttribute("maxLength",maxInt);
	}
	if((whichCode == 45 && count>0) || (whichCode == 43 && count>0))
	{
		return false
	}

    if(count >= maxInt)
    {
        
		return false;
    }
	
	//you donot require this just var strCheck = '.0123456789' for deci > 0
	//strCheck = '0123456789' for deci=0
	      var strCheck = '.0123456789-+';

//	alert(e.getKeyCode())
    if (parseInt(deci)==0)//For Only Nos 0 - 9
        strCheck = '0123456789-+';

    var fldvalue=fld.value;
  //g  var whichCode = (window.Event) ? e.which : e.keyCode;
  // if (whichCode == 13) return true;  // Enter     commented by Channaveer B
    var pointCount=0;

    for(var i=0;i<fldvalue.length;i++)
    {
        if(fldvalue.charAt(i)=='.') pointCount++;
    }

    if (pointCount>0 && whichCode == 46) return false;

    var fldValue    =   fld.value;
    var dotIndex    =   fldValue.indexOf(".");
    var fldLength   =   fldValue.length;
	var count = 0;
    if(dotIndex!=-1){
       /* if( fldLength > (parseInt(dotIndex)+parseInt(deci)) )
			return false;*/
	}


	key = String.fromCharCode(whichCode);  // Get key value from key code
  
	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	else if((key == "-" && fldValue.indexOf(key) != -1) || (key == "+" && fldValue.indexOf(key) != -1) )
	{
		if(fldValue.indexOf(key) != 1 )
			return false
	}
    return true;
}
function CheckForNumber1(val) {
	  
	return true;
}
function validateNumber(obj,numdigitsdec,mindigits,minValue,maxValue,lowlevel,highlevel,rownumber,critlow,crithigh,cricLowStr,cricHighStr,lowStr,highStr)
{
	  tempField = obj;
	  var val = obj.value;
	  var msrId = $(obj).attr('data-discMsrId');
	  //alert(msrId);
		if(isNaN(val))
		{
			obj.value = "";
			return;
		}
		if(val.indexOf(".") != -1)
		{
			var str = val.substring(val.indexOf(".")+1, val.length);
			
			if (parseInt(numdigitsdec) != 0 && (str.length) > parseInt(numdigitsdec) )
			{	
				var msg = "Only " + numdigitsdec + " decimal digit(s) allowed";//getMessage('VARIABLE_DEC_DIGIT','CA');
				//msg = msg.replace('@',numdigitsdec);
				alert(msg);
				obj.value = '';
				//obj.focus(); // this will work only in IE
				//setTimeout("tempField.focus();",10);
				//setTimeout(function(){obj.focus();},2);
				return;
			}
		}
		if(val != null && val != '' && minValue != '' && maxValue != '')
		{
			if(parseFloat(minValue) > val || parseFloat(maxValue) < val)
			{
				var msg = "The value of " + msrId + " should be between " +minValue + " and " + maxValue;//getMessage("MIN_MAX_VALUE_RANGE","CA");
				//msg =msg.replace('(1)',minValue);
				//msg =msg.replace('(2)',maxValue);
				//alert(msg);
				setWarningMessage(obj,msg);
				showWarningDialog(obj);
				obj.value='';
				//obj.select();
				//obj.focus();
				//setTimeout(function(){obj.focus();},2);

				return false;
			}

		}
		//--------
	    if(val != null && val != '')
		{
	    	var colorIndicator = ""
			if((lowlevel != '' && parseFloat(lowlevel) != 0) && (highlevel != '' &&  parseFloat(highlevel) != 0)   && (critlow != '' && parseFloat(critlow) != 0) &&  (crithigh != 0 && parseFloat(crithigh) != ''))
			{
				if(parseFloat(val) >= parseFloat(critlow) && parseFloat(val) < parseFloat(lowlevel))
					colorIndicator = lowStr;
				else if(parseFloat(val) > parseFloat(crithigh))
					colorIndicator = cricHighStr;
				else if(parseFloat(val) < parseFloat(critlow))
					colorIndicator = cricLowStr;
				else if(parseFloat(val) > parseFloat(highlevel) && parseFloat(val) <= parseFloat(crithigh))
					colorIndicator = highStr;
			}// end of if
			else
			{
				if((lowlevel != '' && parseFloat(lowlevel) != 0))
				{
					if((critlow != '' && parseFloat(critlow) != 0))
					{
						if(parseFloat(val) < parseFloat(critlow)) 
							colorIndicator = cricLowStr;
						else if((parseFloat(val) >= parseFloat(critlow)) && (parseFloat(val) < parseFloat(lowlevel))) 
							colorIndicator = lowStr;
					}
					else if(parseFloat(val) < parseFloat(lowlevel)) 
						colorIndicator = lowStr;
				}
	
				if((highlevel != '' &&  parseFloat(highlevel) != 0))
				{
					if((crithigh != '' && parseFloat(crithigh) != 0))
					{
						if(parseFloat(val) > parseFloat(crithigh)) 
							colorIndicator = cricHighStr;
						else if((parseFloat(val) <= parseFloat(crithigh)) && (parseFloat(val) > parseFloat(highlevel))) 
							colorIndicator = highStr;
					}
					else if(parseFloat(val) > parseFloat(highlevel)) 
						colorIndicator = highStr;
				}
			}// end of else
	        /*
			if(parent.ChartRecordingDetailFrame.document.ChartLayoutDetailForm != null)
			{
				var normal_abnormal_ind = eval("document.ChartLayoutDetailForm.normal_abnormal_ind_"+rownumber);
				normal_abnormal_ind.value=colorIndicator;
			}
			else
			{
				var normal_abnormal_ind = eval("document.chartRecordingAmendErrorForm.normal_abnormal_ind_"+rownumber);
				normal_abnormal_ind.value=colorIndicator ;
			}
	    	*/
	    	var normal_abnormal_ind = "normal_abnormal_ind_" +rownumber;
	    	//alert(normal_abnormal_ind);
	    	//alert(document.getElementById(normal_abnormal_ind));
	    	document.getElementById(normal_abnormal_ind).value = colorIndicator;
		}
		//--------
		if ( val != null && val != '')
		{
			var val1=val;
			if(eval(mindigits) != 0) {
				
				if(val1.indexOf("-")>=0)
				{
					val1 = val1.substr(val1.indexOf("-")+1,val1.length);
				}
				
				if(val1.indexOf(".")>=0)
				{
					val1 = val1.substr(0, val1.indexOf("."));
				}
				if(val1.length < eval(mindigits))  {
					var short_desc_alert;

				

					//var message_alert="Please enter minimum" + mindigits + " digits";//getMessage("MINIMUM_DIGITS","CA");
					var message_alert="Minimum number of digits for " + msrId + " must be " + mindigits;
					//message_alert=message_alert.replace('$',short_desc_alert.value);
					//alert(message_alert+' '+mindigits);	
					//alert(message_alert);
					setWarningMessage(obj,message_alert);
				    showWarningDialog(obj);
					obj.value='';
					//obj.focus();
					//setTimeout(function(){obj.focus();},2);
					//obj.select();
				}
			}
			if(!CheckForNumber1(val)) 
			{
				//obj.focus();
			}
			else
			{
			    var n = obj.value;
				if((n.indexOf(".")) >= 0)
				{
					if(numdigitsdec !=0 )  {
						var arr =  new Array();
						arr = n.split(".");
						var num = arr[0].length;
						var frac = arr[1].length;

		                if (frac > numdigitsdec )
						{
							var msg = "Decimal digits greate";//getMessage("VARIABLE_DEC_DIGIT","CA");
							//msg = msg.replace("@",numdigitsdec);
							//alert(msg);
							obj.value='';
							//obj.focus();
							//setTimeout(function(){obj.focus();},2);
						}
					}else {
						//alert("No decimal");
						obj.value='';
						//obj.focus();
						//setTimeout(function(){obj.focus();},2);
					}
				}

			}
		}
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
function evalCheckBox(objCheck,index)
{
	  var sHidden = "comp_" + index;
	 // alert(objCheck.checked);
	if(objCheck.checked==true)
		document.getElementById(sHidden).value = 'Y';
	   	else
	   	document.getElementById(sHidden).value ='';
	
	//alert(index);
	//alert(document.getElementById(sHidden).value);
}	
function validate()
{
	var mandatoryValPassed = true;
	
	$("[data-mandatory='Y']").each(function(index,field){
		//alert($(field).val());
		var type  = $(this).attr("data-type");
		var rowIndex = $(this).attr("data-rowIndex");
		//alert("type = " + type);
		//alert("rowIndex = " + rowIndex); 
		var cntrl = "comp_" + rowIndex
 	    var cntrlValue = document.getElementById(cntrl).value;
 	  //  alert(cntrlValue);
 	   var lCntrl = "listItemValue" + rowIndex;
 	   var lCntrlValue = document.getElementById(lCntrl).value;
 	   
 	   if(type == "L")
 	   {
 		// if(lCntrlValue != null && lCntrlValue != "------Select------" && lCntrlValue != "Select" && lCntrlValue.trim() != "")
 		//	alert(cntrlValue);
 		   if(cntrlValue != null && cntrlValue != "------Select------" && cntrlValue != "Select" && cntrlValue.trim() != "")	
 		  {
 			 $("#"+$(field).attr("id")+"_Label").css("color","black");
 	      }
 		  else
 			  {
 			    mandatoryValPassed = false;
 			    $("#"+$(field).attr("id")+"_Label").css("color","red");
 			  }
 	   }
 	  
 	  if(type == "C" || type == "E" || type == "D")
	   {
 		  /*
 		  if(type == "E")
 			  {
 			 		var datetimepicker = $(this).data("kendoDateTimePicker");
 			 		alert(datetimepicker.value());
 			  }
 		  */
		  if(cntrlValue != null && cntrlValue != "" && cntrlValue.trim() != "")
		  {
			  
			  $("#"+$(field).attr("id")+"_Label").css("color","black");
			  //alert("passed");
	      }
		  else
			  {
			   
			    mandatoryValPassed = false;
			   // alert($("#"+$(field).attr("id")+"_Label"));
			    $("#"+$(field).attr("id")+"_Label").css("color","red");
			    //alert("failed");
			  }
	   }
 	  
 	   
 	   var fieldValue = $(field).val();
 	   if(type != "C" && type != "L" && type != "E" && type != "D")
 	   {
 		  if(fieldValue == "" || fieldValue == null){ 
 				mandatoryValPassed = false;
 				$("#"+$(field).attr("id")+"_Label").css("color","red");
 			}
 			else{
 				$("#"+$(field).attr("id")+"_Label").css("color","black");
 			}
 	   }
		
	});
	if(mandatoryValPassed != true ){
		$("#MandatoryFields_Error").show();
		setTimeout(function(){
			$("#MandatoryFields_Error").hide();
		},5000);
		$("#MandatoryFields_Error").bind('click',function(){
			$(this).hide();
		});
	}
	else
		{
			document.getElementById("frmRecordVitals").submit();
		}
}
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
function checkVitalsDate(obj,cntrlIndex,fieldId,type)
{
	 	var sHidden = "comp_" + cntrlIndex;
	 	//alert($("#" + fieldId));
	 	var controlObject = $("#" + fieldId);
	    if(obj.value() != null)
	    	{
	    	    var today_str = $("#today").val();
	    	    var patDOB_str = $("#patientDOB").val();
	    	    var patDOB = StringToDate(patDOB_str);
	    	    var today_date = StringToDate(today_str);
	    	    if(obj.value() >= patDOB && obj.value() <= today_date)
	    	    	{
	    	    		if(type == "E")
	    	    			{
	    	    				document.getElementById(sHidden).value = DMYHMToString(obj.value());
	    	    			}
	    	    		if(type == "D")
	    	    			{
	    	    				document.getElementById(sHidden).value = DMYToString(obj.value());
	    	    			}
	    	    	}
	    	    else
	    	    	{
	    	    	    if(obj.value() > today_date)
	    	    	    	{
	    	    	    	 	var msg = "Value cannot be greater than today's date";
	 	    	    			setWarningMessage(controlObject,msg);
	 	    					showWarningDialog(controlObject); 
	    	    	    	}
	    	    	    if(obj.value() < patDOB)
	    	    	    	{
		    	    	    	var msg = "Value cannot be less than Patient's DOB";
	 	    	    			setWarningMessage(controlObject,msg);
	 	    					showWarningDialog(controlObject); 
	    	    	    	}
	    	    	    obj.value(null);
	    	    	    document.getElementById(sHidden).value = "";
	    	    	}
	    	}
	    else
	    	{
	    		var msg = "Invalid Date";
 				setWarningMessage(controlObject,msg);
				showWarningDialog(controlObject); 
	    	    obj.value(null);
	    	    document.getElementById(sHidden).value = "";
	    	}
}
function chkValidityOfTime(strfromTime)
{
	if(strfromTime.value != '')
	{
		strfromTimeVal = strfromTime.value;
		strTemp = strfromTimeVal.indexOf(":");
		if(strTemp == -1 || strTemp != 2){
			//alert("Invalid Time Format");
			var msg = "Invalid Time Format";
			setWarningMessage(strfromTime,msg);
			showWarningDialog(strfromTime); 
			//strfromTime.select();
			strfromTime.value = "";
			return false;
		}
		else
		{
			checkTimeForDetail(strfromTime);
		}
	}
}
function checkTimeForDetail(strfromTime)
{
	strfromTimeVal = strfromTime.value;
	strSplitTime = strfromTimeVal.split(":");
	hr = strSplitTime[0];
	min = strSplitTime[1];

	if(strfromTime.value.length !=5)
	{
		//alert("Invalid Time Format");
		var msg = "Invalid Time Format";
		setWarningMessage(strfromTime,msg);
		showWarningDialog(strfromTime); 
				//strfromTime.select();
				strfromTime.value = "";
		return false;
	}
	
	if(!(hr.charCodeAt(0) >= 48 && hr.charCodeAt(0) <=57 &&
		hr.charCodeAt(1) >= 48 && hr.charCodeAt(1) <=57 &&
		min.charCodeAt(0) >= 48 && min.charCodeAt(0) <=57 &&
		min.charCodeAt(1) >= 48 && min.charCodeAt(1) <=57  ))
		{
		    //alert("Invalid Time Format");
		    var msg = "Invalid Time Format";
		    setWarningMessage(strfromTime,msg);
			showWarningDialog(strfromTime); 
			//strfromTime.select();
			strfromTime.value = "";
			return false;
		}



	if(hr>23){
		//  alert("Invalid Hour");
		  var msg = "Invalid Hour";
		  setWarningMessage(strfromTime,msg);
		  showWarningDialog(strfromTime); 
		//strfromTime.select();
		strfromTime.value = "";
		return false;
	}
	if(min>59){
		 // alert("Invalid minute");
		  var msg = "Invalid minute";
		  setWarningMessage(strfromTime,msg);
		  showWarningDialog(strfromTime); 
		//strfromTime.select();
		strfromTime.value = "";
		return false;
	}
	return true;
}

</script>
</head>
<body>
	<div id="divParent" class="divParent" data-role="page" style="padding: 0px">
		<form name = "frmRecordVitals" id = "frmRecordVitals" style="width: 100%; height: 100%" method = "post" action="${path}/mobile/RecordVitals">
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
												<div class="allergyHeaderPageTitle ipHeaderPageTitleTheme" id  = "header1">Record Vitals</div>
											</div>
											<div class="AllergyCell" style="width: 1%">
												<div class="RecordAllergyTable">
													<div class="normalRow">
														<div class="AllergyCell"
															style="width: auto; text-align: right">
															<div class="buttonContainer">
																<div class="WidgetButtonTheme"
																	id="RecordAllergySubmitButton" onclick = "validate()">
																
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
						 <%
						 	if(oVitalsPanelRespone != null && oVitalsPanelRespone.isSuccessResponse() && !oVitalsPanelRespone.isEmptyDataResponse())
						 	{
						 		List<VitalsPanel> vitalsPanelList = null;
						 		vitalsPanelList = oVitalsPanelRespone.getListVitalsPanel();
						 		chartId = oVitalsPanelRespone.getChartId();
						 		//int nLoopCount1 = 0;
						 		if(vitalsPanelList != null && vitalsPanelList.size() > 0)
						 		{
						 			for(VitalsPanel oVitalsPanel : vitalsPanelList)
						 			{
						 				if(oVitalsPanel != null)//to print panel header
						 				{
						 					%>
						 					<div class="AllergyDetailsHeader AllergyDetailsHeaderTheme" data-role="none">
												<span class="spanAllergyDetailsHeader" data-role="none"><%= oVitalsPanel.getSectionDesc()%></span>
											</div>
						 					<% 
						 					
						 					List<VitalsConfig> vitalsConfigList = null;
						 					vitalsConfigList = oVitalsPanel.getVitalsConfigList();
						 					if(vitalsConfigList != null && vitalsConfigList.size() > 0)
						 					{
						 						for(VitalsConfig oVitalsConfig : vitalsConfigList)
						 						{
						 							if(oVitalsConfig != null)
						 							{
						 								 String maxSize = oVitalsConfig.getNumDigitsMax();
											    	     String minSize = oVitalsConfig.getNumDigitsMin();
											    	     String decSize =  oVitalsConfig.getNumDigitsDecimal();
											    	     String defaultValue = oVitalsConfig.getDefaultValue();
											    	     String minValue = oVitalsConfig.getMinValue();
											    	     String maxValue = oVitalsConfig.getMaxValue();
											    	     String num_dflt_result = oVitalsConfig.getNumDfltResult();
											    	     String defaultText = "";
											    	     String mandatory = oVitalsConfig.getMandatoryYN();
											    	    // mandatory = "Y";
											    	     String  normalInd = "";
											    	     if (maxSize.equals(""))
											   			 {
											   				 maxSize = "20";
											   			 }
											              // if(Integer.parseInt(maxSize)==0)
												   		 if(Float.parseFloat(maxSize)==0)
												         {
												                   maxSize = "20";
												         }
												   		String type = oVitalsConfig.getResultType();
												   	   // type = "T";
												   	    if(type != null && !type.equals("L") && !type.equals("C")) // to display text box and date control
												   	    {
												   	    	if(type.equals("N")||type.equals("I"))
												   	    	{
												   	    		normalInd = oVitalsConfig.getNormalIndicator();
												   	    		if(defaultValue != null && defaultValue.length() > Integer.parseInt(maxSize))
												   	    		{
												   	    		  defaultValue = "";
												   	    		}
												   	    	 
												   	    	   if(type.equals("I") )
											    	    	   {
											    	    		   decSize = "0"; 
											    	    	   }
												   	    	   %>
												   	    	   <div class="rowContainer" data-role="none" style="display: block">
												   	    		<div data-role = "none" class = "dvControlTable">
																 	<div data-role = "none" class = "dvControlRow">
																 		<div data-role = "none" class = "Cell1">
																 		<div data-role = "none" class = "dvControlLabel" id = "custom_<%=oVitalsConfig.getSectionId() %>_<%=oVitalsConfig.getDiscreteMeasureId() %>_Label"><%=oVitalsConfig.getDiscreteMeasureDesc() %> <%if(mandatory != null && mandatory.equals("Y")){ %> <font style="color: red">*</font> <%} %></div>
																 		</div>
																 		<div data-role = "none" class = "Cell2">
																 			<div data-role = "none" class="divEvent1 divEventTheme" >
																 				<div class="formValWarningTheme formValError" id = "custom_<%=oVitalsConfig.getSectionId() %>_<%=oVitalsConfig.getDiscreteMeasureId()%>_Warning" style="top: 45px; left: 0px; display: none">
																					<div class="formValErrorMsgTheme" id = "custom_<%=oVitalsConfig.getSectionId() %>_<%=oVitalsConfig.getDiscreteMeasureId()%>_WarningMsg">
																					</div>												
																				</div>
																 				<input  type="text" data-role="none" class="txtContent" style = "width:97%" data-type = "<%=type %>" data-rowIndex = "<%=nLoopCount1 %>" data-discMsrId = "<%=oVitalsConfig.getDiscreteMeasureDesc()%>" onchange = "valueChange(this,'<%=nLoopCount1 %>')" name = "custom_<%=oVitalsConfig.getSectionId() %>_<%=oVitalsConfig.getDiscreteMeasureId() %>" id = "custom_<%=oVitalsConfig.getSectionId() %>_<%=oVitalsConfig.getDiscreteMeasureId() %>"  data-mandatory = "<%=mandatory %>" value = "<%=defaultValue %>" maxLength= "<%=maxSize%>" onkeypress="return allowValidNumberLocal2(this, event, '<%=maxSize%>','<%=decSize%>')" onblur = "validateNumber(this,'<%=decSize%>','<%=minSize %>','<%=minValue %>','<%= maxValue%>','<%=oVitalsConfig.getNormalLow() %>','<%=oVitalsConfig.getNormalHigh() %>','<%=nLoopCount1 %>','<%=oVitalsConfig.getCriticalLow() %>','<%=oVitalsConfig.getCriticalHigh() %>','<%=oVitalsConfig.getCriticalLowStr() %>','<%=oVitalsConfig.getCriticalHighStr() %>','<%=oVitalsConfig.getLowStr() %>','<%=oVitalsConfig.getHighStr() %>')" />
																 			</div>
																 			</div>
																 		<div data-role="none" class="cell3">
                                                                                        <div data-role="none" class="dvRange"><%=oVitalsConfig.getNormalLow()%>-<%=oVitalsConfig.getNormalHigh()%> </div> 
                                                                                        <div data-role="none" class="dvUnit"><%=oVitalsConfig.getUnits()%></div>
                                                                       </div>
																 	</div>
																 </div>
												   	    	</div>
												   	    	<div class="rowDivider"></div>
												   	    	
												   	    	   <%
												   	    	
												   	    	}
												   	    	else if(type.equals("D"))
												   	    	{
												   	    		%>
												   	    		<div class="rowContainer" data-role="none" style="display: block">
												   	    		<div data-role = "none" class = "dvControlTable">
																 	<div data-role = "none" class = "dvControlRow">
																 		<div data-role = "none" class = "Cell1">
																 		<div data-role = "none" class = "dvControlLabel" id = "custom_<%=oVitalsConfig.getSectionId() %>_<%=oVitalsConfig.getDiscreteMeasureId() %>_Label" ><%=oVitalsConfig.getDiscreteMeasureDesc() %> <%if(mandatory != null && mandatory.equals("Y")){ %> <font style="color: red">*</font> <%} %></div>
																 		</div>
																 		<div data-role = "none" class = "Cell2">
																 			<div data-role = "none" class="divEvent1 divEventTheme" >
																 				<div class="formValWarningTheme formValError" id = "custom_<%=oVitalsConfig.getSectionId() %>_<%=oVitalsConfig.getDiscreteMeasureId()%>_Warning" style="top: 45px; left: 0px; display: none">
																					<div class="formValErrorMsgTheme" id = "custom_<%=oVitalsConfig.getSectionId() %>_<%=oVitalsConfig.getDiscreteMeasureId()%>_WarningMsg">
																					</div>												
																				</div>
																 				<input data-rowIndex = "<%=nLoopCount1 %>" data-type = "<%=type %>" id = "custom_<%=oVitalsConfig.getSectionId() %>_<%=oVitalsConfig.getDiscreteMeasureId() %>" data-type="Date" data-count="I" 	style="text-align:right" data-role="none" data-mandatory = "<%=mandatory %>" />
																					 <script>
																			            $(document).ready(function() {
																			                // create DateTimePicker from input HTML element
																			               // var today1 = new Date();
																			                $("#custom_<%=oVitalsConfig.getSectionId() %>_<%=oVitalsConfig.getDiscreteMeasureId() %>").kendoDatePicker({
																			                	format : "dd/MM/yyyy",
																			                	 <%
																			                	    if(locale != null && !locale.equalsIgnoreCase("en"))
																			                	    {
																			                	    	%>
																			                	    	culture : "<%=locale%>",
																			                	    	<%
																			                	    }
																			                	 %>
																			                	change : function() {
																		                	        var cntrlIndex = "<%=nLoopCount1 %>";
																		                	        checkVitalsDate(this,cntrlIndex,'custom_<%=oVitalsConfig.getSectionId() %>_<%=oVitalsConfig.getDiscreteMeasureId() %>','<%=type%>');
																		                	    }
																			                });
																			            });
												                                   </script>
																 			</div>
																 			</div>
																 			<div data-role="none" class="cell3">
                                                                                        <div data-role="none"> &nbsp </div> 
                                                                                        <div data-role="none"> &nbsp </div>
                                                                       </div>
																 		
																 	</div>
																 </div>
												   	    	</div>
												   	    	<div class="rowDivider"></div>
												   	    	 
												   	    		<% 
												   	    	}
												   	    	else if(type.equals("T"))
												   	    	{
												   	    		%>
												   	    		<div class="rowContainer" data-role="none" style="display: block">
												   	    		<div data-role = "none" class = "dvControlTable">
																 	<div data-role = "none" class = "dvControlRow">
																 		<div data-role = "none" class = "Cell1"><div data-role = "none" class = "dvControlLabel" id = "custom_<%=oVitalsConfig.getSectionId() %>_<%=oVitalsConfig.getDiscreteMeasureId() %>_Label" ><%=oVitalsConfig.getDiscreteMeasureDesc() %> <%if(mandatory != null && mandatory.equals("Y")){ %> <font style="color: red">*</font> <%} %></div>
																 		</div>
																 		<div data-role = "none" class = "Cell2">
																 			<div data-role = "none" class="divEvent1 divEventTheme" >
																 				<div class="formValWarningTheme formValError" id = "custom_<%=oVitalsConfig.getSectionId() %>_<%=oVitalsConfig.getDiscreteMeasureId()%>_Warning" style="top: 45px; left: 0px; display: none">
																					<div class="formValErrorMsgTheme" id = "custom_<%=oVitalsConfig.getSectionId() %>_<%=oVitalsConfig.getDiscreteMeasureId()%>_WarningMsg">
																					</div>												
																				</div>
																 				<input  data-rowIndex = "<%=nLoopCount1 %>" data-type = "<%=type %>" type="text" data-role="none" onchange = "valueChange(this,'<%=nLoopCount1 %>')" onblur = "chkValidityOfTime(this)" class="txtContent" style = "width:97%" name = "custom_<%=oVitalsConfig.getSectionId() %>_<%=oVitalsConfig.getDiscreteMeasureId() %>" id = "custom_<%=oVitalsConfig.getSectionId() %>_<%=oVitalsConfig.getDiscreteMeasureId() %>"  data-mandatory = "<%=mandatory %>"  maxLength= "5"  />
																 			</div>
																 			
																 		</div>
																 		<div data-role="none" class="cell3">
                                                                                        <div data-role="none"> &nbsp </div> 
                                                                                        <div data-role="none"> &nbsp </div>
                                                                       </div>
																 	</div>
																 </div>
												   	    	</div>
												   	    	<div class="rowDivider"></div>
												   	    	 
												   	    		<% 
												   	    	}
												   	     	else if(type.equals("E"))
												   	     	{
												   	     		%>
												   	     		<div class="rowContainer" data-role="none" style="display: block">
												   	    		<div data-role = "none" class = "dvControlTable">
																 	<div data-role = "none" class = "dvControlRow">
																 		<div data-role = "none" class = "Cell1"><div data-role = "none" class = "dvControlLabel" id = "custom_<%=oVitalsConfig.getSectionId() %>_<%=oVitalsConfig.getDiscreteMeasureId() %>_Label" ><%=oVitalsConfig.getDiscreteMeasureDesc() %> <%if(mandatory != null && mandatory.equals("Y")){ %> <font style="color: red">*</font> <%} %></div>
																 		</div>
																 		<div data-role = "none" class = "Cell2">
																 			<div data-role = "none" class="divEvent1 divEventTheme" >
																 				<div class="formValWarningTheme formValError" id = "custom_<%=oVitalsConfig.getSectionId() %>_<%=oVitalsConfig.getDiscreteMeasureId()%>_Warning" style="top: 45px; left: 0px; display: none">
																					<div class="formValErrorMsgTheme" id = "custom_<%=oVitalsConfig.getSectionId() %>_<%=oVitalsConfig.getDiscreteMeasureId()%>_WarningMsg">
																					</div>												
																				</div>
																 				<input data-rowIndex = "<%=nLoopCount1 %>"  data-type = "<%=type %>" id = "custom_<%=oVitalsConfig.getSectionId() %>_<%=oVitalsConfig.getDiscreteMeasureId() %>" data-type = "DateTime" data-count="I" 	style="text-align:right;" data-role="none" data-mandatory = "<%=mandatory %>" />
																					 <script>
																			            $(document).ready(function() {
																			                // create DateTimePicker from input HTML element
																			              //  var today = new Date();
																			                $("#custom_<%=oVitalsConfig.getSectionId() %>_<%=oVitalsConfig.getDiscreteMeasureId() %>").kendoDateTimePicker({
																			                	 interval: 1,
																			                	 format : "dd/MM/yyyy HH:mm",
																			                	 <%
																			                	    if(locale != null && !locale.equalsIgnoreCase("en"))
																			                	    {
																			                	    	%>
																			                	    	culture : "<%=locale%>",
																			                	    	<%
																			                	    }
																			                	 %>
																			                	 change : function() {
																			                	        var cntrlIndex = "<%=nLoopCount1 %>";
																			                	        checkVitalsDate(this,cntrlIndex,'custom_<%=oVitalsConfig.getSectionId() %>_<%=oVitalsConfig.getDiscreteMeasureId() %>','<%=type%>');
																			                	    }
																			                });
																			            });
												                                   </script>
																 			</div>
																 		</div>
																 		<div data-role="none" class="cell3">
                                                                                        <div data-role="none"> </div> 
                                                                                        <div data-role="none"> </div>
                                                                       </div>
																 	</div>
																 </div>
												   	    	</div>
												   	    	<div class="rowDivider"></div>
												   	    	
												   	     		<% 
												   	     	}
												   	     	else if(type.equals("A"))
												   	     	{
												   	     	  	nLoopCount1--;
												   	     	}
												   	        else
												   	     	{
												   	     		%>
												   	     		 <div class="rowContainer" data-role="none" style="display: block">
												   	    		<div data-role = "none" class = "dvControlTable">
																 	<div data-role = "none" class = "dvControlRow">
																 		<div data-role = "none" class = "Cell1"><div data-role = "none" class = "dvControlLabel" id = "custom_<%=oVitalsConfig.getSectionId() %>_<%=oVitalsConfig.getDiscreteMeasureId() %>_Label" ><%=oVitalsConfig.getDiscreteMeasureDesc() %> <%if(mandatory != null && mandatory.equals("Y")){ %> <font style="color: red">*</font> <%} %></div>
																 		</div>
																 		<div data-role = "none" class = "Cell2">
																 			<div data-role = "none" class="divEvent1 divEventTheme" >
																 				<div class="formValWarningTheme formValError" id = "custom_<%=oVitalsConfig.getSectionId() %>_<%=oVitalsConfig.getDiscreteMeasureId()%>_Warning" style="top: 45px; left: 0px; display: none">
																					<div class="formValErrorMsgTheme" id = "custom_<%=oVitalsConfig.getSectionId() %>_<%=oVitalsConfig.getDiscreteMeasureId()%>_WarningMsg">
																					</div>												
																				</div>
																 				<input  data-rowIndex = "<%=nLoopCount1 %>" data-type = "<%=type %>" type="text" data-role="none" onchange = "valueChange(this,'<%=nLoopCount1 %>')" class="txtContent" style = "width:97%" name = "custom_<%=oVitalsConfig.getSectionId() %>_<%=oVitalsConfig.getDiscreteMeasureId() %>" id = "custom_<%=oVitalsConfig.getSectionId() %>_<%=oVitalsConfig.getDiscreteMeasureId() %>"  data-mandatory = "<%=mandatory %>" value = "<%=defaultValue %>" maxLength= "20" onkeypress="return allowValidNumberLocal3(this, event)"  />
																 			</div>
																 		</div>
																 		<div data-role="none" class="cell3">
                                                                                        <div data-role="none"> </div> 
                                                                                        <div data-role="none"> </div>
                                                                       </div>
																 	</div>
																 </div>
												   	    	</div>
												   	    	<div class="rowDivider"></div>
												   	    
												   	     		<% 
												   	     	}
												   	    	 
												   	    	
												   	    }
												   	 if(type != null &&  type.equals("C")) // to display checkbox control
										    	       {
										    	    	   
										    	    	  %>
										    	    	   <div class="rowContainer" data-role="none" style="display: block">
												   	    		<div data-role = "none" class = "dvControlTable">
																 	<div data-role = "none" class = "dvControlRow">
																 		<div data-role = "none" class = "Cell1"><div data-role = "none" class = "dvControlLabel" id = "custom_<%=oVitalsConfig.getSectionId() %>_<%=oVitalsConfig.getDiscreteMeasureId() %>_Label"><%=oVitalsConfig.getDiscreteMeasureDesc() %> <%if(mandatory != null && mandatory.equals("Y")){ %> <font style="color: red">*</font> <%} %></div>
																 		</div>
																 		<div data-role = "none" class = "Cell2">
																 		  
																 			<div data-role = "none" class="divEvent2 divEventTheme" >
																 				<div class="formValWarningTheme formValError" id = "custom_<%=oVitalsConfig.getSectionId() %>_<%=oVitalsConfig.getDiscreteMeasureId()%>_Warning" style="top: 45px; left: 0px; display: none">
																					<div class="formValErrorMsgTheme" id = "custom_<%=oVitalsConfig.getSectionId() %>_<%=oVitalsConfig.getDiscreteMeasureId()%>_WarningMsg">
																					</div>												
																				</div>
																				
																 				 <input data-mandatory = "<%=mandatory %>" data-rowIndex = "<%=nLoopCount1 %>" data-type = "<%=type %>" type = "checkbox" data-role = "none" class = "chkChart" id = "custom_<%=oVitalsConfig.getSectionId() %>_<%=oVitalsConfig.getDiscreteMeasureId() %>" onclick = "evalCheckBox(this,'<%=nLoopCount1 %>')" />
																 			</div>
																 		</div>
																 		<div data-role="none" class="cell3">
                                                                                        <div data-role="none"> &nbsp </div> 
                                                                                        <div data-role="none"> &nbsp </div>
                                                                       </div>
																 	</div>
																 </div>
												   	    	</div>
												   	    	<div class="rowDivider"></div>
												   	    	
										    	    	  
										    	    	 <%   
										    	       }
												   	 	if(type != null &&  type.equals("L")) // to display list box control
												   	 	{
												   	 		%>
												   	 		<div class="rowContainer" data-role="none" style="display: block">
												   	    		<div data-role = "none" class = "dvControlTable">
																 	<div data-role = "none" class = "dvControlRow">
																 		<div data-role = "none" class = "Cell1"><div data-role = "none" class = "dvControlLabel" id = "custom_<%=oVitalsConfig.getSectionId() %>_<%=oVitalsConfig.getDiscreteMeasureId() %>_Label" ><%=oVitalsConfig.getDiscreteMeasureDesc() %> <%if(mandatory != null && mandatory.equals("Y")){ %> <font style="color: red">*</font> <%} %></div>
																 		</div>
																 		<div data-role = "none" class = "Cell2">
																 			<div data-role = "none" class="divEvent1 divEventTheme" >
																 				<div class="formValWarningTheme formValError" id = "custom_<%=oVitalsConfig.getSectionId() %>_<%=oVitalsConfig.getDiscreteMeasureId()%>_Warning" style="top: 45px; left: 0px; display: none">
																					<div class="formValErrorMsgTheme" id = "custom_<%=oVitalsConfig.getSectionId() %>_<%=oVitalsConfig.getDiscreteMeasureId()%>_WarningMsg">
																					</div>												
																				</div>
																 				<select data-rowIndex = "<%=nLoopCount1 %>"  data-type = "<%=type %>" id = "custom_<%=oVitalsConfig.getSectionId() %>_<%=oVitalsConfig.getDiscreteMeasureId() %>" data-type = "ComboBox" data-count="I" 	 onchange = "setComboValue(this,'<%=nLoopCount1 %>')" data-role="none" data-mandatory = "<%=mandatory %>" >
																 					 <option value = "">Select</option>
																 				    <%
																 				   List<ChartCombo> oChartComboList = null;
																 				   oChartComboList = oVitalsConfig.getChartComboList();
																 				   if(oChartComboList != null && oChartComboList.size() > 0)
																 				   {
																 					   for(ChartCombo oChartCombo : oChartComboList)
																 					   {
																 						   if(oChartCombo != null)
																 						   {
																 							   String selected = "";
																			    	    	   String dfSelected = "";
																			    	    	   
																			    	    	   normalInd = oChartCombo.getNormAbnormIndicator();
															    	    					   dfSelected = oChartCombo.getDfltYN();
															    	    					   if( dfSelected != null &&  dfSelected.equals("Y"))
															    	    					   {
															    	    						   selected = "selected";
															    	    						  defaultValue = oChartCombo.getRefRangeSeq();
															    	    						   defaultText = oChartCombo.getRefRangeDesc();
															    	    						   
															    	    					   }
															    	    					   else
															    	    					   {
															    	    						   selected = "";
															    	    					   }
															    	    					   %>
															    	    					    <option value = "<%=oChartCombo.getRefRangeSeq()%>" <%=selected %>><%= oChartCombo.getRefRangeDesc()%></option> 
															    	    					   <% 
																 						   }
																 					   }
																 				   }
																 				    	 	
																 				     %>
																 				</select>
																					 <script>
																			            $(document).ready(function() {
																			                $("#custom_<%=oVitalsConfig.getSectionId() %>_<%=oVitalsConfig.getDiscreteMeasureId() %>").kendoComboBox({
																			                	   change : function(e) {
																			                		  // alert(" index = " + this.select());
																			                		   //alert(this.value());
																			                		   var cntrlIndex = "<%=nLoopCount1 %>";
																			                	       // alert(cntrlIndex);
																			                	       
																			                	       // alert(document.getElementById(sHidden));
																			                	          var sHidden = "listItemValue" + cntrlIndex;
																			                	    	   var sCompValue = "comp_" + cntrlIndex;
																			                	       if(this.select() != -1)
																			                	    	{
																			                	    	
																			                	    	   if(this.value() == "")
																			                	    	   {
																			                	    		   document.getElementById(sHidden).value = this.text();
																				                	    	   document.getElementById(sCompValue).value = this.value();
																			                	    	   }
																			                	    	   else
																			                	    	   {
																			                	    		   document.getElementById(sHidden).value = this.text();
																				                	    	   document.getElementById(sCompValue).value = this.value();
																			                	    	   }
																			                	    	
																			                	    	
																			                	    	  
																			                	    	}
																			                	       else
																			                	    	{
																			                	    	   document.getElementById(sHidden).value = "";
																			                	    	   document.getElementById(sCompValue).value = "";
																			                	    	}
																			                	  	    
																			                	   }
																			                }
																			                		);
																			            });
												                                   </script>
																 			</div>
																 		</div>
																 		<div data-role="none" class="cell3">
                                                                                        <div data-role="none"> </div> 
                                                                                        <div data-role="none"> </div>
                                                                       </div>
																 	</div>
																 </div>
												   	    	</div>
												   	    	<div class="rowDivider"></div>
												   	    
												   	 		<% 
												   	 	}
													   	 if(type != null &&  !type.equals("A"))
													   	 {
													   		 %>
													   		 <input type="hidden" name="discr_msr_id_grp_id<%=nLoopCount1 %>" id="discr_msr_id_grp_id<%=nLoopCount1 %>" id="discr_msr_id_grp_id<%=nLoopCount1 %>" value= "custom_<%=oVitalsConfig.getSectionId() %>_<%=oVitalsConfig.getDiscreteMeasureId() %>" />
											                 <input type="hidden" name="dis_msr_type_<%=nLoopCount1 %>" id="dis_msr_type_<%=nLoopCount1 %>" id="dis_msr_type_<%=nLoopCount1 %>" value="<%=type %>"/>
											                 <input type="hidden" name="dis_msr_id_<%=nLoopCount1 %>" id="dis_msr_id_<%=nLoopCount1 %>" id ="dis_msr_id_<%=nLoopCount1 %>" value="<%=oVitalsConfig.getDiscreteMeasureId() %>" />
															 <input type= "hidden" name="chat_grp_id_<%=nLoopCount1 %>" id="chat_grp_id_<%=nLoopCount1 %>" id ="chat_grp_id_<%=nLoopCount1 %>" value="<%=oVitalsConfig.getSectionId() %>"/>
															 <input type="hidden" name="comp_<%=nLoopCount1 %>" id="comp_<%=nLoopCount1 %>" id = "comp_<%=nLoopCount1 %>"  value="<%=defaultValue%>"/>
															 <input type="hidden" name="normal_low_<%=nLoopCount1 %>" id="normal_low_<%=nLoopCount1 %>" id ="normal_low_<%=nLoopCount1 %>" value= "<%=oVitalsConfig.getNormalLow() %>"/>
															 <input type="hidden" name="normal_high_<%=nLoopCount1 %>" id="normal_high_<%=nLoopCount1 %>" id ="normal_high_<%=nLoopCount1 %>" value= "<%=oVitalsConfig.getNormalHigh() %>"/>
															 <input type="hidden" name="critical_low_<%=nLoopCount1 %>" id="critical_low_<%=nLoopCount1 %>" id ="critical_low_<%=nLoopCount1 %>" value= "<%=oVitalsConfig.getCriticalLow() %>"/>
															 <input type="hidden" name="critical_high_<%=nLoopCount1 %>" id="critical_high_<%=nLoopCount1 %>" id ="critical_high_<%=nLoopCount1 %>" value= "<%=oVitalsConfig.getCriticalHigh()%>"/>
															 <input type="hidden" name="associate_score_yn<%=nLoopCount1 %>" id="associate_score_yn<%=nLoopCount1 %>" id ="associate_score_yn<%=nLoopCount1 %>" value= "<%=oVitalsConfig.getAssociateScoreYN() %>" />
															 <input type="hidden" name="normal_abnormal_ind_<%=nLoopCount1 %>" id="normal_abnormal_ind_<%=nLoopCount1 %>" id ="normal_abnormal_ind_<%=nLoopCount1 %>" value= "<%= normalInd %>" />
															 <input type="hidden" name="listItemValue<%=nLoopCount1 %>" id="listItemValue<%=nLoopCount1 %>" id ="listItemValue<%=nLoopCount1 %>" value = "<%=defaultText%>"/>
															 <input type="hidden" name="uom_<%=nLoopCount1 %>" id="uom_<%=nLoopCount1 %>" value="<%= oVitalsConfig.getUnits()%>">
															 <input type="hidden" name="hdnSF<%=nLoopCount1 %>" id="hdnSF<%=nLoopCount1 %>" id ="hdnSF<%=nLoopCount1 %>" value = "<%=oVitalsConfig.getSummationFormula()%>"/>
													   		 <% 
													   	 }
						 							}// if config not null
						 						
						 							nLoopCount1++;
						 						}//config list loop
						 					}
						 				}
						 			}//panel loop
						 		}
						 	}
						 %>
						 	<div class="rowContainer" data-role="none" style="display: block">
												   	    		<div data-role = "none" class = "dvControlTable">
																 	<div data-role = "none" class = "dvControlRow">
																 		<div data-role = "none" class = "Cell1">
																 		&nbsp;
																 		</div>
																 		<div data-role = "none" class = "Cell2">
																 			&nbsp;
																 		</div>
																 		<div data-role = "none" class = "Cell3">
																 			&nbsp;
																 		</div>
																 	</div>
																 </div>
												   	    	</div>
						 	
						</div><!-- container -->
					</div> <!-- scroller -->
					<div class="formValErrorTheme formValError"
					id="MandatoryFields_Error"
					style="bottom: 0px; left: 0px; display: none">
					<div class="formValErrorMsgTheme" id="MandatoryFields_ErrorMsg">All
						mandatory fields must be entered</div>
				</div>
				</div> <!-- divcnt -->
				<input type="hidden" name="hdnPath" id="hdnPath" id="hdnPath" value="${path}" /> 
				<input type = "hidden" name = "today" id = "today" value="<%=today%>"/>
			    <input type = "hidden" name = "patientDOB" id = "patientDOB" value="<%=patientDOB%>"/>
			    <input type = "hidden" name = "hdnPatientId" id = "hdnPatientId" value = "<%=patientId %>" />
			    <input type = "hidden" name = "hdnPatientClass" id = "hdnPatientClass" value = "<%=patientClass%>" />
			    <input type = "hidden" name = "count" id = "count" value = '<%=nLoopCount1 %>'/>
			      <input type = "hidden" name = "hdnChartId" id = "hdnChartId" value = "<%=chartId %>"/>
			     
		</form>
	</div>
</body>
</html>

