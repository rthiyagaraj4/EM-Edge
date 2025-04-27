package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.ConnectionManager;
import java.sql.Connection;
import org.json.simple.parser.JSONParser;
import org.json.simple.*;
import java.util.*;
import com.ehis.util.*;

public final class __haadcolorcodedtls extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/HAADcolorcodeDtls.jsp", 1730371382985L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n\n  ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\t\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<Script src=\"../../eCommon/js/jquery-3.6.3.js\" language=\"JavaScript\"></Script>\n\t\n\t\n\t<script type=\"text/javascript\" src=\"../../eIP/html/JQuery/ColorCoding/farbtastic.js\"></script>\n\t<link rel=\"stylesheet\" href=\"../../eIP/html/JQuery/ColorCoding/farbtastic.css\" type=\"text/css\" />\n\t<script language=\'javascript\' src=\'../../eMR/js/HAADcolorcodeSetup.js\'></script>\n\n\t<style type=\"text/css\">\t\t\t\n\t\t/*\t.colorpickerDiv{\n\t\t\t\tfloat:left;\n\t\t\t\tborder:0px solid black;\n\t\t\t}\n\t\t\t.colorPickTextId{\n\t\t\t\tmargin-left:10%;\n\t\t\t\twidth:100%;\n\t\t\t}\n\t\t\t.TextId{\n\t\t\t\twidth:100%;\t\t\t\t\n\t\t\t}\n\t\t\t.colorPickId{\n\t\t\t\ttop:80%;\n\t\t\t\tmargin-left:10%;\n\t\t\t\tmargin-top:10%;\n\t\t\t\tmargin-top:10%;\n\t\t\t}*/\n\t\t\tbody {\n\t\t\t\tmargin-left: 0px;\n\t\t\t\tmargin-top: 0px;\n\t\t\t\tmargin-right: 0px;\n\t\t\t\tmargin-bottom: 0px;\n\t\t\t\tfont-family:Arial, Helvetica, sans-serif;\n\t\t\t\t\tfont-size:12px;\n\t\t\t}\n\t\t\t.header\n\t\t\t{\n\t\t\t\theight:30px;\n\t\t\t\tbackground-color:#83aab4;\n\t\t\t\tfont-weight:600;\n\t\t\t\tcolor:#fff;\n\t\t\t\tpadding-left:10px;\n\t\t\t}\n\t\t\t.row1\n\t\t\t{\n\t\t\t\tbackground-color:#fff;\n\t\t\t\theight:30px;\n\t\t\t\tborder-bottom:1px solid #dcdfe5;\n\t\t\t}\n\t\t\t.row2\n\t\t\t{\n\t\t\t\tbackground-color:#fff;\n\t\t\t\theight:30px;\n\t\t\t\tborder-bottom:1px solid #f4f4f5;\n\t\t\t}\n\t\t\t.text\n\t\t\t{\n\t\t\t\tfont-size:12px;\n\t\t\t\tfont-weight:400;\n\t\t\t\tcolor:#484848;\n\t\t\t\tpadding-left:10px;\n\t\t\t}\n\t\t\t.child\n\t\t\t{\n\t\t\t\twidth:100%; height:150px; overflow:auto;\n\t\t\t\tborder:1px solid #f4f4f5;\n\t\t\t}\n\t\t\t.box\n\t\t\t{\n\t\t\t\twidth:100%; height:500px; overflow:auto;\n\n\t\t\t}\n\t\t\t.childheader\n\t\t\t{\n\t\t\t\theight:30px;\n\t\t\t\tbackground-color:#f4f4f5;\n\t\t\t\tfont-size:12px;\n\t\t\t\tfont-weight:700;\n\t\t\t\tcolor:#484848;\n\t\t\t\tpadding-left:10px;\n\t\t\t}\n\t\t</style>\n\t\t<script type=\"text/javascript\">\n\t\t\t$(document).ready(function () {\n\t\t\t\t$(\'#colorpicker\').farbtastic(\'#color\');\n\t\t\t\t$(\'.colorcode\').click(function (event){\n\t\t\t\t\tvar $target = $(event.target); // the element that fired the original click event\n\t\t\t\t\t$(\'#color\').val($(this).css(\'backgroundColor\'));\n\t\t\t\t\t$(\'#color\').focus();\n\t\t\t\t\t$(\'#color\').trigger(\'keyup\');\n\t\t\t\t\t$(\"input[id=selectedElem]\").val($(this).attr(\'id\'));\n\t\t\t\t\tevent.stopPropagation();\n\t\t\t\t});\n\t\t\t\t\n\t\t\t});\n\t\t\t\n\t\t\n\t\t</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\t<body OnMouseDown=\"CodeArrest();\" onKeyDown = \'lockKey()\'>\n\t\t<form name=\'HaadColorCodeForm\' id=\'HaadColorCodeForm\' method=\'post\' target=\"messageFrame\" action=\'../../servlet/eMR.HAADcolorcodeServlet\'>\n\t\t<div style=\"width:97%;\">\n\t\t<div class=\"ui-layout-center\" style=\"width:74%; float:left;margin-left:20px;\">\n\t\t\t<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n\t\t\t\t<tr>\n\t\t\t\t\t<td align=\"left\" valign=\"top\">\n\t\t\t\t\t\t<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n\t\t\t\t\t\t  <tr>\n\t\t\t\t\t\t\t<td align=\"left\" valign=\"top\">\n\t\t\t\t\t\t\t\t<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"border:1px solid #83aab4\">\n\t\t\t\t\t\t\t\t\t <tr>\n\t\t\t\t\t\t\t\t\t\t<td width=\"20%\" align=\"left\" valign=\"middle\" class=\"header\">";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =" ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t\t\t\t\t\t\t\t\t\t<td width=\"63%\" align=\"left\" valign=\"middle\" class=\"header\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t\t\t\t\t\t\t\t\t<td width=\"13%\" align=\"left\" valign=\"middle\" class=\"header\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t\t\t\t\t\t\t\t\t\t<td width=\"4%\" align=\"left\" valign=\"middle\" class=\"header\">&nbsp;</td>\n\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t  </tr>\n\t\t\t\t\t\t  <tr>\n\t\t\t\t\t\t\t<td align=\"left\" valign=\"top\">\n\t\t\t\t\t\t\t\t<div class=\"box\">\n\t\t\t\t\t\t\t\t\t<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"border:1px solid #83aab4\">\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t\t\t\t\t\t<tr >\n\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\" valign=\"middle\" class=\"text row1\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\" valign=\"middle\"  class=\"text row1\">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n\t\t\t\t\t\t\t\t\t\t\t<td align=\"center\" valign=\"middle\" class=\"row1\"><div id=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" name=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" class=\'colorcode\' style=\"background-color:";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="; height:30px;width:30px;border: 1px solid;cursor:pointer;\"></div></td>\n\t\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' id=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="BgColor\" name=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="BgColor\" value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" >\n\t\t\t\t\t\t\t\t\t\t\t<td align=\"center\" valign=\"middle\" class=\"row1\">\n\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"../../eOA/patientportal/Edit.png\" width=\"24\" height=\"24\" style=\"cursor:pointer;\" id=\'edit_";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' onclick=\"fnShowTermCode(\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'); \"/>\n\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"../../eOA/patientportal/Save.png\" width=\"24\" height=\"24\" id=\'save_";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' style=\"display:none;cursor:pointer;\" onclick=\"fnSave(\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\');\"/ />\n\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t<tr id=\"tr_";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" style=\'display:none;\'>\n\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\" valign=\"top\">&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t\t<td colspan=\"3\" align=\"left\" valign=\"top\">\n\t\t\t\t\t\t\t\t\t\t\t\t<table width=\"99%\" border=\"0\" cellspacing=\"2\" cellpadding=\"0\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"border:1px solid #f4f4f5;\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"18%\" align=\"left\" valign=\"middle\" class=\"childheader\">";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"77%\" align=\"left\" valign=\"middle\" class=\"childheader\">";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"5%\" align=\"left\" valign=\"middle\" class=\"childheader\">&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"18%\" align=\"left\" valign=\"middle\" class=\"row2\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<select name=\"termSet_";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" id=\"termSet_";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"\">--------";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="---------</option> \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\">";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</option>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"77%\" align=\"left\" valign=\"middle\" class=\"row2\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\'text\' name=\'termCode_";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' id=\'termCode_";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' value=\"\" size=\'15\' maxlength=\'15\' readonly ><input type=\'button\' class=\'button\' value=\'?\' name=\'termCodeBtn_";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' id=\'termCodeBtn_";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' onClick=\"call_Diagnosis(termCode_";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 =",this,\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\');\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"5%\" align=\"left\" valign=\"middle\" class=\"row2\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\'button\' class=\'button\' value=\'Add\' name=\'addBtn_";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' id=\'addBtn_";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' onClick=\"fnAdd(\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\');\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"child\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" id=\"tableList_";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tbody>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tparent.haadTermsetLists.push(\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\");\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr  id=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  <td width=\"18%\" align=\"left\" valign=\"middle\" class=\"row2\">";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="</td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  <td width=\"77%\" align=\"left\" valign=\"middle\" class=\"row2\">";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  <td width=\"5%\" align=\"left\" valign=\"middle\" class=\"row2\"><img src=\"../../eOA/patientportal/Close.png\" width=\"24\" height=\"24\"  style=\"cursor:pointer;\" onclick=\"fnRemoveTr(\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\',\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\');\" /></td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tbody>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t</table>\n\t\t\t\t\t</div>\n\t\t\t\t\t</td>\n\t\t\t\t\t<!--<td width=\"22%\" align=\"center\" valign=\"top\">\n\t\t\t\t\t</td>-->\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t</div>\n\t\t<div style=\"float:right\" >\n\t\t\t<div id=\'colorPickTextId\' class=\'colorPickTextId\'>\n\t\t\t\t<input type=\"hidden\" id=\"color\" name=\"color\" id=\"color\" value=\"#123456\" /><br>\n\t\t\t</div>\n\t\t\t<div id=\'colorPickId\' class=\'colorPickId\' style=\"margin-top:1px; margin-left:40px; width:100%\">\n\t\t\t\t<div id=\"colorpicker\"></div>\n\t\t\t</div>\n\t\t</div>\n\t</div>\n\t\t\n\t\t\t<input type=\'hidden\' id=\'selectedElem\' name=\'selectedElem\' id=\'selectedElem\' value=\'\'>\n\t\t\t<input type=\'hidden\' id=\'IDANDCOLORCONCAT\' name=\'IDANDCOLORCONCAT\' id=\'IDANDCOLORCONCAT\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'diag_code\' id=\'diag_code\' value = \"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'diag_desc\' id=\'diag_desc\' value = \"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\"></input>\n\n\t\t\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t</form>\n\t</body>\t\t\n</html>\n\n";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

        request.setCharacterEncoding("UTF-8");
  		Connection con = null;
	    String locale			= (String)session.getAttribute("LOCALE");
	    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
	("PREFERRED_STYLE"):"IeStyle.css";


            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

try{

	con = ConnectionManager.getConnection(request);
	
	String diag_code					= "";
	String diag_desc					= "";


	String diseaseHDRList				= eMR.MRHaadcolorConfigBean.getHaadDiseaseCodeandDesc(con);
	JSONObject jsonObject				= (JSONObject) new JSONParser().parse(diseaseHDRList);
	JSONArray diseaseHDRListArray 		= (JSONArray)jsonObject.get("diseaseHDRList");
	
	
	String termSetList					= eMR.MRHaadcolorConfigBean.getTermSetList(con);
	jsonObject							= (JSONObject) new JSONParser().parse(termSetList);
	JSONArray termSetListArray 			= (JSONArray)jsonObject.get("termSetList");
	JSONArray diagCodeSchemeArray 		= (JSONArray)jsonObject.get("diagCodeScheme");
	
	if(diagCodeSchemeArray.size() > 1){
		JSONObject diagCodeSchemeObj	= (JSONObject)diagCodeSchemeArray.get(0);
		diag_code						= (String) diagCodeSchemeObj.get("scheme_desc");
		diag_desc						= (String) diagCodeSchemeObj.get("diag_code_scheme");
	}
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
for(int i = 0 ; i < diseaseHDRListArray.size() ; i++) {	

										JSONObject diseaseHDRListObj	= (JSONObject)diseaseHDRListArray.get(i);

										String DISEASE_ID				= (String) diseaseHDRListObj.get("DISEASE_ID");
										String DISEASE_NAME				= (String) diseaseHDRListObj.get("DISEASE_NAME");
										String COLOR_CODE				= (String) diseaseHDRListObj.get("COLOR_CODE");
										String className				= "rowA";
										if(i%2==0)
											className					= "rowA";
										else
											className					= "rowB";

										String diseaseDtlsList			= eMR.MRHaadcolorConfigBean.getHaadDiseaseDtls(con,DISEASE_ID,locale);
										JSONObject jsonObject1			= (JSONObject) new JSONParser().parse(diseaseDtlsList);
										JSONArray diseaseDtlsListArray 	= (JSONArray)jsonObject1.get("diseaseDtlsList");
										
										
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(DISEASE_ID));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(DISEASE_NAME));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(DISEASE_ID));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(DISEASE_ID));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(COLOR_CODE ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(DISEASE_ID));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(DISEASE_ID));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(COLOR_CODE ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(DISEASE_ID));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(DISEASE_ID));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(DISEASE_ID));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(DISEASE_ID));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(DISEASE_ID));
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(DISEASE_ID));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(DISEASE_ID));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(DISEASE_ID));
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);
for(int j = 0 ; j < termSetListArray.size() ; j++){
																				JSONObject termSetListObj = (JSONObject)termSetListArray.get(j);
																				String term_set_id	= (String) termSetListObj.get("term_set_id");
																				String term_set_desc = (String) termSetListObj.get("term_set_desc");
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(term_set_desc));
            _bw.write(_wl_block34Bytes, _wl_block34);
}
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(DISEASE_ID));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(DISEASE_ID));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(DISEASE_ID));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(DISEASE_ID));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(DISEASE_ID));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(DISEASE_ID));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(DISEASE_ID));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(DISEASE_ID));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(DISEASE_ID));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(DISEASE_ID));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(DISEASE_ID));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(DISEASE_ID));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(DISEASE_ID));
            _bw.write(_wl_block45Bytes, _wl_block45);
if(diseaseDtlsListArray.size() > 0){
																		for(int k=0; k < diseaseDtlsListArray.size();k++){
																			JSONObject diseaseDtlsListObj	= (JSONObject)diseaseDtlsListArray.get(k);
																			String dtlsTermSetId			= (String) diseaseDtlsListObj.get("TERM_SET_ID");
																			String dtlsTermCode				= (String) diseaseDtlsListObj.get("TERM_CODE");
																			String dtlsTermSetDesc			= (String) diseaseDtlsListObj.get("TERM_SET_DESC");
																			String dtlsTermCodeForTr		= dtlsTermCode.replace(".", "-");
																			String trId						= DISEASE_ID+'_'+dtlsTermSetId+'_'+dtlsTermCodeForTr;
																			String haadId					= dtlsTermSetId+"$$$"+dtlsTermCode+"###"+DISEASE_ID;
																			
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(haadId));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(trId));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(dtlsTermSetDesc));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(dtlsTermCode));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(trId));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(haadId));
            _bw.write(_wl_block52Bytes, _wl_block52);
}
																		}
            _bw.write(_wl_block53Bytes, _wl_block53);
}
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(diag_code));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(diag_desc));
            _bw.write(_wl_block56Bytes, _wl_block56);
}catch(Exception e){
					e.printStackTrace();
				}finally{
				if(con!=null) ConnectionManager.returnConnection(con,request);
			}
            _bw.write(_wl_block57Bytes, _wl_block57);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.Disease.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.code.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag2(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag2 = null ;
        int __result__tag2 = 0 ;

        if (__tag2 == null ){
            __tag2 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag2);
        }
        __tag2.setPageContext(pageContext);
        __tag2.setParent(null);
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.Disease.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag2;
        __result__tag2 = __tag2.doStartTag();

        if (__result__tag2!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag2== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag2.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag2);
            return true;
        }
        _activeTag=__tag2.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag2);
        __tag2.release();
        return false;
    }

    private boolean _jsp__tag3(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag3 = null ;
        int __result__tag3 = 0 ;

        if (__tag3 == null ){
            __tag3 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag3);
        }
        __tag3.setPageContext(pageContext);
        __tag3.setParent(null);
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.description.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag3;
        __result__tag3 = __tag3.doStartTag();

        if (__result__tag3!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag3== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag3.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag3);
            return true;
        }
        _activeTag=__tag3.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag3);
        __tag3.release();
        return false;
    }

    private boolean _jsp__tag4(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag4 = null ;
        int __result__tag4 = 0 ;

        if (__tag4 == null ){
            __tag4 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag4);
        }
        __tag4.setPageContext(pageContext);
        __tag4.setParent(null);
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Color.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag4;
        __result__tag4 = __tag4.doStartTag();

        if (__result__tag4!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag4== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag4.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag4);
            return true;
        }
        _activeTag=__tag4.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag4);
        __tag4.release();
        return false;
    }

    private boolean _jsp__tag5(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag5 = null ;
        int __result__tag5 = 0 ;

        if (__tag5 == null ){
            __tag5 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag5);
        }
        __tag5.setPageContext(pageContext);
        __tag5.setParent(null);
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.code.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag5;
        __result__tag5 = __tag5.doStartTag();

        if (__result__tag5!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag5== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag5.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag5);
            return true;
        }
        _activeTag=__tag5.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag5);
        __tag5.release();
        return false;
    }

    private boolean _jsp__tag6(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag6 = null ;
        int __result__tag6 = 0 ;

        if (__tag6 == null ){
            __tag6 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag6);
        }
        __tag6.setPageContext(pageContext);
        __tag6.setParent(null);
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.TermSet.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag6;
        __result__tag6 = __tag6.doStartTag();

        if (__result__tag6!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag6== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag6.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag6);
            return true;
        }
        _activeTag=__tag6.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag6);
        __tag6.release();
        return false;
    }

    private boolean _jsp__tag7(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag7 = null ;
        int __result__tag7 = 0 ;

        if (__tag7 == null ){
            __tag7 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag7);
        }
        __tag7.setPageContext(pageContext);
        __tag7.setParent(null);
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.TermCode.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag7;
        __result__tag7 = __tag7.doStartTag();

        if (__result__tag7!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag7== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag7.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag7);
            return true;
        }
        _activeTag=__tag7.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag7);
        __tag7.release();
        return false;
    }

    private boolean _jsp__tag8(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag8 = null ;
        int __result__tag8 = 0 ;

        if (__tag8 == null ){
            __tag8 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag8);
        }
        __tag8.setPageContext(pageContext);
        __tag8.setParent(null);
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag8;
        __result__tag8 = __tag8.doStartTag();

        if (__result__tag8!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag8== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag8.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag8);
            return true;
        }
        _activeTag=__tag8.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag8);
        __tag8.release();
        return false;
    }
}
