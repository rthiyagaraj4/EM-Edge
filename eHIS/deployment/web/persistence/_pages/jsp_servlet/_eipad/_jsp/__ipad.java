package jsp_servlet._eipad._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eCommon.Common.CommonBean;
import eIPAD.IPADConstants;
import java.util.Date;
import java.lang.*;
import java.util.*;
import java.sql.*;
import java.io.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import webbeans.eCommon.ConnectionManager;
import com.ehis.util.*;
import eIPAD.pendingresults.*;

public final class __ipad extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/IPad.jsp", 1709118026912L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "UTF-8".intern();

    private static byte[] _getBytes(java.lang.String block){
        try {
            return block.getBytes(_WL_ORIGINAL_ENCODING);
        } catch (java.io.UnsupportedEncodingException u){
            _WL_ENCODED_BYTES_OK = false;
        }
        return null;
    }

    private final static java.lang.String  _wl_block0 =" \n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<!DOCTYPE html> \n<html> \n<head> \n<title></title>   \n<meta name=\"apple-mobile-web-app-capable\" content=\"yes\" />   \n<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\" />\n<link rel=\"stylesheet\" href=\"../jquery.mobile-1.0a4.1.min.css\" /> \n<script src=\"../jquery-1.5.2.min.js\"></script> \n<script src=\"../jquery.mobile-1.0a4.1.min.js\"></script>\n<script src=\"../js/lib/jquery.touchSwipe.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<!-- <link rel=\"stylesheet\" href=\"../css/iPADNew.css\" /> \n<link rel=\"stylesheet\" href=\"../css/iPADThemeA.css\" />  -->\n<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="/eIPAD/css/mCommon.css\" /> \n<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="/eIPAD/css/iPADThemeA.css\" /> \n<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="/eIPAD/css/mIP.css\" /> \n<style>\n\n.CSTransactionMessage{\n    \n    border-radius: 5px 5px 5px 5px;\n    /*box-shadow: 0 2px 2px 2px #D0D0D0;*/\n    height: 45px;\n    margin-top: 0;\n\topacity: 0.8; \n    position: absolute;\n    text-align: left;\n    width: 95%;\n    z-index: 100;\n}\n</style>\n</head>\n<script>\ndocument.addEventListener(\'touchmove\', function (e) { e.preventDefault(); }, false);\nvar bExpanded = true;\n\nfunction getTotalPageDivHeight(){\n\tvar i = $(\'#divParent\').height();\n\treturn i;\n}\n \nfunction logout()\n{\n\tvar xmlhttp;\n\t\tif (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari\n\t\t\txmlhttp = new XMLHttpRequest();\n\t\t} else {// code for IE6, IE5\n\t\t\txmlhttp = new ActiveXObject(\"Microsoft.XMLHTTP\");\n\t\t}\n\t\txmlhttp.onreadystatechange = function() {\n\t\t\tif (xmlhttp.readyState == 4 && xmlhttp.status == 200) {\n\t\t\t\twindow.location = \"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="/ipadlogin\";\n\t\t\t}\n\t\t}\n\t\txmlhttp.open(\"POST\", \"../jsp/Logoff.jsp\", true);\n\t\txmlhttp.send();\n}\n\n\n\nvar legendsScroll ;\nvar scrollContent1;\nvar IPOpen = false;\nfunction toggleMenu() {\n\tif(IPOpen){\n\t\treturn;\n\t}\nsetTimeout(function () {\n\tif (legendsScroll != null){\n\tlegendsScroll.refresh();}\n\tif (scrollContent1 != null){\n\tscrollContent1.refresh();}\n}, 0);\n\n\tif (bExpanded) {\n\t\t$(\'#divMenu\').animate({\n\t\t\twidth : \"0%\"\n\t\t}, \'slow\');\n\t\t$(\'#divContent\').animate({\n\t\t\twidth : \"100%\"\n\t\t}, \'slow\');\n\t\tdocument.getElementById(\"mb\").style.display = \"none\";\n\t\tdocument.getElementById(\"mh\").style.display = \"none\";\n\t\tdocument.getElementById(\"mc\").style.display = \"none\";\n\t\tbExpanded = false;\n\t} else {\n\t\t$(\'#divMenu\').animate({\n\t\t\twidth : \"2%\"\n\t\t}, \'slow\');\n\t\t$(\'#divContent\').animate({\n\t\t\twidth : \"98%\"\n\t\t}, \'slow\');\n\t\tdocument.getElementById(\"mb\").style.display = \"block\";\n\t\tdocument.getElementById(\"mh\").style.display = \"block\";\n\t\tdocument.getElementById(\"mc\").style.display = \"block\";\n\t\tbExpanded = true;\n\n\t}\n}\nfunction loadwidgets(patientID, episodeId, admitDate, dischargeDateTime,\n\t\tlocnType, locnCode, servicecode,navType) {\n\tdocument.getElementById(\"hdnPatientId\").value = patientID;\n\tdocument.getElementById(\"hdnEpisodeId\").value = episodeId;\n\tdocument.getElementById(\"hdnAdmitDate\").value = admitDate;\n\tdocument.getElementById(\"hdnDischargeDateTime\").value = dischargeDateTime;\n\tdocument.getElementById(\"hdnLocnType\").value = locnType;\n\tdocument.getElementById(\"hdnLocnCode\").value = locnCode;\n\tdocument.getElementById(\"hdnServiceCode\").value = servicecode;\n\tdocument.getElementById(\"hdnNavType\").value = navType;\t\n\tif(navType == \'recordConsent\'){\n\t\tdocument.getElementById(\"frmIcontent\").action = \"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7_0 ="/mobile/charts/consent/RecordConsentInitPatContext\";\n\t}\n\tdocument.getElementById(\"frmIcontent\").submit();\n}\nfunction slideSearchByPat(patientID){\n\t$(\'#frameIP\')[0].contentWindow.slidesfsSearch(patientID); \n}\nfunction clearHdnPatientValue(){\n\t$(\'#frameIP\')[0].contentWindow.clearHdnPatientValue();\n}\nfunction addSpinner(){\n\tvar a = $(\"#spinnerDiv\")\n\t//alert(\"spinner val\"+a.length);\n\tif(a.length ==0)\n\t\t$(\"#divContent\").append(\"<div class=\'loadingCartItem\' id=\'spinnerDiv\'></div>\");\n}\nfunction removeSpinner(){\n\tvar a = $(\"#spinnerDiv\")\n\t//alert(\"spinner val\"+a.length);\n\tif(a.length > 0)\n\t$(\"#spinnerDiv\").remove();\n}\nfunction showTransactionMessage(){\n\t$(\"#transactionMsg\").show();\n\tsetTimeout(function(){\n\t\t$(\"#transactionMsg\").hide();\n\t},5000);\n\t$(\"#transactionMsg\").bind(\'click\',function(){\n\t\t$(this).hide();\n\t});\n}\n$(document).ready(function() {\n\n\t\t\t\t\t//alert($(\".divContent\").height());\n\tvar transactionOccurred = $(\"#transactionOccurred\").val();\n\tif(transactionOccurred == \'true\'){\n\t\tshowTransactionMessage();\n\t}\n\n\t\t\t\t\tvar activePage = document.getElementById(\"hdnActivePage\").value;\n\t\t\t\t\tif (activePage == \'PR\') {\n\t\t\t\t\t\t$(\'#pendingResultsMenuItem\').removeClass(\n\t\t\t\t\t\t\t\t\'normText6-theme\').addClass(\n\t\t\t\t\t\t\t\t\'normText5-theme\');\n\t\t\t\t\t\thideSearchImg();\n\t\t\t\t\t}\n\t\t\t\t\tif (activePage == \'IP\') {\n\t\t\t\t\t\t//addSpinner();\n\t\t\t\t\t\t$(\'#inPatientsMenuItem\').removeClass(\n\t\t\t\t\t\t\t\t\'normText6-theme\').addClass(\n\t\t\t\t\t\t\t\t\'normText5-theme\');\n\t\t\t\t\t\tshowSearchImg();\n\t\t\t\t\t}\n\t\t\t\t\tif(activePage== \'DV\') {\n\t\t\t\t\t\t$(\'#diaryViewMenuItem\').removeClass(\n\t\t\t\t\t\t\'normText6-theme\').addClass(\n\t\t\t\t\t\t\'normText5-theme\');\n                        hideSearchImg();\n\t\t\t\t\t}\n\t\t\t\t\tif (activePage == \'RO\') {\n\t\t\t\t\t\t$(\'#registerOrdersMenuItem\').removeClass(\n\t\t\t\t\t\t\'normText6-theme\').addClass(\n\t\t\t\t\t\t\'normText5-theme\');\n\t\t\t\t\t\thideSearchImg();\n\t\t\t\t\t}\n\n\t\t\t\t\t//On orientation change\n\t\t\t\t\tif (window.DeviceOrientationEvent) {\n\t\t\t\t\t\twindow.addEventListener(\'orientationchange\',\n\t\t\t\t\t\t\t\tmyOrientResizeFunction, false);\n\t\t\t\t\t\t// orientation = Math.abs(window.orientation) === 90 ? \'landscape\' : \'portrait\';\n\t\t\t\t\t}\n\n\t\t\t\t\tfunction myOrientResizeFunction() {\n\t\t\t\t\t\t// alert(Math.abs(window.orientation));\n\t\t\t\t\t\t//alert($(\'#divContent\').height());\n\t\t\t\t\t\tvar orient = Math.abs(window.orientation) === 90 ? \'landscape\'\n\t\t\t\t\t\t\t\t: \'portrait\';\n\t\t\t\t\t\tif (orient == \"landscape\") {\n\t\t\t\t\t\t\tdocument.getElementById(\"frameIP\").contentWindow\n\t\t\t\t\t\t\t\t\t.changeOrientation(orient, $(\'#EMHeader\').height() + $(\'#EMFooter\').height());\n\t\t\t\t\t\t} else {\n\t\t\t\t\t\t\tdocument.getElementById(\"frameIP\").contentWindow\n\t\t\t\t\t\t\t\t\t.changeOrientation(orient, $(\'#EMHeader\').height() + $(\'#EMFooter\').height());\n\t\t\t\t\t\t}\n\t\t\t\t\t\t\tsetIframeSFSHeight();\t\n\n\t\t\t\t\t}\n\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\t$(document).bind(\"swiperight\", \'.sliderSwipe\',function( e ) {\n\t\t\t\t\t\t showSlideSFS();\n\t\t\t\t\t});\n\t\t\t\t});\n\nfunction activePage() {\n\tvar activePage = document.getElementById(\"hdnActivePage\").value;\n\tif (activePage == \'PR\') {\n\t\t$(\'#pendingResultsMenuItem\').removeClass(\'normText6-theme\').addClass(\n\t\t\t\t\'normText5-theme\');\n\t\t$(\'#inPatientsMenuItem\').removeClass(\'normText5-theme\')\n\t\t\t\t.addClass(\'normText6-theme\');\n\t\t$(\'#RecentPatientsMenuItem\').removeClass(\'normText5-theme\')\n\t\t\t\t.addClass(\'normText6-theme\');\n\t\t$(\'#diaryViewMenuItem\').removeClass(\'normText5-theme\')\n\t\t.addClass(\'normText6-theme\');\n\t\t$(\'#registerOrdersMenuItem\').removeClass(\'normText5-theme\')\n\t\t\t\t.addClass(\'normText6-theme\');\n\t}\n\tif (activePage == \'IP\') {\n\t\t$(\'#inPatientsMenuItem\').removeClass(\'normText6-theme\').addClass(\n\t\t\t\t\'normText5-theme\');\n\t\t$(\'#RecentPatientsMenuItem\').removeClass(\'normText5-theme\')\n\t\t\t\t.addClass(\'normText6-theme\');\n\t\t$(\'#pendingResultsMenuItem\').removeClass(\'normText5-theme\')\n\t\t\t\t.addClass(\'normText6-theme\');\n\t\t$(\'#diaryViewMenuItem\').removeClass(\'normText5-theme\')\n\t\t\t\t.addClass(\'normText6-theme\');\n\t\t$(\'#registerOrdersMenuItem\').removeClass(\'normText5-theme\')\n\t\t\t\t.addClass(\'normText6-theme\');\n\t}\n\tif (activePage == \'DV\') {\n\t\t$(\'#inPatientsMenuItem\').removeClass(\'normText5-theme\').addClass(\n\t\t\t\t\'normText6-theme\');\n\t\t$(\'#pendingResultsMenuItem\').removeClass(\'normText5-theme\')\n\t\t\t\t.addClass(\'normText6-theme\');\n\t\t$(\'#RecentPatientsMenuItem\').removeClass(\'normText5-theme\')\n\t\t\t\t.addClass(\'normText6-theme\');\n\t\t$(\'#diaryViewMenuItem\').removeClass(\'normText6-theme\')\n\t\t\t\t.addClass(\'normText5-theme\');\n\t\t$(\'#registerOrdersMenuItem\').removeClass(\'normText5-theme\')\n\t\t\t\t.addClass(\'normText6-theme\');\n\t}\n\tif (activePage == \'RP\') {\n\t\t$(\'#inPatientsMenuItem\').removeClass(\'normText5-theme\').addClass(\n\t\t\t\t\'normText6-theme\');\n\t\t$(\'#pendingResultsMenuItem\').removeClass(\'normText5-theme\')\n\t\t\t\t.addClass(\'normText6-theme\');\n\t\t$(\'#diaryViewMenuItem\').removeClass(\'normText5-theme\')\n\t\t\t\t.addClass(\'normText6-theme\');\n\t\t$(\'#RecentPatientsMenuItem\').removeClass(\'normText6-theme\')\n\t\t\t\t.addClass(\'normText5-theme\');\n\t\t$(\'#registerOrdersMenuItem\').removeClass(\'normText5-theme\')\n\t\t\t\t.addClass(\'normText6-theme\');\n\t}\n\tif (activePage == \'RO\') {\n\t\t$(\'#inPatientsMenuItem\').removeClass(\'normText5-theme\').addClass(\n\t\t\t\t\'normText6-theme\');\n\t\t$(\'#pendingResultsMenuItem\').removeClass(\'normText5-theme\')\n\t\t\t\t.addClass(\'normText6-theme\');\n\t\t$(\'#diaryViewMenuItem\').removeClass(\'normText5-theme\')\n\t\t\t\t.addClass(\'normText6-theme\');\n\t\t$(\'#RecentPatientsMenuItem\').removeClass(\'normText5-theme\')\n\t\t\t\t.addClass(\'normText6-theme\');\n\t\t$(\'#registerOrdersMenuItem\').removeClass(\'normText6-theme\')\n\t\t\t\t.addClass(\'normText5-theme\');\n\t}\n\t\n}\n\nfunction setIframeHeight() {\n\t//On Initial Load change the frame height based on the orientation\n\tvar orientOnLoad = Math.abs(window.orientation) === 90 ? \'landscape\'\n\t\t\t: \'portrait\';\n\t//alert(orientOnLoad);\n\tdocument.getElementById(\"frameIP\").contentWindow\n\t\t\t.changeOrientation(orientOnLoad,$(\'#EMHeader\').height() + $(\'#EMFooter\').height());\n}\nfunction setIframeSFSHeight() {\n\tvar orientOnLoad = Math.abs(window.orientation) === 90 ? \'landscape\'\n\t\t\t: \'portrait\';\n\tdocument.getElementById(\"SlideSfsFrame\").contentWindow\n\t\t\t.changeOrientation(orientOnLoad,$(\'#EMHeader\').height() + $(\'#EMFooter\').height());\n}\nfunction openPendingResults() {\n\t//addSpinner();\n\tdocument.getElementById(\"hdnActivePage\").value = \"PR\";\n\tvar fromPeriodComp = document.getElementById(\"hdnFromPeriod\");\n\tvar fromPeriodVal = \"\";\n\tif (fromPeriodComp) {\n\t\tfromPeriodVal = fromPeriodComp.value;\n\t}\n\n\tvar toPeriodComp = document.getElementById(\"hdnToPeriod\");\n\tvar toPeriodVal = \"\";\n\tif (toPeriodComp) {\n\t\ttoPeriodVal = toPeriodComp.value;\n\t}\n\n\tvar selectedPeriodComp = document.getElementById(\"hdnSelectedPeriod\");\n\tvar selectedPeriod;\n\tif (selectedPeriodComp) {\n\t\tselectedPeriod = selectedPeriodComp.value;\n\t}\n\n\tvar taskApplicabilityComp = document\n\t\t\t.getElementById(\"hdnTaskApplicability\");\n\tvar taskApplicability;\n\tif (taskApplicabilityComp) {\n\t\ttaskApplicability = taskApplicabilityComp.value;\n\t}\n\n\tvar groupbyComp = document.getElementById(\"hdnGroupby\");\n\tvar groupby;\n\tif (groupbyComp) {\n\t\tgroupby = groupbyComp.value;\n\t}\n\tvar caNormalcyIndComp = document.getElementById(\"hdnCANormalcyInd\");\n\tvar caNormalcyInd;\n\tif (caNormalcyIndComp) {\n\t\tcaNormalcyInd = caNormalcyIndComp.value;\n\t}\n\n\tvar pagesrc = \"PendingResultsCriteria.jsp?fromPeriod=\" + fromPeriodVal\n\t\t\t+ \"&toPeriod=\" + toPeriodVal;\n\tpagesrc = \"PendingResults-newUI.jsp?hdnFromPeriod=\" + fromPeriodVal\n\t\t\t+ \"&hdnToPeriod=\" + toPeriodVal + \"&hdnGetTaskApplicability=\"\n\t\t\t+ taskApplicability + \"&hdnGroupby=\" + groupby\n\t\t\t+ \"&hdnNormalcyVal=\" + caNormalcyInd + \"&hdnSelectedPeriod=\"\n\t\t\t+ selectedPeriod;\n\tdocument.getElementById(\"frameIP\").src = pagesrc;\n\tactivePage();\n}\nfunction openIPResults() {\n\t//addSpinner();\n\tdocument.getElementById(\"hdnActivePage\").value = \"IP\";\n\t\tdocument.getElementById(\"frameIP\").src = \"IPList-newUI.jsp\";\n\t// document.getElementById(\"frameIP\").src = \"IPListSlideSfsFilter.jsp\"; \n\tactivePage();\n\t$(\'#sfsSearchImg\').show();\n\t$(\'.sliderSwipe\').show();\n}\n\nfunction openRecentPatients() {\n\t//addSpinner();\n\tdocument.getElementById(\"hdnActivePage\").value = \"RP\";\n\t\tdocument.getElementById(\"frameIP\").src = \"IPRecentPatients.jsp\";\n\t// document.getElementById(\"frameIP\").src = \"IPListSlideSfsFilter.jsp\"; \n\tactivePage();\n\t$(\'#sfsSearchImg\').hide();\n\t$(\'.sliderSwipe\').hide();\n}\nfunction openDiaryView() {\t\n\t//addSpinner();\n\t//$(\"#PageLoadingAnimation\").show();\n\tdocument.getElementById(\"hdnActivePage\").value = \"DV\";\n\tdocument.getElementById(\"frameIP\").src = \"DiaryView.jsp\";\n\t$(\"#PageLoadingAnimation\").hide();\n\tactivePage();\n\t$(\'#sfsSearchImg\').hide();\n\t$(\'.sliderSwipe\').hide();\n}\nfunction showErrorWindow(msg){\n\tshowMezzaineWindow();\n\t$(\"#ErrorMessageTxt\").html(msg);\n\t$(\"#Error_Window\").css(\"display\",\"block\");\n\t$(\"#dvMez\").data(\"popid\",\"Error_Window\");\n}\nfunction showMezzaineWindow()\n{\n\t$(\'#dvMez\').css(\"display\",\"block\");\n\tsetTimeout(function() {\n\t\t$(\"#dvMez\").click(closeMezzaineWindow);\n\t}, 500);\n}\nfunction closeMezzaineWindow()\n{\n\t$(\"#dvMez\").css(\"display\",\"none\");\n\tvar popid = $(\"#dvMez\").data(\"popid\");\n\t$(\"#\"+popid).hide();\n\t$(\"#dvMez\").data(\"popid\",\"\");\n\t$(\"#dvMez\").unbind( \"click\" )\n}\nfunction closeErrorPop(){\n\tcloseMezzaineWindow();\n\t$(\"#Error_Window\").hide();\n\t$(\"#dvMez\").data(\"popid\",\"\");\n\t$(\"#ErrorMessageTxt\").html(\"\");\n}\nfunction openSearchWindow(){\n\tdocument.getElementById(\"sfsFrame\").src=\"IPSlideSFS.jsp\";\t\n}\nfunction showsfs()\n{\n\t//document.getElementById(\"sfs\").style.display = \"none\";\n\t//var e = event.originalEvent; \n\t//alert( $(obj).scrollTop());\n\t//alert(e.touches[0].pageY);\n\tdocument.getElementById(\"sfsFrame\").src = \"IPSlideSFS.jsp\";\n\t$(\"#sfs\").css(\'z-index\', \"1000\");\n\t$(\"#sfsarrow\").css(\'z-index\',\"1000\");\n\t$(\'#sfs\').toggle();\n\t$(\'#sfsarrow\').toggle();\n\t//document.getElementById(\"frame1\").src = \"popup1.html\";\n\t//window.parent.show();\n}\nfunction showSlideSFS(){\n\t$(\"#SlideSfs\").show();\n\t$(\"#mb\").hide();\n\t$(\"#SlideSFSOpener\").hide();\n\t$(\".sliderSwipe\").hide();\n\tIPOpen = true;\n\t\n}\nfunction refresh(){\n\n\tdocument.getElementById(\"frameIP\").src = \"IPList-newUI.jsp\"; \n\n}\nfunction hideSlideSFS(){\n\tvar count = document.getElementById(\"hdnRecCount\").value;\n\tif(count == 0){\n\t\tdocument.getElementById(\'SlideSfsFrame\').contentWindow.refreshMain();\n\t\topenIPResults();\n\t}\n\t$(\"#SlideSfs\").hide();\n\t$(\"#mb\").show();\n\t$(\"#SlideSFSOpener\").show();\n\t$(\".sliderSwipe\").show();\n\t\n\tif(bExpanded){\n\t\t$(\'#divMenu\').animate({\n\t\t\twidth : \"2%\"\n\t\t}, \'slow\');\n\t\t$(\'#divContent\').animate({\n\t\t\twidth : \"98%\"\n\t\t}, \'slow\');\n\t\tdocument.getElementById(\"mb\").style.display = \"block\";\n\t\tdocument.getElementById(\"mh\").style.display = \"block\";\n\t\tdocument.getElementById(\"mc\").style.display = \"block\";\n\t}else{\n\t\t$(\'#divMenu\').animate({\n\t\t\twidth : \"0%\"\n\t\t}, \'slow\');\n\t\t$(\'#divContent\').animate({\n\t\t\twidth : \"100%\"\n\t\t}, \'slow\');\n\t\tdocument.getElementById(\"mb\").style.display = \"none\";\n\t\tdocument.getElementById(\"mh\").style.display = \"none\";\n\t\tdocument.getElementById(\"mc\").style.display = \"none\";\n\t}\n\tI";
    private final static byte[]  _wl_block7_0Bytes = _getBytes( _wl_block7_0 );

    private final static java.lang.String  _wl_block7_1 ="POpen = false;\n}\nfunction showSearchImg(){\n\t$(\'#sfsSearchImg\').show();\n}\nfunction hideSearchImg(){\n\t$(\'#sfsSearchImg\').hide();\n}\nfunction hideRows(arrSP,arrPR,arrNU){\n\tdocument.getElementById(\'frameIP\').contentWindow.hideRows(arrSP,arrPR,arrNU);\n}\nfunction selectedPract(val, desc, dPage){\n\tdocument.getElementById(\'frameIP\').contentWindow.selectedPract(val, desc, dPage);\n\t$(\"#hdnSfsPractitionerId\").val(val);\n\t$(\"#hdnSfsPractitionerDesc\").val(desc);\n}\nfunction updateIPCount(ipCount){\n\tdocument.getElementById(\"hdnRecCount\").value = ipCount;\n\t $(\"#ipListCount\").empty();\n\t if(ipCount == 0){\n\t\t $(\"#ipListCount\").append(\'000\');\n\t }\n\t else if(ipCount < 10){\n\t \t\t$(\"#ipListCount\").append(\'00\'+ipCount);\n\t }\n\t else if(ipCount < 100){\n\t \t\t$(\"#ipListCount\").append(\'0\'+ipCount);\n\t }else{\n\t\t \t$(\"#ipListCount\").append(ipCount);\n\t }\n}\n//Added Against KDAH-CRF-0517 (Register Order) Starts\nfunction registerOrders() {\t\n\tdocument.getElementById(\"hdnActivePage\").value = \"RO\";\n\tdocument.getElementById(\"frameIP\").src = \"RegisterOrderList.jsp\"; \n\tactivePage();\n\t$(\'#sfsSearchImg\').hide();\n\t//$(\'.sliderSwipe\').show();\n}\n//Added Against KDAH-CRF-0517 (Register Order) Ends\n</script>\n<style>\n\n/*---CSS for error pop up Starts---*/\n.absoluteCenter {\n  margin: auto;\n  position: absolute;\n  top: 0; left: 0; bottom: 0; right: 0;\n}\n#Error_Window {\n\twidth: 325;\n\theight: 200px;\n\tborder: 2px solid #ffffff;\n\tbackground: #074860;\n\tmin-height: 200px;\n\tmax-width: 325px;\n\tbox-sizing: border-box;\n\t-moz-box-sizing: border-box;\n\t-webkit-box-sizing: border-box;\n\t-webkit-box-shadow: 0px 0px 15px 2px rgba(0,0,0,0.75);\n\t-moz-box-shadow: 0px 0px 15px 2px rgba(0,0,0,0.75);\n\tbox-shadow: 0px 0px 15px 2px rgba(0,0,0,0.75);\n\tborder-radius: 10px;\n\tbox-sizing: border-box;\n\t-moz-box-sizing: border-box;\n\t-webkit-box-sizing: border-box;\n\toverflow: hidden;\n\tz-index:100;\n}\n.top_shadow {\n\twidth: 100%;\n\theight: 90px;\n\tbackground: #3b6f81; /* Old browsers */\n\tbackground: -moz-radial-gradient(center, ellipse cover, #3b6f81 0%, #074860 64%); /* FF3.6+ */\n\tbackground: -webkit-gradient(radial, center center, 0px, center center, 100%, color-stop(0%, #3b6f81), color-stop(64%, #074860)); /* Chrome,Safari4+ */\n\tbackground: -webkit-radial-gradient(center, ellipse cover, #3b6f81 0%, #074860 64%); /* Chrome10+,Safari5.1+ */\n\tbackground: -o-radial-gradient(center, ellipse cover, #3b6f81 0%, #074860 64%); /* Opera 12+ */\n\tbackground: -ms-radial-gradient(center, ellipse cover, #3b6f81 0%, #074860 64%); /* IE10+ */\n\tbackground: radial-gradient(ellipse at center, #3b6f81 0%, #074860 64%); /* W3C */\nfilter: progid:DXImageTransform.Microsoft.gradient( startColorstr=\'#3b6f81\', endColorstr=\'#074860\', GradientType=1 ); /* IE6-9 fallback on horizontal gradient */\n\tmargin-top: -40px;\n\tmargin-top: -240px;\n\tz-index: -999;\n}\n.Error_msg_box {\n\twidth: 100%;\n\theight: 150px;\n\tmax-height: 150px;\n\tmax-width: 100%;\n\tborder-bottom: 1px solid #000000;\n}\n.Error_msg_btn {\n\twidth: 100%;\n\theight: 49px;\n\tbackground: #2ea3c0; /* Old browsers */\n\tbackground: -moz-linear-gradient(top, #2ea3c0 0%, #2195b0 50%, #0c7f9a 51%, #0c7d9a 100%); /* FF3.6+ */\n\tbackground: -webkit-gradient(linear, left top, left bottom, color-stop(0%, #2ea3c0), color-stop(50%, #2195b0), color-stop(51%, #0c7f9a), color-stop(100%, #0c7d9a)); /* Chrome,Safari4+ */\n\tbackground: -webkit-linear-gradient(top, #2ea3c0 0%, #2195b0 50%, #0c7f9a 51%, #0c7d9a 100%); /* Chrome10+,Safari5.1+ */\n\tbackground: -o-linear-gradient(top, #2ea3c0 0%, #2195b0 50%, #0c7f9a 51%, #0c7d9a 100%); /* Opera 11.10+ */\n\tbackground: -ms-linear-gradient(top, #2ea3c0 0%, #2195b0 50%, #0c7f9a 51%, #0c7d9a 100%); /* IE10+ */\n\tbackground: linear-gradient(to bottom, #2ea3c0 0%, #2195b0 50%, #0c7f9a 51%, #0c7d9a 100%); /* W3C */\nfilter: progid:DXImageTransform.Microsoft.gradient( startColorstr=\'#2ea3c0\', endColorstr=\'#0c7d9a\', GradientType=0 ); /* IE6-9 */\ndisplay:table;\n}\n.Error_msg {\n\theight: 150px;\n\twidth: 100%;\n\toverflow: auto;\n\tz-index: 999999;\n\tposition: relative;\n\tdisplay: table;\n}\n.Error_msg_Frame {\n\tdisplay: table-cell;\n\tvertical-align: middle\n}\n.Error_icon\n{\n\twidth:60px;\n\theight:100%;\n\tfloat:left;\n\ttext-align:right;\n\t\n}\n.Error_cont\n{\n\twidth: 260px;\n\theight:100%;\n\tfloat:left;\n\tfont-family:Arial, Helvetica, sans-serif;\n\tfont-size:12px;\n\tfont-weight:bold;\n\tcolor:#ffffff;\n\ttext-align:center;\n\tpadding-top: 10px;\n\ttext-shadow: none;\n}\n.Error_btn_div\n{\n\twidth:0px;\n\theight:100%;\n\tborder-left:1px solid #0bb5dd;\n\tborder-right:1px solid #023542;\n\tfloat: left;\n}\n.Error_btn_div_con\n{\n\twidth:159px;\n\theight:100%;\n\tfont-family:Arial, Helvetica, sans-serif;\n\tfont-size:12px;\n\tfont-weight:bold;\n\tcolor:#ffffff;\n\ttext-align:center;\t\n\tdisplay: table-cell;\n\tvertical-align: middle;\n\tcursor:pointer;\n\t\n}\n.Error_btn_div_con_single\n{\n\twidth:100%;\n\theight:100%;\n\tfont-family:Arial, Helvetica, sans-serif;\n\tfont-size:12px;\n\tfont-weight:bold;\n\tcolor:#ffffff;\n\ttext-align:center;\t\n\tdisplay: table-cell;\n\tvertical-align: middle;\n\tcursor:pointer;\n}\n.blurPopup\n{\n\tposition:absolute;\n\tz-index : 3;\n\tleft : 0px;\n\ttop : 0px;\n\twidth : 100%;\n\theight : 100%;\n\tbackground-color : #808080;\n\topacity : 0.6;\n\tdisplay : none;\n\t\n}\n.slideSfsOpener\n{\n\tposition:absolute;\n\tz-index:1000;\n\ttop: calc(100%/2); \n}\n.sliderSwipe{\n\tposition: absolute;\n\twidth: 20px;\n\theight: 100%;\n\tz-index:999;\n}\n\n#PageLoadingAnimation{\n\tz-index: 10000;\n\tposition: absolute;\n\tleft: 0px;\n\ttop: 0px;\n\twidth: 100%;\n\theight: 100%;\n\tbackground-color: #808080;\n\topacity: 0.6;\n\tbackground-image: url(";
    private final static byte[]  _wl_block7_1Bytes = _getBytes( _wl_block7_1 );

    private final static java.lang.String  _wl_block8 ="/eIPAD/images/Loading24x24.gif);\n\tbackground-repeat: no-repeat;\n\tbackground-position: 50% 50%;\n\tdisplay: none; \n}\n/*---CSS for error pop up Ends---*/\n</style>\n</head>\n<body>\n\t<div id=\"divParent\" class = \"mdivParent\" data-role=\"page\">\n\t  <form id=\"frmIcontent\" name = \"frmIcontent\" method = \"post\" class=\"mform\" action = \"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="/setpatientcontext\">\n\t\t <div id=\"divTable\" class = \"mdivTable\" data-role = \"none\">\n\t\t \t<div data-role = \"none\" class = \"mheaderRow\" id=\"EMHeader\"><!-- header starts -->\n\t\t\t\t\t<table class=\"mheader grd1-theme\" border = \"0\" cellspacing = \"0\" cellpadding = \"0\">\n\t\t\t        <tr style = \"width:100%;height:100%\">\n\t\t\t\t\t\t<td style = \"width:90%;height:100%\" align = \"left\" ><span class=\"mheaderText headerText1-theme\">";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =" - ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</span></td>\n\t\t\t\t\t\t<td style = \"width:10%;height:100%\" valign = \"center\" align = \"right\" onclick = \"logout()\">\n\t\t\t\t\t\t\t<img src = \"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="/eIPAD/images/Logout1.png\" class=\"mHeaderImgLogout\" ></img>\n\t\t\t\t\t\t</td>\n\t\t\t        </tr>\n\t\t       </table>\n\t\t   </div><!-- div first row header ends  -->\n\t\t   \n\t\t   <div data-role = \"none\" class = \"ipContentRow bg1-theme\"><!-- second row starts -->\n\t\t   <div data-role = \"none\" style=\"display:table-cell\">\n\t\t\t   \t<div data-role = \"none\" style=\"display:table;height:100%;width:100%\">\n\t\t\t   \t   \t<div data-role = \"none\" style=\"display:table-row\">\n\t\t\t\t\t\t<div class=\"sliderSwipe\" ></div>\n\t                     <div onclick=\"showSlideSFS()\" class=\"slideSfsOpener\" id=\"SlideSFSOpener\">\n\t                    <img id=\"sfsSearchImg\" src = \"../images/Open_window.png\" /></div> \n\t\t\t\t\t   \t<div class = \"ipdivMenu bg1-theme\" id = \"divMenu\" data-role = \"none\" >\n\t\t\t\t\t   \t  <div class = \"ipmenuBody bg2-theme\" id = \"mb\"><!-- menu body starts here -->\n\t\t\t\t\t\t   \t<div class = \"ipmenuHeader grd4-theme ipmenuHeaderBorder-theme\" data-role = \"none\" id = \"mh\">\n\t\t\t\t\t\t\t        <span class = \"ipmenuHeaderPageTitle headingText2-theme\">Menu</span>\n\t\t\t\t\t\t\t</div> <!-- menu header ends here -->\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<div class = \"ipmenucontainer border4-theme\" data-role = \"none\" id = \"mc\">\n\t\t\t\t\t\t\t      <div class = \"ipmenuGroup grd5-theme border4TopBottom-theme\" data-role = \"none\">\n\t\t\t\t\t\t\t       <table style = \"width:100%;height:100%\" cellspacing = \"0\" cellpadding = \"0\" border = \"0\">\n\t\t\t\t\t\t\t          <tr style = \"width:100%;height:100%\">\n\t\t\t\t\t\t\t            <td class = \"ipmenuIConTd\" valign = \"center\" align = \"center\">\n\t\t\t\t\t\t\t              <img src = \"../images/iCON01.png\"></img>\n\t\t\t\t\t\t\t            </td>\n\t\t\t\t\t\t\t             <td class = \"ipmenuBigTd\" align =\"left\" valign = \"center\">\n\t\t\t\t\t\t\t             <span class = \"ipspanMenuGroup normText4-theme\">My Patients</span>\n\t\t\t\t\t\t\t            </td>\n\t\t\t\t\t\t\t          </tr>\n\t\t\t\t\t\t\t        </table>\n\t\t\t\t\t\t\t      </div>\n\t\t\t\t\t\t\t      <div class = \"ipmenuItems menuItemBox-theme\" data-role = \"none\" onclick=\"openIPResults()\">\n\t\t\t\t\t\t\t        <table style = \"width:100%;height:100%\" cellspacing = \"0\" cellpadding = \"0\" border = \"0\">\n\t\t\t\t\t\t\t          <tr style = \"width:100%;height:100%\">\n\t\t\t\t\t\t\t            <td class = \"ipmenuIConTd\" valign = \"center\" align = \"center\">\n\t\t\t\t\t\t\t              <img src = \"../images/iCON.png\"></img>\n\t\t\t\t\t\t\t            </td>\n\t\t\t\t\t\t\t             <td class = \"ipmenuBigTd\" align =\"left\" valign = \"center\">\n\t\t\t\t\t\t\t             <span class = \"normText6-theme ipMenuItemTxt\" id=\"inPatientsMenuItem\">In Patients</span>\n\t\t\t\t\t\t\t            </td>\n\t\t\t\t\t\t\t            <td class = \"ipmenuSmallTd\" valign = \"center\" align = \"left\">\n\t\t\t\t\t\t\t             <div data-role =\"none\" id=\"ipListCount\" class = \"btn5-theme ipCountButton normText3-theme\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</div>\n\t\t\t\t\t\t\t            </td>\n\t\t\t\t\t\t\t          </tr>\n\t\t\t\t\t\t\t        </table>\n\t\t\t\t\t\t\t      </div>\t\n\t\t\t\t\t\t\t      <!-- <div class = \"ipmenuItems menuItemBox-theme\" data-role = \"none\" onclick=\"openRecentPatients()\">\n\t\t\t\t\t\t\t        <table style = \"width:100%;height:100%\" cellspacing = \"0\" cellpadding = \"0\" border = \"0\">\n\t\t\t\t\t\t\t          <tr style = \"width:100%;height:100%\">\n\t\t\t\t\t\t\t            <td class = \"ipmenuIConTd\" valign = \"center\" align = \"center\">\n\t\t\t\t\t\t\t              <img src = \"../images/iCON.png\"></img>\n\t\t\t\t\t\t\t            </td>\n\t\t\t\t\t\t\t             <td class = \"ipmenuBigTd\" align =\"left\" valign = \"center\">\n\t\t\t\t\t\t\t             <span class = \"normText6-theme ipMenuItemTxt\" id=\"RecentPatientsMenuItem\">Recently Accessed Patients</span>\n\t\t\t\t\t\t\t            </td>\n\t\t\t\t\t\t\t          </tr>\n\t\t\t\t\t\t\t        </table>\n\t\t\t\t\t\t\t      </div> -->\t\t\t\t\t\t\t      \n\t\t\t\t\t\t\t      <div class = \"ipmenuGroup grd5-theme border4TopBottom-theme\" data-role = \"none\">\n\t\t\t\t\t\t\t         <table style = \"width:100%;height:100%\" cellspacing = \"0\" cellpadding = \"0\" border = \"0\">\n\t\t\t\t\t\t\t          <tr style = \"width:100%;height:100%\">\n\t\t\t\t\t\t\t            <td class = \"ipmenuIConTd\" valign = \"center\" align = \"center\">\n\t\t\t\t\t\t\t              <img src = \"../images/iCON01.png\"></img>\n\t\t\t\t\t\t\t            </td>\n\t\t\t\t\t\t\t             <td class = \"ipmenuBigTd\" align =\"left\" valign = \"center\">\n\t\t\t\t\t\t\t             <span class = \"ipspanMenuGroup normText4-theme\">My Tasks</span>\n\t\t\t\t\t\t\t            </td>\n\t\t\t\t\t\t\t          </tr>\n\t\t\t\t\t\t\t        </table>\n\t\t\t\t\t\t\t      </div>\n\t\t\t\t\t\t\t      \n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\t\n\t\t\t\t\t\t\t      <div class = \"menuItems menuItemBox-theme\" data-role = \"none\">\n\t\t\t\t\t\t\t           <table style = \"width:100%;height:100%\" cellspacing = \"0\" cellpadding = \"0\">\n\t\t\t\t\t\t\t          <tr style = \"width:100%;height:100%\" id=\"diaryView\" onclick=\"openDiaryView()\">\n\t\t\t\t\t\t\t            <td class = \"ipmenuIConTd\" valign = \"center\" align = \"center\">\n\t\t\t\t\t\t\t             <img src = \"../images/iCON.png\"></img>\n\t\t\t\t\t\t\t            </td>\n\t\t\t\t\t\t\t             <td class = \"ipmenuBigTdp\" valign = \"center\" align = \"left\">\n\t\t\t\t\t\t\t           \n\t\t\t\t\t\t\t              <span class = \"normText6-theme ipMenuItemTxt\" id=\"diaryViewMenuItem\">My Diary</span>\n\t\t\t\t\t\t\t            </td>\n\t\t\t\t\t\t\t          </tr>\n\t\t\t\t\t\t\t         </table>\n\t\t\t\t\t\t\t          </div>\n\t\t\t\t\t\t\t         <div class = \"menuItems menuItemBox-theme\" data-role = \"none\">\n\t\t\t\t\t\t\t        <table style = \"width:100%;height:100%\" cellspacing = \"0\" cellpadding = \"0\">\n\t\t\t\t\t\t\t          <tr style = \"width:100%;height:100%\" id=\"pendingResults\" onclick=\"openPendingResults()\">\n\t\t\t\t\t\t\t            <td class = \"ipmenuIConTd\" valign = \"center\" align = \"center\">\n\t\t\t\t\t\t\t             <img src = \"../images/iCON.png\"></img>\n\t\t\t\t\t\t\t            </td>\n\t\t\t\t\t\t\t             <td class = \"ipmenuBigTdp\" valign = \"center\" align = \"left\">\n\t\t\t\t\t\t\t           \n\t\t\t\t\t\t\t              <span class = \"normText6-theme ipMenuItemTxt\" id=\"pendingResultsMenuItem\">Pending Results Review</span>\n\t\t\t\t\t\t\t            </td>\n\t\t\t\t\t\t\t            <td class = \"ipmenuSmallTd\" valign = \"center\" align = \"left\">\n\t\t\t\t\t\t\t             <div data-role =\"none\" class = \"btn5-theme ipCountButton normText3-theme\"> ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</div>\n\t\t\t\t\t\t\t            </td>\n\t\t\t\t\t\t\t            \n\t\t\t\t\t\t\t          </tr>\n\t\t\t\t\t\t\t        </table>\n\t\t\t\t\t\t\t      </div>\n\t\t\t\t\t\t\t      \n\t\t\t\t\t\t\t      <!-- Added Against KDAH-CRF-0517 (Register Order) Starts-->\n\t\t\t\t\t\t\t      <div class = \"menuItems menuItemBox-theme\" data-role = \"none\">\n\t\t\t\t\t\t\t           <table style = \"width:100%;height:100%\" cellspacing = \"0\" cellpadding = \"0\">\n\t\t\t\t\t\t\t          <tr style = \"width:100%;height:100%\" id=\"\" onclick=\"registerOrders()\">\n\t\t\t\t\t\t\t            <td class = \"ipmenuIConTd\" valign = \"center\" align = \"center\">\n\t\t\t\t\t\t\t             <img src = \"../images/iCON.png\"></img>\n\t\t\t\t\t\t\t            </td>\n\t\t\t\t\t\t\t             <td class = \"ipmenuBigTdp\" valign = \"center\" align = \"left\">\n\t\t\t\t\t\t\t           \n\t\t\t\t\t\t\t              <span class = \"normText6-theme ipMenuItemTxt\" id=\"registerOrdersMenuItem\">Register Orders</span>\n\t\t\t\t\t\t\t            </td>\n\t\t\t\t\t\t\t          </tr>\n\t\t\t\t\t\t\t         </table>\n\t\t\t\t\t\t\t      </div>\n\t\t\t\t\t\t\t      <!-- Added Against KDAH-CRF-0517 (Register Order) Ends-->\n\t\t\t\t\t\t\t      \n\t\t\t\t\t\t    </div><!-- menu container ends here -->\n\t\t\t\t\t   \t  </div><!-- menu body end here -->\n\t\t\t\t\n\t\t\t\t\t   \t    <!-- Slide SFS popup STARTS -->\n\t\t\t\t\t   \t  \t<div data-role = \"none\"  id = \"SlideSfs\" style=\"position:relative;width:230px;height:100%;background:white;display:none\">\n  \t \t\t\t\t\t\t\t<iframe id = \"SlideSfsFrame\" frameborder=\"0\"  scrolling =\"no\" height = \"100%\" width = \"100%\" src = \"IPSlideSFS.jsp\"></iframe>  \n  \t \t\t\t\t\t\t\t\n   \t\t\t\t\t\t\t</div>\n   \t\t\t\t\t\t\t<!-- Slide SFS popup ENDS -->\n\t\t\t\t\t   \t</div> <!-- div menu end here -->\n\t\t\t\t\t   \t<div class = \"mdivContent bg1-theme\" id = \"divContent\"> <!-- div content starts here -->\n\t\t                       <div class = \"ipframeContainer\" id = \"contentWrapper\">\n\t\t                       \t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t                               <iframe frameborder=\"0\" id = \"frameIP\" class = \"ipframe\" scrolling =\"no\" src = \"IPList-newUI.jsp\"></iframe>\n\t                             ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t                             \t<iframe frameborder=\"0\" id = \"frameIP\" class = \"ipframe\" scrolling =\"no\" src = \"DiaryView.jsp\"></iframe>\n\t                             ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t                             <!-- Transaction message -->\n\t\t\t\t\t\t\t\t<div class=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =" CSTransactionMessage\" id=\"transactionMsg\" style=\"bottom: 10px; left: 10px; display: none\">\n\t\t\t\t\t\t\t\t\t<div class=\"formValErrorMsgTheme\" id = \"transactionMessageContent\">";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</div>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t<!-- End of Transaction message -->\n\t                          </div>\n\t\t                </div> <!-- div content end here -->\n\t\t                \n\t\t\t\t   \t</div><!-- div content holder ends here -->\n\t\t\t   \t</div><!-- pagContent content end here -->\n\t\t\t   \t\n\t\t\t   \t</div>\n\t\t   </div><!-- div second row rends here -->\n\t\t   \n\t\t   <div data-role = \"none\" class = \"mfooter\" id=\"EMFooter\" ><!-- Footer start  -->\n\t\t      <div class = \"mfooterContent border3Top-theme grd3-theme\" data-role = \"none\">\n\t\t\t     <table style = \"width:100%;height:100%\" border = \"0\" cellspacing = \"0\" cellpadding = \"0\">\n\t\t\t\t        <tr style = \"width:100%;height:100%\">\n\t\t\t\t\t          <td style = \"width:50%;height:100%\" valign = \"top\">\n\t\t\t\t\t            <table style = \"width:100%;height:100%\" border = \"0\" cellspacing = \"0\" cellpadding = \"0\">\n\t\t\t\t\t            \t<tr style = \"width:100%;height:50%\">\n\t\t\t\t\t            \t  <td style = \"width:100%;height:100%\" valign = \"top\" align = \"left\">\n\t\t\t\t\t            \t    <span class=\"mfooterUserInfo cpyRightTxt-theme\">";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</span>\n\t\t\t\t\t            \t  </td>\n\t\t\t\t\t            \t</tr>\n\t\t\t\t\t            \t<tr style = \"width:100%;height:50%\">\n\t\t\t\t\t            \t<td style = \"width:100%;height:100%\" valign = \"top\" align = \"left\">\n\t\t\t\t\t            \t  <span class=\"mfooterUserInfo cpyRightTxt-theme\">";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="-";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</span>\n\t\t\t\t\t            \t  </td>\n\t\t\t\t\t            \t</tr>\n\t\t\t\t\t            </table>\n\t\t\t\t\t          </td>\n\t\t\t\t\t          <td style = \"width:50%;height:100%\" align = \"right\" valign = \"top\">\n\t\t\t\t\t          <span class=\"mcopyrightsText cpyRightTxt-theme\"></span>\n\t\t\t\t\t         <img src=\"../images/CSC_Logo.png\" class=\"mimgCopyRights\"></img>\n\t\t\t\t\t          </td>\n\t\t\t\t\t          \n\t\t\t\t        </tr>\n\t\t\t       </table>\n\t\t\t   </div>    \n\t\t   </div><!-- div footerends here -->\n\t\t   \n\t\t </div> <!-- div table ends here -->\n\t\t <input type = \"hidden\" name = \"hdnPatientId\" id = \"hdnPatientId\" value = \"\" />\n\t\t<input type = \"hidden\" name = \"hdnEpisodeId\" id = \"hdnEpisodeId\" value = \"\" />\n\t\t<input type = \"hidden\" name = \"hdnAdmitDate\" id = \"hdnAdmitDate\" value = \"\" />\n\t\t<input type = \"hidden\" name = \"hdnDischargeDateTime\" id =  \"hdnDischargeDateTime\" value = \"\" />\n\t\t<input type = \"hidden\" name = \"hdnLocnType\" id =  \"hdnLocnType\" value = \"\" />\n\t\t<input type = \"hidden\" name = \"hdnLocnCode\" id =  \"hdnLocnCode\" value = \"\" />\n\t\t<input type = \"hidden\" name = \"hdnServiceCode\" id =  \"hdnServiceCode\" value = \"\" />\n\t\t<input type = \"hidden\" name = \"hdnNavType\" id =  \"hdnNavType\" value = \"\" />\n\t\t<input type=\"hidden\" name=\"hdnPatClass\" id=\"hdnPatClass\" id=\"hdnPatClass\" value=\"IP\"/>\n\t\t<input type = \"hidden\" name =\"hdnRecCount\" id =\"hdnRecCount\" value = \"1\"/>\n\t\t\n\t\t\t<!-- This is added for sending the from and to period in pending review results page -->\n\t\t<input type=\"hidden\" name=\"hdnFromPeriod\" id=\"hdnFromPeriod\" id=\"hdnFromPeriod\" value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\"/>\n\t\t<input type=\"hidden\" name=\"hdnToPeriod\" id=\"hdnToPeriod\" id=\"hdnToPeriod\" value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\"/>\n\t\t<input type=\"hidden\" name=\"hdnTaskApplicability\" id=\"hdnTaskApplicability\" id=\"hdnTaskApplicability\" value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\"/>\n\t\t<input type=\"hidden\" name=\"hdnGroupby\" id=\"hdnGroupby\" id=\"hdnGroupby\" value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\"/>\n\t\t<input type=\"hidden\" name=\"hdnCANormalcyInd\" id=\"hdnCANormalcyInd\" id=\"hdnCANormalcyInd\" value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\"/>\n\t\t<input type=\"hidden\" name=\"hdnSelectedPeriod\" id=\"hdnSelectedPeriod\" id=\"hdnSelectedPeriod\" value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\"/>\n\t\t<input type=\"hidden\" name=\"hdnMainPageURL\" id=\"hdnMainPageURL\" id=\"hdnMainPageURL\" value=\"\"/>\n\t\t<input type=\"hidden\" name=\"hdnParams\" id=\"hdnParams\" id=\"hdnParams\" value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\"/>\n\t\t<input type=\"hidden\" name=\"hdnPatClass\" id=\"hdnPatClass\" id=\"hdnPatClass\" value=\"IP\"/>\n\t\t<input type=\"hidden\" name=\"hdnHideIcon\" id=\"hdnHideIcon\" id=\"hdnHideIcon\" value=\"\"/>\n\t\t<input type=\"hidden\" name=\"hdnActivePage\" id=\"hdnActivePage\" id=\"hdnActivePage\" value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\"/>\n\t\t<input type=\"hidden\" name=\"transactionOccurred\" id=\"transactionOccurred\" id=\"transactionOccurred\" value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\"/>\n\t\t<input type=\"hidden\" name=\"hdnSfsPractitionerId\" id=\"hdnSfsPractitionerId\" id=\"hdnSfsPractitionerId\" value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\"/>\n\t\t<input type=\"hidden\" name=\"hdnSfsPractitionerDesc\" id=\"hdnSfsPractitionerDesc\" id=\"hdnSfsPractitionerDesc\" value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\"/>\n\t\t </form>\n\t\t <!-- Pop up  starts here -->\n\t\t <div data-role = \"none\" id = \"dvMez\" class = \"blurPopup\" data-popid=\"\"></div>\n\t\t <div id=\"Error_Window\" class=\"absoluteCenter\" style=\"display:none\">\n\t\t\t<div class=\"Error_msg_box\">\n\t\t\t  <div class=\"Error_msg\">\n\t\t\t    <div class=\"Error_msg_Frame\">\n\t\t\t      <div>\n\t\t\t        <div class=\"Error_icon\"><img src=\"../images/PopWarning.png\" width=\"30\" height=\"30\" /></div>\n\t\t\t        <div class=\"Error_cont\" id=\"ErrorMessageTxt\" data-role=\"none\"></div>\n\t\t\t      </div>\n\t\t\t    </div>\n\t\t\t  </div>\n\t\t\t</div>\n\t\t\t<div class=\"Error_msg_btn\">\n\t\t\t    <div class=\"Error_btn_div_con_single\" onclick=\"closeErrorPop()\">OK</div>\n\t\t\t</div>\n\t\t\t<div class=\"top_shadow\"> </div>\n\t\t</div> \n\t\t \n\t\t <!-- Pop up  ends here -->\n\t</div><!-- div parent ends here -->\n\t<div id=\"PageLoadingAnimation\" class=\"absoluteCenter\"></div>\n</body>\n</html>\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

String path = request.getContextPath(); 
String product_description = "";
String version_no = "";
String activePage=request.getParameter("ActivePage")==null?"DV":request.getParameter("ActivePage");


if(request.getParameter("hdnActivePage")!= null)
{
	activePage =  request.getParameter("hdnActivePage");
	if(activePage.trim().equals(""))
	{
		activePage="IP";
	}
}

String formValErrClass = "";
String transactionMessage = "";
String transactionResult = "";
String transactionOccurred = "false";
if(request.getParameter("transactionOccurred") != null && request.getParameter("transactionOccurred").equals("true")){
	transactionOccurred = request.getParameter("transactionOccurred") == null?"":request.getParameter("transactionOccurred");
	transactionMessage = request.getParameter("transactionMessage") == null?"":request.getParameter("transactionMessage");
	transactionResult = request.getParameter("transactionResult") == null?"":request.getParameter("transactionResult");
	if(transactionResult.equals("0")){ 
		formValErrClass= "formValSuccessTheme";
	}
	else{
		formValErrClass= "formValErrorTheme";
	}
}
request.setCharacterEncoding("UTF-8");
Connection con = null;
PreparedStatement pstmt=null,pstmt1=null; 
ResultSet rset =null,rsip=null,rset1=null;
Statement stmt = null,stmt1 = null;
String strIPCount = "";
// this code is added specifically for pending results for review 
String fromPeriod="";
String toPeriod="";
String selectedPeriod=IPADConstants.LAST_ONE_WEEK;
StringBuffer sqlipcount = new StringBuffer("");

// code modified to get the request parameters in the flow
// of pending results review
String params = request.getQueryString();
params = CommonBean.checkForNull(params);

if(session.getAttribute("version_no") != null)
{
	version_no = (String)session.getAttribute("version_no");
}
if(session.getAttribute("product_description") != null)
{
	product_description = (String)session.getAttribute("product_description");
}


try{
	String facility_id= (String)session.getValue("facility_id");
    String login_user= (String)session.getValue("login_user");
    String facility_name = "";
    String jdbc_user =  "";
	String jdbc_user_id="";
	String site = "" ;
	if(login_user == null)
	{
		login_user = "";
	}
	String strFromdate = DateUtils.getCurrentDate("DMY", "en");
	String sql= "select func_role_id, AM_GET_DESC.AM_PRACTITIONER(a.func_role_id,?,'1') practitioner_name, pract_type,'N' TAB_MENU_YN , (select c.ESTABLISH_RELN_REQ_YN from ca_encntr_param c ) reln_req_yn from sm_appl_user a, am_practitioner b where b.practitioner_id=a.func_role_id and appl_user_id = ? and func_role ='P' ";
    String func_role_id="",practitioner_name="",pract_type="";
    con =  ConnectionManager.getConnection(request);
    if(con != null)
    pstmt=con.prepareStatement(sql);
    
    String locale = "en";
    if(pstmt != null)
    {
		pstmt.setString(1,locale);
		pstmt.setString(2,login_user);
		
		rset=pstmt.executeQuery();
    }
	
	if(rset !=null && rset.next())
    {
		func_role_id=rset.getString("func_role_id");
		if(func_role_id == null) func_role_id="";
        
		practitioner_name=rset.getString("practitioner_name");
		if(practitioner_name == null) practitioner_name="";
		
		pract_type = rset.getString("pract_type");
		if(pract_type == null) pract_type="";

    }
	if(rset !=null) rset.close();
	if (pstmt!=null) pstmt.close();
	
	 session.putValue("ca_practitioner_id",func_role_id);
	 session.putValue("practitioner_name",practitioner_name);
	 session.putValue("practitioner_type",pract_type);
	 
	 if(con != null)
	 stmt = con.createStatement();
	 
	 rset = null;
	// site = "hi";
	 if(stmt != null)
	 {
	   rset = stmt.executeQuery("SELECT SITE_NAME,DISPLAY_USER_NAME_YN FROM SM_SITE_PARAM_LANG_VW WHERE LANGUAGE_ID = '"+locale+"' and 'Y' = (SELECT DISPLAY_SITE_NAME_YN FROM SM_FACILITY_PARAM WHERE FACILITY_ID = '"+facility_id+"')") ;//Changed  for PE By Sudhakar
	   //site = "hello";
	 }
	 
	 
	 
	 String display_user_name_yn = "";		 
		if(rset !=null)	{
			if(rset.next()) {
				site = rset.getString("SITE_NAME");
				display_user_name_yn= rset.getString("DISPLAY_USER_NAME_YN");//Changed  for PE By Sudhakar
				
			}
		}
		session.putValue("userSite",site);	
		if(rset !=null) rset.close();
		if (stmt!=null) stmt.close();
		
	    if(con != null)
		pstmt=con.prepareStatement( "SELECT (SELECT FACILITY_NAME FROM SM_FACILITY_PARAM_LANG_VW WHERE LANGUAGE_ID = ? and facility_id=?)FACILITY_NAME,APPL_USER_NAME,APPL_USER_ID FROM SM_APPL_USER_LANG_VW WHERE LANGUAGE_ID = ? and APPL_USER_ID=?" );
	    
	    
		if(pstmt != null)
		{
			pstmt.setString(1,locale);
			pstmt.setString(2,facility_id);
			pstmt.setString(3,locale);
			pstmt.setString(4,login_user);
			rset = pstmt.executeQuery();
		}
		

		if(rset !=null)	{
			if(rset.next()) {
				jdbc_user = rset.getString("APPL_USER_NAME");
				jdbc_user_id = rset.getString("APPL_USER_ID");
				facility_name = rset.getString("FACILITY_NAME");
			}
		}
		session.putValue("facility_name",facility_name);
		session.putValue("jdbc_user",jdbc_user);
		if(rset!=null)rset.close();
		if(pstmt!=null)pstmt.close();
		
/* sqlipcount.append("SELECT COUNT (*) Total FROM ip_open_encounter a WHERE a.facility_id = '"+facility_id+"' AND attend_practitioner_id = '"+func_role_id+"' AND patient_class = 'IP'  AND adt_status IN ('00', '01')  AND EXISTS ( SELECT patient_class FROM ca_pract_by_locn_detail o  WHERE facility_id = '"+facility_id +"' AND practitioner_id = '"+ func_role_id +"' ");
sqlipcount.append(" AND locn_type = 'W' AND patient_class = 'IP' AND EXISTS ( SELECT 1   FROM pr_encounter a, mp_patient mp_p WHERE NVL (mp_p.suspend_yn, '*') != 'Y'  AND mp_p.patient_id = a.patient_id  AND a.assign_care_locn_code = o.locn_code AND a.facility_id = o.facility_id AND a.patient_class = o.patient_class AND a.attend_practitioner_id = '"+ func_role_id +"' AND (a.adt_status IN ('01', '02')))) ");
 */		
sqlipcount.append("select count(*) count from IP_OPEN_ENCOUNTER a Where a.facility_id ='"+facility_id+"' AND  ATTEND_PRACTITIONER_ID='"+func_role_id+"' AND PATIENT_CLASS='IP' AND ADT_STATUS IN ('01','02') ");
//this condition is added to find whether the ESTABLISH_RELN_REQ_YN is "Y" and if equal to "Y" then only the patients who have a legitimate relationship with the practitioner will be displayed in the IP List
sqlipcount.append("and case when (Select nvl(ESTABLISH_RELN_REQ_YN ,'N') ESTABLISH_RELN_REQ_YN from CA_ENCNTR_PARAM) = 'Y' then (select count(*) from CA_ENCNTR_PRACT_RELN where facility_id=a.facility_id and NVL(ENCOUNTER_ID,0) = NVL(a.ENCOUNTER_ID,0) and practitioner_id = a.ATTEND_PRACTITIONER_ID and patient_id=a.patient_id AND NVL(STATUS,'01')='01' AND nvl(end_date_time,to_date('31/12/3000','DD/MM/YYYY')) BETWEEN SYSDATE AND  nvl(end_date_time,to_date('31/12/3000','DD/MM/YYYY')) AND BEGIN_DATE_TIME<SYSDATE) else 1 end > 0");
if(con != null)
{
	 stmt1 = con.createStatement();
}
		
		if(stmt1 != null)
		{
			rsip = stmt1.executeQuery(sqlipcount.toString());
		}
		if(rsip != null)
		{
			
			if(rsip.next())
			{
				
				strIPCount = rsip.getString("count");
				if(strIPCount != null )
				{
	                if(strIPCount.length() == 1)
					{
	                	strIPCount = "00" + strIPCount;
					}
	                if(strIPCount.length() == 2)
					{
	                	strIPCount = "0" + strIPCount;
					}
				}
			
			}
			rsip.close();
			if ( stmt1 != null ) stmt1.close() ;
			session.putValue("practitioner_id",func_role_id);
			
		}		
	 					
    

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(path));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(path));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(path));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(path));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(path));
            _bw.write(_wl_block7_0Bytes, _wl_block7_0);
            _bw.write(_wl_block7_1Bytes, _wl_block7_1);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(path));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(product_description));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(version_no));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(path));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(strIPCount));
            _bw.write(_wl_block13Bytes, _wl_block13);

									// the below code is for pending review results
									PendingResults pendingResults = new PendingResults();
									// initialize the request and set it with data
									PendingResultsCountRequest countRequest = new PendingResultsCountRequest();
									countRequest.setRequest(request);
									countRequest.setSession(session);
									countRequest.setPractitionerId(func_role_id);
									Calendar cal = Calendar.getInstance();
									Date toDate = cal.getTime();
									cal.add(Calendar.DATE, -7);
									Date fromDate = cal.getTime();
									countRequest.setFromDate(fromDate);
									countRequest.setToDate(toDate);
									
									// get the response
									PendingResultsCountResponse countResponse = pendingResults.getPendingResultsCount(countRequest);
									// process the response
									Map<PendingResultCategory, Integer> pendingResultCountMap = countResponse.getPendingResultCountMap();
									int totalPendingResults = 0;
									
									if(pendingResultCountMap != null){
										PendingResultCategory pendingResultCategory = new PendingResultCategory(
												PendingResultCategory.TOTAL_CATEGORY);
										Object totalCount = pendingResultCountMap.get(pendingResultCategory);
										Set<PendingResultCategory> keySet = pendingResultCountMap.keySet();
										if(keySet != null){
											Iterator<PendingResultCategory> itr = keySet.iterator();
											if(itr != null){
												while(itr.hasNext()){
													pendingResultCategory = itr.next();
													if(PendingResultCategory.TOTAL_CATEGORY.equals(pendingResultCategory.getCategoryName())){
														totalCount = pendingResultCountMap.get(pendingResultCategory);
														break;
													}
												}
											}
										}
										if(totalCount instanceof Integer){
											totalPendingResults = ((Integer)totalCount).intValue();
										}
									}
									
									// code added to get the task applicability value
									// which is passed to the pending results screen
									String taskApplicability = "";
									TaskApplicablityRequest taskRequest = new TaskApplicablityRequest();
									taskRequest.setMenu("VIEW_CONF_RESULT");
									taskRequest.setRequest(request);
									taskRequest.setSession(session);
									String resp_id = (String)session.getValue("responsibility_id");
									if(resp_id== null){
										resp_id = "";
									}
									taskRequest.setResponsibilityId(resp_id);
									String practRelationId = "";// this is the value passed in desktop app also
									taskRequest.setPract_relationId(practRelationId);
									
									TaskApplicabilityResponse taskResponse = pendingResults.getTaskApplicability(taskRequest);
									taskApplicability = taskResponse.getMenuValue();
									
									// this variable is of use for showing pending results
									// in desktop application also, the group by value is being passed as "P"
									// to pending results screen
									String groupBy = "P";
									// this refers to the normalcy index which is passed to the pending results
									// screen
									String ca_normalcy_ind = "Z";		
									String strTotalPendingResults = "" + totalPendingResults;
									
					                if(strTotalPendingResults.length() == 1)
									{
					                	strTotalPendingResults = "00" + strTotalPendingResults;
									}
					                if(strTotalPendingResults.length() == 2)
									{
					                	strTotalPendingResults = "0" + strTotalPendingResults;
									}
									
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(strTotalPendingResults));
            _bw.write(_wl_block15Bytes, _wl_block15);
if(activePage.equals("IP")){ 
            _bw.write(_wl_block16Bytes, _wl_block16);
}else{ 
            _bw.write(_wl_block17Bytes, _wl_block17);
} 
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(formValErrClass ));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(transactionMessage ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(jdbc_user_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(facility_name ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(site));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(fromPeriod));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(toPeriod));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(taskApplicability));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(groupBy));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(ca_normalcy_ind));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(selectedPeriod));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(params));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(activePage));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(transactionOccurred ));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(func_role_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(practitioner_name));
            _bw.write(_wl_block34Bytes, _wl_block34);


}
    catch(Exception e){
		e.printStackTrace();
		out.println("Exception in Ipad.jsp"+e.toString());
    }
    finally{
        if (rset !=null) rset.close();
		if (pstmt!=null) pstmt.close();
		if (stmt!=null) stmt.close();
		if (rsip!=null) rsip.close();
		if (stmt1!=null) stmt1.close();
        if (con !=null) ConnectionManager.returnConnection(con,request);
		

    }

            _bw.write(_wl_block35Bytes, _wl_block35);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
