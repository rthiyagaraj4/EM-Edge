package jsp_servlet._portal._jsp._schedule;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import portalrefimpl.contactreason.common.model.ContactReasonModel;
import portalrefimpl.contactreason.rescheduleapptrequest.response.ContactReasonResponse;
import portalrefimpl.contactreason.rescheduleapptrequest.svc.ContactReasonServiceInvoker;
import portalrefimpl.contactreason.rescheduleapptrequest.request.ContactReasonRequest;
import portalrefimpl.schedule.createappointment.AppointmentTime;
import portalrefimpl.schedule.createappointment.AppointmentTimeResponse;
import portalrefimpl.schedule.ScheduleConstants;
import portalrefimpl.schedule.createappointment.AppointmentTimeRequest;
import portalrefimpl.schedule.createappointment.response.TimeSlot;
import java.util.List;
import portalrefimpl.schedule.createappointment.response.PractitionerTimeSlotResponse;
import portalrefimpl.schedule.createappointment.svc.serviceinvoker.PractitionerTimeSlotServiceInvoker;
import java.util.Locale;
import portalrefimpl.schedule.createappointment.request.PractitionerTimeSlotRequest;
import portalrefimpl.schedule.createappointment.CreateAppointmentConstants;
import portalrefimpl.schedule.ScheduleHelper;
import portalrefimpl.PortalHelper;
import java.util.Date;
import portalrefimpl.schedule.apptrequestdetails.response.DetailsResponse;
import portalrefimpl.schedule.apptrequestdetails.svc.DetailsServiceInvoker;
import portalrefimpl.schedule.apptrequestdetails.request.DetailsRequest;
import portalrefimpl.schedule.rescheduleappointment.RescheduleRequestConstants;
import portalrefimpl.PortalConstants;

public final class __reschedulestatusandtimeslot extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

    private static void _releaseTags(javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag t) {
        while (t != null) {
            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, t);
            if(t instanceof javax.servlet.jsp.tagext.Tag) {
                javax.servlet.jsp.tagext.Tag tmp = (javax.servlet.jsp.tagext.Tag)t;
                t = ((javax.servlet.jsp.tagext.Tag) t).getParent();
                try {
                    tmp.release();
                } catch(java.lang.Exception ignore) {}
            }
            else {
                t = ((javax.servlet.jsp.tagext.SimpleTag)t).getParent();
            }
        }
    }

    public boolean _isStale(){
        boolean _stale = _staticIsStale((weblogic.servlet.jsp.StaleChecker) getServletConfig().getServletContext());
        return _stale;
    }

    public static boolean _staticIsStale(weblogic.servlet.jsp.StaleChecker sci) {
        if (sci.isResourceStale("/portal/jsp/schedule/RescheduleStatusAndTimeSlot.jsp", 1669269355984L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

    private static byte[] _getBytes(java.lang.String block){
        try {
            return block.getBytes(_WL_ORIGINAL_ENCODING);
        } catch (java.io.UnsupportedEncodingException u){
            _WL_ENCODED_BYTES_OK = false;
        }
        return null;
    }

    private final static java.lang.String  _wl_block0 ="\r\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n<html>\r\n<head>\r\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n<title>::: Patient Portal - Reschedule Appointment Request</title>\r\n\r\n<meta name=\"keywords\" content=\"\" />\r\n<meta name=\"description\" content=\"\" />\r\n<link rel=\"stylesheet\" href=\"../../css/style.css\" type=\"text/css\" />\r\n<link rel=\"stylesheet\" href=\"../../css/style_ie.css\" type=\"text/css\" />\r\n<link href=\"../../css/examples-offline.css\" rel=\"stylesheet\">\r\n<link href=\"../../css/kendo.common.min.css\" rel=\"stylesheet\">\r\n<link href=\"../../css/kendo.default.min.css\" rel=\"stylesheet\">\r\n\r\n<script src=\"../../js/jquery.min.js\"></script>\r\n<script src=\"../../js/kendo.web.min.js\"></script>\r\n<script src=\"../../js/console.js\"></script>\r\n<script>\r\n $(document).ready(function() {\r\n         var today = new Date();\r\n      // create DatePicker from input HTML element\r\n         $(\"#preferredDateFromPage\").kendoDatePicker({\r\n        \t    format: \"dd/MM/yyyy\"\r\n         });\r\n      \t\r\n         var preferredDate;\r\n         var monthDates = [];\r\n         \r\n         // this is where the code to get the practitioner schedule\r\n         // should be called\r\n         var xmlHttp = getHttpObject();\r\n     \txmlHttp.onreadystatechange=function(){\r\n     \t\tif(xmlHttp.readyState==4 && xmlHttp.status==200){\r\n     \t\t\tvar responseText = xmlHttp.responseText;\r\n     \t\t\tvar dataObj = ((JSON && JSON.parse(responseText)));\r\n     \t\t\tvar objLength = dataObj.length;\r\n     \t\t\tvar errorMessage;\r\n     \t\t\tvar scheduleDate;\r\n     \t\t\tvar scheduleStatus;\r\n     \t\t\t\r\n     \t\t\tfor(count=0;count<objLength;count++){\r\n     \t\t\t\terrorMessage = dataObj[count].errorMessage;\r\n     \t\t\t\terrorMessage = trimText(errorMessage);\r\n     \t\t\t\tscheduleDate = dataObj[count].scheduleDate;\r\n     \t\t\t\tscheduleDate = trimText(scheduleDate);\r\n     \t\t\t\tscheduleStatus = dataObj[count].scheduleStatus;\r\n     \t\t\t\tscheduleStatus = trimText(scheduleStatus);\r\n     \t\t\t\t\r\n     \t\t\t\t//alert(errorMessage+\"||\"+scheduleDate+\"||\"+scheduleStatus);\r\n     \t\t\t\t// this is the error scenario\r\n     \t\t\t\t// show the error message in the GUI\r\n     \t\t\t\tif(errorMessage.length > 0){\r\n     \t\t\t\t\tvar errorMessageSpanComp = document.getElementById(\"errorMessageSpan\");\r\n     \t\t\t\t\tvar errorMessageDivComp = document.getElementById(\"errorMessageDiv\");\r\n     \t\t\t\t\tif(errorMessageSpanComp && errorMessageDivComp){\r\n     \t\t\t\t\t\terrorMessageSpanComp.innerHTML = errorMessage;\r\n     \t\t\t\t\t\terrorMessageDivComp.style.display = \"block\";\r\n     \t\t\t\t\t}else{\r\n     \t\t\t\t\t\t// just a safe handling - somehow user should\r\n     \t\t\t\t\t\t// get to know that an error has occurred\r\n     \t\t\t\t\t\talert(\"errorMessage=\"+errorMessage);\r\n     \t\t\t\t\t}\r\n     \t\t\t\t\tcontinue;\r\n     \t\t\t\t}\r\n     \t\t\t\t\r\n     \t\t\t\t// this is for initializing the preferred date which is nothing\r\n     \t\t\t\t// but the date starting from which user would view the schedule\r\n     \t\t\t\t// for example if user has selected preferred date as 28/03/2013\r\n     \t\t\t\t// then user would view the schedule starting from 28/03/2013\r\n     \t\t\t\t// and ending at one month from the starting date\r\n     \t\t\t\tif(count == 0){\r\n     \t\t\t\t\t// the date value will be in the format \"dd/MM/yyyy\"\r\n     \t\t\t\t\t// hence there is no need to have safe checks\r\n     \t\t\t\t\tvar dateIndex = scheduleDate.indexOf(\"/\");\r\n     \t\t\t\t\tvar dateStr = scheduleDate.substring(0,dateIndex);\r\n     \t\t\t\t\tvar dateVal = getIntValue(dateStr,0);\r\n     \t\t\t\t\t\r\n     \t\t\t\t\tvar monthIndex = scheduleDate.indexOf(\"/\",dateIndex+1);\r\n     \t\t\t\t\tvar monthStr = scheduleDate.substring(dateIndex+1,monthIndex);\r\n     \t\t\t\t\tvar monthVal = getIntValue(monthStr,0);\r\n     \t\t\t\t\t\r\n     \t\t\t\t\tvar yearStr = scheduleDate.substring(monthIndex+1,scheduleDate.length);\r\n     \t\t\t\t\tvar yearVal = getIntValue(yearStr,0);\r\n     \t\t\t\t\t// initialize the preferred date\r\n     \t\t\t\t\tpreferredDate = new Date(yearVal,monthVal-1,dateVal);\r\n     \t\t\t\t}\r\n     \t\t\t\tmonthDates[+new Date(preferredDate.getFullYear(),preferredDate.getMonth(),(preferredDate.getDate()+count))] = scheduleStatus;\r\n     \t\t\t\t\r\n     \t\t\t}\r\n     \t\t\t\r\n     \t\t\t//check if the obj length is more than 1 - this indicates\r\n     \t\t\t// that schedule informationn is present\r\n     \t\t\tif(objLength > 1){\r\n     \t\t\t\t$(\"#PreferredDateInTimeSlot\").kendoCalendar({\r\n        \t             value: preferredDate,\r\n        \t             dates: monthDates,\r\n        \t             month:{\r\n        \t               content:\'# if (typeof data.dates[+data.date] === \"string\") { #\' +\r\n        \t                       \'<div style=\"max-height:30px;\">\' +\r\n        \t                       \'#= data.value #\' +\r\n        \t                       //\'<br>\'+\r\n        \t                       \'<span class=\"#= data.dates[+data.date] #\">\' +\r\n        \t                       \'</span>\' +\r\n        \t                       \'</div>\' +\r\n        \t                       \'# } else { #\' +\r\n        \t                       \'#= data.value #\' +\r\n        \t                       \'# } #\'\r\n        \t             },\r\n        \t             footer: \" #=kendo.toString(data, \'d\') #\",\r\n        \t             format: \"dd/MM/yyyy\" \r\n        \t         });\r\n     \t\t\t}else{\r\n     \t\t\t\t// schedule status is not available for the \r\n     \t\t\t\t// selected practitioner and the selected date\r\n     \t\t\t\t// but still the calendar should be shown\r\n     \t\t\t\tvar hdnPreferredDateElem = document.getElementById(\'hdnPreferredDate\');\r\n     \t\t\t\tif(hdnPreferredDateElem){\r\n     \t\t\t\t\tpreferredDate = hdnPreferredDateElem.value;\r\n     \t\t\t\t}\r\n     \t\t\t\t$(\"#PreferredDateInTimeSlot\").kendoCalendar({\r\n       \t             value: preferredDate,\r\n\t       \t          footer: \" #=kendo.toString(data, \'d\') #\",\r\n\t \t             format: \"dd/MM/yyyy\" \r\n\t \t         });\r\n     \t\t\t}\r\n     \t\t\t\r\n     \t\t}\r\n     \t}\r\n     \t// call the servlet to get the schedule status\r\n     \txmlHttp.open(\"POST\", \"./PractitionerScheduleStatusServlet\", true);\r\n     \txmlHttp.setRequestHeader(\"Content-type\",\"application/x-www-form-urlencoded\");\r\n     \t// form the \r\n     \tvar parameters = getPractitionerScheduleStatusParameters();\r\n     \txmlHttp.send(parameters); \r\n      \r\n });\r\n \r\n function getPractitionerScheduleStatusParameters(){\r\n\t // this function gets the URL parameters needed for calling the schedule status\r\n\t // servlet\r\n \tvar parameters = \"\";\r\n \t// speciality\r\n \tvar hdnSpecialityCode = document.getElementById(\"hdnSpecialtyId\");\r\n \tvar specialityCode=\"\";\r\n \tif(hdnSpecialityCode){\r\n \t\tspecialityCode = hdnSpecialityCode.value;\r\n \t}\r\n \tparameters +=\"hdnSelectedSpeciality=\"+specialityCode;\r\n \tparameters +=\"&\";\r\n \t\r\n \t// facility\r\n \tvar hdnFacility = document.getElementById(\"hdnFacilityId\");\r\n \tvar facility=\"\";\r\n \tif(hdnFacility){\r\n \t\tfacility = hdnFacility.value;\r\n \t}\r\n \tparameters +=\"Facility=\"+facility;\r\n \tparameters +=\"&\";\r\n \t\r\n \t// preferred date\r\n \t//var preferredDateComp = document.getElementById(\"hdnPreferredDate\");\r\n \tvar preferredDateComp = document.getElementById(\"hdnPreferredDateInTimeSlotFrame\");//timeslotSelectedDate\");\r\n \tvar preferredDate=\"\";\r\n \tif(preferredDateComp){\r\n \t\tpreferredDate = preferredDateComp.value;\r\n \t}\r\n \tparameters +=\"hdnPreferredDate=\"+preferredDate;\r\n \tparameters +=\"&\";\r\n \t\r\n \t// preferred from time\r\n \tvar preferredFromTimeComp = document.getElementById(\"timeslotSelectedFromTime\");\r\n \tvar preferredFromTime=\"\";\r\n \tif(preferredFromTimeComp){\r\n \t\tpreferredFromTime = preferredFromTimeComp.value;\r\n \t}\r\n \tparameters +=\"ApptPreferredFromTime=\"+preferredFromTime;\r\n \tparameters +=\"&\";\r\n \t\r\n \t// preferred to time\r\n \tvar preferredToTimeComp = document.getElementById(\"timeslotSelectedToTime\");\r\n \tvar preferredToTime=\"\";\r\n \tif(preferredToTimeComp){\r\n \t\tpreferredToTime = preferredToTimeComp.value;\r\n \t}\r\n \tparameters +=\"ApptPreferredToTime=\"+preferredToTime;\r\n \tparameters +=\"&\";\r\n \t\r\n \t// practitioner id\r\n \tvar practitionerIdComp = document.getElementById(\"selectedPractitionerIdInPage\");\r\n \tvar practitionerId=\"\";\r\n \tif(practitionerIdComp){\r\n \t\tpractitionerId = practitionerIdComp.value;\r\n \t}\r\n \tparameters +=\"hdnPractitionerId=\"+practitionerId;\r\n \tparameters +=\"&\";\r\n \t\r\n \t// clinic code\r\n \tvar clinicCodeComp = document.getElementById(\"hdnClinicCode\");\r\n \tvar clinicCode = \"\";\r\n \tif(clinicCodeComp){\r\n \t\tclinicCode = clinicCodeComp.value;\r\n \t}\r\n \tparameters += \"hdnClinicCode=\"+clinicCode;\r\n \t\r\n \treturn parameters;\r\n }\r\n \r\n function getPractitionerList(){\r\n   // this function is invoked when user clicks on search button\r\n   // in the left hand side page\r\n   var validationMessage = \"\";\r\n \r\n   // first validate the fields in the GUI\r\n   var datePickerComp = document.getElementById(\"preferredDateFromPage\");\r\n   var datePicker = $(\"#preferredDateFromPage\").data(\"kendoDatePicker\");\r\n   var preferredApptDate;\r\n\t// get the preferred date from the date picker component or\r\n   // the generalized element\r\n   if(datePickerComp){\r\n\t   if(datePicker){\r\n\t\t   preferredApptDate = datePicker.value();\r\n\t\t   //alert(\'date picker value=\'+preferredApptDate);\r\n\t   }else{\r\n\t\t   var dateValue = datePickerComp.value;\r\n\t\t   preferredApptDate = getDateObject(dateValue);\r\n\t\t   //preferredApptDate = new Date(dateValue);\r\n\t\t   //alert(\'date comp value=\'+dateValue+\' \'+(typeof dateValue)+\' \'+preferredApptDate);\r\n\t\t   //alert(Date.parse(dateValue));\r\n\t   }\r\n   }\r\n     \r\n    if(isNaN(preferredApptDate)){\r\n \t   validationMessage = \"Preferred date is not valid. \\n\";\r\n    }\r\n   \r\n  \tvar currentDate = new Date();\r\n\t // time validation\r\n\tvar selectedFromTimeComp = document.getElementById(\"fromTimeInPage\");\r\n\tvar selectedFromTimeIndex;\r\n\tvar selectedFromTime = \"\";\r\n\tif(selectedFromTimeComp){\r\n\t\tselectedFromTimeIndex = selectedFromTimeComp.selectedIndex;\r\n\t\tselectedFromTime = selectedFromTimeComp.value;\r\n\t}\r\n\t\r\n\tvar selectedToTimeIndex;\r\n\tvar selectedToTimeComp = document.getElementById(\"toTimeInPage\");\r\n\tvar selectedToTime = \"\";\r\n\tif(selectedToTimeComp){\r\n\t\tselectedToTimeIndex = selectedToTimeComp.selectedIndex;\r\n\t\tselectedToTime = selectedToTimeComp.value;\r\n\t\tselectedToTime = trimText(selectedToTime);\r\n\t}\r\n\t\r\n\tvar selectedTimeIsInvalid = false;\r\n\tif(selectedFromTime.length == 0 && selectedToTime.length == 0){\r\n\t\tvalidationMessage += \"Appointment start and end time is not specified. \\n\";\r\n\t\tselectedTimeIsInvalid = true;\r\n\t}else if(selectedFromTime.length == 0){\r\n\t\tvalidationMessage += \"Appointment start time is not specified. \\n\";\r\n\t\tselectedTimeIsInvalid = true;\r\n\t}else if(selectedToTime.length == 0){\r\n\t\tvalidationMessage += \"Appointment end time is not specified. \\n\";\r\n\t\tselectedTimeIsInvalid = true;\r\n\t}\r\n\t\t\r\n\tvar dotIndex = selectedFromTime.indexOf(\".\");\r\n\tvar hrsStr = \"\";\r\n\tvar hrs = 0;\r\n\tvar minsStr = \"\";\r\n\tvar mins = 0;\r\n\tif(dotIndex > 0){\r\n\t\thrsStr = selectedFromTime.substring(0,dotIndex);\r\n\t\tminsStr = selectedFromTime.substring(dotIndex+1,selectedFromTime.length);\r\n\t\ttry{\r\n\t\t\thrs = parseInt(hrsStr);\t\r\n\t\t}catch(e){\r\n\t\t\thrs = 0;\r\n\t\t}\r\n\t\ttry{\r\n\t\t\tmins = parseInt(minsStr);\r\n\t\t}catch(e){\r\n\t\t\tmins = 0;\r\n\t\t}\r\n\t}\r\n\t// set the hours, minutes and the seconds\r\n\t// seconds will be set to 0 now\r\n\tif(!(isNaN(preferredApptDate))){\r\n\t\tpreferredApptDate.setHours(hrs);\r\n\t\tpreferredApptDate.setMinutes(mins);\r\n\t\tpreferredApptDate.setSeconds(0);\r\n\t\t\r\n\t\t// validate the appointment start time with current date only\r\n\t\t// when the start time is selected properly by user\r\n\t\tif((preferredApptDate < currentDate) && !selectedTimeIsInvalid){\r\n\t\t\tvalidationMessage += \"Appointment start time cannot be less than current time. \\n\";\r\n\t\t}\r\n\t}\r\n\t\t\r\n\t// validate the appointment start time with appointment end time only\r\n\t// when the start time and end time is selected properly by user\t\r\n\tif((selectedFromTimeIndex > selectedToTimeIndex) && !selectedTimeIsInvalid){\r\n\t\tvalidationMessage += \"Appointment start time cannot be greater than or equal to end time. \\n\";\r\n\t}\r\n\t\r\n\t// speciality and facility validation\r\n\t// first speciality\r\n\tvar hiddenSpecialityComp = document.getElementById(\"hdnSpecialtyId\");\r\n\tvar selectedSpeciality=\"\";\r\n\tif(hiddenSpecialityComp){\r\n\t\tselectedSpeciality = hiddenSpecialityComp.value;\r\n\t\tselectedSpeciality = trimText(selectedSpeciality);\r\n\t}\r\n\tif(selectedSpeciality.length == 0){\r\n\t\tvalidationMessage += \"Speciality is invalid. \\n\";\r\n\t}\r\n\t\t\r\n\t// validate selected facility\r\n\tvar selectedFacility = \"\";\r\n\tvar facilityComp = document.getElementById(\"hdnFacilityId\");\r\n\tif(facilityComp){\r\n\t\tselectedFacility = facilityComp.value;\r\n\t\tselectedFacility = trimText(selectedFacility);\r\n\t}\r\n\t\r\n\tif(selectedFacility.length == 0){\r\n\t\tvalidationMessage += \"Selected facility is invalid. \\n\";\r\n\t}\r\n\t\t\r\n\t// finally show the validation message\r\n\tif(validationMessage.length > 0){\r\n\t\talert(validationMessage);\r\n\t\treturn;\r\n\t}\r\n\t\t\r\n\t// need to set the values of hdnSelectedSpeciality,hdnSelectedSpecialityDesc\r\n\t//hdnPreferredDate - it is enough to set the hdnpreferreddate with value\r\n\t// hdnselectedspeciality and hdnselectedspecialitydesc is already set\r\n\t// with values\r\n\t//var dateTimePicker = $(\"#ApptPreferredDate\").data(\"kendoDatePicker\");\r\n\t//var preferredApptDate = dateTimePicker.value();\r\n\tvar dateValue = \"\"+preferredApptDate.getDate()+\"/\"+(preferredApptDate.getMonth()+1)+\"/\"+preferredApptDate.getFullYear();\r\n\tvar hdnPreferredDateComp = document.getElementById(\"hdnPreferredDate\");\r\n\tif(hdnPreferredDateComp){\r\n\t\thdnPreferredDateComp.value = dateValue;\r\n\t}\r\n\t // finally all validations have passed - submit the form\r\n\tvar formElement = document.getElementById(\"rescheduleTimeslotForm\");\r\n\t if(formElement){\r\n\t\t formElement.action = \"./ApptRequestDetailsServlet\";\r\n\t\t formElement.submit();\r\n\t }\r\n  }\r\n \r\n function checkTimeSlot(){\r\n \t// this function is invoked when check time slot button\r\n \t// is clicked by the user\r\n \t// this function merely submits the form in this page\r\n \tvar preferredDateInTimeSlot = document.getElementById(\"PreferredDateInTimeSlot\");\r\n \tvar hdnPreferredDateInTimeSlot = document.getElementById(\"hdnPreferredDateInTimeSlotFrame\");\r\n \tvar preferredDateCalendar = $(\"#PreferredDateInTimeSlot\").data(\"kendoCalendar\");\r\n \tif(preferredDateInTimeSlot && hdnPreferredDateInTimeSlot){\r\n \t\tvar preferredDate;\r\n \t\tvar preferredDateObj;\r\n \t\tif(preferredDateCalendar){\r\n \t\t\tpreferredDate = preferredDateCalendar.value();\r\n \t\t\t//alert(preferredDate);\r\n \t\t\tpreferredDateObj = new Date(preferredDate);\r\n \t\t\tif(preferredDateObj){\r\n \t\t\t\tpreferredDate = \"\"+preferredDateObj.getDate()+\"/\"+(preferredDateObj.getMonth()+1)+\"/\"+preferredDateObj.getFullYear();\r\n \t\t\t}\r\n \t\t}else{\r\n \t\t\tpreferredDate = preferredDateInTimeSlot.value;\r\n \t\t\talert(\'Cannot proceed to get timeslot for selected date \'+hdnPreferredDateInTimeSlot.value+\'. System error\');\r\n \t\t\treturn false;\r\n \t\t}\r\n \t\t//alert(preferredDate);\r\n \t\thdnPreferredDateInTimeSlot.value = preferredDate;\r\n \t}\r\n \t\r\n \tvar formElement = document.getElementById(\"rescheduleTimeslotForm\");\r\n \tif(formElement){\r\n \t\tformElement.action = \"./ScheduleStatusAndTimeslotServlet\";\r\n \t\tformElement.submit();\r\n \t}\r\n }\r\n \r\n function selectTimeSlot(timeSlotElement,divId){\r\n\t   // this function sets the selected time slot element\'s style\r\n\t   // also sets the selected time slot value to a hidden variable\r\n\t   // also modifies the text of the selected time slot label shown in GUI\r\n\t   // this function is modified to pass the divid of the selected time slot\r\n\t   var previousSelectedDivId;\r\n\t   var hdnSelectedTimeSlotDivElement = document.getElementById(\"hdnSelectedTimeSlotDivId\");\r\n\t   if(hdnSelectedTimeSlotDivElement){\r\n\t\t   previousSelectedDivId = hdnSelectedTimeSlotDivElement.value;\r\n\t\t   var previousSelectedDiv = document.getElementById(previousSelectedDivId);\r\n\t\t   if(previousSelectedDiv){\r\n\t\t\t   var styleClassName = previousSelectedDiv.className;\r\n\t\t\t   if(\'timeselectionnormal evenrow\' == styleClassName){\r\n\t\t\t\t   previousSelectedDiv.style.background =  \"#F2F2F2\";\r\n\t\t\t   }else if(\'timeselectionnormal oddrow\' == styleClassName){\r\n\t\t\t\t   previousSelectedDiv.style.background =  \"#EBEBEB\";\r\n\t\t\t   }else if(\'timeselectionpreferred\' == styleClassName){\r\n\t\t\t\t   previousSelectedDiv.style.background =  \"#FCFAC8\";\r\n\t\t\t   }\r\n\t\t   }\r\n\t\t   // finally set the currently selected time slot\'s div id\r\n\t\t   // as the value of the hidden element\r\n\t\t   hdnSelectedTimeSlotDivElement.value = divId;\r\n\t   }\r\n\t   timeSlotElement.style.background = \"#73A30A\";\r\n\t   // sets the selected time slot value to a hidden variable\r\n\t   var selectedTimeSlot = timeSlotElement.innerHTML;\r\n\t   selectedTimeSlot = trimText(selectedTimeSlot);\r\n\t   // now set the background color of the currently selected time slot\r\n\t   var hdnSelectedTimeSlotElement = document.getElementById(\'hdnSelectedTimeSlot\');\r\n\t   if(hdnSelectedTimeSlotElement){\r\n\t\t   hdnSelectedTimeSlotElement.value = selectedTimeSlot;\r\n\t   }\r\n\t   //modifies the text of the selected time slot label shown in GUI\r\n\t   var selectedSpan = document.getElementById(\'selectedtimespan\');\r\n\t   if(selectedSpan){\r\n\t\t   selectedSpan.innerHTML = selectedTimeSlot;\r\n\t   }\r\n }\r\n \r\n function confirmRescheduleRequest(){\r\n   // this function shows the confirmation dialog\r\n   // to the user before proceeding to reschedule an appointment request\r\n   \r\n   // validate if time slot and reason for reschedule is selected\r\n   // first validate if any time slot is selected\r\n\t// preferred time slot\r\n   var validationMessage = \"\";\r\n   var selectedTimeSlotComp = document.getElementById(\"hdnSelectedTimeSlot\");\r\n   var selectedTimeSlot = \"\";\r\n   if(selectedTimeSlotComp){\r\n\t   selectedTimeSlot = selectedTimeSlotComp.value;\r\n\t   if(selectedTimeSlot.length == 0){\r\n\t\t   validationMessage += \'Time slot is not selected for the appointment request. \\n\';\r\n\t\t   //alert(\'Time slot is not selected for the appointment request\');\r\n\t\t   //return false;\r\n\t   }\r\n   }\r\n   \r\n   var reasonCodeCombo = document.getElementById(\"rescheduleReasonCode\");\r\n   var reasonCode=\'\';\r\n   if(reasonCodeCombo){\r\n\t   reasonCode = reasonCodeCombo.value;\r\n   }\r\n   \r\n   if(reasonCode.length == 0){\r\n\t   validationMessage += \"Reason for reschedule is not selected.\\n\";\r\n   }\r\n   \r\n   if(validationMessage.length > 0){\r\n\t   alert(validationMessage);\r\n\t   return false;\r\n   }\r\n   \r\n  // need to get the practitioner name, selected specialty\r\n   // appointment date and time\r\n   var practNameComp = document.getElementById(\"selectedPractitionerNameInPage\");\r\n   var practName = \"\";\r\n   if(practNameComp){\r\n\t   practName = practNameComp.value;\r\n\t   practName = escape(practName);\r\n   }\r\n   \r\n   var selectedSpecialtyComp = document.getElementById(\"hdnSpecialtyDesc\");\r\n   var selectedSpecailty = \"\";\r\n   if(selectedSpecialtyComp){\r\n\t   selectedSpecialty = selectedSpecialtyComp.value;\r\n\t   selectedSpecialty = escape(selectedSpecialty);\r\n   }\r\n   \r\n   // preferred date\r\n   var datePickerComp = document.getElementById(\"PreferredDateInTimeSlot\");\r\n   var dateTimePicker = $(\"#PreferredDateInTimeSlot\").data(\"kendoCalendar\");\r\n   var preferredApptDate;\r\n   if(datePickerComp){\r\n\t   if(dateTimePicker){\r\n\t\t   preferredApptDate = dateTimePicker.value();\r\n\t   }else{\r\n\t\t   preferredApptDate = new Date(datePickerComp.value);\r\n\t   }\r\n   }\r\n   //var preferredApptDate = dateTimePicker.value();\r\n   var dateValue = \"\"+preferredApptDate.getDate()+\"/\"+(preferredApptDate.getMonth()+1)+\"/\"+preferredApptDate.getFullYear();\r\n   // escape sequence for the selected time slot\r\n   selectedTimeSlot = escape(selectedTimeSlot);\r\n   \r\n   var confirmPopupURL = \"./ConfirmBookRequest.jsp?practitionerName=\"+practName;\r\n   confirmPopupURL += \"&specialty=\"+selectedSpecialty;\r\n   confirmPopupURL += \"&preferredDate=\"+dateValue;\r\n   confirmPopupURL += \"&selectedTimeSlot=\"+selectedTimeSlot;\r\n   \r\n   // load the div with URL\r\n    $(\'#requestConfirmDiv\').load(confirmPopupURL);\r\n    \r\n\tif (document.getElementById(\'requestConfirmContainerDiv\').style.visibility == \'hidden\') {\r\n       document.getElementById(\'requestConfirmContainerDiv\').style.visibility = \'\';\r\n       $(\"#requestConfirmContainerDiv\").hide();\r\n    }\r\n    if (document.getElementById(\'requestConfirmDiv\').style.visibility == \'hidden\') {\r\n       document.getElementById(\'requestConfirmDiv\').style.visibility = \'\';\r\n       $(\"#requestConfirmDiv\").hide();\r\n    }\r\n\t\r\n\t$(\"#requestConfirmContainerDiv\").fadeIn(200, \"linear\", function () { $(\"#requestConfirmDiv\").show(300, \"swing\"); });\r\n\t   \r\n }\r\n \r\n function closeConfirmRescheduleApptReqPopup(){\r\n   // this function will close the confirm popup dialog\r\n   // also submits this page\r\n   // submit is done as a work around for an issue\r\n\t$(\"#requestConfirmDiv\").hide(\'300\', \"swing\", function () { $(\"#requestConfirmContainerDiv\").fadeOut(\"200\"); });\r\n   \r\n\tvar formElement = document.getElementById(\"rescheduleTimeslotForm\");\r\n   \tif(formElement){\r\n   \t\tformElement.action = \"./ScheduleStatusAndTimeslotServlet\";\r\n   \t\tformElement.submit();\r\n   \t}\r\n }\r\n \r\n function rescheduleApptRequest(){\r\n\t // this function will reschedule the appointment request based\r\n\t // on the configuration done already in the page\r\n\t // first hide the confirmation dialog\r\n     $(\"#requestConfirmDiv\").hide(\'200\', \"swing\", function () { $(\"#requestConfirmContainerDiv\").fadeOut(\"100\"); });\r\n\t \r\n\t// This function will book the appointment for the user\r\n\tvar serializeStr = $(\"#rescheduleTimeslotForm\").serialize();\r\n\tvar bookAppointmentURL = \"./RescheduleApptReqServlet?\"+serializeStr;\r\n    $(\'#rescheduleApptContentDiv\').load(bookAppointmentURL);\r\n\t   \r\n   if (document.getElementById(\'rescheduleApptRequestContainerDiv\').style.visibility == \'hidden\') {\r\n       document.getElementById(\'rescheduleApptRequestContainerDiv\').style.visibility = \'\';\r\n       $(\"#rescheduleApptRequestContainerDiv\").hide();\r\n    }\r\n    if (document.getElementById(\'rescheduleApptContentDiv\').style.visibility == \'hidden\') {\r\n       document.getElementById(\'rescheduleApptContentDiv\').style.visibility = \'\';\r\n       $(\"#rescheduleApptContentDiv\").hide();\r\n    }\r\n\t\t\r\n\t$(\"#rescheduleApptRequestContainerDiv\").fadeIn(200, \"linear\", function () { $(\"#rescheduleApptContentDiv\").show(300, \"swing\"); });\r\n\t \r\n }\r\n \r\n function postRescheduleApptRequest(errorCodeStr){\r\n\t// this function will hide the popup which is shown after the\r\n   // reschedule appointment operation is performed\r\n   // this function will also forward the request to a suitable page\r\n   \r\n   // first hide the popup\r\n   $(\"#rescheduleApptContentDiv\").hide(\'200\', \"swing\", function () { $(\"#rescheduleApptRequestContainerDiv\").fadeOut(\"100\"); });\r\n   var actionURL = \'\';\r\n   \r\n   // this is for successful reschedule appt request\r\n   if(errorCodeStr == \'2\'){\r\n\t  actionURL = \"./UpcomingAppointments.jsp\" ;\r\n   }else if(errorCodeStr == \'1\'){\r\n\t   actionURL = \'./ApptRequestDetailsServlet\';\r\n\t   var refNumberComp = document.getElementById(\"referenceNumber\");\r\n\t   var refNumber=\'\';\r\n\t   if(refNumberComp){\r\n\t\t   refNumber = refNumberComp.value;\r\n\t\t   actionURL += \"?referenceNumber=\"+refNumber;\r\n\t   }\r\n   }\r\n   \r\n   var formElement = document.getElementById(\"rescheduleTimeslotForm\");\r\n   if(formElement){\r\n\t   formElement.action = actionURL;\r\n\t   formElement.submit();\r\n   }\r\n }\r\n \r\n function performOperation(){\r\n\t// this function performs the main operation in this page\r\n\trescheduleApptRequest();\r\n }\r\n \r\n function cancelOperation(){\r\n\t// this function cancels the main operation in this page\r\n\tcloseConfirmRescheduleApptReqPopup();\r\n }\r\n \r\n function postOperation(errorCodeStr){\r\n\t// this function performs some more actions post\r\n\t// the main operation\r\n\tpostRescheduleApptRequest(errorCodeStr);\r\n }\r\n \r\n function getHttpObject(){\r\n\t // this function gets the XMLHttpRequest object for use in Ajax calls\r\n\tvar xmlHttp;\r\n\tif (window.XMLHttpRequest) {\r\n\t\txmlHttp = new XMLHttpRequest();\r\n\t} else if (window.ActiveXObject) {\r\n\t\txmlHttp = new ActiveXObject(\"Microsoft.XMLHTTP\");\r\n\t}\r\n\treturn xmlHttp;\r\n}\r\n \r\n function trimText(textVal){\r\n\t // this function trims a given text\r\n   \t var l=0; var r=textVal.length -1;\r\n   \t while(l < textVal.length && textVal[l] == \' \'){\r\n   \t\t  l++;\r\n   \t }\r\n   \t\t\r\n   \t while(r > l && textVal[r] == \' \'){\r\n   \t\tr-=1;\r\n   \t }\r\n   \t textVal = textVal.substring(l, r+1);\r\n   \t \r\n   \t return textVal;\r\n}\r\n \r\n function getIntValue(stringValue,defaultValue){\r\n \t// this function converts the string value to an integer value\r\n \tvar intVal = defaultValue;\r\n \ttry{\r\n \t\tintVal = parseInt(stringValue);\t\r\n \t}catch(e){\r\n \t\tintVal = defaultValue;\r\n \t}\r\n \treturn intVal;\r\n }\r\n \r\n \r\n </script>\r\n<style scoped>\r\n    #special-days {\r\n        height: 202px;\r\n        width: 300px;\r\n        margin: 2px auto;\r\n        /*padding: 2px 0 2px 2px;*/\r\n    }\r\n\r\n    #PreferredDateInTimeSlot {\r\n        border-radius: 1px 1px 1px 1px;\r\n        border-style: solid;\r\n        border-width: 1px;\r\n    }\r\n\r\n    .k-header {\r\n        border-radius: 3px 3px 0 0;\r\n    }\r\n\r\n    #PreferredDateInTimeSlot .k-content {\r\n        height: 152px;\r\n        width:262px;\r\n    }\r\n\r\n     .normal {\r\n        /* background: transparent url(../../content/web/calendar/exhibition.png) no-repeat 0 50%; */\r\n        background-color : transparent;\r\n        display: inline-block;\r\n        width: 100%;\r\n        height: 10px;\r\n        vertical-align: middle;\r\n        margin-right: 3px;\r\n    }\r\n    \r\n    .FREE {\r\n    \tbackground-color : #38A1E9;\r\n    \tdisplay: inline-block;\r\n        width: 100%;\r\n        height: 8px;\r\n        vertical-align: middle;\r\n        \r\n    }\r\n    \r\n     .LEAVE {\r\n    \tbackground-color : #E8AF1A;\r\n    \tdisplay: inline-block;\r\n        width: 100%;\r\n        height: 8px;\r\n        vertical-align: middle;\r\n        \r\n    }\r\n    \r\n    .BLOCKED {\r\n    \tbackground-color : #DE3A29;\r\n    \tdisplay: inline-block;\r\n        width: 100%;\r\n        height: 8px;\r\n        vertical-align: middle;\r\n    }\r\n    \r\n    .timeslottd{\r\n    \theight:100%;\r\n    \tmargin-left: 2px;\r\n    \twidth:50%;\r\n    \tmin-width:50%;\r\n    \tborder-right:1px solid #AFAFAF;\r\n    }\r\n    \r\n    .confirmpopupContainerStyle {\r\n      background-color: white;\r\n      opacity: 90%;\r\n      filter:alpha(opacity=90);\r\n      background-color: rgba(255,255,255,0.90); \r\n      width: 100%;\r\n      min-height: 100%;\r\n      overflow: hidden;\r\n      float: absolute;\r\n      position: fixed;\r\n      top: 0;\r\n      left: 0;\r\n      color: white;\r\n      \r\n      /* z-index: -1;\r\n      opacity:0%; */\r\n\t}\r\n\t\r\n\t.confirmpopupContentStyle{\r\n\t  background-color: white;\r\n      color: black;\r\n      \r\n      padding: 2px;\r\n      display:block;\r\n      position: absolute;\r\n      top: 30%;\r\n      left: 30%;\r\n      /* width : 0px;\r\n      height : 0px;\r\n      z-index: -1; */\r\n      width: 582px;\r\n      height: 245px; \r\n\t}\r\n    \r\n    .rescheduleApptContainerStyle {\r\n      background-color: white;\r\n      opacity: 90%;\r\n      filter:alpha(opacity=90);\r\n      background-color: rgba(255,255,255,0.90);\r\n      width: 100%;\r\n      min-height: 100%;\r\n      overflow: hidden;\r\n      float: absolute;\r\n      position: fixed;\r\n      top: 0;\r\n      left: 0;\r\n      color: white;\r\n\t}\r\n\t\r\n\t.rescheduleApptpopupContentStyle{\r\n\t  background-color: white;\r\n      color: black;\r\n      /* border: 1px solid gray; */\r\n      padding: 2px;\r\n      display:block;\r\n      position: absolute;\r\n      top: 30%;\r\n      left: 30%;\r\n      width: 582px;\r\n      height: 242px;\r\n\t}\r\n    \r\n    \r\n </style>   \r\n\r\n\r\n</head>\r\n<body>\r\n\r\n\t";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\r\n\r\n\t<div id=\"wrapper\"  style=\"background-color: #ffffff;\">\r\n\t\t<div class=\"fixedheader\">\r\n\t\t\t<header id=\"header\">\r\n\t\t\t<div id=\"headerinfo\">\r\n\t\t\t\t<div class=\"row\">\r\n\t\t\t\t\t<div id=\"headervisitinfo\">Welcome back! Your last visit was\r\n\t\t\t\t\t\ton Wed, Dec 5, 2012 12:47:08 PM</div>\r\n\t\t\t\t\t<div id=\"headerloginas\">\r\n\t\t\t\t\t\t<strong>Welcome, ";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 =", ID:";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="</strong>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t\t<div id=\"headerlogout\">\r\n\t\t\t\t\t\t<div>\r\n\t\t\t\t\t\t\t<a href=\"../../servlet/LogoutServlet\" class=\"logout\"> Logout</a>\r\n\t\t\t\t\t\t</div>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t</div>\r\n\t\t\t</div>\r\n\t\t\t</header>\r\n\r\n\t\t\t<!-- #header-->\r\n\r\n\t\t\t<!-- #logo And Menu -->\r\n\r\n\t\t\t<div id=\"logomenu\">\r\n\t\t\t\t<div class=\"row\">\r\n\t\t\t\t\t<div id=\"logo\">\r\n\t\t\t\t\t\t<img src=\"../../images/logo.png\">\r\n\t\t\t\t\t</div>\r\n\t\t\t\t\t<div id=\"Menubox\">\r\n\t\t\t\t\t\t<ul class=\"menu\">\r\n\t\t\t\t\t\t\t<li><a href=\"../Contact.jsp\"><div class=\"menuicons\">\r\n\t\t\t\t\t\t\t\t\t\t<img src=\"../../images/Contact.png\" />\r\n\t\t\t\t\t\t\t\t\t</div>Contact</a></li>\r\n\t\t\t\t\t\t\t<li><a href=\"../result/DetailedResult.jsp\"><div\r\n\t\t\t\t\t\t\t\t\t\tclass=\"menuicons\">\r\n\t\t\t\t\t\t\t\t\t\t<img src=\"../../images/Results.png\" />\r\n\t\t\t\t\t\t\t\t\t</div>My Results</a></li>\r\n\t\t\t\t\t\t\t<li class=\"menuselect\"><div class=\"menuicons\">\r\n\t\t\t\t\t\t\t\t\t<img src=\"../../images/Appointment.png\" />\r\n\t\t\t\t\t\t\t\t</div>My Appointments</li>\r\n\t\t\t\t\t\t\t<li><a href=\"../PortalHome.jsp\"><div class=\"menuicons\">\r\n\t\t\t\t\t\t\t\t\t\t<img src=\"../../images/Home.png\" />\r\n\t\t\t\t\t\t\t\t\t</div>Home</a></li>\r\n\t\t\t\t\t\t</ul>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t</div>\r\n\t\t\t</div>\r\n\t\t</div>\r\n\t\t<!-- #logo And Menu -->\r\n\r\n\t\t<div class=\"line\"></div>\r\n\t\t<div id=\"content\" style=\"height:auto;overflow:auto;\">\r\n\t\t\t<form id=\"rescheduleTimeslotForm\" name=\"rescheduleTimeslotForm\" method=\"POST\">\r\n\t\t\t<!-- #Patient Banner-->\r\n\r\n\t\t\t<!-- #Patient Banner-->\r\n\t\t\t<!-- #Content Area-->\r\n\t\t\t<div id=\"contentbg\"></div>\r\n\t\t\t<div id=\"contentArea\">\r\n\r\n\t\t\t\t<div id=\"contentArearow\">\r\n\t\t\t\t\t<div id=\"booknewbreadcrumb\">\r\n\t\t\t\t\t\t<span class=\"contenbold\">\r\n\t\t\t\t\t\t\t<a href=\"./UpcomingAppointments.jsp\" class=\"backpage\">My Appointments</a>\r\n\t\t\t\t\t\t</span> \r\n\t\t\t\t\t\t<span class=\"contenbold\" id=\"arrow\">></span> \r\n\t\t\t\t\t\t<span class=\"contenbold\">Reschedule\tAppointment Request</span>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t\t<div class=\"row\">\r\n\t\t\t\t\t\t<div class=\"cellindex searchindex\">\r\n\t\t\t\t\t\t\t<div id=\"BooknewAppsearch\">\r\n\r\n\t\t\t\t\t\t\t\t<div class=\"BookAppTitle\">\r\n\t\t\t\t\t\t\t\t\t<a class=\"rectitle\"> Modify Search </a>\r\n\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t<div class=\"SearchPanelReschedule\">\r\n\r\n\t\t\t\t\t\t\t\t\t<div class=\"searchfields\">\r\n\t\t\t\t\t\t\t\t\t\t <!--  code to check and show the data -->\r\n                                \t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\r\n                                \t<span class=\"loginerror\">";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</span>\r\n                                \t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\r\n\t\t\t\t\t\t\t\t\t<div class=\"Apptitle\">Specialty</div>\r\n\t\t\t\t\t\t\t\t\t\t<span>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</span>\r\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\r\n\t\t\t\t\t\t\t\t\t</div>\r\n\r\n\t\t\t\t\t\t\t\t\t<div class=\"searchfields\">\r\n\t\t\t\t\t\t\t\t\t\t<div class=\"Apptitle\">Preferred date</div>\r\n\t\t\t\t\t\t\t\t\t\t<!-- <input class=\"textboxdatesearch\" type=\"text\" placeholder=\"30 Jan 2013\"/> -->\r\n\t\t\t\t\t\t\t\t\t\t<input id=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" \r\n\t\t\t\t\t\t\t\t\t\t\tname=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" style=\"width:180px;\" />\r\n\t\t\t\t\t\t\t\t\t</div>\r\n\r\n\t\t\t\t\t\t\t\t\t<div class=\"searchfieldsSpeciality  \">\r\n\t\t\t\t\t\t\t\t\t\t<div class=\"Apptitle \">Preferred time</div>\r\n\t\t\t\t\t\t\t\t\t\t<select class=\"Combotimesearch\" id=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\"\r\n\t\t\t\t\t\t\t\t\t\t\tname=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\r\n\t\t\t\t\t\t\t\t\t\t\t<option value=\"\">Select time</option>\r\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\r\n\t\t\t\t\t\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =">";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</option>\r\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\r\n\t\t\t\t\t\t\t\t\t\t</select> \r\n\t\t\t\t\t\t\t\t\t\t<span id=\"spacing\"></span> \r\n\t\t\t\t\t\t\t\t\t\t<span>to</span> \r\n\t\t\t\t\t\t\t\t\t\t<select class=\"Combotimesearch\"  id=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =" \r\n\t\t\t\t\t\t\t\t\t\t</select>\r\n\t\t\t\t\t\t\t\t\t</div>\r\n\r\n\t\t\t\t\t\t\t\t\t<span class=\"btn marginalign\" onclick=\"getPractitionerList()\">Search</span>\r\n\t\t\t\t\t\t\t\t</div>\r\n\r\n\t\t\t\t\t\t\t</div>\r\n\r\n\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t<div class=\"tablebooknewapp\">\r\n\t\t\t\t\t\t\t<div class=\"row\">\r\n\t\t\t\t\t\t\t\t<div class=\"celldivider\"></div>\r\n\t\t\t\t\t\t\t\t<div class=\"cellindex bookingcell\">\r\n\t\t\t\t\t\t\t\t\t<div id=\"BooknewAppDoctor\" style=\"overflow: auto;\">\r\n\t\t\t\t\t\t\t\t\t\t<div class=\"SelectionView\" style=\"background-image:url(\'../../images/Book.PNG\');height:510px;width:1000px;\">\r\n\r\n\t\t\t\t\t\t\t\t\t\t\t<div id=\"SelectLeftPanel\" style=\"height:500px;width:47.4%;\">\r\n\r\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"currentDetailsRS\" style=\"width:380px;\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"title\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"contenbold\">Current Appointment details</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>Appointment No:</span><span> ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>Date & time: </span> <span>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =", </span> \r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\t- ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\r\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"DoctorAppRescheduletime\"  style=\"width:380px;\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"DoctorDetailStripTimeReschedule\" style=\"width:372px;\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"DoctorInnerstrip\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"SearchImage\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img class=\"SearchdoctorIcon\" src=\"../../images/doctor.png\" />\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"DocDetailsTime\" style=\"width:270px;\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"contenbold\">";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</span><br />\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"contentnormal\">";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</span><br /> <span\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tclass=\"contentnormal\">";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t<!--  this div is only for containing an error message\r\n\t\t\t\t\t\t\t\t\t\t\t\t      if the practitioner schedule status cannot be obtained\r\n\t\t\t\t\t\t\t\t\t\t\t\t -->\r\n\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"errorMessageDiv\" name=\"errorMessageDiv\" style=\"display:none;margin-left:auto;margin-right:auto;min-height: 30px;width:380px;border: 1px solid #CDCDCD;\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t<span id=\"errorMessageSpan\" name=\"errorMessageSpan\" class=\"loginerror\" style=\"padding-left: 10px;\"></span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"bookcontent\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ApptimeReschedule\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"calender\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<!-- <img src=\"../../images/calendar2013.PNG\" /> -->\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\"\r\n\t\t\t               \t\t\t\t\t\t\t\t\t\tname=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" \r\n\t\t\t               \t\t\t\t\t\t\t\t\t\tstyle=\"width: 262px;\">\r\n\t\t\t               \t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"availability\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"available\"></div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tAvailable\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"availability\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"full\"></div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tFull\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"availability\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"leave\"></div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tLeave\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\r\n\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ApptitleReschedule contenbold\">Preferred\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\ttime</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<select class=\"textboxtimeindex\" id=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" \r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tname=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" >\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"\">Select time</option>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</option>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</select> \r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>to</span> \r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<select class=\"textboxtimeindex\" id=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</option>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</select>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"SelectedDate\">Selected date: \r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\r\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\r\n\r\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"centeralign ReschedulebtnBottom\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t<span><a href=\"#\" class=\"PPbtn\" onclick=\"checkTimeSlot()\">Check time slot</a></span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\r\n\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\r\n\r\n\r\n\t\t\t\t\t\t\t\t\t\t\t<div id=\"SelectRightPanel\" style=\"height:500px;\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"timesloterrordiv\" name=\"timesloterrordiv\" style=\"margin-left:auto;margin-right:auto;min-height: 25px;width:445px;border: 1px solid #CDCDCD;padding-top: 5px;\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"loginerror\" style=\"padding-left: 10px;\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t</span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"width:99%;margin:10px;min-height: 300px;\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t<table width=\"98%\" cellpadding=\"0\" cellspacing=\"0\" style=\"border:1px solid #cdcdcd;min-height: 290px;\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<th style=\"height:25px;background-color: #E9E9E9;border-bottom:1px solid #ffffff;border-right:1px solid #AFAFAF;\">AM</th>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<th style=\"height:25px;background-color: #E9E9E9;border-bottom:1px solid #ffffff;\">PM</th>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"border-right:1px solid #AFAFAF;\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"border-right:1px solid #AFAFAF;\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\r\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"preferredtime\"><div id=\"prefer\"></div>Preferred time</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"Selected\">Selected date and time: ";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 =", <span id=\"selectedtimespan\">";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 =" - ";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</span></div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"centeralign ReschedulebtnBottom\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t<span><a class=\"disabled\" style=\"float:center;\">Reschedule appointment</a></span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\r\n\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"timesloterrordiv\" name=\"timesloterrordiv\" style=\"margin-left:auto;margin-right:auto;min-height: 25px;width:445px;border: 1px solid #CDCDCD;padding-top: 5px;\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"loginerror\">Could not get time slot information.\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t</span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"width:99%;margin:10px;min-height: 300px;\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t<table width=\"98%\" cellpadding=\"0\" cellspacing=\"0\" style=\"border:1px solid #cdcdcd;min-height: 290px;\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<th style=\"height:25px;background-color: #E9E9E9;border-bottom:1px solid #ffffff;border-right:1px solid #AFAFAF;\">AM</th>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<th style=\"height:25px;background-color: #E9E9E9;border-bottom:1px solid #ffffff;\">PM</th>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"border-right:1px solid #AFAFAF;\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"border-right:1px solid #AFAFAF;\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\r\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"preferredtime\"><div id=\"prefer\"></div>Preferred time</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"Selected\">Selected date and time: ";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</span></div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"centeralign ReschedulebtnBottom\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t<span><a class=\"disabled\" style=\"float:center;\">Reschedule appointment</a></span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\r\n\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"width:99%;margin:10px;\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t<table width=\"98%\" cellpadding=\"0\" cellspacing=\"0\" style=\"border:1px solid #cdcdcd;\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<th style=\"height:25px;background-color: #E9E9E9;border-bottom:1px solid #ffffff;border-right:1px solid #AFAFAF;\">AM</th>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<th style=\"height:25px;background-color: #E9E9E9;border-bottom:1px solid #ffffff;\">PM</th>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"border-right:1px solid #AFAFAF;\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"timeslottd\" valign=\"top\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<!--  for morning records -->\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table cellpadding=\"0\" cellspacing=\"0\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  <tr>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td height=\"100%\" valign=\"top\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table height=\"100%\"  cellpadding=\"0\" cellspacing=\"0\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\" class=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\" onclick=\"selectTimeSlot(this,\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\')\">";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td height=\"100%\" style=\"margin-left: 2px;\"  valign=\"top\"  width=\"50%\" style=\"min-width:50%;border-right:1px solid #AFAFAF;\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<!--  for evening records -->\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table cellpadding=\"0\" cellspacing=\"0\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td height=\"100%\" valign=\"top\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table cellpadding=\"0\" cellspacing=\"0\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n\r\n\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"preferredtime\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"prefer\"></div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\tPreferred time\r\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"Selected\">Selected date and time: ";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 =",  <span id=\"selectedtimespan\">";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="</span></div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"reasondiv\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t<span>Reason for reschedule</span> \r\n\t\t\t\t\t\t\t\t\t\t\t\t\t<select\tclass=\"reasonCombo\" id=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\" name=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"\">---Select----</option>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\">";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t</select>\r\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\r\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"centeralign ReschedulebtnBottom\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t<span><a href=\"#\" class=\"PPbtn\" onclick=\"confirmRescheduleRequest()\">Reschedule appointment</a></span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\r\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\r\n\r\n\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t</div>\r\n\r\n\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t</div>\r\n\r\n\t\t\t\t\t</div>\r\n\t\t\t\t</div>\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t<!--  hidden components to store data  -->\r\n\t\t\t<!--  preferred date obtained from the var timeslotpreferreddate - stores the date selected in the right panel -->\r\n\t\t\t<input type=\"hidden\" id=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\">\r\n\t\t\t<!--  preferred date from the left panel -->\r\n\t\t\t<input type=\"hidden\" id=\"hdnPreferredDate\" name=\"hdnPreferredDate\" value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\">\r\n\t\t\t<!--  selected from and to times from the left panel -->\r\n\t\t\t<input type=\"hidden\" id=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\">\r\n\t\t\t<input type=\"hidden\" id=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\">\r\n\t\t\t\r\n\t\t\t<!-- selected date from the time slot (right) panel -->\r\n\t\t\t<!-- selected from and to time from the time slot (right) panel -->\r\n\t\t\t<input type=\"hidden\" id=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\">\r\n\t\t\t\r\n\t\t\t\r\n\t\t\t<!-- facility id and description -->\r\n\t\t\t<input type=\"hidden\" id=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\">\r\n       \t\t<input type=\"hidden\" id=\"hdnFacilityDesc\" name=\"hdnFacilityDesc\" value=\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\">\r\n       \t\t<!-- specialty id and description -->\r\n       \t\t<input type=\"hidden\" id=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\">\r\n       \t\t<input type=\"hidden\" id=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\">\r\n\t\t\t\r\n\t\t\t<!-- other data like practitioner id, practitioner name and clinic code -->\r\n\t\t\t<input type=\"hidden\" id=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\">\r\n\t       \t<input type=\"hidden\" id=\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\">\r\n\t\t\t<input type=\"hidden\" id=\"hdnSelectedTimeSlotDivId\" name=\"hdnSelectedTimeSlotDivId\" value=\"\">\r\n\t\t\t<input type=\"hidden\" id=\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\" value=\"\">\r\n\t\t</form>\r\n\t</div>\r\n\t<!-- div to show the reschedule confirmation popup -->\r\n\t<div id=\"requestConfirmContainerDiv\" class=\"confirmpopupContainerStyle\" style=\"visibility:hidden;\">\r\n\t\t<div id=\"requestConfirmDiv\" class=\"confirmpopupContentStyle\" style=\"visibility:hidden;\">\r\n\t\t</div>\r\n\t</div>\r\n\t\t\t\t\r\n\t<!--  div to perform the reschedule appointment request and then show result popup -->\r\n\t<div id=\"rescheduleApptRequestContainerDiv\" class=\"rescheduleApptContainerStyle\" style=\"visibility:hidden;\">\r\n\t\t<div id=\"rescheduleApptContentDiv\" class=\"rescheduleApptpopupContentStyle\" style=\"visibility:hidden;\">\r\n\t\t</div>\r\n\t</div>\r\n\t\r\n\t\r\n\t<!-- #content-->\r\n\t<div class=\"clear\"></div>\r\n\t<div class=\"Footerbg\" style=\"margin-top: 2px;\">\r\n\t\t<div id=\"poweredby\">\r\n\t\t\t<p class=\"poweredby\">\r\n\t\t\t\tPowered by <img src=\"../../images/csc.png\" width=\"25\" height=\"14\">\r\n\t\t\t</p>\r\n\t\t</div>\r\n\t</div>\r\n\r\n </div>\r\n\r\n</body>\r\n</html>\r\n";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=ISO-8859-1");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=ISO-8859-1");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

		String patientId = "";
		patientId = (String) session
				.getAttribute(PortalConstants.PATIENTID_REQUEST_PARAM_KEY);
		//patientId = request.getParameter("patientId");
		if (patientId == null) {
			patientId = (String) getServletConfig().getServletContext()
					.getAttribute("patientId");
			if (patientId == null) {
				patientId = "";
			}
		}

		String patientName = "";
		patientName = (String) session
				.getAttribute(PortalConstants.PATIENTNAME_SESSION_KEY);
		//patientName = request.getParameter("patientName");
		if (patientName == null) {
			patientName = "";
		}
		
		// appointment reference number
		String appointmentReqRefNumber = request.getParameter
				(RescheduleRequestConstants.GET_APPTREQUESTDETAILS_REFNUMBER_PARAM_KEY);
		if(appointmentReqRefNumber == null){
			appointmentReqRefNumber = "";
		}

		// preferred date from the GUI
		String preferredDateFromPage = request.getParameter(RescheduleRequestConstants.APPTREQ_DETAILS_PREFERRED_DATE_PAGE_PARAM);

		// preferred from time from the GUI
		String preferredFromTimePage = request.getParameter(RescheduleRequestConstants.APPTREQ_DETAILS_FROM_TIME_PARAM);

		// preferred to time from the GUI
		String preferredToTimePage = request.getParameter(RescheduleRequestConstants.APPTREQ_DETAILS_TO_TIME_PARAM);

		// selected practitioner from the GUI - it is passed on by RescheduleMain.jsp
		// to this page
		String selectedPractitionerId = request.getParameter(RescheduleRequestConstants.APPTREQ_DETAILS_PRACTITIONERID_PARAM);
		String selectedPractitionerName = request.getParameter(RescheduleRequestConstants.APPTREQ_DETAILS_PRACTITIONERNAME_PARAM);
		String selectedClinicCode = request.getParameter(RescheduleRequestConstants.HIDDEN_CLINIC_CODE_PARAM);
		//String practitionerFromPage = request.getParameter(RescheduleRequestConstants.APPTREQ_DETAILS_PRACTITIONERID_PARAM);
		
		// the selected date and times from the time slot panel in the page
		String timeslotSelectedDate = request.getParameter(RescheduleRequestConstants.HIDDEN_PREFERRED_DATE_TIMESLOT_PARAM);

		String timeslotSelectedFromTime = request.getParameter(RescheduleRequestConstants.RESCHEDULE_TIMESLOT_SELECTEDFROMTIME_PARAM);
		String timeslotSelectedToTime = request.getParameter(RescheduleRequestConstants.RESCHEDULE_TIMESLOT_SELECTEDTOTIME_PARAM);
		

		// get the appointment request details by executing the service
		DetailsRequest detailsRequest = new DetailsRequest();
		detailsRequest.setPatientId(patientId);
		detailsRequest.setApptRequestReferenceNumber(appointmentReqRefNumber);
		detailsRequest.setPortalUserName(PortalConstants.PORTALUSER_REQUEST_PARAM_VALUE);

		DetailsServiceInvoker serviceInvoker = new DetailsServiceInvoker();
		serviceInvoker.registerService(detailsRequest);
		DetailsResponse detailsResponse = (DetailsResponse)serviceInvoker.getDataThroughService(detailsRequest);
		boolean detailsResponseResult = detailsResponse.isSuccessful();
		String errorMessage = detailsResponse.getErrorMessage();

		String facilityId = "";
		String facilityDesc = "";
		// stores the preferred date value which will be
		// filled from the response object
		String preferredDateStr = "";
		// stores the appointment requests preferred time
		String apptPreferredFromTime = null;
		String specialty = "";
		String specialtyId = "";
		// stores the preferred date which will be obtained from response object
		Date preferredDateObj = null;
		Date preferredFromTimeObj = null;
		Date preferredToTimeObj = null;
		// stores the preferred date in display format
		String preferredDateDisplayStr = "";
		// stores the from time in dd/mm/yyy HH:mi format
		String preferredFromTimeStr = "";
		//stores the from time in HH:mi format
		String preferredFromTimeDisplayStr = "";
		//stores the to time in dd/mm/yyy HH:mi format
		String preferredToTimeStr = "";
		//stores the to time in HH:mi format
		String preferredToTimeDisplayStr = "";
		// stores the practitioner name
		String practitionerName = "";
		// if the execution result of appointment request details service
		// is ok - then get the details
		if(detailsResponseResult){
			facilityId = detailsResponse.getFacilityId();
			facilityDesc = detailsResponse.getFacilityName();
			
			specialty = detailsResponse.getSpecialityName();
			specialtyId = detailsResponse.getSpecialityCode();
			preferredDateObj = detailsResponse.getPreferredDate();
			preferredDateStr = PortalHelper.getDateAsString(preferredDateObj,
					RescheduleRequestConstants.APPTREQ_DETAILS_DATE_DISPLAY_FORMAT);
			
			// we have got the details - so get data from it
			// first get the preferred date
			preferredDateDisplayStr = PortalHelper.getDateAsString(preferredDateObj,
					RescheduleRequestConstants.APPTREQ_DETAILS_DATE_DISPLAY_FORMAT2);
			// get the preferred from time from response
			preferredFromTimeStr = detailsResponse.getPreferredFromTime();
			preferredFromTimeObj = PortalHelper.getDateFromString(preferredFromTimeStr, 
						RescheduleRequestConstants.APPTREQ_DETAILS_DATE_TIME_FORMAT);
			/* preferredFromTimeStr = PortalHelper.getDateAsString(preferredFromTimeObj,
					RescheduleRequestConstants.APPTREQ_DETAILS_DATE_TIME_FORMAT); */
			preferredFromTimeDisplayStr = PortalHelper.getDateAsString(preferredFromTimeObj,
					RescheduleRequestConstants.APPTREQ_DETAILS_TIME_FORMAT);
			
			// get the to time and populate the vars
			preferredToTimeStr = detailsResponse.getPreferredToTime();
			preferredToTimeObj = PortalHelper.getDateFromString(preferredToTimeStr, 
					RescheduleRequestConstants.APPTREQ_DETAILS_DATE_TIME_FORMAT);
			/* preferredToTimeStr = PortalHelper.getDateAsString(preferredToTimeObj,
					RescheduleRequestConstants.APPTREQ_DETAILS_DATE_TIME_FORMAT); */
			preferredToTimeDisplayStr = PortalHelper.getDateAsString(preferredToTimeObj,
					RescheduleRequestConstants.APPTREQ_DETAILS_TIME_FORMAT);
			
			// practitioner name
			practitionerName = detailsResponse.getResourceName();
			
			
		}
		
		// if the preferred date obtained from the page is null - then set it
		// to the preferred date obtained from the appointment request details service
		if(preferredDateFromPage == null || preferredDateFromPage.trim().equals("")){
			preferredDateFromPage = preferredDateStr;
		}

		//there is also a need to set the selected from time obtained from the page
		// with a value if user has not selected it
		if(preferredFromTimePage == null || preferredFromTimePage.trim().equals("")){
			preferredFromTimePage = preferredFromTimeDisplayStr;
		}

		// there is also a need to set the selected to time obtained from the page
		// with a value if user has not selected it
		if(preferredToTimePage == null || preferredToTimePage.trim().equals("")){
			preferredToTimePage = preferredToTimeDisplayStr;
		}
		
		// finally initialize the time slot date and times if it is not having value
		if(timeslotSelectedDate == null || timeslotSelectedDate.trim().equals("")){
			timeslotSelectedDate = preferredDateFromPage;	
		}
		
		if(timeslotSelectedFromTime == null || timeslotSelectedFromTime.trim().equals("")){
			timeslotSelectedFromTime = preferredFromTimePage;
		}
		
		if(timeslotSelectedToTime == null || timeslotSelectedToTime.trim().equals("")){
			timeslotSelectedToTime = preferredToTimePage;
		}
		
		
	
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(patientName));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block4Bytes, _wl_block4);

                                		if(!detailsResponseResult){
                                	
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(errorMessage ));
            _bw.write(_wl_block6Bytes, _wl_block6);

                                		}else{
                                	
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(specialty ));
            _bw.write(_wl_block8Bytes, _wl_block8);

                                		}
									
									
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(RescheduleRequestConstants.APPTREQ_DETAILS_PREFERRED_DATE_PAGE_PARAM));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(RescheduleRequestConstants.APPTREQ_DETAILS_PREFERRED_DATE_PAGE_PARAM));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(preferredDateFromPage));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(RescheduleRequestConstants.APPTREQ_DETAILS_FROM_TIME_PARAM));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(RescheduleRequestConstants.APPTREQ_DETAILS_FROM_TIME_PARAM));
            _bw.write(_wl_block14Bytes, _wl_block14);

												// now get the different times
												AppointmentTimeRequest apptFromTimeRequest = new AppointmentTimeRequest(
														ScheduleConstants.BOOKAPPT_START_TIME_IDENTIFIER);
												AppointmentTimeResponse apptFromTimeResponse = ScheduleHelper
														.getAppointmentTimeResponse(apptFromTimeRequest);
												
												// there is no need to worry for errors as of now since
												// the data returned is going to be valid and that too not from db
												List<AppointmentTime> apptStartTimeList = apptFromTimeResponse
														.getAppointmentTimeList();
												String apptTimeValue = null;
												String apptDataValue = null;
												String selected = "";
												// iterate through the list and show the time
												for (AppointmentTime apptTime : apptStartTimeList) {
													selected = "";
													apptTimeValue = apptTime.getAppointmentTime();
													apptDataValue = apptTime.getAppointmentDataValue();
													if(apptDataValue.equals(preferredFromTimePage)){
														selected = "selected";
													}
											
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(apptDataValue));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(selected));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(apptTimeValue));
            _bw.write(_wl_block18Bytes, _wl_block18);

												}
											
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(RescheduleRequestConstants.APPTREQ_DETAILS_TO_TIME_PARAM));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(RescheduleRequestConstants.APPTREQ_DETAILS_TO_TIME_PARAM));
            _bw.write(_wl_block14Bytes, _wl_block14);

											selected = "";
											// now get the different times
											AppointmentTimeRequest apptToTimeRequest = new AppointmentTimeRequest(
													ScheduleConstants.BOOKAPPT_TO_TIME_IDENTIFIER);
											AppointmentTimeResponse apptToTimeResponse = ScheduleHelper
													.getAppointmentTimeResponse(apptToTimeRequest);
											// there is no need to worry for errors as of now since
											// the data returned is going to be valid and that too not from db
											List<AppointmentTime> apptToTimeList = apptToTimeResponse
													.getAppointmentTimeList();
											// iterate through the list and show the time
											for (AppointmentTime apptTime : apptToTimeList) {
												selected = "";
												apptTimeValue = apptTime.getAppointmentTime();
												apptDataValue = apptTime.getAppointmentDataValue();
												if(apptDataValue.equals(preferredToTimePage)){
													selected = "selected";
												}
											
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(apptDataValue));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(selected));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(apptTimeValue));
            _bw.write(_wl_block18Bytes, _wl_block18);

												}
											
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(appointmentReqRefNumber ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(preferredDateDisplayStr ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(preferredFromTimeDisplayStr ));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(preferredToTimeDisplayStr ));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(selectedPractitionerName ));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(specialty ));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(facilityDesc ));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(CreateAppointmentConstants.APPT_PREFERREDDATE_TIMESLOT_PARAMETER_KEY));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(CreateAppointmentConstants.APPT_PREFERREDDATE_TIMESLOT_PARAMETER_KEY));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(RescheduleRequestConstants.RESCHEDULE_TIMESLOT_SELECTEDFROMTIME_PARAM));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(RescheduleRequestConstants.RESCHEDULE_TIMESLOT_SELECTEDFROMTIME_PARAM));
            _bw.write(_wl_block31Bytes, _wl_block31);

																if (apptStartTimeList == null || apptStartTimeList.isEmpty()) {
																	apptFromTimeResponse = ScheduleHelper
																			.getAppointmentTimeResponse(apptFromTimeRequest);
																	apptStartTimeList = apptFromTimeResponse
																			.getAppointmentTimeList();
																}
																selected = "";
																// this var is reset and will be used to
																// store the appointment display value
																apptTimeValue = null;
																// this is for storing the appointment data value
																// appointment data value is being used only
																// for calculating the time slot information
																apptDataValue = null;
																// iterate through the list and show the time
																for (AppointmentTime apptTime : apptStartTimeList) {
																	selected = "";
																	apptTimeValue = apptTime.getAppointmentTime();
																	apptDataValue = apptTime.getAppointmentDataValue();
																	
																	if (timeslotSelectedFromTime.equalsIgnoreCase(apptDataValue)) {
																		selected = "selected";
																	}
																	
																	
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(apptDataValue));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(selected));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(apptTimeValue));
            _bw.write(_wl_block33Bytes, _wl_block33);

																	}
																
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(RescheduleRequestConstants.RESCHEDULE_TIMESLOT_SELECTEDTOTIME_PARAM));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(RescheduleRequestConstants.RESCHEDULE_TIMESLOT_SELECTEDTOTIME_PARAM));
            _bw.write(_wl_block31Bytes, _wl_block31);

															if (apptToTimeList == null || apptToTimeList.isEmpty()) {
																apptToTimeResponse = ScheduleHelper
																		.getAppointmentTimeResponse(apptFromTimeRequest);
																apptToTimeList = apptToTimeResponse.getAppointmentTimeList();
															}
															selected = "";
															// reset the vars used to store the appointment times
															apptTimeValue = null;
															apptDataValue = null;
															// iterate through the list and show the time
															for (AppointmentTime apptTime : apptToTimeList) {
																selected = "";
																apptTimeValue = apptTime.getAppointmentTime();
																apptDataValue = apptTime.getAppointmentDataValue();
																/* if (timeslotToTime.equalsIgnoreCase(apptTimeValue)) {
																	selected = "selected";
																} */
																if (timeslotSelectedToTime.equalsIgnoreCase(apptDataValue)) {
																	selected = "selected";
																}
															
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(apptDataValue));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(selected));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(apptTimeValue));
            _bw.write(_wl_block36Bytes, _wl_block36);

															}
														
            _bw.write(_wl_block37Bytes, _wl_block37);

															String selectedDateDisplayStr = ScheduleHelper
																	.getPreferredDateInDisplayFormat(
																			timeslotSelectedDate,
																			CreateAppointmentConstants.PRACTITIONERSTATUS_DATEFORMAT,
																			CreateAppointmentConstants.PRACTITIONERTIMESLOT_DATE_DISPLAY_FORMAT);
															out.println(selectedDateDisplayStr);
														
            _bw.write(_wl_block38Bytes, _wl_block38);

													// code to get the time slot information
													// initialize the request first
													PractitionerTimeSlotRequest timeSlotRequest = new PractitionerTimeSlotRequest();
													timeSlotRequest.setFacilityId(facilityId);
													timeSlotRequest.setPractitionerId(selectedPractitionerId);
													timeSlotRequest.setClinicCode(selectedClinicCode);
													timeSlotRequest.setClinicType(CreateAppointmentConstants.PRACTITIONERSCHEDULESTATUS_DEFAULT_CLINICTYPE);
													timeSlotRequest.setResourceType(CreateAppointmentConstants.PRACTITIONER_SERVICE_RESOURCECLASS_DEFAULT_VALUE);
													timeSlotRequest.setLocale(Locale.getDefault().getLanguage());
													timeSlotRequest.setPreferredDate(timeslotSelectedDate);
													timeSlotRequest.setPortalUserName(PortalConstants.PORTALUSER_REQUEST_PARAM_VALUE);
													
													// call the time slot web service through its service invoker
													PractitionerTimeSlotServiceInvoker timeSlotServiceInvoker = new PractitionerTimeSlotServiceInvoker();
													timeSlotServiceInvoker.registerService(timeSlotRequest);
													PractitionerTimeSlotResponse timeSlotResponse = (PractitionerTimeSlotResponse)timeSlotServiceInvoker.getDataThroughWebService(timeSlotRequest);
													
													errorMessage = null;
													if(!timeSlotResponse.isSuccessful()){	
														errorMessage = timeSlotResponse.getErrorMessage();
												
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(errorMessage ));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(selectedDateDisplayStr));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(timeslotSelectedFromTime ));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(timeslotSelectedToTime ));
            _bw.write(_wl_block43Bytes, _wl_block43);

													}else{
														List<List<TimeSlot>> morningAndEveningTimeSlots = timeSlotResponse.getMorningAndEveningTimeSlots();
														// no need to check for null - it will be only empty at worst
														if(morningAndEveningTimeSlots.isEmpty()){
												
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(selectedDateDisplayStr));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(timeslotSelectedFromTime ));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(timeslotSelectedToTime ));
            _bw.write(_wl_block45Bytes, _wl_block45);
		
													// successfully got the time slot information
													// so show it
														}else{
															// morning time slots are placed at 0th index
															List<TimeSlot> morningTimeSlots = morningAndEveningTimeSlots.get(0);
															List<TimeSlot> eveningTimeSlots = morningAndEveningTimeSlots.get(1);
															
															String updatedPreferredFromTime = ScheduleHelper.
																	getApptSelectedTimeInDisplayFormat(timeslotSelectedFromTime);
															String updatedPreferredToTime = ScheduleHelper.
																	getApptSelectedTimeInDisplayFormat(timeslotSelectedToTime);
															
															// local vars for use in display
															final int COMP_IN_COLUMN = 7;
															final int NUMBER_OF_COLUMN = 3;
															int columnCounter = 0;
															int compCounter = 0;
															TimeSlot timeSlot = null;
															final String TIMESLOT_ODDCOLUMN_STYLE = "timeselectionnormal oddrow";
															final String TIMESLOT_EVENCOLUMN_STYLE = "timeselectionnormal evenrow";
															final String TIMESLOT_PREFERRED_STYLE = "timeselectionpreferred";
															// this is for the div id
															final String TIMESLOT_DIV_ID = "timeslotDiv";
															String timeSlotDivId = null;
															int divCounter = 0;
															String timeSlotStyle = null;
															boolean timeSlotInPreferredTime = false;
												
            _bw.write(_wl_block46Bytes, _wl_block46);

																if(!morningTimeSlots.isEmpty()){
															
            _bw.write(_wl_block47Bytes, _wl_block47);
			
																	int morningTimeSlotCount = morningTimeSlots.size();
																	 
																	while(columnCounter < NUMBER_OF_COLUMN){
																		
															
            _bw.write(_wl_block48Bytes, _wl_block48);

																		for(int count=0;count<COMP_IN_COLUMN;count++){
																			timeSlotStyle = TIMESLOT_ODDCOLUMN_STYLE;
																			if((columnCounter % 2) == 0){
																				timeSlotStyle = TIMESLOT_EVENCOLUMN_STYLE;	
																			}
																			if(compCounter == morningTimeSlotCount){
																				break;		
																			}
																			// this is for setting the div id
																			divCounter ++;
																			timeSlotDivId = TIMESLOT_DIV_ID + divCounter;
																			timeSlot = morningTimeSlots.get(compCounter);
																			timeSlotInPreferredTime = timeSlot.
																				isTimeSlotInPreferredTimeRange(updatedPreferredFromTime, updatedPreferredToTime);
																			if(timeSlotInPreferredTime){
																				timeSlotStyle = TIMESLOT_PREFERRED_STYLE;
																			}
																
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(timeSlotDivId ));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(timeSlotStyle));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(timeSlotDivId ));
            _bw.write(_wl_block52Bytes, _wl_block52);
out.print(timeSlot.getStartTime()+" - "+timeSlot.getEndTime());compCounter++;
            _bw.write(_wl_block53Bytes, _wl_block53);
					
																		}
																		
																		// need to check this once more 
																		if(compCounter == morningTimeSlotCount){
																	
            _bw.write(_wl_block54Bytes, _wl_block54);
	
																			break;
																		}
																		//compCounter++;
																		columnCounter++;
																	
            _bw.write(_wl_block54Bytes, _wl_block54);
	
																	}
																	
            _bw.write(_wl_block55Bytes, _wl_block55);
	
																}
															
            _bw.write(_wl_block56Bytes, _wl_block56);

																columnCounter = 0;
																compCounter = 0;
																timeSlotStyle = null;
																if(!eveningTimeSlots.isEmpty()){
															
            _bw.write(_wl_block57Bytes, _wl_block57);
		
																	int eveningTimeSlotCount = eveningTimeSlots.size();
																	while(columnCounter < NUMBER_OF_COLUMN){
															
            _bw.write(_wl_block58Bytes, _wl_block58);

																		for(int count=0;count<COMP_IN_COLUMN;count++){
																			timeSlotStyle = TIMESLOT_ODDCOLUMN_STYLE;
																			if((columnCounter % 2) == 0){
																				timeSlotStyle = TIMESLOT_EVENCOLUMN_STYLE;	
																			}
																			if(compCounter == eveningTimeSlotCount){
																				break;		
																			}
																			// this is for setting the div id
																			divCounter ++;
																			timeSlotDivId = TIMESLOT_DIV_ID + divCounter;
																			timeSlot = eveningTimeSlots.get(compCounter);
																			timeSlotInPreferredTime = timeSlot.
																				isTimeSlotInPreferredTimeRange(updatedPreferredFromTime, updatedPreferredToTime);
																			if(timeSlotInPreferredTime){
																				timeSlotStyle = TIMESLOT_PREFERRED_STYLE;
																			}
																
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(timeSlotDivId ));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(timeSlotStyle));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(timeSlotDivId ));
            _bw.write(_wl_block52Bytes, _wl_block52);
compCounter++;out.print(timeSlot.getStartTime()+" - "+timeSlot.getEndTime());
            _bw.write(_wl_block53Bytes, _wl_block53);
					
																		}
																		
																		// need to check this once more 
																		if(compCounter == eveningTimeSlotCount){
																	
            _bw.write(_wl_block54Bytes, _wl_block54);
	
																			break;
																		}
																		//compCounter++;
																		columnCounter++;
																	
            _bw.write(_wl_block54Bytes, _wl_block54);
		
																	}
																	
            _bw.write(_wl_block55Bytes, _wl_block55);
	
																}
															
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(selectedDateDisplayStr ));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(timeslotSelectedFromTime ));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(timeslotSelectedToTime ));
            _bw.write(_wl_block61Bytes, _wl_block61);

												
												// code to get the contact reasons
												ContactReasonRequest contactReasonRequest = new ContactReasonRequest();
												contactReasonRequest.setPortalUserName(PortalConstants.PORTALUSER_REQUEST_PARAM_VALUE);
												contactReasonRequest.setLocale(Locale.getDefault().getLanguage());
												
												ContactReasonServiceInvoker contactClient = new ContactReasonServiceInvoker();
												contactClient.registerService(contactReasonRequest);
												
												ContactReasonResponse contactReasonResponse = (ContactReasonResponse)
															contactClient.getDataThroughWebService(contactReasonRequest);
												
												
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(RescheduleRequestConstants.RESCHEDULE_REASON_CODE_PARAM));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(RescheduleRequestConstants.RESCHEDULE_REASON_CODE_PARAM));
            _bw.write(_wl_block64Bytes, _wl_block64);

															List<ContactReasonModel> contactReasonModelList = null;
															if(contactReasonResponse.isSuccessful()){
																contactReasonModelList = contactReasonResponse.getContactReasonList();
																for(ContactReasonModel contactReasonModel : contactReasonModelList){
														
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(contactReasonModel.getCode() ));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(contactReasonModel.getDescription() ));
            _bw.write(_wl_block36Bytes, _wl_block36);

																}
															}
														
            _bw.write(_wl_block67Bytes, _wl_block67);

														}
													}
												
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(RescheduleRequestConstants.APPTREQ_DETAILS_PREFERRED_DATE_PAGE_PARAM ));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(RescheduleRequestConstants.APPTREQ_DETAILS_PREFERRED_DATE_PAGE_PARAM ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(timeslotSelectedDate));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(preferredDateFromPage ));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(RescheduleRequestConstants.APPTREQ_DETAILS_FROM_TIME_PARAM ));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(RescheduleRequestConstants.APPTREQ_DETAILS_FROM_TIME_PARAM ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(preferredFromTimePage ));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(RescheduleRequestConstants.APPTREQ_DETAILS_TO_TIME_PARAM ));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(RescheduleRequestConstants.APPTREQ_DETAILS_TO_TIME_PARAM ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(preferredToTimePage ));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(RescheduleRequestConstants.RESCHEDULE_TIMESLOT_SELECTEDFROMTIME_PARAM ));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(RescheduleRequestConstants.RESCHEDULE_TIMESLOT_SELECTEDFROMTIME_PARAM ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(timeslotSelectedFromTime ));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(RescheduleRequestConstants.RESCHEDULE_TIMESLOT_SELECTEDTOTIME_PARAM ));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(RescheduleRequestConstants.RESCHEDULE_TIMESLOT_SELECTEDTOTIME_PARAM ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(timeslotSelectedToTime ));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(RescheduleRequestConstants.HIDDEN_PREFERRED_DATE_TIMESLOT_PARAM ));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(RescheduleRequestConstants.HIDDEN_PREFERRED_DATE_TIMESLOT_PARAM ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(timeslotSelectedDate));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(RescheduleRequestConstants.HIDDEN_FACILITY_ID_PARAM ));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(RescheduleRequestConstants.HIDDEN_FACILITY_ID_PARAM ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(facilityId ));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(facilityDesc ));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(RescheduleRequestConstants.HIDDEN_SPECIALTY_ID_PARAM ));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(RescheduleRequestConstants.HIDDEN_SPECIALTY_ID_PARAM ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(specialtyId ));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(RescheduleRequestConstants.HIDDEN_SPECIALTY_DESC_PARAM ));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(RescheduleRequestConstants.HIDDEN_SPECIALTY_DESC_PARAM ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(specialty ));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(RescheduleRequestConstants.APPTREQ_DETAILS_PRACTITIONERID_PARAM ));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(RescheduleRequestConstants.APPTREQ_DETAILS_PRACTITIONERID_PARAM ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(selectedPractitionerId));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(RescheduleRequestConstants.HIDDEN_CLINIC_CODE_PARAM));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(RescheduleRequestConstants.HIDDEN_CLINIC_CODE_PARAM));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(selectedClinicCode));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(RescheduleRequestConstants.APPTREQ_DETAILS_PRACTITIONERNAME_PARAM ));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(RescheduleRequestConstants.APPTREQ_DETAILS_PRACTITIONERNAME_PARAM ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(selectedPractitionerName));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(RescheduleRequestConstants.GET_APPTREQUESTDETAILS_REFNUMBER_PARAM_KEY ));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(RescheduleRequestConstants.GET_APPTREQUESTDETAILS_REFNUMBER_PARAM_KEY ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(appointmentReqRefNumber ));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(RescheduleRequestConstants.SELECTED_TIMESLOT_PARAM ));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(RescheduleRequestConstants.SELECTED_TIMESLOT_PARAM ));
            _bw.write(_wl_block80Bytes, _wl_block80);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
