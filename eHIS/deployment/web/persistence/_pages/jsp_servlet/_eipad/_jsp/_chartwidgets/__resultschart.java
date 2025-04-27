package jsp_servlet._eipad._jsp._chartwidgets;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.ArrayList;
import eIPAD.chartsummary.results.healthobject.*;
import eIPAD.chartsummary.common.response.ErrorInfo;
import eIPAD.chartsummary.common.healthobject.PatContext;
import eIPAD.chartsummary.results.response.ResultsResponse;
import java.util.*;

public final class __resultschart extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/chartwidgets/ResultsChart.jsp", 1738426243956L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<!DOCTYPE html>\n<html>\n<head>\n<title></title>\n<meta name=\"apple-mobile-web-app-capable\" content=\"yes\" />\n<meta name=\"viewport\"\n\tcontent=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\" />\n<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="/eIPAD/jquery.mobile-1.0.1.min.css\" />\n\n<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="/eIPAD/css/kendo.common.min.css\" />\n<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="/eIPAD/css/kendo.default.min.css\" />\n<script src=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="/eIPAD/jquery-1.9.1.js\"></script> \n<script src=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="/eIPAD/kendo.web.min.js\"></script>\n<script src=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="/eIPAD/console.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script>\n<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="/eIPAD/css/iPADNew.css\" />\n<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="/eIPAD/css/iPADThemeA.css\" />\n<script type=\"application/javascript\" src=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="/eIPAD/js/iscroll.js\"></script>\n<link href=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="/eIPAD/css/kendo.dataviz.min.css\" rel=\"stylesheet\">\n<script src=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="/eIPAD/kendo.dataviz.min.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n<script>\nvar recordScroll ;\nvar graphScroll;\ndocument.addEventListener(\'touchmove\', function (e) { e.preventDefault(); }, false);\ndocument.addEventListener(\'DOMContentLoaded\', allergyScroll, false);\nfunction allergyScroll() {\n\t setTimeout(function () {\n\t\trecordScroll = new iScroll(\'ResGraphLeftItems\', {\n\t\tuseTransform: true,\n\t\tzoom: false,\n\t\tonBeforeScrollStart: function (e) {\n\t\tvar target = e.target;\n\t\twhile (target.nodeType != 1) target = target.parentNode;\n\n\t\tif (target.tagName != \'SELECT\' && target.tagName != \'INPUT\' && target.tagName != \'TEXTAREA\' && target.tagName != \'DIV\')\n\t\te.preventDefault();\n\t\t}\n\t\t});\n\t}, 1000); \n\t \n\t graphScroll = new iScroll(\'ResGraphRightItems\', {\n\t\t\tuseTransform: true,\n\t\t\tzoom: false,\n\t\t\tonBeforeScrollStart: function (e) {\n\t\t\tvar target = e.target;\n\t\t\twhile (target.nodeType != 1) target = target.parentNode;\n\n\t\t\tif (target.tagName != \'SELECT\' && target.tagName != \'INPUT\' && target.tagName != \'TEXTAREA\' && target.tagName != \'DIV\')\n\t\t\te.preventDefault();\n\t\t\t}\n\t\t\t});\n}\nfunction scrollRefresh()\n{\n\tif(recordScroll != null)\n\t\trecordScroll.refresh();\n\tif(graphScroll != null)\n\t\tgraphScroll.refresh();\n}\nfunction changeOrientation(orient, EMHFheight)\n{\n\tcomputeResultDataFrameWidth();\n\tsetSparklineGraphBoxWidth();\n\tdestroyAllVisibleSparklines();\n\tvar CSHFheight = $(\'#allergyHeader\').height();\n\tHFheight = EMHFheight;\n\tvar content_height = parent.getTotalPageDivHeight() - EMHFheight - CSHFheight-6 ;\n\tdocument.getElementById(\"divcnt\").style.height = content_height+\"px\";\n\tscreenOrienttation = orient;\n\tcomputeLeftRightFrameHeight();\n\talterSparkLineWidth();\n\tbuildAllVisibleSparklines();\n\tscrollRefresh();\n/* \tif(screenOrienttation == \"landscape\") // to display the sfs based on the orientation\n\t {\n\t\t \n\t\t$(\'#lineChartContainer\').css(\"left\" , \"15%\");\n\t\t$(\'#lineChartContainer\').css(\"top\" , \"15%\");\n\t }\n\t else \n\t {\n\t     $(\'#lineChartContainer\').css(\"left\" , \"2%\");\t\n\t     $(\'#lineChartContainer\').css(\"top\" , \"20%\");\n\t } */\n\t\n}\nfunction showMezzaineWindow() // this function is used to show the mezzaine window.\n{\n\t$(\'#dvMez\').css(\"display\",\"block\");\n\tsetTimeout(function() {\n\t\t$(\"#dvMez\").on(\"click\",closeMezzaineWindow);\n\t}, 500);\n}\nfunction closeMezzaineWindow()\n{\n\t$(\'#dvMez\').css(\"display\",\"none\");\n\tvar popid = $(\"#dvMez\").data(\"popid\");\n\t$(\"#\"+popid).hide();\n\t$(\"#dvMez\").data(\"popid\",\"\");\n\t$(\"#dvMez\").off();\n}\nfunction closeLineChart()\n{\n\t   closeMezzaineWindow();\n\t   $(\"#dvMez\").data(\"popid\",\"\");\n\t   $(\'#ResChartCommonPopUpContainer\').css(\"display\" , \"none\");\n\t  \n\t   \n}\n$(document).ready(function () {\n\t\n\t parent.setOnLoadContentPaneHeight();\n\t computeResultDataFrameWidth();\n\t computeLeftRightFrameHeight();\n\t setSparklineGraphBoxWidth();\n\t \n\t //checkall = $(\"#PTCR\");\n\t //checkall.prop(\"indeterminate\", true);\n\t //alert(\"see PTCR\");\n\t //checkall.attr(\'checked\',\'checked\');\n\t//checkall = document.getElementById(\'PTCR\');\n\t//checkall.indeterminate = true;\n\t//alert(\"see PTCR\");\n\t//checkall.checked = true;\n\t//checkall.indeterminate = false;\n});\nfunction gotoCS(){\n\tvar path = document.getElementById(\"hdnPath\").value + \"/mobile/chartsummary/ChartWidgetsView\";\n\twindow.location.replace(path);\n}\n\n\n\nfunction computeLeftRightFrameHeight(){\n\tresultsDataFrameHeight = $(\"#divcnt\").height();\n\tresultLeftHeaderHeight = $(\"#ResGraphLeftHeader\").height();\n\tresultLeftItemsHeight = resultsDataFrameHeight - resultLeftHeaderHeight;\n\t$(\"#ResGraphLeftItems\").css(\"height\", resultLeftItemsHeight+\"px\" );\n\t\n\t//Right\n\t$(\"#ResChartRightDiv\").css(\"height\",resultsDataFrameHeight);\n\t$(\"#ResGraphRightItems\").css(\"height\",resultsDataFrameHeight);\n\t\n}\n\n\n\n//This event is fired whenever a message is sent from the parent window\n//In case of orientationchange event \'OrientationChange\' message is received from the parent iframe\n/* window.addEventListener(\"message\", function(e){\n    var msgvalue = e.data;\n    alert(msgvalue); \n    if(msgvalue==\'OrientationChange\'){\n    \tcomputeResultDataFrameWidth();\n    \t\n    }\n}, false); */\n\nfunction computeResultDataFrameWidth(){\n\tresultsDataFrameWidth = $(\"#divcnt\").width();\n\tresultLeftColWidth = $(\"#ResChartLeftDiv\").width();\n\tresultRightColWidth = resultsDataFrameWidth - resultLeftColWidth;\n\t$(\"#ResChartRightDiv\").css(\"width\", resultRightColWidth+\"px\");\n\t\n\t\n\t//alert(resultRightColWidth);\n\t/* $(\".resultItemsDataCol\").each(function(index,value){\n\t\t$(this).css(\"width\", resultRightColWidth+\"px\");\n\t}); */\n}\n\nfunction resultItemsSelect(obj){\n\t\n\tvar objId = $(obj).attr(\"id\");\n\tvar checkVal = $(obj).prop(\"checked\")\n\t//alert(objId);\n\t//select each and every sub item\n\t$(\"[id^=\'\"+objId+\"__\']\").each(function(index,value){\n\t\t\n\t\t//alert(checkVal);\n\t\t$(this).prop(\"checked\",checkVal);\n\t});\n\t\n\t\n\t//if one or few and not all items under a parent is unchecked put the parent to indeterminate state\n\t//if all items under a parent are unchecked, put the parent to unchecked state\n\t//if all items under a parent are checked, put the parent to checked state.\n\n\tvar n;\n\tvar parentID;\n\tvar idCopy = objId;\n\t//Iterating through the parent ids, by stripping the child\'s specific ID\n\twhile(idCopy.lastIndexOf(\"__\") > 0){\n\t\tn = idCopy.lastIndexOf(\"__\");\n\t\tidCopy = idCopy.substring(0,n);\n\t\t//alert(idCopy);\n\t\tvar parentObj = $(\"#\"+idCopy);\n\t\tif(parentObj){\n\t\t\tvar childCount = $(\"[id^=\'\"+idCopy+\"__\']\").length;\n\t\t\tvar checkedCount = 0;\n\t\t\tvar unCheckedCount = 0;\n\t\t\t$(\"[id^=\'\"+idCopy+\"__\']\").each(function(index,value){\n\t\t\t\tvar isChecked = $(this).prop(\"checked\")\n\t\t\t\tif(isChecked){\n\t\t\t\t\tcheckedCount++;\n\t\t\t\t}else{\n\t\t\t\t\tunCheckedCount++\n\t\t\t\t}\n\t\t\t\t//alert(checkVal);\n\t\t\t\t//$(this).prop(\"checked\",checkVal);\n\t\t\t});\n\t\t\t//alert(childCount+\"  \"+checkedCount+\"  \"+unCheckedCount);\n\t\t\tif(checkedCount == 0 && unCheckedCount == childCount){\n\t\t\t\t//alert(\"all unchecked\");\n\t\t\t\t$(parentObj).prop(\'checked\', false);\n\t\t\t\t$(parentObj).prop(\"indeterminate\", false);\n\t\t\t\t//$(parentObj).removeAttr(\'checked\');\n\t\t\t}\n\t\t\telse if(unCheckedCount == 0 && checkedCount == childCount){\n\t\t\t\t//alert(\"all checked\");\n\t\t\t\t\n\t\t\t\t//$(parentObj).removeAttr(\'checked\');\n\t\t\t\t$(parentObj).prop(\'checked\', true);\n\t\t\t\t$(parentObj).prop(\"indeterminate\", false);\n\t\t\t\t\n\t\t\t\t//$(parentObj).attr(\'checked\',\'checked\');\n\t\t\t}\n\t\t\telse{\n\t\t\t\t//alert(\"indeterminate\");\n\t\t\t\t$(parentObj).prop(\"indeterminate\", true);\n\t\t\t}\n\t\t}\n\t}\n\tvar selectedCount = 0;\n\t//  show/hide selected/unselected graphs\n\t$(\"[data-resultgraph=\'true\']\").each(function(index,value){\n\t\t//selectedCount = 0;\n\t\tvar divCount = $(this).data(\"count\");\n\t\tvar isResChecked = $(this).prop(\"checked\");\n\t\tif(isResChecked){\n\t\t\t\n\t\t\t$(\"#ResultSGraphContainer\"+divCount).show();\n\t\t\t//setSparklineGraphBoxWidth();\n\t\t\t/* if(SparkLineGraphBoxWidth == 0){\n\t\t\t\t\n\t\t\t\talert(SparkLineGraphBoxWidth);\n\t\t\t} */\n\t\t\t\n\t\t\tvar graphAreaWid = SparkLineGraphBoxWidth - $(\".resSGraphCurrValCell\").width() - $(\"#ResChartLeftPanelButton\").width();\n\t\t\t$(\"#ResSGraphArea\"+divCount).css(\"width\", graphAreaWid+\"px\" );\n\t\t\tbuildSparkLine(divCount);\n\t\t\t/* if($(\"#ResSGraphArea\"+divCount).is(\':empty\')) {\n\t\t\t\t\n\t\t\t} */\n\t\t\tselectedCount++;\n\t\t\t\n\t\t}else{\n\t\t\t$(\"#ResultSGraphContainer\"+divCount).hide();\n\t\t}\n\t\t\n\t});\n\t\n\t$(\"#SelectedItemsCount\").html(selectedCount);\n\t\n\tif(graphScroll != null)\n\t\tgraphScroll.refresh();\n\t\n\t\n\t\n}\n\nfunction alterSparkLineWidth(){\n\tvar currCellWid = $(\".resSGraphCurrValCell\").width();\n\t//alert(currCellWid);\n\tvar grWid = SparkLineGraphBoxWidth - currCellWid - $(\"#ResChartLeftPanelButton\").width();\n\t$(\".resSGraphBoxAdjWid\").css(\"width\",grWid+\"px\");\n\t/* $(\".resSGraphBoxAdjWid\").each(function(index,value){\n\t\tid = $(this).attr(\"id\");\n\t\tif($(\"#\"+id).is(\':visible\')){\n\t\t\tvar sparkline = $(\"#\"+id).data(\"kendoSparkline\");\n\t\t\tsparkline.refresh();\n\t\t}\n\t}); */\n\t//alert(grWid);\n\t\n}\nvar SparkLineGraphBoxWidth;\nfunction  setSparklineGraphBoxWidth(){\n\tSparkLineGraphBoxWidth = $(\"#ResGraphRightItems\").width()-50;\n\t//alert(cellWidth);\n\t//alert(SparkLineGraphBoxWidth);\n\t//$(\".resSGraphBoxAdjWid\").css(\"width\",SparkLineGraphBoxWidth);\n\t\n}\n\n\nfunction buildSparkLine(graphNum){\n\t\n\tvar checkBoxID = $(\"[data-count=\'\"+graphNum+\"\']\").attr(\"id\");\n\tvar checkBoxObj= document.getElementById(checkBoxID);\n\t\n\tvar title = $(checkBoxObj).data(\"resultname\");\n\tvar uom = $(checkBoxObj).data(\"uom\");\n\tvar curVal = $(checkBoxObj).data(\"lastvalue\");\n\tvar curDate = $(checkBoxObj).data(\"lastdate\"); \n\t\n\t\n\t\n\tvar curNormInd = $(checkBoxObj).data(\"lastnorm\");\n\t//var normImg = \' \';\n\tvar normImg = \'\';\n\t\n\tif(curNormInd == \'N\'){\n\t\tnormImg = \'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="/eIPAD/images/BNI_NORMAL.gif\';\n\t}\n\telse if(curNormInd == \'H\'){\n\t\tnormImg = \'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="/eIPAD/images/BNI_High.gif\';\n\t}\n\telse if(curNormInd == \'L\'){\n\t\tnormImg = \'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="/eIPAD/images/BNI_Low.gif\';\n\t}\n\telse if(curNormInd == \'C\'){\n\t\tnormImg = \'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="/eIPAD/images/BNI_Critical.gif\';\n\t}\n\telse if(curNormInd == \'A\'){\n\t\tnormImg =\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="/eIPAD/images/BNI_Abnormal.gif\';\n\t}\n\telse if(curNormInd == \'G\'){\n\t\tnormImg = \'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="/eIPAD/images/BNI_CriticallyHigh.gif\';\n\t}\n\telse if(curNormInd == \'S\'){\n\t\tnormImg = \'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="/eIPAD/images/BNI_CriticallyLow.gif\';\n\t}\n\telse{\n\t\tnormImg = \'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="/eIPAD/images/BNoData.PNG\';\n\t}\n\t\n\t//Populate other items inside the graph box\n\t$(\"#ResSGraphTitle\"+graphNum).html(title);\n\tif(uom){\n\t\t$(\"#ResSGraphTitleUOM\"+graphNum).html(\"[\"+uom+\"]\");\n\t}\n\t\n\t$(\"#ResSGraphUOM\"+graphNum).html(uom);\n\t$(\"#ResSGraphCurrentValue\"+graphNum).html(curVal);\n\t$(\"#ResSGraphCurrentDate\"+graphNum).html(curDate);\n\t\n\t\n\t$(\"#ResSGraphCurrentNormInd\"+graphNum).attr(\'src\',normImg);\n\t\n\tdrawSparklineGraph(graphNum);\n\n\t\n}\n\nfunction drawSparklineGraph(graphNum){\n\t\n\tvar checkBoxID = $(\"[data-count=\'\"+graphNum+\"\']\").attr(\"id\");\n\tvar checkBoxObj= document.getElementById(checkBoxID);\n\t\n\tvar valCSV = $(checkBoxObj).data(\"valuecsv\"); \n\tvar dateCSV = $(checkBoxObj).data(\"datecsv\");\n\tvar valArr = $.map(valCSV.toString().split(\',\'), function(value){\n\t    return parseFloat(value);\n\t});\n\tvar dateArr = $.map(dateCSV.toString().split(\',\'), function(value){\n\t    return new Date(value);\n\t});\n\t//alert(dateArr);\n\t//valArr.slice(0, 25);\n\tvalArr = valArr.reverse();\n\t//draw graph \n\t/* $(\"#ResSGraphArea\"+graphNum).kendoSparkline({\n        type: \"line\",\n        data: valArr,\n        tooltip: {\n            format: \"{0}\"\n        }\n    }); */\n\tvar scatterChartData = [];\n\tfor(i=0;i<valArr.length;i++){\n\t\tvar xyPair = [dateArr[i],valArr[i]];\n\t\tscatterChartData.push(xyPair);\n\t}\n\t\n\t$(\"#ResSGraphArea\"+graphNum).kendoChart({\n\t      \n        series: [{\n     \t   type: \"scatterLine\",\n     \t   data: scatterChartData,\n     \t   markers: {\n     \t\t   visible: false \n            }\n        }],\n       \n        xAxis: {\n     \t    type: \"date\",\n     \t    baseUnit: \"months\",\n     \t    visible: false\n     \t  },\n     \n       \n        yAxis: {\n     \t    majorGridLines: {\n     \t      visible: false\n     \t    },\n        visible: false\n     \t  },\n       \n        tooltip: {\n               visible: true,\n               format: \"{1}\",\n                \n           } \n    });\n\t\n\t\n}\n\nfunction hideSGraph(graphNum){\n\t$(\"#ResultSGraphContainer\"+graphNum).hide();\n\t$(\"[data-count=\'\"+graphNum+\"\']\").prop(\'checked\', false);\n\tvar checkBoxID = $(\"[data-count=\'\"+graphNum+\"\']\").attr(\"id\");\n\tvar checkBoxObj= document.getElementById(checkBoxID);\n\tresultItemsSelect(checkBoxObj);\n}\n\nfunction hideChartLeftPane(){\n\t\n\tdestroyAllVisibleSparklines();\n\t$(\"#ResChartLeftDiv\").css(\"width\",\"0px\");\n\t$(\"#ResChartLeftDiv\").hide();\n\t\n\t$(\"#ResChartLeftPanelButton\").css(\"display\",\"table-cell\");\n\t$(\"#ResChartLeftPanelButton\").css(\"width\",\"60px\");\n\t//$(\"#ResChartLeftPanelButton\").css(\"width\",\"60px\");\n\tcomputeResultDataFrameWidth();\n\tsetSparklineGraphBoxWidth();\n\t\n\t\n\talterSparkLineWidth();\n\tbuildAllVisibleSparklines();\n}\n\nfunction showChartLeftPane(){\n\t\n\tdestroyAllVisibleSparklines();\n\t$(\"#ResChartLeftDiv\").show();\n\t$(\"#ResChartLeftDiv\").css(\"width\",\"305px\");\n\t$(\"#ResChartLeftPanelButton\").css(\"width\",\"0px\");\n\t$(\"#ResChartLeftPanelButton\").hide();\n\t\n\t//$(\"#ResChartLeftPanelButton\").css(\"width\",\"0px\");\n\tcomputeResultDataFrameWidth();\n\t\n\tsetSparklineGraphBoxWidth();\n\talterSparkLineWidth();\n\t\n\t//alert(SparkLineGraphBoxWidth);\n\t\n\tbuildAllVisibleSparklines();\n\t\n}\n\nfunction destroyAllVisibleSparklines(){\n\t$(\".resSGraphBoxAdjWid\").each(function(index,value){\n\t\tid = $(this).attr(\"id\");\n\t\tif($(\"#\"+id).is(\':visible\')){\n\t\t\t//alert(\"destoryed\"+id);\n\t\t\tvar sparkline = $(\"#\"+id).data(\"kendoSparkline\");\n\t\t\tsparkline.destroy();\n\t\t\t$(this).empty();\n\t\t}\n\t});\n\t\n}\nfunction buildAllVisibleSparklines(){\n\t$(\".resSGraphBoxAdjWid\").each(function(index,value){\n\t\tid = $(this).attr(\"id\");\n\t\tif($(\"#\"+id).is(\':visible\')){\n\t\t\t//alert(\"built\"+id);\n\t\t\tvar sparkline = $(\"#\"+id).data(\"kendoSparkline\");\n\t\t\tvar graphNum = $(this).data(\"count\");\n\t\t\tdrawSparklineGraph(graphNum)\n\t\t}\n\t});\n\t\n}\n\nfunction openLineGraph(graphNum){\n\t $(\'#ResChartCommonPopUpContainer\').css(\"display\" , \"block\");\n\t $(\"#dvMez\").show();\n\t $(\"#dvMez\").data(\"popid\",\"ResChartCommonPopUpContainer\");\n\t setTimeout(function() {\n\t\t\t$(\"#dvMez\").on(\"click\",closeMezzaineWindow);\n\t\t}, 500);\n\tvar checkBoxID = $(\"[data-count=\'\"+graphNum+\"\']\").attr(\"id\");\n\tvar obj = document.getElementById(checkBoxID);\n\tvar gcategories = $(obj).data(\"datecsv\");\n\tvar gcategories_arr = gcategories.split(\",\");\n\t\n\tvar gdata = $(obj).data(\"valuecsv\");\n\tvar gdata_arr = $.map(gdata.toString().split(\',\'), function(value){\n\t    return parseFloat(value);\n\t});\n\t\n\t//show only latest 25 results in graph\n\tgdata_arr.slice(0, 25);\n\tgcategories_arr.slice(0,25);\n\t\n\tgdata_arr.reverse();\n\tgcategories_arr.reverse();\n\t\n\tvar normalLow = 0;\n\tvar normalHigh = 0;\n\tnormalLow = parseFloat($(obj).data(\"normallow\"));\n\tnormalHigh = parseFloat($(obj).data(\"normalhigh\"));\n\t\n\tvar uom = $(obj).data(\"uom\");\n\tvar valueAxisTitle =\"\";\n\tif(uom){\n\t\tvalueAxisTitle = \"Values in \" + uom;\n\t}\n\tvar resultName = $(obj).data(\"resultname\");\n\tvar totalResultsCount = $(\"#totalResultsCount\").val();\n\t\n\t$(\"#ResLGraphTitle\").html(resultName+\" (\" + uom+\")\");\n\t\n\tvar scatterChartData = [];\n\t   for(i=0;i<gcategories_arr.length;i++){\n\t\t   var xyPair = [new Date(gcategories_arr[i]),gdata_arr[i]];\n\t\t   scatterChartData.push(xyPair);\n\t   }\n\t   //alert(scatterChartData);\n\n    $(\"#ResLGraphBox\").kendoChart({\n        title: {\n            text: \"\"\n        },\n        legend: {\n            position: \"bottom\"\n        },\n        chartArea: {\n            background: \"\"\n        },\n        seriesDefaults: {\n            \n            style: \"smooth\"\n        },\n        series: [{\n     \t   type: \"scatterLine\",\n     \t   data: scatterChartData,\n     \t   \n     \t   markers: {\n                size: 10\n            }\n             \n        }],\n        valueAxis: {\n            labels: {\n                format: \"{0:d}\" \n            },\n            title: {\n         \t      text: valueAxisTitle ,\n         \t      font: \"12px Arial\",\n         \t      rotation: -90\n         \t    },\n           \n            line: {\n                visible: false\n            },\n            axisCrossingValue: -10\n        },\n        categoryAxis: {\n     \t   labels: {\n     \t\t      rotation: 95\n     \t\t    },\n             \n            axisCrossingValue: -10,\n            baseUnitStep: \"auto\",\n          \n\n            majorGridLines: {\n                visible: false\n            }\n        },\n        xAxis: {\n     \t    type: \"date\",\n     \t    baseUnit: \"days\",\n     \t    labels: {\n     \t        dateFormats: {\n     \t          days: \"MMM-d\"\n     \t        }\n     \t      }\n\t\t  },\n       yAxis: {\n     \t   \n             plotBands: [\n                       { from: normalLow, \n                     \t  to: normalHigh , \n                     \t  color: \"Green\", \n                     \t  opacity: 0.4 }\n                     ]\n           },\n        tooltip: {\n            visible: true,\n            format: \"Date:{0:dd-MMM-yy HH:mm}<br>Value:{1}\",\n        }\n    });\n\t\n\n\t\n\tif(graphNum==1){\n\t\t//no prev navi\n\t\t$(\"#ResLGraphPrevNavi\").attr(\"onclick\",\"\");\n\t\t$(\"#ResLGraphPrevNaviImg\").attr(\"src\",\"\");\n\t}else{\n\t\t$(\"#ResLGraphPrevNavi\").attr(\"onclick\",\"openLineGraph(\"+(graphNum-1)+\")\");\n\t\t$(\"#ResLGraphPrevNaviImg\").attr(\"src\",\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="/eIPAD/images/ChartLeftArrow.PNG\");\n\t}\n\t\n\tif(graphNum==totalResultsCount){\n\t\t//no prev navi\n\t\t$(\"#ResLGraphNextNavi\").attr(\"onclick\",\"\");\n\t\t$(\"#ResLGraphNextNaviImg\").attr(\"src\",\"\");\n\t}else{\n\t\t$(\"#ResLGraphNextNavi\").attr(\"onclick\",\"openLineGraph(\"+(graphNum+1)+\")\");\n\t\t$(\"#ResLGraphNextNaviImg\").attr(\"src\",\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="/eIPAD/images/ChartRightArrow.PNG\");\n\t}\n\t\n\t$(\"[id^=\'ResLGraphPagi\']\").each(function(){\n\t\t$(this).removeClass(\"selectedPageIcons\").addClass(\"normalPageIcons\");\n\t});\n\t$(\"#ResLGraphPagi\"+graphNum).removeClass(\"normalPageIcons\").addClass(\"selectedPageIcons\");\n}\n\n\n</script>\n<style>\n\n.resChartHeadArrowTriCell{\n\twidth:15px\n}\n.resChartHeadArrowbtnCell{\n\twidth:30px\n}\n.resChartHeadArrowBtnTabl{\n\theight:30px;\n\twidth:30px;\n}\n.resGraphLeftItems{\n\tpadding: 0px; \n\toverflow: hidden;\n\tposition:relative;\n\twidth:300px;\n}\n.resChartHeadArrowProj{\n\theight:23px;\n\twidth:5px;\n\tpadding-top:6px;\n}\n.resChartLeftPaneTog{\n\twidth:60px;\n\tpadding-top:10px;\n}\n.resSGraphContBorder{\n\tmargin:5px;\n\tborder:2px solid #81ABBC;\n\tmin-height:120px;\n}\n.resSGraphEnclosure{\n\tmargin:5px;\n}\n.resSGraphCurrValCell{\n\tdisplay:block;\n\ttext-align:center;\n\tfloat:right;\n\tmargin:5px;\n\twidth:125px\n}\n</style>\n</head>\n\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n<body>\n   \t<div id=\"divParent\" class=\"divParent\" data-role=\"page\" style=\"padding: 0px\">\n\t\t<form name=\"frmRecordAllergy\" id=\"frmRecordAllergy\" id=\"frmRecordAllergy\" method=\"post\" style=\"width: 100%; height: 100%\" action=\"\">\n\n\t\t\t\n\t\t\t<div id=\"allergyHeader\" class=\"AllergyHeader\" style=\"padding: 0px\"\n\t\t\t\tdata-role=\"none\">\n\t\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" class=\"tbAllergyHeader\"\n\t\t\t\t\tdata-role=\"none\">\n\t\t\t\t\t<tr class=\"normalTr\">\n\t\t\t\t\t\t<td class=\"normalTd\">\n\t\t\t\t\t\t\t<div class=\"RecordAllergyHeader RecordAllergyHeaderTheme\">\n\t\t\t\t\t\t\t\t<div class=\"RecordAllergyTable\">\n\t\t\t\t\t\t\t\t\t<div class=\"normalRow\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyCell\" style=\"width: 99%; text-align: left\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"allergyHeaderPageTitle ipHeaderPageTitleTheme\">Results Graph</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyCell\" style=\"width: 1%\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"RecordAllergyTable\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"normalRow\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyCell\" style=\"width: auto; text-align: right\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"buttonContainer\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"WidgetButtonTheme\" onclick=\"gotoCS()\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="/eIPAD/images/CS_Close16x16.png\"/>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t</div>\n\t\t\t<div id=\"divcnt\" class=\"divAllergyContent divResChartsContentTheme\" style=\"padding: 0px; overflow: hidden\" data-role=\"none\">\n\t\t\t\t<!-- <div style=\"width: 100%; height: auto; overflow: auto\" data-role=\"none\"> -->\n\t\t\t\t\t<div data-role=\"none\" style=\"width: 100%; height: auto\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t\t<div style=\"\" id=\"ResChartLeftDiv\" class=\"resChartLeftDiv\">\n\t\t\t\t\t\t<div style=\"display:table;width:100%\">\n\t\t\t\t\t\t\t<div style=\"display:table-row\">\n\t\t\t\t\t\t\t\t<div style=\"display:table-cell\"> <!-- Cell that contains Result items + Result Header -->\n\t\t\t\t\t\t\t\t\t<div style=\"display:table;\" class=\"resChartVwHeadTheme resChartVwItemRow\"  id=\"ResGraphLeftHeader\">\n\t\t\t\t\t\t\t\t\t \t<div style=\"display:table-row\">\n\t\t\t\t\t\t\t\t\t \t\t<div style=\"display:table-cell;vertical-align:middle;text-align:left;\" class=\"\"><div class=\"resChartVwItemText\">Selected Items - <div id=\"SelectedItemsCount\" style=\"display:inline\">0</div></div></div>\n\t\t\t\t\t\t\t\t\t \t\t<div style=\"display:table-cell;vertical-align:middle;text-align:center;\" class=\"resChartHeadArrowTriCell\"><div class=\"resChartHeadArrowTriTheme\"></div></div>\n\t\t\t\t\t\t\t\t\t \t\t<div style=\"display:table-cell;vertical-align:middle;text-align:center;\" class=\"resChartHeadArrowbtnCell\">\n\t\t\t\t\t\t\t\t\t\t \t\t<div style=\"display:table;\" class=\"resChartHeadArrowBtnTabl resChartHeadArrowTheme\">\n\t\t\t\t\t\t\t\t\t\t \t\t\t<div style=\"display:table-row\">\n\t\t\t\t\t\t\t\t\t\t \t\t\t\t<div style=\"display:table-cell;vertical-align:middle;text-align:center\">\n\t\t\t\t\t\t\t\t\t\t \t\t\t\t\t<img src=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="/eIPAD/images/MenuIcon.png\" onclick=\"hideChartLeftPane()\"/>\n\t\t\t\t\t\t\t\t\t\t \t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t \t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t \t\t</div>\n\t\t\t\t\t\t\t\t\t\t \t</div>\n\t\t\t\t\t\t\t\t\t \t</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t\t\t<div id=\"ResGraphLeftItems\" class=\"resGraphLeftItems\" style=\"\" data-role=\"none\">\n\t\t\t\t\t\t\t<div style=\"width: 100%; height: auto; overflow: auto\" data-role=\"none\">\n\t\t\t\t\t\t\t<div style=\"display:table;width:100%\">\n\t\t\t\t\t\t\t<div style=\"display:table-row\">\n\t\t\t\t\t\t\t\t<div style=\"display:table-cell\">\t\t\n\t\t\t\t\t\t\t<!--  Lab, surgery, diagnostics, radiology Results Starts -->\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<div style=\"display:table;width:100%;\" class=\"resChartVwCatHeadTheme resChartVwItemRow\">\n\t\t\t\t\t\t\t\t\t \t<div style=\"display:table-row\">\n\t\t\t\t\t\t\t\t\t \t\t<div style=\"display:table-cell;vertical-align:middle;text-align:left;\" class=\"\">\n\t\t\t\t\t\t\t\t\t \t\t\t<div class=\"resChartVwItemText\">";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</div>\n\t\t\t\t\t\t\t\t\t \t\t</div>\n\t\t\t\t\t\t\t\t\t \t</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t\t\t\t\t<div style=\"display:table;width:100%;\" class=\"resChartVwSubCatHeadTheme resChartVwItemRow\">\n\t\t\t\t\t\t\t\t\t \t<div style=\"display:table-row\">\n\t\t\t\t\t\t\t\t\t \t\t<div style=\"display:table-cell;vertical-align:middle;text-align:left;\">\n\t\t\t\t\t\t\t\t\t \t\t\t<div style=\"display:table;\">\n\t\t\t\t\t\t\t\t\t \t\t\t\t<div style=\"display:table-row\">\n\t\t\t\t\t\t\t\t\t \t\t\t\t\t<div style=\"display:table-cell\" class=\"resChartVwItemChkBox\">\n\t\t\t\t\t\t\t\t\t \t\t\t\t\t\t<div class=\"csChkBoxTheme3\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" id=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="__";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" data-code=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" data-resultgraph = \"false\"  onclick = \"resultItemsSelect(this)\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label for=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\"></label>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t \t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t \t\t\t\t\t<div style=\"display:table-cell\" class=\"resChartVwItemText\">";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</div>\n\t\t\t\t\t\t\t\t\t \t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t \t\t\t</div>\n\t\t\t\t\t\t\t\t\t \t\t</div>\n\t\t\t\t\t\t\t\t\t \t</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t\t\t\t\t\t<div style=\"display:table;width:100%;\">\n\t\t\t\t\t\t\t\t\t \t<div style=\"display:table-row\">\n\t\t\t\t\t\t\t\t\t \t\t<div style=\"display:table-cell;vertical-align:middle;text-align:left;\" class=\"resChartVwGrpContTheme\">\n\t\t\t\t\t\t\t\t\t \t\t\t<div style=\"margin:3px\" class=\"resChartVwGrpContTheme\">\n\t\t\t\t\t\t\t\t\t\t \t\t\t<div style=\"display:table;width:100%\">\n\t\t\t\t\t\t\t\t\t\t \t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\t\t\t\t\t\t\t \t\t\t<div style=\"display:table-row\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell;vertical-align:middle;\" class=\"resChartGrpItemTheme resChartVwItemRow\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell\" class=\"resChartVwItemChkBox\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t\t\t<div class=\"csChkBoxTheme3\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" id=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" data-code = \"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" data-resultgraph = \"false\"  onclick = \"resultItemsSelect(this)\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label for=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\"></label>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t\t<div style=\"display:table-cell\" class=\"resChartVwItemText\">";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t \t\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t\t\t\t\t\t\t \t\t\t\t<div style=\"display:table-row\">\n\t\t\t\t\t\t\t\t\t\t \t\t\t\t\t<div style=\"display:table-cell;vertical-align:middle;\" class=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 =" resChartVwItemRow\">\n\t\t\t\t\t\t\t\t\t\t \t\t\t\t\t\t<div style=\"display:table;\">\n\t\t\t\t\t\t\t\t\t\t \t\t\t\t\t\t\t<div style=\"display:table-row;\">\n\t\t\t\t\t\t\t\t\t\t \t\t\t\t\t\t\t\t<div style=\"display:table-cell\" class=\"resChartVwItemChkBox\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t\t\t<div class=\"csChkBoxTheme3\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" id=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" data-count=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\" data-resultgraph = \"true\"  \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tdata-datecsv=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\" data-valuecsv=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tdata-uom=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\" data-lastvalue=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\"  data-lastdate=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\" \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tdata-lastnorm=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\" data-resultname = \"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\" \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tonclick = \"resultItemsSelect(this)\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label for=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</div>\n\t\t\t\t\t\t\t\t\t\t \t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t \t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t \t\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t\t\t\t\t\t\t\t \t\t\t</div>\n\t\t\t\t\t\t\t\t\t \t\t\t</div>\n\t\t\t\t\t\t\t\t\t \t\t</div>\n\t\t\t\t\t\t\t\t\t \t</div>\n\t\t\t\t\t\t\t\t\t</div>\t\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t<!--  Lab, surgery, diagnostics, radiology Results Ends -->\n\t\t\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t\t\t<!--  Others Results Starts -->\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t\t\t\t\t\t<div style=\"display:table;width:100%;\" class=\"resChartVwCatHeadTheme resChartVwItemRow\">\n\t\t\t\t\t\t\t\t\t \t<div style=\"display:table-row\">\n\t\t\t\t\t\t\t\t\t \t\t<div style=\"display:table-cell;vertical-align:middle;text-align:left;\" class=\"\">\n\t\t\t\t\t\t\t\t\t \t\t\t<div class=\"resChartVwItemText\">Others</div> <!-- TODO Localize -->\n\t\t\t\t\t\t\t\t\t \t\t</div>\n\t\t\t\t\t\t\t\t\t \t</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="</div>\n\t\t\t\t\t\t\t\t\t \t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t \t\t\t</div>\n\t\t\t\t\t\t\t\t\t \t\t</div>\n\t\t\t\t\t\t\t\t\t \t</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t<div style=\"display:table;width:100%;\">\n\t\t\t\t\t\t\t\t\t \t<div style=\"display:table-row\">\n\t\t\t\t\t\t\t\t\t \t\t<div style=\"display:table-cell;vertical-align:middle;text-align:left;\" class=\"resChartVwGrpContTheme\">\n\t\t\t\t\t\t\t\t\t \t\t\t<div style=\"margin:3px\" class=\"resChartVwGrpContTheme\">\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t \t\t\t<div style=\"display:table;width:100%\">\n\t\t\t\t\t\t\t\t\t\t \t\t\t";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell;vertical-align:middle;\" class=\"resChartGrpItemTheme resChartVwItemRow\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell\" class=\"resChartVwItemChkBox\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t\t\t<div class=\"csChkBoxTheme3\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" id=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t \t\t\t\t";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\">\n\t\t\t\t\t\t\t\t\t\t \t\t\t\t\t<div style=\"display:table-cell;vertical-align:middle;\" class=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tdata-normallow=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\" data-normalhigh=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tonclick = \"resultItemsSelect(this)\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label for=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t\t\t\t\t\t\t\t\t \t\t\t</div>\n\t\t\t\t\t\t\t\t\t \t\t\t\t\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t \t\t</div>\n\t\t\t\t\t\t\t\t\t \t</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t<!--  Others Results Ends -->\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t<div style=\"display:table-cell\"><!-- cell that contains sticking out part of the first row.(Bow like structure for expanding and collapsing the first column) -->\n\t\t\t\t\t\t\t\t\t<div class=\"resChartHeadArrowProj resChartHeadArrowTheme\"></div>\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div> \n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\n\t\t\t\t\t\t<div id=\"ResChartRightDiv\"  style=\"float:right\">\n\t\t\t\t\t\t\t<div id=\"ResGraphRightItems\" style=\"padding: 0px; overflow: hidden;position:relative\" data-role=\"none\"><!-- Scroll wrapper -->\n\t\t\t\t\t\t\t\t<div style=\"width: 100%; height: auto; overflow: auto\" data-role=\"none\"> <!-- Scroll scroller -->\n\t\t\t\t\t\t\t\t<div style=\"display:table;width:100%\">\n\t\t\t\t\t\t\t\t<div style=\"display:table-row\">\n\t\t\t\t\t\t\t\t<div style=\"display:table-cell;vertical-align:top;text-align:center;display:none\" class=\"resChartLeftPaneTog\" id=\"ResChartLeftPanelButton\">\n\t\t\t\t\t\t\t\t\t<div class=\"WidgetButtonTheme\" data-role=\"none\" onclick=\"showChartLeftPane()\"><img src=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="/eIPAD/images/MenuIcon.png\"></div>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t<div style=\"display:table-cell\"> \n\t\t\t\t\t\t\t\t\t<div  class=\"resSGraphContBorder\">\n\t\t\t\t\t\t\t\t\t<div class=\"resSGraphEnclosure\">\n\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t\t\t\t\t\t\t\t\t<div id=\"ResultSGraphContainer";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\" style=\"display:none;padding-top:5px;padding-bottom:5px;padding-left:2px;padding-right:2px;\" >\n\t\t\t\t\t\t\t\t\t\t<div style=\"border:1px solid #aaa;\">\n\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table;width:100%;\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\"><!-- Sparkline graph header row -->\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell;\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table;width:100%\" class=\"resSGraphHeaderTheme\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell;height:30px;vertical-align:middle;text-align:left\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"padding-left:4px\"> <div id=\"ResSGraphTitle";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\" style=\"display:inline-block\"></div><div style=\"display:inline\" id=\"ResSGraphTitleUOM";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\"></div></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell;width:30px;height:30px;vertical-align:middle;text-align:center\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-role = \"none\" class=\"resSGraphCloseTheme\" onclick=\"hideSGraph(";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 =")\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img src = \"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="/eIPAD/images/Close-small.png\" style =\"margin-top:5px;margin-left:2px\"></img>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\n\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\"><!-- Sparkline graph body row -->\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell;width:100%;height:130px\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:block;vertical-align:middle;float:left\"> <!--  Sparkline graph -->\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"ResSGraphArea";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\" style=\"height:120px;\" class=\"resSGraphBoxAdjWid\"  onclick=\"openLineGraph(";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 =")\"></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"resSGraphCurrValCell\"><!-- Current value container -->\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-role = \"none\" class=\"currrentVitalsContainerTheme\" style=\"display:table;width:115px;\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell;vertical-align:middle;text-align:center;\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"\" id=\"ResSGraphCurrentNormInd";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\"></img>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t<div style=\"display:table-row\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell;vertical-align:middle;text-align:center;max-width:110px;\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t\t<div data-role = \"none\" class=\"vitalsValueTheme\" id=\"ResSGraphCurrentValue";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\" style=\"white-space: nowrap;overflow:hidden;text-overflow: ellipsis;\"></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell;vertical-align:middle;text-align:center;max-width:110px;\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-role = \"none\" class=\"vitalsUnitTheme\" id=\"ResSGraphUOM";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\" style=\"white-space: nowrap;overflow:hidden;text-overflow: ellipsis;\"></div>\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t<div style=\"display:table-row\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell;vertical-align:middle;text-align:center\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t\t<div data-role = \"none\" class=\"vitalsDateTheme\" id=\"ResSGraphCurrentDate";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\"></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\n\t\t\t\t\t\t\t</div>\n\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\n\t\t\t\t\t\t<div class=\"WidgetVwErrContainer\">\n\t\t\t\t\t\t\t<div class=\"WidgetErrorResponse WidgetErrorResponseTheme\">No results available for the patient</div><!-- TODO Localize -->\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\n\t\t\t\t\t</div>\n\t\t\t\t<!-- </div> -->\n\t\t\t</div>\n\t\t\t<!-- scrolling div ends -->\n\t\t\t\n\t\t\t\n\t\t\t<!-- line chart graph container starts -->\n\t\t\t<div data-role = \"none\" id = \"dvMez\" class = \"dvMezzaine\" data-popid=\"\"></div>\n\t\t\t<div data-role = \"none\" class = \"resChartCommonPopUpContainer\" id = \"ResChartCommonPopUpContainer\">\n\t\t\t \t<div data-role=\"none\" class=\"resLineChartContainer\" id=\"lineChartContainer\">\n\t\t\t\t\t<div id=\"divParent\" class=\"divParent\" data-role=\"none\" style=\"padding: 0px\">\n\t\t\t\t\t\t<div data-role = \"none\" class = \"lineChartTitle\" onclick = \"closeLineChart()\">\n\t\t\t\t\t\t\t<div data-role = \"none\" class = \"graphTitle\">\n\t\t\t\t\t\t\t\t<div data-role = \"none\" class = \"dvTitle\" id=\"ResLGraphTitle\"></div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t<div data-role = \"none\" class = \"graphCloseButtonArea\">\n\t\t\t\t\t\t\t\t<div data-role = \"none\" class = \"graphCloseButton graphCloseButtonTheme\">\n\t\t\t\t\t\t\t\t\t<img src = \"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="/eIPAD/images/Close10x10.PNG\" style = \"position:relative;margin-top:3px;margin-left : 5px\"></img>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t<div data-role = \"none\" class = \"graphContainer\">\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<div data-role = \"none\" class = \"graphArea\">\n\t\t\t\t\t\t\t   <div data-role = \"none\" class = \"navigateIconsContainer\" id=\"ResLGraphPrevNavi\" onclick = \"navigatePage(\'Previous\')\">\n\t\t\t\t\t\t\t\t<div data-role = \"none\" class = \"navigateIcons\">\n\t\t\t\t\t\t\t\t\t<img id=\"ResLGraphPrevNaviImg\" src = \"";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="/eIPAD/images/ChartLeftArrow.PNG\" ></img>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t  </div>\n\t\t\t\t\t\t\t\t<div data-role = \"none\" class = \"lineChartArea\">\n\t\t\t\t\t\t\t\t\t<div data-role = \"none\" id= \"ResLGraphBox\"></div>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t  <div data-role = \"none\" class = \"navigateIconsContainer\" id=\"ResLGraphNextNavi\" onclick = \"navigatePage(\'Next\')\">\n\t\t\t\t\t\t\t\t<div data-role = \"none\" class = \"navigateIcons\">\n\t\t\t\t\t\t\t\t\t<img id=\"ResLGraphNextNaviImg\" src = \"";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="/eIPAD/images/ChartRightArrow.PNG\" ></img>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t </div>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t<div data-role = \"none\" class = \"graphFooter\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\n\t\t\t\t\t\t\t  <div data-role = \"none\" class = \"normalPageIcons\" id=\"ResLGraphPagi";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\" style = \"margin-bottom : 5px\"></div>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</div>\n\t\t\t   </div>\n\t  \t\t</div> \n\t\t\t<!-- popup container ends -->\n\t\t\t<input type=\"hidden\" name=\"hdnPath\" id=\"hdnPath\" id=\"hdnPath\" value=\"";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\" /> \n\t\t\t<input type=\"hidden\" name=\"totalResultsCount\" id=\"totalResultsCount\" id=\"totalResultsCount\" value=\"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\"\n\t\t</form>\n\t</div>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block1Bytes, _wl_block1);


Locale appLocale;
if(session.getAttribute("LOCALE")!=null && !session.getAttribute("LOCALE").equals(""))
	appLocale = new Locale((String)session.getAttribute("LOCALE"));
else 
	appLocale = new Locale("en");
ResourceBundle csResBundle = ResourceBundle.getBundle("eIPAD.chartsummary.common.resourcebundle.cslabels", appLocale);

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
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block23Bytes, _wl_block23);

int totalResultsCount = (Integer)request.getAttribute("TotalResultsCount");
ResultsResponse labResultsResponse = (ResultsResponse)request.getAttribute("LabResultsResponse"); 
ResultsResponse radiologyResultsResponse = (ResultsResponse)request.getAttribute("RadiologyResultsResponse");
ResultsResponse surgeryResultsResponse = (ResultsResponse)request.getAttribute("SurgeryResultsResponse"); 
ResultsResponse diagnosticsResultsResponse = (ResultsResponse)request.getAttribute("DiagnosticsResultsResponse"); 
ResultsResponse othersResultsResponse = (ResultsResponse)request.getAttribute("OthersResultsResponse"); 

ArrayList<ResultsResponse> resultsResponseList = new ArrayList<ResultsResponse>();
if(!labResultsResponse.isEmptyDataResponse()&& labResultsResponse.isSuccessResponse()){
	resultsResponseList.add(labResultsResponse);
}
if(!radiologyResultsResponse.isEmptyDataResponse()&& radiologyResultsResponse.isSuccessResponse()){
	resultsResponseList.add(radiologyResultsResponse);
}
if(!surgeryResultsResponse.isEmptyDataResponse()&& surgeryResultsResponse.isSuccessResponse()){
	resultsResponseList.add(surgeryResultsResponse);
}
if(!diagnosticsResultsResponse.isEmptyDataResponse()&& diagnosticsResultsResponse.isSuccessResponse()){
	resultsResponseList.add(diagnosticsResultsResponse);
}
//Others result is not added since it has to be grouped by the category unlike by the subcategory
/* if(!othersResultsResponse.isEmptyDataResponse()&& othersResultsResponse.isSuccessResponse()){
	resultsResponseList.add(othersResultsResponse);
} */

int globalResultItemCounter = 0;

            _bw.write(_wl_block24Bytes, _wl_block24);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block25Bytes, _wl_block25);
if(totalResultsCount>0){ 
							
							ResultsResponse resultsResponse;
							ArrayList<ResultHO> resultHOList;
							ResultHO resultHO;
							String resultCategoryCode;
							ArrayList<ResultSubCategory> resultSubCategoryList;
							ResultSubCategory resultSubCategory;
							String resultSubCategoryCode;
							ArrayList<ResultGroupItem> resultGroupItemList;
							ResultGroupItem resultGroupItem;
							ArrayList<ResultValue> resultValueList;
							ResultValue resultValue;
						
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block27Bytes, _wl_block27);
for(int h=0;h<resultsResponseList.size();h++){ 
									resultsResponse = resultsResponseList.get(h);
									resultHOList = resultsResponse.getResults();
									for(int i=0;i<resultHOList.size();i++){
										resultHO = resultHOList.get(i);
										resultCategoryCode = resultHO.getCategoryCode();
										resultSubCategoryList = resultHO.getResSubCat();
								
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(resultHO.getCategoryName() ));
            _bw.write(_wl_block29Bytes, _wl_block29);
for(int j=0;j<resultSubCategoryList.size();j++){
											resultSubCategory = resultSubCategoryList.get(j);
											resultSubCategoryCode = resultSubCategory.getSubCategoryCode();
											resultGroupItemList = resultSubCategory.getResGrpItems();
										
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(resultCategoryCode));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(resultSubCategoryCode));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(resultCategoryCode));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(resultSubCategoryCode));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(resultCategoryCode));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(resultSubCategoryCode));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(resultSubCategory.getSubCategoryName() ));
            _bw.write(_wl_block35Bytes, _wl_block35);
 if(!resultGroupItemList.isEmpty()){ 
            _bw.write(_wl_block36Bytes, _wl_block36);

										 			String curGroupCode = "";
										 			for(int k=0;k<resultGroupItemList.size();k++) {
										 				resultGroupItem = resultGroupItemList.get(k);
														String groupName = resultGroupItem.getResultGroupName();
														String groupCode = resultGroupItem.getResultGroupCode();
														String resultName = resultGroupItem.getResultName();
														String resultCode = resultGroupItem.getResultCode();
														String dataCodePrefix = "";
														String resultRowStyle = "";
														if(groupCode!=null && !groupCode.equals("") && !groupCode.equals(curGroupCode)){
										 				
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(resultCategoryCode));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(resultSubCategoryCode));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(groupCode));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(resultCategoryCode));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(resultSubCategoryCode));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(groupCode));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(resultCategoryCode));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(resultSubCategoryCode));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(groupCode));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf( groupName));
            _bw.write(_wl_block41Bytes, _wl_block41);
} 
														
														if(groupCode != null && !groupCode.equals("")){
															resultRowStyle="resChartItemTheme";
															dataCodePrefix = resultCategoryCode+"__"+resultSubCategoryCode+"__"+groupCode;
														}
														//if there is no group name, then the result row should be in grouprow style -- if(groupCode == null || groupCode.equals(""))
														else{
															resultRowStyle="resChartGrpItemTheme";
															dataCodePrefix = resultCategoryCode+"__"+resultSubCategoryCode;
														}
										 				
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(resultRowStyle));
            _bw.write(_wl_block43Bytes, _wl_block43);
 
													 							resultValueList = resultGroupItem.getResValues(); 
													 							resultValue = resultValueList.get(0);
													 							
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(dataCodePrefix));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(resultCode));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(++globalResultItemCounter));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dataCodePrefix));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(resultCode));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(resultGroupItem.getResultDateCSV("yyyy/MM/dd HH:mm:ss")));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(resultGroupItem.getResultValuesCSV()));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(resultGroupItem.getResultUom() ));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(resultValue.getDblAsStrValue() ));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(resultValue.getDate("dd/MM/yyyy HH:mm")));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(resultValue.getNormalcyInd().getNormalcyCode()));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(resultGroupItem.getResultName()));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(dataCodePrefix));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(resultCode));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf( resultName));
            _bw.write(_wl_block54Bytes, _wl_block54);

										 			curGroupCode = groupCode;
										 			} 
            _bw.write(_wl_block55Bytes, _wl_block55);
	}
										}
            _bw.write(_wl_block56Bytes, _wl_block56);

									}
								} 
            _bw.write(_wl_block57Bytes, _wl_block57);
if(!othersResultsResponse.isEmptyDataResponse() && othersResultsResponse.isSuccessResponse()){ 
									resultHOList = othersResultsResponse.getResults();
									
								
            _bw.write(_wl_block58Bytes, _wl_block58);

									for(int i=0;i<resultHOList.size();i++){
										resultHO = resultHOList.get(i);
										resultCategoryCode = resultHO.getCategoryCode();
										resultSubCategoryList = resultHO.getResSubCat();
								
            _bw.write(_wl_block59Bytes, _wl_block59);
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(resultCategoryCode));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(resultCategoryCode));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(resultCategoryCode));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(resultHO.getCategoryName() ));
            _bw.write(_wl_block60Bytes, _wl_block60);

										for(int j=0;j<resultSubCategoryList.size();j++){
											resultSubCategory = resultSubCategoryList.get(j);
											resultSubCategoryCode = resultSubCategory.getSubCategoryCode();
											resultGroupItemList = resultSubCategory.getResGrpItems();
								
            _bw.write(_wl_block61Bytes, _wl_block61);
 if(!resultGroupItemList.isEmpty()){ 
            _bw.write(_wl_block62Bytes, _wl_block62);

										 			String curGroupCode = "";
										 			for(int k=0;k<resultGroupItemList.size();k++) {
										 				resultGroupItem = resultGroupItemList.get(k);
														String groupName = resultGroupItem.getResultGroupName();
														String groupCode = resultGroupItem.getResultGroupCode();
														String resultName = resultGroupItem.getResultName();
														String resultCode = resultGroupItem.getResultCode();
														String dataCodePrefix = "";
														String resultRowStyle = "";
														
														if(groupCode!=null && !groupCode.equals("") && !groupCode.equals(curGroupCode)){
										 			
										 				
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(resultCategoryCode));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(resultSubCategoryCode));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(groupCode));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(resultCategoryCode));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(resultSubCategoryCode));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(groupCode));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(resultCategoryCode));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(resultSubCategoryCode));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(groupCode));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf( groupName));
            _bw.write(_wl_block64Bytes, _wl_block64);
} 
														if(groupCode != null && !groupCode.equals("")){
															resultRowStyle="resChartItemTheme";
															dataCodePrefix = resultCategoryCode+"__"+resultSubCategoryCode+"__"+groupCode;
														}
														//if there is no group name, then the result row should be in grouprow style -- if(groupCode == null || groupCode.equals(""))
														else{
															resultRowStyle="resChartGrpItemTheme";
															dataCodePrefix = resultCategoryCode+"__"+resultSubCategoryCode;
														}
										 				
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(resultRowStyle));
            _bw.write(_wl_block43Bytes, _wl_block43);
 
													 							resultValueList = resultGroupItem.getResValues(); 
													 							resultValue = resultValueList.get(0);
													 							
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(dataCodePrefix));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(resultCode));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(++globalResultItemCounter));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dataCodePrefix));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(resultCode));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(resultGroupItem.getResultDateCSV("yyyy/MM/dd HH:mm:ss")));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(resultGroupItem.getResultValuesCSV()));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(resultGroupItem.getResultUom() ));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(resultValue.getDblAsStrValue() ));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(resultValue.getDate("dd/MM/yyyy HH:mm")));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(resultValue.getNormalcyInd().getNormalcyCode()));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(resultGroupItem.getResultName()));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(resultGroupItem.getNormalLow() ));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(resultGroupItem.getNormalHigh() ));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(dataCodePrefix));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(resultCode));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf( resultName));
            _bw.write(_wl_block54Bytes, _wl_block54);

										 			curGroupCode = groupCode;
										 			} 
            _bw.write(_wl_block69Bytes, _wl_block69);
	}
										}
            _bw.write(_wl_block70Bytes, _wl_block70);

									}
								} 
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block72Bytes, _wl_block72);
for(int l=1;l<=globalResultItemCounter;l++) {
									
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(l ));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(l ));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(l));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(l));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(l ));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(l ));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(l ));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(l ));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(l));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(l));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(l));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(l));
            _bw.write(_wl_block84Bytes, _wl_block84);
} 
            _bw.write(_wl_block85Bytes, _wl_block85);
} else{
            _bw.write(_wl_block86Bytes, _wl_block86);
} 
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block90Bytes, _wl_block90);
for(int i=1;i<=globalResultItemCounter;i++){ 
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block92Bytes, _wl_block92);
} 
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf( totalResultsCount ));
            _bw.write(_wl_block95Bytes, _wl_block95);
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
