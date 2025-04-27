package jsp_servlet._eipad._jsp._chartwidgets;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.ResourceBundle;
import java.util.*;
import eIPAD.chartsummary.common.response.*;
import eIPAD.chartsummary.vitals.response.*;
import eIPAD.chartsummary.vitals.healthobject.*;

public final class __vitals extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/chartwidgets/Vitals.jsp", 1709116951145L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<style>\n#PageLoadingAnimation{\n\tz-index: 10000;\n\tposition: absolute;\n\tleft: 0px;\n\ttop: 0px;\n\twidth: 100%;\n\theight: 100%;\n\tbackground-color: #808080;\n\topacity: 0.6;\n\tbackground-image: url(";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="/eIPAD/images/Loading24x24.gif);\n\tbackground-repeat: no-repeat;\n\tbackground-position: 50% 50%;\n\tdisplay: none; \n}\n\n</style>\n<script>\nvar vitalsScroll;\nvar currentVitalsScrollingId = \"\";\nfunction assignVitalsScroll()\n{\n\t/*\n\tsetTimeout(function () {\n\t\tvitalsScroll = new iScroll(vitalsScroller, {\n\t\t\thScrollbar : false\n\t});\n\t},100);\n\t*/\n  \n\t$(\'.vitalsSwipeWrapper\').bind(\'touchstart click\', function(event) {\n\t\t /*\n\t\t\tvitalsScroll = new iScroll(\'vitalsSwipeWrapper\',  {\n\t\t\t\thScrollbar : false\n\t\t});\n\t\t */\n\t\tvar vitalsId = \"vitalsSwipeWrapper\";\n\t\tif(currentVitalsScrollingId != null )\n\t\t{\n\t\t\tif(vitalsId != currentVitalsScrollingId)\t\n\t\t\t{\n\t\t\t\tvitalsScroll = new iScroll(vitalsId, {\n\t\t\t\t\thScrollbar : false\n\t\t\t\t});\t\n\t\t\t\tcurrentVitalsScrollingId = vitalsId;\n\t\t\t}\n\t\t}\n\t\telse\n\t\t{\n\t\t\tvitalsScroll = new iScroll(vitalsId, {\n\t\t\t\thScrollbar : false\n\t\t\t});\t\n\t\t}\n\t});\n}\n$(document).ready(function() {\n\tassignVitalsWrapperWidth();\n\tassignVitalsScrollerWidth();\n\tassignVitalsScroll();\n\t\n});\nfunction showChartsView()\n{\n\t$(\"#PageLoadingAnimation\").show();\n\twindow.parent.document.getElementById(\'ChartSummaryIframe\').src = \'";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="/LatestVitals?isRankRequired=N&fromScreen=CLV\';\n}\nfunction showChartsTabularView()\n{\n\t$(\"#PageLoadingAnimation\").show();\n\t//window.parent.document.getElementById(\'ChartSummaryIframe\').src =  \'";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="/eIPAD/jsp/chartwidgets/VitalsTabularView.jsp\';\n\twindow.parent.document.getElementById(\'ChartSummaryIframe\').src = \'";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="/LatestVitals?isRankRequired=N&fromScreen=TV\';\n}\nfunction showRecordVitals()\n{\n\t$(\"#PageLoadingAnimation\").show();\n\twindow.parent.document.getElementById(\'ChartSummaryIframe\').src = \'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="/mobile/RecordVitalsView\';\n}\n</script>\n<div id=\"PageLoadingAnimation\" > </div>\n<div class=\"procWidgetParent widgetParentTheme\" data-role=\"none\">\n\t<div class=\"widgetTable\" data-role=\"none\">\n\t\t<div class=\"widgetHeaderRow widgetHeaderRowTheme\" data-role=\"none\"><!-- header row -->\n\t\t\t<div class=\"widgetHeaderMarginCell\" data-role=\"none\">\n\t\t\t\t<div class=\"widgetHeaderMarginExtn widgetHeaderMarginExtnTheme\" data-role=\"none\"></div>\n\t\t\t\t<div class=\"widgetHeaderIcontriangle\" data-role=\"none\"></div>\n\t\t\t</div>\n\t\t\t<div class=\"widgetHeaderCell widgetHeaderCellTheme\" data-role=\"none\">\n\t\t\t\t<div class=\"widgetHeaderSubTable\" data-role=\"none\">\n\t\t\t\t\t<div class=\"widgetHeaderSubRow\" data-role=\"none\">\n\t\t\t\t\t\t<div class=\"widgetHeaderIconCol1\" data-role=\"none\">\n\t\t\t\t\t\t\t<div class=\"widgetHeaderIconButton widgetHeaderIconButtonTheme\" data-role=\"none\">\n\t\t\t\t\t\t\t\t<img src=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="/eIPAD/images/CS_Latest_Vitals_32x32.PNG\" class=\"widgetHeaderButtonImage\"></img>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</div>\n\n\t\t\t\t\t\t<div class=\"widgetHeaderHeadingTextCol\" data-role=\"none\">\n\t\t\t\t\t\t\t<span class=\"widgetHeaderHeadingTextTheme\" data-role=\"none\">Latest Vitals</span> \n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t<div class=\"notesFilterCol\" data-role=\"none\" style = \"right:0px\">\n\t\t\t\t\t\t  <!--  \n\t\t\t\t\t\t\t<table style=\"height: 100%; width: 100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n\t\t\t\t\t\t\t\t<tr style=\"height: 100%; width: 100%\">\n\t\t\t\t\t\t\t\t\t<td style=\"width: 50%\" align=\"right\" valign=\"center\" onclick = \"showChartsTabularView()\">\n\t\t\t\t\t\t\t\t\t\t<div data-role=\"none\" class=\"notesFilterContainer\">\n\t\t\t\t\t\t\t\t\t\t \n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td style=\"width: 50%\" align=\"right\" valign=\"center\" onclick = \"showChartsView()\">\n\t\t\t\t\t\t\t\t\t\t<div data-role=\"none\" class=\"notesFilterContainer\">\n\t\t\t\t\t\t\t\t\t\t \n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t-->\n\t\t\t\t\t\t\t<table style = \"height:100%;width:100%\" cellpadding = \"0\" cellspacing = \"0\" border = \"0\">\n\t\t\t  \t\t\t\t<tr style = \"height:100%;width:100%\">\n\t\t\t\t\t\t\t    <td style = \"width:10%\">\n\t\t\t\t\t\t\t        \n\t\t\t\t\t\t\t    </td>\n\t\t\t\t\t\t\t    <td></td>\n\t\t\t\t\t\t\t    <td style = \"width:50%\" align = \"right\" valign = \"center\">\n\t\t\t\t\t\t\t    \t<table class= \"ipContentHolderIconContainer WidgetFilterContTheme\" cellpadding = \"0\" cellspacing = \"0\" border = \"0\">\n\t\t\t\t\t\t\t\t\t    <tr>\n\t\t\t\t\t\t\t\t\t\t\t<td class = \"WidgetFilterButtonTheme\"  id=\"orderByNone\" onclick = \"showChartsTabularView()\" ><img src = \"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="/eIPAD/images/thumbb.png\" style=\"vertical-align: middle;\"/></td>\n\t\t\t\t\t\t\t\t        \t<td class = \"WidgetFilterButtonTheme\"  id=\"orderByBedNum\" onclick = \"showChartsView()\" ><img src = \"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="/eIPAD/images/Chart11.png\" style=\"vertical-align: middle;\"/></td>\n\t\t\t\t\t\t\t\t        \t<td class = \"WidgetFilterButtonTheme\"   onclick = \"showRecordVitals()\" ><img src = \"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="/eIPAD/images/CS_add16x16.png\" style=\"vertical-align: middle;\"/></td>\n\t\t\t\t\t\t\t\t        </tr>\n\t\t\t\t\t\t        \t</table>\t\n\t\t\t\t\t\t    \t</td>\n\t\t\t \t\t\t\t</tr>\n\t\t    \t\t\t</table>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</div>\n\t\t\t\t</div>\n\t\t\t</div>\n\t\t</div>\n\t\t<div class=\"widgetContentRow\" data-role=\"none\"><!-- content row starts -->\n\t\t\t<div class=\"widgetHeaderMarginCell\" data-role=\"none\"></div>\n\t\t\t<div class=\"widgetContentCell widgetContentCellTheme\" data-role=\"none\">\n\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t<div class=\"AllergyContentTable WidgetContentStripTheme\" data-role=\"none\" id = \"vitalsTable\"><!-- content strip starts -->\n\t\t\t\t\t<div class=\"AllergyContentRow AllergyContentRowTheme\" data-role=\"none\" >\n\t\t\t\t\t\t<div data-role = \"none\" class = \"swipeContentCell\" id = \"swipeContentCell\">\n\t\t\t\t\t\t\t<div data-role = \"none\" class = \"vitalsSwipeWrapper\" id = \"vitalsSwipeWrapper\" >\n\t\t\t\t\t\t\t\t<div data-role = \"none\" class = \"vitalsScroller\" id = \"vitalsScroller\">\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t\t\t\t\t\t\t<div data-role = \"none\" class = \"vitalWidgetContainer vitalWidgetContainerTheme\" onclick = \"showRecordVitals()\"><!-- vitals Container starts -->\n\t\t\t\t\t\t\t\t\t\t\t\t<div data-role = \"none\" class = \"vitalsHeader vitalsHeaderTheme\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</div>\n\t\t\t\t\t\t\t\t\t\t\t\t<div data-role = \"none\" class = \"vitalsResultsContainer\" onclick = \"showRecordVitals()\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-role = \"none\" class = \"vitalsIcon\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t    ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img src = \"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="/eIPAD/images/";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" style = \"position:relative;margin-top:1px\"></img>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-role = \"none\" class = \"vitalsValue vitalsValueTheme\" style = \"overflow:hidden\">";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-role = \"none\" class = \"vitalsUnit vitalsUnitTheme\">";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-role = \"none\" class = \"vitalsDate vitalsDateTheme\">";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t<div data-role = \"none\" class = \"vitalsBottom vitalsBottomTheme\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-role = \"none\" class = \"vitalsBottomCol\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t  ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-role = \"none\" class = \"vitalsHistoryIcon\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t   ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" style = \"position:relative;margin-top :8px\"></img>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-role = \"none\" class = \"vitalsHistoryValue vitalsHistoryValueTheme\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t    <div data-role = \"none\" class = \"vitalsHistoryIcon\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img src = \"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="/eIPAD/images/SNoData.PNG\" style = \"position:relative;margin-top :8px;margin-left:-2px\"></img>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-role = \"none\" class = \"vitalsHistoryValue vitalsHistoryValueTheme\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t    \t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-role = \"none\" class = \"vitalsArrowContainer\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-role = \"none\" class = \"Vitals-Arrow\"></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-role = \"none\" class = \"vitalsBottomCol\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-role = \"none\" class = \"vitalsArrowContainer\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-role = \"none\" class = \"Vitals-Arrow\"></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-role = \"none\" class = \"vitalsBottomCol\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t</div> <!-- vitals Container ends -->\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t\t\t\t\t\t\t  <div data-role = \"none\" class = \"vitalWidgetContainer vitalWidgetContainerTheme\" onclick = \"showRecordVitals()\">\n\t\t\t\t\t\t\t\t\t\t\t\t  <div data-role = \"none\" class = \"vitalsHeader vitalsHeaderTheme\">";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</div>\n\t\t\t\t\t\t\t\t\t\t\t\t  <div data-role = \"none\" class = \"vitalsResultsContainer\">\n\t\t\t\t\t\t\t\t\t\t\t\t  \t<div data-role = \"none\" class = \"addVitalsIcon\">\n\t\t\t\t\t\t\t\t\t\t\t\t  \t\t<img src = \"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="/eIPAD/images/Add.PNG\" style = \"position:relative;margin-left:30.5px;margin-top:22.5px\"></img>\n\t\t\t\t\t\t\t\t\t\t\t\t  \t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t  </div>\n\t\t\t\t\t\t\t\t\t\t\t\t  <div data-role = \"none\" class = \"vitalsBottom vitalsBottomTheme\"></div>\n\t\t\t\t\t\t\t\t\t\t\t  </div>\n\t\t\t\t\t\t\t\t\t\t\t  ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t</div><!-- scroller -->\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</div>\n\t\t\t\t</div><!-- content strip ends -->\n\t\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t   \t<div data-role = \"none\" class=\"WidgetVwErrContainer\">\n\t\t\t\t   \t\t<div data-role = \"none\" class=\"WidgetErrorResponse WidgetErrorResponseTheme\">\n\t\t\t\t   \t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t   \t\t</div>\n\t\t\t\t   \t\t\n\t\t\t\t   \t</div>\n\t\t\t\t   ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t\n\t\t\t</div>\n\t\t</div><!-- content row ends -->\n\t</div>\n</div>\n";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block1Bytes, _wl_block1);

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

			  // if(oVitalsConfigResponse != null && oVitalsConfigResponse.isSuccessResponse() && !oVitalsConfigResponse.isEmptyDataResponse() && oCurrentAndHistoryResponse != null && oCurrentAndHistoryResponse.isSuccessResponse() && !oCurrentAndHistoryResponse.isEmptyDataResponse())
			   if(oVitalsConfigResponse != null && oVitalsConfigResponse.isSuccessResponse() && !oVitalsConfigResponse.isEmptyDataResponse() && oCurrentAndHistoryResponse != null )  
			   {
				   int nVitalsConfigList = 0;
				   List<VitalsConfig> listVitalConfig = null;
				   if(oVitalsConfigResponse.getListVitalConfig() != null)
				   {
					   listVitalConfig = oVitalsConfigResponse.getListVitalConfig();
					   if(oVitalsConfigResponse.getListVitalConfig() != null)
					   		nVitalsConfigList = listVitalConfig.size();
				   }
				   
			
            _bw.write(_wl_block12Bytes, _wl_block12);

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
												if(eventDescription != null && eventDescription.length() > 11)
												{
													eventDescription = eventDescription.substring(0, 8) + "...";
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
												//List<DiscreteValue> lstHistoryValues = oCurrentAndHistoryDM.getLstHistoryValues();
												List<DiscreteValue> lstHistoryValues = oCurrentAndHistoryResponse.getHistoryValues(oCurrentAndHistoryDM);
												int nHistorycount = 0;
												if(lstHistoryValues != null)
												{
													 nHistorycount = lstHistoryValues.size();
													
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
												
								
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(eventDescription ));
            _bw.write(_wl_block14Bytes, _wl_block14);

													    if(iConName != null && !iConName.equals(""))
													    {
													    
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(iConName ));
            _bw.write(_wl_block17Bytes, _wl_block17);

													    }
														
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(resultValue));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(oCurrentAndHistoryDM.getUOM() ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(oCurrentDiscreteValue.getEventDateTime()));
            _bw.write(_wl_block21Bytes, _wl_block21);

													    if( nHistorycount > 0)
													    {
													    	DiscreteValue oHistoryDiscreteValue = lstHistoryValues.get(0);
													    	String resultNum = "";
													    	if(oHistoryDiscreteValue != null)
													    	{
													    		//resultNum = oHistoryDiscreteValue.getResultNum();
													    		if(oHistoryDiscreteValue.getResultNum() != null && oHistoryDiscreteValue.getResultString() != null)
													    		{
													    			resultNum  = oHistoryDiscreteValue.getResultNum().trim() + oHistoryDiscreteValue.getResultString().trim();
													    		}
													    	}
													    	if(resultNum != null && resultNum.length() > 5)
													    	{
													    		resultNum = resultNum.substring(0, 3) + "..";
													    	}
													    	NormalcyIndicator oHistoryNormalcyIndicator1 = oCurrentAndHistoryDM.getNormalcyIndicator(oHistoryDiscreteValue, "S");
													    	String  iConName1 = oHistoryNormalcyIndicator1.getSymbolIndicator();
															if(iConName1 != null && !iConName1.equals(""))
															{
																iConName1 = "S" + iConName1;
															}
															else
															{
																//iConName1 = "NoData24x24.png";
															}
													  
            _bw.write(_wl_block22Bytes, _wl_block22);

														   if(iConName1 != null && !iConName1.equals(""))
														   {
														   
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(iConName1));
            _bw.write(_wl_block23Bytes, _wl_block23);

														   }
															
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(resultNum ));
            _bw.write(_wl_block25Bytes, _wl_block25);

													    }
													    else
													    {
													    	String dummyValue = "-----";
													    	
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(dummyValue ));
            _bw.write(_wl_block28Bytes, _wl_block28);
 
													    }
														
            _bw.write(_wl_block29Bytes, _wl_block29);

													    if( nHistorycount > 1)
													    {
													    	DiscreteValue oHistoryDiscreteValue = lstHistoryValues.get(1);
													    	String resultNum = "";
													    	if(oHistoryDiscreteValue != null)
													    	{
													    		//resultNum = oHistoryDiscreteValue.getResultNum();
													    		if(oHistoryDiscreteValue.getResultNum() != null && oHistoryDiscreteValue.getResultString() != null)
													    		{
													    			resultNum  = oHistoryDiscreteValue.getResultNum().trim() + oHistoryDiscreteValue.getResultString().trim();
													    		}
													    	}
													    	if(resultNum != null && resultNum.length() > 5)
													    	{
													    		resultNum = resultNum.substring(0, 3) + "..";
													    	}
													    	NormalcyIndicator oHistoryNormalcyIndicator1 = oCurrentAndHistoryDM.getNormalcyIndicator(oHistoryDiscreteValue, "S");
													    	String iConName1 = oHistoryNormalcyIndicator1.getSymbolIndicator();
															if(iConName1 != null && !iConName1.equals(""))
															{
																iConName1 = "S" + iConName1;
															}
															else
															{
																//iConName1 = "NoData24x24.png";
															}
													  
            _bw.write(_wl_block22Bytes, _wl_block22);

														   if(iConName1 != null && !iConName1.equals(""))
														   {
														   
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(iConName1));
            _bw.write(_wl_block23Bytes, _wl_block23);

														   }
															
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(resultNum ));
            _bw.write(_wl_block25Bytes, _wl_block25);

													    }
													    else
													    {
													    	String dummyValue = "-----";
													    	
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(dummyValue ));
            _bw.write(_wl_block28Bytes, _wl_block28);
 
													    }
														
            _bw.write(_wl_block30Bytes, _wl_block30);

													    if( nHistorycount > 2)
													    {
													    	DiscreteValue oHistoryDiscreteValue = lstHistoryValues.get(2);
													    	String resultNum = "";
													    	if(oHistoryDiscreteValue != null)
													    	{
													    		//resultNum = oHistoryDiscreteValue.getResultNum();
													    		if(oHistoryDiscreteValue.getResultNum() != null && oHistoryDiscreteValue.getResultString() != null)
													    		{
													    			resultNum  = oHistoryDiscreteValue.getResultNum().trim() + oHistoryDiscreteValue.getResultString().trim();
													    		}
													    	}
													    	if(resultNum != null && resultNum.length() > 5)
													    	{
													    		resultNum = resultNum.substring(0, 3) + "..";
													    	}
													    	NormalcyIndicator oHistoryNormalcyIndicator1 = oCurrentAndHistoryDM.getNormalcyIndicator(oHistoryDiscreteValue, "S");
													    	String  iConName1 = oHistoryNormalcyIndicator1.getSymbolIndicator();
															if(iConName1 != null && !iConName1.equals(""))
															{
																iConName1 = "S" + iConName1;
															}
															else
															{
																//iConName1 = "NoData24x24.png";
															}
													  
            _bw.write(_wl_block22Bytes, _wl_block22);

														   if(iConName1 != null && !iConName1.equals(""))
														   {
														   
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(iConName1));
            _bw.write(_wl_block23Bytes, _wl_block23);

														   }
															
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(resultNum ));
            _bw.write(_wl_block25Bytes, _wl_block25);

													    }
													    else
													    {
													    	String dummyValue = "-----";
													    	
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(dummyValue ));
            _bw.write(_wl_block28Bytes, _wl_block28);
 
													    }
														
            _bw.write(_wl_block31Bytes, _wl_block31);

											}//if
											else
											{
											  
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(DiscreteMeasureDescription ));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block34Bytes, _wl_block34);
 	
											}
										}//for
									}
									
            _bw.write(_wl_block35Bytes, _wl_block35);

			   }//if
			   else
			   {
				   String message = "";
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
				   
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(strMessage.toString() ));
            _bw.write(_wl_block37Bytes, _wl_block37);
 
			   }
				
            _bw.write(_wl_block38Bytes, _wl_block38);
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
