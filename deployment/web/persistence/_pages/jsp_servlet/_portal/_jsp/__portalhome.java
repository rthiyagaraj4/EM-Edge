package jsp_servlet._portal._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import portalrefimpl.schedule.viewappointment.svc.AppointmentDetailsServiceInvoker;
import portalrefimpl.facility.facilityforpatient.svc.FacilityListServiceInvoker;
import portalrefimpl.homepage.response.HospitalDetailsResponse;
import portalrefimpl.schedule.createappointment.AppointmentTime;
import portalrefimpl.schedule.createappointment.AppointmentTimeResponse;
import portalrefimpl.schedule.ScheduleHelper;
import portalrefimpl.schedule.ScheduleConstants;
import portalrefimpl.schedule.createappointment.AppointmentTimeRequest;
import portalrefimpl.common.model.Facility;
import portalrefimpl.facility.facilityforpatient.response.FacilityListResponse;
import portalrefimpl.facility.facilityforpatient.request.FacilityListRequest;
import portalrefimpl.schedule.createappointment.response.SpecialityModel;
import portalrefimpl.schedule.createappointment.response.SpecialityResponse;
import portalrefimpl.schedule.createappointment.svc.serviceinvoker.SpecialityServiceInvoker;
import portalrefimpl.schedule.createappointment.request.SpecialityRequest;
import portalrefimpl.schedule.createappointment.CreateAppointmentConstants;
import portalrefimpl.result.ResultConstants;
import portalrefimpl.common.CommonConstants;
import portalrefimpl.result.viewtestresult.response.TestDetails;
import portalrefimpl.schedule.viewappointment.response.AppointmentDetails;
import java.util.List;
import portalrefimpl.result.viewtestresult.svc.TestDetailsServiceInvoker;
import portalrefimpl.result.viewtestresult.response.TestDetailsResponse;
import portalrefimpl.result.viewtestresult.request.TestDetailsRequest;
import portalrefimpl.common.response.ErrorInfo;
import portalrefimpl.schedule.viewappointment.response.AppointmentDetailsResponse;
import portalrefimpl.schedule.viewappointment.request.AppointmentDetailsRequest;
import portalrefimpl.homepage.response.PatientDetailsResponse;
import portalrefimpl.PortalHelper;
import java.util.Date;
import portalrefimpl.homepage.svc.HospitalDetailsServiceInvoker;
import portalrefimpl.homepage.request.HospitalDetailsRequest;
import portalrefimpl.common.response.BaseResponse;
import portalrefimpl.common.serviceinvoker.ServiceInvoker;
import portalrefimpl.homepage.svc.PatientDetailsServiceInvoker;
import portalrefimpl.PortalConstants;
import portalrefimpl.homepage.request.PatientDetailsRequest;

public final class __portalhome extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/portal/jsp/PortalHome.jsp", 1669269355891L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n<html>\r\n<head>\r\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n<title>::: Patient Portal - Home :::</title>\r\n<meta name=\"keywords\" content=\"\" />\r\n<meta name=\"description\" content=\"\" />\r\n<link rel=\"stylesheet\" href=\"../css/style.css\" type=\"text/css\"/>\r\n<link rel=\"stylesheet\" href=\"../css/style_ie.css\" type=\"text/css\"/>\r\n<link href=\"../css/examples-offline.css\" rel=\"stylesheet\">\r\n<link href=\"../css/kendo.common.min.css\" rel=\"stylesheet\">\r\n<link href=\"../css/kendo.default.min.css\" rel=\"stylesheet\">\r\n\r\n<script src=\"../js/jquery.min.js\"></script>\r\n<script src=\"../js/kendo.web.min.js\"></script>\r\n<script src=\"../js/console.js\"></script>\r\n\r\n<style scoped>\r\n    #special-days {\r\n        height: 190px;\r\n        width: 300px;\r\n        margin: 2px auto;\r\n        /*padding: 2px 0 2px 2px;*/\r\n    }\r\n\r\n    #ApptPreferredDate {\r\n        border-radius: 1px 1px 1px 1px;\r\n        border-style: solid;\r\n        border-width: 1px;\r\n    }\r\n\r\n    .k-header {\r\n        border-radius: 3px 3px 0 0;\r\n    }\r\n\r\n    #ApptPreferredDate .k-content {\r\n        height: 142px;\r\n        width:262px;\r\n    }\r\n\r\n     .normal {\r\n        /* background: transparent url(../../content/web/calendar/exhibition.png) no-repeat 0 50%; */\r\n        background-color : transparent;\r\n        display: inline-block;\r\n        width: 100%;\r\n        height: 10px;\r\n        vertical-align: middle;\r\n        margin-right: 3px;\r\n    }\r\n\r\n</style>\r\n\r\n<style>\r\n\r\n.menu li a:hover:before {content:url(../images/LeftMenubg.PNG);\r\n\theight:80px;\r\n\twidth:auto;\r\n\ttop:63px;\r\n\tleft:-13px;\r\n\tposition:relative;\r\n}\r\n\r\n.menu li a:hover:after{\r\n\tcontent:url(../images/RightMenubg.PNG);\r\n\theight:80px;\r\n\twidth:auto;\r\n\ttop:35px;\r\n\tright:-13px;\r\n\tposition:relative;\r\n}\r\n\r\n.menuselect:after{\r\n\tcontent:url(../images/RightMenubg.PNG);\r\n\theight:80px;\r\n\twidth:auto;\r\n\ttop:35px;\r\n\tright:-13px;\r\n\tposition:relative;\r\n\r\n}\r\n.menuselect:before {content:url(../images/LeftMenubg.PNG);\r\n\theight:80px;\r\n\twidth:auto;\r\n\ttop:65px;\r\n\tleft:-13px;\r\n\tposition:relative;\r\n\r\n}\r\n\r\n</style>\r\n\r\n <script>\r\n     $(document).ready(function() {\r\n         var today = new Date();\r\n\r\n         $(\"#ApptPreferredDate\").kendoCalendar({\r\n             value: today,\r\n             footer: \"Today - #=kendo.toString(data, \'d\') #\",\r\n             format: \"dd/MM/yyyy\" \r\n         });\r\n     });\r\n     \r\n     function showAppointment(){\r\n    \t // this function allows the user to move from the home page\r\n    \t // to the book appointment screen\r\n    \t \r\n    \t // first call the validation function\r\n    \t var isValid = validateForm();\r\n    \t if(!isValid){\r\n    \t\t return;\r\n    \t }\r\n    \t \r\n    \t // get the calendar object and the preferred date\r\n    \t var calendar = $(\"#ApptPreferredDate\").data(\"kendoCalendar\");\r\n    \t var preferredApptDate = calendar.value();\r\n    \t \r\n    \t var dateValue = \"\"+preferredApptDate.getDate()+\"/\"+(preferredApptDate.getMonth()+1)+\"/\"+preferredApptDate.getFullYear();\r\n    \t // hidden var which will stored the preferred date\r\n    \t var preferredDateHdnElement = document.getElementById(\"hdnPreferredDate\");\r\n    \t if(preferredDateHdnElement){\r\n    \t\t preferredDateHdnElement.value = dateValue;\r\n    \t }\r\n    \t \r\n    \t var specialtyCombo = document.getElementById(\"Speciality\");\r\n    \t if(specialtyCombo){\r\n    \t\t //specialtyCombo.inner\r\n    \t\t //alert($(\"#Speciality\").find(\'option:selected\').text()+ \'  \'+$(\"#Speciality\").find(\'option:selected\').val());\r\n    \t\t var hiddenSpecialtyComp = document.getElementById(\"hdnSelectedSpecialtyDesc\");\r\n    \t\t if(hiddenSpecialtyComp){\r\n    \t\t\t hiddenSpecialtyComp.value = $(\"#Speciality\").find(\'option:selected\').text();\r\n    \t\t }\r\n    \t }\r\n    \t \r\n    \t var facilityCombo = document.getElementById(\"Facility\");\r\n    \t if(facilityCombo){\r\n    \t\t var hiddenFacilityComp = document.getElementById(\"hdnSelectedFacilityDesc\");\r\n    \t\t if(hiddenFacilityComp){\r\n    \t\t\t hiddenFacilityComp.value = $(\"#Facility\").find(\'option:selected\').text();\r\n    \t\t }\r\n    \t }\r\n    \t \r\n    \t \r\n    \t // get the form element, set the action and submit the form\r\n    \t var formElement = document.getElementById(\"bookappointmentform\");\r\n    \t if(formElement){\r\n    \t\t formElement.action = \"./schedule/SpecialityServlet\";\r\n    \t\t formElement.submit();\r\n    \t }\r\n     }\r\n     \r\n     function validateForm(){\r\n    \t var validationMessage = \"\";\r\n    \t \r\n    \t // first validate the fields in the GUI\r\n    \t var calendar = $(\"#ApptPreferredDate\").data(\"kendoCalendar\");\r\n         var preferredApptDate = calendar.value();\r\n         if(isNaN(preferredApptDate)){\r\n        \t validationMessage = \"Preferred date \"+preferredApptDate+\" is not valid. \\n\";\r\n         }\r\n         \r\n        var currentDate = new Date();\r\n         \r\n    \t // time validation\r\n    \tvar selectedFromTimeComp = document.getElementById(\"ApptPreferredFromTime\");\r\n    \tvar selectedFromTimeIndex;\r\n    \tvar selectedFromTime = \"\";\r\n    \tif(selectedFromTimeComp){\r\n    \t\tselectedFromTimeIndex = selectedFromTimeComp.selectedIndex;\r\n    \t\tselectedFromTime = selectedFromTimeComp.value;\r\n    \t\tselectedFromTime = trimText(selectedFromTime);\r\n    \t}\r\n    \t\r\n    \tvar selectedToTimeIndex;\r\n    \tvar selectedToTimeComp = document.getElementById(\"ApptPreferredToTime\");\r\n    \tvar selectedToTime = \"\";\r\n    \tif(selectedToTimeComp){\r\n    \t\tselectedToTimeIndex = selectedToTimeComp.selectedIndex;\r\n    \t\tselectedToTime = selectedToTimeComp.value;\r\n    \t\tselectedToTime = trimText(selectedToTime);\r\n    \t}\r\n    \t\r\n    \tvar selectedTimeIsInvalid = false;\r\n    \tif(selectedFromTime.length == 0 && selectedToTime.length == 0){\r\n    \t\tvalidationMessage += \"Appointment start and end time is not specified. \\n\";\r\n    \t\tselectedTimeIsInvalid = true;\r\n    \t}else if(selectedFromTime.length == 0){\r\n    \t\tvalidationMessage += \"Appointment start time is not specified. \\n\";\r\n    \t\tselectedTimeIsInvalid = true;\r\n    \t}else if(selectedToTime.length == 0){\r\n    \t\tvalidationMessage += \"Appointment end time is not specified. \\n\";\r\n    \t\tselectedTimeIsInvalid = true;\r\n    \t}else if(selectedFromTime == selectedToTime){\r\n    \t\tvalidationMessage += \"Appointment start and end time cannot be same. \\n\";\r\n    \t\tselectedTimeIsInvalid = true;\r\n    \t}\r\n    \t\r\n    \tvar delimiter = \":\";\r\n    \tvar delimiterIndex = selectedFromTime.indexOf(delimiter);\r\n    \tvar hrsStr = \"\";\r\n    \tvar hrs = 0;\r\n    \tvar minsStr = \"\";\r\n    \tvar mins = 0;\r\n    \tif(delimiterIndex > 0){\r\n    \t\thrsStr = selectedFromTime.substring(0,delimiterIndex);\r\n    \t\tminsStr = selectedFromTime.substring(delimiterIndex+1,selectedFromTime.length);\r\n    \t\ttry{\r\n    \t\t\thrs = parseInt(hrsStr);\t\r\n    \t\t}catch(e){\r\n    \t\t\thrs = 0;\r\n    \t\t}\r\n    \t\ttry{\r\n    \t\t\tmins = parseInt(minsStr);\r\n    \t\t}catch(e){\r\n    \t\t\tmins = 0;\r\n    \t\t}\r\n    \t}\r\n    \t// set the hours, minutes and the seconds\r\n    \t// seconds will be set to 0 now\r\n    \tpreferredApptDate.setHours(hrs);\r\n    \tpreferredApptDate.setMinutes(mins);\r\n    \tpreferredApptDate.setSeconds(0);\r\n    \t\r\n    \t// validate the appointment start time with current date only\r\n    \t// when the start time is selected properly by user\r\n    \tif((preferredApptDate < currentDate) && !selectedTimeIsInvalid){\r\n    \t\tvalidationMessage += \"Appointment start time cannot be less than current time. \\n\";\r\n    \t}\r\n    \t\r\n    \t// validate the appointment start time with appointment end time only\r\n    \t// when the start time and end time is selected properly by user\t\r\n    \tif((selectedFromTimeIndex > selectedToTimeIndex) && !selectedTimeIsInvalid){\r\n    \t\tvalidationMessage += \"Appointment start time cannot be greater than or equal to end time. \\n\";\r\n    \t}\r\n    \t\r\n    \t// speciality and facility validation\r\n    \t// first speciality\r\n    \tvar hiddenSpecialityComp = document.getElementById(\"Speciality\");\r\n    \tvar selectedSpeciality=\"\";\r\n    \tif(hiddenSpecialityComp){\r\n    \t\tselectedSpeciality = hiddenSpecialityComp.value;\r\n    \t\tselectedSpeciality = trimText(selectedSpeciality);\r\n    \t}\r\n    \tif(selectedSpeciality.length == 0){\r\n    \t\tvalidationMessage += \"Speciality is not selected. \\n\";\r\n    \t}\r\n    \t\r\n    \t// validate selected facility\r\n    \tvar selectedFacility = \"\";\r\n    \tvar facilityComp = document.getElementById(\"Facility\");\r\n    \tif(facilityComp){\r\n    \t\tselectedFacility = facilityComp.value;\r\n    \t\tselectedFacility = trimText(selectedFacility);\r\n    \t}\r\n    \t\r\n    \tif(selectedFacility.length == 0){\r\n    \t\tvalidationMessage += \"Facility is not selected. \\n\";\r\n    \t}\r\n    \t\r\n    \tif(validationMessage.length > 0){\r\n    \t\talert(validationMessage);\r\n    \t\treturn false;\r\n    \t}\r\n    \t \r\n    \treturn true;\r\n     }\r\n\r\n     function trimText(textVal){\r\n    \t var l=0; var r=textVal.length -1;\r\n    \t while(l < textVal.length && textVal[l] == \' \'){\r\n    \t\t  l++;\r\n    \t }\r\n    \t\t\r\n    \t while(r > l && textVal[r] == \' \'){\r\n    \t\tr-=1;\r\n    \t }\r\n    \t textVal = textVal.substring(l, r+1);\r\n    \t \r\n    \t return textVal;\r\n     }\r\n     \r\n     \r\n </script>\r\n\r\n\r\n</head>\r\n<body>\r\n\r\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\r\n\r\n<div id=\"wrapper\"  style=\"background-color: #ffffff;\">\r\n<div class=\"fixedheader\">\t\r\n<header id=\"header\">\r\n    \t<div id=\"headerinfo\">\r\n        \t<div class=\"row\">\r\n        \t\t<div id=\"headervisitinfo\">\r\n                \tWelcome back! Your last visit was on Wed, Dec 5, 2012 12:47:08 PM \r\n                </div>    \r\n               <div id=\"headerloginas\">\r\n                \t Welcome, ";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 =", ID:";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\r\n               </div>\r\n               <div id=\"headerlogout\">\r\n\t\t\t\t\t<div><a href=\"../servlet/LogoutServlet\"  class=\"logout\">\r\n                    Logout</a></div>\r\n              </div>\r\n          </div>\r\n    </div>\r\n</header>\r\n   \r\n    <!-- #header-->\r\n   \r\n    <!-- #logo And Menu -->\r\n\r\n<div id=\"logomenu\">\r\n\t<div class=\"row\">\r\n    \t<div id=\"logo\">\r\n        <img src=\"../images/logo.png\"> \r\n        </div>\r\n        \r\n        <div id=\"Menubox\">\r\n\t\t\t<ul class=\"menu\">\r\n\t\t\t\t<li><a href=\"./Contact.jsp\"><div class=\"menuicons\"><img src=\"../images/Contact.png\"/></div>Contact</a></li>\r\n                <li><a href=\"./result/DetailedResult.jsp\"><div class=\"menuicons\"><img src=\"../images/Results.png\"/></div>My Results</a></li>\r\n                <li><a href=\"./schedule/UpcomingAppointments.jsp\"><div class=\"menuicons\"><img src=\"../images/Appointment.png\"/></div>My Appointments</a></li>\r\n                <li class=\"menuselect\"><div class=\"menuicons\"><img src=\"../images/Home.png\"/></div>Home</li>\r\n            </ul>\r\n        </div>\r\n        \r\n    </div>\r\n</div>\r\n</div>\r\n   <!-- #logo And Menu -->\r\n   \r\n<div class=\"line\"></div>\r\n\r\n\t<div id=\"content\"  style=\"background-color: #ffffff;\">\r\n     <!-- #Patient Banner-->\r\n\t\t<div id=\"PatientBanner\">\r\n        \t<div class=\"row\">\r\n            \t<div id=\"Patientphoto\">\r\n           \t    <img src=\"../images/sPatientProfile.png\"> \r\n                </div>\r\n                <div id=\"PatientProfile\">\r\n                \t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\r\n                \t<p> <span class=\"contentfont\">Welcome,</span>\r\n                    <span class=\"contencap\">";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</span></p>\r\n\t\t\t\t\t<p> <span class=\"contenbold\">Patient  ID :</span>\r\n                    <span class=\"contentfont\">";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 =", </span>\r\n                     <span class=\"contenbold\">NRIC :</span>\r\n                    <span class=\"contentfont\">";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</span></p>\r\n                    ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\r\n                    <p> <span class=\"loginerror\">";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\r\n                </div>\r\n            </div> \r\n            \r\n            \r\n        </div>  \r\n        \r\n       <!-- #Patient Banner-->\r\n\t   <!-- #Content Area-->\r\n     \t<div id=\"contentbg\" style=\"height:5px;\">\r\n     \t</div>\r\n\t <div id=\"contentArea\" style=\"background-color: #ffffff;\">\r\n      \r\n      <div id=\"contentArearow\">\r\n       \t<div class=\"cellindex searchindex\">\r\n       \t\t<form id=\"bookappointmentform\" method=\"POST\">\r\n       \t\t<div id=\"BooknewAppsearchindex\">\r\n\t\t\t\t<div class=\"BookAppTitlehomepg\">\r\n\t\t\t\t\tBook an appointment\r\n\t\t\t\t</div>\r\n       \t\t\t<div class=\"bookcontent\">\r\n       \t\t\t\t<div id=\"Apptime\">\r\n       \t\t\t\t\t\r\n\t\t\t           <!-- calendar component -->\r\n\t\t\t           <div id=\"special-days\">\r\n\t\t\t               <div id=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\"\r\n\t\t\t               name=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" \r\n\t\t\t               style=\"width: 262px;\"></div>\r\n\t\t\t           </div>\r\n\t\t\t           <!-- preferred time component -->\r\n            \t\t\t<div class=\"ApptitleReschedule\"  style=\"margin-bottom:2px;\">Preferred time</div>\r\n\t\t\t\t\t\t<select class=\"textboxtimeReschedule\" id=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\"\r\n\t\t\t\t\t\tname=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" \r\n\t\t\t\t\t\tstyle=\"width: 110px;\">\r\n\t\t\t\t\t\t\t<option value=\"\">Select time</option>\r\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\r\n\t\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</option>\r\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\r\n\t\t\t\t\t\t</select>\r\n\t\t\t\t\t\t<span >to</span>\r\n\t\t\t\t\t\t<select class=\"textboxtimeReschedule\" id=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\r\n\t\t\t\t\t\t</select>\r\n\t\t\t\t\t\t<div></div>\r\n\t\t\t\t\t\t<span class=\"ApptitleReschedule\" style=\"margin-right: 75px;\">Speciality</span>\r\n\t\t\t\t\t\t<span class=\"ApptitleReschedule\">Facility</span>\r\n\t\t\t\t\t\t<!--  just for giving line -->\r\n\t\t\t\t\t\t<div></div>\r\n\t\t\t\t\t\t<select class=\"textbox\" id=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" \r\n\t\t\t\t\t\tname=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" style=\"width: 125px;margin-right: 5px;\">\r\n\t\t\t\t\t\t\t<option value=\"\">---All---</option>\r\n\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\r\n\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t</select>\r\n\t\t\t\t\t\t<!-- facility comp  -->\r\n       \t\t\t\t \r\n       \t\t\t\t   <select class=\"textbox\" id=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" name=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" style=\"width: 125px;\">\r\n       \t\t\t\t   \t<option value=\"\" selected=\"selected\">----All----</option>\r\n       \t\t\t\t   \t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\t\t\t\r\n\t\t\t\t\t\t  \t<option value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</option>\t\t\r\n\t\t\t\t\t    ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\r\n       \t\t\t\t   \t\r\n       \t\t\t\t   </select> \r\n\t\t\t\t\t\t<input type=\"hidden\" id=\"hdnPreferredDate\" name=\"hdnPreferredDate\" value=\"\">\r\n\t\t\t\t\t\t<input type=\"hidden\" id=\"hdnSelectedSpecialtyDesc\" name=\"hdnSelectedSpecialtyDesc\" value=\"\">\r\n\t\t\t\t\t\t<input type=\"hidden\" id=\"hdnSelectedFacilityDesc\" name=\"hdnSelectedFacilityDesc\" value=\"\">\r\n\t\t\t\t\t</div>\r\n\t\t\t\t</div>\r\n\t\t\t\t<div class=\"centeralign\">\r\n\t\t\t\t\t<span><a href=\"#\" onclick=\"showAppointment()\" class=\"PPbtn\">Book an appointment</a></span>\r\n\t\t\t\t</div>\r\n\t\t\t</div>\r\n\t\t\t</form>\r\n\t\t</div>\r\n        \r\n        <div class=\"cellindex appindex\">\r\n\t\t\t<div class=\"tableindex\">\r\n\t\t\t\t<div class=\"row\">\r\n\t\t\t\t\t<div class=\"cellindex dividerindex\">\r\n\t\t\t\t\t</div>\r\n\t\t\t\t\t<div class=\"cellindex Appdivs\">\r\n\t\t\t\t\t\t<div id=\"UpcomingAppindex\">\r\n\t\t\t\t\t\t\t<div class=\"appTitlehomepg\">            Upcoming appointments            </div>\r\n\t\t\t\t\t\t\t<div id=\"HomepageBox\"  style=\"height:249px\">\r\n\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\r\n        \t \t\t\t<!-- <span style=\"margin-left: 50px; color:#ff0000;font-size:14pt;-webkit-transform: rotate(-30deg); -moz-transform: rotate(-30deg);z-index: 2;position: absolute;top:360px;\"> -->\r\n        \t \t\t\t<p>\r\n        \t \t\t\t<span style=\"margin-left: 50px; color:#ff0000;font-size:12pt;\">\r\n\t\t\t             ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\r\n             \t\t\t </span>\r\n             \t\t\t </p>\r\n\t\t\t\t\t\t ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\r\n\t\t\t\t\t\t\t\t<!-- Stripbox starts here-->\r\n\t\t\t\t\t\t\t\t<div id=\"stripbox\">\r\n\t\t\t\t\t\t\t\t\t<div id=\"row\">\r\n\t\t\t\t\t\t\t\t\t<!-- Stripicon-->\r\n\t\t\t\t\t\t\t\t\t\t<div id=\"StripSpaceA\">\r\n\t\t\t\t\t\t\t\t\t\t\t<div id=\"StripIcon\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"StripIconHeader\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\r\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\r\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"Stripday\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\r\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t<!-- Stripcontent-->\r\n\t\t\t\t\t\t\t\t\t\t<div id=\"StripSpaceB\">\r\n\t\t\t\t\t\t\t\t\t\t\t<p><span class=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</span></p>\r\n\t\t\t\t\t\t\t\t\t\t\t<p><span class=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =" - ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</span></p> \r\n\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t<!-- Stripbox ends here-->   \r\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="    \r\n\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\r\n\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t<div class=\"centeralign\">\r\n\t\t\t\t\t\t\t\t<span><a href=\"./schedule/UpcomingAppointments.jsp\"  class=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" style=\"margin-top:36px;\">Show all appointments</a></span>\r\n\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t</div>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t\t<div class=\"cellindex dividerindex\">\r\n\t\t\t\t\t\t<!-- page divider -->\r\n\t\t\t\t\t\t<div id=\"dividercell\"></div>\r\n\t\t\t\t\t\t<!-- page divider -->\r\n\t\t\t\t\t</div>\r\n\t\t\t\t\t\r\n\t\t\t\t\t ";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 =" \r\n\t\t\t\t\t\r\n\t\t\t\t\t\r\n\t\t\t\t\t<div class=\"cellindex Appdivs\"  >\r\n\t\t\t\t\t\t<div id=\"UpcomingAppindex\">\r\n\t\t\t\t\t\t\t<div class=\"appTitlehomepg\">            Recently published results            </div>\r\n\t\t\t\t\t\t\t<div id=\"HomepageBox\" style=\"height:249px\">\r\n\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\r\n\t\t\t           \t\t <!-- <span style=\"margin-left: 50px; color:#ff0000;font-size:14pt;-webkit-transform: rotate(-30deg); -moz-transform: rotate(-30deg);z-index: 2;position: absolute;top:360px;\"> -->\r\n\t\t\t           \t\t <p>\r\n\t\t\t           \t\t <span style=\"margin-left: 50px; color:#ff0000;font-size:12pt;\">\r\n\t\t\t                ";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\r\n\t\t\t                 </span>\r\n\t\t\t                 </p>\r\n\t\t\t                 ";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\r\n\t\t\t\t\t\t\t\t<!-- Stripbox-->\r\n\t\t\t\t\t\t\t\t<div id=\"stripbox\">\r\n\t\t\t\t\t\t\t\t\t<div class=\"row\">\r\n\t\t\t\t\t\t\t\t\t<!-- Stripicon-->\r\n\t\t\t\t\t\t\t\t\t\t<div id=\"StripSpaceA\">\r\n\t\t\t\t\t\t\t\t\t\t\t<div id=\"Resulticon\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"../images/";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\"/>\r\n\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t<!-- Stripcontent-->\r\n\t\t\t\t\t\t\t\t\t\t<div id=\"StripSpaceB\">\r\n\t\t\t\t\t\t\t\t\t\t\t<p><span class=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</span>\r\n\t\t\t\t\t\t\t\t\t\t\t<!--  <span class=\"contenbold\">Nov 10, 2012 at 11:26pm</span>--> \r\n\t\t\t\t\t\t\t\t\t\t\t\t<img class=\"printPDF\" src=\"../images/PDF.png\" width=\"16\" height=\"16\"> \r\n\t\t\t\t\t\t\t\t\t\t\t\t<img class=\"printPDF\"src=\"../images/print.png\" width=\"16\" height=\"16\">\r\n\t\t\t\t\t\t\t\t\t\t\t</p>\r\n\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t<!-- Stripbox-->  \r\n\t\t\t\t \t\t\t\t ";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\r\n\t\t\t\t \t\t\t\t\r\n\t\t\t\t \t\t\t\t\r\n\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\r\n\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t<div class=\"centeralign\">\r\n\t\t\t\t\t\t\t\t<span><a href=\"./result/DetailedResult.jsp\"  class=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\" style=\"margin-top:36px;\">Show all results</a></span>\r\n\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t</div>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t</div>\r\n\t\t\t</div>\r\n\t\t\r\n\t\t</div>\r\n\t</div> \r\n\t</div>\r\n\t\t\t\r\n\t\t\r\n       <!-- #Content Area-->\r\n        \r\n\t</div>\r\n\t\r\n\t\r\n    <!-- #content-->\r\n\r\n\t<div class=\"Footerbgindex\">\r\n\t\t\r\n\t\r\n\t\t<div id=\"footeradd\" >\r\n\t\t\t<p class=\"FooterTitle\"> Get in Touch! </p>\r\n\t\t\t<div class=\"FooterContent\">\r\n\t\t\t\t<p class=\"Footeradd\"> Envato Marketplace, Melbourne St, Sydney</p>\r\n\t\t\t\r\n\t\t\t</div>\r\n\t\t\t\r\n        </div>\r\n\t\t<div id=\"poweredby\">\r\n\t\t\t<p class=\"poweredby\">Powered by <img src=\"../images/csc.png\" width=\"25\" height=\"14\"></p>\r\n        </div>\r\n\t\t\r\n\t\r\n\t</div>\r\n\t\r\n</div>\r\n<!-- #wrapper -->\r\n\r\n\r\n\r\n</body>\r\n</html>\r\n";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String useWebService = "";
	useWebService = (String) session
			.getAttribute(PortalConstants.USEWEBSERVICE_SESSION_KEY);
	/* useWebService = request.getParameter("useWebService");
	if (useWebService == null || useWebService.trim().equals("")) {
		useWebService = (String) getServletConfig().getServletContext()
				.getAttribute("useWebService");
		if (useWebService == null || useWebService.trim().equals("")) {
			useWebService = "N";
		}
	} */

	String patientId = "";
	patientId = (String) session
			.getAttribute(PortalConstants.PATIENTID_REQUEST_PARAM_KEY);
	/* patientId = request.getParameter("patientId");
	if (patientId == null) {
		patientId = (String) getServletConfig().getServletContext()
				.getAttribute("patientId");
		if (patientId == null) {
			patientId = "";
		}
	} */

	//HomePageSvcImpl homePageSvcImpl = new HomePageSvcImpl();
	PatientDetailsRequest patientDetailsRequest = new PatientDetailsRequest();
	patientDetailsRequest.setPatientId(patientId);
	patientDetailsRequest
			.setPortalUserName(PortalConstants.PORTALUSER_REQUEST_PARAM_VALUE);

	//homePageSvcImpl.registerService(patientDetailsRequest);

	ServiceInvoker patientDetailsServiceInvoker = new PatientDetailsServiceInvoker();
	patientDetailsServiceInvoker.registerService(patientDetailsRequest);
	PatientDetailsResponse patientDetailsResponse = (PatientDetailsResponse) patientDetailsServiceInvoker
			.getDataThroughWebService(patientDetailsRequest);

	String patientName = null;
	String nationalId = null;
	// inspect the patient details response for success and then set data
	if(patientDetailsResponse.isSuccessful()){
		patientName = patientDetailsResponse.getPatientDisplayName();
		nationalId = patientDetailsResponse.getNationalId();
		if(nationalId == null){
			nationalId = "";
		}
		
		// store the patient name in the session
		session.setAttribute(PortalConstants.PATIENTNAME_SESSION_KEY,
				patientName);
	}
	
	HospitalDetailsRequest hospitalDetailsRequest = new HospitalDetailsRequest();
	hospitalDetailsRequest.setPatientId(patientId);
	hospitalDetailsRequest
			.setPortalUserName(PortalConstants.PORTALUSER_REQUEST_PARAM_VALUE);
	//hospitalDetailsRequest.setFacilityId("HS");
	HospitalDetailsResponse hospitalDetailsResponse = null;
	//hospitalDetailsResponse = homePageSvcImpl.getHospitalDetails(hospitalDetailsRequest);
	/* ServiceInvoker hospitalDetailsServiceInvoker = new HospitalDetailsServiceInvoker();
	BaseResponse hospitalResponse = hospitalDetailsServiceInvoker
			.getDataThroughWebService(hospitalDetailsRequest);  */

	AppointmentDetailsRequest appointmentDetailsRequest = new AppointmentDetailsRequest();
	appointmentDetailsRequest.setPatientId(patientId);
	appointmentDetailsRequest.setRecordCount(CommonConstants.HOMEPAGE_APPOINTMENTLIST_RECORDCOUNT);
	appointmentDetailsRequest.setPortalUserName(PortalConstants.PORTALUSER_REQUEST_PARAM_VALUE);
	// initialize the service impl and register it
	/* AppointmentSvcImpl appointSvc = new AppointmentSvcImpl(); */
	/* appointSvc.registerService(appointmentDetailsRequest); */
	// appointments response object
	AppointmentDetailsResponse appointmentDetailsResponse = null;
	AppointmentDetailsServiceInvoker apptDetailsServiceInvoker = new AppointmentDetailsServiceInvoker();

	if ("N".equalsIgnoreCase(useWebService)) {
		/* appointmentDetailsResponse = appointSvc
				.getAppointmentDetails(appointmentDetailsRequest); */
		appointmentDetailsResponse = apptDetailsServiceInvoker.
								getDataThroughService(appointmentDetailsRequest);
	} else if ("Y".equalsIgnoreCase(useWebService)) {
		// need to call the service as a web service
		/* appointmentDetailsResponse = AppointmentDetailsHelper
				.getAppointmentDetail(appointmentDetailsRequest); */
		apptDetailsServiceInvoker.registerService(appointmentDetailsRequest);		
		appointmentDetailsResponse = (AppointmentDetailsResponse)apptDetailsServiceInvoker.
				getDataThroughWebService(appointmentDetailsRequest);		
	}
	
	String originalURL = request.getRequestURL().toString();
	
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
   	//facilityListRequest.setRecordCount(10);

   	/* FacilityListSvcImpl facilityListSvcImpl = new FacilityListSvcImpl(); */
   	FacilityListServiceInvoker facilityListServiceInvoker = new FacilityListServiceInvoker();
   	/* facilityListSvcImpl.registerService(facilityListRequest); */
   	
   	/* ServiceInvoker facilityListServiceInvoker = new FacilityListServiceInvoker();
   	FacilityListResponse facilityListResponse = (FacilityListResponse) facilityListServiceInvoker
   			.getDataThroughWebService(facilityListRequest); */
   	/* FacilityListResponse facilityListResponse = (FacilityListResponse) facilityListSvcImpl.getFacilityList(facilityListRequest); */
   	
   	FacilityListResponse facilityListResponse = facilityListServiceInvoker.
   							getDataThroughService(facilityListRequest);
	
	

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(patientName));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(patientId ));
            _bw.write(_wl_block4Bytes, _wl_block4);

                	// there is a need to check for patient details
                	// and then set the data
                	if(patientDetailsResponse.isSuccessful()){
                	
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(patientName));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(nationalId));
            _bw.write(_wl_block8Bytes, _wl_block8);

                	}else{
                		String errorMsg = patientDetailsResponse.getErrorMessage();
                	
                    
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(errorMsg ));
            _bw.write(_wl_block8Bytes, _wl_block8);

                	}
                    
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(CreateAppointmentConstants.APPT_PREFERREDDATE_PARAMETER_KEY));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(CreateAppointmentConstants.APPT_PREFERREDDATE_PARAMETER_KEY));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(CreateAppointmentConstants.APPT_PREFERREDFROMTIME_PARAMETER_KEY));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(CreateAppointmentConstants.APPT_PREFERREDFROMTIME_PARAMETER_KEY));
            _bw.write(_wl_block14Bytes, _wl_block14);

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
							
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(apptDataValue ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(apptDisplayValue ));
            _bw.write(_wl_block17Bytes, _wl_block17);

								}
							
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(CreateAppointmentConstants.APPT_PREFERREDTOTIME_PARAMETER_KEY));
            _bw.write(_wl_block13Bytes, _wl_block13);
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
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(apptDisplayValue ));
            _bw.write(_wl_block17Bytes, _wl_block17);

								}
							
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(CreateAppointmentConstants.SPECIALITY_PARAMETER_KEY));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(CreateAppointmentConstants.SPECIALITY_PARAMETER_KEY));
            _bw.write(_wl_block21Bytes, _wl_block21);

							// code to show the specialities 
							if(sresponse.isSuccessful()){
								List<SpecialityModel> specialityList = sresponse.getSpecialityList();
								String specialityCode;
								String specialityDesc;
								if (specialityList != null) {
									for (SpecialityModel s : specialityList) {
										specialityCode = s.getSpecialityCode();
										specialityDesc = s.getShortDesc();
										String selected = "";
									
							
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(specialityCode));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(specialityDesc));
            _bw.write(_wl_block17Bytes, _wl_block17);

									}
								}
							}
							
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(CreateAppointmentConstants.APPT_PREFERREDFACILITY_PARAMETER_KEY ));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(CreateAppointmentConstants.APPT_PREFERREDFACILITY_PARAMETER_KEY ));
            _bw.write(_wl_block24Bytes, _wl_block24);

						  	List<Facility> facilityList = null;
						  	if (facilityListResponse.isSuccessful()) {
						  		facilityList = facilityListResponse.getFacilityList();
						  		for (Facility facility : facilityList) {
						  
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(facility.getFacilityId()));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(facility.getFacilityName()));
            _bw.write(_wl_block26Bytes, _wl_block26);

						  		}
						  	}
       				   	
            _bw.write(_wl_block27Bytes, _wl_block27);

        	        		String errorMessage = null;//errorInfo.getErrorMessage();
        	        		if (!appointmentDetailsResponse.isSuccessful()) {
        	        			errorMessage = appointmentDetailsResponse.getErrorMessage();	
        	        	
            _bw.write(_wl_block28Bytes, _wl_block28);

			             	out.println(errorMessage);
			             
            _bw.write(_wl_block29Bytes, _wl_block29);

              				} else {
			              		List<AppointmentDetails> appointmentDetailsList = appointmentDetailsResponse
			              				.getAppointmentDetailsList();
			              		String apptYearAndMonth = "";
			              		int apptDateInt = 0;
			              		String apptDay = "";
			              		String practitioner = "";
			              		String speciality = "";
			              		String apptStartTime = "";
			              		String apptEndTime = "";
			              		
			              		int counter = 0;
			              		String dateStyle = "StripDate";
			              		String practStyle = "AppointmentNewDoctor";
			              		String specialityStyle = "AppointmentnewSPL";
			              		String contentStyle = "contenbold";
			              		for(AppointmentDetails appointmentDetails : appointmentDetailsList){
			              			apptYearAndMonth = appointmentDetails.getAppointmentMonthAndYear();
			              			apptDateInt = appointmentDetails.getAppointmentDateAsInt();
			              			apptDay = appointmentDetails.getAppointmentDay();
			              			practitioner = appointmentDetails.getPractitioner();
			              			speciality = appointmentDetails.getApptSpeciality();
			              			apptStartTime = appointmentDetails.getApptStartTimeAsString();
			              			apptEndTime = appointmentDetails.getApptEndTimeAsString();
							
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(apptYearAndMonth ));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(dateStyle));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(apptDateInt ));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(apptDay ));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(practStyle));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(practitioner ));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(specialityStyle));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(speciality ));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(contentStyle));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(apptStartTime ));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(apptEndTime ));
            _bw.write(_wl_block37Bytes, _wl_block37);

									if(counter == 0){
										dateStyle = "StripDatenormal";
										practStyle = "AppointmentNewDoctorNormal";
										specialityStyle = "AppointmentnewSPLNormal";
										contentStyle = "contentnormal";
									}
									counter++;
							
				              		}// end of for loop
				            	} // end of else loop
				            
            _bw.write(_wl_block38Bytes, _wl_block38);

							String btnStyle="PPbtn hmepgbtn";
							
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(btnStyle));
            _bw.write(_wl_block40Bytes, _wl_block40);

                         	TestDetailsRequest testDetailsRequest = new TestDetailsRequest();
                         	testDetailsRequest.setPatientId(patientId);
              				testDetailsRequest.setRecordCount(CommonConstants.HOMEPAGE_TESTRESULTLIST_RECORDCOUNT);
							testDetailsRequest.setPortalUserName(PortalConstants.PORTALUSER_REQUEST_PARAM_VALUE);
                         	/* TestDetailsSvcImpl testDetailSvc = new TestDetailsSvcImpl(); */
                         	/* testDetailSvc.registerService(testDetailsRequest); */
							TestDetailsServiceInvoker testDetailsServiceInvoker = new TestDetailsServiceInvoker();
                         	TestDetailsResponse testDetailsResponse = null;

                         	if ("N".equalsIgnoreCase(useWebService)) {
                         		/* testDetailsResponse = testDetailSvc
                         				.getTestDetails(testDetailsRequest); */
                         		testDetailsResponse = testDetailsServiceInvoker.
                         					getDataThroughService(testDetailsRequest);		
                         	} else if ("Y".equalsIgnoreCase(useWebService)) {
                         		testDetailsServiceInvoker.registerService(testDetailsRequest);
                         		// need to call the service as a web service
                         		testDetailsResponse = (TestDetailsResponse) testDetailsServiceInvoker
                         				.getDataThroughWebService(testDetailsRequest);
                         	}
                         
            _bw.write(_wl_block41Bytes, _wl_block41);

        	        		if (!testDetailsResponse.isSuccessful()) {
        	        			errorMessage = testDetailsResponse.getErrorMessage();	
			        	     
            _bw.write(_wl_block42Bytes, _wl_block42);

			                	out.println(errorMessage);
			                
            _bw.write(_wl_block43Bytes, _wl_block43);

			                 } else {
		                 		List<TestDetails> testDetailsList = testDetailsResponse.getTestDetailsList();
		                		String order = "";
		                		String orderNumber = "";
		                		String practName = "";
		                		String orderDateString = "";
		                		String imageStyle = "";
		                		
		                		int counter = 0;
		                		String orderCatalogueStyle = "AppointmentNewDoctor";
		                		String practStyle = "AppointmentnewSPL";
		                		String contentStyle = "contenbold";
			                 	String testResultType = "";
			                 	// iterate through the test details and show it
		                		for(TestDetails testDetails : testDetailsList){
		                			order = testDetails.getOrder();
		                			orderNumber = testDetails.getOrderNo();
		                			practName = testDetails.getPractName();
		                			orderDateString = testDetails.getOrderDateString();
		                			
		                			imageStyle = "radiology.png";
			                 			testResultType = testDetails.getResultType();
			                 			if ((ResultConstants.DETAILEDRESULTS_ORDERCATEGORY_LAB_MEDIUM_KEY
			                 					.equalsIgnoreCase(testResultType))
			                 					|| (ResultConstants.DETAILEDRESULTS_ORDERCATEGORY_LAB_ALT_MEDIUM_KEY
			                 							.equalsIgnoreCase(testResultType))) {
			                 				imageStyle = "lab.png";
			                 			}
			                 
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(imageStyle));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(orderCatalogueStyle));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(order ));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(practStyle));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(practName ));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(contentStyle));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(orderDateString ));
            _bw.write(_wl_block46Bytes, _wl_block46);

				 				 		if(counter == 0){
				 				 			orderCatalogueStyle = "AppointmentNewDoctorNormal";
				 				 			practStyle = "AppointmentnewSPLNormal";
				 				 			contentStyle = "contentnormal";
				 				 		}
				 				 		counter++;
				 				 
							    		} // end of for loop
					                 } // end of else loop
					             
            _bw.write(_wl_block47Bytes, _wl_block47);

							 btnStyle = "PPbtn hmepgbtn";
							
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(btnStyle));
            _bw.write(_wl_block49Bytes, _wl_block49);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
