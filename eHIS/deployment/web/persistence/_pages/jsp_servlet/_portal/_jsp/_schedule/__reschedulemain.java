package jsp_servlet._portal._jsp._schedule;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.Calendar;
import portalrefimpl.schedule.createappointment.response.PractitionerModel;
import portalrefimpl.schedule.createappointment.response.PractitionerResponse;
import portalrefimpl.schedule.createappointment.svc.serviceinvoker.PractitionerServiceInvoker;
import java.util.Locale;
import portalrefimpl.schedule.createappointment.CreateAppointmentConstants;
import portalrefimpl.schedule.createappointment.request.PractitionerRequest;
import portalrefimpl.schedule.rescheduleappointment.RescheduleRequestConstants;
import java.sql.Timestamp;
import portalrefimpl.schedule.createappointment.AppointmentTime;
import java.util.List;
import portalrefimpl.schedule.ScheduleHelper;
import portalrefimpl.schedule.createappointment.AppointmentTimeResponse;
import portalrefimpl.schedule.createappointment.AppointmentTimeRequest;
import portalrefimpl.PortalHelper;
import java.util.Date;
import portalrefimpl.schedule.apptrequestdetails.response.DetailsResponse;
import portalrefimpl.schedule.apptrequestdetails.svc.DetailsServiceInvoker;
import portalrefimpl.PortalConstants;
import portalrefimpl.schedule.apptrequestdetails.request.DetailsRequest;
import portalrefimpl.schedule.ScheduleConstants;

public final class __reschedulemain extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/portal/jsp/schedule/RescheduleMain.jsp", 1669269355984L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n<html>\r\n<head>\r\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n<title>::: Patient Portal - Reschedule Appointment</title>\r\n\r\n<meta name=\"keywords\" content=\"\" />\r\n<meta name=\"description\" content=\"\" />\r\n<link rel=\"stylesheet\" href=\"../../css/style.css\" type=\"text/css\"/>\r\n<link rel=\"stylesheet\" href=\"../../css/style_ie.css\" type=\"text/css\"/>\r\n<link href=\"../../css/examples-offline.css\" rel=\"stylesheet\">\r\n<link href=\"../../css/kendo.common.min.css\" rel=\"stylesheet\">\r\n<link href=\"../../css/kendo.default.min.css\" rel=\"stylesheet\">\r\n\r\n<script src=\"../../js/jquery.min.js\"></script>\r\n<script src=\"../../js/kendo.web.min.js\"></script>\r\n<script src=\"../../js/console.js\"></script>\r\n<script src=\"../../js/date.js\"></script>\r\n<script>\r\n $(document).ready(function() {\r\n         var today = new Date();\r\n      // create DatePicker from input HTML element\r\n         $(\"#preferredDateFromPage\").kendoDatePicker({\r\n        \t    format: \"dd/MM/yyyy\"\r\n         });\r\n });\r\n \r\n function showPractitionerSchedule(practitionerId,practitionerName){\r\n\t // this function submits the form to show the practitioner schedule\r\n\t // information in a pop up window\r\n\t/*  var patientIdComp = document.getElementById(\"hdnPatientId\");\r\n\t if(patientIdComp){\r\n\t\t patientIdComp.value = practitionerId;\r\n\t } */\r\n\t var datePickerComp = document.getElementById(\"preferredDateFromPage\");\r\n\t var dateTimePicker = $(\"#preferredDateFromPage\").data(\"kendoDatePicker\");\r\n\t var preferredApptDate;\r\n\t //var fromDate = dateTimePicker.value();\r\n\t //var calendar = $(\"#ApptPreferredDate\").data(\"kendoCalendar\");\r\n\t if(datePickerComp){\r\n\t\t if(dateTimePicker){\r\n\t\t\t preferredApptDate = dateTimePicker.value();\r\n\t\t }else{\r\n\t\t\t preferredApptDate = datePickerComp.value;\r\n\t\t }\r\n\t }\r\n\t //preferredApptDate = dateTimePicker.value();\r\n\t var dateValue = \"\"+preferredApptDate.getDate()+\"/\"+(preferredApptDate.getMonth()+1)+\"/\"+preferredApptDate.getFullYear();\r\n\t \r\n\t var hiddenSpecialityComp = document.getElementById(\"hdnSpecialtyId\");\r\n\t var selectedSpeciality=\"\";\r\n\t if(hiddenSpecialityComp){\r\n\t\t selectedSpeciality = hiddenSpecialityComp.value;\r\n\t }\r\n\t /* var selectedSpeciality = $(\"#Speciality\").find(\'option:selected\').val(); */\r\n\t var hiddenSpecialityDescComp = document.getElementById(\"hdnSpecialtyDesc\");\r\n\t var selectedSpecialityDesc = \"\";\r\n\t if(hiddenSpecialityDescComp){\r\n\t\t selectedSpecialityDesc = hiddenSpecialityDescComp.value;\r\n\t }\r\n\t /* var selectedSpecialityDesc = $(\"#Speciality\").find(\'option:selected\').text(); */\r\n\t var facilityComp = document.getElementById(\"hdnFacilityId\");\r\n\t var selectedFacilityId = \"\";\r\n\t if(facilityComp){\r\n\t\t selectedFacilityId = facilityComp.value;\r\n\t }\r\n\t \r\n\t var facilityDescComp = document.getElementById(\"hdnFacilityDesc\");\r\n\t var selectedFacilityDesc = \"\";\r\n\t if(facilityDescComp){\r\n\t\t selectedFacilityDesc = facilityDescComp.value;\r\n\t }\r\n\t \r\n\t /* var selectedFacility = $(\"#Facility\").find(\'option:selected\').val();\r\n\t var selectedFacilityDesc = $(\"#Facility\").find(\'option:selected\').text(); */\r\n\t \r\n\t // selected from time\r\n\t var selectedFromTime = $(\"#fromTimeInPage\").find(\'option:selected\').val();\r\n\t selectedFromTime = trimText(selectedFromTime);\r\n\t if(selectedFromTime.length == 0){\r\n\t\t var originalFromTimeComp = document.getElementById(\"fromTimeInPage\");\r\n\t\t if(originalFromTimeComp){\r\n\t\t\t selectedFromTime = originalFromTimeComp.value;\r\n\t\t }\r\n\t }\r\n\t \r\n\t // selected to time\r\n\t var selectedToTime = $(\"#toTimeInPage\").find(\'option:selected\').val();\r\n\t selectedToTime = trimText(selectedToTime);\r\n\t if(selectedToTime.length == 0){\r\n\t\t var originalToTimeComp = document.getElementById(\"toTimeInPage\");\r\n\t\t if(originalToTimeComp){\r\n\t\t\t selectedToTime = originalToTimeComp.value;\r\n\t\t }\r\n\t }\r\n\t \r\n\t // escape\r\n\t selectedFacilityDesc = escape(selectedFacilityDesc);\r\n\t selectedSpecialityDesc = escape(selectedSpecialityDesc);\r\n\t practitionerName = escape(practitionerName);\r\n\t \r\n\t var popupUrl = \"./PractitionerScheduleServlet?\";\r\n\t popupUrl += \"ApptPreferredDate=\"+dateValue;\r\n\t popupUrl +=\"&FacilityId=\"+selectedFacilityId;\r\n\t popupUrl +=\"&FacilityDesc=\"+selectedFacilityDesc;\r\n\t popupUrl +=\"&SpecialityId=\"+selectedSpeciality;\r\n\t popupUrl +=\"&SpecialityDesc=\"+selectedSpecialityDesc;\r\n\t popupUrl +=\"&ApptPreferredFromTime=\"+selectedFromTime;\r\n\t popupUrl +=\"&ApptPreferredToTime=\"+selectedToTime;\r\n\t popupUrl +=\"&PractitionerId=\"+practitionerId;\r\n\t popupUrl +=\"&PractitionerName=\"+practitionerName;\r\n\t \t \r\n\t  // load the div with URL\r\n\t    $(\'#practScheduleDiv\').load(popupUrl);\r\n\t    \r\n\t\tif (document.getElementById(\'practScheduleContainerDiv\').style.visibility == \'hidden\') {\r\n\t       document.getElementById(\'practScheduleContainerDiv\').style.visibility = \'\';\r\n\t       $(\"#practScheduleContainerDiv\").hide();\r\n\t    }\r\n\t    if (document.getElementById(\'practScheduleDiv\').style.visibility == \'hidden\') {\r\n\t       document.getElementById(\'practScheduleDiv\').style.visibility = \'\';\r\n\t       $(\"#practScheduleDiv\").hide();\r\n\t    }\r\n\t\t\r\n\t\t$(\"#practScheduleContainerDiv\").fadeIn(200, \"linear\", function () { $(\"#practScheduleDiv\").show(300, \"swing\"); });\r\n\t \r\n\t \r\n\t \r\n\t/*  var winLeft = (screen.width - 795)/2;\r\n\t var winTop = (screen.height - 495)/2;\r\n\t var popupWindow = window.open(popupUrl,\'PractitionerSchedule\',\'height=290,width=620,top=\'+winTop+\',left=\'+winLeft+\',resizable=no,scrollbars=yes,toolbar=no,menubar=no,location=no,directories=no,addressbar=no,status=no,titlebar=no\');\r\n\t return false; */\r\n\t \r\n\t \r\n\t /* var formElement = document.getElementById(\"bookappointmentform\");\r\n\t $(\"#bookappointmentform\").attr(\"action\",\"./PractitionerScheduleServlet\");\r\n\t $(\"#bookappointmentform\").submit(); */\r\n\t \r\n }\r\n \r\n function closePractitionerSchedulePopup(){\r\n\t// this function will close the practitioner schedule popup dialog\r\n\t$(\"#practScheduleDiv\").hide(\'300\', \"swing\", function () { $(\"#practScheduleContainerDiv\").fadeOut(\"200\"); });\r\n }\r\n \r\n function showMorePractitioner(){\r\n\t // this function will show more practitioners\r\n\t \r\n\t // first get the different counts needed\r\n\t // the counts are - 1. total practitioners 2. current count of displayed practitioners\r\n\t // 3. practitioner bucket count\r\n\t \r\n\t // 1. total practitioners\r\n\t var totalPractCountComp = document.getElementById(\"totalPractitionerCount\");\r\n\t var totalPractCountStr = \"\";\r\n\t var totalPractCount = 0;\r\n\t if(totalPractCountComp){\r\n\t\t totalPractCountStr = totalPractCountComp.value;\r\n\t\t totalPractCount = parseInt(totalPractCountStr);\r\n\t }\r\n\t // 2. current count of displayed practitioners\r\n\t var currPractCountComp = document.getElementById(\"currentPractitionerCount\");\r\n\t var currPractCountStr = \"\";\r\n\t var currPractCount = 0;\r\n\t if(currPractCountComp){\r\n\t\t currPractCountStr = currPractCountComp.value;\r\n\t\t currPractCount = parseInt(currPractCountStr);\r\n\t }\r\n\t // 3. practitioner bucket count\r\n\t var practDisplayBucketComp = document.getElementById(\"practitionerDisplayBucket\");\r\n\t var practDisplayBucketStr = \"\";\r\n\t var practDisplayBucket = 0;\r\n\t if(practDisplayBucketComp){\r\n\t\t practDisplayBucketStr = practDisplayBucketComp.value;\r\n\t\t practDisplayBucket = parseInt(practDisplayBucketStr);\r\n\t }\r\n\t \r\n\t // this var stores the practitioners to be shown now\r\n\t var practToBeDisplayedCount = currPractCount + practDisplayBucket;\r\n\t if(totalPractCount < (currPractCount + practDisplayBucket)){\r\n\t\t practToBeDisplayedCount = totalPractCount; \r\n\t }\r\n\t var practitionerComp;\r\n\t // iterate and display the practitioner\r\n\t for(count=(currPractCount+1);count<=practToBeDisplayedCount;count++){\r\n\t\t practitionerComp = document.getElementById(\"Practitioner\"+count);\r\n\t\t if(practitionerComp){\r\n\t\t\t practitionerComp.style.display = \"block\";\r\n\t\t }\r\n\t }\r\n\t \r\n\t // now check and hide the click for more component\r\n\t if(practToBeDisplayedCount == totalPractCount){\r\n\t\t var clickMoreComp = document.getElementById(\"ClickMore\");\r\n\t\t if(clickMoreComp){\r\n\t\t\t clickMoreComp.style.display = \"none\";\r\n\t\t }\r\n\t }\r\n\t \r\n\t \r\n\t // finally set the current practitioner count to the latest practitioner\r\n\t // shown\r\n\t if(currPractCountComp){\r\n\t\t currPractCountComp.value = practToBeDisplayedCount;\r\n\t }\r\n\t \r\n }\r\n \r\n function handleKeyDownInSearchField(e){\r\n\t // this function handles enter button press after specifying text\r\n\t // in the search doctor field\r\n\t var x = e || window.event;\r\n\t var key = (x.keyCode || x.which);\r\n\t if(key == 13 || key == 3){\r\n\t  \tsearchPractitioner();\r\n\t }\r\n }\r\n \r\n function searchPractitioner(){\r\n\t // this function lets a user search for practitioners in the page\r\n\t // get the search text first\r\n\t var searchTextComp = document.getElementById(\"searchtextbox\");\r\n\t var searchText = \"\";\r\n\t if(searchTextComp){\r\n\t\t searchText = searchTextComp.value;\r\n\t\t searchText = searchText.toUpperCase();\r\n\t\t // below code is for trimming the search text\r\n\t\t // this code is done to support any browser\r\n\t\t // that is why in built js functions are not used\r\n\t\t var l=0; var r=searchText.length -1;\r\n\t\t while(l < searchText.length && searchText[l] == \' \'){\r\n\t\t\t  l++;\r\n\t\t }\r\n\t\t\t\r\n\t\t while(r > l && searchText[r] == \' \'){\r\n\t\t\tr-=1;\r\n\t\t }\r\n\t\t searchText = searchText.substring(l, r+1);\r\n\t }\r\n\t // get the total practitioner count\r\n\t // this is needed for iterating through the practitioner\r\n\t // components and then match the name with the search text\r\n\t var totalPractitionerCountComp = document.getElementById(\"totalPractitionerCount\");\r\n\t var totalPractitionerCount = 0;\r\n\t try{\r\n\t\t totalPractitionerCount = parseInt(totalPractitionerCountComp.value);\t \r\n\t }catch(e){\r\n\t\t totalPractitionerCount = 0;\r\n\t }\r\n\t \r\n\t // code to check if the search text is empty text\r\n\t // if so, we need to show all the practitioner components\r\n\t if(searchText == \'\'){\r\n\t\t for(count=1;count<=totalPractitionerCount;count++){\r\n\t\t\t practitionerIdComp = document.getElementById(\"Practitioner\"+count);\r\n\t\t\t if(practitionerIdComp){\r\n\t\t\t\t practitionerIdComp.style.display = \"block\";\r\n\t\t\t }\r\n\t\t }\r\n\t\t return;\r\n\t }\r\n\t \r\n\t // now iterate through the practitioner components\r\n\t var practitionerNameComp;\r\n\t var practitionerName;\r\n\t for(count=1;count<=totalPractitionerCount;count++){\r\n\t\t practitionerNameComp = document.getElementById(\"PractitionerName\"+count);\r\n\t\t practitionerIdComp = document.getElementById(\"Practitioner\"+count);\r\n\t\t if(practitionerNameComp && practitionerIdComp){\r\n\t\t\t practitionerName = practitionerNameComp.value;\r\n\t\t\t practitionerName = practitionerName.toUpperCase();\r\n\t\t\t \r\n\t\t\t textIndex = practitionerName.indexOf(searchText);\r\n\t\t\t if(textIndex != 0){\r\n\t\t\t\t practitionerIdComp.style.display = \"none\";\r\n\t\t\t }else{\r\n\t\t\t\t practitionerIdComp.style.display = \"block\";\r\n\t\t\t }\r\n\t\t }\r\n\t }\r\n }\r\n \r\n function getPractitionerList(){\r\n\t // this function gets the practitioner list again\r\n\t // when user clicks on search on the left panel\r\n\t \r\n\t // first validate the user inputs and if validation fails\r\n\t // show the error message and do not submit the page\r\n\t \r\n\t // stores the validation message\r\n\t var validationMessage = \"\";\r\n\t \r\n\t // first validate the fields in the GUI\r\n\t var datePickerComp = document.getElementById(\"preferredDateFromPage\");\r\n\t var datePicker = $(\"#preferredDateFromPage\").data(\"kendoDatePicker\");\r\n\t var preferredApptDate;\r\n\t // get the preferred date from the date picker component or\r\n\t // the generalized element\r\n\t if(datePickerComp){\r\n\t\t if(datePicker){\r\n\t\t\t preferredApptDate = datePicker.value();\r\n\t\t }else{\r\n\t\t\t preferredApptDate = new Date(datePickerComp.value);\r\n\t\t }\r\n\t }\r\n     //preferredApptDate = datePicker.value();\r\n     if(isNaN(preferredApptDate)){\r\n    \t validationMessage = \"Preferred date \"+preferredApptDate+\" is not valid. \\n\";\r\n     }\r\n     \r\n    var currentDate = new Date();\r\n     \r\n\t // time validation\r\n\tvar selectedFromTimeComp = document.getElementById(\"fromTimeInPage\");\r\n\tvar selectedFromTimeIndex;\r\n\tvar selectedFromTime = \"\";\r\n\tif(selectedFromTimeComp){\r\n\t\tselectedFromTimeIndex = selectedFromTimeComp.selectedIndex;\r\n\t\tselectedFromTime = selectedFromTimeComp.value;\r\n\t}\r\n\t\r\n\tvar selectedToTimeIndex;\r\n\tvar selectedToTimeComp = document.getElementById(\"toTimeInPage\");\r\n\tvar selectedToTime = \"\";\r\n\tif(selectedToTimeComp){\r\n\t\tselectedToTimeIndex = selectedToTimeComp.selectedIndex;\r\n\t\tselectedToTime = selectedToTimeComp.value;\r\n\t\tselectedToTime = trimText(selectedToTime);\r\n\t}\r\n\t\r\n\tvar selectedTimeIsInvalid = false;\r\n\tif(selectedFromTime.length == 0 && selectedToTime.length == 0){\r\n\t\tvalidationMessage += \"Appointment start and end time is not specified. \\n\";\r\n\t\tselectedTimeIsInvalid = true;\r\n\t}else if(selectedFromTime.length == 0){\r\n\t\tvalidationMessage += \"Appointment start time is not specified. \\n\";\r\n\t\tselectedTimeIsInvalid = true;\r\n\t}else if(selectedToTime.length == 0){\r\n\t\tvalidationMessage += \"Appointment end time is not specified. \\n\";\r\n\t\tselectedTimeIsInvalid = true;\r\n\t}else if(selectedFromTime == selectedToTime){\r\n\t\tvalidationMessage += \"Appointment start and end time cannot be same. \\n\";\r\n\t\tselectedTimeIsInvalid = true;\r\n\t}\r\n\t\r\n\t//alert(selectedFromTime+\' || \'+selectedToTime);\r\n\t\r\n\tvar delimiter = \":\";\r\n\tvar dotIndex = selectedFromTime.indexOf(delimiter);\r\n\tvar hrsStr = \"\";\r\n\tvar hrs = 0;\r\n\tvar minsStr = \"\";\r\n\tvar mins = 0;\r\n\tif(dotIndex > 0){\r\n\t\thrsStr = selectedFromTime.substring(0,dotIndex);\r\n\t\tminsStr = selectedFromTime.substring(dotIndex+1,selectedFromTime.length);\r\n\t\ttry{\r\n\t\t\thrs = parseInt(hrsStr);\t\r\n\t\t}catch(e){\r\n\t\t\thrs = 0;\r\n\t\t}\r\n\t\ttry{\r\n\t\t\tmins = parseInt(minsStr);\r\n\t\t}catch(e){\r\n\t\t\tmins = 0;\r\n\t\t}\r\n\t}\r\n\t// set the hours, minutes and the seconds\r\n\t// seconds will be set to 0 now\r\n\tif(!(isNaN(preferredApptDate))){\r\n\t\t//alert(hrs+ \' || \'+mins);\r\n\t\tpreferredApptDate.setHours(hrs);\r\n\t\tpreferredApptDate.setMinutes(mins);\r\n\t\tpreferredApptDate.setSeconds(0);\r\n\t\t\r\n\t\t// validate the appointment start time with current date only\r\n\t\t// when the start time is selected properly by user\r\n\t\tif((preferredApptDate < currentDate) && !selectedTimeIsInvalid){\r\n\t\t\tvalidationMessage += \"Appointment start time cannot be less than current time. \\n\";\r\n\t\t}\r\n\t}\r\n\t\r\n\t// validate the appointment start time with appointment end time only\r\n\t// when the start time and end time is selected properly by user\t\r\n\tif((selectedFromTimeIndex > selectedToTimeIndex) && !selectedTimeIsInvalid){\r\n\t\tvalidationMessage += \"Appointment start time cannot be greater than or equal to end time. \\n\";\r\n\t}\r\n\t\r\n\t// speciality and facility validation\r\n\t// first speciality\r\n\tvar hiddenSpecialityComp = document.getElementById(\"hdnSpecialtyId\");\r\n\tvar selectedSpeciality=\"\";\r\n\tif(hiddenSpecialityComp){\r\n\t\tselectedSpeciality = hiddenSpecialityComp.value;\r\n\t\tselectedSpeciality = trimText(selectedSpeciality);\r\n\t}\r\n\tif(selectedSpeciality.length == 0){\r\n\t\tvalidationMessage += \"Selected specialty is invalid. \\n\";\r\n\t}\r\n\t\r\n\t// validate selected facility\r\n\tvar selectedFacility = \"\";\r\n\tvar facilityComp = document.getElementById(\"hdnFacilityId\");\r\n\tif(facilityComp){\r\n\t\tselectedFacility = facilityComp.value;\r\n\t\tselectedFacility = trimText(selectedFacility);\r\n\t}\r\n\t\r\n\tif(selectedFacility.length == 0){\r\n\t\tvalidationMessage += \"Selected facility is invalid. \\n\";\r\n\t}\r\n\t\r\n\tif(validationMessage.length > 0){\r\n\t\talert(validationMessage);\r\n\t\treturn;\r\n\t}\r\n\t\r\n\t// need to set the values of hdnSelectedSpeciality,hdnSelectedSpecialityDesc\r\n\t//hdnPreferredDate - it is enough to set the hdnpreferreddate with value\r\n\t// hdnselectedspeciality and hdnselectedspecialitydesc is already set\r\n\t// with values\r\n\t//var dateTimePicker = $(\"#ApptPreferredDate\").data(\"kendoDatePicker\");\r\n\t//var preferredApptDate = dateTimePicker.value();\r\n\t\r\n\t// need to set value to hidden elements for the preferred date\r\n\t// and the preferred from and to time\r\n\tvar dateValue = \"\"+preferredApptDate.getDate()+\"/\"+(preferredApptDate.getMonth()+1)+\"/\"+preferredApptDate.getFullYear();\r\n\t// preferred date\r\n\tvar hdnPreferredDateComp = document.getElementById(\"preferredDateFromPage\");\r\n\tif(hdnPreferredDateComp){\r\n\t\thdnPreferredDateComp.value = dateValue;\r\n\t}\r\n\t\r\n\t// preferred from time\r\n\tvar hdnPreferredFromTimeComp = document.getElementById(\"fromTimeInPage\");\r\n\tif(hdnPreferredFromTimeComp){\r\n\t\thdnPreferredFromTimeComp.value = selectedFromTime;\r\n\t}\r\n\t\r\n\t// preferred to time\r\n\tvar hdnPreferredToTimeComp = document.getElementById(\"toTimeInPage\");\r\n\tif(hdnPreferredToTimeComp){\r\n\t\thdnPreferredToTimeComp.value = selectedToTime;\r\n\t}\r\n\t\r\n\tvar hdnApptReqRefNumber = document.getElementById(\"referenceNumber\");\r\n\tvar apptNumber=\"\";\r\n\tif(hdnApptReqRefNumber) {\r\n\t\tapptNumber = hdnApptReqRefNumber.value;\r\n\t}\r\n\t\r\n\tvar rescheduleApptReqURL = \"./ApptRequestDetailsServlet\";\r\n \t//rescheduleApptReqURL += \"?referenceNumber=\"+apptNumber;\r\n\t // finally all validations have passed - submit the form\r\n\tvar formElement = document.getElementById(\"RescheduleMainForm\");\r\n\t if(formElement){\r\n\t\t formElement.action = rescheduleApptReqURL;\r\n\t\t formElement.submit();\r\n\t }\r\n }\r\n \r\n function showPractitionerScheduleStatus(practitionerId,clinicCode,practitionerName){\r\n\t// this function transfers the control to the practitioner schedule\r\n\t// and time slot page\r\n\t\r\n\t // this function will set the page\'s form url and submit it\r\n\t var practitionerIdComp = document.getElementById(\"selectedPractitionerIdInPage\");\r\n\t if(practitionerIdComp){\r\n\t\t practitionerIdComp.value = practitionerId;\r\n\t }\r\n\t \r\n\t var clinicCodeComp = document.getElementById(\"hdnClinicCode\");\r\n\t if(clinicCodeComp){\r\n\t\t clinicCodeComp.value = clinicCode;\r\n\t }\r\n\t \r\n\t var practitionerNameComp = document.getElementById(\"selectedPractitionerNameInPage\");\r\n\t if(practitionerNameComp){\r\n\t\t practitionerNameComp.value = practitionerName;\r\n\t }\r\n\t \r\n\t \r\n\t var formElement = document.getElementById(\"RescheduleMainForm\");\r\n\t if(formElement){\r\n\t\t formElement.action = \"./ScheduleStatusAndTimeslotServlet\";\r\n\t\t formElement.submit();\r\n\t }\r\n }\r\n \r\n \r\n function trimText(textVal){\r\n\t // this function trims a text\r\n\t var l=0; var r=textVal.length -1;\r\n\t while(l < textVal.length && textVal[l] == \' \'){\r\n\t\t  l++;\r\n\t }\r\n\t\t\r\n\t while(r > l && textVal[r] == \' \'){\r\n\t\tr-=1;\r\n\t }\r\n\t textVal = textVal.substring(l, r+1);\r\n\t \r\n\t return textVal;\r\n }\r\n \r\n \r\n</script>\r\n\r\n<style scoped>\r\n .practSchedulePopupContainerStyle {\r\n      background-color: white;\r\n      opacity: 90%;\r\n      filter:alpha(opacity=90);\r\n      background-color: rgba(255,255,255,0.90); \r\n      width: 100%;\r\n      min-height: 100%;\r\n      overflow: hidden;\r\n      float: absolute;\r\n      position: fixed;\r\n      top: 0;\r\n      left: 0;\r\n      color: white;\r\n      \r\n      /* z-index: -1;\r\n      opacity:0%; */\r\n\t}\r\n\t\r\n\t.practSchedulePopupContentStyle{\r\n\t  background-color: white;\r\n      color: black;\r\n      \r\n      padding: 2px;\r\n      display:block;\r\n      position: absolute;\r\n      top: 30%;\r\n      left: 30%;\r\n      /* width : 0px;\r\n      height : 0px;\r\n      z-index: -1; */\r\n      width: 620px;\r\n      height: 290px; \r\n\t}\r\n \r\n </style>\r\n\r\n</head>\r\n<body>\r\n\r\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\r\n<div id=\"wrapper\">\r\n<div class=\"fixedheader\">\t\r\n<header id=\"header\">\r\n    <div id=\"headerinfo\">\r\n        <div class=\"row\">\r\n\t\t\t<div id=\"headervisitinfo\">\r\n                \tWelcome back! Your last visit was on Wed, Dec 5, 2012 12:47:08 PM \r\n            </div>    \r\n            <div id=\"headerloginas\">\r\n                \t <strong>Welcome, ";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 =", ID:";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="</strong>\r\n            </div>\r\n            <div id=\"headerlogout\">\r\n\t\t\t\t<div><a href=\"../../servlet/LogoutServlet\"  class=\"logout\">\r\n                    Logout</a>\r\n\t\t\t\t</div>\r\n            </div>\r\n        </div>\r\n    </div>\r\n</header>\r\n   \r\n    <!-- #header-->\r\n   \r\n    <!-- #logo And Menu -->\r\n\r\n<div id=\"logomenu\">\r\n\t<div class=\"row\">\r\n    \t<div id=\"logo\">\r\n\t\t\t<img src=\"../../images/logo.png\"> \r\n        </div>\r\n        <div id=\"Menubox\">\r\n\t\t\t<ul class=\"menu\">\r\n                <li><a href=\"../Contact.jsp\"><div class=\"menuicons\"><img src=\"../../images/Contact.png\"/></div>Contact</a></li>\r\n                <li><a href=\"../result/DetailedResult.jsp\"><div class=\"menuicons\"><img src=\"../../images/Results.png\"/></div>My Results</a></li>\r\n                <li class=\"menuselect\"><div class=\"menuicons\"><img src=\"../../images/Appointment.png\"/></div>My Appointments</li>\r\n                <li><a href=\"../PortalHome.jsp\"><div class=\"menuicons\"><img src=\"../../images/Home.png\"/></div>Home</a></li>\r\n            </ul>\r\n        </div>\r\n    </div>\r\n</div>\r\n</div>\r\n   <!-- #logo And Menu -->\r\n   \r\n<div class=\"line\"></div>\r\n\r\n\t<form id=\"RescheduleMainForm\" method=\"POST\">\r\n\t<div id=\"content\"  style=\"background-color: #ffffff;\">\r\n\t\r\n     <!-- #Patient Banner-->\r\n\t\t  \r\n       <!-- #Patient Banner-->\r\n\t   <!-- #Content Area-->\r\n     \t<div id=\"contentbg\">\r\n\t\t</div>\r\n\t\t\t<div id=\"contentArea\">\r\n\t\t\t\r\n\t\t\t\t<div id=\"contentArearow\">\r\n\t\t\t\t<div id=\"booknewbreadcrumb\"><span class=\"contenbold\"><a href=\"./UpcomingAppointments.jsp\" class=\"backpage\" >My Appointments</a></span> <span class=\"contenbold\" id=\"arrow\">></span> <span class=\"contenbold\">Reschedule Appointment</span></div>\r\n\t\t\t\t<div class=\"row\" >\r\n\t\t\t\t\t\t<div class=\"cellindex searchindex\" >\r\n\t\t\t\t\t\t<div id=\"BooknewAppsearch\">\r\n\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t<div class=\"BookAppTitle\">\r\n\t\t\t\t\t\t\t\t<a class=\"rectitle\">  Modify Search </a>\r\n\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t<div class=\"SearchPanelReschedule\">\r\n                                     \r\n                                <div class=\"searchfields\">\r\n                                <!--  code to check and show the data -->\r\n                                \t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\r\n                                \t<span class=\"loginerror\">";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</span>\r\n                                \t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\r\n\t\t\t\t\t\t\t\t\t<div class=\"Apptitle\">Specialty</div>\r\n\t\t\t\t\t\t\t\t\t<span>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</span>\r\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\r\n\t\t\t\t\t\t\t\t</div>\r\n                            \r\n\t\t\t\t\t\t\t\t<div class=\"searchfields\">\r\n\t\t\t\t\t\t\t\t\t<div class=\"Apptitle\">Preferred date</div>\r\n\t\t\t\t\t\t\t\t\t<!-- <input class=\"textboxdatesearch\" type=\"text\" placeholder=\"30 Jan 2013\"/> -->\r\n\t\t\t\t\t\t\t\t\t<input id=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" name=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" style=\"width:180px;\" />\r\n\t\t\t\t\t\t\t\t</div>\r\n                                \r\n\t\t\t\t\t\t\t\t<div class=\"searchfieldsSpeciality  \">\r\n\t\t\t\t\t\t\t\t\t<div class=\"Apptitle \">Preferred time</div>\r\n\t\t\t\t\t\t\t\t\t<select class=\"Combotimesearch\" id=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\"\r\n\t\t\t\t\t\t\t\t\t\t\tname=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\r\n\t\t\t\t\t\t\t\t\t\t<option value=\"\">Select time</option>\r\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\r\n\t\t\t\t\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =">";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</option>\r\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\r\n\t\t\t\t\t\t\t\t\t</select>\r\n\t\t\t\t\t\t\t\t\t<span id=\"spacing\"></span>\r\n\t\t\t\t\t\t\t\t\t<span >to</span>\r\n\t\t\t\t\t\t\t\t\t<select class=\"Combotimesearch\" id=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =" \r\n\t\t\t\t\t\t\t\t\t</select>\r\n\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t<span class=\"btn marginalign\" onclick=\"getPractitionerList()\">Search</span>\r\n\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t<div class=\"tablebooknewapp\" style=\"min-height: 450px;\"> \r\n\t\t\t\t\t\t\t<div class=\"row\">\r\n\t\t\t\t\t\t\t\t<div class=\"celldivider\">\r\n\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t<div class=\"cellindex bookingcell\">\r\n\t\t\t\t\t\t\t\t\t<div id=\"BooknewAppDoctor\">\r\n\t\t\t\t\t\t\t\t\t\t<div class=\"currentDetails\" >\r\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"title\">\r\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\r\n\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"loginerror\">";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</span>\r\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"contenbold marginalign\">Reschedule Appointment</span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t<span>Existing Appointment No: </span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t<span>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t<span>&nbsp;&nbsp;Date & time  </span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t<span>:</span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t<span>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =", </span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t<span>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =" - ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t<span>&nbsp;&nbsp;Doctor name: </span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t<span>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\t\r\n\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\r\n\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t<div id=\"DoctorStrip\">\r\n\t\t\t\t\t\t\t\t\t\t\t<div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"contenbold\">";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\r\n\t\t\t\t\t\t\t\t\t\t\t\t</span>\r\n\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\r\n\t\t\t\t\t\t\t\t\t\t<div id=\"BookingAppsearchresult\"  >\r\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"title\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t<span>Results for</span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"contenbold\">\" </span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"contenbold\">";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =", </span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"contenbold\">&nbsp;";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =" to ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =",&nbsp;  </span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"contenbold\">";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"contenbold\">\" </span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"floatright\">";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =" doctor (s)</span>\r\n\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\t<div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"contentnormal \">&nbsp;&nbsp;Search for doctor:</span><input class=\"textboxtimeSpeciality \" id=\"searchtextbox\" type=\"text\" placeholder=\"Search\" onkeydown=\"handleKeyDownInSearchField()\"><img id=\"specialitySearch\" onclick=\"searchPractitioner()\" src=\"../../images/Search.png\"/></input>\r\n\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t<!--Doctor app here-->\r\n\t\t\t\t\t\t\t\t\t\t<div id=\"DoctorStrip\">\r\n\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\r\n\t\t\t\t\t\t\t\t\t\t\t<span class=\"loginerror\">\r\n\t\t\t\t\t\t\t\t       ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\r\n\t\t\t\t\t\t\t\t\t\t</span>\r\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\r\n\t\t\t\t\t\t\t\t\t\t\t\t<!--strip here-->\r\n\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" class=\"DoctorApp\" style=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 =";height:110px;\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"DoctorDetailStrip\" style=\"height:102px;\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"DoctorInnerstrip\" style=\"height:100px;\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ImageSchedule\"><img class=\"doctorIcon\" src=\"../../images/doctor.png\"/><a class=\"ViewSchedulefont \" href=\"#\" onclick=\"showPractitionerSchedule(\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\',\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\')\">View schedule</a></div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"DocDetails\" style=\"height:60px;\"><span class=\"contenbold\">";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</span><br/>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"contentnormal\">";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span id=\"spacing\" class=\"btn\"><a href=\"#\" onclick=\"showPractitionerScheduleStatus(\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\')\" class=\"rectitle\"> Select</a></span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t<!--  code to set the practitioner name in a hidden field -->\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\" >\t\t\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\t<!--strip here-->\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\r\n\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t<!--Doctor app here-->\r\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\r\n\t\t\t\t\t\t\t\t\t\t<div id=\"BookingAppClickmore\" id=\"ClickMore\" style=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\">\r\n\t\t\t\t\t\t\t\t\t\t\t<span class=\"MoreResult\">Click for more</span>\r\n\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\r\n\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\r\n\t\t\t\t\t</div>\r\n\t\t\t\t</div> \r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t</div>\r\n       <!-- #Content Area-->\r\n       \t<!-- values obtained from service are stored in the below hidden elements -->\r\n       \t<!-- specialty id, specialty description, facility id, facility desc, -->\r\n       \t<!-- appointment reference number -->\r\n       \t<input type=\"hidden\" id=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\">\r\n       \t<input type=\"hidden\" id=\"hdnSpecialtyId\" name=\"hdnSpecialtyId\" value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\">\r\n       \t<input type=\"hidden\" id=\"hdnSpecialtyDesc\" name=\"hdnSpecialtyDesc\" value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">\r\n       \t<input type=\"hidden\" id=\"hdnFacilityId\" name=\"hdnFacilityId\" value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\">\r\n       \t<input type=\"hidden\" id=\"hdnFacilityDesc\" name=\"hdnFacilityDesc\" value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\">\r\n       \r\n       \t<!-- values selected from the page are stored in the below hidden elements -->\r\n       \t<input type=\"hidden\" id=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\">\r\n       \t<input type=\"hidden\" id =\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\">\r\n       \t<input type=\"hidden\" id=\"hdnClinicCode\" name=\"hdnClinicCode\" value=\"\">\r\n       \t<!-- for show more practitioners -->\r\n       \t<!--  the hidden vars used for display/hide of practitioner components -->\r\n\t\t<input type=\"hidden\" id=\"totalPractitionerCount\" name=\"totalPractitionerCount\" value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\">\r\n\t\t<input type=\"hidden\" id=\"currentPractitionerCount\" name=\"currentPractitionerCount\" value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\">\r\n\t\t<input type=\"hidden\" id=\"practitionerDisplayBucket\" name=\"practitionerDisplayBucket\" value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\">\r\n       \r\n       </form> \r\n\t\r\n    <!-- #content-->\r\n\r\n<div id=\"practScheduleContainerDiv\" class=\"practSchedulePopupContainerStyle\" style=\"visibility:hidden;\">\r\n\t<div id=\"practScheduleDiv\" class=\"practSchedulePopupContentStyle\" style=\"visibility:hidden;\">\r\n\t</div>\r\n</div>    \r\n    \r\n<div class=\"Footerbg\"  style=\"margin-top:0px;\">\r\n\t\r\n\t<div id=\"poweredby\">\r\n\t\t\t<p class=\"poweredby\">Powered by <img src=\"../../images/csc.png\" width=\"25\" height=\"14\"></p>\r\n    </div>\r\n</div>\r\n</div>\r\n<!-- #wrapper -->\r\n\r\n\r\n</body>\r\n</html>\r\n";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

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

// selected practitioner from the GUI
String practitionerFromPage = "";//request.getParameter(RescheduleRequestConstants.APPTREQ_DETAILS_PRACTITIONERID_PARAM);
String practitionerIdFromPage = "";//request.getParameter(RescheduleRequestConstants.APPTREQ_DETAILS_PRACTITIONERNAME_PARAM);

// get the appointment request details by executing the service
DetailsRequest detailsRequest = new DetailsRequest();
detailsRequest.setPatientId(patientId);
detailsRequest.setApptRequestReferenceNumber(appointmentReqRefNumber);
detailsRequest.setPortalUserName(PortalConstants.PORTALUSER_REQUEST_PARAM_VALUE);

DetailsServiceInvoker serviceInvoker = new DetailsServiceInvoker();
serviceInvoker.registerService(detailsRequest);
DetailsResponse detailsResponse = (DetailsResponse)serviceInvoker.getDataThroughWebService(detailsRequest);
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
	practitionerFromPage = detailsResponse.getResourceName();
	practitionerIdFromPage = detailsResponse.getResourceId();
	
	// this var should be set with an initial value of the preferred date + 1 day
	// on subsequent invocation, this var will store the user selected date
	if(preferredDateFromPage == null || preferredDateFromPage.trim().equals("")){
		if(preferredDateObj != null){
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(preferredDateObj);
			calendar.add(Calendar.DATE, 1);
			preferredDateObj = calendar.getTime();
			preferredDateFromPage = PortalHelper.getDateAsString(preferredDateObj,
					RescheduleRequestConstants.APPTREQ_DETAILS_DATE_DISPLAY_FORMAT);
		}else{
			preferredDateFromPage = preferredDateStr;	
		}
	}
	
}

//there is also a need to set the selected from time obtained from the page
// with a value if user has not selected it
/* if(preferredFromTimePage == null || preferredFromTimePage.trim().equals("")){
	preferredFromTimePage = preferredFromTimeDisplayStr;
}

// there is also a need to set the selected to time obtained from the page
// with a value if user has not selected it
if(preferredToTimePage == null || preferredToTimePage.trim().equals("")){
	preferredToTimePage = preferredToTimeDisplayStr;
} */


            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(patientName ));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(patientId ));
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

												// code to check if the response
												// is a failure - then show the 
												// error message
												if(!detailsResponseResult){
											
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(errorMessage ));
            _bw.write(_wl_block22Bytes, _wl_block22);

												}else{
													// success case - so show details
											
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(appointmentReqRefNumber ));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(preferredDateDisplayStr ));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(preferredFromTimeDisplayStr ));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(preferredToTimeDisplayStr ));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(practitionerFromPage ));
            _bw.write(_wl_block22Bytes, _wl_block22);

												}
											
            _bw.write(_wl_block28Bytes, _wl_block28);

											int totalPractitionerCount = 0;
										
											// code to check the appointment from and to times
											// if even one of it is null or empty
											// show a message accordingly
											if((preferredFromTimePage == null || preferredFromTimePage.trim().equals(""))
												|| (preferredToTimePage == null || preferredToTimePage.trim().equals(""))){
												String infoMessage = "Please select preferred time for the appointment request.";
										
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(infoMessage ));
            _bw.write(_wl_block30Bytes, _wl_block30);

											}else{

												// code to show the user selected
												// date and time
												// var to store the user specified
												// preferred date - used for display purpose
												String userSelectedPreferredDate = null;
												if(preferredDateFromPage != null && !preferredDateFromPage.trim().equals("")){
													// the preferred date from page var stores value
													// in the format "dd/MM/yyyy" but we have to display
													// in the format "dd mmm yyyy" - hence the below conversion
													Date dateFromPage = PortalHelper.getDateFromString
															(preferredDateFromPage, 
																RescheduleRequestConstants.APPTREQ_DETAILS_DATE_DISPLAY_FORMAT);
													if(dateFromPage != null){
														userSelectedPreferredDate = PortalHelper.getDateAsString
															(dateFromPage, 
																RescheduleRequestConstants.APPTREQ_DETAILS_DATE_DISPLAY_FORMAT2);
													}
												}else{
													preferredDateFromPage = preferredDateStr;
													userSelectedPreferredDate = preferredDateStr;
												}
												
												// execute the practitioner service to get the 
												// practitioner data
												PractitionerRequest practitionerRequest = new PractitionerRequest();
												practitionerRequest.setPatientId(patientId);
												practitionerRequest
														.setPortalUserName(PortalConstants.PORTALUSER_REQUEST_PARAM_VALUE);
												// specialty related data is set here
												practitionerRequest.setSpecialityCode(specialtyId);
												practitionerRequest.setSpecialityDesc(specialty);
												// facility related data is set here
												practitionerRequest.setFacilityId(facilityId);
												practitionerRequest.setFacilityDesc(facilityDesc);
												
												practitionerRequest
												.setOperationStandardId(CreateAppointmentConstants.PRACTITIONER_SERVICE_OPRSTN_DEFAULT_VALUE);
												practitionerRequest
														.setResourceClass(CreateAppointmentConstants.PRACTITIONER_SERVICE_RESOURCECLASS_DEFAULT_VALUE);
												practitionerRequest.setLocale(Locale.getDefault().getLanguage());
												
												// need to set the preferred date, from time and to time
												// variable preferredDateFromPage holds the value of the preferred date
												// in the format "dd/MM/yyyy" - this is fine so set it to the request
												practitionerRequest.setPreferredDateAsString(preferredDateFromPage);
											
												// vars preferredFromTimePage and preferredToTimePage will
												// contain the value of from time and to time - set it to the request
												practitionerRequest.setPreferredStartTime(preferredFromTimePage);
												practitionerRequest.setPreferredEndTime(preferredToTimePage);
												
												PractitionerServiceInvoker practitionerServiceInvoker = new PractitionerServiceInvoker();
												practitionerServiceInvoker.registerService(practitionerRequest);
												PractitionerResponse practitionerResponse = (PractitionerResponse) practitionerServiceInvoker
														.getDataThroughWebService(practitionerRequest);
												
												int practitionerCount = 0;
												List<PractitionerModel> practModelList = null;
												if(practitionerResponse.isSuccessful()){
													practModelList = practitionerResponse.getPractitionerModelList();
													practitionerCount = practModelList != null? practModelList.size():0; 
												}
											
										
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(userSelectedPreferredDate ));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(preferredFromTimePage ));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(preferredToTimePage ));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(specialty ));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(practitionerCount ));
            _bw.write(_wl_block36Bytes, _wl_block36);

											

											// this int denotes the practitioner count used
											// for displaying/hiding the practitioner
											int practitionerIndex = 1;
											String practitionerDisplayStyle = "display : block";
											final String PRACTITIONERID_PREFIX = "Practitioner";
											// constant to denote the prefix used for storing
											// the practitioner name in a hidden field
											// the hidden field is needed for search practitioner
											final String PRACTITIONERNAME_PREFIX = "PractitionerName";
											String practitionerIdString = null;
											String practitionerNameString = null;
											String practitionerErrorMessage = null;
											// code to check for the success or error of getting the practitioner list
											/* if (ErrorInfo.SUCCESS_CODE != practitionerErrorCode) { */
											if (!practitionerResponse.isSuccessful()) {	
												practitionerErrorMessage = practitionerResponse.getErrorMessage();	
											
										
            _bw.write(_wl_block37Bytes, _wl_block37);

								       		out.println(practitionerErrorMessage);
								       
            _bw.write(_wl_block38Bytes, _wl_block38);

											} else {
												// once code comes here we can safely assume that
												// there are practitioners 
												// assign the practitioner count variable
												totalPractitionerCount = practModelList.size();
												// this is where all the pracititioners will be displayed
												for (PractitionerModel practModel : practModelList) {
													if (practitionerIndex > CreateAppointmentConstants.PRACTITIONER_DISPLAY_RECORD_COUNT) {
														practitionerDisplayStyle = "display : none";
													}
													practitionerIdString = PRACTITIONERID_PREFIX
															+ practitionerIndex;

													practitionerNameString = PRACTITIONERNAME_PREFIX
															+ practitionerIndex;
													
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(practitionerIdString));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(practitionerDisplayStyle));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(practModel.getPractitionerId()));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(practModel.getPractitionerName()));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(practModel.getPractitionerName()));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(specialty));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(facilityDesc));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(practModel.getPractitionerId()));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(practModel.getClinicCode()));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(practModel.getPractitionerName()));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(practitionerNameString));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(practitionerNameString));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(practModel.getPractitionerName()));
            _bw.write(_wl_block47Bytes, _wl_block47);
	
													practitionerIndex++;
													}
												}
											
            _bw.write(_wl_block48Bytes, _wl_block48);

											String clickMoreDisplayStyle = "display : none";
											// check if there are more than 6 practitioners
											// then only "click for more" should be shown in the GUI
											if (totalPractitionerCount > CreateAppointmentConstants.PRACTITIONER_DISPLAY_RECORD_COUNT) {
												clickMoreDisplayStyle = "display : block";
											}
										
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(clickMoreDisplayStyle));
            _bw.write(_wl_block50Bytes, _wl_block50);

											}
										
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(RescheduleRequestConstants.GET_APPTREQUESTDETAILS_REFNUMBER_PARAM_KEY ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(RescheduleRequestConstants.GET_APPTREQUESTDETAILS_REFNUMBER_PARAM_KEY ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(appointmentReqRefNumber ));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(specialtyId ));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(specialty ));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(facilityId ));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(facilityDesc ));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(RescheduleRequestConstants.APPTREQ_DETAILS_PRACTITIONERID_PARAM ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(RescheduleRequestConstants.APPTREQ_DETAILS_PRACTITIONERID_PARAM ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(practitionerIdFromPage));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(RescheduleRequestConstants.APPTREQ_DETAILS_PRACTITIONERNAME_PARAM ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(RescheduleRequestConstants.APPTREQ_DETAILS_PRACTITIONERNAME_PARAM ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(practitionerFromPage ));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(totalPractitionerCount));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(CreateAppointmentConstants.PRACTITIONER_DISPLAY_RECORD_COUNT));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(CreateAppointmentConstants.PRACTITIONER_DISPLAY_RECORD_COUNT));
            _bw.write(_wl_block61Bytes, _wl_block61);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
