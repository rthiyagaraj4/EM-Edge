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
import eCommon.Common.*;
import eST.Common.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __dispmedicationwsallocatebatches extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/DispMedicationWSAllocateBatches.jsp", 1709120750832L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n  ";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<!-- This will be used on click of show batches button -->\n\n<html>\n<head>\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n\n   <script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../ePH/js/DispMedication.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../ePH/js/DispMedicationAllStages.js\"></script>\n\t\n\n</head>\n<body onMouseDown=\"\" onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<form name=\"frmDispMedicationWSAllocateBatches\" id=\"frmDispMedicationWSAllocateBatches\">\n\n\t<tr><!-- added for MMS-KH-CRF-0038 - start -->\n\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<td  width=\"20%\"  style=\'text-align:right;\'><font style=\'font-size:10;vertical-align: text-top;\'>Barcode</font> <input type=\"text\" class=\'fields\' name=\"barcode_id\" id=\"barcode_id\" style=\"text-align:right\"  onkeydown=\"if (event.keyCode==13) {validateBarcodeAllocateBatch(event,this,\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\',\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\')}\" maxlength=\"100\" size=\"80\">\n\n\t\t</td>\n\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t</tr><!-- added for MMS-KH-CRF-0038 - end -->\n\n\t<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" border=\"1\" id=\"wsallocatebatchestable\">\t\t\n\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t<input type=\"hidden\" name=\"ordered_qty";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" id=\"ordered_qty";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t<tr>\n\n\t\t\t\t<td  colspan=\"8\" style=\"background:#FDE6D0;font-size:10\">";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =" \t<B>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</B></td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t<input type=\"hidden\" name=\"drug_code";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" id=\"drug_code";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"item_code";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" id=\"item_code";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n\t\t\t\t<td  colspan=\"8\" style=\"background:#FDE6D0;font-size:10\"><B>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =" : ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</B></td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td class=\"TDSTYLE1\">\n\t\t\t\t\t<B>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</B>\n\t\t\t\t</td>\n\t\t\t\t<td class=\"TDSTYLE1\">\n\t\t\t\t\t<B>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</B>\n\t\t\t\t</td>\n\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t<td class=\"TDSTYLE1\">\n\t\t\t\t\t<B>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t<script language=\"javascript\">\n\t\t\t\t\talert(getMessage(\"PH_NOT_MORE_THAN_THREE_BATCHES\",\"PH\"));\n\t\t\t</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t<tr>\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" style=\"font-size:10\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\t<input type=\"hidden\" name=\"expiry_date";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" id=\"expiry_date";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\">\n\t\t\t\t</td>\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t\t<input type=\"hidden\" name=\"batch_id";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" id=\"batch_id";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" style=\"font-size:10\">&nbsp;";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t<input type=\"hidden\" name=\"trade_id";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" id=\"trade_id";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t\t<input type=\"hidden\" name=\"manufacturer_id";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" id=\"manufacturer_id";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t\t<input type=\"hidden\" name=\"bin_locn_code";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" id=\"bin_locn_code";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" value=\"\">\n\t\t\t\t</td>\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t\t<input type=\"hidden\" name=\"avail_qty";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\" id=\"avail_qty";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\n\t\t\t\t\t\n\t\t\t\t\t<input type=\"hidden\" name=\"barcode_id";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\" id=\"barcode_id";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\"><!-- added for MMS-KH-CRF-0038 -->\n\t\t\t\t\t\n\t\t\t\t\t<input type=\"hidden\" name=\"batch_id_manual_";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\" id=\"batch_id_manual_";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\" value=\"\"><!-- added for MMS-KH-CRF-0038 -->\n\n\t\t\t\t</td>\n\t\t\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\" style=\"font-size:10\">\n\t\t\t\t\t\t<input type=\"text\" name=\"alloc_qty";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\" id=\"alloc_qty";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\" onKeyPress=\"if(event.keyCode!=13) {return allowValidNumber(this,event,4,";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 =");}else{return false;}\"  value=\"\" size=\"6\" maxlength=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\" class=\"number\" ";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 =">\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\">\n\t\t\t\t\t\t<input type=\"checkbox\" name=\"chkSelect";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\" id=\"chkSelect";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\" value=\"E\" checked>\n\t\t\t\t\t</td>\n\t\t\t\t";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\t\t\t\t\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\" style=\"font-size:10\" >\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t\t\t\t</td>\n\t\t\t\t";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 =");}else{return false;}\"  size=\"6\" maxlength=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\" value=\"E\" checked>\n\t\t\t\t\t</td>\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\" value=\"\" onKeyPress=\"if(event.keyCode!=13) {return allowValidNumber(this,event,4,";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\" value=\"E\" checked>\n\t\t\t\t\t</td>\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t\t\t\t<input type=\"hidden\" name=\"row_count";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\" id=\"row_count";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\">\n\t\t";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n\n\t\t";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t<input type=\"hidden\" name=\"inner_count\" id=\"inner_count\" value=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\">\n\t<input type=\"hidden\" name=\"outer_count\" id=\"outer_count\" value=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\">\n\n\t</table>\n\n\t\n\t";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\t<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" border=\"1\" id=\"wsfluidallocatebatchestable\">\t\t\n\t\t<tr>\n\t\t\t<td  colspan=\"8\" style=\"background:#FDE6D0;font-size:10\">";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="</B>(<b>";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 =")</b></td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td  colspan=\"8\" style=\"background:#FDE6D0;font-size:10\"><B>";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="</B></td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t\t<td class=\"TDSTYLE1\">\n\t\t\t\t\t<B>";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\n\t\t\t\t<tr>\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\t\t\t\t\t\n\t\t\t\t</td>\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\n\t\t\t\t</td>\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n\t\t\t\t\t<input type=\"hidden\" name=\"available_qty\" id=\"available_qty\" value =\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\">\n\t\t\t\t</td>\n\t\t\t\t";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\" style=\"font-size:10\">\t\t\t\t\t\n\t\t\t\t\t<input type=\"text\" name=\"alloc_qty";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\" class=\"number\" >\n\t\t\t\t</td>\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\">\n\t\t\t\t\t<input type=\"checkbox\" name=\"chkSelect";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\" value=\"E\" checked>\n\t\t\t\t</td>\t\n\t\t\t";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\" style=\"font-size:10\">\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\n\t\t\t\t</td>\n\t\t\t";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n\t</table>\n\t";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\t\n\t<input type=\"hidden\" name=\"alloc_qty_count\" id=\"alloc_qty_count\" value=\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\">\n\t<input type=\"hidden\" name=\"drug_item_count\" id=\"drug_item_count\" value=\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\">\n\t<input type=\"hidden\" name=\"rf_drug_flag\" id=\"rf_drug_flag\" value=\"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\">\n\t<input type=\"hidden\" name=\"rec_count\" id=\"rec_count\" value=\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\">\n\t<input type=\"hidden\" name=\"conv_factor\" id=\"conv_factor\" value=\"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\">\n\t<input type=\"hidden\" name=\"no_decimals_allowed\" id=\"no_decimals_allowed\" value=\"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\">\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block5Bytes, _wl_block5);

	  request.setCharacterEncoding("UTF-8");
	//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
	request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
	response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
	response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	//endss
		String locale			= (String)session.getAttribute("LOCALE");
		
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	String retval = request.getParameter("retval");

	String identity				= request.getParameter("identity")==null?"":request.getParameter("identity") ;
	String drug_code_main		= request.getParameter("drug_code");
	String drug_desc_main		= request.getParameter("drug_name");
	String rf_name				= request.getParameter("fluid_name");
	String rf_id				= request.getParameter("rf_id");	
	String rf_drug_flag			= request.getParameter("rf_drug_flag")==null?"":request.getParameter("rf_drug_flag");
	String uom			        = request.getParameter("uom");
	String passed_item_code		= request.getParameter("passed_item_code");
	String order_id			    = request.getParameter("order_id")==null?"":request.getParameter("order_id");//added for MMS-KH-CRF-0038
	String patient_id			    = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");//added for MMS-KH-CRF-0038
	//if(identity==null)identity="";	
	//if(rf_drug_flag==null)rf_drug_flag="";
	String order_line_no		= request.getParameter("order_line_no");	
	String tot_num_of_drugs		= request.getParameter("tot_num_of_drugs");
	String	bean_id				=	"DispMedicationBean" ;
	String	bean_name			=	"ePH.DispMedicationBean";
	DispMedicationBean bean		= (DispMedicationBean)getBeanObject( bean_id, bean_name, request);	
	bean.setLanguageId(locale);

	String bean_id_3				= "DispMedicationAllStages" ;
	String bean_name_3				= "ePH.DispMedicationAllStages";
	DispMedicationAllStages bean_3  = (DispMedicationAllStages)getBeanObject( bean_id_3, bean_name_3, request ) ;

	if(rf_drug_flag.equals("RF")){	// Reconst Fluid
		drug_code_main = rf_id;
		drug_desc_main = rf_name;
	}
	Hashtable ws_allocated_qty = new Hashtable();
	String act_patient_episode_type = "";
	String act_patient_class = ""; //added for MMS-KH-CRF-0038 - start
	String scan_count_required_yn = "";
	String alert_required_yn = "";
	String remarks_required_yn = "";
	act_patient_episode_type     =  bean_3.getEncounterPatientClass(bean.getEncounterID(), patient_id);//Added for MMS-DM-CRF-0170
			//System.err.println("act_patient_episode_type@@@==="+act_patient_episode_type);
			if(act_patient_episode_type.equals("I"))
                act_patient_class  ="IP";
			else if(act_patient_episode_type.equals("O"))
                act_patient_class  ="OP";
			else if(act_patient_episode_type.equals("E"))
                act_patient_class  ="EM";
			else if(act_patient_episode_type.equals("D"))
                act_patient_class  ="DC";
			else if(act_patient_episode_type.equals("R"))
                act_patient_class  ="XT";
				  ArrayList scanCountSetup    = bean.getScanCountReqForPatientClass(act_patient_class,"DISPENSE_MEDICATION");
				  if(scanCountSetup.size()>0){
					  scan_count_required_yn = (String)scanCountSetup.get(0);
					  alert_required_yn      = (String)scanCountSetup.get(1);
					  remarks_required_yn    = (String)scanCountSetup.get(2);
				}
//added for MMS-KH-CRF-0038 end

	//if((bean.getHTWSAllocateBatches()).size()==0){
		bean.setWSAllocateBatches(retval,drug_code_main,drug_desc_main,order_line_no,rf_drug_flag);		
		bean.setDrugDetails(drug_code_main,drug_desc_main);
	//}
	ws_allocated_qty = bean.getWSAllocatedQty();	
	Hashtable ht_ws_fluid_allocate_batches = bean.getHTWSFluidAllocateBatches();

	if(ht_ws_fluid_allocate_batches==null){
		ht_ws_fluid_allocate_batches = new Hashtable();
	}

	int iNoOfDecimals				= 0;

	boolean bDecimalAllowed			= bean_3.getDecimalAllowedYN(drug_code_main);

	if(bDecimalAllowed)
		iNoOfDecimals = bean_3.getINoOfDecimals();
	int iMaxLength					= 5+iNoOfDecimals;
	int recCount=1;

            _bw.write(_wl_block8Bytes, _wl_block8);


		if(bean.getBarcode_Scan_YN().equals("Y")){ 
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(alert_required_yn));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(bean.getDispStage()));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(order_line_no));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(drug_code_main));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(act_patient_class));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(remarks_required_yn));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(bean.getEncounterID()));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
}
		
            _bw.write(_wl_block12Bytes, _wl_block12);

		Hashtable ht_ws_allocate_batches = bean.getHTWSAllocateBatches();
		Hashtable ht_ordered_qty		 = bean.getOrderedQty();	
		int drugItemCount = 0;
		int batch_count = 0;
		int alloc_qty_count = 1;

       HashMap IssueUOMAndBaseUOM		=	new HashMap();
	   Double base_to_disp_uom_equl    =	0.0;
	   Double base_to_def_uom_equl	   =    0.0;
	   Double conv_factor              =    0.0;

       if(!identity.equals("preview")){
         IssueUOMAndBaseUOM		=	(HashMap)bean_3.getStoreDfltIssueUOMAndBaseUOM(bean.getDispLocnCode(),passed_item_code);
		 base_to_disp_uom_equl  =	bean_3.getEqulValue ( passed_item_code, (String)IssueUOMAndBaseUOM.get("BASE_UOM"), uom);
		 base_to_def_uom_equl   =   bean_3.getEqulValue ( passed_item_code, (String)IssueUOMAndBaseUOM.get("BASE_UOM"),(String)IssueUOMAndBaseUOM.get("DEF_ISSUE_UOM"));
		 conv_factor            =   (bean_3.lcm( base_to_disp_uom_equl,base_to_def_uom_equl))/base_to_disp_uom_equl;

	   }


		for(int ii=1;ii<=Integer.parseInt(tot_num_of_drugs);ii++){

			ArrayList arrList = new ArrayList();
			String item_code = "";
			String drug_code = "";
			String drug_name = "";
			String ordered_qty ="";
			String fluidoringredient = "Ingredient";
			if(ht_ws_allocate_batches.get(ii+"")!=null){		
			
				 arrList   = (ArrayList)ht_ws_allocate_batches.get(ii+"");
				 if(arrList.size()>0){

					 item_code = (String)arrList.get(0);
					 drug_code = (String)arrList.get(2);
					 drug_name = (String)arrList.get(3);
					 if(drug_code_main !=null && !drug_code_main.equals(drug_code))
						continue;
					 ++drugItemCount;

					 if((ii+"").equals("1")){
					   fluidoringredient = "Fluid";

					}
				 }
			}
    
    		ordered_qty = (String)ht_ordered_qty.get(ii+"");
			ArrayList alloc_qty =	(ArrayList)ws_allocated_qty.get(item_code+drug_code);


            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(drugItemCount));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(drugItemCount));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(ordered_qty));
            _bw.write(_wl_block16Bytes, _wl_block16);

			if(arrList.size()>0){
				if(identity.equals("preview")&& alloc_qty == null  ){
					continue;
				}
		
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(drug_name));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(drugItemCount));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(drugItemCount));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(drugItemCount));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(drugItemCount));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

				if(!identity.equals("preview")){
			
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

				}
			
            _bw.write(_wl_block29Bytes, _wl_block29);

				int rowCount = 1;
				String classvalue="";

				if((arrList.size() /15) >3)
				{
			
            _bw.write(_wl_block30Bytes, _wl_block30);

					return;
				}

				for (int i=0;i<arrList.size();i=i+15){


					if ( rowCount % 2 == 0 )
						classvalue = "QRYODD" ;
					else
						classvalue = "QRYEVEN" ;
							   
					String batch_id	        = (String)arrList.get(i+1);						
					//String drug_desc      = (String)arrList.get(i+3);
//					String item_desc        = (String)arrList.get(i+4);
//					String disp_locn        = (String)arrList.get(i+5);
//					String disp_store       = (String)arrList.get(i+6);
					String expiry_date      = (String)arrList.get(i+7);
					//String bin_locn_code  = (String)arrList.get(i+8);
					String bin_locn_desc    = (String)arrList.get(i+9);						
					String trade_id			= (String)arrList.get(i+10);
					String trade_name		= (String)arrList.get(i+11);
					String manufacturer_id  = arrList.get(i+12) == null?"":(String)arrList.get(i+12);
					String manufacturer_name= arrList.get(i+13) == null?"":(String)arrList.get(i+13);
					       manufacturer_name=  java.net.URLDecoder.decode(manufacturer_name,"UTF-8");
					String avail_qty        = (String)arrList.get(i+14);

					String barcode_id =bean.getBarcodeID((String)arrList.get(i+0),(String)arrList.get(i+5),batch_id,com.ehis.util.DateUtils.convertDate(expiry_date,"DMY","en",locale));

			

					String sOnBlurValidateion = ""; 
//					if(tot_num_of_drugs.equals("1"))
//					{
						sOnBlurValidateion="onBlur=\"if(validateNumbers(this,4,'"+iNoOfDecimals+"')){validateWSAllocatedQty('"+avail_qty+"',this,'"+ordered_qty+"','"+conv_factor+"','"+iNoOfDecimals+"');}\"";
//					}


					if(alloc_qty !=null && identity.equals("preview") && (alloc_qty.size()<=(rowCount-1))){				
						continue;
					}
			
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(expiry_date,"DMY","en",locale)));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(drugItemCount));
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(drugItemCount));
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(expiry_date));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(batch_id));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(drugItemCount));
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(drugItemCount));
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(batch_id));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(trade_name));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(drugItemCount));
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(drugItemCount));
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(trade_id));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(manufacturer_name));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(drugItemCount));
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(drugItemCount));
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(manufacturer_id));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(bin_locn_desc));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(drugItemCount));
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(drugItemCount));
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(avail_qty));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(drugItemCount));
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(drugItemCount));
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(avail_qty));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(drugItemCount));
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(drugItemCount));
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(barcode_id));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(drugItemCount));
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(drugItemCount));
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block52Bytes, _wl_block52);

					if(ws_allocated_qty.isEmpty()){
				
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(drugItemCount));
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(drugItemCount));
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(iNoOfDecimals));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(iMaxLength));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(sOnBlurValidateion));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(drugItemCount));
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(drugItemCount));
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block62Bytes, _wl_block62);

					}else{
						if(alloc_qty !=null && identity.equals("preview") && alloc_qty.size()>(rowCount-1)){					
				
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(alloc_qty.get(rowCount-1)));
            _bw.write(_wl_block65Bytes, _wl_block65);

						}else if(alloc_qty!=null && !identity.equals("preview")){
							String str_alloc_qty="";
							if(alloc_qty.size()>(rowCount-1)){
								str_alloc_qty=(String)alloc_qty.get(rowCount-1);
								try{ Double.parseDouble(str_alloc_qty);}
								catch(Exception e){str_alloc_qty = "";}

							}
				
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(drugItemCount));
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(drugItemCount));
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(str_alloc_qty));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(iNoOfDecimals));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(iMaxLength));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(sOnBlurValidateion));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(drugItemCount));
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(drugItemCount));
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block67Bytes, _wl_block67);

						}else{
				
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(drugItemCount));
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(drugItemCount));
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(iNoOfDecimals));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(iMaxLength));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(sOnBlurValidateion));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(drugItemCount));
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(drugItemCount));
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block69Bytes, _wl_block69);

						}
					}
				
            _bw.write(_wl_block70Bytes, _wl_block70);

					rowCount++;
					batch_count++;
				}					
			
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(alloc_qty_count));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(alloc_qty_count));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block73Bytes, _wl_block73);

				alloc_qty_count++;
			}
		
            _bw.write(_wl_block74Bytes, _wl_block74);

		}
		
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(batch_count));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(drugItemCount));
            _bw.write(_wl_block77Bytes, _wl_block77);


		if(ht_ws_fluid_allocate_batches.size()>0){
			for(int i=1;i<=Integer.parseInt(tot_num_of_drugs);i++){
				if(ht_ws_fluid_allocate_batches.containsKey(i+"")){
					ArrayList arr_list = (ArrayList)ht_ws_fluid_allocate_batches.get(i+"");
					String item_code = (String)arr_list.get(0);
					String drug_desc = (String)arr_list.get(3);		
	
            _bw.write(_wl_block78Bytes, _wl_block78);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(drug_desc));
            _bw.write(_wl_block79Bytes, _wl_block79);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block80Bytes, _wl_block80);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block81Bytes, _wl_block81);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

				if(!identity.equals("preview")){
			
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

				}
			
            _bw.write(_wl_block29Bytes, _wl_block29);
		
				String classvalue="";
				recCount = 1;				
				for (int j=0;j<arr_list.size();j=j+16){

					if ( recCount % 2 == 0 )
						classvalue = "QRYODD" ;
					else
						classvalue = "QRYEVEN" ;

		   				   item_code		= (String)arr_list.get(j);
					String batch_id			= (String)arr_list.get(j+1);						
						   drug_desc		= (String)arr_list.get(j+3);
//					String item_desc		= (String)arr_list.get(j+4);
//					String disp_locn		= (String)arr_list.get(j+5);
//					String disp_store		= (String)arr_list.get(j+6);
					String expiry_date      = (String)arr_list.get(j+7);
//					String bin_locn_code    = (String)arr_list.get(j+8);					
					String bin_locn_desc    = (String)arr_list.get(j+9);						
//					String trade_id			= (String)arr_list.get(j+10);					
					String trade_name		= (String)arr_list.get(j+11);
//					String manufacturer_id  = (String)arr_list.get(j+12);					
					//String manufacturer_name= (String)arr_list.get(j+13);
					String manufacturer_name=  java.net.URLDecoder.decode(((String)arr_list.get(j+13)),"UTF-8");
					String avail_qty		= (String)arr_list.get(j+14);
					String alloc_qty		= (String)arr_list.get(j+15);
					if(rf_drug_flag.equals("RF")&&alloc_qty.equals(""))
						alloc_qty =request.getParameter("order_qty");
			
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(expiry_date,"DMY","en",locale)));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(batch_id));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(trade_name));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(manufacturer_name));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(bin_locn_desc));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(avail_qty));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(avail_qty));
            _bw.write(_wl_block86Bytes, _wl_block86);

					if(!identity.equals("preview")){
				
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(alloc_qty));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(iNoOfDecimals));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(iMaxLength));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block91Bytes, _wl_block91);

					}else{
			
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(alloc_qty));
            _bw.write(_wl_block93Bytes, _wl_block93);

					}
				recCount++;
				}
			
            _bw.write(_wl_block94Bytes, _wl_block94);
			}
			}
		}
	
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(alloc_qty_count));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(drugItemCount));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(rf_drug_flag));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(conv_factor));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(iNoOfDecimals));
            _bw.write(_wl_block101Bytes, _wl_block101);

putObjectInBean(bean_id,bean,request);

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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.BatchDetailsfor.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ItemCode.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.expiryDate.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BatchID.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.TradeName.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Manufacturer.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BinLocation.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.AvailableQty.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AllocatedQuantity.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.BatchDetailsfor.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Ingredient.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ItemCode.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.expiryDate.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BatchID.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.TradeName.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Manufacturer.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BinLocation.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag18(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag18 = null ;
        int __result__tag18 = 0 ;

        if (__tag18 == null ){
            __tag18 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag18);
        }
        __tag18.setPageContext(pageContext);
        __tag18.setParent(null);
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.AvailableQty.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag18;
        __result__tag18 = __tag18.doStartTag();

        if (__result__tag18!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag18== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag18.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag18);
            return true;
        }
        _activeTag=__tag18.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag18);
        __tag18.release();
        return false;
    }

    private boolean _jsp__tag19(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag19 = null ;
        int __result__tag19 = 0 ;

        if (__tag19 == null ){
            __tag19 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag19);
        }
        __tag19.setPageContext(pageContext);
        __tag19.setParent(null);
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AllocatedQuantity.label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag19;
        __result__tag19 = __tag19.doStartTag();

        if (__result__tag19!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag19== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag19.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag19);
            return true;
        }
        _activeTag=__tag19.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag19);
        __tag19.release();
        return false;
    }

    private boolean _jsp__tag20(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag20 = null ;
        int __result__tag20 = 0 ;

        if (__tag20 == null ){
            __tag20 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag20);
        }
        __tag20.setPageContext(pageContext);
        __tag20.setParent(null);
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag20.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag20;
        __result__tag20 = __tag20.doStartTag();

        if (__result__tag20!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag20== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag20.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag20);
            return true;
        }
        _activeTag=__tag20.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag20);
        __tag20.release();
        return false;
    }
}
