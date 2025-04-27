package jsp_servlet._eipad._jsp._chartwidgets;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eIPAD.chartsummary.results.response.ResultsResponse;
import eIPAD.chartsummary.common.healthobject.PatContext;
import eIPAD.chartsummary.results.healthobject.*;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import eIPAD.chartsummary.results.request.ResultsCatConstants;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.*;
import eIPAD.chartsummary.common.response.ErrorInfo;

public final class __resultsdata extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/chartwidgets/ResultsData.jsp", 1709118024631L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n\n<script type=\"text/javascript\">\n//result values horiz scroller object\nvar resValuesScroll;\nvar currentScrollingResultDiv;\nvar LinkedResPopupScroll;\nfunction assignResValuesScroll(){\n\t\t//When the result values are scrolled iscroll object is assigned to this div\n\t  $(\'.resItemsWrapperDiv\').bind(\'touchstart click\', function(event) { \n\t\t  //alert(currentScrollingResultDiv);\n\t\t  var currentDiv = $(this).attr(\'id\');\n\t\t  //alert(currentDiv);\n\t\t  if(currentScrollingResultDiv){\n\t\t\t  \n\t\t\t  if(currentScrollingResultDiv != currentDiv){\n\t\t\t\t  resValuesScroll = new iScroll(currentDiv, {\n\t\t\t\t\t\thScrollbar : false,\n\t\t\t\t\t\tvScroll : false\n\t\t\t\t});\n\t\t\t\tcurrentScrollingResultDiv = currentDiv;\n\t\t\t\t\n\t\t\t  }\n\t\t  }\n\t\t  else{\n\t\t\t  currentScrollingResultDiv = currentDiv;\n\t\t\t  resValuesScroll = new iScroll(currentDiv, {\n\t\t\t\t\thScrollbar : false,\n\t\t\t\t\tvScroll : false\n\t\t\t});\n\t\t  }\n\t\t  \n\n\t\t  \n\t  });  \n}\ndocument.addEventListener(\'DOMContentLoaded\', assignResValuesScroll, false);\n$(document).ready(function(){\n\t//Binding the iscroll intiation event to results data cells\n\tassignResValuesScroll();\n\tcomputeResultDataFrameWidth();\n\t//Assigning the horizontal scroller width to accomodate all the data\n\t$(\"[id^=\'reswiscroller-\']\").each(function(index,value){\n\t\tvar colNum = parseInt($(this).data(\"colnum\"));\n\t\tif(colNum<10){\n\t\t\tcolNum = 10;\n\t\t}\n\t\tvar scrollerWidth = colNum*116;\n\t\t//alert(colNum);\n\t\t$(this).css(\"width\", scrollerWidth+\"px\");\n\t});\n\tscrollerRefresh(CSMainScroll);\n});\n\nvar resultsDataFrameWidth;\n\nfunction computeResultDataFrameWidth(){\n\tresultsDataFrameWidth = $(\"#resultDataFrame\").width();\n\tresultLeftColWidth = $(\".resultItemsNameCol\").width();\n\tresultRightColWidth = resultsDataFrameWidth - resultLeftColWidth;\n\t//alert(resultRightColWidth);\n\t$(\".resultItemsDataCol\").each(function(index,value){\n\t\t$(this).css(\"width\", resultRightColWidth+\"px\");\n\t});\n}\n\n\n//This event is fired whenever a message is sent from the parent window\n//In case of orientationchange event \'OrientationChange\' message is received from the parent iframe\nwindow.addEventListener(\"message\", function(e){\n    var msgvalue = e.data;\n    //alert(msgvalue); \n    if(msgvalue==\'OrientationChange\'){\n    \tcomputeResultDataFrameWidth();\n    \tscrollerRefresh(CSMainScroll);\n    }\n}, false);\n\n\n\nfunction showResNotesPopup(obj,popupId){\n\t\n\tvar buttonHeight = $(obj).height();\n\tvar buttonWidth = $(obj).width();\n\tvar popupObj = $(\"#\"+popupId);\n\n    \n    var popupTitle = $(obj).data(\"title\");\n    //alert(encodeURI($(obj).data(\"linkurl\")));\n    var url = $(obj).data(\"linkurl\");\n    var accessionNum = escape($(obj).data(\"accessionnum\"));\n    url = url + accessionNum;\n    //alert(url);\n    //var linkurl = encodeURI(url);\n    //alert(linkurl);\n    var scrollerId = popupId+\"-scroller\";\n    var wrapperId = popupId+\"-wrapper\";\n    var contentsId = popupId+\"-contents\";\n    \n    //var LinkedResPopupScroll;\n\n    //clearing the contents\n    $(\"#\"+contentsId).empty();\n\n    $(\"#\"+popupId+\"-title\").html(popupTitle);\n    \n\t$(popupObj).show();\n\t$(\"#dvMez\").show();\n\t$(\"#dvMez\").data(\"popid\",popupId);\n\tsetTimeout(function() {\n\t\t$(\"#dvMez\").on(\"click\",closeMez);\n\t}, 500);\n\tif(LinkedResPopupScroll!=null){\n\t\tLinkedResPopupScroll.refresh();\n\t}\n    $(\"#\"+contentsId).load(url, function(){\n    \t\n    \tLinkedResPopupScroll = new iScroll(wrapperId, {\n    \t\tuseTransform : true,\n    \t\tzoom : false,\n    \t\tonBeforeScrollStart : function(e) {\n    \t\t\tvar target = e.target;\n    \t\t\twhile (target.nodeType != 1) target = target.parentNode;\n\n    \t\t\tif (target.tagName != \'SELECT\' && target.tagName != \'INPUT\' && target.tagName != \'TEXTAREA\' ){\n    \t\t\t\te.preventDefault();\n    \t\t\t}\n\n    \t\t\te.stopPropagation();\n    \t\t}\n    \t});\n    \tif(LinkedResPopupScroll!=null){\n    \t\tLinkedResPopupScroll.refresh();\n    \t}\n    });\n\n}\n\nfunction openStrResPopup(obj,popupId){\n\t\nvar popupObj = $(\"#\"+popupId);\n\n    \n    var popupTitle = $(obj).data(\"title\");\n    var data = $(obj).data(\"resstrvalue\");\n    var scrollerId = popupId+\"-scroller\";\n    var wrapperId = popupId+\"-wrapper\";\n    var contentsId = popupId+\"-contents\";\n    \n    \n    //clearing the contents\n    $(\"#\"+contentsId).empty();\n\n    $(\"#\"+popupId+\"-title\").html(popupTitle);\n    $(\"#\"+contentsId).html(data);\n    \n\t$(popupObj).show();\n\t$(\"#dvMez\").show();\n\tsetTimeout(function() {\n\t\t$(\"#dvMez\").on(\"click\",closeMez);\n\t}, 500);\n\t$(\"#dvMez\").data(\"popid\",popupId);\n\t  \n\n/*     $(\"#\"+contentsId).load(linkurl, function(){\n    \tvar LinkedResPopupScroll;\n    \tLinkedResPopupScroll = new iScroll(wrapperId, {\n    \t\tuseTransform : true,\n    \t\tzoom : false,\n    \t\tonBeforeScrollStart : function(e) {\n    \t\t\tvar target = e.target;\n    \t\t\twhile (target.nodeType != 1) target = target.parentNode;\n\n    \t\t\tif (target.tagName != \'SELECT\' && target.tagName != \'INPUT\' && target.tagName != \'TEXTAREA\' ){\n    \t\t\t\te.preventDefault();\n    \t\t\t}\n\n    \t\t\te.stopPropagation();\n    \t\t}\n    \t});\n    \tif(LinkedResPopupScroll!=null){\n    \t\tLinkedResPopupScroll.refresh();\n    \t}\n    }); */\n\t\n\t\n}\n\nfunction showResGraphPopup(obj,popupId){\n\t\n\tvar buttonHeight = $(obj).height();\n\tvar buttonWidth = $(obj).width();\n\tvar popupObj = $(\"#\"+popupId);\n\n    \n    var popupTitle = $(obj).data(\"title\");\n    var uom = $(obj).data(\"uom\");\n    //var linkurl = encodeURI($(obj).data(\"linkurl\"));\n    var scrollerId = popupId+\"-scroller\";\n    var wrapperId = popupId+\"-wrapper\";\n    var contentsId = popupId+\"-contents\";\n    \n    //clearing the contents\n    $(\"#\"+contentsId).empty();\n\n    $(\"#\"+popupId+\"-title\").html(popupTitle + \" (\" + uom+\")\");\n    \n\t$(popupObj).show();\n\t$(\"#dvMez\").show();\n\tsetTimeout(function() {\n\t\t$(\"#dvMez\").on(\"click\",closeMez);\n\t}, 500);\n\t$(\"#dvMez\").data(\"popid\",popupId);\n\tvar gcategories = $(obj).data(\"xaxis\");\n\tvar gcategories_arr = gcategories.split(\",\");\n\t/* var gcategories_arr = $.map(gcategories.split(\',\'), function(value){\n\t    return parseFloat(value);\n\t    // or return +value; which handles float values as well\n\t}); */\n\tvar gdata = $(obj).data(\"yaxis\");\n\t//alert(gdata);\n\t//var gdata_arr = gdata.split(\",\");\n\tvar gdata_arr = $.map(gdata.toString().split(\',\'), function(value){\n\t    return parseFloat(value);\n\t});\n\t\n\t//show only latest 25 results in graph\n\tgdata_arr.slice(0, 25);\n\tgcategories_arr.slice(0,25);\n\t\n\tgdata_arr.reverse();\n\tgcategories_arr.reverse();\n\t\n\tvar normalLow = 0;\n\tvar normalHigh = 0;\n\tnormalLow = parseFloat($(obj).data(\"normallow\"));\n\tnormalHigh = parseFloat($(obj).data(\"normalhigh\"));\n\tvar uom = $(obj).data(\"uom\");\n\tvar valueAxisTitle = \"\";\n\tif(uom){\n\t\tvalueAxisTitle = \"Values in \" + uom;\n\t}\n\tvar chartwidth = $(\"#CSCommonPopUpContainer\").width() - 20; //20 margin\n\t//alert(gdata_arr);\n\t\n\tvar scatterChartData = [];\n\tfor(i=0;i<gcategories_arr.length;i++){\n\t var xyPair = [new Date(gcategories_arr[i]),gdata_arr[i]];\n\t scatterChartData.push(xyPair);\n\t}\n\t   //alert(scatterChartData);\n\n\t$(\"#\"+contentsId).kendoChart({\n\t     title: {\n\t         text: \"\"\n\t     },\n\t     legend: {\n\t         position: \"bottom\"\n\t     },\n\t     chartArea: {\n\t         background: \"\"\n\t     },\n\t     seriesDefaults: {\n\t         \n\t         style: \"smooth\"\n\t     },\n\t     series: [{\n\t  \t   type: \"scatterLine\",\n\t  \t   data: scatterChartData,\n\t  \t   \n\t  \t   markers: {\n\t             size: 10\n\t         }\n\t          \n\t     }],\n\t     valueAxis: {\n\t         labels: {\n\t             format: \"{0:d}\" \n\t         },\n\t         title: {\n\t      \t      text: valueAxisTitle ,\n\t      \t      font: \"12px Arial\",\n\t      \t      rotation: -90\n\t      \t    },\n\t        \n\t         line: {\n\t             visible: false\n\t         },\n\t         axisCrossingValue: -10\n\t     },\n\t     categoryAxis: {\n\t  \t   labels: {\n\t  \t\t      rotation: 95\n\t  \t\t    },\n\t          \n\t         axisCrossingValue: -10,\n\t         baseUnitStep: \"auto\",\n\t       \n\t\n\t         majorGridLines: {\n\t             visible: false\n\t         }\n\t     },\n\t     xAxis: {\n\t  \t    type: \"date\",\n\t  \t    baseUnit: \"days\",\n\t  \t    labels: {\n\t  \t        dateFormats: {\n\t  \t          days: \"MMM-d\"\n\t  \t        }\n\t  \t      }\n\t\t\t  },\n\t    yAxis: {\n\t  \t   \n\t          plotBands: [\n\t                    { from: normalLow, \n\t                  \t  to: normalHigh , \n\t                  \t  color: \"Green\", \n\t                  \t  opacity: 0.4 }\n\t                  ]\n\t        },\n\t     tooltip: {\n\t         visible: true,\n\t         format: \"{1}\",\n\t     }\n\t});\n\t\n\t\n  \n\t\n    //var LinkedResPopupScroll;\n\t/* LinkedResPopupScroll = new iScroll(wrapperId, {\n\t\tuseTransform : true,\n\t\tzoom : false,\n\t\tonBeforeScrollStart : function(e) {\n\t\t\tvar target = e.target;\n\t\t\twhile (target.nodeType != 1) target = target.parentNode;\n\n\t\t\tif (target.tagName != \'SELECT\' && target.tagName != \'INPUT\' && target.tagName != \'TEXTAREA\' ){\n\t\t\t\te.preventDefault();\n\t\t\t}\n\n\t\t\te.stopPropagation();\n\t\t}\n\t});\n\tif(LinkedResPopupScroll!=null){\n\t\tLinkedResPopupScroll.refresh();\n\t} */\n    \n    \n}\n\n</script>\n<style>\n\n\n</style>\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 =" \n\n\n\n<div style=\"\" class=\"resultDataParent resultDataParentTheme\" id=\"resultDataParent\" data-role = \"none\">\n<form id=\"ResultDataForm\" class=\"ResultDataForm\" action=\"\" method=\"post\" name=\"ResultDataForm\" id=\"ResultDataForm\"> \n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t<div><!-- Results data view starts here -->\n\n\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\t<div style=\"clear: both;\"></div>\n\t\t<div style=\"display:table;\" class=\"resultItemsNameCol\">\n\t\t\t<div style=\"display:table-row\">\n\t\t\t\t<div style=\"display:table-cell;vertical-align:middle;\" class=\"resSubCatLeftRow ResSubCatRowTheme\"><div style=\"\" class=\"resCellDataPad\">";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</div> </div>\n\t\t\t</div>\n\t\t\t<div style=\"display:table-row\">\n\t\t\t\t<div style=\"display:table-cell;\">\n\t\t\t\t\t<div style=\"\" class=\"resItemsTabColTheme resItemsLeftTabCol\">\n\t\t\t\t\t\t<div style=\"display:table;\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t\t\t\t\t<div style=\"display:table-row\">\n\t\t\t\t\t\t\t\t<div style=\"display:table-cell;vertical-align:middle;\" class=\"ResGrpItemTheme resItemsLeftRow\"><div class=\"resCellDataPad\">";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</div> </div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<div style=\"display:table-row\">\n\t\t\t\t\t\t\t\t<div style=\"display:table-cell;vertical-align:middle;\" class=\"resItemsLeftRow ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\">\n\t\t\t\t\t\t\t\t\t<div style=\"display:table;width:100%\">\n\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\">\n\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell;vertical-align:middle;\" class=\"resCellDataPad\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</div>\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell;vertical-align:middle;\" class=\"resItemsChartImg\" onclick=\"showResGraphPopup(this,\'CSCommonPopUpContainer\')\"\n\t\t\t\t\t\t\t\t\t\t\tdata-title=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" data-yaxis=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" data-xaxis=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\"\n\t\t\t\t\t\t\t\t\t\t\tdata-uom=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" data-normallow=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" data-normalhigh=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t<img src=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="/eIPAD/images/BarChart.png\"/></div>\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</div>\n\t\t\t\t</div>\n\t\t\t</div>\n\t\t</div>\n\t\n\t<!-- Data Cells div -->\n\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t<div class=\"resItemsWrapperDiv resultItemsDataCol\" id=\"reswiwrapper-";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n\t\t\t<div id=\"reswiscroller-";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" style=\"\" data-colnum=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n\t\t\t\t<div style=\"display:table;\">\n\t\t\t\t\t<div style=\"display:table-row\">\n\t\t\t\t\t\t<div style=\"display:table\">\n\t\t\t\t\t\t\t<div style=\"display:table-row\">\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t\t\t\t<div style=\"display:table-cell;vertical-align:middle;text-align:center\" class=\"resSubCatRightRow ResSubCatRowTheme\">\n\t\t\t\t\t\t\t\t\t<div style=:display:table;\"><div style=\"display:table-row\"><div style=\"display:table-cell; vertical-align:middle;text-align:center;\" class=\"resCatHeadInnerCell ResCatHeadInnerTheme\">";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</div></div></div>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =" \n\t\t\t\t\t\t\t\t<div style=\"display:table-cell;vertical-align:middle;text-align:center\" class=\"resSubCatRightRow ResSubCatRowTheme\">\n\t\t\t\t\t\t\t\t\t<div style=:display:table;\"><div style=\"display:table-row\"><div style=\"display:table-cell; vertical-align:middle;text-align:center;\" class=\"resCatHeadInnerCell ResCatHeadInnerTheme\"></div></div></div>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</div>\n\t\t\t\t\t<div style=\"display:table-row\">\n\t\t\t\t\t\t<div style=\"display:table-cell;\">\n\t\t\t\t\t\t\t<div style=\"\" class=\"resItemsTabColTheme resItemsRightTabCol\">\n\t\t\t\t\t\t\t\t<div style=\"display:table;\"> \n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\"><!-- group name row with empty data cells -->\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell;\" class=\"resItemsRightCell ResGrpItemTheme\"></div>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =" \n\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell;\" class=\"resItemsRightCell ResGrpItemTheme\"></div>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\" class=\"\">\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell;vertical-align:middle;text-align:center;\" class=\"resItemsRightCell ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\"></div>\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table;width:100%\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell;vertical-align:middle;text-align:center;\" class=\"resItemNormIconCell\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"\" style=\"\"><img src=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="/eIPAD/images/SNI_NORMAL.gif\"/></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="/eIPAD/images/SNI_Abnormal.gif\"/></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="/eIPAD/images/SNI_Critical.gif\"/></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="/eIPAD/images/SNI_Low.gif\"/></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="/eIPAD/images/SNI_High.gif\"/></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="/eIPAD/images/SNI_CriticallyLow.gif\"/></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="/eIPAD/images/SNI_CriticallyHigh.gif\"/></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="/eIPAD/images/SNoData.PNG\"/></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell;vertical-align:middle;text-align:center;\" class=\"resItemValueCell\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ResValueText\" style=\"\">";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ResUomText\">";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell;vertical-align:middle;text-align:center;\" class=\"resItemValueCell\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ResValueText\" data-resstrvalue=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\" onclick=\"openStrResPopup(this,\'CSCommonPopUpContainer\')\" data-title=\"Event Details\">";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell;vertical-align:middle;text-align:center;\" onclick=\"showResNotesPopup(this,\'CSCommonPopUpContainer\')\" \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tdata-linkurl=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="/mobile/chartsummary/ResultNotesView?HistRecType=";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="&ContSysId=";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="&ContrSysEventCode=";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="&AccessionNum=\" \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tdata-title=\"Event Details\" data-accessionnum=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"\"><img src=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="/eIPAD/images/NoteType.png\"/></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 =" \n\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell;vertical-align:middle;text-align:center;\" class=\"resItemsRightCell ";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\"></div>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t \n\t\t\t\t</div> \n\t\t\t</div>\n\t\t</div>\n\t\t\n\t";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t\t</div>\n\t\t";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t\n\t\t\n\t\t<div><!-- Results data view starts here group by category for others category -->\n\n\t";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\t\t\n\t\t<div style=\"clear: both;\"></div>\n\t\t<div style=\"display:table;\" class=\"resultItemsNameCol\">\n\t\t\t<div style=\"display:table-row\">\n\t\t\t\t<div style=\"display:table-cell;vertical-align:middle;\" class=\"resSubCatLeftRow ResSubCatRowTheme\"><div style=\"\" class=\"resCellDataPad\">";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</div>\n\t\t\t\t</div>\n\t\t\t</div>\n\t\t</div>\n\t\t\n\t\t<div class=\"resItemsWrapperDiv resultItemsDataCol\" id=\"reswiwrapper-";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="&AccessionNum=";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\" \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tdata-title=\"Event Details\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"\"><img src=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t \n\t\t\t\t</div> \n\t\t\t</div>\n\t\t</div>\n\n\t";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n</div>\n\t\t";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n\t\t\n\t\t<div class=\"WidgetVwErrContainer\">\n\t\t\t";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t\t\t<div class=\"WidgetErrorResponse WidgetErrorResponseTheme\">";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="</div>\n\t\t\t";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\t\t</div>\n\t";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\t\n</form>\n</div>\n\n\n\n";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block2Bytes, _wl_block2);

ResultsResponse resultsResponse = (ResultsResponse)request.getAttribute("ResultsResponse");
String groupBy = (String)request.getAttribute("GroupBy");
boolean isSuccessResponse = false;
boolean isEmptyResponse = true;
ArrayList<ErrorInfo> errorList = new ArrayList<ErrorInfo>();
ArrayList<ResultHO> resultHOList = new ArrayList<ResultHO>();

SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");


if(resultsResponse!=null){
	isSuccessResponse = resultsResponse.isSuccessResponse();
	isEmptyResponse = resultsResponse.isEmptyDataResponse();
	resultHOList = resultsResponse.getResults();
	errorList = resultsResponse.getErrorsList();
	if(resultHOList!=null && !resultHOList.isEmpty())
		isEmptyResponse = false;
}

            _bw.write(_wl_block3Bytes, _wl_block3);
 if(isSuccessResponse && !isEmptyResponse) {
	if(groupBy.equals(ResultsCatConstants.GROUPBY_SUBCATEGORY)){

            _bw.write(_wl_block4Bytes, _wl_block4);

	for(int i=0;i<resultHOList.size();i++){
		ResultHO resultHO = resultHOList.get(i);
		String histRecType = resultHO.getCategoryCode();
		ArrayList<ResultSubCategory> resultSubCategoryList = resultHO.getResSubCat();
		for(int j=0;j<resultSubCategoryList.size();j++){
			ResultSubCategory resultSubCategory = resultSubCategoryList.get(j); 
			ArrayList<Date> allDates = resultSubCategory.getAllDates();
			ArrayList<ResultGroupItem> resultGroupItemList = resultSubCategory.getResGrpItems();
			if(!resultGroupItemList.isEmpty()){
				
		
		
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(resultSubCategory.getSubCategoryName() ));
            _bw.write(_wl_block6Bytes, _wl_block6);

							String curGroupCode = "";
							for(int a=0;a<resultGroupItemList.size();a++){
								ResultGroupItem resultGroupItem = resultGroupItemList.get(a);
								String groupName = resultGroupItem.getResultGroupName();
								String groupCode = resultGroupItem.getResultGroupCode();
								String resultName = resultGroupItem.getResultName();
								String resultCode = resultGroupItem.getResultCode();
								if(groupCode!=null && !groupCode.equals("") && !groupCode.equals(curGroupCode)){
									
								
							
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf( groupName));
            _bw.write(_wl_block8Bytes, _wl_block8);

								}
								String resultRowStyle="ResItemTheme";
								//if there is no group name, then the result row should be in grouprow style
								if(groupCode == null || groupCode.equals("")){
									resultRowStyle="ResGrpItemTheme";
								}
								
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(resultRowStyle));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf( resultName));
            _bw.write(_wl_block11Bytes, _wl_block11);
 if(resultGroupItem.getResultDataType().equals("NUM")){ 
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf( resultName));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(resultGroupItem.getResultValuesCSV() ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(resultGroupItem.getResultDateCSV("yyyy/MM/dd HH:mm:ss")));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(resultGroupItem.getResultUom()));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(resultGroupItem.getNormalLow()));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(resultGroupItem.getNormalHigh()));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block19Bytes, _wl_block19);
} 
            _bw.write(_wl_block20Bytes, _wl_block20);

								curGroupCode = groupCode;
							}
            _bw.write(_wl_block21Bytes, _wl_block21);

		int emptyCellsToPrint = 0;
		if(allDates.size()<10){
			//if the number of cell is less than 10 print empty cell just making the tabular format look neat
			emptyCellsToPrint = 10 - allDates.size();
		}
	
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(resultSubCategory.getSubCategoryCode() ));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(resultSubCategory.getSubCategoryCode()));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(allDates.size()));
            _bw.write(_wl_block25Bytes, _wl_block25);
for(int x=0;x<allDates.size();x++){ 
									Date xDate = allDates.get(x);
									String dateStr = sdf.format(xDate);
								
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(dateStr));
            _bw.write(_wl_block27Bytes, _wl_block27);
} 
								if(emptyCellsToPrint > 0){
									for(int e=0;e<emptyCellsToPrint;e++){
								
            _bw.write(_wl_block28Bytes, _wl_block28);

									}
								} 
								
            _bw.write(_wl_block29Bytes, _wl_block29);

									String curGroupCode2 = "";
									for(int b=0;b<resultGroupItemList.size();b++){
										ResultGroupItem resultGroupItem = resultGroupItemList.get(b);
										String groupName = resultGroupItem.getResultGroupName();
										String groupCode = resultGroupItem.getResultGroupCode();
										String resultName = resultGroupItem.getResultName();
										String resultCode = resultGroupItem.getResultCode();
										String contSysId = resultGroupItem.getContrSysId();
										String resultDataType = resultGroupItem.getResultDataType();
										String uom = resultGroupItem.getResultUom();
										//ArrayList<ResultValue> resultValueList = resultGroupItem.getResValues();
										ArrayList<ResultValue> resultValueList = resultGroupItem.getResValuesForDates(allDates);
										if(groupCode!=null && !groupCode.equals("") && !groupCode.equals(curGroupCode2)){
										// group header row	-- display empty cells
										
									
            _bw.write(_wl_block30Bytes, _wl_block30);
for(int x=0;x<allDates.size();x++){ 
            _bw.write(_wl_block31Bytes, _wl_block31);
} 
            _bw.write(_wl_block32Bytes, _wl_block32);
if(emptyCellsToPrint > 0){
											for(int e=0;e<emptyCellsToPrint;e++){
										
            _bw.write(_wl_block33Bytes, _wl_block33);

											}
										} 
            _bw.write(_wl_block34Bytes, _wl_block34);

										}
										curGroupCode2 = groupCode;
											
            _bw.write(_wl_block35Bytes, _wl_block35);

										String resultRowStyle="ResItemTheme";
									//if there is no group name, then the result row should be in grouprow style
										if(groupCode == null || groupCode.equals("")){
											resultRowStyle="ResGrpItemTheme";
										}
										for(int n=0;n<resultValueList.size();n++){
											
											ResultValue resultValue = resultValueList.get(n);
											if(resultValue.getDate().equals("NULL") && resultValue.getAccessionNum().equals("NULL")) {
												//display empty cell
											
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(resultRowStyle));
            _bw.write(_wl_block37Bytes, _wl_block37);
 
											}
											else{
												
												//display data cell
											
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(resultRowStyle));
            _bw.write(_wl_block38Bytes, _wl_block38);

																if(resultValue.getNormalcyInd().equals(ResultValue.Normalcy.NORMAL)){
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block40Bytes, _wl_block40);
} 
																else if(resultValue.getNormalcyInd().equals(ResultValue.Normalcy.ABNORMAL)){
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block41Bytes, _wl_block41);
}
																else if(resultValue.getNormalcyInd().equals(ResultValue.Normalcy.CRITICAL)){
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block42Bytes, _wl_block42);
}
																else if(resultValue.getNormalcyInd().equals(ResultValue.Normalcy.LOW)){
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block43Bytes, _wl_block43);
}
																else if(resultValue.getNormalcyInd().equals(ResultValue.Normalcy.HIGH)){
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block44Bytes, _wl_block44);
}
																else if(resultValue.getNormalcyInd().equals(ResultValue.Normalcy.CRITICALLOW)){
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block45Bytes, _wl_block45);
}
																else if(resultValue.getNormalcyInd().equals(ResultValue.Normalcy.CRITICALHIGH)){
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block46Bytes, _wl_block46);
} 
																else{ 
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block47Bytes, _wl_block47);
} 
            _bw.write(_wl_block48Bytes, _wl_block48);
if(resultDataType.equals("NUM")){ 
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf( resultValue.getDblAsStrValue()));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(uom ));
            _bw.write(_wl_block51Bytes, _wl_block51);
} 
															else if(resultDataType.equals("STR")){
															
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf( resultValue.getStrValue()));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf( resultValue.getStrValue()));
            _bw.write(_wl_block51Bytes, _wl_block51);
} 
															else if(resultDataType.equals("HTM") || resultDataType.equals("TXT")){
															
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(histRecType));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(contSysId));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(resultCode));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(resultValueList.get(n).getAccessionNum()));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block60Bytes, _wl_block60);
} 
            _bw.write(_wl_block61Bytes, _wl_block61);
 
											}

										}
										if(emptyCellsToPrint > 0){
											for(int e=0;e<emptyCellsToPrint;e++){
										
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(resultRowStyle));
            _bw.write(_wl_block63Bytes, _wl_block63);

											}
										} 
										
            _bw.write(_wl_block64Bytes, _wl_block64);

						
									}
            _bw.write(_wl_block65Bytes, _wl_block65);

		}
	
		}
		}
		
            _bw.write(_wl_block66Bytes, _wl_block66);

		}else{
            _bw.write(_wl_block67Bytes, _wl_block67);

	for(int i=0;i<resultHOList.size();i++){
		ResultHO resultHO = resultHOList.get(i);
		String histRecType = resultHO.getCategoryCode();
		ArrayList<Date> allDates = resultHO.getAllDates();
		int emptyCellsToPrint = 0;
		if(allDates.size()<10){
			//if the number of cell is less than 10 print empty cell just making the tabular format look neat
			emptyCellsToPrint = 10 - allDates.size();
		}
		ArrayList<ResultSubCategory> resultSubCategoryList = resultHO.getResSubCat(); 
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(resultHO.getCategoryName() ));
            _bw.write(_wl_block6Bytes, _wl_block6);

							for(int j=0;j<resultSubCategoryList.size();j++){
								ResultSubCategory resultSubCategory = resultSubCategoryList.get(j); 
								ArrayList<ResultGroupItem> resultGroupItemList = resultSubCategory.getResGrpItems();
								if(!resultGroupItemList.isEmpty()){
							String curGroupCode = "";
							for(int a=0;a<resultGroupItemList.size();a++){
								ResultGroupItem resultGroupItem = resultGroupItemList.get(a);
								String groupName = resultGroupItem.getResultGroupName();
								String groupCode = resultGroupItem.getResultGroupCode();
								String resultName = resultGroupItem.getResultName();
								String resultCode = resultGroupItem.getResultCode();
								if(groupCode!=null && !groupCode.equals("") && !groupCode.equals(curGroupCode)){
									
								
							
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf( groupName));
            _bw.write(_wl_block8Bytes, _wl_block8);

								}
								String resultRowStyle="ResItemTheme";
								//if there is no group name, then the result row should be in grouprow style
								if(groupCode == null || groupCode.equals("")){
									resultRowStyle="ResGrpItemTheme";
								}
								
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(resultRowStyle));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf( resultName));
            _bw.write(_wl_block11Bytes, _wl_block11);
 if(resultGroupItem.getResultDataType().equals("NUM")){ 
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf( resultName));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(resultGroupItem.getResultValuesCSV() ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(resultGroupItem.getResultDateCSV("yyyy/MM/dd HH:mm:ss")));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(resultGroupItem.getResultUom()));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(resultGroupItem.getNormalLow()));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(resultGroupItem.getNormalHigh()));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block19Bytes, _wl_block19);
} 
            _bw.write(_wl_block20Bytes, _wl_block20);

								curGroupCode = groupCode;
							}
							}
							}
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(resultHO.getCategoryCode() ));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(resultHO.getCategoryCode() ));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(allDates.size()));
            _bw.write(_wl_block25Bytes, _wl_block25);
for(int x=0;x<allDates.size();x++){ 
									Date xDate = allDates.get(x);
									String dateStr = sdf.format(xDate);
								
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(dateStr));
            _bw.write(_wl_block27Bytes, _wl_block27);
} 
								if(emptyCellsToPrint > 0){
									for(int e=0;e<emptyCellsToPrint;e++){
								
            _bw.write(_wl_block28Bytes, _wl_block28);

									}
								} 
								
            _bw.write(_wl_block29Bytes, _wl_block29);

									for(int j=0;j<resultSubCategoryList.size();j++){
								ResultSubCategory resultSubCategory = resultSubCategoryList.get(j); 
								ArrayList<ResultGroupItem> resultGroupItemList = resultSubCategory.getResGrpItems();
								if(!resultGroupItemList.isEmpty()){
									String curGroupCode2 = "";
									for(int b=0;b<resultGroupItemList.size();b++){
										ResultGroupItem resultGroupItem = resultGroupItemList.get(b);
										String groupName = resultGroupItem.getResultGroupName();
										String groupCode = resultGroupItem.getResultGroupCode();
										String resultName = resultGroupItem.getResultName();
										String resultCode = resultGroupItem.getResultCode();
										String contSysId = resultGroupItem.getContrSysId();
										String resultDataType = resultGroupItem.getResultDataType();
										String uom = resultGroupItem.getResultUom();
										//ArrayList<ResultValue> resultValueList = resultGroupItem.getResValues();
										ArrayList<ResultValue> resultValueList = resultGroupItem.getResValuesForDates(allDates);
										if(groupCode!=null && !groupCode.equals("") && !groupCode.equals(curGroupCode2)){
										// group header row	-- display empty cells
										
									
            _bw.write(_wl_block30Bytes, _wl_block30);
for(int x=0;x<allDates.size();x++){ 
            _bw.write(_wl_block31Bytes, _wl_block31);
} 
            _bw.write(_wl_block32Bytes, _wl_block32);
if(emptyCellsToPrint > 0){
											for(int e=0;e<emptyCellsToPrint;e++){
										
            _bw.write(_wl_block33Bytes, _wl_block33);

											}
										} 
            _bw.write(_wl_block34Bytes, _wl_block34);

										}
										curGroupCode2 = groupCode;
											
            _bw.write(_wl_block35Bytes, _wl_block35);

										String resultRowStyle="ResItemTheme";
									//if there is no group name, then the result row should be in grouprow style
										if(groupCode == null || groupCode.equals("")){
											resultRowStyle="ResGrpItemTheme";
										}
										for(int n=0;n<resultValueList.size();n++){
											
											ResultValue resultValue = resultValueList.get(n);
											if(resultValue.getDate().equals("NULL") && resultValue.getAccessionNum().equals("NULL")) {
												//display empty cell
											
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(resultRowStyle));
            _bw.write(_wl_block37Bytes, _wl_block37);
 
											}
											else{
												
												//display data cell
											
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(resultRowStyle));
            _bw.write(_wl_block38Bytes, _wl_block38);

																if(resultValue.getNormalcyInd().equals(ResultValue.Normalcy.NORMAL)){
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block40Bytes, _wl_block40);
} 
																else if(resultValue.getNormalcyInd().equals(ResultValue.Normalcy.ABNORMAL)){
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block41Bytes, _wl_block41);
}
																else if(resultValue.getNormalcyInd().equals(ResultValue.Normalcy.CRITICAL)){
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block42Bytes, _wl_block42);
}
																else if(resultValue.getNormalcyInd().equals(ResultValue.Normalcy.LOW)){
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block43Bytes, _wl_block43);
}
																else if(resultValue.getNormalcyInd().equals(ResultValue.Normalcy.HIGH)){
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block44Bytes, _wl_block44);
}
																else if(resultValue.getNormalcyInd().equals(ResultValue.Normalcy.CRITICALLOW)){
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block45Bytes, _wl_block45);
}
																else if(resultValue.getNormalcyInd().equals(ResultValue.Normalcy.CRITICALHIGH)){
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block46Bytes, _wl_block46);
} 
																else{ 
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block47Bytes, _wl_block47);
} 
            _bw.write(_wl_block48Bytes, _wl_block48);
if(resultDataType.equals("NUM")){ 
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf( resultValue.getDblAsStrValue()));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(uom ));
            _bw.write(_wl_block51Bytes, _wl_block51);
} 
															else if(resultDataType.equals("STR")){
															
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf( resultValue.getStrValue()));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf( resultValue.getStrValue()));
            _bw.write(_wl_block51Bytes, _wl_block51);
} 
															else if(resultDataType.equals("HTM") || resultDataType.equals("TXT")){
															
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(histRecType));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(contSysId));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(resultValueList.get(n).getAccessionNum()));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(resultCode));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block60Bytes, _wl_block60);
} 
            _bw.write(_wl_block61Bytes, _wl_block61);
 
											}

										}
										if(emptyCellsToPrint > 0){
											for(int e=0;e<emptyCellsToPrint;e++){
										
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(resultRowStyle));
            _bw.write(_wl_block63Bytes, _wl_block63);

											}
										} 
										
            _bw.write(_wl_block64Bytes, _wl_block64);

						
									}
									}
									}
            _bw.write(_wl_block72Bytes, _wl_block72);

	}
	
            _bw.write(_wl_block73Bytes, _wl_block73);
}
	} else{ 
            _bw.write(_wl_block74Bytes, _wl_block74);

			for(int k=0;k<errorList.size();k++){
			
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf( errorList.get(k).getErrorMessage()));
            _bw.write(_wl_block76Bytes, _wl_block76);
} 
            _bw.write(_wl_block77Bytes, _wl_block77);
} 
            _bw.write(_wl_block78Bytes, _wl_block78);
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
