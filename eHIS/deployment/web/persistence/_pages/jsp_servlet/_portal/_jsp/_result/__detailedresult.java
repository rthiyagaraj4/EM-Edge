package jsp_servlet._portal._jsp._result;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import portalrefimpl.result.viewresult.TestResultCacheManager;
import java.util.Calendar;
import portalrefimpl.result.ResultConstants;
import portalrefimpl.common.model.Facility;
import portalrefimpl.result.detailedresult.response.ResultStatus;
import portalrefimpl.result.detailedresult.response.DetailedResult;
import java.util.List;
import portalrefimpl.common.response.ErrorInfo;
import portalrefimpl.facility.facilityforpatient.response.FacilityListResponse;
import portalrefimpl.facility.facilityforpatient.svc.FacilityListServiceInvoker;
import portalrefimpl.PortalConstants;
import portalrefimpl.facility.facilityforpatient.request.FacilityListRequest;
import portalrefimpl.result.detailedresult.response.DetailedResultsResponse;
import portalrefimpl.PortalHelper;
import java.util.Date;
import portalrefimpl.result.detailedresult.request.DetailedResultsRequest;
import portalrefimpl.result.detailedresult.svc.DetailedResultsServiceInvoker;
import portalrefimpl.common.serviceinvoker.ServiceInvoker;

public final class __detailedresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/portal/jsp/result/DetailedResult.jsp", 1669269355922L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n<html>\r\n<head>\r\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n<title>::: Patient Portal - Result</title>\r\n<meta name=\"keywords\" content=\"\" />\r\n<meta name=\"description\" content=\"\" />\r\n<link rel=\"stylesheet\" href=\"../../css/style.css\" type=\"text/css\"/>\r\n<link rel=\"stylesheet\" href=\"../../css/style_ie.css\" type=\"text/css\"/>\r\n\r\n<link href=\"../../css/examples-offline.css\" rel=\"stylesheet\">\r\n<link href=\"../../css/kendo.common.min.css\" rel=\"stylesheet\">\r\n<link href=\"../../css/kendo.default.min.css\" rel=\"stylesheet\">\r\n\r\n<script src=\"../../js/jquery.min.js\"></script>\r\n<script src=\"../../js/kendo.web.min.js\"></script>\r\n<script src=\"../../js/console.js\"></script>\r\n<script src=\"../../js/date.js\"></script>\r\n<script>\r\nfunction searchResults(){\r\n\tvar formElement = document.getElementById(\"searchForm\");\r\n\t// TODO need to perform validation for date fields\r\n\t  if(formElement){\r\n\t\t  \r\n\t\t  var categoryCombo = document.getElementById(\'orderCategory\');\r\n\t\t  if(categoryCombo){\r\n\t\t\t  var categoryValue = categoryCombo.options[categoryCombo.selectedIndex].value;\r\n\t\t\t  if(categoryValue == \'\'){\r\n\t\t\t\t  alert(\'Either Lab Order or Radiology should be selected for search operation\');\r\n\t\t\t\t  return false;\r\n\t\t\t  }\r\n\t\t  }\r\n\t\t  \r\n\t\t  \r\n\t\t  var fromDateEle = document.getElementById(\"fromDatePicker\");\r\n\t\t  var fromDateHiddenElem = document.getElementById(\"fromDate\");\r\n\t\t  var fromdatepicker = $(\"#fromDatePicker\").data(\"kendoDatePicker\");\r\n\t\t  var fromDateObj;\r\n\t\t  var dateValue = \"\";\r\n\t\t  if(fromDateEle && fromDateHiddenElem){\r\n\t\t\t //alert(fromDateEle.value);\r\n\t\t\t if(fromdatepicker){\r\n\t\t\t\t fromDateObj = new Date(fromdatepicker.value());\r\n\t\t\t\t dateValue = fromDateObj.toString(\"MM/dd/yyyy\");\r\n\t\t\t }else{\r\n\t\t\t\t dateValue = fromDateEle.value;\r\n\t\t\t }\r\n\t\t\t \r\n\t\t\t fromDateHiddenElem.value = dateValue;\r\n\t\t  }\r\n\t\t  \r\n\t\t  dateValue = \"\";\r\n\t\t  \r\n\t\t  var toDateEle = document.getElementById(\"toDatePicker\");\r\n\t\t  var toDateHiddenElem = document.getElementById(\"toDate\");\r\n\t\t  var todatepicker = $(\"#toDatePicker\").data(\"kendoDatePicker\");\r\n\t\t  var toDateObj;\r\n\t\t  if(toDateEle && toDateHiddenElem){\r\n\t\t\t  if(todatepicker){\r\n\t\t\t\t  toDateObj = new Date(todatepicker.value());\r\n\t\t\t\t  dateValue = toDateObj.toString(\"MM/dd/yyyy\");\r\n\t\t\t  }else{\r\n\t\t\t\t  dateValue = toDateEle.value;\r\n\t\t\t  }\r\n\t\t\t  \r\n\t\t\t  toDateHiddenElem.value = dateValue;\r\n\t\t  }\r\n\t\t  \r\n\t\t  var initialResultElem = document.getElementById(\"initialReset\");\r\n\t\t  if(initialResultElem){\r\n\t\t\t  initialResultElem.value = \"N\";\r\n\t\t  }\r\n\t\t  \r\n\t\t  formElement.submit();\r\n\t  }\r\n}\r\n\r\nfunction showMoreResults(){\r\n\t// get the component which stores the current number\r\n\t// of records shown in the page\r\n\tvar currentResultCounterComp = document.getElementById(\"resultCounter\");\r\n\tvar currentResultCounter;\r\n\tif(currentResultCounterComp){\r\n\t\tcurrentResultCounter = currentResultCounterComp.value;\r\n\t}\r\n\t// get the int value\r\n\tvar currentResultCounterInt = parseInt(currentResultCounter);\r\n\t// get the component which stores the overall number\r\n\t// of records shown in the page\r\n\tvar resultCountComp = document.getElementById(\"resultCount\");\r\n\tvar resultCount;\r\n\tif(resultCountComp){\r\n\t\tresultCount = resultCountComp.value;\r\n\t}\r\n\tvar resultCountInt = parseInt(resultCount);\r\n\t\r\n\t// get the component which stores the number of records to be shown\r\n\t// every time user clicks on \"click more\" button\r\n\tvar recordViewCountComp = document.getElementById(\"DetailedTestResultsRowCount\")\r\n\tvar recordViewCount;\r\n\tif(recordViewCountComp){\r\n\t\trecordViewCount = recordViewCountComp.value;\r\n\t}\r\n\tvar recordViewCountInt = parseInt(recordViewCount);\r\n\t\r\n\t// the logic now is to show records further from the current\r\n\t// number of records shown till the next set of records\t\r\n\tvar iterationEndValue = resultCountInt;\r\n\tif((currentResultCounterInt + recordViewCountInt) < resultCountInt){\r\n\t\titerationEndValue = currentResultCounterInt + recordViewCountInt;\r\n\t}\r\n\t\r\n\tvar resultElement;\r\n\tfor(var itrCnt=(currentResultCounterInt + 1);itrCnt<=iterationEndValue;itrCnt++){\r\n\t\tresultElement = document.getElementById(\"result\"+itrCnt);\r\n\t\tif(resultElement){\r\n\t\t\tresultElement.style.display = \'block\';\r\n\t\t}\r\n\t}\r\n\t\r\n\t// this code will disable the \"click more\" button since there are\r\n\t// no more records to be shown\r\n\tif(iterationEndValue == resultCountInt){\r\n\t\tvar moreResultDivComp = document.getElementById(\"moreResultDiv\");\r\n\t\tif(moreResultDivComp){\r\n\t\t\tmoreResultDivComp.style.display = \"none\";\r\n\t\t}\r\n\t}\r\n\t\r\n\tcurrentResultCounterComp.value = \"\"+iterationEndValue;\r\n}\r\n\r\nfunction showResult(orderCatalogue,orderId,resultType,orderDate){\r\n\tvar newOrderCatalogue = escape(orderCatalogue);\r\n\t//alert(orderId+\' \'+newOrderCatalogue+\' \'+resultType+\' \'+orderDate);\r\n\tvar url = \'./ViewResult.jsp?orderId=\'+orderId+\'&order=\'+newOrderCatalogue+\'&resultType=\'+resultType+\'&orderDate=\'+orderDate;\r\n\tvar winLeft = (screen.width - 795)/2;\r\n\tvar winTop = (screen.height - 495)/2;\r\n\tvar popupWindow = window.open(url,\'TestResult\',\'height=495,width=795,top=\'+winTop+\',left=\'+winLeft+\',resizable=no,scrollbars=yes,toolbar=no,menubar=no,location=no,directories=no,addressbar=no,status=no,titlebar=no\');\r\n\treturn false;\r\n}\r\n\r\nfunction showTestResult(orderId,orderCatalogue,orderCategory,orderDate,counter,viewResultAnchorId){\r\n\t//alert($(\'#testresult\'+counter));\r\n\tvar newOrderCatalogue = escape(orderCatalogue);\r\n\tvar newResultType = escape(orderCategory);\r\n\tvar newOrderDate = escape(orderDate);\r\n\t//alert(orderId+\' \'+newOrderCatalogue+\' \'+newResultType+\' \'+newOrderDate+ \' \'+orderDate+\' \'+orderCategory);\r\n\tvar btnText = $(\'#\'+viewResultAnchorId).html();\r\n\tif(btnText == \'Hide&nbsp;Results\'){\r\n\t\t$(\'#testresult\'+counter).css(\'display\',\'none\');\r\n\t\t$(\'#\'+viewResultAnchorId).html(\"View&nbsp;Results\");\r\n\t}else{\r\n\t\t//$(\'#testresult\'+counter).load(\'./GetTestResult.jsp?orderId=\'+orderId+\'&order=\'+newOrderCatalogue+\'&resultType=\'+newResultType+\'&orderDate=\'+newOrderDate+\'&counter=\'+counter);\r\n\t\t\r\n\t\tvar xmlHttp = getHttpObject();\r\n     \txmlHttp.onreadystatechange=function(){\r\n     \t\tif(xmlHttp.readyState==4 && xmlHttp.status==200){\r\n     \t\t\tvar responseText = xmlHttp.responseText;\r\n     \t\t\t$(\'#testresult\'+counter).html(responseText);\r\n     \t\t\t\r\n     \t\t\t$(\'#testresult\'+counter).css(\'display\',\'block\');\r\n     \t\t\t$(\'#\'+viewResultAnchorId).html(\"Hide&nbsp;Results\");\r\n     \t\t}\r\n     \t };\r\n     \txmlHttp.open(\"POST\", \"./GetTestResult.jsp\", true);\r\n     \txmlHttp.setRequestHeader(\"Content-type\",\"application/x-www-form-urlencoded\");\r\n     \tvar parameters = \'orderId=\'+orderId+\'&order=\'+newOrderCatalogue+\'&resultType=\'+newResultType+\'&orderDate=\'+newOrderDate+\'&counter=\'+counter;\r\n     \txmlHttp.send(parameters);\r\n     \t\r\n     \t\r\n\t\t/* $(\'#testresult\'+counter).load(\'./TestResultWrapper.jsp?orderId=\'+orderId+\'&order=\'+newOrderCatalogue+\'&resultType=\'+newResultType+\'&orderDate=\'+newOrderDate+\'&counter=\'+counter); */\r\n\t\t//$(\'#testresult\'+counter).load(\'./GetTestResult.jsp?orderId=\'+orderId);\r\n\t\t\r\n\t\t//$(\'#testresult\'+counter).css(\'display\',\'block\');\r\n\t\t\r\n\t\t// now change the inner html of the \"view result\" button\r\n\t\t// to \"hide result\"\r\n\t\t//alert($(\'#viewresultbtn\'+counter).html());\r\n\t\t//alert(viewResultAnchorId);\r\n\t\t\r\n\t\t$(\'#\'+viewResultAnchorId).html(\"Hide&nbsp;Results\");\r\n\t}\r\n\t\r\n}\r\n\r\nfunction getHttpObject(){\r\n\tvar xmlHttp;\r\n\tif (window.XMLHttpRequest) {\r\n\t\txmlHttp = new XMLHttpRequest();\r\n\t} else if (window.ActiveXObject) {\r\n\t\txmlHttp = new ActiveXObject(\"Microsoft.XMLHTTP\");\r\n\t}\r\n\treturn xmlHttp;\r\n}\r\n\r\n\r\n$(document).ready(function() {\r\n    // create DatePicker from input HTML element\r\n    $(\"#fromDatePicker\").kendoDatePicker();\r\n    $(\"#toDatePicker\").kendoDatePicker();\r\n});\r\n\r\nfunction showResultPopup(orderCatalogue,orderId,resultType,orderDate,counter){\r\n\t//alert(\'in function\');\r\n\t//alert(\'in function, input values are:\'+orderCatalogue+\' ; \'+orderId+\' ; \'+resultType+\' ; \'+orderDate+\' ; \'+counter );\r\n\tvar newOrderCatalogue = escape(orderCatalogue);\r\n\tvar newResultType = escape(resultType);\r\n\tvar newOrderDate = escape(orderDate);\r\n\tvar newOrderId = escape(orderId);\r\n\t\r\n\t $(\'#popupdiv\'+counter).load(\'./ViewResult.jsp?orderId=\'+newOrderId+\'&order=\'+newOrderCatalogue+\'&resultType=\'+newResultType+\'&orderDate=\'+newOrderDate+\'&counter=\'+counter);\r\n\t //alert(\'in show result popup - after loading\');\r\n\t \r\n\t /* document.getElementById(\'popupcontainerdiv\'+counter).style.visibility = \'\';\r\n\t document.getElementById(\'popupdiv\'+counter).style.visibility = \'\';\r\n\t if(!($(\'#popupdiv\'+counter).data(\"kendoWindow\"))){\r\n\t\t $(\'#popupdiv\'+counter).kendoWindow({\r\n\t\t\t actions : [\"Close\"],\r\n\t\t\t draggable : false,\r\n\t\t\t modal : true,\r\n\t\t\t resizable : false,\r\n\t\t\t close : function() {\r\n\t\t\t\t closeResultPopup(counter);\r\n\t\t\t }\r\n\t\t });\r\n\t\t $(\'#popupdiv\'+counter).data(\"kendoWindow\").open();\r\n\t\t $(\'#popupdiv\'+counter).data(\"kendoWindow\").center();\r\n\t } */\r\n\t \r\n\t \r\n\tif (document.getElementById(\'popupcontainerdiv\'+counter).style.visibility == \'hidden\') {\r\n       document.getElementById(\'popupcontainerdiv\'+counter).style.visibility = \'\';\r\n       $(\"#popupcontainerdiv\"+counter).hide();\r\n    }\r\n    if (document.getElementById(\'popupdiv\'+counter).style.visibility == \'hidden\') {\r\n       document.getElementById(\'popupdiv\'+counter).style.visibility = \'\';\r\n       $(\"#popupdiv\"+counter).hide();\r\n    }\r\n\t\r\n\t$(\"#popupcontainerdiv\"+counter).fadeIn(500, \"linear\", function () { $(\"#popupdiv\"+counter).show(800, \"swing\"); }); \t\r\n}\r\n\r\nfunction closeResultPopup(popupDivCounter){\r\n\t$(\"#popupdiv\"+popupDivCounter).hide(\'800\', \"swing\", function () { $(\"#popupcontainerdiv\"+popupDivCounter).fadeOut(\"500\"); });\r\n\t/* document.getElementById(\'popupcontainerdiv\'+popupDivCounter).style.visibility = \'hidden\';\r\n\tdocument.getElementById(\'popupdiv\'+popupDivCounter).style.visibility = \'hidden\';  */\r\n\t\r\n\t\r\n\t//alert(\'in close\');\r\n\t/* document.getElementById(\'popupcontainerdiv\'+popupDivCounter).style.visibility = \'hidden\';\r\n\tdocument.getElementById(\'popupdiv\'+popupDivCounter).style.visibility = \'hidden\'; */\r\n\t\r\n\t//$(\'#popupdiv\'+popupDivCounter).data(\"kendoWindow\").close();\r\n}\r\n\r\n</script>\r\n\r\n<style>\r\n\r\n.menu li a:before {\r\n\tcontent:url(../../images/patch.PNG);\r\n\theight:80px;\r\n\twidth:auto;\r\n\ttop:63px;\r\n\tleft:-13px;\r\n\tposition:relative;\r\n}\r\n.menu li a:after {content:url(../../images/patch.PNG);\r\n\theight:80px;\r\n\twidth:auto;\r\n\ttop:35px;\r\n\tright:-13px;\r\n\tposition:relative;\r\n\r\n}\r\n.menu li a:hover:before {content:url(../../images/LeftMenubg.PNG);\r\n\theight:80px;\r\n\twidth:auto;\r\n\ttop:63px;\r\n\tleft:-13px;\r\n\tposition:relative;\r\n}\r\n\r\n.menu li a:hover:after{\r\n\tcontent:url(../../images/RightMenubg.PNG);\r\n\theight:80px;\r\n\twidth:auto;\r\n\ttop:35px;\r\n\tright:-13px;\r\n\tposition:relative;\r\n}\r\n\r\n.menuselect:after{\r\n\tcontent:url(../../images/RightMenubg.PNG);\r\n\theight:80px;\r\n\twidth:auto;\r\n\ttop:35px;\r\n\tright:-13px;\r\n\tposition:relative;\r\n\r\n}\r\n.menuselect:before {content:url(../../images/LeftMenubg.PNG);\r\n\theight:80px;\r\n\twidth:auto;\r\n\ttop:65px;\r\n\tleft:-13px;\r\n\tposition:relative;\r\n\r\n}\r\n\r\n.popupContainerStyle {\r\n      /* background-color: white;\r\n      color: black;\r\n      display:block;\r\n      position: absolute;\r\n      top: 50%;\r\n      left: 50%;\r\n      width: 795px;\r\n      height: 495px; */\r\n      \r\n      background-color: black;\r\n      opacity: 90%;\r\n      filter:alpha(opacity=90);\r\n      background-color: rgba(255,255,255,0.90); \r\n      width: 100%;\r\n      min-height: 100%;\r\n      overflow: hidden;\r\n      float: absolute;\r\n      position: fixed;\r\n      top: 0;\r\n      left: 0;\r\n      color: white;\r\n}\r\n\r\n.popupResultContentStyle{\r\n\t  background-color: white;\r\n      color: black;\r\n      border: 1px solid gray;\r\n      padding: 2px;\r\n      display:block;\r\n      position: absolute;\r\n      top: 20%;\r\n      left: 20%; \r\n      width: 775px;\r\n      height: 475px;\r\n}\r\n\r\n</style>\r\n\r\n\r\n\r\n\r\n</head>\r\n<body>\r\n\r\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\r\n\r\n<div id=\"wrapper\" style=\"background-color: #ffffff;\">\r\n<div class=\"fixedheader\">\t\r\n<header id=\"header\">\r\n    \t<div id=\"headerinfo\">\r\n        \t<div class=\"row\">\r\n        \t\t<div id=\"headervisitinfo\">\r\n                \tWelcome back! Your last visit was on Wed, Dec 5, 2012 12:47:08 PM \r\n                </div>    \r\n               <div id=\"headerloginas\">\r\n                \t Welcome, ";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 =", ID:";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\r\n               </div>\r\n               <div id=\"headerlogout\">\r\n\t\t\t\t\t<div><a href=\"../../servlet/LogoutServlet\"  class=\"logout\">\r\n                    Logout</a></div>\r\n              </div>\r\n          </div>\r\n    </div>\r\n</header>\r\n   \r\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="   \r\n    <!-- #header-->\r\n   \r\n    <!-- #logo And Menu -->\r\n\r\n<div id=\"logomenu\">\r\n\t<div class=\"row\">\t\r\n    \t<div id=\"logo\">\r\n        <img src=\"../../images/logo.png\"> \r\n        </div>\r\n        \r\n        <div id=\"Menubox\">\r\n\t\t\t<ul class=\"menu\">\r\n\t\t\t\t<li><a href=\"../Contact.jsp\"><div class=\"menuicons\"><img src=\"../../images/Contact.png\"/></div>Contact</a></li>\r\n                <li class=\"menuselect\"><div class=\"menuicons\"><img src=\"../../images/Results.png\"/></div>My Results</a></li>\r\n                <li><a href=\"../schedule/UpcomingAppointments.jsp\"><div class=\"menuicons\"><img src=\"../../images/Appointment.png\"/></div>My Appointments</a></li>\r\n                <li><a href=\"../PortalHome.jsp\" ><div class=\"menuicons\"><img src=\"../../images/Home.png\"/></div>Home</a></li>\r\n                 <!--   <li><a href=\"#\">Contact</a></li>\r\n                  <li><a href=\"#\">Faq\'s</a></li>\r\n                  <li><a href=\"#\">Settings</a></li>\r\n                  <li><a href=\"#\">About Us</a></li>\r\n                  <li  class=\"menuselect\">My Results</li>\r\n                  <li><a href=\"#\">My Appointments</a></li>\r\n                  <li><a href=\"../PortalHome.jsp\">Home</a></li>-->\r\n            </ul>\r\n        </div>\r\n        \r\n    </div>\r\n</div>\r\n</div>\r\n\r\n<div class=\"line\"></div>\r\n   <!-- #logo And Menu -->\r\n   \r\n\r\n<form id=\"searchForm\" name=\"searchForm\" method=\"POST\" action=\"\">\r\n\r\n <!-- #Content Area       **********************************************        -->\r\n <div id=\"detailedresultcontent\">\r\n <div id=\"contentbg\">\r\n\t\t</div>\r\n <div id=\"contentArea\">\r\n <div id=\"contentArearow\">\r\n <div>\r\n \r\n <div id=\"innercontentExpanded\">\r\n\t<div class=\"row\">\r\n\t\t<div class=\"cell\">\r\n\t\t\t<div class=\"resulttableExpanded\">\r\n \t\t\t<div class=\"innerrow\">\r\n\t\t\t\t<span class=\"AppointmentNewDoctor\">Search Results</span>\r\n\t\t\t</div>\r\n\t\t\t<br/>\r\n\t\t\t<div class=\"innerrow\">\r\n\t\t\t\t<div id=\"searcharea\">\r\n \t\t\t\t<span><a onclick=\"searchResults()\"  class=\"btn\">Search</a></span>\r\n\t\t\t\t\t<input name=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\"\r\n\t\t\t\t\tid=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\" \r\n\t\t\t\t\ttype=\"text\" class=\"textboxresult\" placeholder=\"OrderNo\" title=\"OrderNo\" value=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\">\r\n\t\t\t\t<select class=\"Comboboxresult\" id=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\" name=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\">\r\n\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\r\n\t\t\t\t\t   <option value=\"\" selected=\"selected\">----Select Facility----</option>\t\r\n\t\t\t\t\t  ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\r\n\t\t\t\t\t  <option value=\"\">----Select Facility----</option>\r\n\t\t\t\t\t  ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\r\n\t                  <option value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" selected=\"selected\">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</option>\r\n\t                  ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</option>\r\n\t\t\t\t\t  ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\t\t\t\r\n                </select>\r\n\t\t\t\t\r\n\t\t\t\t<select class=\"Comboboxresult\" id=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =" \t\r\n\t\t\t\t\t  <option value=\"\">---Select Category---</option>\t\t\t\t\t\t\r\n\t                  <option value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" selected=\"selected\">Lab Order</option>\r\n\t                  <option value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">Radiology</option>\r\n\t                  ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\r\n\t                  <option value=\"\">---Select Category---</option>\r\n\t                  <option value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">Lab Order</option>\r\n\t                  <option value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" selected=\"selected\">Radiology</option>\r\n\t                  ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\r\n\t                  <option value=\"\" selected=\"selected\">---Select Category---</option>\r\n\t                  <option value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\r\n\t             </select>  \t\r\n\t            \r\n\t            <span>From</span>     \r\n\t\t\t\t<input id=\"fromDatePicker\" value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" style=\"width:180px;\" />\r\n\t\t\t\t<span>To</span>\r\n         \t\t<input id=\"toDatePicker\" value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" style=\"width:180px;\"/>\r\n\t\t\t\t\r\n\t\t\t</div>\r\n\t\t</div>\r\n\t\t<br/>\r\n\t\t\r\n\t\t\r\n\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\r\n\t\t<div class=\"innerrow\">\r\n\t\t <div id=\"initialMessageDiv\" style=\"margin-left:30px; width:99%;height:20px;border:1px #cccccc solid;display:table-cell;\">\r\n\t\t\t<!-- <table style=\"width:95%;border:1px #cccccc solid;\">\r\n\t\t\t <tr>\r\n\t\t\t \t<td width=\"100%\"> -->\r\n\t\t\t\t<span style=\"color:#333333;font-size:12px;font-weight:bold;\">\r\n\t\t\t ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\t\r\n\t\t\t\t</span>\r\n\t\t\t\t<!-- </td>\r\n\t\t\t  </tr>\r\n\t\t\t</table>  --> \t\r\n\t\t</div>\r\n\t\t</div>\r\n\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\r\n\t\t\r\n\t\t<div class=\"innerrow\" style=\"overflow: auto;\">\r\n   \t\t\t<div id=\"DetailedResultarea\">\t\r\n   \t\t\t\r\n   \t\t\t ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\r\n\t   \t\t   <p>   \r\n\t\t\t   <span class=\"loginerror\" style=\"padding-left: 10px;\">\r\n\t\t       ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\r\n\t\t        </span>\r\n\t\t        </p>\r\n\t   \t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="  \r\n   \t\t\t\t\r\n\t\t\t\t<div class=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" id=\"result";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\"  style=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">\r\n\t\t\t\t\t<div class=\"row\" width=\"100%\">\r\n\t\t\t\t\t<!-- Stripicon-->\r\n\t\t\t\t        <div id=\"StripSpaceA\">\r\n\t\t\t\t        \t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\r\n\t\t\t\t           <div id=\"Resulticon\">\r\n\t\t\t\t\t\t\t\t<img src=\"../../images/";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\"/>\r\n\t\t\t\t\t\t\t</div>\r\n\t\t\t\t        </div>\r\n\t\t\t\t         <!-- Stripcontent-->\r\n\t\t\t\t        <div id=\"StripSpaceB\">\r\n\t\t\t\t            <p><span class=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</span><span class=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\"> by ";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</span></p>\r\n\t\t\t\t            <p> \r\n\t\t\t\t                    <div class=\"floatleft resultdetail\"><span class=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\">Order No : </span><span class=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 =" </span></div>\r\n\t\t\t\t                    <div class=\"floatleft resultdetail\"><span class=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\">Result Type : </span><span class=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 =" </span></div>\r\n\t\t\t\t\t\t\t\t\t<div class=\"floatleft resultLocdetail\"><span class=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\">Location : </span><span class=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 =" </span></div>\r\n\t\t\t\t                    \r\n\t\t\t\t            </p>\r\n\t\t\t\t            <p> <span class=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 =" at ";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</span><img class=\"printPDF\" src=\"../../images/PDF.png\"> <img class=\"printPDF\" src=\"../../images/print.png\"></p>\r\n\t\t\t\t        </div>\r\n\t\t\t\t        \r\n\t\t\t\t        <div id=\"StripSpaceD\">\r\n\t\t\t\t\t\t    ";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\r\n\t\t\t\t           ";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\r\n\t\t\t\t           <span><a id=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\" onclick=\"showTestResult(\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\',\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\')\" class=\"btn\">View&nbsp;Results</a></span>\r\n\t\t\t\t           \t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\r\n\t\t\t\t           \t<span><a href=\"#\"  class=\"disabled\">In&nbsp;Progress</a></span>\r\n\t\t\t\t           \t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\r\n\t\t\t\t        \r\n\t\t\t\t           <!--  <span><a href=\"Resultpopup.html\" target=\"_blank\"  class=\"UpcomingAppbtn\">View&nbsp;Results</a></span>-->\r\n\t\t\t\t        </div>\r\n\t\t\t\t\r\n\t\t\t\t\t</div>\r\n\t\t\t\t</div>\t\r\n\t\t\t\t\r\n\t\t\t\t ";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\r\n\t\t\t\t  <!--INLINE POP UP RESULT ---->\r\n\t\t\t\t<div class=\"detailedresultstripboxwithresult\" id=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\" style=\"display:none;min-height: 330px;\">\r\n\t\t\t\t\t\r\n\t\t\t\t</div>\r\n\t\t\t\t<!--INLINE POP UP RESULT ---- >\r\n\t\t\t\t\r\n\t\t\t\t<!-- popup result -->\r\n\t\t\t\t<div id=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\" class=\"popupContainerStyle\"  style=\"visibility: hidden;\">\r\n\t\t\t\t\t<div id=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\" class=\"popupResultContentStyle\"  style=\"visibility: hidden;\">\r\n\t\t\t\t\t</div>\r\n\t\t\t\t</div>\r\n\t\t\t\t\r\n\t\t\t\t\r\n\t\t\t\t<!--  Result Box01 -->\r\n\t\t\t\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\r\n\t\t\t\t\r\n\t\t\t</div>\r\n  \t\t</div>\r\n  \t\t<br>\r\n  \t\t";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\t\r\n\t\t <div class=\"innerrow\" id=\"moreResultDiv\">\r\n   \t\t \t<div id=\"MoreResult\">\r\n   \t\t \t\t<span><a onclick=\"showMoreResults()\" class=\"moreresultsbtn\" >Click for more \r\n   \t\t \t\t</a></span>\r\n   \t\t \t</div>\r\n\t\t</div>\t\t\r\n\t\t\r\n\t\t";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\r\n\t\t\r\n\t\t</div>\r\n\t\t</div>\r\n\t</div>\r\n\t</div>\r\n\t</div>\r\n\t</div> \r\n</div>\r\n       <!-- #Content Area-->\r\n        \r\n\t</div>\r\n    <!-- #content-->\t\t\r\n\t\t\t\t\r\n\t\t\t\t\r\n\r\n  \r\n  <input type=\"hidden\" id=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\" value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\"/>\r\n  <input type=\"hidden\" id=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\"/>\r\n</form>  \r\n  \r\n  <!-- <div id=\"testdivstyle\"> Test div </div> -->\r\n  ";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\r\n    <!-- #content-->\r\n\t<div class=\"Footerbg\"  style=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\">\r\n        <div id=\"poweredby\">\r\n       \t <p class=\"poweredby\">Powered by <img src=\"../../images/csc.png\" width=\"25\" height=\"14\"></p>\r\n        </div>\r\n\t</div>\r\n</div> <!--  wrapper -->\r\n\r\n</body>\r\n</html>\r\n";
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
		/* orderCategory = ResultConstants.DETAILEDRESULTS_ORDERCATALOGUE_LAB_KEY; */
		orderCategory = "";
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
	fromCalendar.add(Calendar.YEAR, -1);
	if (kendoFromDateString == null) {
		fromDateString = PortalHelper.getDateAsString(
				fromCalendar.getTime(),
				ResultConstants.DETAILEDRESULTS_DATETOSTRING_FORMAT);
		kendoFromDateString = PortalHelper.getDateAsString(
				fromCalendar.getTime(),
				ResultConstants.DETAILEDRESULTS_KENDOUI_DATE_FORMAT);
		//fromDateString = "28/11/2012";
	} else {
		fromDateObj = PortalHelper.getDateFromString(
				kendoFromDateString,
				ResultConstants.DETAILEDRESULTS_KENDOUI_DATE_FORMAT);
		if (fromDateObj == null) {
			fromDateObj = fromCalendar.getTime();
			kendoFromDateString = PortalHelper
					.getDateAsString(
							fromDateObj,
							ResultConstants.DETAILEDRESULTS_KENDOUI_DATE_FORMAT);
		} else {
			fromCalendar.setTime(fromDateObj);
		}
		fromDateString = PortalHelper.getDateAsString(fromDateObj,
				ResultConstants.DETAILEDRESULTS_DATETOSTRING_FORMAT);
	}

	String kendoToDateString = request
			.getParameter(ResultConstants.DETAILEDRESULTS_TODATE_REQUEST_PARAM_KEY);
	String toDateString = kendoToDateString;
	Date toDateObj = new Date();
	if (kendoToDateString == null) {
		kendoToDateString = PortalHelper.getDateAsString(toDateObj,
				ResultConstants.DETAILEDRESULTS_KENDOUI_DATE_FORMAT);
		/* toDateString = PortalHelper.getDateAsString(toDateObj,
				ResultConstants.DETAILEDRESULTS_DATETOSTRING_FORMAT); */
		//toDateString = "27/12/2012";
	}
	toDateString = PortalHelper.getDateAsString(toDateObj,
			ResultConstants.DETAILEDRESULTS_DATETOSTRING_FORMAT);

	// code added to get the initial reset value from request
	// if this value is "Y" then we should not apply the date filter
	// we should simply get the first N records
	String initialResetValue = request
			.getParameter(ResultConstants.DETAILEDRESULTS_INITIALRESET_REQUEST_PARAM_KEY);
	if (initialResetValue == null) {
		initialResetValue = ResultConstants.DETAILEDRESULTS_DEFAULT_INITIALRESET_VALUE;
	}
	// just reset the date string values
	// as when user traverses to this page then only some N number of records
	// should be shown - user can then apply filter
	if (ResultConstants.DETAILEDRESULTS_DEFAULT_INITIALRESET_VALUE
			.equalsIgnoreCase(initialResetValue)) {
		kendoFromDateString = "";
		kendoToDateString = "";
		fromDateString = "";
		toDateString = "";
	}

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
	// constant to store the number of records to be shown at one instance
	final int TOTALRECORD_COUNT = 4;
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
            out.print( String.valueOf(patientId ));
            _bw.write(_wl_block4Bytes, _wl_block4);

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

   	resultsRequest.setInitialResetValue(initialResetValue);
	resultsRequest.setPortalUserName(PortalConstants.PORTALUSER_REQUEST_PARAM_VALUE);
   /* 	DetailedResultsSvcImpl detailedSvc = new DetailedResultsSvcImpl();
   	detailedSvc.registerService(resultsRequest); */

   	ServiceInvoker detailedResultsServiceInvoker = new DetailedResultsServiceInvoker();
   	detailedResultsServiceInvoker.registerService(resultsRequest);
   	DetailedResultsResponse detailedResultsResponse = (DetailedResultsResponse) detailedResultsServiceInvoker
   			.getDataThroughWebService(resultsRequest);

   	FacilityListRequest facilityListRequest = new FacilityListRequest();
   	facilityListRequest
   			.setPortalUserName(PortalConstants.PORTALUSER_REQUEST_PARAM_VALUE);
   	
   	FacilityListServiceInvoker facilityListServiceInvoker = new FacilityListServiceInvoker();
   	FacilityListResponse facilityListResponse = facilityListServiceInvoker.getDataThroughService(facilityListRequest);
   	
   	/* FacilityListSvcImpl facilityListSvcImpl = new FacilityListSvcImpl(); */
   	//facilityListSvcImpl.registerService(facilityListRequest);
   	/* FacilityListResponse facilityListResponse = (FacilityListResponse) facilityListServiceInvoker
   			.getDataThroughWebService(facilityListRequest);  */
   	/* FacilityListResponse facilityListResponse = facilityListSvcImpl.getFacilityList(facilityListRequest); */
	   	
   	
   
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(ResultConstants.DETAILEDRESULTS_ORDERNUMBER_REQUEST_PARAM_KEY));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(ResultConstants.DETAILEDRESULTS_ORDERNUMBER_REQUEST_PARAM_KEY));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(orderNumber));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(ResultConstants.DETAILEDRESULTS_ORDERCATALOGUE_REQUEST_PARAM_KEY));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(ResultConstants.DETAILEDRESULTS_ORDERCATALOGUE_REQUEST_PARAM_KEY));
            _bw.write(_wl_block10Bytes, _wl_block10);

						if ("".equalsIgnoreCase(orderCatalogue.trim())) {
					
            _bw.write(_wl_block11Bytes, _wl_block11);

						  	} else {
						  
            _bw.write(_wl_block12Bytes, _wl_block12);

					  	}
					  	/* ErrorInfo facilityListErrorInfo = facilityListResponse
					  			.getErrorInfo(); */
					  	List<Facility> facilityList = null;
					  	// if facilities are obtained successfully, show them		
					  	/* if (ErrorInfo.SUCCESS_CODE == facilityListErrorInfo.getErrorCode()) { */
					  	if (facilityListResponse.isSuccessful()) {	
					  		facilityList = facilityListResponse.getFacilityList();
					  		for (Facility facility : facilityList) {
					  			if (orderCatalogue.equalsIgnoreCase(facility
					  					.getFacilityId())) {
					  
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(facility.getFacilityId()));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(facility.getFacilityName()));
            _bw.write(_wl_block15Bytes, _wl_block15);

	                  	} else {
	                  
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(facility.getFacilityId()));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(facility.getFacilityName()));
            _bw.write(_wl_block17Bytes, _wl_block17);

					  	}
					  		}
					  	}
					  
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(ResultConstants.DETAILEDRESULTS_ORDERCATEGORY_REQUEST_PARAM_KEY));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(ResultConstants.DETAILEDRESULTS_ORDERCATEGORY_REQUEST_PARAM_KEY));
            _bw.write(_wl_block10Bytes, _wl_block10);

						if (ResultConstants.DETAILEDRESULTS_ORDERCATALOGUE_LAB_KEY
								.equalsIgnoreCase(orderCategory)) {
					
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(ResultConstants.DETAILEDRESULTS_ORDERCATALOGUE_LAB_KEY));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(ResultConstants.DETAILEDRESULTS_ORDERCATALOGUE_RADIOLOGY_KEY));
            _bw.write(_wl_block21Bytes, _wl_block21);

	                  	} else if(ResultConstants.DETAILEDRESULTS_ORDERCATALOGUE_RADIOLOGY_KEY.equalsIgnoreCase(orderCategory)){
	                  
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(ResultConstants.DETAILEDRESULTS_ORDERCATALOGUE_LAB_KEY));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(ResultConstants.DETAILEDRESULTS_ORDERCATALOGUE_RADIOLOGY_KEY));
            _bw.write(_wl_block24Bytes, _wl_block24);

	                  	}else{
	                  
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(ResultConstants.DETAILEDRESULTS_ORDERCATALOGUE_LAB_KEY));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(ResultConstants.DETAILEDRESULTS_ORDERCATALOGUE_RADIOLOGY_KEY));
            _bw.write(_wl_block21Bytes, _wl_block21);

	                  	}
	                  
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(kendoFromDateString));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(kendoToDateString));
            _bw.write(_wl_block28Bytes, _wl_block28);

			ErrorInfo resultsErrorInfo = detailedResultsResponse.getErrorInfo();
			List<DetailedResult> detailedResultList = detailedResultsResponse
					.getTestResultList();
			// set the list size to the resultCount var
			resultCount = 0;//detailedResultList.size();
			// get the size of the test results - there is no need to check for
			resultCount = detailedResultList != null?detailedResultList.size():0;
			if ((ResultConstants.DETAILEDRESULTS_DEFAULT_INITIALRESET_VALUE
					.equalsIgnoreCase(initialResetValue))
					&& (detailedResultsResponse.isSuccessful())){
				StringBuffer displayInitialMesgBuffer = new StringBuffer();
				displayInitialMesgBuffer.append("Showing ");
				displayInitialMesgBuffer.append(""+resultCount+" records for display. Please select appropriate filters and perform search.");
				//detailedResultsResponse.getTestResultList()
				//String displayInitialMessage = "Showing 4 records for display. Please select appropriate filters and perform search.";
		
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(displayInitialMesgBuffer.toString()));
            _bw.write(_wl_block30Bytes, _wl_block30);

				}
			
            _bw.write(_wl_block31Bytes, _wl_block31);

	   			   	String errorMessage = null;//resultsErrorInfo.getErrorMessage();
	   			   	/* if (ErrorInfo.SUCCESS_CODE != resultsErrorInfo.getErrorCode()) { */
	   			   	if(!detailedResultsResponse.isSuccessful()){
	   			   		errorMessage = detailedResultsResponse.getErrorMessage();	
	   		  
            _bw.write(_wl_block32Bytes, _wl_block32);

		       	out.println(errorMessage);
		       
            _bw.write(_wl_block33Bytes, _wl_block33);

	   				} else {
	   					ResultStatus resultStatus = null;

	   					int counter = 1;
	   					String ordCategory = null;
	   					String imageId = null;
	   					// these vars are used for manipulating the style
	   					// needed for showing GUI elements
	   					String divDisableStyle = "display:block";
	   					String orderCatalogueStyle = "AppointmentNewDoctor";
	   					String practitionerStyle = "AppointmentNewDoctor";
	   					String orderNumberStyle = "contenbold";
	   					String orderNumberLabelStyle = "contenbold";
	   					String resultTypeStyle = "contenbold";
	   					String resultTypeLabelStyle = "contenbold";
	   					String locationStyle = "contenbold";
	   					String locationLabelStyle = "contenbold";
	   					String orderDateStyle = "contenbold";
	   					String orderDateLabelStyle = "contenbold";
	   					// this var will store the style class
	   					// used for showing the result
	   					String stripBoxStyle = "detailedresultstripbox";
	   					final String TESTRESULTID = "testresult";
		   				String resultStripBoxId = null;
		   				final String VIEWRESULTBUTTONID = "viewresultbtn";
		   				String viewResultBtnId = null;
		   				final String POPUPRESULTDIVID = "popupdiv";
		   				String popupResultDivId = null;
		   				final String POPUPRESULTCONTAINERDIVID = "popupcontainerdiv";
		   				String popupContainerDivId = null;
		   				
						// iterate through the results and show them
	   					for (DetailedResult detailedResult : detailedResultList) {
	   						stripBoxStyle = "detailedresultstripbox";
	   						resultStripBoxId = TESTRESULTID;
	   						viewResultBtnId = VIEWRESULTBUTTONID;
	   						popupResultDivId = POPUPRESULTDIVID;
	   						popupContainerDivId = POPUPRESULTCONTAINERDIVID;
	   						if (counter > currentResultCounter) {
	   							divDisableStyle = "display:none";
	   						}

	   						resultStatus = detailedResult.getResultStatus();
	   						if (ResultStatus.COMPLETED == resultStatus) {
	   							stripBoxStyle = "detailedresultstripboxwithresultselected";
	   						}
	   						
	   						resultStripBoxId += counter;
	   			
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(stripBoxStyle ));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(divDisableStyle));
            _bw.write(_wl_block37Bytes, _wl_block37);

				        		ordCategory = detailedResult.getOrderCategory();
				        				imageId = "radiology.png";
				        				if ((ResultConstants.DETAILEDRESULTS_ORDERCATEGORY_LAB_MEDIUM_KEY
				        						.equalsIgnoreCase(ordCategory))
				        						|| (ResultConstants.DETAILEDRESULTS_ORDERCATEGORY_LAB_ALT_MEDIUM_KEY
				        								.equalsIgnoreCase(ordCategory))) {
				        					imageId = "lab.png";
				        				}
				        	
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(imageId));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(orderCatalogueStyle));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(detailedResult.getOrderCatalogue()));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(practitionerStyle));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(detailedResult.getOrderPractitioner()));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(orderNumberLabelStyle));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(orderNumberStyle));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(detailedResult.getOrderNumber()));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(resultTypeLabelStyle));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(resultTypeStyle));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(detailedResult.getOrderCategory()));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(locationLabelStyle));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(locationStyle));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(detailedResult.getLocation()));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(orderDateStyle));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(detailedResult.getDisplayOrderDateValue()));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(detailedResult.getDisplayOrderTimeValue()));
            _bw.write(_wl_block50Bytes, _wl_block50);

						    	if (ResultStatus.COMPLETED == resultStatus) {
						    		viewResultBtnId += counter;
						    		popupResultDivId += counter;
						    		popupContainerDivId += counter;
						    
            _bw.write(_wl_block51Bytes, _wl_block51);
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(viewResultBtnId ));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(detailedResult.getOrderNumber()));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(detailedResult.getOrderCatalogue()));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(detailedResult.getOrderCategory()));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(detailedResult.getOrderDate()));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(counter ));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(viewResultBtnId ));
            _bw.write(_wl_block55Bytes, _wl_block55);

				           		} else {
				           	
            _bw.write(_wl_block56Bytes, _wl_block56);

				           		}
				           	
            _bw.write(_wl_block57Bytes, _wl_block57);

					   if (ResultStatus.COMPLETED == resultStatus) {
						   //resultStripBoxId +=  counter;
						   TestResultCacheManager cacheMgr = TestResultCacheManager.getInstance();
						   cacheMgr.addOrderToPatient(patientId, detailedResult.getOrderNumber());
						   String orderDateString = detailedResult.getOrderDate() + "";
						   //String pageSrc = "./GetTestResult.jsp?orderId="+detailedResult.getOrderNumber()+"&order="+detailedResult.getOrderCatalogue()+"&resultType="+detailedResult.getOrderCategory()+"&orderDate="+order+"&counter="+counter+"&popup=N";
				  
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(resultStripBoxId));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(popupContainerDivId ));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(popupResultDivId ));
            _bw.write(_wl_block61Bytes, _wl_block61);

					   }
					counter++;
						if (counter > 0) {
							orderCatalogueStyle = "AppointmentNewDoctorNormal";
							practitionerStyle = "AppointmentNewDoctorNormal";
							orderNumberStyle = "contentnormal";
							orderNumberLabelStyle = "contentnormal";
							resultTypeStyle = "contentnormal";
							resultTypeLabelStyle = "contentnormal";
							locationStyle = "contentnormal";
							locationLabelStyle = "contentnormal";
							orderDateStyle = "contentnormal";
							orderDateLabelStyle = "contentnormal";
						}

						}// end of for loop
					}
				
            _bw.write(_wl_block62Bytes, _wl_block62);

  			if (resultCount > resultCounter) {
  		
            _bw.write(_wl_block63Bytes, _wl_block63);

			}
		
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(ResultConstants.DETAILEDRESULTS_RESULTCOUNTER_REQUEST_PARAM_KEY));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(ResultConstants.DETAILEDRESULTS_RESULTCOUNTER_REQUEST_PARAM_KEY));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(currentResultCounter));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(ResultConstants.DETAILEDRESULTS_RESULTCOUNT_REQUEST_PARAM_KEY));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(ResultConstants.DETAILEDRESULTS_RESULTCOUNT_REQUEST_PARAM_KEY));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(resultCount));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(ResultConstants.DETAILEDRESULTS_RESULTROWCOUNT_KEY));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(ResultConstants.DETAILEDRESULTS_RESULTROWCOUNT_KEY));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(resultCounter));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(ResultConstants.DETAILEDRESULTS_FROMDATE_REQUEST_PARAM_KEY));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(ResultConstants.DETAILEDRESULTS_FROMDATE_REQUEST_PARAM_KEY));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(kendoFromDateString));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(ResultConstants.DETAILEDRESULTS_TODATE_REQUEST_PARAM_KEY));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(ResultConstants.DETAILEDRESULTS_TODATE_REQUEST_PARAM_KEY));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(kendoToDateString));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(ResultConstants.DETAILEDRESULTS_INITIALRESET_REQUEST_PARAM_KEY));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(ResultConstants.DETAILEDRESULTS_INITIALRESET_REQUEST_PARAM_KEY));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(initialResetValue));
            _bw.write(_wl_block67Bytes, _wl_block67);

  	String footerMarginStyle = "margin-top: 10px;";
  	if (ResultConstants.DETAILEDRESULTS_DEFAULT_INITIALRESET_VALUE
  			.equalsIgnoreCase(initialResetValue)) {
  		footerMarginStyle = "margin-top: 20px;";
  	}
  
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(footerMarginStyle));
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
