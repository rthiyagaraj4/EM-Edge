package jsp_servlet._ers._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.*;
import eRS.*;
import eCommon.Common.*;
import java.util.*;
import com.ehis.util.*;

public final class __shiftpatternaddmodify extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ers/jsp/ShiftPatternAddModify.jsp", 1709121653105L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/Common.jsp", 1723025507010L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block3 =" \n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n<head>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<!-- <script language=\"JavaScript\" src=\"../js/RSMessages.js\"></script>\n<script language=\"JavaScript\" src=\"../../eCommon/js/messages.js\"></script> -->\n<!-- <script language=\"javascript\" src=\"../../eCommon/js/MstCodeCommon.js\"></script>\n --><script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\"javascript\" src=\"../js/ShiftPattern.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<body  onload=\'FocusFirstElement()\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" >\n<form name=form_add_mod action=\'../../servlet/eRS.ShiftPatternServlet\' method=\'POST\'\ntarget=\'messageFrame\'>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n\t<table width=\'100%\' cellspacing=\'0\' cellpadding=\'0\' border=\'0\'>\n\t\t<tr><td colspan=2>&nbsp;</td></tr>\n\t\t<tr>\n\t\t\t<td class=\'label\' width=\'30%\' align=\'right\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t\t\t<td width=\'70%\' align=\'left\'>&nbsp;&nbsp;&nbsp;<input type=\'text\' size=\'15\' maxlength=\'10\' value=\'\' name=\'shift_pattern_id\' id=\'shift_pattern_id\' onKeyPress=\"return CheckForSpecChars(event);\" >&nbsp;<img src=\"../../eCommon/images/mandatory.gif\"></td>\n\t\t</tr>\n\t\t<tr><td colspan=2>&nbsp;</td></tr>\n\t\t<tr>\n\t\t\t<td class=\'label\' width=\'30%\' align=\'right\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t\t<td width=\'70%\' align=\'left\'>&nbsp;&nbsp;&nbsp;<input type=\'text\' size=\'20\' maxlength=\'15\' value=\'\' name=\'shift_short_desc\' id=\'shift_short_desc\'onKeyPress=\"return CheckForSpecCharsAllCase(event);\" >&nbsp;<img src=\"../../eCommon/images/mandatory.gif\"></td>\n\t\t</tr>\n\t\t<tr><td colspan=2>&nbsp;</td></tr>\n\t\t<tr>\n\t\t\t<td class=\'label\' width=\'30%\' align=\'right\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t\t\t<td width=\'70%\' align=\'left\'>&nbsp;&nbsp;&nbsp;<input type=\'text\' size=\'40\' maxlength=\'30\' value=\'\' name=\'shift_long_desc\' id=\'shift_long_desc\' onKeyPress=\"return CheckForSpecCharsAllCase(event);\">&nbsp;<img src=\"../../eCommon/images/mandatory.gif\"></td>\n\t\t</tr>\n\t\t<tr><td colspan=2>&nbsp;</td></tr>\n\t\t<tr>\n\t\t\t<td class=\'label\' width=\'30%\' align=\'right\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t\t<td width=\'70%\' align=\'left\'>&nbsp;&nbsp;&nbsp;<select name=\"locn_type\" id=\"locn_type\">\n\t\t\t\t\t<option value=\'\' selected>-------- ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =" ------- </option>\n\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t<option value=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</option>\n\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\t\t\t\t\t\n\t\t\t\t</select></td>\n\t\t</tr>\n\t\t<tr><td colspan=2>&nbsp;</td></tr>\n\t\t<tr>\n\t\t\t<td class=\'label\' width=\'30%\' align=\'right\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n\t\t\t<td width=\'70%\' align=\'left\'>&nbsp;&nbsp;<input type=\'checkbox\' value=\'N\' name=\'eff_status\' id=\'eff_status\' onclick=\'onenable(this);\'></td>\n\t\t</tr>\t\n\t\t<tr><td colspan=2><hr></td></tr>\n\t\t<tr>\n\t\t\t<td class=\'label\' width=\'30%\'><b>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =":</b></td>\n\t\t\t<td class=\'label\' width=\'70%\' align=\'left\'>&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n\t\t</tr>\n\t\t</table>\n\t\t<table width=\'100%\' cellspacing=\'0\' cellpadding=\'0\' border=\'0\'>\n\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\t\t\t\n\t\t\t\t<input type=\'hidden\' name=\'shift_id";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' id=\'shift_id";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'shift_desc";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' id=\'shift_desc";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'mnemonic_key";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' id=\'mnemonic_key";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'>\n\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t</table>\n\n\t<table width=\'100%\' cellspacing=\'0\' cellpadding=\'0\' align=\'center\' border=\'0\'>\t\n\t\t<input type=\'hidden\' name=\'week_count\' id=\'week_count\' value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'>\n\t\t<input type=\'hidden\' name=\'day_count\' id=\'day_count\' value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'>\n\t\t<tr><td colspan=10>&nbsp;</td></tr>\n\t\t<tr><td width=\'20%\'>&nbsp;</td><td width=\'11%\'>&nbsp;&nbsp;&nbsp;</td>\n\n\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t<td class=\'label\' width=\'7%\'><b>&nbsp;";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</b></td>";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\t\t\t\n\t\t\t<td width=\'24%\'>&nbsp;</td>\n\t\t\t</tr>\n\t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t<tr><td width=\'22%\'>&nbsp;</td><td class=\'label\' width=\'7%\'><b>";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</b> </td>\n\t\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t\t<td width=\'7%\'><input type=\'text\' name=\'shift_mnemonic";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' id=\'shift_mnemonic";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' size=\'2\' maxlength=\'1\' value=\'\' onkeypress=\'return check(";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 =",";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 =");\' onblur=\' check1(this,";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 =");\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'shift_code";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\' id=\'shift_code";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\' value=\'\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'day_no";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\' id=\'day_no";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\'></td>\n\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="<td width=\'24%\'>&nbsp;</td>";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t</tr>\n\n\t\t\t<tr><td colspan=10>&nbsp;</td></tr>\n\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\n\t\t<table width=\'100%\' cellspacing=\'0\' cellpadding=\'0\' border=\'0\'>\n\t\t<tr><td colspan=2>&nbsp;</td></tr>\n\t\t<tr>\n\t\t\t<td class=\'label\' width=\'30%\' align=\'right\'>";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</td>\n\t\t\t<td width=\'70%\' align=\'left\'>&nbsp;&nbsp;&nbsp;<input type=\'text\' size=\'15\' maxlength=\'10\' value=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\' name=\'shift_pattern_id\' readonly >&nbsp;<img src=\"../../eCommon/images/mandatory.gif\"></td>\n\t\t</tr>\n\n\t\t<tr><td colspan=2>&nbsp;</td></tr>\n\t\t<tr>\n\t\t\t<td class=\'label\' width=\'30%\' align=\'right\'>";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="</td>\n\t\t\t<td width=\'70%\' align=\'left\'>&nbsp;&nbsp;&nbsp;<input type=\'text\' size=\'20\' maxlength=\'15\' value=\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\'onKeyPress=\"return CheckForSpecCharsAllCase(event);\" name=\'shift_short_desc\' ";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 =">&nbsp;<img src=\"../../eCommon/images/mandatory.gif\"></td>\n\t\t</tr>\n\n\t\t<tr><td colspan=2>&nbsp;</td></tr>\n\t\t<tr>\n\t\t\t\n\t\t\t<td class=\'label\' width=\'30%\' align=\'right\'>";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="</td>\n\t\t\t<td width=\'70%\' align=\'left\'>&nbsp;&nbsp;&nbsp;<input type=\'text\' size=\'40\' maxlength=\'30\' value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\" ";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 =" onKeyPress=\"return CheckForSpecCharsAllCase(event);\" name=\'shift_long_desc\'>&nbsp;<img src=\"../../eCommon/images/mandatory.gif\"></td>\n\t\t</tr>\n\n\t\t<tr><td colspan=2>&nbsp;</td></tr>\n\t\t<tr>\n\t\t\t<td class=\'label\' width=\'30%\' align=\'right\'>";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="</td>\n\t\t\t<td width=\'70%\' align=\'left\'>&nbsp;&nbsp;&nbsp;<select name=\"locn_type\" id=\"locn_type\" ";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 =">\n\t\t\t\t<option value=\"\">-----";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="-----</option>\n\t\t\t\t\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\' selected>";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="</option>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\t\t\t\t\t\n\t\t\t\t</select></td>\n\t\t</tr>\n\n\t\t<tr><td colspan=2>&nbsp;</td></tr>\n\t\t<tr>\n\t\t\t<td class=\'label\' width=\'30%\' align=\'right\'>";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="</td>\n\t\t\t<td width=\'70%\' align=\'left\'>&nbsp;&nbsp;<input type=\'checkbox\' value=\'";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\' name=\'eff_status\' ";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 =" onclick=\'onenable(this);\'>\n\t\t\t<input type=hidden value=\'";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\' name=\'eff_status1\' ></td>\n\t\t</tr>\t\n\t\t<tr><td colspan=2><hr></td></tr>\n\t\t<tr>\n\t\t\t<td class=\'label\' width=\'30%\'><b>";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 =":</b></td>\n\t\t\t<td class=\'label\' width=\'70%\' align=\'left\'>";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="</td>\n\t\t</tr>\n\n\t\t<tr><td colspan=2><b>";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="</b></td></tr>\n\t\t</table>\n\n\t\t<table width=\'100%\' cellspacing=\'0\' cellpadding=\'0\' border=\'0\'>\n\t\t";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t</table>\n\n\t\t<table width=\'100%\' cellspacing=\'0\' cellpadding=\'0\' align=\'center\' border=\'0\'>\t\n\t\t\t<tr><td colspan=10>&nbsp;</td></tr>\n\t\t\t<input type=\'hidden\' name=\'week_count\' id=\'week_count\' value=\'";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\'>\n\t\t\t<input type=\'hidden\' name=\'day_count\' id=\'day_count\' value=\'";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\'>\n\t\t\t<tr><td width=\'22%\'>&nbsp;</td><td width=\'11%\'>&nbsp;</td>\n\n\t\t\t\t";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t\t\t\t<td class=\'label\' width=\'7%\'><b>&nbsp;";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\t\t\t<td width=\'24%\'>&nbsp;</td></tr>\t\n\t\t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\t\t\t\t<tr><td width=\'20%\'>&nbsp;</td><td class=\'label\' width=\'7%\'><b>";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="</b> </td>\n\n\t\t\t\t";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n\n\t\t\t\t\t<td width=\'7%\'><input type=\'text\' name=\'shift_mnemonic";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\' size=\'2\' maxlength=\'1\' value=\'";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\' ";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="  onkeypress=\'return check(";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'update";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\' id=\'update";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\' value=\'U\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'day_no";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\'></td>\n\n\t\t\t\t";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\' size=\'2\' maxlength=\'1\' value=\'\' ";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\' value=\'\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'update";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\' value=\'I\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'day_no";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\'></td>\n\n\t\t\t";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="<td width=\'24%\'>&nbsp;</td>\n\t\t\t";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\n\n\t\t\t\t<td class=\'label\' width=\'7%\'><b>&nbsp;";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\t\t\t<td width=\'24%\'>&nbsp;</td></tr>\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\n\t\t\t</tr>\n\t\t\t<tr><td colspan=10>&nbsp;</td></tr>\n\t";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\n</table>\n<input type=\'hidden\' name=\'mode\' id=\'mode\' value=\'";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\'>\n<input type=\'hidden\' name=\'function_id\' id=\'function_id\' value=\'";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\'>\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);

	eCommon.Common.CommonMultipleHandler mh = null ;
	try {
		if(session.getAttribute("mh" ) == null  ) {
			mh = new  eCommon.Common.CommonMultipleHandler();
			session.setAttribute( "mh",mh ) ;
		}
        else {
            mh = ( eCommon.Common.CommonMultipleHandler )session.getAttribute("mh" ) ;
        }
    } catch(Exception e) {
		session.removeValue("mh") ;
		mh = new  eCommon.Common.CommonMultipleHandler();
		session.setAttribute( "mh",mh ) ;    
    }

            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);

request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	String mode	       = request.getParameter("mode") ;
	String function_id = request.getParameter( "function_id") ;
	String facility_id = (String)session.getAttribute("facility_id");
	//System.err.println("facility_id----->"+facility_id);
	Connection conn 		= null;
	PreparedStatement pstmt = null;
	ResultSet resultSet 	= null;

	ArrayList Locn_Data		= new ArrayList() ;
	ArrayList Shift_Data	= new ArrayList() ;
	ArrayList Week_Days		= new ArrayList();

	String[] record				= null;
	String locn_id	="";
	String locn_shortdesc="";
	String work_cycle="";
	String week_basis="";
	int week_count=0;
	char ch=' ';

	//String sql_locn="select locn_type, short_desc from am_care_locn_type order by short_desc";
	String sql_locn="select locn_type, short_desc from am_care_locn_type_lang_vw where language_id = ? order by short_desc";

	//String sql_shift="select shift_code, short_desc, mnemonic_key from am_shift where eff_status ='E' and shift_indicator in ('P','U')";
	String sql_shift="select shift_code, short_desc, mnemonic_key from am_shift_lang_vw where eff_status ='E' and shift_indicator in ('P','U') and language_id = ?";

	String sql_work_cycle="select facility_id,work_cycle_basis from rs_parameter where facility_id in   (select facility_id from rs_parameter where facility_id = ?  union select facility_id from rs_parameter   where facility_id = '*A' and not exists (select facility_id from rs_parameter where facility_id = ?))";
	String sql_week_days="Select day_no, initcap (substr( day_of_week,1,3) ) day_of_week from sm_day_of_week order by day_no";

	conn = ConnectionManager.getConnection(request);
	try {
		//to get the locantion type
		pstmt = conn.prepareStatement( sql_locn);
		pstmt.setString(1,locale);
		resultSet = pstmt.executeQuery() ;
		while (resultSet != null && resultSet.next()) {
			record = new String[2];				
			record[0] = resultSet.getString("locn_type");
			record[1] = resultSet.getString("short_desc");
			Locn_Data.add(record) ;
		}
		if(resultSet!=null) resultSet.close() ;
		if(pstmt!=null) pstmt.close() ;

		//to get the shift_code & desc
		pstmt = conn.prepareStatement( sql_shift);
		pstmt.setString(1,locale);
		resultSet = pstmt.executeQuery() ;
		while (resultSet != null && resultSet.next()) {
			record = new String[3];				
			record[0] = resultSet.getString("shift_code");
			record[1] = resultSet.getString("short_desc");
			record[2] = resultSet.getString("mnemonic_key");
			Shift_Data.add(record) ;
		}
		if(resultSet!=null) resultSet.close() ;
		if(pstmt!=null) pstmt.close() ;

		//to get work_cycle_basis
		pstmt = conn.prepareStatement( sql_work_cycle);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,facility_id);
		resultSet = pstmt.executeQuery() ;
		while (resultSet != null && resultSet.next()) {
			work_cycle=resultSet.getString("work_cycle_basis");
			//System.err.println("work_cycle---------line 81--->"+work_cycle);
		}
        if(resultSet!=null) resultSet.close() ;
		if(pstmt!=null) pstmt.close() ;

		//to get the week days legend
		pstmt = conn.prepareStatement( sql_week_days);
		resultSet = pstmt.executeQuery();
		while (resultSet != null && resultSet.next()) {
			record = new String[2];				
			record[0] = resultSet.getString("day_no");
			record[1] = resultSet.getString("day_of_week");
			Week_Days.add(record);
		}
		if(resultSet!=null) resultSet.close() ;
		if(pstmt!=null) pstmt.close() ;
	
		int total_locns=Locn_Data.size();
		week_count = Integer.parseInt(work_cycle.substring(0,1));
		ch = work_cycle.charAt(1);

		if(ch == 'M')
		{
			week_count = 5;
			week_basis = "Monthly";
		}
		else
		{
			week_basis = String.valueOf(week_count) + " Weekly";
		}

            _bw.write(_wl_block8Bytes, _wl_block8);
 if (mode.equals("1")){
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

						for(int i=0; i<total_locns;i++){
							record=(String[])Locn_Data.get(i);
							locn_id=record[0];
							locn_shortdesc=record[1];
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(locn_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(locn_shortdesc));
            _bw.write(_wl_block17Bytes, _wl_block17);
}
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(week_basis));
            _bw.write(_wl_block21Bytes, _wl_block21);

			for(int i=0;i<Shift_Data.size();i++){
			record=(String[]) Shift_Data.get(i); 
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(record[0]));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(record[1]));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(record[2]));
            _bw.write(_wl_block29Bytes, _wl_block29);
}
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(week_count));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(Week_Days.size()));
            _bw.write(_wl_block32Bytes, _wl_block32);
for(int i=0; i<Week_Days.size();i++){
			record=(String[])Week_Days.get(i);
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(record[1]));
            _bw.write(_wl_block34Bytes, _wl_block34);
}
            _bw.write(_wl_block35Bytes, _wl_block35);
for(int i=0; i<week_count;i++){
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block37Bytes, _wl_block37);
for(int j=0; j<Week_Days.size();j++){
				record=(String[])Week_Days.get(j);
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(Shift_Data.size()));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(i));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(j));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(Shift_Data.size()));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(i));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(j));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(record[0]));
            _bw.write(_wl_block47Bytes, _wl_block47);
}
            _bw.write(_wl_block48Bytes, _wl_block48);
}
            _bw.write(_wl_block49Bytes, _wl_block49);
}

	/**********************************************************************/
		else{
			String shift_pattern_id="";
			String long_desc="";
			String short_desc="";
			String locn_type="";
			String eff_status="";
			String enable="";
			String disable="";
			String readonly="";
			ArrayList Shift_Details=new ArrayList();
			String sql_shiftdata="select week_no, day_no, shift_code,shift_mnemonic from rs_shift_pattern_dtl where facility_id=? and shift_pattern_id=?";

			shift_pattern_id=((request.getParameter("shift_pattern_id")==null) ? "":request.getParameter("shift_pattern_id").trim());
			long_desc=((request.getParameter("long_desc")==null) ? "":request.getParameter("long_desc").trim());
			
			
			short_desc=((request.getParameter("short_desc")==null) ? "":request.getParameter("short_desc").trim());
			locn_type=((request.getParameter("locn_type")==null) ? "":request.getParameter("locn_type").trim());
			eff_status=((request.getParameter("eff_status")==null) ? "":request.getParameter("eff_status").trim());
			if(eff_status.equalsIgnoreCase("E"))
				enable = "checked";
			else{
				enable = "";
				disable="disabled";
				readonly="readonly";
			}
			pstmt = conn.prepareStatement( sql_shiftdata);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,shift_pattern_id);
			resultSet = pstmt.executeQuery() ;

			while (resultSet != null && resultSet.next()) {
				record = new String[4];				
				record[0] = resultSet.getString("week_no");
				record[1] = resultSet.getString("day_no");
				record[2] = resultSet.getString("shift_code");
				record[3] = resultSet.getString("shift_mnemonic");
				Shift_Details.add(record) ;
			}
		
            _bw.write(_wl_block50Bytes, _wl_block50);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(shift_pattern_id));
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(readonly));
            _bw.write(_wl_block55Bytes, _wl_block55);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(long_desc));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(readonly));
            _bw.write(_wl_block58Bytes, _wl_block58);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(disable));
            _bw.write(_wl_block60Bytes, _wl_block60);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block61Bytes, _wl_block61);

						for(int i=0; i<total_locns;i++){
							record=(String[])Locn_Data.get(i);
							locn_id=record[0];
							locn_shortdesc=record[1];
							if(locn_id.equalsIgnoreCase(locn_type)){ 
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(locn_id ));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(locn_shortdesc));
            _bw.write(_wl_block64Bytes, _wl_block64);
}else
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(locn_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(locn_shortdesc));
            _bw.write(_wl_block17Bytes, _wl_block17);
}
            _bw.write(_wl_block65Bytes, _wl_block65);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(eff_status));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(enable));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(eff_status));
            _bw.write(_wl_block69Bytes, _wl_block69);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(week_basis));
            _bw.write(_wl_block71Bytes, _wl_block71);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block72Bytes, _wl_block72);

			for(int i=0;i<Shift_Data.size();i++){
			record=(String[]) Shift_Data.get(i);
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(record[0]));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(record[1]));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(record[2]));
            _bw.write(_wl_block29Bytes, _wl_block29);
}
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(week_count));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(Week_Days.size()));
            _bw.write(_wl_block75Bytes, _wl_block75);
int l=0;
				String[] record1=null;
				if(!Shift_Details.isEmpty()){
					record1=(String[])Shift_Details.get(l++);
				for(int i=0; i<Week_Days.size();i++){
				record=(String[])Week_Days.get(i);
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(record[1]));
            _bw.write(_wl_block34Bytes, _wl_block34);
}
            _bw.write(_wl_block77Bytes, _wl_block77);
for(int i=0; i<week_count;i++){
            _bw.write(_wl_block78Bytes, _wl_block78);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block79Bytes, _wl_block79);
for(int j=0; j<Week_Days.size();j++){
				record=(String[])Week_Days.get(j);

				if((Integer.parseInt(record1[0])==(i+1))&&(Integer.parseInt(record1[1])==(j+1))){
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(record1[3]));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(readonly));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(Shift_Data.size()));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(i));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(j));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(Shift_Data.size()));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(i));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(j));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(record1[2]));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(record[0]));
            _bw.write(_wl_block87Bytes, _wl_block87);
if(l<Shift_Details.size())
					record1=(String[])Shift_Details.get(l++);
					}else{
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(readonly));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(Shift_Data.size()));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(i));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(j));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(Shift_Data.size()));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(i));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(j));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(record[0]));
            _bw.write(_wl_block91Bytes, _wl_block91);
}}
            _bw.write(_wl_block92Bytes, _wl_block92);
}}else{

				for(int i=0; i<Week_Days.size();i++){
				record=(String[])Week_Days.get(i);
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(record[1]));
            _bw.write(_wl_block34Bytes, _wl_block34);
}
            _bw.write(_wl_block94Bytes, _wl_block94);
for(int i=0; i<week_count;i++){
            _bw.write(_wl_block78Bytes, _wl_block78);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block79Bytes, _wl_block79);
for(int j=0; j<Week_Days.size();j++){
				record=(String[])Week_Days.get(j);
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(readonly));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(Shift_Data.size()));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(i));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(j));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(Shift_Data.size()));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(i));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(j));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(record[0]));
            _bw.write(_wl_block91Bytes, _wl_block91);
}
            _bw.write(_wl_block48Bytes, _wl_block48);
}}
            _bw.write(_wl_block95Bytes, _wl_block95);
}
	} catch ( Exception e )	{
		e.printStackTrace() ;
		throw e ;
	} finally {
		if(resultSet!=null) resultSet.close() ;
		if(pstmt!=null) pstmt.close() ;
		ConnectionManager.returnConnection(conn,request);
	}

            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block98Bytes, _wl_block98);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eRS.ShiftPatternID.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${rs_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.shortdescription.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.longdescription.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.locationtype.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.all.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enabled.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eRS.WorkCycleBasis.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${rs_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Week.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eRS.ShiftPatternID.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${rs_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag9(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag9 = null ;
        int __result__tag9 = 0 ;

        if (__tag9 == null ){
            __tag9 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag9);
        }
        __tag9.setPageContext(pageContext);
        __tag9.setParent(null);
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.shortdescription.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag9;
        __result__tag9 = __tag9.doStartTag();

        if (__result__tag9!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag9== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag9.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag9);
            return true;
        }
        _activeTag=__tag9.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag9);
        __tag9.release();
        return false;
    }

    private boolean _jsp__tag10(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag10 = null ;
        int __result__tag10 = 0 ;

        if (__tag10 == null ){
            __tag10 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag10);
        }
        __tag10.setPageContext(pageContext);
        __tag10.setParent(null);
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.longdescription.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag10;
        __result__tag10 = __tag10.doStartTag();

        if (__result__tag10!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag10== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag10.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag10);
            return true;
        }
        _activeTag=__tag10.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag10);
        __tag10.release();
        return false;
    }

    private boolean _jsp__tag11(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag11 = null ;
        int __result__tag11 = 0 ;

        if (__tag11 == null ){
            __tag11 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag11);
        }
        __tag11.setPageContext(pageContext);
        __tag11.setParent(null);
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.locationtype.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag11;
        __result__tag11 = __tag11.doStartTag();

        if (__result__tag11!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag11== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag11.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag11);
            return true;
        }
        _activeTag=__tag11.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag11);
        __tag11.release();
        return false;
    }

    private boolean _jsp__tag12(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag12 = null ;
        int __result__tag12 = 0 ;

        if (__tag12 == null ){
            __tag12 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag12);
        }
        __tag12.setPageContext(pageContext);
        __tag12.setParent(null);
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.all.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag12;
        __result__tag12 = __tag12.doStartTag();

        if (__result__tag12!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag12== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag12.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag12);
            return true;
        }
        _activeTag=__tag12.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag12);
        __tag12.release();
        return false;
    }

    private boolean _jsp__tag13(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag13 = null ;
        int __result__tag13 = 0 ;

        if (__tag13 == null ){
            __tag13 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag13);
        }
        __tag13.setPageContext(pageContext);
        __tag13.setParent(null);
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enabled.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag13;
        __result__tag13 = __tag13.doStartTag();

        if (__result__tag13!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag13== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag13.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag13);
            return true;
        }
        _activeTag=__tag13.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag13);
        __tag13.release();
        return false;
    }

    private boolean _jsp__tag14(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag14 = null ;
        int __result__tag14 = 0 ;

        if (__tag14 == null ){
            __tag14 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag14);
        }
        __tag14.setPageContext(pageContext);
        __tag14.setParent(null);
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eRS.WorkCycleBasis.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${rs_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag14;
        __result__tag14 = __tag14.doStartTag();

        if (__result__tag14!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag14== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag14.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag14);
            return true;
        }
        _activeTag=__tag14.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag14);
        __tag14.release();
        return false;
    }

    private boolean _jsp__tag15(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag15 = null ;
        int __result__tag15 = 0 ;

        if (__tag15 == null ){
            __tag15 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag15);
        }
        __tag15.setPageContext(pageContext);
        __tag15.setParent(null);
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eRS.Shifts.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${rs_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag15;
        __result__tag15 = __tag15.doStartTag();

        if (__result__tag15!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag15== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag15.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag15);
            return true;
        }
        _activeTag=__tag15.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag15);
        __tag15.release();
        return false;
    }

    private boolean _jsp__tag16(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag16 = null ;
        int __result__tag16 = 0 ;

        if (__tag16 == null ){
            __tag16 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag16);
        }
        __tag16.setPageContext(pageContext);
        __tag16.setParent(null);
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Week.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag16;
        __result__tag16 = __tag16.doStartTag();

        if (__result__tag16!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag16== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag16.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag16);
            return true;
        }
        _activeTag=__tag16.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag16);
        __tag16.release();
        return false;
    }

    private boolean _jsp__tag17(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag17 = null ;
        int __result__tag17 = 0 ;

        if (__tag17 == null ){
            __tag17 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag17);
        }
        __tag17.setPageContext(pageContext);
        __tag17.setParent(null);
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Week.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag17;
        __result__tag17 = __tag17.doStartTag();

        if (__result__tag17!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag17== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag17.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag17);
            return true;
        }
        _activeTag=__tag17.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag17);
        __tag17.release();
        return false;
    }
}
