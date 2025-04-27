/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var currentDateElement;
var calend;
var time;
var fmt;
 
var dateObject;
	function isDatevalid(bool)
	{
		if(!bool)
		{
			assignDate(null,true);
		}
	}
	function assignDate(val,flag)
	{
		if(val!=null)
		{
			dateObject = val;
		}		
		if(flag)
		{
			var key_value = "";
			getServerMessage("com.iba.ehis.dateValidation");
			alert(dwrMessage)
			//alert("Invalid Date Format");
			dateObject.focus();	
			if(dateObject)
			dateObject.value="";
		}
	}


function showCal(id, format, showsTime, showsOtherMonths ,name)
{
	fmt=format;


// Only if we can show the dhtml calendar
			//if(document.body.offsetWidth>250 && document.body.offsetHeight > 250)
		if(document.body.offsetWidth>320 && document.body.offsetHeight > 220)
		{
			showCalendar(id, format, showsTime, showsOtherMonths);
		}
		// Display in the Modal window
		else
		{
			calend=format;
			if (showsTime) {
	     		time = true;				
    		}
    		else
    		{
    			time = false;
    		}
			
			var cal;
			currentDateElement=document.getElementById(id);
			cal = new PopupWindow();
			cal.offsetX=50;
			cal.offsetY=50;
			cal.setSize(250,200);
			cal.autoHide();
			cal.setUrl(contextPath+"/framework/jsp/Calendar.jsp");			
			cal.refresh();
			cal.showPopup(name);
			
			
			
			return false;
	}
}
// This function gets called when the end-user clicks on some date.
function selected(cal, date) {
  cal.sel.value = date; // just update the date in the input field.
  if (cal.dateClicked )
    // if we add this call we close the calendar on single-click.
    // just to exemplify both cases, we are using this only for the 1st
    // and the 3rd field, while 2nd and 4th will still require double-click.
    cal.callCloseHandler();
}

// And this gets called when the end-user clicks on the _selected_ date,
// or clicks on the "Close" button.  It just hides the calendar without
// destroying it.
function closeHandler(cal) {
  cal.hide();                        // hide the calendar
//  cal.destroy();
  _dynarch_popupCalendar = null;
}
// This function shows the calendar under the element having the given id.
// It takes care of catching "mousedown" signals on document and hiding the
// calendar if the click was outside.
function showCalendar(id, format, showsTime, showsOtherMonths ,name) {

  var el = document.getElementById(id);
  var c;
  if (_dynarch_popupCalendar != null) {
    // we already have some calendar created
    _dynarch_popupCalendar.hide();                 // so we hide it first.
  } else {
   // first-time call, create the calendar.
  
    var cal = new Calendar(1, null, selected, closeHandler);
    // uncomment the following line to hide the week numbers
    // cal.weekNumbers = false;
    if (showsTime) {	
      cal.showsTime = true;
      cal.time24 = (showsTime == "24");

    }
	
    //cal.weekNumbers=true;
    if (showsOtherMonths) {
      cal.showsOtherMonths = true;
    }
    cal.singleClick=false;
	_dynarch_popupCalendar = cal;                  // remember it in the global var
	cal.setRange(1900, 3000);        // min/max year allowed.
    cal.create();
   }
   
   // alert('in showCalendar');
  _dynarch_popupCalendar.setDateFormat(format);    // set the specified date format
  //alert('format'+format)
 // alert('el.value'+el.value);
 // var year_val=local_parse(el.value,format);
  //alert('year_val'+year_val);
 // alert('before parseDate'+el.value);
  if(el.value!="")
  {
	_dynarch_popupCalendar.parseDate(el.value);  
  }
 // alert('after parseDate');
      // try to parse the text in field
  _dynarch_popupCalendar.sel = el;                 // inform it what input field we use
  
  // the reference element that we pass to showAtElement is the button that
  // triggers the calendar.  In this example we align the calendar bottom-right
  // to the button.
   _dynarch_popupCalendar.showAtElement(el.nextSibling, "Br");        // show the calendar
  
  return false;
}

