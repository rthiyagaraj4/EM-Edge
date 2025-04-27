package jsp_servlet._est._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eST.*;
import eST.Common.*;
import java.util.HashMap;
import java.util.ArrayList;
import eCommon.Common.*;
import java.util.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.lang.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __producttransferaddmodify extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/est/jsp/ProductTransferAddModify.jsp", 1733592536676L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' ></link>\n<!--<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/IeStyle.css\"></link> -->\n\t<link rel=\"stylesheet\" type =\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n <!--<script language=\"javascript\" src=\"../../eCommon/js/messages.js\"></script> -->\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n<!--<script language=\"javascript\" src=\"../../eST/js/StMessages.js\"></script> -->\n\t<script language=\"javascript\" src=\"../../eST/js/StCommon.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eST/js/StTransaction.js\"></script>\n\t<script language=\"javaScript\" src=\"../../eST/js/ProductTransfer.js\"></script> \n\t<script language=\"JavaScript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t<script language=\"Javascript\" src=\"../../eCommon/js/DateUtils.js\"></script> <!-- IN0037673-SRR20056-SCF-9532 -->\n\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<body onLoad=\"FocusFirstElement();\">\n<form name=\"formProductTransferAddModify\" id=\"formProductTransferAddModify\" onReset=\"FocusFirstElement();\">\n\n<table border=\"0\" cellpadding=\"2\" cellspacing=\"0\" width=\'100%\'  align=center>\n\n\t<tr>\n\t   <th  colspan=10>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</th>\n\t</tr>\n\n\t<!-- <tr>\n\t  <td colspan=10>&nbsp;</td>\n    </tr> -->\n\n\t<!-- <tr>\n\t<td align=\"right\" class=\"LABEL\"  colspan=6 nowrap>&nbsp;&nbsp;&nbsp;&nbsp;Prepare Location</td>\n\t \n\t\n\t<td align=\'left\' >&nbsp;<select name=\'prep_loc\' id=\'prep_loc\' >";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</select></td>\n\t<td align=\"left\" class=\"LABEL\"  nowrap>&nbsp;&nbsp;&nbsp;</td>\n\t<td align=\"left\" class=\"LABEL\"  nowrap>&nbsp;</td>\n\t\n\t</tr> -->\n\n\n\t<tr>\n\t <td  class=\"LABEL\"><label id=\'lblItem\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</label></td>\n\t  <td class=\'FIELDS\'  colspan=3>&nbsp;&nbsp;\n\t  <!--<input maxLength=60 size=70 name=\"p_fm_item_desc\" id=\"p_fm_item_desc\" value=\"\" onBlur=\'fn_check_for_item_validation_from()\'> -->\n\t<!--Added for ML-MMOH-CRF-0448 B.Badmavathi starts -->\n\t  ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t  <input type=text name=\"p_fm_item_desc\" id=\"p_fm_item_desc\" size=70 maxlength=60 size=70 onkeypress=\"callBarCodeBatchSearchproduct(event, trn_type,parent.frameProductTransferHeader.document.formProductTransferHeader.store_code,\'\',this.form,\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\',\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'); \"    value=\"\"   onBlur=\'fn_check_for_item_validation_from()\' ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =">\n\t  ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t  <!--Added for ML-MMOH-CRF-0448 B.Badmavathi end -->\n\t  <input type=text name=\"p_fm_item_desc\" id=\"p_fm_item_desc\" size=70 maxlength=60 size=70 onkeypress=\"callBarCodeBatchSearchproduct(event, trn_type,parent.frameProductTransferHeader.document.formProductTransferHeader.store_code,\'\',this.form,\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'); \"    value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\"   onBlur=\'fn_check_for_item_validation_from()\' ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =">\n\t  <!--Added for ML-MMOH-CRF-0448 B.Badmavathi starts-->\n\t  ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'); \"    value=\"\"   onBlur=\'fn_check_for_item_validation_from()\' >\n\t  ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t  <input type=button name=\"item_search_from\" id=\"item_search_from\" class=\"button\"  onClick=\"callItemSearchScreenFrom(event,trn_type,parent.frameProductTransferHeader.document.formProductTransferHeader.store_code,\'\' ,this.form,\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\');\"  value=\'?\' ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" >&nbsp;<img src=\'../../eCommon/images/mandatory.gif\' ></td>\n\t  <!--added for ML-MMOH-CRF-0448 B.Badmavathi ends-->\n\t <!-- <input type=button name=\"item_search_from\" id=\"item_search_from\" class=\"button\" onClick=\"callItemSearchScreenFrom()\"  value=\'?\'  >&nbsp;<img src=\'../../eCommon/images/mandatory.gif\' ></td> -->\n      <!--Added for ML-MMOH-CRF-0448 B.Badmavathi starts -->\n      ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n      \n     <td class=\"LABEL\" >";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="&nbsp;&nbsp;<b>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</b>\n      ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n      <!--Added for ML-MMOH-CRF-0448 B.Badmavathi  ends-->\n      <td id=fm_item_uom_desc  class=\'LABEL\'  width=\'15%\' style=\"visibility:visible\">&nbsp;</td>\n     <!--Added for ML-MMOH-CRF-0448 B.Badmavathi starts -->\n      ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =" \n\t ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t  <td class=\'FIELDS\'><input type=button name=\"batch_search_from\" id=\"batch_search_from\" class=\"button\"   disabled  onclick=\"callBatchSearchFrom();\"  value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'></td>\n\t ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t <!--Added for ML-MMOH-CRF-0448 B.Badmavathi ends -->\n\t  <td class=\'FIELDS\'><input type=button name=\"batch_search_from\" id=\"batch_search_from\" class=\"button\"     onclick=\"callBatchSearchFrom();\" disabled value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'></td>\n\t  ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="<!--Added for ML-MMOH-CRF-0448 B.Badmavathi -->\n\t  <td  class=\"LABEL\">&nbsp;</td>\n\t  <td  class=\"LABEL\">&nbsp;</td>\n    </tr>\n\n\t<tr>\n\t  <td colspan=10>&nbsp;</td>\n    </tr>\n    \t\n<!-- \t<TR>\n\t  <td id=fm_display_dtl_1 class=\"LABEL\" colspan=10 align=left nowrap>&nbsp;</td>\n\t</tr>\n -->\n     <tr>\n\t  <td id=fm_display_dtl_1_bl class=\"LABEL\"  nowrap>&nbsp;</td>\n\t  <td id=fm_display_dtl_1_bt class=\"LABEL\"  nowrap>&nbsp;</td>\n\t  <td id=fm_display_dtl_1_el class=\"LABEL\"  nowrap>&nbsp;</td>\n\t  <td id=fm_display_dtl_1_et class=\"LABEL\"  nowrap colspan=\'3\'>&nbsp;</td>\n\t  <td id=fm_display_slp_1_el class=\"LABEL\"   nowrap>&nbsp;</td>\n\t  <td id=fm_display_slp_1_et class=\"LABEL\"   nowrap >&nbsp;</td>\n\n\t</tr>\n\t<tr>\n\t  <td colspan=10>&nbsp;</td>\n    </tr>\n\n    <tr>\n\t  <td id=fm_display_dtl_2 class=\"LABEL\" colspan=2  nowrap>&nbsp;</td>\n      <td  class=\"LABEL\">";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</td>\n\t <!--Added for ML-MMOH-CRF-0448 B.Badmavathi  starts -->\n\t  ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t  <td class=\'FIELDS\' >&nbsp;&nbsp;<input class=\"NUMBER\" onkeypress=\"return isValidNumber(this,event,6,0);\" maxLength=6 size=18 name=\"p_fm_factor\" id=\"p_fm_factor\" value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\"  onBlur=\"return CheckForZeroFrom(this);\">&nbsp;<img src=\'../../eCommon/images/mandatory.gif\' ></td>\n\t  ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t  <td class=\'FIELDS\' >&nbsp;&nbsp;<input class=\"NUMBER\" onkeypress=\"return isValidNumber(this,event,6,0);\" maxLength=6 size=18 name=\"p_fm_factor\" id=\"p_fm_factor\" value=\"1\"  onBlur=\"return CheckForZeroFrom(this);\">&nbsp;<img src=\'../../eCommon/images/mandatory.gif\' ></td>\n\t  ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =" \n\t  ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t  <!--Added for ML-MMOH-CRF-0448 B.Badmavathi  ends-->\n\t  <td  class=\"LABEL\" nowrap>";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="&nbsp;&nbsp;<input class=\"NUMBER\" maxLength=12 size=12 name=\"p_fm_quantity\" id=\"p_fm_quantity\" value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" onkeypress=\"return isValidNumber(this,event,7,";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 =");\" onBlur=\"return checkWithAvlQty(this)\" disabled>&nbsp;<img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></td>\n\t <!--Added for ML-MMOH-CRF-0448 B.Badmavathi starts --> \n\t  ";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t  <td  class=\"LABEL\" nowrap>";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="&nbsp;&nbsp;<input class=\"NUMBER\" maxLength=12 size=12 name=\"p_fm_quantity\" id=\"p_fm_quantity\" value=\"\" onkeypress=\"return isValidNumber(this,event,7,";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 =");\" onBlur=\"return checkWithAvlQty(this)\">&nbsp;<img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></td>\n\t  ";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t  <!--Added for ML-MMOH-CRF-0448 B.Badmavathi ends -->\n\t  <td  class=\"LABEL\" nowrap>&nbsp;</td>\n\t  <td  class=\"LABEL\" nowrap>&nbsp;&nbsp;&nbsp;&nbsp;</td>\n\t</tr>\n\t\n   \t<tr>\n\t  <td colspan=10>&nbsp;</td>\n    </tr>\n\t\n      \n   <tr>\n\t   <th  colspan=10>";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</th>\n   </tr>  \n\n   \n\n   <tr>\n\t  <td  class=\"LABEL\"><label id=\'lblItem_2\'>";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</label></td>\n\t<!--Added for ML-MMOH-CRF-0448 B.Badmavathi starts -->\n\t ";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t  <td  class=\'FIELDS\' colspan=4>&nbsp;&nbsp;<input maxLength=60 size=70 name=\"p_to_item_desc\" id=\"p_to_item_desc\" value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\"   disabled><input type=button name=\"item_search_to\" id=\"item_search_to\" class=\"button\" onClick=\"callItemSearchScreenTo()\"   value=\'?\' disabled>&nbsp;<img src=\'../../eCommon/images/mandatory.gif\' ></td>\n\t  ";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t  <!--Added for ML-MMOH-CRF-0448 B.Badmavathi ends-->\n\t  <td  class=\'FIELDS\' colspan=4>&nbsp;&nbsp;<input maxLength=60 size=70 name=\"p_to_item_desc\" id=\"p_to_item_desc\" value=\"\"   disabled><input type=button name=\"item_search_to\" id=\"item_search_to\" class=\"button\" onClick=\"callItemSearchScreenTo()\"   value=\'?\' disabled>&nbsp;<img src=\'../../eCommon/images/mandatory.gif\' ></td>\n  <!--Added for ML-MMOH-CRF-0448 B.Badmavathi starts-->\n\t  ";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t  \n\t  ";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n        <!--Added for ML-MMOH-CRF-0448 B.Badmavathi ends-->\n      <td id=to_item_uom_desc   class=label ></td>\n      ";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="   <!--Added for ML-MMOH-CRF-0448 B.Badmavathi -->\n      \n      \n  \t  \n\t  <td class=LABEL >&nbsp;</td>\n\t  <td class=LABEL >&nbsp;</td>\n    </tr>\n       <!-- Modified maxlength to 20 against ML-BRU-SCF-1720 starts -->\n\t<tr>\n\t  <td id=to_batch_id_name class=\"LABEL\" >";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="</td>\n\t     <!--Added for ML-MMOH-CRF-0448 B.Badmavathi starts-->\n\t   ";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t    <td id=to_batch_id_val class=\'FIELDS\'>&nbsp;&nbsp;<input maxLength=20 size=10 name=\"p_to_batch_id\" id=\"p_to_batch_id\" class=\"UPPER\" value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\" disabled onKeyPress=\"return CheckForSpecChars(event);\" >&nbsp;<img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'  id=\"imgs\" style=\"visibility:visible\">\n\t      ";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t        <!--Added for ML-MMOH-CRF-0448 B.Badmavathi ends-->\n\t  ";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n      <td id=to_batch_id_val class=\'FIELDS\'>&nbsp;&nbsp;<input maxLength=20 size=10 name=\"p_to_batch_id\" id=\"p_to_batch_id\" class=\"UPPER\"  value=\"\" onKeyPress=\"return CheckForSpecChars(event);\"  onBlur=\"NewBarcodeid(\'ProductTransferBean\',\'eST.ProductTransferBean\',\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\',to_item_code,p_to_batch_id, p_to_expiry_date, to_trade_id, p_to_bin_location,store_code, to_barcode_id,p_actual_qty,sale_price)\" disabled>&nbsp;<img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'  id=\"imgs\" style=\"visibility:visible\">\n\t   ";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 =" \n\t   <td id=to_batch_id_val class=\'FIELDS\'>&nbsp;&nbsp;<input maxLength=20 size=10 name=\"p_to_batch_id\" id=\"p_to_batch_id\" class=\"UPPER\"  value=\"\" onKeyPress=\"return CheckForSpecChars(event);\" disabled>&nbsp;<img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'  id=\"imgs\" style=\"visibility:visible\">\n\t   ";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="  <!--Added for ML-MMOH-CRF-0448 B.Badmavathi -->\n\t          <!-- Modified maxlength to 20 against ML-BRU-SCF-1720 ends -->\n      <td class=\"LABEL\"  nowrap id=to_expiry_date_id>&nbsp;";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="</td> \n\t    <!--Added for ML-MMOH-CRF-0448 B.Badmavathi starts-->\n\t   ";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t    <td class=\'FIELDS\'>&nbsp;&nbsp;<input type=\'text\' onBlur=\"CheckDateLeap(this,\'DMY\',\'";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\')\" maxLength=10 size=18 name=\"p_to_expiry_date\" value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\" >&nbsp;\n\t  <img src=\"../../eCommon/images/CommonCalendar.gif\" id=Calendar onClick=\"return  showCalendar(\'p_to_expiry_date\');\" ></img>\n\t  &nbsp;<img src=\'../../eCommon/images/mandatory.gif\' >&nbsp;&nbsp;&nbsp;</td> \n\t   ";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t     <!--Added for ML-MMOH-CRF-0448 B.Badmavathi ends-->\n\t   ";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n      <td class=\'FIELDS\'>&nbsp;&nbsp;<input type=\'text\' onBlur=\"CheckDateLeap(this,\'DMY\',\'";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\'); NewBarcodeid(\'ProductTransferBean\',\'eST.ProductTransferBean\',\'";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\',to_item_code,p_to_batch_id,p_to_expiry_date,to_trade_id,p_to_bin_location,store_code,to_barcode_id,p_actual_qty,sale_price);\" maxLength=10 size=18 name=\"p_to_expiry_date\" id=\"p_to_expiry_date\" value=\"\" disabled>&nbsp;<img src=\"../../eCommon/images/CommonCalendar.gif\" id=Calendar onClick=\"return  showCalendar(\'p_to_expiry_date\');\"  disabled></img>&nbsp;<img src=\'../../eCommon/images/mandatory.gif\' >&nbsp;&nbsp;&nbsp;</td> <!--changed from CheckDate() to CheckDateLeap() for SRR20056-SCF-9532 [IN037673] -->\n\t   ";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 =" \n\t   <td class=\'FIELDS\'>&nbsp;&nbsp;<input type=\'text\' onBlur=\"CheckDateLeap(this,\'DMY\',\'";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\')\" maxLength=10 size=18 name=\"p_to_expiry_date\"  id=\"p_to_expiry_date\" value=\"\" disabled>&nbsp;\n\t  <img src=\"../../eCommon/images/CommonCalendar.gif\" id=Calendar onClick=\"return  showCalendar(\'p_to_expiry_date\');\" disabled></img>\n\t  &nbsp;<img src=\'../../eCommon/images/mandatory.gif\' >&nbsp;&nbsp;&nbsp;</td> <!-- changed CheckDate() to CheckDateLeap() for SRR20056-SCF-9532 [IN037673] -->\n\t   ";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="  \n     \n     ";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n     \t <td class=\"LABEL\" >";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="</b>\n     \n     ";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n      \t<td id=\"to_trade_dtl\" class=\"LABEL\"  nowrap>&nbsp;</td>\n      ";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\t <!--Added for ML-MMOH-CRF-0448 B.Badmavathi -->\n\t  ";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\t  <td class=\"LABEL\" nowrap>";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="&nbsp;<input type=text name=\"sale_price\" id=\"sale_price\" value=\"\" size=12 maxlength=12 class=\"NUMBER\" onKeyPress=\"return isValidNumber(this,event,7,";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 =");\" onblur=\"\"><img src=\'../../eCommon/images/mandatory.gif\' ></td>\n\t  ";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="     \n    </tr>\n\t<tr>\n\t  <td class=\"LABEL\" >";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="</td>\n\t    <!--Added for ML-MMOH-CRF-0448 B.Badmavathi starts-->\n\t   ";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\n\t    \n\t  <td class=\'FIELDS\'>&nbsp;&nbsp;<select name=\"p_to_bin_location\" id=\"p_to_bin_location\" >";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 =" </select>&nbsp;<img src=\'../../eCommon/images/mandatory.gif\' ></td> \n\t  \n\t   \n\t ";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n\t   <!--Added for ML-MMOH-CRF-0448 B.Badmavathi ends-->\n\t  ";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\n\t  <td class=\'FIELDS\'>&nbsp;&nbsp;<select name=\"p_to_bin_location\" id=\"p_to_bin_location\"  onchange =\"NewBarcodeid(\'ProductTransferBean\',\'eST.ProductTransferBean\',\'";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\',to_item_code,p_to_batch_id,p_to_expiry_date,to_trade_id,p_to_bin_location,store_code,to_barcode_id,p_actual_qty,sale_price);\"  onfocus=\'populateBinLocation();\' disabled>";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="</select>&nbsp;<img src=\'../../eCommon/images/mandatory.gif\' ></td>  \n\t    ";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 =" \n\t  <td class=\'FIELDS\'>&nbsp;&nbsp;<select name=\"p_to_bin_location\" id=\"p_to_bin_location\"  onfocus=\'populateBinLocation();\' disabled>";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="</select>&nbsp;<img src=\'../../eCommon/images/mandatory.gif\' ></td> \n\t   ";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\n\t ";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="  <!--Added for ML-MMOH-CRF-0448 B.Badmavathi -->\n\t  <td  class=\"LABEL\">";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\n\t  <td class=\'FIELDS\'>&nbsp;&nbsp;<input class=\"NUMBER\" onkeypress=\"return isValidNumber(this,event,12,6);\" maxLength=12 size=18 name=\"p_to_factor\" id=\"p_to_factor\" value=\"";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\"  onBlur=\"return CheckForZeroFrom(this);\" >&nbsp;<img src=\'../../eCommon/images/mandatory.gif\' ></td>\n\t\t";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\n\t\t  <!--Added for ML-MMOH-CRF-0448 B.Badmavathi ends-->\n\t\t<td class=\'FIELDS\'>&nbsp;&nbsp;<input class=\"NUMBER\" onkeypress=\"return isValidNumber(this,event,12,6);\" maxLength=12 size=18 name=\"p_to_factor\" id=\"p_to_factor\" value=\"1\"  onBlur=\"return CheckForZeroFrom(this);\" disabled>&nbsp;<img src=\'../../eCommon/images/mandatory.gif\' ></td>\n\t\t";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="  <!--Added for ML-MMOH-CRF-0448 B.Badmavathi -->\n\t\t \n\t\t<td  id=p_to_quantity width=\'5%\' class=\"LABEL\" >";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="</td>\n\t\t<td class=\"LABEL\" nowrap>";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="&nbsp;<input type=text name=p_actual_qty value=\"\" size=12 maxlength=12 class=\"NUMBER\" onKeyPress=\"return isValidNumber(this,event,7,";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 =");\" onblur=\"computeLabel();\"><img src=\'../../eCommon/images/mandatory.gif\' ></td>\n\t\t<td  class=\'LABEL\' ></td> \n      </tr>\n\t  \n\t\t<tr>\n\t\t<!--//Added for ML-MMOH-CRF-0448 B.Badmavathi starts-->\n\t\t";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\n       ";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\n\t  <td class = \'LABEL\'>";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="</td>\n\t <td  class=\'fields\'  >&nbsp;&nbsp;<input type=text name=\"to_barcode_id\" id=\"to_barcode_id\" size=15 maxlength=20 class=\"NUMBER\"  onKeyPress=\"return  CheckForSpecialChars(event);\" onBlur=\"\"  value=\"";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\" ></td>\t\n     ";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\t \n\t  <td class=LABEL >";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 =" \n\t  <input type=\'radio\' id=\"label_reqd_yn_1\"  name=\"label_reqd_yn\" id=\"label_reqd_yn\"  value=\"B\" onClick=\"no_of_labels.disabled=!this.checked;enabledisable(); setreport();\">\n\t  </td>\n\t  <td class=LABEL >";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 =" \n\t  <input type=\'radio\'  id=\"label_reqd_yn_2\"  name=\'label_reqd_yn\' id=\'label_reqd_yn\'  value=\"L\" onClick=\"no_of_labels.disabled=!this.checked;enabledisable(); setreport();\">\n\t  </td>\n\t  ";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\n\t      <td class=LABEL >";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="</td>\n\t     <!--  Added for no of labels start -->\n\t";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\n\t\t\t<td  class=\'fields\' >&nbsp;<input type=\"checkbox\" name=\'label_reqd_yn\' id=\'label_reqd_yn\' id=\"label_reqd_yn_2\" value=\"N\" checked  onClick=\"checklabelyn(); setreport();\" ></td>\n\t\t\t";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\n\t\t\t<td  class=\'fields\' >&nbsp;<input type=\"checkbox\" name=\'label_reqd_yn\' id=\'label_reqd_yn\' id=\"label_reqd_yn_2\" value=\"N\"  onClick=\"no_of_labels.disabled=!this.checked;checklabelyn(); setreport();\" ></td>\n\t\t";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\n\t\t<!--  Added for no of labels end -->\n\t\t\n\t  ";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\n\t <td  class=\'LABEL\'>";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 =" \n\t\t <input type=text name=\'no_of_labels\' id=\'no_of_labels\' size=10 maxlength=15 class=\"NUMBER\" onKeyPress=\"return isValidInteger();\"  value=\"";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\" disabled></td>\n\t\t<td  class=\'LABEL\'  id=p_expect_bal_qty  width=\'5%\' >";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="</td>\n\t\t<td  class=\'LABEL\' nowrap>";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="&nbsp;<input type=text name=p_expect_act_qty value=\"";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\" size=12 maxlength=12 class=\"NUMBER\"   onKeyPress=\"return isValidNumber(this,event,7,";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 =");\"   onblur=\'checkForValidFactor();\' ><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></td>\n\t\t<td  class=LABEL></td>\n\t\t ";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\n\t\t <td class=LABEL >";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="</td>\n\t\t \n\t\t <!--for hsa  no of labels start -->\n\t\t ";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\n\t\t\t<td  class=\'FIELDS\' >&nbsp;<input type=\"checkbox\" name=\'label_reqd_yn\' id=\'label_reqd_yn\' id=\"label_reqd_yn_2\" value=\"N\" checked  onClick=\"checklabelyn(); setreport();\" ></td>\n\t\t\t";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\n\t\t\t\n\t\t\t<td  class=\'FIELDS\' >&nbsp;<input type=\"checkbox\" name=\'label_reqd_yn\' id=\'label_reqd_yn\' id=\"label_reqd_yn_2\" value=\"N\" onClick=\"no_of_labels.disabled=!this.checked;checklabelyn(); setreport();\"></td>\n\t\t";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\n\t\t <!--for hsa  no of labels start -->\n\t\t \n\t\t<!--<td  class=\'fields\' >&nbsp;<input type=\"checkbox\" name=\'label_reqd_yn\' id=\'label_reqd_yn\' id=\"label_reqd_yn_2\" value=\"N\" onClick=\"no_of_labels.disabled=!this.checked;checklabelyn(); setreport();\"></td> for hsa -->\n\t\t<td  class=\'LABEL\'>";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="</td>\n\t\t<td   class=\'fields\'>&nbsp;&nbsp;<input type=text name=\'no_of_labels\' id=\'no_of_labels\' size=10 maxlength=15 class=\"NUMBER\" onKeyPress=\"return isValidInteger();\"  value=\"";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\" size=12 maxlength=12 class=\"NUMBER\"   onKeyPress=\"allow_restrict_decimals(this,event);\"   onblur=\'checkForValidFactor();\' ><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></td>\n\t\t<td  class=LABEL></td>\n\t\t \n\t\t ";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\n\t\t ";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\n\t\t <!--//Added for ML-MMOH-CRF-0448 B.Badmavathi ends-->\n\t\t        ";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="</td>\n\t <td  class=\'fields\'  >&nbsp;&nbsp;<input type=text name=\"to_barcode_id\" id=\"to_barcode_id\" size=15 maxlength=20 class=\"NUMBER\"  onKeyPress=\"return  CheckForSpecialChars(event);\" onBlur=\"\"  ";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="  ></td>\t\n     ";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="</td>\n\t\t<td  class=\'fields\' >&nbsp;<input type=\"checkbox\" name=\'label_reqd_yn\' id=\'label_reqd_yn\' id=\"label_reqd_yn_2\" value=\"N\" onClick=\"no_of_labels.disabled=!this.checked;checklabelyn(); setreport();\"></td>\n\t  ";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\" ></td><!--Changed for ML-MMOH-CRF-0448 B.Badmavathi -->\n\t\t<td  class=\'LABEL\'  id=p_expect_bal_qty  width=\'5%\' >";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="&nbsp;<input type=text name=p_expect_act_qty value=\"\" size=12 maxlength=12 class=\"NUMBER\"   onKeyPress=\"return isValidNumber(this,event,7,";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="</td>\n\t\t<td  class=\'fields\' >&nbsp;<input type=\"checkbox\" name=\'label_reqd_yn\' id=\'label_reqd_yn\' id=\"label_reqd_yn_2\" value=\"N\" onClick=\"no_of_labels.disabled=!this.checked;checklabelyn(); setreport();\"></td>\n\t\t<td  class=\'LABEL\'>";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="&nbsp;<input type=text name=p_expect_act_qty value=\"\" size=12 maxlength=12 class=\"NUMBER\"   onKeyPress=\"allow_restrict_decimals(this,event);\"   onblur=\'checkForValidFactor();\' ><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></td>\n\t\t<td  class=LABEL></td>\n\t\t \n\t\t ";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="<!--Added for ML-MMOH-CRF-0448 B.Badmavathi -->\n\t\t ";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\n\t\t<!-- <td align=\'right\'class=\'LABEL\' colspan=3></td>\n\t\t<td align=\'left\'class=\'LABEL\' ></td>\n\t\t<td align=\'left\' class=\'LABEL\'  id=p_expect_bal_qty  width=\'5%\' >Expect Bal Qty</td>\n\t\t<td align=\'left\' class=\'LABEL\' nowrap>Actual Bal Qty\n\t\t<input type=text name=p_expect_act_qty value=\"\" size=7 maxlength=8 class=\"NUMBER\" onKeyPress=\"return isValidNumber(this,event,";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 =",0);\"  onblur=\'checkForValidFactor();\' ></td>\n\t\t<td align=\'right\' class=\'LABEL\' ></td> -->\n\t</tr>\n\n    \n<tr>\n\t\t<th  colspan=\'10\'>";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="</th>\t\n    </tr>\n  \n    <!-- <tr>\n\t\t<td align=\"right\" class=\"LABEL\">Packed By</td>\n\t\t<td class=LABEL colspan=9>&nbsp;&nbsp;<input maxLength=30 size=30 name=\"p_packed_by\" id=\"p_packed_by\" value=\"";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\" readOnly></td>\n\t</tr> -->\n\t<!--//Added for ML-MMOH-CRF-0448 B.Badmavathi starts-->\n";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\n\t<tr>\n\t\t<td  class=LABEL>";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="&nbsp;</td>\n\t\t<td class=\'fields\' colspan=9>&nbsp;&nbsp;<TEXTAREA id=TEXTAREA1 cols=95 rows=2 name=\'remarks\' onKeyPress=\"return false;\" disabled>";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="</TEXTAREA><input type=\"hidden\" name=\"remarks_code_1\" id=\"remarks_code_1\" value = \"\" >\t\n\t\t<input type=\'button\' class=\'BUTTON\' name=\'remark\' id=\'remark\' value=\'?\' onClick=\"searchRemarks(remarks_code_1,remarks);\"></td>\n\t</tr>\n\t<tr>\n\t\t<td  class=\"LABEL\"  nowrap>";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="</td>\n\t\t<td class=\'fields\' colspan=2>&nbsp;&nbsp;<input maxLength=30 size=35 name=\"p_packed_by\" id=\"p_packed_by\" value=\"";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\" ></td>\n\t\t<td  class=\"LABEL\" nowrap >";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 =" </td>\n\t\t<td  class=\'fields\' nowrap colspan=2>&nbsp;&nbsp;<input type=\'text\' maxLength=30 size=35 name=\"p_counter_chk\" id=\"p_counter_chk\" value=\"";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\" ></td>\n\n\t\t\n\t\t<td  class=\"LABEL\" nowrap>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n    </tr>\n\t<tr>\n\t\t<td  class=\"LABEL\" nowrap>";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="</td>\n\t\t<td  class=\'fields\' colspan=2>&nbsp;&nbsp;<input name=\'time_taken\' id=\'time_taken\' maxLength=5 size=3 onKeyPress=\'return allowValidNumber(event);\' onblur=\'validateLength(this);chkCustomTime(this);\' value=\"";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\" >&nbsp;";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="</td>\n\t\t<td  class=\"LABEL\" nowrap >";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="</td>\n\t\t<td class=\'fields\' colspan=2>&nbsp;&nbsp;<input maxLength=30 size=35 name=\"p_auth_by\" id=\"p_auth_by\" value=\"";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\" ></td>\n\t\t<td  class=\"LABEL\" nowrap>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n\t\t\n\t</tr>\n\t";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\n\t<!--//Added for ML-MMOH-CRF-0448 B.Badmavathi ends-->\n\t<tr>\n\t\t<td  class=LABEL>";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="&nbsp;</td>\n\t\t<td class=\'fields\' colspan=9>&nbsp;&nbsp;<TEXTAREA id=TEXTAREA1 cols=95 rows=2 name=\'remarks\' onKeyPress=\"return false;\" disabled></TEXTAREA><input type=\"hidden\" name=\"remarks_code_1\" id=\"remarks_code_1\" value = \"\" >\n\t\t<input type=\'button\' class=\'BUTTON\' name=\'remark\' id=\'remark\' value=\'?\' onClick=\"searchRemarks(remarks_code_1,remarks);\"></td>\n\t</tr>\n\t<tr>\n\t\t<td  class=\"LABEL\"  nowrap>";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\" ></td>\n\t\t<td  class=\"label\" nowrap >";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 =" </td>\n\t\t<td  class=\'fields\' nowrap colspan=2>&nbsp;&nbsp;<input type=\'text\' maxLength=30 size=35 name=\"p_counter_chk\" id=\"p_counter_chk\" value=\"\" ></td>\n\n\t\t\n\t\t<td  class=\"LABEL\" nowrap>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n    </tr>\n\t<tr>\n\t\t<td  class=\"LABEL\" nowrap>";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="</td>\n\t\t<td  class=\'fields\' colspan=2>&nbsp;&nbsp;<input name=\'time_taken\' id=\'time_taken\' value=\"\"  maxLength=5 size=3 onKeyPress=\'return allowValidNumber(event);\' onblur=\'validateLength(this);chkCustomTime(this);\' >&nbsp;";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="</td>\n\t\t<td class=\'fields\' colspan=2>&nbsp;&nbsp;<input maxLength=30 size=35 name=\"p_auth_by\" id=\"p_auth_by\" value=\"\" ></td>\n\t\t<td  class=\"label\" nowrap>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n\t\t\n\t</tr>\n\t";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="<!--//Added for ML-MMOH-CRF-0448 B.Badmavathi -->\n       ";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\n\t   <td  class=\'fields\'><input type=hidden name=\"sale_price\" id=\"sale_price\"></td>\n\t   ";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\n</table>\n\n\t\t\n\t\t<input type=\"hidden\"\tname=\"fm_uom_code\" id=\"fm_uom_code\"\t\t\t\t\t\tvalue=\"\">\n\t\t<input type=\"hidden\"\tname=\"to_uom_code\" id=\"to_uom_code\"\t\t\t\t\t\tvalue=\"\">\n\t\t<input type=\"hidden\"\tname=\"repack_group1\" id=\"repack_group1\"\t\t\t\t\tvalue=\"\">\n\t\t<input type=\"hidden\"\tname=\"repack_group2\" id=\"repack_group2\"\t\t\t\t\tvalue=\"\">\n\t\t<input type=\"hidden\"\tname=\"eqvlvalue\" id=\"eqvlvalue\"\t\t\t\t\t\tvalue=\"\">\n\t\t<input type=\"hidden\"\tname=\"fm_bin_location_code\" id=\"fm_bin_location_code\"\t\t\t\tvalue=\"\">\n\t\t<input type=\"hidden\"\tname=\"p_act_expect_bal_qty\" id=\"p_act_expect_bal_qty\"\t\t\t\tvalue=\"\">\n\t\t<input type=\"hidden\"\tname=\"p_no_of_label\" id=\"p_no_of_label\"\t\t\t\t\tvalue=\"\">\n\t\t<input type=\"hidden\"\tname=\"fm_expiry_date\" id=\"fm_expiry_date\"\t\t\t\t\tvalue=\"\">\n\t\t<input type=\"hidden\"\tname=\"fm_batch_id\" id=\"fm_batch_id\"\t\t\t\t\t\tvalue=\"\">\n\t\t<input type=\"hidden\"\tname=\"to_quantity\" id=\"to_quantity\"\t\t\t\t\t\tvalue=\"\">\n\t\t<input type=\"hidden\"\tname=\"sys_date\" id=\"sys_date\"\t\t\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\">\n\t\t<input type=\"hidden\"\tname=\"fm_item_unit_cost\" id=\"fm_item_unit_cost\"\t\t\t\tvalue=\"\">\n\t\t<input type=\"hidden\"\tname=\"to_item_unit_cost\" id=\"to_item_unit_cost\"\t\t\t\tvalue=\"\">\n\t\t<input type=\"hidden\"\tname=\"to_item_unit_price\" id=\"to_item_unit_price\"\t\t\t\tvalue=\"\">\n\t\t<input type=\"hidden\"\tname=\"fm_trade_id\" id=\"fm_trade_id\"\t\t\t\t\t\tvalue=\"\">\n\t\t<input type=\"hidden\"\tname=\"to_trade_id\" id=\"to_trade_id\"\t\t\t\t\t\tvalue=\"\">\n\t\t<input type=\"hidden\"\tname=\"store_code\" id=\"store_code\"\t\t\t\t\t\tvalue=\"\">\n\t\t<input type=\"hidden\"\tname=\"fm_trade_id_applicable_yn\" id=\"fm_trade_id_applicable_yn\"\t\tvalue=\"\">\n\t\t<input type=\"hidden\"\tname=\"from_req_trade_id_applicable_yn\" id=\"from_req_trade_id_applicable_yn\"  value=\"\">\n\t\t<input type=\"hidden\"\tname=\"from_uom_desc\" id=\"from_uom_desc\"\t\t\t\t\tvalue=\"\">\n\t\t<input type=\"hidden\"\tname=\"too_uom_desc\" id=\"too_uom_desc\"\t\t\t\t\t\tvalue=\"\">\n\t\t<input type=\"hidden\"\tname=\"from_item_desc\" id=\"from_item_desc\"\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\">  <!--Changed for ML-MMOH-CRF-0448 B.Badmavathi -->\n\t\t<input type=\"hidden\"\tname=\"too_item_desc\" id=\"too_item_desc\"\t\t\t\t\tvalue=\"\">\n\t\t<input type=\"hidden\"\tname=\"to_req_trade_id_applicable_yn\" id=\"to_req_trade_id_applicable_yn\"\tvalue=\"\">\n\t\t<input type=\"hidden\"\tname=\"to_req_batch_id_applicable_yn\" id=\"to_req_batch_id_applicable_yn\"\tvalue=\"\">\n\t\t<input type=\"hidden\"\tname=\"from_req_batch_id_applicable_yn\" id=\"from_req_batch_id_applicable_yn\"  value=\"\">\n\t\t<input type=\"hidden\"\tname=\"to_trade_id_applicable_yn\" id=\"to_trade_id_applicable_yn\"\t\tvalue=\"\">\n\t\t<input type=\"hidden\"\tname=\"from_uom\" id=\"from_uom\"\t\t\t\t\t\t\tvalue=\"\">\n\t\t<input type=\"hidden\"\tname=\"to_uom\" id=\"to_uom\"\t\t\t\t\t\t\tvalue=\"\">\n\t\t<input type=\"hidden\"\tname=\"fm_expiry_yn\" id=\"fm_expiry_yn\"\t\t\t\t\t\tvalue=\"\">\n\t\t<input type=\"hidden\"\tname=\"to_expiry_yn\" id=\"to_expiry_yn\"\t\t\t\t\t\tvalue=\"\">\n\t\t<input type=\"hidden\"\tname=\"doc_srl_no\" id=\"doc_srl_no\"\t\t\t\t\t\tvalue=\"-1\">\n\t\t<input type=\"hidden\"\tname=\"next_batch_id\" id=\"next_batch_id\"\t\t\t\t\tvalue=\"\">\n\t\t<input type=\"hidden\"\tname=\"to_batch_id_applicable_yn_1\" id=\"to_batch_id_applicable_yn_1\"\t\tvalue=\"\" >\n\t\t<input type=\"hidden\"\tname=\"from_store_code\" id=\"from_store_code\"\t\t\t\t\tvalue=\"\">\n\t\t<input type=\"hidden\"\tname=\"auto_gen_batch_yn\" id=\"auto_gen_batch_yn\" >\n\t\t<input type=\"hidden\"\tname=\"mode\" id=\"mode\"\t\t\t\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\">\n\t\t<input type=\"hidden\"\tname=\"prod_transfer_mode\" id=\"prod_transfer_mode\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\"><!-- ML-MMOH-SCF-1861 -->\n\t\t<input type=\"hidden\"\tname=\"doc_no\" id=\"doc_no\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\">\n\t\t<input type=\"hidden\"\tname=\"doc_type_code\" id=\"doc_type_code\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\"><!-- end -->\t\t\n\t\t<input type=\"hidden\"\tname=\"bean_id\" id=\"bean_id\"\t\t\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\">\n\t\t<input type=\"hidden\"\tname=\"bean_name\" id=\"bean_name\"\t\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\">\n\t\t<input type=\"hidden\"\tname=\"function_id\" id=\"function_id\"\t\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\">\n\t\t<input type=\"hidden\"\tname=\"expired_batch\" id=\"expired_batch\"\t\t\t\t\tvalue=\"\">\n\t\t<input type=\"hidden\"\tname=\"ex_param_days\" id=\"ex_param_days\"\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\">\n\t\t<input type=\"hidden\"\tname=\"phy_inv_id\" id=\"phy_inv_id\"\t\t\t\t\t\tvalue=\"\">\n\t\t<input type=\"hidden\"\tname=\"request_no\" id=\"request_no\"\t\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\">\n\t\t<input type=\"hidden\"\tname=\"lang_id\" id=\"lang_id\"\t\t\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\">\n\t\t<input type=\"hidden\"\tname=\"rem_trans_type\" id=\"rem_trans_type\"\t\t\t\t\tvalue=\"PRT\">\n\t\t<!--<input type=\"hidden\" name=\"to_bin_location_code\" id=\"to_bin_location_code\"\t\t\t\tvalue=\"\">  -->\n\t\t<!--<input type=\"hidden\" name=\"from_item_code\" id=\"from_item_code\"\t\t\t\t\t\tvalue=\"\">\n\t\t<input type=\"hidden\" name=\"too_item_code\" id=\"too_item_code\"\t\t\t\t\t\tvalue=\"\"> -->\n\t\t<input type=\"hidden\"\tname=\"SQL_ST_TRN_REMARKS_LOOKUP_SELECT\" id=\"SQL_ST_TRN_REMARKS_LOOKUP_SELECT\"\t\tvalue=\"";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\">\n\t\t<input type=\"hidden\" name=\"allow_deci_yn_from\" id=\"allow_deci_yn_from\"\t\t\t\tvalue=\"\">\n\t\t<input type=\"hidden\" name=\"no_deci_from\" id=\"no_deci_from\"\t\t\t\tvalue=\"\">\n\t\t<input type=\"hidden\" name=\"allow_deci_yn_to\" id=\"allow_deci_yn_to\"\t\t\t\tvalue=\"\">\n\t\t<input type=\"hidden\" name=\"no_deci_to\" id=\"no_deci_to\"\t\t\t\tvalue=\"\">\n\n\t\t<input type=\"hidden\" name=\"fr_sale_price\" id=\"fr_sale_price\"\t\t\t\tvalue=\"\">\n\t\t<input type=\"hidden\" name=\"episode_type\" id=\"episode_type\"\t\t\t\tvalue=\"I\">\n\t\t<input type=\"hidden\" name=\"sale_price_appl_yn\" id=\"sale_price_appl_yn\"\t\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\">\n\t\t<input type=\"hidden\" name=\"no_of_decimals\" id=\"no_of_decimals\"\t\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\">\n\t\t<!-- 04/05/12 -->\n\t\t<input type=\"hidden\"    name=\"trn_type\" id=\"trn_type\"\t\t\t\t\t\t\t    value=\'";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\' >\n\t\t<input type=\"hidden\"    name=\"BARCODE_YN\" id=\"BARCODE_YN\"\t\t\t\t\t\t\tvalue=\'";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\' >\n\t\t<input type=\"hidden\"    name=\"barcode_applicable\" id=\"barcode_applicable\"\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\" >\n\t\t<input type=\"hidden\"    name=\"fm_barcode\" id=\"fm_barcode\"\t\t\t\tvalue=\"\">\n\t\t<input type=\"hidden\"    name=\"manufacturer_id\" id=\"manufacturer_id\"\t\t\t\t\t\tvalue=\"\" >\n\t   <input type=\"hidden\"     name=\"supplier_id\" id=\"supplier_id\"\t\t\t\t\t\tvalue=\"\" >\n\t   <input type=\"hidden\"     name=\"mrp\" id=\"mrp\"\t\t\t\t\t\tvalue=\"\" >\n\t   <input type=\"hidden\"    name=\"BarcodeRule\" id=\"BarcodeRule\" value=\"";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\">\n\t   <input type=\"hidden\"    name=\"facility_id\" id=\"facility_id\" value=\"";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\">\n\t    <input type=\"hidden\"    name=\"site_id\" id=\"site_id\" value=\"";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\">\n\t  <!--Added for ML-MMOH-CRF-0448 B.Badmavathi starts-->\n\t   <input type=\"hidden\"\tname=\"finalize_allowed_yn\" id=\"finalize_allowed_yn\"\tvalue=\"N\">\n\t   <input type=\"hidden\"\tname=\"site\" id=\"site\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\">\n\t   <input type=\"hidden\"\tname=\"from_exp_date\" id=\"from_exp_date\"\t\tvalue=\"";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\">\n\t   <input type=\"hidden\"\tname=\"store_desc\" id=\"store_desc\"\t\tvalue=\"";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\">\n\t   <input type=\"hidden\"\tname=\"FM_BIN_LOCN\" id=\"FM_BIN_LOCN\"\t\tvalue=\"";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\">\n\t   <input type=\"hidden\"\tname=\"FM_BIN_LOCN_CODE\" id=\"FM_BIN_LOCN_CODE\"\t\tvalue=\"";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\">\n\t   <input type=\"hidden\"\tname=\"FM_TRADE\" id=\"FM_TRADE\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\">\n\t   <input type=\"hidden\"\tname=\"FM_TRADE_ID\" id=\"FM_TRADE_ID\"\t\tvalue=\"";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\">\n\t   <input type=\"hidden\"\tname=\"MANUFACTURER_ID\" id=\"MANUFACTURER_ID\"\t\tvalue=\"";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\">\n\t   <input type=\"hidden\"\tname=\"MANU_DESC\" id=\"MANU_DESC\"\t\tvalue=\"";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\">\n\t   <input type=\"hidden\"\tname=\"expiry_yn\" id=\"expiry_yn\"\t\tvalue=\"";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\">\n\t   <input type=\"hidden\"\tname=\"QTY_ON_HAND\" id=\"QTY_ON_HAND\"\t\tvalue=\"";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\">\n\t   <input type=\"hidden\"\tname=\"AVAIL_QTY\" id=\"AVAIL_QTY\"\t\tvalue=\"";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\">\n\t   <input type=\"hidden\"\tname=\"NOD\" id=\"NOD\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="\">\n\t   <input type=\"hidden\" \tname=\"from_item_code\" id=\"from_item_code\"\t\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="\">\n\t   <input type=\"hidden\" \tname=\"from_batch_id\" id=\"from_batch_id\"\t\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\">\n\t   <input type=\'hidden\'\t name=\"finalize_yn\" id=\"finalize_yn\"\t\t\t\t value=\"Y\">\n\t  ";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\n\t   <input type=\'hidden\'\t name=\"prt_delete_yn\" id=\"prt_delete_yn\"\t\t\t\t value=\"";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\"> \n\t   ";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\n\t\t<input type=\"hidden\"\tname=\"to_batch_id\" id=\"to_batch_id\"\t\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\">\n\t\t<input type=\"hidden\"\tname=\"fm_item_code\" id=\"fm_item_code\"\t\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\">\n\t\t<input type=\"hidden\"\tname=\"to_item_code\" id=\"to_item_code\"\t\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\">\n\t   ";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="\n\t\t<input type=\"hidden\"\tname=\"to_batch_id\" id=\"to_batch_id\"\t\t\t\t\t\tvalue=\"\">\n\t\t<input type=\"hidden\"\tname=\"fm_item_code\" id=\"fm_item_code\"\t\t\t\t\t\tvalue=\"\">\n\t\t<input type=\"hidden\"\tname=\"to_item_code\" id=\"to_item_code\"\t\t\t\t\t\tvalue=\"\">\n\t   ";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="\n\t   <!--Added for ML-MMOH-CRF-0448 B.Badmavathi ends-->\n\t   \n</form>\n\n</form>\n";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="\n<!--//Added for ML-MMOH-CRF-0448 B.Badmavathi starts-->\n<script type=\"text/javascript\">\n";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\n\tcallBatchSearchFrom1();clearMessageFrame();ComputeToQuantity();\n</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n<!--//Added for ML-MMOH-CRF-0448 B.Badmavathi ends-->\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );
	
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
12/08/2015	  	IN0037673	   		Karthi	 					SRR20056-SCF-9532
21/02/2016		IN0057461			B.Badmavathi					ML-MMOH-CRF-0448
22/06/2017		IN0064609			B.Badmavathi					ML-BRU-SCF-1720
8/8/2021		TFS:21452        	Shazana                      	ML-MMOH-SCF-1861
---------------------------------------------------------------------------------------------------------------
*/

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
            _bw.write(_wl_block5Bytes, _wl_block5);

		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
		String sStyle			=  (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
 
//  int i						=			0;
	String mode;
	String bean_id;
	String bean_name;
	String function_id;
	String  saleprice= null; 
	String  saleprice1 = null;


	//mode						=			request.getParameter( "mode" ) ;//Commented for ML-MMOH-CRF-0448 [IN:57461] by B.Badmavathi 
	//if(mode==null)	mode		=			"1";//Commented for ML-MMOH-CRF-0448 [IN:57461] by B.Badmavathi 
	function_id					=			request.getParameter( "function_id" ) ;
	
	bean_id						=			"ProductTransferBean" ;
	bean_name					=			"eST.ProductTransferBean";

	ProductTransferBean bean	=			(ProductTransferBean) getBeanObject( "ProductTransferBean","eST.ProductTransferBean", request );
	bean.setLanguageId(locale);

	StHeaderBean beanHdr		=			(StHeaderBean) getBeanObject( "stHeaderBean", "eST.Common.StHeaderBean" ,request);
	beanHdr.setLanguageId(locale);
    bean.setProductTransferHeaderBean(beanHdr);
//Added for ML-MMOH-CRF-0448 [IN:57461] by B.Badmavathi starts
   		boolean site=bean.isSite_spec_yn();
		System.out.println("site======product transfer start jsp= in add modify====");
		System.out.println(site);
	 if(site){
		  mode						=		eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT");
		 if(request.getParameter( "doc_type_code" ) != null) {
		 mode						=		eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY");	
		 
		 }
		
	 }
	 else{
	 mode							=		request.getParameter( "mode" ) ;
	if(mode==null)
				mode				=		"1";
	}
	
	 String item_vis_query			=		"disabled";
//Added for ML-MMOH-CRF-0448 [IN:57461] by B.Badmavathi ends
	//String bin_location_code1	=			bean.getBinlocationCodeList();
    String bin_location_value	=			eST.Common.StRepository.getStKeyValue("DEFAULT_LIST_OPTION");

	String sys_date				=			"";
	sys_date					=			beanHdr.getSystemDate();
	 String facility_id	        =	beanHdr.getLoginFacilityId();  
	 String store_code=beanHdr.getStore_code();
    //String to_item_code = "" ;
	int EWDays					=			0;
//pmd 29/01/05
//int expired_batch				=			0;
	EWDays						=			bean.getEntityparam_EWDay((String)session.getAttribute("ACC_ENTITY_ID"));
	HashMap hmTemp				=			(HashMap)bean.fetchRecord("select SALE_PRICE_APPL_YN from st_acc_entity_param");
	String  sale_price_appl_yn	=			 bean.checkForNull((String)hmTemp.get("SALE_PRICE_APPL_YN"),"N");

	//System.out.println("sale_price_appl_yn" +sale_price_appl_yn);
	int no_of_decimals1			=			bean.getNoOfDecimals();
	String noOfDecimalsForCost	=			bean.getNoOfDecimalsCost();
//Added for ML-MMOH-CRF-0448 [IN:57461] by B.Badmavathi starts
	String doc_no 					= 		bean.checkForNull(request.getParameter( "doc_no" ));
	String doc_type_code			=		bean.checkForNull(request.getParameter( "doc_type_code" ));
	//System.out.print("DOC_TYPE_CODE============");System.out.print(doc_type_code);
	String store_desc = bean.checkForNull((String) bean.fetchRecord(StRepository.getStKeyValue("SQL_STORE_DESC_PROD_TRF"),new String[]{doc_no,doc_type_code,facility_id}).get("SHORT_DESC"),"");
	//Added for request number delete in unfinalized mode 
	String reques_no= bean.checkForNull((String) bean.fetchRecord(StRepository.getStKeyValue("SQL_STORE_DESC_PROD_TRF"),new String[]{doc_no,doc_type_code,facility_id}).get("PROD_TFR_REQUEST_NO"),"");
	String NOD = bean.checkForNull((String) bean.fetchRecord(StRepository.getStKeyValue("SQL_NOD_EXP_PROD_TRF"),new String[]{doc_no}).get("NOD"),"");
	
		
	String from_item_code = bean.checkForNull((String) bean.fetchRecord(StRepository.getStKeyValue("SQL_FM_ITEM_DESC_PROD_TRF"),new String[]{doc_no,doc_type_code,facility_id}).get("ITEM_CODE"),"");
	String from_item_desc = bean.checkForNull((String) bean.fetchRecord(StRepository.getStKeyValue("SQL_FM_ITEM_DESC_PROD_TRF"),new String[]{doc_no,doc_type_code,facility_id}).get("SHORT_DESC"),"");
	String FM_STK_UOM_CONV_FACTOR = bean.checkForNull((String) bean.fetchRecord(StRepository.getStKeyValue("SQL_FM_ITEM_DESC_PROD_TRF"),new String[]{doc_no,doc_type_code,facility_id}).get("FM_STK_UOM_CONV_FACTOR"),"");
	
	
	String TO_STK_UOM_CONV_FACTOR = bean.checkForNull((String) bean.fetchRecord(StRepository.getStKeyValue("SQL_TO_ITEM_DESC_PROD_TRF"),new String[]{doc_no,doc_type_code,facility_id}).get("TO_STK_UOM_CONV_FACTOR"),"");
	String to_item_code1 = bean.checkForNull((String) bean.fetchRecord(StRepository.getStKeyValue("SQL_TO_ITEM_DESC_PROD_TRF"),new String[]{doc_no,doc_type_code,facility_id}).get("ITEM_CODE"),"");
	String to_item_desc1 = bean.checkForNull((String) bean.fetchRecord(StRepository.getStKeyValue("SQL_TO_ITEM_DESC_PROD_TRF"),new String[]{doc_no,doc_type_code,facility_id}).get("SHORT_DESC"),"");
	String to_uom_desc1 = bean.checkForNull((String) bean.fetchRecord(StRepository.getStKeyValue("SQL_TO_ITEM_DESC_PROD_TRF"),new String[]{doc_no,doc_type_code,facility_id}).get("UOM_DESC"),"");
	
	String from_uom_desc1 = bean.checkForNull((String) bean.fetchRecord(StRepository.getStKeyValue("SQL_FM_UOM_DESC_PROD_TRF"),new String[]{doc_no,doc_type_code,facility_id}).get("SHORT_DESC"),"");
	String expiry_yn = bean.checkForNull((String) bean.fetchRecord(StRepository.getStKeyValue("SQL_FM_UOM_DESC_PROD_TRF"),new String[]{doc_no,doc_type_code,facility_id}).get("EXPIRY_YN"),"");
	String AVAIL_QTY = bean.checkForNull((String) bean.fetchRecord(StRepository.getStKeyValue("SQL_FM_UOM_DESC_PROD_TRF"),new String[]{doc_no,doc_type_code,facility_id}).get("AVAIL_QTY"),"");
	String QTY_ON_HAND = bean.checkForNull((String) bean.fetchRecord(StRepository.getStKeyValue("SQL_FM_UOM_DESC_PROD_TRF"),new String[]{doc_no,doc_type_code,facility_id}).get("QTY_ON_HAND"),"");
	
	
	String from_exp_date = bean.checkForNull((String) bean.fetchRecord(StRepository.getStKeyValue("SQL_EXP_DATE_PROD_TRF"),new String[]{doc_no,doc_type_code,facility_id}).get("FM_EXPIRY_DATE"),"");
	String to_exp_date = bean.checkForNull((String) bean.fetchRecord(StRepository.getStKeyValue("SQL_EXP_DATE_PROD_TRF"),new String[]{doc_no,doc_type_code,facility_id}).get("TO_EXPIRY_DATE"),"");	
	String from_batch_id = bean.checkForNull((String) bean.fetchRecord(StRepository.getStKeyValue("SQL_EXP_DATE_PROD_TRF"),new String[]{doc_no,doc_type_code,facility_id}).get("FM_ITEM_BATCH_ID"),"");
	String to_batch_id = bean.checkForNull((String) bean.fetchRecord(StRepository.getStKeyValue("SQL_EXP_DATE_PROD_TRF"),new String[]{doc_no,doc_type_code,facility_id}).get("TO_ITEM_BATCH_ID"),"");	
	String from_item_qty = bean.checkForNull((String) bean.fetchRecord(StRepository.getStKeyValue("SQL_EXP_DATE_PROD_TRF"),new String[]{doc_no,doc_type_code,facility_id}).get("FM_ITEM_QTY"),"");
	String to_item_qty = bean.checkForNull((String) bean.fetchRecord(StRepository.getStKeyValue("SQL_EXP_DATE_PROD_TRF"),new String[]{doc_no,doc_type_code,facility_id}).get("TO_ITEM_QTY"),"");	
	String to_item_exp_qty = bean.checkForNull((String) bean.fetchRecord(StRepository.getStKeyValue("SQL_EXP_DATE_PROD_TRF"),new String[]{doc_no,doc_type_code,facility_id}).get("TO_ITEM_EXP_QTY"),"");	
	String FM_ITEM_EXP_BAL_QTY = bean.checkForNull((String) bean.fetchRecord(StRepository.getStKeyValue("SQL_EXP_DATE_PROD_TRF"),new String[]{doc_no,doc_type_code,facility_id}).get("FM_ITEM_EXP_BAL_QTY"),"");
	String FM_ITEM_ACT_BAL_QTY = bean.checkForNull((String) bean.fetchRecord(StRepository.getStKeyValue("SQL_EXP_DATE_PROD_TRF"),new String[]{doc_no,doc_type_code,facility_id}).get("FM_ITEM_ACT_BAL_QTY"),"");
	String NO_OF_LABELS_footer = bean.checkForNull((String) bean.fetchRecord(StRepository.getStKeyValue("SQL_EXP_DATE_PROD_TRF"),new String[]{doc_no,doc_type_code,facility_id}).get("NO_OF_LABELS"),"");
	
	
	String TO_TRADE = bean.checkForNull((String) bean.fetchRecord(StRepository.getStKeyValue("SQL_TO_TRADE_DESC_PROD_TRF"),new String[]{doc_no}).get("SHORT_NAME"),"");
	String TO_BIN_LOCN_CODE = bean.checkForNull((String) bean.fetchRecord(StRepository.getStKeyValue("SQL_TO_TRADE_DESC_PROD_TRF"),new String[]{doc_no}).get("BIN_LOCATION_CODE"),"");
	String TO_BIN_LOCN_DESC = bean.checkForNull((String) bean.fetchRecord(StRepository.getStKeyValue("SQL_TO_TRADE_DESC_PROD_TRF"),new String[]{doc_no}).get("SHORT_DESC"),"");
	String to_barcode = bean.checkForNull((String) bean.fetchRecord(StRepository.getStKeyValue("SQL_TO_TRADE_DESC_PROD_TRF"),new String[]{doc_no}).get("BARCODE_ID"),"");
	
	
	String FM_TRADE = bean.checkForNull((String) bean.fetchRecord(StRepository.getStKeyValue("SQL_FM_TRADE_DESC_PROD_TRF"),new String[]{doc_no}).get("SHORT_NAME"),"");
	String FM_TRADE_ID = bean.checkForNull((String) bean.fetchRecord(StRepository.getStKeyValue("SQL_FM_TRADE_DESC_PROD_TRF"),new String[]{doc_no}).get("TRADE_ID"),"");
	String FM_BIN_LOCN = bean.checkForNull((String) bean.fetchRecord(StRepository.getStKeyValue("SQL_FM_TRADE_DESC_PROD_TRF"),new String[]{doc_no}).get("SHORT_DESC"),"");
	String FM_BIN_LOCN_CODE = bean.checkForNull((String) bean.fetchRecord(StRepository.getStKeyValue("SQL_FM_TRADE_DESC_PROD_TRF"),new String[]{doc_no}).get("BIN_LOCATION_CODE"),"");
	String MANUFACTURER_ID = bean.checkForNull((String) bean.fetchRecord(StRepository.getStKeyValue("SQL_FM_TRADE_DESC_PROD_TRF"),new String[]{doc_no}).get("MANUFACTURER_ID"),"");
	String MANU_DESC = bean.checkForNull((String) bean.fetchRecord(StRepository.getStKeyValue("SQL_FM_TRADE_DESC_PROD_TRF"),new String[]{doc_no}).get("MANU_DESC"),"");
	
	
	String remarks1 = bean.checkForNull((String) bean.fetchRecord(StRepository.getStKeyValue("SQL_FOOTER_PROD_TRF"),new String[]{doc_no,facility_id,doc_type_code}).get("REMARKS"),"");
	String PACKED_BY = bean.checkForNull((String) bean.fetchRecord(StRepository.getStKeyValue("SQL_FOOTER_PROD_TRF"),new String[]{doc_no,facility_id,doc_type_code}).get("PACKED_BY"),"");
	String COUNTER_CHECKED = bean.checkForNull((String) bean.fetchRecord(StRepository.getStKeyValue("SQL_FOOTER_PROD_TRF"),new String[]{doc_no,facility_id,doc_type_code}).get("COUNTER_CHECKED"),"");
	String AUTHORIZED_BY = bean.checkForNull((String) bean.fetchRecord(StRepository.getStKeyValue("SQL_FOOTER_PROD_TRF"),new String[]{doc_no,facility_id,doc_type_code}).get("AUTHORIZED_BY"),"");
	String NO_OF_LABELS = bean.checkForNull((String) bean.fetchRecord(StRepository.getStKeyValue("SQL_FOOTER_PROD_TRF"),new String[]{doc_no,facility_id,doc_type_code}).get("NO_OF_LABELS"),"");
	String time_taken1 = bean.checkForNull((String) bean.fetchRecord(StRepository.getStKeyValue("SQL_FOOTER_PROD_TRF"),new String[]{doc_no,facility_id,doc_type_code}).get("TIME_TAKEN"),"");
	//Added for delete option working
String prt_delete_yn = bean.getMfg_delete_yn(); 
	//Added for ML-MMOH-CRF-0448 [IN:57461] by B.Badmavathi ends
    String item_code = request.getParameter("to_item_code")==null?"":request.getParameter("to_item_code");  
 	//System.out.println("item_code===72===>" +item_code);
    String  trn_type  = "PRT";
    String	BARCODE_YN = request.getParameter("BARCODE_YN")==null?"FALSE":request.getParameter("BARCODE_YN");
	   //System.out.println("BARCODE_YN ===PRT==>"+BARCODE_YN);
	      boolean BarCodeApplicable	=	bean.isBarCodeApplicable(facility_id,trn_type);
	      HashMap BarCodeRules = bean.getNewBarCodeRules(facility_id);
	     //System.out.println("BarCodeRules ===PRT==>"+BarCodeRules);
		String BarcodeRule = bean.checkForNull((String)BarCodeRules.get("BARCODE_GEN_RULE"));
        // System.out.println("BarcodeRule ===PRT==>"+BarcodeRule);			
	     String BarcodeRule_Disable = "";
		 if(BarcodeRule.equals("P") ||BarcodeRule.equals("S") )
			BarcodeRule_Disable = "ReadOnly";
			
	 String site_id = bean.getCustomerID();
	//System.out.println("site_id" +site_id);
		 
	

            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(bean.getPrepLoc()));
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
if(site){if(mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT"))){ 
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf( mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))?item_vis_query:""));
            _bw.write(_wl_block15Bytes, _wl_block15);
}else{ 
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(from_item_desc ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf( mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))?item_vis_query:""));
            _bw.write(_wl_block19Bytes, _wl_block19);
}}else{ 
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block20Bytes, _wl_block20);
} 
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf( mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))?item_vis_query:""));
            _bw.write(_wl_block23Bytes, _wl_block23);
if(mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY"))){ 
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(from_uom_desc1 ));
            _bw.write(_wl_block26Bytes, _wl_block26);
}else{ 
            _bw.write(_wl_block27Bytes, _wl_block27);
} 
            _bw.write(_wl_block28Bytes, _wl_block28);
if(site && (mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY")))){ 
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);
}else{ 
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);
} 
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);
if(site && (mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY")))){ 
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(FM_STK_UOM_CONV_FACTOR ));
            _bw.write(_wl_block36Bytes, _wl_block36);
}else{ 
            _bw.write(_wl_block37Bytes, _wl_block37);
} 
            _bw.write(_wl_block38Bytes, _wl_block38);
if(site && (mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY")))){ 
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(from_item_qty ));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(no_of_decimals1));
            _bw.write(_wl_block42Bytes, _wl_block42);
}else{ 
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(no_of_decimals1));
            _bw.write(_wl_block45Bytes, _wl_block45);
} 
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block47Bytes, _wl_block47);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block48Bytes, _wl_block48);
if(site && (mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY")))){ 
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(to_item_desc1 ));
            _bw.write(_wl_block50Bytes, _wl_block50);
}else{ 
            _bw.write(_wl_block51Bytes, _wl_block51);
} 
            _bw.write(_wl_block52Bytes, _wl_block52);
if(mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY"))){ 
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(to_uom_desc1 ));
            _bw.write(_wl_block26Bytes, _wl_block26);
}else{ 
            _bw.write(_wl_block53Bytes, _wl_block53);
} 
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);
if(site && (mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY")))){ 
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(to_batch_id ));
            _bw.write(_wl_block57Bytes, _wl_block57);
}else{ 
            _bw.write(_wl_block58Bytes, _wl_block58);
if(BarCodeApplicable){
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block60Bytes, _wl_block60);
}else{
            _bw.write(_wl_block61Bytes, _wl_block61);
}}
            _bw.write(_wl_block62Bytes, _wl_block62);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block63Bytes, _wl_block63);
if(site && (mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY")))){ 
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(to_exp_date ));
            _bw.write(_wl_block66Bytes, _wl_block66);
}else{ 
            _bw.write(_wl_block67Bytes, _wl_block67);
if(BarCodeApplicable){
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block70Bytes, _wl_block70);
}else{
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block72Bytes, _wl_block72);
}}
            _bw.write(_wl_block73Bytes, _wl_block73);
if(site && (mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY")))){ 
            _bw.write(_wl_block74Bytes, _wl_block74);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(TO_TRADE));
            _bw.write(_wl_block75Bytes, _wl_block75);
}else{ 
            _bw.write(_wl_block76Bytes, _wl_block76);
} 
            _bw.write(_wl_block77Bytes, _wl_block77);
if(sale_price_appl_yn.equals("Y")) {
            _bw.write(_wl_block78Bytes, _wl_block78);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(noOfDecimalsForCost));
            _bw.write(_wl_block80Bytes, _wl_block80);
}
            _bw.write(_wl_block81Bytes, _wl_block81);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block82Bytes, _wl_block82);
if(site && (mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY")))){ 
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(bean.getBinlocationCodeList1(TO_BIN_LOCN_CODE,to_item_code1)));
            _bw.write(_wl_block84Bytes, _wl_block84);
}else{ 
            _bw.write(_wl_block85Bytes, _wl_block85);
if(BarCodeApplicable){
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(bin_location_value));
            _bw.write(_wl_block88Bytes, _wl_block88);
}else{
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(bin_location_value));
            _bw.write(_wl_block90Bytes, _wl_block90);
}
            _bw.write(_wl_block91Bytes, _wl_block91);
} 
            _bw.write(_wl_block92Bytes, _wl_block92);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block82Bytes, _wl_block82);
if(site && (mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY")))){ 
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(TO_STK_UOM_CONV_FACTOR ));
            _bw.write(_wl_block94Bytes, _wl_block94);
 }else{
            _bw.write(_wl_block95Bytes, _wl_block95);
} 
            _bw.write(_wl_block96Bytes, _wl_block96);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block97Bytes, _wl_block97);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(no_of_decimals1));
            _bw.write(_wl_block99Bytes, _wl_block99);
if(site && (mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY")))){ 
            _bw.write(_wl_block100Bytes, _wl_block100);
if(BarCodeApplicable){
            _bw.write(_wl_block101Bytes, _wl_block101);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(to_barcode ));
            _bw.write(_wl_block103Bytes, _wl_block103);
 if(site_id.equals("MOHBR")){
            _bw.write(_wl_block104Bytes, _wl_block104);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block105Bytes, _wl_block105);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block106Bytes, _wl_block106);
}else{
            _bw.write(_wl_block107Bytes, _wl_block107);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block108Bytes, _wl_block108);
	if(!NO_OF_LABELS.equals("")){
			
            _bw.write(_wl_block109Bytes, _wl_block109);
}
		else{
			
            _bw.write(_wl_block110Bytes, _wl_block110);
}
		
            _bw.write(_wl_block111Bytes, _wl_block111);
}
            _bw.write(_wl_block112Bytes, _wl_block112);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(NO_OF_LABELS_footer));
            _bw.write(_wl_block114Bytes, _wl_block114);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block115Bytes, _wl_block115);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(FM_ITEM_ACT_BAL_QTY ));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(no_of_decimals1));
            _bw.write(_wl_block118Bytes, _wl_block118);
}else{
            _bw.write(_wl_block119Bytes, _wl_block119);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block120Bytes, _wl_block120);
	if(!NO_OF_LABELS.equals("")){
			
            _bw.write(_wl_block121Bytes, _wl_block121);
}
		else{
			
            _bw.write(_wl_block122Bytes, _wl_block122);
}
		
            _bw.write(_wl_block123Bytes, _wl_block123);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(NO_OF_LABELS_footer));
            _bw.write(_wl_block114Bytes, _wl_block114);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block115Bytes, _wl_block115);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(FM_ITEM_ACT_BAL_QTY ));
            _bw.write(_wl_block125Bytes, _wl_block125);
}
            _bw.write(_wl_block126Bytes, _wl_block126);
}else{ 
            _bw.write(_wl_block127Bytes, _wl_block127);
if(BarCodeApplicable){
            _bw.write(_wl_block101Bytes, _wl_block101);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(BarcodeRule_Disable));
            _bw.write(_wl_block129Bytes, _wl_block129);
 if(site_id.equals("MOHBR")){
            _bw.write(_wl_block104Bytes, _wl_block104);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block105Bytes, _wl_block105);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block106Bytes, _wl_block106);
}else{
            _bw.write(_wl_block107Bytes, _wl_block107);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block130Bytes, _wl_block130);
}
            _bw.write(_wl_block112Bytes, _wl_block112);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(NO_OF_LABELS ));
            _bw.write(_wl_block131Bytes, _wl_block131);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block115Bytes, _wl_block115);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(no_of_decimals1));
            _bw.write(_wl_block118Bytes, _wl_block118);
}else{
            _bw.write(_wl_block119Bytes, _wl_block119);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block133Bytes, _wl_block133);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(NO_OF_LABELS ));
            _bw.write(_wl_block131Bytes, _wl_block131);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block115Bytes, _wl_block115);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block134Bytes, _wl_block134);
}
            _bw.write(_wl_block135Bytes, _wl_block135);
} 
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(bean.getStRepositoryValue("INTEGER_PRECISION")));
            _bw.write(_wl_block137Bytes, _wl_block137);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(session.getValue("login_user")));
            _bw.write(_wl_block139Bytes, _wl_block139);
if(site && (mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY")))){ 
            _bw.write(_wl_block140Bytes, _wl_block140);

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(remarks1));
            _bw.write(_wl_block142Bytes, _wl_block142);

            if (_jsp__tag43(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(PACKED_BY));
            _bw.write(_wl_block144Bytes, _wl_block144);

            if (_jsp__tag44(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(COUNTER_CHECKED ));
            _bw.write(_wl_block146Bytes, _wl_block146);

            if (_jsp__tag45(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(time_taken1 ));
            _bw.write(_wl_block148Bytes, _wl_block148);

            if (_jsp__tag46(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block149Bytes, _wl_block149);

            if (_jsp__tag47(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(AUTHORIZED_BY ));
            _bw.write(_wl_block151Bytes, _wl_block151);
}else{ 
            _bw.write(_wl_block152Bytes, _wl_block152);

            if (_jsp__tag48(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block153Bytes, _wl_block153);

            if (_jsp__tag49(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(session.getValue("login_user")));
            _bw.write(_wl_block154Bytes, _wl_block154);

            if (_jsp__tag50(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block155Bytes, _wl_block155);

            if (_jsp__tag51(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block156Bytes, _wl_block156);

            if (_jsp__tag52(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block149Bytes, _wl_block149);

            if (_jsp__tag53(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block157Bytes, _wl_block157);
} 
            _bw.write(_wl_block158Bytes, _wl_block158);
if(!sale_price_appl_yn.equals("Y")) {
            _bw.write(_wl_block159Bytes, _wl_block159);
}
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(sys_date));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(from_item_desc));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(doc_no));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(doc_type_code));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf( bean_name ));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf( function_id ));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(EWDays));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(reques_no));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf( eST.Common.StRepository.getStKeyValue("SQL_ST_TRN_REMARKS_LOOKUP_SELECT")));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(sale_price_appl_yn));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(no_of_decimals1));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(trn_type));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(BARCODE_YN));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(BarCodeApplicable));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(BarcodeRule));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(site_id));
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(site ));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(from_exp_date));
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(store_desc));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(FM_BIN_LOCN));
            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(FM_BIN_LOCN_CODE));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(FM_TRADE));
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(FM_TRADE_ID));
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(MANUFACTURER_ID));
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(MANU_DESC));
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(expiry_yn));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(QTY_ON_HAND));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(AVAIL_QTY));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(NOD));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(from_item_code));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(from_batch_id));
            _bw.write(_wl_block196Bytes, _wl_block196);
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(prt_delete_yn));
            _bw.write(_wl_block198Bytes, _wl_block198);
if(site && (mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY")))){ 
            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(to_batch_id));
            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(from_item_code));
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(to_item_code1));
            _bw.write(_wl_block202Bytes, _wl_block202);
}else{ 
            _bw.write(_wl_block203Bytes, _wl_block203);
} 
            _bw.write(_wl_block204Bytes, _wl_block204);

	putObjectInBean("ProductTransferBean",bean,request);
	putObjectInBean("stHeaderBean",beanHdr,request);


            _bw.write(_wl_block205Bytes, _wl_block205);
if(mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY")))
            _bw.write(_wl_block206Bytes, _wl_block206);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.TransferFrom.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.uom.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.BatchSearch.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.RepackSize.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Quantity.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Quantity.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.TransferTo.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.item.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.uom.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BatchID.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.expiryDate.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.TradeName.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.SalePrice.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BinLocation.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.Factor.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.ExpectedQuantity.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.ActualQuantity.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.BarCodeId.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Label.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.LabelwithBarcode.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Label.label", java.lang.String .class,"key"));
        __tag22.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.NoofLabels.label", java.lang.String .class,"key"));
        __tag23.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.ExpectedBalanceQuantity.label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag25(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag25 = null ;
        int __result__tag25 = 0 ;

        if (__tag25 == null ){
            __tag25 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag25);
        }
        __tag25.setPageContext(pageContext);
        __tag25.setParent(null);
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.ActualBalanceQty.label", java.lang.String .class,"key"));
        __tag25.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag25;
        __result__tag25 = __tag25.doStartTag();

        if (__result__tag25!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag25== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag25.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag25);
            return true;
        }
        _activeTag=__tag25.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag25);
        __tag25.release();
        return false;
    }

    private boolean _jsp__tag26(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag26 = null ;
        int __result__tag26 = 0 ;

        if (__tag26 == null ){
            __tag26 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag26);
        }
        __tag26.setPageContext(pageContext);
        __tag26.setParent(null);
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Label.label", java.lang.String .class,"key"));
        __tag26.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag26;
        __result__tag26 = __tag26.doStartTag();

        if (__result__tag26!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag26== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag26.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag26);
            return true;
        }
        _activeTag=__tag26.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag26);
        __tag26.release();
        return false;
    }

    private boolean _jsp__tag27(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag27 = null ;
        int __result__tag27 = 0 ;

        if (__tag27 == null ){
            __tag27 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag27);
        }
        __tag27.setPageContext(pageContext);
        __tag27.setParent(null);
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.NoofLabels.label", java.lang.String .class,"key"));
        __tag27.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag27;
        __result__tag27 = __tag27.doStartTag();

        if (__result__tag27!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag27== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag27.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag27);
            return true;
        }
        _activeTag=__tag27.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag27);
        __tag27.release();
        return false;
    }

    private boolean _jsp__tag28(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag28 = null ;
        int __result__tag28 = 0 ;

        if (__tag28 == null ){
            __tag28 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag28);
        }
        __tag28.setPageContext(pageContext);
        __tag28.setParent(null);
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.ExpectedBalanceQuantity.label", java.lang.String .class,"key"));
        __tag28.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag28;
        __result__tag28 = __tag28.doStartTag();

        if (__result__tag28!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag28== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag28.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag28);
            return true;
        }
        _activeTag=__tag28.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag28);
        __tag28.release();
        return false;
    }

    private boolean _jsp__tag29(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag29 = null ;
        int __result__tag29 = 0 ;

        if (__tag29 == null ){
            __tag29 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag29);
        }
        __tag29.setPageContext(pageContext);
        __tag29.setParent(null);
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.ActualBalanceQty.label", java.lang.String .class,"key"));
        __tag29.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag29;
        __result__tag29 = __tag29.doStartTag();

        if (__result__tag29!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag29== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag29.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag29);
            return true;
        }
        _activeTag=__tag29.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag29);
        __tag29.release();
        return false;
    }

    private boolean _jsp__tag30(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag30 = null ;
        int __result__tag30 = 0 ;

        if (__tag30 == null ){
            __tag30 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag30);
        }
        __tag30.setPageContext(pageContext);
        __tag30.setParent(null);
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.BarCodeId.label", java.lang.String .class,"key"));
        __tag30.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag30;
        __result__tag30 = __tag30.doStartTag();

        if (__result__tag30!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag30== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag30.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag30);
            return true;
        }
        _activeTag=__tag30.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag30);
        __tag30.release();
        return false;
    }

    private boolean _jsp__tag31(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag31 = null ;
        int __result__tag31 = 0 ;

        if (__tag31 == null ){
            __tag31 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag31);
        }
        __tag31.setPageContext(pageContext);
        __tag31.setParent(null);
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Label.label", java.lang.String .class,"key"));
        __tag31.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag31;
        __result__tag31 = __tag31.doStartTag();

        if (__result__tag31!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag31== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag31.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag31);
            return true;
        }
        _activeTag=__tag31.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag31);
        __tag31.release();
        return false;
    }

    private boolean _jsp__tag32(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag32 = null ;
        int __result__tag32 = 0 ;

        if (__tag32 == null ){
            __tag32 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag32);
        }
        __tag32.setPageContext(pageContext);
        __tag32.setParent(null);
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.LabelwithBarcode.label", java.lang.String .class,"key"));
        __tag32.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag32;
        __result__tag32 = __tag32.doStartTag();

        if (__result__tag32!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag32== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag32.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag32);
            return true;
        }
        _activeTag=__tag32.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag32);
        __tag32.release();
        return false;
    }

    private boolean _jsp__tag33(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag33 = null ;
        int __result__tag33 = 0 ;

        if (__tag33 == null ){
            __tag33 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag33);
        }
        __tag33.setPageContext(pageContext);
        __tag33.setParent(null);
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Label.label", java.lang.String .class,"key"));
        __tag33.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag33;
        __result__tag33 = __tag33.doStartTag();

        if (__result__tag33!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag33== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag33.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag33);
            return true;
        }
        _activeTag=__tag33.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag33);
        __tag33.release();
        return false;
    }

    private boolean _jsp__tag34(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag34 = null ;
        int __result__tag34 = 0 ;

        if (__tag34 == null ){
            __tag34 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag34);
        }
        __tag34.setPageContext(pageContext);
        __tag34.setParent(null);
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.NoofLabels.label", java.lang.String .class,"key"));
        __tag34.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag34;
        __result__tag34 = __tag34.doStartTag();

        if (__result__tag34!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag34== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag34.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag34);
            return true;
        }
        _activeTag=__tag34.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag34);
        __tag34.release();
        return false;
    }

    private boolean _jsp__tag35(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag35 = null ;
        int __result__tag35 = 0 ;

        if (__tag35 == null ){
            __tag35 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag35);
        }
        __tag35.setPageContext(pageContext);
        __tag35.setParent(null);
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.ExpectedBalanceQuantity.label", java.lang.String .class,"key"));
        __tag35.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag35;
        __result__tag35 = __tag35.doStartTag();

        if (__result__tag35!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag35== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag35.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag35);
            return true;
        }
        _activeTag=__tag35.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag35);
        __tag35.release();
        return false;
    }

    private boolean _jsp__tag36(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag36 = null ;
        int __result__tag36 = 0 ;

        if (__tag36 == null ){
            __tag36 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag36);
        }
        __tag36.setPageContext(pageContext);
        __tag36.setParent(null);
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.ActualBalanceQty.label", java.lang.String .class,"key"));
        __tag36.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag36;
        __result__tag36 = __tag36.doStartTag();

        if (__result__tag36!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag36== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag36.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag36);
            return true;
        }
        _activeTag=__tag36.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag36);
        __tag36.release();
        return false;
    }

    private boolean _jsp__tag37(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag37 = null ;
        int __result__tag37 = 0 ;

        if (__tag37 == null ){
            __tag37 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag37);
        }
        __tag37.setPageContext(pageContext);
        __tag37.setParent(null);
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Label.label", java.lang.String .class,"key"));
        __tag37.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag37;
        __result__tag37 = __tag37.doStartTag();

        if (__result__tag37!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag37== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag37.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag37);
            return true;
        }
        _activeTag=__tag37.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag37);
        __tag37.release();
        return false;
    }

    private boolean _jsp__tag38(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag38 = null ;
        int __result__tag38 = 0 ;

        if (__tag38 == null ){
            __tag38 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag38);
        }
        __tag38.setPageContext(pageContext);
        __tag38.setParent(null);
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.NoofLabels.label", java.lang.String .class,"key"));
        __tag38.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag38;
        __result__tag38 = __tag38.doStartTag();

        if (__result__tag38!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag38== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag38.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag38);
            return true;
        }
        _activeTag=__tag38.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag38);
        __tag38.release();
        return false;
    }

    private boolean _jsp__tag39(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag39 = null ;
        int __result__tag39 = 0 ;

        if (__tag39 == null ){
            __tag39 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag39);
        }
        __tag39.setPageContext(pageContext);
        __tag39.setParent(null);
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.ExpectedBalanceQuantity.label", java.lang.String .class,"key"));
        __tag39.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag39;
        __result__tag39 = __tag39.doStartTag();

        if (__result__tag39!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag39== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag39.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag39);
            return true;
        }
        _activeTag=__tag39.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag39);
        __tag39.release();
        return false;
    }

    private boolean _jsp__tag40(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag40 = null ;
        int __result__tag40 = 0 ;

        if (__tag40 == null ){
            __tag40 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag40);
        }
        __tag40.setPageContext(pageContext);
        __tag40.setParent(null);
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.ActualBalanceQty.label", java.lang.String .class,"key"));
        __tag40.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag40;
        __result__tag40 = __tag40.doStartTag();

        if (__result__tag40!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag40== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag40.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag40);
            return true;
        }
        _activeTag=__tag40.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag40);
        __tag40.release();
        return false;
    }

    private boolean _jsp__tag41(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag41 = null ;
        int __result__tag41 = 0 ;

        if (__tag41 == null ){
            __tag41 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag41);
        }
        __tag41.setPageContext(pageContext);
        __tag41.setParent(null);
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
        __tag41.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag41;
        __result__tag41 = __tag41.doStartTag();

        if (__result__tag41!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag41== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag41.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag41);
            return true;
        }
        _activeTag=__tag41.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag41);
        __tag41.release();
        return false;
    }

    private boolean _jsp__tag42(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag42 = null ;
        int __result__tag42 = 0 ;

        if (__tag42 == null ){
            __tag42 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag42);
        }
        __tag42.setPageContext(pageContext);
        __tag42.setParent(null);
        __tag42.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
        __tag42.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag42;
        __result__tag42 = __tag42.doStartTag();

        if (__result__tag42!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag42== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag42.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag42);
            return true;
        }
        _activeTag=__tag42.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag42);
        __tag42.release();
        return false;
    }

    private boolean _jsp__tag43(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag43 = null ;
        int __result__tag43 = 0 ;

        if (__tag43 == null ){
            __tag43 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag43);
        }
        __tag43.setPageContext(pageContext);
        __tag43.setParent(null);
        __tag43.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PackedBy.label", java.lang.String .class,"key"));
        __tag43.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag43;
        __result__tag43 = __tag43.doStartTag();

        if (__result__tag43!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag43== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag43.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag43);
            return true;
        }
        _activeTag=__tag43.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag43);
        __tag43.release();
        return false;
    }

    private boolean _jsp__tag44(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag44 = null ;
        int __result__tag44 = 0 ;

        if (__tag44 == null ){
            __tag44 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag44);
        }
        __tag44.setPageContext(pageContext);
        __tag44.setParent(null);
        __tag44.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.CounterChecked.label", java.lang.String .class,"key"));
        __tag44.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag44;
        __result__tag44 = __tag44.doStartTag();

        if (__result__tag44!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag44== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag44.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag44);
            return true;
        }
        _activeTag=__tag44.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag44);
        __tag44.release();
        return false;
    }

    private boolean _jsp__tag45(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag45 = null ;
        int __result__tag45 = 0 ;

        if (__tag45 == null ){
            __tag45 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag45);
        }
        __tag45.setPageContext(pageContext);
        __tag45.setParent(null);
        __tag45.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.TimeTaken.label", java.lang.String .class,"key"));
        __tag45.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag45;
        __result__tag45 = __tag45.doStartTag();

        if (__result__tag45!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag45== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag45.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag45);
            return true;
        }
        _activeTag=__tag45.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag45);
        __tag45.release();
        return false;
    }

    private boolean _jsp__tag46(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag46 = null ;
        int __result__tag46 = 0 ;

        if (__tag46 == null ){
            __tag46 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag46);
        }
        __tag46.setPageContext(pageContext);
        __tag46.setParent(null);
        __tag46.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.hours.label", java.lang.String .class,"key"));
        __tag46.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag46;
        __result__tag46 = __tag46.doStartTag();

        if (__result__tag46!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag46== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag46.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag46);
            return true;
        }
        _activeTag=__tag46.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag46);
        __tag46.release();
        return false;
    }

    private boolean _jsp__tag47(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag47 = null ;
        int __result__tag47 = 0 ;

        if (__tag47 == null ){
            __tag47 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag47);
        }
        __tag47.setPageContext(pageContext);
        __tag47.setParent(null);
        __tag47.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.authorizedby.label", java.lang.String .class,"key"));
        __tag47.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag47;
        __result__tag47 = __tag47.doStartTag();

        if (__result__tag47!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag47== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag47.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag47);
            return true;
        }
        _activeTag=__tag47.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag47);
        __tag47.release();
        return false;
    }

    private boolean _jsp__tag48(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag48 = null ;
        int __result__tag48 = 0 ;

        if (__tag48 == null ){
            __tag48 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag48);
        }
        __tag48.setPageContext(pageContext);
        __tag48.setParent(null);
        __tag48.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
        __tag48.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag48;
        __result__tag48 = __tag48.doStartTag();

        if (__result__tag48!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag48== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag48.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag48);
            return true;
        }
        _activeTag=__tag48.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag48);
        __tag48.release();
        return false;
    }

    private boolean _jsp__tag49(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag49 = null ;
        int __result__tag49 = 0 ;

        if (__tag49 == null ){
            __tag49 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag49);
        }
        __tag49.setPageContext(pageContext);
        __tag49.setParent(null);
        __tag49.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PackedBy.label", java.lang.String .class,"key"));
        __tag49.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag49;
        __result__tag49 = __tag49.doStartTag();

        if (__result__tag49!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag49== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag49.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag49);
            return true;
        }
        _activeTag=__tag49.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag49);
        __tag49.release();
        return false;
    }

    private boolean _jsp__tag50(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag50 = null ;
        int __result__tag50 = 0 ;

        if (__tag50 == null ){
            __tag50 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag50);
        }
        __tag50.setPageContext(pageContext);
        __tag50.setParent(null);
        __tag50.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.CounterChecked.label", java.lang.String .class,"key"));
        __tag50.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag50;
        __result__tag50 = __tag50.doStartTag();

        if (__result__tag50!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag50== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag50.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag50);
            return true;
        }
        _activeTag=__tag50.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag50);
        __tag50.release();
        return false;
    }

    private boolean _jsp__tag51(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag51 = null ;
        int __result__tag51 = 0 ;

        if (__tag51 == null ){
            __tag51 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag51);
        }
        __tag51.setPageContext(pageContext);
        __tag51.setParent(null);
        __tag51.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.TimeTaken.label", java.lang.String .class,"key"));
        __tag51.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag51;
        __result__tag51 = __tag51.doStartTag();

        if (__result__tag51!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag51== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag51.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag51);
            return true;
        }
        _activeTag=__tag51.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag51);
        __tag51.release();
        return false;
    }

    private boolean _jsp__tag52(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag52 = null ;
        int __result__tag52 = 0 ;

        if (__tag52 == null ){
            __tag52 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag52);
        }
        __tag52.setPageContext(pageContext);
        __tag52.setParent(null);
        __tag52.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.hours.label", java.lang.String .class,"key"));
        __tag52.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag52;
        __result__tag52 = __tag52.doStartTag();

        if (__result__tag52!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag52== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag52.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag52);
            return true;
        }
        _activeTag=__tag52.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag52);
        __tag52.release();
        return false;
    }

    private boolean _jsp__tag53(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag53 = null ;
        int __result__tag53 = 0 ;

        if (__tag53 == null ){
            __tag53 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag53);
        }
        __tag53.setPageContext(pageContext);
        __tag53.setParent(null);
        __tag53.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.authorizedby.label", java.lang.String .class,"key"));
        __tag53.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag53;
        __result__tag53 = __tag53.doStartTag();

        if (__result__tag53!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag53== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag53.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag53);
            return true;
        }
        _activeTag=__tag53.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag53);
        __tag53.release();
        return false;
    }
}
