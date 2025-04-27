package jsp_servlet._eoh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.*;
import webbeans.eCommon.ConnectionManager;
import eOH.Common.*;
import eOH.*;
import eCommon.Common.CommonBean;
import java.util.*;
import com.ehis.util.*;

public final class __ohdentalchart extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoh/jsp/OHDentalChart.jsp", 1709119347536L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOH/jsp/StringUtil.jsp", 1724302706763L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n\t<script language=\"javascript\" src=\"../../eOH/js/OHCommon.js\"></script>\n\t<script src=\"../../eOH/js/OHDentalChart.js\" language=\"javascript\"></script>\n\t<script src=\"../../eOH/js/FillImages.js\" language=\"javascript\"></script>\n\t<script src=\"../../eOH/js/DrawShapes.js\" language=\"javascript\"></script>\n\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n\t<script src=\"../../eOH/js/GetImages.js\" language=\"javascript\"></script>\n\t<script src=\"../../eOH/js/Rules.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\'/>\n\t\n\t<style>\n\t\t\n\t\tTABLE{\n\t\t\t\tBACKGROUND-COLOR:#CACEF9;\n\t\t}\n\t\tTD{\n\t\t\t\tBACKGROUND-COLOR:white;\n\t\t\t\tborder-color:#999999\n\t\t}\n\t\tTD.OTHER{\n\t\t\t\tBACKGROUND-COLOR:#D7E6F9;\n\t\t\t\tCOLOR:navy;\n\t\t\t\tFONT-SIZE: 8pt;\n\t\t\t\tTEXT-ALIGN: LEFT;\n\t\t\t\t\n\t\t}\n\t\tTD.ARCH{\n\t\t\t\tBACKGROUND-COLOR:#99ddee;\n\t\t\t\tCOLOR:navy;\n\t\t\t\tFONT-SIZE: 8pt;\n\t\t\t\tTEXT-ALIGN: LEFT;\n\t\t\t\t\n\t\t}\n\t\tTD.QUADRANT{\n\t\t\t\tBACKGROUND-COLOR:#CCECFF;\n\t\t\t\tCOLOR:navy;\n\t\t\t\tFONT-SIZE: 8pt;\n\t\t\t\tTEXT-ALIGN: LEFT;\n\t\t}\n\n\t\t#menu, #menu ul {list-style:none;\tpadding:0;\tmargin:0;}\n\t\t#menu li {\tfloat:left;\tposition:relative;\tline-height: 4.5em;\twidth: 10em;}\n\n\t\t#menu li ul {\tposition:absolute;\tmargin-top:-1em;\tmargin-left:.5em;\tdisplay:none;}\n\t\t#menu ul li ul {\tmargin-top:-3em;\tmargin-left:7em;}\n\n\t\t#menu a {\tdisplay:block;\tborder-right:1px solid #fff;\tbackground:#E0F574;\tcolor:#3B3B3B;\ttext-decoration:none;\tpadding:0 10px;}\n\t\t#menu a:hover {\tbackground-color:#5798B4;\tcolor:#fff;}\n\t\t#menu ul {\tborder-top:1px solid #fff;}\n\t\t#menu ul a {\tborder-right:none;\tborder-right:1px solid #fff;\tborder-bottom:1px solid #fff;\tborder-left:1px solid #fff;\tbackground:#AEC245;}\n\n\t\t/* SHOW SUBMENU 1 */#menu li:hover ul, #menu li.over ul {\tdisplay:block;}\n\t\t#menu li:hover ul ul, #menu li.over ul ul {\tdisplay:none;}\n\t\t/* SHOW SUBMENU 2 */#menu ul li:hover ul, #menu ul li.over ul {\tdisplay:block;}\n\n\t</style>\n\n\t<!--[if IE]><style type=\"text/css\">\t#menu li {\t\tposition:static;\t}</style><![endif]-->\n\n\n\n</head>\n <body OnMouseDown=\'CodeArrest()\' onKeyDown=\"lockKey()\" onMouseOver=\'hideMenuOnOutFocus()\'> \n<!-- <body OnMouseDown=\'CodeArrest()\' onKeyDown=\"lockKey()\"> -->\n<form name=\"dentalChartMainForm\" id=\"dentalChartMainForm\">\n<!-- This is the hidden field which will hold the value of the tooth that is currently clicked on this field is set with the value by showMenu() function that is present in menu.js -->\n<input type=\'hidden\' name=\'teethClickedOn\' id=\'teethClickedOn\' value=\'\'>\n <table width=\"99%\" border=\"0\" cellspacing=\"1\" cellpadding=\"0\" align=\"left\" valign=\"top\">\n \n\t<tr>\n\t\t <td ><table width=\"100%\" border=\"1\" cellspacing=\"0\" cellpadding=\"0\" >\n\t\t\t<tr>\n\t\t\t\t<!-- Commented by Sharon Crasta on 12/1/2008 for SCR #6755-->\n\t\t\t\t<!-- Added a <table> inside <td> so that the hand cursor can be applied to the whole td-->\n\t\t\t\t<!--<td width=\"33%\" class=\"QUADRANT\" style=\"text-align:left\" nowrap ><table border=0 width=\"100%\"><tr><td id=\"COLORQ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\" class=\"QUADRANT\" style=\"text-align:left\" nowrap ><input type=\"checkbox\" name=\"sel";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\" id=\"sel";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\" value=\"\" onclick=\"setCheckvalForQuad(this,\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\');\" onMouseOver = \"hideToolTip();\"/>&nbsp;<A onclick = \"onMouseClickFunctionArchQuad(\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\');\" onmouseover=\"this.style.color=\'blue\'\" onmouseout = \"this.style.color=\'\'\" style=\'cursor:pointer\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</A></td><td id=\"Q";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" class=\"QUADRANT\" style=\"text-align:left\" nowrap ><a onclick=\"getDialogFeaturesForNoImage(\'Q";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\',\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\',\'QUAD\');\" style=\'cursor:pointer\'>&nbsp;</a></td></tr></table></td>-->\n\n\t\t\t\t<td width=\"33%\" class=\"QUADRANT\" style=\"text-align:left\" nowrap ><table border=0 width=\"100%\"><tr><td id=\"COLORQ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" class=\"QUADRANT\" style=\"text-align:left\" nowrap ><table border=\"0\"  width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" onMouseOver=\'hideToolTip();\' onclick=\"getDialogFeaturesForNoImage(\'Q";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\',\'QUAD\');\" style=\'cursor:pointer\'><tr><td class=\"QUADRANT\"  width=\"100%\"><img src=\"../../eOH/images/spacer.gif\" height=\"16.5\" width=\"18\">&nbsp;</td></tr></table></td></tr></table></td>\n\t\t\t   <!-- Commented by Sharon Crasta on 12/1/2008 for SCR #6755-->\n\t\t\t\t<!-- Added a <table> inside <td> so that the hand cursor can be applied to the whole td-->\n\t\t\t\t<!--<td width=\"33%\" class=\"ARCH\" style=\"text-align:center\" nowrap ><table border=0 width=\"100%\"><tr><td id=\"COLORAU\" class=\"ARCH\" style=\"text-align:left\" nowrap ><input type=\"checkbox\" name=\"selU\" id=\"selU\" value=\"\" onclick=\"setCheckvalForArch(this,\'U\')\" onMouseOver = \"hideToolTip();\"/>&nbsp;<A onclick = \"onMouseClickFunctionArchQuad(\'U\');\" onmouseover=\"this.style.color=\'blue\'\" onmouseout = \"this.style.color=\'\'\" style=\'cursor:pointer\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</A></td><td id=\"AU\" class=\"ARCH\" style=\"text-align:left\" nowrap><a onclick=\"getDialogFeaturesForNoImage(\'AU\',\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\',\'ARCH\');\" style=\'cursor:pointer\'>&nbsp;</a></td></tr></table></td>-->\n\n\t\t\t\t<td width=\"33%\" class=\"ARCH\" style=\"text-align:center\" nowrap ><table border=0 width=\"100%\"><tr><td id=\"COLORAU\" class=\"ARCH\" style=\"text-align:left\" nowrap ><input type=\"checkbox\" name=\"selU\" id=\"selU\" value=\"\" onclick=\"setCheckvalForArch(this,\'U\')\" onMouseOver = \"hideToolTip();\"/>&nbsp;<A onclick = \"onMouseClickFunctionArchQuad(\'U\');\" onmouseover=\"this.style.color=\'blue\'\" onmouseout = \"this.style.color=\'\'\" style=\'cursor:pointer\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</A></td><td id=\"AU\" class=\"ARCH\" style=\"text-align:left\" nowrap><table border=\"0\" width=\"100%\" cellspacing=\"0\" cellpadding=\"3\"  onMouseOver=\'hideToolTip();\' onclick=\"getDialogFeaturesForNoImage(\'AU\',\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\',\'ARCH\');\" style=\'cursor:pointer\'><tr><td class=\"ARCH\" width=\"100%\"><img src=\"../../eOH/images/spacer.gif\" height=\"16.5\" width=\"18\" >&nbsp</td></tr></table></td></tr></table></td>\n\t\t\t\t<!-- Commented by Sharon Crasta on 12/1/2008 for SCR #6755-->\n\t\t\t\t<!-- Added a <table> inside <td> so that the hand cursor can be applied to the whole td-->\n\t\t\t\t<!--<td width=\"33%\" class=\"QUADRANT\" style=\"text-align:right\" nowrap ><table border=0 width=\"100%\"><tr><td  id=\"COLORQ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\')\" onMouseOver = \"hideToolTip();\"/>&nbsp;<A onclick = \"onMouseClickFunctionArchQuad(\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" class=\"QUADRANT\" style=\"text-align:left\" nowrap><a onclick=\"getDialogFeaturesForNoImage(\'Q";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\',\'QUAD\');\" style=\'cursor:pointer\'>&nbsp;</a></td></tr></table></td>-->\n\n\t\t\t\t<td width=\"33%\" class=\"QUADRANT\" style=\"text-align:right\" nowrap ><table border=0 width=\"100%\"><tr><td  id=\"COLORQ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" class=\"QUADRANT\" style=\"text-align:left\" nowrap><table border=\"0\"  width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" onMouseOver=\'hideToolTip();\' onclick=\"getDialogFeaturesForNoImage(\'Q";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\',\'QUAD\');\" style=\'cursor:pointer\'><tr onMouseOver=\'hideToolTip();\'><td class=\"QUADRANT\" width=\"100%\"><img src=\"../../eOH/images/spacer.gif\" height=\"16.5\" width=\"18\">&nbsp;</td></tr></table></td></tr></table></td>\n\t\t\t</tr>\n\t\t</table></td>\n\t</tr>\n\t<tr>\n\t\t<td valign=\"top\"><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t\t\t<tr>\n\t\t\t\t<td valign=\"top\"><table  border=\"0\" cellpadding=\"1\" cellspacing=\"1\">\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\"><tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t\t\t</tr></table></td>\n\t\t\t\t\t</tr>\n\t\t\t\t</table></td>\n\t\t\t\t<td valign=\"top\"><table border=\"0\" cellpadding=\"1\" cellspacing=\"1\" >\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\"><tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t\t</tr></table></td>\n\t\t\t\t\t</tr>\n\t\t\t\t</table></td>\n\t\t\t</tr>\n\t\t</table></td>\n\t</tr>\n\n\t<tr>\n\t\t<td valign=\"top\"><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t\t\t<tr>\n\t\t\t\t<td valign=\"top\"><table border=\"0\" cellpadding=\"1\" cellspacing=\"1\">\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\"><tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t\t</tr></table></td>\n\t\t\t\t\t</tr>\n\t\t\t\t</table></td>\n\t\t\t</tr>\n\t\t</table></td>\n\t</tr>\n\t\t<tr>\n\t\t<td><table width=\"100%\" border=\"1\" cellspacing=\"0\" cellpadding=\"0\">\n\t\t\t<tr>\n\t\t\t    <!-- Commented by Sharon Crasta on 12/1/2008 for SCR #6755-->\n\t\t\t\t<!-- Added a <table> inside <td> so that the hand cursor can be applied to the whole td-->\n\t\t\t\t<!--<td width=\"33%\" class=\"QUADRANT\" style=\"text-align:left\" nowrap><table border=0 width=\"100%\"><tr><td id=\"COLORQ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" class=\"QUADRANT\" style=\"text-align:left\" nowrap><input type=\"checkbox\" name=\"sel";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\',\'QUAD\');\" style=\'cursor:pointer\'>&nbsp;</a></td></tr></table></td>-->\n\n\t\t\t\t<td width=\"33%\" class=\"QUADRANT\" style=\"text-align:left\" nowrap><table border=0 width=\"100%\"><tr><td id=\"COLORQ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" class=\"QUADRANT\" style=\"text-align:left\" nowrap><table border=\"0\" width=\"100%\" cellspacing=\"0\" cellpadding=\"3\"  onclick=\"getDialogFeaturesForNoImage(\'Q";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\',\'QUAD\');\" style=\'cursor:pointer\'><tr><td class=\"QUADRANT\" width=\"100%\"><img src=\"../../eOH/images/spacer.gif\" height=\"16.5\" width=\"18\">&nbsp;</td></tr></table></td></tr></table></td>\n\n\t\t\t\t<!-- Commented by Sharon Crasta on 12/1/2008 for SCR #6755-->\n\t\t\t\t<!-- Added a <table> inside <td> so that the hand cursor can be applied to the whole td-->\n\t\t\t\t<!--<td width=\"33%\" class=\"ARCH\" style=\"text-align:center\" nowrap><table border=0 width=\"100%\"><tr><td id=\"COLORAL\" class=\"ARCH\" style=\"text-align:left\" nowrap><input type=\"checkbox\" name=\"selL\" id=\"selL\" value=\"\" onclick=\"setCheckvalForArch(this,\'L\')\" onMouseOver = \"hideToolTip();\"/>&nbsp;<A onclick = \"onMouseClickFunctionArchQuad(\'L\');\" onmouseover=\"this.style.color=\'blue\'\" onmouseout = \"this.style.color=\'\'\" style=\'cursor:pointer\'>";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</A></td><td id=\"AL\" class=\"ARCH\" style=\"text-align:left\" nowrap><a onclick=\"getDialogFeaturesForNoImage(\'AL\',\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\',\'ARCH\');\" style=\'cursor:pointer\'>&nbsp;</a></td></tr></table></td>-->\n\n\t\t\t\t<td width=\"33%\" class=\"ARCH\" style=\"text-align:center\" nowrap><table border=0 width=\"100%\"><tr><td id=\"COLORAL\" class=\"ARCH\" style=\"text-align:left\" nowrap><input type=\"checkbox\" name=\"selL\" id=\"selL\" value=\"\" onclick=\"setCheckvalForArch(this,\'L\')\" onMouseOver = \"hideToolTip();\"/>&nbsp;<A onclick = \"onMouseClickFunctionArchQuad(\'L\');\" onmouseover=\"this.style.color=\'blue\'\" onmouseout = \"this.style.color=\'\'\" style=\'cursor:pointer\'>";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</A></td><td id=\"AL\" class=\"ARCH\" style=\"text-align:left\" nowrap><table border=\"0\" width=\"100%\" cellspacing=\"0\" cellpadding=\"3\"  onclick=\"getDialogFeaturesForNoImage(\'AL\',\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\',\'ARCH\');\" style=\'cursor:pointer\'><tr><td class=\"ARCH\" width=\"100%\"><img src=\"../../eOH/images/spacer.gif\" height=\"16.5\" width=\"18\">&nbsp;</td></tr></table></td></tr></table></td>\n\n\t\t\t\t<!-- Commented by Sharon Crasta on 12/1/2008 for SCR #6755-->\n\t\t\t\t<!-- Added a <table> inside <td> so that the hand cursor can be applied to the whole td-->\n\t\t\t\t<!--<td width=\"33%\" class=\"QUADRANT\" style=\"text-align:right\" nowrap><table border=0 width=\"100%\"><tr><td id=\"COLORQ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\',\'QUAD\');\" style=\'cursor:pointer\'>&nbsp;</a></td></tr></table></td>-->\n\n\t\t\t\t<td width=\"33%\" class=\"QUADRANT\" style=\"text-align:right\" nowrap><table border=0 width=\"100%\"><tr><td id=\"COLORQ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" class=\"QUADRANT\" style=\"text-align:left\" nowrap><table border=\"0\" width=\"100%\" cellspacing=\"0\" conellpadding=\"3\"  onclick=\"getDialogFeaturesForNoImage(\'Q";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\',\'QUAD\');\" style=\'cursor:pointer\'><tr><td class=\"QUADRANT\" width=\"100%\"><img src=\"../../eOH/images/spacer.gif\" height=\"16.5\" width=\"18\">&nbsp;</td></tr><table></td></tr></table></td>\n\n\t\t\t</tr>\n\t\t</table></td>\n\t</tr>\n</table>\n\n<!-- <input type=\"hidden\" name=\'patientAge\' id=\'patientAge\' value=";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 =" > -->\n<input type=\"hidden\" name=\'locale\' id=\'locale\' value=";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 =" >\n<input type=\"hidden\" name=\'patient_id\' id=\'patient_id\' value=";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 =" >\n<input type=\"hidden\" name=\'encounter_id\' id=\'encounter_id\' value=";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 =" >\n<input type=\"hidden\" name=\'facility_id\' id=\'facility_id\' value=";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 =" >\n<input type=\"hidden\" name=\'Treat_Locn_Type\' id=\'Treat_Locn_Type\' value=";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 =" >\n<input type=\"hidden\" name=\'patient_class\' id=\'patient_class\' value=";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 =" >\n<input type=\"hidden\" name=\'chart_type\' id=\'chart_type\' value=";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 =" >\n<input type=\"hidden\" name=\'chart_num\' id=\'chart_num\' value=";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 =" >\n<input type=\"hidden\" name=\'header_tab\' id=\'header_tab\' value=";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 =" >\n<input type=\"hidden\" name=\'show_new_active_yn\' id=\'show_new_active_yn\' value=";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 =" >\n<input type=\"hidden\" name=\'mixed_dentition_YN\' id=\'mixed_dentition_YN\' value=";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 =" >\n\n<input type = \"hidden\" name= \"episode_id\" value = \"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\">\n<input type = \"hidden\" name= \"episode_type\" value = \"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">\n<input type = \"hidden\" name= \"visit_id\" value = \"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\">\n<input type = \"hidden\" name= \"location_code\" value = \"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\">\n<input type = \"hidden\" name= \"location_type\" value = \"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\">\n<input type = \"hidden\" name= \"oh_chart_level\" value = \"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\">\n\n\n<input type=\"hidden\" name=\'tooth_numbering_system\' id=\'tooth_numbering_system\' value=";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 =" >\n<input type=\"hidden\" name=\'permanent_deciduous_flag\' id=\'permanent_deciduous_flag\' value=";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 =" >\n<input type=\"hidden\" name=\"chart_hdr_insert_yn\" id=\"chart_hdr_insert_yn\" value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\">\n<input type=\"hidden\" name=\"called_from_viewchart_yn\" id=\"called_from_viewchart_yn\" value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\">\n<input type=\"hidden\" name=\"date_diff_flag\" id=\"date_diff_flag\" value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\">\n<input type = \"hidden\" name= \"decith_yn\" value = \"\"> \n<input type = \"hidden\" name= \"ca_params\" value = \"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\"> \n\n<!-- These variables are used in the developing Menu -->\n<input type=\"hidden\" name=\"function_id_list\" id=\"function_id_list\" value=\"\">\t\t\n<input type=\"hidden\" name=\"function_name_list\" id=\"function_name_list\" value=\"\">\t\t\n<input type=\"hidden\" name=\"function_type_list\" id=\"function_type_list\" value=\"\">\n<input type=\"hidden\" name=\"function_type_desc_list\" id=\"function_type_desc_list\" value=\"\">\n<input type=\"hidden\" name=\"function_cat_code_list\" id=\"function_cat_code_list\" value=\"\">\n\n<!-- These variables are for disabling the check Boxes when not applicable -->\n<input type=\"hidden\" name=\"lower_arch_applicable_yn\" id=\"lower_arch_applicable_yn\" value=\"Y\">\n<input type=\"hidden\" name=\"upper_arch_applicable_yn\" id=\"upper_arch_applicable_yn\" value=\"Y\">\n\n<input type=\"hidden\" name=\"UR_quadrant_applicable_yn\" id=\"UR_quadrant_applicable_yn\" value=\"Y\">\n<input type=\"hidden\" name=\"UL_quadrant_applicable_yn\" id=\"UL_quadrant_applicable_yn\" value=\"Y\">\n<input type=\"hidden\" name=\"LR_quadrant_applicable_yn\" id=\"LR_quadrant_applicable_yn\" value=\"Y\">\n<input type=\"hidden\" name=\"LL_quadrant_applicable_yn\" id=\"LL_quadrant_applicable_yn\" value=\"Y\">\n\n<!-- This param is to clear \'selected_tooth_count\' for multi selection on Supernumenary tooth after form submission(after reset) -->\n<input type=\"hidden\" name=\"reset_done\" id=\"reset_done\" value=\"\">\n\n\n\n<!-- DentalChart Variables -->\n<input type=\"hidden\" name=\"upper_arch_desc\" id=\"upper_arch_desc\" value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\">\n<input type=\"hidden\" name=\"lower_arch_desc\" id=\"lower_arch_desc\" value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\">\n<input type=\"hidden\" name=\"Q1_id\" id=\"Q1_id\" value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\">\n<input type=\"hidden\" name=\"Q2_id\" id=\"Q2_id\" value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\">\n<input type=\"hidden\" name=\"Q3_id\" id=\"Q3_id\" value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\">\n<input type=\"hidden\" name=\"Q4_id\" id=\"Q4_id\" value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\">\n<input type=\"hidden\" name=\"Q1_desc\" id=\"Q1_desc\" value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\">\n<input type=\"hidden\" name=\"Q2_desc\" id=\"Q2_desc\" value=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\">\n<input type=\"hidden\" name=\"Q3_desc\" id=\"Q3_desc\" value=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\">\n<input type=\"hidden\" name=\"Q4_desc\" id=\"Q4_desc\" value=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\">\n\n\n\n<input type=\"hidden\" name=\"baseline_chart_yn\" id=\"baseline_chart_yn\" value=\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\">\n<input type=\"hidden\" name=\"chart_status_from_view\" id=\"chart_status_from_view\" value=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\">\n<!-- added by parul  for other facility chart CRF#0423 -->\n<input type=\"hidden\" name=\"other_facilitychart_yn\" id=\"other_facilitychart_yn\" value=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\">\n<input type=\"hidden\" name=\"other_chart_facility_id\" id=\"other_chart_facility_id\" value=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\">\n<!-- Added by Sharon Crasta on 1/11/2010 for IN017822  -->\n<input type = \"hidden\" name= \"chart_disable_from_main\" value = \"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\">\n<!-- -->\n</form>\n\n<div name=\'tooltiplayer\' id=\'tooltiplayer\' style=\'position:absolute; width:20%; visibility:hidden;\' bgcolor=\'blue\' >\n\t<table id=\'tooltiptable\' cellpadding=\"3\" cellspacing=0 border=\'0\' width=\'100%\' align=\'center\' >\n\t\t<tr id=\'tooltiprow\'>\n\t\t\t<!-- <td width=\'100%\' id=\'menu_table\' onMouseOver=\'hideMenuOnOutFocus()\'></td> -->\n\t\t\t<td width=\'100%\' id=\'menu_table\'></td>\n\t\t\t</td>\n\t\t</tr>\n\t</table>\n</div> \n\n <div name=\'tooltiplayer1\' id=\'tooltiplayer1\' style=\'position:absolute; width:20%; visibility:hidden;\' bgcolor=\'blue\' >\n\t<table id=\'tooltiptable1\' cellpadding=\"3\" cellspacing=0 border=\'0\' width=\'100%\' align=\'center\' >\n\t\t<tr id=\'tooltiprow1\'>\n\t\t\t<td width=\'100%\' id=\'menu_table1\'></td>\n\t\t\t</td>\n\t\t</tr>\n\t</table>\n</div> \n\n\t";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n\t<script>\n\t\tgetAllImagesFromDB();\n\t</script>\n\t";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\n</body>\n<!--Map for Teeth-->\n<map name=\"MapTUR1\" id=\"MapTUR1\">\n    <!--Deistal-->\n\t<area shape=\"poly\" coords=\"4,6,11,13,11,23,4,30\" href=\"#\" />\n\t<!--Labial/Buccal-->\n\t<area shape=\"poly\" coords=\"5,5,39,5,32,12,12,12\" href=\"#\" />\n\t<!--Palatal/Lingual-->\n\t<area shape=\"poly\" coords=\"5,31,12,24,32,24,39,31\" href=\"#\" />\n    <!--Mesial -->\n\t<area shape=\"poly\" coords=\"33,13,40,6,40,30,33,23\" href=\"#\" />\n\t<!--Mesio Occlusal-->\n\t<area shape=\"rect\" coords=\"13,14,22,23\" href=\"#\" />\n\t<!--Disto Occlusal-->\n\t<area shape=\"rect\" coords=\"23,14,32,23\" href=\"#\" />\n</map>\n\n<!--Map for Upper Right Top Row of Root -->\n\n<map name=\"MapRUR1\" id=\"MapRUR1\">\n\t<area shape=\"poly\"  coords=\"13,37,12,31,11,25,15,17,20,9,29,16,29,24,30,27,30,38,26,38,18,38\" href=\"R1\" />\n</map>\n\n<map name=\"MapRUR2\" id=\"MapRUR2\">\n\t<area shape=\"poly\" coords=\"17,14,20,15,17,21,17,31,20,33,20,38,14,39,12,35,12,27\" href=\"#\" />\n\t<area shape=\"poly\" coords=\"24,13,31,20,32,33,28,39,21,37,21,33,24,23\" href=\"#\" />\n</map>\n\n<map name=\"MapRUR3\" id=\"MapRUR3\">\n\t<area shape=\"poly\" coords=\"23,39,14,39,10,29,9,11,12,8,14,10,16,27,23,33\" href=\"#\" />\n\t<area shape=\"poly\" coords=\"17,12,21,8,24,13,26,18,28,21,28,26,24,30,19,24,18,21\" href=\"#\" />\n\t<area shape=\"poly\" coords=\"24,32,28,29,31,25,31,14,34,19,34,28,33,30,33,39,30,39,26,38,24,39\" href=\"#\" />\n</map>\n\n<map name=\"MapRUR4\" id=\"MapRUR4\">\n\t<area shape=\"poly\" coords=\"18,11,22,7,24,10,23,13,23,20,26,27,27,38,21,36,19,36,16,36,16,29,18,16\" href=\"#\" />\n</map>\n\n<map name=\"MapRUR5\" id=\"MapRUR5\">\n\t<area shape=\"poly\" coords=\"20,9,26,13,25,25,27,28,27,27,27,33,27,37,22,37,18,36,16,37,16,23\" href=\"#\" />\n</map>\n\n<map name=\"MapRUR6\" id=\"MapRUR6\">\n\t<area shape=\"poly\" coords=\"16,8,16,29,15,32,15,43,16,42,19,41,20,43,23,43,25,41,27,41,28,37,21,8,18,5\" href=\"#\" />\n</map>\n\n<map name=\"MapRUR7\" id=\"MapRUR7\">\n\t<area shape=\"poly\" coords=\"20,5,20,15,15,30,15,43,17,42,23,42,27,42,29,44,28,38,26,26,26,14,25,9\" href=\"#\" />\n</map>\n\n<map name=\"MapRUR8\" id=\"MapRUR8\">\n\t<area shape=\"poly\" coords=\"13,38,15,29,18,21,22,10,24,11,26,16,28,25,29,32,29,41,25,37,21,40,17,38\" href=\"#\" />\n</map>\n\n<!--Map for Upper Left Row of Root -->\n\n<map name=\"MapRUL9\" id=\"MapRUL9\">\n\t  <area shape=\"poly\" coords=\"13,40,14,28,17,18,19,10,22,10,26,22,28,30,29,34,30,40,25,39,22,40,18,39\" href=\"#\" />\n</map>\n\n<map name=\"MapRUL10\" id=\"MapRUL10\">\n\t  <area shape=\"poly\" coords=\"19,5,22,5,23,14,26,23,28,40,22,42,16,41,15,42,16,19,17,10\" href=\"#\" />\n</map>\n\n<map name=\"MapRUL11\" id=\"MapRUL11\">\n\t  <area shape=\"poly\" coords=\"13,44,18,24,20,11,26,4,28,5,28,28,29,35,30,42,28,44,26,41,21,43\" href=\"#\" />\n</map>\n<map name=\"MapRUL12\" id=\"MapRUL12\">\n\t  <area shape=\"poly\" coords=\"16,36,17,27,20,19,21,11,24,9,28,16,28,25,29,32,29,36,22,37\" href=\"#\" />\n</map>\n<map name=\"MapRUL13\" id=\"MapRUL13\">\n\t  <area shape=\"poly\" coords=\"15,37,15,28,19,19,18,8,24,8,27,20,27,28,28,32,27,37,25,37,23,38,19,38\" href=\"#\" />\n</map>\n<map name=\"MapRUL14\" id=\"MapRUL14\">\n\t  <area shape=\"poly\" coords=\"12,14,9,21,8,27,10,34,10,39,19,39\" href=\"#\" />\n\t  <area shape=\"poly\" coords=\"20,34,21,38,25,38,29,39,32,34,34,27,35,14,32,8,28,25\" href=\"#\" />\n\t  <area shape=\"poly\" coords=\"42,26\" href=\"#\" />\n\t  <area shape=\"poly\" coords=\"21,8,23,9,27,13,24,25,19,31,15,24,18,18,18,16,18,15\" href=\"#\" />\n</map>\n\n<map name=\"MapRUL15\" id=\"MapRUL15\">\n\t  <area shape=\"poly\" coords=\"15,37,12,31,13,19,19,13,22,13,21,24,23,30,25,32,23,35,20,37\" href=\"#\" />\n\t  <area shape=\"poly\" coords=\"22,9,29,20,28,27,26,33,23,36,28,39,32,35,32,26,28,14,25,10\" href=\"#\" />\n</map>\n\n<map name=\"MapRUL16\" id=\"MapRUL16\">\n      <area shape=\"poly\" coords=\"12,37,12,29,13,21,14,14,17,9,24,9,29,15,30,21,31,30,32,34,27,34,22,36,17,34\" href=\"#\" />\n</map>\n\n\n<!--Map for Lower Right Row of Root -->\n\n<map name=\"MapRLR32\" id=\"MapRLR32\">\n<area shape=\"poly\" coords=\"10,14,14,12,22,12,23,16,22,23,21,30,15,39,11,39,11,28,11,22\" href=\"#\" />\n<area shape=\"poly\" coords=\"16,40,23,33,22,29,25,15,26,10,26,9,32,9,32,26,29,31,18,40\" href=\"#\" />\n</map>\n\n<map name=\"MapRLR31\" id=\"MapRLR31\">\n<area shape=\"poly\" coords=\"12,40,15,40,20,26,20,16,24,14,24,7,18,8,12,9,11,12,11,28\" href=\"#\" />\n<area shape=\"poly\" coords=\"23,42,22,35,25,30,25,16,25,8,33,9,32,15,33,24,24,39\" href=\"#\" />\n</map>\n\n<map name=\"MapRLR30\" id=\"MapRLR30\">\n<area shape=\"poly\" coords=\"8,11\" href=\"#\" />\n<area shape=\"poly\" coords=\"9,11,15,12,22,11,22,15,12,38,8,39,9,26,8,25,8,15\" href=\"#\" />\n<area shape=\"poly\" coords=\"24,39,28,39,34,26,34,18,33,9,26,9,23,11,24,15\" href=\"#\" />\n</map>\n\n<map name=\"MapRLR29\" id=\"MapRLR29\">\n<area shape=\"poly\" coords=\"14,8,17,26,18,29,17,33,17,41,24,34,28,19,30,7,27,6,25,6,18,7\" href=\"#\" />\n</map>\n\n<map name=\"MapRLR28\" id=\"MapRLR28\">\n<area shape=\"poly\" coords=\"15,6,21,6,22,4,26,4,28,5,28,28,28,32,23,42,21,42,18,22,18,24,17,13\" href=\"#\" />\n</map>\n\n<map name=\"MapRLR27\" id=\"MapRLR27\">\n<area shape=\"poly\" coords=\"15,19,20,33,20,43,22,44,27,31,29,4,26,4,24,5,22,5,17,6\" href=\"#\" />\n</map>\n\n<map name=\"MapRLR26\" id=\"MapRLR26\">\n<area shape=\"poly\" coords=\"16,10,19,8,24,6,27,7,28,11,25,23,22,40,17,43,17,28\" href=\"#\" />\n</map>\n\n<map name=\"MapRLR25\" id=\"MapRLR25\">\n<area shape=\"poly\" coords=\"15,15,18,8,23,8,28,7,29,12,20,41,17,43,15,39,16,37,16,25\" href=\"#\" />\n</map>\n\n\n<!--Map for Lower Left Row of Root -->\n\n<map name=\"MapRLL24\" id=\"MapRLL24\">\n<area shape=\"poly\" coords=\"14,7,14,19,21,38,26,42,27,41,28,38,27,27,27,22,28,12,25,6,23,9,17,8\" href=\"#\" />\n</map>\n\n<map name=\"MapRLL23\" id=\"MapRLL23\">\n<area shape=\"poly\" coords=\"17,8,21,9,24,7,27,7,28,8,28,23,27,24,28,36,27,41,24,41,19,29,18,22,17,17,17,12\" href=\"#\" />\n</map>\n\n<map name=\"MapRLL22\" id=\"MapRLL22\">\n<area shape=\"poly\" coords=\"15,6,18,6,23,7,25,8,28,8,28,8,28,21,25,32,24,42,20,43,16,34,15,28\" href=\"#\" />\n</map>\n\n<map name=\"MapRLL21\" id=\"MapRLL21\">\n<area shape=\"poly\" coords=\"15,13,17,9,17,7,20,7,22,8,26,9,28,8,28,12,27,20,25,27,23,32,23,39,22,40,20,41,17,34,15,27,15,26\" href=\"#\" />\n</map>\n\n<map name=\"MapRLL20\" id=\"MapRLL20\">\n<area shape=\"poly\" coords=\"14,10,14,14,20,34,25,39,27,37,27,21,28,19,28,11,23,12,20,9\" href=\"#\" />\n</map>\n\n<map name=\"MapRLL19\" id=\"MapRLL19\">\n<area shape=\"poly\" coords=\"10,8,13,8,14,9,17,9,18,10,22,10,22,14,18,14,18,31,19,32,18,38,16,39,8,27,8,15\" href=\"#\" />\n<area shape=\"poly\" coords=\"22,10,22,15,25,19,26,27,31,38,35,39,35,32,35,28,34,12,32,11,32,10,25,10\" href=\"#\" />\n</map>\n\n<map name=\"MapRLL18\" id=\"MapRLL18\">\n<area shape=\"poly\" coords=\"10,8,16,8,18,7,19,6,21,10,23,10,23,14,19,15,18,27,22,36,22,39,19,40,11,24,11,14\" href=\"#\" />\n<area shape=\"poly\" coords=\"24,10,25,8,29,8,29,7,32,7,33,9,33,12,34,25,32,28,32,39,31,41,24,24,24,13\" href=\"#\" />\n</map>\n\n<map name=\"MapRLL17\" id=\"MapRLL17\">\n<area shape=\"poly\" coords=\"27,39\" href=\"#\" />\n<area shape=\"poly\" coords=\"27,39,17,33,11,24,10,19,10,8,16,8,18,9,19,11,21,11,20,17\" href=\"#\" />\n<area shape=\"poly\" coords=\"22,11,25,9,29,8,32,9,33,12,33,23,32,27,31,28,30,37,32,37,27,35,24,28,22,18\" href=\"#\" />\n</map>\n\n</html>\n";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );
 
// instead of using CommonBean.checkForNull use StringUtil.jsp  to filter null values
public String checkForNull(String str){
	return (str!=null && str.intern()!="null")?str:"";
}
public String checkForNull(String inputString,String defaultValue){
        return ( inputString == null || inputString.equals("") )    ?   defaultValue    :   inputString;
	}

public String format_decimal(Double gs_val, int no_of_decimal){
		 
		String gs_val_str = gs_val+"";
		String restrict_gs_val = gs_val_str;
		int index = gs_val_str.indexOf(".");
		int len = (gs_val_str.substring(index+1)).length();
		if(index != -1 && len>no_of_decimal){
			restrict_gs_val = gs_val_str.substring(0,index+no_of_decimal+1);
		}

		return restrict_gs_val;
	}


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", " text/html;charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType(" text/html;charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String locale = (String)session.getAttribute("LOCALE"); 
	request.setCharacterEncoding("UTF-8"); 

	String load_images_yn	= request.getParameter("load_images_yn");
	load_images_yn=checkForNull(load_images_yn,"Y");
	String tooth_numbering_system	= request.getParameter("tooth_numbering_system");
	String upper_arch_desc			= request.getParameter("upper_arch_desc");
	String lower_arch_desc			= request.getParameter("lower_arch_desc");
	String Q1_id					= request.getParameter("Q1_id");
	String Q2_id					= request.getParameter("Q2_id");
	String Q3_id					= request.getParameter("Q3_id");
	String Q4_id					= request.getParameter("Q4_id");
	String Q1_desc					= request.getParameter("Q1_desc");
	String Q2_desc					= request.getParameter("Q2_desc");
	String Q3_desc					= request.getParameter("Q3_desc");
	String Q4_desc					= request.getParameter("Q4_desc");
	String permanent_deciduous_flag = request.getParameter("permanent_deciduous_flag");
	String mixed_dentition_YN        = request.getParameter("mixed_dentition_YN");
	String date_diff_flag        = request.getParameter("date_diff_flag");
	
	String patient_id = request.getParameter( "patient_id" ) ;
	String encounter_id = request.getParameter( "encounter_id" ) ;
	String facility_id = (String)session.getValue("facility_id") ;
	String patient_class = request.getParameter("patient_class");
	String chart_type = request.getParameter( "chart_type" ) ;
	String header_tab = request.getParameter( "header_tab" ) ;
	String treat_Locn_Type = request.getParameter( "treat_Locn_Type" ) ;

	String episode_id = checkForNull(request.getParameter("episode_id")) ;
	String episode_type = checkForNull(request.getParameter("episode_type")) ;
	String visit_id = checkForNull(request.getParameter("visit_id")) ;
	String location_code = checkForNull(request.getParameter("location_code")) ;
	String location_type = checkForNull(request.getParameter("location_type")) ;
	
	String mode = checkForNull(request.getParameter("mode")) ;
	String other_facilitychart_yn = checkForNull(request.getParameter("other_facilitychart_yn")) ;//added by parul  for other facility chart CRF#0423
	String other_chart_facility_id = checkForNull(request.getParameter("other_chart_facility_id")) ;//added by parul  for other facility chart CRF#0423
	if(mode.equals("modify")){
		patient_id = request.getParameter( "patient_id_new" ) ;
	}
	Connection con=null;
	PreparedStatement pstmt=null;
	//Statement stmt=null;
	ResultSet rs=null;
	String sql = "";
	String tooth_num = "";
	String tooth_name ="";
	String tooth_sn = "";
	String mapped_tooth_string = "";
	int mapped_tooth_no = 0;
	//int i = 0;
	//int j = 1;
	int k = 1;
	int z = 0;

	String show_new_active_yn = checkForNull(request.getParameter("show_new_active_yn"));
	String chart_hdr_insert_yn = checkForNull(request.getParameter("chart_hdr_insert_yn"));
	String chart_num =checkForNull(request.getParameter("chart_num")) ;
	String called_from_viewchart_yn =checkForNull(request.getParameter("called_from_viewchart_yn")) ;
	String baseline_chart_yn =checkForNull(request.getParameter("baseline_chart_yn")) ;
	String chart_status_from_view =checkForNull(request.getParameter("chart_status_from_view")) ;
	String oh_chart_level =checkForNull(request.getParameter("oh_chart_level")) ;
	String add_new_yn =checkForNull(request.getParameter("add_new_yn")) ;
	String add_new_done_flag =checkForNull(request.getParameter("add_new_done_flag")) ;
	if(add_new_yn.equals("Y") || add_new_done_flag.equals("Y")){
	   other_chart_facility_id = facility_id;
	   other_facilitychart_yn = "";
	   date_diff_flag = "enable";
	   called_from_viewchart_yn = "N";
	}
	//Added by Sharon Crasta on 1/11/2010 for IN017822
	//Used to disable the chart once the APP-OH000153 message is displayed and on cancel.
	String chart_disable_from_main = checkForNull(request.getParameter( "chart_disable_from_main" )) ;
   	//End
	

            _bw.write(_wl_block1Bytes, _wl_block1);
	
	try{
		con = ConnectionManager.getConnection(request);

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(Q1_id));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(Q1_id));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(Q1_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(Q1_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(Q1_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(Q1_desc));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(Q1_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(Q1_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(Q1_desc));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(Q1_id));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(Q1_id));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(Q1_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(Q1_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(Q1_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(Q1_desc));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(Q1_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(Q1_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(Q1_desc));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(upper_arch_desc));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(upper_arch_desc));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(upper_arch_desc));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(upper_arch_desc));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(Q2_id));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(Q2_id));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(Q2_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(Q2_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(Q2_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(Q2_desc));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(Q2_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(Q2_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(Q2_desc));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(Q2_id));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(Q2_id));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(Q2_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(Q2_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(Q2_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(Q2_desc));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(Q2_id));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(Q2_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(Q2_desc));
            _bw.write(_wl_block26Bytes, _wl_block26);

							//LOGIC FOR DISPLAYING UPPER RIGHT QUADRANT OF DENTAL CHART
							if(rs != null) rs.close();
							if(pstmt != null) pstmt.close();
							//sql = "SELECT B.TOOTH_NO, B.TOOTH_NAME, DECODE(?,'UNI',B.UNIVERSAL_TOOTH_NO, B.FDI_TOOTH_NO) TOOTH_NUM, B.MAPPED_TOOTH_NO, B.PERMANENT_DECIDUOUS FROM OH_TOOTH  B WHERE B.PERMANENT_DECIDUOUS = ?";												
							//If additional Lang_vw object is added to the below query, make sure that the TOOTH_NAME qry from the TOOTH_LANG_VW is retrieved properly
							if(permanent_deciduous_flag.equals("D") && mixed_dentition_YN.equals("Y")){
								//sql = "SELECT B.TOOTH_NO, B.TOOTH_NAME, C.NS_TOOTH_NO TOOTH_NUM, B.MAPPED_TOOTH_NO, B.PERMANENT_DECIDUOUS FROM OH_TOOTH  B, OH_TOOTH_BY_NUMBERING_SYSTEM C WHERE B.TOOTH_NO = C.TOOTH_NO AND C.NUMBERING_SYSTEM = ? AND (B.PERMANENT_DECIDUOUS = ? OR MIXED_DENT_TOOTH_NO IS NOT NULL) ORDER BY MIXED_DENT_TOOTH_ORDER";
								sql = "SELECT B.TOOTH_NO, B.TOOTH_NAME, B.NS_TOOTH_NO TOOTH_NUM, B.MAPPED_TOOTH_NO, B.PERMANENT_DECIDUOUS FROM OH_TOOTH_LANG_VW  B WHERE B.LANGUAGE_ID = ? AND B.NUMBERING_SYSTEM = ? AND (B.PERMANENT_DECIDUOUS = ? OR MIXED_DENT_TOOTH_NO IS NOT NULL) ORDER BY MIXED_DENT_TOOTH_ORDER";
							}else{
								//sql = "SELECT B.TOOTH_NO, B.TOOTH_NAME, C.NS_TOOTH_NO TOOTH_NUM, B.MAPPED_TOOTH_NO, B.PERMANENT_DECIDUOUS FROM OH_TOOTH B, OH_TOOTH_BY_NUMBERING_SYSTEM C WHERE B.TOOTH_NO = C.TOOTH_NO AND C.NUMBERING_SYSTEM = ? AND B.PERMANENT_DECIDUOUS = ?";
								sql = "SELECT B.TOOTH_NO, B.TOOTH_NAME, B.NS_TOOTH_NO TOOTH_NUM, B.MAPPED_TOOTH_NO, B.PERMANENT_DECIDUOUS FROM OH_TOOTH_LANG_VW B WHERE B.LANGUAGE_ID = ? AND B.NUMBERING_SYSTEM = ? AND B.PERMANENT_DECIDUOUS = ?";
							}
							pstmt=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,	ResultSet.CONCUR_UPDATABLE);
							pstmt.setString(1,locale);
							pstmt.setString(2,tooth_numbering_system);
							pstmt.setString(3,permanent_deciduous_flag);
							rs=pstmt.executeQuery();
							k=1;
							//This is the count (only for deciduous tooth ) which goes on reducing as the teeths absent increases in the patient with age less than 6 / 5 
							z=32;
							while(rs.next()){
								if(k<=8){
									tooth_sn = rs.getString("TOOTH_NO");
									tooth_num = rs.getString("TOOTH_NUM");
									tooth_name = rs.getString("TOOTH_NAME");
									mapped_tooth_string = rs.getString("MAPPED_TOOTH_NO");
									if(mapped_tooth_string != null){
										mapped_tooth_no = Integer.parseInt(mapped_tooth_string);
									}
									
									if(permanent_deciduous_flag.equals("P")){
										if(mixed_dentition_YN.equals("Y")){
											if(k == 1){
												out.println("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

												out.println("<tr><td ><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");

												out.println("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='20'/></td></tr>");

												out.println("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr></table></td>");
											
											}
											else if(k!=1 && k<=3){
												out.println("<td id ='decith_table"+k+"' align='center'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='R"+k+ "' align='center'><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

												out.println("<tr><td id='T"+k+"' align='center'><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");

												out.println("<tr><td align='center' id='check_num"+tooth_sn+"'><A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" ></td></tr>");

												out.println("<tr onMouseOver='hideToolTip();'><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' onclick=\"getDialogFeaturesForNoImage('"+tooth_sn+"','"+tooth_num+"');\" style='cursor:pointer'>&nbsp;</td></tr></table></td></tr></table></td>");
											}
											else{
												out.println("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='R"+tooth_sn+ "' align='center' background-color='red'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R" + k + ".gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + k + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");
											
												out.println("<tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");

												out.println("<tr><td align='center' id='check_num"+tooth_sn+"'><A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" ></td></tr>");
											
												out.println("<tr onMouseOver='hideToolTip();'><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' onclick=\"getDialogFeaturesForNoImage('"+tooth_sn+"','"+tooth_num+"');\" style='cursor:pointer'>&nbsp;</td></tr></table></td></tr></table></td>");
											}
										}
										else if(mixed_dentition_YN.equals("N")){
											if(k == 1){ //Remove Images for 3rd Molars(Extreame Teeth)
												out.println("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='R"+tooth_sn+ "' align='center'><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

												out.println("<tr><td id='T"+tooth_sn+"' align='center'><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");
											}
											else{
												out.println("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1' ><tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R" + k + ".gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + k + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");
												
												out.println("<tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");
											}

											out.println("<tr><td id='check_num"+tooth_sn+"' align='center'><A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" ></td></tr>");
											//	out.println("<tr><td id='check_num"+tooth_sn+"' align='center'><font size='1'><A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + tooth_num + "</a></font><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" ></td></tr>");
											
											out.println("<tr onMouseOver='hideToolTip();'><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' onclick=\"getDialogFeaturesForNoImage('"+tooth_sn+"','"+tooth_num+"');\" style='cursor:pointer'>&nbsp;</td></tr></table></td></tr></table></td>");
											
										}
									}
									else if(permanent_deciduous_flag.equals("D")){
										/*
										while(mapped_tooth_no != k){
											out.println("<td><table border='0' cellpadding='1' cellspacing='1'><tr><td><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

											out.println("<tr><td ><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");

											out.println("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='20'/></td></tr>");

											out.println("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr></table></td>");

											k++;
											z--;
										}*/
										
										if(mixed_dentition_YN.equals("Y")){
											if(k == 1){
												out.println("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

												out.println("<tr><td ><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");

												out.println("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='20'/></td></tr>");

												out.println("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr></table></td>");
											
											}
											else if(k!=1 && k<=3){
												out.println("<td id ='decith_table"+tooth_sn+"' align='center'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='R"+tooth_sn+ "' align='center'><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

												out.println("<tr><td id='T"+tooth_sn+"' align='center'><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");

												out.println("<tr><td align='center' id='check_num"+tooth_sn+"'><A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "','N')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" ></td></tr>");

												out.println("<tr onMouseOver='hideToolTip();'><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' onclick=\"getDialogFeaturesForNoImage('"+tooth_sn+"','"+tooth_num+"');\" style='cursor:pointer'>&nbsp;</td></tr></table></td></tr></table></td>");
											}
											else{
												if(k==4 || k==5){//Added for IN009202 (SRR20056-CRF-0455) by Sridevi Joshi 15/07/09
													out.println("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R3.gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR3' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "','MR')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");

													out.println("<tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "','MR')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");

													out.println("<tr><td align='center' id='check_num"+tooth_sn+"'><A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "','MR')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" ></td></tr>");

													out.println("<tr onMouseOver='hideToolTip();'><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' onclick=\"getDialogFeaturesForNoImage('"+tooth_sn+"','"+tooth_num+"');\" style='cursor:pointer'>&nbsp;</td></tr></table></td></tr></table></td>");
												}
												else{
													out.println("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R" + k + ".gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + k + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "','MR')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");

													out.println("<tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "','MR')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");

													out.println("<tr><td align='center' id='check_num"+tooth_sn+"'><A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "','MR')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" ></td></tr>");

													out.println("<tr onMouseOver='hideToolTip();'><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' onclick=\"getDialogFeaturesForNoImage('"+tooth_sn+"','"+tooth_num+"');\" style='cursor:pointer'>&nbsp;</td></tr></table></td></tr></table></td>");
												}
											}
										}else if(mixed_dentition_YN.equals("N")){
											while(mapped_tooth_no != k){
												out.println("<td><table border='0' cellpadding='1' cellspacing='1'><tr><td><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

												out.println("<tr><td ><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");

												out.println("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='20'/></td></tr>");

												out.println("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr></table></td>");

												k++;
												z--;
											}

											if(k==4 || k==5){//Added for IN009202 (SRR20056-CRF-0455) by Sridevi Joshi 15/07/09
												out.println("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R3.gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR3' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");

												out.println("<tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");
												
												out.println("<tr><td id='check_num"+tooth_sn+"' align='center'><A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" ></td></tr>");

												out.println("<tr onMouseOver='hideToolTip();'><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' onclick=\"getDialogFeaturesForNoImage('"+tooth_sn+"','"+tooth_num+"');\" style='cursor:pointer'>&nbsp;</td></tr></table></td></tr></table></td>");
											}
											else{
												out.println("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R" + k + ".gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + k + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");

												out.println("<tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");
												
												out.println("<tr><td id='check_num"+tooth_sn+"' align='center'><A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" ></td></tr>");

												out.println("<tr onMouseOver='hideToolTip();'><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' onclick=\"getDialogFeaturesForNoImage('"+tooth_sn+"','"+tooth_num+"');\" style='cursor:pointer'>&nbsp;</td></tr></table></td></tr></table></td>");
											}
										}
									}
									k++;
								}
								else{
									rs.previous();
									break;
								}
							}
						
            _bw.write(_wl_block27Bytes, _wl_block27);
	
							//LOGIC FOR DISPLAYING UPPER LEFT QUADRANT OF DENTAL CHART
							while(rs.next()){
								tooth_sn = rs.getString("TOOTH_NO");
								tooth_num = rs.getString("TOOTH_NUM");
								tooth_name = rs.getString("TOOTH_NAME");
								mapped_tooth_string = rs.getString("MAPPED_TOOTH_NO");
								if(mapped_tooth_string != null){
									mapped_tooth_no = Integer.parseInt(mapped_tooth_string);
								}
								if(k<=16){
									if(permanent_deciduous_flag.equals("P")){
										if(mixed_dentition_YN.equals("Y")){
											if(k == 16){
												out.println("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

												out.println("<tr><td ><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");

												out.println("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='20'/></td></tr>");

												out.println("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr></table></td>");
											
											}
											else if(k!=16 && k>=14){
												out.println("<td id ='decith_table"+tooth_sn+"' align='center'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='R"+tooth_sn+ "' align='center'><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

												out.println("<tr><td id='T"+tooth_sn+"' align='center'><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");

												out.println("<tr><td align='center' id='check_num"+tooth_sn+"'><A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" ></td></tr>");

												out.println("<tr onMouseOver='hideToolTip();'><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' onclick=\"getDialogFeaturesForNoImage('"+tooth_sn+"','"+tooth_num+"');\" style='cursor:pointer'>&nbsp;</td></tr></table></td></tr></table></td>");
											}
											else{
												out.println("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R" + k + ".gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + k + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");

												out.println("<tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");

												out.println("<tr><td id='check_num"+tooth_sn+"' align='center' ><A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\"></td></tr>");

												out.println("<tr onMouseOver='hideToolTip();'><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' onclick=\"getDialogFeaturesForNoImage('"+tooth_sn+"','"+tooth_num+"');\" style='cursor:pointer'>&nbsp;</td></tr></table></td></tr></table></td>");
											}
										}
										else if(mixed_dentition_YN.equals("N")){
											if(k == 16){ //Remove Images for 3rd Molars(Extreame Teeth)
												out.println("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='R"+tooth_sn+ "' align='center'><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

												out.println("<tr><td id='T"+tooth_sn+"' align='center'><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");
											}
											else{
												out.println("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R" + k + ".gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + k + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");

												out.println("<tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");
											}
												
											out.println("<tr><td id='check_num"+tooth_sn+"' align='center' ><A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\"></td></tr>");
											//	out.println("<tr><td id='check_num"+tooth_sn+"' align='center' ><font size='1'><A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + tooth_num + "</a></font><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\"></td></tr>");

											out.println("<tr onMouseOver='hideToolTip();'><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' onclick=\"getDialogFeaturesForNoImage('"+tooth_sn+"','"+tooth_num+"');\" style='cursor:pointer'>&nbsp;</td></tr></table></td></tr></table></td>");
										}
									}
									else if(permanent_deciduous_flag.equals("D")){
										if(mixed_dentition_YN.equals("Y")){
											if(k == 16){
												out.println("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

												out.println("<tr><td ><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");

												out.println("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='20'/></td></tr>");

												out.println("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr></table></td>");
											
											}
											else if(k!=16 && k>=14){
												out.println("<td id ='decith_table"+tooth_sn+"' align='center'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='R"+tooth_sn+ "' align='center'><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

												out.println("<tr><td id='T"+tooth_sn+"' align='center'><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");

												out.println("<tr><td align='center' id='check_num"+tooth_sn+"'><A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "','N')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" ></td></tr>");

												out.println("<tr onMouseOver='hideToolTip();'><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' onclick=\"getDialogFeaturesForNoImage('"+tooth_sn+"','"+tooth_num+"');\" style='cursor:pointer'>&nbsp;</td></tr></table></td></tr></table></td>");
											}
											else{
												if(k==12 || k==13){//Added for IN009202 (SRR20056-CRF-0455) by Sridevi Joshi 15/07/09
													out.println("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R14.gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR14' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "','MR')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");

													out.println("<tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "','MR')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");

													out.println("<tr><td align='center' id='check_num"+tooth_sn+"'><A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "','MR')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\"></td></tr>");
													
													out.println("<tr onMouseOver='hideToolTip();'><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' onclick=\"getDialogFeaturesForNoImage('"+tooth_sn+"','"+tooth_num+"');\" style='cursor:pointer'>&nbsp;</td></tr></table></td></tr></table></td>");
												}
												else{
													out.println("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R" + k + ".gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + k + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "','MR')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");

													out.println("<tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "','MR')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");

													out.println("<tr><td align='center' id='check_num"+tooth_sn+"'><A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "','MR')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\"></td></tr>");
													
													out.println("<tr onMouseOver='hideToolTip();'><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' onclick=\"getDialogFeaturesForNoImage('"+tooth_sn+"','"+tooth_num+"');\" style='cursor:pointer'>&nbsp;</td></tr></table></td></tr></table></td>");
												}
											}
										}else if(mixed_dentition_YN.equals("N")){
											if(mapped_tooth_no == k){
												if(k==12 || k==13){//Added for IN009202 (SRR20056-CRF-0455) by Sridevi Joshi 15/07/09
													out.println("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R14.gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR14' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");

													out.println("<tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");

													out.println("<tr><td align='center' id='check_num"+tooth_sn+"'><A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\"></td></tr>");
													
													out.println("<tr onMouseOver='hideToolTip();'><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' onclick=\"getDialogFeaturesForNoImage('"+tooth_sn+"','"+tooth_num+"');\" style='cursor:pointer'>&nbsp;</td></tr></table></td></tr></table></td>");
												}
												else{
													out.println("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R" + k + ".gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + k + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");

													out.println("<tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");

													out.println("<tr><td align='center' id='check_num"+tooth_sn+"'><A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\"></td></tr>");
													
													out.println("<tr onMouseOver='hideToolTip();'><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' onclick=\"getDialogFeaturesForNoImage('"+tooth_sn+"','"+tooth_num+"');\" style='cursor:pointer'>&nbsp;</td></tr></table></td></tr></table></td>");
												}

											}else{
												out.println("<td><table border='0' cellpadding='1' cellspacing='1'><tr><td><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

												out.println("<tr><td ><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");

												out.println("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='20'/></td></tr>");

												out.println("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr></table></td>");

												z--;
											}
										}
									}
									k++;
								}
								else{
									break;
								}
							}
						
            _bw.write(_wl_block28Bytes, _wl_block28);

							//LOGIC FOR DISPLAYING LOWER RIGHT QUADRANT OF DENTAL CHART
							if(rs != null) rs.close();
							if(pstmt != null) pstmt.close();
							//sql = "SELECT B.TOOTH_NO, B.TOOTH_NAME, DECODE(?,'UNI',B.UNIVERSAL_TOOTH_NO, B.FDI_TOOTH_NO) TOOTH_NUM, B.MAPPED_TOOTH_NO, B.PERMANENT_DECIDUOUS FROM OH_TOOTH  B WHERE B.PERMANENT_DECIDUOUS = ? ORDER BY TOOTH_NO DESC";
							//If additional Lang_vw object is added to the below query, make sure that the TOOTH_NAME qry from the TOOTH_LANG_VW is retrieved properly
							if(permanent_deciduous_flag.equals("D") && mixed_dentition_YN.equals("Y")){
								//sql = "SELECT B.TOOTH_NO, B.TOOTH_NAME, C.NS_TOOTH_NO TOOTH_NUM, B.MAPPED_TOOTH_NO, B.PERMANENT_DECIDUOUS FROM OH_TOOTH_LANG_VW  B, OH_TOOTH_BY_NUMBERING_SYSTEM C WHERE B.TOOTH_NO = C.TOOTH_NO AND B.LANGUAGE_ID = ? AND C.NUMBERING_SYSTEM = ? AND (B.PERMANENT_DECIDUOUS = ? OR MIXED_DENT_TOOTH_NO IS NOT NULL) ORDER BY MIXED_DENT_TOOTH_ORDER DESC";
								sql = "SELECT B.TOOTH_NO, B.TOOTH_NAME, B.NS_TOOTH_NO TOOTH_NUM, B.MAPPED_TOOTH_NO, B.PERMANENT_DECIDUOUS FROM OH_TOOTH_LANG_VW  B WHERE B.LANGUAGE_ID = ? AND B.NUMBERING_SYSTEM = ? AND (B.PERMANENT_DECIDUOUS = ? OR MIXED_DENT_TOOTH_NO IS NOT NULL) ORDER BY MIXED_DENT_TOOTH_ORDER DESC";
							}else{
								//sql = "SELECT B.TOOTH_NO, B.TOOTH_NAME, C.NS_TOOTH_NO TOOTH_NUM, B.MAPPED_TOOTH_NO, B.PERMANENT_DECIDUOUS FROM OH_TOOTH  B, OH_TOOTH_BY_NUMBERING_SYSTEM C WHERE B.TOOTH_NO = C.TOOTH_NO AND C.NUMBERING_SYSTEM = ? AND B.PERMANENT_DECIDUOUS = ? ORDER BY B.TOOTH_NO DESC";
								sql = "SELECT B.TOOTH_NO, B.TOOTH_NAME, B.NS_TOOTH_NO TOOTH_NUM, B.MAPPED_TOOTH_NO, B.PERMANENT_DECIDUOUS FROM OH_TOOTH_LANG_VW  B WHERE B.LANGUAGE_ID = ? AND B.NUMBERING_SYSTEM = ? AND B.PERMANENT_DECIDUOUS = ? ORDER BY B.TOOTH_NO DESC";
							}
							pstmt=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,	ResultSet.CONCUR_UPDATABLE);
							pstmt.setString(1,locale);
							pstmt.setString(2,tooth_numbering_system);
							pstmt.setString(3,permanent_deciduous_flag);
							rs=pstmt.executeQuery();

							k=32;
							while(rs.next()){
								tooth_sn = rs.getString("TOOTH_NO");
								tooth_num = rs.getString("TOOTH_NUM");
								tooth_name = rs.getString("TOOTH_NAME");
								mapped_tooth_string = rs.getString("MAPPED_TOOTH_NO");
								if(mapped_tooth_string != null){
									mapped_tooth_no = Integer.parseInt(mapped_tooth_string);
								}
								if(k>=25){
									if(permanent_deciduous_flag.equals("P")){
										if(mixed_dentition_YN.equals("Y")){
											if(k == 32){
												out.println("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");

												out.println("<tr><td ><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

												out.println("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='20'/></td></tr>");

												out.println("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr></table></td>");
												
											}
											else if(k!=32 && k>=30){
												out.println("<td id ='decith_table"+tooth_sn+"' align='center'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='T"+tooth_sn+ "' align='center'><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");

												out.println("<tr><td id='R"+tooth_sn+"' align='center'><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

												out.println("<tr><td align='center' id='check_num"+tooth_sn+"'><A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\"></td></tr>");

												out.println("<tr onMouseOver='hideToolTip();'><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' onclick=\"getDialogFeaturesForNoImage('"+tooth_sn+"','"+tooth_num+"');\" style='cursor:pointer'>&nbsp;</td></tr></table></td></tr></table></td>");
											}
											else{
												out.println("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");
											
												out.println("<tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R" + k + ".gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + k + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");

												out.println("<tr><td align='center' id='check_num"+tooth_sn+"'><A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\"></td></tr>");

												out.println("<tr onMouseOver='hideToolTip();'><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' onclick=\"getDialogFeaturesForNoImage('"+tooth_sn+"','"+tooth_num+"');\" style='cursor:pointer'>&nbsp;</td></tr></table></td></tr></table></td>");
											}
										}
										else if(mixed_dentition_YN.equals("N")){
											if(k == 32){//Remove Images for 3rd Molars(Extreame Teeth)
												out.println("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='T"+tooth_sn+"' align='center'><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

												out.println("<tr><td id='R"+tooth_sn+ "' align='center'><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");
											}
											else{
												out.println("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");
												
												out.println("<tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R" + k + ".gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + k + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");
											}

											out.println("<tr><td id='check_num"+tooth_sn+"' align='center' ><A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\"></td></tr>");

											out.println("<tr onMouseOver='hideToolTip();'><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' onclick=\"getDialogFeaturesForNoImage('"+tooth_sn+"','"+tooth_num+"');\" style='cursor:pointer'>&nbsp;</td></tr></table></td></tr></table></td>");
										}
									}
									else if(permanent_deciduous_flag.equals("D")){
										if(mixed_dentition_YN.equals("Y")){
											if(k == 32){
												out.println("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");

												out.println("<tr><td ><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

												out.println("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='20'/></td></tr>");

												out.println("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr></table></td>");
												
											}
											else if(k!=32 && k>=30){
												out.println("<td id ='decith_table"+tooth_sn+"' align='center'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='T"+tooth_sn+ "' align='center'><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");

												out.println("<tr><td id='R"+tooth_sn+"' align='center'><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

												out.println("<tr><td align='center' id='check_num"+tooth_sn+"'><A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "','N')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\"></td></tr>");

												out.println("<tr onMouseOver='hideToolTip();'><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' onclick=\"getDialogFeaturesForNoImage('"+tooth_sn+"','"+tooth_num+"');\" style='cursor:pointer'>&nbsp;</td></tr></table></td></tr></table></td>");
											}
											else{
												if(k==29 || k==28){//Added for IN009202 (SRR20056-CRF-0455) by Sridevi Joshi 15/07/09
													out.println("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "','MR')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");
			 
													out.println("<tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R30.gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR30' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "','MR')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");

													out.println("<tr><td align='center' id='check_num"+tooth_sn+"'><A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "','MR')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\"></td></tr>");

													out.println("<tr onMouseOver='hideToolTip();'><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' onclick=\"getDialogFeaturesForNoImage('"+tooth_sn+"','"+tooth_num+"');\" style='cursor:pointer'>&nbsp;</td></tr></table></td></tr></table></td>");	
												}
												else{
													out.println("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "','MR')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");
			 
													out.println("<tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R" + k + ".gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + k + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "','MR')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");

													out.println("<tr><td align='center' id='check_num"+tooth_sn+"'><A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "','MR')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\"></td></tr>");

													out.println("<tr onMouseOver='hideToolTip();'><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' onclick=\"getDialogFeaturesForNoImage('"+tooth_sn+"','"+tooth_num+"');\" style='cursor:pointer'>&nbsp;</td></tr></table></td></tr></table></td>");				
												}
											}
										}else if(mixed_dentition_YN.equals("N")){
											while(mapped_tooth_no != k){
												out.println("<td><table border='0' cellpadding='1' cellspacing='1'><tr><td><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");

												out.println("<tr><td ><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

												out.println("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='20'/></td></tr>");

												out.println("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr></table></td>");

												k--;
												z--;
											}

											if(k==29 || k==28){//Added for IN009202 (SRR20056-CRF-0455) by Sridevi Joshi 15/07/09
												out.println("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");
		 
												out.println("<tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R30.gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR30' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");

												out.println("<tr><td align='center' id='check_num"+tooth_sn+"'><A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\"></td></tr>");

												out.println("<tr onMouseOver='hideToolTip();'><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' onclick=\"getDialogFeaturesForNoImage('"+tooth_sn+"','"+tooth_num+"');\" style='cursor:pointer'>&nbsp;</td></tr></table></td></tr></table></td>");
											}else{
												out.println("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");
		 
												out.println("<tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R" + k + ".gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + k + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");

												out.println("<tr><td align='center' id='check_num"+tooth_sn+"'><A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\"></td></tr>");

												out.println("<tr onMouseOver='hideToolTip();'><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' onclick=\"getDialogFeaturesForNoImage('"+tooth_sn+"','"+tooth_num+"');\" style='cursor:pointer'>&nbsp;</td></tr></table></td></tr></table></td>");
											}
										}
									}
									k--;
								}
								else{
									rs.previous();
									break;
								}
							}
							
            _bw.write(_wl_block27Bytes, _wl_block27);

							//LOGIC FOR DISPLAYING LOWER LEFT QUADRANT OF DENTAL CHART
							while(rs.next()){
								tooth_sn = rs.getString("TOOTH_NO");
								tooth_num = rs.getString("TOOTH_NUM");
								tooth_name = rs.getString("TOOTH_NAME");
								mapped_tooth_string = rs.getString("MAPPED_TOOTH_NO");
								if(mapped_tooth_string != null){
									mapped_tooth_no = Integer.parseInt(mapped_tooth_string);
								}
								if(k>=17){
									if(permanent_deciduous_flag.equals("P")){
										if(mixed_dentition_YN.equals("Y")){
											if(k == 17){
												out.println("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");

												out.println("<tr><td ><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

												out.println("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='20'/></td></tr>");

												out.println("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr></table></td>");
												
											}
											else if(k!=17 && k<=19){
												out.println("<td id ='decith_table"+tooth_sn+"' align='center'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='T"+tooth_sn+ "' align='center'><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");

												out.println("<tr><td id='R"+tooth_sn+"' align='center'><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

												out.println("<tr><td align='center' id='check_num"+tooth_sn+"'><A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\"></td></tr>");

												out.println("<tr onMouseOver='hideToolTip();'><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' onclick=\"getDialogFeaturesForNoImage('"+tooth_sn+"','"+tooth_num+"');\" style='cursor:pointer'>&nbsp;</td></tr></table></td></tr></table></td>");
											}
											else{
												out.println("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"'  border='0' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");

												out.println("<tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R" + k + ".gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + k + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");

												out.println("<tr><td align='center' id='check_num"+tooth_sn+"'><A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\"></td></tr>");

												out.println("<tr onMouseOver='hideToolTip();'><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' onclick=\"getDialogFeaturesForNoImage('"+tooth_sn+"','"+tooth_num+"');\" style='cursor:pointer'>&nbsp;</td></tr></table></td></tr></table></td>");
											}
										}
										else if(mixed_dentition_YN.equals("N")){
											if(k == 17){//Remove Images for 3rd Molars(Extreame Teeth)
												out.println("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='T"+tooth_sn+"' align='center'><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

												out.println("<tr><td id='R"+tooth_sn+ "' align='center'><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");

											}
											else{
												out.println("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"'  border='0' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");

												out.println("<tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R" + k + ".gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + k + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");
												
											}
											out.println("<tr><td id='check_num"+tooth_sn+"' align='center' ><A  onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\"></td></tr>");

											out.println("<tr onMouseOver='hideToolTip();'><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' onclick=\"getDialogFeaturesForNoImage('"+tooth_sn+"','"+tooth_num+"');\" style='cursor:pointer'>&nbsp;</td></tr></table></td></tr></table></td>");
										}
									}
									else if(permanent_deciduous_flag.equals("D")){
										if(mixed_dentition_YN.equals("Y")){
											if(k == 17){
												out.println("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");

												out.println("<tr><td ><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

												out.println("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='20'/></td></tr>");

												out.println("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr></table></td>");
												
											}
											else if(k!=17 && k<=19){
												out.println("<td id ='decith_table"+tooth_sn+"' align='center'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='T"+tooth_sn+ "' align='center'><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");

												out.println("<tr><td id='R"+tooth_sn+"' align='center'><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");


												out.println("<tr><td align='center' id='check_num"+tooth_sn+"'><A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "','N')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\"></td></tr>");

												out.println("<tr onMouseOver = 'hideToolTip();'><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' onclick=\"getDialogFeaturesForNoImage('"+tooth_sn+"','"+tooth_num+"');\" style='cursor:pointer'>&nbsp;</td></tr></table></td></tr></table></td>");
											}
											else{
												if(k==20 || k==21){ //Added for IN009202 (SRR20056-CRF-0455) by Sridevi Joshi 15/07/09
													out.println("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "','MR')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");

													out.println("<tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R19.gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR19' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "','MR')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");

													out.println("<tr><td align='center' id='check_num"+tooth_sn+"'><A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "','MR')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\"></td></tr>");

													out.println("<tr onMouseOver = 'hideToolTip();'><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' onclick=\"getDialogFeaturesForNoImage('"+tooth_sn+"','"+tooth_num+"');\" style='cursor:pointer'>&nbsp;</td></tr></table></td></tr></table></td>");
												}
												else{
													out.println("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "','MR')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");

													out.println("<tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R" + k + ".gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + k + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "','MR')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");

													out.println("<tr><td align='center' id='check_num"+tooth_sn+"'><A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "','MR')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\"></td></tr>");

													out.println("<tr onMouseOver = 'hideToolTip();'><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' onclick=\"getDialogFeaturesForNoImage('"+tooth_sn+"','"+tooth_num+"');\" style='cursor:pointer'>&nbsp;</td></tr></table></td></tr></table></td>");
												}
											}
										}else if(mixed_dentition_YN.equals("N")){
											if(mapped_tooth_no == k){
												if(k==20 || k==21){ //Added for IN009202 (SRR20056-CRF-0455) by Sridevi Joshi 15/07/09
													out.println("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");

													out.println("<tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R19.gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR19' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");

													out.println("<tr><td align='center' id='check_num"+tooth_sn+"'><A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\"></td></tr>");

													out.println("<tr onMouseOver = 'hideToolTip();'><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' onclick=\"getDialogFeaturesForNoImage('"+tooth_sn+"','"+tooth_num+"');\" style='cursor:pointer'>&nbsp;</td></tr></table></td></tr></table></td>");
												}
												else{
													out.println("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");

													out.println("<tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R" + k + ".gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + k + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");

													out.println("<tr><td align='center' id='check_num"+tooth_sn+"'><A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\"></td></tr>");

													out.println("<tr onMouseOver = 'hideToolTip();'><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' onclick=\"getDialogFeaturesForNoImage('"+tooth_sn+"','"+tooth_num+"');\" style='cursor:pointer'>&nbsp;</td></tr></table></td></tr></table></td>");
												}
											}
											else{
												out.println("<td><table border='0' cellpadding='1' cellspacing='1'><tr><td><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");

												out.println("<tr><td ><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

												out.println("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='20'/></td></tr>");

												out.println("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr></table></td>");
											}
										}
									}
									k--;
								}
								else{
									break;
								}
							}
					
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(Q4_id));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(Q4_id));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(Q4_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(Q4_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(Q4_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(Q4_desc));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(Q4_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(Q4_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(Q4_desc));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(Q4_id));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(Q4_id));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(Q4_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(Q4_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(Q4_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(Q4_desc));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(Q4_id));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(Q4_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(Q4_desc));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(lower_arch_desc));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(lower_arch_desc));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(lower_arch_desc));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(lower_arch_desc));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(Q3_id));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(Q3_id));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(Q3_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(Q3_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(Q3_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(Q3_desc));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(Q3_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(Q3_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(Q3_desc));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(Q3_id));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(Q3_id));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(Q3_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(Q3_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(Q3_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(Q3_desc));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(Q3_id));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(Q3_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(Q3_desc));
            _bw.write(_wl_block40Bytes, _wl_block40);
//=patientAge
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(treat_Locn_Type));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(chart_type));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(chart_num));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(header_tab));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(show_new_active_yn));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(mixed_dentition_YN));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(episode_id));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(episode_type));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(visit_id));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(location_code));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(location_type));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(oh_chart_level));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(tooth_numbering_system));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(permanent_deciduous_flag));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(chart_hdr_insert_yn));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(called_from_viewchart_yn));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(date_diff_flag));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(upper_arch_desc));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(lower_arch_desc));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(Q1_id));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(Q2_id));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(Q3_id));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(Q4_id));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(Q1_desc));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(Q2_desc));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Q3_desc));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(Q4_desc));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(baseline_chart_yn));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(chart_status_from_view));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(other_facilitychart_yn));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(other_chart_facility_id));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(chart_disable_from_main));
            _bw.write(_wl_block79Bytes, _wl_block79);

		if(load_images_yn.equals("Y")){
	
            _bw.write(_wl_block80Bytes, _wl_block80);

		}
	
            _bw.write(_wl_block81Bytes, _wl_block81);

}catch ( Exception e ) {
	e.printStackTrace() ;
}finally {
	try{
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(con!=null) 
			ConnectionManager.returnConnection(con,request);
	   }catch(Exception es){es.printStackTrace();}
}

            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
