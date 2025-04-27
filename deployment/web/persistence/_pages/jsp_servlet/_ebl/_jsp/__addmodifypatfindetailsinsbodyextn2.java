package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import com.google.gson.JsonObject;
import java.sql.*;
import webbeans.eBL.*;
import webbeans.eCommon.*;
import webbeans.op.CurrencyFormat;
import java.io.*;
import java.util.*;
import eBL.Common.*;
import com.ehis.util.*;
import java.text.*;
import eXH.InterfaceUtil;
import eBL.*;

public final class __addmodifypatfindetailsinsbodyextn2 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/AddModifyPatFinDetailsInsBodyExtn2.jsp", 1742821559596L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="  \r\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\r\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\r\n\t<tr>\r\n\t<td class=\'PATIENTLINECOLOR\' >";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="&nbsp;&nbsp;<div id=\"bg_curr_desc_disp";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\" style=\"display:inline\"><Font color=\'red\'><b id=\"bg_curr_desc";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\"></b></font></div></td>\r\n\t<td class=\'PATIENTLINECOLOR\' colspan=2><input type=\'text\' readonly name=\"billing_group_desc";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" maxlength=\'30\' size=\'25\' tabindex=\'0\' value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\">\r\n\t<input type=\'hidden\' name=\'blng_grp_visible";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' value=\"Y\">\r\n\t<td  class=\'PATIENTLINECOLOR\' >\r\n\t\t\t\t<div id=\'ref_src_code_main_leg_disp";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' style=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\r\n\t\t\t\t</div>\r\n\t</td>\r\n\t<td class=\'PATIENTLINECOLOR\' colspan=2>\r\n\t\t\t<div id=\'ref_src_code_main_val_disp";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>\r\n\t\t\t\t<input type=\'text\' name=\"referral_source_main_desc";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" maxlength=\'50\' size=\'24\' tabindex=\'0\'  value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" onBlur=\"return refsrclkup(document.forms[0].blng_grp_code";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =",\'M\',referral_source_main_desc";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =",\'B\')\">\r\n\t\t\t\t<input type=\'button\' class=\'button\' name=\"refsrcmainbut";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" value=\'?\' onClick=\"return refsrclkup(document.forms[0].blng_grp_code";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =",\'C\')\" tabindex=\'0\'>\r\n\t\t\t\t<div id=\'ref_src_code_main_mand_disp\' style=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'><img src=\'../../eCommon/images/mandatory.gif\'></div>\r\n\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\r\n\t\t\t\t<img src=\'../../eCommon/images/more.gif\' name=\"pmy_ref_src_lng_name_";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" id=\"pmy_ref_src_lng_name_";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" align=\'center\' style=\"visibility:hidden\">\r\n\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" align=\'center\' style=\"visibility:inline\" alt=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\r\n\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\t\t\t\r\n\t\t\t</div>\r\n\t</td>\r\n\t<td class=\'PATIENTLINECOLOR\'>\r\n\t\t\t<div id=\'ref_src_code_sub_leg_disp";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\r\n\t\t\t</div>\r\n\t</td>\r\n\t<td class=\'PATIENTLINECOLOR\' colspan=2>\r\n\t\t\t<div id=\'ref_src_code_sub_val_disp";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'>\r\n\t\t\t\t<input type=\'text\' name=\"referral_source_sub_desc";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =",\'S\',referral_source_sub_desc";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =",\'B\')\">\r\n\t\t\t\t<input type=\'button\' class=\'button\' name=\"refsrcsubbut";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =",\'C\')\" tabindex=\'0\'>\r\n\t\t\t\t<div id=\'ref_src_code_sub_mand_disp\' style=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\r\n\t\t\t\t<img src=\'../../eCommon/images/more.gif\' name=\"sec_ref_src_lng_name_";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" id=\"sec_ref_src_lng_name_";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\t\r\n\t\t\t</div>\r\n\t</td>\r\n\t</tr>\r\n\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\r\n\t<input type=\'hidden\' name=\'billing_group_desc";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' value=\"N\">\r\n\t<input type=\'hidden\' name=\'referral_source_main_desc";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">\r\n\t<input type=\'hidden\' name=\'referral_source_sub_desc";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\r\n\t<tr id=row";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 =">\r\n\t<input type= \"hidden\" name=\"currency_code_for_bg";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\"  value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\">\r\n\t<input type= \"hidden\" name=\"currency_desc_for_bg";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\">\r\n\t<input type=\'hidden\' name=\'blng_grp_code";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\">\r\n\t<input type=\'hidden\' name=\'referral_source_main_code";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\r\n\t<input type=\'hidden\' name=\'referral_source_sub_code";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\">\r\n\t<input type=\'hidden\' name=\'referral_source_capture_YN";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\">\r\n\t<input type=\'hidden\' name=\'referral_source_main_mand_YN";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\">\r\n\t<input type=\'hidden\' name=\'referral_source_sub_mand_YN";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\">\r\n\t<input type=\'hidden\' name=\'payerEligibilityParam";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\">\r\n\t<input type=\'hidden\' name=\'responseCode";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">\r\n\t<input type=\'hidden\' name=\'responseCodeDesc";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\">\r\n\t<input type=\'hidden\' name=\'statuDescription";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\">\r\n\t<input type=\'hidden\' name=\'validityPeriod";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\">\r\n\t<input type=\'hidden\' name=\'validityPeriodDesc";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\">\r\n\t<input type=\'hidden\' name=\'eligibilityCode";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\">\r\n\t<input type=\'hidden\' name=\'transactionId";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\">\r\n\t<input type=\'hidden\' name=\'responseDateTime";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\r\n\t<td class=";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 =" width=\'14%\'><input type=\"checkbox\" name=\'selected_row";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\' value=\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\' onClick=\"selected(";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 =")\">&nbsp;&nbsp;<input maxlength=\'15\' size=\'12\' type=text name=\'ins_cust_group_name";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\'  value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\" onFocus=\'check(";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 =");\'  readonly></td>\r\n\t<td class=";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 =" width=\'12%\' ><input maxlength=\'40\' size=\'13\' type=text name=\'payer_desc";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 =");\'  readonly></td>\r\n\t<input type=\'hidden\' name=\'cust_3";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\">\r\n\t<input type=\'hidden\' name=\'ins_cust_group_code";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\">\r\n\t<input type=\'hidden\' name=\'valid_payer_YN";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\'>\r\n\t<input type=\'hidden\' name=\'payer_suspended_YN";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\">\r\n\t<input type=\'hidden\' name=\'cust_valid_from_date";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\">\r\n\t<input type=\'hidden\' name=\'cust_valid_to_date";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\">\r\n\t<td class=";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 =" width=\'7%\'><input type=\"text\" maxlength=\'2\' size=\"3\" name=\'priority";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\' style=\'text-align:right\'  value=\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 =");\'  readonly></td> \r\n\t<td class=";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 =" width=\'12%\' ><input maxlength=\'40\' size=\'13\' type=text name=\'policy_type_desc";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 =");\'  readonly>\r\n\t";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\r\n\t<a name=\'\' href=\"#\" onClick=\"callPolicyDetails(";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 =")\">(dtls)</a><!-- Karthik added the link to Display Policy Details 38144 MMS-QH-CRF-0082-->\r\n\t";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\t\r\n\t</td>\r\n\t<input type=\'hidden\' name=\'policy_type_code";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\" >\r\n\t<input type=\'hidden\' name=\'valid_policy_type_code_YN";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\'>\r\n\t<input type=\'hidden\' name=\'policy_suspended_YN";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 =" width=\'12%\'><input type=\"text\" maxlength=\'30\' size=\"13\" name=\'policy_no";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\'   value=\"";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 =");\'  readonly></td>\r\n\t";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 =" width=\'10%\' ><input type=\'text\'  name=\'policy_start_date";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\' size=\'10\' maxlength=\'10\' value=\'";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\'  onFocus=\'check(";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 =");\' readonly></td>\r\n\t";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 =" width=\'10%\'><input type=\'text\'  name=\'policy_exp_date";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 =" width=\'12%\'><div id=\"credit_auth_val_disp";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\" style=";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 =" ><input type=\"text\" maxlength=\'20\' size=\"13\" name=\'credit_auth_ref";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 =");\'  readonly></div></td>\r\n\t";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 =" width=\'11%\'><div id=\"credit_auth_date_val_disp";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 =" ><input type=\'text\'  name=\'credit_auth_date";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\' readonly></div></td>\r\n\t</tr>\r\n\t";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 =">\r\n\t<td class=";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 =" width=\'14%\'><b id=\"policy_coverage_basis_";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\"></b></td>\r\n\t<td class=";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 =" width=\'12%\' ><div id=\"apprd_amt_leg_disp";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 =">";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="</div></td>\r\n\t<td class=";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 =" width=\'7%\'><div id=\"apprd_amt_val_disp";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 =" ><input type=\"text\" maxlength=\'10\' size=\"7\" name=\'credit_apprd_amt";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\' style=\'text-align:right\'  value=\'";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\' onFocus=\'check(";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 =");\'  readonly></div></td>\r\n\t<td  class=";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 =" width=\'12%\'><div id=\"apprd_days_leg_disp";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 =" >";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 =" width=\'12%\'><div id=\"apprd_days_val_disp";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 =" ><input type=\"text\" maxlength=\'4\' size=\"4\" name=\'credit_apprd_days";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\t\r\n\t<td class=";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 =" width=\'10%\' >";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="</td>\r\n\t<td class=";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 =" width=\'10%\'><input type=\'text\'  name=\'policy_eff_frm_date";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\' readonly></td>\r\n\t";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 =" width=\'12%\' >";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 =" width=\'11%\'><input type=\'text\'  name=\'policy_eff_to_date";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\' readonly></td>\r\n\t</tr>\r\n\t<input type=hidden name=\'adj_rule_ind";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\">\r\n\t<input type=hidden name=\'adj_perc_amt_ind";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\">\r\n\t<input type=hidden name=\'adj_perc_amt_value";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\">\r\n\t<input type=hidden name=\'pmnt_diff_adj_int";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\">\r\n\t<input type=hidden name=\'drg_pmnt_diff_adj_int";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\">\r\n\t<input type=hidden name=\'spl_srv_pmnt_diff_adj_int";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\">\r\n\t<input type=hidden name=\'restrict_check";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\'>\r\n\t<input type=hidden name=\'apprd_amt_restrict_check";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\'>\r\n\t<input type=hidden name=\'apprd_days_restrict_check";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\'>\r\n\t<input type=hidden name=\'policy_coverage_basis_ind";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\'>\r\n\t<input type=hidden name=\'cred_auth_req_yn";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\">\r\n\t<input type=hidden name=\'cred_auth_mand_capt_yn";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\">\r\n\t<input type=hidden name=\'dflt_auth_ref_as_pol_no_yn";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\">\r\n\t<input type=hidden name=\'pol_validity_chk_date";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\">\r\n\t<input type=hidden name=\'rec_edited_YN";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\">\r\n\t<input type=hidden name=\'mcn_for_policy";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\">  \r\n\t<input type=hidden name=\'reg_ref_id";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\">   <!-- V230315 -->\r\n\t<input type=\"hidden\" name=\"tmp_pol_eff_to";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\" id=\"tmp_pol_eff_to";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\" value=\"";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\">  <!--  Added By Vijay for MMS-QF-SCf-567-->\r\n\t<input type=hidden name=\"userId_for_priv";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\" />  <!-- V230707 -->\r\n\t<input type=hidden name=\"reasonCode_for_priv";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\" />  <!-- V230707 -->\r\n\t<input type=hidden name=\"offline_Eligibility_Check";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\" />  <!-- V240301 -->\r\n\t<input type=hidden name=\"offline_Eligibility_Dt";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\" />  <!-- V240301 -->\r\n\t<input type=hidden name=\"offline_Eligibility_Code";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\" />  <!-- V240301 -->\r\n\t<input type=hidden name=\"admission_approval_details";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\" />  <!-- V280827 -->\r\n\t\r\n\r\n\t\t\r\n\t";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 =")\" >&nbsp;&nbsp;<input maxlength=\'15\' size=\'12\' type=text name=\'ins_cust_group_name";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\'  value=\"\" onFocus=\'check(";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 =");\' readonly>\r\n\t<input type=\'hidden\' name=\'cust_3";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\' value=\"\">\r\n\t<input type=\'hidden\' name=\'ins_cust_group_code";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\' value=\"\">\r\n\t<input type=\'hidden\' name=\'valid_payer_YN";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\' value=\"N\">\r\n\t<input type=\'hidden\' name=\'payer_suspended_YN";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\' value=\"\">\r\n\t<input type=\'hidden\' name=\'cust_valid_from_date";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\' value=\"\">\r\n\t<input type=\'hidden\' name=\'cust_valid_to_date";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\' value=\"\">\r\n\t<td class=";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\' style=\'text-align:right\'  value=\'\' onFocus=\'check(";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 =");\' readonly>\r\n\t";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\t\r\n\t</td>\r\n\t<input type=hidden name=\'policy_type_code";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\' value=\"\">\r\n\t<input type=\'hidden\' name=\'valid_policy_type_code_YN";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\' value=\"N\">\r\n\t<input type=\'hidden\' name=\'policy_suspended_YN";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\'   value=\"\" onFocus=\'check(";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\' size=\'10\' maxlength=\'10\' value=\"\"  onFocus=\'check(";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 =");\' readonly></td>\r\n\t<td class=";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 =");\' readonly></div></td>\r\n\t<td class=";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 =");\' readonly></div></td>\r\n\t</tr>\r\n\t<tr id=row";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\' style=\'text-align:right\'  value=\"\" onFocus=\'check(";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 =");\' readonly></div></td>\r\n\t<td  class=";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 =");\' readonly>\r\n\t<td class=";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 =");\' readonly></td>\r\n\t</tr>\r\n\t<input type=hidden name=\'adj_rule_ind";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\' value=\"\">\r\n\t<input type=hidden name=\'adj_perc_amt_ind";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\' value=\"\">\r\n\t<input type=hidden name=\'adj_perc_amt_value";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\' value=\"\">\r\n\t<input type=hidden name=\'pmnt_diff_adj_int";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\' value=\"\">\r\n\t<input type=hidden name=\'drg_pmnt_diff_adj_int";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\' value=\"\">\r\n\t<input type=hidden name=\'spl_srv_pmnt_diff_adj_int";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\' value=\"\">\r\n\t<input type=hidden name=\'restrict_check";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\' value=\'U\'>\r\n\t<input type=hidden name=\'apprd_amt_restrict_check";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\' value=\'U\'>\r\n\t<input type=hidden name=\'apprd_days_restrict_check";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\' value=\'U\'>\r\n\t<input type=hidden name=\'policy_coverage_basis_ind";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\' value=\'\'>\r\n\t<input type=hidden name=\'cred_auth_req_yn";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\' value=\"N\">\r\n\t<input type=hidden name=\'cred_auth_mand_capt_yn";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\' value=\"N\">\r\n\t<input type=hidden name=\'dflt_auth_ref_as_pol_no_yn";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\' value=\"N\">\r\n\t<input type=hidden name=\'pol_validity_chk_date";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\' value=\"\">\r\n\t<input type=hidden name=\'rec_edited_YN";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\' value=\"N\">\r\n\t<input type=hidden name=\'mcn_for_policy";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\">   <!-- V230315 -->\r\n\t<input type=hidden name=\"tmp_pol_eff_to";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\" />  <!-- V280827 -->\r\n\t";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\t\r\n\t\t<input type=hidden name=\"totRec\" id=\"totRec\"  value=\"";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\"><!-- Added By Vijay For MMS-QF-SCf-567  -->\r\n\t";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block5Bytes, _wl_block5);

	int totalRecords=0;
	String classval="";
	String desc = "";
	String tempDesc = "";
	String policy_coverage_basis_ind="", policy_coverage_basis_gbl_ind="";
	String blng_grp_values="", billing_group = "", class_code = "";
	String p_patient_class = "";
	String episode_type="";
	JsonObject objFromBean = null;
	AddModifyPatFinDetailsBean addModifyBean = new AddModifyPatFinDetailsBean();
	String cust_valid_from_date = "" ,cust_valid_to_date = "";
	String str_currency_code_for_bg="", str_currency_desc_for_bg="";
	String payer_suspended_YN = "N", policy_suspended_YN = "N";
	String rec_edited_YN="N", cred_auth_mand_capt_yn="N";
	String ref_src_main_lng_name = "";
	String ref_src_sub_lng_name = "";

	String policy_start_date_conv="";
	String policy_exp_date_conv="";
	String credit_auth_date_conv="";
	String v_display_hide="",v_display_hide_apprvd_amt="", v_display_hide_apprvd_days="";
	String policy_eff_frm_date_conv="";
	String policy_eff_to_date_conv="";
	String policy_eff_to_date_Org=""; //Added By Vijay for MMS-QF-SCf-567
	String pol_validity_chk_date="";
	ArrayList existing_records_array=new ArrayList();
	String strChargeLogicYN = "";
	String strModuleId = "";
	String[] output1=new String[59]; //V240301 	//V240828 -MMS-DM-CRF-0252.1-US004
	String cred_auth_req_yn="N",dflt_auth_ref_as_pol_no_yn="N",v_display_hide_cred_auth="";
	
	Connection con				= null;
 	Statement stmt				= null;
	PreparedStatement pstmt		= null;
	ResultSet rs				= null;
	ResultSet rs2				= null;
	ResultSet rs4				= null;
	ResultSet rs5				= null;

	try
	{
		HttpSession httpSession = request.getSession(false);
		String facility_id = (String)httpSession.getValue("facility_id");	
		String locale			= (String)session.getAttribute("LOCALE");	
		con	=	ConnectionManager.getConnection(request);
		
		billing_group = request.getParameter("billing_group") == null ? "" : request.getParameter("billing_group");
		p_patient_class = request.getParameter("p_patient_class") == null ? "" : request.getParameter("p_patient_class");
		class_code = request.getParameter("class_code") == null ? "" : request.getParameter("class_code");
		strModuleId = request.getParameter("strModuleId") == null ? "" : request.getParameter("strModuleId");
		episode_type = request.getParameter("episode_type") == null ? "" : request.getParameter("episode_type");
		
		existing_records_array = (ArrayList) request.getAttribute("existing_records_array");
	System.err.println("existing_records_array size is: "+existing_records_array.size());
		for(int i=0;i<existing_records_array.size();i++)
		{
			output1=(String[])existing_records_array.get(i);
			policy_coverage_basis_ind=output1[26];	
			if(policy_coverage_basis_ind==null) policy_coverage_basis_ind="";
			if(i==0)
			{
				policy_coverage_basis_gbl_ind=policy_coverage_basis_ind;
			}
			if(i % 2 == 0 )
			{
				classval	=	"QRYEVEN";
			}
			else
			{
				classval	=	"QRYODD";
			}
			desc = output1[1];
			System.err.println("value of output1 for desc:"+output1[1]+"is this");
			String referral_source_capture_YN="N";
			String ref_src_main_mand_YN="N";
			String ref_src_sub_mand_YN="N";
			String ref_src_code_disp="";
			String ref_src_code_main_mand_disp ="";
			String ref_src_code_sub_mand_disp = "";
			System.err.println("custcode value : "+output1[3]);
			objFromBean = addModifyBean.getCustValidDates(output1[3], con);
			
			
			cust_valid_from_date = objFromBean.get("cust_valid_from_date").getAsString();
			System.err.println("cust_valid_from_date 121 : "+cust_valid_from_date);
			cust_valid_to_date = objFromBean.get("cust_valid_to_date").getAsString();
			System.err.println("cust_valid_to_date 121: "+cust_valid_to_date);
			objFromBean = addModifyBean.getCurrencyCode(output1[1], locale, con);
			str_currency_code_for_bg= objFromBean.get("str_currency_code_for_bg").getAsString();
			str_currency_desc_for_bg= objFromBean.get("str_currency_desc_for_bg").getAsString();
			objFromBean = addModifyBean.getRefSourceFlagsForP1(output1[1], con);
			referral_source_capture_YN = objFromBean.get("referral_source_code_flag").getAsString();
			ref_src_main_mand_YN = objFromBean.get("referral_source_main_mand_YN").getAsString();
			ref_src_sub_mand_YN = objFromBean.get("referral_source_sub_mand_YN").getAsString();
			if(referral_source_capture_YN.equals("Y"))
			{
				ref_src_code_disp="display:inline";
				if(ref_src_main_mand_YN.equals("Y"))
				{
					ref_src_code_main_mand_disp = "display:inline";
				}
				else
				{
					ref_src_code_main_mand_disp = "display:none";
				}
				if(ref_src_sub_mand_YN.equals("Y"))
				{
					ref_src_code_sub_mand_disp = "display:inline";
				}
				else
				{
					ref_src_code_sub_mand_disp = "display:none";
				}
			}
			else if(referral_source_capture_YN.equals("N"))
			{
				ref_src_code_disp="display:none";
				ref_src_code_main_mand_disp = "display:none";
				ref_src_code_sub_mand_disp = "display:none";
			}
			else
			{
				ref_src_code_disp="display:none";
			}
			if(!output1[27].equals(""))
			{
				String val="3";
				String refInsSrcMainCode=(String)output1[27];
				ref_src_main_lng_name=addModifyBean.getrefSrcMainLngName(refInsSrcMainCode,locale,val,con);		
			}
			else
			{
				ref_src_main_lng_name="";
			}

			if(!output1[29].equals(""))
			{
				String refInsSrcMainCode=(String)output1[29];
				String val = "3";
				ref_src_sub_lng_name=addModifyBean.getrefSrcMainLngName(refInsSrcMainCode,locale,val,con);
			}
			else
			{
				ref_src_sub_lng_name="";
			}
			payer_suspended_YN = addModifyBean.payerSuspendedYn(strModuleId, output1[3], output1[25], con);
			String empty_sql_check="N";
			String custCde=(String)output1[3];
			String custGrpCde =(String)output1[25]; 
			String policyTypeCde=(String)output1[6];

			objFromBean=addModifyBean.getpolicySuspendedYN(empty_sql_check,strModuleId, custCde, custGrpCde,policyTypeCde,locale,facility_id, con);			
			empty_sql_check=	objFromBean.get("empty_sql_check").getAsString();
			policy_suspended_YN=	objFromBean.get("policy_suspended_YN").getAsString();		
			if((!desc.equals("") && tempDesc.equals("")) || (!desc.equals(tempDesc))){
	
            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(output1[0]));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(ref_src_code_disp));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(ref_src_code_disp));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(output1[28]));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(ref_src_code_main_mand_disp));
            _bw.write(_wl_block23Bytes, _wl_block23);

				if(ref_src_main_lng_name.equals("")){
	
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block26Bytes, _wl_block26);

				}else{
	
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(ref_src_main_lng_name));
            _bw.write(_wl_block28Bytes, _wl_block28);

				}
	
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(ref_src_code_disp));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(ref_src_code_disp));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(output1[30]));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(ref_src_code_sub_mand_disp));
            _bw.write(_wl_block23Bytes, _wl_block23);

				if(ref_src_sub_lng_name.equals("")){
	
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block26Bytes, _wl_block26);

				}else{
	
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(ref_src_sub_lng_name));
            _bw.write(_wl_block28Bytes, _wl_block28);

				}
	
            _bw.write(_wl_block37Bytes, _wl_block37);

			}else{
	
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(output1[0]));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(output1[28]));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(output1[30]));
            _bw.write(_wl_block28Bytes, _wl_block28);

			}
	
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(str_currency_code_for_bg));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(str_currency_desc_for_bg));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(output1[1]));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(output1[27]));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(output1[29]));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(referral_source_capture_YN));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(ref_src_main_mand_YN));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(ref_src_sub_mand_YN));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(output1[41]));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(output1[42]));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(output1[43]));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(output1[44]));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(output1[45]));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(output1[46]));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(output1[47]));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(output1[48]));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(output1[49]));
            _bw.write(_wl_block28Bytes, _wl_block28);

		blng_grp_values=blng_grp_values+output1[1]+"|";
		if(output1[23].equals("Y") && output1[24].equals("Y"))
		{
	
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(output1[37]));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(output1[2]));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(output1[3]));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(output1[25]));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(output1[23]));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(payer_suspended_YN));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(cust_valid_from_date));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(cust_valid_to_date));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(output1[4]));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(output1[5]));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block81Bytes, _wl_block81);
 if( "Y".equals(strChargeLogicYN)) { 
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block83Bytes, _wl_block83);
}
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(output1[6]));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(output1[24]));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(policy_suspended_YN));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(output1[7]));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block89Bytes, _wl_block89);

		policy_start_date_conv=(String)output1[8];	
		if(policy_start_date_conv==null) policy_start_date_conv="";
		policy_start_date_conv=policy_start_date_conv.trim();
		if(!policy_start_date_conv.equals(""))
		{
			policy_start_date_conv=com.ehis.util.DateUtils.convertDate(policy_start_date_conv,"DMY","en",locale);
		}
	
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(policy_start_date_conv));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block93Bytes, _wl_block93);

		policy_exp_date_conv=(String)output1[9];	 
		if(policy_exp_date_conv==null) policy_exp_date_conv="";
		policy_exp_date_conv=policy_exp_date_conv.trim();
		if(!policy_exp_date_conv.equals(""))
		{
			policy_exp_date_conv=com.ehis.util.DateUtils.convertDate(policy_exp_date_conv,"DMY","en",locale);
		}
	
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(policy_exp_date_conv));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block89Bytes, _wl_block89);

		if(output1[33].equals("Y"))
		{
			v_display_hide_cred_auth = "display:inline";
		}
		else
		{
			v_display_hide_cred_auth = "display:none";
		}
	
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(v_display_hide_cred_auth));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(output1[10]));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block98Bytes, _wl_block98);

		credit_auth_date_conv=(String)output1[11];	
		if(credit_auth_date_conv==null) credit_auth_date_conv="";
		credit_auth_date_conv=credit_auth_date_conv.trim();
		if(!credit_auth_date_conv.equals(""))
		{
			credit_auth_date_conv=com.ehis.util.DateUtils.convertDate(credit_auth_date_conv,"DMY","en",locale);
		}
	
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(v_display_hide_cred_auth));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(credit_auth_date_conv));
            _bw.write(_wl_block101Bytes, _wl_block101);

		v_display_hide="";
		v_display_hide_apprvd_amt="";
		v_display_hide_apprvd_days="";
		if(output1[22].equals("U"))
		{
			v_display_hide="display:none";
			v_display_hide_apprvd_amt="display:none";
			v_display_hide_apprvd_days = "display:none";
		}
		else if (output1[22].equals("R"))
		{
			if(output1[31].equals("U"))
			{
				v_display_hide_apprvd_amt="display:none";
			}
			if(output1[32].equals("U"))
			{
				v_display_hide_apprvd_days = "display:none";
			}
		}
	
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(v_display_hide_apprvd_amt));
            _bw.write(_wl_block106Bytes, _wl_block106);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(v_display_hide_apprvd_amt));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(output1[12]));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(v_display_hide_apprvd_days));
            _bw.write(_wl_block114Bytes, _wl_block114);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(v_display_hide_apprvd_days));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(output1[13]));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block98Bytes, _wl_block98);

		policy_eff_frm_date_conv=(String)output1[14];	
		if(policy_eff_frm_date_conv==null) policy_eff_frm_date_conv="";
		policy_eff_frm_date_conv=policy_eff_frm_date_conv.trim();
		if(!policy_eff_frm_date_conv.equals(""))
		{
			policy_eff_frm_date_conv=com.ehis.util.DateUtils.convertDate(policy_eff_frm_date_conv,"DMY","en",locale);
		}
	
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block118Bytes, _wl_block118);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(policy_eff_frm_date_conv));
            _bw.write(_wl_block121Bytes, _wl_block121);

		policy_eff_to_date_conv=(String)output1[15];	
		if(policy_eff_to_date_conv==null) policy_eff_to_date_conv="";
		policy_eff_to_date_conv=policy_eff_to_date_conv.trim();
		if(!policy_eff_to_date_conv.equals(""))
		{
			policy_eff_to_date_conv=com.ehis.util.DateUtils.convertDate(policy_eff_to_date_conv,"DMY","en",locale);
		}
	
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block122Bytes, _wl_block122);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(policy_eff_to_date_conv));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(output1[16]));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(output1[17]));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(output1[18]));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(output1[19]));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(output1[20]));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(output1[21]));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(output1[22]));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(output1[31]));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(output1[32]));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(policy_coverage_basis_ind));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(output1[33]));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(output1[40]));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(output1[34]));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(pol_validity_chk_date));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(output1[39]));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(output1[51]));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(output1[52]));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(output1[50]));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(output1[53]));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(output1[54]));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(output1[55]));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(output1[56]));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(output1[57]));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(output1[58]));
            _bw.write(_wl_block150Bytes, _wl_block150);
 }
		else
		{
			if((!desc.equals("") && tempDesc.equals("")) || (!desc.equals(tempDesc)))
			{
	
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block93Bytes, _wl_block93);

			v_display_hide_apprvd_amt="display:inline";
			v_display_hide_apprvd_days = "display:inline";
	
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block161Bytes, _wl_block161);
 if( "Y".equals(strChargeLogicYN)) { 
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block83Bytes, _wl_block83);
}
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block93Bytes, _wl_block93);

			v_display_hide_cred_auth = "display:inline";
	
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(v_display_hide_cred_auth));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(v_display_hide_cred_auth));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(v_display_hide_apprvd_amt));
            _bw.write(_wl_block114Bytes, _wl_block114);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(v_display_hide_apprvd_amt));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(v_display_hide_apprvd_days));
            _bw.write(_wl_block114Bytes, _wl_block114);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(v_display_hide_apprvd_days));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block118Bytes, _wl_block118);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block122Bytes, _wl_block122);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(output1[51]));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(output1[52]));
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(output1[50]));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(output1[53]));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(output1[54]));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(output1[55]));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(output1[56]));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(output1[57]));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(output1[58]));
            _bw.write(_wl_block190Bytes, _wl_block190);

				
			}
		}
		totalRecords++;
		tempDesc=desc;
		}
	
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(existing_records_array.size()));
            _bw.write(_wl_block192Bytes, _wl_block192);

	}
	catch(Exception e)
	{
		out.println("Exception in main"+e);
		e.printStackTrace();
	}
	finally
	{
		if(con!=null) ConnectionManager.returnConnection(con,request);
	} 


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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BillingGroup.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PMY_REF_SRC.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.SEC_REF_SRC.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.APPROVED_AMT.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.APPROVED_DAY.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.POLICY_EFFECTIVE_FROM.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.POLICY_EFFECTIVE_TO.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.APPROVED_AMT.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.APPROVED_DAY.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.POLICY_EFFECTIVE_FROM.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.POLICY_EFFECTIVE_TO.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
