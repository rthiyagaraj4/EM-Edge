package jsp_servlet._est._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eMM.ItemMasterBean;
import eST.GoodsReceivedNoteBean;
import eST.Common.StHeaderBean;
import webbeans.eCommon.*;
import java.sql.*;
import java.util.HashMap;
import eMM.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __goodsreceivednotelistheader extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/est/jsp/GoodsReceivedNoteListHeader.jsp", 1742811594635L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<html>\n\t<head>\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' ></link>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n \t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n\t<script language=\"javascript\" src=\"../../eST/js/StCommon.js\"></script>\n\t<script language=\"javascript\" src=\"../../eST/js/StTransaction.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/CommonResult.js\"></script> <!-- added for MO-CRF-20165 -->\n\t<script language=\"JavaScript\" src=\"../../eST/js/GoodsReceivedNote.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t</head>\n\t<body onload() onLoad=\"batchdisable();\">\n\t<form name=\"formGoodsReceivedNoteListHeader\" id=\"formGoodsReceivedNoteListHeader\">\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t<table border=\'0\' cellpadding=\'2\' cellspacing=\'0\' width=\'100%\' height=\'100%\'>\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t<tr>\n\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t\t\t<td  align=\'left\' class=\'fields\' colspan=\'2\'><input type=\'text\' name=\'barcode\' id=\'barcode\'  size=\"50\" maxLength=\"100\" value=\"\" onkeypress=\"getGTINDetails(event,barcode);\"  ></td>\t\t\t\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t<tr>\n\t\t\t<td class=\'label\' >";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t\t\t<td colspan=\'5\' class=\'fields\'> <input type=\'text\' name=\'item_desc\' id=\'item_desc\' size=\'50\' maxlength=60 value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="><input type=\'button\' name=\"item_search\" id=\"item_search\" class=\"button\" onClick=\"callItemSearchScreen();batchdisable();\"  value=\'?\' ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =">";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="<input type=\"hidden\" name=\"item_code\" id=\"item_code\" value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n\t\t\t<b><span id=\"id_uom\" class=\'label\'>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</span></b></td>\n\t\t\t<!--Added By Rabbani #inc no:27056 on 13/10/11-->\n\t\t\t<!-- added for MO-CRF-20165 START-->\n\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t<td class=\'label\' >";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td> \n\t\t\t<td class=\'fields\'><select name=\"manufacturer_id\" id=\"manufacturer_id\"  ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =" ><option value=\"\">-----";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="-----</option>\t\n\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t\t\n\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =" >";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</option>\n\t\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t</select> </td>\n\t\t\t<td> <textarea name=\"manufac_remarks\"  rows=\"2\" cols=\"25\"  onKeyPress=\"checkMaxLimit(this,250);\" onblur=\"checkManuRemarksLength(this);\" ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</textarea> </td>  <!-- MO-CRF-20178 -->\n\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =" <!-- ADDED FOR MO-CRF-20165 END --> \n\t\t\t<td><input type=\'button\' name=\'batchsearch\' id=\'batchsearch\' value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' class=\'button\'     onclick= \"callBatchSearchScreen();\"></td>\n\t\t</tr>\n\t\t<tr>\n\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="<!-- MO-CRF-20165 -->\n\t\t\t<td class=\'label\' colspan=\"3\">";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</td>\n\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t<!-- \t\t\n\t\t\t* @Name - Priya\n\t\t\t* @Date - 10/02/2010\n\t\t\t* @Inc# - 19092 \n\t\t\t* @Desc - No.of Decimals is passed to isValidNumber function and in onblur  checkdoubleformat is called.\t\t\t\n\t\t-->\n\t\t\t<td  class=\'fields\'><input type=\'text\' name=\'item_qty_normal\' id=\'item_qty_normal\' size=\'13\' maxlength=\'13\' class=\"NUMBER\" onKeyPress=\"return isValidNumber(this,event,8,";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =");\" onBlur=\"checkDoubleFormat(this);calculateValue();\"  value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\"  ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="></td>\n\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="<!-- MO-CRF-20165 -->\n\t\t\t<td class=\'label\' ><span style=\"visibility:";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</span></td>\n\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t<td class=\'label\' ><span style=\"visibility:";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 =" \n\t\t\t<!-- \t\t\n\t\t\t* @Name - Priya\n\t\t\t* @Date - 10/02/2010\n\t\t\t* @Inc# - 19092 \n\t\t\t* @Desc - No.of Decimals is passed to isValidNumber function and in onblur  checkdoubleformat is called.\t\t\t\n\t\t\t-->\n\t\t\t<td class=\'fields\'><span style=\"visibility:";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\"><input type=\'text\' name=\'item_qty_bonus\' id=\'item_qty_bonus\' size=\'13\' maxlength=\'13\' class=\"NUMBER\" onKeyPress=\"return isValidNumber(this,event,8,";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\"></span></td>\n\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</span></td> \n\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 =" \n\t\t\t<!-- \t\t\n\t\t\t* @Name - Priya\n\t\t\t* @Date - 10/02/2010\n\t\t\t* @Inc# - 19092 \n\t\t\t* @Desc - No.of Decimals is passed to isValidNumber function and in onblur  checkdoubleformat is called.\t\t\t\n\t\t-->\n\t\t\t<td class=\'fields\' colspan=\"5\"><span style=\"visibility:";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\"><input type=\'text\' name=\'item_qty_sample\' id=\'item_qty_sample\' size=13 maxlength=13 class=\"NUMBER\" onKeyPress=\"return isValidNumber(this,event,8,";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 =");\"  value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\" onBlur=\"checkDoubleFormat(this);calculateValue();\" ></span></td>\n\t\t\t\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t<tr>\n\t\t\t\t<!-- \t\t\n\t\t\t* @Name - Priya\n\t\t\t* @Date - 11/02/2010\n\t\t\t* @Inc# - 19088 \n\t\t\t* @Desc - The precision for the field \'po_cost\' is changed to 8,noOfDecimalsForCost\t\t\t\n\t\t-->\n\t\t\t\t<td class=\'label\' >";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="</td>\n\t\t\t\t<td  class=\'fields\'><input type=\'text\' name=\'po_cost\' id=\'po_cost\' size=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\" maxlength=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\" class=\"NUMBER\" onKeyPress=\"return isValidNumberCost(this,event,8,";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 =");\" onBlur=\"calculatePoCost(this);calculateValue();checkDoubleFormat(this, false);\"  value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\"></td>\n\n\t\t\t\t<td class=\'label\' >";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="</td>\n\t\t\t\t<td  class=\'fields\'><input type=\'text\' name=\'po_discount\' id=\'po_discount\' size=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\" class=\"NUMBER\" onKeyPress=\"return isValidNumberCost(this,event,12,";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\"></td>\n\t\t\t\t<td class=\'label\' >";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 =" %</td>\n\t\t\t\t<td  class=\'fields\'>\n\t\t\t\t\t<!-- \t\t\n\t\t\t* @Name - Priya\n\t\t\t* @Date - 11/02/2010\n\t\t\t* @Inc# - 19088 \n\t\t\t* @Desc - The precision for the field \'po_tax\' is changed to 6,noOfDecimalsForCost\t\t\t\n\t\t-->\n\t\t\t\t<input type=\'text\' name=\'po_tax\' id=\'po_tax\' size=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\" class=\"NUMBER\" onKeyPress=\"return isValidNumberCost(this,event,6,";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\"></td>\n\t\t\t\t\n\t\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="</td>\n\t\t\t<td  class=\'fields\'>\n\t\t\t\t<!-- \t\t\n\t\t\t* @Name - Priya\n\t\t\t* @Date - 11/02/2010\n\t\t\t* @Inc# - 19088 \n\t\t\t* @Desc - The precision for the field \'user_grn_unit_cost_in_pur_uom\' is changed to 8,noOfDecimalsForCost\t\t\t\n\t\t-->\n\t\t\t<input type=\'text\' name=\'user_grn_unit_cost_in_pur_uom\'  id=\'user_grn_unit_cost_in_pur_uom\' size=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 =");\"  onBlur=\"setPOCost(this);calculateValue();checkDoubleFormat(this, false);\"  value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 =" onChange=\"grn_unit_cost_in_pur_uom.value=this.value;\">\n\t\t\t\t<span style=\"visibility:";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\"><IMG id=\'unit_cost_mandatory\'  src=\"../../eCommon/images/mandatory.gif\" > <!-- Added against GDOH-CRF-0109 -->\n\t\t\t<input type=\"hidden\" name=\"grn_unit_cost_in_pur_uom\" id=\"grn_unit_cost_in_pur_uom\" value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\" ></td>\n\t\t\t<td class=\'label\' >";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="</td>\n\t\t\t<td class=\'fields\' colspan=\"2\"><input type=\'text\' name=\'item_cost_value\' id=\'item_cost_value\' size=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 =");\" onBlur=\"calculateCost();checkDoubleFormat(this, false);\"  value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="></td>\n\t\t\t<td colspan=\'2\'></td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td class=\'label\' >";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="</td>\n\t\t\t<td  class=\'label\' colspan=\'2\'>\n\t\t\t<table border=\'0\' cellpadding=2 cellspacing=0 width=\'100%\' align=\'center\'>\n\t\t\t<tr><td class=\'fields\'><input type=\"checkbox\" name=\'label_reqd_yn\' id=\'label_reqd_yn\' value=\'Y\' ";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 =" onClick=\"no_of_labels.disabled=!this.checked\">\n\t\t\t</td>\n\t\t\t<td  class=\'label\'>";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="</td>\n\t\t\t</tr>\n\t\t\t</table>\n\t\t\t</td>\n\t\t\t<td  colspan=\'2\'>\n\t\t\t<table border=\'0\' cellpadding=2 cellspacing=0 width=\'100%\' align=center>\n\t\t\t<tr><td>\n\t\t\t<input type=\'text\' name=\'no_of_labels\' id=\'no_of_labels\' size=10 maxlength=10 class=\"NUMBER\" onKeyPress=\"return isValidInteger();\"  value=\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\" onBlur=\"checkIntegerFormat(this, false);\" ";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="></td>\n\t\t\t<td class=\'label\' >";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="</td>\n\t\t\t</tr>\n\t\t\t</table>\n\t\t\t</td>\n\t\t\t<td class=\'fields\' colspan=\"5\"><input type=\"checkbox\" name=\'replace_on_expiry_yn\' id=\'replace_on_expiry_yn\' value=\'Y\' ";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 =" ></td>\n\t\t</tr>\n\n\t\t<tr><!-- ADDED FOR MO-CRF-20165 START -->\n\t\t";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="</td>   \n\t\t\t<td colspan=3 class=\'fields\'><select name=\"catalog_code\" id=\"catalog_code\" ><option value=\"\">-----";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 =" \n\t\t\t\t";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="</option> \n\t\t\t\t\t";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\n\t\t\t</select> \n\t\t\t";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 =" <!-- ADDED FOR MO-CRF-20165 END -->\n\t\t\t<td class=\'label\' >";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="</td>\n\t\t\t<td  colspan=3 class=\'fields\'><select name=\'pur_uom_code\' id=\'pur_uom_code\' onBlur=\"checkUOMConvFactor();\" ";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 =">\n\t\t\t";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\n\t\t\t</select>";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 =":<b id=\"id_pur_uom_conv\">";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="</b>\n\t\t\t";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 =" <!-- MO-CRF-20165 -->\n\t\t\t<label onMouseOver=\"changeCursor(this);\"  class=\"label\" onClick = \"showItemRemarks();\"><font class=\'HYPERLINK\'>";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="</font></label></td>\t<!-- ADDED for MO-CRF-20165 -->\n\t\t\t";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\n\t\t\t</td>\n\t\t\n\t\t\t<td class=\'fields\'  colspan=\'8\'>\n\t\t\t\t<input type=\'button\' name=\"apply\" id=\"apply\" value=\"";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\" class=button onclick=\"if(issueUOMQtyChk()) addToList();\"><input type=button name=Cancel id=Cancel value=\'";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\' class=button  onclick=\"cancel_me();\">\n\t\t\t</td>\n\t\t</tr>\n\t\t</table>\n\t\t";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n\t\t<input type=\"hidden\" name=\"store_item_unit_cost\" id=\"store_item_unit_cost\"\tvalue=\"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\">\n\t\t<input type=\"hidden\" name=\"store_code\" id=\"store_code\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\">\n\t\t<input type=\"hidden\" name=\"uom_code\" id=\"uom_code\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\">\n\t\t<input type=\"hidden\" name=\"expiry_yn\" id=\"expiry_yn\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\">\n\t\t<input type=\"hidden\" name=\"doc_srl_no\" id=\"doc_srl_no\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\">\n\t\t<input type=\"hidden\" name=\"index\" id=\"index\"\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\">\n\t\t<input type=\"hidden\" name=\"dis_expiry_yn\" id=\"dis_expiry_yn\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\" >\n\t\t<input type=\"hidden\" name=\"tmp_conv\" id=\"tmp_conv\"\t\t\t\tvalue=\"\">\n\t\t<input type=\"hidden\" name=\"pur_uom_conv\" id=\"pur_uom_conv\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\">\n\t\t<input type=\"hidden\" name=\"item_class_code\" id=\"item_class_code\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\">\n\t\t<input type=\"hidden\" name=\"phy_inv_id\" id=\"phy_inv_id\"\t\t\t\tvalue=\"\">\n\t\t<input type=\"hidden\" name=\"po_details_applicable_yn\" id=\"po_details_applicable_yn\"value=\"";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\">\n\t\t<input type=\"hidden\" name=\"tmp_cost\" id=\"tmp_cost\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\">\n\t\t<input type=\'hidden\' name=\'allow_deci_yn\' id=\'allow_deci_yn\'\t\tvalue=\"";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\">\n\t    <input type=\'hidden\' name=\'no_deci\' id=\'no_deci\'\t\tvalue=\"";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\">\n\n\t\t<input type=\"hidden\" name=\"ordered_qty\" id=\"ordered_qty\"\t\tvalue=\"";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\">\n\t\t<input type=\"hidden\" name=\"delivery_date\" id=\"delivery_date\"\t\tvalue=\"";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\">\n\t\t<input type=\"hidden\" name=\"po_interface_yn\" id=\"po_interface_yn\"\t\tvalue=\"";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\">\n\t\t<input type=\"hidden\" name=\"conversion_rate\" id=\"conversion_rate\"\t\tvalue=\"";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\">\n\t\t<input type=\"hidden\" name=\"delv_date_override_yn\" id=\"delv_date_override_yn\"\t\t\t value=\"";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\">\n\t\t<input type=\"hidden\" name=\"price_override_yn\" id=\"price_override_yn\"\t\tvalue=\'";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\'>\n\t\t<input type=\"hidden\" name=\"remarks\" id=\"remarks\"\t\t\t\tvalue=\"\"><!-- added for MO-CRF-20165 START-->\n\t\t<input type=\"hidden\" name=\"function_id\" id=\"function_id\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\"><!-- END -->\n\t\t<!-- \t\t\n\t\t* @Name - Priya\n\t\t* @Date - 10/02/2010\n\t\t* @Inc# - 19092\n\t\t* @Desc - Code added to accept decimal values dynamically.\t\t\t\n\t\t-->\n\t<input type=\"hidden\"\t\tname=\"dec_allowed_yn\" id=\"dec_allowed_yn\"\t\t\t value=\"";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\">\n\t<input type=\"hidden\"\t\tname=\"no_of_decimals\" id=\"no_of_decimals\"\t\t\t value=\"";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\">\n\t<input type=\"hidden\"\t\tname=\"no_of_decimals_for_cost\" id=\"no_of_decimals_for_cost\"\t value=\'";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\'>\n\t<input type=\"hidden\"\t\tname=\"po_unit_cost_in_pur_uom\" id=\"po_unit_cost_in_pur_uom\"\t value=\'";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\'>\n\t<input type=\"hidden\"\t\tname=\"by_po\" id=\"by_po\"\t\t\t\t\t value=\'";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\'>\n\t<input type=\"hidden\"\t\tname=\"grn_newfields_applicable\" id=\"grn_newfields_applicable\"\t\t \t\t\t value=\'";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\'><!-- added for MO-CRF-20165 --> \n\t<input type=\"hidden\"\t\tname=\"item_2d_barcode_yn\" id=\"item_2d_barcode_yn\"\t\t \t\t\t value=\'";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\'><!-- added for MOHE-CRF-0167 --> \n\t\n\n\t</form>\n";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\n\t</body>\n</html>\n\n\n";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );
	
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

/*
--------------------------------------------------------------------------------------------------------------
Date       		Edit History      	Name       	Rev.Date   		Rev.By    	Description
--------------------------------------------------------------------------------------------------------------
19/04/2016		4708			B.Badmavathi						GRN Validation removed for UOM for KAUH		
19/05/2017		62881			B.Badmavathi						Unit Cost Mandatory in GRN 
22/4/2021		TFS:14012		Shazana			22/4/2021	   Manickam		MO-CRF-20165 
9/2/2022				TFS28606				Shazana						MO-CRF-20178  
---------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
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
		String locale				= (String)session.getAttribute("LOCALE");
		String sStyle				=  (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	GoodsReceivedNoteBean bean		=	(GoodsReceivedNoteBean) getBeanObject( "goodsReceivedNoteBean", "eST.GoodsReceivedNoteBean" ,request   );
	StHeaderBean stbean				=	(StHeaderBean) getBeanObject( "StHeaderBean", "eST.Common.StHeaderBean" ,request   );
	//Added by B.Badmavathi against KAUH-SCF-0249 STARTS
	Connection con				= null;
	con						= ConnectionManager.getConnection(request);
	boolean site_main = eCommon.Common.CommonBean.isSiteSpecific(con, "MM","MM_GRN");
	bean.setSite_spec_yn(site_main);
	//Added by B.Badmavathi against KAUH-SCF-0249 ENDS
//	Added by B.Badmavathi against GDOH-CRF-0109 STARTS
	boolean check_uc = eCommon.Common.CommonBean.isSiteSpecific(con, "MM","MM_UNIT_COST_MANDATORY_GRN");
	boolean grn_newfields_applicable = eCommon.Common.CommonBean.isSiteSpecific(con, "ST","ST_GRN_NEW_FIELDS");//Added for MO-CRF-20165 
	String item_2d_barcode_yn =bean.barcode2DApplicable();//Added for MOHE-CRF-0167
	String visibilityUnitCost			= 	"";
	if(check_uc)
		visibilityUnitCost =	"visible";	
	else
		visibilityUnitCost =	"hidden";
//	Added by B.Badmavathi against GDOH-CRF-0109 ENDS
	bean.setLanguageId(locale);
	String store_code				=	bean.getStore_code();
	
	String stButtonLegend			=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels");

	String index					=	bean.checkForNull(request.getParameter("index"),"-1");
	String doc_srl_no				=	bean.checkForNull(request.getParameter("doc_srl_no"),"-1");

	String item_code				=	"";
	String item_desc				=	"";
	String uom						=	"";
	String uom_code					=	"";
	String pur_uom_code				=	"";
	String item_qty_normal			=	"";
	String item_qty_bonus			=	"";
	String item_qty_sample			=	"";
	String item_cost_value			=	"";
	String replace_on_expiry_yn		=	"N";
	String label_reqd_yn			=	"N";
	String expiry_yn				=	"";
	String pur_uom_conv				=	"";
	String store_item_unit_cost		=	"";
	String codeDisabled				=	"";
	String codeDisabled1			=	"";
	String dis_expiry_yn			=	"";
	String no_of_labels				=	"";
	String grn_unit_cost_in_pur_uom	=	"";
	String po_cost					=	"";
	String po_discount				=	"";
	String po_tax					=	"";
	String rate_disabled			=	"";
	String dis						=	"";
	String allow_deci_yn            =    "";
	String pur_uom_conv_id           =    "";
	String remarks_desc           = ""; //added for MO-CRF-20165 
	String catalog_code ="";
	String manufacture_id="";
	String manufacturer_disabled	=  ""; //END 
	String manufac_remarks_disabled = "";  //MO-CRF-20178 
	String manufac_remarks = "";//MO-CRF-20178  
	int no_deci                   =    bean.getNoOfDecimals();
	String visibilityBonus			=	((String)bean.getMmParameter().get("RECEIVE_BONUS_YN")).equals("Y")?"visible":"hidden";	
	String visibilitySample			=	((String)bean.getMmParameter().get("RECEIVE_SAMPLE_YN")).equals("Y")?"visible":"hidden";	
	double effective_qty=0.0;
	double item_qty=0.0;
	double ordered_qty = 0.0;
	String delivery_date = "";

	String conversion_rate = bean.checkForNull(request.getParameter("conversion_rate"));
	String po_unit_cost_in_pur_uom	=	"";

	String mode = bean.getMode();

	String by_po = "";
	String QtyDisabled				=	"";
	String delv_date_override_yn	=	"";
	String price_override_yn		=	"";

	int noOfDecimalsForCost=Integer.parseInt(bean.getNoOfDecimalsCost());	

	HashMap hmTemp	=	(HashMap)bean.fetchRecord("SELECT PO_DETAILS_APPLICABLE_YN,PO_INTERFACE_YN FROM ST_ACC_ENTITY_PARAM");
	
	String  po_details_applicable_yn	=	bean.checkForNull((String)hmTemp.get("PO_DETAILS_APPLICABLE_YN"),"N");
	String po_interface_yn				=   bean.checkForNull((String)hmTemp.get("PO_INTERFACE_YN"),"N");
		
	 if(po_interface_yn.equals("Y")){
	 
	 HashMap PO_Override				=	bean.fetchRecord(bean.getStRepositoryValue("SQL_PO_PARAMETER_OVERRIDE_ALLOW"));

	 delv_date_override_yn	=	bean.checkForNull((String)PO_Override.get("ALLOW_OVERRIDE_PO_DLVDT"),"N");
	 price_override_yn		=	bean.checkForNull((String)PO_Override.get("ALLOW_PRICE_OVERRIDE_IN_GRN"),"N");
	 }


	if(!index.equals("-1")){

		HashMap hmRecord			=	bean.getDtlRecord(Integer.parseInt(index));

		System.out.println("hmRecord------71----"+hmRecord);


		stButtonLegend				=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modify.label","common_labels");
		

		doc_srl_no					=	(String)hmRecord.get("doc_srl_no");
		item_code					=	(String)hmRecord.get("item_code");
		item_desc					=	(String)hmRecord.get("item_desc");
		uom							=	(String)hmRecord.get("uom_desc");
		uom_code					=	(String)hmRecord.get("uom_code");
		pur_uom_code				=	(String)hmRecord.get("pur_uom_code"); 
		manufacture_id              =   bean.checkForNull((String)hmRecord.get("manufacturer_id"),""); //Added for MO-CRF-20165 
		remarks_desc                =  	bean.checkForNull((String)hmRecord.get("remarks_desc"),"");
		catalog_code				=  bean.checkForNull((String)hmRecord.get("catalog_code"),"");
		manufac_remarks 			= bean.checkForNull((String)hmRecord.get("manufac_remarks"),"");//MO-CRF-20178    
		bean.setItemRemarks(remarks_desc); //end   

		by_po						=	bean.checkForNull((String)hmRecord.get("by_po"),"N");

		
		if((bean.getAllowDecimalsYN(item_code)).equals("N")){
			no_deci = 0;
		}
		item_qty_normal				=	(bean.checkForNull((String)hmRecord.get("item_qty_normal")).equals(""))?"":bean.setNumber((String)hmRecord.get("item_qty_normal"),no_deci);
		item_qty_bonus				=	(bean.checkForNull((String)hmRecord.get("item_qty_bonus")).equals(""))?"":bean.setNumber((String)hmRecord.get("item_qty_bonus"),no_deci);
		item_qty_sample				=	(bean.checkForNull((String)hmRecord.get("item_qty_sample")).equals(""))?"":bean.setNumber((String)hmRecord.get("item_qty_sample"),no_deci);
		item_cost_value				=	(String)hmRecord.get("item_cost_value");
		replace_on_expiry_yn		=	bean.checkForNull((String)hmRecord.get("replace_on_expiry_yn"),"N");
		label_reqd_yn				=	bean.checkForNull((String)hmRecord.get("label_reqd_yn"),"N");
		expiry_yn					=	(String)hmRecord.get("expiry_yn");   
        allow_deci_yn               =   (String)hmRecord.get("allow_deci_yn");
      
		no_of_labels				=	bean.checkForNull((String)hmRecord.get("no_of_labels")); 	
		
		// Check For Null is added for the Interface Work By Ramana CV on 8/14/2009
		grn_unit_cost_in_pur_uom	=	bean.checkForNull((String)hmRecord.get("grn_unit_cost_in_pur_uom"),"");     
		po_unit_cost_in_pur_uom	=	bean.checkForNull((String)hmRecord.get("grn_unit_cost_in_pur_uom"),"");     
		po_cost						=	bean.checkForNull((String)hmRecord.get("po_cost"));     
		po_discount					=	bean.checkForNull((String)hmRecord.get("po_discount"));     
		po_tax						=	bean.checkForNull((String)hmRecord.get("po_tax"));  
		
		if(hmRecord.containsKey("ordered_qty"))
		ordered_qty   =		Double.parseDouble(bean.checkForNull((String)hmRecord.get("ordered_qty")));

		delivery_date = 	 bean.checkForNull((String)hmRecord.get("delivery_date"));  
		conversion_rate =	 bean.checkForNull(conversion_rate,bean.checkForNull((String)hmRecord.get("conversion_rate")));
	
		if (!((!bean.checkForNull(item_qty_normal,"0").equals("0"))&&bean.checkForNull(item_qty_bonus,"0").equals("0")&&bean.checkForNull(item_qty_sample,"0").equals("0"))) {
			rate_disabled			=	"disabled";
		}
		if (!item_qty_normal.equals("")) {
			effective_qty+=Double.parseDouble(item_qty_normal);
		}
		if (!item_qty_bonus.equals("")) {
			effective_qty+=Double.parseDouble(item_qty_bonus);
		}
		if (no_of_labels.equals("")){
			no_of_labels=""+effective_qty;
		}
		
		double item_value = 0;			
		if(po_interface_yn.equals("Y") && by_po.equals("Y")){
			item_value = (effective_qty * Double.parseDouble(grn_unit_cost_in_pur_uom) * Double.parseDouble(bean.checkForNull(conversion_rate,"1")));
		}else{
			item_value = (effective_qty * Double.parseDouble(grn_unit_cost_in_pur_uom));
		}

		item_cost_value=bean.setNumber((""+item_value),noOfDecimalsForCost);
		

		if (effective_qty!=0 && grn_unit_cost_in_pur_uom.equals("")) {
			double unit_cost		=	Double.parseDouble(item_cost_value)/effective_qty;
			grn_unit_cost_in_pur_uom=bean.setNumber((""+unit_cost),noOfDecimalsForCost);
		}else if(effective_qty!=0 && po_interface_yn.equals("Y")){
			double unit_cost1		=	Double.parseDouble(item_cost_value)/effective_qty;
			grn_unit_cost_in_pur_uom=bean.setNumber((""+unit_cost1),noOfDecimalsForCost);
		}

		if( (replace_on_expiry_yn).equals("N") && (expiry_yn).equals("N") )
			dis_expiry_yn			=	"disabled";

		store_item_unit_cost	=	(String)hmRecord.get("store_item_unit_cost");
		pur_uom_conv			=	(String)hmRecord.get("pur_uom_conv");
		pur_uom_conv_id			=	(String)hmRecord.get("pur_uom_conv_id");
		
		if(pur_uom_conv.equals(pur_uom_conv_id)){
			pur_uom_conv_id=pur_uom_conv;
		}
		if(by_po.equals("N")){
			codeDisabled			=	"disabled";
		}
		codeDisabled1			=	"disabled";


		if(po_interface_yn.equals("Y")){
			QtyDisabled				=	"disabled";	
		}
	}


		if(po_interface_yn.equals("Y")){
		po_details_applicable_yn = "N";
		}

		if(po_details_applicable_yn.equals("Y")){
			if(!((String)bean.checkForNull(po_cost)).equals(""))
				dis = "disabled";
		}
	
		String item_disabled			=	request.getParameter("item_disabled")==null?"":request.getParameter("item_disabled");
	
		if(!((String)bean.checkForNull(bean.getPo_no())).equals("") && po_interface_yn.equals("N"))
		item_disabled="disabled";
		
		if(!index.equals("-1")){ //added for MO-CRF-20165 TFS:19215
			manufacturer_disabled =""; 
		}else{
			if(manufacture_id==null || manufacture_id.trim().equals("")){//MO-CRF-20165 START
				manufacturer_disabled = "disabled" ;
			}
			else{
				manufacturer_disabled="" ;
			} 
		}//END
		
		/*if(mode.equals("2")){
			manufac_remarks_disabled = "";//MO-CRF-20178 
			if(manufac_remarks==null || manufac_remarks.equals("")){
				manufac_remarks_disabled = "";  
			}else{
				manufac_remarks_disabled = "disabled";  	
			}
		}*/
		//MO-CRF-20178 

	
            _bw.write(_wl_block9Bytes, _wl_block9);
try{
            _bw.write(_wl_block10Bytes, _wl_block10);
 if(item_2d_barcode_yn.equals("Y")){//Added for MOHE-CRF-0167 starts
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
} //Added for MOHE-CRF-0167 ends
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(item_desc));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(codeDisabled1));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(codeDisabled1));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(item_disabled));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(bean.getImage("M")));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(uom));
            _bw.write(_wl_block21Bytes, _wl_block21);
if(grn_newfields_applicable){ 
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(manufacturer_disabled));
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

				ArrayList	arrManu				=	null;
				HashMap		hmManu				=	null;	
				String code = "";
				String	desc  = "";
				String Manu_select				=	"";
				//arrManu =	bean.getManufactureList();
				arrManu =	bean.getDropDownList("MANU"); 
				int arrLength	=	arrManu.size();
            _bw.write(_wl_block26Bytes, _wl_block26);
 
				for(int i=0;i<arrLength; i++)
				{
					hmManu		=	(HashMap) arrManu.get(i);

					code				=	(String)hmManu.get("code");
					desc				=	(String)hmManu.get("desc");
					if(code.trim().equals(manufacture_id))
					{
						Manu_select		=	"Selected";
					}
					else
						Manu_select		=	"";
					
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(code));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(Manu_select));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block29Bytes, _wl_block29);

				} 					
			
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(manufac_remarks_disabled));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(manufac_remarks));
            _bw.write(_wl_block31Bytes, _wl_block31);
} 
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);
if(grn_newfields_applicable){ 
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);
}else { 
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);
} 
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(no_deci));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(item_qty_normal));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(QtyDisabled));
            _bw.write(_wl_block39Bytes, _wl_block39);
if(grn_newfields_applicable){ 
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(visibilityBonus));
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);
}else { 
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(visibilityBonus));
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);
} 
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(visibilityBonus));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(no_deci));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(item_qty_bonus));
            _bw.write(_wl_block46Bytes, _wl_block46);
if(grn_newfields_applicable){ 
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(visibilitySample));
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);
}else { 
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(visibilitySample));
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block47Bytes, _wl_block47);
} 
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(visibilitySample));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(no_deci));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(item_qty_sample));
            _bw.write(_wl_block51Bytes, _wl_block51);
if(po_details_applicable_yn.equals("Y")){
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(Integer.parseInt(bean.getStRepositoryValue("VALUE_PRECISION"))-3));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(bean.getStRepositoryValue("VALUE_PRECISION")));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(noOfDecimalsForCost));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(po_cost.equals("")?"":bean.setNumber(po_cost,noOfDecimalsForCost)));
            _bw.write(_wl_block57Bytes, _wl_block57);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(Integer.parseInt(bean.getStRepositoryValue("VALUE_PRECISION"))-3));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(bean.getStRepositoryValue("VALUE_PRECISION")));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(noOfDecimalsForCost));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(po_discount.equals("")?"":bean.setNumber(po_discount,noOfDecimalsForCost)));
            _bw.write(_wl_block60Bytes, _wl_block60);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(Integer.parseInt(bean.getStRepositoryValue("VALUE_PRECISION"))-3));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(bean.getStRepositoryValue("VALUE_PRECISION")));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(noOfDecimalsForCost));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(po_tax.equals("")?"":bean.setNumber(po_tax,noOfDecimalsForCost)));
            _bw.write(_wl_block63Bytes, _wl_block63);
}
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(Integer.parseInt(bean.getStRepositoryValue("VALUE_PRECISION"))-3));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(bean.getStRepositoryValue("VALUE_PRECISION")));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(noOfDecimalsForCost));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(bean.setNumber(grn_unit_cost_in_pur_uom,noOfDecimalsForCost)));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(rate_disabled));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(visibilityUnitCost));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(bean.setNumber(grn_unit_cost_in_pur_uom,noOfDecimalsForCost)));
            _bw.write(_wl_block68Bytes, _wl_block68);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(bean.getStRepositoryValue("VALUE_PRECISION")));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(bean.getStRepositoryValue("VALUE_PRECISION")));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(noOfDecimalsForCost));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(item_cost_value));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block71Bytes, _wl_block71);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(bean.getChecked(label_reqd_yn)));
            _bw.write(_wl_block73Bytes, _wl_block73);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(no_of_labels));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(label_reqd_yn.equals("N")?"disabled":""));
            _bw.write(_wl_block76Bytes, _wl_block76);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(bean.getChecked(replace_on_expiry_yn)));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(dis_expiry_yn));
            _bw.write(_wl_block78Bytes, _wl_block78);
if(grn_newfields_applicable){ 
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block79Bytes, _wl_block79);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
 
				ArrayList	arrCatalog				=	null;
				HashMap		hmCatalog				=	null;	
				String code = "";
				String	desc  = "";
				String catalog_select				=	"";
			//	arrCatalog =	bean.getCatalogCodeList(); 
				arrCatalog = bean.getDropDownList("CAT"); 
				int arrLength	=	arrCatalog.size();
            _bw.write(_wl_block80Bytes, _wl_block80);
 
				for(int i=0;i<arrLength; i++)
				{
					hmCatalog		=	(HashMap) arrCatalog.get(i);

					code				=	(String)hmCatalog.get("code");
					desc				=	(String)hmCatalog.get("desc");
					if(code.trim().equals(catalog_code))
					{
						catalog_select		=	"Selected";
					}
					else
						catalog_select		=	"";				
					
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(code));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(catalog_select));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block81Bytes, _wl_block81);

				} 
								
			
            _bw.write(_wl_block82Bytes, _wl_block82);
} 
            _bw.write(_wl_block83Bytes, _wl_block83);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(codeDisabled));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(bean.getPur_uom_code_List(pur_uom_code,item_code)));
            _bw.write(_wl_block86Bytes, _wl_block86);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(pur_uom_conv_id));
            _bw.write(_wl_block88Bytes, _wl_block88);
 if(grn_newfields_applicable){ 
            _bw.write(_wl_block89Bytes, _wl_block89);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block90Bytes, _wl_block90);
 } 
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(stButtonLegend));
            _bw.write(_wl_block92Bytes, _wl_block92);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block93Bytes, _wl_block93);

	 	}
		catch(Exception e){
			out.println("Exception@1: "+e.toString());
			e.printStackTrace();
		}
		finally{
			con.close();
		}
		
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(store_item_unit_cost));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(store_code));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(uom_code));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(expiry_yn));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(doc_srl_no));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(index));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(dis_expiry_yn));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(pur_uom_conv));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(stbean.getItem_class_code()));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(po_details_applicable_yn));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(bean.setNumber(grn_unit_cost_in_pur_uom,noOfDecimalsForCost)));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(allow_deci_yn));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(no_deci));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(ordered_qty));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(delivery_date));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(po_interface_yn));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(bean.checkForNull(conversion_rate,"1")));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(delv_date_override_yn));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(price_override_yn));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf( request.getParameter("function_id") ));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(bean.getAllowDecimalsYN(item_code)));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(no_deci));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(noOfDecimalsForCost));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(po_unit_cost_in_pur_uom));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(by_po));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(grn_newfields_applicable));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(item_2d_barcode_yn));
            _bw.write(_wl_block121Bytes, _wl_block121);

	putObjectInBean("goodsReceivedNoteBean",bean,request);

            _bw.write(_wl_block122Bytes, _wl_block122);
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Manufacturer.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.BatchSearch.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.NormalQty.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Normal.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.BonusQty.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.Bonus.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.SampleQty.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.Sample.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.POCost.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.PODiscount.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.Tax.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.UnitCost.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Value.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Label.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.NoofLabels.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.Replonexpiry.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.Catalogue.label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag21(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag21 = null ;
        int __result__tag21 = 0 ;

        if (__tag21 == null ){
            __tag21 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag21);
        }
        __tag21.setPageContext(pageContext);
        __tag21.setParent(null);
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PurchaseUOM.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag21;
        __result__tag21 = __tag21.doStartTag();

        if (__result__tag21!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag21== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag21.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag21);
            return true;
        }
        _activeTag=__tag21.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag21);
        __tag21.release();
        return false;
    }

    private boolean _jsp__tag22(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag22 = null ;
        int __result__tag22 = 0 ;

        if (__tag22 == null ){
            __tag22 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag22);
        }
        __tag22.setPageContext(pageContext);
        __tag22.setParent(null);
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.ConvFactorRule.label", java.lang.String .class,"key"));
        __tag22.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag22;
        __result__tag22 = __tag22.doStartTag();

        if (__result__tag22!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag22== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag22.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag22);
            return true;
        }
        _activeTag=__tag22.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag22);
        __tag22.release();
        return false;
    }

    private boolean _jsp__tag23(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag23 = null ;
        int __result__tag23 = 0 ;

        if (__tag23 == null ){
            __tag23 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag23);
        }
        __tag23.setPageContext(pageContext);
        __tag23.setParent(null);
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
        __tag23.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag23;
        __result__tag23 = __tag23.doStartTag();

        if (__result__tag23!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag23== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag23.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag23);
            return true;
        }
        _activeTag=__tag23.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag23);
        __tag23.release();
        return false;
    }

    private boolean _jsp__tag24(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag24 = null ;
        int __result__tag24 = 0 ;

        if (__tag24 == null ){
            __tag24 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag24);
        }
        __tag24.setPageContext(pageContext);
        __tag24.setParent(null);
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.cancel.label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag24;
        __result__tag24 = __tag24.doStartTag();

        if (__result__tag24!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag24== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag24.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag24);
            return true;
        }
        _activeTag=__tag24.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag24);
        __tag24.release();
        return false;
    }
}
