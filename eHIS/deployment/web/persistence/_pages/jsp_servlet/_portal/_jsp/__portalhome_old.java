package jsp_servlet._portal._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import portalrefimpl.result.ResultConstants;
import portalrefimpl.common.CommonConstants;
import portalrefimpl.result.viewtestresult.response.TestDetails;
import portalrefimpl.schedule.viewappointment.response.AppointmentDetails;
import java.util.List;
import portalrefimpl.result.viewtestresult.svc.TestDetailsServiceInvoker;
import portalrefimpl.result.viewtestresult.response.TestDetailsResponse;
import portalrefimpl.result.viewtestresult.svc.TestDetailsSvcImpl;
import portalrefimpl.result.viewtestresult.request.TestDetailsRequest;
import portalrefimpl.common.response.ErrorInfo;
import portalrefimpl.schedule.viewappointment.svc.AppointmentDetailsHelper;
import portalrefimpl.schedule.viewappointment.response.AppointmentDetailsResponse;
import portalrefimpl.schedule.viewappointment.svc.AppointmentSvcImpl;
import portalrefimpl.schedule.viewappointment.request.AppointmentDetailsRequest;
import portalrefimpl.homepage.response.PatientDetailsResponse;
import portalrefimpl.result.detailedresult.svc.DetailedResultsSvcImpl;
import portalrefimpl.result.detailedresult.response.DetailedResultsResponse;
import portalrefimpl.PortalHelper;
import java.util.Date;
import portalrefimpl.result.detailedresult.request.DetailedResultsRequest;
import portalrefimpl.result.detailedresult.svc.DetailedResultsServiceInvoker;
import portalrefimpl.homepage.svc.HospitalDetailsServiceInvoker;
import portalrefimpl.homepage.request.HospitalDetailsRequest;
import portalrefimpl.common.response.BaseResponse;
import portalrefimpl.common.serviceinvoker.ServiceInvoker;
import portalrefimpl.homepage.svc.PatientDetailsServiceInvoker;
import portalrefimpl.PortalConstants;
import portalrefimpl.homepage.request.PatientDetailsRequest;
import portalrefimpl.homepage.svc.HomePageSvcImpl;

public final class __portalhome_old extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/portal/jsp/PortalHome_old.jsp", 1669269355891L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n<html>\r\n<head>\r\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n<title>::: Patient Portal - Home :::</title>\r\n<meta name=\"keywords\" content=\"\" />\r\n<meta name=\"description\" content=\"\" />\r\n<link rel=\"stylesheet\" href=\"../css/style.css\" type=\"text/css\"/>\r\n<link rel=\"stylesheet\" href=\"../css/style_ie.css\" type=\"text/css\"/>\r\n<link href=\"../css/examples-offline.css\" rel=\"stylesheet\">\r\n<link href=\"../css/kendo.common.min.css\" rel=\"stylesheet\">\r\n<link href=\"../css/kendo.default.min.css\" rel=\"stylesheet\">\r\n\r\n<script src=\"../js/jquery.min.js\"></script>\r\n<script src=\"../js/kendo.web.min.js\"></script>\r\n<script src=\"../js/console.js\"></script>\r\n\r\n<style scoped>\r\n    #special-days {\r\n        height: 300px;\r\n        width: 300px;\r\n        margin: 10px auto;\r\n        padding: 12px 0 12px 11px;\r\n    }\r\n\r\n    #calendar {\r\n        border-radius: 3px 3px 3px 3px;\r\n        border-style: solid;\r\n        border-width: 1px;\r\n    }\r\n\r\n    .k-header {\r\n        border-radius: 3px 3px 0 0;\r\n    }\r\n\r\n    #calendar .k-content {\r\n        height: 208px;\r\n        width:260px;\r\n    }\r\n\r\n    .exhibition {\r\n        /* background: transparent url(../../content/web/calendar/exhibition.png) no-repeat 0 50%; */\r\n        background-color : green;\r\n        display: inline-block;\r\n        width: 100%;\r\n        height: 10px;\r\n        vertical-align: middle;\r\n        margin-right: 3px;\r\n    }\r\n\r\n    .party {\r\n       /*  background: transparent url(../../content/web/calendar/party.png) no-repeat 0 50%; */\r\n       background-color : blue;\r\n        display: inline-block;\r\n        width: 100%;\r\n        height: 10px;\r\n        vertical-align: middle;\r\n        margin-right: 3px;\r\n    }\r\n\r\n    .cocktail {\r\n        /* background: transparent url(../../content/web/calendar/cocktail.png) no-repeat 0 50%; */\r\n        background-color : red;\r\n        display: inline-block;\r\n        width: 100%;\r\n        height: 10px;\r\n        vertical-align: middle;\r\n        margin-right: 3px;\r\n    }\r\n    \r\n     .normal {\r\n        /* background: transparent url(../../content/web/calendar/exhibition.png) no-repeat 0 50%; */\r\n        background-color : transparent;\r\n        display: inline-block;\r\n        width: 100%;\r\n        height: 10px;\r\n        vertical-align: middle;\r\n        margin-right: 3px;\r\n    }\r\n\r\n</style>\r\n\r\n <script>\r\n     $(document).ready(function() {\r\n         var today = new Date();\r\n\r\n         $(\"#calendar\").kendoCalendar({\r\n             value: today,\r\n             footer: \"Today - #=kendo.toString(data, \'d\') #\"\r\n         });\r\n     });\r\n </script>\r\n\r\n\r\n</head>\r\n<body>\r\n\r\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\r\n\r\n<div id=\"wrapper\">\r\n<div class=\"fixedheader\">\t\r\n<header id=\"header\">\r\n    \t<div id=\"headerinfo\">\r\n        \t<div class=\"row\">\r\n        \t\t<div id=\"headervisitinfo\">\r\n                \tWelcome back! Your last visit was on Wed, Dec 5, 2012 12:47:08 PM \r\n                </div>    \r\n               <div id=\"headerloginas\">\r\n                \t Welcome, ";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 =",\r\n               </div>\r\n               <div id=\"headerlogout\">\r\n\t\t\t\t\t<div><a href=\"../servlet/LogoutServlet\"  class=\"logout\">\r\n                    Logout</a></div>\r\n              </div>\r\n          </div>\r\n    </div>\r\n</header>\r\n   \r\n    <!-- #header-->\r\n   \r\n    <!-- #logo And Menu -->\r\n\r\n<div id=\"logomenu\">\r\n\t<div class=\"row\">\r\n    \t<div id=\"logo\">\r\n        <img src=\"../images/logo.png\"> \r\n        </div>\r\n        \r\n        <div id=\"Menubox\">\r\n\t\t\t<ul class=\"menu\">\r\n                  <li><a href=\"#\">Contact</a></li>\r\n                  <li><a href=\"#\">Faq\'s</a></li>\r\n                  <li><a href=\"#\">Settings</a></li>\r\n                  <li><a href=\"#\">About Us</a></li>\r\n                  <li><a href=\"./result/DetailedResult.jsp\">My Results</a></li>\r\n                  <li><a href=\"#\">My Appointments</a></li>\r\n                  <li class=\"menuselect\">Home</li>\r\n            </ul>\r\n        </div>\r\n        \r\n    </div>\r\n</div>\r\n</div>\r\n   <!-- #logo And Menu -->\r\n   \r\n<div class=\"line\"></div>\r\n\r\n\r\n\t<div id=\"content\">\r\n     <!-- #Patient Banner-->\r\n\t\t<div id=\"PatientBanner\">\r\n        \t<div class=\"row\">\r\n            \t<div id=\"Patientphoto\">\r\n           \t    <img src=\"../images/PatientProfile.png\"> \r\n                </div>\r\n                <div id=\"PatientProfile\">\r\n                \t<p> <span class=\"contentfont\">Welcome,</span>\r\n                    <span class=\"contencap\">";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="</span></p>\r\n\t\t\t\t\t<p> <span class=\"contenbold\">Patient  ID :</span>\r\n                    <span class=\"contentfont\">";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =", </span>\r\n                     <span class=\"contenbold\">NRIC :</span>\r\n                    <span class=\"contentfont\">";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</span></p>\r\n                </div>\r\n            </div> \r\n            \r\n            \r\n        </div>  \r\n        \r\n       <!-- #Patient Banner-->\r\n\t   <!-- #Content Area-->\r\n     \t<div id=\"contentbg\">\r\n     \t</div>\r\n\t <div id=\"contentArea\">\r\n      \r\n      <div id=\"contentArearow\">\r\n       \t<div class=\"cellindex searchindex\">\r\n       \t\t<div id=\"BooknewAppsearchindex\">\r\n\t\t\t\t<div class=\"BookAppTitlehomepg\">\r\n\t\t\t\t\tBook an appointment\r\n\t\t\t\t</div>\r\n       \t\t\t<div class=\"bookcontent\">\r\n       \t\t\t\t<div id=\"Apptime\">\r\n\t\t\t           <div id=\"special-days\">\r\n\t\t\t               <div id=\"calendar\" style=\"width: 260px;\"></div>\r\n\t\t\t           </div>\r\n            \t\t\t<div class=\"ApptitleReschedule\">Preferred time</div>\r\n\t\t\t\t\t\t<select class=\"textboxtimeReschedule\"  >\r\n\t\t\t\t\t\t\t<option>Select time</option>\r\n\t\t\t\t\t\t\t<option>10.30</option>\r\n\t\t\t\t\t\t\t<option>11.30</option>\r\n\t\t\t\t\t\t\t<option>1.30</option>\r\n\t\t\t\t\t\t\t<option>2.30</option>\r\n\t\t\t\t\t\t\t<option>3.30</option>\r\n\t\t\t\t\t\t\t<option>4.30</option>\r\n\t\t\t\t\t\t\t<option>5.30</option>\r\n\t\t\t\t\t\t\t<option>6.30</option>\r\n\t\t\t\t\t\t\t<option>7.30</option>\r\n\t\t\t\t\t\t\t<option>8.30</option>\r\n\t\t\t\t\t\t</select>\r\n\t\t\t\t\t\t<span >to</span>\r\n\t\t\t\t\t\t<select class=\"textboxtimeReschedule\" >\r\n\t\t\t\t\t\t\t<option>Select time</option>\r\n\t\t\t\t\t\t\t<option>10.30</option>\r\n\t\t\t\t\t\t\t<option>11.30</option>\r\n\t\t\t\t\t\t\t<option>1.30</option>\r\n\t\t\t\t\t\t\t<option>2.30</option>\r\n\t\t\t\t\t\t\t<option>3.30</option>\r\n\t\t\t\t\t\t\t<option>4.30</option>\r\n\t\t\t\t\t\t\t<option>5.30</option>\r\n\t\t\t\t\t\t\t<option>6.30</option>\r\n\t\t\t\t\t\t\t<option>7.30</option>\r\n\t\t\t\t\t\t\t<option>8.30</option>\r\n\t\t\t\t\t\t</select>\r\n\t\t\t\t\t\t<div class=\"ApptitleReschedule\">Speciality</div>\r\n\t\t\t\t\t\t<select class=\"textbox\"  >\r\n\t\t\t\t\t\t\t<option>---All---</option>\r\n\t\t\t\t\t\t\t<option>Cardiology</option>\r\n\t\t\t\t\t\t\t<option>Dermatology</option>\r\n\t\t\t\t\t\t\t<option>Endocrinology</option>\r\n\t\t\t\t\t\t\t<option>Gastrology</option>\r\n\t\t\t\t\t\t\t<option>General medicine</option>\r\n\t\t\t\t\t\t\t<option>Gastrology</option>\r\n\t\t\t\t\t\t\t<option>Endocrinology</option>\r\n\t\t\t\t\t\t\t<option>Gynaecology</option>\r\n\t\t\t\t\t\t\t<option>Neurology</option>\r\n\t\t\t\t\t\t\t<option>Orthopedics</option>\r\n\t\t\t\t\t\t</select>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t</div>\r\n\t\t\t\t<div class=\"centeralign\">\r\n\t\t\t\t\t<span><a href=\"#\"  class=\"PPbtn\">Book an appointment</a></span>\r\n\t\t\t\t</div>\r\n\t\t\t</div>\r\n\t\t</div>\r\n        \r\n        <div id=\"divider\"></div>\r\n        \r\n        <div id=\"UpcomingApp\">\r\n        \t<div class=\"Title\">            upcoming appointments            </div>\r\n        \t<div id=\"HomepageBox\">\r\n        \t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\r\n        \t <span style=\"margin-left:5px; margin-top:50px;color:#ff0000;font-size:12px;font-weight:bold;\">\r\n             ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\r\n              </span>\r\n              ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\r\n              \t\r\n              \t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\r\n                \r\n                      <!-- Stripbox-->\r\n                    <div id=\"stripbox\">\r\n                        <div class=\"row\">\r\n                             <!-- Stripicon-->\r\n                            <div id=\"StripSpaceA\">\r\n                                <div id=\"StripIcon\">\r\n                                    <div id=\"StripIconHeader\">\r\n                                        ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\r\n                                    </div>\r\n                                    <div id=\"StripDate\">\r\n                                    ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\r\n                                    </div>\r\n                                     <div id=\"Stripday\">\r\n                                    ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\r\n                                    </div>\r\n                                </div>\r\n                            </div>\r\n                             <!-- Stripcontent-->\r\n                            <div id=\"StripSpaceB\">\r\n                                <p><span class=\"AppointmentNewDoctor\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</span><span class=\"AppointmentnewSPL\">- ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</span><p>\r\n                                <p class=\"contenbold\">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" - ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</p>\r\n                                \r\n                                \r\n                            </div>\r\n                            \r\n                        </div>\r\n                    </div>\r\n                  <!-- Stripbox-->   \r\n                  \r\n               ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="       \r\n                \r\n            ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="    \r\n           </div>     \r\n            <div>\r\n            <span><a href=\"#\"  class=\"PPbtn\">Show All</a></span>\r\n         \t</div>\r\n         </div>\r\n                 \r\n       \t<div id=\"divider\"></div>\r\n                \r\n         ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="       \r\n        <div id=\"Recentresult\">\r\n        \t<div class=\"Title\">            recent results            </div>\r\n        \t<div id=\"HomepageBox\">\r\n        \t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\r\n           \t <span class=\"loginerror\">\r\n                ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\r\n                 </span>\r\n                 ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\r\n        \t\r\n\t\r\n    \t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="    \t\r\n            <!-- Stripbox-->\r\n                <div id=\"stripbox\">\r\n                \t<div class=\"row\">\r\n                    \t <!-- Stripicon-->\r\n                        <div id=\"StripSpaceA\">\r\n                            <div id=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\r\n                           \t\t\r\n                            </div>\r\n                        </div>\r\n                         <!-- Stripcontent-->\r\n                      <div id=\"StripSpaceB\">\r\n                    \t\t<p><span class=\"AppointmentNewDoctor\">";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</span><span class=\"contenbold\"> by ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</span><p>\r\n                            <p> <span class=\"contentfont\">Order No  : ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =", </span>  <img src=\"../images/PDF.png\" width=\"16\" height=\"16\"> <img src=\"../images/print.png\" width=\"16\" height=\"16\"></p>\r\n                            <p> <span class=\"ResultDate\">";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</span></p>\r\n                            \r\n                      </div>\r\n                        \r\n                    </div>\r\n                </div>\r\n              <!-- Stripbox-->  \r\n            ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\r\n            ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\r\n            </div>\r\n         <div>\r\n         <span><a href=\"./result/DetailedResult.jsp\"  class=\"PPbtn\">Show All</a></span>\r\n         </div>\r\n        </div>\r\n            \r\n        \r\n       </div> \r\n       </div>\r\n       </div>\r\n       <!-- #Content Area-->\r\n        \r\n\t</div>\r\n    <!-- #content-->\r\n<div class=\"Footerbg\">\r\n<div class=\"row\">\r\n\t\t<div id=\"footeradd\">\r\n        <p class=\"FooterTitle\"> Get in Touch! </p>\r\n<p class=\"Footeradd\"> Envato Marketplace, Melbourne St, Sydney. TF - 123456, (+00) 0123-456-798, Contact@icarehospital.com, www.icarehospital.com </p>\r\n        \r\n        </div>\r\n\r\n        <div id=\"poweredby\">\r\n        <p class=\"poweredby\">Powered by <img src=\"../images/csc.png\" width=\"25\" height=\"14\"></p>\r\n        </div>\r\n</div>\r\n</div>\r\n</div>\r\n<!-- #wrapper -->\r\n\r\n\r\n\r\n</body>\r\n</html>\r\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

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

	HomePageSvcImpl homePageSvcImpl = new HomePageSvcImpl();
	PatientDetailsRequest patientDetailsRequest = new PatientDetailsRequest();
	patientDetailsRequest.setPatientId(patientId);
	patientDetailsRequest
			.setPortalUserName(PortalConstants.PORTALUSER_REQUEST_PARAM_VALUE);

	homePageSvcImpl.registerService(patientDetailsRequest);

	ServiceInvoker patientDetailsServiceInvoker = new PatientDetailsServiceInvoker();
	PatientDetailsResponse patientDetailsResponse = (PatientDetailsResponse) patientDetailsServiceInvoker
			.getDataThroughWebService(patientDetailsRequest);

	String patientName = patientDetailsResponse.getPatientDisplayName();
	String nationalId = patientDetailsResponse.getNationalId();
	if(nationalId == null){
		nationalId = "";
	}

	// store the patient name in the session
	session.setAttribute(PortalConstants.PATIENTNAME_SESSION_KEY,
			patientName);

	/* HospitalDetailsRequest hospitalDetailsRequest = new HospitalDetailsRequest();
	hospitalDetailsRequest.setPatientId(patientId);
	hospitalDetailsRequest
			.setPortalUserName(PortalConstants.PORTALUSER_REQUEST_PARAM_VALUE);
	hospitalDetailsRequest.setFacilityId("HS");
	ServiceInvoker hospitalDetailsServiceInvoker = new HospitalDetailsServiceInvoker();
	BaseResponse hospitalResponse = hospitalDetailsServiceInvoker
			.getDataThroughWebService(hospitalDetailsRequest); */

	AppointmentDetailsRequest appointmentDetailsRequest = new AppointmentDetailsRequest();
	appointmentDetailsRequest.setPatientId(patientId);
	appointmentDetailsRequest.setRecordCount(CommonConstants.HOMEPAGE_APPOINTMENTLIST_RECORDCOUNT);

	AppointmentSvcImpl appointSvc = new AppointmentSvcImpl();
	appointSvc.registerService(appointmentDetailsRequest);

	AppointmentDetailsResponse appointmentDetailsResponse = null;

	if ("N".equalsIgnoreCase(useWebService)) {
		appointmentDetailsResponse = appointSvc
				.getAppointmentDetails(appointmentDetailsRequest);
	} else if ("Y".equalsIgnoreCase(useWebService)) {
		// need to call the service as a web service
		appointmentDetailsResponse = AppointmentDetailsHelper
				.getAppointmentDetail(appointmentDetailsRequest);
	}

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(patientName));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(patientName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(nationalId));
            _bw.write(_wl_block6Bytes, _wl_block6);

        	        		ErrorInfo errorInfo = appointmentDetailsResponse.getErrorInfo();
        	        		int errorCode = errorInfo.getErrorCode();
        	        		String errorMessage = errorInfo.getErrorMessage();
        	        		if (ErrorInfo.SUCCESS_CODE != errorCode) {
        	        	
            _bw.write(_wl_block7Bytes, _wl_block7);

             	out.println(errorMessage);
             
            _bw.write(_wl_block8Bytes, _wl_block8);

              	} else {
              	
            _bw.write(_wl_block9Bytes, _wl_block9);
	
              		List<AppointmentDetails> appointmentDetailsList = appointmentDetailsResponse
              				.getAppointmentDetailsList();
              		String apptYearAndMonth = "";
              		int apptDateInt = 0;
              		String apptDay = "";
              		String practitioner = "";
              		String speciality = "";
              		String apptStartTime = "";
              		String apptEndTime = "";
              		for(AppointmentDetails appointmentDetails : appointmentDetailsList){
              			apptYearAndMonth = appointmentDetails.getAppointmentMonthAndYear();
              			apptDateInt = appointmentDetails.getAppointmentDateAsInt();
              			apptDay = appointmentDetails.getAppointmentDay();
              			practitioner = appointmentDetails.getPractitioner();
              			speciality = appointmentDetails.getApptSpeciality();
              			apptStartTime = appointmentDetails.getApptStartTimeAsString();
              			apptEndTime = appointmentDetails.getApptEndTimeAsString();
              
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(apptYearAndMonth ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(apptDateInt ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(apptDay ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(practitioner ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(speciality ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(apptStartTime ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(apptEndTime ));
            _bw.write(_wl_block17Bytes, _wl_block17);

              		}// end of for loop
               
            _bw.write(_wl_block18Bytes, _wl_block18);

            	} // end of else loop
            
            _bw.write(_wl_block19Bytes, _wl_block19);

                         	TestDetailsRequest testDetailsRequest = new TestDetailsRequest();
                         	testDetailsRequest.setPatientId(patientId);
              				testDetailsRequest.setRecordCount(CommonConstants.HOMEPAGE_TESTRESULTLIST_RECORDCOUNT);
		
                         	TestDetailsSvcImpl testDetailSvc = new TestDetailsSvcImpl();
                         	testDetailSvc.registerService(testDetailsRequest);

                         	TestDetailsResponse testDetailsResponse = null;

                         	if ("N".equalsIgnoreCase(useWebService)) {
                         		testDetailsResponse = testDetailSvc
                         				.getTestDetails(testDetailsRequest);
                         	} else if ("Y".equalsIgnoreCase(useWebService)) {
                         		ServiceInvoker testDetailsServiceInvoker = new TestDetailsServiceInvoker();
                         		// need to call the service as a web service
                         		testDetailsResponse = (TestDetailsResponse) testDetailsServiceInvoker
                         				.getDataThroughWebService(testDetailsRequest);
                         	}
                         
            _bw.write(_wl_block20Bytes, _wl_block20);

        	        		ErrorInfo testDetailsErrorInfo = testDetailsResponse.getErrorInfo();
        	        		errorCode = testDetailsErrorInfo.getErrorCode();
        	        		errorMessage = testDetailsErrorInfo.getErrorMessage();
        	        		if (ErrorInfo.SUCCESS_CODE != errorCode) {
        	        	
            _bw.write(_wl_block21Bytes, _wl_block21);

                	out.println(errorMessage);
                
            _bw.write(_wl_block22Bytes, _wl_block22);

                 	} else {
                 
            _bw.write(_wl_block23Bytes, _wl_block23);

    		List<TestDetails> testDetailsList = testDetailsResponse.getTestDetailsList();
    		String order = "";
    		String orderNumber = "";
    		String practName = "";
    		String orderDateString = "";
    		String imageStyle = "";
    		for(TestDetails testDetails : testDetailsList){
    			order = testDetails.getOrder();
    			orderNumber = testDetails.getOrderNo();
    			practName = testDetails.getPractName();
    			orderDateString = testDetails.getOrderDateString();
    			
    			imageStyle = "Resultrio";
    			if(ResultConstants.DETAILEDRESULTS_ORDERCATEGORY_LAB_MEDIUM_KEY.equalsIgnoreCase(testDetails.getResultType())){
    				imageStyle = "Resultlab";
    			}
    		
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(imageStyle));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(order ));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(practName ));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(orderNumber ));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(orderDateString ));
            _bw.write(_wl_block29Bytes, _wl_block29);

    		} // end of for loop
            
            _bw.write(_wl_block30Bytes, _wl_block30);

                     } // end of else loop
             
            _bw.write(_wl_block31Bytes, _wl_block31);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
