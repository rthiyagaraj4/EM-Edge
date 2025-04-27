package jsp_servlet._epo._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import ePO.PurchaseOrderDetailBean;
import ePO.PurchaseOrderBean;
import ePO.Common.*;
import eCommon.Common.*;
import java.util.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __purchaseorderdetail extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ePO/jsp/PurchaseOrderDetail.jsp", 1709121593966L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' ></link>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../ePO/js/PoCommon.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../ePO/js/PoTransaction.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../ePO/js/PurchaseOrder.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/CommonResult.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t <script>\n        function_id = \"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"\n\t\t </script>\n</head>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<body onLoad=\"FocusFirstElement();onLoadCurrCode(\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\');calculateDisAmount();loadDeptId1(\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\',\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\');\">\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t<body onLoad=\"onLoadCurrCode(\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\');calculateDisAmount();\">\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\n\t<form name=\"formPurchaseOrderDetail\" id=\"formPurchaseOrderDetail\">\n\t\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" >\n\t\t\t<tr>\n\t\t\t\t<th colspan=2>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</th>\n\t\t\t</tr>\n\t\t\t<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>\n\t\t\t<tr>\n\t\t\t\t<td class=\"label\" colspan=2>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&nbsp;&nbsp;\n\t\t\t\t\t<input type=\"text\" name=\"item_desc\" id=\"item_desc\" size=\"30\" maxlength=\"30\"  value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =">\n\t\t\t\t\t<input type=\"button\" value=\"?\" class=\"button\" onClick=\"return searchCodeItem(item_desc);\" ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="  >&nbsp;<img src=\"../../eCommon/images/mandatory.gif\" align=center></img>&nbsp;&nbsp;\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>\n\t\t\t<tr>\n\t\t\t\t<td class=\"label\" >\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n\t\t\t\t<td class=\"field\" >\t<input type=\"text\" name=\"order_qty\" id=\"order_qty\" class=NUMBER size=\"10\" maxlength=\"8\"  value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" onKeyPress=\"return isValidInteger();\" onBlur=\"checkIntegerFormat(this);calculateValue();calculateDiscount();calculatePrice();checkUOMConvFactor();\">";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>\n\t\t\t<tr>\n\t\t\t\t<td class=\"label\" >";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td>\n\t\t\t\t<td class=\"field\" >\t\n\t\t\t\t\t<select name=\'uom\' id=\'uom\' onchange=\"getUOMDesc(this);\" onBlur=\"getUOMDesc(this); checkUOMConvFactor();\" >";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</select>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t</td>\n\t\t\n\t\t\t</tr>\n\t\t\t<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>\n\t\t\t<tr>\n\t\t\t\t<td class=\"label\" >\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</td>\n\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t<td class=\"field\" > <input type=\"text\" class=NUMBER name=\"unit_price\" id=\"unit_price\" size=\"12\" maxlength=\"12\"  value=\"0\" onKeyPress=\"return isValidNumber(this,event,7,3);isValidInteger();\" onBlur=\"calculateValue();calculateDiscount();calculatePrice();\">\n\t\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t<td class=\"field\" > <input type=\"text\" class=NUMBER name=\"unit_price\" id=\"unit_price\" size=\"12\" maxlength=\"12\"  value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" onKeyPress=\"return isValidNumber(this,event,7,3);isValidInteger();\" onBlur=\"calculateValue();calculateDiscount();calculatePrice();\">\n\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =" \n\t\t\t\t<label id=\'currency_label_1\' class=\"label\" >&nbsp;<B></B></label>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>\n\t\t\t<tr>\n\t\t\t\t<td class=\"label\" >\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</td>\n\t\t\t\t<td class=\"field\" > <input type=\"text\" class=NUMBER name=\"tot_value\" id=\"tot_value\" size=\"15\" maxlength=\"15\"  value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" onKeyPress=\"return isValidNumber(this,event,10,3);isValidInteger();\" onBlur=\"calculateDiscount();\">\n\t\t\t\t<label id=\'currency_label_2\' class=\"label\" >&nbsp;<B></B></label>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>\n\t\t\t<tr>\n\t\t\t\t<td class=\"label\"> ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</td>\n\t\t\t\t<td class=\"field\" > \n\t\t\t\t\t<select name=\"dis_type\" id=\"dis_type\" onchange=\"calculateDiscount();perChange(this);\">\n\t\t\t\t\t\t<option value=\"P\" ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =">Percentage</option>\n\t\t\t\t\t\t<option value=\"A\" ";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =">Amount</option>\n\t\t\t\t\t</select>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>\n\t\t\t<tr>\n\t\t\t\t<td class=\"label\">\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</td>\n\t\t\t\t<td class=\"field\" > \n\t\t\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t\t\t<input type=\"text\" class=NUMBER name=\"dis_value\" id=\"dis_value\" size=\"10\" maxlength=\"10\"  value=\"0\" onKeyPress=\"return isValidNumber(this,event,5,3);return isValidInteger();\" onBlur=\"calculateDiscount();calculatePrice();\">\n\t\t\t\t\t\t<span id=\"perHidden\" style=visibility:visible>\n\t\t\t\t\t\t\t<input type=\"text\" class=NUMBER name=\"dis_amt\" id=\"dis_amt\" size=\"10\" maxlength=\"10\"  value=\"0\" onKeyPress=\"return isValidNumber(this,event,5,3);return isValidInteger();\" onBlur=\"calculateDiscount();\" disabled>\n\t\t\t\t\t\t</span>\n\t\t\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t\t<input type=\"text\" class=NUMBER name=\"dis_value\" id=\"dis_value\" size=\"10\" maxlength=\"10\"  value=\"\" onKeyPress=\"return isValidNumber(this,event,5,3);return isValidInteger();\" onBlur=\"calculateDiscount();calculatePrice();\">\n\t\t\t\t\t\t<span id=\"perHidden\" style=visibility:";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 =">\n\t\t\t\t\t\t\t<input type=\"text\" class=NUMBER name=\"dis_amt\" id=\"dis_amt\" size=\"10\" maxlength=\"10\"  value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" onKeyPress=\"return isValidNumber(this,event,5,3);return isValidInteger();\" onBlur=\"calculateDiscount();calculateDisAmount()\" disabled>\n\t\t\t\t\t\t</span>\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t\t\t<label id=\'currency_label_3\' class=\"label\" >&nbsp;<B></B></label>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>\n\t\t\t<tr>\n\t\t\t\t<td class=\"label\"> ";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</td>\n\t\t\t\t<td class=\"field\" > <input type=\"text\"  class=NUMBER name=\"net_amount\" id=\"net_amount\" size=\"15\" maxlength=\"15\"  value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" onKeyPress=\"return isValidNumber(this,event,10,3);isValidInteger();\" onBlur=\"calculatePrice();\">\n\t\t\t\t\t<label id=\'currency_label_4\' class=\"label\" >&nbsp;<B></B></label>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>\n\t\t\t<tr>\n\t\t\t\t<td class=\"label\" >\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</td>\n\t\t\t\t<td class=\"field\" > <input type=\"text\" class=NUMBER name=\"pur_price\" id=\"pur_price\" size=\"12\" maxlength=\"12\"  value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\" onKeyPress=\"return isValidNumber(this,event,7,3);isValidInteger();\" onBlur=\"calculatePrice();\">\n\t\t\t\t<label id=\'currency_label_8\' class=\"label\" >&nbsp;<B></B></label>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t\n\t\t\t<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>\n\t\t\t<tr>\n\t\t\t\t<td class=label align=right> ";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</td>\n\t\t\t\t<td class=\"field\" > <select name=\"commit_code\" id=\"commit_code\" onchange=\"loadDeptId(this);getCOMMNTDesc(this);\" onBlur=\"getCOMMNTDesc(this);\">";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</select><span style=\'visibility:";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\'>";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</span></td>\n\t\t\t</tr>\n\t\t\t<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>\n\t\t\t<tr>\n\n\t\t\t\t<td class=label align=right> ";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</td>\n\t\t\t\t<td class=\"field\" > <select name=\"dept_id\" id=\"dept_id\" onchange=\"loadAccNo(this);\">\n\t\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\">";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</option>\n\t\t\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\t\n\t\t\t\t\t<option value=\"\">---Select---</option>\n\t\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\t\n\t\t\t\t\t</select> <span style=\'visibility:";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="</span></td>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>\n\t\t\t<tr>\n\t\t\t\t<td class=label align=right>";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="</td>\n\t\t\t\t<td class=\"field\" > <select name=\"acc_no\" id=\"acc_no\" onchange=\'loadAccDesc(this);\'>\n\t\t\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t\t\t</select> <span style=\'visibility:";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="</span></td>\t\t\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>\n\t\t\t<tr>\n\t\t\t\t<td class=label align=right> ";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="</td>\n\t\t\t\t<td class=\"field\" > \n\t\t\t\t\t<label id=\'acc_desc_label\'  class=\"label\">";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="</label>\n\t\t\t\t\t<input type=\"hidden\" name=\"acc_desc\" id=\"acc_desc\" value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\">\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>\n\t\t\t<tr>\n\t\t\t\t<td class=label align=right> \n\t\t\t\t\t<span id=\"DelvSchHidden\" style=visibility:";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 =">\n\t\t\t\t\t\t<a href=\"javascript:DeliverySchedule(\'";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\')\">Delivery Schedule</a>\n\t\t\t\t\t</span>\n\t\t\t\t\t<span id=\"DelvSchHide\" style=visibility:";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 =">\n\t\t\t\t\t\tDelivery Schedule\n\t\t\t\t\t</span>\t\t\t\t\n\t\t\t\t</td>\n\t\t\t\n\t\t\t\t<td class=\"fields\">\n\t\t\t\t";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\t\t\t\t\t<input type=\"text\" value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\" name=\"del_date\"  maxLength=\"10\" size=\"10\"  onBlur=\"CheckDate(this);\" >&nbsp;\n\t\t\t\t";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\t\n\t\t\t\t\t<input type=\"text\" value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\t\t\n\t\t\t\t\t<input type=\"text\" value=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\t\n\t\t\t\t\t<img src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendar(\'del_date\');\"  ></img>";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\t\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>\n\t\t\t<tr>\n\t\t\t\t<td class=label align=right>";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="</td>\n\t\t\t\t<td class=\"field\" > <input type=\"checkbox\" value=\"Y\" name=\"app_ref\" id=\"app_ref\" onclick=\"checkAppvlRef(this)\" ";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 =">\n\t\t\t\t\t<input type=\"text\" name=\"ref_value\" id=\"ref_value\" size=\"15\" maxlength=\"20\"  value=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 =">\n\t\t\t\t\t<span id=\"manditHidden\" style=visibility:hidden> ";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 =" </span>\t\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>\n\t\t\t<tr>\n\t\t\t\t<td class=\"label\" ><label onMouseOver=\"changeCursor(this);\"  class=\"label\" onClick = \"ItemRemarks(item_remarks.value,\'\');\"><font class=\'HYPERLINK\'>";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="</font></label>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>\n\t\t\t<tr>\n\t\t\t\t<td colspan=2 align=right>\n\t\t\t\t\t<input type=\"button\" class=\"button\" name=\"add\" id=\"add\" value=\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\"  ";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 =" onClick=\"addItemRecord();\">&nbsp;\n\t\t\t\t\t<input type=\"button\" class=\"button\" name=\"cancel\" id=\"cancel\" value=\'";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\' onClick=\"resetDetail();\"></td>\n\t\t\t</tr>\n\t\t</table>\n\t\n\t\n\t\t<input type=\"hidden\"\t\tname=\"mode\" id=\"mode\"\t\t\t\t\t\t value=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\">\n\t\t<input type=\"hidden\"\t\tname=\"request_by_pu\" id=\"request_by_pu\"\t\t\t value=\"\">\n\t\t<input type=\"hidden\"\t\tname=\"request_on_supp\" id=\"request_on_supp\"\t\t\t value=\"\">\n\t\t<input type=\"hidden\"\t\tname=\"item_code\" id=\"item_code\"\t\t\t\t value=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\">\n\t\t<input type=\"hidden\"\t\tname=\"srl_no\" id=\"srl_no\"\t\t\t\t\t value=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\">\n\t\t<input type=\"hidden\"\t\tname=\"bean_id\" id=\"bean_id\"\t\t\t\t\t value=\"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\">\n\t\t<input type=\"hidden\"\t\tname=\"bean_name\" id=\"bean_name\"\t\t\t\t value=\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\">\n\t\t<input type=\"hidden\"\t\tname=\"function_id\" id=\"function_id\"\t\t\t\t value=\"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\">\n\t\t<input type=\"hidden\"\t\tname=\"editing\" id=\"editing\"\t\t\t\t\t value=\"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\">\n\t\t<input type=\"hidden\"\t\tname=\"check_box_status\" id=\"check_box_status\"\t\t\t value=\"Y\">\n\t\t<input type=\"hidden\"\t\tname=\"store_name\" id=\"store_name\"\t\t\t\t value=\"\">\n\t\t<input type=\"hidden\"\t\tname=\"temp_uom\" id=\"temp_uom\"\t\t\t\t\t value=\"";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\">\n\t\t<input type=\"hidden\"\t\tname=\"temp_uom_code\" id=\"temp_uom_code\"\t\t\t value=\"";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\">\n\t\t<input type=\"hidden\"\t\tname=\"temp_commt\" id=\"temp_commt\"\t\t\t\t value=\"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\">\n\t\t<input type=\"hidden\"\t\tname=\"SQL_ST_ITEM_LOOKUP\" id=\"SQL_ST_ITEM_LOOKUP\"\t\t value=\"";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\">\n\t\t<input type=\"hidden\"\t\tname=\"p_language_id\" id=\"p_language_id\"\t\t\t value=\"";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\">\n\t\t<input type=\"hidden\"\t\tname=\"conv_fact\" id=\"conv_fact\"\t\t\t\t value=\"";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\">\n\t\t<input type=\"hidden\"\t\tname=\"item_remarks\" id=\"item_remarks\"\t\t\t\t value=\"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\">\n\t\t<input type=\"hidden\"\t\tname=\"order_qty1\" id=\"order_qty1\"\t\t\t\t value=\"\">\n\t\t<input type=\"hidden\"\t\tname=\"del_due_dt1\" id=\"del_due_dt1\"\t\t\t\t value=\"\">\n\t\t<input type=\"hidden\"\t\tname=\"itemCode_reqNO\" id=\"itemCode_reqNO\"\t\t\t value=\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\">\n\t\t<input type=\"hidden\"\t\tname=\"req_store\" id=\"req_store\"\t\t\t\t value=\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\">\n\t\t<input type=\"hidden\"\t\tname=\"facility_id\" id=\"facility_id\"\t\t\t\t value=\"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\">\n\t\t<input type=\"hidden\"\t\tname=\"req_no\" id=\"req_no\"\t\t\t\t     value=\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\">\n\t\t<input type=\"hidden\"\t\tname=\"req_srl_no\" id=\"req_srl_no\"\t\t\t\t value=\"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\">\n\t\t<input type=\"hidden\"\t\tname=\"budget_check_yn\" id=\"budget_check_yn\"\t\t\t value=\"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\">\n\t\t<input type=\"hidden\"\t\tname=\"dept_desc\" id=\"dept_desc\"\t\t\t\t value=\"";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\">\n\t\t<input type=\"hidden\"\t\tname=\"bal_budget\" id=\"bal_budget\"\t\t\t\t value=\"\">\n\t\t<input type=\"hidden\"\t\tname=\"eff_from\" id=\"eff_from\"\t\t\t\t value=\"\">\n\t\t\n\t\t\t\t\n\t</form>\n\t";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\n</body>\n</html>\n\n";
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

	PurchaseOrderDetailBean requestDetail;
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
	String unit_price					= 			"";
	String list_price					=			"";
	String tot_value					=			"";
	String dis_type						=			"";
	String dis_amt						=			"";
	String dis_value					=			"";
	String net_amount					=			"";
	String commit_code					=			"";
	String commit_desc					=			"";
	String dept_no						=			"";
	String acc_no						=			"";
	String acc_desc						=			"";
	String app_ref						=			"";
	String ref_value					=			"";
	String item_remarks 				=			"";
	String disPerSelected 				=			"";
	String disAmtSelected 				=			"";
	String appRefChecked 				=			"";
	String appRefDisabled 				= 			"";
	String  item_code_dis				=			"";
	int srl_no							=			-1;
	int req_srl_no 						= 			0;
	mode								=			mode.trim();
	String item_code					=			request.getParameter("item_code");
	String req_no						=			request.getParameter("req_no")==null?"":request.getParameter("req_no");
	String bean_id						=			"purchaseOrderBean";
	String bean_name					=			"ePO.PurchaseOrderBean";
	String caption						=			com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePO.Add.label","po_labels");
	String disable_add					=			"";
	String	uom_code					=			"";
	String itemCode_reqNO 				= 			"";
	String req_store 					= 			"";
	String facility_id 					= 			"";
	String DevlHidden					=			"";
	String DevlHide						=			"";
	String perHidden					=			"";
	String del_date						=			request.getParameter("del_date");
	String blanket_yn					=			request.getParameter("blanket_yn");
	String to_supplier					=			request.getParameter("to_supplier");
	String currency_code				=			request.getParameter("currency_code");
	String budget_check_yn				=			"";
	String budget_check_mandatory		=			"hidden";
	String eff_from_dt 				=			"";
	
	
	
	if ((mode == null) || (mode.equals(""))) 
		return;
	if (!(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))))
		return;

	PurchaseOrderBean bean				=			(PurchaseOrderBean) getBeanObject(bean_id, bean_name,request );  
	bean.setLanguageId(locale);
	
/*	int no_of_decimals					=			bean.getNoOfDecimals();
	if((bean.getAllowDecimalsYN(item_code)).equals("N")){
			no_of_decimals = 0;
	}
*/	
	
	if (item_code != null) {
	
		caption							=			com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePO.Modify.label","po_labels");
		editMode						=			true;
		item_disabled					=			"disabled";
		if(edit.equals("2"))
			disabled					=			"disabled";
				
		itemCode_reqNO = item_code +""+req_no;
		
		requestDetail					=			bean.getItemDetail(itemCode_reqNO);
		item_code						=			bean.checkForNull(requestDetail.getItem_code());
		item_desc						=			requestDetail.getItem_desc();
		order_qty						=			requestDetail.getOrder_qty();	
		uom								=			bean.checkForNull(requestDetail.getUomDesc());
		uom_code						=			bean.checkForNull(requestDetail.getUom());
		srl_no							=			requestDetail.getSrl_no();
		req_srl_no						=			requestDetail.getReq_srl_no();
		list_price 						= 			bean.checkForNull(requestDetail.getUnit_price());
		unit_price 						= 			bean.checkForNull(requestDetail.getPur_price());
		tot_value 						= 			bean.checkForNull(requestDetail.getTot_value());
		dis_type 						= 			bean.checkForNull(requestDetail.getDis_type());
		dis_amt 						= 			bean.checkForNull(requestDetail.getDis_amt());
	//	dis_value 						= 			bean.checkForNull(requestDetail.getDis_value());
		net_amount 						= 			bean.checkForNull(requestDetail.getNet_amount());
		commit_code 					= 			bean.checkForNull(requestDetail.getCommit_code());
		commit_desc						=			bean.checkForNull(requestDetail.getCommt_Desc());	
		dept_no 						= 			bean.checkForNull(requestDetail.getDept_no());
		acc_no 							= 			bean.checkForNull(requestDetail.getAcc_no());
		acc_desc 						= 			bean.checkForNull(requestDetail.getAcc_desc());
		app_ref 						= 			bean.checkForNull(requestDetail.getApp_ref());
		ref_value 						= 			bean.checkForNull(requestDetail.getRef_value());
		item_remarks 					= 			bean.checkForNull(requestDetail.getItem_remarks());
		req_store 						= 			bean.checkForNull(requestDetail.getStore_code());
		facility_id 					= 			bean.checkForNull(requestDetail.getFacility_code());
		del_date 						= 			bean.checkForNull(requestDetail.getDel_date());
		conv_fact						=			bean.checkForNull(requestDetail.getConvFact());
		eff_from_dt 					= 			bean.checkForNull(requestDetail.getEff_from_dt());
		
	/*	id_pur_uom_conv1				=			bean.checkForNull(requestDetail.getPur_uom_conv_id());
		if(conv_fact.equals(id_pur_uom_conv1))
				id_pur_uom_conv1=conv_fact;
	*/			
		}else{
			item_code						=			"";
			disable_add						=			 "disabled";
			appRefDisabled = "disabled";
		}
		
		if(dis_type.equals("P")){
			disPerSelected = "selected";
			perHidden = "visible";
		}else if(dis_type.equals("A")){
			disAmtSelected = "selected";
			perHidden = "hidden";
		}
		if(app_ref.equals("Y")){
			appRefChecked = "checked";
			appRefDisabled = "";
		}else{
			appRefChecked = "";
			appRefDisabled = "disabled";
		}
		
		if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")))
			item_code_dis= "disabled";
		else
			item_code_dis= "";
			
		if(bean.getBlanket_po_yn().equals("Y") || bean.checkForNull(blanket_yn).equals("Y")){
			
			DevlHidden = "visible";
			DevlHide = "hidden";
		} else {
			
			DevlHidden = "hidden";
			DevlHide = "visible";
		}	
		
			
		String dept_desc =		bean.checkForNull((String)bean.fetchRecord("SELECT ad.DEPT_CODE,ad.SHORT_DESC FROM PO_COMMTTMENT_ACCOUNT ca,  AM_DEPT_LANG_VW ad WHERE ad.LANGUAGE_ID=? AND ca.DEPT_CODE = ad.DEPT_CODE AND ca.MASTER_CODE=? AND ca.DEPT_CODE = ?",new String[]{bean.getLanguageId(),(String) commit_code , (String) dept_no }).get("SHORT_DESC"),"");
		
		dept_desc = dept_desc+"-"+eff_from_dt;
		dept_desc = URLEncoder.encode(dept_desc, "UTF-8").replaceAll("\\+", "%20") ;
		
		String currentdate	   =	com.ehis.util.DateUtils.getCurrentDate("DMY",locale).toString();
		String postdate	       =    com.ehis.util.DateUtils.plusDate(currentdate,"DMY",locale,7,"d");
		
		
		String supp_code = "";
		String dflt_currency = "";
		if(bean.getRequest_on_supp() != "" && bean.getRequest_on_supp() != null ){
			supp_code = bean.getRequest_on_supp(); 
		}else if(to_supplier != "" && to_supplier != null){
			 supp_code = to_supplier ; 
		}
		if(bean.getCurrency_code() != "" && bean.getCurrency_code() != null ){
			dflt_currency = bean.getCurrency_code() ; 	 
			
		}
		else if(currency_code != "" && currency_code != null){	 
			dflt_currency = currency_code ; 	 
			
		}
		
		if(dflt_currency == "" && dflt_currency == null){
		HashMap hmRecord = bean.getCurrencyDesc(supp_code);
			if(hmRecord.size()>0){
				 dflt_currency = (String)hmRecord.get("CURRENCY_CODE");
			}
		}	
			
			
		budget_check_yn =		bean.checkForNull((String)bean.fetchRecord("SELECT BUDGET_CHECK_REQD_YN FROM PO_PARAMETER").get("BUDGET_CHECK_REQD_YN"),"");
		
		if(budget_check_yn.equals("Y")) { 
			budget_check_mandatory = "visible";
		}
		
		
	if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))){			

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(dflt_currency));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(commit_code));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(dept_desc));
            _bw.write(_wl_block12Bytes, _wl_block12);
 
	}else{ 

            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(dflt_currency));
            _bw.write(_wl_block14Bytes, _wl_block14);

	}

            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(item_desc));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(item_disabled));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(item_disabled));
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(order_qty));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(bean.getImage("M")));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
//bean.getUom_code(uom_code) Modified by suresh.r on 04-12-2014 against ML-BRU-SCF-1457 
            out.print( String.valueOf(bean.getPur_uom_code_List(uom_code,item_code)));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(bean.getImage("M")));
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);
 if(list_price == "") {
            _bw.write(_wl_block28Bytes, _wl_block28);
 } else { 
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(list_price));
            _bw.write(_wl_block30Bytes, _wl_block30);
 } 
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(tot_value));
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(disPerSelected));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(disAmtSelected));
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);
 if(dis_amt == "") {
            _bw.write(_wl_block38Bytes, _wl_block38);
 } else { 
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(perHidden));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(dis_amt));
            _bw.write(_wl_block41Bytes, _wl_block41);
 } 
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(net_amount));
            _bw.write(_wl_block44Bytes, _wl_block44);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(unit_price));
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(bean.getComm_code(commit_code)));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(budget_check_mandatory));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(bean.getImage("M")));
            _bw.write(_wl_block50Bytes, _wl_block50);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block51Bytes, _wl_block51);
 if(dept_no != "" && dept_no != null) {
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(dept_no));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(dept_desc));
            _bw.write(_wl_block54Bytes, _wl_block54);
 } else { 
            _bw.write(_wl_block55Bytes, _wl_block55);
 } 
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(budget_check_mandatory));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(bean.getImage("M")));
            _bw.write(_wl_block57Bytes, _wl_block57);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block58Bytes, _wl_block58);
 if(acc_no != "" && acc_no != null) {
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(acc_no));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(acc_no));
            _bw.write(_wl_block54Bytes, _wl_block54);
 } else { 
            _bw.write(_wl_block55Bytes, _wl_block55);
 } 
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(budget_check_mandatory));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(bean.getImage("M")));
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(acc_desc));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(acc_desc));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(DevlHidden));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(DevlHide));
            _bw.write(_wl_block67Bytes, _wl_block67);
 if(bean.checkForNull(del_date) != "" && bean.checkForNull(del_date) != null){ 
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(bean.checkForNull(del_date)));
            _bw.write(_wl_block69Bytes, _wl_block69);
 } else  if(bean.checkForNull(bean.getExp_date()) != "" && bean.checkForNull(bean.getExp_date()) != null){ 
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(bean.checkForNull(bean.getExp_date())));
            _bw.write(_wl_block69Bytes, _wl_block69);
 } else { 
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(postdate));
            _bw.write(_wl_block69Bytes, _wl_block69);
 } 
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(bean.getImage("M")));
            _bw.write(_wl_block73Bytes, _wl_block73);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(appRefChecked));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(ref_value));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(appRefDisabled));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(bean.getImage("M")));
            _bw.write(_wl_block77Bytes, _wl_block77);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(caption));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(disable_add));
            _bw.write(_wl_block80Bytes, _wl_block80);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf( bean_name ));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(bean.getFunctionId()));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(editMode?2:1));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(uom));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(uom_code));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(commit_desc));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf( ePO.Common.PoRepository.getPoKeyValue("SQL_ST_ITEM_LOOKUP")));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(conv_fact));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(item_remarks));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(itemCode_reqNO));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(req_store));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(req_no));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(req_srl_no));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(budget_check_yn));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(dept_desc));
            _bw.write(_wl_block102Bytes, _wl_block102);

		putObjectInBean(bean_id,bean,request);
	
            _bw.write(_wl_block103Bytes, _wl_block103);
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePO.OrderQty.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePO.OrderUOM.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePO.ListPrice.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePO.PurchasePrice.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePO.CommitmentCode.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePO.DeptId/Acc.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePO.AcctNumber.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePO.AccNoDesc.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePO.ApprovalReference.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePO.ItemRmks.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${po_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePO.cancel.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${po_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
