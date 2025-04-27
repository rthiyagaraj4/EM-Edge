package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import eCA.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __encsummlayoutconfig extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/EncSummLayoutConfig.jsp", 1709115859403L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'\n\ttype=\'text/css\'></link>\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n<script language=\'javascript\' src=\'../js/EncSummLayout.js\'></script>\n<Script language=\"JavaScript\" src=\'../../eCommon/js/CommonLookup.js\'></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<body class=\'CONTENT\' OnMouseDown=\"CodeArrest()\"\n\tonload=\'FocusFirstElement();\' onKeyDown=\"lockKey()\">\n\t<form name=\"SummLayoutConfigForm\" id=\"SummLayoutConfigForm\"\n\t\taction=\"../../servlet/eCA.EncSummLayoutServlet\" method=\"post\"\n\t\ttarget=\"messageFrame\">\n\t\t\n\t\t<table class=\'grid\' align=\"center\" border=\"1\" cellpadding=\"1\" cellspacing=\"1\"\n\t\t\tstyle=\"width: 900px;\">\n\t\t\t<tbody>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'columnheadercenter\' colspan=\"3\">Summary Information&nbsp;</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'gridData\' width=\"45%\">Header Orientation&nbsp;</td>\n\t\t\t\t\t<td class=\'Fields\' ><input type=\"radio\"\n\t\t\t\t\t\t\t\t\tname=\"orientation\" id=\"orientation\" value=\"0\"\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 =">Vertical</td>\n\t\t\t\t\t<td class=\'Fields\'><input type=\"radio\"\n\t\t\t\t\t\t\t\t\tname=\"orientation\" id=\"orientation\" value=\"1\"\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =">Horizontal</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'gridData\' width=\"45%\">Color Indicate&nbsp;</td>\n\t\t\t\t\t<td class=\'Fields\' colspan=\"2\"><input type=\"checkbox\"\n\t\t\t\t\t\t\t\t\tname=\"es_colors_indicate\" id=\"es_colors_indicate\"\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =">Yes/No</td>\n\t\t\t\t</tr>\t\t\t\t\t\t\t\n\t\t\t</tbody>\n\t\t</table>\n\t\n\t\t<table class=\'grid\' align=\"center\" border=\"1\" cellpadding=\"1\" cellspacing=\"1\"\n\t\t\tstyle=\"width: 900px;\">\n\t\t\t<tbody>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'columnheadercenter\' colspan=\"2\">Table Template&nbsp;</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'gridData\' width=\"45%\">Cell Color Fill&nbsp;</td>\n\t\t\t\t\t<td class=\'Fields\' width=\"55%\"><input type=\"checkbox\"\n\t\t\t\t\t\t\t\t\tname=\"es_tab_cell_color\" id=\"es_tab_cell_color\"\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =">Yes/No</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'gridData\' width=\"45%\">Cell Border Color Fill&nbsp;</td>\n\t\t\t\t\t<td class=\'Fields\' width=\"55%\"><input type=\"checkbox\"\n\t\t\t\t\t\t\t\t\tname=\"es_tbl_cell_bborder_fill\" id=\"es_tbl_cell_bborder_fill\"\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =">Yes/No</td>\n\t\t\t\t</tr>\n\t\t\t</tbody>\n\t\t</table>\n\t\t\t\t\t\n\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t<table class=\'grid\' align=\"center\" border=\"1\" cellpadding=\"1\" cellspacing=\"1\"\n\t\t\t\t\t\tstyle=\"width: 900px;\">\n\t\t\t\t<tbody>\n\t\t\t\t<tr id=\'trcoll\'>\n\t\t\t\t\t<td class=\'COLUMNHEADERCENTER\' width=\"100\" >Field Name</td>\n\t\t\t\t\t<td class=\'COLUMNHEADERCENTER\'>Enable Flag</td>\t\t\t\t\t\n\t\t\t\t\t<td class=\'COLUMNHEADERCENTER\' colspan=\"2\">Orientation</td>\n\t\t\t\t\t<td class=\'COLUMNHEADERCENTER\'>Label</td>\n\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t\t\t<tr id=\'trcoll\'>\n\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADERCENTER\' colspan=\'5\' >Facility Information</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t\t\t\t<tr id=\'trcoll\'>\n\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADERCENTER\' colspan=\'5\' >Patient Information</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t\t\t\t<tr id=\'trcoll\'>\n\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADERCENTER\' colspan=\'5\' >Order Information</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t<tr id = \'numRows\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =">\n\t\t\t\t\t<td style=\'display:none\'> <input type= hidden value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" name=\'es_field_id";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'> </td>\t\t\n\t\t\t\t\t<td style=\'display:none\'> <input type= hidden value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" name=\'es_field_hidden_flag";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'> </td>\t\t\t\n\t\t\t\t\t<td style=\'display:none\'> <input type= hidden value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" name=\'es_field_fmt";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'> </td>\n\t\t\t\t\t<td style=\'display:none\'> <input type= hidden value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" name=\'es_field_type";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'> </td>\n\t\t\t\t\t<td class=\'gridData\'   > ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</td>\t\t\t\t\t\t\t\t\n\t\t\t\t\t<td class=\'Fields\'><input type=\"checkbox\"\n\t\t\t\t\t\t\t\t\t\t\t\t\tname=\'es_field_flag";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' id=\'es_field_flag";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'\n\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\tonclick=\'setHeadFootFields(";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =")\'>Yes/No</td>\t\n\t\t\t\t\t<td class=\'Fields\' ><input type=\"radio\"\n\t\t\t\t\t\t\t\t\t\t\t\t\tname=\'es_field_orient";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' id=\'es_field_orient";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' value=\"0\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =" ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =">Header</td>\n\t\t\t\t\t<td class=\'Fields\'><input type=\"radio\"\n\t\t\t\t\t\t\t\t\t\t\t\t\tname=\'es_field_orient";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' value=\"1\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =">Footer</td>\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t<td class=\'Fields\'><input type=\"text\"\n\t\t\t\t\t\t\t\t\t\t\t\t\tname=\'es_field_lbl";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' id=\'es_field_lbl";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\"\n\t\t\t\t\t\t\t\t\t\t\t\t\tsize=40 maxlength=40\n\t\t\t\t\t\t\t\t\t\t\t\t\tonkeypress=\"return CheckForSpecCharsWithSpaceBlur(event)\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="></td>\t\t\t\t\t\n\t\t\t\t\t</tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t</tbody>\n\t\t\t\t</table>\n\t\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\n\t\t<table class=\'grid\' align=\"center\" border=\"1\" cellpadding=\"1\" cellspacing=\"1\"\n\t\t\tstyle=\"width: 900px;\">\n\t\t\t<tbody>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'columnheadercenter\' colspan=\"4\">Signature Template&nbsp;</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'gridData\'>Signature Flag&nbsp;</td>\n\t\t\t\t\t<td class=\'Fields\'><input type=\"checkbox\"\n\t\t\t\t\t\t\t\t\tname=\"es_footer_sign_flag\" id=\"es_footer_sign_flag\"\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t\t\t\t\t\tonclick=\"setSignatureFields(0,this)\">Yes/No\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\'gridData\'>Signature Position&nbsp;</td>\n\t\t\t\t\t<td class=\'Fields\'><input type=\"radio\"\n\t\t\t\t\t\t\t\t\tname=\"es_footer_sign_posn\" id=\"es_footer_sign_posn\" value=\"0\"\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 =">End of each page&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t\t\t\t\t<input type=\"radio\"\n\t\t\t\t\t\t\t\t\tname=\"es_footer_sign_posn\" id=\"es_footer_sign_posn\" value=\"1\"\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 =">End of Report\n\t\t\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'columnheadercenter\' colspan=\"4\">Signature 1 Template&nbsp;</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'gridData\'>Signature 1 Required &nbsp;</td>\n\t\t\t\t\t<td class=\'Fields\'><input type=\"checkbox\"\n\t\t\t\t\t\t\t\t\tname=\"es_footer_sign_1_flag\" id=\"es_footer_sign_1_flag\" ";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t\t\t\t\t\t\tonclick=\"setSignatureFields(1,this)\">Yes/No\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\'gridData\'>Label&nbsp;</td>\n\t\t\t\t\t<td class=\'Fields\'><input type=\"text\"\n\t\t\t\t\t\t\t\t\tname=\"es_footer_sign_1_label\" id=\"es_footer_sign_1_label\" value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\"\n\t\t\t\t\t\t\t\t\tsize=30 maxlength=30\n\t\t\t\t\t\t\t\t\tonkeypress=\"return CheckForSpecCharsWithSpaceBlur(event)\"\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 =">\n\t\t\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'gridData\'>Select Practioner Type&nbsp;</td>\n\t\t\t\t\t<td class=\'Fields\'><select name=\'es_footer_sign_1_practid\' id=\'es_footer_sign_1_practid\'\n\t\t\t\t\t\t\t\t\tonchange=\'mainGroupType(this)\' ";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 =" \n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 =">\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t<option value=0> -------------\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="-------------\t</option>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t<script>\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\tvar tempObjName = \'es_footer_sign_1_practid\';\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\tif (\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\' > 0 )\n\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\tvar selTempObj = document.getElementById(tempObjName);\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\tfor(var i=0;i<selTempObj.options.length;i++){\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t            if (selTempObj.options[i].value == \'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\') {\n\t\t\t\t\t\t\t\t            \tselTempObj.selectedIndex = i;\n\t\t\t\t\t\t\t\t                break;\n\t\t\t\t\t\t\t\t            }\n\t\t\t\t\t\t\t\t        }\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\'gridData\'>Speciality Flag&nbsp;</td>\n\t\t\t\t\t<td class=\'Fields\'> <input type=\"checkbox\"\n\t\t\t\t\t\t\t\t\tname=\"es_footer_sign_1_splty\" id=\"es_footer_sign_1_splty\"\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 =">Yes/No\n\t\t\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'columnheadercenter\' colspan=\"4\">Signature 2 Template&nbsp;</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'gridData\'>Signature Required &nbsp;</td>\n\t\t\t\t\t<td class=\'Fields\'><input type=\"checkbox\"\n\t\t\t\t\t\t\t\t\tname=\"es_footer_sign_2_flag\" id=\"es_footer_sign_2_flag\" ";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t\t\t\t\t\t\t\tonclick=\"setSignatureFields(2,this)\">Yes/No\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\'gridData\'>Label&nbsp;</td>\n\t\t\t\t\t<td class=\'Fields\'><input type=\"text\"\n\t\t\t\t\t\t\t\t\tname=\"es_footer_sign_2_label\" id=\"es_footer_sign_2_label\" value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 =">\n\t\t\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'gridData\'>Select Practioner Type&nbsp;</td>\n\t\t\t\t\t<td class=\'Fields\'><select name=\'es_footer_sign_2_practid\' id=\'es_footer_sign_2_practid\'\n\t\t\t\t\t\t\t\t\tonchange=\'mainGroupType(this)\' ";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\tvar tempObjName = \'es_footer_sign_2_practid\';\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\tif (\'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\') {\n\t\t\t\t\t\t\t\t            \tselTempObj.selectedIndex = i;\n\t\t\t\t\t\t\t\t                break;\n\t\t\t\t\t\t\t\t            }\n\t\t\t\t\t\t\t\t        }\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\'gridData\'>Speciality Flag&nbsp;</td>\n\t\t\t\t\t<td class=\'Fields\'><input type=\"checkbox\"\n\t\t\t\t\t\t\t\t\tname=\"es_footer_sign_2_splty\" id=\"es_footer_sign_2_splty\"\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 =">Yes/No\n\t\t\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'columnheadercenter\' colspan=\"4\">Signature 3 Template&nbsp;</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'gridData\'>Signature Required &nbsp;</td>\n\t\t\t\t\t<td class=\'Fields\'><input type=\"checkbox\"\n\t\t\t\t\t\t\t\t\tname=\"es_footer_sign_3_flag\" id=\"es_footer_sign_3_flag\" ";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t\t\t\t\t\t\t\tonclick=\"setSignatureFields(3,this)\">Yes/No\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\'gridData\'>Label&nbsp;</td>\n\t\t\t\t\t<td class=\'Fields\'><input type=\"text\"\n\t\t\t\t\t\t\t\t\tname=\"es_footer_sign_3_label\" id=\"es_footer_sign_3_label\" value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 =">\n\t\t\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'gridData\'>Select Practitioner Type&nbsp;</td>\n\t\t\t\t\t<td class=\'Fields\'><select name=\'es_footer_sign_3_practid\' id=\'es_footer_sign_3_practid\'\n\t\t\t\t\t\t\t\t\tonchange=\'mainGroupType(this)\' ";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\tvar tempObjName = \'es_footer_sign_3_practid\';\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\tif (\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\') {\n\n\t\t\t\t\t\t\t\t            \tselTempObj.selectedIndex = i;\n\t\t\t\t\t\t\t\t                break;\n\t\t\t\t\t\t\t\t            }\n\t\t\t\t\t\t\t\t        }\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\'gridData\'>Speciality Flag&nbsp;</td>\n\t\t\t\t\t<td class=\'Fields\'><input type=\"checkbox\"\n\t\t\t\t\t\t\t\t\tname=\"es_footer_sign_3_splty\" id=\"es_footer_sign_3_splty\"\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 =">Yes/No\n\t\t\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t</tbody>\n\t\t</table>\n\t\t<!-- Header & Footer Preview Buttons -->\n\t\t<table class=\'grid\' align=\"center\" border=\"1\" cellpadding=\"1\" cellspacing=\"1\"\n\t\t\tstyle=\"width: 900px;\">\n\t\t\t<tbody>\n\t\t\t\t<tr>\t\t\t\t\t\n\t\t\t\t\t<td>\n\t\t\t\t\t\t<input type=\"button\" name=\"search\" id=\"search\" value=\"Page Header Preview\" onClick=\"showHeaderHtml();\"  class=\"button\">\n\t\t\t\t\t</td>\n\t\t\t\t\t<td>\n\t\t\t\t\t\t<input type=\"button\" name=\"search\" id=\"search\" value=\"Page Footer Preview\" onClick=\"showFooterHtml();\"  class=\"button\">\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t\n\t\t\t</tbody>\n\t\t</table>\n\t\t\n\t\t<br>\n\t\t<br>\n\t\t<br>\n\t\t\t\t\t\n\n\t\t<input type=hidden name=\"mode\" id=\"mode\" value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\"> \n\t\t<input type=hidden name=\"es_summ_code\" id=\"es_summ_code\" value=";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 =">\n\t\t<input type=hidden name=\"fieldsCount\" id=\"fieldsCount\" value=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\"> \n\t\t<input type=hidden name=\"fieldsValue\" id=\"fieldsValue\" value=\"\"> \n\t\t<input type=hidden name=\"flag\" id=\"flag\" value=\"true\">\n\t\t\n\t\t<input type=hidden name=\"hiddenHeaderOrient\" id=\"hiddenHeaderOrient\" value=\"\"> \n\t\t<input type=hidden name=\"hiddenColorIndicate\" id=\"hiddenColorIndicate\" value=\"\"> \n\t\t<input type=hidden name=\"hiddenTblCellColFill\" id=\"hiddenTblCellColFill\" value=\"\"> \n\t\t<input type=hidden name=\"hiddenTblCellBorFill\" id=\"hiddenTblCellBorFill\" value=\"\"> \n\t\t<input type=hidden name=\"hiddenFooterSignFlag\" id=\"hiddenFooterSignFlag\" value=\"\"> \n\t\t<input type=hidden name=\"hiddenFooterSignPosn\" id=\"hiddenFooterSignPosn\" value=\"\"> \n\t\t\n\t\t<input type=hidden name=\"hiddenFooterSign1Flag\" id=\"hiddenFooterSign1Flag\" value=\"\"> \n\t\t<input type=hidden name=\"hiddenFooterSign1Lbl\" id=\"hiddenFooterSign1Lbl\" value=\"\"> \n\t\t<input type=hidden name=\"hiddenFooterSign1Pract\" id=\"hiddenFooterSign1Pract\" value=\"\"> \n\t\t<input type=hidden name=\"hiddenFooterSign1Splty\" id=\"hiddenFooterSign1Splty\" value=\"\"> \n\t\t\n\t\t<input type=hidden name=\"hiddenFooterSign2Flag\" id=\"hiddenFooterSign2Flag\" value=\"\"> \n\t\t<input type=hidden name=\"hiddenFooterSign2Lbl\" id=\"hiddenFooterSign2Lbl\" value=\"\"> \n\t\t<input type=hidden name=\"hiddenFooterSign2Pract\" id=\"hiddenFooterSign2Pract\" value=\"\"> \n\t\t<input type=hidden name=\"hiddenFooterSign2Splty\" id=\"hiddenFooterSign2Splty\" value=\"\">\n\t\t\n\t\t<input type=hidden name=\"hiddenFooterSign3Flag\" id=\"hiddenFooterSign3Flag\" value=\"\"> \n\t\t<input type=hidden name=\"hiddenFooterSign3Lbl\" id=\"hiddenFooterSign3Lbl\" value=\"\"> \n\t\t<input type=hidden name=\"hiddenFooterSign3Pract\" id=\"hiddenFooterSign3Pract\" value=\"\"> \n\t\t<input type=hidden name=\"hiddenFooterSign3Splty\" id=\"hiddenFooterSign3Splty\" value=\"\">\n\t\t\n\t\t<input type=hidden name=\"headerValue\" id=\"headerValue\" value=\"\"> \n\t\t<input type=hidden name=\"footerValue\" id=\"footerValue\" value=\"\"> \n\t</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            _bw.write(_wl_block0Bytes, _wl_block0);

/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
24/09/2014     		1   		Sethuraman      Created for Configuring Summary Layout  
-------------------------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
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
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
	String mode="";
	String readOnly = "";
	String status = "";		
	String signatureStatus = "";		
	
	int nSummLayoutHdrListsize = 0;
	int nSummLayoutFieldsListsize = 0;
	
	int iHeaderOrient = 0; 
	int iColorsIndicate = 0; 
	int iTabcellColFill = 0;  
	int iTabCellBorFill = 0;  
	
	int iFooterSignFlag = 0;  
	int iFooterSignPosn = 0;  
	int iFooterSign1Flag = 0;  
	String sFooterSign1Lbl = ""; 
	int iFooterSign1PractID = 0;  
	int iFooterSign1Splty = 0;  
	int iFooterSign2Flag = 0;  
	String sFooterSign2Lbl = "";  
	int iFooterSign2PractID = 0;  
	int iFooterSign2Splty = 0;  
	int iFooterSign3Flag = 0;  
	String sFooterSign3Lbl = "";  
	int iFooterSign3PractID = 0;  
	int iFooterSign3Splty = 0; 
	
	int iFooterDigitSign = 0; 
	
	int iFieldFlag = 0, iFieldOrient = 0;
	String sFieldId = "", sFieldName="", sFieldLbl = "", sFieldFmt = "", sFieldType = "";
	
	int iFacilityTypeFlag = 0, iPatientTypeFlag = 0, iOrderTypeFlag = 0;
	
	int iFieldsCount = 0;
	
	String enabled_checked1="";
	
	String sHeaderCode = "";
	String sFooterCode = "";
	
	String sSummaryCode = "";
	String sSummaryDesc = "";

	String enabled_checked="";
	
	String disabledStatus = "disabled";
	
	mode = (request.getParameter("mode")==null)?"":request.getParameter("mode");
	
	EncSummGroup summGrpDetails = new EncSummGroup(); 		
	
	List<EncSummLayoutHdrBean> oSummLayoutHdrList = null;
	EncSummLayoutHdrBean sSummLayoutHdrBean = null;	
	
	List<EncSummLayoutFieldsBean> oSummLayoutFieldsList = null;
	EncSummLayoutFieldsBean sSummLayoutFieldsBean = null;	
	
	EncSummLayoutHdrBean oSummLayoutHdrBean = null;
	EncSummLayoutFieldsBean oSummLayoutFieldsBean = null;
	
	
	String practType = "";
	practType = practType + "<option value=1>Attending Practitioner</option>";
	practType = practType + "<option value=2>Admitting Practitioner</option>";
	practType = practType + "<option value=3>Authorised By</option>";
	
	if(mode.trim().equalsIgnoreCase("insert")){	
		
		oSummLayoutHdrList = new ArrayList<EncSummLayoutHdrBean>();
		sSummLayoutHdrBean = new EncSummLayoutHdrBean();
		
		oSummLayoutFieldsList = new ArrayList<EncSummLayoutFieldsBean>();
		sSummLayoutFieldsBean = new EncSummLayoutFieldsBean();
		
		sSummaryCode = (request.getParameter("summaryCode")==null)?"":request.getParameter("summaryCode");		
		
		sSummLayoutHdrBean.setRequest(request);		
		sSummLayoutHdrBean.setsSummaryCode(sSummaryCode);
		
		sSummLayoutFieldsBean.setRequest(request);		
		sSummLayoutFieldsBean.setsSummaryCode(sSummaryCode);
		
		oSummLayoutHdrList = summGrpDetails.getLayoutHeader(sSummLayoutHdrBean);
		nSummLayoutHdrListsize = oSummLayoutHdrList.size();
		if (nSummLayoutHdrListsize>0)
		{			
			
			oSummLayoutHdrBean = oSummLayoutHdrList.get(nSummLayoutHdrListsize-1);		
			
			iHeaderOrient 	= oSummLayoutHdrBean.getiHeaderOrient();
			iColorsIndicate = oSummLayoutHdrBean.getiColorsIndicate();
			iTabcellColFill = oSummLayoutHdrBean.getiTabcellColFill();  
			iTabCellBorFill = oSummLayoutHdrBean.getiTabCellBorFill();  
			
			iFooterSignFlag 	= oSummLayoutHdrBean.getiFooterSignFlag();  
			iFooterSignPosn 	= oSummLayoutHdrBean.getiFooterSignPosn();  
			iFooterSign1Flag 	= oSummLayoutHdrBean.getiFooterSign1Flag();  
			sFooterSign1Lbl 	= oSummLayoutHdrBean.getsFooterSign1Lbl(); 
			iFooterSign1PractID = oSummLayoutHdrBean.getiFooterSign1PractID();  
			iFooterSign1Splty 	= oSummLayoutHdrBean.getiFooterSign1Splty();  
			iFooterSign2Flag 	= oSummLayoutHdrBean.getiFooterSign2Flag();  
			sFooterSign2Lbl 	= oSummLayoutHdrBean.getsFooterSign2Lbl();  
			iFooterSign2PractID = oSummLayoutHdrBean.getiFooterSign2PractID();  
			iFooterSign2Splty 	= oSummLayoutHdrBean.getiFooterSign2Splty();  
			iFooterSign3Flag 	= oSummLayoutHdrBean.getiFooterSign3Flag();  
			sFooterSign3Lbl 	= oSummLayoutHdrBean.getsFooterSign3Lbl();  
			iFooterSign3PractID = oSummLayoutHdrBean.getiFooterSign3PractID();  
			iFooterSign3Splty 	= oSummLayoutHdrBean.getiFooterSign3Splty(); 
			
			iFooterDigitSign 	= oSummLayoutHdrBean.getiFooterDigitSign(); 
			
			sHeaderCode 		= oSummLayoutHdrBean.getsHeaderCode();
			sFooterCode			= oSummLayoutHdrBean.getsFooterCode();
			
		}
		
	}
	
	if (iFooterSignFlag == 1)
	{
		signatureStatus = "enabled";
	}
	else
	{
		signatureStatus = "disabled";
	}

	if(mode.trim().equalsIgnoreCase("update")) 
	{
		status="disabled" ;readOnly = "readonly"; 
	}
	else if(mode.trim().equalsIgnoreCase("insert"))
	{
		status = "enabled"; 
		readOnly = "";
	}
	else
	{
		status = "disabled"; 
		readOnly = "readonly";
	}


            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf( iHeaderOrient == 0 ? "checked='checked'" : "" ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf( iHeaderOrient == 1 ? "checked='checked'" : "" ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf( iColorsIndicate == 1 ? "checked" : "" ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf( iTabcellColFill == 1 ? "checked" : "" ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf( iTabCellBorFill == 1 ? "checked" : "" ));
            _bw.write(_wl_block12Bytes, _wl_block12);

			oSummLayoutFieldsList = summGrpDetails.getLayoutDetails(sSummLayoutFieldsBean);
			nSummLayoutFieldsListsize = oSummLayoutFieldsList.size();
			
			if (nSummLayoutFieldsListsize>0){
				
            _bw.write(_wl_block13Bytes, _wl_block13);

				
				for (int i=0; i<oSummLayoutFieldsList.size(); i++) {
					oSummLayoutFieldsBean = oSummLayoutFieldsList.get(i);
					sFieldId = oSummLayoutFieldsBean.getsFieldId();
					sFieldName = oSummLayoutFieldsBean.getsFieldName();
					iFieldFlag = oSummLayoutFieldsBean.getiFieldFlag();
					iFieldOrient = oSummLayoutFieldsBean.getiFieldOrient();
					sFieldLbl = oSummLayoutFieldsBean.getsFieldLabel();
					sFieldFmt = oSummLayoutFieldsBean.getsFieldFormat();
					sFieldType = oSummLayoutFieldsBean.getsFieldType();
					iFieldsCount = iFieldsCount + 1;
					
            _bw.write(_wl_block14Bytes, _wl_block14);

					
						if (iFacilityTypeFlag == 0){
							
							if (sFieldType.equalsIgnoreCase("f")) 
							{
								
            _bw.write(_wl_block15Bytes, _wl_block15);

								
								iFacilityTypeFlag = 1;								
							}
							
						}
						if (iPatientTypeFlag == 0){
							
							if (sFieldType.equalsIgnoreCase("p")) 
							{
								
            _bw.write(_wl_block16Bytes, _wl_block16);

								
								iPatientTypeFlag = 1;								
							}
							
						}
						if (iOrderTypeFlag == 0){
							
							if (sFieldType.equalsIgnoreCase("o") ) 
							{
								
            _bw.write(_wl_block17Bytes, _wl_block17);

								
								iOrderTypeFlag = 1;								
							}
							
						}
					
					
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(i));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(sFieldId));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(iFieldFlag));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(sFieldFmt));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(sFieldType));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(i));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(sFieldName));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(i));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf( iFieldFlag == 1 ? "checked" : "" ));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(i));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf( iFieldOrient == 0 ? "checked='checked'" : "" ));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf( iFieldFlag == 0 ? "disabled" : "" ));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf( sFieldType.equalsIgnoreCase("p") ? "disabled" : "" ));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf( iFieldOrient == 1 ? "checked='checked'" : "" ));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf( iFieldFlag == 0 ? "disabled" : "" ));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf( sFieldType.equalsIgnoreCase("p") ? "disabled" : "" ));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(sFieldLbl));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf( iFieldFlag == 0 ? "disabled" : "" ));
            _bw.write(_wl_block43Bytes, _wl_block43);
 
				}
				
				
            _bw.write(_wl_block44Bytes, _wl_block44);
	
			}
		
		
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf( iFooterSignFlag == 1 ? "checked" : "" ));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf( iFooterSignPosn == 0 ? "checked='checked'" : "" ));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf( iFooterSignFlag == 0 ? "disabled" : "" ));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf( iFooterSignPosn == 1 ? "checked='checked'" : "" ));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf( iFooterSignFlag == 0 ? "disabled" : "" ));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(signatureStatus ));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf( iFooterSign1Flag == 1 ? "checked" : "" ));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(sFooterSign1Lbl));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf( iFooterSign1Flag == 0 ? "disabled" : "" ));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf( status));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf( iFooterSign1Flag == 0 ? "disabled" : "" ));
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(practType));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(iFooterSign1PractID));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(iFooterSign1PractID));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf( iFooterSign1Splty == 1 ? "checked" : "" ));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf( iFooterSign1Flag == 0 ? "disabled" : "" ));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(signatureStatus ));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf( iFooterSign2Flag == 1 ? "checked" : "" ));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(sFooterSign2Lbl));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf( iFooterSign2Flag == 0 ? "disabled" : "" ));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf( status));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf( iFooterSign2Flag == 0 ? "disabled" : "" ));
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(practType));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(iFooterSign2PractID));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(iFooterSign2PractID));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf( iFooterSign2Splty == 1 ? "checked" : "" ));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf( iFooterSign2Flag == 0 ? "disabled" : "" ));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(signatureStatus ));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf( iFooterSign3Flag == 1 ? "checked" : "" ));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(sFooterSign3Lbl));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf( iFooterSign3Flag == 0 ? "disabled" : "" ));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf( status));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf( iFooterSign3Flag == 0 ? "disabled" : "" ));
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(practType));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(iFooterSign3PractID));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(iFooterSign3PractID));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf( iFooterSign3Splty == 1 ? "checked" : "" ));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf( iFooterSign3Flag == 0 ? "disabled" : "" ));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(sSummaryCode));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(iFieldsCount));
            _bw.write(_wl_block72Bytes, _wl_block72);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
