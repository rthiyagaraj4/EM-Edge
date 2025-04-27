/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var calendarWindow;
function setDate(day) {
	// Format the date string:
    year = document.getElementById("currentYear").value;
    month = document.getElementById("currentMonth").value;
    isoDateString = formatISODate(year, month, day);
	// Get the destination object id:
    idString = document.getElementById("destinationId").value;
	// Store the value:
    window.opener.document.getElementById(idString).value = isoDateString;
    window.close();
}
function formatISODate(year, month, day) {
	
	// Date delimiter:
    var delimiter = "/";
    if (year < 0) {
        year = -year;
        year = "/" + padWithZeros(year, 4);
    } else {
        year = padWithZeros(year, 4);
    }
    var currDate = new Date()
    
    
    return padWithZeros(day, 2) + delimiter + padWithZeros(month, 2) + delimiter + year+" "+currDate.getHours()+":"+currDate.getMinutes();
}

//
// previousYear()
//
function previousYear() {
    year = parseInt(document.getElementById("currentYear").value);
    month = parseInt(document.getElementById("currentMonth").value);
    day = parseInt(document.getElementById("currentDay").value);
    destination = document.getElementById("destinationId").value;
    year -= 1;
	// Remember that there was no year zero:
    if (year == 0) {
        year = -1;
    }
	//
	// NOTE BENE: The generateCalendar() function *MUST* be called
	// from the "window.opener" window.  Otherwise, if you just call
	// "generateCalendar()" from *this* window, then the "opener"
	// property becomes the calendar popup window itself in the new
	// incarnation of the calendar window -- instead of being
	// the form window -- and then you would be stuck with no
	// way to access the form elements in the main form window!
	// 
    if (calendarWindow.type == "WINDOW") {
        window.opener.generateCalendar(year, month, day, destination, true);
    } else {
        generateCalendar(year, month, day, destination);
    }
}

//
// previousMonth()
//
function previousMonth() {
    year = parseInt(document.getElementById("currentYear").value);
    month = parseInt(document.getElementById("currentMonth").value);
    day = parseInt(document.getElementById("currentDay").value);
    destination = document.getElementById("destinationId").value;
    month -= 1;
    if (month < 1) {
        month = 12;
        year -= 1;
        if (year == 0) {
            year = -1;
        }
    }
    if (calendarWindow.type == "WINDOW") {
        window.opener.generateCalendar(year, month, day, destination, true);
    } else {
        generateCalendar(year, month, day, destination);
    }
}

//
// nextMonth()
//
function nextMonth() {
    year = parseInt(document.getElementById("currentYear").value);
    month = parseInt(document.getElementById("currentMonth").value);
    day = parseInt(document.getElementById("currentDay").value);
    destination = document.getElementById("destinationId").value;
    month += 1;
    if (month > 12) {
        month = 1;
        year += 1;
        if (year == 0) {
            year = 1;
        }
    }
    if (calendarWindow.type == "WINDOW") {
        window.opener.generateCalendar(year, month, day, destination, true);
    } else {
        generateCalendar(year, month, day, destination);
    }
}

//
// nextYear()
//
function nextYear() {
    year = parseInt(document.getElementById("currentYear").value);
    month = parseInt(document.getElementById("currentMonth").value);
    day = parseInt(document.getElementById("currentDay").value);
    destination = document.getElementById("destinationId").value;
    year += 1;
	// Remember that there was no year zero:
    if (year == 0) {
        year = 1;
    }
    if (calendarWindow.type == "WINDOW") {
        window.opener.generateCalendar(year, month, day, destination, true);
    } else {
        generateCalendar(year, month, day, destination);
    }
}
function callCalendar(objectId, popup) {
    var dateString = document.getElementById(objectId).value;
    dateString=Trim(dateString);
    if(dateString.indexOf(" ")!=-1)
		dateString=dateString.split(" ")[0];
	// Normalize possibly variant delimiters to the ISO preferred delimiter:
    var re = new RegExp("[/. ]", "gi");
    dateString = dateString.replace(re, "-");
	// Split the date string:
    var year, month, day;
    if (dateString != "") {
        dateComponents = dateString.split("-");
        /*
	year = dateComponents[0];
	month = dateComponents[1];
	day = dateComponents[2];
	*/
        if (dateComponents.length == 3) {
            year = dateComponents[2];
            month = dateComponents[1];
            day = dateComponents[0];
        }
        if (month.indexOf("0") == 0) {
            month = month.charAt(1);
        }
    }
    generateCalendar(year, month, day, objectId, popup);
}
function generateCalendar(Y, M, D, targetId, popup) {
//alert(2)
	// Names of the Months:
    var Month = new Array("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
	
	// Days of the Week:
    var Day = new Array("Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat");
	// Digits (if you want to use something other than Arabic-Indic digits):
	// var Digits = new Array("0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31");
    var daysInMonth = new Array(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);
    var daysInAWeek = 7;
    var OutputString;
	
	// Guard against arguments that are really passed as strings:
	// Get year:
    var today = new Date();
    if (Y == "" || isNaN(Y)) {
        thisYear = today.getYear();
    } else {
        thisYear = parseInt(Y);
    }
	// Get month:
    if (M == "" || isNaN(M)) {
        thisMonth = today.getMonth() + 1;
    } else {
        thisMonth = parseInt(M);
        if (thisMonth < 1) {
            thisMonth = 1;
        }
        if (thisMonth > 12) {
            thisMonth = 12;
        }
    }
	// Get day:
    if (D == "" || isNaN(D)) {
        thisDay = today.getDate();
    } else {
        thisDay = parseInt(D);
        if (thisDay < 0) {
            thisDay = 1;
        }
        if (thisDay > 31) {
            thisDay = 31;
        }
    }
	
	// Calculate the number of days in February:
    if ((thisYear % 4) == 0) {
        daysInMonth[1] = 29;
        if ((thisYear % 100) == 0 && (thisYear % 400) != 0) {
            daysInMonth[1] = 28;
        }
    }
	
	// Document header:
    OutputString = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0//EN\"\n";
    OutputString += "   \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n";
    OutputString += "<html>\n <head>\n";
    OutputString += "  <title>Gladiator Calendar</title>\n";
    OutputString += "  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n";
    OutputString += "  <link rel=\"stylesheet\" title=\"Default Style\" href=\"/eHIS-DS/framework/css/calendar.css\" type=\"text/css\" media=\"screen\">\n";
    OutputString += "  <script type=\"text/javascript\" src=\"/eHIS-DS/framework/js/javascript/calendar.js\"></script>\n";
    OutputString += "  <script type=\"text/javascript\" src=\"/eHIS-DS/framework/js/javascript/calendarExtra.js\"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
\n";
    OutputString += "  <script>calendarWindow=window.opener.calendarWindow;</script>\n";
    OutputString += " </head>\n <body id=\"mycal\">\n";
	
	// Start the calendar table with day headings:
    OutputString += "<table border='1'>\n <tr>\n";
    OutputString += " <td class=\"calendarheading\"><div class=\"cssleftstretcharrow\" onclick=\"previousYear()\"><!-- left arrow --></div></td>\n";
    OutputString += " <td class=\"calendarheading\"><div class=\"cssleftarrow\" onclick=\"previousMonth()\"><!-- left arrow --></div></td>\n";
	// Print the month heading:
    OutputString += " <td class=\"calendarheading\" colspan=\"3\">" + Month[thisMonth - 1] + "<br>";
	// Print the year heading: If year<0, negate and print "BCE"; if 0<year<1000, print "CE":
    if (thisYear < 0) {
        yearString = -thisYear + " BCE";
    } else {
        if (thisYear < 1000) {
            yearString = thisYear + " CE";
        } else {
            yearString = thisYear;
        }
    }
    OutputString += yearString + "</td>\n";
    OutputString += " <td class=\"calendarheading\"><div class=\"cssrightarrow\" onclick=\"nextMonth()\"><!-- right arrow --></div></td>\n";
    OutputString += " <td class=\"calendarheading\"><div class=\"cssrightstretcharrow\" onclick=\"nextYear()\"><!-- right arrow --></div></td>\n";
    OutputString += "</tr>\n <tr>\n";
    for (i = 0; i < daysInAWeek; i++) {
        OutputString += "  <th>" + Day[i] + "</th>\n";
    }
    OutputString += " </tr>\n <tr>\n";
	
	// Get the day of week of the first of the month:
    var firstDay = dayOfWeek(julianDay(thisYear, thisMonth, 1)); 
	//alert( Day[ firstDay ] );
	
	// First week:
    for (i = 0; i < firstDay; i++) {
        OutputString += "  <td onclick=\"previousMonth()\">&nbsp;</td>\n";
    }
    for (d = 1; i < daysInAWeek; i++, d++) {
		// Special handling for October of 1582:
        if (d == 5 && thisMonth == 10 && thisYear == 1582) {
            d += 10;
        }
        OutputString += "  <td";
        if (d == thisDay) {
            OutputString += " class='thisday'";
        }
        OutputString += " onclick=\"setDate(" + d + ")\">" + d + "</td>\n";
    }
	
	// Subsequent weeks;
    var lastDayOfMonth = daysInMonth[thisMonth - 1];
    for (j = 1; j < 6 && d <= lastDayOfMonth; j++) {
        OutputString += " </tr>\n <!-- Week " + (j + 1) + " -->\n<tr>\n";
		// Days in this month:
        for (i = 0; i < daysInAWeek && d <= lastDayOfMonth; i++, d++) {
            OutputString += "  <td";
            if (d == thisDay) {
                OutputString += " class='thisday'";
            }
            OutputString += " onclick=\"setDate(" + d + ")\">" + d + "</td>\n";
        }
		// Finish out the row:
        for (; i < daysInAWeek; i++) {
            OutputString += "  <td onclick=\"nextMonth()\">&nbsp;</td>\n";
        }
    }
	// Finish the HTML, with hidden vars:
    OutputString += "  </tr>\n";
    OutputString += " </table>\n";
    OutputString += " <p>\n";
    OutputString += "  <input type=\"hidden\" id=\"currentYear\" value=\"" + thisYear + "\">\n";
    OutputString += "  <input type=\"hidden\" id=\"currentMonth\" value=\"" + thisMonth + "\">\n";
    OutputString += "  <input type=\"hidden\" id=\"currentDay\" value=\"" + thisDay + "\">\n";
    OutputString += "  <input type=\"hidden\" id=\"destinationId\" value=\"" + targetId + "\">\n";
    OutputString += " </p>\n </body>\n</html>\n";
    actVal = targetId.substring(targetId.lastIndexOf(".") + 1);

//	var calendarWindow
    if (calendarWindow != null) {
        if (calendarWindow.popupWindow != null) {
            if (calendarWindow.popupWindow.closed) {
                calendarWindow.popupWindow = null;
            }
        }
    }
    if (!popup) {
        calendarWindow = new PopupWindow("calWindow");
        calendarWindow.showPopup(("calControl_" + actVal));
    } else {
        if (calendarWindow == null) {
            calendarWindow = new PopupWindow();
        }
    }
    calendarWindow.populate(OutputString);
    calendarWindow.setUrl("");
    calendarWindow.setSize(200, 200);
    calendarWindow.autoHide();
    if (calendarWindow.popupWindow != null) {
       // alert(calendarWindow.popupWindow.closed);
        if (calendarWindow.popupWindow.closed) {
            calendarWindow.showPopup(("calControl_" + actVal));
        }
    }
    if (calendarWindow.popupWindow == null) {
//alert("calControl_" + actVal)
        calendarWindow.showPopup(("calControl_" + actVal));
    } else {
//	alert(77)
        calendarWindow.refresh();
    }
}


