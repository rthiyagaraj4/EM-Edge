package jsp_servlet._portal._jsp._schedule;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import portalrefimpl.facility.facilityforpatient.svc.FacilityListServiceInvoker;
import portalrefimpl.schedule.createappointment.response.TimeSlot;
import java.util.Date;
import portalrefimpl.schedule.createappointment.response.PractitionerTimeSlotResponse;
import portalrefimpl.schedule.createappointment.svc.serviceinvoker.PractitionerTimeSlotServiceInvoker;
import java.util.Locale;
import portalrefimpl.schedule.createappointment.request.PractitionerTimeSlotRequest;
import portalrefimpl.common.model.Facility;
import portalrefimpl.facility.facilityforpatient.response.FacilityListResponse;
import portalrefimpl.facility.facilityforpatient.request.FacilityListRequest;
import portalrefimpl.common.response.ErrorInfo;
import portalrefimpl.schedule.createappointment.AppointmentTime;
import java.util.List;
import portalrefimpl.schedule.ScheduleHelper;
import portalrefimpl.schedule.createappointment.AppointmentTimeResponse;
import portalrefimpl.schedule.ScheduleConstants;
import portalrefimpl.schedule.createappointment.AppointmentTimeRequest;
import portalrefimpl.PortalConstants;
import portalrefimpl.schedule.createappointment.CreateAppointmentConstants;
import portalrefimpl.schedule.createappointment.response.SpecialityModel;
import portalrefimpl.schedule.createappointment.response.SpecialityResponse;
import portalrefimpl.schedule.createappointment.svc.serviceinvoker.SpecialityServiceInvoker;
import portalrefimpl.schedule.createappointment.request.SpecialityRequest;

public final class __practitionertimeslot extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/portal/jsp/schedule/PractitionerTimeSlot.jsp", 1669269355969L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\r\n<!DOCTYPE html>\r\n<html>\r\n<head>\r\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n<title>::: Patient Portal - Book Appointment :::</title>\r\n\r\n<meta name=\"keywords\" content=\"\" />\r\n<meta name=\"description\" content=\"\" />\r\n<link rel=\"stylesheet\" href=\"../../css/style.css\" type=\"text/css\"/>\r\n<link rel=\"stylesheet\" href=\"../../css/style_ie.css\" type=\"text/css\"/>\r\n<link href=\"../../css/examples-offline.css\" rel=\"stylesheet\">\r\n<link href=\"../../css/kendo.common.min.css\" rel=\"stylesheet\">\r\n<link href=\"../../css/kendo.default.min.css\" rel=\"stylesheet\">\r\n\r\n<script src=\"../../js/jquery.min.js\"></script>\r\n<script src=\"../../js/kendo.web.min.js\"></script>\r\n<script src=\"../../js/console.js\"></script>\r\n\r\n<style scoped>\r\n    #special-days {\r\n        height: 202px;\r\n        width: 300px;\r\n        margin: 2px auto;\r\n        /*padding: 2px 0 2px 2px;*/\r\n    }\r\n\r\n    #PreferredDateInTimeSlot {\r\n        border-radius: 1px 1px 1px 1px;\r\n        border-style: solid;\r\n        border-width: 1px;\r\n    }\r\n\r\n    .k-header {\r\n        border-radius: 3px 3px 0 0;\r\n    }\r\n\r\n    #PreferredDateInTimeSlot .k-content {\r\n        height: 152px;\r\n        width:262px;\r\n    }\r\n\r\n     .normal {\r\n        /* background: transparent url(../../content/web/calendar/exhibition.png) no-repeat 0 50%; */\r\n        background-color : transparent;\r\n        display: inline-block;\r\n        width: 100%;\r\n        height: 10px;\r\n        vertical-align: middle;\r\n        margin-right: 3px;\r\n    }\r\n    \r\n    .FREE {\r\n    \tbackground-color : #38A1E9;\r\n    \tdisplay: inline-block;\r\n        width: 100%;\r\n        height: 8px;\r\n        vertical-align: middle;\r\n        \r\n    }\r\n    \r\n     .LEAVE {\r\n    \tbackground-color : #E8AF1A;\r\n    \tdisplay: inline-block;\r\n        width: 100%;\r\n        height: 8px;\r\n        vertical-align: middle;\r\n        \r\n    }\r\n    \r\n    .BLOCKED {\r\n    \tbackground-color : #DE3A29;\r\n    \tdisplay: inline-block;\r\n        width: 100%;\r\n        height: 8px;\r\n        vertical-align: middle;\r\n    }\r\n    \r\n    .timeslottd{\r\n    \theight:100%;\r\n    \tmargin-left: 2px;\r\n    \twidth:50%;\r\n    \tmin-width:50%;\r\n    \tborder-right:1px solid #AFAFAF;\r\n    }\r\n    \r\n    .confirmpopupContainerStyle {\r\n      background-color: white;\r\n      opacity: 90%;\r\n      filter:alpha(opacity=90);\r\n      background-color: rgba(255,255,255,0.90); \r\n      width: 100%;\r\n      min-height: 100%;\r\n      overflow: hidden;\r\n      float: absolute;\r\n      position: fixed;\r\n      top: 0;\r\n      left: 0;\r\n      color: white;\r\n      \r\n      /* z-index: -1;\r\n      opacity:0%; */\r\n\t}\r\n\t\r\n\t.confirmpopupContentStyle{\r\n\t  background-color: white;\r\n      color: black;\r\n      \r\n      padding: 2px;\r\n      display:block;\r\n      position: absolute;\r\n      top: 30%;\r\n      left: 30%;\r\n      /* width : 0px;\r\n      height : 0px;\r\n      z-index: -1; */\r\n      width: 582px;\r\n      height: 245px; \r\n\t}\r\n    \r\n    .bookapptContainerStyle {\r\n      background-color: white;\r\n      opacity: 90%;\r\n      filter:alpha(opacity=90);\r\n      background-color: rgba(255,255,255,0.90);\r\n      width: 100%;\r\n      min-height: 100%;\r\n      overflow: hidden;\r\n      float: absolute;\r\n      position: fixed;\r\n      top: 0;\r\n      left: 0;\r\n      color: white;\r\n\t}\r\n\t\r\n\t.bookapptpopupContentStyle{\r\n\t  background-color: white;\r\n      color: black;\r\n      /* border: 1px solid gray; */\r\n      padding: 2px;\r\n      display:block;\r\n      position: absolute;\r\n      top: 30%;\r\n      left: 30%;\r\n      width: 582px;\r\n      height: 242px;\r\n\t}\r\n\r\n</style>\r\n\r\n <script>\r\n     $(document).ready(function() {\r\n         var today = new Date();\r\n         \r\n         // create DatePicker from input HTML element\r\n         $(\"#ApptPreferredDate\").kendoDatePicker({\r\n        \t    format: \"dd/MM/yyyy\"\r\n         });\r\n         \r\n         var preferredDate;\r\n         var monthDates = [];\r\n\r\n         // this is where the code to get the practitioner schedule\r\n         // should be called\r\n         var xmlHttp = getHttpObject();\r\n     \txmlHttp.onreadystatechange=function(){\r\n     \t\tif(xmlHttp.readyState==4 && xmlHttp.status==200){\r\n     \t\t\tvar responseText = xmlHttp.responseText;\r\n     \t\t\tvar dataObj = ((JSON && JSON.parse(responseText)) );\r\n     \t\t\t// || ($.parseJSON(responseText)));\r\n     \t\t\tvar objLength = dataObj.length; \r\n     \t\t\tvar errorMessage;\r\n     \t\t\tvar scheduleDate;\r\n     \t\t\tvar scheduleStatus;\r\n     \t\t\t//alert(\'response text=\'+responseText+\'||| objLength=\'+objLength);\r\n     \t\t\tfor(count=0;count<objLength;count++){\r\n     \t\t\t\terrorMessage = dataObj[count].errorMessage;\r\n     \t\t\t\terrorMessage = trimText(errorMessage);\r\n     \t\t\t\tscheduleDate = dataObj[count].scheduleDate;\r\n     \t\t\t\tscheduleDate = trimText(scheduleDate);\r\n     \t\t\t\tscheduleStatus = dataObj[count].scheduleStatus;\r\n     \t\t\t\tscheduleStatus = trimText(scheduleStatus);\r\n     \t\t\t\t\r\n     \t\t\t\t//alert(errorMessage+\"||\"+scheduleDate+\"||\"+scheduleStatus);\r\n     \t\t\t\t// this is the error scenario\r\n     \t\t\t\t// show the error message in the GUI\r\n     \t\t\t\tif(errorMessage.length > 0){\r\n     \t\t\t\t\tvar errorMessageSpanComp = document.getElementById(\"errorMessageSpan\");\r\n     \t\t\t\t\tvar errorMessageDivComp = document.getElementById(\"errorMessageDiv\");\r\n     \t\t\t\t\tif(errorMessageSpanComp && errorMessageDivComp){\r\n     \t\t\t\t\t\terrorMessageSpanComp.innerHTML = errorMessage;\r\n     \t\t\t\t\t\terrorMessageDivComp.style.display = \"block\";\r\n     \t\t\t\t\t}else{\r\n     \t\t\t\t\t\t// just a safe handling - somehow user should\r\n     \t\t\t\t\t\t// get to know that an error has occurred\r\n     \t\t\t\t\t\talert(\"errorMessage=\"+errorMessage);\r\n     \t\t\t\t\t}\r\n     \t\t\t\t\tcontinue;\r\n     \t\t\t\t}\r\n     \t\t\t\t// this is for initializing the preferred date which is nothing\r\n     \t\t\t\t// but the date starting from which user would view the schedule\r\n     \t\t\t\t// for example if user has selected preferred date as 28/03/2013\r\n     \t\t\t\t// then user would view the schedule starting from 28/03/2013\r\n     \t\t\t\t// and ending at one month from the starting date\r\n     \t\t\t\tif(count == 0){\r\n     \t\t\t\t\t// the date value will be in the format \"dd/MM/yyyy\"\r\n     \t\t\t\t\t// hence there is no need to have safe checks\r\n     \t\t\t\t\tvar dateIndex = scheduleDate.indexOf(\"/\");\r\n     \t\t\t\t\tvar dateStr = scheduleDate.substring(0,dateIndex);\r\n     \t\t\t\t\tvar dateVal = getIntValue(dateStr,0);\r\n     \t\t\t\t\t\r\n     \t\t\t\t\tvar monthIndex = scheduleDate.indexOf(\"/\",dateIndex+1);\r\n     \t\t\t\t\tvar monthStr = scheduleDate.substring(dateIndex+1,monthIndex);\r\n     \t\t\t\t\tvar monthVal = getIntValue(monthStr,0);\r\n     \t\t\t\t\t\r\n     \t\t\t\t\tvar yearStr = scheduleDate.substring(monthIndex+1,scheduleDate.length);\r\n     \t\t\t\t\tvar yearVal = getIntValue(yearStr,0);\r\n     \t\t\t\t\t// initialize the preferred date\r\n     \t\t\t\t\tpreferredDate = new Date(yearVal,monthVal-1,dateVal);\r\n     \t\t\t\t}\r\n     \t\t\t\tmonthDates[+new Date(preferredDate.getFullYear(),preferredDate.getMonth(),(preferredDate.getDate()+count))] = scheduleStatus;\r\n     \t\t\t}\r\n     \t\t\t//check if the obj length is more than 1 - this indicates\r\n     \t\t\t// that schedule informationn is present\r\n     \t\t\tif(objLength > 1){\r\n     \t\t\t\t$(\"#PreferredDateInTimeSlot\").kendoCalendar({\r\n        \t             value: preferredDate,\r\n        \t             dates: monthDates,\r\n        \t             month:{\r\n        \t               content:\'# if (typeof data.dates[+data.date] === \"string\") { #\' +\r\n        \t                       \'<div style=\"max-height:30px;\">\' +\r\n        \t                       \'#= data.value #\' +\r\n        \t                       //\'<br>\'+\r\n        \t                       \'<span class=\"#= data.dates[+data.date] #\">\' +\r\n        \t                       \'</span>\' +\r\n        \t                       \'</div>\' +\r\n        \t                       \'# } else { #\' +\r\n        \t                       \'#= data.value #\' +\r\n        \t                       \'# } #\'\r\n        \t             },\r\n        \t             footer: \" #=kendo.toString(data, \'d\') #\",\r\n        \t             format: \"dd/MM/yyyy\" \r\n        \t         });\r\n     \t\t\t}else{\r\n     \t\t\t\t// schedule status is not available for the \r\n     \t\t\t\t// selected practitioner and the selected date\r\n     \t\t\t\t// but still the calendar should be shown\r\n     \t\t\t\tvar hdnPreferredDateElem = document.getElementById(\'hdnPreferredDate\');\r\n     \t\t\t\tif(hdnPreferredDateElem){\r\n     \t\t\t\t\tpreferredDate = hdnPreferredDateElem.value;\r\n     \t\t\t\t}\r\n     \t\t\t\t$(\"#PreferredDateInTimeSlot\").kendoCalendar({\r\n       \t             value: preferredDate,\r\n\t       \t          footer: \" #=kendo.toString(data, \'d\') #\",\r\n\t \t             format: \"dd/MM/yyyy\" \r\n\t \t         });\r\n     \t\t\t}\r\n     \t\t\t\r\n     \t\t\t// now bind the function for on change\r\n     \t\t\t//var calendarObj = $(\"#PreferredDateInTimeSlot\").data(\"kendoCalendar\");\r\n     \t\t\t//calendarObj.bind(\"change\",onCalendarValueChange);\r\n     \t\t}\r\n     \t}\r\n     \txmlHttp.open(\"POST\", \"./PractitionerScheduleStatusServlet\", true);\r\n     \txmlHttp.setRequestHeader(\"Content-type\",\"application/x-www-form-urlencoded\");\r\n     \t// form the \r\n     \tvar parameters = getPractitionerScheduleStatusParameters();\r\n     \txmlHttp.send(parameters); \r\n     });\r\n     \r\n     function getHttpObject(){\r\n    \t\tvar xmlHttp;\r\n    \t\tif (window.XMLHttpRequest) {\r\n    \t\t\txmlHttp = new XMLHttpRequest();\r\n    \t\t} else if (window.ActiveXObject) {\r\n    \t\t\txmlHttp = new ActiveXObject(\"Microsoft.XMLHTTP\");\r\n    \t\t}\r\n    \t\treturn xmlHttp;\r\n    }\r\n     \r\n    function onCalendarValueChange(){\r\n\t\tvar calendarObj = $(\"#PreferredDateInTimeSlot\").data(\"kendoCalendar\");\r\n\t\t//var preferredDateInTimeSlotComp = document.getElementById(\"hdnPreferredDateInTimeSlotFrame\");\r\n\t\tif(calendarObj){\r\n\t\t\t//alert(\'on calendar value change  \'+calendarObj.value());\t\r\n\t\t}else{\r\n\t\t\t//alert(\'calendar obj is not valid\');\r\n\t\t}\r\n    } \r\n     \r\n    function getPractitionerScheduleStatusParameters(){\r\n    \tvar parameters = \"\";\r\n    \t// speciality\r\n    \tvar hdnSpecialityCode = document.getElementById(\"hdnSelectedSpeciality\");\r\n    \tvar specialityCode=\"\";\r\n    \tif(hdnSpecialityCode){\r\n    \t\tspecialityCode = hdnSpecialityCode.value;\r\n    \t}\r\n    \tparameters +=\"hdnSelectedSpeciality=\"+specialityCode;\r\n    \tparameters +=\"&\";\r\n    \t\r\n    \t// facility\r\n    \tvar hdnFacility = document.getElementById(\"Facility\");\r\n    \tvar facility=\"\";\r\n    \tif(hdnFacility){\r\n    \t\tfacility = hdnFacility.value;\r\n    \t}\r\n    \tparameters +=\"Facility=\"+facility;\r\n    \tparameters +=\"&\";\r\n    \t\r\n    \t// preferred date\r\n    \t//var preferredDateComp = document.getElementById(\"hdnPreferredDate\");\r\n    \tvar preferredDateComp = document.getElementById(\"hdnPreferredDateInTimeSlotFrame\");\r\n    \tvar preferredDate=\"\";\r\n    \tif(preferredDateComp){\r\n    \t\tpreferredDate = preferredDateComp.value;\r\n    \t}\r\n    \tparameters +=\"hdnPreferredDate=\"+preferredDate;\r\n    \tparameters +=\"&\";\r\n    \t\r\n    \t// preferred from time\r\n    \tvar preferredFromTimeComp = document.getElementById(\"ApptPreferredFromTime\");\r\n    \tvar preferredFromTime=\"\";\r\n    \tif(preferredFromTimeComp){\r\n    \t\tpreferredFromTime = preferredFromTimeComp.value;\r\n    \t}\r\n    \tparameters +=\"ApptPreferredFromTime=\"+preferredFromTime;\r\n    \tparameters +=\"&\";\r\n    \t\r\n    \t// preferred to time\r\n    \tvar preferredToTimeComp = document.getElementById(\"ApptPreferredToTime\");\r\n    \tvar preferredToTime=\"\";\r\n    \tif(preferredToTimeComp){\r\n    \t\tpreferredToTime = preferredToTimeComp.value;\r\n    \t}\r\n    \tparameters +=\"ApptPreferredToTime=\"+preferredToTime;\r\n    \tparameters +=\"&\";\r\n    \t\r\n    \t// practitioner id\r\n    \tvar practitionerIdComp = document.getElementById(\"hdnPractitionerId\");\r\n    \tvar practitionerId=\"\";\r\n    \tif(practitionerIdComp){\r\n    \t\tpractitionerId = practitionerIdComp.value;\r\n    \t}\r\n    \tparameters +=\"hdnPractitionerId=\"+practitionerId;\r\n    \tparameters +=\"&\";\r\n    \t\r\n    \t// clinic code\r\n    \tvar clinicCodeComp = document.getElementById(\"hdnClinicCode\");\r\n    \tvar clinicCode = \"\";\r\n    \tif(clinicCodeComp){\r\n    \t\tclinicCode = clinicCodeComp.value;\r\n    \t}\r\n    \tparameters += \"hdnClinicCode=\"+clinicCode;\r\n    \t\r\n    \treturn parameters;\r\n    } \r\n    \r\n    function trimText(textVal){\r\n\t   \t var l=0; var r=textVal.length -1;\r\n\t   \t while(l < textVal.length && textVal[l] == \' \'){\r\n\t   \t\t  l++;\r\n\t   \t }\r\n\t   \t\t\r\n\t   \t while(r > l && textVal[r] == \' \'){\r\n\t   \t\tr-=1;\r\n\t   \t }\r\n\t   \t textVal = textVal.substring(l, r+1);\r\n\t   \t \r\n\t   \t return textVal;\r\n    }\r\n    \r\n    function getIntValue(stringValue,defaultValue){\r\n    \t// this function converts the string value to an integer value\r\n    \tvar intVal = defaultValue;\r\n    \ttry{\r\n    \t\tintVal = parseInt(stringValue);\t\r\n    \t}catch(e){\r\n    \t\tintVal = defaultValue;\r\n    \t}\r\n    \treturn intVal;\r\n    }\r\n    \r\n    function checkTimeSlot(){\r\n    \t// this function is invoked when check time slot button\r\n    \t// is clicked by the user\r\n    \t// this function merely submits the form in this page\r\n    \tvar preferredDateInTimeSlot = document.getElementById(\"PreferredDateInTimeSlot\");\r\n    \tvar hdnPreferredDateInTimeSlot = document.getElementById(\"hdnPreferredDateInTimeSlotFrame\");\r\n    \tvar preferredDateCalendar = $(\"#PreferredDateInTimeSlot\").data(\"kendoCalendar\");\r\n    \tif(preferredDateInTimeSlot && hdnPreferredDateInTimeSlot){\r\n    \t\tvar preferredDate;\r\n    \t\tvar preferredDateObj;\r\n    \t\tif(preferredDateCalendar){\r\n    \t\t\tpreferredDate = preferredDateCalendar.value();\r\n    \t\t\t//alert(preferredDate);\r\n    \t\t\tpreferredDateObj = new Date(preferredDate);\r\n    \t\t\tif(preferredDateObj){\r\n    \t\t\t\tpreferredDate = \"\"+preferredDateObj.getDate()+\"/\"+(preferredDateObj.getMonth()+1)+\"/\"+preferredDateObj.getFullYear();\r\n    \t\t\t}\r\n    \t\t\t//preferredDate = preferredDateObj.toString(\'MM/dd/yyyy\');\r\n    \t\t\t//alert(preferredDate);\r\n    \t\t\t//alert(\'calendar is valid \'+preferredDate);\r\n    \t\t}else{\r\n    \t\t\tpreferredDate = preferredDateInTimeSlot.value;\r\n    \t\t\t//alert(\'calendar is invalid \'+preferredDate);\r\n    \t\t\talert(\'Cannot proceed to get timeslot for selected date \'+hdnPreferredDateInTimeSlot.value+\'. System error\');\r\n    \t\t\treturn false;\r\n    \t\t}\r\n    \t\t//alert(preferredDate);\r\n    \t\thdnPreferredDateInTimeSlot.value = preferredDate;\r\n    \t}\r\n    \t\r\n    \tvar formElement = document.getElementById(\"timeslotform\");\r\n    \tif(formElement){\r\n    \t\tformElement.action = \"./PractitionerTimeSlotServlet\";\r\n    \t\tformElement.submit();\r\n    \t}\r\n    }\r\n    \r\n   function selectSpeciality(spanElement,specialityCodeId,specialityDescId){\r\n   \t // this function sets the background color of a selected specialty\r\n   \t // this function also sets the hidden speciality elements with\r\n   \t // the value of the selected speciality and the speciality description\r\n   \t \r\n   \t spanElement.style.backgroundColor=\"#C1D994\";\r\n   \t // set the selected speciality in the hidden element\r\n   \t var specialityCodeElement = document.getElementById(specialityCodeId);\r\n   \t var selectedSpecialityComp = document.getElementById(\"hdnSelectedSpeciality\");\r\n   \t if(specialityCodeElement && selectedSpecialityComp){\r\n   \t\t selectedSpecialityComp.value = specialityCodeElement.value;\r\n   \t }\r\n   \t \r\n   \t // set the selected speciality\'s description in the hidden element\r\n   \t var specialityDescElement = document.getElementById(specialityDescId);\r\n   \t var selectedSpecialityDescComp = document.getElementById(\"hdnSelectedSpecialtyDesc\");\r\n   \t if(specialityDescElement && selectedSpecialityDescComp){\r\n   \t\t selectedSpecialityDescComp.value = specialityDescElement.value;\r\n   \t }\r\n    }\r\n   \r\n   function searchSpeciality(){\r\n\t\t // this function performs the search when user clicks on search\r\n\t\t // after specifying the speciality\r\n\t\t \r\n\t\t // first get the text entered by user\r\n\t\t var searchTextComp = document.getElementById(\"specialitySearchText\");\r\n\t\t var searchText=\"\";\r\n\t\t if(searchTextComp){\r\n\t\t\t searchText = searchTextComp.value;\r\n\t\t\t // convert to upper case - this will be useful\r\n\t\t\t// for string comparision\t\t \r\n\t\t\t searchText = searchText.toUpperCase();\r\n\t\t }\r\n\t\t \r\n\t\t // below code is for trimming the search text\r\n\t\t // this code is done to support any browser\r\n\t\t // that is why in built js functions are not used\r\n\t\t var l=0; var r=searchText.length -1;\r\n\t\t  while(l < searchText.length && searchText[l] == \' \'){\r\n\t\t\t  l++;\r\n\t\t  }\r\n\t\t\t\r\n\t\twhile(r > l && searchText[r] == \' \'){\r\n\t\t\tr-=1;\r\n\t\t}\r\n\t\t  searchText = searchText.substring(l, r+1);\r\n\t\t  \r\n\t\t  // get the number of specialities shown in the GUI\r\n\t\t var specialityIndexCountComp = document.getElementById(\"hdnSpecialityIndex\");\r\n\t\t var specialityIndexCountStr;\r\n\t\t var specialityIndexCount = 0;\r\n\t\t if(specialityIndexCountComp){\r\n\t\t\t specialityIndexCountStr = specialityIndexCountComp.value;\r\n\t\t\t specialityIndexCount = parseInt(specialityIndexCountStr);\r\n\t\t }\r\n\t\t //alert(specialityIndexCount);\r\n\t\t \r\n\t\t var specialityIdComp;\r\n\t\t var specialityText;\r\n\t\t var textIndex=-1;\r\n\t\t  \r\n\t\t  // check if the search text is empty - if so\r\n\t\t  // bring back all the hidden elements \r\n\t\t if(searchText == \'\'){\r\n\t\t\t for(count=2;count<=specialityIndexCount;count++){\r\n\t\t\t\t specialityIdComp = document.getElementById(\"Speciality\"+count);\r\n\t\t\t\t if(specialityIdComp){\r\n\t\t\t\t\t specialityIdComp.style.display = \"block\";\r\n\t\t\t\t }\r\n\t\t\t }\r\n\t\t\t return;\r\n\t\t }\r\n\t\t\r\n\t\t // loop through the speciality components\r\n\t\t // and hide them if their value does not match the text entered\r\n\t\t for(count=2;count<=specialityIndexCount;count++){\r\n\t\t\t specialityIdComp = document.getElementById(\"Speciality\"+count);\r\n\t\t\t if(specialityIdComp){\r\n\t\t\t\t specialityText = specialityIdComp.innerHTML;\r\n\t\t\t\t // convert the text to upper case - usefull for\r\n\t\t\t\t // case insensitive string comparision\r\n\t\t\t\t specialityText = specialityText.toUpperCase();\r\n\t\t\t\t textIndex = specialityText.indexOf(searchText);\r\n\t\t\t\t if(textIndex != 0){\r\n\t\t\t\t\t specialityIdComp.style.display = \"none\";\r\n\t\t\t\t }else{\r\n\t\t\t\t\t specialityIdComp.style.display = \"block\";\r\n\t\t\t\t }\r\n\t\t\t }\r\n\t\t }\r\n\t }\r\n\r\n   function getPractitionerList(){\r\n\t   // this function is invoked when user clicks on search button\r\n\t   // in this page\r\n\t   var validationMessage = \"\";\r\n\t \r\n\t   // first validate the fields in the GUI\r\n\t   var datePickerComp = document.getElementById(\"ApptPreferredDate\");\r\n\t   var datePicker = $(\"#ApptPreferredDate\").data(\"kendoDatePicker\");\r\n\t   var preferredApptDate;\r\n\t\t// get the preferred date from the date picker component or\r\n\t   // the generalized element\r\n\t   if(datePickerComp){\r\n\t\t   if(datePicker){\r\n\t\t\t   preferredApptDate = datePicker.value();\r\n\t\t\t   //alert(\'date picker value=\'+preferredApptDate);\r\n\t\t   }else{\r\n\t\t\t   var dateValue = datePickerComp.value;\r\n\t\t\t   preferredApptDate = getDateObject(dateValue);\r\n\t\t\t   //preferredApptDate = new Date(dateValue);\r\n\t\t\t   //alert(\'date comp value=\'+dateValue+\' \'+(typeof dateValue)+\' \'+preferredApptDate);\r\n\t\t\t   //alert(Date.parse(dateValue));\r\n\t\t   }\r\n\t   }\r\n       \r\n       if(isNaN(preferredApptDate)){\r\n    \t   validationMessage = \"Preferred date is not valid. \\n\";\r\n       }\r\n     \r\n    \tvar currentDate = new Date();\r\n\t\t // time validation\r\n\t\tvar selectedFromTimeComp = document.getElementById(\"ApptPreferredFromTime\");\r\n\t\tvar selectedFromTimeIndex;\r\n\t\tvar selectedFromTime = \"\";\r\n\t\tif(selectedFromTimeComp){\r\n\t\t\tselectedFromTimeIndex = selectedFromTimeComp.selectedIndex;\r\n\t\t\tselectedFromTime = selectedFromTimeComp.value;\r\n\t\t}\r\n\t\t\r\n\t\tvar selectedToTimeIndex;\r\n\t\tvar selectedToTimeComp = document.getElementById(\"ApptPreferredToTime\");\r\n\t\tvar selectedToTime = \"\";\r\n\t\tif(selectedToTimeComp){\r\n\t\t\tselectedToTimeIndex = selectedToTimeComp.selectedIndex;\r\n\t\t\tselectedToTime = selectedToTimeComp.value;\r\n\t\t\tselectedToTime = trimText(selectedToTime);\r\n\t\t}\r\n\t\t\r\n\t\tvar selectedTimeIsInvalid = false;\r\n\t\tif(selectedFromTime.length == 0 && selectedToTime.length == 0){\r\n\t\t\tvalidationMessage += \"Appointment start and end time is not specified. \\n\";\r\n\t\t\tselectedTimeIsInvalid = true;\r\n\t\t}else if(selectedFromTime.length == 0){\r\n\t\t\tvalidationMessage += \"Appointment start time is not specified. \\n\";\r\n\t\t\tselectedTimeIsInvalid = true;\r\n\t\t}else if(selectedToTime.length == 0){\r\n\t\t\tvalidationMessage += \"Appointment end time is not specified. \\n\";\r\n\t\t\tselectedTimeIsInvalid = true;\r\n\t\t}\r\n\t\t\r\n\t\tvar dotIndex = selectedFromTime.indexOf(\".\");\r\n\t\tvar hrsStr = \"\";\r\n\t\tvar hrs = 0;\r\n\t\tvar minsStr = \"\";\r\n\t\tvar mins = 0;\r\n\t\tif(dotIndex > 0){\r\n\t\t\thrsStr = selectedFromTime.substring(0,dotIndex);\r\n\t\t\tminsStr = selectedFromTime.substring(dotIndex+1,selectedFromTime.length);\r\n\t\t\ttry{\r\n\t\t\t\thrs = parseInt(hrsStr);\t\r\n\t\t\t}catch(e){\r\n\t\t\t\thrs = 0;\r\n\t\t\t}\r\n\t\t\ttry{\r\n\t\t\t\tmins = parseInt(minsStr);\r\n\t\t\t}catch(e){\r\n\t\t\t\tmins = 0;\r\n\t\t\t}\r\n\t\t}\r\n\t\t// set the hours, minutes and the seconds\r\n\t\t// seconds will be set to 0 now\r\n\t\tif(!(isNaN(preferredApptDate))){\r\n\t\t\tpreferredApptDate.setHours(hrs);\r\n\t\t\tpreferredApptDate.setMinutes(mins);\r\n\t\t\tpreferredApptDate.setSeconds(0);\r\n\t\t\t\r\n\t\t\t// validate the appointment start time with current date only\r\n\t\t\t// when the start time is selected properly by user\r\n\t\t\tif((preferredApptDate < currentDate) && !selectedTimeIsInvalid){\r\n\t\t\t\tvalidationMessage += \"Appointment start time cannot be less than current time. \\n\";\r\n\t\t\t}\r\n\t\t}\r\n\t\t\r\n\t\t// validate the appointment start time with appointment end time only\r\n\t\t// when the start time and end time is selected properly by user\t\r\n\t\tif((selectedFromTimeIndex > selectedToTimeIndex) && !selectedTimeIsInvalid){\r\n\t\t\tvalidationMessage += \"Appointment start time cannot be greater than or equal to end time. \\n\";\r\n\t\t}\r\n\t\t\r\n\t\t// speciality and facility validation\r\n\t\t// first speciality\r\n\t\tvar hiddenSpecialityComp = document.getElementById(\"hdnSelectedSpeciality\");\r\n\t\tvar selectedSpeciality=\"\";\r\n\t\tif(hiddenSpecialityComp){\r\n\t\t\tselectedSpeciality = hiddenSpecialityComp.value;\r\n\t\t\tselectedSpeciality = trimText(selectedSpeciality);\r\n\t\t}\r\n\t\tif(selectedSpeciality.length == 0){\r\n\t\t\tvalidationMessage += \"Selected speciality is invalid. \\n\";\r\n\t\t}\r\n\t\t\r\n\t\t// validate selected facility\r\n\t\tvar selectedFacility = \"\";\r\n\t\tvar facilityComp = document.getElementById(\"Facility\");\r\n\t\tif(facilityComp){\r\n\t\t\tselectedFacility = facilityComp.value;\r\n\t\t\tselectedFacility = trimText(selectedFacility);\r\n\t\t}\r\n\t\t\r\n\t\tif(selectedFacility.length == 0){\r\n\t\t\tvalidationMessage += \"Selected facility is invalid. \\n\";\r\n\t\t}\r\n\t\t\r\n\t\tif(validationMessage.length > 0){\r\n\t\t\talert(validationMessage);\r\n\t\t\treturn;\r\n\t\t}\r\n\t\t\r\n\t\t// need to set the values of hdnSelectedSpeciality,hdnSelectedSpecialityDesc\r\n\t\t//hdnPreferredDate - it is enough to set the hdnpreferreddate with value\r\n\t\t// hdnselectedspeciality and hdnselectedspecialitydesc is already set\r\n\t\t// with values\r\n\t\t//var dateTimePicker = $(\"#ApptPreferredDate\").data(\"kendoDatePicker\");\r\n\t\t//var preferredApptDate = dateTimePicker.value();\r\n\t\tvar dateValue = \"\"+preferredApptDate.getDate()+\"/\"+(preferredApptDate.getMonth()+1)+\"/\"+preferredApptDate.getFullYear();\r\n\t\tvar hdnPreferredDateComp = document.getElementById(\"hdnPreferredDate\");\r\n\t\tif(hdnPreferredDateComp){\r\n\t\t\thdnPreferredDateComp.value = dateValue;\r\n\t\t}\r\n\t\t // finally all validations have passed - submit the form\r\n\t\tvar formElement = document.getElementById(\"timeslotform\");\r\n\t\t if(formElement){\r\n\t\t\t formElement.action = \"../schedule/SpecialityServlet\";\r\n\t\t\t formElement.submit();\r\n\t\t }\r\n\t }\r\n   \r\n   function selectTimeSlot(timeSlotElement,divId){\r\n\t   // this function sets the selected time slot element\'s style\r\n\t   // also sets the selected time slot value to a hidden variable\r\n\t   // also modifies the text of the selected time slot label shown in GUI\r\n\t   // this function is modified to pass the divid of the selected time slot\r\n\t   \r\n\t   var previousSelectedDivId;\r\n\t   var hdnSelectedTimeSlotDivElement = document.getElementById(\"hdnSelectedTimeSlotDivId\");\r\n\t   if(hdnSelectedTimeSlotDivElement){\r\n\t\t   previousSelectedDivId = hdnSelectedTimeSlotDivElement.value;\r\n\t\t   var previousSelectedDiv = document.getElementById(previousSelectedDivId);\r\n\t\t   if(previousSelectedDiv){\r\n\t\t\t   var styleClassName = previousSelectedDiv.className;\r\n\t\t\t   if(\'timeselectionnormal evenrow\' == styleClassName){\r\n\t\t\t\t   previousSelectedDiv.style.background =  \"#F2F2F2\";\r\n\t\t\t   }else if(\'timeselectionnormal oddrow\' == styleClassName){\r\n\t\t\t\t   previousSelectedDiv.style.background =  \"#EBEBEB\";\r\n\t\t\t   }else if(\'timeselectionpreferred\' == styleClassName){\r\n\t\t\t\t   previousSelectedDiv.style.background =  \"#FCFAC8\";\r\n\t\t\t   }\r\n\t\t   }\r\n\t\t   // finally set the currently selected time slot\'s div id\r\n\t\t   // as the value of the hidden element\r\n\t\t   hdnSelectedTimeSlotDivElement.value = divId;\r\n\t   }\r\n\t   timeSlotElement.style.background = \"#73A30A\";\r\n\t   // sets the selected time slot value to a hidden variable\r\n\t   var selectedTimeSlot = timeSlotElement.innerHTML;\r\n\t   selectedTimeSlot = trimText(selectedTimeSlot);\r\n\t   // now set the background color of the currently selected time slot\r\n\t   var hdnSelectedTimeSlotElement = document.getElementById(\'hdnSelectedTimeSlot\');\r\n\t   if(hdnSelectedTimeSlotElement){\r\n\t\t   hdnSelectedTimeSlotElement.value = selectedTimeSlot;\r\n\t   }\r\n\t   //modifies the text of the selected time slot label shown in GUI\r\n\t   var selectedSpan = document.getElementById(\'selectedtimespan\');\r\n\t   if(selectedSpan){\r\n\t\t   selectedSpan.innerHTML = selectedTimeSlot;\r\n\t   }\r\n   }\r\n   \r\n   function confirmAppointmentRequest(){\r\n\t   // this function shows the confirmation dialog\r\n\t   // to the user before proceeding to book an appointment request\r\n\t   \r\n\t   // first validate if any time slot is selected\r\n\t\t// preferred time slot\r\n\t   var selectedTimeSlotComp = document.getElementById(\"hdnSelectedTimeSlot\");\r\n\t   var selectedTimeSlot = \"\";\r\n\t   if(selectedTimeSlotComp){\r\n\t\t   selectedTimeSlot = selectedTimeSlotComp.value;\r\n\t\t   if(selectedTimeSlot.length == 0){\r\n\t\t\t   alert(\'Time slot is not selected for the appointment request\');\r\n\t\t\t   return false;\r\n\t\t   }\r\n\t   }\r\n\t   \r\n\t   // need to get the practitioner name, selected specialty\r\n\t   // appointment date and time\r\n\t   var practNameComp = document.getElementById(\"hdnPractitionerName\");\r\n\t   var practName = \"\";\r\n\t   if(practNameComp){\r\n\t\t   practName = practNameComp.value;\r\n\t\t   practName = escape(practName);\r\n\t   }\r\n\t   \r\n\t   var selectedSpecialtyComp = document.getElementById(\"hdnSelectedSpecialtyDesc\");\r\n\t   var selectedSpecailty = \"\";\r\n\t   if(selectedSpecialtyComp){\r\n\t\t   selectedSpecialty = selectedSpecialtyComp.value;\r\n\t\t   selectedSpecialty = escape(selectedSpecialty);\r\n\t   }\r\n\t   \r\n\t   // preferred date\r\n\t   var datePickerComp = document.getElementById(\"PreferredDateInTimeSlot\");\r\n\t   var dateTimePicker = $(\"#PreferredDateInTimeSlot\").data(\"kendoCalendar\");\r\n\t   var preferredApptDate;\r\n\t   if(datePickerComp){\r\n\t\t   if(dateTimePicker){\r\n\t\t\t   preferredApptDate = dateTimePicker.value();\r\n\t\t   }else{\r\n\t\t\t   preferredApptDate = new Date(datePickerComp.value);\r\n\t\t   }\r\n\t   }\r\n\t   //var preferredApptDate = dateTimePicker.value();\r\n\t   var dateValue = \"\"+preferredApptDate.getDate()+\"/\"+(preferredApptDate.getMonth()+1)+\"/\"+preferredApptDate.getFullYear();\r\n\t   // escape sequence for the selected time slot\r\n\t   selectedTimeSlot = escape(selectedTimeSlot);\r\n\t   \r\n\t   var confirmPopupURL = \"./ConfirmBookRequest.jsp?practitionerName=\"+practName;\r\n\t   confirmPopupURL += \"&specialty=\"+selectedSpecialty;\r\n\t   confirmPopupURL += \"&preferredDate=\"+dateValue;\r\n\t   confirmPopupURL += \"&selectedTimeSlot=\"+selectedTimeSlot;\r\n\t   \r\n\t   // load the div with URL\r\n\t    $(\'#requestConfirmDiv\').load(confirmPopupURL);\r\n\t    \r\n\t\tif (document.getElementById(\'requestConfirmContainerDiv\').style.visibility == \'hidden\') {\r\n\t       document.getElementById(\'requestConfirmContainerDiv\').style.visibility = \'\';\r\n\t       $(\"#requestConfirmContainerDiv\").hide();\r\n\t    }\r\n\t    if (document.getElementById(\'requestConfirmDiv\').style.visibility == \'hidden\') {\r\n\t       document.getElementById(\'requestConfirmDiv\').style.visibility = \'\';\r\n\t       $(\"#requestConfirmDiv\").hide();\r\n\t    }\r\n\t\t\r\n\t\t$(\"#requestConfirmContainerDiv\").fadeIn(300, \"linear\", function () { $(\"#requestConfirmDiv\").show(400, \"swing\"); }); \r\n\t\t\r\n\t\t\r\n\t\t\r\n\t\t/* $(\'#requestConfirmContainerDiv\').animate({zIndex:2},\'fast\');\r\n\t\t$(\'#requestConfirmContainerDiv\').animate({opacity:0.70},\'fast\');\r\n\t\t$(\'#requestConfirmDiv\').animate({zIndex:10},\'fast\');\r\n\t\t$(\'#requestConfirmDiv\').animate({width:\"582px\"},\'slow\');\r\n\t\t$(\'#requestConfirmDiv\').animate({height:\"245px\"},\'fast\'); */\r\n\t\t\r\n   }\r\n   \r\n   function closeConfirmAppointmentPopup(){\r\n\t   // this function will close the confirm popup dialog\r\n\t\t$(\"#requestConfirmDiv\").hide(\'300\', \"swing\", function () { $(\"#requestConfirmContainerDiv\").fadeOut(\"200\"); });\r\n\t   \r\n\t\t/* $(\'#requestConfirmDiv\').animate({zIndex:-1},\'fast\');\r\n\t\t$(\'#requestConfirmDiv\').animate({width:\"0px\"},\'fast\');\r\n\t\t$(\'#requestConfirmDiv\').animate({height:\"0px\"},\'fast\');\r\n\t\t$(\'#requestConfirmContainerDiv\').animate({zIndex:-2},\'fast\');\r\n\t\t$(\'#requestConfirmContainerDiv\').animate({opacity:0},\'fast\'); */\r\n\t\t//reinitializeCalendar();\r\n\t\tvar formElement = document.getElementById(\"timeslotform\");\r\n    \tif(formElement){\r\n    \t\tformElement.action = \"./PractitionerTimeSlotServlet\";\r\n    \t\tformElement.submit();\r\n    \t}\r\n\t}\r\n   \r\n  \r\n   function bookAppointment(){\r\n\t   // this function will book an appointment request based\r\n\t   // on the configuration done already in the page\r\n\t   \r\n\t   // first hide the confirmation dialog\r\n\t   $(\"#requestConfirmDiv\").hide(\'200\', \"swing\", function () { $(\"#requestConfirmContainerDiv\").fadeOut(\"100\"); });\r\n\t   \r\n\t   // This function will book the appointment for the user\r\n\t   var serializeStr = $(\"#timeslotform\").serialize();\r\n\t   //alert(serializeStr);\r\n\t   var bookAppointmentURL = \"./BookAppointmentServlet?\"+serializeStr;\r\n\t   $(\'#bookapptContentDiv\').load(bookAppointmentURL);\r\n\t   \r\n\t   if (document.getElementById(\'bookapptRequestContainerDiv\').style.visibility == \'hidden\') {\r\n\t       document.getElementById(\'bookapptRequestContainerDiv\').style.visibility = \'\';\r\n\t       $(\"#bookapptRequestContainerDiv\").hide();\r\n\t    }\r\n\t    if (document.getElementById(\'bookapptContentDiv\').style.visibility == \'hidden\') {\r\n\t       document.getElementById(\'bookapptContentDiv\').style.visibility = \'\';\r\n\t       $(\"#bookapptContentDiv\").hide();\r\n\t    }\r\n\t\t\r\n\t\t$(\"#bookapptRequestContainerDiv\").fadeIn(200, \"linear\", function () { $(\"#bookapptContentDiv\").show(300, \"swing\"); });\r\n   }\r\n   \r\n   function cancelAppointment(){\r\n\t   // this function will cancel the appointment booking\r\n\t   $(\"#requestConfirmDiv\").hide(\'300\', \"swing\", function () { $(\"#requestConfirmContainerDiv\").fadeOut(\"200\"); });\r\n\t   \r\n\t   /* $(\'#requestConfirmDiv\').animate({zIndex:-1},\'fast\');\r\n\t\t$(\'#requestConfirmDiv\').animate({width:\"0px\"},\'fast\');\r\n\t\t$(\'#requestConfirmDiv\').animate({height:\"0px\"},\'fast\');\r\n\t\t$(\'#requestConfirmContainerDiv\').animate({zIndex:-2},\'fast\');\r\n\t\t$(\'#requestConfirmContainerDiv\').animate({opacity:0},\'fast\'); */\r\n\t   //reinitializeCalendar();\r\n\t   var formElement = document.getElementById(\"timeslotform\");\r\n\t   \tif(formElement){\r\n\t   \t\tformElement.action = \"./PractitionerTimeSlotServlet\";\r\n\t   \t\tformElement.submit();\r\n\t   \t}\r\n   }\r\n   \r\n   function postBookAppointment(errorCodeStr){\r\n\t   // this function will hide the popup which is shown after the\r\n\t   // book appointment operation is performed\r\n\t   // this function will also forward the request to a suitable page\r\n\t   \r\n\t   // first hide the popup\r\n\t   $(\"#bookapptContentDiv\").hide(\'200\', \"swing\", function () { $(\"#bookapptRequestContainerDiv\").fadeOut(\"100\"); });\r\n\t   \r\n\t   var actionURL = \'\';\r\n\t   \r\n\t   // this is for successful appointment booking\r\n\t   if(errorCodeStr == \'2\'){\r\n\t\t  actionURL = \"./UpcomingAppointments.jsp\" ;\r\n\t   }else if(errorCodeStr == \'1\'){\r\n\t\t   actionURL = \'./SpecialityServlet\';\r\n\t   }\r\n\t   \r\n\t   var formElement = document.getElementById(\"timeslotform\");\r\n\t   if(formElement){\r\n\t\t   formElement.action = actionURL;\r\n\t\t   formElement.submit();\r\n\t   }\r\n   }\r\n   \r\n   function getDateObject(scheduleDate){\r\n\t   // this function returns a date object for the string in the format dd/MM/yyyy\r\n\t   var dateIndex = scheduleDate.indexOf(\"/\");\r\n\t\tvar dateStr = scheduleDate.substring(0,dateIndex);\r\n\t\tvar dateVal = getIntValue(dateStr,0);\r\n\t\t\r\n\t\tvar monthIndex = scheduleDate.indexOf(\"/\",dateIndex+1);\r\n\t\tvar monthStr = scheduleDate.substring(dateIndex+1,monthIndex);\r\n\t\tvar monthVal = getIntValue(monthStr,0);\r\n\t\t\r\n\t\tvar yearStr = scheduleDate.substring(monthIndex+1,scheduleDate.length);\r\n\t\tvar yearVal = getIntValue(yearStr,0);\r\n\t\t// initialize the preferred date\r\n\t\tvar preferredDate = new Date(yearVal,monthVal-1,dateVal);\r\n\t\treturn preferredDate;\r\n   }\r\n   \r\n   function reinitializeCalendar(){\r\n\t   $(\"#PreferredDateInTimeSlot\").kendoCalendar({\r\n\t        value: new Date(),\r\n \t        footer: \" #=kendo.toString(data, \'d\') #\",\r\n            format: \"dd/MM/yyyy\" \r\n        });\r\n   }\r\n   \r\n   function performOperation(){\r\n\t   // this function performs the main operation in this page\r\n\t   bookAppointment();\r\n   }\r\n   \r\n   function cancelOperation(){\r\n\t// this function cancels the main operation in this page\r\n\t   cancelAppointment();\r\n   }\r\n   \r\n   function postOperation(errorCodeStr){\r\n\t// this function performs some more actions post\r\n\t// the main operation\r\n\t   postBookAppointment(errorCodeStr);\r\n   }\r\n   \r\n </script>    \r\n\r\n</head>\r\n<body>\r\n\r\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\r\n\r\n<div id=\"wrapper\" style=\"background-color: #ffffff;\">\r\n<div class=\"fixedheader\">\t\r\n<header id=\"header\">\r\n    <div id=\"headerinfo\">\r\n        <div class=\"row\">\r\n\t\t\t<div id=\"headervisitinfo\">\r\n                \tWelcome back! Your last visit was on Wed, Dec 5, 2012 12:47:08 PM \r\n            </div>    \r\n            <div id=\"headerloginas\">\r\n                \t <strong>Welcome, ";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 =", ID:";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="</strong>\r\n            </div>\r\n            <div id=\"headerlogout\">\r\n\t\t\t\t<div><a href=\"../../servlet/LogoutServlet\"  class=\"logout\">\r\n                    Logout</a>\r\n\t\t\t\t</div>\r\n            </div>\r\n        </div>\r\n    </div>\r\n</header>\r\n    <!-- #header-->\r\n    <!-- #logo And Menu -->\r\n\r\n<div id=\"logomenu\">\r\n\t<div class=\"row\">\r\n    \t<div id=\"logo\">\r\n\t\t\t<img src=\"../../images/logo.png\"> \r\n        </div>\r\n        <div id=\"Menubox\">\r\n\t\t\t<ul class=\"menu\">\r\n                <li><a href=\"../Contact.jsp\"><div class=\"menuicons\"><img src=\"../../images/Contact.png\"/></div>Contact</a></li>\r\n                <li><a href=\"../result/DetailedResult.jsp\"><div class=\"menuicons\"><img src=\"../../images/Results.png\"/></div>My Results</a></li>\r\n                <li class=\"menuselect\"><div class=\"menuicons\"><img src=\"../../images/Appointment.png\"/></div>My Appointments</li>\r\n                <li><a href=\"../PortalHome.jsp\"><div class=\"menuicons\"><img src=\"../../images/Home.png\"/></div>Home</a></li>\r\n            </ul>\r\n        </div>\r\n    </div>\r\n</div>\r\n</div>\r\n   <!-- #logo And Menu -->\r\n   \r\n<div class=\"line\"></div>\r\n\t<div id=\"content\" style=\"padding-bottom: 15px;\">\r\n     <!-- #Patient Banner-->\r\n       <!-- #Patient Banner-->\r\n\t   <!-- #Content Area-->\r\n     \t<div id=\"contentbg\">\r\n\t\t</div>\r\n\t\t\t<div id=\"contentArea\">\r\n\t\t\t\r\n\t\t\t\t<div id=\"contentArearow\">\r\n\t\t\t\t<div id=\"booknewbreadcrumb\"><span class=\"contenbold\"><a href=\"./UpcomingAppointments.jsp\" class=\"backpage\">My appointments</a></span> <span class=\"contenbold\" id=\"arrow\">></span> <span class=\"contenbold\">Book new appointment request</span></div>\r\n\t\t\t\t<form id=\"timeslotform\" name=\"timeslotform\" method=\"POST\"> \r\n\t\t\t\t<div class=\"row\">\r\n\t\t\t\t\t<div class=\"cellindex searchindex\" >\r\n\t\t\t\t\t\t<div id=\"BooknewAppsearch\">\r\n\t\t\t\t\t\t\t<div class=\"BookAppTitle\"  >\r\n\t\t\t\t\t\t\t\t<a class=\"rectitle\" href=\"BooknewAppoinmentRecentSearch.html\">Recent doctor</a>\r\n\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t<div class=\"BookAppTitle\">\r\n\t\t\t\t\t\t\t\t<a class=\"rectitle\"> Modify search</a>\r\n\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t<div id=\"SearchPanel\" style=\"height:330px;\">\r\n\t\t\t\t\t\t\t\t<div class=\"searchfields\">\r\n\t\t\t\t\t\t\t\t\t<div class=\"Apptitle\">Preferred date</div>\r\n\t\t\t\t\t\t\t\t\t<!-- <input class=\"textboxdatesearch\" type=\"text\" placeholder=\"Date\"/> -->\r\n\t\t\t\t\t\t\t\t\t<input id=\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\" name=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\" value=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\" style=\"width:180px;\" />\r\n\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t<div class=\"searchfields\">\r\n\t\t\t\t\t\t\t\t\t<div class=\"Apptitle \">Preferred time</div>\r\n\t\t\t\t\t\t\t\t\t<select class=\"Combotimesearch\" id=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"\r\n\t\t\t\t\t\t\t\t\t\t\tname=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\">\r\n\t\t\t\t\t\t\t\t\t ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\r\n\t\t\t\t\t\t\t\t    \t<option value=\"\" selected=\"selected\">Select time</option>\r\n\t\t\t\t\t\t\t\t    ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\r\n\t\t\t\t\t\t\t\t\t\t<option value=\"\">Select time</option>\r\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\t\r\n\t\t\t\t\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</option>\r\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\r\n\t\t\t\t\t\t\t\t\t</select>\r\n\t\t\t\t\t\t\t\t\t<span id=\"spacing\"></span>\r\n\t\t\t\t\t\t\t\t\t<span >to</span>\r\n\t\t\t\t\t\t\t\t\t<select class=\"Combotimesearch\" id=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" \r\n\t\t\t\t\t\t\t\t\t</select>\r\n\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t<!-- facility is introduced here -->\r\n\t\t\t\t\t\t\t\t<div class=\"searchfields\">\r\n\t\t\t\t\t\t\t\t<div class=\"Apptitle\">Facility</div>\r\n\t\t\t\t\t\t\t\t <select class=\"textbox\" id=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" style=\"width: 175px;\">\r\n\t\t\t       \t\t\t\t   \t<option value=\"\" selected=\"selected\">----All----</option>\r\n\t\t\t       \t\t\t\t   \t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\t\t\t\r\n\t\t\t\t\t\t\t\t\t  \t<option value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" selected=\"selected\">";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</option>\r\n\t\t\t\t\t\t\t\t\t  \t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\r\n\t\t\t\t\t\t\t\t\t  \t<option value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</option>\t\t\r\n\t\t\t\t\t\t\t\t  \t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\r\n\t\t\t       \t\t\t\t  </select> \r\n\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t<div class=\"searchfieldsSpeciality\">\r\n\t\t\t\t\t\t\t\t\t<div class=\"Apptitle\">Speciality</div>\r\n\t\t\t\t\t\t\t\t\t<div id=\"DetailedSearch\"  style=\"height:107px;\">\r\n\t\t\t\t\t\t\t\t\t\t<input class=\"textboxtimeSpeciality\" type=\"text\"  id=\"specialitySearchText\" name=\"specialitySearchText\" placeholder=\"Search\"><img id=\"specialitySearch\" src=\"../../images/Search.png\" onclick=\"searchSpeciality()\"/></input>\r\n\t\t\t\t\t\t\t\t\t\t<div class=\"specialityDiv\" style=\"height:80px;\">\r\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\r\n\t\t\t\t\t\t\t\t\t\t\t<span class=\"options selectedopt\" id=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" style=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =";padding-left:10px;padding-top:5px;padding-right:10px;padding-bottom:5px;\" onclick=\"selectSpeciality(this,\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\')\">Not Known</span>\r\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" value=\"\">\r\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\r\n\t\t\t\t\t\t\t\t\t\t\t<span class=\"options\" id=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\r\n\t\t\t\t\t\t\t\t\t\t\t<span class=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\"  id=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\')\">";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</span>\r\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">\r\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\r\n\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t<span class=\"btn marginalign\" onclick=\"getPractitionerList()\">Search</span>\r\n\t\t\t\t\t\t</div>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t\t\t<div class=\"tablebooknewapp\"> \r\n\t\t\t\t\t\t\t<div class=\"row\">\r\n\t\t\t\t\t\t\t\t<div class=\"celldivider\">\r\n\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t<div class=\"cellindex bookingcell\">\r\n\t\t\t\t\t\t\t\t\t<div id=\"BooknewAppDoctor\">\r\n\t\t\t\t\t\t\t\t\t\t<div class=\"SelectionViewboonnew\" style=\"background-image:url(\'../../images/Book.PNG\');height:508px;width:1000px;\">\r\n\t\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t\t<div id=\"SelectLeftPanelbooknew\" style=\"height:483px;width:47.4%;\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"DoctorAppRescheduletime\" style=\"width:380px;\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"DoctorDetailStripTimeReschedule\"  style=\"width:372px;\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"DoctorInnerstrip\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ImageSchedule\"><img class=\"doctorIcon\" src=\"../../images/doctor.png\"/></div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"DocDetailsTime\" style=\"width:270px;\"><span class=\"contenbold\">";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</span><br/>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"contentnormal\">";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t<!--  this div is only for containing an error message\r\n\t\t\t\t\t\t\t\t\t\t\t\t      if the practitioner schedule status cannot be obtained\r\n\t\t\t\t\t\t\t\t\t\t\t\t -->\r\n\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"errorMessageDiv\" name=\"errorMessageDiv\" style=\"display:none;margin-left:auto;margin-right:auto;min-height: 30px;width:380px;border: 1px solid #CDCDCD;\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t<span id=\"errorMessageSpan\" name=\"errorMessageSpan\" class=\"loginerror\" style=\"padding-left: 10px;\"></span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"bookcontent\" >\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"Apptime\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"calender \">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<!-- <img src=\"../../images/calendar2013.PNG\"/> -->\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\"\r\n\t\t\t               \t\t\t\t\t\t\t\t\t\tname=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" \r\n\t\t\t               \t\t\t\t\t\t\t\t\t\tstyle=\"width: 262px;\">\r\n\t\t\t               \t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"availability\"><div id=\"available\"></div>Available</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"availability\"><div id=\"full\"></div>Full</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"availability\"><div id=\"leave\"></div>Leave</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ApptitleReschedule contenbold\" >Preferred time</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<select class=\"textboxtimeindex\"  \r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tid=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" \r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tname=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" >\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"\" selected=\"selected\">Select time</option>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t ";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"\">Select time</option>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</option>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</select>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span >to</span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<select class=\"textboxtimeindex\" \r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tid=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\" >\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"\" selected=\"selected\">Select time</option>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t ";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"\">Select time</option>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="</option>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</select>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"SelectedDate\">Selected date: \r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"centeralign ReschedulebtnBottom\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span><a href=\"#\" onclick=\"checkTimeSlot()\" class=\"PPbtn\">Check time slot</a></span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t\t<div id=\"SelectRightPanelbooknew\" style=\"height:483px;\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\r\n\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"timesloterrordiv\" name=\"timesloterrordiv\" style=\"margin-left:auto;margin-right:auto;min-height: 25px;width:445px;border: 1px solid #CDCDCD;padding-top: 5px;\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"loginerror\" style=\"padding-left: 10px;\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t</span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"width:99%;margin:10px;min-height: 300px;\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t<table width=\"98%\" cellpadding=\"0\" cellspacing=\"0\" style=\"border:1px solid #cdcdcd;min-height: 290px;\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<th style=\"height:25px;background-color: #E9E9E9;border-bottom:1px solid #ffffff;border-right:1px solid #AFAFAF;\">AM</th>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<th style=\"height:25px;background-color: #E9E9E9;border-bottom:1px solid #ffffff;\">PM</th>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"border-right:1px solid #AFAFAF;\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"border-right:1px solid #AFAFAF;\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\r\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"preferredtime\"><div id=\"prefer\"></div>Preferred time</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"Selected\">Selected date and time: ";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 =", <span id=\"selectedtimespan\">";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 =" - ";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="</span></div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"centeralign ReschedulebtnBottom\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t<span><a class=\"disabled\" style=\"float:center;\">Book an appointment</a></span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\t\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\r\n\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"timesloterrordiv\" name=\"timesloterrordiv\" style=\"margin-left:auto;margin-right:auto;min-height: 25px;width:445px;border: 1px solid #CDCDCD;padding-top: 5px;\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"loginerror\">Could not get time slot information.\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t</span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"width:99%;margin:10px;min-height: 300px;\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t<table width=\"98%\" cellpadding=\"0\" cellspacing=\"0\" style=\"border:1px solid #cdcdcd;min-height: 290px;\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<th style=\"height:25px;background-color: #E9E9E9;border-bottom:1px solid #ffffff;border-right:1px solid #AFAFAF;\">AM</th>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<th style=\"height:25px;background-color: #E9E9E9;border-bottom:1px solid #ffffff;\">PM</th>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"border-right:1px solid #AFAFAF;\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"border-right:1px solid #AFAFAF;\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\r\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"preferredtime\"><div id=\"prefer\"></div>Preferred time</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"Selected\">Selected date and time: ";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\r\n\t\t\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"width:99%;margin:10px;\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t<table width=\"98%\" cellpadding=\"0\" cellspacing=\"0\" style=\"border:1px solid #cdcdcd;\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<th style=\"height:25px;background-color: #E9E9E9;border-bottom:1px solid #ffffff;border-right:1px solid #AFAFAF;\">AM</th>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<th style=\"height:25px;background-color: #E9E9E9;border-bottom:1px solid #ffffff;\">PM</th>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"border-right:1px solid #AFAFAF;\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"timeslottd\" valign=\"top\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<!--  for morning records -->\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table cellpadding=\"0\" cellspacing=\"0\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  <tr>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td height=\"100%\" valign=\"top\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table height=\"100%\"  cellpadding=\"0\" cellspacing=\"0\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\" class=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\" onclick=\"selectTimeSlot(this,\'";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td height=\"100%\" style=\"margin-left: 2px;\"  valign=\"top\"  width=\"50%\" style=\"min-width:50%;border-right:1px solid #AFAFAF;\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<!--  for evening records -->\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table cellpadding=\"0\" cellspacing=\"0\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td height=\"100%\" valign=\"top\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table cellpadding=\"0\" cellspacing=\"0\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"preferredtime\"><div id=\"prefer\"></div>Preferred time</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"Selected\">Selected date and time: ";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="</span></div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"centeralign ReschedulebtnBottom\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t<span><a onclick=\"confirmAppointmentRequest()\"  class=\"PPbtn\">Book an appointment request</a></span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\r\n\t\t\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t\t</div><!-- end of right panel -->\r\n\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\r\n\t\t\t\t</div>\r\n\t\t\t\t\t\t\r\n\t\t\t\t<!-- div to show the confirmation popup -->\r\n\t\t\t\t<div id=\"requestConfirmContainerDiv\" class=\"confirmpopupContainerStyle\" style=\"visibility:hidden;\">\r\n\t\t\t\t\t<div id=\"requestConfirmDiv\" class=\"confirmpopupContentStyle\" style=\"visibility:hidden;\">\r\n\t\t\t\t\t</div>\r\n\t\t\t\t</div>\r\n\t\t\t\t\r\n\t\t\t\t<!--  div to perform the book appointment request and then show result popup -->\r\n\t\t\t\t<div id=\"bookapptRequestContainerDiv\" class=\"bookapptContainerStyle\" style=\"visibility:hidden;\">\r\n\t\t\t\t\t<div id=\"bookapptContentDiv\" class=\"bookapptpopupContentStyle\" style=\"visibility:hidden;\">\r\n\t\t\t\t\t</div>\r\n\t\t\t\t</div>\t\t\t\r\n\t\t\t\t\t\t\r\n\t\t\t\t\t\t<!-- put the hidden elements here -->\r\n\t\t\t\t\t<input type=\"hidden\" id=\"hdnSpecialityIndex\" name=\"hdnSpecialityIndex\" value=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\">\t\r\n\t\t\t\t \t<input type=\"hidden\" id=\"hdnSelectedSpeciality\" name=\"hdnSelectedSpeciality\" value=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\">\r\n\t\t\t\t\t<input type=\"hidden\" id=\"hdnFacilityId\" name=\"hdnFacilityId\" value=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\">\r\n\t\t\t\t\t<input type=\"hidden\" id=\"hdnPreferredDate\" name=\"hdnPreferredDate\" value=\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\">\r\n\t\t\t\t\t";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\r\n\t\t\t\t\t<input type=\"hidden\" id=\"hdnPractitionerId\" name=\"hdnPractitionerId\" value=\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\">\r\n\t\t\t\t\t<input type=\"hidden\" id=\"hdnClinicCode\" name=\"hdnClinicCode\" value=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\">\r\n\t\t\t\t\t<input type=\"hidden\" id=\"hdnSelectedSpecialtyDesc\" name=\"hdnSelectedSpecialtyDesc\" value=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\">\r\n\t\t\t\t\t<input type=\"hidden\" id=\"hdnSelectedFacilityDesc\" name=\"hdnSelectedFacilityDesc\" value=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\">\r\n\t\t\t\t\t<input type=\"hidden\" id=\"hdnSelectedTimeSlot\" name=\"hdnSelectedTimeSlot\" value=\"\">\r\n\t\t\t\t\t<input type=\"hidden\" id=\"hdnPractitionerName\" name=\"hdnPractitionerName\" value=\"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\">\r\n\t\t\t\t\t<input type=\"hidden\" id=\"hdnPreferredDateInTimeSlotFrame\" name=\"hdnPreferredDateInTimeSlotFrame\" value=\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\">\r\n\t\t\t\t\t<input type=\"hidden\" id=\"hdnSelectedTimeSlotDivId\" name=\"hdnSelectedTimeSlotDivId\" value=\"\">\r\n\t\t\t \t</form> \r\n\t\t\t\t\t\t\r\n\t\t\t\t</div> \r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t</div>\r\n       <!-- #Content Area-->\r\n        \r\n\t\r\n    <!-- #content-->\r\n\t<div class=\"clear\"></div>\r\n\t<div class=\"Footerbg\" style=\"margin-top:5px;\">\r\n\t\r\n\t<div id=\"poweredby\">\r\n\t\t\t<p class=\"poweredby\">Powered by <img src=\"../../images/csc.png\" width=\"25\" height=\"14\"></p>\r\n        </div>\r\n</div>\r\n</div>\r\n</div>\r\n<!-- #wrapper -->\r\n\r\n\r\n</body>\r\n</html>\r\n";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

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

	// read the input parameters
	String selectedSpecialityCode = request
			.getParameter("hdnSelectedSpeciality");
	if (selectedSpecialityCode == null) {
		selectedSpecialityCode = "";
	}

	String facilityId = request
			.getParameter(CreateAppointmentConstants.APPT_PREFERREDFACILITY_PARAMETER_KEY);
	if (facilityId == null) {
		facilityId = "";
	}

	// this is the preferred date from the left hand side search panel
	String preferredDateStr = request
			.getParameter(CreateAppointmentConstants.APPT_PREFERREDDATE_PARAMETER_KEY);
	if (preferredDateStr == null) {
		preferredDateStr = request.getParameter("hdnPreferredDate");
		if (preferredDateStr == null) {
			preferredDateStr = "";
		}
	}
	
	// this is the preferred date given in the time slot frame
	String preferredDateInTimeSlotFrame = request.getParameter("hdnPreferredDateInTimeSlotFrame");
	if(preferredDateInTimeSlotFrame == null || preferredDateInTimeSlotFrame.trim().equals("")){
		preferredDateInTimeSlotFrame = preferredDateStr;
	}

	String preferredFromTime = request
			.getParameter(CreateAppointmentConstants.APPT_PREFERREDFROMTIME_PARAMETER_KEY);
	if (preferredFromTime == null) {
		preferredFromTime = "";
	}

	String preferredToTime = request
			.getParameter(CreateAppointmentConstants.APPT_PREFERREDTOTIME_PARAMETER_KEY);
	if (preferredToTime == null) {
		preferredToTime = "";
	}

	String practitionerId = request.getParameter("hdnPractitionerId");
	if (practitionerId == null) {
		practitionerId = "";
	}

	String clinicCode = request.getParameter("hdnClinicCode");
	if (clinicCode == null) {
		clinicCode = "";
	}

	String practitionerName = request
			.getParameter("hdnPractitionerName");
	if (practitionerName == null) {
		practitionerName = "";
	}

	String selectedSpecialityDescription = request
			.getParameter("hdnSelectedSpecialtyDesc");
	if (selectedSpecialityDescription == null) {
		selectedSpecialityDescription = "";
	}

	String timeslotFromTime = request
			.getParameter(CreateAppointmentConstants.TIMESLOT_PREFERREDFROMTIME_PARAMETER_KEY);
	if (timeslotFromTime == null || timeslotFromTime.trim().equals("")) {
		timeslotFromTime = preferredFromTime;
	}

	String timeslotToTime = request
			.getParameter(CreateAppointmentConstants.TIMESLOT_PREFERREDTOTIME_PARAMETER_KEY);
	if (timeslotToTime == null || timeslotToTime.trim().equals("")) {
		timeslotToTime = preferredToTime;
	}
	
	// there are two time selections in the GUI page
	// the time selection in the time slot section overrides the time selection
	// in the left hand side panel - override the time selection here
	if(!timeslotFromTime.equalsIgnoreCase(preferredFromTime)){
		preferredFromTime = timeslotFromTime;
	}
	if(!timeslotToTime.equalsIgnoreCase(preferredToTime)){
		preferredToTime = timeslotToTime;
	}
	
	// selected facility description is also read now
	// used for GUI
	String selectedFacilityDescription = request.getParameter("hdnSelectedFacilityDesc");
	if(selectedFacilityDescription == null){
		selectedFacilityDescription = "";
	}

	//Invoking Speciality service to polpulate the speciality dropdown
	/* SpecialitySvcImpl ssvcImpl = new SpecialitySvcImpl(); */
	SpecialityRequest srequest = new SpecialityRequest();
	srequest.setPatientId(patientId);
	srequest.setPortalUserName(PortalConstants.PORTALUSER_REQUEST_PARAM_VALUE);
	/* ssvcImpl.registerService(srequest); */
	SpecialityServiceInvoker specialityServiceInvoker = new SpecialityServiceInvoker();
	specialityServiceInvoker.registerService(srequest);
	SpecialityResponse sresponse = (SpecialityResponse) specialityServiceInvoker
			.getDataThroughWebService(srequest);

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(patientName));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(CreateAppointmentConstants.APPT_PREFERREDDATE_PARAMETER_KEY));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(CreateAppointmentConstants.APPT_PREFERREDDATE_PARAMETER_KEY));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(preferredDateStr));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(CreateAppointmentConstants.APPT_PREFERREDFROMTIME_PARAMETER_KEY));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(CreateAppointmentConstants.APPT_PREFERREDFROMTIME_PARAMETER_KEY));
            _bw.write(_wl_block9Bytes, _wl_block9);

									 	// check for empty alone is fine
									 	if (preferredFromTime.trim().equals("")) {
									 
            _bw.write(_wl_block10Bytes, _wl_block10);

								    	} else {
								    
            _bw.write(_wl_block11Bytes, _wl_block11);

										}
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
										// used for storing the selected style
										String selected = "";
										// iterate through the list and show the time
										for (AppointmentTime apptTime : apptStartTimeList) {
											selected = "";
											apptTimeValue = apptTime.getAppointmentTime();
											apptDataValue = apptTime.getAppointmentDataValue();
											/* if (preferredFromTime.equalsIgnoreCase(apptTimeValue)) {
												selected = "selected";
											} */
											if (preferredFromTime.equalsIgnoreCase(apptDataValue)) {
												selected = "selected";
											}
									
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(apptDataValue));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(selected));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(apptTimeValue));
            _bw.write(_wl_block15Bytes, _wl_block15);

											}
										
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(CreateAppointmentConstants.APPT_PREFERREDTOTIME_PARAMETER_KEY));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(CreateAppointmentConstants.APPT_PREFERREDTOTIME_PARAMETER_KEY));
            _bw.write(_wl_block9Bytes, _wl_block9);

									 	// check for empty alone is fine
									 	if (preferredToTime.trim().equals("")) {
									 
            _bw.write(_wl_block10Bytes, _wl_block10);

								    	} else {
								    
            _bw.write(_wl_block11Bytes, _wl_block11);

										}
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
											/* if (preferredToTime.equalsIgnoreCase(apptTimeValue)) {
												selected = "selected";
											} */
											if (preferredToTime.equalsIgnoreCase(apptDataValue)) {
												selected = "selected";
											}
									
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(apptDataValue));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(selected));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(apptTimeValue));
            _bw.write(_wl_block15Bytes, _wl_block15);

											}
										
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(CreateAppointmentConstants.APPT_PREFERREDFACILITY_PARAMETER_KEY));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(CreateAppointmentConstants.APPT_PREFERREDFACILITY_PARAMETER_KEY));
            _bw.write(_wl_block18Bytes, _wl_block18);

			       				   		// get the facility list as a normal java service
			       				   		// this is done only to improve performance
			       				   		FacilityListRequest facilityListRequest = new FacilityListRequest();
			       				   		facilityListRequest
			       				   				.setPortalUserName(PortalConstants.PORTALUSER_REQUEST_PARAM_VALUE);

			       				   		/* FacilityListSvcImpl facilityListSvcImpl = new FacilityListSvcImpl();
			       				   		FacilityListResponse facilityListResponse = facilityListSvcImpl
			       				   				.getFacilityList(facilityListRequest); */
										FacilityListServiceInvoker facilityListServiceInvoker = new FacilityListServiceInvoker();
										FacilityListResponse facilityListResponse = facilityListServiceInvoker.getDataThroughService(facilityListRequest);
			       				   		
			       				   		/* ErrorInfo facilityListErrorInfo = facilityListResponse
			       				   				.getErrorInfo(); */
			       				   		List<Facility> facilityList = null;
			       				   		/* if (ErrorInfo.SUCCESS_CODE == facilityListErrorInfo.getErrorCode()) { */
			       				   		if (facilityListResponse.isSuccessful()) {	
			       				   			facilityList = facilityListResponse.getFacilityList();
			       				   			for (Facility facility : facilityList) {
			       				   				if (facilityId.equalsIgnoreCase(facility.getFacilityId())) {
			       				   	
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(facility.getFacilityId()));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(facility.getFacilityName()));
            _bw.write(_wl_block21Bytes, _wl_block21);

									  		} else {
									  	
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(facility.getFacilityId()));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(facility.getFacilityName()));
            _bw.write(_wl_block24Bytes, _wl_block24);

										  			}
								  				}
								  			}
								  		
            _bw.write(_wl_block25Bytes, _wl_block25);

												int specialityIndex = 1;
												String specialityCodeVal = "SpecialityCode" + specialityIndex;
												String specialityId = "Speciality" + specialityIndex;
												String selectedStyle = "options";
												String spanDisplayStyle = "display:block";
												// this is for empty speciality
												if (selectedSpecialityCode.trim().equals("")) {
											
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(specialityId));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(specialityId));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(spanDisplayStyle));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(specialityCodeVal));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(specialityCodeVal));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(specialityCodeVal));
            _bw.write(_wl_block30Bytes, _wl_block30);

												} else {
											
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(specialityId));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(specialityId));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(spanDisplayStyle));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(specialityCodeVal));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(specialityCodeVal));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(specialityCodeVal));
            _bw.write(_wl_block30Bytes, _wl_block30);

												}
												// code to show the specialities 
												List<SpecialityModel> specialityList = null;
												String specialityCode;
												String specialityDescription;
												// iterate through the speciality list	
												// and show it in the UI
												if(sresponse.isSuccessful()){
													specialityList = sresponse
															.getSpecialityList();	
													if (specialityList != null) {
														for (SpecialityModel s : specialityList) {
															selectedStyle = "options";
															specialityCode = s.getSpecialityCode();
															specialityDescription = s.getShortDesc();
															// check if the selected speciality
															// equals any of the specialities
															// obtained from the service
															if (selectedSpecialityCode.equals(specialityCode)) {
																selectedStyle = "options selectedopt";
															}
	
															specialityIndex++;
															specialityId = "Speciality" + specialityIndex;
															specialityCodeVal = "SpecialityCode" + specialityIndex;
											
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(selectedStyle));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(specialityId));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(specialityId));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(spanDisplayStyle));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(specialityCodeVal));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(specialityDescription));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(specialityCodeVal));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(specialityCodeVal));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(specialityCode));
            _bw.write(_wl_block36Bytes, _wl_block36);

														}
													}
												}
											
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(practitionerName));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(selectedSpecialityDescription));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(selectedFacilityDescription ));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(CreateAppointmentConstants.APPT_PREFERREDDATE_TIMESLOT_PARAMETER_KEY));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(CreateAppointmentConstants.APPT_PREFERREDDATE_TIMESLOT_PARAMETER_KEY));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(CreateAppointmentConstants.TIMESLOT_PREFERREDFROMTIME_PARAMETER_KEY));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(CreateAppointmentConstants.TIMESLOT_PREFERREDFROMTIME_PARAMETER_KEY));
            _bw.write(_wl_block43Bytes, _wl_block43);

																if (apptStartTimeList == null || apptStartTimeList.isEmpty()) {
																	apptFromTimeResponse = ScheduleHelper
																			.getAppointmentTimeResponse(apptFromTimeRequest);
																	apptStartTimeList = apptFromTimeResponse
																			.getAppointmentTimeList();
																}

																if (timeslotFromTime.trim().equals("")) {
															
            _bw.write(_wl_block44Bytes, _wl_block44);

															 	} else {
															 
            _bw.write(_wl_block45Bytes, _wl_block45);

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
																	/* if (timeslotFromTime.equalsIgnoreCase(apptTimeValue)) {
																		selected = "selected";
																	} */
																	if (timeslotFromTime.equalsIgnoreCase(apptDataValue)) {
																		selected = "selected";
																	}
															
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(apptDataValue));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(selected));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(apptTimeValue));
            _bw.write(_wl_block47Bytes, _wl_block47);

																}
															
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(CreateAppointmentConstants.TIMESLOT_PREFERREDTOTIME_PARAMETER_KEY));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(CreateAppointmentConstants.TIMESLOT_PREFERREDTOTIME_PARAMETER_KEY));
            _bw.write(_wl_block49Bytes, _wl_block49);

															if (apptToTimeList == null || apptToTimeList.isEmpty()) {
																apptToTimeResponse = ScheduleHelper
																		.getAppointmentTimeResponse(apptFromTimeRequest);
																apptToTimeList = apptToTimeResponse.getAppointmentTimeList();
															}

															if (timeslotToTime.trim().equals("")) {
														
            _bw.write(_wl_block50Bytes, _wl_block50);

														 	} else {
														 
            _bw.write(_wl_block51Bytes, _wl_block51);

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
																if (timeslotToTime.equalsIgnoreCase(apptDataValue)) {
																	selected = "selected";
																}
														
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(apptDataValue));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(selected));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(apptTimeValue));
            _bw.write(_wl_block52Bytes, _wl_block52);

															}
														
            _bw.write(_wl_block53Bytes, _wl_block53);

															String preferredDateDisplayStr = ScheduleHelper
																	.getPreferredDateInDisplayFormat(
																			preferredDateInTimeSlotFrame,
																			CreateAppointmentConstants.PRACTITIONERSTATUS_DATEFORMAT,
																			CreateAppointmentConstants.PRACTITIONERTIMESLOT_DATE_DISPLAY_FORMAT);
															out.println(preferredDateDisplayStr);
														
            _bw.write(_wl_block54Bytes, _wl_block54);

													// code to get the time slot information
													// initialize the request first
													PractitionerTimeSlotRequest timeSlotRequest = new PractitionerTimeSlotRequest();
													timeSlotRequest.setFacilityId(facilityId);
													timeSlotRequest.setPractitionerId(practitionerId);
													timeSlotRequest.setClinicCode(clinicCode);
													timeSlotRequest.setClinicType(CreateAppointmentConstants.PRACTITIONERSCHEDULESTATUS_DEFAULT_CLINICTYPE);
													timeSlotRequest.setResourceType(CreateAppointmentConstants.PRACTITIONER_SERVICE_RESOURCECLASS_DEFAULT_VALUE);
													timeSlotRequest.setLocale(Locale.getDefault().getLanguage());
													timeSlotRequest.setPreferredDate(preferredDateInTimeSlotFrame);
													timeSlotRequest.setPortalUserName(PortalConstants.PORTALUSER_REQUEST_PARAM_VALUE);
													
													/* PractitionerTimeSlotSvcImpl timeSlotSvcImpl = new PractitionerTimeSlotSvcImpl();
													timeSlotSvcImpl.registerService(timeSlotRequest); */
													
													PractitionerTimeSlotServiceInvoker timeSlotServiceInvoker = new PractitionerTimeSlotServiceInvoker();
													timeSlotServiceInvoker.registerService(timeSlotRequest);
													PractitionerTimeSlotResponse timeSlotResponse = (PractitionerTimeSlotResponse)timeSlotServiceInvoker.getDataThroughWebService(timeSlotRequest);
													
													/* ErrorInfo timeSlotErrorInfo = timeSlotResponse.getErrorInfo(); */
													String errorMessage = null;
													/* if(ErrorInfo.SUCCESS_CODE != timeSlotErrorInfo.getErrorCode()){ */
													if(!timeSlotResponse.isSuccessful()){	
														errorMessage = timeSlotResponse.getErrorMessage();
												
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(errorMessage ));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(preferredDateDisplayStr));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(ScheduleHelper.getApptSelectedTimeInDisplayFormat(timeslotFromTime) ));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(ScheduleHelper.getApptSelectedTimeInDisplayFormat(timeslotToTime) ));
            _bw.write(_wl_block59Bytes, _wl_block59);

													}else{
														List<List<TimeSlot>> morningAndEveningTimeSlots = timeSlotResponse.getMorningAndEveningTimeSlots();
														// no need to check for null - it will be only empty at worst
														if(morningAndEveningTimeSlots.isEmpty()){
												
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(preferredDateDisplayStr));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(ScheduleHelper.getApptSelectedTimeInDisplayFormat(timeslotFromTime) ));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(ScheduleHelper.getApptSelectedTimeInDisplayFormat(timeslotToTime) ));
            _bw.write(_wl_block59Bytes, _wl_block59);
		
														}else{
															// morning time slots are placed at 0th index
														List<TimeSlot> morningTimeSlots = morningAndEveningTimeSlots.get(0);
														List<TimeSlot> eveningTimeSlots = morningAndEveningTimeSlots.get(1);
														
														String updatedPreferredFromTime = ScheduleHelper.
																getApptSelectedTimeInDisplayFormat(timeslotFromTime);
														String updatedPreferredToTime = ScheduleHelper.
																getApptSelectedTimeInDisplayFormat(timeslotToTime);
														
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
														
												
            _bw.write(_wl_block61Bytes, _wl_block61);

																if(!morningTimeSlots.isEmpty()){
															
            _bw.write(_wl_block62Bytes, _wl_block62);
			
																	int morningTimeSlotCount = morningTimeSlots.size();
																	 
																	while(columnCounter < NUMBER_OF_COLUMN){
																		
															
            _bw.write(_wl_block63Bytes, _wl_block63);

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
																
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(timeSlotDivId ));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(timeSlotStyle));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(timeSlotDivId ));
            _bw.write(_wl_block34Bytes, _wl_block34);
out.print(timeSlot.getStartTime()+" - "+timeSlot.getEndTime());compCounter++;
            _bw.write(_wl_block67Bytes, _wl_block67);
					
																		}
																		
																		// need to check this once more 
																		if(compCounter == morningTimeSlotCount){
																	
            _bw.write(_wl_block68Bytes, _wl_block68);
	
																			break;
																		}
																		//compCounter++;
																		columnCounter++;
																	
            _bw.write(_wl_block68Bytes, _wl_block68);
	
																	}
																	
            _bw.write(_wl_block69Bytes, _wl_block69);
	
																}
															
            _bw.write(_wl_block70Bytes, _wl_block70);

																columnCounter = 0;
																compCounter = 0;
																timeSlotStyle = null;
																if(!eveningTimeSlots.isEmpty()){
															
            _bw.write(_wl_block71Bytes, _wl_block71);
		
																	int eveningTimeSlotCount = eveningTimeSlots.size();
																	while(columnCounter < NUMBER_OF_COLUMN){
															
            _bw.write(_wl_block72Bytes, _wl_block72);

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
																
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(timeSlotDivId ));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(timeSlotStyle));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(timeSlotDivId ));
            _bw.write(_wl_block34Bytes, _wl_block34);
compCounter++;out.print(timeSlot.getStartTime()+" - "+timeSlot.getEndTime());
            _bw.write(_wl_block67Bytes, _wl_block67);
					
																		}
																		
																		// need to check this once more 
																		if(compCounter == eveningTimeSlotCount){
																	
            _bw.write(_wl_block68Bytes, _wl_block68);
	
																			break;
																		}
																		//compCounter++;
																		columnCounter++;
																	
            _bw.write(_wl_block68Bytes, _wl_block68);
		
																	}
																	
            _bw.write(_wl_block69Bytes, _wl_block69);
	
																}
															
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(preferredDateDisplayStr));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(ScheduleHelper.getApptSelectedTimeInDisplayFormat(timeslotFromTime) ));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(ScheduleHelper.getApptSelectedTimeInDisplayFormat(timeslotToTime) ));
            _bw.write(_wl_block74Bytes, _wl_block74);

														}
													}
												
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(specialityIndex));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(selectedSpecialityCode));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(preferredDateStr));
            _bw.write(_wl_block79Bytes, _wl_block79);
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(practitionerId));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(clinicCode));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(selectedSpecialityDescription));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(selectedFacilityDescription));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(practitionerName));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(preferredDateInTimeSlotFrame));
            _bw.write(_wl_block86Bytes, _wl_block86);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
