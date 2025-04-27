/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function getXHR(){
	var request = false;
	try {
		request = new XMLHttpRequest();
	}catch (trymicrosoft) {
		try {
			request = new ActiveXObject("Msxml2.XMLHTTP");
		}catch (othermicrosoft) {
			try {
				request = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (failed) {
				request = false;
			}
		}
    }
	if (!request){
		alert("System Error initializing XMLHttpRequest!");
		return;
	}else return request;
}


function convertDate(date,format,from,to){
	var xhr =  getXHR();
	var url = "../../eCommon/jsp/DateUtils.jsp?methodName=convertDate&format="+format+"&date="+date+"&fromLocale="+from+"&toLocale="+to;
    xhr.open("POST", url, false);
	xhr.setRequestHeader("Content-Type","text/plain")
   	xhr.send("");
	
	var xmlText =  trimString(xhr.responseText)
	return(xmlText);
}

function getCurrentDate(format, locale){
	var xhr =  getXHR();
	var url = "../../eCommon/jsp/DateUtils.jsp?methodName=getCurrentDate&format="+format+"&locale="+locale;
    xhr.open("POST", url, false);
	xhr.setRequestHeader("Content-Type","text/plain")
   	xhr.send("");
	
	var xmlText = trimString(xhr.responseText)
	return(xmlText);
}

function validDate(date, format, locale){
	var dateFlag=true;
	var dateArr;
	var dateArr1;
	if(format=="DMY"){
		dateArr=date.split("/");
		if(dateArr[2]==0){
			dateFlag=false;
		}
	}else if(format=="DMYHM"){
		dateArr1=date.split(" ");
		dateArr=(dateArr1[0]).split("/");
		if(dateArr[2]==0){
			dateFlag=false;
		}
	}else if(format=="YY"){
		if(date==0){
			dateFlag=false;
		}
	}else if(format=="MY"){
		dateArr=date.split("/");
		if(dateArr[1]==0){
			dateFlag=false;
		}
	}
	if(dateFlag){
		var xhr =  getXHR();
		var url = "../../eCommon/jsp/DateUtils.jsp?methodName=validDate&format="+format+"&locale="+locale+"&date="+date;
		xhr.open("POST", url, false);
		xhr.setRequestHeader("Content-Type","text/plain")
		xhr.send("");
		var xmlText = xhr.responseText
		if (TrimStr(xmlText) == "true"){
			dateFlag=true;
		}else{
			dateFlag=false;
		}
	}
	return dateFlag;
}
/* Method to accept Object
	Created by : Vinod @ 12/22/2006
*/
function validDateObj(date, format, locale){
	if(date.value != ''){
		var dateValue=date.value;
		var dateArray="";
		var dateArray1;
		var checkFlag=true;
		if(format=="DMY"){
			dateArray=dateValue.split("/");
			if(dateArray[2]==0){
				checkFlag=false;
			}else{
				if(locale=='th'){
					if(dateArray[2]<=543){
						checkFlag=false;
					}
				}
			}
		}else if(format=="DMYHM"){
			dateArray1=dateValue.split(" ");
			dateArray=(dateArray1[0]).split("/");
			if(dateArray[2]==0){
				checkFlag=false;
			}else{
				if(locale=='th'){
					if(dateArray[2]<=543){
						checkFlag=false;
					}
				}
			}

			if(dateArray1.length >1){
				var time1arr=dateArray1[1].split(":")
				if(time1arr.length==2)
				{
					var time1hr=time1arr[0]
					var time1min=time1arr[1]

					if (time1hr.length != 2 || time1min.length != 2)
					{
						 checkFlag=false;
					}
				}
			}
			
		}else if(format=="DMYHMS"){			
			dateArray1=dateValue.split(" ");
			dateArray=(dateArray1[0]).split("/");
			if(dateArray[2]==0){
				checkFlag=false;
			}else{
				if(locale=='th'){
					if(dateArray[2]<=543){
						checkFlag=false;
					}
				}
			}
			var time1arr=dateArray1[1].split(":")
			if(time1arr.length==3)
            {
				var time1hr=time1arr[0]
				var time1min=time1arr[1]
				var time1sec=time1arr[2]

				if (time1hr.length != 2 || time1min.length != 2 || time1sec.length != 2)
				{
					 checkFlag=false;
				}
			}
			
		}else if(format=="YY"){
			if(date==0){
				checkFlag=false;
			}else{
				if(locale=='th'){
					if(dateArray[2]<=543){
						checkFlag=false;
					}
				}
			}
		}else if(format=="MY"){
			dateArray=dateValue.split("/");
			if(dateArray[1]==0){
				checkFlag=false;
			}else{
				if(locale=='th'){
					if(dateArray[2]<=543){
						checkFlag=false;
					}
				}
			}
		}	
		if(checkFlag){
			if(!validDate(date.value,format,locale)){
				if(top.header != null){
					alert(top.header.getMessage("INVALID_DATE_FMT", "SM"));
				}else{
					alert(getMessage("INVALID_DATE_FMT", "SM"));
				}
				date.value='';
				date.select();
				date.focus();
				
				return false;
			}else{
				return true;
			}
		}else{
			var msg=getMessage("INVALID_VALUE", "COMMON");
			alert(msg.replace('#',getLabel("Common.date.label","Common")));
			date.value='';
			date.select();
			date.focus();
			return false;
		}
	}
}

function isBefore(fromDate, toDate, format, locale){
	var xhr =  getXHR();
	var url = "../../eCommon/jsp/DateUtils.jsp?methodName=isBefore&fromDate="+fromDate+"&toDate="+toDate+"&format="+format+"&locale="+locale;
    xhr.open("POST", url, false);
	xhr.setRequestHeader("Content-Type","text/plain")
   	xhr.send("");
	
	var xmlText = xhr.responseText
	if (TrimStr(xmlText) == "true"){
		return true;
	}
	return false;
}

function isBeforeNow(currDate, format, locale){
	var xhr =  getXHR();
	var url = "../../eCommon/jsp/DateUtils.jsp?methodName=isBeforeNow&currDate="+currDate+"&format="+format+"&locale="+locale;
    xhr.open("POST", url, false);
	xhr.setRequestHeader("Content-Type","text/plain")
   	xhr.send("");
	
	var xmlText = xhr.responseText
	if (TrimStr(xmlText) == "true"){
		return true;
	}
	return false;
}

function isAfterNow(currDate, format, locale){
	var xhr =  getXHR();
	var url = "../../eCommon/jsp/DateUtils.jsp?methodName=isAfterNow&currDate="+currDate+"&format="+format+"&locale="+locale;
    xhr.open("POST", url, false);
	xhr.setRequestHeader("Content-Type","text/plain")
   	xhr.send("");
	
	var xmlText = xhr.responseText
	if (TrimStr(xmlText) == "true"){
		return true;
	}
	return false;
}

function isAfter(fromDate, toDate, format, locale){
	var xhr =  getXHR();
	var url = "../../eCommon/jsp/DateUtils.jsp?methodName=isAfter&fromDate="+fromDate+"&toDate="+toDate+"&format="+format+"&locale="+locale;
    xhr.open("POST", url, false);
	xhr.setRequestHeader("Content-Type","text/plain")
   	xhr.send("");
	
	var xmlText = xhr.responseText
	if (TrimStr(xmlText) == "true"){
		return true;
	}
	return false;
}

function isBetween(fromDate, toDate, currDate, format, locale){
	var xhr =  getXHR();
	var url = "../../eCommon/jsp/DateUtils.jsp?methodName=isBetween&fromDate="+fromDate+"&toDate="+toDate+"&currDate="+currDate+"&format="+format+"&locale="+locale;
    xhr.open("POST", url, false);
	xhr.setRequestHeader("Content-Type","text/plain")
   	xhr.send("");
	
	var xmlText = xhr.responseText
	if (TrimStr(xmlText) == "true"){
		return true;
	}
	return false;
}

function getDayOfMonth(currDate, format, locale){
	var xhr =  getXHR();
	var url = "../../eCommon/jsp/DateUtils.jsp?methodName=getDayOfMonth&currDate="+currDate+"&format="+format+"&locale="+locale;
    xhr.open("POST", url, false);
	xhr.setRequestHeader("Content-Type","text/plain")
   	xhr.send("");
	
	var xmlText = trimString(xhr.responseText)
	return(xmlText);
}

function getDayOfWeek(currDate,  format,  locale) {
	var xhr =  getXHR();
	var url = "../../eCommon/jsp/DateUtils.jsp?methodName=getDayOfWeek&currDate="+currDate+"&format="+format+"&locale="+locale;
    xhr.open("POST", url, false);
	xhr.setRequestHeader("Content-Type","text/plain")
   	xhr.send("");
	
	var xmlText = trimString(xhr.responseText)
	return(xmlText);
}

function getDayOfWeekAsLongText(currDate, format, locale){
	var xhr =  getXHR();
	var url = "../../eCommon/jsp/DateUtils.jsp?methodName=getDayOfWeekAsLongText&currDate="+currDate+"&format="+format+"&locale="+locale;
    xhr.open("POST", url, false);
	xhr.setRequestHeader("Content-Type","text/plain")
   	xhr.send("");
	
	var xmlText = trimString(xhr.responseText)
	return(xmlText);
}

function getDayOfWeekAsShortText( currDate, format, locale){
	var xhr =  getXHR();
	var url = "../../eCommon/jsp/DateUtils.jsp?methodName=getDayOfWeekAsShortText&currDate="+currDate+"&format="+format+"&locale="+locale;
    xhr.open("POST", url, false);
	xhr.setRequestHeader("Content-Type","text/plain")
   	xhr.send("");
	
	var xmlText = trimString(xhr.responseText)
	return(xmlText);
}

function getMonthOfYear(currDate, format, locale){
	var xhr =  getXHR();
	var url = "../../eCommon/jsp/DateUtils.jsp?methodName=getMonthOfYear&currDate="+currDate+"&format="+format+"&locale="+locale;
    xhr.open("POST", url, false);
	xhr.setRequestHeader("Content-Type","text/plain")
   	xhr.send("");
	
	var xmlText = trimString(xhr.responseText)
	return(xmlText);
}

function getMonthOfYearAsLongText(currDate, format, locale){
	var xhr =  getXHR();
	var url = "../../eCommon/jsp/DateUtils.jsp?methodName=getMonthOfYearAsLongText&currDate="+currDate+"&format="+format+"&locale="+locale;
    xhr.open("POST", url, false);
	xhr.setRequestHeader("Content-Type","text/plain")
   	xhr.send("");
	
	var xmlText = trimString(xhr.responseText)
	return(xmlText);
}

function getMonthOfYearAsShortText(currDate, format, locale){
	var xhr =  getXHR();
	var url = "../../eCommon/jsp/DateUtils.jsp?methodName=getMonthOfYearAsShortText&currDate="+currDate+"&format="+format+"&locale="+locale;
    xhr.open("POST", url, false);
	xhr.setRequestHeader("Content-Type","text/plain")
   	xhr.send("");
	
	var xmlText = trimString(xhr.responseText)
	return(xmlText);
}

function getYear(currDate, format, locale){
	var xhr =  getXHR();
	var url = "../../eCommon/jsp/DateUtils.jsp?methodName=getYear&currDate="+currDate+"&format="+format+"&locale="+locale;
    xhr.open("POST", url, false);
	xhr.setRequestHeader("Content-Type","text/plain")
   	xhr.send("");
	
	var xmlText = trimString(xhr.responseText)
	return(xmlText);
}

function getHourOfDay(currDate, format, locale){
	var xhr =  getXHR();
	var url = "../../eCommon/jsp/DateUtils.jsp?methodName=getHourOfDay&currDate="+currDate+"&format="+format+"&locale="+locale;
    xhr.open("POST", url, false);
	xhr.setRequestHeader("Content-Type","text/plain")
   	xhr.send("");
	
	var xmlText = trimString(xhr.responseText)
	return(xmlText);
}

function getMinuteOfHour(currDate, format, locale){
	var xhr =  getXHR();
	var url = "../../eCommon/jsp/DateUtils.jsp?methodName=getMinuteOfHour&currDate="+currDate+"&format="+format+"&locale="+locale;
    xhr.open("POST", url, false);
	xhr.setRequestHeader("Content-Type","text/plain")
   	xhr.send("");
	
	var xmlText = trimString(xhr.responseText)
	return(xmlText);
}

function minusDate(currDate, format, locale, value, interval){
	var xhr =  getXHR();
	var url = "../../eCommon/jsp/DateUtils.jsp?methodName=minusDate&currDate="+currDate+"&format="+format+"&locale="+locale+"&value="+value+"&interval="+interval;
    xhr.open("POST", url, false);
	xhr.setRequestHeader("Content-Type","text/plain")
   	xhr.send("");
	
	var xmlText = trimString(xhr.responseText)
	return(xmlText);
}

function plusDate(currDate, format, locale, value, interval){
	var xhr =  getXHR();
	var url = "../../eCommon/jsp/DateUtils.jsp?methodName=plusDate&currDate="+currDate+"&format="+format+"&locale="+locale+"&value="+value+"&interval="+interval;
    xhr.open("POST", url, false);
	xhr.setRequestHeader("Content-Type","text/plain")
   	xhr.send("");
	
	var xmlText = trimString(xhr.responseText)
	return(xmlText);
}

function daysBetween(fromDate,toDate,format,locale){
	var xhr =  getXHR();
	var url = "../../eCommon/jsp/DateUtils.jsp?methodName=daysBetween&fromDate="+fromDate+"&toDate="+toDate+"&format="+format+"&locale="+locale;
	xhr.open("POST",url,false);
	xhr.setRequestHeader("Content-Type","text/plain")
	xhr.send("");
	
	var xmlText = trimString(xhr.responseText)
	return(xmlText);
}	

function weeksBetween(fromDate,toDate,format,locale){
	var xhr =  getXHR();
	var url = "../../eCommon/jsp/DateUtils.jsp?methodName=weeksBetween&fromDate="+fromDate+"&toDate="+toDate+"&format="+format+"&locale="+locale;
	xhr.open("POST",url,false);
	xhr.setRequestHeader("Content-Type","text/plain")
	xhr.send("");
	
	var xmlText = trimString(xhr.responseText)
	return(xmlText);
}	

function monthsBetween(fromDate,toDate,format,locale){
	var xhr =  getXHR();
	var url = "../../eCommon/jsp/DateUtils.jsp?methodName=monthsBetween&fromDate="+fromDate+"&toDate="+toDate+"&format="+format+"&locale="+locale;
	xhr.open("POST",url,false);
	xhr.setRequestHeader("Content-Type","text/plain")
	xhr.send("");
	
	var xmlText = trimString(xhr.responseText)
	return(xmlText);
}	

function yearsBetween(fromDate,toDate,format,locale){
	var xhr =  getXHR();
	var url = "../../eCommon/jsp/DateUtils.jsp?methodName=yearsBetween&fromDate="+fromDate+"&toDate="+toDate+"&format="+format+"&locale="+locale;
	xhr.open("POST",url,false);
	xhr.setRequestHeader("Content-Type","text/plain")
	xhr.send("");
	
	var xmlText = trimString(xhr.responseText)
	return(xmlText);
}	

function hoursBetween(fromDate,toDate,format,locale){
	var xhr =  getXHR();
	var url = "../../eCommon/jsp/DateUtils.jsp?methodName=hoursBetween&fromDate="+fromDate+"&toDate="+toDate+"&format="+format+"&locale="+locale;
	xhr.open("POST",url,false);
	xhr.setRequestHeader("Content-Type","text/plain")
	xhr.send("");
	
	var xmlText = trimString(xhr.responseText)
	return(xmlText);
}	

function minutesBetween(fromDate,toDate,format,locale){
	var xhr =  getXHR();
	var url = "../../eCommon/jsp/DateUtils.jsp?methodName=minutesBetween&fromDate="+fromDate+"&toDate="+toDate+"&format="+format+"&locale="+locale;
	xhr.open("POST",url,false);
	xhr.setRequestHeader("Content-Type","text/plain")
	xhr.send("");
	
	var xmlText = trimString(xhr.responseText)
	return(xmlText);
}	

function secondsBetween(fromDate,toDate,format,locale){
	var xhr =  getXHR();
	var url = "../../eCommon/jsp/DateUtils.jsp?methodName=secondsBetween&fromDate="+fromDate+"&toDate="+toDate+"&format="+format+"&locale="+locale;
	xhr.open("POST",url,false);
	xhr.setRequestHeader("Content-Type","text/plain")
	xhr.send("");
	
	var xmlText = trimString(xhr.responseText)
	return(xmlText);
}	

function durationBetween(fromDate,toDate,format,locale){
	var xhr =  getXHR();
	var url = "../../eCommon/jsp/DateUtils.jsp?methodName=durationBetween&fromDate="+fromDate+"&toDate="+toDate+"&format="+format+"&locale="+locale;
	xhr.open("POST",url,false);
	xhr.setRequestHeader("Content-Type","text/plain")
	xhr.send("");
	
	var xmlText = trimString(xhr.responseText)
	return(xmlText);
}	

function getDaysInMonth(date,format,locale ){
	var xhr =  getXHR();
	var url = "../../eCommon/jsp/DateUtils.jsp?methodName=getDaysInMonth&date="+date+"&format="+format+"&locale="+locale;
	xhr.open("POST",url,false);
	xhr.setRequestHeader("Content-Type","text/plain")
	xhr.send("");
	
	var xmlText = trimString(xhr.responseText)
	return(xmlText);
}	

function isLeapYear(date,format,locale ){
	var xhr =  getXHR();
	var url = "../../eCommon/jsp/DateUtils.jsp?methodName=isLeapYear&date="+date+"&format="+format+"&locale="+locale;
	xhr.open("POST",url,false);
	xhr.setRequestHeader("Content-Type","text/plain")
	xhr.send("");
	
	var xmlText = trimString(xhr.responseText)
	return(xmlText);
}	

function formatDate(date,fromFormat,toFormat,locale){
	var xhr =  getXHR();
	var url = "../../eCommon/jsp/DateUtils.jsp?methodName=formatDate&fromFormat="+fromFormat+"&toFormat="+toFormat+"&locale="+locale+"&date="+date;
	xhr.open("POST",url,false);
	xhr.setRequestHeader("Content-Type","text/plain")
	xhr.send("");
	
	var xmlText = trimString(xhr.responseText)
	return(xmlText);
}
/**
	 * Method to Validate From Date <= To date and Display message in Message Frame
	 * 
	 * @param fromDate Date to be checked 
	 * @param toDate Date against which isBefore is to be checked 
	 * @param format Format of the date
	 * return True if fromDate isBefore toDate, False otherwise 
	 */
function doDateCheckMsg(from,to,messageFrame,format) 
{
	if (from.value != undefined)
	{
		from = from.value;
	}
	else
	{
		from=from;
	}

	if (to.value != undefined)
	{
		to = to.value;
	}
	else
	{
		to=to;
	}

	if ( to=='' || from=='' )
	{
		return true;
	}

	 if(!isBefore(from,to,format,localeName)){
		var error=getMessage("REMARKS_MUST_GR_EQUAL","common") ;
		error=error.replace("$",getLabel("Common.to.label","Common"));
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error ;
			return false;
		}
		else  
			return true;
}

/**
	 * Method to Validate in MASTER Functions, From Date <= To date and Display message in Message Frame
	 * 
	 * @param fromDate Date to be checked 
	 * @param toDate Date against which isBefore is to be checked 
	 * @param format Format of the date
	 * return True if fromDate isBefore toDate, False otherwise 
	 */
function doDateCheckMstMsg(from,to,messageFrame,format) 
{
	if (from.value != undefined)
	{
		from = from.value;
	}
	else
	{
		from=from;
	}

	if (to.value != undefined)
	{
		to = to.value;
	}
	else
	{
		to=to;
	}
	
	if ( to=='' || from=='' )
	{
		return true;
	}

	 if(!isBefore(from,to,format,localeName)){
		var error=getMessage("REMARKS_MUST_GR_EQUAL","common") ;
		error=error.replace("$",getLabel("Common.to.label","Common"));
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+error ;
			return false;
		}
		else  
			return true;
}

/**
	 * Method to Validate From Date <= To date and Display message in Message Frame with the given Label Name
	 * 
	 * @param fromDate Date to be checked 
	 * @param toDate Date against which isBefore is to be checked 
	 * @param format Format of the date
	 * @param stringLabel Legend of the field which is validated
	 * return True if fromDate isBefore toDate, False otherwise 
	 */
function doDateChkWithLabel(from,to,messageFrame,format,stringLabel) 
{
	if (from.value != undefined)
	{
		from = from.value;
	}
	else
	{
		from=from;
	}

	if (to.value != undefined)
	{
		to = to.value;
	}
	else
	{
		to=to;
	}

	if ( to=='' || from=='' )
	{
		return true;
	}

	 if(!isBefore(from,to,format,localeName)){
		var error=getMessage("REMARKS_MUST_GR_EQUAL","common") ;
		error=error.replace("$",stringLabel+' '+getLabel("Common.to.label","Common"));
		error=error.replace("#",stringLabel);
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error ;
			return false;
		}
		else  
			return true;
}


function dateRangeValidation(fromDate, toDate, locale, chkDays, format){

	var days = daysBetween(fromDate.value, toDate.value, format, locale);
	if(parseInt(days) > parseInt(chkDays)){
		return false;
	}
	return true;
}

