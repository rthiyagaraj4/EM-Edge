package jsp_servlet._eipad._jsp._chartwidgets;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import eIPAD.chartsummary.allergies.response.AllergyResponse;
import eIPAD.chartsummary.allergies.healthobject.Allergy;
import eIPAD.chartsummary.allergies.healthobject.Reaction;
import eIPAD.chartsummary.common.response.ErrorInfo;

public final class __allergyview extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/chartwidgets/AllergyView.jsp", 1709118013881L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n\n<style>\n#PageLoadingAnimation{\n\tz-index: 10000;\n\tposition: absolute;\n\tleft: 0px;\n\ttop: 0px;\n\twidth: 100%;\n\theight: 100%;\n\tbackground-color: #808080;\n\topacity: 0.6;\n\tbackground-image: url(";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="/eIPAD/images/Loading24x24.gif);\n\tbackground-repeat: no-repeat;\n\tbackground-position: 50% 50%;\n\tdisplay: none; \n}\n\n</style>\n\n\n<script>\n//this variable is maintained for showing only one modify button at a time\nvar modifyButtonShown = 0;\n$(document)\n.ready(\n\t\tfunction() {\n\t\t\t$(\".AllergyContentTable\").on(\"dblclick swipeleft\", function() {\n\t\t\t\t//var allergencode = $(this).data(\"allergencode\");\n\t\t\t\t//var allergyeventcode = $(this).data(\"allergyeventcode\");\n\t\t\t\t//var allergyeventtypeind = $(this).data(\"allergyeventtypeind\");\n\t\t\t\t//$(\"#AllergyModifyButton\"+allergencode+\"_\"+allergyeventcode+\"_\"+allergyeventtypeind).show();\n\t\t\t\t\n\t\t\t\tvar allergyModButCount = $(this).data(\"count\");\n\t\t\t\t$(\"#AllergyModifyButton\"+modifyButtonShown).hide();\n\t\t\t\t$(\"#AllergyModifyButton\"+allergyModButCount).show();\n\t\t\t\thighlightAllergy(allergyModButCount);\n\t\t\t\tmodifyButtonShown = allergyModButCount;\n\n\t\t\t});\n\t\t\t$(\".AllergyContentTable\").on(\"swiperight\", function() {\n\t\n\t\t\t\tvar allergyModButCount = $(this).data(\"count\");\n\t\t\t\t//$(\"#AllergyModifyButton\"+modifyButtonShown).hide();\n\t\t\t\t$(\"#AllergyModifyButton\"+allergyModButCount).hide();\n\t\t\t\thighlightAllergy(allergyModButCount);\n\n\t\t\t});\n\t\t});\nfunction expCollAllergy(count){\n\t$(\'#AllergyReactionTable\'+count).toggle();\n\t//$(\'#AllergyContentTable\'+count).toggleClass(\'WidgetContentStripTheme\');\n\t//$(\'#AllergyContentTable\'+count).toggleClass(\'WidgetContentStripSelTheme\');\n\tif(($(\'#ExpCollAllergy\'+count).attr(\"src\")).indexOf(\"Expandview\") >=0)\n\t\t$(\'#ExpCollAllergy\'+count).attr(\"src\",\"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="/eIPAD/images/Collapseview.png\")\n\telse if(($(\'#ExpCollAllergy\'+count).attr(\"src\")).indexOf(\"Collapseview\") >=0)\n\t\t$(\'#ExpCollAllergy\'+count).attr(\"src\",\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="/eIPAD/images/Expandview.png\")\n\tscrollerRefresh(CSMainScroll);\n}\n\nfunction modifyAllergy(allergencode,date){\n\t$(\"input[id=hdnModifyAllergyCode]\").val(allergencode);\n\t$(\"input[id=hdnModifyAllergyDate]\").val(date);\n\t$(\'#frmIcontent\').attr(\"action\", \"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="/chartsummary/RecordAllergyView\");\n}\nfunction openRecordAllergyFrame(){\n\t$(\"#PageLoadingAnimation\").show();\n\twindow.parent.document.getElementById(\'ChartSummaryIframe\').src = \'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="/chartsummary/RecordAllergyView\';\n\t\n}\nfunction openModifyAllergyFrame(allergen,eventCode,eventInd){\n\twindow.parent.document.getElementById(\'ChartSummaryIframe\').src = \'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="/chartsummary/ModifyAllergyView?allergencode=\'+allergen+\'&eventcode=\'+eventCode+\'&eventind=\'+eventInd;\n\t\n}\n//this variable is maintained for highlighting only one allergy at a time\nvar hightlightedAllergy=0;\nfunction highlightAllergy(count){\n\t$(\'#AllergyContentTable\'+hightlightedAllergy).removeClass(\'WidgetContentStripSelTheme\').addClass(\'WidgetContentStripTheme\');\n\t$(\'#AllergyContentTable\'+count).removeClass(\'WidgetContentStripTheme\').addClass(\'WidgetContentStripSelTheme\');\n\thightlightedAllergy = count;\n}\n\nfunction testmove(){\n\t$(\"#VitalsFrame\").prependTo(\"#ChartSummaryMainScroller\");\n}\n\n</script>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<div id=\"PageLoadingAnimation\" > </div>\n\t<div class=\"widgetParent widgetParentTheme\" data-role = \"none\">\n<!-- \t<form id=\"AllergyWidgetForm\" class=\"AllergyWidgetForm\" action=\"\" method=\"post\" name=\"AllergyWidgetForm\" id=\"AllergyWidgetForm\"> -->\n\t\t<div class=\"widgetTable\" data-role = \"none\">\n\t\t\t<div class=\"widgetHeaderRow widgetHeaderRowTheme\" data-role = \"none\">\n\t\t\t\t<div class=\"widgetHeaderMarginCell\" data-role = \"none\">\n\t\t\t\t\t<div class=\"widgetHeaderMarginExtn widgetHeaderMarginExtnTheme\" data-role = \"none\"></div>\n\t\t\t\t\t<div class=\"widgetHeaderIcontriangle\" data-role = \"none\"></div>\n\t\t\t\t</div>\n\t\t\t\t<div class=\"widgetHeaderCell widgetHeaderCellTheme\" data-role = \"none\">\n\t\t\t\t\t<div class=\"widgetHeaderSubTable\" data-role = \"none\">\n\t\t\t\t\t\t<div class=\"widgetHeaderSubRow\" data-role = \"none\">\n\t\t\t\t\t\t\t<div class=\"widgetHeaderIconCol1\" data-role = \"none\">\n\t\t\t\t\t\t\t\t<div class=\"widgetHeaderIconButton widgetHeaderIconButtonTheme\" data-role = \"none\"><img src=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="/eIPAD/images/CS_Allergies.PNG\" class=\"widgetHeaderButtonImage\"></div>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t</div>\n\n\t\t\t\t\t\t\t<div class=\"widgetHeaderHeadingTextCol\" data-role = \"none\"><span class=\"widgetHeaderHeadingTextTheme\" data-role = \"none\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</span> <input type=\"button\" class=\"widgetHeaderCountButtonTheme\" id=\"allergyViewCount\" value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" onclick=\"testmove()\"></div>\n\t\t\t\t\t\t\t<div class=\"widgetHeaderPlusButtonCell\" data-role = \"none\">\n\t\t\t\t\t\t\t\t<div class=\"WidgetButtonTheme\" data-role = \"none\" onclick=\"openRecordAllergyFrame()\"><img src=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="/eIPAD/images/CS_add16x16.png\"></div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</div>\n\t\t\t\t</div>\n\t\t\t</div>\n\n\n\t\t\t<div class=\"widgetContentRow\" data-role = \"none\">\n\t\t\t\t<div class=\"widgetHeaderMarginCell\" data-role = \"none\">\n\t\t\t\t</div>\n\t\t\t\t<div class=\"widgetContentCell widgetContentCellTheme\" data-role = \"none\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t\t\t<!-- Allergy widget content starts here -->\n\t\t\t\t\t<div class=\"AllergyContentTable WidgetContentStripTheme\" id=\"AllergyContentTable";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" data-count=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" data-allergencode=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" data-allergyeventcode=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" data-allergyeventtypeind=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" data-role = \"none\" onclick=\"highlightAllergy(\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\')\">\n\t\t\t\t\t\t<div class=\"AllergyContentRow AllergyContentRowTheme\" data-role = \"none\">\n\t\t\t\t\t\t\t<div class=\"AllergyContentCol1 WidgetContentStripCol1Theme\" data-role = \"none\">\n\t\t\t\t\t\t\t\t<div class=\"AllergyReactionCount WidgetContentStripCol1BoxTheme\" data-role = \"none\">\n\t\t\t\t\t\t\t\t\t<div class=\"AllergyReactionCountCircleTheme\" data-role = \"none\">\n\t\t\t\t\t\t\t\t\t<!-- Add an extra 0 to front if count is in 1 digit -->\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyReactionCountCircleText\" data-role = \"none\">0";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</div>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyReactionCountCircleText\" data-role = \"none\">";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t<img src=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="/eIPAD/images/Allergy16x16.png\" class=\"AllergyReactionCountImage\">\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t<div class=\"AllergyContentCol2\" data-role = \"none\">\n\t\t\t\t\t\t\t\t<div class=\"WidgetParaHeadTextTheme AllergyEventTypeText\" data-role = \"none\">";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</div>\n\t\t\t\t\t\t\t\t<div class=\"WidgetNormalTextTheme AllergyAllergenText\" data-role = \"none\">";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t<div class=\"AllergyContentCol3\" data-role = \"none\">\n\t\t\t\t\t\t\t\t<div class=\"AllergyEventExpandCollapse\" data-role = \"none\">\n\t\t\t\t\t\t\t\t\t<div class=\"SfsHeaderButtonTheme\" style=\"display:none\" id=\"AllergyModifyButton";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" \n\t\t\t\t\t\t\t\t\t\tonclick=\"openModifyAllergyFrame(\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\',\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\')\">\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="/eIPAD/images/Expandview.png\" class=\"AllergyEventExpandCollapseImage\" id=\"ExpCollAllergy";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" onclick=\"expCollAllergy(\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\')\">\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t\t\t\t\t<div class=\"AllergyEstDurationIcon\"><img src=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="/eIPAD/images/Yellow Bullet.png\" class=\"AlleryEstDurationImage\"></div>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t\t\t\t\t<div class=\"WidgetDateTextTheme\" data-role = \"none\">";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</div>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t\t<div style=\"display:none\" id=\"AllergyReactionTable";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" class=\"AllergyReacOutContTheme\">\n\t\t\t\t\t\t<div style=\"display:table;width:100%;\">\n\t\t\t\t\t\t\t<div class=\"AllergyReactionTableContainer AllergyReacContTheme\"  data-role = \"none\">\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t\t\t\t\t<div class=\"AllergyReactionTable AllergyReactionTableTheme WidgetContentStripTheme\" data-role = \"none\">\n\t\t\t\t\t\t\t\t\t<div class=\"AllergyReactionRow\" data-role = \"none\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyReactionCol1 WidgetContentStripCol1Theme\" data-role = \"none\">\n\t\t\t\t\t\t\t\t\t\t\t<div  class=\"AllergyReactionSeverityCont\" data-role = \"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyReactionSeverityTable\" data-role = \"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyReactionSeverityRow\" data-role = \"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyReactionDiviCell\" data-role = \"none\"><div class=\"AllergyReactionSeverityDiviTheme\" data-role = \"none\"></div></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyReactionSeverityCell\" data-role = \"none\"><div class=\"AllergyReactionSeverityOrangeTheme\" data-role = \"none\"></div></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyReactionDiviCell\" data-role = \"none\"><div class=\"AllergyReactionSeverityDiviTheme\" data-role = \"none\"></div></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyReactionSeverityCell\" data-role = \"none\"><div class=\"AllergyReactionSeverityGrayTheme\" data-role = \"none\"></div></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyReactionDiviCell\" data-role = \"none\"><div class=\"AllergyReactionSeverityDiviTheme\" data-role = \"none\"></div></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyReactionSeverityCell\" data-role = \"none\"><div class=\"AllergyReactionSeverityGrayTheme\" data-role = \"none\"></div></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyReactionDiviCell\" data-role = \"none\"><div class=\"AllergyReactionSeverityDiviTheme\" data-role = \"none\"></div></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyReactionSeverityRow\" data-role = \"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyReactionDiviCell\" data-role = \"none\"><div class=\"AllergyReactionSeverityDiviTheme\" data-role = \"none\"></div></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyReactionSeverityCell\" data-role = \"none\"><div class=\"AllergyReactionSeverityOrangeTheme\" data-role = \"none\"></div></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyReactionDiviCell\" data-role = \"none\"><div class=\"AllergyReactionSeverityDiviTheme\" data-role = \"none\"></div></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyReactionSeverityCell\" data-role = \"none\"><div class=\"AllergyReactionSeverityOrangeTheme\" data-role = \"none\"></div></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyReactionDiviCell\" data-role = \"none\"><div class=\"AllergyReactionSeverityDiviTheme\" data-role = \"none\"></div></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyReactionSeverityCell\" data-role = \"none\"><div class=\"AllergyReactionSeverityGrayTheme\" data-role = \"none\"></div></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyReactionDiviCell\" data-role = \"none\"><div class=\"AllergyReactionSeverityDiviTheme\" data-role = \"none\"></div></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyReactionSeverityRow\" data-role = \"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyReactionDiviCell\" data-role = \"none\"><div class=\"AllergyReactionSeverityDiviTheme\" data-role = \"none\"></div></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyReactionSeverityCell\" data-role = \"none\"><div class=\"AllergyReactionSeverityOrangeTheme\" data-role = \"none\"></div></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyReactionDiviCell\" data-role = \"none\"><div class=\"AllergyReactionSeverityDiviTheme\" data-role = \"none\"></div></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyReactionSeverityCell\" data-role = \"none\"><div class=\"AllergyReactionSeverityOrangeTheme\" data-role = \"none\"></div></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyReactionDiviCell\" data-role = \"none\"><div class=\"AllergyReactionSeverityDiviTheme\" data-role = \"none\"></div></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyReactionSeverityCell\" data-role = \"none\"><div class=\"AllergyReactionSeverityOrangeTheme\" data-role = \"none\"></div></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyReactionDiviCell\" data-role = \"none\"><div class=\"AllergyReactionSeverityDiviTheme\" data-role = \"none\"></div></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyReactionSeverityRow\" data-role = \"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyReactionDiviCell\" data-role = \"none\"><div class=\"AllergyReactionSeverityDiviTheme\" data-role = \"none\"></div></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyReactionSeverityCell\" data-role = \"none\"><div class=\"AllergyReactionSeverityGrayTheme\" data-role = \"none\"></div></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyReactionDiviCell\" data-role = \"none\"><div class=\"AllergyReactionSeverityDiviTheme\" data-role = \"none\"></div></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyReactionSeverityCell\" data-role = \"none\"><div class=\"AllergyReactionSeverityGrayTheme\" data-role = \"none\"></div></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyReactionDiviCell\" data-role = \"none\"><div class=\"AllergyReactionSeverityDiviTheme\" data-role = \"none\"></div></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyReactionSeverityCell\" data-role = \"none\"><div class=\"AllergyReactionSeverityGrayTheme\" data-role = \"none\"></div></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyReactionDiviCell\" data-role = \"none\"><div class=\"AllergyReactionSeverityDiviTheme\" data-role = \"none\"></div></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"WidgetSmallTextTheme\" data-role = \"none\">";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyReactionCol2 AllergyReactionCol2Theme\" data-role = \"none\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyReactionDescTheme\" data-role = \"none\">";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</div>\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyReactionSiteTheme\" data-role = \"none\">";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyReactionCol3 AllergyReactionCol3Theme\" data-role = \"none\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"WidgetDateText2Theme\" data-role = \"none\">";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t\t\t\t\t\t\t ";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 =" \n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</div>\n\t\t\t\t\t<!-- Allergy widget content ends here -->\n\t\t\t\t\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t\n\t\t\t\t\t<div class=\"WidgetVwErrContainer\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t\t\t\t<div class=\"WidgetErrorResponse WidgetErrorResponseTheme\">";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="</div>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t\t\t</div>\n\t\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t</div>\n\t\t\t</div>\n\t\t\t\n\t\t\t\n\t\t</div>\n<!-- \t</form> -->\n\t</div>\n\n";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

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

AllergyResponse allergyResponse = (AllergyResponse)request.getAttribute("AllergyResponse");
boolean isSuccessResponse = false;
boolean isEmptyResponse = true;
ArrayList<ErrorInfo> errorList = new ArrayList<ErrorInfo>();
List<Allergy> allergyList = new ArrayList<Allergy>();
List<Reaction> reactionList = new ArrayList<Reaction>();
if(allergyResponse!=null){
	isSuccessResponse = allergyResponse.isSuccessResponse();
	allergyList = allergyResponse.getAllergyDetails();
	errorList = allergyResponse.getErrorsList();
	if(allergyList!=null && !allergyList.isEmpty())
		isEmptyResponse = false;
}

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(csResBundle.getString("allergy.allergies") ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(allergyList.size()));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block13Bytes, _wl_block13);
 if(isSuccessResponse && !isEmptyResponse) {
						for(int i=0;i<allergyList.size();i++){
							Allergy currentAllergy = allergyList.get(i);
							String allergyUniqueStr = currentAllergy.getAllergyEventDesc() + currentAllergy.getAllergenDesc() + currentAllergy.getOnsetDate();
						
					
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(i+1 ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(i+1 ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(currentAllergy.getAllergenCode()));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(currentAllergy.getAllergyEventCode()));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(currentAllergy.getAllergyEventTypeInd()));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(i+1 ));
            _bw.write(_wl_block20Bytes, _wl_block20);
if(currentAllergy.getCount()<10){ 
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(currentAllergy.getCount()));
            _bw.write(_wl_block22Bytes, _wl_block22);
}else{ 
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(currentAllergy.getCount()));
            _bw.write(_wl_block22Bytes, _wl_block22);
} 
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(currentAllergy.getAllergenDesc() ));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(currentAllergy.getAllergyEventDesc() ));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i+1 ));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(currentAllergy.getAllergenCode()));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(currentAllergy.getAllergyEventCode()));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(currentAllergy.getAllergyEventTypeInd()));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(csResBundle.getString("common.modify") ));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(i+1 ));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i+1 ));
            _bw.write(_wl_block33Bytes, _wl_block33);
if(currentAllergy.isEstimatedDuration()) {
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block35Bytes, _wl_block35);
} 
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(currentAllergy.getOnsetDate() ));
            _bw.write(_wl_block37Bytes, _wl_block37);
 reactionList = currentAllergy.getReactions();
							if(reactionList != null && !reactionList.isEmpty())
							{
								boolean severe=false;
						
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf( i+1 ));
            _bw.write(_wl_block39Bytes, _wl_block39);

										for(int j=0; j<reactionList.size(); j++){
											Reaction currentReaction = reactionList.get(j);							
									
            _bw.write(_wl_block40Bytes, _wl_block40);

												if(currentReaction.getSevereityDesc().equals("M") ){
            _bw.write(_wl_block41Bytes, _wl_block41);

												}
												else if(currentReaction.getSevereityDesc().equals("O")){
												
            _bw.write(_wl_block42Bytes, _wl_block42);

												}
												else if(currentReaction.getSevereityDesc().equals("S")){
												
            _bw.write(_wl_block43Bytes, _wl_block43);

												} 
												else{
												
            _bw.write(_wl_block44Bytes, _wl_block44);

												} 
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(csResBundle.getString("allergy.severity") ));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(currentReaction.getReactionDesc() ));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(currentReaction.getReactionSite() ));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(currentReaction.getReactionDate() ));
            _bw.write(_wl_block49Bytes, _wl_block49);

											if(currentReaction.getSevereityDesc().equals("S"))
												severe = true;
										}
            _bw.write(_wl_block50Bytes, _wl_block50);
 
									//if there are severe reactions then the allergy record should be expanded by default
									if(severe){ 
            _bw.write(_wl_block51Bytes, _wl_block51);
            _bw.write(_wl_block52Bytes, _wl_block52);
 } 
            _bw.write(_wl_block53Bytes, _wl_block53);
 		
							}
						}
					}
					else{
            _bw.write(_wl_block54Bytes, _wl_block54);

						for(int k=0;k<errorList.size();k++){
						
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf( errorList.get(k).getErrorMessage()));
            _bw.write(_wl_block56Bytes, _wl_block56);
} 
            _bw.write(_wl_block57Bytes, _wl_block57);
} 
            _bw.write(_wl_block58Bytes, _wl_block58);
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
