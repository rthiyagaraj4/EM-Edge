package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import ePH.*;
import ePH.Common.*;
import eST.*;
import eST.Common.*;
import eCommon.Common.*;
import java.text.DecimalFormat;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __reissuemedbatchlookup extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/ReissueMedBatchLookup.jsp", 1731574864149L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n ";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<HTML>\n\t<HEAD>\n\t<!-- <LINK REL=\"stylesheet\" TYPE=\"text/css\" HREF=\"../../eCommon/html/IeStyle.css\"></LINK> -->\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n\t\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../eCommon/js/common.js\"></SCRIPT>\n\t\t<SCRIPT LANGUAGE=\"JavaScript\" SRC=\"../../ePH/js/ReissueMed.js\"></script>\n\t\t<SCRIPT LANGUAGE=\"Javascript\" SRC=\"../../eCommon/js/ValidateControl.js\"></SCRIPT>\n\t\t<SCRIPT LANGUAGE=\"JavaScript\" SRC=\"../../ePH/js/PhCommon.js\"></SCRIPT>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</HEAD>\n\t<!-- <body onload=\"shiftFocus()\">  -->\n\t<body onload=\"shiftFocus()\" onMouseDown=\"\" onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<form name=\"ReissueMedBatchLookup\" id=\"ReissueMedBatchLookup\">\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =" <script>alert(getMessage(\"ITEM_NOT_AVAILABLE\",\"PH\"));</script>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t<table width=\"100%\" >\n\t\t\t\t\t<tr><td class=\"white\" align=right><input type=\"button\" value=\"Stock Availability\" class=\"button\"  name=\"stkAvailability\" id=\"stkAvailability\" onclick=\"stockdialog(\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\',\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\')\"> </td></tr>\n\t\t\t\t</table> <!-- store code removed and disp_locn added for showing current dispensing location batches --> \n\t\t\t\t<table cellpadding=\"1\" cellspacing=\"1\" width=\"100%\" align=\"center\" border=\"1\" id=\"batchtable\" name=\"batchtable\" id=\"batchtable\">\n\t\t\t\t\t\n\t\t\t\t\t <!-- added for ML-BRU-SCF-1073 by Ganga -->\n\t\t\t\t\t<tr><th colspan=\"8\" align=\"left\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</th>\t</tr>\n\t\t\t\t\t\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<th>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</th>\n\t\t\t\t\t\t<th>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</th>\n\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t\t\t\t\t<tr><td colspan=\"8\" align=\"left\" class=\"CURRTEXT\"><font size=\"1\" style=\"font-weight:bold\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" : ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</font></td></tr>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td align=\"left\" width=\"10%\" class=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"item_drug_code";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" id=\"item_drug_code";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\"><input type=\"hidden\" name=\"item_drug_color";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" id=\"item_drug_color";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">&nbsp;";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="<input type=\"hidden\" name=\"expiry_date";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" id=\"expiry_date";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td align=\"left\" width=\"10%\" class=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="<input type=\"hidden\" name=\"batch_id";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" id=\"batch_id";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\"></td>\n\t\t\t\t\t\t\t\t<td align=\"left\" width=\"20%\" class=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="<input type=\"hidden\" name=\"trade_id";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" id=\"trade_id";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</td>\n\t\t\t\t\t\t\t\t<td align=\"left\" width=\"15%\" class=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="<input type=\"hidden\" name=\"bin_locn_code";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" id=\"bin_locn_code";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\"></td>\n\t\t\t\t\t\t\t  \n\t\t\t\t\t\t\t\t<td align=\"left\" width=\"12%\" class=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="<input type=\"hidden\" name=\"alloc_qty";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" id=\"alloc_qty";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\"></td>\n";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t\t\t\t\t<td align=\"left\" width=\"8%\" class=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\">\n\t\t\t\t\t\t\t\t<input type=\"text\" class=\"flat\" size=\"8\" value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" id=\"issue_qty";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" name=\"issue_qty";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" style=\"text-align:right\" onKeyPress=\"return allowValidNumber(this,event,6,0);\" onBlur=\"checkstock(this,\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\');\" maxlength=\"5\">\n\t\t\t\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\" name=\"Hissue_qty";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"issue_uom";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\" id=\"issue_uom";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\">\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td align=\"center\" width=\"5%\" class=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\"><input type=\"checkbox\"  name=\"select";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\" id=\"select";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\" ";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 =" onClick=\"validateCheck(this,\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\')\"></td>\n\t\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t\t</table>\n\t\t\t\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"drug_code\" id=\"drug_code\" value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\"> \n\t\t\t\t<input type=\"hidden\" name=\"totalRecords\" id=\"totalRecords\" value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\"> \n\t\t\t\t<input type=\"hidden\" name=\"alt_drug_code\" id=\"alt_drug_code\" value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\"> \n\t\t\t\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\"> \n\t\t\t\t<input type=\"hidden\" name=\"order_id\" id=\"order_id\" value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\"> \n\t\t\t\t<input type=\"hidden\" name=\"uom\" id=\"uom\" value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"bms_qty\" id=\"bms_qty\" value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"order_line_no\" id=\"order_line_no\" value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"source\" id=\"source\" value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"recno\" id=\"recno\" value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"tot_qty\" id=\"tot_qty\" value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"item_cost\" id=\"item_cost\" value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"conv_factor\" id=\"conv_factor\" value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"baseUOM\" id=\"baseUOM\" value=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\"> <!-- //Added for HSA-SCF-0221-->\n";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t\t\t<table width=\"100%\">\n\t\t\t\t\t<tr><td class=\"white\" align=right><input type=\"button\" value=\"Stock Availability\" class=\"button\"  name=\"stkAvailability\" id=\"stkAvailability\" onclick=\"stockdialog(\'";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\')\"> </td></tr>\n\t\t\t\t</table>\n\t\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" border=\"1\" id=\"batchtable\" name=\"batchtable\" id=\"batchtable\">\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<th>";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td width=\"10%\" class=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\">";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="</td>\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"expiry_date";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\">\n\t\t\t\t\t\t\t\t<td width=\"10%\" class=\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="</td>\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"batch_id";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\">\n\t\t\t\t\t\t\t\t<td width=\"20%\" class=\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="</td>\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"trade_id";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="</td>\n\t\t\t\t\t\t\t\t<td width=\"15%\" class=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="</td>\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"bin_locn_code";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\">\n\t\t\t\t\t\t\t\t<td width=\"12%\" class=\"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="</td>\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<td width=\"8%\" class=\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\"><input type=\"text\" class=\"flat\" size=\"8\" value=\"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\" style=\"text-align:right\" align=\"center\" onKeyPress=\"return allowValidNumber(this,event,6,0);\" onBlur=\"checkstock(this,\'";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\');\" >\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td width=\"5%\"><input type=\"checkbox\"  name=\"select";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\" checked></td>\n\t\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\n\t\t\t\t\t<input type=\"hidden\" name=\"conv_factor\" id=\"conv_factor\" value=\"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"baseUOM\" id=\"baseUOM\" value=\"";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\"> <!--//Added for HSA-SCF-0221-->\n";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\n\t\t\t\t<input type=\"hidden\" name=\"item_code\" id=\"item_code\" value=\"";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"store_code\" id=\"store_code\" value=\"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\">\n";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\n\t\t</form>\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
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
            _bw.write(_wl_block5Bytes, _wl_block5);

		request.setCharacterEncoding("UTF-8");
	//Added by Himanshu for MMS-ME-SCF-0097 Starts 
	request= new XSSRequestWrapper(request); 
	response.addHeader("X-XSS-Protection", "1; mode=block"); 
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//Added by Himanshu for MMS-ME-SCF-0097 ends
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

		String drug_code			=	"";
		String item_code			=	request.getParameter("item_code");
		String store_code			=	request.getParameter("store_code");
		String item_name 			=   request.getParameter("reissue_drug_name"); // added for ML-BRU-SCF-1073 by Ganga 		

            _bw.write(_wl_block8Bytes, _wl_block8);

			try{
				String recno				=	request.getParameter("no");
				String qty					=	request.getParameter("qty");
				String uom					=	request.getParameter("qty_uom");
				String disp_uom				=	request.getParameter("disp_uom");
				String Disp_facility_id			=   request.getParameter("Disp_facility_id");

				String decimalStringFormat = "#.####";
				DecimalFormat dfToInteger = new DecimalFormat(decimalStringFormat);

				String bean_id		= "ReissueMedBean" ;
				String bean_name	    = "ePH.ReissueMedBean";
				ReissueMedBean beanObj	= (ReissueMedBean)getBeanObject(bean_id,bean_name,request);
				String uom_code				= ""; //Added for HSA-SCF-0221

				if(!(request.getParameter("calledfrom").equals("modelwin"))){
					drug_code					=	request.getParameter("drug_code");
					String patient_id			=	request.getParameter("patient_id");
					String order_id				=	request.getParameter("order_id");
					String order_line_no		=	request.getParameter("order_line_no");
					String end_date				=	request.getParameter("end_date");
					String patient_class		=   request.getParameter("patient_class");
					String fill_period			=   request.getParameter("fill_period");
					String fill_unit			=   request.getParameter("fill_unit");
					String source				= "";
					String drug_strength		= "";
					String bms_strength			= "";
					String bms_qty				= "";
					String alt_drug_strength	= "";
					String called_from			= "";
					String drug_color			= "";
					String alt_drug_code		= "";
					String class_name			= "";
					String batch_id				= "";
					String expiry_date			= "";
					String issue_qty			= "";
					String item_drug_code		= "";
					String trade_name			= "";
					String manufacturer_name	= "";
					String bin_location			= "";
					String trade_id				= "";
					String bin_locn_code		= "";
					String batch_ids			= request.getParameter("batchId");
					String binLocCode			= request.getParameter("binLocCode");
					String expiryDate			= request.getParameter("expiryDate");
					String issued_qtys			= request.getParameter("issued_qty");
					String disp_locn  = beanObj.getDispLocnCode(); //added for FD-BRU-CRF-092
					HashMap		stock				=	new HashMap();
					ArrayList   for_stock_1			=	new ArrayList();
					ArrayList   for_stock_2			=	new ArrayList();
					ArrayList	stock_detail		=	new ArrayList();
					HashMap		drug_detail			=	new HashMap();

					String	bean_id_2		=	"StUtilities" ;
					String	bean_name_2		=	"eST.Common.StUtilities";
					StUtilities bean_2		=	null;
				//hard coded this function should be checked..
					//String		sys_date			=	"02/02/2004";

					/** Stock Bean Integration -Start ***/
					try { 
						bean_2 = (StUtilities)getBeanObject( bean_id_2,bean_name_2,request );
						bean_2.setLanguageId(locale);
					}
					catch (Exception exception) {
						exception.printStackTrace();
					}

					String	bean_id_3		=	"BatchSearchBean" ;
					String	bean_name_3		=	"eST.BatchSearchBean";

					BatchSearchBean bean_3	= (BatchSearchBean)getBeanObject( bean_id_3,bean_name_3,request);
					bean_3.setLanguageId(locale);
					/** Stock Bean Integration -End ***/ 

					StringTokenizer STbatchids = new StringTokenizer(batch_ids,"~");
					StringTokenizer STexpdate = new StringTokenizer(expiryDate,"~");
					StringTokenizer STlocncode = new StringTokenizer(binLocCode,"~");
					StringTokenizer STissued_qtys = new StringTokenizer(issued_qtys,"~");
					while(STbatchids.hasMoreElements()){
						for_stock_1		=	new ArrayList();
						batch_id		=	STbatchids.nextToken();
						expiry_date		=	STexpdate.nextToken();
						bin_locn_code	=	STlocncode.nextToken();
						for_stock_1.add(batch_id);
						for_stock_1.add(expiry_date);
						for_stock_1.add(bin_locn_code);
						for_stock_2.add(for_stock_1);
					}	

					if(alt_drug_code.equals(""))	{
						item_drug_code	=	drug_code;
					}
					else {
						item_drug_code	=	alt_drug_code;
					}

					String tmp_drug_code		=	item_drug_code;
					String tmp_drug_color		=	drug_color;
					String item_drug_color		=	drug_color;
					String tmp_item_code		=	"";
					String quantity				=	"";
					String select_status		=	"";

					ArrayList stock_items		=	new ArrayList();

					if(alt_drug_code.equals("")) {
						qty		=	new Float(qty).intValue()+"";
					}
					else {
						if(!drug_strength.equals("") && !alt_drug_strength.equals("")) { 
							bms_qty	=	new Float(Float.parseFloat(bms_strength)/	Float.parseFloat(alt_drug_strength)).intValue()+"";
							qty		=	bms_qty;
						} 
					}

					HashMap params			=	new HashMap();
					params.put("ITEM_CODE",item_code);
			//		params.put("STORE_CODE",store_code); commented for FD-BRU-CRF-092
					params.put("STORE_CODE",disp_locn); // added for FD-BRU-CRF-092
					params.put("TRN_QTY",qty);
					params.put("INCLUDE_SUSPENDED","FALSE");
					params.put("INCLUDE_EXPIRED","FALSE");
					params.put("CUT_OFF_DATE",end_date);
					params.put("VERIFY_INSUFFICIENT_QTY","FALSE");

					stock					=	bean_2.getBatches(params);
					stock_detail			=	(ArrayList)stock.get("BATCH_DATA");
					if(stock_detail.size() == 0) // Added for FD-BRU-CRF-092
						{ 
						 
            _bw.write(_wl_block9Bytes, _wl_block9);

						}

					ArrayList st_detail		=	new ArrayList();

					if(called_from.equals("stock") && bean_3.getSelectedList()!=null) {
						st_detail.add(bean_3.getSelectedList());	   
					} 
					else if(for_stock_2.size()!=0) {
						stock				=	bean_2.getBatches(params,for_stock_2);
						st_detail.add((ArrayList)stock.get("BATCH_DATA"));
					} 
					else {
						st_detail.add((ArrayList)stock.get("BATCH_DATA"));
					} 
					HashMap IssueUOMAndBaseUOM		=	(HashMap)beanObj.getStoreDfltIssueUOMAndBaseUOM(store_code,item_code);
					Double base_to_disp_uom_equl    =1.0;
					Double base_to_def_uom_equl	    =1.0;
					if(! IssueUOMAndBaseUOM.get("BASE_UOM").equals(disp_uom)){
						  base_to_disp_uom_equl    =	beanObj.getEqulValue ( item_code, (String)IssueUOMAndBaseUOM.get("BASE_UOM"), disp_uom);
					}
					if(!IssueUOMAndBaseUOM.get("BASE_UOM").equals((String)IssueUOMAndBaseUOM.get("DEF_ISSUE_UOM"))){
						base_to_def_uom_equl	    =   beanObj.getEqulValue ( item_code, (String)IssueUOMAndBaseUOM.get("BASE_UOM"), (String)IssueUOMAndBaseUOM.get("DEF_ISSUE_UOM"));
					}
					Double conv_factor              =  ( beanObj.lcm( base_to_disp_uom_equl,base_to_def_uom_equl))/base_to_disp_uom_equl; 
					uom_code = (String)IssueUOMAndBaseUOM.get("BASE_UOM"); //Added for HSA-SCF-0221

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(disp_locn));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(recno));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(qty));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(uom));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(Disp_facility_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(java.net.URLDecoder.decode(item_name,"UTF-8")));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
	
					double tot_qty	=	0;
					tmp_item_code		=	"";
					double tmp_qty			=	0;
					int rec_no			=	0;

					for(int i=0; i<st_detail.size(); i++)	{
							
						batch_id			=	"";
						expiry_date			=	"";
						issue_qty			=	"";
						trade_id			=	"";
						bin_locn_code		=	"";
						item_drug_code		=	tmp_drug_code;
						item_drug_color		=	tmp_drug_color;
						drug_color			=	item_drug_color;
						if(st_detail.get(i) != null)
							stock_detail		=	(ArrayList) st_detail.get(i);

						for(int j=0; j<stock_detail.size(); j++ ) {
							drug_detail			=	(HashMap)stock_detail.get(j);
							item_drug_code		=	(String)drug_detail.get("ITEM_CODE");	
							expiry_date			=	(String)drug_detail.get("EXPIRY_DATE");	
							batch_id			=	(String)drug_detail.get("BATCH_ID");	
							trade_id			=	(String)drug_detail.get("TRADE_ID");	
							trade_name			=	(String)drug_detail.get("TRADE_NAME");	
							manufacturer_name	=	(String)drug_detail.get("MANUFACTURER_NAME");	
							bin_locn_code		=	(String)drug_detail.get("BIN_LOCATION_CODE");
							bin_location		=	(String)drug_detail.get("BIN_DESC");	
							issue_qty			=	(String)drug_detail.get("AVAIL_QTY");		
							quantity			=	"";
							select_status		=	"";
							tot_qty				+=	Double.parseDouble(issue_qty);

							if(for_stock_2.size()!=0){
								 quantity =STissued_qtys.nextToken();
							}

							if(j%2==0)
								class_name	=	"QRYEVENSMALL"; 
							else
								class_name	=	"QRYODDSMALL";

						// For getting the allocated quantity

							if(quantity.equals("") && !called_from.equals("stock")) {
								if( (Double.parseDouble(qty) < Double.parseDouble(issue_qty))) {
									quantity	=	qty;
								} 
								else  {
									quantity	=	issue_qty;
									tmp_qty		=	Double.parseDouble(qty) - Double.parseDouble(issue_qty);
									qty			=	tmp_qty+"";
								}
							}

							// Check/Uncheck Select checkbox based on quantity value
							if(!quantity.equals(""))
								select_status	=	"checked";
							
							if(stock_items.size() > 1) {
								if(!item_drug_code.equals(tmp_item_code)) {
									tmp_item_code		=	item_drug_code;

            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(tmp_item_code));
            _bw.write(_wl_block18Bytes, _wl_block18);
	
								}	
							}

            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(class_name));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(item_drug_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(item_drug_color));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(expiry_date,"DMY","en",locale)));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(expiry_date));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(class_name));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(batch_id));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(batch_id));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(class_name));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(trade_name));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(trade_id));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(class_name));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(manufacturer_name));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(class_name));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(bin_location));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(bin_locn_code));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(class_name));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(dfToInteger.format(Double.parseDouble(issue_qty))));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(issue_qty));
            _bw.write(_wl_block40Bytes, _wl_block40);
	
								if(patient_class == "IP") {
									int per_day			=0;
									if(per_day < 1)  
										per_day	=	1;
									if(fill_unit.equals("H") && !fill_period.equals("")) {
										quantity	=	new Float((Math.floor(Integer.parseInt(fill_period) / 24 )* per_day)).intValue()+"";
									} 
									else if(fill_unit.equals("D")) {
										quantity	=	(Integer.parseInt(fill_period) * per_day)+"";
									}
								} 
								quantity =(new Double(Double.parseDouble(quantity)).intValue())+"";

            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(class_name));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(quantity));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(issue_qty));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(conv_factor));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(quantity));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(uom_code));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(class_name));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(select_status));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block55Bytes, _wl_block55);
	
							rec_no++;
						}	
					}	

            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(""));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(""));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(alt_drug_code));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(uom));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(bms_qty));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(order_line_no));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(source));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(recno));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(tot_qty));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(0));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(conv_factor));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(uom_code));
            _bw.write(_wl_block72Bytes, _wl_block72);

				// objects nullified after usage
				stock				=	null;
				for_stock_1			=	null;
				for_stock_2			=	null;
				stock_detail		=	null;
				drug_detail			=	null;
				stock_items			=	null;
				params				=	null;
				st_detail			=	null;

				putObjectInBean(bean_id_2,bean_2,request);
				putObjectInBean(bean_id_3,bean_3,request);
			}
			else{

            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(store_code));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(recno));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(qty));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(uom));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(Disp_facility_id));
            _bw.write(_wl_block74Bytes, _wl_block74);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

					HashMap IssueUOMAndBaseUOM		=	(HashMap)beanObj.getStoreDfltIssueUOMAndBaseUOM(store_code,item_code);
					Double base_to_disp_uom_equl    =	beanObj.getEqulValue ( item_code, (String)IssueUOMAndBaseUOM.get("BASE_UOM"), disp_uom);

					Double base_to_def_uom_equl	    =   beanObj.getEqulValue ( item_code, (String)IssueUOMAndBaseUOM.get("BASE_UOM"), (String)IssueUOMAndBaseUOM.get("DEF_ISSUE_UOM"));
					Double conv_factor              =  ( beanObj.lcm( base_to_disp_uom_equl,base_to_def_uom_equl))/base_to_disp_uom_equl; 
					uom_code = (String)IssueUOMAndBaseUOM.get("BASE_UOM"); //Added for HSA-SCF-0221
					int rec_no =  0;
					String 	batch_id				= "";
					item_code						= "";
					store_code						= "";
					String expiry_date			    = "";
					String bin_locn_code			= "";
					String bin_locn_desc			= "";
					String trade_id					= "";
					String trade_desc				= "";
					String manufacturer_desc	= "";
					String avail_qty		="";
					String class_name = "";
					String retval = request.getParameter("retval");
					StringTokenizer record		= new StringTokenizer (retval,"~");
					while(record.hasMoreElements()){
						ArrayList items = new ArrayList();
						StringTokenizer item = new StringTokenizer(record.nextToken() ,"`" );
						while(item.hasMoreElements()) {
							items.add(item.nextToken());
						}
								
						for (int j=0; j<items.size()-1;j+=16){
							batch_id				= (String) items.get(j);
							item_code				= (String) items.get(j+1);
							store_code				= (String) items.get(j+3);
							expiry_date				= (String) items.get(j+6);
							bin_locn_code			= (String) items.get(j+7);
							bin_locn_desc			= (String) items.get(j+8);
							trade_id				= (String) items.get(j+9);
							trade_desc				= (String) items.get(j+10);
							manufacturer_desc		= (String) items.get(j+14);
							avail_qty				= (String) items.get(j+15);
							if(j%2==0)
								class_name	=	"QRYEVENSMALL"; 
							else
								class_name	=	"QRYODDSMALL";

            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(class_name));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(expiry_date,"DMY","en",locale)));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(expiry_date));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(class_name));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(batch_id));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(batch_id));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(class_name));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(trade_desc));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(trade_id));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(class_name));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(manufacturer_desc));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(class_name));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(bin_locn_desc));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(bin_locn_code));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(class_name));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(dfToInteger.format(Double.parseDouble(avail_qty))));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(class_name));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(qty));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(avail_qty));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(conv_factor));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block89Bytes, _wl_block89);
	
							rec_no++;	
						}	
					}

            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(conv_factor));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(uom_code));
            _bw.write(_wl_block92Bytes, _wl_block92);

				}

            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(store_code));
            _bw.write(_wl_block95Bytes, _wl_block95);

			}
			catch(Exception e){
				e.printStackTrace();
			}

            _bw.write(_wl_block96Bytes, _wl_block96);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.expiryDate.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BatchID.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.TradeName.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Manufacturer.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BinLocation.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.AvailableQty.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AllocatedQuantity.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.item.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.expiryDate.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BatchID.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.TradeName.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Manufacturer.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BinLocation.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.AvailableQty.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AllocatedQuantity.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
