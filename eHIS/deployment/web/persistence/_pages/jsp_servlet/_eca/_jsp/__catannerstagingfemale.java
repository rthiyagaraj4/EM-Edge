package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __catannerstagingfemale extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/CATannerStagingFemale.jsp", 1709115634825L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html xmlns=\"http://www.w3.org/1999/xhtml\">\n\t<head>\n\t\t<link rel=\'StyleSheet\' href=\'../html/CATannerStaging.css\' type=\'text/css\'>\n\t\t<script language=\'javascript\' src=\'../js/CATannerStaging.js\'></script>\n\t\t<script language=\'javascript\' src=\'../js/json2.js\'></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\t\n\t</head>\n\t<style>\n\t.Em_Col_header01\n\t{\n\t\tbackground-color:#eeeeee;\n\t\theight:110px;\n\t\tborder-bottom:1px solid #d9d8d8;\n\t\ttext-align:center;\n\t\tfont-weight:bold;\n\t\tcolor:#0c6780;\n\t}\n\t.Em_Col_header02\n\t{\n\t\tbackground-color:#e7e7e7;\n\t\theight:110px;\n\t\tborder-bottom:1px solid #d9d8d8;\n\t\ttext-align:center;\n\t\tfont-weight:bold;\n\t\tcolor:#0c6780;\n\t}\n\t.Em_Cell\n\t{\n\t\theight:110px;\n\t\tborder-bottom:1px solid #d9d8d8;\n\t\tborder-right:1px solid #98b9c2;\n\t}\n\t.Em_Cell01\n\t{\n\t\theight:110px;\n\t\tborder-bottom:1px solid #d9d8d8;\n\t}\n\t.Em_box\n\t{\n\theight:80px;\n\tbackground-color:#f4f9fa;\n\tborder-radius:3px;\n\tmargin:10px;\n\tpadding:5px;\n\t}\n\n\t.Em_box_Select\n\t{\n\theight:80px;\n\tbackground-color:#98b9c2;\n\tborder-radius:3px;\n\tmargin:10px;\n\tpadding:5px;\n\t}\n\t</style>\n\t<body class=\'CONTENT\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\t\t<form name=\'TannerStagingForm\' id=\'TannerStagingForm\' method =\'post\' target=\'messageFrame\' action=\'../../servlet/eCA.TannerStagingServlet\'>\t\t\n\t\t\t<div class=\"Em_Body_container\">\n\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td width=\"10%\" align=\"left\" valign=\"top\">\n\t\t\t\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t\t\t\t\t\t\t  <tr>\n\t\t\t\t\t\t\t\t<td align=\"left\" valign=\"middle\" class=\"Em_header\">Stages of puberty</td>\n\t\t\t\t\t\t\t  </tr>\n\t\t\t\t\t\t\t  <tr>\n\t\t\t\t\t\t\t\t<td align=\"left\" valign=\"middle\" class=\"Em_Col_header01\">Stage 01</td>\n\t\t\t\t\t\t\t  </tr>\n\t\t\t\t\t\t\t  <tr>\n\t\t\t\t\t\t\t\t<td align=\"left\" valign=\"middle\" class=\"Em_Col_header02\">Stage 02</td>\n\t\t\t\t\t\t\t  </tr>\n\t\t\t\t\t\t\t  <tr>\n\t\t\t\t\t\t\t\t<td align=\"left\" valign=\"middle\" class=\"Em_Col_header01\">Stage 03</td>\n\t\t\t\t\t\t\t  </tr>\n\t\t\t\t\t\t\t  <tr>\n\t\t\t\t\t\t\t\t<td align=\"left\" valign=\"middle\" class=\"Em_Col_header02\">Stage 04</td>\n\t\t\t\t\t\t\t  </tr>\n\t\t\t\t\t\t\t  <tr>\n\t\t\t\t\t\t\t\t<td align=\"left\" valign=\"middle\" class=\"Em_Col_header01\">Stage 05</td>\n\t\t\t\t\t\t\t  </tr>\n\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td align=\"left\" valign=\"top\">\n\t\t\t\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td width=\"50%\" align=\"left\" valign=\"middle\" class=\"Em_header\">";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</td>\n\t\t\t\t\t\t\t\t\t<td width=\"50%\" align=\"left\" valign=\"middle\" class=\"Em_header\">";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td align=\"left\" valign=\"top\" class=\"Em_Cell\">\n\t\t\t\t\t\t\t\t\t\t<div id=\"SP1\" class=\"Em_box\"  onClick=\"selectTannerStaging(\'SP\',\'1\');\">\n\t\t\t\t\t\t\t\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t\t\t\t\t\t\t\t\t\t\t\t<tr class=\"Em_box_H\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"30%\" align=\"center\" valign=\"top\" bgcolor=\"#FFFFFF\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"../../eCA/images/G_B_Satge01.PNG\" width=\"144\" height=\"80\" />\n\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\" valign=\"top\" class=\"Em_box_Dis\">Prepubertal</td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"5%\" align=\"center\" id=\"SP10\" valign=\"bottom\">&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td align=\"left\" valign=\"top\" class=\"Em_Cell01\">\n\t\t\t\t\t\t\t\t\t\t<div id=\"PH1\" class=\"Em_box\"  onClick=\"selectTannerStaging(\'PH\',\'1\');\">\n\t\t\t\t\t\t\t\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t\t\t\t\t\t\t\t\t\t\t\t<tr class=\"Em_box_H\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"30%\" align=\"center\" valign=\"top\" bgcolor=\"#FFFFFF\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"../../eCA/images/G_H_Satge01.PNG\" width=\"144\" height=\"80\" />\n\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\" valign=\"top\" class=\"Em_box_Dis\">Pre-adolescent. The vellus over the pubes is not further developed than that over the abdominal wall, i.e. no pubic hair.</td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"5%\" align=\"center\" id=\"PH10\" valign=\"bottom\">&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td align=\"left\" valign=\"top\" class=\"Em_Cell\">\n\t\t\t\t\t\t\t\t\t\t<div id=\"SP2\" class=\"Em_box\"   onClick=\"selectTannerStaging(\'SP\',\'2\');\">\n\t\t\t\t\t\t\t\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t\t\t\t\t\t\t\t\t\t\t\t<tr class=\"Em_box_H\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"30%\" align=\"center\" valign=\"top\" bgcolor=\"#FFFFFF\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"../../eCA/images/G_B_Satge02.PNG\" width=\"144\" height=\"80\" />\n\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\" valign=\"top\" class=\"Em_box_Dis\">Elevation of breasts and papilla</td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"5%\" align=\"center\" id=\"SP20\" valign=\"bottom\">&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td align=\"left\" valign=\"top\" class=\"Em_Cell01\">\n\t\t\t\t\t\t\t\t\t\t<div id=\"PH2\" class=\"Em_box\"   onClick=\"selectTannerStaging(\'PH\',\'2\');\">\n\t\t\t\t\t\t\t\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t\t\t\t\t\t\t\t\t\t\t\t<tr class=\"Em_box_H\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"30%\" align=\"center\" valign=\"top\" bgcolor=\"#FFFFFF\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"../../eCA/images/G_H_Satge02.PNG\" width=\"144\" height=\"80\" />\n\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\" valign=\"top\" class=\"Em_box_Dis\">Sparse growth of long, slightly pigmented downy hair, straight or slightly curled, chiefly along labia.</td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"5%\" align=\"center\" id=\"PH20\" valign=\"bottom\">&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td align=\"left\" valign=\"top\" class=\"Em_Cell\">\n\t\t\t\t\t\t\t\t\t\t<div id=\"SP3\" class=\"Em_box\"  onClick=\"selectTannerStaging(\'SP\',\'3\');\">\n\t\t\t\t\t\t\t\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t\t\t\t\t\t\t\t\t\t\t\t<tr class=\"Em_box_H\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"30%\" align=\"center\" valign=\"top\" bgcolor=\"#FFFFFF\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"../../eCA/images/G_B_Satge03.PNG\" width=\"144\" height=\"80\" />\n\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\" valign=\"top\" class=\"Em_box_Dis\">Further elevation and areola but no separation of contours</td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"5%\" align=\"center\" id=\"SP30\" valign=\"bottom\">&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td align=\"left\" valign=\"top\" class=\"Em_Cell01\">\n\t\t\t\t\t\t\t\t\t\t<div id=\"PH3\" class=\"Em_box\"  onClick=\"selectTannerStaging(\'PH\',\'3\');\">\n\t\t\t\t\t\t\t\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t\t\t\t\t\t\t\t\t\t\t\t<tr class=\"Em_box_H\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"30%\" align=\"center\" valign=\"top\" bgcolor=\"#FFFFFF\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"../../eCA/images/G_H_Satge03.PNG\" width=\"144\" height=\"80\" />\n\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\" valign=\"top\" class=\"Em_box_Dis\">Considerably darker, coarser and more curled. The hair spreads sparsely over the junction of the pubes.</td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"5%\" align=\"center\" id=\"PH30\" valign=\"bottom\">&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td align=\"left\" valign=\"top\" class=\"Em_Cell\">\n\t\t\t\t\t\t\t\t\t\t<div id=\"SP4\" class=\"Em_box\"  onClick=\"selectTannerStaging(\'SP\',\'4\');\">\n\t\t\t\t\t\t\t\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t\t\t\t\t\t\t\t\t\t\t\t<tr class=\"Em_box_H\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"30%\" align=\"center\" valign=\"top\" bgcolor=\"#FFFFFF\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"../../eCA/images/G_B_Satge04.PNG\" width=\"144\" height=\"80\" />\n\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\" valign=\"top\" class=\"Em_box_Dis\">Areola and papilla form a secondary mound above level of the breast</td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"5%\" align=\"center\" id=\"SP40\" valign=\"bottom\">&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td align=\"left\" valign=\"top\" class=\"Em_Cell01\">\n\t\t\t\t\t\t\t\t\t\t<div id=\"PH4\" class=\"Em_box\"  onClick=\"selectTannerStaging(\'PH\',\'4\');\">\n\t\t\t\t\t\t\t\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t\t\t\t\t\t\t\t\t\t\t\t<tr class=\"Em_box_H\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"30%\" align=\"center\" valign=\"top\" bgcolor=\"#FFFFFF\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"../../eCA/images/G_H_Satge04.PNG\" width=\"144\" height=\"80\" />\n\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\" valign=\"top\" class=\"Em_box_Dis\">Hair now adult in type, but area covered is still considerably smaller than in the adult. No spread to the medial surface of thighs.</td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"5%\" align=\"center\" id=\"PH40\" valign=\"bottom\">&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td width=\"50%\" align=\"left\" valign=\"top\" class=\"Em_Cell\">\n\t\t\t\t\t\t\t\t\t\t<div id=\"SP5\" class=\"Em_box\"  onClick=\"selectTannerStaging(\'SP\',\'5\');\">\n\t\t\t\t\t\t\t\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t\t\t\t\t\t\t\t\t\t\t\t<tr class=\"Em_box_H\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"30%\" align=\"center\" valign=\"top\" bgcolor=\"#FFFFFF\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"../../eCA/images/G_B_Satge05.PNG\" width=\"144\" height=\"80\" />\n\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\" valign=\"top\" class=\"Em_box_Dis\">Areola recesses to the general contour of the breast</td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"5%\" align=\"center\" id=\"SP50\" valign=\"bottom\">&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td width=\"50%\" align=\"left\" valign=\"top\" class=\"Em_Cell01\">\n\t\t\t\t\t\t\t\t\t\t<div id=\"PH5\" class=\"Em_box\"  onClick=\"selectTannerStaging(\'PH\',\'5\');\">\n\t\t\t\t\t\t\t\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t\t\t\t\t\t\t\t\t\t\t\t<tr class=\"Em_box_H\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"30%\" align=\"center\" valign=\"top\" bgcolor=\"#FFFFFF\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"../../eCA/images/G_H_Satge05.PNG\" width=\"144\" height=\"80\" />\n\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\" valign=\"top\" class=\"Em_box_Dis\">Adult in quantity and type with distribution of the horizontal (or classically \'feminine\') pattern. Spread to medial surface of thighs but not up linea alba or elsewhere above the base of the inverse triangle (spread up linea alba  occurs late and is rated stage 6).</td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"5%\" align=\"center\" id=\"PH50\" valign=\"bottom\">&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t</div>\n\t\t\t<input type=\"hidden\" name=\"patientId\" id=\"patientId\" value=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\"/>\n\t\t\t<input type=\"hidden\" name=\"encounterId\" id=\"encounterId\" value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\"/>\n\t\t\t<input type=\"hidden\" name=\"recordedScoreYN\" id=\"recordedScoreYN\" value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\"/>\n\t\t\t<input type=\"hidden\" name=\"stageOfPuberty\" id=\"stageOfPuberty\" value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\"/>\n\t\t\t<input type=\"hidden\" name=\"pubicHair\" id=\"pubicHair\" value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\"/>\n\t\t\t<input type=\"hidden\" name=\"isAuditYN\" id=\"isAuditYN\" value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\"/><!--IN067402-->\n\t\t\t<SCRIPT>\n\t\t\tif(\'Y\'==\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'){\n\t\t\t\tif(\'N\'==\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'){//IN067402\n\t\t\t\t\tparent.TannerStagingButtonFrame.document.TannerStagingButtonForm.record.disabled=\"disabled\";\n\t\t\t\t\tparent.TannerStagingButtonFrame.document.TannerStagingButtonForm.print.disabled=\"\";\n\t\t\t\t}//IN067402\t\n\t\t\t//IN067402 starts\t\n\t\t\t\t//selectTannerStaging(\'SP\',\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\',\'D\');\n\t\t\t\t//selectTannerStaging(\'PH\',\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\',\'D\');\n\t\t\t\tdisplayRecordedDetails(\'SP\',\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\',\'D\');//IN067402--Method name alone changed to control click in audit trail\n\t\t\t\tdisplayRecordedDetails(\'PH\',\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\',\'D\');//IN067402--Method name alone changed to control click in audit trail\t\n\t\t\t//IN067402 ends\t\n\t\t\t}else{\n\t\t\t\tparent.TannerStagingButtonFrame.document.TannerStagingButtonForm.record.disabled=\"\";\n\t\t\t\tparent.TannerStagingButtonFrame.document.TannerStagingButtonForm.print.disabled=\"disabled\";\n\t\t\t}\n\t\t\t</SCRIPT>\n\t\t</form>\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

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

/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History     Name      			Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
11/05/2018	IN063838		Ramesh G											ML-MMOH-CRF-0813
23/10/2018	IN067402		Prakash				10/09/2018		Ramesh Goli		ML-MMOH-CRF-0813.1
---------------------------------------------------------------------------------------------------------------------------------------------------------
*/ 

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block2Bytes, _wl_block2);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
String encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
String recordedScoreYN = request.getParameter("recordedScoreYN")==null?"":request.getParameter("recordedScoreYN");
String stageOfPuberty = request.getParameter("stageOfPuberty")==null?"":request.getParameter("stageOfPuberty");
String pubicHair = request.getParameter("pubicHair")==null?"":request.getParameter("pubicHair");
String isAuditYN = request.getParameter("isAuditYN")==null?"N":request.getParameter("isAuditYN");//IN067402

            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(recordedScoreYN));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(stageOfPuberty));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(pubicHair));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(isAuditYN));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(recordedScoreYN));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(isAuditYN));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(stageOfPuberty));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(pubicHair));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(stageOfPuberty));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(pubicHair));
            _bw.write(_wl_block20Bytes, _wl_block20);
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
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.BreastDevelopment.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag1(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag1 = null ;
        int __result__tag1 = 0 ;

        if (__tag1 == null ){
            __tag1 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag1);
        }
        __tag1.setPageContext(pageContext);
        __tag1.setParent(null);
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.PubicHair.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag1;
        __result__tag1 = __tag1.doStartTag();

        if (__result__tag1!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag1== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag1.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag1);
            return true;
        }
        _activeTag=__tag1.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag1);
        __tag1.release();
        return false;
    }
}
