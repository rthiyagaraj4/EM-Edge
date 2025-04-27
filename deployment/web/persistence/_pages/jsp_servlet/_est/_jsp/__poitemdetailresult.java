package jsp_servlet._est._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eST.*;
import eST.Common.*;
import java.util.*;
import eCommon.Common.*;
import java.text.*;
import java.sql.*;
import webbeans.eCommon.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __poitemdetailresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/est/jsp/POItemDetailResult.jsp", 1709122117104L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="<!-- Modified for IN:071539 -->\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html> \n\t<head>\n\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' ></link>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eST/js/StCommon.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/messages.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eST/js/StMessages.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eST/js/GoodsReceivedNote.js\"></script>\n    \t<script language=\'javascript\' src=\'../../eST/js/StTransaction.js\'></script>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t<script>\n\t\t\t\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\"));\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t<base target=_self>\n\t</head>\n<body>\n\t<form name= \"formPOItemDetailResult\">\n\n\t<table border=\'1\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' align=center>\n        <tr><th align=\'center\' >";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</th></tr>\n\t</table>\t\n\t\n\t<input type=\"hidden\" name=\"store_code\" id=\"store_code\" value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\">\n\t<input type=\"hidden\" name=\"selected_doc_no\" id=\"selected_doc_no\" value=\"\">\n\t<input type=\"hidden\" name=\"sel_doc_batch_count\" id=\"sel_doc_batch_count\" value=\"\">\n\t<input type=\"hidden\" name=\"prev_ind\" id=\"prev_ind\" value=\"\">\n\t<input type=\"hidden\" name=\"total\" id=\"total\" value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\">\n\t<input type=\"hidden\" name=\"phy_inv_id\" id=\"phy_inv_id\" value=\"\">\n\t<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\n\t<input type=\"hidden\" name=\"qty_override_yn\" id=\"qty_override_yn\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\n\t<input type=\"hidden\" name=\"sys_date\" id=\"sys_date\" value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\n\t<input type=\"hidden\" name=\"multi_selct_appl_chk\" id=\"multi_selct_appl_chk\" value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'><!-- Added for IN:071539 -->\n\n\t<div style=\"overflow:scroll;height:380px;width:100%;overflow:auto\">     \n\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\n\t<table  border = \'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' align=center>\n\t\t<tr>\n\t\t<td align=\'left\' width=\'20%\'><input type=\"radio\" name=\"doc_no_radio\" id=\"doc_no_radio\" id=\"doc_no_radio\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\"  onClick=\'enable_doc(this, \"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\",\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\",\"P\");\'  >\n\t\t<label style=\"font-family:verdana;font-size:10\"><b>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</b></label>&nbsp;</td>\n\n\t\t<td width=\'10%\'><label style=\"font-family:verdana;font-size:10\"><b>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&nbsp;:</b></label></td>\n\t\t<td><label  style=\"font-family:verdana;font-size:10;\"><b>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</b></label> </td>\n\n\t\t<td width=\'10%\'><label style=\"font-family:verdana;font-size:10\"><b>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="&nbsp;:&nbsp;&nbsp;</b></label></td>\n\t\t<td class=\"label\"><input type=\"text\" name=\"next_del_date_";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" id=\"next_del_date_";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\"  size=\"10\" maxlength=\"10\" onBlur=\"CheckDelDateWithSysdate(this,sys_date)\" >&nbsp;<img src=\"../../eCommon/images/CommonCalendar.gif\"  onClick=\"return showCalendar(\'next_del_date_";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\');\"></img> <span id=\"img_next_del_date_";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\"  style=\"visibility:";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\"  >";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</span></td>\n\n\n\t    </tr>\n\t</table>\n\n\t<table border=\'1\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' align=\'center\'>\n\t\t\t<tr>\n               <!-- Modified for IN:071539 start -->\n               ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n                <th nowrap> <input type=\"checkbox\" id=\'doc_no1_";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'   name=\'doc_no1_";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' onClick=\'selectItems(this, \"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\");\' disabled > ";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</th>     \n\t\t        <th>";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</th>\n\t\t        ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t        <th>";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t        <!-- Modified for IN:071539 end-->\n\t\t\t<th>";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</th>\n\t\t        <th>";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</th>\n\t\t\t\t<th>";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</th>\n\t\t\t\t<!--<th colspan=2>";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</th>-->\n\t\t\t\t<th colspan=2>";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</th>\t\n\t\t\t\t<th nowrap>";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</th>\n\t\t\t\t<th nowrap>";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</th><!-- added for NMC-JD-CRF-0142 -->\n\n\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="  \n\t\t <tr  >\t                                                                         \n            <td class=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\" style=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\' width=\'2%\'><input type=\"checkbox\"  id=\'doc_no_";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="_";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\'   name=\'doc_no_";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\'  value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\" onClick=\"getItemQty(this,\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\',\'P\',\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\');MandatoryChkForDelDate(\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\')\"  disabled  > </td>\n\t\t\t<!-- Added for IN:071539 start -->\n\t\t\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t<td class=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\"  style=\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\'width=\'25%\' ><label style=\"font-family:verdana;font-size:10\">";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="</label>&nbsp;</td>\n\t\t\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\t<!-- Added for IN:071539 end -->\n\t\t\t<td class=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="</label>&nbsp;</td>\n\t\t\t<td class=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\'width=\'10%\' ><label style=\"font-family:verdana;font-size:10\" > <a href=\"#\"  onclick=\'DOBatchDetails(\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\");\' >";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="</a> </label>&nbsp;</td>\n\t\t\t<td\tclass=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\'width=\'10%\'><label style=\"font-family:verdana;font-size:10\">";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="</label>&nbsp;</td>\n\t\t\t<td\tclass=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="</label>&nbsp;\n\t\t<!--<td class=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\"  width=\'10%\' style=\'text-align:right;\'><label  style=\"font-family:verdana;font-size:10;text-align:right;\">";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="</label> &nbsp;</td>\n\t\t\t<td\tclass=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\"  width=\'10%\'><label style=\"font-family:verdana;font-size:10\">";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="&nbsp;</label></td>-->\n\t\t\t<td class=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\'width=\'10%\' style=\'text-align:right;\'><label  style=\"font-family:verdana;font-size:10;text-align:right;\">";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="</label>\n\t\t\t<td class=\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\'width=\'10%\' style=\'text-align:right;\'><label  style=\"font-family:verdana;font-size:10;text-align:right;\">\n\t\t\t";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t\t\t\t";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\t\t\t";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\t\t\t\t\n\t\t\t</label> &nbsp;</td>\n<!--\t\t<td class=\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="</label> &nbsp;</td>-->\n\t\t\t<td class=\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\' width=\'10%\' style=\'text-align:right;\'><label  style=\"font-family:verdana;font-size:10;text-align:right;\">";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="</label> &nbsp;</td>\n\t\t\t<td class=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\' ><input style=\'text-align:right;\' type=\"text\" id=\'grn_item_qty_";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\' name=\'grn_item_qty_";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\'  size=\"10\" maxlength=\"10\" onKeyPress=\"return isValidNumberforMultiLine(this,event,8,";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 =",allow_deci_";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 =");\" onBlur=\"checkDoubleFormat(this);MandatoryChkForDelDate(\'";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\')\"  disabled  ";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 =" >  </td>\n            <td class=\"";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\' >";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="</td>\n            \n\t\t\t<input type=\"hidden\" name=\'item_code_";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\' id=\'item_code_";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\'       value=\"";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\">\n\t\t\t<input type=\"hidden\" name=\'req_no_";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\' id=\'req_no_";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\'          value=\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\">\n\t\t\t<input type=\"hidden\" name=\'req_qty_";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\' id=\'req_qty_";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\' \t\t  value=\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\">\n\t\t<!--<input type=\"hidden\" name=\'po_qty_";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\' id=\'po_qty_";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\">-->\n\t\t\t<input type=\"hidden\" name=\'po_qty_";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\">\n\t\t\t<input type=\"hidden\" name=\'pur_unit_code_";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\' id=\'pur_unit_code_";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\'   value=\"";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\">\t\n\t\t\t<input type=\"hidden\" name=\'local_currency_";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\' id=\'local_currency_";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\">\t\n\t\t\t<input type=\"hidden\" name=\'trans_currency_";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\' id=\'trans_currency_";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\">\t\n\t\t\t<input type=\"hidden\" name=\'conversion_rate_";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\' id=\'conversion_rate_";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\' value=\"";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\">\t\n\t\t\t<input type=\"hidden\" name=\'allow_deci_";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\' id=\'allow_deci_";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\' \t  value=\"";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\">\t\t\t\t\n\t\t\t<input type=\"hidden\" name=\'do_no_";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\' id=\'do_no_";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\">\t\t\t\t\n\t\t\t<input type=\"hidden\" name=\'invoice_no_";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\' id=\'invoice_no_";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\">\t\t\t\t\n\t\t\t<input type=\"hidden\" name=\'invoice_received_by_";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\' id=\'invoice_received_by_";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\">\t\t\t\t\n\t\t\t\n\t\t</tr>\n\t";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\n\t\t<tr> \t    \n\t\t<td class=\"";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\"  colspan=\"12\" style=\"text-align:right\"> <input align=\"right\" type=button name=\'apply_";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\' id=\'apply_";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\'   value=\'";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\'    align=\'right\' class=button onclick=\"onadd(\'";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\');\"  disabled >\t </td><!-- Modified for IN:071539 end-->\n\t\t</tr>\n\t</table>\n \n\t";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\n\t</div>\n\t</form>\n\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );
	
	/** START FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	public Object getBean(String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
		return PersistenceHelper.getBean(sessionid,userid,ws_no,session_creation_date,jdbc_props);
	}
	
	public Object getObjectFromBean(String id,String ClassName,javax.servlet.http.HttpSession session){
		return PersistenceHelper.getObjectFromBean( id,ClassName,session);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpSession session){
		PersistenceHelper.putObjectInBean(id,obj,session);
	}

	/** END FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	/** START FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/
	public Object getBeanObject(String id,String ClassName,javax.servlet.http.HttpServletRequest request){
		return PersistenceHelper.getBeanObject(id,ClassName,request);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.putObjectInBean(id,obj,request);
	}

	public void cleanBeanObject(String id,String className,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.	cleanBeanObject(id,className,request);
	} 
	/** END FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/

	/** START TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/
	public void cleanAll(javax.servlet.http.HttpSession session){
		PersistenceHelper.cleanAll(session);
	}
	/** END TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/


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
-------------------------------------------------------------------------------------------------------------------------------------------
Date		       Edit History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------
27/11/2019      IN:071539               B Haribabu         28/11/2019         Manickam                NMC-JD-CRF-0029
05/05/2021  	TFS id:-17345           Haribabu	      05/05/2021	 	 Manickavasagam J         NMC-JD-SCF-0183
--------------------------------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);

		request.setCharacterEncoding("UTF-8");
		String locale		=	(String)session.getAttribute("LOCALE");

		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    	
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
    

	String facility_id			=		(String) session.getValue( "facility_id" ) ;

	String bean_id              ="";
    String bean_name            ="";
	String store_code           ="";
	String from_doc_date        ="";
	String to_doc_date          ="";
	String item_code            ="";
	String po_number            ="";
	String supp_code			="";
	String pur_unit_code		="";
	String pur_unit_desc		="";
	String req_qty				="";		
	String req_uom				="";
	String classValue			="";
	String new_po_no			="";
	String st_uom_code			="";
	String st_uom_desc			="";
	String mode					="";
	String img_next_del_date	="hidden";
	String receipt_qty			= "";
	String grn_qty_readonly		= "";
	String do_no				= "";
	String sort_by				= "";// Added for IN:071539
	String Item_Store_Combination="";//added for NMC-JD-CRF-0142
    String bckcolor="";//added for NMC-JD-CRF-0142
	bean_id                     = "goodsReceivedNoteBean" ;
	bean_name                   = "eST.GoodsReceivedNoteBean";

    
	GoodsReceivedNoteBean bean = (GoodsReceivedNoteBean) getBeanObject( bean_id, bean_name,request );


	store_code           =  bean.checkForNull(request.getParameter("store_code"));
	item_code            =  request.getParameter("item_desc").equals("")? "%": request.getParameter("item_code");
	from_doc_date        =  bean.checkForNull(request.getParameter("from_doc_date"));
	to_doc_date          =  bean.checkForNull(request.getParameter("to_doc_date"));	
	po_number            =  bean.checkForNull(request.getParameter("doc_no"),"%");
	supp_code            =  bean.checkForNull(request.getParameter("supp_code"),"%");//Modified for IN:071539
	pur_unit_code        =  bean.checkForNull(request.getParameter("purchase_unit"),"%");
	mode				 =  bean.checkForNull(request.getParameter("mode"));
	do_no				 =  bean.checkForNull(request.getParameter("do_no"));
	sort_by				 =  bean.checkForNull(request.getParameter("sort_by"));// Added for IN:071539

	int no_deci                   =    bean.getNoOfDecimals();

	HashMap PO_Override			=	bean.fetchRecord(bean.getStRepositoryValue("SQL_PO_PARAMETER_OVERRIDE_ALLOW"));

	String qty_override_yn		=	bean.checkForNull((String)PO_Override.get("ALLOW_QTY_OVERRIDE_IN_GRN"),"N");
	//Added for IN:071539 start
    Connection con				= null;
	 
	boolean multi_selct_appl = false;
	
	try 
	{
		con						= ConnectionManager.getConnection(request);
		multi_selct_appl = eCommon.Common.CommonBean.isSiteSpecific(con, "ST","ST_GRN_PO_RESULT_MULTI_SELECT");
		
	} 
	catch (Exception e) 
	{
		e.printStackTrace(System.err);
		System.out.println(" Error in Criteria Page " + e.getMessage());
	} 
	finally 
	{
		if (con != null) ConnectionManager.returnConnection(con, request); 
	}
	String multi_selct_appl_chk="N";
	if(multi_selct_appl)
		multi_selct_appl_chk="Y";
	//Added for IN:071539(US04) START
	ArrayList stParameters = new ArrayList();
	stParameters.add(store_code);
	stParameters.add(facility_id);
	stParameters.add(supp_code);
	stParameters.add(from_doc_date);
	stParameters.add(to_doc_date);
	stParameters.add(po_number);
	stParameters.add(pur_unit_code);
	stParameters.add(item_code);
	ArrayList alParameters = null;
	String doc_type=bean.getDoc_type_code();
	//System.out.println("doc_type> "+doc_type);
	//String []stParameters1={store_code,facility_id,supp_code,from_doc_date,to_doc_date,po_number,pur_unit_code,item_code,doc_type};		
	String sql="";
	if(multi_selct_appl){
		stParameters.add(doc_type);
		if(supp_code.equals("%")){
		 sql= "SELECT DISTINCT dtl.pur_unit_code, dtl.po_no FROM po_order_hdr hdr, po_order_fcy_dtl dtl,XI_TRN_PO_DTLS_IB xi WHERE hdr.pur_unit_code = dtl.pur_unit_code AND hdr.po_no = dtl.po_no AND (dtl.req_store_code = ? OR dtl.req_store_code = '*A') AND (dtl.req_facility_id = ? OR dtl.req_facility_id = '*A') AND hdr.supp_code LIKE ? AND hdr.po_status IN ('FA', 'AM', 'RA', 'PD', 'FD', 'PR') AND po_date BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901')), 'DD/MM/YYYY' ) AND NVL (TO_DATE (?, 'DD/MM/YYYY'), SYSDATE) AND dtl.po_no LIKE ? AND dtl.pur_unit_code LIKE ? AND dtl.item_code LIKE ? AND DTL.PO_NO=XI.RESP_NUM and XI.DOC_TYPE_CODE=? AND (NVL (dtl.po_qty, 0) - NVL (dtl.grn_qty, 0)) > 0 ORDER BY 2";
		}
		else{
		 sql= "SELECT DISTINCT dtl.pur_unit_code, dtl.po_no FROM po_order_hdr hdr, po_order_fcy_dtl dtl, xi_trn_po_dtls_ib xi WHERE hdr.pur_unit_code = dtl.pur_unit_code AND hdr.po_no = dtl.po_no AND (dtl.req_store_code = ? OR dtl.req_store_code = '*A') AND (dtl.req_facility_id = ? OR dtl.req_facility_id = '*A') AND hdr.supp_code = ? AND hdr.po_status IN ('FA', 'AM', 'RA', 'PD', 'FD', 'PR') AND po_date BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901')), 'DD/MM/YYYY' ) AND NVL (TO_DATE (?, 'DD/MM/YYYY'), SYSDATE) AND dtl.po_no LIKE ? AND dtl.pur_unit_code LIKE ? AND dtl.item_code LIKE ? AND dtl.po_no = xi.resp_num AND xi.doc_type_code = ? AND (NVL (dtl.po_qty, 0) - NVL (dtl.grn_qty, 0)) > 0 ORDER BY 2";
		}
	}
	else{
		sql= "SELECT DISTINCT DTL.PUR_UNIT_CODE,DTL.PO_NO FROM PO_ORDER_HDR HDR ,PO_ORDER_FCY_DTL DTL WHERE HDR.PUR_UNIT_CODE=DTL.PUR_UNIT_CODE AND HDR.PO_NO=DTL.PO_NO AND (DTL.REQ_STORE_CODE = ? OR DTL.REQ_STORE_CODE='*A') AND (DTL.REQ_FACILITY_ID = ? OR DTL.REQ_FACILITY_ID = '*A') AND HDR.SUPP_CODE = ? AND  HDR.PO_STATUS IN ('FA','AM', 'RA', 'PD','FD','PR') AND PO_DATE BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'DD/MM/YYYY' )  AND  NVL (TO_DATE (?, 'DD/MM/YYYY'), SYSDATE) AND DTL.PO_NO LIKE ? AND DTL.PUR_UNIT_CODE LIKE ?  AND DTL.ITEM_CODE  LIKE  ? AND (NVL(DTL.PO_QTY,0)-NVL(DTL.GRN_QTY,0)) > 0  ORDER BY 2";
	}
	
	String []stParameters1 = new String[stParameters.size()];              
		for(int j =0;j<stParameters.size();j++){
			stParameters1[j] = (String) stParameters.get(j);
		}
    
	ArrayList alTemp = new ArrayList();
	HashMap hmExpData = new HashMap();
	HashMap hmTemp = null;
	HashMap temp = null;

	alTemp =  bean.fetchRecords(sql,stParameters1);
	//Modified for IN:071539(US04) end
	int total = alTemp.size();	
	if(total ==0){
		
            _bw.write(_wl_block9Bytes, _wl_block9);
		
	}	
	
	for(int j=0;j<total;){		

		HashMap hm = (HashMap)alTemp.get(j);
		
		//String []stParameters1 = {locale,store_code,facility_id,from_doc_date,to_doc_date,(String)hm.get("PO_NO"),(String)hm.get("PUR_UNIT_CODE"),item_code,facility_id,store_code,do_no};
		alParameters = new ArrayList();
		alParameters.add(locale);
		alParameters.add(store_code);
		alParameters.add(facility_id);
		alParameters.add(from_doc_date);
		alParameters.add(to_doc_date);
		alParameters.add((String)hm.get("PO_NO"));
		alParameters.add((String)hm.get("PUR_UNIT_CODE"));
		alParameters.add(item_code);
		alParameters.add(facility_id);
		alParameters.add(store_code);
		alParameters.add(do_no);

		String sql1 = "";

		if(mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY"))){			

			//sql1 = "select * from (SELECT DTL.PUR_UNIT_CODE,DTL.PO_NO,DTL.PO_SRL_NO,DTL.ITEM_CODE,MMITEM.SHORT_DESC ITEM_DESC, (NVL (dtl.po_qty, 0) - (NVL (dtl.grn_qty, 0) + (select nvl(sum(nvl(blocked_qty,0)),0) blocked_qty from po_order_unf_grn where po_no = dtl.po_no and item_code=dtl.item_code  and (req_no=dtl.req_no or req_no = '*A') and (facility_id !='"+facility_id+"' or grn_doc_type_code!='"+bean.getDoc_type_code()+"' or grn_no!='"+bean.getDoc_no()+"')))) item_qty_normal,nvl(DTL.ITEM_UNIT_COST,0) ITEM_UNIT_COST,	((NVL (dtl.po_qty, 0) - (NVL (dtl.grn_qty, 0)) +  (select nvl(sum(nvl(blocked_qty,0)),0) blocked_qty from po_order_unf_grn where po_no = dtl.po_no and item_code=dtl.item_code and (req_no=dtl.req_no or req_no = '*A') and ( facility_id !='"+facility_id+"' or grn_doc_type_code!= '"+bean.getDoc_type_code()+"' or grn_no!='"+bean.getDoc_no()+"'))) * (NVL (dtl.item_unit_cost, 0) * NVL (hdr.conversion_rate, 0))) item_cost_value, STOCK_ITEM_YN, PO_UOM PUR_UOM_CODE,AM1.SHORT_DESC PUR_UOM_DESC,AM.UOM_CODE,AM.SHORT_DESC GEN_UOM_DESC, DTL.PO_GEN_UOM_CONV_FACTOR,DTL.PO_GEN_UOM_QTY,STITEM.EXPIRY_YN, '0' ITEM_QTY_BONUS, '0' ITEM_QTY_SAMPLE , nvl(STITEM.ALLOW_DECIMALS_YN,'N') ALLOW_DECIMALS_YN,HDR.TRANS_CURRENCY,hdr.LOCAL_CURRENCY,hdr.CONVERSION_RATE,to_char(HDR.PO_DATE,'dd/mm/yyyy') PO_DATE,to_char(HDR.EXPECTED_DELV_DATE,'dd/mm/yyyy') EXPECTED_DELV_DATE,DTL.REQ_SRL_NO,DTL.REQ_NO,DTL.REQ_FACILITY_ID,DTL.REQ_STORE_CODE,ST.DEF_ISSUE_UOM,NVL(DTL.PO_QTY,0) PO_QTY  FROM po_order_hdr HDR ,po_order_fcy_dtl DTL,MM_ITEM_LANG_VW MMITEM,ST_ITEM STITEM,AM_UOM_LANG_VW AM,ST_ITEM_STORE ST, AM_UOM_LANG_VW AM1  WHERE HDR.PUR_UNIT_CODE=DTL.PUR_UNIT_CODE AND HDR.PO_NO=DTL.PO_NO and MMITEM.ITEM_CODE = DTL.ITEM_CODE AND  STITEM.ITEM_CODE = DTL.ITEM_CODE  AND  MMITEM.GEN_UOM_CODE = AM.UOM_CODE  AND MMITEM.LANGUAGE_ID = AM.LANGUAGE_ID AND  MMITEM.LANGUAGE_ID = ? AND AM.LANGUAGE_ID = AM1.LANGUAGE_ID AND DTL.PO_UOM = AM1.UOM_CODE AND ST.ITEM_CODE(+) = DTL.ITEM_CODE  AND ST.STORE_CODE(+) = DTL.REQ_STORE_CODE AND (DTL.REQ_STORE_CODE = ? OR dtl.req_store_code='*A') AND (DTL.REQ_FACILITY_ID = ? OR dtl.req_facility_id = '*A' ) AND PO_DATE BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'dd/mm/yyyy' )  AND  NVL (TO_DATE (?, 'dd/mm/yyyy'), SYSDATE) AND DTL.PO_NO = ? and DTL.PUR_UNIT_CODE = ?  and dtl.item_code like  ? ) a  where a.item_qty_normal > 0 order by 2";
			//Modified for IN:071539 start
			sql1 = "select * from (SELECT DISTINCT DTL.PUR_UNIT_CODE,DTL.PO_NO,DTL.PO_SRL_NO,DTL.ITEM_CODE,MMITEM.SHORT_DESC ITEM_DESC, (NVL (dtl.po_qty, 0) - (NVL (dtl.grn_qty, 0) + (select nvl(sum(nvl(blocked_qty,0)),0) blocked_qty from po_order_unf_grn where po_no = dtl.po_no and item_code=dtl.item_code  and (req_no=dtl.req_no or req_no = '*A') and (facility_id !='"+facility_id+"' or grn_doc_type_code!='"+bean.getDoc_type_code()+"' or grn_no!='"+bean.getDoc_no()+"')))) item_qty_normal,nvl(DTL.ITEM_UNIT_COST,0) ITEM_UNIT_COST,	((NVL (dtl.po_qty, 0) - (NVL (dtl.grn_qty, 0)) +  (select nvl(sum(nvl(blocked_qty,0)),0) blocked_qty from po_order_unf_grn where po_no = dtl.po_no and item_code=dtl.item_code and (req_no=dtl.req_no or req_no = '*A') and ( facility_id !='"+facility_id+"' or grn_doc_type_code!= '"+bean.getDoc_type_code()+"' or grn_no!='"+bean.getDoc_no()+"'))) * (NVL (dtl.item_unit_cost, 0) * NVL (hdr.conversion_rate, 0))) item_cost_value, STOCK_ITEM_YN, PO_UOM PUR_UOM_CODE,AM1.SHORT_DESC PUR_UOM_DESC,AM.UOM_CODE,AM.SHORT_DESC GEN_UOM_DESC, DTL.PO_GEN_UOM_CONV_FACTOR,DTL.PO_GEN_UOM_QTY,STITEM.EXPIRY_YN, '0' ITEM_QTY_BONUS, '0' ITEM_QTY_SAMPLE , nvl(STITEM.ALLOW_DECIMALS_YN,'N') ALLOW_DECIMALS_YN,HDR.TRANS_CURRENCY,hdr.LOCAL_CURRENCY,hdr.CONVERSION_RATE,to_char(HDR.PO_DATE,'dd/mm/yyyy') PO_DATE,to_char(HDR.EXPECTED_DELV_DATE,'dd/mm/yyyy') EXPECTED_DELV_DATE,DTL.REQ_SRL_NO,DTL.REQ_NO,DTL.REQ_FACILITY_ID,DTL.REQ_STORE_CODE,ST.DEF_ISSUE_UOM,NVL(DTL.PO_QTY,0) PO_QTY , POD.DO_NO,DECODE(POD.DO_NO,'','',NVL(POH.DO_STATUS,'UF'))DO_STATUS,SUM(POD.DO_QTY_NORMAL) OVER(PARTITION BY POD.DO_NO, POD.ITEM_CODE,POD.PO_NO,POD.PO_SRL_NO)  DO_QTY_NORMAL,SUM(NVL(POD.DO_QTY_NORMAL - NVL (POD.GRN_QTY, 0),0)) OVER(PARTITION BY POD.DO_NO, POD.ITEM_CODE,POD.PO_NO,POD.PO_SRL_NO) AVAIL_QTY FROM po_order_hdr HDR ,po_order_fcy_dtl DTL,MM_ITEM_LANG_VW MMITEM,ST_ITEM STITEM,AM_UOM_LANG_VW AM,ST_ITEM_STORE ST, AM_UOM_LANG_VW AM1  ,po_delv_ord_dtl_bat pod,PO_DELV_ORD_HDR POH WHERE HDR.PUR_UNIT_CODE=DTL.PUR_UNIT_CODE AND HDR.PO_NO=DTL.PO_NO and MMITEM.ITEM_CODE = DTL.ITEM_CODE AND  STITEM.ITEM_CODE = DTL.ITEM_CODE  AND  MMITEM.GEN_UOM_CODE = AM.UOM_CODE  AND MMITEM.LANGUAGE_ID = AM.LANGUAGE_ID AND  MMITEM.LANGUAGE_ID = ? AND AM.LANGUAGE_ID = AM1.LANGUAGE_ID AND DTL.PO_UOM = AM1.UOM_CODE AND ST.ITEM_CODE(+) = DTL.ITEM_CODE  AND ST.STORE_CODE(+) = DTL.REQ_STORE_CODE AND (DTL.REQ_STORE_CODE = ? OR dtl.req_store_code='*A') AND (DTL.REQ_FACILITY_ID = ? OR dtl.req_facility_id = '*A' ) AND PO_DATE BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'dd/mm/yyyy' )  AND  NVL (TO_DATE (?, 'dd/mm/yyyy'), SYSDATE) AND DTL.PO_NO = ? and DTL.PUR_UNIT_CODE = ?  and dtl.item_code like  ? AND POH.DO_NO(+) = POD.DO_NO  AND POH.DO_STATUS(+) IN ('FN','PR')  AND pod.po_no(+) = dtl.po_no  AND pod.item_code(+) = dtl.item_code   AND pod.po_srl_no(+) = dtl.po_srl_no   AND (   pod.dist_facility_id = ?   OR NVL (pod.dist_facility_id, '*A') = '*A' ) AND (   pod.dist_store_code = ?  OR NVL (pod.dist_store_code, '*A') = '*A')              AND NVL (pod.do_no, '*A') =  NVL (?, NVL (pod.do_no, '*A')) ) a  where a.item_qty_normal > 0 order by 2";
			System.out.println("sql1>> "+sql1);		
			if(multi_selct_appl){
				if(sort_by.equals("ITEMCODE")){
					sql1=sql1+", item_code";
				}
				else{
					sql1=sql1+", item_desc";
				}
				}
				
					//sql1=sql1+" ITEM_DESC, DO_NO";
				//Modified for IN:071539 end
		}else{
			
			alParameters.add(locale);
			alParameters.add(store_code);
			alParameters.add(facility_id);
			alParameters.add(from_doc_date);
			alParameters.add(to_doc_date);
			alParameters.add((String)hm.get("PO_NO"));
			alParameters.add((String)hm.get("PUR_UNIT_CODE"));
			alParameters.add(item_code);

			//sql1 = "select * from (SELECT DTL.PUR_UNIT_CODE,DTL.PO_NO,DTL.PO_SRL_NO,DTL.ITEM_CODE,MMITEM.SHORT_DESC ITEM_DESC, (NVL (dtl.po_qty, 0) - (NVL (dtl.grn_qty, 0) + (select nvl(sum(nvl(blocked_qty,0)),0) blocked_qty from po_order_unf_grn where po_no = dtl.po_no and item_code=dtl.item_code ) )) item_qty_normal,nvl(DTL.ITEM_UNIT_COST,0) ITEM_UNIT_COST,	((NVL (dtl.po_qty, 0) - (NVL (dtl.grn_qty, 0)) +  (select nvl(sum(nvl(blocked_qty,0)),0) blocked_qty from po_order_unf_grn where po_no = dtl.po_no and item_code=dtl.item_code )) * (NVL (dtl.item_unit_cost, 0) * NVL (hdr.conversion_rate, 0))) item_cost_value, STOCK_ITEM_YN, PO_UOM PUR_UOM_CODE,AM1.SHORT_DESC PUR_UOM_DESC,AM.UOM_CODE,AM.SHORT_DESC GEN_UOM_DESC, DTL.PO_GEN_UOM_CONV_FACTOR,DTL.PO_GEN_UOM_QTY,STITEM.EXPIRY_YN, '0' ITEM_QTY_BONUS, '0' ITEM_QTY_SAMPLE , nvl(STITEM.ALLOW_DECIMALS_YN,'N') ALLOW_DECIMALS_YN,HDR.TRANS_CURRENCY,hdr.LOCAL_CURRENCY,hdr.CONVERSION_RATE,to_char(HDR.PO_DATE,'dd/mm/yyyy') PO_DATE,to_char(HDR.EXPECTED_DELV_DATE,'dd/mm/yyyy') EXPECTED_DELV_DATE,DTL.REQ_SRL_NO,DTL.REQ_NO,DTL.REQ_FACILITY_ID,DTL.REQ_STORE_CODE,ST.DEF_ISSUE_UOM,NVL(DTL.PO_QTY,0) PO_QTY  FROM po_order_hdr HDR ,po_order_fcy_dtl DTL,MM_ITEM_LANG_VW MMITEM,ST_ITEM STITEM,AM_UOM_LANG_VW AM,ST_ITEM_STORE ST, AM_UOM_LANG_VW AM1  WHERE HDR.PUR_UNIT_CODE=DTL.PUR_UNIT_CODE AND HDR.PO_NO=DTL.PO_NO and MMITEM.ITEM_CODE = DTL.ITEM_CODE AND  STITEM.ITEM_CODE = DTL.ITEM_CODE  AND  MMITEM.GEN_UOM_CODE = AM.UOM_CODE  AND MMITEM.LANGUAGE_ID = AM.LANGUAGE_ID AND  MMITEM.LANGUAGE_ID = ? AND AM.LANGUAGE_ID = AM1.LANGUAGE_ID AND DTL.PO_UOM = AM1.UOM_CODE AND ST.ITEM_CODE(+) = DTL.ITEM_CODE  AND ST.STORE_CODE(+) = DTL.REQ_STORE_CODE AND (DTL.REQ_STORE_CODE = ? OR dtl.req_store_code='*A') AND (DTL.REQ_FACILITY_ID = ? OR dtl.req_facility_id = '*A' ) AND PO_DATE BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'dd/mm/yyyy' )  AND  NVL (TO_DATE (?, 'dd/mm/yyyy'), SYSDATE) AND DTL.PO_NO = ? and DTL.PUR_UNIT_CODE = ?  and dtl.item_code like  ? ) a  where a.item_qty_normal > 0 order by 2";
			//sql1 = "SELECT * FROM (SELECT DISTINCT DTL.PUR_UNIT_CODE,DTL.PO_NO,DTL.PO_SRL_NO,DTL.ITEM_CODE,MMITEM.SHORT_DESC ITEM_DESC, (NVL (DTL.PO_QTY, 0) - (NVL (DTL.GRN_QTY, 0) + (SELECT NVL(SUM(NVL(BLOCKED_QTY,0)),0) BLOCKED_QTY FROM PO_ORDER_UNF_GRN WHERE PO_NO = DTL.PO_NO AND ITEM_CODE=DTL.ITEM_CODE ) )) ITEM_QTY_NORMAL,NVL(DTL.ITEM_UNIT_COST,0) ITEM_UNIT_COST,	((NVL (DTL.PO_QTY, 0) - (NVL (DTL.GRN_QTY, 0)) +  (SELECT NVL(SUM(NVL(BLOCKED_QTY,0)),0) BLOCKED_QTY FROM PO_ORDER_UNF_GRN WHERE PO_NO = DTL.PO_NO AND ITEM_CODE=DTL.ITEM_CODE )) * (NVL (DTL.ITEM_UNIT_COST, 0) * NVL (HDR.CONVERSION_RATE, 0))) ITEM_COST_VALUE, STOCK_ITEM_YN, PO_UOM PUR_UOM_CODE,AM1.SHORT_DESC PUR_UOM_DESC,AM.UOM_CODE,AM.SHORT_DESC GEN_UOM_DESC, DTL.PO_GEN_UOM_CONV_FACTOR,DTL.PO_GEN_UOM_QTY,STITEM.EXPIRY_YN, '0' ITEM_QTY_BONUS, '0' ITEM_QTY_SAMPLE , NVL(STITEM.ALLOW_DECIMALS_YN,'N') ALLOW_DECIMALS_YN,HDR.TRANS_CURRENCY,HDR.LOCAL_CURRENCY,HDR.CONVERSION_RATE,TO_CHAR(HDR.PO_DATE,'DD/MM/YYYY') PO_DATE,TO_CHAR(HDR.EXPECTED_DELV_DATE,'DD/MM/YYYY') EXPECTED_DELV_DATE,DTL.REQ_SRL_NO,DTL.REQ_NO,DTL.REQ_FACILITY_ID,DTL.REQ_STORE_CODE,ST.DEF_ISSUE_UOM,NVL(DTL.PO_QTY,0) PO_QTY,POD.DO_NO,POD.DO_QTY_NORMAL, NVL(POD.DO_QTY_NORMAL - NVL (POD.GRN_QTY, 0),9999999)AVAIL_QTY,BATCH_ID,TO_CHAR(EXPIRY_DATE,'DD/MM/YYYY')EXPIRY_DATE,TRADE_ID   FROM PO_ORDER_HDR HDR ,PO_ORDER_FCY_DTL DTL,PO_ORDER_DELV_SCH POSCH,MM_ITEM_LANG_VW MMITEM,ST_ITEM STITEM,AM_UOM_LANG_VW AM,ST_ITEM_STORE ST, AM_UOM_LANG_VW AM1,PO_DELV_ORD_DTL_BAT POD  WHERE HDR.PUR_UNIT_CODE=DTL.PUR_UNIT_CODE AND HDR.PO_NO=DTL.PO_NO  AND DTL.PO_NO = POSCH.PO_NO  AND DTL.PO_SRL_NO= POSCH.PO_SRL_NO  AND DTL.ITEM_CODE = POSCH.ITEM_CODE AND MMITEM.ITEM_CODE = DTL.ITEM_CODE AND  STITEM.ITEM_CODE = DTL.ITEM_CODE  AND  MMITEM.GEN_UOM_CODE = AM.UOM_CODE  AND MMITEM.LANGUAGE_ID = AM.LANGUAGE_ID AND  MMITEM.LANGUAGE_ID = ? AND AM.LANGUAGE_ID = AM1.LANGUAGE_ID AND DTL.PO_UOM = AM1.UOM_CODE AND ST.ITEM_CODE(+) = DTL.ITEM_CODE  AND ST.STORE_CODE(+) = DTL.REQ_STORE_CODE AND (DTL.REQ_STORE_CODE = ? OR DTL.REQ_STORE_CODE='*A') AND (DTL.REQ_FACILITY_ID = ? OR DTL.REQ_FACILITY_ID = '*A' ) AND PO_DATE BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'DD/MM/YYYY' )  AND  NVL (TO_DATE (?, 'DD/MM/YYYY'), SYSDATE) AND DTL.PO_NO = ? AND DTL.PUR_UNIT_CODE = ?  AND DTL.ITEM_CODE LIKE  ?  AND POD.PO_NO(+) = POSCH.PO_NO AND POD.PO_SRL_NO(+) = POSCH.PO_SRL_NO  AND POD.ITEM_CODE(+) = POSCH.ITEM_CODE  AND POD.SCH_DELV_DATE(+) = POSCH.DELV_DATE  AND (POD.DIST_FACILITY_ID = ? OR NVL(POD.DIST_FACILITY_ID,'*A') = '*A') AND (POD.DIST_STORE_CODE= ? OR NVL(POD.DIST_STORE_CODE,'*A') = '*A') AND NVL(POSCH.DO_NO,'*A') = NVL(?,NVL(POSCH.DO_NO,'*A'))) A  WHERE A.ITEM_QTY_NORMAL > 0 AND A.AVAIL_QTY > 0 ORDER BY PO_NO,ITEM_DESC,REQ_NO,DO_NO";
			//sql1 = "SELECT * FROM (SELECT DISTINCT DTL.PUR_UNIT_CODE,DTL.PO_NO,DTL.PO_SRL_NO,DTL.ITEM_CODE,MMITEM.SHORT_DESC ITEM_DESC, (NVL (DTL.PO_QTY, 0) - (NVL (DTL.GRN_QTY, 0) + (SELECT NVL(SUM(NVL(BLOCKED_QTY,0)),0) BLOCKED_QTY FROM PO_ORDER_UNF_GRN WHERE PO_NO = DTL.PO_NO AND ITEM_CODE=DTL.ITEM_CODE ) )) ITEM_QTY_NORMAL,NVL(DTL.ITEM_UNIT_COST,0) ITEM_UNIT_COST,	((NVL (DTL.PO_QTY, 0) - (NVL (DTL.GRN_QTY, 0)) +  (SELECT NVL(SUM(NVL(BLOCKED_QTY,0)),0) BLOCKED_QTY FROM PO_ORDER_UNF_GRN WHERE PO_NO = DTL.PO_NO AND ITEM_CODE=DTL.ITEM_CODE )) * (NVL (DTL.ITEM_UNIT_COST, 0) * NVL (HDR.CONVERSION_RATE, 0))) ITEM_COST_VALUE, STOCK_ITEM_YN, PO_UOM PUR_UOM_CODE,AM1.SHORT_DESC PUR_UOM_DESC,AM.UOM_CODE,AM.SHORT_DESC GEN_UOM_DESC, DTL.PO_GEN_UOM_CONV_FACTOR,DTL.PO_GEN_UOM_QTY,STITEM.EXPIRY_YN, '0' ITEM_QTY_BONUS, '0' ITEM_QTY_SAMPLE , NVL(STITEM.ALLOW_DECIMALS_YN,'N') ALLOW_DECIMALS_YN,HDR.TRANS_CURRENCY,HDR.LOCAL_CURRENCY,HDR.CONVERSION_RATE,TO_CHAR(HDR.PO_DATE,'DD/MM/YYYY') PO_DATE,TO_CHAR(HDR.EXPECTED_DELV_DATE,'DD/MM/YYYY') EXPECTED_DELV_DATE,DTL.REQ_SRL_NO,DTL.REQ_NO,DTL.REQ_FACILITY_ID,DTL.REQ_STORE_CODE,ST.DEF_ISSUE_UOM,NVL(DTL.PO_QTY,0) PO_QTY , POD.DO_NO,SUM(POD.DO_QTY_NORMAL) OVER(PARTITION BY POD.DO_NO, POD.ITEM_CODE,POD.PO_NO,POD.PO_SRL_NO)  DO_QTY_NORMAL,SUM(NVL(POD.DO_QTY_NORMAL - NVL (POD.GRN_QTY, 0),9999999)) OVER(PARTITION BY POD.DO_NO, POD.ITEM_CODE,POD.PO_NO,POD.PO_SRL_NO)  AVAIL_QTY FROM PO_ORDER_HDR HDR ,PO_ORDER_FCY_DTL DTL,MM_ITEM_LANG_VW MMITEM,ST_ITEM STITEM,AM_UOM_LANG_VW AM,ST_ITEM_STORE ST, AM_UOM_LANG_VW AM1, PO_DELV_ORD_DTL_BAT POD WHERE HDR.PUR_UNIT_CODE=DTL.PUR_UNIT_CODE AND HDR.PO_NO=DTL.PO_NO AND MMITEM.ITEM_CODE = DTL.ITEM_CODE AND  STITEM.ITEM_CODE = DTL.ITEM_CODE  AND  MMITEM.GEN_UOM_CODE = AM.UOM_CODE  AND MMITEM.LANGUAGE_ID = AM.LANGUAGE_ID AND  MMITEM.LANGUAGE_ID = ? AND AM.LANGUAGE_ID = AM1.LANGUAGE_ID AND DTL.PO_UOM = AM1.UOM_CODE AND ST.ITEM_CODE(+) = DTL.ITEM_CODE  AND ST.STORE_CODE(+) = DTL.REQ_STORE_CODE AND (DTL.REQ_STORE_CODE = ? OR DTL.REQ_STORE_CODE='*A') AND (DTL.REQ_FACILITY_ID = ? OR DTL.REQ_FACILITY_ID = '*A' ) AND PO_DATE BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'DD/MM/YYYY' )  AND  NVL (TO_DATE (?, 'DD/MM/YYYY'), SYSDATE) AND DTL.PO_NO = ? AND DTL.PUR_UNIT_CODE = ?  AND DTL.ITEM_CODE LIKE  ?  AND POD.PO_NO(+) = DTL.PO_NO  AND POD.ITEM_CODE(+) = DTL.ITEM_CODE  AND POD.PO_SRL_NO(+) = DTL.PO_SRL_NO  AND (POD.DIST_FACILITY_ID = ? OR NVL(POD.DIST_FACILITY_ID,'*A') = '*A') AND (POD.DIST_STORE_CODE = ? OR  NVL(POD.DIST_STORE_CODE,'*A') = '*A') AND NVL(pod.DO_NO,'*A') = NVL(?,NVL(pod.DO_NO,'*A')) ) A  WHERE A.ITEM_QTY_NORMAL > 0 AND A.AVAIL_QTY > 0 ORDER BY PO_NO, ITEM_DESC, DO_NO";
			//sql1 = "SELECT * FROM (SELECT DISTINCT DTL.PUR_UNIT_CODE,DTL.PO_NO,DTL.PO_SRL_NO,DTL.ITEM_CODE,MMITEM.SHORT_DESC ITEM_DESC, (NVL (DTL.PO_QTY, 0) - (NVL (DTL.GRN_QTY, 0) + (SELECT NVL(SUM(NVL(BLOCKED_QTY,0)),0) BLOCKED_QTY FROM PO_ORDER_UNF_GRN WHERE PO_NO = DTL.PO_NO AND ITEM_CODE=DTL.ITEM_CODE ) )) ITEM_QTY_NORMAL,NVL(DTL.ITEM_UNIT_COST,0) ITEM_UNIT_COST,	((NVL (DTL.PO_QTY, 0) - (NVL (DTL.GRN_QTY, 0)) +  (SELECT NVL(SUM(NVL(BLOCKED_QTY,0)),0) BLOCKED_QTY FROM PO_ORDER_UNF_GRN WHERE PO_NO = DTL.PO_NO AND ITEM_CODE=DTL.ITEM_CODE )) * (NVL (DTL.ITEM_UNIT_COST, 0) * NVL (HDR.CONVERSION_RATE, 0))) ITEM_COST_VALUE, STOCK_ITEM_YN, PO_UOM PUR_UOM_CODE,AM1.SHORT_DESC PUR_UOM_DESC,AM.UOM_CODE,AM.SHORT_DESC GEN_UOM_DESC, DTL.PO_GEN_UOM_CONV_FACTOR,DTL.PO_GEN_UOM_QTY,STITEM.EXPIRY_YN, '0' ITEM_QTY_BONUS, '0' ITEM_QTY_SAMPLE , NVL(STITEM.ALLOW_DECIMALS_YN,'N') ALLOW_DECIMALS_YN,HDR.TRANS_CURRENCY,HDR.LOCAL_CURRENCY,HDR.CONVERSION_RATE,TO_CHAR(HDR.PO_DATE,'DD/MM/YYYY') PO_DATE,TO_CHAR(HDR.EXPECTED_DELV_DATE,'DD/MM/YYYY') EXPECTED_DELV_DATE,DTL.REQ_SRL_NO,DTL.REQ_NO,DTL.REQ_FACILITY_ID,DTL.REQ_STORE_CODE,ST.DEF_ISSUE_UOM,NVL(DTL.PO_QTY,0) PO_QTY , POD.DO_NO,DECODE(POD.DO_NO,'','',NVL(POH.DO_STATUS,'UF'))DO_STATUS,SUM(POD.DO_QTY_NORMAL) OVER(PARTITION BY POD.DO_NO, POD.ITEM_CODE,POD.PO_NO,POD.PO_SRL_NO)  DO_QTY_NORMAL,SUM(NVL(POD.DO_QTY_NORMAL - NVL (POD.GRN_QTY, 0),9999999)) OVER(PARTITION BY POD.DO_NO, POD.ITEM_CODE,POD.PO_NO,POD.PO_SRL_NO)-(SELECT NVL(SUM (NVL (BLOCKED_QTY, 0)),0) BLOCKED_QTY  FROM PO_ORDER_UNF_GRN  WHERE PO_NO = DTL.PO_NO  AND ITEM_CODE = DTL.ITEM_CODE  AND DO_NO=NVL (POD.DO_NO, '*A'))  AVAIL_QTY,POH.INVOICE_NO,POH.INVOICE_RECD_BY,POD.DO_QTY_BONUS, POD.DO_QTY_SAMPLE FROM PO_ORDER_HDR HDR ,PO_ORDER_FCY_DTL DTL,MM_ITEM_LANG_VW MMITEM,ST_ITEM STITEM,AM_UOM_LANG_VW AM,ST_ITEM_STORE ST, AM_UOM_LANG_VW AM1, PO_DELV_ORD_DTL_BAT POD ,PO_DELV_ORD_HDR POH WHERE HDR.PUR_UNIT_CODE=DTL.PUR_UNIT_CODE AND HDR.PO_NO=DTL.PO_NO AND MMITEM.ITEM_CODE = DTL.ITEM_CODE AND  STITEM.ITEM_CODE = DTL.ITEM_CODE  AND  MMITEM.GEN_UOM_CODE = AM.UOM_CODE  AND MMITEM.LANGUAGE_ID = AM.LANGUAGE_ID AND  MMITEM.LANGUAGE_ID = ? AND AM.LANGUAGE_ID = AM1.LANGUAGE_ID AND DTL.PO_UOM = AM1.UOM_CODE AND ST.ITEM_CODE(+) = DTL.ITEM_CODE  AND ST.STORE_CODE(+) = DTL.REQ_STORE_CODE AND (DTL.REQ_STORE_CODE = ? OR DTL.REQ_STORE_CODE='*A') AND (DTL.REQ_FACILITY_ID = ? OR DTL.REQ_FACILITY_ID = '*A' ) AND PO_DATE BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'DD/MM/YYYY' )  AND  NVL (TO_DATE (?, 'DD/MM/YYYY'), SYSDATE) AND DTL.PO_NO = ? AND DTL.PUR_UNIT_CODE = ?  AND DTL.ITEM_CODE LIKE  ?  AND POH.DO_NO(+) = POD.DO_NO AND POH.DO_STATUS(+) IN ('FN','PR') AND POD.PO_NO(+) = DTL.PO_NO  AND POD.ITEM_CODE(+) = DTL.ITEM_CODE  AND POD.PO_SRL_NO(+) = DTL.PO_SRL_NO  AND (POD.DIST_FACILITY_ID = ? OR NVL(POD.DIST_FACILITY_ID,'*A') = '*A') AND (POD.DIST_STORE_CODE = ? OR  NVL(POD.DIST_STORE_CODE,'*A') = '*A') AND NVL(POD.DO_NO,'*A') = NVL(?,NVL(POD.DO_NO,'*A')) ) A  WHERE A.ITEM_QTY_NORMAL > 0 AND A.AVAIL_QTY > 0  AND DECODE(A.DO_NO,'','FN',A.DO_STATUS) IN ('FN','PR') ORDER BY PO_NO, ITEM_DESC, DO_NO";
			//sql1 = "SELECT * FROM (SELECT DISTINCT DTL.PUR_UNIT_CODE,DTL.PO_NO,DTL.PO_SRL_NO,DTL.ITEM_CODE,MMITEM.SHORT_DESC ITEM_DESC, (NVL (DTL.PO_QTY, 0) - (NVL (DTL.GRN_QTY, 0) + (SELECT NVL(SUM(NVL(BLOCKED_QTY,0)),0) BLOCKED_QTY FROM PO_ORDER_UNF_GRN WHERE PO_NO = DTL.PO_NO AND ITEM_CODE=DTL.ITEM_CODE ) )) ITEM_QTY_NORMAL,NVL(DTL.ITEM_UNIT_COST,0) ITEM_UNIT_COST,	((NVL (DTL.PO_QTY, 0) - (NVL (DTL.GRN_QTY, 0)) +  (SELECT NVL(SUM(NVL(BLOCKED_QTY,0)),0) BLOCKED_QTY FROM PO_ORDER_UNF_GRN WHERE PO_NO = DTL.PO_NO AND ITEM_CODE=DTL.ITEM_CODE )) * (NVL (DTL.ITEM_UNIT_COST, 0) * NVL (HDR.CONVERSION_RATE, 0))) ITEM_COST_VALUE, STOCK_ITEM_YN, PO_UOM PUR_UOM_CODE,AM1.SHORT_DESC PUR_UOM_DESC,AM.UOM_CODE,AM.SHORT_DESC GEN_UOM_DESC, DTL.PO_GEN_UOM_CONV_FACTOR,DTL.PO_GEN_UOM_QTY,STITEM.EXPIRY_YN, '0' ITEM_QTY_BONUS, '0' ITEM_QTY_SAMPLE , NVL(STITEM.ALLOW_DECIMALS_YN,'N') ALLOW_DECIMALS_YN,HDR.TRANS_CURRENCY,HDR.LOCAL_CURRENCY,HDR.CONVERSION_RATE,TO_CHAR(HDR.PO_DATE,'DD/MM/YYYY') PO_DATE,TO_CHAR(HDR.EXPECTED_DELV_DATE,'DD/MM/YYYY') EXPECTED_DELV_DATE,DTL.REQ_SRL_NO,DTL.REQ_NO,DTL.REQ_FACILITY_ID,DTL.REQ_STORE_CODE,ST.DEF_ISSUE_UOM,NVL(DTL.PO_QTY,0) PO_QTY , POD.DO_NO,DECODE(POD.DO_NO,'','',NVL(POH.DO_STATUS,'UF'))DO_STATUS,SUM(POD.DO_QTY_NORMAL) OVER(PARTITION BY POD.DO_NO, POD.ITEM_CODE,POD.PO_NO,POD.PO_SRL_NO)  DO_QTY_NORMAL,SUM(NVL(POD.DO_QTY_NORMAL - NVL (POD.GRN_QTY, 0),9999999)) OVER(PARTITION BY POD.DO_NO, POD.ITEM_CODE,POD.PO_NO,POD.PO_SRL_NO)-(SELECT NVL(SUM (NVL (BLOCKED_QTY, 0)),0) BLOCKED_QTY  FROM PO_ORDER_UNF_GRN  WHERE PO_NO = DTL.PO_NO  AND ITEM_CODE = DTL.ITEM_CODE  AND DO_NO=NVL (POD.DO_NO, '*A'))  AVAIL_QTY,POH.INVOICE_NO,POH.INVOICE_RECD_BY ,SUM (NVL (POD.DO_QTY_BONUS,0)) OVER (PARTITION BY POD.DO_NO, POD.ITEM_CODE, POD.PO_NO, POD.PO_SRL_NO) DO_QTY_BONUS, SUM (NVL (POD.DO_QTY_SAMPLE,0)) OVER (PARTITION BY POD.DO_NO, POD.ITEM_CODE, POD.PO_NO, POD.PO_SRL_NO) DO_QTY_SAMPLE FROM PO_ORDER_HDR HDR ,PO_ORDER_FCY_DTL DTL,MM_ITEM_LANG_VW MMITEM,ST_ITEM STITEM,AM_UOM_LANG_VW AM,ST_ITEM_STORE ST, AM_UOM_LANG_VW AM1, PO_DELV_ORD_DTL_BAT POD ,PO_DELV_ORD_HDR POH WHERE HDR.PUR_UNIT_CODE=DTL.PUR_UNIT_CODE AND HDR.PO_NO=DTL.PO_NO AND MMITEM.ITEM_CODE = DTL.ITEM_CODE AND  STITEM.ITEM_CODE = DTL.ITEM_CODE  AND  MMITEM.GEN_UOM_CODE = AM.UOM_CODE  AND MMITEM.LANGUAGE_ID = AM.LANGUAGE_ID AND  MMITEM.LANGUAGE_ID = ? AND AM.LANGUAGE_ID = AM1.LANGUAGE_ID AND DTL.PO_UOM = AM1.UOM_CODE AND ST.ITEM_CODE(+) = DTL.ITEM_CODE  AND ST.STORE_CODE(+) = DTL.REQ_STORE_CODE AND (DTL.REQ_STORE_CODE = ? OR DTL.REQ_STORE_CODE='*A') AND (DTL.REQ_FACILITY_ID = ? OR DTL.REQ_FACILITY_ID = '*A' ) AND PO_DATE BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'DD/MM/YYYY' )  AND  NVL (TO_DATE (?, 'DD/MM/YYYY'), SYSDATE) AND DTL.PO_NO = ? AND DTL.PUR_UNIT_CODE = ?  AND DTL.ITEM_CODE LIKE  ?  AND POH.DO_NO(+) = POD.DO_NO AND POH.DO_STATUS(+) IN ('FN','PR') AND POD.PO_NO(+) = DTL.PO_NO  AND POD.ITEM_CODE(+) = DTL.ITEM_CODE  AND POD.PO_SRL_NO(+) = DTL.PO_SRL_NO  AND (POD.DIST_FACILITY_ID = ? OR NVL(POD.DIST_FACILITY_ID,'*A') = '*A') AND (POD.DIST_STORE_CODE = ? OR  NVL(POD.DIST_STORE_CODE,'*A') = '*A') AND NVL(POD.DO_NO,'*A') = NVL(?,NVL(POD.DO_NO,'*A')) ) A  WHERE A.ITEM_QTY_NORMAL > 0 AND A.AVAIL_QTY > 0  AND DECODE(A.DO_NO,'','FN',A.DO_STATUS) IN ('FN','PR') ORDER BY PO_NO, ITEM_DESC, DO_NO";
			//commented for 41090 on 12nd Sep 2013
			//Modified for IN:071539 start
			sql1 = "SELECT * FROM (SELECT DISTINCT DTL.PUR_UNIT_CODE,DTL.PO_NO,DTL.PO_SRL_NO,DTL.ITEM_CODE ITEM_CODE,MMITEM.SHORT_DESC ITEM_DESC, (NVL (DTL.PO_QTY, 0) - (NVL (DTL.GRN_QTY, 0) + (SELECT NVL(SUM(NVL(BLOCKED_QTY,0)),0) BLOCKED_QTY FROM PO_ORDER_UNF_GRN WHERE PO_NO = DTL.PO_NO AND ITEM_CODE=DTL.ITEM_CODE ) )) ITEM_QTY_NORMAL,NVL(DTL.ITEM_UNIT_COST,0) ITEM_UNIT_COST,	((NVL (DTL.PO_QTY, 0) - (NVL (DTL.GRN_QTY, 0)) +  (SELECT NVL(SUM(NVL(BLOCKED_QTY,0)),0) BLOCKED_QTY FROM PO_ORDER_UNF_GRN WHERE PO_NO = DTL.PO_NO AND ITEM_CODE=DTL.ITEM_CODE )) * (NVL (DTL.ITEM_UNIT_COST, 0) * NVL (HDR.CONVERSION_RATE, 0))) ITEM_COST_VALUE, STOCK_ITEM_YN, PO_UOM PUR_UOM_CODE,AM1.SHORT_DESC PUR_UOM_DESC,AM.UOM_CODE,AM.SHORT_DESC GEN_UOM_DESC, DTL.PO_GEN_UOM_CONV_FACTOR,DTL.PO_GEN_UOM_QTY,STITEM.EXPIRY_YN, '0' ITEM_QTY_BONUS, '0' ITEM_QTY_SAMPLE , NVL(STITEM.ALLOW_DECIMALS_YN,'N') ALLOW_DECIMALS_YN,HDR.TRANS_CURRENCY,HDR.LOCAL_CURRENCY,HDR.CONVERSION_RATE,TO_CHAR(HDR.PO_DATE,'DD/MM/YYYY') PO_DATE,TO_CHAR(HDR.EXPECTED_DELV_DATE,'DD/MM/YYYY') EXPECTED_DELV_DATE,DTL.REQ_SRL_NO,DTL.REQ_NO,DTL.REQ_FACILITY_ID,DTL.REQ_STORE_CODE,ST.DEF_ISSUE_UOM,NVL(DTL.PO_QTY,0) PO_QTY , POD.DO_NO,DECODE(POD.DO_NO,'','',NVL(POH.DO_STATUS,'UF'))DO_STATUS,SUM(POD.DO_QTY_NORMAL) OVER(PARTITION BY POD.DO_NO, POD.ITEM_CODE,POD.PO_NO,POD.PO_SRL_NO)  DO_QTY_NORMAL,SUM(NVL(POD.DO_QTY_NORMAL - NVL (POD.GRN_QTY, 0),0)) OVER(PARTITION BY POD.DO_NO, POD.ITEM_CODE,POD.PO_NO,POD.PO_SRL_NO)-(SELECT NVL(SUM (NVL (BLOCKED_QTY, 0)),0) BLOCKED_QTY  FROM PO_ORDER_UNF_GRN  WHERE PO_NO = DTL.PO_NO  AND ITEM_CODE = DTL.ITEM_CODE  AND DO_NO=NVL (POD.DO_NO, '*A'))  AVAIL_QTY,POH.INVOICE_NO,POH.INVOICE_RECD_BY ,SUM (NVL (POD.DO_QTY_BONUS,0)) OVER (PARTITION BY POD.DO_NO, POD.ITEM_CODE, POD.PO_NO, POD.PO_SRL_NO) DO_QTY_BONUS, SUM (NVL (POD.DO_QTY_SAMPLE,0)) OVER (PARTITION BY POD.DO_NO, POD.ITEM_CODE, POD.PO_NO, POD.PO_SRL_NO) DO_QTY_SAMPLE FROM PO_ORDER_HDR HDR ,PO_ORDER_FCY_DTL DTL,MM_ITEM_LANG_VW MMITEM,ST_ITEM STITEM,AM_UOM_LANG_VW AM,ST_ITEM_STORE ST, AM_UOM_LANG_VW AM1, PO_DELV_ORD_DTL_BAT POD ,PO_DELV_ORD_HDR POH WHERE HDR.PUR_UNIT_CODE=DTL.PUR_UNIT_CODE AND HDR.PO_NO=DTL.PO_NO AND MMITEM.ITEM_CODE = DTL.ITEM_CODE AND  STITEM.ITEM_CODE = DTL.ITEM_CODE  AND  MMITEM.GEN_UOM_CODE = AM.UOM_CODE  AND MMITEM.LANGUAGE_ID = AM.LANGUAGE_ID AND  MMITEM.LANGUAGE_ID = ? AND AM.LANGUAGE_ID = AM1.LANGUAGE_ID AND DTL.PO_UOM = AM1.UOM_CODE AND ST.ITEM_CODE(+) = DTL.ITEM_CODE  AND ST.STORE_CODE(+) = DTL.REQ_STORE_CODE AND (DTL.REQ_STORE_CODE = ? OR DTL.REQ_STORE_CODE='*A') AND (DTL.REQ_FACILITY_ID = ? OR DTL.REQ_FACILITY_ID = '*A' ) AND PO_DATE BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'DD/MM/YYYY' )  AND  NVL (TO_DATE (?, 'DD/MM/YYYY'), SYSDATE) AND DTL.PO_NO = ? AND DTL.PUR_UNIT_CODE = ?  AND DTL.ITEM_CODE LIKE  ?  AND POH.DO_NO(+) = POD.DO_NO AND POH.DO_STATUS(+) IN ('FN','PR') AND POD.PO_NO(+) = DTL.PO_NO  AND POD.ITEM_CODE(+) = DTL.ITEM_CODE  AND POD.PO_SRL_NO(+) = DTL.PO_SRL_NO  AND (POD.DIST_FACILITY_ID = ? OR NVL(POD.DIST_FACILITY_ID,'*A') = '*A') AND (POD.DIST_STORE_CODE = ? OR  NVL(POD.DIST_STORE_CODE,'*A') = '*A') AND NVL(POD.DO_NO,'*A') = NVL(?,NVL(POD.DO_NO,'*A')) UNION SELECT DISTINCT dtl.pur_unit_code, dtl.po_no, dtl.po_srl_no, dtl.item_code, mmitem.short_desc item_desc,(  NVL (dtl.po_qty, 0) - (  NVL (dtl.grn_qty, 0) + (SELECT NVL(SUM (NVL (blocked_qty, 0)),0) blocked_qty  FROM po_order_unf_grn  WHERE po_no = dtl.po_no  AND item_code = dtl.item_code) )) item_qty_normal, NVL (dtl.item_unit_cost, 0) item_unit_cost,((NVL (dtl.po_qty, 0) - (NVL (dtl.grn_qty, 0)) + (SELECT NVL (SUM (NVL (blocked_qty, 0)),0) blocked_qty FROM po_order_unf_grn  WHERE po_no = dtl.po_no  AND item_code = dtl.item_code)) * (  NVL (dtl.item_unit_cost, 0) * NVL (hdr.conversion_rate, 0))) item_cost_value, stock_item_yn, po_uom pur_uom_code, am1.short_desc pur_uom_desc, am.uom_code, am.short_desc gen_uom_desc,dtl.po_gen_uom_conv_factor, dtl.po_gen_uom_qty, stitem.expiry_yn, '0' item_qty_bonus, '0' item_qty_sample,NVL (stitem.allow_decimals_yn,'N') allow_decimals_yn,hdr.trans_currency, hdr.local_currency,hdr.conversion_rate, TO_CHAR (hdr.po_date, 'DD/MM/YYYY') po_date,TO_CHAR (hdr.expected_delv_date,'DD/MM/YYYY') expected_delv_date, dtl.req_srl_no, dtl.req_no, dtl.req_facility_id, dtl.req_store_code, st.def_issue_uom, NVL (dtl.po_qty, 0) po_qty, '' do_no, '' do_status, 0 do_qty_normal,SUM (NVL (sch.DELV_QTY, 0) - (nvl(dtl.grn_qty,0)+nvl(sch.DO_BLOCKED_QTY,0))) OVER (PARTITION BY sch.po_no, sch.item_code,sch.po_srl_no) - (SELECT NVL (SUM (NVL (blocked_qty, 0)),0) blocked_qty FROM po_order_unf_grn  WHERE po_no = dtl.po_no  AND item_code = dtl.item_code) avail_qty, '' invoice_no, '' invoice_recd_by,0 do_qty_bonus,0 do_qty_sample  FROM po_order_hdr hdr,po_order_fcy_dtl dtl,po_order_delv_sch sch,mm_item_lang_vw mmitem,st_item stitem,am_uom_lang_vw am,st_item_store st, am_uom_lang_vw am1  WHERE hdr.pur_unit_code = dtl.pur_unit_code  AND hdr.po_no = dtl.po_no  AND dtl.po_no = sch.po_no  AND dtl.item_code = sch.item_code  AND DTL.PO_SRL_NO = SCH.PO_SRL_NO  AND mmitem.item_code = dtl.item_code  AND stitem.item_code = dtl.item_code  AND mmitem.gen_uom_code = am.uom_code  AND mmitem.language_id = am.language_id   AND mmitem.language_id = ?  AND am.language_id = am1.language_id  AND dtl.po_uom = am1.uom_code  AND st.item_code(+) = dtl.item_code  AND st.store_code(+) = dtl.req_store_code AND (dtl.req_store_code = ? OR dtl.req_store_code = '*A')  AND (   dtl.req_facility_id = ? OR dtl.req_facility_id = '*A') AND po_date BETWEEN TO_DATE (TO_CHAR (NVL (?,'01/01/1901')),'DD/MM/YYYY') AND NVL (TO_DATE (?, 'DD/MM/YYYY'),SYSDATE) AND dtl.po_no = ?  AND dtl.pur_unit_code = ?  AND dtl.item_code LIKE ? ) A  WHERE A.ITEM_QTY_NORMAL > 0 AND A.AVAIL_QTY > 0  AND DECODE(A.DO_NO,'','FN',A.DO_STATUS) IN ('FN','PR') ORDER BY PO_NO,";//Modified for TFS Id:-17345
			if(multi_selct_appl){
			if(sort_by.equals("ITEMCODE")){
				sql1=sql1+" ITEM_CODE, DO_NO";
			}
			else{
				sql1=sql1+" ITEM_DESC, DO_NO";
			}
			}
			else
				sql1=sql1+" ITEM_DESC, DO_NO";
			//Modified for IN:071539 end
		}

		ArrayList alExpData =  (ArrayList)bean.fetchRecords(sql1,alParameters);
		
        int alsize = alExpData.size();
		if ( alsize > 0 ){
		hmExpData.put((String)hm.get("PO_NO"),alExpData);
		j++;
		}
		else{
        alTemp.remove(j);
		total--;
		}
	}
		bean.setPoItemDetails(hmExpData);

	
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(store_code));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(total));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(qty_override_yn));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(com.ehis.util.DateUtils.getCurrentDate("DMY",locale).toString()));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(multi_selct_appl_chk));
            _bw.write(_wl_block17Bytes, _wl_block17);

	for(int k=0;k<total;k++ ){  
	hmTemp = (HashMap)alTemp.get(k);

	 pur_unit_code =	bean.checkForNull((String)hmTemp.get("PUR_UNIT_CODE"));
	 pur_unit_desc = 	(String)bean.fetchRecord("SELECT pur_unit_code,long_desc short_desc FROM po_purchase_unit	WHERE pur_unit_code=?",pur_unit_code).get("SHORT_DESC");

	 ArrayList alBatchDetails = (ArrayList)hmExpData.get((String)hmTemp.get("PO_NO"));

	 new_po_no = bean.checkForNull((String)hmTemp.get("PO_NO"));
	 
	 int batchcount =	 alBatchDetails.size();
	
	 classValue	=	"QRYODD";

	
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(bean.checkForNull((String)hmTemp.get("PO_NO"))));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(batchcount));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(k));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(bean.checkForNull((String)hmTemp.get("PO_NO"))));
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(pur_unit_desc));
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(new_po_no));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(new_po_no));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(new_po_no));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(new_po_no));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(img_next_del_date));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(bean.getImage("M")));
            _bw.write(_wl_block31Bytes, _wl_block31);
if(multi_selct_appl){ 
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(new_po_no));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(new_po_no));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(batchcount));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(bean.checkForNull((String)hmTemp.get("PO_NO"))));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(k));
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);
}else{ 
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);
} 
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);

		for(int i=0;i<alBatchDetails.size();i++){

		HashMap hmBatchDetails = (HashMap)alBatchDetails.get(i);
		
		String[] qtyparam = {bean.checkForNull((String)hmBatchDetails.get("REQ_FACILITY_ID")),bean.checkForNull((String)hmBatchDetails.get("REQ_NO")),bean.checkForNull((String)hmBatchDetails.get("REQ_SRL_NO"))};
	 
		temp = bean.fetchRecord("SELECT REQ_QTY,REQ_UOM  FROM PO_REQUEST_DETAIL	WHERE FACILITY_ID=? and REQ_NO = ? and REQ_SRL_NO = ? " ,qtyparam);

		req_qty = bean.checkForNull((String)temp.get("REQ_QTY"));
		req_uom = bean.checkForNull((String)temp.get("REQ_UOM"));

		st_uom_code = bean.checkForNull((String)hmBatchDetails.get("DEF_ISSUE_UOM"));
		String[] qtyparam1 = {(String)hmBatchDetails.get("ITEM_CODE"),store_code};
		if(st_uom_code.equals("")){
			temp=null;

		
			temp = bean.fetchRecord("SELECT DEF_ISSUE_UOM  FROM ST_ITEM_STORE WHERE ITEM_CODE=? and STORE_CODE = ? " ,qtyparam1);
            
			st_uom_code = bean.checkForNull((String)temp.get("DEF_ISSUE_UOM"));
		}
		
			st_uom_desc = bean.checkForNull(bean.getUOMDesc(st_uom_code));

		grn_qty_readonly = "";
		//added for NMC-JD-CRF-0142 start
		temp = bean.fetchRecord("SELECT COUNT(*) COUNT FROM ST_ITEM_STORE WHERE ITEM_CODE=? AND STORE_CODE=? " ,qtyparam1);
		int count = Integer.parseInt((String)temp.get("COUNT"));
		if(count==0){
			Item_Store_Combination="No";
			bckcolor ="background-color:pink;";
		}
		else{
			Item_Store_Combination="Yes";
			bckcolor ="";
		}
		//added for NMC-JD-CRF-0142 end

		if(bean.checkForNull((String)hmBatchDetails.get("DO_NO")).equals("")){
			receipt_qty = bean.checkForNull((String)hmBatchDetails.get("AVAIL_QTY"));
		}else{
			receipt_qty = bean.checkForNull((String)hmBatchDetails.get("AVAIL_QTY"));
			grn_qty_readonly	= "Readonly";
		}
		
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(bckcolor));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(new_po_no));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(new_po_no));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(new_po_no));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(i));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(batchcount));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(batchcount));
            _bw.write(_wl_block56Bytes, _wl_block56);
if(multi_selct_appl){ 
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(bckcolor));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("ITEM_CODE"))));
            _bw.write(_wl_block60Bytes, _wl_block60);
} 
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(bckcolor));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("ITEM_DESC"))));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(bckcolor));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("DO_NO"))));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("REQ_NO"))));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("PO_NO"))));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("ITEM_DESC"))));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("ITEM_CODE"))));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("PO_SRL_NO"))));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("DO_NO"))));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(bckcolor));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(st_uom_desc));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(bckcolor));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("REQ_NO"))));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(req_qty));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(bean.checkForNull(bean.getUOMDesc(req_uom))));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(bckcolor));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("PO_QTY"))));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(bckcolor));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("PUR_UOM_DESC"))));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(bckcolor));
            _bw.write(_wl_block75Bytes, _wl_block75);
 
				if(!bean.checkForNull((String)hmBatchDetails.get("DO_NO")).equals("")){
			
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("DO_QTY_NORMAL"))));
            _bw.write(_wl_block77Bytes, _wl_block77);

				}
			
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("ITEM_QTY_NORMAL"))));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(bckcolor));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(receipt_qty));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(bckcolor));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(i));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(new_po_no));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(no_deci));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(new_po_no));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(batchcount));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(grn_qty_readonly));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(bckcolor));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(Item_Store_Combination));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(new_po_no));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(new_po_no));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("ITEM_CODE"))));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(new_po_no));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(new_po_no));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("REQ_NO"))));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(new_po_no));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(new_po_no));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(req_qty));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(new_po_no));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(new_po_no));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("ITEM_QTY_NORMAL"))));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(new_po_no));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(new_po_no));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(receipt_qty));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(new_po_no));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(new_po_no));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(pur_unit_code));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(new_po_no));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(new_po_no));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("LOCAL_CURRENCY"))));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(new_po_no));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(new_po_no));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("TRANS_CURRENCY"))));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(new_po_no));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(new_po_no));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("CONVERSION_RATE"))));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(new_po_no));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(new_po_no));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("ALLOW_DECIMALS_YN"),"N")));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(new_po_no));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(new_po_no));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("DO_NO"))));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(new_po_no));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(new_po_no));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("INVOICE_NO"))));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(new_po_no));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(new_po_no));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("INVOICE_RECD_BY"))));
            _bw.write(_wl_block121Bytes, _wl_block121);
}
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(new_po_no));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(new_po_no));
            _bw.write(_wl_block125Bytes, _wl_block125);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(batchcount));
            _bw.write(_wl_block127Bytes, _wl_block127);

	}
	
            _bw.write(_wl_block128Bytes, _wl_block128);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.PurchaseOrderDetails.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.PORaisedBy.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.DelDateForPendQty.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Select.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.ItemCode.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Select.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.item.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.DoNo.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.StockUOM.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.ReqNo.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.RequestedQty.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.OrderQty.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.DOQty.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.BackOrderQty.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.GRNQuantity.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.ItemStoreCombination.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Add.label", java.lang.String .class,"key"));
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
}
