package jsp_servlet._eipad._jsp._chartwidgets;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.google.gson.*;
import eIPAD.chartsummary.common.healthobject.*;

public final class __sfsgson extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/chartwidgets/SfsGson.jsp", 1709118025084L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\t\t\n\n<div data-role=\"none\" class=\"reactionItemsContainer\"\n\tid=\"ReactionContainer";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\" >\n\t<!-- reaction first row -->\n\t<table class=\"tbReactionItemsContainer\" cellspacing=\"0\" cellpadding=\"0\"\n\t\tborder=\"0\" data-role=\"none\">\n\t\t<tr class=\"normalTr\">\n\t\t\t<td class=\"reactionTd\" valign=\"middle\">\n\t\t\t\t<div data-role=\"none\" style=\"height: auto\"\n\t\t\t\t\tid=\"dvReactionParent";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\">\n\t\t\t\t\t<div data-role=\"none\" class=\"reactionItems\">\n\t\t\t\t\t\t<!-- reaction items -->\n\t\t\t\t\t\t<div class=\"rowContainer\" data-role=\"none\">\n\t\t\t\t\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" class=\"tbRowContainer\"\n\t\t\t\t\t\t\t\tborder=\"0\" data-role=\"none\">\n\t\t\t\t\t\t\t\t<tr class=\"normalTr\">\n\t\t\t\t\t\t\t\t\t<td class=\"removeReactionSmallTd\" valign=\"middle\" align=\"right\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"allergyRowFonts\">Reaction Description</div>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td class=\"removeReactionTd\" valign=\"middle\" align=\"left\">\n\t\t\t\t\t\t\t\t\t\t<span data-role=\"none\" class=\"spanReactionContent\">";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="</span>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t<div class=\"rowDivider\"></div>\n\t\t\t\t\t\t<div class=\"rowContainer\" data-role=\"none\">\n\t\t\t\t\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" class=\"tbRowContainer\"\n\t\t\t\t\t\t\t\tborder=\"0\" data-role=\"none\">\n\t\t\t\t\t\t\t\t<tr class=\"normalTr\">\n\t\t\t\t\t\t\t\t\t<td class=\"removeReactionSmallTd\" valign=\"middle\" align=\"right\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"allergyRowFonts\"\n\t\t\t\t\t\t\t\t\t\t\tid=\"ReactionDateTime";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="_Label\">";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 =" <font style=\"color: red\">*</font>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td class=\"removeReactionTd\" valign=\"middle\" align=\"left\">\n\t\t\t\t\t\t\t\t\t\t<!-- Error Message Container for reac date -->\n\t\t\t\t\t\t\t\t\t\t<div class=\"formValWarningTheme formValError\"\n\t\t\t\t\t\t\t\t\t\t\tid=\"ReactionDateTime";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="_Warning\"\n\t\t\t\t\t\t\t\t\t\t\tstyle=\"top: 55px; left: 32.5%; display: none; width: auto;\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"formValErrorMsgTheme\"\n\t\t\t\t\t\t\t\t\t\t\t\tid=\"ReactionDateTime";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="_WarningMsg\"></div>\n\t\t\t\t\t\t\t\t\t\t</div> <input id=\"ReactionDateTime";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" data-count=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\"\n\t\t\t\t\t\t\t\t\t\tdata-type=\"DateTime\"\n\t\t\t\t\t\t\t\t\t\tstyle=\"position: relative; width: 240px; margin-left: 10px\"\n\t\t\t\t\t\t\t\t\t\tdata-role=\"none\" onchange=\"validate(this)\"\n\t\t\t\t\t\t\t\t\t\tdata-errmsg1=\"Reaction Date/Time cannot be greater than Current Date/Time\"\n\t\t\t\t\t\t\t\t\t\tdata-errmsg2=\"Reaction Date cannot be less than Active since Date\"\n\t\t\t\t\t\t\t\t\t\tdata-mandatory=\"true\" /> <input type=\"hidden\"\n\t\t\t\t\t\t\t\t\t\tid=\"hdnReactionDateTime";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\"\n\t\t\t\t\t\t\t\t\t\tname=\"hdnReactionDateTime";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" /> \n\t\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t\t $(document).ready(function() {\n\t\t\t\t\t\t\t              // create DateTimePicker from input HTML element\n\t\t\t\t\t\t\t\t\t\t     //var today2 = new Date();\n\t\t\t\t\t\t\t                 $(\"#ReactionDateTime";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\").kendoDateTimePicker({\n\t\t\t\t\t\t\t\t\t\t\t\t interval: 5,\n\t\t\t\t\t\t\t\t\t\t\t\t value: today,\n\t\t\t\t\t\t\t\t\t\t\t\t change : function(e)\n\t\t\t\t\t\t\t\t\t\t\t\t {\n\t\t\t\t\t\t\t\t\t\t\t\t\t var react_date_calobj = $(\"#ReactionDateTime";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\").data(\"kendoDateTimePicker\");\n\t\t\t\t\t\t\t\t\t\t\t\t \t $(\"#hdnReactionDateTime";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\").val(DMYHMToString(react_date_calobj.value()));\n\t\t\t\t\t\t\t\t\t\t\t\t }\n\t\t\t\t\t\t\t\t\t\t\t });\n\t\t\t\t\t\t\t\t\t\t  });\n\t\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t<div class=\"rowDivider\"></div>\n\t\t\t\t\t\t<div class=\"rowContainer\" data-role=\"none\">\n\t\t\t\t\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" class=\"tbRowContainer\"\n\t\t\t\t\t\t\t\tborder=\"0\">\n\t\t\t\t\t\t\t\t<tr class=\"normalTr\">\n\t\t\t\t\t\t\t\t\t<td class=\"removeReactionSmallTd\" valign=\"middle\" align=\"right\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"allergyRowFonts\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</div>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td class=\"removeReactionTd\" valign=\"middle\" align=\"left\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"divRangeContainer\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t<div id=\"nDvParent";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" class=\"parent\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"scaleDv";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" class=\"scale scaleTheme\"\n\t\t\t\t\t\t\t\t\t\t\t\t\tdata-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-role=\"none\" class=\"Round roundTheme\" id=\"Round";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\"></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-role=\"none\" class=\"scaleHover scaleHoverTheme\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tid=\"scaleHover";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\"></div>\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-role=\"none\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tclass=\"scaleSeparator1 scaleSeparatorTheme\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tonclick=\"sliderControlClick(event,this,";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =",true,false,\'0%\',\'U\',\'01\')\"></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-role=\"none\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tclass=\"scaleSeparator2 scaleSeparatorTheme\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tonclick=\"sliderControlClick(event,this,";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =",true,false,\'33%\',\'M\',\'02\')\"></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-role=\"none\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tclass=\"scaleSeparator3 scaleSeparatorTheme\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tonclick=\"sliderControlClick(event,this,";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =",true,false,\'66%\',\'O\',\'03\')\"></div>\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-role=\"none\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tclass=\"scaleSeparator4 scaleSeparatorTheme1\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tonclick=\"sliderControlClick(event,this,";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =",true,false,\'98%\',\'S\',\'04\')\"></div>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"position: relative; width: 100%; height: 20px\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-map = \"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\"  data-left = \"0%\"  style=\"position: absolute; left: 0.5%\" class = \"dvSliderLabel\" onclick=\"sliderControlClick(event,this,";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =",true,false,\'0%\',\'U\',\'01\')\">";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-map = \"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\"  data-left = \"33%\"  style=\"position: absolute; left: 31%\" class = \"dvSliderLabel\" onclick=\"sliderControlClick(event,this,";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =",true,false,\'33%\',\'M\',\'02\')\">";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\"  data-left = \"66%\"  style=\"position: absolute; left: 63%\" class = \"dvSliderLabel\" onclick=\"sliderControlClick(event,this,";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =",true,false,\'66%\',\'O\',\'03\')\">";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\"  data-left = \"98%\"  style=\"position: absolute; right: 1%\" class = \"dvSliderLabel\" onclick=\"sliderControlClick(event,this,";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =",true,false,\'98%\',\'S\',\'04\')\">";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</div>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t  \t\t\t\t$(document).ready(function() {\n\t\t\t\t\t\t\t\t  \t\t\t\t\t$(\"#Round";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\").sliderControl(); \n\t\t\t\t\t\t\t\t\t\t\t\t});\n\t\t\t\t\t\t  \t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"hdnScale";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\"\n\t\t\t\t\t\t\t\t\t\t\t\tname=\"hdnScale";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" value=\"U\" />\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t<div class=\"rowDivider\"></div>\n\t\t\t\t\t\t<div class=\"rowContainer\" data-role=\"none\">\n\t\t\t\t\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" class=\"tbRowContainer\"\n\t\t\t\t\t\t\t\tborder=\"0\">\n\t\t\t\t\t\t\t\t<tr class=\"normalTr\">\n\t\t\t\t\t\t\t\t\t<td class=\"removeReactionSmallTd\" valign=\"middle\" align=\"right\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"allergyRowFonts\">Site Of Reaction</div>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td class=\"removeReactionTd\" valign=\"middle\" align=\"left\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"divEvent divEventTheme\">\n\t\t\t\t\t\t\t\t\t\t\t<table cellpadding=\"0\" cellspacing=\"0\"\n\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"width: 100%; height: 100%\">\n\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"width: 100%; height: 100%\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"width: 100%; height: 100%\" valign=\"middle\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"text\" data-role=\"none\" class=\"txtContent\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tid=\"txtSite";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" name=\"txtSite";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" />\n\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t</div>\n\n\t\t\t\t\t</div>\n\t\t\t\t\t<!-- reaction items end -->\n\t\t\t\t</div> <!-- reaction parent -->\n\t\t\t</td>\n\t\t\t<td class=\"reactionSmallTd\" valign=\"top\" align=\"right\">\n\t\t\t\t<div data-role=\"none\" class=\"removeReaction removeReactionTheme\"\n\t\t\t\t\tdata-containerID=\"ReactionContainer";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\"\n\t\t\t\t\tonclick=\"showRemoveReactionBubble(this)\" data-Id = \"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\"></div>\n\t\t\t\t\t\n\t\t\t</td>\n\t\t\n\t\t</tr>\n\t</table>\n\t<input type=\"hidden\" name=\"reactionCode";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" id=\"reactionCode";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\"\n\t\tid=\"reactionCode";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\" />\n\t<input type=\"hidden\" name=\"reactionDesc";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\" id=\"reactionDesc";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\"\n\t\tid=\"reactionDesc";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\" />\n\t\t\n</div>\n";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\n";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

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

Locale appLocale;
if(session.getAttribute("LOCALE")!=null && !session.getAttribute("LOCALE").equals(""))
	appLocale = new Locale((String)session.getAttribute("LOCALE"));
else 
	appLocale = new Locale("en");
ResourceBundle csResBundle = ResourceBundle.getBundle("eIPAD.chartsummary.common.resourcebundle.cslabels", appLocale);
List<SfsJson> oSfsList = new ArrayList<SfsJson>();
int nCount = 0;
int nId = 0;
int nListCount = 0;
if(request.getParameter("RC") != null && !request.getParameter("RC").equals(""))
{
	nId = Integer.parseInt(request.getParameter("RC"));
}
if(request.getParameter("json") != null && !request.getParameter("json").equals(""))
{
	String reactionDetails = request.getParameter("json");
	JsonElement oJsonElement = new JsonParser().parse(reactionDetails);
	if(oJsonElement != null)
	{
		JsonArray oJsonArray = oJsonElement.getAsJsonArray();
		if(oJsonArray != null)
		{
			Iterator iterator = oJsonArray.iterator();
			
			while(iterator.hasNext()){
				JsonElement json2 = (JsonElement)iterator.next();
				Gson gson2 = new Gson();
				SfsJson oSfsJson =  gson2.fromJson(json2, SfsJson.class);
				if(oSfsJson != null)
				{
					oSfsList.add(oSfsJson);
				}
				  
				  
			}
		}
		
	}

	
}
nListCount = oSfsList.size();
if(nListCount > 0)
{
	for(nCount =0;nCount<nListCount;nCount ++)
	{
		SfsJson oSfsJson = oSfsList.get(nCount);
		
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(nId));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(nId));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(oSfsJson.desc ));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(nId));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(csResBundle.getString("allergy.date") ));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(nId));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(nId));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(nId));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(nId));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(nId));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(nId));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(nId));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(nId));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(nId));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(csResBundle.getString("allergy.severity") ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(nId));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(nId));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(nId));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(nId));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(nId));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(nId));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(nId));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(nId));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(nId));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(nId));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(nId));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(csResBundle.getString("allergy.unknown") ));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(nId));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(nId));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(csResBundle.getString("allergy.mild") ));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(nId));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(nId));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(csResBundle.getString("allergy.moderate") ));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(nId));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(nId));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(csResBundle.getString("allergy.severe") ));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(nId));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(nId));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(nId));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(nId));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(nId));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(nId));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(nId));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(nId));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(nId));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(nId));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(oSfsJson.code));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(nId));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(nId));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(nId));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(oSfsJson.desc));
            _bw.write(_wl_block49Bytes, _wl_block49);
 
		nId++;
	}
}

            _bw.write(_wl_block50Bytes, _wl_block50);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
