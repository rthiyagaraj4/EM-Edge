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
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __wardreturnaction extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/WardReturnAction.jsp", 1732171933095L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n\t<head>\n\t\t<title></title>\n\t\t<!-- <link rel=\"stylesheet\" type =\"text/css\" href=\"../../eCommon/html/IeStyle.css\"></link> -->\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../ePH/js/PhCommon.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/CommonResult.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../ePH/js/WardReturn.js\"></script>\n\t\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../js/PHReports.js\"></SCRIPT>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/CommonLookup.js\"></SCRIPT>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/dchk.js\"></script>\n\t\n\t</head>\n\t<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" >\n\t\t<form id=\"FormWardReturnAction\" name=\"FormWardReturnAction\" id=\"FormWardReturnAction\">\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t\t\t\t<script>alert(getMessage(\"NOT_A_VALID_BARCODE\",\"PH\")); cancelAction();</script>\n\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t<script>alert(getMessage(\"NOT_A_VALID_BARCODE\",\"PH\")); cancelAction();</script>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t<script> alert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\"));parent.parent.reset();</script>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t<script>alert(getMessage(\"NOT_A_VALID_BARCODE\",\"PH\"));</script>\n\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n<script type=\"text/javascript\">\nvar barcode=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\';\nvar barcodeDrug =\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\';\nvar formObjdrug=parent.wardretmedicationdrugframe.FormWardReturnDrug;\nvar check=formObjdrug.DrugSelect;\nvar drugid=formObjdrug.drugid;\nvar drugselect = formObjdrug.DrugSelect;\nfor(i=0;i<check.length;i++){\n  if(drugid[i].value==barcodeDrug){\n\t  drugselect[i].checked=true;\n\t  break;\n  }\n}\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="<script>\n       alert(getMessage(\"PH_EXCEED_BALANCE_QTY\",\"PH\"));\n       </script>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t<TABLE width=\"100%\" align=\"left\" cellspacing=\"0\" cellpadding=\"0\" border=\"1\">\n\t\t\t\t\t<TR>\n\t\t\t\t\t\t<Th colspan=13 style=\"background-color:#FFD7D7;color:black;border-color:#FFD7D7\" align=\"left\">";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</Th>\n\t\t\t\t\t</TR>\n\t\t\t\t\t<TR>\n\t\t\t\t\t    ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t\t <td class=\'COLUMNHEADER\' width=6%>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="<input type=\"checkbox\" name=\"Selcet_chk\" id=\"Selcet_chk\" value=\'\' onClick=\"SelectAll_1(this,\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\')\"></td>\n\t\t\t\t\t\t    ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t    <td class=\'COLUMNHEADER\'  width=26%>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td>\n\t\t\t\t\t\t<td class=\'COLUMNHEADER\' width=8%>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td>\n\t\t\t\t\t\t<td class=\'COLUMNHEADER\' width=10%>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td> \n\t\t\t\t\t\t<td class=\'COLUMNHEADER\' width=6%>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</td>\n\t\t\t\t\t\t<td class=\'COLUMNHEADER\' width=6%>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</td>\n\t\t\t\t\t\t<td class=\'COLUMNHEADER\' width=12%>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</td>\n\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t\t\t\t<TR >\n\t\t\t\t\t\t\t\t    ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =" \n\t\t\t\t\t\t\t    <td class=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\"><input type=\"checkbox\" name=\"check_name";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" id=\"check_name";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" onClick=\"selectCheck(";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =")\" ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="></td>\n\t\t\t\t\t\t\t      ";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t\t\t\t\t\t<TD class=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" style=\"font-family:verdana;font-size:8pt;\" align=\"left\">\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =" - ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t\t\t\t\t\t\t<label class=\"label\" style=\"font-size:xx-small;font-weight:normal\" >(";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 =")</label> \n";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t\t\t\t<TD class=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" style=\"font-family:verdana;font-size:8pt;\">\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 =" \n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"dispno";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" id=\"dispno";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" value=";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 =">\n\t\t\t\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t\t\t\t<TD  class=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"disp_date_time";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\" id=\"disp_date_time";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 =">\n\t\t\t\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t\t\t\t<TD class=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\" style=\"font-family:verdana;font-size:8pt;\"  align=\"right\" nowrap>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="<br>\n";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t<b>";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="<b>\n";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\" nowrap>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 =" <!-- changed (String)batchDetails.get(i+6) batch_uom for BRU-SCF-1842-->\n\t\t\t\t\t\t\t\t\t</TD>\n\n\t\t\t\t\t\t\t\t\t<TD align=\"right\" class=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\">\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="</TD>\n\t\t\t\t\t\t\t\t\t<TD>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t\t\t\t\t\t<input type=\'text\'  maxlength=3 size=3 style=\"text-align:right\" name=\"actualReturn";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\" id=\"actualReturn";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="  id=\"actualReturn";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\"  onKeyPress=\" if(event.keyCode!=13) {return allowValidNumber(this,event,3,0);}else{return false;}\"onblur=\"CheckPositiveNumber(this);checkQty(this,";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 =",";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 =",\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\',\'";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\');StoreCheck(";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 =");checkOnChange(";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 =");saveChangedQty(this,";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 =");\">\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t\t\t\t\t\t\t\t <input type=\'text\'  maxlength=3 size=3 style=\"text-align:right\" name=\"actualReturn";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"returnable";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\" id=\"returnable";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 =">\t\t\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"disp_locn_code";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\" id=\"disp_locn_code";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 =">\t\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"patient_class";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\" id=\"patient_class";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 =">\t\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"order_id";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\" id=\"order_id";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 =">\t\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"order_line_no";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\" id=\"order_line_no";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 =">\t\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"srl_no";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\" id=\"srl_no";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 =">\t\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"srl_no_batch";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\" id=\"srl_no_batch";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 =">\t\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"qty_uom";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\" id=\"qty_uom";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 =">\t\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"drugcodes";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\" id=\"drugcodes";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 =">\t\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"from_locn_code";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\" id=\"from_locn_code";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 =">\t\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"encounter_id";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\" id=\"encounter_id";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 =">\t\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"tot_admin_qty";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\" id=\"tot_admin_qty";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 =">\t\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"StoreCount";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\" id=\"StoreCount";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 =">\t<!-- GHL-SCF-1395-->\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t\t\t</TR>\n";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\n\t\t\t\t\t\t<script>alert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\"));parent.parent.reset();</script>\n";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\n\t\t\t<script>\n   \t\t\t\t\t var rowCount = ";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 =";  \n    \t\t\t\t\tparent.wardretmedicationbuttonframe.location.href = \"../../ePH/jsp/WardReturnButton.jsp?countRows=\" + rowCount;\n\t\t\t</script>\n\t\t\t<INPUT TYPE=\"hidden\" name=\"remarks\" id=\"remarks\" VALUE=\"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"mode\" id=\"mode\" VALUE=\"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"bean_id\" id=\"bean_id\" VALUE=\"";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"bean_name\" id=\"bean_name\" VALUE=\"";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"patientid\" id=\"patientid\" VALUE=\"";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\">\n\n\t\t\t<INPUT TYPE=\"hidden\" name=\"disabledCoun\" id=\"disabledCoun\" VALUE=\"";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"totalrows\" id=\"totalrows\" VALUE=\"";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"ToStore\" id=\"ToStore\" VALUE=\"";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"ToStoreCode\" id=\"ToStoreCode\" VALUE=\"";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"site\" id=\"site\" VALUE=\"";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\"> <!--  Added for GHL-CRF-0413.8 -->\n\t\t</form>\n";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);

		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

try{
			String mode	= CommonRepository.getCommonKeyValue("MODE_INSERT"); 
			java.util.Properties prop = (java.util.Properties) session.getValue( "jdbc" ) ;
			String login_at_ws_no		        = prop.getProperty( "client_ip_address" );
			String bean_id		= "WardReturnBean"+login_at_ws_no;
			String bean_name	= "ePH.WardReturnBean";
			String facility_id					= (String) session.getValue("facility_id");

			WardReturnBean bean = (WardReturnBean)getBeanObject( bean_id,bean_name,request) ;
			bean.clear() ;
			bean.setLanguageId(locale);
			bean.setMode( mode ) ;
			
			//Search Criteria's from Query Criteria page
			String patientid		= CommonBean.checkForNull(request.getParameter( "patientid" ));
			String drugcodes		= request.getParameter( "drugcodes" );
			String dispno     		= request.getParameter( "dispno" ) ;
			String cutoff     		= request.getParameter( "cutoff" ) ;
			String orderid     		= request.getParameter( "orderid" ) ;
			String displocn     	= request.getParameter( "dispLocn" ) ;
			String remarks     		= request.getParameter( "remarks" ) ;
			String ToStoreCode     	= request.getParameter( "ToStoreCode" ) ;
			String ToStore     	    = request.getParameter( "ToStore" ) ;
                        String drugcodes1       = request.getParameter( "checkstring1")==null?"":request.getParameter( "checkstring1"); // Added for GHL-CRF-0413.8 - Start
                        String barcode_id       = request.getParameter( "barcode_id" )==null?"":request.getParameter( "barcode_id" );
						barcode_id=barcode_id.trim();  // Added for GHL-CRF-0413.8 
                        String calledFrom       = request.getParameter("calledFrom")==null?"":request.getParameter("calledFrom");
                        if(!calledFrom.equals("ScannedBatch")){
							bean.getScannedBatchDetails().clear(); 
							bean.getscannedDetails().clear(); 
                        } // Added for GHL-CRF-0413.8  - End
			StringBuffer issue_qty_dtl   = new StringBuffer(); 
			HashMap IssueUOMAndBaseUOM	 = new HashMap();
			HashMap binLocationDetails	 = new HashMap();
			ArrayList binLocation=new ArrayList();

			String dflt_issue_uom		 = "";
			String base_uom			     = "";
			int base_to_disp_uom_equl    = 0;
			int base_to_def_uom_equl     = 0;
			int base_to_issue_uom_equl   = 0;
			int base_to_to_store_def_uom_equl = 0;
			int final_conv_factor        = 0;
			String to_store_def_issue_uom ="";
			String issue_uom_by			 = bean.getISSUE_UOM_BY ();

			String order_line_staus      = "";
			String dis_cont_reason       = "";
			String DISC_DATE_TIME		 = "";
			String pract_name			 = "";
			String nationalid			 = "" ;
			String healthcard     		 = "" ;
			String drug_code     		 = "" ;
			String status				 = "" ;
			int disabledCount			 = 0;
			boolean flag				 = false;

			String StoreCount			 = "" ;
			boolean site                 = bean.isSiteSpecific("PH", "WARD_ACK"); // Added for GHL-CRF-0413.8
			boolean barcode_2d_applicable = bean.isSiteSpecific("ST","2D_BARCODE_APPLICABLE");
			/* Initialize Function specific start */
			if(patientid.equals("")){
				patientid=(String)bean.getPatient_ID(dispno);
			}
			ArrayList checkedArray = new ArrayList();
			ArrayList batchDetails = bean.getScannedBatchDetails();
			
			HashMap scanned = bean.getscannedDetails();
		    batchDetails=bean.getBatchDetails(patientid,drugcodes,nationalid,healthcard,dispno,cutoff,orderid,displocn,ToStoreCode,barcode_id); // barcode_id Added for GHL-CRF-0413.8
			if ((batchDetails.size()==0 && !batchDetails.contains(barcode_id.trim())) && site && !barcode_id.equals("")){ // Added for GHL-CRF-0413.8 - Start
				
            _bw.write(_wl_block9Bytes, _wl_block9);

							}
			
			if(bean.getScannedBatchDetails().size()>0){ 
				batchDetails = bean.getScannedBatchDetails();
			} // Added for GHL-CRF-0413.8 - End
				
			int totalRows=batchDetails.size()/33; //changed 32 to 33 for BRU-SCF-1842
			int increment =33;//changed 32 to 33 for BRU-SCF-1842
		
			if(site || barcode_2d_applicable){ // if condition Added for GHL-CRF-0413.8 -Start
				
				totalRows=batchDetails.size()/35; //changed 34 to 35 for BRU-SCF-1842
				increment =35; //changed 34 to 35 for BRU-SCF-1842
			} // if condition Added for GHL-CRF-0413.8  - End
			int administred_count =0;
			if ((batchDetails.size()==0 && !batchDetails.contains(barcode_id.trim())) && site && !barcode_id.equals("")){ // else if Added for GHL-CRF-0413.8 - Start
				
            _bw.write(_wl_block10Bytes, _wl_block10);

			} 
			else if (batchDetails.size()==0 && !site){

            _bw.write(_wl_block11Bytes, _wl_block11);

			}
			else{
				if((batchDetails.size()>0 && !batchDetails.contains(barcode_id.trim())) && site && !barcode_id.equals("")){
					
            _bw.write(_wl_block12Bytes, _wl_block12);

				}
				else if(site && !barcode_id.equals("") && batchDetails.size()>0){

            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(barcode_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(batchDetails.get((batchDetails.indexOf(barcode_id))-17)));
            _bw.write(_wl_block15Bytes, _wl_block15);
} 
	boolean Filled=false;
	if(!barcode_id.equals("") && site){
    	if(batchDetails.contains(barcode_id.trim())){
             for(int i=0;i<batchDetails.size();i+=35){ // 34 Changed to 35 for ML-BRU-SCF-1842 (PO Raised Issue)
            	 int incrmt = (Integer)batchDetails.get(i+33); 
            	 if(batchDetails.get(i+32).equals(barcode_id.trim())){
            		if(Integer.parseInt((String)batchDetails.get(i+21))>incrmt){
            			incrmt=incrmt+1;
            			batchDetails.set((i+33), incrmt);
            			scanned.put(batchDetails.get(i+3), "Y");
            			bean.setscannedDetails(scanned);
            			bean.setScannedBatchDetails(batchDetails);
            			Filled = true;
            			break;
            		}
            	 }
             }
          if(!Filled){
       
            _bw.write(_wl_block16Bytes, _wl_block16);
 
          }
          } 		
    } // Added for GHL-CRF-0431.8 - End
	
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
if(site){ // Added for GHL-CRF-0413.8[IN063028] -Start 
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(totalRows));
            _bw.write(_wl_block21Bytes, _wl_block21);
} // Added for GHL-CRF-0413.8[IN063028] -End 
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

					int rowCount=0;
					String classvalue="";
					String batch_uom = "";//added for BRU-SCF-1842
					if(batchDetails!=null && batchDetails.size()>1){ // added for icn63722	
						for (int i=0,count=1;i<batchDetails.size();i+=increment){// Incremented 30 to 31  AMS-SCF-190 IN038440 // 31 changed to increment for GHL-CRF-0413.8
							if ( rowCount++ % 2 == 0 ){
								classvalue = "QRYEVEN" ;
							}
							else{
								classvalue = "QRYODD" ;
							}
							if(batchDetails.get(i+20).equals("Y")&& !batchDetails.get(i+21).equals("0")){
								flag   =	true;
								issue_qty_dtl			 =  new StringBuffer(); 
								IssueUOMAndBaseUOM		 =	(HashMap)bean.getStoreDfltIssueUOMAndBaseUOM((String)batchDetails.get(i+15),(String)batchDetails.get(i+14));			
								dflt_issue_uom			 =	(String)IssueUOMAndBaseUOM.get("DEF_ISSUE_UOM");
								base_uom			     =  (String)IssueUOMAndBaseUOM.get("BASE_UOM");
								to_store_def_issue_uom   = 	(String)batchDetails.get(i+19);
								StoreCount="0";
								if(!to_store_def_issue_uom.equals("")){	
								   StoreCount="1";
								}
								
								drug_code=(String)batchDetails.get(i+15);
								binLocation		 =	bean.getBinDetails(drug_code,displocn,locale);	
								
								base_to_disp_uom_equl    =	bean.getEqulValue ( (String)batchDetails.get(i+15), base_uom, (String)batchDetails.get(i+6));	
								base_to_def_uom_equl     =	bean.getEqulValue ( (String)batchDetails.get(i+15),base_uom, dflt_issue_uom);			
								final_conv_factor        =	bean.lcm( base_to_disp_uom_equl,base_to_def_uom_equl);
								base_to_to_store_def_uom_equl =	bean.getEqulValue ( (String)batchDetails.get(i+15),base_uom, to_store_def_issue_uom);

								if(site){ //if else added for BRU-SCF-1842
									batch_uom = (String)batchDetails.get(i+34);
								}else{
									batch_uom = (String)batchDetails.get(i+32);
								}
							 	//if(base_to_disp_uom_equl!=0 &&base_to_def_uom_equl!=0)COMMENTED FOR ML-BRU-SCF-1880
									if(base_to_disp_uom_equl != base_to_def_uom_equl){
									if(!((String)batchDetails.get(i+23)).equals("")){		
										if(issue_uom_by.equals("I")){
											base_to_issue_uom_equl   =  bean.getEqulValue ( (String)batchDetails.get(i+15),base_uom,(String)batchDetails.get(i+23));
											if(!displocn.equals(ToStore)){
											   final_conv_factor        =	bean.lcm( final_conv_factor,base_to_to_store_def_uom_equl);
											} 
											else{
											   final_conv_factor        =	bean.lcm( final_conv_factor,base_to_issue_uom_equl);
											}
										}	
										issue_qty_dtl.append("( ").append((String)batchDetails.get(i+22)).append((String)batchDetails.get(i+24)).append(" )");
									}
									if(final_conv_factor>1)
									{final_conv_factor =final_conv_factor/base_to_disp_uom_equl;	//commented for ML-BRU-SCF-1880
									}
								}

            _bw.write(_wl_block29Bytes, _wl_block29);
 String checkYN ="";  // Added for GHL-CRF-0413.8[IN063028] - Start
								    if(site){  
								    	if(scanned.containsKey(batchDetails.get(i+3)) && scanned.get(batchDetails.get(i+3)).equals("Y"))
								            checkYN="checked";
								         else
								            checkYN ="";
								            	
								    
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(count));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(count));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(count));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(checkYN));
            _bw.write(_wl_block35Bytes, _wl_block35);
} // Added for GHL-CRF-0413.8[IN063028] - End 
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(batchDetails.get(i)));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(batchDetails.get(i+29)));
            _bw.write(_wl_block1Bytes, _wl_block1);

										if(bean.getTradeName_Flag().equals("Y") && (batchDetails.get(i+30)!=null && !batchDetails.get(i+30).equals(""))){ // if block added for AMS-SCF-190 IN038440

            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(batchDetails.get(i+30) ));
            _bw.write(_wl_block40Bytes, _wl_block40);

										}

            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(batchDetails.get(i+1)));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate((String)batchDetails.get(i+2),"DMY","en",locale)));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(batchDetails.get(i+3)));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(batchDetails.get(i+18)));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(count));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(count));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(count));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(batchDetails.get(i+3)));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate((String)batchDetails.get(i+4),"DMY","en",locale)));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(count));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(count));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(count));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf((String)batchDetails.get(i+4)));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(batchDetails.get(i+5)));
            _bw.write(_wl_block51Bytes, _wl_block51);

									if(issue_uom_by.equals("I")){

            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(issue_qty_dtl.toString()));
            _bw.write(_wl_block53Bytes, _wl_block53);

									}

            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(bean.getUomDisplay(facility_id,batch_uom)));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(batchDetails.get(i+21)));
            _bw.write(_wl_block57Bytes, _wl_block57);
if(site && (!barcode_id.equals("") || drugcodes1.length()>0) && scanned.containsKey(batchDetails.get(i+3)) && scanned.get(batchDetails.get(i+3)).equals("Y")){
									
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(count));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(count));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(batchDetails.get(i+33)));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(count));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(final_conv_factor));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(base_to_disp_uom_equl));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(base_to_def_uom_equl));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf((String)batchDetails.get(i+6)));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(dflt_issue_uom));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(StoreCount));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(count));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(count));
            _bw.write(_wl_block68Bytes, _wl_block68);
}else if(site){ 
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(count));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(count));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(count));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(final_conv_factor));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(base_to_disp_uom_equl));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(base_to_def_uom_equl));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf((String)batchDetails.get(i+6)));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(dflt_issue_uom));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(StoreCount));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(count));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(count));
            _bw.write(_wl_block68Bytes, _wl_block68);
} 
									 else{
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(count));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(count));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(count));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(final_conv_factor));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(base_to_disp_uom_equl));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(base_to_def_uom_equl));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf((String)batchDetails.get(i+6)));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(dflt_issue_uom));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(StoreCount));
            _bw.write(_wl_block68Bytes, _wl_block68);
} 
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(count));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(count));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(count));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(batchDetails.get(i+21)));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(count));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(count));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(count));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(batchDetails.get(i+14)));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(count));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(count));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(count));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(batchDetails.get(i+25)));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(count));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(count));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(count));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(batchDetails.get(i+26)));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(count));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(count));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(count));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(batchDetails.get(i+27)));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(count));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(count));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(count));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(batchDetails.get(i+9)));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(count));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(count));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(count));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(batchDetails.get(i+10)));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(count));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(count));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(count));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(batchDetails.get(i+6)));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(count));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(count));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(count));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(batchDetails.get(i+15)));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(count));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(count));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(count));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(batchDetails.get(i+28)));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(count));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(count));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(count));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(batchDetails.get(i+29)));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(count));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(count));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(count));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(batchDetails.get(i+31)));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(count));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(count));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(count));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(StoreCount));
            _bw.write(_wl_block96Bytes, _wl_block96);

								count++;
							}
							else{
							   administred_count++;
							}
						}
					}//end if
				
					if(!flag && batchDetails.size() != 1 ){ // modefied for icn63722

            _bw.write(_wl_block97Bytes, _wl_block97);

					}
				}

            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf( totalRows - administred_count ));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf( remarks ));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf( mode ));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf( bean_id ));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf( bean_name ));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf( patientid ));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf( disabledCount));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(totalRows-administred_count));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(ToStore));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(ToStoreCode));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(site));
            _bw.write(_wl_block109Bytes, _wl_block109);

		putObjectInBean(bean_id,bean,request); 
	}catch(Exception e){
		e.printStackTrace();
	}

            _bw.write(_wl_block110Bytes, _wl_block110);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DispensedDrugDetails.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Drug.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.expiryDate.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DispenseNo.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DispenseLocation.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DispensedDate.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.IssuedQuantity.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.QtyUOM.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.MaxReturnQty.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.ReturnedQuantity.label", java.lang.String .class,"key"));
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
}
