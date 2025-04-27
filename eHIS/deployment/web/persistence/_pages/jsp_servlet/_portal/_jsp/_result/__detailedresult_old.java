package jsp_servlet._portal._jsp._result;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.Calendar;
import portalrefimpl.result.ResultConstants;
import portalrefimpl.common.model.Facility;
import portalrefimpl.result.detailedresult.response.ResultStatus;
import portalrefimpl.result.detailedresult.response.DetailedResult;
import java.util.List;
import portalrefimpl.common.response.ErrorInfo;
import portalrefimpl.facility.facilityforpatient.response.FacilityListResponse;
import portalrefimpl.facility.facilityforpatient.svc.FacilityListServiceInvoker;
import portalrefimpl.facility.facilityforpatient.svc.FacilityListSvcImpl;
import portalrefimpl.PortalConstants;
import portalrefimpl.facility.facilityforpatient.request.FacilityListRequest;
import portalrefimpl.result.detailedresult.response.DetailedResultsResponse;
import portalrefimpl.result.detailedresult.svc.DetailedResultsSvcImpl;
import portalrefimpl.PortalHelper;
import java.util.Date;
import portalrefimpl.result.detailedresult.request.DetailedResultsRequest;
import portalrefimpl.result.detailedresult.svc.DetailedResultsServiceInvoker;
import portalrefimpl.common.serviceinvoker.ServiceInvoker;

public final class __detailedresult_old extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/portal/jsp/result/DetailedResult_old.jsp", 1669269355906L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n<html>\r\n<head>\r\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n<title>::: Patient Portal - Result</title>\r\n<meta name=\"keywords\" content=\"\" />\r\n<meta name=\"description\" content=\"\" />\r\n<link rel=\"stylesheet\" href=\"../../css/style.css\" type=\"text/css\"/>\r\n<link rel=\"stylesheet\" href=\"../../css/style_ie.css\" type=\"text/css\"/>\r\n\r\n<link href=\"../../css/examples-offline.css\" rel=\"stylesheet\">\r\n<link href=\"../../css/kendo.common.min.css\" rel=\"stylesheet\">\r\n<link href=\"../../css/kendo.default.min.css\" rel=\"stylesheet\">\r\n\r\n<script src=\"../../js/jquery.min.js\"></script>\r\n<script src=\"../../js/kendo.web.min.js\"></script>\r\n<script src=\"../../js/console.js\"></script>\r\n<script src=\"../../js/date.js\"></script>\r\n<script>\r\nfunction searchResults(){\r\n\tvar formElement = document.getElementById(\"searchForm\");\r\n\t// TODO need to perform validation for date fields\r\n\t  if(formElement){\r\n\t\t  var fromDateEle = document.getElementById(\"fromDatePicker\");\r\n\t\t  var fromDateHiddenElem = document.getElementById(\"fromDate\");\r\n\t\t  var fromdatepicker = $(\"#fromDatePicker\").data(\"kendoDatePicker\");\r\n\t\t  var fromDateObj;\r\n\t\t  if(fromDateEle && fromDateHiddenElem){\r\n\t\t\t // alert(\'both from date elements are valid \');\r\n\t\t\t fromDateObj = new Date(fromdatepicker.value());\r\n\t\t\t fromDateHiddenElem.value = fromDateObj.toString(\"MM/dd/yyyy\");\r\n\t\t\t //alert(fromDateObj+\' \'+fromDateObj.toString(\"MM/dd/yyyy\"));\r\n\t\t\t //alert(fromdatepicker.value());\r\n\t\t  }\r\n\t\t  \r\n\t\t  var toDateEle = document.getElementById(\"toDatePicker\");\r\n\t\t  var toDateHiddenElem = document.getElementById(\"toDate\");\r\n\t\t  var todatepicker = $(\"#toDatePicker\").data(\"kendoDatePicker\");\r\n\t\t  var toDateObj;\r\n\t\t  if(toDateEle && toDateHiddenElem){\r\n\t\t\t  //alert(\'both to date elements are valid\');\r\n\t\t\t  toDateObj = new Date(todatepicker.value());\r\n\t\t\t  toDateHiddenElem.value = toDateObj.toString(\"MM/dd/yyyy\");\r\n\t\t\t  //alert(toDateObj+\' \'+toDateObj.toString(\"MM/dd/yyyy\"));\r\n\t\t\t  //alert(todatepicker.value());\r\n\t\t  }\r\n\t\t  //var userName = document.getElementById(\"name\").value;\r\n\t\t  //formElement.action = \"../jsp/PatientPortalHome.jsp?patientId=\"+userName+\"&useWebService=Y\";\r\n\t\t  //formElement.action = \"../servlet/LoginServlet?patientId=\"+userName+\"&useWebService=Y\";\r\n\t\t  formElement.submit();\r\n\t  }\r\n}\r\n\r\nfunction showMoreResults(){\r\n\tvar currentResultCounterComp = document.getElementById(\"resultCounter\");\r\n\tvar currentResultCounter;\r\n\tif(currentResultCounterComp){\r\n\t\tcurrentResultCounter = currentResultCounterComp.value;\r\n\t}\r\n\tvar currentResultCounterInt = parseInt(currentResultCounter);\r\n\tvar resultCountComp = document.getElementById(\"resultCount\");\r\n\tvar resultCount;\r\n\tif(resultCountComp){\r\n\t\tresultCount = resultCountComp.value;\r\n\t}\r\n\tvar resultCountInt = parseInt(resultCount);\r\n\t\r\n\tvar recordViewCountComp = document.getElementById(\"DetailedTestResultsRowCount\")\r\n\tvar recordViewCount;\r\n\tif(recordViewCountComp){\r\n\t\trecordViewCount = recordViewCountComp.value;\r\n\t}\r\n\tvar recordViewCountInt = parseInt(recordViewCount);\r\n\t\r\n\tvar iterationEndValue = resultCountInt;\r\n\tif((currentResultCounterInt + recordViewCountInt) < resultCountInt){\r\n\t\titerationEndValue = currentResultCounterInt + recordViewCountInt;\r\n\t}\r\n\t\r\n\tvar resultElement;\r\n\tfor(var itrCnt=(currentResultCounterInt + 1);itrCnt<=iterationEndValue;itrCnt++){\r\n\t\tresultElement = document.getElementById(\"result\"+itrCnt);\r\n\t\tif(resultElement){\r\n\t\t\tresultElement.style.display = \'block\';\r\n\t\t}\r\n\t}\r\n\t\r\n\tcurrentResultCounterComp.value = \"\"+iterationEndValue;\r\n\t\r\n}\r\n\r\nfunction showResult(orderCatalogue,orderId,resultType){\r\n\tvar url = \'./ViewResult.jsp?orderId=\'+orderId+\'&order=\'+orderCatalogue+\'&resultType=\'+resultType;\r\n\tvar winLeft = (screen.width - 795)/2;\r\n\tvar winTop = (screen.height - 495)/2;\r\n\tvar popupWindow = window.open(url,\'Test Result\',\'height=495,width=795,top=\'+winTop+\',left=\'+winLeft+\',resizable=no,scrollbars=no,toolbar=no,menubar=no,location=no,directories=no,addressbar=no,status=no,titlebar=no\');\r\n}\r\n\r\n$(document).ready(function() {\r\n    // create DatePicker from input HTML element\r\n    $(\"#fromDatePicker\").kendoDatePicker();\r\n    $(\"#toDatePicker\").kendoDatePicker();\r\n});\r\n\r\n</script>\r\n</head>\r\n<body>\r\n\r\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\r\n\r\n<div id=\"wrapper\">\r\n\t\r\n<header id=\"header\">\r\n    \t<div id=\"headerinfo\">\r\n        \t<div class=\"row\">\r\n        \t\t<div id=\"headervisitinfo\">\r\n                \tWelcome back! Your last visit was on Wed, Dec 5, 2012 12:47:08 PM \r\n                </div>    \r\n               <div id=\"headerloginas\">\r\n                \t Welcome, ";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 =",\r\n               </div>\r\n               <div id=\"headerlogout\">\r\n\t\t\t\t\t<div><a href=\"../../servlet/LogoutServlet\"  class=\"logout\">\r\n                    Logout</a></div>\r\n              </div>\r\n          </div>\r\n    </div>\r\n</header>\r\n   \r\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="   \r\n    <!-- #header-->\r\n   \r\n    <!-- #logo And Menu -->\r\n\r\n<div id=\"logomenu\">\r\n\t<div class=\"row\">\t\r\n    \t<div id=\"logo\">\r\n        <img src=\"../../images/logo.png\"> \r\n        </div>\r\n        \r\n        <div id=\"Menubox\">\r\n\t\t\t<ul class=\"menu\">\r\n                  <li><a href=\"#\">Contact</a></li>\r\n                  <li><a href=\"#\">Faq\'s</a></li>\r\n                  <li><a href=\"#\">Settings</a></li>\r\n                  <li><a href=\"#\">About Us</a></li>\r\n                  <li  class=\"menuselect\">My Results</li>\r\n                  <li><a href=\"#\">My Appointments</a></li>\r\n                  <li><a href=\"../PortalHome.jsp\">Home</a></li>\r\n            </ul>\r\n        </div>\r\n        \r\n    </div>\r\n</div>\r\n<div class=\"line\"></div>\r\n   <!-- #logo And Menu -->\r\n   \r\n\r\n<form id=\"searchForm\" name=\"searchForm\" method=\"POST\" action=\"\">\r\n\r\n <!-- #Content Area       **********************************************        -->\r\n<div id=\"innercontent\">\r\n\t<div class=\"row\">\r\n    \t<div class=\"cell\">\r\n        \t<div\t class=\"resulttable\">\r\n<!-- SEARCH ------->\r\n    <div class=\"innerrow\">\r\n    <span class=\"AppointmentNewDoctor\">Search Results</span>\r\n\t</div>\r\n<br>\r\n\r\n  \r\n  <div class=\"innerrow\">\r\n  \r\n            <div id=\"searcharea\">\r\n              <span><a href=\"#\" onclick=\"searchResults()\" class=\"btn\">Search</a></span> \r\n              <input\r\n\t\t\t\t\t\t\t\t\t\tname=\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\"\r\n\t\t\t\t\t\t\t\t\t\tid=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\"\r\n\t\t\t\t\t\t\t\t\t\ttype=\"text\" class=\"textboxsearch\" placeholder=\"Order No\" value=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\">\r\n\t\t\t\t<select id=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\" name=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\" class=\"textboxsearch\" >\r\n\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\r\n\t\t\t\t   <option value=\"\">----Select----</option>\t\r\n\t\t\t\t  ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\r\n\t\t\t\t  <option value=\"\" selected=\"selected\">----Select----</option>\r\n\t\t\t\t  ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\r\n                  <option value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" selected=\"selected\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</option>\r\n                  ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</option>\r\n\t\t\t\t  ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\t\t\t\r\n                </select>\r\n                <select id=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" class=\"textboxsearch\" >\r\n                  ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =" \t\r\n                  <option value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" selected=\"selected\">Lab Order</option>\r\n                  <option value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">Radiology</option>\r\n                  ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">Lab Order</option>\r\n                  <option value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" selected=\"selected\">Radiology</option>\r\n                  ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =" \r\n                </select>\r\n                \r\n         \t\t<input id=\"fromDatePicker\" value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" style=\"width:180px;\" />\r\n         \t\t<input id=\"toDatePicker\" value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" style=\"width:180px;\"/>\r\n            </div>\r\n    </div>\r\n    \r\n    \r\n    \r\n\t\r\n<br>\r\n     <div class=\"innerrow\">\r\n     \r\n   <div id=\"Resultarea\">\r\n      \r\n   ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="   \r\n\t   <span class=\"loginerror\">\r\n       ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\r\n        </span>\r\n        ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="  \r\n      \r\n<!--  Result Box01 -->\r\n<div id=\"result";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" class=\"stripbox\" style=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\r\n\t<div class=\"row\">\r\n\t<!-- Stripicon-->\r\n        <div id=\"StripSpaceA\">\r\n        \t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\r\n            <div id=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'>\r\n            </div>\r\n        </div>\r\n                             <!-- Stripcontent-->\r\n        <div id=\"StripSpaceB\">\r\n            <p><span class=\"AppointmentNewDoctor\">";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</span><span class=\"contenbold\"> by ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</span></p>\r\n            <p> \r\n                    <span class=\"contentfontbold\">Order No :</span><span class=\"contentfont\">";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =" |</span>\r\n                    <span class=\"contentfontbold\">Location : </span><span class=\"contentfont\">";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="  |</span>\r\n                    <span class=\"contentfontbold\">Result Type : </span><span class=\"contentfont\">";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =" </span>\r\n            </p>\r\n            <p> <span class=\"ResultDate\">";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =" at 11:26pm</span><img src=\"../../images/PDF.png\"> <img src=\"../../images/print.png\"></p>\r\n        </div>\r\n        \r\n        <div id=\"StripSpaceD\">\r\n        \t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\r\n           <span><a href=\"#\" onclick=\"showResult(\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\',\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\')\" class=\"btn\">View&nbsp;Results</a></span>\r\n           \t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\r\n           \t<span><a href=\"#\"  class=\"disabled\">In&nbsp;Progress</a></span>\r\n           \t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\r\n        </div>\r\n\r\n\t</div>\r\n</div>\r\n<!--  Result Box01 -->\r\n";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\r\n\r\n</div>\t\r\n  </div><!--  end of result area div -->\r\n<br>\r\n    <div class=\"innerrow\">\r\n   \t\t <div id=\"MoreResult\">\r\n         \t<span><a href=\"#\" onclick=\"showMoreResults()\">Click For More Results</a></span>\r\n            </div>\r\n\t</div>\r\n\r\n</div>\r\n</div>\r\n</div>\r\n\r\n\r\n <!-- #Content Area       **********************************************        -->\r\n        \r\n  </div>\r\n  \r\n  <input type=\"hidden\" id=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\" value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\"/>\r\n  <input type=\"hidden\" id=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\"/>\r\n</form>  \r\n  \r\n    <!-- #content-->\r\n<div class=\"PageFooterbg\">\r\n<div class=\"row\">\r\n\t\r\n\r\n        <div id=\"poweredby\">\r\n        <p class=\"poweredby\">Powered by <img src=\"../../images/csc.png\" width=\"25\" height=\"14\"></p>\r\n        </div>\r\n</div>\r\n</div>\r\n</div>\r\n\r\n</body>\r\n</html>\r\n";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

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

	String orderNumber = request
			.getParameter(ResultConstants.DETAILEDRESULTS_ORDERNUMBER_REQUEST_PARAM_KEY);
	if (orderNumber == null) {
		orderNumber = "";
	}

	String orderCategory = request
			.getParameter(ResultConstants.DETAILEDRESULTS_ORDERCATEGORY_REQUEST_PARAM_KEY);
	if (orderCategory == null) {
		orderCategory = ResultConstants.DETAILEDRESULTS_ORDERCATALOGUE_LAB_KEY;
	}

	String orderCatalogue = request
			.getParameter(ResultConstants.DETAILEDRESULTS_ORDERCATALOGUE_REQUEST_PARAM_KEY);
	if (orderCatalogue == null) {
		orderCatalogue = "";
	}

	String kendoFromDateString = request
			.getParameter(ResultConstants.DETAILEDRESULTS_FROMDATE_REQUEST_PARAM_KEY);
	String fromDateString = kendoFromDateString;
	Date fromDateObj = new Date();
	Calendar fromCalendar = Calendar.getInstance();
	fromCalendar.setTime(fromDateObj);
	fromCalendar.set(Calendar.MONTH, -1);
	if (kendoFromDateString == null) {
		fromDateString = PortalHelper.getDateAsString(
				fromCalendar.getTime(),
				ResultConstants.DETAILEDRESULTS_DATETOSTRING_FORMAT);
		kendoFromDateString = PortalHelper.getDateAsString(
				fromCalendar.getTime(),ResultConstants.DETAILEDRESULTS_KENDOUI_DATE_FORMAT);
		//fromDateString = "28/11/2012";
	}else{
		fromDateObj = PortalHelper.getDateFromString(kendoFromDateString, ResultConstants.DETAILEDRESULTS_KENDOUI_DATE_FORMAT);
		if(fromDateObj == null){
			fromDateObj = fromCalendar.getTime();
			kendoFromDateString = PortalHelper.getDateAsString(
					fromDateObj,ResultConstants.DETAILEDRESULTS_KENDOUI_DATE_FORMAT);
		}else{
			fromCalendar.setTime(fromDateObj);
		}
		fromDateString = PortalHelper.getDateAsString(
				fromDateObj,
				ResultConstants.DETAILEDRESULTS_DATETOSTRING_FORMAT);
	}

	String kendoToDateString = request
			.getParameter(ResultConstants.DETAILEDRESULTS_TODATE_REQUEST_PARAM_KEY); 
	String toDateString = kendoToDateString;
	Date toDateObj = new Date();
	if (kendoToDateString == null) {
		kendoToDateString =  PortalHelper.getDateAsString(
				toDateObj,ResultConstants.DETAILEDRESULTS_KENDOUI_DATE_FORMAT);
		/* toDateString = PortalHelper.getDateAsString(toDateObj,
				ResultConstants.DETAILEDRESULTS_DATETOSTRING_FORMAT); */
		//toDateString = "27/12/2012";
	}
	toDateString = PortalHelper.getDateAsString(toDateObj,
			ResultConstants.DETAILEDRESULTS_DATETOSTRING_FORMAT);

	String resultCountString = request
			.getParameter(ResultConstants.DETAILEDRESULTS_RESULTCOUNT_REQUEST_PARAM_KEY);
	if (resultCountString == null) {
		resultCountString = "0";
	}
	int resultCount = 0;
	try {
		resultCount = Integer.parseInt(resultCountString);
	} catch (Exception ex) {
		resultCount = 0;
	}

	final int TOTALRECORD_COUNT = 7;
	// read the result counter
	String resultCounterString = request
			.getParameter(ResultConstants.DETAILEDRESULTS_RESULTCOUNTER_REQUEST_PARAM_KEY);
	String tempResultCountString = PortalHelper.getConfigPropertyValue(
			ResultConstants.DETAILEDRESULTS_RESULTROWCOUNT_KEY, true);
	if (resultCounterString == null) {
		resultCounterString = tempResultCountString;
	}
	int currentResultCounter = PortalHelper.getIntegerValue(
			tempResultCountString, TOTALRECORD_COUNT);
	int resultCounter = PortalHelper.getIntegerValue(
			tempResultCountString, TOTALRECORD_COUNT);

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(patientName));
            _bw.write(_wl_block3Bytes, _wl_block3);

   	DetailedResultsRequest resultsRequest = new DetailedResultsRequest();
   	//resultsRequest.setPatientId("MC00000345");
   	resultsRequest.setPatientId(patientId);
   	resultsRequest.setOrderNumber(orderNumber);
   	resultsRequest.setOrderCategory(orderCategory);
   	resultsRequest.setLocation(orderCatalogue);
   	/* Date fromDate = PortalHelper.getDateFromString(fromDateString,
   			"dd/MM/yyyy"); */
   	resultsRequest.setFromDate(fromCalendar.getTime());
   	resultsRequest.setFromDateString(fromDateString);

   	/* Date toDate = new Date(); */
   	resultsRequest.setToDate(toDateObj);
   	resultsRequest.setToDateString(toDateString);

   	DetailedResultsSvcImpl detailedSvc = new DetailedResultsSvcImpl();
   	detailedSvc.registerService(resultsRequest);

   	ServiceInvoker detailedResultsServiceInvoker = new DetailedResultsServiceInvoker();
   	DetailedResultsResponse detailedResultsResponse = (DetailedResultsResponse) detailedResultsServiceInvoker
   			.getDataThroughWebService(resultsRequest);

   	FacilityListRequest facilityListRequest = new FacilityListRequest();
   	facilityListRequest
   			.setPortalUserName(PortalConstants.PORTALUSER_REQUEST_PARAM_VALUE);

   	FacilityListSvcImpl facilityListSvcImpl = new FacilityListSvcImpl();
   	facilityListSvcImpl.registerService(facilityListRequest);

   	ServiceInvoker facilityListServiceInvoker = new FacilityListServiceInvoker();
   	FacilityListResponse facilityListResponse = (FacilityListResponse) facilityListServiceInvoker
   			.getDataThroughWebService(facilityListRequest);
   
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(ResultConstants.DETAILEDRESULTS_ORDERNUMBER_REQUEST_PARAM_KEY));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(ResultConstants.DETAILEDRESULTS_ORDERNUMBER_REQUEST_PARAM_KEY));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(orderNumber));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(ResultConstants.DETAILEDRESULTS_ORDERCATALOGUE_REQUEST_PARAM_KEY));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(ResultConstants.DETAILEDRESULTS_ORDERCATALOGUE_REQUEST_PARAM_KEY));
            _bw.write(_wl_block9Bytes, _wl_block9);

					if ("".equalsIgnoreCase(orderCatalogue.trim())) {
				
            _bw.write(_wl_block10Bytes, _wl_block10);

					  	} else {
					  
            _bw.write(_wl_block11Bytes, _wl_block11);

				  	}
				  	ErrorInfo facilityListErrorInfo = facilityListResponse
				  			.getErrorInfo();
				  	List<Facility> facilityList = null;
				  	if (ErrorInfo.SUCCESS_CODE == facilityListErrorInfo.getErrorCode()) {
				  		facilityList = facilityListResponse.getFacilityList();
				  		for (Facility facility : facilityList) {
				  			if (orderCatalogue.equalsIgnoreCase(facility
				  					.getFacilityId())) {
				  
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(facility.getFacilityId()));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(facility.getFacilityName()));
            _bw.write(_wl_block14Bytes, _wl_block14);

                  	} else {
                  
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(facility.getFacilityId()));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(facility.getFacilityName()));
            _bw.write(_wl_block16Bytes, _wl_block16);

				  	}
				  		}
				  	}
				  
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(ResultConstants.DETAILEDRESULTS_ORDERCATEGORY_REQUEST_PARAM_KEY));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(ResultConstants.DETAILEDRESULTS_ORDERCATEGORY_REQUEST_PARAM_KEY));
            _bw.write(_wl_block18Bytes, _wl_block18);

                  	if (ResultConstants.DETAILEDRESULTS_ORDERCATALOGUE_LAB_KEY
                  			.equalsIgnoreCase(orderCategory)) {
                  
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(ResultConstants.DETAILEDRESULTS_ORDERCATALOGUE_LAB_KEY));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(ResultConstants.DETAILEDRESULTS_ORDERCATALOGUE_RADIOLOGY_KEY));
            _bw.write(_wl_block21Bytes, _wl_block21);

                  	} else {
                  
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(ResultConstants.DETAILEDRESULTS_ORDERCATALOGUE_LAB_KEY));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(ResultConstants.DETAILEDRESULTS_ORDERCATALOGUE_RADIOLOGY_KEY));
            _bw.write(_wl_block23Bytes, _wl_block23);

                  	}
                  
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(kendoFromDateString ));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(kendoToDateString ));
            _bw.write(_wl_block26Bytes, _wl_block26);

         	ErrorInfo resultsErrorInfo = detailedResultsResponse.getErrorInfo();
         	String errorMessage = resultsErrorInfo.getErrorMessage();
         	if (ErrorInfo.SUCCESS_CODE != resultsErrorInfo.getErrorCode()) {
         
            _bw.write(_wl_block27Bytes, _wl_block27);

       	out.println(errorMessage);
       
            _bw.write(_wl_block28Bytes, _wl_block28);

        	} else {
        		List<DetailedResult> detailedResultList = detailedResultsResponse
        				.getTestResultList();
        		// set the list size to the resultCount var
        		resultCount = detailedResultList.size();

        		ResultStatus resultStatus = null;

        		int counter = 1;
        		String ordCategory = null;
        		String imageId = null;
        		String divDisableStyle = "display:block";
        		for (DetailedResult detailedResult : detailedResultList) {
        			if (counter > currentResultCounter) {
        				divDisableStyle = "display:none";
        			}

        			resultStatus = detailedResult.getResultStatus();
        
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(divDisableStyle));
            _bw.write(_wl_block31Bytes, _wl_block31);

        		ordCategory = detailedResult.getOrderCategory();
        				imageId = "Resultrio";
        				if (ResultConstants.DETAILEDRESULTS_ORDERCATEGORY_LAB_MEDIUM_KEY
        						.equalsIgnoreCase(ordCategory)) {
        					imageId = "Resultlab";
        				}
        	
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(imageId));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(detailedResult.getOrderCatalogue()));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(detailedResult.getOrderPractitioner()));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(detailedResult.getOrderNumber()));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(detailedResult.getLocation()));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(detailedResult.getOrderCategory()));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(detailedResult.getOrderDate() ));
            _bw.write(_wl_block39Bytes, _wl_block39);

        		if (ResultStatus.COMPLETED == resultStatus) {
        	
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(detailedResult.getOrderCatalogue()));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(detailedResult.getOrderNumber()));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(detailedResult.getOrderCategory()));
            _bw.write(_wl_block42Bytes, _wl_block42);

           		} else {
           	
            _bw.write(_wl_block43Bytes, _wl_block43);

           		}
           	
            _bw.write(_wl_block44Bytes, _wl_block44);

	counter++;
		}
	}

            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(ResultConstants.DETAILEDRESULTS_RESULTCOUNTER_REQUEST_PARAM_KEY));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(ResultConstants.DETAILEDRESULTS_RESULTCOUNTER_REQUEST_PARAM_KEY));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(currentResultCounter));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(ResultConstants.DETAILEDRESULTS_RESULTCOUNT_REQUEST_PARAM_KEY));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(ResultConstants.DETAILEDRESULTS_RESULTCOUNT_REQUEST_PARAM_KEY));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(resultCount));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(ResultConstants.DETAILEDRESULTS_RESULTROWCOUNT_KEY));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(ResultConstants.DETAILEDRESULTS_RESULTROWCOUNT_KEY));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(resultCounter));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(ResultConstants.DETAILEDRESULTS_FROMDATE_REQUEST_PARAM_KEY ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(ResultConstants.DETAILEDRESULTS_FROMDATE_REQUEST_PARAM_KEY ));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(kendoFromDateString ));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(ResultConstants.DETAILEDRESULTS_TODATE_REQUEST_PARAM_KEY ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(ResultConstants.DETAILEDRESULTS_TODATE_REQUEST_PARAM_KEY ));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(kendoToDateString ));
            _bw.write(_wl_block48Bytes, _wl_block48);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
