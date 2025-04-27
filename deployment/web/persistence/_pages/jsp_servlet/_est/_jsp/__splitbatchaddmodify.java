package jsp_servlet._est._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eST.SplitBatchBean;
import eST.Common.*;
import eCommon.Common.*;
import java.util.ArrayList;
import java.util.HashMap;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __splitbatchaddmodify extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/est/jsp/SplitBatchAddModify.jsp", 1733595836670L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n\t<head>\n\t\t<title> </title>\n\t\t<!-- <link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/IeStyle.css\"></link> -->\n\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' \ntype=\'text/css\' ></link>\n\t\t<link rel=\"stylesheet\" type =\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<!-- <script language=\"javascript\" src=\"../../eCommon/js/messages.js\"></script> -->\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n\t<!-- <script language=\"javascript\" src=\"../../eST/js/StMessages.js\"></script> -->\n\t<script language=\"javascript\" src=\"../../eST/js/StCommon.js\"></script>\n\t<script language=\"javaScript\" src=\"../../eST/js/SplitBatch.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t<script language=\"Javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t<style type=\"text/css\">\n\t\tinput{\n/*\t\t\tfont-family:  verdana;*/\n\t\t\tfont-size: 10px;\n\n\t\t}\n\t\tselect{\n/*\t\t\tfont-family:  verdana;*/\n\t\t\tfont-size: 10px;\n\t\t}\n\t</style>\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n</head>\n<body>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<form name=formOpeningStockListDetail>\n\t<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' align=\"center\">\n\t<th>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</th>\n\t<th>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</th>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t<th>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</th><!-- Modified for TFS id:6938 -->\n\t<th>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</th>\n\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</th>\n\t ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t<th>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t<tr>\n\t\t<td class=\'fields\'>\n\t\t\t<input type=\'text\' name=\"expiry_date_or_receipt_date_";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" id=\"expiry_date_or_receipt_date_";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" disabled value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" size=10 maxlength=10 >\n\t\t\t<img  src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendarLocal(\'expiry_date_or_receipt_date_";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\');\"  disabled ></img>\n\t\t</td>\n\t\t<td class=\'fields\'>\n\t\t\t&nbsp;<input type=\'text\' name=\"batch_id_";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" id=\"batch_id_";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" class=\"UPPER\" value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" size=24 maxlength=20 disabled  >\n\t\t\t\t<input type=button name=\"batch_search_";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" id=\"batch_search_";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" class=\"button\" onClick=\"callGRNBatchSearch(";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =",\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\')\" value=\'?\' >\n\t\t</td>\n\t\t<td class=\'fields\'>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t<select name=\"trade_id_";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" id=\"trade_id_";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" disabled>";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</select>";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t</td> \n\t\t<td class=\'fields\'>\n\t\t\t<select name=\"bin_location_code_";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" id=\"bin_location_code_";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" disabled >\n\t\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t</select>\n\t\t</td>\n\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t<td  class=\'fields\'>&nbsp;&nbsp;<input type=text name=\"barcode_id_";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" id=\"barcode_id_";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" size=12 maxlength=20 class=\"NUMBER\" disabled value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\"></td>\n\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 =" \n\t\t<td  class=\'fields\'><input type=hidden name=\"barcode_id_";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t<td class=\'fields\'>\n\t\t\t<input type=\'text\' name=\"item_qty_";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" id=\"item_qty_";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\" value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\" class=\"NUMBER\" onKeyPress=\"return isValidNumber(this,event,7,";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 =");\" onblur=\"checkDoubleFormat(this); CallNewBarcodeString(\'SplitBatchBean\',\'eST.SplitBatchBean\',\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\',\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\',batch_id_";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 =",expiry_date_or_receipt_date_";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 =",trade_id_";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 =",bin_location_code_";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\',barcode_id_";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 =",item_qty_";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\');\" size=12 maxlength=12>\n\t\t</td>\n\t</tr>\n\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\n\t\t \n\t <tr>\n\t\t<td class=\'fields\'>\n\t\t\t<input type=\'text\' name=\"expiry_date_or_receipt_date_";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\" ";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="  value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\" size=10 maxlength=10 onBlur=\"javascript:getBatchIDFromExpiryDate(expiry_date_or_receipt_date_";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 =",";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\');CheckMaxYearForExpiryDate(this,\'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\');CallNewBarcodeString(\'SplitBatchBean\',\'eST.SplitBatchBean\',\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\');\">\n\t\t\t<img  src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendarLocal(\'expiry_date_or_receipt_date_";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\');\"  ";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 =" ></img>\n\t\t</td>\n\t\t \n\t\t<td class=\'fields\'>\n\t\t\t&nbsp;<input type=\'text\' name=\"batch_id_";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\" size=24 maxlength=20 ";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 =" onKeyPress=\"return  CheckForSpecialChars(event);\" onblur = \"CallNewBarcodeString(\'SplitBatchBean\',\'eST.SplitBatchBean\',\'";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\');\" >\n\t\t</td>\n\t\t<td class=\'fields\'>";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t\t</td> \n\t\t\n\t\t<td class=\'fields\'>\n\t\t\t<select name=\"bin_location_code_";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\" onchange=\"CallNewBarcodeString(\'SplitBatchBean\',\'eST.SplitBatchBean\',\'";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\');\" >\n\t\t\t\t";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t\t</select>\n\t\t</td>\n\t\t \n\t\t<!-- \t\t\n\t\t\t* @Name - Priya\n\t\t\t* @Date - 19/01/2010\n\t\t\t* @Inc# - 15496 (SRR20056-CRF-0537.2)\n\t\t\t* @Desc - For the field \'item_qty_\' No.of Decimals is passed to isValidNumber function and maxlength is increased to 12, onblur, checkdoubleformat is called.\t\t\t\n\t\t-->\n\t\t<td class=\'fields\'>\n\t\t\t<input type=\'text\' name=\"item_qty_";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\');\" size=12 maxlength=12>\n\t\t</td>\n\t\t";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\n\t\t\t<td  class=\'fields\'>&nbsp;&nbsp;<input type=text name=\"barcode_id_";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\" size=12 maxlength=20 class=\"NUMBER\" onKeyPress=\"return  CheckForSpecialChars(event);\"  onBlur=\"\"  ";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 =" value=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\t\t\n\t\t\n\t\t\n\t\t\n\t</tr>\n\t";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'fields\'>\n\t\t\t\t\t\t<input type=\'text\' name=\"expiry_date_or_receipt_date_";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\" value=\"\" size=10 maxlength=10 disabled><img src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendarLocal(\'expiry_date_or_receipt_date_";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\');\"  disabled ></img>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\'fields\'>\n\t\t\t\t\t\t&nbsp;<input type=\'text\' name=\"batch_id_";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\" class=\"UPPER\" value=\"\" size=24 maxlength=20 disabled  >\n\t\t\t\t\t\t<input type=button name=\"batch_search_";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\')\" value=\'?\' >\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\'fields\'>\n\t\t\t\t\t\t<select name=\"trade_id_";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\" value =\"\" disabled  >\n\t\t\t\t\t\t<option  value=\"\" >";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="</option>  </select>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\'fields\'>\n\t\t\t\t\t\t<select name=\"bin_location_code_";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\"  value=\"\"  disabled >\t\n\t\t\t\t\t<option  value=\"\" >";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="</option>  \n\t\t\t\t\t\t</select>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td  class=\'fields\'>&nbsp;&nbsp;<input type=text name=\"barcode_id_";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\" size=12 maxlength=20 class=\"NUMBER\"  disabled value=\"\"></td>\t\t\t\t\n\t\t\t\t\t<td class=\'fields\'>\n\t\t\t\t\t\t<input type=\'text\' name=\"item_qty_";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 =");\" size=12 maxlength=12>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\" size=10 maxlength=10 ";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="  onBlur=\"javascript:getBatchIDFromExpiryDate(expiry_date_or_receipt_date_";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\');\">\n\t\t\t<img src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendarLocal(\'expiry_date_or_receipt_date_";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 =" ></img>\n\t\t</td>\n\t\t<td class=\'fields\'>\n\t\t\t&nbsp;<input type=\'text\' name=\"batch_id_";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 =" onKeyPress=\"return  CheckForSpecialChars(event);\"  onchange=\"CallNewBarcodeString(\'SplitBatchBean\',\'eST.SplitBatchBean\',\'";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\')\">\n\t\t</td>\n\t\t<td class=\'fields\'>";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\n\t\t\t<select name=\"trade_id_";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\"   disabled >";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\t\t</select>";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\"  disabled >";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\n\t\t</td>\n\t\t<td class=\'fields\'>\n\t\t\t<select name=\"bin_location_code_";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\" onblur=\"CallNewBarcodeString(\'SplitBatchBean\',\'eST.SplitBatchBean\',\'";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\')\">\n\t\t\t\t";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\n\t\t\t</select>\n\t\t</td>\n\t\t<!-- \t\t\n\t\t\t* @Name - Priya\n\t\t\t* @Date - 19/01/2010\n\t\t\t* @Inc# - 15496 (SRR20056-CRF-0537.2)\n\t\t\t* @Desc - For the field \'item_qty_\' No.of Decimals is passed to isValidNumber function and maxlength is increased to 12, onblur, checkdoubleformat is called.\t\t\t\n\t\t-->\n\t\t<td class=\'fields\'>\n\t\t\t<input type=\'text\' name=\"item_qty_";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\');\" size=12 maxlength=12>\n\t\t</td>\n\t\t\n\t\t";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\" size=12 maxlength=20  class=\"NUMBER\"  onKeyPress=\"return  CheckForSpecialChars(event);\" onBlur=\"\"  value=\"\"></td>\n\t\t";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\n\t\t\n\t</tr>\n\t";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\" class=\"UPPER\" id=\"batch_id_";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\" value=\"\" size=24 maxlength=20 disabled  >\n\t\t\t\t\t\t<input type=button name=\"batch_search_";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\"  value=\"\"  disabled >\t\n\t\t\t\t\t <option  value=\"\" >";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="</option>   \n\t\t\t\t\t\t</select>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td  class=\'fields\'>&nbsp;&nbsp;<input type=text name=\"barcode_id_";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 =");\" onblur=\"checkDoubleFormat(this); \" size=12 maxlength=12>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\');\" ";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="><img src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendarLocal(\'expiry_date_or_receipt_date_";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 =" onKeyPress=\"return  CheckForSpecialChars(event);\" onblur=\"CallNewBarcodeString(\'SplitBatchBean\',\'eST.SplitBatchBean\',\'";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\" disabled  >";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\" disabled >";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\n\t\t\t\t";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\n\t\t</td>\n\t\t<td class=\'fields\'><select name=\"bin_location_code_";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\"  onblur=\"CallNewBarcodeString(\'SplitBatchBean\',\'eST.SplitBatchBean\',\'";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\');\" >\t";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\n\t\t\t</select>\n\t\t</td>\n\t\n\t\t<!-- \t\t\n\t\t\t* @Name - Priya\n\t\t\t* @Date - 19/01/2010\n\t\t\t* @Inc# - 15496 (SRR20056-CRF-0537.2)\n\t\t\t* @Desc - For the field \'item_qty_\' No.of Decimals is passed to isValidNumber function and maxlength is increased to 12, onblur, checkdoubleformat is called.\t\t\t\n\t\t-->\n\t\t<td class=\'fields\'>\n\t\t\t<input type=\'text\' name=\"item_qty_";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 =" value=\"\"></td>\n\t\t";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\n\t <tr>\n\t\t <td colspan=7>&nbsp;</td>\n\t </tr>\n\t";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\n\t<tr>\n\t\t<td colspan=3 class=WHITE></td>\n\t\t<td  colspan=2 class=WHITE><input type=button name=Modify value=\'";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\' class=button onclick=\"addToList(\'modify\');\"><input type=button name=Cancel value=\'";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\' class=button onclick=\"cancel_me();\"></td>\n\t</tr>\n\t";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\n\t<tr>\n\t\t<td colspan=3 class=WHITE></td>\n\t\t<td  colspan=2 class=WHITE><input type=button name=Add value=\'";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\' class=button onclick=\"addToList(\'add\');\"><input type=button name=Cancel value=\'";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\n</table>\n    <input type=\"hidden\" name=\"locale\" id=\"locale\" value=\"";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\">\n\t<input type=\"hidden\" name=\"sys_date\" id=\"sys_date\" value=\"";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\">\n\t<input type=\"hidden\" name=\"item_code\" id=\"item_code\" value=\"";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\">\n\t<input type=\"hidden\" name=\"item_desc\" id=\"item_desc\" value=\"";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\">\n\t<input type=\"hidden\" name=\"store_code\" id=\"store_code\" value=\"";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\">\n\t<input type=\"hidden\" name=\"doc_date\" id=\"doc_date\" value=\"";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\">\n\t<input type=\"hidden\" name=\"doc_type_code\" id=\"doc_type_code\" value=\"";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\">\n\t<input type=\"hidden\" name=\"doc_no\" id=\"doc_no\" value=\"";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\">\n\t<input type=\"hidden\" name=\"doc_ref\" id=\"doc_ref\" value=\"";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\">\n\t<input type=\"hidden\" name=\"trn_type\" id=\"trn_type\" value=\"";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\">\n\t<input type=\"hidden\" name=\"expiry_yn\" id=\"expiry_yn\" value=\"";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\">\n\t<input type=\"hidden\" name=\"totalRecords\" id=\"totalRecords\" value=\"10\">\n\t<input type=\"hidden\" name=\"batch_id_applicable_yn\" id=\"batch_id_applicable_yn\" value=\"";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\">\n\t<input type=\"hidden\" name=\"trade_id_applicable_yn\" id=\"trade_id_applicable_yn\" value=\"";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\">\n\t<input type=\"hidden\" name=\"uom\" id=\"uom\" value=\"";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\">\n\t<input type=\"hidden\" name=\"doc_srl_no\" id=\"doc_srl_no\" value=\"";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\">\n\t<input type=\"hidden\" name=\"SQL_ST_ITEM_LOOKUP\" id=\"SQL_ST_ITEM_LOOKUP\" value=\"";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\">\n\t<!-- \t\t\n\t\t\t* @Name - Priya\n\t\t\t* @Date - 18/01/2010\n\t\t\t* @Inc# - 15496 (SRR20056-CRF-0537.2)\n\t\t\t* @Desc - To get the value, whether decimals are allowed to this item or not.\t\t\t\n\t\t-->\n\t<input type=\"hidden\"\t\tname=\"dec_allowed_yn\" id=\"dec_allowed_yn\"\t\t\t value=\"";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\">\n\t<input type=\"hidden\"\t\tname=\"Barcode_app_yn\" id=\"Barcode_app_yn\"\t\t\t value=\"";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\">\n\t<input type=\"hidden\"\t\tname=\"Barcode_\" id=\"Barcode_\"\t\t\t        value=\"";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\">\n\t<input type=\"hidden\"\t\tname=\"index\" id=\"index\"\t\t\t        value=\"";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\">\n\t<input type=\"hidden\"        name=\"bin_location_code_chk\" id=\"bin_location_code_chk\"\t\tvalue=\"";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\">\n\t  \n\t  \n\t   <input type=\"hidden\"     name=\"BarcodeRule\" id=\"BarcodeRule\"                value=\"";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\">\n\t   <input type=\"hidden\"     name=\"facility_id\" id=\"facility_id\"                value=\"";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\">\n\t   <input type=\"hidden\"     name=\"no_of_batches_entered\" id=\"no_of_batches_entered\"\t\tvalue=\"\">\n\t    <input type=\"hidden\"    name=\"manufacturer_id\" id=\"manufacturer_id\"\t\t\t\t value=\"";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\" >\n\t    <input type=\"hidden\"    name=\"supplier_id\" id=\"supplier_id\"\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\" >\n\t   <input type=\"hidden\"     name=\"mrp\" id=\"mrp\"\t\t\t\t\t\t     value=\"";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\" >\n \t   <input type=\"hidden\"     name=\"restrict_GRN_batch\" id=\"restrict_GRN_batch\"\t\t\t\t\t\t     value=\"";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\" ><!-- Added against GHL-CRF-0446  -->\n \t   <input type=\"hidden\"     name=\"allow_zero_batches\" id=\"allow_zero_batches\"\t\t\t\t\t\t     value=\"";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\" ><!-- Added against GHL-CRF-0503  -->\n \t   \n\t\n\t\n\t<script>\n\t\tif(document.forms[0].trade_id_0.length==1 && !";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 =")\n\t\t{\n\t\t\talert(getMessage(\"TRADE_NOT_ASS_FOR_ITEM\",\"ST\"));\n\t\t\tparent.frameOpeningStockListHeader.location.reload();\n\t\t\tself.location.href=\"../../eCommon/html/blank.html\";\n\t\t}\n\t\t else if(document.forms[0].bin_location_code_0.length==1 && !";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 =")\n\t\t{\n\t\t\talert(getMessage(\"BIN_LOCN_NOT_ASS_FOR_STORE\",\"ST\"));\n\t\t\tparent.frameOpeningStockListHeader.location.reload();\n\t\t\tself.location.href=\"../../eCommon/html/blank.html\";\n\t\t}\n\t</script>\n</form>\n";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\n\t</body>\n</html>\n\t\t";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );
	
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
Date		            Edit History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------
1/2/2018				66368				Shazana 						  								GHL-CRF-0503 Split batch	
06/11/2019              IN0071697          B Haribabu                                  					Alpha incident
22/9/2021		TFS:22321	Shazana								GHL-SCF-1587
--------------------------------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
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

try{

	SplitBatchBean bean = (SplitBatchBean) getBeanObject( "splitBatchBean",  "eST.SplitBatchBean", request );
	bean.setLanguageId(locale);
	StHeaderBean beanHdr = (StHeaderBean) getBeanObject( "stHeaderBean", "eST.Common.StHeaderBean", request );
		beanHdr.setLanguageId(locale);
 	boolean site = bean.isSite_spec_yn();//Added against GHL-CRF-0446 
	ArrayList ALExp=new ArrayList();
	HashMap hashDtl=new HashMap();

	String sys_date=beanHdr.getSysDate();
	String facility_id	 =	beanHdr.getLoginFacilityId();  
	String trn_type      =  beanHdr.getTrn_type();  
	String index						=		bean.checkForNull(request.getParameter("index"),"-1"); //24/04/12
	String doc_srl_no = request.getParameter("doc_srl_no")==null?"-1":request.getParameter("doc_srl_no");
	System.out.println("index===add" +index);
	//17/04/12
	String store_code             =   "";
	String item_code              =   "";
	String item_desc              =   "";
	String expiry_yn              =   "";
	String expiry_date            =   "";
	String dflt_trade_id          =   "";
	String batch_id_applicable_yn =   "";
	String trade_id_applicable_yn =   "";
	String  manufacturer_id       =   "";
	String supplier_id             = "";
	String allow_zero_batches =""; //ADDED FOR GHL-CRF-0503 
	String mrp          = "";
	HashMap alTemp	=	new HashMap();
	
	String bar_code = request.getParameter("bar_code")==null?"":request.getParameter("bar_code");
 	String Barcode_yn = request.getParameter("Barcode_yn")==null?"":request.getParameter("Barcode_yn");
 	boolean BarCodeApplicable	=	bean.isBarCodeApplicable(facility_id,trn_type);  
	//System.out.println("BarCodeApplicable===57===>" +BarCodeApplicable);
	//Added against GHL-CRF-0446  starts
	String select_option= "";
	select_option=bean.getSTMessage(bean.getLanguageId(),"SELECT_OPTION","ST") ;
	String select_option_legend="------Select------";
	//Added against GHL-CRF-0446  ends
	if(Barcode_yn.equals("true")){
	if(doc_srl_no.equals("-1")){
	store_code = request.getParameter("store_code")==null?"":request.getParameter("store_code");
	//System.out.println("store_code===55===>" +store_code);
	String barcode_2d_applicable_yn = bean.barcode2DApplicable(); 
	ArrayList alBarCodeListDetails = new ArrayList(); 
	if(barcode_2d_applicable_yn.equals("Y")){
		 alBarCodeListDetails =bean.get2DBarcodeBacthes(store_code,bar_code);//Adding end for MMS-DM-CRF-0174.6
	}else{
        alBarCodeListDetails = bean.getBarCodeDetailArrayList1(bar_code,store_code);//GHL-SCF-1587
	}
	 // ArrayList alBarCodeListDetails =   bean.getBarCodeDetailArrayList1(bar_code,store_code);//modified for GHL-SCF-1587  
	 //System.out.println("alBarCodeListDetails===59===>" +alBarCodeListDetails);
	          
	    for (int t=0;t<alBarCodeListDetails.size();t++){
			          HashMap record	=	(HashMap)alBarCodeListDetails.get(t);
					  
					        item_code     =     (String)record.get("ITEM_CODE");
				      String batchid	   =	 (String)record.get("BATCH_ID");
				       expiry_date	   =	  (String)record.get("EXPIRY_DATE");
				      String binlocation   =	  (String)record.get("BIN_LOCATION_CODE");
				       dflt_trade_id    =	   (String)record.get("TRADE_ID");
					   
				ArrayList alItemDetails = bean.getItemDetailArrayList(locale,item_code,store_code);
				alTemp = (HashMap)alItemDetails.get(t);
				//System.out.println("alTemp= validate=>"+alTemp);
			 
				  item_desc              = (String)alTemp.get("ITEM_DESC") ;
				  expiry_yn                = (String)alTemp.get("EXPIRY_YN") ;
                  batch_id_applicable_yn   = (String)alTemp.get("BATCH_ID_APPLICABLE_YN") ; 
                  trade_id_applicable_yn   = (String)alTemp.get("TRADE_ID_APPLICABLE_YN") ;
                    manufacturer_id   = bean.checkForNull((String)alTemp.get("MANUFACTURER_ID")) ;
				// System.out.println("manufacturer_id:" +manufacturer_id);
				 	  supplier_id = bean.checkForNull((String)bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_BATCH_CONTROL_SELECT_FOR_BAR_CODE_RULE"),new String[]{item_code,batchid,expiry_date}).get("SUPP_CODE"));
				// System.out.println("supplier_id:" +supplier_id);
				  mrp     =  bean.checkForNull((String)bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_ITEM_BATCH_LEVEL_SALES_PRICE"),new String[]{facility_id,"I",item_code,dflt_trade_id,batchid}).get("MRP_PRICE"));
				 }
				 }else{
				  store_code=beanHdr.getStore_code();
	 item_code = request.getParameter("item_code")==null?"":request.getParameter("item_code");
	 dflt_trade_id=bean.getDefault_trade_id();
	// if(trade_id_applicable_yn.equals("Y")){
	 dflt_trade_id=bean.checkForNull(request.getParameter("trade_id"));
	 //}

	 if(dflt_trade_id.equals("")){
	 dflt_trade_id=bean.getDefault_trade_id();	 
	 }

	  batch_id_applicable_yn = 	bean.checkForNull(request.getParameter("batch_id_applicable_yn"));
	  trade_id_applicable_yn = bean.checkForNull(request.getParameter("trade_id_applicable_yn"));
	  item_desc = request.getParameter("item_desc")==null?"":request.getParameter("item_desc");
	  expiry_yn = bean.checkForNull(request.getParameter("expiry_yn"));
	  expiry_date=request.getParameter("expiry_date")==null?"":request.getParameter("expiry_date"); //modified by ganga
	   mrp     =  bean.checkForNull((String)bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_ITEM_BATCH_LEVEL_SALES_PRICE"),new String[]{facility_id,"I",item_code,dflt_trade_id, bean.checkForNull((String)bean.getDefault_batch_id())}).get("MRP_PRICE"));
	  
	  
	}
}else{
	 store_code=beanHdr.getStore_code();
	 item_code = request.getParameter("item_code")==null?"":request.getParameter("item_code");
	 dflt_trade_id=bean.getDefault_trade_id();
	// if(trade_id_applicable_yn.equals("Y")){
	 dflt_trade_id=bean.checkForNull(request.getParameter("trade_id"));
	 //}

	 if(dflt_trade_id.equals("")){
	 dflt_trade_id=bean.getDefault_trade_id();	 
	 }

	  batch_id_applicable_yn = 	bean.checkForNull(request.getParameter("batch_id_applicable_yn"));
	  trade_id_applicable_yn = bean.checkForNull(request.getParameter("trade_id_applicable_yn"));
	  item_desc = request.getParameter("item_desc")==null?"":request.getParameter("item_desc");
	  expiry_yn = bean.checkForNull(request.getParameter("expiry_yn"));
	  expiry_date=request.getParameter("expiry_date")==null?"":request.getParameter("expiry_date"); //modified by ganga
	}
	
	
	String doc_date=beanHdr.getDoc_date();
	String doc_type_code=beanHdr.getDoc_type_code();
	String doc_no=beanHdr.getDoc_no();
	String doc_ref=beanHdr.getDoc_ref();
	//String trn_type=beanHdr.getTrn_type();
	bean.setOpeningStockHeaderBean(beanHdr);
	String uom = bean.checkForNull(request.getParameter("uom"));
	
	String disable_batch_id="";	
	String disable_expiry_date="";
	String default_batch_id="";	
	String default_bin_location_code="";
	
	//String expiry_date=request.getParameter("expiry_date");
	//commentted for IN:0071697 start	
// 	if(!locale.equals("en"))
// 	{
//        expiry_date=com.ehis.util.DateUtils.convertDate(expiry_date,"DMY","en",locale);
// 	}
//commentted for IN:0071697 end
	//String date_legend="Expiry Dt";
	String date_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.expiryDate.label","common_labels");

	

	//int x=0;
	int y=0;
	/*The below line was commented By Dinesh T 1/20/2011 for the CRF No 113*/
	//expiry_date=sys_date;
	default_bin_location_code=bean.getDefaultBinLocationCode(item_code);
	//System.out.println("default_bin_location_code===100===>" +default_bin_location_code);
	
	//System.out.println("dflt_trade_id===102===>" +dflt_trade_id);
	if(!locale.equals("en"))
	{
      expiry_date=com.ehis.util.DateUtils.convertDate(expiry_date,"DMY","en",locale);
	}
	if(expiry_yn.equals("N")) {
		expiry_date = doc_date;
		disable_expiry_date="disabled";
		//date_legend="Receipt Dt";
		date_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.receiptdate.label","common_labels");
	}

	/*if(trade_id_applicable_yn.equals("N")) {
		default_trade_id = (String)bean.getDefault_trade_id();
	}*/
	//System.out.println("batch_id_applicable_yn======>" +batch_id_applicable_yn);

	if(batch_id_applicable_yn.equals("N")) {
		disable_batch_id="disabled";
		default_batch_id = (String)bean.getDefault_batch_id();
	}	
	else if(batch_id_applicable_yn.equals("E")) {
		disable_batch_id="disabled";		
		if(expiry_yn.equals("N")) {
			//default_batch_id = bean.getBatchIDFromExpiryDate(expiry_date);
			default_batch_id = "";
		}
		else{
			expiry_date="";
			default_batch_id="";
		}
	}

	

	/**
	* @Name - Priya
	* @Date - 13/01/2010
	* @Inc# - 15496 (SRR20056-CRF-0537.2)
	* @Desc - No of Decimal is brought here in order to pass a value to setNumber Function and isValidNumber Function.
	*/
	int no_of_decimals = bean.getNoOfDecimals();
	
	//System.out.println("dflt_trade_id===178===>" +dflt_trade_id);
	//System.out.println("trade_id_applicable_yn===179===>" +trade_id_applicable_yn);
	
	
	//09/05/12
	      HashMap BarCodeRules = bean.getNewBarCodeRules(facility_id);
	      // System.out.println("BarCodeRules ===PRT==>"+BarCodeRules);
			String BarcodeRule = bean.checkForNull((String)BarCodeRules.get("BARCODE_GEN_RULE"));
              System.out.println("BarcodeRule ===PRT==>"+BarcodeRule);			
			String BarcodeRule_Disable = "";
			if(BarcodeRule.equals("P") ||BarcodeRule.equals("S") )
			BarcodeRule_Disable = "ReadOnly";
	boolean restrict_GRN_batch = bean.getRestrictSplitGRN();//Added against GHL-CRF-0446 
	System.out.println("restrict_GRN_batch----->"+restrict_GRN_batch);
	/*Added for GHL-CRF-0503 split batch START*/
	allow_zero_batches = bean.getAllowZeroBatchGRN();
	/*Added for GHL-CRF-0503 split batch END*/

            _bw.write(_wl_block9Bytes, _wl_block9);

	//expiry_yn="Y";

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(date_legend));
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
if(restrict_GRN_batch){ //Added against GHL-CRF-0446 
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
}
  else{
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
if(BarCodeApplicable){
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
}
}
            _bw.write(_wl_block18Bytes, _wl_block18);

	if(doc_srl_no!="-1") {
		
		/**
			* @Name - Priya
			* @Date - 19/01/2010
			* @Inc# - 15496 (SRR20056-CRF-0537.2)
			* @Desc - Making No.of Decimals to zero if Decimal is not allowed by the item.
			*/
		if((bean.getAllowDecimalsYN(item_code)).equals("N")){
			no_of_decimals = 0;
		}
		/**END**/
		
		 ALExp=bean.getExpList(doc_srl_no);
		 System.out.println("ALExp ==209=>" +ALExp);
		/*if(ALExp.size()!=10) {
			x=10-ALExp.size();
		}*/
			 for(int i=0;i<ALExp.size();i++) {
			 hashDtl=(HashMap)ALExp.get(i);
			 System.out.println("hashDtl ==215=>" +hashDtl);
			 			// System.out.println("hashDtl ==215=>" +hashDtl);
						// System.out.println("store_code ==215=>" +store_code);
						// System.out.println("item_code ==215=>" +item_code);
	if(restrict_GRN_batch){//Added against GHL-CRF-0446  starts
 	 
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(i));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(bean.checkForNull((String)hashDtl.get("expiry_date_or_receipt_date"),expiry_date)));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf((String)hashDtl.get("batch_id")));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(i));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block30Bytes, _wl_block30);
if(trade_id_applicable_yn.equals("Y")){
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(bean.getTradeList(item_code,(String)hashDtl.get("trade_id"))));
            _bw.write(_wl_block34Bytes, _wl_block34);
}else{
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(bean.getTradeListDflt((String)hashDtl.get("trade_id"))));
            _bw.write(_wl_block34Bytes, _wl_block34);
}
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(bean.getSTITBin_location_code_List(store_code,item_code,(String)hashDtl.get("bin_location_code"),locale)));
            _bw.write(_wl_block38Bytes, _wl_block38);
if(BarCodeApplicable){
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(bean.checkForNull((String)hashDtl.get("barcode_id"))));
            _bw.write(_wl_block42Bytes, _wl_block42);
}else{
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(i));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i));
            _bw.write(_wl_block42Bytes, _wl_block42);
}
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(bean.setNumber(bean.checkForNull((String)hashDtl.get("item_qty"),"0"),no_of_decimals)));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(no_of_decimals));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(i));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(i));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(store_code));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(i));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(mrp));
            _bw.write(_wl_block56Bytes, _wl_block56);
}	else{//Added against GHL-CRF-0446 ends
 	 
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(i));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(i));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(disable_expiry_date));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(bean.checkForNull((String)hashDtl.get("expiry_date_or_receipt_date"),expiry_date)));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(i));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(i));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(batch_id_applicable_yn));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(i));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(i));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(store_code));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(i));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(mrp));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(i));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(disable_expiry_date));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf((String)hashDtl.get("batch_id")));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(disable_batch_id));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(i));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(i));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(store_code));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(i));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(mrp));
            _bw.write(_wl_block69Bytes, _wl_block69);
if(trade_id_applicable_yn.equals("Y")){
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(bean.getTradeList(item_code,(String)hashDtl.get("trade_id"))));
            _bw.write(_wl_block34Bytes, _wl_block34);
}else{
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(bean.getTradeListDflt((String)hashDtl.get("trade_id"))));
            _bw.write(_wl_block34Bytes, _wl_block34);
}
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(i));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(i));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(store_code));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(i));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(mrp));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(bean.getSTITBin_location_code_List(store_code,item_code,(String)hashDtl.get("bin_location_code"),locale)));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(bean.setNumber(bean.checkForNull((String)hashDtl.get("item_qty"),"0"),no_of_decimals)));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(no_of_decimals));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(i));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(i));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(store_code));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(i));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(mrp));
            _bw.write(_wl_block74Bytes, _wl_block74);
if(BarCodeApplicable){
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(i));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(BarcodeRule_Disable));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(bean.checkForNull((String)hashDtl.get("barcode_id"))));
            _bw.write(_wl_block42Bytes, _wl_block42);
}else{
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(i));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i));
            _bw.write(_wl_block42Bytes, _wl_block42);
}
            _bw.write(_wl_block78Bytes, _wl_block78);
	
	}
				y=i;
		}
		y++;
		ALExp.clear();
		for(int j=y;j<10;j++) {
		dflt_trade_id=(String)hashDtl.get("trade_id");	
		if(restrict_GRN_batch){//Added against GHL-CRF-0446 starts
				
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(j));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(j));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(j));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(j));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(j));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(j));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(j));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(j));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(j));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(j));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(select_option_legend ));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(j));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(j));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(select_option_legend ));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(j));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(j));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(j));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(j));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(no_of_decimals));
            _bw.write(_wl_block89Bytes, _wl_block89);

		}
		else{//Added against GHL-CRF-0446 ends
	
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(j));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(j));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(expiry_date));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(disable_expiry_date));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(j));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(j));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(batch_id_applicable_yn));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(j));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(j));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(j));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(j));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(store_code));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(j));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(j));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(mrp));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(j));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(disable_expiry_date));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(j));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(j));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(default_batch_id));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(disable_batch_id));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(j));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(j));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(j));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(j));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(store_code));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(j));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(j));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(mrp));
            _bw.write(_wl_block95Bytes, _wl_block95);
if(trade_id_applicable_yn.equals("Y")){
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(j));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(j));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(bean.getTradeList(item_code,dflt_trade_id)));
            _bw.write(_wl_block98Bytes, _wl_block98);
}else{
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(j));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(j));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(bean.getTradeListDflt(dflt_trade_id)));
            _bw.write(_wl_block34Bytes, _wl_block34);
}
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(j));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(j));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(j));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(j));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(j));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(j));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(store_code));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(j));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(j));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(mrp));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(bean.getSTITBin_location_code_List(store_code,item_code,default_bin_location_code,locale)));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(j));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(j));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(no_of_decimals));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(j));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(j));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(j));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(j));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(store_code));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(j));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(j));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(mrp));
            _bw.write(_wl_block104Bytes, _wl_block104);
if(BarCodeApplicable){
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(j));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(j));
            _bw.write(_wl_block105Bytes, _wl_block105);
}else{
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(j));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(j));
            _bw.write(_wl_block42Bytes, _wl_block42);
}
            _bw.write(_wl_block106Bytes, _wl_block106);

		}
	}
	}
	else {
		for(int i=0;i<10;i++) {	
			if(restrict_GRN_batch){//Added against GHL-CRF-0446 starts 
				
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(i));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(i));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(i));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(i));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(i));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(i));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(select_option_legend ));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(select_option_legend ));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(i));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(no_of_decimals));
            _bw.write(_wl_block111Bytes, _wl_block111);

			}
			else{//Added against GHL-CRF-0446 ends
	
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(i));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(i));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(expiry_date));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(i));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(i));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(batch_id_applicable_yn));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(i));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(i));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(store_code));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(i));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(mrp));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(disable_expiry_date));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(i));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(disable_expiry_date));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(default_batch_id));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(disable_batch_id));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(i));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(i));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(store_code));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(i));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(mrp));
            _bw.write(_wl_block69Bytes, _wl_block69);
if(trade_id_applicable_yn.equals("Y")){
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(bean.getTradeList(item_code,dflt_trade_id)));
            _bw.write(_wl_block34Bytes, _wl_block34);
}else{
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(bean.getTradeListDflt(dflt_trade_id)));
            _bw.write(_wl_block34Bytes, _wl_block34);
}
            _bw.write(_wl_block117Bytes, _wl_block117);
 System.out.println("fr"+bean.getTradeListDflt(dflt_trade_id)); 
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(i));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(i));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(store_code));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(i));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(mrp));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(bean.getSTITBin_location_code_List(store_code,item_code,default_bin_location_code,locale)));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(no_of_decimals));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(i));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(i));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(store_code));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(i));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(mrp));
            _bw.write(_wl_block74Bytes, _wl_block74);
if(BarCodeApplicable){
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(i));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(BarcodeRule_Disable));
            _bw.write(_wl_block122Bytes, _wl_block122);
}else{
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(i));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i));
            _bw.write(_wl_block42Bytes, _wl_block42);
}
            _bw.write(_wl_block106Bytes, _wl_block106);

		}
		}
	}
	
            _bw.write(_wl_block123Bytes, _wl_block123);
	if(doc_srl_no!="-1") {
            _bw.write(_wl_block124Bytes, _wl_block124);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block125Bytes, _wl_block125);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block126Bytes, _wl_block126);
}else{
            _bw.write(_wl_block127Bytes, _wl_block127);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block128Bytes, _wl_block128);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block126Bytes, _wl_block126);
}
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(sys_date));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(item_desc));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(store_code));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(doc_date));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(doc_type_code));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(doc_no));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(doc_ref));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(trn_type));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(expiry_yn));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(batch_id_applicable_yn));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(trade_id_applicable_yn));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(uom));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf((request.getParameter("doc_srl_no"))==null?"-1":request.getParameter("doc_srl_no")));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(bean.getStRepositoryValue("SQL_ST_ITEM_LOOKUP")));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(bean.getAllowDecimalsYN(item_code)));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(BarCodeApplicable));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(bar_code));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(index));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(default_bin_location_code));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(BarcodeRule));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(manufacturer_id));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(supplier_id));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(mrp));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(restrict_GRN_batch));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(allow_zero_batches));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(site));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(site));
            _bw.write(_wl_block159Bytes, _wl_block159);

putObjectInBean("splitBatchBean",bean,request);
putObjectInBean("stHeaderBean",beanHdr,request);

            _bw.write(_wl_block160Bytes, _wl_block160);
}
	catch(Exception e)
	{
e.printStackTrace();
}
            _bw.write(_wl_block3Bytes, _wl_block3);
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.BarCodeId.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Qty.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Qty.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.BarCodeId.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Modify.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.cancel.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Add.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.cancel.label", java.lang.String .class,"key"));
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
