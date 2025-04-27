package jsp_servlet._epo._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import ePO.QuotationDetailBean;
import ePO.QuotationBean;
import ePO.Common.*;
import eCommon.Common.*;
import java.util.*;
import java.sql.*;
import webbeans.eCommon.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __quotationdetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ePO/jsp/QuotationDetails.jsp", 1709121597638L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' ></link>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../ePO/js/PoCommon.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../ePO/js/PoTransaction.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../ePO/js/Quotation.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/CommonResult.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t <script>\n        function_id = \"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"\n\t\t </script>\n</head>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<body onLoad=\"FocusFirstElement();onLoadCurrCode(\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\',\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\');calculateDisAmount();\">\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n<body onLoad=\"onLoadCurrCode(\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\n\t<form name=\"formQuotationDetail\" id=\"formQuotationDetail\">\n\t\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" >\n\t\t\t<tr>\n\t\t\t\t<th colspan=2>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</th>\n\t\t\t</tr>\n\t\t\t<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>\n\t\t\t<tr>\n\t\t\t\t<td class=\"label\" colspan=2>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&nbsp;&nbsp;\n\t\t\t\t\t<input type=\"text\" name=\"item_desc\" id=\"item_desc\" size=\"30\" maxlength=\"30\"  value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" onBlur=\"\">\n\t\t\t\t\t<input type=\"button\" value=\"?\" class=\"button\" onClick=\"return searchCodeItem(item_desc);\" ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="   >&nbsp;<img src=\"../../eCommon/images/mandatory.gif\" align=center></img>&nbsp;&nbsp;\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\n\t\t\t\n\t\t\t<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>\n\t\t<tr>\n\t\t\t\t<td class=\"label\" >\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n\t\t\t\t<td class=\"field\" >\n\t\t\t\t\n\t\t\t\t<input type=\"text\" name=\"quotation_qty\" id=\"quotation_qty\"  class=NUMBER size=\"10\" maxlength=\"8\"  value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" onKeyPress=\"return isValidInteger();\" onBlur=\"checkIntegerFormat(this);checkUOMConvFactor();calculateValue();calculateDiscount();\">";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t\n\t\t\t<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>\n\t\t\t<tr>\n\t\t\t\t<td class=\"label\" >\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\n\t\t\t\t<td class=\"field\" >\t\n\t\t\t\t\t<select name=\'quotation_uom\' id=\'quotation_uom\' onchange=\"getUOMDesc(this);\" onBlur=\"getUOMDesc(this);  checkUOMConvFactor();\" >";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</select>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t\n\t\t\t<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>\n\t\t\t<tr>\n\t\t\t\t<td class=\"label\" >\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\n\t\t\t\t<td class=\"field\" >\t<input type=\"text\" name=\"quotation_price\" id=\"quotation_price\" class=NUMBER size=\"12\" maxlength=\"12\"  value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" onKeyPress=\"return isValidNumber(this,event,7,3);isValidInteger();\" onBlur=\"checkUOMConvFactor();calculateValue();calculateDiscount();\" >\n\t\t\t\t<label id=\'currency_label_1\' class=\"label\" >&nbsp;<B></B></label>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t\n\t\t\t\n\t\t\t<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>\n\t\t\t<tr>\n\t\t\t\t<td class=\"label\" >\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</td>\n\t\t\t\t<td class=\"field\" > <input type=\"text\" class=NUMBER name=\"tot_value\" id=\"tot_value\" size=\"15\" maxlength=\"15\"  value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" onKeyPress=\"return isValidNumber(this,event,10,3);isValidInteger();\" onBlur=\"calculateDiscount();\">\n\t\t\t\t<label id=\'currency_label_2\' class=\"label\" >&nbsp;<B></B></label>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>\n\t\t\t<tr>\n\t\t\t\t<td class=\"label\"> ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</td>\n\t\t\t\t<td class=\"field\" > \n\t\t\t\t\t<select name=\"dis_type\" id=\"dis_type\" onchange=\"calculateDiscount();perChange(this);\">\n\t\t\t\t\t\t<option value=\"P\" ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =">Percentage</option>\n\t\t\t\t\t\t<option value=\"A\" ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =">Amount</option>\n\t\t\t\t\t</select>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>\n\t\t\t<tr>\n\t\t\t\t<td class=\"label\">\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</td>\n\t\t\t\t<td class=\"field\" > \n\t\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\t\t<input type=\"text\" class=NUMBER name=\"dis_value\" id=\"dis_value\" size=\"10\" maxlength=\"10\"  value=\"0\" onKeyPress=\"return isValidNumber(this,event,5,3);return isValidInteger();\" onBlur=\"calculateDiscount();\">\n\t\t\t\t\t\t<span id=\"PerHide\" style=visibility:visible>\n\t\t\t\t\t\t\t<input type=\"text\" class=NUMBER name=\"dis_amt\" id=\"dis_amt\" size=\"10\" maxlength=\"10\"  value=\"0\" onKeyPress=\"return isValidNumber(this,event,5,3);return isValidInteger();\" onBlur=\"calculateDiscount();\" disabled>\n\t\t\t\t\t\t</span>\n\t\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t\t<input type=\"text\" class=NUMBER name=\"dis_value\" id=\"dis_value\" size=\"10\" maxlength=\"10\"  value=\"\" onKeyPress=\"return isValidNumber(this,event,5,3);return isValidInteger();\" onBlur=\"calculateDiscount();\">\n\t\t\t\t\t\t<span id=\"PerHide\" style=visibility:";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =">\n\t\t\t\t\t\t\t<input type=\"text\" class=NUMBER name=\"dis_amt\" id=\"dis_amt\" size=\"10\" maxlength=\"10\"  value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" onKeyPress=\"return isValidNumber(this,event,5,3);return isValidInteger();\" onBlur=\"calculateDiscount();calculateDisAmount()\" disabled>\n\t\t\t\t\t\t</span>\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\t\t<label id=\'currency_label_3\' class=\"label\" >&nbsp;<B></B></label>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t\n\t\t\t<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>\n\t\t\t<tr>\n\t\t\t\t<td class=\"label\"> ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</td>\n\t\t\t\t<td class=\"field\" > <input type=\"text\"  class=NUMBER name=\"net_amount\" id=\"net_amount\" size=\"15\" maxlength=\"15\"  value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" onKeyPress=\"return isValidNumber(this,event,10,3);isValidInteger();\" onBlur=\"\">\n\t\t\t\t\t<label id=\'currency_label_4\' class=\"label\" >&nbsp;<B></B></label>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t\n\t\t\t<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>\n\t\t\t<tr>\n\t\t\t\t<td class=\"label\"> ";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</td>\n\t\t\t\t<td class=\"field\" > \n\t\t\t\t\t<select name=\"item_status\" id=\"item_status\" onchange=\"\">\n\t\t\t\t\t\t<option value=\"PD\" ";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 =" >Pending</option>\n\t\t\t\t\t\t<option value=\"RD\" ";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 =">Rejected</option>\n\t\t\t\t\t\t<option value=\"SD\" ";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 =">Selected</option>\n\t\t\t\t\t</select>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t\n\t\t\t\n\t\t\t<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>\n\t\t\t<tr>\n\t\t\t\t<td colspan=2 class=\"label\" id=\"batch_td\" ><label onMouseOver=\"changeCursor(this);\"  class=\"label\" onClick = \"MoreItemDetails(\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\');\"><font class=\'HYPERLINK\'>";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</font></label></td> \n\t\t\t\t\n\t\t\t</tr>\n\t\t\t\n\t\t\t<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>\n\t\t\t<tr>\n\t\t\t\t<td colspan=2 class=\"label\" id=\"batch_td\" ><label onMouseOver=\"changeCursor(this);\"  class=\"label\" onClick = \"SelectionCriteria(\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</font></label></td> \n\t\t\t\t\n\t\t\t</tr>\n\t\t\t\n\t\t\t<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>\n\t\t\t<tr>\n\t\t\t\t<td colspan=2 class=\"label\" id=\"batch_td\" ><label onMouseOver=\"changeCursor(this);\"  class=\"label\" onClick = \"EvaluationFactor(\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</font></label></td> \n\t\t\t\t\n\t\t\t</tr>\n\t\t\t\n\t\t\t\n\t\t\t\n\t\t\t\n\t\t\t\n\t\t\t<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>\n\t\t\t<tr>\n\t\t\t\t<td colspan=2 align=right>\n\t\t\t\t\t<input type=\"button\" class=\"button\" name=\"add\" id=\"add\" value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 =" onClick=\"addItemRecord();\">&nbsp;\n\t\t\t\t\t<input type=\"button\" class=\"button\" name=\"cancel\" id=\"cancel\" value=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\' onClick=\"resetDetail();\"></td>\n\t\t\t</tr>\n\t\t</table>\n\t\n\t\n\t\t<input type=\"hidden\"\t\tname=\"mode\" id=\"mode\"\t\t\t\t\t\t value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\">\n\t\t<input type=\"hidden\"\t\tname=\"request_by_pu\" id=\"request_by_pu\"\t\t\t value=\"\">\n\t\t<input type=\"hidden\"\t\tname=\"request_on_supp\" id=\"request_on_supp\"\t\t\t value=\"\">\n\t\t<input type=\"hidden\"\t\tname=\"item_code\" id=\"item_code\"\t\t\t\t value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\">\n\t\t<input type=\"hidden\"\t\tname=\"srl_no\" id=\"srl_no\"\t\t\t\t\t value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\">\n\t\t<input type=\"hidden\"\t\tname=\"bean_id\" id=\"bean_id\"\t\t\t\t\t value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\">\n\t\t<input type=\"hidden\"\t\tname=\"bean_name\" id=\"bean_name\"\t\t\t\t value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">\n\t\t<input type=\"hidden\"\t\tname=\"function_id\" id=\"function_id\"\t\t\t\t value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\">\n\t\t<input type=\"hidden\"\t\tname=\"editing\" id=\"editing\"\t\t\t\t\t value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\">\n\t\t<input type=\"hidden\"\t\tname=\"check_box_status\" id=\"check_box_status\"\t\t\t value=\"Y\">\n\t\t<input type=\"hidden\"\t\tname=\"store_name\" id=\"store_name\"\t\t\t\t value=\"\">\n\t\t<input type=\"hidden\"\t\tname=\"uom\" id=\"uom\"\t\t\t\t\t     value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\">\n\t\t<input type=\"hidden\"\t\tname=\"temp_uom\" id=\"temp_uom\"\t\t\t\t\t value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\">\n\t\t<input type=\"hidden\"\t\tname=\"temp_uom_code\" id=\"temp_uom_code\"\t\t\t value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\">\n\t\t<input type=\"hidden\"\t\tname=\"SQL_MM_ITEM_LOOKUP\" id=\"SQL_MM_ITEM_LOOKUP\"\t\t value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\">\n\t\t<input type=\"hidden\"\t\tname=\"p_language_id\" id=\"p_language_id\"\t\t\t value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\">\n\t\t<input type=\"hidden\"\t\tname=\"conv_fact\" id=\"conv_fact\"\t\t\t\t value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\">\n\t\t<input type=\"hidden\"\t\tname=\"item_remarks\" id=\"item_remarks\"\t\t\t\t value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\">\n\t\t<input type=\"hidden\"\t\tname=\"order_qty1\" id=\"order_qty1\"\t\t\t\t value=\"\">\n\t\t<input type=\"hidden\"\t\tname=\"del_due_dt1\" id=\"del_due_dt1\"\t\t\t\t value=\"\">\n\t\t<input type=\"hidden\"\t\tname=\"itemCode_reqNO\" id=\"itemCode_reqNO\"\t\t\t value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\">\n\t\t<input type=\"hidden\"\t\tname=\"req_store\" id=\"req_store\"\t\t\t\t value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\">\n\t\t<input type=\"hidden\"\t\tname=\"facility_id\" id=\"facility_id\"\t\t\t\t value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\">\n\t\t<input type=\"hidden\"\t\tname=\"po_no\" id=\"po_no\"\t\t\t\t     value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\">\n\t\t<input type=\"hidden\"\t\tname=\"po_srl_no\" id=\"po_srl_no\"\t\t\t\t value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\">\n\t\t<input type=\"hidden\"\t\tname=\"delv_srl_no\" id=\"delv_srl_no\"\t\t\t\t value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\">\n\t\t<input type=\"hidden\"\t\tname=\"bal_budget\" id=\"bal_budget\"\t\t\t\t value=\"\">\n\t\t<input type=\"hidden\"\t\tname=\"rejection_remarks\" id=\"rejection_remarks\"\t\t value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\">\n\t\t<input type=\"hidden\"\t\tname=\"temp_delv_uom_desc\" id=\"temp_delv_uom_desc\"\t\t value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\">\n\t\t<input type=\"hidden\"\t\tname=\"temp_delv_uom_code\" id=\"temp_delv_uom_code\"\t\t value=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\">\n\t\t<input type=\"hidden\"\t\tname=\"delv_date\" id=\"delv_date\"\t\t \t\t value=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\">\n\t\t<input type=\"hidden\"\t\tname=\"order_qty\" id=\"order_qty\"\t\t \t\t value=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\">\n\t\t<input type=\"hidden\"\t\tname=\"request_no\" id=\"request_no\"\t\t \t\t value=\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\">\n\t\t\n\t\t\n\t\t\t\t\n\t</form>\n\t";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	String sStyle			= (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf( request.getParameter( "function_id" ) ));
            _bw.write(_wl_block8Bytes, _wl_block8);

	QuotationDetailBean requestDetail;
	String bean_id						=			"quotationBean";
	String bean_name					=			"ePO.QuotationBean";
	QuotationBean bean				=			(QuotationBean) getBeanObject(bean_id, bean_name,request );  
	bean.setLanguageId(locale);
	boolean editMode					=			false;
	String mode							=			request.getParameter("mode");
	String edit							=			request.getParameter("edit")==null?"1":request.getParameter("edit");
	String disabled						=			"";
	String item_disabled				=			"";
	String item_desc					=			"";
	String uom							=			"";
	String	conv_fact					=			"";
	String 	id_pur_uom_conv1			=			"";
	String order_qty 					=			"";
	String item_remarks 				=			"";
	String  item_code_dis				=			"";
	int srl_no							=			-1;
	int po_srl_no 						= 			1;
	int delv_srl_no						=			1;
	mode								=			mode.trim();
	String item_code					=			request.getParameter("item_code");
	String po_no						=			request.getParameter("po_no")==null?"":request.getParameter("po_no");
	String delv_date					=			request.getParameter("delv_date")==null?"":request.getParameter("delv_date");
	String request_no					=			request.getParameter("request_no")==null?"":request.getParameter("request_no");
	

	String caption						=			com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePO.Add.label","po_labels");
	String disable_add					=			"";
	String	uom_code					=			"";
	String itemCode_reqNO 				= 			"";
	String req_store 					= 			"";
	String facility_id 					= 			"";
	String rejection_remarks 			=			"";
	String quotation_uom_desc			=			"";
	String quotation_uom_code			=			"";
	String quotation_qty = "";
	String free_qty = "";
	String sample_qty = "";
	String batch_id = "";
	String expiry_date = "";
	String trade_id = "";
	String rejected_qty = "";
	String delvy_date = "";
	String quotation_price = "";
	String to_supplier					=			request.getParameter("to_supplier");
	String currency_code				=			request.getParameter("currency_code");
	String local_currency			=		bean.checkForNull(request.getParameter("local_currency"));
	String tot_value					=			"";
	String dis_type						=			"";
	String dis_amt						=			"";
	String net_amount					=			"";
	String disPerSelected 				=			"";
	String disAmtSelected 				=			"";
	String perHidden					=			"";
	String manufactur_id = "" ;
	String sample_type = "";
	String replace_type = "";
	String item_status = "";
	
	if ((mode == null) || (mode.equals(""))) 
		return;
	if (!(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))))
		return;


	
	if (item_code != null) {
	
		caption							=			com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePO.Modify.label","po_labels");
		editMode						=			true;
		item_disabled					=			"disabled";
		if(edit.equals("2"))
			disabled					=			"disabled";
				
		
		requestDetail					=			bean.getItemDetail(item_code);
		System.out.println("requestDetail in details = "+requestDetail);
		item_code						=			bean.checkForNull(requestDetail.getItem_code());
		item_desc						=			requestDetail.getItem_desc();
		order_qty						=			bean.checkForNull(requestDetail.getOrder_qty());	
		uom								=			bean.checkForNull(requestDetail.getUomDesc());
		uom_code						=			bean.checkForNull(requestDetail.getUom());
		srl_no							=			requestDetail.getSrl_no();
		po_srl_no						=			requestDetail.getPo_srl_no();
		delv_srl_no						=			requestDetail.getDelv_srl_no();
		item_remarks 					= 			bean.checkForNull(requestDetail.getItem_remarks());
		req_store 						= 			bean.checkForNull(requestDetail.getStore_code());
		facility_id 					= 			bean.checkForNull(requestDetail.getFacility_code());
		conv_fact						=			bean.checkForNull(requestDetail.getConvFact());
		rejection_remarks 				= 			bean.checkForNull(requestDetail.getRejection_remarks());
		quotation_uom_desc				=			bean.checkForNull(requestDetail.getQuotation_uom_desc());
		quotation_uom_code 				= 			bean.checkForNull(requestDetail.getQuotation_uom_code());
		quotation_qty 					= 			bean.checkForNull(requestDetail.getQuotation_qty());
		free_qty 						= 			bean.checkForNull(requestDetail.getFree_qty());
		sample_qty 						= 			bean.checkForNull(requestDetail.getSample_qty());
		batch_id 						= 			bean.checkForNull(requestDetail.getBatch_id());
		expiry_date 					= 			bean.checkForNull(requestDetail.getExpiry_date());
		trade_id 						= 			bean.checkForNull(requestDetail.getTrade_id());
		rejected_qty 					= 			bean.checkForNull(requestDetail.getRejected_qty());
		delvy_date						=			bean.checkForNull(requestDetail.getDelv_date());
		quotation_price					=			bean.checkForNull(requestDetail.getQuotation_price());
		tot_value 						= 			bean.checkForNull(requestDetail.getTot_value());
		dis_type 						= 			bean.checkForNull(requestDetail.getDis_type());
		dis_amt 						= 			bean.checkForNull(requestDetail.getDis_amt());
		net_amount 						= 			bean.checkForNull(requestDetail.getNet_amount());
		manufactur_id					=			bean.checkForNull(requestDetail.getManufactur_id());
		replace_type					=			bean.checkForNull(requestDetail.getReplace_type());
		sample_type						=			bean.checkForNull(requestDetail.getSample_type());
		item_status						=			bean.checkForNull(requestDetail.getItem_status());
			
		}else{
			item_code						=			"";
			disable_add						=			 "disabled";
			
		}
		
	
		if(dis_type.equals("P")){
			disPerSelected = "selected";
			perHidden = "visible";
		}else if(dis_type.equals("A")){
			disAmtSelected = "selected";
			perHidden = "hidden";
		}
		
		String replaceYesSelected = "";
		String replaceNoSelected = "";
		
		if(replace_type.equals("Y")){
			replaceYesSelected = "selected";
			
		}else if(replace_type.equals("N")){
			replaceNoSelected = "selected";
		}
		
		String sampleYesSelected = "";
		String sampleNoSelected = "";
		
		if(sample_type.equals("Y")){
			sampleYesSelected = "selected";
			
		}else if(sample_type.equals("N")){
			sampleNoSelected = "selected";
		}
		
		String statusSelected = "";
		String statusRejected = "";
		String statusPending = "";
		
		System.out.println("item_status in dtl = "+item_status);
		
		if(item_status.equals("SD")){
			statusSelected = "selected";
			
		}else if(item_status.equals("RD")){
			statusRejected = "selected";
		}else if(item_status.equals("PD")){
			statusPending = "selected";
		}
		
		
				
		if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")))
			item_code_dis= "disabled";
		else
			item_code_dis= "";
		
		String currentdate	   =	com.ehis.util.DateUtils.getCurrentDate("DMY",locale).toString();
		String postdate	       =    com.ehis.util.DateUtils.plusDate(currentdate,"DMY",locale,7,"d");
		
		
		System.out.println("bean.getCurrency_code() in dtl= "+bean.getCurrency_code());
		String supp_code = "";
		String dflt_currency = "";
		if(bean.getRequest_on_supp() != "" && bean.getRequest_on_supp() != null ){
			supp_code = bean.getRequest_on_supp(); 
		}else if(to_supplier != "" && to_supplier != null){
			 supp_code = to_supplier ; 
		}
		if(bean.getCurrency_code() != "" && bean.getCurrency_code() != null ){
			dflt_currency = bean.getCurrency_code() ; 	 
			System.out.println("dflt_currency in hdr before1= "+dflt_currency);
		}
		else if(currency_code != "" && currency_code != null){	 
			dflt_currency = currency_code ; 	 
			System.out.println("dflt_currency in hdr before= "+dflt_currency);
		}
	
		
		System.out.println("supp_code in dtl = "+supp_code);
		
		if(dflt_currency == "" && dflt_currency == null){
		HashMap hmRecord = bean.getCurrencyDesc(supp_code);
			if(hmRecord.size()>0){
				 dflt_currency = (String)hmRecord.get("CURRENCY_CODE");
				
			}
		}	
			System.out.println("dflt_currency in  Detail= "+dflt_currency);
			
		String dflt_currency_desc =	bean.checkForNull((String)bean.fetchRecord("SELECT currency_code, short_desc FROM sy_foreign_currency_lang_vw WHERE language_id = ? and currency_code = ? ORDER BY 2",new String[]{locale,dflt_currency}).get("SHORT_DESC"),"");
		
		String currency_desc_lc =	bean.checkForNull((String)bean.fetchRecord("select  SHORT_DESC  from  sy_foreign_currency_lang_vw where CURRENCY_CODE=? and language_id = ?",new String[]{local_currency,locale}).get("SHORT_DESC"),"");	
		
	if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))){	

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(dflt_currency_desc));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(currency_desc_lc));
            _bw.write(_wl_block11Bytes, _wl_block11);
 } else { 
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(dflt_currency_desc));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(currency_desc_lc));
            _bw.write(_wl_block11Bytes, _wl_block11);
 } 
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(item_desc));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(item_disabled));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(item_disabled));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(quotation_qty));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(bean.getImage("M")));
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(bean.getUom_code(quotation_uom_code)));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(bean.getImage("M")));
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(quotation_price));
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(tot_value));
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(disPerSelected));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(disAmtSelected));
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);
 if(dis_amt == "") {
            _bw.write(_wl_block33Bytes, _wl_block33);
 } else { 
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(perHidden));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(dis_amt));
            _bw.write(_wl_block36Bytes, _wl_block36);
 } 
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(net_amount));
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(statusPending));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(statusRejected));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(statusSelected));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block44Bytes, _wl_block44);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block44Bytes, _wl_block44);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block44Bytes, _wl_block44);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(caption));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(disable_add));
            _bw.write(_wl_block48Bytes, _wl_block48);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf( bean_name ));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(bean.getFunctionId()));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(editMode?2:1));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(uom_code));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(uom));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(uom_code));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf( ePO.Common.PoRepository.getPoKeyValue("SQL_MM_ITEM_LOOKUP")));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(conv_fact));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(item_remarks));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(itemCode_reqNO));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(req_store));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(po_no));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(po_srl_no));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(delv_srl_no));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(rejection_remarks));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(quotation_uom_desc));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(quotation_uom_code));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(delvy_date));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(order_qty));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(request_no));
            _bw.write(_wl_block75Bytes, _wl_block75);

		putObjectInBean(bean_id,bean,request);
	
            _bw.write(_wl_block76Bytes, _wl_block76);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePO.EnterItemDetails.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${po_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePO.Item.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${po_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePO.QuotationQty.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${po_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePO.QuotationUOM.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${po_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePO.UnitCost.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${po_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePO.GrossAmount.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePO.DiscountType.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePO.Discount.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePO.NetAmount.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePO.ItemStatus.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePO.MoreDetails.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${po_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePO.SelectionCriteria.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${po_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePO.EvaluationFactor.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${po_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePO.cancel.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${po_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
