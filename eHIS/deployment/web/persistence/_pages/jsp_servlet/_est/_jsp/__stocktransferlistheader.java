package jsp_servlet._est._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eST.StockTransferBean;
import eST.Common.StHeaderBean;
import java.util.ArrayList;
import java.util.HashMap;
import webbeans.eCommon.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __stocktransferlistheader extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/est/jsp/StockTransferListHeader.jsp", 1742889324327L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 =" \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n\n\t<head>\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' ></link>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n\t<script language=\"javascript\" src=\"../../eST/js/StCommon.js\"></script>\n\t<script language=\"javascript\" src=\"../../eST/js/StTransaction.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eST/js/StockTransfer.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/CommonResult.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t</head>\n\t<body onLoad=\"FocusFirstElement();totalqty();\">\n\t<form name=\'formStockTransferListHeader\' id=\'formStockTransferListHeader\'>\n\t\t<table border=\'0\' cellpadding=\'2\' cellspacing=\'0\' width=\'100%\' >\n\t\t<tr>\n\t\t\t<td colspan = \'6\' class =\"label\">&nbsp;</td>\n\t\t</tr>\n\t\t ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t<tr>\n\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t\t<td colspan=6 align=left class=\'label\' colspan=2>&nbsp;<input type=\'text\' name=\'barcode\' id=\'barcode\'  size=80 maxLength=100 value=\"\" onkeypress=\"getGTINDetails(event,this);\"  ></td>\t\t\t\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t<tr>\n\t\t\t<td class=label align=left>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td> \n\t\t\t<input type=\"hidden\" name=\"item_desc_temp\" id=\"item_desc_temp\" value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" >\n\t\t\t<td colspan=5 align=left class=\'label\'>&nbsp;<input type=text name=item_desc id=item_desc size=70 maxlength=60  onkeypress=\"callBarCodeBatchSearch(event,item_desc,trn_type1,parent.parent.frameStockTransferHeader.document.formStockTransferHeader.from_store_code,parent.parent.frameStockTransferHeader.document.formStockTransferHeader.to_store_code,this.form,\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\',\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\',\'StockTransferListHeader\',\'StockTransferListDetail\',\'StockTransferDetail\');\" value=\"\" ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="   > <input type=button name=\"item_search\" id=\"item_search\" class=\"button\" onClick=\"callBarCodeBatchSearch(event,item_desc,trn_type1,parent.parent.frameStockTransferHeader.document.formStockTransferHeader.from_store_code,parent.parent.frameStockTransferHeader.document.formStockTransferHeader.to_store_code,this.form,\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\',\'StockTransferListHeader\',\'StockTransferListDetail\',\'StockTransferDetail\');getstorecode();\"  value=\'?\' ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =" >";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="<input type=\"hidden\" name=\"item_code\" id=\"item_code\" value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">&nbsp;<b><span id=\"id_uom\">";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</span></b>\n\t\t\t\n\t\t\t<!-- //Added by Rabbani#AMS-CRF-0068(49822) on 11-AUG-2014 -->\n\t\t\t&nbsp;&nbsp;\n\t\t\t<label id=\"id_min_stk_label\" style=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" >Min.Level:</label>\n\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t<label id=\"id_min_str_stk\" style=\"background-color:red;color:yellow; ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\"  ><b>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</b></label>\n\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t<label id=\"id_min_str_stk\" style=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" ><b>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t&nbsp;&nbsp;\n\t\t\t<label id=\"id_stk_rol_label\" style=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" >ROL:</label>\n\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t<label  id=\"id_stk_rol\" style=\"background-color:red;color:yellow;";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t<label  id=\"id_stk_rol\"  style=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\"><b>";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t \n\t\t\t<!-- ends -->\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>  \n\t\t\t<td class=label align=left>";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</td>\n\t\t\t<td align=left class=\"label\">&nbsp;<input type=text  name=item_qty id=item_qty size=12 maxlength=12 class=\"NUMBER\" onkeypress =\"allow_restrict_decimals(this,event);\" onblur=\"if(checkDoubleFormat(this,true)){checkminmaxstatus();totalqty();return CheckQuantity();}\" value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\"  ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</td>\n\t\t\t<td width=\'75%\'>\n\t\t\t<table border=0 cellspacing=0 cellpadding=0 width=\'100%\'>\n\t\t\t<tr>\n\t\t\t<td class=\'label\' align=\'right\'>";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =":</td>\n\t\t\t<td class=\'label\' width=\'20%\'>&nbsp;<b><span id=\"id_stock_available\">";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</span></b></td>\n\t\t\t<td class=\'label\' align=\'right\'>\n\t\t\t<td class=\'label\' align=\'right\'><label id=\"id_item_unit_cost_label\" style=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\">";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 =":</label></td>\n\t\t\t<td width=\'25%\' class=\'label\' width=\'20%\'>&nbsp;<b><label id=\"id_item_unit_cost\" style=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</label></b><input name=\"item_unit_cost\" id=\"item_unit_cost\" value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" type=\"hidden\"></td>\n\t\t\t<td align=left width=\'25%\'  class=\'label\'><label id=\"id_item_sal_value_label\" style=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 =":&nbsp;</label><b><label id=\"id_item_sal_value\" width=\'20%\'style=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</label></b></td>\n\t\t\t</tr>\n\t\t\t</table>\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td class=\'label\' align=right >";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</td>\n\t\t\t<td align=left class=\"label\" colspan=4>&nbsp;<input type=\"text\" name=\"ret_qty\" id=\"ret_qty\" value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\" size=10 maxlength=10 class=\"NUMBER\" disabled></td>\n\t\t</tr>\n\t\t</table>\t\n\t\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"2\" width=\"100%\"> \n\t\t\t<tr>\n\t\t\t<td colspan = \'8\' class =\"label\">&nbsp;</td>\n\t\t\t</tr>\n<!--\t\t\t <tr> \n\t\t\t\t<td align = right class =\"label\" nowrap Width=\"12%\"> <B>&nbsp; ";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="  </B></td>\n\t\t\t\t<td align = right class =\"label\" nowrap Width=\"12%\" > ";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="</td>\n\t\t\t\t<td align = right class =\"label\" nowrap Width=\"12%\" > ";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</td>\n\t\t\t\t<td align = right class =\"label\" nowrap Width=\"13%\"> &nbsp;";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</td>\n\t\t\t\t<td align = right class =\"label\" nowrap Width=\"12%\"> &nbsp;";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="</td>\n\t\t\t\t<td align = right class =\"label\" nowrap Width=\"14%\"> &nbsp;";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="</td>\n\t\t\t\t<td align = right class =\"label\" nowrap Width=\"40%\">&nbsp;</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t<td align = right class =\"label\" nowrap> ";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</td>\n\t\t\t<td align = right class =\"label\" nowrap> &nbsp;&nbsp;<label class=\"label\" id=\"lb_frm_store_qty_on_hand\">   </label>";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="</td>\n\t\t\t<td align = right class =\"label\" nowrap> <label class=\"label\" id=\"lb_frm_store_uom_desc\"> </label>";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="</td>\n\t\t\t<td align = right class =\"label\" nowrap> &nbsp;&nbsp;<label class=\"label\" id=\"lb_frm_store_min_stk_level\"> </label>";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="</td>\n\t\t\t<td align = right class =\"label\" nowrap> &nbsp;&nbsp;<label class=\"label\" id=\"lb_frm_store_max_stk_level\"> </label>";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="</td>\n\t\t\t<td align = right class =\"label\" nowrap> &nbsp;&nbsp;<label class=\"label\" id=\"lb_frm_store_reorder_level\"> </label>";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="</td>\n\t\t\t<td align = right class =\"label\" nowrap>&nbsp;</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td align = right class =\"label\" nowrap>";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="</td>\n\t\t\t<td align = right class =\"label\" nowrap> &nbsp;&nbsp;<label class=\"label\" id=\"lb_to_store_qty_on_hand\">\t</label>";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="</td>\n\t\t\t<td align = right class =\"label\" nowrap> <label class=\"label\" id=\"lb_to_store_uom_desc\"> </label>";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="</td>\n\t\t\t<td align = right class =\"label\" nowrap> &nbsp;&nbsp;<label class=\"label\" id=\"lb_to_store_min_stk_level\"> </label>";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="</td>\n\t\t\t<td align = right class =\"label\" nowrap> &nbsp;&nbsp;<label class=\"label\" id=\"lb_to_store_max_stk_level\"> </label>";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="</td>\n\t\t\t<td align = right class =\"label\" nowrap> &nbsp;&nbsp;<label class=\"label\" id=\"lb_to_store_reorder_level\"> </label>";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="</td>\n\t\t\t<td align = right class =\"label\" nowrap>&nbsp;</td>\n\t\t</tr>\n-->\t\t<tr>\n\t\t\t<td class=label align=left colspan=\'7\'>\n\t\t\t\t<input type=button name=\"edit\" id=\"edit\" value=\'";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\' class=button onclick=\"editViewBatch();\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="><input type=button name=batchsearch id=batchsearch value=\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\' class=button onclick=\"callBatchSearch();\"  ";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="><input type=button name=\"apply\" id=\"apply\" value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\" class=button onclick=\"totalqty();addToListforBarCode(\'";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\',parent.parent.frameStockTransferHeader.document.formStockTransferHeader.barcode_applicable1,\'StockTransferListHeader\',\'StockTransferListDetail\',\'StockTransferDetail\');\"><input type=button name=Cancel id=Cancel value=\'";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\' class=button onclick=\"cancel_me();\">\n\t\t\t<input class=\"button\" type=\"button\" name=\"ItemDetails\" id=\"ItemDetails\" value=\'";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\' onClick=\"ItemDetail();\" ";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="></td>\n\n\t\t\t\n\n\n\t\t</tr>\n\t\t</table>\n\t\t<input type=\"hidden\" name=\"stock_item_yn\" id=\"stock_item_yn\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\">\n\t\t<input type=\"hidden\" name=\"store_code\" id=\"store_code\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\">\n\t\t<input type=\"hidden\" name=\"expiry_yn\" id=\"expiry_yn\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\">\n\t\t<input type=\"hidden\" name=\"doc_srl_no\" id=\"doc_srl_no\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\">\n\t\t<input type=\"hidden\" name=\"uom_code\" id=\"uom_code\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\">\n\t\t<input type=\"hidden\" name=\"index\" id=\"index\"\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\">\n\t\t<input type=\"hidden\" name=\"frm_store_qty_on_hand\" id=\"frm_store_qty_on_hand\"\tvalue=\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\">\n\t\t<input type=\"hidden\" name=\"frm_store_min_stk_level\" id=\"frm_store_min_stk_level\" value=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\">\n\t\t<input type=\"hidden\" name=\"frm_store_max_stk_level\" id=\"frm_store_max_stk_level\" value=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\">\n\t\t<input type=\"hidden\" name=\"frm_store_reorder_level\" id=\"frm_store_reorder_level\" value=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\">\n\t\t<input type=\"hidden\" name=\"frm_store_uom_desc\" id=\"frm_store_uom_desc\"\t\tvalue=\"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\">\n\t\t<input type=\"hidden\" name=\"to_store_qty_on_hand\" id=\"to_store_qty_on_hand\"\tvalue=\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\">\n\t\t<input type=\"hidden\" name=\"to_store_min_stk_level\" id=\"to_store_min_stk_level\"\tvalue=\"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\">\n\t\t<input type=\"hidden\" name=\"to_store_max_stk_level\" id=\"to_store_max_stk_level\"\tvalue=\"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\">\n\t\t<input type=\"hidden\" name=\"to_store_reorder_level\" id=\"to_store_reorder_level\"\tvalue=\"";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\">\n\t\t<input type=\"hidden\" name=\"to_store_uom_desc\" id=\"to_store_uom_desc\"\t\tvalue=\"";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\">\n\t\t<input type=\"hidden\" name=\"tmp_conv\" id=\"tmp_conv\"\t\t\t\tvalue=\"\">\n\t\t<input type=\"hidden\" name=\"kit\" id=\"kit\"\t\t\t\t\t\tvalue=\"\">\n\t\t<input type=\"hidden\" name=\"frm_tmp_conv\" id=\"frm_tmp_conv\"\t\t\tvalue=\"\">\n\t\t<input type=\"hidden\" name=\"phy_inv_id\" id=\"phy_inv_id\"\t\t\t\tvalue=\"\">\n\t\t<input type=\"hidden\" name=\"allow_deci_yn\" id=\"allow_deci_yn\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\">\n\t\t<input type=\"hidden\" name=\"no_deci\" id=\"no_deci\"\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\">\n\t\t<input type=\"hidden\" name=\"kit_item_yn\" id=\"kit_item_yn\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\">\n\t\t<input type=\"hidden\" name=\"from_multiples\" id=\"from_multiples\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\">\n\t\t<input type=\"hidden\" name=\"to_multiples\" id=\"to_multiples\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\">\n\t\t<input type=\"hidden\" name=\"batch_multiples\" id=\"batch_multiples\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\">\n\t\t<input type=\"hidden\" name=\"no_of_decimals_for_cost\" id=\"no_of_decimals_for_cost\" value=\'";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\'>\n\n\n\t\t<input type=\"hidden\"    name=\"trn_type1\" id=\"trn_type1\"\t\t\t\t\t\t\t    value=\'";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\' >\n\t\t<input type=\"hidden\"    name=\"BARCODE_YN\" id=\"BARCODE_YN\"\t\t\t\t\t\t\t    value=\'";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\' >\n\t\t<input type=\"hidden\"    name=\"barcode_applicable\" id=\"barcode_applicable\"\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\" >\n\t\t<input type=\"hidden\"    name=\"bar_or_item_code\" id=\"bar_or_item_code\"\t\t\t\t\t\tvalue=\"\" >\n\t\t<input type=\"hidden\"    name=\"mode\" id=\"mode\"\t\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\" >\n\t\t<input type=\"hidden\"    name=\"billable_item_yn\" id=\"billable_item_yn\"\t\t\t\tvalue=\"\" ><!--dummy-->\n\t\t<input type=\"hidden\"    name=\"sale_req_qty\" id=\"sale_req_qty\"\t\t\t\tvalue=\"\" ><!--dummy-->\n         <input type=\"hidden\"  name=\"kit_temp_code\" id=\"kit_temp_code\"\t        value=\"";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\" >\n\t\t <input type=\"hidden\" name=\"usage_type\" id=\"usage_type\"\t\t\t\tvalue= \'";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\'>\n\t\t <input type=\"hidden\"  name=\"noofbatchesforbarcode\" id=\"noofbatchesforbarcode\"\tvalue=\"1\" >\n\t\t<input type=\"hidden\" name=\"item_2d_barcode_yn\" id=\"item_2d_barcode_yn\"\tvalue=\'";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\'><!-- added for MOHE-CRF-0167 -->\n\n\t</form>\n";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\n\n\t</body>\n</html>\n\n<script>\nSetitemdesc(document.formStockTransferListHeader.item_desc_temp);\n</script>\n\n";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);
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
	String locale			= (String)session.getAttribute("LOCALE");
	
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);


	String bean_id				=    "stockTransferBean";
	String bean_name			=    "eST.StockTransferBean";


	StockTransferBean bean = (StockTransferBean) getBeanObject( "stockTransferBean","eST.StockTransferBean", request  );
	bean.setLanguageId(locale);
	StHeaderBean beanHdr = (StHeaderBean)getBeanObject( "stHeaderBean", "eST.Common.StHeaderBean",request );
	beanHdr.setLanguageId(locale);


	
	String stButtonLegend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels");
	String index=bean.checkForNull(request.getParameter("index"),"-1");
	String doc_srl_no=bean.checkForNull(request.getParameter("doc_srl_no"),"-1");

	String item_code		=	"";
	String item_desc		=	"";
	String uom				=	"";
	String uom_code			=	"";
	String stock_available	=	"";
	String item_unit_cost	=	"";
	String item_qty			=	"";
	String item_sal_value	=	"";
	//String remarks			=	"";
	String expiry_yn		=	"";
	String codeDisabled		=	"";
	String stock_item_yn	=	"";
	String store_code		=   "";
	String frm_store_qty_on_hand		= "";
	String frm_store_min_stk_level		= "";
	String frm_store_max_stk_level		= "";
	String frm_store_reorder_level		= "";
	String frm_store_uom_desc			= "";
	String to_store_qty_on_hand			= "";
	String to_store_min_stk_level		= "";
	String to_store_max_stk_level		= "";
	String to_store_reorder_level		= "";
	String to_store_uom_desc			= "";
	String display_flag					= "visibility:hidden";
	String disable_add					= "disabled";
	String allow_deci_yn				= "N";
	String no_deci						= "";
	String kit_item_yn					= "";
	String from_multiples				= "1";
	String to_multiples					= "1";
	String batch_multiples				= "1";
	String trn_type   = null;
	String ret_qty						= request.getParameter("ret_qty")==null?"":request.getParameter("ret_qty");
	System.out.println("ret_qty==71=>" +ret_qty);


	String  trn_type1  = "TFR";
	String	BARCODE_YN = request.getParameter("BARCODE_YN")==null?"FALSE":request.getParameter("BARCODE_YN");
	String  barcode_applicable = "";
	String mode = bean.getMode();

	String editqty_appl     =	bean.checkForNull(bean.getBarcodeEditQtyAppl(),"N");
	String Qty_disabled = "";
	String kit_temp_code            =        "";//01/08/12
	String usage_type                =        "";
	
	//Added by Rabbani#AMS-CRF-0068(49822) on 12-AUG-2014
	String min_stk_flag					=		"visibility:hidden";
	String rol_flag					    =		"visibility:hidden";
	boolean min_stk                     =       false;
	boolean rol_stk                     =       false;
	//ends
	
	if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT")) && BARCODE_YN.equals("TRUE") && editqty_appl.equals("N")){
		Qty_disabled  = "disabled"	;
	}
	


	if(!index.equals("-1")){
		
		HashMap hmRecord = new HashMap();

		//hmRecord=bean.getDtlRecord(Integer.parseInt(index));

		if (BARCODE_YN.equals("TRUE")){
		hmRecord		=		(HashMap)bean.getDtlRecordforBarCode(Integer.parseInt(index));
		barcode_applicable = "Y";
		}
		else{
		hmRecord		=	    bean.getDtlRecord(Integer.parseInt(index));
		barcode_applicable = "N";
		}

		


		stButtonLegend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modify.label","common_labels");
		doc_srl_no		=	(String)hmRecord.get("doc_srl_no");
		item_code		=	(String)hmRecord.get("item_code");
		item_desc		=	(String)hmRecord.get("item_desc");
		uom				=	(String)hmRecord.get("uom_desc");
		uom_code		=	(String)hmRecord.get("uom_code");
		stock_available	=	(String)hmRecord.get("stock_available");
		//stock_available	=	(String)hmRecord.get("frm_str_avl_qty");
		item_unit_cost	=	(String)hmRecord.get("item_unit_cost");
		item_qty		=	(String)hmRecord.get("item_qty");
		item_sal_value	=	(String)hmRecord.get("item_cost_value");
		kit_item_yn						=		bean.checkForNull((String)hmRecord.get("kit_item_yn"),"N");
		//remarks			=	(String)hmRecord.get("remarks");
		expiry_yn		=	(String)hmRecord.get("expiry_yn");
		codeDisabled	=	"disabled";
		disable_add		=	"";
		stock_item_yn	=	(String)hmRecord.get("stock_item_yn");
		store_code		=	(String)hmRecord.get("store_code");
		from_multiples	=	bean.checkForNull((String)hmRecord.get("from_multiples"),"1");
		to_multiples	=	bean.checkForNull((String)hmRecord.get("to_multiples"),"1");
		batch_multiples	=	bean.checkForNull((String)hmRecord.get("batch_multiples"),"1");
		frm_store_uom_desc		=	bean.getShortDesc(item_code,store_code);
		to_store_uom_desc		=	bean.getShortDesc(item_code,(String)request.getParameter("to_store_code"));
		kit_temp_code	=	bean.checkForNull((String)hmRecord.get("kit_temp_code"),""); //02/08/12
		usage_type	=	bean.checkForNull((String)hmRecord.get("usage_type"),"");
		
		
		if(hmRecord.containsKey("allow_deci_yn"))
		allow_deci_yn           =   bean.checkForNull((String)hmRecord.get("allow_deci_yn"));
		else
		allow_deci_yn           =   bean.checkForNull((String)hmRecord.get("decimal_allowedYN"));

		if(hmRecord.containsKey("allow_deci_yn"))
		no_deci                 =   bean.checkForNull((String)hmRecord.get("no_deci"));
		else
		no_deci                 =   bean.checkForNull((String)hmRecord.get("no_of_decimals"));

    	 if(allow_deci_yn.equals("N"))
          no_deci ="0";


		System.out.println("hmRecord-decimal_allowedYN--124-->"+hmRecord);
		System.out.println("allow_deci_yn---124-->"+allow_deci_yn);
		System.out.println("no_deci---124-->"+no_deci);

		//HashMap hmMinMaxRecord=bean.getMinMaxRecord(Integer.parseInt(index));
		HashMap hmMinMaxRecord = new HashMap();

		if (BARCODE_YN.equals("TRUE")){
		hmMinMaxRecord=bean.getMinMaxRecordforBarcode(Integer.parseInt(index));
		}else{
		hmMinMaxRecord=bean.getMinMaxRecord(Integer.parseInt(index));
		}

		stock_available  = bean.setNumber(stock_available,Integer.parseInt(no_deci));
        item_qty = bean.setNumber(item_qty,Integer.parseInt(no_deci));  
		//frm_store_qty_on_hand		=	(String)hmRecord.get("stock_available"); // Availabe Qty has to be taken based on document no without commited qty , hmMinMaxRecord.get("frm_store_qty_on_hand") will not give doc no based available qty
		//frm_store_qty_on_hand		=	(String)hmRecord.get("frm_str_avl_qty"); // Availabe Qty has to be taken based on document no without commited qty , hmMinMaxRecord.get("frm_store_qty_on_hand") will not give doc no based available qty
		
		frm_store_qty_on_hand		=	(String)hmMinMaxRecord.get("frm_store_qty_on_hand");
		frm_store_min_stk_level		=	bean.checkForNull((String)hmMinMaxRecord.get("frm_store_min_stk_level"),"0");
		frm_store_max_stk_level		=	(String)hmMinMaxRecord.get("frm_store_max_stk_level");
		frm_store_reorder_level		=	bean.checkForNull((String)hmMinMaxRecord.get("frm_store_reorder_level"),"0");
		to_store_qty_on_hand		=	(String)hmMinMaxRecord.get("to_store_qty_on_hand");
		to_store_min_stk_level		=	(String)hmMinMaxRecord.get("to_store_min_stk_level");
		to_store_max_stk_level		=	(String)hmMinMaxRecord.get("to_store_max_stk_level");
		to_store_reorder_level		=	(String)hmMinMaxRecord.get("to_store_reorder_level");
		
	 	//Added By Rabbani #inc no:28266 on 16/09/11 
	      //Starts Here
	    ArrayList  alist =  bean.getTrnTypeArrayList();
	    for(int k=0; k<alist.size(); k++){
	    HashMap  blist = (HashMap)alist.get(k);
	    for(int l=0; l<blist.size();l++){
	    trn_type = (String)blist.get("TRNTYPE");
	     if(trn_type.equals("TFR")){
	     if(((String)bean.getCostYN(store_code)).equals("Y")){ 
	  	   display_flag	="visibility:visible"; 
		   
			}		 
		   }
	     }
	   }  
	       if(trn_type == null){
	       if(((String)bean.getAccessCostDetails()).equals("Y")){
            display_flag	=		"visibility:visible"; 
            }
           }
		   
		   //Added by Rabbani#AMS-CRF-0068(49822) on 11-AUG-2014
	       if(bean.getMin_Rol_yn(bean.getLoginById(),store_code)){
	  		 if(!frm_store_min_stk_level.equals("0")){
	  		if ( (Double.parseDouble(stock_available) - Double.parseDouble(item_qty))  <  Double.parseDouble(frm_store_min_stk_level)){
	  	    	   min_stk = true;
				 }
				 min_stk_flag = "visibility:visible";
	  		 }
	  		 if(!frm_store_reorder_level.equals("0")){
	  	     if ( (Double.parseDouble(stock_available) - Double.parseDouble(item_qty))  <  Double.parseDouble(frm_store_reorder_level)){
	  	    	   rol_stk = true;
	  	       }
	  	     rol_flag	   = "visibility:visible";
	  		 }
	  	 } //ends
	 
	}

	/**
 * @Name - Priya
 * @Date - 26/05/2010
 * @Inc# - 
 * @Desc -  To get no of decimals for cost and assign it to 'no_of_decimals_for_cost' hidden field 
 */
	String noOfDecimalsForCost=bean.getNoOfDecimalsCost();
	//Added by sakti against ML-BRU-SCF-0963[INC#42099]	
			item_desc = item_desc.replaceAll(" ","%20");
			item_desc = java.net.URLEncoder.encode(item_desc,"UTF-8");
			item_desc = item_desc.replaceAll("%2520","%20");
		//Added ends

		String item_2d_barcode_yn =bean.barcode2DApplicable();//Added for MOHE-CRF-0167
	
            _bw.write(_wl_block9Bytes, _wl_block9);
 if(item_2d_barcode_yn.equals("Y")){//Added for MOHE-CRF-0167 starts
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
} //Added for MOHE-CRF-0167 ends
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(item_desc));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(codeDisabled));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(codeDisabled));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(bean.getImage("M")));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(uom));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(min_stk_flag));
            _bw.write(_wl_block23Bytes, _wl_block23);
if(min_stk){ 
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(min_stk_flag));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(frm_store_min_stk_level));
            _bw.write(_wl_block26Bytes, _wl_block26);
}else{ 
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(min_stk_flag));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(frm_store_min_stk_level));
            _bw.write(_wl_block26Bytes, _wl_block26);
} 
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(rol_flag));
            _bw.write(_wl_block30Bytes, _wl_block30);
if(rol_stk) {
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(rol_flag));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(frm_store_reorder_level));
            _bw.write(_wl_block26Bytes, _wl_block26);
}else{
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(rol_flag));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(frm_store_reorder_level));
            _bw.write(_wl_block26Bytes, _wl_block26);
} 
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(bean.checkForNull(item_qty)));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(Qty_disabled));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(bean.getImage("M")));
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(stock_available));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(display_flag));
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(display_flag));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(item_unit_cost));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(item_unit_cost));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(display_flag));
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(display_flag));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(bean.setNumber(item_sal_value,Integer.parseInt(noOfDecimalsForCost))));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(ret_qty));
            _bw.write(_wl_block47Bytes, _wl_block47);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block48Bytes, _wl_block48);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block50Bytes, _wl_block50);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block51Bytes, _wl_block51);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(frm_store_qty_on_hand));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(frm_store_uom_desc));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(frm_store_min_stk_level));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(frm_store_max_stk_level));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(frm_store_reorder_level));
            _bw.write(_wl_block59Bytes, _wl_block59);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(to_store_qty_on_hand));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(to_store_uom_desc));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(to_store_min_stk_level));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(to_store_max_stk_level));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(to_store_reorder_level));
            _bw.write(_wl_block65Bytes, _wl_block65);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(codeDisabled));
            _bw.write(_wl_block67Bytes, _wl_block67);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf( BARCODE_YN.equals("TRUE") && mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))?codeDisabled:""));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(stButtonLegend));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block71Bytes, _wl_block71);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(disable_add));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(stock_item_yn));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(store_code));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(expiry_yn));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(doc_srl_no));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(uom_code));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(index));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(frm_store_qty_on_hand));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(frm_store_min_stk_level));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(frm_store_max_stk_level));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(frm_store_reorder_level));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(frm_store_uom_desc));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(to_store_qty_on_hand));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(to_store_min_stk_level));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(to_store_max_stk_level));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(to_store_reorder_level));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(to_store_uom_desc));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(allow_deci_yn));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(no_deci));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(kit_item_yn));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(from_multiples));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(to_multiples));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(batch_multiples));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(noOfDecimalsForCost));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(trn_type1));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(BARCODE_YN));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(barcode_applicable));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(kit_temp_code));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(usage_type));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(item_2d_barcode_yn));
            _bw.write(_wl_block104Bytes, _wl_block104);

putObjectInBean("stockTransferBean",bean,request);
putObjectInBean("stHeaderBean",beanHdr,request);


            _bw.write(_wl_block105Bytes, _wl_block105);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.BarcodeId.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.item.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Quantity.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.AvailableQty.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Cost.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Value.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.TransferQty.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.StockLevel.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Quantity.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.uom.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Minimum.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.maximum.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.ReOrder.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.FromStore.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ToStore.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.Edit/View.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.BatchSearch.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.cancel.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.StockLevel.label", java.lang.String .class,"key"));
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
}
