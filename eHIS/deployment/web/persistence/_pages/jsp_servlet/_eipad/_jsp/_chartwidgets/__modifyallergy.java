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
import eIPAD.chartsummary.allergies.response.AllergyResponse;
import eIPAD.chartsummary.allergies.healthobject.Allergy;
import eIPAD.chartsummary.allergies.healthobject.Reaction;
import eIPAD.chartsummary.common.response.ErrorInfo;

public final class __modifyallergy extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/chartwidgets/ModifyAllergy.jsp", 1709118017725L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n ";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n ";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<!DOCTYPE html> \n<html> \n<head> \n<title></title>   \n<meta name=\"apple-mobile-web-app-capable\" content=\"yes\" />   \n<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\" />\n  <link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="/eIPAD/jquery.mobile-1.0.1.min.css\" /> \n\n<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="/eIPAD/css/kendo.common.min.css\" /> \n<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="/eIPAD/css/kendo.default.min.css\" />  \n<script src=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="/eIPAD/jquery-1.9.1.js\"></script> \n  <script src=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="/eIPAD/kendo.web.min.js\"></script>\n <script src=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="/eIPAD/console.js\"></script>\n<script src=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="/eIPAD/jquery.mobile-1.0.1.min.js\"></script>\n<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="/eIPAD/css/iPADNew.css\" /> \n<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="/eIPAD/css/iPADThemeA.css\" /> \n<script type=\"application/javascript\" src=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="/eIPAD/js/iscroll.js\"></script>\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n<script type=\"application/javascript\" src=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="/eIPAD/js/AllergyTransaction.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n<script>\n\ndocument.addEventListener(\'touchmove\', function (e) { e.preventDefault(); }, false);\ndocument.addEventListener(\'DOMContentLoaded\', allergyScroll, false);\n\n\n</script>\n<style>\n\n</style>\n</head>\n\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n<body >\n\t<div id=\"divParent\" class = \"divParent\" data-role=\"page\" style = \"padding:0px\">\n\t\t<form name = \"frmRecordAllergy\" id = \"frmRecordAllergy\" method = \"post\" style = \"width:100%;height:100%\" action=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="/mobile/chartsummary/AllergyTransactionServlet\">\n\t\t\t<!-- Remove reaction -->\n\t\t\t <div data-role = \"none\" id = \"dvMez\" class = \"blurPopup\" data-popid=\"\"></div>\n\t\t\t <div id = \"sfsarrowUp\" data-role = \"none\" class = \"RA-sfs-bubble-arrow RA-sfs-bubble-UpArrowTheme\" ></div>\n\t\t\t <div id = \"sfsarrowDown\" data-role = \"none\" class = \"RA-sfs-bubble-arrowDown RA-sfs-bubble-DownArrowTheme\" ></div>\n\t\t\t <div id = \"dvRemoveReaction\" data-role = \"none\" class = \"dvRemoveReaction dvRemoveReactionTheme\" onclick = \"deleteReaction(this)\">Remove</div>\n\t\t\t <div id = \"sfsarrowUpError\" data-role = \"none\" class = \"RA-sfs-bubble-arrow RA-sfs-bubble-UpArrowTheme\" ></div>\n\t\t\t <div id = \"sfsarrowDownError\" data-role = \"none\" class = \"RA-sfs-bubble-arrowDown RA-sfs-bubble-DownArrowTheme\" ></div>\n\t\t\t <div id = \"dvMarkAsError\" data-role = \"none\" class = \"dvRemoveReaction dvRemoveReactionTheme\" onclick = \"errorReaction(this)\">Mark As Error</div>\n\t\t\t<!-- Remove reaction end --->\n\t\t<!-- popup container -->\n\t\t   <div data-role = \"none\" class = \"allergenSfs sfsIPTheme\"  id = \"sfs\" >\n  \t \t\t\t<iframe id = \"sfsFrame\" frameborder=\"0\" style = \"display:block;\" scrolling =\"no\" class=\"popupIFrame\" src = \"\"></iframe>  \n   \t\t  </div> \n\t\t <!-- popup container ends -->  \n\t\t\t<div id = \"allergyHeader\"  class = \"AllergyHeader\" style=\"padding:0px\" data-role = \"none\">\n\t\t\t  <table cellpadding = \"0\" cellspacing = \"0\" class = \"tbAllergyHeader\" data-role = \"none\">\n\t\t\t  \t\n\t\t\t  \t<tr class = \"normalTr\">\n\t\t\t  \t\t<td class = \"normalTd\">\n\t\t\t  \t\t\t<div class = \"RecordAllergyHeader RecordAllergyHeaderTheme\">\n\t\t\t  \t\t\t\t<div class = \"RecordAllergyTable\">\n\t\t\t\t\t\t\t  \t\t<div class = \"normalRow\">\n\t\t\t\t\t\t\t  \t\t\t<div class = \"AllergyCell\" style = \"width:99%;text-align:left\">\n\t\t\t\t\t\t\t  \t\t\t  <div class = \"allergyHeaderPageTitle ipHeaderPageTitleTheme\">Modify Allergy</div><!-- TODO localize -->\n\t\t\t\t\t\t\t  \t\t\t</div>\n\t\t\t\t\t\t\t  \t\t\t<div class = \"AllergyCell\" style = \"width:1%\">\n\t\t\t\t\t\t\t  \t\t\t  <div class = \"RecordAllergyTable\">\n\t\t\t\t\t\t\t  \t\t\t  \t<div class = \"normalRow\">\n\t\t\t\t\t\t\t  \t\t\t  \t\t<div class = \"AllergyCell\" style = \"width:auto;text-align:right\">\n\t\t\t\t\t\t\t  \t\t\t  \t\t\t<div class = \"buttonContainer\">\n\t\t\t\t\t\t\t  \t\t\t  \t\t\t\t<div class = \"WidgetButtonTheme\" id=\"RecordAllergySubmitButton\" onclick=\"validateAndModifyAllergy()\"><img src = \"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="/eIPAD/images/CS_Ok16x16.png\"/></div>\n\t\t\t\t\t\t\t  \t\t\t  \t\t\t</div>\n\t\t\t\t\t\t\t  \t\t\t  \t\t</div>\n\t\t\t\t\t\t\t  \t\t\t  \t\t<div class = \"AllergyCell\" style = \"width:auto;text-align:right\">\n\t\t\t\t\t\t\t  \t\t\t  \t\t\t<div class = \"buttonContainer\">\n\t\t\t\t\t\t\t  \t\t\t  \t\t\t\t<div class = \"WidgetButtonTheme\" onclick=\"cancelTransaction()\"><img src = \"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="/eIPAD/images/CS_Close16x16.png\"/></div>\n\t\t\t\t\t\t\t  \t\t\t  \t\t\t</div>\n\t\t\t\t\t\t\t  \t\t\t  \t\t</div>\n\t\t\t\t\t\t\t  \t\t\t  \t</div>\n\t\t\t\t\t\t\t  \t\t\t  </div>\n\t\t\t\t\t\t\t  \t\t\t</div>\n\t\t\t\t\t\t\t  \t\t</div>\n\t\t\t\t\t\t\t  \t</div>\n\t\t\t  \t\t\t</div>\n\t\t\t  \t\t</td>\n\t\t\t  \t</tr>\n\t\t\t  </table>\n\t\t\t</div>\n\t\t\n\t\t   \n\t\t\t<div id = \"divcnt\"  class = \"divAllergyContent divAllergyContentTheme\" style=\"padding:0px;overflow:hidden\" data-role = \"none\">\n\t\t\t\t<div style = \"width:100%;height:auto;overflow:auto\" data-role = \"none\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t<input type = \"hidden\" name = \"existingReactionCount\" id = \"existingReactionCount\" value = \"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" />\n\t\t\t\t\t\t\t\t<!-- Allergy widget content starts here -->\n\t\t\t\t\t<div class=\"AllergyContentTable WidgetContentStripTheme\" id=\"AllergyContentTable\" data-allergencode=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" data-role = \"none\">\n\t\t\t\t\t\t<div class=\"AllergyContentRow AllergyContentRowTheme\" data-role = \"none\">\n\t\t\t\t\t\t\t<div class=\"AllergyContentCol1 WidgetContentStripCol1Theme\" data-role = \"none\">\n\t\t\t\t\t\t\t\t<div class=\"AllergyReactionCount WidgetContentStripCol1BoxTheme\" data-role = \"none\">\n\t\t\t\t\t\t\t\t\t<img src=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="/eIPAD/images/Refresh_black.png\" class=\"AllergyReactionCountImage\">\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t<div class=\"AllergyContentCol2\" data-role = \"none\">\n\t\t\t\t\t\t\t\t<div class=\"WidgetParaHeadTextTheme AllergyEventTypeText\" data-role = \"none\">";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</div>\n\t\t\t\t\t\t\t\t<div class=\"WidgetNormalTextTheme AllergyAllergenText\" data-role = \"none\">";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t<div class=\"AllergyContentCol3\" data-role = \"none\">\n\t\t\t\t\t\t\t\t<div class=\"AllergyEventExpandCollapse\" data-role = \"none\">\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t\t\t\t\t\t<div class=\"AllergyEstDurationIcon\"><img src=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="/eIPAD/images/Yellow Bullet.png\" class=\"AlleryEstDurationImage\"></div>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t\t\t\t<div class=\"WidgetDateTextTheme\" data-role = \"none\">";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</div>\n\t\t\t\t\t\n\t\t\t\t\t<!-- Add Reaction content starts -->\n\t\t\t\t\t<div data-role = \"none\" style = \"width:100%;height:auto\" id=\"dvRContent\"> \n\t\t\t\t\t<!-- reaction header starts -->\n\t\t\t\t\t\t<div data-role = \"none\" class = \"reactionHeader\">\n\t\t\t\t\t\t\t<table style = \"height:100%;width:100%\" cellspacing = \"0\" cellpadding = \"0\" border = \"0\" data-role = \"none\">\n\t\t\t\t\t\t\t\t<tr style = \"height:100%;width:100%\">\n\t\t\t\t\t\t\t\t\t<td style = \"height:100%;width:100%\" valign = \"middle\">\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t<span class = \"spanAllergyDetailsHeader\" id=\"AllergyAllReactions_Label\" data-role = \"none\">Reaction </span><font style = \"color:red\">*</font>\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t<!-- reaction header ends--> \n\t\t\t\t\t\t\n\t\t\t\t\t\t<div class = \"rowDivider\"></div>\n\t\t\t\t\t\t\n\t\t\t\t\t\t<!-- reaction 1st row starts -->\n\t\t\t\t\t\t<div data-role = \"none\" class = \"rowContainer\">\n\t\t\t\t\t\t\t<table class = \"tbRowContainer\" cellspacing = \"0\" cellpadding = \"0\" border = \"0\" data-role = \"none\">\n\t\t\t\t\t\t\t\t<tr class = \"normalTr\">\n\t\t\t\t\t\t\t\t\t<td class = \"reactionTd\" valign = \"middle\" >\n\t\t\t\t\t\t\t\t\t\t<div data-role = \"none\" class = \"divReaction divReactionTheme\">\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t\t\t\t\t\t<input type=\"text\" data-role=\"none\" class=\"txtContent\" name=\"txtReactionSearch\" id=\"txtReactionSearch\" id=\"txtReactionSearch\" placeholder=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\"/>\n\t\t\t\t\t\t\t\t\t\t</div>\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td class = \"reactionSmallTd\" valign = \"middle\" align = \"right\">\n\t\t\t\t\t\t\t\t\t\t<div data-role = \"none\" class = \"addReactionDiv\" onclick=\"showReactionSfs()\"></div>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</div> <!-- Reaction content ends --> \n\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =" <!-- Adding all existing reaction codes to this String with seperator `-->\n\t\t\t\t\t<!-- Existing Reactions List starts -->\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t<div style=\"margin-left:10px;margin-top:10px;\">\n\t\t\t\t\t\t<div class=\"AllergyReactionTable AllergyReactionTableTheme\" style=\"width:100%\" data-role = \"none\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\n\t\t\t\t\t\t\t<div class=\"AllergyReactionRow\" data-role = \"none\">\n\t\t\t\t\t\t\t\t<div class=\"AllergyReactionCol1 WidgetContentStripCol1Theme\" data-role = \"none\">\n\t\t\t\t\t\t\t\t\t<div  class=\"AllergyReactionSeverityCont\" data-role = \"none\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyReactionSeverityTable\" data-role = \"none\">\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyReactionSeverityRow\" data-role = \"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyReactionDiviCell\" data-role = \"none\"><div class=\"AllergyReactionSeverityDiviTheme\" data-role = \"none\"></div></div>\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyReactionSeverityCell\" data-role = \"none\"><div class=\"AllergyReactionSeverityOrangeTheme\" data-role = \"none\"></div></div>\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyReactionDiviCell\" data-role = \"none\"><div class=\"AllergyReactionSeverityDiviTheme\" data-role = \"none\"></div></div>\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyReactionSeverityCell\" data-role = \"none\"><div class=\"AllergyReactionSeverityGrayTheme\" data-role = \"none\"></div></div>\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyReactionDiviCell\" data-role = \"none\"><div class=\"AllergyReactionSeverityDiviTheme\" data-role = \"none\"></div></div>\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyReactionSeverityCell\" data-role = \"none\"><div class=\"AllergyReactionSeverityGrayTheme\" data-role = \"none\"></div></div>\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyReactionDiviCell\" data-role = \"none\"><div class=\"AllergyReactionSeverityDiviTheme\" data-role = \"none\"></div></div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyReactionSeverityRow\" data-role = \"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyReactionDiviCell\" data-role = \"none\"><div class=\"AllergyReactionSeverityDiviTheme\" data-role = \"none\"></div></div>\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyReactionSeverityCell\" data-role = \"none\"><div class=\"AllergyReactionSeverityOrangeTheme\" data-role = \"none\"></div></div>\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyReactionDiviCell\" data-role = \"none\"><div class=\"AllergyReactionSeverityDiviTheme\" data-role = \"none\"></div></div>\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyReactionSeverityCell\" data-role = \"none\"><div class=\"AllergyReactionSeverityOrangeTheme\" data-role = \"none\"></div></div>\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyReactionDiviCell\" data-role = \"none\"><div class=\"AllergyReactionSeverityDiviTheme\" data-role = \"none\"></div></div>\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyReactionSeverityCell\" data-role = \"none\"><div class=\"AllergyReactionSeverityGrayTheme\" data-role = \"none\"></div></div>\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyReactionDiviCell\" data-role = \"none\"><div class=\"AllergyReactionSeverityDiviTheme\" data-role = \"none\"></div></div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyReactionSeverityRow\" data-role = \"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyReactionDiviCell\" data-role = \"none\"><div class=\"AllergyReactionSeverityDiviTheme\" data-role = \"none\"></div></div>\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyReactionSeverityCell\" data-role = \"none\"><div class=\"AllergyReactionSeverityOrangeTheme\" data-role = \"none\"></div></div>\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyReactionDiviCell\" data-role = \"none\"><div class=\"AllergyReactionSeverityDiviTheme\" data-role = \"none\"></div></div>\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyReactionSeverityCell\" data-role = \"none\"><div class=\"AllergyReactionSeverityOrangeTheme\" data-role = \"none\"></div></div>\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyReactionDiviCell\" data-role = \"none\"><div class=\"AllergyReactionSeverityDiviTheme\" data-role = \"none\"></div></div>\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyReactionSeverityCell\" data-role = \"none\"><div class=\"AllergyReactionSeverityOrangeTheme\" data-role = \"none\"></div></div>\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyReactionDiviCell\" data-role = \"none\"><div class=\"AllergyReactionSeverityDiviTheme\" data-role = \"none\"></div></div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyReactionSeverityRow\" data-role = \"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyReactionDiviCell\" data-role = \"none\"><div class=\"AllergyReactionSeverityDiviTheme\" data-role = \"none\"></div></div>\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyReactionSeverityCell\" data-role = \"none\"><div class=\"AllergyReactionSeverityGrayTheme\" data-role = \"none\"></div></div>\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyReactionDiviCell\" data-role = \"none\"><div class=\"AllergyReactionSeverityDiviTheme\" data-role = \"none\"></div></div>\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyReactionSeverityCell\" data-role = \"none\"><div class=\"AllergyReactionSeverityGrayTheme\" data-role = \"none\"></div></div>\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyReactionDiviCell\" data-role = \"none\"><div class=\"AllergyReactionSeverityDiviTheme\" data-role = \"none\"></div></div>\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyReactionSeverityCell\" data-role = \"none\"><div class=\"AllergyReactionSeverityGrayTheme\" data-role = \"none\"></div></div>\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyReactionDiviCell\" data-role = \"none\"><div class=\"AllergyReactionSeverityDiviTheme\" data-role = \"none\"></div></div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t<div class=\"WidgetSmallTextTheme\" data-role = \"none\">";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</div>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t<div class=\"AllergyReactionCol2 AllergyReactionCol2Theme WidgetContentStripTheme\" data-role = \"none\">\n\t\t\t\t\t\t\t\t\t<div class=\"AllergyReactionDescTheme\" data-role = \"none\">";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</div>\n\t\t\t\t\t\t\t\t\t<div class=\"AllergyReactionSiteTheme\" data-role = \"none\">";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</div>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t<div class=\"AllergyReactionCol3 AllergyReactionCol3Theme WidgetContentStripTheme\" data-role = \"none\">\n\t\t\t\t\t\t\t\t\t<div class=\"WidgetDateText2Theme\" data-role = \"none\">";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</div>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t<div class=\"\" style=\"display:table-cell;width:8%\">\n\t\t\t\t\t\t\t\t\t<div data-role = \"none\" id =\"errorReaction";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" class = \"errorReaction removeReactionTheme\" onclick = \"showMarkAsErrorBubble(this)\" style=\"margin-left:50%\" data-id=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\" data-error=\"N\"></div>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t<input type = \"hidden\" name = \"existingReactionCode";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\" id = \"existingReactionCode";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\" value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\"/>\n\t\t\t\t\t\t\t<input type = \"hidden\" name = \"existingReactionDesc";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\" id = \"existingReactionDesc";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\"/>\n\t\t\t\t\t\t\t<input type = \"hidden\" name = \"existingReactionSrlNo";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\" id = \"existingReactionSrlNo";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\"/>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</div>\n\t\t\t\t\t<!-- Existing Reactions List ends here -->\n\t\t\t\t\t\n\t\t\t\t\t<!-- Allergy widget content ends here -->\n\t\t\t\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 =" <!-- removing the last ` character -->\n\t\t\t\t\t\t<script> arrReactionCode = (\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\').split(\'`\')</script>\n\t\t\t\t\t<input type = \"hidden\" name = \"hdnHypSensitivity\" id = \"hdnHypSensitivity\" value = \"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\" />\n\t\t\t\t\t<input type = \"hidden\" name = \"hdnEventTypeCode\" id = \"hdnEventTypeCode\" value = \"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\" />\n\t\t\t\t\t<input type = \"hidden\" name = \"hdnEventTypeCodeValue\" id =\"hdnEventTypeCodeValue\" value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\" />\n\t\t\t\t\t<input type = \"hidden\" name = \"hdnSfsType\" id = \"hdnSfsType\"  />\n\t\t\t\t\t<input type = \"hidden\" name = \"hdnAllergenCode\" id = \"hdnAllergenCode\" value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\" />\n\t\t\t\t\t<input type = \"hidden\" name = \"hdnCACode\" id = \"hdnCACode\" value=\"\" /> <!-- drug code is always passed as empty in MODIFY-->\n\t\t\t\t\t<input type = \"hidden\" name = \"hdnReactionCount\" id = \"hdnReactionCount\" />\n\t\t\t\t\t<input type = \"hidden\" name = \"hdnAddedReactionId\" id = \"hdnAddedReactionId\" />\n\t\t\t\t\t<input type = \"hidden\" name = \"hdnEstimatedDuration\" id = \"hdnEstimatedDuration\" value = \"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\"/>\n\t\t\t\t\t<input type = \"hidden\" name = \"hdnTransactionMode\" id = \"hdnTransactionMode\" value = \"MODIFY\"/>\n\t\t\t\t\t<input type = \"hidden\" name = \"hdnOnsetDateTime\" id = \"hdnOnsetDateTime\" value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\"/>\n\t\t\t\t\t<input type = \"hidden\" name = \"hdnActiveSinceDate\" id = \"hdnActiveSinceDate\" value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\"/>\n\t\t\t\t\t\n\t\t\t\t\t<input type = \"hidden\" name = \"certainity\" id = \"certainity\" value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\"/>\n\t\t\t\t\t<input type = \"hidden\" name = \"status1\" id = \"status1\" value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\"/>\n\t\t\t\t\t<input type = \"hidden\" name = \"diagnosis_code\" id = \"diagnosis_code\" value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\"/>\n\t\t\t\t\t<input type = \"hidden\" name = \"remarks\" id = \"remarks\" value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\"/>\n\t\t\t\t\t<input type = \"hidden\" name = \"no_known_allergy\" id = \"no_known_allergy\" value=\"\"/> <!-- no_known_allergy is always passed as empty in MODIFY-->\n\t\t\t\t\t<input type = \"hidden\" name = \"sou_of_info\" id = \"sou_of_info\" value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\"/>\n\t\t\t\t\t<input type = \"hidden\" name = \"err_remarks\" id = \"err_remarks\" value=\"\"/><!-- err_remarks is always passed as empty in MODIFY since there is no provision in EM-Mobile to mark an allergy as error-->\n\t\t\t\t\t<input type = \"hidden\" name = \"Site_Of_Reac\" id = \"Site_Of_Reac\" value=\"\"/><!-- Site_Of_Reac is always passed as empty and is passed in MODIFY alone-->\n\t\t\t\t\t<input type = \"hidden\" name = \"treat_advice\" id = \"treat_advice\" value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\"/>\n\t\t\t\t\t<input type = \"hidden\" name = \"cause_sub\" id = \"cause_sub\" value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\"/>\n\t\t\t\t\t<input type = \"hidden\" name = \"severity\" id = \"severity\" value=\"\"/> <!-- this value is not used in the EJB RecordAdverseEventManager. Specifying it here inorder to maintain consistency -->\n\t\t\t\t\t<input type = \"hidden\" name = \"route_exp\" id = \"route_exp\" value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\"/>\n\t\t\t\t\t<input type = \"hidden\" name = \"allergy_test_res\" id = \"allergy_test_res\" value=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\"/>\n\t\t\t\t\t<input type = \"hidden\" name = \"drug_code\" id = \"drug_code\" value=\"\"/><!-- Site_Of_Reac is always passed as empty in MODIFY-->\n\t\t\t\t\t<input type = \"hidden\" name = \"chkreact1\" id = \"chkreact1\" value=\"N\"/><!-- chkreact1 is always passed as \"N\" in MODIFY but this value is not used in the EJB RecordAdverseEventManager -->\n\t\t\t\t\t<input type = \"hidden\" name = \"reaction_date\" id = \"reaction_date\" value=\"\"/><!-- reaction_date is passed with some date in MODIFY but this value is not used in the EJB RecordAdverseEventManager -->\n\t\t\t\t\t<input type = \"hidden\" name = \"certainity\" id = \"certainity\" value=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\"/>\n\t\t\t\t\t\n\t\t\t\t\t<input type = \"hidden\" name = \"today\" id = \"today\" value=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\"/>\n\t\t\t\t\t<input type = \"hidden\" name = \"patientDOB\" id = \"patientDOB\" value=\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\"/>\n\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\t<input type = \"hidden\" name = \"hdnReactionsToAdd\" id = \"hdnReactionsToAdd\" value=\"\"/>\n\t\t\t\t\t<input type = \"hidden\" name = \"hdnErrorReactions\" id = \"hdnErrorReactions\" value=\"\"/>\n\t\t\t\t\t<input type = \"hidden\" name = \"hdnPath\" id = \"hdnPath\" value = \"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\" />\n\t\t\t\t\t";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\t\t\t\n\t\t\t\t\t<div class=\"AllergyErrorResponse\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\t\t\t\t\t\t<div class=\"WidgetErrorResponse\">";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="</div>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n\t\t\t\t\t</div>\n\t\t\t";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\n\n\t\t\t\t</div><!-- first child of the scroller control -->\n\t\t\t\t<!-- Mandatory fields error -->\n\t\t\t\t<div class=\"formValErrorTheme formValError\" id=\"MandatoryFields_Error\" style=\"bottom: 0px; left: 0px;display:none\">\n\t\t\t  \t \t<div class=\"formValErrorMsgTheme\" id=\"MandatoryFields_ErrorMsg\">All mandatory fields must be entered</div>\n\t\t\t  \t </div>\n\t\t\t  \t <div class=\"formValWarningTheme formValError\" id=\"AllReactionsErrorMarked_Error\" style=\"bottom: 0px; left: 0px;display:none\">\n\t\t\t  \t \t<div class=\"formValErrorMsgTheme\" id=\"MandatoryFields_ErrorMsg\">All reactions cannot be marked as error</div>\n\t\t\t  \t </div>\n\t\t\t</div><!-- scrolling div ends -->\n\n\t\t</form>\n\t</div>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block3Bytes, _wl_block3);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block0Bytes, _wl_block0);

Locale appLocale;
if(session.getAttribute("LOCALE")!=null && !session.getAttribute("LOCALE").equals(""))
	appLocale = new Locale((String)session.getAttribute("LOCALE"));
else 
	appLocale = new Locale("en");
ResourceBundle csResBundle = ResourceBundle.getBundle("eIPAD.chartsummary.common.resourcebundle.cslabels", appLocale); 

            _bw.write(_wl_block3Bytes, _wl_block3);


String patientDOB="";
PatContext patContext= (PatContext)session.getAttribute("PatientContext");
if(patContext!=null){
	patientDOB = patContext.getDob();
}

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
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block16Bytes, _wl_block16);

AllergyResponse allergyResponse = (AllergyResponse)request.getAttribute("AllergyResponse");
boolean isSuccessResponse = allergyResponse.isSuccessResponse();
boolean isEmptyResponse = false;
ArrayList<ErrorInfo> errorList = new ArrayList<ErrorInfo>();
List<Allergy> allergyList = new ArrayList<Allergy>();
List<Reaction> reactionList = new ArrayList<Reaction>();
allergyList = allergyResponse.getAllergyDetails();
errorList = allergyResponse.getErrorsList();

//setting current date in dd/mm/yyyy hh:mm
java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm");
String today = dateFormat.format(new java.util.Date());
		
if(allergyList==null || allergyList.isEmpty())
	isEmptyResponse = true;

            _bw.write(_wl_block17Bytes, _wl_block17);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block20Bytes, _wl_block20);
 if(isSuccessResponse && !isEmptyResponse) {
							Allergy currentAllergy = allergyList.get(0);
							
							String estimatedDurationYN = currentAllergy.isEstimatedDuration()?"Y":"N";
					
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(currentAllergy.getReactions().size()));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(currentAllergy.getAllergenCode()));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(currentAllergy.getAllergyEventDesc() ));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(currentAllergy.getAllergenDesc() ));
            _bw.write(_wl_block26Bytes, _wl_block26);
if(currentAllergy.isEstimatedDuration()) {
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block28Bytes, _wl_block28);
} 
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(currentAllergy.getOnsetDate() ));
            _bw.write(_wl_block30Bytes, _wl_block30);
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(csResBundle.getString("allergy.enterReaction")));
            _bw.write(_wl_block32Bytes, _wl_block32);
 StringBuffer reactionCodesSB = new StringBuffer();
            _bw.write(_wl_block33Bytes, _wl_block33);
 reactionList = currentAllergy.getReactions();
							if(reactionList != null && !reactionList.isEmpty())
							{
						
            _bw.write(_wl_block34Bytes, _wl_block34);

								for(int j=0; j<reactionList.size(); j++){
									Reaction currentReaction = reactionList.get(j);		
									reactionCodesSB.append(currentReaction.getReactionCode() + "`");
							
            _bw.write(_wl_block35Bytes, _wl_block35);

										if(currentReaction.getSevereityDesc().equals("M") ){
            _bw.write(_wl_block36Bytes, _wl_block36);

										}
										else if(currentReaction.getSevereityDesc().equals("O")){
										
            _bw.write(_wl_block37Bytes, _wl_block37);

										}
										else if(currentReaction.getSevereityDesc().equals("S")){
										
            _bw.write(_wl_block38Bytes, _wl_block38);

										} 
										else{
										
            _bw.write(_wl_block39Bytes, _wl_block39);

										} 
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(csResBundle.getString("allergy.severity") ));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(currentReaction.getReactionDesc() ));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(currentReaction.getReactionSite() ));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(currentReaction.getReactionDate() ));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(j));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(j));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(j));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(j));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(currentReaction.getReactionCode()));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(j));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(j));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(currentReaction.getReactionDesc()));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(j));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(j));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(currentReaction.getReactionSerNo()));
            _bw.write(_wl_block53Bytes, _wl_block53);
 } 
            _bw.write(_wl_block54Bytes, _wl_block54);
 		
							} 
							
							String reactioncodes = reactionCodesSB.substring(0, (reactionCodesSB.length()-1));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(reactioncodes));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(currentAllergy.getAllergyEventTypeInd()));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(currentAllergy.getAllergyEventCode()));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(currentAllergy.getAllergyEventDesc()));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(currentAllergy.getAllergenCode()));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(estimatedDurationYN));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(currentAllergy.getOnsetDate()));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(currentAllergy.getActiveDate()));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(currentAllergy.getCertainity()));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(currentAllergy.getAllergyStatus()));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(currentAllergy.getDiagnosisCode()));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(currentAllergy.getRemarks()));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(currentAllergy.getInformationSource()));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(currentAllergy.getTreatmentAdvice()));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(currentAllergy.getCausativeSubstance()));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(currentAllergy.getRouteOfExposure()));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(currentAllergy.getAllergyTestResult()));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(currentAllergy.getCertainity()));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(today));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(patientDOB));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block76Bytes, _wl_block76);
}
					else{
            _bw.write(_wl_block77Bytes, _wl_block77);

						for(int k=0;k<errorList.size();k++){
						
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf( errorList.get(k).getErrorMessage()));
            _bw.write(_wl_block79Bytes, _wl_block79);
} 
            _bw.write(_wl_block80Bytes, _wl_block80);
} 
            _bw.write(_wl_block81Bytes, _wl_block81);
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
