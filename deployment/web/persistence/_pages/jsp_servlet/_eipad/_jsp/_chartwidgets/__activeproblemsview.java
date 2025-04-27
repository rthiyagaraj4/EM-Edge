package jsp_servlet._eipad._jsp._chartwidgets;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eIPAD.chartsummary.activeproblems.healthobject.ProblemsDiagnosisHO;
import eIPAD.chartsummary.activeproblems.response.ProblemsDiagnosisResponse;
import java.util.*;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import eIPAD.chartsummary.common.response.ErrorInfo;

public final class __activeproblemsview extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/chartwidgets/ActiveProblemsView.jsp", 1709118013522L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n<style>\n#PageLoadingAnimation{\n\tz-index: 10000;\n\tposition: absolute;\n\tleft: 0px;\n\ttop: 0px;\n\twidth: 100%;\n\theight: 100%;\n\tbackground-color: #808080;\n\topacity: 0.6;\n\tbackground-image: url(";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="/eIPAD/images/Loading24x24.gif);\n\tbackground-repeat: no-repeat;\n\tbackground-position: 50% 50%;\n\tdisplay: none; \n}\n\n</style>\n\n<script> \nvar pdModifyButtonShownId = 0;\n$(document).ready(function(){\n\t$(\".PDContentTable\").on(\"dblclick swipeleft\", function() {\n\t\tvar thisButton = $(this).data(\'pdcount\');\n\t\tif(pdModifyButtonShownId != thisButton){\n\t\t\t$(\"#PDModifyButton\"+pdModifyButtonShownId).hide();\n\t\t\t$(\"#PDTable\"+pdModifyButtonShownId).removeClass(\"WidgetContentStripSelTheme\").addClass(\"WidgetContentStripTheme\");\n\t\t\t$(\"#PDModifyButton\"+thisButton).show();\n\t\t\t$(\"#PDTable\"+thisButton).removeClass(\"WidgetContentStripTheme\").addClass(\"WidgetContentStripSelTheme\");\n\t\t\tpdModifyButtonShownId = thisButton;\n\t\t}\n\t});\n\t$(\".PDContentTable\").on(\"swiperight\", function() {\n\t\tvar thisButton = $(this).data(\'pdcount\');\n\t\t$(\"#PDModifyButton\"+thisButton).hide();\n\t\t$(\"#PDTable\"+thisButton).removeClass(\"WidgetContentStripSelTheme\").addClass(\"WidgetContentStripTheme\");\n\t\tif(thisButton==pdModifyButtonShownId){\n\t\t\tpdModifyButtonShownId=0;\n\t\t}\n\t\t\n\t});\n\t\n});\nfunction showLinkedEncounters(obj,popupId){\n\t\n\tvar buttonHeight = $(obj).height();\n\tvar buttonWidth = $(obj).width();\n\tvar popupObj = $(\"#\"+popupId);\n\tvar popupHeight = $(popupObj).height();\n\tvar popupWidth = $(popupObj).width();\n\tvar arrowHeight = $(\"#\"+popupId+\"-arrowUp\").height();\n    var top = $(obj).offset().top;\n    var position = $(obj).position().top+buttonHeight;\n    var positionLeft = $(obj).position().left - popupWidth + (buttonWidth/2);\n    var positionRight = $(window).width() - positionLeft - popupWidth - + (buttonWidth/2);\n    \n    var popupTitle = $(obj).data(\"title\");\n    var linkurl = encodeURI($(obj).data(\"linkurl\"));\n    var scrollerId = popupId+\"-contents\";\n    var wrapperId = popupId+\"-wrapper\";\n    \n    //clearing the contents\n    $(\"#\"+scrollerId).empty();\n    \n    if(top + popupHeight + 100 > $(window).height()){   //100 is the EM footer and Chart summary footer height\n    \tposition = position - popupHeight - buttonHeight - arrowHeight;\n    \ttop = $(window).height() - popupHeight - buttonHeight;\n    \t$(\"#\"+popupId+\"-arrowUp\").hide();\n    \t$(\"#\"+popupId+\"-arrowDown\").show();\n    }\n    else{\n    \t$(\"#\"+popupId+\"-arrowUp\").show();\n    \t$(\"#\"+popupId+\"-arrowDown\").hide();\n    }\n    \n    //alert(popupTitle);\n    $(\"#\"+popupId+\"-title\").html(popupTitle);\n    \n    $(popupObj).css(\"top\", position+\"px\");\n    $(popupObj).css(\"right\", positionRight+\"px\");\n    $(popupObj).show();\n\n    $(\"#\"+scrollerId).load(linkurl, function(){\n    \tvar LinkedECScroll;\n    \tLinkedECScroll = new iScroll(wrapperId, {\n    \t\tuseTransform : true,\n    \t\tzoom : false,\n    \t\tonBeforeScrollStart : function(e) {\n    \t\t\tvar target = e.target;\n    \t\t\twhile (target.nodeType != 1) target = target.parentNode;\n\n    \t\t\tif (target.tagName != \'SELECT\' && target.tagName != \'INPUT\' && target.tagName != \'TEXTAREA\' ){\n    \t\t\t\te.preventDefault();\n    \t\t\t}\n\n    \t\t\te.stopPropagation();\n    \t\t}\n    \t});\n    \tif(LinkedECScroll!=null){\n    \t\tLinkedECScroll.refresh();\n    \t}\n    });\n\n}\n\n\nfunction openRecordPDFrame(){\n\t$(\"#PageLoadingAnimation\").show();\n\twindow.parent.document.getElementById(\'ChartSummaryIframe\').src = \'";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="/mobile/chartsummary/RecordDiagnosisView\';\n\t// window.parent.document.getElementById(\'ChartSummaryIframe\').src = \'";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="/eIPAD/jsp/chartwidgets/RecordDiagnosis.jsp\';\n}\nfunction openModifyDiagnosisFrame(diagSetId,diagCode,occurSrlNo){\n\tvar params = \'DiagSetId=\'+diagSetId+\'&DiagCode=\'+diagCode+\'&OccurSrlNo=\'+occurSrlNo;\n\twindow.parent.document.getElementById(\'ChartSummaryIframe\').src = \'";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="/mobile/chartsummary/ModifyDiagnosisView?\'+params;\n}\n\nfunction openModifyComplaintFrame(complCode){\n\tvar params = \'ComplaintCode=\'+complCode;\n\twindow.parent.document.getElementById(\'ChartSummaryIframe\').src = \'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="/mobile/chartsummary/ModifyComplaintView?\'+params;\n}\n</script>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<div id=\"PageLoadingAnimation\" > </div>\n\t<div class=\"widgetParent widgetParentTheme\" style=\"position:relative;\" data-role = \"none\">\n\t\t<!-- Linked encounters/complaints popup starts -->\n\t\t<div id=\"PDLinkedECcontainer\" class=\"PDLinkedECcontainer\">\n\t\t\t<div id=\"PDLinkedECcontainer-arrowUp\" class=\"PDLinkPopup-arrowUpTheme\"></div>\n\t\t\t<div  class=\"PDLinkPopup PDLinkPopupTheme\">\n\t\t\t\t<div style=\"display:table;width:100%\">\n\t\t\t\t\t<div style=\"display:table-row\">\n\t\t\t\t\t\t<div style=\"display:table-cell;height:40px\">\n\t\t\t\t\t\t\t<div style=\"display:table\" class=\"PDLinkPopupHeader PDLinkPopupHeaderTheme\">\n\t\t\t\t\t\t\t\t<div style=\"display:table-row\">\n\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell;width:100px;vertical-align:middle;text-align:center\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"PDLinkPopupCloseBtnTheme\" id=\"PDLinkPopupCloseBtn\" onclick=\"closePopup(\'PDLinkedECcontainer\')\">";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell;width:80%;vertical-align:middle;text-align:center\" class=\"PDLinkPopupHeaderTextTheme\" id=\"PDLinkedECcontainer-title\"></div>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</div>\n\t\t\t\t\t<div style=\"display:table-row\">\n\t\t\t\t\t\t<div style=\"display:table-cell;width:100%;vertical-align:middle;\">\n\t\t\t\t\t\t\t<div id=\"PDLinkedECcontainer-wrapper\" class=\"PDLinkPopupWrapper\">\n\t\t\t\t\t\t\t\t<div id=\"PDLinkedECcontainer-contents\" class=\"PDLinkPopupContents\">\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</div>\n\t\t\t\t</div>\n\t\t\t</div>\n\t\t\t<div id=\"PDLinkedECcontainer-arrowDown\" class=\"PDLinkPopup-arrowDownTheme\"></div>\n\t\t</div>\n\t<!-- Linked encounters/complaints popup ends -->\n \t<form id=\"problemsDiagnosisForm\" class=\"problemsDiagnosisForm\" action=\"\" method=\"post\" name=\"problemsDiagnosisForm\" id=\"problemsDiagnosisForm\"> \n\t\t<div class=\"widgetTable\" data-role = \"none\">\n\t\t\t<div class=\"widgetHeaderRow widgetHeaderRowTheme\" data-role = \"none\">\n\t\t\t\t<div class=\"widgetHeaderMarginCell\" data-role = \"none\">\n\t\t\t\t\t<div class=\"widgetHeaderMarginExtn widgetHeaderMarginExtnTheme\" data-role = \"none\"></div>\n\t\t\t\t\t<div class=\"widgetHeaderIcontriangle\" data-role = \"none\"></div>\n\t\t\t\t</div>\n\t\t\t\t<div class=\"widgetHeaderCell widgetHeaderCellTheme\" data-role = \"none\">\n\t\t\t\t\t<div class=\"widgetHeaderSubTable\" data-role = \"none\">\n\t\t\t\t\t\t<div class=\"widgetHeaderSubRow\" data-role = \"none\">\n\t\t\t\t\t\t\t<div class=\"widgetHeaderIconCol1\" data-role = \"none\">\n\t\t\t\t\t\t\t\t<div class=\"widgetHeaderIconButton widgetHeaderIconButtonTheme\" data-role = \"none\"><img src=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="/eIPAD/images/CS_Active_Problems_32x32.png\" class=\"widgetHeaderButtonImage\"></div>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t</div>\n<!-- \t\t\t\t\t\t\t<div class=\"widgetHeaderIconCol2\" data-role = \"none\">\n\t\t\t\t\t\t\t\t<div class=\"widgetHeaderArrowRightTheme\" data-role = \"none\"></div>\n\t\t\t\t\t\t\t</div> -->\n\t\t\t\t\t\t\t<div class=\"widgetHeaderHeadingTextCol\" data-role = \"none\"><span class=\"widgetHeaderHeadingTextTheme\" data-role = \"none\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</span> <input type=\"button\" class=\"widgetHeaderCountButtonTheme\" id=\"activeProblemViewCount\" value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\"></div>\n\t\t\t\t\t\t\t<div class=\"widgetHeaderPlusButtonCell\" data-role = \"none\">\n\t\t\t\t\t\t\t\t<div class=\"WidgetButtonTheme\" data-role = \"none\" onclick=\"openRecordPDFrame()\"><img src=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="/eIPAD/images/CS_add16x16.png\"></div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</div>\n\t\t\t\t</div>\n\t\t\t</div>\n\n\n\t\t\t<div class=\"widgetContentRow\" data-role = \"none\">\n\t\t\t\t<div class=\"widgetHeaderMarginCell\" data-role = \"none\">\n\t\t\t\t\t\n\t\t\t\t</div>\n\t\t\t\t<div class=\"widgetContentCell widgetContentCellTheme\" data-role = \"none\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t<div class=\"SensitiveHeader SensitiveHeaderTheme\" id=\"PDSensitiveHeader\" data-role = \"none\">\n\t\t\t\t\t\t<div style=\"display:table-row\">\n\t\t\t\t\t\t\t<div style=\"display:table-cell;width:48%\">\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t<div style=\"display:table-cell;vertical-align:middle;padding-right:15px\">\n\t\t\t\t\t\t\t\t<div style=\"\" class=\"SensitiveHeaderText WidgetNormalBoldTextTheme\">\n\t\t\t\t\t\t\t\t\tSensitive Diagnosis (";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =")\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t<div style=\"display:table-cell;vertical-align:middle;padding-left:15px\">\n\t\t\t\t\t\t\t\t<div class=\"viewSensitiveButton viewSensitiveButtonTheme WidgetNormalBoldTextTheme\" id=\"viewSensitiveDataButton\" onclick=\"openAuthorizePrompt()\">\n\t\t\t\t\t\t\t\tView\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t<div style=\"display:table-cell;width:48%\">\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</div>\n\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t\t\t\t<!-- PD widget content starts here -->\n\t\t\t\t\t<div class=\"PDContentTable WidgetContentStripTheme\" id=\"PDTable";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" data-pdcode=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" data-role = \"none\" data-pdcount=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n\t\t\t\t\t\t<div class=\"PDContentRow\" data-role = \"none\">\n\t\t\t\t\t\t\t<div class=\"PDContentCol1 WidgetContentStripCol1Theme\" data-role = \"none\">\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<div class=\"PDIcon ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =" WidgetContentStripCol1BoxOrangeTheme";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="WidgetContentStripCol1BoxTheme";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" data-role = \"none\">\n\t\t\t\t\t\t\t \n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t\t\t\t\t<img src=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="/eIPAD/images/CS_Active_Problems_32x32.png\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="/eIPAD/images/DiagnosisW32x32.png\">\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="/eIPAD/images/DiagnosisAddW32x32.png\">\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t<div class=\"PDContentCol2\" data-role = \"none\">\n\t\t\t\t\t\t\t\t<div style=\"font-weight:normal;\" class=\"WidgetParaHeadText2Theme PDdescText\" data-role = \"none\">";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</div>\n\t\t\t\t\t\t\t\t<div class=\"WidgetParaHeadTextTheme PDCodeText\" style=\"display:inline-block\" data-role = \"none\">";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</div>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t\t\t\t<div class=\"WidgetNormalTextItalicTheme\" style=\"display:inline-block\">(During Admission stage)</div>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t\t\t\t<div class=\"WidgetNormalTextItalicTheme\" style=\"display:inline-block\">(During Intermediate stage)</div>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t\t\t\t<div class=\"WidgetNormalTextItalicTheme\" style=\"display:inline-block\">(During Discharge stage)</div>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t<div style=\"display:table-cell;vertical-align:middle;position: absolute;margin-top: 18px;\">\n\t\t\t\t\t\t\t\t<div class=\"SfsHeaderButtonTheme\" style=\"display:none\" \n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t\t\t\t\tonclick=\"openModifyDiagnosisFrame(\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\',\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\')\"\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\t\t\t\t\tonclick=\"openModifyComplaintFrame(\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t\t\t\t\tid=\"PDModifyButton";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">Modify\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t<div class=\"PDContentCol3\" style=\"width:80px\" data-role = \"none\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t\t\t\t\t<div style=\"display:inline-block;text-align:center\">\n\t\t\t\t\t\t\t\t\t<div class=\"widgetIconButton WidgetButtonTheme\"  id=\"PDLinkedProblems_";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" onclick=\"showLinkedEncounters(this,\'PDLinkedECcontainer\')\" data-role = \"none\" data-linkurl=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="/mobile/chartsummary/DiagnosisLinkedProblems?termSetId=";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="&diagCode=";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="&termSetDesc=";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="&occurSrlNo=";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\" data-title=\"Linked Problems\">\n\t\t\t\t\t\t\t\t\t\t<img src=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="/eIPAD/images/LinkedProblem24x24.png\">\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t\t\t\t\t\t<div style=\"display:inline-block;text-align:center\">\n\t\t\t\t\t\t\t\t\t<div class=\"widgetIconButton WidgetButtonTheme\" id=\"PDLinkedEncounters_";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="/mobile/chartsummary/DiagnosisLinkedEncounters?termSetId=";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="&status=";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\" data-title=\"Linked Encounters\">\n\t\t\t\t\t\t\t\t\t\t<img src=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="/eIPAD/images/Linked_Encounters24x24.png\">\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\t\t\t\t\t<div class=\"WidgetDateTextTheme\" data-role = \"none\">";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</div>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t\n\t\t\t\t\t<div class=\"WidgetVwErrContainer\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t\t\t\t<div class=\"WidgetErrorResponse WidgetErrorResponseTheme\">";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="</div>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t\t</div>\n\t\t\t\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t\t\t</div>\n\t\t\t</div>\n\t\t\t\n\t\t\t\n\t\t<input type=\"hidden\" name=\"SensitiveDataPwd\" id=\"SensitiveDataPwd\" id=\"SensitiveDataPwd\" value=\"\">\n\t\t</div>\n \t</form> \n\t</div>\n\n";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

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

ProblemsDiagnosisResponse pdResponse = (ProblemsDiagnosisResponse)request.getAttribute("ProblemsDiagnosisResponse");
boolean isSuccessResponse = false;
boolean isEmptyResponse = true;
ArrayList<ErrorInfo> errorList = new ArrayList<ErrorInfo>();
List<ProblemsDiagnosisHO> pdList = new ArrayList<ProblemsDiagnosisHO>();
if(pdResponse!=null){
	isSuccessResponse = pdResponse.isSuccessResponse();
	isEmptyResponse = pdResponse.isEmptyDataResponse();
	pdList = pdResponse.getProblemsDiagnosisList();
	errorList = pdResponse.getErrorsList();
	if(pdList!=null && !pdList.isEmpty())
		isEmptyResponse = false;
}

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(csResBundle.getString("common.close") ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(csResBundle.getString("activeProbs.activeProblemsAndDiagnosis") ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(pdList.size()));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block13Bytes, _wl_block13);
 if(isSuccessResponse && !isEmptyResponse) {
						if(!pdResponse.isSensitiveDataShown() && pdResponse.isSensitiveDataPresent() && pdResponse.getSensitiveDiagnosisCount()>0){
					
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(pdResponse.getSensitiveDiagnosisCount() ));
            _bw.write(_wl_block15Bytes, _wl_block15);

						}
						for(int i=0;i<pdList.size();i++){
							ProblemsDiagnosisHO currentPD = pdList.get(i);
						
					
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(i+1 ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(currentPD.getDiagProbCode() ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(i+1 ));
            _bw.write(_wl_block19Bytes, _wl_block19);
if(currentPD.getSensitiveYN().equals("Y")){
            _bw.write(_wl_block20Bytes, _wl_block20);
}else {
            _bw.write(_wl_block21Bytes, _wl_block21);
} 
            _bw.write(_wl_block22Bytes, _wl_block22);
if(currentPD.getCurrentState().equals("PROBLEM")){ 
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block24Bytes, _wl_block24);
} else if(currentPD.getCurrentState().equals("DIAGNOSIS")){
									if(currentPD.getCurrentAccuracyInd().equals("U")){
							
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block25Bytes, _wl_block25);
} else {
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block26Bytes, _wl_block26);
}
								}
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(currentPD.getDiagProbDesc() ));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(currentPD.getDiagProbCode() ));
            _bw.write(_wl_block29Bytes, _wl_block29);
if(currentPD.getEncounterStage().equals("A")){ 
            _bw.write(_wl_block30Bytes, _wl_block30);
}else if(currentPD.getEncounterStage().equals("I")){ 
            _bw.write(_wl_block31Bytes, _wl_block31);
}else if(currentPD.getEncounterStage().equals("D")){ 
            _bw.write(_wl_block32Bytes, _wl_block32);
} 
            _bw.write(_wl_block33Bytes, _wl_block33);
if(currentPD.getCurrentState().equals("DIAGNOSIS")){ 
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(currentPD.getTermSetId()));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(currentPD.getDiagProbCode()));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(currentPD.getOccurSrlNo() ));
            _bw.write(_wl_block36Bytes, _wl_block36);
}else{ 
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(currentPD.getDiagProbCode()));
            _bw.write(_wl_block36Bytes, _wl_block36);
} 
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i+1 ));
            _bw.write(_wl_block39Bytes, _wl_block39);
if(currentPD.getComplCount()>0 && currentPD.getCurrentState().equals("DIAGNOSIS")) {
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(currentPD.getDiagProbCode()));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(currentPD.getTermSetId()));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(currentPD.getDiagProbCode()));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(currentPD.getTermSetDesc()));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(currentPD.getOccurSrlNo()));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block47Bytes, _wl_block47);
} 
							if(currentPD.getEncounterCount()>0 && currentPD.getCurrentState().equals("DIAGNOSIS")) {
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(currentPD.getDiagProbCode()));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(currentPD.getTermSetId()));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(currentPD.getDiagProbCode()));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(currentPD.getStatus()));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block52Bytes, _wl_block52);
} 
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(currentPD.getOnsetDate()));
            _bw.write(_wl_block54Bytes, _wl_block54);
 
						}
					}
					else{
            _bw.write(_wl_block55Bytes, _wl_block55);

						for(int k=0;k<errorList.size();k++){
						
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf( errorList.get(k).getErrorMessage()));
            _bw.write(_wl_block57Bytes, _wl_block57);
} 
            _bw.write(_wl_block58Bytes, _wl_block58);
}
            _bw.write(_wl_block59Bytes, _wl_block59);
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
