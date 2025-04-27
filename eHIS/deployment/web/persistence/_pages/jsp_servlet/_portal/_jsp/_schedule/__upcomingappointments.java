package jsp_servlet._portal._jsp._schedule;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import portalrefimpl.common.ResourceBundleHelper;
import portalrefimpl.schedule.createappointment.AppointmentTime;
import portalrefimpl.schedule.ScheduleHelper;
import portalrefimpl.schedule.createappointment.AppointmentTimeResponse;
import portalrefimpl.schedule.createappointment.AppointmentTimeRequest;
import java.text.DateFormat;
import portalrefimpl.common.CommonConstants;
import portalrefimpl.common.serviceinvoker.ServiceInvoker;
import portalrefimpl.common.response.BaseResponse;
import portalrefimpl.common.response.ErrorInfo;
import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import portalrefimpl.PortalConstants;
import portalrefimpl.schedule.upcomingappointments.request.UpcomingAppointmentsRequest;
import portalrefimpl.schedule.upcomingappointments.response.UpcomingAppointmentsResponse;
import portalrefimpl.schedule.upcomingappointments.response.UpcomingAppointmentDetails;
import portalrefimpl.schedule.upcomingappointments.svc.UpcomingAppointmentsServiceInvoker;
import portalrefimpl.schedule.ScheduleConstants;
import portalrefimpl.PortalHelper;
import portalrefimpl.schedule.createappointment.CreateAppointmentConstants;
import portalrefimpl.facility.facilityforpatient.request.FacilityListRequest;
import portalrefimpl.facility.facilityforpatient.response.FacilityListResponse;
import portalrefimpl.common.model.Facility;
import portalrefimpl.facility.facilityforpatient.svc.FacilityListServiceInvoker;
import portalrefimpl.schedule.createappointment.request.SpecialityRequest;
import portalrefimpl.schedule.createappointment.response.SpecialityResponse;
import portalrefimpl.schedule.createappointment.response.SpecialityModel;
import portalrefimpl.schedule.createappointment.svc.serviceinvoker.SpecialityServiceInvoker;

public final class __upcomingappointments extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/portal/jsp/schedule/UpcomingAppointments.jsp", 1669269355984L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\r\n\r\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\r\n\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n<html>\r\n<head>\r\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n<title>::: Patient Portal - Appointments :::</title>\r\n<meta name=\"keywords\" content=\"\" />\r\n<meta name=\"description\" content=\"\" />\r\n<link rel=\"stylesheet\" href=\"../../css/style.css\" type=\"text/css\"/>\r\n<link rel=\"stylesheet\" href=\"../../css/style_ie.css\" type=\"text/css\"/>\r\n\r\n<link href=\"../../css/examples-offline.css\" rel=\"stylesheet\">\r\n<link href=\"../../css/kendo.common.min.css\" rel=\"stylesheet\">\r\n<link href=\"../../css/kendo.default.min.css\" rel=\"stylesheet\">\r\n\r\n<script src=\"../../js/jquery.min.js\"></script>\r\n<script src=\"../../js/kendo.web.min.js\"></script>\r\n<script src=\"../../js/console.js\"></script>\r\n<script src=\"../../js/date.js\"></script>\r\n\r\n<style>\r\n    #special-days {\r\n        height: 185px;\r\n        width: 300px;\r\n        margin: 2px auto;\r\n        /*padding: 2px 0 2px 2px;*/\r\n    }\r\n\r\n    #ApptPreferredDate {\r\n        border-radius: 3px 3px 3px 3px;\r\n        border-style: solid;\r\n        border-width: 1px;\r\n    }\r\n\r\n    .k-header {\r\n        border-radius: 3px 3px 0 0;\r\n    }\r\n\r\n    #ApptPreferredDate .k-content {\r\n        height: 137px;\r\n        width:262px;\r\n    }\r\n\r\n     .normal {\r\n        /* background: transparent url(../../content/web/calendar/exhibition.png) no-repeat 0 50%; */\r\n        background-color : transparent;\r\n        display: inline-block;\r\n        width: 100%;\r\n        height: 10px;\r\n        vertical-align: middle;\r\n        margin-right: 3px;\r\n    }\r\n\r\n.menu li a:before {\r\n\tcontent:url(../../images/patch.PNG);\r\n\theight:80px;\r\n\twidth:auto;\r\n\ttop:63px;\r\n\tleft:-13px;\r\n\tposition:relative;\r\n}\r\n.menu li a:after {content:url(../../images/patch.PNG);\r\n\theight:80px;\r\n\twidth:auto;\r\n\ttop:35px;\r\n\tright:-13px;\r\n\tposition:relative;\r\n\r\n}\r\n.menu li a:hover:before {content:url(../../images/LeftMenubg.PNG);\r\n\theight:80px;\r\n\twidth:auto;\r\n\ttop:63px;\r\n\tleft:-13px;\r\n\tposition:relative;\r\n}\r\n\r\n.menu li a:hover:after{\r\n\tcontent:url(../../images/RightMenubg.PNG);\r\n\theight:80px;\r\n\twidth:auto;\r\n\ttop:35px;\r\n\tright:-13px;\r\n\tposition:relative;\r\n}\r\n\r\n.menuselect:after{\r\n\tcontent:url(../../images/RightMenubg.PNG);\r\n\theight:80px;\r\n\twidth:auto;\r\n\ttop:35px;\r\n\tright:-13px;\r\n\tposition:relative;\r\n\r\n}\r\n.menuselect:before {content:url(../../images/LeftMenubg.PNG);\r\n\theight:80px;\r\n\twidth:auto;\r\n\ttop:65px;\r\n\tleft:-13px;\r\n\tposition:relative;\r\n\r\n}\r\n\r\n.confirmpopupContainerStyle {\r\n      background-color: white;\r\n      opacity: 90%;\r\n      filter:alpha(opacity=90);\r\n      background-color: rgba(255,255,255,0.90); \r\n      width: 100%;\r\n      min-height: 100%;\r\n      overflow: hidden;\r\n      float: absolute;\r\n      position: fixed;\r\n      top: 0;\r\n      left: 0;\r\n      color: white;\r\n      \r\n      /* z-index: -1;\r\n      opacity:0%; */\r\n\t}\r\n\t\r\n\t.confirmpopupContentStyle{\r\n\t  background-color: white;\r\n      color: black;\r\n      \r\n      padding: 2px;\r\n      display:block;\r\n      position: absolute;\r\n      top: 30%;\r\n      left: 30%;\r\n      /* width : 0px;\r\n      height : 0px;\r\n      z-index: -1; */\r\n      width: 582px;\r\n      height: 245px; \r\n\t}\r\n\r\n.cancelResultPopupContainerStyle {\r\n      background-color: white;\r\n      opacity: 90%;\r\n      filter:alpha(opacity=90);\r\n      background-color: rgba(255,255,255,0.90); \r\n      width: 100%;\r\n      min-height: 100%;\r\n      overflow: hidden;\r\n      float: absolute;\r\n      position: fixed;\r\n      top: 0;\r\n      left: 0;\r\n      color: white;\r\n      \r\n      /* z-index: -1;\r\n      opacity:0%; */\r\n\t}\r\n\t\r\n\t.cancelResultPopupContentStyle{\r\n\t  background-color: white;\r\n      color: black;\r\n      \r\n      padding: 2px;\r\n      display:block;\r\n      position: absolute;\r\n      top: 30%;\r\n      left: 30%;\r\n      /* width : 0px;\r\n      height : 0px;\r\n      z-index: -1; */\r\n      width: 582px;\r\n      height: 245px; \r\n\t}\r\n\r\n</style>\r\n\r\n <script>\r\n     $(document).ready(function() {\r\n         var today = new Date();\r\n\r\n         // create DatePicker from input HTML element\r\n         $(\"#fromDateText\").kendoDatePicker({\r\n        \t    format: \"dd/MM/yyyy\"\r\n         });\r\n         $(\"#toDateText\").kendoDatePicker({\r\n        \t    format: \"dd/MM/yyyy\"\r\n         });\r\n         \r\n         $(\"#ApptPreferredDate\").kendoCalendar({\r\n             value: today,\r\n             footer: \"Today - #=kendo.toString(data, \'d\') #\"\r\n         });\r\n     });\r\n     \r\n     function showMoreResults(){\r\n\r\n    \t\t// get the component which stores the current number\r\n    \t\t// of records shown in the page\r\n    \t\tvar currentResultCounterComp = document.getElementById(\"resultCounter\");\r\n    \t\tvar currentResultCounter;\r\n    \t\tif(currentResultCounterComp){\r\n    \t\t\tcurrentResultCounter = currentResultCounterComp.value;\r\n    \t\t}\r\n    \t\t// get the int value\r\n    \t\tvar currentResultCounterInt = parseInt(currentResultCounter);\r\n    \t\t// get the component which stores the overall number\r\n    \t\t// of records shown in the page\r\n    \t\tvar resultCountComp = document.getElementById(\"resultCount\");\r\n    \t\tvar resultCount;\r\n    \t\tif(resultCountComp){\r\n    \t\t\tresultCount = resultCountComp.value;\r\n    \t\t}\r\n    \t\tvar resultCountInt = parseInt(resultCount);\r\n    \t\t\r\n    \t\t// get the component which stores the number of records to be shown\r\n    \t\t// every time user clicks on \"click more\" button\r\n    \t\tvar recordViewCountComp = document.getElementById(\"UpcomingAppointmentsRowCount\")\r\n    \t\tvar recordViewCount;\r\n    \t\tif(recordViewCountComp){\r\n    \t\t\trecordViewCount = recordViewCountComp.value;\r\n    \t\t}\r\n    \t\tvar recordViewCountInt = parseInt(recordViewCount);\r\n    \t\t\r\n    \t\t// the logic now is to show records further from the current\r\n    \t\t// number of records shown till the next set of records\t\r\n    \t\tvar iterationEndValue = resultCountInt;\r\n    \t\tif((currentResultCounterInt + recordViewCountInt) < resultCountInt){\r\n    \t\t\titerationEndValue = currentResultCounterInt + recordViewCountInt;\r\n    \t\t}\r\n    \t\t    \t\t\r\n    \t\tvar resultElement;\r\n    \t\tfor(var itrCnt=(currentResultCounterInt + 1);itrCnt<=iterationEndValue;itrCnt++){\r\n    \t\t\tresultElement = document.getElementById(\"result\"+itrCnt);\r\n    \t\t\tif(resultElement){\r\n    \t\t\t\tresultElement.style.display = \'block\';\r\n    \t\t\t}\r\n    \t\t}\r\n    \t\t\r\n    \t\t// this code will disable the \"click more\" button since there are\r\n    \t\t// no more records to be shown\r\n    \t\tif(iterationEndValue == resultCountInt){\r\n    \t\t\tvar moreResultDivComp = document.getElementById(\"moreResultDiv\");\r\n    \t\t\tif(moreResultDivComp){\r\n    \t\t\t\tmoreResultDivComp.style.display = \"none\";\r\n    \t\t\t}\r\n    \t\t}\r\n    \t\t\r\n    \t\tcurrentResultCounterComp.value = \"\"+iterationEndValue;\r\n     }\r\n     \r\n     \r\n     function searchResults(){\r\n    \t var formElement = document.getElementById(\"searchForm\");\r\n    \t document.getElementById(\"hdnPostBack\").value = \"true\";\r\n    \t document.getElementById(\"hdnFacilityId\").value = document.getElementById(\"facilityIdText\").value;\r\n    \t document.getElementById(\"hdnFromDate\").value = document.getElementById(\"fromDateText\").value;\r\n    \t document.getElementById(\"hdnToDate\").value = document.getElementById(\"toDateText\").value;\r\n\t\t\r\n    \t var fromDateText = document.getElementById(\"fromDateText\").value;\r\n    \t var toDateText = document.getElementById(\"toDateText\").value;\r\n\r\n    \t var dateTimePicker = $(\"#fromDateText\").data(\"kendoDatePicker\");\r\n    \t var fromDate = dateTimePicker.value();\r\n    \t var dateTimePicker = $(\"#toDateText\").data(\"kendoDatePicker\");\r\n    \t var toDate = dateTimePicker.value();\r\n    \t \r\n    \t var today = new Date();\r\n\t\t \r\n    \t if((fromDateText == \"\" && toDateText!= \"\")||(toDateText == \"\" && fromDateText!= \"\")){\r\n    \t\t alert(\"Both From and To date should be present\")\r\n    \t }\r\n    \t else if(fromDateText!=\"\" && toDateText!=\"\"){\r\n\t\t\t\tif(fromDate == null){\r\n    \t\t \talert(\"From date value is invalid\");\r\n\t\t    \t }\r\n\t\t    \t else if(toDate == null){\r\n\t\t    \t\t alert(\"To date value is invalid\");\r\n\t\t    \t }\r\n\t\t    \t else if(!fromDate > today){\r\n\t\t    \t\t alert(\"From date cannot be before today\");\r\n\t\t    \t }\r\n\t\t    \t else if(fromDate > toDate){\r\n\t\t    \t\t alert(\"From date cannot be after to date\");\r\n\t\t    \t }\r\n\t\t    \t else {\r\n\t\t    \t\t formElement.submit();\r\n\t\t    \t }\r\n    \t }\r\n    \t else{\r\n    \t\t formElement.submit();\r\n    \t }\r\n    \t \r\n    \t \r\n     }\r\n     \r\n     function showAppointment(){\r\n    \t // this function allows the user to move from the home page\r\n    \t // to the book appointment screen\r\n    \t \r\n    \t // first call the validation function\r\n    \t var isValid = validateForm();\r\n    \t if(!isValid){\r\n    \t\t return;\r\n    \t }\r\n    \t \r\n    \t // get the calendar object and the preferred date\r\n    \t var calendar = $(\"#ApptPreferredDate\").data(\"kendoCalendar\");\r\n    \t var preferredApptDate = calendar.value();\r\n    \t \r\n    \t var dateValue = \"\"+preferredApptDate.getDate()+\"/\"+(preferredApptDate.getMonth()+1)+\"/\"+preferredApptDate.getFullYear();\r\n    \t // hidden var which will stored the preferred date\r\n    \t var preferredDateHdnElement = document.getElementById(\"hdnPreferredDate\");\r\n    \t if(preferredDateHdnElement){\r\n    \t\t preferredDateHdnElement.value = dateValue;\r\n    \t }\r\n    \t \r\n    \t var specialtyCombo = document.getElementById(\"Speciality\");\r\n    \t if(specialtyCombo){\r\n    \t\t //specialtyCombo.inner\r\n    \t\t //alert($(\"#Speciality\").find(\'option:selected\').text()+ \'  \'+$(\"#Speciality\").find(\'option:selected\').val());\r\n    \t\t var hiddenSpecialtyComp = document.getElementById(\"hdnSelectedSpecialtyDesc\");\r\n    \t\t if(hiddenSpecialtyComp){\r\n    \t\t\t hiddenSpecialtyComp.value = $(\"#Speciality\").find(\'option:selected\').text();\r\n    \t\t }\r\n    \t }\r\n    \t \r\n    \t var facilityCombo = document.getElementById(\"Facility\");\r\n    \t if(facilityCombo){\r\n    \t\t var hiddenFacilityComp = document.getElementById(\"hdnSelectedFacilityDesc\");\r\n    \t\t if(hiddenFacilityComp){\r\n    \t\t\t hiddenFacilityComp.value = $(\"#Facility\").find(\'option:selected\').text();\r\n    \t\t }\r\n    \t }\r\n    \t \r\n    \t \r\n    \t // get the form element, set the action and submit the form\r\n    \t var formElement = document.getElementById(\"searchForm\");\r\n    \t if(formElement){\r\n    \t\t formElement.action = \"./SpecialityServlet\";\r\n    \t\t formElement.submit();\r\n    \t }\r\n     }\r\n     \r\n     function validateForm(){\r\n    \t var validationMessage = \"\";\r\n    \t \r\n    \t // first validate the fields in the GUI\r\n    \t var calendar = $(\"#ApptPreferredDate\").data(\"kendoCalendar\");\r\n         var preferredApptDate = calendar.value();\r\n         if(isNaN(preferredApptDate)){\r\n        \t validationMessage = \"Preferred date \"+preferredApptDate+\" is not valid. \\n\";\r\n         }\r\n         \r\n        var currentDate = new Date();\r\n         \r\n    \t // time validation\r\n    \tvar selectedFromTimeComp = document.getElementById(\"ApptPreferredFromTime\");\r\n    \tvar selectedFromTimeIndex;\r\n    \tvar selectedFromTime = \"\";\r\n    \tif(selectedFromTimeComp){\r\n    \t\tselectedFromTimeIndex = selectedFromTimeComp.selectedIndex;\r\n    \t\tselectedFromTime = selectedFromTimeComp.value;\r\n    \t\tselectedFromTime = trimText(selectedFromTime);\r\n    \t}\r\n    \t\r\n    \tvar selectedToTimeIndex;\r\n    \tvar selectedToTimeComp = document.getElementById(\"ApptPreferredToTime\");\r\n    \tvar selectedToTime = \"\";\r\n    \tif(selectedToTimeComp){\r\n    \t\tselectedToTimeIndex = selectedToTimeComp.selectedIndex;\r\n    \t\tselectedToTime = selectedToTimeComp.value;\r\n    \t\tselectedToTime = trimText(selectedToTime);\r\n    \t}\r\n    \t\r\n    \tvar selectedTimeIsInvalid = false;\r\n    \tif(selectedFromTime.length == 0 && selectedToTime.length == 0){\r\n    \t\tvalidationMessage += \"Appointment start and end time is not specified. \\n\";\r\n    \t\tselectedTimeIsInvalid = true;\r\n    \t}else if(selectedFromTime.length == 0){\r\n    \t\tvalidationMessage += \"Appointment start time is not specified. \\n\";\r\n    \t\tselectedTimeIsInvalid = true;\r\n    \t}else if(selectedToTime.length == 0){\r\n    \t\tvalidationMessage += \"Appointment end time is not specified. \\n\";\r\n    \t\tselectedTimeIsInvalid = true;\r\n    \t}else if(selectedFromTime == selectedToTime){\r\n    \t\tvalidationMessage += \"Appointment start and end time cannot be same. \\n\";\r\n    \t\tselectedTimeIsInvalid = true;\r\n    \t}\r\n    \t\r\n    \tvar delimiter = \":\";\r\n    \tvar delimiterIndex = selectedFromTime.indexOf(delimiter);\r\n    \tvar hrsStr = \"\";\r\n    \tvar hrs = 0;\r\n    \tvar minsStr = \"\";\r\n    \tvar mins = 0;\r\n    \tif(delimiterIndex > 0){\r\n    \t\thrsStr = selectedFromTime.substring(0,delimiterIndex);\r\n    \t\tminsStr = selectedFromTime.substring(delimiterIndex+1,selectedFromTime.length);\r\n    \t\ttry{\r\n    \t\t\thrs = parseInt(hrsStr);\t\r\n    \t\t}catch(e){\r\n    \t\t\thrs = 0;\r\n    \t\t}\r\n    \t\ttry{\r\n    \t\t\tmins = parseInt(minsStr);\r\n    \t\t}catch(e){\r\n    \t\t\tmins = 0;\r\n    \t\t}\r\n    \t}\r\n    \t// set the hours, minutes and the seconds\r\n    \t// seconds will be set to 0 now\r\n    \tpreferredApptDate.setHours(hrs);\r\n    \tpreferredApptDate.setMinutes(mins);\r\n    \tpreferredApptDate.setSeconds(0);\r\n    \t\r\n    \t// validate the appointment start time with current date only\r\n    \t// when the start time is selected properly by user\r\n    \tif((preferredApptDate < currentDate) && !selectedTimeIsInvalid){\r\n    \t\tvalidationMessage += \"Appointment start time cannot be less than current time. \\n\";\r\n    \t}\r\n    \t\r\n    \t// validate the appointment start time with appointment end time only\r\n    \t// when the start time and end time is selected properly by user\t\r\n    \tif((selectedFromTimeIndex > selectedToTimeIndex) && !selectedTimeIsInvalid){\r\n    \t\tvalidationMessage += \"Appointment start time cannot be greater than or equal to end time. \\n\";\r\n    \t}\r\n    \t\r\n    \t// speciality and facility validation\r\n    \t// first speciality\r\n    \tvar hiddenSpecialityComp = document.getElementById(\"Speciality\");\r\n    \tvar selectedSpeciality=\"\";\r\n    \tif(hiddenSpecialityComp){\r\n    \t\tselectedSpeciality = hiddenSpecialityComp.value;\r\n    \t\tselectedSpeciality = trimText(selectedSpeciality);\r\n    \t}\r\n    \tif(selectedSpeciality.length == 0){\r\n    \t\tvalidationMessage += \"Speciality is not selected. \\n\";\r\n    \t}\r\n    \t\r\n    \t// validate selected facility\r\n    \tvar selectedFacility = \"\";\r\n    \tvar facilityComp = document.getElementById(\"Facility\");\r\n    \tif(facilityComp){\r\n    \t\tselectedFacility = facilityComp.value;\r\n    \t\tselectedFacility = trimText(selectedFacility);\r\n    \t}\r\n    \t\r\n    \tif(selectedFacility.length == 0){\r\n    \t\tvalidationMessage += \"Facility is not selected. \\n\";\r\n    \t}\r\n    \t\r\n    \tif(validationMessage.length > 0){\r\n    \t\talert(validationMessage);\r\n    \t\treturn false;\r\n    \t}\r\n    \t \r\n    \treturn true;\r\n     }\r\n\r\n     function trimText(textVal){\r\n    \t var l=0; var r=textVal.length -1;\r\n    \t while(l < textVal.length && textVal[l] == \' \'){\r\n    \t\t  l++;\r\n    \t }\r\n    \t\t\r\n    \t while(r > l && textVal[r] == \' \'){\r\n    \t\tr-=1;\r\n    \t }\r\n    \t textVal = textVal.substring(l, r+1);\r\n    \t \r\n    \t return textVal;\r\n     }\r\n     \r\n     function rescheduleAppointment(apptNumber){\r\n    \t// this function starts the reschedule appointment flow\r\n     \t// by submitting the form to get the appointment request details\r\n     \tvar rescheduleApptReqURL = \"./ApptRequestDetailsServlet\";\r\n     \trescheduleApptReqURL += \"?referenceNumber=\"+apptNumber;\r\n     \t// get the form element, set the action and submit the form\r\n \t   \tvar formElement = document.getElementById(\"searchForm\");\r\n \t   \tif(formElement){\r\n \t   \t\tformElement.action = rescheduleApptReqURL;\r\n \t   \t\tformElement.submit();\r\n \t   \t}\r\n     }\r\n     \r\n     function confirmCancelAppointment(appointmentNumber,appointmentStatus,specialty,facilityId,practitionerName,appointmentDate,apptStartTime,apptEndTime){\r\n    \t // this function will show an confirmation popup before an\r\n    \t // appointment is cancelled\r\n    \t //alert(appointmentNumber+\"|||\"+appointmentStatus+\"|||\"+specialty+\"|||\"+facilityId+\"|||\"+practitionerName+\"|||\"+appointmentDate+\"|||\"+apptStartTime+\"|||\"+apptEndTime);\r\n    \t var apptNumber = escape(appointmentNumber);\r\n    \t var apptStatus = escape(appointmentStatus);\r\n    \t var spl = escape(specialty);\r\n    \t var fac = escape(facilityId);\r\n    \t var prac = escape(practitionerName);\r\n    \t var apptDate = escape(appointmentDate);\r\n    \t var startTime = escape(apptStartTime);\r\n    \t var endTime = escape(apptEndTime);\r\n    \t var confirmPopupURL = \"./CancelAppConfirm.jsp?appointmentNumber=\"+apptNumber+\"&status=\"+apptStatus+\"&specialty=\"+spl+\"&facilityId=\"+fac+\"&practitionerName=\"+prac+\"&appointmentDate=\"+apptDate+\"&startTime=\"+startTime+\"&endTime=\"+endTime;\r\n    \t //alert(confirmPopupURL);\r\n    \t $(\'#confirmCancelPopupDiv\').load(confirmPopupURL);\r\n \t    \r\n \t\tif (document.getElementById(\'confirmCancelPopupContainerDiv\').style.visibility == \'hidden\') {\r\n \t       document.getElementById(\'confirmCancelPopupContainerDiv\').style.visibility = \'\';\r\n \t       $(\"#confirmCancelPopupContainerDiv\").hide();\r\n \t    }\r\n \t    if (document.getElementById(\'confirmCancelPopupDiv\').style.visibility == \'hidden\') {\r\n \t       document.getElementById(\'confirmCancelPopupDiv\').style.visibility = \'\';\r\n \t       $(\"#confirmCancelPopupDiv\").hide();\r\n \t    }\r\n \t\t\r\n \t\t$(\"#confirmCancelPopupContainerDiv\").fadeIn(300, \"linear\", function () { $(\"#confirmCancelPopupDiv\").show(400, \"swing\"); });\r\n    \t \r\n     }\r\n     \r\n    function closeConfirmCancelAppointmentPopup(){\r\n  \t   // this function will close the confirm cancel appointment popup dialog\r\n  \t\t$(\"#confirmCancelPopupDiv\").hide(\'300\', \"swing\", function () { $(\"#confirmCancelPopupContainerDiv\").fadeOut(\"200\"); });\r\n  \t}\r\n    \r\n    function cancelAppointmentMain(appointmentNumber,appointmentStatus,facilityId,selectedReasonCode){\r\n    \t// this function cancels an appointment\r\n    \t$(\"#confirmCancelPopupDiv\").hide(\'200\', \"swing\", function () { $(\"#confirmCancelPopupContainerDiv\").fadeOut(\"100\"); });\r\n    \t\r\n    \tvar cancelApptResultURL = \"./CancelAppointmentServlet?\";\r\n    \tcancelApptResultURL += \"appointmentNumber=\"+appointmentNumber+\"&appointmentStatus=\"+appointmentStatus+\"&FacilityId=\"+facilityId+\"&cancelReasonCode=\"+selectedReasonCode;\r\n    \t\r\n    \t$(\"#cancelApptResultPopupDiv\").load(cancelApptResultURL);\r\n    \tif (document.getElementById(\'cancelApptResultPopupContainerDiv\').style.visibility == \'hidden\') {\r\n  \t       document.getElementById(\'cancelApptResultPopupContainerDiv\').style.visibility = \'\';\r\n  \t       $(\"#cancelApptResultPopupContainerDiv\").hide();\r\n  \t    }\r\n  \t    if (document.getElementById(\'cancelApptResultPopupDiv\').style.visibility == \'hidden\') {\r\n  \t       document.getElementById(\'cancelApptResultPopupDiv\').style.visibility = \'\';\r\n  \t       $(\"#cancelApptResultPopupDiv\").hide();\r\n  \t    }\r\n  \t\t\r\n  \t\t$(\"#cancelApptResultPopupContainerDiv\").fadeIn(200, \"linear\", function () { $(\"#cancelApptResultPopupDiv\").show(300, \"swing\"); });\r\n    \t\r\n    }\r\n    \r\n    function closeCancelAppointmentResultPage(){\r\n    \t// this function closes the cancel appointment result popup\r\n    \t$(\"#cancelApptResultPopupDiv\").hide(\'300\', \"swing\", function () { $(\"#cancelApptResultPopupContainerDiv\").fadeOut(\"200\"); });\r\n    \t // get the form element, set the action and submit the form\r\n\t   \t var formElement = document.getElementById(\"searchForm\");\r\n\t   \t if(formElement){\r\n\t   \t\t formElement.submit();\r\n\t   \t }\r\n    }\r\n     \r\n </script>\r\n</head>\r\n\r\n<body>\r\n\t";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\r\n\r\n\r\n\t<div id=\"wrapper\" style=\"background-color: #ffffff;\">\r\n\t\t<div class=\"fixedheader\">\r\n\t\t\t<header id=\"header\">\r\n\t\t\t\t<div id=\"headerinfo\">\r\n\t\t\t\t\t<div class=\"row\">\r\n\t\t\t\t\t\t<div id=\"headervisitinfo\">Welcome back! Your last visit was\r\n\t\t\t\t\t\t\ton Wed, Dec 5, 2012 12:47:08 PM</div>\r\n\t\t\t\t\t\t<div id=\"headerloginas\">\r\n\t\t\t\t\t\t\t<strong>Welcome, ";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 =", ID:";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="</strong>\r\n\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t<div id=\"headerlogout\">\r\n\t\t\t\t\t\t\t<div>\r\n\t\t\t\t\t\t\t\t<a href=\"../../servlet/LogoutServlet\" class=\"logout\"> Logout</a>\r\n\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t</div>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t</div>\r\n\t\t\t</header>\r\n\r\n\t\t\t<!-- #header-->\r\n\r\n\t\t\t<!-- #logo And Menu -->\r\n\r\n\t\t\t<div id=\"logomenu\">\r\n\t\t\t\t<div class=\"row\">\r\n\t\t\t    \t<div id=\"logo\">\r\n\t\t\t\t\t\t<img src=\"../../images/logo.png\"> \r\n\t\t\t        </div>\r\n\t\t\t        <div id=\"Menubox\">\r\n\t\t\t\t\t\t<ul class=\"menu\">\r\n\t\t\t                <li><a href=\"../Contact.jsp\"><div class=\"menuicons\"><img src=\"../../images/Contact.png\"/></div>Contact</a></li>\r\n\t\t\t                <li><a href=\"../result/DetailedResult.jsp\"><div class=\"menuicons\"><img src=\"../../images/Results.png\"/></div>My Results</a></li>\r\n\t\t\t                <li class=\"menuselect\"><div class=\"menuicons\"><img src=\"../../images/Appointment.png\"/></div>My Appointments</a></li>\r\n\t\t\t                <li><a href=\"../PortalHome.jsp\"><div class=\"menuicons\"><img src=\"../../images/Home.png\"/></div>Home</a></li>\r\n\t\t\t            </ul>\r\n\t\t\t        </div>\r\n\t\t\t    </div>\r\n\t\t\t</div>\r\n\t\t</div>\r\n\t\t<!-- #logo And Menu -->\r\n\r\n\t\t<div class=\"line\"></div>\r\n\r\n\t\t<form id=\"searchForm\" name=\"searchForm\" method=\"POST\" >\r\n\r\n\t\t<div id=\"content\" style=\"background-color: #ffffff;padding-bottom: 1px;\">\r\n\r\n\t\t\t<!-- #Patient Banner-->\r\n\r\n\t\t\t<!-- #Patient Banner-->\r\n\t\t\t<!-- #Content Area-->\r\n\t\t\t<div id=\"contentbg\"></div>\r\n\t\t\t<div id=\"contentArea\" style=\"min-height:460px;height:505px;max-height: 505px;overflow:none;\">\r\n\r\n\t\t\t\t<div id=\"contentArearow\" style=\"min-height:460px;height:505px;max-height: 505px;\">\r\n\r\n\t\t\t\t\t<div class=\"cellindex searchindex\">\r\n\t\t\t\t\t\t<div id=\"BooknewAppsearchindex\">\r\n\t\t\t\t\t\t\t<div class=\"BookAppTitlehomepg\">Book an appointment</div>\r\n\t\t\t\t\t\t\t<div class=\"bookcontent\">\r\n\t\t\t\t\t\t\t\t<div id=\"Apptime\">\r\n\t\t\t\t\t\t\t\t\t<div id=\"special-days\">\r\n\t\t\t               \t\t\t\t<!-- <div id=\"calendar\" style=\"width: 262px;\"></div> -->\r\n\t\t\t               \t\t\t\t<div id=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\"\r\n\t\t\t               \t\t\t\t\tname=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\" \r\n\t\t\t              \t\t\t\t\t style=\"width: 262px;\">\r\n\t\t\t              \t\t\t\t</div>\r\n\t\t\t          \t \t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t<div class=\"ApptitleReschedule\">Preferred time</div>\r\n\t\t\t\t\t\t\t\t\t<select class=\"textboxtimeindex\" id=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"\r\n\t\t\t\t\t\t\t\t\t\tname=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\" style=\"width: 110px;\">\r\n\t\t\t\t\t\t\t\t\t\t<option>Select time</option>\r\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\r\n\t\t\t\t\t\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</option>\r\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\r\n\t\t\t\t\t\t\t\t\t</select> \r\n\t\t\t\t\t\t\t\t\t<span>to</span> \r\n\t\t\t\t\t\t\t\t\t<select class=\"textboxtimeindex\"  id=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" \r\n\t\t\t\t\t\t\t\t\t\tstyle=\"width: 110px;\">\r\n\t\t\t\t\t\t\t\t\t\t<option>Select time</option>\r\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\r\n\t\t\t\t\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</option>\r\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\r\n\t\t\t\t\t\t\t\t\t</select>\r\n\t\t\t\t\t\t\t\t\t<div></div>\r\n\t\t\t\t\t\t\t\t\t<span class=\"ApptitleReschedule\" style=\"margin-right: 75px;\">Speciality</span>\r\n\t\t\t\t\t\t\t\t\t<span class=\"ApptitleReschedule\">Facility</span>\r\n\t\t\t\t\t\t\t\t\t<!--  just for giving line -->\r\n\t\t\t\t\t\t\t\t\t<div></div>\r\n\t\t\t\t\t\t\t\t\t<!-- <div class=\"ApptitleReschedule\">Speciality</div> -->\r\n\t\t\t\t\t\t\t\t\t<select class=\"textbox\" id=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" \r\n\t\t\t\t\t\t\t\t\t\tname=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" style=\"width: 125px;margin-right: 5px;\">\r\n\t\t\t\t\t\t\t\t\t\t<option value=\"\">---All---</option>\r\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =">";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\r\n\r\n\t\t\t\t\t\t\t\t\t\t</select>\r\n\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t<!-- facility comp  -->\r\n\t\t\t\t       \t\t\t\t   <select class=\"textbox\" id=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" name=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" style=\"width: 125px;\">\r\n\t\t\t\t       \t\t\t\t   \t<option value=\"\" selected=\"selected\">----All----</option>\r\n\t\t\t\t       \t\t\t\t   \t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t  \t<option value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</option>\t\t\r\n\t\t\t\t\t\t\t\t\t  \t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\r\n\t\t\t\t       \t\t\t\t   \t\r\n\t\t\t\t       \t\t\t\t   </select> \r\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"hdnPreferredDate\" name=\"hdnPreferredDate\" value=\"\">\r\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"hdnSelectedSpecialtyDesc\" name=\"hdnSelectedSpecialtyDesc\" value=\"\">\r\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"hdnSelectedFacilityDesc\" name=\"hdnSelectedFacilityDesc\" value=\"\">\r\n\t\t\t\t\t\t\t\t</div>\r\n\r\n\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t<div class=\"centeralign\">\r\n\t\t\t\t\t\t\t\t<span><a href=\"#\" onclick=\"showAppointment()\"  class=\"PPbtn\">Book an appointment</a></span>\r\n\t\t\t\t\t\t\t</div>\r\n\r\n\t\t\t\t\t\t</div>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t\t<!-- page divider -->\r\n\t\t\t\t\t<div class=\"cellindex appindex\">\r\n\t\t\t\t\t\t<div class=\"tableindex\">\r\n\t\t\t\t\t\t\t<div class=\"row\">\r\n\t\t\t\t\t\t\t\t<div class=\"cellindex dividerindex\"></div>\r\n\t\t\t\t\t\t\t\t<div class=\"cellindex uppcomingwidth\">\r\n\t\t\t\t\t\t\t\t\t<div id=\"UpcomingAppExpand\">\r\n\t\t\t\t\t\t\t\t\t\t<div class=\"AppoinmentExpandTitle\">\r\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"titleSelected\">Upcoming appointments</div>\r\n\t\t\t\t\t\t\t\t\t\t\t<div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t<a href=\"PastAppoinments.html\">Past appointments</a>\r\n\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\r\n\t\t\t\t\t\t\t\t\t\t</div>\r\n\r\n\r\n\t\t\t\t\t\t\t\t\t\t<!-- content from result.html given here -->\r\n\t\t\t\t\t\t\t\t\t\t<div id=\"innercontentExpanded\" style=\"min-height: 450px;max-height: 450px;\">\r\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"row\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"cell\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"resulttableExpanded\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<!-- SEARCH ------->\r\n\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"innerrow\">\r\n\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"searcharea\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span><a href=\"#\" class=\"btn\" onclick=\"searchResults()\">Search</a></span> \r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<select class=\"CombotextboxdateUP\" name=\"facilityIdText\" id=\"facilityIdText\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"\">----Select Facility----</option>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\"  ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</option>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</select> \t\t\t\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t <span>From</span>     \r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input id=\"fromDateText\" name=\"fromDateText\" value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" style=\"width:160px;\" />\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>To</span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t         \t\t<input id=\"toDateText\" name=\"toDateText\" value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" style=\"width:160px;\"/>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"min-height: 25px;width:100%;border: 1px solid #CDCDCD;\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"loginerror\" style=\"padding-left: 10px;margin-top: 5px;\">";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\r\n              \t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"min-height: 20px;width:100%;border: 1px solid #CDCDCD;padding-top: 5px;\">\r\n              \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span style=\"padding-left: 10px;color: #000000;font-size: 12px;\">";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</span>\r\n              \t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n              \t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\r\n           \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"min-height: 20px;width:100%;border: 1px solid #CDCDCD;padding-top: 5px;\">\r\n              \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span style=\"padding-left: 10px;color: #000000;font-size: 12px;\">";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\r\n              \t\t\t\t\t\t\t\t\t\t\t<div class=\"innerrow\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"Resultarea\">\t\r\n              \t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\r\n              \t\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"result";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" style=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\"> \r\n              \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<!--  Result Box01 -->\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"stripbox\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"row\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<!-- Stripicon-->\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"StripSpaceA\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"StripIcon\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"StripIconHeader\">";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 =" - ";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<!-- Stripcontent-->\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"StripSpaceB\" style=\"width:60%;\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<p>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</span><span\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tclass=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\"> - ";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</p>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<p>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 =",</span><span\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tclass=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\"> ";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\">APP No:";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 =",</span> <span\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tclass=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="</span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tclass=\"printPDF\" src=\"../../images/PDF.png\"> <img\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tclass=\"printPDF\" src=\"../../images/print.png\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</p>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"StripSpaceC\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>Status : ";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"StripSpaceD\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<a href=\"#\" onclick=\"rescheduleAppointment(\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\')\"\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tclass=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\">Reschedule</a>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"StripSpaceD\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span><a href=\"#\" onclick=\"confirmCancelAppointment(\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\',\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\')\"\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tclass=\"UpcomingAppbtn\">Cancel</a></span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div> <!--  Result Box01 -->\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n              \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n\t\t              \t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\r\n              \t\t\t\t\t\t\t\t\t\t\t\t\t\r\n                  \t\t\t\t\t\t\t\t\t\t\t\t\t\r\n        \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n        \t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n        \t\t\t\t\t\t\t\t\t\t\t\t\t\t<!--  Result Box01 -->\r\n        \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\r\n\r\n        \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"innerrow\" id=\"moreResultDiv\" >\r\n        \t\t\t\t\t\t\t\t\t\t\t\t\t\t   \t\t <div id=\"MoreResult\">\r\n        \t\t\t\t\t\t\t\t\t\t\t\t\t\t         <!-- \tClick for more -->\r\n        \t\t\t\t\t\t\t\t\t\t\t\t\t\t         \t<span>\r\n        \t\t\t\t\t\t\t\t\t\t\t\t\t\t         \t\t<a onclick=\"showMoreResults()\" class=\"moreresultsbtn\" >Click for more \r\n   \t\t \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</a>\r\n   \t\t \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</span>\r\n        \t\t\t\t\t\t\t\t\t\t\t\t\t\t         </div>\r\n        \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n       \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\r\n              \t\t\t\t\t\t\t\t\t\t\t\t\t\r\n\r\n\t\t\r\n\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\r\n\r\n\t\t\t\t\t\t\t\t\t\t\t<!-- #Content Area       **********************************************        -->\r\n\r\n\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t<!-- content from result.html given here -->\r\n\r\n\r\n\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t</div>\r\n\r\n\r\n\t\t\t\t\t\t<!-- page divider -->\r\n\r\n\r\n\t\t\t\t\t</div>\r\n\t\t\t\t</div>\r\n\t\t\t</div>\r\n\t\t\r\n\t\t\t<!--  div for the popup -->\r\n\t\t\t<div id=\"confirmCancelPopupContainerDiv\" name=\"confirmCancelPopupContainerDiv\" class=\"confirmpopupContainerStyle\" style=\"visibility:hidden;\">\r\n\t\t\t\t<div id=\"confirmCancelPopupDiv\" name=\"confirmCancelPopupDiv\" class=\"confirmpopupContentStyle\" style=\"visibility:hidden;\">\r\n\t\t\t\t</div>\r\n\t\t\t</div>\r\n\t\t\t<div id=\"cancelApptResultPopupContainerDiv\" name=\"cancelApptResultPopupContainerDiv\" class=\"cancelResultPopupContainerStyle\" style=\"visibility:hidden;\">\r\n\t\t\t\t<div id=\"cancelApptResultPopupDiv\" name=\"cancelApptResultPopupDiv\" class=\"cancelResultPopupContentStyle\" style=\"visibility:hidden;\">\r\n\t\t\t\t</div>\r\n\t\t\t</div>\r\n\r\n\t\t</div>\r\n\t\t<input type=\"hidden\" id=\"totalResultsCount\" name=\"totalResultsCount\" value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\"/>\r\n\t\t<input type=\"hidden\" id=\"showInitialConstant\" name=\"showInitialConstant\" value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\"/>\r\n\t\t<input type=\"hidden\" id=\"currentShowing\" name=\"currentShowing\" value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\"/>\r\n\t\t<input type=\"hidden\" id=\"hdnFacilityId\" name=\"hdnFacilityId\" value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\"/>\r\n\t\t<input type=\"hidden\" id=\"hdnFromDate\" name=\"hdnFromDate\" value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\"/>\r\n\t\t<input type=\"hidden\" id=\"hdnToDate\" name=\"hdnToDate\" value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\"/>\r\n\t\t<input type=\"hidden\" id=\"hdnPostBack\" name=\"hdnPostBack\" value=\"false\"/>\r\n\t\t<input type=\"hidden\" id=\"UpcomingAppointmentsRowCount\" name=\"UpcomingAppointmentsRowCount\" value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\"/>\r\n\t\t<input type=\"hidden\" id=\"resultCount\" name=\"resultCount\" value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\"/>\r\n\t\t<input type=\"hidden\" id=\"resultCounter\" name=\"resultCounter\" value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\"/>\r\n\t\t</form>\r\n\t\t<!-- #Content Area-->\r\n\r\n\r\n\t\t<!-- #content-->\r\n\t<div class=\"Footerbg\" style=\"height: 20px;margin-top:5px;\">\r\n\t\t\r\n\t\r\n\r\n\t\t<div id=\"poweredby\">\r\n\t\t\t<p class=\"poweredby\">Powered by <img src=\"../../images/csc.png\" width=\"25\" height=\"14\"></p>\r\n        </div>\r\n\t\t\r\n\t\r\n\t</div>\r\n\t</div>\r\n\r\n\t<!-- #wrapper -->\r\n\r\n\r\n\t<!-- #footer -->\r\n\t<!-- <div id=\"footeradd\">\r\n<p class=\"FooterTitle\"> Get in Touch! </p>\r\n<p class=\"Footeradd\"> Envato Marketplace, Melbourne St, Sydney. TF - 123456, (+00) 0123-456-798, Contact@icarehospital.com, www.icarehospital.com </p>\r\n\r\n</div>-->\r\n</body>\r\n</html>\r\n";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

		String useWebService = "";
		useWebService = (String) session.getAttribute(PortalConstants.USEWEBSERVICE_SESSION_KEY);

		String patientId = "";
		patientId = (String) session.getAttribute(PortalConstants.PATIENTID_REQUEST_PARAM_KEY);
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
		if (patientName == null) {
			patientName = "";
		}
		
		String facilityIdParameter = request.getParameter("facilityIdText");
		String fromDateParameter = request.getParameter("fromDateText");
		String toDateParameter = request.getParameter("toDateText");
		
		String facilityIdPostBack = "";
		String fromDatePostBack = "";
		String toDatePostBack = "";
		String postBack = "";
		
		String resultCountString = request
				.getParameter("resultCount");
		if (resultCountString == null) {
			resultCountString = "0";
		}
		int resultCount = 0;
		try {
			resultCount = Integer.parseInt(resultCountString);
		} catch (Exception ex) {
			resultCount = 0;
		}

		final int TOTALRECORD_COUNT = 4;
		// read the result counter
		String resultCounterString = request
				.getParameter("resultCounter");
		String tempResultCountString = PortalHelper.getConfigPropertyValue(
				"UpcomingAppointmentsRowCount", true);
		if (resultCounterString == null) {
			resultCounterString = tempResultCountString;
		}
		int currentResultCounter = PortalHelper.getIntegerValue(
				tempResultCountString, TOTALRECORD_COUNT);
		int resultCounter = PortalHelper.getIntegerValue(
				tempResultCountString, TOTALRECORD_COUNT);
		
		//Invoking upcoming appointments service
		/* UpcomingAppointmentsSvcImpl svcImpl = new UpcomingAppointmentsSvcImpl(); */
		UpcomingAppointmentsRequest urequest = new UpcomingAppointmentsRequest();
		urequest.setPatientId(patientId);
		urequest.setPortalUserName(PortalConstants.PORTALUSER_REQUEST_PARAM_VALUE);
		if(facilityIdParameter!=null && !facilityIdParameter.trim().equals(""))
			urequest.setFacilityId(facilityIdParameter);
		if(fromDateParameter!=null && !fromDateParameter.equals(""))
			urequest.setFromDate(fromDateParameter);
		if(toDateParameter!=null && !toDateParameter.equals(""))
			urequest.setToDate(toDateParameter);
		/* svcImpl.registerService(urequest); */
		UpcomingAppointmentsServiceInvoker upcomingAppointmentsServiceInvoker = new UpcomingAppointmentsServiceInvoker();
		upcomingAppointmentsServiceInvoker.registerService(urequest);
		UpcomingAppointmentsResponse upcomingresponse = (UpcomingAppointmentsResponse) upcomingAppointmentsServiceInvoker
				.getDataThroughWebService(urequest);
		
		//Invoking Facility service to polpulate the facility dropdown
		/* FacilityListSvcImpl fsvcImpl = new FacilityListSvcImpl(); */
		FacilityListRequest frequest = new FacilityListRequest();
		frequest.setPatientId(patientId);
		frequest.setPortalUserName(PortalConstants.PORTALUSER_REQUEST_PARAM_VALUE);
				
		FacilityListServiceInvoker facilityListServiceInvoker = new FacilityListServiceInvoker();
		/* FacilityListResponse fresponse = fsvcImpl.getFacilityList(frequest); */		
		FacilityListResponse fresponse = facilityListServiceInvoker.getDataThroughService(frequest);
		
		
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
		
		if(request.getParameter("hdnPostBack") != null){
			postBack = request.getParameter("hdnPostBack");
			if(postBack.equals("true")){
				facilityIdPostBack = request.getParameter("hdnFacilityId");
				fromDatePostBack = request.getParameter("hdnFromDate");
				toDatePostBack = request.getParameter("hdnToDate");
			}

		} 
		

	
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(patientName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(CreateAppointmentConstants.APPT_PREFERREDDATE_PARAMETER_KEY));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(CreateAppointmentConstants.APPT_PREFERREDDATE_PARAMETER_KEY));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(CreateAppointmentConstants.APPT_PREFERREDFROMTIME_PARAMETER_KEY));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(CreateAppointmentConstants.APPT_PREFERREDFROMTIME_PARAMETER_KEY));
            _bw.write(_wl_block9Bytes, _wl_block9);

											AppointmentTimeRequest apptTimeRequest = new AppointmentTimeRequest(
													ScheduleConstants.BOOKAPPT_START_TIME_IDENTIFIER);
											AppointmentTimeResponse apptTimeResponse = ScheduleHelper.
													getAppointmentTimeResponse(apptTimeRequest);
											// there is no need to worry for errors as of now since
											// the data returned is going to be valid and that too not from db
											List<AppointmentTime> apptTimeList = apptTimeResponse
													.getAppointmentTimeList();
											String apptDisplayValue = null;
											String apptDataValue = null;
											
											// iterate through the list and show the time
											for (AppointmentTime apptTime : apptTimeList) {
												apptDisplayValue = apptTime.getAppointmentTime();
												apptDataValue = apptTime.getAppointmentDataValue();
											
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(apptDataValue ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(apptDisplayValue ));
            _bw.write(_wl_block12Bytes, _wl_block12);

												}
											
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(CreateAppointmentConstants.APPT_PREFERREDTOTIME_PARAMETER_KEY));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(CreateAppointmentConstants.APPT_PREFERREDTOTIME_PARAMETER_KEY));
            _bw.write(_wl_block14Bytes, _wl_block14);

										apptTimeRequest = new AppointmentTimeRequest(
												ScheduleConstants.BOOKAPPT_TO_TIME_IDENTIFIER);
										apptTimeResponse = ScheduleHelper.
												getAppointmentTimeResponse(apptTimeRequest);
										apptTimeList = apptTimeResponse
												.getAppointmentTimeList();
										// iterate through the list and show the time
										for (AppointmentTime apptTime : apptTimeList) {
											apptDisplayValue = apptTime.getAppointmentTime();
											apptDataValue = apptTime.getAppointmentDataValue();
										
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(apptDataValue ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(apptDisplayValue ));
            _bw.write(_wl_block16Bytes, _wl_block16);

											}
										
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(CreateAppointmentConstants.SPECIALITY_PARAMETER_KEY));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(CreateAppointmentConstants.SPECIALITY_PARAMETER_KEY));
            _bw.write(_wl_block19Bytes, _wl_block19);

												List<SpecialityModel> specialityList = null;
												String specialityCode;
												String specialityDesc;
												// check if the specialities were retrieved successfully
												// if so, then show the specialities
												if(sresponse.isSuccessful()){
													specialityList = sresponse.getSpecialityList();
													if (specialityList != null) {
														for (SpecialityModel s : specialityList) {
															specialityCode = s.getSpecialityCode();
															specialityDesc = s.getShortDesc();
															String selected = "";
														/* if (facilityId.equals(facilityIdPostBack))
															selected = "selected"; */
											
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(specialityCode));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(selected));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(specialityDesc));
            _bw.write(_wl_block12Bytes, _wl_block12);

														}
													}
												}
											
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(CreateAppointmentConstants.APPT_PREFERREDFACILITY_PARAMETER_KEY ));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(CreateAppointmentConstants.APPT_PREFERREDFACILITY_PARAMETER_KEY ));
            _bw.write(_wl_block24Bytes, _wl_block24);

				       				 		/* ErrorInfo facilityListErrorInfo = fresponse
							  								.getErrorInfo(); */
										  	List<Facility> facilityList = null;
										  	/* if (ErrorInfo.SUCCESS_CODE == facilityListErrorInfo.getErrorCode()) { */
										  	if (fresponse.isSuccessful()) {	
										  		facilityList = fresponse.getFacilityList();
										  		for (Facility facility : facilityList) {
										  
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(facility.getFacilityId()));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(facility.getFacilityName()));
            _bw.write(_wl_block26Bytes, _wl_block26);

										  		}
										  	}
				       				   	
            _bw.write(_wl_block27Bytes, _wl_block27);

																		//ErrorInfo errorInfo = upcomingresponse.getErrorInfo();
																		//int errorCode = errorInfo.getErrorCode(); 
																		String errorMessage = null;//errorInfo.getErrorMessage();
																		
																		String facilityId = null;
																		String facilityName = null;
																		facilityList = null;
																		/* if(ErrorInfo.SUCCESS_CODE == errorCode){ */
																		// check the upcoming appointment response's success state
																		if(upcomingresponse.isSuccessful()){	
																			facilityList = upcomingresponse.getUpcomingAppointmentsFacilityList();
																			
																			if(facilityList!=null){
			              														for(Facility f: facilityList){
																					facilityId = f.getFacilityId();
																					facilityName = f.getFacilityName();
																					String selected = "";
																					if(facilityId.equals(facilityIdPostBack))
																						selected = "selected";
																	
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(facilityId ));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(selected ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(facilityName ));
            _bw.write(_wl_block30Bytes, _wl_block30);
		
																				}
	              															}
																		 }
	              													
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(fromDatePostBack));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(toDatePostBack));
            _bw.write(_wl_block33Bytes, _wl_block33);
 
																
																String StripDate ="StripDate";
																String Stripday = "Stripday";
																String AppointmentNewDoctor = "AppointmentNewDoctor";
																String contenbold = "contenbold";
																int showInitialConstant = 4;
																int totalResultsCount = 0;
																String divMoreResultsVisibleStyle = "display:none";
																//int showInitialConstant = ScheduleConstants.UPCOMINGAPPOINTMENTS_RESULTS_SHOW_COUNT;
																errorMessage = upcomingresponse.getErrorMessage(); 
																if(!upcomingresponse.isSuccessful()) { 
																	// this indicates failure in the complete operation
																
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(errorMessage));
            _bw.write(_wl_block35Bytes, _wl_block35);

              													} else {
              														// showing information message
              														// part operation has failed - either appointments
              														// or appointment requests were not retrieved
              														if(errorMessage != null && !errorMessage.trim().equals("")){
              													
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(errorMessage ));
            _bw.write(_wl_block37Bytes, _wl_block37);
	
              														}else{
              															// showing a generic message that both appointments
              															// and appointment requests have been retrieved
              															errorMessage = ResourceBundleHelper.getMessageFromBundle
              																	(ScheduleConstants.UPCOMING_APPOINTMENT_BUNDLE_CLASS,
              																	ScheduleConstants.UPCOMING_APPOINTMENT_RETRIEVE_SUCCESS_DISPLAYMESSAGE_KEY);
              															if(errorMessage == null || errorMessage.trim().equals("")){
              																errorMessage = "Showing appointments and appointment requests.";
              															}
              													
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(errorMessage ));
            _bw.write(_wl_block37Bytes, _wl_block37);

              														}
              													
            _bw.write(_wl_block39Bytes, _wl_block39);
	
              														List<UpcomingAppointmentDetails> upcomingAppointmentDetails = upcomingresponse.getUpcomingAppointmentsList();
              														totalResultsCount = upcomingAppointmentDetails.size();
              														int counter = 1;
              														resultCount = upcomingAppointmentDetails.size();
              														String divResultsVisibleStyle = "display:block";
              														// var to store the appointment status for display purpose
              														String appointmentStatusForDisplay = null;
              														String appointmentStatus = null;
              														final String EM_APPOINTMENT_KEY = "Appointment";
              														final String APP_REQ_KEY = "Request";
              														final String APP_REQ_IDENTIFIER = "Appointment Request";
              														// var to store the style class for the reschedule appointment button
              														String rescheduleButtonStyle = null;
              														// constant to store the status for appointments booked in EM
              														final String EM_APPOINTMENT_STATUS = "1";
              														for(UpcomingAppointmentDetails d: upcomingAppointmentDetails){
              															String practitioner = d.getPractitionerName();
              															String speciality = d.getApptSpeciality();
              															String facility = d.getFacilityName();
              															String location = d.getLocationName();
              															String apptNum = d.getAppointmentNumber();
              															String startTime = d.getAppointmentStartTime();
              															String endTime = d.getAppointmentEndTime();
              															String apptDate = d.getAppointmentDate();
              															SimpleDateFormat df_full = new SimpleDateFormat("dd/MM/yyyy");
              															SimpleDateFormat df_month = new SimpleDateFormat("MMM");
              															SimpleDateFormat df_year = new SimpleDateFormat("yyyy");
              															SimpleDateFormat df_date = new SimpleDateFormat("dd");
              															SimpleDateFormat df_day = new SimpleDateFormat("EEEE");
              															Date appt_date = df_full.parse(apptDate);
              															String appt_month = df_month.format(appt_date);
              															String appt_year = df_year.format(appt_date);
              															String appt_date_num = df_date.format(appt_date);
              															String appt_weekday = df_day.format(appt_date);
              															// reset the reschedule button style
              															rescheduleButtonStyle = "UpcomingAppbtn";
              															
              															appointmentStatusForDisplay = d.getAppointmentStatus();
              															if(EM_APPOINTMENT_STATUS.equals(appointmentStatusForDisplay)){
              																appointmentStatusForDisplay = "Open";
              																rescheduleButtonStyle = "disabled";
              																appointmentStatus = EM_APPOINTMENT_KEY;
              															}else if(APP_REQ_IDENTIFIER.equals(appointmentStatusForDisplay)){
              																appointmentStatus = APP_REQ_KEY;
              															}
              															
              															if(counter>0){
			              													StripDate ="StripDatenormal";
																			Stripday = "Stripdaynormal";
																			AppointmentNewDoctor = "AppointmentNewDoctorNormal";
																			contenbold = "contentnormal";
              															}
              															
              															if(counter > currentResultCounter){
              																divResultsVisibleStyle = "display:none";
              															}

              															if(totalResultsCount>showInitialConstant){
              																divMoreResultsVisibleStyle = "display:table-row";
              															}
              																
              															
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(divResultsVisibleStyle));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(appt_month ));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf( appt_year ));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(StripDate ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(appt_date_num ));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(Stripday));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(appt_weekday ));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(AppointmentNewDoctor));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(practitioner ));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(AppointmentNewDoctor));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(speciality ));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(contenbold));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(facility));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(contenbold));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(location ));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(contenbold));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(apptNum ));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(contenbold));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(startTime ));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(endTime ));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(appointmentStatusForDisplay ));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(apptNum ));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(rescheduleButtonStyle));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(apptNum ));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(appointmentStatus ));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(speciality ));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(d.getFacilityId() ));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(practitioner ));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(apptDate ));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(startTime ));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(endTime ));
            _bw.write(_wl_block58Bytes, _wl_block58);
 
		              												counter++;	
		              												} 
		              												
            _bw.write(_wl_block59Bytes, _wl_block59);

          															if (resultCount > resultCounter) {
          														    
            _bw.write(_wl_block60Bytes, _wl_block60);

       																}
       															}
       															
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(totalResultsCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(showInitialConstant));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(showInitialConstant));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(facilityIdParameter));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(fromDateParameter));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(toDateParameter));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(resultCounter));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(resultCount));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(currentResultCounter));
            _bw.write(_wl_block70Bytes, _wl_block70);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
