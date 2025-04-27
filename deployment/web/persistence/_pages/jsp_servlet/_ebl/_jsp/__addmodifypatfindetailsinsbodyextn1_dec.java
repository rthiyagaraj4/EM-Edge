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

public final class __addmodifypatfindetailsinsbodyextn1_dec extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/AddModifyPatFinDetailsInsBodyExtn1_Dec.jsp", 1727085296763L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="  \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<script>\nfunction selected_loc(i)\n{\n\tvar selected_row=eval(\"document.forms[0].selected_row\"+i);\n\n\tif(selected_row.checked==false)\n\t{\n\t\tselected_row.checked=false;\n\t\tdocument.add_modify_pat_fin_det_insmain.checked_row.value=\"\";\n\t}\n\telse\n\t{\n\t\tvar total_records=document.forms[0].total_records.value;\n\t\tfor(var j=0;j<total_records;j++)\n\t\t{\n\t\t\tvar temp=eval(\"document.forms[0].selected_row\"+j);\n\t\t\ttemp.checked=false;\n\t\t}\n\t\tselected_row.checked=true;\n\t\tdocument.add_modify_pat_fin_det_insmain.checked_row.value=i;\n\t}\n}\n</script>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<tr>\n<td class=\'PATIENTLINECOLOR\'>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="&nbsp;&nbsp;<div id=\"bg_curr_desc_disp";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\" style=\"display:inline\"><Font color=\'red\'><b id=\"bg_curr_desc";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\"></b></font></div></td>\n<td class=\'PATIENTLINECOLOR\' colspan=2 ><input type=\'text\' readonly name=\"billing_group_desc";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" id=\"billing_group_desc";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" maxlength=\'40\' size=\'25\' tabindex=\'0\' value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\"></td>\n<input type=\'hidden\' name=\'blng_grp_visible";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' id=\'blng_grp_visible";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' value=\"Y\">\n<td  class=\'PATIENTLINECOLOR\'>\n\t\t\t<div id=\'ref_src_code_main_leg_disp";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' style=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t</div>\n</td>\n<td class=\'PATIENTLINECOLOR\' colspan=2>\n\t\t<div id=\'ref_src_code_main_val_disp";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'>\n\t\t\t<input type=\'text\' name=\"referral_source_main_desc";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" id=\"referral_source_main_desc";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" maxlength=\'50\' size=\'24\' tabindex=\'0\'  value=\"\" onBlur=\"return refsrclkup(document.forms[0].blng_grp_code";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =",\'M\',referral_source_main_desc";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =",\'B\')\">\n\t\t\t<input type=\'button\' class=\'button\' name=\"refsrcmainbut";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" id=\"refsrcmainbut";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" value=\'?\' onClick=\"return refsrclkup(document.forms[0].blng_grp_code";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =",\'C\')\" tabindex=\'0\'>\n\t\t\t<div id=\'ref_src_code_main_mand_disp\' style=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'><img src=\'../../eCommon/images/mandatory.gif\'></div>\n\t\t\t<img src=\'../../eCommon/images/more.gif\' name=\"pmy_ref_src_lng_name_";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" id=\"pmy_ref_src_lng_name_";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" align=\'center\' style=\"visibility:hidden\">\n\t\t</div>\n</td>\n<td class=\'PATIENTLINECOLOR\'>\n\t\t<div id=\'ref_src_code_sub_leg_disp";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t</div>\n</td>\n<td class=\'PATIENTLINECOLOR\' colspan=2>\n\t\t<div id=\'ref_src_code_sub_val_disp";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'>\n\t\t\t<input type=\'text\' name=\"referral_source_sub_desc";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" id=\"referral_source_sub_desc";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =",\'S\',referral_source_sub_desc";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =",\'B\')\">\n\t\t\t<input type=\'button\' class=\'button\' name=\"refsrcsubbut";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" id=\"refsrcsubbut";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =",\'C\')\" tabindex=\'0\'>\n\t\t\t<div id=\'ref_src_code_sub_mand_disp\' style=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'><img src=\'../../eCommon/images/mandatory.gif\'></div>\n\t\t\t<img src=\'../../eCommon/images/more.gif\' name=\"sec_ref_src_lng_name_";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" id=\"sec_ref_src_lng_name_";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" align=\'center\' style=\"visibility:hidden\">\n\t\t</div>\n</td>\n</tr>\n";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\t\n<input type=\'hidden\' name=\'billing_group_desc";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' id=\'billing_group_desc";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\">\n<input type=\'hidden\' name=\'blng_grp_visible";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\' value=\"N\">\n<input type=\'hidden\' name=\'referral_source_main_desc";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\' id=\'referral_source_main_desc";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\' value=\"\">\n<input type=\'hidden\' name=\'referral_source_sub_desc";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\' id=\'referral_source_sub_desc";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\' value=\"\">\n";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n<tr id=row";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 =">\n<input type= \"hidden\" name=\"currency_code_for_bg";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\" id=\"currency_code_for_bg";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\"  value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\">\n<input type= \"hidden\" name=\"currency_desc_for_bg";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\" id=\"currency_desc_for_bg";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\">\n<input type=\'hidden\' name=\'blng_grp_code";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\' id=\'blng_grp_code";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\">\n<input type=\'hidden\' name=\'referral_source_main_code";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\' id=\'referral_source_main_code";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\' value=\"\">\n<input type=\'hidden\' name=\'referral_source_sub_code";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\' id=\'referral_source_sub_code";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\' value=\"\">\n<input type=\'hidden\' name=\'referral_source_capture_YN";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\' id=\'referral_source_capture_YN";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\">\n<input type=\'hidden\' name=\'referral_source_main_mand_YN";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\' id=\'referral_source_main_mand_YN";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\">\n<input type=\'hidden\' name=\'referral_source_sub_mand_YN";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\' id=\'referral_source_sub_mand_YN";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\">\n<input type= \"hidden\" name=\"payerEligibilityParam";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\" id=\"payerEligibilityParam";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\">\n<input type= \"hidden\" name=\"responseCode";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\" id=\"responseCode";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\" value=\"\">\n<input type= \"hidden\" name=\"responseCodeDesc";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\" id=\"responseCodeDesc";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\" value=\"\">\n<input type= \"hidden\" name=\"statuDescription";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\" id=\"statuDescription";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\" value=\"\">\n<input type= \"hidden\" name=\"validityPeriod";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\" id=\"validityPeriod";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\" value=\"\">\n<input type= \"hidden\" name=\"validityPeriodDesc";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\" id=\"validityPeriodDesc";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\" value=\"\">\n<input type= \"hidden\" name=\"eligibilityCode";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\" id=\"eligibilityCode";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\" value=\"\">\n<input type= \"hidden\" name=\"transactionId";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\" id=\"transactionId";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\" value=\"\">\n<input type= \"hidden\" name=\"responseDateTime";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\" id=\"responseDateTime";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\" value=\"\">\n<td class=";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 =" width=\'14%\'><input type=\"checkbox\" name=\'selected_row";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\' id=\'selected_row";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\' value=\'";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\' onClick=\"selected_loc(";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 =")\">&nbsp;&nbsp;<input maxlength=\'15\' size=\'12\' type=text name=\'ins_cust_group_name";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\' id=\'ins_cust_group_name";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\'  value=\"";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\" onFocus=\'check(";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 =");\'  readonly></td>\n";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\n<td class=";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 =" width=\'12%\' ><input maxlength=\'40\' size=\'13\' type=text name=\'payer_desc";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\' id=\'payer_desc";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 =");\'  readonly></td>\n<input type=\'hidden\' name=\'cust_3";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\' id=\'cust_3";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\">\n<input type=\'hidden\' name=\'ins_cust_group_code";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\' id=\'ins_cust_group_code";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\">\n<input type=\'hidden\' name=\'valid_payer_YN";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\' id=\'valid_payer_YN";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\">\n<input type=\'hidden\' name=\'payer_suspended_YN";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\' id=\'payer_suspended_YN";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\">\n<input type=\'hidden\' name=\'cust_valid_from_date";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\' id=\'cust_valid_from_date";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\">\n<input type=\'hidden\' name=\'cust_valid_to_date";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\' id=\'cust_valid_to_date";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\">\n<td class=";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 =" width=\'7%\'><input type=\"text\" maxlength=\'2\' size=\"3\" name=\'priority";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\' id=\'priority";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\' style=\'text-align:right\'  value=\"";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 =");\'  readonly></td> \n";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 =" width=\'12%\' ><input maxlength=\'40\' size=\'13\' type=text name=\'policy_type_desc";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\' id=\'policy_type_desc";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 =");\'  readonly>\n";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\n<a name=\'\' href=\"#\" onClick=\"callPolicyDetails(";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 =")\">(dtls)</a><!-- Karthik added the link to Display Policy Details 38144 MMS-QH-CRF-0082-->\n";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\t\n</td>\n<input type=\'hidden\' name=\'policy_type_code";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\' id=\'policy_type_code";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\" >\n<input type=\'hidden\' name=\'valid_policy_type_code_YN";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\' id=\'valid_policy_type_code_YN";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\" >\n<input type=\'hidden\' name=\'policy_suspended_YN";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\' id=\'policy_suspended_YN";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 =" width=\'12%\'><input type=\"text\" maxlength=\'30\' size=\"13\" name=\'policy_no";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\' id=\'policy_no";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\'   value=\"\" onFocus=\'check(";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 =");\'  readonly></td>\n<td class=";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 =" width=\'10%\' ><input type=\'text\'  name=\'policy_start_date";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\' id=\'policy_start_date";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\' size=\'10\' maxlength=\'10\' value=\'\'  onFocus=\'check(";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 =");\' readonly></td>\n<td class=";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 =" width=\'10%\'><input type=\'text\'  name=\'policy_exp_date";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\' id=\'policy_exp_date";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 =" width=\'12%\'><div id=\"credit_auth_val_disp";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\" style=";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 =" ><input type=\"text\" maxlength=\'20\' size=\"13\" name=\'credit_auth_ref";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\' id=\'credit_auth_ref";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\' value=\"\" onFocus=\'check(";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 =");\'  readonly></div></td>\n<td class=";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 =" width=\'11%\'><div id=\"credit_auth_date_val_disp";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 =" ><input type=\'text\'  name=\'credit_auth_date";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\' id=\'credit_auth_date";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\' size=\'10\' maxlength=\'10\' value=\'";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\' readonly></div></td>\n</tr>\n<tr id=row";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 =">\n<td class=";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 =" width=\'14%\'><b id=\"policy_coverage_basis_";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\"></b></td>\n<td class=";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 =" width=\'12%\'><div id=\"apprd_amt_leg_disp";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 =" >";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="</div></td>\n<td class=";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 =" width=\'7%\'><div id=\"apprd_amt_val_disp";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 =" ><input type=\"text\" maxlength=\'10\' size=\"7\" name=\'credit_apprd_amt";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\' id=\'credit_apprd_amt";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\' style=\'text-align:right\'  value=\'\' onFocus=\'check(";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 =");\'  readonly></div></td>\n<td  class=";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 =" width=\'12%\'><div id=\"apprd_days_leg_disp";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 =" width=\'12%\'><div id=\"apprd_days_val_disp";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 =" ><input type=\"text\" maxlength=\'4\' size=\"4\" name=\'credit_apprd_days";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\' id=\'credit_apprd_days";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 =" width=\'10%\' >";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="</td>\n<td class=";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 =" width=\'10%\'><input type=\'text\'  name=\'policy_eff_frm_date";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\' id=\'policy_eff_frm_date";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\' size=\'10\' maxlength=\'10\' value=\'\' readonly></td>\n<td class=";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 =" width=\'12%\' >";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 =" width=\'11%\'><input type=\'text\'  name=\'policy_eff_to_date";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\' id=\'policy_eff_to_date";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\' size=\'10\' maxlength=\'10\' value=\'\' readonly></td>\n</tr>\n<input type=\"hidden\" name=\"tmp_pol_eff_to";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\" id=\"tmp_pol_eff_to";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\" value=\"";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\"> <!-- Added By Vijay For MMS-QF-SCF-567 -->\n<input type=hidden name=\'adj_rule_ind";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\' id=\'adj_rule_ind";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\">\n<input type=hidden name=\'adj_perc_amt_ind";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\' id=\'adj_perc_amt_ind";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\">\n<input type=hidden name=\'adj_perc_amt_value";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\' id=\'adj_perc_amt_value";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\">\n<input type=hidden name=\'pmnt_diff_adj_int";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\' id=\'pmnt_diff_adj_int";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\">\n<input type=hidden name=\'drg_pmnt_diff_adj_int";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\' id=\'drg_pmnt_diff_adj_int";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\">\n<input type=hidden name=\'spl_srv_pmnt_diff_adj_int";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\' id=\'spl_srv_pmnt_diff_adj_int";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\">\n<input type=hidden name=\'restrict_check";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\' id=\'restrict_check";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\">\n<input type=hidden name=\'apprd_amt_restrict_check";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\' id=\'apprd_amt_restrict_check";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\'>\n<input type=hidden name=\'apprd_days_restrict_check";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\' id=\'apprd_days_restrict_check";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\'>\n<input type=hidden name=\'policy_coverage_basis_ind";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\' id=\'policy_coverage_basis_ind";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\">\n<input type=hidden name=\'cred_auth_req_yn";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="\' id=\'cred_auth_req_yn";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="\">\n<input type=hidden name=\'cred_auth_mand_capt_yn";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\' id=\'cred_auth_mand_capt_yn";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\">\n<input type=hidden name=\'dflt_auth_ref_as_pol_no_yn";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\' id=\'dflt_auth_ref_as_pol_no_yn";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\">\n<input type=hidden name=\'pol_validity_chk_date";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\' id=\'pol_validity_chk_date";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\">\n<input type=hidden name=\'rec_edited_YN";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\' id=\'rec_edited_YN";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="\' value=\"N\">\n<input type=hidden name=\'policy_eff_to_date_hdn\' id=\'policy_eff_to_date_hdn\' id=\'policy_eff_to_date_hdn\' value=\'";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="\'>\n<input type=hidden name=\'mcn_for_policy";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="\' id=\'mcn_for_policy";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\' value=\"\"> \n<input type=hidden name=\'reg_ref_id";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="\' id=\'reg_ref_id";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="\'   value=\"\">  <!--  V230315 -->\n\n<input type=hidden name=\"userId_for_priv";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="\" id=\"userId_for_priv";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="\" value=\"\" />  <!-- V230707 -->\n<input type=hidden name=\"reasonCode_for_priv";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="\" id=\"reasonCode_for_priv";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="\" value=\"\" />  <!-- V230707 -->\n\n";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="\n\t<input type=\"hidden\" name=\"totRec\" id=\"totRec\" id=\"totRec\" value=\"";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="\">\t\n\t";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

private String FinDtlsQueryFormation(String payerList,String facility_id,String billing_group,String p_patient_class){
	String sql_default = "";
		
	ArrayList<String> arPayerList=new ArrayList<String>();
	String queryFramed="";

	StringTokenizer stTilt=new StringTokenizer(payerList,"~");
	
	while(stTilt.hasMoreTokens()){
		arPayerList.add(stTilt.nextToken());
	}

	for(int pc=0;pc<arPayerList.size();pc++){	
		
		if(pc!=0)  queryFramed+=" OR "; 	
		
		StringTokenizer stPipe=new StringTokenizer(arPayerList.get(pc),"|");
		while(stPipe.hasMoreTokens()){
			queryFramed+= " (a.blng_grp_id = '"+stPipe.nextToken()+"'"+
	                      " AND a.cust_group_code = '"+stPipe.nextToken()+"'"+
	                      " AND a.cust_code = '"+stPipe.nextToken()+"'"+
	                      " AND a.policy_type_code = '"+stPipe.nextToken()+"'"+
	                      " ) ";
			if(stPipe.hasMoreTokens()){
				stPipe.nextToken();
			}
			
		}
	}	
	sql_default="SELECT DISTINCT a.cust_code cust_code, NULL cust_short_name, "+
            "a.policy_type_code policy_type_code, NULL policy_short_desc, "+
            "a.priority_no priority_no, a.adj_rule_ind adj_rule_ind, "+
            "a.adj_perc_amt_ind adj_perc_amt_ind, "+
            "a.adj_perc_amt_value adj_perc_amt_value, "+
            "a.pmnt_diff_adj_int pmnt_diff_adj_int, "+
            "a.drg_pmnt_diff_adj_int drg_pmnt_diff_adj_int, "+
            "a.spl_srv_pmnt_diff_adj_int spl_srv_pmnt_diff_adj_int, "+
            "a.cust_group_code cust_group_code, d.policy_coverage_basis, "+
            "NULL short_desc,e.INTERFACE_YN, D.POLICY_EFF_TO "+ //Added by shikha on 01-06-2020
       "FROM bl_payers_priority_by_bg a, "+
            "bl_ins_policy_types b, "+
            "ar_customer c, "+
            "bl_ins_policy_type_hdr d, "+
            "ar_cust_group e, "+
            "bl_cust_by_cust_group f "+
      "WHERE a.operating_facility_id = '"+facility_id+"' "+
        "AND a.blng_grp_id = '"+billing_group+"' "+
        "AND a.patient_class = '"+p_patient_class+"' "+
        "AND c.acc_entity_code = e.acc_entity_code "+
        "AND e.acc_entity_code = f.acc_entity_code "+
        "AND a.operating_facility_id = b.operating_facility_id "+
        "AND a.operating_facility_id = d.operating_facility_id "+
        "AND (a.cust_code = d.cust_code OR d.cust_code = '**') "+
        "AND (c.cust_code = a.cust_code OR a.cust_code = '**') "+
        "AND c.cust_code = f.cust_code "+
        "AND a.cust_group_code = f.cust_group_code "+
        "AND a.cust_group_code = d.cust_group_code "+
        "AND d.cust_group_code = e.cust_group_code "+
        "AND a.policy_type_code = b.policy_type_code "+
        "AND a.policy_type_code = d.policy_type_code "+
        "AND(  "+
        queryFramed +
        ")  ORDER BY a.priority_no ";
	
	return sql_default;
}


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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);

	int priority_count=0;
	String sql_default="";
	String autoFinChk="N";
	String blng_grp_values="", billing_group = "", class_code = "";
	JsonObject objFromBean = null;
	String str_currency_code_for_bg="", str_currency_desc_for_bg="";
	String payerGrpBySetup = "";
	String strChargeLogicYN = "";
	String p_patient_class = "";
	String DFLT_POLICY_DEF_IN_VIS_REG_YN=null;
	int totalRecords=0;
	String classval="";
	String strModuleId = "";
	String valid_payer_YN="";
	String valid_policy_type_code_YN="";
	String cust_valid_from_date = "" ,cust_valid_to_date = "";
	String payer_suspended_YN = "N", policy_suspended_YN = "N";
	String episode_type="";
	String v_display_hide="",v_display_hide_apprvd_amt="", v_display_hide_apprvd_days="";
	String cred_auth_req_yn="N",dflt_auth_ref_as_pol_no_yn="N",v_display_hide_cred_auth="";
	String restrict_check="", apprd_amt_restrict_check = "", apprd_days_restrict_check = "";
	String policy_coverage_basis_gbl_ind="";
	String cust_group_name = "";
	String rec_edited_YN="N", cred_auth_mand_capt_yn="N";
	String encounter_date_time = "", encounter_date_aft_trunc="", encounter_date="";
	String pol_validity_chk_date="";
	String rtn_ins_policy_eff_from_date="",rtn_ins_policy_eff_to_date="";
	
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
	
	AddModifyPatFinDetailsBean addModifyBean = new AddModifyPatFinDetailsBean();
	
	objFromBean = addModifyBean.getDfltPlcyAndPyrGrpSetup(con, facility_id);
	DFLT_POLICY_DEF_IN_VIS_REG_YN = objFromBean.get("dfltPolicyDefInVisRegnYn").getAsString();
	payerGrpBySetup = objFromBean.get("payerGrpBySetup").getAsString();
	strChargeLogicYN = objFromBean.get("strChargeLogicYN").getAsString();
	objFromBean = null;	
	

	
	billing_group = request.getParameter("billing_group") == null ? "" : request.getParameter("billing_group");
	p_patient_class = request.getParameter("p_patient_class") == null ? "" : request.getParameter("p_patient_class");
	class_code = request.getParameter("class_code") == null ? "" : request.getParameter("class_code");
	strModuleId = request.getParameter("strModuleId") == null ? "" : request.getParameter("strModuleId");
	episode_type = request.getParameter("episode_type") == null ? "" : request.getParameter("episode_type");
		objFromBean=addModifyBean.getblngGrpDesc(billing_group,locale,con);
		String blng_grp_long_desc=objFromBean.get("blng_grp_desc").getAsString();
		str_currency_code_for_bg=objFromBean.get("str_currency_code_for_bg").getAsString();
		str_currency_desc_for_bg=objFromBean.get("str_currency_desc_for_bg").getAsString();
		blng_grp_values=blng_grp_values+billing_group+"|";
	int i=0;

	if(autoFinChk.equals("Y"))
	{
		sql_default="SELECT DISTINCT a.cust_code cust_code,null cust_short_name,a.policy_type_code policy_type_code,null policy_short_desc,a.priority_no priority_no,a.adj_rule_ind adj_rule_ind,a.adj_perc_amt_ind adj_perc_amt_ind,a.adj_perc_amt_value adj_perc_amt_value,a.pmnt_diff_adj_int pmnt_diff_adj_int,a.drg_pmnt_diff_adj_int drg_pmnt_diff_adj_int,a.spl_srv_pmnt_diff_adj_int spl_srv_pmnt_diff_adj_int,a.cust_group_code cust_group_code,d.policy_coverage_basis,null short_desc,e.INTERFACE_YN,d.POLICY_EFF_TO effTo FROM bl_payers_priority_by_bg a, bl_ins_policy_types b,ar_customer c,bl_ins_policy_type_hdr d,ar_cust_group E,bl_cust_by_cust_group f,BL_APPL_BG_BY_CLASSFCTN g WHERE a.operating_facility_id ='"+facility_id+"' AND a.blng_grp_id ='"+billing_group+"' AND a.BLNG_GRP_ID = g.APPL_BLNG_GRP_ID AND a.patient_class ='"+p_patient_class+"' and c.ACC_ENTITY_CODE = e.ACC_ENTITY_CODE and e.ACC_ENTITY_CODE = f.ACC_ENTITY_CODE AND g.CLASSIFICATION_CODE='"+class_code+"' AND a.operating_facility_id = b.operating_facility_id AND a.operating_facility_id = d.operating_facility_id AND a.operating_facility_id = g.operating_facility_id AND (a.cust_code = d.cust_code OR d.cust_code='**') AND (c.cust_code = a.cust_code OR a.cust_code='**') AND c.cust_code=f.cust_code AND f.cust_code=g.APPL_CUST_CODE AND a.cust_group_code=f.cust_group_code AND a.cust_group_code=d.cust_group_code AND d.cust_group_code=e.cust_group_code AND d.cust_group_code=g.APPL_CUST_GROUP_CODE AND a.policy_type_code = b.policy_type_code AND a.policy_type_code = d.policy_type_code ORDER BY a.priority_no";	
	}
	else
	{
		sql_default="SELECT DISTINCT a.cust_code cust_code,null cust_short_name,a.policy_type_code policy_type_code,null policy_short_desc,a.priority_no priority_no,a.adj_rule_ind adj_rule_ind,a.adj_perc_amt_ind adj_perc_amt_ind,a.adj_perc_amt_value adj_perc_amt_value,a.pmnt_diff_adj_int pmnt_diff_adj_int,a.drg_pmnt_diff_adj_int drg_pmnt_diff_adj_int,a.spl_srv_pmnt_diff_adj_int spl_srv_pmnt_diff_adj_int,a.cust_group_code cust_group_code,d.policy_coverage_basis,null short_desc,e.INTERFACE_YN,d.POLICY_EFF_TO effTo FROM bl_payers_priority_by_bg a, bl_ins_policy_types b,ar_customer c,bl_ins_policy_type_hdr d,ar_cust_group E,bl_cust_by_cust_group f,bl_blng_grp g  WHERE a.operating_facility_id ='"+facility_id+"'  AND  g.blng_grp_id  = a.blng_grp_id AND g.DFLT_PAYER_DTLS_DURING_REGN_YN = 'Y' AND a.blng_grp_id ='"+billing_group+"' AND a.patient_class ='"+p_patient_class+"' and c.ACC_ENTITY_CODE = e.ACC_ENTITY_CODE and e.ACC_ENTITY_CODE = f.ACC_ENTITY_CODE AND a.operating_facility_id = b.operating_facility_id AND a.operating_facility_id = d.operating_facility_id AND (a.cust_code = d.cust_code OR d.cust_code='**') AND (c.cust_code = a.cust_code OR a.cust_code='**') AND c.cust_code=f.cust_code AND a.cust_group_code=f.cust_group_code AND a.cust_group_code=d.cust_group_code AND d.cust_group_code=e.cust_group_code AND a.policy_type_code = b.policy_type_code AND a.policy_type_code = d.policy_type_code and nvl(a.status,'E') = 'E'  ORDER BY a.priority_no";	
	}
		if(payerGrpBySetup.equalsIgnoreCase("Y")){		
			String payerList=(String)session.getAttribute("BL_PAYER_LIST_FROM_SETUP");
			session.setAttribute("BL_PAYER_LIST_FROM_SETUP",null);
			if(payerList != null){
				sql_default = FinDtlsQueryFormation(payerList,facility_id,billing_group,p_patient_class);
			}
		}
	pstmt = con.prepareStatement(sql_default);
	rs2 = pstmt.executeQuery() ;
	if( rs2 != null) 
	{
		while( rs2.next() )
		{  
			String payerEligibilityParam="9";
			String cust_code=rs2.getString(1);
			if(cust_code==null || cust_code.equals("")) cust_code="";
			String cust_short_name="";String policy_short_desc="";
			String policy_type_code=rs2.getString(3);
			if(policy_type_code==null || policy_type_code.equals("")) policy_type_code="";
			String priority_no=rs2.getString(5);
			if(priority_no==null || priority_no.equals("")) priority_no="";
			String cust_group_code=rs2.getString(12);
			if(cust_group_code==null || cust_group_code.equals("")) cust_group_code="";
			String policy_coverage_basis_ind=rs2.getString(13);
			if(policy_coverage_basis_ind==null || policy_coverage_basis_ind.equals("")) policy_coverage_basis_ind="";
			String adj_rule_ind=rs2.getString(6);
			if(adj_rule_ind==null || adj_rule_ind.equals("")) adj_rule_ind="";
			String adj_perc_amt_ind=rs2.getString(7);
			if(adj_perc_amt_ind==null || adj_perc_amt_ind.equals("")) adj_perc_amt_ind="";
			String adj_perc_amt_value=rs2.getString(8);
			if(adj_perc_amt_value==null || adj_perc_amt_value.equals("")) adj_perc_amt_value="";
			String pmnt_diff_adj_int=rs2.getString(9);
			if(pmnt_diff_adj_int==null || pmnt_diff_adj_int.equals("")) pmnt_diff_adj_int="";
			String drg_pmnt_diff_adj_int=rs2.getString(10);
			if(drg_pmnt_diff_adj_int==null || drg_pmnt_diff_adj_int.equals("")) drg_pmnt_diff_adj_int="";
			String spl_srv_pmnt_diff_adj_int=rs2.getString(11);
			if(spl_srv_pmnt_diff_adj_int==null || spl_srv_pmnt_diff_adj_int.equals("")) spl_srv_pmnt_diff_adj_int="";
			String interfaceYNcustgroup = rs2.getString(15);
			if(interfaceYNcustgroup==null || interfaceYNcustgroup.equals("")) interfaceYNcustgroup="";
			String polEfToDate=rs2.getString(16); 
			if(i==0)
			{
				policy_coverage_basis_gbl_ind=policy_coverage_basis_ind;
			}
			priority_count++;
			if(i % 2 == 0 )
			{
				classval	=	"QRYEVEN";
			}
			else
			{
				classval	=	"QRYODD";
			}
			String referral_source_capture_YN="N";
			String ref_src_main_mand_YN="N";
			String ref_src_sub_mand_YN="N";
			String ref_src_code_disp="";
			String ref_src_code_main_mand_disp ="";
			String ref_src_code_sub_mand_disp = "";
			objFromBean=addModifyBean.getRefSourceFlagsForP1(billing_group, con);
			referral_source_capture_YN= objFromBean.get("referral_source_code_flag").getAsString();
			ref_src_main_mand_YN = objFromBean.get("referral_source_main_mand_YN").getAsString();
			ref_src_sub_mand_YN = objFromBean.get("referral_source_sub_mand_YN").getAsString();
			objFromBean=addModifyBean.getCustDtls(cust_group_code,cust_code,locale,policy_type_code,con);
			cust_group_name=objFromBean.get("cust_group_name").getAsString();
			cust_short_name=objFromBean.get("cust_short_name").getAsString();
			policy_short_desc=objFromBean.get("policy_short_desc").getAsString();	
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

            _bw.write(_wl_block1Bytes, _wl_block1);

	if(i==0)
	{

            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(blng_grp_long_desc));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(ref_src_code_disp));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(ref_src_code_disp));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(ref_src_code_main_mand_disp));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(ref_src_code_disp));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(ref_src_code_disp));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(ref_src_code_sub_mand_disp));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block39Bytes, _wl_block39);

	}
	else
	{

            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(blng_grp_long_desc));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block48Bytes, _wl_block48);

	}
	String check_profileId="ELCPROF1";
	String profile_id_exists="N";
	String moduleIdCheck = InterfaceUtil.checkModuleIdForPayerEligibility(strModuleId);
    profile_id_exists = InterfaceUtil.isInterfaceProfileExisting(check_profileId);
	if("Y".equals(profile_id_exists) && "Y".equals(moduleIdCheck) )
	{ 
		if("Y".equals(interfaceYNcustgroup))
		{
		  payerEligibilityParam="0";
		}
		else
		{
          payerEligibilityParam="9";
		}
	}

            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(str_currency_code_for_bg));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(str_currency_desc_for_bg));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(billing_group));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(referral_source_capture_YN));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(ref_src_main_mand_YN));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(ref_src_sub_mand_YN));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(payerEligibilityParam));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(cust_group_name));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block94Bytes, _wl_block94);

	try
	{
		String empty_sql_check="N";
		String valid_payer_YN_sql="select DISTINCT 'Y',to_char(a.VALID_FROM,'dd/mm/yyyy') VALID_FROM,to_char(a.VALID_TO,'dd/mm/yyyy') VALID_TO,a.status status from ar_customer a, ar_cust_group b,sy_acc_entity c,bl_cust_by_cust_group e where a.acc_entity_code= b.acc_entity_code and a.acc_entity_code = c.acc_entity_code and a.patient_flag = 'Y' and NVL(a.pat_com_flag,'N') = 'N' and nvl(a.insurance_yn,'Y') = 'Y' and a.status is null and (('"+strModuleId+"' in ('OP','AE') and nvl(a.op_yn,'N') = 'Y') or ('"+strModuleId+"' in ('IP','DC') and nvl(a.ip_yn,'N') = 'Y') or ('"+strModuleId+"' = 'MP' and nvl(ref_yn,'N') = 'Y')) and a.cust_code = e.cust_code and b.cust_group_code = e.cust_group_code and a.CUST_CODE ='"+cust_code+"' and b.cust_group_code='"+cust_group_code+"'";
		pstmt = con.prepareStatement(valid_payer_YN_sql);
		rs=pstmt.executeQuery();
		if( rs != null ) 
		{	
			empty_sql_check="Y";
			valid_payer_YN="";
			while(rs.next())
			{
				empty_sql_check="N";
				valid_payer_YN=rs.getString(1);
				cust_valid_from_date = rs.getString(2);
				cust_valid_to_date = rs.getString(3);
				payer_suspended_YN = rs.getString(4);
			}
		}
		if(rs != null) rs.close();
		pstmt.close();
		if(payer_suspended_YN == null) payer_suspended_YN="";
	}
	catch(Exception e)
	{
		System.out.println("Exception in valid_payer_YN_sql:"+e);
			e.printStackTrace();
	}

	if(valid_payer_YN.equals("")) valid_payer_YN="N";
	if(cust_valid_from_date == null) cust_valid_from_date= "";
	if(cust_valid_to_date == null) cust_valid_to_date= "";
	if(cust_code.equals("**")) valid_payer_YN="Y";

            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(cust_short_name));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(cust_code));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(cust_group_code));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(valid_payer_YN));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(payer_suspended_YN));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(cust_valid_from_date));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(cust_valid_to_date));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(priority_no));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block114Bytes, _wl_block114);

//6/10/2008	String valid_policy_type_code_YN_sql="Select DISTINCT 'Y' from bl_ins_policy_types_lang_vw a, bl_ins_policy_type_hdr b, ar_customer c where a.language_id='"+locale+"' and  a.operating_facility_id='"+facility_id+"' and nvl(a.status,'N') <> 'S' and a.operating_facility_id = b.operating_facility_id and a.policy_type_code = b.policy_type_code and b.cust_code='"+cust_code+"' and c.cust_group_code = b.cust_group_code and (b.cust_code=c.cust_code or b.cust_code = '**') and (('"+strModuleId+"' in ('OP','AE') and nvl(b.outpatient_cover,'N') = 'Y') or ('"+strModuleId+"' in ('IP','DC') and nvl(b.inpatient_covered,'N') = 'Y') or ('"+strModuleId+"' = 'MP' and nvl(b.external_covered,'N') = 'Y'))";
	objFromBean = addModifyBean.getvalidPolicyTypeCodeYN("N", strModuleId, cust_code, cust_group_code, policy_type_code, locale, facility_id, con);
	valid_policy_type_code_YN = objFromBean.get("valid_policy_type_code_YN").getAsString();
	policy_suspended_YN = objFromBean.get("policy_suspended_YN").getAsString();
	if(!(policy_type_code.equals("") && cust_code.equals("")))
	{
		String restrict_check_sql="SELECT DECODE('"+episode_type+"','O', NVL(a.OUTPATIENT_LIMIT_TYPE,'U'),'E', NVL(a.OUTPATIENT_LIMIT_TYPE,'U'),'I', NVL(a.INPATIENT_LIMIT_TYPE,'U'),'D',NVL(a.INPATIENT_LIMIT_TYPE,'U'),'R',NVL(a.EXTERNAL_LIMIT_TYPE,'U'),'U'), DECODE('"+episode_type+"','O', NVL(a.OP_APPROVED_AMT_LIMIT_TYPE,'U'),'E', NVL(a.OP_APPROVED_AMT_LIMIT_TYPE,'U'),'I', NVL(a.IP_APPROVED_AMT_LIMIT_TYPE,'U'),'D',NVL(a.IP_APPROVED_AMT_LIMIT_TYPE,'U'),'R',NVL(a.EX_APPROVED_AMT_LIMIT_TYPE, 'U'),'U'),DECODE('"+episode_type+"','O', NVL(a.OP_APPROVED_DAYS_LIMIT_TYPE, 'U'),'E', NVL(a.OP_APPROVED_DAYS_LIMIT_TYPE, 'U'),'I', NVL(a.IP_APPROVED_DAYS_LIMIT_TYPE, 'U'),'D',NVL(a.IP_APPROVED_DAYS_LIMIT_TYPE, 'U'),'R',NVL(a.EX_APPROVED_DAYS_LIMIT_TYPE,  'U'),'U'),decode('"+episode_type+"','O',NVL(a.OP_CRED_AUTH_REQ_YN, 'N'),'E',NVL(a.OP_CRED_AUTH_REQ_YN,'N'),'I',NVL(a.IP_CRED_AUTH_REQ_YN, 'N'),'D',NVL(a.IP_CRED_AUTH_REQ_YN,'N'),'R',NVL(a.EX_CRED_AUTH_REQ_YN,'N'),'N'),decode('"+episode_type+"','O',NVL(a.OP_DFLT_AUTH_REF_AS_POL_NO_YN, 'N'),'E',NVL(a.OP_DFLT_AUTH_REF_AS_POL_NO_YN,'N'),'I',NVL(a.IP_DFLT_AUTH_REF_AS_POL_NO_YN, 'N'),'D',NVL(a.IP_DFLT_AUTH_REF_AS_POL_NO_YN,'N'),'R',NVL(a.EX_DFLT_AUTH_REF_AS_POL_NO_YN,'N'),'N'),decode('"+episode_type+"','O',NVL(a.OP_CRED_AUTH_MAND_TO_CAPT_YN, 'N'),'E',NVL(a.OP_CRED_AUTH_MAND_TO_CAPT_YN,'N'),'I',NVL(a.IP_CRED_AUTH_MAND_TO_CAPT_YN, 'N'),'D',NVL(a.IP_CRED_AUTH_MAND_TO_CAPT_YN,'N'),'R',NVL(a.EX_CRED_AUTH_MAND_TO_CAPT_YN,'N'),'N') FROM BL_INS_POLICY_TYPE_HDR a, BL_CUST_BY_CUST_GROUP b WHERE a.OPERATING_FACILITY_ID = '"+facility_id+"' AND a.POLICY_TYPE_CODE = '"+policy_type_code+"' AND a.CUST_CODE = '"+cust_code+"' and b.cust_group_code = a.cust_group_code and a.cust_code = b.cust_code and a.cust_group_code='"+cust_group_code+"'";
		String empty_sql_check="N";
		v_display_hide="";
		v_display_hide_apprvd_amt="";
		v_display_hide_apprvd_days="";
		cred_auth_req_yn = "N";
		cred_auth_mand_capt_yn = "N";
		dflt_auth_ref_as_pol_no_yn = "N";
		pstmt = con.prepareStatement(restrict_check_sql);
		rs=pstmt.executeQuery();
		if( rs != null ) 
		{
			empty_sql_check="Y";
			while(rs.next())
			{
				restrict_check=rs.getString(1);
				apprd_amt_restrict_check = rs.getString(2); 
				apprd_days_restrict_check = rs.getString(3);
				cred_auth_req_yn = rs.getString(4); 
				dflt_auth_ref_as_pol_no_yn = rs.getString(5); 
				cred_auth_mand_capt_yn = rs.getString(6); 
				empty_sql_check="N";
			}
		}
		if(rs != null) rs.close();
		pstmt.close();
		if(empty_sql_check.equals("Y"))
		{
			restrict_check="";
			apprd_amt_restrict_check ="";
			apprd_days_restrict_check ="";
			restrict_check_sql="SELECT DECODE('"+episode_type+"','O', NVL(a.OUTPATIENT_LIMIT_TYPE,'U'),'E', NVL(a.OUTPATIENT_LIMIT_TYPE,'U'),'I', NVL(a.INPATIENT_LIMIT_TYPE,'U'),'D',NVL(a.INPATIENT_LIMIT_TYPE,'U'),'R',NVL(a.EXTERNAL_LIMIT_TYPE,'U'),'U'), DECODE('"+episode_type+"','O', NVL(a.OP_APPROVED_AMT_LIMIT_TYPE,'U'),'E', NVL(a.OP_APPROVED_AMT_LIMIT_TYPE,'U'),'I', NVL(a.IP_APPROVED_AMT_LIMIT_TYPE,'U'),'D',NVL(a.IP_APPROVED_AMT_LIMIT_TYPE,'U'),'R',NVL(a.EX_APPROVED_AMT_LIMIT_TYPE, 'U'),'U'),DECODE('"+episode_type+"','O', NVL(a.OP_APPROVED_DAYS_LIMIT_TYPE, 'U'),'E', NVL(a.OP_APPROVED_DAYS_LIMIT_TYPE, 'U'),'I', NVL(a.IP_APPROVED_DAYS_LIMIT_TYPE, 'U'),'D',NVL(a.IP_APPROVED_DAYS_LIMIT_TYPE, 'U'),'R',NVL(a.EX_APPROVED_DAYS_LIMIT_TYPE,  'U'),'U'),decode('"+episode_type+"','O',NVL(a.OP_CRED_AUTH_REQ_YN, 'N'),'E',NVL(a.OP_CRED_AUTH_REQ_YN,'N'),'I',NVL(a.IP_CRED_AUTH_REQ_YN, 'N'),'D',NVL(a.IP_CRED_AUTH_REQ_YN,'N'),'R',NVL(a.EX_CRED_AUTH_REQ_YN,'N'),'N'),decode('"+episode_type+"','O',NVL(a.OP_DFLT_AUTH_REF_AS_POL_NO_YN, 'N'),'E',NVL(a.OP_DFLT_AUTH_REF_AS_POL_NO_YN,'N'),'I',NVL(a.IP_DFLT_AUTH_REF_AS_POL_NO_YN, 'N'),'D',NVL(a.IP_DFLT_AUTH_REF_AS_POL_NO_YN,'N'),'R',NVL(a.EX_DFLT_AUTH_REF_AS_POL_NO_YN,'N'),'N'),decode('"+episode_type+"','O',NVL(a.OP_CRED_AUTH_MAND_TO_CAPT_YN, 'N'),'E',NVL(a.OP_CRED_AUTH_MAND_TO_CAPT_YN,'N'),'I',NVL(a.IP_CRED_AUTH_MAND_TO_CAPT_YN, 'N'),'D',NVL(a.IP_CRED_AUTH_MAND_TO_CAPT_YN,'N'),'R',NVL(a.EX_CRED_AUTH_MAND_TO_CAPT_YN,'N'),'N') FROM BL_INS_POLICY_TYPE_HDR a WHERE a.OPERATING_FACILITY_ID = '"+facility_id+"' AND a.POLICY_TYPE_CODE = '"+policy_type_code+"' AND a.CUST_CODE = '**' and a.cust_group_code='"+cust_group_code+"'";
			pstmt = con.prepareStatement(restrict_check_sql);
			rs=pstmt.executeQuery();
			if( rs != null ) 
			{
				while(rs.next())
				{
					restrict_check=rs.getString(1);
					apprd_amt_restrict_check = rs.getString(2); 
					apprd_days_restrict_check = rs.getString(3);
					cred_auth_req_yn = rs.getString(4); 
					dflt_auth_ref_as_pol_no_yn = rs.getString(5); 
					cred_auth_mand_capt_yn = rs.getString(6); 
				}
			}
			if(rs != null) rs.close();
			pstmt.close();
		}
	}	
	if(restrict_check==null || restrict_check.equals("")) restrict_check="U";
	if(apprd_amt_restrict_check==null || apprd_amt_restrict_check.equals("")) apprd_amt_restrict_check="U";
	if(apprd_days_restrict_check==null || apprd_days_restrict_check.equals("")) apprd_days_restrict_check="U";			
	if(cred_auth_req_yn==null || cred_auth_req_yn.equals("")) cred_auth_req_yn="N";
	if(cred_auth_mand_capt_yn == null || cred_auth_mand_capt_yn.equals("")) cred_auth_mand_capt_yn="N";
	if(dflt_auth_ref_as_pol_no_yn==null || dflt_auth_ref_as_pol_no_yn.equals("")) dflt_auth_ref_as_pol_no_yn="N";
	if(restrict_check.equals("U"))
	{
		v_display_hide="display:none";
		v_display_hide_apprvd_amt="display:none";
		v_display_hide_apprvd_days = "display:none";
	}
	else if (restrict_check.equals("R"))
	{
		if(apprd_amt_restrict_check.equals("U"))
		{
			v_display_hide_apprvd_amt="display:none";
		}
		if(apprd_days_restrict_check.equals("U"))
		{
			v_display_hide_apprvd_days = "display:none";
		}
	}
	if(cred_auth_req_yn.equals("Y"))
	{
		if(cred_auth_mand_capt_yn.equals("Y"))
		{
			encounter_date = encounter_date_aft_trunc;
		}
		else
		{
			encounter_date = "";
		}
		v_display_hide_cred_auth = "display:inline";
	}
	else
	{
		encounter_date = "";
		v_display_hide_cred_auth = "display:none";
	}
	if(!encounter_date.equals(""))
	{
		if(!locale.equals("en"))
		{
			encounter_date=com.ehis.util.DateUtils.convertDate(encounter_date,"DMY","en",locale);
		}
	}

            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(policy_short_desc));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block117Bytes, _wl_block117);
 if( "Y".equals(strChargeLogicYN)) { 
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block119Bytes, _wl_block119);
}
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(policy_type_code));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(valid_policy_type_code_YN));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(policy_suspended_YN));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(v_display_hide_cred_auth));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(v_display_hide_cred_auth));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(encounter_date));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(v_display_hide_apprvd_amt));
            _bw.write(_wl_block151Bytes, _wl_block151);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(v_display_hide_apprvd_amt));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(v_display_hide_apprvd_days));
            _bw.write(_wl_block151Bytes, _wl_block151);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(v_display_hide_apprvd_days));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block162Bytes, _wl_block162);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block167Bytes, _wl_block167);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(totalRecords ));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(totalRecords ));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(totalRecords ));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(polEfToDate));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(adj_rule_ind));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(adj_perc_amt_ind));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(adj_perc_amt_value));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(pmnt_diff_adj_int));
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(drg_pmnt_diff_adj_int));
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(spl_srv_pmnt_diff_adj_int));
            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(restrict_check));
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(apprd_amt_restrict_check));
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(apprd_days_restrict_check));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(policy_coverage_basis_ind));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(cred_auth_req_yn));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(cred_auth_mand_capt_yn));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(dflt_auth_ref_as_pol_no_yn));
            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(pol_validity_chk_date));
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(rtn_ins_policy_eff_to_date ));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block206Bytes, _wl_block206);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block210Bytes, _wl_block210);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block211Bytes, _wl_block211);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block212Bytes, _wl_block212);

		i++;
	    totalRecords++;
	}
	}
	
            _bw.write(_wl_block213Bytes, _wl_block213);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block214Bytes, _wl_block214);

		if(rs2 != null) rs2.close();
		pstmt.close();
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

            _bw.write(_wl_block1Bytes, _wl_block1);
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
}
