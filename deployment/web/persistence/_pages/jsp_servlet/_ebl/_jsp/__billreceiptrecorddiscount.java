package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eBL.billreceipt.bc.BillReceiptBC;
import eBL.billreceipt.model.BillReceiptExistOrderExclusion;
import java.net.URLDecoder;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __billreceiptrecorddiscount extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BillReceiptRecordDiscount.jsp", 1738423951408L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

    private static byte[] _getBytes(java.lang.String block){
        try {
            return block.getBytes(_WL_ORIGINAL_ENCODING);
        } catch (java.io.UnsupportedEncodingException u){
            _WL_ENCODED_BYTES_OK = false;
        }
        return null;
    }

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\r\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\r\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="    \r\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n<html>\r\n<head>\r\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n<title>Adhoc Discount Details</title>\r\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\r\n\r\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'/>\r\n<script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script>\r\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\r\n<script language=\"javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\r\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\r\n<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\r\n<script language=\'javascript\' src=\'../../eBL/js/BillReceipt.js\'></script>\r\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\r\n\r\n\r\n<script>\r\n\t$(document).ready(function(){\r\n\t\t\r\n\t\tif($(\'#prevDiscCode\').val() == \'\'){\r\n\t\t\t$(\'#usePrevious\').prop(\'disabled\',\'disabled\');\r\n\t\t}\r\n\t\telse{\r\n\t\t\t$(\'#usePrevious\').prop(\'disabled\',\'\');\r\n\t\t}\r\n\t\t$(\'#close\').click(function(){\r\n\t\t\twindow.close();\r\n\t\t});\r\n\t\t$(\'#usePrevious\').change(function(){\r\n\t\t\tif($(this).prop(\'checked\')){\r\n\t\t\t\t$(\'#discountCode\').val($(\'#prevDiscCode\').val());\r\n\t\t\t\t$(\'#discountDesc\').val($(\'#prevDiscDesc\').val());\r\n\t\t\t}\r\n\t\t\telse{\r\n\t\t\t\t$(\'#discountCode\').val(\'\');\r\n\t\t\t\t$(\'#discountDesc\').val(\'\');\r\n\t\t\t}\r\n\t\t\t\t\t\r\n\t\t});\r\n\t});\r\n</script>\r\n<script>\r\nfunction close(){\r\n\tconst dialogTag = parent.document.getElementById(\"dialog_tag\");    \r\n    dialogTag.close();\r\n}\r\n</script>\r\n<body>\r\n\t<br/>\r\n\t<form>\r\n\t\t<table style=\"width: 95%\" align=\"right\">\r\n\t\t\t<tr style=\"width:100%\">\r\n\t\t\t\t<td width=\"25%\" class=\'LABEL\'>\r\n\t\t\t\t\tService\r\n\t\t\t\t</td>\r\n\t\t\t\t<td class=\'LABEL\' width=\"20%\">\r\n\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\r\n\t\t\t\t</td>\r\n\t\t\t\t<td width=\"5%\"></td>\r\n\t\t\t\t<td class=\'LABEL\' colspan=\'2\'>\r\n\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\r\n\t\t\t\t</td>\r\n\t\t\t\t<td width=\"5%\"></td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td class=\'LABEL\' width=\"25%\">\r\n\t\t\t\t\tItem Code\r\n\t\t\t\t</td>\r\n\t\t\t\t<td class=\'LABEL\' width=\"20%\">\r\n\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\r\n\t\t\t\t</td>\r\n\t\t\t\t<td width=\"5%\"></td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td class=\'LABEL\' width=\"25%\" >\r\n\t\t\t\t\tGross Amount\r\n\t\t\t\t</td>\r\n\t\t\t\t<td class=\'LABEL\' width=\"20%\" id=\'gross\' style=\"text-align:right;\">\r\n\t\t\t\t<span style=\"width: 100px;\">\r\n\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</span>\r\n\t\t\t\t</td>\r\n\t\t\t\t<td width=\"5%\"></td>\r\n\t\t\t\t<td class=\'LABEL\'  width=\"25%\">\r\n\t\t\t\t\tDiscount Amount\r\n\t\t\t\t</td>\r\n\t\t\t\t<td class=\'LABEL\'  width=\"20%\" style=\"text-align:right;\">\r\n\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\r\n\t\t\t\t</td>\r\n\t\t\t\t<td width=\"5%\"></td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td class=\'LABEL\' width=\"25%\">\r\n\t\t\t\t\tNet Amount\r\n\t\t\t\t</td>\r\n\t\t\t\t\r\n\t\t\t\t<td class=\'LABEL\' width=\"20%\" style=\"text-align:right;\">\r\n\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\r\n\t\t\t\t</td>\r\n\t\t\t\t<td width=\"5%\"></td>\r\n\t\t\t\t<td class=\'LABEL\'  width=\"25%\">\r\n\t\t\t\t\tAddl Amount\r\n\t\t\t\t</td>\r\n\t\t\t\t<td class=\'LABEL\'  width=\"20%\" style=\"text-align:right;\">\r\n\t\t\t\t\t&nbsp;\r\n\t\t\t\t</td>\r\n\t\t\t\t<td width=\"5%\"></td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td class=\'LABEL\' width=\"25%\">\r\n\t\t\t\t\tAdhoc Discount %\r\n\t\t\t\t</td>\r\n\t\t\t\t\r\n\t\t\t\t<td class=\'LABEL\' width=\"20%\">\r\n\t\t\t\t\t<input type=\'text\' style=\"text-align: right;\" name=\'discountPer\' id=\'discountPer\' onkeypress=\"return checkAlpha(event)\" id=\'discountPer\' size=\"7\" maxlength=\"5\" \r\n\t\t\t\t\tonblur=\"if(this.value != \'\'){ findDiscount(gross,\'P\',this,netAfterDisc,discountAmt); }else{fnClearCode(discountAmt); $(\'#netAfterDisc\').val($(\'#actGrossAmt\').val());}\">\r\n\t\t\t\t</td>\r\n\t\t\t\t<td width=\"5%\"></td>\r\n\t\t\t\t<td class=\'LABEL\'  width=\"25%\">\r\n\t\t\t\t\tAdhoc Discount Amount\r\n\t\t\t\t</td>\r\n\t\t\t\t<td class=\'LABEL\'  width=\"20%\">\r\n\t\t\t\t\t<input type=\'text\' style=\"text-align: right;\" name=\'discountAmt\' id=\'discountAmt\' id=\'discountAmt\' size=\"17\" maxlength=\"12\" onkeypress=\"return checkAlpha1(event)\"\r\n\t\t\t\t\tonblur=\"if(this.value != \'\'){ findDiscount(gross,\'A\',this,netAfterDisc,discountPer);  }else{fnClearCode(discountPer); $(\'#netAfterDisc\').val($(\'#actGrossAmt\').val());}\">\r\n\t\t\t\t</td>\r\n\t\t\t\t<td width=\"5%\"></td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td class=\'LABEL\' width=\"25%\">\r\n\t\t\t\t\tNet After Disc\r\n\t\t\t\t</td>\r\n\t\t\t\t\r\n\t\t\t\t<td class=\'LABEL\' width=\"20%\">\r\n\t\t\t\t\t<input type=\'text\' style=\"text-align: right;\" name=\'netAfterDisc\' id=\'netAfterDisc\' id=\'netAfterDisc\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' readonly size=\"15\" maxlength=\"3\">\r\n\t\t\t\t</td>\r\n\t\t\t\t<td width=\"5%\"></td>\t\r\n\t\t\t\t<td class=\'LABEL\' width=\"25%\">\r\n\t\t\t\t\tActual Gross Amt.\r\n\t\t\t\t</td>\r\n\t\t\t\t\r\n\t\t\t\t<td class=\'LABEL\' width=\"20%\">\r\n\t\t\t\t\t<input type=\'text\' style=\"text-align: right;\" name=\'actGrossAmt\' id=\'actGrossAmt\' id=\'actGrossAmt\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' readonly size=\"17\" maxlength=\"12\">\r\n\t\t\t\t</td>\t\r\n\t\t\t\t<td width=\"5%\"></td>\t\r\n\t\t\t</tr>\r\n\t\t\t\r\n\t\t\t<tr>\r\n\t\t\t\t<td width=\'25%\' class=\'LABEL\'>\r\n\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\r\n\t\t\t\t</td>\r\n\t\t\t\t<td width=\'20%\' class=\"LABEL\">\r\n\t\t\t\t\t<input type=\'text\' name=\'adhoc_user_id\' id=\'adhoc_user_id\' id=\'adhoc_user_id\' size=\'15\'  maxlength=\'30\'  value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\"  onkeypress =\"changeToUpper()\" \r\n\t\t\t\t\tonBlur =\"userValidation(this,\'U\');\" >\r\n\t\t\t\t</td>\r\n\t\t\t\t<td width=\"5%\"></td>\r\n\t\t\t\t<td width=\'25%\' class=\'LABEL\'>\r\n\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\r\n\t\t\t\t</td>\r\n\t\t\t\t<td width=\'20%\' class=\"LABEL\">\r\n\t\t\t\t\t<input type=\'password\' name=\'user_password\' id=\'user_password\'  id=\'user_password\' size=\'17\'  maxlength=\'30\'  value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\"  \r\n\t\t\t\t\tonblur=\"userValidation(this,\'P\');\" autocomplete=\"off\"><!--V230508-41626 -->\r\n\t\t\t\t</td>\t\t\t\r\n\t\t\t\t<td width=\"5%\"></td>\t\t\t\r\n\t\t\t</tr>\r\n\t\t\t<tr style=\"width:100%\">\r\n\t\t\t\t<td width=\"25%\" class=\'LABEL\'>\r\n\t\t\t\t\tDiscount Reason\r\n\t\t\t\t</td>\r\n\t\t\t\t<td class=\'LABEL\' width=\"20%\">\r\n\t\t\t\t\t<input type=\'text\' name=\'discountCode\' id=\'discountCode\' id=\'discountCode\' size=\"15\" value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" onblur=\"if(this.value!=\'\'){ callCommonLookupCode(discountDesc,discountCode,1,1);  } else{ fnClearCode(discountDesc); }\">\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t</td>\r\n\t\t\t\t<td width=\"5%\"></td>\r\n\t\t\t\t<td class=\'LABEL\' colspan=\'2\'>\r\n\t\t\t\t\t<input type=\'text\' name=\'discountDesc\' id=\'discountDesc\' id=\'discountDesc\' size=\"44\" value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" onblur=\"if(this.value!=\'\'){ callCommonLookupCode(discountDesc,discountCode,1,2);} else{ fnClearCode(discountCode); }\">&nbsp;\r\n\t\t\t\t\t<input type=\'button\' class=\'button\' name=\"discountBtn\" id=\"discountBtn\" value=\'?\' onClick=\"callCommonLookupCode(discountDesc,discountCode,1,2); \" tabindex=\'2\'>\r\n\t\t\t\t</td>\r\n\t\t\t\t<td width=\"5%\"></td>\r\n\t\t\t</tr>\r\n\t\t\t<tr style=\"width:100%\">\r\n\t\t\t\t<td class=\'LABEL\' colspan=\'2\'>\r\n\t\t\t\t\t<input type=\'checkbox\' id=\'usePrevious\' name=\'usePrevious\' id=\'usePrevious\' >&nbsp;Use Prev.Disc.Reason\r\n\t\t\t\t</td>\t\t\r\n\t\t\t\t<td width=\"5%\"></td>\t\t\r\n\t\t\t\t<td class=\'LABEL\' colspan=\'2\'>\r\n\t\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\r\n\t\t\t\t\t\t<input type=\'checkbox\' id=\'makeDefault\' name=\'makeDefault\' id=\'makeDefault\' >&nbsp;Make Default\r\n\t\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\r\n\t\t\t\t\t\t<input type=\'checkbox\' id=\'makeDefault\' name=\'makeDefault\' id=\'makeDefault\' checked>&nbsp;Make Default\r\n\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\r\n\t\t\t\t</td>\r\n\t\t\t\t<td width=\"5%\"></td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td colspan = \'5\' align=\"right\">\r\n\t\t\t\t<input type=\'button\' class=\'button\' id=\'validateDiscount\' name=\'validateDiscount\' id=\'validateDiscount\' value=\'Ok\' onclick=\"validate();\">\r\n\t\t\t\t&nbsp;&nbsp;\r\n\t\t\t\t<input type=\'button\' class=\'button\' value=\'Close\' id=\'close\'>\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t</table>\r\n\t<input type=\'hidden\' name=\'payer\' id=\'payer\' id=\'payer\' value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'>\r\n\t<input type=\'hidden\' name=\'moduleId\' id=\'moduleId\' id=\'moduleId\' value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'>\r\n\t<input type=\'hidden\' name=\'episodeType\' id=\'episodeType\' id=\'episodeType\' value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'>\r\n\t<input type=\'hidden\' name=\'patientId\' id=\'patientId\' id=\'patientId\' value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'>\r\n\t<input type=\'hidden\' name=\'episodeId\' id=\'episodeId\' id=\'episodeId\' value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'>\r\n\t<input type=\'hidden\' name=\'visitId\' id=\'visitId\' id=\'visitId\' value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'>\r\n\t<input type=\'hidden\' name=\'facilityId\' id=\'facilityId\' id=\'facilityId\' value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'>\r\n\t<input type=\'hidden\' name=\'locale\' id=\'locale\' id=\'locale\' value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'>\r\n\r\n\t<input type=\'hidden\' name=\'blngServCode\' id=\'blngServCode\' id=\'blngServCode\' value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'>\r\n\t<input type=\'hidden\' name=\'trxDocRef\' id=\'trxDocRef\' id=\'trxDocRef\' value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'>\r\n\t<input type=\'hidden\' name=\'trxDocRefLineNum\' id=\'trxDocRefLineNum\' id=\'trxDocRefLineNum\' value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'>\r\n\t<input type=\'hidden\' name=\'trxDocRefSeqNum\' id=\'trxDocRefSeqNum\' id=\'trxDocRefSeqNum\' value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'>\r\n\t<input type=\'hidden\' name=\'serviceItemCode\' id=\'serviceItemCode\' id=\'serviceItemCode\' value=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'>\r\n\t<input type=\'hidden\' name=\'serviceDate\' id=\'serviceDate\' id=\'serviceDate\' value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'>\r\n\t<input type=\'hidden\' name=\'prevDiscCode\' id=\'prevDiscCode\' id=\'prevDiscCode\' value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'>\t\t\r\n\t<input type=\'hidden\' name=\'prevDiscDesc\' id=\'prevDiscDesc\' id=\'prevDiscDesc\' value=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'>\r\n\t<input type=\'hidden\' name=\'noOfDecimals\' id=\'noOfDecimals\' id=\'noOfDecimals\' value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'>\r\n\t<input type=\'hidden\' name=\'loginUser\' id=\'loginUser\' id=\'loginUser\' value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'>\r\n\r\n\t<input type=\'hidden\' name=\'hdnDiscPer\' id=\'hdnDiscPer\' id=\'hdnDiscPer\' value=\'\'>\r\n\t<input type=\'hidden\' name=\'hdnDiscAmt\' id=\'hdnDiscAmt\' id=\'hdnDiscAmt\' value=\'\'>\r\n\t<input type=\'hidden\' name=\'hdnUserId\' id=\'hdnUserId\' id=\'hdnUserId\' value=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'>\r\n\t</form>\r\n</body>\r\n</html>";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );
	
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

	
	private String checkForNull(String input)
	{
		if(input == null || "null".equals(input)){
			input = "";
		}
		return input;
	}

	private String decodeParam(String input){
		String output = "";
		try{
			 if(input!=null){
				input = input.replaceAll("%(?![0-9a-fA-F]{2})", "%25");
				input = input.replaceAll("\\+", "%2B");
				output = URLDecoder.decode(input,"UTF-8");
			 }
		}
		catch(Exception e){
			System.err.println("Exception while Decoding BillReceiptAjax->"+e);
		}
		return output;
	}


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=ISO-8859-1");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=ISO-8859-1");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String blngServCode = checkForNull(request.getParameter("blngServCode"));
	String blngServDesc = decodeParam(request.getParameter("blngServDesc"));
	String trxDocRef = checkForNull(request.getParameter("trxDocRef"));
	String trxDocRefLineNum = checkForNull(request.getParameter("trxDocRefLineNum"));
	String trxDocRefSeqNum = checkForNull(request.getParameter("trxDocRefSeqNum"));
	String serviceItemCode = checkForNull(request.getParameter("serviceItemCode"));
	String serviceItemDesc = decodeParam(request.getParameter("serviceItemDesc"));
	String gross = checkForNull(request.getParameter("gross"));
	String discount = checkForNull(request.getParameter("discount"));
	String net = checkForNull(request.getParameter("net"));
	String payer = checkForNull(request.getParameter("payer"));
	String moduleId = checkForNull(request.getParameter("moduleId"));
	String episodeType = checkForNull(request.getParameter("episodeType"));
	String patientId = checkForNull(request.getParameter("patientId"));
	String episodeId = checkForNull(request.getParameter("episodeId"));
	String visitId = checkForNull(request.getParameter("visitId"));
	String facilityId = (String) session.getValue("facility_id");
	String locale = (String) session.getValue("LOCALE");
	String serviceDate = checkForNull(request.getParameter("serviceDate"));
	String noOfDecimals = request.getParameter("noOfDecimals");
	String loginUser = (String) session.getValue("login_user");
	BillReceiptBC bc = new BillReceiptBC();
	String userPasword  = bc.getCredentails(loginUser);
	String beanId = "BillReceiptExistOrderExclusion" ;
	String beanName = "eBL.billreceipt.model.BillReceiptExistOrderExclusion";
	BillReceiptExistOrderExclusion exclusionBean = (BillReceiptExistOrderExclusion) getObjectFromBean(beanId, beanName, session);
	String discount_allowed_yn = "Y";
	String loggd_user_valid_for_disc_YN ="N";		

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(blngServCode ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(blngServDesc ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(serviceItemCode ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(serviceItemDesc ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(gross ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(discount ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(net ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(net ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(gross ));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(loginUser));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(userPasword));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(checkForNull(exclusionBean.getDefDiscCode()) ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(checkForNull(exclusionBean.getDefDiscDesc()) ));
            _bw.write(_wl_block23Bytes, _wl_block23);
if("".equals(checkForNull(exclusionBean.getDefDiscCode()))){ 
            _bw.write(_wl_block24Bytes, _wl_block24);
} else{ 
            _bw.write(_wl_block25Bytes, _wl_block25);
} 
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(payer ));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(moduleId ));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(episodeType ));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(patientId ));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(episodeId ));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(visitId ));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(facilityId ));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(locale ));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(blngServCode ));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(trxDocRef ));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(trxDocRefLineNum ));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(trxDocRefSeqNum ));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(serviceItemCode ));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(serviceDate ));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(checkForNull(exclusionBean.getPrevDiscCode()) ));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(checkForNull(exclusionBean.getPrevDiscDesc()) ));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(noOfDecimals ));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(loginUser ));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(loginUser));
            _bw.write(_wl_block45Bytes, _wl_block45);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.userid.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PIN.label", java.lang.String .class,"key"));
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
}
