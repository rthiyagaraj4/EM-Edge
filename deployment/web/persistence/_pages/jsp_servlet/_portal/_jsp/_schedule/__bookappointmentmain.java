package jsp_servlet._portal._jsp._schedule;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.Locale;
import portalrefimpl.facility.facilityforpatient.response.FacilityListResponse;
import portalrefimpl.facility.facilityforpatient.request.FacilityListRequest;
import portalrefimpl.common.model.Facility;
import portalrefimpl.schedule.createappointment.response.PractitionerModel;
import portalrefimpl.common.response.ErrorInfo;
import portalrefimpl.schedule.createappointment.response.PractitionerResponse;
import portalrefimpl.schedule.createappointment.svc.serviceinvoker.PractitionerServiceInvoker;
import portalrefimpl.schedule.createappointment.request.PractitionerRequest;
import portalrefimpl.schedule.createappointment.AppointmentTimeResponse;
import portalrefimpl.schedule.createappointment.AppointmentTime;
import portalrefimpl.schedule.ScheduleConstants;
import portalrefimpl.schedule.createappointment.AppointmentTimeRequest;
import portalrefimpl.schedule.ScheduleHelper;
import java.util.List;
import portalrefimpl.schedule.createappointment.response.SpecialityModel;
import portalrefimpl.schedule.createappointment.response.SpecialityResponse;
import portalrefimpl.schedule.createappointment.svc.serviceinvoker.SpecialityServiceInvoker;
import portalrefimpl.schedule.createappointment.request.SpecialityRequest;
import portalrefimpl.PortalHelper;
import java.util.Date;
import portalrefimpl.schedule.createappointment.CreateAppointmentConstants;
import portalrefimpl.PortalConstants;
import portalrefimpl.facility.facilityforpatient.svc.FacilityListServiceInvoker;

public final class __bookappointmentmain extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/portal/jsp/schedule/BookAppointmentMain.jsp", 1669269355953L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n<html>\r\n<head>\r\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n<title>::: Patient Portal - Book Appointment :::</title>\r\n\r\n<meta name=\"keywords\" content=\"\" />\r\n<meta name=\"description\" content=\"\" />\r\n<link rel=\"stylesheet\" href=\"../../css/style.css\" type=\"text/css\"/>\r\n<link rel=\"stylesheet\" href=\"../../css/style_ie.css\" type=\"text/css\"/>\r\n<link href=\"../../css/examples-offline.css\" rel=\"stylesheet\">\r\n<link href=\"../../css/kendo.common.min.css\" rel=\"stylesheet\">\r\n<link href=\"../../css/kendo.default.min.css\" rel=\"stylesheet\">\r\n\r\n<script src=\"../../js/jquery.min.js\"></script>\r\n<script src=\"../../js/kendo.web.min.js\"></script>\r\n<script src=\"../../js/console.js\"></script>\r\n<script src=\"../../js/date.js\"></script>\r\n\r\n<script>\r\n $(document).ready(function() {\r\n         var today = new Date();\r\n      // create DatePicker from input HTML element\r\n         $(\"#ApptPreferredDate\").kendoDatePicker({\r\n        \t    format: \"dd/MM/yyyy\"\r\n         });\r\n });\r\n \r\n function searchSpeciality(){\r\n\t // this function performs the search when user clicks on search\r\n\t // after specifying the speciality\r\n\t \r\n\t // first get the text entered by user\r\n\t var searchTextComp = document.getElementById(\"specialitySearchText\");\r\n\t var searchText=\"\";\r\n\t if(searchTextComp){\r\n\t\t searchText = searchTextComp.value;\r\n\t\t // convert to upper case - this will be useful\r\n\t\t// for string comparision\t\t \r\n\t\t searchText = searchText.toUpperCase();\r\n\t }\r\n\t \r\n\t // below code is for trimming the search text\r\n\t // this code is done to support any browser\r\n\t // that is why in built js functions are not used\r\n\t var l=0; var r=searchText.length -1;\r\n\t  while(l < searchText.length && searchText[l] == \' \'){\r\n\t\t  l++;\r\n\t  }\r\n\t\t\r\n\twhile(r > l && searchText[r] == \' \'){\r\n\t\tr-=1;\r\n\t}\r\n\t  searchText = searchText.substring(l, r+1);\r\n\t  \r\n\t  // get the number of specialities shown in the GUI\r\n\t var specialityIndexCountComp = document.getElementById(\"hdnSpecialityIndex\");\r\n\t var specialityIndexCountStr;\r\n\t var specialityIndexCount = 0;\r\n\t if(specialityIndexCountComp){\r\n\t\t specialityIndexCountStr = specialityIndexCountComp.value;\r\n\t\t specialityIndexCount = parseInt(specialityIndexCountStr);\r\n\t }\r\n\t //alert(specialityIndexCount);\r\n\t \r\n\t var specialityIdComp;\r\n\t var specialityText;\r\n\t var textIndex=-1;\r\n\t  \r\n\t  // check if the search text is empty - if so\r\n\t  // bring back all the hidden elements \r\n\t if(searchText == \'\'){\r\n\t\t for(count=2;count<=specialityIndexCount;count++){\r\n\t\t\t specialityIdComp = document.getElementById(\"Speciality\"+count);\r\n\t\t\t if(specialityIdComp){\r\n\t\t\t\t specialityIdComp.style.display = \"block\";\r\n\t\t\t }\r\n\t\t }\r\n\t\t return;\r\n\t }\r\n\t\r\n\t // loop through the speciality components\r\n\t // and hide them if their value does not match the text entered\r\n\t for(count=2;count<=specialityIndexCount;count++){\r\n\t\t specialityIdComp = document.getElementById(\"Speciality\"+count);\r\n\t\t if(specialityIdComp){\r\n\t\t\t specialityText = specialityIdComp.innerHTML;\r\n\t\t\t // convert the text to upper case - usefull for\r\n\t\t\t // case insensitive string comparision\r\n\t\t\t specialityText = specialityText.toUpperCase();\r\n\t\t\t textIndex = specialityText.indexOf(searchText);\r\n\t\t\t if(textIndex != 0){\r\n\t\t\t\t specialityIdComp.style.display = \"none\";\r\n\t\t\t }else{\r\n\t\t\t\t specialityIdComp.style.display = \"block\";\r\n\t\t\t }\r\n\t\t }\r\n\t }\r\n\t \r\n }\r\n \r\n function selectSpeciality(spanElement,specialityCodeId,specialityDescId){\r\n\t // this function sets the background color of a selected specialty\r\n\t // this function also sets the hidden speciality elements with\r\n\t // the value of the selected speciality and the speciality description\r\n\t if(spanElement){\r\n\t\t spanElement.style.backgroundColor=\"#C1D994\";\r\n\t\t //alert(spanElement.id);\r\n\t }\r\n\t \r\n\t var hdnSpecialtySpanElementId = document.getElementById(\"hdnSelectedSpecialitySpanElementId\");\r\n\t if(hdnSpecialtySpanElementId){\r\n\t\t //alert(hdnSpecialtySpanElementId.value);\r\n\t\t var selectedSpanElementId = document.getElementById(hdnSpecialtySpanElementId.value);\r\n\t\t if(selectedSpanElementId){\r\n\t\t\t //selectedSpanElementId.style.backgroundColor=\"#FFFFFF\";\r\n\t\t\t selectedSpanElementId.className = \"options\";\r\n\t\t }\r\n\t\t hdnSpecialtySpanElementId.value = spanElement.id;\r\n\t }\r\n\t \r\n\t // set the selected speciality in the hidden element\r\n\t var specialityCodeElement = document.getElementById(specialityCodeId);\r\n\t var selectedSpecialityComp = document.getElementById(\"hdnSelectedSpeciality\");\r\n\t if(specialityCodeElement && selectedSpecialityComp){\r\n\t\t selectedSpecialityComp.value = specialityCodeElement.value;\r\n\t }\r\n\t \r\n\t // set the selected speciality\'s description in the hidden element\r\n\t var specialityDescElement = document.getElementById(specialityDescId);\r\n\t var selectedSpecialityDescComp = document.getElementById(\"hdnSelectedSpecialtyDesc\");\r\n\t if(specialityDescElement && selectedSpecialityDescComp){\r\n\t\t selectedSpecialityDescComp.value = specialityDescElement.value;\r\n\t }\r\n }\r\n \r\n function showMorePractitioner(){\r\n\t // this function will show more practitioners\r\n\t \r\n\t // first get the different counts needed\r\n\t // the counts are - 1. total practitioners 2. current count of displayed practitioners\r\n\t // 3. practitioner bucket count\r\n\t \r\n\t // 1. total practitioners\r\n\t var totalPractCountComp = document.getElementById(\"totalPractitionerCount\");\r\n\t var totalPractCountStr = \"\";\r\n\t var totalPractCount = 0;\r\n\t if(totalPractCountComp){\r\n\t\t totalPractCountStr = totalPractCountComp.value;\r\n\t\t totalPractCount = parseInt(totalPractCountStr);\r\n\t }\r\n\t // 2. current count of displayed practitioners\r\n\t var currPractCountComp = document.getElementById(\"currentPractitionerCount\");\r\n\t var currPractCountStr = \"\";\r\n\t var currPractCount = 0;\r\n\t if(currPractCountComp){\r\n\t\t currPractCountStr = currPractCountComp.value;\r\n\t\t currPractCount = parseInt(currPractCountStr);\r\n\t }\r\n\t // 3. practitioner bucket count\r\n\t var practDisplayBucketComp = document.getElementById(\"practitionerDisplayBucket\");\r\n\t var practDisplayBucketStr = \"\";\r\n\t var practDisplayBucket = 0;\r\n\t if(practDisplayBucketComp){\r\n\t\t practDisplayBucketStr = practDisplayBucketComp.value;\r\n\t\t practDisplayBucket = parseInt(practDisplayBucketStr);\r\n\t }\r\n\t \r\n\t // this var stores the practitioners to be shown now\r\n\t var practToBeDisplayedCount = currPractCount + practDisplayBucket;\r\n\t if(totalPractCount < (currPractCount + practDisplayBucket)){\r\n\t\t practToBeDisplayedCount = totalPractCount; \r\n\t }\r\n\t var practitionerComp;\r\n\t // iterate and display the practitioner\r\n\t for(count=(currPractCount+1);count<=practToBeDisplayedCount;count++){\r\n\t\t practitionerComp = document.getElementById(\"Practitioner\"+count);\r\n\t\t if(practitionerComp){\r\n\t\t\t practitionerComp.style.display = \"block\";\r\n\t\t }\r\n\t }\r\n\t \r\n\t // now check and hide the click for more component\r\n\t if(practToBeDisplayedCount == totalPractCount){\r\n\t\t var clickMoreComp = document.getElementById(\"ClickMore\");\r\n\t\t if(clickMoreComp){\r\n\t\t\t clickMoreComp.style.display = \"none\";\r\n\t\t }\r\n\t }\r\n\t \r\n\t \r\n\t // finally set the current practitioner count to the latest practitioner\r\n\t // shown\r\n\t if(currPractCountComp){\r\n\t\t currPractCountComp.value = practToBeDisplayedCount;\r\n\t }\r\n\t \r\n }\r\n \r\n function showPractitionerSchedule(practitionerId,practitionerName){\r\n\t // this function submits the form to show the practitioner schedule\r\n\t // information in a pop up window\r\n\t/*  var patientIdComp = document.getElementById(\"hdnPatientId\");\r\n\t if(patientIdComp){\r\n\t\t patientIdComp.value = practitionerId;\r\n\t } */\r\n\t var datePickerComp = document.getElementById(\"ApptPreferredDate\");\r\n\t var dateTimePicker = $(\"#ApptPreferredDate\").data(\"kendoDatePicker\");\r\n\t var preferredApptDate;\r\n\t //var fromDate = dateTimePicker.value();\r\n\t //var calendar = $(\"#ApptPreferredDate\").data(\"kendoCalendar\");\r\n\t if(datePickerComp){\r\n\t\t if(dateTimePicker){\r\n\t\t\t preferredApptDate = dateTimePicker.value();\r\n\t\t }else{\r\n\t\t\t preferredApptDate = datePickerComp.value;\r\n\t\t }\r\n\t }\r\n\t //preferredApptDate = dateTimePicker.value();\r\n\t var dateValue = \"\"+preferredApptDate.getDate()+\"/\"+(preferredApptDate.getMonth()+1)+\"/\"+preferredApptDate.getFullYear();\r\n\t \r\n\t var hiddenSpecialityComp = document.getElementById(\"hdnSelectedSpeciality\");\r\n\t var selectedSpeciality=\"\";\r\n\t if(hiddenSpecialityComp){\r\n\t\t selectedSpeciality = hiddenSpecialityComp.value;\r\n\t }\r\n\t /* var selectedSpeciality = $(\"#Speciality\").find(\'option:selected\').val(); */\r\n\t var hiddenSpecialityDescComp = document.getElementById(\"hdnSelectedSpecialtyDesc\");\r\n\t var selectedSpecialityDesc = \"\";\r\n\t if(hiddenSpecialityDescComp){\r\n\t\t selectedSpecialityDesc = hiddenSpecialityDescComp.value;\r\n\t }\r\n\t /* var selectedSpecialityDesc = $(\"#Speciality\").find(\'option:selected\').text(); */\r\n\t \r\n\t var selectedFacility = $(\"#Facility\").find(\'option:selected\').val();\r\n\t var selectedFacilityDesc = $(\"#Facility\").find(\'option:selected\').text();\r\n\t \r\n\t var selectedFromTime = $(\"#ApptPreferredFromTime\").find(\'option:selected\').val();\r\n\t var selectedToTime = $(\"#ApptPreferredToTime\").find(\'option:selected\').val();\r\n\t \r\n\t // escape\r\n\t selectedFacilityDesc = escape(selectedFacilityDesc);\r\n\t selectedSpecialityDesc = escape(selectedSpecialityDesc);\r\n\t practitionerName = escape(practitionerName);\r\n\t \r\n\t var popupUrl = \"./PractitionerScheduleServlet?\";\r\n\t popupUrl += \"ApptPreferredDate=\"+dateValue;\r\n\t popupUrl +=\"&FacilityId=\"+selectedFacility;\r\n\t popupUrl +=\"&FacilityDesc=\"+selectedFacilityDesc;\r\n\t popupUrl +=\"&SpecialityId=\"+selectedSpeciality;\r\n\t popupUrl +=\"&SpecialityDesc=\"+selectedSpecialityDesc;\r\n\t popupUrl +=\"&ApptPreferredFromTime=\"+selectedFromTime;\r\n\t popupUrl +=\"&ApptPreferredToTime=\"+selectedToTime;\r\n\t popupUrl +=\"&PractitionerId=\"+practitionerId;\r\n\t popupUrl +=\"&PractitionerName=\"+practitionerName;\r\n\t \t \r\n\t  // load the div with URL\r\n\t    $(\'#practScheduleDiv\').load(popupUrl);\r\n\t    \r\n\t\tif (document.getElementById(\'practScheduleContainerDiv\').style.visibility == \'hidden\') {\r\n\t       document.getElementById(\'practScheduleContainerDiv\').style.visibility = \'\';\r\n\t       $(\"#practScheduleContainerDiv\").hide();\r\n\t    }\r\n\t    if (document.getElementById(\'practScheduleDiv\').style.visibility == \'hidden\') {\r\n\t       document.getElementById(\'practScheduleDiv\').style.visibility = \'\';\r\n\t       $(\"#practScheduleDiv\").hide();\r\n\t    }\r\n\t\t\r\n\t\t$(\"#practScheduleContainerDiv\").fadeIn(200, \"linear\", function () { $(\"#practScheduleDiv\").show(300, \"swing\"); });\r\n\t \r\n\t \r\n\t \r\n\t/*  var winLeft = (screen.width - 795)/2;\r\n\t var winTop = (screen.height - 495)/2;\r\n\t var popupWindow = window.open(popupUrl,\'PractitionerSchedule\',\'height=290,width=620,top=\'+winTop+\',left=\'+winLeft+\',resizable=no,scrollbars=yes,toolbar=no,menubar=no,location=no,directories=no,addressbar=no,status=no,titlebar=no\');\r\n\t return false; */\r\n\t \r\n\t \r\n\t /* var formElement = document.getElementById(\"bookappointmentform\");\r\n\t $(\"#bookappointmentform\").attr(\"action\",\"./PractitionerScheduleServlet\");\r\n\t $(\"#bookappointmentform\").submit(); */\r\n\t \r\n }\r\n \r\n function closePractitionerSchedulePopup(){\r\n\t// this function will close the practitioner schedule popup dialog\r\n\t\t$(\"#practScheduleDiv\").hide(\'300\', \"swing\", function () { $(\"#practScheduleContainerDiv\").fadeOut(\"200\"); });\r\n }\r\n \r\n function handleKeyDownInSearchField(e){\r\n\t // this function handles enter button press after specifying text\r\n\t // in the search doctor field\r\n\t var x = e || window.event;\r\n\t var key = (x.keyCode || x.which);\r\n\t if(key == 13 || key == 3){\r\n\t  \tsearchPractitioner();\r\n\t }\r\n }\r\n \r\n \r\n function searchPractitioner(){\r\n\t // get the search text first\r\n\t var searchTextComp = document.getElementById(\"searchtextbox\");\r\n\t var searchText = \"\";\r\n\t if(searchTextComp){\r\n\t\t searchText = searchTextComp.value;\r\n\t\t searchText = searchText.toUpperCase();\r\n\t\t // below code is for trimming the search text\r\n\t\t // this code is done to support any browser\r\n\t\t // that is why in built js functions are not used\r\n\t\t var l=0; var r=searchText.length -1;\r\n\t\t while(l < searchText.length && searchText[l] == \' \'){\r\n\t\t\t  l++;\r\n\t\t }\r\n\t\t\t\r\n\t\t while(r > l && searchText[r] == \' \'){\r\n\t\t\tr-=1;\r\n\t\t }\r\n\t\t searchText = searchText.substring(l, r+1);\r\n\t }\r\n\t // get the total practitioner count\r\n\t // this is needed for iterating through the practitioner\r\n\t // components and then match the name with the search text\r\n\t var totalPractitionerCountComp = document.getElementById(\"totalPractitionerCount\");\r\n\t var totalPractitionerCount = 0;\r\n\t try{\r\n\t\t totalPractitionerCount = parseInt(totalPractitionerCountComp.value);\t \r\n\t }catch(e){\r\n\t\t totalPractitionerCount = 0;\r\n\t }\r\n\t \r\n\t // code to check if the search text is empty text\r\n\t // if so, we need to show all the practitioner components\r\n\t if(searchText == \'\'){\r\n\t\t for(count=1;count<=totalPractitionerCount;count++){\r\n\t\t\t practitionerIdComp = document.getElementById(\"Practitioner\"+count);\r\n\t\t\t if(practitionerIdComp){\r\n\t\t\t\t practitionerIdComp.style.display = \"block\";\r\n\t\t\t }\r\n\t\t }\r\n\t\t return;\r\n\t }\r\n\t \r\n\t // now iterate through the practitioner components\r\n\t var practitionerNameComp;\r\n\t var practitionerName;\r\n\t for(count=1;count<=totalPractitionerCount;count++){\r\n\t\t practitionerNameComp = document.getElementById(\"PractitionerName\"+count);\r\n\t\t practitionerIdComp = document.getElementById(\"Practitioner\"+count);\r\n\t\t if(practitionerNameComp && practitionerIdComp){\r\n\t\t\t practitionerName = practitionerNameComp.value;\r\n\t\t\t practitionerName = practitionerName.toUpperCase();\r\n\t\t\t \r\n\t\t\t textIndex = practitionerName.indexOf(searchText);\r\n\t\t\t if(textIndex != 0){\r\n\t\t\t\t practitionerIdComp.style.display = \"none\";\r\n\t\t\t }else{\r\n\t\t\t\t practitionerIdComp.style.display = \"block\";\r\n\t\t\t }\r\n\t\t }\r\n\t }\r\n }\r\n \r\n function getPractitionerList(){\r\n\t var validationMessage = \"\";\r\n\t \r\n\t // first validate the fields in the GUI\r\n\t var datePickerComp = document.getElementById(\"ApptPreferredDate\");\r\n\t var datePicker = $(\"#ApptPreferredDate\").data(\"kendoDatePicker\");\r\n\t var preferredApptDate;\r\n\t // get the preferred date from the date picker component or\r\n\t // the generalized element\r\n\t if(datePickerComp){\r\n\t\t if(datePicker){\r\n\t\t\t preferredApptDate = datePicker.value();\r\n\t\t }else{\r\n\t\t\t preferredApptDate = new Date(datePickerComp.value);\r\n\t\t }\r\n\t }\r\n     //preferredApptDate = datePicker.value();\r\n     if(isNaN(preferredApptDate)){\r\n    \t validationMessage = \"Preferred date \"+preferredApptDate+\" is not valid. \\n\";\r\n     }\r\n     \r\n    var currentDate = new Date();\r\n     \r\n\t // time validation\r\n\tvar selectedFromTimeComp = document.getElementById(\"ApptPreferredFromTime\");\r\n\tvar selectedFromTimeIndex;\r\n\tvar selectedFromTime = \"\";\r\n\tif(selectedFromTimeComp){\r\n\t\tselectedFromTimeIndex = selectedFromTimeComp.selectedIndex;\r\n\t\tselectedFromTime = selectedFromTimeComp.value;\r\n\t}\r\n\t\r\n\tvar selectedToTimeIndex;\r\n\tvar selectedToTimeComp = document.getElementById(\"ApptPreferredToTime\");\r\n\tvar selectedToTime = \"\";\r\n\tif(selectedToTimeComp){\r\n\t\tselectedToTimeIndex = selectedToTimeComp.selectedIndex;\r\n\t\tselectedToTime = selectedToTimeComp.value;\r\n\t\tselectedToTime = trimText(selectedToTime);\r\n\t}\r\n\t\r\n\tvar selectedTimeIsInvalid = false;\r\n\tif(selectedFromTime.length == 0 && selectedToTime.length == 0){\r\n\t\tvalidationMessage += \"Appointment start and end time is not specified. \\n\";\r\n\t\tselectedTimeIsInvalid = true;\r\n\t}else if(selectedFromTime.length == 0){\r\n\t\tvalidationMessage += \"Appointment start time is not specified. \\n\";\r\n\t\tselectedTimeIsInvalid = true;\r\n\t}else if(selectedToTime.length == 0){\r\n\t\tvalidationMessage += \"Appointment end time is not specified. \\n\";\r\n\t\tselectedTimeIsInvalid = true;\r\n\t}else if(selectedFromTime == selectedToTime){\r\n\t\tvalidationMessage += \"Appointment start and end time cannot be same. \\n\";\r\n\t\tselectedTimeIsInvalid = true;\r\n\t}\r\n\t\r\n\t//alert(selectedFromTime+\' || \'+selectedToTime);\r\n\t\r\n\tvar delimiter = \":\";\r\n\tvar dotIndex = selectedFromTime.indexOf(delimiter);\r\n\tvar hrsStr = \"\";\r\n\tvar hrs = 0;\r\n\tvar minsStr = \"\";\r\n\tvar mins = 0;\r\n\tif(dotIndex > 0){\r\n\t\thrsStr = selectedFromTime.substring(0,dotIndex);\r\n\t\tminsStr = selectedFromTime.substring(dotIndex+1,selectedFromTime.length);\r\n\t\ttry{\r\n\t\t\thrs = parseInt(hrsStr);\t\r\n\t\t}catch(e){\r\n\t\t\thrs = 0;\r\n\t\t}\r\n\t\ttry{\r\n\t\t\tmins = parseInt(minsStr);\r\n\t\t}catch(e){\r\n\t\t\tmins = 0;\r\n\t\t}\r\n\t}\r\n\t// set the hours, minutes and the seconds\r\n\t// seconds will be set to 0 now\r\n\tif(!(isNaN(preferredApptDate))){\r\n\t\t//alert(hrs+ \' || \'+mins);\r\n\t\tpreferredApptDate.setHours(hrs);\r\n\t\tpreferredApptDate.setMinutes(mins);\r\n\t\tpreferredApptDate.setSeconds(0);\r\n\t\t\r\n\t\t// validate the appointment start time with current date only\r\n\t\t// when the start time is selected properly by user\r\n\t\tif((preferredApptDate < currentDate) && !selectedTimeIsInvalid){\r\n\t\t\tvalidationMessage += \"Appointment start time cannot be less than current time. \\n\";\r\n\t\t}\r\n\t}\r\n\t\r\n\t// validate the appointment start time with appointment end time only\r\n\t// when the start time and end time is selected properly by user\t\r\n\tif((selectedFromTimeIndex > selectedToTimeIndex) && !selectedTimeIsInvalid){\r\n\t\tvalidationMessage += \"Appointment start time cannot be greater than or equal to end time. \\n\";\r\n\t}\r\n\t\r\n\t// speciality and facility validation\r\n\t// first speciality\r\n\tvar hiddenSpecialityComp = document.getElementById(\"hdnSelectedSpeciality\");\r\n\tvar selectedSpeciality=\"\";\r\n\tif(hiddenSpecialityComp){\r\n\t\tselectedSpeciality = hiddenSpecialityComp.value;\r\n\t\tselectedSpeciality = trimText(selectedSpeciality);\r\n\t}\r\n\tif(selectedSpeciality.length == 0){\r\n\t\tvalidationMessage += \"Selected speciality is invalid. \\n\";\r\n\t}\r\n\t\r\n\t// validate selected facility\r\n\tvar selectedFacility = \"\";\r\n\tvar facilityComp = document.getElementById(\"Facility\");\r\n\tif(facilityComp){\r\n\t\tselectedFacility = facilityComp.value;\r\n\t\tselectedFacility = trimText(selectedFacility);\r\n\t}\r\n\t\r\n\tif(selectedFacility.length == 0){\r\n\t\tvalidationMessage += \"Selected facility is invalid. \\n\";\r\n\t}\r\n\t\r\n\tif(validationMessage.length > 0){\r\n\t\talert(validationMessage);\r\n\t\treturn;\r\n\t}\r\n\t\r\n\t// need to set the values of hdnSelectedSpeciality,hdnSelectedSpecialityDesc\r\n\t//hdnPreferredDate - it is enough to set the hdnpreferreddate with value\r\n\t// hdnselectedspeciality and hdnselectedspecialitydesc is already set\r\n\t// with values\r\n\t//var dateTimePicker = $(\"#ApptPreferredDate\").data(\"kendoDatePicker\");\r\n\t//var preferredApptDate = dateTimePicker.value();\r\n\tvar dateValue = \"\"+preferredApptDate.getDate()+\"/\"+(preferredApptDate.getMonth()+1)+\"/\"+preferredApptDate.getFullYear();\r\n\tvar hdnPreferredDateComp = document.getElementById(\"hdnPreferredDate\");\r\n\tif(hdnPreferredDateComp){\r\n\t\thdnPreferredDateComp.value = dateValue;\r\n\t}\r\n\t\r\n\t // finally all validations have passed - submit the form\r\n\tvar formElement = document.getElementById(\"bookappointmentform\");\r\n\t if(formElement){\r\n\t\t formElement.action = \"../schedule/SpecialityServlet\";\r\n\t\t formElement.submit();\r\n\t }\r\n }\r\n \r\n function trimText(textVal){\r\n\t var l=0; var r=textVal.length -1;\r\n\t while(l < textVal.length && textVal[l] == \' \'){\r\n\t\t  l++;\r\n\t }\r\n\t\t\r\n\t while(r > l && textVal[r] == \' \'){\r\n\t\tr-=1;\r\n\t }\r\n\t textVal = textVal.substring(l, r+1);\r\n\t \r\n\t return textVal;\r\n }\r\n \r\n function showPractitionerScheduleStatus(practitionerId,clinicCode,practitionerName){\r\n\t // this function shows the practitioner schedule and time slot\r\n\t // page\r\n\t // this function will set the page\'s form url and submit it\r\n\t var practitionerIdComp = document.getElementById(\"hdnPractitionerId\");\r\n\t if(practitionerIdComp){\r\n\t\t practitionerIdComp.value = practitionerId;\r\n\t }\r\n\t \r\n\t var clinicCodeComp = document.getElementById(\"hdnClinicCode\");\r\n\t if(clinicCodeComp){\r\n\t\t clinicCodeComp.value = clinicCode;\r\n\t }\r\n\t \r\n\t var practitionerNameComp = document.getElementById(\"hdnPractitionerName\");\r\n\t if(practitionerNameComp){\r\n\t\t practitionerNameComp.value = practitionerName;\r\n\t }\r\n\t \r\n\t \r\n\t var formElement = document.getElementById(\"bookappointmentform\");\r\n\t if(formElement){\r\n\t\t formElement.action = \"./PractitionerTimeSlotServlet\";\r\n\t\t formElement.submit();\r\n\t }\r\n\t \r\n }\r\n \r\n </script>\r\n \r\n <style scoped>\r\n .practSchedulePopupContainerStyle {\r\n      background-color: white;\r\n      opacity: 90%;\r\n      filter:alpha(opacity=90);\r\n      background-color: rgba(255,255,255,0.90); \r\n      width: 100%;\r\n      min-height: 100%;\r\n      overflow: hidden;\r\n      float: absolute;\r\n      position: fixed;\r\n      top: 0;\r\n      left: 0;\r\n      color: white;\r\n      \r\n      /* z-index: -1;\r\n      opacity:0%; */\r\n\t}\r\n\t\r\n\t.practSchedulePopupContentStyle{\r\n\t  background-color: white;\r\n      color: black;\r\n      \r\n      padding: 2px;\r\n      display:block;\r\n      position: absolute;\r\n      top: 30%;\r\n      left: 30%;\r\n      /* width : 0px;\r\n      height : 0px;\r\n      z-index: -1; */\r\n      width: 620px;\r\n      height: 290px; \r\n\t}\r\n \r\n </style>\r\n \r\n \r\n</head>\r\n<body>\r\n\r\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\r\n\r\n<div id=\"wrapper\">\r\n<div class=\"fixedheader\">\t\r\n<header id=\"header\">\r\n    <div id=\"headerinfo\">\r\n        <div class=\"row\">\r\n\t\t\t<div id=\"headervisitinfo\">\r\n                \tWelcome back! Your last visit was on Wed, Dec 5, 2012 12:47:08 PM \r\n            </div>    \r\n            <div id=\"headerloginas\">\r\n                \t <strong>Welcome, ";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 =", ID:";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="</strong>\r\n            </div>\r\n            <div id=\"headerlogout\">\r\n\t\t\t\t<div><a href=\"../../servlet/LogoutServlet\"  class=\"logout\">\r\n                    Logout</a>\r\n\t\t\t\t</div>\r\n            </div>\r\n        </div>\r\n    </div>\r\n</header>\r\n<!-- #header-->\r\n   \r\n<!-- #logo And Menu -->\r\n<div id=\"logomenu\">\r\n\t<div class=\"row\">\r\n    \t<div id=\"logo\">\r\n\t\t\t<img src=\"../../images/logo.png\"> \r\n        </div>\r\n        <div id=\"Menubox\">\r\n\t\t\t<ul class=\"menu\">\r\n                <li><a href=\"../Contact.jsp\"><div class=\"menuicons\"><img src=\"../../images/Contact.png\"/></div>Contact</a></li>\r\n                <li><a href=\"../result/DetailedResult.jsp\"><div class=\"menuicons\"><img src=\"../../images/Results.png\"/></div>My Results</a></li>\r\n                <li class=\"menuselect\"><div class=\"menuicons\"><img src=\"../../images/Appointment.png\"/></div>My Appointments</li>\r\n                <li><a href=\"../PortalHome.jsp\"><div class=\"menuicons\"><img src=\"../../images/Home.png\"/></div>Home</a></li>\r\n            </ul>\r\n        </div>\r\n    </div>\r\n</div>\r\n</div>\r\n   <!-- #logo And Menu -->\r\n   \r\n<div class=\"line\"></div>\r\n\t<div id=\"content\"  style=\"background-color: #ffffff;padding-bottom: 22px;\">\r\n     <!-- #Patient Banner-->\r\n       <!-- #Patient Banner-->\r\n\t   <!-- #Content Area-->\r\n     \t<div id=\"contentbg\">\r\n\t\t</div>\r\n\t\t\t<div id=\"contentArea\" style=\"background-color: #ffffff;\">\r\n\t\t\t\t<div id=\"contentArearow\" > \r\n\t\t\t\t\t\t<div id=\"booknewbreadcrumb\"><span class=\"contenbold\"><a href=\"UpcomingAppoinments.html\" class=\"backpage\">My appointments</a></span> <span class=\"contenbold\" id=\"arrow\">></span> <span class=\"contenbold\">Book new appointment</span></div>\r\n\t\t\t\t\t<div class=\"row\">\r\n\t\t\t\t\t\t<div class=\"cellindex searchindex\" >\r\n\t\t\t\t\t\t<form id=\"bookappointmentform\" method=\"POST\">\r\n\t\t\t\t\t\t<div id=\"BooknewAppsearch\" >\r\n\t\t\t\t\t\t\t<div class=\"BookAppTitle\"  >\r\n\t\t\t\t\t\t\t\t<a class=\"rectitle\" href=\"BooknewAppoinmentRecentSearch.html\">Recent doctor</a>\r\n\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t<div class=\"BookAppTitle\">\r\n\t\t\t\t\t\t\t\t<a class=\"rectitle\">  Search doctor</a>\r\n\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t<div id=\"SearchPanel\" style=\"height:330px;\">\r\n\t\t\t\t\t\t\t\t<div class=\"searchfields\">\r\n\t\t\t\t\t\t\t\t\t<div class=\"Apptitle\">Preferred date</div>\r\n\t\t\t\t\t\t\t\t\t<!-- <input class=\"textboxdatesearch\" type=\"text\" placeholder=\"16 Dec 2012\"/> -->\r\n\t\t\t\t\t\t\t\t\t<input id=\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\" name=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\" value=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\" style=\"width:180px;\" />\r\n\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t<div class=\"searchfields\">\r\n\t\t\t\t\t\t\t\t\t<div class=\"Apptitle \">Preferred time</div>\r\n\t\t\t\t\t\t\t\t\t<select class=\"Combotimesearch\" id=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"\r\n\t\t\t\t\t\t\t\t\t\t\tname=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\">\r\n\t\t\t\t\t\t\t\t\t    ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\r\n\t\t\t\t\t\t\t\t\t    \t<option value=\"\" selected=\"selected\">Select time</option>\r\n\t\t\t\t\t\t\t\t\t    ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\r\n\t\t\t\t\t\t\t\t\t\t\t<option value=\"\">Select time</option>\r\n\t\t\t\t\t\t\t\t\t\t";
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

    private final static java.lang.String  _wl_block17 ="\">\r\n\t\t\t\t\t\t\t\t\t\t ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =" \r\n\t\t\t\t\t\t\t\t\t</select>\r\n\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t<!-- facility is introduced here -->\r\n\t\t\t\t\t\t\t\t<div class=\"searchfields\">\r\n\t\t\t\t\t\t\t\t<div class=\"Apptitle\">Facility</div>\r\n\t\t\t\t\t\t\t\t <select class=\"textbox\" id=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" style=\"width: 175px;\">\r\n\t\t\t       \t\t\t\t   \t<option value=\"\" selected=\"selected\">----All----</option>\r\n\t\t\t       \t\t\t\t   \t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\t\t\t\r\n\t\t\t\t\t\t\t\t\t  \t<option value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" selected=\"selected\">";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</option>\r\n\t\t\t\t\t\t\t\t\t  \t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\r\n\t\t\t\t\t\t\t\t\t  \t<option value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</option>\t\t\r\n\t\t\t\t\t\t\t\t  \t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\r\n\t\t\t       \t\t\t\t  </select> \r\n\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t<div class=\"searchfieldsSpeciality\">\r\n\t\t\t\t\t\t\t\t\t<div class=\"Apptitle\">Speciality</div>\r\n\t\t\t\t\t\t\t\t\t<div id=\"DetailedSearch\"  style=\"height:107px;\">\r\n\t\t\t\t\t\t\t\t\t\t<input class=\"textboxtimeSpeciality\" type=\"text\" id=\"specialitySearchText\" name=\"specialitySearchText\" placeholder=\"Search\"><img id=\"specialitySearch\" src=\"../../images/Search.png\" onclick=\"searchSpeciality()\"/></input>\r\n\t\t\t\t\t\t\t\t\t\t<div class=\"specialityDiv\" style=\"height:80px;\">\r\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\r\n\t\t\t\t\t\t\t\t\t\t\t<span class=\"options selectedopt\" id=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" style=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =";padding-left:10px;padding-top:5px;padding-right:10px;padding-bottom:5px;\" onclick=\"selectSpeciality(this,\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\',\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\')\">Not Known</span>\r\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" value=\"\">\r\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" value=\"\">\r\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\r\n\t\t\t\t\t\t\t\t\t\t\t<span class=\"options\" id=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\r\n\t\t\t\t\t\t\t\t\t\t\t<span class=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\"  id=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\')\">";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</span>\r\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">\r\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\">\r\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\r\n\t\t\t\t\t\t\t\t\t\t\t<!-- hidden element to store the number of speciality indices found from data -->\r\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"hdnSpecialityIndex\" name=\"hdnSpecialityIndex\" value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\">\r\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"hdnSelectedSpeciality\" name=\"hdnSelectedSpeciality\" value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\">\r\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"hdnSelectedSpecialtyDesc\" name=\"hdnSelectedSpecialtyDesc\" value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\">\r\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"hdnPreferredDate\" name=\"hdnPreferredDate\" value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\">\r\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"hdnPractitionerId\" name=\"hdnPractitionerId\" value=\"\">\r\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"hdnClinicCode\" name=\"hdnClinicCode\" value=\"\">\r\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"hdnPractitionerName\" name=\"hdnPractitionerName\" value=\"\">\r\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"hdnSelectedFacilityDesc\" name=\"hdnSelectedFacilityDesc\" value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\">\r\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"hdnSelectedSpecialitySpanElementId\" name=\"hdnSelectedSpecialitySpanElementId\" value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\">\r\n\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t<span class=\"btn marginalign\" onclick=\"getPractitionerList()\">Search</span>\r\n\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\r\n\t\t\t\t\t\t</form>\r\n\t\t\t\t\t\t\r\n\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\r\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\r\n\t\t\t\t\t\t\r\n\t\t\t\t\t\t\r\n\t\t\t\t\t\t<div class=\"tablebooknewapp\" style=\"min-height: 455px;\"> \r\n\t\t\t\t\t\t\t<div class=\"row\">\r\n\t\t\t\t\t\t\t\t<div class=\"celldivider\">\r\n\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t<div class=\"cellindex bookingcell\">\r\n\t\t\t\t\t\t\t\t<div id=\"BooknewAppDoctor\">\r\n\t\t\t\t\t\t\t\t\t\t<div id=\"BookingAppsearchresult\" >\r\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"title\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t<span>Results for</span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"contenbold\">\" </span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"contenbold\">";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 =", </span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"contenbold\">&nbsp;";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 =" to ";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 =",&nbsp;</span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"contenbold\">";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="</span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"contenbold\">\" </span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"floatright\">";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 =" doctor (s)</span>\r\n\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\t<div>\r\n\t\t\t\t\t\t\t\t\t\t\t<span class=\"contentnormal \">&nbsp;&nbsp;Search for doctor:</span><input class=\"textboxtimeSpeciality \" id=\"searchtextbox\" type=\"text\" placeholder=\"Search\" onkeydown=\"handleKeyDownInSearchField()\"><img id=\"specialitySearch\" onclick=\"searchPractitioner()\" src=\"../../images/Search.png\"/></input>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t<!--Doctor app here-->\r\n\t\t\t\t\t\t\t\t\t\t<div id=\"DoctorStrip\">\r\n\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\r\n\t\t\t\t\t\t\t\t\t\t<span class=\"loginerror\">\r\n\t\t\t\t\t\t\t\t       ";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\r\n\t\t\t\t\t\t\t\t        </span>\r\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t<!--strip here-->\r\n\t\t\t\t\t\t\t\t\t\t\t<div id=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\" class=\"DoctorApp\" style=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 =";height:110px;\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"DoctorDetailStrip\" style=\"height:102px;\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"DoctorInnerstrip\" style=\"height:100px;\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ImageSchedule\"><img class=\"doctorIcon\" src=\"../../images/doctor.png\"/><a class=\"ViewSchedulefont \" href=\"#\" onclick=\"showPractitionerSchedule(\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\')\">View schedule</a></div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"DocDetails\" style=\"height:60px;\"><span class=\"contenbold\">";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="</span><br/>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"contentnormal\">";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="</span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span id=\"spacing\" class=\"btn\"><a href=\"#\" onclick=\"showPractitionerScheduleStatus(\'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\')\" class=\"rectitle\"> Select</a></span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t<!--  code to set the practitioner name in a hidden field -->\r\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\" >\t\t\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t<!--strip here-->\r\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\r\n\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t<!--  the hidden vars used for display/hide of practitioner components -->\r\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"totalPractitionerCount\" name=\"totalPractitionerCount\" value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\">\r\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"currentPractitionerCount\" name=\"currentPractitionerCount\" value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\">\r\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"practitionerDisplayBucket\" name=\"practitionerDisplayBucket\" value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\">\r\n\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t<!--Doctor app here-->\r\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\r\n\t\t\t\t\t\t\t\t\t\t<div class=\"BookingAppClickmore\" id=\"ClickMore\" style=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\">\r\n\t\t\t\t\t\t\t\t\t\t\t<span class=\"MoreResult\" onclick=\"showMorePractitioner()\">Click for more</span>\r\n\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t</div>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t</div> \r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t</div>\r\n       <!-- #Content Area-->\r\n    <!-- #content-->\r\n    \r\n<div id=\"practScheduleContainerDiv\" class=\"practSchedulePopupContainerStyle\" style=\"visibility:hidden;\">\r\n\t<div id=\"practScheduleDiv\" class=\"practSchedulePopupContentStyle\" style=\"visibility:hidden;\">\r\n\t</div>\r\n</div>    \r\n    \r\n<div class=\"Footerbg\" style=\"margin-top:0px;\">\r\n\t<div id=\"poweredby\">\r\n\t\t\t<p class=\"poweredby\">Powered by <img src=\"../../images/csc.png\" width=\"25\" height=\"14\" style=\"vertical-align:middle;\"></p>\r\n    </div>\r\n</div>\r\n</div>\r\n\r\n</body>\r\n</html>\r\n";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

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

	String selectedFacility = request
			.getParameter(CreateAppointmentConstants.APPT_PREFERREDFACILITY_PARAMETER_KEY);
	if (selectedFacility == null) {
		selectedFacility = "";
	}

	// get the speciality from the request
	String speciality = request
			.getParameter(CreateAppointmentConstants.SPECIALITY_PARAMETER_KEY);
	if (speciality == null || speciality.trim().equals("")) {
		speciality = request.getParameter("hdnSelectedSpeciality");
		if (speciality == null) {
			speciality = "";
		}
	}

	// get the selected speciality description
	String specialityDesc = request
			.getParameter("hdnSelectedSpecialtyDesc");
	if (specialityDesc == null) {
		specialityDesc = "";
	}

	// get the selected facility description as well
	String selectedFacilityDesc = request
			.getParameter("hdnSelectedFacilityDesc");
	if (selectedFacilityDesc == null) {
		selectedFacilityDesc = "";
	}

	String apptPreferredDate = request
			.getParameter(CreateAppointmentConstants.APPT_PREFERREDDATE_PARAMETER_KEY);
	if (apptPreferredDate == null) {
		apptPreferredDate = "";
	}

	String apptPreferredFromTime = request
			.getParameter(CreateAppointmentConstants.APPT_PREFERREDFROMTIME_PARAMETER_KEY);
	if (apptPreferredFromTime == null) {
		apptPreferredFromTime = "";
	}

	String apptPreferredToTime = request
			.getParameter(CreateAppointmentConstants.APPT_PREFERREDTOTIME_PARAMETER_KEY);
	if (apptPreferredToTime == null) {
		apptPreferredToTime = "";
	}

	String preferredDateStr = request.getParameter("hdnPreferredDate");
	if (preferredDateStr == null) {
		preferredDateStr = apptPreferredDate;
	}
	Date preferredDate = PortalHelper.getDateFromString(
			preferredDateStr, "dd/MM/yyyy");

	// this string will contain the selected speciality's description
	// the speciality's code only will get passed to this page
	// but we need the description for the GUI
	//String selectedSpecialityDesc = null;

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

	// get the facility list as a normal java service
	// this is done only to improve performance
	FacilityListRequest facilityListRequest = new FacilityListRequest();
	facilityListRequest
			.setPortalUserName(PortalConstants.PORTALUSER_REQUEST_PARAM_VALUE);

	FacilityListServiceInvoker facilityListServiceInvoker = new FacilityListServiceInvoker();
	FacilityListResponse facilityListResponse = facilityListServiceInvoker.
										getDataThroughService(facilityListRequest);
	
	/* FacilityListSvcImpl facilityListSvcImpl = new FacilityListSvcImpl();
	FacilityListResponse facilityListResponse = facilityListSvcImpl
			.getFacilityList(facilityListRequest); */

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
									    	if (apptPreferredFromTime.trim().equals("")) {
									    
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
												/* if (apptPreferredFromTime.equalsIgnoreCase(apptTimeValue)) {
													selected = "selected";
												} */
												if (apptPreferredFromTime.equalsIgnoreCase(apptDataValue)) {
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
            _bw.write(_wl_block17Bytes, _wl_block17);

										 	// check for empty alone is fine
										 	if (apptPreferredToTime.trim().equals("")) {
										 
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
											apptTimeValue = null;
											// iterate through the list and show the time
											for (AppointmentTime apptTime : apptToTimeList) {
												selected = "";
												apptTimeValue = apptTime.getAppointmentTime();
												apptDataValue = apptTime.getAppointmentDataValue();
												/* if (apptPreferredToTime.equalsIgnoreCase(apptTimeValue)) {
													selected = "selected";
												} */
												if (apptPreferredToTime.equalsIgnoreCase(apptDataValue)) {
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
										
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(CreateAppointmentConstants.APPT_PREFERREDFACILITY_PARAMETER_KEY));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(CreateAppointmentConstants.APPT_PREFERREDFACILITY_PARAMETER_KEY));
            _bw.write(_wl_block19Bytes, _wl_block19);

			       				   		/* ErrorInfo facilityListErrorInfo = facilityListResponse
			       				   				.getErrorInfo(); */
			       				   		List<Facility> facilityList = null;
			       				   		/* if (ErrorInfo.SUCCESS_CODE == facilityListErrorInfo.getErrorCode()) { */
			       				   		if (facilityListResponse.isSuccessful()) {	
			       				   			facilityList = facilityListResponse.getFacilityList();
			       				   			for (Facility facility : facilityList) {
			       				   				if (selectedFacility.equalsIgnoreCase(facility
			       				   						.getFacilityId())) {
			       				   	
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(facility.getFacilityId()));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(facility.getFacilityName()));
            _bw.write(_wl_block22Bytes, _wl_block22);

									  		} else {
									  	
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(facility.getFacilityId()));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(facility.getFacilityName()));
            _bw.write(_wl_block25Bytes, _wl_block25);

										  			}
										  		}
											}
										 
            _bw.write(_wl_block26Bytes, _wl_block26);

												int specialityIndex = 1;
												String specialityCodeVal = "SpecialityCode" + specialityIndex;
												String specialityId = "Speciality" + specialityIndex;
												String selectedStyle = "options";
												String spanDisplayStyle = "display:block";
												String specialityDescId = "SpecialityDesc" + specialityIndex;
												String selectedSpanElementId = null;
												// this is for empty speciality
												if (speciality.trim().equals("")) {
													selectedSpanElementId = specialityId;
											
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(specialityId));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(specialityId));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(spanDisplayStyle));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(specialityCodeVal));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(specialityDescId));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(specialityCodeVal));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(specialityCodeVal));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(specialityDescId));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(specialityDescId));
            _bw.write(_wl_block33Bytes, _wl_block33);

												} else {
											
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(specialityId));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(specialityId));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(spanDisplayStyle));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(specialityCodeVal));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(specialityDescId));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(specialityCodeVal));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(specialityCodeVal));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(specialityDescId));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(specialityDescId));
            _bw.write(_wl_block33Bytes, _wl_block33);

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
															
	
															specialityIndex++;
															specialityId = "Speciality" + specialityIndex;
															specialityCodeVal = "SpecialityCode" + specialityIndex;
															specialityDescId = "SpecialityDesc" + specialityIndex;
															
															// check if the selected speciality
															// equals any of the specialities
															// obtained from the service
															if (speciality.equals(specialityCode)) {
																selectedStyle = "options selectedopt";
																// set the selected speciality description
																// this will be used
																//selectedSpecialityDesc = specialityDescription;
																selectedSpanElementId = specialityId;
															}
											
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(selectedStyle));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(specialityId));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(specialityId));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(spanDisplayStyle));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(specialityCodeVal));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(specialityDescId));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(specialityDescription));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(specialityCodeVal));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(specialityCodeVal));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(specialityCode));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(specialityDescId));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(specialityDescId));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(specialityDescription));
            _bw.write(_wl_block40Bytes, _wl_block40);

														}
													}
												}
											
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(specialityIndex));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(speciality));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(specialityDesc));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(preferredDateStr));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(selectedFacilityDesc));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(selectedSpanElementId));
            _bw.write(_wl_block47Bytes, _wl_block47);

							// code to get the selected date in required display format
							String selectedDateDisplayValue = preferredDateStr;
							if (preferredDate != null) {
								selectedDateDisplayValue = PortalHelper.getDateAsString(
										preferredDate,
										ScheduleConstants.BOOKAPPT_DATE_DISPLAY_FORMAT);
							}

							// code to get the list of practitioners goes here
							PractitionerRequest practitionerRequest = new PractitionerRequest();
							practitionerRequest.setPatientId(patientId);
							practitionerRequest
									.setPortalUserName(PortalConstants.PORTALUSER_REQUEST_PARAM_VALUE);
							practitionerRequest.setSpecialityCode(speciality);
							// need to set other request parameters as well
							// facility id
							practitionerRequest.setFacilityId(selectedFacility);
							// preferred date
							practitionerRequest.setPreferredDateAsString(preferredDateStr);
							practitionerRequest.setPreferredStartTime(apptPreferredFromTime);
							practitionerRequest.setPreferredEndTime(apptPreferredToTime);
							practitionerRequest.setLocale(Locale.getDefault().getLanguage());
							practitionerRequest
									.setOperationStandardId(CreateAppointmentConstants.PRACTITIONER_SERVICE_OPRSTN_DEFAULT_VALUE);
							practitionerRequest
									.setResourceClass(CreateAppointmentConstants.PRACTITIONER_SERVICE_RESOURCECLASS_DEFAULT_VALUE);
							practitionerRequest.setSpecialityDesc(specialityDesc);
							practitionerRequest.setFacilityDesc(selectedFacilityDesc);

							// initialize the practitioner service and register it
							/* PractitionerSvcImpl practitionerSvcImpl = new PractitionerSvcImpl();
							practitionerSvcImpl.registerService(practitionerRequest); */
							// initialize the service invoker and get the response object
							PractitionerServiceInvoker practitionerServiceInvoker = new PractitionerServiceInvoker();
							practitionerServiceInvoker.registerService(practitionerRequest);
							PractitionerResponse practitionerResponse = (PractitionerResponse) practitionerServiceInvoker
									.getDataThroughWebService(practitionerRequest);
							// get the error info object and inspect it for success or failure
							/* ErrorInfo practitionerErrorInfo = practitionerResponse
									.getErrorInfo(); */
							//int practitionerErrorCode = practitionerErrorInfo.getErrorCode();
							String practitionerErrorMessage = null;//practitionerResponse.getErrorMessage();
							/* practitionerErrorInfo
									.getErrorMessage(); */
							// get the number of doctors
							int noOfDoctors = 0;
							List<PractitionerModel> practitionerModelList = practitionerResponse
									.getPractitionerModelList();
							if (practitionerModelList != null) {
								noOfDoctors = practitionerModelList.size();
							}

							// stores the from time and to time in display format
							// it is needed for display purpose only
							String selectedFromTimeDisplayVal = ScheduleHelper
									.getApptSelectedTimeInDisplayFormat(apptPreferredFromTime);
							String selectedToTimeDisplayVal = ScheduleHelper
									.getApptSelectedTimeInDisplayFormat(apptPreferredToTime);
						
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(selectedDateDisplayValue));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(selectedFromTimeDisplayVal));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(selectedToTimeDisplayVal));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(specialityDesc));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(noOfDoctors));
            _bw.write(_wl_block53Bytes, _wl_block53);

											int totalPractitionerCount = 0;

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

											// code to check for the success or error of getting the practitioner list
											/* if (ErrorInfo.SUCCESS_CODE != practitionerErrorCode) { */
											if (!practitionerResponse.isSuccessful()) {	
												practitionerErrorMessage = practitionerResponse.getErrorMessage();	
											
										
            _bw.write(_wl_block54Bytes, _wl_block54);

								       	out.println(practitionerErrorMessage);
								       
            _bw.write(_wl_block55Bytes, _wl_block55);

											} else {
												// once code comes here we can safely assume that
												// there are practitioners 
												// assign the practitioner count variable
												totalPractitionerCount = practitionerModelList.size();
												// this is where all the pracititioners will be displayed
												for (PractitionerModel practModel : practitionerModelList) {
													if (practitionerIndex > CreateAppointmentConstants.PRACTITIONER_DISPLAY_RECORD_COUNT) {
														practitionerDisplayStyle = "display : none";
													}
													practitionerIdString = PRACTITIONERID_PREFIX
															+ practitionerIndex;

													practitionerNameString = PRACTITIONERNAME_PREFIX
															+ practitionerIndex;
										
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(practitionerIdString));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(practitionerDisplayStyle));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(practModel.getPractitionerId()));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(practModel.getPractitionerName()));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(practModel.getPractitionerName()));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(specialityDesc));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(selectedFacilityDesc));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(practModel.getPractitionerId()));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(practModel.getClinicCode()));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(practModel.getPractitionerName()));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(practitionerNameString));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(practitionerNameString));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(practModel.getPractitionerName()));
            _bw.write(_wl_block63Bytes, _wl_block63);

													practitionerIndex++;
												}
											}
										
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(totalPractitionerCount));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(CreateAppointmentConstants.PRACTITIONER_DISPLAY_RECORD_COUNT));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(CreateAppointmentConstants.PRACTITIONER_DISPLAY_RECORD_COUNT));
            _bw.write(_wl_block67Bytes, _wl_block67);

											String clickMoreDisplayStyle = "display : none";
											// check if there are more than 6 practitioners
											// then only "click for more" should be shown in the GUI
											if (totalPractitionerCount > CreateAppointmentConstants.PRACTITIONER_DISPLAY_RECORD_COUNT) {
												clickMoreDisplayStyle = "display : block";
											}
										
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(clickMoreDisplayStyle));
            _bw.write(_wl_block69Bytes, _wl_block69);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
