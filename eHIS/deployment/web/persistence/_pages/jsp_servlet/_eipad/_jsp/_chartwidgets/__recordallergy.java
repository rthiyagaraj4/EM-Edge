package jsp_servlet._eipad._jsp._chartwidgets;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.google.gson.*;
import eIPAD.chartsummary.allergies.response.EventTypeResponse;
import eIPAD.chartsummary.allergies.healthobject.*;
import eIPAD.chartsummary.common.response.ErrorInfo;
import eIPAD.chartsummary.common.healthobject.PatContext;

public final class __recordallergy extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/chartwidgets/RecordAllergy.jsp", 1738426224036L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block11 ="/eIPAD/js/iscroll.js\"></script>\n<script type=\"application/javascript\" src=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="/eIPAD/js/AllergyTransaction.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n<script>\n\ndocument.addEventListener(\'touchmove\', function (e) { e.preventDefault(); }, false);\ndocument.addEventListener(\'DOMContentLoaded\', allergyScroll, false);\n\n\n</script>\n<style>\n\n\n\n</style>\n</head>\n<body>\n   \t<div id=\"divParent\" class=\"divParent\" data-role=\"page\"\n\t\tstyle=\"padding: 0px\">\n\t\t<form name=\"frmRecordAllergy\" id=\"frmRecordAllergy\" id=\"frmRecordAllergy\" method=\"post\" style=\"width: 100%; height: 100%\" action=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="/mobile/chartsummary/AllergyTransactionServlet\">\n\t\t\t<!-- Remove reaction -->\n\t\t\t <div data-role = \"none\" id = \"dvMez\" class = \"blurPopup\" data-popid=\"\"></div>\n\t\t\t <div id = \"sfsarrowUp\" data-role = \"none\" class = \"RA-sfs-bubble-arrow RA-sfs-bubble-UpArrowTheme\" ></div>\n\t\t\t <div id = \"sfsarrowDown\" data-role = \"none\" class = \"RA-sfs-bubble-arrowDown RA-sfs-bubble-DownArrowTheme\" ></div>\n\t\t\t <div id = \"dvRemoveReaction\" data-role = \"none\" class = \"dvRemoveReaction dvRemoveReactionTheme\" onclick = \"deleteReaction(this)\">Remove</div>\n\t\t\t<!-- Remove reaction end --->\n\t\t\t<!-- popup container  -->\n\t\t\t<div data-role=\"none\" class=\"allergenSfs sfsIPTheme\" id=\"sfs\">\n\t\t\t\t<iframe id=\"sfsFrame\" frameborder=\"0\" style=\"display: block;\"\n\t\t\t\t\tscrolling=\"no\" class=\"popupIFrame\" src=\"\"></iframe>\n\t\t\t</div>\n\t\t\t<!-- popup container ends -->\n\t\t\t<div id=\"allergyHeader\" class=\"AllergyHeader\" style=\"padding: 0px\"\n\t\t\t\tdata-role=\"none\">\n\t\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" class=\"tbAllergyHeader\"\n\t\t\t\t\tdata-role=\"none\">\n\t\t\t\t\t<tr class=\"normalTr\">\n\t\t\t\t\t\t<td class=\"normalTd\">\n\t\t\t\t\t\t\t<div class=\"RecordAllergyHeader RecordAllergyHeaderTheme\">\n\t\t\t\t\t\t\t\t<div class=\"RecordAllergyTable\">\n\t\t\t\t\t\t\t\t\t<div class=\"normalRow\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyCell\" style=\"width: 99%; text-align: left\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"allergyHeaderPageTitle ipHeaderPageTitleTheme\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyCell\" style=\"width: 1%\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"RecordAllergyTable\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"normalRow\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyCell\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"width: auto; text-align: right\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"buttonContainer\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"WidgetButtonTheme\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tid=\"RecordAllergySubmitButton\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tonclick=\"validateAndRecordAllergy()\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="/eIPAD/images/CS_Ok16x16.png\"/>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyCell\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"width: auto; text-align: right\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"buttonContainer\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"WidgetButtonTheme\" onclick=\"cancelTransaction()\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="/eIPAD/images/CS_Close16x16.png\"/>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t</div>\n\t\t\t<div id=\"divcnt\" class=\"divAllergyContent divAllergyContentTheme\"\n\t\t\t\tstyle=\"padding: 0px; overflow: hidden\" data-role=\"none\">\n\t\t\t\t<div style=\"width: 100%; height: auto; overflow: auto\"\n\t\t\t\t\tdata-role=\"none\">\n\t\t\t\t\t<div data-role=\"none\" style=\"width: 100%; height: auto\">\n\t\t\t\t\t\t<!-- Record allergy content starts here -->\n\t\t\t\t\t\t<div class=\"AllergyDetailsHeader AllergyDetailsHeaderTheme\"\n\t\t\t\t\t\t\tdata-role=\"none\">\n\t\t\t\t\t\t\t<span class=\"spanAllergyDetailsHeader\" data-role=\"none\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</span>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t<!-- first row -->\n\t\t\t\t\t\t<div class=\"rowContainer\" data-role=\"none\">\n\t\t\t\t\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" class=\"tbRowContainer\"\n\t\t\t\t\t\t\t\tborder=\"0\">\n\t\t\t\t\t\t\t\t<tr class=\"normalTr\">\n\t\t\t\t\t\t\t\t\t<td class=\"td30\" valign=\"middle\" align=\"right\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"allergyRowFonts\">";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</div>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td class=\"td70\" valign=\"middle\" align=\"left\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"divRangeContainer\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t<div id=\"nDvParentI\" class=\"parent\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"scaleDvI\" class=\"scale scaleTheme\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-role=\"none\" class=\"Round roundTheme\" id=\"RoundI\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tdata-count=\"I\"></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-role=\"none\" class=\"scaleHover scaleHoverTheme\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tid=\"scaleHoverI\"></div>\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-role=\"none\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tclass=\"scaleSeparator1 scaleSeparatorTheme\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tonclick=\"sliderControlClick(event,this,\'I\',false,true,\'0%\',\'U\',\'01\')\"></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-role=\"none\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tclass=\"scaleSeparator2 scaleSeparatorTheme\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tonclick=\"sliderControlClick(event,this,\'I\',false,true,\'33%\',\'M\',\'02\')\"></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-role=\"none\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tclass=\"scaleSeparator3 scaleSeparatorTheme\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tonclick=\"sliderControlClick(event,this,\'I\',false,true,\'66%\',\'O\',\'03\')\"></div>\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-role=\"none\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tclass=\"scaleSeparator4 scaleSeparatorTheme1\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tonclick=\"sliderControlClick(event,this,\'I\',false,true,\'98%\',\'S\',\'04\')\"></div>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"position: relative; width: 100%; height: 20px\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-map = \"I\" data-left = \"0%\" style=\"position: absolute; left: 0.5%;\" class = \"dvSliderLabel\" onclick=\"sliderControlClick(event,this,\'I\',false,true,\'0%\',\'U\',\'01\')\">";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-map = \"I\" data-left = \"33%\" style=\"position: absolute; left: 30%\" class = \"dvSliderLabel\" onclick=\"sliderControlClick(event,this,\'I\',false,true,\'33%\',\'M\',\'02\')\">";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-map = \"I\" data-left = \"66%\" style=\"position: absolute; left: 64%\" class = \"dvSliderLabel\" onclick=\"sliderControlClick(event,this,\'I\',false,true,\'66%\',\'O\',\'03\')\">";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-map = \"I\" data-left = \"98%\" style=\"position: absolute; right: 1%\" class = \"dvSliderLabel\" onclick=\"sliderControlClick(event,this,\'I\',false,true,\'98%\',\'S\',\'04\')\">";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</div>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t</table>\n\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t<!-- first row ends -->\n\t\t\t\t\t\t<div class=\"rowDivider\"></div>\n\t\t\t\t\t\t<!-- Second Row Starts -->\n\t\t\t\t\t\t<div class=\"rowContainer\" data-role=\"none\">\n\t\t\t\t\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" class=\"tbRowContainer\"\n\t\t\t\t\t\t\t\tborder=\"0\">\n\t\t\t\t\t\t\t\t<tr class=\"normalTr\">\n\t\t\t\t\t\t\t\t\t<td class=\"td30\" valign=\"middle\" align=\"right\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"allergyRowFonts\" id=\"cmbEventType_Label\">";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" <font style=\"color: red\">*</font>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td class=\"td70\" valign=\"middle\" align=\"left\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"divEvent divEventTheme\">\n\t\t\t\t\t\t\t\t\t\t\t<table cellpadding=\"0\" cellspacing=\"0\"\n\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"width: 100%; height: 100%\">\n\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"width: 100%; height: 100%\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"width: 100%; height: 100%\" valign=\"middle\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\talign=\"right\">\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t <input id=\"cmbEventType\" data-type=\"ComboBox\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tdata-role=\"none\" data-mandatory=\"true\" /> <script>\n\t\t\t\t\t\t\t\t\t\t  \t  $(document).ready(function() {\n\t\t\t\t\t\t\t\t\t\t  \t\t  var data1 = null;\n\t\t\t\t\t\t\t\t\t\t  \t\t  var eventValue = document.getElementById(\"hdnEventValues\").value;\n\t\t\t\t\t\t\t\t\t\t  \t\t  eventValue = eventValue.replace(\"\'\", \"\\\'\");\n\t\t\t\t\t\t\t\t\t\t  \t\t // eventValue = escape(eventValue);\n\t\t\t\t\t\t\t\t\t\t  \t\t//  alert(eventValue);\n\t\t\t\t\t\t\t\t\t\t  \t\t   data1 = JSON.parse(eventValue);\n\t\t\t\t\t\t\t\t\t\t  \t\t $(\"#cmbEventType\").kendoComboBox({\n\t\t\t\t\t\t\t\t\t\t  \t\t\tfilter:\"startswith\",\n\t\t\t\t\t\t\t\t\t\t  \t\t\tdataTextField: \"eventTypeDescription\",\n\t\t\t\t\t\t\t                        dataValueField: \"eventTypeCode\",\n\t\t\t\t\t\t\t                        dataSource: data1,\n\t\t\t\t\t\t\t                        change: function(e) {\n\t\t\t\t\t\t\t                        \tclearDetails(\"EVNT\");\n\t\t\t\t\t\t\t                        \tvar selectedIndex = this.select();\n\t\t\t\t\t\t\t                        \t//alert(selectedIndex);\n\t\t\t\t\t\t\t                        \t\n\t\t\t\t\t\t\t                       \n\t\t\t\t\t\t\t                        \tcmbPrevEventTypeText = this.text();\n\t\t\t\t\t\t\t                        \tcmbEventTypePrevValue = this.value();\n\t\t\t\t\t\t\t                        \tif(selectedIndex == -1){\n\t\t\t\t\t\t\t                        \t\tthis.value(\"\");\n\t\t\t\t\t\t\t                        \t}\n\t\t\t\t\t\t\t                        \tdocument.getElementById(\"hdnEventTypeCode\").value = this.value();\n\t\t\t\t\t\t\t                        \tdocument.getElementById(\"hdnEventTypeCodeValue\").value = this.value();\n\t\t\t\t\t\t\t                        \t//alert(document.getElementById(\"hdnEventTypeCode\").value);\n\t\t\t\t\t\t\t                        \tif(this.value() == \"DA\")\n\t\t\t\t\t\t\t                        \t{\n\t\t\t\t\t\t\t                        \t  $(\'#dvCA1\').css(\"display\" , \"none\");\n\t\t\t\t\t\t\t                        \t  $(\'#dvCA2\').css(\"display\" , \"block\");\n\t\t\t\t\t\t\t                        \t}\n\t\t\t\t\t\t\t                        \telse\n\t\t\t\t\t\t\t                        \t{\n\t\t\t\t\t\t\t                        \t\t$(\'#dvCA1\').css(\"display\" , \"block\");\n\t\t\t\t\t\t\t\t                        \t$(\'#dvCA2\').css(\"display\" , \"none\");\n\t\t\t\t\t\t\t                        \t}\n\t\t\t\t\t\t\t                        \tscrollRefresh();\n\t\t\t\t\t                                  }\n\t\t\t\t\t\t\t\t\t\t  \t\t });\n\t\t\t\t\t\t\t\t\t\t  \t  });\n\t\t\t\t\t\t\t\t\t\t  \t \t</script>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t<!-- second Row ends -->\n\t\t\t\t\t\t<div class=\"rowDivider\"></div>\n\t\t\t\t\t\t<!-- Third Row Starts -->\n\t\t\t\t\t\t<div class=\"rowContainer\" data-role=\"none\">\n\t\t\t\t\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" class=\"tbRowContainer\"\n\t\t\t\t\t\t\t\tborder=\"0\">\n\t\t\t\t\t\t\t\t<tr class=\"normalTr\">\n\t\t\t\t\t\t\t\t\t<td class=\"td30\" valign=\"middle\" align=\"right\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"allergyRowFonts\" id=\"txtAllergen_Label\">";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =" <font style=\"color: red\">*</font>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td class=\"td70\" valign=\"middle\" align=\"left\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"divEvent divEventTheme\"\n\t\t\t\t\t\t\t\t\t\t\tonclick=\"showAllergenSfs()\">\n\t\t\t\t\t\t\t\t\t\t\t<table cellpadding=\"0\" cellspacing=\"0\"\n\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"width: 100%; height: 100%\">\n\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"width: 100%; height: 100%\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"width: 99%; height: 100%\" valign=\"middle\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"text\" readonly data-role=\"none\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tclass=\"txtContent\" name=\"txtAllergen\" id=\"txtAllergen\" id=\"txtAllergen\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tdata-mandatory=\"true\" />\n\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"width: 1%; height: 100%\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"cellDivider\"><div data-role = \"none\" class = \"dvSerarchIcon\"></div></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t<!-- Third Row Ends -->\n\t\t\t\t\t\t<div class=\"rowDivider\"></div>\n\t\t\t\t\t\t<!-- Fourth Row Starts -->\n\t\t\t\t\t\t<div class=\"rowContainer1\" data-role=\"none\" id=\"dvCA1\">\n\t\t\t\t\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" class=\"tbRowContainer1\"\n\t\t\t\t\t\t\t\tborder=\"0\">\n\t\t\t\t\t\t\t\t<tr class=\"normalTr\">\n\t\t\t\t\t\t\t\t\t<td class=\"td30\" valign=\"middle\" align=\"right\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"allergyRowFonts\" id=\"txtCA_Label\">";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</div>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td class=\"td70\" valign=\"middle\" align=\"left\">\n\t\t\t\t\t\t\t\t\t\t<div style=\"position: relative; width: 100%; height: auto\"\n\t\t\t\t\t\t\t\t\t\t\tdata-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t<textarea class=\"txtArea\" data-role=\"none\" id=\"txtCA\" name=\"txtCA\"\n\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"display: block\" rows=\"50\" cols=\"10\">\n\t      \t\t\t\t\t\t\t\t\t</textarea>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t<div class=\"rowContainer\" data-role=\"none\" style=\"display: none\"\n\t\t\t\t\t\t\tid=\"dvCA2\">\n\t\t\t\t\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" class=\"tbRowContainer\"\n\t\t\t\t\t\t\t\tborder=\"0\">\n\t\t\t\t\t\t\t\t<tr class=\"normalTr\">\n\t\t\t\t\t\t\t\t\t<td class=\"td30\" valign=\"middle\" align=\"right\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"allergyRowFonts\">";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</div>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td class=\"td70\" valign=\"middle\" align=\"left\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"divEvent divEventTheme\" data-role=\"none\"\n\t\t\t\t\t\t\t\t\t\t\tonclick=\"showCaSfs()\">\n\t\t\t\t\t\t\t\t\t\t\t<table cellpadding=\"0\" cellspacing=\"0\"\n\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"width: 100%; height: 100%\">\n\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"width: 100%; height: 100%\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"width: 99%; height: 100%\" valign=\"middle\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input readonly type=\"text\" data-role=\"none\" class=\"txtContent\" id=\"txtCAS\" name=\"txtCAS\" id=\"txtCAS\"/>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"width: 1%; height: 100%\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"cellDivider\"></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t<!-- Fourth Row Ends -->\n\t\t\t\t\t\t<div class=\"rowDivider\"></div>\n\t\t\t\t\t\t<!-- Fifth row starts -->\n\t\t\t\t\t\t<div class=\"rowContainer\" data-role=\"none\" style=\"display: block\">\n\t\t\t\t\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" class=\"tbRowContainer\"\n\t\t\t\t\t\t\t\tborder=\"0\" data-role=\"none\">\n\t\t\t\t\t\t\t\t<tr class=\"normalTr\">\n\t\t\t\t\t\t\t\t\t<td class=\"td30\" valign=\"middle\" align=\"right\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"allergyRowFonts\" id=\"OnsetDateTime_Label\">";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =" <font style=\"color: red\">*</font>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td class=\"td70\" valign=\"middle\" align=\"left\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"divEvent divEventTheme\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t<table cellpadding=\"0\" cellspacing=\"0\"\n\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"width: 100%; height: 100%\">\n\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"width: 100%; height: 100%\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"width: 50%; height: 100%\" valign=\"middle\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table cellpadding = \"0\" cellspacing = \"0\" style = \"height:100%;width:100%\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style = \"height:100%;width:100%\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style = \"height:100%;width:2%\" align = \"right\" valign = \"middle\"><input type = \"checkBox\" name = \"chkEstDuration\" id = \"chkEstDuration\" onclick = \"setEstDurn(this)\" style = \"margin-left:5px;height:20px;width:20px\"/></td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style = \"height:100%;width:98%\" align = \"left\" valign = \"middle\"><span class=\"allergyRowFonts\">";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</span></td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n                                       \n\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"width: 50%; height: 100%\" valign=\"middle\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\talign=\"right\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<!-- Error Message Container for onset date -->\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"formValWarningTheme formValError\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tid=\"OnsetDateTime_Warning\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"top: 45px; left: 0px; display: none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"formValErrorMsgTheme\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tid=\"OnsetDateTime_WarningMsg\"></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div> <input id=\"OnsetDateTime\" data-type=\"DateTime\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tdata-count=\"I\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"text-align:right\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tdata-role=\"none\" onchange=\"validate(this)\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tdata-errmsg1=\"Onset date should be between Date of Birth and Current date\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tdata-mandatory=\"true\" /> <script>\n\t\t\t\t\t\t\t\t\t\t\t\t            $(document).ready(function() {\n\t\t\t\t\t\t\t\t\t\t\t\t                // create DateTimePicker from input HTML element\n\t\t\t\t\t\t\t\t\t\t\t\t                //var today = new Date();\n\t\t\t\t\t\t\t\t\t\t\t\t                $(\"#OnsetDateTime\").kendoDateTimePicker({\n\t\t\t\t\t\t\t\t\t\t\t\t                \t interval: 5,\n\t\t\t\t\t\t\t\t\t\t\t\t        \t\t\t value: today\n\t\t\t\t\t\t\t\t\t\t\t\t                });\n\t\t\t\t\t\t\t\t\t\t\t\t            });\n\t\t\t\t\t\t\t\t\t\t\t\t        </script>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t<!-- Fifth row ends -->\n\t\t\t\t\t\t<div class=\"rowDivider\"></div>\n\t\t\t\t\t\t<!-- sixth row starts -->\n\t\t\t\t\t\t<div class=\"rowContainer\" data-role=\"none\" style=\"display: block\">\n\t\t\t\t\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" class=\"tbRowContainer\"\n\t\t\t\t\t\t\t\tborder=\"0\">\n\t\t\t\t\t\t\t\t<tr class=\"normalTr\">\n\t\t\t\t\t\t\t\t\t<td class=\"td30\" valign=\"middle\" align=\"right\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"allergyRowFonts\" id=\"ActiveSinceDate_Label\">\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =" <font style=\"color: red\">*</font>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td class=\"td70\" valign=\"middle\" align=\"left\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"divEvent divEventTheme\">\n\t\t\t\t\t\t\t\t\t\t\t<table cellpadding=\"0\" cellspacing=\"0\"\n\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"width: 100%; height: 100%\" >\n\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"width: 100%; height: 100%\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"width: 5%; height: 100%\" valign=\"middle\" align = \"left\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<!--  <input type = \"checkBox\" name = \"chkEstDuration\" id = \"chkEstDuration\" style = \"height:20px;width:20px\"/>&nbsp;Estimated Duration\n\t\t\t\t\t\t\t\t\t\t\t\t\t--> \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"width: 95%; height: 100%\" valign=\"middle\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\talign=\"right\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<!-- Error Message Container for onset date -->\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"formValWarningTheme formValError\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tid=\"ActiveSinceDate_Warning\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"top: 45px; left: 0px; display: none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"formValErrorMsgTheme\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tid=\"ActiveSinceDate_WarningMsg\"></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div> <input id=\"ActiveSinceDate\" data-type=\"Date\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tdata-count=\"I\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"text-align:right\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tdata-role=\"none\" onchange=\"validate(this)\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tdata-errmsg1=\"Active Since Date cannot be greater than Current Date\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tdata-errmsg2=\"Active Since Date cannot be less than Onset Date\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tdata-mandatory=\"true\" /> <script>\n\t\t\t\t\t\t\t\t\t\t\t\t            $(document).ready(function() {\n\t\t\t\t\t\t\t\t\t\t\t\t                // create DateTimePicker from input HTML element\n\t\t\t\t\t\t\t\t\t\t\t\t               // var today1 = new Date();\n\t\t\t\t\t\t\t\t\t\t\t\t                $(\"#ActiveSinceDate\").kendoDatePicker({\n\t\t\t\t\t\t\t\t\t\t\t\t        \t\t\t value: today\n\t\t\t\t\t\t\t\t\t\t\t\t                });\n\t\t\t\t\t\t\t\t\t\t\t\t            });\n\t\t\t\t\t\t\t\t\t\t\t\t        </script>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t<!-- sixth row ends -->\n\t\t\t\t\t\t<div class=\"rowDivider\"></div>\n\t\t\t\t\t</div>\n\t\t\t\t\t<!-- alergy content ends -->\n\t\t\t\t\t<!-- Reaction content strats -->\n\t\t\t\t\t<div data-role=\"none\" style=\"width: 100%; height: auto\"\n\t\t\t\t\t\tid=\"dvRContent\">\n\t\t\t\t\t\t<!-- reaction header starts -->\n\t\t\t\t\t\t<div data-role=\"none\" class=\"reactionHeader\">\n\t\t\t\t\t\t\t<table style=\"height: 100%; width: 100%\" cellspacing=\"0\"\n\t\t\t\t\t\t\t\tcellpadding=\"0\" border=\"0\" data-role=\"none\">\n\t\t\t\t\t\t\t\t<tr style=\"height: 100%; width: 100%\">\n\t\t\t\t\t\t\t\t\t<td style=\"height: 100%; width: 100%\" valign=\"middle\"><span\n\t\t\t\t\t\t\t\t\t\tclass=\"spanAllergyDetailsHeader\"\n\t\t\t\t\t\t\t\t\t\tid=\"AllergyAllReactions_Label\" data-role=\"none\">";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t\t\t\t\t</span><font style=\"color: red\">*</font></td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t<!-- reaction header ends-->\n\t\t\t\t\t\t<div class=\"rowDivider\"></div>\n\t\t\t\t\t\t<!-- reaction 1st row starts -->\n\t\t\t\t\t\t<div data-role=\"none\" class=\"rowContainer\">\n\t\t\t\t\t\t\t<table class=\"tbRowContainer\" cellspacing=\"0\" cellpadding=\"0\"\n\t\t\t\t\t\t\t\tborder=\"0\" data-role=\"none\">\n\t\t\t\t\t\t\t\t<tr class=\"normalTr\">\n\t\t\t\t\t\t\t\t\t<td class=\"reactionTd\" valign=\"middle\">\n\t\t\t\t\t\t\t\t\t\t<div data-role = \"none\" class = \"divReaction divReactionTheme\">\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t\t\t\t\t\t<input type=\"text\" data-role=\"none\" class=\"txtContent\" name=\"txtReactionSearch\" id=\"txtReactionSearch\" id=\"txtReactionSearch\" placeholder=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\"/>\n\t\t\t\t\t\t\t\t\t\t</div>\t\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td class=\"reactionSmallTd\" valign=\"middle\" align=\"right\">\n\t\t\t\t\t\t\t\t\t\t<div data-role=\"none\" class=\"addReactionDiv\"\n\t\t\t\t\t\t\t\t\t\t\tonclick=\"showReactionSfs()\"></div>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</div>\n\t\t\t\t\t<!-- Reaction content ends -->\n\t\t\t\t</div>\n\t\t\t\t<!-- first child of the scroller control -->\n\t\t\t\t<!-- Mandatory fields error -->\n\t\t\t\t<div class=\"formValErrorTheme formValError\"\n\t\t\t\t\tid=\"MandatoryFields_Error\"\n\t\t\t\t\tstyle=\"bottom: 0px; left: 0px; display: none\">\n\t\t\t\t\t<div class=\"formValErrorMsgTheme\" id=\"MandatoryFields_ErrorMsg\">All\n\t\t\t\t\t\tmandatory fields must be entered</div>\n\t\t\t\t</div>\n\t\t\t</div>\n\t\t\t<!-- scrolling div ends -->\n\t\t\t<input type=\"hidden\" name=\"hdnEventValues\" id=\"hdnEventValues\" id=\"hdnEventValues\"\n\t\t\t\tvalue=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' /> \n\t\t\t<input type=\"hidden\" name=\"hdnHypSensitivity\" id=\"hdnHypSensitivity\" id=\"hdnHypSensitivity\" value=\"01\" /> \n\t\t\t<input type=\"hidden\" name=\"hdnPath\" id=\"hdnPath\" id=\"hdnPath\" value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" /> \n\t\t\t<input type=\"hidden\" name=\"hdnEventTypeCode\" id=\"hdnEventTypeCode\" id=\"hdnEventTypeCode\" /> \n\t\t\t<input type=\"hidden\" name=\"hdnEventTypeCodeValue\" id=\"hdnEventTypeCodeValue\"\n\t\t\t\tid=\"hdnEventTypeCodeValue\" /> <input type=\"hidden\"\n\t\t\t\tname=\"hdnSfsType\" id=\"hdnSfsType\" id=\"hdnSfsType\" /> <input type=\"hidden\"\n\t\t\t\tname=\"hdnAllergenCode\" id=\"hdnAllergenCode\" id=\"hdnAllergenCode\" /> \n\t\t\t<input type=\"hidden\" name=\"hdnCACode\" id=\"hdnCACode\" id=\"hdnCACode\" />\n\t\t\t<input type = \"hidden\" name = \"hdnReactionCount\" id = \"hdnReactionCount\" />\n\t\t\t<input type = \"hidden\" name = \"hdnAddedReactionId\" id = \"hdnAddedReactionId\" />\n\t\t\t<input type = \"hidden\" name = \"hdnEstimatedDuration\" id = \"hdnEstimatedDuration\" value = \"N\"/>\n\t\t\t<input type = \"hidden\" name = \"hdnTransactionMode\" id = \"hdnTransactionMode\" value = \"INSERT\"/>\n\t\t\t<input type = \"hidden\" name = \"hdnOnsetDateTime\" id = \"hdnOnsetDateTime\" value=\"\"/>\n\t\t\t<input type = \"hidden\" name = \"hdnActiveSinceDate\" id = \"hdnActiveSinceDate\" value=\"\"/>\n\t\t\t<input type = \"hidden\" name = \"hdnReactionsToAdd\" id = \"hdnReactionsToAdd\" value=\"\"/>\n\t\t\t\n\t\t\t<input type = \"hidden\" name = \"today\" id = \"today\" value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\"/>\n\t\t\t<input type = \"hidden\" name = \"patientDOB\" id = \"patientDOB\" value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\"/>\n\t\t\t\n\t\t</form>\n\t</div>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block1Bytes, _wl_block1);

EventTypeResponse oEvntTypeRes = null;
List<EventType> oLstEvntType = null;
String eventTypeResponse = "";
Gson gson = new Gson();
if(request.getAttribute("EventTypeResponse") != null)
{

	oEvntTypeRes = (EventTypeResponse)request.getAttribute("EventTypeResponse");
	if(oEvntTypeRes != null)
	{
		oLstEvntType = oEvntTypeRes.getLstEventTypeDetails();
		if(oLstEvntType != null && oLstEvntType.size() > 0)
		{
			eventTypeResponse = gson.toJson(oLstEvntType);
		}
		
	}
}
String patientDOB="";
PatContext patContext= (PatContext)session.getAttribute("PatientContext");
if(patContext!=null){
	patientDOB = patContext.getDob();
}
//setting current date in dd/mm/yyyy hh:mm
java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm");
String today = dateFormat.format(new java.util.Date());

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
            out.print( String.valueOf(csResBundle.getString("allergy.allergen") ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(csResBundle.getString("allergy.details") ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(csResBundle.getString("allergy.hypersensitivity") ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(csResBundle.getString("allergy.type1") ));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(csResBundle.getString("allergy.type2") ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(csResBundle.getString("allergy.type3") ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(csResBundle.getString("allergy.type4") ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(csResBundle.getString("allergy.eventType")));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(csResBundle.getString("allergy.allergen")));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(csResBundle.getString("allergy.CS")));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(csResBundle.getString("allergy.CS")));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(csResBundle.getString("allergy.onsetDate")));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(csResBundle.getString("allergy.estdurn")));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(csResBundle.getString("allergy.activeSince")));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(csResBundle.getString("allergy.reaction")));
            _bw.write(_wl_block30Bytes, _wl_block30);
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(csResBundle.getString("allergy.enterReaction")));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(eventTypeResponse));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(today));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(patientDOB));
            _bw.write(_wl_block36Bytes, _wl_block36);
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
