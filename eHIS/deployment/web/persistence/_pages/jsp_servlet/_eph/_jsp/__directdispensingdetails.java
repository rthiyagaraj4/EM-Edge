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
import java.text.DecimalFormat;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __directdispensingdetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/DirectDispensingDetails.jsp", 1709120670408L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n\t<head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n\t\t<script language=\"JavaScript\" src=\"../../ePH/js/DirectDispensing.js\"></script> \n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<body onMouseDown=\"\" onKeyDown=\"lockKey()\">\n\t\t<form name=\"DirectDispDispensingDetails\" id=\"DirectDispDispensingDetails\" >\n\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\"  border=\"1\" >\n\t\t\t\t<tr>  \n\t\t\t\t\t <td class= \"COLUMNHEADER\" width=\"35%\" style=\"font-size:9\">";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =" </td>\n\t\t\t\t\t <td class= \"COLUMNHEADER\" width=\"8%\" style=\"font-size:9\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="  </td>\n\t\t\t\t\t <td class= \"COLUMNHEADER\" width=\"8%\" style=\"font-size:9\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =" </td>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t\t<td class= \"COLUMNHEADER\" width=\"10%\" style=\"font-size:9\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t\t\t\t\t\t<td class= \"COLUMNHEADER\" width=\"10%\" style=\"font-size:9\">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\t\n\t\t\t\t\t\t<td class= \"COLUMNHEADER\" width=\"10%\" style=\"font-size:9\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t\t<td class= \"COLUMNHEADER\" width=\"7%\" style=\"font-size:9\">&nbsp;</td>\n\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t <td class= \"COLUMNHEADER\" width=\"10%\" style=\"font-size:9\">";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t<td class= \"COLUMNHEADER\" width=\"15%\" style=\"font-size:9\"> ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" &nbsp;&nbsp;&nbsp;&nbsp;</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t <td class= \"COLUMNHEADER\" width=\"17%\" style=\"font-size:9\">";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td> \n\t\t\t\t</tr>\n ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td align=\"left\"  class=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\"nowrap style=\"font-size:9\" title=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\t<label style=\"cursor:pointer;\"  id=\"drug_desc";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="&nbsp;</label>&nbsp;\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t\t\t\t\t<img src=\"../../ePH/images/Patientcounsel.gif\" valign=\"center\"  ></img>\n\t\t\t\t\t\t\t\t\t<input type=checkbox name=pat_reqd_";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =" ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =" value=\'C\' onclick=\"CheckPatReqd(this)\">\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"pat_reqd_";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" id=\"pat_reqd_";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\"    value=\"N\">\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\t\t\t\t</td>               \n\t\t\t\t\t\t\t\t<!-- <td align=\"right\"  class=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" nowrap style=\"font-size:9\"title=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'   >&nbsp;";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="(";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =")&nbsp;</td> commented on 8/10/09 -->\n\t\t\t\t\t\t\t\t<td align=\"right\"  class=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 =")&nbsp;</td> \n\t\t\t\t\t\t\t\t<td align=\"right\"  class=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\"nowrap style=\"font-size:8\" title=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' >&nbsp;<b>";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="&nbsp;";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</b><br><label id=\"issue_uom_lbl";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" class=\"label\" style=\"font-size:9\" ><b>&nbsp;";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</b></label></td>\n\t\t\t\t\t\t\t\t<td align=\"right\"  class=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\"nowrap style=\"font-size:9\"  title=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\'>&nbsp;";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="&nbsp;</td>\n";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\"align=\"center\" id=\'gross_charge_amount_";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="</td>\n\t\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\" align=\"center\"id=\'pat_charge_amount_";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</td>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\t\n\t\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\"align=\"center\" id=\'gross_charge_amount_payable_";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="</td><!-- added for ml-bru-crf-0469 -->\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"override_allowed_yn_";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\" id=\"override_allowed_yn_";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\"   value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"excl_incl_ind_";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\" id=\"excl_incl_ind_";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\"         value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"excl_incl_ind_default_";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\" id=\"excl_incl_ind_default_";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\" value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"approval_reqd_yn_";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\" id=\"approval_reqd_yn_";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\"      value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"bl_incl_excl_override_reason_desc_";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\" id=\"bl_incl_excl_override_reason_desc_";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"bl_incl_excl_override_reason_code_";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\" id=\"bl_incl_excl_override_reason_code_";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"tot_alloc_qty_";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\" id=\"tot_alloc_qty_";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"batch_str_";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\" id=\"batch_str_";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\"             value=\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\"> \n";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\" ><a href=\"javascript:callIncludeExclude(\'";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\',\'";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\');\" id=\"include_exclude\"  style=\"font-size:9;\">";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="?</a></td>  \n";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\" >&nbsp;</td>\n";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\'>&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\'>&nbsp;</td>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\" align=\"center\"id=\'gross_charge_amount_payable_";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\'>&nbsp;</td><!-- added for ml-bru-crf-0469 -->\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\"   value=\"\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"excl_incl_ind_";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\"         value=\"\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"excl_incl_ind_default_";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\" value=\"\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"approval_reqd_yn_";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\"      value=\"\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"bl_incl_excl_override_reason_desc_";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\" value=\"\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"bl_incl_excl_override_reason_code_";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\" value=\"\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"tot_alloc_qty_";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\"         value=\"\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"batch_str_";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\"             value=\"\">        \n\t\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\n\t\t\t\t\t\t\t\t<td align=\"left\"  class=\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\"nowrap style=\"font-size:9\">\n\t\t\t\t\t\t\t\t\t<label style=\"cursor:pointer;color:blue;font-size:9;\" id=\"edit_remarks";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\" onClick=\"callEditDetails(this,\'";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\',\'D\',";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 =");\">";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 =" </label><br><label style=\"cursor:pointer;color:blue;font-size:9;\" id=\"fill_remarks";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\" onClick=\"callFillingRemarks(this,\'";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 =");\"> ";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 =" </label>&nbsp;&nbsp;<input type=\'checkbox\'  name=\'del_detail_";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\' id=\'del_detail_";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\' ";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="  value=\'";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\' onClick=\'updateValue(this)\' ";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 =">\n\t\t\t\t\t\t\t\t</td>\t\t\n";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\n                     <td class=\"";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\" nowrap>  <!-- -nowrap added for AAKH-CRF-0117-->  \n\t\t\t\t\t <input type=\"text\"  maxlength=\"20\" onchange=\"getApprovalNumForDrug(this,\'";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\')\"   name=\"approval_no_";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\" ";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 =" onKeyPress=\"return KeyPressSpecCharsForApprovalNo(event)\" onBlur=\"CheckForSpecCharApprovalno(this,\'D\',";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 =")\" /><!-- modified for AAKH-CRF-0117--> \n\t\t\t\t\t ";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\n\t\t\t\t\t\t<img id=\"imgForWithin\" src=\"../../eCommon/images/mandatory.gif\" align=\"center\" style=\"visibility:visible\"></img>\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\n\t\t\t\t\t </td>\n";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\n\t\t\t\t\t\t\t\t<td align=\"center\"  class=\"";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\"nowrap ><input type=\"checkbox\"  name=\"Complete_Order_";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\" id=\"Complete_Order_";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\" value=\'N\'  onClick=\'updateValue(this)\' ";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 =">\n\t\t\t\t\t\t\t\t</td> \n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"disp_srl_no_";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\" id=\"disp_srl_no_";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\"  value=\"";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\"> \n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"issue_uom_";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\" id=\"issue_uom_";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\"> \n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"issue_qty_";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\" id=\"issue_qty_";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\t\t\t\t<input type=\"hidden\" name=\"tot_rec\" id=\"tot_rec\"  value=\"";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\"><!-- AAKH-CRF-0117-->\n\t\t\t\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\"                 value=\"";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\"               value=\"";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"approval_no_flag\" id=\"approval_no_flag\"               value=\"";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\"><!-- AAKH-CRF-0117-->\n\t\t\t\t<input type=\"hidden\" name=\"approval_no_app_for_patient_class\" id=\"approval_no_app_for_patient_class\" value=\"";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\"><!-- AAKH-CRF-0117-->\n";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\n\t\t\t\t\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\"   value=\"";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" value=\"";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"sal_trn_type\" id=\"sal_trn_type\" value=\"";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"sysdate\" id=\"sysdate\"      value=\"";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"store_code\" id=\"store_code\"   value=\"";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\">\n";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\n\t\t\t</table>\n\t\t</form>\n";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\n\t\t\t<script>\n\t\t\tif(";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="){\n\t\t\t\tcalldispbuttonsframes(\'";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\');//tot_gross_charge_amount_payable_str added for ml-bru-crf-0469\n\t\t\t}\n\t\t\telse{ // esle Added for MMS-MD-SCF-0091 - Start\n\t\t\t\tcalldispbuttonsframes(\'";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\');\n\t\t\t} // esle Added for MMS-MD-SCF-0091 - End\n\t\t\t\t</script>\n";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\n\n\t\t";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );
	
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
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
18/02/2020		IN071362                Manickavasagam J                       AAKH-CRF-0117
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
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
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	String dir_bean_id				= "DirectDispensingBean" ;
	String dir_bean_name			= "ePH.DirectDispensingBean";
	String facility_id				= (String) session.getValue("facility_id");
	DirectDispensingBean dir_bean	= (DirectDispensingBean)getBeanObject( dir_bean_id,dir_bean_name,request) ;

	String  billing_interface_yn	=  dir_bean.checkforbillinginterface();
	String patient_class			=   dir_bean.getPatientClass();

    if(billing_interface_yn.equals("Y")){
	    dir_bean.getTokenSeries(patient_class); //// patient_class added for SRR20056-SCF-7639 ICN027720
	}

	String allocatedd_yn			= "N";
	String drug_desc				= "";
	String tot_alloc_qty			= "";
	String bms_qty					= "";
	String ord_qty					= "";
	String dosage_dtl				= "";
	String qty_value				= "";
	String qty_desc					= "";
	String classvalue				= "";
	String durn_value				= "";	
	String or_durn_desc				= "";
	String freq_desc				= "";
	String stock_uom				= "";
	String srl_no					= "";
	String drug_code				= "";
	String pat_reqd					= "";
	String pat_coun_reqd_yn			= "";
	//bl interface starts
    String item_code				=	"";
	String disp_delivery_chk_box_val=   "Y";
	String disp_del_chk_box_style   =   "";
	String disp_del_chk_box_checked =   "checked";     
    String patient_id				=	dir_bean.getPatientID();
	String encounter_id				=	dir_bean.getEncounterID();
	String sal_trn_type				=	"";
	String sysdate					=   dir_bean.getBLSysDates();
	String dispense_location_code   =   dir_bean.getDispLocnCode();
	String store_code			    =   dir_bean.getStoreCode(dispense_location_code);

	if(encounter_id==null||encounter_id.equals(""))
		patient_class= "XT";
	if(patient_class.equals("IP"))
		sal_trn_type="I";
	else if (patient_class.equals("DC"))
		sal_trn_type="D";	
	else if(patient_class.equals("OP"))
		sal_trn_type="O";
	else if( patient_class.equals("EM"))
		sal_trn_type="E";	
	else
		sal_trn_type="R";
	boolean displayGrossAmtYn = dir_bean.isSiteSpecific("PH", "GROSS_AMT_DISPLY_YN"); //ADDED for ML-BRU-CRF-0469
  //ends here
  boolean approval_no_flag = dir_bean.isSiteSpecific("PH","APPROVAL_NO_APPLICABLE_FLAG");//AAKH-CRF-0117  
		  String approval_no_app_for_patient_class = "N";
			if(approval_no_flag){
			   approval_no_app_for_patient_class = dir_bean.getApprovalNoApplicableForPatientClass(patient_class);
			}

            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

					if(billing_interface_yn.equals("Y")){

            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
if(displayGrossAmtYn){ 
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
} 
            _bw.write(_wl_block17Bytes, _wl_block17);

					}

            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
if(approval_no_flag){ //added for AAKH-CRF-0117 
					
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
} 
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

				ArrayList presDetails		=  (ArrayList) dir_bean.getpresDetails();
				HashMap drugDetails			=  null;
				ArrayList batchDetails		=  null;
				HashMap sel_batches         =  null;
				ArrayList stock_detail      =  null;
				HashMap batcn_data			=  null;	
				String disp_qty			    =  "";
				String  batch_id		    =  "";
				String	expiry_date		    =  "";
				String	trade_id		    =  "";
				String	bin_locn_code	    =  "";
				StringBuffer batch_str      =  new StringBuffer();
				String excl_incl_ind		=  "";				
				String bl_incl_excl_override_reason_code =	"";	
				String bl_incl_excl_override_reason_desc =	"";	
				String decimalFormatString				 =  "";
				String gross_charge_amount_str			 =  "";
				String groos_pat_payable_str			 =  "";	
				String gross_charge_amount_payable_str="";//added for ML-BRU-CRF-0469
				String tot_gross_charge_amount_str		 =  "";
				String tot_groos_pat_payable_str		 =  "";
				String tot_gross_charge_amount_payable_str="";//added for ML-BRU-CRF-0469
				float tot_gross_charge_amount		     =  0;
				float tot_groos_pat_payable		         =  0;
				float tot_gross_charge_amount_payable		     =  0;//added for ML-BRU-CRF-0469
				//variable uom
				String IssueByUOM			             =  dir_bean.getIssueByUOMBy();
				StringBuffer issue_qty_dtl			     =  new StringBuffer();
				HashMap issue_uom_qty_hm		         =  new HashMap();
				HashMap  detail							 =  new HashMap();
				double base_to_disp_uom_equl              =  0;
				double Actual_Equl_Value                  =  0;
				String alloc_qty						 =  "";
				String issue_uom_desc					 =	"";
				String issue_uom						 =  "";
				String billable_item_yn					 =  "";
				if(IssueByUOM.equals("I")){
					 issue_uom_qty_hm					 =  dir_bean.getIssueUomQty();
				}//ends here
				float gross_charge_amount =0;
				float groos_pat_payable   =0;
				float gross_charge_amount_payable=0;//added for ML-BRU-CRF-0469
				StringBuffer gross_charge_display_str  = new StringBuffer();
				StringBuffer pat_charge_display_str    = new StringBuffer();
				StringBuffer gross_charge_payable_display_str    = new StringBuffer();//added forml-bru-crf-0469
						
				HashMap chareg_det=null;
				String start_date = "";//MMS-DM-CRF-0126.2
				String end_date = "";//MMS-DM-CRF-0126.2
				String approval_no = ""; //AAKH-CRF-0117
				int recCount					=	1; //AAKH-CRF-0117

				if(presDetails!=null && presDetails.size()>0 ){
					for(int i=0;i<presDetails.size();i++){
						drugDetails			= (HashMap)presDetails.get(i);
						drug_desc			= "";
						allocatedd_yn		= "";
						tot_alloc_qty		= "";
						bms_qty				= "";
						ord_qty				= "";
						qty_value			= "";
						qty_desc			= "";
						durn_value			= "";	
						or_durn_desc		= "";	
						freq_desc			= "";
						drug_code			= "";
						pat_coun_reqd_yn	= ""; 
						batch_str           = new StringBuffer();
						gross_charge_amount_str ="";
						groos_pat_payable_str   ="";
						gross_charge_amount_payable_str="";//added for ML-BRU-CRF-0469
						start_date = "";//MMS-DM-CRF-0126.2
						end_date   = "";//MMS-DM-CRF-0126.2
						approval_no = ""; //AAKH-CRF-0117
System.err.println("DirectDispensingDetails.jsp====166===drugDetails=======>"+drugDetails);
						allocatedd_yn		= (String)drugDetails.get("ALLOCATEDD_YN");
						if(allocatedd_yn!=null && allocatedd_yn.equals("Y")){
							item_code			= (String)drugDetails.get("ITEM_CODE");      
							drug_desc		= (String)drugDetails.get("DRUG_DESC");
							drug_code		= (String)drugDetails.get("DRUG_CODE");
							pat_coun_reqd_yn	= (String)drugDetails.get("PT_COUN_REQD_YN");
							ord_qty			= (String)drugDetails.get("ORD_QTY");
							bms_qty			= (String)drugDetails.get("ALLOC_BMS_QTY");
							bms_qty			= (new Float(Float.parseFloat(bms_qty)).intValue())+"";
							tot_alloc_qty	= (String)drugDetails.get("TOT_ALLOC_QTY");
							qty_value        = (String)drugDetails.get("QTY_VALUE") ;
							qty_desc         = (String)drugDetails.get("QTY_DESC") ;
							freq_desc	    = (String)drugDetails.get("FREQ_DESC") ;
							durn_value	    = (String)drugDetails.get("DURN_VALUE") ;
							or_durn_desc	    = (String)drugDetails.get("OR_DURN_DESC") ;
							stock_uom	    = (String)drugDetails.get("STOCK_UOM") ;
							srl_no			= (String)drugDetails.get("SRL_NO") ;	
							billable_item_yn	= (String)drugDetails.get("BILLABLE_ITEM_YN") ;	
							qty_desc=CommonBean.checkForNull(dir_bean.getUomDisplay(facility_id,qty_desc));
							dosage_dtl	    = qty_value+qty_desc+"   "+freq_desc+" "+durn_value+" "+or_durn_desc;
							//added for AAKH-CRF-0117 - start
							approval_no     = (String)drugDetails.get("approval_no");
							System.err.println("approval_no=====204==>"+approval_no);
							if(approval_no==null)
								approval_no = "";
							//added for AAKH-CRF-0117 - end
							if ( i% 2 == 0 )
								classvalue = "QRYODD" ;
							else
								classvalue = "QRYEVEN" ;
						   
							detail            =   new HashMap();	
							
							if( issue_uom_qty_hm.containsKey(drug_code+srl_no)){						 
								 detail =  (HashMap)issue_uom_qty_hm.get(drug_code+srl_no);
							}
							Double base_to_def_uom_equl =0.0;
							if(detail.containsKey(drug_code+srl_no+"_conv_factor")){
								 base_to_def_uom_equl  = Double.parseDouble((String)detail.get(drug_code+srl_no+"_base_to_def_uom_equl")) ;
								 issue_uom_desc        = (String)detail.get(drug_code+srl_no+"_uom_desc") ;
								 issue_uom			   = (String)detail.get(drug_code+srl_no+"_uom") ;
								 base_to_disp_uom_equl = Double.parseDouble((String)detail.get(drug_code+srl_no+"_base_to_disp_uom_equl")) ; 
								 Actual_Equl_Value	   = Float.parseFloat((String)detail.get(drug_code+srl_no+"_base_to_disp_uom_equl_Actu")) ; 
							}
							else{
								issue_uom_desc       = "";
								issue_uom			 = "";
								Actual_Equl_Value	 = 1;
							}

							if(base_to_def_uom_equl!=base_to_disp_uom_equl)
								alloc_qty = ( new Float(Math.ceil((Double.parseDouble(tot_alloc_qty)*(base_to_disp_uom_equl))/Actual_Equl_Value)).intValue())+"";
							else
								alloc_qty = tot_alloc_qty+"";

							if(IssueByUOM.equals("I")){
								issue_qty_dtl	= new StringBuffer();
								issue_qty_dtl	= issue_qty_dtl.append("( ").append(alloc_qty).append("  ").append(issue_uom_desc).append(" )");
							}
  
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(dosage_dtl));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(i));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(drug_desc));
            _bw.write(_wl_block28Bytes, _wl_block28);

								if(pat_coun_reqd_yn.equals("Y")){
									pat_reqd="Checked";	

            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(i));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(pat_reqd));
            _bw.write(_wl_block31Bytes, _wl_block31);

								}
								else{

            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(i));
            _bw.write(_wl_block34Bytes, _wl_block34);

								}

            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(ord_qty));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(stock_uom));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(ord_qty));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(CommonBean.checkForNull(dir_bean.getUomDisplay(facility_id,stock_uom))));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(tot_alloc_qty));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(CommonBean.checkForNull(dir_bean.getUomDisplay(facility_id,stock_uom))));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(issue_qty_dtl.toString()));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block47Bytes, _wl_block47);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(bms_qty));
            _bw.write(_wl_block49Bytes, _wl_block49);
								boolean approval_flag = false; //AAKH-CRF-0117
								String disabled = "disabled";//AAKH-CRF-0117
								if(billing_interface_yn.equals("Y")){
									if(billable_item_yn.equals("Y")){
										excl_incl_ind						   = "";
										bl_incl_excl_override_reason_code     = "";
										bl_incl_excl_override_reason_desc	   = "";
										start_date		= (String)drugDetails.get("START_DATE")==null?"":(String)drugDetails.get("START_DATE"); //MMS-DM-CRF-0126.2
										end_date		= (String)drugDetails.get("END_DATE")==null?"":(String)drugDetails.get("END_DATE");//MMS-DM-CRF-0126.2

										if(drugDetails.containsKey("EXCL_INCL_IND")){
											excl_incl_ind						   =     (String)drugDetails.get("EXCL_INCL_IND");
											bl_incl_excl_override_reason_code    =     (String)drugDetails.get("BL_INCL_EXCL_OVERRIDE_REASON_CODE");
											bl_incl_excl_override_reason_desc    =     (String)drugDetails.get("BL_INCL_EXCL_OVERRIDE_REASON_DESC");
										}
										batchDetails			= (ArrayList)drugDetails.get("BATCH_DETAILS");//BATCH_DETAILS
										sel_batches             = (HashMap)drugDetails.get("SEL_BATCHES");//batch wise qty
										for (int j=0;j<batchDetails.size() ; j++){
											if(batchDetails.get(j) != null){
												stock_detail	    =  null;  
												stock_detail	= (ArrayList) batchDetails.get(j);
											}					
											for(int m=0; m<stock_detail.size(); m++ ) {
												batcn_data		=    null;
												batcn_data		=	(HashMap)stock_detail.get(m);
												if(sel_batches.get((m+""))!=null){
													disp_qty		= (String)sel_batches.get((m+""));
													batch_id		= (String)batcn_data.get("BATCH_ID");
													expiry_date		= (String)batcn_data.get("EXPIRY_DATE");
													trade_id		= (String)batcn_data.get("TRADE_ID");
													bin_locn_code	= (String)batcn_data.get("BIN_LOCATION_CODE");
													//trade;batchid,exp_date,bin_loc,req_qty 
													batch_str.append(trade_id).append(";").append(batch_id).append(";").append(expiry_date).append(";").append(bin_locn_code).append(";").append(disp_qty).append(";");
												}
											}
										}
										gross_charge_amount =0;
										groos_pat_payable   =0;
										gross_charge_amount_payable=0; //added for ML-BRU-CRF-0469
										disp_delivery_chk_box_val="Y";
										disp_del_chk_box_style ="";	
										disp_del_chk_box_checked="checked";
										gross_charge_display_str  = new StringBuffer();
										pat_charge_display_str    = new StringBuffer();
										gross_charge_payable_display_str  = new StringBuffer();//added for ml-bru-crf-0469
										chareg_det=(HashMap)dir_bean.callItemChargeDtls(patient_id,encounter_id,sal_trn_type,item_code,Integer.parseInt(tot_alloc_qty), batch_str.toString(),sysdate,store_code,excl_incl_ind,bl_incl_excl_override_reason_code,"",start_date,end_date);////MMS-DM-CRF-0126.2
System.err.println("DirectDispensingDetails.jsp=====chareg_det==ds======286===>"+chareg_det+"==start_date=>"+start_date+"==end_date==>"+end_date);
										if(chareg_det.get("error_msg").equals("")){
											decimalFormatString=(String)chareg_det.get("BL_DECIMAL_FORMAT_STRING");
											/*if(!chareg_det.get("grosschargeamt").equals("null")){
												gross_charge_amount     = Float.parseFloat((String)chareg_det.get("grosschargeamt"));
												DecimalFormat dfTest    = new DecimalFormat(decimalFormatString);
												gross_charge_amount_str = dfTest.format(gross_charge_amount);
											}*/ //Commented for ML-BRU-SCF-0368 [IN:034748]
											//added for ML-BRU-CR4F-0469 start
													if(!chareg_det.get("grosschargeamt").equals("null")){
												gross_charge_amount_payable     = Float.parseFloat((String)chareg_det.get("grosschargeamt"));
												DecimalFormat dfTest    = new DecimalFormat(decimalFormatString);
												gross_charge_amount_payable_str = dfTest.format(gross_charge_amount_payable);
											}
											//added for ML-BRU-CR4F-0469 end
											if(!chareg_det.get("netchargeamt").equals("null")){ //if block added for ML-BRU-SCF-0368 [IN:034748]
												gross_charge_amount     = Float.parseFloat((String)chareg_det.get("netchargeamt"));
												DecimalFormat dfTest    = new DecimalFormat(decimalFormatString);
												gross_charge_amount_str = dfTest.format(gross_charge_amount);
											}
											if(!chareg_det.get("patnetamt").equals("null")){
												 groos_pat_payable  = Float.parseFloat(((String)chareg_det.get("patnetamt")).trim());
												 
											}
											/*if(groos_pat_payable==0){
											   if(!chareg_det.get("netchargeamt").equals("null")){
												 groos_pat_payable  = Float.parseFloat((String)chareg_det.get("netchargeamt"));
											   }
										   }*/

											DecimalFormat dfTest     = new DecimalFormat(decimalFormatString);
											groos_pat_payable_str    = dfTest.format(groos_pat_payable);

											tot_gross_charge_amount  =  tot_gross_charge_amount+gross_charge_amount;
											tot_groos_pat_payable    =  tot_groos_pat_payable+groos_pat_payable;
											tot_gross_charge_amount_payable  =  tot_gross_charge_amount_payable+gross_charge_amount_payable;//added for ML-BRU-CRF-0469
											if(tot_gross_charge_amount !=tot_groos_pat_payable){ //AAKH-CRF-0117
												approval_flag =true;
											}
											drugDetails.put("GROSS_CHARGE_AMOUNT",gross_charge_amount_str);
											drugDetails.put("GROOS_PAT_PAYABLE",groos_pat_payable_str);
											drugDetails.put("GROSS_CHARGE_AMOUNT_PAYABLE",gross_charge_amount_payable_str);//added for ml-bru-crf-0469
											drugDetails.put("DECIMALFORMATSTRING",decimalFormatString);

											gross_charge_display_str.append("<label style='font-size:9;color:black'>").append(gross_charge_amount_str).append("</label>");
											pat_charge_display_str.append("<label style='font-size:9;color:black'>").append(groos_pat_payable_str).append("</label>");
											if(displayGrossAmtYn)gross_charge_payable_display_str.append("<label style='font-size:9;color:black'>").append(gross_charge_amount_payable_str).append("</label>");//added for ml-bru-crf-0469

											if(!drugDetails.containsKey("EXCL_INCL_IND"))
											excl_incl_ind = (String)chareg_det.get("excl_incl_ind");

										}
										else{
											gross_charge_display_str.append("<label style='font-size:9;color:red' title='").append(chareg_det.get("error_msg")).append("'>").append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels")).append("</label>");
											pat_charge_display_str.append("<label style='font-size:9;color:red' title='").append(chareg_det.get("error_msg")).append("'>").append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels")).append("</label>");
											if(displayGrossAmtYn)gross_charge_payable_display_str.append("<label style='font-size:9;color:red' title='").append(chareg_det.get("error_msg")).append("'>").append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels")).append("</label>");//added for ml-bru-crf-0469
											disp_delivery_chk_box_val	= "N";
											disp_del_chk_box_style		= "disabled";
											disp_del_chk_box_checked	= "";
										}						 

            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(gross_charge_display_str.toString()));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(pat_charge_display_str.toString()));
            _bw.write(_wl_block54Bytes, _wl_block54);
if(displayGrossAmtYn){ 
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(gross_charge_payable_display_str.toString()));
            _bw.write(_wl_block57Bytes, _wl_block57);
} 
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf((String)chareg_det.get("override_allowed_yn")));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(excl_incl_ind));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf((String)chareg_det.get("excl_incl_ind")));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf((String)chareg_det.get("approval_reqd_yn")));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(bl_incl_excl_override_reason_desc));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(bl_incl_excl_override_reason_code));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(tot_alloc_qty));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(batch_str.toString()));
            _bw.write(_wl_block79Bytes, _wl_block79);

										if(chareg_det.get("error_msg").equals("")){

            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block83Bytes, _wl_block83);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block84Bytes, _wl_block84);

										}
										else{

            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block85Bytes, _wl_block85);

										}
									}
									else{

            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block87Bytes, _wl_block87);
if(displayGrossAmtYn){ 
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block89Bytes, _wl_block89);
} 
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block85Bytes, _wl_block85);
    
									}
								}
 
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(i));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(i));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block102Bytes, _wl_block102);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(i));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(i));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block105Bytes, _wl_block105);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(i));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(i));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(disp_del_chk_box_checked));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(disp_delivery_chk_box_val));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(disp_del_chk_box_style));
            _bw.write(_wl_block111Bytes, _wl_block111);
					if(approval_flag){//AAKH-CRF-0117
						disabled = "";
 					}else{ //AAKH-CRF-0117
						approval_no = "";
					}
				    if(approval_no_flag) { //added for AAKH-CRF-0117

            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(approval_no));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block117Bytes, _wl_block117);
 //added for AAKH-CRF-0117
						if(approval_no_app_for_patient_class!=null && approval_no_app_for_patient_class.equals("Y") && disabled.equals("") && !encounter_id.equals("")){ 
            _bw.write(_wl_block118Bytes, _wl_block118);
}
						
					
            _bw.write(_wl_block119Bytes, _wl_block119);

					}

            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(i));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(i));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(disp_del_chk_box_style));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(i));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(i));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(i));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(i));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(issue_uom));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(i));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(i));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(alloc_qty));
            _bw.write(_wl_block79Bytes, _wl_block79);
							 recCount++;//AAKH-CRF-0117
						}
					}
					if(!decimalFormatString.equals("")&&billing_interface_yn.equals("Y")){
						DecimalFormat dfTest        = new DecimalFormat(decimalFormatString);
						tot_gross_charge_amount_str = dfTest.format(tot_gross_charge_amount);
						tot_groos_pat_payable_str   = dfTest.format(tot_groos_pat_payable); 
						tot_gross_charge_amount_payable_str = dfTest.format(tot_gross_charge_amount_payable);//added for ml-bru-crf-0469
					}
				}
				

            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(dir_bean_id));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(dir_bean_name));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(approval_no_flag));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(approval_no_app_for_patient_class));
            _bw.write(_wl_block136Bytes, _wl_block136);

				if(billing_interface_yn.equals("Y")){

            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(sal_trn_type));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(sysdate));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(store_code));
            _bw.write(_wl_block142Bytes, _wl_block142);

				}
 
            _bw.write(_wl_block143Bytes, _wl_block143);

		if(billing_interface_yn.equals("Y")){

            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(displayGrossAmtYn));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(tot_gross_charge_amount_str));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(tot_groos_pat_payable_str));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(tot_gross_charge_amount_payable_str));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(tot_gross_charge_amount_str));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(tot_groos_pat_payable_str));
            _bw.write(_wl_block147Bytes, _wl_block147);

		}

            _bw.write(_wl_block148Bytes, _wl_block148);
 putObjectInBean(dir_bean_id,dir_bean,request); 
            _bw.write(_wl_block149Bytes, _wl_block149);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DosageDetail.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.PrescribedQuantity.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AllocatedQuantity.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.BalanceQuantity.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ChargeAmount.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.PayableAmount.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.GrossAmount.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Deliver.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.ApprovalNo.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.CompleteOrder.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.PrescribedQuantity.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.PrescribedQuantity.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AllocatedQuantity.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.BalanceQuantity.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Include.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.EditLabel.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Findings.label", java.lang.String .class,"key"));
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
}
