package jsp_servlet._est._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eST.*;
import eST.Common.*;
import eCommon.Common.*;
import java.text.*;
import java.util.*;
import java.lang.*;
import java.sql.*;
import webbeans.eCommon.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __goodsreceivednotelistdetail extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/est/jsp/GoodsReceivedNoteListDetail.jsp", 1733632839564L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n \n ";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 =" \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<html>\n<head>\n\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\' ></link>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n\t<script language=\"javascript\" src=\"../../eST/js/StCommon.js\"></script>\n\t<script language=\"javaScript\" src=\"../../eST/js/GoodsReceivedNote.js\"></script>\n\t<script language=\"javaScript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n<script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\n<body>\n<form name=\"formGoodsReceivedNoteListDetail\" id=\"formGoodsReceivedNoteListDetail\" action=\"../../servlet/eST.DocUploadServlet\" method=\"post\"  enctype=\'multipart/form-data\' >  <!-- Added action and enctype properties for //23925 -->\n\t<table border=\'1\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' align=center>\n\t<tr>\n\t\t<th nowrap>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</th>\n\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =" <!-- Added for MO-CRF-20165 -->\n\t\t<th>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</th> \n\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t<th>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</th>\n\t\t<th>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t<th nowrap>Sale Price/";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t<th>Uploaded Document</th> <!-- //23925 -->\n\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t <tr>\n\t\t\n\t\t<td nowrap class=\'fields\'>\n\t\t<input class=\"STSMALL\" type=\'text\' name=\"expiry_date_or_receipt_date_";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" id=\"expiry_date_or_receipt_date_";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="  ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" size=10 maxlength=\'10\' onBlur=\"getBatchIDFromExpiryDate(expiry_date_or_receipt_date_";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =",";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =");ChekDate(this,\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\');CheckMaxYearForExpiryDate(this,\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\');CallNewBarcodeString(\'goodsReceivedNoteBean\',\'eST.GoodsReceivedNoteBean\',\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\',\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\',batch_id_";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =",expiry_date_or_receipt_date_";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =",trade_id_";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =",bin_location_code_";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =",\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\',barcode_id_";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =",grn_item_qty_";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =",sale_price_";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =");\"  onchange=\"\"><img src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendarLocal  (\'expiry_date_or_receipt_date_";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\');\" ";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 =" ";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="></img>\t</td>\n\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="<!-- MO-CRF-20165 -->\n\t\t<td class=\'fields\'><input class=\"STSMALL\" type=\'text\' name=\"manufactured_date_";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" id=\"manufactured_date_";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\"  value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" size=10 maxlength=\'10\' onBlur=\"ChekDate(this,\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\');doDateCheckLocal(this);doDateCheckWithExpDate  (this,expiry_date_or_receipt_date_";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 =");\"  onchange=\"\"><img src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendarLocal  (\'manufactured_date_";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\');\" ></img>\t</td>\n\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 =" \n\t\t<td class=\'fields\'>&nbsp;<input type=\'text\' class=\"UPPER\" name=\"batch_id_";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\" id=\"batch_id_";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\" value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\"size=18 maxlength=20 ";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 =" onKeyPress=\"return  CheckForSpecialChars(event);\"  onBlur=\"CallNewBarcodeString(\'goodsReceivedNoteBean\',\'eST.GoodsReceivedNoteBean\',\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 =")\">\t</td>\n\t\t<td class=\'fields\'><select class=\"STSMALL\" name=\"trade_id_";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\" id=\"trade_id_";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\"  onchange=\"CallNewBarcodeString(\'goodsReceivedNoteBean\',\'eST.GoodsReceivedNoteBean\',\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 =");\">";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="</select></td>\n\t\t<td class=\'fields\'>\t<select class=\"STSMALL\" name=\"bin_location_code_";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\" id=\"bin_location_code_";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\" onchange=\"CallNewBarcodeString(\'goodsReceivedNoteBean\',\'eST.GoodsReceivedNoteBean\',\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 =")\">\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="</select></td>\n\t";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t\t<td class=\'fields\' ><input class=\"STSMALL\" type=\'text\' name=\"grn_item_qty_";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\" id=\"grn_item_qty_";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\"  style=\"text-align:right\" onKeyPress=\"return isValidNumber(this,event,7,";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 =");\" ";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 =" size=10 maxlength=12 onblur=\"checkDoubleFormat(this);CallNewBarcodeString(\'goodsReceivedNoteBean\',\'eST.GoodsReceivedNoteBean\',\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 =")\">\t</td>\n\t";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t\t<td  class=\'fields\'>&nbsp;&nbsp;<input type=\'text\' name=\"barcode_id_";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\" id=\"barcode_id_";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\" size=20 maxlength=20 class=\"NUMBER\"  onKeyPress=\"return  CheckForSpecialChars(event);\"  value=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\"  ";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 =" ></td>\n\t";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n\t\t\t<td  class=\'fields\'>&nbsp;&nbsp;<input type=\'text\' name=\"sale_price_";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\" id=\"sale_price_";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\" size=8 maxlength=7 class=\"NUMBER\" onKeyPress=\"return isValidNumberCost(this,event,12,";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 =");\" onBlur=\"checkUnitCost(this);checkDoubleFormat(this, false);;CallNewBarcodeString(\'goodsReceivedNoteBean\',\'eST.GoodsReceivedNoteBean\',\'";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 =")\"  value=\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\"></td>\n\t";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n\t\t\t<input type=\'hidden\' name=\"sale_price_";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\">\n\t";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\n\t";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\n\t\t\t<input type=\'hidden\' name=\"barcode_id_";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\n\t\t<input type=\'hidden\' value=\"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\" name=\"by_do_";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\">\n\t\t<!--  Added by Rabbani #Inc no:40591 on 07-JUN-2013 -->\n\t\t<input type=\'hidden\' name=\"shelf_life_exp_date_";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\" id=\"shelf_life_exp_date_";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\">\t\n\t\t<!-- 23925 Start-->\n\t\t<td class = \'fields\'  >\t\n\t\t";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\n\t\t\t\t<input type=\'hidden\' name = \'fileRef_";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\' id=\'fileRef_";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\' value=\'";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\' />\t\t\n\t\t\t\t<input type=\'file\' name=\'fileupload_";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\'  id = \'fileuploadid_";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\' size=\'30\' onMouseDown=\' \' onKeyDown=\'\' onKeyPress =\'\'  onContextMenu =\'return false;\' onChange=\"javascript:validateUploadImage(\'fileuploadid_";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\');\" onclick=\"\" >\n\t\t</td>\n\t\t<!-- 23925 End-->\n\t</tr>\n\t";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\n</table> \n\n\t<input type=\"hidden\" name=\"sys_date\" id=\"sys_date\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\">  \n\t<input type=\"hidden\" name=\"item_code\" id=\"item_code\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\">\n\t<input type=\"hidden\" name=\"store_code\" id=\"store_code\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\">\n\t<input type=\"hidden\" name=\"gen_uom_desc\" id=\"gen_uom_desc\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\">\n\t<input type=\"hidden\" name=\"batch_id_applicable_yn\" id=\"batch_id_applicable_yn\"  value=\"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\">\n\t<input type=\"hidden\" name=\"sale_price_appl_yn\" id=\"sale_price_appl_yn\"\t\tvalue=\"";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\">\n\t<input type=\"hidden\" name=\"lesser_sale_price_yn\" id=\"lesser_sale_price_yn\"\tvalue=\"";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\">\n\t<input type=\"hidden\" name=\"index\" id=\"index\"\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\">\n\t<input type=\"hidden\" name=\"total_records\" id=\"total_records\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\">\n    <input type=\"hidden\" name=\"language_id\" id=\"language_id\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\">\n    <input type=\"hidden\" name=\"allow_deci_yn\" id=\"allow_deci_yn\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\">\n\t<input type=\"hidden\" name=\"no_deci\" id=\"no_deci\"\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\">\n    <input type=\"hidden\" name=\"BarcodeRule\" id=\"BarcodeRule\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\">\n\t<input type=\"hidden\" name=\"manufacturer_id\" id=\"manufacturer_id\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\" >\n\t<input type=\"hidden\" name=\"supplier_id\" id=\"supplier_id\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\" >\n\t<input type=\"hidden\" name=\"mrp\" id=\"mrp\"\t\t\t\t\t\tvalue=\"\" >\n\t<input type=\"hidden\" name=\"trn_type\" id=\"trn_type\"\t\t\t\tvalue=\"GRN\" >\n\t<input type=\"hidden\" name=\"shelfLifeDate\" id=\"shelfLifeDate\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\" >\n\t<input type=\"hidden\" name=\"formatedDate\" id=\"formatedDate\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\" >  <!-- //23925 -->\n<script>\n\t\tif(document.forms[0].trade_id_0.length==1)\n\t\t{\n\t\t\talert(getMessage(\"TRADE_NOT_ASS_FOR_ITEM\",\"ST\"));\n\t\t\tparent.frameGoodsReceivedNoteListHeader.location.reload();\n\t\t\tself.location.href=\"../../eCommon/html/blank.html\";\n\t\t}\n\t\telse if(document.forms[0].bin_location_code_0.length==1)\n\t\t{\t\t\t\n\t\t\talert(getMessage(\"BIN_LOCN_NOT_ASS_FOR_STORE\",\"ST\"));\n\t\t\tparent.frameGoodsReceivedNoteListHeader.location.reload();\n\t\t\n\t\t\tself.location.href=\"../../eCommon/html/blank.html\";\n\t\t}\n\t</script>\n</form>\n";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\n</body>\n</html>\n\t";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );
	
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
22/4/2021		TFS:14012				Shazana			22/4/2021	   			Manickam				MO-CRF-20165 
23/04/2022		23925					Ramesh Goli		23/04/2022			RAMESH G    			MO-CRF-20171
-------------------------------------------------------------------------------------------------------------------------------------------- 
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block4Bytes, _wl_block4);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block7Bytes, _wl_block7);

	request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");

		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String facilityid=(String)session.getValue("facility_id");
		Connection con				= null; //Added for MO-CRF-20165  
		con						= ConnectionManager.getConnection(request);
	
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

try{
	//23925 Start.
	java.util.Date myDate = new java.util.Date();
	SimpleDateFormat mdyFormat = new SimpleDateFormat("ddMMyyyyhhmmssSSS");
	String formatedDate=mdyFormat.format(myDate);
	//23925 End.	
	GoodsReceivedNoteBean bean = (GoodsReceivedNoteBean) getBeanObject( "goodsReceivedNoteBean", "eST.GoodsReceivedNoteBean", request  );
	bean.setLanguageId(locale); 	   
	ArrayList alExpRecords	=	new ArrayList();
	HashMap hmTmpExpRecords =   new HashMap();
	String	sys_date		=	bean.getSysDate();
	//To set values in GoodsReceivedNoteBean
	String exp_disp_date="";
	String manufactured_date = ""; //added for MO-CRF-20165 
	String	item_code = request.getParameter("item_code");
	String	index = bean.checkForNull(request.getParameter("index"),"-1");

	//String	flag = bean.checkForNull(request.getParameter("flag"),"X");
	String allow_deci_yn = "";
    String no_deci    = "";
    allow_deci_yn        =       bean.checkForNull(bean.getAllowDecimalsYN(item_code),"N");
            if(allow_deci_yn.equals("Y"))
			no_deci              =       ""+bean.checkForNull(""+bean.getNoOfDecimals(),"0");
			else
            no_deci   = "0";

	if (item_code==null) {
		return;
	}
	HashMap hmItemRecord		=	bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_ITEM_SELECT_FOR_GRN"),item_code);
	HashMap hmTemp	=	(HashMap)bean.fetchRecord("select LESSER_SALE_PRICE_YN,SALE_PRICE_APPL_YN from st_acc_entity_param");
	
	//String external_po_yn			=	bean.checkForNull((String)	bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_ACC_ENTITY_PARAM_SELECT1"),new String[]{(String)session.getAttribute("ACC_ENTITY_ID")}).get("INTERFACE_TO_EXTERNAL_PO_YN"),"N");

	HashMap PO_Interface			=	bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_ACC_ENTITY_PARAM_SELECT1"),new String[]{(String)session.getAttribute("ACC_ENTITY_ID")});
	
	String po_interface_yn			=	bean.checkForNull((String)PO_Interface.get("PO_INTERFACE_YN"),"N");
	String external_po_yn			=	bean.checkForNull((String)PO_Interface.get("INTERFACE_TO_EXTERNAL_PO_YN"),"N");


	if(po_interface_yn.equals("Y")){
	external_po_yn = "N";
	}

	//Added by Rabbani #inc no:30127 on 09/01/11
	boolean flaggrn = bean.isCreateGRNApplicable(facilityid,"GRN");
	boolean grn_newfields_applicable = eCommon.Common.CommonBean.isSiteSpecific(con, "ST","ST_GRN_NEW_FIELDS");//added for MO-CRF-20165 START
	String mnaufactured_date_legend=""; //END 
	
	String  lesser_sale_price_yn	=bean.checkForNull((String)hmTemp.get("LESSER_SALE_PRICE_YN"),"N");
	String  sale_price_appl_yn		=bean.checkForNull((String)hmTemp.get("SALE_PRICE_APPL_YN"),"N");
	String  batch_id_applicable_yn	=bean.checkForNull((String)hmItemRecord.get("BATCH_ID_APPLICABLE_YN"),"N");
	String	trade_id_applicable_yn	=bean.checkForNull((String)hmItemRecord.get("TRADE_ID_APPLICABLE_YN"),"N");
	String	expiry_yn				=bean.checkForNull((String)hmItemRecord.get("EXPIRY_YN"),"N");	
	// default batch_id to be fetched from mm_parameter
	String disable_batch_id="";
	String disable_expiry_date="";
	String expiry_date="";
	String default_batch_id="";
	String default_trade_id="";
	String default_trade_id_new ="";
//	String date_legend="Expiry Dt";
	String date_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.expiryDate.label","common_labels");
	if(expiry_yn.equals("N")) {
		expiry_date = sys_date;
		disable_expiry_date="disabled";
//		date_legend="Receipt Dt";
		date_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.receiptdate.label","common_labels");
	}		
	if(grn_newfields_applicable){//MO-CRF-20165 
		mnaufactured_date_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.ManufacturedDate.label","st_labels"); 
	}
	if(trade_id_applicable_yn.equals("N")) {
		default_trade_id = (String)bean.getMm_parameter().get("DFLT_TRADE_ID");	
	}

	if(batch_id_applicable_yn.equals("N")) {
		disable_batch_id="disabled";
		default_batch_id = (String)bean.getMm_parameter().get("DFLT_BATCH_ID");	
	}
	else if(batch_id_applicable_yn.equals("E")) {
		if(expiry_yn.equals("Y")) {
			if (!expiry_date.equals("")) {
				default_batch_id = bean.getBatchIDFromExpiryDate(expiry_date);
			}
		}
		disable_batch_id="disabled";			
	}
	if(!index.equals("-1") && po_interface_yn.equals("N")){
		ArrayList alTmpExpRecords=(ArrayList)bean.getExpRecords(Integer.parseInt(index.trim()));
		hmTmpExpRecords=(HashMap)alTmpExpRecords.get(0);
	}

	/**
		 * @Name - Priya
		 * @Date - 07/06/2010
		 * @Inc# - 
		 * @Desc -  To get no of decimals for cost 
		 */
	int noOfDecimalsForCost=Integer.parseInt(bean.getNoOfDecimalsCost());

	boolean BarCodeApplicable	=	bean.isBarCodeApplicable(facilityid,"GRN");
	HashMap BarCodeRules		=	bean.getNewBarCodeRules(facilityid);
	String BarcodeRule			=   bean.checkForNull((String)BarCodeRules.get("BARCODE_GEN_RULE"));	
	String BarcodeRule_Disable="";
	if(BarcodeRule.equals("P") || BarcodeRule.equals("S"))
	BarcodeRule_Disable = "Readonly";
	
	String manufacturer_id	= bean.checkForNull(request.getParameter("manufacturer_id"));//added for MO-CRF-20165
	String supplier_id		= bean.checkForNull(request.getParameter("supplier_id"));
	String store_code =bean.getStore_code();

	String by_po = bean.checkForNull((String)request.getParameter("by_po"),"N");
 	String by_do,by_do_disable = "";
	
	String shelf_life	=	bean.checkForNull((String)bean.fetchRecord("select SHELF_LIFE from MM_ITEM_LANG_VW where ITEM_CODE = ? and LANGUAGE_ID= ?",new String[]{item_code,locale}).get("SHELF_LIFE"),"N");
	String shelf_life_no = "";
	String shelf_life_time = "";
	if(shelf_life != null && shelf_life.length() > 0){
		 shelf_life_time = shelf_life.substring(shelf_life.length() - 1);
		 shelf_life_no = shelf_life.substring(0,shelf_life.length() - 1);
	}
	String currentdate	   =	com.ehis.util.DateUtils.getCurrentDate("DMY",locale).toString();
	String shelfLifeDate	       = "";
	int s_life = 0 ;
	if(!shelf_life_no.equals(""))
		s_life = Integer.parseInt(shelf_life_no);
	if(shelf_life_time.equals("D")){
		shelfLifeDate	       =    com.ehis.util.DateUtils.plusDate(currentdate,"DMY",locale,s_life,"d");
	}else if(shelf_life_time.equals("M")){
		shelfLifeDate	       =    com.ehis.util.DateUtils.plusDate(currentdate,"DMY",locale,s_life,"M");
	}else if(shelf_life_time.equals("Y")){
		shelfLifeDate	       =    com.ehis.util.DateUtils.plusDate(currentdate,"DMY",locale,s_life,"Y");
	}
	int size = 10; //added for MO-CRF-20165 

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(date_legend));
            _bw.write(_wl_block11Bytes, _wl_block11);
if(grn_newfields_applicable){ 
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(mnaufactured_date_legend));
            _bw.write(_wl_block13Bytes, _wl_block13);
} 
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
if(BarCodeApplicable){
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
}
            _bw.write(_wl_block16Bytes, _wl_block16);
if(sale_price_appl_yn.equals("Y")){
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(bean.checkForNull(request.getParameter("gen_uom_desc"),bean.checkForNull((String)bean.getGenItemUOMDesc(item_code)))));
            _bw.write(_wl_block11Bytes, _wl_block11);
}
            _bw.write(_wl_block18Bytes, _wl_block18);
 
	//int size = 10;//added above for MO-CRF-20165 
	if(!index.equals("-1") && by_po.equals("N"))
		alExpRecords=bean.getExpRecords(Integer.parseInt(index.trim()));
	else if(!index.equals("-1") && by_po.equals("Y")){
		//alExpRecords=bean.getDoExpRecordsList(item_code);
		ArrayList alExpRecordsGroup=bean.getDoExpRecords(item_code);
 	if(alExpRecordsGroup != null){
		ArrayList alTempdetail = new ArrayList();
		for(int l=0;l<alExpRecordsGroup.size();l++){
			HashMap alExp = (HashMap)alExpRecordsGroup.get(l);
				HashMap hmTempdetail = new HashMap();
					hmTempdetail.put("grn_item_qty", (String)alExp.get("grn_item_qty"));             
					hmTempdetail.put("trade_id", (String)alExp.get("trade_id"));                 
					hmTempdetail.put("expiry_date_or_receipt_date", (String)alExp.get("expiry_date_or_receipt_date"));
					hmTempdetail.put("item_code", (String)alExp.get("item_code"));                
					hmTempdetail.put("store_code", (String)alExp.get("store_code"));               
					hmTempdetail.put("dist_store_code",(String) alExp.get("dist_store_code"));               
					hmTempdetail.put("batch_id", (String)alExp.get("batch_id"));                 
					hmTempdetail.put("do_no", (String)alExp.get("do_no"));                 
					hmTempdetail.put("po_no", (String)alExp.get("po_no"));                 
					hmTempdetail.put("do_srl_no", (String)alExp.get("do_srl_no"));                 
					hmTempdetail.put("dist_facility_id", (String)alExp.get("dist_facility_id"));                 
					hmTempdetail.put("sch_delv_date", (String)alExp.get("sch_delv_date"));      
					hmTempdetail.put("by_do", (String)alExp.get("by_do"));      
					hmTempdetail.put("manufactured_date", (String)alExp.get("manufactured_date"));//Added for MO-CRF-20165
					

			alTempdetail.add(hmTempdetail);
		}

 
		boolean check;

		for(int m=0;m<alTempdetail.size();m++){
			check = true;
			HashMap alTempGroup = (HashMap)alTempdetail.get(m);
					if(alExpRecords.size()>0){	
						for(int n=0;n<alExpRecords.size();n++){
							HashMap temp=(HashMap)alExpRecords.get(n);
							if(((String)alTempGroup.get("batch_id")).equals((String)temp.get("batch_id")) && ((String)alTempGroup.get("expiry_date_or_receipt_date")).equals((String)temp.get("expiry_date_or_receipt_date"))){
								//if(!(temp.containsKey("ADDED"))){
								float new_item_qty	= Float.parseFloat((String)alTempGroup.get("grn_item_qty"))+ Float.parseFloat((String)temp.get("grn_item_qty")) ; 
								temp.put("grn_item_qty",	""+new_item_qty);
								//temp.put("ADDED",	"YES");
							 	//}
								check = false;
							}
						}
					}else{
					alExpRecords.add(alTempGroup);
					check = false;
					}
					if(check){
					alExpRecords.add(alTempGroup);
					}
		}
	}
	}


 		HashMap hmExpRecords=new HashMap();
		
	 //Added by Rabbani #inc no:30127 on 09/01/11
			if(external_po_yn.equals("Y")){   
			   if(flaggrn){
				  size = 10;
			 }else{
				 if(alExpRecords.size()>10){
					size = 10;
				}else{
					size = alExpRecords.size();
				}
				}
			}
			else if(by_po.equals("Y")){
			size = 10;
			}
	/* if(external_po_yn.equals("Y")){
		if(alExpRecords.size()>10){
			size = 10;
		}else{
			size = alExpRecords.size();
		}
	} */
 for(int i=0;i<size;i++) {
		hmExpRecords=new HashMap();
		if(expiry_yn.equals("N")) {
			hmExpRecords.put("batch_id",default_batch_id);
			hmExpRecords.put("expiry_date_or_receipt_date",expiry_date);
		}
	//String exp_disp_date = bean.checkForNull((String)hmExpRecords.get("expiry_date_or_receipt_date"));
		if (i<alExpRecords.size()) 
			hmExpRecords	=	(HashMap)alExpRecords.get(i);

			  exp_disp_date	 = bean.checkForNull((String)hmExpRecords.get("expiry_date_or_receipt_date"));
			 manufactured_date = bean.checkForNull((String)hmExpRecords.get("manufactured_date"));//added for MO-CRF-20165 
			  

	  if(!locale.equals("en"))
		{
		  exp_disp_date = com.ehis.util.DateUtils.convertDate(exp_disp_date,"DMY","en",locale);
		}else
		{
		  exp_disp_date = com.ehis.util.DateUtils.convertDate(exp_disp_date,"DMY",locale,"en");
		}

			if(trade_id_applicable_yn.equals("Y")) {
			default_trade_id_new = bean.getTrade_id_List(item_code,(String)hmExpRecords.get("trade_id"));
			}
			else if(trade_id_applicable_yn.equals("N")) {
			default_trade_id_new = bean.getTrade_id_Default_List(bean.checkForNull((String)hmExpRecords.get("trade_id"),default_trade_id));
			}
		
		by_do = bean.checkForNull((String)hmExpRecords.get("by_do"),"N");
		if(by_do.equals("Y"))
			by_do_disable = "disabled";
		else
			by_do_disable = "";
			
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(i));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(disable_expiry_date));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(by_do_disable));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(exp_disp_date));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(facilityid));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(i));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(i));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(store_code));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(disable_expiry_date));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(by_do_disable));
            _bw.write(_wl_block41Bytes, _wl_block41);
if(grn_newfields_applicable){ 
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(i));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(manufactured_date));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(i));
            _bw.write(_wl_block48Bytes, _wl_block48);
 } 
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(i));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(bean.checkForNull((String)hmExpRecords.get("batch_id"))));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(disable_batch_id));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(by_do_disable));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(facilityid));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(i));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(i));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(store_code));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(i));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(i));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(facilityid));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(i));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(i));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(store_code));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(i));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(default_trade_id_new));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(i));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(facilityid));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(i));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(i));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(store_code));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(i));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(bean.getBin_location_code_List(bean.getStore_code(),bean.checkForNull((String)hmExpRecords.get("bin_location_code")),item_code)));
            _bw.write(_wl_block62Bytes, _wl_block62);

		String grn_item_qty				=	(bean.checkForNull((String)hmExpRecords.get("grn_item_qty")).equals(""))?"":bean.setNumber((String)hmExpRecords.get("grn_item_qty"),Integer.parseInt(no_deci));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(i));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(i));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(grn_item_qty));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(Integer.parseInt(no_deci)));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(by_do_disable));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(facilityid));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(i));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(i));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(store_code));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(i));
            _bw.write(_wl_block68Bytes, _wl_block68);
if(BarCodeApplicable){
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(i));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(i));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(bean.checkForNull((String)hmExpRecords.get("barcode_id"))));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(BarcodeRule_Disable));
            _bw.write(_wl_block73Bytes, _wl_block73);
}
	if(sale_price_appl_yn.equals("Y")){
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(i));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(i));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(noOfDecimalsForCost));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(facilityid));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(i));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(i));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(store_code));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(i));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(bean.checkForNull((String)hmExpRecords.get("sale_price"))));
            _bw.write(_wl_block79Bytes, _wl_block79);
}else{
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(i));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(i));
            _bw.write(_wl_block81Bytes, _wl_block81);
}
            _bw.write(_wl_block82Bytes, _wl_block82);
if(!BarCodeApplicable){
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(i));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(i));
            _bw.write(_wl_block81Bytes, _wl_block81);
}
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(bean.checkForNull((String)hmExpRecords.get("by_do"))));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(i));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(i));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(i));
            _bw.write(_wl_block88Bytes, _wl_block88);
 String fileRef				=	(bean.checkForNull((String)hmExpRecords.get("fileRef")).equals(""))?"":bean.checkForNull((String)hmExpRecords.get("fileRef"));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(i));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(fileRef));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(i));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(i));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(i));
            _bw.write(_wl_block95Bytes, _wl_block95);
	
		}
	
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(com.ehis.util.DateUtils.getCurrentDate("DMY",locale).toString()));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(bean.getStore_code()));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(bean.checkForNull(request.getParameter("gen_uom_desc"),bean.checkForNull((String)bean.getGenItemUOMDesc(item_code)))));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(batch_id_applicable_yn));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(sale_price_appl_yn));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(lesser_sale_price_yn));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(index));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(size));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(allow_deci_yn));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(no_deci));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(BarcodeRule));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(manufacturer_id));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(supplier_id));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(shelfLifeDate));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(formatedDate));
            _bw.write(_wl_block113Bytes, _wl_block113);

putObjectInBean("goodsReceivedNoteBean",bean,request);

            _bw.write(_wl_block114Bytes, _wl_block114);
 
		}
		catch(Exception e) {
			e.printStackTrace();
					}
finally{//MO-CRF-20165 
	if(con!=null){
		ConnectionManager.returnConnection(con,request); 
	}
}
	
            _bw.write(_wl_block4Bytes, _wl_block4);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BatchID.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.TradeName.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BinLocation.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Qty.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.BarCodeId.label", java.lang.String .class,"key"));
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
}
