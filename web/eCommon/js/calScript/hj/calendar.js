/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
ï»¿var basicTheme;
//////////////////////////////////////////////////////////////////////
//
//  ======================================================
//  GLADIATOR JAVASCRIPT CALENDAR AND JULIAN DAY FUNCTIONS
//  ======================================================
//  
//  Javascript Calendar and Julian day to Gregorian date
//  conversion functions
//
//  VERSION: 1.0.0 dated 2003.10.15
//
//  COPYRIGHT (c) 2003 by Edward H. Trager.  ALL RIGHTS RESERVED.
//  Ann Arbor, Michigan, USA.  
//
//  This file and the accompanying Cascading Style Sheet file,
//  calendar.css, are released under the 
//  GNU GENERAL PUBLIC LICENSE (GPL) -- see terms below.  You
//  are basically free to use and modify these files, but you 
//  must preserve the copyright notice above.
//
//  AUTHOR 
//  ------
//
//  Edward H. Trager  <ehtrager@umich.edu>
//
//  DESCRIPTION
//  -----------
//
//  The main purpose of this file and its accompanying Cascading
//  Style Sheet, calendar.css, are to provide a Javascript popup
//  calendar for use in modern browser-based applications. 
//
//  The popup calendar uses "dayOfWeek( julianDay() )" to determine
//  the day of the week of the first day of the month.
//  A complementary "julianGregorianDate()" function is also 
//  provided so that you can make round-trip conversions between
//  Julian days and calendar dates if your application should 
//  require it.  These functions are based directly on the  
//  algorithms presented in Press et al., "Numerical Recipes in C"
//  (Cambridge University Press, 1988). The "julianGregorianDate()" 
//  function is not actually required for the popup calendar 
//  to work.
//
//  Unlike many other Javascript calendars that one finds on the
//  web, this calendar relies entirely on the World Wide Web
//  Consortium's (W3C) Document Object Model (DOM) and Cascading
//  Style Sheet (CSS) standards for its operation.  There is not
//  a single line of Netscape- or Internet Explorer-specific
//  code in the beast.  As a result, the code is relatively short
//  and simple, and it should work on all DOM- and CSS-compliant
//  browsers.
//
//  Also unlike many other Javascript calendars, this one will
//  happily give you a calendar for any year in the past 
//  (but not preceding January 1st, 4713 BCE) or future
//  Of course you must recognize that the Gregorian calendar only
//  took effect in 1582 when Pope Gregory XIII implemented it based
//  on the recommendations of the commission headed by the Jesuit
//  mathematician and astronomer, Christoph Clavius.  At that time,
//  only the Catholic countries adopted it immediately.  Some
//  countries did not adopt it until much later.  For example, the
//  English and the American colonies did not adopt it until the
//  middle of the 18th century.  Keep this in mind if your application
//  requires historical dates!
//
//  SUMMARY OF GPL LICENSING TERMS
//  ------------------------------
//
//  This program is free software; you can redistribute it and/or     
//  modify it under the terms of the GNU General Public               
//  License as published by the Free Software Foundation; either      
//  version 2 of the License, or (at your option) any later version.  
//                                                                    
//  This program is distributed in the hope that it will be useful,   
//  but WITHOUT ANY WARRANTY; without even the implied warranty of    
//  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU 
//  General Public License for more details.                          
//                                                                    
//  You should have received a copy of the GNU General Public         
//  License along with this software source code distribution; if not,
//  write to the Free Software Foundation, Inc., 59 Temple Place -    
//  Suite 330, Boston, MA 02111-1307, USA, or review the license                           
//  online at:
//
//     http://www.gnu.org/licenses/gpl.txt
//  
//////////////////////////////////////////////////////////////////////
//
// calendar.js
//
//////////////////////////////////////////////////////////////////////

//
// julianDay()
//
// Arguments: Y: year; M: month; D: date;
// Return: Julian day number;
//
// julianDay and julianGregorianDate algorithms adapted
// from Press et al., "Numerical Recipes in C" 
// (Cambridge Univ. Press).  The Javascript adaptation
// presented here also borrows a bit from Marc A. Murison's
// Javascript implementation shown on the U.S. Naval Observatory's
// Astronomical Applications Dept. web page, "Julian Date Converter"
// at http://aa.usno.navy.mil/data/docs/JulianDate.html
//
function julianDay( Y, M, D ){
	
	var y,m,d;
	
	// Guard against arguments that are really passed as strings:
	y=parseInt(Y);
	m=parseInt(M);
	d=parseInt(D);
	
	var jy,ja,jm;
	
	// Don't permit year zero: it does not exist in the Julian calendar:
	if( y==0 ){
		alert("There was no year zero in the Julian calendar.");
		return "invalid";
	}
	
	// Don't permit the missing 10 days in October of 1582:
	if( y==1582 && m==10 && d>4 && d<15 ){
		alert("October 5th to 14th were skipped in October of 1582\nwhen Pope Gregory XIII implemented the calendar reforms\nof the commission headed by the Jesuit mathematician and astronomer\nChristoph Clavius.");
		return "invalid";
	}
	
	// Negative years represent years before the Common Era (BCE).
	// Correct for the fact that there was no year zero:
	if(y<0) y++;

	if(m>2){
		jy=y;
		jm=m+1;
	}else{
		jy=y-1;
		jm=m+13;
	}
	
	var julian = Math.floor( Math.floor(365.25*jy) + Math.floor(30.6001*jm) + d + 1720995 );
	
	// Check for the switch to the Gregorian calendar:
	var gregorianStart = 15 + 31*( 10 + 12*1582 );
	
	if( d + 31*(m + 12*y) >= gregorianStart ){
		ja = Math.floor(0.01*jy);
		julian += 2 - ja + Math.floor(0.25*ja);
	}
	
	// return the Julian day number:
	return julian;
	
}

//
// julianGregorianDate()
//
// Argument: Julian day number;
// Return: Julian or Gregorian date string in ISO YYYY-MM-DD form;
//
// julianDay and julianGregorianDate algorithms adapted
// from Press et al., "Numerical Recipes in C" 
// (Cambridge Univ. Press).  The Javascript adaptation
// presented here also borrows a bit from Marc A. Murison's
// Javascript implementation shown on the U.S. Naval Observatory's
// Astronomical Applications Dept. web page, "Julian Date Converter"
// at http://aa.usno.navy.mil/data/docs/JulianDate.html
//
function julianGregorianDate( julian ){
	
	var j1, j2, j3, j4, j5;
	
	// This is of course the Julian day number
	// for October 15, 1582:
	var gregorianStart  = 2299161;
	if( julian >= gregorianStart ){
		var tmp = Math.floor( ( (julian - 1867216) - 0.25 ) / 36524.25 );
		j1 = julian + 1 + tmp - Math.floor(0.25*tmp);
	}else{
		j1 = julian;
	}
	
	j2 = j1 + 1524;
	j3 = Math.floor( 6680.0 + ( (j2 - 2439870) - 122.1 )/365.25 );
	j4 = Math.floor(j3*365.25);
	j5 = Math.floor( (j2 - j4)/30.6001 );
	
	var d = Math.floor(j2 - j4 - Math.floor(j5*30.6001));
	var m = Math.floor(j5 - 1);
	if( m > 12 ) m -= 12;
	var y = Math.floor(j3 - 4715);
	if( m > 2 ) y--;
	if( y <= 0 ) y--;
	
	return formatISODate(y,m,d);
	
}

//
// dayOfWeek()
//
// Argument: Julian day number;
// Return: Day of week;
//
function dayOfWeek( julian ){
	
	return (julian+1)%7;
	
}

//
// padWithZeros()
//
// Arguments: number: value to display; length: total length to display;
// Return: number padded out with zeros;
//
function padWithZeros(number,length) {
	 var str = "" + number;
	 while( str.length < length ) str = '0' + str;
	 return str;
}


//
// formatISODate()
//
// Arguments: year, month, day
// Return: Date string in ISO 8601 format for CE years.
//
//         For years BCE, the year is padded to 4 digits
//         and is prefixed with a negative sign.
//         Actual ISO 8601 conformance would require
//         expanding the padding of BCE years
//         beyond 4 digits, which I do not do, and then
//         prefixing with a negative sign.
//  
//         NOTE BENE: If your application really
//         requires accurate representation of dates
//         before 1582, consider modifying this function
//         to return the Julian day number instead.  This
//         would solve the issue of BCE dates as well.
//
function formatISODate( year, month, day ){
	
	// Date delimiter:
	var delimiter="/";
	if(year<0){
		year= -year; year = "/" + padWithZeros(year,4);
	}else{
		year = padWithZeros(year,4);
	}
	return padWithZeros(day,2)+ delimiter +  padWithZeros(month,2) + delimiter +year ;
	//return year + delimiter + padWithZeros(month,2) + delimiter + padWithZeros(day,2);
	
}

//
// setToday(): Sets objectId's value to today's ISO 8601 date string
// Arguments: Id of the target object (i.e., a text entry widget)
//           
function setToday( objectId ){
	 
	var today = new Date();
	document.getElementById( objectId ).value = formatISODate( today.getFullYear(), today.getMonth()+1, today.getDate() );
	
}

//
// callCalendar(): Examines the objectId's value to see if a seed year, month, and/or day
//                 are present to use for seeding generateCalendar(), and then calls
//                 generateCalendar() with the objectId as the target.
//
function callCalendar( objectId ){
	
	var dateString=document.getElementById( objectId ).value;
	// Normalize possibly variant delimiters to the ISO preferred delimiter:
	var re = new RegExp( '[/\.\ ]', 'gi' );
	dateString=dateString.replace( re, "-" );
	// Split the date string:
	dateComponents=dateString.split("-");
	var year,month,day;
	//year=dateComponents[0];
	//month=dateComponents[1];
	//day=dateComponents[2];
	generateCalendar( year, month, day, objectId );
	
}

//
// setCalDate()
//
function  setCalDate(day,format)
{ 
	// Format the date string:
	year =document.getElementById("currentYear").value;
	month=document.getElementById("currentMonth").value;
	idString = document.getElementById("destinationId").value;
	display =  document.getElementById("displayType").value ;
	diff_Yr=document.getElementById("diff_Year").value ;
	year = parseInt(year) + parseInt(diff_Yr);
   	var isoDateString=formatISODate(year,month,day);
   	var isoMMYYDateString = padWithZeros(month,2)+"/"+year
	var serverTime = "";
	var finalDate = "";
		if ( (format=='dd/mm/yyyy') || (format=='dd/mm/y') )
	{
				serverTime = ""
				finalDate=isoDateString;
      }
/*	Added by Vinod 6/03/2008 10:00 AM
To return date in Month/Year format m/YY.
*/
	else
		if(format=='mm/y')
			{
					serverTime=""
				finalDate=isoMMYYDateString;
			}
			else 
		if(format=='y')
			{
				serverTime = ""
				finalDate=year;
			}
			//var finalDate=isoDateString+" "+serverTime;
					
/*	
To return date in date/month/year hours:minutes:seconds format dd/mm/yyyy hh:mm:ss.
*/

		else
	if(format=='dd/mm/yyyy hh:mm:ss')
	{
			Dt = new Date();
				var mins = Dt.getMinutes();
				var secs= Dt.getSeconds();
				if (mins<10)
				{
					mins = '0'+mins.valueOf();
				}
				if (secs<10)
				{
					secs = '0'+secs.valueOf();
				}
				serverTime=Dt.getHours()+':'+mins+':'+secs;
				finalDate=isoDateString+" "+serverTime;
	}
		else 
	{
				Dt = new Date();
				var mins = Dt.getMinutes();
				var secs= Dt.getSeconds() ;
				var hrs = Dt.getHours();
				if (mins<10)
				{
					mins = '0'+mins.valueOf();
				}
				if(hrs<10)
				{
					hrs= '0'+hrs.valueOf();
				}
				serverTime=hrs+':'+mins;
				finalDate=isoDateString+" "+serverTime;
		} 

		//Modal Window display
		if(display == "isModal")
		{
			top.returnValue = finalDate
			top.close();
                }
		//Layer Display
		else
		{	
			document.getElementById(idString).value=finalDate;
			document.getElementById(idString).focus();
			hideDiv()
			enableFlag=false;
		}
/*End Added by vinod 6/03/2008 10:30 AM*/
}
//
// previousYear()
//
function previousYear(){
	
		year =parseInt(document.getElementById("currentYear").value) ;
		month=parseInt(document.getElementById("currentMonth").value) ;
		day  =parseInt(document.getElementById("currentDay").value) ;
		destination =  document.getElementById("destinationId").value ;
		display =  document.getElementById("displayType").value ;
		basicTheme=document.getElementById("basicTheme").value ;
		time_format=document.getElementById("timming").value ;
		diff_Yr=document.getElementById("diff_Year").value ;

	year -= 1;
	// Remember that there was no year zero:
	if( year==0 ) year = -1;
	// 
	// NOTE BENE: The generateCalendar() function *MUST* be called
	// from the "window.opener" window.  Otherwise, if you just call
	// "generateCalendar()" from *this* window, then the "opener"
	// property becomes the calendar popup window itself in the new
	// incarnation of the calendar window -- instead of being
	// the form window -- and then you would be stuck with no
	// way to access the form elements in the main form window!
	// 
	if(display=="isDiv")
	{
			time_format=document.getElementById("timming").value ;
			document.getElementById("textid").innerHTML=generateCalendar(year,month,day,destination,display,"divID","",time_format,diff_Yr);
			hideShowCovered(document.getElementById("divID"))
	}
	else
	{
			generateCalendar(year,month,day,destination,display,"divID",basicTheme,time_format,diff_Yr);
	}

	
}

//
// previousMonth()
//
function previousMonth(){

	year =parseInt(document.getElementById("currentYear").value);
	month=parseInt(document.getElementById("currentMonth").value);
	day  =parseInt(document.getElementById("currentDay").value);
	destination = document.getElementById("destinationId").value;
	display =  document.getElementById("displayType").value ;
 	basicTheme=document.getElementById("basicTheme").value ;
			time_format=document.getElementById("timming").value ;
			diff_Yr=document.getElementById("diff_Year").value ;

	month -= 1;
	if(month<1){ 
		month = 12;
		year -= 1;
		if( year==0 ) year = -1;
	}
		if(display=="isDiv")
		{
			time_format=document.getElementById("timming").value ;
					document.getElementById("textid").innerHTML=generateCalendar(year,month,day,destination,display,"divID","",time_format,diff_Yr);
			hideShowCovered(document.getElementById("divID"))
		}
		else
		{
				generateCalendar(year,month,day,destination,display,"divID",basicTheme,time_format,diff_Yr);
		}

	
}

//
// nextMonth()
//
function nextMonth(){
	
	year =parseInt(document.getElementById("currentYear").value);
	month=parseInt(document.getElementById("currentMonth").value);
	day  =parseInt(document.getElementById("currentDay").value);
	destination = document.getElementById("destinationId").value;
	display =  document.getElementById("displayType").value ;
	basicTheme=document.getElementById("basicTheme").value ;
			time_format=document.getElementById("timming").value ;
			diff_Yr=document.getElementById("diff_Year").value ;

	month += 1;
	if(month>12){
		month = 1;
		year += 1;
		if( year==0 ) year = 1;
	}
	if(display=="isDiv")
	{
		time_format=document.getElementById("timming").value ;
					document.getElementById("textid").innerHTML=generateCalendar(year,month,day,destination,display,"divID","",time_format,diff_Yr);
		hideShowCovered(document.getElementById("divID"))
	}
	else
	{
				generateCalendar(year,month,day,destination,display,"divID",basicTheme,time_format,diff_Yr);
	
}
}
//
// nextYear()
//
function nextYear(){
	
		year =parseInt(document.getElementById("currentYear").value);
		month=parseInt(document.getElementById("currentMonth").value);
		day  =parseInt(document.getElementById("currentDay").value);
		destination = document.getElementById("destinationId").value;
		display =  document.getElementById("displayType").value ;
		basicTheme=document.getElementById("basicTheme").value ;
		time_format=document.getElementById("timming").value ;
		diff_Yr=document.getElementById("diff_Year").value ;
	year += 1;
	// Remember that there was no year zero:
	if( year==0 ) year = 1;
	if(display=="isDiv")
	{
		time_format=document.getElementById("timming").value ;
					document.getElementById("textid").innerHTML=generateCalendar(year,month,day,destination,display,"divID","",time_format,diff_Yr);
		hideShowCovered(document.getElementById("divID"))
	}
	else
	{
				generateCalendar(year,month,day,destination,display,"divID",basicTheme,time_format,diff_Yr);
	}

	
}

//
// generateCalendar()
//
// Arguments: Year, Month, Day, and the ID of the target element.
//
// This function creates the popup calendar.  Clicking on a date
// populates the target element with the chosen date in ISO 8601
// YYYY-MM-DD format (for Common Era years: years before Common Era
// are prefixed with a negative sign) and closes the popup window.
//
function generateCalendar(Y, M, D,targetId,isModal,divId,basicTheme1,time_format,diff_Year){

		
	// Names of the Months:
	var Month = new Array("January","February","March","April","May","June","July","August","September","October","November","December");
	var Month = new Array('MuHarram','Safar','Rabi`al-Awwal','Rabi`ath-Thani','Jumada l-Ula','Jumada t-Tania','Rajab','Sha`ban','Ramadan','Shawwal','Dhu l-Qa`da','Dhu l-Hijja');
	var Month = new Array('Ù?Ù?Ø­Ù?Ø±Ù?Ù?Ù?','ØµÙ?Ù?Ù?Ø±','Ø±Ù?Ø¨Ù?Ù?Ø¹ Ø§Ù?Ø£Ù?Ù?Ù?Ù? ','Ø±Ù?Ø¨Ù?Ù?Ø¹ Ø§Ù?Ø«Ù?Ù?Ø§Ù?Ù?','Ø¬Ù?Ù?Ù?Ø§Ø¯ Ø§Ù?Ø£Ù?Ù?Ù?Ù?','Ø¬Ù?Ù?Ù?Ø§Ø¯ Ø§Ù?Ø«Ù?Ù?Ø§Ù?Ù?','Ø±Ù?Ø¬Ù?Ø¨','Ø´Ù?Ø¹Ù?Ø¨Ù?Ø§Ù?','Ø±Ù?Ù?Ù?Ø¶Ù?Ø§Ù?','Ø´Ù?Ù?Ù?Ù?Ø§Ù?','Ø°Ù?Ù? Ø§Ù?Ù?Ù?Ù?Ø¹Ù?Ø¯Ù?Ø©','Ø°Ù?Ù? Ø§Ù?Ù?Ø­Ù?Ø¬Ù?Ù?Ø©');
	// Days of the Week:
	//var Day = new Array("Sun","Mon","Tue","Wed","Thu","Fri","Sat");
	//var Day = new Array( 'S' , 'S', 'M', 'T', 'W', 'T', 'F');
	var Day = new Array( 'Ø§Ù?Ø³Ù?Ù?Ø¨Ù?Øª' , 'Ø§Ù?Ø£Ø­Ù?Ø¯', 'Ø§Ù?Ø¥Ø«Ù?Ù?Ù?Ù?Ù?Ù?', 'Ø§Ù?Ø«Ù?Ù?Ù?Ø§Ø«Ù?Ø§Ø¡', 'Ø§Ù?Ø£Ø±Ù?Ø¨Ù?Ø¹Ù?Ø§Ø¡', 'Ø§Ù?Ù?Ø®Ù?Ù?Ù?Ù?Ø³', 'Ø§Ù?Ù?Ø¬Ù?Ù?Ù?Ø¹Ù?Ø©');
	
	//var Day = new Array( 'S', 'M', 'T', 'W', 'T', 'F', 'S');
	
	
	// Digits (if you want to use something other than Arabic-Indic digits):
	 var Digits = new Array("0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31");
      
       
      	
	//var daysInMonth = new Array(29,30,29,30,29,30,29,30,29,30,29,29);
	var daysInMonth = new Array(30,29,30,29,30,29,30,29,30,29,30,29);
	//var adaysInMonth = new Array(30,29,30,31,30,31,30,31,30,31,30,31);
	var daysInAWeek=7;
	var OutputString;
	var difference = 0;
	if ( (diff_Year != '') && (diff_Year != undefined) && (diff_Year != 'undefined') && (diff_Year != null)  )
	{
		difference = eval(diff_Year);
	}
	
	var day="";
	var month="";
		var year="";
	var thisDay = getTodayIslamic();
	
	
	
	if( Y=="" || isNaN(Y) ){
		thisYear=thisDay[0];
	}else{
		thisYear=parseInt(Y);
	}
	// Get month:
	if( M=="" || isNaN(M) ){
		thisMonth=thisDay[1];
	}else{
		thisMonth=parseInt(M);
		if(thisMonth<1) thisMonth=1;
		if(thisMonth>12) thisMonth=12;
	}
	// Get day:
	if( D=="" || isNaN(D) ){
		thisDay=thisDay[2];
	}else{
		thisDay=parseInt(D);
		if(thisDay<0) thisDay=1;
		if(thisDay>30) thisDay=30;
	}
	
	
	if( thisMonth == 12 && leap_islamic(thisYear))
	{
	  daysInMonth[11] = 30;
	}
	
	
	/*thisDay = calcIslamic(thisDay[0],thisDay[1],1);
	alert('this day - '+thisDay);*/
   //till here
	
	
	// Document header:
	OutputString = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0//EN\"\n";
	OutputString += "   \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n";
	OutputString += "<html>\n <head>\n";
	OutputString = "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=EmulateIE6\" >\n";//to render page as IE6 added By Sudhakar
	OutputString += "  <script type=\"text/javascript\" src=\"../js/common.js\"></script>\n";
	OutputString += "  <title>Hijri Calendar</title>\n";
	OutputString += "  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n";
	OutputString += "  <link rel=\"stylesheet\" title=\"Default Style\" href=\"../../eCommon/html/calendar.css\" type=\"text/css\" media=\"screen\">\n";
	OutputString += "  <link rel=\"stylesheet\" title=\"Default Style\" href=\"../../eCommon/html/"+basicTheme+"\" type=\"text/css\" media=\"screen\">\n"; 
	OutputString += "  <script type=\"text/javascript\" src=\"../js/calScript/hj/calendar.js\"></script>\n";
	OutputString += "  <script type=\"text/javascript\" src=\"../js/calScript/hj/amin.js\"></script>\n";
	//OutputString += "  <script type=\"text/javascript\" src=\"../js/CommonCalendar.js\"></script>\n";
	//OutputString += "  <script type=\"text/javascript\" src=\"../js/common.js\"></script> <script>localeName='ar'</script>\n";
	// lin1 616 commented
	

	OutputString += " </head>\n <body id=\"mycal\" class='calendarbody'>\n";

	
	// Start the calendar table with day headings:
	OutputString += "<table border='0' class='calendartable' width='100%'>\n <tr>\n";
	OutputString += " <td class=\"calendarheading\"><div class=\"cssleftstretcharrow\" onclick=\"nextYear()\"><!-- left arrow --></div></td>\n";
	OutputString += " <td class=\"calendarheading\"><div class=\"cssleftarrow\" onclick=\"nextMonth()\"><!-- left arrow --></div></td>\n";
	// Print the month heading:
	OutputString += " <td class=\"calendarheading\" colspan=\"3\">" + Month[ thisMonth-1 ] + "<br>";
	// Print the year heading: If year<0, negate and print "BCE"; if 0<year<1000, print "CE":
	if( thisYear < 0 ) 
		yearString = -thisYear + " BCE";
	else if( thisYear < 1000 ) 
		yearString = thisYear + " CE";
	else 
		yearString = thisYear;
	OutputString += yearString + "</td>\n";
	OutputString += " <td class=\"calendarheading\"><div class=\"cssrightarrow\" onclick=\"previousMonth()\"></div></td>\n";
	OutputString += " <td class=\"calendarheading\"><div class=\"cssrightstretcharrow\" onclick=\"previousYear()\"></div></td>\n";
	OutputString += "</tr>\n <tr>\n";
	//for(i=0;i<daysInAWeek;i++){
	for(i=daysInAWeek-1;i>=0;i--)
	{
		OutputString += "  <th>" + Day[i] + "</th>\n";
	}
	OutputString += " </tr>\n <tr>\n";
	
	// Get the day of week of the first of the month:
	var firstDay=dayOfWeek( julianDay( thisYear, thisMonth, 1 ) ); 


	
	// First week:
	// For Arabic, we just append each td to the beginning of trow:
	var trow="";
	var tcell;
	for(i=0;i<firstDay;i++){
		trow = "  <td onclick=\"previousMonth()\">&nbsp;</td>\n" + trow;
	}
	
	for(d=1;i<daysInAWeek;i++,d++){
		// Special handling for October of 1582:
		if( d==5 && thisMonth==10 && thisYear==1582 ) d+=10;
		tcell = "  <td";

		if(d==thisDay) 
		tcell += " class='thisday'";
		tcell += " onclick=\"setCalDate('"+d+"','"+time_format +"');\">" + Digits[d] + "</td>\n";
		trow = tcell + trow;
	}
	
	OutputString += trow;
	
	// Subsequent weeks;
	var lastDayOfMonth=daysInMonth[thisMonth-1];
	for(j=1;j<6 && d<=lastDayOfMonth;j++){
		OutputString += " </tr>\n <!-- Week " + (j+1) + " -->\n<tr>\n";
		// Days in this month:
		trow="";
		for( i=0; i<daysInAWeek && d<=lastDayOfMonth;i++,d++){  
			tcell = "  <td";
			if(d==thisDay) 
			{
			tcell += " class='thisday'";
			}
			tcell += " onclick=\"setCalDate('"+d+"','"+time_format +"');\">" + Digits[d] + "</td>\n";
			trow = tcell + trow;
		}
		// Finish out the row:
		for(;i<daysInAWeek;i++){
			trow = "  <td onclick=\"nextMonth()\">&nbsp;</td>\n" + trow;      
		}
		OutputString += trow;
	}
	// Finish the HTML, with hidden vars:
	OutputString += "  </tr>\n";
	OutputString += " </table>\n";
	OutputString += " <p>\n";
	OutputString += "  <input type=\"hidden\" id=\"currentYear\" value=\"" + thisYear + "\">\n";
	OutputString += "  <input type=\"hidden\" id=\"currentMonth\" value=\"" + thisMonth + "\">\n";
	OutputString += "  <input type=\"hidden\" id=\"currentDay\" value=\"" + thisDay + "\">\n";
	OutputString += "  <input type=\"hidden\" id=\"destinationId\" value=\"" + targetId + "\">\n";  
	OutputString += "  <input type=\"hidden\" id=\"displayType\" value=\"" + isModal + "\">\n";   
	OutputString += "  <input type=\"hidden\" id=\"basicTheme\" value=\"" + basicTheme + "\">\n";  
	OutputString += "  <input type=\"hidden\" id=\"timming\" value=\"" + time_format + "\">\n";   
	OutputString += "  <input type=\"hidden\" id=\"diff_Year\" value=\"" + diff_Year + "\">\n";   
	OutputString += " </p>\n </body>\n</html>\n";
	
	
	if(isModal=="isDiv")
	{  
		return OutputString;
	}
	else
	{
		document.write(OutputString);
		document.close();
	}

	
}

/* 
The below methods are taken from amin.js for Islamic Calendar related functions
Jalali (Shamsi) Calendar Date Picker Version 1.00 (JavaScript)
*/

/*  MOD  --  Modulus function which works for non-integers.  */

//dispGR(dt)



function mod(a, b)
{
    return a - (b * Math.floor(a / b));
}

function jwday(j)
{
    return mod(Math.floor((j + 1.5)), 7);
}

var Weekdays = new Array( "Sunday", "Monday", "Tuesday", "Wednesday",
                          "Thursday", "Friday", "Saturday" );

//  LEAP_GREGORIAN  --  Is a given year in the Gregorian calendar a leap year ?

function leap_gregorian(year)
{
    return ((year % 4) == 0) &&
            (!(((year % 100) == 0) && ((year % 400) != 0)));
}

//  GREGORIAN_TO_JD  --  Determine Julian day number from Gregorian calendar date

var GREGORIAN_EPOCH = 1721425.5;

function gregorian_to_jd(year, month, day)
{
    return (GREGORIAN_EPOCH - 1) +
           (365 * (year - 1)) +
           Math.floor((year - 1) / 4) +
           (-Math.floor((year - 1) / 100)) +
           Math.floor((year - 1) / 400) +
           Math.floor((((367 * month) - 362) / 12) +
           ((month <= 2) ? 0 :
                               (leap_gregorian(year) ? -1 : -2)
           ) +
           day);
}

//  JD_TO_GREGORIAN  --  Calculate Gregorian calendar date from Julian day

function jd_to_gregorian(jd) {
    var wjd, depoch, quadricent, dqc, cent, dcent, quad, dquad,
        yindex, dyindex, year, yearday, leapadj;

    wjd = Math.floor(jd - 0.5) + 0.5;
    depoch = wjd - GREGORIAN_EPOCH;
    quadricent = Math.floor(depoch / 146097);
    dqc = mod(depoch, 146097);
    cent = Math.floor(dqc / 36524);
    dcent = mod(dqc, 36524);
    quad = Math.floor(dcent / 1461);
    dquad = mod(dcent, 1461);
    yindex = Math.floor(dquad / 365);
    year = (quadricent * 400) + (cent * 100) + (quad * 4) + yindex;
    if (!((cent == 4) || (yindex == 4))) {
        year++;
    }
    yearday = wjd - gregorian_to_jd(year, 1, 1);
    leapadj = ((wjd < gregorian_to_jd(year, 3, 1)) ? 0
                                                  :
                  (leap_gregorian(year) ? 1 : 2)
              );
    month = Math.floor((((yearday + leapadj) * 12) + 373) / 367);
    day = (wjd - gregorian_to_jd(year, month, 1)) + 1;

    return new Array(year, month, day);
}

//  LEAP_ISLAMIC  --  Is a given year a leap year in the Islamic calendar ?

function leap_islamic(year)
{
    return (((year * 11) + 14) % 30) < 11;
}

//  LEAP_PERSIAN  --  Is a given year a leap year in the Persian calendar ?

/*function leap_persian(year)
{
    return ((((((year - ((year > 0) ? 474 : 473)) % 2820) + 474) + 38) * 682) % 2816) < 682;
}

//  PERSIAN_TO_JD  --  Determine Julian day from Persian date

var PERSIAN_EPOCH = 1948320.5;
var PERSIAN_WEEKDAYS = new Array("Ã­Ë?Ã?Ã¤Ã?Ã¥", "Ã?Ã¦Ã?Ã¤Ã?Ã¥",
                                 "Ã?Ã¥ Ã?Ã¤Ã?Ã¥", "Â?Ã¥Ã?Ã?Ã?Ã¤Ã?Ã¥",
                                 "Â?Ã¤Ã? Ã?Ã¤Ã?Ã¥", "Ã?Ã£Ã?Ã¥", "Ã?Ã¤Ã?Ã¥");

function persian_to_jd(year, month, day)
{
    var epbase, epyear;

    epbase = year - ((year >= 0) ? 474 : 473);
    epyear = 474 + mod(epbase, 2820);

    return day +
            ((month <= 7) ?
                ((month - 1) * 31) :
                (((month - 1) * 30) + 6)
            ) +
            Math.floor(((epyear * 682) - 110) / 2816) +
            (epyear - 1) * 365 +
            Math.floor(epbase / 2820) * 1029983 +
            (PERSIAN_EPOCH - 1);
}

//  JD_TO_PERSIAN  --  Calculate Persian date from Julian day



function jd_to_persian(jd)
{
    var year, month, day, depoch, cycle, cyear, ycycle,
        aux1, aux2, yday;


    jd = Math.floor(jd) + 0.5;

    depoch = jd - persian_to_jd(475, 1, 1);
    cycle = Math.floor(depoch / 1029983);
    cyear = mod(depoch, 1029983);
    if (cyear == 1029982) {
        ycycle = 2820;
    } else {
        aux1 = Math.floor(cyear / 366);
        aux2 = mod(cyear, 366);
        ycycle = Math.floor(((2134 * aux1) + (2816 * aux2) + 2815) / 1028522) +
                    aux1 + 1;
    }
    year = ycycle + (2820 * cycle) + 474;
    if (year <= 0) {
        year--;
    }
    yday = (jd - persian_to_jd(year, 1, 1)) + 1;
    month = (yday <= 186) ? Math.ceil(yday / 31) : Math.ceil((yday - 6) / 30);
    day = (jd - persian_to_jd(year, month, 1)) + 1;
    return new Array(year, month, day);
}*/

//  ISLAMIC_TO_JD  --  Determine Julian day from Islamic date

var ISLAMIC_EPOCH = 1948439.5;
var ISLAMIC_WEEKDAYS = new Array("al-'ahad", "al-'ithnayn",
                                 "ath-thalatha'", "al-'arb`a'",
                                 "al-khamis", "al-jum`a", "as-sabt");

function islamic_to_jd(year, month, day)
{
    return (day +
            Math.ceil(29.5 * (month - 1)) +
            (year - 1) * 354 +
            Math.floor((3 + (11 * year)) / 30) +
            ISLAMIC_EPOCH) - 1;
}

//  JD_TO_ISLAMIC  --  Calculate Islamic date from Julian day

function jd_to_islamic(jd)
{
    var year, month, day;

    jd = Math.floor(jd) + 0.5;
    year = Math.floor(((30 * (jd - ISLAMIC_EPOCH)) + 10646) / 10631);
    month = Math.min(12,
                Math.ceil((jd - (29 + islamic_to_jd(year, 1, 1))) / 29.5) + 1);
    day = (jd - islamic_to_jd(year, month, 1)) + 1;
    return new Array(year, month, day);
}

/*function calcPersian(year,month,day)
{
    var date,j;

    j = persian_to_jd(year,month,day);
    date = jd_to_gregorian(j);
    weekday = jwday(j);
    return new Array(date[0], date[1], date[2],weekday);
}*/

function calcIslamic(year,month,day)
{
	var date,j;
	 j = islamic_to_jd(year,month,day);
    date = jd_to_gregorian(j);
    weekday = jwday(j);
	
    return new Array(date[0], date[1], date[2],weekday);

   /* setJulian(islamic_to_jd((new Number(document.islamic.year.value)),
                           document.islamic.month.selectedIndex + 1,
                           (new Number(document.islamic.day.value))));*/
}


//  calcGregorian  --  Perform calculation starting with a Gregorian date
function calcGregorian(year,month,day)
{
    month--;

    var j, weekday;

    //  Update Julian day



    j = gregorian_to_jd(year, month + 1, day) +
           (Math.floor(0 + 60 * (0 + 60 * 0) + 0.5) / 86400.0);
    //  Update Persian Calendar
    perscal = jd_to_islamic(j);
    weekday = jwday(j);
    return new Array(perscal[0], perscal[1], perscal[2],weekday);
}

function getTodayGregorian()
{
    var t = new Date();
    var today = new Date();

    var y = today.getYear();
    if (y < 1000) {
        y += 1900;
    }

    return new Array(y, today.getMonth() + 1, today.getDate(),t.getDay());
}

//function getTodayPersian()
function getTodayIslamic()
{
    var t = new Date();
    var today = getTodayGregorian();

    var islamic = calcGregorian(today[0],today[1],today[2]);
    return new Array(islamic[0],islamic[1],islamic[2]);
}

function getGreg(dt)
{
    //var t = new Date();
    //var today = getTodayGregorian();
    var astrDateArray = new Array();
     var strDay;
    var strMonth;
    var strYear;
    
     astrDateArray = dt.split("/");
    if (astrDateArray.length != 3) {
        return false;
    }
    else {
        strDay = astrDateArray[0];
        strMonth = astrDateArray[1];
        strYear = astrDateArray[2];
    }

    //var islamic = calcGregorian(today[0],today[1],today[2]);
   
   
   var greg = calcIslamic(strYear,strMonth,strDay);
    return new Array(greg[0],greg[1],greg[2],t.getDay());
}

//Function to validate the Date in yyyy/MM/DD
 function CheckDate(Object2) {
    var datefield = Object2;
    if (ChkDate(Object2) == false) {
        alert("Invalid Date Format");
            datefield.focus();
        return false;
    }
    else {
        return true;
    }
}

function ChkDate(Object3) {
    var strDate;
    var strDay;
    var strMonth;
    var strYear;
    var datefield = Object3;
    var strDateArray = new Array();

    strDate = datefield.value;
    if (strDate.length == 0) return true;

if(Object3.value.indexOf('.') > 0) return false;

    strDateArray = strDate.split("/");
    if (strDateArray.length != 3) {
        return false;
    }
    else {
        strDay = strDateArray[0];
        strMonth = strDateArray[1];
        strYear = strDateArray[2];
    }


    if (strYear.length < 4 || strYear.length > 4) return false;

    if (isNaN(strDay)==true) return false;
    if (isNaN(strMonth)==true) return false;
    if (isNaN(strYear)==true) return false;

if((strDay==0)||(strMonth==0)||(strYear==0))  return false;

        if (strMonth>12 || strMonth<1)  return false;

      return true;
}


function convertToHij(greDate){	

	// Names of the Months:
	var Month = new Array("January","February","March","April","May","June","July","August","September","October","November","December");
	var Month = new Array('MuHarram','Safar','Rabi`al-Awwal','Rabi`ath-Thani','Jumada l-Ula','Jumada t-Tania','Rajab','Sha`ban','Ramadan','Shawwal','Dhu l-Qa`da','Dhu l-Hijja');
	var Month = new Array('Ù?Ù?Ø­Ù?Ø±Ù?Ù?Ù?','ØµÙ?Ù?Ù?Ø±','Ø±Ù?Ø¨Ù?Ù?Ø¹ Ø§Ù?Ø£Ù?Ù?Ù?Ù? ','Ø±Ù?Ø¨Ù?Ù?Ø¹ Ø§Ù?Ø«Ù?Ù?Ø§Ù?Ù?','Ø¬Ù?Ù?Ù?Ø§Ø¯ Ø§Ù?Ø£Ù?Ù?Ù?Ù?','Ø¬Ù?Ù?Ù?Ø§Ø¯ Ø§Ù?Ø«Ù?Ù?Ø§Ù?Ù?','Ø±Ù?Ø¬Ù?Ø¨','Ø´Ù?Ø¹Ù?Ø¨Ù?Ø§Ù?','Ø±Ù?Ù?Ù?Ø¶Ù?Ø§Ù?','Ø´Ù?Ù?Ù?Ù?Ø§Ù?','Ø°Ù?Ù? Ø§Ù?Ù?Ù?Ù?Ø¹Ù?Ø¯Ù?Ø©','Ø°Ù?Ù? Ø§Ù?Ù?Ø­Ù?Ø¬Ù?Ù?Ø©');
	// Days of the Week:
	//var Day = new Array("Sun","Mon","Tue","Wed","Thu","Fri","Sat");
	//var Day = new Array( 'S' , 'S', 'M', 'T', 'W', 'T', 'F');
	var Day = new Array( 'Ø§Ù?Ø³Ù?Ù?Ø¨Ù?Øª' , 'Ø§Ù?Ø£Ø­Ù?Ø¯', 'Ø§Ù?Ø¥Ø«Ù?Ù?Ù?Ù?Ù?Ù?', 'Ø§Ù?Ø«Ù?Ù?Ù?Ø§Ø«Ù?Ø§Ø¡', 'Ø§Ù?Ø£Ø±Ù?Ø¨Ù?Ø¹Ù?Ø§Ø¡', 'Ø§Ù?Ù?Ø®Ù?Ù?Ù?Ù?Ø³', 'Ø§Ù?Ù?Ø¬Ù?Ù?Ù?Ø¹Ù?Ø©');
	
	
	// Digits (if you want to use something other than Arabic-Indic digits):
	 var Digits = new Array("0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31");
      
       
      	
	//var daysInMonth = new Array(29,30,29,30,29,30,29,30,29,30,29,29);
	var daysInMonth = new Array(30,29,30,29,30,29,30,29,30,29,30,29);
	//var adaysInMonth = new Array(30,29,30,31,30,31,30,31,30,31,30,31);
	var daysInAWeek=7;
	var OutputString;
	var difference = 0;
	var diff_Year=0;
	var Y="";
	var M="";
	var D="";
	if ( (diff_Year != '') && (diff_Year != undefined) && (diff_Year != 'undefined') && (diff_Year != null)  )
	{
		difference = eval(diff_Year);
	}
	
	var day="";
	var month="";
	var year="";
	var dt_arr=	greDate.split("/");
	
	day=dt_arr[0];
	month=dt_arr[1];
	year=dt_arr[2];
	
	var today = new Date();
	today.setFullYear(year,parseInt(month)-1,day);

    var y = today.getYear();
    if (y < 1000) {
        y += 1900;
    }

    today= new Array(y, today.getMonth() + 1, today.getDate(),today.getDay());

	var islamic = calcGregorian(today[0],today[1],today[2]);
    new Array(islamic[0],islamic[1],islamic[2]);
	thisDay= new Array(islamic[0],islamic[1],islamic[2]);
	
	
	if( Y=="" || isNaN(Y) ){
		thisYear=thisDay[0];
	}else{
		thisYear=parseInt(Y);
	}
	// Get month:
	if( M=="" || isNaN(M) ){
		thisMonth=thisDay[1];
	}else{
		thisMonth=parseInt(M);
		if(thisMonth<1) thisMonth=1;
		if(thisMonth>12) thisMonth=12;
	}
	// Get day:
	if( D=="" || isNaN(D) ){
		thisDay=thisDay[2];
	}else{
		thisDay=parseInt(D);
		if(thisDay<0) thisDay=1;
		if(thisDay>30) thisDay=30;
	}
	
	
	if( thisMonth == 12 && leap_islamic(thisYear))
	{
	  daysInMonth[11] = 30;
	}
	
	if(parseInt(thisDay) <10){
		thisDay="0"+thisDay;
	}
	
	if(parseInt(thisMonth) <10){
		thisMonth="0"+thisMonth;
	}
	
	var hjDT=thisDay+"/"+thisMonth+"/"+ thisYear;
	
	return hjDT;
}





/* End Of Functions from amin.js*/
