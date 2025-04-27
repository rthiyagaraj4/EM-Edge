package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eOR.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import eOR.Common.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __orderentryduplicate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/OrderEntryDuplicate.jsp", 1709119796000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\t\n<html>\n\t<head>\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\t\n\t\t<title>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</title>\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t<title>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</title>\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' type=\'text/css\'/></link>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eOR/js/OrderEntry.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eOR/js/OrderEntrySearch.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\t</head>\n<body OnMouseDown=\"CodeArrest()\"; onKeyDown=\"lockKey()\" onload = \"showDupeReasonText(";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =",";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =")\"> <!-- IN047632 -->\n\t<form name =\"duplicateForm\">\t\n\t<!--  [IN030464] Start -->\n\t<BGSOUND><bgsound src=\"../../eCA/images/DuplicateOrder.wav\" LOOP=1></BGSOUND >\n\t<!--  [IN030464] End -->\n\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" align=\"CENTER\" class=\"grid\">\n\t\t<tr><td class=\"gridHeader\">&nbsp;</td>\n\t    ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t<td class = \"gridHeader\" nowrap id=\"catalogDesc\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t<input type=\"checkbox\" name=\"chk";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" id=\"chk";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" id=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" checked value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" onclick=\"validateCatalogs(this,\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\');enableMultiDupeReason(\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\')\">\n\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" name=\"hd";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n\t\t\t\t\t<a href=\"#\" id = \'order_dupe_reason";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'  style=\'display:inline\' title=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' onclick=\"addDupeCodeReason(\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\',\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\')\"> Dup... </a><label  id=\"dup_mand";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" Title=\"dup reason\"  style=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\"><img src=\"../../eCommon/images/mandatory.gif\"></img></label><!-- added for SS-CRF-20045 --> <!--IN024984 added mandatory img-->\n\t\t\t\t\t<input type=\"hidden\" name=\"mand";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" id=\"mand";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\n\t\t\t\t</td>\n\t\t\t\t\n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr id = \'patient_row";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'>\n\t\t\t\t\t<td class=\"gridData\"  id =\"reject_order_hdr";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="<input type=\"checkbox\" name=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" id=\"pat";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" checked onclick=\"validatePatients(this,\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\')\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"pat_id";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" id=\"pat_id";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\">\n\t\t\t\t\t</td>\n\t\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t\t\t<td  class=\"gridData\" id =\"reject_order";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" > <!-- IN047686 End -->\n\t\t\t\t\t\t\t<B>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t\t\t\t\t\t<font color=\"red\" size=\"3\">X</font>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t\t\t\t\t\t<font color=\"Orange\" size=\"3\">X</font>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t\t\t\t\t</B>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t\t<input type=\"hidden\" name=\"patRejectOrder";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\" id=\"patRejectOrder";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\" value =\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\">\n\t\t\t\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t</table>\n\t\t\t<!-- IN024984, IN047686 Start -->\n\t\t\t<table valign=\'center\' border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" height = \'150px\' align=\"CENTER\" >\n<tr><td>\t\t\t\n\t\t\t\t<tr> \n\t\t\t\t\t\t<td valign=\'center\' class=\'gridHeader\' id =\'dupe_reason_header_title\' style = \'text-align:center;display:none;\'  >";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="</td> <!-- IN047632  -->\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t\t<!--<td valign=\'center\' class=\'gridData\' id =\'dupe_reason_header_text\' style = \'text-align:center;display:none;\' ><textarea name=\"dup_override_reason\"  value=\"\" rows=\"3\" cols=\"50\" maxlength=\'2000\' onKeyPress=\'checkMaxLimit(this,2000);\'    onBlur=\"makeValidString(this)\" ></textarea></td> <!-- IN047632  --> <!--Commented for IN062607-->\n\t\t\t\t\t\t<td valign=\'center\' class=\'gridData\' id =\'dupe_reason_header_text\' style = \'text-align:center;display:none;\' ><textarea name=\"dup_override_reason\"  value=\"\" rows=\"3\" cols=\"50\" maxlength=\'2000\' onKeyPress=\'checkMaxLimit(this,2000);\'    onBlur=\"makeValidString(this)\" >";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="</textarea></td> <!-- IN047632  --> <!--Modified for IN062607-->\n\t\t\t\t</tr>\t\n</td></tr>\t\t\t\t\n\t\t\t<!-- IN024984, IN047686 End -->\n\t\t\t</table>\n\t\t\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t<br>\n\t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" align=\"CENTER\">\n\t\t<tr>\n\t\t\t<td class=\"LABEL\" colspan=\"3\" width=\"100%\">\n\t\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\"LABEL\" colspan=\"2\" width=\"50%\"><b><font size=\"2\">";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="</font></b>\n\t\t\t\t\t\t</td><td class=\"label\" width=\"50%\"><b><font size=\"2\">";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="</b></td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t\t\t\t<tr>\n\t\t\t\t\t<td width=\"65%\"><a href=\"#\" onclick=\"viewDuplicateRecords(\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\')\">";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="</a></td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t\t\t\t\t<td width=\"5%\">\n\t\t\t\t\t<input type=\"checkbox\"  name=\'chk";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\' id=\'chk";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\' value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\" ";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 =" onclick = \"enableDupeReason(\'";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\')\">\n\t\t\t\t\t</td>\n\t\t\t\t\t<!-- IN024984 Start -->\n\t\t\t\t\t";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t\t\t\t\t<td width=\"40%\" id = \'order_dupe_reason";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\' style=\'display:inline\'>\n\t\t\t\t\t\t<a href=\"#\" onclick=\"addDupeCodeReason(\'";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\')\"> ";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 =" </a> <label  id=\"dup_mand\" Title=\"dup reason\"  style=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\"><img src=\"../../eCommon/images/mandatory.gif\"></img></label><!-- added for SS-CRF-20045 --> <!--IN024984 added mandatory img-->\n\t\t\t\t\t</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\t\t\t\t\t<td width=\"40%\">&nbsp;</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\t\t\t\t\t<input type=\"hidden\" name=\"DupDesckey";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\" id=\"DupDesckey";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\">\t\n\t\t\t\t\t<input type=\"hidden\" name=\"mand";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"discard";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\" id=\"discard";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\" value=\"N\">\n\t\t\t\t\t<!-- IN024984 End -->\n\t\t\t\t\t</tr><td>\n";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\n\t\t\t\t\t<!-- IN024984 Start -->\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td colspan=\"3\" id =\'dupe_reason_header_title\' style = \'font-size:9pt;font-weight:normal;text-align:center;display:none\'  >";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="</td> <!-- IN047632  -->\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<!--<td id =\'dupe_reason_header_text\' style = \'font-size:9pt;font-weight:normal;text-align:center;display:none\' ><textarea name=\"dup_override_reason\"  value=\"\" rows=\"3\" cols=\"50\" maxlength=\'2000\' onKeyPress=\'checkMaxLimit(this,2000);\'    onBlur=\"makeValidString(this)\" ></textarea></td>  <!-- IN047632  --> <!--Commented for IN062607-->\n\t\t\t\t\t\t<td colspan=\"3\" id =\'dupe_reason_header_text\' style = \'font-size:9pt;font-weight:normal;text-align:center;display:none\' ><textarea name=\"dup_override_reason\"  value=\"\" rows=\"3\" cols=\"50\" maxlength=\'2000\' onKeyPress=\'checkMaxLimit(this,2000);\'    onBlur=\"makeValidString(this)\" >";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="</textarea></td>  <!-- IN047632  --> <!--Modified for IN062607-->\n\t\t\t\t\t</tr>\n\t\t\t\t\t<!-- IN024984 End -->\n";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\n\t\t\t\t\t</td></tr><tr><td class=\"LABEL\" colspan=\"3\" width=\"100%\"><b><font size=\"2\">";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="</font></b></td></tr>\n\t\t\t\t";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td colspan=\"3\">";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="</td>\n\t\t\t\t\t</tr><td>\n";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\n\t\t</tr>\n\t\t<tr><td colspan=\"3\" class=\"LABEL\">&nbsp;</td></tr>\n\t</table>\n\t";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\n\t\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\">\n\t\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\">\n\t\t<input type=\"hidden\" name=\"total_dupl_count_records\" id=\"total_dupl_count_records\" value=\"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\">\n\t\t<input type=\"hidden\" name=\"total_dup_catalogs\" id=\"total_dup_catalogs\" value=\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\">\n\t\t<input type=\"hidden\" name=\"total_dup_patients\" id=\"total_dup_patients\" value=\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\">\n\t\t<input type=\"hidden\" name=\"patient_count\" id=\"patient_count\" value=\"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\">\n\t\t<input type=\"hidden\" name=\"chk_records_count\" id=\"chk_records_count\" value=\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\">\n\t\t<input type=\"hidden\" name=\"dupe_catalogcode_list\" id=\"dupe_catalogcode_list\" value=\"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\"> <!-- IN024984 -->\n\t\t<input type=\"hidden\" name=\"validated_reason_hashmap\" id=\"validated_reason_hashmap\" value=\"\"> <!-- IN024984 -->\n\t\t<input type=\"hidden\" name=\"dupe_reject_count\" id=\"dupe_reject_count\" value=\"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\"> <!-- IN047605 -->\n\t\t<input type=\"hidden\" name=\"dupe_reason_header_title\" id=\"dupe_reason_header_title\" value=\"\"><!-- IN047686 -->\n\t\t<input type=\"hidden\" name=\"dupe_reason_header_text\" id=\"dupe_reason_header_text\" value=\"\"> <!-- IN047686 -->\n\t\t<input type=\"hidden\" name=\"multi_pat_catalog_count\" id=\"multi_pat_catalog_count\" value=\"";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\"> <!-- IN024984 -->\n\t\t<input type=\"hidden\" name=\"firstDupWindow\" id=\"firstDupWindow\" value=\"";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\"><!--IN062607-->\n\t\t\n\t\t\n\t</form>\n\t</body>\n</html>\n";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );
	
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
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

/*
-----------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
-----------------------------------------------------------------------------------------
?             100            ?           	?				?				created
17/02/2014	  IN024984		Karthi		21/02/2014		Ramesh				Conditional reordering by clinician
10/03/2014	  IN024984		Chowminya	 									Duplicate order recording with reason - new mandatory option	
13/03/2014	  IN047632		Karthi											System popup Duplicate check window with Override Reason Text box for Reject Duplicate check Action 
13/03/2014	  IN047605		Karthi											Alignment format of Duplicate Override reason text is differed
14/03/2014	  IN047686		Karthi											While placing Duplicate Orders for Multiple patients through 'Multi Patient Order' getting Script error.
21/03/2014	  IN047686		Karthi											While placing Duplicate Orders for Multiple patients through 'Multi Patient Order', System not asking to capture the duplicate Override Reason.
03/07/2017    IN062607		Raja S		03/07/2017		Ramesh G			ML-MMOH-CRF-0727
12/07/2017	  IN064747		Raja S		12/07/2017		Ramesh G				ML-MMOH-CRF-0727-US 001-User Entered first duplicate popup screen comments are displayed with %% symbols in Second duplicate popup screen
09/10/2017	  IN063973		Raja S		10/10/2017		Ramesh G			SS-CRF-0058	
------------------------------------------------------------------------------------------
*/ 

            _bw.write(_wl_block1Bytes, _wl_block1);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

     request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085		
	String bean_id 					= request.getParameter("bean_id");
	String bean_name 				= request.getParameter("bean_name");
	String dupl_message				= "";  // For Lab is installed and panel dupl check
	String susp_message				= "";  // For Lab is installed and catalog is suspended
//	String ord_dupl_message			= "";
	String rd_appt = "";
	String called_from_multi				= "";
	String dup_catalogs			= "";
	String patient_id				= "";
	String dupl_patient_id		= "";
	//String rejectOrder				= "";
	String patRejectOrder		= "";

	ArrayList RejectOrders=new ArrayList();
	ArrayList DuplicateCatalogCodes=new ArrayList();	
	ArrayList dupl_ord_catalogs = new ArrayList();
	ArrayList multi_patient = new ArrayList();
			
	/* Initialize Function specific start */
	OrderEntryBean bean		= (OrderEntryBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(localeName);
	/* Initialize Function specific end */

	HashMap hashValues				= bean.getAllValues();
	HashMap NewOrderMap		=new HashMap();
	HashMap DuplicateOrderMap		=new HashMap();
	HashMap duplOrdCatalogs = new HashMap();
	StringBuilder builderCatalogList = new StringBuilder(); //IN024984 
	String catalogList	= ""; //IN024984 
	HashMap mandatoryCatagoryMap = null;  //IN024984 
	int dupl_count_alert			= 0;
	int dupl_count_error			= 0;
	//IN047632 - Start
	int dupe_reject_count			= 0;
	int new_order_count  			= 0;
	int dupe_record_count			= 0;
	//IN047632 - End
	int multi_pat_catalog_count 	= 0; //IN024984
	//int row_num = 0;
	//int col_num = 0;
	int conflict_exam_count_records = 0; int conflict_records = 0,total_records=0,total_dupl_count_records=0;
	//int row_col = 0;	
	int count_patient = 0 , count_chk_records = 0 ;
	
	//IN062607 Starts 
	String temp_dup_reason ="";
	String firstDupWin = request.getParameter("fwin")==null?"N":request.getParameter("fwin");
	String emptyVal = request.getParameter("emptyContent")==null?"N":request.getParameter("emptyContent");
	if(!"Y".equals(firstDupWin)){
		if(!"Y".equals(emptyVal)){
			temp_dup_reason=bean.getTempDupeReason()== null?"": bean.getTempDupeReason();
			temp_dup_reason = java.net.URLDecoder.decode(temp_dup_reason,"UTF-8");//[IN064747]
		}
	}
	//IN062607 Ends
	if(hashValues!=null)
	{
		dupl_message		 		= bean.checkForNull((String)hashValues.get("dupl_message"),"");
		susp_message		 		= bean.checkForNull((String)hashValues.get("susp_message"),"");
		rd_appt							= bean.checkForNull((String)hashValues.get("rd_appt"),""); // For Radialogy Appointment
		dupl_count_alert 			= Integer.parseInt(bean.checkForNull((String)hashValues.get("dupl_count_alert"),"0"));
		dupl_count_error 			= Integer.parseInt(bean.checkForNull((String)hashValues.get("dupl_count_error"),"0"));
		conflict_exam_count_records = Integer.parseInt(bean.checkForNull((String)hashValues.get("conflict_exam_count_records"),"0"));
		conflict_records = Integer.parseInt(bean.checkForNull((String)hashValues.get("conflict_records"),"0"));
		total_records = Integer.parseInt(bean.checkForNull((String)hashValues.get("total_count"),"0"));
		total_dupl_count_records = Integer.parseInt(bean.checkForNull((String)hashValues.get("total_dupl_count_records"),"0"));
		called_from_multi				= bean.checkForNull((String)hashValues.get("called_from_multi"),"");
		count_patient			= (Integer)hashValues.get("count_patient")==null?0:(Integer)hashValues.get("count_patient");
		count_chk_records	= (Integer)hashValues.get("count_chk_records")==null?0:(Integer)hashValues.get("count_chk_records");		
		for(int i=1;i<=total_dupl_count_records;i++)
		{
			DuplicateCatalogCodes.add(bean.checkForNull((String)hashValues.get("dupl_catalog_code"+i),""));
			if(called_from_multi.equalsIgnoreCase("MULTI_PATIENT_ORDERS"))
			{
				String ord_catalog_codes = bean.checkForNull((String)hashValues.get("dupl_catalog_code"+i),"");
				String ord_catalog_desc = bean.checkForNull((String)hashValues.get("dupl_catalog_desc"+i),"");
				if(!dupl_ord_catalogs.contains(ord_catalog_codes))
				{
					dupl_ord_catalogs.add(ord_catalog_codes);
					duplOrdCatalogs.put(ord_catalog_codes,ord_catalog_desc);
				}
				patient_id = bean.checkForNull((String)hashValues.get("patient_id"+i),"");
				if(!dupl_patient_id.equalsIgnoreCase(patient_id))
				{
					multi_patient.add(patient_id);
					dupl_patient_id = patient_id;
				}
			}
		}
		mandatoryCatagoryMap = bean.isDupeMandatoryHashMap(DuplicateCatalogCodes); //IN024984
	}
	for(int i=0;i<dupl_count_error;i++)
	{
		if(!RejectOrders.contains(bean.checkForNull((String)hashValues.get("reject_dupl_catalog_code"+i),"")))
			RejectOrders.add(bean.checkForNull((String)hashValues.get("reject_dupl_catalog_code"+i),""));
	}
	dupe_reject_count = RejectOrders.size(); //IN047632
	for(int dp_orders=0;dp_orders<total_records;dp_orders++)
	{
		if(!DuplicateCatalogCodes.contains((bean.checkForNull((String)hashValues.get("catalog_code"+dp_orders),""))))
		{			
			NewOrderMap.put((bean.checkForNull((String)hashValues.get("catalog_code"+dp_orders),"")),(bean.checkForNull((String)hashValues.get("cat_desc"+dp_orders),"")));
		}
		else
		{
			DuplicateOrderMap.put((bean.checkForNull((String)hashValues.get("catalog_code"+dp_orders),"")),(bean.checkForNull((String)hashValues.get("cat_desc"+dp_orders),"")));
			
		}
	}
	new_order_count = NewOrderMap.size(); //IN047632
	dupe_record_count = total_records - new_order_count; //IN047632
	multi_pat_catalog_count = dupl_ord_catalogs.size();

            _bw.write(_wl_block5Bytes, _wl_block5);

 		if(!susp_message.equals("")) 
		{ 
	
            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);

		}  
		else if(conflict_exam_count_records > 0)
		{ 
		
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
 
		}
		else if(rd_appt.equals("X"))
		{ 
		
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);
 
		} 
		else 
		{ 
		
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);
 
		} 
		String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(dupe_record_count));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(dupe_reject_count));
            _bw.write(_wl_block13Bytes, _wl_block13);

	if(called_from_multi.equalsIgnoreCase("MULTI_PATIENT_ORDERS"))
	{
	
            _bw.write(_wl_block14Bytes, _wl_block14);

		if(duplOrdCatalogs.size()>0)
		{
			for(int dupcatalogs=0;dupcatalogs<dupl_ord_catalogs.size();dupcatalogs++)
			{
				String catalog_code = (String)dupl_ord_catalogs.get(dupcatalogs);
				String catalog_desc = (String)duplOrdCatalogs.get(catalog_code);
				//IN024984 - Start
						String mand = (String)mandatoryCatagoryMap.get(catalog_code);
						String display_style = "visibility:hidden";
						if(mand!=null && mand.equals("Y"))
						{
							display_style = "visibility:visible";
						}
						//IN024984 - End
				
				
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(dupcatalogs));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(bean.checkForNull(catalog_desc,"")));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(dupcatalogs));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(dupcatalogs));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(dupcatalogs));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(catalog_code));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(dupcatalogs));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(dupcatalogs));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(catalog_code));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(dupcatalogs));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(dupcatalogs));
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(catalog_code));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(catalog_desc));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(dupcatalogs));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(display_style));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(dupcatalogs));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(dupcatalogs));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(mand));
            _bw.write(_wl_block34Bytes, _wl_block34);

			}
			for(int i=0;i<multi_patient.size();i++)
			{
				patient_id					= (String)multi_patient.get(i);
				patRejectOrder			= "";
				String[] record			= (String[])bean.getDeceasedPatientYn(patient_id);
				String patient_name	= bean.checkForNull((String)record[1],"");
				
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(patient_name));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(i));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block43Bytes, _wl_block43);

				int patTotCatalogs = (Integer)hashValues.get(patient_id);
				for(int ord_cat=0;ord_cat<duplOrdCatalogs.size();ord_cat++)
				{	
					boolean datafound = false;
					String[] str			= null;
					String catalog_code = bean.checkForNull((String)dupl_ord_catalogs.get(ord_cat),"");	
					for(int pat_cat=0;pat_cat<patTotCatalogs;pat_cat++)
					{
						String catalog_str = bean.checkForNull((String)hashValues.get(patient_id+pat_cat),"");
						if(catalog_str.indexOf("##")!=-1)
						{
							str = catalog_str.split("##");
						}
						if(catalog_code.equalsIgnoreCase(str[0]))
						{
							datafound = true;
							pat_cat = patTotCatalogs;
						}
					}
					if(datafound)
					{
					
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);

								//if(RejectOrders.contains(catalog_code))
								if(str[1].equalsIgnoreCase("R"))
								{	
									patRejectOrder = "R";
								
            _bw.write(_wl_block46Bytes, _wl_block46);

								}
								else
								{
									patRejectOrder = "";
								
            _bw.write(_wl_block47Bytes, _wl_block47);

								}
								
            _bw.write(_wl_block48Bytes, _wl_block48);

					}
					else
					{
						patRejectOrder = "";
					
            _bw.write(_wl_block49Bytes, _wl_block49);

					}
					
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            out.print( String.valueOf(ord_cat));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i));
            out.print( String.valueOf(ord_cat));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(patRejectOrder));
            _bw.write(_wl_block53Bytes, _wl_block53);

				}				
			}
			
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(temp_dup_reason));
            _bw.write(_wl_block56Bytes, _wl_block56);

		}
	}
	else
	{
	
            _bw.write(_wl_block57Bytes, _wl_block57);
	
			if((dupl_count_error > 0) || (dupl_count_alert > 0) ) // for the duplicate check
			{
			
            _bw.write(_wl_block58Bytes, _wl_block58);
            _bw.write(_wl_block59Bytes, _wl_block59);

				if((DuplicateOrderMap.size()>0))
				{
				
            _bw.write(_wl_block60Bytes, _wl_block60);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block62Bytes, _wl_block62);

					int dr=0;
					Set newmap=DuplicateOrderMap.keySet();
					Iterator iterator 	 = newmap.iterator();
					while( iterator. hasNext() )
					{
						String DupDesckey=(String)iterator.next();
						String DupKeyShortDesc = (String)DuplicateOrderMap.get(DupDesckey);
						//IN024984 - Start
						String mand = (String)mandatoryCatagoryMap.get(DupDesckey);
						String display_style = "visibility:hidden";
						if(mand!=null && mand.equals("Y"))
						{
							display_style = "visibility:visible";
						}
						//IN024984 - End
					
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(DupDesckey));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(DuplicateOrderMap.get(DupDesckey)));
            _bw.write(_wl_block65Bytes, _wl_block65);

					if(RejectOrders.contains(DupDesckey))
					{
						dup_catalogs="checked disabled";
					}
					else
					{
						dup_catalogs="";
						builderCatalogList.append(DupDesckey); //IN024984
						builderCatalogList.append("#"); //IN024984
					}
					
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(dr));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(dr));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(DupDesckey));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(dup_catalogs));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(dr));
            _bw.write(_wl_block71Bytes, _wl_block71);

					if(dup_catalogs.equals("")){
						DupKeyShortDesc = java.net.URLEncoder.encode(DupKeyShortDesc,"UTF-8");
					
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(dr));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(DupDesckey));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(DupKeyShortDesc));
            _bw.write(_wl_block74Bytes, _wl_block74);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(display_style));
            _bw.write(_wl_block76Bytes, _wl_block76);

					}else{
					
            _bw.write(_wl_block77Bytes, _wl_block77);
}					
					
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(dr));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(dr));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(DupDesckey));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(dr));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(dr));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(mand));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(dr));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(dr));
            _bw.write(_wl_block83Bytes, _wl_block83);

						dr++;
					}

            _bw.write(_wl_block84Bytes, _wl_block84);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(temp_dup_reason));
            _bw.write(_wl_block86Bytes, _wl_block86);
					
					catalogList = builderCatalogList.toString();
				}
				//commented at the top added below for IN063973 starts
				if(NewOrderMap.size()>0)
				{
				
            _bw.write(_wl_block87Bytes, _wl_block87);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block88Bytes, _wl_block88);

					Set newmap=NewOrderMap.keySet();
					Iterator iterator 	 = newmap.iterator();
					while( iterator. hasNext() )
					{
						
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(NewOrderMap.get(iterator.next())));
            _bw.write(_wl_block90Bytes, _wl_block90);

					}
				}
				//commented at the top added below for IN063973  ends
		}
		else if(conflict_exam_count_records >0) // For the Exam Conflicts for radialogy
		{
			if(conflict_records > 0 ) //That means it can be proceeded
				out.println("Exam Conflicts Found...");
			else  // otherwise cannot proceed further should stop (displaying the last record desc)
			out.println("Exam Conflicts Found...Cannot Proceed...<br>");
			out.println(bean.checkForNull((String)hashValues.get("conflict_reason0"),""));
  		}
		else if(rd_appt.equals("X")) 	// For the Radiology , if appointment is there 
		{
			out.println("Other Appointments already exists...");
		}
		else if(!susp_message.equals("")) {  // For Lab Installed and Test Codes and Panel Matching
		  	out.println("<b>"+susp_message+"</b><br> has been Suspended/Invalid.<br> Cannot Proceed...");	
		} else   // For Lab Installed and Test Codes and Panel Matching
			out.println("<b>"+dupl_message+"</b><br> is Already Selected in the Panel.<br> Cannot Proceed...");

            _bw.write(_wl_block91Bytes, _wl_block91);

	}
	
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(total_dupl_count_records));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(dupl_ord_catalogs.size()));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(multi_patient.size()));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(count_patient));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(count_chk_records));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(catalogList));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(RejectOrders.size()));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(multi_pat_catalog_count));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(firstDupWin));
            _bw.write(_wl_block103Bytes, _wl_block103);

	// no need to set it back persistence
	// putObjectInBean(bean_id,bean,request);

            _bw.write(_wl_block2Bytes, _wl_block2);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Suspended.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.ExamConflicts.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AppointmentDetails.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.DuplicateCheck.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.dupoverridereason.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.dupoverridereason.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.DuplicateOrders.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.Discard.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.dupoverridereason.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.dupoverridereason.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.NewOrders.label", java.lang.String .class,"key"));
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
}
