package jsp_servlet._eipad._jsp._chartwidgets;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.ResourceBundle;
import java.util.*;
import com.google.gson.*;
import eIPAD.chartsummary.common.response.*;
import eIPAD.chartsummary.vitals.response.*;
import eIPAD.chartsummary.vitals.healthobject.*;

public final class __vitalschart extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/chartwidgets/VitalsChart.jsp", 1738426251091L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n<!DOCTYPE html>\n<html>\n<head>\n   <meta name=\"apple-mobile-web-app-capable\" content=\"yes\" />\n   <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\" />\n   <link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="/eIPAD/jquery.mobile-1.0.1.min.css\" />\n   <link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="/eIPAD/css/kendo.dataviz.min.css\" />\n\t<script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script>\n   <script src=\"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="/eIPAD/kendo.dataviz.min.js\"></script>\n   <script src=\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="/eIPAD/console.js\"></script>\n   \n   <link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="/eIPAD/css/iPADThemeA.css\" />\n   <link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="/eIPAD/css/iPADNew.css\" />\n   <script type=\"application/javascript\" src=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="/eIPAD/js/iscroll.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<style>\n\n\n\n\n</style>\n<script>\n   document.addEventListener(\'touchmove\', function (e) { e.preventDefault(); }, false);\n   document.addEventListener(\'DOMContentLoaded\', vitalsChartScroll, false);\n   var vitalsScroll ;\n   var screenOrienttation = \"landscape\";\n   var chartWidth = 670;\n   var chartHeight = 462; // to hold the height of the chart container.\n   var arrEventCode = []; // to hold the list of event codes for line chart.\n   var arrXAxis = []; // to hold the x axis values for the selected discrete measure.\n   var arrYAxis = []; // to hold the y axis values for the selected discrete measure. \n   var arrEventCodeIndex = []; // to hold the index of the event code;\n   function changeOrientation(orient, EMHFheight)\n   {\n\t   \tvar CSHFheight = $(\'#allergyHeader\').height();\n\t   \tHFheight = EMHFheight;\n\t   \tscreenOrienttation = orient;\n\t   \tvar content_height = parent.getTotalPageDivHeight() - EMHFheight - CSHFheight-6 ;\n\t   \tdocument.getElementById(\"divcnt\").style.height = content_height+\"px\";\n\t   \n\t   \tif(screenOrienttation == \"landscape\") // to display the sfs based on the orientation\n\t\t {\n\t\t\t \n\t\t\t$(\'#lineChartContainer\').css(\"left\" , \"15%\");\n\t\t\t$(\'#lineChartContainer\').css(\"top\" , \"15%\");\n\t\t }\n\t\t else\n\t\t {\n\t\t     $(\'#lineChartContainer\').css(\"left\" , \"2%\");\t\n\t\t     $(\'#lineChartContainer\').css(\"top\" , \"20%\");\n\t\t }\n\t\tassignVitalsColumnWidth();\n\t    scrollRefresh();\n\t   // assignLineChartTop();\n   }\n   function assignVitalsColumnWidth() // to assign the spark line chart columns during loading and orientation change so that the kendo chart is made to fit for the repective screen size\n   {\n\t    var vitalsTableWidth = 0;\n\t    $(\"[data-id = \'table\']\").each(function(index, value) { \n\t    \tvitalsTableWidth = $(this).width();\n\t\t });\n\t    var remainingWidth = vitalsTableWidth - 120;\n\t    var col1Width = remainingWidth * 0.25 + \"px\";\n\t    var col2Width = remainingWidth * 0.75 + \"px\";\n\t    $(\"[data-id = \'col1\']\").each(function(index, value) { \n\t\t\t $(this).css(\"width\" , col1Width);\n\t\t });\n\t    $(\"[data-id = \'col2\']\").each(function(index, value) { \n\t\t\t $(this).css(\"width\" , col2Width);\n\t\t });\n\t    $(\"[data-id = \'col3\']\").each(function(index, value) { \n\t\t\t $(this).css(\"width\" , \"120px\");\n\t\t });\n   }\n   function vitalsChartScroll() {\n\t\t setTimeout(function () {\n\t\t\t vitalsScroll = new iScroll(\'divcnt\', {\n\t\t\tuseTransform: true,\n\t\t\tzoom: false,\n\t\t\tonBeforeScrollStart: function (e) {\n\t\t\tvar target = e.target;\n\t\t\twhile (target.nodeType != 1) target = target.parentNode;\n\n\t\t\tif (target.tagName != \'SELECT\' && target.tagName != \'INPUT\' && target.tagName != \'TEXTAREA\' && target.tagName != \'DIV\')\n\t\t\te.preventDefault();\n\t\t\t}\n\t\t\t});\n\t}, 1000); \n}\n   function scrollRefresh()\n   {\n    \tif(vitalsScroll != null)\n   \t\t   vitalsScroll.refresh();\n   }\n   $(document).ready(function () {\n\t   parent.setOnLoadContentPaneHeight();\n   });\n   function cancelTransaction(){\n\t\tvar path = document.getElementById(\"hdnPath\").value + \"/mobile/chartsummary/ChartWidgetsView\";\n\t\twindow.parent.document.getElementById(\'ChartSummaryIframe\').src = path;\n\t}\n   function showMezzaineWindow() // this function is used to show the mezzaine window.\n   {\n   \t\t$(\'#dvMez\').css(\"display\",\"block\");\n   \t\tsetTimeout(function() {\n   \t\t\t$(\"#dvMez\").on(\"click\",closeMezzaineWindow);\n   \t\t}, 500);\n   }\n   function closeMezzaineWindow()\n   {\n   \t\t$(\'#dvMez\').css(\"display\",\"none\");\n   \t\t$(\"#dvMez\").off();\n   \t\tvar popid = $(\"#dvMez\").data(\"popid\");\n\t\t$(\"#\"+popid).hide();\n   \t\t$(\"#dvMez\").data(\"popid\",\"\");\n   \t\n   }\n   function closeLineChart()\n   {\n\t   closeMezzaineWindow();\n\t   $(\'#dvLineChart\').css(\"display\" , \"none\");\n\t   $(\'#lineChartFrame\').attr(\"src\" , \"\");\n\t   \n   }\n   function showLineChartGraph(objContainer) // to show the line chart on clicking of a particular row.\n   {\n\t    showMezzaineWindow();\n\t    $(\'#dvLineChart\').css(\"display\" , \"block\");\n\t    $(\"#dvMez\").data(\"popid\",\"dvLineChart\");\n\t  //  assignLineChartTop();\n\t    if(arrEventCode != null && arrEventCode.length > 0 && arrEventCodeIndex != null && arrEventCodeIndex.length > 0)\n\t\t{\n\t\t\tvar evCode = $(objContainer).attr(\"data-eventCode\");\n\t\t\tvar currentPageNumber = $.inArray(evCode, arrEventCode);\n\t\t\t\tif(currentPageNumber != -1)\n\t\t\t\t{\n\t\t\t\t  var selectedIndex = arrEventCodeIndex[currentPageNumber];\n\t\t\t\t  callLineChart(arrEventCode.length,selectedIndex,evCode,currentPageNumber);\n\t\t\t\t}\n\t\t}\n   }\n   function paginateLineChart(eventCode,action) // function will be called when next and previous arrow buttons are clicked\n   {\n\t  \n\t   if(action == \"Next\")\n\t   {\n\t\t       if(arrEventCode != null && arrEventCode.length > 0  && arrEventCodeIndex != null && arrEventCodeIndex.length > 0)\n\t\t\t   {\n\t\t\t  \t\t var currentPageNumber = $.inArray(eventCode, arrEventCode);\n\t\t\t  \t\t if(currentPageNumber != -1)\n\t\t\t  \t\t {\n\t\t\t  \t\t\tcurrentPageNumber = currentPageNumber + 1;\n\t\t\t  \t\t\t\tif(currentPageNumber < arrEventCodeIndex.length && currentPageNumber < arrEventCode.length && currentPageNumber >= 0)\n\t\t\t  \t\t\t\t{\n\t\t\t  \t\t\t\t\tvar evntCode = arrEventCode[currentPageNumber];\n\t\t\t\t\t\t\t\tvar selectedIndex = arrEventCodeIndex[currentPageNumber];\n\t\t\t\t\t\t\t\tcallLineChart(arrEventCode.length,selectedIndex,evntCode,currentPageNumber);\n\t\t\t  \t\t\t\t}\n\t\t\t  \t\t }\n\t\t\t   }\n\t   }\n\t   if(action == \"Previous\")\n\t   {\n\t\t       if(arrEventCode != null && arrEventCode.length > 0  && arrEventCodeIndex != null && arrEventCodeIndex.length > 0)\n\t\t\t   {\n\t\t\t  \t\t var currentPageNumber = $.inArray(eventCode, arrEventCode);\n\t\t\t  \t\t if(currentPageNumber != -1)\n\t\t\t  \t\t {\n\t\t\t  \t\t\tcurrentPageNumber = currentPageNumber - 1;\n\t\t\t  \t\t\t\tif(currentPageNumber < arrEventCodeIndex.length && currentPageNumber < arrEventCode.length && currentPageNumber>= 0)\n\t\t\t  \t\t\t\t{\n\t\t\t  \t\t\t\t\tvar evntCode = arrEventCode[currentPageNumber];\n\t\t\t\t\t\t\t\tvar selectedIndex = arrEventCodeIndex[currentPageNumber];\n\t\t\t\t\t\t\t\tcallLineChart(arrEventCode.length,selectedIndex,evntCode,currentPageNumber);\n\t\t\t  \t\t\t\t}\n\t\t\t  \t\t }\n\t\t\t   }\n\t   }\n\t   \n   }\n\n   function setAxisArray(rowCount) // to set the x - axis and y - axis value for the selected discrete measure\n   {\n\t  // var XObjArr = JSON.parse($(\"#hdn\" + rowCount).val());\n\t  // var YObjArr = JSON.parse($(\"#hdnDate\" + rowCount).val());\n\t  try\n\t  {\n\t\t  var XObjArr = JSON.parse($(\"#hdnDate\" + rowCount).val()); //JSON.parse($(\"#hdn\" + rowCount).val());\n\t\t   var YObjArr = JSON.parse($(\"#hdn\" + rowCount).val());\n\t\t   clearAxisArray();\n\t\t   \n\t\t   if(XObjArr != null)\n\t\t   {\n\t\t\t\tvar i = 0;\n\t\t\t\tfor(i = 0 ; i < XObjArr.length; i++)\n\t\t\t\t{\n\t\t\t\t\tarrXAxis.push(XObjArr[i].eventDateTime);\t\n\t\t\t\t\t//alert(XObjArr[i].eventDateTime);\n\t\t\t\t}\n\t\t\t\t//alert(arrXAxis.length);\n\t\t   }\n\t\t   else\n\t\t   {\n\t\t\t   arrXAxis = null;\n\t\t\t   arrXAxis = [];\n\t\t   }\n\t\t   if(YObjArr != null)\n\t\t   {\n\t\t\t    var i = 0;\n\t\t\t\tfor(i = 0 ; i < YObjArr.length; i++)\n\t\t\t\t{\n\t\t\t\t\tarrYAxis.push(YObjArr[i].resultNumber);\t\n\t\t\t\t\t//alert(YObjArr[i].eventDateTime);\n\t\t\t\t}  \n\t\t\t\t//alert(arrYAxis.length);\n\t\t   }\n\t\t   else\n\t\t\t   {\n\t\t\t   \t\tarrYAxis = null;\n\t\t\t   \t\tarrYAxis = [];\n\t\t\t   }\n\t  }\n\t  catch(e)\n\t  {\n\t\t//  alert(\"exception\" + e);\n\t  }\n\t  \n   }\n   function clearAxisArray()\n   {\n\t    arrYAxis = null;\n  \t\tarrYAxis = [];\n  \t\tarrXAxis = null;\n\t    arrXAxis = [];\n   }\n   function callLineChart(totalRecords,selectedRecord,selectedEventCode,currentPageNumber)\n   {\n\t    setAxisArray(selectedRecord);\n\t    var desc = $(\'#hdnDesc\' + selectedRecord).val();\n\t    var nl = $(\'#hdnNormalLow\' + selectedRecord).val();\n\t    var nh = $(\'#hdnNormalHigh\' + selectedRecord).val(); \n\t    var UOM = $(\'#hdnUOM\' + selectedRecord).val();\n        var queryString = \"?TR=\" + totalRecords + \"&SR=\" + selectedRecord + \"&SEC=\" + selectedEventCode + \"&TI=\" + UOM+\"&NL=\" + nl + \"&NH=\" + nh+ \"&PNO=\" + currentPageNumber+\"&DESC=\" + desc;\n        var path = $(\'#hdnPath\').val() + \"/eIPAD/jsp/chartwidgets/LineChart.jsp\" + queryString;\n        $(\'#lineChartFrame\').attr(\"src\" , path);\n        \n        \n   }\n   function assignLineChartTop()\n   {\n\t //  $(\'#dvLineChart\').css(\"display\" , \"none\");\n\t   var lineChartTop = calculateLinchartTop() ;\n\t   lineChartTop = lineChartTop + \"px\";\n\t   var lineChartLeft = calculateLineChartLeft();\n\t   lineChartLeft = lineChartLeft + \"px\";\n\t//   $(\'#dvLineChart\').css(\"display\" , \"block\");\n\t   $(\'#lineChartContainer\').css(\"margin-top\", lineChartTop);\n\t   $(\'#lineChartContainer\').css(\"margin-left\", lineChartLeft);\n   }\n   function calculateLineChartLeft()\n   {\n\t   \n\t   var dvLineChartLeft =  $(\'#dvLineChart\').width() -10;\n\t   //alert(dvLineChartLeft);\n\t   var lineChartWidth = dvLineChartLeft - chartWidth;\n\t   var left = 0;\n\t   if(lineChartWidth > 0)\n\t\t   {\n\t\t      left = lineChartWidth / 2;\n\t\t   }\n\t   \n\t   return left;\n   }\n   function calculateLinchartTop()\n   {\n\t  // alert($(\'#dvLineChart\').height());\n\t   var dvLineChartheight = $(\'#dvLineChart\').height();  \n\t   var lineChartHeight = dvLineChartheight - chartHeight;\n\t   var top = 0;\n\t   if(lineChartHeight > 0)\n\t   {\n\t\t\t top = lineChartHeight / 2;  \n\t   }\n\t   return top;\n   }\n   function getXAxis()\n   {\n\t //alert(arrXAxis.reverse());\n\t   return arrXAxis.reverse();\n   }\n   function getYAxis()\n   {\n\t  //alert(arrYAxis.reverse());\n\t   return arrYAxis.reverse();\n   }\n   function getEventCode()\n   {\n\t   return arrEventCode;\n   }\n   function getDesc()\n   {\n\t   \n   }\n   </script>\n</head>\n<body style = \"padding :0px;display : block;margin: 0px; height: 100%; width: 100%;\">\n\t<div id=\"divParent\" class=\"divParent\" data-role=\"page\" style=\"padding: 0px\">\n\t\t<form name=\"frmRecordAllergy\" id=\"frmRecordAllergy\" id=\"frmViewCharts\" style=\"width: 100%; height: 100%\" >\n\t\t     <!-- line chart graph container starts -->\n\t\t     <div data-role = \"none\" id = \"dvMez\" class = \"dvMezzaine\" data-popid=\"\" ></div>\n\t\t\t  <div data-role = \"none\" class = \"dvLineChart\" id = \"dvLineChart\">\n\t\t\t \t<div data-role=\"none\" class=\"lineChartContainer\" id=\"lineChartContainer\">\n\t\t\t\t\t<iframe id=\"lineChartFrame\" frameborder=\"0\" style=\"display: block;\" scrolling=\"no\" src=\"\" class=\"popupIFrame\"></iframe>\n\t\t\t   </div>\n\t\t \t </div> \n\t\t\t <!-- line chart graph container ends -->\n\t\t\t<div id=\"allergyHeader\" class=\"AllergyHeader\" style=\"padding: 0px\"\n\t\t\t\tdata-role=\"none\">\n\t\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" class=\"tbAllergyHeader\"\n\t\t\t\t\tdata-role=\"none\">\n\t\t\t\t\t<tr class=\"normalTr\">\n\t\t\t\t\t\t<td class=\"normalTd\">\n\t\t\t\t\t\t\t<div class=\"RecordAllergyHeader RecordAllergyHeaderTheme\">\n\t\t\t\t\t\t\t\t<div class=\"RecordAllergyTable\">\n\t\t\t\t\t\t\t\t\t<div class=\"normalRow\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyCell\" style=\"width: 99%; text-align: left\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"allergyHeaderPageTitle ipHeaderPageTitleTheme\">";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyCell\" style=\"width: 1%\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"RecordAllergyTable\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"normalRow\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyCell\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"width: auto; text-align: right\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"vitbuttonContainer\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyCell\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"width: auto; text-align: right\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"vitbuttonContainer\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"WidgetButtonTheme\" onclick=\"cancelTransaction()\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="/eIPAD/images/CS_Close16x16.png\"/>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t</div>\n\t\t\t<div id=\"divcnt\" class=\"divAllergyContent divVitalsContentTheme\" style=\"padding: 0px;\" data-role=\"none\">\n\t\t\t\t<div style=\"width: 100%; height: auto; overflow: auto\" data-role=\"none\">\n\t\t\t\t\t<div data-role=\"none\" style=\"width: 100%; height: auto\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-role = \"none\" data-id = \"table\" class = \"vitcontainer\" id = \"container";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" data-eventCode = \"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" onclick = \"showLineChartGraph(this)\" data-count = \"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t \t<div data-role = \"none\" data-id = \"col1\" class = \"vitCol1 vitalsDescription\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t \t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t \t<div data-role = \"none\" data-id = \"col2\" class = \"vitCol2\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t  <div data-role = \"none\" style = \"position:relative;overflow:hidden;width:100%;direction: rtl; height:100px\" id=\"vitalsChart";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\"></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t \t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t \t<div data-role = \"none\" data-id = \"col3\" class = \"vitCol3\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t<div data-role = \"none\"  class = \"currrentVitalsContainer currrentVitalsContainerTheme\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t    <div data-role = \"none\" class = \"vitalsIcon\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t    \t<img src = \"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="/eIPAD/images/";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" style = \"position:relative;margin-top:1px\"></img>\n\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t    </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t<div data-role = \"none\" class = \"vitalsValue vitalsValueTheme\" style = \"overflow:hidden\">";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t<div data-role = \"none\" class = \"vitalsUnit vitalsUnitTheme\">";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t<div data-role = \"none\" class = \"vitalsDate vitalsDateTheme\">";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t \t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t  </div> \n\t\t\t\t\t\t\t\t\t\t\t\t  <div class=\"rowDivider\"></div>\n\t\t\t\t\t\t\t\t\t\t\t\t  <input type = \"hidden\" name = \"hdn";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" id = \"hdn";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" value = \'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' />\n\t\t\t\t\t\t\t\t\t\t\t\t  <input type = \"hidden\" name = \"hdnDate";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" id = \"hdnDate";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' />\n\t\t\t\t\t\t\t\t\t\t\t\t  <input type = \"hidden\" name = \"hdnNormalLow";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" id = \"hdnNormalLow";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" value = \"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" />\n\t\t\t\t\t\t\t\t\t\t\t\t  <input type = \"hidden\" name = \"hdnNormalHigh";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" id = \"hdnNormalHigh";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" />\n\t\t\t\t\t\t\t\t\t\t\t\t  <input type = \"hidden\" name = \"hdnDesc";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" id = \"hdnDesc";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" />\n\t\t\t\t\t\t\t\t\t\t\t\t  <input type = \"hidden\" name = \"hdnUOM";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" id = \"hdnUOM";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" />\n\t\t\t\t\t\t\t\t\t\t\t\t  <script>\n\t\t\t\t\t\t\t\t\t\t\t\t  $(document).ready(function () {\n\t\t\t\t\t\t\t\t\t\t\t\t\t  var dataYObj";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =" = JSON.parse($(\"#hdn";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\").val());\n\t\t\t\t\t\t\t\t\t\t\t\t\t  var dataXObj";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =" = JSON.parse($(\"#hdnDate";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\").val());\n\t\t\t\t\t\t\t\t\t\t\t\t\t  var xyData";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 =" = [];\n\t\t\t\t\t\t\t\t\t\t\t\t\t  arrEventCode.push(\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\');\n\t\t\t\t\t\t\t\t\t\t\t\t\t  arrEventCodeIndex.push(";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 =");\n\t\t\t\t\t\t\t\t\t\t\t\t\t  if(dataYObj";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 =" != null)\n\t\t\t\t\t\t\t\t\t\t\t\t\t  {\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tfor(var i = 0 ; i < dataYObj";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 =".length; i++)\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tvar resultNum = dataYObj";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="[i].resultNumber;\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tvar resultD = new Date(dataXObj";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="[i].eventDateTime);\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tvar valueXY";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 =" = [new Date(resultD),resultNum];\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t       \t  xyData";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 =".push(valueXY";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 =");\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t\t\t\t  }\n\t\t\t\t\t\t\t\t\t\t\t\t    \n\t\t\t\t\t\t\t\t\t\t\t\t   \t\t\t\t\t\t\t\t\t\t\t\t\t\t   \n\t\t\t\t\t\t\t\t\t\t\t\t\t  $(\"#vitalsChart";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\").kendoChart({\n\t\t\t\t\t\t\t\t\t\t\t\t      \n\t\t\t\t\t\t\t\t\t\t\t\t           series: [{\n\t\t\t\t\t\t\t\t\t\t\t\t        \t   type: \"scatterLine\",\n\t\t\t\t\t\t\t\t\t\t\t\t        \t   data: xyData";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 =",\n\t\t\t\t\t\t\t\t\t\t\t\t        \t   markers: {\n\t\t\t\t\t\t\t\t\t\t\t\t        \t\t   visible: false \n\t\t\t\t\t\t\t\t\t\t\t\t               }\n\t\t\t\t\t\t\t\t\t\t\t\t        \t   \n\t\t\t\t\t\t\t\t\t\t\t\t           }],\n\t\t\t\t\t\t\t\t\t\t\t\t          \n\t\t\t\t\t\t\t\t\t\t\t\t           xAxis: {\n\t\t\t\t\t\t\t\t\t\t\t\t        \t    type: \"date\",\n\t\t\t\t\t\t\t\t\t\t\t\t        \t    baseUnit: \"months\",\n\t\t\t\t\t\t\t\t\t\t\t\t        \t    visible: false\n\t\t\t\t\t\t\t\t\t\t\t\t        \t  },\n\t\t\t\t\t\t\t\t\t\t\t\t        \n\t\t\t\t\t\t\t\t\t\t\t\t          \n\t\t\t\t\t\t\t\t\t\t\t\t           yAxis: {\n\t\t\t\t\t\t\t\t\t\t\t\t        \t    majorGridLines: {\n\t\t\t\t\t\t\t\t\t\t\t\t        \t      visible: false\n\t\t\t\t\t\t\t\t\t\t\t\t        \t    },\n\t\t\t\t\t\t\t\t\t\t\t\t           visible: false\n\t\t\t\t\t\t\t\t\t\t\t\t        \t  },\n\t\t\t\t\t\t\t\t\t\t\t\t          \n\t\t\t\t\t\t\t\t\t\t\t\t           tooltip: {\n\t\t\t\t\t\t\t\t\t\t\t\t                  visible: true,\n\t\t\t\t\t\t\t\t\t\t\t\t                  format: \"{1}\",\n\t\t\t\t\t\t\t\t\t\t\t\t                   \n\t\t\t\t\t\t\t\t\t\t\t\t              } \n\t\t\t\t\t\t\t\t\t\t\t\t       });\n\t\t\t\t\t\t\t\t\t\t\t\t   });\n\t\t\t\t\t\t\t\t\t\t\t\t  \n\t\t\t\t\t\t\t\t\t\t\t\t  </script>\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t\t\t\t\t    <div data-role = \"none\" class=\"WidgetVwErrContainer\">\n\t\t\t\t\t\t\t   \t\t<div data-role = \"none\" class=\"WidgetErrorResponse WidgetErrorResponseTheme\">\n\t\t\t\t\t\t\t   \t\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\t\t\t\t   \t\t</div>\n\t\t\t\t   \t\t    \t</div>\n\t\t\t\t\t\t\t   ";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t\t\t</div>\n\t\t\t\t</div>\n\t\t\t</div>\n\t\t\t<input type=\"hidden\" name=\"hdnPath\" id=\"hdnPath\" id=\"hdnPath\" value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\" /> \n\t\t</form>\n\t</div>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block0Bytes, _wl_block0);

Locale appLocale;
if(session.getAttribute("LOCALE")!=null && !session.getAttribute("LOCALE").equals(""))
	appLocale = new Locale((String)session.getAttribute("LOCALE"));
else 
	appLocale = new Locale("en");
ResourceBundle csResBundle = ResourceBundle.getBundle("eIPAD.chartsummary.common.resourcebundle.cslabels", appLocale);
VitalsConfigResponse oVitalsConfigResponse = null;
CurrentAndHistoryResponse oCurrentAndHistoryResponse = null;
if(request.getAttribute("VitalsConfigResponse") != null)
{
	oVitalsConfigResponse = (VitalsConfigResponse)request.getAttribute("VitalsConfigResponse");
	
}
if(request.getAttribute("CurrentAndHistoryResponse") != null)
{
	oCurrentAndHistoryResponse = (CurrentAndHistoryResponse)request.getAttribute("CurrentAndHistoryResponse");
}
Gson gson =new GsonBuilder().setDateFormat("yyyy/MM/dd HH:mm:ss").create();

            _bw.write(_wl_block1Bytes, _wl_block1);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(csResBundle.getString("vitals.vitalschartview") ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block10Bytes, _wl_block10);

						if(oVitalsConfigResponse != null && oVitalsConfigResponse.isSuccessResponse() && !oVitalsConfigResponse.isEmptyDataResponse() && oCurrentAndHistoryResponse != null && oCurrentAndHistoryResponse.isSuccessResponse() && !oCurrentAndHistoryResponse.isEmptyDataResponse())
						{
							   int nVitalsConfigList = 0;
							   List<VitalsConfig> listVitalConfig = null;
							   if(oVitalsConfigResponse.getListVitalConfig() != null)
							   {
								   listVitalConfig = oVitalsConfigResponse.getListVitalConfig();
								   if(oVitalsConfigResponse.getListVitalConfig() != null)
								   		nVitalsConfigList = listVitalConfig.size();
							   }
							   
							   if(nVitalsConfigList > 0)
							   {
								   int nVitalsConfigLoopCount = 0;
								   for(nVitalsConfigLoopCount = 0; nVitalsConfigLoopCount < nVitalsConfigList; nVitalsConfigLoopCount++)
								   {
										String eventCode = listVitalConfig.get(nVitalsConfigLoopCount).getDiscreteMeasureId();
										String DiscreteMeasureDescription = listVitalConfig.get(nVitalsConfigLoopCount).getDiscreteMeasureDesc();
										
										CurrentAndHistoryDM oCurrentAndHistoryDM = oCurrentAndHistoryResponse.getDiscreteMeasure(eventCode);
										if( DiscreteMeasureDescription != null &&  DiscreteMeasureDescription.length() > 11)
										{
											 DiscreteMeasureDescription =  DiscreteMeasureDescription.substring(0, 8) + "...";
										}
										if(oCurrentAndHistoryDM != null && oCurrentAndHistoryDM.getCurrentDiscreteValue() != null)
										{
											DiscreteValue oCurrentDiscreteValue = oCurrentAndHistoryDM.getCurrentDiscreteValue();
											String eventDescription = oCurrentAndHistoryDM.getEventDescription();
											if(eventDescription != null && eventDescription.length() > 15)
											{
												eventDescription = eventDescription.substring(0, 12) + "...";
											}
											NormalcyIndicator oNormalcyIndicator = oCurrentAndHistoryDM.getNormalcyIndicator(oCurrentDiscreteValue, "S");
											String iConName = oNormalcyIndicator.getSymbolIndicator();
											if(iConName != null && !iConName.equals(""))
											{
												iConName = "B" + iConName;
											}
											else
											{
												//iConName = "BNodata.PNG";
											}
											String resultValue = "";//oCurrentDiscreteValue.getResultNum();
											if(oCurrentDiscreteValue.getResultNum() != null && oCurrentDiscreteValue.getResultString() != null)
											{
												resultValue = oCurrentDiscreteValue.getResultNum().trim() + oCurrentDiscreteValue.getResultString().trim();
											}
											if(resultValue == null || resultValue.equals(""))
											{
												resultValue = "-----";
											}
											//LineChartAxisContainer oLineChartAxisContainer = oSparkLineDM.getLineChartAxisContainer();
											LineChartAxisContainer oLineChartAxisContainer = oCurrentAndHistoryResponse.getChartValues(oCurrentAndHistoryDM);
											if(oLineChartAxisContainer != null && oLineChartAxisContainer.getoGraphYAxisList() != null && oLineChartAxisContainer.getoGraphYAxisList().size() > 0)
											{
												List<GraphYAxis> lstGraphYAxis = oLineChartAxisContainer.getoGraphYAxisList();
												List<GraphXAxis> lstGraphXAxis = oLineChartAxisContainer.getoGraphXAxisList();
												
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(nVitalsConfigLoopCount));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(eventCode));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(nVitalsConfigLoopCount));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(eventDescription ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(nVitalsConfigLoopCount));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(iConName ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(resultValue));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf( oCurrentAndHistoryDM.getUOM()));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(oCurrentDiscreteValue.getEventDateTime()));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(nVitalsConfigLoopCount));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(nVitalsConfigLoopCount));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(gson.toJson(lstGraphYAxis)));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(nVitalsConfigLoopCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(nVitalsConfigLoopCount));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(gson.toJson(lstGraphXAxis)));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(nVitalsConfigLoopCount));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(nVitalsConfigLoopCount));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(oCurrentAndHistoryDM.getNormalLow() ));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(nVitalsConfigLoopCount));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(nVitalsConfigLoopCount));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(oCurrentAndHistoryDM.getNormalHigh()));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(nVitalsConfigLoopCount));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(nVitalsConfigLoopCount));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf( listVitalConfig.get(nVitalsConfigLoopCount).getDiscreteMeasureDesc()));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(nVitalsConfigLoopCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(nVitalsConfigLoopCount));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf( oCurrentAndHistoryDM.getUOM()));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(nVitalsConfigLoopCount));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(nVitalsConfigLoopCount));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(nVitalsConfigLoopCount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(nVitalsConfigLoopCount));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(nVitalsConfigLoopCount));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(eventCode));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(nVitalsConfigLoopCount));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(nVitalsConfigLoopCount));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(nVitalsConfigLoopCount));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(nVitalsConfigLoopCount));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(nVitalsConfigLoopCount));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(nVitalsConfigLoopCount));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(nVitalsConfigLoopCount));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(nVitalsConfigLoopCount));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(nVitalsConfigLoopCount));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(nVitalsConfigLoopCount));
            _bw.write(_wl_block51Bytes, _wl_block51);
 
											}
										}
								   }
							   }
							   
						}//if
						else
						{
							   StringBuffer strMessage = new StringBuffer("");
							   if(oVitalsConfigResponse != null )
							   {
								   if(oVitalsConfigResponse.getErrorsList() != null)
								   {
									   int size = oVitalsConfigResponse.getErrorsList().size();
									   if(size > 0)
									   {
										   int nErrorCount = 0;
										   for(nErrorCount = 0;nErrorCount < size; nErrorCount++)
										   {
											  // strMessage.append(oVitalsConfigResponse.getErrorsList().get(index))
											  if(oVitalsConfigResponse.getErrorsList().get(nErrorCount) != null)
											  {
												  strMessage.append(oVitalsConfigResponse.getErrorsList().get(nErrorCount).getErrorMessage());
												 // message = message + oVitalsConfigResponse.getErrorsList().get(nErrorCount).getErrorMessage();
											  }
										   }
									   }
								   }
							   }
							   if(oCurrentAndHistoryResponse != null )
							   {
								   if(oCurrentAndHistoryResponse.getErrorsList() != null)
								   {
									   int size = oCurrentAndHistoryResponse.getErrorsList().size();
									   if(size > 0)
									   {
										   strMessage.append("   ");
										   int nErrorCount = 0;
										   for(nErrorCount = 0;nErrorCount < size; nErrorCount++)
										   {
											  // strMessage.append(oVitalsConfigResponse.getErrorsList().get(index))
											  if(oCurrentAndHistoryResponse.getErrorsList().get(nErrorCount) != null)
											  {
												  if( oCurrentAndHistoryResponse.getErrorsList().get(nErrorCount).getErrorType() != Errors.NO_CHART_CONFIGURED)
												  strMessage.append(oCurrentAndHistoryResponse.getErrorsList().get(nErrorCount).getErrorMessage());
												// message = message + oCurrentAndHistoryResponse.getErrorsList().get(nErrorCount).getErrorMessage();
											  }
										   }
									   }
								   }
							   }
							   
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(strMessage.toString() ));
            _bw.write(_wl_block53Bytes, _wl_block53);
 
						}
						
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block55Bytes, _wl_block55);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }

    private boolean _jsp__tag0(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.core.SetTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.core.SetTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setVar(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("path", java.lang.String .class,"var"));
        __tag0.setValue(( java.lang.Object ) weblogic.servlet.jsp.ELHelper.evaluate("${pageContext.request.contextPath}",java.lang.Object.class,pageContext,_jspx_fnmap));
        _activeTag=__tag0;
        __result__tag0 = __tag0.doStartTag();

        if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag0.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag0);
            return true;
        }
        _activeTag=__tag0.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag0);
        __tag0.release();
        return false;
    }
}
