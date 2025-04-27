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
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __salesreturnsearchwindowresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/est/jsp/SalesReturnSearchWindowResult.jsp", 1709122178994L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 =" \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n\t<head>\n\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' ></link>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eST/js/StCommon.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eST/js/SalesReturn.js\"></script>\n    \t<script language=\'javascript\' src=\'../../eST/js/StTransaction.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t<script>\n\t\t\t\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\"));\n\t\t\t\t//document.parentWindow.close();\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t<base target=_self>\n\t</head>\n<body>\n\t<form name= \"formSalesReturnSearchWindowResult\">\n\n\t<table border=\'1\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' align=center>\n        <tr><th align=\'center\' >";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</th>\t</tr>\n\t</table>\n\t<!--added above, if more records for one patient id gives script error-->\n\t\n\t<input type=\"hidden\" name=\"finalstring\" id=\"finalstring\" value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\">\n\t<input type=\"hidden\" name=\"chargeable_yn\" id=\"chargeable_yn\" value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\">\n\t<input type=\"hidden\" name=\"sal_trn_type\" id=\"sal_trn_type\" value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\n\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\n\t<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\n\t<input type=\"hidden\" name=\"store_code\" id=\"store_code\" value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n\t<input type=\"hidden\" name=\"patient_name\" id=\"patient_name\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" >\n\t<input type=\"hidden\" name=\"selected_doc_no\" id=\"selected_doc_no\" value=\"\">\n\t<input type=\"hidden\" name=\"prevdoc_type\" id=\"prevdoc_type\" value=\"\"> <!-- added for IN074078-->\n\t<input type=\"hidden\" name=\"sel_doc_batch_count\" id=\"sel_doc_batch_count\" value=\"\">\n\t<input type=\"hidden\" name=\"prev_ind\" id=\"prev_ind\" value=\"\">\n\t<input type=\"hidden\" name=\"total\" id=\"total\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n        \n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\n        <table  border = \'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' align=center>\n\t\t<tr>\n\t\t<td align=\'left\' width=\'20%\'><input type=\"radio\" name=\"doc_no_radio\" id=\"doc_no_radio\" id=\"doc_no_radio\" value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\"  onClick=\'enable_doc(this, \"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\",\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\");\'  > <!--modified for  IN074078-->\n\t\t<label style=\"font-family:verdana;font-size:10\"><b>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</b></label>&nbsp;\n        <label style=\"font-family:verdana;font-size:10\"><b>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</b></label></td>\n\n\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t<td width=\'10%\'><label style=\"font-family:verdana;font-size:10\"><b>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="&nbsp;:</b></label></td>\n\t\t<td><label  style=\"font-family:verdana;font-size:10;\"><b>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</b></label> \n\t\t<input type=\"hidden\" name=\'sal_patient_name_";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' id=\'sal_patient_name_";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\"></td>\n\t\t\n\t    ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t</td>\n\t    </tr>\n\t\t</table>\n\t\t<table border=\'1\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' align=\'center\'>\n\t\t\t<tr>\n                <th>\n                \n                <!-- Added by Sharanraj for GHL-CRF-0483 starts -->\n                ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n               \n                <input type=\"checkbox\" name=\'chkAll_";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="_";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' id=\'chkAll_";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'  id=\"chkAll";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\"    value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\"  onclick=\'chkALl(this, \"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\");\'  disabled >  <!--modified for  IN074078-->\n                \n\t\t\t\t<!-- Added by Sharanraj for GHL-CRF-0483 ends -->                \n                \n                </th>\n\t\t       <th >";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</th>\n\t\t\t\t<th>";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</th> \n\t\t\t\t<th>";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</th>\n                <th>";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</th>\n\t\t\t    <th>";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</th>\n       </tr>\n\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\n\t\t\t<TR>\t                                                                         \n            <td class=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\"   width=\'6%\'>\n\t    <!-- Modified for  IN074078-->\n            <input type=\"checkbox\"  id=\'doc_no_";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\'   name=\'doc_no_";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\'  value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\" onClick=\'getItemQty(this,";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 =",\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\");chkSel(this,\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\",";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\");\'  disabled  >  <!--  Added chkSel function by sharanraj against GHL-CRF-0483--> \n\t\t\t<input type=\"hidden\" name=\'doc_type_code_";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\' id=\'doc_type_code_";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\">\n\t\t\t<input type=\"hidden\" name=\'material_group_access_yn_";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\' id=\'material_group_access_yn_";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\"> <!-- 34089 -->\n\t\t\t</td>\n\t\t\t<td class=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\"   width=\'30%\' ><label style=\"font-family:verdana;font-size:10\">";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="</label>&nbsp;\n\t\t\t<input type=\"hidden\" name=\'item_code_";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\' id=\'item_code_";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\'       value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\">\n\t\t\t<input type=\"hidden\" name=\'item_name_";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\' id=\'item_name_";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\">\t\t\t\n\t\t\t<input type=\"hidden\" name=\'item_cost_";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\' id=\'item_cost_";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\">\t\t\t\n\t\t\t<input type=\"hidden\" name=\'expiry_yn_";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\' id=\'expiry_yn_";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\">\n\t\t\t<input type=\"hidden\" name=\'refund_allow_yn_";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\' id=\'refund_allow_yn_";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\">\n\t\t\t<input type=\"hidden\" name=\'stock_item_yn_";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\' id=\'stock_item_yn_";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\'   value=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\">\n\t\t\t<input type=\"hidden\" name=\'doc_srl_no_";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\' id=\'doc_srl_no_";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\'      value=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\">\n\t\t\t<input type=\"hidden\" name=\'srl_no_";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\' id=\'srl_no_";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\'          value=\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\"></td>\n\t\t\t<td class=\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\"  width=\'10%\'><label style=\"font-family:verdana;font-size:10\">";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 =" </label> <input type=\"hidden\" name=\'trade_id_";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\' id=\'trade_id_";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\"><input type=\"hidden\" name=\'trade_name_";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\' id=\'trade_name_";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\"></td>\t\n\t\t\t\n\t\t\t<td class=\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="</label><input type=\"hidden\"  name=\'batch_id_";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\' id=\'batch_id_";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\"></td>\n\n\n\t\t\t<td class=\"";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\"  width=\'15%\'><label style=\"font-family:verdana;font-size:10\">";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="</label>    <input type=\"hidden\" name=\'expiry_date_or_receipt_date_";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\' id=\'expiry_date_or_receipt_date_";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\"></td>\n    \t\t<td class=\"";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="</label><input type=\"hidden\" name=\'bin_location_code_";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\' id=\'bin_location_code_";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\'    value=\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\"><input type=\"hidden\" name=\'bin_location_desc_";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\' id=\'bin_location_desc_";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\' \t\t   value=\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\"> </td>\n\t\t    <td class=\"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\"  width=\'10%\' style=\'text-align:right;\'><label  style=\"font-family:verdana;font-size:10;text-align:right;\">";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="</label> &nbsp;\t</td>\n\t\t\t<input type=\"hidden\" id=\'sal_item_qty_";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\'  name=\'sal_item_qty_";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\">\n\t\t\t<input type=\"hidden\" id=\'allow_deci_";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\'  name=\'allow_deci_";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\">\n\t\t\t<td\tclass=\"";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\"   width=\'10%\'><label style=\"font-family:verdana;font-size:10\">";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="</label><input type=\"hidden\" name=\'uom_desc_";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\' id=\'uom_desc_";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\"><input type=\"hidden\" name=\'uom_code_";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\' id=\'uom_code_";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\" ><input style=\'text-align:right;\' type=\"text\" id=\'item_qty_";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="-";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\' name=\'item_qty_";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\'  size=\"10\" maxlength=\"10\" onKeyPress=\"return isValidNumberforMultiLine(this,event,8,";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 =",allow_deci_";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 =");\" disabled >  </td>\n\t\t     <!-- Modified for  IN074078-->\n</TR>\n";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\n\t\t<TR>\t\n            <td class=\"label\"  width=\'6%\' >&nbsp;</td>\n\t\t\t<input type=\"hidden\" name=\'material_group_access_yn_";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\' value=\"N\">   <!-- 34089 -->\n\t\t\t<td class=\"";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\"   width=\'30%\'><label style=\"font-family:verdana;font-size:10\">";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="</label>&nbsp;\t</td>\n\t\t\t<td class=\"";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\t</td>\t\n\t\t\t<td class=\"";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\"   width=\'15%\'><label style=\"font-family:verdana;font-size:10\">";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="</label>&nbsp;</td>\n\t        <td class=\"";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="</label> </td>\n\t\t    <td class=\"";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\"   width=\'10%\'  style=\'text-align:right;\'><label style=\"font-family:verdana;font-size:10\">";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="</label>&nbsp; </td>\n\t\t\t<td class=\"";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="</label>&nbsp;   </td>\n\t\t    <td class=\"";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\"   >&nbsp;</td>\n       </TR>\n\t\t   \n  ";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\n        <tr> \n\t      <td class=\"";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\" colspan=\"8\" id=\"material_group_access_message_";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\">&nbsp;</td>\t    <!-- 34089 -->  \n\t\t  <td> \n\t        <input align=\"right\" type=button name=\'apply_";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\' id=\'apply_";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\'   value=\'";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\'    align=\'right\' class=button onclick=\"onapply(\'";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\',\'";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\');\"  disabled >\t<!-- Modified for  IN074078-->\n\t\t  </td>\n\t\t</tr>\n\n\t</table>\t\n        \n";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\t\n\n\n<input type=\'hidden\'\tname=\"sal_doc_chkd\" id=\"sal_doc_chkd\"\t\tvalue=\"";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\">    <!-- Added by sharanraj for GHL-CRF-0483 -->\n\n\t</form>\n\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );
	
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
--------------------------------------------------------------------------------------------------------------
Date       		Edit History      	Name       	Rev.Date   		Rev.By    	Description
--------------------------------------------------------------------------------------------------------------
24/09/2020  	IN074078        B Haribabu          24/09/2020                          SKR-SCF-1441
27/07/2022		34089			Ramesh G 									PMG2022-COMN-CRF-0044
---------------------------------------------------------------------------------------------------------------
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
		String locale		=	(String)session.getAttribute("LOCALE");
		String login_user = (String)session.getValue("login_user") == null ? "" : (String)session.getValue("login_user"); //34089
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    	
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
    
	String patient_id           ="";
	String encounter_id         ="";
	String patient_name         ="";
	String bean_id              ="";
    String bean_name            ="";
    String sal_trn_type         ="";
	String chargeable_yn        ="";
	String store_code           ="";
	String from_doc_date        ="";
	String to_doc_date          ="";
	String item_code            ="";
	String item_desc            ="";
	String doc_no               ="";
	String sal_patient_name     ="";
	String batch_id = "";
	String trade_id = "";
	String expiry_date = "";
	String bin_location="";
	
	java.util.Properties prop   = (java.util.Properties) session.getValue( "jdbc" ) ;
	String login_at_ws_no		= prop.getProperty( "client_ip_address" );
	bean_id						= "salesReturnBean"+login_at_ws_no;
	bean_name					= "eST.SalesReturnBean";

   
	SalesReturnBean bean = (SalesReturnBean) getBeanObject( bean_id, bean_name,request );

	patient_id           =  request.getParameter( "patient_id"   );
	encounter_id         =  request.getParameter( "encounter_id" );
    patient_name         =  CommonBean.checkForNull(request.getParameter("patient_name"),"%")+'%';
	sal_trn_type         =  request.getParameter( "sal_trn_type" );
	chargeable_yn        =  request.getParameter( "chargeable_yn");
	store_code           =  request.getParameter( "store_code"   );
	item_desc            =  CommonBean.checkForNull(request.getParameter("item_desc"),"");
	item_code            =  request.getParameter("item_desc").equals("")? "%": request.getParameter("item_code");
	from_doc_date        =  CommonBean.checkForNull(request.getParameter("from_doc_date"),"");
	to_doc_date          =  CommonBean.checkForNull(request.getParameter("to_doc_date"),"");

	if(!(from_doc_date.equals("")))
	  from_doc_date		 =	DateUtils.convertDate(from_doc_date,"DMY",locale,"en");
	
	if(!(to_doc_date.equals("")))
	  to_doc_date			 =	DateUtils.convertDate(to_doc_date,"DMY",locale,"en");

	doc_no               =  CommonBean.checkForNull(request.getParameter("doc_no"),"%");

	
	batch_id        =  CommonBean.checkForNull(request.getParameter("batch_id"),"");
	expiry_date     =  CommonBean.checkForNull(request.getParameter("expiry_date"),"");	
	trade_id        =  CommonBean.checkForNull(request.getParameter("trade_id"),"");
	bin_location    =  CommonBean.checkForNull(request.getParameter("binlocation"),"");
	
	String barcode_yn     =	bean.checkForNull(bean.getBarcodeApplicable(),"N");
	System.out.println("barcode_yn==>"+barcode_yn);

	int no_deci                   =    bean.getNoOfDecimals();


    //String []stParameters = {patient_id,encounter_id,store_code,doc_no,from_doc_date,to_doc_date,patient_name}; 
	//String sql = "SELECT DISTINCT a.doc_no, a.doc_type_code, a.facility_id, A.PATIENT_NAME  FROM st_sal_hdr a,  st_sal_dtl b, st_sal_dtl_exp c, mm_item d, mm_bin_location e,  am_trade_name f  WHERE a.finalized_yn = 'Y'  /*AND a.billable_trn_yn = 'Y'*/  AND a.patient_id = ?  AND a.module_id = 'ST'  AND NVL (a.encounter_id, 1) = NVL (?, 1)  AND a.facility_id = b.facility_id  AND a.doc_type_code = b.doc_type_code  AND a.doc_no = b.doc_no  AND b.item_code = d.item_code  AND b.facility_id = c.facility_id  AND b.doc_type_code = c.doc_type_code  AND b.doc_no = c.doc_no  AND b.doc_srl_no = c.doc_srl_no  AND c.bin_location_code = e.bin_location_code  AND c.store_code = e.store_code  AND c.trade_id = f.trade_id(+) AND (NVL (c.sal_item_qty, 0) - NVL (c.ret_item_qty, 0)) > 0  AND a.store_code = ? AND a.doc_no like ?  AND a.doc_date BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'dd/mm/yyyy' )  AND NVL (TO_DATE (?, 'dd/mm/yyyy'), SYSDATE)  AND (A.PATIENT_NAME IS NULL OR UPPER(A.PATIENT_NAME) like UPPER (?))";

	String []stParameters = {patient_id,encounter_id,store_code,from_doc_date,to_doc_date,patient_name};
	String sql = "SELECT DISTINCT a.doc_no, a.doc_type_code, a.facility_id, A.PATIENT_NAME  FROM st_sal_hdr a,  st_sal_dtl b, st_sal_dtl_exp c, mm_item d, mm_bin_location e,  am_trade_name f  WHERE a.finalized_yn = 'Y'  /*AND a.billable_trn_yn = 'Y'*/  AND a.patient_id = ?  AND a.module_id = 'ST'  AND NVL (a.encounter_id, 1) = NVL (?, 1)  AND a.facility_id = b.facility_id  AND a.doc_type_code = b.doc_type_code  AND a.doc_no = b.doc_no  AND b.item_code = d.item_code  AND b.facility_id = c.facility_id  AND b.doc_type_code = c.doc_type_code  AND b.doc_no = c.doc_no  AND b.doc_srl_no = c.doc_srl_no  AND c.bin_location_code = e.bin_location_code  AND c.store_code = e.store_code  AND c.trade_id = f.trade_id(+) AND (NVL (c.sal_item_qty, 0) - NVL (c.ret_item_qty, 0)) > 0  AND a.store_code = ? AND a.doc_date BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'dd/mm/yyyy' )  AND NVL (TO_DATE (?, 'dd/mm/yyyy'), SYSDATE)  AND (A.PATIENT_NAME IS NULL OR UPPER(A.PATIENT_NAME) like UPPER (?))  ";

	
	if(doc_no != "%")
	{	
		sql = sql + " and a.doc_no = " + "'"+doc_no+"'" ;
	}
	if(item_code != "%")
	{	
		sql = sql + " and b.item_code = " + "'"+item_code+"'" ;
	}
	
	if(barcode_yn.equals("Y") && item_code != "%"){ 
		if(batch_id != "")
		{	
		sql = sql + " and c.batch_id = " + "'"+batch_id+"'" ;
		}
		if(expiry_date != "")
		{	
		sql = sql + " and to_char(c.expiry_date_or_receipt_date,'dd/mm/yyyy') = "+"'"+expiry_date+"'";
		}
		if(trade_id != "")
		{	
		sql = sql + " and c.trade_id = " + "'"+trade_id+"'" ;
		}
		if(bin_location != "")
		{	
		sql = sql + " and c.bin_location_code = " + "'"+bin_location+"'" ;
		}
	}

	System.out.println("sql==>"+sql);

	ArrayList alTemp = new ArrayList();
	alTemp =  bean.fetchRecords(sql,stParameters);
	System.out.println("alTemp==>"+alTemp);

	int total = alTemp.size();	
	if(total ==0){
		
            _bw.write(_wl_block9Bytes, _wl_block9);
		
	}
	HashMap hmExpData = new HashMap();
	
	for(int i=0;i<total;){		
		HashMap hm = (HashMap)alTemp.get(i);
		//String []stParameters1 = {patient_id,encounter_id,(String)hm.get("DOC_NO"),(String)hm.get("DOC_TYPE_CODE"),(String)hm.get("FACILITY_ID"),item_code};
		//34089 Start.
		//String []stParameters1 = {patient_id,encounter_id,(String)hm.get("DOC_NO"),(String)hm.get("DOC_TYPE_CODE"),(String)hm.get("FACILITY_ID")};
		String []stParameters1 = {login_user,patient_id,encounter_id,(String)hm.get("DOC_NO"),(String)hm.get("DOC_TYPE_CODE"),(String)hm.get("FACILITY_ID")};

		//34089 End.
		
		//ArrayList alExpData =  (ArrayList)bean.fetchRecords("SELECT   a.facility_id, a.doc_type_code, a.doc_no, a.store_code, a.patient_id, a.encounter_id, a.sal_trn_type, b.doc_srl_no, b.item_code, d.short_desc item_name, c.batch_id, TO_CHAR (c.expiry_date_or_receipt_date,'dd/mm/yyyy') expiry_date_or_receipt_date, c.trade_id, nvl(f.short_name,c.trade_id) trade_name, c.bin_location_code, e.short_desc bin_location,(NVL(c.sal_item_qty,0) - NVL (c.ret_item_qty, 0)) sal_item_qty, b.item_cost_value item_cost, d.gen_uom_code uom_code, g.expiry_yn expiry_yn, d.ps_item_yn stock_item_yn, g.REFUND_ALLOW_YN REFUND_ALLOW_YN, h.short_desc uom_desc  FROM st_sal_hdr a, st_sal_dtl b, st_sal_dtl_exp c, mm_item d, mm_bin_location e, am_trade_name f, st_item g, am_uom h WHERE a.finalized_yn = 'Y' /*AND a.billable_trn_yn = 'Y'*/  AND a.patient_id = ?  AND NVL (a.encounter_id, 1) = NVL (?, 1) AND a.doc_no = ? AND a.doc_type_code = ?  AND a.facility_id = ?  AND a.module_id = 'ST' AND a.facility_id = b.facility_id AND a.doc_type_code = b.doc_type_code  AND a.doc_no = b.doc_no  AND b.item_code = d.item_code  AND d.item_code = g.item_code AND b.facility_id = c.facility_id AND b.doc_type_code = c.doc_type_code  AND b.doc_no = c.doc_no AND b.doc_srl_no = c.doc_srl_no AND c.bin_location_code = e.bin_location_code  AND c.store_code = e.store_code AND c.trade_id = f.trade_id(+) AND h.uom_code = d.gen_uom_code  AND (NVL(c.sal_item_qty,0) - NVL (c.ret_item_qty, 0)) > 0  AND b.item_code like upper(?)  ORDER BY a.facility_id, a.doc_type_code, a.doc_no, b.doc_srl_no",stParameters1);
		//34089 Start.
		//ArrayList alExpData =  (ArrayList)bean.fetchRecords("SELECT   a.facility_id, a.doc_type_code, a.doc_no, a.store_code, a.patient_id, a.encounter_id, a.sal_trn_type, b.doc_srl_no, b.item_code, d.short_desc item_name, c.batch_id, TO_CHAR (c.expiry_date_or_receipt_date,'dd/mm/yyyy') expiry_date_or_receipt_date, c.trade_id, nvl(f.short_name,c.trade_id) trade_name, c.bin_location_code, e.short_desc bin_location,(NVL(c.sal_item_qty,0) - NVL (c.ret_item_qty, 0)) sal_item_qty, b.item_cost_value item_cost, d.gen_uom_code uom_code, g.expiry_yn expiry_yn, d.ps_item_yn stock_item_yn, g.REFUND_ALLOW_YN REFUND_ALLOW_YN, h.short_desc uom_desc,nvl(g.ALLOW_DECIMALS_YN,'N') ALLOW_DECIMALS_YN  FROM st_sal_hdr a, st_sal_dtl b, st_sal_dtl_exp c, mm_item d, mm_bin_location e, am_trade_name f, st_item g, am_uom h WHERE a.finalized_yn = 'Y' /*AND a.billable_trn_yn = 'Y'*/  AND a.patient_id = ?  AND NVL (a.encounter_id, 1) = NVL (?, 1) AND a.doc_no = ? AND a.doc_type_code = ?  AND a.facility_id = ?  AND a.module_id = 'ST' AND a.facility_id = b.facility_id AND a.doc_type_code = b.doc_type_code  AND a.doc_no = b.doc_no  AND b.item_code = d.item_code  AND d.item_code = g.item_code AND b.facility_id = c.facility_id AND b.doc_type_code = c.doc_type_code  AND b.doc_no = c.doc_no AND b.doc_srl_no = c.doc_srl_no AND c.bin_location_code = e.bin_location_code  AND c.store_code = e.store_code AND c.trade_id = f.trade_id(+) AND h.uom_code = d.gen_uom_code  AND (NVL(c.sal_item_qty,0) - NVL (c.ret_item_qty, 0)) > 0  ORDER BY a.facility_id, a.doc_type_code, a.doc_no, b.doc_srl_no",stParameters1);
		ArrayList alExpData =  (ArrayList)bean.fetchRecords("SELECT   a.facility_id, a.doc_type_code, a.doc_no, a.store_code, a.patient_id, a.encounter_id, a.sal_trn_type, b.doc_srl_no, b.item_code, d.short_desc item_name, c.batch_id, TO_CHAR (c.expiry_date_or_receipt_date,'dd/mm/yyyy') expiry_date_or_receipt_date, c.trade_id, nvl(f.short_name,c.trade_id) trade_name, c.bin_location_code, e.short_desc bin_location,(NVL(c.sal_item_qty,0) - NVL (c.ret_item_qty, 0)) sal_item_qty, b.item_cost_value item_cost, d.gen_uom_code uom_code, g.expiry_yn expiry_yn, d.ps_item_yn stock_item_yn, g.REFUND_ALLOW_YN REFUND_ALLOW_YN, h.short_desc uom_desc,nvl(g.ALLOW_DECIMALS_YN,'N') ALLOW_DECIMALS_YN,NVL((select 'Y' from MM_USER_MATERIAL_GROUP where material_group_code=d.material_group_code and user_id=? and EFF_STATUS='E'),'N') MATERIAL_GROUP_ACESS_YN  FROM st_sal_hdr a, st_sal_dtl b, st_sal_dtl_exp c, mm_item d, mm_bin_location e, am_trade_name f, st_item g, am_uom h WHERE a.finalized_yn = 'Y' /*AND a.billable_trn_yn = 'Y'*/  AND a.patient_id = ?  AND NVL (a.encounter_id, 1) = NVL (?, 1) AND a.doc_no = ? AND a.doc_type_code = ?  AND a.facility_id = ?  AND a.module_id = 'ST' AND a.facility_id = b.facility_id AND a.doc_type_code = b.doc_type_code  AND a.doc_no = b.doc_no  AND b.item_code = d.item_code  AND d.item_code = g.item_code AND b.facility_id = c.facility_id AND b.doc_type_code = c.doc_type_code  AND b.doc_no = c.doc_no AND b.doc_srl_no = c.doc_srl_no AND c.bin_location_code = e.bin_location_code  AND c.store_code = e.store_code AND c.trade_id = f.trade_id(+) AND h.uom_code = d.gen_uom_code  AND (NVL(c.sal_item_qty,0) - NVL (c.ret_item_qty, 0)) > 0  ORDER BY a.facility_id, a.doc_type_code, a.doc_no, b.doc_srl_no",stParameters1);
		
		//34089 End.
			System.out.println("alExpData==>"+alExpData);

        int alsize = alExpData.size();
		if ( alsize > 0 ){
		hmExpData.put((((String)hm.get("DOC_NO"))+((String)hm.get("DOC_TYPE_CODE"))),alExpData); //Modified for IN074078
		i++;
		}
		else{
        alTemp.remove(i);
		total--;
		}
	}	
//	int flag=0;
	String classValue			= "";

	
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(chargeable_yn));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(sal_trn_type));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(store_code));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(patient_name));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(total));
            _bw.write(_wl_block19Bytes, _wl_block19);
 
		String new_doc_no ="";
		String	new_doc_type_code =""; //added for  IN074078
		for(int i=0;i<total;i++ ){  
	        HashMap hmTemp = new HashMap();
            hmTemp = (HashMap)alTemp.get(i);
			sal_patient_name = bean.checkForNull((String)hmTemp.get("PATIENT_NAME"));
			ArrayList alBatchDetails = (ArrayList)hmExpData.get(((String)hmTemp.get("DOC_NO")+(String)hmTemp.get("DOC_TYPE_CODE"))); //modified for  IN074078
			int batchcount = alBatchDetails.size();
			new_doc_no = bean.checkForNull((String)hmTemp.get("DOC_NO"));
			new_doc_type_code = bean.checkForNull((String)hmTemp.get("DOC_TYPE_CODE")); //added for  IN074078

            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(bean.checkForNull((String)hmTemp.get("DOC_NO"))));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(batchcount));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(bean.checkForNull((String)hmTemp.get("DOC_TYPE_CODE"))));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(bean.checkForNull((String)hmTemp.get("DOC_TYPE_CODE"))));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block25Bytes, _wl_block25);
 if(sal_trn_type.equals("X")){
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(sal_patient_name));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(sal_patient_name));
            _bw.write(_wl_block31Bytes, _wl_block31);
}
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(new_doc_type_code));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(new_doc_type_code));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(new_doc_type_code));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(bean.checkForNull((String)hmTemp.get("DOC_NO"))));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(batchcount));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(new_doc_type_code));
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);

		     for(int j=0;j<alBatchDetails.size();j++){
			 HashMap hmBatchDetails = (HashMap)alBatchDetails.get(j);
			// System.out.println("hmBatchDetails==>"+hmBatchDetails);	

             //classValue	=	((flag%2)==0)?"QRYODD":"QRYEVEN";

			 if(barcode_yn.equals("Y")){ 
			 if(item_code.equals((String)hmBatchDetails.get("ITEM_CODE")) && batch_id.equals((String)hmBatchDetails.get("BATCH_ID")) && expiry_date.equals((String)hmBatchDetails.get("EXPIRY_DATE_OR_RECEIPT_DATE")) && trade_id.equals((String)hmBatchDetails.get("TRADE_ID")))
			 classValue	=	"STLIGHTPINK";
			 else if(item_code.equals((String)hmBatchDetails.get("ITEM_CODE")) && batch_id.equals("") && expiry_date.equals("") && trade_id.equals(""))	
			 classValue	=	"STLIGHTPINK";
			 else 
			 classValue	=	"QRYODD";
			}else{
			 if(item_code.equals((String)hmBatchDetails.get("ITEM_CODE")))
			 classValue	=	"STLIGHTPINK";
			 else
			 classValue	=	"QRYODD";			
			}


             String refund_allow_yn = bean.checkForNull((String)hmBatchDetails.get("REFUND_ALLOW_YN"));
	
	     if (refund_allow_yn.equals("Y")){
         
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(new_doc_type_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(j));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(new_doc_type_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(j));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(j));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(new_doc_type_code));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(batchcount));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(j));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(new_doc_type_code));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(new_doc_type_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(j));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(new_doc_type_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(j));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("DOC_TYPE_CODE"))));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(new_doc_type_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(j));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(new_doc_type_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(j));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("MATERIAL_GROUP_ACESS_YN"))));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("ITEM_NAME"))));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(new_doc_type_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(j));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(new_doc_type_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(j));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("ITEM_CODE"))));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(new_doc_type_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(j));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(new_doc_type_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(j));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(java.net.URLEncoder.encode(bean.checkForNull((String)hmBatchDetails.get("ITEM_NAME")))));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(new_doc_type_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(j));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(new_doc_type_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(j));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("ITEM_COST"))));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(new_doc_type_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(j));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(new_doc_type_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(j));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("EXPIRY_YN"))));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(new_doc_type_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(j));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(new_doc_type_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(j));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("REFUND_ALLOW_YN"))));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(new_doc_type_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(j));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(new_doc_type_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(j));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("STOCK_ITEM_YN"))));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(new_doc_type_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(j));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(new_doc_type_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(j));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("DOC_SRL_NO"))));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(new_doc_type_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(j));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(new_doc_type_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(j));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(j));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("TRADE_NAME"))));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(new_doc_type_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(j));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(new_doc_type_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(j));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("TRADE_ID"))));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(new_doc_type_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(j));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(new_doc_type_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(j));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("TRADE_NAME"))));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("BIN_LOCATION"))));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(new_doc_type_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(j));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(new_doc_type_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(j));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("BATCH_ID"))));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("BATCH_ID"))));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(new_doc_type_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(j));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(new_doc_type_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(j));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("EXPIRY_DATE_OR_RECEIPT_DATE"))));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("EXPIRY_DATE_OR_RECEIPT_DATE"))));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(new_doc_type_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(j));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(new_doc_type_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(j));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("BIN_LOCATION_CODE"))));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(new_doc_type_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(j));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(new_doc_type_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(j));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("BIN_LOCATION"))));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("SAL_ITEM_QTY"))));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(new_doc_type_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(j));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(new_doc_type_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(j));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("SAL_ITEM_QTY"))));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(new_doc_type_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(j));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(new_doc_type_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(j));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("ALLOW_DECIMALS_YN"),"N")));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("UOM_DESC"))));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(new_doc_type_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(j));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(new_doc_type_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(j));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("UOM_DESC"))));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(new_doc_type_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(j));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(new_doc_type_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(j));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("UOM_CODE"))));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(new_doc_type_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(j));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(new_doc_type_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(j));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(no_deci));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(new_doc_type_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(j));
            _bw.write(_wl_block116Bytes, _wl_block116);
}else { 
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(new_doc_type_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(j));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(new_doc_type_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(j));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("ITEM_NAME"))));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("TRADE_NAME"))));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("BIN_LOCATION"))));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("BATCH_ID"))));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("EXPIRY_DATE_OR_RECEIPT_DATE"))));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("SAL_ITEM_QTY"))));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchDetails.get("UOM_DESC"))));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block128Bytes, _wl_block128);
 }
}
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(i));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(new_doc_type_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(i));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(new_doc_no));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(new_doc_type_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(i));
            _bw.write(_wl_block133Bytes, _wl_block133);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(batchcount));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(new_doc_type_code));
            _bw.write(_wl_block136Bytes, _wl_block136);
 } 
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf((String)bean.getSal_Doc_Chkd()));
            _bw.write(_wl_block138Bytes, _wl_block138);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.TransactionDetails.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.selectall.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.item.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BinLocation.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BatchID.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.expiryDate.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.AvailableQty.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.SaleUOM.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReturnQty.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Add.label", java.lang.String .class,"key"));
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
}
