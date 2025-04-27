package jsp_servlet._eipad._jsp._chartwidgets;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.ResourceBundle;
import java.util.*;
import eIPAD.chartsummary.vitals.response.*;
import eIPAD.chartsummary.vitals.healthobject.*;

public final class __vitalstabularview extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/chartwidgets/VitalsTabularView.jsp", 1738426257271L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<!DOCTYPE html>\n<html>\n<head>\n    <meta name=\"apple-mobile-web-app-capable\" content=\"yes\" />\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\" />\n\t<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="/eIPAD/jquery.mobile-1.0.1.min.css\" />\n\t<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="/eIPAD/css/kendo.common.min.css\" />\n\t<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="/eIPAD/css/kendo.default.min.css\" />\n\t<script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script>\n\t<script src=\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="/eIPAD/kendo.web.min.js\"></script>\n\t<script src=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="/eIPAD/console.js\"></script>\n\t \n\t<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="/eIPAD/css/iPADNew.css\" />\n\t<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="/eIPAD/css/iPADThemeA.css\" />\n\t<script type=\"application/javascript\" src=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9_0 ="/eIPAD/js/iscroll.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n   <style>\n   .buttonContainer \n\t{\n\t\tmargin-right: 10px;\n\t}\n   .divVitalsContentTheme\n\t{\n\t\tbackground-color : #ffffff;\n\t\tborder-right: 1px solid #08415e;\n\t\tborder-left: 1px solid #08415e;\n\t\tborder-bottom: 1px solid #08415e;\n\t}\n\t.dvTBVContainer\n\t{\n\t\t  position:relative;\n\t\t  width : 100%;\n\t\t  min-height:75px;\n\t\t  height: auto;\n\t\t  vertical-align : middle;\n\t\t  \n\t}\n\t.dvTBVContainerTheme\n\t{\n\t\tborder-bottom : 1px solid #b2b2b21;\n\t\tbox-shadow:         0 -2px 2px 0 #d3d3d3  ;\n\t    -moz-box-shadow:    0 -2px 2px 0 #d3d3d3 ;\n\t    -webkit-box-shadow: 0 -2px 2px 0 #d3d3d3 ;\n\t\tbackground: #fffefe; /* Old browsers */\n\t\tbackground: -moz-linear-gradient(top,  #fffefe 0%,  #ebebeb 100%);/* FF3.6+ */\n\t\tbackground: -webkit-gradient(linear, left top, left bottom, color-stop(0%, #fffefe),color-stop(100%, #ebebeb) ); /* Chrome,Safari4+ */\n\t\tbackground: -webkit-linear-gradient(top, #fffefe 0%,  #ebebeb 100%);/* Chrome10+,Safari5.1+ */\n\t\tbackground: -o-linear-gradient(top, #fffefe 0%,  #ebebeb 100%);/* Opera 11.10+ */\n\t\tbackground: -ms-linear-gradient(top, #fffefe 0%,  #ebebeb 100%);/* IE10+ */\n\t\tbackground: linear-gradient(to bottom, #fffefe 0%,  #ebebeb 100%);/* W3C */\n\t\tfilter: progid:DXImageTransform.Microsoft.gradient(  startColorstr=\'#fffefe\',endColorstr=\'#ebebeb\', GradientType=0 ); /* IE6-9 */\n\t}\n\t.dvControlTable\n\t{\n\t\tdisplay : table;\n\t\twidth : 100%;\n\t\tmin-height : 75px;\n\t\theight: auto;\n\t}\n\t.dvControlRow\n\t{\n\t\tdisplay : table-row;\n\t\twidth : 100%;\n\t\tmin-height : 75px;\n\t\theight: auto;\n\t}\n\t.Cell1\n\t{\n\t\tdisplay : table-cell;\n\t\twidth : 30%;\n\t\tmin-height : 75px;\n\t\theight: auto;\n\t\tvertical-align : middle;\n\t\ttext-align : right;\n\t\tborder-right : 1px solid #ffffff;\n\t\t\n\t}\n\t.Cell2\n\t{\n\t\tdisplay : table-cell;\n\t\twidth : 70%;\n\t\tmin-height : 75px;\n\t\theight: auto;\n\t\tvertical-align : middle;\n\t\ttext-align : center;\n\t\tborder-left : 1px solid #d3d3d3;\n\t}\n\t.dvControlLabel\n\t{\n\t\tposition : relative;\n\t\tmargin-right : 10px;\n\t\tfont-family :Arial;\n        font-size : 13px;\n        font-weight : bold;\n        color : #44484a;\n\t\t\n\t}\n\t.dvTabularView\n\t{\n\t\tposition : relative;\n\t\t\n\t\tmargin-right : 10px;\n\t\tmargin-left : 10px;\n\t\tmargin-top : 10px;\n\t\toverflow-x : hidden;\n\t\tborder : 1px solid #055168 ;\n\t\theight : auto;\n\t}\n\t.dvdiscreteDesc\n\t{\n\t\tposition : relative;\n\t\tfloat : left;\n\t\twidth : 29.9%;\t\n\t\theight : 1000px;\n\t\tborder-right : 1px solid red;\n\t\tbackground-color : blue;\n\t}\n\t.dvdiscreteValue\n\t{\n\t\tposition : relative;\n\t\tfloat : left;\n\t\twidth : 69.9%;\n\t\toverflow:hidden;\n\t\theight : 1000px;\n\t\tborder-left : 1px solid orange;\n\t\tbackground-color : pink;\n\t}\n\t.dvResultsTable\n\t{\n\t\tdisplay : table;\n\t\tmin-height : 75px;\n\t\theight: auto;\t\n\t\twidth : 100%;\n\t}\n\t.dvReslutsRow1\n\t{\n\t\tdisplay : table-row;\n\t\twidth : 100%;\n\t\tmin-height : 75px;\n\t\theight: auto;\n\t\t\n\t}\n\t.dvResultsCol1\n\t{\n\t\tdisplay : table-cell;\n\t\twidth : 2%;\n\t\tmin-height : 75px;\n\t\theight: auto;\n\t\tvertical-align : top;\n\t\t\n\t\t\n\t}\n\t.dvResultsCol2\n\t{\n\t\tdisplay : table-cell;\n\t\twidth : 98%;\n\t\tmin-height : 75px;\n\t\theight: auto;\n\t\t\n\t\t/*border-left : 1px solid #00485e;*/\n\t\t\n\t}\n\t.dvVitalsResultHeader\n\t{\n\t\tposition : relative;\n\t\twidth : 100%;\n\t\theight : 40px;\n\t\twidth : 200px;\n\t}\n\t.dvResultsHeaderTable\n\t{\n\t\tdisplay : table;\n\t\twidth: 100%;\n\t\theight : 40px;\n\t}\n\t.dvResultsHeaderRow\n\t{\n\t\tdisplay : table-row;\n\t\twidth : 100%;\n\t\theight : 40px;\n\t}\n\t.dvResultsHeaderCol\n\t{\n\t\tdisplay : table-cell;\n\t\twidth : 100%;\n\t\theight : 40px;\t\n\t\tvertical-align : middle;\n\t\ttext-align : center;\n\t}\n\t.dvResultsValueTable\n\t{\n\t\tdisplay : table;\n\t\twidth: 100%;\n\t\theight : 60px;\n\t}\n\t.dvResultsValueRow\n\t{\n\t\tdisplay : table-row;\n\t\twidth : 100%;\n\t\theight : 60px;\n\t}\n\t.dvResultsValueCol\n\t{\n\t\tdisplay : table-cell;\n\t\twidth : 100%;\n\t\theight : 60px;\t\n\t\tvertical-align : middle;\n\t\ttext-align : center;\n\t}\n\t.dvHeaderDate\n\t{\n\t\tposition : relative;\n\t\twidth : 100px;\n\t\theight : 40px;\n\t\tfloat : left;\n\t\tvertical-align : middle;\n\t\ttext-align : center;\n\t\tborder-left : 1px solid #60adc4;\n\t\tborder-right : 1px solid #00485e;\n\t\t\n\t}\n\t.dvResultsHeaderBorder\n\t{\n\t\tborder-left : 1px solid #055168;\n\t\tborder-bottom : 1px solid #33373d;\n\t\tborder-right : 1px solid #00485e;\n\t\tborder-top : 1px solid #055168;\n\t\t/*\n\t\tfont-size : 12px;\n\t\tfont-weight : bold;\n\t\tfont-family :Arial;\n\t\tcolor : #ffffff;\n\t\tmargin-left : 10px;\n\t\ttext-shadow: 0px 2px #133d49;\n\t\t*/\n\t}\n\t.dvResultsValueBorder\n\t{\n\t\tborder-bottom : 1px solid #33373d;\n\t\tborder-right : 1px solid #055168;\n\t\tborder-top : 1px solid #055168;\n\t\t/*border-left : 1px solid #00485e;*/\n\t}\n\t.dvVitalsResultHeaderTheme\n\t{\n\t   \n\t\tbox-shadow:         0 -2px 2px 0 #133d49;\n\t    -moz-box-shadow:    0 -2px 2px 0 #133d49 ;\n\t    -webkit-box-shadow: 0 -2px 2px 0 #133d49 ;\n\t\tbackground: #439eba; /* Old browsers */\n\t\tbackground: -moz-linear-gradient(top,  #439eba 0%,  #227e99 100%);/* FF3.6+ */\n\t\tbackground: -webkit-gradient(linear, left top, left bottom, color-stop(0%, #439eba),color-stop(100%,  #227e99) ); /* Chrome,Safari4+ */\n\t\tbackground: -webkit-linear-gradient(top, #439eba 0%,   #227e99 100%);/* Chrome10+,Safari5.1+ */\n\t\tbackground: -o-linear-gradient(top, #439eba 0%,   #227e99 100%);/* Opera 11.10+ */\n\t\tbackground: -ms-linear-gradient(top, #439eba 0%,   #227e99 100%);/* IE10+ */\n\t\tbackground: linear-gradient(to bottom, #439eba 0%,   #227e99 100%);/* W3C */\n\t\tfilter: progid:DXImageTransform.Microsoft.gradient(  startColorstr=\'#439eba\',endColorstr=\' #227e99\', GradientType=0 ); /* IE6-9 */\n\t}\n\t.vitalsSwipeWrapper\n\t{\n\t\tposition : relative;\n\t\twidth : 200px;\n\t\tmin-height : 75px;\n\t\theight : auto;\n\t\toverflow : hidden;\n\t\t\n\t\t\n\t}\n\t.vitalsScroller\n\t{\n\t\tposition : relative;\n\t\tmin-height : 75px;\n\t\theight : auto;\n\t\twidth : 1000px;\n\t}\n\t.dvDateFont\n\t{\n\t    word-break: break-word;\n\t    vertical-align : top;\n\t    text-align : center;\n\t    margin-top : 14px;\n\t\tfont-size : 12px;\n\t\tfont-weight : bold;\n\t\tfont-family :Arial;\n\t\tcolor : #ffffff;\n\t\ttext-shadow: 0px 2px #133d49;\n\t\t\n\t}\n\t.dvHeaderFont\n\t{\n\t    position : relative;\n\t\tvertical-align : top;\n\t    padding-top : 14px;\n\t\tfont-size : 12px;\n\t\tfont-weight : bold;\n\t\tfont-family :Arial;\n\t\tcolor : #ffffff;\n\t\tmargin-left : 10px;\n\t\ttext-shadow: 0px 2px #133d49;\n\t}\n\t.dvVitals\n\t{\n\t\tposition:relative;\n\t\theight:60px;\n\t\twidth:200px;\n\t\tborder-left :  1px solid #ffffff;\n\t\tborder-right : 1px solid #c7cfd2;\n\t\tborder-top :  1px solid #ffffff;\n\t\tborder-bottom : 1px solid #c7cfd2;\n\t}\n\t.dvVitalsTheme\n\t{\n\t    background : #f4f8fb;\n\t\tbackground: -moz-linear-gradient(top, #f4f8fb 0%, #fefefe 35%, #f0f3f6 60%, #e6ecf2 100%); \n\t\tbackground: -webkit-gradient(linear, left top, left bottom, color-stop(0%,#f4f8fb), color-stop(35%,#fefefe), color-stop(60%,#f0f3f6), color-stop(100%,#e6ecf2)); \n\t\tbackground: -webkit-linear-gradient(top, #f4f8fb 0%,#fefefe 35%, #f0f3f6 60%,#e6ecf2 100%); \n\t\tbackground: -o-linear-gradient(top, #f4f8fb 0%,#fefefe 35%,#f0f3f6 60%,#e6ecf2 100%); \n\t\tbackground: -ms-linear-gradient(top, #f4f8fb 0%,#fefefe 35%,#f0f3f6 60%,#e6ecf2 100%);\n\t \tbackground: linear-gradient(to bottom, #f4f8fb 0%,#fefefe 35%,#f0f3f6 60%,#e6ecf2 100%);  \n\t    filter: progid:DXImageTransform.Microsoft.gradient( startColorstr=\'#f4f8fb\', endColorstr=\'#e6ecf2\',GradientType=0 ); \n\t}\n\t.dvVitalsBorderTheme\n\t{\n\t /*\n\t    border-left : 1px solid #ffffff;\n\t    border-right : 1px solid #c7cfd2;\n\t    */\n\t    border-bottom : 1px solid #c7cfd2;\n\t    border-top :  1px solid #ffffff;\n\t}\n\t.dvVitalsTheme1\n\t{\n\n\t    background : #f4f8fb;\n\t\tbackground: -moz-linear-gradient(top, #f4f8fb 0%, #fefefe 35%, #f0f3f6 60%, #e6ecf2 100%); \n\t\tbackground: -webkit-gradient(linear, left top, left bottom, color-stop(0%,#f4f8fb), color-stop(35%,#fefefe), color-stop(60%,#f0f3f6), color-stop(100%,#e6ecf2)); \n\t\tbackground: -webkit-linear-gradient(top, #f4f8fb 0%,#fefefe 35%, #f0f3f6 60%,#e6ecf2 100%); \n\t\tbackground: -o-linear-gradient(top, #f4f8fb 0%,#fefefe 35%,#f0f3f6 60%,#e6ecf2 100%); \n\t\tbackground: -ms-linear-gradient(top, #f4f8fb 0%,#fefefe 35%,#f0f3f6 60%,#e6ecf2 100%);\n\t \tbackground: linear-gradient(to bottom, #f4f8fb 0%,#fefefe 35%,#f0f3f6 60%,#e6ecf2 100%);  \n\t    filter: progid:DXImageTransform.Microsoft.gradient( startColorstr=\'#f4f8fb\', endColorstr=\'#e6ecf2\',GradientType=0 ); \n\t}\n\t.dvMeasureContainer\n\t{\n\t\tposition:relative;\n\t\twidth : 100%;\n\t\theight : 30px;\n\t\tvertical-align : bottom;\n\t\t\n\t\t\n\t}\n\t.dvMeasureFont\n\t{\n\t\tmargin-left : 10px;\n\t\tpadding-top : 13.5px;\n\t\tfont-size : 13px;\n\t\tfont-weight : bold;\n\t\tfont-family :Arial;\n\t\tcolor : #44484a;\n\t\t\n\t}\n\t.dvMeasureUnits\n\t{\n\t\tposition:relative;\n\t\twidth : 100%;\n\t\theight : 30px;\n\t\tvertical-align : top;\n\t}\n\t.dvUnitsFont\n\t{\n\t\tmargin-left : 10px;\n\t\tpadding-bottom : 13.5px;\n\t\tfont-size : 13px;\n\t\tfont-weight : bold;\n\t\tfont-family :Arial;\n\t\tcolor : #878787;\n\t}\n\t.dvValueContainer\n\t{\n\t\tposition : relative;\n\t    border-left : 1px solid #ffffff;\n\t    border-right : 1px solid #c7cfd2;\n\t\twidth : 100px;\n\t\theight : 60px;\n\t\tfloat : left;\n\t\tvertical-align : middle;\n\t\ttext-align : center;\n\t}\n\t.dvVitalsIconContainer\n\t{\n\t\tposition : relative;\n\t\twidth : 30px;\n\t\theight : 100%;\n\t\tfloat:left;\n\t\ttext-align : center;\n\t\t\n\t}\n\t.dvVitalsValue\n\t{\n\t\tposition : relative;\n\t\twidth : 70px;\n\t\theight : 100%;\n\t\tfloat:left; \n\t\ttext-align : center;\n\t\t\n\t\tpadding-top : 23.5px;\n\t\tfont-size : 13px;\n\t\tfont-weight : bold;\n\t\tfont-family :Arial;\n\t\tcolor : #44484a;\n\t\t\n\t}\n\t.dvVitalsValueFont\n\t{\n\t\tmargin-top : 23.5px;\n\t\tfont-size : 13px;\n\t\tfont-weight : bold;\n\t\tfont-family :Arial;\n\t\tcolor : #44484a;\n\t}\n   </style>\n   <script>\n   document.addEventListener(\'touchmove\', function (e) { e.preventDefault(); }, false);\n   document.addEventListener(\'DOMContentLoaded\', vitalsChartScroll, false);\n   var vitalsScroll ;\n   var screenOrienttation = \"landscape\";\n   var vitalsResultScroll;\n   var bValueLoaded = false;\n   function cancelTransaction(){\n\t\tvar path = document.getElementById(\"hdnPath\").value + \"/mobile/chartsummary/ChartWidgetsView\";\n\t\twindow.parent.document.getElementById(\'ChartSummaryIframe\').src = path;\n\t}\n   function vitalsChartScroll() {\n\t\t setTimeout(function () {\n\t\t\t vitalsScroll = new iScroll(\'divcnt\', {\n\t\t\tuseTransform: true,\n\t\t\tzoom: false,\n\t\t\tonBeforeScrollStart: function (e) {\n\t\t\tvar target = e.target;\n\t\t\twhile (target.nodeType != 1) target = target.parentNode;\n\n\t\t\tif (target.tagName != \'SELECT\' && target.tagName != \'INPUT\' && target.tagName != \'TEXTAREA\' && target.tagName != \'DIV\')\n\t\t\te.preventDefault();\n\t\t\t}\n\t\t\t});\n\t}, 1000);\n}\n function scrollRefresh()\n {\n  \tif(vitalsScroll != null)\n \t\t   vitalsScroll.refresh();\n }\n function changeOrientation(orient, EMHFheight)\n {\n\t   \tvar CSHFheight = $(\'#allergyHeader\').height();\n\t   \tHFheight = EMHFheight;\n\t   \tscreenOrienttation = orient;\n\t   \tvar content_height = parent.getTotalPageDivHeight() - EMHFheight - CSHFheight-6 ;\n\t   //\talert(content_height);\n\t   \tdocument.getElementById(\"divc";
    private final static byte[]  _wl_block9_0Bytes = _getBytes( _wl_block9_0 );

    private final static java.lang.String  _wl_block9_1 ="nt\").style.height = content_height+\"px\";\n\t   \tif(bValueLoaded) // if tab view load properly, assign the wrapper width;\n\t   \t{\n\t\t   \t $(\"[data-type = \'ComboBox\']\").each(function(index, value) { \n\t\t\t\t $(this).data(\"kendoMultiSelect\").close();\t\t\n\t\t\t });\n\t\t   \t// setCombostyle();\n\t\t\t setVitalsWrapperWidth();\n\t\t\t setVitalsScrollerWidth();\n\t\t\t vitalsResultScrollRefresh();\n\t   \t}\n\t    scrollRefresh();\n }\n $(document).ready(function () {\n\t   parent.setOnLoadContentPaneHeight();\n\t   loadTabularView();\n\t   /*\n\t   setVitalsScrollerWidth();\n\t   setVitalsResultScroll();\n\t   scrollRefresh();\n\t   vitalsResultScrollRefresh();\n\t   */\n });\n function setCombostyle()\n {\n\t $(\'#chartConfig\').css(\"width\" , \"0%\");\n\t// alert(\"hello\");\n\t $(\'#chartConfig\').css(\"width\" , \"90%\");\n\t \n }\n function loadTabularView()\n {\n\t \n\t bValueLoaded = false;\n\t path = $(\'#hdnPath\').val();\n\t //var query = DV=t&SV=s\n\t// var obj = new object();\n\t// obj.code = \"s,t\";\n\t// var data =\n\t\t/*\n     var arrEvent = [];\n     var oCombo = new Object();\n     oCombo.DV =  $(\'#hdnComboValue\').val();\n     arrEvent.push(oCombo);\n     */\n    // var comboValues = JSON.stringify(arrEvent)\n\t\n\t $(\'#dvTabularView\').load( path + \"/LatestVitals?isRankRequired=N&fromScreen=VV&DV=\" + $(\'#hdnComboValue\').val() ,function(response, status, xhr){\n\t\tif(status == \"error\")\n\t\t{\n\t\t\talert(\"Error Loading the page\");\t\n\t\t}\n\t\telse\n\t\t{\n\t\t\t$(document).ready(function () {\n\t\t\t\t bValueLoaded = true;\n\t\t\t\t setVitalsWrapperWidth();\n\t\t\t\t setVitalsScrollerWidth();\n\t\t\t\t setVitalsResultScroll();\n\t\t\t\t scrollRefresh();\n\t\t\t\t vitalsResultScrollRefresh();\n\t\t\t});\n\t\t}\n\t });\n\t \n }\n function setVitalsWrapperWidth()\n {\n\t $(\'#vitalsSwipeWrapper\').css(\'width\' , \"0px\");\n\t var colWidth = $(\'#dvResultsCol2\').width();\n\t colWidth = colWidth + \"px\";\n\t $(\'#vitalsSwipeWrapper\').css(\'width\' , colWidth);\n\t \n }\n function setVitalsScrollerWidth()\n {\n\t //dvHeaderDate\n\t $(\'#vitalsScroller\').css(\'width\' , \"0px\");\n\t var scrollWidth = 0;\n\t var count = 0;\n\t var dummyWidth =  $(\'#dvResultsCol2\').width();//$(\'#vitalsSwipeWrapper\').width();\n\t $(\".dvHeaderDate\").each(function(index, value) {\n\t\t scrollWidth = scrollWidth + 110;\n\t\t \n\t });\n\t// alert(scrollWidth);\n\t if(scrollWidth < dummyWidth)\n\t {\n\t\t dummyWidth = dummyWidth + 110;\n\t\t dummyWidth = dummyWidth + \"px\";\n\t\t    $(\'#vitalsScroller\').css(\'width\' , dummyWidth);\n\t }\n\t else\n\t {\n\t\t var width =  scrollWidth  + \"px\";\n\t\t $(\'#vitalsScroller\').css(\'width\' , width);\n\t  }\n\t \n }\n function setVitalsResultScroll()\n {\n\t var dummyWidth =  $(\'#vitalsSwipeWrapper\').width();\n\t var hScrollwidth = $(\'#vitalsScroller\').width();\n\t if(hScrollwidth > dummyWidth)\n\t {\n\t\t \n\t\t vitalsResultScroll = new iScroll(\'vitalsSwipeWrapper\', {\n\t\t\t\thScrollbar : false\n\t\t});\n\t  }\n\t\t\n }\n function vitalsResultScrollRefresh()\n {\n\t if( vitalsResultScroll != null)\n\t\t {\n\t\t \tvitalsResultScroll.refresh();\n\t\t }\n }\n function myFunction()\n {\n\t alert(\"hi\");\n }\n   </script>\n</head>\n<body style = \"padding :0px;display : block;margin: 0px; height: 100%; width: 100%;\" >\n\t<div id=\"divParent\" class=\"divParent\" data-role=\"page\" style=\"padding: 0px\">\n\t\t<form name=\"frmvitalsTabView\" id=\"frmvitalsTabView\" id=\"frmvitalsTabView\" style=\"width: 100%; height: 100%\" >\n\t\t\t<div id=\"allergyHeader\" class=\"AllergyHeader\" style=\"padding: 0px\"\n\t\t\t\tdata-role=\"none\">\n\t\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" class=\"tbAllergyHeader\"\n\t\t\t\t\tdata-role=\"none\">\n\t\t\t\t\t<tr class=\"normalTr\">\n\t\t\t\t\t\t<td class=\"normalTd\">\n\t\t\t\t\t\t\t<div class=\"RecordAllergyHeader RecordAllergyHeaderTheme\">\n\t\t\t\t\t\t\t\t<div class=\"RecordAllergyTable\">\n\t\t\t\t\t\t\t\t\t<div class=\"normalRow\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyCell\" style=\"width: 99%; text-align: left\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"allergyHeaderPageTitle ipHeaderPageTitleTheme\">Vitals Table View</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyCell\" style=\"width: 1%\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"RecordAllergyTable\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"normalRow\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyCell\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"width: auto; text-align: right\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"buttonContainer\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyCell\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"width: auto; text-align: right\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"buttonContainer\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"WidgetButtonTheme\" onclick=\"cancelTransaction()\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"";
    private final static byte[]  _wl_block9_1Bytes = _getBytes( _wl_block9_1 );

    private final static java.lang.String  _wl_block10 ="/eIPAD/images/CS_Close16x16.png\"/>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t</div>\n\t\t\t<div id=\"divcnt\" class=\"divAllergyContent divVitalsContentTheme\" style=\"padding: 0px;\" data-role=\"none\">\n\t\t\t\t<div style=\"width: 100%; height: auto; overflow: auto\" data-role=\"none\">\n\t\t\t\t   <div data-role = \"none\" class = \"dvTBVContainer dvTBVContainerTheme\">\n\t\t\t\t   \t\t<div data-role = \"none\" class = \"dvControlTable\" >\n\t\t\t\t   \t\t\t<div data-role = \"none\" class = \"dvControlRow\">\n\t\t\t\t   \t\t\t\t<div data-role = \"none\" class = \"Cell1\">\n\t\t\t\t   \t\t\t\t\t<div data-role = \"none\" class = \"dvControlLabel\">\n\t\t\t\t   \t\t\t\t\t\tVitals\n\t\t\t\t   \t\t\t\t\t</div>\n\t\t\t\t   \t\t\t\t</div>\n\t\t\t\t   \t\t\t\t<div data-role = \"none\" class = \"Cell2\">\n\t\t\t\t   \t\t\t\t\t  <select id=\"chartConfig\" multiple=\"multiple\" style = \"margin:10px\" data-type = \"ComboBox\">\n\t\t\t\t   \t\t\t\t\t    ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<option value = \"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</option>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t\t\t      </select>\n\t\t\t\t   \t\t\t\t\t <script>\n\t\t\t\t   \t\t\t\t\t $(document).ready(function() {\n\t\t\t\t   \t\t\t\t\t\t $(\"#chartConfig\").kendoMultiSelect({\n\t\t\t\t   \t\t\t\t\t\t  change: function(e) {\n\t\t\t\t   \t\t\t\t\t\t\t // alert(this.value())\n\t\t\t\t   \t\t\t\t\t\t\t $(\'#hdnComboValue\').val(this.value());\n\t\t\t\t   \t\t\t\t\t\t\t loadTabularView();\n\t\t\t\t   \t\t\t\t\t\t  }\n\t\t\t\t   \t\t\t\t\t\t });\n\t\t\t\t   \t\t\t\t\t });\n\t\t\t\t   \t\t\t\t\t </script>\n\t\t\t\t   \t\t\t\t</div>\n\t\t\t\t   \t\t\t</div>\n\t\t\t\t   \t\t</div>\n\t\t\t\t   </div><!-- control container end -->\n\t\t\t\t   <div data-role = \"none\" class = \"dvTabularView\" id = \"dvTabularView\">\n\t\t\t\t   \t\n\t\t\t\t   </div> <!-- tabular View end -->\n\t\t\t\t</div>\n\t\t\t</div>\n\t\t\t\t<input type=\"hidden\" name=\"hdnPath\" id=\"hdnPath\" id=\"hdnPath\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" /> \n\t\t\t\t<input type=\"hidden\" name=\"hdnComboValue\" id=\"hdnComboValue\" id=\"hdnComboValue\"  />\n\t\t</form>\n\t</div>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

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

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block0Bytes, _wl_block0);

Locale appLocale;
if (session.getAttribute("LOCALE") != null
		&& !session.getAttribute("LOCALE").equals(""))
	appLocale = new Locale((String) session.getAttribute("LOCALE"));
else
	appLocale = new Locale("en");
ResourceBundle csResBundle = ResourceBundle.getBundle(
		"eIPAD.chartsummary.common.resourcebundle.cslabels",
		appLocale);
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
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block9_0Bytes, _wl_block9_0);
            _bw.write(_wl_block9_1Bytes, _wl_block9_1);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block10Bytes, _wl_block10);

					   					 if(oVitalsConfigResponse != null && oVitalsConfigResponse.isSuccessResponse() && !oVitalsConfigResponse.isEmptyDataResponse())
					   					 {
						   				       int nVitalsConfigList = 0;
						   					   List<VitalsConfig> listVitalConfig = null;
						   					   if(oVitalsConfigResponse.getListVitalConfig() != null)
						   					   {
						   						   listVitalConfig = oVitalsConfigResponse.getListVitalConfig();
						   						   nVitalsConfigList = listVitalConfig.size();
						   					   }
						   					   if(nVitalsConfigList > 0)
						   					   {
							   						int nVitalsConfigLoopCount = 0;
													for(nVitalsConfigLoopCount = 0; nVitalsConfigLoopCount < nVitalsConfigList; nVitalsConfigLoopCount++)
													{
														String eventCode = listVitalConfig.get(nVitalsConfigLoopCount).getDiscreteMeasureId();
														String DiscreteMeasureDescription = listVitalConfig.get(nVitalsConfigLoopCount).getDiscreteMeasureDesc();
														
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(eventCode));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf( DiscreteMeasureDescription));
            _bw.write(_wl_block13Bytes, _wl_block13);
 
													}
						   					   }
					   					 }
				   					    
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block15Bytes, _wl_block15);
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
